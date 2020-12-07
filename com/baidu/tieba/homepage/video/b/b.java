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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.m;
import com.baidu.tbadk.widget.richText.f;
import com.baidu.tieba.R;
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
/* loaded from: classes22.dex */
public class b {
    private boolean isLoading;
    private a kaM;
    private DataRes.Builder kaO;
    private TbPageContext mPageContext;
    private boolean iLL = true;
    private com.baidu.adp.framework.listener.a kaP = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_VIDEO_TAB, 309648) { // from class: com.baidu.tieba.homepage.video.b.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            b.this.isLoading = false;
            b.this.iLL = false;
            if (responsedMessage != null) {
                b.this.h(responsedMessage);
            } else if (b.this.kaM != null) {
                b.this.kaM.o(-1, "", false);
            }
        }
    };
    private List<q> mDataList = new LinkedList();
    private List<ThreadInfo> jPg = new LinkedList();
    private List<ThreadPersonalized> kaN = new LinkedList();

    /* loaded from: classes22.dex */
    public interface a {
        void g(int i, boolean z, boolean z2);

        void o(int i, String str, boolean z);
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
        if (dataRes == null || y.getCount(dataRes.thread_list) <= 0) {
            i = 0;
        } else {
            i = y.getCount(dataRes.thread_list);
            a(dataRes, z);
            if (!y.isEmpty(dataRes.thread_list)) {
                rP(z);
            }
        }
        if (this.kaM != null) {
            if (responsedMessage.getError() != 0) {
                this.kaM.o(responsedMessage.getError(), responsedMessage.getErrorString(), z);
            } else {
                this.kaM.g(i, z, false);
            }
        }
    }

    public b(TbPageContext tbPageContext, a aVar) {
        this.mPageContext = tbPageContext;
        this.kaM = aVar;
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(309648);
        bVar.setResponsedClass(VideoTabSocketResMessage.class);
        bVar.setNeedAck(true);
        MessageManager.getInstance().registerTask(bVar);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_VIDEO_TAB, com.baidu.tieba.tbadkCore.a.a.bN(TbConfig.URL_VIDEO_TAB, 309648));
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setResponsedClass(VideoTabHttpResMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void registerListener() {
        MessageManager.getInstance().registerListener(this.kaP);
    }

    public void cRg() {
        if (!this.isLoading) {
            this.isLoading = true;
            if (this.iLL) {
                bmf();
                this.iLL = false;
            }
            VideoTabRequestMessage videoTabRequestMessage = new VideoTabRequestMessage();
            videoTabRequestMessage.new_net_type = j.netType();
            videoTabRequestMessage.load_type = 1;
            videoTabRequestMessage.page_thread_count = 12;
            videoTabRequestMessage.setNetType(NetMessage.NetType.HTTP);
            this.mPageContext.sendMessage(videoTabRequestMessage);
        }
    }

    public void cFh() {
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

    public void Lx(String str) {
        if (!y.isEmpty(this.mDataList)) {
            Iterator<q> it = this.mDataList.iterator();
            while (it.hasNext()) {
                q next = it.next();
                if (next instanceof com.baidu.tieba.card.data.b) {
                    com.baidu.tieba.card.data.b bVar = (com.baidu.tieba.card.data.b) next;
                    if (bVar.bmn() != null && bVar.bmn().getTid() != null && bVar.bmn().getTid().equals(str)) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void Mt(String str) {
        if (this.kaO != null && !y.isEmpty(this.kaO.thread_list)) {
            long j = com.baidu.adp.lib.f.b.toLong(str, 0L);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.kaO.thread_list.size()) {
                    ThreadInfo threadInfo = this.kaO.thread_list.get(i2);
                    if (threadInfo == null || threadInfo.tid == null || threadInfo.tid.longValue() != j) {
                        i = i2 + 1;
                    } else {
                        this.kaO.thread_list.remove(i2);
                        a(this.kaO);
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void rP(boolean z) {
        DataRes.Builder builder = new DataRes.Builder();
        if (y.getCount(this.jPg) >= 12) {
            if (z) {
                builder.thread_list = this.jPg.subList(this.jPg.size() - 12, this.jPg.size());
                a(builder, true);
            } else {
                builder.thread_list = this.jPg.subList(0, 12);
                a(builder, false);
            }
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.jPg);
            builder.thread_list = arrayList;
            a(builder, false);
        }
        this.kaO = builder;
        a(builder);
    }

    private void a(DataRes.Builder builder, boolean z) {
        if (builder != null) {
            if (y.getCount(this.kaN) >= 12) {
                if (z) {
                    builder.thread_personalized = this.kaN.subList(this.kaN.size() - 12, this.kaN.size());
                    return;
                } else {
                    builder.thread_personalized = this.kaN.subList(0, 12);
                    return;
                }
            }
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(this.kaN);
            builder.thread_personalized = linkedList;
        }
    }

    private void bmf() {
        ad.a(new ac<DataRes>() { // from class: com.baidu.tieba.homepage.video.b.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ac
            /* renamed from: cRh */
            public DataRes doInBackground() {
                l<byte[]> dM = com.baidu.tbadk.core.c.a.brq().dM("tb.video_tab", TbadkCoreApplication.getCurrentAccount());
                if (dM == null) {
                    return null;
                }
                byte[] bArr = dM.get(TbadkCoreApplication.getCurrentAccount());
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
        }, new m<DataRes>() { // from class: com.baidu.tieba.homepage.video.b.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.m
            /* renamed from: a */
            public void onReturnDataInUI(DataRes dataRes) {
                if (dataRes != null) {
                    b.this.kaO = new DataRes.Builder(dataRes);
                    int count = y.getCount(dataRes.thread_list);
                    if (count > 0) {
                        b.this.a(dataRes, false);
                        if (b.this.kaM != null) {
                            b.this.kaM.g(count, false, true);
                        }
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes, boolean z) {
        q(dataRes.thread_list, !z);
        r(dataRes.thread_personalized, z ? false : true);
        this.mDataList = cPc();
        com.baidu.tieba.homepage.video.b.a.w(this.kaN, this.mDataList);
    }

    private void r(List<ThreadPersonalized> list, boolean z) {
        if (!y.isEmpty(list)) {
            if (z) {
                LinkedList linkedList = new LinkedList();
                linkedList.addAll(list);
                linkedList.addAll(this.kaN);
                this.kaN.clear();
                this.kaN.addAll(linkedList);
                return;
            }
            this.kaN.addAll(list);
        }
    }

    private void q(List<ThreadInfo> list, boolean z) {
        if (!y.isEmpty(list)) {
            if (z) {
                LinkedList linkedList = new LinkedList();
                linkedList.addAll(list);
                linkedList.addAll(this.jPg);
                this.jPg.clear();
                this.jPg.addAll(linkedList);
                return;
            }
            this.jPg.addAll(list);
        }
    }

    private List<q> cPc() {
        int i;
        String format;
        LinkedList linkedList = new LinkedList();
        if (y.isEmpty(this.jPg)) {
            return linkedList;
        }
        int i2 = 0;
        for (ThreadInfo threadInfo : this.jPg) {
            by byVar = new by();
            byVar.a(threadInfo);
            byVar.eMk = true;
            if (com.baidu.tieba.card.data.l.ad(byVar)) {
                k aD = d.aD(byVar);
                if (aD != null && aD.eCR != null && aD.eCR.bqF() != null && !StringUtils.isNull(aD.eCR.bqF().forumName)) {
                    aD.tid = byVar.getTid();
                    aD.position = i2;
                    d.h(aD);
                    linkedList.add(aD);
                } else {
                    k aD2 = d.aD(byVar);
                    if (aD2 != null) {
                        aD2.tid = byVar.getTid();
                        aD2.position = i2;
                        d.a(aD2);
                    }
                    if (aD2 != null && aD2.isValid()) {
                        linkedList.add(aD2);
                    }
                }
                int[] imageWidthAndHeight = byVar.getImageWidthAndHeight();
                final com.baidu.tieba.card.data.b aC = d.aC(byVar);
                if (aC != null) {
                    aC.tid = byVar.getTid();
                    aC.position = i2;
                    if (aC instanceof k) {
                        if (byVar.bqM()) {
                            d.d(aC);
                        } else if (byVar.bpX() == 1) {
                            d.b(aC);
                            aC.eIP = imageWidthAndHeight[0];
                            aC.eIQ = imageWidthAndHeight[1];
                        } else if (byVar.bpX() >= 2) {
                            d.c(aC);
                        } else {
                            d.e(aC);
                        }
                    } else if (aC instanceof com.baidu.tieba.card.data.l) {
                        d.f(aC);
                    }
                }
                if (aC != null && aC.isValid()) {
                    if (!byVar.bnz() && byVar.boP() != null && byVar.bqF() != null && !StringUtils.isNull(byVar.bqF().forumName)) {
                        SpannableString spannableString = new SpannableString(String.format(TbadkCoreApplication.getInst().getString(R.string.at_username), byVar.boP().getName_show()));
                        spannableString.setSpan(new f(16, byVar.boP().getUserId()) { // from class: com.baidu.tieba.homepage.video.b.b.4
                            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                            public void onClick(View view) {
                                com.baidu.tieba.homepage.video.c.a.o(aC);
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(view.getContext(), getLink(), null)));
                            }
                        }, 0, format.length() - 1, 33);
                        aC.eCR.a(spannableString);
                    }
                    linkedList.add(aC);
                }
                if (threadInfo.top_agree_post != null) {
                    k aD3 = d.aD(byVar);
                    if (aD3 != null) {
                        aD3.tid = byVar.getTid();
                        aD3.position = i2;
                        d.i(aD3);
                    }
                    if (aD3 != null && aD3.isValid()) {
                        linkedList.add(aD3);
                    }
                }
                k aD4 = d.aD(byVar);
                if (aD4 != null) {
                    aD4.tid = byVar.getTid();
                    aD4.position = i2;
                    d.j(aD4);
                }
                if (aD4 != null && aD4.isValid()) {
                    linkedList.add(aD4);
                }
                i = i2 + 1;
            } else {
                i = i2;
            }
            i2 = i;
        }
        com.baidu.tbadk.a.a.a.bh(linkedList);
        return linkedList;
    }

    private void a(final DataRes.Builder builder) {
        ad.a(new ac<Object>() { // from class: com.baidu.tieba.homepage.video.b.b.5
            @Override // com.baidu.tbadk.util.ac
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                try {
                    com.baidu.tbadk.core.c.a.brq().dM("tb.video_tab", TbadkCoreApplication.getCurrentAccount()).setForever(TbadkCoreApplication.getCurrentAccount(), builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.kaP);
    }
}
