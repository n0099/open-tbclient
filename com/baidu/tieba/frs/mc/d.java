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
/* loaded from: classes21.dex */
public class d extends j {
    private final com.baidu.adp.framework.listener.a hxi;
    private final CustomMessageListener iiY;
    private final CustomMessageListener iwq;
    private final CustomMessageListener iwr;

    public d(FrsFragment frsFragment) {
        super(frsFragment);
        this.iwq = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.frs.mc.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && !((PostWriteCallBackData) customResponsedMessage.getData()).isDyamicCallback()) {
                    d.this.f((PostWriteCallBackData) customResponsedMessage.getData());
                }
            }
        };
        this.iiY = new CustomMessageListener(CmdConfigCustom.PB_DELETE_THREAD) { // from class: com.baidu.tieba.frs.mc.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!StringUtils.isNull(str) && d.this.ivI.cpJ() != null) {
                        FrsViewData cpJ = d.this.ivI.cpJ();
                        cpJ.removeThread(str);
                        d.this.hZV.a(cpJ.getThreadList(), cpJ);
                        if (com.baidu.tieba.tbadkCore.e.dzD() != null) {
                            com.baidu.tieba.tbadkCore.e.dzD().aW(d.this.ivI.getForumName(), false);
                        }
                    }
                }
            }
        };
        this.iwr = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_MANAGE) { // from class: com.baidu.tieba.frs.mc.d.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v19, types: [java.util.List] */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ForumManageModel.e eVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ForumManageModel.e) && d.this.ivI != null && d.this.hZV != null && d.this.iap != null && (eVar = (ForumManageModel.e) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(eVar.threadId) && d.this.ivI.cpJ() != null) {
                    String str = eVar.threadId;
                    String str2 = eVar.forumId;
                    String str3 = eVar.forumName;
                    if (eVar.mrp == 4) {
                        FrsViewData cpJ = d.this.ivI.cpJ();
                        bw threadDataById = cpJ.getThreadDataById(str);
                        cpJ.removeThreadData(threadDataById);
                        List<q> topThreadList = cpJ.getTopThreadList();
                        if (topThreadList == null) {
                            topThreadList = new ArrayList<>();
                        }
                        topThreadList.add(0, threadDataById);
                        d.this.hZV.a(cpJ.getThreadList(), cpJ);
                        d.this.iap.i(cpJ);
                    }
                    if (TextUtils.equals(d.this.ivI.getForumName(), str3)) {
                        com.baidu.tieba.tbadkCore.e.dzD().aW(d.this.ivI.getForumName(), false);
                    }
                }
            }
        };
        this.hxi = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.frs.mc.d.4
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
                                errorString2 = d.this.ivI.getResources().getString(R.string.neterror);
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
                                errorString = d.this.ivI.getResources().getString(R.string.neterror);
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
        this.hxi.getSocketMessageListener().setSelfListener(true);
        this.hxi.getHttpMessageListener().setSelfListener(true);
        this.iiY.setSelfListener(false);
        this.ivI.registerListener(this.iiY);
        this.ivI.registerListener(this.hxi);
        this.ivI.registerListener(this.iwq);
        this.ivI.registerListener(this.iwr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, GetMyPostResIdl getMyPostResIdl, int i2) {
        if (i != 0) {
            this.ivI.showToast(str);
            return;
        }
        FrsViewData cpJ = this.ivI.cpJ();
        if (cpJ != null && cpJ.getForum() != null && getMyPostResIdl != null && this.hZV != null && this.iao != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
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
            builder.fname = cpJ.getForum().getName();
            builder.fid = Long.valueOf(com.baidu.adp.lib.f.b.toLong(cpJ.getForum().getId(), 0L));
            asVar.a(builder.build(true));
            if (i2 == 1) {
                FrsTabViewController.b cxn = this.ivI.cpd().cxn();
                if (cxn != null && (cxn.fragment instanceof FrsCommonTabFragment)) {
                    ((FrsCommonTabFragment) cxn.fragment).an(asVar);
                }
            } else if (i2 == 2) {
                FrsTabViewController.b zs = this.ivI.cpd().zs(301);
                if (zs != null && (zs.fragment instanceof FrsGoodFragment)) {
                    this.iwS.sn(301);
                    ((FrsGoodFragment) zs.fragment).a(asVar);
                }
            } else if (asVar.getTabId() > 0) {
                FrsTabViewController.b zs2 = this.ivI.cpd().zs(asVar.getTabId());
                if (zs2 != null && (zs2.fragment instanceof FrsCommonTabFragment)) {
                    this.iwS.sn(asVar.getTabId());
                    ((FrsCommonTabFragment) zs2.fragment).an(asVar);
                }
            } else {
                if (!y.isEmpty(asVar.bhC())) {
                    asVar.bfa();
                    int cxj = this.ivI.cpd().cxj();
                    FrsTabViewController.b zs3 = this.ivI.cpd().zs(cxj);
                    if (zs3 != null && (zs3.fragment instanceof FrsCommonTabFragment)) {
                        this.iwS.sn(cxj);
                        ((FrsCommonTabFragment) zs3.fragment).an(asVar);
                        return;
                    }
                }
                int cxi = this.ivI.cpd().cxi();
                FrsTabViewController.b zs4 = this.ivI.cpd().zs(cxi);
                if (zs4 != null) {
                    this.iwS.sn(cxi);
                    if (zs4.fragment instanceof FrsNewAreaFragment) {
                        a(asVar, (FrsNewAreaFragment) zs4.fragment);
                    } else {
                        b(asVar);
                    }
                }
            }
        }
    }

    private void b(as asVar) {
        ArrayList<q> a;
        FrsViewData cpJ = this.ivI.cpJ();
        if (cpJ != null) {
            this.iao.addMyNewThread(asVar);
            if (this.iao.cvr()) {
                ArrayList<q> arrayList = new ArrayList<>();
                arrayList.add(asVar);
                a = this.iwU.a(false, true, arrayList, null, true);
            } else {
                a = this.iwU.a(false, true, cpJ.getThreadList(), null, true);
            }
            if (a != null) {
                cpJ.setThreadList(a);
                cpJ.checkLiveStageInThreadList();
                this.hZV.a(a, cpJ);
                this.hZV.xI(0);
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
        if (this.iao != null) {
            boolean z = this.iao.cuI() != null && this.iao.cuI().getIsBrandForum();
            int cvm = this.iao.cvm();
            if (cvm == 2 || cvm == 3 || cvm == 7 || cvm == 8 || z) {
                if ((ag.cri().xS(1) != null ? this.iao.cvf() : 0) == 0 && postWriteCallBackData != null) {
                    final long j = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getPostId(), 0L);
                    final long j2 = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getThreadId(), 0L);
                    final long j3 = com.baidu.adp.lib.f.b.toLong(this.ivI.getForumId(), 0L);
                    if (j != 0 && j2 != 0 && j3 != 0) {
                        com.baidu.adp.lib.f.e.mX().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.mc.d.5
                            @Override // java.lang.Runnable
                            public void run() {
                                int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
                                int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
                                float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                                int i = 1;
                                if (au.bkm().bkn()) {
                                    i = 2;
                                }
                                RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                                requestGetMyPostNetMessage.setProZone(postWriteCallBackData.getProZone());
                                requestGetMyPostNetMessage.setParams(j2, j, j3, equipmentWidth, equipmentHeight, f, i);
                                d.this.ivI.sendMessage(requestGetMyPostNetMessage);
                            }
                        }, 1000L);
                    }
                }
            }
        }
    }
}
