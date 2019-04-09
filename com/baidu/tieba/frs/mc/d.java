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
    private final com.baidu.adp.framework.listener.a erS;
    private final CustomMessageListener fgb;
    private final CustomMessageListener frk;
    private final CustomMessageListener frl;

    public d(FrsFragment frsFragment) {
        super(frsFragment);
        this.frk = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.frs.mc.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    d.this.e((PostWriteCallBackData) customResponsedMessage.getData());
                }
            }
        };
        this.fgb = new CustomMessageListener(2921031) { // from class: com.baidu.tieba.frs.mc.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!StringUtils.isNull(str) && d.this.fqE.bcP() != null) {
                        FrsViewData bcP = d.this.fqE.bcP();
                        bcP.removeThread(str);
                        d.this.eYF.a(bcP.getThreadList(), bcP);
                        if (com.baidu.tieba.tbadkCore.d.cdq() != null) {
                            com.baidu.tieba.tbadkCore.d.cdq().au(d.this.fqE.getForumName(), false);
                        }
                    }
                }
            }
        };
        this.frl = new CustomMessageListener(2921316) { // from class: com.baidu.tieba.frs.mc.d.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v19, types: [java.util.List] */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ForumManageModel.e eVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ForumManageModel.e) && d.this.fqE != null && d.this.eYF != null && d.this.eYX != null && (eVar = (ForumManageModel.e) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(eVar.threadId) && d.this.fqE.bcP() != null) {
                    String str = eVar.threadId;
                    String str2 = eVar.forumId;
                    String str3 = eVar.forumName;
                    if (eVar.iIp == 4) {
                        FrsViewData bcP = d.this.fqE.bcP();
                        bg threadDataById = bcP.getThreadDataById(str);
                        bcP.removeThreadData(threadDataById);
                        List<m> topThreadList = bcP.getTopThreadList();
                        if (topThreadList == null) {
                            topThreadList = new ArrayList<>();
                        }
                        topThreadList.add(0, threadDataById);
                        d.this.eYF.a(bcP.getThreadList(), bcP);
                        d.this.eYX.h(bcP);
                    }
                    if (TextUtils.equals(d.this.fqE.getForumName(), str3)) {
                        com.baidu.tieba.tbadkCore.d.cdq().au(d.this.fqE.getForumName(), false);
                    }
                }
            }
        };
        this.erS = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_MY_POST, 303111) { // from class: com.baidu.tieba.frs.mc.d.4
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String errorString;
                String errorString2;
                if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                    GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
                    if (StringUtils.isNull(getMyPostHttpResponseMessage.getErrorString())) {
                        errorString2 = d.this.fqE.getResources().getString(d.j.neterror);
                    } else {
                        errorString2 = getMyPostHttpResponseMessage.getErrorString();
                    }
                    d.this.a(getMyPostHttpResponseMessage.getError(), errorString2, getMyPostHttpResponseMessage.getResponseData(), responsedMessage.getOrginalMessage().getExtra() instanceof RequestGetMyPostNetMessage ? ((RequestGetMyPostNetMessage) responsedMessage.getOrginalMessage().getExtra()).getProZone() : 0);
                } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                    GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                    if (StringUtils.isNull(getMyPostSocketResponseMessage.getErrorString())) {
                        errorString = d.this.fqE.getResources().getString(d.j.neterror);
                    } else {
                        errorString = getMyPostSocketResponseMessage.getErrorString();
                    }
                    d.this.a(getMyPostSocketResponseMessage.getError(), errorString, getMyPostSocketResponseMessage.getResponseData(), responsedMessage.getOrginalMessage().getExtra() instanceof RequestGetMyPostNetMessage ? ((RequestGetMyPostNetMessage) responsedMessage.getOrginalMessage().getExtra()).getProZone() : 0);
                }
            }
        };
        this.erS.getSocketMessageListener().setSelfListener(true);
        this.erS.getHttpMessageListener().setSelfListener(true);
        this.fgb.setSelfListener(false);
        this.fqE.registerListener(this.fgb);
        this.fqE.registerListener(this.erS);
        this.fqE.registerListener(this.frk);
        this.fqE.registerListener(this.frl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, GetMyPostResIdl getMyPostResIdl, int i2) {
        ArrayList<m> a;
        if (i != 0) {
            this.fqE.showToast(str);
            return;
        }
        FrsViewData bcP = this.fqE.bcP();
        if (bcP != null && bcP.getForum() != null && getMyPostResIdl != null && this.eYF != null && this.eYW != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
            ak akVar = new ak();
            ThreadInfo.Builder builder = new ThreadInfo.Builder(getMyPostResIdl.data.thread_info);
            User.Builder builder2 = new User.Builder(builder.author);
            a(builder2, getMyPostResIdl.data.user_info);
            builder.author = builder2.build(true);
            builder.cheak_repeat = 1;
            builder.fname = bcP.getForum().getName();
            builder.fid = Long.valueOf(com.baidu.adp.lib.g.b.d(bcP.getForum().getId(), 0L));
            akVar.a(builder.build(true));
            akVar.setCurrentPage(3);
            if (i2 == 1) {
                FrsTabViewController.b bjs = this.fqE.bcq().bjs();
                if (bjs != null && (bjs.fragment instanceof FrsCommonTabFragment)) {
                    ((FrsCommonTabFragment) bjs.fragment).ac(akVar);
                    return;
                }
                return;
            }
            FrsTabViewController.b bjs2 = this.fqE.bcq().bjs();
            if (bjs2 != null && (bjs2.fragment instanceof FrsNewAreaFragment)) {
                ((FrsNewAreaFragment) bjs2.fragment).ac(akVar);
                return;
            }
            this.eYW.addMyNewThread(akVar);
            if (this.eYW.bhR()) {
                ArrayList<m> arrayList = new ArrayList<>();
                arrayList.add(akVar);
                a = this.frQ.a(false, true, arrayList, null, true);
            } else {
                a = this.frQ.a(false, true, bcP.getThreadList(), null, true);
            }
            if (a != null) {
                bcP.setThreadList(a);
                bcP.updateInterviewTaskInfoDataInThreadList();
                this.eYF.a(a, bcP);
                this.eYF.qd(0);
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
        if (this.eYW != null) {
            boolean z = this.eYW.bhm() != null && this.eYW.bhm().getIsBrandForum();
            int bhN = this.eYW.bhN();
            if (bhN == 2 || bhN == 3 || bhN == 7 || bhN == 8 || z) {
                if ((w.beh().ql(1) != null ? this.eYW.bhG() : 0) == 0 && postWriteCallBackData != null) {
                    final long d = com.baidu.adp.lib.g.b.d(postWriteCallBackData.getPostId(), 0L);
                    final long d2 = com.baidu.adp.lib.g.b.d(postWriteCallBackData.getThreadId(), 0L);
                    final long d3 = com.baidu.adp.lib.g.b.d(this.fqE.getForumId(), 0L);
                    if (d != 0 && d2 != 0 && d3 != 0) {
                        com.baidu.adp.lib.g.e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.mc.d.5
                            @Override // java.lang.Runnable
                            public void run() {
                                int aO = com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst());
                                int aQ = com.baidu.adp.lib.util.l.aQ(TbadkCoreApplication.getInst());
                                float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                                int i = 1;
                                if (ar.adm().ado()) {
                                    i = 2;
                                }
                                RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                                requestGetMyPostNetMessage.setProZone(postWriteCallBackData.getProZone());
                                requestGetMyPostNetMessage.setParams(d2, d, d3, aO, aQ, f, i);
                                d.this.fqE.sendMessage(requestGetMyPostNetMessage);
                            }
                        }, 1000L);
                    }
                }
            }
        }
    }
}
