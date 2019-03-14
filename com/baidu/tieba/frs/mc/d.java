package com.baidu.tieba.frs.mc;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.vc.FrsTabViewController;
import com.baidu.tieba.frs.w;
import com.baidu.tieba.homepage.GetMyPostHttpResponseMessage;
import com.baidu.tieba.homepage.GetMyPostSocketResponseMessage;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetMyPost.GetMyPostResIdl;
import tbclient.GetMyPost.User_Info;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes4.dex */
public class d extends j {
    private final com.baidu.adp.framework.listener.a esf;
    private final CustomMessageListener fgo;
    private final CustomMessageListener frA;
    private final CustomMessageListener frz;

    public d(FrsFragment frsFragment) {
        super(frsFragment);
        this.frz = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.frs.mc.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    d.this.e((PostWriteCallBackData) customResponsedMessage.getData());
                }
            }
        };
        this.fgo = new CustomMessageListener(2921031) { // from class: com.baidu.tieba.frs.mc.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!StringUtils.isNull(str) && d.this.fqS.bcR() != null) {
                        FrsViewData bcR = d.this.fqS.bcR();
                        bcR.removeThread(str);
                        d.this.eYS.a(bcR.getThreadList(), bcR);
                        if (com.baidu.tieba.tbadkCore.d.cdu() != null) {
                            com.baidu.tieba.tbadkCore.d.cdu().au(d.this.fqS.getForumName(), false);
                        }
                    }
                }
            }
        };
        this.frA = new CustomMessageListener(2921316) { // from class: com.baidu.tieba.frs.mc.d.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v19, types: [java.util.List] */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ForumManageModel.e eVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ForumManageModel.e) && d.this.fqS != null && d.this.eYS != null && d.this.eZk != null && (eVar = (ForumManageModel.e) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(eVar.threadId) && d.this.fqS.bcR() != null) {
                    String str = eVar.threadId;
                    String str2 = eVar.forumId;
                    String str3 = eVar.forumName;
                    if (eVar.iID == 4) {
                        FrsViewData bcR = d.this.fqS.bcR();
                        bg threadDataById = bcR.getThreadDataById(str);
                        bcR.removeThreadData(threadDataById);
                        List<m> topThreadList = bcR.getTopThreadList();
                        if (topThreadList == null) {
                            topThreadList = new ArrayList<>();
                        }
                        topThreadList.add(0, threadDataById);
                        d.this.eYS.a(bcR.getThreadList(), bcR);
                        d.this.eZk.h(bcR);
                    }
                    if (TextUtils.equals(d.this.fqS.getForumName(), str3)) {
                        com.baidu.tieba.tbadkCore.d.cdu().au(d.this.fqS.getForumName(), false);
                    }
                }
            }
        };
        this.esf = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_MY_POST, 303111) { // from class: com.baidu.tieba.frs.mc.d.4
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String errorString;
                String errorString2;
                if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                    GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
                    if (StringUtils.isNull(getMyPostHttpResponseMessage.getErrorString())) {
                        errorString2 = d.this.fqS.getResources().getString(d.j.neterror);
                    } else {
                        errorString2 = getMyPostHttpResponseMessage.getErrorString();
                    }
                    d.this.a(getMyPostHttpResponseMessage.getError(), errorString2, getMyPostHttpResponseMessage.getResponseData(), responsedMessage.getOrginalMessage().getExtra() instanceof RequestGetMyPostNetMessage ? ((RequestGetMyPostNetMessage) responsedMessage.getOrginalMessage().getExtra()).getProZone() : 0);
                } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                    GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                    if (StringUtils.isNull(getMyPostSocketResponseMessage.getErrorString())) {
                        errorString = d.this.fqS.getResources().getString(d.j.neterror);
                    } else {
                        errorString = getMyPostSocketResponseMessage.getErrorString();
                    }
                    d.this.a(getMyPostSocketResponseMessage.getError(), errorString, getMyPostSocketResponseMessage.getResponseData(), responsedMessage.getOrginalMessage().getExtra() instanceof RequestGetMyPostNetMessage ? ((RequestGetMyPostNetMessage) responsedMessage.getOrginalMessage().getExtra()).getProZone() : 0);
                }
            }
        };
        this.esf.getSocketMessageListener().setSelfListener(true);
        this.esf.getHttpMessageListener().setSelfListener(true);
        this.fgo.setSelfListener(false);
        this.fqS.registerListener(this.fgo);
        this.fqS.registerListener(this.esf);
        this.fqS.registerListener(this.frz);
        this.fqS.registerListener(this.frA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, GetMyPostResIdl getMyPostResIdl, int i2) {
        ArrayList<m> a;
        if (i != 0) {
            this.fqS.showToast(str);
            return;
        }
        FrsViewData bcR = this.fqS.bcR();
        if (bcR != null && bcR.getForum() != null && getMyPostResIdl != null && this.eYS != null && this.eZj != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
            ak akVar = new ak();
            ThreadInfo.Builder builder = new ThreadInfo.Builder(getMyPostResIdl.data.thread_info);
            User.Builder builder2 = new User.Builder(builder.author);
            a(builder2, getMyPostResIdl.data.user_info);
            builder.author = builder2.build(true);
            builder.cheak_repeat = 1;
            builder.fname = bcR.getForum().getName();
            builder.fid = Long.valueOf(com.baidu.adp.lib.g.b.d(bcR.getForum().getId(), 0L));
            akVar.a(builder.build(true));
            akVar.setCurrentPage(3);
            if (i2 == 1) {
                FrsTabViewController.b bju = this.fqS.bcs().bju();
                if (bju != null && (bju.fragment instanceof FrsCommonTabFragment)) {
                    ((FrsCommonTabFragment) bju.fragment).ad(akVar);
                    return;
                }
                return;
            }
            FrsTabViewController.b bju2 = this.fqS.bcs().bju();
            if (bju2 != null && (bju2.fragment instanceof FrsNewAreaFragment)) {
                ((FrsNewAreaFragment) bju2.fragment).ad(akVar);
                return;
            }
            this.eZj.addMyNewThread(akVar);
            if (this.eZj.bhT()) {
                ArrayList<m> arrayList = new ArrayList<>();
                arrayList.add(akVar);
                a = this.fse.a(false, true, arrayList, null, true);
            } else {
                a = this.fse.a(false, true, bcR.getThreadList(), null, true);
            }
            if (a != null) {
                bcR.setThreadList(a);
                bcR.updateInterviewTaskInfoDataInThreadList();
                this.eYS.a(a, bcR);
                this.eYS.qh(0);
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

    public void e(final PostWriteCallBackData postWriteCallBackData) {
        if (this.eZj != null) {
            boolean z = this.eZj.bho() != null && this.eZj.bho().getIsBrandForum();
            int bhP = this.eZj.bhP();
            if (bhP == 2 || bhP == 3 || bhP == 7 || bhP == 8 || z) {
                if ((w.bej().qp(1) != null ? this.eZj.bhI() : 0) == 0 && postWriteCallBackData != null) {
                    final long d = com.baidu.adp.lib.g.b.d(postWriteCallBackData.getPostId(), 0L);
                    final long d2 = com.baidu.adp.lib.g.b.d(postWriteCallBackData.getThreadId(), 0L);
                    final long d3 = com.baidu.adp.lib.g.b.d(this.fqS.getForumId(), 0L);
                    if (d != 0 && d2 != 0 && d3 != 0) {
                        com.baidu.adp.lib.g.e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.mc.d.5
                            @Override // java.lang.Runnable
                            public void run() {
                                int aO = com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst());
                                int aQ = com.baidu.adp.lib.util.l.aQ(TbadkCoreApplication.getInst());
                                float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                                int i = 1;
                                if (ar.adp().adr()) {
                                    i = 2;
                                }
                                RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                                requestGetMyPostNetMessage.setProZone(postWriteCallBackData.getProZone());
                                requestGetMyPostNetMessage.setParams(d2, d, d3, aO, aQ, f, i);
                                d.this.fqS.sendMessage(requestGetMyPostNetMessage);
                            }
                        }, 1000L);
                    }
                }
            }
        }
    }
}
