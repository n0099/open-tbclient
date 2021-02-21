package com.baidu.tieba.homepage.gamevideo.d;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.util.af;
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
/* loaded from: classes2.dex */
public class b {
    private boolean isLoadMore;
    private boolean isLoading;
    private a kfG;
    private int kfI;
    private DataRes.Builder kfL;
    private TbPageContext mPageContext;
    private boolean iZm = true;
    private boolean kfK = false;
    private com.baidu.adp.framework.listener.a kfM = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GAME_VIDEO, 309646) { // from class: com.baidu.tieba.homepage.gamevideo.d.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            DataRes dataRes;
            int i;
            b.this.isLoading = false;
            if (responsedMessage == null) {
                b.this.iZm = false;
                if (b.this.kfG != null) {
                    b.this.kfG.m(-1, "", b.this.isLoadMore);
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
                b.this.dU(dataRes.class_info.sub_class_list);
                b.this.kfK = dataRes.need_rechoose.intValue() == 1;
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
            if (b.this.kfG != null) {
                if (responsedMessage.getError() == 0) {
                    b.this.kfG.f(i, b.this.isLoadMore, false);
                } else {
                    b.this.kfG.m(responsedMessage.getError(), responsedMessage.getErrorString(), b.this.isLoadMore);
                }
            }
            b.this.iZm = false;
        }
    };
    private List<n> mDataList = new LinkedList();
    private List<ThreadInfo> kfH = new LinkedList();
    private List<com.baidu.tieba.homepage.gamevideo.c.a> kfJ = new LinkedList();

    /* loaded from: classes2.dex */
    public interface a {
        void f(int i, boolean z, boolean z2);

        void m(int i, String str, boolean z);
    }

    public b(TbPageContext tbPageContext, a aVar) {
        this.mPageContext = tbPageContext;
        this.kfG = aVar;
    }

    public void registerListener() {
        MessageManager.getInstance().registerListener(this.kfM);
    }

    public void reset() {
        this.iZm = true;
        this.mDataList.clear();
        this.kfH.clear();
    }

    public void BR(int i) {
        int i2;
        if (!this.isLoading) {
            this.kfI = i;
            this.isLoading = true;
            this.isLoadMore = false;
            if (this.iZm) {
                bld();
                this.iZm = false;
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

    public void BS(int i) {
        int i2 = 1;
        if (!this.isLoading) {
            this.kfI = i;
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

    public void KY(String str) {
        if (!y.isEmpty(this.mDataList)) {
            Iterator<n> it = this.mDataList.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if (next instanceof com.baidu.tieba.card.data.b) {
                    com.baidu.tieba.card.data.b bVar = (com.baidu.tieba.card.data.b) next;
                    if (bVar.bln() != null && bVar.bln().getTid() != null && bVar.bln().getTid().equals(str)) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void LW(String str) {
        if (this.kfL != null && !y.isEmpty(this.kfL.thread_list)) {
            long j = com.baidu.adp.lib.f.b.toLong(str, 0L);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.kfL.thread_list.size()) {
                    ThreadInfo threadInfo = this.kfL.thread_list.get(i2);
                    if (threadInfo == null || threadInfo.tid == null || threadInfo.tid.longValue() != j) {
                        i = i2 + 1;
                    } else {
                        this.kfL.thread_list.remove(i2);
                        a(this.kfL);
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public List<com.baidu.tieba.homepage.gamevideo.c.a> cQu() {
        return this.kfJ;
    }

    public boolean cQv() {
        return this.kfK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dU(List<SubClassItem> list) {
        if (!y.isEmpty(list)) {
            if (this.kfJ == null) {
                this.kfJ = new LinkedList();
            }
            this.kfJ.clear();
            for (SubClassItem subClassItem : list) {
                com.baidu.tieba.homepage.gamevideo.c.a aVar = new com.baidu.tieba.homepage.gamevideo.c.a();
                aVar.a(subClassItem);
                this.kfJ.add(aVar);
            }
        }
    }

    private void s(List<ThreadInfo> list, boolean z) {
        if (!y.isEmpty(list)) {
            if (z) {
                LinkedList linkedList = new LinkedList();
                linkedList.addAll(list);
                linkedList.addAll(this.kfH);
                this.kfH.clear();
                this.kfH.addAll(linkedList);
                return;
            }
            this.kfH.addAll(list);
        }
    }

    private List<n> cQw() {
        LinkedList linkedList = new LinkedList();
        if (y.isEmpty(this.kfH)) {
            return linkedList;
        }
        int i = 0;
        Iterator<ThreadInfo> it = this.kfH.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return linkedList;
            }
            ThreadInfo next = it.next();
            cb cbVar = new cb();
            cbVar.a(next);
            if (l.ae(cbVar)) {
                k kVar = new k();
                kVar.eJQ = cbVar;
                kVar.iBk = true;
                kVar.tid = cbVar.getTid();
                kVar.position = i2;
                kVar.ePR = true;
                linkedList.add(kVar);
                l lVar = new l(cbVar);
                lVar.tid = cbVar.getTid();
                lVar.position = i2;
                lVar.iAy = true;
                linkedList.add(lVar);
                if (next.top_agree_post != null) {
                    k kVar2 = new k();
                    kVar2.eJQ = cbVar;
                    kVar2.iBk = true;
                    kVar2.tid = cbVar.getTid();
                    kVar2.position = i2;
                    kVar2.ePY = true;
                    linkedList.add(kVar2);
                }
                k kVar3 = new k();
                kVar3.eJQ = cbVar;
                kVar3.iBk = true;
                kVar3.tid = cbVar.getTid();
                kVar3.position = i2;
                kVar3.ePX = true;
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
        if (y.getCount(this.kfH) >= 12) {
            if (this.isLoadMore) {
                builder.thread_list = this.kfH.subList(this.kfH.size() - 12, this.kfH.size());
            } else {
                builder.thread_list = this.kfH.subList(0, 12);
            }
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.kfH);
            builder.thread_list = arrayList;
        }
        this.kfL = builder;
        a(builder);
    }

    private void bld() {
        af.a(new ae<DataRes>() { // from class: com.baidu.tieba.homepage.gamevideo.d.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ae
            /* renamed from: cQx */
            public DataRes doInBackground() {
                com.baidu.adp.lib.cache.l<byte[]> dE = com.baidu.tbadk.core.c.a.bqr().dE("tb.game_video", TbadkCoreApplication.getCurrentAccount());
                if (dE == null) {
                    return null;
                }
                byte[] bArr = dE.get(String.valueOf(b.this.kfI));
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
                    b.this.kfL = new DataRes.Builder(dataRes);
                    int count = y.getCount(dataRes.thread_list);
                    if (count > 0) {
                        b.this.b(dataRes);
                        b.this.dU(dataRes.class_info.sub_class_list);
                        if (b.this.kfG != null) {
                            b.this.kfG.f(count, false, true);
                        }
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(DataRes dataRes) {
        s(dataRes.thread_list, !this.isLoadMore);
        this.mDataList = cQw();
        com.baidu.tieba.homepage.gamevideo.d.a.a(dataRes, this.mDataList);
    }

    private void a(final DataRes.Builder builder) {
        af.a(new ae<Object>() { // from class: com.baidu.tieba.homepage.gamevideo.d.b.4
            @Override // com.baidu.tbadk.util.ae
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                try {
                    com.baidu.tbadk.core.c.a.bqr().dE("tb.game_video", TbadkCoreApplication.getCurrentAccount()).setForever(String.valueOf(b.this.kfI), builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.kfM);
    }
}
