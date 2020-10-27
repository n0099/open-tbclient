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
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.ag;
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
/* loaded from: classes22.dex */
public class d extends j {
    private final com.baidu.adp.framework.listener.a hYA;
    private final CustomMessageListener iKr;
    private final CustomMessageListener iXF;
    private final CustomMessageListener iXG;

    public d(FrsFragment frsFragment) {
        super(frsFragment);
        this.iXF = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.frs.mc.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && !((PostWriteCallBackData) customResponsedMessage.getData()).isDyamicCallback()) {
                    d.this.f((PostWriteCallBackData) customResponsedMessage.getData());
                }
            }
        };
        this.iKr = new CustomMessageListener(CmdConfigCustom.PB_DELETE_THREAD) { // from class: com.baidu.tieba.frs.mc.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!StringUtils.isNull(str) && d.this.iWX.cwo() != null) {
                        FrsViewData cwo = d.this.iWX.cwo();
                        cwo.removeThread(str);
                        d.this.iBs.a(cwo.getThreadList(), cwo);
                        if (com.baidu.tieba.tbadkCore.e.dGw() != null) {
                            com.baidu.tieba.tbadkCore.e.dGw().bc(d.this.iWX.getForumName(), false);
                        }
                    }
                }
            }
        };
        this.iXG = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_MANAGE) { // from class: com.baidu.tieba.frs.mc.d.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v19, types: [java.util.List] */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ForumManageModel.e eVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ForumManageModel.e) && d.this.iWX != null && d.this.iBs != null && d.this.iBM != null && (eVar = (ForumManageModel.e) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(eVar.threadId) && d.this.iWX.cwo() != null) {
                    String str = eVar.threadId;
                    String str2 = eVar.forumId;
                    String str3 = eVar.forumName;
                    if (eVar.mTH == 4) {
                        FrsViewData cwo = d.this.iWX.cwo();
                        bw threadDataById = cwo.getThreadDataById(str);
                        cwo.removeThreadData(threadDataById);
                        List<q> topThreadList = cwo.getTopThreadList();
                        if (topThreadList == null) {
                            topThreadList = new ArrayList<>();
                        }
                        topThreadList.add(0, threadDataById);
                        d.this.iBs.a(cwo.getThreadList(), cwo);
                        d.this.iBM.i(cwo);
                    }
                    if (TextUtils.equals(d.this.iWX.getForumName(), str3)) {
                        com.baidu.tieba.tbadkCore.e.dGw().bc(d.this.iWX.getForumName(), false);
                    }
                }
            }
        };
        this.hYA = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.frs.mc.d.4
            /* JADX WARN: Removed duplicated region for block: B:11:0x0021  */
            /* JADX WARN: Removed duplicated region for block: B:23:0x0074  */
            @Override // com.baidu.adp.framework.listener.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z;
                String errorString;
                String errorString2;
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                    Object extra = responsedMessage.getOrginalMessage().getExtra();
                    if (extra instanceof RequestGetMyPostNetMessage) {
                        z = ((RequestGetMyPostNetMessage) extra).showErrorToast();
                        if (!(responsedMessage instanceof GetMyPostHttpResponseMessage)) {
                            GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
                            if (StringUtils.isNull(getMyPostHttpResponseMessage.getErrorString())) {
                                errorString2 = d.this.iWX.getResources().getString(R.string.neterror);
                            } else {
                                errorString2 = getMyPostHttpResponseMessage.getErrorString();
                            }
                            int proZone = responsedMessage.getOrginalMessage().getExtra() instanceof RequestGetMyPostNetMessage ? ((RequestGetMyPostNetMessage) responsedMessage.getOrginalMessage().getExtra()).getProZone() : 0;
                            if (z || getMyPostHttpResponseMessage.getError() == 0) {
                                d.this.a(getMyPostHttpResponseMessage.getError(), errorString2, getMyPostHttpResponseMessage.getResponseData(), proZone);
                                return;
                            }
                            return;
                        } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                            GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                            if (StringUtils.isNull(getMyPostSocketResponseMessage.getErrorString())) {
                                errorString = d.this.iWX.getResources().getString(R.string.neterror);
                            } else {
                                errorString = getMyPostSocketResponseMessage.getErrorString();
                            }
                            int proZone2 = responsedMessage.getOrginalMessage().getExtra() instanceof RequestGetMyPostNetMessage ? ((RequestGetMyPostNetMessage) responsedMessage.getOrginalMessage().getExtra()).getProZone() : 0;
                            if (z || getMyPostSocketResponseMessage.getError() == 0) {
                                d.this.a(getMyPostSocketResponseMessage.getError(), errorString, getMyPostSocketResponseMessage.getResponseData(), proZone2);
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                }
                z = true;
                if (!(responsedMessage instanceof GetMyPostHttpResponseMessage)) {
                }
            }
        };
        this.hYA.getSocketMessageListener().setSelfListener(true);
        this.hYA.getHttpMessageListener().setSelfListener(true);
        this.iKr.setSelfListener(false);
        this.iWX.registerListener(this.iKr);
        this.iWX.registerListener(this.hYA);
        this.iWX.registerListener(this.iXF);
        this.iWX.registerListener(this.iXG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, GetMyPostResIdl getMyPostResIdl, int i2) {
        if (i != 0) {
            this.iWX.showToast(str);
            return;
        }
        FrsViewData cwo = this.iWX.cwo();
        if (cwo != null && cwo.getForum() != null && getMyPostResIdl != null && this.iBs != null && this.iBL != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
            as asVar = new as();
            ThreadInfo.Builder builder = new ThreadInfo.Builder(getMyPostResIdl.data.thread_info);
            User.Builder builder2 = new User.Builder(builder.author);
            a(builder2, getMyPostResIdl.data.user_info);
            if (builder.author == null || TextUtils.isEmpty(builder.author.name)) {
                builder.author = builder2.build(true);
            }
            if (builder.author != null && getMyPostResIdl.data.user_info != null && builder.author.name.equals(getMyPostResIdl.data.user_info.name)) {
                builder.author = builder2.build(true);
            }
            builder.cheak_repeat = 1;
            builder.fname = cwo.getForum().getName();
            builder.fid = Long.valueOf(com.baidu.adp.lib.f.b.toLong(cwo.getForum().getId(), 0L));
            asVar.a(builder.build(true));
            if (i2 == 1) {
                FrsTabViewController.b cDR = this.iWX.cvI().cDR();
                if (cDR != null && (cDR.fragment instanceof FrsCommonTabFragment)) {
                    ((FrsCommonTabFragment) cDR.fragment).an(asVar);
                }
            } else if (i2 == 2) {
                FrsTabViewController.b Ar = this.iWX.cvI().Ar(301);
                if (Ar != null && (Ar.fragment instanceof FrsGoodFragment)) {
                    this.iYh.sW(301);
                    ((FrsGoodFragment) Ar.fragment).a(asVar);
                }
            } else if (asVar.getTabId() > 0) {
                FrsTabViewController.b Ar2 = this.iWX.cvI().Ar(asVar.getTabId());
                if (Ar2 != null && (Ar2.fragment instanceof FrsCommonTabFragment)) {
                    this.iYh.sW(asVar.getTabId());
                    ((FrsCommonTabFragment) Ar2.fragment).an(asVar);
                }
            } else {
                if (!y.isEmpty(asVar.bme())) {
                    asVar.bjC();
                    int cDN = this.iWX.cvI().cDN();
                    FrsTabViewController.b Ar3 = this.iWX.cvI().Ar(cDN);
                    if (Ar3 != null && (Ar3.fragment instanceof FrsCommonTabFragment)) {
                        this.iYh.sW(cDN);
                        ((FrsCommonTabFragment) Ar3.fragment).an(asVar);
                        return;
                    }
                }
                int cDM = this.iWX.cvI().cDM();
                FrsTabViewController.b Ar4 = this.iWX.cvI().Ar(cDM);
                if (Ar4 != null) {
                    this.iYh.sW(cDM);
                    if (Ar4.fragment instanceof FrsNewAreaFragment) {
                        a(asVar, (FrsNewAreaFragment) Ar4.fragment);
                    } else {
                        b(asVar);
                    }
                }
            }
        }
    }

    private void b(as asVar) {
        ArrayList<q> a2;
        FrsViewData cwo = this.iWX.cwo();
        if (cwo != null) {
            this.iBL.addMyNewThread(asVar);
            if (this.iBL.cBV()) {
                ArrayList<q> arrayList = new ArrayList<>();
                arrayList.add(asVar);
                a2 = this.iYj.a(false, true, arrayList, null, true);
            } else {
                a2 = this.iYj.a(false, true, cwo.getThreadList(), null, true);
            }
            if (a2 != null) {
                cwo.setThreadList(a2);
                cwo.checkLiveStageInThreadList();
                this.iBs.a(a2, cwo);
                this.iBs.yH(0);
            }
        }
    }

    private void a(bw bwVar, FrsNewAreaFragment frsNewAreaFragment) {
        frsNewAreaFragment.an(bwVar);
    }

    private void a(User.Builder builder, User_Info user_Info) {
        if (user_Info != null) {
            builder.id = user_Info.id;
            builder.gender = user_Info.gender;
            builder.type = user_Info.type;
            builder.name = user_Info.name;
            builder.name_show = user_Info.name_show;
            if (user_Info.id.longValue() == TbadkCoreApplication.getCurrentAccountId()) {
                builder.portrait = TbadkCoreApplication.getCurrentPortrait();
            } else {
                builder.portrait = user_Info.portrait;
            }
            builder.god_data = user_Info.god_data;
            builder.fans_num = user_Info.fans_num;
            builder.fans_nickname = user_Info.fans_nickname;
            builder.is_bawu = user_Info.is_bawu;
            builder.bawu_type = user_Info.bawu_type;
            builder.new_god_data = user_Info.new_god_data;
        }
    }

    public void f(final PostWriteCallBackData postWriteCallBackData) {
        if (this.iBL != null) {
            boolean z = this.iBL.cBm() != null && this.iBL.cBm().getIsBrandForum();
            int cBQ = this.iBL.cBQ();
            if (cBQ == 2 || cBQ == 3 || cBQ == 7 || cBQ == 8 || z) {
                if ((ag.cxN().yR(1) != null ? this.iBL.cBJ() : 0) == 0 && postWriteCallBackData != null) {
                    final long j = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getPostId(), 0L);
                    final long j2 = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getThreadId(), 0L);
                    final long j3 = com.baidu.adp.lib.f.b.toLong(this.iWX.getForumId(), 0L);
                    if (j != 0 && j2 != 0 && j3 != 0) {
                        com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.mc.d.5
                            @Override // java.lang.Runnable
                            public void run() {
                                int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
                                int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
                                float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                                int i = 1;
                                if (au.boO().boP()) {
                                    i = 2;
                                }
                                RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                                requestGetMyPostNetMessage.setProZone(postWriteCallBackData.getProZone());
                                requestGetMyPostNetMessage.setParams(j2, j, j3, equipmentWidth, equipmentHeight, f, i);
                                d.this.iWX.sendMessage(requestGetMyPostNetMessage);
                            }
                        }, 1000L);
                    }
                }
            }
        }
    }
}
