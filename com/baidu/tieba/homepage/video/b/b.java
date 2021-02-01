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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.util.af;
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
/* loaded from: classes2.dex */
public class b {
    private boolean isLoading;
    private a krB;
    private DataRes.Builder krD;
    private TbPageContext mPageContext;
    private boolean iYY = true;
    private com.baidu.adp.framework.listener.a krE = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_VIDEO_TAB, 309648) { // from class: com.baidu.tieba.homepage.video.b.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            b.this.isLoading = false;
            b.this.iYY = false;
            if (responsedMessage != null) {
                b.this.h(responsedMessage);
            } else if (b.this.krB != null) {
                b.this.krB.n(-1, "", false);
            }
        }
    };
    private List<n> mDataList = new LinkedList();
    private List<ThreadInfo> kft = new LinkedList();
    private List<ThreadPersonalized> krC = new LinkedList();

    /* loaded from: classes2.dex */
    public interface a {
        void g(int i, boolean z, boolean z2);

        void n(int i, String str, boolean z);
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
                sv(z);
            }
        }
        if (this.krB != null) {
            if (responsedMessage.getError() != 0) {
                this.krB.n(responsedMessage.getError(), responsedMessage.getErrorString(), z);
            } else {
                this.krB.g(i, z, false);
            }
        }
    }

    public b(TbPageContext tbPageContext, a aVar) {
        this.mPageContext = tbPageContext;
        this.krB = aVar;
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
        MessageManager.getInstance().registerListener(this.krE);
    }

    public void cSv() {
        if (!this.isLoading) {
            this.isLoading = true;
            if (this.iYY) {
                bld();
                this.iYY = false;
            }
            VideoTabRequestMessage videoTabRequestMessage = new VideoTabRequestMessage();
            videoTabRequestMessage.new_net_type = j.netType();
            videoTabRequestMessage.load_type = 1;
            videoTabRequestMessage.page_thread_count = 12;
            videoTabRequestMessage.setNetType(NetMessage.NetType.HTTP);
            this.mPageContext.sendMessage(videoTabRequestMessage);
        }
    }

    public void cFy() {
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

    public void KX(String str) {
        if (!y.isEmpty(this.mDataList)) {
            Iterator<n> it = this.mDataList.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if (next instanceof com.baidu.tieba.card.data.b) {
                    com.baidu.tieba.card.data.b bVar = (com.baidu.tieba.card.data.b) next;
                    if (bVar.bln() != null && bVar.bln().getTid() != null && bVar.bln().getTid().equals(str)) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void LV(String str) {
        if (this.krD != null && !y.isEmpty(this.krD.thread_list)) {
            long j = com.baidu.adp.lib.f.b.toLong(str, 0L);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.krD.thread_list.size()) {
                    ThreadInfo threadInfo = this.krD.thread_list.get(i2);
                    if (threadInfo == null || threadInfo.tid == null || threadInfo.tid.longValue() != j) {
                        i = i2 + 1;
                    } else {
                        this.krD.thread_list.remove(i2);
                        a(this.krD);
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void sv(boolean z) {
        DataRes.Builder builder = new DataRes.Builder();
        if (y.getCount(this.kft) >= 12) {
            if (z) {
                builder.thread_list = this.kft.subList(this.kft.size() - 12, this.kft.size());
                a(builder, true);
            } else {
                builder.thread_list = this.kft.subList(0, 12);
                a(builder, false);
            }
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.kft);
            builder.thread_list = arrayList;
            a(builder, false);
        }
        this.krD = builder;
        a(builder);
    }

    private void a(DataRes.Builder builder, boolean z) {
        if (builder != null) {
            if (y.getCount(this.krC) >= 12) {
                if (z) {
                    builder.thread_personalized = this.krC.subList(this.krC.size() - 12, this.krC.size());
                    return;
                } else {
                    builder.thread_personalized = this.krC.subList(0, 12);
                    return;
                }
            }
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(this.krC);
            builder.thread_personalized = linkedList;
        }
    }

    private void bld() {
        af.a(new ae<DataRes>() { // from class: com.baidu.tieba.homepage.video.b.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ae
            /* renamed from: cSw */
            public DataRes doInBackground() {
                l<byte[]> dE = com.baidu.tbadk.core.c.a.bqr().dE("tb.video_tab", TbadkCoreApplication.getCurrentAccount());
                if (dE == null) {
                    return null;
                }
                byte[] bArr = dE.get(TbadkCoreApplication.getCurrentAccount());
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
                    b.this.krD = new DataRes.Builder(dataRes);
                    int count = y.getCount(dataRes.thread_list);
                    if (count > 0) {
                        b.this.a(dataRes, false);
                        if (b.this.krB != null) {
                            b.this.krB.g(count, false, true);
                        }
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes, boolean z) {
        s(dataRes.thread_list, !z);
        t(dataRes.thread_personalized, z ? false : true);
        this.mDataList = cQp();
        com.baidu.tieba.homepage.video.b.a.y(this.krC, this.mDataList);
    }

    private void t(List<ThreadPersonalized> list, boolean z) {
        if (!y.isEmpty(list)) {
            if (z) {
                LinkedList linkedList = new LinkedList();
                linkedList.addAll(list);
                linkedList.addAll(this.krC);
                this.krC.clear();
                this.krC.addAll(linkedList);
                return;
            }
            this.krC.addAll(list);
        }
    }

    private void s(List<ThreadInfo> list, boolean z) {
        if (!y.isEmpty(list)) {
            if (z) {
                LinkedList linkedList = new LinkedList();
                linkedList.addAll(list);
                linkedList.addAll(this.kft);
                this.kft.clear();
                this.kft.addAll(linkedList);
                return;
            }
            this.kft.addAll(list);
        }
    }

    private List<n> cQp() {
        int i;
        String format;
        LinkedList linkedList = new LinkedList();
        if (y.isEmpty(this.kft)) {
            return linkedList;
        }
        int i2 = 0;
        for (ThreadInfo threadInfo : this.kft) {
            cb cbVar = new cb();
            cbVar.a(threadInfo);
            cbVar.eTG = true;
            if (com.baidu.tieba.card.data.l.ae(cbVar)) {
                k aF = d.aF(cbVar);
                if (aF != null && aF.eJQ != null && aF.eJQ.bpG() != null && !StringUtils.isNull(aF.eJQ.bpG().forumName)) {
                    aF.tid = cbVar.getTid();
                    aF.position = i2;
                    d.h(aF);
                    linkedList.add(aF);
                } else {
                    k aF2 = d.aF(cbVar);
                    if (aF2 != null) {
                        aF2.tid = cbVar.getTid();
                        aF2.position = i2;
                        d.a(aF2);
                    }
                    if (aF2 != null && aF2.isValid()) {
                        linkedList.add(aF2);
                    }
                }
                int[] imageWidthAndHeight = cbVar.getImageWidthAndHeight();
                final com.baidu.tieba.card.data.b aE = d.aE(cbVar);
                if (aE != null) {
                    aE.tid = cbVar.getTid();
                    aE.position = i2;
                    if (aE instanceof k) {
                        if (cbVar.bpN()) {
                            d.d(aE);
                        } else if (cbVar.boX() == 1) {
                            d.b(aE);
                            aE.eQj = imageWidthAndHeight[0];
                            aE.eQk = imageWidthAndHeight[1];
                        } else if (cbVar.boX() >= 2) {
                            d.c(aE);
                        } else {
                            d.e(aE);
                        }
                    } else if (aE instanceof com.baidu.tieba.card.data.l) {
                        d.f(aE);
                    }
                }
                if (aE != null && aE.isValid()) {
                    if (!cbVar.bmz() && cbVar.bnQ() != null && cbVar.bpG() != null && !StringUtils.isNull(cbVar.bpG().forumName)) {
                        SpannableString spannableString = new SpannableString(String.format(TbadkCoreApplication.getInst().getString(R.string.at_username), cbVar.bnQ().getName_show()));
                        spannableString.setSpan(new f(16, cbVar.bnQ().getUserId()) { // from class: com.baidu.tieba.homepage.video.b.b.4
                            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                            public void onClick(View view) {
                                com.baidu.tieba.homepage.video.c.a.o(aE);
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(view.getContext(), getLink(), null)));
                            }
                        }, 0, format.length() - 1, 33);
                        aE.eJQ.a(spannableString);
                    }
                    linkedList.add(aE);
                }
                if (threadInfo.top_agree_post != null) {
                    k aF3 = d.aF(cbVar);
                    if (aF3 != null) {
                        aF3.tid = cbVar.getTid();
                        aF3.position = i2;
                        d.i(aF3);
                    }
                    if (aF3 != null && aF3.isValid()) {
                        linkedList.add(aF3);
                    }
                }
                k aF4 = d.aF(cbVar);
                if (aF4 != null) {
                    aF4.tid = cbVar.getTid();
                    aF4.position = i2;
                    d.j(aF4);
                }
                if (aF4 != null && aF4.isValid()) {
                    linkedList.add(aF4);
                }
                i = i2 + 1;
            } else {
                i = i2;
            }
            i2 = i;
        }
        com.baidu.tbadk.a.a.a.bj(linkedList);
        return linkedList;
    }

    private void a(final DataRes.Builder builder) {
        af.a(new ae<Object>() { // from class: com.baidu.tieba.homepage.video.b.b.5
            @Override // com.baidu.tbadk.util.ae
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                try {
                    com.baidu.tbadk.core.c.a.bqr().dE("tb.video_tab", TbadkCoreApplication.getCurrentAccount()).setForever(TbadkCoreApplication.getCurrentAccount(), builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.krE);
    }
}
