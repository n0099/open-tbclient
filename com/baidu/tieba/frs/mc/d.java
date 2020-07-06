package com.baidu.tieba.frs.mc;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.ae;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.good.FrsGoodFragment;
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
    private final com.baidu.adp.framework.listener.a gXA;
    private final CustomMessageListener hHI;
    private final CustomMessageListener hUL;
    private final CustomMessageListener hUM;

    public d(FrsFragment frsFragment) {
        super(frsFragment);
        this.hUL = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.frs.mc.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && !((PostWriteCallBackData) customResponsedMessage.getData()).isDyamicCallback()) {
                    d.this.e((PostWriteCallBackData) customResponsedMessage.getData());
                }
            }
        };
        this.hHI = new CustomMessageListener(CmdConfigCustom.PB_DELETE_THREAD) { // from class: com.baidu.tieba.frs.mc.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!StringUtils.isNull(str) && d.this.hUd.bYC() != null) {
                        FrsViewData bYC = d.this.hUd.bYC();
                        bYC.removeThread(str);
                        d.this.hzK.a(bYC.getThreadList(), bYC);
                        if (com.baidu.tieba.tbadkCore.e.dgZ() != null) {
                            com.baidu.tieba.tbadkCore.e.dgZ().aV(d.this.hUd.getForumName(), false);
                        }
                    }
                }
            }
        };
        this.hUM = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_MANAGE) { // from class: com.baidu.tieba.frs.mc.d.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v19, types: [java.util.List] */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ForumManageModel.e eVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ForumManageModel.e) && d.this.hUd != null && d.this.hzK != null && d.this.hAd != null && (eVar = (ForumManageModel.e) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(eVar.threadId) && d.this.hUd.bYC() != null) {
                    String str = eVar.threadId;
                    String str2 = eVar.forumId;
                    String str3 = eVar.forumName;
                    if (eVar.lIB == 4) {
                        FrsViewData bYC = d.this.hUd.bYC();
                        bu threadDataById = bYC.getThreadDataById(str);
                        bYC.removeThreadData(threadDataById);
                        List<q> topThreadList = bYC.getTopThreadList();
                        if (topThreadList == null) {
                            topThreadList = new ArrayList<>();
                        }
                        topThreadList.add(0, threadDataById);
                        d.this.hzK.a(bYC.getThreadList(), bYC);
                        d.this.hAd.i(bYC);
                    }
                    if (TextUtils.equals(d.this.hUd.getForumName(), str3)) {
                        com.baidu.tieba.tbadkCore.e.dgZ().aV(d.this.hUd.getForumName(), false);
                    }
                }
            }
        };
        this.gXA = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.frs.mc.d.4
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String errorString;
                String errorString2;
                if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                    GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
                    if (StringUtils.isNull(getMyPostHttpResponseMessage.getErrorString())) {
                        errorString2 = d.this.hUd.getResources().getString(R.string.neterror);
                    } else {
                        errorString2 = getMyPostHttpResponseMessage.getErrorString();
                    }
                    d.this.a(getMyPostHttpResponseMessage.getError(), errorString2, getMyPostHttpResponseMessage.getResponseData(), responsedMessage.getOrginalMessage().getExtra() instanceof RequestGetMyPostNetMessage ? ((RequestGetMyPostNetMessage) responsedMessage.getOrginalMessage().getExtra()).getProZone() : 0);
                } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                    GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                    if (StringUtils.isNull(getMyPostSocketResponseMessage.getErrorString())) {
                        errorString = d.this.hUd.getResources().getString(R.string.neterror);
                    } else {
                        errorString = getMyPostSocketResponseMessage.getErrorString();
                    }
                    d.this.a(getMyPostSocketResponseMessage.getError(), errorString, getMyPostSocketResponseMessage.getResponseData(), responsedMessage.getOrginalMessage().getExtra() instanceof RequestGetMyPostNetMessage ? ((RequestGetMyPostNetMessage) responsedMessage.getOrginalMessage().getExtra()).getProZone() : 0);
                }
            }
        };
        this.gXA.getSocketMessageListener().setSelfListener(true);
        this.gXA.getHttpMessageListener().setSelfListener(true);
        this.hHI.setSelfListener(false);
        this.hUd.registerListener(this.hHI);
        this.hUd.registerListener(this.gXA);
        this.hUd.registerListener(this.hUL);
        this.hUd.registerListener(this.hUM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, GetMyPostResIdl getMyPostResIdl, int i2) {
        if (i != 0) {
            this.hUd.showToast(str);
            return;
        }
        FrsViewData bYC = this.hUd.bYC();
        if (bYC != null && bYC.getForum() != null && getMyPostResIdl != null && this.hzK != null && this.hAc != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
            aq aqVar = new aq();
            ThreadInfo.Builder builder = new ThreadInfo.Builder(getMyPostResIdl.data.thread_info);
            User.Builder builder2 = new User.Builder(builder.author);
            a(builder2, getMyPostResIdl.data.user_info);
            builder.author = builder2.build(true);
            builder.cheak_repeat = 1;
            builder.fname = bYC.getForum().getName();
            builder.fid = Long.valueOf(com.baidu.adp.lib.f.b.toLong(bYC.getForum().getId(), 0L));
            aqVar.a(builder.build(true));
            if (i2 == 1) {
                FrsTabViewController.b cfQ = this.hUd.bXY().cfQ();
                if (cfQ != null && (cfQ.fragment instanceof FrsCommonTabFragment)) {
                    ((FrsCommonTabFragment) cfQ.fragment).ap(aqVar);
                }
            } else if (i2 == 2) {
                FrsTabViewController.b wh = this.hUd.bXY().wh(301);
                if (wh != null && (wh.fragment instanceof FrsGoodFragment)) {
                    this.hVo.wi(301);
                    ((FrsGoodFragment) wh.fragment).a(aqVar);
                }
            } else if (aqVar.getTabId() > 0) {
                FrsTabViewController.b wh2 = this.hUd.bXY().wh(aqVar.getTabId());
                if (wh2 != null && (wh2.fragment instanceof FrsCommonTabFragment)) {
                    this.hVo.wi(aqVar.getTabId());
                    ((FrsCommonTabFragment) wh2.fragment).ap(aqVar);
                }
            } else {
                if (!w.isEmpty(aqVar.aUv())) {
                    aqVar.aRR();
                    int cfM = this.hUd.bXY().cfM();
                    FrsTabViewController.b wh3 = this.hUd.bXY().wh(cfM);
                    if (wh3 != null && (wh3.fragment instanceof FrsCommonTabFragment)) {
                        this.hVo.wi(cfM);
                        ((FrsCommonTabFragment) wh3.fragment).ap(aqVar);
                        return;
                    }
                }
                int cfL = this.hUd.bXY().cfL();
                FrsTabViewController.b wh4 = this.hUd.bXY().wh(cfL);
                if (wh4 != null) {
                    this.hVo.wi(cfL);
                    if (wh4.fragment instanceof FrsNewAreaFragment) {
                        a(aqVar, (FrsNewAreaFragment) wh4.fragment);
                    } else {
                        b(aqVar);
                    }
                }
            }
        }
    }

    private void b(aq aqVar) {
        ArrayList<q> a;
        FrsViewData bYC = this.hUd.bYC();
        if (bYC != null) {
            this.hAc.addMyNewThread(aqVar);
            if (this.hAc.cdX()) {
                ArrayList<q> arrayList = new ArrayList<>();
                arrayList.add(aqVar);
                a = this.hVq.a(false, true, arrayList, null, true);
            } else {
                a = this.hVq.a(false, true, bYC.getThreadList(), null, true);
            }
            if (a != null) {
                bYC.setThreadList(a);
                bYC.checkLiveStageInThreadList();
                this.hzK.a(a, bYC);
                this.hzK.uC(0);
            }
        }
    }

    private void a(bu buVar, FrsNewAreaFragment frsNewAreaFragment) {
        frsNewAreaFragment.ap(buVar);
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
            builder.new_god_data = user_Info.new_god_data;
        }
    }

    public void e(final PostWriteCallBackData postWriteCallBackData) {
        if (this.hAc != null) {
            boolean z = this.hAc.cdo() != null && this.hAc.cdo().getIsBrandForum();
            int cdS = this.hAc.cdS();
            if (cdS == 2 || cdS == 3 || cdS == 7 || cdS == 8 || z) {
                if ((ae.bZY().uK(1) != null ? this.hAc.cdL() : 0) == 0 && postWriteCallBackData != null) {
                    final long j = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getPostId(), 0L);
                    final long j2 = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getThreadId(), 0L);
                    final long j3 = com.baidu.adp.lib.f.b.toLong(this.hUd.getForumId(), 0L);
                    if (j != 0 && j2 != 0 && j3 != 0) {
                        com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.mc.d.5
                            @Override // java.lang.Runnable
                            public void run() {
                                int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
                                int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
                                float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                                int i = 1;
                                if (as.aWR().aWS()) {
                                    i = 2;
                                }
                                RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                                requestGetMyPostNetMessage.setProZone(postWriteCallBackData.getProZone());
                                requestGetMyPostNetMessage.setParams(j2, j, j3, equipmentWidth, equipmentHeight, f, i);
                                d.this.hUd.sendMessage(requestGetMyPostNetMessage);
                            }
                        }, 1000L);
                    }
                }
            }
        }
    }
}
