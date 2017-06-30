package com.baidu.tieba.homepage.personalize;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tbclient.GetMyPost.GetMyPostResIdl;
import tbclient.GetMyPost.User_Info;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes.dex */
public class e {
    private BdUniqueId aMp;
    private final List<com.baidu.adp.widget.ListView.v> bZo;
    private List<ThreadInfo> cIB;
    private a cIC;
    private final com.baidu.tieba.homepage.personalize.b.af cIz;
    private HashMap<Long, ThreadInfo> cIA = new HashMap<>();
    private CustomMessageListener cID = new f(this, CmdConfigCustom.PERSONALIZED_MAINTAB_ON_RESULT);
    private final com.baidu.adp.framework.listener.a cmS = new g(this, CmdConfigHttp.CMD_GET_MY_POST, 303111);
    private final CustomMessageListener cmR = new h(this, CmdConfigCustom.PB_DELETE_THREAD);

    public e(List<com.baidu.adp.widget.ListView.v> list, com.baidu.tieba.homepage.personalize.b.af afVar) {
        this.bZo = list;
        this.cIz = afVar;
    }

    public void i(BdUniqueId bdUniqueId) {
        this.aMp = bdUniqueId;
        this.cID.setTag(bdUniqueId);
        this.cID.setSelfListener(false);
        this.cmS.setTag(bdUniqueId);
        this.cmS.getHttpMessageListener().setSelfListener(true);
        this.cmS.getSocketMessageListener().setSelfListener(true);
        this.cmR.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.cID);
        MessageManager.getInstance().registerListener(this.cmS);
        MessageManager.getInstance().registerListener(this.cmR);
    }

    public void bd(List<ThreadInfo> list) {
        this.cIB = list;
    }

    public void be(List<ThreadInfo> list) {
        if (!com.baidu.tbadk.core.util.z.t(list)) {
            Iterator<ThreadInfo> it = list.iterator();
            while (it.hasNext()) {
                ThreadInfo next = it.next();
                if (next != null && this.cIA.get(next.tid) != null) {
                    it.remove();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        private long postId;
        private long threadId;

        public a(long j, long j2) {
            this.threadId = j;
            this.postId = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int af = com.baidu.adp.lib.util.k.af(TbadkCoreApplication.m9getInst());
            int ag = com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.m9getInst());
            float f = TbadkCoreApplication.m9getInst().getApp().getResources().getDisplayMetrics().density;
            int i = 1;
            if (com.baidu.tbadk.core.util.ax.vA().vC()) {
                i = 2;
            }
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setTag(e.this.aMp);
            requestGetMyPostNetMessage.setParams(this.threadId, this.postId, 0L, af, ag, f, i);
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, GetMyPostResIdl getMyPostResIdl) {
        if (i == 0 && !com.baidu.tbadk.core.util.z.t(this.bZo) && !com.baidu.tbadk.core.util.z.t(this.cIB) && this.cIz != null && getMyPostResIdl != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
            ThreadInfo.Builder builder = new ThreadInfo.Builder(getMyPostResIdl.data.thread_info);
            User.Builder builder2 = new User.Builder(builder.author);
            a(builder2, getMyPostResIdl.data.user_info);
            builder2.portrait = TbadkCoreApplication.getCurrentPortrait();
            builder.author = builder2.build(true);
            ThreadInfo build = builder.build(true);
            bm bmVar = new bm();
            bmVar.a(build);
            if (com.baidu.tieba.card.data.l.x(bmVar)) {
                this.bZo.add(0, com.baidu.tieba.homepage.personalize.model.e.M(bmVar));
                com.baidu.tieba.homepage.personalize.model.c.bi(this.bZo);
                this.cIz.bg(new ArrayList(this.bZo));
                this.cIB.add(0, build);
                this.cIA.put(build.tid, build);
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
        if (this.cIC != null) {
            com.baidu.adp.lib.g.h.fR().removeCallbacks(this.cIC);
        }
    }
}
