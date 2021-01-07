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
    private final com.baidu.adp.framework.listener.a iCG;
    private final CustomMessageListener jEq;
    private final CustomMessageListener jol;

    public d(FrsFragment frsFragment) {
        super(frsFragment);
        this.jol = new CustomMessageListener(CmdConfigCustom.PB_DELETE_THREAD) { // from class: com.baidu.tieba.frs.mc.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!StringUtils.isNull(str) && d.this.jDI.cFF() != null) {
                        FrsViewData cFF = d.this.jDI.cFF();
                        cFF.removeThread(str);
                        d.this.jfi.a(cFF.getThreadList(), cFF);
                        if (com.baidu.tieba.tbadkCore.e.dNZ() != null) {
                            com.baidu.tieba.tbadkCore.e.dNZ().bd(d.this.jDI.getForumName(), false);
                        }
                    }
                }
            }
        };
        this.jEq = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_MANAGE) { // from class: com.baidu.tieba.frs.mc.d.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v19, types: [java.util.List] */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ForumManageModel.e eVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ForumManageModel.e) && d.this.jDI != null && d.this.jfi != null && d.this.jfB != null && (eVar = (ForumManageModel.e) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(eVar.threadId) && d.this.jDI.cFF() != null) {
                    String str = eVar.threadId;
                    String str2 = eVar.forumId;
                    String str3 = eVar.forumName;
                    if (eVar.nuu == 4) {
                        FrsViewData cFF = d.this.jDI.cFF();
                        bz threadDataById = cFF.getThreadDataById(str);
                        cFF.removeThreadData(threadDataById);
                        List<com.baidu.adp.widget.ListView.n> topThreadList = cFF.getTopThreadList();
                        if (topThreadList == null) {
                            topThreadList = new ArrayList<>();
                        }
                        topThreadList.add(0, threadDataById);
                        d.this.jfi.a(cFF.getThreadList(), cFF);
                        d.this.jfB.j(cFF);
                    }
                    if (TextUtils.equals(d.this.jDI.getForumName(), str3)) {
                        com.baidu.tieba.tbadkCore.e.dNZ().bd(d.this.jDI.getForumName(), false);
                    }
                }
            }
        };
        this.iCG = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.frs.mc.d.3
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
                                errorString2 = d.this.jDI.getResources().getString(R.string.neterror);
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
                                errorString = d.this.jDI.getResources().getString(R.string.neterror);
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
        this.iCG.getSocketMessageListener().setSelfListener(true);
        this.iCG.getHttpMessageListener().setSelfListener(true);
        this.jol.setSelfListener(false);
        this.jDI.registerListener(this.jol);
        this.jDI.registerListener(this.iCG);
        this.jDI.registerListener(this.jEq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, GetMyPostResIdl getMyPostResIdl, int i2) {
        if (i != 0) {
            this.jDI.showToast(str);
            return;
        }
        FrsViewData cFF = this.jDI.cFF();
        if (cFF != null && cFF.getForum() != null && getMyPostResIdl != null && this.jfi != null && this.jfA != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
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
            builder.fname = cFF.getForum().getName();
            builder.fid = Long.valueOf(com.baidu.adp.lib.f.b.toLong(cFF.getForum().getId(), 0L));
            auVar.a(builder.build(true));
            a(auVar, i2);
        }
    }

    private void a(au auVar, int i) {
        if (i == 1) {
            FrsTabViewController.b cOr = this.jDI.cEY().cOr();
            if (cOr != null && (cOr.fragment instanceof FrsCommonTabFragment)) {
                ((FrsCommonTabFragment) cOr.fragment).ap(auVar);
            }
        } else if (i == 2) {
            FrsTabViewController.b Cc = this.jDI.cEY().Cc(301);
            if (Cc != null && (Cc.fragment instanceof FrsGoodFragment)) {
                this.jER.uu(301);
                ((FrsGoodFragment) Cc.fragment).a(auVar);
            }
        } else if (auVar.getTabId() > 0) {
            FrsTabViewController.b Cc2 = this.jDI.cEY().Cc(auVar.getTabId());
            if (Cc2 != null && (Cc2.fragment instanceof FrsCommonTabFragment)) {
                ((FrsCommonTabFragment) Cc2.fragment).ap(auVar);
            }
        } else {
            if (!x.isEmpty(auVar.btz())) {
                auVar.bqT();
            }
            FrsTabViewController.b Cc3 = this.jDI.cEY().Cc(this.jDI.cEY().cOn());
            if (Cc3 != null) {
                if (Cc3.fragment instanceof FrsNewAreaFragment) {
                    a(auVar, (FrsNewAreaFragment) Cc3.fragment);
                } else {
                    b(auVar);
                }
            }
        }
    }

    private void b(au auVar) {
        ArrayList<com.baidu.adp.widget.ListView.n> a2;
        FrsViewData cFF = this.jDI.cFF();
        if (cFF != null) {
            this.jfA.addMyNewThread(auVar);
            if (this.jfA.cMp()) {
                ArrayList<com.baidu.adp.widget.ListView.n> arrayList = new ArrayList<>();
                arrayList.add(auVar);
                a2 = this.jET.a(false, true, arrayList, null, true);
            } else {
                a2 = this.jET.a(false, true, cFF.getThreadList(), null, true);
            }
            if (a2 != null) {
                cFF.setThreadList(a2);
                cFF.checkLiveStageInThreadList();
                this.jfi.a(a2, cFF);
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
        if (this.jfA != null) {
            boolean z = this.jfA.cLG() != null && this.jfA.cLG().getIsBrandForum();
            int cMk = this.jfA.cMk();
            if (cMk == 2 || cMk == 3 || cMk == 7 || cMk == 8 || z) {
                if ((ac.cHe().At(1) != null ? this.jfA.cMd() : 0) == 0 && postWriteCallBackData != null) {
                    final long j = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getPostId(), 0L);
                    final long j2 = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getThreadId(), 0L);
                    final long j3 = com.baidu.adp.lib.f.b.toLong(this.jDI.getForumId(), 0L);
                    if (j != 0 && j2 != 0 && j3 != 0) {
                        com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.mc.d.4
                            @Override // java.lang.Runnable
                            public void run() {
                                int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
                                int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
                                float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                                int i = 1;
                                if (com.baidu.tbadk.core.util.au.bws().bwt()) {
                                    i = 2;
                                }
                                RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                                requestGetMyPostNetMessage.setProZone(postWriteCallBackData.getProZone());
                                requestGetMyPostNetMessage.setParams(j2, j, j3, equipmentWidth, equipmentHeight, f, i);
                                d.this.jDI.sendMessage(requestGetMyPostNetMessage);
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
