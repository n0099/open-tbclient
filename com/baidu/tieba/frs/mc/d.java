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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.e;
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
/* loaded from: classes6.dex */
public class d extends h {
    private final com.baidu.adp.framework.listener.a cWP;
    private final CustomMessageListener dSL;
    private final CustomMessageListener dSM;
    private final CustomMessageListener dSN;

    public d(FrsFragment frsFragment) {
        super(frsFragment);
        this.dSL = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.frs.mc.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    d.this.e((PostWriteCallBackData) customResponsedMessage.getData());
                }
            }
        };
        this.dSM = new CustomMessageListener(2921031) { // from class: com.baidu.tieba.frs.mc.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!StringUtils.isNull(str) && d.this.dSg.azS() != null) {
                        l azS = d.this.dSg.azS();
                        azS.ab(azS.nJ(str));
                        d.this.dAn.a(azS.getThreadList(), azS);
                        if (com.baidu.tieba.tbadkCore.c.bzN() != null) {
                            com.baidu.tieba.tbadkCore.c.bzN().ab(d.this.dSg.getForumName(), false);
                        }
                    }
                }
            }
        };
        this.dSN = new CustomMessageListener(2921316) { // from class: com.baidu.tieba.frs.mc.d.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v19, types: [java.util.List] */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ForumManageModel.e eVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ForumManageModel.e) && d.this.dSg != null && d.this.dAn != null && d.this.dAy != null && (eVar = (ForumManageModel.e) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(eVar.threadId) && d.this.dSg.azS() != null) {
                    String str = eVar.threadId;
                    String str2 = eVar.forumId;
                    String str3 = eVar.forumName;
                    if (eVar.hfs == 4) {
                        l azS = d.this.dSg.azS();
                        bb nJ = azS.nJ(str);
                        azS.ab(nJ);
                        List<com.baidu.adp.widget.ListView.h> bBj = azS.bBj();
                        if (bBj == null) {
                            bBj = new ArrayList<>();
                        }
                        bBj.add(0, nJ);
                        d.this.dAn.a(azS.getThreadList(), azS);
                        d.this.dAy.h(azS);
                    }
                    if (TextUtils.equals(d.this.dSg.getForumName(), str3)) {
                        com.baidu.tieba.tbadkCore.c.bzN().ab(d.this.dSg.getForumName(), false);
                    }
                }
            }
        };
        this.cWP = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_MY_POST, 303111) { // from class: com.baidu.tieba.frs.mc.d.4
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String errorString;
                String errorString2;
                if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                    GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
                    if (StringUtils.isNull(getMyPostHttpResponseMessage.getErrorString())) {
                        errorString2 = d.this.dSg.getResources().getString(e.j.neterror);
                    } else {
                        errorString2 = getMyPostHttpResponseMessage.getErrorString();
                    }
                    d.this.a(getMyPostHttpResponseMessage.getError(), errorString2, getMyPostHttpResponseMessage.getResponseData());
                } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                    GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                    if (StringUtils.isNull(getMyPostSocketResponseMessage.getErrorString())) {
                        errorString = d.this.dSg.getResources().getString(e.j.neterror);
                    } else {
                        errorString = getMyPostSocketResponseMessage.getErrorString();
                    }
                    d.this.a(getMyPostSocketResponseMessage.getError(), errorString, getMyPostSocketResponseMessage.getResponseData());
                }
            }
        };
        this.cWP.getSocketMessageListener().setSelfListener(true);
        this.cWP.getHttpMessageListener().setSelfListener(true);
        this.dSM.setSelfListener(false);
        this.dSg.registerListener(this.dSM);
        this.dSg.registerListener(this.cWP);
        this.dSg.registerListener(this.dSL);
        this.dSg.registerListener(this.dSN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, GetMyPostResIdl getMyPostResIdl) {
        ArrayList<com.baidu.adp.widget.ListView.h> a;
        if (i != 0) {
            this.dSg.showToast(str);
            return;
        }
        l azS = this.dSg.azS();
        if (azS != null && azS.beT() != null && getMyPostResIdl != null && this.dAn != null && this.dAx != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
            ai aiVar = new ai();
            ThreadInfo.Builder builder = new ThreadInfo.Builder(getMyPostResIdl.data.thread_info);
            User.Builder builder2 = new User.Builder(builder.author);
            a(builder2, getMyPostResIdl.data.user_info);
            builder.author = builder2.build(true);
            builder.cheak_repeat = 1;
            builder.fname = azS.beT().getName();
            builder.fid = Long.valueOf(com.baidu.adp.lib.g.b.d(azS.beT().getId(), 0L));
            aiVar.a(builder.build(true));
            aiVar.setCurrentPage(3);
            this.dAx.a(aiVar);
            if (this.dAx.aFo()) {
                ArrayList<com.baidu.adp.widget.ListView.h> arrayList = new ArrayList<>();
                arrayList.add(aiVar);
                a = this.dTf.a(false, true, arrayList, null, true);
            } else {
                a = this.dTf.a(false, true, azS.getThreadList(), null, true);
            }
            if (a != null) {
                azS.ay(a);
                azS.bAU();
                this.dAn.a(a, azS);
                this.dAn.lz(0);
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
        if (this.dAx != null) {
            boolean z = this.dAx.aEE() != null && this.dAx.aEE().bAV();
            int aFk = this.dAx.aFk();
            if (aFk == 2 || aFk == 3 || aFk == 7 || aFk == 8 || z) {
                if ((y.aBk().lF(1) != null ? this.dAx.aFc() : 0) == 0 && postWriteCallBackData != null) {
                    final long d = com.baidu.adp.lib.g.b.d(postWriteCallBackData.getPostId(), 0L);
                    final long d2 = com.baidu.adp.lib.g.b.d(postWriteCallBackData.getThreadId(), 0L);
                    final long d3 = com.baidu.adp.lib.g.b.d(this.dSg.getForumId(), 0L);
                    if (d != 0 && d2 != 0 && d3 != 0) {
                        com.baidu.adp.lib.g.e.jI().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.mc.d.5
                            @Override // java.lang.Runnable
                            public void run() {
                                int aO = com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst());
                                int aQ = com.baidu.adp.lib.util.l.aQ(TbadkCoreApplication.getInst());
                                float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                                int i = 1;
                                if (aq.CG().CI()) {
                                    i = 2;
                                }
                                RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                                requestGetMyPostNetMessage.setParams(d2, d, d3, aO, aQ, f, i);
                                d.this.dSg.sendMessage(requestGetMyPostNetMessage);
                            }
                        }, 1000L);
                    }
                }
            }
        }
    }
}
