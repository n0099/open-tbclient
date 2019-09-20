package com.baidu.tieba.frs.mc;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
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
    private final com.baidu.adp.framework.listener.a eOj;
    private final CustomMessageListener fDM;
    private final CustomMessageListener fPk;
    private final CustomMessageListener fPl;

    public d(FrsFragment frsFragment) {
        super(frsFragment);
        this.fPk = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.frs.mc.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    d.this.e((PostWriteCallBackData) customResponsedMessage.getData());
                }
            }
        };
        this.fDM = new CustomMessageListener(2921031) { // from class: com.baidu.tieba.frs.mc.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!StringUtils.isNull(str) && d.this.fOE.bnj() != null) {
                        FrsViewData bnj = d.this.fOE.bnj();
                        bnj.removeThread(str);
                        d.this.fwb.a(bnj.getThreadList(), bnj);
                        if (com.baidu.tieba.tbadkCore.d.cpu() != null) {
                            com.baidu.tieba.tbadkCore.d.cpu().aA(d.this.fOE.getForumName(), false);
                        }
                    }
                }
            }
        };
        this.fPl = new CustomMessageListener(2921316) { // from class: com.baidu.tieba.frs.mc.d.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v19, types: [java.util.List] */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ForumManageModel.e eVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ForumManageModel.e) && d.this.fOE != null && d.this.fwb != null && d.this.fwt != null && (eVar = (ForumManageModel.e) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(eVar.threadId) && d.this.fOE.bnj() != null) {
                    String str = eVar.threadId;
                    String str2 = eVar.forumId;
                    String str3 = eVar.forumName;
                    if (eVar.jli == 4) {
                        FrsViewData bnj = d.this.fOE.bnj();
                        bh threadDataById = bnj.getThreadDataById(str);
                        bnj.removeThreadData(threadDataById);
                        List<m> topThreadList = bnj.getTopThreadList();
                        if (topThreadList == null) {
                            topThreadList = new ArrayList<>();
                        }
                        topThreadList.add(0, threadDataById);
                        d.this.fwb.a(bnj.getThreadList(), bnj);
                        d.this.fwt.i(bnj);
                    }
                    if (TextUtils.equals(d.this.fOE.getForumName(), str3)) {
                        com.baidu.tieba.tbadkCore.d.cpu().aA(d.this.fOE.getForumName(), false);
                    }
                }
            }
        };
        this.eOj = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_MY_POST, 303111) { // from class: com.baidu.tieba.frs.mc.d.4
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String errorString;
                String errorString2;
                if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                    GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
                    if (StringUtils.isNull(getMyPostHttpResponseMessage.getErrorString())) {
                        errorString2 = d.this.fOE.getResources().getString(R.string.neterror);
                    } else {
                        errorString2 = getMyPostHttpResponseMessage.getErrorString();
                    }
                    d.this.a(getMyPostHttpResponseMessage.getError(), errorString2, getMyPostHttpResponseMessage.getResponseData(), responsedMessage.getOrginalMessage().getExtra() instanceof RequestGetMyPostNetMessage ? ((RequestGetMyPostNetMessage) responsedMessage.getOrginalMessage().getExtra()).getProZone() : 0);
                } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                    GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                    if (StringUtils.isNull(getMyPostSocketResponseMessage.getErrorString())) {
                        errorString = d.this.fOE.getResources().getString(R.string.neterror);
                    } else {
                        errorString = getMyPostSocketResponseMessage.getErrorString();
                    }
                    d.this.a(getMyPostSocketResponseMessage.getError(), errorString, getMyPostSocketResponseMessage.getResponseData(), responsedMessage.getOrginalMessage().getExtra() instanceof RequestGetMyPostNetMessage ? ((RequestGetMyPostNetMessage) responsedMessage.getOrginalMessage().getExtra()).getProZone() : 0);
                }
            }
        };
        this.eOj.getSocketMessageListener().setSelfListener(true);
        this.eOj.getHttpMessageListener().setSelfListener(true);
        this.fDM.setSelfListener(false);
        this.fOE.registerListener(this.fDM);
        this.fOE.registerListener(this.eOj);
        this.fOE.registerListener(this.fPk);
        this.fOE.registerListener(this.fPl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, GetMyPostResIdl getMyPostResIdl, int i2) {
        ArrayList<m> a;
        if (i != 0) {
            this.fOE.showToast(str);
            return;
        }
        FrsViewData bnj = this.fOE.bnj();
        if (bnj != null && bnj.getForum() != null && getMyPostResIdl != null && this.fwb != null && this.fws != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
            ak akVar = new ak();
            ThreadInfo.Builder builder = new ThreadInfo.Builder(getMyPostResIdl.data.thread_info);
            User.Builder builder2 = new User.Builder(builder.author);
            a(builder2, getMyPostResIdl.data.user_info);
            builder.author = builder2.build(true);
            builder.cheak_repeat = 1;
            builder.fname = bnj.getForum().getName();
            builder.fid = Long.valueOf(com.baidu.adp.lib.g.b.e(bnj.getForum().getId(), 0L));
            akVar.a(builder.build(true));
            akVar.setCurrentPage(3);
            if (i2 == 1) {
                FrsTabViewController.b btR = this.fOE.bmH().btR();
                if (btR != null && (btR.fragment instanceof FrsCommonTabFragment)) {
                    ((FrsCommonTabFragment) btR.fragment).ae(akVar);
                    return;
                }
                return;
            }
            FrsTabViewController.b btR2 = this.fOE.bmH().btR();
            if (btR2 != null && (btR2.fragment instanceof FrsNewAreaFragment)) {
                ((FrsNewAreaFragment) btR2.fragment).ae(akVar);
                return;
            }
            this.fws.addMyNewThread(akVar);
            if (this.fws.bsp()) {
                ArrayList<m> arrayList = new ArrayList<>();
                arrayList.add(akVar);
                a = this.fPQ.a(false, true, arrayList, null, true);
            } else {
                a = this.fPQ.a(false, true, bnj.getThreadList(), null, true);
            }
            if (a != null) {
                bnj.setThreadList(a);
                bnj.checkLiveStageInThreadList();
                this.fwb.a(a, bnj);
                this.fwb.rH(0);
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
        if (this.fws != null) {
            boolean z = this.fws.brI() != null && this.fws.brI().getIsBrandForum();
            int bsl = this.fws.bsl();
            if (bsl == 2 || bsl == 3 || bsl == 7 || bsl == 8 || z) {
                if ((w.boy().rP(1) != null ? this.fws.bse() : 0) == 0 && postWriteCallBackData != null) {
                    final long e = com.baidu.adp.lib.g.b.e(postWriteCallBackData.getPostId(), 0L);
                    final long e2 = com.baidu.adp.lib.g.b.e(postWriteCallBackData.getThreadId(), 0L);
                    final long e3 = com.baidu.adp.lib.g.b.e(this.fOE.getForumId(), 0L);
                    if (e != 0 && e2 != 0 && e3 != 0) {
                        com.baidu.adp.lib.g.e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.mc.d.5
                            @Override // java.lang.Runnable
                            public void run() {
                                int af = com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst());
                                int ah = com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst());
                                float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                                int i = 1;
                                if (ar.ajw().ajy()) {
                                    i = 2;
                                }
                                RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                                requestGetMyPostNetMessage.setProZone(postWriteCallBackData.getProZone());
                                requestGetMyPostNetMessage.setParams(e2, e, e3, af, ah, f, i);
                                d.this.fOE.sendMessage(requestGetMyPostNetMessage);
                            }
                        }, 1000L);
                    }
                }
            }
        }
    }
}
