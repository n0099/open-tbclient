package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.am;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.z;
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
public class d extends h {
    private final CustomMessageListener cOp;
    private final CustomMessageListener cOq;
    private final com.baidu.adp.framework.listener.a cbm;

    public d(com.baidu.tieba.frs.f fVar) {
        super(fVar);
        this.cOp = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.frs.mc.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    d.this.c((PostWriteCallBackData) customResponsedMessage.getData());
                }
            }
        };
        this.cOq = new CustomMessageListener(CmdConfigCustom.PB_DELETE_THREAD) { // from class: com.baidu.tieba.frs.mc.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!StringUtils.isNull(str) && d.this.cEN.ajn() != null) {
                        com.baidu.tieba.tbadkCore.j ajn = d.this.cEN.ajn();
                        ajn.ai(ajn.so(str));
                        d.this.cxB.a(ajn.getThreadList(), ajn);
                        if (com.baidu.tieba.tbadkCore.c.bsm() != null) {
                            com.baidu.tieba.tbadkCore.c.bsm().W(d.this.cEN.getForumName(), false);
                        }
                    }
                }
            }
        };
        this.cbm = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_MY_POST, 303111) { // from class: com.baidu.tieba.frs.mc.d.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String errorString;
                String errorString2;
                if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                    GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
                    if (StringUtils.isNull(getMyPostHttpResponseMessage.getErrorString())) {
                        errorString2 = d.this.cEN.getResources().getString(d.j.neterror);
                    } else {
                        errorString2 = getMyPostHttpResponseMessage.getErrorString();
                    }
                    d.this.a(getMyPostHttpResponseMessage.getError(), errorString2, getMyPostHttpResponseMessage.getResponseData());
                } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                    GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                    if (StringUtils.isNull(getMyPostSocketResponseMessage.getErrorString())) {
                        errorString = d.this.cEN.getResources().getString(d.j.neterror);
                    } else {
                        errorString = getMyPostSocketResponseMessage.getErrorString();
                    }
                    d.this.a(getMyPostSocketResponseMessage.getError(), errorString, getMyPostSocketResponseMessage.getResponseData());
                }
            }
        };
        this.cbm.getSocketMessageListener().setSelfListener(true);
        this.cbm.getHttpMessageListener().setSelfListener(true);
        this.cOq.setSelfListener(false);
        fVar.registerListener(this.cOq);
        this.cEN.registerListener(this.cbm);
        this.cEN.registerListener(this.cOp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, GetMyPostResIdl getMyPostResIdl) {
        if (i != 0) {
            this.cEN.showToast(str);
            return;
        }
        com.baidu.tieba.tbadkCore.j ajn = this.cEN.ajn();
        if (ajn != null && ajn.aPM() != null && getMyPostResIdl != null && this.cxB != null && this.cxK != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
            am amVar = new am();
            ThreadInfo.Builder builder = new ThreadInfo.Builder(getMyPostResIdl.data.thread_info);
            User.Builder builder2 = new User.Builder(builder.author);
            a(builder2, getMyPostResIdl.data.user_info);
            builder.author = builder2.build(true);
            builder.cheak_repeat = 1;
            builder.fname = ajn.aPM().getName();
            amVar.a(builder.build(true));
            amVar.bX(3);
            this.cxK.a(amVar);
            ArrayList<com.baidu.adp.widget.ListView.f> a = this.cOE.a(false, true, ajn.getThreadList(), null);
            if (a != null) {
                ajn.az(a);
                ajn.btn();
                this.cxB.a(a, ajn);
                this.cxB.ju(0);
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

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (this.cxK != null) {
            if (this.cxK.anJ() == 2 || this.cxK.anJ() == 3 || this.cxK.anJ() == 7) {
                int anB = this.cxK.anB();
                if (z.ake().jw(1) == null) {
                    anB = 0;
                }
                if (anB == 0 && postWriteCallBackData != null) {
                    final long c = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getPostId(), 0L);
                    final long c2 = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getThreadId(), 0L);
                    final long c3 = com.baidu.adp.lib.g.b.c(this.cEN.getForumId(), 0L);
                    if (c != 0 && c2 != 0 && c3 != 0) {
                        com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.mc.d.4
                            @Override // java.lang.Runnable
                            public void run() {
                                int ac = l.ac(TbadkCoreApplication.getInst());
                                int ae = l.ae(TbadkCoreApplication.getInst());
                                float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                                int i = 1;
                                if (an.vs().vu()) {
                                    i = 2;
                                }
                                RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                                requestGetMyPostNetMessage.setParams(c2, c, c3, ac, ae, f, i);
                                d.this.cEN.sendMessage(requestGetMyPostNetMessage);
                            }
                        }, 1000L);
                    }
                }
            }
        }
    }
}
