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
/* loaded from: classes22.dex */
public class b {
    private boolean isLoadMore;
    private boolean isLoading;
    private a jin;
    private int jip;
    private DataRes.Builder jis;
    private TbPageContext mPageContext;
    private boolean ihJ = true;
    private boolean jir = false;
    private com.baidu.adp.framework.listener.a jit = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GAME_VIDEO, 309646) { // from class: com.baidu.tieba.homepage.gamevideo.d.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            DataRes dataRes;
            int i;
            b.this.isLoading = false;
            if (responsedMessage == null) {
                b.this.ihJ = false;
                if (b.this.jin != null) {
                    b.this.jin.m(-1, "", b.this.isLoadMore);
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
                b.this.dn(dataRes.class_info.sub_class_list);
                b.this.jir = dataRes.need_rechoose.intValue() == 1;
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
            if (b.this.jin != null) {
                if (responsedMessage.getError() == 0) {
                    b.this.jin.f(i, b.this.isLoadMore, false);
                } else {
                    b.this.jin.m(responsedMessage.getError(), responsedMessage.getErrorString(), b.this.isLoadMore);
                }
            }
            b.this.ihJ = false;
        }
    };
    private List<q> mDataList = new LinkedList();
    private List<ThreadInfo> jio = new LinkedList();
    private List<com.baidu.tieba.homepage.gamevideo.c.a> jiq = new LinkedList();

    /* loaded from: classes22.dex */
    public interface a {
        void f(int i, boolean z, boolean z2);

        void m(int i, String str, boolean z);
    }

    public b(TbPageContext tbPageContext, a aVar) {
        this.mPageContext = tbPageContext;
        this.jin = aVar;
    }

    public void registerListener() {
        MessageManager.getInstance().registerListener(this.jit);
    }

    public void reset() {
        this.ihJ = true;
        this.mDataList.clear();
        this.jio.clear();
    }

    public void Bb(int i) {
        int i2;
        if (!this.isLoading) {
            this.jip = i;
            this.isLoading = true;
            this.isLoadMore = false;
            if (this.ihJ) {
                bfy();
                this.ihJ = false;
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

    public void Bc(int i) {
        int i2 = 1;
        if (!this.isLoading) {
            this.jip = i;
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

    public void JZ(String str) {
        if (!y.isEmpty(this.mDataList)) {
            Iterator<q> it = this.mDataList.iterator();
            while (it.hasNext()) {
                q next = it.next();
                if (next instanceof c) {
                    c cVar = (c) next;
                    if (cVar.bfG() != null && cVar.bfG().getTid() != null && cVar.bfG().getTid().equals(str)) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void KW(String str) {
        if (this.jis != null && !y.isEmpty(this.jis.thread_list)) {
            long j = com.baidu.adp.lib.f.b.toLong(str, 0L);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.jis.thread_list.size()) {
                    ThreadInfo threadInfo = this.jis.thread_list.get(i2);
                    if (threadInfo == null || threadInfo.tid == null || threadInfo.tid.longValue() != j) {
                        i = i2 + 1;
                    } else {
                        this.jis.thread_list.remove(i2);
                        a(this.jis);
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public List<com.baidu.tieba.homepage.gamevideo.c.a> cEy() {
        return this.jiq;
    }

    public boolean cEz() {
        return this.jir;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dn(List<SubClassItem> list) {
        if (!y.isEmpty(list)) {
            if (this.jiq == null) {
                this.jiq = new LinkedList();
            }
            this.jiq.clear();
            for (SubClassItem subClassItem : list) {
                com.baidu.tieba.homepage.gamevideo.c.a aVar = new com.baidu.tieba.homepage.gamevideo.c.a();
                aVar.a(subClassItem);
                this.jiq.add(aVar);
            }
        }
    }

    private void o(List<ThreadInfo> list, boolean z) {
        if (!y.isEmpty(list)) {
            if (z) {
                LinkedList linkedList = new LinkedList();
                linkedList.addAll(list);
                linkedList.addAll(this.jio);
                this.jio.clear();
                this.jio.addAll(linkedList);
                return;
            }
            this.jio.addAll(list);
        }
    }

    private List<q> cEA() {
        LinkedList linkedList = new LinkedList();
        if (y.isEmpty(this.jio)) {
            return linkedList;
        }
        int i = 0;
        Iterator<ThreadInfo> it = this.jio.iterator();
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
                lVar.eji = bwVar;
                lVar.hJo = true;
                lVar.tid = bwVar.getTid();
                lVar.position = i2;
                lVar.eoR = true;
                linkedList.add(lVar);
                m mVar = new m(bwVar);
                mVar.tid = bwVar.getTid();
                mVar.position = i2;
                mVar.hJx = true;
                linkedList.add(mVar);
                if (next.top_agree_post != null) {
                    l lVar2 = new l();
                    lVar2.eji = bwVar;
                    lVar2.hJo = true;
                    lVar2.tid = bwVar.getTid();
                    lVar2.position = i2;
                    lVar2.eoY = true;
                    linkedList.add(lVar2);
                }
                l lVar3 = new l();
                lVar3.eji = bwVar;
                lVar3.hJo = true;
                lVar3.tid = bwVar.getTid();
                lVar3.position = i2;
                lVar3.eoX = true;
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
        if (y.getCount(this.jio) >= 12) {
            if (this.isLoadMore) {
                builder.thread_list = this.jio.subList(this.jio.size() - 12, this.jio.size());
            } else {
                builder.thread_list = this.jio.subList(0, 12);
            }
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.jio);
            builder.thread_list = arrayList;
        }
        this.jis = builder;
        a(builder);
    }

    private void bfy() {
        ae.a(new ad<DataRes>() { // from class: com.baidu.tieba.homepage.gamevideo.d.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ad
            /* renamed from: cEB */
            public DataRes doInBackground() {
                com.baidu.adp.lib.cache.l<byte[]> dA = com.baidu.tbadk.core.c.a.bkE().dA("tb.game_video", TbadkCoreApplication.getCurrentAccount());
                if (dA == null) {
                    return null;
                }
                byte[] bArr = dA.get(String.valueOf(b.this.jip));
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
                    b.this.jis = new DataRes.Builder(dataRes);
                    int count = y.getCount(dataRes.thread_list);
                    if (count > 0) {
                        b.this.b(dataRes);
                        b.this.dn(dataRes.class_info.sub_class_list);
                        if (b.this.jin != null) {
                            b.this.jin.f(count, false, true);
                        }
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(DataRes dataRes) {
        o(dataRes.thread_list, !this.isLoadMore);
        this.mDataList = cEA();
        com.baidu.tieba.homepage.gamevideo.d.a.a(dataRes, this.mDataList);
    }

    private void a(final DataRes.Builder builder) {
        ae.a(new ad<Object>() { // from class: com.baidu.tieba.homepage.gamevideo.d.b.4
            @Override // com.baidu.tbadk.util.ad
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                try {
                    com.baidu.tbadk.core.c.a.bkE().dA("tb.game_video", TbadkCoreApplication.getCurrentAccount()).setForever(String.valueOf(b.this.jip), builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.jit);
    }
}
