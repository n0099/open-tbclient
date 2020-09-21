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
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.util.m;
import com.baidu.tbadk.widget.richText.f;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.c;
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
/* loaded from: classes21.dex */
public class b {
    private boolean isLoading;
    private a jfc;
    private DataRes.Builder jfe;
    private TbPageContext mPageContext;
    private boolean hSK = true;
    private com.baidu.adp.framework.listener.a jff = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_VIDEO_TAB, 309648) { // from class: com.baidu.tieba.homepage.video.b.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            b.this.isLoading = false;
            b.this.hSK = false;
            if (responsedMessage != null) {
                b.this.h(responsedMessage);
            } else if (b.this.jfc != null) {
                b.this.jfc.l(-1, "", false);
            }
        }
    };
    private List<q> mDataList = new LinkedList();
    private List<ThreadInfo> iTq = new LinkedList();
    private List<ThreadPersonalized> jfd = new LinkedList();

    /* loaded from: classes21.dex */
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
                qd(z);
            }
        }
        if (this.jfc != null) {
            if (responsedMessage.getError() != 0) {
                this.jfc.l(responsedMessage.getError(), responsedMessage.getErrorString(), z);
            } else {
                this.jfc.g(i, z, false);
            }
        }
    }

    public b(TbPageContext tbPageContext, a aVar) {
        this.mPageContext = tbPageContext;
        this.jfc = aVar;
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
        MessageManager.getInstance().registerListener(this.jff);
    }

    public void cCU() {
        if (!this.isLoading) {
            this.isLoading = true;
            if (this.hSK) {
                bcQ();
                this.hSK = false;
            }
            VideoTabRequestMessage videoTabRequestMessage = new VideoTabRequestMessage();
            videoTabRequestMessage.new_net_type = j.netType();
            videoTabRequestMessage.load_type = 1;
            videoTabRequestMessage.page_thread_count = 12;
            videoTabRequestMessage.setNetType(NetMessage.NetType.HTTP);
            this.mPageContext.sendMessage(videoTabRequestMessage);
        }
    }

    public void csj() {
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

    public void Jm(String str) {
        if (!y.isEmpty(this.mDataList)) {
            Iterator<q> it = this.mDataList.iterator();
            while (it.hasNext()) {
                q next = it.next();
                if (next instanceof c) {
                    c cVar = (c) next;
                    if (cVar.bcY() != null && cVar.bcY().getTid() != null && cVar.bcY().getTid().equals(str)) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void Kh(String str) {
        if (this.jfe != null && !y.isEmpty(this.jfe.thread_list)) {
            long j = com.baidu.adp.lib.f.b.toLong(str, 0L);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.jfe.thread_list.size()) {
                    ThreadInfo threadInfo = this.jfe.thread_list.get(i2);
                    if (threadInfo == null || threadInfo.tid == null || threadInfo.tid.longValue() != j) {
                        i = i2 + 1;
                    } else {
                        this.jfe.thread_list.remove(i2);
                        a(this.jfe);
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void qd(boolean z) {
        DataRes.Builder builder = new DataRes.Builder();
        if (y.getCount(this.iTq) >= 12) {
            if (z) {
                builder.thread_list = this.iTq.subList(this.iTq.size() - 12, this.iTq.size());
                a(builder, true);
            } else {
                builder.thread_list = this.iTq.subList(0, 12);
                a(builder, false);
            }
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.iTq);
            builder.thread_list = arrayList;
            a(builder, false);
        }
        this.jfe = builder;
        a(builder);
    }

    private void a(DataRes.Builder builder, boolean z) {
        if (builder != null) {
            if (y.getCount(this.jfd) >= 12) {
                if (z) {
                    builder.thread_personalized = this.jfd.subList(this.jfd.size() - 12, this.jfd.size());
                    return;
                } else {
                    builder.thread_personalized = this.jfd.subList(0, 12);
                    return;
                }
            }
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(this.jfd);
            builder.thread_personalized = linkedList;
        }
    }

    private void bcQ() {
        ae.a(new ad<DataRes>() { // from class: com.baidu.tieba.homepage.video.b.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ad
            /* renamed from: cCV */
            public DataRes doInBackground() {
                l<byte[]> dv = com.baidu.tbadk.core.c.a.bhV().dv("tb.video_tab", TbadkCoreApplication.getCurrentAccount());
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
        }, new m<DataRes>() { // from class: com.baidu.tieba.homepage.video.b.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.m
            /* renamed from: a */
            public void onReturnDataInUI(DataRes dataRes) {
                if (dataRes != null) {
                    b.this.jfe = new DataRes.Builder(dataRes);
                    int count = y.getCount(dataRes.thread_list);
                    if (count > 0) {
                        b.this.a(dataRes, false);
                        if (b.this.jfc != null) {
                            b.this.jfc.g(count, false, true);
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
        this.mDataList = cAT();
        com.baidu.tieba.homepage.video.b.a.t(this.jfd, this.mDataList);
    }

    private void o(List<ThreadPersonalized> list, boolean z) {
        if (!y.isEmpty(list)) {
            if (z) {
                LinkedList linkedList = new LinkedList();
                linkedList.addAll(list);
                linkedList.addAll(this.jfd);
                this.jfd.clear();
                this.jfd.addAll(linkedList);
                return;
            }
            this.jfd.addAll(list);
        }
    }

    private void n(List<ThreadInfo> list, boolean z) {
        if (!y.isEmpty(list)) {
            if (z) {
                LinkedList linkedList = new LinkedList();
                linkedList.addAll(list);
                linkedList.addAll(this.iTq);
                this.iTq.clear();
                this.iTq.addAll(linkedList);
                return;
            }
            this.iTq.addAll(list);
        }
    }

    private List<q> cAT() {
        int i;
        String format;
        LinkedList linkedList = new LinkedList();
        if (y.isEmpty(this.iTq)) {
            return linkedList;
        }
        int i2 = 0;
        for (ThreadInfo threadInfo : this.iTq) {
            bw bwVar = new bw();
            bwVar.a(threadInfo);
            bwVar.egv = true;
            if (com.baidu.tieba.card.data.m.ab(bwVar)) {
                com.baidu.tieba.card.data.l aB = d.aB(bwVar);
                if (aB != null && aB.dXg != null && aB.dXg.bhm() != null && !StringUtils.isNull(aB.dXg.bhm().forumName)) {
                    aB.tid = bwVar.getTid();
                    aB.position = i2;
                    d.h(aB);
                    linkedList.add(aB);
                } else {
                    com.baidu.tieba.card.data.l aB2 = d.aB(bwVar);
                    if (aB2 != null) {
                        aB2.tid = bwVar.getTid();
                        aB2.position = i2;
                        d.a(aB2);
                    }
                    if (aB2 != null && aB2.isValid()) {
                        linkedList.add(aB2);
                    }
                }
                int[] imageWidthAndHeight = bwVar.getImageWidthAndHeight();
                final c aA = d.aA(bwVar);
                if (aA != null) {
                    aA.tid = bwVar.getTid();
                    aA.position = i2;
                    if (aA instanceof com.baidu.tieba.card.data.l) {
                        if (bwVar.bht()) {
                            d.d(aA);
                        } else if (bwVar.bgE() == 1) {
                            d.b(aA);
                            aA.edd = imageWidthAndHeight[0];
                            aA.ede = imageWidthAndHeight[1];
                        } else if (bwVar.bgE() >= 2) {
                            d.c(aA);
                        } else {
                            d.e(aA);
                        }
                    } else if (aA instanceof com.baidu.tieba.card.data.m) {
                        d.f(aA);
                    }
                }
                if (aA != null && aA.isValid()) {
                    if (!bwVar.bei() && bwVar.bfy() != null && bwVar.bhm() != null && !StringUtils.isNull(bwVar.bhm().forumName)) {
                        SpannableString spannableString = new SpannableString(String.format(TbadkCoreApplication.getInst().getString(R.string.at_username), bwVar.bfy().getName_show()));
                        spannableString.setSpan(new f(16, bwVar.bfy().getUserId()) { // from class: com.baidu.tieba.homepage.video.b.b.4
                            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                            public void onClick(View view) {
                                com.baidu.tieba.homepage.video.c.a.o(aA);
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(view.getContext(), getLink(), null)));
                            }
                        }, 0, format.length() - 1, 33);
                        aA.dXg.a(spannableString);
                    }
                    linkedList.add(aA);
                }
                if (threadInfo.top_agree_post != null) {
                    com.baidu.tieba.card.data.l aB3 = d.aB(bwVar);
                    if (aB3 != null) {
                        aB3.tid = bwVar.getTid();
                        aB3.position = i2;
                        d.i(aB3);
                    }
                    if (aB3 != null && aB3.isValid()) {
                        linkedList.add(aB3);
                    }
                }
                com.baidu.tieba.card.data.l aB4 = d.aB(bwVar);
                if (aB4 != null) {
                    aB4.tid = bwVar.getTid();
                    aB4.position = i2;
                    d.j(aB4);
                }
                if (aB4 != null && aB4.isValid()) {
                    linkedList.add(aB4);
                }
                i = i2 + 1;
            } else {
                i = i2;
            }
            i2 = i;
        }
        com.baidu.tbadk.a.a.a.aK(linkedList);
        return linkedList;
    }

    private void a(final DataRes.Builder builder) {
        ae.a(new ad<Object>() { // from class: com.baidu.tieba.homepage.video.b.b.5
            @Override // com.baidu.tbadk.util.ad
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                try {
                    com.baidu.tbadk.core.c.a.bhV().dv("tb.video_tab", TbadkCoreApplication.getCurrentAccount()).setForever(TbadkCoreApplication.getCurrentAccount(), builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.jff);
    }
}
