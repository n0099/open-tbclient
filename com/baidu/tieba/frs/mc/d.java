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
    private final CustomMessageListener iQo;
    private final com.baidu.adp.framework.listener.a ieB;
    private final CustomMessageListener jdC;
    private final CustomMessageListener jdD;

    public d(FrsFragment frsFragment) {
        super(frsFragment);
        this.jdC = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.frs.mc.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && !((PostWriteCallBackData) customResponsedMessage.getData()).isDyamicCallback()) {
                    d.this.f((PostWriteCallBackData) customResponsedMessage.getData());
                }
            }
        };
        this.iQo = new CustomMessageListener(CmdConfigCustom.PB_DELETE_THREAD) { // from class: com.baidu.tieba.frs.mc.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!StringUtils.isNull(str) && d.this.jcU.cyP() != null) {
                        FrsViewData cyP = d.this.jcU.cyP();
                        cyP.removeThread(str);
                        d.this.iHp.a(cyP.getThreadList(), cyP);
                        if (com.baidu.tieba.tbadkCore.e.dIY() != null) {
                            com.baidu.tieba.tbadkCore.e.dIY().bc(d.this.jcU.getForumName(), false);
                        }
                    }
                }
            }
        };
        this.jdD = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_MANAGE) { // from class: com.baidu.tieba.frs.mc.d.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v19, types: [java.util.List] */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ForumManageModel.e eVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ForumManageModel.e) && d.this.jcU != null && d.this.iHp != null && d.this.iHJ != null && (eVar = (ForumManageModel.e) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(eVar.threadId) && d.this.jcU.cyP() != null) {
                    String str = eVar.threadId;
                    String str2 = eVar.forumId;
                    String str3 = eVar.forumName;
                    if (eVar.mZF == 4) {
                        FrsViewData cyP = d.this.jcU.cyP();
                        bw threadDataById = cyP.getThreadDataById(str);
                        cyP.removeThreadData(threadDataById);
                        List<q> topThreadList = cyP.getTopThreadList();
                        if (topThreadList == null) {
                            topThreadList = new ArrayList<>();
                        }
                        topThreadList.add(0, threadDataById);
                        d.this.iHp.a(cyP.getThreadList(), cyP);
                        d.this.iHJ.i(cyP);
                    }
                    if (TextUtils.equals(d.this.jcU.getForumName(), str3)) {
                        com.baidu.tieba.tbadkCore.e.dIY().bc(d.this.jcU.getForumName(), false);
                    }
                }
            }
        };
        this.ieB = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.frs.mc.d.4
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
                                errorString2 = d.this.jcU.getResources().getString(R.string.neterror);
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
                                errorString = d.this.jcU.getResources().getString(R.string.neterror);
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
        this.ieB.getSocketMessageListener().setSelfListener(true);
        this.ieB.getHttpMessageListener().setSelfListener(true);
        this.iQo.setSelfListener(false);
        this.jcU.registerListener(this.iQo);
        this.jcU.registerListener(this.ieB);
        this.jcU.registerListener(this.jdC);
        this.jcU.registerListener(this.jdD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, GetMyPostResIdl getMyPostResIdl, int i2) {
        if (i != 0) {
            this.jcU.showToast(str);
            return;
        }
        FrsViewData cyP = this.jcU.cyP();
        if (cyP != null && cyP.getForum() != null && getMyPostResIdl != null && this.iHp != null && this.iHI != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
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
            builder.fname = cyP.getForum().getName();
            builder.fid = Long.valueOf(com.baidu.adp.lib.f.b.toLong(cyP.getForum().getId(), 0L));
            asVar.a(builder.build(true));
            if (i2 == 1) {
                FrsTabViewController.b cGs = this.jcU.cyj().cGs();
                if (cGs != null && (cGs.fragment instanceof FrsCommonTabFragment)) {
                    ((FrsCommonTabFragment) cGs.fragment).an(asVar);
                }
            } else if (i2 == 2) {
                FrsTabViewController.b AE = this.jcU.cyj().AE(301);
                if (AE != null && (AE.fragment instanceof FrsGoodFragment)) {
                    this.jee.tg(301);
                    ((FrsGoodFragment) AE.fragment).a(asVar);
                }
            } else if (asVar.getTabId() > 0) {
                FrsTabViewController.b AE2 = this.jcU.cyj().AE(asVar.getTabId());
                if (AE2 != null && (AE2.fragment instanceof FrsCommonTabFragment)) {
                    this.jee.tg(asVar.getTabId());
                    ((FrsCommonTabFragment) AE2.fragment).an(asVar);
                }
            } else {
                if (!y.isEmpty(asVar.boE())) {
                    asVar.bmc();
                    int cGo = this.jcU.cyj().cGo();
                    FrsTabViewController.b AE3 = this.jcU.cyj().AE(cGo);
                    if (AE3 != null && (AE3.fragment instanceof FrsCommonTabFragment)) {
                        this.jee.tg(cGo);
                        ((FrsCommonTabFragment) AE3.fragment).an(asVar);
                        return;
                    }
                }
                int cGn = this.jcU.cyj().cGn();
                FrsTabViewController.b AE4 = this.jcU.cyj().AE(cGn);
                if (AE4 != null) {
                    this.jee.tg(cGn);
                    if (AE4.fragment instanceof FrsNewAreaFragment) {
                        a(asVar, (FrsNewAreaFragment) AE4.fragment);
                    } else {
                        b(asVar);
                    }
                }
            }
        }
    }

    private void b(as asVar) {
        ArrayList<q> a2;
        FrsViewData cyP = this.jcU.cyP();
        if (cyP != null) {
            this.iHI.addMyNewThread(asVar);
            if (this.iHI.cEw()) {
                ArrayList<q> arrayList = new ArrayList<>();
                arrayList.add(asVar);
                a2 = this.jeg.a(false, true, arrayList, null, true);
            } else {
                a2 = this.jeg.a(false, true, cyP.getThreadList(), null, true);
            }
            if (a2 != null) {
                cyP.setThreadList(a2);
                cyP.checkLiveStageInThreadList();
                this.iHp.a(a2, cyP);
                this.iHp.yU(0);
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
        if (this.iHI != null) {
            boolean z = this.iHI.cDN() != null && this.iHI.cDN().getIsBrandForum();
            int cEr = this.iHI.cEr();
            if (cEr == 2 || cEr == 3 || cEr == 7 || cEr == 8 || z) {
                if ((ag.cAo().ze(1) != null ? this.iHI.cEk() : 0) == 0 && postWriteCallBackData != null) {
                    final long j = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getPostId(), 0L);
                    final long j2 = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getThreadId(), 0L);
                    final long j3 = com.baidu.adp.lib.f.b.toLong(this.jcU.getForumId(), 0L);
                    if (j != 0 && j2 != 0 && j3 != 0) {
                        com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.mc.d.5
                            @Override // java.lang.Runnable
                            public void run() {
                                int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
                                int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
                                float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                                int i = 1;
                                if (au.bro().brp()) {
                                    i = 2;
                                }
                                RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                                requestGetMyPostNetMessage.setProZone(postWriteCallBackData.getProZone());
                                requestGetMyPostNetMessage.setParams(j2, j, j3, equipmentWidth, equipmentHeight, f, i);
                                d.this.jcU.sendMessage(requestGetMyPostNetMessage);
                            }
                        }, 1000L);
                    }
                }
            }
        }
    }
}
