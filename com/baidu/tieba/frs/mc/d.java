package com.baidu.tieba.frs.mc;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.aw;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.ac;
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
/* loaded from: classes2.dex */
public class d extends j {
    private final com.baidu.adp.framework.listener.a iFG;
    private final CustomMessageListener jHl;
    private final CustomMessageListener jri;

    public d(FrsFragment frsFragment) {
        super(frsFragment);
        this.jri = new CustomMessageListener(CmdConfigCustom.PB_DELETE_THREAD) { // from class: com.baidu.tieba.frs.mc.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!StringUtils.isNull(str) && d.this.jGE.cDm() != null) {
                        FrsViewData cDm = d.this.jGE.cDm();
                        cDm.removeThread(str);
                        d.this.jif.a(cDm.getThreadList(), cDm);
                        if (com.baidu.tieba.tbadkCore.e.dMI() != null) {
                            com.baidu.tieba.tbadkCore.e.dMI().bd(d.this.jGE.getForumName(), false);
                        }
                    }
                }
            }
        };
        this.jHl = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_MANAGE) { // from class: com.baidu.tieba.frs.mc.d.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v19, types: [java.util.List] */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ForumManageModel.e eVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ForumManageModel.e) && d.this.jGE != null && d.this.jif != null && d.this.jiy != null && (eVar = (ForumManageModel.e) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(eVar.threadId) && d.this.jGE.cDm() != null) {
                    String str = eVar.threadId;
                    String str2 = eVar.forumId;
                    String str3 = eVar.forumName;
                    if (eVar.nCd == 4) {
                        FrsViewData cDm = d.this.jGE.cDm();
                        cb threadDataById = cDm.getThreadDataById(str);
                        cDm.removeThreadData(threadDataById);
                        List<com.baidu.adp.widget.ListView.n> topThreadList = cDm.getTopThreadList();
                        if (topThreadList == null) {
                            topThreadList = new ArrayList<>();
                        }
                        topThreadList.add(0, threadDataById);
                        d.this.jif.a(cDm.getThreadList(), cDm);
                        d.this.jiy.j(cDm);
                    }
                    if (TextUtils.equals(d.this.jGE.getForumName(), str3)) {
                        com.baidu.tieba.tbadkCore.e.dMI().bd(d.this.jGE.getForumName(), false);
                    }
                }
            }
        };
        this.iFG = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.frs.mc.d.3
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
                                errorString2 = d.this.jGE.getResources().getString(R.string.neterror);
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
                                errorString = d.this.jGE.getResources().getString(R.string.neterror);
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
        this.iFG.getSocketMessageListener().setSelfListener(true);
        this.iFG.getHttpMessageListener().setSelfListener(true);
        this.jri.setSelfListener(false);
        this.jGE.registerListener(this.jri);
        this.jGE.registerListener(this.iFG);
        this.jGE.registerListener(this.jHl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, GetMyPostResIdl getMyPostResIdl, int i2) {
        if (i != 0) {
            this.jGE.showToast(str);
            return;
        }
        FrsViewData cDm = this.jGE.cDm();
        if (cDm != null && cDm.getForum() != null && getMyPostResIdl != null && this.jif != null && this.jix != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
            aw awVar = new aw();
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
            builder.fname = cDm.getForum().getName();
            builder.fid = Long.valueOf(com.baidu.adp.lib.f.b.toLong(cDm.getForum().getId(), 0L));
            awVar.a(builder.build(true));
            a(awVar, i2);
        }
    }

    private void a(aw awVar, int i) {
        if (i == 1) {
            FrsTabViewController.b cMa = this.jGE.cCF().cMa();
            if (cMa != null && (cMa.fragment instanceof FrsCommonTabFragment)) {
                ((FrsCommonTabFragment) cMa.fragment).aq(awVar);
            }
        } else if (i == 2) {
            FrsTabViewController.b AH = this.jGE.cCF().AH(301);
            if (AH != null && (AH.fragment instanceof FrsGoodFragment)) {
                this.jHM.sV(301);
                ((FrsGoodFragment) AH.fragment).a(awVar);
            }
        } else if (awVar.getTabId() > 0) {
            FrsTabViewController.b AH2 = this.jGE.cCF().AH(awVar.getTabId());
            if (AH2 != null && (AH2.fragment instanceof FrsCommonTabFragment)) {
                ((FrsCommonTabFragment) AH2.fragment).aq(awVar);
            }
        } else {
            if (!y.isEmpty(awVar.bpZ())) {
                awVar.bnu();
            }
            FrsTabViewController.b AH3 = this.jGE.cCF().AH(this.jGE.cCF().cLW());
            if (AH3 != null) {
                if (AH3.fragment instanceof FrsNewAreaFragment) {
                    a(awVar, (FrsNewAreaFragment) AH3.fragment);
                } else {
                    b(awVar);
                }
            }
        }
    }

    private void b(aw awVar) {
        ArrayList<com.baidu.adp.widget.ListView.n> threadList;
        FrsViewData cDm = this.jGE.cDm();
        if (cDm != null) {
            this.jix.addMyNewThread(awVar);
            if (this.jix.cJX()) {
                ArrayList<com.baidu.adp.widget.ListView.n> arrayList = new ArrayList<>();
                arrayList.add(awVar);
                threadList = this.jHO.a(false, true, arrayList, null, true);
            } else {
                threadList = cDm.getThreadList();
            }
            if (threadList != null) {
                cDm.setThreadList(threadList);
                cDm.checkLiveStageInThreadList();
                this.jif.a(threadList, cDm);
            }
        }
    }

    private void a(cb cbVar, FrsNewAreaFragment frsNewAreaFragment) {
        frsNewAreaFragment.aq(cbVar);
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
            builder.business_account_info = user_Info.business_account_info;
        }
    }

    public void f(final PostWriteCallBackData postWriteCallBackData) {
        if (this.jix != null) {
            boolean z = this.jix.cJo() != null && this.jix.cJo().getIsBrandForum();
            int cJS = this.jix.cJS();
            if (cJS == 2 || cJS == 3 || cJS == 7 || cJS == 8 || z) {
                if ((ac.cEL().yY(1) != null ? this.jix.cJL() : 0) == 0 && postWriteCallBackData != null) {
                    final long j = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getPostId(), 0L);
                    final long j2 = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getThreadId(), 0L);
                    final long j3 = com.baidu.adp.lib.f.b.toLong(this.jGE.getForumId(), 0L);
                    if (j != 0 && j2 != 0 && j3 != 0) {
                        com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.mc.d.4
                            @Override // java.lang.Runnable
                            public void run() {
                                int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
                                int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
                                float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                                int i = 1;
                                if (av.bsV().bsW()) {
                                    i = 2;
                                }
                                RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                                requestGetMyPostNetMessage.setProZone(postWriteCallBackData.getProZone());
                                requestGetMyPostNetMessage.setParams(j2, j, j3, equipmentWidth, equipmentHeight, f, i);
                                d.this.jGE.sendMessage(requestGetMyPostNetMessage);
                            }
                        }, 1000L);
                    } else if (postWriteCallBackData.writeDataForVideo != null) {
                        WriteData writeData = postWriteCallBackData.writeDataForVideo;
                        aw awVar = new aw();
                        awVar.a(writeData);
                        a(awVar, writeData.getProZone());
                    }
                }
            }
        }
    }
}
