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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.widget.richText.f;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.c;
import com.baidu.tieba.card.data.m;
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
/* loaded from: classes16.dex */
public class b {
    private a iWq;
    private DataRes.Builder iWs;
    private boolean isLoading;
    private TbPageContext mPageContext;
    private boolean hLD = true;
    private com.baidu.adp.framework.listener.a iWt = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_VIDEO_TAB, 309648) { // from class: com.baidu.tieba.homepage.video.b.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            b.this.isLoading = false;
            b.this.hLD = false;
            if (responsedMessage != null) {
                b.this.h(responsedMessage);
            } else if (b.this.iWq != null) {
                b.this.iWq.l(-1, "", false);
            }
        }
    };
    private List<q> mDataList = new LinkedList();
    private List<ThreadInfo> iKE = new LinkedList();
    private List<ThreadPersonalized> iWr = new LinkedList();

    /* loaded from: classes16.dex */
    public interface a {
        void g(int i, boolean z, boolean z2);

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
        if (dataRes == null || y.getCount(dataRes.thread_list) <= 0) {
            i = 0;
        } else {
            i = y.getCount(dataRes.thread_list);
            a(dataRes, z);
            if (!y.isEmpty(dataRes.thread_list)) {
                pT(z);
            }
        }
        if (this.iWq != null) {
            if (responsedMessage.getError() != 0) {
                this.iWq.l(responsedMessage.getError(), responsedMessage.getErrorString(), z);
            } else {
                this.iWq.g(i, z, false);
            }
        }
    }

    public b(TbPageContext tbPageContext, a aVar) {
        this.mPageContext = tbPageContext;
        this.iWq = aVar;
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(309648);
        bVar.setResponsedClass(VideoTabSocketResMessage.class);
        bVar.setNeedAck(true);
        MessageManager.getInstance().registerTask(bVar);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_VIDEO_TAB, com.baidu.tieba.tbadkCore.a.a.bH(TbConfig.URL_VIDEO_TAB, 309648));
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setResponsedClass(VideoTabHttpResMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void registerListener() {
        MessageManager.getInstance().registerListener(this.iWt);
    }

    public void czm() {
        if (!this.isLoading) {
            this.isLoading = true;
            if (this.hLD) {
                bbW();
                this.hLD = false;
            }
            VideoTabRequestMessage videoTabRequestMessage = new VideoTabRequestMessage();
            videoTabRequestMessage.new_net_type = j.netType();
            videoTabRequestMessage.load_type = 1;
            videoTabRequestMessage.page_thread_count = 12;
            videoTabRequestMessage.setNetType(NetMessage.NetType.HTTP);
            this.mPageContext.sendMessage(videoTabRequestMessage);
        }
    }

    public void coV() {
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

    public void IN(String str) {
        if (!y.isEmpty(this.mDataList)) {
            Iterator<q> it = this.mDataList.iterator();
            while (it.hasNext()) {
                q next = it.next();
                if (next instanceof c) {
                    c cVar = (c) next;
                    if (cVar.bce() != null && cVar.bce().getTid() != null && cVar.bce().getTid().equals(str)) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void JE(String str) {
        if (this.iWs != null && !y.isEmpty(this.iWs.thread_list)) {
            long j = com.baidu.adp.lib.f.b.toLong(str, 0L);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.iWs.thread_list.size()) {
                    ThreadInfo threadInfo = this.iWs.thread_list.get(i2);
                    if (threadInfo == null || threadInfo.tid == null || threadInfo.tid.longValue() != j) {
                        i = i2 + 1;
                    } else {
                        this.iWs.thread_list.remove(i2);
                        a(this.iWs);
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void pT(boolean z) {
        DataRes.Builder builder = new DataRes.Builder();
        if (y.getCount(this.iKE) >= 12) {
            if (z) {
                builder.thread_list = this.iKE.subList(this.iKE.size() - 12, this.iKE.size());
                a(builder, true);
            } else {
                builder.thread_list = this.iKE.subList(0, 12);
                a(builder, false);
            }
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.iKE);
            builder.thread_list = arrayList;
            a(builder, false);
        }
        this.iWs = builder;
        a(builder);
    }

    private void a(DataRes.Builder builder, boolean z) {
        if (builder != null) {
            if (y.getCount(this.iWr) >= 12) {
                if (z) {
                    builder.thread_personalized = this.iWr.subList(this.iWr.size() - 12, this.iWr.size());
                    return;
                } else {
                    builder.thread_personalized = this.iWr.subList(0, 12);
                    return;
                }
            }
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(this.iWr);
            builder.thread_personalized = linkedList;
        }
    }

    private void bbW() {
        ad.a(new ac<DataRes>() { // from class: com.baidu.tieba.homepage.video.b.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ac
            /* renamed from: czn */
            public DataRes doInBackground() {
                l<byte[]> dv = com.baidu.tbadk.core.c.a.bhb().dv("tb.video_tab", TbadkCoreApplication.getCurrentAccount());
                if (dv == null) {
                    return null;
                }
                byte[] bArr = dv.get(TbadkCoreApplication.getCurrentAccount());
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
                    b.this.iWs = new DataRes.Builder(dataRes);
                    int count = y.getCount(dataRes.thread_list);
                    if (count > 0) {
                        b.this.a(dataRes, false);
                        if (b.this.iWq != null) {
                            b.this.iWq.g(count, false, true);
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
        this.mDataList = cxk();
        com.baidu.tieba.homepage.video.b.a.s(this.iWr, this.mDataList);
    }

    private void o(List<ThreadPersonalized> list, boolean z) {
        if (!y.isEmpty(list)) {
            if (z) {
                LinkedList linkedList = new LinkedList();
                linkedList.addAll(list);
                linkedList.addAll(this.iWr);
                this.iWr.clear();
                this.iWr.addAll(linkedList);
                return;
            }
            this.iWr.addAll(list);
        }
    }

    private void n(List<ThreadInfo> list, boolean z) {
        if (!y.isEmpty(list)) {
            if (z) {
                LinkedList linkedList = new LinkedList();
                linkedList.addAll(list);
                linkedList.addAll(this.iKE);
                this.iKE.clear();
                this.iKE.addAll(linkedList);
                return;
            }
            this.iKE.addAll(list);
        }
    }

    private List<q> cxk() {
        int i;
        String format;
        LinkedList linkedList = new LinkedList();
        if (y.isEmpty(this.iKE)) {
            return linkedList;
        }
        int i2 = 0;
        for (ThreadInfo threadInfo : this.iKE) {
            bw bwVar = new bw();
            bwVar.a(threadInfo);
            bwVar.eeh = true;
            if (m.aa(bwVar)) {
                com.baidu.tieba.card.data.l aA = d.aA(bwVar);
                if (aA != null && aA.dUS != null && aA.dUS.bgs() != null && !StringUtils.isNull(aA.dUS.bgs().forumName)) {
                    aA.tid = bwVar.getTid();
                    aA.position = i2;
                    d.h(aA);
                    linkedList.add(aA);
                } else {
                    com.baidu.tieba.card.data.l aA2 = d.aA(bwVar);
                    if (aA2 != null) {
                        aA2.tid = bwVar.getTid();
                        aA2.position = i2;
                        d.a(aA2);
                    }
                    if (aA2 != null && aA2.isValid()) {
                        linkedList.add(aA2);
                    }
                }
                int[] imageWidthAndHeight = bwVar.getImageWidthAndHeight();
                final c az = d.az(bwVar);
                if (az != null) {
                    az.tid = bwVar.getTid();
                    az.position = i2;
                    if (az instanceof com.baidu.tieba.card.data.l) {
                        if (bwVar.bgz()) {
                            d.d(az);
                        } else if (bwVar.bfK() == 1) {
                            d.b(az);
                            az.eaP = imageWidthAndHeight[0];
                            az.eaQ = imageWidthAndHeight[1];
                        } else if (bwVar.bfK() >= 2) {
                            d.c(az);
                        } else {
                            d.e(az);
                        }
                    } else if (az instanceof m) {
                        d.f(az);
                    }
                }
                if (az != null && az.isValid()) {
                    if (!bwVar.bdo() && bwVar.beE() != null && bwVar.bgs() != null && !StringUtils.isNull(bwVar.bgs().forumName)) {
                        SpannableString spannableString = new SpannableString(String.format(TbadkCoreApplication.getInst().getString(R.string.at_username), bwVar.beE().getName_show()));
                        spannableString.setSpan(new f(16, bwVar.beE().getUserId()) { // from class: com.baidu.tieba.homepage.video.b.b.4
                            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                            public void onClick(View view) {
                                com.baidu.tieba.homepage.video.c.a.o(az);
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(view.getContext(), getLink(), null)));
                            }
                        }, 0, format.length() - 1, 33);
                        az.dUS.a(spannableString);
                    }
                    linkedList.add(az);
                }
                if (threadInfo.top_agree_post != null) {
                    com.baidu.tieba.card.data.l aA3 = d.aA(bwVar);
                    if (aA3 != null) {
                        aA3.tid = bwVar.getTid();
                        aA3.position = i2;
                        d.i(aA3);
                    }
                    if (aA3 != null && aA3.isValid()) {
                        linkedList.add(aA3);
                    }
                }
                com.baidu.tieba.card.data.l aA4 = d.aA(bwVar);
                if (aA4 != null) {
                    aA4.tid = bwVar.getTid();
                    aA4.position = i2;
                    d.j(aA4);
                }
                if (aA4 != null && aA4.isValid()) {
                    linkedList.add(aA4);
                }
                i = i2 + 1;
            } else {
                i = i2;
            }
            i2 = i;
        }
        com.baidu.tbadk.a.a.a.aG(linkedList);
        return linkedList;
    }

    private void a(final DataRes.Builder builder) {
        ad.a(new ac<Object>() { // from class: com.baidu.tieba.homepage.video.b.b.5
            @Override // com.baidu.tbadk.util.ac
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                try {
                    com.baidu.tbadk.core.c.a.bhb().dv("tb.video_tab", TbadkCoreApplication.getCurrentAccount()).setForever(TbadkCoreApplication.getCurrentAccount(), builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.iWt);
    }
}
