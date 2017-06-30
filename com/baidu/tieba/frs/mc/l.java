package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ap;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.frs.br;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
import tbclient.GetMyPost.GetMyPostResIdl;
import tbclient.GetMyPost.User_Info;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes.dex */
public class l extends z {
    private final CustomMessageListener cmQ;
    private final CustomMessageListener cmR;
    private final com.baidu.adp.framework.listener.a cmS;

    public l(com.baidu.tieba.frs.r rVar) {
        super(rVar);
        this.cmQ = new m(this, CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS);
        this.cmR = new n(this, CmdConfigCustom.PB_DELETE_THREAD);
        this.cmS = new o(this, CmdConfigHttp.CMD_GET_MY_POST, 303111);
        this.cmS.getSocketMessageListener().setSelfListener(true);
        this.cmS.getHttpMessageListener().setSelfListener(true);
        this.cmR.setSelfListener(false);
        rVar.registerListener(this.cmR);
        this.cbE.registerListener(this.cmS);
        this.cbE.registerListener(this.cmQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, GetMyPostResIdl getMyPostResIdl) {
        if (i != 0) {
            this.cbE.showToast(str);
            return;
        }
        com.baidu.tieba.tbadkCore.n aek = this.cbE.aek();
        if (aek != null && aek.aMt() != null && getMyPostResIdl != null && this.ccj != null && this.ccs != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
            ap apVar = new ap();
            ThreadInfo.Builder builder = new ThreadInfo.Builder(getMyPostResIdl.data.thread_info);
            User.Builder builder2 = new User.Builder(builder.author);
            a(builder2, getMyPostResIdl.data.user_info);
            builder.author = builder2.build(true);
            builder.cheak_repeat = 1;
            builder.fname = aek.aMt().getName();
            apVar.a(builder.build(true));
            apVar.bW(3);
            this.ccs.a(apVar);
            ArrayList<com.baidu.adp.widget.ListView.v> a = this.cnf.a(false, true, aek.getThreadList(), null);
            if (a != null) {
                aek.az(a);
                aek.blo();
                this.ccj.a(a, aek);
                this.ccj.iy(0);
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
            builder.portrait = TbadkCoreApplication.getCurrentPortrait();
            builder.god_data = user_Info.god_data;
            builder.fans_num = user_Info.fans_num;
        }
    }

    public void a(PostWriteCallBackData postWriteCallBackData) {
        if (this.ccs != null) {
            if (this.ccs.agT() == 2 || this.ccs.agT() == 3 || this.ccs.agT() == 7) {
                int agL = this.ccs.agL();
                if (br.aeU().iA(1) == null) {
                    agL = 0;
                }
                if (agL == 0 && postWriteCallBackData != null) {
                    long c = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getPostId(), 0L);
                    long c2 = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getThreadId(), 0L);
                    long c3 = com.baidu.adp.lib.g.b.c(this.cbE.getForumId(), 0L);
                    if (c != 0 && c2 != 0 && c3 != 0) {
                        com.baidu.adp.lib.g.h.fR().postDelayed(new p(this, c2, c, c3), 1000L);
                    }
                }
            }
        }
    }
}
