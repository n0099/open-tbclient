package com.baidu.tieba.homepage.gamevideo.d;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.x;
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
/* loaded from: classes16.dex */
public class b {
    private boolean isLoadMore;
    private boolean isLoading;
    private a iwm;
    private int iwo;
    private DataRes.Builder iwr;
    private TbPageContext mPageContext;
    private boolean hyo = true;
    private boolean iwq = false;
    private com.baidu.adp.framework.listener.a iws = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GAME_VIDEO, 309646) { // from class: com.baidu.tieba.homepage.gamevideo.d.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            DataRes dataRes;
            int i;
            b.this.isLoading = false;
            if (responsedMessage == null) {
                b.this.hyo = false;
                if (b.this.iwm != null) {
                    b.this.iwm.l(-1, "", b.this.isLoadMore);
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
                b.this.da(dataRes.class_info.sub_class_list);
                b.this.iwq = dataRes.need_rechoose.intValue() == 1;
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
            if (b.this.iwm != null) {
                if (responsedMessage.getError() == 0) {
                    b.this.iwm.e(i, b.this.isLoadMore, false);
                } else {
                    b.this.iwm.l(responsedMessage.getError(), responsedMessage.getErrorString(), b.this.isLoadMore);
                }
            }
            b.this.hyo = false;
        }
    };
    private List<q> mDataList = new LinkedList();
    private List<ThreadInfo> iwn = new LinkedList();
    private List<com.baidu.tieba.homepage.gamevideo.c.a> iwp = new LinkedList();

    /* loaded from: classes16.dex */
    public interface a {
        void e(int i, boolean z, boolean z2);

        void l(int i, String str, boolean z);
    }

    public b(TbPageContext tbPageContext, a aVar) {
        this.mPageContext = tbPageContext;
        this.iwm = aVar;
    }

    public void registerListener() {
        MessageManager.getInstance().registerListener(this.iws);
    }

    public void reset() {
        this.hyo = true;
        this.mDataList.clear();
        this.iwn.clear();
    }

    public void xA(int i) {
        int i2;
        if (!this.isLoading) {
            this.iwo = i;
            this.isLoading = true;
            this.isLoadMore = false;
            if (this.hyo) {
                aTF();
                this.hyo = false;
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

    public void xB(int i) {
        int i2 = 1;
        if (!this.isLoading) {
            this.iwo = i;
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

    public void Gl(String str) {
        if (!x.isEmpty(this.mDataList)) {
            Iterator<q> it = this.mDataList.iterator();
            while (it.hasNext()) {
                q next = it.next();
                if (next instanceof c) {
                    c cVar = (c) next;
                    if (cVar.aTN() != null && cVar.aTN().getTid() != null && cVar.aTN().getTid().equals(str)) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void GO(String str) {
        if (this.iwr != null && !x.isEmpty(this.iwr.thread_list)) {
            long j = com.baidu.adp.lib.f.b.toLong(str, 0L);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.iwr.thread_list.size()) {
                    ThreadInfo threadInfo = this.iwr.thread_list.get(i2);
                    if (threadInfo == null || threadInfo.tid == null || threadInfo.tid.longValue() != j) {
                        i = i2 + 1;
                    } else {
                        this.iwr.thread_list.remove(i2);
                        a(this.iwr);
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public List<com.baidu.tieba.homepage.gamevideo.c.a> cmz() {
        return this.iwp;
    }

    public boolean cmA() {
        return this.iwq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void da(List<SubClassItem> list) {
        if (!x.isEmpty(list)) {
            if (this.iwp == null) {
                this.iwp = new LinkedList();
            }
            this.iwp.clear();
            for (SubClassItem subClassItem : list) {
                com.baidu.tieba.homepage.gamevideo.c.a aVar = new com.baidu.tieba.homepage.gamevideo.c.a();
                aVar.a(subClassItem);
                this.iwp.add(aVar);
            }
        }
    }

    private void n(List<ThreadInfo> list, boolean z) {
        if (!x.isEmpty(list)) {
            if (z) {
                LinkedList linkedList = new LinkedList();
                linkedList.addAll(list);
                linkedList.addAll(this.iwn);
                this.iwn.clear();
                this.iwn.addAll(linkedList);
                return;
            }
            this.iwn.addAll(list);
        }
    }

    private List<q> cmB() {
        LinkedList linkedList = new LinkedList();
        if (x.isEmpty(this.iwn)) {
            return linkedList;
        }
        int i = 0;
        Iterator<ThreadInfo> it = this.iwn.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return linkedList;
            }
            ThreadInfo next = it.next();
            bv bvVar = new bv();
            bvVar.a(next);
            if (l.aa(bvVar)) {
                k kVar = new k();
                kVar.dLK = bvVar;
                kVar.hat = true;
                kVar.tid = bvVar.getTid();
                kVar.position = i2;
                kVar.dRe = true;
                linkedList.add(kVar);
                l lVar = new l(bvVar);
                lVar.tid = bvVar.getTid();
                lVar.position = i2;
                lVar.haD = true;
                linkedList.add(lVar);
                if (next.top_agree_post != null) {
                    k kVar2 = new k();
                    kVar2.dLK = bvVar;
                    kVar2.hat = true;
                    kVar2.tid = bvVar.getTid();
                    kVar2.position = i2;
                    kVar2.dRl = true;
                    linkedList.add(kVar2);
                }
                k kVar3 = new k();
                kVar3.dLK = bvVar;
                kVar3.hat = true;
                kVar3.tid = bvVar.getTid();
                kVar3.position = i2;
                kVar3.dRk = true;
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
        if (x.getCount(this.iwn) >= 12) {
            if (this.isLoadMore) {
                builder.thread_list = this.iwn.subList(this.iwn.size() - 12, this.iwn.size());
            } else {
                builder.thread_list = this.iwn.subList(0, 12);
            }
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.iwn);
            builder.thread_list = arrayList;
        }
        this.iwr = builder;
        a(builder);
    }

    private void aTF() {
        ad.a(new ac<DataRes>() { // from class: com.baidu.tieba.homepage.gamevideo.d.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ac
            /* renamed from: cmC */
            public DataRes doInBackground() {
                com.baidu.adp.lib.cache.l<byte[]> df = com.baidu.tbadk.core.c.a.aYG().df("tb.game_video", TbadkCoreApplication.getCurrentAccount());
                if (df == null) {
                    return null;
                }
                byte[] bArr = df.get(String.valueOf(b.this.iwo));
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
                    b.this.iwr = new DataRes.Builder(dataRes);
                    int count = x.getCount(dataRes.thread_list);
                    if (count > 0) {
                        b.this.b(dataRes);
                        b.this.da(dataRes.class_info.sub_class_list);
                        if (b.this.iwm != null) {
                            b.this.iwm.e(count, false, true);
                        }
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(DataRes dataRes) {
        n(dataRes.thread_list, !this.isLoadMore);
        this.mDataList = cmB();
        com.baidu.tieba.homepage.gamevideo.d.a.a(dataRes, this.mDataList);
    }

    private void a(final DataRes.Builder builder) {
        ad.a(new ac<Object>() { // from class: com.baidu.tieba.homepage.gamevideo.d.b.4
            @Override // com.baidu.tbadk.util.ac
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                try {
                    com.baidu.tbadk.core.c.a.aYG().df("tb.game_video", TbadkCoreApplication.getCurrentAccount()).setForever(String.valueOf(b.this.iwo), builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.iws);
    }
}
