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
    private final com.baidu.adp.framework.listener.a hMd;
    private final CustomMessageListener iLj;
    private final CustomMessageListener iLk;
    private final CustomMessageListener ixV;

    public d(FrsFragment frsFragment) {
        super(frsFragment);
        this.iLj = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.frs.mc.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && !((PostWriteCallBackData) customResponsedMessage.getData()).isDyamicCallback()) {
                    d.this.f((PostWriteCallBackData) customResponsedMessage.getData());
                }
            }
        };
        this.ixV = new CustomMessageListener(CmdConfigCustom.PB_DELETE_THREAD) { // from class: com.baidu.tieba.frs.mc.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!StringUtils.isNull(str) && d.this.iKB.cth() != null) {
                        FrsViewData cth = d.this.iKB.cth();
                        cth.removeThread(str);
                        d.this.ioW.a(cth.getThreadList(), cth);
                        if (com.baidu.tieba.tbadkCore.e.dDo() != null) {
                            com.baidu.tieba.tbadkCore.e.dDo().ba(d.this.iKB.getForumName(), false);
                        }
                    }
                }
            }
        };
        this.iLk = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_MANAGE) { // from class: com.baidu.tieba.frs.mc.d.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v19, types: [java.util.List] */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ForumManageModel.e eVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ForumManageModel.e) && d.this.iKB != null && d.this.ioW != null && d.this.ipq != null && (eVar = (ForumManageModel.e) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(eVar.threadId) && d.this.iKB.cth() != null) {
                    String str = eVar.threadId;
                    String str2 = eVar.forumId;
                    String str3 = eVar.forumName;
                    if (eVar.mGX == 4) {
                        FrsViewData cth = d.this.iKB.cth();
                        bw threadDataById = cth.getThreadDataById(str);
                        cth.removeThreadData(threadDataById);
                        List<q> topThreadList = cth.getTopThreadList();
                        if (topThreadList == null) {
                            topThreadList = new ArrayList<>();
                        }
                        topThreadList.add(0, threadDataById);
                        d.this.ioW.a(cth.getThreadList(), cth);
                        d.this.ipq.i(cth);
                    }
                    if (TextUtils.equals(d.this.iKB.getForumName(), str3)) {
                        com.baidu.tieba.tbadkCore.e.dDo().ba(d.this.iKB.getForumName(), false);
                    }
                }
            }
        };
        this.hMd = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.frs.mc.d.4
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
                                errorString2 = d.this.iKB.getResources().getString(R.string.neterror);
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
                                errorString = d.this.iKB.getResources().getString(R.string.neterror);
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
        this.hMd.getSocketMessageListener().setSelfListener(true);
        this.hMd.getHttpMessageListener().setSelfListener(true);
        this.ixV.setSelfListener(false);
        this.iKB.registerListener(this.ixV);
        this.iKB.registerListener(this.hMd);
        this.iKB.registerListener(this.iLj);
        this.iKB.registerListener(this.iLk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, GetMyPostResIdl getMyPostResIdl, int i2) {
        if (i != 0) {
            this.iKB.showToast(str);
            return;
        }
        FrsViewData cth = this.iKB.cth();
        if (cth != null && cth.getForum() != null && getMyPostResIdl != null && this.ioW != null && this.ipp != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
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
            builder.fname = cth.getForum().getName();
            builder.fid = Long.valueOf(com.baidu.adp.lib.f.b.toLong(cth.getForum().getId(), 0L));
            asVar.a(builder.build(true));
            if (i2 == 1) {
                FrsTabViewController.b cAK = this.iKB.csB().cAK();
                if (cAK != null && (cAK.fragment instanceof FrsCommonTabFragment)) {
                    ((FrsCommonTabFragment) cAK.fragment).an(asVar);
                }
            } else if (i2 == 2) {
                FrsTabViewController.b zY = this.iKB.csB().zY(301);
                if (zY != null && (zY.fragment instanceof FrsGoodFragment)) {
                    this.iLL.sL(301);
                    ((FrsGoodFragment) zY.fragment).a(asVar);
                }
            } else if (asVar.getTabId() > 0) {
                FrsTabViewController.b zY2 = this.iKB.csB().zY(asVar.getTabId());
                if (zY2 != null && (zY2.fragment instanceof FrsCommonTabFragment)) {
                    this.iLL.sL(asVar.getTabId());
                    ((FrsCommonTabFragment) zY2.fragment).an(asVar);
                }
            } else {
                if (!y.isEmpty(asVar.bkl())) {
                    asVar.bhJ();
                    int cAG = this.iKB.csB().cAG();
                    FrsTabViewController.b zY3 = this.iKB.csB().zY(cAG);
                    if (zY3 != null && (zY3.fragment instanceof FrsCommonTabFragment)) {
                        this.iLL.sL(cAG);
                        ((FrsCommonTabFragment) zY3.fragment).an(asVar);
                        return;
                    }
                }
                int cAF = this.iKB.csB().cAF();
                FrsTabViewController.b zY4 = this.iKB.csB().zY(cAF);
                if (zY4 != null) {
                    this.iLL.sL(cAF);
                    if (zY4.fragment instanceof FrsNewAreaFragment) {
                        a(asVar, (FrsNewAreaFragment) zY4.fragment);
                    } else {
                        b(asVar);
                    }
                }
            }
        }
    }

    private void b(as asVar) {
        ArrayList<q> a2;
        FrsViewData cth = this.iKB.cth();
        if (cth != null) {
            this.ipp.addMyNewThread(asVar);
            if (this.ipp.cyO()) {
                ArrayList<q> arrayList = new ArrayList<>();
                arrayList.add(asVar);
                a2 = this.iLN.a(false, true, arrayList, null, true);
            } else {
                a2 = this.iLN.a(false, true, cth.getThreadList(), null, true);
            }
            if (a2 != null) {
                cth.setThreadList(a2);
                cth.checkLiveStageInThreadList();
                this.ioW.a(a2, cth);
                this.ioW.yo(0);
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
        if (this.ipp != null) {
            boolean z = this.ipp.cyf() != null && this.ipp.cyf().getIsBrandForum();
            int cyJ = this.ipp.cyJ();
            if (cyJ == 2 || cyJ == 3 || cyJ == 7 || cyJ == 8 || z) {
                if ((ag.cuG().yy(1) != null ? this.ipp.cyC() : 0) == 0 && postWriteCallBackData != null) {
                    final long j = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getPostId(), 0L);
                    final long j2 = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getThreadId(), 0L);
                    final long j3 = com.baidu.adp.lib.f.b.toLong(this.iKB.getForumId(), 0L);
                    if (j != 0 && j2 != 0 && j3 != 0) {
                        com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.mc.d.5
                            @Override // java.lang.Runnable
                            public void run() {
                                int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
                                int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
                                float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                                int i = 1;
                                if (au.bmV().bmW()) {
                                    i = 2;
                                }
                                RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                                requestGetMyPostNetMessage.setProZone(postWriteCallBackData.getProZone());
                                requestGetMyPostNetMessage.setParams(j2, j, j3, equipmentWidth, equipmentHeight, f, i);
                                d.this.iKB.sendMessage(requestGetMyPostNetMessage);
                            }
                        }, 1000L);
                    }
                }
            }
        }
    }
}
