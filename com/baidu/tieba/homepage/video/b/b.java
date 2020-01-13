package com.baidu.tieba.homepage.video.b;

import android.text.SpannableString;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.m;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.widget.richText.f;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.c;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.homepage.personalize.model.d;
import com.baidu.tieba.homepage.video.message.VideoTabHttpResMessage;
import com.baidu.tieba.homepage.video.message.VideoTabRequestMessage;
import com.baidu.tieba.homepage.video.message.VideoTabSocketResMessage;
import com.squareup.wire.Wire;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.RecomVideo.DataRes;
import tbclient.RecomVideo.ThreadPersonalized;
import tbclient.ThreadInfo;
/* loaded from: classes7.dex */
public class b {
    private a hhi;
    private DataRes.Builder hhk;
    private boolean isLoading;
    private TbPageContext mPageContext;
    private boolean gfl = true;
    private com.baidu.adp.framework.listener.a hhl = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_VIDEO_TAB, 309648) { // from class: com.baidu.tieba.homepage.video.b.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            b.this.isLoading = false;
            b.this.gfl = false;
            if (responsedMessage != null) {
                b.this.h(responsedMessage);
            } else if (b.this.hhi != null) {
                b.this.hhi.l(-1, "", false);
            }
        }
    };
    private List<m> mDataList = new LinkedList();
    private List<ThreadInfo> gZg = new LinkedList();
    private List<ThreadPersonalized> hhj = new LinkedList();

    /* loaded from: classes7.dex */
    public interface a {
        void f(int i, boolean z, boolean z2);

        void l(int i, String str, boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(ResponsedMessage<?> responsedMessage) {
        DataRes dataRes;
        boolean z;
        int i;
        if (responsedMessage instanceof VideoTabSocketResMessage) {
            dataRes = ((VideoTabSocketResMessage) responsedMessage).mResultData;
        } else if (!(responsedMessage instanceof VideoTabHttpResMessage)) {
            dataRes = null;
        } else {
            dataRes = ((VideoTabHttpResMessage) responsedMessage).mResultData;
        }
        if (responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof VideoTabRequestMessage)) {
            z = false;
        } else {
            z = ((VideoTabRequestMessage) responsedMessage.getOrginalMessage().getExtra()).load_type == 2;
        }
        if (dataRes == null || v.getCount(dataRes.thread_list) <= 0) {
            i = 0;
        } else {
            i = v.getCount(dataRes.thread_list);
            a(dataRes, z);
            if (!v.isEmpty(dataRes.thread_list)) {
                mQ(z);
            }
        }
        if (this.hhi != null) {
            if (responsedMessage.getError() != 0) {
                this.hhi.l(responsedMessage.getError(), responsedMessage.getErrorString(), z);
            } else {
                this.hhi.f(i, z, false);
            }
        }
    }

    public b(TbPageContext tbPageContext, a aVar) {
        this.mPageContext = tbPageContext;
        this.hhi = aVar;
    }

    public void registerListener() {
        MessageManager.getInstance().registerListener(this.hhl);
    }

    public void bOc() {
        if (!this.isLoading) {
            this.isLoading = true;
            if (this.gfl) {
                axI();
                this.gfl = false;
            }
            VideoTabRequestMessage videoTabRequestMessage = new VideoTabRequestMessage();
            videoTabRequestMessage.new_net_type = j.netType();
            videoTabRequestMessage.load_type = 1;
            videoTabRequestMessage.page_thread_count = 12;
            videoTabRequestMessage.setNetType(NetMessage.NetType.HTTP);
            this.mPageContext.sendMessage(videoTabRequestMessage);
        }
    }

    public void bES() {
        if (!this.isLoading) {
            this.isLoading = true;
            VideoTabRequestMessage videoTabRequestMessage = new VideoTabRequestMessage();
            videoTabRequestMessage.new_net_type = j.netType();
            videoTabRequestMessage.load_type = 2;
            videoTabRequestMessage.page_thread_count = 12;
            videoTabRequestMessage.setNetType(NetMessage.NetType.HTTP);
            this.mPageContext.sendMessage(videoTabRequestMessage);
        }
    }

    public List<m> getDataList() {
        return this.mDataList;
    }

    public void Bl(String str) {
        if (!v.isEmpty(this.mDataList)) {
            Iterator<m> it = this.mDataList.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (next instanceof c) {
                    c cVar = (c) next;
                    if (cVar.axQ() != null && cVar.axQ().getTid() != null && cVar.axQ().getTid().equals(str)) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void BQ(String str) {
        if (this.hhk != null && !v.isEmpty(this.hhk.thread_list)) {
            long j = com.baidu.adp.lib.f.b.toLong(str, 0L);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.hhk.thread_list.size()) {
                    ThreadInfo threadInfo = this.hhk.thread_list.get(i2);
                    if (threadInfo == null || threadInfo.tid == null || threadInfo.tid.longValue() != j) {
                        i = i2 + 1;
                    } else {
                        this.hhk.thread_list.remove(i2);
                        a(this.hhk);
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void mQ(boolean z) {
        DataRes.Builder builder = new DataRes.Builder();
        if (v.getCount(this.gZg) >= 12) {
            if (z) {
                builder.thread_list = this.gZg.subList(this.gZg.size() - 12, this.gZg.size());
                a(builder, true);
            } else {
                builder.thread_list = this.gZg.subList(0, 12);
                a(builder, false);
            }
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.gZg);
            builder.thread_list = arrayList;
            a(builder, false);
        }
        this.hhk = builder;
        a(builder);
    }

    private void a(DataRes.Builder builder, boolean z) {
        if (builder != null) {
            if (v.getCount(this.hhj) >= 12) {
                if (z) {
                    builder.thread_personalized = this.hhj.subList(this.hhj.size() - 12, this.hhj.size());
                    return;
                } else {
                    builder.thread_personalized = this.hhj.subList(0, 12);
                    return;
                }
            }
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(this.hhj);
            builder.thread_personalized = linkedList;
        }
    }

    private void axI() {
        ac.a(new ab<DataRes>() { // from class: com.baidu.tieba.homepage.video.b.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ab
            /* renamed from: bOd */
            public DataRes doInBackground() {
                l<byte[]> ch = com.baidu.tbadk.core.c.a.aCo().ch("tb.video_tab", TbadkCoreApplication.getCurrentAccount());
                if (ch == null) {
                    return null;
                }
                byte[] bArr = ch.get(TbadkCoreApplication.getCurrentAccount());
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
        }, new com.baidu.tbadk.util.l<DataRes>() { // from class: com.baidu.tieba.homepage.video.b.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            /* renamed from: a */
            public void onReturnDataInUI(DataRes dataRes) {
                if (dataRes != null) {
                    b.this.hhk = new DataRes.Builder(dataRes);
                    int count = v.getCount(dataRes.thread_list);
                    if (count > 0) {
                        b.this.a(dataRes, false);
                        if (b.this.hhi != null) {
                            b.this.hhi.f(count, false, true);
                        }
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes, boolean z) {
        p(dataRes.thread_list, !z);
        q(dataRes.thread_personalized, z ? false : true);
        this.mDataList = bMG();
        com.baidu.tieba.homepage.video.b.a.o(this.hhj, this.mDataList);
    }

    private void q(List<ThreadPersonalized> list, boolean z) {
        if (!v.isEmpty(list)) {
            if (z) {
                LinkedList linkedList = new LinkedList();
                linkedList.addAll(list);
                linkedList.addAll(this.hhj);
                this.hhj.clear();
                this.hhj.addAll(linkedList);
                return;
            }
            this.hhj.addAll(list);
        }
    }

    private void p(List<ThreadInfo> list, boolean z) {
        if (!v.isEmpty(list)) {
            if (z) {
                LinkedList linkedList = new LinkedList();
                linkedList.addAll(list);
                linkedList.addAll(this.gZg);
                this.gZg.clear();
                this.gZg.addAll(linkedList);
                return;
            }
            this.gZg.addAll(list);
        }
    }

    private List<m> bMG() {
        int i;
        String format;
        LinkedList linkedList = new LinkedList();
        if (v.isEmpty(this.gZg)) {
            return linkedList;
        }
        int i2 = 0;
        for (ThreadInfo threadInfo : this.gZg) {
            bj bjVar = new bj();
            bjVar.a(threadInfo);
            bjVar.cQp = true;
            if (com.baidu.tieba.card.data.l.Z(bjVar)) {
                if (bjVar.aBV()) {
                    k aw = d.aw(bjVar);
                    if (aw != null) {
                        aw.tid = bjVar.getTid();
                        aw.position = i2;
                        d.a(aw);
                    }
                    if (aw != null && aw.isValid()) {
                        linkedList.add(aw);
                    }
                } else {
                    k aw2 = d.aw(bjVar);
                    if (aw2 != null) {
                        aw2.tid = bjVar.getTid();
                        aw2.position = i2;
                        d.h(aw2);
                    }
                    if (aw2 != null && aw2.isValid()) {
                        linkedList.add(aw2);
                    }
                }
                int[] imageWidthAndHeight = bjVar.getImageWidthAndHeight();
                final c av = d.av(bjVar);
                if (av != null) {
                    av.tid = bjVar.getTid();
                    av.position = i2;
                    if (av instanceof k) {
                        if (bjVar.aBT()) {
                            d.d(av);
                        } else if (bjVar.aBb() == 1) {
                            d.b(av);
                            av.cNc = imageWidthAndHeight[0];
                            av.cNd = imageWidthAndHeight[1];
                        } else if (bjVar.aBb() >= 2) {
                            d.c(av);
                        } else {
                            d.e(av);
                        }
                    } else if (av instanceof com.baidu.tieba.card.data.l) {
                        d.f(av);
                    }
                }
                if (av != null && av.isValid()) {
                    if (!bjVar.aBV() && bjVar.azX() != null) {
                        SpannableString spannableString = new SpannableString(String.format(TbadkCoreApplication.getInst().getString(R.string.at_username), bjVar.azX().getName_show()));
                        spannableString.setSpan(new f(16, bjVar.azX().getUserId()) { // from class: com.baidu.tieba.homepage.video.b.b.4
                            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                            public void onClick(View view) {
                                com.baidu.tieba.homepage.video.c.a.l(av);
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(view.getContext(), getLink(), null)));
                            }
                        }, 0, format.length() - 1, 33);
                        av.cNb.a(spannableString);
                    }
                    linkedList.add(av);
                }
                if (threadInfo.top_agree_post != null) {
                    k aw3 = d.aw(bjVar);
                    if (aw3 != null) {
                        aw3.tid = bjVar.getTid();
                        aw3.position = i2;
                        d.i(aw3);
                    }
                    if (aw3 != null && aw3.isValid()) {
                        linkedList.add(aw3);
                    }
                }
                k aw4 = d.aw(bjVar);
                if (aw4 != null) {
                    aw4.tid = bjVar.getTid();
                    aw4.position = i2;
                    d.j(aw4);
                }
                if (aw4 != null && aw4.isValid()) {
                    linkedList.add(aw4);
                }
                i = i2 + 1;
            } else {
                i = i2;
            }
            i2 = i;
        }
        return linkedList;
    }

    private void a(final DataRes.Builder builder) {
        ac.a(new ab<Object>() { // from class: com.baidu.tieba.homepage.video.b.b.5
            @Override // com.baidu.tbadk.util.ab
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                try {
                    com.baidu.tbadk.core.c.a.aCo().ch("tb.video_tab", TbadkCoreApplication.getCurrentAccount()).setForever(TbadkCoreApplication.getCurrentAccount(), builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.hhl);
    }
}
