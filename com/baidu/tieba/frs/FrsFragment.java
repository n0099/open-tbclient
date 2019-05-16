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
    public static com.baidu.tieba.tbadkCore.j foT;
    private com.baidu.tbadk.util.w cBS;
    private com.baidu.adp.lib.e.b<TbImageView> cbP;
    private com.baidu.tieba.frs.gametab.b dyW;
    private com.baidu.tbadk.core.dialog.a ezP;
    private com.baidu.tieba.frs.entelechy.a foB;
    private com.baidu.tieba.tbadkCore.data.f foL;
    private VoiceManager foO;
    private OvalActionButton foQ;
    private FRSRefreshButton foR;
    private View.OnTouchListener fpA;
    private com.baidu.tieba.frs.view.a fpB;
    private com.baidu.tieba.frs.view.c fpC;
    private com.baidu.tieba.frs.vc.e fpD;
    private boolean fpE;
    private com.baidu.tieba.NEGFeedBack.a fpG;
    private com.baidu.tieba.ala.a fpH;
    private com.baidu.tieba.frs.brand.buttommenu.a fpI;
    private com.baidu.tieba.frs.sportspage.notification.a fpJ;
    private AddExperiencedModel fpK;
    private boolean fpM;
    private int fpX;
    private com.baidu.card.z fpf;
    private FrsModelController fpg;
    private com.baidu.tieba.frs.vc.f fph;
    private FrsTabViewController fpi;
    private com.baidu.tieba.frs.mc.h fpj;
    private com.baidu.tieba.frs.smartsort.a fpk;
    private com.baidu.tieba.frs.mc.b fpl;
    private ak fpm;
    private com.baidu.tieba.frs.entelechy.b.b fpo;
    private com.baidu.tbadk.k.a fpp;
    private com.baidu.tieba.frs.vc.a fpq;
    private com.baidu.tieba.frs.mc.d fpr;
    private com.baidu.tieba.frs.mc.c fpt;
    private com.baidu.tieba.frs.vc.h fpu;
    private com.baidu.tieba.frs.mc.a fpv;
    private com.baidu.tieba.frs.live.a fpw;
    private j fpx;
    public com.baidu.tieba.frs.vc.c fpy;
    private com.baidu.tieba.frs.mc.e fpz;
    private View mRootView;
    public static boolean foG = false;
    public static volatile long foV = 0;
    public static volatile long foW = 0;
    public static volatile int foX = 0;
    public boolean foC = false;
    private boolean foD = false;
    private boolean foE = false;
    private boolean foF = true;
    public String foH = null;
    public String mFrom = null;
    public int mFlag = 0;
    public boolean foI = false;
    private boolean foJ = false;
    private String mThreadId = null;
    public String forumId = null;
    private int fou = 0;
    private boolean foK = false;
    private boolean foM = false;
    private boolean foN = false;
    private k foP = null;
    private boolean foS = false;
    public final bg cbg = null;
    private FrsViewData fos = new FrsViewData();
    public long eSl = -1;
    public long cyE = 0;
    public long cyw = 0;
    public long createTime = 0;
    public long beginTime = -1;
    public long foU = 0;
    public boolean foY = false;
    private boolean foZ = false;
    private boolean fpa = false;
    public com.baidu.tbadk.p.b fpb = null;
    private boolean fpc = true;
    private boolean fpd = true;
    private a.C0038a fpe = new a.C0038a(2);
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> fpn = new SparseArray<>();
    private boolean dnJ = true;
    private boolean fpF = false;
    private boolean hasInit = false;
    private boolean fpL = false;
    private boolean fpN = false;
    private AlphaAnimation fpO = null;
    private AlphaAnimation fpP = null;
    private AddExperiencedModel.a fpQ = new AddExperiencedModel.a() { // from class: com.baidu.tieba.frs.FrsFragment.1
        @Override // com.baidu.tieba.share.AddExperiencedModel.a
        public void a(ContriInfo contriInfo) {
        }
    };
    private HttpMessageListener fpR = new HttpMessageListener(CmdConfigHttp.CMD_PB_FLOOR_AGREE, true) { // from class: com.baidu.tieba.frs.FrsFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof PbFloorAgreeResponseMessage)) {
                PbFloorAgreeResponseMessage pbFloorAgreeResponseMessage = (PbFloorAgreeResponseMessage) httpResponsedMessage;
            }
        }
    };
    private final CustomMessageListener fpS = new CustomMessageListener(2016495) { // from class: com.baidu.tieba.frs.FrsFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof bg) {
                    com.baidu.tieba.frs.f.h.a(FrsFragment.this.foP, FrsFragment.this.fos, FrsFragment.this.getForumId(), true, (bg) data);
                }
            }
        }
    };
    private CustomMessageListener fpT = new CustomMessageListener(2921005) { // from class: com.baidu.tieba.frs.FrsFragment.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.fos != null) {
                FrsFragment.this.fos.removeGameRankListFromThreadList();
                if (FrsFragment.this.foP != null) {
                    FrsFragment.this.foP.Ve();
                }
            }
        }
    };
    private CustomMessageListener VO = new CustomMessageListener(2921401) { // from class: com.baidu.tieba.frs.FrsFragment.41
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && FrsFragment.this.foR != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() <= 0 || FrsFragment.this.fpi.bqN() == 0 || FrsFragment.this.fpi.bqK() == null || !(FrsFragment.this.fpi.bqK().fragment instanceof BaseFragment) || !((BaseFragment) FrsFragment.this.fpi.bqK().fragment).isPrimary()) {
                    if (FrsFragment.this.fpi.bqN() != 0) {
                        FrsFragment.this.bkh();
                        return;
                    }
                    return;
                }
                FrsFragment.this.bki();
            }
        }
    };
    private CustomMessageListener fpU = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.FrsFragment.42
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 1) {
                    FrsFragment.this.bjZ();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                }
            }
        }
    };
    private final ai fpV = new ai() { // from class: com.baidu.tieba.frs.FrsFragment.43
        @Override // com.baidu.tieba.frs.ai
        public void a(int i, int i2, ap apVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
            FrsFragment.this.bjP();
            if (FrsFragment.this.fpo != null) {
                FrsFragment.this.fph.kE(FrsFragment.this.fpo.rD(i));
            }
            e.b bVar = new e.b();
            if (apVar != null) {
                bVar.isSuccess = apVar.errCode == 0;
                bVar.errorCode = apVar.errCode;
                bVar.errorMsg = apVar.errMsg;
                if (bVar.isSuccess) {
                    if (com.baidu.tbadk.core.util.v.aa(arrayList)) {
                        FrsFragment.this.foP.aIG();
                    } else if (apVar.hasMore) {
                        if (com.baidu.tbadk.core.util.v.Z(FrsFragment.this.fos.getThreadList()) > 3) {
                            FrsFragment.this.foP.aIE();
                        } else {
                            FrsFragment.this.foP.bld();
                        }
                    } else if (apVar.fte) {
                        FrsFragment.this.foP.aIF();
                    } else {
                        FrsFragment.this.foP.aIG();
                    }
                }
            } else {
                apVar = new ap();
                apVar.pn = 1;
                apVar.hasMore = false;
                apVar.fte = false;
            }
            if (i == 1) {
                FrsFragment.this.fpc = true;
                FrsFragment.this.fqj.a(FrsFragment.this.fpg.getType(), false, bVar);
            } else {
                FrsFragment.this.a(bVar);
                if (FrsFragment.this.fpg.boF() != null) {
                    FrsFragment.this.fos = FrsFragment.this.fpg.boF();
                }
                FrsFragment.this.bkb();
            }
            if (FrsFragment.this.fqq != null) {
                FrsFragment.this.fqq.a(i, i2, apVar, arrayList);
            }
        }
    };
    private FrsTabViewController.a fpW = new FrsTabViewController.a() { // from class: com.baidu.tieba.frs.FrsFragment.44
        @Override // com.baidu.tieba.frs.vc.FrsTabViewController.a
        public void ku(int i) {
            boolean z = false;
            if (i != 1) {
                com.baidu.tieba.card.t.aXM().iv(false);
                FrsFragment.this.jC(false);
            }
            if (i == 303 && i != FrsFragment.this.fpX) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13121").bT("fid", FrsFragment.this.forumId).bT("uid", TbadkCoreApplication.getCurrentAccount()));
            }
            if (i == 502) {
                FrsFragment.this.foQ.setIconFade(R.drawable.btn_frs_professional_edit_n);
            } else {
                FrsFragment.this.foQ.setIconFade(0);
            }
            FrsFragment.this.fpX = i;
            FrsFragment.this.bke();
            com.baidu.tieba.frs.d.d.fxk.fJF = i;
            com.baidu.tieba.frs.d.d.fxk.fJG = -1;
            com.baidu.tieba.frs.a biT = com.baidu.tieba.frs.a.biT();
            if (i == 1 && FrsFragment.this.fpL) {
                z = true;
            }
            biT.A(z, true);
        }
    };
    private CustomMessageListener fpY = new CustomMessageListener(2001606) { // from class: com.baidu.tieba.frs.FrsFragment.45
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                FrsFragment.this.fpi.sI(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    };
    private CustomMessageListener fpZ = new CustomMessageListener(2001607) { // from class: com.baidu.tieba.frs.FrsFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && ((Integer) customResponsedMessage.getData()).intValue() == 51 && FrsFragment.this.fos != null) {
                com.baidu.tieba.frs.f.j.a(FrsFragment.this.fos, FrsFragment.this.getPageContext());
            }
        }
    };
    private final CustomMessageListener fqa = new CustomMessageListener(2003019) { // from class: com.baidu.tieba.frs.FrsFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                FrsFragment.this.fpi.sG(49);
            }
        }
    };
    private final CustomMessageListener fqb = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.frs.FrsFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && FrsFragment.this.fos != null && FrsFragment.this.fos.getForum() != null) {
                SignData signData = (SignData) customResponsedMessage.getData();
                int user_level = FrsFragment.this.fos.getForum().getUser_level();
                if (signData.forumId != null && signData.forumId.equals(FrsFragment.this.fos.getForum().getId())) {
                    FrsFragment.this.fos.updateSignData(signData);
                    FrsFragment.this.fph.j(FrsFragment.this.fos);
                    if (FrsFragment.this.fph.bqy()) {
                        i = FrsFragment.this.fos.getForum().getUser_level();
                        if (user_level >= i) {
                            i++;
                        }
                    } else {
                        i = user_level;
                    }
                    TbadkCoreApplication.getInst().addSignedForum(FrsFragment.this.fos.getForum().getName(), signData.sign_bonus_point, i);
                }
            }
        }
    };
    private final CustomMessageListener fqc = new CustomMessageListener(2001352) { // from class: com.baidu.tieba.frs.FrsFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.r) && FrsFragment.this.fos != null) {
                FrsFragment.this.fos.updateLikeData((com.baidu.tieba.tbadkCore.r) customResponsedMessage.getData());
                FrsFragment.this.fph.i(FrsFragment.this.fos);
                FrsFragment.this.fpi.a(FrsFragment.this.fos, FrsFragment.this.fpg.bpg());
            }
        }
    };
    private final AntiHelper.a fqd = new AntiHelper.a() { // from class: com.baidu.tieba.frs.FrsFragment.6
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12536").P("obj_locate", at.a.bTc));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12535").P("obj_locate", at.a.bTc));
        }
    };
    private CustomMessageListener dnU = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.frs.FrsFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(FrsFragment.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().cgz != null) {
                        if (AntiHelper.a(FrsFragment.this.getActivity(), updateAttentionMessage.getData().cgz, FrsFragment.this.fqd) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12534").P("obj_locate", at.a.bTc));
                        }
                    } else if (updateAttentionMessage.getData().Hi && updateAttentionMessage.getData().isAttention) {
                        com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getPageContext().getPageActivity(), (int) R.string.attention_success);
                    }
                }
            }
        }
    };
    private CustomMessageListener fqe = new CustomMessageListener(2921346) { // from class: com.baidu.tieba.frs.FrsFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsFragment.this.refresh();
        }
    };
    private CustomMessageListener fqf = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.frs.FrsFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                FrsFragment.this.foP.c((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener fqg = new CustomMessageListener(2001626) { // from class: com.baidu.tieba.frs.FrsFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewsRemindMessage newsRemindMessage;
            if (customResponsedMessage != null && (customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626 && (newsRemindMessage = (NewsRemindMessage) customResponsedMessage) != null) {
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (FrsFragment.this.foP != null) {
                    FrsFragment.this.foP.B(notificationCount, z);
                }
            }
        }
    };
    private final CustomMessageListener fqh = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.frs.FrsFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.isResumed()) {
                FrsFragment.this.bkr();
            }
        }
    };
    private CustomMessageListener fqi = new CustomMessageListener(2003020) { // from class: com.baidu.tieba.frs.FrsFragment.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (FrsFragment.this.foP != null) {
                    FrsFragment.this.foP.setExpanded(booleanValue);
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.n fqj = new com.baidu.tieba.tbadkCore.n() { // from class: com.baidu.tieba.frs.FrsFragment.14
        private long startTime = 0;

        @Override // com.baidu.tieba.tbadkCore.n
        public void ra(int i) {
            this.startTime = System.nanoTime();
            if (FrsFragment.this.foP != null) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsFragment.this.foP.bkN();
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
            if (FrsFragment.this.dnJ) {
                FrsFragment.this.dnJ = false;
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.foP, FrsFragment.this.fos, FrsFragment.this.getForumId(), false, null);
            }
            FrsFragment.this.bjP();
            FrsFragment.this.foZ = true;
            if (bVar != null && bVar.isSuccess) {
                FrsFragment.this.foP.bkZ().ko(com.baidu.tbadk.core.util.ar.ail().ain());
                FrsFragment.foV = 0L;
                FrsFragment.foW = 0L;
                FrsFragment.foX = 0;
            } else {
                FrsFragment.foX = 1;
            }
            if (!FrsFragment.this.fpg.bpk() && (i == 3 || i == 6)) {
                FrsFragment.this.fpt.resetData();
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (FrsFragment.this.fpg.boF() != null) {
                FrsFragment.this.fos = FrsFragment.this.fpg.boF();
            }
            FrsFragment.this.foP.b(FrsFragment.this.fos.getRedpacketRainData());
            FrsFragment.this.qW(1);
            if (i == 7) {
                FrsFragment.this.qX(FrsFragment.this.fos.getFrsDefaultTabId());
                return;
            }
            if (FrsFragment.this.fos.getPage() != null) {
                FrsFragment.this.setHasMore(FrsFragment.this.fos.getPage().acp());
            }
            if (i == 4) {
                if (!FrsFragment.this.fpg.bpk() && TbadkCoreApplication.getInst().isRecAppExist() && FrsFragment.this.fpg.bpb() == 1) {
                    FrsFragment.this.fos.addRecommendAppToThreadList(FrsFragment.this);
                }
                ArrayList<com.baidu.adp.widget.ListView.m> a2 = FrsFragment.this.fpt.a(false, false, FrsFragment.this.fos.getThreadList(), FrsFragment.this.foL, false);
                if (a2 != null) {
                    FrsFragment.this.fos.setThreadList(a2);
                    FrsFragment.this.fos.checkLiveStageInThreadList();
                }
                if (FrsFragment.this.fpg != null) {
                    com.baidu.tieba.frs.d.c.a(FrsFragment.this.fos, FrsFragment.this.fpg.bpg(), 2);
                }
                com.baidu.tieba.frs.f.a.a(FrsFragment.this, FrsFragment.this.fos.getForum(), FrsFragment.this.fos.getThreadList(), false, FrsFragment.this.getPn());
                FrsFragment.this.cyE = System.currentTimeMillis() - currentTimeMillis;
                FrsFragment.this.foP.a(a2, FrsFragment.this.fos);
                FrsFragment.this.bjQ();
                return;
            }
            FrsFragment.this.bjQ();
            switch (i) {
                case 1:
                    FrsFragment.this.foP.bkN();
                    break;
                case 2:
                    FrsFragment.this.foP.bkN();
                    break;
                case 3:
                case 6:
                    if (FrsFragment.this.fos != null) {
                        FrsFragment.this.fos.clearPostThreadCount();
                    }
                    if (FrsFragment.this.fpy != null) {
                        FrsFragment.this.fpy.refresh();
                        break;
                    }
                    break;
            }
            FrsFragment.this.bjU();
            if (bVar == null || bVar.errorCode == 0) {
                if (FrsFragment.this.fos != null) {
                    FrsFragment.this.D(false, i == 5);
                    if (FrsFragment.this.fpg != null) {
                        if (FrsFragment.this.fos.getActivityHeadData() != null && FrsFragment.this.fos.getActivityHeadData().abJ() != null && FrsFragment.this.fos.getActivityHeadData().abJ().size() > 0) {
                            com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), 1, FrsFragment.this.fos.getForum(), FrsFragment.this.fpg.getSortType(), 1);
                        }
                        if (FrsFragment.this.fos.getThreadList() != null && FrsFragment.this.fos.getThreadList().size() > 0) {
                            Iterator<com.baidu.adp.widget.ListView.m> it = FrsFragment.this.fos.getThreadList().iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    com.baidu.adp.widget.ListView.m next = it.next();
                                    if ((next instanceof bg) && ((bg) next).getType() == bg.bJU) {
                                        com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), 1, FrsFragment.this.fos.getForum(), FrsFragment.this.fpg.getSortType(), 2);
                                    }
                                }
                            }
                        }
                        com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), FrsFragment.this.fos.getThreadList(), FrsFragment.this.fos.getForum(), FrsFragment.this.fpg.getSortType());
                    }
                    FrsFragment.this.foP.rj(i);
                    FrsFragment.foV = (System.nanoTime() - this.startTime) / 1000000;
                    if (bVar != null) {
                        FrsFragment.foW = bVar.iWp;
                    }
                } else {
                    return;
                }
            } else if (FrsFragment.this.fos == null || com.baidu.tbadk.core.util.v.aa(FrsFragment.this.fos.getThreadList())) {
                FrsFragment.this.a(bVar);
            } else if (bVar.eWE) {
                FrsFragment.this.showToast(FrsFragment.this.getPageContext().getResources().getString(R.string.net_error_text, bVar.errorMsg, Integer.valueOf(bVar.errorCode)));
            }
            FrsFragment.this.bjR();
            FrsFragment.this.bjS();
            if (FrsFragment.this.fos.getAccessFlag() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11384"));
            }
            if (FrsFragment.this.eSl > -1 && !FrsFragment.this.fpF) {
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.fpg, FrsFragment.this.eSl);
                FrsFragment.this.eSl = -1L;
                FrsFragment.this.fpF = true;
            }
            if (FrsFragment.this.foM && FrsFragment.this.fpi.sG(49)) {
                FrsFragment.this.foM = false;
            }
            FrsFragment.this.cyE = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void b(com.baidu.tieba.tbadkCore.j jVar) {
            if ((jVar != null && ("normal_page".equals(FrsFragment.this.fpg.getPageType()) || "frs_page".equals(FrsFragment.this.fpg.getPageType()) || "book_page".equals(FrsFragment.this.fpg.getPageType()))) || "brand_page".equals(FrsFragment.this.fpg.getPageType())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001615, jVar));
                FrsFragment.this.a(jVar);
                FrsFragment.foT = jVar;
            }
        }
    };
    private final CustomMessageListener fqk = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.frs.FrsFragment.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                FrsFragment.this.fos.updateCurrentUserPendant((com.baidu.tbadk.data.l) customResponsedMessage.getData());
                FrsFragment.this.foP.bkZ().notifyDataSetChanged();
            }
        }
    };
    private final CustomMessageListener mMemListener = new CustomMessageListener(2001194) { // from class: com.baidu.tieba.frs.FrsFragment.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && FrsFragment.this.fos != null && (userData = FrsFragment.this.fos.getUserData()) != null) {
                userData.setIsMem(num.intValue());
                if (num.intValue() != 0) {
                    FrsFragment.this.fph.h(num);
                }
            }
        }
    };
    private final com.baidu.tieba.frs.mc.k fql = new com.baidu.tieba.frs.mc.k() { // from class: com.baidu.tieba.frs.FrsFragment.26
        @Override // com.baidu.tieba.frs.mc.k
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.m> arrayList, boolean z3) {
            if (FrsFragment.this.fpk != null && FrsFragment.this.fpg != null && FrsFragment.this.fpg.bpk() && z && !z2 && !z3) {
                FrsFragment.this.fpk.sj(i2);
            }
        }
    };
    public final View.OnTouchListener clb = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.FrsFragment.27
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (FrsFragment.this.fpA != null) {
                FrsFragment.this.fpA.onTouch(view, motionEvent);
            }
            if (FrsFragment.this.fpm != null && FrsFragment.this.fpm.blI() != null) {
                FrsFragment.this.fpm.blI().onTouchEvent(motionEvent);
            }
            if (FrsFragment.this.dyW != null) {
                FrsFragment.this.dyW.f(view, motionEvent);
            }
            if (FrsFragment.this.fph != null) {
                FrsFragment.this.fph.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private final CustomMessageListener fqm = new CustomMessageListener(2004507) { // from class: com.baidu.tieba.frs.FrsFragment.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.agM().getInt(TbadkCoreApplication.getCurrentAccount() + "photolive_hostLevel", -1) != -1 && FrsFragment.this.fos.getForum() != null) {
                FrsFragment.this.fos.getForum().setCanAddPhotoLivePost(true);
            }
        }
    };
    public final View.OnClickListener fqn = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.30
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsFragment.this.foP == null || view != FrsFragment.this.foP.bkL() || FrsFragment.this.getActivity() == null) {
                if (FrsFragment.this.fos != null && FrsFragment.this.fos.getForum() != null && FrsFragment.this.foP != null && view == FrsFragment.this.foP.bkR()) {
                    if (FrsFragment.this.fpC == null) {
                        FrsFragment.this.fpC = new com.baidu.tieba.frs.view.c(FrsFragment.this.getPageContext());
                    }
                    FrsFragment.this.fpC.m(FrsFragment.this.fos);
                    FrsFragment.this.fpC.showDialog();
                    return;
                }
                if (view.getId() == R.id.game_activity_egg_layout && com.baidu.adp.lib.util.l.ki()) {
                    TiebaStatic.log("c10853");
                    if (FrsFragment.this.foP.bkW()) {
                        FrsFragment.this.foP.bkX();
                    } else {
                        String activityUrl = FrsFragment.this.fos.getForum().getYuleData().afA().getActivityUrl();
                        if (!StringUtils.isNull(activityUrl)) {
                            com.baidu.tbadk.browser.a.ag(FrsFragment.this.getPageContext().getPageActivity(), activityUrl);
                        }
                    }
                }
                if (view == FrsFragment.this.foP.ble() && FrsFragment.this.fpg != null && FrsFragment.this.fpg.hasMore()) {
                    FrsFragment.this.foP.aIE();
                    FrsFragment.this.aHq();
                }
                if (view != null && view == FrsFragment.this.foP.bkT() && bc.cE(FrsFragment.this.getContext())) {
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
        private int fqz = 0;
        private int dkC = 0;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (FrsFragment.this.fpq != null) {
                FrsFragment.this.fpq.bpY();
            }
            this.fqz = 0;
            this.dkC = 0;
            if (recyclerView != null && (recyclerView instanceof BdRecyclerView)) {
                this.fqz = ((BdRecyclerView) recyclerView).getFirstVisiblePosition();
                this.dkC = ((BdRecyclerView) recyclerView).getLastVisiblePosition();
            }
            if (FrsFragment.this.fpD != null) {
                FrsFragment.this.fpD.a(recyclerView, this.fqz, this.dkC);
            }
            if (FrsFragment.this.fos != null && FrsFragment.this.foP != null && FrsFragment.this.foP.bkZ() != null) {
                FrsFragment.this.foP.bn(this.fqz, this.dkC);
                if (FrsFragment.this.fpf != null && FrsFragment.this.fpf.qs() != null) {
                    FrsFragment.this.fpf.qs().b(FrsFragment.this.fpe);
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (FrsFragment.this.fph != null) {
                FrsFragment.this.fph.setScrollState(i);
            }
            if (i == 0) {
                FrsFragment.this.foP.bli();
            }
            if ((i == 2 || i == 1) && !FrsFragment.this.fpa) {
                FrsFragment.this.fpa = true;
                FrsFragment.this.foP.blc();
            }
            if (FrsFragment.this.fpb == null && !FrsFragment.this.bkl()) {
                FrsFragment.this.fpb = new com.baidu.tbadk.p.b();
                FrsFragment.this.fpb.kK(1000);
            }
            if (i == 0) {
                if (FrsFragment.this.fpb != null) {
                    FrsFragment.this.fpb.aub();
                }
                com.baidu.tieba.card.t.aXM().iv(true);
                FrsFragment.this.jC(true);
                FrsFragment.this.foP.bm(this.fqz, this.dkC);
            } else if (FrsFragment.this.fpb != null) {
                FrsFragment.this.fpb.aua();
            }
            if (FrsFragment.this.fpD != null) {
                FrsFragment.this.fpD.onScrollStateChanged(recyclerView, i);
            }
            if (i == 0) {
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.foP, FrsFragment.this.fos, FrsFragment.this.getForumId(), false, null);
            }
            if (FrsFragment.this.fpi != null && i == 1) {
                FrsFragment.this.fpi.bqM();
            }
            if (FrsFragment.this.fpf == null) {
                if (FrsFragment.this.foP.bkE() != null && !FrsFragment.this.foP.bkk() && FrsFragment.this.foP.bkE().cbk() != null && (FrsFragment.this.foP.bkE().cbk().getTag() instanceof com.baidu.card.z)) {
                    FrsFragment.this.fpf = (com.baidu.card.z) FrsFragment.this.foP.bkE().cbk().getTag();
                }
            } else if (i == 0 && FrsFragment.this.foP.bkE() != null && !FrsFragment.this.foP.bkk() && FrsFragment.this.foP.bkE().cbk() != null && (FrsFragment.this.foP.bkE().cbk().getTag() instanceof com.baidu.card.z)) {
                FrsFragment.this.fpf = (com.baidu.card.z) FrsFragment.this.foP.bkE().cbk().getTag();
            }
            if (i == 1) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921418));
            }
        }
    };
    private final d fqo = new d() { // from class: com.baidu.tieba.frs.FrsFragment.32
        @Override // com.baidu.tieba.frs.d
        public void a(int i, int i2, View view, View view2, bg bgVar) {
            if (i != FrsFragment.this.foP.bkZ().bmU()) {
                if (i != FrsFragment.this.foP.bkZ().bmV()) {
                    if (i == FrsFragment.this.foP.bkZ().bmS() && FrsFragment.this.fos != null && FrsFragment.this.fos.getUserData() != null && FrsFragment.this.fos.getUserData().isBawu()) {
                        String bawuCenterUrl = FrsFragment.this.fos.getBawuCenterUrl();
                        if (!com.baidu.tbadk.core.util.ap.isEmpty(bawuCenterUrl) && FrsFragment.this.fos.getForum() != null) {
                            com.baidu.tbadk.browser.a.af(FrsFragment.this.getPageContext().getPageActivity(), bawuCenterUrl);
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10502").bT("fid", FrsFragment.this.fos.getForum().getId()).bT("uid", FrsFragment.this.fos.getUserData().getUserId()));
                        }
                    }
                } else if (bc.cE(FrsFragment.this.getPageContext().getPageActivity())) {
                    TiebaStatic.log("my_service_ck");
                    if (FrsFragment.this.fos != null && FrsFragment.this.fos.getForum() != null) {
                        ForumData forum = FrsFragment.this.fos.getForum();
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(forum.getId(), 0L), forum.getName(), forum.getImage_url(), 0)));
                    }
                }
            } else if (bc.cE(FrsFragment.this.getActivity())) {
                TiebaStatic.log("forum_fortune_click");
                com.baidu.tieba.frs.f.i.b(FrsFragment.this.getPageContext(), FrsFragment.this.fos);
            }
        }
    };
    private final NoNetworkView.a fmu = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.FrsFragment.33
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void el(boolean z) {
            if (FrsFragment.this.fpg.bpb() == 1 && z && !FrsFragment.this.foP.bkk()) {
                if (FrsFragment.this.fos == null || com.baidu.tbadk.core.util.v.aa(FrsFragment.this.fos.getThreadList())) {
                    FrsFragment.this.hideNetRefreshView(FrsFragment.this.foP.bla());
                    FrsFragment.this.showLoadingView(FrsFragment.this.foP.bla(), true);
                    FrsFragment.this.foP.jN(false);
                    FrsFragment.this.refresh();
                    return;
                }
                FrsFragment.this.foP.bkN();
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
                com.baidu.tieba.frs.f.c.a(customResponsedMessage, FrsFragment.this.foP, FrsFragment.this.fos);
            }
        }
    };
    private com.baidu.adp.widget.ListView.s fqp = new a();
    private ai fqq = new ai() { // from class: com.baidu.tieba.frs.FrsFragment.37
        @Override // com.baidu.tieba.frs.ai
        public void a(int i, int i2, ap apVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
            com.baidu.adp.lib.g.e.iB().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.37.1
                @Override // java.lang.Runnable
                public void run() {
                    if (FrsFragment.this.foP != null && FrsFragment.this.foP.aYK()) {
                        FrsFragment.this.aHq();
                    }
                }
            });
        }
    };
    private CustomMessageListener fqr = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.frs.FrsFragment.38
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    FrsFragment.this.fpE = true;
                }
            }
        }
    };
    private CustomMessageListener fqs = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.frs.FrsFragment.39
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                    if (FrsFragment.this.fpf == null && FrsFragment.this.foP.bkE() != null && !FrsFragment.this.foP.bkk() && FrsFragment.this.foP.bkE().cbk() != null && (FrsFragment.this.foP.bkE().cbk().getTag() instanceof com.baidu.card.z)) {
                        FrsFragment.this.fpf = (com.baidu.card.z) FrsFragment.this.foP.bkE().cbk().getTag();
                    }
                    if (FrsFragment.this.fpf != null && FrsFragment.this.fpf.qs() != null) {
                        FrsFragment.this.fpf.qs().b(new a.C0038a(3));
                    }
                }
            }
        }
    };
    private CustomMessageListener fqt = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.FrsFragment.40
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.foP != null) {
                FrsFragment.this.foP.blk();
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.frs.loadmore.a
    public /* bridge */ /* synthetic */ com.baidu.adp.base.e getPageContext() {
        return super.getPageContext();
    }

    public com.baidu.tieba.frs.entelechy.b.b bjD() {
        return this.fpo;
    }

    public com.baidu.adp.widget.ListView.s bjE() {
        return this.fqp;
    }

    public com.baidu.tieba.frs.mc.d bjF() {
        return this.fpr;
    }

    public com.baidu.tieba.frs.smartsort.a bjG() {
        return this.fpk;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public FrsModelController bjH() {
        return this.fpg;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public com.baidu.tieba.frs.mc.c bjI() {
        return this.fpt;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public com.baidu.tieba.frs.vc.f bjJ() {
        return this.fph;
    }

    public FrsTabViewController bjK() {
        return this.fpi;
    }

    public ak bjL() {
        return this.fpm;
    }

    public void jB(boolean z) {
        this.fpN = z;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public k bjM() {
        return this.foP;
    }

    @Override // com.baidu.tieba.frs.aj
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.aj, com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.foH;
    }

    public void setForumName(String str) {
        this.foH = str;
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
        if (this.fpt == null) {
            return 1;
        }
        return this.fpt.getPn();
    }

    public int getPn() {
        if (this.fpt == null) {
            return 1;
        }
        return this.fpt.getPn();
    }

    public void setPn(int i) {
        if (this.fpt != null) {
            this.fpt.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.fpt != null) {
            this.fpt.setHasMore(i);
        }
    }

    public int bjN() {
        if (this.fpt == null) {
            return -1;
        }
        return this.fpt.bjN();
    }

    public boolean bjO() {
        return this.foN;
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
            this.foP.bkH();
            showNetRefreshView(this.foP.bla(), string, true);
        } else if (340001 == bVar.errorCode) {
            a(bVar, this.fos.getRecm_forum_list());
        } else {
            if (com.baidu.tbadk.core.util.v.aa(this.fos.getThreadList())) {
                b(bVar);
            }
            if (bkl()) {
                setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst(), R.dimen.ds280));
            } else {
                setNetRefreshViewEmotionDefMarginTop();
            }
        }
    }

    public void a(View view, String str, boolean z, List<RecmForumInfo> list) {
        this.foP.bkH();
        this.foP.rf(8);
        if (this.fpB == null) {
            this.fpB = new com.baidu.tieba.frs.view.a(getPageContext(), getNetRefreshListener());
        }
        this.fpB.qx(str);
        this.fpB.co(list);
        this.fpB.attachView(view, z);
    }

    private void a(e.b bVar, List<RecmForumInfo> list) {
        if (this.foP != null) {
            this.foP.bkH();
            this.foP.setTitle(this.foH);
            a(this.foP.bla(), bVar.errorMsg, true, list);
        }
    }

    private void b(e.b bVar) {
        this.foP.bkH();
        if (bVar.eWE) {
            showNetRefreshView(this.foP.bla(), TbadkCoreApplication.getInst().getString(R.string.net_error_text, new Object[]{bVar.errorMsg, Integer.valueOf(bVar.errorCode)}), true);
        } else {
            showNetRefreshView(this.foP.bla(), bVar.errorMsg, true);
        }
    }

    public void bjP() {
        hideLoadingView(this.foP.bla());
        this.foP.jP(false);
        if (this.foP.bkF() instanceof com.baidu.tieba.frs.tab.c) {
            ((com.baidu.tieba.frs.tab.c) this.foP.bkF()).bpD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjQ() {
        if (bjN() == 0 && com.baidu.tbadk.core.util.v.aa(this.fos.getThreadListIds())) {
            if (com.baidu.tbadk.core.util.v.aa(this.fos.getThreadList())) {
                this.foP.aIG();
            } else {
                this.foP.aIF();
            }
        } else if (com.baidu.tbadk.core.util.v.Z(this.fos.getThreadList()) > 3) {
            this.foP.aIE();
        } else {
            this.foP.bld();
        }
    }

    public void a(ErrorData errorData) {
        String stringExtra = getActivity().getIntent().getStringExtra("name");
        if (getActivity().getIntent().getIntExtra(FrsActivityConfig.FRS_CALL_FROM, -1) == 12 && errorData != null && errorData.error_code == 3 && !StringUtils.isNull(stringExtra) && TbadkCoreApplication.isLogin()) {
            sendMessage(new CustomMessage(2002001, new CreateBarGuideActivityConfig(getContext(), stringExtra)));
            getActivity().finish();
            return;
        }
        bjP();
        this.foP.bkN();
        e.b boY = this.fpg.boY();
        boolean aa = com.baidu.tbadk.core.util.v.aa(this.fos.getThreadList());
        if (boY != null && aa) {
            if (this.fpg.boZ() != 0) {
                this.fpg.bpe();
                this.foP.bkN();
            } else {
                a(boY);
            }
            this.foP.E(this.fos.isStarForum(), false);
            return;
        }
        a(boY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjR() {
        boolean b;
        if (!bjT()) {
            final PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
            privateForumPopInfoData.a(this.fos.getPrivateForumTotalInfo().getPrivatePopInfo());
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(getActivity());
            if (this.fos.getPrivateForumTotalInfo().acw().private_forum_status.intValue() == 1 && (com.baidu.tbadk.core.util.ap.isEmpty(privateForumPopInfoData.acy()) || privateForumPopInfoData.acB() != Integer.valueOf(this.forumId))) {
                privateForumPopInfoData.mh("create_success");
                privateForumPopInfoData.mi(TbadkCoreApplication.getInst().getString(R.string.frs_private_create_hint));
                privateForumPopInfoData.mj("https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.foH + "&nomenu=1");
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
    public void bjS() {
        if (bjT() || this.fos.getPrivateForumTotalInfo().acw().private_forum_status.intValue() != 1) {
            a((Integer) null, (Integer) null, true);
        } else {
            a(this.fos.getPrivateForumTotalInfo().acw().private_forum_audit_status, this.fos.getPrivateForumTotalInfo().acx(), false);
        }
    }

    public void a(Integer num, Integer num2, boolean z) {
        final String str;
        final int i = 2;
        if (this.foP.bkS() != null) {
            TextView bkS = this.foP.bkS();
            if (z) {
                bkS.setVisibility(8);
                return;
            }
            if (num.intValue() == 2) {
                bkS.setText("修改实名认证信息");
                bkS.setVisibility(0);
                str = "https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + this.forumId + "&nomenu=1";
            } else if (num2.intValue() >= 0 && num2.intValue() <= 100) {
                bkS.setText("目标已完成" + String.valueOf(num2) + "%");
                bkS.setVisibility(0);
                str = "https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.foH + "&nomenu=1";
                i = 1;
            } else {
                bkS.setVisibility(8);
                i = 0;
                str = "";
            }
            bkS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.17
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

    private boolean bjT() {
        return this.fos == null || !this.fos.isPrivateForum() || this.fos.getPrivateForumTotalInfo() == null || this.fos.getPrivateForumTotalInfo().acw() == null || this.fos.getUserData().getIs_manager() != 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qW(int i) {
        List<WindowToast> list;
        if (TbadkCoreApplication.isLogin() && this.fos != null && (list = this.fos.mWindowToast) != null && list.size() > 0) {
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
    public void bjU() {
        if (this.fos == null || this.fos.getForum() != null) {
            this.foP.bkY();
        } else if (this.fos.getForum().getYuleData() != null && this.fos.getForum().getYuleData().afz()) {
            TiebaStatic.log("c10852");
            this.foP.a(this.fos.getForum().getYuleData().afA());
        } else {
            this.foP.bkY();
        }
    }

    private void C(boolean z, boolean z2) {
        if (this.fpg != null && this.fos != null && this.foP != null && z) {
            if (!this.fpg.bpk() && this.fpg.bpb() == 1) {
                if (!this.fpg.bpi()) {
                    this.fos.addCardVideoInfoToThreadList();
                    this.fos.addVideoInfoToThreadListInTenAndFifteenFloor();
                }
                boolean z3 = false;
                if (this.foP.bkZ().m(com.baidu.tieba.card.data.n.eBs)) {
                    z3 = this.fos.addHotTopicDataToThreadList();
                }
                if (!z3) {
                    this.fos.addFeedForumDataToThreadList();
                }
                if (TbadkCoreApplication.getInst().isRecAppExist()) {
                    this.fos.addRecommendAppToThreadList(this);
                }
                if (!this.foP.bkZ().m(bg.bIx)) {
                    this.fos.removeAlaLiveThreadData();
                }
                this.fos.addSchoolRecommendToThreadList();
            }
            if (!this.foP.bkZ().m(bg.bIx)) {
                this.fos.removeAlaInsertLiveData();
                this.fos.removeAlaStageLiveDat();
            } else {
                this.fos.addInsertLiveDataToThreadList();
                this.fos.addStageLiveDataToThreadList();
            }
            this.fos.checkLiveStageInThreadList();
            this.fos.addNoticeThreadToThreadList();
            if (this.foP.bkZ().m(com.baidu.tieba.h.b.fRt)) {
                this.fos.addGameRankListToThreadList(z2);
            }
            if (TbadkCoreApplication.isLogin() && (!this.fpg.bpk() || this.fpg.isNetFirstLoad)) {
                this.fos.addUserRecommendToThreadList();
            }
            this.fos.addVideoActivityToTop();
        }
    }

    public boolean bjV() {
        if (this.fph != null && this.fpg != null) {
            this.fph.a(this.fpg.getPageType(), this.fos);
        }
        boolean z = false;
        if (this.fos != null) {
            z = this.fos.hasTab();
        }
        bjX();
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qX(int i) {
        am amVar = null;
        bjV();
        bke();
        try {
            if (this.fos != null) {
                this.foP.a((ArrayList<com.baidu.adp.widget.ListView.m>) null, this.fos);
                this.fph.sA(1);
                this.foP.bkQ();
                this.fpi.a(this.fos, this.fpg.bpg());
                com.baidu.tieba.frs.tab.d sH = this.fpi.sH(this.fos.getFrsDefaultTabId());
                if (sH != null && !TextUtils.isEmpty(sH.url)) {
                    amVar = new am();
                    amVar.ftb = sH.url;
                    amVar.stType = sH.name;
                }
                this.fpg.a(this.fos.getFrsDefaultTabId(), 0, amVar);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(boolean z, boolean z2) {
        try {
            if (this.fos != null && this.fpi != null && this.fpg != null) {
                if (!this.foP.bkZ().m(bg.bIx)) {
                    this.fos.removeAlaLiveThreadData();
                }
                boolean aa = com.baidu.tbadk.core.util.v.aa(this.fos.getGameTabInfo());
                this.foP.jL(aa);
                if (!aa) {
                    if (this.fpD == null) {
                        this.fpD = new com.baidu.tieba.frs.vc.e(this, (NoPressedRelativeLayout) this.mRootView);
                    }
                    if (this.dyW == null) {
                        this.dyW = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
                    }
                } else {
                    this.fpD = null;
                    this.dyW = null;
                }
                if (this.fos.getForum() != null) {
                    this.foH = this.fos.getForum().getName();
                    this.forumId = this.fos.getForum().getId();
                }
                if (this.fos.hasTab()) {
                    this.fpi.a(this.fos, this.fpg.bpg());
                }
                if (z) {
                    C(true, z);
                } else {
                    C(this.fpc, z);
                }
                bjV();
                if (this.fpo != null) {
                    this.fpo.a(this.fph, this.fos);
                }
                if (this.fos.getPage() != null) {
                    setHasMore(this.fos.getPage().acp());
                }
                ArrayList<com.baidu.adp.widget.ListView.m> a2 = this.fpt.a(z2, true, this.fos.getThreadList(), null, z, false);
                if (a2 != null) {
                    this.fos.setThreadList(a2);
                }
                this.fos.removeRedundantUserRecommendData();
                this.fou = this.fos.getTopThreadSize();
                if (this.foL != null) {
                    this.foK = true;
                    this.foL.Au(this.fou);
                    com.baidu.tieba.frs.f.a.a(this, this.fos.getForum(), this.fos.getThreadList(), this.foK, getPn());
                }
                if (this.fpg.bpb() == 1) {
                    bkb();
                    if (!z && this.fpg.getPn() == 1) {
                        bjW();
                    }
                }
                if (this.fpq != null) {
                    this.fpq.bV(this.fpi.bqJ());
                }
                bjP();
                this.foP.bkI();
                this.foP.E(true, false);
                if (z && this.fos.isFirstTabEqualAllThread()) {
                    com.baidu.adp.lib.g.e.iB().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.18
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!FrsFragment.this.foZ) {
                                FrsFragment.this.foP.blj();
                            }
                        }
                    });
                }
                if (this.fos.getForum() != null) {
                    this.foP.wr(this.fos.getForum().getWarningMsg());
                }
                if (this.fos != null && this.fos.getFrsVideoActivityData() != null && com.baidu.tbadk.core.sharedPref.b.agM().getLong("frs_video_activity_guide", 0L) == 0) {
                    com.baidu.adp.lib.g.e.iB().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.19
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsFragment.this.foP.blg();
                        }
                    }, 1000L);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2921326, this));
                this.foP.bkC();
                if (this.fos != null && this.fos.getForum() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016564, new VisitedForumData(this.fos.getForum().getId(), this.fos.getForum().getName(), this.fos.getForum().getImage_url(), String.valueOf(System.currentTimeMillis() / 1000), "showlive".equals(this.fos.getForum().special_forum_type), this.fos.getForum().getThemeColorInfo(), this.fos.getForum().getMember_num())));
                }
                this.fpI.a(this.fos.bottomMenuList, this.fos.getForum());
                bkr();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void jC(boolean z) {
        com.baidu.tieba.q.c.clt().b(getUniqueId(), z);
    }

    public void bjW() {
        if (this.fpw == null) {
            this.fpw = new com.baidu.tieba.frs.live.a(this, com.baidu.adp.lib.g.b.f(this.forumId, 0));
        }
        this.fpw.boK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.j jVar) {
        try {
            if (!this.foZ && jVar != null && this.fos != null) {
                this.fos.receiveData(jVar);
                D(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void bjX() {
        if (this.fpg != null) {
            wp(this.fpg.getPageType());
        } else {
            wp("normal_page");
        }
    }

    private void wp(String str) {
        jD("frs_page".equals(str));
        if (this.fpo != null) {
            this.fpo.a(this.fph, this.foP, this.fos);
        }
    }

    public void jD(boolean z) {
        if (this.fpu != null) {
            this.fpu.bqD();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.q.c.clt().u(getUniqueId());
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.frs_activity, viewGroup, false);
            this.foB = new com.baidu.tieba.frs.entelechy.a();
            this.fpo = this.foB.bmz();
            this.fph = new com.baidu.tieba.frs.vc.f(this, this.foB, (FrsHeaderViewContainer) this.mRootView.findViewById(R.id.header_view_container));
            this.fpi = new FrsTabViewController(this, this.mRootView);
            this.fpi.registerListener();
            this.fph.a(this.fpi);
            this.fpi.a(this.fpW);
            Intent intent = getActivity().getIntent();
            if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                this.foD = true;
            }
            this.foP = new k(this, this.fqn, this.foB, this.foD, this.fph);
            this.fpI = new com.baidu.tieba.frs.brand.buttommenu.a(getPageContext(), this.mRootView);
        } else {
            if (this.mRootView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            if (this.fpi != null) {
                this.fpi.registerListener();
            }
            this.foP.blf();
            this.mRootView.setLeft(0);
            this.mRootView.setRight(com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst().getContext()));
        }
        this.fpM = true;
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        ArrayList<com.baidu.adp.widget.ListView.m> arrayList = null;
        this.eSl = System.currentTimeMillis();
        this.beginTime = this.eSl;
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.foM = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.eSl = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            af(intent);
        }
        this.cyw = this.beginTime - this.eSl;
        this.foL = new com.baidu.tieba.tbadkCore.data.f("frs", com.baidu.tieba.tbadkCore.data.f.iXY);
        if (this.fpg == null) {
            this.fpg = new FrsModelController(this, this.fqj);
            this.fpg.a(this.fpV);
            this.fpg.init();
        }
        if (intent != null) {
            this.fpg.K(intent.getExtras());
        } else if (bundle != null) {
            this.fpg.K(bundle);
        } else {
            this.fpg.K(null);
        }
        if (intent != null) {
            this.fph.R(intent.getExtras());
        } else if (bundle != null) {
            this.fph.R(bundle);
        } else {
            this.fph.R(null);
        }
        this.foO = getVoiceManager();
        this.fpx = new j(getPageContext(), this);
        initUI();
        initData(bundle);
        if (!bkl()) {
            this.fpm = new ak(getActivity(), this.foP, this.fph);
            this.fpm.kc(true);
        }
        this.foO = getVoiceManager();
        if (this.foO != null) {
            this.foO.onCreate(getPageContext());
        }
        new com.baidu.tieba.frs.mc.i();
        int i = -1;
        if (this.fpt != null && this.fpt.boV() != null) {
            i = this.fpt.boV().bjN();
            arrayList = this.fpt.boV().getDataList();
        }
        this.fpt = new com.baidu.tieba.frs.mc.c(this, this.fql);
        this.fpt.boV().setHasMore(i);
        if (arrayList != null && arrayList.size() > 0) {
            this.fpt.boV().ad(arrayList);
        }
        this.fpk = new com.baidu.tieba.frs.smartsort.a(this);
        this.fpu = new com.baidu.tieba.frs.vc.h(this);
        this.fpq = new com.baidu.tieba.frs.vc.a(getPageContext(), this.fpg.bph());
        this.fpl = new com.baidu.tieba.frs.mc.b(this);
        this.fpr = new com.baidu.tieba.frs.mc.d(this);
        this.fpj = new com.baidu.tieba.frs.mc.h(this);
        this.fpv = new com.baidu.tieba.frs.mc.a(this);
        this.fpy = new com.baidu.tieba.frs.vc.c(this);
        this.fpz = new com.baidu.tieba.frs.mc.e(this, getUniqueId());
        this.fpG = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "frs");
        this.fpH = new com.baidu.tieba.ala.a(getPageContext());
        this.fpJ = new com.baidu.tieba.frs.sportspage.notification.a(getPageContext());
        registerListener(this.dnU);
        registerListener(this.mMemListener);
        registerListener(this.fqc);
        registerListener(this.fqm);
        registerListener(this.fqb);
        registerListener(this.fqk);
        registerListener(this.fpY);
        registerListener(this.fpZ);
        registerListener(this.fqa);
        registerListener(this.fpS);
        registerListener(this.fpT);
        registerListener(this.VO);
        registerListener(this.fqr);
        registerListener(this.fqf);
        registerListener(this.fpU);
        registerListener(this.fqg);
        registerListener(this.fqe);
        this.fpR.setTag(getPageContext().getUniqueId());
        registerListener(this.fpR);
        registerListener(this.fqh);
        registerListener(this.fqi);
        this.fqs.setTag(getPageContext().getUniqueId());
        MessageManager.getInstance().registerListener(this.fqs);
        registerListener(this.fqt);
        this.foP.jN(false);
        if (!bkl() && !this.hasInit) {
            showLoadingView(this.foP.bla(), true);
            this.fpg.D(3, false);
        }
        com.baidu.tieba.frs.a.biT().a(new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.22
            @Override // com.baidu.tieba.frs.a.b
            public void B(boolean z, boolean z2) {
                if (FrsFragment.this.foP != null) {
                    FrsFragment.this.foP.rg(z ? 0 : 8);
                    if (!z2) {
                        FrsFragment.this.fpL = z;
                    }
                    if (FrsFragment.this.foP.bkZ() != null && FrsFragment.this.fpg != null && FrsFragment.this.fpg.bpc()) {
                        FrsFragment.this.foP.bkZ().notifyDataSetChanged();
                    }
                    if (FrsFragment.this.bjK() != null) {
                        FrsTabViewController.b bqK = FrsFragment.this.bjK().bqK();
                        if (bqK != null && bqK.tabId == 502 && (bqK.fragment instanceof FrsCommonTabFragment)) {
                            ((FrsCommonTabFragment) bqK.fragment).bmv();
                        } else if (bqK != null && bqK.tabId == 503 && (bqK.fragment instanceof FrsNewAreaFragment)) {
                            FrsNewAreaFragment frsNewAreaFragment = (FrsNewAreaFragment) bqK.fragment;
                            frsNewAreaFragment.bmv();
                            if (frsNewAreaFragment.bpn() != null) {
                                com.baidu.tieba.frs.mc.g bpn = frsNewAreaFragment.bpn();
                                bpn.jQ(!z);
                                bpn.jR(!z);
                            }
                        }
                        if (FrsFragment.this.bjK().bqE() != null) {
                            FrsFragment.this.bjK().bqE().setmDisallowSlip(z);
                            FrsFragment.this.bjK().kG(z);
                        }
                    }
                    if (FrsFragment.this.foP.bkG() != null) {
                        FrsFragment.this.foP.jK(!z);
                    }
                    if (FrsFragment.this.getActivity() instanceof FrsActivity) {
                        ((FrsActivity) FrsFragment.this.getActivity()).jA(!z);
                    }
                    if (FrsFragment.this.fpI != null) {
                        FrsFragment.this.fpI.kk(!z);
                    }
                    FrsFragment.this.foP.jQ(!z);
                    FrsFragment.this.foP.jR(z ? false : true);
                }
            }

            @Override // com.baidu.tieba.frs.a.b
            public void qT(int i2) {
                if (FrsFragment.this.foP != null) {
                    FrsFragment.this.foP.rh(i2);
                }
            }

            @Override // com.baidu.tieba.frs.a.b
            public void bja() {
                com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getContext(), (int) R.string.frs_multi_delete_max_num);
            }
        });
        this.foP.b(new d.a() { // from class: com.baidu.tieba.frs.FrsFragment.24
            @Override // com.baidu.tieba.NEGFeedBack.d.a
            public void a(DeleteThreadHttpResponseMessage deleteThreadHttpResponseMessage) {
                boolean z;
                int i2 = 0;
                if (deleteThreadHttpResponseMessage != null) {
                    FrsFragment.this.foP.azW();
                    FrsFragment.this.foP.blh();
                    FrsNewAreaFragment frsNewAreaFragment = null;
                    if (FrsFragment.this.fpi == null || FrsFragment.this.fpi.bqK() == null || !(FrsFragment.this.fpi.bqK().fragment instanceof FrsNewAreaFragment)) {
                        z = false;
                    } else {
                        frsNewAreaFragment = (FrsNewAreaFragment) FrsFragment.this.fpi.bqK().fragment;
                        z = true;
                    }
                    if (deleteThreadHttpResponseMessage.getError() == 0) {
                        String text = !TextUtils.isEmpty(deleteThreadHttpResponseMessage.getText()) ? deleteThreadHttpResponseMessage.getText() : FrsFragment.this.getString(R.string.delete_fail);
                        if (deleteThreadHttpResponseMessage.getRetType() == 1211066) {
                            if (FrsFragment.this.ezP == null) {
                                FrsFragment.this.ezP = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.ezP.mE(text);
                            FrsFragment.this.ezP.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.24.1
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.ezP.dN(false);
                            FrsFragment.this.ezP.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.ezP.afG();
                        } else if (deleteThreadHttpResponseMessage.getRetType() == 1211067) {
                            if (FrsFragment.this.ezP == null) {
                                FrsFragment.this.ezP = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.ezP.mE(text);
                            FrsFragment.this.ezP.a(R.string.know, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.24.2
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.ezP.dN(false);
                            FrsFragment.this.ezP.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.ezP.afG();
                        } else {
                            FrsFragment.this.foP.at(deleteThreadHttpResponseMessage.getText(), ContextCompat.getColor(FrsFragment.this.getContext(), deleteThreadHttpResponseMessage.getRetType() == 1 ? R.color.nav_bar_tip_error : R.color.cp_link_tip_a_alpha95));
                        }
                        if (z && frsNewAreaFragment != null) {
                            frsNewAreaFragment.cj(deleteThreadHttpResponseMessage.getSuccessItems());
                        }
                        FrsFragment.this.bX(deleteThreadHttpResponseMessage.getSuccessItems());
                        com.baidu.tieba.frs.a.biT().bW(deleteThreadHttpResponseMessage.getSuccessItems());
                        for (com.baidu.adp.widget.ListView.m mVar : FrsFragment.this.fos.getThreadList()) {
                            if (mVar instanceof bf) {
                                i2++;
                                continue;
                            }
                            if (i2 >= 6) {
                                break;
                            }
                        }
                        if (i2 < 6) {
                            FrsFragment.this.aHq();
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
        if (this.fpi != null) {
            this.fpi.fMW = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bX(List<String> list) {
        if (!com.baidu.tbadk.core.util.v.aa(list)) {
            ArrayList<com.baidu.adp.widget.ListView.m> threadList = this.fos.getThreadList();
            if (!com.baidu.tbadk.core.util.v.aa(threadList) && this.foP.getListView() != null && this.foP.getListView().getData() != null) {
                Iterator<com.baidu.adp.widget.ListView.m> it = threadList.iterator();
                List<com.baidu.adp.widget.ListView.m> data = this.foP.getListView().getData();
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
                                this.fpt.e(next);
                                this.foP.getListView().getAdapter().notifyItemRemoved(i);
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
    public void aHJ() {
        if (isAdded() && this.dnJ && !isLoadingViewAttached()) {
            showLoadingView(this.foP.bla(), true);
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void aHK() {
        if (isAdded() && this.dnJ && isLoadingViewAttached()) {
            hideLoadingView(this.foP.bla());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (bkl()) {
            showLoadingView(this.foP.bla(), true);
            this.foP.ri(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.fpg.D(3, true);
            ajY().scrollToPosition(0);
        }
    }

    private void qY(int i) {
        String str = "";
        if (this.fos != null && this.fos.getForum() != null) {
            str = this.fos.getForum().getId();
        }
        if (!StringUtils.isNull(str)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13008").bT("fid", str).bT("obj_type", "4").P("obj_locate", i).bT("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.x xVar) {
        if (xVar != null) {
            this.cBS = xVar.avn();
            this.fpA = xVar.avo();
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
                this.foH = data.getQueryParameter("name");
                this.mFrom = data.getQueryParameter("from");
                if (!StringUtils.isNull(this.foH)) {
                    intent.putExtra("name", this.foH);
                }
                if (!StringUtils.isNull(this.mFrom)) {
                    intent.putExtra("from", this.mFrom);
                }
                TiebaStatic.log("c10105");
            }
            if (StringUtils.isNull(this.foH) && intent != null && intent.getData() != null) {
                Uri data2 = intent.getData();
                if (com.baidu.tbadk.BdToken.f.m(data2)) {
                    com.baidu.tbadk.BdToken.f.YA().b(data2, new f.a() { // from class: com.baidu.tieba.frs.FrsFragment.25
                        @Override // com.baidu.tbadk.BdToken.f.a
                        public void o(HashMap<String, Object> hashMap) {
                            if (hashMap != null && (hashMap.get(com.baidu.tbadk.BdToken.f.bys) instanceof String)) {
                                FrsFragment.this.foH = (String) hashMap.get(com.baidu.tbadk.BdToken.f.bys);
                            }
                        }
                    });
                } else {
                    com.baidu.tieba.frs.f.d ai = com.baidu.tieba.frs.f.i.ai(intent);
                    if (ai != null) {
                        this.foH = ai.forumName;
                        if (ai.fLt == null || ai.fLt.equals("aidou")) {
                        }
                    }
                }
                if (!StringUtils.isNull(this.foH)) {
                    intent.putExtra("name", this.foH);
                }
                intent.putExtra(FrsActivityConfig.FRS_CALL_FROM, 12);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.foO = getVoiceManager();
        if (this.foO != null) {
            this.foO.onStart(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        Intent intent;
        registerListener(2001118, this.chc);
        if (bundle != null) {
            this.foH = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
            this.foH = intent.getStringExtra("name");
            this.mFrom = intent.getStringExtra("from");
            this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
        }
        if (getArguments() != null) {
            this.foI = getArguments().getBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, false);
        }
        if (TextUtils.isEmpty(this.mFrom) || FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
        }
        if (this.mIsLogin) {
            registerListener(2001120, this.chc);
        }
        this.fph.R(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.q.c.clt().v(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.fqr);
        foT = null;
        if (this.foO != null) {
            this.foO.onDestory(getPageContext());
        }
        com.baidu.tieba.recapp.report.a.remove("FRS");
        this.foO = null;
        com.baidu.tieba.card.t.aXM().iv(false);
        if (this.fos != null && this.fos.getForum() != null) {
            aa.blF().db(com.baidu.adp.lib.g.b.c(this.fos.getForum().getId(), 0L));
        }
        if (this.fpw != null) {
            this.fpw.onDestory();
        }
        if (this.foP != null) {
            com.baidu.tieba.frs.f.h.a(this.foP, this.fos, getForumId(), false, null);
            this.foP.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.fpb != null) {
                this.fpb.auc();
            }
            this.foP.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.fph.onActivityDestroy();
        if (this.fpg != null) {
            this.fpg.aJP();
        }
        if (this.fpm != null) {
            this.fpm.avm();
        }
        if (this.fpp != null) {
            this.fpp.destory();
        }
        if (this.fpq != null) {
            this.fpq.destory();
        }
        if (this.fpk != null) {
            this.fpk.onDestroy();
        }
        if (this.fpD != null) {
            this.fpD.onDestory();
        }
        if (this.fpv != null) {
            this.fpv.onDestroy();
        }
        if (this.fpG != null) {
            this.fpG.onDestroy();
        }
        if (this.fpH != null) {
            this.fpH.onDestroy();
        }
        com.baidu.tieba.recapp.d.a.cfz().cfB();
        com.baidu.tieba.frs.f.j.bpV();
        if (this.fpi != null) {
            this.fpi.a((FrsTabViewController.a) null);
            this.fpi.bqM();
        }
        if (this.fpK != null) {
            this.fpK.onDestroy();
        }
        com.baidu.tieba.frs.a.biT().a(null);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.foH);
        bundle.putString("from", this.mFrom);
        this.fpg.onSaveInstanceState(bundle);
        if (this.foO != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            this.foO.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.fpv != null) {
            this.fpv.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.foP != null) {
            this.foP.bkN();
            this.foP.onResume();
        }
        this.fpj.kz(true);
        this.fpc = true;
        if (foG) {
            foG = false;
            this.foP.startPullRefresh();
            return;
        }
        if (this.foO != null) {
            this.foO.onResume(getPageContext());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921338));
        this.foP.jS(false);
        if (this.fpE) {
            refresh(6);
            this.fpE = false;
        }
        bkr();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
    }

    public boolean bjY() {
        Intent intent;
        if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
            return false;
        }
        return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
    }

    public void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.foH = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.foJ = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.foJ) {
                bjZ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjZ() {
        this.foP.startPullRefresh();
    }

    public void closeActivity() {
        com.baidu.tieba.frs.f.i.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.mFrom);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.foP.setTitle(this.foH);
        } else {
            this.foP.setTitle("");
            this.mFlag = 1;
        }
        this.foP.setOnAdapterItemClickListener(this.fqp);
        this.foP.addOnScrollListener(this.mScrollListener);
        this.foP.h(this.fmu);
        this.foP.bkZ().a(this.fqo);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fpM) {
            this.foP.onChangeSkinType(i);
            this.fph.sz(i);
            this.fpi.onChangeSkinType(i);
            if (this.foR != null) {
                this.foR.onChangeSkinType(i);
            }
            if (this.fpB != null) {
                this.fpB.onChangeSkinType();
            }
            if (this.fpI != null) {
                this.fpI.onChangeSkinType(getPageContext(), i);
            }
            if (this.ezP != null) {
                com.baidu.tbadk.s.a.a(getPageContext(), this.ezP.afH());
            }
            if (this.fpC != null) {
                this.fpC.onChangeSkinType();
            }
        }
    }

    public void qZ(int i) {
        if (!this.mIsLogin) {
            if (this.fos != null && this.fos.getAnti() != null) {
                this.fos.getAnti().setIfpost(1);
            }
            if (i == 0) {
                bc.cD(getActivity());
            }
        } else if (this.fos != null) {
            if (i == 0) {
                com.baidu.tieba.frs.f.j.d(this, 0);
            } else {
                this.foP.bkP();
            }
        }
    }

    public void refresh() {
        com.baidu.tieba.a.d.aBn().rU("page_frs");
        refresh(3);
    }

    public void refresh(int i) {
        this.foZ = false;
        bke();
        if (this.foP != null && this.foP.bkE() != null) {
            this.foP.bkE().bvO();
        }
        if (this.fpg != null) {
            this.fpg.D(i, true);
        }
    }

    private void bka() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.g.h.iC().d(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.29
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.Ec(FrsFragment.this.foH);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkb() {
        bke();
        try {
            if (this.fos != null) {
                this.foP.aUE();
                this.foP.jK(bkq());
                if (!com.baidu.tieba.frs.vc.f.l(this.fos) || !com.baidu.tieba.frs.vc.f.k(this.fos)) {
                }
                if (this.fos.getForum() != null) {
                    this.foH = this.fos.getForum().getName();
                    this.forumId = this.fos.getForum().getId();
                }
                if (this.fos.getPage() != null) {
                    setHasMore(this.fos.getPage().acp());
                }
                this.foP.setTitle(this.foH);
                this.foP.setForumName(this.foH);
                TbadkCoreApplication.getInst().setDefaultBubble(this.fos.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.fos.getUserData().getBimg_end_time());
                bka();
                bkc();
                ArrayList<com.baidu.adp.widget.ListView.m> threadList = this.fos.getThreadList();
                if (threadList != null) {
                    this.foP.a(threadList, this.fos);
                    com.baidu.tieba.frs.f.c.y(this.foP);
                    this.fph.sA(getPageNum());
                    this.fph.i(this.fos);
                    this.fpi.a(this.fos, this.fpg.bpg());
                    this.foP.bkQ();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void bkc() {
        if (this.fos != null) {
            if (this.fos.getIsNewUrl() == 1) {
                this.foP.bkZ().setFromCDN(true);
            } else {
                this.foP.bkZ().setFromCDN(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.fpj.kz(false);
        this.fpc = false;
        this.foP.onPause();
        if (this.foO != null) {
            this.foO.onPause(getPageContext());
        }
        this.foP.jS(true);
        if (this.fpq != null) {
            this.fpq.bpY();
        }
        com.baidu.tbadk.BdToken.c.Yk().Yp();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.fpi != null && this.fpi.bqK() != null && (this.fpi.bqK().fragment instanceof BaseFragment)) {
            ((BaseFragment) this.fpi.bqK().fragment).setPrimary(z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.t.aXM().iv(false);
        jC(false);
        if (this.fos != null && this.fos.getForum() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            com.baidu.tbadk.distribute.a.aqF().a(getPageContext().getPageActivity(), "frs", this.fos.getForum().getId(), 0L);
        }
        if (this.foO != null) {
            this.foO.onStop(getPageContext());
        }
        if (ajY() != null) {
            ajY().getRecycledViewPool().clear();
        }
        this.fph.onActivityStop();
        com.baidu.tbadk.util.y.avq();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            if (this.fph != null) {
                this.fph.jI(isPrimary());
            }
            if (this.foP != null) {
                this.foP.jI(isPrimary());
                this.foP.jS(!isPrimary());
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (com.baidu.tieba.frs.a.biT().biU()) {
                com.baidu.tieba.frs.a.biT().reset();
                return true;
            } else if (this.foP != null) {
                return this.foP.bkM();
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
    public void bkd() {
        bjH().bkd();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.foO == null) {
            this.foO = VoiceManager.instance();
        }
        return this.foO;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdRecyclerView ajY() {
        if (this.foP == null) {
            return null;
        }
        return this.foP.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void bke() {
        if (this.foO != null) {
            this.foO.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> ajZ() {
        if (this.cbP == null) {
            this.cbP = UserIconBox.q(getPageContext().getPageActivity(), 8);
        }
        return this.cbP;
    }

    public void bkf() {
        if (getFragmentActivity() != null && getFragmentActivity().getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.b(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.p onGetPreLoadListView() {
        return ajY().getPreLoadHandle();
    }

    @Override // com.baidu.tieba.frs.ah
    public NavigationBar aJz() {
        if (this.foP == null) {
            return null;
        }
        return this.foP.aJz();
    }

    public FRSRefreshButton bkg() {
        return this.foR;
    }

    public void a(FRSRefreshButton fRSRefreshButton) {
        if (fRSRefreshButton != null) {
            this.foR = fRSRefreshButton;
            this.foR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.36
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (FrsFragment.this.fpi != null) {
                        FrsTabViewController.b bqK = FrsFragment.this.fpi.bqK();
                        if (bqK != null && bqK.fragment != null && (bqK.fragment instanceof ag)) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                            ((ag) bqK.fragment).bjv();
                            ((ag) bqK.fragment).aID();
                            return;
                        }
                        FrsFragment.this.bjM().startPullRefresh();
                    }
                }
            });
        }
    }

    public void bkh() {
        if (this.foR != null && this.foS) {
            if (this.fpO != null) {
                this.fpO.cancel();
            }
            this.fpO = new AlphaAnimation(1.0f, 0.0f);
            this.fpO.setDuration(300L);
            this.fpO.setFillAfter(true);
            this.foR.startAnimation(this.fpO);
            this.foR.setClickable(false);
            this.foS = false;
        }
    }

    public void bki() {
        if (this.foR != null && !this.foS && this.fpi.bqN() != 0) {
            this.foR.setVisibility(0);
            if (this.fpP != null) {
                this.fpP.cancel();
            }
            this.fpP = new AlphaAnimation(0.0f, 1.0f);
            this.fpP.setDuration(300L);
            this.fpP.setFillAfter(true);
            this.foR.startAnimation(this.fpP);
            this.foR.setClickable(true);
            this.foS = true;
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
                if (bdUniqueId == p.fsa) {
                    if (FrsFragment.this.foP != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11752").bT("fid", FrsFragment.this.forumId).bT("obj_locate", "1"));
                        FrsFragment.this.foP.startPullRefresh();
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
                                com.baidu.tieba.frs.f.h.a(FrsFragment.this, FrsFragment.this.fos, bgVar);
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
            hideNetRefreshView(this.foP.bla());
            showLoadingView(this.foP.bla(), true);
            this.foP.jN(false);
            this.fpg.D(3, true);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData bkj() {
        return this.fos;
    }

    public boolean bkk() {
        return this.foP.bkk();
    }

    public void ar(Object obj) {
        if (this.fpl != null && this.fpl.fGW != null) {
            this.fpl.fGW.m(obj);
        }
    }

    public void as(Object obj) {
        if (this.fpl != null && this.fpl.fGX != null) {
            this.fpl.fGX.m(obj);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        this.foP.getListView().stopScroll();
        if (!this.foP.bkV()) {
            if (!com.baidu.adp.lib.util.l.ki()) {
                this.foP.aIG();
            } else if (this.fpg.bpb() == 1) {
                aHE();
                aHq();
            } else if (this.fpg.hasMore()) {
                aHq();
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void vY(String str) {
        aHE();
        showToast(str);
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void V(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        boolean aa = com.baidu.tbadk.core.util.v.aa(arrayList);
        setHasMore(aa ? 0 : 1);
        aHE();
        if (!aa) {
            if (!this.fpg.bpk() && TbadkCoreApplication.getInst().isRecAppExist() && this.fpg.bpb() == 1) {
                this.fos.addRecommendAppToThreadList(this, arrayList);
            }
            if (this.fpg != null) {
                com.baidu.tieba.frs.d.a.a(getUniqueId(), arrayList, this.fos.getForum(), this.fpg.getSortType());
            }
            ArrayList<com.baidu.adp.widget.ListView.m> a2 = this.fpt.a(false, false, arrayList, this.foL, false);
            if (a2 != null) {
                this.fos.setThreadList(a2);
                this.foP.a(a2, this.fos);
            }
            if (this.fpg != null) {
                com.baidu.tieba.frs.d.c.a(this.fos, this.fpg.bpg(), 2);
            }
        }
    }

    private void aHE() {
        if (bjN() == 1 || this.fpt.ci(this.fos.getThreadListIds())) {
            if (com.baidu.tbadk.core.util.v.Z(this.fos.getThreadList()) > 3) {
                this.foP.aIE();
            } else {
                this.foP.bld();
            }
        } else if (com.baidu.tbadk.core.util.v.aa(this.fos.getThreadList())) {
            this.foP.aIG();
        } else {
            this.foP.aIF();
        }
    }

    @Override // com.baidu.tieba.frs.mc.l
    public void aHq() {
        if (this.fpt != null) {
            this.fpt.a(this.foH, this.forumId, this.fos);
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
        if (this.fpm != null) {
            this.fpm.kc(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.fpn.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a lX(int i) {
        return this.fpn.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        this.fpx.b(bVar);
    }

    public boolean bkl() {
        return this.foD;
    }

    @Override // com.baidu.tieba.frs.ae
    public void aHI() {
        if (this.foP != null) {
            showFloatingView();
            this.foP.getListView().scrollToPosition(0);
            this.foP.startPullRefresh();
        }
    }

    public ForumWriteData bkm() {
        if (this.fos == null || this.fos.getForum() == null) {
            return null;
        }
        ForumData forum = this.fos.getForum();
        ForumWriteData forumWriteData = new ForumWriteData(forum.getId(), forum.getName(), forum.getPrefixData(), this.fos.getAnti());
        forumWriteData.avatar = forum.getImage_url();
        forumWriteData.forumLevel = forum.getUser_level();
        forumWriteData.specialForumType = forum.special_forum_type;
        forumWriteData.firstDir = forum.getFirst_class();
        forumWriteData.secondDir = forum.getSecond_class();
        UserData userData = this.fos.getUserData();
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
        this.fpd = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z) {
        super.showLoadingView(view, z);
        this.foP.rf(8);
        ((FrsActivity) getActivity()).i(view, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        super.hideLoadingView(view);
        this.foP.rf(0);
        ((FrsActivity) getActivity()).i(view, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        super.showNetRefreshView(view, str, z);
        this.foP.rf(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshViewNoClick(View view, String str, boolean z) {
        super.showNetRefreshViewNoClick(view, str, z);
        this.foP.rf(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        super.hideNetRefreshView(view);
        this.foP.rf(0);
    }

    public void bkn() {
        FrsTabViewController.b bqK;
        if (this.fpi != null && (bqK = this.fpi.bqK()) != null && bqK.fragment != null && (bqK.fragment instanceof ag)) {
            ((ag) bqK.fragment).bjv();
        }
    }

    public void jH(boolean z) {
        this.foF = z;
    }

    public void b(OvalActionButton ovalActionButton) {
        this.foQ = ovalActionButton;
    }

    public OvalActionButton bko() {
        return this.foQ;
    }

    public boolean bkp() {
        return this.foF;
    }

    public void wq(String str) {
        if (TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.util.ap.isEmpty(str)) {
            if (this.fpK == null) {
                this.fpK = new AddExperiencedModel(getTbPageContext());
                this.fpK.a(this.fpQ);
            }
            this.fpK.ed(this.forumId, str);
        }
    }

    public boolean bkq() {
        if (this.fpd && !this.fpN) {
            return (this.fpg != null && this.fpg.bpc() && com.baidu.tieba.frs.a.biT().biU()) ? false : true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.e.c
    public boolean videoNeedPreload() {
        if (this.fos != null) {
            return com.baidu.tbadk.util.ad.avy() && (this.fos.isFrsVideoAutoPlay || com.baidu.tbadk.core.sharedPref.b.agM().getInt("auto_play_video_frs", 0) == 1);
        }
        return super.videoNeedPreload();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkr() {
        if (!com.baidu.tbadk.core.util.ap.isEmpty(this.forumId)) {
            com.baidu.tbadk.BdToken.c.Yk().l(com.baidu.tbadk.BdToken.b.bwX, com.baidu.adp.lib.g.b.c(this.forumId, 0L));
        }
    }
}
