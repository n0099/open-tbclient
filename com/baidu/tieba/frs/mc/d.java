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
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.av;
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
    private final CustomMessageListener iRb;
    private final com.baidu.adp.framework.listener.a ifq;
    private final CustomMessageListener jep;
    private final CustomMessageListener jeq;

    public d(FrsFragment frsFragment) {
        super(frsFragment);
        this.jep = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.frs.mc.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && !((PostWriteCallBackData) customResponsedMessage.getData()).isDyamicCallback()) {
                    d.this.f((PostWriteCallBackData) customResponsedMessage.getData());
                }
            }
        };
        this.iRb = new CustomMessageListener(CmdConfigCustom.PB_DELETE_THREAD) { // from class: com.baidu.tieba.frs.mc.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!StringUtils.isNull(str) && d.this.jdH.cys() != null) {
                        FrsViewData cys = d.this.jdH.cys();
                        cys.removeThread(str);
                        d.this.iId.a(cys.getThreadList(), cys);
                        if (com.baidu.tieba.tbadkCore.e.dIP() != null) {
                            com.baidu.tieba.tbadkCore.e.dIP().bc(d.this.jdH.getForumName(), false);
                        }
                    }
                }
            }
        };
        this.jeq = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_MANAGE) { // from class: com.baidu.tieba.frs.mc.d.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v19, types: [java.util.List] */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ForumManageModel.e eVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ForumManageModel.e) && d.this.jdH != null && d.this.iId != null && d.this.iIx != null && (eVar = (ForumManageModel.e) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(eVar.threadId) && d.this.jdH.cys() != null) {
                    String str = eVar.threadId;
                    String str2 = eVar.forumId;
                    String str3 = eVar.forumName;
                    if (eVar.naG == 4) {
                        FrsViewData cys = d.this.jdH.cys();
                        bx threadDataById = cys.getThreadDataById(str);
                        cys.removeThreadData(threadDataById);
                        List<q> topThreadList = cys.getTopThreadList();
                        if (topThreadList == null) {
                            topThreadList = new ArrayList<>();
                        }
                        topThreadList.add(0, threadDataById);
                        d.this.iId.a(cys.getThreadList(), cys);
                        d.this.iIx.j(cys);
                    }
                    if (TextUtils.equals(d.this.jdH.getForumName(), str3)) {
                        com.baidu.tieba.tbadkCore.e.dIP().bc(d.this.jdH.getForumName(), false);
                    }
                }
            }
        };
        this.ifq = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.frs.mc.d.4
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
                                errorString2 = d.this.jdH.getResources().getString(R.string.neterror);
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
                                errorString = d.this.jdH.getResources().getString(R.string.neterror);
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
        this.ifq.getSocketMessageListener().setSelfListener(true);
        this.ifq.getHttpMessageListener().setSelfListener(true);
        this.iRb.setSelfListener(false);
        this.jdH.registerListener(this.iRb);
        this.jdH.registerListener(this.ifq);
        this.jdH.registerListener(this.jep);
        this.jdH.registerListener(this.jeq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, GetMyPostResIdl getMyPostResIdl, int i2) {
        if (i != 0) {
            this.jdH.showToast(str);
            return;
        }
        FrsViewData cys = this.jdH.cys();
        if (cys != null && cys.getForum() != null && getMyPostResIdl != null && this.iId != null && this.iIw != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
            at atVar = new at();
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
            builder.fname = cys.getForum().getName();
            builder.fid = Long.valueOf(com.baidu.adp.lib.f.b.toLong(cys.getForum().getId(), 0L));
            atVar.a(builder.build(true));
            if (i2 == 1) {
                FrsTabViewController.b cFX = this.jdH.cxM().cFX();
                if (cFX != null && (cFX.fragment instanceof FrsCommonTabFragment)) {
                    ((FrsCommonTabFragment) cFX.fragment).ap(atVar);
                }
            } else if (i2 == 2) {
                FrsTabViewController.b Bc = this.jdH.cxM().Bc(301);
                if (Bc != null && (Bc.fragment instanceof FrsGoodFragment)) {
                    this.jeR.tE(301);
                    ((FrsGoodFragment) Bc.fragment).a(atVar);
                }
            } else if (atVar.getTabId() > 0) {
                FrsTabViewController.b Bc2 = this.jdH.cxM().Bc(atVar.getTabId());
                if (Bc2 != null && (Bc2.fragment instanceof FrsCommonTabFragment)) {
                    this.jeR.tE(atVar.getTabId());
                    ((FrsCommonTabFragment) Bc2.fragment).ap(atVar);
                }
            } else {
                if (!y.isEmpty(atVar.bnI())) {
                    atVar.ble();
                    int cFT = this.jdH.cxM().cFT();
                    FrsTabViewController.b Bc3 = this.jdH.cxM().Bc(cFT);
                    if (Bc3 != null && (Bc3.fragment instanceof FrsCommonTabFragment)) {
                        this.jeR.tE(cFT);
                        ((FrsCommonTabFragment) Bc3.fragment).ap(atVar);
                        return;
                    }
                }
                int cFS = this.jdH.cxM().cFS();
                FrsTabViewController.b Bc4 = this.jdH.cxM().Bc(cFS);
                if (Bc4 != null) {
                    this.jeR.tE(cFS);
                    if (Bc4.fragment instanceof FrsNewAreaFragment) {
                        a(atVar, (FrsNewAreaFragment) Bc4.fragment);
                    } else {
                        b(atVar);
                    }
                }
            }
        }
    }

    private void b(at atVar) {
        ArrayList<q> a2;
        FrsViewData cys = this.jdH.cys();
        if (cys != null) {
            this.iIw.addMyNewThread(atVar);
            if (this.iIw.cEa()) {
                ArrayList<q> arrayList = new ArrayList<>();
                arrayList.add(atVar);
                a2 = this.jeT.a(false, true, arrayList, null, true);
            } else {
                a2 = this.jeT.a(false, true, cys.getThreadList(), null, true);
            }
            if (a2 != null) {
                cys.setThreadList(a2);
                cys.checkLiveStageInThreadList();
                this.iId.a(a2, cys);
                this.iId.zs(0);
            }
        }
    }

    private void a(bx bxVar, FrsNewAreaFragment frsNewAreaFragment) {
        frsNewAreaFragment.ap(bxVar);
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
        if (this.iIw != null) {
            boolean z = this.iIw.cDr() != null && this.iIw.cDr().getIsBrandForum();
            int cDV = this.iIw.cDV();
            if (cDV == 2 || cDV == 3 || cDV == 7 || cDV == 8 || z) {
                if ((ag.czR().zC(1) != null ? this.iIw.cDO() : 0) == 0 && postWriteCallBackData != null) {
                    final long j = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getPostId(), 0L);
                    final long j2 = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getThreadId(), 0L);
                    final long j3 = com.baidu.adp.lib.f.b.toLong(this.jdH.getForumId(), 0L);
                    if (j != 0 && j2 != 0 && j3 != 0) {
                        com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.mc.d.5
                            @Override // java.lang.Runnable
                            public void run() {
                                int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
                                int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
                                float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                                int i = 1;
                                if (av.bqC().bqD()) {
                                    i = 2;
                                }
                                RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                                requestGetMyPostNetMessage.setProZone(postWriteCallBackData.getProZone());
                                requestGetMyPostNetMessage.setParams(j2, j, j3, equipmentWidth, equipmentHeight, f, i);
                                d.this.jdH.sendMessage(requestGetMyPostNetMessage);
                            }
                        }, 1000L);
                    }
                }
            }
        }
    }
}
