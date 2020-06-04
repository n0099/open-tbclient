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
    private final com.baidu.adp.framework.listener.a gKD;
    private final CustomMessageListener hHA;
    private final CustomMessageListener hHz;
    private final CustomMessageListener huS;

    public d(FrsFragment frsFragment) {
        super(frsFragment);
        this.hHz = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.frs.mc.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && !((PostWriteCallBackData) customResponsedMessage.getData()).isDyamicCallback()) {
                    d.this.e((PostWriteCallBackData) customResponsedMessage.getData());
                }
            }
        };
        this.huS = new CustomMessageListener(CmdConfigCustom.PB_DELETE_THREAD) { // from class: com.baidu.tieba.frs.mc.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!StringUtils.isNull(str) && d.this.hGQ.bVu() != null) {
                        FrsViewData bVu = d.this.hGQ.bVu();
                        bVu.removeThread(str);
                        d.this.hnt.a(bVu.getThreadList(), bVu);
                        if (com.baidu.tieba.tbadkCore.e.dcJ() != null) {
                            com.baidu.tieba.tbadkCore.e.dcJ().aT(d.this.hGQ.getForumName(), false);
                        }
                    }
                }
            }
        };
        this.hHA = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_MANAGE) { // from class: com.baidu.tieba.frs.mc.d.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v19, types: [java.util.List] */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ForumManageModel.e eVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ForumManageModel.e) && d.this.hGQ != null && d.this.hnt != null && d.this.hnK != null && (eVar = (ForumManageModel.e) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(eVar.threadId) && d.this.hGQ.bVu() != null) {
                    String str = eVar.threadId;
                    String str2 = eVar.forumId;
                    String str3 = eVar.forumName;
                    if (eVar.loQ == 4) {
                        FrsViewData bVu = d.this.hGQ.bVu();
                        bk threadDataById = bVu.getThreadDataById(str);
                        bVu.removeThreadData(threadDataById);
                        List<o> topThreadList = bVu.getTopThreadList();
                        if (topThreadList == null) {
                            topThreadList = new ArrayList<>();
                        }
                        topThreadList.add(0, threadDataById);
                        d.this.hnt.a(bVu.getThreadList(), bVu);
                        d.this.hnK.i(bVu);
                    }
                    if (TextUtils.equals(d.this.hGQ.getForumName(), str3)) {
                        com.baidu.tieba.tbadkCore.e.dcJ().aT(d.this.hGQ.getForumName(), false);
                    }
                }
            }
        };
        this.gKD = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.frs.mc.d.4
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String errorString;
                String errorString2;
                if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                    GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
                    if (StringUtils.isNull(getMyPostHttpResponseMessage.getErrorString())) {
                        errorString2 = d.this.hGQ.getResources().getString(R.string.neterror);
                    } else {
                        errorString2 = getMyPostHttpResponseMessage.getErrorString();
                    }
                    d.this.a(getMyPostHttpResponseMessage.getError(), errorString2, getMyPostHttpResponseMessage.getResponseData(), responsedMessage.getOrginalMessage().getExtra() instanceof RequestGetMyPostNetMessage ? ((RequestGetMyPostNetMessage) responsedMessage.getOrginalMessage().getExtra()).getProZone() : 0);
                } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                    GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                    if (StringUtils.isNull(getMyPostSocketResponseMessage.getErrorString())) {
                        errorString = d.this.hGQ.getResources().getString(R.string.neterror);
                    } else {
                        errorString = getMyPostSocketResponseMessage.getErrorString();
                    }
                    d.this.a(getMyPostSocketResponseMessage.getError(), errorString, getMyPostSocketResponseMessage.getResponseData(), responsedMessage.getOrginalMessage().getExtra() instanceof RequestGetMyPostNetMessage ? ((RequestGetMyPostNetMessage) responsedMessage.getOrginalMessage().getExtra()).getProZone() : 0);
                }
            }
        };
        this.gKD.getSocketMessageListener().setSelfListener(true);
        this.gKD.getHttpMessageListener().setSelfListener(true);
        this.huS.setSelfListener(false);
        this.hGQ.registerListener(this.huS);
        this.hGQ.registerListener(this.gKD);
        this.hGQ.registerListener(this.hHz);
        this.hGQ.registerListener(this.hHA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, GetMyPostResIdl getMyPostResIdl, int i2) {
        if (i != 0) {
            this.hGQ.showToast(str);
            return;
        }
        FrsViewData bVu = this.hGQ.bVu();
        if (bVu != null && bVu.getForum() != null && getMyPostResIdl != null && this.hnt != null && this.hnJ != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
            al alVar = new al();
            ThreadInfo.Builder builder = new ThreadInfo.Builder(getMyPostResIdl.data.thread_info);
            User.Builder builder2 = new User.Builder(builder.author);
            a(builder2, getMyPostResIdl.data.user_info);
            builder.author = builder2.build(true);
            builder.cheak_repeat = 1;
            builder.fname = bVu.getForum().getName();
            builder.fid = Long.valueOf(com.baidu.adp.lib.f.b.toLong(bVu.getForum().getId(), 0L));
            alVar.a(builder.build(true));
            if (i2 == 1) {
                FrsTabViewController.b ccw = this.hGQ.bUR().ccw();
                if (ccw != null && (ccw.fragment instanceof FrsCommonTabFragment)) {
                    ((FrsCommonTabFragment) ccw.fragment).ap(alVar);
                }
            } else if (alVar.getTabId() > 0) {
                FrsTabViewController.b vC = this.hGQ.bUR().vC(alVar.getTabId());
                if (vC != null && (vC.fragment instanceof FrsCommonTabFragment)) {
                    this.hIc.vD(alVar.getTabId());
                    ((FrsCommonTabFragment) vC.fragment).ap(alVar);
                }
            } else {
                int ccs = this.hGQ.bUR().ccs();
                FrsTabViewController.b vC2 = this.hGQ.bUR().vC(ccs);
                if (vC2 != null) {
                    this.hIc.vD(ccs);
                    if (vC2.fragment instanceof FrsNewAreaFragment) {
                        a(alVar, (FrsNewAreaFragment) vC2.fragment);
                    } else {
                        a(alVar);
                    }
                }
            }
        }
    }

    private void a(al alVar) {
        ArrayList<o> a;
        FrsViewData bVu = this.hGQ.bVu();
        if (bVu != null) {
            this.hnJ.addMyNewThread(alVar);
            if (this.hnJ.caI()) {
                ArrayList<o> arrayList = new ArrayList<>();
                arrayList.add(alVar);
                a = this.hIe.a(false, true, arrayList, null, true);
            } else {
                a = this.hIe.a(false, true, bVu.getThreadList(), null, true);
            }
            if (a != null) {
                bVu.setThreadList(a);
                bVu.checkLiveStageInThreadList();
                this.hnt.a(a, bVu);
                this.hnt.tX(0);
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
        if (this.hnJ != null) {
            boolean z = this.hnJ.bZZ() != null && this.hnJ.bZZ().getIsBrandForum();
            int caD = this.hnJ.caD();
            if (caD == 2 || caD == 3 || caD == 7 || caD == 8 || z) {
                if ((ab.bWN().uf(1) != null ? this.hnJ.caw() : 0) == 0 && postWriteCallBackData != null) {
                    final long j = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getPostId(), 0L);
                    final long j2 = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getThreadId(), 0L);
                    final long j3 = com.baidu.adp.lib.f.b.toLong(this.hGQ.getForumId(), 0L);
                    if (j != 0 && j2 != 0 && j3 != 0) {
                        com.baidu.adp.lib.f.e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.mc.d.5
                            @Override // java.lang.Runnable
                            public void run() {
                                int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
                                int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
                                float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                                int i = 1;
                                if (ar.aUX().aUY()) {
                                    i = 2;
                                }
                                RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                                requestGetMyPostNetMessage.setProZone(postWriteCallBackData.getProZone());
                                requestGetMyPostNetMessage.setParams(j2, j, j3, equipmentWidth, equipmentHeight, f, i);
                                d.this.hGQ.sendMessage(requestGetMyPostNetMessage);
                            }
                        }, 1000L);
                    }
                }
            }
        }
    }
}
