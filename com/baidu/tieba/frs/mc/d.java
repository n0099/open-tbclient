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
import com.baidu.tbadk.core.data.au;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.af;
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
    private final com.baidu.adp.framework.listener.a iqm;
    private final CustomMessageListener jbV;
    private final CustomMessageListener jrU;
    private final CustomMessageListener jrV;

    public d(FrsFragment frsFragment) {
        super(frsFragment);
        this.jrU = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.frs.mc.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && !((PostWriteCallBackData) customResponsedMessage.getData()).isDyamicCallback()) {
                    d.this.f((PostWriteCallBackData) customResponsedMessage.getData());
                }
            }
        };
        this.jbV = new CustomMessageListener(CmdConfigCustom.PB_DELETE_THREAD) { // from class: com.baidu.tieba.frs.mc.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!StringUtils.isNull(str) && d.this.jrm.cCK() != null) {
                        FrsViewData cCK = d.this.jrm.cCK();
                        cCK.removeThread(str);
                        d.this.iSX.a(cCK.getThreadList(), cCK);
                        if (com.baidu.tieba.tbadkCore.e.dOg() != null) {
                            com.baidu.tieba.tbadkCore.e.dOg().bd(d.this.jrm.getForumName(), false);
                        }
                    }
                }
            }
        };
        this.jrV = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_MANAGE) { // from class: com.baidu.tieba.frs.mc.d.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v19, types: [java.util.List] */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ForumManageModel.e eVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ForumManageModel.e) && d.this.jrm != null && d.this.iSX != null && d.this.iTq != null && (eVar = (ForumManageModel.e) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(eVar.threadId) && d.this.jrm.cCK() != null) {
                    String str = eVar.threadId;
                    String str2 = eVar.forumId;
                    String str3 = eVar.forumName;
                    if (eVar.noL == 4) {
                        FrsViewData cCK = d.this.jrm.cCK();
                        by threadDataById = cCK.getThreadDataById(str);
                        cCK.removeThreadData(threadDataById);
                        List<q> topThreadList = cCK.getTopThreadList();
                        if (topThreadList == null) {
                            topThreadList = new ArrayList<>();
                        }
                        topThreadList.add(0, threadDataById);
                        d.this.iSX.a(cCK.getThreadList(), cCK);
                        d.this.iTq.j(cCK);
                    }
                    if (TextUtils.equals(d.this.jrm.getForumName(), str3)) {
                        com.baidu.tieba.tbadkCore.e.dOg().bd(d.this.jrm.getForumName(), false);
                    }
                }
            }
        };
        this.iqm = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.frs.mc.d.4
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
                                errorString2 = d.this.jrm.getResources().getString(R.string.neterror);
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
                                errorString = d.this.jrm.getResources().getString(R.string.neterror);
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
        this.iqm.getSocketMessageListener().setSelfListener(true);
        this.iqm.getHttpMessageListener().setSelfListener(true);
        this.jbV.setSelfListener(false);
        this.jrm.registerListener(this.jbV);
        this.jrm.registerListener(this.iqm);
        this.jrm.registerListener(this.jrU);
        this.jrm.registerListener(this.jrV);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, GetMyPostResIdl getMyPostResIdl, int i2) {
        if (i != 0) {
            this.jrm.showToast(str);
            return;
        }
        FrsViewData cCK = this.jrm.cCK();
        if (cCK != null && cCK.getForum() != null && getMyPostResIdl != null && this.iSX != null && this.iTp != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
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
            builder.fname = cCK.getForum().getName();
            builder.fid = Long.valueOf(com.baidu.adp.lib.f.b.toLong(cCK.getForum().getId(), 0L));
            auVar.a(builder.build(true));
            if (i2 == 1) {
                FrsTabViewController.b cLn = this.jrm.cCd().cLn();
                if (cLn != null && (cLn.fragment instanceof FrsCommonTabFragment)) {
                    ((FrsCommonTabFragment) cLn.fragment).ap(auVar);
                }
            } else if (i2 == 2) {
                FrsTabViewController.b BQ = this.jrm.cCd().BQ(301);
                if (BQ != null && (BQ.fragment instanceof FrsGoodFragment)) {
                    this.jsw.ui(301);
                    ((FrsGoodFragment) BQ.fragment).a(auVar);
                }
            } else if (auVar.getTabId() > 0) {
                FrsTabViewController.b BQ2 = this.jrm.cCd().BQ(auVar.getTabId());
                if (BQ2 != null && (BQ2.fragment instanceof FrsCommonTabFragment)) {
                    this.jsw.ui(auVar.getTabId());
                    ((FrsCommonTabFragment) BQ2.fragment).ap(auVar);
                }
            } else {
                if (!y.isEmpty(auVar.bqW())) {
                    auVar.bor();
                }
                int cLj = this.jrm.cCd().cLj();
                FrsTabViewController.b BQ3 = this.jrm.cCd().BQ(cLj);
                if (BQ3 != null) {
                    this.jsw.ui(cLj);
                    if (BQ3.fragment instanceof FrsNewAreaFragment) {
                        a(auVar, (FrsNewAreaFragment) BQ3.fragment);
                    } else {
                        b(auVar);
                    }
                }
            }
        }
    }

    private void b(au auVar) {
        ArrayList<q> a2;
        FrsViewData cCK = this.jrm.cCK();
        if (cCK != null) {
            this.iTp.addMyNewThread(auVar);
            if (this.iTp.cJo()) {
                ArrayList<q> arrayList = new ArrayList<>();
                arrayList.add(auVar);
                a2 = this.jsy.a(false, true, arrayList, null, true);
            } else {
                a2 = this.jsy.a(false, true, cCK.getThreadList(), null, true);
            }
            if (a2 != null) {
                cCK.setThreadList(a2);
                cCK.checkLiveStageInThreadList();
                this.iSX.a(a2, cCK);
                this.iSX.zX(0);
            }
        }
    }

    private void a(by byVar, FrsNewAreaFragment frsNewAreaFragment) {
        frsNewAreaFragment.ap(byVar);
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
        if (this.iTp != null) {
            boolean z = this.iTp.cIF() != null && this.iTp.cIF().getIsBrandForum();
            int cJj = this.iTp.cJj();
            if (cJj == 2 || cJj == 3 || cJj == 7 || cJj == 8 || z) {
                if ((af.cEi().Ah(1) != null ? this.iTp.cJc() : 0) == 0 && postWriteCallBackData != null) {
                    final long j = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getPostId(), 0L);
                    final long j2 = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getThreadId(), 0L);
                    final long j3 = com.baidu.adp.lib.f.b.toLong(this.jrm.getForumId(), 0L);
                    if (j != 0 && j2 != 0 && j3 != 0) {
                        com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.mc.d.5
                            @Override // java.lang.Runnable
                            public void run() {
                                int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
                                int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
                                float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                                int i = 1;
                                if (av.btX().btY()) {
                                    i = 2;
                                }
                                RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                                requestGetMyPostNetMessage.setProZone(postWriteCallBackData.getProZone());
                                requestGetMyPostNetMessage.setParams(j2, j, j3, equipmentWidth, equipmentHeight, f, i);
                                d.this.jrm.sendMessage(requestGetMyPostNetMessage);
                            }
                        }, 1000L);
                    }
                }
            }
        }
    }
}
