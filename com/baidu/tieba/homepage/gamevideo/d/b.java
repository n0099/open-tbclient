package com.baidu.tieba.homepage.gamevideo.d;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
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
    private a iaY;
    private int iba;
    private DataRes.Builder ibd;
    private boolean isLoadMore;
    private boolean isLoading;
    private TbPageContext mPageContext;
    private boolean hgh = true;
    private boolean ibc = false;
    private com.baidu.adp.framework.listener.a ibe = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GAME_VIDEO, 309646) { // from class: com.baidu.tieba.homepage.gamevideo.d.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            DataRes dataRes;
            int i;
            b.this.isLoading = false;
            if (responsedMessage == null) {
                b.this.hgh = false;
                if (b.this.iaY != null) {
                    b.this.iaY.l(-1, "", b.this.isLoadMore);
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
                b.this.cJ(dataRes.class_info.sub_class_list);
                b.this.ibc = dataRes.need_rechoose.intValue() == 1;
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
            if (b.this.iaY != null) {
                if (responsedMessage.getError() == 0) {
                    b.this.iaY.e(i, b.this.isLoadMore, false);
                } else {
                    b.this.iaY.l(responsedMessage.getError(), responsedMessage.getErrorString(), b.this.isLoadMore);
                }
            }
            b.this.hgh = false;
        }
    };
    private List<o> mDataList = new LinkedList();
    private List<ThreadInfo> iaZ = new LinkedList();
    private List<com.baidu.tieba.homepage.gamevideo.c.a> ibb = new LinkedList();

    /* loaded from: classes9.dex */
    public interface a {
        void e(int i, boolean z, boolean z2);

        void l(int i, String str, boolean z);
    }

    public b(TbPageContext tbPageContext, a aVar) {
        this.mPageContext = tbPageContext;
        this.iaY = aVar;
    }

    public void registerListener() {
        MessageManager.getInstance().registerListener(this.ibe);
    }

    public void reset() {
        this.hgh = true;
        this.mDataList.clear();
        this.iaZ.clear();
    }

    public void wA(int i) {
        int i2;
        if (!this.isLoading) {
            this.iba = i;
            this.isLoading = true;
            this.isLoadMore = false;
            if (this.hgh) {
                aOa();
                this.hgh = false;
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

    public void wB(int i) {
        int i2 = 1;
        if (!this.isLoading) {
            this.iba = i;
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

    public List<o> getDataList() {
        return this.mDataList;
    }

    public void EY(String str) {
        if (!v.isEmpty(this.mDataList)) {
            Iterator<o> it = this.mDataList.iterator();
            while (it.hasNext()) {
                o next = it.next();
                if (next instanceof c) {
                    c cVar = (c) next;
                    if (cVar.aOi() != null && cVar.aOi().getTid() != null && cVar.aOi().getTid().equals(str)) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void FB(String str) {
        if (this.ibd != null && !v.isEmpty(this.ibd.thread_list)) {
            long j = com.baidu.adp.lib.f.b.toLong(str, 0L);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.ibd.thread_list.size()) {
                    ThreadInfo threadInfo = this.ibd.thread_list.get(i2);
                    if (threadInfo == null || threadInfo.tid == null || threadInfo.tid.longValue() != j) {
                        i = i2 + 1;
                    } else {
                        this.ibd.thread_list.remove(i2);
                        a(this.ibd);
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public List<com.baidu.tieba.homepage.gamevideo.c.a> cfs() {
        return this.ibb;
    }

    public boolean cft() {
        return this.ibc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJ(List<SubClassItem> list) {
        if (!v.isEmpty(list)) {
            if (this.ibb == null) {
                this.ibb = new LinkedList();
            }
            this.ibb.clear();
            for (SubClassItem subClassItem : list) {
                com.baidu.tieba.homepage.gamevideo.c.a aVar = new com.baidu.tieba.homepage.gamevideo.c.a();
                aVar.a(subClassItem);
                this.ibb.add(aVar);
            }
        }
    }

    private void p(List<ThreadInfo> list, boolean z) {
        if (!v.isEmpty(list)) {
            if (z) {
                LinkedList linkedList = new LinkedList();
                linkedList.addAll(list);
                linkedList.addAll(this.iaZ);
                this.iaZ.clear();
                this.iaZ.addAll(linkedList);
                return;
            }
            this.iaZ.addAll(list);
        }
    }

    private List<o> cfu() {
        LinkedList linkedList = new LinkedList();
        if (v.isEmpty(this.iaZ)) {
            return linkedList;
        }
        int i = 0;
        Iterator<ThreadInfo> it = this.iaZ.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return linkedList;
            }
            ThreadInfo next = it.next();
            bk bkVar = new bk();
            bkVar.a(next);
            if (l.ac(bkVar)) {
                k kVar = new k();
                kVar.dEA = bkVar;
                kVar.gHE = true;
                kVar.tid = bkVar.getTid();
                kVar.position = i2;
                kVar.dEo = true;
                linkedList.add(kVar);
                l lVar = new l(bkVar);
                lVar.tid = bkVar.getTid();
                lVar.position = i2;
                lVar.gHO = true;
                linkedList.add(lVar);
                if (next.top_agree_post != null) {
                    k kVar2 = new k();
                    kVar2.dEA = bkVar;
                    kVar2.gHE = true;
                    kVar2.tid = bkVar.getTid();
                    kVar2.position = i2;
                    kVar2.dEv = true;
                    linkedList.add(kVar2);
                }
                k kVar3 = new k();
                kVar3.dEA = bkVar;
                kVar3.gHE = true;
                kVar3.tid = bkVar.getTid();
                kVar3.position = i2;
                kVar3.dEu = true;
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
        if (v.getCount(this.iaZ) >= 12) {
            if (this.isLoadMore) {
                builder.thread_list = this.iaZ.subList(this.iaZ.size() - 12, this.iaZ.size());
            } else {
                builder.thread_list = this.iaZ.subList(0, 12);
            }
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.iaZ);
            builder.thread_list = arrayList;
        }
        this.ibd = builder;
        a(builder);
    }

    private void aOa() {
        ad.a(new ac<DataRes>() { // from class: com.baidu.tieba.homepage.gamevideo.d.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ac
            /* renamed from: cfv */
            public DataRes doInBackground() {
                com.baidu.adp.lib.cache.l<byte[]> cZ = com.baidu.tbadk.core.c.a.aSS().cZ("tb.game_video", TbadkCoreApplication.getCurrentAccount());
                if (cZ == null) {
                    return null;
                }
                byte[] bArr = cZ.get(String.valueOf(b.this.iba));
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
                    b.this.ibd = new DataRes.Builder(dataRes);
                    int count = v.getCount(dataRes.thread_list);
                    if (count > 0) {
                        b.this.b(dataRes);
                        b.this.cJ(dataRes.class_info.sub_class_list);
                        if (b.this.iaY != null) {
                            b.this.iaY.e(count, false, true);
                        }
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(DataRes dataRes) {
        p(dataRes.thread_list, !this.isLoadMore);
        this.mDataList = cfu();
        com.baidu.tieba.homepage.gamevideo.d.a.a(dataRes, this.mDataList);
    }

    private void a(final DataRes.Builder builder) {
        ad.a(new ac<Object>() { // from class: com.baidu.tieba.homepage.gamevideo.d.b.4
            @Override // com.baidu.tbadk.util.ac
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                try {
                    com.baidu.tbadk.core.c.a.aSS().cZ("tb.game_video", TbadkCoreApplication.getCurrentAccount()).setForever(String.valueOf(b.this.iba), builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.ibe);
    }
}
