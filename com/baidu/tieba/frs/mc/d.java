package com.baidu.tieba.frs.mc;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.o;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.ab;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
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
    private final com.baidu.adp.framework.listener.a gKs;
    private final CustomMessageListener hGM;
    private final CustomMessageListener hGN;
    private final CustomMessageListener huH;

    public d(FrsFragment frsFragment) {
        super(frsFragment);
        this.hGM = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.frs.mc.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && !((PostWriteCallBackData) customResponsedMessage.getData()).isDyamicCallback()) {
                    d.this.e((PostWriteCallBackData) customResponsedMessage.getData());
                }
            }
        };
        this.huH = new CustomMessageListener(CmdConfigCustom.PB_DELETE_THREAD) { // from class: com.baidu.tieba.frs.mc.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!StringUtils.isNull(str) && d.this.hGd.bVs() != null) {
                        FrsViewData bVs = d.this.hGd.bVs();
                        bVs.removeThread(str);
                        d.this.hni.a(bVs.getThreadList(), bVs);
                        if (com.baidu.tieba.tbadkCore.e.dcu() != null) {
                            com.baidu.tieba.tbadkCore.e.dcu().aT(d.this.hGd.getForumName(), false);
                        }
                    }
                }
            }
        };
        this.hGN = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_MANAGE) { // from class: com.baidu.tieba.frs.mc.d.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v19, types: [java.util.List] */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ForumManageModel.e eVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ForumManageModel.e) && d.this.hGd != null && d.this.hni != null && d.this.hnz != null && (eVar = (ForumManageModel.e) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(eVar.threadId) && d.this.hGd.bVs() != null) {
                    String str = eVar.threadId;
                    String str2 = eVar.forumId;
                    String str3 = eVar.forumName;
                    if (eVar.lnD == 4) {
                        FrsViewData bVs = d.this.hGd.bVs();
                        bk threadDataById = bVs.getThreadDataById(str);
                        bVs.removeThreadData(threadDataById);
                        List<o> topThreadList = bVs.getTopThreadList();
                        if (topThreadList == null) {
                            topThreadList = new ArrayList<>();
                        }
                        topThreadList.add(0, threadDataById);
                        d.this.hni.a(bVs.getThreadList(), bVs);
                        d.this.hnz.i(bVs);
                    }
                    if (TextUtils.equals(d.this.hGd.getForumName(), str3)) {
                        com.baidu.tieba.tbadkCore.e.dcu().aT(d.this.hGd.getForumName(), false);
                    }
                }
            }
        };
        this.gKs = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.frs.mc.d.4
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String errorString;
                String errorString2;
                if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                    GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
                    if (StringUtils.isNull(getMyPostHttpResponseMessage.getErrorString())) {
                        errorString2 = d.this.hGd.getResources().getString(R.string.neterror);
                    } else {
                        errorString2 = getMyPostHttpResponseMessage.getErrorString();
                    }
                    d.this.a(getMyPostHttpResponseMessage.getError(), errorString2, getMyPostHttpResponseMessage.getResponseData(), responsedMessage.getOrginalMessage().getExtra() instanceof RequestGetMyPostNetMessage ? ((RequestGetMyPostNetMessage) responsedMessage.getOrginalMessage().getExtra()).getProZone() : 0);
                } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                    GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                    if (StringUtils.isNull(getMyPostSocketResponseMessage.getErrorString())) {
                        errorString = d.this.hGd.getResources().getString(R.string.neterror);
                    } else {
                        errorString = getMyPostSocketResponseMessage.getErrorString();
                    }
                    d.this.a(getMyPostSocketResponseMessage.getError(), errorString, getMyPostSocketResponseMessage.getResponseData(), responsedMessage.getOrginalMessage().getExtra() instanceof RequestGetMyPostNetMessage ? ((RequestGetMyPostNetMessage) responsedMessage.getOrginalMessage().getExtra()).getProZone() : 0);
                }
            }
        };
        this.gKs.getSocketMessageListener().setSelfListener(true);
        this.gKs.getHttpMessageListener().setSelfListener(true);
        this.huH.setSelfListener(false);
        this.hGd.registerListener(this.huH);
        this.hGd.registerListener(this.gKs);
        this.hGd.registerListener(this.hGM);
        this.hGd.registerListener(this.hGN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, GetMyPostResIdl getMyPostResIdl, int i2) {
        if (i != 0) {
            this.hGd.showToast(str);
            return;
        }
        FrsViewData bVs = this.hGd.bVs();
        if (bVs != null && bVs.getForum() != null && getMyPostResIdl != null && this.hni != null && this.hny != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
            al alVar = new al();
            ThreadInfo.Builder builder = new ThreadInfo.Builder(getMyPostResIdl.data.thread_info);
            User.Builder builder2 = new User.Builder(builder.author);
            a(builder2, getMyPostResIdl.data.user_info);
            builder.author = builder2.build(true);
            builder.cheak_repeat = 1;
            builder.fname = bVs.getForum().getName();
            builder.fid = Long.valueOf(com.baidu.adp.lib.f.b.toLong(bVs.getForum().getId(), 0L));
            alVar.a(builder.build(true));
            if (i2 == 1) {
                FrsTabViewController.b cco = this.hGd.bUP().cco();
                if (cco != null && (cco.fragment instanceof FrsCommonTabFragment)) {
                    ((FrsCommonTabFragment) cco.fragment).ap(alVar);
                }
            } else if (alVar.getTabId() > 0) {
                FrsTabViewController.b vA = this.hGd.bUP().vA(alVar.getTabId());
                if (vA != null && (vA.fragment instanceof FrsCommonTabFragment)) {
                    this.hHp.vB(alVar.getTabId());
                    ((FrsCommonTabFragment) vA.fragment).ap(alVar);
                }
            } else {
                int cck = this.hGd.bUP().cck();
                FrsTabViewController.b vA2 = this.hGd.bUP().vA(cck);
                if (vA2 != null) {
                    this.hHp.vB(cck);
                    if (vA2.fragment instanceof FrsNewAreaFragment) {
                        a(alVar, (FrsNewAreaFragment) vA2.fragment);
                    } else {
                        a(alVar);
                    }
                }
            }
        }
    }

    private void a(al alVar) {
        ArrayList<o> a;
        FrsViewData bVs = this.hGd.bVs();
        if (bVs != null) {
            this.hny.addMyNewThread(alVar);
            if (this.hny.caA()) {
                ArrayList<o> arrayList = new ArrayList<>();
                arrayList.add(alVar);
                a = this.hHr.a(false, true, arrayList, null, true);
            } else {
                a = this.hHr.a(false, true, bVs.getThreadList(), null, true);
            }
            if (a != null) {
                bVs.setThreadList(a);
                bVs.checkLiveStageInThreadList();
                this.hni.a(a, bVs);
                this.hni.tV(0);
            }
        }
    }

    private void a(bk bkVar, FrsNewAreaFragment frsNewAreaFragment) {
        frsNewAreaFragment.ap(bkVar);
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
        if (this.hny != null) {
            boolean z = this.hny.bZR() != null && this.hny.bZR().getIsBrandForum();
            int cav = this.hny.cav();
            if (cav == 2 || cav == 3 || cav == 7 || cav == 8 || z) {
                if ((ab.bWL().ud(1) != null ? this.hny.cao() : 0) == 0 && postWriteCallBackData != null) {
                    final long j = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getPostId(), 0L);
                    final long j2 = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getThreadId(), 0L);
                    final long j3 = com.baidu.adp.lib.f.b.toLong(this.hGd.getForumId(), 0L);
                    if (j != 0 && j2 != 0 && j3 != 0) {
                        com.baidu.adp.lib.f.e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.mc.d.5
                            @Override // java.lang.Runnable
                            public void run() {
                                int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
                                int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
                                float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                                int i = 1;
                                if (ar.aUW().aUX()) {
                                    i = 2;
                                }
                                RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                                requestGetMyPostNetMessage.setProZone(postWriteCallBackData.getProZone());
                                requestGetMyPostNetMessage.setParams(j2, j, j3, equipmentWidth, equipmentHeight, f, i);
                                d.this.hGd.sendMessage(requestGetMyPostNetMessage);
                            }
                        }, 1000L);
                    }
                }
            }
        }
    }
}
