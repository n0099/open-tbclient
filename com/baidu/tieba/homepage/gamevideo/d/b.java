package com.baidu.tieba.homepage.gamevideo.d;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.w;
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
    private a iqi;
    private int iqk;
    private DataRes.Builder iqn;
    private boolean isLoadMore;
    private boolean isLoading;
    private TbPageContext mPageContext;
    private boolean hsC = true;
    private boolean iqm = false;
    private com.baidu.adp.framework.listener.a iqo = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GAME_VIDEO, 309646) { // from class: com.baidu.tieba.homepage.gamevideo.d.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            DataRes dataRes;
            int i;
            b.this.isLoading = false;
            if (responsedMessage == null) {
                b.this.hsC = false;
                if (b.this.iqi != null) {
                    b.this.iqi.l(-1, "", b.this.isLoadMore);
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
            if (dataRes != null && dataRes.class_info != null && !w.isEmpty(dataRes.class_info.sub_class_list)) {
                b.this.cV(dataRes.class_info.sub_class_list);
                b.this.iqm = dataRes.need_rechoose.intValue() == 1;
            }
            if (dataRes == null || w.getCount(dataRes.thread_list) <= 0) {
                i = 0;
            } else {
                i = w.getCount(dataRes.thread_list);
                b.this.b(dataRes);
                if (!w.isEmpty(dataRes.thread_list)) {
                    b.this.a(dataRes);
                }
            }
            if (b.this.iqi != null) {
                if (responsedMessage.getError() == 0) {
                    b.this.iqi.e(i, b.this.isLoadMore, false);
                } else {
                    b.this.iqi.l(responsedMessage.getError(), responsedMessage.getErrorString(), b.this.isLoadMore);
                }
            }
            b.this.hsC = false;
        }
    };
    private List<q> mDataList = new LinkedList();
    private List<ThreadInfo> iqj = new LinkedList();
    private List<com.baidu.tieba.homepage.gamevideo.c.a> iql = new LinkedList();

    /* loaded from: classes9.dex */
    public interface a {
        void e(int i, boolean z, boolean z2);

        void l(int i, String str, boolean z);
    }

    public b(TbPageContext tbPageContext, a aVar) {
        this.mPageContext = tbPageContext;
        this.iqi = aVar;
    }

    public void registerListener() {
        MessageManager.getInstance().registerListener(this.iqo);
    }

    public void reset() {
        this.hsC = true;
        this.mDataList.clear();
        this.iqj.clear();
    }

    public void xi(int i) {
        int i2;
        if (!this.isLoading) {
            this.iqk = i;
            this.isLoading = true;
            this.isLoadMore = false;
            if (this.hsC) {
                aPK();
                this.hsC = false;
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

    public void xj(int i) {
        int i2 = 1;
        if (!this.isLoading) {
            this.iqk = i;
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

    public void Fz(String str) {
        if (!w.isEmpty(this.mDataList)) {
            Iterator<q> it = this.mDataList.iterator();
            while (it.hasNext()) {
                q next = it.next();
                if (next instanceof c) {
                    c cVar = (c) next;
                    if (cVar.aPS() != null && cVar.aPS().getTid() != null && cVar.aPS().getTid().equals(str)) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void Gc(String str) {
        if (this.iqn != null && !w.isEmpty(this.iqn.thread_list)) {
            long j = com.baidu.adp.lib.f.b.toLong(str, 0L);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.iqn.thread_list.size()) {
                    ThreadInfo threadInfo = this.iqn.thread_list.get(i2);
                    if (threadInfo == null || threadInfo.tid == null || threadInfo.tid.longValue() != j) {
                        i = i2 + 1;
                    } else {
                        this.iqn.thread_list.remove(i2);
                        a(this.iqn);
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public List<com.baidu.tieba.homepage.gamevideo.c.a> ciY() {
        return this.iql;
    }

    public boolean ciZ() {
        return this.iqm;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cV(List<SubClassItem> list) {
        if (!w.isEmpty(list)) {
            if (this.iql == null) {
                this.iql = new LinkedList();
            }
            this.iql.clear();
            for (SubClassItem subClassItem : list) {
                com.baidu.tieba.homepage.gamevideo.c.a aVar = new com.baidu.tieba.homepage.gamevideo.c.a();
                aVar.a(subClassItem);
                this.iql.add(aVar);
            }
        }
    }

    private void p(List<ThreadInfo> list, boolean z) {
        if (!w.isEmpty(list)) {
            if (z) {
                LinkedList linkedList = new LinkedList();
                linkedList.addAll(list);
                linkedList.addAll(this.iqj);
                this.iqj.clear();
                this.iqj.addAll(linkedList);
                return;
            }
            this.iqj.addAll(list);
        }
    }

    private List<q> cja() {
        LinkedList linkedList = new LinkedList();
        if (w.isEmpty(this.iqj)) {
            return linkedList;
        }
        int i = 0;
        Iterator<ThreadInfo> it = this.iqj.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return linkedList;
            }
            ThreadInfo next = it.next();
            bu buVar = new bu();
            buVar.a(next);
            if (l.ad(buVar)) {
                k kVar = new k();
                kVar.dLi = buVar;
                kVar.gUP = true;
                kVar.tid = buVar.getTid();
                kVar.position = i2;
                kVar.dKS = true;
                linkedList.add(kVar);
                l lVar = new l(buVar);
                lVar.tid = buVar.getTid();
                lVar.position = i2;
                lVar.gUZ = true;
                linkedList.add(lVar);
                if (next.top_agree_post != null) {
                    k kVar2 = new k();
                    kVar2.dLi = buVar;
                    kVar2.gUP = true;
                    kVar2.tid = buVar.getTid();
                    kVar2.position = i2;
                    kVar2.dKZ = true;
                    linkedList.add(kVar2);
                }
                k kVar3 = new k();
                kVar3.dLi = buVar;
                kVar3.gUP = true;
                kVar3.tid = buVar.getTid();
                kVar3.position = i2;
                kVar3.dKY = true;
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
        if (w.getCount(this.iqj) >= 12) {
            if (this.isLoadMore) {
                builder.thread_list = this.iqj.subList(this.iqj.size() - 12, this.iqj.size());
            } else {
                builder.thread_list = this.iqj.subList(0, 12);
            }
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.iqj);
            builder.thread_list = arrayList;
        }
        this.iqn = builder;
        a(builder);
    }

    private void aPK() {
        ad.a(new ac<DataRes>() { // from class: com.baidu.tieba.homepage.gamevideo.d.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ac
            /* renamed from: cjb */
            public DataRes doInBackground() {
                com.baidu.adp.lib.cache.l<byte[]> dc = com.baidu.tbadk.core.c.a.aUM().dc("tb.game_video", TbadkCoreApplication.getCurrentAccount());
                if (dc == null) {
                    return null;
                }
                byte[] bArr = dc.get(String.valueOf(b.this.iqk));
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
                    b.this.iqn = new DataRes.Builder(dataRes);
                    int count = w.getCount(dataRes.thread_list);
                    if (count > 0) {
                        b.this.b(dataRes);
                        b.this.cV(dataRes.class_info.sub_class_list);
                        if (b.this.iqi != null) {
                            b.this.iqi.e(count, false, true);
                        }
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(DataRes dataRes) {
        p(dataRes.thread_list, !this.isLoadMore);
        this.mDataList = cja();
        com.baidu.tieba.homepage.gamevideo.d.a.a(dataRes, this.mDataList);
    }

    private void a(final DataRes.Builder builder) {
        ad.a(new ac<Object>() { // from class: com.baidu.tieba.homepage.gamevideo.d.b.4
            @Override // com.baidu.tbadk.util.ac
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                try {
                    com.baidu.tbadk.core.c.a.aUM().dc("tb.game_video", TbadkCoreApplication.getCurrentAccount()).setForever(String.valueOf(b.this.iqk), builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.iqo);
    }
}
