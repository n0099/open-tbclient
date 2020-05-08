package com.baidu.tieba.homepage.gamevideo.d;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.util.ac;
import com.baidu.tieba.card.data.c;
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
/* loaded from: classes9.dex */
public class b {
    private DataRes.Builder hMC;
    private a hMx;
    private int hMz;
    private boolean isLoadMore;
    private boolean isLoading;
    private TbPageContext mPageContext;
    private boolean gRw = true;
    private boolean hMB = false;
    private com.baidu.adp.framework.listener.a hMD = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GAME_VIDEO, 309646) { // from class: com.baidu.tieba.homepage.gamevideo.d.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            DataRes dataRes;
            int i;
            b.this.isLoading = false;
            if (responsedMessage == null) {
                b.this.gRw = false;
                if (b.this.hMx != null) {
                    b.this.hMx.l(-1, "", b.this.isLoadMore);
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
            if (dataRes != null && dataRes.class_info != null && !v.isEmpty(dataRes.class_info.sub_class_list)) {
                b.this.cM(dataRes.class_info.sub_class_list);
                b.this.hMB = dataRes.need_rechoose.intValue() == 1;
            }
            if (dataRes == null || v.getCount(dataRes.thread_list) <= 0) {
                i = 0;
            } else {
                i = v.getCount(dataRes.thread_list);
                b.this.b(dataRes);
                if (!v.isEmpty(dataRes.thread_list)) {
                    b.this.a(dataRes);
                }
            }
            if (b.this.hMx != null) {
                if (responsedMessage.getError() == 0) {
                    b.this.hMx.e(i, b.this.isLoadMore, false);
                } else {
                    b.this.hMx.l(responsedMessage.getError(), responsedMessage.getErrorString(), b.this.isLoadMore);
                }
            }
            b.this.gRw = false;
        }
    };
    private List<m> mDataList = new LinkedList();
    private List<ThreadInfo> hMy = new LinkedList();
    private List<com.baidu.tieba.homepage.gamevideo.c.a> hMA = new LinkedList();

    /* loaded from: classes9.dex */
    public interface a {
        void e(int i, boolean z, boolean z2);

        void l(int i, String str, boolean z);
    }

    public b(TbPageContext tbPageContext, a aVar) {
        this.mPageContext = tbPageContext;
        this.hMx = aVar;
    }

    public void registerListener() {
        MessageManager.getInstance().registerListener(this.hMD);
    }

    public void reset() {
        this.gRw = true;
        this.mDataList.clear();
        this.hMy.clear();
    }

    public void vU(int i) {
        int i2;
        if (!this.isLoading) {
            this.hMz = i;
            this.isLoading = true;
            this.isLoadMore = false;
            if (this.gRw) {
                aIm();
                this.gRw = false;
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

    public void vV(int i) {
        int i2 = 1;
        if (!this.isLoading) {
            this.hMz = i;
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

    public List<m> getDataList() {
        return this.mDataList;
    }

    public void Dp(String str) {
        if (!v.isEmpty(this.mDataList)) {
            Iterator<m> it = this.mDataList.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (next instanceof c) {
                    c cVar = (c) next;
                    if (cVar.aIu() != null && cVar.aIu().getTid() != null && cVar.aIu().getTid().equals(str)) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void DS(String str) {
        if (this.hMC != null && !v.isEmpty(this.hMC.thread_list)) {
            long j = com.baidu.adp.lib.f.b.toLong(str, 0L);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.hMC.thread_list.size()) {
                    ThreadInfo threadInfo = this.hMC.thread_list.get(i2);
                    if (threadInfo == null || threadInfo.tid == null || threadInfo.tid.longValue() != j) {
                        i = i2 + 1;
                    } else {
                        this.hMC.thread_list.remove(i2);
                        a(this.hMC);
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public List<com.baidu.tieba.homepage.gamevideo.c.a> bYW() {
        return this.hMA;
    }

    public boolean bYX() {
        return this.hMB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cM(List<SubClassItem> list) {
        if (!v.isEmpty(list)) {
            if (this.hMA == null) {
                this.hMA = new LinkedList();
            }
            this.hMA.clear();
            for (SubClassItem subClassItem : list) {
                com.baidu.tieba.homepage.gamevideo.c.a aVar = new com.baidu.tieba.homepage.gamevideo.c.a();
                aVar.a(subClassItem);
                this.hMA.add(aVar);
            }
        }
    }

    private void p(List<ThreadInfo> list, boolean z) {
        if (!v.isEmpty(list)) {
            if (z) {
                LinkedList linkedList = new LinkedList();
                linkedList.addAll(list);
                linkedList.addAll(this.hMy);
                this.hMy.clear();
                this.hMy.addAll(linkedList);
                return;
            }
            this.hMy.addAll(list);
        }
    }

    private List<m> bYY() {
        LinkedList linkedList = new LinkedList();
        if (v.isEmpty(this.hMy)) {
            return linkedList;
        }
        int i = 0;
        Iterator<ThreadInfo> it = this.hMy.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return linkedList;
            }
            ThreadInfo next = it.next();
            bj bjVar = new bj();
            bjVar.a(next);
            if (l.ab(bjVar)) {
                k kVar = new k();
                kVar.dqE = bjVar;
                kVar.gsR = true;
                kVar.tid = bjVar.getTid();
                kVar.position = i2;
                kVar.dqs = true;
                linkedList.add(kVar);
                l lVar = new l(bjVar);
                lVar.tid = bjVar.getTid();
                lVar.position = i2;
                lVar.gtd = true;
                linkedList.add(lVar);
                if (next.top_agree_post != null) {
                    k kVar2 = new k();
                    kVar2.dqE = bjVar;
                    kVar2.gsR = true;
                    kVar2.tid = bjVar.getTid();
                    kVar2.position = i2;
                    kVar2.dqz = true;
                    linkedList.add(kVar2);
                }
                k kVar3 = new k();
                kVar3.dqE = bjVar;
                kVar3.gsR = true;
                kVar3.tid = bjVar.getTid();
                kVar3.position = i2;
                kVar3.dqy = true;
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
        if (v.getCount(this.hMy) >= 12) {
            if (this.isLoadMore) {
                builder.thread_list = this.hMy.subList(this.hMy.size() - 12, this.hMy.size());
            } else {
                builder.thread_list = this.hMy.subList(0, 12);
            }
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.hMy);
            builder.thread_list = arrayList;
        }
        this.hMC = builder;
        a(builder);
    }

    private void aIm() {
        ac.a(new ab<DataRes>() { // from class: com.baidu.tieba.homepage.gamevideo.d.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ab
            /* renamed from: bYZ */
            public DataRes doInBackground() {
                com.baidu.adp.lib.cache.l<byte[]> cA = com.baidu.tbadk.core.c.a.aMR().cA("tb.game_video", TbadkCoreApplication.getCurrentAccount());
                if (cA == null) {
                    return null;
                }
                byte[] bArr = cA.get(String.valueOf(b.this.hMz));
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
                    b.this.hMC = new DataRes.Builder(dataRes);
                    int count = v.getCount(dataRes.thread_list);
                    if (count > 0) {
                        b.this.b(dataRes);
                        b.this.cM(dataRes.class_info.sub_class_list);
                        if (b.this.hMx != null) {
                            b.this.hMx.e(count, false, true);
                        }
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(DataRes dataRes) {
        p(dataRes.thread_list, !this.isLoadMore);
        this.mDataList = bYY();
        com.baidu.tieba.homepage.gamevideo.d.a.a(dataRes, this.mDataList);
    }

    private void a(final DataRes.Builder builder) {
        ac.a(new ab<Object>() { // from class: com.baidu.tieba.homepage.gamevideo.d.b.4
            @Override // com.baidu.tbadk.util.ab
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                try {
                    com.baidu.tbadk.core.c.a.aMR().cA("tb.game_video", TbadkCoreApplication.getCurrentAccount()).setForever(String.valueOf(b.this.hMz), builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.hMD);
    }
}
