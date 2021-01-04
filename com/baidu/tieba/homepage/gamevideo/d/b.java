package com.baidu.tieba.homepage.gamevideo.d;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.util.ac;
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
/* loaded from: classes2.dex */
public class b {
    private boolean isLoadMore;
    private boolean isLoading;
    private DataRes.Builder kcA;
    private a kcv;
    private int kcx;
    private TbPageContext mPageContext;
    private boolean iXY = true;
    private boolean kcz = false;
    private com.baidu.adp.framework.listener.a kcB = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GAME_VIDEO, 309646) { // from class: com.baidu.tieba.homepage.gamevideo.d.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            DataRes dataRes;
            int i;
            b.this.isLoading = false;
            if (responsedMessage == null) {
                b.this.iXY = false;
                if (b.this.kcv != null) {
                    b.this.kcv.n(-1, "", b.this.isLoadMore);
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
            if (dataRes != null && dataRes.class_info != null && !x.isEmpty(dataRes.class_info.sub_class_list)) {
                b.this.dX(dataRes.class_info.sub_class_list);
                b.this.kcz = dataRes.need_rechoose.intValue() == 1;
            }
            if (dataRes == null || x.getCount(dataRes.thread_list) <= 0) {
                i = 0;
            } else {
                i = x.getCount(dataRes.thread_list);
                b.this.b(dataRes);
                if (!x.isEmpty(dataRes.thread_list)) {
                    b.this.a(dataRes);
                }
            }
            if (b.this.kcv != null) {
                if (responsedMessage.getError() == 0) {
                    b.this.kcv.f(i, b.this.isLoadMore, false);
                } else {
                    b.this.kcv.n(responsedMessage.getError(), responsedMessage.getErrorString(), b.this.isLoadMore);
                }
            }
            b.this.iXY = false;
        }
    };
    private List<n> mDataList = new LinkedList();
    private List<ThreadInfo> kcw = new LinkedList();
    private List<com.baidu.tieba.homepage.gamevideo.c.a> kcy = new LinkedList();

    /* loaded from: classes2.dex */
    public interface a {
        void f(int i, boolean z, boolean z2);

        void n(int i, String str, boolean z);
    }

    public b(TbPageContext tbPageContext, a aVar) {
        this.mPageContext = tbPageContext;
        this.kcv = aVar;
    }

    public void registerListener() {
        MessageManager.getInstance().registerListener(this.kcB);
    }

    public void reset() {
        this.iXY = true;
        this.mDataList.clear();
        this.kcw.clear();
    }

    public void Di(int i) {
        int i2;
        if (!this.isLoading) {
            this.kcx = i;
            this.isLoading = true;
            this.isLoadMore = false;
            if (this.iXY) {
                boE();
                this.iXY = false;
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

    public void Dj(int i) {
        int i2 = 1;
        if (!this.isLoading) {
            this.kcx = i;
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

    public List<n> getDataList() {
        return this.mDataList;
    }

    public void Lx(String str) {
        if (!x.isEmpty(this.mDataList)) {
            Iterator<n> it = this.mDataList.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if (next instanceof com.baidu.tieba.card.data.b) {
                    com.baidu.tieba.card.data.b bVar = (com.baidu.tieba.card.data.b) next;
                    if (bVar.boO() != null && bVar.boO().getTid() != null && bVar.boO().getTid().equals(str)) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void Mt(String str) {
        if (this.kcA != null && !x.isEmpty(this.kcA.thread_list)) {
            long j = com.baidu.adp.lib.f.b.toLong(str, 0L);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.kcA.thread_list.size()) {
                    ThreadInfo threadInfo = this.kcA.thread_list.get(i2);
                    if (threadInfo == null || threadInfo.tid == null || threadInfo.tid.longValue() != j) {
                        i = i2 + 1;
                    } else {
                        this.kcA.thread_list.remove(i2);
                        a(this.kcA);
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public List<com.baidu.tieba.homepage.gamevideo.c.a> cSh() {
        return this.kcy;
    }

    public boolean cSi() {
        return this.kcz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dX(List<SubClassItem> list) {
        if (!x.isEmpty(list)) {
            if (this.kcy == null) {
                this.kcy = new LinkedList();
            }
            this.kcy.clear();
            for (SubClassItem subClassItem : list) {
                com.baidu.tieba.homepage.gamevideo.c.a aVar = new com.baidu.tieba.homepage.gamevideo.c.a();
                aVar.a(subClassItem);
                this.kcy.add(aVar);
            }
        }
    }

    private void r(List<ThreadInfo> list, boolean z) {
        if (!x.isEmpty(list)) {
            if (z) {
                LinkedList linkedList = new LinkedList();
                linkedList.addAll(list);
                linkedList.addAll(this.kcw);
                this.kcw.clear();
                this.kcw.addAll(linkedList);
                return;
            }
            this.kcw.addAll(list);
        }
    }

    private List<n> cSj() {
        LinkedList linkedList = new LinkedList();
        if (x.isEmpty(this.kcw)) {
            return linkedList;
        }
        int i = 0;
        Iterator<ThreadInfo> it = this.kcw.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return linkedList;
            }
            ThreadInfo next = it.next();
            bz bzVar = new bz();
            bzVar.a(next);
            if (l.ad(bzVar)) {
                k kVar = new k();
                kVar.eMv = bzVar;
                kVar.izT = true;
                kVar.tid = bzVar.getTid();
                kVar.position = i2;
                kVar.eSq = true;
                linkedList.add(kVar);
                l lVar = new l(bzVar);
                lVar.tid = bzVar.getTid();
                lVar.position = i2;
                lVar.izh = true;
                linkedList.add(lVar);
                if (next.top_agree_post != null) {
                    k kVar2 = new k();
                    kVar2.eMv = bzVar;
                    kVar2.izT = true;
                    kVar2.tid = bzVar.getTid();
                    kVar2.position = i2;
                    kVar2.eSx = true;
                    linkedList.add(kVar2);
                }
                k kVar3 = new k();
                kVar3.eMv = bzVar;
                kVar3.izT = true;
                kVar3.tid = bzVar.getTid();
                kVar3.position = i2;
                kVar3.eSw = true;
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
        if (x.getCount(this.kcw) >= 12) {
            if (this.isLoadMore) {
                builder.thread_list = this.kcw.subList(this.kcw.size() - 12, this.kcw.size());
            } else {
                builder.thread_list = this.kcw.subList(0, 12);
            }
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.kcw);
            builder.thread_list = arrayList;
        }
        this.kcA = builder;
        a(builder);
    }

    private void boE() {
        ac.a(new ab<DataRes>() { // from class: com.baidu.tieba.homepage.gamevideo.d.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ab
            /* renamed from: cSk */
            public DataRes doInBackground() {
                com.baidu.adp.lib.cache.l<byte[]> dL = com.baidu.tbadk.core.c.a.btS().dL("tb.game_video", TbadkCoreApplication.getCurrentAccount());
                if (dL == null) {
                    return null;
                }
                byte[] bArr = dL.get(String.valueOf(b.this.kcx));
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
        }, new com.baidu.tbadk.util.l<DataRes>() { // from class: com.baidu.tieba.homepage.gamevideo.d.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            /* renamed from: c */
            public void onReturnDataInUI(DataRes dataRes) {
                if (dataRes != null) {
                    b.this.kcA = new DataRes.Builder(dataRes);
                    int count = x.getCount(dataRes.thread_list);
                    if (count > 0) {
                        b.this.b(dataRes);
                        b.this.dX(dataRes.class_info.sub_class_list);
                        if (b.this.kcv != null) {
                            b.this.kcv.f(count, false, true);
                        }
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(DataRes dataRes) {
        r(dataRes.thread_list, !this.isLoadMore);
        this.mDataList = cSj();
        com.baidu.tieba.homepage.gamevideo.d.a.a(dataRes, this.mDataList);
    }

    private void a(final DataRes.Builder builder) {
        ac.a(new ab<Object>() { // from class: com.baidu.tieba.homepage.gamevideo.d.b.4
            @Override // com.baidu.tbadk.util.ab
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                try {
                    com.baidu.tbadk.core.c.a.btS().dL("tb.game_video", TbadkCoreApplication.getCurrentAccount()).setForever(String.valueOf(b.this.kcx), builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.kcB);
    }
}
