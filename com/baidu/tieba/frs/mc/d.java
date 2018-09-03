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
import com.baidu.tieba.f;
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
    private final com.baidu.adp.framework.listener.a cIH;
    private final CustomMessageListener dDY;
    private final CustomMessageListener dDZ;
    private final CustomMessageListener dEa;

    public d(FrsFragment frsFragment) {
        super(frsFragment);
        this.dDY = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.frs.mc.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    d.this.e((PostWriteCallBackData) customResponsedMessage.getData());
                }
            }
        };
        this.dDZ = new CustomMessageListener(2921031) { // from class: com.baidu.tieba.frs.mc.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!StringUtils.isNull(str) && d.this.dDt.auC() != null) {
                        l auC = d.this.dDt.auC();
                        auC.aa(auC.mE(str));
                        d.this.dmo.a(auC.getThreadList(), auC);
                        if (com.baidu.tieba.tbadkCore.c.btS() != null) {
                            com.baidu.tieba.tbadkCore.c.btS().T(d.this.dDt.getForumName(), false);
                        }
                    }
                }
            }
        };
        this.dEa = new CustomMessageListener(2921316) { // from class: com.baidu.tieba.frs.mc.d.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v19, types: [java.util.List] */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ForumManageModel.e eVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ForumManageModel.e) && d.this.dDt != null && d.this.dmo != null && d.this.dmA != null && (eVar = (ForumManageModel.e) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(eVar.threadId) && d.this.dDt.auC() != null) {
                    String str = eVar.threadId;
                    String str2 = eVar.forumId;
                    String str3 = eVar.forumName;
                    if (eVar.gQt == 4) {
                        l auC = d.this.dDt.auC();
                        bb mE = auC.mE(str);
                        auC.aa(mE);
                        List<com.baidu.adp.widget.ListView.h> bvo = auC.bvo();
                        if (bvo == null) {
                            bvo = new ArrayList<>();
                        }
                        bvo.add(0, mE);
                        d.this.dmo.a(auC.getThreadList(), auC);
                        d.this.dmA.h(auC);
                    }
                    if (TextUtils.equals(d.this.dDt.getForumName(), str3)) {
                        com.baidu.tieba.tbadkCore.c.btS().T(d.this.dDt.getForumName(), false);
                    }
                }
            }
        };
        this.cIH = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_MY_POST, 303111) { // from class: com.baidu.tieba.frs.mc.d.4
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String errorString;
                String errorString2;
                if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                    GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
                    if (StringUtils.isNull(getMyPostHttpResponseMessage.getErrorString())) {
                        errorString2 = d.this.dDt.getResources().getString(f.j.neterror);
                    } else {
                        errorString2 = getMyPostHttpResponseMessage.getErrorString();
                    }
                    d.this.a(getMyPostHttpResponseMessage.getError(), errorString2, getMyPostHttpResponseMessage.getResponseData());
                } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                    GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                    if (StringUtils.isNull(getMyPostSocketResponseMessage.getErrorString())) {
                        errorString = d.this.dDt.getResources().getString(f.j.neterror);
                    } else {
                        errorString = getMyPostSocketResponseMessage.getErrorString();
                    }
                    d.this.a(getMyPostSocketResponseMessage.getError(), errorString, getMyPostSocketResponseMessage.getResponseData());
                }
            }
        };
        this.cIH.getSocketMessageListener().setSelfListener(true);
        this.cIH.getHttpMessageListener().setSelfListener(true);
        this.dDZ.setSelfListener(false);
        this.dDt.registerListener(this.dDZ);
        this.dDt.registerListener(this.cIH);
        this.dDt.registerListener(this.dDY);
        this.dDt.registerListener(this.dEa);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, GetMyPostResIdl getMyPostResIdl) {
        ArrayList<com.baidu.adp.widget.ListView.h> a;
        if (i != 0) {
            this.dDt.showToast(str);
            return;
        }
        l auC = this.dDt.auC();
        if (auC != null && auC.aZg() != null && getMyPostResIdl != null && this.dmo != null && this.dmz != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
            ai aiVar = new ai();
            ThreadInfo.Builder builder = new ThreadInfo.Builder(getMyPostResIdl.data.thread_info);
            User.Builder builder2 = new User.Builder(builder.author);
            a(builder2, getMyPostResIdl.data.user_info);
            builder.author = builder2.build(true);
            builder.cheak_repeat = 1;
            builder.fname = auC.aZg().getName();
            builder.fid = Long.valueOf(com.baidu.adp.lib.g.b.c(auC.aZg().getId(), 0L));
            aiVar.a(builder.build(true));
            aiVar.ca(3);
            this.dmz.a(aiVar);
            if (this.dmz.azM()) {
                ArrayList<com.baidu.adp.widget.ListView.h> arrayList = new ArrayList<>();
                arrayList.add(aiVar);
                a = this.dEs.a(false, true, arrayList, null, true);
            } else {
                a = this.dEs.a(false, true, auC.getThreadList(), null, true);
            }
            if (a != null) {
                auC.ax(a);
                auC.buZ();
                this.dmo.a(a, auC);
                this.dmo.kC(0);
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
        if (this.dmz != null) {
            boolean z = (this.dmz == null || this.dmz.azd() == null || !this.dmz.azd().isBrandForum) ? false : true;
            if (this.dmz.azI() == 2 || this.dmz.azI() == 3 || this.dmz.azI() == 7 || z) {
                if ((y.avH().kE(1) != null ? this.dmz.azA() : 0) == 0 && postWriteCallBackData != null) {
                    final long c = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getPostId(), 0L);
                    final long c2 = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getThreadId(), 0L);
                    final long c3 = com.baidu.adp.lib.g.b.c(this.dDt.getForumId(), 0L);
                    if (c != 0 && c2 != 0 && c3 != 0) {
                        com.baidu.adp.lib.g.e.in().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.mc.d.5
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
                                requestGetMyPostNetMessage.setParams(c2, c, c3, ah, aj, f, i);
                                d.this.dDt.sendMessage(requestGetMyPostNetMessage);
                            }
                        }, 1000L);
                    }
                }
            }
        }
    }
}
