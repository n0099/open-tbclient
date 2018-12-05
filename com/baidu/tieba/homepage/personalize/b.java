package com.baidu.tieba.homepage.personalize;

import android.support.v4.util.LongSparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.homepage.GetMyPostHttpResponseMessage;
import com.baidu.tieba.homepage.GetMyPostSocketResponseMessage;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import com.baidu.tieba.homepage.personalize.a.l;
import com.baidu.tieba.homepage.personalize.data.g;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.GetMyPost.GetMyPostResIdl;
import tbclient.GetMyPost.User_Info;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes6.dex */
public class b {
    private BdUniqueId bdE;
    private final List<h> dED;
    private final l euu;
    private List<ThreadInfo> euw;
    private a eux;
    private LongSparseArray<ThreadInfo> euv = new LongSparseArray<>();
    private CustomMessageListener euy = new CustomMessageListener(2921030) { // from class: com.baidu.tieba.homepage.personalize.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                PostWriteCallBackData postWriteCallBackData = (PostWriteCallBackData) customResponsedMessage.getData();
                long d = com.baidu.adp.lib.g.b.d(postWriteCallBackData.getPostId(), 0L);
                long d2 = com.baidu.adp.lib.g.b.d(postWriteCallBackData.getThreadId(), 0L);
                if (d != 0 && d2 != 0) {
                    com.baidu.adp.lib.g.e.jG().removeCallbacks(b.this.eux);
                    b.this.eux = new a(d2, d);
                    com.baidu.adp.lib.g.e.jG().postDelayed(b.this.eux, 500L);
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.a deH = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_MY_POST, 303111) { // from class: com.baidu.tieba.homepage.personalize.b.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
                b.this.a(getMyPostHttpResponseMessage.getError(), getMyPostHttpResponseMessage.getResponseData());
            } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                b.this.a(getMyPostSocketResponseMessage.getError(), getMyPostSocketResponseMessage.getResponseData());
            }
        }
    };
    private final CustomMessageListener eav = new CustomMessageListener(2921031) { // from class: com.baidu.tieba.homepage.personalize.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str) && !v.I(b.this.dED) && !v.I(b.this.euw)) {
                    Iterator it = b.this.dED.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        h hVar = (h) it.next();
                        if (hVar instanceof com.baidu.tieba.card.data.c) {
                            com.baidu.tieba.card.data.c cVar = (com.baidu.tieba.card.data.c) hVar;
                            if (cVar.ZR() != null && cVar.ZR().getTid() != null && cVar.ZR().getTid().equals(str)) {
                                it.remove();
                                com.baidu.tieba.homepage.personalize.model.b.cn(b.this.dED);
                                b.this.euu.ak(new ArrayList(b.this.dED));
                                break;
                            }
                        }
                    }
                    long d = com.baidu.adp.lib.g.b.d(str, 0L);
                    Iterator it2 = b.this.euw.iterator();
                    while (it2.hasNext()) {
                        ThreadInfo threadInfo = (ThreadInfo) it2.next();
                        if (threadInfo != null && threadInfo.tid != null && threadInfo.tid.longValue() == d) {
                            it2.remove();
                            return;
                        }
                    }
                }
            }
        }
    };

    public b(List<h> list, l lVar) {
        this.dED = list;
        this.euu = lVar;
    }

    public void h(BdUniqueId bdUniqueId) {
        this.bdE = bdUniqueId;
        this.euy.setTag(bdUniqueId);
        this.euy.setSelfListener(false);
        this.deH.setTag(bdUniqueId);
        this.deH.getHttpMessageListener().setSelfListener(true);
        this.deH.getSocketMessageListener().setSelfListener(true);
        this.eav.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.euy);
        MessageManager.getInstance().registerListener(this.deH);
        MessageManager.getInstance().registerListener(this.eav);
    }

    public void ck(List<ThreadInfo> list) {
        this.euw = list;
    }

    public void cl(List<ThreadInfo> list) {
        if (!v.I(list)) {
            Iterator<ThreadInfo> it = list.iterator();
            while (it.hasNext()) {
                ThreadInfo next = it.next();
                if (next != null && this.euv.get(next.tid.longValue()) != null) {
                    it.remove();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a implements Runnable {
        private long postId;
        private long threadId;

        public a(long j, long j2) {
            this.threadId = j;
            this.postId = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int aO = com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst());
            int aQ = com.baidu.adp.lib.util.l.aQ(TbadkCoreApplication.getInst());
            float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int i = 1;
            if (aq.DR().DT()) {
                i = 2;
            }
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setTag(b.this.bdE);
            requestGetMyPostNetMessage.setParams(this.threadId, this.postId, 0L, aO, aQ, f, i);
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, GetMyPostResIdl getMyPostResIdl) {
        if (i == 0 && !v.I(this.dED) && !v.I(this.euw) && this.euu != null && getMyPostResIdl != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
            ThreadInfo.Builder builder = new ThreadInfo.Builder(getMyPostResIdl.data.thread_info);
            User.Builder builder2 = new User.Builder(builder.author);
            a(builder2, getMyPostResIdl.data.user_info);
            builder2.portrait = TbadkCoreApplication.getCurrentPortrait();
            builder.author = builder2.build(true);
            ThreadInfo build = builder.build(true);
            bb bbVar = new bb();
            bbVar.a(build);
            if (k.S(bbVar)) {
                this.dED.add(this.dED.get(0) instanceof g ? 1 : 0, com.baidu.tieba.homepage.personalize.model.d.ai(bbVar));
                com.baidu.tieba.homepage.personalize.model.b.cn(this.dED);
                this.euu.ak(new ArrayList(this.dED));
                this.euw.add(0, build);
                this.euv.put(build.tid.longValue(), build);
            }
        }
    }

    private void a(User.Builder builder, User_Info user_Info) {
        if (user_Info != null) {
            builder.id = user_Info.id;
            builder.gender = user_Info.gender;
            builder.type = user_Info.type;
            builder.name = user_Info.name;
            builder.name_show = user_Info.name_show;
            builder.portrait = user_Info.portrait;
            builder.god_data = user_Info.god_data;
            builder.fans_num = user_Info.fans_num;
        }
    }

    public void onDestroy() {
        if (this.eux != null) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.eux);
        }
    }
}
