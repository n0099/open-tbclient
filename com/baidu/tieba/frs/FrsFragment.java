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
    public static com.baidu.tieba.tbadkCore.m hnl;
    private com.baidu.adp.lib.d.b<TbImageView> dXO;
    private com.baidu.tbadk.util.z evv;
    private com.baidu.tieba.frs.gametab.b fuV;
    private com.baidu.tbadk.core.dialog.a gGm;
    private com.baidu.tieba.frs.entelechy.a hmU;
    private FrsTabViewController hnA;
    private com.baidu.tieba.frs.mc.h hnB;
    private com.baidu.tieba.frs.smartsort.a hnC;
    private com.baidu.tieba.frs.mc.b hnD;
    private aq hnE;
    private com.baidu.tieba.frs.entelechy.b.b hnG;
    private com.baidu.tieba.frs.vc.a hnH;
    private com.baidu.tieba.frs.mc.d hnI;
    private com.baidu.tieba.frs.mc.c hnJ;
    private com.baidu.tieba.frs.vc.j hnK;
    private com.baidu.tieba.frs.mc.a hnL;
    private com.baidu.tieba.frs.live.a hnM;
    private m hnN;
    public com.baidu.tieba.frs.vc.c hnO;
    private com.baidu.tieba.frs.mc.e hnP;
    private View.OnTouchListener hnQ;
    private com.baidu.tieba.frs.view.a hnR;
    private com.baidu.tieba.frs.vc.e hnS;
    private boolean hnT;
    private com.baidu.tieba.NEGFeedBack.a hnU;
    private com.baidu.tieba.ala.a hnV;
    private com.baidu.tieba.frs.brand.buttommenu.a hnW;
    private com.baidu.tieba.frs.sportspage.notification.a hnX;
    private AddExperiencedModel hnY;
    private com.baidu.tieba.tbadkCore.data.f hne;
    private VoiceManager hnh;
    private OvalActionButton hnj;
    private FRSRefreshButton hnk;
    public long hnm;
    private com.baidu.card.ag hnx;
    private FrsModelController hny;
    private com.baidu.tieba.frs.vc.h hnz;
    private boolean hoa;
    private com.baidu.tieba.frs.live.b hoe;
    private int hof;
    private int hol;
    private View mRootView;
    private String mSchemeUrl;
    public static boolean hmZ = false;
    public static volatile long hno = 0;
    public static volatile long hnp = 0;
    public static volatile int mNetError = 0;
    private String hmT = "";
    public boolean hmV = false;
    private boolean hmW = false;
    private boolean hmX = false;
    private boolean hmY = true;
    public String hna = null;
    public String mFrom = null;
    public int mFlag = 0;
    public boolean hnb = false;
    private boolean hnc = false;
    private String mThreadId = null;
    public String forumId = null;
    private int hmI = 0;
    private boolean hnd = false;
    private boolean hnf = false;
    private boolean hng = false;
    private n hni = null;
    public final bk ahg = null;
    private FrsViewData hmG = new FrsViewData();
    public long gPK = -1;
    public long esg = 0;
    public long erW = 0;
    public long createTime = 0;
    public long erX = 0;
    public long esd = 0;
    public long hnn = 0;
    public boolean hnq = false;
    private boolean hnr = false;
    private boolean hns = false;
    public com.baidu.tbadk.n.b hnt = null;
    private boolean hnu = true;
    private boolean hnv = true;
    private a.C0097a hnw = new a.C0097a(2);
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> hnF = new SparseArray<>();
    private boolean feJ = true;
    private boolean hasInit = false;
    private boolean hnZ = false;
    private boolean hob = false;
    private Date hoc = null;
    private int cOy = 0;
    private int hod = 0;
    public int mHeadLineDefaultNavTabId = -1;
    private final CustomMessageListener hog = new CustomMessageListener(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED) { // from class: com.baidu.tieba.frs.FrsFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof bk) {
                    com.baidu.tieba.frs.f.h.a(FrsFragment.this.hni, FrsFragment.this.hmG, FrsFragment.this.getForumId(), true, (bk) data);
                }
            }
        }
    };
    private CustomMessageListener hoh = new CustomMessageListener(CmdConfigCustom.CMD_CLOSE_GAME_RANK_CARD) { // from class: com.baidu.tieba.frs.FrsFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.hmG != null) {
                FrsFragment.this.hmG.removeGameRankListFromThreadList();
                if (FrsFragment.this.hni != null) {
                    FrsFragment.this.hni.aES();
                }
            }
        }
    };
    private CustomMessageListener aei = new CustomMessageListener(2921401) { // from class: com.baidu.tieba.frs.FrsFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && FrsFragment.this.hnk != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() <= 0 || FrsFragment.this.hnA.ccr() == 0 || FrsFragment.this.hnA.cco() == null || !(FrsFragment.this.hnA.cco().fragment instanceof BaseFragment) || !((BaseFragment) FrsFragment.this.hnA.cco().fragment).isPrimary() || FrsFragment.this.hni.bWw()) {
                    if (FrsFragment.this.hnA.ccr() != 0) {
                        FrsFragment.this.hnk.hide();
                        return;
                    }
                    return;
                }
                FrsFragment.this.hnk.show();
            }
        }
    };
    private CustomMessageListener hoi = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.FrsFragment.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 1) {
                    FrsFragment.this.bVi();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                }
            }
        }
    };
    private final ao hoj = new ao() { // from class: com.baidu.tieba.frs.FrsFragment.40
        @Override // com.baidu.tieba.frs.ao
        public void a(int i, int i2, av avVar, ArrayList<com.baidu.adp.widget.ListView.o> arrayList) {
            FrsFragment.this.bUU();
            if (FrsFragment.this.hnG != null) {
                FrsFragment.this.hnz.nL(FrsFragment.this.hnG.ur(i));
            }
            com.baidu.tieba.tbadkCore.f fVar = new com.baidu.tieba.tbadkCore.f();
            if (avVar != null) {
                fVar.isSuccess = avVar.errCode == 0;
                fVar.errorCode = avVar.errCode;
                fVar.errorMsg = avVar.errMsg;
                if (fVar.isSuccess) {
                    if (com.baidu.tbadk.core.util.v.isEmpty(arrayList)) {
                        FrsFragment.this.hni.brM();
                    } else if (avVar.hasMore) {
                        if (com.baidu.tbadk.core.util.v.getCount(FrsFragment.this.hmG.getThreadList()) > 3) {
                            FrsFragment.this.hni.brK();
                        } else {
                            FrsFragment.this.hni.bWp();
                        }
                    } else if (avVar.hrp) {
                        FrsFragment.this.hni.brL();
                    } else {
                        FrsFragment.this.hni.brM();
                    }
                }
            } else {
                avVar = new av();
                avVar.pn = 1;
                avVar.hasMore = false;
                avVar.hrp = false;
            }
            if (i == 1) {
                FrsFragment.this.hnu = true;
                FrsFragment.this.hox.a(FrsFragment.this.hny.getType(), false, fVar);
            } else {
                FrsFragment.this.a(fVar);
                if (FrsFragment.this.hny.bZR() != null) {
                    FrsFragment.this.hmG = FrsFragment.this.hny.bZR();
                }
                FrsFragment.this.bVk();
            }
            if (FrsFragment.this.hoF != null) {
                FrsFragment.this.hoF.a(i, i2, avVar, arrayList);
            }
        }
    };
    private FrsTabViewController.a hok = new FrsTabViewController.a() { // from class: com.baidu.tieba.frs.FrsFragment.41
        @Override // com.baidu.tieba.frs.vc.FrsTabViewController.a
        public void bO(int i, int i2) {
            boolean z = false;
            if (i != 1) {
                com.baidu.tieba.card.s.bLq().lT(false);
                FrsFragment.this.mJ(false);
            }
            if (i == 502) {
                FrsFragment.this.hnj.setIconFade(R.drawable.btn_frs_professional_edit_n);
            } else {
                FrsFragment.this.hnj.setIconFade(0);
            }
            FrsFragment.this.hol = i;
            FrsFragment.this.hof = i2;
            if (FrsFragment.this.hoe != null) {
                FrsFragment.this.hoe.uT(FrsFragment.this.hof);
            }
            TbSingleton.getInstance().setFrsCurTabType(FrsFragment.this.hof);
            FrsFragment.this.bVn();
            com.baidu.tieba.frs.d.d.hvA.hIQ = i;
            com.baidu.tieba.frs.d.d.hvA.hIR = -1;
            com.baidu.tieba.frs.a bTX = com.baidu.tieba.frs.a.bTX();
            if (i == 1 && FrsFragment.this.hnZ) {
                z = true;
            }
            bTX.L(z, true);
        }
    };
    private CustomMessageListener hom = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIVE_COUNT) { // from class: com.baidu.tieba.frs.FrsFragment.42
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                FrsFragment.this.hnA.vD(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    };
    private CustomMessageListener hon = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_LIVE_START) { // from class: com.baidu.tieba.frs.FrsFragment.43
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && ((Integer) customResponsedMessage.getData()).intValue() == 51 && FrsFragment.this.hmG != null) {
                com.baidu.tieba.frs.f.j.a(FrsFragment.this.hmG, FrsFragment.this.getPageContext());
            }
        }
    };
    private final CustomMessageListener hoo = new CustomMessageListener(CmdConfigCustom.CMD_FRS_SELECT_ALA_LIVE_TAB) { // from class: com.baidu.tieba.frs.FrsFragment.44
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                FrsFragment.this.hnA.vB(49);
            }
        }
    };
    private final CustomMessageListener hop = new CustomMessageListener(CmdConfigCustom.CMD_FRS_EXPERIENCE_TIP) { // from class: com.baidu.tieba.frs.FrsFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.u) && FrsFragment.this.hmG != null) {
                FrsFragment.this.hmG.updateLikeData((com.baidu.tieba.tbadkCore.u) customResponsedMessage.getData());
                FrsFragment.this.hnz.i(FrsFragment.this.hmG);
                FrsFragment.this.hnA.a(FrsFragment.this.hmG, FrsFragment.this.hny.cav());
            }
        }
    };
    private final AntiHelper.a hoq = new AntiHelper.a() { // from class: com.baidu.tieba.frs.FrsFragment.3
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ag("obj_locate", at.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ag("obj_locate", at.a.LOCATE_LIKE_PERSON));
        }
    };
    private CustomMessageListener hor = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.FrsFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(FrsFragment.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().ecK != null) {
                        if (AntiHelper.a(FrsFragment.this.getActivity(), updateAttentionMessage.getData().ecK, FrsFragment.this.hoq) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ag("obj_locate", at.a.LOCATE_LIKE_PERSON));
                        }
                    } else if (updateAttentionMessage.getData().isSucc && updateAttentionMessage.getData().isAttention) {
                        com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getPageContext().getPageActivity(), (int) R.string.attention_success);
                    }
                }
            }
        }
    };
    private CustomMessageListener hos = new CustomMessageListener(CmdConfigCustom.CMD_GET_ENSURE_CAST_ID) { // from class: com.baidu.tieba.frs.FrsFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsFragment.this.refresh();
        }
    };
    private CustomMessageListener hot = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.frs.FrsFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && !((PostWriteCallBackData) customResponsedMessage.getData()).isDyamicCallback()) {
                FrsFragment.this.hni.c((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener hou = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_REMIND) { // from class: com.baidu.tieba.frs.FrsFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewsRemindMessage newsRemindMessage;
            if (customResponsedMessage != null && (customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626 && (newsRemindMessage = (NewsRemindMessage) customResponsedMessage) != null) {
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (FrsFragment.this.hni != null) {
                    FrsFragment.this.hni.J(notificationCount, z);
                }
            }
        }
    };
    private final CustomMessageListener hov = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.frs.FrsFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.isResumed()) {
                FrsFragment.this.bVC();
            }
        }
    };
    private CustomMessageListener how = new CustomMessageListener(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER) { // from class: com.baidu.tieba.frs.FrsFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (FrsFragment.this.hni != null) {
                    FrsFragment.this.hni.setExpanded(booleanValue);
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.q hox = new com.baidu.tieba.tbadkCore.q() { // from class: com.baidu.tieba.frs.FrsFragment.10
        private long startTime = 0;

        @Override // com.baidu.tieba.tbadkCore.q
        public void tK(int i) {
            this.startTime = System.nanoTime();
            if (FrsFragment.this.hni != null) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsFragment.this.hni.bVZ();
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
            if (FrsFragment.this.feJ) {
                FrsFragment.this.feJ = false;
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.hni, FrsFragment.this.hmG, FrsFragment.this.getForumId(), false, null);
            }
            FrsFragment.this.bUU();
            FrsFragment.this.hnr = true;
            if (fVar != null && fVar.isSuccess) {
                FrsFragment.this.hni.bWm().ns(com.baidu.tbadk.core.util.ar.aUW().aUX());
                FrsFragment.hno = 0L;
                FrsFragment.hnp = 0L;
                FrsFragment.mNetError = 0;
            } else {
                FrsFragment.mNetError = 1;
            }
            if (!FrsFragment.this.hny.caA() && (i == 3 || i == 6)) {
                FrsFragment.this.hnJ.resetData();
            }
            FrsFragment.this.hnm = System.currentTimeMillis();
            if (FrsFragment.this.hny.bZR() != null) {
                FrsFragment.this.hmG = FrsFragment.this.hny.bZR();
            }
            FrsFragment.this.hni.b(FrsFragment.this.hmG.getRedpacketRainData());
            FrsFragment.this.tG(1);
            if (i == 7) {
                FrsFragment.this.tH(FrsFragment.this.hmG.getFrsDefaultTabId());
                return;
            }
            if (FrsFragment.this.hmG.getPage() != null) {
                FrsFragment.this.setHasMore(FrsFragment.this.hmG.getPage().aPt());
            }
            if (i == 4) {
                if (!FrsFragment.this.hny.caA() && TbadkCoreApplication.getInst().isRecAppExist() && FrsFragment.this.hny.caq() == 1) {
                    FrsFragment.this.hmG.addRecommendAppToThreadList(FrsFragment.this);
                }
                ArrayList<com.baidu.adp.widget.ListView.o> a2 = FrsFragment.this.hnJ.a(false, false, FrsFragment.this.hmG.getThreadList(), FrsFragment.this.hne, false);
                if (a2 != null) {
                    FrsFragment.this.hmG.setThreadList(a2);
                    FrsFragment.this.hmG.checkLiveStageInThreadList();
                }
                if (FrsFragment.this.hny != null) {
                    com.baidu.tieba.frs.d.c.a(FrsFragment.this.hmG, FrsFragment.this.hny.cav(), 2, FrsFragment.this.getContext());
                }
                com.baidu.tieba.frs.f.a.a(FrsFragment.this, FrsFragment.this.hmG.getForum(), FrsFragment.this.hmG.getThreadList(), false, FrsFragment.this.getPn());
                FrsFragment.this.hni.a(a2, FrsFragment.this.hmG);
                FrsFragment.this.bUV();
                return;
            }
            FrsFragment.this.bUV();
            switch (i) {
                case 1:
                    FrsFragment.this.hni.bVZ();
                    break;
                case 2:
                    FrsFragment.this.hni.bVZ();
                    break;
                case 3:
                case 6:
                    if (FrsFragment.this.hmG != null) {
                        FrsFragment.this.hmG.clearPostThreadCount();
                    }
                    if (FrsFragment.this.hnO != null) {
                        FrsFragment.this.hnO.refresh();
                        break;
                    }
                    break;
            }
            FrsFragment.this.bVd();
            if (fVar == null || fVar.errorCode == 0) {
                if (FrsFragment.this.hmG != null) {
                    if (!FrsFragment.this.a(FrsFragment.this.hmG)) {
                        FrsFragment.this.bVc();
                    }
                    FrsFragment.this.O(false, i == 5);
                    if (FrsFragment.this.hny != null) {
                        if (FrsFragment.this.hmG.getActivityHeadData() != null && FrsFragment.this.hmG.getActivityHeadData().aOG() != null && FrsFragment.this.hmG.getActivityHeadData().aOG().size() > 0) {
                            com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), 1, FrsFragment.this.hmG.getForum(), FrsFragment.this.hny.getSortType(), 1);
                        }
                        if (FrsFragment.this.hmG.getThreadList() != null && FrsFragment.this.hmG.getThreadList().size() > 0) {
                            Iterator<com.baidu.adp.widget.ListView.o> it = FrsFragment.this.hmG.getThreadList().iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    com.baidu.adp.widget.ListView.o next = it.next();
                                    if ((next instanceof bk) && ((bk) next).getType() == bk.dGz) {
                                        com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), 1, FrsFragment.this.hmG.getForum(), FrsFragment.this.hny.getSortType(), 2);
                                    }
                                }
                            }
                        }
                        com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), FrsFragment.this.hmG.getThreadList(), FrsFragment.this.hmG.getForum(), FrsFragment.this.hny.getSortType());
                    }
                    FrsFragment.this.hni.tU(i);
                    FrsFragment.hno = (System.nanoTime() - this.startTime) / TimeUtils.NANOS_PER_MS;
                    if (fVar != null) {
                        FrsFragment.hnp = fVar.liw;
                    }
                } else {
                    return;
                }
            } else if (FrsFragment.this.hmG == null || com.baidu.tbadk.core.util.v.isEmpty(FrsFragment.this.hmG.getThreadList())) {
                FrsFragment.this.a(fVar);
            } else if (fVar.gXl) {
                FrsFragment.this.showToast(FrsFragment.this.getPageContext().getResources().getString(R.string.net_error_text, fVar.errorMsg, Integer.valueOf(fVar.errorCode)));
            }
            FrsFragment.this.bUZ();
            FrsFragment.this.bVa();
            if (FrsFragment.this.hmG.getAccessFlag() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11384"));
            }
            if (FrsFragment.this.hnf && FrsFragment.this.hnA.vB(49)) {
                FrsFragment.this.hnf = false;
            }
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.q
        public void c(com.baidu.tieba.tbadkCore.m mVar) {
            if ((mVar != null && ("normal_page".equals(FrsFragment.this.hny.getPageType()) || "frs_page".equals(FrsFragment.this.hny.getPageType()) || "book_page".equals(FrsFragment.this.hny.getPageType()))) || "brand_page".equals(FrsFragment.this.hny.getPageType())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE, mVar));
                FrsFragment.this.b(mVar);
                FrsFragment.hnl = mVar;
            }
        }
    };
    private final CustomMessageListener hoy = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.frs.FrsFragment.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                FrsFragment.this.hmG.updateCurrentUserPendant((com.baidu.tbadk.data.l) customResponsedMessage.getData());
                FrsFragment.this.hni.bWm().notifyDataSetChanged();
            }
        }
    };
    private final CustomMessageListener mMemListener = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_MEM) { // from class: com.baidu.tieba.frs.FrsFragment.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && FrsFragment.this.hmG != null && (userData = FrsFragment.this.hmG.getUserData()) != null) {
                userData.setIsMem(num.intValue());
                if (num.intValue() != 0) {
                    FrsFragment.this.hnz.l(num);
                }
            }
        }
    };
    private final f.a hoz = new f.a() { // from class: com.baidu.tieba.frs.FrsFragment.21
        @Override // com.baidu.tbadk.BdToken.f.a
        public void C(HashMap<String, Object> hashMap) {
            if (hashMap != null && (hashMap.get(com.baidu.tbadk.BdToken.f.dvr) instanceof String)) {
                FrsFragment.this.hna = (String) hashMap.get(com.baidu.tbadk.BdToken.f.dvr);
            }
        }
    };
    private final com.baidu.tieba.frs.mc.k hoA = new com.baidu.tieba.frs.mc.k() { // from class: com.baidu.tieba.frs.FrsFragment.22
        @Override // com.baidu.tieba.frs.mc.k
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.o> arrayList, boolean z3) {
            if (FrsFragment.this.hnC != null && FrsFragment.this.hny != null && FrsFragment.this.hny.caA() && z && !z2 && !z3) {
                FrsFragment.this.hnC.va(i2);
            }
        }
    };
    public final View.OnTouchListener evw = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.FrsFragment.24
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (FrsFragment.this.hnQ != null) {
                FrsFragment.this.hnQ.onTouch(view, motionEvent);
            }
            if (FrsFragment.this.hnE != null && FrsFragment.this.hnE.bWU() != null) {
                FrsFragment.this.hnE.bWU().onTouchEvent(motionEvent);
            }
            if (FrsFragment.this.fuV != null) {
                FrsFragment.this.fuV.b(view, motionEvent);
            }
            if (FrsFragment.this.hnz != null) {
                FrsFragment.this.hnz.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private final CustomMessageListener hoB = new CustomMessageListener(CmdConfigCustom.CMD_GOTOLIVE_HOST_UPGRADE) { // from class: com.baidu.tieba.frs.FrsFragment.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.aTX().getInt(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.PHOTOLIVE_HOSTLEVEL, -1) != -1 && FrsFragment.this.hmG.getForum() != null) {
                FrsFragment.this.hmG.getForum().setCanAddPhotoLivePost(true);
            }
        }
    };
    public final View.OnClickListener hoC = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.27
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsFragment.this.hni != null && view == FrsFragment.this.hni.bVX() && FrsFragment.this.getActivity() != null) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, FrsFragment.this.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            if (view.getId() == R.id.game_activity_egg_layout && com.baidu.adp.lib.util.l.isNetOk()) {
                TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_CLICK);
                if (FrsFragment.this.hni == null || !FrsFragment.this.hni.bWj()) {
                    String activityUrl = FrsFragment.this.hmG.getForum().getYuleData().aSP().getActivityUrl();
                    if (!StringUtils.isNull(activityUrl)) {
                        com.baidu.tbadk.browser.a.startInternalWebActivity(FrsFragment.this.getPageContext().getPageActivity(), activityUrl);
                    }
                } else {
                    FrsFragment.this.hni.bWk();
                }
            }
            if (FrsFragment.this.hni != null && view == FrsFragment.this.hni.bWq() && FrsFragment.this.hny != null && FrsFragment.this.hny.hasMore()) {
                FrsFragment.this.hni.brK();
                FrsFragment.this.bqv();
            }
            if (view != null && FrsFragment.this.hni != null && view == FrsFragment.this.hni.bWg()) {
                if (bc.checkUpIsLogin(FrsFragment.this.getContext())) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).ag("obj_locate", 2));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MessageCenterActivityConfig(FrsFragment.this.getContext())));
                } else {
                    return;
                }
            }
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (FrsFragment.this.hmG != null && FrsFragment.this.hmG.getForum() != null) {
                    if (FrsFragment.this.hni != null && view == FrsFragment.this.hni.bWe()) {
                        if (FrsFragment.this.hmG != null && FrsFragment.this.hmG.getForum() != null && !StringUtils.isNull(FrsFragment.this.hmG.getForum().getId()) && !StringUtils.isNull(FrsFragment.this.hmG.getForum().getName())) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_SHARE_CLICK).dh("fid", FrsFragment.this.hmG.getForum().getId()).ag("obj_locate", 11));
                            com.baidu.tieba.frs.f.e.a(FrsFragment.this.getPageContext(), FrsFragment.this.hmG, FrsFragment.this.hmG.getForum().getId());
                        } else {
                            return;
                        }
                    }
                    if (FrsFragment.this.hni != null && view == FrsFragment.this.hni.bWd()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12402").dh("fid", FrsFragment.this.hmG.getForum().getId()).dh("uid", TbadkCoreApplication.getCurrentAccount()).dh("fname", FrsFragment.this.hmG.getForum().getName()));
                        if (!StringUtils.isNull(FrsFragment.this.hmG.getForum().getName())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PostSearchActivityConfig(FrsFragment.this.getContext(), FrsFragment.this.hmG.getForum().getName(), FrsFragment.this.hmG.getForum().getId())));
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
        private int hoQ = 0;
        private int faG = 0;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsFragment.this.hod += i2;
            if (FrsFragment.this.hod >= FrsFragment.this.cOy * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
            if (FrsFragment.this.hnH != null) {
                FrsFragment.this.hnH.cbn();
            }
            this.hoQ = 0;
            this.faG = 0;
            if (recyclerView != null && (recyclerView instanceof BdRecyclerView)) {
                this.hoQ = ((BdRecyclerView) recyclerView).getFirstVisiblePosition();
                this.faG = ((BdRecyclerView) recyclerView).getLastVisiblePosition();
            }
            if (FrsFragment.this.hnS != null) {
                FrsFragment.this.hnS.a(recyclerView, this.hoQ, this.faG);
            }
            if (FrsFragment.this.hmG != null && FrsFragment.this.hni != null && FrsFragment.this.hni.bWm() != null) {
                FrsFragment.this.hni.bQ(this.hoQ, this.faG);
                if (FrsFragment.this.hnx != null && FrsFragment.this.hnx.rM() != null) {
                    FrsFragment.this.hnx.rM().b(FrsFragment.this.hnw);
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (FrsFragment.this.hnz != null) {
                FrsFragment.this.hnz.setScrollState(i);
            }
            if ((i == 2 || i == 1) && !FrsFragment.this.hns) {
                FrsFragment.this.hns = true;
                FrsFragment.this.hni.bWo();
            }
            if (FrsFragment.this.hnt == null && !FrsFragment.this.bVv()) {
                FrsFragment.this.hnt = new com.baidu.tbadk.n.b();
                FrsFragment.this.hnt.setSubType(1000);
            }
            if (i == 0) {
                if (FrsFragment.this.hnt != null) {
                    FrsFragment.this.hnt.bfz();
                }
                com.baidu.tieba.card.s.bLq().lT(true);
                FrsFragment.this.mJ(true);
                FrsFragment.this.hni.bP(this.hoQ, this.faG);
            } else if (FrsFragment.this.hnt != null) {
                FrsFragment.this.hnt.bfy();
            }
            if (FrsFragment.this.hnS != null) {
                FrsFragment.this.hnS.onScrollStateChanged(recyclerView, i);
            }
            if (i == 0) {
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.hni, FrsFragment.this.hmG, FrsFragment.this.getForumId(), false, null);
            }
            if (FrsFragment.this.hnA != null && i == 1) {
                FrsFragment.this.hnA.ccq();
            }
            if (FrsFragment.this.hnx == null) {
                if (FrsFragment.this.hni.bVQ() != null && !FrsFragment.this.hni.bVt() && FrsFragment.this.hni.bVQ().cQE() != null && (FrsFragment.this.hni.bVQ().cQE().getTag() instanceof com.baidu.card.ag)) {
                    FrsFragment.this.hnx = (com.baidu.card.ag) FrsFragment.this.hni.bVQ().cQE().getTag();
                }
            } else if (i == 0 && FrsFragment.this.hni.bVQ() != null && !FrsFragment.this.hni.bVt() && FrsFragment.this.hni.bVQ().cQE() != null && (FrsFragment.this.hni.bVQ().cQE().getTag() instanceof com.baidu.card.ag)) {
                FrsFragment.this.hnx = (com.baidu.card.ag) FrsFragment.this.hni.bVQ().cQE().getTag();
            }
            if (i == 1) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921418));
            }
        }
    };
    private final d hoD = new d() { // from class: com.baidu.tieba.frs.FrsFragment.29
        @Override // com.baidu.tieba.frs.d
        public void a(int i, int i2, View view, View view2, bk bkVar) {
            if (i != FrsFragment.this.hni.bWm().bYp()) {
                if (i != FrsFragment.this.hni.bWm().bYq()) {
                    if (i == FrsFragment.this.hni.bWm().bYn() && FrsFragment.this.hmG != null && FrsFragment.this.hmG.getUserData() != null && FrsFragment.this.hmG.getUserData().isBawu()) {
                        String bawuCenterUrl = FrsFragment.this.hmG.getBawuCenterUrl();
                        if (!com.baidu.tbadk.core.util.aq.isEmpty(bawuCenterUrl) && FrsFragment.this.hmG.getForum() != null) {
                            com.baidu.tbadk.browser.a.startWebActivity(FrsFragment.this.getPageContext().getPageActivity(), bawuCenterUrl);
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10502").dh("fid", FrsFragment.this.hmG.getForum().getId()).dh("uid", FrsFragment.this.hmG.getUserData().getUserId()));
                        }
                    }
                } else if (bc.checkUpIsLogin(FrsFragment.this.getPageContext().getPageActivity())) {
                    TiebaStatic.log(CommonStatisticKey.MY_SERVICE_CK);
                    if (FrsFragment.this.hmG != null && FrsFragment.this.hmG.getForum() != null) {
                        ForumData forum = FrsFragment.this.hmG.getForum();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(forum.getId(), 0L), forum.getName(), forum.getImage_url(), 0)));
                    }
                }
            } else if (bc.checkUpIsLogin(FrsFragment.this.getActivity())) {
                TiebaStatic.log("forum_fortune_click");
                com.baidu.tieba.frs.f.i.b(FrsFragment.this.getPageContext(), FrsFragment.this.hmG);
            }
        }
    };
    private final NoNetworkView.a hkE = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.FrsFragment.30
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (FrsFragment.this.hny.caq() == 1 && z && !FrsFragment.this.hni.bVt()) {
                if (FrsFragment.this.hmG == null || com.baidu.tbadk.core.util.v.isEmpty(FrsFragment.this.hmG.getThreadList())) {
                    FrsFragment.this.hideNetRefreshView(FrsFragment.this.hni.bIL());
                    FrsFragment.this.showLoadingView(FrsFragment.this.hni.bIL(), true);
                    FrsFragment.this.hni.mT(false);
                    FrsFragment.this.refresh();
                    return;
                }
                FrsFragment.this.hni.bVZ();
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
                com.baidu.tieba.frs.f.c.a(customResponsedMessage, FrsFragment.this.hni, FrsFragment.this.hmG);
            }
        }
    };
    private com.baidu.adp.widget.ListView.x hoE = new a();
    private ao hoF = new ao() { // from class: com.baidu.tieba.frs.FrsFragment.33
        @Override // com.baidu.tieba.frs.ao
        public void a(int i, int i2, av avVar, ArrayList<com.baidu.adp.widget.ListView.o> arrayList) {
            com.baidu.adp.lib.f.e.ld().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.33.1
                @Override // java.lang.Runnable
                public void run() {
                    if (FrsFragment.this.hni != null && FrsFragment.this.hni.bWr()) {
                        FrsFragment.this.bqv();
                    }
                }
            });
        }
    };
    private CustomMessageListener hoG = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.frs.FrsFragment.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    FrsFragment.this.hnT = true;
                }
            }
        }
    };
    private CustomMessageListener hoH = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.frs.FrsFragment.36
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                    if (FrsFragment.this.hnx == null && FrsFragment.this.hni.bVQ() != null && !FrsFragment.this.hni.bVt() && FrsFragment.this.hni.bVQ().cQE() != null && (FrsFragment.this.hni.bVQ().cQE().getTag() instanceof com.baidu.card.ag)) {
                        FrsFragment.this.hnx = (com.baidu.card.ag) FrsFragment.this.hni.bVQ().cQE().getTag();
                    }
                    if (FrsFragment.this.hnx != null && FrsFragment.this.hnx.rM() != null) {
                        FrsFragment.this.hnx.rM().b(new a.C0097a(3));
                    }
                }
            }
        }
    };
    private CustomMessageListener hoI = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.FrsFragment.37
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.hni != null) {
                FrsFragment.this.hni.ya();
            }
        }
    };
    private CustomMessageListener hoJ = new CustomMessageListener(2921437) { // from class: com.baidu.tieba.frs.FrsFragment.38
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && FrsFragment.this.isResumed()) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (FrsFragment.this.hnk != null) {
                    if (booleanValue) {
                        if (FrsFragment.this.hnA.ccr() != 0 && !FrsFragment.this.hni.bWw()) {
                            FrsFragment.this.hnk.show();
                            return;
                        }
                        return;
                    }
                    FrsFragment.this.hnk.hide();
                }
            }
        }
    };
    private CustomMessageListener hoK = new CustomMessageListener(2001223) { // from class: com.baidu.tieba.frs.FrsFragment.39
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Date)) {
                FrsFragment.this.hoc = (Date) customResponsedMessage.getData();
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.frs.loadmore.a
    public /* bridge */ /* synthetic */ com.baidu.adp.base.e getPageContext() {
        return super.getPageContext();
    }

    public com.baidu.tieba.frs.entelechy.b.b bUI() {
        return this.hnG;
    }

    public com.baidu.adp.widget.ListView.x bUJ() {
        return this.hoE;
    }

    public com.baidu.tieba.frs.mc.d bUK() {
        return this.hnI;
    }

    public com.baidu.tieba.frs.smartsort.a bUL() {
        return this.hnC;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public FrsModelController bUM() {
        return this.hny;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public com.baidu.tieba.frs.mc.c bUN() {
        return this.hnJ;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public com.baidu.tieba.frs.vc.h bUO() {
        return this.hnz;
    }

    public FrsTabViewController bUP() {
        return this.hnA;
    }

    public aq bUQ() {
        return this.hnE;
    }

    public void mI(boolean z) {
        this.hob = z;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public n bUR() {
        return this.hni;
    }

    @Override // com.baidu.tieba.frs.ap
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.ap, com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.hna;
    }

    public void setForumName(String str) {
        this.hna = str;
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
        if (this.hnJ == null) {
            return 1;
        }
        return this.hnJ.getPn();
    }

    public int getPn() {
        if (this.hnJ == null) {
            return 1;
        }
        return this.hnJ.getPn();
    }

    public void setPn(int i) {
        if (this.hnJ != null) {
            this.hnJ.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.hnJ != null) {
            this.hnJ.setHasMore(i);
        }
    }

    public int bUS() {
        if (this.hnJ == null) {
            return -1;
        }
        return this.hnJ.bUS();
    }

    public boolean bUT() {
        return this.hng;
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
            this.hni.bVT();
            showNetRefreshView(this.hni.bIL(), string, true);
        } else if (340001 == fVar.errorCode) {
            a(fVar, this.hmG.getRecm_forum_list());
        } else {
            if (com.baidu.tbadk.core.util.v.isEmpty(this.hmG.getThreadList())) {
                b(fVar);
            }
            if (bVv()) {
                setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds280));
            } else {
                setNetRefreshViewEmotionDefMarginTop();
            }
        }
    }

    public void a(View view, String str, boolean z, List<RecmForumInfo> list) {
        this.hni.bVT();
        this.hni.tQ(8);
        if (this.hnR == null) {
            this.hnR = new com.baidu.tieba.frs.view.a(getPageContext(), getNetRefreshListener());
        }
        this.hnR.setSubText(str);
        this.hnR.cB(list);
        this.hnR.attachView(view, z);
    }

    private void a(com.baidu.tieba.tbadkCore.f fVar, List<RecmForumInfo> list) {
        if (this.hni != null) {
            this.hni.bVT();
            this.hni.setTitle(this.hna);
            a(this.hni.bIL(), fVar.errorMsg, true, list);
        }
    }

    private void b(com.baidu.tieba.tbadkCore.f fVar) {
        this.hni.bVT();
        if (fVar.gXl) {
            showNetRefreshView(this.hni.bIL(), TbadkCoreApplication.getInst().getString(R.string.net_error_text, new Object[]{fVar.errorMsg, Integer.valueOf(fVar.errorCode)}), true);
        } else {
            showNetRefreshView(this.hni.bIL(), fVar.errorMsg, true);
        }
    }

    public void bUU() {
        hideLoadingView(this.hni.bIL());
        this.hni.bqV();
        if (this.hni.bVR() instanceof com.baidu.tieba.frs.tab.c) {
            ((com.baidu.tieba.frs.tab.c) this.hni.bVR()).caU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUV() {
        if (bUS() == 0 && com.baidu.tbadk.core.util.v.isEmpty(this.hmG.getThreadListIds())) {
            if (com.baidu.tbadk.core.util.v.isEmpty(this.hmG.getThreadList())) {
                this.hni.brM();
            } else {
                this.hni.brL();
            }
        } else if (com.baidu.tbadk.core.util.v.getCount(this.hmG.getThreadList()) > 3) {
            this.hni.brK();
        } else {
            this.hni.bWp();
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
            bUU();
            this.hni.bVZ();
            com.baidu.tieba.tbadkCore.f cam = this.hny.cam();
            boolean isEmpty = com.baidu.tbadk.core.util.v.isEmpty(this.hmG.getThreadList());
            if (cam != null && isEmpty) {
                if (this.hny.cao() != 0) {
                    this.hny.cat();
                    this.hni.bVZ();
                } else {
                    a(cam);
                }
                this.hni.P(this.hmG.isStarForum(), false);
                return;
            }
            a(cam);
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

    public boolean bUW() {
        return bUX() && !bUY();
    }

    private boolean bUX() {
        if (bVs() == null) {
            return false;
        }
        FrsViewData bVs = bVs();
        com.baidu.tbadk.core.data.s sVar = null;
        if (bVs.getStar() != null && !StringUtils.isNull(bVs.getStar().dcI())) {
            sVar = new com.baidu.tbadk.core.data.s();
        } else if (bVs.getActivityHeadData() != null && com.baidu.tbadk.core.util.v.getCount(bVs.getActivityHeadData().aOG()) >= 1) {
            sVar = bVs.getActivityHeadData().aOG().get(0);
        }
        return sVar != null;
    }

    public boolean bUY() {
        if (bVs() == null) {
            return false;
        }
        FrsViewData bVs = bVs();
        return (com.baidu.tbadk.core.util.v.isEmpty(bVs.getShowTopThreadList()) && bVs.getBusinessPromot() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUZ() {
        boolean b;
        if (!bVb()) {
            final PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
            privateForumPopInfoData.a(this.hmG.getPrivateForumTotalInfo().getPrivatePopInfo());
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(getActivity());
            if (this.hmG.getPrivateForumTotalInfo().aPA().private_forum_status.intValue() == 1 && (com.baidu.tbadk.core.util.aq.isEmpty(privateForumPopInfoData.aPC()) || privateForumPopInfoData.aPF() != Integer.valueOf(this.forumId))) {
                privateForumPopInfoData.vu("create_success");
                privateForumPopInfoData.vv(TbadkCoreApplication.getInst().getString(R.string.frs_private_create_hint));
                privateForumPopInfoData.vw("https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.hna + "&nomenu=1");
                privateForumPopInfoData.h(Integer.valueOf(this.forumId));
                b = frsPrivateCommonDialogView.b(privateForumPopInfoData);
            } else {
                b = privateForumPopInfoData.aPF() == Integer.valueOf(this.forumId) ? frsPrivateCommonDialogView.b(privateForumPopInfoData) : false;
            }
            if (b) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
                aVar.kG(2);
                aVar.aP(frsPrivateCommonDialogView);
                aVar.gX(false);
                frsPrivateCommonDialogView.setConfirmButton(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.11
                    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.frs.FrsFragment */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ba.aUZ().b(FrsFragment.this.getPageContext(), new String[]{privateForumPopInfoData.aPE()});
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
    public void bVa() {
        if (bVb() || this.hmG.getPrivateForumTotalInfo().aPA().private_forum_status.intValue() != 1) {
            a((Integer) null, (Integer) null, true);
        } else {
            a(this.hmG.getPrivateForumTotalInfo().aPA().private_forum_audit_status, this.hmG.getPrivateForumTotalInfo().aPB(), false);
        }
    }

    public void a(Integer num, Integer num2, boolean z) {
        final String str;
        final int i = 2;
        if (this.hni.bWf() != null) {
            TextView bWf = this.hni.bWf();
            if (z) {
                bWf.setVisibility(8);
                return;
            }
            if (num.intValue() == 2) {
                bWf.setText("修改实名认证信息");
                bWf.setVisibility(0);
                str = "https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + this.forumId + "&nomenu=1";
            } else if (num2.intValue() >= 0 && num2.intValue() <= 100) {
                bWf.setText("目标已完成" + String.valueOf(num2) + "%");
                bWf.setVisibility(0);
                str = "https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.hna + "&nomenu=1";
                i = 1;
            } else {
                bWf.setVisibility(8);
                i = 0;
                str = "";
            }
            bWf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.14
                /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13387").dh("fid", FrsFragment.this.forumId).dh("uid", TbadkCoreApplication.getCurrentAccount()).ag("obj_type", i));
                    ba.aUZ().b(FrsFragment.this.getPageContext(), new String[]{str});
                }
            });
        }
    }

    private boolean bVb() {
        return this.hmG == null || this.hmG.getPrivateForumTotalInfo() == null || this.hmG.getPrivateForumTotalInfo().aPA() == null || this.hmG.getUserData().getIs_manager() != 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVc() {
        boolean z;
        boolean z2;
        if (this.hmG == null || this.hmG.getEntelechyTabInfo() == null || this.hmG.getEntelechyTabInfo().tab == null) {
            z = false;
        } else {
            z = false;
            for (FrsTabInfo frsTabInfo : this.hmG.getEntelechyTabInfo().tab) {
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
    public void tG(int i) {
        List<WindowToast> list;
        if (TbadkCoreApplication.isLogin() && this.hmG != null && (list = this.hmG.mWindowToast) != null && list.size() > 0) {
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
    public void bVd() {
        if (this.hmG == null || this.hmG.getForum() != null) {
            this.hni.bWl();
        } else if (this.hmG.getForum().getYuleData() != null && this.hmG.getForum().getYuleData().aSO()) {
            TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_VIEW);
            this.hni.a(this.hmG.getForum().getYuleData().aSP());
        } else {
            this.hni.bWl();
        }
    }

    private void N(boolean z, boolean z2) {
        if (this.hny != null && this.hmG != null && this.hni != null && z) {
            if (!this.hny.caA() && this.hny.caq() == 1) {
                if (!this.hny.cay()) {
                    this.hmG.addCardVideoInfoToThreadList();
                    this.hmG.addVideoInfoToThreadListInTenAndFifteenFloor();
                }
                boolean z3 = false;
                if (this.hni.bWm().r(com.baidu.tieba.card.data.n.gHP)) {
                    z3 = this.hmG.addHotTopicDataToThreadList();
                }
                if (!z3) {
                    this.hmG.addFeedForumDataToThreadList();
                }
                if (TbadkCoreApplication.getInst().isRecAppExist()) {
                    this.hmG.addRecommendAppToThreadList(this);
                }
                if (!this.hni.bWm().r(bk.dEW)) {
                    this.hmG.removeAlaLiveThreadData();
                }
                this.hmG.addSchoolRecommendToThreadList();
            }
            if (!this.hni.bWm().r(bk.dEW)) {
                this.hmG.removeAlaInsertLiveData();
                this.hmG.removeAlaStageLiveDat();
            } else {
                this.hmG.addInsertLiveDataToThreadList();
                this.hmG.addStageLiveDataToThreadList();
            }
            this.hmG.checkLiveStageInThreadList();
            this.hmG.addNoticeThreadToThreadList();
            if (this.hni.bWm().r(com.baidu.tieba.h.b.hRz)) {
                this.hmG.addGameRankListToThreadList(z2);
            }
            if (TbadkCoreApplication.isLogin() && (!this.hny.caA() || this.hny.isNetFirstLoad)) {
                this.hmG.addUserRecommendToThreadList();
            }
            this.hmG.addVideoActivityToTop();
        }
    }

    public boolean bVe() {
        if (this.hnz != null && this.hny != null) {
            this.hnz.a(this.hny.getPageType(), this.hmG);
        }
        boolean z = false;
        if (this.hmG != null) {
            z = this.hmG.hasTab();
        }
        bVg();
        if (this.hni != null) {
            this.hni.bWx();
            this.hni.bWy();
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tH(int i) {
        as asVar = null;
        bVe();
        bVn();
        try {
            if (this.hmG != null) {
                this.hni.a((ArrayList<com.baidu.adp.widget.ListView.o>) null, this.hmG);
                this.hnz.vt(1);
                this.hni.bWc();
                this.hnA.a(this.hmG, this.hny.cav());
                com.baidu.tieba.frs.tab.d vC = this.hnA.vC(this.hmG.getFrsDefaultTabId());
                if (vC != null && !TextUtils.isEmpty(vC.url)) {
                    asVar = new as();
                    asVar.ext = vC.url;
                    asVar.stType = vC.name;
                }
                this.hny.a(this.hmG.getFrsDefaultTabId(), 0, asVar);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(boolean z, boolean z2) {
        try {
            if (this.hmG != null && this.hnA != null && this.hny != null) {
                if (!this.hni.bWm().r(bk.dEW)) {
                    this.hmG.removeAlaLiveThreadData();
                }
                boolean isEmpty = com.baidu.tbadk.core.util.v.isEmpty(this.hmG.getGameTabInfo());
                this.hni.mR(isEmpty);
                if (!isEmpty) {
                    if (this.hnS == null) {
                        this.hnS = new com.baidu.tieba.frs.vc.e(this, (NoPressedRelativeLayout) this.mRootView);
                    }
                    if (this.fuV == null) {
                        this.fuV = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
                    }
                } else {
                    this.hnS = null;
                    this.fuV = null;
                }
                if (this.hmG.getForum() != null) {
                    this.hna = this.hmG.getForum().getName();
                    this.forumId = this.hmG.getForum().getId();
                }
                if (this.hmG.hasTab()) {
                    this.hnA.a(this.hmG, this.hny.cav());
                }
                if (z) {
                    N(true, z);
                } else {
                    N(this.hnu, z);
                }
                bVe();
                if (this.hnG != null) {
                    this.hnG.a(this.hnz, this.hmG);
                }
                if (this.hmG.getPage() != null) {
                    setHasMore(this.hmG.getPage().aPt());
                }
                ArrayList<com.baidu.adp.widget.ListView.o> a2 = this.hnJ.a(z2, true, this.hmG.getThreadList(), null, z, false);
                if (a2 != null) {
                    this.hmG.setThreadList(a2);
                }
                this.hmG.removeRedundantUserRecommendData();
                this.hmI = this.hmG.getTopThreadSize();
                if (this.hne != null) {
                    this.hnd = true;
                    this.hne.DO(this.hmI);
                    com.baidu.tieba.frs.f.a.a(this, this.hmG.getForum(), this.hmG.getThreadList(), this.hnd, getPn());
                }
                if (this.hny.caq() == 1) {
                    bVk();
                    if (!z && this.hny.getPn() == 1) {
                        bVf();
                    }
                }
                if (this.hnH != null) {
                    this.hnH.cd(this.hnA.ccn());
                }
                bUU();
                this.hni.bVU();
                this.hni.P(true, false);
                if (z && this.hmG.isFirstTabEqualAllThread()) {
                    com.baidu.adp.lib.f.e.ld().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.15
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!FrsFragment.this.hnr && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                FrsFragment.this.hni.bWv();
                            }
                        }
                    });
                }
                if (this.hmG.getForum() != null) {
                    this.hni.ED(this.hmG.getForum().getWarningMsg());
                }
                if (this.hmG != null && this.hmG.getFrsVideoActivityData() != null && com.baidu.tbadk.core.sharedPref.b.aTX().getLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 0L) == 0) {
                    com.baidu.adp.lib.f.e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.16
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsFragment.this.hni.bWt();
                        }
                    }, 1000L);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FRS_SHOW_AR_ENTRY, this));
                this.hni.bVO();
                if (this.hmG != null && this.hmG.getForum() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ENTER_FORUM, new VisitedForumData(this.hmG.getForum().getId(), this.hmG.getForum().getName(), this.hmG.getForum().getImage_url(), String.valueOf(System.currentTimeMillis() / 1000), ConstantData.Forum.SPECAIL_FORUM_TYPE_LIVE.equals(this.hmG.getForum().special_forum_type), this.hmG.getForum().getThemeColorInfo(), this.hmG.getForum().getMember_num())));
                }
                this.hnW.a(this.hmG.bottomMenuList, this.hmG.getForum());
                bVC();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void mJ(boolean z) {
        com.baidu.tieba.s.c.dct().b(getUniqueId(), z);
    }

    public void bVf() {
        if (this.hnM == null) {
            this.hnM = new com.baidu.tieba.frs.live.a(this, com.baidu.adp.lib.f.b.toInt(this.forumId, 0));
        }
        this.hnM.bZX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.tbadkCore.m mVar) {
        try {
            if (!this.hnr && mVar != null && this.hmG != null) {
                this.hmG.receiveData(mVar);
                O(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void bVg() {
        if (this.hny != null) {
            EC(this.hny.getPageType());
        } else {
            EC("normal_page");
        }
    }

    private void EC(String str) {
        mK("frs_page".equals(str));
        if (this.hnG != null) {
            this.hnG.a(this.hnz, this.hni, this.hmG);
        }
    }

    public void mK(boolean z) {
        if (this.hnK != null) {
            this.hnK.ccb();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.s.c.dct().z(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.frs_activity, viewGroup, false);
            this.hmU = new com.baidu.tieba.frs.entelechy.a();
            this.hnG = this.hmU.bXT();
            this.hmT = TbadkCoreApplication.getInst().getString(R.string.frs_title_new_area);
            this.hnz = new com.baidu.tieba.frs.vc.h(this, this.hmU, (FrsHeaderViewContainer) this.mRootView.findViewById(R.id.header_view_container));
            this.hnA = new FrsTabViewController(this, this.mRootView);
            this.hnA.registerListener();
            this.hnz.a(this.hnA);
            this.hnA.a(this.hok);
            Intent intent = getActivity().getIntent();
            if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                this.hmW = true;
            }
            this.hni = new n(this, this.hoC, this.hmU, this.hmW, this.hnz);
            this.hnW = new com.baidu.tieba.frs.brand.buttommenu.a(getPageContext(), this.mRootView);
        } else {
            if (this.mRootView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            if (this.hnA != null) {
                this.hnA.registerListener();
            }
            this.hni.bWs();
            this.mRootView.setLeft(0);
            this.mRootView.setRight(com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getContext()));
        }
        this.hoa = true;
        this.erX = System.currentTimeMillis() - currentTimeMillis;
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        ArrayList<com.baidu.adp.widget.ListView.o> arrayList = null;
        this.gPK = System.currentTimeMillis();
        long j = this.gPK;
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.hnf = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.gPK = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            R(intent);
        }
        this.erW = j - this.gPK;
        this.hne = new com.baidu.tieba.tbadkCore.data.f("frs", com.baidu.tieba.tbadkCore.data.f.lkh);
        if (this.hny == null) {
            this.hny = new FrsModelController(this, this.hox);
            this.hny.a(this.hoj);
            this.hny.init();
        }
        this.hny.setSchemeUrl(this.mSchemeUrl);
        if (intent != null) {
            this.hny.aj(intent.getExtras());
        } else if (bundle != null) {
            this.hny.aj(bundle);
        } else {
            this.hny.aj(null);
        }
        if (intent != null) {
            this.hnz.ap(intent.getExtras());
        } else if (bundle != null) {
            this.hnz.ap(bundle);
        } else {
            this.hnz.ap(null);
        }
        this.hnh = getVoiceManager();
        this.hnN = new m(getPageContext(), this);
        initUI();
        initData(bundle);
        if (!bVv()) {
            this.hnE = new aq(getActivity(), this.hni, this.hnz);
            this.hnE.ng(true);
        }
        this.hnh = getVoiceManager();
        if (this.hnh != null) {
            this.hnh.onCreate(getPageContext());
        }
        new com.baidu.tieba.frs.mc.i();
        int i = -1;
        if (this.hnJ != null && this.hnJ.cai() != null) {
            i = this.hnJ.cai().bUS();
            arrayList = this.hnJ.cai().getDataList();
        }
        this.hnJ = new com.baidu.tieba.frs.mc.c(this, this.hoA);
        this.hnJ.cai().setHasMore(i);
        if (arrayList != null && arrayList.size() > 0) {
            this.hnJ.cai().av(arrayList);
        }
        this.hnC = new com.baidu.tieba.frs.smartsort.a(this);
        this.hnK = new com.baidu.tieba.frs.vc.j(this);
        this.hnH = new com.baidu.tieba.frs.vc.a(getPageContext(), this.hny.cax());
        this.hnD = new com.baidu.tieba.frs.mc.b(this);
        this.hnI = new com.baidu.tieba.frs.mc.d(this);
        this.hnB = new com.baidu.tieba.frs.mc.h(this);
        this.hnL = new com.baidu.tieba.frs.mc.a(this);
        this.hnO = new com.baidu.tieba.frs.vc.c(this);
        this.hnP = new com.baidu.tieba.frs.mc.e(this, getUniqueId());
        this.hnU = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "frs");
        this.hnV = new com.baidu.tieba.ala.a(getPageContext());
        this.hnX = new com.baidu.tieba.frs.sportspage.notification.a(getPageContext());
        registerListener(this.hor);
        registerListener(this.mMemListener);
        registerListener(this.hop);
        registerListener(this.hoB);
        registerListener(this.hoy);
        registerListener(this.hom);
        registerListener(this.hon);
        registerListener(this.hoo);
        registerListener(this.hog);
        registerListener(this.hoh);
        registerListener(this.aei);
        registerListener(this.hoG);
        registerListener(this.hot);
        registerListener(this.hoi);
        registerListener(this.hou);
        registerListener(this.hos);
        registerListener(this.hov);
        registerListener(this.how);
        this.hoH.setTag(getPageContext().getUniqueId());
        MessageManager.getInstance().registerListener(this.hoH);
        registerListener(this.hoI);
        registerListener(this.hoJ);
        registerListener(this.hoK);
        this.hni.mT(false);
        if (!bVv() && !this.hasInit) {
            showLoadingView(this.hni.bIL(), true);
            this.hny.M(3, false);
        }
        com.baidu.tieba.frs.a.bTX().a(new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.19
            @Override // com.baidu.tieba.frs.a.b
            public void M(boolean z, boolean z2) {
                if (FrsFragment.this.hni != null) {
                    FrsFragment.this.hni.tR(z ? 0 : 8);
                    if (!z2) {
                        FrsFragment.this.hnZ = z;
                    }
                    if (FrsFragment.this.hni.bWm() != null && FrsFragment.this.hny != null && FrsFragment.this.hny.car()) {
                        FrsFragment.this.hni.bWm().notifyDataSetChanged();
                    }
                    if (FrsFragment.this.bUP() != null) {
                        FrsTabViewController.b cco = FrsFragment.this.bUP().cco();
                        if (cco != null && cco.tabId == 502 && (cco.fragment instanceof FrsCommonTabFragment)) {
                            ((FrsCommonTabFragment) cco.fragment).bXL();
                        } else if (cco != null && cco.tabId == 503 && (cco.fragment instanceof FrsNewAreaFragment)) {
                            FrsNewAreaFragment frsNewAreaFragment = (FrsNewAreaFragment) cco.fragment;
                            frsNewAreaFragment.bXL();
                            if (frsNewAreaFragment.caE() != null) {
                                com.baidu.tieba.frs.mc.g caE = frsNewAreaFragment.caE();
                                caE.ni(!z);
                                caE.mW(!z);
                            }
                        }
                        if (FrsFragment.this.bUP().ccg() != null) {
                            FrsFragment.this.bUP().ccg().setmDisallowSlip(z);
                            FrsFragment.this.bUP().nM(z);
                        }
                    }
                    if (FrsFragment.this.hni.bVS() != null) {
                        FrsFragment.this.hni.mQ(!z);
                    }
                    if (FrsFragment.this.getActivity() instanceof FrsActivity) {
                        ((FrsActivity) FrsFragment.this.getActivity()).mH(!z);
                    }
                    if (FrsFragment.this.hnW != null) {
                        FrsFragment.this.hnW.no(!z);
                    }
                    FrsFragment.this.hni.mV(!z);
                    FrsFragment.this.hni.mW(z ? false : true);
                }
            }

            @Override // com.baidu.tieba.frs.a.b
            public void tD(int i2) {
                if (FrsFragment.this.hni != null) {
                    FrsFragment.this.hni.tS(i2);
                }
            }

            @Override // com.baidu.tieba.frs.a.b
            public void bUd() {
                com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getContext(), (int) R.string.frs_multi_delete_max_num);
            }
        });
        this.hni.b(new d.a() { // from class: com.baidu.tieba.frs.FrsFragment.20
            @Override // com.baidu.tieba.NEGFeedBack.d.a
            public void a(DeleteThreadHttpResponseMessage deleteThreadHttpResponseMessage) {
                boolean z;
                int i2 = 0;
                if (deleteThreadHttpResponseMessage != null) {
                    FrsFragment.this.hni.bkO();
                    FrsFragment.this.hni.bWu();
                    FrsNewAreaFragment frsNewAreaFragment = null;
                    if (FrsFragment.this.hnA == null || FrsFragment.this.hnA.cco() == null || !(FrsFragment.this.hnA.cco().fragment instanceof FrsNewAreaFragment)) {
                        z = false;
                    } else {
                        frsNewAreaFragment = (FrsNewAreaFragment) FrsFragment.this.hnA.cco().fragment;
                        z = true;
                    }
                    if (deleteThreadHttpResponseMessage.getError() == 0) {
                        String text = !TextUtils.isEmpty(deleteThreadHttpResponseMessage.getText()) ? deleteThreadHttpResponseMessage.getText() : FrsFragment.this.getString(R.string.delete_fail);
                        if (deleteThreadHttpResponseMessage.getRetType() == 1211066) {
                            if (FrsFragment.this.gGm == null) {
                                FrsFragment.this.gGm = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.gGm.vO(text);
                            FrsFragment.this.gGm.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.20.1
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.gGm.gX(false);
                            FrsFragment.this.gGm.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.gGm.aST();
                        } else if (deleteThreadHttpResponseMessage.getRetType() == 1211067) {
                            if (FrsFragment.this.gGm == null) {
                                FrsFragment.this.gGm = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.gGm.vO(text);
                            FrsFragment.this.gGm.a(R.string.know, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.20.2
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.gGm.gX(false);
                            FrsFragment.this.gGm.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.gGm.aST();
                        } else {
                            FrsFragment.this.hni.aK(deleteThreadHttpResponseMessage.getText(), ContextCompat.getColor(FrsFragment.this.getContext(), deleteThreadHttpResponseMessage.getRetType() == 1 ? R.color.nav_bar_tip_error : R.color.cp_link_tip_a_alpha95));
                        }
                        if (z && frsNewAreaFragment != null) {
                            frsNewAreaFragment.cx(deleteThreadHttpResponseMessage.getSuccessItems());
                        }
                        FrsFragment.this.cm(deleteThreadHttpResponseMessage.getSuccessItems());
                        com.baidu.tieba.frs.a.bTX().cl(deleteThreadHttpResponseMessage.getSuccessItems());
                        for (com.baidu.adp.widget.ListView.o oVar : FrsFragment.this.hmG.getThreadList()) {
                            if (oVar instanceof bj) {
                                i2++;
                                continue;
                            }
                            if (i2 >= 6) {
                                break;
                            }
                        }
                        if (i2 < 6) {
                            FrsFragment.this.bqv();
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
        tI(1);
        super.onActivityCreated(bundle);
        this.createTime = System.currentTimeMillis() - j;
    }

    public void mL(boolean z) {
        if (this.hnA != null) {
            this.hnA.hNc = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cm(List<String> list) {
        if (!com.baidu.tbadk.core.util.v.isEmpty(list)) {
            ArrayList<com.baidu.adp.widget.ListView.o> threadList = this.hmG.getThreadList();
            if (!com.baidu.tbadk.core.util.v.isEmpty(threadList) && this.hni.getListView() != null && this.hni.getListView().getData() != null) {
                Iterator<com.baidu.adp.widget.ListView.o> it = threadList.iterator();
                List<com.baidu.adp.widget.ListView.o> data = this.hni.getListView().getData();
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
                                this.hnJ.d(next);
                                this.hni.getListView().getAdapter().notifyItemRemoved(i);
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
    public void bqQ() {
        if (isAdded() && this.feJ && !isLoadingViewAttached()) {
            showLoadingView(this.hni.bIL(), true);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void bqR() {
        if (isAdded() && this.feJ && isLoadingViewAttached()) {
            hideLoadingView(this.hni.bIL());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (bVv()) {
            showLoadingView(this.hni.bIL(), true);
            this.hni.tT(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.hny.M(3, true);
            aWN().scrollToPosition(0);
        }
    }

    private void tI(int i) {
        String str = "";
        if (this.hmG != null && this.hmG.getForum() != null) {
            str = this.hmG.getForum().getId();
        }
        if (!StringUtils.isNull(str)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13008").dh("fid", str).dh("obj_type", "4").ag("obj_locate", i).dh("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.aa aaVar) {
        if (aaVar != null) {
            this.evv = aaVar.bgL();
            this.hnQ = aaVar.bgM();
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
                this.hna = uri.getQueryParameter("name");
                this.mFrom = uri.getQueryParameter("from");
                if (!StringUtils.isNull(this.hna)) {
                    intent.putExtra("name", this.hna);
                }
                if (!StringUtils.isNull(this.mFrom)) {
                    intent.putExtra("from", this.mFrom);
                }
                TiebaStatic.log(TbadkCoreStatisticKey.AS_INVOKE_TIEBA);
            }
            if (StringUtils.isNull(this.hna) && uri != null) {
                if (com.baidu.tbadk.BdToken.f.p(uri)) {
                    com.baidu.tbadk.BdToken.f.aLw().b(uri, this.hoz);
                } else {
                    com.baidu.tieba.frs.f.d U = com.baidu.tieba.frs.f.i.U(intent);
                    if (U != null) {
                        this.hna = U.forumName;
                        if (U.hKG == null || U.hKG.equals("aidou")) {
                        }
                    }
                }
                if (!StringUtils.isNull(this.hna)) {
                    intent.putExtra("name", this.hna);
                }
                intent.putExtra(FrsActivityConfig.FRS_CALL_FROM, 12);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.hnh = getVoiceManager();
        if (this.hnh != null) {
            this.hnh.onStart(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        Intent intent;
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.edg);
        if (bundle != null) {
            this.hna = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
            this.hna = intent.getStringExtra("name");
            this.mFrom = intent.getStringExtra("from");
            this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
        }
        if (getArguments() != null) {
            this.hnb = getArguments().getBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, false);
        }
        if (TextUtils.isEmpty(this.mFrom) || FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
        }
        if (this.mIsLogin) {
            registerListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL, this.edg);
        }
        this.hnz.ap(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.s.c.dct().A(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.hoG);
        hnl = null;
        if (this.hnh != null) {
            this.hnh.onDestory(getPageContext());
        }
        com.baidu.tieba.recapp.report.a.remove("FRS");
        this.hnh = null;
        com.baidu.tieba.card.s.bLq().lT(false);
        if (this.hmG != null && this.hmG.getForum() != null) {
            af.bWR().ef(com.baidu.adp.lib.f.b.toLong(this.hmG.getForum().getId(), 0L));
        }
        if (this.hnM != null) {
            this.hnM.onDestory();
        }
        if (this.hni != null) {
            com.baidu.tieba.frs.f.h.a(this.hni, this.hmG, getForumId(), false, null);
            this.hni.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.hnt != null) {
                this.hnt.bfA();
            }
            if (this.hni != null) {
                this.hni.release();
            }
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.hnz.bZP();
        if (this.hny != null) {
            this.hny.bwi();
        }
        if (this.hnE != null) {
            this.hnE.bld();
        }
        if (this.hnH != null) {
            this.hnH.destory();
        }
        if (this.hnC != null) {
            this.hnC.onDestroy();
        }
        if (this.hnS != null) {
            this.hnS.onDestory();
        }
        if (this.hnL != null) {
            this.hnL.onDestroy();
        }
        if (this.hnU != null) {
            this.hnU.onDestroy();
        }
        if (this.hnV != null) {
            this.hnV.onDestroy();
        }
        com.baidu.tieba.recapp.d.a.cUZ().cVb();
        com.baidu.tieba.frs.f.j.cbk();
        if (this.hnA != null) {
            this.hnA.a((FrsTabViewController.a) null);
            this.hnA.ccq();
        }
        if (this.hnY != null) {
            this.hnY.onDestroy();
        }
        com.baidu.tieba.frs.a.bTX().a(null);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.hna);
        bundle.putString("from", this.mFrom);
        this.hny.onSaveInstanceState(bundle);
        if (this.hnh != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            this.hnh.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.hnL != null) {
            this.hnL.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.hni != null) {
            this.hni.bVZ();
            this.hni.onResume();
        }
        this.hnB.nE(true);
        this.hnu = true;
        if (hmZ) {
            hmZ = false;
            if (this.hni != null) {
                this.hni.startPullRefresh();
                return;
            }
            return;
        }
        if (this.hnh != null) {
            this.hnh.onResume(getPageContext());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_RESUME));
        if (this.hni != null) {
            this.hni.mX(false);
        }
        if (this.hnT) {
            refresh(6);
            this.hnT = false;
        }
        if (this.hoc != null && getActivity() != null) {
            if (NotificationManagerCompat.from(getActivity()).areNotificationsEnabled()) {
                com.baidu.tbadk.coreExtra.messageCenter.f.ban().setSignAlertOn(true);
                com.baidu.tbadk.coreExtra.messageCenter.f.ban().setSignAlertTime(this.hoc.getHours(), this.hoc.getMinutes());
                com.baidu.tbadk.coreExtra.messageCenter.f.ban().a(getTbPageContext().getPageActivity(), this.hni.bIL());
            }
            this.hoc = null;
        }
        bVC();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
    }

    public boolean bVh() {
        Intent intent;
        if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
            return false;
        }
        return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
    }

    public void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.hna = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.hnc = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.hnc) {
                bVi();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVi() {
        this.hni.startPullRefresh();
    }

    public void closeActivity() {
        com.baidu.tieba.frs.f.i.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.mFrom);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.hni.setTitle(this.hna);
        } else {
            this.hni.setTitle("");
            this.mFlag = 1;
        }
        this.hni.a(this.hoE);
        this.hni.addOnScrollListener(this.mScrollListener);
        this.hni.g(this.hkE);
        this.hni.bWm().a(this.hoD);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hoa) {
            this.hni.onChangeSkinType(i);
            this.hnz.vs(i);
            this.hnA.onChangeSkinType(i);
            if (this.hnk != null) {
                this.hnk.onChangeSkinType(i);
            }
            if (this.hnR != null) {
                this.hnR.onChangeSkinType();
            }
            if (this.hnW != null) {
                this.hnW.onChangeSkinType(getPageContext(), i);
            }
            if (this.gGm != null) {
                com.baidu.tbadk.q.a.a(getPageContext(), this.gGm.getRealView());
            }
            if (this.hnS != null) {
                this.hnS.onChangeSkinType(getPageContext(), i);
            }
        }
    }

    public void tJ(int i) {
        if (!this.mIsLogin) {
            if (this.hmG != null && this.hmG.getAnti() != null) {
                this.hmG.getAnti().setIfpost(1);
            }
            if (i == 0) {
                bc.skipToLoginActivity(getActivity());
            }
        } else if (this.hmG != null) {
            if (i == 0) {
                com.baidu.tieba.frs.f.j.f(this, 0);
            } else {
                this.hni.bWb();
            }
        }
    }

    public void refresh() {
        com.baidu.tieba.a.d.blZ().zK("page_frs");
        refresh(3);
    }

    public void refresh(int i) {
        this.hnr = false;
        bVn();
        if (this.hni != null && this.hni.bVQ() != null) {
            this.hni.bVQ().cfz();
        }
        if (this.hny != null) {
            this.hny.M(i, true);
        }
    }

    private void bVj() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.f.h.le().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.26
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.MI(FrsFragment.this.hna);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVk() {
        bVn();
        try {
            if (this.hmG != null) {
                this.hni.bvM();
                this.hni.mQ(bVB());
                if (!com.baidu.tieba.frs.vc.h.l(this.hmG) || !com.baidu.tieba.frs.vc.h.k(this.hmG)) {
                }
                if (this.hmG.getForum() != null) {
                    this.hna = this.hmG.getForum().getName();
                    this.forumId = this.hmG.getForum().getId();
                }
                if (this.hmG.getPage() != null) {
                    setHasMore(this.hmG.getPage().aPt());
                }
                this.hni.setTitle(this.hna);
                this.hni.setForumName(this.hna);
                TbadkCoreApplication.getInst().setDefaultBubble(this.hmG.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.hmG.getUserData().getBimg_end_time());
                bVj();
                bVl();
                ArrayList<com.baidu.adp.widget.ListView.o> threadList = this.hmG.getThreadList();
                if (threadList != null) {
                    this.hni.a(threadList, this.hmG);
                    com.baidu.tieba.frs.f.c.A(this.hni);
                    this.hnz.vt(getPageNum());
                    this.hnz.i(this.hmG);
                    this.hnA.a(this.hmG, this.hny.cav());
                    this.hni.bWc();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void bVl() {
        if (this.hmG != null) {
            if (this.hmG.getIsNewUrl() == 1) {
                this.hni.bWm().setFromCDN(true);
            } else {
                this.hni.bWm().setFromCDN(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.hnB.nE(false);
        this.hnu = false;
        this.hni.onPause();
        if (this.hnh != null) {
            this.hnh.onPause(getPageContext());
        }
        this.hni.mX(true);
        if (this.hnH != null) {
            this.hnH.cbn();
        }
        com.baidu.tbadk.BdToken.c.aLi().aLn();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.hnA != null && this.hnA.cco() != null && (this.hnA.cco().fragment instanceof BaseFragment)) {
            ((BaseFragment) this.hnA.cco().fragment).setPrimary(z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.s.bLq().lT(false);
        mJ(false);
        if (this.hmG != null && this.hmG.getForum() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            com.baidu.tbadk.distribute.a.bcK().b(getPageContext().getPageActivity(), "frs", this.hmG.getForum().getId(), 0L);
        }
        if (this.hnh != null) {
            this.hnh.onStop(getPageContext());
        }
        if (aWN() != null) {
            aWN().getRecycledViewPool().clear();
        }
        this.hnz.aVZ();
        com.baidu.tbadk.util.ab.bgO();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            if (this.hnz != null) {
                this.hnz.bB(isPrimary());
            }
            if (this.hni != null) {
                this.hni.bB(isPrimary());
                this.hni.mX(!isPrimary());
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (com.baidu.tieba.frs.a.bTX().bTY()) {
                com.baidu.tieba.frs.a.bTX().reset();
                return true;
            } else if (this.hni != null) {
                return this.hni.bVY();
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
        com.baidu.tbadk.distribute.a.bcK().a(advertAppInfo, this.forumId, 0L, "FRS", str, getPn());
    }

    @Override // com.baidu.tieba.recapp.m
    public void bVm() {
        bUM().bVm();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.hnh == null) {
            this.hnh = VoiceManager.instance();
        }
        return this.hnh;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdRecyclerView aWN() {
        if (this.hni == null) {
            return null;
        }
        return this.hni.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void bVn() {
        if (this.hnh != null) {
            this.hnh.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> aWO() {
        if (this.dXO == null) {
            this.dXO = UserIconBox.s(getPageContext().getPageActivity(), 8);
        }
        return this.dXO;
    }

    public void bVo() {
        if (getFragmentActivity() != null && getFragmentActivity().getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.r onGetPreLoadListView() {
        return aWN().getPreLoadHandle();
    }

    @Override // com.baidu.tieba.frs.am
    public NavigationBar btY() {
        if (this.hni == null) {
            return null;
        }
        return this.hni.btY();
    }

    public FRSRefreshButton bVp() {
        return this.hnk;
    }

    public void a(FRSRefreshButton fRSRefreshButton) {
        if (fRSRefreshButton != null) {
            this.hnk = fRSRefreshButton;
            this.hnk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.32
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (FrsFragment.this.hnA != null) {
                        FrsTabViewController.b cco = FrsFragment.this.hnA.cco();
                        if (cco != null && cco.fragment != null && (cco.fragment instanceof al)) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                            ((al) cco.fragment).bUy();
                            ((al) cco.fragment).brJ();
                            return;
                        }
                        FrsFragment.this.bUR().startPullRefresh();
                    }
                }
            });
        }
    }

    public void bVq() {
        if (this.hnk != null) {
            this.hnk.hide();
        }
    }

    public void bVr() {
        if (this.hnk != null) {
            this.hnk.show();
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
                if (bdUniqueId == t.hqs) {
                    if (FrsFragment.this.hni != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11752").dh("fid", FrsFragment.this.forumId).dh("obj_locate", "1"));
                        FrsFragment.this.hni.startPullRefresh();
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
                                if (readThreadHistory != null && !readThreadHistory.MO(bkVar.getId())) {
                                    readThreadHistory.MN(bkVar.getId());
                                }
                                boolean z = false;
                                final String aQE = bkVar.aQE();
                                if (aQE != null && !aQE.equals("")) {
                                    z = true;
                                    new Thread(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.a.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(aQE);
                                            xVar.aUA().aVa().mIsNeedAddCommenParam = false;
                                            xVar.aUA().aVa().mIsUseCurrentBDUSS = false;
                                            xVar.getNetData();
                                        }
                                    }).start();
                                }
                                String tid = bkVar.getTid();
                                if (tid == null) {
                                    tid = "";
                                }
                                if (bkVar.aQs() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                    ba.aUZ().b(FrsFragment.this.getPageContext(), new String[]{tid, "", null});
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
                                com.baidu.tieba.frs.f.h.a(FrsFragment.this, FrsFragment.this.hmG, bkVar);
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
            hideNetRefreshView(this.hni.bIL());
            showLoadingView(this.hni.bIL(), true);
            this.hni.mT(false);
            this.hny.M(3, true);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData bVs() {
        return this.hmG;
    }

    public boolean bVt() {
        return this.hni.bVt();
    }

    public void az(Object obj) {
        if (this.hnD != null && this.hnD.hGa != null) {
            this.hnD.hGa.callback(obj);
        }
    }

    public void aA(Object obj) {
        if (this.hnD != null && this.hnD.hGb != null) {
            this.hnD.hGb.callback(obj);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        this.hni.getListView().stopScroll();
        if (!this.hni.bWi()) {
            if (!com.baidu.adp.lib.util.l.isNetOk()) {
                this.hni.brM();
            } else if (this.hny.caq() == 1) {
                bqK();
                bqv();
            } else if (this.hny.hasMore()) {
                bqv();
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void onFailed(String str) {
        bqK();
        showToast(str);
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void an(ArrayList<com.baidu.adp.widget.ListView.o> arrayList) {
        boolean isEmpty = com.baidu.tbadk.core.util.v.isEmpty(arrayList);
        setHasMore(isEmpty ? 0 : 1);
        bqK();
        if (!isEmpty) {
            if (!this.hny.caA() && TbadkCoreApplication.getInst().isRecAppExist() && this.hny.caq() == 1) {
                this.hmG.addRecommendAppToThreadList(this, arrayList);
            }
            if (this.hny != null) {
                com.baidu.tieba.frs.d.a.a(getUniqueId(), arrayList, this.hmG.getForum(), this.hny.getSortType());
            }
            ArrayList<com.baidu.adp.widget.ListView.o> a2 = this.hnJ.a(false, false, arrayList, this.hne, false);
            if (a2 != null) {
                this.hmG.setThreadList(a2);
                this.hni.a(a2, this.hmG);
            }
            if (this.hny != null) {
                com.baidu.tieba.frs.d.c.a(this.hmG, this.hny.cav(), 2, getContext());
            }
        }
    }

    private void bqK() {
        if (bUS() == 1 || this.hnJ.cw(this.hmG.getThreadListIds())) {
            if (com.baidu.tbadk.core.util.v.getCount(this.hmG.getThreadList()) > 3) {
                this.hni.brK();
            } else {
                this.hni.bWp();
            }
        } else if (com.baidu.tbadk.core.util.v.isEmpty(this.hmG.getThreadList())) {
            this.hni.brM();
        } else {
            this.hni.brL();
        }
    }

    @Override // com.baidu.tieba.frs.mc.l
    public void bqv() {
        if (this.hnJ != null) {
            this.hnJ.a(this.hna, this.forumId, this.hmG);
        }
    }

    public void bVu() {
        if (!com.baidu.tbadk.core.util.ab.requestWriteExternalStorgeAndCameraPermission(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.al.d(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment, com.baidu.h.a.a.InterfaceC0125a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        com.baidu.tieba.frs.f.i.a(this, i, strArr, iArr);
    }

    public void mM(boolean z) {
        if (this.hnE != null) {
            this.hnE.ng(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.hnF.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a oM(int i) {
        return this.hnF.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        this.hnN.b(bVar);
    }

    public boolean bVv() {
        return this.hmW;
    }

    @Override // com.baidu.tieba.frs.aj
    public void Ho() {
        if (this.hni != null) {
            showFloatingView();
            this.hni.getListView().scrollToPosition(0);
            this.hni.startPullRefresh();
        }
    }

    public ForumWriteData bVw() {
        if (this.hmG == null || this.hmG.getForum() == null) {
            return null;
        }
        ForumData forum = this.hmG.getForum();
        ForumWriteData forumWriteData = new ForumWriteData(forum.getId(), forum.getName(), forum.getPrefixData(), this.hmG.getAnti());
        forumWriteData.avatar = forum.getImage_url();
        forumWriteData.forumLevel = forum.getUser_level();
        forumWriteData.specialForumType = forum.special_forum_type;
        forumWriteData.firstDir = forum.getFirst_class();
        forumWriteData.secondDir = forum.getSecond_class();
        UserData userData = this.hmG.getUserData();
        forumWriteData.privateThread = userData != null ? userData.getPrivateThread() : 0;
        forumWriteData.frsTabInfo = bVx();
        return forumWriteData;
    }

    private FrsTabInfoData bVx() {
        int i;
        if (this.hny == null || this.hmG == null || this.hnA == null) {
            return null;
        }
        if (this.hmG.getEntelechyTabInfo() == null || com.baidu.tbadk.core.util.v.isEmpty(this.hmG.getEntelechyTabInfo().tab)) {
            return null;
        }
        int ccs = this.hnA.ccs();
        if (ccs == 502) {
            return null;
        }
        int i2 = -1;
        ArrayList arrayList = new ArrayList();
        Iterator<FrsTabInfo> it = this.hmG.getEntelechyTabInfo().tab.iterator();
        while (true) {
            i = i2;
            if (!it.hasNext()) {
                break;
            }
            FrsTabInfo next = it.next();
            if (next != null && next.is_general_tab.intValue() == 1) {
                arrayList.add(new FrsTabItemData(next));
                if (ccs == next.tab_id.intValue()) {
                    i2 = ccs;
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
    public void aWq() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void mN(boolean z) {
        this.hnv = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z) {
        this.hni.tQ(8);
        ((FrsActivity) getActivity()).showLoadingView(view, z);
        ((FrsActivity) getActivity()).j(view, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        this.hni.tQ(0);
        ((FrsActivity) getActivity()).hideLoadingView(view);
        ((FrsActivity) getActivity()).j(view, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        super.showNetRefreshView(view, getResources().getString(R.string.refresh_view_title_text), null, getResources().getString(R.string.refresh_view_button_text), z, getNetRefreshListener());
        this.hni.tQ(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshViewNoClick(View view, String str, boolean z) {
        super.showNetRefreshViewNoClick(view, str, z);
        this.hni.tQ(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        super.hideNetRefreshView(view);
        this.hni.tQ(0);
    }

    public void bVy() {
        FrsTabViewController.b cco;
        if (this.hnA != null && (cco = this.hnA.cco()) != null && cco.fragment != null && (cco.fragment instanceof al)) {
            ((al) cco.fragment).bUy();
        }
    }

    public void mO(boolean z) {
        this.hmY = z;
    }

    public void b(OvalActionButton ovalActionButton) {
        this.hnj = ovalActionButton;
    }

    public OvalActionButton bVz() {
        return this.hnj;
    }

    public boolean bVA() {
        return this.hmY;
    }

    public void onShareSuccess(String str) {
        if (TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.util.aq.isEmpty(str)) {
            if (this.hnY == null) {
                this.hnY = new AddExperiencedModel(getTbPageContext());
            }
            this.hnY.fj(this.forumId, str);
        }
    }

    public boolean bVB() {
        if (this.hnv && !this.hob) {
            return (this.hny != null && this.hny.car() && com.baidu.tieba.frs.a.bTX().bTY()) ? false : true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.f.c
    public boolean videoNeedPreload() {
        if (this.hmG != null) {
            return com.baidu.tbadk.util.ag.nI(2) || (com.baidu.tbadk.util.ag.bgT() && this.hmG.isFrsVideoAutoPlay);
        }
        return super.videoNeedPreload();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.f.c
    public boolean isCyberVideoUsedThisPage() {
        return com.baidu.tbadk.a.b.uD("cyber_player_test") || com.baidu.tbadk.a.b.uC("cyber_player_test");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVC() {
        if (!com.baidu.tbadk.core.util.aq.isEmpty(this.forumId)) {
            com.baidu.tbadk.BdToken.c.aLi().p(com.baidu.tbadk.BdToken.b.dtT, com.baidu.adp.lib.f.b.toLong(this.forumId, 0L));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        FrsTabViewController.b cco;
        if (bUP() == null || (cco = bUP().cco()) == null || !(cco.fragment instanceof BaseFragment)) {
            return null;
        }
        if (cco.fragment instanceof FrsAllThreadFragment) {
            TbPageTag tbPageTag = super.getTbPageTag();
            int i = -1;
            if (this.hmG != null) {
                i = this.hmG.getSortType();
            }
            tbPageTag.sortType = com.baidu.tieba.frs.f.g.vq(i);
            tbPageTag.locatePage = "a070";
            if (this.hmT.equals(cco.title)) {
                tbPageTag.locatePage = "a071";
            }
            return tbPageTag;
        } else if (cco.fragment instanceof FrsFragment) {
            return null;
        } else {
            return ((BaseFragment) cco.fragment).getTbPageTag();
        }
    }

    public void bVD() {
        if (this.hmG != null) {
            com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
            if (this.hmG.needLog == 1) {
                bVar.hIN = true;
            } else {
                bVar.hIN = false;
            }
            if (this.hmG.getForum() != null) {
                bVar.hIP = this.hmG.getForum().getId();
            }
            if (bUM() != null) {
                bVar.hIO = bUM().cav();
            }
            if (com.baidu.tieba.frs.d.d.hvA != null) {
                bVar.hIQ = com.baidu.tieba.frs.d.d.hvA.hIQ;
                bVar.hIR = com.baidu.tieba.frs.d.d.hvA.hIR;
            }
            this.hoe = new com.baidu.tieba.frs.live.b(bVar, getTbPageTag(), getUniqueId());
            this.hoe.uT(this.hof);
            CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_CARD_CLICK, this.hoe);
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
            CustomMessageTask customMessageTask2 = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW, this.hoe);
            customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask2);
            CustomMessageTask customMessageTask3 = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_USER_CLICK, this.hoe);
            customMessageTask3.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask3);
            CustomMessageTask customMessageTask4 = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_VIDEO_CLICK, this.hoe);
            customMessageTask4.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask4);
        }
    }
}
