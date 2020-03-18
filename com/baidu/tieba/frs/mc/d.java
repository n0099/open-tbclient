package com.baidu.tieba.frs.mc;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.am;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.vc.FrsTabViewController;
import com.baidu.tieba.frs.y;
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
/* loaded from: classes9.dex */
public class d extends j {
    private final com.baidu.adp.framework.listener.a fQT;
    private final CustomMessageListener gIA;
    private final CustomMessageListener gIB;
    private final CustomMessageListener gwC;

    public d(FrsFragment frsFragment) {
        super(frsFragment);
        this.gIA = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.frs.mc.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    d.this.e((PostWriteCallBackData) customResponsedMessage.getData());
                }
            }
        };
        this.gwC = new CustomMessageListener(CmdConfigCustom.PB_DELETE_THREAD) { // from class: com.baidu.tieba.frs.mc.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!StringUtils.isNull(str) && d.this.gHP.bEz() != null) {
                        FrsViewData bEz = d.this.gHP.bEz();
                        bEz.removeThread(str);
                        d.this.gpj.a(bEz.getThreadList(), bEz);
                        if (com.baidu.tieba.tbadkCore.e.cKw() != null) {
                            com.baidu.tieba.tbadkCore.e.cKw().aA(d.this.gHP.getForumName(), false);
                        }
                    }
                }
            }
        };
        this.gIB = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_MANAGE) { // from class: com.baidu.tieba.frs.mc.d.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v19, types: [java.util.List] */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ForumManageModel.e eVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ForumManageModel.e) && d.this.gHP != null && d.this.gpj != null && d.this.gpA != null && (eVar = (ForumManageModel.e) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(eVar.threadId) && d.this.gHP.bEz() != null) {
                    String str = eVar.threadId;
                    String str2 = eVar.forumId;
                    String str3 = eVar.forumName;
                    if (eVar.kkX == 4) {
                        FrsViewData bEz = d.this.gHP.bEz();
                        bj threadDataById = bEz.getThreadDataById(str);
                        bEz.removeThreadData(threadDataById);
                        List<com.baidu.adp.widget.ListView.m> topThreadList = bEz.getTopThreadList();
                        if (topThreadList == null) {
                            topThreadList = new ArrayList<>();
                        }
                        topThreadList.add(0, threadDataById);
                        d.this.gpj.a(bEz.getThreadList(), bEz);
                        d.this.gpA.i(bEz);
                    }
                    if (TextUtils.equals(d.this.gHP.getForumName(), str3)) {
                        com.baidu.tieba.tbadkCore.e.cKw().aA(d.this.gHP.getForumName(), false);
                    }
                }
            }
        };
        this.fQT = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.frs.mc.d.4
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String errorString;
                String errorString2;
                if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                    GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
                    if (StringUtils.isNull(getMyPostHttpResponseMessage.getErrorString())) {
                        errorString2 = d.this.gHP.getResources().getString(R.string.neterror);
                    } else {
                        errorString2 = getMyPostHttpResponseMessage.getErrorString();
                    }
                    d.this.a(getMyPostHttpResponseMessage.getError(), errorString2, getMyPostHttpResponseMessage.getResponseData(), responsedMessage.getOrginalMessage().getExtra() instanceof RequestGetMyPostNetMessage ? ((RequestGetMyPostNetMessage) responsedMessage.getOrginalMessage().getExtra()).getProZone() : 0);
                } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                    GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                    if (StringUtils.isNull(getMyPostSocketResponseMessage.getErrorString())) {
                        errorString = d.this.gHP.getResources().getString(R.string.neterror);
                    } else {
                        errorString = getMyPostSocketResponseMessage.getErrorString();
                    }
                    d.this.a(getMyPostSocketResponseMessage.getError(), errorString, getMyPostSocketResponseMessage.getResponseData(), responsedMessage.getOrginalMessage().getExtra() instanceof RequestGetMyPostNetMessage ? ((RequestGetMyPostNetMessage) responsedMessage.getOrginalMessage().getExtra()).getProZone() : 0);
                }
            }
        };
        this.fQT.getSocketMessageListener().setSelfListener(true);
        this.fQT.getHttpMessageListener().setSelfListener(true);
        this.gwC.setSelfListener(false);
        this.gHP.registerListener(this.gwC);
        this.gHP.registerListener(this.fQT);
        this.gHP.registerListener(this.gIA);
        this.gHP.registerListener(this.gIB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, GetMyPostResIdl getMyPostResIdl, int i2) {
        if (i != 0) {
            this.gHP.showToast(str);
            return;
        }
        FrsViewData bEz = this.gHP.bEz();
        if (bEz != null && bEz.getForum() != null && getMyPostResIdl != null && this.gpj != null && this.gpz != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
            am amVar = new am();
            ThreadInfo.Builder builder = new ThreadInfo.Builder(getMyPostResIdl.data.thread_info);
            User.Builder builder2 = new User.Builder(builder.author);
            a(builder2, getMyPostResIdl.data.user_info);
            builder.author = builder2.build(true);
            builder.cheak_repeat = 1;
            builder.fname = bEz.getForum().getName();
            builder.fid = Long.valueOf(com.baidu.adp.lib.f.b.toLong(bEz.getForum().getId(), 0L));
            amVar.a(builder.build(true));
            if (i2 == 1) {
                FrsTabViewController.b bLn = this.gHP.bDW().bLn();
                if (bLn != null && (bLn.fragment instanceof FrsCommonTabFragment)) {
                    ((FrsCommonTabFragment) bLn.fragment).am(amVar);
                }
            } else if (amVar.getTabId() > 0) {
                FrsTabViewController.b uw = this.gHP.bDW().uw(amVar.getTabId());
                if (uw != null && (uw.fragment instanceof FrsCommonTabFragment)) {
                    this.gJf.ux(amVar.getTabId());
                    ((FrsCommonTabFragment) uw.fragment).am(amVar);
                }
            } else {
                int bLj = this.gHP.bDW().bLj();
                FrsTabViewController.b uw2 = this.gHP.bDW().uw(bLj);
                if (uw2 != null) {
                    this.gJf.ux(bLj);
                    if (uw2.fragment instanceof FrsNewAreaFragment) {
                        a(amVar, (FrsNewAreaFragment) uw2.fragment);
                    } else {
                        a(amVar);
                    }
                }
            }
        }
    }

    private void a(am amVar) {
        ArrayList<com.baidu.adp.widget.ListView.m> a;
        FrsViewData bEz = this.gHP.bEz();
        if (bEz != null) {
            this.gpz.addMyNewThread(amVar);
            if (this.gpz.bJH()) {
                ArrayList<com.baidu.adp.widget.ListView.m> arrayList = new ArrayList<>();
                arrayList.add(amVar);
                a = this.gJh.a(false, true, arrayList, null, true);
            } else {
                a = this.gJh.a(false, true, bEz.getThreadList(), null, true);
            }
            if (a != null) {
                bEz.setThreadList(a);
                bEz.checkLiveStageInThreadList();
                this.gpj.a(a, bEz);
                this.gpj.sS(0);
            }
        }
    }

    private void a(bj bjVar, FrsNewAreaFragment frsNewAreaFragment) {
        frsNewAreaFragment.am(bjVar);
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
        if (this.gpz != null) {
            boolean z = this.gpz.bIZ() != null && this.gpz.bIZ().getIsBrandForum();
            int bJD = this.gpz.bJD();
            if (bJD == 2 || bJD == 3 || bJD == 7 || bJD == 8 || z) {
                if ((y.bFO().ta(1) != null ? this.gpz.bJw() : 0) == 0 && postWriteCallBackData != null) {
                    final long j = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getPostId(), 0L);
                    final long j2 = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getThreadId(), 0L);
                    final long j3 = com.baidu.adp.lib.f.b.toLong(this.gHP.getForumId(), 0L);
                    if (j != 0 && j2 != 0 && j3 != 0) {
                        com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.mc.d.5
                            @Override // java.lang.Runnable
                            public void run() {
                                int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
                                int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
                                float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                                int i = 1;
                                if (ar.aGH().aGI()) {
                                    i = 2;
                                }
                                RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                                requestGetMyPostNetMessage.setProZone(postWriteCallBackData.getProZone());
                                requestGetMyPostNetMessage.setParams(j2, j, j3, equipmentWidth, equipmentHeight, f, i);
                                d.this.gHP.sendMessage(requestGetMyPostNetMessage);
                            }
                        }, 1000L);
                    }
                }
            }
        }
    }
}
