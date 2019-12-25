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
/* loaded from: classes6.dex */
public class b {
    private a hdF;
    private DataRes.Builder hdH;
    private boolean isLoading;
    private TbPageContext mPageContext;
    private boolean gca = true;
    private com.baidu.adp.framework.listener.a hdI = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_VIDEO_TAB, 309648) { // from class: com.baidu.tieba.homepage.video.b.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            b.this.isLoading = false;
            b.this.gca = false;
            if (responsedMessage != null) {
                b.this.h(responsedMessage);
            } else if (b.this.hdF != null) {
                b.this.hdF.l(-1, "", false);
            }
        }
    };
    private List<m> mDataList = new LinkedList();
    private List<ThreadInfo> gVI = new LinkedList();
    private List<ThreadPersonalized> hdG = new LinkedList();

    /* loaded from: classes6.dex */
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
                mF(z);
            }
        }
        if (this.hdF != null) {
            if (responsedMessage.getError() != 0) {
                this.hdF.l(responsedMessage.getError(), responsedMessage.getErrorString(), z);
            } else {
                this.hdF.f(i, z, false);
            }
        }
    }

    public b(TbPageContext tbPageContext, a aVar) {
        this.mPageContext = tbPageContext;
        this.hdF = aVar;
    }

    public void registerListener() {
        MessageManager.getInstance().registerListener(this.hdI);
    }

    public void bMU() {
        if (!this.isLoading) {
            this.isLoading = true;
            if (this.gca) {
                axp();
                this.gca = false;
            }
            VideoTabRequestMessage videoTabRequestMessage = new VideoTabRequestMessage();
            videoTabRequestMessage.new_net_type = j.netType();
            videoTabRequestMessage.load_type = 1;
            videoTabRequestMessage.page_thread_count = 12;
            videoTabRequestMessage.setNetType(NetMessage.NetType.HTTP);
            this.mPageContext.sendMessage(videoTabRequestMessage);
        }
    }

    public void bDQ() {
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

    public void Bb(String str) {
        if (!v.isEmpty(this.mDataList)) {
            Iterator<m> it = this.mDataList.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (next instanceof c) {
                    c cVar = (c) next;
                    if (cVar.axx() != null && cVar.axx().getTid() != null && cVar.axx().getTid().equals(str)) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void BG(String str) {
        if (this.hdH != null && !v.isEmpty(this.hdH.thread_list)) {
            long j = com.baidu.adp.lib.f.b.toLong(str, 0L);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.hdH.thread_list.size()) {
                    ThreadInfo threadInfo = this.hdH.thread_list.get(i2);
                    if (threadInfo == null || threadInfo.tid == null || threadInfo.tid.longValue() != j) {
                        i = i2 + 1;
                    } else {
                        this.hdH.thread_list.remove(i2);
                        a(this.hdH);
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void mF(boolean z) {
        DataRes.Builder builder = new DataRes.Builder();
        if (v.getCount(this.gVI) >= 12) {
            if (z) {
                builder.thread_list = this.gVI.subList(this.gVI.size() - 12, this.gVI.size());
                a(builder, true);
            } else {
                builder.thread_list = this.gVI.subList(0, 12);
                a(builder, false);
            }
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.gVI);
            builder.thread_list = arrayList;
            a(builder, false);
        }
        this.hdH = builder;
        a(builder);
    }

    private void a(DataRes.Builder builder, boolean z) {
        if (builder != null) {
            if (v.getCount(this.hdG) >= 12) {
                if (z) {
                    builder.thread_personalized = this.hdG.subList(this.hdG.size() - 12, this.hdG.size());
                    return;
                } else {
                    builder.thread_personalized = this.hdG.subList(0, 12);
                    return;
                }
            }
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(this.hdG);
            builder.thread_personalized = linkedList;
        }
    }

    private void axp() {
        ac.a(new ab<DataRes>() { // from class: com.baidu.tieba.homepage.video.b.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ab
            /* renamed from: bMV */
            public DataRes doInBackground() {
                l<byte[]> ch = com.baidu.tbadk.core.c.a.aBV().ch("tb.video_tab", TbadkCoreApplication.getCurrentAccount());
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
                    b.this.hdH = new DataRes.Builder(dataRes);
                    int count = v.getCount(dataRes.thread_list);
                    if (count > 0) {
                        b.this.a(dataRes, false);
                        if (b.this.hdF != null) {
                            b.this.hdF.f(count, false, true);
                        }
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes, boolean z) {
        n(dataRes.thread_list, !z);
        o(dataRes.thread_personalized, z ? false : true);
        this.mDataList = bLy();
        com.baidu.tieba.homepage.video.b.a.o(this.hdG, this.mDataList);
    }

    private void o(List<ThreadPersonalized> list, boolean z) {
        if (!v.isEmpty(list)) {
            if (z) {
                LinkedList linkedList = new LinkedList();
                linkedList.addAll(list);
                linkedList.addAll(this.hdG);
                this.hdG.clear();
                this.hdG.addAll(linkedList);
                return;
            }
            this.hdG.addAll(list);
        }
    }

    private void n(List<ThreadInfo> list, boolean z) {
        if (!v.isEmpty(list)) {
            if (z) {
                LinkedList linkedList = new LinkedList();
                linkedList.addAll(list);
                linkedList.addAll(this.gVI);
                this.gVI.clear();
                this.gVI.addAll(linkedList);
                return;
            }
            this.gVI.addAll(list);
        }
    }

    private List<m> bLy() {
        int i;
        String format;
        LinkedList linkedList = new LinkedList();
        if (v.isEmpty(this.gVI)) {
            return linkedList;
        }
        int i2 = 0;
        for (ThreadInfo threadInfo : this.gVI) {
            bj bjVar = new bj();
            bjVar.a(threadInfo);
            bjVar.cQf = true;
            if (com.baidu.tieba.card.data.l.Y(bjVar)) {
                if (bjVar.aBC()) {
                    k av = d.av(bjVar);
                    if (av != null) {
                        av.tid = bjVar.getTid();
                        av.position = i2;
                        d.a(av);
                    }
                    if (av != null && av.isValid()) {
                        linkedList.add(av);
                    }
                } else {
                    k av2 = d.av(bjVar);
                    if (av2 != null) {
                        av2.tid = bjVar.getTid();
                        av2.position = i2;
                        d.h(av2);
                    }
                    if (av2 != null && av2.isValid()) {
                        linkedList.add(av2);
                    }
                }
                int[] imageWidthAndHeight = bjVar.getImageWidthAndHeight();
                final c au = d.au(bjVar);
                if (au != null) {
                    au.tid = bjVar.getTid();
                    au.position = i2;
                    if (au instanceof k) {
                        if (bjVar.aBA()) {
                            d.d(au);
                        } else if (bjVar.aAI() == 1) {
                            d.b(au);
                            au.cMS = imageWidthAndHeight[0];
                            au.cMT = imageWidthAndHeight[1];
                        } else if (bjVar.aAI() >= 2) {
                            d.c(au);
                        } else {
                            d.e(au);
                        }
                    } else if (au instanceof com.baidu.tieba.card.data.l) {
                        d.f(au);
                    }
                }
                if (au != null && au.isValid()) {
                    if (!bjVar.aBC() && bjVar.azE() != null) {
                        SpannableString spannableString = new SpannableString(String.format(TbadkCoreApplication.getInst().getString(R.string.at_username), bjVar.azE().getName_show()));
                        spannableString.setSpan(new f(16, bjVar.azE().getUserId()) { // from class: com.baidu.tieba.homepage.video.b.b.4
                            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                            public void onClick(View view) {
                                com.baidu.tieba.homepage.video.c.a.l(au);
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(view.getContext(), getLink(), null)));
                            }
                        }, 0, format.length() - 1, 33);
                        au.cMR.a(spannableString);
                    }
                    linkedList.add(au);
                }
                if (threadInfo.top_agree_post != null) {
                    k av3 = d.av(bjVar);
                    if (av3 != null) {
                        av3.tid = bjVar.getTid();
                        av3.position = i2;
                        d.i(av3);
                    }
                    if (av3 != null && av3.isValid()) {
                        linkedList.add(av3);
                    }
                }
                k av4 = d.av(bjVar);
                if (av4 != null) {
                    av4.tid = bjVar.getTid();
                    av4.position = i2;
                    d.j(av4);
                }
                if (av4 != null && av4.isValid()) {
                    linkedList.add(av4);
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
                    com.baidu.tbadk.core.c.a.aBV().ch("tb.video_tab", TbadkCoreApplication.getCurrentAccount()).setForever(TbadkCoreApplication.getCurrentAccount(), builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.hdI);
    }
}
