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
import com.baidu.adp.widget.ListView.o;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.v;
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
    private a ijx;
    private DataRes.Builder ijz;
    private boolean isLoading;
    private TbPageContext mPageContext;
    private boolean hgh = true;
    private com.baidu.adp.framework.listener.a ijA = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_VIDEO_TAB, 309648) { // from class: com.baidu.tieba.homepage.video.b.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            b.this.isLoading = false;
            b.this.hgh = false;
            if (responsedMessage != null) {
                b.this.h(responsedMessage);
            } else if (b.this.ijx != null) {
                b.this.ijx.m(-1, "", false);
            }
        }
    };
    private List<o> mDataList = new LinkedList();
    private List<ThreadInfo> iaZ = new LinkedList();
    private List<ThreadPersonalized> ijy = new LinkedList();

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
                oy(z);
            }
        }
        if (this.ijx != null) {
            if (responsedMessage.getError() != 0) {
                this.ijx.m(responsedMessage.getError(), responsedMessage.getErrorString(), z);
            } else {
                this.ijx.f(i, z, false);
            }
        }
    }

    public b(TbPageContext tbPageContext, a aVar) {
        this.mPageContext = tbPageContext;
        this.ijx = aVar;
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(309648);
        bVar.setResponsedClass(VideoTabSocketResMessage.class);
        bVar.setNeedAck(true);
        MessageManager.getInstance().registerTask(bVar);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_VIDEO_TAB, com.baidu.tieba.tbadkCore.a.a.bF(TbConfig.URL_VIDEO_TAB, 309648));
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setResponsedClass(VideoTabHttpResMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void registerListener() {
        MessageManager.getInstance().registerListener(this.ijA);
    }

    public void cgX() {
        if (!this.isLoading) {
            this.isLoading = true;
            if (this.hgh) {
                aOa();
                this.hgh = false;
            }
            VideoTabRequestMessage videoTabRequestMessage = new VideoTabRequestMessage();
            videoTabRequestMessage.new_net_type = j.netType();
            videoTabRequestMessage.load_type = 1;
            videoTabRequestMessage.page_thread_count = 12;
            videoTabRequestMessage.setNetType(NetMessage.NetType.HTTP);
            this.mPageContext.sendMessage(videoTabRequestMessage);
        }
    }

    public void bXF() {
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

    public List<o> getDataList() {
        return this.mDataList;
    }

    public void EY(String str) {
        if (!v.isEmpty(this.mDataList)) {
            Iterator<o> it = this.mDataList.iterator();
            while (it.hasNext()) {
                o next = it.next();
                if (next instanceof c) {
                    c cVar = (c) next;
                    if (cVar.aOi() != null && cVar.aOi().getTid() != null && cVar.aOi().getTid().equals(str)) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void FB(String str) {
        if (this.ijz != null && !v.isEmpty(this.ijz.thread_list)) {
            long j = com.baidu.adp.lib.f.b.toLong(str, 0L);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.ijz.thread_list.size()) {
                    ThreadInfo threadInfo = this.ijz.thread_list.get(i2);
                    if (threadInfo == null || threadInfo.tid == null || threadInfo.tid.longValue() != j) {
                        i = i2 + 1;
                    } else {
                        this.ijz.thread_list.remove(i2);
                        a(this.ijz);
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void oy(boolean z) {
        DataRes.Builder builder = new DataRes.Builder();
        if (v.getCount(this.iaZ) >= 12) {
            if (z) {
                builder.thread_list = this.iaZ.subList(this.iaZ.size() - 12, this.iaZ.size());
                a(builder, true);
            } else {
                builder.thread_list = this.iaZ.subList(0, 12);
                a(builder, false);
            }
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.iaZ);
            builder.thread_list = arrayList;
            a(builder, false);
        }
        this.ijz = builder;
        a(builder);
    }

    private void a(DataRes.Builder builder, boolean z) {
        if (builder != null) {
            if (v.getCount(this.ijy) >= 12) {
                if (z) {
                    builder.thread_personalized = this.ijy.subList(this.ijy.size() - 12, this.ijy.size());
                    return;
                } else {
                    builder.thread_personalized = this.ijy.subList(0, 12);
                    return;
                }
            }
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(this.ijy);
            builder.thread_personalized = linkedList;
        }
    }

    private void aOa() {
        ad.a(new ac<DataRes>() { // from class: com.baidu.tieba.homepage.video.b.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ac
            /* renamed from: cgY */
            public DataRes doInBackground() {
                l<byte[]> cZ = com.baidu.tbadk.core.c.a.aSS().cZ("tb.video_tab", TbadkCoreApplication.getCurrentAccount());
                if (cZ == null) {
                    return null;
                }
                byte[] bArr = cZ.get(TbadkCoreApplication.getCurrentAccount());
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
                    b.this.ijz = new DataRes.Builder(dataRes);
                    int count = v.getCount(dataRes.thread_list);
                    if (count > 0) {
                        b.this.a(dataRes, false);
                        if (b.this.ijx != null) {
                            b.this.ijx.f(count, false, true);
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
        this.mDataList = cfu();
        com.baidu.tieba.homepage.video.b.a.o(this.ijy, this.mDataList);
    }

    private void q(List<ThreadPersonalized> list, boolean z) {
        if (!v.isEmpty(list)) {
            if (z) {
                LinkedList linkedList = new LinkedList();
                linkedList.addAll(list);
                linkedList.addAll(this.ijy);
                this.ijy.clear();
                this.ijy.addAll(linkedList);
                return;
            }
            this.ijy.addAll(list);
        }
    }

    private void p(List<ThreadInfo> list, boolean z) {
        if (!v.isEmpty(list)) {
            if (z) {
                LinkedList linkedList = new LinkedList();
                linkedList.addAll(list);
                linkedList.addAll(this.iaZ);
                this.iaZ.clear();
                this.iaZ.addAll(linkedList);
                return;
            }
            this.iaZ.addAll(list);
        }
    }

    private List<o> cfu() {
        int i;
        String format;
        LinkedList linkedList = new LinkedList();
        if (v.isEmpty(this.iaZ)) {
            return linkedList;
        }
        int i2 = 0;
        for (ThreadInfo threadInfo : this.iaZ) {
            bk bkVar = new bk();
            bkVar.a(threadInfo);
            bkVar.dHO = true;
            if (com.baidu.tieba.card.data.l.ac(bkVar)) {
                k aC = d.aC(bkVar);
                if (aC != null && aC.dEA != null && aC.dEA.aSm() != null && !StringUtils.isNull(aC.dEA.aSm().forumName)) {
                    aC.tid = bkVar.getTid();
                    aC.position = i2;
                    d.h(aC);
                    linkedList.add(aC);
                } else {
                    k aC2 = d.aC(bkVar);
                    if (aC2 != null) {
                        aC2.tid = bkVar.getTid();
                        aC2.position = i2;
                        d.a(aC2);
                    }
                    if (aC2 != null && aC2.isValid()) {
                        linkedList.add(aC2);
                    }
                }
                int[] imageWidthAndHeight = bkVar.getImageWidthAndHeight();
                final c aB = d.aB(bkVar);
                if (aB != null) {
                    aB.tid = bkVar.getTid();
                    aB.position = i2;
                    if (aB instanceof k) {
                        if (bkVar.aSv()) {
                            d.d(aB);
                        } else if (bkVar.aRE() == 1) {
                            d.b(aB);
                            aB.dEB = imageWidthAndHeight[0];
                            aB.dEC = imageWidthAndHeight[1];
                        } else if (bkVar.aRE() >= 2) {
                            d.c(aB);
                        } else {
                            d.e(aB);
                        }
                    } else if (aB instanceof com.baidu.tieba.card.data.l) {
                        d.f(aB);
                    }
                }
                if (aB != null && aB.isValid()) {
                    if (!bkVar.aSx() && bkVar.aQx() != null && bkVar.aSm() != null && !StringUtils.isNull(bkVar.aSm().forumName)) {
                        SpannableString spannableString = new SpannableString(String.format(TbadkCoreApplication.getInst().getString(R.string.at_username), bkVar.aQx().getName_show()));
                        spannableString.setSpan(new f(16, bkVar.aQx().getUserId()) { // from class: com.baidu.tieba.homepage.video.b.b.4
                            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                            public void onClick(View view) {
                                com.baidu.tieba.homepage.video.c.a.l(aB);
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(view.getContext(), getLink(), null)));
                            }
                        }, 0, format.length() - 1, 33);
                        aB.dEA.a(spannableString);
                    }
                    linkedList.add(aB);
                }
                if (threadInfo.top_agree_post != null) {
                    k aC3 = d.aC(bkVar);
                    if (aC3 != null) {
                        aC3.tid = bkVar.getTid();
                        aC3.position = i2;
                        d.i(aC3);
                    }
                    if (aC3 != null && aC3.isValid()) {
                        linkedList.add(aC3);
                    }
                }
                k aC4 = d.aC(bkVar);
                if (aC4 != null) {
                    aC4.tid = bkVar.getTid();
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
                    com.baidu.tbadk.core.c.a.aSS().cZ("tb.video_tab", TbadkCoreApplication.getCurrentAccount()).setForever(TbadkCoreApplication.getCurrentAccount(), builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.ijA);
    }
}
