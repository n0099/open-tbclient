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
    private a gip;
    private int gir;
    private DataRes.Builder giu;
    private boolean isLoadMore;
    private boolean isLoading;
    private TbPageContext mPageContext;
    private boolean fnD = true;
    private boolean git = false;
    private com.baidu.adp.framework.listener.a giv = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GAME_VIDEO, 309646) { // from class: com.baidu.tieba.homepage.gamevideo.d.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            DataRes dataRes;
            int i;
            b.this.isLoading = false;
            if (responsedMessage == null) {
                b.this.fnD = false;
                if (b.this.gip != null) {
                    b.this.gip.i(-1, "", b.this.isLoadMore);
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
                b.this.cQ(dataRes.class_info.sub_class_list);
                b.this.git = dataRes.need_rechoose.intValue() == 1;
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
            if (b.this.gip != null) {
                if (responsedMessage.getError() == 0) {
                    b.this.gip.d(i, b.this.isLoadMore, false);
                } else {
                    b.this.gip.i(responsedMessage.getError(), responsedMessage.getErrorString(), b.this.isLoadMore);
                }
            }
            b.this.fnD = false;
        }
    };
    private List<m> mDataList = new LinkedList();
    private List<ThreadInfo> giq = new LinkedList();
    private List<com.baidu.tieba.homepage.gamevideo.c.a> gis = new LinkedList();

    /* loaded from: classes4.dex */
    public interface a {
        void d(int i, boolean z, boolean z2);

        void i(int i, String str, boolean z);
    }

    public b(TbPageContext tbPageContext, a aVar) {
        this.mPageContext = tbPageContext;
        this.gip = aVar;
    }

    public void registerListener() {
        MessageManager.getInstance().registerListener(this.giv);
    }

    public void reset() {
        this.fnD = true;
        this.mDataList.clear();
        this.giq.clear();
    }

    public void tb(int i) {
        int i2;
        if (!this.isLoading) {
            this.gir = i;
            this.isLoading = true;
            this.isLoadMore = false;
            if (this.fnD) {
                agy();
                this.fnD = false;
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

    public void tc(int i) {
        int i2 = 1;
        if (!this.isLoading) {
            this.gir = i;
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

    public void wm(String str) {
        if (!v.isEmpty(this.mDataList)) {
            Iterator<m> it = this.mDataList.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (next instanceof c) {
                    c cVar = (c) next;
                    if (cVar.agG() != null && cVar.agG().getTid() != null && cVar.agG().getTid().equals(str)) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void wX(String str) {
        if (this.giu != null && !v.isEmpty(this.giu.thread_list)) {
            long j = com.baidu.adp.lib.g.b.toLong(str, 0L);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.giu.thread_list.size()) {
                    ThreadInfo threadInfo = this.giu.thread_list.get(i2);
                    if (threadInfo == null || threadInfo.tid == null || threadInfo.tid.longValue() != j) {
                        i = i2 + 1;
                    } else {
                        this.giu.thread_list.remove(i2);
                        a(this.giu);
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public List<com.baidu.tieba.homepage.gamevideo.c.a> bui() {
        return this.gis;
    }

    public boolean buj() {
        return this.git;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQ(List<SubClassItem> list) {
        if (!v.isEmpty(list)) {
            if (this.gis == null) {
                this.gis = new LinkedList();
            }
            this.gis.clear();
            for (SubClassItem subClassItem : list) {
                com.baidu.tieba.homepage.gamevideo.c.a aVar = new com.baidu.tieba.homepage.gamevideo.c.a();
                aVar.a(subClassItem);
                this.gis.add(aVar);
            }
        }
    }

    private void o(List<ThreadInfo> list, boolean z) {
        if (!v.isEmpty(list)) {
            if (z) {
                LinkedList linkedList = new LinkedList();
                linkedList.addAll(list);
                linkedList.addAll(this.giq);
                this.giq.clear();
                this.giq.addAll(linkedList);
                return;
            }
            this.giq.addAll(list);
        }
    }

    private List<m> buk() {
        LinkedList linkedList = new LinkedList();
        if (v.isEmpty(this.giq)) {
            return linkedList;
        }
        int i = 0;
        Iterator<ThreadInfo> it = this.giq.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return linkedList;
            }
            ThreadInfo next = it.next();
            bh bhVar = new bh();
            bhVar.a(next);
            if (l.V(bhVar)) {
                k kVar = new k();
                kVar.caz = bhVar;
                kVar.ePH = true;
                kVar.tid = bhVar.getTid();
                kVar.position = i2;
                kVar.cap = true;
                linkedList.add(kVar);
                l lVar = new l(bhVar);
                lVar.tid = bhVar.getTid();
                lVar.position = i2;
                lVar.ePS = true;
                linkedList.add(lVar);
                if (next.top_agree_post != null) {
                    k kVar2 = new k();
                    kVar2.caz = bhVar;
                    kVar2.ePH = true;
                    kVar2.tid = bhVar.getTid();
                    kVar2.position = i2;
                    kVar2.cav = true;
                    linkedList.add(kVar2);
                }
                k kVar3 = new k();
                kVar3.caz = bhVar;
                kVar3.ePH = true;
                kVar3.tid = bhVar.getTid();
                kVar3.position = i2;
                kVar3.cau = true;
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
        if (v.getCount(this.giq) >= 12) {
            if (this.isLoadMore) {
                builder.thread_list = this.giq.subList(this.giq.size() - 12, this.giq.size());
            } else {
                builder.thread_list = this.giq.subList(0, 12);
            }
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.giq);
            builder.thread_list = arrayList;
        }
        this.giu = builder;
        a(builder);
    }

    private void agy() {
        z.a(new y<DataRes>() { // from class: com.baidu.tieba.homepage.gamevideo.d.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.y
            /* renamed from: bul */
            public DataRes doInBackground() {
                com.baidu.adp.lib.cache.l<byte[]> bJ = com.baidu.tbadk.core.d.a.akL().bJ("tb.game_video", TbadkCoreApplication.getCurrentAccount());
                if (bJ == null) {
                    return null;
                }
                byte[] bArr = bJ.get(String.valueOf(b.this.gir));
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
                    b.this.giu = new DataRes.Builder(dataRes);
                    int count = v.getCount(dataRes.thread_list);
                    if (count > 0) {
                        b.this.b(dataRes);
                        b.this.cQ(dataRes.class_info.sub_class_list);
                        if (b.this.gip != null) {
                            b.this.gip.d(count, false, true);
                        }
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(DataRes dataRes) {
        o(dataRes.thread_list, !this.isLoadMore);
        this.mDataList = buk();
        com.baidu.tieba.homepage.gamevideo.d.a.a(dataRes, this.mDataList);
    }

    private void a(final DataRes.Builder builder) {
        z.a(new y<Object>() { // from class: com.baidu.tieba.homepage.gamevideo.d.b.4
            @Override // com.baidu.tbadk.util.y
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                try {
                    com.baidu.tbadk.core.d.a.akL().bJ("tb.game_video", TbadkCoreApplication.getCurrentAccount()).setForever(String.valueOf(b.this.gir), builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.giv);
    }
}
