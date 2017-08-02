package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ao;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.y;
import com.baidu.tieba.homepage.GetMyPostHttpResponseMessage;
import com.baidu.tieba.homepage.GetMyPostSocketResponseMessage;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
import tbclient.GetMyPost.GetMyPostResIdl;
import tbclient.GetMyPost.User_Info;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes.dex */
public class e extends i {
    private final CustomMessageListener ctG;
    private final CustomMessageListener ctH;
    private final com.baidu.adp.framework.listener.a ctI;

    public e(com.baidu.tieba.frs.f fVar) {
        super(fVar);
        this.ctG = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.frs.mc.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    e.this.a((PostWriteCallBackData) customResponsedMessage.getData());
                }
            }
        };
        this.ctH = new CustomMessageListener(CmdConfigCustom.PB_DELETE_THREAD) { // from class: com.baidu.tieba.frs.mc.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!StringUtils.isNull(str) && e.this.cna.afm() != null) {
                        com.baidu.tieba.tbadkCore.i afm = e.this.cna.afm();
                        afm.ai(afm.rO(str));
                        e.this.chQ.a(afm.getThreadList(), afm);
                        if (com.baidu.tieba.tbadkCore.c.bqn() != null) {
                            com.baidu.tieba.tbadkCore.c.bqn().aa(e.this.cna.getForumName(), false);
                        }
                    }
                }
            }
        };
        this.ctI = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_MY_POST, 303111) { // from class: com.baidu.tieba.frs.mc.e.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String errorString;
                String errorString2;
                if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                    GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
                    if (StringUtils.isNull(getMyPostHttpResponseMessage.getErrorString())) {
                        errorString2 = e.this.cna.getResources().getString(d.l.neterror);
                    } else {
                        errorString2 = getMyPostHttpResponseMessage.getErrorString();
                    }
                    e.this.a(getMyPostHttpResponseMessage.getError(), errorString2, getMyPostHttpResponseMessage.getResponseData());
                } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                    GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                    if (StringUtils.isNull(getMyPostSocketResponseMessage.getErrorString())) {
                        errorString = e.this.cna.getResources().getString(d.l.neterror);
                    } else {
                        errorString = getMyPostSocketResponseMessage.getErrorString();
                    }
                    e.this.a(getMyPostSocketResponseMessage.getError(), errorString, getMyPostSocketResponseMessage.getResponseData());
                }
            }
        };
        this.ctI.getSocketMessageListener().setSelfListener(true);
        this.ctI.getHttpMessageListener().setSelfListener(true);
        this.ctH.setSelfListener(false);
        fVar.registerListener(this.ctH);
        this.cna.registerListener(this.ctI);
        this.cna.registerListener(this.ctG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, GetMyPostResIdl getMyPostResIdl) {
        if (i != 0) {
            this.cna.showToast(str);
            return;
        }
        com.baidu.tieba.tbadkCore.i afm = this.cna.afm();
        if (afm != null && afm.aOW() != null && getMyPostResIdl != null && this.chQ != null && this.chZ != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
            ao aoVar = new ao();
            ThreadInfo.Builder builder = new ThreadInfo.Builder(getMyPostResIdl.data.thread_info);
            User.Builder builder2 = new User.Builder(builder.author);
            a(builder2, getMyPostResIdl.data.user_info);
            builder.author = builder2.build(true);
            builder.cheak_repeat = 1;
            builder.fname = afm.aOW().getName();
            aoVar.a(builder.build(true));
            aoVar.bV(3);
            this.chZ.a(aoVar);
            ArrayList<com.baidu.adp.widget.ListView.f> a = this.ctV.a(false, true, afm.getThreadList(), null);
            if (a != null) {
                afm.aB(a);
                afm.brl();
                this.chQ.a(a, afm);
                this.chQ.iH(0);
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
        if (this.chZ != null) {
            if (this.chZ.ais() == 2 || this.chZ.ais() == 3 || this.chZ.ais() == 7) {
                int aik = this.chZ.aik();
                if (y.afY().iJ(1) == null) {
                    aik = 0;
                }
                if (aik == 0 && postWriteCallBackData != null) {
                    final long c = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getPostId(), 0L);
                    final long c2 = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getThreadId(), 0L);
                    final long c3 = com.baidu.adp.lib.g.b.c(this.cna.getForumId(), 0L);
                    if (c != 0 && c2 != 0 && c3 != 0) {
                        com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.mc.e.4
                            @Override // java.lang.Runnable
                            public void run() {
                                int af = com.baidu.adp.lib.util.k.af(TbadkCoreApplication.getInst());
                                int ag = com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.getInst());
                                float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                                int i = 1;
                                if (am.vG().vI()) {
                                    i = 2;
                                }
                                RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                                requestGetMyPostNetMessage.setParams(c2, c, c3, af, ag, f, i);
                                e.this.cna.sendMessage(requestGetMyPostNetMessage);
                            }
                        }, 1000L);
                    }
                }
            }
        }
    }
}
