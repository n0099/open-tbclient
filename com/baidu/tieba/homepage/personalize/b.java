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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.homepage.GetMyPostHttpResponseMessage;
import com.baidu.tieba.homepage.GetMyPostSocketResponseMessage;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import com.baidu.tieba.homepage.personalize.a.v;
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
    private BdUniqueId coa;
    private final List<m> eVb;
    private final v fKi;
    private List<ThreadInfo> fKk;
    private a fKl;
    private LongSparseArray<ThreadInfo> fKj = new LongSparseArray<>();
    private CustomMessageListener fKm = new CustomMessageListener(2921030) { // from class: com.baidu.tieba.homepage.personalize.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                PostWriteCallBackData postWriteCallBackData = (PostWriteCallBackData) customResponsedMessage.getData();
                long d = com.baidu.adp.lib.g.b.d(postWriteCallBackData.getPostId(), 0L);
                long d2 = com.baidu.adp.lib.g.b.d(postWriteCallBackData.getThreadId(), 0L);
                if (d != 0 && d2 != 0) {
                    com.baidu.adp.lib.g.e.jH().removeCallbacks(b.this.fKl);
                    b.this.fKl = new a(d2, d);
                    com.baidu.adp.lib.g.e.jH().postDelayed(b.this.fKl, 500L);
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.a erS = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_MY_POST, 303111) { // from class: com.baidu.tieba.homepage.personalize.b.2
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
    private final CustomMessageListener fgb = new CustomMessageListener(2921031) { // from class: com.baidu.tieba.homepage.personalize.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str) && !com.baidu.tbadk.core.util.v.T(b.this.eVb) && !com.baidu.tbadk.core.util.v.T(b.this.fKk)) {
                    Iterator it = b.this.eVb.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        m mVar = (m) it.next();
                        if (mVar instanceof com.baidu.tieba.card.data.c) {
                            com.baidu.tieba.card.data.c cVar = (com.baidu.tieba.card.data.c) mVar;
                            if (cVar.WO() != null && cVar.WO().getTid() != null && cVar.WO().getTid().equals(str)) {
                                it.remove();
                                com.baidu.tieba.homepage.personalize.model.b.cy(b.this.eVb);
                                b.this.fKi.ay(new ArrayList(b.this.eVb));
                                break;
                            }
                        }
                    }
                    long d = com.baidu.adp.lib.g.b.d(str, 0L);
                    Iterator it2 = b.this.fKk.iterator();
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

    public b(List<m> list, v vVar) {
        this.eVb = list;
        this.fKi = vVar;
    }

    public void i(BdUniqueId bdUniqueId) {
        this.coa = bdUniqueId;
        this.fKm.setTag(bdUniqueId);
        this.fKm.setSelfListener(false);
        this.erS.setTag(bdUniqueId);
        this.erS.getHttpMessageListener().setSelfListener(true);
        this.erS.getSocketMessageListener().setSelfListener(true);
        this.fgb.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fKm);
        MessageManager.getInstance().registerListener(this.erS);
        MessageManager.getInstance().registerListener(this.fgb);
    }

    public void cv(List<ThreadInfo> list) {
        this.fKk = list;
    }

    public void cw(List<ThreadInfo> list) {
        if (!com.baidu.tbadk.core.util.v.T(list)) {
            Iterator<ThreadInfo> it = list.iterator();
            while (it.hasNext()) {
                ThreadInfo next = it.next();
                if (next != null && this.fKj.get(next.tid.longValue()) != null) {
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
            int aO = l.aO(TbadkCoreApplication.getInst());
            int aQ = l.aQ(TbadkCoreApplication.getInst());
            float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int i = 1;
            if (ar.adm().ado()) {
                i = 2;
            }
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setTag(b.this.coa);
            requestGetMyPostNetMessage.setParams(this.threadId, this.postId, 0L, aO, aQ, f, i);
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, GetMyPostResIdl getMyPostResIdl) {
        if (i == 0 && !com.baidu.tbadk.core.util.v.T(this.eVb) && !com.baidu.tbadk.core.util.v.T(this.fKk) && this.fKi != null && getMyPostResIdl != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
            ThreadInfo.Builder builder = new ThreadInfo.Builder(getMyPostResIdl.data.thread_info);
            User.Builder builder2 = new User.Builder(builder.author);
            a(builder2, getMyPostResIdl.data.user_info);
            builder2.portrait = TbadkCoreApplication.getCurrentPortrait();
            builder.author = builder2.build(true);
            ThreadInfo build = builder.build(true);
            bg bgVar = new bg();
            bgVar.a(build);
            if (k.V(bgVar)) {
                this.eVb.add(this.eVb.get(0) instanceof g ? 1 : 0, com.baidu.tieba.homepage.personalize.model.d.aq(bgVar));
                com.baidu.tieba.homepage.personalize.model.b.cy(this.eVb);
                this.fKi.ay(new ArrayList(this.eVb));
                this.fKk.add(0, build);
                this.fKj.put(build.tid.longValue(), build);
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
        if (this.fKl != null) {
            com.baidu.adp.lib.g.e.jH().removeCallbacks(this.fKl);
        }
    }
}
