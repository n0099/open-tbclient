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
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.ae;
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
    private final CustomMessageListener hNJ;
    private final com.baidu.adp.framework.listener.a hdf;
    private final CustomMessageListener iaM;
    private final CustomMessageListener iaN;

    public d(FrsFragment frsFragment) {
        super(frsFragment);
        this.iaM = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.frs.mc.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && !((PostWriteCallBackData) customResponsedMessage.getData()).isDyamicCallback()) {
                    d.this.e((PostWriteCallBackData) customResponsedMessage.getData());
                }
            }
        };
        this.hNJ = new CustomMessageListener(CmdConfigCustom.PB_DELETE_THREAD) { // from class: com.baidu.tieba.frs.mc.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!StringUtils.isNull(str) && d.this.iae.cbZ() != null) {
                        FrsViewData cbZ = d.this.iae.cbZ();
                        cbZ.removeThread(str);
                        d.this.hFz.a(cbZ.getThreadList(), cbZ);
                        if (com.baidu.tieba.tbadkCore.e.dki() != null) {
                            com.baidu.tieba.tbadkCore.e.dki().aS(d.this.iae.getForumName(), false);
                        }
                    }
                }
            }
        };
        this.iaN = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_MANAGE) { // from class: com.baidu.tieba.frs.mc.d.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v19, types: [java.util.List] */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ForumManageModel.e eVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ForumManageModel.e) && d.this.iae != null && d.this.hFz != null && d.this.hFT != null && (eVar = (ForumManageModel.e) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(eVar.threadId) && d.this.iae.cbZ() != null) {
                    String str = eVar.threadId;
                    String str2 = eVar.forumId;
                    String str3 = eVar.forumName;
                    if (eVar.lPR == 4) {
                        FrsViewData cbZ = d.this.iae.cbZ();
                        bv threadDataById = cbZ.getThreadDataById(str);
                        cbZ.removeThreadData(threadDataById);
                        List<q> topThreadList = cbZ.getTopThreadList();
                        if (topThreadList == null) {
                            topThreadList = new ArrayList<>();
                        }
                        topThreadList.add(0, threadDataById);
                        d.this.hFz.a(cbZ.getThreadList(), cbZ);
                        d.this.hFT.i(cbZ);
                    }
                    if (TextUtils.equals(d.this.iae.getForumName(), str3)) {
                        com.baidu.tieba.tbadkCore.e.dki().aS(d.this.iae.getForumName(), false);
                    }
                }
            }
        };
        this.hdf = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.frs.mc.d.4
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String errorString;
                String errorString2;
                if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                    GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
                    if (StringUtils.isNull(getMyPostHttpResponseMessage.getErrorString())) {
                        errorString2 = d.this.iae.getResources().getString(R.string.neterror);
                    } else {
                        errorString2 = getMyPostHttpResponseMessage.getErrorString();
                    }
                    d.this.a(getMyPostHttpResponseMessage.getError(), errorString2, getMyPostHttpResponseMessage.getResponseData(), responsedMessage.getOrginalMessage().getExtra() instanceof RequestGetMyPostNetMessage ? ((RequestGetMyPostNetMessage) responsedMessage.getOrginalMessage().getExtra()).getProZone() : 0);
                } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                    GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                    if (StringUtils.isNull(getMyPostSocketResponseMessage.getErrorString())) {
                        errorString = d.this.iae.getResources().getString(R.string.neterror);
                    } else {
                        errorString = getMyPostSocketResponseMessage.getErrorString();
                    }
                    d.this.a(getMyPostSocketResponseMessage.getError(), errorString, getMyPostSocketResponseMessage.getResponseData(), responsedMessage.getOrginalMessage().getExtra() instanceof RequestGetMyPostNetMessage ? ((RequestGetMyPostNetMessage) responsedMessage.getOrginalMessage().getExtra()).getProZone() : 0);
                }
            }
        };
        this.hdf.getSocketMessageListener().setSelfListener(true);
        this.hdf.getHttpMessageListener().setSelfListener(true);
        this.hNJ.setSelfListener(false);
        this.iae.registerListener(this.hNJ);
        this.iae.registerListener(this.hdf);
        this.iae.registerListener(this.iaM);
        this.iae.registerListener(this.iaN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, GetMyPostResIdl getMyPostResIdl, int i2) {
        if (i != 0) {
            this.iae.showToast(str);
            return;
        }
        FrsViewData cbZ = this.iae.cbZ();
        if (cbZ != null && cbZ.getForum() != null && getMyPostResIdl != null && this.hFz != null && this.hFS != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
            ar arVar = new ar();
            ThreadInfo.Builder builder = new ThreadInfo.Builder(getMyPostResIdl.data.thread_info);
            User.Builder builder2 = new User.Builder(builder.author);
            a(builder2, getMyPostResIdl.data.user_info);
            builder.author = builder2.build(true);
            builder.cheak_repeat = 1;
            builder.fname = cbZ.getForum().getName();
            builder.fid = Long.valueOf(com.baidu.adp.lib.f.b.toLong(cbZ.getForum().getId(), 0L));
            arVar.a(builder.build(true));
            if (i2 == 1) {
                FrsTabViewController.b cjp = this.iae.cbu().cjp();
                if (cjp != null && (cjp.fragment instanceof FrsCommonTabFragment)) {
                    ((FrsCommonTabFragment) cjp.fragment).am(arVar);
                }
            } else if (i2 == 2) {
                FrsTabViewController.b wz = this.iae.cbu().wz(301);
                if (wz != null && (wz.fragment instanceof FrsGoodFragment)) {
                    this.ibp.wA(301);
                    ((FrsGoodFragment) wz.fragment).a(arVar);
                }
            } else if (arVar.getTabId() > 0) {
                FrsTabViewController.b wz2 = this.iae.cbu().wz(arVar.getTabId());
                if (wz2 != null && (wz2.fragment instanceof FrsCommonTabFragment)) {
                    this.ibp.wA(arVar.getTabId());
                    ((FrsCommonTabFragment) wz2.fragment).am(arVar);
                }
            } else {
                if (!x.isEmpty(arVar.aYp())) {
                    arVar.aVN();
                    int cjl = this.iae.cbu().cjl();
                    FrsTabViewController.b wz3 = this.iae.cbu().wz(cjl);
                    if (wz3 != null && (wz3.fragment instanceof FrsCommonTabFragment)) {
                        this.ibp.wA(cjl);
                        ((FrsCommonTabFragment) wz3.fragment).am(arVar);
                        return;
                    }
                }
                int cjk = this.iae.cbu().cjk();
                FrsTabViewController.b wz4 = this.iae.cbu().wz(cjk);
                if (wz4 != null) {
                    this.ibp.wA(cjk);
                    if (wz4.fragment instanceof FrsNewAreaFragment) {
                        a(arVar, (FrsNewAreaFragment) wz4.fragment);
                    } else {
                        b(arVar);
                    }
                }
            }
        }
    }

    private void b(ar arVar) {
        ArrayList<q> a;
        FrsViewData cbZ = this.iae.cbZ();
        if (cbZ != null) {
            this.hFS.addMyNewThread(arVar);
            if (this.hFS.chw()) {
                ArrayList<q> arrayList = new ArrayList<>();
                arrayList.add(arVar);
                a = this.ibr.a(false, true, arrayList, null, true);
            } else {
                a = this.ibr.a(false, true, cbZ.getThreadList(), null, true);
            }
            if (a != null) {
                cbZ.setThreadList(a);
                cbZ.checkLiveStageInThreadList();
                this.hFz.a(a, cbZ);
                this.hFz.uU(0);
            }
        }
    }

    private void a(bv bvVar, FrsNewAreaFragment frsNewAreaFragment) {
        frsNewAreaFragment.am(bvVar);
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
        if (this.hFS != null) {
            boolean z = this.hFS.cgN() != null && this.hFS.cgN().getIsBrandForum();
            int chr = this.hFS.chr();
            if (chr == 2 || chr == 3 || chr == 7 || chr == 8 || z) {
                if ((ae.cdv().vc(1) != null ? this.hFS.chk() : 0) == 0 && postWriteCallBackData != null) {
                    final long j = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getPostId(), 0L);
                    final long j2 = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getThreadId(), 0L);
                    final long j3 = com.baidu.adp.lib.f.b.toLong(this.iae.getForumId(), 0L);
                    if (j != 0 && j2 != 0 && j3 != 0) {
                        com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.mc.d.5
                            @Override // java.lang.Runnable
                            public void run() {
                                int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
                                int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
                                float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                                int i = 1;
                                if (at.baS().baT()) {
                                    i = 2;
                                }
                                RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                                requestGetMyPostNetMessage.setProZone(postWriteCallBackData.getProZone());
                                requestGetMyPostNetMessage.setParams(j2, j, j3, equipmentWidth, equipmentHeight, f, i);
                                d.this.iae.sendMessage(requestGetMyPostNetMessage);
                            }
                        }, 1000L);
                    }
                }
            }
        }
    }
}
