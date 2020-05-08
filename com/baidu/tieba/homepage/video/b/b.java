package com.baidu.tieba.homepage.video.b;

import android.text.SpannableString;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
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
/* loaded from: classes9.dex */
public class b {
    private a hUM;
    private DataRes.Builder hUO;
    private boolean isLoading;
    private TbPageContext mPageContext;
    private boolean gRw = true;
    private com.baidu.adp.framework.listener.a hUP = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_VIDEO_TAB, 309648) { // from class: com.baidu.tieba.homepage.video.b.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            b.this.isLoading = false;
            b.this.gRw = false;
            if (responsedMessage != null) {
                b.this.h(responsedMessage);
            } else if (b.this.hUM != null) {
                b.this.hUM.m(-1, "", false);
            }
        }
    };
    private List<m> mDataList = new LinkedList();
    private List<ThreadInfo> hMy = new LinkedList();
    private List<ThreadPersonalized> hUN = new LinkedList();

    /* loaded from: classes9.dex */
    public interface a {
        void f(int i, boolean z, boolean z2);

        void m(int i, String str, boolean z);
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
                oc(z);
            }
        }
        if (this.hUM != null) {
            if (responsedMessage.getError() != 0) {
                this.hUM.m(responsedMessage.getError(), responsedMessage.getErrorString(), z);
            } else {
                this.hUM.f(i, z, false);
            }
        }
    }

    public b(TbPageContext tbPageContext, a aVar) {
        this.mPageContext = tbPageContext;
        this.hUM = aVar;
    }

    public void registerListener() {
        MessageManager.getInstance().registerListener(this.hUP);
    }

    public void cax() {
        if (!this.isLoading) {
            this.isLoading = true;
            if (this.gRw) {
                aIm();
                this.gRw = false;
            }
            VideoTabRequestMessage videoTabRequestMessage = new VideoTabRequestMessage();
            videoTabRequestMessage.new_net_type = j.netType();
            videoTabRequestMessage.load_type = 1;
            videoTabRequestMessage.page_thread_count = 12;
            videoTabRequestMessage.setNetType(NetMessage.NetType.HTTP);
            this.mPageContext.sendMessage(videoTabRequestMessage);
        }
    }

    public void bRi() {
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
        if (this.hUO != null && !v.isEmpty(this.hUO.thread_list)) {
            long j = com.baidu.adp.lib.f.b.toLong(str, 0L);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.hUO.thread_list.size()) {
                    ThreadInfo threadInfo = this.hUO.thread_list.get(i2);
                    if (threadInfo == null || threadInfo.tid == null || threadInfo.tid.longValue() != j) {
                        i = i2 + 1;
                    } else {
                        this.hUO.thread_list.remove(i2);
                        a(this.hUO);
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void oc(boolean z) {
        DataRes.Builder builder = new DataRes.Builder();
        if (v.getCount(this.hMy) >= 12) {
            if (z) {
                builder.thread_list = this.hMy.subList(this.hMy.size() - 12, this.hMy.size());
                a(builder, true);
            } else {
                builder.thread_list = this.hMy.subList(0, 12);
                a(builder, false);
            }
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.hMy);
            builder.thread_list = arrayList;
            a(builder, false);
        }
        this.hUO = builder;
        a(builder);
    }

    private void a(DataRes.Builder builder, boolean z) {
        if (builder != null) {
            if (v.getCount(this.hUN) >= 12) {
                if (z) {
                    builder.thread_personalized = this.hUN.subList(this.hUN.size() - 12, this.hUN.size());
                    return;
                } else {
                    builder.thread_personalized = this.hUN.subList(0, 12);
                    return;
                }
            }
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(this.hUN);
            builder.thread_personalized = linkedList;
        }
    }

    private void aIm() {
        ac.a(new ab<DataRes>() { // from class: com.baidu.tieba.homepage.video.b.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ab
            /* renamed from: cay */
            public DataRes doInBackground() {
                l<byte[]> cA = com.baidu.tbadk.core.c.a.aMR().cA("tb.video_tab", TbadkCoreApplication.getCurrentAccount());
                if (cA == null) {
                    return null;
                }
                byte[] bArr = cA.get(TbadkCoreApplication.getCurrentAccount());
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
                    b.this.hUO = new DataRes.Builder(dataRes);
                    int count = v.getCount(dataRes.thread_list);
                    if (count > 0) {
                        b.this.a(dataRes, false);
                        if (b.this.hUM != null) {
                            b.this.hUM.f(count, false, true);
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
        this.mDataList = bYY();
        com.baidu.tieba.homepage.video.b.a.n(this.hUN, this.mDataList);
    }

    private void q(List<ThreadPersonalized> list, boolean z) {
        if (!v.isEmpty(list)) {
            if (z) {
                LinkedList linkedList = new LinkedList();
                linkedList.addAll(list);
                linkedList.addAll(this.hUN);
                this.hUN.clear();
                this.hUN.addAll(linkedList);
                return;
            }
            this.hUN.addAll(list);
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
        int i;
        String format;
        LinkedList linkedList = new LinkedList();
        if (v.isEmpty(this.hMy)) {
            return linkedList;
        }
        int i2 = 0;
        for (ThreadInfo threadInfo : this.hMy) {
            bj bjVar = new bj();
            bjVar.a(threadInfo);
            bjVar.dtV = true;
            if (com.baidu.tieba.card.data.l.ab(bjVar)) {
                k aC = d.aC(bjVar);
                if (aC != null && aC.dqE != null && aC.dqE.aMn() != null && !StringUtils.isNull(aC.dqE.aMn().forumName)) {
                    aC.tid = bjVar.getTid();
                    aC.position = i2;
                    d.h(aC);
                    linkedList.add(aC);
                } else {
                    k aC2 = d.aC(bjVar);
                    if (aC2 != null) {
                        aC2.tid = bjVar.getTid();
                        aC2.position = i2;
                        d.a(aC2);
                    }
                    if (aC2 != null && aC2.isValid()) {
                        linkedList.add(aC2);
                    }
                }
                int[] imageWidthAndHeight = bjVar.getImageWidthAndHeight();
                final c aB = d.aB(bjVar);
                if (aB != null) {
                    aB.tid = bjVar.getTid();
                    aB.position = i2;
                    if (aB instanceof k) {
                        if (bjVar.aMw()) {
                            d.d(aB);
                        } else if (bjVar.aLF() == 1) {
                            d.b(aB);
                            aB.dqF = imageWidthAndHeight[0];
                            aB.dqG = imageWidthAndHeight[1];
                        } else if (bjVar.aLF() >= 2) {
                            d.c(aB);
                        } else {
                            d.e(aB);
                        }
                    } else if (aB instanceof com.baidu.tieba.card.data.l) {
                        d.f(aB);
                    }
                }
                if (aB != null && aB.isValid()) {
                    if (!bjVar.aMy() && bjVar.aKC() != null && bjVar.aMn() != null && !StringUtils.isNull(bjVar.aMn().forumName)) {
                        SpannableString spannableString = new SpannableString(String.format(TbadkCoreApplication.getInst().getString(R.string.at_username), bjVar.aKC().getName_show()));
                        spannableString.setSpan(new f(16, bjVar.aKC().getUserId()) { // from class: com.baidu.tieba.homepage.video.b.b.4
                            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                            public void onClick(View view) {
                                com.baidu.tieba.homepage.video.c.a.l(aB);
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(view.getContext(), getLink(), null)));
                            }
                        }, 0, format.length() - 1, 33);
                        aB.dqE.a(spannableString);
                    }
                    linkedList.add(aB);
                }
                if (threadInfo.top_agree_post != null) {
                    k aC3 = d.aC(bjVar);
                    if (aC3 != null) {
                        aC3.tid = bjVar.getTid();
                        aC3.position = i2;
                        d.i(aC3);
                    }
                    if (aC3 != null && aC3.isValid()) {
                        linkedList.add(aC3);
                    }
                }
                k aC4 = d.aC(bjVar);
                if (aC4 != null) {
                    aC4.tid = bjVar.getTid();
                    aC4.position = i2;
                    d.j(aC4);
                }
                if (aC4 != null && aC4.isValid()) {
                    linkedList.add(aC4);
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
                    com.baidu.tbadk.core.c.a.aMR().cA("tb.video_tab", TbadkCoreApplication.getCurrentAccount()).setForever(TbadkCoreApplication.getCurrentAccount(), builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.hUP);
    }
}
