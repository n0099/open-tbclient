package com.baidu.tieba.homepage.gamevideo.d;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.ae;
import com.baidu.tieba.card.data.c;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.card.data.m;
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
/* loaded from: classes21.dex */
public class b {
    private a iTp;
    private int iTr;
    private DataRes.Builder iTu;
    private boolean isLoadMore;
    private boolean isLoading;
    private TbPageContext mPageContext;
    private boolean hSK = true;
    private boolean iTt = false;
    private com.baidu.adp.framework.listener.a iTv = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GAME_VIDEO, 309646) { // from class: com.baidu.tieba.homepage.gamevideo.d.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            DataRes dataRes;
            int i;
            b.this.isLoading = false;
            if (responsedMessage == null) {
                b.this.hSK = false;
                if (b.this.iTp != null) {
                    b.this.iTp.k(-1, "", b.this.isLoadMore);
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
                b.this.dk(dataRes.class_info.sub_class_list);
                b.this.iTt = dataRes.need_rechoose.intValue() == 1;
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
            if (b.this.iTp != null) {
                if (responsedMessage.getError() == 0) {
                    b.this.iTp.f(i, b.this.isLoadMore, false);
                } else {
                    b.this.iTp.k(responsedMessage.getError(), responsedMessage.getErrorString(), b.this.isLoadMore);
                }
            }
            b.this.hSK = false;
        }
    };
    private List<q> mDataList = new LinkedList();
    private List<ThreadInfo> iTq = new LinkedList();
    private List<com.baidu.tieba.homepage.gamevideo.c.a> iTs = new LinkedList();

    /* loaded from: classes21.dex */
    public interface a {
        void f(int i, boolean z, boolean z2);

        void k(int i, String str, boolean z);
    }

    public b(TbPageContext tbPageContext, a aVar) {
        this.mPageContext = tbPageContext;
        this.iTp = aVar;
    }

    public void registerListener() {
        MessageManager.getInstance().registerListener(this.iTv);
    }

    public void reset() {
        this.hSK = true;
        this.mDataList.clear();
        this.iTq.clear();
    }

    public void Av(int i) {
        int i2;
        if (!this.isLoading) {
            this.iTr = i;
            this.isLoading = true;
            this.isLoadMore = false;
            if (this.hSK) {
                bcQ();
                this.hSK = false;
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

    public void Aw(int i) {
        int i2 = 1;
        if (!this.isLoading) {
            this.iTr = i;
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

    public void Jm(String str) {
        if (!y.isEmpty(this.mDataList)) {
            Iterator<q> it = this.mDataList.iterator();
            while (it.hasNext()) {
                q next = it.next();
                if (next instanceof c) {
                    c cVar = (c) next;
                    if (cVar.bcY() != null && cVar.bcY().getTid() != null && cVar.bcY().getTid().equals(str)) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void Kh(String str) {
        if (this.iTu != null && !y.isEmpty(this.iTu.thread_list)) {
            long j = com.baidu.adp.lib.f.b.toLong(str, 0L);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.iTu.thread_list.size()) {
                    ThreadInfo threadInfo = this.iTu.thread_list.get(i2);
                    if (threadInfo == null || threadInfo.tid == null || threadInfo.tid.longValue() != j) {
                        i = i2 + 1;
                    } else {
                        this.iTu.thread_list.remove(i2);
                        a(this.iTu);
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public List<com.baidu.tieba.homepage.gamevideo.c.a> cAR() {
        return this.iTs;
    }

    public boolean cAS() {
        return this.iTt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dk(List<SubClassItem> list) {
        if (!y.isEmpty(list)) {
            if (this.iTs == null) {
                this.iTs = new LinkedList();
            }
            this.iTs.clear();
            for (SubClassItem subClassItem : list) {
                com.baidu.tieba.homepage.gamevideo.c.a aVar = new com.baidu.tieba.homepage.gamevideo.c.a();
                aVar.a(subClassItem);
                this.iTs.add(aVar);
            }
        }
    }

    private void n(List<ThreadInfo> list, boolean z) {
        if (!y.isEmpty(list)) {
            if (z) {
                LinkedList linkedList = new LinkedList();
                linkedList.addAll(list);
                linkedList.addAll(this.iTq);
                this.iTq.clear();
                this.iTq.addAll(linkedList);
                return;
            }
            this.iTq.addAll(list);
        }
    }

    private List<q> cAT() {
        LinkedList linkedList = new LinkedList();
        if (y.isEmpty(this.iTq)) {
            return linkedList;
        }
        int i = 0;
        Iterator<ThreadInfo> it = this.iTq.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return linkedList;
            }
            ThreadInfo next = it.next();
            bw bwVar = new bw();
            bwVar.a(next);
            if (m.ab(bwVar)) {
                l lVar = new l();
                lVar.dXg = bwVar;
                lVar.hut = true;
                lVar.tid = bwVar.getTid();
                lVar.position = i2;
                lVar.ecM = true;
                linkedList.add(lVar);
                m mVar = new m(bwVar);
                mVar.tid = bwVar.getTid();
                mVar.position = i2;
                mVar.huC = true;
                linkedList.add(mVar);
                if (next.top_agree_post != null) {
                    l lVar2 = new l();
                    lVar2.dXg = bwVar;
                    lVar2.hut = true;
                    lVar2.tid = bwVar.getTid();
                    lVar2.position = i2;
                    lVar2.ecT = true;
                    linkedList.add(lVar2);
                }
                l lVar3 = new l();
                lVar3.dXg = bwVar;
                lVar3.hut = true;
                lVar3.tid = bwVar.getTid();
                lVar3.position = i2;
                lVar3.ecS = true;
                linkedList.add(lVar3);
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
        if (y.getCount(this.iTq) >= 12) {
            if (this.isLoadMore) {
                builder.thread_list = this.iTq.subList(this.iTq.size() - 12, this.iTq.size());
            } else {
                builder.thread_list = this.iTq.subList(0, 12);
            }
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.iTq);
            builder.thread_list = arrayList;
        }
        this.iTu = builder;
        a(builder);
    }

    private void bcQ() {
        ae.a(new ad<DataRes>() { // from class: com.baidu.tieba.homepage.gamevideo.d.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ad
            /* renamed from: cAU */
            public DataRes doInBackground() {
                com.baidu.adp.lib.cache.l<byte[]> dv = com.baidu.tbadk.core.c.a.bhV().dv("tb.game_video", TbadkCoreApplication.getCurrentAccount());
                if (dv == null) {
                    return null;
                }
                byte[] bArr = dv.get(String.valueOf(b.this.iTr));
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
        }, new com.baidu.tbadk.util.m<DataRes>() { // from class: com.baidu.tieba.homepage.gamevideo.d.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.m
            /* renamed from: c */
            public void onReturnDataInUI(DataRes dataRes) {
                if (dataRes != null) {
                    b.this.iTu = new DataRes.Builder(dataRes);
                    int count = y.getCount(dataRes.thread_list);
                    if (count > 0) {
                        b.this.b(dataRes);
                        b.this.dk(dataRes.class_info.sub_class_list);
                        if (b.this.iTp != null) {
                            b.this.iTp.f(count, false, true);
                        }
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(DataRes dataRes) {
        n(dataRes.thread_list, !this.isLoadMore);
        this.mDataList = cAT();
        com.baidu.tieba.homepage.gamevideo.d.a.a(dataRes, this.mDataList);
    }

    private void a(final DataRes.Builder builder) {
        ae.a(new ad<Object>() { // from class: com.baidu.tieba.homepage.gamevideo.d.b.4
            @Override // com.baidu.tbadk.util.ad
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                try {
                    com.baidu.tbadk.core.c.a.bhV().dv("tb.game_video", TbadkCoreApplication.getCurrentAccount()).setForever(String.valueOf(b.this.iTr), builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.iTv);
    }
}
