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
import com.baidu.tieba.frs.ab;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.vc.FrsTabViewController;
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
    private final com.baidu.adp.framework.listener.a gvB;
    private final CustomMessageListener hfN;
    private final CustomMessageListener hrS;
    private final CustomMessageListener hrT;

    public d(FrsFragment frsFragment) {
        super(frsFragment);
        this.hrS = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.frs.mc.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && !((PostWriteCallBackData) customResponsedMessage.getData()).isDyamicCallback()) {
                    d.this.e((PostWriteCallBackData) customResponsedMessage.getData());
                }
            }
        };
        this.hfN = new CustomMessageListener(CmdConfigCustom.PB_DELETE_THREAD) { // from class: com.baidu.tieba.frs.mc.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!StringUtils.isNull(str) && d.this.hri.bOY() != null) {
                        FrsViewData bOY = d.this.hri.bOY();
                        bOY.removeThread(str);
                        d.this.gYq.a(bOY.getThreadList(), bOY);
                        if (com.baidu.tieba.tbadkCore.e.cVs() != null) {
                            com.baidu.tieba.tbadkCore.e.cVs().aG(d.this.hri.getForumName(), false);
                        }
                    }
                }
            }
        };
        this.hrT = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_MANAGE) { // from class: com.baidu.tieba.frs.mc.d.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v19, types: [java.util.List] */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ForumManageModel.e eVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ForumManageModel.e) && d.this.hri != null && d.this.gYq != null && d.this.gYH != null && (eVar = (ForumManageModel.e) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(eVar.threadId) && d.this.hri.bOY() != null) {
                    String str = eVar.threadId;
                    String str2 = eVar.forumId;
                    String str3 = eVar.forumName;
                    if (eVar.kVd == 4) {
                        FrsViewData bOY = d.this.hri.bOY();
                        bj threadDataById = bOY.getThreadDataById(str);
                        bOY.removeThreadData(threadDataById);
                        List<com.baidu.adp.widget.ListView.m> topThreadList = bOY.getTopThreadList();
                        if (topThreadList == null) {
                            topThreadList = new ArrayList<>();
                        }
                        topThreadList.add(0, threadDataById);
                        d.this.gYq.a(bOY.getThreadList(), bOY);
                        d.this.gYH.i(bOY);
                    }
                    if (TextUtils.equals(d.this.hri.getForumName(), str3)) {
                        com.baidu.tieba.tbadkCore.e.cVs().aG(d.this.hri.getForumName(), false);
                    }
                }
            }
        };
        this.gvB = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.frs.mc.d.4
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String errorString;
                String errorString2;
                if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                    GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
                    if (StringUtils.isNull(getMyPostHttpResponseMessage.getErrorString())) {
                        errorString2 = d.this.hri.getResources().getString(R.string.neterror);
                    } else {
                        errorString2 = getMyPostHttpResponseMessage.getErrorString();
                    }
                    d.this.a(getMyPostHttpResponseMessage.getError(), errorString2, getMyPostHttpResponseMessage.getResponseData(), responsedMessage.getOrginalMessage().getExtra() instanceof RequestGetMyPostNetMessage ? ((RequestGetMyPostNetMessage) responsedMessage.getOrginalMessage().getExtra()).getProZone() : 0);
                } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                    GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                    if (StringUtils.isNull(getMyPostSocketResponseMessage.getErrorString())) {
                        errorString = d.this.hri.getResources().getString(R.string.neterror);
                    } else {
                        errorString = getMyPostSocketResponseMessage.getErrorString();
                    }
                    d.this.a(getMyPostSocketResponseMessage.getError(), errorString, getMyPostSocketResponseMessage.getResponseData(), responsedMessage.getOrginalMessage().getExtra() instanceof RequestGetMyPostNetMessage ? ((RequestGetMyPostNetMessage) responsedMessage.getOrginalMessage().getExtra()).getProZone() : 0);
                }
            }
        };
        this.gvB.getSocketMessageListener().setSelfListener(true);
        this.gvB.getHttpMessageListener().setSelfListener(true);
        this.hfN.setSelfListener(false);
        this.hri.registerListener(this.hfN);
        this.hri.registerListener(this.gvB);
        this.hri.registerListener(this.hrS);
        this.hri.registerListener(this.hrT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, GetMyPostResIdl getMyPostResIdl, int i2) {
        if (i != 0) {
            this.hri.showToast(str);
            return;
        }
        FrsViewData bOY = this.hri.bOY();
        if (bOY != null && bOY.getForum() != null && getMyPostResIdl != null && this.gYq != null && this.gYG != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
            am amVar = new am();
            ThreadInfo.Builder builder = new ThreadInfo.Builder(getMyPostResIdl.data.thread_info);
            User.Builder builder2 = new User.Builder(builder.author);
            a(builder2, getMyPostResIdl.data.user_info);
            builder.author = builder2.build(true);
            builder.cheak_repeat = 1;
            builder.fname = bOY.getForum().getName();
            builder.fid = Long.valueOf(com.baidu.adp.lib.f.b.toLong(bOY.getForum().getId(), 0L));
            amVar.a(builder.build(true));
            if (i2 == 1) {
                FrsTabViewController.b bVR = this.hri.bOv().bVR();
                if (bVR != null && (bVR.fragment instanceof FrsCommonTabFragment)) {
                    ((FrsCommonTabFragment) bVR.fragment).ao(amVar);
                }
            } else if (amVar.getTabId() > 0) {
                FrsTabViewController.b uU = this.hri.bOv().uU(amVar.getTabId());
                if (uU != null && (uU.fragment instanceof FrsCommonTabFragment)) {
                    this.hsv.uV(amVar.getTabId());
                    ((FrsCommonTabFragment) uU.fragment).ao(amVar);
                }
            } else {
                int bVN = this.hri.bOv().bVN();
                FrsTabViewController.b uU2 = this.hri.bOv().uU(bVN);
                if (uU2 != null) {
                    this.hsv.uV(bVN);
                    if (uU2.fragment instanceof FrsNewAreaFragment) {
                        a(amVar, (FrsNewAreaFragment) uU2.fragment);
                    } else {
                        a(amVar);
                    }
                }
            }
        }
    }

    private void a(am amVar) {
        ArrayList<com.baidu.adp.widget.ListView.m> a;
        FrsViewData bOY = this.hri.bOY();
        if (bOY != null) {
            this.gYG.addMyNewThread(amVar);
            if (this.gYG.bUe()) {
                ArrayList<com.baidu.adp.widget.ListView.m> arrayList = new ArrayList<>();
                arrayList.add(amVar);
                a = this.hsx.a(false, true, arrayList, null, true);
            } else {
                a = this.hsx.a(false, true, bOY.getThreadList(), null, true);
            }
            if (a != null) {
                bOY.setThreadList(a);
                bOY.checkLiveStageInThreadList();
                this.gYq.a(a, bOY);
                this.gYq.tq(0);
            }
        }
    }

    private void a(bj bjVar, FrsNewAreaFragment frsNewAreaFragment) {
        frsNewAreaFragment.ao(bjVar);
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
        if (this.gYG != null) {
            boolean z = this.gYG.bTw() != null && this.gYG.bTw().getIsBrandForum();
            int bUa = this.gYG.bUa();
            if (bUa == 2 || bUa == 3 || bUa == 7 || bUa == 8 || z) {
                if ((ab.bQq().ty(1) != null ? this.gYG.bTT() : 0) == 0 && postWriteCallBackData != null) {
                    final long j = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getPostId(), 0L);
                    final long j2 = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getThreadId(), 0L);
                    final long j3 = com.baidu.adp.lib.f.b.toLong(this.hri.getForumId(), 0L);
                    if (j != 0 && j2 != 0 && j3 != 0) {
                        com.baidu.adp.lib.f.e.lb().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.mc.d.5
                            @Override // java.lang.Runnable
                            public void run() {
                                int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
                                int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
                                float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                                int i = 1;
                                if (ar.aOV().aOW()) {
                                    i = 2;
                                }
                                RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                                requestGetMyPostNetMessage.setProZone(postWriteCallBackData.getProZone());
                                requestGetMyPostNetMessage.setParams(j2, j, j3, equipmentWidth, equipmentHeight, f, i);
                                d.this.hri.sendMessage(requestGetMyPostNetMessage);
                            }
                        }, 1000L);
                    }
                }
            }
        }
    }
}
