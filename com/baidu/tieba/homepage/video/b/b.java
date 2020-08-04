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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.x;
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
/* loaded from: classes16.dex */
public class b {
    private a iHs;
    private DataRes.Builder iHu;
    private boolean isLoading;
    private TbPageContext mPageContext;
    private boolean hyo = true;
    private com.baidu.adp.framework.listener.a iHv = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_VIDEO_TAB, 309648) { // from class: com.baidu.tieba.homepage.video.b.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            b.this.isLoading = false;
            b.this.hyo = false;
            if (responsedMessage != null) {
                b.this.h(responsedMessage);
            } else if (b.this.iHs != null) {
                b.this.iHs.m(-1, "", false);
            }
        }
    };
    private List<q> mDataList = new LinkedList();
    private List<ThreadInfo> iwp = new LinkedList();
    private List<ThreadPersonalized> iHt = new LinkedList();

    /* loaded from: classes16.dex */
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
        if (dataRes == null || x.getCount(dataRes.thread_list) <= 0) {
            i = 0;
        } else {
            i = x.getCount(dataRes.thread_list);
            a(dataRes, z);
            if (!x.isEmpty(dataRes.thread_list)) {
                pn(z);
            }
        }
        if (this.iHs != null) {
            if (responsedMessage.getError() != 0) {
                this.iHs.m(responsedMessage.getError(), responsedMessage.getErrorString(), z);
            } else {
                this.iHs.f(i, z, false);
            }
        }
    }

    public b(TbPageContext tbPageContext, a aVar) {
        this.mPageContext = tbPageContext;
        this.iHs = aVar;
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(309648);
        bVar.setResponsedClass(VideoTabSocketResMessage.class);
        bVar.setNeedAck(true);
        MessageManager.getInstance().registerTask(bVar);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_VIDEO_TAB, com.baidu.tieba.tbadkCore.a.a.bC(TbConfig.URL_VIDEO_TAB, 309648));
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setResponsedClass(VideoTabHttpResMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void registerListener() {
        MessageManager.getInstance().registerListener(this.iHv);
    }

    public void cot() {
        if (!this.isLoading) {
            this.isLoading = true;
            if (this.hyo) {
                aTF();
                this.hyo = false;
            }
            VideoTabRequestMessage videoTabRequestMessage = new VideoTabRequestMessage();
            videoTabRequestMessage.new_net_type = j.netType();
            videoTabRequestMessage.load_type = 1;
            videoTabRequestMessage.page_thread_count = 12;
            videoTabRequestMessage.setNetType(NetMessage.NetType.HTTP);
            this.mPageContext.sendMessage(videoTabRequestMessage);
        }
    }

    public void cer() {
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
        if (this.iHu != null && !x.isEmpty(this.iHu.thread_list)) {
            long j = com.baidu.adp.lib.f.b.toLong(str, 0L);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.iHu.thread_list.size()) {
                    ThreadInfo threadInfo = this.iHu.thread_list.get(i2);
                    if (threadInfo == null || threadInfo.tid == null || threadInfo.tid.longValue() != j) {
                        i = i2 + 1;
                    } else {
                        this.iHu.thread_list.remove(i2);
                        a(this.iHu);
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void pn(boolean z) {
        DataRes.Builder builder = new DataRes.Builder();
        if (x.getCount(this.iwp) >= 12) {
            if (z) {
                builder.thread_list = this.iwp.subList(this.iwp.size() - 12, this.iwp.size());
                a(builder, true);
            } else {
                builder.thread_list = this.iwp.subList(0, 12);
                a(builder, false);
            }
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.iwp);
            builder.thread_list = arrayList;
            a(builder, false);
        }
        this.iHu = builder;
        a(builder);
    }

    private void a(DataRes.Builder builder, boolean z) {
        if (builder != null) {
            if (x.getCount(this.iHt) >= 12) {
                if (z) {
                    builder.thread_personalized = this.iHt.subList(this.iHt.size() - 12, this.iHt.size());
                    return;
                } else {
                    builder.thread_personalized = this.iHt.subList(0, 12);
                    return;
                }
            }
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(this.iHt);
            builder.thread_personalized = linkedList;
        }
    }

    private void aTF() {
        ad.a(new ac<DataRes>() { // from class: com.baidu.tieba.homepage.video.b.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ac
            /* renamed from: cou */
            public DataRes doInBackground() {
                l<byte[]> df = com.baidu.tbadk.core.c.a.aYG().df("tb.video_tab", TbadkCoreApplication.getCurrentAccount());
                if (df == null) {
                    return null;
                }
                byte[] bArr = df.get(TbadkCoreApplication.getCurrentAccount());
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
                    b.this.iHu = new DataRes.Builder(dataRes);
                    int count = x.getCount(dataRes.thread_list);
                    if (count > 0) {
                        b.this.a(dataRes, false);
                        if (b.this.iHs != null) {
                            b.this.iHs.f(count, false, true);
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
        this.mDataList = cmB();
        com.baidu.tieba.homepage.video.b.a.p(this.iHt, this.mDataList);
    }

    private void o(List<ThreadPersonalized> list, boolean z) {
        if (!x.isEmpty(list)) {
            if (z) {
                LinkedList linkedList = new LinkedList();
                linkedList.addAll(list);
                linkedList.addAll(this.iHt);
                this.iHt.clear();
                this.iHt.addAll(linkedList);
                return;
            }
            this.iHt.addAll(list);
        }
    }

    private void n(List<ThreadInfo> list, boolean z) {
        if (!x.isEmpty(list)) {
            if (z) {
                LinkedList linkedList = new LinkedList();
                linkedList.addAll(list);
                linkedList.addAll(this.iwp);
                this.iwp.clear();
                this.iwp.addAll(linkedList);
                return;
            }
            this.iwp.addAll(list);
        }
    }

    private List<q> cmB() {
        int i;
        String format;
        LinkedList linkedList = new LinkedList();
        if (x.isEmpty(this.iwp)) {
            return linkedList;
        }
        int i2 = 0;
        for (ThreadInfo threadInfo : this.iwp) {
            bv bvVar = new bv();
            bvVar.a(threadInfo);
            bvVar.dUL = true;
            if (com.baidu.tieba.card.data.l.aa(bvVar)) {
                k az = d.az(bvVar);
                if (az != null && az.dLK != null && az.dLK.aXZ() != null && !StringUtils.isNull(az.dLK.aXZ().forumName)) {
                    az.tid = bvVar.getTid();
                    az.position = i2;
                    d.h(az);
                    linkedList.add(az);
                } else {
                    k az2 = d.az(bvVar);
                    if (az2 != null) {
                        az2.tid = bvVar.getTid();
                        az2.position = i2;
                        d.a(az2);
                    }
                    if (az2 != null && az2.isValid()) {
                        linkedList.add(az2);
                    }
                }
                int[] imageWidthAndHeight = bvVar.getImageWidthAndHeight();
                final c ay = d.ay(bvVar);
                if (ay != null) {
                    ay.tid = bvVar.getTid();
                    ay.position = i2;
                    if (ay instanceof k) {
                        if (bvVar.aYg()) {
                            d.d(ay);
                        } else if (bvVar.aXr() == 1) {
                            d.b(ay);
                            ay.dRu = imageWidthAndHeight[0];
                            ay.dRv = imageWidthAndHeight[1];
                        } else if (bvVar.aXr() >= 2) {
                            d.c(ay);
                        } else {
                            d.e(ay);
                        }
                    } else if (ay instanceof com.baidu.tieba.card.data.l) {
                        d.f(ay);
                    }
                }
                if (ay != null && ay.isValid()) {
                    if (!bvVar.aUV() && bvVar.aWl() != null && bvVar.aXZ() != null && !StringUtils.isNull(bvVar.aXZ().forumName)) {
                        SpannableString spannableString = new SpannableString(String.format(TbadkCoreApplication.getInst().getString(R.string.at_username), bvVar.aWl().getName_show()));
                        spannableString.setSpan(new f(16, bvVar.aWl().getUserId()) { // from class: com.baidu.tieba.homepage.video.b.b.4
                            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                            public void onClick(View view) {
                                com.baidu.tieba.homepage.video.c.a.o(ay);
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(view.getContext(), getLink(), null)));
                            }
                        }, 0, format.length() - 1, 33);
                        ay.dLK.a(spannableString);
                    }
                    linkedList.add(ay);
                }
                if (threadInfo.top_agree_post != null) {
                    k az3 = d.az(bvVar);
                    if (az3 != null) {
                        az3.tid = bvVar.getTid();
                        az3.position = i2;
                        d.i(az3);
                    }
                    if (az3 != null && az3.isValid()) {
                        linkedList.add(az3);
                    }
                }
                k az4 = d.az(bvVar);
                if (az4 != null) {
                    az4.tid = bvVar.getTid();
                    az4.position = i2;
                    d.j(az4);
                }
                if (az4 != null && az4.isValid()) {
                    linkedList.add(az4);
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
                    com.baidu.tbadk.core.c.a.aYG().df("tb.video_tab", TbadkCoreApplication.getCurrentAccount()).setForever(TbadkCoreApplication.getCurrentAccount(), builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.iHv);
    }
}
