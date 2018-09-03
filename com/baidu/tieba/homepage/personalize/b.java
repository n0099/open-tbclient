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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.w;
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
/* loaded from: classes2.dex */
public class b {
    private BdUniqueId aRC;
    private final l dWU;
    private List<ThreadInfo> dWW;
    private a dWX;
    private final List<h> diR;
    private LongSparseArray<ThreadInfo> dWV = new LongSparseArray<>();
    private CustomMessageListener dWY = new CustomMessageListener(2921030) { // from class: com.baidu.tieba.homepage.personalize.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                PostWriteCallBackData postWriteCallBackData = (PostWriteCallBackData) customResponsedMessage.getData();
                long c = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getPostId(), 0L);
                long c2 = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getThreadId(), 0L);
                if (c != 0 && c2 != 0) {
                    com.baidu.adp.lib.g.e.in().removeCallbacks(b.this.dWX);
                    b.this.dWX = new a(c2, c);
                    com.baidu.adp.lib.g.e.in().postDelayed(b.this.dWX, 500L);
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.a cIH = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_MY_POST, 303111) { // from class: com.baidu.tieba.homepage.personalize.b.2
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
    private final CustomMessageListener dDZ = new CustomMessageListener(2921031) { // from class: com.baidu.tieba.homepage.personalize.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str) && !w.z(b.this.diR) && !w.z(b.this.dWW)) {
                    Iterator it = b.this.diR.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        h hVar = (h) it.next();
                        if (hVar instanceof com.baidu.tieba.card.data.c) {
                            com.baidu.tieba.card.data.c cVar = (com.baidu.tieba.card.data.c) hVar;
                            if (cVar.Tg() != null && cVar.Tg().getTid() != null && cVar.Tg().getTid().equals(str)) {
                                it.remove();
                                com.baidu.tieba.homepage.personalize.model.b.bU(b.this.diR);
                                b.this.dWU.ai(new ArrayList(b.this.diR));
                                break;
                            }
                        }
                    }
                    long c = com.baidu.adp.lib.g.b.c(str, 0L);
                    Iterator it2 = b.this.dWW.iterator();
                    while (it2.hasNext()) {
                        ThreadInfo threadInfo = (ThreadInfo) it2.next();
                        if (threadInfo != null && threadInfo.tid != null && threadInfo.tid.longValue() == c) {
                            it2.remove();
                            return;
                        }
                    }
                }
            }
        }
    };

    public b(List<h> list, l lVar) {
        this.diR = list;
        this.dWU = lVar;
    }

    public void h(BdUniqueId bdUniqueId) {
        this.aRC = bdUniqueId;
        this.dWY.setTag(bdUniqueId);
        this.dWY.setSelfListener(false);
        this.cIH.setTag(bdUniqueId);
        this.cIH.getHttpMessageListener().setSelfListener(true);
        this.cIH.getSocketMessageListener().setSelfListener(true);
        this.dDZ.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.dWY);
        MessageManager.getInstance().registerListener(this.cIH);
        MessageManager.getInstance().registerListener(this.dDZ);
    }

    public void bR(List<ThreadInfo> list) {
        this.dWW = list;
    }

    public void bS(List<ThreadInfo> list) {
        if (!w.z(list)) {
            Iterator<ThreadInfo> it = list.iterator();
            while (it.hasNext()) {
                ThreadInfo next = it.next();
                if (next != null && this.dWV.get(next.tid.longValue()) != null) {
                    it.remove();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        private long postId;
        private long threadId;

        public a(long j, long j2) {
            this.threadId = j;
            this.postId = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int ah = com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst());
            int aj = com.baidu.adp.lib.util.l.aj(TbadkCoreApplication.getInst());
            float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int i = 1;
            if (ar.zu().zw()) {
                i = 2;
            }
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setTag(b.this.aRC);
            requestGetMyPostNetMessage.setParams(this.threadId, this.postId, 0L, ah, aj, f, i);
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, GetMyPostResIdl getMyPostResIdl) {
        if (i == 0 && !w.z(this.diR) && !w.z(this.dWW) && this.dWU != null && getMyPostResIdl != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
            ThreadInfo.Builder builder = new ThreadInfo.Builder(getMyPostResIdl.data.thread_info);
            User.Builder builder2 = new User.Builder(builder.author);
            a(builder2, getMyPostResIdl.data.user_info);
            builder2.portrait = TbadkCoreApplication.getCurrentPortrait();
            builder.author = builder2.build(true);
            ThreadInfo build = builder.build(true);
            bb bbVar = new bb();
            bbVar.a(build);
            if (k.R(bbVar)) {
                this.diR.add(this.diR.get(0) instanceof g ? 1 : 0, com.baidu.tieba.homepage.personalize.model.d.ah(bbVar));
                com.baidu.tieba.homepage.personalize.model.b.bU(this.diR);
                this.dWU.ai(new ArrayList(this.diR));
                this.dWW.add(0, build);
                this.dWV.put(build.tid.longValue(), build);
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
        if (this.dWX != null) {
            com.baidu.adp.lib.g.e.in().removeCallbacks(this.dWX);
        }
    }
}
