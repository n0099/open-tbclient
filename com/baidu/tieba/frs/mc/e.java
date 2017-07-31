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
    private final CustomMessageListener cuZ;
    private final CustomMessageListener cva;
    private final com.baidu.adp.framework.listener.a cvb;

    public e(com.baidu.tieba.frs.f fVar) {
        super(fVar);
        this.cuZ = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.frs.mc.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    e.this.a((PostWriteCallBackData) customResponsedMessage.getData());
                }
            }
        };
        this.cva = new CustomMessageListener(CmdConfigCustom.PB_DELETE_THREAD) { // from class: com.baidu.tieba.frs.mc.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!StringUtils.isNull(str) && e.this.f5com.afr() != null) {
                        com.baidu.tieba.tbadkCore.i afr = e.this.f5com.afr();
                        afr.ai(afr.rT(str));
                        e.this.ciX.a(afr.getThreadList(), afr);
                        if (com.baidu.tieba.tbadkCore.c.bqu() != null) {
                            com.baidu.tieba.tbadkCore.c.bqu().Z(e.this.f5com.getForumName(), false);
                        }
                    }
                }
            }
        };
        this.cvb = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_MY_POST, 303111) { // from class: com.baidu.tieba.frs.mc.e.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String errorString;
                String errorString2;
                if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                    GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
                    if (StringUtils.isNull(getMyPostHttpResponseMessage.getErrorString())) {
                        errorString2 = e.this.f5com.getResources().getString(d.l.neterror);
                    } else {
                        errorString2 = getMyPostHttpResponseMessage.getErrorString();
                    }
                    e.this.a(getMyPostHttpResponseMessage.getError(), errorString2, getMyPostHttpResponseMessage.getResponseData());
                } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                    GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                    if (StringUtils.isNull(getMyPostSocketResponseMessage.getErrorString())) {
                        errorString = e.this.f5com.getResources().getString(d.l.neterror);
                    } else {
                        errorString = getMyPostSocketResponseMessage.getErrorString();
                    }
                    e.this.a(getMyPostSocketResponseMessage.getError(), errorString, getMyPostSocketResponseMessage.getResponseData());
                }
            }
        };
        this.cvb.getSocketMessageListener().setSelfListener(true);
        this.cvb.getHttpMessageListener().setSelfListener(true);
        this.cva.setSelfListener(false);
        fVar.registerListener(this.cva);
        this.f5com.registerListener(this.cvb);
        this.f5com.registerListener(this.cuZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, GetMyPostResIdl getMyPostResIdl) {
        if (i != 0) {
            this.f5com.showToast(str);
            return;
        }
        com.baidu.tieba.tbadkCore.i afr = this.f5com.afr();
        if (afr != null && afr.aPh() != null && getMyPostResIdl != null && this.ciX != null && this.cjg != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
            ao aoVar = new ao();
            ThreadInfo.Builder builder = new ThreadInfo.Builder(getMyPostResIdl.data.thread_info);
            User.Builder builder2 = new User.Builder(builder.author);
            a(builder2, getMyPostResIdl.data.user_info);
            builder.author = builder2.build(true);
            builder.cheak_repeat = 1;
            builder.fname = afr.aPh().getName();
            aoVar.a(builder.build(true));
            aoVar.bX(3);
            this.cjg.a(aoVar);
            ArrayList<com.baidu.adp.widget.ListView.f> a = this.cvn.a(false, true, afr.getThreadList(), null);
            if (a != null) {
                afr.aB(a);
                afr.brs();
                this.ciX.a(a, afr);
                this.ciX.iH(0);
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
        if (this.cjg != null) {
            if (this.cjg.aiE() == 2 || this.cjg.aiE() == 3 || this.cjg.aiE() == 7) {
                int aiw = this.cjg.aiw();
                if (y.agf().iJ(1) == null) {
                    aiw = 0;
                }
                if (aiw == 0 && postWriteCallBackData != null) {
                    final long d = com.baidu.adp.lib.g.b.d(postWriteCallBackData.getPostId(), 0L);
                    final long d2 = com.baidu.adp.lib.g.b.d(postWriteCallBackData.getThreadId(), 0L);
                    final long d3 = com.baidu.adp.lib.g.b.d(this.f5com.getForumId(), 0L);
                    if (d != 0 && d2 != 0 && d3 != 0) {
                        com.baidu.adp.lib.g.e.ga().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.mc.e.4
                            @Override // java.lang.Runnable
                            public void run() {
                                int ag = com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.getInst());
                                int ah = com.baidu.adp.lib.util.k.ah(TbadkCoreApplication.getInst());
                                float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                                int i = 1;
                                if (am.vQ().vS()) {
                                    i = 2;
                                }
                                RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                                requestGetMyPostNetMessage.setParams(d2, d, d3, ag, ah, f, i);
                                e.this.f5com.sendMessage(requestGetMyPostNetMessage);
                            }
                        }, 1000L);
                    }
                }
            }
        }
    }
}
