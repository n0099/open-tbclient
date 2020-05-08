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
    private final com.baidu.adp.framework.listener.a gvH;
    private final CustomMessageListener hfT;
    private final CustomMessageListener hrY;
    private final CustomMessageListener hrZ;

    public d(FrsFragment frsFragment) {
        super(frsFragment);
        this.hrY = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.frs.mc.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && !((PostWriteCallBackData) customResponsedMessage.getData()).isDyamicCallback()) {
                    d.this.e((PostWriteCallBackData) customResponsedMessage.getData());
                }
            }
        };
        this.hfT = new CustomMessageListener(CmdConfigCustom.PB_DELETE_THREAD) { // from class: com.baidu.tieba.frs.mc.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!StringUtils.isNull(str) && d.this.hro.bOW() != null) {
                        FrsViewData bOW = d.this.hro.bOW();
                        bOW.removeThread(str);
                        d.this.gYw.a(bOW.getThreadList(), bOW);
                        if (com.baidu.tieba.tbadkCore.e.cVp() != null) {
                            com.baidu.tieba.tbadkCore.e.cVp().aG(d.this.hro.getForumName(), false);
                        }
                    }
                }
            }
        };
        this.hrZ = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_MANAGE) { // from class: com.baidu.tieba.frs.mc.d.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v19, types: [java.util.List] */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ForumManageModel.e eVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ForumManageModel.e) && d.this.hro != null && d.this.gYw != null && d.this.gYN != null && (eVar = (ForumManageModel.e) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(eVar.threadId) && d.this.hro.bOW() != null) {
                    String str = eVar.threadId;
                    String str2 = eVar.forumId;
                    String str3 = eVar.forumName;
                    if (eVar.kVh == 4) {
                        FrsViewData bOW = d.this.hro.bOW();
                        bj threadDataById = bOW.getThreadDataById(str);
                        bOW.removeThreadData(threadDataById);
                        List<com.baidu.adp.widget.ListView.m> topThreadList = bOW.getTopThreadList();
                        if (topThreadList == null) {
                            topThreadList = new ArrayList<>();
                        }
                        topThreadList.add(0, threadDataById);
                        d.this.gYw.a(bOW.getThreadList(), bOW);
                        d.this.gYN.i(bOW);
                    }
                    if (TextUtils.equals(d.this.hro.getForumName(), str3)) {
                        com.baidu.tieba.tbadkCore.e.cVp().aG(d.this.hro.getForumName(), false);
                    }
                }
            }
        };
        this.gvH = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.frs.mc.d.4
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String errorString;
                String errorString2;
                if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                    GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
                    if (StringUtils.isNull(getMyPostHttpResponseMessage.getErrorString())) {
                        errorString2 = d.this.hro.getResources().getString(R.string.neterror);
                    } else {
                        errorString2 = getMyPostHttpResponseMessage.getErrorString();
                    }
                    d.this.a(getMyPostHttpResponseMessage.getError(), errorString2, getMyPostHttpResponseMessage.getResponseData(), responsedMessage.getOrginalMessage().getExtra() instanceof RequestGetMyPostNetMessage ? ((RequestGetMyPostNetMessage) responsedMessage.getOrginalMessage().getExtra()).getProZone() : 0);
                } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                    GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                    if (StringUtils.isNull(getMyPostSocketResponseMessage.getErrorString())) {
                        errorString = d.this.hro.getResources().getString(R.string.neterror);
                    } else {
                        errorString = getMyPostSocketResponseMessage.getErrorString();
                    }
                    d.this.a(getMyPostSocketResponseMessage.getError(), errorString, getMyPostSocketResponseMessage.getResponseData(), responsedMessage.getOrginalMessage().getExtra() instanceof RequestGetMyPostNetMessage ? ((RequestGetMyPostNetMessage) responsedMessage.getOrginalMessage().getExtra()).getProZone() : 0);
                }
            }
        };
        this.gvH.getSocketMessageListener().setSelfListener(true);
        this.gvH.getHttpMessageListener().setSelfListener(true);
        this.hfT.setSelfListener(false);
        this.hro.registerListener(this.hfT);
        this.hro.registerListener(this.gvH);
        this.hro.registerListener(this.hrY);
        this.hro.registerListener(this.hrZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, GetMyPostResIdl getMyPostResIdl, int i2) {
        if (i != 0) {
            this.hro.showToast(str);
            return;
        }
        FrsViewData bOW = this.hro.bOW();
        if (bOW != null && bOW.getForum() != null && getMyPostResIdl != null && this.gYw != null && this.gYM != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
            am amVar = new am();
            ThreadInfo.Builder builder = new ThreadInfo.Builder(getMyPostResIdl.data.thread_info);
            User.Builder builder2 = new User.Builder(builder.author);
            a(builder2, getMyPostResIdl.data.user_info);
            builder.author = builder2.build(true);
            builder.cheak_repeat = 1;
            builder.fname = bOW.getForum().getName();
            builder.fid = Long.valueOf(com.baidu.adp.lib.f.b.toLong(bOW.getForum().getId(), 0L));
            amVar.a(builder.build(true));
            if (i2 == 1) {
                FrsTabViewController.b bVP = this.hro.bOt().bVP();
                if (bVP != null && (bVP.fragment instanceof FrsCommonTabFragment)) {
                    ((FrsCommonTabFragment) bVP.fragment).ao(amVar);
                }
            } else if (amVar.getTabId() > 0) {
                FrsTabViewController.b uU = this.hro.bOt().uU(amVar.getTabId());
                if (uU != null && (uU.fragment instanceof FrsCommonTabFragment)) {
                    this.hsB.uV(amVar.getTabId());
                    ((FrsCommonTabFragment) uU.fragment).ao(amVar);
                }
            } else {
                int bVL = this.hro.bOt().bVL();
                FrsTabViewController.b uU2 = this.hro.bOt().uU(bVL);
                if (uU2 != null) {
                    this.hsB.uV(bVL);
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
        FrsViewData bOW = this.hro.bOW();
        if (bOW != null) {
            this.gYM.addMyNewThread(amVar);
            if (this.gYM.bUc()) {
                ArrayList<com.baidu.adp.widget.ListView.m> arrayList = new ArrayList<>();
                arrayList.add(amVar);
                a = this.hsD.a(false, true, arrayList, null, true);
            } else {
                a = this.hsD.a(false, true, bOW.getThreadList(), null, true);
            }
            if (a != null) {
                bOW.setThreadList(a);
                bOW.checkLiveStageInThreadList();
                this.gYw.a(a, bOW);
                this.gYw.tq(0);
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
        if (this.gYM != null) {
            boolean z = this.gYM.bTu() != null && this.gYM.bTu().getIsBrandForum();
            int bTY = this.gYM.bTY();
            if (bTY == 2 || bTY == 3 || bTY == 7 || bTY == 8 || z) {
                if ((ab.bQo().ty(1) != null ? this.gYM.bTR() : 0) == 0 && postWriteCallBackData != null) {
                    final long j = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getPostId(), 0L);
                    final long j2 = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getThreadId(), 0L);
                    final long j3 = com.baidu.adp.lib.f.b.toLong(this.hro.getForumId(), 0L);
                    if (j != 0 && j2 != 0 && j3 != 0) {
                        com.baidu.adp.lib.f.e.lb().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.mc.d.5
                            @Override // java.lang.Runnable
                            public void run() {
                                int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
                                int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
                                float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                                int i = 1;
                                if (ar.aOS().aOT()) {
                                    i = 2;
                                }
                                RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                                requestGetMyPostNetMessage.setProZone(postWriteCallBackData.getProZone());
                                requestGetMyPostNetMessage.setParams(j2, j, j3, equipmentWidth, equipmentHeight, f, i);
                                d.this.hro.sendMessage(requestGetMyPostNetMessage);
                            }
                        }, 1000L);
                    }
                }
            }
        }
    }
}
