package com.baidu.tieba.frs.mc;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ai;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.y;
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
    private final com.baidu.adp.framework.listener.a cIK;
    private final CustomMessageListener dEb;
    private final CustomMessageListener dEc;
    private final CustomMessageListener dEd;

    public d(FrsFragment frsFragment) {
        super(frsFragment);
        this.dEb = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.frs.mc.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    d.this.e((PostWriteCallBackData) customResponsedMessage.getData());
                }
            }
        };
        this.dEc = new CustomMessageListener(2921031) { // from class: com.baidu.tieba.frs.mc.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!StringUtils.isNull(str) && d.this.dDw.auD() != null) {
                        l auD = d.this.dDw.auD();
                        auD.aa(auD.mC(str));
                        d.this.dmq.a(auD.getThreadList(), auD);
                        if (com.baidu.tieba.tbadkCore.c.btR() != null) {
                            com.baidu.tieba.tbadkCore.c.btR().T(d.this.dDw.getForumName(), false);
                        }
                    }
                }
            }
        };
        this.dEd = new CustomMessageListener(2921316) { // from class: com.baidu.tieba.frs.mc.d.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v19, types: [java.util.List] */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ForumManageModel.e eVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ForumManageModel.e) && d.this.dDw != null && d.this.dmq != null && d.this.dmC != null && (eVar = (ForumManageModel.e) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(eVar.threadId) && d.this.dDw.auD() != null) {
                    String str = eVar.threadId;
                    String str2 = eVar.forumId;
                    String str3 = eVar.forumName;
                    if (eVar.gQs == 4) {
                        l auD = d.this.dDw.auD();
                        bb mC = auD.mC(str);
                        auD.aa(mC);
                        List<com.baidu.adp.widget.ListView.h> bvn = auD.bvn();
                        if (bvn == null) {
                            bvn = new ArrayList<>();
                        }
                        bvn.add(0, mC);
                        d.this.dmq.a(auD.getThreadList(), auD);
                        d.this.dmC.h(auD);
                    }
                    if (TextUtils.equals(d.this.dDw.getForumName(), str3)) {
                        com.baidu.tieba.tbadkCore.c.btR().T(d.this.dDw.getForumName(), false);
                    }
                }
            }
        };
        this.cIK = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_MY_POST, 303111) { // from class: com.baidu.tieba.frs.mc.d.4
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String errorString;
                String errorString2;
                if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                    GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
                    if (StringUtils.isNull(getMyPostHttpResponseMessage.getErrorString())) {
                        errorString2 = d.this.dDw.getResources().getString(d.j.neterror);
                    } else {
                        errorString2 = getMyPostHttpResponseMessage.getErrorString();
                    }
                    d.this.a(getMyPostHttpResponseMessage.getError(), errorString2, getMyPostHttpResponseMessage.getResponseData());
                } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                    GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                    if (StringUtils.isNull(getMyPostSocketResponseMessage.getErrorString())) {
                        errorString = d.this.dDw.getResources().getString(d.j.neterror);
                    } else {
                        errorString = getMyPostSocketResponseMessage.getErrorString();
                    }
                    d.this.a(getMyPostSocketResponseMessage.getError(), errorString, getMyPostSocketResponseMessage.getResponseData());
                }
            }
        };
        this.cIK.getSocketMessageListener().setSelfListener(true);
        this.cIK.getHttpMessageListener().setSelfListener(true);
        this.dEc.setSelfListener(false);
        this.dDw.registerListener(this.dEc);
        this.dDw.registerListener(this.cIK);
        this.dDw.registerListener(this.dEb);
        this.dDw.registerListener(this.dEd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, GetMyPostResIdl getMyPostResIdl) {
        ArrayList<com.baidu.adp.widget.ListView.h> a;
        if (i != 0) {
            this.dDw.showToast(str);
            return;
        }
        l auD = this.dDw.auD();
        if (auD != null && auD.aZl() != null && getMyPostResIdl != null && this.dmq != null && this.dmB != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
            ai aiVar = new ai();
            ThreadInfo.Builder builder = new ThreadInfo.Builder(getMyPostResIdl.data.thread_info);
            User.Builder builder2 = new User.Builder(builder.author);
            a(builder2, getMyPostResIdl.data.user_info);
            builder.author = builder2.build(true);
            builder.cheak_repeat = 1;
            builder.fname = auD.aZl().getName();
            builder.fid = Long.valueOf(com.baidu.adp.lib.g.b.c(auD.aZl().getId(), 0L));
            aiVar.a(builder.build(true));
            aiVar.ca(3);
            this.dmB.a(aiVar);
            if (this.dmB.azP()) {
                ArrayList<com.baidu.adp.widget.ListView.h> arrayList = new ArrayList<>();
                arrayList.add(aiVar);
                a = this.dEv.a(false, true, arrayList, null, true);
            } else {
                a = this.dEv.a(false, true, auD.getThreadList(), null, true);
            }
            if (a != null) {
                auD.ax(a);
                auD.buY();
                this.dmq.a(a, auD);
                this.dmq.kD(0);
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

    public void e(PostWriteCallBackData postWriteCallBackData) {
        if (this.dmB != null) {
            boolean z = (this.dmB == null || this.dmB.azf() == null || !this.dmB.azf().isBrandForum) ? false : true;
            if (this.dmB.azL() == 2 || this.dmB.azL() == 3 || this.dmB.azL() == 7 || z) {
                if ((y.avI().kF(1) != null ? this.dmB.azD() : 0) == 0 && postWriteCallBackData != null) {
                    final long c = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getPostId(), 0L);
                    final long c2 = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getThreadId(), 0L);
                    final long c3 = com.baidu.adp.lib.g.b.c(this.dDw.getForumId(), 0L);
                    if (c != 0 && c2 != 0 && c3 != 0) {
                        com.baidu.adp.lib.g.e.in().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.mc.d.5
                            @Override // java.lang.Runnable
                            public void run() {
                                int ah = com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst());
                                int aj = com.baidu.adp.lib.util.l.aj(TbadkCoreApplication.getInst());
                                float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                                int i = 1;
                                if (ar.zw().zy()) {
                                    i = 2;
                                }
                                RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                                requestGetMyPostNetMessage.setParams(c2, c, c3, ah, aj, f, i);
                                d.this.dDw.sendMessage(requestGetMyPostNetMessage);
                            }
                        }, 1000L);
                    }
                }
            }
        }
    }
}
