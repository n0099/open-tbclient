package com.baidu.tieba.homepage.gamevideo.d;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.m;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.homepage.gamevideo.message.GameVideoHttpResMessage;
import com.baidu.tieba.homepage.gamevideo.message.GameVideoRequestMessage;
import com.baidu.tieba.homepage.gamevideo.message.GameVideoSocketResMessage;
import com.squareup.wire.Wire;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.RecomVertical.DataRes;
import tbclient.RecomVertical.SubClassItem;
import tbclient.ThreadInfo;
/* loaded from: classes22.dex */
public class b {
    private boolean isLoadMore;
    private boolean isLoading;
    private a jPh;
    private int jPj;
    private DataRes.Builder jPm;
    private TbPageContext mPageContext;
    private boolean iLN = true;
    private boolean jPl = false;
    private com.baidu.adp.framework.listener.a jPn = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GAME_VIDEO, 309646) { // from class: com.baidu.tieba.homepage.gamevideo.d.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            DataRes dataRes;
            int i;
            b.this.isLoading = false;
            if (responsedMessage == null) {
                b.this.iLN = false;
                if (b.this.jPh != null) {
                    b.this.jPh.n(-1, "", b.this.isLoadMore);
                    return;
                }
                return;
            }
            if (responsedMessage instanceof GameVideoSocketResMessage) {
                dataRes = ((GameVideoSocketResMessage) responsedMessage).mResultData;
            } else if (!(responsedMessage instanceof GameVideoHttpResMessage)) {
                dataRes = null;
            } else {
                dataRes = ((GameVideoHttpResMessage) responsedMessage).mResultData;
            }
            if (dataRes != null && dataRes.class_info != null && !y.isEmpty(dataRes.class_info.sub_class_list)) {
                b.this.dP(dataRes.class_info.sub_class_list);
                b.this.jPl = dataRes.need_rechoose.intValue() == 1;
            }
            if (dataRes == null || y.getCount(dataRes.thread_list) <= 0) {
                i = 0;
            } else {
                i = y.getCount(dataRes.thread_list);
                b.this.b(dataRes);
                if (!y.isEmpty(dataRes.thread_list)) {
                    b.this.a(dataRes);
                }
            }
            if (b.this.jPh != null) {
                if (responsedMessage.getError() == 0) {
                    b.this.jPh.f(i, b.this.isLoadMore, false);
                } else {
                    b.this.jPh.n(responsedMessage.getError(), responsedMessage.getErrorString(), b.this.isLoadMore);
                }
            }
            b.this.iLN = false;
        }
    };
    private List<q> mDataList = new LinkedList();
    private List<ThreadInfo> jPi = new LinkedList();
    private List<com.baidu.tieba.homepage.gamevideo.c.a> jPk = new LinkedList();

    /* loaded from: classes22.dex */
    public interface a {
        void f(int i, boolean z, boolean z2);

        void n(int i, String str, boolean z);
    }

    public b(TbPageContext tbPageContext, a aVar) {
        this.mPageContext = tbPageContext;
        this.jPh = aVar;
    }

    public void registerListener() {
        MessageManager.getInstance().registerListener(this.jPn);
    }

    public void reset() {
        this.iLN = true;
        this.mDataList.clear();
        this.jPi.clear();
    }

    public void CU(int i) {
        int i2;
        if (!this.isLoading) {
            this.jPj = i;
            this.isLoading = true;
            this.isLoadMore = false;
            if (this.iLN) {
                bmf();
                this.iLN = false;
            }
            GameVideoRequestMessage gameVideoRequestMessage = new GameVideoRequestMessage();
            gameVideoRequestMessage.class_id = "1";
            gameVideoRequestMessage.sub_class_id = i;
            if (j.isWifiNet()) {
                i2 = 1;
            } else if (j.is4GNet()) {
                i2 = 4;
            } else if (j.is3GNet()) {
                i2 = 3;
            } else {
                i2 = j.is2GNet() ? 2 : 1;
            }
            gameVideoRequestMessage.new_net_type = i2;
            gameVideoRequestMessage.load_type = 1;
            gameVideoRequestMessage.page_thread_count = 12;
            gameVideoRequestMessage.setNetType(NetMessage.NetType.HTTP);
            this.mPageContext.sendMessage(gameVideoRequestMessage);
        }
    }

    public void CV(int i) {
        int i2 = 1;
        if (!this.isLoading) {
            this.jPj = i;
            this.isLoading = true;
            this.isLoadMore = true;
            GameVideoRequestMessage gameVideoRequestMessage = new GameVideoRequestMessage();
            gameVideoRequestMessage.class_id = "1";
            gameVideoRequestMessage.sub_class_id = i;
            if (!j.isWifiNet()) {
                if (j.is4GNet()) {
                    i2 = 4;
                } else if (j.is3GNet()) {
                    i2 = 3;
                } else if (j.is2GNet()) {
                    i2 = 2;
                }
            }
            gameVideoRequestMessage.new_net_type = i2;
            gameVideoRequestMessage.load_type = 2;
            gameVideoRequestMessage.page_thread_count = 12;
            gameVideoRequestMessage.setNetType(NetMessage.NetType.HTTP);
            this.mPageContext.sendMessage(gameVideoRequestMessage);
        }
    }

    public List<q> getDataList() {
        return this.mDataList;
    }

    public void Lx(String str) {
        if (!y.isEmpty(this.mDataList)) {
            Iterator<q> it = this.mDataList.iterator();
            while (it.hasNext()) {
                q next = it.next();
                if (next instanceof com.baidu.tieba.card.data.b) {
                    com.baidu.tieba.card.data.b bVar = (com.baidu.tieba.card.data.b) next;
                    if (bVar.bmn() != null && bVar.bmn().getTid() != null && bVar.bmn().getTid().equals(str)) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void Mt(String str) {
        if (this.jPm != null && !y.isEmpty(this.jPm.thread_list)) {
            long j = com.baidu.adp.lib.f.b.toLong(str, 0L);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.jPm.thread_list.size()) {
                    ThreadInfo threadInfo = this.jPm.thread_list.get(i2);
                    if (threadInfo == null || threadInfo.tid == null || threadInfo.tid.longValue() != j) {
                        i = i2 + 1;
                    } else {
                        this.jPm.thread_list.remove(i2);
                        a(this.jPm);
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public List<com.baidu.tieba.homepage.gamevideo.c.a> cPb() {
        return this.jPk;
    }

    public boolean cPc() {
        return this.jPl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dP(List<SubClassItem> list) {
        if (!y.isEmpty(list)) {
            if (this.jPk == null) {
                this.jPk = new LinkedList();
            }
            this.jPk.clear();
            for (SubClassItem subClassItem : list) {
                com.baidu.tieba.homepage.gamevideo.c.a aVar = new com.baidu.tieba.homepage.gamevideo.c.a();
                aVar.a(subClassItem);
                this.jPk.add(aVar);
            }
        }
    }

    private void q(List<ThreadInfo> list, boolean z) {
        if (!y.isEmpty(list)) {
            if (z) {
                LinkedList linkedList = new LinkedList();
                linkedList.addAll(list);
                linkedList.addAll(this.jPi);
                this.jPi.clear();
                this.jPi.addAll(linkedList);
                return;
            }
            this.jPi.addAll(list);
        }
    }

    private List<q> cPd() {
        LinkedList linkedList = new LinkedList();
        if (y.isEmpty(this.jPi)) {
            return linkedList;
        }
        int i = 0;
        Iterator<ThreadInfo> it = this.jPi.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return linkedList;
            }
            ThreadInfo next = it.next();
            by byVar = new by();
            byVar.a(next);
            if (l.ad(byVar)) {
                k kVar = new k();
                kVar.eCR = byVar;
                kVar.inz = true;
                kVar.tid = byVar.getTid();
                kVar.position = i2;
                kVar.eIy = true;
                linkedList.add(kVar);
                l lVar = new l(byVar);
                lVar.tid = byVar.getTid();
                lVar.position = i2;
                lVar.imM = true;
                linkedList.add(lVar);
                if (next.top_agree_post != null) {
                    k kVar2 = new k();
                    kVar2.eCR = byVar;
                    kVar2.inz = true;
                    kVar2.tid = byVar.getTid();
                    kVar2.position = i2;
                    kVar2.eIF = true;
                    linkedList.add(kVar2);
                }
                k kVar3 = new k();
                kVar3.eCR = byVar;
                kVar3.inz = true;
                kVar3.tid = byVar.getTid();
                kVar3.position = i2;
                kVar3.eIE = true;
                linkedList.add(kVar3);
                i = i2 + 1;
            } else {
                i = i2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        DataRes.Builder builder = new DataRes.Builder();
        builder.need_rechoose = dataRes.need_rechoose;
        builder.class_info = dataRes.class_info;
        builder.thread_personalized = dataRes.thread_personalized;
        if (y.getCount(this.jPi) >= 12) {
            if (this.isLoadMore) {
                builder.thread_list = this.jPi.subList(this.jPi.size() - 12, this.jPi.size());
            } else {
                builder.thread_list = this.jPi.subList(0, 12);
            }
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.jPi);
            builder.thread_list = arrayList;
        }
        this.jPm = builder;
        a(builder);
    }

    private void bmf() {
        ad.a(new ac<DataRes>() { // from class: com.baidu.tieba.homepage.gamevideo.d.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ac
            /* renamed from: cPe */
            public DataRes doInBackground() {
                com.baidu.adp.lib.cache.l<byte[]> dM = com.baidu.tbadk.core.c.a.brq().dM("tb.game_video", TbadkCoreApplication.getCurrentAccount());
                if (dM == null) {
                    return null;
                }
                byte[] bArr = dM.get(String.valueOf(b.this.jPj));
                if (bArr == null || bArr.length == 0) {
                    return null;
                }
                try {
                    return (DataRes) new Wire(new Class[0]).parseFrom(bArr, DataRes.class);
                } catch (IOException e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, new m<DataRes>() { // from class: com.baidu.tieba.homepage.gamevideo.d.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.m
            /* renamed from: c */
            public void onReturnDataInUI(DataRes dataRes) {
                if (dataRes != null) {
                    b.this.jPm = new DataRes.Builder(dataRes);
                    int count = y.getCount(dataRes.thread_list);
                    if (count > 0) {
                        b.this.b(dataRes);
                        b.this.dP(dataRes.class_info.sub_class_list);
                        if (b.this.jPh != null) {
                            b.this.jPh.f(count, false, true);
                        }
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(DataRes dataRes) {
        q(dataRes.thread_list, !this.isLoadMore);
        this.mDataList = cPd();
        com.baidu.tieba.homepage.gamevideo.d.a.a(dataRes, this.mDataList);
    }

    private void a(final DataRes.Builder builder) {
        ad.a(new ac<Object>() { // from class: com.baidu.tieba.homepage.gamevideo.d.b.4
            @Override // com.baidu.tbadk.util.ac
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                try {
                    com.baidu.tbadk.core.c.a.brq().dM("tb.game_video", TbadkCoreApplication.getCurrentAccount()).setForever(String.valueOf(b.this.jPj), builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.jPn);
    }
}
