package com.baidu.tieba.homepage.gamevideo.d;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.z;
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
/* loaded from: classes4.dex */
public class b {
    private a gha;
    private int ghc;
    private DataRes.Builder ghf;
    private boolean isLoadMore;
    private boolean isLoading;
    private TbPageContext mPageContext;
    private boolean fjz = true;
    private boolean ghe = false;
    private com.baidu.adp.framework.listener.a ghg = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GAME_VIDEO, 309646) { // from class: com.baidu.tieba.homepage.gamevideo.d.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            DataRes dataRes;
            int i;
            b.this.isLoading = false;
            if (responsedMessage == null) {
                b.this.fjz = false;
                if (b.this.gha != null) {
                    b.this.gha.i(-1, "", b.this.isLoadMore);
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
            if (dataRes != null && dataRes.class_info != null && !v.aa(dataRes.class_info.sub_class_list)) {
                b.this.cE(dataRes.class_info.sub_class_list);
                b.this.ghe = dataRes.need_rechoose.intValue() == 1;
            }
            if (dataRes == null || v.Z(dataRes.thread_list) <= 0) {
                i = 0;
            } else {
                i = v.Z(dataRes.thread_list);
                b.this.b(dataRes);
                if (!v.aa(dataRes.thread_list)) {
                    b.this.a(dataRes);
                }
            }
            if (b.this.gha != null) {
                if (responsedMessage.getError() == 0) {
                    b.this.gha.d(i, b.this.isLoadMore, false);
                } else {
                    b.this.gha.i(responsedMessage.getError(), responsedMessage.getErrorString(), b.this.isLoadMore);
                }
            }
            b.this.fjz = false;
        }
    };
    private List<m> mDataList = new LinkedList();
    private List<ThreadInfo> ghb = new LinkedList();
    private List<com.baidu.tieba.homepage.gamevideo.c.a> ghd = new LinkedList();

    /* loaded from: classes4.dex */
    public interface a {
        void d(int i, boolean z, boolean z2);

        void i(int i, String str, boolean z);
    }

    public b(TbPageContext tbPageContext, a aVar) {
        this.mPageContext = tbPageContext;
        this.gha = aVar;
    }

    public void registerListener() {
        MessageManager.getInstance().registerListener(this.ghg);
    }

    public void reset() {
        this.fjz = true;
        this.mDataList.clear();
        this.ghb.clear();
    }

    public void ub(int i) {
        int i2;
        if (!this.isLoading) {
            this.ghc = i;
            this.isLoading = true;
            this.isLoadMore = false;
            if (this.fjz) {
                acq();
                this.fjz = false;
            }
            GameVideoRequestMessage gameVideoRequestMessage = new GameVideoRequestMessage();
            gameVideoRequestMessage.class_id = "1";
            gameVideoRequestMessage.sub_class_id = i;
            if (j.kd()) {
                i2 = 1;
            } else if (j.kf()) {
                i2 = 4;
            } else if (j.kg()) {
                i2 = 3;
            } else {
                i2 = j.kh() ? 2 : 1;
            }
            gameVideoRequestMessage.new_net_type = i2;
            gameVideoRequestMessage.load_type = 1;
            gameVideoRequestMessage.page_thread_count = 12;
            gameVideoRequestMessage.setNetType(NetMessage.NetType.HTTP);
            this.mPageContext.sendMessage(gameVideoRequestMessage);
        }
    }

    public void uc(int i) {
        int i2 = 1;
        if (!this.isLoading) {
            this.ghc = i;
            this.isLoading = true;
            this.isLoadMore = true;
            GameVideoRequestMessage gameVideoRequestMessage = new GameVideoRequestMessage();
            gameVideoRequestMessage.class_id = "1";
            gameVideoRequestMessage.sub_class_id = i;
            if (!j.kd()) {
                if (j.kf()) {
                    i2 = 4;
                } else if (j.kg()) {
                    i2 = 3;
                } else if (j.kh()) {
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

    public void xu(String str) {
        if (!v.aa(this.mDataList)) {
            Iterator<m> it = this.mDataList.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (next instanceof c) {
                    c cVar = (c) next;
                    if (cVar.acx() != null && cVar.acx().getTid() != null && cVar.acx().getTid().equals(str)) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void ye(String str) {
        if (this.ghf != null && !v.aa(this.ghf.thread_list)) {
            long c = com.baidu.adp.lib.g.b.c(str, 0L);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.ghf.thread_list.size()) {
                    ThreadInfo threadInfo = this.ghf.thread_list.get(i2);
                    if (threadInfo == null || threadInfo.tid == null || threadInfo.tid.longValue() != c) {
                        i = i2 + 1;
                    } else {
                        this.ghf.thread_list.remove(i2);
                        a(this.ghf);
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public List<com.baidu.tieba.homepage.gamevideo.c.a> bwd() {
        return this.ghd;
    }

    public boolean bwe() {
        return this.ghe;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cE(List<SubClassItem> list) {
        if (!v.aa(list)) {
            if (this.ghd == null) {
                this.ghd = new LinkedList();
            }
            this.ghd.clear();
            for (SubClassItem subClassItem : list) {
                com.baidu.tieba.homepage.gamevideo.c.a aVar = new com.baidu.tieba.homepage.gamevideo.c.a();
                aVar.a(subClassItem);
                this.ghd.add(aVar);
            }
        }
    }

    private void o(List<ThreadInfo> list, boolean z) {
        if (!v.aa(list)) {
            if (z) {
                LinkedList linkedList = new LinkedList();
                linkedList.addAll(list);
                linkedList.addAll(this.ghb);
                this.ghb.clear();
                this.ghb.addAll(linkedList);
                return;
            }
            this.ghb.addAll(list);
        }
    }

    private List<m> bwf() {
        LinkedList linkedList = new LinkedList();
        if (v.aa(this.ghb)) {
            return linkedList;
        }
        int i = 0;
        Iterator<ThreadInfo> it = this.ghb.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return linkedList;
            }
            ThreadInfo next = it.next();
            bg bgVar = new bg();
            bgVar.a(next);
            if (l.V(bgVar)) {
                k kVar = new k();
                kVar.threadData = bgVar;
                kVar.eGd = true;
                kVar.tid = bgVar.getTid();
                kVar.position = i2;
                kVar.bIW = true;
                linkedList.add(kVar);
                l lVar = new l(bgVar);
                lVar.tid = bgVar.getTid();
                lVar.position = i2;
                lVar.eGo = true;
                linkedList.add(lVar);
                if (next.top_agree_post != null) {
                    k kVar2 = new k();
                    kVar2.threadData = bgVar;
                    kVar2.eGd = true;
                    kVar2.tid = bgVar.getTid();
                    kVar2.position = i2;
                    kVar2.bJc = true;
                    linkedList.add(kVar2);
                }
                k kVar3 = new k();
                kVar3.threadData = bgVar;
                kVar3.eGd = true;
                kVar3.tid = bgVar.getTid();
                kVar3.position = i2;
                kVar3.bJb = true;
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
        if (v.Z(this.ghb) >= 12) {
            if (this.isLoadMore) {
                builder.thread_list = this.ghb.subList(this.ghb.size() - 12, this.ghb.size());
            } else {
                builder.thread_list = this.ghb.subList(0, 12);
            }
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.ghb);
            builder.thread_list = arrayList;
        }
        this.ghf = builder;
        a(builder);
    }

    private void acq() {
        aa.a(new z<DataRes>() { // from class: com.baidu.tieba.homepage.gamevideo.d.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.z
            /* renamed from: bwg */
            public DataRes doInBackground() {
                com.baidu.adp.lib.cache.l<byte[]> bD = com.baidu.tbadk.core.d.a.agF().bD("tb.game_video", TbadkCoreApplication.getCurrentAccount());
                if (bD == null) {
                    return null;
                }
                byte[] bArr = bD.get(String.valueOf(b.this.ghc));
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
        }, new com.baidu.tbadk.util.k<DataRes>() { // from class: com.baidu.tieba.homepage.gamevideo.d.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.k
            /* renamed from: c */
            public void onReturnDataInUI(DataRes dataRes) {
                if (dataRes != null) {
                    b.this.ghf = new DataRes.Builder(dataRes);
                    int Z = v.Z(dataRes.thread_list);
                    if (Z > 0) {
                        b.this.b(dataRes);
                        b.this.cE(dataRes.class_info.sub_class_list);
                        if (b.this.gha != null) {
                            b.this.gha.d(Z, false, true);
                        }
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(DataRes dataRes) {
        o(dataRes.thread_list, !this.isLoadMore);
        this.mDataList = bwf();
        com.baidu.tieba.homepage.gamevideo.d.a.a(dataRes, this.mDataList);
    }

    private void a(final DataRes.Builder builder) {
        aa.a(new z<Object>() { // from class: com.baidu.tieba.homepage.gamevideo.d.b.4
            @Override // com.baidu.tbadk.util.z
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                try {
                    com.baidu.tbadk.core.d.a.agF().bD("tb.game_video", TbadkCoreApplication.getCurrentAccount()).f(String.valueOf(b.this.ghc), builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.ghg);
    }
}
