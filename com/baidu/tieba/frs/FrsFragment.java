package com.baidu.tieba.frs;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
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
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.ResponsedMessage;
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
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.baidu.tbadk.BdToken.f;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.CreateBarGuideActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.core.atomData.MessageCenterActivityConfig;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.PostSearchActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.PrivateForumPopInfoData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bt;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.av;
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
import com.baidu.tieba.frs.HorseRace.GetLiveHorseRaceHttpResponseMessage;
import com.baidu.tieba.frs.HorseRace.GetLiveHorseRaceSocketResponseMessage;
import com.baidu.tieba.frs.HorseRace.LiveHorseRaceData;
import com.baidu.tieba.frs.HorseRace.LiveHorseRaceRequestMessage;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.good.FrsGoodFragment;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.frs.mc.FrsNewAreaFragment;
import com.baidu.tieba.frs.vc.FrsTabViewController;
import com.baidu.tieba.frs.view.FrsHeaderViewContainer;
import com.baidu.tieba.frs.view.FrsRedpackRunView;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.BdTopToast;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsPage.RecmForumInfo;
import tbclient.FrsTabInfo;
import tbclient.WindowToast;
/* loaded from: classes9.dex */
public class FrsFragment extends BaseFragment implements BdListView.e, a.InterfaceC0127a, UserIconBox.b<BdRecyclerView>, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, ao, ar, au, com.baidu.tieba.frs.loadmore.a, com.baidu.tieba.frs.mc.l, com.baidu.tieba.recapp.m {
    public static com.baidu.tieba.tbadkCore.m hzO;
    private com.baidu.tbadk.util.z eEB;
    private com.baidu.adp.lib.d.b<TbImageView> efk;
    private com.baidu.tieba.frs.gametab.b fGq;
    private com.baidu.tbadk.core.dialog.a gTx;
    private com.baidu.tieba.frs.brand.buttommenu.a hAA;
    private com.baidu.tieba.frs.sportspage.notification.a hAB;
    private AddExperiencedModel hAC;
    private boolean hAE;
    private List<LiveHorseRaceData> hAJ;
    private com.baidu.tieba.frs.live.b hAK;
    private int hAL;
    private int hAU;
    private com.baidu.card.ak hAb;
    private FrsModelController hAc;
    private com.baidu.tieba.frs.vc.h hAd;
    private FrsTabViewController hAe;
    private com.baidu.tieba.frs.mc.h hAf;
    private com.baidu.tieba.frs.smartsort.a hAg;
    private com.baidu.tieba.frs.mc.b hAh;
    private av hAi;
    private com.baidu.tieba.frs.entelechy.b.b hAk;
    private com.baidu.tieba.frs.vc.a hAl;
    private com.baidu.tieba.frs.mc.d hAm;
    private com.baidu.tieba.frs.mc.c hAn;
    private com.baidu.tieba.frs.vc.j hAo;
    private com.baidu.tieba.frs.mc.a hAp;
    private com.baidu.tieba.frs.live.a hAq;
    private o hAr;
    public com.baidu.tieba.frs.vc.c hAs;
    private com.baidu.tieba.frs.mc.e hAt;
    private View.OnTouchListener hAu;
    private com.baidu.tieba.frs.view.a hAv;
    private com.baidu.tieba.frs.vc.e hAw;
    private boolean hAx;
    private com.baidu.tieba.NEGFeedBack.a hAy;
    private com.baidu.tieba.ala.a hAz;
    private com.baidu.tieba.tbadkCore.data.f hzG;
    private VoiceManager hzJ;
    private OvalActionButton hzL;
    private FRSRefreshButton hzM;
    private LinearLayout hzN;
    public long hzP;
    private com.baidu.tieba.frs.entelechy.a hzw;
    private View mRootView;
    private String mSchemeUrl;
    public static boolean hzB = false;
    public static volatile long hzR = 0;
    public static volatile long hzS = 0;
    public static volatile int mNetError = 0;
    private String hzv = "";
    public boolean hzx = false;
    private boolean hzy = false;
    private boolean hzz = false;
    private boolean hzA = true;
    public String hzC = null;
    public String mFrom = null;
    public int mFlag = 0;
    public boolean hzD = false;
    private boolean hzE = false;
    private String mThreadId = null;
    public String forumId = null;
    private int hzk = 0;
    private boolean hzF = false;
    private boolean hzH = false;
    private boolean hzI = false;
    private p hzK = null;
    public final bu aiq = null;
    private FrsViewData hzi = new FrsViewData();
    public long hcE = -1;
    public long eAY = 0;
    public long eAO = 0;
    public long createTime = 0;
    public long eAP = 0;
    public long eAV = 0;
    public long hzQ = 0;
    boolean hzT = false;
    public boolean hzU = false;
    private boolean hzV = false;
    private boolean hzW = false;
    public com.baidu.tbadk.n.b hzX = null;
    private boolean hzY = true;
    private boolean hzZ = true;
    private a.C0098a hAa = new a.C0098a(2);
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> hAj = new SparseArray<>();
    private boolean fqf = true;
    private boolean hasInit = false;
    private boolean hAD = false;
    private boolean hAF = false;
    private Date hAG = null;
    private int cTi = 0;
    private int hAH = 0;
    private int hAI = 0;
    public int mHeadLineDefaultNavTabId = -1;
    MessageQueue.IdleHandler hAM = new MessageQueue.IdleHandler() { // from class: com.baidu.tieba.frs.FrsFragment.1
        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            FrsFragment.this.bYo();
            return false;
        }
    };
    private final CustomMessageListener hAN = new CustomMessageListener(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED) { // from class: com.baidu.tieba.frs.FrsFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof bu) {
                    com.baidu.tieba.frs.f.h.a(FrsFragment.this.hzK, FrsFragment.this.hzi, FrsFragment.this.getForumId(), true, (bu) data);
                }
            }
        }
    };
    private CustomMessageListener hAO = new CustomMessageListener(CmdConfigCustom.CMD_CLOSE_GAME_RANK_CARD) { // from class: com.baidu.tieba.frs.FrsFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.hzi != null) {
                FrsFragment.this.hzi.removeGameRankListFromThreadList();
                if (FrsFragment.this.hzK != null) {
                    FrsFragment.this.hzK.aFY();
                }
            }
        }
    };
    private CustomMessageListener aeO = new CustomMessageListener(2921401) { // from class: com.baidu.tieba.frs.FrsFragment.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && FrsFragment.this.hzM != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() <= 0 || FrsFragment.this.hAe.cfT() == 0 || FrsFragment.this.hAe.cfQ() == null || !(FrsFragment.this.hAe.cfQ().fragment instanceof BaseFragment) || !((BaseFragment) FrsFragment.this.hAe.cfQ().fragment).isPrimary() || FrsFragment.this.hzK.bZJ()) {
                    if (FrsFragment.this.hAe.cfT() != 0) {
                        FrsFragment.this.hzM.hide();
                        return;
                    }
                    return;
                }
                FrsFragment.this.hzM.show();
            }
        }
    };
    private CustomMessageListener hAP = new CustomMessageListener(2921467) { // from class: com.baidu.tieba.frs.FrsFragment.45
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && FrsFragment.this.hzM != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() <= 0 || FrsFragment.this.hAe.cfQ() == null || !(FrsFragment.this.hAe.cfQ().fragment instanceof BaseFragment) || !((BaseFragment) FrsFragment.this.hAe.cfQ().fragment).isPrimary() || FrsFragment.this.hzK.bZJ()) {
                    FrsFragment.this.hzN.setVisibility(8);
                    FrsFragment.this.hzT = true;
                    return;
                }
                FrsFragment.this.hzN.setVisibility(0);
                FrsFragment.this.hzT = false;
            }
        }
    };
    private com.baidu.adp.framework.listener.a hAQ = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_FRS_LIVE_HORSE_RACE_LIST, 309667) { // from class: com.baidu.tieba.frs.FrsFragment.51
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if ((responsedMessage instanceof GetLiveHorseRaceHttpResponseMessage) || (responsedMessage instanceof GetLiveHorseRaceSocketResponseMessage)) {
                    FrsFragment.this.hAJ = new ArrayList();
                    FrsFragment.this.hAI = 0;
                    if (responsedMessage instanceof GetLiveHorseRaceHttpResponseMessage) {
                        FrsFragment.this.hAJ = ((GetLiveHorseRaceHttpResponseMessage) responsedMessage).getData().cah();
                    }
                    if (responsedMessage instanceof GetLiveHorseRaceSocketResponseMessage) {
                        FrsFragment.this.hAJ = ((GetLiveHorseRaceSocketResponseMessage) responsedMessage).getData().cah();
                    }
                    BdLog.e("horseSize" + FrsFragment.this.hAJ.size());
                    if (FrsFragment.this.hAJ.size() > 0) {
                        FrsFragment.this.bYN();
                    }
                }
            }
        }
    };
    private CustomMessageListener hAR = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.FrsFragment.52
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 1) {
                    FrsFragment.this.bYs();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                }
            }
        }
    };
    private final at hAS = new at() { // from class: com.baidu.tieba.frs.FrsFragment.53
        @Override // com.baidu.tieba.frs.at
        public void a(int i, int i2, bb bbVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
            FrsFragment.this.bYd();
            if (FrsFragment.this.hAk != null) {
                FrsFragment.this.hAd.nX(FrsFragment.this.hAk.uY(i));
            }
            com.baidu.tieba.tbadkCore.f fVar = new com.baidu.tieba.tbadkCore.f();
            if (bbVar != null) {
                fVar.isSuccess = bbVar.errCode == 0;
                fVar.errorCode = bbVar.errCode;
                fVar.errorMsg = bbVar.errMsg;
                if (fVar.isSuccess) {
                    if (com.baidu.tbadk.core.util.w.isEmpty(arrayList)) {
                        FrsFragment.this.hzK.buL();
                    } else if (bbVar.hasMore) {
                        if (com.baidu.tbadk.core.util.w.getCount(FrsFragment.this.hzi.getThreadList()) > 3) {
                            FrsFragment.this.hzK.buJ();
                        } else {
                            FrsFragment.this.hzK.bZA();
                        }
                    } else if (bbVar.hEr) {
                        FrsFragment.this.hzK.buK();
                    } else {
                        FrsFragment.this.hzK.buL();
                    }
                }
            } else {
                bbVar = new bb();
                bbVar.pn = 1;
                bbVar.hasMore = false;
                bbVar.hEr = false;
            }
            if (i == 1) {
                FrsFragment.this.hzY = true;
                FrsFragment.this.hBi.a(FrsFragment.this.hAc.getType(), false, fVar);
            } else {
                FrsFragment.this.a(fVar);
                if (FrsFragment.this.hAc.cdo() != null) {
                    FrsFragment.this.hzi = FrsFragment.this.hAc.cdo();
                }
                FrsFragment.this.bYu();
            }
            if (FrsFragment.this.hBq != null) {
                FrsFragment.this.hBq.a(i, i2, bbVar, arrayList);
            }
        }
    };
    private FrsTabViewController.a hAT = new FrsTabViewController.a() { // from class: com.baidu.tieba.frs.FrsFragment.54
        @Override // com.baidu.tieba.frs.vc.FrsTabViewController.a
        public void bU(int i, int i2) {
            boolean z = false;
            if (i != 1) {
                com.baidu.tieba.card.s.bOB().mc(false);
                FrsFragment.this.mU(false);
            }
            if (i == 502) {
                FrsFragment.this.hzL.setIconFade(R.drawable.btn_frs_professional_edit_n);
            } else {
                FrsFragment.this.hzL.setIconFade(0);
            }
            FrsFragment.this.hAU = i;
            FrsFragment.this.hAL = i2;
            if (FrsFragment.this.hAK != null) {
                FrsFragment.this.hAK.vA(FrsFragment.this.hAL);
            }
            TbSingleton.getInstance().setFrsCurTabType(FrsFragment.this.hAL);
            FrsFragment.this.bYx();
            com.baidu.tieba.frs.d.d.hIE.hWP = i;
            com.baidu.tieba.frs.d.d.hIE.hWQ = -1;
            b.bXd().M(i == 1 && FrsFragment.this.hAD, true);
            com.baidu.tieba.frs.a bWW = com.baidu.tieba.frs.a.bWW();
            if (i == 1 && FrsFragment.this.hAD) {
                z = true;
            }
            bWW.M(z, true);
        }
    };
    private CustomMessageListener hAV = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIVE_COUNT) { // from class: com.baidu.tieba.frs.FrsFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                FrsFragment.this.hAe.wk(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    };
    private CustomMessageListener hAW = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_LIVE_START) { // from class: com.baidu.tieba.frs.FrsFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && ((Integer) customResponsedMessage.getData()).intValue() == 51 && FrsFragment.this.hzi != null) {
                com.baidu.tieba.frs.f.j.a(FrsFragment.this.hzi, FrsFragment.this.getPageContext());
            }
        }
    };
    private final CustomMessageListener hAX = new CustomMessageListener(CmdConfigCustom.CMD_FRS_SELECT_ALA_LIVE_TAB) { // from class: com.baidu.tieba.frs.FrsFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                FrsFragment.this.hAe.wi(49);
            }
        }
    };
    private final CustomMessageListener hAY = new CustomMessageListener(CmdConfigCustom.CMD_FRS_EXPERIENCE_TIP) { // from class: com.baidu.tieba.frs.FrsFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.u) && FrsFragment.this.hzi != null) {
                FrsFragment.this.hzi.updateLikeData((com.baidu.tieba.tbadkCore.u) customResponsedMessage.getData());
                FrsFragment.this.hAd.i(FrsFragment.this.hzi);
                FrsFragment.this.hAe.a(FrsFragment.this.hzi, FrsFragment.this.hAc.cdS());
            }
        }
    };
    private final AntiHelper.a hAZ = new AntiHelper.a() { // from class: com.baidu.tieba.frs.FrsFragment.6
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ao(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ag("obj_locate", av.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ao(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ag("obj_locate", av.a.LOCATE_LIKE_PERSON));
        }
    };
    private CustomMessageListener hBa = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.FrsFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(FrsFragment.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().els != null) {
                        if (AntiHelper.a(FrsFragment.this.getActivity(), updateAttentionMessage.getData().els, FrsFragment.this.hAZ) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ao(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ag("obj_locate", av.a.LOCATE_LIKE_PERSON));
                        }
                    } else if (updateAttentionMessage.getData().isSucc && updateAttentionMessage.getData().isAttention) {
                        com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getPageContext().getPageActivity(), (int) R.string.attention_success);
                    }
                }
            }
        }
    };
    private CustomMessageListener hBb = new CustomMessageListener(CmdConfigCustom.CMD_GET_ENSURE_CAST_ID) { // from class: com.baidu.tieba.frs.FrsFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsFragment.this.refresh();
        }
    };
    private CustomMessageListener hBc = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.frs.FrsFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && !((PostWriteCallBackData) customResponsedMessage.getData()).isDyamicCallback()) {
                FrsFragment.this.hzK.c((PostWriteCallBackData) customResponsedMessage.getData());
                if (((PostWriteCallBackData) customResponsedMessage.getData()).getGeneralTabId() >= 0) {
                    FrsFragment.this.hAp.vC(((PostWriteCallBackData) customResponsedMessage.getData()).getGeneralTabId());
                }
            }
        }
    };
    private CustomMessageListener hBd = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_REMIND) { // from class: com.baidu.tieba.frs.FrsFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626) {
                NewsRemindMessage newsRemindMessage = (NewsRemindMessage) customResponsedMessage;
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (FrsFragment.this.hzK != null) {
                    FrsFragment.this.hzK.L(notificationCount, z);
                }
            }
        }
    };
    private HttpMessageListener hBe = new HttpMessageListener(CmdConfigHttp.CMD_FRS_MOVE_AREA) { // from class: com.baidu.tieba.frs.FrsFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int i;
            int i2 = 0;
            if (httpResponsedMessage != null && FrsFragment.this.getContext() != null && FrsFragment.this.hzK != null) {
                if (httpResponsedMessage.getError() == 0) {
                    new BdTopToast(FrsFragment.this.getContext()).vz(true).OJ(FrsFragment.this.getContext().getString(R.string.frs_move_area_move_suc)).aE(FrsFragment.this.hzK.bLT());
                    if (com.baidu.tieba.frs.a.bWW().uh(com.baidu.tieba.frs.a.bWW().bWY())) {
                        FrsCommonTabFragment frsCommonTabFragment = null;
                        if (FrsFragment.this.hAe != null && FrsFragment.this.hAe.cfQ() != null && (FrsFragment.this.hAe.cfQ().fragment instanceof FrsCommonTabFragment)) {
                            frsCommonTabFragment = (FrsCommonTabFragment) FrsFragment.this.hAe.cfQ().fragment;
                        }
                        if (frsCommonTabFragment != null) {
                            frsCommonTabFragment.caW();
                        }
                        FrsFragment.this.bXb();
                        com.baidu.tieba.frs.a.bWW().bXb();
                        Iterator<com.baidu.adp.widget.ListView.q> it = FrsFragment.this.hzi.getThreadList().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                i = i2;
                                break;
                            }
                            i = it.next() instanceof bt ? i2 + 1 : i2;
                            if (i >= 6) {
                                break;
                            }
                            i2 = i;
                        }
                        if (i < 6) {
                            FrsFragment.this.btv();
                        }
                    }
                    com.baidu.tieba.frs.a.bWW().reset();
                    return;
                }
                new BdTopToast(FrsFragment.this.getContext()).vz(false).OJ(httpResponsedMessage.getErrorString()).aE(FrsFragment.this.hzK.bLT());
            }
        }
    };
    private final CustomMessageListener hBf = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.frs.FrsFragment.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.isResumed()) {
                FrsFragment.this.bYM();
            }
        }
    };
    private CustomMessageListener hBg = new CustomMessageListener(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER) { // from class: com.baidu.tieba.frs.FrsFragment.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (FrsFragment.this.hzK != null) {
                    FrsFragment.this.hzK.setExpanded(booleanValue);
                }
            }
        }
    };
    private final CustomMessageListener hBh = new CustomMessageListener(2921463) { // from class: com.baidu.tieba.frs.FrsFragment.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TbadkApplication.getInst().getCurrentActivity() != null && !com.baidu.tbadk.core.util.ar.isEmpty(str) && str.equals(FrsFragment.this.forumId)) {
                    com.baidu.tieba.frs.f.e.b(((TbPageContextSupport) TbadkApplication.getInst().getCurrentActivity()).getPageContext(), FrsFragment.this.hzi);
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.q hBi = new com.baidu.tieba.tbadkCore.q() { // from class: com.baidu.tieba.frs.FrsFragment.16
        private long startTime = 0;

        @Override // com.baidu.tieba.tbadkCore.q
        public void uo(int i) {
            this.startTime = System.nanoTime();
            if (FrsFragment.this.hzK != null) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsFragment.this.hzK.bZk();
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
            if (FrsFragment.this.fqf) {
                FrsFragment.this.fqf = false;
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.hzK, FrsFragment.this.hzi, FrsFragment.this.getForumId(), false, null);
            }
            FrsFragment.this.bYd();
            FrsFragment.this.hzV = true;
            if (fVar != null && fVar.isSuccess) {
                FrsFragment.this.hzK.bZx().nE(com.baidu.tbadk.core.util.as.aWR().aWS());
                FrsFragment.hzR = 0L;
                FrsFragment.hzS = 0L;
                FrsFragment.mNetError = 0;
            } else {
                FrsFragment.mNetError = 1;
            }
            if (!FrsFragment.this.hAc.cdX() && (i == 3 || i == 6)) {
                FrsFragment.this.hAn.resetData();
            }
            FrsFragment.this.hzP = System.currentTimeMillis();
            if (FrsFragment.this.hAc.cdo() != null) {
                FrsFragment.this.hzi = FrsFragment.this.hAc.cdo();
            }
            FrsFragment.this.uk(1);
            if (i == 7) {
                FrsFragment.this.ul(FrsFragment.this.hzi.getFrsDefaultTabId());
                return;
            }
            if (FrsFragment.this.hzi.getPage() != null) {
                FrsFragment.this.setHasMore(FrsFragment.this.hzi.getPage().aRf());
            }
            if (i == 4) {
                if (!FrsFragment.this.hAc.cdX() && TbadkCoreApplication.getInst().isRecAppExist() && FrsFragment.this.hAc.cdN() == 1) {
                    FrsFragment.this.hzi.addRecommendAppToThreadList(FrsFragment.this);
                }
                ArrayList<com.baidu.adp.widget.ListView.q> a2 = FrsFragment.this.hAn.a(false, false, FrsFragment.this.hzi.getThreadList(), FrsFragment.this.hzG, false);
                if (a2 != null) {
                    FrsFragment.this.hzi.setThreadList(a2);
                    FrsFragment.this.hzi.checkLiveStageInThreadList();
                }
                if (FrsFragment.this.hAc != null) {
                    com.baidu.tieba.frs.d.c.a(FrsFragment.this.hzi, FrsFragment.this.hAc.cdS(), 2, FrsFragment.this.getContext());
                }
                com.baidu.tieba.frs.f.a.a(FrsFragment.this, FrsFragment.this.hzi.getForum(), FrsFragment.this.hzi.getThreadList(), false, FrsFragment.this.getPn());
                FrsFragment.this.hzK.a(a2, FrsFragment.this.hzi);
                FrsFragment.this.bYe();
                return;
            }
            FrsFragment.this.bYe();
            switch (i) {
                case 1:
                    FrsFragment.this.hzK.bZk();
                    break;
                case 2:
                    FrsFragment.this.hzK.bZk();
                    break;
                case 3:
                case 6:
                    if (FrsFragment.this.hzi != null) {
                        FrsFragment.this.hzi.clearPostThreadCount();
                    }
                    if (FrsFragment.this.hAs != null) {
                        FrsFragment.this.hAs.refresh();
                        break;
                    }
                    break;
            }
            FrsFragment.this.bYm();
            if (fVar == null || fVar.errorCode == 0) {
                if (FrsFragment.this.hzi != null) {
                    if (!FrsFragment.this.a(FrsFragment.this.hzi)) {
                        FrsFragment.this.bYl();
                    }
                    FrsFragment.this.O(false, i == 5);
                    if (FrsFragment.this.hAc != null) {
                        if (FrsFragment.this.hzi.getActivityHeadData() != null && FrsFragment.this.hzi.getActivityHeadData().aQt() != null && FrsFragment.this.hzi.getActivityHeadData().aQt().size() > 0) {
                            com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), 1, FrsFragment.this.hzi.getForum(), FrsFragment.this.hAc.getSortType(), 1);
                        }
                        if (FrsFragment.this.hzi.getThreadList() != null && FrsFragment.this.hzi.getThreadList().size() > 0) {
                            Iterator<com.baidu.adp.widget.ListView.q> it = FrsFragment.this.hzi.getThreadList().iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    com.baidu.adp.widget.ListView.q next = it.next();
                                    if ((next instanceof bu) && ((bu) next).getType() == bu.dNk) {
                                        com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), 1, FrsFragment.this.hzi.getForum(), FrsFragment.this.hAc.getSortType(), 2);
                                    }
                                }
                            }
                        }
                        com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), FrsFragment.this.hzi.getThreadList(), FrsFragment.this.hzi.getForum(), FrsFragment.this.hAc.getSortType());
                    }
                    FrsFragment.this.hzK.uB(i);
                    FrsFragment.hzR = (System.nanoTime() - this.startTime) / TimeUtils.NANOS_PER_MS;
                    if (fVar != null) {
                        FrsFragment.hzS = fVar.lDA;
                    }
                } else {
                    return;
                }
            } else if (FrsFragment.this.hzi == null || com.baidu.tbadk.core.util.w.isEmpty(FrsFragment.this.hzi.getThreadList())) {
                FrsFragment.this.a(fVar);
            } else if (fVar.hkm) {
                FrsFragment.this.showToast(FrsFragment.this.getPageContext().getResources().getString(R.string.net_error_text, fVar.errorMsg, Integer.valueOf(fVar.errorCode)));
            }
            FrsFragment.this.bYi();
            FrsFragment.this.bYj();
            if (FrsFragment.this.hzi.getAccessFlag() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c11384"));
            }
            if (FrsFragment.this.hzH && FrsFragment.this.hAe.wi(49)) {
                FrsFragment.this.hzH = false;
            }
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.q
        public void c(com.baidu.tieba.tbadkCore.m mVar) {
            if ((mVar != null && ("normal_page".equals(FrsFragment.this.hAc.getPageType()) || "frs_page".equals(FrsFragment.this.hAc.getPageType()) || "book_page".equals(FrsFragment.this.hAc.getPageType()))) || "brand_page".equals(FrsFragment.this.hAc.getPageType())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE, mVar));
                FrsFragment.this.b(mVar);
                FrsFragment.hzO = mVar;
            }
        }

        @Override // com.baidu.tieba.tbadkCore.q
        public void bYo() {
            FrsFragment.this.bYo();
        }
    };
    private final CustomMessageListener hBj = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.frs.FrsFragment.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                FrsFragment.this.hzi.updateCurrentUserPendant((com.baidu.tbadk.data.l) customResponsedMessage.getData());
                FrsFragment.this.hzK.bZx().notifyDataSetChanged();
            }
        }
    };
    private final CustomMessageListener mMemListener = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_MEM) { // from class: com.baidu.tieba.frs.FrsFragment.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && FrsFragment.this.hzi != null && (userData = FrsFragment.this.hzi.getUserData()) != null) {
                userData.setIsMem(num.intValue());
                if (num.intValue() != 0) {
                    FrsFragment.this.hAd.l(num);
                }
            }
        }
    };
    private final f.a hBk = new AnonymousClass27();
    private final com.baidu.tieba.frs.mc.k hBl = new com.baidu.tieba.frs.mc.k() { // from class: com.baidu.tieba.frs.FrsFragment.28
        @Override // com.baidu.tieba.frs.mc.k
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, boolean z3) {
            if (FrsFragment.this.hAg != null && FrsFragment.this.hAc != null && FrsFragment.this.hAc.cdX() && z && !z2 && !z3) {
                FrsFragment.this.hAg.vH(i2);
            }
        }
    };
    public final View.OnTouchListener eEC = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.FrsFragment.29
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (FrsFragment.this.hAu != null) {
                FrsFragment.this.hAu.onTouch(view, motionEvent);
            }
            if (FrsFragment.this.hAi != null && FrsFragment.this.hAi.cai() != null) {
                FrsFragment.this.hAi.cai().onTouchEvent(motionEvent);
            }
            if (FrsFragment.this.fGq != null) {
                FrsFragment.this.fGq.b(view, motionEvent);
            }
            if (FrsFragment.this.hAd != null) {
                FrsFragment.this.hAd.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private final CustomMessageListener hBm = new CustomMessageListener(CmdConfigCustom.CMD_GOTOLIVE_HOST_UPGRADE) { // from class: com.baidu.tieba.frs.FrsFragment.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.aVP().getInt(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.PHOTOLIVE_HOSTLEVEL, -1) != -1 && FrsFragment.this.hzi.getForum() != null) {
                FrsFragment.this.hzi.getForum().setCanAddPhotoLivePost(true);
            }
        }
    };
    public final View.OnClickListener hBn = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.32
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsFragment.this.hzK != null && view == FrsFragment.this.hzK.bZi() && FrsFragment.this.getActivity() != null) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, FrsFragment.this.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            if (view.getId() == R.id.game_activity_egg_layout && com.baidu.adp.lib.util.l.isNetOk()) {
                TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_CLICK);
                if (FrsFragment.this.hzK == null || !FrsFragment.this.hzK.bZu()) {
                    String activityUrl = FrsFragment.this.hzi.getForum().getYuleData().aUJ().getActivityUrl();
                    if (!StringUtils.isNull(activityUrl)) {
                        com.baidu.tbadk.browser.a.startInternalWebActivity(FrsFragment.this.getPageContext().getPageActivity(), activityUrl);
                    }
                } else {
                    FrsFragment.this.hzK.bZv();
                }
            }
            if (FrsFragment.this.hzK != null && view == FrsFragment.this.hzK.bZB() && FrsFragment.this.hAc != null && FrsFragment.this.hAc.hasMore()) {
                FrsFragment.this.hzK.buJ();
                FrsFragment.this.btv();
            }
            if (view != null && FrsFragment.this.hzK != null && view == FrsFragment.this.hzK.bZr()) {
                if (com.baidu.tbadk.core.util.be.checkUpIsLogin(FrsFragment.this.getContext())) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ao(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).ag("obj_locate", 2));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MessageCenterActivityConfig(FrsFragment.this.getContext())));
                } else {
                    return;
                }
            }
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (FrsFragment.this.hzi != null && FrsFragment.this.hzi.getForum() != null) {
                    if (FrsFragment.this.hzK != null && view == FrsFragment.this.hzK.bZp()) {
                        if (FrsFragment.this.hzi != null && FrsFragment.this.hzi.getForum() != null && !StringUtils.isNull(FrsFragment.this.hzi.getForum().getId()) && !StringUtils.isNull(FrsFragment.this.hzi.getForum().getName())) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ao(TbadkCoreStatisticKey.KEY_SHARE_CLICK).dk("fid", FrsFragment.this.hzi.getForum().getId()).ag("obj_locate", 11));
                            com.baidu.tieba.frs.f.e.a(FrsFragment.this.getPageContext(), FrsFragment.this.hzi, FrsFragment.this.hzi.getForum().getId());
                        } else {
                            return;
                        }
                    }
                    if (FrsFragment.this.hzK != null && view == FrsFragment.this.hzK.bZo()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c12402").dk("fid", FrsFragment.this.hzi.getForum().getId()).dk("uid", TbadkCoreApplication.getCurrentAccount()).dk("fname", FrsFragment.this.hzi.getForum().getName()));
                        if (!StringUtils.isNull(FrsFragment.this.hzi.getForum().getName())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PostSearchActivityConfig(FrsFragment.this.getContext(), FrsFragment.this.hzi.getForum().getName(), FrsFragment.this.hzi.getForum().getId())));
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
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.FrsFragment.33
        private int hBI = 0;
        private int fmb = 0;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsFragment.this.hAH += i2;
            if (FrsFragment.this.hAH >= FrsFragment.this.cTi * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
            if (FrsFragment.this.hAl != null) {
                FrsFragment.this.hAl.ceO();
            }
            this.hBI = 0;
            this.fmb = 0;
            if (recyclerView != null && (recyclerView instanceof BdRecyclerView)) {
                this.hBI = ((BdRecyclerView) recyclerView).getFirstVisiblePosition();
                this.fmb = ((BdRecyclerView) recyclerView).getLastVisiblePosition();
            }
            if (FrsFragment.this.hAw != null) {
                FrsFragment.this.hAw.a(recyclerView, this.hBI, this.fmb);
            }
            if (FrsFragment.this.hzi != null && FrsFragment.this.hzK != null && FrsFragment.this.hzK.bZx() != null) {
                FrsFragment.this.hzK.bW(this.hBI, this.fmb);
                if (FrsFragment.this.hAb != null && FrsFragment.this.hAb.se() != null) {
                    FrsFragment.this.hAb.se().b(FrsFragment.this.hAa);
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (FrsFragment.this.hAd != null) {
                FrsFragment.this.hAd.setScrollState(i);
            }
            if ((i == 2 || i == 1) && !FrsFragment.this.hzW) {
                FrsFragment.this.hzW = true;
                FrsFragment.this.hzK.bZz();
            }
            if (FrsFragment.this.hzX == null && !FrsFragment.this.bYF()) {
                FrsFragment.this.hzX = new com.baidu.tbadk.n.b();
                FrsFragment.this.hzX.setSubType(1000);
            }
            if (i == 0) {
                if (FrsFragment.this.hzX != null) {
                    FrsFragment.this.hzX.bhG();
                }
                com.baidu.tieba.card.s.bOB().mc(true);
                FrsFragment.this.mU(true);
                FrsFragment.this.hzK.bV(this.hBI, this.fmb);
            } else if (FrsFragment.this.hzX != null) {
                FrsFragment.this.hzX.bhF();
            }
            if (FrsFragment.this.hAw != null) {
                FrsFragment.this.hAw.onScrollStateChanged(recyclerView, i);
            }
            if (i == 0) {
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.hzK, FrsFragment.this.hzi, FrsFragment.this.getForumId(), false, null);
            }
            if (FrsFragment.this.hAe != null && i == 1) {
                FrsFragment.this.hAe.cfS();
            }
            if (FrsFragment.this.hAb == null) {
                if (FrsFragment.this.hzK.bZb() != null && !FrsFragment.this.hzK.bYD() && FrsFragment.this.hzK.bZb().cVm() != null && (FrsFragment.this.hzK.bZb().cVm().getTag() instanceof com.baidu.card.ak)) {
                    FrsFragment.this.hAb = (com.baidu.card.ak) FrsFragment.this.hzK.bZb().cVm().getTag();
                }
            } else if (i == 0 && FrsFragment.this.hzK.bZb() != null && !FrsFragment.this.hzK.bYD() && FrsFragment.this.hzK.bZb().cVm() != null && (FrsFragment.this.hzK.bZb().cVm().getTag() instanceof com.baidu.card.ak)) {
                FrsFragment.this.hAb = (com.baidu.card.ak) FrsFragment.this.hzK.bZb().cVm().getTag();
            }
            if (i == 1) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921418));
            }
        }
    };
    private final f hBo = new f() { // from class: com.baidu.tieba.frs.FrsFragment.35
        @Override // com.baidu.tieba.frs.f
        public void a(int i, int i2, View view, View view2, bu buVar) {
            if (i != FrsFragment.this.hzK.bZx().cbH()) {
                if (i != FrsFragment.this.hzK.bZx().cbI()) {
                    if (i == FrsFragment.this.hzK.bZx().cbF() && FrsFragment.this.hzi != null && FrsFragment.this.hzi.getUserData() != null && FrsFragment.this.hzi.getUserData().isBawu()) {
                        String bawuCenterUrl = FrsFragment.this.hzi.getBawuCenterUrl();
                        if (!com.baidu.tbadk.core.util.ar.isEmpty(bawuCenterUrl) && FrsFragment.this.hzi.getForum() != null) {
                            com.baidu.tbadk.browser.a.startWebActivity(FrsFragment.this.getPageContext().getPageActivity(), bawuCenterUrl);
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c10502").dk("fid", FrsFragment.this.hzi.getForum().getId()).dk("uid", FrsFragment.this.hzi.getUserData().getUserId()));
                        }
                    }
                } else if (com.baidu.tbadk.core.util.be.checkUpIsLogin(FrsFragment.this.getPageContext().getPageActivity())) {
                    TiebaStatic.log(CommonStatisticKey.MY_SERVICE_CK);
                    if (FrsFragment.this.hzi != null && FrsFragment.this.hzi.getForum() != null) {
                        ForumData forum = FrsFragment.this.hzi.getForum();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(forum.getId(), 0L), forum.getName(), forum.getImage_url(), 0)));
                    }
                }
            } else if (com.baidu.tbadk.core.util.be.checkUpIsLogin(FrsFragment.this.getActivity())) {
                TiebaStatic.log("forum_fortune_click");
                com.baidu.tieba.frs.f.i.c(FrsFragment.this.getPageContext(), FrsFragment.this.hzi);
            }
        }
    };
    private final NoNetworkView.a hwW = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.FrsFragment.36
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (FrsFragment.this.hAc.cdN() == 1 && z && !FrsFragment.this.hzK.bYD()) {
                if (FrsFragment.this.hzi == null || com.baidu.tbadk.core.util.w.isEmpty(FrsFragment.this.hzi.getThreadList())) {
                    FrsFragment.this.hideNetRefreshView(FrsFragment.this.hzK.bLT());
                    FrsFragment.this.showLoadingView(FrsFragment.this.hzK.bLT(), true);
                    FrsFragment.this.hzK.ne(false);
                    FrsFragment.this.refresh();
                    return;
                }
                FrsFragment.this.hzK.bZk();
            }
        }
    };
    private final CustomMessageListener elO = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.FrsFragment.37
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                com.baidu.tieba.frs.f.c.a(customResponsedMessage, FrsFragment.this.hzK, FrsFragment.this.hzi);
            }
        }
    };
    private com.baidu.adp.widget.ListView.z hBp = new a();
    private at hBq = new at() { // from class: com.baidu.tieba.frs.FrsFragment.39
        @Override // com.baidu.tieba.frs.at
        public void a(int i, int i2, bb bbVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
            com.baidu.adp.lib.f.e.lt().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.39.1
                @Override // java.lang.Runnable
                public void run() {
                    if (FrsFragment.this.hzK != null && FrsFragment.this.hzK.bZE()) {
                        FrsFragment.this.btv();
                    }
                }
            });
        }
    };
    private CustomMessageListener hBr = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.frs.FrsFragment.40
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    FrsFragment.this.hAx = true;
                }
            }
        }
    };
    private CustomMessageListener hBs = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.frs.FrsFragment.41
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                    if (FrsFragment.this.hAb == null && FrsFragment.this.hzK.bZb() != null && !FrsFragment.this.hzK.bYD() && FrsFragment.this.hzK.bZb().cVm() != null && (FrsFragment.this.hzK.bZb().cVm().getTag() instanceof com.baidu.card.ak)) {
                        FrsFragment.this.hAb = (com.baidu.card.ak) FrsFragment.this.hzK.bZb().cVm().getTag();
                    }
                    if (FrsFragment.this.hAb != null && FrsFragment.this.hAb.se() != null) {
                        FrsFragment.this.hAb.se().b(new a.C0098a(3));
                    }
                }
            }
        }
    };
    private CustomMessageListener hBt = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.FrsFragment.42
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.hzK != null) {
                FrsFragment.this.hzK.yA();
            }
        }
    };
    private CustomMessageListener hBu = new CustomMessageListener(2921437) { // from class: com.baidu.tieba.frs.FrsFragment.43
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && FrsFragment.this.isResumed()) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (FrsFragment.this.hzM != null) {
                    if (booleanValue) {
                        if (FrsFragment.this.hAe.cfT() != 0 && !FrsFragment.this.hzK.bZJ()) {
                            FrsFragment.this.hzM.show();
                            return;
                        }
                        return;
                    }
                    FrsFragment.this.hzM.hide();
                }
            }
        }
    };
    private CustomMessageListener hBv = new CustomMessageListener(2921462) { // from class: com.baidu.tieba.frs.FrsFragment.49
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && FrsFragment.this.hzi.getIs_get_horse_race_lamp().intValue() == 1 && FrsFragment.this.mIsLogin) {
                LiveHorseRaceRequestMessage liveHorseRaceRequestMessage = new LiveHorseRaceRequestMessage();
                liveHorseRaceRequestMessage.setForum_id(Long.valueOf(FrsFragment.this.forumId));
                FrsFragment.this.sendMessage(liveHorseRaceRequestMessage);
            }
        }
    };
    private CustomMessageListener hBw = new CustomMessageListener(2001223) { // from class: com.baidu.tieba.frs.FrsFragment.50
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Date)) {
                FrsFragment.this.hAG = (Date) customResponsedMessage.getData();
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.frs.loadmore.a
    public /* bridge */ /* synthetic */ com.baidu.adp.base.e getPageContext() {
        return super.getPageContext();
    }

    public com.baidu.tieba.frs.entelechy.b.b bXR() {
        return this.hAk;
    }

    public com.baidu.adp.widget.ListView.z bXS() {
        return this.hBp;
    }

    public com.baidu.tieba.frs.mc.d bXT() {
        return this.hAm;
    }

    public com.baidu.tieba.frs.smartsort.a bXU() {
        return this.hAg;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public FrsModelController bXV() {
        return this.hAc;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public com.baidu.tieba.frs.mc.c bXW() {
        return this.hAn;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public com.baidu.tieba.frs.vc.h bXX() {
        return this.hAd;
    }

    public FrsTabViewController bXY() {
        return this.hAe;
    }

    public av bXZ() {
        return this.hAi;
    }

    public void mT(boolean z) {
        this.hAF = z;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public p bYa() {
        return this.hzK;
    }

    @Override // com.baidu.tieba.frs.au
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.au, com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.hzC;
    }

    public void setForumName(String str) {
        this.hzC = str;
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
        if (this.hAn == null) {
            return 1;
        }
        return this.hAn.getPn();
    }

    public int getPn() {
        if (this.hAn == null) {
            return 1;
        }
        return this.hAn.getPn();
    }

    public void setPn(int i) {
        if (this.hAn != null) {
            this.hAn.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.hAn != null) {
            this.hAn.setHasMore(i);
        }
    }

    public int bYb() {
        if (this.hAn == null) {
            return -1;
        }
        return this.hAn.bYb();
    }

    public boolean bYc() {
        return this.hzI;
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
            this.hzK.bZe();
            showNetRefreshView(this.hzK.bLT(), string, true);
        } else if (340001 == fVar.errorCode) {
            a(fVar, this.hzi.getRecm_forum_list());
        } else {
            if (com.baidu.tbadk.core.util.w.isEmpty(this.hzi.getThreadList())) {
                b(fVar);
            }
            if (bYF()) {
                setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds280));
            } else {
                setNetRefreshViewEmotionDefMarginTop();
            }
        }
    }

    public void a(View view, String str, boolean z, List<RecmForumInfo> list) {
        this.hzK.bZe();
        this.hzK.uv(8);
        if (this.hAv == null) {
            this.hAv = new com.baidu.tieba.frs.view.a(getPageContext(), getNetRefreshListener());
        }
        this.hAv.setSubText(str);
        this.hAv.cM(list);
        this.hAv.attachView(view, z);
    }

    private void a(com.baidu.tieba.tbadkCore.f fVar, List<RecmForumInfo> list) {
        if (this.hzK != null) {
            this.hzK.bZe();
            this.hzK.setTitle(this.hzC);
            a(this.hzK.bLT(), fVar.errorMsg, true, list);
        }
    }

    private void b(com.baidu.tieba.tbadkCore.f fVar) {
        this.hzK.bZe();
        if (fVar.hkm) {
            showNetRefreshView(this.hzK.bLT(), TbadkCoreApplication.getInst().getString(R.string.net_error_text, new Object[]{fVar.errorMsg, Integer.valueOf(fVar.errorCode)}), true);
        } else {
            showNetRefreshView(this.hzK.bLT(), fVar.errorMsg, true);
        }
    }

    public void bYd() {
        hideLoadingView(this.hzK.bLT());
        this.hzK.btV();
        if (this.hzK.bZc() instanceof com.baidu.tieba.frs.tab.c) {
            ((com.baidu.tieba.frs.tab.c) this.hzK.bZc()).cev();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYe() {
        if (bYb() == 0 && com.baidu.tbadk.core.util.w.isEmpty(this.hzi.getThreadListIds())) {
            if (com.baidu.tbadk.core.util.w.isEmpty(this.hzi.getThreadList())) {
                this.hzK.buL();
            } else {
                this.hzK.buK();
            }
        } else if (com.baidu.tbadk.core.util.w.getCount(this.hzi.getThreadList()) > 3) {
            this.hzK.buJ();
        } else {
            this.hzK.bZA();
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
            bYd();
            this.hzK.bZk();
            com.baidu.tieba.tbadkCore.f cdJ = this.hAc.cdJ();
            boolean isEmpty = com.baidu.tbadk.core.util.w.isEmpty(this.hzi.getThreadList());
            if (cdJ != null && isEmpty) {
                if (this.hAc.cdL() != 0) {
                    this.hAc.cdQ();
                    this.hzK.bZk();
                } else {
                    a(cdJ);
                }
                this.hzK.P(this.hzi.isStarForum(), false);
                return;
            }
            a(cdJ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(com.baidu.tieba.tbadkCore.m mVar) {
        if (mVar != null && mVar.getEntelechyTabInfo() != null && mVar.getEntelechyTabInfo().tab != null) {
            for (FrsTabInfo frsTabInfo : mVar.getEntelechyTabInfo().tab) {
                if (frsTabInfo.tab_id.intValue() == 502 && com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean("first_into_tab_profession", true)) {
                    return false;
                }
            }
        }
        return new com.baidu.tieba.frs.ad.f(getTbPageContext()).d(mVar);
    }

    public boolean bYf() {
        return bYg() && !bYh();
    }

    private boolean bYg() {
        if (bYC() == null) {
            return false;
        }
        FrsViewData bYC = bYC();
        com.baidu.tbadk.core.data.w wVar = null;
        if (bYC.getStar() != null && !StringUtils.isNull(bYC.getStar().dhn())) {
            wVar = new com.baidu.tbadk.core.data.w();
        } else if (bYC.getActivityHeadData() != null && com.baidu.tbadk.core.util.w.getCount(bYC.getActivityHeadData().aQt()) >= 1) {
            wVar = bYC.getActivityHeadData().aQt().get(0);
        }
        return wVar != null;
    }

    public boolean bYh() {
        if (bYC() == null) {
            return false;
        }
        FrsViewData bYC = bYC();
        return (com.baidu.tbadk.core.util.w.isEmpty(bYC.getShowTopThreadList()) && bYC.getBusinessPromot() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYi() {
        boolean b;
        if (!bYk()) {
            final PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
            privateForumPopInfoData.a(this.hzi.getPrivateForumTotalInfo().getPrivatePopInfo());
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(getActivity());
            if (this.hzi.getPrivateForumTotalInfo().aRm().private_forum_status.intValue() == 1 && (com.baidu.tbadk.core.util.ar.isEmpty(privateForumPopInfoData.aRo()) || privateForumPopInfoData.aRr() != Integer.valueOf(this.forumId))) {
                privateForumPopInfoData.vH("create_success");
                privateForumPopInfoData.vI(TbadkCoreApplication.getInst().getString(R.string.frs_private_create_hint));
                privateForumPopInfoData.vJ("https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.hzC + "&nomenu=1");
                privateForumPopInfoData.h(Integer.valueOf(this.forumId));
                b = frsPrivateCommonDialogView.b(privateForumPopInfoData);
            } else {
                b = privateForumPopInfoData.aRr() == Integer.valueOf(this.forumId) ? frsPrivateCommonDialogView.b(privateForumPopInfoData) : false;
            }
            if (b) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
                aVar.kW(2);
                aVar.aP(frsPrivateCommonDialogView);
                aVar.hg(false);
                frsPrivateCommonDialogView.setConfirmButton(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.17
                    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.frs.FrsFragment */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        com.baidu.tbadk.core.util.bc.aWU().b(FrsFragment.this.getPageContext(), new String[]{privateForumPopInfoData.aRq()});
                        aVar.dismiss();
                    }
                });
                aVar.a(new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.18
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(getPageContext()).aUN();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYj() {
        if (bYk() || this.hzi.getPrivateForumTotalInfo().aRm().private_forum_status.intValue() != 1) {
            a((Integer) null, (Integer) null, true);
        } else {
            a(this.hzi.getPrivateForumTotalInfo().aRm().private_forum_audit_status, this.hzi.getPrivateForumTotalInfo().aRn(), false);
        }
    }

    public void a(Integer num, Integer num2, boolean z) {
        final String str;
        final int i = 2;
        if (this.hzK.bZq() != null) {
            TextView bZq = this.hzK.bZq();
            if (z) {
                bZq.setVisibility(8);
                return;
            }
            if (num.intValue() == 2) {
                bZq.setText("修改实名认证信息");
                bZq.setVisibility(0);
                str = "https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + this.forumId + "&nomenu=1";
            } else if (num2.intValue() >= 0 && num2.intValue() <= 100) {
                bZq.setText("目标已完成" + String.valueOf(num2) + "%");
                bZq.setVisibility(0);
                str = "https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.hzC + "&nomenu=1";
                i = 1;
            } else {
                bZq.setVisibility(8);
                i = 0;
                str = "";
            }
            bZq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.19
                /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c13387").dk("fid", FrsFragment.this.forumId).dk("uid", TbadkCoreApplication.getCurrentAccount()).ag("obj_type", i));
                    com.baidu.tbadk.core.util.bc.aWU().b(FrsFragment.this.getPageContext(), new String[]{str});
                }
            });
        }
    }

    private boolean bYk() {
        return this.hzi == null || this.hzi.getPrivateForumTotalInfo() == null || this.hzi.getPrivateForumTotalInfo().aRm() == null || this.hzi.getUserData().getIs_manager() != 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYl() {
        boolean z;
        boolean z2;
        if (this.hzi == null || this.hzi.getEntelechyTabInfo() == null || this.hzi.getEntelechyTabInfo().tab == null) {
            z = false;
        } else {
            z = false;
            for (FrsTabInfo frsTabInfo : this.hzi.getEntelechyTabInfo().tab) {
                if (frsTabInfo.tab_id.intValue() == 502) {
                    if (com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean("first_into_tab_profession", true)) {
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
        if (z && com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean("first_into_tab_general", true)) {
            l.a(getActivity(), getPageContext());
            com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean("first_into_tab_general", false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uk(int i) {
        List<WindowToast> list;
        if (TbadkCoreApplication.isLogin() && this.hzi != null && (list = this.hzi.mWindowToast) != null && list.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < list.size()) {
                    WindowToast windowToast = list.get(i3);
                    if (windowToast == null || windowToast.toast_type.intValue() != i) {
                        i2 = i3 + 1;
                    } else if (!com.baidu.tbadk.core.util.ar.isEmpty(windowToast.toast_link)) {
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
    public void bYm() {
        if (this.hzi == null || this.hzi.getForum() != null) {
            this.hzK.bZw();
        } else if (this.hzi.getForum().getYuleData() != null && this.hzi.getForum().getYuleData().aUI()) {
            TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_VIEW);
            this.hzK.a(this.hzi.getForum().getYuleData().aUJ());
        } else {
            this.hzK.bZw();
        }
    }

    private void N(boolean z, boolean z2) {
        if (this.hAc != null && this.hzi != null && this.hzK != null && z) {
            if (!this.hAc.cdX() && this.hAc.cdN() == 1) {
                if (!this.hAc.cdV()) {
                    this.hzi.addCardVideoInfoToThreadList();
                    this.hzi.addVideoInfoToThreadListInTenAndFifteenFloor();
                }
                boolean z3 = false;
                if (this.hzK.bZx().r(com.baidu.tieba.card.data.n.gVa)) {
                    z3 = this.hzi.addHotTopicDataToThreadList();
                }
                if (!z3) {
                    this.hzi.addFeedForumDataToThreadList();
                }
                if (TbadkCoreApplication.getInst().isRecAppExist()) {
                    this.hzi.addRecommendAppToThreadList(this);
                }
                if (!this.hzK.bZx().r(bu.dLI)) {
                    this.hzi.removeAlaLiveThreadData();
                }
                this.hzi.addSchoolRecommendToThreadList();
            }
            if (!this.hzK.bZx().r(bu.dLI)) {
                this.hzi.removeAlaInsertLiveData();
                this.hzi.removeAlaStageLiveDat();
            } else {
                this.hzi.addInsertLiveDataToThreadList();
                this.hzi.addStageLiveDataToThreadList();
            }
            this.hzi.checkLiveStageInThreadList();
            this.hzi.addNoticeThreadToThreadList();
            if (this.hzK.bZx().r(com.baidu.tieba.h.b.igG)) {
                this.hzi.addGameRankListToThreadList(z2);
            }
            if (TbadkCoreApplication.isLogin() && (!this.hAc.cdX() || this.hAc.isNetFirstLoad)) {
                this.hzi.addUserRecommendToThreadList();
            }
            this.hzi.addVideoActivityToTop();
        }
    }

    public boolean bYn() {
        if (this.hAd != null && this.hAc != null) {
            this.hAd.a(this.hAc.getPageType(), this.hzi);
        }
        boolean z = false;
        if (this.hzi != null) {
            z = this.hzi.hasTab();
        }
        bYq();
        if (this.hzK != null) {
            this.hzK.bZK();
            this.hzK.bZL();
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ul(int i) {
        ay ayVar = null;
        bYn();
        bYx();
        try {
            if (this.hzi != null) {
                this.hzK.a((ArrayList<com.baidu.adp.widget.ListView.q>) null, this.hzi);
                this.hAd.wa(1);
                this.hzK.bZn();
                this.hAe.a(this.hzi, this.hAc.cdS());
                com.baidu.tieba.frs.tab.d wj = this.hAe.wj(this.hzi.getFrsDefaultTabId());
                if (wj != null && !TextUtils.isEmpty(wj.url)) {
                    ayVar = new ay();
                    ayVar.ext = wj.url;
                    ayVar.stType = wj.name;
                }
                this.hAc.a(this.hzi.getFrsDefaultTabId(), 0, ayVar);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(boolean z, boolean z2) {
        try {
            if (this.hzi != null && this.hAe != null && this.hAc != null) {
                if (!this.hzK.bZx().r(bu.dLI)) {
                    this.hzi.removeAlaLiveThreadData();
                }
                boolean isEmpty = com.baidu.tbadk.core.util.w.isEmpty(this.hzi.getGameTabInfo());
                this.hzK.nc(isEmpty);
                if (!isEmpty) {
                    if (this.hAw == null) {
                        this.hAw = new com.baidu.tieba.frs.vc.e(this, (NoPressedRelativeLayout) this.mRootView);
                    }
                    if (this.fGq == null) {
                        this.fGq = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
                    }
                } else {
                    this.hAw = null;
                    this.fGq = null;
                }
                if (this.hzi.getForum() != null) {
                    this.hzC = this.hzi.getForum().getName();
                    this.forumId = this.hzi.getForum().getId();
                }
                if (this.hzi.hasTab()) {
                    this.hAe.a(this.hzi, this.hAc.cdS());
                }
                if (z) {
                    N(true, z);
                } else {
                    N(this.hzY, z);
                }
                bYn();
                if (this.hAk != null) {
                    this.hAk.a(this.hAd, this.hzi);
                }
                if (this.hzi.getPage() != null) {
                    setHasMore(this.hzi.getPage().aRf());
                }
                ArrayList<com.baidu.adp.widget.ListView.q> a2 = this.hAn.a(z2, true, this.hzi.getThreadList(), null, z, false);
                if (a2 != null) {
                    this.hzi.setThreadList(a2);
                }
                this.hzi.removeRedundantUserRecommendData();
                this.hzk = this.hzi.getTopThreadSize();
                if (this.hzG != null) {
                    this.hzF = true;
                    this.hzG.ES(this.hzk);
                    com.baidu.tieba.frs.f.a.a(this, this.hzi.getForum(), this.hzi.getThreadList(), this.hzF, getPn());
                }
                if (this.hAc.cdN() == 1) {
                    bYu();
                    if (!z && this.hAc.getPn() == 1) {
                        bYp();
                    }
                }
                if (this.hAl != null) {
                    this.hAl.ce(this.hAe.cfP());
                }
                bYd();
                this.hzK.bZf();
                this.hzK.P(true, false);
                if (z && this.hzi.isFirstTabEqualAllThread()) {
                    com.baidu.adp.lib.f.e.lt().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.20
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!FrsFragment.this.hzV && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                FrsFragment.this.hzK.bZI();
                            }
                        }
                    });
                }
                if (this.hzi.getForum() != null) {
                    this.hzK.Fe(this.hzi.getForum().getWarningMsg());
                }
                if (this.hzi != null && this.hzi.getFrsVideoActivityData() != null && com.baidu.tbadk.core.sharedPref.b.aVP().getLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 0L) == 0) {
                    com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.21
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsFragment.this.hzK.bZG();
                        }
                    }, 1000L);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FRS_SHOW_AR_ENTRY, this));
                this.hzK.bYZ();
                if (this.hzi != null && this.hzi.getForum() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ENTER_FORUM, new VisitedForumData(this.hzi.getForum().getId(), this.hzi.getForum().getName(), this.hzi.getForum().getImage_url(), String.valueOf(System.currentTimeMillis() / 1000), ConstantData.Forum.SPECAIL_FORUM_TYPE_LIVE.equals(this.hzi.getForum().special_forum_type), this.hzi.getForum().getThemeColorInfo(), this.hzi.getForum().getMember_num())));
                }
                this.hAA.a(this.hzi.bottomMenuList, this.hzi.getForum());
                bYM();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void bYo() {
        if (this.hAc != null && this.hAc.cdN() == 1) {
            this.hAd.j(this.hzi);
        }
    }

    public void mU(boolean z) {
        com.baidu.tieba.s.c.dgY().b(getUniqueId(), z);
    }

    public void bYp() {
        if (this.hAq == null) {
            this.hAq = new com.baidu.tieba.frs.live.a(this, com.baidu.adp.lib.f.b.toInt(this.forumId, 0));
        }
        this.hAq.cdu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.tbadkCore.m mVar) {
        try {
            if (!this.hzV && mVar != null && this.hzi != null) {
                this.hzi.receiveData(mVar);
                O(true, false);
                Looper.myQueue().addIdleHandler(this.hAM);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void bYq() {
        if (this.hAc != null) {
            Fd(this.hAc.getPageType());
        } else {
            Fd("normal_page");
        }
    }

    private void Fd(String str) {
        mV("frs_page".equals(str));
        if (this.hAk != null) {
            this.hAk.a(this.hAd, this.hzK, this.hzi);
        }
    }

    public void mV(boolean z) {
        if (this.hAo != null) {
            this.hAo.cfC();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.s.c.dgY().z(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.frs_activity, viewGroup, false);
            this.hzw = new com.baidu.tieba.frs.entelechy.a();
            this.hAk = this.hzw.cbl();
            this.hzv = TbadkCoreApplication.getInst().getString(R.string.frs_title_new_area);
            this.hAd = new com.baidu.tieba.frs.vc.h(this, this.hzw, (FrsHeaderViewContainer) this.mRootView.findViewById(R.id.header_view_container));
            this.hAe = new FrsTabViewController(this, this.mRootView);
            this.hAe.registerListener();
            this.hAd.a(this.hAe);
            this.hAe.a(this.hAT);
            Intent intent = getActivity().getIntent();
            if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                this.hzy = true;
            }
            this.hzK = new p(this, this.hBn, this.hzw, this.hzy, this.hAd);
            this.hAA = new com.baidu.tieba.frs.brand.buttommenu.a(getPageContext(), this.mRootView);
        } else {
            if (this.mRootView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            if (this.hAe != null) {
                this.hAe.registerListener();
            }
            this.hzK.bZF();
            this.mRootView.setLeft(0);
            this.mRootView.setRight(com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getContext()));
        }
        this.hAE = true;
        this.eAP = System.currentTimeMillis() - currentTimeMillis;
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        ArrayList<com.baidu.adp.widget.ListView.q> arrayList = null;
        this.hcE = System.currentTimeMillis();
        long j = this.hcE;
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.hzH = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.hcE = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            R(intent);
        }
        this.eAO = j - this.hcE;
        this.hzG = new com.baidu.tieba.tbadkCore.data.f("frs", com.baidu.tieba.tbadkCore.data.f.lFk);
        if (this.hAc == null) {
            this.hAc = new FrsModelController(this, this.hBi);
            this.hAc.a(this.hAS);
            this.hAc.init();
        }
        this.hAc.setSchemeUrl(this.mSchemeUrl);
        if (intent != null) {
            this.hAc.aj(intent.getExtras());
        } else if (bundle != null) {
            this.hAc.aj(bundle);
        } else {
            this.hAc.aj(null);
        }
        if (intent != null) {
            this.hAd.aq(intent.getExtras());
        } else if (bundle != null) {
            this.hAd.aq(bundle);
        } else {
            this.hAd.aq(null);
        }
        this.hzJ = getVoiceManager();
        this.hAr = new o(getPageContext(), this);
        initUI();
        initData(bundle);
        if (!bYF()) {
            this.hAi = new av(getActivity(), this.hzK, this.hAd);
            this.hAi.nr(true);
        }
        this.hzJ = getVoiceManager();
        if (this.hzJ != null) {
            this.hzJ.onCreate(getPageContext());
        }
        new com.baidu.tieba.frs.mc.i();
        int i = -1;
        if (this.hAn != null && this.hAn.cdF() != null) {
            i = this.hAn.cdF().bYb();
            arrayList = this.hAn.cdF().getDataList();
        }
        this.hAn = new com.baidu.tieba.frs.mc.c(this, this.hBl);
        this.hAn.cdF().setHasMore(i);
        if (arrayList != null && arrayList.size() > 0) {
            this.hAn.cdF().av(arrayList);
        }
        this.hAg = new com.baidu.tieba.frs.smartsort.a(this);
        this.hAo = new com.baidu.tieba.frs.vc.j(this);
        this.hAl = new com.baidu.tieba.frs.vc.a(getPageContext(), this.hAc.cdU());
        this.hAh = new com.baidu.tieba.frs.mc.b(this);
        this.hAm = new com.baidu.tieba.frs.mc.d(this);
        this.hAf = new com.baidu.tieba.frs.mc.h(this);
        this.hAp = new com.baidu.tieba.frs.mc.a(this);
        this.hAs = new com.baidu.tieba.frs.vc.c(this);
        this.hAt = new com.baidu.tieba.frs.mc.e(this, getUniqueId());
        this.hAy = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "frs");
        this.hAz = new com.baidu.tieba.ala.a(getPageContext());
        this.hAB = new com.baidu.tieba.frs.sportspage.notification.a(getPageContext());
        registerListener(this.hBa);
        registerListener(this.mMemListener);
        registerListener(this.hAY);
        registerListener(this.hBm);
        registerListener(this.hBj);
        registerListener(this.hAV);
        registerListener(this.hAW);
        registerListener(this.hAX);
        registerListener(this.hAN);
        registerListener(this.hAO);
        registerListener(this.aeO);
        registerListener(this.hBr);
        registerListener(this.hBc);
        registerListener(this.hAR);
        registerListener(this.hBd);
        registerListener(this.hBb);
        registerListener(this.hBf);
        registerListener(this.hBg);
        registerListener(this.hBh);
        this.hBs.setTag(getPageContext().getUniqueId());
        MessageManager.getInstance().registerListener(this.hBs);
        registerListener(this.hBt);
        registerListener(this.hBu);
        registerListener(this.hBv);
        registerListener(this.hAQ);
        registerListener(this.hBw);
        registerListener(this.hBe);
        registerListener(this.hAP);
        this.hzK.ne(false);
        if (!bYF() && !this.hasInit) {
            showLoadingView(this.hzK.bLT(), true);
            this.hAc.P(3, false);
        }
        aw awVar = new aw() { // from class: com.baidu.tieba.frs.FrsFragment.25
            @Override // com.baidu.tieba.frs.aw
            public void d(boolean z, boolean z2, int i2) {
                if (FrsFragment.this.hzK != null) {
                    if (i2 == 1) {
                        FrsFragment.this.hzK.uw(z ? 0 : 8);
                    } else if (i2 == 2) {
                        FrsFragment.this.hzK.uy(z ? 0 : 8);
                    }
                    if (!z2) {
                        FrsFragment.this.hAD = z;
                    }
                    if (FrsFragment.this.hzK.bZx() != null && (i2 == 2 || (FrsFragment.this.hAc != null && FrsFragment.this.hAc.cdO()))) {
                        FrsFragment.this.hzK.bZx().notifyDataSetChanged();
                    }
                    if (FrsFragment.this.bXY() != null) {
                        FrsTabViewController.b cfQ = FrsFragment.this.bXY().cfQ();
                        if (cfQ != null) {
                            if ((cfQ.fragment instanceof FrsCommonTabFragment) && (i2 == 2 || cfQ.tabId == 502)) {
                                ((FrsCommonTabFragment) cfQ.fragment).cbb();
                            } else if ((cfQ.fragment instanceof FrsNewAreaFragment) && (i2 == 2 || cfQ.tabId == 503)) {
                                FrsNewAreaFragment frsNewAreaFragment = (FrsNewAreaFragment) cfQ.fragment;
                                frsNewAreaFragment.cbb();
                                if (frsNewAreaFragment.ceg() != null) {
                                    com.baidu.tieba.frs.mc.g ceg = frsNewAreaFragment.ceg();
                                    ceg.nt(!z);
                                    if (i2 == 1) {
                                        ceg.nh(!z);
                                    } else if (i2 == 2) {
                                        ceg.nh(true);
                                    }
                                }
                            } else if (cfQ.fragment instanceof FrsGoodFragment) {
                                ((FrsGoodFragment) cfQ.fragment).cbb();
                            }
                        }
                        if (FrsFragment.this.bXY().cfH() != null) {
                            FrsFragment.this.bXY().cfH().setmDisallowSlip(z);
                            FrsFragment.this.bXY().nY(z);
                        }
                    }
                    if (FrsFragment.this.hzK.bZd() != null) {
                        FrsFragment.this.hzK.nb(!z);
                    }
                    if (FrsFragment.this.getActivity() instanceof FrsActivity) {
                        ((FrsActivity) FrsFragment.this.getActivity()).mS(!z);
                    }
                    if (FrsFragment.this.hAA != null) {
                        FrsFragment.this.hAA.nz(!z);
                    }
                    FrsFragment.this.hzK.ng(!z);
                    if (i2 == 1) {
                        FrsFragment.this.hzK.nh(z ? false : true);
                    } else if (i2 == 2) {
                        FrsFragment.this.hzK.nh(true);
                    }
                }
            }

            @Override // com.baidu.tieba.frs.aw
            public void bT(int i2, int i3) {
                if (FrsFragment.this.hzK != null) {
                    if (i3 == 1) {
                        FrsFragment.this.hzK.ux(i2);
                    } else if (i3 == 2) {
                        FrsFragment.this.hzK.uz(i2);
                    }
                }
            }

            @Override // com.baidu.tieba.frs.aw
            public void up(int i2) {
                if (FrsFragment.this.getContext() != null) {
                    if (i2 == 1) {
                        com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getContext(), (int) R.string.frs_multi_delete_max_num);
                    } else if (i2 == 2 && FrsFragment.this.hzK != null) {
                        new BdTopToast(FrsFragment.this.getContext()).vz(false).OJ(FrsFragment.this.getContext().getString(R.string.frs_move_area_max_num)).aE(FrsFragment.this.hzK.bLT());
                    }
                }
            }
        };
        b.bXd().a(awVar);
        com.baidu.tieba.frs.a.bWW().a(awVar);
        this.hzK.b(new d.a() { // from class: com.baidu.tieba.frs.FrsFragment.26
            @Override // com.baidu.tieba.NEGFeedBack.d.a
            public void a(DeleteThreadHttpResponseMessage deleteThreadHttpResponseMessage) {
                boolean z;
                int i2 = 0;
                if (deleteThreadHttpResponseMessage != null) {
                    FrsFragment.this.hzK.bnq();
                    FrsFragment.this.hzK.bZH();
                    FrsNewAreaFragment frsNewAreaFragment = null;
                    if (FrsFragment.this.hAe == null || FrsFragment.this.hAe.cfQ() == null || !(FrsFragment.this.hAe.cfQ().fragment instanceof FrsNewAreaFragment)) {
                        z = false;
                    } else {
                        frsNewAreaFragment = (FrsNewAreaFragment) FrsFragment.this.hAe.cfQ().fragment;
                        z = true;
                    }
                    if (deleteThreadHttpResponseMessage.getError() == 0) {
                        String text = !TextUtils.isEmpty(deleteThreadHttpResponseMessage.getText()) ? deleteThreadHttpResponseMessage.getText() : FrsFragment.this.getString(R.string.delete_fail);
                        if (deleteThreadHttpResponseMessage.getRetType() == 1211066) {
                            if (FrsFragment.this.gTx == null) {
                                FrsFragment.this.gTx = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.gTx.we(text);
                            FrsFragment.this.gTx.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.26.1
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.gTx.hg(false);
                            FrsFragment.this.gTx.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.gTx.aUN();
                        } else if (deleteThreadHttpResponseMessage.getRetType() == 1211067) {
                            if (FrsFragment.this.gTx == null) {
                                FrsFragment.this.gTx = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.gTx.we(text);
                            FrsFragment.this.gTx.a(R.string.know, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.26.2
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.gTx.hg(false);
                            FrsFragment.this.gTx.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.gTx.aUN();
                        } else {
                            FrsFragment.this.hzK.aJ(deleteThreadHttpResponseMessage.getText(), ContextCompat.getColor(FrsFragment.this.getContext(), deleteThreadHttpResponseMessage.getRetType() == 1 ? R.color.nav_bar_tip_error : R.color.cp_link_tip_a_alpha95));
                        }
                        if (z && frsNewAreaFragment != null) {
                            frsNewAreaFragment.cI(deleteThreadHttpResponseMessage.getSuccessItems());
                        }
                        FrsFragment.this.cw(deleteThreadHttpResponseMessage.getSuccessItems());
                        b.bXd().cv(deleteThreadHttpResponseMessage.getSuccessItems());
                        for (com.baidu.adp.widget.ListView.q qVar : FrsFragment.this.hzi.getThreadList()) {
                            if (qVar instanceof bt) {
                                i2++;
                                continue;
                            }
                            if (i2 >= 6) {
                                break;
                            }
                        }
                        if (i2 < 6) {
                            FrsFragment.this.btv();
                            return;
                        }
                        return;
                    }
                    com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getActivity(), deleteThreadHttpResponseMessage.getErrorString());
                }
            }
        });
        this.cTi = UtilHelper.getScreenHeight(getActivity());
        this.hasInit = true;
        um(1);
        super.onActivityCreated(bundle);
        this.createTime = System.currentTimeMillis() - j;
    }

    public void mW(boolean z) {
        if (this.hAe != null) {
            this.hAe.ibb = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cw(List<String> list) {
        if (!com.baidu.tbadk.core.util.w.isEmpty(list)) {
            ArrayList<com.baidu.adp.widget.ListView.q> threadList = this.hzi.getThreadList();
            if (!com.baidu.tbadk.core.util.w.isEmpty(threadList) && this.hzK.getListView() != null && this.hzK.getListView().getData() != null) {
                Iterator<com.baidu.adp.widget.ListView.q> it = threadList.iterator();
                List<com.baidu.adp.widget.ListView.q> data = this.hzK.getListView().getData();
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.q next = it.next();
                    if (next instanceof bt) {
                        bu buVar = ((bt) next).dLi;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= list.size()) {
                                break;
                            } else if (!com.baidu.tbadk.core.util.ar.equals(list.get(i2), buVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.hAn.d(next);
                                this.hzK.getListView().getAdapter().notifyItemRemoved(i);
                                break;
                            }
                        }
                    }
                    i++;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXb() {
        if (!com.baidu.tbadk.core.util.w.isEmpty(com.baidu.tieba.frs.a.bWW().bXa()) && this.hzK.getListView() != null && this.hzK.getListView().getData() != null) {
            ArrayList<com.baidu.adp.widget.ListView.q> threadList = this.hzi.getThreadList();
            if (!com.baidu.tbadk.core.util.w.isEmpty(threadList)) {
                Iterator<com.baidu.adp.widget.ListView.q> it = threadList.iterator();
                List<com.baidu.adp.widget.ListView.q> data = this.hzK.getListView().getData();
                int count = com.baidu.tbadk.core.util.w.getCount(com.baidu.tieba.frs.a.bWW().bXa());
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.q next = it.next();
                    if (next instanceof bt) {
                        bu buVar = ((bt) next).dLi;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= count) {
                                break;
                            } else if (!com.baidu.tbadk.core.util.ar.equals(com.baidu.tieba.frs.a.bWW().bXa().get(i2).getId(), buVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.hAn.d(next);
                                this.hzK.getListView().getAdapter().notifyItemRemoved(i);
                                break;
                            }
                        }
                    }
                    i++;
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.ao
    public void btQ() {
        if (isAdded() && this.fqf && !isLoadingViewAttached()) {
            showLoadingView(this.hzK.bLT(), true);
        }
    }

    @Override // com.baidu.tieba.frs.ao
    public void btR() {
        if (isAdded() && this.fqf && isLoadingViewAttached()) {
            hideLoadingView(this.hzK.bLT());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (bYF()) {
            showLoadingView(this.hzK.bLT(), true);
            this.hzK.uA(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.hAc.O(3, true);
            aYH().scrollToPosition(0);
        }
    }

    private void um(int i) {
        String str = "";
        if (this.hzi != null && this.hzi.getForum() != null) {
            str = this.hzi.getForum().getId();
        }
        if (!StringUtils.isNull(str)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c13008").dk("fid", str).dk("obj_type", "4").ag("obj_locate", i).dk("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    @Override // com.baidu.tieba.frs.ao
    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.aa aaVar) {
        if (aaVar != null) {
            this.eEB = aaVar.bja();
            this.hAu = aaVar.bjb();
        }
    }

    @Override // com.baidu.tieba.frs.ao
    public void showFloatingView() {
        if (this.eEB != null) {
            this.eEB.iK(true);
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
                this.hzC = uri.getQueryParameter("name");
                this.mFrom = uri.getQueryParameter("from");
                if (!StringUtils.isNull(this.hzC)) {
                    intent.putExtra("name", this.hzC);
                }
                if (!StringUtils.isNull(this.mFrom)) {
                    intent.putExtra("from", this.mFrom);
                }
                TiebaStatic.log(TbadkCoreStatisticKey.AS_INVOKE_TIEBA);
            }
            if (StringUtils.isNull(this.hzC) && uri != null) {
                if (com.baidu.tbadk.BdToken.f.p(uri)) {
                    com.baidu.tbadk.BdToken.f.aMH().b(uri, this.hBk);
                } else {
                    com.baidu.tieba.frs.f.d U = com.baidu.tieba.frs.f.i.U(intent);
                    if (U != null) {
                        this.hzC = U.forumName;
                        if (U.hYF == null || U.hYF.equals("aidou")) {
                        }
                    }
                }
                if (!StringUtils.isNull(this.hzC)) {
                    intent.putExtra("name", this.hzC);
                }
                intent.putExtra(FrsActivityConfig.FRS_CALL_FROM, 12);
            }
        }
    }

    /* renamed from: com.baidu.tieba.frs.FrsFragment$27  reason: invalid class name */
    /* loaded from: classes9.dex */
    class AnonymousClass27 implements f.a {
        AnonymousClass27() {
        }

        @Override // com.baidu.tbadk.BdToken.f.a
        public void C(final HashMap<String, Object> hashMap) {
            if (hashMap != null) {
                if (hashMap.get(com.baidu.tbadk.BdToken.f.dAb) instanceof String) {
                    FrsFragment.this.hzC = (String) hashMap.get(com.baidu.tbadk.BdToken.f.dAb);
                }
                if ((hashMap.get(com.baidu.tbadk.BdToken.f.dAt) instanceof String) && !TextUtils.isEmpty((String) hashMap.get(com.baidu.tbadk.BdToken.f.dAt))) {
                    com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.27.1
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsFragment.this.hAe.wi(301);
                            final long j = com.baidu.adp.lib.f.b.toLong((String) hashMap.get(com.baidu.tbadk.BdToken.f.dAc), 0L);
                            final int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
                            final int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
                            final float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                            final int i = 1;
                            if (com.baidu.tbadk.core.util.as.aWR().aWS()) {
                                i = 2;
                            }
                            com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.27.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                                    requestGetMyPostNetMessage.setParams(j, 0L, 0L, equipmentWidth, equipmentHeight, f, i);
                                    requestGetMyPostNetMessage.setTag(FrsFragment.this.getUniqueId());
                                    requestGetMyPostNetMessage.setProZone(2);
                                    MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
                                }
                            }, 1000L);
                        }
                    }, 1200L);
                }
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.hzJ = getVoiceManager();
        if (this.hzJ != null) {
            this.hzJ.onStart(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        Intent intent;
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.elO);
        if (bundle != null) {
            this.hzC = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
            this.hzC = intent.getStringExtra("name");
            this.mFrom = intent.getStringExtra("from");
            this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
        }
        if (getArguments() != null) {
            this.hzD = getArguments().getBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, false);
        }
        if (TextUtils.isEmpty(this.mFrom) || FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
        }
        if (this.mIsLogin) {
            registerListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL, this.elO);
        }
        this.hAd.aq(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.s.c.dgY().A(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.hBr);
        hzO = null;
        if (this.hzJ != null) {
            this.hzJ.onDestory(getPageContext());
        }
        com.baidu.tieba.recapp.report.a.remove("FRS");
        this.hzJ = null;
        com.baidu.tieba.card.s.bOB().mc(false);
        if (this.hzi != null && this.hzi.getForum() != null) {
            ai.cae().ei(com.baidu.adp.lib.f.b.toLong(this.hzi.getForum().getId(), 0L));
        }
        if (this.hAq != null) {
            this.hAq.onDestory();
        }
        if (this.hzK != null) {
            com.baidu.tieba.frs.f.h.a(this.hzK, this.hzi, getForumId(), false, null);
            this.hzK.onDestroy();
        }
        if (this.hzN != null) {
            this.hzN.removeAllViews();
            this.hzN.setVisibility(8);
        }
        super.onDestroy();
        try {
            if (this.hzX != null) {
                this.hzX.bhH();
            }
            if (this.hzK != null) {
                this.hzK.release();
            }
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.hAd.cdm();
        Looper.myQueue().removeIdleHandler(this.hAM);
        if (this.hAc != null) {
            this.hAc.bzg();
        }
        if (this.hAi != null) {
            this.hAi.bnF();
        }
        if (this.hAl != null) {
            this.hAl.destory();
        }
        if (this.hAg != null) {
            this.hAg.onDestroy();
        }
        if (this.hAw != null) {
            this.hAw.onDestory();
        }
        if (this.hAp != null) {
            this.hAp.onDestroy();
        }
        if (this.hAy != null) {
            this.hAy.onDestroy();
        }
        if (this.hAz != null) {
            this.hAz.onDestroy();
        }
        com.baidu.tieba.recapp.d.a.cZG().cZI();
        com.baidu.tieba.frs.f.j.ceL();
        if (this.hAe != null) {
            this.hAe.a((FrsTabViewController.a) null);
            this.hAe.cfS();
        }
        if (this.hAC != null) {
            this.hAC.onDestroy();
        }
        b.bXd().a(null);
        com.baidu.tieba.frs.a.bWW().a(null);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.hzC);
        bundle.putString("from", this.mFrom);
        this.hAc.onSaveInstanceState(bundle);
        if (this.hzJ != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            this.hzJ.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.hAp != null) {
            this.hAp.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.hzK != null) {
            this.hzK.bZk();
            this.hzK.onResume();
        }
        this.hAf.nQ(true);
        this.hzY = true;
        if (hzB) {
            hzB = false;
            if (this.hzK != null) {
                this.hzK.startPullRefresh();
                return;
            }
            return;
        }
        if (this.hzJ != null) {
            this.hzJ.onResume(getPageContext());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_RESUME));
        if (this.hzK != null) {
            this.hzK.ni(false);
        }
        if (this.hAx) {
            refresh(6);
            this.hAx = false;
        }
        if (this.hAG != null && getActivity() != null) {
            if (NotificationManagerCompat.from(getActivity()).areNotificationsEnabled()) {
                com.baidu.tbadk.coreExtra.messageCenter.f.bcq().setSignAlertOn(true);
                com.baidu.tbadk.coreExtra.messageCenter.f.bcq().setSignAlertTime(this.hAG.getHours(), this.hAG.getMinutes());
                if (this.hzK != null) {
                    com.baidu.tbadk.coreExtra.messageCenter.f.bcq().a(getTbPageContext().getPageActivity(), this.hzK.bLT());
                }
            }
            this.hAG = null;
        }
        bYM();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
    }

    public boolean bYr() {
        Intent intent;
        if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
            return false;
        }
        return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
    }

    public void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.hzC = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.hzE = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.hzE) {
                bYs();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYs() {
        this.hzK.startPullRefresh();
    }

    public void closeActivity() {
        com.baidu.tieba.frs.f.i.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.mFrom);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.hzK.setTitle(this.hzC);
        } else {
            this.hzK.setTitle("");
            this.mFlag = 1;
        }
        this.hzK.a(this.hBp);
        this.hzK.addOnScrollListener(this.mScrollListener);
        this.hzK.g(this.hwW);
        this.hzK.bZx().a(this.hBo);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hAE) {
            this.hzK.onChangeSkinType(i);
            this.hAd.vZ(i);
            this.hAe.onChangeSkinType(i);
            if (this.hzM != null) {
                this.hzM.onChangeSkinType(i);
            }
            if (this.hAv != null) {
                this.hAv.onChangeSkinType();
            }
            if (this.hAA != null) {
                this.hAA.onChangeSkinType(getPageContext(), i);
            }
            if (this.gTx != null) {
                com.baidu.tbadk.r.a.a(getPageContext(), this.gTx.getRealView());
            }
            if (this.hAw != null) {
                this.hAw.onChangeSkinType(getPageContext(), i);
            }
        }
    }

    public void un(int i) {
        if (!this.mIsLogin) {
            if (this.hzi != null && this.hzi.getAnti() != null) {
                this.hzi.getAnti().setIfpost(1);
            }
            if (i == 0) {
                com.baidu.tbadk.core.util.be.skipToLoginActivity(getActivity());
            }
        } else if (this.hzi != null) {
            if (i == 0) {
                com.baidu.tieba.frs.f.j.g(this, 0);
            } else {
                this.hzK.bZm();
            }
        }
    }

    public void refresh() {
        com.baidu.tieba.a.d.boB().Ad("page_frs");
        refresh(3);
    }

    public void refresh(int i) {
        this.hzV = false;
        bYx();
        if (this.hzK != null && this.hzK.bZb() != null) {
            this.hzK.bZb().cjf();
        }
        if (this.hAc != null) {
            this.hAc.O(i, true);
        }
    }

    private void bYt() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.f.h.lu().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.31
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.Nl(FrsFragment.this.hzC);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYu() {
        bYx();
        try {
            if (this.hzi != null) {
                this.hzK.byK();
                this.hzK.nb(bYL());
                if (!com.baidu.tieba.frs.vc.h.m(this.hzi) || !com.baidu.tieba.frs.vc.h.l(this.hzi)) {
                }
                if (this.hzi.getForum() != null) {
                    this.hzC = this.hzi.getForum().getName();
                    this.forumId = this.hzi.getForum().getId();
                }
                if (this.hzi.getPage() != null) {
                    setHasMore(this.hzi.getPage().aRf());
                }
                this.hzK.setTitle(this.hzC);
                this.hzK.setForumName(this.hzC);
                TbadkCoreApplication.getInst().setDefaultBubble(this.hzi.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.hzi.getUserData().getBimg_end_time());
                bYt();
                bYv();
                ArrayList<com.baidu.adp.widget.ListView.q> threadList = this.hzi.getThreadList();
                if (threadList != null) {
                    this.hzK.a(threadList, this.hzi);
                    com.baidu.tieba.frs.f.c.A(this.hzK);
                    this.hAd.wa(getPageNum());
                    this.hAd.i(this.hzi);
                    this.hAe.a(this.hzi, this.hAc.cdS());
                    this.hzK.bZn();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void bYv() {
        if (this.hzi != null) {
            if (this.hzi.getIsNewUrl() == 1) {
                this.hzK.bZx().setFromCDN(true);
            } else {
                this.hzK.bZx().setFromCDN(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.hAf.nQ(false);
        this.hzY = false;
        this.hzK.onPause();
        if (this.hzJ != null) {
            this.hzJ.onPause(getPageContext());
        }
        this.hzK.ni(true);
        if (this.hAl != null) {
            this.hAl.ceO();
        }
        com.baidu.tbadk.BdToken.c.aMo().aMy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.hAe != null && this.hAe.cfQ() != null && (this.hAe.cfQ().fragment instanceof BaseFragment)) {
            ((BaseFragment) this.hAe.cfQ().fragment).setPrimary(z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.s.bOB().mc(false);
        mU(false);
        if (this.hzi != null && this.hzi.getForum() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            com.baidu.tbadk.distribute.a.beN().b(getPageContext().getPageActivity(), "frs", this.hzi.getForum().getId(), 0L);
        }
        if (this.hzJ != null) {
            this.hzJ.onStop(getPageContext());
        }
        if (aYH() != null) {
            aYH().getRecycledViewPool().clear();
        }
        this.hAd.aXU();
        com.baidu.tbadk.util.ab.bjd();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            if (this.hAd != null) {
                this.hAd.bB(isPrimary());
            }
            if (this.hzK != null) {
                this.hzK.bB(isPrimary());
                this.hzK.ni(!isPrimary());
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (b.bXd().bWX()) {
                b.bXd().reset();
                return true;
            } else if (com.baidu.tieba.frs.a.bWW().bWX()) {
                if (this.hzK != null && this.hzK.bZC()) {
                    this.hzK.bZD();
                    return true;
                }
                com.baidu.tieba.frs.a.bWW().reset();
                return true;
            } else if (this.hzK != null) {
                return this.hzK.bZj();
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
        com.baidu.tbadk.distribute.a.beN().a(advertAppInfo, this.forumId, 0L, "FRS", str, getPn());
    }

    @Override // com.baidu.tieba.recapp.m
    public void bYw() {
        bXV().bYw();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.hzJ == null) {
            this.hzJ = VoiceManager.instance();
        }
        return this.hzJ;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdRecyclerView aYH() {
        if (this.hzK == null) {
            return null;
        }
        return this.hzK.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void bYx() {
        if (this.hzJ != null) {
            this.hzJ.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> aYI() {
        if (this.efk == null) {
            this.efk = UserIconBox.t(getPageContext().getPageActivity(), 8);
        }
        return this.efk;
    }

    public void bYy() {
        if (getFragmentActivity() != null && getFragmentActivity().getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.t onGetPreLoadListView() {
        return aYH().getPreLoadHandle();
    }

    @Override // com.baidu.tieba.frs.ar
    public NavigationBar bwW() {
        if (this.hzK == null) {
            return null;
        }
        return this.hzK.bwW();
    }

    public FRSRefreshButton bYz() {
        return this.hzM;
    }

    public void c(LinearLayout linearLayout) {
        if (linearLayout != null) {
            this.hzN = linearLayout;
        }
    }

    public void a(FRSRefreshButton fRSRefreshButton) {
        if (fRSRefreshButton != null) {
            this.hzM = fRSRefreshButton;
            this.hzM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.38
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (FrsFragment.this.hAe != null) {
                        FrsTabViewController.b cfQ = FrsFragment.this.hAe.cfQ();
                        if (cfQ != null && cfQ.fragment != null && (cfQ.fragment instanceof aq)) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                            ((aq) cfQ.fragment).bXH();
                            ((aq) cfQ.fragment).buI();
                            return;
                        }
                        FrsFragment.this.bYa().startPullRefresh();
                    }
                }
            });
        }
    }

    public void bYA() {
        if (this.hzM != null) {
            this.hzM.hide();
        }
    }

    public void bYB() {
        if (this.hzM != null) {
            this.hzM.show();
        }
    }

    /* loaded from: classes9.dex */
    private final class a implements com.baidu.adp.widget.ListView.z {
        private a() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.z
        public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null) {
                if (bdUniqueId == v.hDm) {
                    if (FrsFragment.this.hzK != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c11752").dk("fid", FrsFragment.this.forumId).dk("obj_locate", "1"));
                        FrsFragment.this.hzK.startPullRefresh();
                    }
                } else if (qVar != null && (qVar instanceof bt)) {
                    bu buVar = ((bt) qVar).dLi;
                    if (buVar.aTp() == null || buVar.aTp().getGroup_id() == 0 || com.baidu.tbadk.core.util.be.checkUpIsLogin(FrsFragment.this.getActivity())) {
                        if (buVar.aTc() != 1 || com.baidu.tbadk.core.util.be.checkUpIsLogin(FrsFragment.this.getActivity())) {
                            if (buVar.aSB() != null) {
                                if (com.baidu.tbadk.core.util.be.checkUpIsLogin(FrsFragment.this.getActivity())) {
                                    String postUrl = buVar.aSB().getPostUrl();
                                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.isNetOk()) {
                                        com.baidu.tbadk.browser.a.startInternalWebActivity(FrsFragment.this.getActivity(), postUrl);
                                    }
                                }
                            } else if (buVar.aTA() != null) {
                                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                    com.baidu.tbadk.core.util.be.skipToLoginActivity(FrsFragment.this.getPageContext().getPageActivity());
                                    return;
                                }
                                com.baidu.tbadk.core.data.r aTA = buVar.aTA();
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), aTA.getCartoonId(), aTA.getChapterId(), 2)));
                            } else {
                                com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                                if (readThreadHistory != null && !readThreadHistory.Nr(buVar.getId())) {
                                    readThreadHistory.Nq(buVar.getId());
                                }
                                boolean z = false;
                                final String aSv = buVar.aSv();
                                if (aSv != null && !aSv.equals("")) {
                                    z = true;
                                    new Thread(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.a.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            com.baidu.tbadk.core.util.y yVar = new com.baidu.tbadk.core.util.y(aSv);
                                            yVar.aWu().aWV().mIsNeedAddCommenParam = false;
                                            yVar.aWu().aWV().mIsUseCurrentBDUSS = false;
                                            yVar.getNetData();
                                        }
                                    }).start();
                                }
                                String tid = buVar.getTid();
                                if (tid == null) {
                                    tid = "";
                                }
                                if (buVar.aSk() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                    com.baidu.tbadk.core.util.bc.aWU().b(FrsFragment.this.getPageContext(), new String[]{tid, "", null});
                                    return;
                                }
                                if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && tid.length() > 4 && tid.length() > 3) {
                                    buVar.setId(tid.substring(3));
                                }
                                if (bdUniqueId.getId() == bu.dNk.getId()) {
                                    com.baidu.tieba.frs.f.h.a(buVar.aRV());
                                } else if (bdUniqueId.getId() == bu.dLL.getId()) {
                                    com.baidu.tbadk.core.util.ao aoVar = new com.baidu.tbadk.core.util.ao(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                                    aoVar.dk("obj_type", "2");
                                    aoVar.dk("tid", buVar.getTid());
                                    TiebaStatic.log(aoVar);
                                }
                                com.baidu.tieba.frs.f.i.a(FrsFragment.this, buVar, i, z);
                                com.baidu.tieba.frs.f.h.a(FrsFragment.this, FrsFragment.this.hzi, buVar);
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
            hideNetRefreshView(this.hzK.bLT());
            showLoadingView(this.hzK.bLT(), true);
            this.hzK.ne(false);
            this.hAc.O(3, true);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData bYC() {
        return this.hzi;
    }

    public boolean bYD() {
        return this.hzK.bYD();
    }

    public void aA(Object obj) {
        if (this.hAh != null && this.hAh.hUa != null) {
            this.hAh.hUa.callback(obj);
        }
    }

    public void aB(Object obj) {
        if (this.hAh != null && this.hAh.hUb != null) {
            this.hAh.hUb.callback(obj);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        this.hzK.getListView().stopScroll();
        if (!this.hzK.bZt()) {
            if (!com.baidu.adp.lib.util.l.isNetOk()) {
                this.hzK.buL();
            } else if (this.hAc.cdN() == 1) {
                btK();
                btv();
            } else if (this.hAc.hasMore()) {
                btv();
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void onFailed(String str) {
        btK();
        showToast(str);
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void an(ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        boolean isEmpty = com.baidu.tbadk.core.util.w.isEmpty(arrayList);
        setHasMore(isEmpty ? 0 : 1);
        btK();
        if (!isEmpty) {
            if (!this.hAc.cdX() && TbadkCoreApplication.getInst().isRecAppExist() && this.hAc.cdN() == 1) {
                this.hzi.addRecommendAppToThreadList(this, arrayList);
            }
            if (this.hAc != null) {
                com.baidu.tieba.frs.d.a.a(getUniqueId(), arrayList, this.hzi.getForum(), this.hAc.getSortType());
            }
            ArrayList<com.baidu.adp.widget.ListView.q> a2 = this.hAn.a(false, false, arrayList, this.hzG, false);
            if (a2 != null) {
                this.hzi.setThreadList(a2);
                this.hzK.a(a2, this.hzi);
            }
            if (this.hAc != null) {
                com.baidu.tieba.frs.d.c.a(this.hzi, this.hAc.cdS(), 2, getContext());
            }
        }
    }

    private void btK() {
        if (bYb() == 1 || this.hAn.cH(this.hzi.getThreadListIds())) {
            if (com.baidu.tbadk.core.util.w.getCount(this.hzi.getThreadList()) > 3) {
                this.hzK.buJ();
            } else {
                this.hzK.bZA();
            }
        } else if (com.baidu.tbadk.core.util.w.isEmpty(this.hzi.getThreadList())) {
            this.hzK.buL();
        } else {
            this.hzK.buK();
        }
    }

    @Override // com.baidu.tieba.frs.mc.l
    public void btv() {
        if (this.hAn != null) {
            this.hAn.a(this.hzC, this.forumId, this.hzi);
        }
    }

    public void bYE() {
        if (!com.baidu.tbadk.core.util.ac.requestWriteExternalStorgeAndCameraPermission(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.am.g(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment, com.baidu.h.a.a.InterfaceC0127a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        com.baidu.tieba.frs.f.i.a(this, i, strArr, iArr);
    }

    public void mX(boolean z) {
        if (this.hAi != null) {
            this.hAi.nr(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.hAj.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a pm(int i) {
        return this.hAj.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        this.hAr.b(bVar);
    }

    public boolean bYF() {
        return this.hzy;
    }

    @Override // com.baidu.tieba.frs.ao
    public void IB() {
        if (this.hzK != null) {
            showFloatingView();
            this.hzK.getListView().scrollToPosition(0);
            this.hzK.startPullRefresh();
        }
    }

    public ForumWriteData bYG() {
        if (this.hzi == null || this.hzi.getForum() == null) {
            return null;
        }
        ForumData forum = this.hzi.getForum();
        ForumWriteData forumWriteData = new ForumWriteData(forum.getId(), forum.getName(), forum.getPrefixData(), this.hzi.getAnti());
        forumWriteData.avatar = forum.getImage_url();
        forumWriteData.forumLevel = forum.getUser_level();
        forumWriteData.specialForumType = forum.special_forum_type;
        forumWriteData.firstDir = forum.getFirst_class();
        forumWriteData.secondDir = forum.getSecond_class();
        UserData userData = this.hzi.getUserData();
        forumWriteData.privateThread = userData != null ? userData.getPrivateThread() : 0;
        forumWriteData.frsTabInfo = bYH();
        return forumWriteData;
    }

    private FrsTabInfoData bYH() {
        int i;
        if (this.hAc == null || this.hzi == null || this.hAe == null) {
            return null;
        }
        if (this.hzi.getEntelechyTabInfo() == null || com.baidu.tbadk.core.util.w.isEmpty(this.hzi.getEntelechyTabInfo().tab)) {
            return null;
        }
        int cfU = this.hAe.cfU();
        if (cfU == 502) {
            return null;
        }
        int i2 = -1;
        ArrayList arrayList = new ArrayList();
        Iterator<FrsTabInfo> it = this.hzi.getEntelechyTabInfo().tab.iterator();
        while (true) {
            i = i2;
            if (!it.hasNext()) {
                break;
            }
            FrsTabInfo next = it.next();
            if (next != null && next.is_general_tab.intValue() == 1) {
                arrayList.add(new FrsTabItemData(next));
                if (cfU == next.tab_id.intValue()) {
                    i2 = cfU;
                }
            }
            i2 = i;
        }
        if (com.baidu.tbadk.core.util.w.isEmpty(arrayList)) {
            return null;
        }
        FrsTabInfoData frsTabInfoData = new FrsTabInfoData();
        frsTabInfoData.tabList = arrayList;
        frsTabInfoData.selectedTabId = i;
        return frsTabInfoData;
    }

    @Override // com.baidu.tieba.frs.ao
    public void aYj() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void mY(boolean z) {
        this.hzZ = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z) {
        this.hzK.uv(8);
        ((FrsActivity) getActivity()).showLoadingView(view, z);
        ((FrsActivity) getActivity()).j(view, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        this.hzK.uv(0);
        ((FrsActivity) getActivity()).hideLoadingView(view);
        ((FrsActivity) getActivity()).j(view, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        super.showNetRefreshView(view, getResources().getString(R.string.refresh_view_title_text), null, getResources().getString(R.string.refresh_view_button_text), z, getNetRefreshListener());
        this.hzK.uv(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshViewNoClick(View view, String str, boolean z) {
        super.showNetRefreshViewNoClick(view, str, z);
        this.hzK.uv(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        super.hideNetRefreshView(view);
        this.hzK.uv(0);
    }

    public void bYI() {
        FrsTabViewController.b cfQ;
        if (this.hAe != null && (cfQ = this.hAe.cfQ()) != null && cfQ.fragment != null && (cfQ.fragment instanceof aq)) {
            ((aq) cfQ.fragment).bXH();
        }
    }

    public void mZ(boolean z) {
        this.hzA = z;
    }

    public void b(OvalActionButton ovalActionButton) {
        this.hzL = ovalActionButton;
    }

    public OvalActionButton bYJ() {
        return this.hzL;
    }

    public boolean bYK() {
        return this.hzA;
    }

    public void onShareSuccess(String str) {
        if (TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.util.ar.isEmpty(str)) {
            if (this.hAC == null) {
                this.hAC = new AddExperiencedModel(getTbPageContext());
            }
            this.hAC.fq(this.forumId, str);
        }
    }

    public boolean bYL() {
        if (this.hzZ && !this.hAF) {
            return (this.hAc != null && this.hAc.cdO() && (b.bXd().bWX() || com.baidu.tieba.frs.a.bWW().bWX())) ? false : true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.f.c
    public boolean videoNeedPreload() {
        if (this.hzi != null) {
            return com.baidu.tbadk.util.ag.og(2) || (com.baidu.tbadk.util.ag.bji() && this.hzi.isFrsVideoAutoPlay);
        }
        return super.videoNeedPreload();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.f.c
    public boolean isCyberVideoUsedThisPage() {
        return com.baidu.tbadk.a.b.uL("cyber_player_test") || com.baidu.tbadk.a.b.uK("cyber_player_test");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYM() {
        if (!com.baidu.tbadk.core.util.ar.isEmpty(this.forumId)) {
            com.baidu.tbadk.BdToken.c.aMo().q(com.baidu.tbadk.BdToken.b.dyC, com.baidu.adp.lib.f.b.toLong(this.forumId, 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYN() {
        String format;
        String str;
        if (isResumed() && this.hAJ != null && this.hAJ.size() >= 1 && this.hAI <= this.hAJ.size() - 1) {
            final LiveHorseRaceData liveHorseRaceData = this.hAJ.get(this.hAI);
            if (System.currentTimeMillis() / 1000 >= liveHorseRaceData.getRob_end_tm().longValue()) {
                this.hAI++;
                bYN();
            }
            if (this.hzN != null) {
                final FrsRedpackRunView frsRedpackRunView = new FrsRedpackRunView(getActivity());
                if (liveHorseRaceData.getUser_nickname() == null || TextUtils.isEmpty(liveHorseRaceData.getUser_nickname())) {
                    format = String.format(getResources().getString(R.string.live_horserace_red_envelope), getResources().getString(R.string.frs_horse_none_title_verser));
                } else if (liveHorseRaceData.getUser_nickname().length() > 4) {
                    format = String.format(getResources().getString(R.string.live_horserace_red_envelope), liveHorseRaceData.getUser_nickname().substring(0, 4) + StringHelper.STRING_MORE);
                } else {
                    format = String.format(getResources().getString(R.string.live_horserace_red_envelope), liveHorseRaceData.getUser_nickname());
                }
                frsRedpackRunView.settextTitle(format + format + format);
                frsRedpackRunView.setClickliner(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.44
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        String str2;
                        if (FrsFragment.this.hzi == null) {
                            str2 = "";
                        } else if (FrsFragment.this.hzi.getForum() != null) {
                            str2 = FrsFragment.this.hzi.getForum().getName();
                        } else {
                            str2 = "";
                        }
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c13744").ag("obj_source", 1).dk("fid", FrsFragment.this.forumId).dk("fname", str2));
                        AlaInfoData alaInfoData = new AlaInfoData();
                        if (liveHorseRaceData.getLive_id() != null) {
                            alaInfoData.live_id = liveHorseRaceData.getLive_id().longValue();
                            alaInfoData.screen_direction = liveHorseRaceData.getScreen_direction().intValue();
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.fillWithInfoData(alaInfoData);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(FrsFragment.this.getContext(), alaLiveInfoCoreData, "live_paomadeng", FrsFragment.this.forumId)));
                        }
                    }
                });
                final ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
                ofFloat.setDuration(600L);
                ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.FrsFragment.46
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        if (valueAnimator.isRunning()) {
                            frsRedpackRunView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                            frsRedpackRunView.setTranslationX(-(TbadkApplication.getInst().getContext().getResources().getDimensionPixelOffset(R.dimen.tbds850) * valueAnimator.getAnimatedFraction()));
                        }
                    }
                });
                ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.FrsFragment.47
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        frsRedpackRunView.setAlpha(0.0f);
                        frsRedpackRunView.setTranslationY(TbadkApplication.getInst().getContext().getResources().getDimensionPixelOffset(R.dimen.tbds660));
                        frsRedpackRunView.hide();
                        FrsFragment.this.hzN.removeView(frsRedpackRunView);
                        if (FrsFragment.this.hAI > FrsFragment.this.hAJ.size() - 1) {
                            FrsFragment.this.hzN.removeAllViews();
                            FrsFragment.this.hzN.setVisibility(8);
                            FrsFragment.this.hAI = 0;
                            return;
                        }
                        FrsFragment.this.bYN();
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        onAnimationEnd(animator);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                frsRedpackRunView.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.48
                    @Override // java.lang.Runnable
                    public void run() {
                        if (FrsFragment.this.hzN != null && frsRedpackRunView != null) {
                            ofFloat.start();
                        }
                    }
                }, 5000L);
                if (this.hzN.getChildCount() == 0) {
                    this.hAI++;
                    this.hzN.addView(frsRedpackRunView);
                    if (this.hzi != null) {
                        str = this.hzi.getForum() != null ? this.hzi.getForum().getName() : "";
                    } else {
                        str = "";
                    }
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c13743").ag("obj_source", 1).dk("fid", this.forumId).dk("fname", str));
                }
                if (this.hzN.getVisibility() == 8 && ((BaseFragment) this.hAe.cfQ().fragment).isPrimary() && !this.hzK.bZJ() && !this.hzT) {
                    this.hzN.setVisibility(0);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        FrsTabViewController.b cfQ;
        if (bXY() == null || (cfQ = bXY().cfQ()) == null || !(cfQ.fragment instanceof BaseFragment)) {
            return null;
        }
        if (cfQ.fragment instanceof FrsAllThreadFragment) {
            TbPageTag tbPageTag = super.getTbPageTag();
            int i = -1;
            if (this.hzi != null) {
                i = this.hzi.getSortType();
            }
            tbPageTag.sortType = com.baidu.tieba.frs.f.g.vX(i);
            tbPageTag.locatePage = "a070";
            if (this.hzv.equals(cfQ.title)) {
                tbPageTag.locatePage = "a071";
            }
            return tbPageTag;
        } else if (cfQ.fragment instanceof FrsFragment) {
            return null;
        } else {
            return ((BaseFragment) cfQ.fragment).getTbPageTag();
        }
    }

    public void bYO() {
        if (this.hzi != null) {
            com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
            if (this.hzi.needLog == 1) {
                bVar.hWM = true;
            } else {
                bVar.hWM = false;
            }
            if (this.hzi.getForum() != null) {
                bVar.hWO = this.hzi.getForum().getId();
            }
            if (bXV() != null) {
                bVar.hWN = bXV().cdS();
            }
            if (com.baidu.tieba.frs.d.d.hIE != null) {
                bVar.hWP = com.baidu.tieba.frs.d.d.hIE.hWP;
                bVar.hWQ = com.baidu.tieba.frs.d.d.hIE.hWQ;
            }
            this.hAK = new com.baidu.tieba.frs.live.b(bVar, getTbPageTag(), getUniqueId());
            this.hAK.vA(this.hAL);
            CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_CARD_CLICK, this.hAK);
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
            CustomMessageTask customMessageTask2 = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW, this.hAK);
            customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask2);
            CustomMessageTask customMessageTask3 = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_USER_CLICK, this.hAK);
            customMessageTask3.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask3);
            CustomMessageTask customMessageTask4 = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_VIDEO_CLICK, this.hAK);
            customMessageTask4.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask4);
        }
    }
}
