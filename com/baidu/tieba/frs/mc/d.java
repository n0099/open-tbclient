package com.baidu.tieba.frs.mc;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.m;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.am;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.vc.FrsTabViewController;
import com.baidu.tieba.frs.x;
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
/* loaded from: classes7.dex */
public class d extends j {
    private final com.baidu.adp.framework.listener.a fNB;
    private final CustomMessageListener gFp;
    private final CustomMessageListener gFq;
    private final CustomMessageListener gtG;

    public d(FrsFragment frsFragment) {
        super(frsFragment);
        this.gFp = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.frs.mc.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    d.this.e((PostWriteCallBackData) customResponsedMessage.getData());
                }
            }
        };
        this.gtG = new CustomMessageListener(CmdConfigCustom.PB_DELETE_THREAD) { // from class: com.baidu.tieba.frs.mc.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!StringUtils.isNull(str) && d.this.gEE.bCK() != null) {
                        FrsViewData bCK = d.this.gEE.bCK();
                        bCK.removeThread(str);
                        d.this.gmj.a(bCK.getThreadList(), bCK);
                        if (com.baidu.tieba.tbadkCore.d.cIv() != null) {
                            com.baidu.tieba.tbadkCore.d.cIv().aA(d.this.gEE.getForumName(), false);
                        }
                    }
                }
            }
        };
        this.gFq = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_MANAGE) { // from class: com.baidu.tieba.frs.mc.d.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v19, types: [java.util.List] */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ForumManageModel.e eVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ForumManageModel.e) && d.this.gEE != null && d.this.gmj != null && d.this.gmA != null && (eVar = (ForumManageModel.e) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(eVar.threadId) && d.this.gEE.bCK() != null) {
                    String str = eVar.threadId;
                    String str2 = eVar.forumId;
                    String str3 = eVar.forumName;
                    if (eVar.kig == 4) {
                        FrsViewData bCK = d.this.gEE.bCK();
                        bj threadDataById = bCK.getThreadDataById(str);
                        bCK.removeThreadData(threadDataById);
                        List<m> topThreadList = bCK.getTopThreadList();
                        if (topThreadList == null) {
                            topThreadList = new ArrayList<>();
                        }
                        topThreadList.add(0, threadDataById);
                        d.this.gmj.a(bCK.getThreadList(), bCK);
                        d.this.gmA.i(bCK);
                    }
                    if (TextUtils.equals(d.this.gEE.getForumName(), str3)) {
                        com.baidu.tieba.tbadkCore.d.cIv().aA(d.this.gEE.getForumName(), false);
                    }
                }
            }
        };
        this.fNB = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.frs.mc.d.4
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String errorString;
                String errorString2;
                if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                    GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
                    if (StringUtils.isNull(getMyPostHttpResponseMessage.getErrorString())) {
                        errorString2 = d.this.gEE.getResources().getString(R.string.neterror);
                    } else {
                        errorString2 = getMyPostHttpResponseMessage.getErrorString();
                    }
                    d.this.a(getMyPostHttpResponseMessage.getError(), errorString2, getMyPostHttpResponseMessage.getResponseData(), responsedMessage.getOrginalMessage().getExtra() instanceof RequestGetMyPostNetMessage ? ((RequestGetMyPostNetMessage) responsedMessage.getOrginalMessage().getExtra()).getProZone() : 0);
                } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                    GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                    if (StringUtils.isNull(getMyPostSocketResponseMessage.getErrorString())) {
                        errorString = d.this.gEE.getResources().getString(R.string.neterror);
                    } else {
                        errorString = getMyPostSocketResponseMessage.getErrorString();
                    }
                    d.this.a(getMyPostSocketResponseMessage.getError(), errorString, getMyPostSocketResponseMessage.getResponseData(), responsedMessage.getOrginalMessage().getExtra() instanceof RequestGetMyPostNetMessage ? ((RequestGetMyPostNetMessage) responsedMessage.getOrginalMessage().getExtra()).getProZone() : 0);
                }
            }
        };
        this.fNB.getSocketMessageListener().setSelfListener(true);
        this.fNB.getHttpMessageListener().setSelfListener(true);
        this.gtG.setSelfListener(false);
        this.gEE.registerListener(this.gtG);
        this.gEE.registerListener(this.fNB);
        this.gEE.registerListener(this.gFp);
        this.gEE.registerListener(this.gFq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, GetMyPostResIdl getMyPostResIdl, int i2) {
        ArrayList<m> a;
        if (i != 0) {
            this.gEE.showToast(str);
            return;
        }
        FrsViewData bCK = this.gEE.bCK();
        if (bCK != null && bCK.getForum() != null && getMyPostResIdl != null && this.gmj != null && this.gmz != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
            am amVar = new am();
            ThreadInfo.Builder builder = new ThreadInfo.Builder(getMyPostResIdl.data.thread_info);
            User.Builder builder2 = new User.Builder(builder.author);
            a(builder2, getMyPostResIdl.data.user_info);
            builder.author = builder2.build(true);
            builder.cheak_repeat = 1;
            builder.fname = bCK.getForum().getName();
            builder.fid = Long.valueOf(com.baidu.adp.lib.f.b.toLong(bCK.getForum().getId(), 0L));
            amVar.a(builder.build(true));
            if (i2 == 1) {
                FrsTabViewController.b bJv = this.gEE.bCi().bJv();
                if (bJv != null && (bJv.fragment instanceof FrsCommonTabFragment)) {
                    ((FrsCommonTabFragment) bJv.fragment).ak(amVar);
                    return;
                }
                return;
            }
            FrsTabViewController.b bJv2 = this.gEE.bCi().bJv();
            if (bJv2 != null && (bJv2.fragment instanceof FrsNewAreaFragment)) {
                ((FrsNewAreaFragment) bJv2.fragment).ak(amVar);
                return;
            }
            this.gmz.addMyNewThread(amVar);
            if (this.gmz.bHP()) {
                ArrayList<m> arrayList = new ArrayList<>();
                arrayList.add(amVar);
                a = this.gFV.a(false, true, arrayList, null, true);
            } else {
                a = this.gFV.a(false, true, bCK.getThreadList(), null, true);
            }
            if (a != null) {
                bCK.setThreadList(a);
                bCK.checkLiveStageInThreadList();
                this.gmj.a(a, bCK);
                this.gmj.sK(0);
            }
        }
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
        }
    }

    public void e(final PostWriteCallBackData postWriteCallBackData) {
        if (this.gmz != null) {
            boolean z = this.gmz.bHj() != null && this.gmz.bHj().getIsBrandForum();
            int bHL = this.gmz.bHL();
            if (bHL == 2 || bHL == 3 || bHL == 7 || bHL == 8 || z) {
                if ((x.bDY().sS(1) != null ? this.gmz.bHE() : 0) == 0 && postWriteCallBackData != null) {
                    final long j = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getPostId(), 0L);
                    final long j2 = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getThreadId(), 0L);
                    final long j3 = com.baidu.adp.lib.f.b.toLong(this.gEE.getForumId(), 0L);
                    if (j != 0 && j2 != 0 && j3 != 0) {
                        com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.mc.d.5
                            @Override // java.lang.Runnable
                            public void run() {
                                int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
                                int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
                                float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                                int i = 1;
                                if (ar.aEq().aEr()) {
                                    i = 2;
                                }
                                RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                                requestGetMyPostNetMessage.setProZone(postWriteCallBackData.getProZone());
                                requestGetMyPostNetMessage.setParams(j2, j, j3, equipmentWidth, equipmentHeight, f, i);
                                d.this.gEE.sendMessage(requestGetMyPostNetMessage);
                            }
                        }, 1000L);
                    }
                }
            }
        }
    }
}
