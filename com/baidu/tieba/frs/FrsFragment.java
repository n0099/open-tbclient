package com.baidu.tieba.frs;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.card.a.a;
import com.baidu.e.a.a;
import com.baidu.tbadk.BdToken.f;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CreateBarGuideActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.core.atomData.MessageCenterActivityConfig;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.PrivateForumPopInfoData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.coreExtra.messageCenter.NewsRemindMessage;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tbadk.widget.FRSRefreshButton;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.d;
import com.baidu.tieba.R;
import com.baidu.tieba.deletethread.DeleteThreadHttpResponseMessage;
import com.baidu.tieba.frs.a;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.frs.mc.FrsNewAreaFragment;
import com.baidu.tieba.frs.vc.FrsTabViewController;
import com.baidu.tieba.frs.view.FrsHeaderViewContainer;
import com.baidu.tieba.pb.data.ContriInfo;
import com.baidu.tieba.pb.data.PbFloorAgreeResponseMessage;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.e;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsPage.RecmForumInfo;
import tbclient.WindowToast;
/* loaded from: classes4.dex */
public class FrsFragment extends BaseFragment implements BdListView.e, a.InterfaceC0041a, UserIconBox.b<BdRecyclerView>, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, ae, ah, aj, com.baidu.tieba.frs.loadmore.a, com.baidu.tieba.frs.mc.l, com.baidu.tieba.recapp.n {
    public static com.baidu.tieba.tbadkCore.j foU;
    private com.baidu.tbadk.util.w cBS;
    private com.baidu.adp.lib.e.b<TbImageView> cbP;
    private com.baidu.tieba.frs.gametab.b dyX;
    private com.baidu.tbadk.core.dialog.a ezQ;
    private com.baidu.tieba.frs.entelechy.a foC;
    private com.baidu.tieba.tbadkCore.data.f foM;
    private VoiceManager foP;
    private OvalActionButton foR;
    private FRSRefreshButton foS;
    private com.baidu.tieba.frs.mc.e fpA;
    private View.OnTouchListener fpB;
    private com.baidu.tieba.frs.view.a fpC;
    private com.baidu.tieba.frs.view.c fpD;
    private com.baidu.tieba.frs.vc.e fpE;
    private boolean fpF;
    private com.baidu.tieba.NEGFeedBack.a fpH;
    private com.baidu.tieba.ala.a fpI;
    private com.baidu.tieba.frs.brand.buttommenu.a fpJ;
    private com.baidu.tieba.frs.sportspage.notification.a fpK;
    private AddExperiencedModel fpL;
    private boolean fpN;
    private int fpY;
    private com.baidu.card.z fpg;
    private FrsModelController fph;
    private com.baidu.tieba.frs.vc.f fpi;
    private FrsTabViewController fpj;
    private com.baidu.tieba.frs.mc.h fpk;
    private com.baidu.tieba.frs.smartsort.a fpl;
    private com.baidu.tieba.frs.mc.b fpm;
    private ak fpn;
    private com.baidu.tieba.frs.entelechy.b.b fpp;
    private com.baidu.tbadk.k.a fpq;
    private com.baidu.tieba.frs.vc.a fpr;
    private com.baidu.tieba.frs.mc.d fpt;
    private com.baidu.tieba.frs.mc.c fpu;
    private com.baidu.tieba.frs.vc.h fpv;
    private com.baidu.tieba.frs.mc.a fpw;
    private com.baidu.tieba.frs.live.a fpx;
    private j fpy;
    public com.baidu.tieba.frs.vc.c fpz;
    private View mRootView;
    public static boolean foH = false;
    public static volatile long foW = 0;
    public static volatile long foX = 0;
    public static volatile int foY = 0;
    public boolean foD = false;
    private boolean foE = false;
    private boolean foF = false;
    private boolean foG = true;
    public String foI = null;
    public String mFrom = null;
    public int mFlag = 0;
    public boolean foJ = false;
    private boolean foK = false;
    private String mThreadId = null;
    public String forumId = null;
    private int fov = 0;
    private boolean foL = false;
    private boolean foN = false;
    private boolean foO = false;
    private k foQ = null;
    private boolean foT = false;
    public final bg cbg = null;
    private FrsViewData fot = new FrsViewData();
    public long eSm = -1;
    public long cyE = 0;
    public long cyw = 0;
    public long createTime = 0;
    public long beginTime = -1;
    public long foV = 0;
    public boolean foZ = false;
    private boolean fpa = false;
    private boolean fpb = false;
    public com.baidu.tbadk.p.b fpc = null;
    private boolean fpd = true;
    private boolean fpe = true;
    private a.C0038a fpf = new a.C0038a(2);
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> fpo = new SparseArray<>();
    private boolean dnK = true;
    private boolean fpG = false;
    private boolean hasInit = false;
    private boolean fpM = false;
    private boolean fpO = false;
    private AlphaAnimation fpP = null;
    private AlphaAnimation fpQ = null;
    private AddExperiencedModel.a fpR = new AddExperiencedModel.a() { // from class: com.baidu.tieba.frs.FrsFragment.1
        @Override // com.baidu.tieba.share.AddExperiencedModel.a
        public void a(ContriInfo contriInfo) {
        }
    };
    private HttpMessageListener fpS = new HttpMessageListener(CmdConfigHttp.CMD_PB_FLOOR_AGREE, true) { // from class: com.baidu.tieba.frs.FrsFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof PbFloorAgreeResponseMessage)) {
                PbFloorAgreeResponseMessage pbFloorAgreeResponseMessage = (PbFloorAgreeResponseMessage) httpResponsedMessage;
            }
        }
    };
    private final CustomMessageListener fpT = new CustomMessageListener(2016495) { // from class: com.baidu.tieba.frs.FrsFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof bg) {
                    com.baidu.tieba.frs.f.h.a(FrsFragment.this.foQ, FrsFragment.this.fot, FrsFragment.this.getForumId(), true, (bg) data);
                }
            }
        }
    };
    private CustomMessageListener fpU = new CustomMessageListener(2921005) { // from class: com.baidu.tieba.frs.FrsFragment.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.fot != null) {
                FrsFragment.this.fot.removeGameRankListFromThreadList();
                if (FrsFragment.this.foQ != null) {
                    FrsFragment.this.foQ.Ve();
                }
            }
        }
    };
    private CustomMessageListener VO = new CustomMessageListener(2921401) { // from class: com.baidu.tieba.frs.FrsFragment.41
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && FrsFragment.this.foS != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() <= 0 || FrsFragment.this.fpj.bqQ() == 0 || FrsFragment.this.fpj.bqN() == null || !(FrsFragment.this.fpj.bqN().fragment instanceof BaseFragment) || !((BaseFragment) FrsFragment.this.fpj.bqN().fragment).isPrimary()) {
                    if (FrsFragment.this.fpj.bqQ() != 0) {
                        FrsFragment.this.bkk();
                        return;
                    }
                    return;
                }
                FrsFragment.this.bkl();
            }
        }
    };
    private CustomMessageListener fpV = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.FrsFragment.42
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 1) {
                    FrsFragment.this.bkc();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                }
            }
        }
    };
    private final ai fpW = new ai() { // from class: com.baidu.tieba.frs.FrsFragment.43
        @Override // com.baidu.tieba.frs.ai
        public void a(int i, int i2, ap apVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
            FrsFragment.this.bjS();
            if (FrsFragment.this.fpp != null) {
                FrsFragment.this.fpi.kE(FrsFragment.this.fpp.rD(i));
            }
            e.b bVar = new e.b();
            if (apVar != null) {
                bVar.isSuccess = apVar.errCode == 0;
                bVar.errorCode = apVar.errCode;
                bVar.errorMsg = apVar.errMsg;
                if (bVar.isSuccess) {
                    if (com.baidu.tbadk.core.util.v.aa(arrayList)) {
                        FrsFragment.this.foQ.aIJ();
                    } else if (apVar.hasMore) {
                        if (com.baidu.tbadk.core.util.v.Z(FrsFragment.this.fot.getThreadList()) > 3) {
                            FrsFragment.this.foQ.aIH();
                        } else {
                            FrsFragment.this.foQ.blg();
                        }
                    } else if (apVar.ftf) {
                        FrsFragment.this.foQ.aII();
                    } else {
                        FrsFragment.this.foQ.aIJ();
                    }
                }
            } else {
                apVar = new ap();
                apVar.pn = 1;
                apVar.hasMore = false;
                apVar.ftf = false;
            }
            if (i == 1) {
                FrsFragment.this.fpd = true;
                FrsFragment.this.fqk.a(FrsFragment.this.fph.getType(), false, bVar);
            } else {
                FrsFragment.this.a(bVar);
                if (FrsFragment.this.fph.boI() != null) {
                    FrsFragment.this.fot = FrsFragment.this.fph.boI();
                }
                FrsFragment.this.bke();
            }
            if (FrsFragment.this.fqr != null) {
                FrsFragment.this.fqr.a(i, i2, apVar, arrayList);
            }
        }
    };
    private FrsTabViewController.a fpX = new FrsTabViewController.a() { // from class: com.baidu.tieba.frs.FrsFragment.44
        @Override // com.baidu.tieba.frs.vc.FrsTabViewController.a
        public void ku(int i) {
            boolean z = false;
            if (i != 1) {
                com.baidu.tieba.card.t.aXP().iv(false);
                FrsFragment.this.jC(false);
            }
            if (i == 303 && i != FrsFragment.this.fpY) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13121").bT("fid", FrsFragment.this.forumId).bT("uid", TbadkCoreApplication.getCurrentAccount()));
            }
            if (i == 502) {
                FrsFragment.this.foR.setIconFade(R.drawable.btn_frs_professional_edit_n);
            } else {
                FrsFragment.this.foR.setIconFade(0);
            }
            FrsFragment.this.fpY = i;
            FrsFragment.this.bkh();
            com.baidu.tieba.frs.d.d.fxl.fJG = i;
            com.baidu.tieba.frs.d.d.fxl.fJH = -1;
            com.baidu.tieba.frs.a biW = com.baidu.tieba.frs.a.biW();
            if (i == 1 && FrsFragment.this.fpM) {
                z = true;
            }
            biW.A(z, true);
        }
    };
    private CustomMessageListener fpZ = new CustomMessageListener(2001606) { // from class: com.baidu.tieba.frs.FrsFragment.45
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                FrsFragment.this.fpj.sI(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    };
    private CustomMessageListener fqa = new CustomMessageListener(2001607) { // from class: com.baidu.tieba.frs.FrsFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && ((Integer) customResponsedMessage.getData()).intValue() == 51 && FrsFragment.this.fot != null) {
                com.baidu.tieba.frs.f.j.a(FrsFragment.this.fot, FrsFragment.this.getPageContext());
            }
        }
    };
    private final CustomMessageListener fqb = new CustomMessageListener(2003019) { // from class: com.baidu.tieba.frs.FrsFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                FrsFragment.this.fpj.sG(49);
            }
        }
    };
    private final CustomMessageListener fqc = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.frs.FrsFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && FrsFragment.this.fot != null && FrsFragment.this.fot.getForum() != null) {
                SignData signData = (SignData) customResponsedMessage.getData();
                int user_level = FrsFragment.this.fot.getForum().getUser_level();
                if (signData.forumId != null && signData.forumId.equals(FrsFragment.this.fot.getForum().getId())) {
                    FrsFragment.this.fot.updateSignData(signData);
                    FrsFragment.this.fpi.j(FrsFragment.this.fot);
                    if (FrsFragment.this.fpi.bqB()) {
                        i = FrsFragment.this.fot.getForum().getUser_level();
                        if (user_level >= i) {
                            i++;
                        }
                    } else {
                        i = user_level;
                    }
                    TbadkCoreApplication.getInst().addSignedForum(FrsFragment.this.fot.getForum().getName(), signData.sign_bonus_point, i);
                }
            }
        }
    };
    private final CustomMessageListener fqd = new CustomMessageListener(2001352) { // from class: com.baidu.tieba.frs.FrsFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.r) && FrsFragment.this.fot != null) {
                FrsFragment.this.fot.updateLikeData((com.baidu.tieba.tbadkCore.r) customResponsedMessage.getData());
                FrsFragment.this.fpi.i(FrsFragment.this.fot);
                FrsFragment.this.fpj.a(FrsFragment.this.fot, FrsFragment.this.fph.bpj());
            }
        }
    };
    private final AntiHelper.a fqe = new AntiHelper.a() { // from class: com.baidu.tieba.frs.FrsFragment.6
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12536").P("obj_locate", at.a.bTc));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12535").P("obj_locate", at.a.bTc));
        }
    };
    private CustomMessageListener dnV = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.frs.FrsFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(FrsFragment.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().cgz != null) {
                        if (AntiHelper.a(FrsFragment.this.getActivity(), updateAttentionMessage.getData().cgz, FrsFragment.this.fqe) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12534").P("obj_locate", at.a.bTc));
                        }
                    } else if (updateAttentionMessage.getData().Hi && updateAttentionMessage.getData().isAttention) {
                        com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getPageContext().getPageActivity(), (int) R.string.attention_success);
                    }
                }
            }
        }
    };
    private CustomMessageListener fqf = new CustomMessageListener(2921346) { // from class: com.baidu.tieba.frs.FrsFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsFragment.this.refresh();
        }
    };
    private CustomMessageListener fqg = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.frs.FrsFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                FrsFragment.this.foQ.c((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener fqh = new CustomMessageListener(2001626) { // from class: com.baidu.tieba.frs.FrsFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewsRemindMessage newsRemindMessage;
            if (customResponsedMessage != null && (customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626 && (newsRemindMessage = (NewsRemindMessage) customResponsedMessage) != null) {
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (FrsFragment.this.foQ != null) {
                    FrsFragment.this.foQ.B(notificationCount, z);
                }
            }
        }
    };
    private final CustomMessageListener fqi = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.frs.FrsFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.isResumed()) {
                FrsFragment.this.bku();
            }
        }
    };
    private CustomMessageListener fqj = new CustomMessageListener(2003020) { // from class: com.baidu.tieba.frs.FrsFragment.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (FrsFragment.this.foQ != null) {
                    FrsFragment.this.foQ.setExpanded(booleanValue);
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.n fqk = new com.baidu.tieba.tbadkCore.n() { // from class: com.baidu.tieba.frs.FrsFragment.14
        private long startTime = 0;

        @Override // com.baidu.tieba.tbadkCore.n
        public void ra(int i) {
            this.startTime = System.nanoTime();
            if (FrsFragment.this.foQ != null) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsFragment.this.foQ.bkQ();
                        return;
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    default:
                        return;
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void a(int i, boolean z, e.b bVar) {
            if (FrsFragment.this.dnK) {
                FrsFragment.this.dnK = false;
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.foQ, FrsFragment.this.fot, FrsFragment.this.getForumId(), false, null);
            }
            FrsFragment.this.bjS();
            FrsFragment.this.fpa = true;
            if (bVar != null && bVar.isSuccess) {
                FrsFragment.this.foQ.blc().ko(com.baidu.tbadk.core.util.ar.ail().ain());
                FrsFragment.foW = 0L;
                FrsFragment.foX = 0L;
                FrsFragment.foY = 0;
            } else {
                FrsFragment.foY = 1;
            }
            if (!FrsFragment.this.fph.bpn() && (i == 3 || i == 6)) {
                FrsFragment.this.fpu.resetData();
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (FrsFragment.this.fph.boI() != null) {
                FrsFragment.this.fot = FrsFragment.this.fph.boI();
            }
            FrsFragment.this.foQ.b(FrsFragment.this.fot.getRedpacketRainData());
            FrsFragment.this.qW(1);
            if (i == 7) {
                FrsFragment.this.qX(FrsFragment.this.fot.getFrsDefaultTabId());
                return;
            }
            if (FrsFragment.this.fot.getPage() != null) {
                FrsFragment.this.setHasMore(FrsFragment.this.fot.getPage().acp());
            }
            if (i == 4) {
                if (!FrsFragment.this.fph.bpn() && TbadkCoreApplication.getInst().isRecAppExist() && FrsFragment.this.fph.bpe() == 1) {
                    FrsFragment.this.fot.addRecommendAppToThreadList(FrsFragment.this);
                }
                ArrayList<com.baidu.adp.widget.ListView.m> a2 = FrsFragment.this.fpu.a(false, false, FrsFragment.this.fot.getThreadList(), FrsFragment.this.foM, false);
                if (a2 != null) {
                    FrsFragment.this.fot.setThreadList(a2);
                    FrsFragment.this.fot.checkLiveStageInThreadList();
                }
                if (FrsFragment.this.fph != null) {
                    com.baidu.tieba.frs.d.c.a(FrsFragment.this.fot, FrsFragment.this.fph.bpj(), 2);
                }
                com.baidu.tieba.frs.f.a.a(FrsFragment.this, FrsFragment.this.fot.getForum(), FrsFragment.this.fot.getThreadList(), false, FrsFragment.this.getPn());
                FrsFragment.this.cyE = System.currentTimeMillis() - currentTimeMillis;
                FrsFragment.this.foQ.a(a2, FrsFragment.this.fot);
                FrsFragment.this.bjT();
                return;
            }
            FrsFragment.this.bjT();
            switch (i) {
                case 1:
                    FrsFragment.this.foQ.bkQ();
                    break;
                case 2:
                    FrsFragment.this.foQ.bkQ();
                    break;
                case 3:
                case 6:
                    if (FrsFragment.this.fot != null) {
                        FrsFragment.this.fot.clearPostThreadCount();
                    }
                    if (FrsFragment.this.fpz != null) {
                        FrsFragment.this.fpz.refresh();
                        break;
                    }
                    break;
            }
            FrsFragment.this.bjX();
            if (bVar == null || bVar.errorCode == 0) {
                if (FrsFragment.this.fot != null) {
                    FrsFragment.this.D(false, i == 5);
                    if (FrsFragment.this.fph != null) {
                        if (FrsFragment.this.fot.getActivityHeadData() != null && FrsFragment.this.fot.getActivityHeadData().abJ() != null && FrsFragment.this.fot.getActivityHeadData().abJ().size() > 0) {
                            com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), 1, FrsFragment.this.fot.getForum(), FrsFragment.this.fph.getSortType(), 1);
                        }
                        if (FrsFragment.this.fot.getThreadList() != null && FrsFragment.this.fot.getThreadList().size() > 0) {
                            Iterator<com.baidu.adp.widget.ListView.m> it = FrsFragment.this.fot.getThreadList().iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    com.baidu.adp.widget.ListView.m next = it.next();
                                    if ((next instanceof bg) && ((bg) next).getType() == bg.bJU) {
                                        com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), 1, FrsFragment.this.fot.getForum(), FrsFragment.this.fph.getSortType(), 2);
                                    }
                                }
                            }
                        }
                        com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), FrsFragment.this.fot.getThreadList(), FrsFragment.this.fot.getForum(), FrsFragment.this.fph.getSortType());
                    }
                    FrsFragment.this.foQ.rj(i);
                    FrsFragment.foW = (System.nanoTime() - this.startTime) / 1000000;
                    if (bVar != null) {
                        FrsFragment.foX = bVar.iWr;
                    }
                } else {
                    return;
                }
            } else if (FrsFragment.this.fot == null || com.baidu.tbadk.core.util.v.aa(FrsFragment.this.fot.getThreadList())) {
                FrsFragment.this.a(bVar);
            } else if (bVar.eWF) {
                FrsFragment.this.showToast(FrsFragment.this.getPageContext().getResources().getString(R.string.net_error_text, bVar.errorMsg, Integer.valueOf(bVar.errorCode)));
            }
            FrsFragment.this.bjU();
            FrsFragment.this.bjV();
            if (FrsFragment.this.fot.getAccessFlag() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11384"));
            }
            if (FrsFragment.this.eSm > -1 && !FrsFragment.this.fpG) {
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.fph, FrsFragment.this.eSm);
                FrsFragment.this.eSm = -1L;
                FrsFragment.this.fpG = true;
            }
            if (FrsFragment.this.foN && FrsFragment.this.fpj.sG(49)) {
                FrsFragment.this.foN = false;
            }
            FrsFragment.this.cyE = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void b(com.baidu.tieba.tbadkCore.j jVar) {
            if ((jVar != null && ("normal_page".equals(FrsFragment.this.fph.getPageType()) || "frs_page".equals(FrsFragment.this.fph.getPageType()) || "book_page".equals(FrsFragment.this.fph.getPageType()))) || "brand_page".equals(FrsFragment.this.fph.getPageType())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001615, jVar));
                FrsFragment.this.a(jVar);
                FrsFragment.foU = jVar;
            }
        }
    };
    private final CustomMessageListener fql = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.frs.FrsFragment.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                FrsFragment.this.fot.updateCurrentUserPendant((com.baidu.tbadk.data.l) customResponsedMessage.getData());
                FrsFragment.this.foQ.blc().notifyDataSetChanged();
            }
        }
    };
    private final CustomMessageListener mMemListener = new CustomMessageListener(2001194) { // from class: com.baidu.tieba.frs.FrsFragment.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && FrsFragment.this.fot != null && (userData = FrsFragment.this.fot.getUserData()) != null) {
                userData.setIsMem(num.intValue());
                if (num.intValue() != 0) {
                    FrsFragment.this.fpi.h(num);
                }
            }
        }
    };
    private final com.baidu.tieba.frs.mc.k fqm = new com.baidu.tieba.frs.mc.k() { // from class: com.baidu.tieba.frs.FrsFragment.26
        @Override // com.baidu.tieba.frs.mc.k
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.m> arrayList, boolean z3) {
            if (FrsFragment.this.fpl != null && FrsFragment.this.fph != null && FrsFragment.this.fph.bpn() && z && !z2 && !z3) {
                FrsFragment.this.fpl.sj(i2);
            }
        }
    };
    public final View.OnTouchListener clb = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.FrsFragment.27
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (FrsFragment.this.fpB != null) {
                FrsFragment.this.fpB.onTouch(view, motionEvent);
            }
            if (FrsFragment.this.fpn != null && FrsFragment.this.fpn.blL() != null) {
                FrsFragment.this.fpn.blL().onTouchEvent(motionEvent);
            }
            if (FrsFragment.this.dyX != null) {
                FrsFragment.this.dyX.f(view, motionEvent);
            }
            if (FrsFragment.this.fpi != null) {
                FrsFragment.this.fpi.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private final CustomMessageListener fqn = new CustomMessageListener(2004507) { // from class: com.baidu.tieba.frs.FrsFragment.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.agM().getInt(TbadkCoreApplication.getCurrentAccount() + "photolive_hostLevel", -1) != -1 && FrsFragment.this.fot.getForum() != null) {
                FrsFragment.this.fot.getForum().setCanAddPhotoLivePost(true);
            }
        }
    };
    public final View.OnClickListener fqo = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.30
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsFragment.this.foQ == null || view != FrsFragment.this.foQ.bkO() || FrsFragment.this.getActivity() == null) {
                if (FrsFragment.this.fot != null && FrsFragment.this.fot.getForum() != null && FrsFragment.this.foQ != null && view == FrsFragment.this.foQ.bkU()) {
                    if (FrsFragment.this.fpD == null) {
                        FrsFragment.this.fpD = new com.baidu.tieba.frs.view.c(FrsFragment.this.getPageContext());
                    }
                    FrsFragment.this.fpD.m(FrsFragment.this.fot);
                    FrsFragment.this.fpD.showDialog();
                    return;
                }
                if (view.getId() == R.id.game_activity_egg_layout && com.baidu.adp.lib.util.l.ki()) {
                    TiebaStatic.log("c10853");
                    if (FrsFragment.this.foQ.bkZ()) {
                        FrsFragment.this.foQ.bla();
                    } else {
                        String activityUrl = FrsFragment.this.fot.getForum().getYuleData().afA().getActivityUrl();
                        if (!StringUtils.isNull(activityUrl)) {
                            com.baidu.tbadk.browser.a.ag(FrsFragment.this.getPageContext().getPageActivity(), activityUrl);
                        }
                    }
                }
                if (view == FrsFragment.this.foQ.blh() && FrsFragment.this.fph != null && FrsFragment.this.fph.hasMore()) {
                    FrsFragment.this.foQ.aIH();
                    FrsFragment.this.aHt();
                }
                if (view != null && view == FrsFragment.this.foQ.bkW() && bc.cE(FrsFragment.this.getContext())) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12924").P("obj_locate", 2));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(FrsFragment.this.getContext())));
                    return;
                }
                return;
            }
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
            customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, FrsFragment.this.getPageContext().getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.FrsFragment.31
        private int fqA = 0;
        private int dkD = 0;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (FrsFragment.this.fpr != null) {
                FrsFragment.this.fpr.bqb();
            }
            this.fqA = 0;
            this.dkD = 0;
            if (recyclerView != null && (recyclerView instanceof BdRecyclerView)) {
                this.fqA = ((BdRecyclerView) recyclerView).getFirstVisiblePosition();
                this.dkD = ((BdRecyclerView) recyclerView).getLastVisiblePosition();
            }
            if (FrsFragment.this.fpE != null) {
                FrsFragment.this.fpE.a(recyclerView, this.fqA, this.dkD);
            }
            if (FrsFragment.this.fot != null && FrsFragment.this.foQ != null && FrsFragment.this.foQ.blc() != null) {
                FrsFragment.this.foQ.bn(this.fqA, this.dkD);
                if (FrsFragment.this.fpg != null && FrsFragment.this.fpg.qs() != null) {
                    FrsFragment.this.fpg.qs().b(FrsFragment.this.fpf);
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (FrsFragment.this.fpi != null) {
                FrsFragment.this.fpi.setScrollState(i);
            }
            if (i == 0) {
                FrsFragment.this.foQ.bll();
            }
            if ((i == 2 || i == 1) && !FrsFragment.this.fpb) {
                FrsFragment.this.fpb = true;
                FrsFragment.this.foQ.blf();
            }
            if (FrsFragment.this.fpc == null && !FrsFragment.this.bko()) {
                FrsFragment.this.fpc = new com.baidu.tbadk.p.b();
                FrsFragment.this.fpc.kK(1000);
            }
            if (i == 0) {
                if (FrsFragment.this.fpc != null) {
                    FrsFragment.this.fpc.aub();
                }
                com.baidu.tieba.card.t.aXP().iv(true);
                FrsFragment.this.jC(true);
                FrsFragment.this.foQ.bm(this.fqA, this.dkD);
            } else if (FrsFragment.this.fpc != null) {
                FrsFragment.this.fpc.aua();
            }
            if (FrsFragment.this.fpE != null) {
                FrsFragment.this.fpE.onScrollStateChanged(recyclerView, i);
            }
            if (i == 0) {
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.foQ, FrsFragment.this.fot, FrsFragment.this.getForumId(), false, null);
            }
            if (FrsFragment.this.fpj != null && i == 1) {
                FrsFragment.this.fpj.bqP();
            }
            if (FrsFragment.this.fpg == null) {
                if (FrsFragment.this.foQ.bkH() != null && !FrsFragment.this.foQ.bkn() && FrsFragment.this.foQ.bkH().cbn() != null && (FrsFragment.this.foQ.bkH().cbn().getTag() instanceof com.baidu.card.z)) {
                    FrsFragment.this.fpg = (com.baidu.card.z) FrsFragment.this.foQ.bkH().cbn().getTag();
                }
            } else if (i == 0 && FrsFragment.this.foQ.bkH() != null && !FrsFragment.this.foQ.bkn() && FrsFragment.this.foQ.bkH().cbn() != null && (FrsFragment.this.foQ.bkH().cbn().getTag() instanceof com.baidu.card.z)) {
                FrsFragment.this.fpg = (com.baidu.card.z) FrsFragment.this.foQ.bkH().cbn().getTag();
            }
            if (i == 1) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921418));
            }
        }
    };
    private final d fqp = new d() { // from class: com.baidu.tieba.frs.FrsFragment.32
        @Override // com.baidu.tieba.frs.d
        public void a(int i, int i2, View view, View view2, bg bgVar) {
            if (i != FrsFragment.this.foQ.blc().bmX()) {
                if (i != FrsFragment.this.foQ.blc().bmY()) {
                    if (i == FrsFragment.this.foQ.blc().bmV() && FrsFragment.this.fot != null && FrsFragment.this.fot.getUserData() != null && FrsFragment.this.fot.getUserData().isBawu()) {
                        String bawuCenterUrl = FrsFragment.this.fot.getBawuCenterUrl();
                        if (!com.baidu.tbadk.core.util.ap.isEmpty(bawuCenterUrl) && FrsFragment.this.fot.getForum() != null) {
                            com.baidu.tbadk.browser.a.af(FrsFragment.this.getPageContext().getPageActivity(), bawuCenterUrl);
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10502").bT("fid", FrsFragment.this.fot.getForum().getId()).bT("uid", FrsFragment.this.fot.getUserData().getUserId()));
                        }
                    }
                } else if (bc.cE(FrsFragment.this.getPageContext().getPageActivity())) {
                    TiebaStatic.log("my_service_ck");
                    if (FrsFragment.this.fot != null && FrsFragment.this.fot.getForum() != null) {
                        ForumData forum = FrsFragment.this.fot.getForum();
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(forum.getId(), 0L), forum.getName(), forum.getImage_url(), 0)));
                    }
                }
            } else if (bc.cE(FrsFragment.this.getActivity())) {
                TiebaStatic.log("forum_fortune_click");
                com.baidu.tieba.frs.f.i.b(FrsFragment.this.getPageContext(), FrsFragment.this.fot);
            }
        }
    };
    private final NoNetworkView.a fmv = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.FrsFragment.33
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void el(boolean z) {
            if (FrsFragment.this.fph.bpe() == 1 && z && !FrsFragment.this.foQ.bkn()) {
                if (FrsFragment.this.fot == null || com.baidu.tbadk.core.util.v.aa(FrsFragment.this.fot.getThreadList())) {
                    FrsFragment.this.hideNetRefreshView(FrsFragment.this.foQ.bld());
                    FrsFragment.this.showLoadingView(FrsFragment.this.foQ.bld(), true);
                    FrsFragment.this.foQ.jN(false);
                    FrsFragment.this.refresh();
                    return;
                }
                FrsFragment.this.foQ.bkQ();
            }
        }
    };
    private final CustomMessageListener chc = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.FrsFragment.35
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                com.baidu.tieba.frs.f.c.a(customResponsedMessage, FrsFragment.this.foQ, FrsFragment.this.fot);
            }
        }
    };
    private com.baidu.adp.widget.ListView.s fqq = new a();
    private ai fqr = new ai() { // from class: com.baidu.tieba.frs.FrsFragment.37
        @Override // com.baidu.tieba.frs.ai
        public void a(int i, int i2, ap apVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
            com.baidu.adp.lib.g.e.iB().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.37.1
                @Override // java.lang.Runnable
                public void run() {
                    if (FrsFragment.this.foQ != null && FrsFragment.this.foQ.aYN()) {
                        FrsFragment.this.aHt();
                    }
                }
            });
        }
    };
    private CustomMessageListener fqs = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.frs.FrsFragment.38
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    FrsFragment.this.fpF = true;
                }
            }
        }
    };
    private CustomMessageListener fqt = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.frs.FrsFragment.39
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                    if (FrsFragment.this.fpg == null && FrsFragment.this.foQ.bkH() != null && !FrsFragment.this.foQ.bkn() && FrsFragment.this.foQ.bkH().cbn() != null && (FrsFragment.this.foQ.bkH().cbn().getTag() instanceof com.baidu.card.z)) {
                        FrsFragment.this.fpg = (com.baidu.card.z) FrsFragment.this.foQ.bkH().cbn().getTag();
                    }
                    if (FrsFragment.this.fpg != null && FrsFragment.this.fpg.qs() != null) {
                        FrsFragment.this.fpg.qs().b(new a.C0038a(3));
                    }
                }
            }
        }
    };
    private CustomMessageListener fqu = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.FrsFragment.40
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.foQ != null) {
                FrsFragment.this.foQ.bln();
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.frs.loadmore.a
    public /* bridge */ /* synthetic */ com.baidu.adp.base.e getPageContext() {
        return super.getPageContext();
    }

    public com.baidu.tieba.frs.entelechy.b.b bjG() {
        return this.fpp;
    }

    public com.baidu.adp.widget.ListView.s bjH() {
        return this.fqq;
    }

    public com.baidu.tieba.frs.mc.d bjI() {
        return this.fpt;
    }

    public com.baidu.tieba.frs.smartsort.a bjJ() {
        return this.fpl;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public FrsModelController bjK() {
        return this.fph;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public com.baidu.tieba.frs.mc.c bjL() {
        return this.fpu;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public com.baidu.tieba.frs.vc.f bjM() {
        return this.fpi;
    }

    public FrsTabViewController bjN() {
        return this.fpj;
    }

    public ak bjO() {
        return this.fpn;
    }

    public void jB(boolean z) {
        this.fpO = z;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public k bjP() {
        return this.foQ;
    }

    @Override // com.baidu.tieba.frs.aj
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.aj, com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.foI;
    }

    public void setForumName(String str) {
        this.foI = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public String getFrom() {
        return this.mFrom;
    }

    public void setFlag(int i) {
        this.mFlag = i;
    }

    @Override // com.baidu.tieba.recapp.n
    public String getFid() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.recapp.n
    public int getPageNum() {
        if (this.fpu == null) {
            return 1;
        }
        return this.fpu.getPn();
    }

    public int getPn() {
        if (this.fpu == null) {
            return 1;
        }
        return this.fpu.getPn();
    }

    public void setPn(int i) {
        if (this.fpu != null) {
            this.fpu.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.fpu != null) {
            this.fpu.setHasMore(i);
        }
    }

    public int bjQ() {
        if (this.fpu == null) {
            return -1;
        }
        return this.fpu.bjQ();
    }

    public boolean bjR() {
        return this.foO;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public View getRootView() {
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e.b bVar) {
        if (bVar == null) {
            String string = TbadkCoreApplication.getInst().getString(R.string.error_unkown_try_again);
            this.foQ.bkK();
            showNetRefreshView(this.foQ.bld(), string, true);
        } else if (340001 == bVar.errorCode) {
            a(bVar, this.fot.getRecm_forum_list());
        } else {
            if (com.baidu.tbadk.core.util.v.aa(this.fot.getThreadList())) {
                b(bVar);
            }
            if (bko()) {
                setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst(), R.dimen.ds280));
            } else {
                setNetRefreshViewEmotionDefMarginTop();
            }
        }
    }

    public void a(View view, String str, boolean z, List<RecmForumInfo> list) {
        this.foQ.bkK();
        this.foQ.rf(8);
        if (this.fpC == null) {
            this.fpC = new com.baidu.tieba.frs.view.a(getPageContext(), getNetRefreshListener());
        }
        this.fpC.qx(str);
        this.fpC.co(list);
        this.fpC.attachView(view, z);
    }

    private void a(e.b bVar, List<RecmForumInfo> list) {
        if (this.foQ != null) {
            this.foQ.bkK();
            this.foQ.setTitle(this.foI);
            a(this.foQ.bld(), bVar.errorMsg, true, list);
        }
    }

    private void b(e.b bVar) {
        this.foQ.bkK();
        if (bVar.eWF) {
            showNetRefreshView(this.foQ.bld(), TbadkCoreApplication.getInst().getString(R.string.net_error_text, new Object[]{bVar.errorMsg, Integer.valueOf(bVar.errorCode)}), true);
        } else {
            showNetRefreshView(this.foQ.bld(), bVar.errorMsg, true);
        }
    }

    public void bjS() {
        hideLoadingView(this.foQ.bld());
        this.foQ.jP(false);
        if (this.foQ.bkI() instanceof com.baidu.tieba.frs.tab.c) {
            ((com.baidu.tieba.frs.tab.c) this.foQ.bkI()).bpG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjT() {
        if (bjQ() == 0 && com.baidu.tbadk.core.util.v.aa(this.fot.getThreadListIds())) {
            if (com.baidu.tbadk.core.util.v.aa(this.fot.getThreadList())) {
                this.foQ.aIJ();
            } else {
                this.foQ.aII();
            }
        } else if (com.baidu.tbadk.core.util.v.Z(this.fot.getThreadList()) > 3) {
            this.foQ.aIH();
        } else {
            this.foQ.blg();
        }
    }

    public void a(ErrorData errorData) {
        String stringExtra = getActivity().getIntent().getStringExtra("name");
        if (getActivity().getIntent().getIntExtra(FrsActivityConfig.FRS_CALL_FROM, -1) == 12 && errorData != null && errorData.error_code == 3 && !StringUtils.isNull(stringExtra) && TbadkCoreApplication.isLogin()) {
            sendMessage(new CustomMessage(2002001, new CreateBarGuideActivityConfig(getContext(), stringExtra)));
            getActivity().finish();
            return;
        }
        bjS();
        this.foQ.bkQ();
        e.b bpb = this.fph.bpb();
        boolean aa = com.baidu.tbadk.core.util.v.aa(this.fot.getThreadList());
        if (bpb != null && aa) {
            if (this.fph.bpc() != 0) {
                this.fph.bph();
                this.foQ.bkQ();
            } else {
                a(bpb);
            }
            this.foQ.E(this.fot.isStarForum(), false);
            return;
        }
        a(bpb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjU() {
        boolean b;
        if (!bjW()) {
            final PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
            privateForumPopInfoData.a(this.fot.getPrivateForumTotalInfo().getPrivatePopInfo());
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(getActivity());
            if (this.fot.getPrivateForumTotalInfo().acw().private_forum_status.intValue() == 1 && (com.baidu.tbadk.core.util.ap.isEmpty(privateForumPopInfoData.acy()) || privateForumPopInfoData.acB() != Integer.valueOf(this.forumId))) {
                privateForumPopInfoData.mh("create_success");
                privateForumPopInfoData.mi(TbadkCoreApplication.getInst().getString(R.string.frs_private_create_hint));
                privateForumPopInfoData.mj("https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.foI + "&nomenu=1");
                privateForumPopInfoData.b(Integer.valueOf(this.forumId));
                b = frsPrivateCommonDialogView.b(privateForumPopInfoData);
            } else {
                b = privateForumPopInfoData.acB() == Integer.valueOf(this.forumId) ? frsPrivateCommonDialogView.b(privateForumPopInfoData) : false;
            }
            if (b) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
                aVar.hr(2);
                aVar.aF(frsPrivateCommonDialogView);
                aVar.dN(false);
                frsPrivateCommonDialogView.setConfirmButton(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.15
                    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.frs.FrsFragment */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ba.aiz().c(FrsFragment.this.getPageContext(), new String[]{privateForumPopInfoData.acA()});
                        aVar.dismiss();
                    }
                });
                aVar.a(new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.16
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(getPageContext()).afG();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjV() {
        if (bjW() || this.fot.getPrivateForumTotalInfo().acw().private_forum_status.intValue() != 1) {
            a((Integer) null, (Integer) null, true);
        } else {
            a(this.fot.getPrivateForumTotalInfo().acw().private_forum_audit_status, this.fot.getPrivateForumTotalInfo().acx(), false);
        }
    }

    public void a(Integer num, Integer num2, boolean z) {
        final String str;
        final int i = 2;
        if (this.foQ.bkV() != null) {
            TextView bkV = this.foQ.bkV();
            if (z) {
                bkV.setVisibility(8);
                return;
            }
            if (num.intValue() == 2) {
                bkV.setText("修改实名认证信息");
                bkV.setVisibility(0);
                str = "https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + this.forumId + "&nomenu=1";
            } else if (num2.intValue() >= 0 && num2.intValue() <= 100) {
                bkV.setText("目标已完成" + String.valueOf(num2) + "%");
                bkV.setVisibility(0);
                str = "https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.foI + "&nomenu=1";
                i = 1;
            } else {
                bkV.setVisibility(8);
                i = 0;
                str = "";
            }
            bkV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.17
                /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13387").bT("fid", FrsFragment.this.forumId).bT("uid", TbadkCoreApplication.getCurrentAccount()).P("obj_type", i));
                    ba.aiz().c(FrsFragment.this.getPageContext(), new String[]{str});
                }
            });
        }
    }

    private boolean bjW() {
        return this.fot == null || !this.fot.isPrivateForum() || this.fot.getPrivateForumTotalInfo() == null || this.fot.getPrivateForumTotalInfo().acw() == null || this.fot.getUserData().getIs_manager() != 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qW(int i) {
        List<WindowToast> list;
        if (TbadkCoreApplication.isLogin() && this.fot != null && (list = this.fot.mWindowToast) != null && list.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < list.size()) {
                    WindowToast windowToast = list.get(i3);
                    if (windowToast == null || windowToast.toast_type.intValue() != i) {
                        i2 = i3 + 1;
                    } else if (!com.baidu.tbadk.core.util.ap.isEmpty(windowToast.toast_link)) {
                        sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(getPageContext().getPageActivity(), "", com.baidu.tbadk.util.ae.rb(windowToast.toast_link), true)));
                        return;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjX() {
        if (this.fot == null || this.fot.getForum() != null) {
            this.foQ.blb();
        } else if (this.fot.getForum().getYuleData() != null && this.fot.getForum().getYuleData().afz()) {
            TiebaStatic.log("c10852");
            this.foQ.a(this.fot.getForum().getYuleData().afA());
        } else {
            this.foQ.blb();
        }
    }

    private void C(boolean z, boolean z2) {
        if (this.fph != null && this.fot != null && this.foQ != null && z) {
            if (!this.fph.bpn() && this.fph.bpe() == 1) {
                if (!this.fph.bpl()) {
                    this.fot.addCardVideoInfoToThreadList();
                    this.fot.addVideoInfoToThreadListInTenAndFifteenFloor();
                }
                boolean z3 = false;
                if (this.foQ.blc().m(com.baidu.tieba.card.data.n.eBt)) {
                    z3 = this.fot.addHotTopicDataToThreadList();
                }
                if (!z3) {
                    this.fot.addFeedForumDataToThreadList();
                }
                if (TbadkCoreApplication.getInst().isRecAppExist()) {
                    this.fot.addRecommendAppToThreadList(this);
                }
                if (!this.foQ.blc().m(bg.bIx)) {
                    this.fot.removeAlaLiveThreadData();
                }
                this.fot.addSchoolRecommendToThreadList();
            }
            if (!this.foQ.blc().m(bg.bIx)) {
                this.fot.removeAlaInsertLiveData();
                this.fot.removeAlaStageLiveDat();
            } else {
                this.fot.addInsertLiveDataToThreadList();
                this.fot.addStageLiveDataToThreadList();
            }
            this.fot.checkLiveStageInThreadList();
            this.fot.addNoticeThreadToThreadList();
            if (this.foQ.blc().m(com.baidu.tieba.h.b.fRu)) {
                this.fot.addGameRankListToThreadList(z2);
            }
            if (TbadkCoreApplication.isLogin() && (!this.fph.bpn() || this.fph.isNetFirstLoad)) {
                this.fot.addUserRecommendToThreadList();
            }
            this.fot.addVideoActivityToTop();
        }
    }

    public boolean bjY() {
        if (this.fpi != null && this.fph != null) {
            this.fpi.a(this.fph.getPageType(), this.fot);
        }
        boolean z = false;
        if (this.fot != null) {
            z = this.fot.hasTab();
        }
        bka();
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qX(int i) {
        am amVar = null;
        bjY();
        bkh();
        try {
            if (this.fot != null) {
                this.foQ.a((ArrayList<com.baidu.adp.widget.ListView.m>) null, this.fot);
                this.fpi.sA(1);
                this.foQ.bkT();
                this.fpj.a(this.fot, this.fph.bpj());
                com.baidu.tieba.frs.tab.d sH = this.fpj.sH(this.fot.getFrsDefaultTabId());
                if (sH != null && !TextUtils.isEmpty(sH.url)) {
                    amVar = new am();
                    amVar.ftc = sH.url;
                    amVar.stType = sH.name;
                }
                this.fph.a(this.fot.getFrsDefaultTabId(), 0, amVar);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(boolean z, boolean z2) {
        try {
            if (this.fot != null && this.fpj != null && this.fph != null) {
                if (!this.foQ.blc().m(bg.bIx)) {
                    this.fot.removeAlaLiveThreadData();
                }
                boolean aa = com.baidu.tbadk.core.util.v.aa(this.fot.getGameTabInfo());
                this.foQ.jL(aa);
                if (!aa) {
                    if (this.fpE == null) {
                        this.fpE = new com.baidu.tieba.frs.vc.e(this, (NoPressedRelativeLayout) this.mRootView);
                    }
                    if (this.dyX == null) {
                        this.dyX = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
                    }
                } else {
                    this.fpE = null;
                    this.dyX = null;
                }
                if (this.fot.getForum() != null) {
                    this.foI = this.fot.getForum().getName();
                    this.forumId = this.fot.getForum().getId();
                }
                if (this.fot.hasTab()) {
                    this.fpj.a(this.fot, this.fph.bpj());
                }
                if (z) {
                    C(true, z);
                } else {
                    C(this.fpd, z);
                }
                bjY();
                if (this.fpp != null) {
                    this.fpp.a(this.fpi, this.fot);
                }
                if (this.fot.getPage() != null) {
                    setHasMore(this.fot.getPage().acp());
                }
                ArrayList<com.baidu.adp.widget.ListView.m> a2 = this.fpu.a(z2, true, this.fot.getThreadList(), null, z, false);
                if (a2 != null) {
                    this.fot.setThreadList(a2);
                }
                this.fot.removeRedundantUserRecommendData();
                this.fov = this.fot.getTopThreadSize();
                if (this.foM != null) {
                    this.foL = true;
                    this.foM.Au(this.fov);
                    com.baidu.tieba.frs.f.a.a(this, this.fot.getForum(), this.fot.getThreadList(), this.foL, getPn());
                }
                if (this.fph.bpe() == 1) {
                    bke();
                    if (!z && this.fph.getPn() == 1) {
                        bjZ();
                    }
                }
                if (this.fpr != null) {
                    this.fpr.bV(this.fpj.bqM());
                }
                bjS();
                this.foQ.bkL();
                this.foQ.E(true, false);
                if (z && this.fot.isFirstTabEqualAllThread()) {
                    com.baidu.adp.lib.g.e.iB().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.18
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!FrsFragment.this.fpa) {
                                FrsFragment.this.foQ.blm();
                            }
                        }
                    });
                }
                if (this.fot.getForum() != null) {
                    this.foQ.wr(this.fot.getForum().getWarningMsg());
                }
                if (this.fot != null && this.fot.getFrsVideoActivityData() != null && com.baidu.tbadk.core.sharedPref.b.agM().getLong("frs_video_activity_guide", 0L) == 0) {
                    com.baidu.adp.lib.g.e.iB().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.19
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsFragment.this.foQ.blj();
                        }
                    }, 1000L);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2921326, this));
                this.foQ.bkF();
                if (this.fot != null && this.fot.getForum() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016564, new VisitedForumData(this.fot.getForum().getId(), this.fot.getForum().getName(), this.fot.getForum().getImage_url(), String.valueOf(System.currentTimeMillis() / 1000), "showlive".equals(this.fot.getForum().special_forum_type), this.fot.getForum().getThemeColorInfo(), this.fot.getForum().getMember_num())));
                }
                this.fpJ.a(this.fot.bottomMenuList, this.fot.getForum());
                bku();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void jC(boolean z) {
        com.baidu.tieba.q.c.clv().b(getUniqueId(), z);
    }

    public void bjZ() {
        if (this.fpx == null) {
            this.fpx = new com.baidu.tieba.frs.live.a(this, com.baidu.adp.lib.g.b.f(this.forumId, 0));
        }
        this.fpx.boN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.j jVar) {
        try {
            if (!this.fpa && jVar != null && this.fot != null) {
                this.fot.receiveData(jVar);
                D(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void bka() {
        if (this.fph != null) {
            wp(this.fph.getPageType());
        } else {
            wp("normal_page");
        }
    }

    private void wp(String str) {
        jD("frs_page".equals(str));
        if (this.fpp != null) {
            this.fpp.a(this.fpi, this.foQ, this.fot);
        }
    }

    public void jD(boolean z) {
        if (this.fpv != null) {
            this.fpv.bqG();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.q.c.clv().u(getUniqueId());
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.frs_activity, viewGroup, false);
            this.foC = new com.baidu.tieba.frs.entelechy.a();
            this.fpp = this.foC.bmC();
            this.fpi = new com.baidu.tieba.frs.vc.f(this, this.foC, (FrsHeaderViewContainer) this.mRootView.findViewById(R.id.header_view_container));
            this.fpj = new FrsTabViewController(this, this.mRootView);
            this.fpj.registerListener();
            this.fpi.a(this.fpj);
            this.fpj.a(this.fpX);
            Intent intent = getActivity().getIntent();
            if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                this.foE = true;
            }
            this.foQ = new k(this, this.fqo, this.foC, this.foE, this.fpi);
            this.fpJ = new com.baidu.tieba.frs.brand.buttommenu.a(getPageContext(), this.mRootView);
        } else {
            if (this.mRootView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            if (this.fpj != null) {
                this.fpj.registerListener();
            }
            this.foQ.bli();
            this.mRootView.setLeft(0);
            this.mRootView.setRight(com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst().getContext()));
        }
        this.fpN = true;
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        ArrayList<com.baidu.adp.widget.ListView.m> arrayList = null;
        this.eSm = System.currentTimeMillis();
        this.beginTime = this.eSm;
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.foN = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.eSm = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            af(intent);
        }
        this.cyw = this.beginTime - this.eSm;
        this.foM = new com.baidu.tieba.tbadkCore.data.f("frs", com.baidu.tieba.tbadkCore.data.f.iYa);
        if (this.fph == null) {
            this.fph = new FrsModelController(this, this.fqk);
            this.fph.a(this.fpW);
            this.fph.init();
        }
        if (intent != null) {
            this.fph.K(intent.getExtras());
        } else if (bundle != null) {
            this.fph.K(bundle);
        } else {
            this.fph.K(null);
        }
        if (intent != null) {
            this.fpi.R(intent.getExtras());
        } else if (bundle != null) {
            this.fpi.R(bundle);
        } else {
            this.fpi.R(null);
        }
        this.foP = getVoiceManager();
        this.fpy = new j(getPageContext(), this);
        initUI();
        initData(bundle);
        if (!bko()) {
            this.fpn = new ak(getActivity(), this.foQ, this.fpi);
            this.fpn.kc(true);
        }
        this.foP = getVoiceManager();
        if (this.foP != null) {
            this.foP.onCreate(getPageContext());
        }
        new com.baidu.tieba.frs.mc.i();
        int i = -1;
        if (this.fpu != null && this.fpu.boY() != null) {
            i = this.fpu.boY().bjQ();
            arrayList = this.fpu.boY().getDataList();
        }
        this.fpu = new com.baidu.tieba.frs.mc.c(this, this.fqm);
        this.fpu.boY().setHasMore(i);
        if (arrayList != null && arrayList.size() > 0) {
            this.fpu.boY().ad(arrayList);
        }
        this.fpl = new com.baidu.tieba.frs.smartsort.a(this);
        this.fpv = new com.baidu.tieba.frs.vc.h(this);
        this.fpr = new com.baidu.tieba.frs.vc.a(getPageContext(), this.fph.bpk());
        this.fpm = new com.baidu.tieba.frs.mc.b(this);
        this.fpt = new com.baidu.tieba.frs.mc.d(this);
        this.fpk = new com.baidu.tieba.frs.mc.h(this);
        this.fpw = new com.baidu.tieba.frs.mc.a(this);
        this.fpz = new com.baidu.tieba.frs.vc.c(this);
        this.fpA = new com.baidu.tieba.frs.mc.e(this, getUniqueId());
        this.fpH = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "frs");
        this.fpI = new com.baidu.tieba.ala.a(getPageContext());
        this.fpK = new com.baidu.tieba.frs.sportspage.notification.a(getPageContext());
        registerListener(this.dnV);
        registerListener(this.mMemListener);
        registerListener(this.fqd);
        registerListener(this.fqn);
        registerListener(this.fqc);
        registerListener(this.fql);
        registerListener(this.fpZ);
        registerListener(this.fqa);
        registerListener(this.fqb);
        registerListener(this.fpT);
        registerListener(this.fpU);
        registerListener(this.VO);
        registerListener(this.fqs);
        registerListener(this.fqg);
        registerListener(this.fpV);
        registerListener(this.fqh);
        registerListener(this.fqf);
        this.fpS.setTag(getPageContext().getUniqueId());
        registerListener(this.fpS);
        registerListener(this.fqi);
        registerListener(this.fqj);
        this.fqt.setTag(getPageContext().getUniqueId());
        MessageManager.getInstance().registerListener(this.fqt);
        registerListener(this.fqu);
        this.foQ.jN(false);
        if (!bko() && !this.hasInit) {
            showLoadingView(this.foQ.bld(), true);
            this.fph.D(3, false);
        }
        com.baidu.tieba.frs.a.biW().a(new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.22
            @Override // com.baidu.tieba.frs.a.b
            public void B(boolean z, boolean z2) {
                if (FrsFragment.this.foQ != null) {
                    FrsFragment.this.foQ.rg(z ? 0 : 8);
                    if (!z2) {
                        FrsFragment.this.fpM = z;
                    }
                    if (FrsFragment.this.foQ.blc() != null && FrsFragment.this.fph != null && FrsFragment.this.fph.bpf()) {
                        FrsFragment.this.foQ.blc().notifyDataSetChanged();
                    }
                    if (FrsFragment.this.bjN() != null) {
                        FrsTabViewController.b bqN = FrsFragment.this.bjN().bqN();
                        if (bqN != null && bqN.tabId == 502 && (bqN.fragment instanceof FrsCommonTabFragment)) {
                            ((FrsCommonTabFragment) bqN.fragment).bmy();
                        } else if (bqN != null && bqN.tabId == 503 && (bqN.fragment instanceof FrsNewAreaFragment)) {
                            FrsNewAreaFragment frsNewAreaFragment = (FrsNewAreaFragment) bqN.fragment;
                            frsNewAreaFragment.bmy();
                            if (frsNewAreaFragment.bpq() != null) {
                                com.baidu.tieba.frs.mc.g bpq = frsNewAreaFragment.bpq();
                                bpq.jQ(!z);
                                bpq.jR(!z);
                            }
                        }
                        if (FrsFragment.this.bjN().bqH() != null) {
                            FrsFragment.this.bjN().bqH().setmDisallowSlip(z);
                            FrsFragment.this.bjN().kG(z);
                        }
                    }
                    if (FrsFragment.this.foQ.bkJ() != null) {
                        FrsFragment.this.foQ.jK(!z);
                    }
                    if (FrsFragment.this.getActivity() instanceof FrsActivity) {
                        ((FrsActivity) FrsFragment.this.getActivity()).jA(!z);
                    }
                    if (FrsFragment.this.fpJ != null) {
                        FrsFragment.this.fpJ.kk(!z);
                    }
                    FrsFragment.this.foQ.jQ(!z);
                    FrsFragment.this.foQ.jR(z ? false : true);
                }
            }

            @Override // com.baidu.tieba.frs.a.b
            public void qT(int i2) {
                if (FrsFragment.this.foQ != null) {
                    FrsFragment.this.foQ.rh(i2);
                }
            }

            @Override // com.baidu.tieba.frs.a.b
            public void bjd() {
                com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getContext(), (int) R.string.frs_multi_delete_max_num);
            }
        });
        this.foQ.b(new d.a() { // from class: com.baidu.tieba.frs.FrsFragment.24
            @Override // com.baidu.tieba.NEGFeedBack.d.a
            public void a(DeleteThreadHttpResponseMessage deleteThreadHttpResponseMessage) {
                boolean z;
                int i2 = 0;
                if (deleteThreadHttpResponseMessage != null) {
                    FrsFragment.this.foQ.azZ();
                    FrsFragment.this.foQ.blk();
                    FrsNewAreaFragment frsNewAreaFragment = null;
                    if (FrsFragment.this.fpj == null || FrsFragment.this.fpj.bqN() == null || !(FrsFragment.this.fpj.bqN().fragment instanceof FrsNewAreaFragment)) {
                        z = false;
                    } else {
                        frsNewAreaFragment = (FrsNewAreaFragment) FrsFragment.this.fpj.bqN().fragment;
                        z = true;
                    }
                    if (deleteThreadHttpResponseMessage.getError() == 0) {
                        String text = !TextUtils.isEmpty(deleteThreadHttpResponseMessage.getText()) ? deleteThreadHttpResponseMessage.getText() : FrsFragment.this.getString(R.string.delete_fail);
                        if (deleteThreadHttpResponseMessage.getRetType() == 1211066) {
                            if (FrsFragment.this.ezQ == null) {
                                FrsFragment.this.ezQ = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.ezQ.mE(text);
                            FrsFragment.this.ezQ.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.24.1
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.ezQ.dN(false);
                            FrsFragment.this.ezQ.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.ezQ.afG();
                        } else if (deleteThreadHttpResponseMessage.getRetType() == 1211067) {
                            if (FrsFragment.this.ezQ == null) {
                                FrsFragment.this.ezQ = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.ezQ.mE(text);
                            FrsFragment.this.ezQ.a(R.string.know, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.24.2
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.ezQ.dN(false);
                            FrsFragment.this.ezQ.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.ezQ.afG();
                        } else {
                            FrsFragment.this.foQ.at(deleteThreadHttpResponseMessage.getText(), ContextCompat.getColor(FrsFragment.this.getContext(), deleteThreadHttpResponseMessage.getRetType() == 1 ? R.color.nav_bar_tip_error : R.color.cp_link_tip_a_alpha95));
                        }
                        if (z && frsNewAreaFragment != null) {
                            frsNewAreaFragment.cj(deleteThreadHttpResponseMessage.getSuccessItems());
                        }
                        FrsFragment.this.bX(deleteThreadHttpResponseMessage.getSuccessItems());
                        com.baidu.tieba.frs.a.biW().bW(deleteThreadHttpResponseMessage.getSuccessItems());
                        for (com.baidu.adp.widget.ListView.m mVar : FrsFragment.this.fot.getThreadList()) {
                            if (mVar instanceof bf) {
                                i2++;
                                continue;
                            }
                            if (i2 >= 6) {
                                break;
                            }
                        }
                        if (i2 < 6) {
                            FrsFragment.this.aHt();
                            return;
                        }
                        return;
                    }
                    com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getActivity(), deleteThreadHttpResponseMessage.getErrorString());
                }
            }
        });
        this.hasInit = true;
        qY(1);
        super.onActivityCreated(bundle);
        this.createTime = System.currentTimeMillis() - this.beginTime;
    }

    public void jE(boolean z) {
        if (this.fpj != null) {
            this.fpj.fMX = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bX(List<String> list) {
        if (!com.baidu.tbadk.core.util.v.aa(list)) {
            ArrayList<com.baidu.adp.widget.ListView.m> threadList = this.fot.getThreadList();
            if (!com.baidu.tbadk.core.util.v.aa(threadList) && this.foQ.getListView() != null && this.foQ.getListView().getData() != null) {
                Iterator<com.baidu.adp.widget.ListView.m> it = threadList.iterator();
                List<com.baidu.adp.widget.ListView.m> data = this.foQ.getListView().getData();
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.m next = it.next();
                    if (next instanceof bf) {
                        bg bgVar = ((bf) next).threadData;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= list.size()) {
                                break;
                            } else if (!com.baidu.tbadk.core.util.ap.equals(list.get(i2), bgVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.fpu.e(next);
                                this.foQ.getListView().getAdapter().notifyItemRemoved(i);
                                break;
                            }
                        }
                    }
                    i++;
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void aHM() {
        if (isAdded() && this.dnK && !isLoadingViewAttached()) {
            showLoadingView(this.foQ.bld(), true);
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void aHN() {
        if (isAdded() && this.dnK && isLoadingViewAttached()) {
            hideLoadingView(this.foQ.bld());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (bko()) {
            showLoadingView(this.foQ.bld(), true);
            this.foQ.ri(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.fph.D(3, true);
            ajY().scrollToPosition(0);
        }
    }

    private void qY(int i) {
        String str = "";
        if (this.fot != null && this.fot.getForum() != null) {
            str = this.fot.getForum().getId();
        }
        if (!StringUtils.isNull(str)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13008").bT("fid", str).bT("obj_type", "4").P("obj_locate", i).bT("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.x xVar) {
        if (xVar != null) {
            this.cBS = xVar.avn();
            this.fpB = xVar.avo();
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void showFloatingView() {
        if (this.cBS != null) {
            this.cBS.fI(true);
        }
    }

    private void af(Intent intent) {
        if (intent != null) {
            if (intent != null) {
                if (!com.baidu.tieba.frs.f.f.a(this, getForumName(), "from", intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false)) && getActivity() != null) {
                    getActivity().finish();
                    return;
                }
            }
            if (intent != null && intent.getData() != null) {
                Uri data = intent.getData();
                this.foI = data.getQueryParameter("name");
                this.mFrom = data.getQueryParameter("from");
                if (!StringUtils.isNull(this.foI)) {
                    intent.putExtra("name", this.foI);
                }
                if (!StringUtils.isNull(this.mFrom)) {
                    intent.putExtra("from", this.mFrom);
                }
                TiebaStatic.log("c10105");
            }
            if (StringUtils.isNull(this.foI) && intent != null && intent.getData() != null) {
                Uri data2 = intent.getData();
                if (com.baidu.tbadk.BdToken.f.m(data2)) {
                    com.baidu.tbadk.BdToken.f.YA().b(data2, new f.a() { // from class: com.baidu.tieba.frs.FrsFragment.25
                        @Override // com.baidu.tbadk.BdToken.f.a
                        public void o(HashMap<String, Object> hashMap) {
                            if (hashMap != null && (hashMap.get(com.baidu.tbadk.BdToken.f.bys) instanceof String)) {
                                FrsFragment.this.foI = (String) hashMap.get(com.baidu.tbadk.BdToken.f.bys);
                            }
                        }
                    });
                } else {
                    com.baidu.tieba.frs.f.d ai = com.baidu.tieba.frs.f.i.ai(intent);
                    if (ai != null) {
                        this.foI = ai.forumName;
                        if (ai.fLu == null || ai.fLu.equals("aidou")) {
                        }
                    }
                }
                if (!StringUtils.isNull(this.foI)) {
                    intent.putExtra("name", this.foI);
                }
                intent.putExtra(FrsActivityConfig.FRS_CALL_FROM, 12);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.foP = getVoiceManager();
        if (this.foP != null) {
            this.foP.onStart(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        Intent intent;
        registerListener(2001118, this.chc);
        if (bundle != null) {
            this.foI = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
            this.foI = intent.getStringExtra("name");
            this.mFrom = intent.getStringExtra("from");
            this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
        }
        if (getArguments() != null) {
            this.foJ = getArguments().getBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, false);
        }
        if (TextUtils.isEmpty(this.mFrom) || FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
        }
        if (this.mIsLogin) {
            registerListener(2001120, this.chc);
        }
        this.fpi.R(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.q.c.clv().v(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.fqs);
        foU = null;
        if (this.foP != null) {
            this.foP.onDestory(getPageContext());
        }
        com.baidu.tieba.recapp.report.a.remove("FRS");
        this.foP = null;
        com.baidu.tieba.card.t.aXP().iv(false);
        if (this.fot != null && this.fot.getForum() != null) {
            aa.blI().db(com.baidu.adp.lib.g.b.c(this.fot.getForum().getId(), 0L));
        }
        if (this.fpx != null) {
            this.fpx.onDestory();
        }
        if (this.foQ != null) {
            com.baidu.tieba.frs.f.h.a(this.foQ, this.fot, getForumId(), false, null);
            this.foQ.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.fpc != null) {
                this.fpc.auc();
            }
            this.foQ.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.fpi.onActivityDestroy();
        if (this.fph != null) {
            this.fph.aJS();
        }
        if (this.fpn != null) {
            this.fpn.avm();
        }
        if (this.fpq != null) {
            this.fpq.destory();
        }
        if (this.fpr != null) {
            this.fpr.destory();
        }
        if (this.fpl != null) {
            this.fpl.onDestroy();
        }
        if (this.fpE != null) {
            this.fpE.onDestory();
        }
        if (this.fpw != null) {
            this.fpw.onDestroy();
        }
        if (this.fpH != null) {
            this.fpH.onDestroy();
        }
        if (this.fpI != null) {
            this.fpI.onDestroy();
        }
        com.baidu.tieba.recapp.d.a.cfB().cfD();
        com.baidu.tieba.frs.f.j.bpY();
        if (this.fpj != null) {
            this.fpj.a((FrsTabViewController.a) null);
            this.fpj.bqP();
        }
        if (this.fpL != null) {
            this.fpL.onDestroy();
        }
        com.baidu.tieba.frs.a.biW().a(null);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.foI);
        bundle.putString("from", this.mFrom);
        this.fph.onSaveInstanceState(bundle);
        if (this.foP != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            this.foP.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.fpw != null) {
            this.fpw.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.foQ != null) {
            this.foQ.bkQ();
            this.foQ.onResume();
        }
        this.fpk.kz(true);
        this.fpd = true;
        if (foH) {
            foH = false;
            this.foQ.startPullRefresh();
            return;
        }
        if (this.foP != null) {
            this.foP.onResume(getPageContext());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921338));
        this.foQ.jS(false);
        if (this.fpF) {
            refresh(6);
            this.fpF = false;
        }
        bku();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
    }

    public boolean bkb() {
        Intent intent;
        if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
            return false;
        }
        return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
    }

    public void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.foI = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.foK = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.foK) {
                bkc();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkc() {
        this.foQ.startPullRefresh();
    }

    public void closeActivity() {
        com.baidu.tieba.frs.f.i.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.mFrom);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.foQ.setTitle(this.foI);
        } else {
            this.foQ.setTitle("");
            this.mFlag = 1;
        }
        this.foQ.setOnAdapterItemClickListener(this.fqq);
        this.foQ.addOnScrollListener(this.mScrollListener);
        this.foQ.h(this.fmv);
        this.foQ.blc().a(this.fqp);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fpN) {
            this.foQ.onChangeSkinType(i);
            this.fpi.sz(i);
            this.fpj.onChangeSkinType(i);
            if (this.foS != null) {
                this.foS.onChangeSkinType(i);
            }
            if (this.fpC != null) {
                this.fpC.onChangeSkinType();
            }
            if (this.fpJ != null) {
                this.fpJ.onChangeSkinType(getPageContext(), i);
            }
            if (this.ezQ != null) {
                com.baidu.tbadk.s.a.a(getPageContext(), this.ezQ.afH());
            }
            if (this.fpD != null) {
                this.fpD.onChangeSkinType();
            }
        }
    }

    public void qZ(int i) {
        if (!this.mIsLogin) {
            if (this.fot != null && this.fot.getAnti() != null) {
                this.fot.getAnti().setIfpost(1);
            }
            if (i == 0) {
                bc.cD(getActivity());
            }
        } else if (this.fot != null) {
            if (i == 0) {
                com.baidu.tieba.frs.f.j.d(this, 0);
            } else {
                this.foQ.bkS();
            }
        }
    }

    public void refresh() {
        com.baidu.tieba.a.d.aBq().rU("page_frs");
        refresh(3);
    }

    public void refresh(int i) {
        this.fpa = false;
        bkh();
        if (this.foQ != null && this.foQ.bkH() != null) {
            this.foQ.bkH().bvR();
        }
        if (this.fph != null) {
            this.fph.D(i, true);
        }
    }

    private void bkd() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.g.h.iC().d(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.29
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.Ec(FrsFragment.this.foI);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bke() {
        bkh();
        try {
            if (this.fot != null) {
                this.foQ.aUH();
                this.foQ.jK(bkt());
                if (!com.baidu.tieba.frs.vc.f.l(this.fot) || !com.baidu.tieba.frs.vc.f.k(this.fot)) {
                }
                if (this.fot.getForum() != null) {
                    this.foI = this.fot.getForum().getName();
                    this.forumId = this.fot.getForum().getId();
                }
                if (this.fot.getPage() != null) {
                    setHasMore(this.fot.getPage().acp());
                }
                this.foQ.setTitle(this.foI);
                this.foQ.setForumName(this.foI);
                TbadkCoreApplication.getInst().setDefaultBubble(this.fot.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.fot.getUserData().getBimg_end_time());
                bkd();
                bkf();
                ArrayList<com.baidu.adp.widget.ListView.m> threadList = this.fot.getThreadList();
                if (threadList != null) {
                    this.foQ.a(threadList, this.fot);
                    com.baidu.tieba.frs.f.c.y(this.foQ);
                    this.fpi.sA(getPageNum());
                    this.fpi.i(this.fot);
                    this.fpj.a(this.fot, this.fph.bpj());
                    this.foQ.bkT();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void bkf() {
        if (this.fot != null) {
            if (this.fot.getIsNewUrl() == 1) {
                this.foQ.blc().setFromCDN(true);
            } else {
                this.foQ.blc().setFromCDN(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.fpk.kz(false);
        this.fpd = false;
        this.foQ.onPause();
        if (this.foP != null) {
            this.foP.onPause(getPageContext());
        }
        this.foQ.jS(true);
        if (this.fpr != null) {
            this.fpr.bqb();
        }
        com.baidu.tbadk.BdToken.c.Yk().Yp();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.fpj != null && this.fpj.bqN() != null && (this.fpj.bqN().fragment instanceof BaseFragment)) {
            ((BaseFragment) this.fpj.bqN().fragment).setPrimary(z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.t.aXP().iv(false);
        jC(false);
        if (this.fot != null && this.fot.getForum() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            com.baidu.tbadk.distribute.a.aqF().a(getPageContext().getPageActivity(), "frs", this.fot.getForum().getId(), 0L);
        }
        if (this.foP != null) {
            this.foP.onStop(getPageContext());
        }
        if (ajY() != null) {
            ajY().getRecycledViewPool().clear();
        }
        this.fpi.onActivityStop();
        com.baidu.tbadk.util.y.avq();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            if (this.fpi != null) {
                this.fpi.jI(isPrimary());
            }
            if (this.foQ != null) {
                this.foQ.jI(isPrimary());
                this.foQ.jS(!isPrimary());
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (com.baidu.tieba.frs.a.biW().biX()) {
                com.baidu.tieba.frs.a.biW().reset();
                return true;
            } else if (this.foQ != null) {
                return this.foQ.bkP();
            }
        } else if (i == 24) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921381, keyEvent));
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.n
    public TbPageContext<?> getTbPageContext() {
        return getPageContext();
    }

    @Override // com.baidu.tieba.recapp.n
    public void a(AdvertAppInfo advertAppInfo, String str) {
        com.baidu.tbadk.distribute.a.aqF().a(advertAppInfo, this.forumId, 0L, "FRS", str, getPn());
    }

    @Override // com.baidu.tieba.recapp.n
    public void bkg() {
        bjK().bkg();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.foP == null) {
            this.foP = VoiceManager.instance();
        }
        return this.foP;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdRecyclerView ajY() {
        if (this.foQ == null) {
            return null;
        }
        return this.foQ.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void bkh() {
        if (this.foP != null) {
            this.foP.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> ajZ() {
        if (this.cbP == null) {
            this.cbP = UserIconBox.q(getPageContext().getPageActivity(), 8);
        }
        return this.cbP;
    }

    public void bki() {
        if (getFragmentActivity() != null && getFragmentActivity().getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.b(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.p onGetPreLoadListView() {
        return ajY().getPreLoadHandle();
    }

    @Override // com.baidu.tieba.frs.ah
    public NavigationBar aJC() {
        if (this.foQ == null) {
            return null;
        }
        return this.foQ.aJC();
    }

    public FRSRefreshButton bkj() {
        return this.foS;
    }

    public void a(FRSRefreshButton fRSRefreshButton) {
        if (fRSRefreshButton != null) {
            this.foS = fRSRefreshButton;
            this.foS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.36
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (FrsFragment.this.fpj != null) {
                        FrsTabViewController.b bqN = FrsFragment.this.fpj.bqN();
                        if (bqN != null && bqN.fragment != null && (bqN.fragment instanceof ag)) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                            ((ag) bqN.fragment).bjy();
                            ((ag) bqN.fragment).aIG();
                            return;
                        }
                        FrsFragment.this.bjP().startPullRefresh();
                    }
                }
            });
        }
    }

    public void bkk() {
        if (this.foS != null && this.foT) {
            if (this.fpP != null) {
                this.fpP.cancel();
            }
            this.fpP = new AlphaAnimation(1.0f, 0.0f);
            this.fpP.setDuration(300L);
            this.fpP.setFillAfter(true);
            this.foS.startAnimation(this.fpP);
            this.foS.setClickable(false);
            this.foT = false;
        }
    }

    public void bkl() {
        if (this.foS != null && !this.foT && this.fpj.bqQ() != 0) {
            this.foS.setVisibility(0);
            if (this.fpQ != null) {
                this.fpQ.cancel();
            }
            this.fpQ = new AlphaAnimation(0.0f, 1.0f);
            this.fpQ.setDuration(300L);
            this.fpQ.setFillAfter(true);
            this.foS.startAnimation(this.fpQ);
            this.foS.setClickable(true);
            this.foT = true;
        }
    }

    /* loaded from: classes4.dex */
    private final class a implements com.baidu.adp.widget.ListView.s {
        private a() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.s
        public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null) {
                if (bdUniqueId == p.fsb) {
                    if (FrsFragment.this.foQ != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11752").bT("fid", FrsFragment.this.forumId).bT("obj_locate", "1"));
                        FrsFragment.this.foQ.startPullRefresh();
                    }
                } else if (mVar != null && (mVar instanceof bf)) {
                    bg bgVar = ((bf) mVar).threadData;
                    if (bgVar.aen() == null || bgVar.aen().getGroup_id() == 0 || bc.cE(FrsFragment.this.getActivity())) {
                        if (bgVar.aef() != 1 || bc.cE(FrsFragment.this.getActivity())) {
                            if (bgVar.adI() != null) {
                                if (bc.cE(FrsFragment.this.getActivity())) {
                                    String postUrl = bgVar.adI().getPostUrl();
                                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.ki()) {
                                        com.baidu.tbadk.browser.a.ag(FrsFragment.this.getActivity(), postUrl);
                                    }
                                }
                            } else if (bgVar.aey() != null) {
                                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                    bc.cD(FrsFragment.this.getPageContext().getPageActivity());
                                    return;
                                }
                                com.baidu.tbadk.core.data.o aey = bgVar.aey();
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), aey.getCartoonId(), aey.getChapterId(), 2)));
                            } else {
                                com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                                if (readThreadHistory != null && !readThreadHistory.Ei(bgVar.getId())) {
                                    readThreadHistory.Eh(bgVar.getId());
                                }
                                boolean z = false;
                                final String adC = bgVar.adC();
                                if (adC != null && !adC.equals("")) {
                                    z = true;
                                    new Thread(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.a.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(adC);
                                            xVar.ahC().aiB().mIsNeedAddCommenParam = false;
                                            xVar.ahC().aiB().mIsUseCurrentBDUSS = false;
                                            xVar.ahf();
                                        }
                                    }).start();
                                }
                                String tid = bgVar.getTid();
                                if (tid == null) {
                                    tid = "";
                                }
                                if (bgVar.adq() == 2 && !tid.startsWith("pb:")) {
                                    ba.aiz().c(FrsFragment.this.getPageContext(), new String[]{tid, "", null});
                                    return;
                                }
                                if (tid.startsWith("pb:")) {
                                    bgVar.setId(tid.substring(3));
                                }
                                if (bdUniqueId.getId() == bg.bJU.getId()) {
                                    com.baidu.tieba.frs.f.h.a(bgVar.adb());
                                } else if (bdUniqueId.getId() == bg.bIA.getId()) {
                                    com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c12940");
                                    amVar.bT("obj_type", "2");
                                    amVar.bT("tid", bgVar.getTid());
                                    TiebaStatic.log(amVar);
                                }
                                com.baidu.tieba.frs.f.i.a(FrsFragment.this, bgVar, i, z);
                                com.baidu.tieba.frs.f.h.a(FrsFragment.this, FrsFragment.this.fot, bgVar);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.l.ki()) {
            hideNetRefreshView(this.foQ.bld());
            showLoadingView(this.foQ.bld(), true);
            this.foQ.jN(false);
            this.fph.D(3, true);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData bkm() {
        return this.fot;
    }

    public boolean bkn() {
        return this.foQ.bkn();
    }

    public void ar(Object obj) {
        if (this.fpm != null && this.fpm.fGX != null) {
            this.fpm.fGX.m(obj);
        }
    }

    public void as(Object obj) {
        if (this.fpm != null && this.fpm.fGY != null) {
            this.fpm.fGY.m(obj);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        this.foQ.getListView().stopScroll();
        if (!this.foQ.bkY()) {
            if (!com.baidu.adp.lib.util.l.ki()) {
                this.foQ.aIJ();
            } else if (this.fph.bpe() == 1) {
                aHH();
                aHt();
            } else if (this.fph.hasMore()) {
                aHt();
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void vY(String str) {
        aHH();
        showToast(str);
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void V(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        boolean aa = com.baidu.tbadk.core.util.v.aa(arrayList);
        setHasMore(aa ? 0 : 1);
        aHH();
        if (!aa) {
            if (!this.fph.bpn() && TbadkCoreApplication.getInst().isRecAppExist() && this.fph.bpe() == 1) {
                this.fot.addRecommendAppToThreadList(this, arrayList);
            }
            if (this.fph != null) {
                com.baidu.tieba.frs.d.a.a(getUniqueId(), arrayList, this.fot.getForum(), this.fph.getSortType());
            }
            ArrayList<com.baidu.adp.widget.ListView.m> a2 = this.fpu.a(false, false, arrayList, this.foM, false);
            if (a2 != null) {
                this.fot.setThreadList(a2);
                this.foQ.a(a2, this.fot);
            }
            if (this.fph != null) {
                com.baidu.tieba.frs.d.c.a(this.fot, this.fph.bpj(), 2);
            }
        }
    }

    private void aHH() {
        if (bjQ() == 1 || this.fpu.ci(this.fot.getThreadListIds())) {
            if (com.baidu.tbadk.core.util.v.Z(this.fot.getThreadList()) > 3) {
                this.foQ.aIH();
            } else {
                this.foQ.blg();
            }
        } else if (com.baidu.tbadk.core.util.v.aa(this.fot.getThreadList())) {
            this.foQ.aIJ();
        } else {
            this.foQ.aII();
        }
    }

    @Override // com.baidu.tieba.frs.mc.l
    public void aHt() {
        if (this.fpu != null) {
            this.fpu.a(this.foI, this.forumId, this.fot);
        }
    }

    public void takePhoto() {
        if (!com.baidu.tbadk.core.util.ab.e(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.ak.c(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment, com.baidu.e.a.a.InterfaceC0041a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        com.baidu.tieba.frs.f.i.a(this, i, strArr, iArr);
    }

    public void jF(boolean z) {
        if (this.fpn != null) {
            this.fpn.kc(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.fpo.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a lX(int i) {
        return this.fpo.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        this.fpy.b(bVar);
    }

    public boolean bko() {
        return this.foE;
    }

    @Override // com.baidu.tieba.frs.ae
    public void aHL() {
        if (this.foQ != null) {
            showFloatingView();
            this.foQ.getListView().scrollToPosition(0);
            this.foQ.startPullRefresh();
        }
    }

    public ForumWriteData bkp() {
        if (this.fot == null || this.fot.getForum() == null) {
            return null;
        }
        ForumData forum = this.fot.getForum();
        ForumWriteData forumWriteData = new ForumWriteData(forum.getId(), forum.getName(), forum.getPrefixData(), this.fot.getAnti());
        forumWriteData.avatar = forum.getImage_url();
        forumWriteData.forumLevel = forum.getUser_level();
        forumWriteData.specialForumType = forum.special_forum_type;
        forumWriteData.firstDir = forum.getFirst_class();
        forumWriteData.secondDir = forum.getSecond_class();
        UserData userData = this.fot.getUserData();
        forumWriteData.privateThread = userData != null ? userData.getPrivateThread() : 0;
        return forumWriteData;
    }

    @Override // com.baidu.tieba.frs.ae
    public void ajG() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.frs.ae
    public void setVideoThreadId(String str) {
    }

    public void jG(boolean z) {
        this.fpe = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z) {
        super.showLoadingView(view, z);
        this.foQ.rf(8);
        ((FrsActivity) getActivity()).i(view, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        super.hideLoadingView(view);
        this.foQ.rf(0);
        ((FrsActivity) getActivity()).i(view, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        super.showNetRefreshView(view, str, z);
        this.foQ.rf(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshViewNoClick(View view, String str, boolean z) {
        super.showNetRefreshViewNoClick(view, str, z);
        this.foQ.rf(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        super.hideNetRefreshView(view);
        this.foQ.rf(0);
    }

    public void bkq() {
        FrsTabViewController.b bqN;
        if (this.fpj != null && (bqN = this.fpj.bqN()) != null && bqN.fragment != null && (bqN.fragment instanceof ag)) {
            ((ag) bqN.fragment).bjy();
        }
    }

    public void jH(boolean z) {
        this.foG = z;
    }

    public void b(OvalActionButton ovalActionButton) {
        this.foR = ovalActionButton;
    }

    public OvalActionButton bkr() {
        return this.foR;
    }

    public boolean bks() {
        return this.foG;
    }

    public void wq(String str) {
        if (TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.util.ap.isEmpty(str)) {
            if (this.fpL == null) {
                this.fpL = new AddExperiencedModel(getTbPageContext());
                this.fpL.a(this.fpR);
            }
            this.fpL.ed(this.forumId, str);
        }
    }

    public boolean bkt() {
        if (this.fpe && !this.fpO) {
            return (this.fph != null && this.fph.bpf() && com.baidu.tieba.frs.a.biW().biX()) ? false : true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.e.c
    public boolean videoNeedPreload() {
        if (this.fot != null) {
            return com.baidu.tbadk.util.ad.avy() && (this.fot.isFrsVideoAutoPlay || com.baidu.tbadk.core.sharedPref.b.agM().getInt("auto_play_video_frs", 0) == 1);
        }
        return super.videoNeedPreload();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bku() {
        if (!com.baidu.tbadk.core.util.ap.isEmpty(this.forumId)) {
            com.baidu.tbadk.BdToken.c.Yk().l(com.baidu.tbadk.BdToken.b.bwX, com.baidu.adp.lib.g.b.c(this.forumId, 0L));
        }
    }
}
