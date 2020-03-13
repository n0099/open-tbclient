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
/* loaded from: classes9.dex */
public class b {
    private a hjx;
    private DataRes.Builder hjz;
    private boolean isLoading;
    private TbPageContext mPageContext;
    private boolean ghA = true;
    private com.baidu.adp.framework.listener.a hjA = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_VIDEO_TAB, 309648) { // from class: com.baidu.tieba.homepage.video.b.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            b.this.isLoading = false;
            b.this.ghA = false;
            if (responsedMessage != null) {
                b.this.h(responsedMessage);
            } else if (b.this.hjx != null) {
                b.this.hjx.l(-1, "", false);
            }
        }
    };
    private List<m> mDataList = new LinkedList();
    private List<ThreadInfo> hbu = new LinkedList();
    private List<ThreadPersonalized> hjy = new LinkedList();

    /* loaded from: classes9.dex */
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
                mS(z);
            }
        }
        if (this.hjx != null) {
            if (responsedMessage.getError() != 0) {
                this.hjx.l(responsedMessage.getError(), responsedMessage.getErrorString(), z);
            } else {
                this.hjx.f(i, z, false);
            }
        }
    }

    public b(TbPageContext tbPageContext, a aVar) {
        this.mPageContext = tbPageContext;
        this.hjx = aVar;
    }

    public void registerListener() {
        MessageManager.getInstance().registerListener(this.hjA);
    }

    public void bPH() {
        if (!this.isLoading) {
            this.isLoading = true;
            if (this.ghA) {
                azY();
                this.ghA = false;
            }
            VideoTabRequestMessage videoTabRequestMessage = new VideoTabRequestMessage();
            videoTabRequestMessage.new_net_type = j.netType();
            videoTabRequestMessage.load_type = 1;
            videoTabRequestMessage.page_thread_count = 12;
            videoTabRequestMessage.setNetType(NetMessage.NetType.HTTP);
            this.mPageContext.sendMessage(videoTabRequestMessage);
        }
    }

    public void bGx() {
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

    public void BC(String str) {
        if (!v.isEmpty(this.mDataList)) {
            Iterator<m> it = this.mDataList.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (next instanceof c) {
                    c cVar = (c) next;
                    if (cVar.aAg() != null && cVar.aAg().getTid() != null && cVar.aAg().getTid().equals(str)) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void Ch(String str) {
        if (this.hjz != null && !v.isEmpty(this.hjz.thread_list)) {
            long j = com.baidu.adp.lib.f.b.toLong(str, 0L);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.hjz.thread_list.size()) {
                    ThreadInfo threadInfo = this.hjz.thread_list.get(i2);
                    if (threadInfo == null || threadInfo.tid == null || threadInfo.tid.longValue() != j) {
                        i = i2 + 1;
                    } else {
                        this.hjz.thread_list.remove(i2);
                        a(this.hjz);
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void mS(boolean z) {
        DataRes.Builder builder = new DataRes.Builder();
        if (v.getCount(this.hbu) >= 12) {
            if (z) {
                builder.thread_list = this.hbu.subList(this.hbu.size() - 12, this.hbu.size());
                a(builder, true);
            } else {
                builder.thread_list = this.hbu.subList(0, 12);
                a(builder, false);
            }
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.hbu);
            builder.thread_list = arrayList;
            a(builder, false);
        }
        this.hjz = builder;
        a(builder);
    }

    private void a(DataRes.Builder builder, boolean z) {
        if (builder != null) {
            if (v.getCount(this.hjy) >= 12) {
                if (z) {
                    builder.thread_personalized = this.hjy.subList(this.hjy.size() - 12, this.hjy.size());
                    return;
                } else {
                    builder.thread_personalized = this.hjy.subList(0, 12);
                    return;
                }
            }
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(this.hjy);
            builder.thread_personalized = linkedList;
        }
    }

    private void azY() {
        ac.a(new ab<DataRes>() { // from class: com.baidu.tieba.homepage.video.b.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ab
            /* renamed from: bPI */
            public DataRes doInBackground() {
                l<byte[]> cq = com.baidu.tbadk.core.c.a.aEB().cq("tb.video_tab", TbadkCoreApplication.getCurrentAccount());
                if (cq == null) {
                    return null;
                }
                byte[] bArr = cq.get(TbadkCoreApplication.getCurrentAccount());
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
                    b.this.hjz = new DataRes.Builder(dataRes);
                    int count = v.getCount(dataRes.thread_list);
                    if (count > 0) {
                        b.this.a(dataRes, false);
                        if (b.this.hjx != null) {
                            b.this.hjx.f(count, false, true);
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
        this.mDataList = bOl();
        com.baidu.tieba.homepage.video.b.a.o(this.hjy, this.mDataList);
    }

    private void r(List<ThreadPersonalized> list, boolean z) {
        if (!v.isEmpty(list)) {
            if (z) {
                LinkedList linkedList = new LinkedList();
                linkedList.addAll(list);
                linkedList.addAll(this.hjy);
                this.hjy.clear();
                this.hjy.addAll(linkedList);
                return;
            }
            this.hjy.addAll(list);
        }
    }

    private void q(List<ThreadInfo> list, boolean z) {
        if (!v.isEmpty(list)) {
            if (z) {
                LinkedList linkedList = new LinkedList();
                linkedList.addAll(list);
                linkedList.addAll(this.hbu);
                this.hbu.clear();
                this.hbu.addAll(linkedList);
                return;
            }
            this.hbu.addAll(list);
        }
    }

    private List<m> bOl() {
        int i;
        String format;
        LinkedList linkedList = new LinkedList();
        if (v.isEmpty(this.hbu)) {
            return linkedList;
        }
        int i2 = 0;
        for (ThreadInfo threadInfo : this.hbu) {
            bj bjVar = new bj();
            bjVar.a(threadInfo);
            bjVar.cUt = true;
            if (com.baidu.tieba.card.data.l.aa(bjVar)) {
                if (bjVar.aEi()) {
                    k aA = d.aA(bjVar);
                    if (aA != null) {
                        aA.tid = bjVar.getTid();
                        aA.position = i2;
                        d.a(aA);
                    }
                    if (aA != null && aA.isValid()) {
                        linkedList.add(aA);
                    }
                } else {
                    k aA2 = d.aA(bjVar);
                    if (aA2 != null) {
                        aA2.tid = bjVar.getTid();
                        aA2.position = i2;
                        d.h(aA2);
                    }
                    if (aA2 != null && aA2.isValid()) {
                        linkedList.add(aA2);
                    }
                }
                int[] imageWidthAndHeight = bjVar.getImageWidthAndHeight();
                final c az = d.az(bjVar);
                if (az != null) {
                    az.tid = bjVar.getTid();
                    az.position = i2;
                    if (az instanceof k) {
                        if (bjVar.aEg()) {
                            d.d(az);
                        } else if (bjVar.aDq() == 1) {
                            d.b(az);
                            az.cRh = imageWidthAndHeight[0];
                            az.cRi = imageWidthAndHeight[1];
                        } else if (bjVar.aDq() >= 2) {
                            d.c(az);
                        } else {
                            d.e(az);
                        }
                    } else if (az instanceof com.baidu.tieba.card.data.l) {
                        d.f(az);
                    }
                }
                if (az != null && az.isValid()) {
                    if (!bjVar.aEi() && bjVar.aCo() != null) {
                        SpannableString spannableString = new SpannableString(String.format(TbadkCoreApplication.getInst().getString(R.string.at_username), bjVar.aCo().getName_show()));
                        spannableString.setSpan(new f(16, bjVar.aCo().getUserId()) { // from class: com.baidu.tieba.homepage.video.b.b.4
                            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                            public void onClick(View view) {
                                com.baidu.tieba.homepage.video.c.a.l(az);
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(view.getContext(), getLink(), null)));
                            }
                        }, 0, format.length() - 1, 33);
                        az.cRg.a(spannableString);
                    }
                    linkedList.add(az);
                }
                if (threadInfo.top_agree_post != null) {
                    k aA3 = d.aA(bjVar);
                    if (aA3 != null) {
                        aA3.tid = bjVar.getTid();
                        aA3.position = i2;
                        d.i(aA3);
                    }
                    if (aA3 != null && aA3.isValid()) {
                        linkedList.add(aA3);
                    }
                }
                k aA4 = d.aA(bjVar);
                if (aA4 != null) {
                    aA4.tid = bjVar.getTid();
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
        return linkedList;
    }

    private void a(final DataRes.Builder builder) {
        ac.a(new ab<Object>() { // from class: com.baidu.tieba.homepage.video.b.b.5
            @Override // com.baidu.tbadk.util.ab
            public Object doInBackground() {
                DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
                try {
                    com.baidu.tbadk.core.c.a.aEB().cq("tb.video_tab", TbadkCoreApplication.getCurrentAccount()).setForever(TbadkCoreApplication.getCurrentAccount(), builder2.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
        }, null);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.hjA);
    }
}
