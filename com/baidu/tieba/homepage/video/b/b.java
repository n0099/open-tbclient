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
import com.baidu.adp.widget.ListView.n;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.util.ac;
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
/* loaded from: classes2.dex */
public class b {
    private boolean isLoading;
    private a kju;
    private DataRes.Builder kjw;
    private TbPageContext mPageContext;
    private boolean iTr = true;
    private com.baidu.adp.framework.listener.a kjx = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_VIDEO_TAB, 309648) { // from class: com.baidu.tieba.homepage.video.b.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            b.this.isLoading = false;
            b.this.iTr = false;
            if (responsedMessage != null) {
                b.this.h(responsedMessage);
            } else if (b.this.kju != null) {
                b.this.kju.o(-1, "", false);
            }
        }
    };
    private List<n> mDataList = new LinkedList();
    private List<ThreadInfo> jXR = new LinkedList();
    private List<ThreadPersonalized> kjv = new LinkedList();

    /* loaded from: classes2.dex */
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
        if (dataRes == null || x.getCount(dataRes.thread_list) <= 0) {
            i = 0;
        } else {
            i = x.getCount(dataRes.thread_list);
            a(dataRes, z);
            if (!x.isEmpty(dataRes.thread_list)) {
                si(z);
            }
        }
        if (this.kju != null) {
            if (responsedMessage.getError() != 0) {
                this.kju.o(responsedMessage.getError(), responsedMessage.getErrorString(), z);
            } else {
                this.kju.g(i, z, false);
            }
        }
    }

    public b(TbPageContext tbPageContext, a aVar) {
        this.mPageContext = tbPageContext;
        this.kju = aVar;
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(309648);
        bVar.setResponsedClass(VideoTabSocketResMessage.class);
        bVar.setNeedAck(true);
        MessageManager.getInstance().registerTask(bVar);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_VIDEO_TAB, com.baidu.tieba.tbadkCore.a.a.bV(TbConfig.URL_VIDEO_TAB, 309648));
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setResponsedClass(VideoTabHttpResMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void registerListener() {
        MessageManager.getInstance().registerListener(this.kjx);
    }

    public void cQw() {
        if (!this.isLoading) {
            this.isLoading = true;
            if (this.iTr) {
                bkL();
                this.iTr = false;
            }
            VideoTabRequestMessage videoTabRequestMessage = new VideoTabRequestMessage();
            videoTabRequestMessage.new_net_type = j.netType();
            videoTabRequestMessage.load_type = 1;
            videoTabRequestMessage.page_thread_count = 12;
            videoTabRequestMessage.setNetType(NetMessage.NetType.HTTP);
            this.mPageContext.sendMessage(videoTabRequestMessage);
        }
    }

    public void cEl() {
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

    public List<n> getDataList() {
        return this.mDataList;
    }

    public void Km(String str) {
        if (!x.isEmpty(this.mDataList)) {
            Iterator<n> it = this.mDataList.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if (next instanceof com.baidu.tieba.card.data.b) {
                    com.baidu.tieba.card.data.b bVar = (com.baidu.tieba.card.data.b) next;
                    if (bVar.bkV() != null && bVar.bkV().getTid() != null && bVar.bkV().getTid().equals(str)) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void Ll(String str) {
        if (this.kjw != null && !x.isEmpty(this.kjw.thread_list)) {
            long j = com.baidu.adp.lib.f.b.toLong(str, 0L);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.kjw.thread_list.size()) {
                    ThreadInfo threadInfo = this.kjw.thread_list.get(i2);
                    if (threadInfo == null || threadInfo.tid == null || threadInfo.tid.longValue() != j) {
                        i = i2 + 1;
                    } else {
                        this.kjw.thread_list.remove(i2);
                        a(this.kjw);
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void si(boolean z) {
        DataRes.Builder builder = new DataRes.Builder();
        if (x.getCount(this.jXR) >= 12) {
            if (z) {
                builder.thread_list = this.jXR.subList(this.jXR.size() - 12, this.jXR.size());
                a(builder, true);
            } else {
                builder.thread_list = this.jXR.subList(0, 12);
                a(builder, false);
            }
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.jXR);
            builder.thread_list = arrayList;
            a(builder, false);
        }
        this.kjw = builder;
        a(builder);
    }

    private void a(DataRes.Builder builder, boolean z) {
        if (builder != null) {
            if (x.getCount(this.kjv) >= 12) {
                if (z) {
                    builder.thread_personalized = this.kjv.subList(this.kjv.size() - 12, this.kjv.size());
                    return;
                } else {
                    builder.thread_personalized = this.kjv.subList(0, 12);
                    return;
                }
            }
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(this.kjv);
            builder.thread_personalized = linkedList;
        }
    }

    private void bkL() {
        ac.a(new ab<DataRes>() { // from class: com.baidu.tieba.homepage.video.b.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ab
            /* renamed from: cQx */
            public DataRes doInBackground() {
                l<byte[]> dK = com.baidu.tbadk.core.c.a.bpZ().dK("tb.video_tab", TbadkCoreApplication.getCurrentAccount());
                if (dK == null) {
                    return null;
                }
                byte[] bArr = dK.get(TbadkCoreApplication.getCurrentAccount());
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
                    b.this.kjw = new DataRes.Builder(dataRes);
                    int count = x.getCount(dataRes.thread_list);
                    if (count > 0) {
                        b.this.a(dataRes, false);
                        if (b.this.kju != null) {
                            b.this.kju.g(count, false, true);
                        }
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes, boolean z) {
        r(dataRes.thread_list, !z);
        s(dataRes.thread_personalized, z ? false : true);
        this.mDataList = cOs();
        com.baidu.tieba.homepage.video.b.a.z(this.kjv, this.mDataList);
    }

    private void s(List<ThreadPersonalized> list, boolean z) {
        if (!x.isEmpty(list)) {
            if (z) {
                LinkedList linkedList = new LinkedList();
                linkedList.addAll(list);
                linkedList.addAll(this.kjv);
                this.kjv.clear();
                this.kjv.addAll(linkedList);
                return;
            }
            this.kjv.addAll(list);
        }
    }

    private void r(List<ThreadInfo> list, boolean z) {
        if (!x.isEmpty(list)) {
            if (z) {
                LinkedList linkedList = new LinkedList();
                linkedList.addAll(list);
                linkedList.addAll(this.jXR);
                this.jXR.clear();
                this.jXR.addAll(linkedList);
                return;
            }
            this.jXR.addAll(list);
        }
    }

    private List<n> cOs() {
        int i;
        String format;
        LinkedList linkedList = new LinkedList();
        if (x.isEmpty(this.jXR)) {
            return linkedList;
        }
        int i2 = 0;
        for (ThreadInfo threadInfo : this.jXR) {
            bz bzVar = new bz();
            bzVar.a(threadInfo);
            bzVar.eRu = true;
            if (com.baidu.tieba.card.data.l.ad(bzVar)) {
                k aE = d.aE(bzVar);
                if (aE != null && aE.eHK != null && aE.eHK.bpo() != null && !StringUtils.isNull(aE.eHK.bpo().forumName)) {
                    aE.tid = bzVar.getTid();
                    aE.position = i2;
                    d.h(aE);
                    linkedList.add(aE);
                } else {
                    k aE2 = d.aE(bzVar);
                    if (aE2 != null) {
                        aE2.tid = bzVar.getTid();
                        aE2.position = i2;
                        d.a(aE2);
                    }
                    if (aE2 != null && aE2.isValid()) {
                        linkedList.add(aE2);
                    }
                }
                int[] imageWidthAndHeight = bzVar.getImageWidthAndHeight();
                final com.baidu.tieba.card.data.b aD = d.aD(bzVar);
                if (aD != null) {
                    aD.tid = bzVar.getTid();
                    aD.position = i2;
                    if (aD instanceof k) {
                        if (bzVar.bpv()) {
                            d.d(aD);
                        } else if (bzVar.boF() == 1) {
                            d.b(aD);
                            aD.eNX = imageWidthAndHeight[0];
                            aD.eNY = imageWidthAndHeight[1];
                        } else if (bzVar.boF() >= 2) {
                            d.c(aD);
                        } else {
                            d.e(aD);
                        }
                    } else if (aD instanceof com.baidu.tieba.card.data.l) {
                        d.f(aD);
                    }
                }
                if (aD != null && aD.isValid()) {
                    if (!bzVar.bmg() && bzVar.bnx() != null && bzVar.bpo() != null && !StringUtils.isNull(bzVar.bpo().forumName)) {
                        SpannableString spannableString = new SpannableString(String.format(TbadkCoreApplication.getInst().getString(R.string.at_username), bzVar.bnx().getName_show()));
                        spannableString.setSpan(new f(16, bzVar.bnx().getUserId()) { // from class: com.baidu.tieba.homepage.video.b.b.4
                            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                            public void onClick(View view) {
                                com.baidu.tieba.homepage.video.c.a.o(aD);
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(view.getContext(), getLink(), null)));
                            }
                        }, 0, format.length() - 1, 33);
                        aD.eHK.a(spannableString);
                    }
                    linkedList.add(aD);
                }
                if (threadInfo.top_agree_post != null) {
                    k aE3 = d.aE(bzVar);
                    if (aE3 != null) {
                        aE3.tid = bzVar.getTid();
                        aE3.position = i2;
                        d.i(aE3);
                    }
                    if (aE3 != null && aE3.isValid()) {
                        linkedList.add(aE3);
                    }
                }
                k aE4 = d.aE(bzVar);
                if (aE4 != null) {
                    aE4.tid = bzVar.getTid();
                    aE4.position = i2;
                    d.j(aE4);
                }
                if (aE4 != null && aE4.isValid()) {
                    linkedList.add(aE4);
                }
                i = i2 + 1;
            } else {
                i = i2;
            }
            i2 = i;
        }
        com.baidu.tbadk.a.a.a.bo(linkedList);
        return linkedList;
    }

    private void a(final DataRes.Builder builder) {
        ac.a(new ab<Object>() { // from class: com.baidu.tieba.homepage.video.b.b.5
            @Override // com.baidu.tbadk.util.ab
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                try {
                    com.baidu.tbadk.core.c.a.bpZ().dK("tb.video_tab", TbadkCoreApplication.getCurrentAccount()).setForever(TbadkCoreApplication.getCurrentAccount(), builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.kjx);
    }
}
