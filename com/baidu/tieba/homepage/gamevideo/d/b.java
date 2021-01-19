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
    private a jXQ;
    private int jXS;
    private DataRes.Builder jXV;
    private TbPageContext mPageContext;
    private boolean iTr = true;
    private boolean jXU = false;
    private com.baidu.adp.framework.listener.a jXW = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GAME_VIDEO, 309646) { // from class: com.baidu.tieba.homepage.gamevideo.d.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            DataRes dataRes;
            int i;
            b.this.isLoading = false;
            if (responsedMessage == null) {
                b.this.iTr = false;
                if (b.this.jXQ != null) {
                    b.this.jXQ.n(-1, "", b.this.isLoadMore);
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
                b.this.jXU = dataRes.need_rechoose.intValue() == 1;
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
            if (b.this.jXQ != null) {
                if (responsedMessage.getError() == 0) {
                    b.this.jXQ.f(i, b.this.isLoadMore, false);
                } else {
                    b.this.jXQ.n(responsedMessage.getError(), responsedMessage.getErrorString(), b.this.isLoadMore);
                }
            }
            b.this.iTr = false;
        }
    };
    private List<n> mDataList = new LinkedList();
    private List<ThreadInfo> jXR = new LinkedList();
    private List<com.baidu.tieba.homepage.gamevideo.c.a> jXT = new LinkedList();

    /* loaded from: classes2.dex */
    public interface a {
        void f(int i, boolean z, boolean z2);

        void n(int i, String str, boolean z);
    }

    public b(TbPageContext tbPageContext, a aVar) {
        this.mPageContext = tbPageContext;
        this.jXQ = aVar;
    }

    public void registerListener() {
        MessageManager.getInstance().registerListener(this.jXW);
    }

    public void reset() {
        this.iTr = true;
        this.mDataList.clear();
        this.jXR.clear();
    }

    public void BB(int i) {
        int i2;
        if (!this.isLoading) {
            this.jXS = i;
            this.isLoading = true;
            this.isLoadMore = false;
            if (this.iTr) {
                bkL();
                this.iTr = false;
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

    public void BC(int i) {
        int i2 = 1;
        if (!this.isLoading) {
            this.jXS = i;
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

    public void Km(String str) {
        if (!x.isEmpty(this.mDataList)) {
            Iterator<n> it = this.mDataList.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if (next instanceof com.baidu.tieba.card.data.b) {
                    com.baidu.tieba.card.data.b bVar = (com.baidu.tieba.card.data.b) next;
                    if (bVar.bkV() != null && bVar.bkV().getTid() != null && bVar.bkV().getTid().equals(str)) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void Ll(String str) {
        if (this.jXV != null && !x.isEmpty(this.jXV.thread_list)) {
            long j = com.baidu.adp.lib.f.b.toLong(str, 0L);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.jXV.thread_list.size()) {
                    ThreadInfo threadInfo = this.jXV.thread_list.get(i2);
                    if (threadInfo == null || threadInfo.tid == null || threadInfo.tid.longValue() != j) {
                        i = i2 + 1;
                    } else {
                        this.jXV.thread_list.remove(i2);
                        a(this.jXV);
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public List<com.baidu.tieba.homepage.gamevideo.c.a> cOq() {
        return this.jXT;
    }

    public boolean cOr() {
        return this.jXU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dX(List<SubClassItem> list) {
        if (!x.isEmpty(list)) {
            if (this.jXT == null) {
                this.jXT = new LinkedList();
            }
            this.jXT.clear();
            for (SubClassItem subClassItem : list) {
                com.baidu.tieba.homepage.gamevideo.c.a aVar = new com.baidu.tieba.homepage.gamevideo.c.a();
                aVar.a(subClassItem);
                this.jXT.add(aVar);
            }
        }
    }

    private void r(List<ThreadInfo> list, boolean z) {
        if (!x.isEmpty(list)) {
            if (z) {
                LinkedList linkedList = new LinkedList();
                linkedList.addAll(list);
                linkedList.addAll(this.jXR);
                this.jXR.clear();
                this.jXR.addAll(linkedList);
                return;
            }
            this.jXR.addAll(list);
        }
    }

    private List<n> cOs() {
        LinkedList linkedList = new LinkedList();
        if (x.isEmpty(this.jXR)) {
            return linkedList;
        }
        int i = 0;
        Iterator<ThreadInfo> it = this.jXR.iterator();
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
                kVar.eHK = bzVar;
                kVar.ivm = true;
                kVar.tid = bzVar.getTid();
                kVar.position = i2;
                kVar.eNF = true;
                linkedList.add(kVar);
                l lVar = new l(bzVar);
                lVar.tid = bzVar.getTid();
                lVar.position = i2;
                lVar.iuA = true;
                linkedList.add(lVar);
                if (next.top_agree_post != null) {
                    k kVar2 = new k();
                    kVar2.eHK = bzVar;
                    kVar2.ivm = true;
                    kVar2.tid = bzVar.getTid();
                    kVar2.position = i2;
                    kVar2.eNM = true;
                    linkedList.add(kVar2);
                }
                k kVar3 = new k();
                kVar3.eHK = bzVar;
                kVar3.ivm = true;
                kVar3.tid = bzVar.getTid();
                kVar3.position = i2;
                kVar3.eNL = true;
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
        if (x.getCount(this.jXR) >= 12) {
            if (this.isLoadMore) {
                builder.thread_list = this.jXR.subList(this.jXR.size() - 12, this.jXR.size());
            } else {
                builder.thread_list = this.jXR.subList(0, 12);
            }
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.jXR);
            builder.thread_list = arrayList;
        }
        this.jXV = builder;
        a(builder);
    }

    private void bkL() {
        ac.a(new ab<DataRes>() { // from class: com.baidu.tieba.homepage.gamevideo.d.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ab
            /* renamed from: cOt */
            public DataRes doInBackground() {
                com.baidu.adp.lib.cache.l<byte[]> dK = com.baidu.tbadk.core.c.a.bpZ().dK("tb.game_video", TbadkCoreApplication.getCurrentAccount());
                if (dK == null) {
                    return null;
                }
                byte[] bArr = dK.get(String.valueOf(b.this.jXS));
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
                    b.this.jXV = new DataRes.Builder(dataRes);
                    int count = x.getCount(dataRes.thread_list);
                    if (count > 0) {
                        b.this.b(dataRes);
                        b.this.dX(dataRes.class_info.sub_class_list);
                        if (b.this.jXQ != null) {
                            b.this.jXQ.f(count, false, true);
                        }
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(DataRes dataRes) {
        r(dataRes.thread_list, !this.isLoadMore);
        this.mDataList = cOs();
        com.baidu.tieba.homepage.gamevideo.d.a.a(dataRes, this.mDataList);
    }

    private void a(final DataRes.Builder builder) {
        ac.a(new ab<Object>() { // from class: com.baidu.tieba.homepage.gamevideo.d.b.4
            @Override // com.baidu.tbadk.util.ab
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                try {
                    com.baidu.tbadk.core.c.a.bpZ().dK("tb.game_video", TbadkCoreApplication.getCurrentAccount()).setForever(String.valueOf(b.this.jXS), builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.jXW);
    }
}
