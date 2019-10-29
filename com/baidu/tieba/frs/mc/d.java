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
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.vc.FrsTabViewController;
import com.baidu.tieba.frs.w;
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
/* loaded from: classes4.dex */
public class d extends j {
    private final com.baidu.adp.framework.listener.a eWA;
    private final CustomMessageListener fDd;
    private final CustomMessageListener fOE;
    private final CustomMessageListener fOF;

    public d(FrsFragment frsFragment) {
        super(frsFragment);
        this.fOE = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.frs.mc.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    d.this.e((PostWriteCallBackData) customResponsedMessage.getData());
                }
            }
        };
        this.fDd = new CustomMessageListener(CmdConfigCustom.PB_DELETE_THREAD) { // from class: com.baidu.tieba.frs.mc.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!StringUtils.isNull(str) && d.this.fNY.bkp() != null) {
                        FrsViewData bkp = d.this.fNY.bkp();
                        bkp.removeThread(str);
                        d.this.fvo.a(bkp.getThreadList(), bkp);
                        if (com.baidu.tieba.tbadkCore.d.cnl() != null) {
                            com.baidu.tieba.tbadkCore.d.cnl().av(d.this.fNY.getForumName(), false);
                        }
                    }
                }
            }
        };
        this.fOF = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_MANAGE) { // from class: com.baidu.tieba.frs.mc.d.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v19, types: [java.util.List] */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ForumManageModel.e eVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ForumManageModel.e) && d.this.fNY != null && d.this.fvo != null && d.this.fvG != null && (eVar = (ForumManageModel.e) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(eVar.threadId) && d.this.fNY.bkp() != null) {
                    String str = eVar.threadId;
                    String str2 = eVar.forumId;
                    String str3 = eVar.forumName;
                    if (eVar.jkY == 4) {
                        FrsViewData bkp = d.this.fNY.bkp();
                        bh threadDataById = bkp.getThreadDataById(str);
                        bkp.removeThreadData(threadDataById);
                        List<m> topThreadList = bkp.getTopThreadList();
                        if (topThreadList == null) {
                            topThreadList = new ArrayList<>();
                        }
                        topThreadList.add(0, threadDataById);
                        d.this.fvo.a(bkp.getThreadList(), bkp);
                        d.this.fvG.i(bkp);
                    }
                    if (TextUtils.equals(d.this.fNY.getForumName(), str3)) {
                        com.baidu.tieba.tbadkCore.d.cnl().av(d.this.fNY.getForumName(), false);
                    }
                }
            }
        };
        this.eWA = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.frs.mc.d.4
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String errorString;
                String errorString2;
                if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                    GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
                    if (StringUtils.isNull(getMyPostHttpResponseMessage.getErrorString())) {
                        errorString2 = d.this.fNY.getResources().getString(R.string.neterror);
                    } else {
                        errorString2 = getMyPostHttpResponseMessage.getErrorString();
                    }
                    d.this.a(getMyPostHttpResponseMessage.getError(), errorString2, getMyPostHttpResponseMessage.getResponseData(), responsedMessage.getOrginalMessage().getExtra() instanceof RequestGetMyPostNetMessage ? ((RequestGetMyPostNetMessage) responsedMessage.getOrginalMessage().getExtra()).getProZone() : 0);
                } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                    GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                    if (StringUtils.isNull(getMyPostSocketResponseMessage.getErrorString())) {
                        errorString = d.this.fNY.getResources().getString(R.string.neterror);
                    } else {
                        errorString = getMyPostSocketResponseMessage.getErrorString();
                    }
                    d.this.a(getMyPostSocketResponseMessage.getError(), errorString, getMyPostSocketResponseMessage.getResponseData(), responsedMessage.getOrginalMessage().getExtra() instanceof RequestGetMyPostNetMessage ? ((RequestGetMyPostNetMessage) responsedMessage.getOrginalMessage().getExtra()).getProZone() : 0);
                }
            }
        };
        this.eWA.getSocketMessageListener().setSelfListener(true);
        this.eWA.getHttpMessageListener().setSelfListener(true);
        this.fDd.setSelfListener(false);
        this.fNY.registerListener(this.fDd);
        this.fNY.registerListener(this.eWA);
        this.fNY.registerListener(this.fOE);
        this.fNY.registerListener(this.fOF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, GetMyPostResIdl getMyPostResIdl, int i2) {
        ArrayList<m> a;
        if (i != 0) {
            this.fNY.showToast(str);
            return;
        }
        FrsViewData bkp = this.fNY.bkp();
        if (bkp != null && bkp.getForum() != null && getMyPostResIdl != null && this.fvo != null && this.fvF != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
            ak akVar = new ak();
            ThreadInfo.Builder builder = new ThreadInfo.Builder(getMyPostResIdl.data.thread_info);
            User.Builder builder2 = new User.Builder(builder.author);
            a(builder2, getMyPostResIdl.data.user_info);
            builder.author = builder2.build(true);
            builder.cheak_repeat = 1;
            builder.fname = bkp.getForum().getName();
            builder.fid = Long.valueOf(com.baidu.adp.lib.g.b.toLong(bkp.getForum().getId(), 0L));
            akVar.a(builder.build(true));
            akVar.setCurrentPage(3);
            if (i2 == 1) {
                FrsTabViewController.b bqU = this.fNY.bjN().bqU();
                if (bqU != null && (bqU.fragment instanceof FrsCommonTabFragment)) {
                    ((FrsCommonTabFragment) bqU.fragment).ac(akVar);
                    return;
                }
                return;
            }
            FrsTabViewController.b bqU2 = this.fNY.bjN().bqU();
            if (bqU2 != null && (bqU2.fragment instanceof FrsNewAreaFragment)) {
                ((FrsNewAreaFragment) bqU2.fragment).ac(akVar);
                return;
            }
            this.fvF.addMyNewThread(akVar);
            if (this.fvF.bpt()) {
                ArrayList<m> arrayList = new ArrayList<>();
                arrayList.add(akVar);
                a = this.fPk.a(false, true, arrayList, null, true);
            } else {
                a = this.fPk.a(false, true, bkp.getThreadList(), null, true);
            }
            if (a != null) {
                bkp.setThreadList(a);
                bkp.checkLiveStageInThreadList();
                this.fvo.a(a, bkp);
                this.fvo.qA(0);
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
        if (this.fvF != null) {
            boolean z = this.fvF.boM() != null && this.fvF.boM().getIsBrandForum();
            int bpp = this.fvF.bpp();
            if (bpp == 2 || bpp == 3 || bpp == 7 || bpp == 8 || z) {
                if ((w.blC().qI(1) != null ? this.fvF.bpi() : 0) == 0 && postWriteCallBackData != null) {
                    final long j = com.baidu.adp.lib.g.b.toLong(postWriteCallBackData.getPostId(), 0L);
                    final long j2 = com.baidu.adp.lib.g.b.toLong(postWriteCallBackData.getThreadId(), 0L);
                    final long j3 = com.baidu.adp.lib.g.b.toLong(this.fNY.getForumId(), 0L);
                    if (j != 0 && j2 != 0 && j3 != 0) {
                        com.baidu.adp.lib.g.e.fZ().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.mc.d.5
                            @Override // java.lang.Runnable
                            public void run() {
                                int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
                                int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
                                float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                                int i = 1;
                                if (ar.amO().isFrsShowBigImage()) {
                                    i = 2;
                                }
                                RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                                requestGetMyPostNetMessage.setProZone(postWriteCallBackData.getProZone());
                                requestGetMyPostNetMessage.setParams(j2, j, j3, equipmentWidth, equipmentHeight, f, i);
                                d.this.fNY.sendMessage(requestGetMyPostNetMessage);
                            }
                        }, 1000L);
                    }
                }
            }
        }
    }
}
