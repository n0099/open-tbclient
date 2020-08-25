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
/* loaded from: classes16.dex */
public class d extends j {
    private final com.baidu.adp.framework.listener.a hpZ;
    private final CustomMessageListener ibO;
    private final CustomMessageListener ioU;
    private final CustomMessageListener ioV;

    public d(FrsFragment frsFragment) {
        super(frsFragment);
        this.ioU = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.frs.mc.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && !((PostWriteCallBackData) customResponsedMessage.getData()).isDyamicCallback()) {
                    d.this.e((PostWriteCallBackData) customResponsedMessage.getData());
                }
            }
        };
        this.ibO = new CustomMessageListener(CmdConfigCustom.PB_DELETE_THREAD) { // from class: com.baidu.tieba.frs.mc.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!StringUtils.isNull(str) && d.this.iom.cmw() != null) {
                        FrsViewData cmw = d.this.iom.cmw();
                        cmw.removeThread(str);
                        d.this.hSP.a(cmw.getThreadList(), cmw);
                        if (com.baidu.tieba.tbadkCore.e.dvF() != null) {
                            com.baidu.tieba.tbadkCore.e.dvF().aW(d.this.iom.getForumName(), false);
                        }
                    }
                }
            }
        };
        this.ioV = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_MANAGE) { // from class: com.baidu.tieba.frs.mc.d.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v19, types: [java.util.List] */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ForumManageModel.e eVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ForumManageModel.e) && d.this.iom != null && d.this.hSP != null && d.this.hTj != null && (eVar = (ForumManageModel.e) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(eVar.threadId) && d.this.iom.cmw() != null) {
                    String str = eVar.threadId;
                    String str2 = eVar.forumId;
                    String str3 = eVar.forumName;
                    if (eVar.mhA == 4) {
                        FrsViewData cmw = d.this.iom.cmw();
                        bw threadDataById = cmw.getThreadDataById(str);
                        cmw.removeThreadData(threadDataById);
                        List<q> topThreadList = cmw.getTopThreadList();
                        if (topThreadList == null) {
                            topThreadList = new ArrayList<>();
                        }
                        topThreadList.add(0, threadDataById);
                        d.this.hSP.a(cmw.getThreadList(), cmw);
                        d.this.hTj.i(cmw);
                    }
                    if (TextUtils.equals(d.this.iom.getForumName(), str3)) {
                        com.baidu.tieba.tbadkCore.e.dvF().aW(d.this.iom.getForumName(), false);
                    }
                }
            }
        };
        this.hpZ = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.frs.mc.d.4
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String errorString;
                String errorString2;
                if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                    GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
                    if (StringUtils.isNull(getMyPostHttpResponseMessage.getErrorString())) {
                        errorString2 = d.this.iom.getResources().getString(R.string.neterror);
                    } else {
                        errorString2 = getMyPostHttpResponseMessage.getErrorString();
                    }
                    d.this.a(getMyPostHttpResponseMessage.getError(), errorString2, getMyPostHttpResponseMessage.getResponseData(), responsedMessage.getOrginalMessage().getExtra() instanceof RequestGetMyPostNetMessage ? ((RequestGetMyPostNetMessage) responsedMessage.getOrginalMessage().getExtra()).getProZone() : 0);
                } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                    GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                    if (StringUtils.isNull(getMyPostSocketResponseMessage.getErrorString())) {
                        errorString = d.this.iom.getResources().getString(R.string.neterror);
                    } else {
                        errorString = getMyPostSocketResponseMessage.getErrorString();
                    }
                    d.this.a(getMyPostSocketResponseMessage.getError(), errorString, getMyPostSocketResponseMessage.getResponseData(), responsedMessage.getOrginalMessage().getExtra() instanceof RequestGetMyPostNetMessage ? ((RequestGetMyPostNetMessage) responsedMessage.getOrginalMessage().getExtra()).getProZone() : 0);
                }
            }
        };
        this.hpZ.getSocketMessageListener().setSelfListener(true);
        this.hpZ.getHttpMessageListener().setSelfListener(true);
        this.ibO.setSelfListener(false);
        this.iom.registerListener(this.ibO);
        this.iom.registerListener(this.hpZ);
        this.iom.registerListener(this.ioU);
        this.iom.registerListener(this.ioV);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, GetMyPostResIdl getMyPostResIdl, int i2) {
        if (i != 0) {
            this.iom.showToast(str);
            return;
        }
        FrsViewData cmw = this.iom.cmw();
        if (cmw != null && cmw.getForum() != null && getMyPostResIdl != null && this.hSP != null && this.hTi != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
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
            builder.fname = cmw.getForum().getName();
            builder.fid = Long.valueOf(com.baidu.adp.lib.f.b.toLong(cmw.getForum().getId(), 0L));
            asVar.a(builder.build(true));
            if (i2 == 1) {
                FrsTabViewController.b ctT = this.iom.clQ().ctT();
                if (ctT != null && (ctT.fragment instanceof FrsCommonTabFragment)) {
                    ((FrsCommonTabFragment) ctT.fragment).am(asVar);
                }
            } else if (i2 == 2) {
                FrsTabViewController.b yT = this.iom.clQ().yT(301);
                if (yT != null && (yT.fragment instanceof FrsGoodFragment)) {
                    this.ipw.yU(301);
                    ((FrsGoodFragment) yT.fragment).a(asVar);
                }
            } else if (asVar.getTabId() > 0) {
                FrsTabViewController.b yT2 = this.iom.clQ().yT(asVar.getTabId());
                if (yT2 != null && (yT2.fragment instanceof FrsCommonTabFragment)) {
                    this.ipw.yU(asVar.getTabId());
                    ((FrsCommonTabFragment) yT2.fragment).am(asVar);
                }
            } else {
                if (!y.isEmpty(asVar.bgI())) {
                    asVar.beg();
                    int ctP = this.iom.clQ().ctP();
                    FrsTabViewController.b yT3 = this.iom.clQ().yT(ctP);
                    if (yT3 != null && (yT3.fragment instanceof FrsCommonTabFragment)) {
                        this.ipw.yU(ctP);
                        ((FrsCommonTabFragment) yT3.fragment).am(asVar);
                        return;
                    }
                }
                int ctO = this.iom.clQ().ctO();
                FrsTabViewController.b yT4 = this.iom.clQ().yT(ctO);
                if (yT4 != null) {
                    this.ipw.yU(ctO);
                    if (yT4.fragment instanceof FrsNewAreaFragment) {
                        a(asVar, (FrsNewAreaFragment) yT4.fragment);
                    } else {
                        b(asVar);
                    }
                }
            }
        }
    }

    private void b(as asVar) {
        ArrayList<q> a;
        FrsViewData cmw = this.iom.cmw();
        if (cmw != null) {
            this.hTi.addMyNewThread(asVar);
            if (this.hTi.csb()) {
                ArrayList<q> arrayList = new ArrayList<>();
                arrayList.add(asVar);
                a = this.ipy.a(false, true, arrayList, null, true);
            } else {
                a = this.ipy.a(false, true, cmw.getThreadList(), null, true);
            }
            if (a != null) {
                cmw.setThreadList(a);
                cmw.checkLiveStageInThreadList();
                this.hSP.a(a, cmw);
                this.hSP.xj(0);
            }
        }
    }

    private void a(bw bwVar, FrsNewAreaFragment frsNewAreaFragment) {
        frsNewAreaFragment.am(bwVar);
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
        if (this.hTi != null) {
            boolean z = this.hTi.crs() != null && this.hTi.crs().getIsBrandForum();
            int crW = this.hTi.crW();
            if (crW == 2 || crW == 3 || crW == 7 || crW == 8 || z) {
                if ((ag.cnU().xt(1) != null ? this.hTi.crP() : 0) == 0 && postWriteCallBackData != null) {
                    final long j = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getPostId(), 0L);
                    final long j2 = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getThreadId(), 0L);
                    final long j3 = com.baidu.adp.lib.f.b.toLong(this.iom.getForumId(), 0L);
                    if (j != 0 && j2 != 0 && j3 != 0) {
                        com.baidu.adp.lib.f.e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.mc.d.5
                            @Override // java.lang.Runnable
                            public void run() {
                                int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
                                int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
                                float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                                int i = 1;
                                if (au.bjr().bjs()) {
                                    i = 2;
                                }
                                RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                                requestGetMyPostNetMessage.setProZone(postWriteCallBackData.getProZone());
                                requestGetMyPostNetMessage.setParams(j2, j, j3, equipmentWidth, equipmentHeight, f, i);
                                d.this.iom.sendMessage(requestGetMyPostNetMessage);
                            }
                        }, 1000L);
                    }
                }
            }
        }
    }
}
