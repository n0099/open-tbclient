package com.baidu.tieba.homepage.personalize;

import android.support.v4.util.LongSparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.homepage.GetMyPostHttpResponseMessage;
import com.baidu.tieba.homepage.GetMyPostSocketResponseMessage;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import com.baidu.tieba.homepage.personalize.a.w;
import com.baidu.tieba.homepage.personalize.data.g;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.GetMyPost.GetMyPostResIdl;
import tbclient.GetMyPost.User_Info;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes4.dex */
public class b {
    private BdUniqueId cyA;
    private final List<m> fsx;
    private final w gks;
    private List<ThreadInfo> gku;
    private a gkv;
    private LongSparseArray<ThreadInfo> gkt = new LongSparseArray<>();
    private CustomMessageListener gkw = new CustomMessageListener(2921030) { // from class: com.baidu.tieba.homepage.personalize.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                PostWriteCallBackData postWriteCallBackData = (PostWriteCallBackData) customResponsedMessage.getData();
                long e = com.baidu.adp.lib.g.b.e(postWriteCallBackData.getPostId(), 0L);
                long e2 = com.baidu.adp.lib.g.b.e(postWriteCallBackData.getThreadId(), 0L);
                if (e != 0 && e2 != 0) {
                    com.baidu.adp.lib.g.e.iK().removeCallbacks(b.this.gkv);
                    b.this.gkv = new a(e2, e);
                    com.baidu.adp.lib.g.e.iK().postDelayed(b.this.gkv, 500L);
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.a eOj = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_MY_POST, 303111) { // from class: com.baidu.tieba.homepage.personalize.b.2
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
    private final CustomMessageListener fDM = new CustomMessageListener(2921031) { // from class: com.baidu.tieba.homepage.personalize.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str) && !v.aa(b.this.fsx) && !v.aa(b.this.gku)) {
                    Iterator it = b.this.fsx.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        m mVar = (m) it.next();
                        if (mVar instanceof com.baidu.tieba.card.data.c) {
                            com.baidu.tieba.card.data.c cVar = (com.baidu.tieba.card.data.c) mVar;
                            if (cVar.acC() != null && cVar.acC().getTid() != null && cVar.acC().getTid().equals(str)) {
                                it.remove();
                                com.baidu.tieba.homepage.personalize.model.b.cH(b.this.fsx);
                                b.this.gks.aF(new ArrayList(b.this.fsx));
                                break;
                            }
                        }
                    }
                    long e = com.baidu.adp.lib.g.b.e(str, 0L);
                    Iterator it2 = b.this.gku.iterator();
                    while (it2.hasNext()) {
                        ThreadInfo threadInfo = (ThreadInfo) it2.next();
                        if (threadInfo != null && threadInfo.tid != null && threadInfo.tid.longValue() == e) {
                            it2.remove();
                            return;
                        }
                    }
                }
            }
        }
    };

    public b(List<m> list, w wVar) {
        this.fsx = list;
        this.gks = wVar;
    }

    public void j(BdUniqueId bdUniqueId) {
        this.cyA = bdUniqueId;
        this.gkw.setTag(bdUniqueId);
        this.gkw.setSelfListener(false);
        this.eOj.setTag(bdUniqueId);
        this.eOj.getHttpMessageListener().setSelfListener(true);
        this.eOj.getSocketMessageListener().setSelfListener(true);
        this.fDM.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gkw);
        MessageManager.getInstance().registerListener(this.eOj);
        MessageManager.getInstance().registerListener(this.fDM);
    }

    public void cE(List<ThreadInfo> list) {
        this.gku = list;
    }

    public void cF(List<ThreadInfo> list) {
        if (!v.aa(list)) {
            Iterator<ThreadInfo> it = list.iterator();
            while (it.hasNext()) {
                ThreadInfo next = it.next();
                if (next != null && this.gkt.get(next.tid.longValue()) != null) {
                    it.remove();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a implements Runnable {
        private long postId;
        private long threadId;

        public a(long j, long j2) {
            this.threadId = j;
            this.postId = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int af = l.af(TbadkCoreApplication.getInst());
            int ah = l.ah(TbadkCoreApplication.getInst());
            float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int i = 1;
            if (ar.ajw().ajy()) {
                i = 2;
            }
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setTag(b.this.cyA);
            requestGetMyPostNetMessage.setParams(this.threadId, this.postId, 0L, af, ah, f, i);
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, GetMyPostResIdl getMyPostResIdl) {
        if (i == 0 && !v.aa(this.fsx) && !v.aa(this.gku) && this.gks != null && getMyPostResIdl != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
            ThreadInfo.Builder builder = new ThreadInfo.Builder(getMyPostResIdl.data.thread_info);
            User.Builder builder2 = new User.Builder(builder.author);
            a(builder2, getMyPostResIdl.data.user_info);
            builder2.portrait = TbadkCoreApplication.getCurrentPortrait();
            builder.author = builder2.build(true);
            ThreadInfo build = builder.build(true);
            bh bhVar = new bh();
            bhVar.a(build);
            if (k.X(bhVar)) {
                this.fsx.add(this.fsx.get(0) instanceof g ? 1 : 0, com.baidu.tieba.homepage.personalize.model.d.aq(bhVar));
                com.baidu.tieba.homepage.personalize.model.b.cH(this.fsx);
                this.gks.aF(new ArrayList(this.fsx));
                this.gku.add(0, build);
                this.gkt.put(build.tid.longValue(), build);
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
        if (this.gkv != null) {
            com.baidu.adp.lib.g.e.iK().removeCallbacks(this.gkv);
        }
    }
}
