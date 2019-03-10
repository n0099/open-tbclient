package com.baidu.tieba.frs.mc;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.d;
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
    private final com.baidu.adp.framework.listener.a esj;
    private final CustomMessageListener fgp;
    private final CustomMessageListener frA;
    private final CustomMessageListener frB;

    public d(FrsFragment frsFragment) {
        super(frsFragment);
        this.frA = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.frs.mc.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    d.this.e((PostWriteCallBackData) customResponsedMessage.getData());
                }
            }
        };
        this.fgp = new CustomMessageListener(2921031) { // from class: com.baidu.tieba.frs.mc.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!StringUtils.isNull(str) && d.this.fqT.bcS() != null) {
                        FrsViewData bcS = d.this.fqT.bcS();
                        bcS.removeThread(str);
                        d.this.eYT.a(bcS.getThreadList(), bcS);
                        if (com.baidu.tieba.tbadkCore.d.cds() != null) {
                            com.baidu.tieba.tbadkCore.d.cds().au(d.this.fqT.getForumName(), false);
                        }
                    }
                }
            }
        };
        this.frB = new CustomMessageListener(2921316) { // from class: com.baidu.tieba.frs.mc.d.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v19, types: [java.util.List] */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ForumManageModel.e eVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ForumManageModel.e) && d.this.fqT != null && d.this.eYT != null && d.this.eZl != null && (eVar = (ForumManageModel.e) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(eVar.threadId) && d.this.fqT.bcS() != null) {
                    String str = eVar.threadId;
                    String str2 = eVar.forumId;
                    String str3 = eVar.forumName;
                    if (eVar.iIL == 4) {
                        FrsViewData bcS = d.this.fqT.bcS();
                        bg threadDataById = bcS.getThreadDataById(str);
                        bcS.removeThreadData(threadDataById);
                        List<m> topThreadList = bcS.getTopThreadList();
                        if (topThreadList == null) {
                            topThreadList = new ArrayList<>();
                        }
                        topThreadList.add(0, threadDataById);
                        d.this.eYT.a(bcS.getThreadList(), bcS);
                        d.this.eZl.h(bcS);
                    }
                    if (TextUtils.equals(d.this.fqT.getForumName(), str3)) {
                        com.baidu.tieba.tbadkCore.d.cds().au(d.this.fqT.getForumName(), false);
                    }
                }
            }
        };
        this.esj = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_MY_POST, 303111) { // from class: com.baidu.tieba.frs.mc.d.4
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String errorString;
                String errorString2;
                if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                    GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
                    if (StringUtils.isNull(getMyPostHttpResponseMessage.getErrorString())) {
                        errorString2 = d.this.fqT.getResources().getString(d.j.neterror);
                    } else {
                        errorString2 = getMyPostHttpResponseMessage.getErrorString();
                    }
                    d.this.a(getMyPostHttpResponseMessage.getError(), errorString2, getMyPostHttpResponseMessage.getResponseData(), responsedMessage.getOrginalMessage().getExtra() instanceof RequestGetMyPostNetMessage ? ((RequestGetMyPostNetMessage) responsedMessage.getOrginalMessage().getExtra()).getProZone() : 0);
                } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                    GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                    if (StringUtils.isNull(getMyPostSocketResponseMessage.getErrorString())) {
                        errorString = d.this.fqT.getResources().getString(d.j.neterror);
                    } else {
                        errorString = getMyPostSocketResponseMessage.getErrorString();
                    }
                    d.this.a(getMyPostSocketResponseMessage.getError(), errorString, getMyPostSocketResponseMessage.getResponseData(), responsedMessage.getOrginalMessage().getExtra() instanceof RequestGetMyPostNetMessage ? ((RequestGetMyPostNetMessage) responsedMessage.getOrginalMessage().getExtra()).getProZone() : 0);
                }
            }
        };
        this.esj.getSocketMessageListener().setSelfListener(true);
        this.esj.getHttpMessageListener().setSelfListener(true);
        this.fgp.setSelfListener(false);
        this.fqT.registerListener(this.fgp);
        this.fqT.registerListener(this.esj);
        this.fqT.registerListener(this.frA);
        this.fqT.registerListener(this.frB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, GetMyPostResIdl getMyPostResIdl, int i2) {
        ArrayList<m> a;
        if (i != 0) {
            this.fqT.showToast(str);
            return;
        }
        FrsViewData bcS = this.fqT.bcS();
        if (bcS != null && bcS.getForum() != null && getMyPostResIdl != null && this.eYT != null && this.eZk != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
            ak akVar = new ak();
            ThreadInfo.Builder builder = new ThreadInfo.Builder(getMyPostResIdl.data.thread_info);
            User.Builder builder2 = new User.Builder(builder.author);
            a(builder2, getMyPostResIdl.data.user_info);
            builder.author = builder2.build(true);
            builder.cheak_repeat = 1;
            builder.fname = bcS.getForum().getName();
            builder.fid = Long.valueOf(com.baidu.adp.lib.g.b.d(bcS.getForum().getId(), 0L));
            akVar.a(builder.build(true));
            akVar.setCurrentPage(3);
            if (i2 == 1) {
                FrsTabViewController.b bjv = this.fqT.bct().bjv();
                if (bjv != null && (bjv.fragment instanceof FrsCommonTabFragment)) {
                    ((FrsCommonTabFragment) bjv.fragment).ad(akVar);
                    return;
                }
                return;
            }
            FrsTabViewController.b bjv2 = this.fqT.bct().bjv();
            if (bjv2 != null && (bjv2.fragment instanceof FrsNewAreaFragment)) {
                ((FrsNewAreaFragment) bjv2.fragment).ad(akVar);
                return;
            }
            this.eZk.addMyNewThread(akVar);
            if (this.eZk.bhU()) {
                ArrayList<m> arrayList = new ArrayList<>();
                arrayList.add(akVar);
                a = this.fsf.a(false, true, arrayList, null, true);
            } else {
                a = this.fsf.a(false, true, bcS.getThreadList(), null, true);
            }
            if (a != null) {
                bcS.setThreadList(a);
                bcS.updateInterviewTaskInfoDataInThreadList();
                this.eYT.a(a, bcS);
                this.eYT.qh(0);
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
        if (this.eZk != null) {
            boolean z = this.eZk.bhp() != null && this.eZk.bhp().getIsBrandForum();
            int bhQ = this.eZk.bhQ();
            if (bhQ == 2 || bhQ == 3 || bhQ == 7 || bhQ == 8 || z) {
                if ((w.bek().qp(1) != null ? this.eZk.bhJ() : 0) == 0 && postWriteCallBackData != null) {
                    final long d = com.baidu.adp.lib.g.b.d(postWriteCallBackData.getPostId(), 0L);
                    final long d2 = com.baidu.adp.lib.g.b.d(postWriteCallBackData.getThreadId(), 0L);
                    final long d3 = com.baidu.adp.lib.g.b.d(this.fqT.getForumId(), 0L);
                    if (d != 0 && d2 != 0 && d3 != 0) {
                        com.baidu.adp.lib.g.e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.mc.d.5
                            @Override // java.lang.Runnable
                            public void run() {
                                int aO = com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst());
                                int aQ = com.baidu.adp.lib.util.l.aQ(TbadkCoreApplication.getInst());
                                float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                                int i = 1;
                                if (ar.adp().adr()) {
                                    i = 2;
                                }
                                RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                                requestGetMyPostNetMessage.setProZone(postWriteCallBackData.getProZone());
                                requestGetMyPostNetMessage.setParams(d2, d, d3, aO, aQ, f, i);
                                d.this.fqT.sendMessage(requestGetMyPostNetMessage);
                            }
                        }, 1000L);
                    }
                }
            }
        }
    }
}
