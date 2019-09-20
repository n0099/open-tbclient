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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bh;
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
import tbclient.FrsTabInfo;
import tbclient.WindowToast;
/* loaded from: classes4.dex */
public class FrsFragment extends BaseFragment implements BdListView.e, a.InterfaceC0049a, UserIconBox.b<BdRecyclerView>, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, ae, ah, aj, com.baidu.tieba.frs.loadmore.a, com.baidu.tieba.frs.mc.l, com.baidu.tieba.recapp.n {
    public static com.baidu.tieba.tbadkCore.l fwf;
    private com.baidu.tbadk.util.v cEi;
    private com.baidu.adp.lib.e.b<TbImageView> cdT;
    private com.baidu.tieba.frs.gametab.b dEj;
    private com.baidu.tbadk.core.dialog.a eGC;
    private com.baidu.tieba.frs.entelechy.a fvN;
    private com.baidu.tieba.tbadkCore.data.f fvX;
    private com.baidu.tieba.frs.entelechy.b.b fwA;
    private com.baidu.tbadk.k.a fwB;
    private com.baidu.tieba.frs.vc.a fwC;
    private com.baidu.tieba.frs.mc.d fwD;
    private com.baidu.tieba.frs.mc.c fwE;
    private com.baidu.tieba.frs.vc.h fwF;
    private com.baidu.tieba.frs.mc.a fwG;
    private com.baidu.tieba.frs.live.a fwH;
    private j fwI;
    public com.baidu.tieba.frs.vc.c fwJ;
    private com.baidu.tieba.frs.mc.e fwK;
    private View.OnTouchListener fwL;
    private com.baidu.tieba.frs.view.a fwM;
    private com.baidu.tieba.frs.view.c fwN;
    private com.baidu.tieba.frs.vc.e fwO;
    private boolean fwP;
    private com.baidu.tieba.NEGFeedBack.a fwR;
    private com.baidu.tieba.ala.a fwS;
    private com.baidu.tieba.frs.brand.buttommenu.a fwT;
    private com.baidu.tieba.frs.sportspage.notification.a fwU;
    private AddExperiencedModel fwV;
    private boolean fwX;
    private VoiceManager fwa;
    private OvalActionButton fwc;
    private FRSRefreshButton fwd;
    private com.baidu.card.z fwr;
    private FrsModelController fws;
    private com.baidu.tieba.frs.vc.f fwt;
    private FrsTabViewController fwu;
    private com.baidu.tieba.frs.mc.h fwv;
    private com.baidu.tieba.frs.smartsort.a fww;
    private com.baidu.tieba.frs.mc.b fwx;
    private ak fwy;
    private int fxi;
    private View mRootView;
    public static boolean fvS = false;
    public static volatile long fwh = 0;
    public static volatile long fwi = 0;
    public static volatile int fwj = 0;
    public boolean fvO = false;
    private boolean fvP = false;
    private boolean fvQ = false;
    private boolean fvR = true;
    public String fvT = null;
    public String mFrom = null;
    public int mFlag = 0;
    public boolean fvU = false;
    private boolean fvV = false;
    private String mThreadId = null;
    public String forumId = null;
    private int fvG = 0;
    private boolean fvW = false;
    private boolean fvY = false;
    private boolean fvZ = false;
    private k fwb = null;
    private boolean fwe = false;
    public final bh cdk = null;
    private FrsViewData fvE = new FrsViewData();
    public long eZc = -1;
    public long cAY = 0;
    public long cAQ = 0;
    public long createTime = 0;
    public long beginTime = -1;
    public long fwg = 0;
    public boolean fwk = false;
    private boolean fwl = false;
    private boolean fwm = false;
    public com.baidu.tbadk.p.b fwn = null;
    private boolean fwo = true;
    private boolean fwp = true;
    private a.C0038a fwq = new a.C0038a(2);
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> fwz = new SparseArray<>();
    private boolean drA = true;
    private boolean fwQ = false;
    private boolean hasInit = false;
    private boolean fwW = false;
    private boolean fwY = false;
    private AlphaAnimation fwZ = null;
    private AlphaAnimation fxa = null;
    private AddExperiencedModel.a fxb = new AddExperiencedModel.a() { // from class: com.baidu.tieba.frs.FrsFragment.1
        @Override // com.baidu.tieba.share.AddExperiencedModel.a
        public void a(ContriInfo contriInfo) {
        }
    };
    public int mHeadLineDefaultNavTabId = -1;
    private HttpMessageListener fxc = new HttpMessageListener(CmdConfigHttp.CMD_PB_FLOOR_AGREE, true) { // from class: com.baidu.tieba.frs.FrsFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof PbFloorAgreeResponseMessage)) {
                PbFloorAgreeResponseMessage pbFloorAgreeResponseMessage = (PbFloorAgreeResponseMessage) httpResponsedMessage;
            }
        }
    };
    private final CustomMessageListener fxd = new CustomMessageListener(2016495) { // from class: com.baidu.tieba.frs.FrsFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof bh) {
                    com.baidu.tieba.frs.f.h.a(FrsFragment.this.fwb, FrsFragment.this.fvE, FrsFragment.this.getForumId(), true, (bh) data);
                }
            }
        }
    };
    private CustomMessageListener fxe = new CustomMessageListener(2921005) { // from class: com.baidu.tieba.frs.FrsFragment.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.fvE != null) {
                FrsFragment.this.fvE.removeGameRankListFromThreadList();
                if (FrsFragment.this.fwb != null) {
                    FrsFragment.this.fwb.Wb();
                }
            }
        }
    };
    private CustomMessageListener Wh = new CustomMessageListener(2921401) { // from class: com.baidu.tieba.frs.FrsFragment.41
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && FrsFragment.this.fwd != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() <= 0 || FrsFragment.this.fwu.btU() == 0 || FrsFragment.this.fwu.btR() == null || !(FrsFragment.this.fwu.btR().fragment instanceof BaseFragment) || !((BaseFragment) FrsFragment.this.fwu.btR().fragment).isPrimary()) {
                    if (FrsFragment.this.fwu.btU() != 0) {
                        FrsFragment.this.bnh();
                        return;
                    }
                    return;
                }
                FrsFragment.this.bni();
            }
        }
    };
    private CustomMessageListener fxf = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.FrsFragment.42
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 1) {
                    FrsFragment.this.bmZ();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                }
            }
        }
    };
    private final ai fxg = new ai() { // from class: com.baidu.tieba.frs.FrsFragment.43
        @Override // com.baidu.tieba.frs.ai
        public void a(int i, int i2, ap apVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
            FrsFragment.this.bmM();
            if (FrsFragment.this.fwA != null) {
                FrsFragment.this.fwt.kS(FrsFragment.this.fwA.sb(i));
            }
            e.b bVar = new e.b();
            if (apVar != null) {
                bVar.isSuccess = apVar.errCode == 0;
                bVar.errorCode = apVar.errCode;
                bVar.errorMsg = apVar.errMsg;
                if (bVar.isSuccess) {
                    if (com.baidu.tbadk.core.util.v.aa(arrayList)) {
                        FrsFragment.this.fwb.aKQ();
                    } else if (apVar.hasMore) {
                        if (com.baidu.tbadk.core.util.v.Z(FrsFragment.this.fvE.getThreadList()) > 3) {
                            FrsFragment.this.fwb.aKO();
                        } else {
                            FrsFragment.this.fwb.boc();
                        }
                    } else if (apVar.fAn) {
                        FrsFragment.this.fwb.aKP();
                    } else {
                        FrsFragment.this.fwb.aKQ();
                    }
                }
            } else {
                apVar = new ap();
                apVar.pn = 1;
                apVar.hasMore = false;
                apVar.fAn = false;
            }
            if (i == 1) {
                FrsFragment.this.fwo = true;
                FrsFragment.this.fxu.a(FrsFragment.this.fws.getType(), false, bVar);
            } else {
                FrsFragment.this.a(bVar);
                if (FrsFragment.this.fws.brI() != null) {
                    FrsFragment.this.fvE = FrsFragment.this.fws.brI();
                }
                FrsFragment.this.bnb();
            }
            if (FrsFragment.this.fxB != null) {
                FrsFragment.this.fxB.a(i, i2, apVar, arrayList);
            }
        }
    };
    private FrsTabViewController.a fxh = new FrsTabViewController.a() { // from class: com.baidu.tieba.frs.FrsFragment.44
        @Override // com.baidu.tieba.frs.vc.FrsTabViewController.a
        public void kE(int i) {
            boolean z = false;
            if (i != 1) {
                com.baidu.tieba.card.t.bat().iH(false);
                FrsFragment.this.jP(false);
            }
            if (i == 303 && i != FrsFragment.this.fxi) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13121").bT("fid", FrsFragment.this.forumId).bT("uid", TbadkCoreApplication.getCurrentAccount()));
            }
            if (i == 502) {
                FrsFragment.this.fwc.setIconFade(R.drawable.btn_frs_professional_edit_n);
            } else {
                FrsFragment.this.fwc.setIconFade(0);
            }
            FrsFragment.this.fxi = i;
            FrsFragment.this.bne();
            com.baidu.tieba.frs.d.d.fEI.fRl = i;
            com.baidu.tieba.frs.d.d.fEI.fRm = -1;
            com.baidu.tieba.frs.a blQ = com.baidu.tieba.frs.a.blQ();
            if (i == 1 && FrsFragment.this.fwW) {
                z = true;
            }
            blQ.D(z, true);
        }
    };
    private CustomMessageListener fxj = new CustomMessageListener(2001606) { // from class: com.baidu.tieba.frs.FrsFragment.45
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                FrsFragment.this.fwu.tg(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    };
    private CustomMessageListener fxk = new CustomMessageListener(2001607) { // from class: com.baidu.tieba.frs.FrsFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && ((Integer) customResponsedMessage.getData()).intValue() == 51 && FrsFragment.this.fvE != null) {
                com.baidu.tieba.frs.f.j.a(FrsFragment.this.fvE, FrsFragment.this.getPageContext());
            }
        }
    };
    private final CustomMessageListener fxl = new CustomMessageListener(2003019) { // from class: com.baidu.tieba.frs.FrsFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                FrsFragment.this.fwu.te(49);
            }
        }
    };
    private final CustomMessageListener fxm = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.frs.FrsFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && FrsFragment.this.fvE != null && FrsFragment.this.fvE.getForum() != null) {
                SignData signData = (SignData) customResponsedMessage.getData();
                int user_level = FrsFragment.this.fvE.getForum().getUser_level();
                if (signData.forumId != null && signData.forumId.equals(FrsFragment.this.fvE.getForum().getId())) {
                    FrsFragment.this.fvE.updateSignData(signData);
                    FrsFragment.this.fwt.j(FrsFragment.this.fvE);
                    if (FrsFragment.this.fwt.btE()) {
                        i = FrsFragment.this.fvE.getForum().getUser_level();
                        if (user_level >= i) {
                            i++;
                        }
                    } else {
                        i = user_level;
                    }
                    TbadkCoreApplication.getInst().addSignedForum(FrsFragment.this.fvE.getForum().getName(), signData.sign_bonus_point, i);
                }
            }
        }
    };
    private final CustomMessageListener fxn = new CustomMessageListener(2001352) { // from class: com.baidu.tieba.frs.FrsFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.t) && FrsFragment.this.fvE != null) {
                FrsFragment.this.fvE.updateLikeData((com.baidu.tieba.tbadkCore.t) customResponsedMessage.getData());
                FrsFragment.this.fwt.i(FrsFragment.this.fvE);
                FrsFragment.this.fwu.a(FrsFragment.this.fvE, FrsFragment.this.fws.bsl());
            }
        }
    };
    private final AntiHelper.a fxo = new AntiHelper.a() { // from class: com.baidu.tieba.frs.FrsFragment.6
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12536").P("obj_locate", at.a.bUN));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12535").P("obj_locate", at.a.bUN));
        }
    };
    private CustomMessageListener dAA = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.frs.FrsFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(FrsFragment.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().ciI != null) {
                        if (AntiHelper.a(FrsFragment.this.getActivity(), updateAttentionMessage.getData().ciI, FrsFragment.this.fxo) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12534").P("obj_locate", at.a.bUN));
                        }
                    } else if (updateAttentionMessage.getData().Hs && updateAttentionMessage.getData().isAttention) {
                        com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getPageContext().getPageActivity(), (int) R.string.attention_success);
                    }
                }
            }
        }
    };
    private CustomMessageListener fxp = new CustomMessageListener(2921346) { // from class: com.baidu.tieba.frs.FrsFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsFragment.this.refresh();
        }
    };
    private CustomMessageListener fxq = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.frs.FrsFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                FrsFragment.this.fwb.c((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener fxr = new CustomMessageListener(2001626) { // from class: com.baidu.tieba.frs.FrsFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewsRemindMessage newsRemindMessage;
            if (customResponsedMessage != null && (customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626 && (newsRemindMessage = (NewsRemindMessage) customResponsedMessage) != null) {
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (FrsFragment.this.fwb != null) {
                    FrsFragment.this.fwb.E(notificationCount, z);
                }
            }
        }
    };
    private final CustomMessageListener fxs = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.frs.FrsFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.isResumed()) {
                FrsFragment.this.bnr();
            }
        }
    };
    private CustomMessageListener fxt = new CustomMessageListener(2003020) { // from class: com.baidu.tieba.frs.FrsFragment.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (FrsFragment.this.fwb != null) {
                    FrsFragment.this.fwb.setExpanded(booleanValue);
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.p fxu = new com.baidu.tieba.tbadkCore.p() { // from class: com.baidu.tieba.frs.FrsFragment.14
        private long startTime = 0;

        @Override // com.baidu.tieba.tbadkCore.p
        public void rx(int i) {
            this.startTime = System.nanoTime();
            if (FrsFragment.this.fwb != null) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsFragment.this.fwb.bnN();
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

        @Override // com.baidu.tieba.tbadkCore.p
        public void a(int i, boolean z, e.b bVar) {
            if (FrsFragment.this.drA) {
                FrsFragment.this.drA = false;
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.fwb, FrsFragment.this.fvE, FrsFragment.this.getForumId(), false, null);
            }
            FrsFragment.this.bmM();
            FrsFragment.this.fwl = true;
            if (bVar != null && bVar.isSuccess) {
                FrsFragment.this.fwb.bnZ().kB(com.baidu.tbadk.core.util.ar.ajw().ajy());
                FrsFragment.fwh = 0L;
                FrsFragment.fwi = 0L;
                FrsFragment.fwj = 0;
            } else {
                FrsFragment.fwj = 1;
            }
            if (!FrsFragment.this.fws.bsp() && (i == 3 || i == 6)) {
                FrsFragment.this.fwE.resetData();
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (FrsFragment.this.fws.brI() != null) {
                FrsFragment.this.fvE = FrsFragment.this.fws.brI();
            }
            FrsFragment.this.fwb.b(FrsFragment.this.fvE.getRedpacketRainData());
            FrsFragment.this.rt(1);
            if (i == 7) {
                FrsFragment.this.ru(FrsFragment.this.fvE.getFrsDefaultTabId());
                return;
            }
            if (FrsFragment.this.fvE.getPage() != null) {
                FrsFragment.this.setHasMore(FrsFragment.this.fvE.getPage().adw());
            }
            if (i == 4) {
                if (!FrsFragment.this.fws.bsp() && TbadkCoreApplication.getInst().isRecAppExist() && FrsFragment.this.fws.bsg() == 1) {
                    FrsFragment.this.fvE.addRecommendAppToThreadList(FrsFragment.this);
                }
                ArrayList<com.baidu.adp.widget.ListView.m> a2 = FrsFragment.this.fwE.a(false, false, FrsFragment.this.fvE.getThreadList(), FrsFragment.this.fvX, false);
                if (a2 != null) {
                    FrsFragment.this.fvE.setThreadList(a2);
                    FrsFragment.this.fvE.checkLiveStageInThreadList();
                }
                if (FrsFragment.this.fws != null) {
                    com.baidu.tieba.frs.d.c.a(FrsFragment.this.fvE, FrsFragment.this.fws.bsl(), 2);
                }
                com.baidu.tieba.frs.f.a.a(FrsFragment.this, FrsFragment.this.fvE.getForum(), FrsFragment.this.fvE.getThreadList(), false, FrsFragment.this.getPn());
                FrsFragment.this.cAY = System.currentTimeMillis() - currentTimeMillis;
                FrsFragment.this.fwb.a(a2, FrsFragment.this.fvE);
                FrsFragment.this.bmN();
                return;
            }
            FrsFragment.this.bmN();
            switch (i) {
                case 1:
                    FrsFragment.this.fwb.bnN();
                    break;
                case 2:
                    FrsFragment.this.fwb.bnN();
                    break;
                case 3:
                case 6:
                    if (FrsFragment.this.fvE != null) {
                        FrsFragment.this.fvE.clearPostThreadCount();
                    }
                    if (FrsFragment.this.fwJ != null) {
                        FrsFragment.this.fwJ.refresh();
                        break;
                    }
                    break;
            }
            FrsFragment.this.bmU();
            if (bVar == null || bVar.errorCode == 0) {
                if (FrsFragment.this.fvE != null) {
                    FrsFragment.this.a(FrsFragment.this.fvE);
                    FrsFragment.this.G(false, i == 5);
                    if (FrsFragment.this.fws != null) {
                        if (FrsFragment.this.fvE.getActivityHeadData() != null && FrsFragment.this.fvE.getActivityHeadData().acQ() != null && FrsFragment.this.fvE.getActivityHeadData().acQ().size() > 0) {
                            com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), 1, FrsFragment.this.fvE.getForum(), FrsFragment.this.fws.getSortType(), 1);
                        }
                        if (FrsFragment.this.fvE.getThreadList() != null && FrsFragment.this.fvE.getThreadList().size() > 0) {
                            Iterator<com.baidu.adp.widget.ListView.m> it = FrsFragment.this.fvE.getThreadList().iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    com.baidu.adp.widget.ListView.m next = it.next();
                                    if ((next instanceof bh) && ((bh) next).getType() == bh.bLy) {
                                        com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), 1, FrsFragment.this.fvE.getForum(), FrsFragment.this.fws.getSortType(), 2);
                                    }
                                }
                            }
                        }
                        com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), FrsFragment.this.fvE.getThreadList(), FrsFragment.this.fvE.getForum(), FrsFragment.this.fws.getSortType());
                    }
                    FrsFragment.this.fwb.rG(i);
                    FrsFragment.fwh = (System.nanoTime() - this.startTime) / 1000000;
                    if (bVar != null) {
                        FrsFragment.fwi = bVar.jgm;
                    }
                } else {
                    return;
                }
            } else if (FrsFragment.this.fvE == null || com.baidu.tbadk.core.util.v.aa(FrsFragment.this.fvE.getThreadList())) {
                FrsFragment.this.a(bVar);
            } else if (bVar.fdH) {
                FrsFragment.this.showToast(FrsFragment.this.getPageContext().getResources().getString(R.string.net_error_text, bVar.errorMsg, Integer.valueOf(bVar.errorCode)));
            }
            FrsFragment.this.bmR();
            FrsFragment.this.bmS();
            if (FrsFragment.this.fvE.getAccessFlag() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11384"));
            }
            if (FrsFragment.this.eZc > -1 && !FrsFragment.this.fwQ) {
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.fws, FrsFragment.this.eZc);
                FrsFragment.this.eZc = -1L;
                FrsFragment.this.fwQ = true;
            }
            if (FrsFragment.this.fvY && FrsFragment.this.fwu.te(49)) {
                FrsFragment.this.fvY = false;
            }
            FrsFragment.this.cAY = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.p
        public void c(com.baidu.tieba.tbadkCore.l lVar) {
            if ((lVar != null && ("normal_page".equals(FrsFragment.this.fws.getPageType()) || "frs_page".equals(FrsFragment.this.fws.getPageType()) || "book_page".equals(FrsFragment.this.fws.getPageType()))) || "brand_page".equals(FrsFragment.this.fws.getPageType())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001615, lVar));
                FrsFragment.this.b(lVar);
                FrsFragment.fwf = lVar;
            }
        }
    };
    private final CustomMessageListener fxv = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.frs.FrsFragment.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                FrsFragment.this.fvE.updateCurrentUserPendant((com.baidu.tbadk.data.l) customResponsedMessage.getData());
                FrsFragment.this.fwb.bnZ().notifyDataSetChanged();
            }
        }
    };
    private final CustomMessageListener mMemListener = new CustomMessageListener(2001194) { // from class: com.baidu.tieba.frs.FrsFragment.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && FrsFragment.this.fvE != null && (userData = FrsFragment.this.fvE.getUserData()) != null) {
                userData.setIsMem(num.intValue());
                if (num.intValue() != 0) {
                    FrsFragment.this.fwt.h(num);
                }
            }
        }
    };
    private final com.baidu.tieba.frs.mc.k fxw = new com.baidu.tieba.frs.mc.k() { // from class: com.baidu.tieba.frs.FrsFragment.26
        @Override // com.baidu.tieba.frs.mc.k
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.m> arrayList, boolean z3) {
            if (FrsFragment.this.fww != null && FrsFragment.this.fws != null && FrsFragment.this.fws.bsp() && z && !z2 && !z3) {
                FrsFragment.this.fww.sH(i2);
            }
        }
    };
    public final View.OnTouchListener cnr = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.FrsFragment.27
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (FrsFragment.this.fwL != null) {
                FrsFragment.this.fwL.onTouch(view, motionEvent);
            }
            if (FrsFragment.this.fwy != null && FrsFragment.this.fwy.boH() != null) {
                FrsFragment.this.fwy.boH().onTouchEvent(motionEvent);
            }
            if (FrsFragment.this.dEj != null) {
                FrsFragment.this.dEj.f(view, motionEvent);
            }
            if (FrsFragment.this.fwt != null) {
                FrsFragment.this.fwt.K(motionEvent);
                return false;
            }
            return false;
        }
    };
    private final CustomMessageListener fxx = new CustomMessageListener(2004507) { // from class: com.baidu.tieba.frs.FrsFragment.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.ahU().getInt(TbadkCoreApplication.getCurrentAccount() + "photolive_hostLevel", -1) != -1 && FrsFragment.this.fvE.getForum() != null) {
                FrsFragment.this.fvE.getForum().setCanAddPhotoLivePost(true);
            }
        }
    };
    public final View.OnClickListener fxy = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.30
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsFragment.this.fwb == null || view != FrsFragment.this.fwb.bnL() || FrsFragment.this.getActivity() == null) {
                if (FrsFragment.this.fvE != null && FrsFragment.this.fvE.getForum() != null && FrsFragment.this.fwb != null && view == FrsFragment.this.fwb.bnR()) {
                    if (FrsFragment.this.fwN == null) {
                        FrsFragment.this.fwN = new com.baidu.tieba.frs.view.c(FrsFragment.this.getPageContext());
                    }
                    FrsFragment.this.fwN.m(FrsFragment.this.fvE);
                    FrsFragment.this.fwN.showDialog();
                    return;
                }
                if (view.getId() == R.id.game_activity_egg_layout && com.baidu.adp.lib.util.l.kt()) {
                    TiebaStatic.log("c10853");
                    if (FrsFragment.this.fwb.bnW()) {
                        FrsFragment.this.fwb.bnX();
                    } else {
                        String activityUrl = FrsFragment.this.fvE.getForum().getYuleData().agI().getActivityUrl();
                        if (!StringUtils.isNull(activityUrl)) {
                            com.baidu.tbadk.browser.a.af(FrsFragment.this.getPageContext().getPageActivity(), activityUrl);
                        }
                    }
                }
                if (view == FrsFragment.this.fwb.bod() && FrsFragment.this.fws != null && FrsFragment.this.fws.hasMore()) {
                    FrsFragment.this.fwb.aKO();
                    FrsFragment.this.aJw();
                }
                if (view != null && view == FrsFragment.this.fwb.bnT() && bc.cF(FrsFragment.this.getContext())) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12924").P("obj_locate", 2));
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
        private int fxK = 0;
        private int dof = 0;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (FrsFragment.this.fwC != null) {
                FrsFragment.this.fwC.bte();
            }
            this.fxK = 0;
            this.dof = 0;
            if (recyclerView != null && (recyclerView instanceof BdRecyclerView)) {
                this.fxK = ((BdRecyclerView) recyclerView).getFirstVisiblePosition();
                this.dof = ((BdRecyclerView) recyclerView).getLastVisiblePosition();
            }
            if (FrsFragment.this.fwO != null) {
                FrsFragment.this.fwO.a(recyclerView, this.fxK, this.dof);
            }
            if (FrsFragment.this.fvE != null && FrsFragment.this.fwb != null && FrsFragment.this.fwb.bnZ() != null) {
                FrsFragment.this.fwb.bs(this.fxK, this.dof);
                if (FrsFragment.this.fwr != null && FrsFragment.this.fwr.qQ() != null) {
                    FrsFragment.this.fwr.qQ().b(FrsFragment.this.fwq);
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (FrsFragment.this.fwt != null) {
                FrsFragment.this.fwt.setScrollState(i);
            }
            if (i == 0) {
                FrsFragment.this.fwb.boh();
            }
            if ((i == 2 || i == 1) && !FrsFragment.this.fwm) {
                FrsFragment.this.fwm = true;
                FrsFragment.this.fwb.bob();
            }
            if (FrsFragment.this.fwn == null && !FrsFragment.this.bnl()) {
                FrsFragment.this.fwn = new com.baidu.tbadk.p.b();
                FrsFragment.this.fwn.kU(1000);
            }
            if (i == 0) {
                if (FrsFragment.this.fwn != null) {
                    FrsFragment.this.fwn.avy();
                }
                com.baidu.tieba.card.t.bat().iH(true);
                FrsFragment.this.jP(true);
                FrsFragment.this.fwb.br(this.fxK, this.dof);
            } else if (FrsFragment.this.fwn != null) {
                FrsFragment.this.fwn.avx();
            }
            if (FrsFragment.this.fwO != null) {
                FrsFragment.this.fwO.onScrollStateChanged(recyclerView, i);
            }
            if (i == 0) {
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.fwb, FrsFragment.this.fvE, FrsFragment.this.getForumId(), false, null);
            }
            if (FrsFragment.this.fwu != null && i == 1) {
                FrsFragment.this.fwu.btT();
            }
            if (FrsFragment.this.fwr == null) {
                if (FrsFragment.this.fwb.bnE() != null && !FrsFragment.this.fwb.bnk() && FrsFragment.this.fwb.bnE().cfk() != null && (FrsFragment.this.fwb.bnE().cfk().getTag() instanceof com.baidu.card.z)) {
                    FrsFragment.this.fwr = (com.baidu.card.z) FrsFragment.this.fwb.bnE().cfk().getTag();
                }
            } else if (i == 0 && FrsFragment.this.fwb.bnE() != null && !FrsFragment.this.fwb.bnk() && FrsFragment.this.fwb.bnE().cfk() != null && (FrsFragment.this.fwb.bnE().cfk().getTag() instanceof com.baidu.card.z)) {
                FrsFragment.this.fwr = (com.baidu.card.z) FrsFragment.this.fwb.bnE().cfk().getTag();
            }
            if (i == 1) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921418));
            }
        }
    };
    private final d fxz = new d() { // from class: com.baidu.tieba.frs.FrsFragment.32
        @Override // com.baidu.tieba.frs.d
        public void a(int i, int i2, View view, View view2, bh bhVar) {
            if (i != FrsFragment.this.fwb.bnZ().bpW()) {
                if (i != FrsFragment.this.fwb.bnZ().bpX()) {
                    if (i == FrsFragment.this.fwb.bnZ().bpU() && FrsFragment.this.fvE != null && FrsFragment.this.fvE.getUserData() != null && FrsFragment.this.fvE.getUserData().isBawu()) {
                        String bawuCenterUrl = FrsFragment.this.fvE.getBawuCenterUrl();
                        if (!com.baidu.tbadk.core.util.aq.isEmpty(bawuCenterUrl) && FrsFragment.this.fvE.getForum() != null) {
                            com.baidu.tbadk.browser.a.ae(FrsFragment.this.getPageContext().getPageActivity(), bawuCenterUrl);
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10502").bT("fid", FrsFragment.this.fvE.getForum().getId()).bT("uid", FrsFragment.this.fvE.getUserData().getUserId()));
                        }
                    }
                } else if (bc.cF(FrsFragment.this.getPageContext().getPageActivity())) {
                    TiebaStatic.log("my_service_ck");
                    if (FrsFragment.this.fvE != null && FrsFragment.this.fvE.getForum() != null) {
                        ForumData forum = FrsFragment.this.fvE.getForum();
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.e(forum.getId(), 0L), forum.getName(), forum.getImage_url(), 0)));
                    }
                }
            } else if (bc.cF(FrsFragment.this.getActivity())) {
                TiebaStatic.log("forum_fortune_click");
                com.baidu.tieba.frs.f.i.b(FrsFragment.this.getPageContext(), FrsFragment.this.fvE);
            }
        }
    };
    private final NoNetworkView.a ftG = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.FrsFragment.33
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void es(boolean z) {
            if (FrsFragment.this.fws.bsg() == 1 && z && !FrsFragment.this.fwb.bnk()) {
                if (FrsFragment.this.fvE == null || com.baidu.tbadk.core.util.v.aa(FrsFragment.this.fvE.getThreadList())) {
                    FrsFragment.this.hideNetRefreshView(FrsFragment.this.fwb.aYe());
                    FrsFragment.this.showLoadingView(FrsFragment.this.fwb.aYe(), true);
                    FrsFragment.this.fwb.ka(false);
                    FrsFragment.this.refresh();
                    return;
                }
                FrsFragment.this.fwb.bnN();
            }
        }
    };
    private final CustomMessageListener cjl = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.FrsFragment.35
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                com.baidu.tieba.frs.f.c.a(customResponsedMessage, FrsFragment.this.fwb, FrsFragment.this.fvE);
            }
        }
    };
    private com.baidu.adp.widget.ListView.s fxA = new a();
    private ai fxB = new ai() { // from class: com.baidu.tieba.frs.FrsFragment.37
        @Override // com.baidu.tieba.frs.ai
        public void a(int i, int i2, ap apVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
            com.baidu.adp.lib.g.e.iK().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.37.1
                @Override // java.lang.Runnable
                public void run() {
                    if (FrsFragment.this.fwb != null && FrsFragment.this.fwb.bbs()) {
                        FrsFragment.this.aJw();
                    }
                }
            });
        }
    };
    private CustomMessageListener fxC = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.frs.FrsFragment.38
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    FrsFragment.this.fwP = true;
                }
            }
        }
    };
    private CustomMessageListener fxD = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.frs.FrsFragment.39
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                    if (FrsFragment.this.fwr == null && FrsFragment.this.fwb.bnE() != null && !FrsFragment.this.fwb.bnk() && FrsFragment.this.fwb.bnE().cfk() != null && (FrsFragment.this.fwb.bnE().cfk().getTag() instanceof com.baidu.card.z)) {
                        FrsFragment.this.fwr = (com.baidu.card.z) FrsFragment.this.fwb.bnE().cfk().getTag();
                    }
                    if (FrsFragment.this.fwr != null && FrsFragment.this.fwr.qQ() != null) {
                        FrsFragment.this.fwr.qQ().b(new a.C0038a(3));
                    }
                }
            }
        }
    };
    private CustomMessageListener fxE = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.FrsFragment.40
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.fwb != null) {
                FrsFragment.this.fwb.boj();
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.frs.loadmore.a
    public /* bridge */ /* synthetic */ com.baidu.adp.base.e getPageContext() {
        return super.getPageContext();
    }

    public com.baidu.tieba.frs.entelechy.b.b bmA() {
        return this.fwA;
    }

    public com.baidu.adp.widget.ListView.s bmB() {
        return this.fxA;
    }

    public com.baidu.tieba.frs.mc.d bmC() {
        return this.fwD;
    }

    public com.baidu.tieba.frs.smartsort.a bmD() {
        return this.fww;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public FrsModelController bmE() {
        return this.fws;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public com.baidu.tieba.frs.mc.c bmF() {
        return this.fwE;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public com.baidu.tieba.frs.vc.f bmG() {
        return this.fwt;
    }

    public FrsTabViewController bmH() {
        return this.fwu;
    }

    public ak bmI() {
        return this.fwy;
    }

    public void jO(boolean z) {
        this.fwY = z;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public k bmJ() {
        return this.fwb;
    }

    @Override // com.baidu.tieba.frs.aj
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.aj, com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.fvT;
    }

    public void setForumName(String str) {
        this.fvT = str;
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
        if (this.fwE == null) {
            return 1;
        }
        return this.fwE.getPn();
    }

    public int getPn() {
        if (this.fwE == null) {
            return 1;
        }
        return this.fwE.getPn();
    }

    public void setPn(int i) {
        if (this.fwE != null) {
            this.fwE.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.fwE != null) {
            this.fwE.setHasMore(i);
        }
    }

    public int bmK() {
        if (this.fwE == null) {
            return -1;
        }
        return this.fwE.bmK();
    }

    public boolean bmL() {
        return this.fvZ;
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
            this.fwb.bnH();
            showNetRefreshView(this.fwb.aYe(), string, true);
        } else if (340001 == bVar.errorCode) {
            a(bVar, this.fvE.getRecm_forum_list());
        } else {
            if (com.baidu.tbadk.core.util.v.aa(this.fvE.getThreadList())) {
                b(bVar);
            }
            if (bnl()) {
                setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst(), R.dimen.ds280));
            } else {
                setNetRefreshViewEmotionDefMarginTop();
            }
        }
    }

    public void a(View view, String str, boolean z, List<RecmForumInfo> list) {
        this.fwb.bnH();
        this.fwb.rC(8);
        if (this.fwM == null) {
            this.fwM = new com.baidu.tieba.frs.view.a(getPageContext(), getNetRefreshListener());
        }
        this.fwM.qY(str);
        this.fwM.co(list);
        this.fwM.attachView(view, z);
    }

    private void a(e.b bVar, List<RecmForumInfo> list) {
        if (this.fwb != null) {
            this.fwb.bnH();
            this.fwb.setTitle(this.fvT);
            a(this.fwb.aYe(), bVar.errorMsg, true, list);
        }
    }

    private void b(e.b bVar) {
        this.fwb.bnH();
        if (bVar.fdH) {
            showNetRefreshView(this.fwb.aYe(), TbadkCoreApplication.getInst().getString(R.string.net_error_text, new Object[]{bVar.errorMsg, Integer.valueOf(bVar.errorCode)}), true);
        } else {
            showNetRefreshView(this.fwb.aYe(), bVar.errorMsg, true);
        }
    }

    public void bmM() {
        hideLoadingView(this.fwb.aYe());
        this.fwb.kc(false);
        if (this.fwb.bnF() instanceof com.baidu.tieba.frs.tab.c) {
            ((com.baidu.tieba.frs.tab.c) this.fwb.bnF()).bsJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmN() {
        if (bmK() == 0 && com.baidu.tbadk.core.util.v.aa(this.fvE.getThreadListIds())) {
            if (com.baidu.tbadk.core.util.v.aa(this.fvE.getThreadList())) {
                this.fwb.aKQ();
            } else {
                this.fwb.aKP();
            }
        } else if (com.baidu.tbadk.core.util.v.Z(this.fvE.getThreadList()) > 3) {
            this.fwb.aKO();
        } else {
            this.fwb.boc();
        }
    }

    public void a(ErrorData errorData) {
        String stringExtra = getActivity().getIntent().getStringExtra("name");
        if (getActivity().getIntent().getIntExtra(FrsActivityConfig.FRS_CALL_FROM, -1) == 12 && errorData != null && errorData.error_code == 3 && !StringUtils.isNull(stringExtra) && TbadkCoreApplication.isLogin()) {
            sendMessage(new CustomMessage(2002001, new CreateBarGuideActivityConfig(getContext(), stringExtra)));
            getActivity().finish();
            return;
        }
        bmM();
        this.fwb.bnN();
        e.b bsd = this.fws.bsd();
        boolean aa = com.baidu.tbadk.core.util.v.aa(this.fvE.getThreadList());
        if (bsd != null && aa) {
            if (this.fws.bse() != 0) {
                this.fws.bsj();
                this.fwb.bnN();
            } else {
                a(bsd);
            }
            this.fwb.H(this.fvE.isStarForum(), false);
            return;
        }
        a(bsd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.l lVar) {
        if (lVar != null && lVar.getEntelechyTabInfo() != null && lVar.getEntelechyTabInfo().tab != null) {
            for (FrsTabInfo frsTabInfo : lVar.getEntelechyTabInfo().tab) {
                if (frsTabInfo.tab_id.intValue() == 502 && com.baidu.tbadk.core.sharedPref.b.ahU().getBoolean("first_into_tab_profession", true)) {
                    return;
                }
            }
        }
        new com.baidu.tieba.frs.ad.f(getTbPageContext()).a(lVar);
    }

    public boolean bmO() {
        return bmP() && !bmQ();
    }

    private boolean bmP() {
        if (bnj() == null) {
            return false;
        }
        FrsViewData bnj = bnj();
        com.baidu.tbadk.core.data.s sVar = null;
        if (bnj.getStar() != null && !StringUtils.isNull(bnj.getStar().cpI())) {
            sVar = new com.baidu.tbadk.core.data.s();
        } else if (bnj.getActivityHeadData() != null && com.baidu.tbadk.core.util.v.Z(bnj.getActivityHeadData().acQ()) >= 1) {
            sVar = bnj.getActivityHeadData().acQ().get(0);
        }
        return sVar != null;
    }

    public boolean bmQ() {
        if (bnj() == null) {
            return false;
        }
        FrsViewData bnj = bnj();
        return (com.baidu.tbadk.core.util.v.aa(bnj.getShowTopThreadList()) && bnj.getBusinessPromot() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmR() {
        boolean b;
        if (!bmT()) {
            final PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
            privateForumPopInfoData.a(this.fvE.getPrivateForumTotalInfo().getPrivatePopInfo());
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(getActivity());
            if (this.fvE.getPrivateForumTotalInfo().adD().private_forum_status.intValue() == 1 && (com.baidu.tbadk.core.util.aq.isEmpty(privateForumPopInfoData.adF()) || privateForumPopInfoData.adI() != Integer.valueOf(this.forumId))) {
                privateForumPopInfoData.mt("create_success");
                privateForumPopInfoData.mu(TbadkCoreApplication.getInst().getString(R.string.frs_private_create_hint));
                privateForumPopInfoData.mv("https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.fvT + "&nomenu=1");
                privateForumPopInfoData.b(Integer.valueOf(this.forumId));
                b = frsPrivateCommonDialogView.b(privateForumPopInfoData);
            } else {
                b = privateForumPopInfoData.adI() == Integer.valueOf(this.forumId) ? frsPrivateCommonDialogView.b(privateForumPopInfoData) : false;
            }
            if (b) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
                aVar.hy(2);
                aVar.aH(frsPrivateCommonDialogView);
                aVar.dR(false);
                frsPrivateCommonDialogView.setConfirmButton(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.15
                    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.frs.FrsFragment */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ba.ajK().c(FrsFragment.this.getPageContext(), new String[]{privateForumPopInfoData.adH()});
                        aVar.dismiss();
                    }
                });
                aVar.a(new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.16
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(getPageContext()).agO();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmS() {
        if (bmT() || this.fvE.getPrivateForumTotalInfo().adD().private_forum_status.intValue() != 1) {
            a((Integer) null, (Integer) null, true);
        } else {
            a(this.fvE.getPrivateForumTotalInfo().adD().private_forum_audit_status, this.fvE.getPrivateForumTotalInfo().adE(), false);
        }
    }

    public void a(Integer num, Integer num2, boolean z) {
        final String str;
        final int i = 2;
        if (this.fwb.bnS() != null) {
            TextView bnS = this.fwb.bnS();
            if (z) {
                bnS.setVisibility(8);
                return;
            }
            if (num.intValue() == 2) {
                bnS.setText("修改实名认证信息");
                bnS.setVisibility(0);
                str = "https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + this.forumId + "&nomenu=1";
            } else if (num2.intValue() >= 0 && num2.intValue() <= 100) {
                bnS.setText("目标已完成" + String.valueOf(num2) + "%");
                bnS.setVisibility(0);
                str = "https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.fvT + "&nomenu=1";
                i = 1;
            } else {
                bnS.setVisibility(8);
                i = 0;
                str = "";
            }
            bnS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.17
                /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13387").bT("fid", FrsFragment.this.forumId).bT("uid", TbadkCoreApplication.getCurrentAccount()).P("obj_type", i));
                    ba.ajK().c(FrsFragment.this.getPageContext(), new String[]{str});
                }
            });
        }
    }

    private boolean bmT() {
        return this.fvE == null || !this.fvE.isPrivateForum() || this.fvE.getPrivateForumTotalInfo() == null || this.fvE.getPrivateForumTotalInfo().adD() == null || this.fvE.getUserData().getIs_manager() != 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rt(int i) {
        List<WindowToast> list;
        if (TbadkCoreApplication.isLogin() && this.fvE != null && (list = this.fvE.mWindowToast) != null && list.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < list.size()) {
                    WindowToast windowToast = list.get(i3);
                    if (windowToast == null || windowToast.toast_type.intValue() != i) {
                        i2 = i3 + 1;
                    } else if (!com.baidu.tbadk.core.util.aq.isEmpty(windowToast.toast_link)) {
                        sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(getPageContext().getPageActivity(), "", com.baidu.tbadk.util.ad.rD(windowToast.toast_link), true)));
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
    public void bmU() {
        if (this.fvE == null || this.fvE.getForum() != null) {
            this.fwb.bnY();
        } else if (this.fvE.getForum().getYuleData() != null && this.fvE.getForum().getYuleData().agH()) {
            TiebaStatic.log("c10852");
            this.fwb.a(this.fvE.getForum().getYuleData().agI());
        } else {
            this.fwb.bnY();
        }
    }

    private void F(boolean z, boolean z2) {
        if (this.fws != null && this.fvE != null && this.fwb != null && z) {
            if (!this.fws.bsp() && this.fws.bsg() == 1) {
                if (!this.fws.bsn()) {
                    this.fvE.addCardVideoInfoToThreadList();
                    this.fvE.addVideoInfoToThreadListInTenAndFifteenFloor();
                }
                boolean z3 = false;
                if (this.fwb.bnZ().n(com.baidu.tieba.card.data.n.eIf)) {
                    z3 = this.fvE.addHotTopicDataToThreadList();
                }
                if (!z3) {
                    this.fvE.addFeedForumDataToThreadList();
                }
                if (TbadkCoreApplication.getInst().isRecAppExist()) {
                    this.fvE.addRecommendAppToThreadList(this);
                }
                if (!this.fwb.bnZ().n(bh.bKb)) {
                    this.fvE.removeAlaLiveThreadData();
                }
                this.fvE.addSchoolRecommendToThreadList();
            }
            if (!this.fwb.bnZ().n(bh.bKb)) {
                this.fvE.removeAlaInsertLiveData();
                this.fvE.removeAlaStageLiveDat();
            } else {
                this.fvE.addInsertLiveDataToThreadList();
                this.fvE.addStageLiveDataToThreadList();
            }
            this.fvE.checkLiveStageInThreadList();
            this.fvE.addNoticeThreadToThreadList();
            if (this.fwb.bnZ().n(com.baidu.tieba.h.b.fZa)) {
                this.fvE.addGameRankListToThreadList(z2);
            }
            if (TbadkCoreApplication.isLogin() && (!this.fws.bsp() || this.fws.isNetFirstLoad)) {
                this.fvE.addUserRecommendToThreadList();
            }
            this.fvE.addVideoActivityToTop();
        }
    }

    public boolean bmV() {
        if (this.fwt != null && this.fws != null) {
            this.fwt.a(this.fws.getPageType(), this.fvE);
        }
        boolean z = false;
        if (this.fvE != null) {
            z = this.fvE.hasTab();
        }
        bmX();
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ru(int i) {
        am amVar = null;
        bmV();
        bne();
        try {
            if (this.fvE != null) {
                this.fwb.a((ArrayList<com.baidu.adp.widget.ListView.m>) null, this.fvE);
                this.fwt.sY(1);
                this.fwb.bnQ();
                this.fwu.a(this.fvE, this.fws.bsl());
                com.baidu.tieba.frs.tab.d tf = this.fwu.tf(this.fvE.getFrsDefaultTabId());
                if (tf != null && !TextUtils.isEmpty(tf.url)) {
                    amVar = new am();
                    amVar.fAk = tf.url;
                    amVar.stType = tf.name;
                }
                this.fws.a(this.fvE.getFrsDefaultTabId(), 0, amVar);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(boolean z, boolean z2) {
        try {
            if (this.fvE != null && this.fwu != null && this.fws != null) {
                if (!this.fwb.bnZ().n(bh.bKb)) {
                    this.fvE.removeAlaLiveThreadData();
                }
                boolean aa = com.baidu.tbadk.core.util.v.aa(this.fvE.getGameTabInfo());
                this.fwb.jY(aa);
                if (!aa) {
                    if (this.fwO == null) {
                        this.fwO = new com.baidu.tieba.frs.vc.e(this, (NoPressedRelativeLayout) this.mRootView);
                    }
                    if (this.dEj == null) {
                        this.dEj = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
                    }
                } else {
                    this.fwO = null;
                    this.dEj = null;
                }
                if (this.fvE.getForum() != null) {
                    this.fvT = this.fvE.getForum().getName();
                    this.forumId = this.fvE.getForum().getId();
                }
                if (this.fvE.hasTab()) {
                    this.fwu.a(this.fvE, this.fws.bsl());
                }
                if (z) {
                    F(true, z);
                } else {
                    F(this.fwo, z);
                }
                bmV();
                if (this.fwA != null) {
                    this.fwA.a(this.fwt, this.fvE);
                }
                if (this.fvE.getPage() != null) {
                    setHasMore(this.fvE.getPage().adw());
                }
                ArrayList<com.baidu.adp.widget.ListView.m> a2 = this.fwE.a(z2, true, this.fvE.getThreadList(), null, z, false);
                if (a2 != null) {
                    this.fvE.setThreadList(a2);
                }
                this.fvE.removeRedundantUserRecommendData();
                this.fvG = this.fvE.getTopThreadSize();
                if (this.fvX != null) {
                    this.fvW = true;
                    this.fvX.Bg(this.fvG);
                    com.baidu.tieba.frs.f.a.a(this, this.fvE.getForum(), this.fvE.getThreadList(), this.fvW, getPn());
                }
                if (this.fws.bsg() == 1) {
                    bnb();
                    if (!z && this.fws.getPn() == 1) {
                        bmW();
                    }
                }
                if (this.fwC != null) {
                    this.fwC.bY(this.fwu.btQ());
                }
                bmM();
                this.fwb.bnI();
                this.fwb.H(true, false);
                if (z && this.fvE.isFirstTabEqualAllThread()) {
                    com.baidu.adp.lib.g.e.iK().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.18
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!FrsFragment.this.fwl) {
                                FrsFragment.this.fwb.boi();
                            }
                        }
                    });
                }
                if (this.fvE.getForum() != null) {
                    this.fwb.xv(this.fvE.getForum().getWarningMsg());
                }
                if (this.fvE != null && this.fvE.getFrsVideoActivityData() != null && com.baidu.tbadk.core.sharedPref.b.ahU().getLong("frs_video_activity_guide", 0L) == 0) {
                    com.baidu.adp.lib.g.e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.19
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsFragment.this.fwb.bof();
                        }
                    }, 1000L);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2921326, this));
                this.fwb.bnC();
                if (this.fvE != null && this.fvE.getForum() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016564, new VisitedForumData(this.fvE.getForum().getId(), this.fvE.getForum().getName(), this.fvE.getForum().getImage_url(), String.valueOf(System.currentTimeMillis() / 1000), "showlive".equals(this.fvE.getForum().special_forum_type), this.fvE.getForum().getThemeColorInfo(), this.fvE.getForum().getMember_num())));
                }
                this.fwT.a(this.fvE.bottomMenuList, this.fvE.getForum());
                bnr();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void jP(boolean z) {
        com.baidu.tieba.q.c.cpt().b(getUniqueId(), z);
    }

    public void bmW() {
        if (this.fwH == null) {
            this.fwH = new com.baidu.tieba.frs.live.a(this, com.baidu.adp.lib.g.b.f(this.forumId, 0));
        }
        this.fwH.brO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.tbadkCore.l lVar) {
        try {
            if (!this.fwl && lVar != null && this.fvE != null) {
                this.fvE.receiveData(lVar);
                G(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void bmX() {
        if (this.fws != null) {
            xt(this.fws.getPageType());
        } else {
            xt("normal_page");
        }
    }

    private void xt(String str) {
        jQ("frs_page".equals(str));
        if (this.fwA != null) {
            this.fwA.a(this.fwt, this.fwb, this.fvE);
        }
    }

    public void jQ(boolean z) {
        if (this.fwF != null) {
            this.fwF.btJ();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.q.c.cpt().u(getUniqueId());
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.frs_activity, viewGroup, false);
            this.fvN = new com.baidu.tieba.frs.entelechy.a();
            this.fwA = this.fvN.bpB();
            this.fwt = new com.baidu.tieba.frs.vc.f(this, this.fvN, (FrsHeaderViewContainer) this.mRootView.findViewById(R.id.header_view_container));
            this.fwu = new FrsTabViewController(this, this.mRootView);
            this.fwu.registerListener();
            this.fwt.a(this.fwu);
            this.fwu.a(this.fxh);
            Intent intent = getActivity().getIntent();
            if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                this.fvP = true;
            }
            this.fwb = new k(this, this.fxy, this.fvN, this.fvP, this.fwt);
            this.fwT = new com.baidu.tieba.frs.brand.buttommenu.a(getPageContext(), this.mRootView);
        } else {
            if (this.mRootView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            if (this.fwu != null) {
                this.fwu.registerListener();
            }
            this.fwb.boe();
            this.mRootView.setLeft(0);
            this.mRootView.setRight(com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst().getContext()));
        }
        this.fwX = true;
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        ArrayList<com.baidu.adp.widget.ListView.m> arrayList = null;
        this.eZc = System.currentTimeMillis();
        this.beginTime = this.eZc;
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.fvY = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.eZc = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            ah(intent);
        }
        this.cAQ = this.beginTime - this.eZc;
        this.fvX = new com.baidu.tieba.tbadkCore.data.f("frs", com.baidu.tieba.tbadkCore.data.f.jhX);
        if (this.fws == null) {
            this.fws = new FrsModelController(this, this.fxu);
            this.fws.a(this.fxg);
            this.fws.init();
        }
        if (intent != null) {
            this.fws.K(intent.getExtras());
        } else if (bundle != null) {
            this.fws.K(bundle);
        } else {
            this.fws.K(null);
        }
        if (intent != null) {
            this.fwt.R(intent.getExtras());
        } else if (bundle != null) {
            this.fwt.R(bundle);
        } else {
            this.fwt.R(null);
        }
        this.fwa = getVoiceManager();
        this.fwI = new j(getPageContext(), this);
        initUI();
        initData(bundle);
        if (!bnl()) {
            this.fwy = new ak(getActivity(), this.fwb, this.fwt);
            this.fwy.kp(true);
        }
        this.fwa = getVoiceManager();
        if (this.fwa != null) {
            this.fwa.onCreate(getPageContext());
        }
        new com.baidu.tieba.frs.mc.i();
        int i = -1;
        if (this.fwE != null && this.fwE.brZ() != null) {
            i = this.fwE.brZ().bmK();
            arrayList = this.fwE.brZ().getDataList();
        }
        this.fwE = new com.baidu.tieba.frs.mc.c(this, this.fxw);
        this.fwE.brZ().setHasMore(i);
        if (arrayList != null && arrayList.size() > 0) {
            this.fwE.brZ().ad(arrayList);
        }
        this.fww = new com.baidu.tieba.frs.smartsort.a(this);
        this.fwF = new com.baidu.tieba.frs.vc.h(this);
        this.fwC = new com.baidu.tieba.frs.vc.a(getPageContext(), this.fws.bsm());
        this.fwx = new com.baidu.tieba.frs.mc.b(this);
        this.fwD = new com.baidu.tieba.frs.mc.d(this);
        this.fwv = new com.baidu.tieba.frs.mc.h(this);
        this.fwG = new com.baidu.tieba.frs.mc.a(this);
        this.fwJ = new com.baidu.tieba.frs.vc.c(this);
        this.fwK = new com.baidu.tieba.frs.mc.e(this, getUniqueId());
        this.fwR = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "frs");
        this.fwS = new com.baidu.tieba.ala.a(getPageContext());
        this.fwU = new com.baidu.tieba.frs.sportspage.notification.a(getPageContext());
        registerListener(this.dAA);
        registerListener(this.mMemListener);
        registerListener(this.fxn);
        registerListener(this.fxx);
        registerListener(this.fxm);
        registerListener(this.fxv);
        registerListener(this.fxj);
        registerListener(this.fxk);
        registerListener(this.fxl);
        registerListener(this.fxd);
        registerListener(this.fxe);
        registerListener(this.Wh);
        registerListener(this.fxC);
        registerListener(this.fxq);
        registerListener(this.fxf);
        registerListener(this.fxr);
        registerListener(this.fxp);
        this.fxc.setTag(getPageContext().getUniqueId());
        registerListener(this.fxc);
        registerListener(this.fxs);
        registerListener(this.fxt);
        this.fxD.setTag(getPageContext().getUniqueId());
        MessageManager.getInstance().registerListener(this.fxD);
        registerListener(this.fxE);
        this.fwb.ka(false);
        if (!bnl() && !this.hasInit) {
            showLoadingView(this.fwb.aYe(), true);
            this.fws.G(3, false);
        }
        com.baidu.tieba.frs.a.blQ().a(new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.22
            @Override // com.baidu.tieba.frs.a.b
            public void E(boolean z, boolean z2) {
                if (FrsFragment.this.fwb != null) {
                    FrsFragment.this.fwb.rD(z ? 0 : 8);
                    if (!z2) {
                        FrsFragment.this.fwW = z;
                    }
                    if (FrsFragment.this.fwb.bnZ() != null && FrsFragment.this.fws != null && FrsFragment.this.fws.bsh()) {
                        FrsFragment.this.fwb.bnZ().notifyDataSetChanged();
                    }
                    if (FrsFragment.this.bmH() != null) {
                        FrsTabViewController.b btR = FrsFragment.this.bmH().btR();
                        if (btR != null && btR.tabId == 502 && (btR.fragment instanceof FrsCommonTabFragment)) {
                            ((FrsCommonTabFragment) btR.fragment).bpx();
                        } else if (btR != null && btR.tabId == 503 && (btR.fragment instanceof FrsNewAreaFragment)) {
                            FrsNewAreaFragment frsNewAreaFragment = (FrsNewAreaFragment) btR.fragment;
                            frsNewAreaFragment.bpx();
                            if (frsNewAreaFragment.bst() != null) {
                                com.baidu.tieba.frs.mc.g bst = frsNewAreaFragment.bst();
                                bst.kd(!z);
                                bst.ke(!z);
                            }
                        }
                        if (FrsFragment.this.bmH().btK() != null) {
                            FrsFragment.this.bmH().btK().setmDisallowSlip(z);
                            FrsFragment.this.bmH().kU(z);
                        }
                    }
                    if (FrsFragment.this.fwb.bnG() != null) {
                        FrsFragment.this.fwb.jX(!z);
                    }
                    if (FrsFragment.this.getActivity() instanceof FrsActivity) {
                        ((FrsActivity) FrsFragment.this.getActivity()).jN(!z);
                    }
                    if (FrsFragment.this.fwT != null) {
                        FrsFragment.this.fwT.kx(!z);
                    }
                    FrsFragment.this.fwb.kd(!z);
                    FrsFragment.this.fwb.ke(z ? false : true);
                }
            }

            @Override // com.baidu.tieba.frs.a.b
            public void rq(int i2) {
                if (FrsFragment.this.fwb != null) {
                    FrsFragment.this.fwb.rE(i2);
                }
            }

            @Override // com.baidu.tieba.frs.a.b
            public void blX() {
                com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getContext(), (int) R.string.frs_multi_delete_max_num);
            }
        });
        this.fwb.b(new d.a() { // from class: com.baidu.tieba.frs.FrsFragment.24
            @Override // com.baidu.tieba.NEGFeedBack.d.a
            public void a(DeleteThreadHttpResponseMessage deleteThreadHttpResponseMessage) {
                boolean z;
                int i2 = 0;
                if (deleteThreadHttpResponseMessage != null) {
                    FrsFragment.this.fwb.aBD();
                    FrsFragment.this.fwb.bog();
                    FrsNewAreaFragment frsNewAreaFragment = null;
                    if (FrsFragment.this.fwu == null || FrsFragment.this.fwu.btR() == null || !(FrsFragment.this.fwu.btR().fragment instanceof FrsNewAreaFragment)) {
                        z = false;
                    } else {
                        frsNewAreaFragment = (FrsNewAreaFragment) FrsFragment.this.fwu.btR().fragment;
                        z = true;
                    }
                    if (deleteThreadHttpResponseMessage.getError() == 0) {
                        String text = !TextUtils.isEmpty(deleteThreadHttpResponseMessage.getText()) ? deleteThreadHttpResponseMessage.getText() : FrsFragment.this.getString(R.string.delete_fail);
                        if (deleteThreadHttpResponseMessage.getRetType() == 1211066) {
                            if (FrsFragment.this.eGC == null) {
                                FrsFragment.this.eGC = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.eGC.mQ(text);
                            FrsFragment.this.eGC.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.24.1
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.eGC.dR(false);
                            FrsFragment.this.eGC.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.eGC.agO();
                        } else if (deleteThreadHttpResponseMessage.getRetType() == 1211067) {
                            if (FrsFragment.this.eGC == null) {
                                FrsFragment.this.eGC = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.eGC.mQ(text);
                            FrsFragment.this.eGC.a(R.string.know, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.24.2
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.eGC.dR(false);
                            FrsFragment.this.eGC.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.eGC.agO();
                        } else {
                            FrsFragment.this.fwb.aw(deleteThreadHttpResponseMessage.getText(), ContextCompat.getColor(FrsFragment.this.getContext(), deleteThreadHttpResponseMessage.getRetType() == 1 ? R.color.nav_bar_tip_error : R.color.cp_link_tip_a_alpha95));
                        }
                        if (z && frsNewAreaFragment != null) {
                            frsNewAreaFragment.cj(deleteThreadHttpResponseMessage.getSuccessItems());
                        }
                        FrsFragment.this.bY(deleteThreadHttpResponseMessage.getSuccessItems());
                        com.baidu.tieba.frs.a.blQ().bX(deleteThreadHttpResponseMessage.getSuccessItems());
                        for (com.baidu.adp.widget.ListView.m mVar : FrsFragment.this.fvE.getThreadList()) {
                            if (mVar instanceof bg) {
                                i2++;
                                continue;
                            }
                            if (i2 >= 6) {
                                break;
                            }
                        }
                        if (i2 < 6) {
                            FrsFragment.this.aJw();
                            return;
                        }
                        return;
                    }
                    com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getActivity(), deleteThreadHttpResponseMessage.getErrorString());
                }
            }
        });
        this.hasInit = true;
        rv(1);
        super.onActivityCreated(bundle);
        this.createTime = System.currentTimeMillis() - this.beginTime;
    }

    public void jR(boolean z) {
        if (this.fwu != null) {
            this.fwu.fUB = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bY(List<String> list) {
        if (!com.baidu.tbadk.core.util.v.aa(list)) {
            ArrayList<com.baidu.adp.widget.ListView.m> threadList = this.fvE.getThreadList();
            if (!com.baidu.tbadk.core.util.v.aa(threadList) && this.fwb.getListView() != null && this.fwb.getListView().getData() != null) {
                Iterator<com.baidu.adp.widget.ListView.m> it = threadList.iterator();
                List<com.baidu.adp.widget.ListView.m> data = this.fwb.getListView().getData();
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.m next = it.next();
                    if (next instanceof bg) {
                        bh bhVar = ((bg) next).threadData;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= list.size()) {
                                break;
                            } else if (!com.baidu.tbadk.core.util.aq.bV(list.get(i2), bhVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.fwE.e(next);
                                this.fwb.getListView().getAdapter().notifyItemRemoved(i);
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
    public void aJP() {
        if (isAdded() && this.drA && !isLoadingViewAttached()) {
            showLoadingView(this.fwb.aYe(), true);
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void aJQ() {
        if (isAdded() && this.drA && isLoadingViewAttached()) {
            hideLoadingView(this.fwb.aYe());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (bnl()) {
            showLoadingView(this.fwb.aYe(), true);
            this.fwb.rF(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.fws.G(3, true);
            alr().scrollToPosition(0);
        }
    }

    private void rv(int i) {
        String str = "";
        if (this.fvE != null && this.fvE.getForum() != null) {
            str = this.fvE.getForum().getId();
        }
        if (!StringUtils.isNull(str)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13008").bT("fid", str).bT("obj_type", "4").P("obj_locate", i).bT("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.w wVar) {
        if (wVar != null) {
            this.cEi = wVar.awK();
            this.fwL = wVar.awL();
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void showFloatingView() {
        if (this.cEi != null) {
            this.cEi.fP(true);
        }
    }

    private void ah(Intent intent) {
        if (intent != null) {
            if (intent != null) {
                if (!com.baidu.tieba.frs.f.f.a(this, getForumName(), "from", intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false)) && getActivity() != null) {
                    getActivity().finish();
                    return;
                }
            }
            if (intent != null && intent.getData() != null) {
                Uri data = intent.getData();
                this.fvT = data.getQueryParameter("name");
                this.mFrom = data.getQueryParameter("from");
                if (!StringUtils.isNull(this.fvT)) {
                    intent.putExtra("name", this.fvT);
                }
                if (!StringUtils.isNull(this.mFrom)) {
                    intent.putExtra("from", this.mFrom);
                }
                TiebaStatic.log("c10105");
            }
            if (StringUtils.isNull(this.fvT) && intent != null && intent.getData() != null) {
                Uri data2 = intent.getData();
                if (com.baidu.tbadk.BdToken.f.m(data2)) {
                    com.baidu.tbadk.BdToken.f.ZA().b(data2, new f.a() { // from class: com.baidu.tieba.frs.FrsFragment.25
                        @Override // com.baidu.tbadk.BdToken.f.a
                        public void o(HashMap<String, Object> hashMap) {
                            if (hashMap != null && (hashMap.get(com.baidu.tbadk.BdToken.f.bzJ) instanceof String)) {
                                FrsFragment.this.fvT = (String) hashMap.get(com.baidu.tbadk.BdToken.f.bzJ);
                            }
                        }
                    });
                } else {
                    com.baidu.tieba.frs.f.d ak = com.baidu.tieba.frs.f.i.ak(intent);
                    if (ak != null) {
                        this.fvT = ak.forumName;
                        if (ak.fSZ == null || ak.fSZ.equals("aidou")) {
                        }
                    }
                }
                if (!StringUtils.isNull(this.fvT)) {
                    intent.putExtra("name", this.fvT);
                }
                intent.putExtra(FrsActivityConfig.FRS_CALL_FROM, 12);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.fwa = getVoiceManager();
        if (this.fwa != null) {
            this.fwa.onStart(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        Intent intent;
        registerListener(2001118, this.cjl);
        if (bundle != null) {
            this.fvT = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
            this.fvT = intent.getStringExtra("name");
            this.mFrom = intent.getStringExtra("from");
            this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
        }
        if (getArguments() != null) {
            this.fvU = getArguments().getBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, false);
        }
        if (TextUtils.isEmpty(this.mFrom) || FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
        }
        if (this.mIsLogin) {
            registerListener(2001120, this.cjl);
        }
        this.fwt.R(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.q.c.cpt().v(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.fxC);
        fwf = null;
        if (this.fwa != null) {
            this.fwa.onDestory(getPageContext());
        }
        com.baidu.tieba.recapp.report.a.remove("FRS");
        this.fwa = null;
        com.baidu.tieba.card.t.bat().iH(false);
        if (this.fvE != null && this.fvE.getForum() != null) {
            aa.boE().dl(com.baidu.adp.lib.g.b.e(this.fvE.getForum().getId(), 0L));
        }
        if (this.fwH != null) {
            this.fwH.onDestory();
        }
        if (this.fwb != null) {
            com.baidu.tieba.frs.f.h.a(this.fwb, this.fvE, getForumId(), false, null);
            this.fwb.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.fwn != null) {
                this.fwn.avz();
            }
            this.fwb.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.fwt.aGu();
        if (this.fws != null) {
            this.fws.aMd();
        }
        if (this.fwy != null) {
            this.fwy.awJ();
        }
        if (this.fwB != null) {
            this.fwB.destory();
        }
        if (this.fwC != null) {
            this.fwC.destory();
        }
        if (this.fww != null) {
            this.fww.onDestroy();
        }
        if (this.fwO != null) {
            this.fwO.onDestory();
        }
        if (this.fwG != null) {
            this.fwG.onDestroy();
        }
        if (this.fwR != null) {
            this.fwR.onDestroy();
        }
        if (this.fwS != null) {
            this.fwS.onDestroy();
        }
        com.baidu.tieba.recapp.d.a.cjz().cjB();
        com.baidu.tieba.frs.f.j.btb();
        if (this.fwu != null) {
            this.fwu.a((FrsTabViewController.a) null);
            this.fwu.btT();
        }
        if (this.fwV != null) {
            this.fwV.onDestroy();
        }
        com.baidu.tieba.frs.a.blQ().a(null);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.fvT);
        bundle.putString("from", this.mFrom);
        this.fws.onSaveInstanceState(bundle);
        if (this.fwa != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            this.fwa.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.fwG != null) {
            this.fwG.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.fwb != null) {
            this.fwb.bnN();
            this.fwb.onResume();
        }
        this.fwv.kN(true);
        this.fwo = true;
        if (fvS) {
            fvS = false;
            this.fwb.startPullRefresh();
            return;
        }
        if (this.fwa != null) {
            this.fwa.onResume(getPageContext());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921338));
        this.fwb.kf(false);
        if (this.fwP) {
            refresh(6);
            this.fwP = false;
        }
        bnr();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
    }

    public boolean bmY() {
        Intent intent;
        if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
            return false;
        }
        return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
    }

    public void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.fvT = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.fvV = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.fvV) {
                bmZ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmZ() {
        this.fwb.startPullRefresh();
    }

    public void closeActivity() {
        com.baidu.tieba.frs.f.i.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.mFrom);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.fwb.setTitle(this.fvT);
        } else {
            this.fwb.setTitle("");
            this.mFlag = 1;
        }
        this.fwb.setOnAdapterItemClickListener(this.fxA);
        this.fwb.addOnScrollListener(this.mScrollListener);
        this.fwb.h(this.ftG);
        this.fwb.bnZ().a(this.fxz);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fwX) {
            this.fwb.onChangeSkinType(i);
            this.fwt.sX(i);
            this.fwu.onChangeSkinType(i);
            if (this.fwd != null) {
                this.fwd.onChangeSkinType(i);
            }
            if (this.fwM != null) {
                this.fwM.onChangeSkinType();
            }
            if (this.fwT != null) {
                this.fwT.onChangeSkinType(getPageContext(), i);
            }
            if (this.eGC != null) {
                com.baidu.tbadk.s.a.a(getPageContext(), this.eGC.agP());
            }
            if (this.fwN != null) {
                this.fwN.onChangeSkinType();
            }
        }
    }

    public void rw(int i) {
        if (!this.mIsLogin) {
            if (this.fvE != null && this.fvE.getAnti() != null) {
                this.fvE.getAnti().setIfpost(1);
            }
            if (i == 0) {
                bc.cE(getActivity());
            }
        } else if (this.fvE != null) {
            if (i == 0) {
                com.baidu.tieba.frs.f.j.d(this, 0);
            } else {
                this.fwb.bnP();
            }
        }
    }

    public void refresh() {
        com.baidu.tieba.a.d.aCV().sx("page_frs");
        refresh(3);
    }

    public void refresh(int i) {
        this.fwl = false;
        bne();
        if (this.fwb != null && this.fwb.bnE() != null) {
            this.fwb.bnE().bxn();
        }
        if (this.fws != null) {
            this.fws.G(i, true);
        }
    }

    private void bna() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.g.h.iL().d(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.29
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.Fs(FrsFragment.this.fvT);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnb() {
        bne();
        try {
            if (this.fvE != null) {
                this.fwb.aWv();
                this.fwb.jX(bnq());
                if (!com.baidu.tieba.frs.vc.f.l(this.fvE) || !com.baidu.tieba.frs.vc.f.k(this.fvE)) {
                }
                if (this.fvE.getForum() != null) {
                    this.fvT = this.fvE.getForum().getName();
                    this.forumId = this.fvE.getForum().getId();
                }
                if (this.fvE.getPage() != null) {
                    setHasMore(this.fvE.getPage().adw());
                }
                this.fwb.setTitle(this.fvT);
                this.fwb.setForumName(this.fvT);
                TbadkCoreApplication.getInst().setDefaultBubble(this.fvE.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.fvE.getUserData().getBimg_end_time());
                bna();
                bnc();
                ArrayList<com.baidu.adp.widget.ListView.m> threadList = this.fvE.getThreadList();
                if (threadList != null) {
                    this.fwb.a(threadList, this.fvE);
                    com.baidu.tieba.frs.f.c.y(this.fwb);
                    this.fwt.sY(getPageNum());
                    this.fwt.i(this.fvE);
                    this.fwu.a(this.fvE, this.fws.bsl());
                    this.fwb.bnQ();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void bnc() {
        if (this.fvE != null) {
            if (this.fvE.getIsNewUrl() == 1) {
                this.fwb.bnZ().setFromCDN(true);
            } else {
                this.fwb.bnZ().setFromCDN(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.fwv.kN(false);
        this.fwo = false;
        this.fwb.onPause();
        if (this.fwa != null) {
            this.fwa.onPause(getPageContext());
        }
        this.fwb.kf(true);
        if (this.fwC != null) {
            this.fwC.bte();
        }
        com.baidu.tbadk.BdToken.c.Zk().Zp();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.fwu != null && this.fwu.btR() != null && (this.fwu.btR().fragment instanceof BaseFragment)) {
            ((BaseFragment) this.fwu.btR().fragment).setPrimary(z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.t.bat().iH(false);
        jP(false);
        if (this.fvE != null && this.fvE.getForum() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            com.baidu.tbadk.distribute.a.arZ().a(getPageContext().getPageActivity(), "frs", this.fvE.getForum().getId(), 0L);
        }
        if (this.fwa != null) {
            this.fwa.onStop(getPageContext());
        }
        if (alr() != null) {
            alr().getRecycledViewPool().clear();
        }
        this.fwt.akI();
        com.baidu.tbadk.util.x.awN();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            if (this.fwt != null) {
                this.fwt.jV(isPrimary());
            }
            if (this.fwb != null) {
                this.fwb.jV(isPrimary());
                this.fwb.kf(!isPrimary());
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (com.baidu.tieba.frs.a.blQ().blR()) {
                com.baidu.tieba.frs.a.blQ().reset();
                return true;
            } else if (this.fwb != null) {
                return this.fwb.bnM();
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
        com.baidu.tbadk.distribute.a.arZ().a(advertAppInfo, this.forumId, 0L, "FRS", str, getPn());
    }

    @Override // com.baidu.tieba.recapp.n
    public void bnd() {
        bmE().bnd();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.fwa == null) {
            this.fwa = VoiceManager.instance();
        }
        return this.fwa;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdRecyclerView alr() {
        if (this.fwb == null) {
            return null;
        }
        return this.fwb.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void bne() {
        if (this.fwa != null) {
            this.fwa.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> als() {
        if (this.cdT == null) {
            this.cdT = UserIconBox.q(getPageContext().getPageActivity(), 8);
        }
        return this.cdT;
    }

    public void bnf() {
        if (getFragmentActivity() != null && getFragmentActivity().getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.b(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.p onGetPreLoadListView() {
        return alr().getPreLoadHandle();
    }

    @Override // com.baidu.tieba.frs.ah
    public NavigationBar aLN() {
        if (this.fwb == null) {
            return null;
        }
        return this.fwb.aLN();
    }

    public FRSRefreshButton bng() {
        return this.fwd;
    }

    public void a(FRSRefreshButton fRSRefreshButton) {
        if (fRSRefreshButton != null) {
            this.fwd = fRSRefreshButton;
            this.fwd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.36
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (FrsFragment.this.fwu != null) {
                        FrsTabViewController.b btR = FrsFragment.this.fwu.btR();
                        if (btR != null && btR.fragment != null && (btR.fragment instanceof ag)) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                            ((ag) btR.fragment).bms();
                            ((ag) btR.fragment).aKN();
                            return;
                        }
                        FrsFragment.this.bmJ().startPullRefresh();
                    }
                }
            });
        }
    }

    public void bnh() {
        if (this.fwd != null && this.fwe) {
            if (this.fwZ != null) {
                this.fwZ.cancel();
            }
            this.fwZ = new AlphaAnimation(1.0f, 0.0f);
            this.fwZ.setDuration(300L);
            this.fwZ.setFillAfter(true);
            this.fwd.startAnimation(this.fwZ);
            this.fwd.setClickable(false);
            this.fwe = false;
        }
    }

    public void bni() {
        if (this.fwd != null && !this.fwe && this.fwu.btU() != 0) {
            this.fwd.setVisibility(0);
            if (this.fxa != null) {
                this.fxa.cancel();
            }
            this.fxa = new AlphaAnimation(0.0f, 1.0f);
            this.fxa.setDuration(300L);
            this.fxa.setFillAfter(true);
            this.fwd.startAnimation(this.fxa);
            this.fwd.setClickable(true);
            this.fwe = true;
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
                if (bdUniqueId == p.fzj) {
                    if (FrsFragment.this.fwb != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11752").bT("fid", FrsFragment.this.forumId).bT("obj_locate", "1"));
                        FrsFragment.this.fwb.startPullRefresh();
                    }
                } else if (mVar != null && (mVar instanceof bg)) {
                    bh bhVar = ((bg) mVar).threadData;
                    if (bhVar.afu() == null || bhVar.afu().getGroup_id() == 0 || bc.cF(FrsFragment.this.getActivity())) {
                        if (bhVar.afm() != 1 || bc.cF(FrsFragment.this.getActivity())) {
                            if (bhVar.aeP() != null) {
                                if (bc.cF(FrsFragment.this.getActivity())) {
                                    String postUrl = bhVar.aeP().getPostUrl();
                                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.kt()) {
                                        com.baidu.tbadk.browser.a.af(FrsFragment.this.getActivity(), postUrl);
                                    }
                                }
                            } else if (bhVar.afF() != null) {
                                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                    bc.cE(FrsFragment.this.getPageContext().getPageActivity());
                                    return;
                                }
                                com.baidu.tbadk.core.data.o afF = bhVar.afF();
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), afF.getCartoonId(), afF.getChapterId(), 2)));
                            } else {
                                com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                                if (readThreadHistory != null && !readThreadHistory.Fy(bhVar.getId())) {
                                    readThreadHistory.Fx(bhVar.getId());
                                }
                                boolean z = false;
                                final String aeJ = bhVar.aeJ();
                                if (aeJ != null && !aeJ.equals("")) {
                                    z = true;
                                    new Thread(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.a.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(aeJ);
                                            xVar.aiK().ajM().mIsNeedAddCommenParam = false;
                                            xVar.aiK().ajM().mIsUseCurrentBDUSS = false;
                                            xVar.ain();
                                        }
                                    }).start();
                                }
                                String tid = bhVar.getTid();
                                if (tid == null) {
                                    tid = "";
                                }
                                if (bhVar.aex() == 2 && !tid.startsWith("pb:")) {
                                    ba.ajK().c(FrsFragment.this.getPageContext(), new String[]{tid, "", null});
                                    return;
                                }
                                if (tid.startsWith("pb:")) {
                                    bhVar.setId(tid.substring(3));
                                }
                                if (bdUniqueId.getId() == bh.bLy.getId()) {
                                    com.baidu.tieba.frs.f.h.a(bhVar.aei());
                                } else if (bdUniqueId.getId() == bh.bKe.getId()) {
                                    com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c12940");
                                    anVar.bT("obj_type", "2");
                                    anVar.bT("tid", bhVar.getTid());
                                    TiebaStatic.log(anVar);
                                }
                                com.baidu.tieba.frs.f.i.a(FrsFragment.this, bhVar, i, z);
                                com.baidu.tieba.frs.f.h.a(FrsFragment.this, FrsFragment.this.fvE, bhVar);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.l.kt()) {
            hideNetRefreshView(this.fwb.aYe());
            showLoadingView(this.fwb.aYe(), true);
            this.fwb.ka(false);
            this.fws.G(3, true);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData bnj() {
        return this.fvE;
    }

    public boolean bnk() {
        return this.fwb.bnk();
    }

    public void ar(Object obj) {
        if (this.fwx != null && this.fwx.fOB != null) {
            this.fwx.fOB.m(obj);
        }
    }

    public void as(Object obj) {
        if (this.fwx != null && this.fwx.fOC != null) {
            this.fwx.fOC.m(obj);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        this.fwb.getListView().stopScroll();
        if (!this.fwb.bnV()) {
            if (!com.baidu.adp.lib.util.l.kt()) {
                this.fwb.aKQ();
            } else if (this.fws.bsg() == 1) {
                aJK();
                aJw();
            } else if (this.fws.hasMore()) {
                aJw();
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void xc(String str) {
        aJK();
        showToast(str);
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void V(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        boolean aa = com.baidu.tbadk.core.util.v.aa(arrayList);
        setHasMore(aa ? 0 : 1);
        aJK();
        if (!aa) {
            if (!this.fws.bsp() && TbadkCoreApplication.getInst().isRecAppExist() && this.fws.bsg() == 1) {
                this.fvE.addRecommendAppToThreadList(this, arrayList);
            }
            if (this.fws != null) {
                com.baidu.tieba.frs.d.a.a(getUniqueId(), arrayList, this.fvE.getForum(), this.fws.getSortType());
            }
            ArrayList<com.baidu.adp.widget.ListView.m> a2 = this.fwE.a(false, false, arrayList, this.fvX, false);
            if (a2 != null) {
                this.fvE.setThreadList(a2);
                this.fwb.a(a2, this.fvE);
            }
            if (this.fws != null) {
                com.baidu.tieba.frs.d.c.a(this.fvE, this.fws.bsl(), 2);
            }
        }
    }

    private void aJK() {
        if (bmK() == 1 || this.fwE.ci(this.fvE.getThreadListIds())) {
            if (com.baidu.tbadk.core.util.v.Z(this.fvE.getThreadList()) > 3) {
                this.fwb.aKO();
            } else {
                this.fwb.boc();
            }
        } else if (com.baidu.tbadk.core.util.v.aa(this.fvE.getThreadList())) {
            this.fwb.aKQ();
        } else {
            this.fwb.aKP();
        }
    }

    @Override // com.baidu.tieba.frs.mc.l
    public void aJw() {
        if (this.fwE != null) {
            this.fwE.a(this.fvT, this.forumId, this.fvE);
        }
    }

    public void takePhoto() {
        if (!com.baidu.tbadk.core.util.ab.f(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.al.c(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment, com.baidu.e.a.a.InterfaceC0049a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        com.baidu.tieba.frs.f.i.a(this, i, strArr, iArr);
    }

    public void jS(boolean z) {
        if (this.fwy != null) {
            this.fwy.kp(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.fwz.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a mj(int i) {
        return this.fwz.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        this.fwI.b(bVar);
    }

    public boolean bnl() {
        return this.fvP;
    }

    @Override // com.baidu.tieba.frs.ae
    public void aJO() {
        if (this.fwb != null) {
            showFloatingView();
            this.fwb.getListView().scrollToPosition(0);
            this.fwb.startPullRefresh();
        }
    }

    public ForumWriteData bnm() {
        if (this.fvE == null || this.fvE.getForum() == null) {
            return null;
        }
        ForumData forum = this.fvE.getForum();
        ForumWriteData forumWriteData = new ForumWriteData(forum.getId(), forum.getName(), forum.getPrefixData(), this.fvE.getAnti());
        forumWriteData.avatar = forum.getImage_url();
        forumWriteData.forumLevel = forum.getUser_level();
        forumWriteData.specialForumType = forum.special_forum_type;
        forumWriteData.firstDir = forum.getFirst_class();
        forumWriteData.secondDir = forum.getSecond_class();
        UserData userData = this.fvE.getUserData();
        forumWriteData.privateThread = userData != null ? userData.getPrivateThread() : 0;
        return forumWriteData;
    }

    @Override // com.baidu.tieba.frs.ae
    public void akZ() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.frs.ae
    public void setVideoThreadId(String str) {
    }

    public void jT(boolean z) {
        this.fwp = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z) {
        super.showLoadingView(view, z);
        this.fwb.rC(8);
        ((FrsActivity) getActivity()).i(view, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        super.hideLoadingView(view);
        this.fwb.rC(0);
        ((FrsActivity) getActivity()).i(view, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        super.showNetRefreshView(view, str, z);
        this.fwb.rC(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshViewNoClick(View view, String str, boolean z) {
        super.showNetRefreshViewNoClick(view, str, z);
        this.fwb.rC(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        super.hideNetRefreshView(view);
        this.fwb.rC(0);
    }

    public void bnn() {
        FrsTabViewController.b btR;
        if (this.fwu != null && (btR = this.fwu.btR()) != null && btR.fragment != null && (btR.fragment instanceof ag)) {
            ((ag) btR.fragment).bms();
        }
    }

    public void jU(boolean z) {
        this.fvR = z;
    }

    public void b(OvalActionButton ovalActionButton) {
        this.fwc = ovalActionButton;
    }

    public OvalActionButton bno() {
        return this.fwc;
    }

    public boolean bnp() {
        return this.fvR;
    }

    public void xu(String str) {
        if (TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.util.aq.isEmpty(str)) {
            if (this.fwV == null) {
                this.fwV = new AddExperiencedModel(getTbPageContext());
                this.fwV.a(this.fxb);
            }
            this.fwV.ef(this.forumId, str);
        }
    }

    public boolean bnq() {
        if (this.fwp && !this.fwY) {
            return (this.fws != null && this.fws.bsh() && com.baidu.tieba.frs.a.blQ().blR()) ? false : true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.g.c
    public boolean videoNeedPreload() {
        if (this.fvE != null) {
            return com.baidu.tbadk.util.ac.awV() && (this.fvE.isFrsVideoAutoPlay || com.baidu.tbadk.core.sharedPref.b.ahU().getInt("auto_play_video_frs", 0) == 1);
        }
        return super.videoNeedPreload();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.g.c
    public boolean isCyberVideoUsedThisPage() {
        return com.baidu.tbadk.a.b.ly("cyber_player_test");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnr() {
        if (!com.baidu.tbadk.core.util.aq.isEmpty(this.forumId)) {
            com.baidu.tbadk.BdToken.c.Zk().l(com.baidu.tbadk.BdToken.b.bym, com.baidu.adp.lib.g.b.e(this.forumId, 0L));
        }
    }
}
