package com.baidu.tieba.frs.mc;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.au;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.x;
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
    private final com.baidu.adp.framework.listener.a ixZ;
    private final CustomMessageListener jjE;
    private final CustomMessageListener jzK;

    public d(FrsFragment frsFragment) {
        super(frsFragment);
        this.jjE = new CustomMessageListener(CmdConfigCustom.PB_DELETE_THREAD) { // from class: com.baidu.tieba.frs.mc.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!StringUtils.isNull(str) && d.this.jzc.cBN() != null) {
                        FrsViewData cBN = d.this.jzc.cBN();
                        cBN.removeThread(str);
                        d.this.jaB.a(cBN.getThreadList(), cBN);
                        if (com.baidu.tieba.tbadkCore.e.dKh() != null) {
                            com.baidu.tieba.tbadkCore.e.dKh().bd(d.this.jzc.getForumName(), false);
                        }
                    }
                }
            }
        };
        this.jzK = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_MANAGE) { // from class: com.baidu.tieba.frs.mc.d.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v19, types: [java.util.List] */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ForumManageModel.e eVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ForumManageModel.e) && d.this.jzc != null && d.this.jaB != null && d.this.jaU != null && (eVar = (ForumManageModel.e) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(eVar.threadId) && d.this.jzc.cBN() != null) {
                    String str = eVar.threadId;
                    String str2 = eVar.forumId;
                    String str3 = eVar.forumName;
                    if (eVar.npO == 4) {
                        FrsViewData cBN = d.this.jzc.cBN();
                        bz threadDataById = cBN.getThreadDataById(str);
                        cBN.removeThreadData(threadDataById);
                        List<com.baidu.adp.widget.ListView.n> topThreadList = cBN.getTopThreadList();
                        if (topThreadList == null) {
                            topThreadList = new ArrayList<>();
                        }
                        topThreadList.add(0, threadDataById);
                        d.this.jaB.a(cBN.getThreadList(), cBN);
                        d.this.jaU.j(cBN);
                    }
                    if (TextUtils.equals(d.this.jzc.getForumName(), str3)) {
                        com.baidu.tieba.tbadkCore.e.dKh().bd(d.this.jzc.getForumName(), false);
                    }
                }
            }
        };
        this.ixZ = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.frs.mc.d.3
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
                                errorString2 = d.this.jzc.getResources().getString(R.string.neterror);
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
                                errorString = d.this.jzc.getResources().getString(R.string.neterror);
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
        this.ixZ.getSocketMessageListener().setSelfListener(true);
        this.ixZ.getHttpMessageListener().setSelfListener(true);
        this.jjE.setSelfListener(false);
        this.jzc.registerListener(this.jjE);
        this.jzc.registerListener(this.ixZ);
        this.jzc.registerListener(this.jzK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, GetMyPostResIdl getMyPostResIdl, int i2) {
        if (i != 0) {
            this.jzc.showToast(str);
            return;
        }
        FrsViewData cBN = this.jzc.cBN();
        if (cBN != null && cBN.getForum() != null && getMyPostResIdl != null && this.jaB != null && this.jaT != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
            au auVar = new au();
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
            builder.fname = cBN.getForum().getName();
            builder.fid = Long.valueOf(com.baidu.adp.lib.f.b.toLong(cBN.getForum().getId(), 0L));
            auVar.a(builder.build(true));
            a(auVar, i2);
        }
    }

    private void a(au auVar, int i) {
        if (i == 1) {
            FrsTabViewController.b cKz = this.jzc.cBg().cKz();
            if (cKz != null && (cKz.fragment instanceof FrsCommonTabFragment)) {
                ((FrsCommonTabFragment) cKz.fragment).ap(auVar);
            }
        } else if (i == 2) {
            FrsTabViewController.b Aw = this.jzc.cBg().Aw(301);
            if (Aw != null && (Aw.fragment instanceof FrsGoodFragment)) {
                this.jAl.sO(301);
                ((FrsGoodFragment) Aw.fragment).a(auVar);
            }
        } else if (auVar.getTabId() > 0) {
            FrsTabViewController.b Aw2 = this.jzc.cBg().Aw(auVar.getTabId());
            if (Aw2 != null && (Aw2.fragment instanceof FrsCommonTabFragment)) {
                ((FrsCommonTabFragment) Aw2.fragment).ap(auVar);
            }
        } else {
            if (!x.isEmpty(auVar.bpF())) {
                auVar.bmZ();
            }
            FrsTabViewController.b Aw3 = this.jzc.cBg().Aw(this.jzc.cBg().cKv());
            if (Aw3 != null) {
                if (Aw3.fragment instanceof FrsNewAreaFragment) {
                    a(auVar, (FrsNewAreaFragment) Aw3.fragment);
                } else {
                    b(auVar);
                }
            }
        }
    }

    private void b(au auVar) {
        ArrayList<com.baidu.adp.widget.ListView.n> a2;
        FrsViewData cBN = this.jzc.cBN();
        if (cBN != null) {
            this.jaT.addMyNewThread(auVar);
            if (this.jaT.cIx()) {
                ArrayList<com.baidu.adp.widget.ListView.n> arrayList = new ArrayList<>();
                arrayList.add(auVar);
                a2 = this.jAn.a(false, true, arrayList, null, true);
            } else {
                a2 = this.jAn.a(false, true, cBN.getThreadList(), null, true);
            }
            if (a2 != null) {
                cBN.setThreadList(a2);
                cBN.checkLiveStageInThreadList();
                this.jaB.a(a2, cBN);
            }
        }
    }

    private void a(bz bzVar, FrsNewAreaFragment frsNewAreaFragment) {
        frsNewAreaFragment.ap(bzVar);
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
        if (this.jaT != null) {
            boolean z = this.jaT.cHO() != null && this.jaT.cHO().getIsBrandForum();
            int cIs = this.jaT.cIs();
            if (cIs == 2 || cIs == 3 || cIs == 7 || cIs == 8 || z) {
                if ((ac.cDm().yN(1) != null ? this.jaT.cIl() : 0) == 0 && postWriteCallBackData != null) {
                    final long j = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getPostId(), 0L);
                    final long j2 = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getThreadId(), 0L);
                    final long j3 = com.baidu.adp.lib.f.b.toLong(this.jzc.getForumId(), 0L);
                    if (j != 0 && j2 != 0 && j3 != 0) {
                        com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.mc.d.4
                            @Override // java.lang.Runnable
                            public void run() {
                                int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
                                int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
                                float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                                int i = 1;
                                if (com.baidu.tbadk.core.util.au.bsy().bsz()) {
                                    i = 2;
                                }
                                RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                                requestGetMyPostNetMessage.setProZone(postWriteCallBackData.getProZone());
                                requestGetMyPostNetMessage.setParams(j2, j, j3, equipmentWidth, equipmentHeight, f, i);
                                d.this.jzc.sendMessage(requestGetMyPostNetMessage);
                            }
                        }, 1000L);
                    } else if (postWriteCallBackData.writeDataForVideo != null) {
                        WriteData writeData = postWriteCallBackData.writeDataForVideo;
                        au auVar = new au();
                        auVar.a(writeData);
                        a(auVar, writeData.getProZone());
                    }
                }
            }
        }
    }
}
