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
import tbclient.WindowToast;
/* loaded from: classes4.dex */
public class FrsFragment extends BaseFragment implements BdListView.e, a.InterfaceC0041a, UserIconBox.b<BdRecyclerView>, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, ae, ah, aj, com.baidu.tieba.frs.loadmore.a, com.baidu.tieba.frs.mc.l, com.baidu.tieba.recapp.n {
    public static com.baidu.tieba.tbadkCore.j ftT;
    private com.baidu.tbadk.util.w cDk;
    private com.baidu.adp.lib.e.b<TbImageView> ccT;
    private com.baidu.tieba.frs.gametab.b dCr;
    private com.baidu.tbadk.core.dialog.a eEM;
    private com.baidu.tieba.frs.entelechy.a ftB;
    private com.baidu.tieba.tbadkCore.data.f ftL;
    private VoiceManager ftO;
    private OvalActionButton ftQ;
    private FRSRefreshButton ftR;
    private com.baidu.tieba.frs.view.a fuA;
    private com.baidu.tieba.frs.view.c fuB;
    private com.baidu.tieba.frs.vc.e fuC;
    private boolean fuD;
    private com.baidu.tieba.NEGFeedBack.a fuF;
    private com.baidu.tieba.ala.a fuG;
    private com.baidu.tieba.frs.brand.buttommenu.a fuH;
    private com.baidu.tieba.frs.sportspage.notification.a fuI;
    private AddExperiencedModel fuJ;
    private boolean fuL;
    private int fuW;
    private com.baidu.card.z fuf;
    private FrsModelController fug;
    private com.baidu.tieba.frs.vc.f fuh;
    private FrsTabViewController fui;
    private com.baidu.tieba.frs.mc.h fuj;
    private com.baidu.tieba.frs.smartsort.a fuk;
    private com.baidu.tieba.frs.mc.b ful;
    private ak fum;
    private com.baidu.tieba.frs.entelechy.b.b fuo;
    private com.baidu.tbadk.k.a fup;
    private com.baidu.tieba.frs.vc.a fuq;
    private com.baidu.tieba.frs.mc.d fur;
    private com.baidu.tieba.frs.mc.c fus;
    private com.baidu.tieba.frs.vc.h fut;
    private com.baidu.tieba.frs.mc.a fuu;
    private com.baidu.tieba.frs.live.a fuv;
    private j fuw;
    public com.baidu.tieba.frs.vc.c fux;
    private com.baidu.tieba.frs.mc.e fuy;
    private View.OnTouchListener fuz;
    private View mRootView;
    public static boolean ftG = false;
    public static volatile long ftV = 0;
    public static volatile long ftW = 0;
    public static volatile int ftX = 0;
    public boolean ftC = false;
    private boolean ftD = false;
    private boolean ftE = false;
    private boolean ftF = true;
    public String ftH = null;
    public String mFrom = null;
    public int mFlag = 0;
    public boolean ftI = false;
    private boolean ftJ = false;
    private String mThreadId = null;
    public String forumId = null;
    private int ftu = 0;
    private boolean ftK = false;
    private boolean ftM = false;
    private boolean ftN = false;
    private k ftP = null;
    private boolean ftS = false;
    public final bg ccj = null;
    private FrsViewData fts = new FrsViewData();
    public long eXm = -1;
    public long czV = 0;
    public long czN = 0;
    public long createTime = 0;
    public long beginTime = -1;
    public long ftU = 0;
    public boolean ftY = false;
    private boolean ftZ = false;
    private boolean fua = false;
    public com.baidu.tbadk.p.b fub = null;
    private boolean fuc = true;
    private boolean fud = true;
    private a.C0038a fue = new a.C0038a(2);
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> fun = new SparseArray<>();
    private boolean dpI = true;
    private boolean fuE = false;
    private boolean hasInit = false;
    private boolean fuK = false;
    private boolean fuM = false;
    private AlphaAnimation fuN = null;
    private AlphaAnimation fuO = null;
    private AddExperiencedModel.a fuP = new AddExperiencedModel.a() { // from class: com.baidu.tieba.frs.FrsFragment.1
        @Override // com.baidu.tieba.share.AddExperiencedModel.a
        public void a(ContriInfo contriInfo) {
        }
    };
    private HttpMessageListener fuQ = new HttpMessageListener(CmdConfigHttp.CMD_PB_FLOOR_AGREE, true) { // from class: com.baidu.tieba.frs.FrsFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof PbFloorAgreeResponseMessage)) {
                PbFloorAgreeResponseMessage pbFloorAgreeResponseMessage = (PbFloorAgreeResponseMessage) httpResponsedMessage;
            }
        }
    };
    private final CustomMessageListener fuR = new CustomMessageListener(2016495) { // from class: com.baidu.tieba.frs.FrsFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof bg) {
                    com.baidu.tieba.frs.f.h.a(FrsFragment.this.ftP, FrsFragment.this.fts, FrsFragment.this.getForumId(), true, (bg) data);
                }
            }
        }
    };
    private CustomMessageListener fuS = new CustomMessageListener(2921005) { // from class: com.baidu.tieba.frs.FrsFragment.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.fts != null) {
                FrsFragment.this.fts.removeGameRankListFromThreadList();
                if (FrsFragment.this.ftP != null) {
                    FrsFragment.this.ftP.VX();
                }
            }
        }
    };
    private CustomMessageListener Wi = new CustomMessageListener(2921401) { // from class: com.baidu.tieba.frs.FrsFragment.41
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && FrsFragment.this.ftR != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() <= 0 || FrsFragment.this.fui.bsT() == 0 || FrsFragment.this.fui.bsQ() == null || !(FrsFragment.this.fui.bsQ().fragment instanceof BaseFragment) || !((BaseFragment) FrsFragment.this.fui.bsQ().fragment).isPrimary()) {
                    if (FrsFragment.this.fui.bsT() != 0) {
                        FrsFragment.this.bmm();
                        return;
                    }
                    return;
                }
                FrsFragment.this.bmn();
            }
        }
    };
    private CustomMessageListener fuT = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.FrsFragment.42
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 1) {
                    FrsFragment.this.bme();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                }
            }
        }
    };
    private final ai fuU = new ai() { // from class: com.baidu.tieba.frs.FrsFragment.43
        @Override // com.baidu.tieba.frs.ai
        public void a(int i, int i2, ap apVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
            FrsFragment.this.blU();
            if (FrsFragment.this.fuo != null) {
                FrsFragment.this.fuh.kP(FrsFragment.this.fuo.rV(i));
            }
            e.b bVar = new e.b();
            if (apVar != null) {
                bVar.isSuccess = apVar.errCode == 0;
                bVar.errorCode = apVar.errCode;
                bVar.errorMsg = apVar.errMsg;
                if (bVar.isSuccess) {
                    if (com.baidu.tbadk.core.util.v.aa(arrayList)) {
                        FrsFragment.this.ftP.aKk();
                    } else if (apVar.hasMore) {
                        if (com.baidu.tbadk.core.util.v.Z(FrsFragment.this.fts.getThreadList()) > 3) {
                            FrsFragment.this.ftP.aKi();
                        } else {
                            FrsFragment.this.ftP.bnh();
                        }
                    } else if (apVar.fyb) {
                        FrsFragment.this.ftP.aKj();
                    } else {
                        FrsFragment.this.ftP.aKk();
                    }
                }
            } else {
                apVar = new ap();
                apVar.pn = 1;
                apVar.hasMore = false;
                apVar.fyb = false;
            }
            if (i == 1) {
                FrsFragment.this.fuc = true;
                FrsFragment.this.fvi.a(FrsFragment.this.fug.getType(), false, bVar);
            } else {
                FrsFragment.this.a(bVar);
                if (FrsFragment.this.fug.bqK() != null) {
                    FrsFragment.this.fts = FrsFragment.this.fug.bqK();
                }
                FrsFragment.this.bmg();
            }
            if (FrsFragment.this.fvp != null) {
                FrsFragment.this.fvp.a(i, i2, apVar, arrayList);
            }
        }
    };
    private FrsTabViewController.a fuV = new FrsTabViewController.a() { // from class: com.baidu.tieba.frs.FrsFragment.44
        @Override // com.baidu.tieba.frs.vc.FrsTabViewController.a
        public void kA(int i) {
            boolean z = false;
            if (i != 1) {
                com.baidu.tieba.card.t.aZN().iE(false);
                FrsFragment.this.jM(false);
            }
            if (i == 303 && i != FrsFragment.this.fuW) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13121").bT("fid", FrsFragment.this.forumId).bT("uid", TbadkCoreApplication.getCurrentAccount()));
            }
            if (i == 502) {
                FrsFragment.this.ftQ.setIconFade(R.drawable.btn_frs_professional_edit_n);
            } else {
                FrsFragment.this.ftQ.setIconFade(0);
            }
            FrsFragment.this.fuW = i;
            FrsFragment.this.bmj();
            com.baidu.tieba.frs.d.d.fCh.fOG = i;
            com.baidu.tieba.frs.d.d.fCh.fOH = -1;
            com.baidu.tieba.frs.a bkY = com.baidu.tieba.frs.a.bkY();
            if (i == 1 && FrsFragment.this.fuK) {
                z = true;
            }
            bkY.D(z, true);
        }
    };
    private CustomMessageListener fuX = new CustomMessageListener(2001606) { // from class: com.baidu.tieba.frs.FrsFragment.45
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                FrsFragment.this.fui.ta(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    };
    private CustomMessageListener fuY = new CustomMessageListener(2001607) { // from class: com.baidu.tieba.frs.FrsFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && ((Integer) customResponsedMessage.getData()).intValue() == 51 && FrsFragment.this.fts != null) {
                com.baidu.tieba.frs.f.j.a(FrsFragment.this.fts, FrsFragment.this.getPageContext());
            }
        }
    };
    private final CustomMessageListener fuZ = new CustomMessageListener(2003019) { // from class: com.baidu.tieba.frs.FrsFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                FrsFragment.this.fui.sY(49);
            }
        }
    };
    private final CustomMessageListener fva = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.frs.FrsFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && FrsFragment.this.fts != null && FrsFragment.this.fts.getForum() != null) {
                SignData signData = (SignData) customResponsedMessage.getData();
                int user_level = FrsFragment.this.fts.getForum().getUser_level();
                if (signData.forumId != null && signData.forumId.equals(FrsFragment.this.fts.getForum().getId())) {
                    FrsFragment.this.fts.updateSignData(signData);
                    FrsFragment.this.fuh.j(FrsFragment.this.fts);
                    if (FrsFragment.this.fuh.bsE()) {
                        i = FrsFragment.this.fts.getForum().getUser_level();
                        if (user_level >= i) {
                            i++;
                        }
                    } else {
                        i = user_level;
                    }
                    TbadkCoreApplication.getInst().addSignedForum(FrsFragment.this.fts.getForum().getName(), signData.sign_bonus_point, i);
                }
            }
        }
    };
    private final CustomMessageListener fvb = new CustomMessageListener(2001352) { // from class: com.baidu.tieba.frs.FrsFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.r) && FrsFragment.this.fts != null) {
                FrsFragment.this.fts.updateLikeData((com.baidu.tieba.tbadkCore.r) customResponsedMessage.getData());
                FrsFragment.this.fuh.i(FrsFragment.this.fts);
                FrsFragment.this.fui.a(FrsFragment.this.fts, FrsFragment.this.fug.brm());
            }
        }
    };
    private final AntiHelper.a fvc = new AntiHelper.a() { // from class: com.baidu.tieba.frs.FrsFragment.6
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12536").P("obj_locate", au.a.bUe));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12535").P("obj_locate", au.a.bUe));
        }
    };
    private CustomMessageListener dyI = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.frs.FrsFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(FrsFragment.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().chF != null) {
                        if (AntiHelper.a(FrsFragment.this.getActivity(), updateAttentionMessage.getData().chF, FrsFragment.this.fvc) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12534").P("obj_locate", au.a.bUe));
                        }
                    } else if (updateAttentionMessage.getData().Hs && updateAttentionMessage.getData().isAttention) {
                        com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getPageContext().getPageActivity(), (int) R.string.attention_success);
                    }
                }
            }
        }
    };
    private CustomMessageListener fvd = new CustomMessageListener(2921346) { // from class: com.baidu.tieba.frs.FrsFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsFragment.this.refresh();
        }
    };
    private CustomMessageListener fve = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.frs.FrsFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                FrsFragment.this.ftP.c((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener fvf = new CustomMessageListener(2001626) { // from class: com.baidu.tieba.frs.FrsFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewsRemindMessage newsRemindMessage;
            if (customResponsedMessage != null && (customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626 && (newsRemindMessage = (NewsRemindMessage) customResponsedMessage) != null) {
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (FrsFragment.this.ftP != null) {
                    FrsFragment.this.ftP.D(notificationCount, z);
                }
            }
        }
    };
    private final CustomMessageListener fvg = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.frs.FrsFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.isResumed()) {
                FrsFragment.this.bmw();
            }
        }
    };
    private CustomMessageListener fvh = new CustomMessageListener(2003020) { // from class: com.baidu.tieba.frs.FrsFragment.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (FrsFragment.this.ftP != null) {
                    FrsFragment.this.ftP.setExpanded(booleanValue);
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.n fvi = new com.baidu.tieba.tbadkCore.n() { // from class: com.baidu.tieba.frs.FrsFragment.14
        private long startTime = 0;

        @Override // com.baidu.tieba.tbadkCore.n
        public void rs(int i) {
            this.startTime = System.nanoTime();
            if (FrsFragment.this.ftP != null) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsFragment.this.ftP.bmS();
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
            if (FrsFragment.this.dpI) {
                FrsFragment.this.dpI = false;
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.ftP, FrsFragment.this.fts, FrsFragment.this.getForumId(), false, null);
            }
            FrsFragment.this.blU();
            FrsFragment.this.ftZ = true;
            if (bVar != null && bVar.isSuccess) {
                FrsFragment.this.ftP.bne().ky(com.baidu.tbadk.core.util.as.ajo().ajq());
                FrsFragment.ftV = 0L;
                FrsFragment.ftW = 0L;
                FrsFragment.ftX = 0;
            } else {
                FrsFragment.ftX = 1;
            }
            if (!FrsFragment.this.fug.brq() && (i == 3 || i == 6)) {
                FrsFragment.this.fus.resetData();
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (FrsFragment.this.fug.bqK() != null) {
                FrsFragment.this.fts = FrsFragment.this.fug.bqK();
            }
            FrsFragment.this.ftP.b(FrsFragment.this.fts.getRedpacketRainData());
            FrsFragment.this.ro(1);
            if (i == 7) {
                FrsFragment.this.rp(FrsFragment.this.fts.getFrsDefaultTabId());
                return;
            }
            if (FrsFragment.this.fts.getPage() != null) {
                FrsFragment.this.setHasMore(FrsFragment.this.fts.getPage().adr());
            }
            if (i == 4) {
                if (!FrsFragment.this.fug.brq() && TbadkCoreApplication.getInst().isRecAppExist() && FrsFragment.this.fug.brh() == 1) {
                    FrsFragment.this.fts.addRecommendAppToThreadList(FrsFragment.this);
                }
                ArrayList<com.baidu.adp.widget.ListView.m> a2 = FrsFragment.this.fus.a(false, false, FrsFragment.this.fts.getThreadList(), FrsFragment.this.ftL, false);
                if (a2 != null) {
                    FrsFragment.this.fts.setThreadList(a2);
                    FrsFragment.this.fts.checkLiveStageInThreadList();
                }
                if (FrsFragment.this.fug != null) {
                    com.baidu.tieba.frs.d.c.a(FrsFragment.this.fts, FrsFragment.this.fug.brm(), 2);
                }
                com.baidu.tieba.frs.f.a.a(FrsFragment.this, FrsFragment.this.fts.getForum(), FrsFragment.this.fts.getThreadList(), false, FrsFragment.this.getPn());
                FrsFragment.this.czV = System.currentTimeMillis() - currentTimeMillis;
                FrsFragment.this.ftP.a(a2, FrsFragment.this.fts);
                FrsFragment.this.blV();
                return;
            }
            FrsFragment.this.blV();
            switch (i) {
                case 1:
                    FrsFragment.this.ftP.bmS();
                    break;
                case 2:
                    FrsFragment.this.ftP.bmS();
                    break;
                case 3:
                case 6:
                    if (FrsFragment.this.fts != null) {
                        FrsFragment.this.fts.clearPostThreadCount();
                    }
                    if (FrsFragment.this.fux != null) {
                        FrsFragment.this.fux.refresh();
                        break;
                    }
                    break;
            }
            FrsFragment.this.blZ();
            if (bVar == null || bVar.errorCode == 0) {
                if (FrsFragment.this.fts != null) {
                    FrsFragment.this.G(false, i == 5);
                    if (FrsFragment.this.fug != null) {
                        if (FrsFragment.this.fts.getActivityHeadData() != null && FrsFragment.this.fts.getActivityHeadData().acL() != null && FrsFragment.this.fts.getActivityHeadData().acL().size() > 0) {
                            com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), 1, FrsFragment.this.fts.getForum(), FrsFragment.this.fug.getSortType(), 1);
                        }
                        if (FrsFragment.this.fts.getThreadList() != null && FrsFragment.this.fts.getThreadList().size() > 0) {
                            Iterator<com.baidu.adp.widget.ListView.m> it = FrsFragment.this.fts.getThreadList().iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    com.baidu.adp.widget.ListView.m next = it.next();
                                    if ((next instanceof bg) && ((bg) next).getType() == bg.bKV) {
                                        com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), 1, FrsFragment.this.fts.getForum(), FrsFragment.this.fug.getSortType(), 2);
                                    }
                                }
                            }
                        }
                        com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), FrsFragment.this.fts.getThreadList(), FrsFragment.this.fts.getForum(), FrsFragment.this.fug.getSortType());
                    }
                    FrsFragment.this.ftP.rB(i);
                    FrsFragment.ftV = (System.nanoTime() - this.startTime) / 1000000;
                    if (bVar != null) {
                        FrsFragment.ftW = bVar.jcN;
                    }
                } else {
                    return;
                }
            } else if (FrsFragment.this.fts == null || com.baidu.tbadk.core.util.v.aa(FrsFragment.this.fts.getThreadList())) {
                FrsFragment.this.a(bVar);
            } else if (bVar.fbG) {
                FrsFragment.this.showToast(FrsFragment.this.getPageContext().getResources().getString(R.string.net_error_text, bVar.errorMsg, Integer.valueOf(bVar.errorCode)));
            }
            FrsFragment.this.blW();
            FrsFragment.this.blX();
            if (FrsFragment.this.fts.getAccessFlag() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11384"));
            }
            if (FrsFragment.this.eXm > -1 && !FrsFragment.this.fuE) {
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.fug, FrsFragment.this.eXm);
                FrsFragment.this.eXm = -1L;
                FrsFragment.this.fuE = true;
            }
            if (FrsFragment.this.ftM && FrsFragment.this.fui.sY(49)) {
                FrsFragment.this.ftM = false;
            }
            FrsFragment.this.czV = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void b(com.baidu.tieba.tbadkCore.j jVar) {
            if ((jVar != null && ("normal_page".equals(FrsFragment.this.fug.getPageType()) || "frs_page".equals(FrsFragment.this.fug.getPageType()) || "book_page".equals(FrsFragment.this.fug.getPageType()))) || "brand_page".equals(FrsFragment.this.fug.getPageType())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001615, jVar));
                FrsFragment.this.a(jVar);
                FrsFragment.ftT = jVar;
            }
        }
    };
    private final CustomMessageListener fvj = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.frs.FrsFragment.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                FrsFragment.this.fts.updateCurrentUserPendant((com.baidu.tbadk.data.l) customResponsedMessage.getData());
                FrsFragment.this.ftP.bne().notifyDataSetChanged();
            }
        }
    };
    private final CustomMessageListener mMemListener = new CustomMessageListener(2001194) { // from class: com.baidu.tieba.frs.FrsFragment.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && FrsFragment.this.fts != null && (userData = FrsFragment.this.fts.getUserData()) != null) {
                userData.setIsMem(num.intValue());
                if (num.intValue() != 0) {
                    FrsFragment.this.fuh.h(num);
                }
            }
        }
    };
    private final com.baidu.tieba.frs.mc.k fvk = new com.baidu.tieba.frs.mc.k() { // from class: com.baidu.tieba.frs.FrsFragment.26
        @Override // com.baidu.tieba.frs.mc.k
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.m> arrayList, boolean z3) {
            if (FrsFragment.this.fuk != null && FrsFragment.this.fug != null && FrsFragment.this.fug.brq() && z && !z2 && !z3) {
                FrsFragment.this.fuk.sB(i2);
            }
        }
    };
    public final View.OnTouchListener cmp = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.FrsFragment.27
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (FrsFragment.this.fuz != null) {
                FrsFragment.this.fuz.onTouch(view, motionEvent);
            }
            if (FrsFragment.this.fum != null && FrsFragment.this.fum.bnM() != null) {
                FrsFragment.this.fum.bnM().onTouchEvent(motionEvent);
            }
            if (FrsFragment.this.dCr != null) {
                FrsFragment.this.dCr.f(view, motionEvent);
            }
            if (FrsFragment.this.fuh != null) {
                FrsFragment.this.fuh.L(motionEvent);
                return false;
            }
            return false;
        }
    };
    private final CustomMessageListener fvl = new CustomMessageListener(2004507) { // from class: com.baidu.tieba.frs.FrsFragment.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.ahO().getInt(TbadkCoreApplication.getCurrentAccount() + "photolive_hostLevel", -1) != -1 && FrsFragment.this.fts.getForum() != null) {
                FrsFragment.this.fts.getForum().setCanAddPhotoLivePost(true);
            }
        }
    };
    public final View.OnClickListener fvm = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.30
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsFragment.this.ftP == null || view != FrsFragment.this.ftP.bmQ() || FrsFragment.this.getActivity() == null) {
                if (FrsFragment.this.fts != null && FrsFragment.this.fts.getForum() != null && FrsFragment.this.ftP != null && view == FrsFragment.this.ftP.bmW()) {
                    if (FrsFragment.this.fuB == null) {
                        FrsFragment.this.fuB = new com.baidu.tieba.frs.view.c(FrsFragment.this.getPageContext());
                    }
                    FrsFragment.this.fuB.m(FrsFragment.this.fts);
                    FrsFragment.this.fuB.showDialog();
                    return;
                }
                if (view.getId() == R.id.game_activity_egg_layout && com.baidu.adp.lib.util.l.kt()) {
                    TiebaStatic.log("c10853");
                    if (FrsFragment.this.ftP.bnb()) {
                        FrsFragment.this.ftP.bnc();
                    } else {
                        String activityUrl = FrsFragment.this.fts.getForum().getYuleData().agC().getActivityUrl();
                        if (!StringUtils.isNull(activityUrl)) {
                            com.baidu.tbadk.browser.a.af(FrsFragment.this.getPageContext().getPageActivity(), activityUrl);
                        }
                    }
                }
                if (view == FrsFragment.this.ftP.bni() && FrsFragment.this.fug != null && FrsFragment.this.fug.hasMore()) {
                    FrsFragment.this.ftP.aKi();
                    FrsFragment.this.aIQ();
                }
                if (view != null && view == FrsFragment.this.ftP.bmY() && bd.cF(FrsFragment.this.getContext())) {
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
        private int fvy = 0;
        private int dml = 0;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (FrsFragment.this.fuq != null) {
                FrsFragment.this.fuq.bse();
            }
            this.fvy = 0;
            this.dml = 0;
            if (recyclerView != null && (recyclerView instanceof BdRecyclerView)) {
                this.fvy = ((BdRecyclerView) recyclerView).getFirstVisiblePosition();
                this.dml = ((BdRecyclerView) recyclerView).getLastVisiblePosition();
            }
            if (FrsFragment.this.fuC != null) {
                FrsFragment.this.fuC.a(recyclerView, this.fvy, this.dml);
            }
            if (FrsFragment.this.fts != null && FrsFragment.this.ftP != null && FrsFragment.this.ftP.bne() != null) {
                FrsFragment.this.ftP.bs(this.fvy, this.dml);
                if (FrsFragment.this.fuf != null && FrsFragment.this.fuf.qP() != null) {
                    FrsFragment.this.fuf.qP().b(FrsFragment.this.fue);
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (FrsFragment.this.fuh != null) {
                FrsFragment.this.fuh.setScrollState(i);
            }
            if (i == 0) {
                FrsFragment.this.ftP.bnm();
            }
            if ((i == 2 || i == 1) && !FrsFragment.this.fua) {
                FrsFragment.this.fua = true;
                FrsFragment.this.ftP.bng();
            }
            if (FrsFragment.this.fub == null && !FrsFragment.this.bmq()) {
                FrsFragment.this.fub = new com.baidu.tbadk.p.b();
                FrsFragment.this.fub.kQ(1000);
            }
            if (i == 0) {
                if (FrsFragment.this.fub != null) {
                    FrsFragment.this.fub.avk();
                }
                com.baidu.tieba.card.t.aZN().iE(true);
                FrsFragment.this.jM(true);
                FrsFragment.this.ftP.br(this.fvy, this.dml);
            } else if (FrsFragment.this.fub != null) {
                FrsFragment.this.fub.avj();
            }
            if (FrsFragment.this.fuC != null) {
                FrsFragment.this.fuC.onScrollStateChanged(recyclerView, i);
            }
            if (i == 0) {
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.ftP, FrsFragment.this.fts, FrsFragment.this.getForumId(), false, null);
            }
            if (FrsFragment.this.fui != null && i == 1) {
                FrsFragment.this.fui.bsS();
            }
            if (FrsFragment.this.fuf == null) {
                if (FrsFragment.this.ftP.bmJ() != null && !FrsFragment.this.ftP.bmp() && FrsFragment.this.ftP.bmJ().ced() != null && (FrsFragment.this.ftP.bmJ().ced().getTag() instanceof com.baidu.card.z)) {
                    FrsFragment.this.fuf = (com.baidu.card.z) FrsFragment.this.ftP.bmJ().ced().getTag();
                }
            } else if (i == 0 && FrsFragment.this.ftP.bmJ() != null && !FrsFragment.this.ftP.bmp() && FrsFragment.this.ftP.bmJ().ced() != null && (FrsFragment.this.ftP.bmJ().ced().getTag() instanceof com.baidu.card.z)) {
                FrsFragment.this.fuf = (com.baidu.card.z) FrsFragment.this.ftP.bmJ().ced().getTag();
            }
            if (i == 1) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921418));
            }
        }
    };
    private final d fvn = new d() { // from class: com.baidu.tieba.frs.FrsFragment.32
        @Override // com.baidu.tieba.frs.d
        public void a(int i, int i2, View view, View view2, bg bgVar) {
            if (i != FrsFragment.this.ftP.bne().boY()) {
                if (i != FrsFragment.this.ftP.bne().boZ()) {
                    if (i == FrsFragment.this.ftP.bne().boW() && FrsFragment.this.fts != null && FrsFragment.this.fts.getUserData() != null && FrsFragment.this.fts.getUserData().isBawu()) {
                        String bawuCenterUrl = FrsFragment.this.fts.getBawuCenterUrl();
                        if (!com.baidu.tbadk.core.util.aq.isEmpty(bawuCenterUrl) && FrsFragment.this.fts.getForum() != null) {
                            com.baidu.tbadk.browser.a.ae(FrsFragment.this.getPageContext().getPageActivity(), bawuCenterUrl);
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10502").bT("fid", FrsFragment.this.fts.getForum().getId()).bT("uid", FrsFragment.this.fts.getUserData().getUserId()));
                        }
                    }
                } else if (bd.cF(FrsFragment.this.getPageContext().getPageActivity())) {
                    TiebaStatic.log("my_service_ck");
                    if (FrsFragment.this.fts != null && FrsFragment.this.fts.getForum() != null) {
                        ForumData forum = FrsFragment.this.fts.getForum();
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(forum.getId(), 0L), forum.getName(), forum.getImage_url(), 0)));
                    }
                }
            } else if (bd.cF(FrsFragment.this.getActivity())) {
                TiebaStatic.log("forum_fortune_click");
                com.baidu.tieba.frs.f.i.b(FrsFragment.this.getPageContext(), FrsFragment.this.fts);
            }
        }
    };
    private final NoNetworkView.a fru = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.FrsFragment.33
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void ep(boolean z) {
            if (FrsFragment.this.fug.brh() == 1 && z && !FrsFragment.this.ftP.bmp()) {
                if (FrsFragment.this.fts == null || com.baidu.tbadk.core.util.v.aa(FrsFragment.this.fts.getThreadList())) {
                    FrsFragment.this.hideNetRefreshView(FrsFragment.this.ftP.aXy());
                    FrsFragment.this.showLoadingView(FrsFragment.this.ftP.aXy(), true);
                    FrsFragment.this.ftP.jX(false);
                    FrsFragment.this.refresh();
                    return;
                }
                FrsFragment.this.ftP.bmS();
            }
        }
    };
    private final CustomMessageListener cij = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.FrsFragment.35
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                com.baidu.tieba.frs.f.c.a(customResponsedMessage, FrsFragment.this.ftP, FrsFragment.this.fts);
            }
        }
    };
    private com.baidu.adp.widget.ListView.s fvo = new a();
    private ai fvp = new ai() { // from class: com.baidu.tieba.frs.FrsFragment.37
        @Override // com.baidu.tieba.frs.ai
        public void a(int i, int i2, ap apVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
            com.baidu.adp.lib.g.e.iK().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.37.1
                @Override // java.lang.Runnable
                public void run() {
                    if (FrsFragment.this.ftP != null && FrsFragment.this.ftP.baM()) {
                        FrsFragment.this.aIQ();
                    }
                }
            });
        }
    };
    private CustomMessageListener fvq = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.frs.FrsFragment.38
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    FrsFragment.this.fuD = true;
                }
            }
        }
    };
    private CustomMessageListener fvr = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.frs.FrsFragment.39
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                    if (FrsFragment.this.fuf == null && FrsFragment.this.ftP.bmJ() != null && !FrsFragment.this.ftP.bmp() && FrsFragment.this.ftP.bmJ().ced() != null && (FrsFragment.this.ftP.bmJ().ced().getTag() instanceof com.baidu.card.z)) {
                        FrsFragment.this.fuf = (com.baidu.card.z) FrsFragment.this.ftP.bmJ().ced().getTag();
                    }
                    if (FrsFragment.this.fuf != null && FrsFragment.this.fuf.qP() != null) {
                        FrsFragment.this.fuf.qP().b(new a.C0038a(3));
                    }
                }
            }
        }
    };
    private CustomMessageListener fvs = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.FrsFragment.40
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.ftP != null) {
                FrsFragment.this.ftP.bno();
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.frs.loadmore.a
    public /* bridge */ /* synthetic */ com.baidu.adp.base.e getPageContext() {
        return super.getPageContext();
    }

    public com.baidu.tieba.frs.entelechy.b.b blI() {
        return this.fuo;
    }

    public com.baidu.adp.widget.ListView.s blJ() {
        return this.fvo;
    }

    public com.baidu.tieba.frs.mc.d blK() {
        return this.fur;
    }

    public com.baidu.tieba.frs.smartsort.a blL() {
        return this.fuk;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public FrsModelController blM() {
        return this.fug;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public com.baidu.tieba.frs.mc.c blN() {
        return this.fus;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public com.baidu.tieba.frs.vc.f blO() {
        return this.fuh;
    }

    public FrsTabViewController blP() {
        return this.fui;
    }

    public ak blQ() {
        return this.fum;
    }

    public void jL(boolean z) {
        this.fuM = z;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public k blR() {
        return this.ftP;
    }

    @Override // com.baidu.tieba.frs.aj
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.aj, com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.ftH;
    }

    public void setForumName(String str) {
        this.ftH = str;
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
        if (this.fus == null) {
            return 1;
        }
        return this.fus.getPn();
    }

    public int getPn() {
        if (this.fus == null) {
            return 1;
        }
        return this.fus.getPn();
    }

    public void setPn(int i) {
        if (this.fus != null) {
            this.fus.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.fus != null) {
            this.fus.setHasMore(i);
        }
    }

    public int blS() {
        if (this.fus == null) {
            return -1;
        }
        return this.fus.blS();
    }

    public boolean blT() {
        return this.ftN;
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
            this.ftP.bmM();
            showNetRefreshView(this.ftP.aXy(), string, true);
        } else if (340001 == bVar.errorCode) {
            a(bVar, this.fts.getRecm_forum_list());
        } else {
            if (com.baidu.tbadk.core.util.v.aa(this.fts.getThreadList())) {
                b(bVar);
            }
            if (bmq()) {
                setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst(), R.dimen.ds280));
            } else {
                setNetRefreshViewEmotionDefMarginTop();
            }
        }
    }

    public void a(View view, String str, boolean z, List<RecmForumInfo> list) {
        this.ftP.bmM();
        this.ftP.rx(8);
        if (this.fuA == null) {
            this.fuA = new com.baidu.tieba.frs.view.a(getPageContext(), getNetRefreshListener());
        }
        this.fuA.qN(str);
        this.fuA.cp(list);
        this.fuA.attachView(view, z);
    }

    private void a(e.b bVar, List<RecmForumInfo> list) {
        if (this.ftP != null) {
            this.ftP.bmM();
            this.ftP.setTitle(this.ftH);
            a(this.ftP.aXy(), bVar.errorMsg, true, list);
        }
    }

    private void b(e.b bVar) {
        this.ftP.bmM();
        if (bVar.fbG) {
            showNetRefreshView(this.ftP.aXy(), TbadkCoreApplication.getInst().getString(R.string.net_error_text, new Object[]{bVar.errorMsg, Integer.valueOf(bVar.errorCode)}), true);
        } else {
            showNetRefreshView(this.ftP.aXy(), bVar.errorMsg, true);
        }
    }

    public void blU() {
        hideLoadingView(this.ftP.aXy());
        this.ftP.jZ(false);
        if (this.ftP.bmK() instanceof com.baidu.tieba.frs.tab.c) {
            ((com.baidu.tieba.frs.tab.c) this.ftP.bmK()).brJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blV() {
        if (blS() == 0 && com.baidu.tbadk.core.util.v.aa(this.fts.getThreadListIds())) {
            if (com.baidu.tbadk.core.util.v.aa(this.fts.getThreadList())) {
                this.ftP.aKk();
            } else {
                this.ftP.aKj();
            }
        } else if (com.baidu.tbadk.core.util.v.Z(this.fts.getThreadList()) > 3) {
            this.ftP.aKi();
        } else {
            this.ftP.bnh();
        }
    }

    public void a(ErrorData errorData) {
        String stringExtra = getActivity().getIntent().getStringExtra("name");
        if (getActivity().getIntent().getIntExtra(FrsActivityConfig.FRS_CALL_FROM, -1) == 12 && errorData != null && errorData.error_code == 3 && !StringUtils.isNull(stringExtra) && TbadkCoreApplication.isLogin()) {
            sendMessage(new CustomMessage(2002001, new CreateBarGuideActivityConfig(getContext(), stringExtra)));
            getActivity().finish();
            return;
        }
        blU();
        this.ftP.bmS();
        e.b bre = this.fug.bre();
        boolean aa = com.baidu.tbadk.core.util.v.aa(this.fts.getThreadList());
        if (bre != null && aa) {
            if (this.fug.brf() != 0) {
                this.fug.brk();
                this.ftP.bmS();
            } else {
                a(bre);
            }
            this.ftP.H(this.fts.isStarForum(), false);
            return;
        }
        a(bre);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blW() {
        boolean b;
        if (!blY()) {
            final PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
            privateForumPopInfoData.a(this.fts.getPrivateForumTotalInfo().getPrivatePopInfo());
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(getActivity());
            if (this.fts.getPrivateForumTotalInfo().ady().private_forum_status.intValue() == 1 && (com.baidu.tbadk.core.util.aq.isEmpty(privateForumPopInfoData.adA()) || privateForumPopInfoData.adD() != Integer.valueOf(this.forumId))) {
                privateForumPopInfoData.mr("create_success");
                privateForumPopInfoData.ms(TbadkCoreApplication.getInst().getString(R.string.frs_private_create_hint));
                privateForumPopInfoData.mt("https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.ftH + "&nomenu=1");
                privateForumPopInfoData.b(Integer.valueOf(this.forumId));
                b = frsPrivateCommonDialogView.b(privateForumPopInfoData);
            } else {
                b = privateForumPopInfoData.adD() == Integer.valueOf(this.forumId) ? frsPrivateCommonDialogView.b(privateForumPopInfoData) : false;
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
                        bb.ajC().c(FrsFragment.this.getPageContext(), new String[]{privateForumPopInfoData.adC()});
                        aVar.dismiss();
                    }
                });
                aVar.a(new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.16
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(getPageContext()).agI();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blX() {
        if (blY() || this.fts.getPrivateForumTotalInfo().ady().private_forum_status.intValue() != 1) {
            a((Integer) null, (Integer) null, true);
        } else {
            a(this.fts.getPrivateForumTotalInfo().ady().private_forum_audit_status, this.fts.getPrivateForumTotalInfo().adz(), false);
        }
    }

    public void a(Integer num, Integer num2, boolean z) {
        final String str;
        final int i = 2;
        if (this.ftP.bmX() != null) {
            TextView bmX = this.ftP.bmX();
            if (z) {
                bmX.setVisibility(8);
                return;
            }
            if (num.intValue() == 2) {
                bmX.setText("修改实名认证信息");
                bmX.setVisibility(0);
                str = "https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + this.forumId + "&nomenu=1";
            } else if (num2.intValue() >= 0 && num2.intValue() <= 100) {
                bmX.setText("目标已完成" + String.valueOf(num2) + "%");
                bmX.setVisibility(0);
                str = "https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.ftH + "&nomenu=1";
                i = 1;
            } else {
                bmX.setVisibility(8);
                i = 0;
                str = "";
            }
            bmX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.17
                /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13387").bT("fid", FrsFragment.this.forumId).bT("uid", TbadkCoreApplication.getCurrentAccount()).P("obj_type", i));
                    bb.ajC().c(FrsFragment.this.getPageContext(), new String[]{str});
                }
            });
        }
    }

    private boolean blY() {
        return this.fts == null || !this.fts.isPrivateForum() || this.fts.getPrivateForumTotalInfo() == null || this.fts.getPrivateForumTotalInfo().ady() == null || this.fts.getUserData().getIs_manager() != 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ro(int i) {
        List<WindowToast> list;
        if (TbadkCoreApplication.isLogin() && this.fts != null && (list = this.fts.mWindowToast) != null && list.size() > 0) {
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
    public void blZ() {
        if (this.fts == null || this.fts.getForum() != null) {
            this.ftP.bnd();
        } else if (this.fts.getForum().getYuleData() != null && this.fts.getForum().getYuleData().agB()) {
            TiebaStatic.log("c10852");
            this.ftP.a(this.fts.getForum().getYuleData().agC());
        } else {
            this.ftP.bnd();
        }
    }

    private void F(boolean z, boolean z2) {
        if (this.fug != null && this.fts != null && this.ftP != null && z) {
            if (!this.fug.brq() && this.fug.brh() == 1) {
                if (!this.fug.bro()) {
                    this.fts.addCardVideoInfoToThreadList();
                    this.fts.addVideoInfoToThreadListInTenAndFifteenFloor();
                }
                boolean z3 = false;
                if (this.ftP.bne().n(com.baidu.tieba.card.data.n.eGp)) {
                    z3 = this.fts.addHotTopicDataToThreadList();
                }
                if (!z3) {
                    this.fts.addFeedForumDataToThreadList();
                }
                if (TbadkCoreApplication.getInst().isRecAppExist()) {
                    this.fts.addRecommendAppToThreadList(this);
                }
                if (!this.ftP.bne().n(bg.bJy)) {
                    this.fts.removeAlaLiveThreadData();
                }
                this.fts.addSchoolRecommendToThreadList();
            }
            if (!this.ftP.bne().n(bg.bJy)) {
                this.fts.removeAlaInsertLiveData();
                this.fts.removeAlaStageLiveDat();
            } else {
                this.fts.addInsertLiveDataToThreadList();
                this.fts.addStageLiveDataToThreadList();
            }
            this.fts.checkLiveStageInThreadList();
            this.fts.addNoticeThreadToThreadList();
            if (this.ftP.bne().n(com.baidu.tieba.h.b.fWt)) {
                this.fts.addGameRankListToThreadList(z2);
            }
            if (TbadkCoreApplication.isLogin() && (!this.fug.brq() || this.fug.isNetFirstLoad)) {
                this.fts.addUserRecommendToThreadList();
            }
            this.fts.addVideoActivityToTop();
        }
    }

    public boolean bma() {
        if (this.fuh != null && this.fug != null) {
            this.fuh.a(this.fug.getPageType(), this.fts);
        }
        boolean z = false;
        if (this.fts != null) {
            z = this.fts.hasTab();
        }
        bmc();
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rp(int i) {
        am amVar = null;
        bma();
        bmj();
        try {
            if (this.fts != null) {
                this.ftP.a((ArrayList<com.baidu.adp.widget.ListView.m>) null, this.fts);
                this.fuh.sS(1);
                this.ftP.bmV();
                this.fui.a(this.fts, this.fug.brm());
                com.baidu.tieba.frs.tab.d sZ = this.fui.sZ(this.fts.getFrsDefaultTabId());
                if (sZ != null && !TextUtils.isEmpty(sZ.url)) {
                    amVar = new am();
                    amVar.fxY = sZ.url;
                    amVar.stType = sZ.name;
                }
                this.fug.a(this.fts.getFrsDefaultTabId(), 0, amVar);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(boolean z, boolean z2) {
        try {
            if (this.fts != null && this.fui != null && this.fug != null) {
                if (!this.ftP.bne().n(bg.bJy)) {
                    this.fts.removeAlaLiveThreadData();
                }
                boolean aa = com.baidu.tbadk.core.util.v.aa(this.fts.getGameTabInfo());
                this.ftP.jV(aa);
                if (!aa) {
                    if (this.fuC == null) {
                        this.fuC = new com.baidu.tieba.frs.vc.e(this, (NoPressedRelativeLayout) this.mRootView);
                    }
                    if (this.dCr == null) {
                        this.dCr = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
                    }
                } else {
                    this.fuC = null;
                    this.dCr = null;
                }
                if (this.fts.getForum() != null) {
                    this.ftH = this.fts.getForum().getName();
                    this.forumId = this.fts.getForum().getId();
                }
                if (this.fts.hasTab()) {
                    this.fui.a(this.fts, this.fug.brm());
                }
                if (z) {
                    F(true, z);
                } else {
                    F(this.fuc, z);
                }
                bma();
                if (this.fuo != null) {
                    this.fuo.a(this.fuh, this.fts);
                }
                if (this.fts.getPage() != null) {
                    setHasMore(this.fts.getPage().adr());
                }
                ArrayList<com.baidu.adp.widget.ListView.m> a2 = this.fus.a(z2, true, this.fts.getThreadList(), null, z, false);
                if (a2 != null) {
                    this.fts.setThreadList(a2);
                }
                this.fts.removeRedundantUserRecommendData();
                this.ftu = this.fts.getTopThreadSize();
                if (this.ftL != null) {
                    this.ftK = true;
                    this.ftL.Ba(this.ftu);
                    com.baidu.tieba.frs.f.a.a(this, this.fts.getForum(), this.fts.getThreadList(), this.ftK, getPn());
                }
                if (this.fug.brh() == 1) {
                    bmg();
                    if (!z && this.fug.getPn() == 1) {
                        bmb();
                    }
                }
                if (this.fuq != null) {
                    this.fuq.bX(this.fui.bsP());
                }
                blU();
                this.ftP.bmN();
                this.ftP.H(true, false);
                if (z && this.fts.isFirstTabEqualAllThread()) {
                    com.baidu.adp.lib.g.e.iK().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.18
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!FrsFragment.this.ftZ) {
                                FrsFragment.this.ftP.bnn();
                            }
                        }
                    });
                }
                if (this.fts.getForum() != null) {
                    this.ftP.wV(this.fts.getForum().getWarningMsg());
                }
                if (this.fts != null && this.fts.getFrsVideoActivityData() != null && com.baidu.tbadk.core.sharedPref.b.ahO().getLong("frs_video_activity_guide", 0L) == 0) {
                    com.baidu.adp.lib.g.e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.19
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsFragment.this.ftP.bnk();
                        }
                    }, 1000L);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2921326, this));
                this.ftP.bmH();
                if (this.fts != null && this.fts.getForum() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016564, new VisitedForumData(this.fts.getForum().getId(), this.fts.getForum().getName(), this.fts.getForum().getImage_url(), String.valueOf(System.currentTimeMillis() / 1000), "showlive".equals(this.fts.getForum().special_forum_type), this.fts.getForum().getThemeColorInfo(), this.fts.getForum().getMember_num())));
                }
                this.fuH.a(this.fts.bottomMenuList, this.fts.getForum());
                bmw();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void jM(boolean z) {
        com.baidu.tieba.q.c.coo().b(getUniqueId(), z);
    }

    public void bmb() {
        if (this.fuv == null) {
            this.fuv = new com.baidu.tieba.frs.live.a(this, com.baidu.adp.lib.g.b.f(this.forumId, 0));
        }
        this.fuv.bqQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.j jVar) {
        try {
            if (!this.ftZ && jVar != null && this.fts != null) {
                this.fts.receiveData(jVar);
                G(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void bmc() {
        if (this.fug != null) {
            wT(this.fug.getPageType());
        } else {
            wT("normal_page");
        }
    }

    private void wT(String str) {
        jN("frs_page".equals(str));
        if (this.fuo != null) {
            this.fuo.a(this.fuh, this.ftP, this.fts);
        }
    }

    public void jN(boolean z) {
        if (this.fut != null) {
            this.fut.bsJ();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.q.c.coo().u(getUniqueId());
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.frs_activity, viewGroup, false);
            this.ftB = new com.baidu.tieba.frs.entelechy.a();
            this.fuo = this.ftB.boD();
            this.fuh = new com.baidu.tieba.frs.vc.f(this, this.ftB, (FrsHeaderViewContainer) this.mRootView.findViewById(R.id.header_view_container));
            this.fui = new FrsTabViewController(this, this.mRootView);
            this.fui.registerListener();
            this.fuh.a(this.fui);
            this.fui.a(this.fuV);
            Intent intent = getActivity().getIntent();
            if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                this.ftD = true;
            }
            this.ftP = new k(this, this.fvm, this.ftB, this.ftD, this.fuh);
            this.fuH = new com.baidu.tieba.frs.brand.buttommenu.a(getPageContext(), this.mRootView);
        } else {
            if (this.mRootView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            if (this.fui != null) {
                this.fui.registerListener();
            }
            this.ftP.bnj();
            this.mRootView.setLeft(0);
            this.mRootView.setRight(com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst().getContext()));
        }
        this.fuL = true;
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        ArrayList<com.baidu.adp.widget.ListView.m> arrayList = null;
        this.eXm = System.currentTimeMillis();
        this.beginTime = this.eXm;
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.ftM = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.eXm = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            af(intent);
        }
        this.czN = this.beginTime - this.eXm;
        this.ftL = new com.baidu.tieba.tbadkCore.data.f("frs", com.baidu.tieba.tbadkCore.data.f.jev);
        if (this.fug == null) {
            this.fug = new FrsModelController(this, this.fvi);
            this.fug.a(this.fuU);
            this.fug.init();
        }
        if (intent != null) {
            this.fug.K(intent.getExtras());
        } else if (bundle != null) {
            this.fug.K(bundle);
        } else {
            this.fug.K(null);
        }
        if (intent != null) {
            this.fuh.R(intent.getExtras());
        } else if (bundle != null) {
            this.fuh.R(bundle);
        } else {
            this.fuh.R(null);
        }
        this.ftO = getVoiceManager();
        this.fuw = new j(getPageContext(), this);
        initUI();
        initData(bundle);
        if (!bmq()) {
            this.fum = new ak(getActivity(), this.ftP, this.fuh);
            this.fum.km(true);
        }
        this.ftO = getVoiceManager();
        if (this.ftO != null) {
            this.ftO.onCreate(getPageContext());
        }
        new com.baidu.tieba.frs.mc.i();
        int i = -1;
        if (this.fus != null && this.fus.brb() != null) {
            i = this.fus.brb().blS();
            arrayList = this.fus.brb().getDataList();
        }
        this.fus = new com.baidu.tieba.frs.mc.c(this, this.fvk);
        this.fus.brb().setHasMore(i);
        if (arrayList != null && arrayList.size() > 0) {
            this.fus.brb().ad(arrayList);
        }
        this.fuk = new com.baidu.tieba.frs.smartsort.a(this);
        this.fut = new com.baidu.tieba.frs.vc.h(this);
        this.fuq = new com.baidu.tieba.frs.vc.a(getPageContext(), this.fug.brn());
        this.ful = new com.baidu.tieba.frs.mc.b(this);
        this.fur = new com.baidu.tieba.frs.mc.d(this);
        this.fuj = new com.baidu.tieba.frs.mc.h(this);
        this.fuu = new com.baidu.tieba.frs.mc.a(this);
        this.fux = new com.baidu.tieba.frs.vc.c(this);
        this.fuy = new com.baidu.tieba.frs.mc.e(this, getUniqueId());
        this.fuF = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "frs");
        this.fuG = new com.baidu.tieba.ala.a(getPageContext());
        this.fuI = new com.baidu.tieba.frs.sportspage.notification.a(getPageContext());
        registerListener(this.dyI);
        registerListener(this.mMemListener);
        registerListener(this.fvb);
        registerListener(this.fvl);
        registerListener(this.fva);
        registerListener(this.fvj);
        registerListener(this.fuX);
        registerListener(this.fuY);
        registerListener(this.fuZ);
        registerListener(this.fuR);
        registerListener(this.fuS);
        registerListener(this.Wi);
        registerListener(this.fvq);
        registerListener(this.fve);
        registerListener(this.fuT);
        registerListener(this.fvf);
        registerListener(this.fvd);
        this.fuQ.setTag(getPageContext().getUniqueId());
        registerListener(this.fuQ);
        registerListener(this.fvg);
        registerListener(this.fvh);
        this.fvr.setTag(getPageContext().getUniqueId());
        MessageManager.getInstance().registerListener(this.fvr);
        registerListener(this.fvs);
        this.ftP.jX(false);
        if (!bmq() && !this.hasInit) {
            showLoadingView(this.ftP.aXy(), true);
            this.fug.F(3, false);
        }
        com.baidu.tieba.frs.a.bkY().a(new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.22
            @Override // com.baidu.tieba.frs.a.b
            public void E(boolean z, boolean z2) {
                if (FrsFragment.this.ftP != null) {
                    FrsFragment.this.ftP.ry(z ? 0 : 8);
                    if (!z2) {
                        FrsFragment.this.fuK = z;
                    }
                    if (FrsFragment.this.ftP.bne() != null && FrsFragment.this.fug != null && FrsFragment.this.fug.bri()) {
                        FrsFragment.this.ftP.bne().notifyDataSetChanged();
                    }
                    if (FrsFragment.this.blP() != null) {
                        FrsTabViewController.b bsQ = FrsFragment.this.blP().bsQ();
                        if (bsQ != null && bsQ.tabId == 502 && (bsQ.fragment instanceof FrsCommonTabFragment)) {
                            ((FrsCommonTabFragment) bsQ.fragment).boz();
                        } else if (bsQ != null && bsQ.tabId == 503 && (bsQ.fragment instanceof FrsNewAreaFragment)) {
                            FrsNewAreaFragment frsNewAreaFragment = (FrsNewAreaFragment) bsQ.fragment;
                            frsNewAreaFragment.boz();
                            if (frsNewAreaFragment.brt() != null) {
                                com.baidu.tieba.frs.mc.g brt = frsNewAreaFragment.brt();
                                brt.ka(!z);
                                brt.kb(!z);
                            }
                        }
                        if (FrsFragment.this.blP().bsK() != null) {
                            FrsFragment.this.blP().bsK().setmDisallowSlip(z);
                            FrsFragment.this.blP().kR(z);
                        }
                    }
                    if (FrsFragment.this.ftP.bmL() != null) {
                        FrsFragment.this.ftP.jU(!z);
                    }
                    if (FrsFragment.this.getActivity() instanceof FrsActivity) {
                        ((FrsActivity) FrsFragment.this.getActivity()).jK(!z);
                    }
                    if (FrsFragment.this.fuH != null) {
                        FrsFragment.this.fuH.ku(!z);
                    }
                    FrsFragment.this.ftP.ka(!z);
                    FrsFragment.this.ftP.kb(z ? false : true);
                }
            }

            @Override // com.baidu.tieba.frs.a.b
            public void rl(int i2) {
                if (FrsFragment.this.ftP != null) {
                    FrsFragment.this.ftP.rz(i2);
                }
            }

            @Override // com.baidu.tieba.frs.a.b
            public void blf() {
                com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getContext(), (int) R.string.frs_multi_delete_max_num);
            }
        });
        this.ftP.b(new d.a() { // from class: com.baidu.tieba.frs.FrsFragment.24
            @Override // com.baidu.tieba.NEGFeedBack.d.a
            public void a(DeleteThreadHttpResponseMessage deleteThreadHttpResponseMessage) {
                boolean z;
                int i2 = 0;
                if (deleteThreadHttpResponseMessage != null) {
                    FrsFragment.this.ftP.aBn();
                    FrsFragment.this.ftP.bnl();
                    FrsNewAreaFragment frsNewAreaFragment = null;
                    if (FrsFragment.this.fui == null || FrsFragment.this.fui.bsQ() == null || !(FrsFragment.this.fui.bsQ().fragment instanceof FrsNewAreaFragment)) {
                        z = false;
                    } else {
                        frsNewAreaFragment = (FrsNewAreaFragment) FrsFragment.this.fui.bsQ().fragment;
                        z = true;
                    }
                    if (deleteThreadHttpResponseMessage.getError() == 0) {
                        String text = !TextUtils.isEmpty(deleteThreadHttpResponseMessage.getText()) ? deleteThreadHttpResponseMessage.getText() : FrsFragment.this.getString(R.string.delete_fail);
                        if (deleteThreadHttpResponseMessage.getRetType() == 1211066) {
                            if (FrsFragment.this.eEM == null) {
                                FrsFragment.this.eEM = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.eEM.mO(text);
                            FrsFragment.this.eEM.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.24.1
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.eEM.dR(false);
                            FrsFragment.this.eEM.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.eEM.agI();
                        } else if (deleteThreadHttpResponseMessage.getRetType() == 1211067) {
                            if (FrsFragment.this.eEM == null) {
                                FrsFragment.this.eEM = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.eEM.mO(text);
                            FrsFragment.this.eEM.a(R.string.know, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.24.2
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.eEM.dR(false);
                            FrsFragment.this.eEM.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.eEM.agI();
                        } else {
                            FrsFragment.this.ftP.au(deleteThreadHttpResponseMessage.getText(), ContextCompat.getColor(FrsFragment.this.getContext(), deleteThreadHttpResponseMessage.getRetType() == 1 ? R.color.nav_bar_tip_error : R.color.cp_link_tip_a_alpha95));
                        }
                        if (z && frsNewAreaFragment != null) {
                            frsNewAreaFragment.ck(deleteThreadHttpResponseMessage.getSuccessItems());
                        }
                        FrsFragment.this.bY(deleteThreadHttpResponseMessage.getSuccessItems());
                        com.baidu.tieba.frs.a.bkY().bX(deleteThreadHttpResponseMessage.getSuccessItems());
                        for (com.baidu.adp.widget.ListView.m mVar : FrsFragment.this.fts.getThreadList()) {
                            if (mVar instanceof bf) {
                                i2++;
                                continue;
                            }
                            if (i2 >= 6) {
                                break;
                            }
                        }
                        if (i2 < 6) {
                            FrsFragment.this.aIQ();
                            return;
                        }
                        return;
                    }
                    com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getActivity(), deleteThreadHttpResponseMessage.getErrorString());
                }
            }
        });
        this.hasInit = true;
        rq(1);
        super.onActivityCreated(bundle);
        this.createTime = System.currentTimeMillis() - this.beginTime;
    }

    public void jO(boolean z) {
        if (this.fui != null) {
            this.fui.fRW = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bY(List<String> list) {
        if (!com.baidu.tbadk.core.util.v.aa(list)) {
            ArrayList<com.baidu.adp.widget.ListView.m> threadList = this.fts.getThreadList();
            if (!com.baidu.tbadk.core.util.v.aa(threadList) && this.ftP.getListView() != null && this.ftP.getListView().getData() != null) {
                Iterator<com.baidu.adp.widget.ListView.m> it = threadList.iterator();
                List<com.baidu.adp.widget.ListView.m> data = this.ftP.getListView().getData();
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.m next = it.next();
                    if (next instanceof bf) {
                        bg bgVar = ((bf) next).threadData;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= list.size()) {
                                break;
                            } else if (!com.baidu.tbadk.core.util.aq.bV(list.get(i2), bgVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.fus.e(next);
                                this.ftP.getListView().getAdapter().notifyItemRemoved(i);
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
    public void aJj() {
        if (isAdded() && this.dpI && !isLoadingViewAttached()) {
            showLoadingView(this.ftP.aXy(), true);
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void aJk() {
        if (isAdded() && this.dpI && isLoadingViewAttached()) {
            hideLoadingView(this.ftP.aXy());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (bmq()) {
            showLoadingView(this.ftP.aXy(), true);
            this.ftP.rA(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.fug.F(3, true);
            ald().scrollToPosition(0);
        }
    }

    private void rq(int i) {
        String str = "";
        if (this.fts != null && this.fts.getForum() != null) {
            str = this.fts.getForum().getId();
        }
        if (!StringUtils.isNull(str)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13008").bT("fid", str).bT("obj_type", "4").P("obj_locate", i).bT("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.x xVar) {
        if (xVar != null) {
            this.cDk = xVar.aww();
            this.fuz = xVar.awx();
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void showFloatingView() {
        if (this.cDk != null) {
            this.cDk.fM(true);
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
                this.ftH = data.getQueryParameter("name");
                this.mFrom = data.getQueryParameter("from");
                if (!StringUtils.isNull(this.ftH)) {
                    intent.putExtra("name", this.ftH);
                }
                if (!StringUtils.isNull(this.mFrom)) {
                    intent.putExtra("from", this.mFrom);
                }
                TiebaStatic.log("c10105");
            }
            if (StringUtils.isNull(this.ftH) && intent != null && intent.getData() != null) {
                Uri data2 = intent.getData();
                if (com.baidu.tbadk.BdToken.f.m(data2)) {
                    com.baidu.tbadk.BdToken.f.Zw().b(data2, new f.a() { // from class: com.baidu.tieba.frs.FrsFragment.25
                        @Override // com.baidu.tbadk.BdToken.f.a
                        public void o(HashMap<String, Object> hashMap) {
                            if (hashMap != null && (hashMap.get(com.baidu.tbadk.BdToken.f.bzl) instanceof String)) {
                                FrsFragment.this.ftH = (String) hashMap.get(com.baidu.tbadk.BdToken.f.bzl);
                            }
                        }
                    });
                } else {
                    com.baidu.tieba.frs.f.d ai = com.baidu.tieba.frs.f.i.ai(intent);
                    if (ai != null) {
                        this.ftH = ai.forumName;
                        if (ai.fQu == null || ai.fQu.equals("aidou")) {
                        }
                    }
                }
                if (!StringUtils.isNull(this.ftH)) {
                    intent.putExtra("name", this.ftH);
                }
                intent.putExtra(FrsActivityConfig.FRS_CALL_FROM, 12);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.ftO = getVoiceManager();
        if (this.ftO != null) {
            this.ftO.onStart(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        Intent intent;
        registerListener(2001118, this.cij);
        if (bundle != null) {
            this.ftH = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
            this.ftH = intent.getStringExtra("name");
            this.mFrom = intent.getStringExtra("from");
            this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
        }
        if (getArguments() != null) {
            this.ftI = getArguments().getBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, false);
        }
        if (TextUtils.isEmpty(this.mFrom) || FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
        }
        if (this.mIsLogin) {
            registerListener(2001120, this.cij);
        }
        this.fuh.R(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.q.c.coo().v(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.fvq);
        ftT = null;
        if (this.ftO != null) {
            this.ftO.onDestory(getPageContext());
        }
        com.baidu.tieba.recapp.report.a.remove("FRS");
        this.ftO = null;
        com.baidu.tieba.card.t.aZN().iE(false);
        if (this.fts != null && this.fts.getForum() != null) {
            aa.bnJ().di(com.baidu.adp.lib.g.b.c(this.fts.getForum().getId(), 0L));
        }
        if (this.fuv != null) {
            this.fuv.onDestory();
        }
        if (this.ftP != null) {
            com.baidu.tieba.frs.f.h.a(this.ftP, this.fts, getForumId(), false, null);
            this.ftP.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.fub != null) {
                this.fub.avl();
            }
            this.ftP.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.fuh.aFO();
        if (this.fug != null) {
            this.fug.aLx();
        }
        if (this.fum != null) {
            this.fum.awv();
        }
        if (this.fup != null) {
            this.fup.destory();
        }
        if (this.fuq != null) {
            this.fuq.destory();
        }
        if (this.fuk != null) {
            this.fuk.onDestroy();
        }
        if (this.fuC != null) {
            this.fuC.onDestory();
        }
        if (this.fuu != null) {
            this.fuu.onDestroy();
        }
        if (this.fuF != null) {
            this.fuF.onDestroy();
        }
        if (this.fuG != null) {
            this.fuG.onDestroy();
        }
        com.baidu.tieba.recapp.d.a.cit().civ();
        com.baidu.tieba.frs.f.j.bsb();
        if (this.fui != null) {
            this.fui.a((FrsTabViewController.a) null);
            this.fui.bsS();
        }
        if (this.fuJ != null) {
            this.fuJ.onDestroy();
        }
        com.baidu.tieba.frs.a.bkY().a(null);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.ftH);
        bundle.putString("from", this.mFrom);
        this.fug.onSaveInstanceState(bundle);
        if (this.ftO != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            this.ftO.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.fuu != null) {
            this.fuu.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.ftP != null) {
            this.ftP.bmS();
            this.ftP.onResume();
        }
        this.fuj.kK(true);
        this.fuc = true;
        if (ftG) {
            ftG = false;
            this.ftP.startPullRefresh();
            return;
        }
        if (this.ftO != null) {
            this.ftO.onResume(getPageContext());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921338));
        this.ftP.kc(false);
        if (this.fuD) {
            refresh(6);
            this.fuD = false;
        }
        bmw();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
    }

    public boolean bmd() {
        Intent intent;
        if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
            return false;
        }
        return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
    }

    public void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.ftH = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.ftJ = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.ftJ) {
                bme();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bme() {
        this.ftP.startPullRefresh();
    }

    public void closeActivity() {
        com.baidu.tieba.frs.f.i.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.mFrom);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.ftP.setTitle(this.ftH);
        } else {
            this.ftP.setTitle("");
            this.mFlag = 1;
        }
        this.ftP.setOnAdapterItemClickListener(this.fvo);
        this.ftP.addOnScrollListener(this.mScrollListener);
        this.ftP.h(this.fru);
        this.ftP.bne().a(this.fvn);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fuL) {
            this.ftP.onChangeSkinType(i);
            this.fuh.sR(i);
            this.fui.onChangeSkinType(i);
            if (this.ftR != null) {
                this.ftR.onChangeSkinType(i);
            }
            if (this.fuA != null) {
                this.fuA.onChangeSkinType();
            }
            if (this.fuH != null) {
                this.fuH.onChangeSkinType(getPageContext(), i);
            }
            if (this.eEM != null) {
                com.baidu.tbadk.s.a.a(getPageContext(), this.eEM.agJ());
            }
            if (this.fuB != null) {
                this.fuB.onChangeSkinType();
            }
        }
    }

    public void rr(int i) {
        if (!this.mIsLogin) {
            if (this.fts != null && this.fts.getAnti() != null) {
                this.fts.getAnti().setIfpost(1);
            }
            if (i == 0) {
                bd.cE(getActivity());
            }
        } else if (this.fts != null) {
            if (i == 0) {
                com.baidu.tieba.frs.f.j.d(this, 0);
            } else {
                this.ftP.bmU();
            }
        }
    }

    public void refresh() {
        com.baidu.tieba.a.d.aCF().sl("page_frs");
        refresh(3);
    }

    public void refresh(int i) {
        this.ftZ = false;
        bmj();
        if (this.ftP != null && this.ftP.bmJ() != null) {
            this.ftP.bmJ().bwl();
        }
        if (this.fug != null) {
            this.fug.F(i, true);
        }
    }

    private void bmf() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.g.h.iL().d(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.29
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.ER(FrsFragment.this.ftH);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmg() {
        bmj();
        try {
            if (this.fts != null) {
                this.ftP.aVP();
                this.ftP.jU(bmv());
                if (!com.baidu.tieba.frs.vc.f.l(this.fts) || !com.baidu.tieba.frs.vc.f.k(this.fts)) {
                }
                if (this.fts.getForum() != null) {
                    this.ftH = this.fts.getForum().getName();
                    this.forumId = this.fts.getForum().getId();
                }
                if (this.fts.getPage() != null) {
                    setHasMore(this.fts.getPage().adr());
                }
                this.ftP.setTitle(this.ftH);
                this.ftP.setForumName(this.ftH);
                TbadkCoreApplication.getInst().setDefaultBubble(this.fts.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.fts.getUserData().getBimg_end_time());
                bmf();
                bmh();
                ArrayList<com.baidu.adp.widget.ListView.m> threadList = this.fts.getThreadList();
                if (threadList != null) {
                    this.ftP.a(threadList, this.fts);
                    com.baidu.tieba.frs.f.c.y(this.ftP);
                    this.fuh.sS(getPageNum());
                    this.fuh.i(this.fts);
                    this.fui.a(this.fts, this.fug.brm());
                    this.ftP.bmV();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void bmh() {
        if (this.fts != null) {
            if (this.fts.getIsNewUrl() == 1) {
                this.ftP.bne().setFromCDN(true);
            } else {
                this.ftP.bne().setFromCDN(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.fuj.kK(false);
        this.fuc = false;
        this.ftP.onPause();
        if (this.ftO != null) {
            this.ftO.onPause(getPageContext());
        }
        this.ftP.kc(true);
        if (this.fuq != null) {
            this.fuq.bse();
        }
        com.baidu.tbadk.BdToken.c.Zg().Zl();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.fui != null && this.fui.bsQ() != null && (this.fui.bsQ().fragment instanceof BaseFragment)) {
            ((BaseFragment) this.fui.bsQ().fragment).setPrimary(z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.t.aZN().iE(false);
        jM(false);
        if (this.fts != null && this.fts.getForum() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            com.baidu.tbadk.distribute.a.arL().a(getPageContext().getPageActivity(), "frs", this.fts.getForum().getId(), 0L);
        }
        if (this.ftO != null) {
            this.ftO.onStop(getPageContext());
        }
        if (ald() != null) {
            ald().getRecycledViewPool().clear();
        }
        this.fuh.aku();
        com.baidu.tbadk.util.y.awz();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            if (this.fuh != null) {
                this.fuh.jS(isPrimary());
            }
            if (this.ftP != null) {
                this.ftP.jS(isPrimary());
                this.ftP.kc(!isPrimary());
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (com.baidu.tieba.frs.a.bkY().bkZ()) {
                com.baidu.tieba.frs.a.bkY().reset();
                return true;
            } else if (this.ftP != null) {
                return this.ftP.bmR();
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
        com.baidu.tbadk.distribute.a.arL().a(advertAppInfo, this.forumId, 0L, "FRS", str, getPn());
    }

    @Override // com.baidu.tieba.recapp.n
    public void bmi() {
        blM().bmi();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.ftO == null) {
            this.ftO = VoiceManager.instance();
        }
        return this.ftO;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdRecyclerView ald() {
        if (this.ftP == null) {
            return null;
        }
        return this.ftP.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void bmj() {
        if (this.ftO != null) {
            this.ftO.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> ale() {
        if (this.ccT == null) {
            this.ccT = UserIconBox.q(getPageContext().getPageActivity(), 8);
        }
        return this.ccT;
    }

    public void bmk() {
        if (getFragmentActivity() != null && getFragmentActivity().getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.b(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.p onGetPreLoadListView() {
        return ald().getPreLoadHandle();
    }

    @Override // com.baidu.tieba.frs.ah
    public NavigationBar aLh() {
        if (this.ftP == null) {
            return null;
        }
        return this.ftP.aLh();
    }

    public FRSRefreshButton bml() {
        return this.ftR;
    }

    public void a(FRSRefreshButton fRSRefreshButton) {
        if (fRSRefreshButton != null) {
            this.ftR = fRSRefreshButton;
            this.ftR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.36
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (FrsFragment.this.fui != null) {
                        FrsTabViewController.b bsQ = FrsFragment.this.fui.bsQ();
                        if (bsQ != null && bsQ.fragment != null && (bsQ.fragment instanceof ag)) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                            ((ag) bsQ.fragment).blA();
                            ((ag) bsQ.fragment).aKh();
                            return;
                        }
                        FrsFragment.this.blR().startPullRefresh();
                    }
                }
            });
        }
    }

    public void bmm() {
        if (this.ftR != null && this.ftS) {
            if (this.fuN != null) {
                this.fuN.cancel();
            }
            this.fuN = new AlphaAnimation(1.0f, 0.0f);
            this.fuN.setDuration(300L);
            this.fuN.setFillAfter(true);
            this.ftR.startAnimation(this.fuN);
            this.ftR.setClickable(false);
            this.ftS = false;
        }
    }

    public void bmn() {
        if (this.ftR != null && !this.ftS && this.fui.bsT() != 0) {
            this.ftR.setVisibility(0);
            if (this.fuO != null) {
                this.fuO.cancel();
            }
            this.fuO = new AlphaAnimation(0.0f, 1.0f);
            this.fuO.setDuration(300L);
            this.fuO.setFillAfter(true);
            this.ftR.startAnimation(this.fuO);
            this.ftR.setClickable(true);
            this.ftS = true;
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
                if (bdUniqueId == p.fwX) {
                    if (FrsFragment.this.ftP != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11752").bT("fid", FrsFragment.this.forumId).bT("obj_locate", "1"));
                        FrsFragment.this.ftP.startPullRefresh();
                    }
                } else if (mVar != null && (mVar instanceof bf)) {
                    bg bgVar = ((bf) mVar).threadData;
                    if (bgVar.afp() == null || bgVar.afp().getGroup_id() == 0 || bd.cF(FrsFragment.this.getActivity())) {
                        if (bgVar.afh() != 1 || bd.cF(FrsFragment.this.getActivity())) {
                            if (bgVar.aeK() != null) {
                                if (bd.cF(FrsFragment.this.getActivity())) {
                                    String postUrl = bgVar.aeK().getPostUrl();
                                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.kt()) {
                                        com.baidu.tbadk.browser.a.af(FrsFragment.this.getActivity(), postUrl);
                                    }
                                }
                            } else if (bgVar.afA() != null) {
                                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                    bd.cE(FrsFragment.this.getPageContext().getPageActivity());
                                    return;
                                }
                                com.baidu.tbadk.core.data.o afA = bgVar.afA();
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), afA.getCartoonId(), afA.getChapterId(), 2)));
                            } else {
                                com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                                if (readThreadHistory != null && !readThreadHistory.EX(bgVar.getId())) {
                                    readThreadHistory.EW(bgVar.getId());
                                }
                                boolean z = false;
                                final String aeE = bgVar.aeE();
                                if (aeE != null && !aeE.equals("")) {
                                    z = true;
                                    new Thread(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.a.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(aeE);
                                            xVar.aiE().ajE().mIsNeedAddCommenParam = false;
                                            xVar.aiE().ajE().mIsUseCurrentBDUSS = false;
                                            xVar.aih();
                                        }
                                    }).start();
                                }
                                String tid = bgVar.getTid();
                                if (tid == null) {
                                    tid = "";
                                }
                                if (bgVar.aes() == 2 && !tid.startsWith("pb:")) {
                                    bb.ajC().c(FrsFragment.this.getPageContext(), new String[]{tid, "", null});
                                    return;
                                }
                                if (tid.startsWith("pb:")) {
                                    bgVar.setId(tid.substring(3));
                                }
                                if (bdUniqueId.getId() == bg.bKV.getId()) {
                                    com.baidu.tieba.frs.f.h.a(bgVar.aed());
                                } else if (bdUniqueId.getId() == bg.bJB.getId()) {
                                    com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c12940");
                                    anVar.bT("obj_type", "2");
                                    anVar.bT("tid", bgVar.getTid());
                                    TiebaStatic.log(anVar);
                                }
                                com.baidu.tieba.frs.f.i.a(FrsFragment.this, bgVar, i, z);
                                com.baidu.tieba.frs.f.h.a(FrsFragment.this, FrsFragment.this.fts, bgVar);
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
            hideNetRefreshView(this.ftP.aXy());
            showLoadingView(this.ftP.aXy(), true);
            this.ftP.jX(false);
            this.fug.F(3, true);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData bmo() {
        return this.fts;
    }

    public boolean bmp() {
        return this.ftP.bmp();
    }

    public void ar(Object obj) {
        if (this.ful != null && this.ful.fLY != null) {
            this.ful.fLY.m(obj);
        }
    }

    public void as(Object obj) {
        if (this.ful != null && this.ful.fLZ != null) {
            this.ful.fLZ.m(obj);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        this.ftP.getListView().stopScroll();
        if (!this.ftP.bna()) {
            if (!com.baidu.adp.lib.util.l.kt()) {
                this.ftP.aKk();
            } else if (this.fug.brh() == 1) {
                aJe();
                aIQ();
            } else if (this.fug.hasMore()) {
                aIQ();
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void wC(String str) {
        aJe();
        showToast(str);
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void V(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        boolean aa = com.baidu.tbadk.core.util.v.aa(arrayList);
        setHasMore(aa ? 0 : 1);
        aJe();
        if (!aa) {
            if (!this.fug.brq() && TbadkCoreApplication.getInst().isRecAppExist() && this.fug.brh() == 1) {
                this.fts.addRecommendAppToThreadList(this, arrayList);
            }
            if (this.fug != null) {
                com.baidu.tieba.frs.d.a.a(getUniqueId(), arrayList, this.fts.getForum(), this.fug.getSortType());
            }
            ArrayList<com.baidu.adp.widget.ListView.m> a2 = this.fus.a(false, false, arrayList, this.ftL, false);
            if (a2 != null) {
                this.fts.setThreadList(a2);
                this.ftP.a(a2, this.fts);
            }
            if (this.fug != null) {
                com.baidu.tieba.frs.d.c.a(this.fts, this.fug.brm(), 2);
            }
        }
    }

    private void aJe() {
        if (blS() == 1 || this.fus.cj(this.fts.getThreadListIds())) {
            if (com.baidu.tbadk.core.util.v.Z(this.fts.getThreadList()) > 3) {
                this.ftP.aKi();
            } else {
                this.ftP.bnh();
            }
        } else if (com.baidu.tbadk.core.util.v.aa(this.fts.getThreadList())) {
            this.ftP.aKk();
        } else {
            this.ftP.aKj();
        }
    }

    @Override // com.baidu.tieba.frs.mc.l
    public void aIQ() {
        if (this.fus != null) {
            this.fus.a(this.ftH, this.forumId, this.fts);
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
        if (this.fum != null) {
            this.fum.km(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.fun.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a me(int i) {
        return this.fun.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        this.fuw.b(bVar);
    }

    public boolean bmq() {
        return this.ftD;
    }

    @Override // com.baidu.tieba.frs.ae
    public void aJi() {
        if (this.ftP != null) {
            showFloatingView();
            this.ftP.getListView().scrollToPosition(0);
            this.ftP.startPullRefresh();
        }
    }

    public ForumWriteData bmr() {
        if (this.fts == null || this.fts.getForum() == null) {
            return null;
        }
        ForumData forum = this.fts.getForum();
        ForumWriteData forumWriteData = new ForumWriteData(forum.getId(), forum.getName(), forum.getPrefixData(), this.fts.getAnti());
        forumWriteData.avatar = forum.getImage_url();
        forumWriteData.forumLevel = forum.getUser_level();
        forumWriteData.specialForumType = forum.special_forum_type;
        forumWriteData.firstDir = forum.getFirst_class();
        forumWriteData.secondDir = forum.getSecond_class();
        UserData userData = this.fts.getUserData();
        forumWriteData.privateThread = userData != null ? userData.getPrivateThread() : 0;
        return forumWriteData;
    }

    @Override // com.baidu.tieba.frs.ae
    public void akL() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.frs.ae
    public void setVideoThreadId(String str) {
    }

    public void jQ(boolean z) {
        this.fud = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z) {
        super.showLoadingView(view, z);
        this.ftP.rx(8);
        ((FrsActivity) getActivity()).i(view, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        super.hideLoadingView(view);
        this.ftP.rx(0);
        ((FrsActivity) getActivity()).i(view, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        super.showNetRefreshView(view, str, z);
        this.ftP.rx(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshViewNoClick(View view, String str, boolean z) {
        super.showNetRefreshViewNoClick(view, str, z);
        this.ftP.rx(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        super.hideNetRefreshView(view);
        this.ftP.rx(0);
    }

    public void bms() {
        FrsTabViewController.b bsQ;
        if (this.fui != null && (bsQ = this.fui.bsQ()) != null && bsQ.fragment != null && (bsQ.fragment instanceof ag)) {
            ((ag) bsQ.fragment).blA();
        }
    }

    public void jR(boolean z) {
        this.ftF = z;
    }

    public void b(OvalActionButton ovalActionButton) {
        this.ftQ = ovalActionButton;
    }

    public OvalActionButton bmt() {
        return this.ftQ;
    }

    public boolean bmu() {
        return this.ftF;
    }

    public void wU(String str) {
        if (TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.util.aq.isEmpty(str)) {
            if (this.fuJ == null) {
                this.fuJ = new AddExperiencedModel(getTbPageContext());
                this.fuJ.a(this.fuP);
            }
            this.fuJ.ee(this.forumId, str);
        }
    }

    public boolean bmv() {
        if (this.fud && !this.fuM) {
            return (this.fug != null && this.fug.bri() && com.baidu.tieba.frs.a.bkY().bkZ()) ? false : true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.e.c
    public boolean videoNeedPreload() {
        if (this.fts != null) {
            return com.baidu.tbadk.util.ad.awH() && (this.fts.isFrsVideoAutoPlay || com.baidu.tbadk.core.sharedPref.b.ahO().getInt("auto_play_video_frs", 0) == 1);
        }
        return super.videoNeedPreload();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmw() {
        if (!com.baidu.tbadk.core.util.aq.isEmpty(this.forumId)) {
            com.baidu.tbadk.BdToken.c.Zg().l(com.baidu.tbadk.BdToken.b.bxO, com.baidu.adp.lib.g.b.c(this.forumId, 0L));
        }
    }
}
