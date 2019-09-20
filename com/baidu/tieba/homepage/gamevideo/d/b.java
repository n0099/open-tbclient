package com.baidu.tieba.homepage.gamevideo.d;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.util.y;
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
    private a gjJ;
    private int gjL;
    private DataRes.Builder gjO;
    private boolean isLoadMore;
    private boolean isLoading;
    private TbPageContext mPageContext;
    private boolean flM = true;
    private boolean gjN = false;
    private com.baidu.adp.framework.listener.a gjP = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GAME_VIDEO, 309646) { // from class: com.baidu.tieba.homepage.gamevideo.d.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            DataRes dataRes;
            int i;
            b.this.isLoading = false;
            if (responsedMessage == null) {
                b.this.flM = false;
                if (b.this.gjJ != null) {
                    b.this.gjJ.i(-1, "", b.this.isLoadMore);
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
                b.this.cD(dataRes.class_info.sub_class_list);
                b.this.gjN = dataRes.need_rechoose.intValue() == 1;
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
            if (b.this.gjJ != null) {
                if (responsedMessage.getError() == 0) {
                    b.this.gjJ.d(i, b.this.isLoadMore, false);
                } else {
                    b.this.gjJ.i(responsedMessage.getError(), responsedMessage.getErrorString(), b.this.isLoadMore);
                }
            }
            b.this.flM = false;
        }
    };
    private List<m> mDataList = new LinkedList();
    private List<ThreadInfo> gjK = new LinkedList();
    private List<com.baidu.tieba.homepage.gamevideo.c.a> gjM = new LinkedList();

    /* loaded from: classes4.dex */
    public interface a {
        void d(int i, boolean z, boolean z2);

        void i(int i, String str, boolean z);
    }

    public b(TbPageContext tbPageContext, a aVar) {
        this.mPageContext = tbPageContext;
        this.gjJ = aVar;
    }

    public void registerListener() {
        MessageManager.getInstance().registerListener(this.gjP);
    }

    public void reset() {
        this.flM = true;
        this.mDataList.clear();
        this.gjK.clear();
    }

    public void uh(int i) {
        int i2;
        if (!this.isLoading) {
            this.gjL = i;
            this.isLoading = true;
            this.isLoadMore = false;
            if (this.flM) {
                acu();
                this.flM = false;
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

    public void ui(int i) {
        int i2 = 1;
        if (!this.isLoading) {
            this.gjL = i;
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

    public void xU(String str) {
        if (!v.aa(this.mDataList)) {
            Iterator<m> it = this.mDataList.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (next instanceof c) {
                    c cVar = (c) next;
                    if (cVar.acC() != null && cVar.acC().getTid() != null && cVar.acC().getTid().equals(str)) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void yE(String str) {
        if (this.gjO != null && !v.aa(this.gjO.thread_list)) {
            long e = com.baidu.adp.lib.g.b.e(str, 0L);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.gjO.thread_list.size()) {
                    ThreadInfo threadInfo = this.gjO.thread_list.get(i2);
                    if (threadInfo == null || threadInfo.tid == null || threadInfo.tid.longValue() != e) {
                        i = i2 + 1;
                    } else {
                        this.gjO.thread_list.remove(i2);
                        a(this.gjO);
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public List<com.baidu.tieba.homepage.gamevideo.c.a> bxf() {
        return this.gjM;
    }

    public boolean bxg() {
        return this.gjN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cD(List<SubClassItem> list) {
        if (!v.aa(list)) {
            if (this.gjM == null) {
                this.gjM = new LinkedList();
            }
            this.gjM.clear();
            for (SubClassItem subClassItem : list) {
                com.baidu.tieba.homepage.gamevideo.c.a aVar = new com.baidu.tieba.homepage.gamevideo.c.a();
                aVar.a(subClassItem);
                this.gjM.add(aVar);
            }
        }
    }

    private void o(List<ThreadInfo> list, boolean z) {
        if (!v.aa(list)) {
            if (z) {
                LinkedList linkedList = new LinkedList();
                linkedList.addAll(list);
                linkedList.addAll(this.gjK);
                this.gjK.clear();
                this.gjK.addAll(linkedList);
                return;
            }
            this.gjK.addAll(list);
        }
    }

    private List<m> bxh() {
        LinkedList linkedList = new LinkedList();
        if (v.aa(this.gjK)) {
            return linkedList;
        }
        int i = 0;
        Iterator<ThreadInfo> it = this.gjK.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return linkedList;
            }
            ThreadInfo next = it.next();
            bh bhVar = new bh();
            bhVar.a(next);
            if (l.X(bhVar)) {
                k kVar = new k();
                kVar.threadData = bhVar;
                kVar.eHT = true;
                kVar.tid = bhVar.getTid();
                kVar.position = i2;
                kVar.bJz = true;
                linkedList.add(kVar);
                l lVar = new l(bhVar);
                lVar.tid = bhVar.getTid();
                lVar.position = i2;
                lVar.eIe = true;
                linkedList.add(lVar);
                if (next.top_agree_post != null) {
                    k kVar2 = new k();
                    kVar2.threadData = bhVar;
                    kVar2.eHT = true;
                    kVar2.tid = bhVar.getTid();
                    kVar2.position = i2;
                    kVar2.bJF = true;
                    linkedList.add(kVar2);
                }
                k kVar3 = new k();
                kVar3.threadData = bhVar;
                kVar3.eHT = true;
                kVar3.tid = bhVar.getTid();
                kVar3.position = i2;
                kVar3.bJE = true;
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
        if (v.Z(this.gjK) >= 12) {
            if (this.isLoadMore) {
                builder.thread_list = this.gjK.subList(this.gjK.size() - 12, this.gjK.size());
            } else {
                builder.thread_list = this.gjK.subList(0, 12);
            }
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.gjK);
            builder.thread_list = arrayList;
        }
        this.gjO = builder;
        a(builder);
    }

    private void acu() {
        z.a(new y<DataRes>() { // from class: com.baidu.tieba.homepage.gamevideo.d.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.y
            /* renamed from: bxi */
            public DataRes doInBackground() {
                com.baidu.adp.lib.cache.l<byte[]> bD = com.baidu.tbadk.core.d.a.agL().bD("tb.game_video", TbadkCoreApplication.getCurrentAccount());
                if (bD == null) {
                    return null;
                }
                byte[] bArr = bD.get(String.valueOf(b.this.gjL));
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
        }, new com.baidu.tbadk.util.j<DataRes>() { // from class: com.baidu.tieba.homepage.gamevideo.d.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.j
            /* renamed from: c */
            public void onReturnDataInUI(DataRes dataRes) {
                if (dataRes != null) {
                    b.this.gjO = new DataRes.Builder(dataRes);
                    int Z = v.Z(dataRes.thread_list);
                    if (Z > 0) {
                        b.this.b(dataRes);
                        b.this.cD(dataRes.class_info.sub_class_list);
                        if (b.this.gjJ != null) {
                            b.this.gjJ.d(Z, false, true);
                        }
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(DataRes dataRes) {
        o(dataRes.thread_list, !this.isLoadMore);
        this.mDataList = bxh();
        com.baidu.tieba.homepage.gamevideo.d.a.a(dataRes, this.mDataList);
    }

    private void a(final DataRes.Builder builder) {
        z.a(new y<Object>() { // from class: com.baidu.tieba.homepage.gamevideo.d.b.4
            @Override // com.baidu.tbadk.util.y
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                try {
                    com.baidu.tbadk.core.d.a.agL().bD("tb.game_video", TbadkCoreApplication.getCurrentAccount()).f(String.valueOf(b.this.gjL), builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gjP);
    }
}
