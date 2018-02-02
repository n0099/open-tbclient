package com.baidu.tieba.frs.mc;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ai;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.aa;
import com.baidu.tieba.homepage.GetMyPostHttpResponseMessage;
import com.baidu.tieba.homepage.GetMyPostSocketResponseMessage;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import com.baidu.tieba.tbadkCore.l;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetMyPost.GetMyPostResIdl;
import tbclient.GetMyPost.User_Info;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes2.dex */
public class d extends h {
    private final CustomMessageListener dQm;
    private final CustomMessageListener dQn;
    private final CustomMessageListener dQo;
    private final com.baidu.adp.framework.listener.a ddU;

    public d(com.baidu.tieba.frs.i iVar) {
        super(iVar);
        this.dQm = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.frs.mc.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    d.this.d((PostWriteCallBackData) customResponsedMessage.getData());
                }
            }
        };
        this.dQn = new CustomMessageListener(CmdConfigCustom.PB_DELETE_THREAD) { // from class: com.baidu.tieba.frs.mc.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!StringUtils.isNull(str) && d.this.dPK.auv() != null) {
                        l auv = d.this.dPK.auv();
                        auv.ag(auv.sx(str));
                        d.this.dBD.a(auv.getThreadList(), auv);
                        if (com.baidu.tieba.tbadkCore.c.btv() != null) {
                            com.baidu.tieba.tbadkCore.c.btv().aa(d.this.dPK.getForumName(), false);
                        }
                    }
                }
            }
        };
        this.dQo = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_MANAGE) { // from class: com.baidu.tieba.frs.mc.d.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v19, types: [java.util.List] */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ForumManageModel.e eVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ForumManageModel.e) && d.this.dPK != null && d.this.dBD != null && d.this.dBM != null && (eVar = (ForumManageModel.e) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(eVar.threadId) && d.this.dPK.auv() != null) {
                    String str = eVar.threadId;
                    String str2 = eVar.forumId;
                    String str3 = eVar.forumName;
                    if (eVar.haX == 4) {
                        l auv = d.this.dPK.auv();
                        bd sx = auv.sx(str);
                        auv.ag(sx);
                        List<com.baidu.adp.widget.ListView.i> buO = auv.buO();
                        if (buO == null) {
                            buO = new ArrayList<>();
                        }
                        buO.add(0, sx);
                        d.this.dBD.a(auv.getThreadList(), auv);
                        d.this.dBM.f(auv);
                    }
                    if (TextUtils.equals(d.this.dPK.getForumName(), str3)) {
                        com.baidu.tieba.tbadkCore.c.btv().aa(d.this.dPK.getForumName(), false);
                    }
                }
            }
        };
        this.ddU = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_MY_POST, 303111) { // from class: com.baidu.tieba.frs.mc.d.4
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String errorString;
                String errorString2;
                if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                    GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
                    if (StringUtils.isNull(getMyPostHttpResponseMessage.getErrorString())) {
                        errorString2 = d.this.dPK.getResources().getString(d.j.neterror);
                    } else {
                        errorString2 = getMyPostHttpResponseMessage.getErrorString();
                    }
                    d.this.a(getMyPostHttpResponseMessage.getError(), errorString2, getMyPostHttpResponseMessage.getResponseData());
                } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                    GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                    if (StringUtils.isNull(getMyPostSocketResponseMessage.getErrorString())) {
                        errorString = d.this.dPK.getResources().getString(d.j.neterror);
                    } else {
                        errorString = getMyPostSocketResponseMessage.getErrorString();
                    }
                    d.this.a(getMyPostSocketResponseMessage.getError(), errorString, getMyPostSocketResponseMessage.getResponseData());
                }
            }
        };
        this.ddU.getSocketMessageListener().setSelfListener(true);
        this.ddU.getHttpMessageListener().setSelfListener(true);
        this.dQn.setSelfListener(false);
        this.dPK.registerListener(this.dQn);
        this.dPK.registerListener(this.ddU);
        this.dPK.registerListener(this.dQm);
        this.dPK.registerListener(this.dQo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, GetMyPostResIdl getMyPostResIdl) {
        if (i != 0) {
            this.dPK.showToast(str);
            return;
        }
        l auv = this.dPK.auv();
        if (auv != null && auv.aYJ() != null && getMyPostResIdl != null && this.dBD != null && this.dBL != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
            ai aiVar = new ai();
            ThreadInfo.Builder builder = new ThreadInfo.Builder(getMyPostResIdl.data.thread_info);
            User.Builder builder2 = new User.Builder(builder.author);
            a(builder2, getMyPostResIdl.data.user_info);
            builder.author = builder2.build(true);
            builder.cheak_repeat = 1;
            builder.fname = auv.aYJ().getName();
            aiVar.a(builder.build(true));
            aiVar.eW(3);
            this.dBL.a(aiVar);
            ArrayList<com.baidu.adp.widget.ListView.i> a = this.dQG.a(false, true, auv.getThreadList(), null);
            if (a != null) {
                auv.at(a);
                auv.buy();
                this.dBD.a(a, auv);
                this.dBD.mX(0);
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
            builder.fans_nickname = user_Info.fans_nickname;
            builder.is_bawu = user_Info.is_bawu;
            builder.bawu_type = user_Info.bawu_type;
        }
    }

    public void d(PostWriteCallBackData postWriteCallBackData) {
        if (this.dBL != null) {
            if (this.dBL.ayv() == 2 || this.dBL.ayv() == 3 || this.dBL.ayv() == 7) {
                int ayn = this.dBL.ayn();
                if (aa.avn().mZ(1) == null) {
                    ayn = 0;
                }
                if (ayn == 0 && postWriteCallBackData != null) {
                    final long c = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getPostId(), 0L);
                    final long c2 = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getThreadId(), 0L);
                    final long c3 = com.baidu.adp.lib.g.b.c(this.dPK.getForumId(), 0L);
                    if (c != 0 && c2 != 0 && c3 != 0) {
                        com.baidu.adp.lib.g.e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.mc.d.5
                            @Override // java.lang.Runnable
                            public void run() {
                                int ao = com.baidu.adp.lib.util.l.ao(TbadkCoreApplication.getInst());
                                int aq = com.baidu.adp.lib.util.l.aq(TbadkCoreApplication.getInst());
                                float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                                int i = 1;
                                if (an.CK().CM()) {
                                    i = 2;
                                }
                                RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                                requestGetMyPostNetMessage.setParams(c2, c, c3, ao, aq, f, i);
                                d.this.dPK.sendMessage(requestGetMyPostNetMessage);
                            }
                        }, 1000L);
                    }
                }
            }
        }
    }
}
