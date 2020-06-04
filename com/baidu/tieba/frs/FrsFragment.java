package com.baidu.tieba.frs;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.card.a.a;
import com.baidu.h.a.a;
import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.baidu.tbadk.BdToken.f;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CreateBarGuideActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.core.atomData.MessageCenterActivityConfig;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.PostSearchActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.PrivateForumPopInfoData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
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
import com.baidu.tbadk.pageInfo.TbPageTag;
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
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsPage.RecmForumInfo;
import tbclient.FrsTabInfo;
import tbclient.WindowToast;
/* loaded from: classes9.dex */
public class FrsFragment extends BaseFragment implements BdListView.e, a.InterfaceC0125a, UserIconBox.b<BdRecyclerView>, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, aj, am, ap, com.baidu.tieba.frs.loadmore.a, com.baidu.tieba.frs.mc.l, com.baidu.tieba.recapp.m {
    public static com.baidu.tieba.tbadkCore.m hnw;
    private com.baidu.adp.lib.d.b<TbImageView> dXO;
    private com.baidu.tbadk.util.z evv;
    private com.baidu.tieba.frs.gametab.b fvg;
    private com.baidu.tbadk.core.dialog.a gGx;
    private com.baidu.card.ag hnI;
    private FrsModelController hnJ;
    private com.baidu.tieba.frs.vc.h hnK;
    private FrsTabViewController hnL;
    private com.baidu.tieba.frs.mc.h hnM;
    private com.baidu.tieba.frs.smartsort.a hnN;
    private com.baidu.tieba.frs.mc.b hnO;
    private aq hnP;
    private com.baidu.tieba.frs.entelechy.b.b hnR;
    private com.baidu.tieba.frs.vc.a hnS;
    private com.baidu.tieba.frs.mc.d hnT;
    private com.baidu.tieba.frs.mc.c hnU;
    private com.baidu.tieba.frs.vc.j hnV;
    private com.baidu.tieba.frs.mc.a hnW;
    private com.baidu.tieba.frs.live.a hnX;
    private m hnY;
    public com.baidu.tieba.frs.vc.c hnZ;
    private com.baidu.tieba.frs.entelechy.a hnf;
    private com.baidu.tieba.tbadkCore.data.f hnp;
    private VoiceManager hns;
    private OvalActionButton hnu;
    private FRSRefreshButton hnv;
    public long hnx;
    private com.baidu.tieba.frs.mc.e hoa;
    private View.OnTouchListener hob;
    private com.baidu.tieba.frs.view.a hoc;
    private com.baidu.tieba.frs.vc.e hod;
    private boolean hoe;
    private com.baidu.tieba.NEGFeedBack.a hof;
    private com.baidu.tieba.ala.a hog;
    private com.baidu.tieba.frs.brand.buttommenu.a hoh;
    private com.baidu.tieba.frs.sportspage.notification.a hoi;
    private AddExperiencedModel hoj;
    private boolean hol;
    private com.baidu.tieba.frs.live.b hop;
    private int hoq;
    private int how;
    private View mRootView;
    private String mSchemeUrl;
    public static boolean hnk = false;
    public static volatile long hnz = 0;
    public static volatile long hnA = 0;
    public static volatile int mNetError = 0;
    private String hne = "";
    public boolean hng = false;
    private boolean hnh = false;
    private boolean hni = false;
    private boolean hnj = true;
    public String hnl = null;
    public String mFrom = null;
    public int mFlag = 0;
    public boolean hnm = false;
    private boolean hnn = false;
    private String mThreadId = null;
    public String forumId = null;
    private int hmT = 0;
    private boolean hno = false;
    private boolean hnq = false;
    private boolean hnr = false;
    private n hnt = null;
    public final bk ahg = null;
    private FrsViewData hmR = new FrsViewData();
    public long gPV = -1;
    public long esg = 0;
    public long erW = 0;
    public long createTime = 0;
    public long erX = 0;
    public long esd = 0;
    public long hny = 0;
    public boolean hnB = false;
    private boolean hnC = false;
    private boolean hnD = false;
    public com.baidu.tbadk.n.b hnE = null;
    private boolean hnF = true;
    private boolean hnG = true;
    private a.C0097a hnH = new a.C0097a(2);
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> hnQ = new SparseArray<>();
    private boolean feU = true;
    private boolean hasInit = false;
    private boolean hok = false;
    private boolean hom = false;
    private Date hon = null;
    private int cOy = 0;
    private int hoo = 0;
    public int mHeadLineDefaultNavTabId = -1;
    private final CustomMessageListener hor = new CustomMessageListener(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED) { // from class: com.baidu.tieba.frs.FrsFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof bk) {
                    com.baidu.tieba.frs.f.h.a(FrsFragment.this.hnt, FrsFragment.this.hmR, FrsFragment.this.getForumId(), true, (bk) data);
                }
            }
        }
    };
    private CustomMessageListener hos = new CustomMessageListener(CmdConfigCustom.CMD_CLOSE_GAME_RANK_CARD) { // from class: com.baidu.tieba.frs.FrsFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.hmR != null) {
                FrsFragment.this.hmR.removeGameRankListFromThreadList();
                if (FrsFragment.this.hnt != null) {
                    FrsFragment.this.hnt.aES();
                }
            }
        }
    };
    private CustomMessageListener aei = new CustomMessageListener(2921401) { // from class: com.baidu.tieba.frs.FrsFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && FrsFragment.this.hnv != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() <= 0 || FrsFragment.this.hnL.ccz() == 0 || FrsFragment.this.hnL.ccw() == null || !(FrsFragment.this.hnL.ccw().fragment instanceof BaseFragment) || !((BaseFragment) FrsFragment.this.hnL.ccw().fragment).isPrimary() || FrsFragment.this.hnt.bWy()) {
                    if (FrsFragment.this.hnL.ccz() != 0) {
                        FrsFragment.this.hnv.hide();
                        return;
                    }
                    return;
                }
                FrsFragment.this.hnv.show();
            }
        }
    };
    private CustomMessageListener hot = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.FrsFragment.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 1) {
                    FrsFragment.this.bVk();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                }
            }
        }
    };
    private final ao hou = new ao() { // from class: com.baidu.tieba.frs.FrsFragment.40
        @Override // com.baidu.tieba.frs.ao
        public void a(int i, int i2, av avVar, ArrayList<com.baidu.adp.widget.ListView.o> arrayList) {
            FrsFragment.this.bUW();
            if (FrsFragment.this.hnR != null) {
                FrsFragment.this.hnK.nL(FrsFragment.this.hnR.ut(i));
            }
            com.baidu.tieba.tbadkCore.f fVar = new com.baidu.tieba.tbadkCore.f();
            if (avVar != null) {
                fVar.isSuccess = avVar.errCode == 0;
                fVar.errorCode = avVar.errCode;
                fVar.errorMsg = avVar.errMsg;
                if (fVar.isSuccess) {
                    if (com.baidu.tbadk.core.util.v.isEmpty(arrayList)) {
                        FrsFragment.this.hnt.brO();
                    } else if (avVar.hasMore) {
                        if (com.baidu.tbadk.core.util.v.getCount(FrsFragment.this.hmR.getThreadList()) > 3) {
                            FrsFragment.this.hnt.brM();
                        } else {
                            FrsFragment.this.hnt.bWr();
                        }
                    } else if (avVar.hrA) {
                        FrsFragment.this.hnt.brN();
                    } else {
                        FrsFragment.this.hnt.brO();
                    }
                }
            } else {
                avVar = new av();
                avVar.pn = 1;
                avVar.hasMore = false;
                avVar.hrA = false;
            }
            if (i == 1) {
                FrsFragment.this.hnF = true;
                FrsFragment.this.hoI.a(FrsFragment.this.hnJ.getType(), false, fVar);
            } else {
                FrsFragment.this.a(fVar);
                if (FrsFragment.this.hnJ.bZZ() != null) {
                    FrsFragment.this.hmR = FrsFragment.this.hnJ.bZZ();
                }
                FrsFragment.this.bVm();
            }
            if (FrsFragment.this.hoQ != null) {
                FrsFragment.this.hoQ.a(i, i2, avVar, arrayList);
            }
        }
    };
    private FrsTabViewController.a hov = new FrsTabViewController.a() { // from class: com.baidu.tieba.frs.FrsFragment.41
        @Override // com.baidu.tieba.frs.vc.FrsTabViewController.a
        public void bO(int i, int i2) {
            boolean z = false;
            if (i != 1) {
                com.baidu.tieba.card.s.bLs().lT(false);
                FrsFragment.this.mJ(false);
            }
            if (i == 502) {
                FrsFragment.this.hnu.setIconFade(R.drawable.btn_frs_professional_edit_n);
            } else {
                FrsFragment.this.hnu.setIconFade(0);
            }
            FrsFragment.this.how = i;
            FrsFragment.this.hoq = i2;
            if (FrsFragment.this.hop != null) {
                FrsFragment.this.hop.uV(FrsFragment.this.hoq);
            }
            TbSingleton.getInstance().setFrsCurTabType(FrsFragment.this.hoq);
            FrsFragment.this.bVp();
            com.baidu.tieba.frs.d.d.hvL.hJD = i;
            com.baidu.tieba.frs.d.d.hvL.hJE = -1;
            com.baidu.tieba.frs.a bTZ = com.baidu.tieba.frs.a.bTZ();
            if (i == 1 && FrsFragment.this.hok) {
                z = true;
            }
            bTZ.L(z, true);
        }
    };
    private CustomMessageListener hox = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIVE_COUNT) { // from class: com.baidu.tieba.frs.FrsFragment.42
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                FrsFragment.this.hnL.vF(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    };
    private CustomMessageListener hoy = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_LIVE_START) { // from class: com.baidu.tieba.frs.FrsFragment.43
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && ((Integer) customResponsedMessage.getData()).intValue() == 51 && FrsFragment.this.hmR != null) {
                com.baidu.tieba.frs.f.j.a(FrsFragment.this.hmR, FrsFragment.this.getPageContext());
            }
        }
    };
    private final CustomMessageListener hoz = new CustomMessageListener(CmdConfigCustom.CMD_FRS_SELECT_ALA_LIVE_TAB) { // from class: com.baidu.tieba.frs.FrsFragment.44
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                FrsFragment.this.hnL.vD(49);
            }
        }
    };
    private final CustomMessageListener hoA = new CustomMessageListener(CmdConfigCustom.CMD_FRS_EXPERIENCE_TIP) { // from class: com.baidu.tieba.frs.FrsFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.u) && FrsFragment.this.hmR != null) {
                FrsFragment.this.hmR.updateLikeData((com.baidu.tieba.tbadkCore.u) customResponsedMessage.getData());
                FrsFragment.this.hnK.i(FrsFragment.this.hmR);
                FrsFragment.this.hnL.a(FrsFragment.this.hmR, FrsFragment.this.hnJ.caD());
            }
        }
    };
    private final AntiHelper.a hoB = new AntiHelper.a() { // from class: com.baidu.tieba.frs.FrsFragment.3
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ag("obj_locate", at.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ag("obj_locate", at.a.LOCATE_LIKE_PERSON));
        }
    };
    private CustomMessageListener hoC = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.FrsFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(FrsFragment.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().ecK != null) {
                        if (AntiHelper.a(FrsFragment.this.getActivity(), updateAttentionMessage.getData().ecK, FrsFragment.this.hoB) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ag("obj_locate", at.a.LOCATE_LIKE_PERSON));
                        }
                    } else if (updateAttentionMessage.getData().isSucc && updateAttentionMessage.getData().isAttention) {
                        com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getPageContext().getPageActivity(), (int) R.string.attention_success);
                    }
                }
            }
        }
    };
    private CustomMessageListener hoD = new CustomMessageListener(CmdConfigCustom.CMD_GET_ENSURE_CAST_ID) { // from class: com.baidu.tieba.frs.FrsFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsFragment.this.refresh();
        }
    };
    private CustomMessageListener hoE = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.frs.FrsFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && !((PostWriteCallBackData) customResponsedMessage.getData()).isDyamicCallback()) {
                FrsFragment.this.hnt.c((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener hoF = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_REMIND) { // from class: com.baidu.tieba.frs.FrsFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewsRemindMessage newsRemindMessage;
            if (customResponsedMessage != null && (customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626 && (newsRemindMessage = (NewsRemindMessage) customResponsedMessage) != null) {
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (FrsFragment.this.hnt != null) {
                    FrsFragment.this.hnt.J(notificationCount, z);
                }
            }
        }
    };
    private final CustomMessageListener hoG = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.frs.FrsFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.isResumed()) {
                FrsFragment.this.bVE();
            }
        }
    };
    private CustomMessageListener hoH = new CustomMessageListener(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER) { // from class: com.baidu.tieba.frs.FrsFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (FrsFragment.this.hnt != null) {
                    FrsFragment.this.hnt.setExpanded(booleanValue);
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.q hoI = new com.baidu.tieba.tbadkCore.q() { // from class: com.baidu.tieba.frs.FrsFragment.10
        private long startTime = 0;

        @Override // com.baidu.tieba.tbadkCore.q
        public void tM(int i) {
            this.startTime = System.nanoTime();
            if (FrsFragment.this.hnt != null) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsFragment.this.hnt.bWb();
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

        @Override // com.baidu.tieba.tbadkCore.q
        public void a(int i, boolean z, com.baidu.tieba.tbadkCore.f fVar) {
            if (FrsFragment.this.feU) {
                FrsFragment.this.feU = false;
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.hnt, FrsFragment.this.hmR, FrsFragment.this.getForumId(), false, null);
            }
            FrsFragment.this.bUW();
            FrsFragment.this.hnC = true;
            if (fVar != null && fVar.isSuccess) {
                FrsFragment.this.hnt.bWo().ns(com.baidu.tbadk.core.util.ar.aUX().aUY());
                FrsFragment.hnz = 0L;
                FrsFragment.hnA = 0L;
                FrsFragment.mNetError = 0;
            } else {
                FrsFragment.mNetError = 1;
            }
            if (!FrsFragment.this.hnJ.caI() && (i == 3 || i == 6)) {
                FrsFragment.this.hnU.resetData();
            }
            FrsFragment.this.hnx = System.currentTimeMillis();
            if (FrsFragment.this.hnJ.bZZ() != null) {
                FrsFragment.this.hmR = FrsFragment.this.hnJ.bZZ();
            }
            FrsFragment.this.hnt.b(FrsFragment.this.hmR.getRedpacketRainData());
            FrsFragment.this.tI(1);
            if (i == 7) {
                FrsFragment.this.tJ(FrsFragment.this.hmR.getFrsDefaultTabId());
                return;
            }
            if (FrsFragment.this.hmR.getPage() != null) {
                FrsFragment.this.setHasMore(FrsFragment.this.hmR.getPage().aPt());
            }
            if (i == 4) {
                if (!FrsFragment.this.hnJ.caI() && TbadkCoreApplication.getInst().isRecAppExist() && FrsFragment.this.hnJ.cay() == 1) {
                    FrsFragment.this.hmR.addRecommendAppToThreadList(FrsFragment.this);
                }
                ArrayList<com.baidu.adp.widget.ListView.o> a2 = FrsFragment.this.hnU.a(false, false, FrsFragment.this.hmR.getThreadList(), FrsFragment.this.hnp, false);
                if (a2 != null) {
                    FrsFragment.this.hmR.setThreadList(a2);
                    FrsFragment.this.hmR.checkLiveStageInThreadList();
                }
                if (FrsFragment.this.hnJ != null) {
                    com.baidu.tieba.frs.d.c.a(FrsFragment.this.hmR, FrsFragment.this.hnJ.caD(), 2, FrsFragment.this.getContext());
                }
                com.baidu.tieba.frs.f.a.a(FrsFragment.this, FrsFragment.this.hmR.getForum(), FrsFragment.this.hmR.getThreadList(), false, FrsFragment.this.getPn());
                FrsFragment.this.hnt.a(a2, FrsFragment.this.hmR);
                FrsFragment.this.bUX();
                return;
            }
            FrsFragment.this.bUX();
            switch (i) {
                case 1:
                    FrsFragment.this.hnt.bWb();
                    break;
                case 2:
                    FrsFragment.this.hnt.bWb();
                    break;
                case 3:
                case 6:
                    if (FrsFragment.this.hmR != null) {
                        FrsFragment.this.hmR.clearPostThreadCount();
                    }
                    if (FrsFragment.this.hnZ != null) {
                        FrsFragment.this.hnZ.refresh();
                        break;
                    }
                    break;
            }
            FrsFragment.this.bVf();
            if (fVar == null || fVar.errorCode == 0) {
                if (FrsFragment.this.hmR != null) {
                    if (!FrsFragment.this.a(FrsFragment.this.hmR)) {
                        FrsFragment.this.bVe();
                    }
                    FrsFragment.this.O(false, i == 5);
                    if (FrsFragment.this.hnJ != null) {
                        if (FrsFragment.this.hmR.getActivityHeadData() != null && FrsFragment.this.hmR.getActivityHeadData().aOG() != null && FrsFragment.this.hmR.getActivityHeadData().aOG().size() > 0) {
                            com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), 1, FrsFragment.this.hmR.getForum(), FrsFragment.this.hnJ.getSortType(), 1);
                        }
                        if (FrsFragment.this.hmR.getThreadList() != null && FrsFragment.this.hmR.getThreadList().size() > 0) {
                            Iterator<com.baidu.adp.widget.ListView.o> it = FrsFragment.this.hmR.getThreadList().iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    com.baidu.adp.widget.ListView.o next = it.next();
                                    if ((next instanceof bk) && ((bk) next).getType() == bk.dGz) {
                                        com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), 1, FrsFragment.this.hmR.getForum(), FrsFragment.this.hnJ.getSortType(), 2);
                                    }
                                }
                            }
                        }
                        com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), FrsFragment.this.hmR.getThreadList(), FrsFragment.this.hmR.getForum(), FrsFragment.this.hnJ.getSortType());
                    }
                    FrsFragment.this.hnt.tW(i);
                    FrsFragment.hnz = (System.nanoTime() - this.startTime) / TimeUtils.NANOS_PER_MS;
                    if (fVar != null) {
                        FrsFragment.hnA = fVar.ljF;
                    }
                } else {
                    return;
                }
            } else if (FrsFragment.this.hmR == null || com.baidu.tbadk.core.util.v.isEmpty(FrsFragment.this.hmR.getThreadList())) {
                FrsFragment.this.a(fVar);
            } else if (fVar.gXw) {
                FrsFragment.this.showToast(FrsFragment.this.getPageContext().getResources().getString(R.string.net_error_text, fVar.errorMsg, Integer.valueOf(fVar.errorCode)));
            }
            FrsFragment.this.bVb();
            FrsFragment.this.bVc();
            if (FrsFragment.this.hmR.getAccessFlag() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11384"));
            }
            if (FrsFragment.this.hnq && FrsFragment.this.hnL.vD(49)) {
                FrsFragment.this.hnq = false;
            }
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.q
        public void c(com.baidu.tieba.tbadkCore.m mVar) {
            if ((mVar != null && ("normal_page".equals(FrsFragment.this.hnJ.getPageType()) || "frs_page".equals(FrsFragment.this.hnJ.getPageType()) || "book_page".equals(FrsFragment.this.hnJ.getPageType()))) || "brand_page".equals(FrsFragment.this.hnJ.getPageType())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE, mVar));
                FrsFragment.this.b(mVar);
                FrsFragment.hnw = mVar;
            }
        }
    };
    private final CustomMessageListener hoJ = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.frs.FrsFragment.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                FrsFragment.this.hmR.updateCurrentUserPendant((com.baidu.tbadk.data.l) customResponsedMessage.getData());
                FrsFragment.this.hnt.bWo().notifyDataSetChanged();
            }
        }
    };
    private final CustomMessageListener mMemListener = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_MEM) { // from class: com.baidu.tieba.frs.FrsFragment.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && FrsFragment.this.hmR != null && (userData = FrsFragment.this.hmR.getUserData()) != null) {
                userData.setIsMem(num.intValue());
                if (num.intValue() != 0) {
                    FrsFragment.this.hnK.l(num);
                }
            }
        }
    };
    private final f.a hoK = new f.a() { // from class: com.baidu.tieba.frs.FrsFragment.21
        @Override // com.baidu.tbadk.BdToken.f.a
        public void C(HashMap<String, Object> hashMap) {
            if (hashMap != null && (hashMap.get(com.baidu.tbadk.BdToken.f.dvr) instanceof String)) {
                FrsFragment.this.hnl = (String) hashMap.get(com.baidu.tbadk.BdToken.f.dvr);
            }
        }
    };
    private final com.baidu.tieba.frs.mc.k hoL = new com.baidu.tieba.frs.mc.k() { // from class: com.baidu.tieba.frs.FrsFragment.22
        @Override // com.baidu.tieba.frs.mc.k
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.o> arrayList, boolean z3) {
            if (FrsFragment.this.hnN != null && FrsFragment.this.hnJ != null && FrsFragment.this.hnJ.caI() && z && !z2 && !z3) {
                FrsFragment.this.hnN.vc(i2);
            }
        }
    };
    public final View.OnTouchListener evw = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.FrsFragment.24
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (FrsFragment.this.hob != null) {
                FrsFragment.this.hob.onTouch(view, motionEvent);
            }
            if (FrsFragment.this.hnP != null && FrsFragment.this.hnP.bWW() != null) {
                FrsFragment.this.hnP.bWW().onTouchEvent(motionEvent);
            }
            if (FrsFragment.this.fvg != null) {
                FrsFragment.this.fvg.b(view, motionEvent);
            }
            if (FrsFragment.this.hnK != null) {
                FrsFragment.this.hnK.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private final CustomMessageListener hoM = new CustomMessageListener(CmdConfigCustom.CMD_GOTOLIVE_HOST_UPGRADE) { // from class: com.baidu.tieba.frs.FrsFragment.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.aTX().getInt(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.PHOTOLIVE_HOSTLEVEL, -1) != -1 && FrsFragment.this.hmR.getForum() != null) {
                FrsFragment.this.hmR.getForum().setCanAddPhotoLivePost(true);
            }
        }
    };
    public final View.OnClickListener hoN = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.27
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsFragment.this.hnt != null && view == FrsFragment.this.hnt.bVZ() && FrsFragment.this.getActivity() != null) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, FrsFragment.this.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            if (view.getId() == R.id.game_activity_egg_layout && com.baidu.adp.lib.util.l.isNetOk()) {
                TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_CLICK);
                if (FrsFragment.this.hnt == null || !FrsFragment.this.hnt.bWl()) {
                    String activityUrl = FrsFragment.this.hmR.getForum().getYuleData().aSP().getActivityUrl();
                    if (!StringUtils.isNull(activityUrl)) {
                        com.baidu.tbadk.browser.a.startInternalWebActivity(FrsFragment.this.getPageContext().getPageActivity(), activityUrl);
                    }
                } else {
                    FrsFragment.this.hnt.bWm();
                }
            }
            if (FrsFragment.this.hnt != null && view == FrsFragment.this.hnt.bWs() && FrsFragment.this.hnJ != null && FrsFragment.this.hnJ.hasMore()) {
                FrsFragment.this.hnt.brM();
                FrsFragment.this.bqx();
            }
            if (view != null && FrsFragment.this.hnt != null && view == FrsFragment.this.hnt.bWi()) {
                if (bc.checkUpIsLogin(FrsFragment.this.getContext())) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).ag("obj_locate", 2));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MessageCenterActivityConfig(FrsFragment.this.getContext())));
                } else {
                    return;
                }
            }
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (FrsFragment.this.hmR != null && FrsFragment.this.hmR.getForum() != null) {
                    if (FrsFragment.this.hnt != null && view == FrsFragment.this.hnt.bWg()) {
                        if (FrsFragment.this.hmR != null && FrsFragment.this.hmR.getForum() != null && !StringUtils.isNull(FrsFragment.this.hmR.getForum().getId()) && !StringUtils.isNull(FrsFragment.this.hmR.getForum().getName())) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_SHARE_CLICK).dh("fid", FrsFragment.this.hmR.getForum().getId()).ag("obj_locate", 11));
                            com.baidu.tieba.frs.f.e.a(FrsFragment.this.getPageContext(), FrsFragment.this.hmR, FrsFragment.this.hmR.getForum().getId());
                        } else {
                            return;
                        }
                    }
                    if (FrsFragment.this.hnt != null && view == FrsFragment.this.hnt.bWf()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12402").dh("fid", FrsFragment.this.hmR.getForum().getId()).dh("uid", TbadkCoreApplication.getCurrentAccount()).dh("fname", FrsFragment.this.hmR.getForum().getName()));
                        if (!StringUtils.isNull(FrsFragment.this.hmR.getForum().getName())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PostSearchActivityConfig(FrsFragment.this.getContext(), FrsFragment.this.hmR.getForum().getName(), FrsFragment.this.hmR.getForum().getId())));
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getContext().getApplicationContext(), (int) R.string.network_not_available);
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.FrsFragment.28
        private int hpb = 0;
        private int faR = 0;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsFragment.this.hoo += i2;
            if (FrsFragment.this.hoo >= FrsFragment.this.cOy * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
            if (FrsFragment.this.hnS != null) {
                FrsFragment.this.hnS.cbv();
            }
            this.hpb = 0;
            this.faR = 0;
            if (recyclerView != null && (recyclerView instanceof BdRecyclerView)) {
                this.hpb = ((BdRecyclerView) recyclerView).getFirstVisiblePosition();
                this.faR = ((BdRecyclerView) recyclerView).getLastVisiblePosition();
            }
            if (FrsFragment.this.hod != null) {
                FrsFragment.this.hod.a(recyclerView, this.hpb, this.faR);
            }
            if (FrsFragment.this.hmR != null && FrsFragment.this.hnt != null && FrsFragment.this.hnt.bWo() != null) {
                FrsFragment.this.hnt.bQ(this.hpb, this.faR);
                if (FrsFragment.this.hnI != null && FrsFragment.this.hnI.rM() != null) {
                    FrsFragment.this.hnI.rM().b(FrsFragment.this.hnH);
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (FrsFragment.this.hnK != null) {
                FrsFragment.this.hnK.setScrollState(i);
            }
            if ((i == 2 || i == 1) && !FrsFragment.this.hnD) {
                FrsFragment.this.hnD = true;
                FrsFragment.this.hnt.bWq();
            }
            if (FrsFragment.this.hnE == null && !FrsFragment.this.bVx()) {
                FrsFragment.this.hnE = new com.baidu.tbadk.n.b();
                FrsFragment.this.hnE.setSubType(1000);
            }
            if (i == 0) {
                if (FrsFragment.this.hnE != null) {
                    FrsFragment.this.hnE.bfA();
                }
                com.baidu.tieba.card.s.bLs().lT(true);
                FrsFragment.this.mJ(true);
                FrsFragment.this.hnt.bP(this.hpb, this.faR);
            } else if (FrsFragment.this.hnE != null) {
                FrsFragment.this.hnE.bfz();
            }
            if (FrsFragment.this.hod != null) {
                FrsFragment.this.hod.onScrollStateChanged(recyclerView, i);
            }
            if (i == 0) {
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.hnt, FrsFragment.this.hmR, FrsFragment.this.getForumId(), false, null);
            }
            if (FrsFragment.this.hnL != null && i == 1) {
                FrsFragment.this.hnL.ccy();
            }
            if (FrsFragment.this.hnI == null) {
                if (FrsFragment.this.hnt.bVS() != null && !FrsFragment.this.hnt.bVv() && FrsFragment.this.hnt.bVS().cQU() != null && (FrsFragment.this.hnt.bVS().cQU().getTag() instanceof com.baidu.card.ag)) {
                    FrsFragment.this.hnI = (com.baidu.card.ag) FrsFragment.this.hnt.bVS().cQU().getTag();
                }
            } else if (i == 0 && FrsFragment.this.hnt.bVS() != null && !FrsFragment.this.hnt.bVv() && FrsFragment.this.hnt.bVS().cQU() != null && (FrsFragment.this.hnt.bVS().cQU().getTag() instanceof com.baidu.card.ag)) {
                FrsFragment.this.hnI = (com.baidu.card.ag) FrsFragment.this.hnt.bVS().cQU().getTag();
            }
            if (i == 1) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921418));
            }
        }
    };
    private final d hoO = new d() { // from class: com.baidu.tieba.frs.FrsFragment.29
        @Override // com.baidu.tieba.frs.d
        public void a(int i, int i2, View view, View view2, bk bkVar) {
            if (i != FrsFragment.this.hnt.bWo().bYs()) {
                if (i != FrsFragment.this.hnt.bWo().bYt()) {
                    if (i == FrsFragment.this.hnt.bWo().bYq() && FrsFragment.this.hmR != null && FrsFragment.this.hmR.getUserData() != null && FrsFragment.this.hmR.getUserData().isBawu()) {
                        String bawuCenterUrl = FrsFragment.this.hmR.getBawuCenterUrl();
                        if (!com.baidu.tbadk.core.util.aq.isEmpty(bawuCenterUrl) && FrsFragment.this.hmR.getForum() != null) {
                            com.baidu.tbadk.browser.a.startWebActivity(FrsFragment.this.getPageContext().getPageActivity(), bawuCenterUrl);
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10502").dh("fid", FrsFragment.this.hmR.getForum().getId()).dh("uid", FrsFragment.this.hmR.getUserData().getUserId()));
                        }
                    }
                } else if (bc.checkUpIsLogin(FrsFragment.this.getPageContext().getPageActivity())) {
                    TiebaStatic.log(CommonStatisticKey.MY_SERVICE_CK);
                    if (FrsFragment.this.hmR != null && FrsFragment.this.hmR.getForum() != null) {
                        ForumData forum = FrsFragment.this.hmR.getForum();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(forum.getId(), 0L), forum.getName(), forum.getImage_url(), 0)));
                    }
                }
            } else if (bc.checkUpIsLogin(FrsFragment.this.getActivity())) {
                TiebaStatic.log("forum_fortune_click");
                com.baidu.tieba.frs.f.i.b(FrsFragment.this.getPageContext(), FrsFragment.this.hmR);
            }
        }
    };
    private final NoNetworkView.a hkP = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.FrsFragment.30
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (FrsFragment.this.hnJ.cay() == 1 && z && !FrsFragment.this.hnt.bVv()) {
                if (FrsFragment.this.hmR == null || com.baidu.tbadk.core.util.v.isEmpty(FrsFragment.this.hmR.getThreadList())) {
                    FrsFragment.this.hideNetRefreshView(FrsFragment.this.hnt.bIN());
                    FrsFragment.this.showLoadingView(FrsFragment.this.hnt.bIN(), true);
                    FrsFragment.this.hnt.mT(false);
                    FrsFragment.this.refresh();
                    return;
                }
                FrsFragment.this.hnt.bWb();
            }
        }
    };
    private final CustomMessageListener edg = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.FrsFragment.31
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                com.baidu.tieba.frs.f.c.a(customResponsedMessage, FrsFragment.this.hnt, FrsFragment.this.hmR);
            }
        }
    };
    private com.baidu.adp.widget.ListView.x hoP = new a();
    private ao hoQ = new ao() { // from class: com.baidu.tieba.frs.FrsFragment.33
        @Override // com.baidu.tieba.frs.ao
        public void a(int i, int i2, av avVar, ArrayList<com.baidu.adp.widget.ListView.o> arrayList) {
            com.baidu.adp.lib.f.e.ld().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.33.1
                @Override // java.lang.Runnable
                public void run() {
                    if (FrsFragment.this.hnt != null && FrsFragment.this.hnt.bWt()) {
                        FrsFragment.this.bqx();
                    }
                }
            });
        }
    };
    private CustomMessageListener hoR = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.frs.FrsFragment.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    FrsFragment.this.hoe = true;
                }
            }
        }
    };
    private CustomMessageListener hoS = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.frs.FrsFragment.36
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                    if (FrsFragment.this.hnI == null && FrsFragment.this.hnt.bVS() != null && !FrsFragment.this.hnt.bVv() && FrsFragment.this.hnt.bVS().cQU() != null && (FrsFragment.this.hnt.bVS().cQU().getTag() instanceof com.baidu.card.ag)) {
                        FrsFragment.this.hnI = (com.baidu.card.ag) FrsFragment.this.hnt.bVS().cQU().getTag();
                    }
                    if (FrsFragment.this.hnI != null && FrsFragment.this.hnI.rM() != null) {
                        FrsFragment.this.hnI.rM().b(new a.C0097a(3));
                    }
                }
            }
        }
    };
    private CustomMessageListener hoT = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.FrsFragment.37
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.hnt != null) {
                FrsFragment.this.hnt.ya();
            }
        }
    };
    private CustomMessageListener hoU = new CustomMessageListener(2921437) { // from class: com.baidu.tieba.frs.FrsFragment.38
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && FrsFragment.this.isResumed()) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (FrsFragment.this.hnv != null) {
                    if (booleanValue) {
                        if (FrsFragment.this.hnL.ccz() != 0 && !FrsFragment.this.hnt.bWy()) {
                            FrsFragment.this.hnv.show();
                            return;
                        }
                        return;
                    }
                    FrsFragment.this.hnv.hide();
                }
            }
        }
    };
    private CustomMessageListener hoV = new CustomMessageListener(2001223) { // from class: com.baidu.tieba.frs.FrsFragment.39
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Date)) {
                FrsFragment.this.hon = (Date) customResponsedMessage.getData();
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.frs.loadmore.a
    public /* bridge */ /* synthetic */ com.baidu.adp.base.e getPageContext() {
        return super.getPageContext();
    }

    public com.baidu.tieba.frs.entelechy.b.b bUK() {
        return this.hnR;
    }

    public com.baidu.adp.widget.ListView.x bUL() {
        return this.hoP;
    }

    public com.baidu.tieba.frs.mc.d bUM() {
        return this.hnT;
    }

    public com.baidu.tieba.frs.smartsort.a bUN() {
        return this.hnN;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public FrsModelController bUO() {
        return this.hnJ;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public com.baidu.tieba.frs.mc.c bUP() {
        return this.hnU;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public com.baidu.tieba.frs.vc.h bUQ() {
        return this.hnK;
    }

    public FrsTabViewController bUR() {
        return this.hnL;
    }

    public aq bUS() {
        return this.hnP;
    }

    public void mI(boolean z) {
        this.hom = z;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public n bUT() {
        return this.hnt;
    }

    @Override // com.baidu.tieba.frs.ap
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.ap, com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.hnl;
    }

    public void setForumName(String str) {
        this.hnl = str;
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

    @Override // com.baidu.tieba.recapp.m
    public String getFid() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.recapp.m
    public int getPageNum() {
        if (this.hnU == null) {
            return 1;
        }
        return this.hnU.getPn();
    }

    public int getPn() {
        if (this.hnU == null) {
            return 1;
        }
        return this.hnU.getPn();
    }

    public void setPn(int i) {
        if (this.hnU != null) {
            this.hnU.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.hnU != null) {
            this.hnU.setHasMore(i);
        }
    }

    public int bUU() {
        if (this.hnU == null) {
            return -1;
        }
        return this.hnU.bUU();
    }

    public boolean bUV() {
        return this.hnr;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public View getRootView() {
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.f fVar) {
        if (fVar == null) {
            String string = TbadkCoreApplication.getInst().getString(R.string.error_unkown_try_again);
            this.hnt.bVV();
            showNetRefreshView(this.hnt.bIN(), string, true);
        } else if (340001 == fVar.errorCode) {
            a(fVar, this.hmR.getRecm_forum_list());
        } else {
            if (com.baidu.tbadk.core.util.v.isEmpty(this.hmR.getThreadList())) {
                b(fVar);
            }
            if (bVx()) {
                setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds280));
            } else {
                setNetRefreshViewEmotionDefMarginTop();
            }
        }
    }

    public void a(View view, String str, boolean z, List<RecmForumInfo> list) {
        this.hnt.bVV();
        this.hnt.tS(8);
        if (this.hoc == null) {
            this.hoc = new com.baidu.tieba.frs.view.a(getPageContext(), getNetRefreshListener());
        }
        this.hoc.setSubText(str);
        this.hoc.cC(list);
        this.hoc.attachView(view, z);
    }

    private void a(com.baidu.tieba.tbadkCore.f fVar, List<RecmForumInfo> list) {
        if (this.hnt != null) {
            this.hnt.bVV();
            this.hnt.setTitle(this.hnl);
            a(this.hnt.bIN(), fVar.errorMsg, true, list);
        }
    }

    private void b(com.baidu.tieba.tbadkCore.f fVar) {
        this.hnt.bVV();
        if (fVar.gXw) {
            showNetRefreshView(this.hnt.bIN(), TbadkCoreApplication.getInst().getString(R.string.net_error_text, new Object[]{fVar.errorMsg, Integer.valueOf(fVar.errorCode)}), true);
        } else {
            showNetRefreshView(this.hnt.bIN(), fVar.errorMsg, true);
        }
    }

    public void bUW() {
        hideLoadingView(this.hnt.bIN());
        this.hnt.bqX();
        if (this.hnt.bVT() instanceof com.baidu.tieba.frs.tab.c) {
            ((com.baidu.tieba.frs.tab.c) this.hnt.bVT()).cbc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUX() {
        if (bUU() == 0 && com.baidu.tbadk.core.util.v.isEmpty(this.hmR.getThreadListIds())) {
            if (com.baidu.tbadk.core.util.v.isEmpty(this.hmR.getThreadList())) {
                this.hnt.brO();
            } else {
                this.hnt.brN();
            }
        } else if (com.baidu.tbadk.core.util.v.getCount(this.hmR.getThreadList()) > 3) {
            this.hnt.brM();
        } else {
            this.hnt.bWr();
        }
    }

    public void a(ErrorData errorData) {
        if (getActivity() != null) {
            String stringExtra = getActivity().getIntent().getStringExtra("name");
            if (getActivity().getIntent().getIntExtra(FrsActivityConfig.FRS_CALL_FROM, -1) == 12 && errorData != null && errorData.error_code == 3 && !StringUtils.isNull(stringExtra) && TbadkCoreApplication.isLogin()) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateBarGuideActivityConfig(getContext(), stringExtra)));
                getActivity().finish();
                return;
            }
            bUW();
            this.hnt.bWb();
            com.baidu.tieba.tbadkCore.f cau = this.hnJ.cau();
            boolean isEmpty = com.baidu.tbadk.core.util.v.isEmpty(this.hmR.getThreadList());
            if (cau != null && isEmpty) {
                if (this.hnJ.caw() != 0) {
                    this.hnJ.caB();
                    this.hnt.bWb();
                } else {
                    a(cau);
                }
                this.hnt.P(this.hmR.isStarForum(), false);
                return;
            }
            a(cau);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(com.baidu.tieba.tbadkCore.m mVar) {
        if (mVar != null && mVar.getEntelechyTabInfo() != null && mVar.getEntelechyTabInfo().tab != null) {
            for (FrsTabInfo frsTabInfo : mVar.getEntelechyTabInfo().tab) {
                if (frsTabInfo.tab_id.intValue() == 502 && com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean("first_into_tab_profession", true)) {
                    return false;
                }
            }
        }
        return new com.baidu.tieba.frs.ad.f(getTbPageContext()).d(mVar);
    }

    public boolean bUY() {
        return bUZ() && !bVa();
    }

    private boolean bUZ() {
        if (bVu() == null) {
            return false;
        }
        FrsViewData bVu = bVu();
        com.baidu.tbadk.core.data.s sVar = null;
        if (bVu.getStar() != null && !StringUtils.isNull(bVu.getStar().dcX())) {
            sVar = new com.baidu.tbadk.core.data.s();
        } else if (bVu.getActivityHeadData() != null && com.baidu.tbadk.core.util.v.getCount(bVu.getActivityHeadData().aOG()) >= 1) {
            sVar = bVu.getActivityHeadData().aOG().get(0);
        }
        return sVar != null;
    }

    public boolean bVa() {
        if (bVu() == null) {
            return false;
        }
        FrsViewData bVu = bVu();
        return (com.baidu.tbadk.core.util.v.isEmpty(bVu.getShowTopThreadList()) && bVu.getBusinessPromot() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVb() {
        boolean b;
        if (!bVd()) {
            final PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
            privateForumPopInfoData.a(this.hmR.getPrivateForumTotalInfo().getPrivatePopInfo());
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(getActivity());
            if (this.hmR.getPrivateForumTotalInfo().aPA().private_forum_status.intValue() == 1 && (com.baidu.tbadk.core.util.aq.isEmpty(privateForumPopInfoData.aPC()) || privateForumPopInfoData.aPF() != Integer.valueOf(this.forumId))) {
                privateForumPopInfoData.vu("create_success");
                privateForumPopInfoData.vv(TbadkCoreApplication.getInst().getString(R.string.frs_private_create_hint));
                privateForumPopInfoData.vw("https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.hnl + "&nomenu=1");
                privateForumPopInfoData.h(Integer.valueOf(this.forumId));
                b = frsPrivateCommonDialogView.b(privateForumPopInfoData);
            } else {
                b = privateForumPopInfoData.aPF() == Integer.valueOf(this.forumId) ? frsPrivateCommonDialogView.b(privateForumPopInfoData) : false;
            }
            if (b) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
                aVar.kI(2);
                aVar.aP(frsPrivateCommonDialogView);
                aVar.gX(false);
                frsPrivateCommonDialogView.setConfirmButton(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.11
                    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.frs.FrsFragment */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ba.aVa().b(FrsFragment.this.getPageContext(), new String[]{privateForumPopInfoData.aPE()});
                        aVar.dismiss();
                    }
                });
                aVar.a(new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.13
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(getPageContext()).aST();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVc() {
        if (bVd() || this.hmR.getPrivateForumTotalInfo().aPA().private_forum_status.intValue() != 1) {
            a((Integer) null, (Integer) null, true);
        } else {
            a(this.hmR.getPrivateForumTotalInfo().aPA().private_forum_audit_status, this.hmR.getPrivateForumTotalInfo().aPB(), false);
        }
    }

    public void a(Integer num, Integer num2, boolean z) {
        final String str;
        final int i = 2;
        if (this.hnt.bWh() != null) {
            TextView bWh = this.hnt.bWh();
            if (z) {
                bWh.setVisibility(8);
                return;
            }
            if (num.intValue() == 2) {
                bWh.setText("修改实名认证信息");
                bWh.setVisibility(0);
                str = "https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + this.forumId + "&nomenu=1";
            } else if (num2.intValue() >= 0 && num2.intValue() <= 100) {
                bWh.setText("目标已完成" + String.valueOf(num2) + "%");
                bWh.setVisibility(0);
                str = "https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.hnl + "&nomenu=1";
                i = 1;
            } else {
                bWh.setVisibility(8);
                i = 0;
                str = "";
            }
            bWh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.14
                /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13387").dh("fid", FrsFragment.this.forumId).dh("uid", TbadkCoreApplication.getCurrentAccount()).ag("obj_type", i));
                    ba.aVa().b(FrsFragment.this.getPageContext(), new String[]{str});
                }
            });
        }
    }

    private boolean bVd() {
        return this.hmR == null || this.hmR.getPrivateForumTotalInfo() == null || this.hmR.getPrivateForumTotalInfo().aPA() == null || this.hmR.getUserData().getIs_manager() != 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVe() {
        boolean z;
        boolean z2;
        if (this.hmR == null || this.hmR.getEntelechyTabInfo() == null || this.hmR.getEntelechyTabInfo().tab == null) {
            z = false;
        } else {
            z = false;
            for (FrsTabInfo frsTabInfo : this.hmR.getEntelechyTabInfo().tab) {
                if (frsTabInfo.tab_id.intValue() == 502) {
                    if (com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean("first_into_tab_profession", true)) {
                        return;
                    }
                } else if (frsTabInfo.is_general_tab.intValue() == 1) {
                    z2 = true;
                    z = z2;
                }
                z2 = z;
                z = z2;
            }
        }
        if (z && com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean("first_into_tab_general", true)) {
            j.a(getActivity(), getPageContext());
            com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean("first_into_tab_general", false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tI(int i) {
        List<WindowToast> list;
        if (TbadkCoreApplication.isLogin() && this.hmR != null && (list = this.hmR.mWindowToast) != null && list.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < list.size()) {
                    WindowToast windowToast = list.get(i3);
                    if (windowToast == null || windowToast.toast_type.intValue() != i) {
                        i2 = i3 + 1;
                    } else if (!com.baidu.tbadk.core.util.aq.isEmpty(windowToast.toast_link)) {
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), "", com.baidu.tbadk.util.ah.addParamsForPageTranslucent(windowToast.toast_link), true)));
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
    public void bVf() {
        if (this.hmR == null || this.hmR.getForum() != null) {
            this.hnt.bWn();
        } else if (this.hmR.getForum().getYuleData() != null && this.hmR.getForum().getYuleData().aSO()) {
            TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_VIEW);
            this.hnt.a(this.hmR.getForum().getYuleData().aSP());
        } else {
            this.hnt.bWn();
        }
    }

    private void N(boolean z, boolean z2) {
        if (this.hnJ != null && this.hmR != null && this.hnt != null && z) {
            if (!this.hnJ.caI() && this.hnJ.cay() == 1) {
                if (!this.hnJ.caG()) {
                    this.hmR.addCardVideoInfoToThreadList();
                    this.hmR.addVideoInfoToThreadListInTenAndFifteenFloor();
                }
                boolean z3 = false;
                if (this.hnt.bWo().r(com.baidu.tieba.card.data.n.gIa)) {
                    z3 = this.hmR.addHotTopicDataToThreadList();
                }
                if (!z3) {
                    this.hmR.addFeedForumDataToThreadList();
                }
                if (TbadkCoreApplication.getInst().isRecAppExist()) {
                    this.hmR.addRecommendAppToThreadList(this);
                }
                if (!this.hnt.bWo().r(bk.dEW)) {
                    this.hmR.removeAlaLiveThreadData();
                }
                this.hmR.addSchoolRecommendToThreadList();
            }
            if (!this.hnt.bWo().r(bk.dEW)) {
                this.hmR.removeAlaInsertLiveData();
                this.hmR.removeAlaStageLiveDat();
            } else {
                this.hmR.addInsertLiveDataToThreadList();
                this.hmR.addStageLiveDataToThreadList();
            }
            this.hmR.checkLiveStageInThreadList();
            this.hmR.addNoticeThreadToThreadList();
            if (this.hnt.bWo().r(com.baidu.tieba.h.b.hSm)) {
                this.hmR.addGameRankListToThreadList(z2);
            }
            if (TbadkCoreApplication.isLogin() && (!this.hnJ.caI() || this.hnJ.isNetFirstLoad)) {
                this.hmR.addUserRecommendToThreadList();
            }
            this.hmR.addVideoActivityToTop();
        }
    }

    public boolean bVg() {
        if (this.hnK != null && this.hnJ != null) {
            this.hnK.a(this.hnJ.getPageType(), this.hmR);
        }
        boolean z = false;
        if (this.hmR != null) {
            z = this.hmR.hasTab();
        }
        bVi();
        if (this.hnt != null) {
            this.hnt.bWz();
            this.hnt.bWA();
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tJ(int i) {
        as asVar = null;
        bVg();
        bVp();
        try {
            if (this.hmR != null) {
                this.hnt.a((ArrayList<com.baidu.adp.widget.ListView.o>) null, this.hmR);
                this.hnK.vv(1);
                this.hnt.bWe();
                this.hnL.a(this.hmR, this.hnJ.caD());
                com.baidu.tieba.frs.tab.d vE = this.hnL.vE(this.hmR.getFrsDefaultTabId());
                if (vE != null && !TextUtils.isEmpty(vE.url)) {
                    asVar = new as();
                    asVar.ext = vE.url;
                    asVar.stType = vE.name;
                }
                this.hnJ.a(this.hmR.getFrsDefaultTabId(), 0, asVar);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(boolean z, boolean z2) {
        try {
            if (this.hmR != null && this.hnL != null && this.hnJ != null) {
                if (!this.hnt.bWo().r(bk.dEW)) {
                    this.hmR.removeAlaLiveThreadData();
                }
                boolean isEmpty = com.baidu.tbadk.core.util.v.isEmpty(this.hmR.getGameTabInfo());
                this.hnt.mR(isEmpty);
                if (!isEmpty) {
                    if (this.hod == null) {
                        this.hod = new com.baidu.tieba.frs.vc.e(this, (NoPressedRelativeLayout) this.mRootView);
                    }
                    if (this.fvg == null) {
                        this.fvg = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
                    }
                } else {
                    this.hod = null;
                    this.fvg = null;
                }
                if (this.hmR.getForum() != null) {
                    this.hnl = this.hmR.getForum().getName();
                    this.forumId = this.hmR.getForum().getId();
                }
                if (this.hmR.hasTab()) {
                    this.hnL.a(this.hmR, this.hnJ.caD());
                }
                if (z) {
                    N(true, z);
                } else {
                    N(this.hnF, z);
                }
                bVg();
                if (this.hnR != null) {
                    this.hnR.a(this.hnK, this.hmR);
                }
                if (this.hmR.getPage() != null) {
                    setHasMore(this.hmR.getPage().aPt());
                }
                ArrayList<com.baidu.adp.widget.ListView.o> a2 = this.hnU.a(z2, true, this.hmR.getThreadList(), null, z, false);
                if (a2 != null) {
                    this.hmR.setThreadList(a2);
                }
                this.hmR.removeRedundantUserRecommendData();
                this.hmT = this.hmR.getTopThreadSize();
                if (this.hnp != null) {
                    this.hno = true;
                    this.hnp.DQ(this.hmT);
                    com.baidu.tieba.frs.f.a.a(this, this.hmR.getForum(), this.hmR.getThreadList(), this.hno, getPn());
                }
                if (this.hnJ.cay() == 1) {
                    bVm();
                    if (!z && this.hnJ.getPn() == 1) {
                        bVh();
                    }
                }
                if (this.hnS != null) {
                    this.hnS.cd(this.hnL.ccv());
                }
                bUW();
                this.hnt.bVW();
                this.hnt.P(true, false);
                if (z && this.hmR.isFirstTabEqualAllThread()) {
                    com.baidu.adp.lib.f.e.ld().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.15
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!FrsFragment.this.hnC && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                FrsFragment.this.hnt.bWx();
                            }
                        }
                    });
                }
                if (this.hmR.getForum() != null) {
                    this.hnt.ED(this.hmR.getForum().getWarningMsg());
                }
                if (this.hmR != null && this.hmR.getFrsVideoActivityData() != null && com.baidu.tbadk.core.sharedPref.b.aTX().getLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 0L) == 0) {
                    com.baidu.adp.lib.f.e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.16
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsFragment.this.hnt.bWv();
                        }
                    }, 1000L);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FRS_SHOW_AR_ENTRY, this));
                this.hnt.bVQ();
                if (this.hmR != null && this.hmR.getForum() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ENTER_FORUM, new VisitedForumData(this.hmR.getForum().getId(), this.hmR.getForum().getName(), this.hmR.getForum().getImage_url(), String.valueOf(System.currentTimeMillis() / 1000), ConstantData.Forum.SPECAIL_FORUM_TYPE_LIVE.equals(this.hmR.getForum().special_forum_type), this.hmR.getForum().getThemeColorInfo(), this.hmR.getForum().getMember_num())));
                }
                this.hoh.a(this.hmR.bottomMenuList, this.hmR.getForum());
                bVE();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void mJ(boolean z) {
        com.baidu.tieba.s.c.dcI().b(getUniqueId(), z);
    }

    public void bVh() {
        if (this.hnX == null) {
            this.hnX = new com.baidu.tieba.frs.live.a(this, com.baidu.adp.lib.f.b.toInt(this.forumId, 0));
        }
        this.hnX.caf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.tbadkCore.m mVar) {
        try {
            if (!this.hnC && mVar != null && this.hmR != null) {
                this.hmR.receiveData(mVar);
                O(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void bVi() {
        if (this.hnJ != null) {
            EC(this.hnJ.getPageType());
        } else {
            EC("normal_page");
        }
    }

    private void EC(String str) {
        mK("frs_page".equals(str));
        if (this.hnR != null) {
            this.hnR.a(this.hnK, this.hnt, this.hmR);
        }
    }

    public void mK(boolean z) {
        if (this.hnV != null) {
            this.hnV.ccj();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.s.c.dcI().z(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.frs_activity, viewGroup, false);
            this.hnf = new com.baidu.tieba.frs.entelechy.a();
            this.hnR = this.hnf.bXW();
            this.hne = TbadkCoreApplication.getInst().getString(R.string.frs_title_new_area);
            this.hnK = new com.baidu.tieba.frs.vc.h(this, this.hnf, (FrsHeaderViewContainer) this.mRootView.findViewById(R.id.header_view_container));
            this.hnL = new FrsTabViewController(this, this.mRootView);
            this.hnL.registerListener();
            this.hnK.a(this.hnL);
            this.hnL.a(this.hov);
            Intent intent = getActivity().getIntent();
            if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                this.hnh = true;
            }
            this.hnt = new n(this, this.hoN, this.hnf, this.hnh, this.hnK);
            this.hoh = new com.baidu.tieba.frs.brand.buttommenu.a(getPageContext(), this.mRootView);
        } else {
            if (this.mRootView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            if (this.hnL != null) {
                this.hnL.registerListener();
            }
            this.hnt.bWu();
            this.mRootView.setLeft(0);
            this.mRootView.setRight(com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getContext()));
        }
        this.hol = true;
        this.erX = System.currentTimeMillis() - currentTimeMillis;
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        ArrayList<com.baidu.adp.widget.ListView.o> arrayList = null;
        this.gPV = System.currentTimeMillis();
        long j = this.gPV;
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.hnq = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.gPV = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            R(intent);
        }
        this.erW = j - this.gPV;
        this.hnp = new com.baidu.tieba.tbadkCore.data.f("frs", com.baidu.tieba.tbadkCore.data.f.llq);
        if (this.hnJ == null) {
            this.hnJ = new FrsModelController(this, this.hoI);
            this.hnJ.a(this.hou);
            this.hnJ.init();
        }
        this.hnJ.setSchemeUrl(this.mSchemeUrl);
        if (intent != null) {
            this.hnJ.aj(intent.getExtras());
        } else if (bundle != null) {
            this.hnJ.aj(bundle);
        } else {
            this.hnJ.aj(null);
        }
        if (intent != null) {
            this.hnK.ap(intent.getExtras());
        } else if (bundle != null) {
            this.hnK.ap(bundle);
        } else {
            this.hnK.ap(null);
        }
        this.hns = getVoiceManager();
        this.hnY = new m(getPageContext(), this);
        initUI();
        initData(bundle);
        if (!bVx()) {
            this.hnP = new aq(getActivity(), this.hnt, this.hnK);
            this.hnP.ng(true);
        }
        this.hns = getVoiceManager();
        if (this.hns != null) {
            this.hns.onCreate(getPageContext());
        }
        new com.baidu.tieba.frs.mc.i();
        int i = -1;
        if (this.hnU != null && this.hnU.caq() != null) {
            i = this.hnU.caq().bUU();
            arrayList = this.hnU.caq().getDataList();
        }
        this.hnU = new com.baidu.tieba.frs.mc.c(this, this.hoL);
        this.hnU.caq().setHasMore(i);
        if (arrayList != null && arrayList.size() > 0) {
            this.hnU.caq().av(arrayList);
        }
        this.hnN = new com.baidu.tieba.frs.smartsort.a(this);
        this.hnV = new com.baidu.tieba.frs.vc.j(this);
        this.hnS = new com.baidu.tieba.frs.vc.a(getPageContext(), this.hnJ.caF());
        this.hnO = new com.baidu.tieba.frs.mc.b(this);
        this.hnT = new com.baidu.tieba.frs.mc.d(this);
        this.hnM = new com.baidu.tieba.frs.mc.h(this);
        this.hnW = new com.baidu.tieba.frs.mc.a(this);
        this.hnZ = new com.baidu.tieba.frs.vc.c(this);
        this.hoa = new com.baidu.tieba.frs.mc.e(this, getUniqueId());
        this.hof = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "frs");
        this.hog = new com.baidu.tieba.ala.a(getPageContext());
        this.hoi = new com.baidu.tieba.frs.sportspage.notification.a(getPageContext());
        registerListener(this.hoC);
        registerListener(this.mMemListener);
        registerListener(this.hoA);
        registerListener(this.hoM);
        registerListener(this.hoJ);
        registerListener(this.hox);
        registerListener(this.hoy);
        registerListener(this.hoz);
        registerListener(this.hor);
        registerListener(this.hos);
        registerListener(this.aei);
        registerListener(this.hoR);
        registerListener(this.hoE);
        registerListener(this.hot);
        registerListener(this.hoF);
        registerListener(this.hoD);
        registerListener(this.hoG);
        registerListener(this.hoH);
        this.hoS.setTag(getPageContext().getUniqueId());
        MessageManager.getInstance().registerListener(this.hoS);
        registerListener(this.hoT);
        registerListener(this.hoU);
        registerListener(this.hoV);
        this.hnt.mT(false);
        if (!bVx() && !this.hasInit) {
            showLoadingView(this.hnt.bIN(), true);
            this.hnJ.M(3, false);
        }
        com.baidu.tieba.frs.a.bTZ().a(new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.19
            @Override // com.baidu.tieba.frs.a.b
            public void M(boolean z, boolean z2) {
                if (FrsFragment.this.hnt != null) {
                    FrsFragment.this.hnt.tT(z ? 0 : 8);
                    if (!z2) {
                        FrsFragment.this.hok = z;
                    }
                    if (FrsFragment.this.hnt.bWo() != null && FrsFragment.this.hnJ != null && FrsFragment.this.hnJ.caz()) {
                        FrsFragment.this.hnt.bWo().notifyDataSetChanged();
                    }
                    if (FrsFragment.this.bUR() != null) {
                        FrsTabViewController.b ccw = FrsFragment.this.bUR().ccw();
                        if (ccw != null && ccw.tabId == 502 && (ccw.fragment instanceof FrsCommonTabFragment)) {
                            ((FrsCommonTabFragment) ccw.fragment).bXN();
                        } else if (ccw != null && ccw.tabId == 503 && (ccw.fragment instanceof FrsNewAreaFragment)) {
                            FrsNewAreaFragment frsNewAreaFragment = (FrsNewAreaFragment) ccw.fragment;
                            frsNewAreaFragment.bXN();
                            if (frsNewAreaFragment.caM() != null) {
                                com.baidu.tieba.frs.mc.g caM = frsNewAreaFragment.caM();
                                caM.ni(!z);
                                caM.mW(!z);
                            }
                        }
                        if (FrsFragment.this.bUR().cco() != null) {
                            FrsFragment.this.bUR().cco().setmDisallowSlip(z);
                            FrsFragment.this.bUR().nM(z);
                        }
                    }
                    if (FrsFragment.this.hnt.bVU() != null) {
                        FrsFragment.this.hnt.mQ(!z);
                    }
                    if (FrsFragment.this.getActivity() instanceof FrsActivity) {
                        ((FrsActivity) FrsFragment.this.getActivity()).mH(!z);
                    }
                    if (FrsFragment.this.hoh != null) {
                        FrsFragment.this.hoh.no(!z);
                    }
                    FrsFragment.this.hnt.mV(!z);
                    FrsFragment.this.hnt.mW(z ? false : true);
                }
            }

            @Override // com.baidu.tieba.frs.a.b
            public void tF(int i2) {
                if (FrsFragment.this.hnt != null) {
                    FrsFragment.this.hnt.tU(i2);
                }
            }

            @Override // com.baidu.tieba.frs.a.b
            public void bUf() {
                com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getContext(), (int) R.string.frs_multi_delete_max_num);
            }
        });
        this.hnt.b(new d.a() { // from class: com.baidu.tieba.frs.FrsFragment.20
            @Override // com.baidu.tieba.NEGFeedBack.d.a
            public void a(DeleteThreadHttpResponseMessage deleteThreadHttpResponseMessage) {
                boolean z;
                int i2 = 0;
                if (deleteThreadHttpResponseMessage != null) {
                    FrsFragment.this.hnt.bkQ();
                    FrsFragment.this.hnt.bWw();
                    FrsNewAreaFragment frsNewAreaFragment = null;
                    if (FrsFragment.this.hnL == null || FrsFragment.this.hnL.ccw() == null || !(FrsFragment.this.hnL.ccw().fragment instanceof FrsNewAreaFragment)) {
                        z = false;
                    } else {
                        frsNewAreaFragment = (FrsNewAreaFragment) FrsFragment.this.hnL.ccw().fragment;
                        z = true;
                    }
                    if (deleteThreadHttpResponseMessage.getError() == 0) {
                        String text = !TextUtils.isEmpty(deleteThreadHttpResponseMessage.getText()) ? deleteThreadHttpResponseMessage.getText() : FrsFragment.this.getString(R.string.delete_fail);
                        if (deleteThreadHttpResponseMessage.getRetType() == 1211066) {
                            if (FrsFragment.this.gGx == null) {
                                FrsFragment.this.gGx = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.gGx.vO(text);
                            FrsFragment.this.gGx.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.20.1
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.gGx.gX(false);
                            FrsFragment.this.gGx.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.gGx.aST();
                        } else if (deleteThreadHttpResponseMessage.getRetType() == 1211067) {
                            if (FrsFragment.this.gGx == null) {
                                FrsFragment.this.gGx = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.gGx.vO(text);
                            FrsFragment.this.gGx.a(R.string.know, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.20.2
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.gGx.gX(false);
                            FrsFragment.this.gGx.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.gGx.aST();
                        } else {
                            FrsFragment.this.hnt.aK(deleteThreadHttpResponseMessage.getText(), ContextCompat.getColor(FrsFragment.this.getContext(), deleteThreadHttpResponseMessage.getRetType() == 1 ? R.color.nav_bar_tip_error : R.color.cp_link_tip_a_alpha95));
                        }
                        if (z && frsNewAreaFragment != null) {
                            frsNewAreaFragment.cy(deleteThreadHttpResponseMessage.getSuccessItems());
                        }
                        FrsFragment.this.cm(deleteThreadHttpResponseMessage.getSuccessItems());
                        com.baidu.tieba.frs.a.bTZ().cl(deleteThreadHttpResponseMessage.getSuccessItems());
                        for (com.baidu.adp.widget.ListView.o oVar : FrsFragment.this.hmR.getThreadList()) {
                            if (oVar instanceof bj) {
                                i2++;
                                continue;
                            }
                            if (i2 >= 6) {
                                break;
                            }
                        }
                        if (i2 < 6) {
                            FrsFragment.this.bqx();
                            return;
                        }
                        return;
                    }
                    com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getActivity(), deleteThreadHttpResponseMessage.getErrorString());
                }
            }
        });
        this.cOy = UtilHelper.getScreenHeight(getActivity());
        this.hasInit = true;
        tK(1);
        super.onActivityCreated(bundle);
        this.createTime = System.currentTimeMillis() - j;
    }

    public void mL(boolean z) {
        if (this.hnL != null) {
            this.hnL.hNP = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cm(List<String> list) {
        if (!com.baidu.tbadk.core.util.v.isEmpty(list)) {
            ArrayList<com.baidu.adp.widget.ListView.o> threadList = this.hmR.getThreadList();
            if (!com.baidu.tbadk.core.util.v.isEmpty(threadList) && this.hnt.getListView() != null && this.hnt.getListView().getData() != null) {
                Iterator<com.baidu.adp.widget.ListView.o> it = threadList.iterator();
                List<com.baidu.adp.widget.ListView.o> data = this.hnt.getListView().getData();
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.o next = it.next();
                    if (next instanceof bj) {
                        bk bkVar = ((bj) next).dEA;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= list.size()) {
                                break;
                            } else if (!com.baidu.tbadk.core.util.aq.equals(list.get(i2), bkVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.hnU.d(next);
                                this.hnt.getListView().getAdapter().notifyItemRemoved(i);
                                break;
                            }
                        }
                    }
                    i++;
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void bqS() {
        if (isAdded() && this.feU && !isLoadingViewAttached()) {
            showLoadingView(this.hnt.bIN(), true);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void bqT() {
        if (isAdded() && this.feU && isLoadingViewAttached()) {
            hideLoadingView(this.hnt.bIN());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (bVx()) {
            showLoadingView(this.hnt.bIN(), true);
            this.hnt.tV(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.hnJ.M(3, true);
            aWO().scrollToPosition(0);
        }
    }

    private void tK(int i) {
        String str = "";
        if (this.hmR != null && this.hmR.getForum() != null) {
            str = this.hmR.getForum().getId();
        }
        if (!StringUtils.isNull(str)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13008").dh("fid", str).dh("obj_type", "4").ag("obj_locate", i).dh("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.aa aaVar) {
        if (aaVar != null) {
            this.evv = aaVar.bgM();
            this.hob = aaVar.bgN();
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void showFloatingView() {
        if (this.evv != null) {
            this.evv.iz(true);
        }
    }

    private void R(Intent intent) {
        if (intent != null) {
            if (intent != null) {
                if (!com.baidu.tieba.frs.f.f.a(this, getForumName(), "from", intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false)) && getActivity() != null) {
                    getActivity().finish();
                    return;
                }
            }
            Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
            this.mSchemeUrl = uri != null ? uri.toString() : null;
            if (uri != null) {
                this.hnl = uri.getQueryParameter("name");
                this.mFrom = uri.getQueryParameter("from");
                if (!StringUtils.isNull(this.hnl)) {
                    intent.putExtra("name", this.hnl);
                }
                if (!StringUtils.isNull(this.mFrom)) {
                    intent.putExtra("from", this.mFrom);
                }
                TiebaStatic.log(TbadkCoreStatisticKey.AS_INVOKE_TIEBA);
            }
            if (StringUtils.isNull(this.hnl) && uri != null) {
                if (com.baidu.tbadk.BdToken.f.p(uri)) {
                    com.baidu.tbadk.BdToken.f.aLw().b(uri, this.hoK);
                } else {
                    com.baidu.tieba.frs.f.d U = com.baidu.tieba.frs.f.i.U(intent);
                    if (U != null) {
                        this.hnl = U.forumName;
                        if (U.hLt == null || U.hLt.equals("aidou")) {
                        }
                    }
                }
                if (!StringUtils.isNull(this.hnl)) {
                    intent.putExtra("name", this.hnl);
                }
                intent.putExtra(FrsActivityConfig.FRS_CALL_FROM, 12);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.hns = getVoiceManager();
        if (this.hns != null) {
            this.hns.onStart(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        Intent intent;
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.edg);
        if (bundle != null) {
            this.hnl = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
            this.hnl = intent.getStringExtra("name");
            this.mFrom = intent.getStringExtra("from");
            this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
        }
        if (getArguments() != null) {
            this.hnm = getArguments().getBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, false);
        }
        if (TextUtils.isEmpty(this.mFrom) || FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
        }
        if (this.mIsLogin) {
            registerListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL, this.edg);
        }
        this.hnK.ap(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.s.c.dcI().A(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.hoR);
        hnw = null;
        if (this.hns != null) {
            this.hns.onDestory(getPageContext());
        }
        com.baidu.tieba.recapp.report.a.remove("FRS");
        this.hns = null;
        com.baidu.tieba.card.s.bLs().lT(false);
        if (this.hmR != null && this.hmR.getForum() != null) {
            af.bWT().ef(com.baidu.adp.lib.f.b.toLong(this.hmR.getForum().getId(), 0L));
        }
        if (this.hnX != null) {
            this.hnX.onDestory();
        }
        if (this.hnt != null) {
            com.baidu.tieba.frs.f.h.a(this.hnt, this.hmR, getForumId(), false, null);
            this.hnt.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.hnE != null) {
                this.hnE.bfB();
            }
            if (this.hnt != null) {
                this.hnt.release();
            }
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.hnK.bZX();
        if (this.hnJ != null) {
            this.hnJ.bwk();
        }
        if (this.hnP != null) {
            this.hnP.blf();
        }
        if (this.hnS != null) {
            this.hnS.destory();
        }
        if (this.hnN != null) {
            this.hnN.onDestroy();
        }
        if (this.hod != null) {
            this.hod.onDestory();
        }
        if (this.hnW != null) {
            this.hnW.onDestroy();
        }
        if (this.hof != null) {
            this.hof.onDestroy();
        }
        if (this.hog != null) {
            this.hog.onDestroy();
        }
        com.baidu.tieba.recapp.d.a.cVp().cVr();
        com.baidu.tieba.frs.f.j.cbs();
        if (this.hnL != null) {
            this.hnL.a((FrsTabViewController.a) null);
            this.hnL.ccy();
        }
        if (this.hoj != null) {
            this.hoj.onDestroy();
        }
        com.baidu.tieba.frs.a.bTZ().a(null);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.hnl);
        bundle.putString("from", this.mFrom);
        this.hnJ.onSaveInstanceState(bundle);
        if (this.hns != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            this.hns.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.hnW != null) {
            this.hnW.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.hnt != null) {
            this.hnt.bWb();
            this.hnt.onResume();
        }
        this.hnM.nE(true);
        this.hnF = true;
        if (hnk) {
            hnk = false;
            if (this.hnt != null) {
                this.hnt.startPullRefresh();
                return;
            }
            return;
        }
        if (this.hns != null) {
            this.hns.onResume(getPageContext());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_RESUME));
        if (this.hnt != null) {
            this.hnt.mX(false);
        }
        if (this.hoe) {
            refresh(6);
            this.hoe = false;
        }
        if (this.hon != null && getActivity() != null) {
            if (NotificationManagerCompat.from(getActivity()).areNotificationsEnabled()) {
                com.baidu.tbadk.coreExtra.messageCenter.f.bao().setSignAlertOn(true);
                com.baidu.tbadk.coreExtra.messageCenter.f.bao().setSignAlertTime(this.hon.getHours(), this.hon.getMinutes());
                com.baidu.tbadk.coreExtra.messageCenter.f.bao().a(getTbPageContext().getPageActivity(), this.hnt.bIN());
            }
            this.hon = null;
        }
        bVE();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
    }

    public boolean bVj() {
        Intent intent;
        if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
            return false;
        }
        return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
    }

    public void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.hnl = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.hnn = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.hnn) {
                bVk();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVk() {
        this.hnt.startPullRefresh();
    }

    public void closeActivity() {
        com.baidu.tieba.frs.f.i.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.mFrom);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.hnt.setTitle(this.hnl);
        } else {
            this.hnt.setTitle("");
            this.mFlag = 1;
        }
        this.hnt.a(this.hoP);
        this.hnt.addOnScrollListener(this.mScrollListener);
        this.hnt.g(this.hkP);
        this.hnt.bWo().a(this.hoO);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hol) {
            this.hnt.onChangeSkinType(i);
            this.hnK.vu(i);
            this.hnL.onChangeSkinType(i);
            if (this.hnv != null) {
                this.hnv.onChangeSkinType(i);
            }
            if (this.hoc != null) {
                this.hoc.onChangeSkinType();
            }
            if (this.hoh != null) {
                this.hoh.onChangeSkinType(getPageContext(), i);
            }
            if (this.gGx != null) {
                com.baidu.tbadk.q.a.a(getPageContext(), this.gGx.getRealView());
            }
            if (this.hod != null) {
                this.hod.onChangeSkinType(getPageContext(), i);
            }
        }
    }

    public void tL(int i) {
        if (!this.mIsLogin) {
            if (this.hmR != null && this.hmR.getAnti() != null) {
                this.hmR.getAnti().setIfpost(1);
            }
            if (i == 0) {
                bc.skipToLoginActivity(getActivity());
            }
        } else if (this.hmR != null) {
            if (i == 0) {
                com.baidu.tieba.frs.f.j.f(this, 0);
            } else {
                this.hnt.bWd();
            }
        }
    }

    public void refresh() {
        com.baidu.tieba.a.d.bmb().zK("page_frs");
        refresh(3);
    }

    public void refresh(int i) {
        this.hnC = false;
        bVp();
        if (this.hnt != null && this.hnt.bVS() != null) {
            this.hnt.bVS().cfI();
        }
        if (this.hnJ != null) {
            this.hnJ.M(i, true);
        }
    }

    private void bVl() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.f.h.le().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.26
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.MJ(FrsFragment.this.hnl);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVm() {
        bVp();
        try {
            if (this.hmR != null) {
                this.hnt.bvO();
                this.hnt.mQ(bVD());
                if (!com.baidu.tieba.frs.vc.h.l(this.hmR) || !com.baidu.tieba.frs.vc.h.k(this.hmR)) {
                }
                if (this.hmR.getForum() != null) {
                    this.hnl = this.hmR.getForum().getName();
                    this.forumId = this.hmR.getForum().getId();
                }
                if (this.hmR.getPage() != null) {
                    setHasMore(this.hmR.getPage().aPt());
                }
                this.hnt.setTitle(this.hnl);
                this.hnt.setForumName(this.hnl);
                TbadkCoreApplication.getInst().setDefaultBubble(this.hmR.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.hmR.getUserData().getBimg_end_time());
                bVl();
                bVn();
                ArrayList<com.baidu.adp.widget.ListView.o> threadList = this.hmR.getThreadList();
                if (threadList != null) {
                    this.hnt.a(threadList, this.hmR);
                    com.baidu.tieba.frs.f.c.A(this.hnt);
                    this.hnK.vv(getPageNum());
                    this.hnK.i(this.hmR);
                    this.hnL.a(this.hmR, this.hnJ.caD());
                    this.hnt.bWe();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void bVn() {
        if (this.hmR != null) {
            if (this.hmR.getIsNewUrl() == 1) {
                this.hnt.bWo().setFromCDN(true);
            } else {
                this.hnt.bWo().setFromCDN(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.hnM.nE(false);
        this.hnF = false;
        this.hnt.onPause();
        if (this.hns != null) {
            this.hns.onPause(getPageContext());
        }
        this.hnt.mX(true);
        if (this.hnS != null) {
            this.hnS.cbv();
        }
        com.baidu.tbadk.BdToken.c.aLi().aLn();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.hnL != null && this.hnL.ccw() != null && (this.hnL.ccw().fragment instanceof BaseFragment)) {
            ((BaseFragment) this.hnL.ccw().fragment).setPrimary(z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.s.bLs().lT(false);
        mJ(false);
        if (this.hmR != null && this.hmR.getForum() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            com.baidu.tbadk.distribute.a.bcL().b(getPageContext().getPageActivity(), "frs", this.hmR.getForum().getId(), 0L);
        }
        if (this.hns != null) {
            this.hns.onStop(getPageContext());
        }
        if (aWO() != null) {
            aWO().getRecycledViewPool().clear();
        }
        this.hnK.aWa();
        com.baidu.tbadk.util.ab.bgP();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            if (this.hnK != null) {
                this.hnK.bB(isPrimary());
            }
            if (this.hnt != null) {
                this.hnt.bB(isPrimary());
                this.hnt.mX(!isPrimary());
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (com.baidu.tieba.frs.a.bTZ().bUa()) {
                com.baidu.tieba.frs.a.bTZ().reset();
                return true;
            } else if (this.hnt != null) {
                return this.hnt.bWa();
            }
        } else if (i == 24) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921381, keyEvent));
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.m
    public TbPageContext<?> getTbPageContext() {
        return getPageContext();
    }

    @Override // com.baidu.tieba.recapp.m
    public void a(AdvertAppInfo advertAppInfo, String str) {
        com.baidu.tbadk.distribute.a.bcL().a(advertAppInfo, this.forumId, 0L, "FRS", str, getPn());
    }

    @Override // com.baidu.tieba.recapp.m
    public void bVo() {
        bUO().bVo();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.hns == null) {
            this.hns = VoiceManager.instance();
        }
        return this.hns;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdRecyclerView aWO() {
        if (this.hnt == null) {
            return null;
        }
        return this.hnt.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void bVp() {
        if (this.hns != null) {
            this.hns.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> aWP() {
        if (this.dXO == null) {
            this.dXO = UserIconBox.s(getPageContext().getPageActivity(), 8);
        }
        return this.dXO;
    }

    public void bVq() {
        if (getFragmentActivity() != null && getFragmentActivity().getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.r onGetPreLoadListView() {
        return aWO().getPreLoadHandle();
    }

    @Override // com.baidu.tieba.frs.am
    public NavigationBar bua() {
        if (this.hnt == null) {
            return null;
        }
        return this.hnt.bua();
    }

    public FRSRefreshButton bVr() {
        return this.hnv;
    }

    public void a(FRSRefreshButton fRSRefreshButton) {
        if (fRSRefreshButton != null) {
            this.hnv = fRSRefreshButton;
            this.hnv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.32
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (FrsFragment.this.hnL != null) {
                        FrsTabViewController.b ccw = FrsFragment.this.hnL.ccw();
                        if (ccw != null && ccw.fragment != null && (ccw.fragment instanceof al)) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                            ((al) ccw.fragment).bUA();
                            ((al) ccw.fragment).brL();
                            return;
                        }
                        FrsFragment.this.bUT().startPullRefresh();
                    }
                }
            });
        }
    }

    public void bVs() {
        if (this.hnv != null) {
            this.hnv.hide();
        }
    }

    public void bVt() {
        if (this.hnv != null) {
            this.hnv.show();
        }
    }

    /* loaded from: classes9.dex */
    private final class a implements com.baidu.adp.widget.ListView.x {
        private a() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.x
        public void a(View view, com.baidu.adp.widget.ListView.o oVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null) {
                if (bdUniqueId == t.hqD) {
                    if (FrsFragment.this.hnt != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11752").dh("fid", FrsFragment.this.forumId).dh("obj_locate", "1"));
                        FrsFragment.this.hnt.startPullRefresh();
                    }
                } else if (oVar != null && (oVar instanceof bj)) {
                    bk bkVar = ((bj) oVar).dEA;
                    if (bkVar.aRy() == null || bkVar.aRy().getGroup_id() == 0 || bc.checkUpIsLogin(FrsFragment.this.getActivity())) {
                        if (bkVar.aRl() != 1 || bc.checkUpIsLogin(FrsFragment.this.getActivity())) {
                            if (bkVar.aQK() != null) {
                                if (bc.checkUpIsLogin(FrsFragment.this.getActivity())) {
                                    String postUrl = bkVar.aQK().getPostUrl();
                                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.isNetOk()) {
                                        com.baidu.tbadk.browser.a.startInternalWebActivity(FrsFragment.this.getActivity(), postUrl);
                                    }
                                }
                            } else if (bkVar.aRJ() != null) {
                                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                    bc.skipToLoginActivity(FrsFragment.this.getPageContext().getPageActivity());
                                    return;
                                }
                                com.baidu.tbadk.core.data.o aRJ = bkVar.aRJ();
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), aRJ.getCartoonId(), aRJ.getChapterId(), 2)));
                            } else {
                                com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                                if (readThreadHistory != null && !readThreadHistory.MP(bkVar.getId())) {
                                    readThreadHistory.MO(bkVar.getId());
                                }
                                boolean z = false;
                                final String aQE = bkVar.aQE();
                                if (aQE != null && !aQE.equals("")) {
                                    z = true;
                                    new Thread(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.a.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(aQE);
                                            xVar.aUA().aVb().mIsNeedAddCommenParam = false;
                                            xVar.aUA().aVb().mIsUseCurrentBDUSS = false;
                                            xVar.getNetData();
                                        }
                                    }).start();
                                }
                                String tid = bkVar.getTid();
                                if (tid == null) {
                                    tid = "";
                                }
                                if (bkVar.aQs() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                    ba.aVa().b(FrsFragment.this.getPageContext(), new String[]{tid, "", null});
                                    return;
                                }
                                if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && tid.length() > 4 && tid.length() > 4) {
                                    bkVar.setId(tid.substring(3));
                                }
                                if (bdUniqueId.getId() == bk.dGz.getId()) {
                                    com.baidu.tieba.frs.f.h.a(bkVar.aQd());
                                } else if (bdUniqueId.getId() == bk.dEZ.getId()) {
                                    com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                                    anVar.dh("obj_type", "2");
                                    anVar.dh("tid", bkVar.getTid());
                                    TiebaStatic.log(anVar);
                                }
                                com.baidu.tieba.frs.f.i.a(FrsFragment.this, bkVar, i, z);
                                com.baidu.tieba.frs.f.h.a(FrsFragment.this, FrsFragment.this.hmR, bkVar);
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.l.isNetOk()) {
            hideNetRefreshView(this.hnt.bIN());
            showLoadingView(this.hnt.bIN(), true);
            this.hnt.mT(false);
            this.hnJ.M(3, true);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData bVu() {
        return this.hmR;
    }

    public boolean bVv() {
        return this.hnt.bVv();
    }

    public void az(Object obj) {
        if (this.hnO != null && this.hnO.hGN != null) {
            this.hnO.hGN.callback(obj);
        }
    }

    public void aA(Object obj) {
        if (this.hnO != null && this.hnO.hGO != null) {
            this.hnO.hGO.callback(obj);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        this.hnt.getListView().stopScroll();
        if (!this.hnt.bWk()) {
            if (!com.baidu.adp.lib.util.l.isNetOk()) {
                this.hnt.brO();
            } else if (this.hnJ.cay() == 1) {
                bqM();
                bqx();
            } else if (this.hnJ.hasMore()) {
                bqx();
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void onFailed(String str) {
        bqM();
        showToast(str);
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void an(ArrayList<com.baidu.adp.widget.ListView.o> arrayList) {
        boolean isEmpty = com.baidu.tbadk.core.util.v.isEmpty(arrayList);
        setHasMore(isEmpty ? 0 : 1);
        bqM();
        if (!isEmpty) {
            if (!this.hnJ.caI() && TbadkCoreApplication.getInst().isRecAppExist() && this.hnJ.cay() == 1) {
                this.hmR.addRecommendAppToThreadList(this, arrayList);
            }
            if (this.hnJ != null) {
                com.baidu.tieba.frs.d.a.a(getUniqueId(), arrayList, this.hmR.getForum(), this.hnJ.getSortType());
            }
            ArrayList<com.baidu.adp.widget.ListView.o> a2 = this.hnU.a(false, false, arrayList, this.hnp, false);
            if (a2 != null) {
                this.hmR.setThreadList(a2);
                this.hnt.a(a2, this.hmR);
            }
            if (this.hnJ != null) {
                com.baidu.tieba.frs.d.c.a(this.hmR, this.hnJ.caD(), 2, getContext());
            }
        }
    }

    private void bqM() {
        if (bUU() == 1 || this.hnU.cx(this.hmR.getThreadListIds())) {
            if (com.baidu.tbadk.core.util.v.getCount(this.hmR.getThreadList()) > 3) {
                this.hnt.brM();
            } else {
                this.hnt.bWr();
            }
        } else if (com.baidu.tbadk.core.util.v.isEmpty(this.hmR.getThreadList())) {
            this.hnt.brO();
        } else {
            this.hnt.brN();
        }
    }

    @Override // com.baidu.tieba.frs.mc.l
    public void bqx() {
        if (this.hnU != null) {
            this.hnU.a(this.hnl, this.forumId, this.hmR);
        }
    }

    public void bVw() {
        if (!com.baidu.tbadk.core.util.ab.requestWriteExternalStorgeAndCameraPermission(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.al.d(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment, com.baidu.h.a.a.InterfaceC0125a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        com.baidu.tieba.frs.f.i.a(this, i, strArr, iArr);
    }

    public void mM(boolean z) {
        if (this.hnP != null) {
            this.hnP.ng(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.hnQ.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a oO(int i) {
        return this.hnQ.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        this.hnY.b(bVar);
    }

    public boolean bVx() {
        return this.hnh;
    }

    @Override // com.baidu.tieba.frs.aj
    public void Ho() {
        if (this.hnt != null) {
            showFloatingView();
            this.hnt.getListView().scrollToPosition(0);
            this.hnt.startPullRefresh();
        }
    }

    public ForumWriteData bVy() {
        if (this.hmR == null || this.hmR.getForum() == null) {
            return null;
        }
        ForumData forum = this.hmR.getForum();
        ForumWriteData forumWriteData = new ForumWriteData(forum.getId(), forum.getName(), forum.getPrefixData(), this.hmR.getAnti());
        forumWriteData.avatar = forum.getImage_url();
        forumWriteData.forumLevel = forum.getUser_level();
        forumWriteData.specialForumType = forum.special_forum_type;
        forumWriteData.firstDir = forum.getFirst_class();
        forumWriteData.secondDir = forum.getSecond_class();
        UserData userData = this.hmR.getUserData();
        forumWriteData.privateThread = userData != null ? userData.getPrivateThread() : 0;
        forumWriteData.frsTabInfo = bVz();
        return forumWriteData;
    }

    private FrsTabInfoData bVz() {
        int i;
        if (this.hnJ == null || this.hmR == null || this.hnL == null) {
            return null;
        }
        if (this.hmR.getEntelechyTabInfo() == null || com.baidu.tbadk.core.util.v.isEmpty(this.hmR.getEntelechyTabInfo().tab)) {
            return null;
        }
        int ccA = this.hnL.ccA();
        if (ccA == 502) {
            return null;
        }
        int i2 = -1;
        ArrayList arrayList = new ArrayList();
        Iterator<FrsTabInfo> it = this.hmR.getEntelechyTabInfo().tab.iterator();
        while (true) {
            i = i2;
            if (!it.hasNext()) {
                break;
            }
            FrsTabInfo next = it.next();
            if (next != null && next.is_general_tab.intValue() == 1) {
                arrayList.add(new FrsTabItemData(next));
                if (ccA == next.tab_id.intValue()) {
                    i2 = ccA;
                }
            }
            i2 = i;
        }
        if (com.baidu.tbadk.core.util.v.isEmpty(arrayList)) {
            return null;
        }
        FrsTabInfoData frsTabInfoData = new FrsTabInfoData();
        frsTabInfoData.tabList = arrayList;
        frsTabInfoData.selectedTabId = i;
        return frsTabInfoData;
    }

    @Override // com.baidu.tieba.frs.aj
    public void aWr() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void mN(boolean z) {
        this.hnG = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z) {
        this.hnt.tS(8);
        ((FrsActivity) getActivity()).showLoadingView(view, z);
        ((FrsActivity) getActivity()).j(view, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        this.hnt.tS(0);
        ((FrsActivity) getActivity()).hideLoadingView(view);
        ((FrsActivity) getActivity()).j(view, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        super.showNetRefreshView(view, getResources().getString(R.string.refresh_view_title_text), null, getResources().getString(R.string.refresh_view_button_text), z, getNetRefreshListener());
        this.hnt.tS(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshViewNoClick(View view, String str, boolean z) {
        super.showNetRefreshViewNoClick(view, str, z);
        this.hnt.tS(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        super.hideNetRefreshView(view);
        this.hnt.tS(0);
    }

    public void bVA() {
        FrsTabViewController.b ccw;
        if (this.hnL != null && (ccw = this.hnL.ccw()) != null && ccw.fragment != null && (ccw.fragment instanceof al)) {
            ((al) ccw.fragment).bUA();
        }
    }

    public void mO(boolean z) {
        this.hnj = z;
    }

    public void b(OvalActionButton ovalActionButton) {
        this.hnu = ovalActionButton;
    }

    public OvalActionButton bVB() {
        return this.hnu;
    }

    public boolean bVC() {
        return this.hnj;
    }

    public void onShareSuccess(String str) {
        if (TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.util.aq.isEmpty(str)) {
            if (this.hoj == null) {
                this.hoj = new AddExperiencedModel(getTbPageContext());
            }
            this.hoj.fj(this.forumId, str);
        }
    }

    public boolean bVD() {
        if (this.hnG && !this.hom) {
            return (this.hnJ != null && this.hnJ.caz() && com.baidu.tieba.frs.a.bTZ().bUa()) ? false : true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.f.c
    public boolean videoNeedPreload() {
        if (this.hmR != null) {
            return com.baidu.tbadk.util.ag.nK(2) || (com.baidu.tbadk.util.ag.bgU() && this.hmR.isFrsVideoAutoPlay);
        }
        return super.videoNeedPreload();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.f.c
    public boolean isCyberVideoUsedThisPage() {
        return com.baidu.tbadk.a.b.uD("cyber_player_test") || com.baidu.tbadk.a.b.uC("cyber_player_test");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVE() {
        if (!com.baidu.tbadk.core.util.aq.isEmpty(this.forumId)) {
            com.baidu.tbadk.BdToken.c.aLi().p(com.baidu.tbadk.BdToken.b.dtT, com.baidu.adp.lib.f.b.toLong(this.forumId, 0L));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        FrsTabViewController.b ccw;
        if (bUR() == null || (ccw = bUR().ccw()) == null || !(ccw.fragment instanceof BaseFragment)) {
            return null;
        }
        if (ccw.fragment instanceof FrsAllThreadFragment) {
            TbPageTag tbPageTag = super.getTbPageTag();
            int i = -1;
            if (this.hmR != null) {
                i = this.hmR.getSortType();
            }
            tbPageTag.sortType = com.baidu.tieba.frs.f.g.vs(i);
            tbPageTag.locatePage = "a070";
            if (this.hne.equals(ccw.title)) {
                tbPageTag.locatePage = "a071";
            }
            return tbPageTag;
        } else if (ccw.fragment instanceof FrsFragment) {
            return null;
        } else {
            return ((BaseFragment) ccw.fragment).getTbPageTag();
        }
    }

    public void bVF() {
        if (this.hmR != null) {
            com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
            if (this.hmR.needLog == 1) {
                bVar.hJA = true;
            } else {
                bVar.hJA = false;
            }
            if (this.hmR.getForum() != null) {
                bVar.hJC = this.hmR.getForum().getId();
            }
            if (bUO() != null) {
                bVar.hJB = bUO().caD();
            }
            if (com.baidu.tieba.frs.d.d.hvL != null) {
                bVar.hJD = com.baidu.tieba.frs.d.d.hvL.hJD;
                bVar.hJE = com.baidu.tieba.frs.d.d.hvL.hJE;
            }
            this.hop = new com.baidu.tieba.frs.live.b(bVar, getTbPageTag(), getUniqueId());
            this.hop.uV(this.hoq);
            CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_CARD_CLICK, this.hop);
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
            CustomMessageTask customMessageTask2 = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW, this.hop);
            customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask2);
            CustomMessageTask customMessageTask3 = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_USER_CLICK, this.hop);
            customMessageTask3.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask3);
            CustomMessageTask customMessageTask4 = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_VIDEO_CLICK, this.hop);
            customMessageTask4.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask4);
        }
    }
}
