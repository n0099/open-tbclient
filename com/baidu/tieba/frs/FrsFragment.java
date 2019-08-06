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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.bd;
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
public class FrsFragment extends BaseFragment implements BdListView.e, a.InterfaceC0041a, UserIconBox.b<BdRecyclerView>, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, ae, ah, aj, com.baidu.tieba.frs.loadmore.a, com.baidu.tieba.frs.mc.l, com.baidu.tieba.recapp.n {
    public static com.baidu.tieba.tbadkCore.l fus;
    private com.baidu.tbadk.util.w cDr;
    private com.baidu.adp.lib.e.b<TbImageView> cda;
    private com.baidu.tieba.frs.gametab.b dCy;
    private com.baidu.tbadk.core.dialog.a eET;
    private com.baidu.card.z fuE;
    private FrsModelController fuF;
    private com.baidu.tieba.frs.vc.f fuG;
    private FrsTabViewController fuH;
    private com.baidu.tieba.frs.mc.h fuI;
    private com.baidu.tieba.frs.smartsort.a fuJ;
    private com.baidu.tieba.frs.mc.b fuK;
    private ak fuL;
    private com.baidu.tieba.frs.entelechy.b.b fuN;
    private com.baidu.tbadk.k.a fuO;
    private com.baidu.tieba.frs.vc.a fuP;
    private com.baidu.tieba.frs.mc.d fuQ;
    private com.baidu.tieba.frs.mc.c fuR;
    private com.baidu.tieba.frs.vc.h fuS;
    private com.baidu.tieba.frs.mc.a fuT;
    private com.baidu.tieba.frs.live.a fuU;
    private j fuV;
    public com.baidu.tieba.frs.vc.c fuW;
    private com.baidu.tieba.frs.mc.e fuX;
    private View.OnTouchListener fuY;
    private com.baidu.tieba.frs.view.a fuZ;
    private com.baidu.tieba.frs.entelechy.a fua;
    private com.baidu.tieba.tbadkCore.data.f fuk;
    private VoiceManager fun;
    private OvalActionButton fup;
    private FRSRefreshButton fuq;
    private com.baidu.tieba.frs.view.c fva;
    private com.baidu.tieba.frs.vc.e fvb;
    private boolean fvc;
    private com.baidu.tieba.NEGFeedBack.a fve;
    private com.baidu.tieba.ala.a fvf;
    private com.baidu.tieba.frs.brand.buttommenu.a fvg;
    private com.baidu.tieba.frs.sportspage.notification.a fvh;
    private AddExperiencedModel fvi;
    private boolean fvk;
    private int fvv;
    private View mRootView;
    public static boolean fuf = false;
    public static volatile long fuu = 0;
    public static volatile long fuv = 0;
    public static volatile int fuw = 0;
    public boolean fub = false;
    private boolean fuc = false;
    private boolean fud = false;
    private boolean fue = true;
    public String fug = null;
    public String mFrom = null;
    public int mFlag = 0;
    public boolean fuh = false;
    private boolean fui = false;
    private String mThreadId = null;
    public String forumId = null;
    private int ftT = 0;
    private boolean fuj = false;
    private boolean ful = false;
    private boolean fum = false;
    private k fuo = null;
    private boolean fur = false;
    public final bh ccq = null;
    private FrsViewData ftR = new FrsViewData();
    public long eXw = -1;
    public long cAc = 0;
    public long czU = 0;
    public long createTime = 0;
    public long beginTime = -1;
    public long fut = 0;
    public boolean fux = false;
    private boolean fuy = false;
    private boolean fuz = false;
    public com.baidu.tbadk.p.b fuA = null;
    private boolean fuB = true;
    private boolean fuC = true;
    private a.C0038a fuD = new a.C0038a(2);
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> fuM = new SparseArray<>();
    private boolean dpP = true;
    private boolean fvd = false;
    private boolean hasInit = false;
    private boolean fvj = false;
    private boolean fvl = false;
    private AlphaAnimation fvm = null;
    private AlphaAnimation fvn = null;
    private AddExperiencedModel.a fvo = new AddExperiencedModel.a() { // from class: com.baidu.tieba.frs.FrsFragment.1
        @Override // com.baidu.tieba.share.AddExperiencedModel.a
        public void a(ContriInfo contriInfo) {
        }
    };
    private HttpMessageListener fvp = new HttpMessageListener(CmdConfigHttp.CMD_PB_FLOOR_AGREE, true) { // from class: com.baidu.tieba.frs.FrsFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof PbFloorAgreeResponseMessage)) {
                PbFloorAgreeResponseMessage pbFloorAgreeResponseMessage = (PbFloorAgreeResponseMessage) httpResponsedMessage;
            }
        }
    };
    private final CustomMessageListener fvq = new CustomMessageListener(2016495) { // from class: com.baidu.tieba.frs.FrsFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof bh) {
                    com.baidu.tieba.frs.f.h.a(FrsFragment.this.fuo, FrsFragment.this.ftR, FrsFragment.this.getForumId(), true, (bh) data);
                }
            }
        }
    };
    private CustomMessageListener fvr = new CustomMessageListener(2921005) { // from class: com.baidu.tieba.frs.FrsFragment.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.ftR != null) {
                FrsFragment.this.ftR.removeGameRankListFromThreadList();
                if (FrsFragment.this.fuo != null) {
                    FrsFragment.this.fuo.VX();
                }
            }
        }
    };
    private CustomMessageListener Wi = new CustomMessageListener(2921401) { // from class: com.baidu.tieba.frs.FrsFragment.41
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && FrsFragment.this.fuq != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() <= 0 || FrsFragment.this.fuH.btg() == 0 || FrsFragment.this.fuH.btd() == null || !(FrsFragment.this.fuH.btd().fragment instanceof BaseFragment) || !((BaseFragment) FrsFragment.this.fuH.btd().fragment).isPrimary()) {
                    if (FrsFragment.this.fuH.btg() != 0) {
                        FrsFragment.this.bmw();
                        return;
                    }
                    return;
                }
                FrsFragment.this.bmx();
            }
        }
    };
    private CustomMessageListener fvs = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.FrsFragment.42
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 1) {
                    FrsFragment.this.bmo();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                }
            }
        }
    };
    private final ai fvt = new ai() { // from class: com.baidu.tieba.frs.FrsFragment.43
        @Override // com.baidu.tieba.frs.ai
        public void a(int i, int i2, ap apVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
            FrsFragment.this.bmb();
            if (FrsFragment.this.fuN != null) {
                FrsFragment.this.fuG.kP(FrsFragment.this.fuN.rX(i));
            }
            e.b bVar = new e.b();
            if (apVar != null) {
                bVar.isSuccess = apVar.errCode == 0;
                bVar.errorCode = apVar.errCode;
                bVar.errorMsg = apVar.errMsg;
                if (bVar.isSuccess) {
                    if (com.baidu.tbadk.core.util.v.aa(arrayList)) {
                        FrsFragment.this.fuo.aKm();
                    } else if (apVar.hasMore) {
                        if (com.baidu.tbadk.core.util.v.Z(FrsFragment.this.ftR.getThreadList()) > 3) {
                            FrsFragment.this.fuo.aKk();
                        } else {
                            FrsFragment.this.fuo.bnr();
                        }
                    } else if (apVar.fyA) {
                        FrsFragment.this.fuo.aKl();
                    } else {
                        FrsFragment.this.fuo.aKm();
                    }
                }
            } else {
                apVar = new ap();
                apVar.pn = 1;
                apVar.hasMore = false;
                apVar.fyA = false;
            }
            if (i == 1) {
                FrsFragment.this.fuB = true;
                FrsFragment.this.fvH.a(FrsFragment.this.fuF.getType(), false, bVar);
            } else {
                FrsFragment.this.a(bVar);
                if (FrsFragment.this.fuF.bqX() != null) {
                    FrsFragment.this.ftR = FrsFragment.this.fuF.bqX();
                }
                FrsFragment.this.bmq();
            }
            if (FrsFragment.this.fvO != null) {
                FrsFragment.this.fvO.a(i, i2, apVar, arrayList);
            }
        }
    };
    private FrsTabViewController.a fvu = new FrsTabViewController.a() { // from class: com.baidu.tieba.frs.FrsFragment.44
        @Override // com.baidu.tieba.frs.vc.FrsTabViewController.a
        public void kB(int i) {
            boolean z = false;
            if (i != 1) {
                com.baidu.tieba.card.t.aZP().iE(false);
                FrsFragment.this.jM(false);
            }
            if (i == 303 && i != FrsFragment.this.fvv) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13121").bT("fid", FrsFragment.this.forumId).bT("uid", TbadkCoreApplication.getCurrentAccount()));
            }
            if (i == 502) {
                FrsFragment.this.fup.setIconFade(R.drawable.btn_frs_professional_edit_n);
            } else {
                FrsFragment.this.fup.setIconFade(0);
            }
            FrsFragment.this.fvv = i;
            FrsFragment.this.bmt();
            com.baidu.tieba.frs.d.d.fCV.fPu = i;
            com.baidu.tieba.frs.d.d.fCV.fPv = -1;
            com.baidu.tieba.frs.a blf = com.baidu.tieba.frs.a.blf();
            if (i == 1 && FrsFragment.this.fvj) {
                z = true;
            }
            blf.D(z, true);
        }
    };
    private CustomMessageListener fvw = new CustomMessageListener(2001606) { // from class: com.baidu.tieba.frs.FrsFragment.45
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                FrsFragment.this.fuH.tc(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    };
    private CustomMessageListener fvx = new CustomMessageListener(2001607) { // from class: com.baidu.tieba.frs.FrsFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && ((Integer) customResponsedMessage.getData()).intValue() == 51 && FrsFragment.this.ftR != null) {
                com.baidu.tieba.frs.f.j.a(FrsFragment.this.ftR, FrsFragment.this.getPageContext());
            }
        }
    };
    private final CustomMessageListener fvy = new CustomMessageListener(2003019) { // from class: com.baidu.tieba.frs.FrsFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                FrsFragment.this.fuH.ta(49);
            }
        }
    };
    private final CustomMessageListener fvz = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.frs.FrsFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && FrsFragment.this.ftR != null && FrsFragment.this.ftR.getForum() != null) {
                SignData signData = (SignData) customResponsedMessage.getData();
                int user_level = FrsFragment.this.ftR.getForum().getUser_level();
                if (signData.forumId != null && signData.forumId.equals(FrsFragment.this.ftR.getForum().getId())) {
                    FrsFragment.this.ftR.updateSignData(signData);
                    FrsFragment.this.fuG.j(FrsFragment.this.ftR);
                    if (FrsFragment.this.fuG.bsR()) {
                        i = FrsFragment.this.ftR.getForum().getUser_level();
                        if (user_level >= i) {
                            i++;
                        }
                    } else {
                        i = user_level;
                    }
                    TbadkCoreApplication.getInst().addSignedForum(FrsFragment.this.ftR.getForum().getName(), signData.sign_bonus_point, i);
                }
            }
        }
    };
    private final CustomMessageListener fvA = new CustomMessageListener(2001352) { // from class: com.baidu.tieba.frs.FrsFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.t) && FrsFragment.this.ftR != null) {
                FrsFragment.this.ftR.updateLikeData((com.baidu.tieba.tbadkCore.t) customResponsedMessage.getData());
                FrsFragment.this.fuG.i(FrsFragment.this.ftR);
                FrsFragment.this.fuH.a(FrsFragment.this.ftR, FrsFragment.this.fuF.brz());
            }
        }
    };
    private final AntiHelper.a fvB = new AntiHelper.a() { // from class: com.baidu.tieba.frs.FrsFragment.6
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12536").P("obj_locate", au.a.bUk));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12535").P("obj_locate", au.a.bUk));
        }
    };
    private CustomMessageListener dyP = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.frs.FrsFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(FrsFragment.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().chM != null) {
                        if (AntiHelper.a(FrsFragment.this.getActivity(), updateAttentionMessage.getData().chM, FrsFragment.this.fvB) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12534").P("obj_locate", au.a.bUk));
                        }
                    } else if (updateAttentionMessage.getData().Hs && updateAttentionMessage.getData().isAttention) {
                        com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getPageContext().getPageActivity(), (int) R.string.attention_success);
                    }
                }
            }
        }
    };
    private CustomMessageListener fvC = new CustomMessageListener(2921346) { // from class: com.baidu.tieba.frs.FrsFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsFragment.this.refresh();
        }
    };
    private CustomMessageListener fvD = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.frs.FrsFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                FrsFragment.this.fuo.c((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener fvE = new CustomMessageListener(2001626) { // from class: com.baidu.tieba.frs.FrsFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewsRemindMessage newsRemindMessage;
            if (customResponsedMessage != null && (customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626 && (newsRemindMessage = (NewsRemindMessage) customResponsedMessage) != null) {
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (FrsFragment.this.fuo != null) {
                    FrsFragment.this.fuo.D(notificationCount, z);
                }
            }
        }
    };
    private final CustomMessageListener fvF = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.frs.FrsFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.isResumed()) {
                FrsFragment.this.bmG();
            }
        }
    };
    private CustomMessageListener fvG = new CustomMessageListener(2003020) { // from class: com.baidu.tieba.frs.FrsFragment.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (FrsFragment.this.fuo != null) {
                    FrsFragment.this.fuo.setExpanded(booleanValue);
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.p fvH = new com.baidu.tieba.tbadkCore.p() { // from class: com.baidu.tieba.frs.FrsFragment.14
        private long startTime = 0;

        @Override // com.baidu.tieba.tbadkCore.p
        public void ru(int i) {
            this.startTime = System.nanoTime();
            if (FrsFragment.this.fuo != null) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsFragment.this.fuo.bnc();
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
            if (FrsFragment.this.dpP) {
                FrsFragment.this.dpP = false;
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.fuo, FrsFragment.this.ftR, FrsFragment.this.getForumId(), false, null);
            }
            FrsFragment.this.bmb();
            FrsFragment.this.fuy = true;
            if (bVar != null && bVar.isSuccess) {
                FrsFragment.this.fuo.bno().ky(com.baidu.tbadk.core.util.as.ajq().ajs());
                FrsFragment.fuu = 0L;
                FrsFragment.fuv = 0L;
                FrsFragment.fuw = 0;
            } else {
                FrsFragment.fuw = 1;
            }
            if (!FrsFragment.this.fuF.brD() && (i == 3 || i == 6)) {
                FrsFragment.this.fuR.resetData();
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (FrsFragment.this.fuF.bqX() != null) {
                FrsFragment.this.ftR = FrsFragment.this.fuF.bqX();
            }
            FrsFragment.this.fuo.b(FrsFragment.this.ftR.getRedpacketRainData());
            FrsFragment.this.rq(1);
            if (i == 7) {
                FrsFragment.this.rr(FrsFragment.this.ftR.getFrsDefaultTabId());
                return;
            }
            if (FrsFragment.this.ftR.getPage() != null) {
                FrsFragment.this.setHasMore(FrsFragment.this.ftR.getPage().ads());
            }
            if (i == 4) {
                if (!FrsFragment.this.fuF.brD() && TbadkCoreApplication.getInst().isRecAppExist() && FrsFragment.this.fuF.bru() == 1) {
                    FrsFragment.this.ftR.addRecommendAppToThreadList(FrsFragment.this);
                }
                ArrayList<com.baidu.adp.widget.ListView.m> a2 = FrsFragment.this.fuR.a(false, false, FrsFragment.this.ftR.getThreadList(), FrsFragment.this.fuk, false);
                if (a2 != null) {
                    FrsFragment.this.ftR.setThreadList(a2);
                    FrsFragment.this.ftR.checkLiveStageInThreadList();
                }
                if (FrsFragment.this.fuF != null) {
                    com.baidu.tieba.frs.d.c.a(FrsFragment.this.ftR, FrsFragment.this.fuF.brz(), 2);
                }
                com.baidu.tieba.frs.f.a.a(FrsFragment.this, FrsFragment.this.ftR.getForum(), FrsFragment.this.ftR.getThreadList(), false, FrsFragment.this.getPn());
                FrsFragment.this.cAc = System.currentTimeMillis() - currentTimeMillis;
                FrsFragment.this.fuo.a(a2, FrsFragment.this.ftR);
                FrsFragment.this.bmc();
                return;
            }
            FrsFragment.this.bmc();
            switch (i) {
                case 1:
                    FrsFragment.this.fuo.bnc();
                    break;
                case 2:
                    FrsFragment.this.fuo.bnc();
                    break;
                case 3:
                case 6:
                    if (FrsFragment.this.ftR != null) {
                        FrsFragment.this.ftR.clearPostThreadCount();
                    }
                    if (FrsFragment.this.fuW != null) {
                        FrsFragment.this.fuW.refresh();
                        break;
                    }
                    break;
            }
            FrsFragment.this.bmj();
            if (bVar == null || bVar.errorCode == 0) {
                if (FrsFragment.this.ftR != null) {
                    FrsFragment.this.a(FrsFragment.this.ftR);
                    FrsFragment.this.G(false, i == 5);
                    if (FrsFragment.this.fuF != null) {
                        if (FrsFragment.this.ftR.getActivityHeadData() != null && FrsFragment.this.ftR.getActivityHeadData().acM() != null && FrsFragment.this.ftR.getActivityHeadData().acM().size() > 0) {
                            com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), 1, FrsFragment.this.ftR.getForum(), FrsFragment.this.fuF.getSortType(), 1);
                        }
                        if (FrsFragment.this.ftR.getThreadList() != null && FrsFragment.this.ftR.getThreadList().size() > 0) {
                            Iterator<com.baidu.adp.widget.ListView.m> it = FrsFragment.this.ftR.getThreadList().iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    com.baidu.adp.widget.ListView.m next = it.next();
                                    if ((next instanceof bh) && ((bh) next).getType() == bh.bLa) {
                                        com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), 1, FrsFragment.this.ftR.getForum(), FrsFragment.this.fuF.getSortType(), 2);
                                    }
                                }
                            }
                        }
                        com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), FrsFragment.this.ftR.getThreadList(), FrsFragment.this.ftR.getForum(), FrsFragment.this.fuF.getSortType());
                    }
                    FrsFragment.this.fuo.rD(i);
                    FrsFragment.fuu = (System.nanoTime() - this.startTime) / 1000000;
                    if (bVar != null) {
                        FrsFragment.fuv = bVar.jdR;
                    }
                } else {
                    return;
                }
            } else if (FrsFragment.this.ftR == null || com.baidu.tbadk.core.util.v.aa(FrsFragment.this.ftR.getThreadList())) {
                FrsFragment.this.a(bVar);
            } else if (bVar.fcf) {
                FrsFragment.this.showToast(FrsFragment.this.getPageContext().getResources().getString(R.string.net_error_text, bVar.errorMsg, Integer.valueOf(bVar.errorCode)));
            }
            FrsFragment.this.bmg();
            FrsFragment.this.bmh();
            if (FrsFragment.this.ftR.getAccessFlag() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11384"));
            }
            if (FrsFragment.this.eXw > -1 && !FrsFragment.this.fvd) {
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.fuF, FrsFragment.this.eXw);
                FrsFragment.this.eXw = -1L;
                FrsFragment.this.fvd = true;
            }
            if (FrsFragment.this.ful && FrsFragment.this.fuH.ta(49)) {
                FrsFragment.this.ful = false;
            }
            FrsFragment.this.cAc = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.p
        public void c(com.baidu.tieba.tbadkCore.l lVar) {
            if ((lVar != null && ("normal_page".equals(FrsFragment.this.fuF.getPageType()) || "frs_page".equals(FrsFragment.this.fuF.getPageType()) || "book_page".equals(FrsFragment.this.fuF.getPageType()))) || "brand_page".equals(FrsFragment.this.fuF.getPageType())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001615, lVar));
                FrsFragment.this.b(lVar);
                FrsFragment.fus = lVar;
            }
        }
    };
    private final CustomMessageListener fvI = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.frs.FrsFragment.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                FrsFragment.this.ftR.updateCurrentUserPendant((com.baidu.tbadk.data.l) customResponsedMessage.getData());
                FrsFragment.this.fuo.bno().notifyDataSetChanged();
            }
        }
    };
    private final CustomMessageListener mMemListener = new CustomMessageListener(2001194) { // from class: com.baidu.tieba.frs.FrsFragment.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && FrsFragment.this.ftR != null && (userData = FrsFragment.this.ftR.getUserData()) != null) {
                userData.setIsMem(num.intValue());
                if (num.intValue() != 0) {
                    FrsFragment.this.fuG.h(num);
                }
            }
        }
    };
    private final com.baidu.tieba.frs.mc.k fvJ = new com.baidu.tieba.frs.mc.k() { // from class: com.baidu.tieba.frs.FrsFragment.26
        @Override // com.baidu.tieba.frs.mc.k
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.m> arrayList, boolean z3) {
            if (FrsFragment.this.fuJ != null && FrsFragment.this.fuF != null && FrsFragment.this.fuF.brD() && z && !z2 && !z3) {
                FrsFragment.this.fuJ.sD(i2);
            }
        }
    };
    public final View.OnTouchListener cmw = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.FrsFragment.27
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (FrsFragment.this.fuY != null) {
                FrsFragment.this.fuY.onTouch(view, motionEvent);
            }
            if (FrsFragment.this.fuL != null && FrsFragment.this.fuL.bnW() != null) {
                FrsFragment.this.fuL.bnW().onTouchEvent(motionEvent);
            }
            if (FrsFragment.this.dCy != null) {
                FrsFragment.this.dCy.f(view, motionEvent);
            }
            if (FrsFragment.this.fuG != null) {
                FrsFragment.this.fuG.L(motionEvent);
                return false;
            }
            return false;
        }
    };
    private final CustomMessageListener fvK = new CustomMessageListener(2004507) { // from class: com.baidu.tieba.frs.FrsFragment.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.ahQ().getInt(TbadkCoreApplication.getCurrentAccount() + "photolive_hostLevel", -1) != -1 && FrsFragment.this.ftR.getForum() != null) {
                FrsFragment.this.ftR.getForum().setCanAddPhotoLivePost(true);
            }
        }
    };
    public final View.OnClickListener fvL = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.30
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsFragment.this.fuo == null || view != FrsFragment.this.fuo.bna() || FrsFragment.this.getActivity() == null) {
                if (FrsFragment.this.ftR != null && FrsFragment.this.ftR.getForum() != null && FrsFragment.this.fuo != null && view == FrsFragment.this.fuo.bng()) {
                    if (FrsFragment.this.fva == null) {
                        FrsFragment.this.fva = new com.baidu.tieba.frs.view.c(FrsFragment.this.getPageContext());
                    }
                    FrsFragment.this.fva.m(FrsFragment.this.ftR);
                    FrsFragment.this.fva.showDialog();
                    return;
                }
                if (view.getId() == R.id.game_activity_egg_layout && com.baidu.adp.lib.util.l.kt()) {
                    TiebaStatic.log("c10853");
                    if (FrsFragment.this.fuo.bnl()) {
                        FrsFragment.this.fuo.bnm();
                    } else {
                        String activityUrl = FrsFragment.this.ftR.getForum().getYuleData().agE().getActivityUrl();
                        if (!StringUtils.isNull(activityUrl)) {
                            com.baidu.tbadk.browser.a.af(FrsFragment.this.getPageContext().getPageActivity(), activityUrl);
                        }
                    }
                }
                if (view == FrsFragment.this.fuo.bns() && FrsFragment.this.fuF != null && FrsFragment.this.fuF.hasMore()) {
                    FrsFragment.this.fuo.aKk();
                    FrsFragment.this.aIS();
                }
                if (view != null && view == FrsFragment.this.fuo.bni() && bd.cF(FrsFragment.this.getContext())) {
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
        private int fvX = 0;
        private int dms = 0;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (FrsFragment.this.fuP != null) {
                FrsFragment.this.fuP.bsr();
            }
            this.fvX = 0;
            this.dms = 0;
            if (recyclerView != null && (recyclerView instanceof BdRecyclerView)) {
                this.fvX = ((BdRecyclerView) recyclerView).getFirstVisiblePosition();
                this.dms = ((BdRecyclerView) recyclerView).getLastVisiblePosition();
            }
            if (FrsFragment.this.fvb != null) {
                FrsFragment.this.fvb.a(recyclerView, this.fvX, this.dms);
            }
            if (FrsFragment.this.ftR != null && FrsFragment.this.fuo != null && FrsFragment.this.fuo.bno() != null) {
                FrsFragment.this.fuo.bs(this.fvX, this.dms);
                if (FrsFragment.this.fuE != null && FrsFragment.this.fuE.qP() != null) {
                    FrsFragment.this.fuE.qP().b(FrsFragment.this.fuD);
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (FrsFragment.this.fuG != null) {
                FrsFragment.this.fuG.setScrollState(i);
            }
            if (i == 0) {
                FrsFragment.this.fuo.bnw();
            }
            if ((i == 2 || i == 1) && !FrsFragment.this.fuz) {
                FrsFragment.this.fuz = true;
                FrsFragment.this.fuo.bnq();
            }
            if (FrsFragment.this.fuA == null && !FrsFragment.this.bmA()) {
                FrsFragment.this.fuA = new com.baidu.tbadk.p.b();
                FrsFragment.this.fuA.kR(1000);
            }
            if (i == 0) {
                if (FrsFragment.this.fuA != null) {
                    FrsFragment.this.fuA.avm();
                }
                com.baidu.tieba.card.t.aZP().iE(true);
                FrsFragment.this.jM(true);
                FrsFragment.this.fuo.br(this.fvX, this.dms);
            } else if (FrsFragment.this.fuA != null) {
                FrsFragment.this.fuA.avl();
            }
            if (FrsFragment.this.fvb != null) {
                FrsFragment.this.fvb.onScrollStateChanged(recyclerView, i);
            }
            if (i == 0) {
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.fuo, FrsFragment.this.ftR, FrsFragment.this.getForumId(), false, null);
            }
            if (FrsFragment.this.fuH != null && i == 1) {
                FrsFragment.this.fuH.btf();
            }
            if (FrsFragment.this.fuE == null) {
                if (FrsFragment.this.fuo.bmT() != null && !FrsFragment.this.fuo.bmz() && FrsFragment.this.fuo.bmT().cev() != null && (FrsFragment.this.fuo.bmT().cev().getTag() instanceof com.baidu.card.z)) {
                    FrsFragment.this.fuE = (com.baidu.card.z) FrsFragment.this.fuo.bmT().cev().getTag();
                }
            } else if (i == 0 && FrsFragment.this.fuo.bmT() != null && !FrsFragment.this.fuo.bmz() && FrsFragment.this.fuo.bmT().cev() != null && (FrsFragment.this.fuo.bmT().cev().getTag() instanceof com.baidu.card.z)) {
                FrsFragment.this.fuE = (com.baidu.card.z) FrsFragment.this.fuo.bmT().cev().getTag();
            }
            if (i == 1) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921418));
            }
        }
    };
    private final d fvM = new d() { // from class: com.baidu.tieba.frs.FrsFragment.32
        @Override // com.baidu.tieba.frs.d
        public void a(int i, int i2, View view, View view2, bh bhVar) {
            if (i != FrsFragment.this.fuo.bno().bpl()) {
                if (i != FrsFragment.this.fuo.bno().bpm()) {
                    if (i == FrsFragment.this.fuo.bno().bpj() && FrsFragment.this.ftR != null && FrsFragment.this.ftR.getUserData() != null && FrsFragment.this.ftR.getUserData().isBawu()) {
                        String bawuCenterUrl = FrsFragment.this.ftR.getBawuCenterUrl();
                        if (!com.baidu.tbadk.core.util.aq.isEmpty(bawuCenterUrl) && FrsFragment.this.ftR.getForum() != null) {
                            com.baidu.tbadk.browser.a.ae(FrsFragment.this.getPageContext().getPageActivity(), bawuCenterUrl);
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10502").bT("fid", FrsFragment.this.ftR.getForum().getId()).bT("uid", FrsFragment.this.ftR.getUserData().getUserId()));
                        }
                    }
                } else if (bd.cF(FrsFragment.this.getPageContext().getPageActivity())) {
                    TiebaStatic.log("my_service_ck");
                    if (FrsFragment.this.ftR != null && FrsFragment.this.ftR.getForum() != null) {
                        ForumData forum = FrsFragment.this.ftR.getForum();
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(forum.getId(), 0L), forum.getName(), forum.getImage_url(), 0)));
                    }
                }
            } else if (bd.cF(FrsFragment.this.getActivity())) {
                TiebaStatic.log("forum_fortune_click");
                com.baidu.tieba.frs.f.i.b(FrsFragment.this.getPageContext(), FrsFragment.this.ftR);
            }
        }
    };
    private final NoNetworkView.a frT = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.FrsFragment.33
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void ep(boolean z) {
            if (FrsFragment.this.fuF.bru() == 1 && z && !FrsFragment.this.fuo.bmz()) {
                if (FrsFragment.this.ftR == null || com.baidu.tbadk.core.util.v.aa(FrsFragment.this.ftR.getThreadList())) {
                    FrsFragment.this.hideNetRefreshView(FrsFragment.this.fuo.aXA());
                    FrsFragment.this.showLoadingView(FrsFragment.this.fuo.aXA(), true);
                    FrsFragment.this.fuo.jX(false);
                    FrsFragment.this.refresh();
                    return;
                }
                FrsFragment.this.fuo.bnc();
            }
        }
    };
    private final CustomMessageListener ciq = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.FrsFragment.35
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                com.baidu.tieba.frs.f.c.a(customResponsedMessage, FrsFragment.this.fuo, FrsFragment.this.ftR);
            }
        }
    };
    private com.baidu.adp.widget.ListView.s fvN = new a();
    private ai fvO = new ai() { // from class: com.baidu.tieba.frs.FrsFragment.37
        @Override // com.baidu.tieba.frs.ai
        public void a(int i, int i2, ap apVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
            com.baidu.adp.lib.g.e.iK().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.37.1
                @Override // java.lang.Runnable
                public void run() {
                    if (FrsFragment.this.fuo != null && FrsFragment.this.fuo.baO()) {
                        FrsFragment.this.aIS();
                    }
                }
            });
        }
    };
    private CustomMessageListener fvP = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.frs.FrsFragment.38
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    FrsFragment.this.fvc = true;
                }
            }
        }
    };
    private CustomMessageListener fvQ = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.frs.FrsFragment.39
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                    if (FrsFragment.this.fuE == null && FrsFragment.this.fuo.bmT() != null && !FrsFragment.this.fuo.bmz() && FrsFragment.this.fuo.bmT().cev() != null && (FrsFragment.this.fuo.bmT().cev().getTag() instanceof com.baidu.card.z)) {
                        FrsFragment.this.fuE = (com.baidu.card.z) FrsFragment.this.fuo.bmT().cev().getTag();
                    }
                    if (FrsFragment.this.fuE != null && FrsFragment.this.fuE.qP() != null) {
                        FrsFragment.this.fuE.qP().b(new a.C0038a(3));
                    }
                }
            }
        }
    };
    private CustomMessageListener fvR = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.FrsFragment.40
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.fuo != null) {
                FrsFragment.this.fuo.bny();
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.frs.loadmore.a
    public /* bridge */ /* synthetic */ com.baidu.adp.base.e getPageContext() {
        return super.getPageContext();
    }

    public com.baidu.tieba.frs.entelechy.b.b blP() {
        return this.fuN;
    }

    public com.baidu.adp.widget.ListView.s blQ() {
        return this.fvN;
    }

    public com.baidu.tieba.frs.mc.d blR() {
        return this.fuQ;
    }

    public com.baidu.tieba.frs.smartsort.a blS() {
        return this.fuJ;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public FrsModelController blT() {
        return this.fuF;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public com.baidu.tieba.frs.mc.c blU() {
        return this.fuR;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public com.baidu.tieba.frs.vc.f blV() {
        return this.fuG;
    }

    public FrsTabViewController blW() {
        return this.fuH;
    }

    public ak blX() {
        return this.fuL;
    }

    public void jL(boolean z) {
        this.fvl = z;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public k blY() {
        return this.fuo;
    }

    @Override // com.baidu.tieba.frs.aj
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.aj, com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.fug;
    }

    public void setForumName(String str) {
        this.fug = str;
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
        if (this.fuR == null) {
            return 1;
        }
        return this.fuR.getPn();
    }

    public int getPn() {
        if (this.fuR == null) {
            return 1;
        }
        return this.fuR.getPn();
    }

    public void setPn(int i) {
        if (this.fuR != null) {
            this.fuR.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.fuR != null) {
            this.fuR.setHasMore(i);
        }
    }

    public int blZ() {
        if (this.fuR == null) {
            return -1;
        }
        return this.fuR.blZ();
    }

    public boolean bma() {
        return this.fum;
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
            this.fuo.bmW();
            showNetRefreshView(this.fuo.aXA(), string, true);
        } else if (340001 == bVar.errorCode) {
            a(bVar, this.ftR.getRecm_forum_list());
        } else {
            if (com.baidu.tbadk.core.util.v.aa(this.ftR.getThreadList())) {
                b(bVar);
            }
            if (bmA()) {
                setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst(), R.dimen.ds280));
            } else {
                setNetRefreshViewEmotionDefMarginTop();
            }
        }
    }

    public void a(View view, String str, boolean z, List<RecmForumInfo> list) {
        this.fuo.bmW();
        this.fuo.rz(8);
        if (this.fuZ == null) {
            this.fuZ = new com.baidu.tieba.frs.view.a(getPageContext(), getNetRefreshListener());
        }
        this.fuZ.qN(str);
        this.fuZ.co(list);
        this.fuZ.attachView(view, z);
    }

    private void a(e.b bVar, List<RecmForumInfo> list) {
        if (this.fuo != null) {
            this.fuo.bmW();
            this.fuo.setTitle(this.fug);
            a(this.fuo.aXA(), bVar.errorMsg, true, list);
        }
    }

    private void b(e.b bVar) {
        this.fuo.bmW();
        if (bVar.fcf) {
            showNetRefreshView(this.fuo.aXA(), TbadkCoreApplication.getInst().getString(R.string.net_error_text, new Object[]{bVar.errorMsg, Integer.valueOf(bVar.errorCode)}), true);
        } else {
            showNetRefreshView(this.fuo.aXA(), bVar.errorMsg, true);
        }
    }

    public void bmb() {
        hideLoadingView(this.fuo.aXA());
        this.fuo.jZ(false);
        if (this.fuo.bmU() instanceof com.baidu.tieba.frs.tab.c) {
            ((com.baidu.tieba.frs.tab.c) this.fuo.bmU()).brW();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmc() {
        if (blZ() == 0 && com.baidu.tbadk.core.util.v.aa(this.ftR.getThreadListIds())) {
            if (com.baidu.tbadk.core.util.v.aa(this.ftR.getThreadList())) {
                this.fuo.aKm();
            } else {
                this.fuo.aKl();
            }
        } else if (com.baidu.tbadk.core.util.v.Z(this.ftR.getThreadList()) > 3) {
            this.fuo.aKk();
        } else {
            this.fuo.bnr();
        }
    }

    public void a(ErrorData errorData) {
        String stringExtra = getActivity().getIntent().getStringExtra("name");
        if (getActivity().getIntent().getIntExtra(FrsActivityConfig.FRS_CALL_FROM, -1) == 12 && errorData != null && errorData.error_code == 3 && !StringUtils.isNull(stringExtra) && TbadkCoreApplication.isLogin()) {
            sendMessage(new CustomMessage(2002001, new CreateBarGuideActivityConfig(getContext(), stringExtra)));
            getActivity().finish();
            return;
        }
        bmb();
        this.fuo.bnc();
        e.b brr = this.fuF.brr();
        boolean aa = com.baidu.tbadk.core.util.v.aa(this.ftR.getThreadList());
        if (brr != null && aa) {
            if (this.fuF.brs() != 0) {
                this.fuF.brx();
                this.fuo.bnc();
            } else {
                a(brr);
            }
            this.fuo.H(this.ftR.isStarForum(), false);
            return;
        }
        a(brr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.l lVar) {
        if (lVar != null && lVar.getEntelechyTabInfo() != null && lVar.getEntelechyTabInfo().tab != null) {
            for (FrsTabInfo frsTabInfo : lVar.getEntelechyTabInfo().tab) {
                if (frsTabInfo.tab_id.intValue() == 502 && com.baidu.tbadk.core.sharedPref.b.ahQ().getBoolean("first_into_tab_profession", true)) {
                    return;
                }
            }
        }
        new com.baidu.tieba.frs.ad.f(getTbPageContext()).a(lVar);
    }

    public boolean bmd() {
        return bme() && !bmf();
    }

    private boolean bme() {
        if (bmy() == null) {
            return false;
        }
        FrsViewData bmy = bmy();
        com.baidu.tbadk.core.data.s sVar = null;
        if (bmy.getStar() != null && !StringUtils.isNull(bmy.getStar().coV())) {
            sVar = new com.baidu.tbadk.core.data.s();
        } else if (bmy.getActivityHeadData() != null && com.baidu.tbadk.core.util.v.Z(bmy.getActivityHeadData().acM()) >= 1) {
            sVar = bmy.getActivityHeadData().acM().get(0);
        }
        return sVar != null;
    }

    public boolean bmf() {
        if (bmy() == null) {
            return false;
        }
        FrsViewData bmy = bmy();
        return (com.baidu.tbadk.core.util.v.aa(bmy.getShowTopThreadList()) && bmy.getBusinessPromot() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmg() {
        boolean b;
        if (!bmi()) {
            final PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
            privateForumPopInfoData.a(this.ftR.getPrivateForumTotalInfo().getPrivatePopInfo());
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(getActivity());
            if (this.ftR.getPrivateForumTotalInfo().adz().private_forum_status.intValue() == 1 && (com.baidu.tbadk.core.util.aq.isEmpty(privateForumPopInfoData.adB()) || privateForumPopInfoData.adE() != Integer.valueOf(this.forumId))) {
                privateForumPopInfoData.mr("create_success");
                privateForumPopInfoData.ms(TbadkCoreApplication.getInst().getString(R.string.frs_private_create_hint));
                privateForumPopInfoData.mt("https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.fug + "&nomenu=1");
                privateForumPopInfoData.b(Integer.valueOf(this.forumId));
                b = frsPrivateCommonDialogView.b(privateForumPopInfoData);
            } else {
                b = privateForumPopInfoData.adE() == Integer.valueOf(this.forumId) ? frsPrivateCommonDialogView.b(privateForumPopInfoData) : false;
            }
            if (b) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
                aVar.hx(2);
                aVar.aH(frsPrivateCommonDialogView);
                aVar.dR(false);
                frsPrivateCommonDialogView.setConfirmButton(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.15
                    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.frs.FrsFragment */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        bb.ajE().c(FrsFragment.this.getPageContext(), new String[]{privateForumPopInfoData.adD()});
                        aVar.dismiss();
                    }
                });
                aVar.a(new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.16
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(getPageContext()).agK();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmh() {
        if (bmi() || this.ftR.getPrivateForumTotalInfo().adz().private_forum_status.intValue() != 1) {
            a((Integer) null, (Integer) null, true);
        } else {
            a(this.ftR.getPrivateForumTotalInfo().adz().private_forum_audit_status, this.ftR.getPrivateForumTotalInfo().adA(), false);
        }
    }

    public void a(Integer num, Integer num2, boolean z) {
        final String str;
        final int i = 2;
        if (this.fuo.bnh() != null) {
            TextView bnh = this.fuo.bnh();
            if (z) {
                bnh.setVisibility(8);
                return;
            }
            if (num.intValue() == 2) {
                bnh.setText("修改实名认证信息");
                bnh.setVisibility(0);
                str = "https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + this.forumId + "&nomenu=1";
            } else if (num2.intValue() >= 0 && num2.intValue() <= 100) {
                bnh.setText("目标已完成" + String.valueOf(num2) + "%");
                bnh.setVisibility(0);
                str = "https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.fug + "&nomenu=1";
                i = 1;
            } else {
                bnh.setVisibility(8);
                i = 0;
                str = "";
            }
            bnh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.17
                /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13387").bT("fid", FrsFragment.this.forumId).bT("uid", TbadkCoreApplication.getCurrentAccount()).P("obj_type", i));
                    bb.ajE().c(FrsFragment.this.getPageContext(), new String[]{str});
                }
            });
        }
    }

    private boolean bmi() {
        return this.ftR == null || !this.ftR.isPrivateForum() || this.ftR.getPrivateForumTotalInfo() == null || this.ftR.getPrivateForumTotalInfo().adz() == null || this.ftR.getUserData().getIs_manager() != 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rq(int i) {
        List<WindowToast> list;
        if (TbadkCoreApplication.isLogin() && this.ftR != null && (list = this.ftR.mWindowToast) != null && list.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < list.size()) {
                    WindowToast windowToast = list.get(i3);
                    if (windowToast == null || windowToast.toast_type.intValue() != i) {
                        i2 = i3 + 1;
                    } else if (!com.baidu.tbadk.core.util.aq.isEmpty(windowToast.toast_link)) {
                        sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(getPageContext().getPageActivity(), "", com.baidu.tbadk.util.ae.rs(windowToast.toast_link), true)));
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
    public void bmj() {
        if (this.ftR == null || this.ftR.getForum() != null) {
            this.fuo.bnn();
        } else if (this.ftR.getForum().getYuleData() != null && this.ftR.getForum().getYuleData().agD()) {
            TiebaStatic.log("c10852");
            this.fuo.a(this.ftR.getForum().getYuleData().agE());
        } else {
            this.fuo.bnn();
        }
    }

    private void F(boolean z, boolean z2) {
        if (this.fuF != null && this.ftR != null && this.fuo != null && z) {
            if (!this.fuF.brD() && this.fuF.bru() == 1) {
                if (!this.fuF.brB()) {
                    this.ftR.addCardVideoInfoToThreadList();
                    this.ftR.addVideoInfoToThreadListInTenAndFifteenFloor();
                }
                boolean z3 = false;
                if (this.fuo.bno().n(com.baidu.tieba.card.data.n.eGw)) {
                    z3 = this.ftR.addHotTopicDataToThreadList();
                }
                if (!z3) {
                    this.ftR.addFeedForumDataToThreadList();
                }
                if (TbadkCoreApplication.getInst().isRecAppExist()) {
                    this.ftR.addRecommendAppToThreadList(this);
                }
                if (!this.fuo.bno().n(bh.bJD)) {
                    this.ftR.removeAlaLiveThreadData();
                }
                this.ftR.addSchoolRecommendToThreadList();
            }
            if (!this.fuo.bno().n(bh.bJD)) {
                this.ftR.removeAlaInsertLiveData();
                this.ftR.removeAlaStageLiveDat();
            } else {
                this.ftR.addInsertLiveDataToThreadList();
                this.ftR.addStageLiveDataToThreadList();
            }
            this.ftR.checkLiveStageInThreadList();
            this.ftR.addNoticeThreadToThreadList();
            if (this.fuo.bno().n(com.baidu.tieba.h.b.fXj)) {
                this.ftR.addGameRankListToThreadList(z2);
            }
            if (TbadkCoreApplication.isLogin() && (!this.fuF.brD() || this.fuF.isNetFirstLoad)) {
                this.ftR.addUserRecommendToThreadList();
            }
            this.ftR.addVideoActivityToTop();
        }
    }

    public boolean bmk() {
        if (this.fuG != null && this.fuF != null) {
            this.fuG.a(this.fuF.getPageType(), this.ftR);
        }
        boolean z = false;
        if (this.ftR != null) {
            z = this.ftR.hasTab();
        }
        bmm();
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rr(int i) {
        am amVar = null;
        bmk();
        bmt();
        try {
            if (this.ftR != null) {
                this.fuo.a((ArrayList<com.baidu.adp.widget.ListView.m>) null, this.ftR);
                this.fuG.sU(1);
                this.fuo.bnf();
                this.fuH.a(this.ftR, this.fuF.brz());
                com.baidu.tieba.frs.tab.d tb = this.fuH.tb(this.ftR.getFrsDefaultTabId());
                if (tb != null && !TextUtils.isEmpty(tb.url)) {
                    amVar = new am();
                    amVar.fyx = tb.url;
                    amVar.stType = tb.name;
                }
                this.fuF.a(this.ftR.getFrsDefaultTabId(), 0, amVar);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(boolean z, boolean z2) {
        try {
            if (this.ftR != null && this.fuH != null && this.fuF != null) {
                if (!this.fuo.bno().n(bh.bJD)) {
                    this.ftR.removeAlaLiveThreadData();
                }
                boolean aa = com.baidu.tbadk.core.util.v.aa(this.ftR.getGameTabInfo());
                this.fuo.jV(aa);
                if (!aa) {
                    if (this.fvb == null) {
                        this.fvb = new com.baidu.tieba.frs.vc.e(this, (NoPressedRelativeLayout) this.mRootView);
                    }
                    if (this.dCy == null) {
                        this.dCy = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
                    }
                } else {
                    this.fvb = null;
                    this.dCy = null;
                }
                if (this.ftR.getForum() != null) {
                    this.fug = this.ftR.getForum().getName();
                    this.forumId = this.ftR.getForum().getId();
                }
                if (this.ftR.hasTab()) {
                    this.fuH.a(this.ftR, this.fuF.brz());
                }
                if (z) {
                    F(true, z);
                } else {
                    F(this.fuB, z);
                }
                bmk();
                if (this.fuN != null) {
                    this.fuN.a(this.fuG, this.ftR);
                }
                if (this.ftR.getPage() != null) {
                    setHasMore(this.ftR.getPage().ads());
                }
                ArrayList<com.baidu.adp.widget.ListView.m> a2 = this.fuR.a(z2, true, this.ftR.getThreadList(), null, z, false);
                if (a2 != null) {
                    this.ftR.setThreadList(a2);
                }
                this.ftR.removeRedundantUserRecommendData();
                this.ftT = this.ftR.getTopThreadSize();
                if (this.fuk != null) {
                    this.fuj = true;
                    this.fuk.Bc(this.ftT);
                    com.baidu.tieba.frs.f.a.a(this, this.ftR.getForum(), this.ftR.getThreadList(), this.fuj, getPn());
                }
                if (this.fuF.bru() == 1) {
                    bmq();
                    if (!z && this.fuF.getPn() == 1) {
                        bml();
                    }
                }
                if (this.fuP != null) {
                    this.fuP.bY(this.fuH.btc());
                }
                bmb();
                this.fuo.bmX();
                this.fuo.H(true, false);
                if (z && this.ftR.isFirstTabEqualAllThread()) {
                    com.baidu.adp.lib.g.e.iK().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.18
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!FrsFragment.this.fuy) {
                                FrsFragment.this.fuo.bnx();
                            }
                        }
                    });
                }
                if (this.ftR.getForum() != null) {
                    this.fuo.wW(this.ftR.getForum().getWarningMsg());
                }
                if (this.ftR != null && this.ftR.getFrsVideoActivityData() != null && com.baidu.tbadk.core.sharedPref.b.ahQ().getLong("frs_video_activity_guide", 0L) == 0) {
                    com.baidu.adp.lib.g.e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.19
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsFragment.this.fuo.bnu();
                        }
                    }, 1000L);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2921326, this));
                this.fuo.bmR();
                if (this.ftR != null && this.ftR.getForum() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016564, new VisitedForumData(this.ftR.getForum().getId(), this.ftR.getForum().getName(), this.ftR.getForum().getImage_url(), String.valueOf(System.currentTimeMillis() / 1000), "showlive".equals(this.ftR.getForum().special_forum_type), this.ftR.getForum().getThemeColorInfo(), this.ftR.getForum().getMember_num())));
                }
                this.fvg.a(this.ftR.bottomMenuList, this.ftR.getForum());
                bmG();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void jM(boolean z) {
        com.baidu.tieba.q.c.coG().b(getUniqueId(), z);
    }

    public void bml() {
        if (this.fuU == null) {
            this.fuU = new com.baidu.tieba.frs.live.a(this, com.baidu.adp.lib.g.b.f(this.forumId, 0));
        }
        this.fuU.brd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.tbadkCore.l lVar) {
        try {
            if (!this.fuy && lVar != null && this.ftR != null) {
                this.ftR.receiveData(lVar);
                G(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void bmm() {
        if (this.fuF != null) {
            wU(this.fuF.getPageType());
        } else {
            wU("normal_page");
        }
    }

    private void wU(String str) {
        jN("frs_page".equals(str));
        if (this.fuN != null) {
            this.fuN.a(this.fuG, this.fuo, this.ftR);
        }
    }

    public void jN(boolean z) {
        if (this.fuS != null) {
            this.fuS.bsW();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.q.c.coG().u(getUniqueId());
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.frs_activity, viewGroup, false);
            this.fua = new com.baidu.tieba.frs.entelechy.a();
            this.fuN = this.fua.boQ();
            this.fuG = new com.baidu.tieba.frs.vc.f(this, this.fua, (FrsHeaderViewContainer) this.mRootView.findViewById(R.id.header_view_container));
            this.fuH = new FrsTabViewController(this, this.mRootView);
            this.fuH.registerListener();
            this.fuG.a(this.fuH);
            this.fuH.a(this.fvu);
            Intent intent = getActivity().getIntent();
            if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                this.fuc = true;
            }
            this.fuo = new k(this, this.fvL, this.fua, this.fuc, this.fuG);
            this.fvg = new com.baidu.tieba.frs.brand.buttommenu.a(getPageContext(), this.mRootView);
        } else {
            if (this.mRootView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            if (this.fuH != null) {
                this.fuH.registerListener();
            }
            this.fuo.bnt();
            this.mRootView.setLeft(0);
            this.mRootView.setRight(com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst().getContext()));
        }
        this.fvk = true;
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        ArrayList<com.baidu.adp.widget.ListView.m> arrayList = null;
        this.eXw = System.currentTimeMillis();
        this.beginTime = this.eXw;
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.ful = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.eXw = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            ah(intent);
        }
        this.czU = this.beginTime - this.eXw;
        this.fuk = new com.baidu.tieba.tbadkCore.data.f("frs", com.baidu.tieba.tbadkCore.data.f.jfC);
        if (this.fuF == null) {
            this.fuF = new FrsModelController(this, this.fvH);
            this.fuF.a(this.fvt);
            this.fuF.init();
        }
        if (intent != null) {
            this.fuF.K(intent.getExtras());
        } else if (bundle != null) {
            this.fuF.K(bundle);
        } else {
            this.fuF.K(null);
        }
        if (intent != null) {
            this.fuG.R(intent.getExtras());
        } else if (bundle != null) {
            this.fuG.R(bundle);
        } else {
            this.fuG.R(null);
        }
        this.fun = getVoiceManager();
        this.fuV = new j(getPageContext(), this);
        initUI();
        initData(bundle);
        if (!bmA()) {
            this.fuL = new ak(getActivity(), this.fuo, this.fuG);
            this.fuL.km(true);
        }
        this.fun = getVoiceManager();
        if (this.fun != null) {
            this.fun.onCreate(getPageContext());
        }
        new com.baidu.tieba.frs.mc.i();
        int i = -1;
        if (this.fuR != null && this.fuR.bro() != null) {
            i = this.fuR.bro().blZ();
            arrayList = this.fuR.bro().getDataList();
        }
        this.fuR = new com.baidu.tieba.frs.mc.c(this, this.fvJ);
        this.fuR.bro().setHasMore(i);
        if (arrayList != null && arrayList.size() > 0) {
            this.fuR.bro().ad(arrayList);
        }
        this.fuJ = new com.baidu.tieba.frs.smartsort.a(this);
        this.fuS = new com.baidu.tieba.frs.vc.h(this);
        this.fuP = new com.baidu.tieba.frs.vc.a(getPageContext(), this.fuF.brA());
        this.fuK = new com.baidu.tieba.frs.mc.b(this);
        this.fuQ = new com.baidu.tieba.frs.mc.d(this);
        this.fuI = new com.baidu.tieba.frs.mc.h(this);
        this.fuT = new com.baidu.tieba.frs.mc.a(this);
        this.fuW = new com.baidu.tieba.frs.vc.c(this);
        this.fuX = new com.baidu.tieba.frs.mc.e(this, getUniqueId());
        this.fve = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "frs");
        this.fvf = new com.baidu.tieba.ala.a(getPageContext());
        this.fvh = new com.baidu.tieba.frs.sportspage.notification.a(getPageContext());
        registerListener(this.dyP);
        registerListener(this.mMemListener);
        registerListener(this.fvA);
        registerListener(this.fvK);
        registerListener(this.fvz);
        registerListener(this.fvI);
        registerListener(this.fvw);
        registerListener(this.fvx);
        registerListener(this.fvy);
        registerListener(this.fvq);
        registerListener(this.fvr);
        registerListener(this.Wi);
        registerListener(this.fvP);
        registerListener(this.fvD);
        registerListener(this.fvs);
        registerListener(this.fvE);
        registerListener(this.fvC);
        this.fvp.setTag(getPageContext().getUniqueId());
        registerListener(this.fvp);
        registerListener(this.fvF);
        registerListener(this.fvG);
        this.fvQ.setTag(getPageContext().getUniqueId());
        MessageManager.getInstance().registerListener(this.fvQ);
        registerListener(this.fvR);
        this.fuo.jX(false);
        if (!bmA() && !this.hasInit) {
            showLoadingView(this.fuo.aXA(), true);
            this.fuF.F(3, false);
        }
        com.baidu.tieba.frs.a.blf().a(new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.22
            @Override // com.baidu.tieba.frs.a.b
            public void E(boolean z, boolean z2) {
                if (FrsFragment.this.fuo != null) {
                    FrsFragment.this.fuo.rA(z ? 0 : 8);
                    if (!z2) {
                        FrsFragment.this.fvj = z;
                    }
                    if (FrsFragment.this.fuo.bno() != null && FrsFragment.this.fuF != null && FrsFragment.this.fuF.brv()) {
                        FrsFragment.this.fuo.bno().notifyDataSetChanged();
                    }
                    if (FrsFragment.this.blW() != null) {
                        FrsTabViewController.b btd = FrsFragment.this.blW().btd();
                        if (btd != null && btd.tabId == 502 && (btd.fragment instanceof FrsCommonTabFragment)) {
                            ((FrsCommonTabFragment) btd.fragment).boM();
                        } else if (btd != null && btd.tabId == 503 && (btd.fragment instanceof FrsNewAreaFragment)) {
                            FrsNewAreaFragment frsNewAreaFragment = (FrsNewAreaFragment) btd.fragment;
                            frsNewAreaFragment.boM();
                            if (frsNewAreaFragment.brG() != null) {
                                com.baidu.tieba.frs.mc.g brG = frsNewAreaFragment.brG();
                                brG.ka(!z);
                                brG.kb(!z);
                            }
                        }
                        if (FrsFragment.this.blW().bsX() != null) {
                            FrsFragment.this.blW().bsX().setmDisallowSlip(z);
                            FrsFragment.this.blW().kR(z);
                        }
                    }
                    if (FrsFragment.this.fuo.bmV() != null) {
                        FrsFragment.this.fuo.jU(!z);
                    }
                    if (FrsFragment.this.getActivity() instanceof FrsActivity) {
                        ((FrsActivity) FrsFragment.this.getActivity()).jK(!z);
                    }
                    if (FrsFragment.this.fvg != null) {
                        FrsFragment.this.fvg.ku(!z);
                    }
                    FrsFragment.this.fuo.ka(!z);
                    FrsFragment.this.fuo.kb(z ? false : true);
                }
            }

            @Override // com.baidu.tieba.frs.a.b
            public void rn(int i2) {
                if (FrsFragment.this.fuo != null) {
                    FrsFragment.this.fuo.rB(i2);
                }
            }

            @Override // com.baidu.tieba.frs.a.b
            public void blm() {
                com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getContext(), (int) R.string.frs_multi_delete_max_num);
            }
        });
        this.fuo.b(new d.a() { // from class: com.baidu.tieba.frs.FrsFragment.24
            @Override // com.baidu.tieba.NEGFeedBack.d.a
            public void a(DeleteThreadHttpResponseMessage deleteThreadHttpResponseMessage) {
                boolean z;
                int i2 = 0;
                if (deleteThreadHttpResponseMessage != null) {
                    FrsFragment.this.fuo.aBp();
                    FrsFragment.this.fuo.bnv();
                    FrsNewAreaFragment frsNewAreaFragment = null;
                    if (FrsFragment.this.fuH == null || FrsFragment.this.fuH.btd() == null || !(FrsFragment.this.fuH.btd().fragment instanceof FrsNewAreaFragment)) {
                        z = false;
                    } else {
                        frsNewAreaFragment = (FrsNewAreaFragment) FrsFragment.this.fuH.btd().fragment;
                        z = true;
                    }
                    if (deleteThreadHttpResponseMessage.getError() == 0) {
                        String text = !TextUtils.isEmpty(deleteThreadHttpResponseMessage.getText()) ? deleteThreadHttpResponseMessage.getText() : FrsFragment.this.getString(R.string.delete_fail);
                        if (deleteThreadHttpResponseMessage.getRetType() == 1211066) {
                            if (FrsFragment.this.eET == null) {
                                FrsFragment.this.eET = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.eET.mO(text);
                            FrsFragment.this.eET.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.24.1
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.eET.dR(false);
                            FrsFragment.this.eET.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.eET.agK();
                        } else if (deleteThreadHttpResponseMessage.getRetType() == 1211067) {
                            if (FrsFragment.this.eET == null) {
                                FrsFragment.this.eET = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.eET.mO(text);
                            FrsFragment.this.eET.a(R.string.know, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.24.2
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.eET.dR(false);
                            FrsFragment.this.eET.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.eET.agK();
                        } else {
                            FrsFragment.this.fuo.au(deleteThreadHttpResponseMessage.getText(), ContextCompat.getColor(FrsFragment.this.getContext(), deleteThreadHttpResponseMessage.getRetType() == 1 ? R.color.nav_bar_tip_error : R.color.cp_link_tip_a_alpha95));
                        }
                        if (z && frsNewAreaFragment != null) {
                            frsNewAreaFragment.cj(deleteThreadHttpResponseMessage.getSuccessItems());
                        }
                        FrsFragment.this.bY(deleteThreadHttpResponseMessage.getSuccessItems());
                        com.baidu.tieba.frs.a.blf().bX(deleteThreadHttpResponseMessage.getSuccessItems());
                        for (com.baidu.adp.widget.ListView.m mVar : FrsFragment.this.ftR.getThreadList()) {
                            if (mVar instanceof bg) {
                                i2++;
                                continue;
                            }
                            if (i2 >= 6) {
                                break;
                            }
                        }
                        if (i2 < 6) {
                            FrsFragment.this.aIS();
                            return;
                        }
                        return;
                    }
                    com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getActivity(), deleteThreadHttpResponseMessage.getErrorString());
                }
            }
        });
        this.hasInit = true;
        rs(1);
        super.onActivityCreated(bundle);
        this.createTime = System.currentTimeMillis() - this.beginTime;
    }

    public void jO(boolean z) {
        if (this.fuH != null) {
            this.fuH.fSK = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bY(List<String> list) {
        if (!com.baidu.tbadk.core.util.v.aa(list)) {
            ArrayList<com.baidu.adp.widget.ListView.m> threadList = this.ftR.getThreadList();
            if (!com.baidu.tbadk.core.util.v.aa(threadList) && this.fuo.getListView() != null && this.fuo.getListView().getData() != null) {
                Iterator<com.baidu.adp.widget.ListView.m> it = threadList.iterator();
                List<com.baidu.adp.widget.ListView.m> data = this.fuo.getListView().getData();
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
                                this.fuR.e(next);
                                this.fuo.getListView().getAdapter().notifyItemRemoved(i);
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
    public void aJl() {
        if (isAdded() && this.dpP && !isLoadingViewAttached()) {
            showLoadingView(this.fuo.aXA(), true);
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void aJm() {
        if (isAdded() && this.dpP && isLoadingViewAttached()) {
            hideLoadingView(this.fuo.aXA());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (bmA()) {
            showLoadingView(this.fuo.aXA(), true);
            this.fuo.rC(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.fuF.F(3, true);
            alf().scrollToPosition(0);
        }
    }

    private void rs(int i) {
        String str = "";
        if (this.ftR != null && this.ftR.getForum() != null) {
            str = this.ftR.getForum().getId();
        }
        if (!StringUtils.isNull(str)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13008").bT("fid", str).bT("obj_type", "4").P("obj_locate", i).bT("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.x xVar) {
        if (xVar != null) {
            this.cDr = xVar.awy();
            this.fuY = xVar.awz();
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void showFloatingView() {
        if (this.cDr != null) {
            this.cDr.fM(true);
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
                this.fug = data.getQueryParameter("name");
                this.mFrom = data.getQueryParameter("from");
                if (!StringUtils.isNull(this.fug)) {
                    intent.putExtra("name", this.fug);
                }
                if (!StringUtils.isNull(this.mFrom)) {
                    intent.putExtra("from", this.mFrom);
                }
                TiebaStatic.log("c10105");
            }
            if (StringUtils.isNull(this.fug) && intent != null && intent.getData() != null) {
                Uri data2 = intent.getData();
                if (com.baidu.tbadk.BdToken.f.m(data2)) {
                    com.baidu.tbadk.BdToken.f.Zw().b(data2, new f.a() { // from class: com.baidu.tieba.frs.FrsFragment.25
                        @Override // com.baidu.tbadk.BdToken.f.a
                        public void o(HashMap<String, Object> hashMap) {
                            if (hashMap != null && (hashMap.get(com.baidu.tbadk.BdToken.f.bzl) instanceof String)) {
                                FrsFragment.this.fug = (String) hashMap.get(com.baidu.tbadk.BdToken.f.bzl);
                            }
                        }
                    });
                } else {
                    com.baidu.tieba.frs.f.d ak = com.baidu.tieba.frs.f.i.ak(intent);
                    if (ak != null) {
                        this.fug = ak.forumName;
                        if (ak.fRi == null || ak.fRi.equals("aidou")) {
                        }
                    }
                }
                if (!StringUtils.isNull(this.fug)) {
                    intent.putExtra("name", this.fug);
                }
                intent.putExtra(FrsActivityConfig.FRS_CALL_FROM, 12);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.fun = getVoiceManager();
        if (this.fun != null) {
            this.fun.onStart(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        Intent intent;
        registerListener(2001118, this.ciq);
        if (bundle != null) {
            this.fug = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
            this.fug = intent.getStringExtra("name");
            this.mFrom = intent.getStringExtra("from");
            this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
        }
        if (getArguments() != null) {
            this.fuh = getArguments().getBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, false);
        }
        if (TextUtils.isEmpty(this.mFrom) || FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
        }
        if (this.mIsLogin) {
            registerListener(2001120, this.ciq);
        }
        this.fuG.R(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.q.c.coG().v(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.fvP);
        fus = null;
        if (this.fun != null) {
            this.fun.onDestory(getPageContext());
        }
        com.baidu.tieba.recapp.report.a.remove("FRS");
        this.fun = null;
        com.baidu.tieba.card.t.aZP().iE(false);
        if (this.ftR != null && this.ftR.getForum() != null) {
            aa.bnT().di(com.baidu.adp.lib.g.b.c(this.ftR.getForum().getId(), 0L));
        }
        if (this.fuU != null) {
            this.fuU.onDestory();
        }
        if (this.fuo != null) {
            com.baidu.tieba.frs.f.h.a(this.fuo, this.ftR, getForumId(), false, null);
            this.fuo.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.fuA != null) {
                this.fuA.avn();
            }
            this.fuo.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.fuG.aFQ();
        if (this.fuF != null) {
            this.fuF.aLz();
        }
        if (this.fuL != null) {
            this.fuL.awx();
        }
        if (this.fuO != null) {
            this.fuO.destory();
        }
        if (this.fuP != null) {
            this.fuP.destory();
        }
        if (this.fuJ != null) {
            this.fuJ.onDestroy();
        }
        if (this.fvb != null) {
            this.fvb.onDestory();
        }
        if (this.fuT != null) {
            this.fuT.onDestroy();
        }
        if (this.fve != null) {
            this.fve.onDestroy();
        }
        if (this.fvf != null) {
            this.fvf.onDestroy();
        }
        com.baidu.tieba.recapp.d.a.ciL().ciN();
        com.baidu.tieba.frs.f.j.bso();
        if (this.fuH != null) {
            this.fuH.a((FrsTabViewController.a) null);
            this.fuH.btf();
        }
        if (this.fvi != null) {
            this.fvi.onDestroy();
        }
        com.baidu.tieba.frs.a.blf().a(null);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.fug);
        bundle.putString("from", this.mFrom);
        this.fuF.onSaveInstanceState(bundle);
        if (this.fun != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            this.fun.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.fuT != null) {
            this.fuT.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.fuo != null) {
            this.fuo.bnc();
            this.fuo.onResume();
        }
        this.fuI.kK(true);
        this.fuB = true;
        if (fuf) {
            fuf = false;
            this.fuo.startPullRefresh();
            return;
        }
        if (this.fun != null) {
            this.fun.onResume(getPageContext());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921338));
        this.fuo.kc(false);
        if (this.fvc) {
            refresh(6);
            this.fvc = false;
        }
        bmG();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
    }

    public boolean bmn() {
        Intent intent;
        if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
            return false;
        }
        return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
    }

    public void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.fug = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.fui = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.fui) {
                bmo();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmo() {
        this.fuo.startPullRefresh();
    }

    public void closeActivity() {
        com.baidu.tieba.frs.f.i.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.mFrom);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.fuo.setTitle(this.fug);
        } else {
            this.fuo.setTitle("");
            this.mFlag = 1;
        }
        this.fuo.setOnAdapterItemClickListener(this.fvN);
        this.fuo.addOnScrollListener(this.mScrollListener);
        this.fuo.h(this.frT);
        this.fuo.bno().a(this.fvM);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fvk) {
            this.fuo.onChangeSkinType(i);
            this.fuG.sT(i);
            this.fuH.onChangeSkinType(i);
            if (this.fuq != null) {
                this.fuq.onChangeSkinType(i);
            }
            if (this.fuZ != null) {
                this.fuZ.onChangeSkinType();
            }
            if (this.fvg != null) {
                this.fvg.onChangeSkinType(getPageContext(), i);
            }
            if (this.eET != null) {
                com.baidu.tbadk.s.a.a(getPageContext(), this.eET.agL());
            }
            if (this.fva != null) {
                this.fva.onChangeSkinType();
            }
        }
    }

    public void rt(int i) {
        if (!this.mIsLogin) {
            if (this.ftR != null && this.ftR.getAnti() != null) {
                this.ftR.getAnti().setIfpost(1);
            }
            if (i == 0) {
                bd.cE(getActivity());
            }
        } else if (this.ftR != null) {
            if (i == 0) {
                com.baidu.tieba.frs.f.j.d(this, 0);
            } else {
                this.fuo.bne();
            }
        }
    }

    public void refresh() {
        com.baidu.tieba.a.d.aCH().sl("page_frs");
        refresh(3);
    }

    public void refresh(int i) {
        this.fuy = false;
        bmt();
        if (this.fuo != null && this.fuo.bmT() != null) {
            this.fuo.bmT().bwz();
        }
        if (this.fuF != null) {
            this.fuF.F(i, true);
        }
    }

    private void bmp() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.g.h.iL().d(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.29
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.ES(FrsFragment.this.fug);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmq() {
        bmt();
        try {
            if (this.ftR != null) {
                this.fuo.aVR();
                this.fuo.jU(bmF());
                if (!com.baidu.tieba.frs.vc.f.l(this.ftR) || !com.baidu.tieba.frs.vc.f.k(this.ftR)) {
                }
                if (this.ftR.getForum() != null) {
                    this.fug = this.ftR.getForum().getName();
                    this.forumId = this.ftR.getForum().getId();
                }
                if (this.ftR.getPage() != null) {
                    setHasMore(this.ftR.getPage().ads());
                }
                this.fuo.setTitle(this.fug);
                this.fuo.setForumName(this.fug);
                TbadkCoreApplication.getInst().setDefaultBubble(this.ftR.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.ftR.getUserData().getBimg_end_time());
                bmp();
                bmr();
                ArrayList<com.baidu.adp.widget.ListView.m> threadList = this.ftR.getThreadList();
                if (threadList != null) {
                    this.fuo.a(threadList, this.ftR);
                    com.baidu.tieba.frs.f.c.y(this.fuo);
                    this.fuG.sU(getPageNum());
                    this.fuG.i(this.ftR);
                    this.fuH.a(this.ftR, this.fuF.brz());
                    this.fuo.bnf();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void bmr() {
        if (this.ftR != null) {
            if (this.ftR.getIsNewUrl() == 1) {
                this.fuo.bno().setFromCDN(true);
            } else {
                this.fuo.bno().setFromCDN(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.fuI.kK(false);
        this.fuB = false;
        this.fuo.onPause();
        if (this.fun != null) {
            this.fun.onPause(getPageContext());
        }
        this.fuo.kc(true);
        if (this.fuP != null) {
            this.fuP.bsr();
        }
        com.baidu.tbadk.BdToken.c.Zg().Zl();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.fuH != null && this.fuH.btd() != null && (this.fuH.btd().fragment instanceof BaseFragment)) {
            ((BaseFragment) this.fuH.btd().fragment).setPrimary(z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.t.aZP().iE(false);
        jM(false);
        if (this.ftR != null && this.ftR.getForum() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            com.baidu.tbadk.distribute.a.arN().a(getPageContext().getPageActivity(), "frs", this.ftR.getForum().getId(), 0L);
        }
        if (this.fun != null) {
            this.fun.onStop(getPageContext());
        }
        if (alf() != null) {
            alf().getRecycledViewPool().clear();
        }
        this.fuG.akw();
        com.baidu.tbadk.util.y.awB();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            if (this.fuG != null) {
                this.fuG.jS(isPrimary());
            }
            if (this.fuo != null) {
                this.fuo.jS(isPrimary());
                this.fuo.kc(!isPrimary());
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (com.baidu.tieba.frs.a.blf().blg()) {
                com.baidu.tieba.frs.a.blf().reset();
                return true;
            } else if (this.fuo != null) {
                return this.fuo.bnb();
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
        com.baidu.tbadk.distribute.a.arN().a(advertAppInfo, this.forumId, 0L, "FRS", str, getPn());
    }

    @Override // com.baidu.tieba.recapp.n
    public void bms() {
        blT().bms();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.fun == null) {
            this.fun = VoiceManager.instance();
        }
        return this.fun;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdRecyclerView alf() {
        if (this.fuo == null) {
            return null;
        }
        return this.fuo.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void bmt() {
        if (this.fun != null) {
            this.fun.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> alg() {
        if (this.cda == null) {
            this.cda = UserIconBox.q(getPageContext().getPageActivity(), 8);
        }
        return this.cda;
    }

    public void bmu() {
        if (getFragmentActivity() != null && getFragmentActivity().getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.b(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.p onGetPreLoadListView() {
        return alf().getPreLoadHandle();
    }

    @Override // com.baidu.tieba.frs.ah
    public NavigationBar aLj() {
        if (this.fuo == null) {
            return null;
        }
        return this.fuo.aLj();
    }

    public FRSRefreshButton bmv() {
        return this.fuq;
    }

    public void a(FRSRefreshButton fRSRefreshButton) {
        if (fRSRefreshButton != null) {
            this.fuq = fRSRefreshButton;
            this.fuq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.36
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (FrsFragment.this.fuH != null) {
                        FrsTabViewController.b btd = FrsFragment.this.fuH.btd();
                        if (btd != null && btd.fragment != null && (btd.fragment instanceof ag)) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                            ((ag) btd.fragment).blH();
                            ((ag) btd.fragment).aKj();
                            return;
                        }
                        FrsFragment.this.blY().startPullRefresh();
                    }
                }
            });
        }
    }

    public void bmw() {
        if (this.fuq != null && this.fur) {
            if (this.fvm != null) {
                this.fvm.cancel();
            }
            this.fvm = new AlphaAnimation(1.0f, 0.0f);
            this.fvm.setDuration(300L);
            this.fvm.setFillAfter(true);
            this.fuq.startAnimation(this.fvm);
            this.fuq.setClickable(false);
            this.fur = false;
        }
    }

    public void bmx() {
        if (this.fuq != null && !this.fur && this.fuH.btg() != 0) {
            this.fuq.setVisibility(0);
            if (this.fvn != null) {
                this.fvn.cancel();
            }
            this.fvn = new AlphaAnimation(0.0f, 1.0f);
            this.fvn.setDuration(300L);
            this.fvn.setFillAfter(true);
            this.fuq.startAnimation(this.fvn);
            this.fuq.setClickable(true);
            this.fur = true;
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
                if (bdUniqueId == p.fxw) {
                    if (FrsFragment.this.fuo != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11752").bT("fid", FrsFragment.this.forumId).bT("obj_locate", "1"));
                        FrsFragment.this.fuo.startPullRefresh();
                    }
                } else if (mVar != null && (mVar instanceof bg)) {
                    bh bhVar = ((bg) mVar).threadData;
                    if (bhVar.afq() == null || bhVar.afq().getGroup_id() == 0 || bd.cF(FrsFragment.this.getActivity())) {
                        if (bhVar.afi() != 1 || bd.cF(FrsFragment.this.getActivity())) {
                            if (bhVar.aeL() != null) {
                                if (bd.cF(FrsFragment.this.getActivity())) {
                                    String postUrl = bhVar.aeL().getPostUrl();
                                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.kt()) {
                                        com.baidu.tbadk.browser.a.af(FrsFragment.this.getActivity(), postUrl);
                                    }
                                }
                            } else if (bhVar.afB() != null) {
                                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                    bd.cE(FrsFragment.this.getPageContext().getPageActivity());
                                    return;
                                }
                                com.baidu.tbadk.core.data.o afB = bhVar.afB();
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), afB.getCartoonId(), afB.getChapterId(), 2)));
                            } else {
                                com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                                if (readThreadHistory != null && !readThreadHistory.EY(bhVar.getId())) {
                                    readThreadHistory.EX(bhVar.getId());
                                }
                                boolean z = false;
                                final String aeF = bhVar.aeF();
                                if (aeF != null && !aeF.equals("")) {
                                    z = true;
                                    new Thread(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.a.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(aeF);
                                            xVar.aiG().ajG().mIsNeedAddCommenParam = false;
                                            xVar.aiG().ajG().mIsUseCurrentBDUSS = false;
                                            xVar.aij();
                                        }
                                    }).start();
                                }
                                String tid = bhVar.getTid();
                                if (tid == null) {
                                    tid = "";
                                }
                                if (bhVar.aet() == 2 && !tid.startsWith("pb:")) {
                                    bb.ajE().c(FrsFragment.this.getPageContext(), new String[]{tid, "", null});
                                    return;
                                }
                                if (tid.startsWith("pb:")) {
                                    bhVar.setId(tid.substring(3));
                                }
                                if (bdUniqueId.getId() == bh.bLa.getId()) {
                                    com.baidu.tieba.frs.f.h.a(bhVar.aee());
                                } else if (bdUniqueId.getId() == bh.bJG.getId()) {
                                    com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c12940");
                                    anVar.bT("obj_type", "2");
                                    anVar.bT("tid", bhVar.getTid());
                                    TiebaStatic.log(anVar);
                                }
                                com.baidu.tieba.frs.f.i.a(FrsFragment.this, bhVar, i, z);
                                com.baidu.tieba.frs.f.h.a(FrsFragment.this, FrsFragment.this.ftR, bhVar);
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
            hideNetRefreshView(this.fuo.aXA());
            showLoadingView(this.fuo.aXA(), true);
            this.fuo.jX(false);
            this.fuF.F(3, true);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData bmy() {
        return this.ftR;
    }

    public boolean bmz() {
        return this.fuo.bmz();
    }

    public void ar(Object obj) {
        if (this.fuK != null && this.fuK.fMM != null) {
            this.fuK.fMM.m(obj);
        }
    }

    public void as(Object obj) {
        if (this.fuK != null && this.fuK.fMN != null) {
            this.fuK.fMN.m(obj);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        this.fuo.getListView().stopScroll();
        if (!this.fuo.bnk()) {
            if (!com.baidu.adp.lib.util.l.kt()) {
                this.fuo.aKm();
            } else if (this.fuF.bru() == 1) {
                aJg();
                aIS();
            } else if (this.fuF.hasMore()) {
                aIS();
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void wD(String str) {
        aJg();
        showToast(str);
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void V(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        boolean aa = com.baidu.tbadk.core.util.v.aa(arrayList);
        setHasMore(aa ? 0 : 1);
        aJg();
        if (!aa) {
            if (!this.fuF.brD() && TbadkCoreApplication.getInst().isRecAppExist() && this.fuF.bru() == 1) {
                this.ftR.addRecommendAppToThreadList(this, arrayList);
            }
            if (this.fuF != null) {
                com.baidu.tieba.frs.d.a.a(getUniqueId(), arrayList, this.ftR.getForum(), this.fuF.getSortType());
            }
            ArrayList<com.baidu.adp.widget.ListView.m> a2 = this.fuR.a(false, false, arrayList, this.fuk, false);
            if (a2 != null) {
                this.ftR.setThreadList(a2);
                this.fuo.a(a2, this.ftR);
            }
            if (this.fuF != null) {
                com.baidu.tieba.frs.d.c.a(this.ftR, this.fuF.brz(), 2);
            }
        }
    }

    private void aJg() {
        if (blZ() == 1 || this.fuR.ci(this.ftR.getThreadListIds())) {
            if (com.baidu.tbadk.core.util.v.Z(this.ftR.getThreadList()) > 3) {
                this.fuo.aKk();
            } else {
                this.fuo.bnr();
            }
        } else if (com.baidu.tbadk.core.util.v.aa(this.ftR.getThreadList())) {
            this.fuo.aKm();
        } else {
            this.fuo.aKl();
        }
    }

    @Override // com.baidu.tieba.frs.mc.l
    public void aIS() {
        if (this.fuR != null) {
            this.fuR.a(this.fug, this.forumId, this.ftR);
        }
    }

    public void takePhoto() {
        if (!com.baidu.tbadk.core.util.ab.e(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.al.c(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment, com.baidu.e.a.a.InterfaceC0041a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        com.baidu.tieba.frs.f.i.a(this, i, strArr, iArr);
    }

    public void jP(boolean z) {
        if (this.fuL != null) {
            this.fuL.km(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.fuM.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a mf(int i) {
        return this.fuM.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        this.fuV.b(bVar);
    }

    public boolean bmA() {
        return this.fuc;
    }

    @Override // com.baidu.tieba.frs.ae
    public void aJk() {
        if (this.fuo != null) {
            showFloatingView();
            this.fuo.getListView().scrollToPosition(0);
            this.fuo.startPullRefresh();
        }
    }

    public ForumWriteData bmB() {
        if (this.ftR == null || this.ftR.getForum() == null) {
            return null;
        }
        ForumData forum = this.ftR.getForum();
        ForumWriteData forumWriteData = new ForumWriteData(forum.getId(), forum.getName(), forum.getPrefixData(), this.ftR.getAnti());
        forumWriteData.avatar = forum.getImage_url();
        forumWriteData.forumLevel = forum.getUser_level();
        forumWriteData.specialForumType = forum.special_forum_type;
        forumWriteData.firstDir = forum.getFirst_class();
        forumWriteData.secondDir = forum.getSecond_class();
        UserData userData = this.ftR.getUserData();
        forumWriteData.privateThread = userData != null ? userData.getPrivateThread() : 0;
        return forumWriteData;
    }

    @Override // com.baidu.tieba.frs.ae
    public void akN() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.frs.ae
    public void setVideoThreadId(String str) {
    }

    public void jQ(boolean z) {
        this.fuC = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z) {
        super.showLoadingView(view, z);
        this.fuo.rz(8);
        ((FrsActivity) getActivity()).i(view, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        super.hideLoadingView(view);
        this.fuo.rz(0);
        ((FrsActivity) getActivity()).i(view, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        super.showNetRefreshView(view, str, z);
        this.fuo.rz(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshViewNoClick(View view, String str, boolean z) {
        super.showNetRefreshViewNoClick(view, str, z);
        this.fuo.rz(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        super.hideNetRefreshView(view);
        this.fuo.rz(0);
    }

    public void bmC() {
        FrsTabViewController.b btd;
        if (this.fuH != null && (btd = this.fuH.btd()) != null && btd.fragment != null && (btd.fragment instanceof ag)) {
            ((ag) btd.fragment).blH();
        }
    }

    public void jR(boolean z) {
        this.fue = z;
    }

    public void b(OvalActionButton ovalActionButton) {
        this.fup = ovalActionButton;
    }

    public OvalActionButton bmD() {
        return this.fup;
    }

    public boolean bmE() {
        return this.fue;
    }

    public void wV(String str) {
        if (TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.util.aq.isEmpty(str)) {
            if (this.fvi == null) {
                this.fvi = new AddExperiencedModel(getTbPageContext());
                this.fvi.a(this.fvo);
            }
            this.fvi.ee(this.forumId, str);
        }
    }

    public boolean bmF() {
        if (this.fuC && !this.fvl) {
            return (this.fuF != null && this.fuF.brv() && com.baidu.tieba.frs.a.blf().blg()) ? false : true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.e.c
    public boolean videoNeedPreload() {
        if (this.ftR != null) {
            return com.baidu.tbadk.util.ad.awJ() && (this.ftR.isFrsVideoAutoPlay || com.baidu.tbadk.core.sharedPref.b.ahQ().getInt("auto_play_video_frs", 0) == 1);
        }
        return super.videoNeedPreload();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmG() {
        if (!com.baidu.tbadk.core.util.aq.isEmpty(this.forumId)) {
            com.baidu.tbadk.BdToken.c.Zg().l(com.baidu.tbadk.BdToken.b.bxO, com.baidu.adp.lib.g.b.c(this.forumId, 0L));
        }
    }
}
