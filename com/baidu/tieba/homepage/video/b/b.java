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
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
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
    private a iBm;
    private DataRes.Builder iBo;
    private boolean isLoading;
    private TbPageContext mPageContext;
    private boolean hsC = true;
    private com.baidu.adp.framework.listener.a iBp = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_VIDEO_TAB, 309648) { // from class: com.baidu.tieba.homepage.video.b.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            b.this.isLoading = false;
            b.this.hsC = false;
            if (responsedMessage != null) {
                b.this.h(responsedMessage);
            } else if (b.this.iBm != null) {
                b.this.iBm.m(-1, "", false);
            }
        }
    };
    private List<q> mDataList = new LinkedList();
    private List<ThreadInfo> iqj = new LinkedList();
    private List<ThreadPersonalized> iBn = new LinkedList();

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
        if (dataRes == null || w.getCount(dataRes.thread_list) <= 0) {
            i = 0;
        } else {
            i = w.getCount(dataRes.thread_list);
            a(dataRes, z);
            if (!w.isEmpty(dataRes.thread_list)) {
                oI(z);
            }
        }
        if (this.iBm != null) {
            if (responsedMessage.getError() != 0) {
                this.iBm.m(responsedMessage.getError(), responsedMessage.getErrorString(), z);
            } else {
                this.iBm.f(i, z, false);
            }
        }
    }

    public b(TbPageContext tbPageContext, a aVar) {
        this.mPageContext = tbPageContext;
        this.iBm = aVar;
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(309648);
        bVar.setResponsedClass(VideoTabSocketResMessage.class);
        bVar.setNeedAck(true);
        MessageManager.getInstance().registerTask(bVar);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_VIDEO_TAB, com.baidu.tieba.tbadkCore.a.a.bE(TbConfig.URL_VIDEO_TAB, 309648));
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setResponsedClass(VideoTabHttpResMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void registerListener() {
        MessageManager.getInstance().registerListener(this.iBp);
    }

    public void ckS() {
        if (!this.isLoading) {
            this.isLoading = true;
            if (this.hsC) {
                aPK();
                this.hsC = false;
            }
            VideoTabRequestMessage videoTabRequestMessage = new VideoTabRequestMessage();
            videoTabRequestMessage.new_net_type = j.netType();
            videoTabRequestMessage.load_type = 1;
            videoTabRequestMessage.page_thread_count = 12;
            videoTabRequestMessage.setNetType(NetMessage.NetType.HTTP);
            this.mPageContext.sendMessage(videoTabRequestMessage);
        }
    }

    public void caS() {
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
        if (this.iBo != null && !w.isEmpty(this.iBo.thread_list)) {
            long j = com.baidu.adp.lib.f.b.toLong(str, 0L);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.iBo.thread_list.size()) {
                    ThreadInfo threadInfo = this.iBo.thread_list.get(i2);
                    if (threadInfo == null || threadInfo.tid == null || threadInfo.tid.longValue() != j) {
                        i = i2 + 1;
                    } else {
                        this.iBo.thread_list.remove(i2);
                        a(this.iBo);
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void oI(boolean z) {
        DataRes.Builder builder = new DataRes.Builder();
        if (w.getCount(this.iqj) >= 12) {
            if (z) {
                builder.thread_list = this.iqj.subList(this.iqj.size() - 12, this.iqj.size());
                a(builder, true);
            } else {
                builder.thread_list = this.iqj.subList(0, 12);
                a(builder, false);
            }
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.iqj);
            builder.thread_list = arrayList;
            a(builder, false);
        }
        this.iBo = builder;
        a(builder);
    }

    private void a(DataRes.Builder builder, boolean z) {
        if (builder != null) {
            if (w.getCount(this.iBn) >= 12) {
                if (z) {
                    builder.thread_personalized = this.iBn.subList(this.iBn.size() - 12, this.iBn.size());
                    return;
                } else {
                    builder.thread_personalized = this.iBn.subList(0, 12);
                    return;
                }
            }
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(this.iBn);
            builder.thread_personalized = linkedList;
        }
    }

    private void aPK() {
        ad.a(new ac<DataRes>() { // from class: com.baidu.tieba.homepage.video.b.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ac
            /* renamed from: ckT */
            public DataRes doInBackground() {
                l<byte[]> dc = com.baidu.tbadk.core.c.a.aUM().dc("tb.video_tab", TbadkCoreApplication.getCurrentAccount());
                if (dc == null) {
                    return null;
                }
                byte[] bArr = dc.get(TbadkCoreApplication.getCurrentAccount());
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
                    b.this.iBo = new DataRes.Builder(dataRes);
                    int count = w.getCount(dataRes.thread_list);
                    if (count > 0) {
                        b.this.a(dataRes, false);
                        if (b.this.iBm != null) {
                            b.this.iBm.f(count, false, true);
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
        this.mDataList = ciZ();
        com.baidu.tieba.homepage.video.b.a.p(this.iBn, this.mDataList);
    }

    private void q(List<ThreadPersonalized> list, boolean z) {
        if (!w.isEmpty(list)) {
            if (z) {
                LinkedList linkedList = new LinkedList();
                linkedList.addAll(list);
                linkedList.addAll(this.iBn);
                this.iBn.clear();
                this.iBn.addAll(linkedList);
                return;
            }
            this.iBn.addAll(list);
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

    private List<q> ciZ() {
        int i;
        String format;
        LinkedList linkedList = new LinkedList();
        if (w.isEmpty(this.iqj)) {
            return linkedList;
        }
        int i2 = 0;
        for (ThreadInfo threadInfo : this.iqj) {
            bu buVar = new bu();
            buVar.a(threadInfo);
            buVar.dOA = true;
            if (com.baidu.tieba.card.data.l.ad(buVar)) {
                k aC = d.aC(buVar);
                if (aC != null && aC.dLi != null && aC.dLi.aUd() != null && !StringUtils.isNull(aC.dLi.aUd().forumName)) {
                    aC.tid = buVar.getTid();
                    aC.position = i2;
                    d.h(aC);
                    linkedList.add(aC);
                } else {
                    k aC2 = d.aC(buVar);
                    if (aC2 != null) {
                        aC2.tid = buVar.getTid();
                        aC2.position = i2;
                        d.a(aC2);
                    }
                    if (aC2 != null && aC2.isValid()) {
                        linkedList.add(aC2);
                    }
                }
                int[] imageWidthAndHeight = buVar.getImageWidthAndHeight();
                final c aB = d.aB(buVar);
                if (aB != null) {
                    aB.tid = buVar.getTid();
                    aB.position = i2;
                    if (aB instanceof k) {
                        if (buVar.aUl()) {
                            d.d(aB);
                        } else if (buVar.aTv() == 1) {
                            d.b(aB);
                            aB.dLj = imageWidthAndHeight[0];
                            aB.dLk = imageWidthAndHeight[1];
                        } else if (buVar.aTv() >= 2) {
                            d.c(aB);
                        } else {
                            d.e(aB);
                        }
                    } else if (aB instanceof com.baidu.tieba.card.data.l) {
                        d.f(aB);
                    }
                }
                if (aB != null && aB.isValid()) {
                    if (!buVar.aQZ() && buVar.aSp() != null && buVar.aUd() != null && !StringUtils.isNull(buVar.aUd().forumName)) {
                        SpannableString spannableString = new SpannableString(String.format(TbadkCoreApplication.getInst().getString(R.string.at_username), buVar.aSp().getName_show()));
                        spannableString.setSpan(new f(16, buVar.aSp().getUserId()) { // from class: com.baidu.tieba.homepage.video.b.b.4
                            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                            public void onClick(View view) {
                                com.baidu.tieba.homepage.video.c.a.o(aB);
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(view.getContext(), getLink(), null)));
                            }
                        }, 0, format.length() - 1, 33);
                        aB.dLi.a(spannableString);
                    }
                    linkedList.add(aB);
                }
                if (threadInfo.top_agree_post != null) {
                    k aC3 = d.aC(buVar);
                    if (aC3 != null) {
                        aC3.tid = buVar.getTid();
                        aC3.position = i2;
                        d.i(aC3);
                    }
                    if (aC3 != null && aC3.isValid()) {
                        linkedList.add(aC3);
                    }
                }
                k aC4 = d.aC(buVar);
                if (aC4 != null) {
                    aC4.tid = buVar.getTid();
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
        ad.a(new ac<Object>() { // from class: com.baidu.tieba.homepage.video.b.b.5
            @Override // com.baidu.tbadk.util.ac
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                try {
                    com.baidu.tbadk.core.c.a.aUM().dc("tb.video_tab", TbadkCoreApplication.getCurrentAccount()).setForever(TbadkCoreApplication.getCurrentAccount(), builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.iBp);
    }
}
