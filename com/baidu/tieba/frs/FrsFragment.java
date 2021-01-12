package com.baidu.tieba.frs;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.a.a;
import com.baidu.l.a.a;
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
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AchievementActivityConfig;
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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.coreExtra.messageCenter.NewsRemindMessage;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tbadk.mutiprocess.event.TopToastEvent;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.widget.FRSRefreshButton;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.e;
import com.baidu.tieba.R;
import com.baidu.tieba.deletethread.DeleteThreadHttpResponseMessage;
import com.baidu.tieba.frs.HorseRace.GetLiveHorseRaceHttpResponseMessage;
import com.baidu.tieba.frs.HorseRace.GetLiveHorseRaceSocketResponseMessage;
import com.baidu.tieba.frs.HorseRace.LiveHorseRaceData;
import com.baidu.tieba.frs.HorseRace.LiveHorseRaceRequestMessage;
import com.baidu.tieba.frs.broadcast.ForumManagerRightsResMsg;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.good.FrsGoodFragment;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.frs.mc.FrsNewAreaFragment;
import com.baidu.tieba.frs.vc.FrsTabViewController;
import com.baidu.tieba.frs.view.FrsBroadcastCopyGuideDialogView;
import com.baidu.tieba.frs.view.FrsHeaderViewContainer;
import com.baidu.tieba.frs.view.FrsRedpackRunView;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.ScreenTopToast;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsPage.RecmForumInfo;
import tbclient.FrsTabInfo;
import tbclient.WindowToast;
/* loaded from: classes2.dex */
public class FrsFragment extends BaseFragment implements BdListView.e, a.InterfaceC0148a, UserIconBox.a<BdRecyclerView>, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, am, ap, as, com.baidu.tieba.frs.loadmore.a, com.baidu.tieba.frs.mc.l, com.baidu.tieba.recapp.p {
    public static com.baidu.tieba.tbadkCore.m jaF;
    private com.baidu.tbadk.util.x fKY;
    private com.baidu.adp.lib.d.b<TbImageView> fjw;
    private com.baidu.tieba.funad.a funAdController;
    private com.baidu.tieba.frs.gametab.b gSX;
    private com.baidu.tbadk.core.dialog.a itE;
    private VoiceManager jaA;
    private OvalActionButton jaC;
    private FRSRefreshButton jaD;
    private LinearLayout jaE;
    public long jaG;
    private String jaQ;
    private ThreadCardViewHolder jaS;
    private FrsModelController jaT;
    private com.baidu.tieba.frs.vc.h jaU;
    private FrsTabViewController jaV;
    private com.baidu.tieba.frs.mc.h jaW;
    private com.baidu.tieba.frs.smartsort.a jaX;
    private com.baidu.tieba.frs.mc.b jaY;
    private at jaZ;
    private com.baidu.tieba.frs.entelechy.a jan;
    private com.baidu.tieba.tbadkCore.data.f jax;
    private List<LiveHorseRaceData> jbA;
    private ValueAnimator jbB;
    private Runnable jbC;
    private com.baidu.tieba.frs.live.b jbD;
    private com.baidu.tieba.frs.broadcast.a jbE;
    private int jbF;
    private com.baidu.tieba.frs.d.e jbG;
    private int jbQ;
    private com.baidu.tieba.frs.entelechy.a.b jbb;
    private com.baidu.tieba.frs.vc.a jbc;
    private com.baidu.tieba.frs.mc.d jbd;
    private com.baidu.tieba.frs.mc.c jbe;
    private com.baidu.tieba.frs.vc.j jbf;
    private com.baidu.tieba.frs.mc.a jbg;
    private com.baidu.tieba.frs.live.a jbh;
    private p jbi;
    public com.baidu.tieba.frs.vc.c jbj;
    private com.baidu.tieba.frs.mc.e jbk;
    private View.OnTouchListener jbl;
    private com.baidu.tieba.frs.view.a jbm;
    private com.baidu.tieba.frs.vc.e jbn;
    private boolean jbo;
    private com.baidu.tieba.NEGFeedBack.a jbp;
    private com.baidu.tieba.ala.b jbq;
    private com.baidu.tieba.frs.brand.buttommenu.a jbr;
    private com.baidu.tieba.frs.sportspage.notification.a jbs;
    private AddExperiencedModel jbt;
    private boolean jbv;
    private View mRootView;
    private String mSchemeUrl;
    public static boolean jas = false;
    public static volatile long jaI = 0;
    public static volatile long jaJ = 0;
    public static volatile int mNetError = 0;
    private String jam = "";
    public boolean jao = false;
    private boolean jap = false;
    private boolean jaq = false;
    private boolean jar = true;
    public String jat = null;
    public String mFrom = null;
    public int mFlag = 0;
    public boolean jau = false;
    private boolean jav = false;
    private String mThreadId = null;
    public String forumId = null;
    private int jac = 0;
    private boolean jaw = false;
    private boolean jay = false;
    private boolean jaz = false;
    private q jaB = null;
    public final bz ale = null;
    private FrsViewData jaa = new FrsViewData();
    public long iDg = -1;
    public long fHj = 0;
    public long fHa = 0;
    public long createTime = 0;
    public long fHb = 0;
    public long fHg = 0;
    public long jaH = 0;
    boolean jaK = false;
    public boolean jaL = false;
    private boolean jaM = false;
    public com.baidu.tbadk.n.b jaN = null;
    private boolean jaO = true;
    private boolean jaP = true;
    private a.C0089a jaR = new a.C0089a(2);
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> jba = new SparseArray<>();
    private boolean gAr = true;
    private boolean hasInit = false;
    private boolean jbu = false;
    private boolean jbw = false;
    private Date jbx = null;
    private int dTc = 0;
    private int jby = 0;
    private int jbz = 0;
    public int mHeadLineDefaultNavTabId = -1;
    MessageQueue.IdleHandler jbH = new MessageQueue.IdleHandler() { // from class: com.baidu.tieba.frs.FrsFragment.1
        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            FrsFragment.this.cBw();
            return false;
        }
    };
    private final CustomMessageListener jbI = new CustomMessageListener(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED) { // from class: com.baidu.tieba.frs.FrsFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof bz) {
                    com.baidu.tieba.frs.d.k.a(FrsFragment.this.jaB, FrsFragment.this.jaa, FrsFragment.this.getForumId(), true, (bz) data);
                }
            }
        }
    };
    private CustomMessageListener jbJ = new CustomMessageListener(CmdConfigCustom.CMD_CLOSE_GAME_RANK_CARD) { // from class: com.baidu.tieba.frs.FrsFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.jaa != null) {
                FrsFragment.this.jaa.removeGameRankListFromThreadList();
                if (FrsFragment.this.jaB != null) {
                    FrsFragment.this.jaB.bbp();
                }
            }
        }
    };
    private CustomMessageListener ahx = new CustomMessageListener(2921401) { // from class: com.baidu.tieba.frs.FrsFragment.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && FrsFragment.this.jaD != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() <= 0 || FrsFragment.this.jaV.cKC() == 0 || FrsFragment.this.jaV.cKz() == null || !(FrsFragment.this.jaV.cKz().fragment instanceof BaseFragment) || !((BaseFragment) FrsFragment.this.jaV.cKz().fragment).isPrimary() || FrsFragment.this.jaB.cCT() || com.baidu.tbadk.k.d.bCj().bCk()) {
                    if (FrsFragment.this.jaV.cKC() != 0) {
                        FrsFragment.this.jaD.hide();
                        return;
                    }
                    return;
                }
                FrsFragment.this.jaD.show();
            }
        }
    };
    private CustomMessageListener jbK = new CustomMessageListener(2921473) { // from class: com.baidu.tieba.frs.FrsFragment.45
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && FrsFragment.this.jaD != null && FrsFragment.this.jaC != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() == 0) {
                    FrsFragment.this.jaD.setVisibility(8);
                    FrsFragment.this.jaC.setVisibility(8);
                    return;
                }
                FrsFragment.this.jaC.setVisibility(0);
            }
        }
    };
    private CustomMessageListener jbL = new CustomMessageListener(2921467) { // from class: com.baidu.tieba.frs.FrsFragment.56
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && FrsFragment.this.jaD != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() <= 0 || FrsFragment.this.jaV.cKz() == null || !(FrsFragment.this.jaV.cKz().fragment instanceof BaseFragment) || !((BaseFragment) FrsFragment.this.jaV.cKz().fragment).isPrimary() || FrsFragment.this.jaB.cCT()) {
                    FrsFragment.this.jaE.setVisibility(8);
                    FrsFragment.this.jaK = true;
                    return;
                }
                FrsFragment.this.jaE.setVisibility(0);
                FrsFragment.this.jaK = false;
            }
        }
    };
    private com.baidu.adp.framework.listener.a jbM = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_FRS_LIVE_HORSE_RACE_LIST, 309667) { // from class: com.baidu.tieba.frs.FrsFragment.64
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if ((responsedMessage instanceof GetLiveHorseRaceHttpResponseMessage) || (responsedMessage instanceof GetLiveHorseRaceSocketResponseMessage)) {
                    List<LiveHorseRaceData> arrayList = new ArrayList<>();
                    if (responsedMessage instanceof GetLiveHorseRaceHttpResponseMessage) {
                        arrayList = ((GetLiveHorseRaceHttpResponseMessage) responsedMessage).getData().cDv();
                    }
                    if (responsedMessage instanceof GetLiveHorseRaceSocketResponseMessage) {
                        arrayList = ((GetLiveHorseRaceSocketResponseMessage) responsedMessage).getData().cDv();
                    }
                    if (FrsFragment.this.jbA != null) {
                        if (FrsFragment.this.jaE == null || FrsFragment.this.jaE.getVisibility() != 8) {
                            if (FrsFragment.this.jbz >= FrsFragment.this.jbA.size()) {
                                FrsFragment.this.jbA.addAll(arrayList);
                                return;
                            }
                            FrsFragment.this.jbA = FrsFragment.this.jbA.subList(0, FrsFragment.this.jbz);
                            FrsFragment.this.jbA.addAll(arrayList);
                            return;
                        }
                        FrsFragment.this.jbA = new ArrayList();
                        FrsFragment.this.jbA.addAll(arrayList);
                        FrsFragment.this.jbz = 0;
                        FrsFragment.this.cBY();
                        return;
                    }
                    FrsFragment.this.jbA = new ArrayList();
                    FrsFragment.this.jbz = 0;
                    FrsFragment.this.jbA.addAll(arrayList);
                    FrsFragment.this.cBY();
                }
            }
        }
    };
    private CustomMessageListener jbN = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.FrsFragment.65
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 1) {
                    FrsFragment.this.cBA();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                }
            }
        }
    };
    private final ar jbO = new ar() { // from class: com.baidu.tieba.frs.FrsFragment.66
        @Override // com.baidu.tieba.frs.ar
        public void a(int i, int i2, ba baVar, ArrayList<com.baidu.adp.widget.ListView.n> arrayList) {
            FrsFragment.this.cBl();
            if (FrsFragment.this.jbb != null) {
                FrsFragment.this.jaU.rt(FrsFragment.this.jbb.zc(i));
            }
            com.baidu.tieba.tbadkCore.f fVar = new com.baidu.tieba.tbadkCore.f();
            if (baVar != null) {
                fVar.isSuccess = baVar.errCode == 0;
                fVar.errorCode = baVar.errCode;
                fVar.errorMsg = baVar.errMsg;
                if (fVar.isSuccess) {
                    if (com.baidu.tbadk.core.util.x.isEmpty(arrayList)) {
                        FrsFragment.this.jaB.bRO();
                    } else if (baVar.hasMore) {
                        if (com.baidu.tbadk.core.util.x.getCount(FrsFragment.this.jaa.getThreadList()) > 3) {
                            FrsFragment.this.jaB.Vo();
                        } else {
                            FrsFragment.this.jaB.cCK();
                        }
                    } else if (baVar.jfA) {
                        FrsFragment.this.jaB.Vp();
                    } else {
                        FrsFragment.this.jaB.bRO();
                    }
                }
            } else {
                baVar = new ba();
                baVar.pn = 1;
                baVar.hasMore = false;
                baVar.jfA = false;
            }
            if (i == 1) {
                FrsFragment.this.jaO = true;
                FrsFragment.this.jcg.a(FrsFragment.this.jaT.getType(), false, fVar);
            } else {
                FrsFragment.this.a(fVar);
                if (FrsFragment.this.jaT.cHO() != null) {
                    FrsFragment.this.jaa = FrsFragment.this.jaT.cHO();
                }
                FrsFragment.this.cBC();
            }
            if (FrsFragment.this.jco != null) {
                FrsFragment.this.jco.a(i, i2, baVar, arrayList);
            }
        }
    };
    private FrsTabViewController.a jbP = new FrsTabViewController.a() { // from class: com.baidu.tieba.frs.FrsFragment.2
        @Override // com.baidu.tieba.frs.vc.FrsTabViewController.a
        public void m(int i, int i2, String str) {
            boolean z = false;
            if (i != 1) {
                com.baidu.tieba.card.s.crj().pr(false);
                FrsFragment.this.qk(false);
            }
            if (i == 502) {
                FrsFragment.this.jaC.setIconFade(R.drawable.btn_frs_professional_edit_n);
            } else {
                FrsFragment.this.jaC.setIconFade(0);
            }
            FrsFragment.this.jbQ = i;
            FrsFragment.this.jbF = i2;
            if (FrsFragment.this.jbD != null) {
                FrsFragment.this.jbD.zO(FrsFragment.this.jbF);
            }
            TbSingleton.getInstance().setFrsCurTabType(FrsFragment.this.jbF);
            FrsFragment.this.cBI();
            com.baidu.tieba.frs.b.d.jkJ.jBJ = i;
            com.baidu.tieba.frs.b.d.jkJ.jBM = i2;
            com.baidu.tieba.frs.b.d.jkJ.jBK = -1;
            b.cAg().X(i == 1 && FrsFragment.this.jbu, true);
            com.baidu.tieba.frs.a czZ = com.baidu.tieba.frs.a.czZ();
            if (i == 1 && FrsFragment.this.jbu) {
                z = true;
            }
            czZ.X(z, true);
        }
    };
    private CustomMessageListener jbR = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIVE_COUNT) { // from class: com.baidu.tieba.frs.FrsFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                FrsFragment.this.jaV.Ay(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    };
    private CustomMessageListener jbS = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_LIVE_START) { // from class: com.baidu.tieba.frs.FrsFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && ((Integer) customResponsedMessage.getData()).intValue() == 51 && FrsFragment.this.jaa != null) {
                com.baidu.tieba.frs.d.m.a(FrsFragment.this.jaa, FrsFragment.this.getPageContext());
            }
        }
    };
    private final CustomMessageListener jbT = new CustomMessageListener(CmdConfigCustom.CMD_FRS_SELECT_ALA_LIVE_TAB) { // from class: com.baidu.tieba.frs.FrsFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                FrsFragment.this.jaV.sO(49);
            }
        }
    };
    private final CustomMessageListener jbU = new CustomMessageListener(2921470) { // from class: com.baidu.tieba.frs.FrsFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                FrsFragment.this.jaV.sO(1);
                FrsFragment.this.cBA();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
            }
        }
    };
    private final CustomMessageListener jbV = new CustomMessageListener(CmdConfigCustom.CMD_FRS_EXPERIENCE_TIP) { // from class: com.baidu.tieba.frs.FrsFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.w) && FrsFragment.this.jaa != null) {
                FrsFragment.this.jaa.updateLikeData((com.baidu.tieba.tbadkCore.w) customResponsedMessage.getData());
                FrsFragment.this.jaU.j(FrsFragment.this.jaa);
                FrsFragment.this.jaV.a(FrsFragment.this.jaa, FrsFragment.this.jaT.cIs());
            }
        }
    };
    private final AntiHelper.a jbW = new AntiHelper.a() { // from class: com.baidu.tieba.frs.FrsFragment.8
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).an("obj_locate", ax.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).an("obj_locate", ax.a.LOCATE_LIKE_PERSON));
        }
    };
    private CustomMessageListener jbX = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.FrsFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(FrsFragment.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().fqk != null) {
                        if (AntiHelper.a(FrsFragment.this.getActivity(), updateAttentionMessage.getData().fqk, FrsFragment.this.jbW) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).an("obj_locate", ax.a.LOCATE_LIKE_PERSON));
                        }
                    } else if (updateAttentionMessage.getData().isSucc && updateAttentionMessage.getData().isAttention) {
                        com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getPageContext().getPageActivity(), R.string.attention_success);
                    }
                }
            }
        }
    };
    private CustomMessageListener jbY = new CustomMessageListener(CmdConfigCustom.CMD_GET_ENSURE_CAST_ID) { // from class: com.baidu.tieba.frs.FrsFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsFragment.this.refresh();
        }
    };
    private CustomMessageListener jbZ = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.frs.FrsFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                FrsFragment.this.jaB.c((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener jca = new CustomMessageListener(2001378) { // from class: com.baidu.tieba.frs.FrsFragment.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof WriteData) && com.baidu.tbadk.core.util.at.equals(((WriteData) customResponsedMessage.getData()).getForumId(), FrsFragment.this.forumId)) {
                FrsFragment.this.jbg.zQ(((WriteData) customResponsedMessage.getData()).getTabId());
                MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
            }
        }
    };
    private CustomMessageListener jcb = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_REMIND) { // from class: com.baidu.tieba.frs.FrsFragment.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626) {
                NewsRemindMessage newsRemindMessage = (NewsRemindMessage) customResponsedMessage;
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (FrsFragment.this.jaB != null) {
                    FrsFragment.this.jaB.P(notificationCount, z);
                }
            }
        }
    };
    private HttpMessageListener jcc = new HttpMessageListener(CmdConfigHttp.CMD_FRS_MOVE_AREA) { // from class: com.baidu.tieba.frs.FrsFragment.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int i;
            int i2 = 0;
            if (httpResponsedMessage != null && FrsFragment.this.getContext() != null && FrsFragment.this.jaB != null) {
                if (httpResponsedMessage.getError() == 0) {
                    new BdTopToast(FrsFragment.this.getContext()).yS(true).TP(FrsFragment.this.getContext().getString(R.string.frs_move_area_move_suc)).aR(FrsFragment.this.jaB.cmp());
                    if (com.baidu.tieba.frs.a.czZ().yj(com.baidu.tieba.frs.a.czZ().cAb())) {
                        FrsCommonTabFragment frsCommonTabFragment = null;
                        if (FrsFragment.this.jaV != null && FrsFragment.this.jaV.cKz() != null && (FrsFragment.this.jaV.cKz().fragment instanceof FrsCommonTabFragment)) {
                            frsCommonTabFragment = (FrsCommonTabFragment) FrsFragment.this.jaV.cKz().fragment;
                        }
                        if (frsCommonTabFragment != null) {
                            frsCommonTabFragment.cEp();
                        }
                        FrsFragment.this.cAe();
                        com.baidu.tieba.frs.a.czZ().cAe();
                        Iterator<com.baidu.adp.widget.ListView.n> it = FrsFragment.this.jaa.getThreadList().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                i = i2;
                                break;
                            }
                            i = it.next() instanceof by ? i2 + 1 : i2;
                            if (i >= 6) {
                                break;
                            }
                            i2 = i;
                        }
                        if (i < 6) {
                            FrsFragment.this.bQy();
                        }
                    }
                    com.baidu.tieba.frs.a.czZ().reset();
                    return;
                }
                new BdTopToast(FrsFragment.this.getContext()).yS(false).TP(httpResponsedMessage.getErrorString()).aR(FrsFragment.this.jaB.cmp());
            }
        }
    };
    private com.baidu.tbadk.mutiprocess.h mTopToastEventListener = new com.baidu.tbadk.mutiprocess.h<TopToastEvent>() { // from class: com.baidu.tieba.frs.FrsFragment.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.mutiprocess.b
        public boolean a(TopToastEvent topToastEvent) {
            new BdTopToast(FrsFragment.this.getContext()).yS(topToastEvent.isSuccess()).TP(topToastEvent.getContent()).aR(FrsFragment.this.jaB.cmp());
            return false;
        }
    };
    private final CustomMessageListener jcd = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.frs.FrsFragment.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.isResumed()) {
                FrsFragment.this.cBX();
            }
        }
    };
    private CustomMessageListener jce = new CustomMessageListener(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER) { // from class: com.baidu.tieba.frs.FrsFragment.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (FrsFragment.this.jaB != null) {
                    FrsFragment.this.jaB.setExpanded(booleanValue);
                }
            }
        }
    };
    private final CustomMessageListener jcf = new CustomMessageListener(2921463) { // from class: com.baidu.tieba.frs.FrsFragment.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TbadkApplication.getInst().getCurrentActivity() != null && !com.baidu.tbadk.core.util.at.isEmpty(str) && str.equals(FrsFragment.this.forumId)) {
                    com.baidu.tieba.frs.d.h.b(((TbPageContextSupport) TbadkApplication.getInst().getCurrentActivity()).getPageContext(), FrsFragment.this.jaa);
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.s jcg = new com.baidu.tieba.tbadkCore.s() { // from class: com.baidu.tieba.frs.FrsFragment.20
        private long startTime = 0;

        @Override // com.baidu.tieba.tbadkCore.s
        public void yq(int i) {
            this.startTime = System.nanoTime();
            if (FrsFragment.this.jaB != null) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsFragment.this.jaB.cCv();
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

        @Override // com.baidu.tieba.tbadkCore.s
        public void a(int i, boolean z, com.baidu.tieba.tbadkCore.f fVar) {
            if (FrsFragment.this.gAr) {
                FrsFragment.this.gAr = false;
                com.baidu.tieba.frs.d.k.a(FrsFragment.this.jaB, FrsFragment.this.jaa, FrsFragment.this.getForumId(), false, null);
            }
            FrsFragment.this.cBl();
            FrsFragment.this.jaM = true;
            if (fVar != null && fVar.isSuccess) {
                FrsFragment.this.jaB.cCI().qV(com.baidu.tbadk.core.util.au.bsy().bsz());
                FrsFragment.jaI = 0L;
                FrsFragment.jaJ = 0L;
                FrsFragment.mNetError = 0;
            } else {
                FrsFragment.mNetError = 1;
            }
            if (!FrsFragment.this.jaT.cIx() && (i == 3 || i == 6)) {
                FrsFragment.this.jbe.resetData();
            }
            FrsFragment.this.jaG = System.currentTimeMillis();
            if (FrsFragment.this.jaT.cHO() != null) {
                FrsFragment.this.jaa = FrsFragment.this.jaT.cHO();
            }
            FrsFragment.this.ym(1);
            FrsFragment.this.cBt();
            if (i == 7) {
                FrsFragment.this.yn(FrsFragment.this.jaa.getFrsDefaultTabId());
                return;
            }
            if (FrsFragment.this.jaa.getPage() != null) {
                FrsFragment.this.setHasMore(FrsFragment.this.jaa.getPage().bmm());
            }
            if (i == 4) {
                if (!FrsFragment.this.jaT.cIx() && TbadkCoreApplication.getInst().isRecAppExist() && FrsFragment.this.jaT.cIn() == 1 && !com.baidu.tieba.funad.a.cLz()) {
                    FrsFragment.this.jaa.addRecommendAppToThreadList(FrsFragment.this);
                }
                ArrayList<com.baidu.adp.widget.ListView.n> a2 = FrsFragment.this.jbe.a(false, false, FrsFragment.this.jaa.getThreadList(), FrsFragment.this.jax, false);
                if (a2 != null) {
                    FrsFragment.this.jaa.setThreadList(a2);
                    FrsFragment.this.jaa.checkLiveStageInThreadList();
                }
                if (FrsFragment.this.jaT != null) {
                    com.baidu.tieba.frs.b.c.a(FrsFragment.this.jaa, FrsFragment.this.jaT.cIs(), 2, FrsFragment.this.getContext());
                }
                com.baidu.tieba.frs.d.a.a(FrsFragment.this, FrsFragment.this.jaa.getForum(), FrsFragment.this.jaa.getThreadList(), false, FrsFragment.this.getPn());
                FrsFragment.this.jaB.a(a2, FrsFragment.this.jaa);
                FrsFragment.this.cBm();
                return;
            }
            FrsFragment.this.cBm();
            switch (i) {
                case 1:
                    FrsFragment.this.jaB.cCv();
                    break;
                case 2:
                    FrsFragment.this.jaB.cCv();
                    break;
                case 3:
                case 6:
                    if (FrsFragment.this.jaa != null) {
                        FrsFragment.this.jaa.clearPostThreadCount();
                    }
                    if (FrsFragment.this.jbj != null) {
                        FrsFragment.this.jbj.refresh();
                        break;
                    }
                    break;
            }
            FrsFragment.this.cBu();
            if (fVar == null || fVar.errorCode == 0) {
                if (FrsFragment.this.jaa != null) {
                    FrsFragment.this.a(FrsFragment.this.jaa);
                    FrsFragment.this.Z(false, i == 5);
                    if (FrsFragment.this.jaT != null) {
                        if (FrsFragment.this.jaa.getActivityHeadData() != null && FrsFragment.this.jaa.getActivityHeadData().blz() != null && FrsFragment.this.jaa.getActivityHeadData().blz().size() > 0) {
                            com.baidu.tieba.frs.b.a.a(FrsFragment.this.getUniqueId(), 1, FrsFragment.this.jaa.getForum(), FrsFragment.this.jaT.getSortType(), 1);
                        }
                        if (FrsFragment.this.jaa.getThreadList() != null && FrsFragment.this.jaa.getThreadList().size() > 0) {
                            Iterator<com.baidu.adp.widget.ListView.n> it = FrsFragment.this.jaa.getThreadList().iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    com.baidu.adp.widget.ListView.n next = it.next();
                                    if ((next instanceof bz) && ((bz) next).getType() == bz.eQd) {
                                        com.baidu.tieba.frs.b.a.a(FrsFragment.this.getUniqueId(), 1, FrsFragment.this.jaa.getForum(), FrsFragment.this.jaT.getSortType(), 2);
                                    }
                                }
                            }
                        }
                        com.baidu.tieba.frs.b.a.a(FrsFragment.this.getUniqueId(), FrsFragment.this.jaa.getThreadList(), FrsFragment.this.jaa.getForum(), FrsFragment.this.jaT.getSortType());
                    }
                    FrsFragment.this.jaB.yD(i);
                    FrsFragment.jaI = (System.nanoTime() - this.startTime) / TimeUtils.NANOS_PER_MS;
                    if (fVar != null) {
                        FrsFragment.jaJ = fVar.nkx;
                    }
                } else {
                    return;
                }
            } else if (FrsFragment.this.jaa == null || com.baidu.tbadk.core.util.x.isEmpty(FrsFragment.this.jaa.getThreadList())) {
                FrsFragment.this.a(fVar);
            } else if (fVar.iKB) {
                FrsFragment.this.showToast(FrsFragment.this.getPageContext().getResources().getString(R.string.net_error_text, fVar.errorMsg, Integer.valueOf(fVar.errorCode)));
            }
            FrsFragment.this.cBq();
            FrsFragment.this.cBr();
            if (FrsFragment.this.jaa.getAccessFlag() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11384"));
            }
            if (FrsFragment.this.jay && FrsFragment.this.jaV.sO(49)) {
                FrsFragment.this.jay = false;
            }
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.s
        public void c(com.baidu.tieba.tbadkCore.m mVar) {
            if ((mVar != null && ("normal_page".equals(FrsFragment.this.jaT.getPageType()) || "frs_page".equals(FrsFragment.this.jaT.getPageType()) || "book_page".equals(FrsFragment.this.jaT.getPageType()))) || "brand_page".equals(FrsFragment.this.jaT.getPageType())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE, mVar));
                FrsFragment.this.b(mVar);
                FrsFragment.jaF = mVar;
            }
        }

        @Override // com.baidu.tieba.tbadkCore.s
        public void cBw() {
            FrsFragment.this.cBw();
        }
    };
    private final CustomMessageListener jch = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.frs.FrsFragment.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.n) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                FrsFragment.this.jaa.updateCurrentUserPendant((com.baidu.tbadk.data.n) customResponsedMessage.getData());
                FrsFragment.this.jaB.cCI().notifyDataSetChanged();
            }
        }
    };
    private final CustomMessageListener mMemListener = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_MEM) { // from class: com.baidu.tieba.frs.FrsFragment.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && FrsFragment.this.jaa != null && (userData = FrsFragment.this.jaa.getUserData()) != null) {
                userData.setIsMem(num.intValue());
                if (num.intValue() != 0) {
                    FrsFragment.this.jaU.q(num);
                }
            }
        }
    };
    private final f.a jci = new AnonymousClass31();
    private final com.baidu.tieba.frs.mc.k jcj = new com.baidu.tieba.frs.mc.k() { // from class: com.baidu.tieba.frs.FrsFragment.32
        @Override // com.baidu.tieba.frs.mc.k
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.n> arrayList, boolean z3) {
            if (FrsFragment.this.jaX != null && FrsFragment.this.jaT != null && FrsFragment.this.jaT.cIx() && z && !z2 && !z3) {
                FrsFragment.this.jaX.zV(i2);
            }
        }
    };
    public final View.OnTouchListener bPd = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.FrsFragment.33
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (FrsFragment.this.jbl != null) {
                FrsFragment.this.jbl.onTouch(view, motionEvent);
            }
            if (FrsFragment.this.jaZ != null && FrsFragment.this.jaZ.cDw() != null) {
                FrsFragment.this.jaZ.cDw().onTouchEvent(motionEvent);
            }
            if (FrsFragment.this.gSX != null) {
                FrsFragment.this.gSX.i(view, motionEvent);
            }
            if (FrsFragment.this.jaU != null) {
                FrsFragment.this.jaU.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private final CustomMessageListener jck = new CustomMessageListener(CmdConfigCustom.CMD_GOTOLIVE_HOST_UPGRADE) { // from class: com.baidu.tieba.frs.FrsFragment.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.brx().getInt(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.PHOTOLIVE_HOSTLEVEL, -1) != -1 && FrsFragment.this.jaa.getForum() != null) {
                FrsFragment.this.jaa.getForum().setCanAddPhotoLivePost(true);
            }
        }
    };
    public final View.OnClickListener jcl = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.41
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsFragment.this.jaB != null && view == FrsFragment.this.jaB.cCt() && FrsFragment.this.getActivity() != null) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, FrsFragment.this.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            if (view.getId() == R.id.game_activity_egg_layout && com.baidu.adp.lib.util.l.isNetOk()) {
                TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_CLICK);
                if (FrsFragment.this.jaB == null || !FrsFragment.this.jaB.cCF()) {
                    String activityUrl = FrsFragment.this.jaa.getForum().getYuleData().bpW().getActivityUrl();
                    if (!StringUtils.isNull(activityUrl)) {
                        com.baidu.tbadk.browser.a.startInternalWebActivity(FrsFragment.this.getPageContext().getPageActivity(), activityUrl);
                    }
                } else {
                    FrsFragment.this.jaB.cCG();
                }
            }
            if (FrsFragment.this.jaB != null && view == FrsFragment.this.jaB.cCL() && FrsFragment.this.jaT != null && FrsFragment.this.jaT.hasMore()) {
                FrsFragment.this.jaB.Vo();
                FrsFragment.this.bQy();
            }
            if (view != null && FrsFragment.this.jaB != null && view == FrsFragment.this.jaB.cCC()) {
                if (bg.checkUpIsLogin(FrsFragment.this.getContext())) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).an("obj_locate", 2));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MessageCenterActivityConfig(FrsFragment.this.getContext())));
                } else {
                    return;
                }
            }
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (FrsFragment.this.jaa != null && FrsFragment.this.jaa.getForum() != null) {
                    if (FrsFragment.this.jaB != null && view == FrsFragment.this.jaB.cCA()) {
                        if (FrsFragment.this.jaa != null && FrsFragment.this.jaa.getForum() != null && !StringUtils.isNull(FrsFragment.this.jaa.getForum().getId()) && !StringUtils.isNull(FrsFragment.this.jaa.getForum().getName())) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_SHARE_CLICK).dW("fid", FrsFragment.this.jaa.getForum().getId()).an("obj_locate", 11));
                            com.baidu.tieba.frs.d.h.a(FrsFragment.this.getPageContext(), FrsFragment.this.jaa, FrsFragment.this.jaa.getForum().getId());
                        } else {
                            return;
                        }
                    }
                    if (FrsFragment.this.jaB != null && view == FrsFragment.this.jaB.cCz()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12402").dW("fid", FrsFragment.this.jaa.getForum().getId()).dW("uid", TbadkCoreApplication.getCurrentAccount()).dW("fname", FrsFragment.this.jaa.getForum().getName()));
                        if (!StringUtils.isNull(FrsFragment.this.jaa.getForum().getName())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PostSearchActivityConfig(FrsFragment.this.getContext(), FrsFragment.this.jaa.getForum().getName(), FrsFragment.this.jaa.getForum().getId())));
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getContext().getApplicationContext(), R.string.network_not_available);
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.FrsFragment.42
        private int jcJ = 0;
        private int gwh = 0;

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsFragment.this.jby += i2;
            if (FrsFragment.this.jby >= FrsFragment.this.dTc * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
            if (FrsFragment.this.jbc != null) {
                FrsFragment.this.jbc.cJt();
            }
            this.jcJ = 0;
            this.gwh = 0;
            if (recyclerView != null && (recyclerView instanceof BdRecyclerView)) {
                this.jcJ = ((BdRecyclerView) recyclerView).getFirstVisiblePosition();
                this.gwh = ((BdRecyclerView) recyclerView).getLastVisiblePosition();
            }
            if (FrsFragment.this.jbn != null) {
                FrsFragment.this.jbn.a(recyclerView, this.jcJ, this.gwh);
            }
            if (FrsFragment.this.jaa != null && FrsFragment.this.jaB != null && FrsFragment.this.jaB.cCI() != null) {
                FrsFragment.this.jaB.cq(this.jcJ, this.gwh);
                if (FrsFragment.this.jaS != null && FrsFragment.this.jaS.tm() != null) {
                    FrsFragment.this.jaS.tm().b(FrsFragment.this.jaR);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (FrsFragment.this.jaU != null) {
                FrsFragment.this.jaU.setScrollState(i);
                if (i == 1) {
                    FrsFragment.this.jaU.cJU();
                }
            }
            if (FrsFragment.this.jaN == null && !FrsFragment.this.cBQ()) {
                FrsFragment.this.jaN = new com.baidu.tbadk.n.b();
                FrsFragment.this.jaN.setSubType(1000);
            }
            if (i == 0) {
                if (FrsFragment.this.jaN != null) {
                    FrsFragment.this.jaN.bDH();
                }
                com.baidu.tieba.card.s.crj().pr(true);
                FrsFragment.this.qk(true);
                FrsFragment.this.jaB.cp(this.jcJ, this.gwh);
            } else if (FrsFragment.this.jaN != null) {
                FrsFragment.this.jaN.bDG();
            }
            if (FrsFragment.this.jbn != null) {
                FrsFragment.this.jbn.onScrollStateChanged(recyclerView, i);
            }
            if (i == 0) {
                com.baidu.tieba.frs.d.k.a(FrsFragment.this.jaB, FrsFragment.this.jaa, FrsFragment.this.getForumId(), false, null);
            }
            if (FrsFragment.this.jaV != null && i == 1) {
                FrsFragment.this.jaV.cKB();
            }
            if (FrsFragment.this.jaS == null) {
                if (FrsFragment.this.jaB.cCm() != null && !FrsFragment.this.jaB.cBO() && FrsFragment.this.jaB.cCm().dxN() != null && (FrsFragment.this.jaB.cCm().dxN().getTag() instanceof ThreadCardViewHolder)) {
                    FrsFragment.this.jaS = (ThreadCardViewHolder) FrsFragment.this.jaB.cCm().dxN().getTag();
                }
            } else if (i == 0 && FrsFragment.this.jaB.cCm() != null && !FrsFragment.this.jaB.cBO() && FrsFragment.this.jaB.cCm().dxN() != null && (FrsFragment.this.jaB.cCm().dxN().getTag() instanceof ThreadCardViewHolder)) {
                FrsFragment.this.jaS = (ThreadCardViewHolder) FrsFragment.this.jaB.cCm().dxN().getTag();
            }
            if (i == 1) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921418));
            }
        }
    };
    private final f jcm = new f() { // from class: com.baidu.tieba.frs.FrsFragment.43
        @Override // com.baidu.tieba.frs.f
        public void a(int i, int i2, View view, View view2, bz bzVar) {
            if (i != FrsFragment.this.jaB.cCI().cFi()) {
                if (i != FrsFragment.this.jaB.cCI().cFj()) {
                    if (i == FrsFragment.this.jaB.cCI().cFg() && FrsFragment.this.jaa != null && FrsFragment.this.jaa.getUserData() != null && FrsFragment.this.jaa.getUserData().isBawu()) {
                        String bawuCenterUrl = FrsFragment.this.jaa.getBawuCenterUrl();
                        if (!com.baidu.tbadk.core.util.at.isEmpty(bawuCenterUrl) && FrsFragment.this.jaa.getForum() != null) {
                            com.baidu.tbadk.browser.a.startWebActivity(FrsFragment.this.getPageContext().getPageActivity(), bawuCenterUrl);
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10502").dW("fid", FrsFragment.this.jaa.getForum().getId()).dW("uid", FrsFragment.this.jaa.getUserData().getUserId()));
                        }
                    }
                } else if (bg.checkUpIsLogin(FrsFragment.this.getPageContext().getPageActivity())) {
                    TiebaStatic.log(CommonStatisticKey.MY_SERVICE_CK);
                    if (FrsFragment.this.jaa != null && FrsFragment.this.jaa.getForum() != null) {
                        ForumData forum = FrsFragment.this.jaa.getForum();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(forum.getId(), 0L), forum.getName(), forum.getImage_url(), 0)));
                    }
                }
            } else if (bg.checkUpIsLogin(FrsFragment.this.getActivity())) {
                TiebaStatic.log("forum_fortune_click");
                com.baidu.tieba.frs.d.l.c(FrsFragment.this.getPageContext(), FrsFragment.this.jaa);
            }
        }
    };
    private final NoNetworkView.a iXM = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.FrsFragment.44
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (FrsFragment.this.jaT.cIn() == 1 && z && !FrsFragment.this.jaB.cBO()) {
                if (FrsFragment.this.jaa == null || com.baidu.tbadk.core.util.x.isEmpty(FrsFragment.this.jaa.getThreadList())) {
                    FrsFragment.this.hideNetRefreshView(FrsFragment.this.jaB.cCW().cKp());
                    FrsFragment.this.showLoadingView(FrsFragment.this.jaB.cmp(), true);
                    FrsFragment.this.jaB.qv(false);
                    FrsFragment.this.refresh();
                    return;
                }
                FrsFragment.this.jaB.cCv();
            }
        }
    };
    private final CustomMessageListener fqC = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.FrsFragment.46
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                com.baidu.tieba.frs.d.c.a(customResponsedMessage, FrsFragment.this.jaB, FrsFragment.this.jaa);
            }
        }
    };
    private com.baidu.adp.widget.ListView.w jcn = new a();
    private ar jco = new ar() { // from class: com.baidu.tieba.frs.FrsFragment.48
        @Override // com.baidu.tieba.frs.ar
        public void a(int i, int i2, ba baVar, ArrayList<com.baidu.adp.widget.ListView.n> arrayList) {
            com.baidu.adp.lib.f.e.mB().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.48.1
                @Override // java.lang.Runnable
                public void run() {
                    if (FrsFragment.this.jaB != null && FrsFragment.this.jaB.cCO()) {
                        FrsFragment.this.bQy();
                    }
                }
            });
        }
    };
    private CustomMessageListener jcp = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.frs.FrsFragment.49
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    FrsFragment.this.jbo = true;
                }
            }
        }
    };
    private CustomMessageListener jcq = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.frs.FrsFragment.50
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                    if (FrsFragment.this.jaS == null && FrsFragment.this.jaB.cCm() != null && !FrsFragment.this.jaB.cBO() && FrsFragment.this.jaB.cCm().dxN() != null && (FrsFragment.this.jaB.cCm().dxN().getTag() instanceof ThreadCardViewHolder)) {
                        FrsFragment.this.jaS = (ThreadCardViewHolder) FrsFragment.this.jaB.cCm().dxN().getTag();
                    }
                    if (FrsFragment.this.jaS != null && FrsFragment.this.jaS.tm() != null) {
                        FrsFragment.this.jaS.tm().b(new a.C0089a(3));
                    }
                }
            }
        }
    };
    private CustomMessageListener jcr = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.FrsFragment.51
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.jaB != null) {
                FrsFragment.this.jaB.Du();
            }
        }
    };
    private CustomMessageListener jcs = new CustomMessageListener(2921437) { // from class: com.baidu.tieba.frs.FrsFragment.52
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && FrsFragment.this.isResumed()) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (FrsFragment.this.jaD != null) {
                    if (booleanValue) {
                        if (FrsFragment.this.jaV.cKC() != 0 && !FrsFragment.this.jaB.cCT() && !com.baidu.tbadk.k.d.bCj().bCk()) {
                            FrsFragment.this.jaD.show();
                            return;
                        }
                        return;
                    }
                    FrsFragment.this.jaD.hide();
                }
            }
        }
    };
    private CustomMessageListener jct = new CustomMessageListener(2921462) { // from class: com.baidu.tieba.frs.FrsFragment.58
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && FrsFragment.this.jaa.getToLoadHorseData().intValue() == 1 && FrsFragment.this.mIsLogin) {
                LiveHorseRaceRequestMessage liveHorseRaceRequestMessage = new LiveHorseRaceRequestMessage();
                liveHorseRaceRequestMessage.setForum_id(Long.valueOf(FrsFragment.this.forumId));
                FrsFragment.this.sendMessage(liveHorseRaceRequestMessage);
            }
        }
    };
    private CustomMessageListener jcu = new CustomMessageListener(2001223) { // from class: com.baidu.tieba.frs.FrsFragment.59
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Date)) {
                FrsFragment.this.jbx = (Date) customResponsedMessage.getData();
            }
        }
    };
    private CustomMessageListener jcv = new CustomMessageListener(2921469) { // from class: com.baidu.tieba.frs.FrsFragment.60
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.y) && FrsFragment.this.isResumed()) {
                com.baidu.tbadk.core.data.y yVar = (com.baidu.tbadk.core.data.y) customResponsedMessage.getData();
                if (FrsFragment.this.jbE == null) {
                    FrsFragment.this.jbE = new com.baidu.tieba.frs.broadcast.a(FrsFragment.this.getPageContext());
                }
                if (FrsFragment.this.jaa != null && FrsFragment.this.jaa.getForum() != null && !TextUtils.isEmpty(FrsFragment.this.jaa.getForum().getId())) {
                    FrsFragment.this.jbE.e(yVar.type, FrsFragment.this.jaa.getForum().getId(), FrsFragment.this.jaa.getForum().getName(), yVar.tid);
                }
            }
        }
    };
    private CustomMessageListener jcw = new CustomMessageListener(2921475) { // from class: com.baidu.tieba.frs.FrsFragment.61
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bz bzVar = (bz) customResponsedMessage.getData();
            if (bzVar != null && FrsFragment.this.isResumed()) {
                FrsFragment.this.jaQ = bzVar.getTid() + "";
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE_NUMBER);
                httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
                httpMessage.addParam("forum_id", bzVar.getFid());
                MessageManager.getInstance().sendMessage(httpMessage);
            }
        }
    };
    private HttpMessageListener jcx = new HttpMessageListener(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE_NUMBER) { // from class: com.baidu.tieba.frs.FrsFragment.62
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if ((httpResponsedMessage instanceof ForumManagerRightsResMsg) && FrsFragment.this.isResumed()) {
                ForumManagerRightsResMsg forumManagerRightsResMsg = (ForumManagerRightsResMsg) httpResponsedMessage;
                if (forumManagerRightsResMsg.broadcastTotalCount - forumManagerRightsResMsg.broadcastUsedCount <= 0) {
                    new ScreenTopToast(FrsFragment.this.getContext()).TT(FrsFragment.this.getString(R.string.frs_forum_bawu_send_broadcast_none_tip)).TV(FrsFragment.this.getString(R.string.frs_recommend_fail_tip_btn)).an(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.62.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("_forumId", FrsFragment.this.jaa.getForum().getId());
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new com.baidu.tieba.tbadkCore.data.m(FrsFragment.this.getContext(), "ForumGradePage", hashMap)));
                        }
                    }).aR((ViewGroup) FrsFragment.this.mRootView.findViewById(R.id.frs));
                    return;
                }
                com.baidu.tbadk.core.util.o oVar = new com.baidu.tbadk.core.util.o(TbadkCoreApplication.getInst());
                oVar.an(FrsFragment.this.jaa.getForum().getId(), FrsFragment.this.jaa.getForum().getName(), "6");
                oVar.AD(FrsFragment.this.jaQ);
                oVar.start();
            }
        }
    };
    private CustomMessageListener jcy = new CustomMessageListener(2921515) { // from class: com.baidu.tieba.frs.FrsFragment.63
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                com.baidu.tieba.NEGFeedBack.g gVar = (com.baidu.tieba.NEGFeedBack.g) customResponsedMessage.getData();
                if (FrsFragment.this.jaa == null || FrsFragment.this.jaa.getForum() == null || FrsFragment.this.jaa.getForum().getDeletedReasonInfo() == null) {
                    com.baidu.tieba.NEGFeedBack.d.a(0, FrsFragment.this.getPageContext(), gVar, null, FrsFragment.this.jaa.getUserData());
                    return;
                }
                com.baidu.tieba.NEGFeedBack.h hVar = new com.baidu.tieba.NEGFeedBack.h(FrsFragment.this.jaa.getForum().getDeletedReasonInfo().is_grays_cale_forum.intValue(), FrsFragment.this.jaa.getForum().getDeletedReasonInfo().is_boomgrow.intValue(), FrsFragment.this.jaa.forumRule != null ? FrsFragment.this.jaa.forumRule.has_forum_rule.intValue() : 0);
                hVar.ei(FrsFragment.this.jaa.getForum().getId(), FrsFragment.this.jaa.getForum().getName());
                hVar.setForumHeadUrl(FrsFragment.this.jaa.getForum().getImage_url());
                hVar.setUserLevel(FrsFragment.this.jaa.getForum().getUser_level());
                com.baidu.tieba.NEGFeedBack.d.a(hVar.bKb(), FrsFragment.this.getPageContext(), gVar, hVar, FrsFragment.this.jaa.getUserData());
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.frs.loadmore.a
    public /* bridge */ /* synthetic */ com.baidu.adp.base.f getPageContext() {
        return super.getPageContext();
    }

    public com.baidu.tieba.frs.entelechy.a.b cAZ() {
        return this.jbb;
    }

    public com.baidu.adp.widget.ListView.w cBa() {
        return this.jcn;
    }

    public com.baidu.tieba.frs.mc.d cBb() {
        return this.jbd;
    }

    public com.baidu.tieba.frs.smartsort.a cBc() {
        return this.jaX;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public FrsModelController cBd() {
        return this.jaT;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public com.baidu.tieba.frs.mc.c cBe() {
        return this.jbe;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public com.baidu.tieba.frs.vc.h cBf() {
        return this.jaU;
    }

    public FrsTabViewController cBg() {
        return this.jaV;
    }

    public at cBh() {
        return this.jaZ;
    }

    public void qj(boolean z) {
        this.jbw = z;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public q cBi() {
        return this.jaB;
    }

    @Override // com.baidu.tieba.frs.as
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.as, com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.jat;
    }

    public void setForumName(String str) {
        this.jat = str;
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

    @Override // com.baidu.tieba.recapp.p
    public String getFid() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.recapp.p
    public int getPageNum() {
        if (this.jbe == null) {
            return 1;
        }
        return this.jbe.getPn();
    }

    public int getPn() {
        if (this.jbe == null) {
            return 1;
        }
        return this.jbe.getPn();
    }

    public void setPn(int i) {
        if (this.jbe != null) {
            this.jbe.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.jbe != null) {
            this.jbe.setHasMore(i);
        }
    }

    public int cBj() {
        if (this.jbe == null) {
            return -1;
        }
        return this.jbe.cBj();
    }

    public boolean cBk() {
        return this.jaz;
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
            this.jaB.cCp();
            showNetRefreshView(this.jaB.cmp(), string, true);
        } else if (340001 == fVar.errorCode) {
            a(fVar, this.jaa.getRecm_forum_list());
        } else {
            if (com.baidu.tbadk.core.util.x.isEmpty(this.jaa.getThreadList())) {
                b(fVar);
            }
            if (cBQ()) {
                setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds280));
            } else {
                setNetRefreshViewEmotionDefMarginTop();
            }
        }
    }

    public void a(View view, String str, boolean z, List<RecmForumInfo> list) {
        this.jaB.cCp();
        this.jaB.yx(8);
        if (this.jbm == null) {
            this.jbm = new com.baidu.tieba.frs.view.a(getPageContext(), getNetRefreshListener());
        }
        this.jbm.setSubText(str);
        this.jbm.setListData(list);
        this.jbm.attachView(view, z);
    }

    private void a(com.baidu.tieba.tbadkCore.f fVar, List<RecmForumInfo> list) {
        if (this.jaB != null) {
            this.jaB.cCp();
            this.jaB.setTitle(this.jat);
            a(this.jaB.cmp(), fVar.errorMsg, true, list);
        }
    }

    private void b(com.baidu.tieba.tbadkCore.f fVar) {
        this.jaB.cCp();
        if (fVar.iKB) {
            showNetRefreshView(this.jaB.cmp(), TbadkCoreApplication.getInst().getString(R.string.net_error_text, new Object[]{fVar.errorMsg, Integer.valueOf(fVar.errorCode)}), true);
        } else {
            showNetRefreshView(this.jaB.cCW().cKp(), fVar.errorMsg, true);
        }
    }

    public void cBl() {
        hideLoadingView(this.jaB.cmp());
        this.jaB.bQX();
        if (this.jaB.cCn() instanceof com.baidu.tieba.frs.tab.c) {
            ((com.baidu.tieba.frs.tab.c) this.jaB.cCn()).cIV();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cBm() {
        if (cBj() == 0 && com.baidu.tbadk.core.util.x.isEmpty(this.jaa.getThreadListIds())) {
            if (com.baidu.tbadk.core.util.x.isEmpty(this.jaa.getThreadList())) {
                this.jaB.bRO();
            } else {
                this.jaB.Vp();
            }
        } else if (com.baidu.tbadk.core.util.x.getCount(this.jaa.getThreadList()) > 3) {
            this.jaB.Vo();
        } else {
            this.jaB.cCK();
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
            cBl();
            this.jaB.cCv();
            com.baidu.tieba.tbadkCore.f cIj = this.jaT.cIj();
            boolean isEmpty = com.baidu.tbadk.core.util.x.isEmpty(this.jaa.getThreadList());
            if (cIj != null && isEmpty) {
                if (this.jaT.cIl() != 0) {
                    this.jaT.cIq();
                    this.jaB.cCv();
                } else {
                    a(cIj);
                }
                this.jaB.aa(this.jaa.isStarForum(), false);
                return;
            }
            a(cIj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(com.baidu.tieba.tbadkCore.m mVar) {
        if (mVar != null && mVar.getEntelechyTabInfo() != null && mVar.getEntelechyTabInfo().tab != null) {
            for (FrsTabInfo frsTabInfo : mVar.getEntelechyTabInfo().tab) {
                if (frsTabInfo.tab_id.intValue() == 502 && com.baidu.tbadk.core.sharedPref.b.brx().getBoolean("first_into_tab_profession", true)) {
                    return false;
                }
            }
        }
        return new com.baidu.tieba.frs.ad.f(getTbPageContext()).d(mVar);
    }

    public boolean cBn() {
        return cBo() && !cBp();
    }

    private boolean cBo() {
        if (cBN() == null) {
            return false;
        }
        FrsViewData cBN = cBN();
        com.baidu.tbadk.core.data.z zVar = null;
        if (cBN.getStar() != null && !StringUtils.isNull(cBN.getStar().dKv())) {
            zVar = new com.baidu.tbadk.core.data.z();
        } else if (cBN.getActivityHeadData() != null && com.baidu.tbadk.core.util.x.getCount(cBN.getActivityHeadData().blz()) >= 1) {
            zVar = cBN.getActivityHeadData().blz().get(0);
        }
        return zVar != null;
    }

    public boolean cBp() {
        if (cBN() == null) {
            return false;
        }
        FrsViewData cBN = cBN();
        return (com.baidu.tbadk.core.util.x.isEmpty(cBN.getShowTopThreadList()) && cBN.getBusinessPromot() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cBq() {
        boolean b2;
        if (!cBs()) {
            final PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
            privateForumPopInfoData.a(this.jaa.getPrivateForumTotalInfo().getPrivatePopInfo());
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(getActivity());
            if (this.jaa.getPrivateForumTotalInfo().bmt().private_forum_status.intValue() == 1 && (com.baidu.tbadk.core.util.at.isEmpty(privateForumPopInfoData.bmv()) || privateForumPopInfoData.bmy() != Integer.valueOf(this.forumId))) {
                privateForumPopInfoData.zF("create_success");
                privateForumPopInfoData.zG(TbadkCoreApplication.getInst().getString(R.string.frs_private_create_hint));
                privateForumPopInfoData.zH("https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.jat + "&nomenu=1");
                privateForumPopInfoData.m(Integer.valueOf(this.forumId));
                b2 = frsPrivateCommonDialogView.b(privateForumPopInfoData);
            } else {
                b2 = privateForumPopInfoData.bmy() == Integer.valueOf(this.forumId) ? frsPrivateCommonDialogView.b(privateForumPopInfoData) : false;
            }
            if (b2) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
                aVar.nx(2);
                aVar.br(frsPrivateCommonDialogView);
                aVar.jE(false);
                frsPrivateCommonDialogView.setConfirmButton(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.21
                    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.frs.FrsFragment */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        be.bsB().b(FrsFragment.this.getPageContext(), new String[]{privateForumPopInfoData.bmx()});
                        aVar.dismiss();
                    }
                });
                aVar.a(new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.22
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(getPageContext()).bqe();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cBr() {
        if (cBs() || this.jaa.getPrivateForumTotalInfo().bmt().private_forum_status.intValue() != 1) {
            a((Integer) null, (Integer) null, true);
        } else {
            a(this.jaa.getPrivateForumTotalInfo().bmt().private_forum_audit_status, this.jaa.getPrivateForumTotalInfo().bmu(), false);
        }
    }

    public void a(Integer num, Integer num2, boolean z) {
        final int i = 2;
        if (this.jaB.cCB() != null) {
            TextView cCB = this.jaB.cCB();
            if (z) {
                cCB.setVisibility(8);
                return;
            }
            final String str = "";
            if (num.intValue() == 2) {
                cCB.setText("修改实名认证信息");
                cCB.setVisibility(0);
                str = "https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + this.forumId + "&nomenu=1";
            } else if (num2.intValue() >= 0 && num2.intValue() <= 100) {
                cCB.setText("目标已完成" + String.valueOf(num2) + "%");
                cCB.setVisibility(0);
                i = 1;
                str = "https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.jat + "&nomenu=1";
            } else {
                cCB.setVisibility(8);
                i = 0;
            }
            cCB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.24
                /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13387").dW("fid", FrsFragment.this.forumId).dW("uid", TbadkCoreApplication.getCurrentAccount()).an("obj_type", i));
                    be.bsB().b(FrsFragment.this.getPageContext(), new String[]{str});
                }
            });
        }
    }

    private boolean cBs() {
        return this.jaa == null || this.jaa.getPrivateForumTotalInfo() == null || this.jaa.getPrivateForumTotalInfo().bmt() == null || this.jaa.getUserData().getIs_manager() != 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ym(int i) {
        List<WindowToast> list;
        if (TbadkCoreApplication.isLogin() && this.jaa != null && (list = this.jaa.mWindowToast) != null && list.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < list.size()) {
                    WindowToast windowToast = list.get(i3);
                    if (windowToast == null || windowToast.toast_type.intValue() != i) {
                        i2 = i3 + 1;
                    } else if (!com.baidu.tbadk.core.util.at.isEmpty(windowToast.toast_link)) {
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), "", com.baidu.tbadk.util.ai.addParamsForPageTranslucent(windowToast.toast_link), true)));
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
    public void cBt() {
        if (getActivity() != null && getActivity().getIntent() != null) {
            String stringExtra = getActivity().getIntent().getStringExtra(FrsActivityConfig.KEY_ACHIEVEMENT_URL);
            if (!TextUtils.isEmpty(stringExtra)) {
                getActivity().getIntent().removeExtra(FrsActivityConfig.KEY_ACHIEVEMENT_URL);
                AchievementActivityConfig achievementActivityConfig = new AchievementActivityConfig(getActivity());
                achievementActivityConfig.setUrl(stringExtra);
                if (this.jaa != null && this.jaa.getForumActiveInfo() != null) {
                    achievementActivityConfig.setShareUrl(this.jaa.getForumActiveInfo().forum_share_url);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, achievementActivityConfig));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cBu() {
        if (this.jaa == null || this.jaa.getForum() != null) {
            this.jaB.cCH();
        } else if (this.jaa.getForum().getYuleData() != null && this.jaa.getForum().getYuleData().bpV()) {
            TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_VIEW);
            this.jaB.a(this.jaa.getForum().getYuleData().bpW());
        } else {
            this.jaB.cCH();
        }
    }

    private void Y(boolean z, boolean z2) {
        if (this.jaT != null && this.jaa != null && this.jaB != null && z) {
            if (!this.jaT.cIx() && this.jaT.cIn() == 1) {
                if (!this.jaT.cIv()) {
                    this.jaa.addCardVideoInfoToThreadList();
                    this.jaa.addVideoInfoToThreadListInTenAndFifteenFloor();
                }
                boolean z3 = false;
                if (this.jaB.cCI().r(com.baidu.tieba.card.data.n.ivt)) {
                    z3 = this.jaa.addHotTopicDataToThreadList();
                }
                if (!z3) {
                    this.jaa.addFeedForumDataToThreadList();
                }
                if (TbadkCoreApplication.getInst().isRecAppExist() && !com.baidu.tieba.funad.a.cLz()) {
                    this.jaa.addRecommendAppToThreadList(this);
                }
                if (!this.jaB.cCI().r(bz.eOz)) {
                    this.jaa.removeAlaLiveThreadData();
                }
                this.jaa.addSchoolRecommendToThreadList();
            }
            if (!this.jaB.cCI().r(bz.eOz)) {
                this.jaa.removeAlaInsertLiveData();
                this.jaa.removeAlaStageLiveDat();
            } else {
                this.jaa.addInsertLiveDataToThreadList();
                this.jaa.addStageLiveDataToThreadList();
            }
            this.jaa.checkLiveStageInThreadList();
            this.jaa.addNoticeThreadToThreadList();
            if (this.jaB.cCI().r(com.baidu.tieba.i.b.jMA)) {
                this.jaa.addGameRankListToThreadList(z2);
            }
            if (TbadkCoreApplication.isLogin() && (!this.jaT.cIx() || this.jaT.isNetFirstLoad)) {
                this.jaa.addUserRecommendToThreadList();
            }
            this.jaa.addVideoActivityToTop();
        }
    }

    public boolean cBv() {
        if (this.jaU != null && this.jaT != null) {
            this.jaU.a(this.jaT.getPageType(), this.jaa);
        }
        boolean z = false;
        if (this.jaa != null) {
            z = this.jaa.hasTab();
        }
        cBy();
        if (this.jaB != null) {
            this.jaB.cCU();
            this.jaB.cCV();
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yn(int i) {
        ax axVar = null;
        cBv();
        cBI();
        try {
            if (this.jaa != null) {
                this.jaB.a((ArrayList<com.baidu.adp.widget.ListView.n>) null, this.jaa);
                this.jaU.Ao(1);
                this.jaB.cCy();
                this.jaV.a(this.jaa, this.jaT.cIs());
                com.baidu.tieba.frs.tab.d Ax = this.jaV.Ax(this.jaa.getFrsDefaultTabId());
                if (Ax != null && !TextUtils.isEmpty(Ax.url)) {
                    axVar = new ax();
                    axVar.ext = Ax.url;
                    axVar.stType = Ax.name;
                }
                this.jaT.a(this.jaa.getFrsDefaultTabId(), 0, axVar);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(boolean z, boolean z2) {
        try {
            if (this.jaa != null && this.jaV != null && this.jaT != null) {
                if (!this.jaB.cCI().r(bz.eOz)) {
                    this.jaa.removeAlaLiveThreadData();
                }
                boolean isEmpty = com.baidu.tbadk.core.util.x.isEmpty(this.jaa.getGameTabInfo());
                this.jaB.qt(isEmpty);
                if (!isEmpty) {
                    if (this.jbn == null) {
                        this.jbn = new com.baidu.tieba.frs.vc.e(this, (NoPressedRelativeLayout) this.mRootView);
                    }
                    if (this.gSX == null) {
                        this.gSX = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
                    }
                } else {
                    this.jbn = null;
                    this.gSX = null;
                }
                if (this.jaa.getForum() != null) {
                    this.jat = this.jaa.getForum().getName();
                    this.forumId = this.jaa.getForum().getId();
                }
                if (this.jaa.hasTab()) {
                    this.jaV.a(this.jaa, this.jaT.cIs());
                }
                if (z) {
                    Y(true, z);
                } else {
                    Y(this.jaO, z);
                }
                cBv();
                if (this.jbb != null) {
                    this.jbb.a(this.jaU, this.jaa);
                }
                if (this.jaa.getPage() != null) {
                    setHasMore(this.jaa.getPage().bmm());
                }
                ArrayList<com.baidu.adp.widget.ListView.n> a2 = this.jbe.a(z2, true, this.jaa.getThreadList(), null, z, false);
                if (a2 != null) {
                    this.jaa.setThreadList(a2);
                }
                this.jaa.removeRedundantUserRecommendData();
                this.jac = this.jaa.getTopThreadSize();
                if (this.jax != null) {
                    this.jaw = true;
                    this.jax.Jg(this.jac);
                    com.baidu.tieba.frs.d.a.a(this, this.jaa.getForum(), this.jaa.getThreadList(), this.jaw, getPn());
                }
                if (this.jaT.cIn() == 1) {
                    cBC();
                    if (!z && this.jaT.getPn() == 1) {
                        cBx();
                    }
                }
                if (this.jbc != null) {
                    this.jbc.dd(this.jaV.cKy());
                }
                cBl();
                this.jaB.cCq();
                this.jaB.aa(true, false);
                if (z && this.jaa.isFirstTabEqualAllThread()) {
                    com.baidu.adp.lib.f.e.mB().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.25
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!FrsFragment.this.jaM && com.baidu.adp.lib.util.j.isNetWorkAvailable() && !FrsFragment.this.jaB.cCX()) {
                                FrsFragment.this.jaB.cCS();
                            }
                        }
                    });
                }
                if (this.jaa.getForum() != null) {
                    this.jaB.Jw(this.jaa.getForum().getWarningMsg());
                }
                if (this.jaa != null && this.jaa.getFrsVideoActivityData() != null && com.baidu.tbadk.core.sharedPref.b.brx().getLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 0L) == 0) {
                    com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.26
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsFragment.this.jaB.cCQ();
                        }
                    }, 1000L);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FRS_SHOW_AR_ENTRY, this));
                this.jaB.cCk();
                if (this.jaa != null && this.jaa.getForum() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ENTER_FORUM, new VisitedForumData(this.jaa.getForum().getId(), this.jaa.getForum().getName(), this.jaa.getForum().getImage_url(), String.valueOf(System.currentTimeMillis() / 1000), ConstantData.Forum.SPECAIL_FORUM_TYPE_LIVE.equals(this.jaa.getForum().special_forum_type), this.jaa.getForum().getThemeColorInfo(), this.jaa.getForum().getMember_num())));
                }
                this.jbr.a(this.jaa.bottomMenuList, this.jaa.getForum());
                cBX();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void cBw() {
        if (this.jaT != null && this.jaT.cIn() == 1) {
            this.jaU.k(this.jaa);
        }
    }

    public void qk(boolean z) {
        com.baidu.tieba.s.c.dKg().b(getUniqueId(), z);
    }

    public void cBx() {
        if (this.jbh == null) {
            this.jbh = new com.baidu.tieba.frs.live.a(this, com.baidu.adp.lib.f.b.toInt(this.forumId, 0));
        }
        this.jbh.cHU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.tbadkCore.m mVar) {
        try {
            if (!this.jaM && mVar != null && this.jaa != null) {
                this.jaa.receiveData(mVar);
                Z(true, false);
                Looper.myQueue().addIdleHandler(this.jbH);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void cBy() {
        if (this.jaT != null) {
            Jt(this.jaT.getPageType());
        } else {
            Jt("normal_page");
        }
    }

    private void Jt(String str) {
        ql("frs_page".equals(str));
        if (this.jbb != null) {
            this.jbb.a(this.jaU, this.jaB, this.jaa);
        }
    }

    public void ql(boolean z) {
        if (this.jbf != null) {
            this.jbf.cKi();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.s.c.dKg().z(getUniqueId());
        registerResponsedEventListener(TopToastEvent.class, this.mTopToastEventListener);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.frs_activity, viewGroup, false);
            this.jan = new com.baidu.tieba.frs.entelechy.a();
            this.jbb = this.jan.cEF();
            this.jam = TbadkCoreApplication.getInst().getString(R.string.frs_title_new_area);
            this.jaU = new com.baidu.tieba.frs.vc.h(this, this.jan, (FrsHeaderViewContainer) this.mRootView.findViewById(R.id.header_view_container));
            this.jaV = new FrsTabViewController(this, this.mRootView);
            this.jaV.registerListener();
            this.jaU.a(this.jaV);
            this.jaV.a(this.jbP);
            Intent intent = getActivity().getIntent();
            if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                this.jap = true;
            }
            this.jaB = new q(this, this.jcl, this.jan, this.jap, this.jaU);
            this.jbr = new com.baidu.tieba.frs.brand.buttommenu.a(getPageContext(), this.mRootView);
        } else {
            if (this.mRootView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            if (this.jaV != null) {
                this.jaV.registerListener();
            }
            this.jaB.cCP();
            this.mRootView.setLeft(0);
            this.mRootView.setRight(com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getContext()));
        }
        this.jbv = true;
        this.fHb = System.currentTimeMillis() - currentTimeMillis;
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        ArrayList<com.baidu.adp.widget.ListView.n> arrayList = null;
        this.iDg = System.currentTimeMillis();
        long j = this.iDg;
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.jay = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.iDg = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            S(intent);
        }
        this.fHa = j - this.iDg;
        this.jax = new com.baidu.tieba.tbadkCore.data.f("frs", com.baidu.tieba.tbadkCore.data.f.nmi);
        if (this.jaT == null) {
            this.jaT = new FrsModelController(this, this.jcg);
            this.jaT.a(this.jbO);
            this.jaT.init();
        }
        this.jaT.setSchemeUrl(this.mSchemeUrl);
        if (intent != null) {
            this.jaT.aj(intent.getExtras());
        } else if (bundle != null) {
            this.jaT.aj(bundle);
        } else {
            this.jaT.aj(null);
        }
        if (intent != null) {
            this.jaU.as(intent.getExtras());
        } else if (bundle != null) {
            this.jaU.as(bundle);
        } else {
            this.jaU.as(null);
        }
        this.jaA = getVoiceManager();
        this.jbi = new p(getPageContext(), this);
        initUI();
        initData(bundle);
        if (!cBQ()) {
            this.jaZ = new at(getActivity(), this.jaB, this.jaU);
            this.jaZ.qI(true);
        }
        this.jaA = getVoiceManager();
        if (this.jaA != null) {
            this.jaA.onCreate(getPageContext());
        }
        if (FrsActivityConfig.FRS_FROM_FLUTTER_BCASTEDIT.equals(getFrom()) && !this.hasInit) {
            int i = com.baidu.tbadk.core.sharedPref.b.brx().getInt("key_forum_broadcast_edit_tip_number", 0);
            if (i < 2) {
                com.baidu.tbadk.core.sharedPref.b.brx().putInt("key_forum_broadcast_edit_tip_number", i + 1);
                cBE();
            } else if (Build.VERSION.SDK_INT >= 23) {
                if (Settings.canDrawOverlays(getContext())) {
                    cBF();
                } else {
                    new BdTopToast(getContext()).yS(false).TP(getContext().getString(R.string.forum_broadcast_copy_no_permission_hint)).aR(this.jaB.cmp());
                }
            } else {
                cBF();
            }
        }
        if (FrsActivityConfig.FRS_FROM_FORUM_RULE_EDIT.equals(getFrom()) && !this.hasInit) {
            if (Build.VERSION.SDK_INT >= 23) {
                if (Settings.canDrawOverlays(getContext())) {
                    cBG();
                } else if (Build.VERSION.SDK_INT < 23 || !com.baidu.tbadk.core.sharedPref.b.brx().getBoolean("key_forum_rule_dialog_show_frs", false)) {
                    cBG();
                    com.baidu.tbadk.core.sharedPref.b.brx().putBoolean("key_forum_rule_dialog_show_frs", true);
                }
            } else {
                cBG();
            }
        }
        if (com.baidu.tbadk.k.d.bCj().bCk()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
            if (this.jaC != null) {
                this.jaC.setVisibility(8);
            }
        }
        new com.baidu.tieba.frs.mc.i();
        int i2 = -1;
        if (this.jbe != null && this.jbe.cIf() != null) {
            i2 = this.jbe.cIf().cBj();
            arrayList = this.jbe.cIf().getDataList();
        }
        this.jbe = new com.baidu.tieba.frs.mc.c(this, this.jcj);
        this.jbe.cIf().setHasMore(i2);
        if (arrayList != null && arrayList.size() > 0) {
            this.jbe.cIf().aD(arrayList);
        }
        this.jaX = new com.baidu.tieba.frs.smartsort.a(this);
        this.jbf = new com.baidu.tieba.frs.vc.j(this);
        this.jbc = new com.baidu.tieba.frs.vc.a(getPageContext(), this.jaT.cIu());
        this.jaY = new com.baidu.tieba.frs.mc.b(this);
        this.jbd = new com.baidu.tieba.frs.mc.d(this);
        this.jaW = new com.baidu.tieba.frs.mc.h(this);
        this.jbg = new com.baidu.tieba.frs.mc.a(this);
        this.jbj = new com.baidu.tieba.frs.vc.c(this);
        this.jbk = new com.baidu.tieba.frs.mc.e(this, getUniqueId());
        this.jbp = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "frs");
        this.jbq = new com.baidu.tieba.ala.b(getPageContext());
        this.jbs = new com.baidu.tieba.frs.sportspage.notification.a(getPageContext());
        registerListener(this.jbX);
        registerListener(this.mMemListener);
        registerListener(this.jbV);
        registerListener(this.jck);
        registerListener(this.jch);
        registerListener(this.jbR);
        registerListener(this.jbS);
        registerListener(this.jbT);
        registerListener(this.jbU);
        registerListener(this.jbI);
        registerListener(this.jbJ);
        registerListener(this.ahx);
        registerListener(this.jbK);
        registerListener(this.jcp);
        registerListener(this.jbZ);
        this.jca.setSelfListener(true);
        this.jca.setTag(getPageContext().getUniqueId());
        registerListener(this.jca);
        registerListener(this.jbN);
        registerListener(this.jcb);
        registerListener(this.jbY);
        registerListener(this.jcd);
        registerListener(this.jce);
        registerListener(this.jcf);
        this.jcq.setTag(getPageContext().getUniqueId());
        MessageManager.getInstance().registerListener(this.jcq);
        registerListener(this.jcr);
        registerListener(this.jcs);
        registerListener(this.jct);
        registerListener(this.jbM);
        registerListener(this.jcu);
        registerListener(this.jcc);
        registerListener(this.jbL);
        registerListener(this.jcv);
        registerListener(this.jcw);
        registerListener(this.jcx);
        registerListener(this.jcy);
        this.jaB.qv(false);
        if (!cBQ() && !this.hasInit) {
            showLoadingView(this.jaB.cmp(), true);
            this.jaT.T(3, false);
        }
        av avVar = new av() { // from class: com.baidu.tieba.frs.FrsFragment.29
            @Override // com.baidu.tieba.frs.av
            public void e(boolean z, boolean z2, int i3) {
                if (FrsFragment.this.jaB != null) {
                    if (i3 == 1) {
                        FrsFragment.this.jaB.yy(z ? 0 : 8);
                    } else if (i3 == 2) {
                        FrsFragment.this.jaB.yA(z ? 0 : 8);
                    }
                    if (!z2) {
                        FrsFragment.this.jbu = z;
                    }
                    if (FrsFragment.this.jaB.cCI() != null && (i3 == 2 || (FrsFragment.this.jaT != null && FrsFragment.this.jaT.cIo()))) {
                        FrsFragment.this.jaB.cCI().notifyDataSetChanged();
                    }
                    if (FrsFragment.this.cBg() != null) {
                        FrsTabViewController.b cKz = FrsFragment.this.cBg().cKz();
                        if (cKz != null) {
                            if ((cKz.fragment instanceof FrsCommonTabFragment) && (i3 == 2 || cKz.tabId == 502)) {
                                ((FrsCommonTabFragment) cKz.fragment).cEu();
                            } else if ((cKz.fragment instanceof FrsNewAreaFragment) && (i3 == 2 || cKz.tabId == 503)) {
                                FrsNewAreaFragment frsNewAreaFragment = (FrsNewAreaFragment) cKz.fragment;
                                frsNewAreaFragment.cEu();
                                if (frsNewAreaFragment.cIF() != null) {
                                    com.baidu.tieba.frs.mc.g cIF = frsNewAreaFragment.cIF();
                                    cIF.qK(!z);
                                    if (i3 == 1) {
                                        cIF.qy(!z);
                                    } else if (i3 == 2) {
                                        cIF.qy(true);
                                    }
                                }
                            } else if (cKz.fragment instanceof FrsGoodFragment) {
                                ((FrsGoodFragment) cKz.fragment).cEu();
                            }
                        }
                        if (FrsFragment.this.cBg().cKq() != null) {
                            FrsFragment.this.cBg().cKq().setmDisallowSlip(z);
                            FrsFragment.this.cBg().ru(z);
                        }
                    }
                    if (FrsFragment.this.jaB.cCo() != null) {
                        FrsFragment.this.jaB.qs(!z);
                    }
                    if (FrsFragment.this.getActivity() instanceof FrsActivity) {
                        ((FrsActivity) FrsFragment.this.getActivity()).qi(!z);
                    }
                    if (FrsFragment.this.jbr != null) {
                        FrsFragment.this.jbr.qQ(!z);
                    }
                    FrsFragment.this.jaB.qx(!z);
                    if (i3 == 1) {
                        FrsFragment.this.jaB.qy(z ? false : true);
                    } else if (i3 == 2) {
                        FrsFragment.this.jaB.qy(true);
                    }
                }
            }

            @Override // com.baidu.tieba.frs.av
            public void co(int i3, int i4) {
                if (FrsFragment.this.jaB != null) {
                    if (i4 == 1) {
                        FrsFragment.this.jaB.yz(i3);
                    } else if (i4 == 2) {
                        FrsFragment.this.jaB.yB(i3);
                    }
                }
            }

            @Override // com.baidu.tieba.frs.av
            public void yr(int i3) {
                if (FrsFragment.this.getContext() != null) {
                    if (i3 == 1) {
                        com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getContext(), R.string.frs_multi_delete_max_num);
                    } else if (i3 == 2 && FrsFragment.this.jaB != null) {
                        new BdTopToast(FrsFragment.this.getContext()).yS(false).TP(FrsFragment.this.getContext().getString(R.string.frs_move_area_max_num)).aR(FrsFragment.this.jaB.cmp());
                    }
                }
            }
        };
        b.cAg().a(avVar);
        com.baidu.tieba.frs.a.czZ().a(avVar);
        this.jaB.b(new e.a() { // from class: com.baidu.tieba.frs.FrsFragment.30
            @Override // com.baidu.tieba.NEGFeedBack.e.a
            public void a(DeleteThreadHttpResponseMessage deleteThreadHttpResponseMessage) {
                boolean z;
                int i3 = 0;
                if (deleteThreadHttpResponseMessage != null) {
                    FrsFragment.this.jaB.bJR();
                    FrsFragment.this.jaB.cCR();
                    FrsNewAreaFragment frsNewAreaFragment = null;
                    if (FrsFragment.this.jaV == null || FrsFragment.this.jaV.cKz() == null || !(FrsFragment.this.jaV.cKz().fragment instanceof FrsNewAreaFragment)) {
                        z = false;
                    } else {
                        frsNewAreaFragment = (FrsNewAreaFragment) FrsFragment.this.jaV.cKz().fragment;
                        z = true;
                    }
                    if (deleteThreadHttpResponseMessage.getError() == 0) {
                        String text = !TextUtils.isEmpty(deleteThreadHttpResponseMessage.getText()) ? deleteThreadHttpResponseMessage.getText() : FrsFragment.this.getString(R.string.delete_fail);
                        if (deleteThreadHttpResponseMessage.getRetType() == 1211066) {
                            if (FrsFragment.this.itE == null) {
                                FrsFragment.this.itE = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.itE.Ad(text);
                            FrsFragment.this.itE.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.30.1
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.itE.jE(false);
                            FrsFragment.this.itE.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.itE.bqe();
                        } else if (deleteThreadHttpResponseMessage.getRetType() == 1211067) {
                            if (FrsFragment.this.itE == null) {
                                FrsFragment.this.itE = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.itE.Ad(text);
                            FrsFragment.this.itE.a(R.string.know, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.30.2
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.itE.jE(false);
                            FrsFragment.this.itE.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.itE.bqe();
                        } else {
                            FrsFragment.this.jaB.aX(deleteThreadHttpResponseMessage.getText(), ContextCompat.getColor(FrsFragment.this.getContext(), deleteThreadHttpResponseMessage.getRetType() == 1 ? R.color.nav_bar_tip_error : R.color.cp_link_tip_a_alpha95));
                        }
                        if (z && frsNewAreaFragment != null) {
                            frsNewAreaFragment.dG(deleteThreadHttpResponseMessage.getSuccessItems());
                        }
                        FrsFragment.this.m33do(deleteThreadHttpResponseMessage.getSuccessItems());
                        b.cAg().dn(deleteThreadHttpResponseMessage.getSuccessItems());
                        for (com.baidu.adp.widget.ListView.n nVar : FrsFragment.this.jaa.getThreadList()) {
                            if (nVar instanceof by) {
                                i3++;
                                continue;
                            }
                            if (i3 >= 6) {
                                break;
                            }
                        }
                        if (i3 < 6) {
                            FrsFragment.this.bQy();
                            return;
                        }
                        return;
                    }
                    com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getActivity(), deleteThreadHttpResponseMessage.getErrorString());
                }
            }
        });
        this.dTc = UtilHelper.getScreenHeight(getActivity());
        this.hasInit = true;
        yo(1);
        super.onActivityCreated(bundle);
        this.createTime = System.currentTimeMillis() - j;
    }

    public void qm(boolean z) {
        if (this.jaV != null) {
            this.jaV.jGc = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: do  reason: not valid java name */
    public void m33do(List<String> list) {
        if (!com.baidu.tbadk.core.util.x.isEmpty(list)) {
            ArrayList<com.baidu.adp.widget.ListView.n> threadList = this.jaa.getThreadList();
            if (!com.baidu.tbadk.core.util.x.isEmpty(threadList) && this.jaB.getListView() != null && this.jaB.getListView().getData() != null) {
                Iterator<com.baidu.adp.widget.ListView.n> it = threadList.iterator();
                List<com.baidu.adp.widget.ListView.n> data = this.jaB.getListView().getData();
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.n next = it.next();
                    if (next instanceof by) {
                        bz bzVar = ((by) next).eHK;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= list.size()) {
                                break;
                            } else if (!com.baidu.tbadk.core.util.at.equals(list.get(i2), bzVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.jbe.d(next);
                                this.jaB.getListView().getAdapter().notifyItemRemoved(i);
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
    public void cAe() {
        if (!com.baidu.tbadk.core.util.x.isEmpty(com.baidu.tieba.frs.a.czZ().cAd()) && this.jaB.getListView() != null && this.jaB.getListView().getData() != null) {
            ArrayList<com.baidu.adp.widget.ListView.n> threadList = this.jaa.getThreadList();
            if (!com.baidu.tbadk.core.util.x.isEmpty(threadList)) {
                Iterator<com.baidu.adp.widget.ListView.n> it = threadList.iterator();
                List<com.baidu.adp.widget.ListView.n> data = this.jaB.getListView().getData();
                int count = com.baidu.tbadk.core.util.x.getCount(com.baidu.tieba.frs.a.czZ().cAd());
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.n next = it.next();
                    if (next instanceof by) {
                        bz bzVar = ((by) next).eHK;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= count) {
                                break;
                            } else if (!com.baidu.tbadk.core.util.at.equals(com.baidu.tieba.frs.a.czZ().cAd().get(i2).getId(), bzVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.jbe.d(next);
                                this.jaB.getListView().getAdapter().notifyItemRemoved(i);
                                break;
                            }
                        }
                    }
                    i++;
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.am
    public void bQS() {
        if (isAdded() && this.gAr && !isLoadingViewAttached()) {
            showLoadingView(this.jaB.cmp(), true);
        }
    }

    @Override // com.baidu.tieba.frs.am
    public void bQT() {
        if (isAdded() && this.gAr && isLoadingViewAttached()) {
            hideLoadingView(this.jaB.cmp());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (cBQ()) {
            showLoadingView(this.jaB.cmp(), true);
            this.jaB.yC(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.jaT.S(3, true);
            getListView().scrollToPosition(0);
        }
    }

    private void yo(int i) {
        String str = "";
        if (this.jaa != null && this.jaa.getForum() != null) {
            str = this.jaa.getForum().getId();
        }
        if (!StringUtils.isNull(str)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13008").dW("fid", str).dW("obj_type", "4").an("obj_locate", i).dW("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    @Override // com.baidu.tieba.frs.am
    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.y yVar) {
        if (yVar != null) {
            this.fKY = yVar.bFm();
            this.jbl = yVar.bFn();
        }
    }

    @Override // com.baidu.tieba.frs.am
    public void showFloatingView() {
        if (this.fKY != null) {
            this.fKY.kZ(true);
        }
    }

    private void S(Intent intent) {
        if (intent != null) {
            if (intent != null) {
                if (!com.baidu.tieba.frs.d.i.a(this, getForumName(), "from", intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false)) && getActivity() != null) {
                    getActivity().finish();
                    return;
                }
            }
            Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
            this.mSchemeUrl = uri != null ? uri.toString() : null;
            if (uri != null) {
                this.jat = uri.getQueryParameter("name");
                this.mFrom = uri.getQueryParameter("from");
                if (!StringUtils.isNull(this.jat)) {
                    intent.putExtra("name", this.jat);
                }
                if (!StringUtils.isNull(this.mFrom)) {
                    intent.putExtra("from", this.mFrom);
                }
                TiebaStatic.log(TbadkCoreStatisticKey.AS_INVOKE_TIEBA);
            }
            if (StringUtils.isNull(this.jat) && uri != null) {
                if (com.baidu.tbadk.BdToken.f.r(uri)) {
                    com.baidu.tbadk.BdToken.f.bhu().b(uri, this.jci);
                } else {
                    com.baidu.tieba.frs.d.g V = com.baidu.tieba.frs.d.l.V(intent);
                    if (V != null) {
                        this.jat = V.forumName;
                        if (V.jDG == null || V.jDG.equals("aidou")) {
                        }
                    }
                }
                if (!StringUtils.isNull(this.jat)) {
                    intent.putExtra("name", this.jat);
                }
                intent.putExtra(FrsActivityConfig.FRS_CALL_FROM, 12);
            }
        }
    }

    /* renamed from: com.baidu.tieba.frs.FrsFragment$31  reason: invalid class name */
    /* loaded from: classes2.dex */
    class AnonymousClass31 implements f.a {
        AnonymousClass31() {
        }

        @Override // com.baidu.tbadk.BdToken.f.a
        public void onCallBack(final HashMap<String, Object> hashMap) {
            if (hashMap != null) {
                if (hashMap.get(com.baidu.tbadk.BdToken.f.eBF) instanceof String) {
                    FrsFragment.this.jat = (String) hashMap.get(com.baidu.tbadk.BdToken.f.eBF);
                }
                if ((hashMap.get(com.baidu.tbadk.BdToken.f.eBX) instanceof String) && !TextUtils.isEmpty((String) hashMap.get(com.baidu.tbadk.BdToken.f.eBX))) {
                    com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.31.1
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsFragment.this.jaV.sO(301);
                            final long j = com.baidu.adp.lib.f.b.toLong((String) hashMap.get(com.baidu.tbadk.BdToken.f.eBG), 0L);
                            final int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
                            final int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
                            final float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                            final int i = 1;
                            if (com.baidu.tbadk.core.util.au.bsy().bsz()) {
                                i = 2;
                            }
                            com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.31.1.1
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

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.jaA = getVoiceManager();
        if (this.jaA != null) {
            this.jaA.onStart(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        Intent intent;
        long j = 0;
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.fqC);
        if (bundle != null) {
            this.jat = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            j = bundle.getLong(FrsActivityConfig.FRS_FAKE_THREAD_ID, 0L);
        } else if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
            this.jat = intent.getStringExtra("name");
            this.mFrom = intent.getStringExtra("from");
            this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
            j = intent.getLongExtra(FrsActivityConfig.FRS_FAKE_THREAD_ID, 0L);
        }
        if (getArguments() != null) {
            this.jau = getArguments().getBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, false);
        }
        if (TextUtils.isEmpty(this.mFrom) || FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
        }
        if (this.mIsLogin) {
            registerListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL, this.fqC);
        }
        this.jaU.as(bundle);
        gl(j);
    }

    private void gl(final long j) {
        if (j > 0) {
            final int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
            final int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
            final float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            final int i = 1;
            if (com.baidu.tbadk.core.util.au.bsy().bsz()) {
                i = 2;
            }
            com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.36
                @Override // java.lang.Runnable
                public void run() {
                    RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                    requestGetMyPostNetMessage.setParams(j, 0L, 0L, equipmentWidth, equipmentHeight, f, i);
                    requestGetMyPostNetMessage.setTag(FrsFragment.this.getUniqueId());
                    requestGetMyPostNetMessage.setHideErrorToast(true);
                    MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
                }
            }, 1000L);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.s.c.dKg().A(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.jcp);
        MessageManager.getInstance().unRegisterListener(this.jca);
        unRegisterResponsedEventListener();
        this.jbf.destroy();
        jaF = null;
        if (this.jaA != null) {
            this.jaA.onDestory(getPageContext());
        }
        com.baidu.tieba.recapp.report.a.remove("FRS");
        this.jaA = null;
        com.baidu.tieba.card.s.crj().pr(false);
        if (this.jaa != null && this.jaa.getForum() != null) {
            ag.cDs().gm(com.baidu.adp.lib.f.b.toLong(this.jaa.getForum().getId(), 0L));
        }
        if (this.jbh != null) {
            this.jbh.onDestory();
        }
        if (this.jaB != null) {
            com.baidu.tieba.frs.d.k.a(this.jaB, this.jaa, getForumId(), false, null);
            this.jaB.onDestroy();
        }
        if (this.jaE != null) {
            this.jaE.removeAllViews();
            this.jaE.setVisibility(8);
        }
        if (this.jbB != null) {
            this.jbB.cancel();
        }
        if (this.jbC != null) {
            com.baidu.adp.lib.f.e.mB().removeCallbacks(this.jbC);
        }
        this.jbA = null;
        super.onDestroy();
        try {
            if (this.jaN != null) {
                this.jaN.bDI();
            }
            if (this.jaB != null) {
                this.jaB.release();
            }
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.jaU.cHM();
        Looper.myQueue().removeIdleHandler(this.jbH);
        if (this.jaT != null) {
            this.jaT.bXP();
        }
        if (this.jaZ != null) {
            this.jaZ.cDA();
        }
        if (this.jbc != null) {
            this.jbc.destory();
        }
        if (this.jaX != null) {
            this.jaX.onDestroy();
        }
        if (this.jbn != null) {
            this.jbn.onDestory();
        }
        if (this.jbg != null) {
            this.jbg.onDestroy();
        }
        if (this.jbp != null) {
            this.jbp.onDestroy();
        }
        if (this.jbq != null) {
            this.jbq.onDestroy();
        }
        com.baidu.tieba.recapp.c.a.dBW().dBZ();
        com.baidu.tieba.frs.d.m.cJq();
        if (this.jaV != null) {
            this.jaV.a((FrsTabViewController.a) null);
            this.jaV.cKB();
        }
        if (this.jbt != null) {
            this.jbt.onDestroy();
        }
        b.cAg().a(null);
        com.baidu.tieba.frs.a.czZ().a(null);
        if (this.jbG != null) {
            this.jbG.cJo();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.jat);
        bundle.putString("from", this.mFrom);
        this.jaT.onSaveInstanceState(bundle);
        if (this.jaA != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            this.jaA.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.jbg != null) {
            this.jbg.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.jaB != null) {
            this.jaB.cCv();
            this.jaB.onResume();
        }
        this.jaW.rl(true);
        this.jaO = true;
        if (jas) {
            jas = false;
            if (this.jaB != null) {
                this.jaB.startPullRefresh();
                return;
            }
            return;
        }
        if (this.jaA != null) {
            this.jaA.onResume(getPageContext());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_RESUME));
        if (this.jaB != null) {
            this.jaB.qz(false);
        }
        if (this.jbo) {
            refresh(6);
            this.jbo = false;
        }
        if (this.jbx != null && getActivity() != null) {
            if (NotificationManagerCompat.from(getActivity()).areNotificationsEnabled()) {
                com.baidu.tbadk.coreExtra.messageCenter.f.byi().setSignAlertOn(true);
                com.baidu.tbadk.coreExtra.messageCenter.f.byi().setSignAlertTime(this.jbx.getHours(), this.jbx.getMinutes());
                if (this.jaB != null) {
                    com.baidu.tbadk.coreExtra.messageCenter.f.byi().a(getTbPageContext().getPageActivity(), this.jaB.cmp());
                }
            }
            this.jbx = null;
        }
        cBX();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
    }

    public boolean cBz() {
        Intent intent;
        if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
            return false;
        }
        return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
    }

    public void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.jat = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.jav = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.jav) {
                cBA();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cBA() {
        this.jaB.startPullRefresh();
    }

    public void closeActivity() {
        com.baidu.tieba.frs.d.l.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.mFrom);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.jaB.setTitle(this.jat);
        } else {
            this.jaB.setTitle("");
            this.mFlag = 1;
        }
        this.jaB.a(this.jcn);
        this.jaB.addOnScrollListener(this.mScrollListener);
        this.jaB.g(this.iXM);
        this.jaB.cCI().a(this.jcm);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jbv) {
            this.jaB.onChangeSkinType(i);
            this.jaU.An(i);
            this.jaV.onChangeSkinType(i);
            if (this.jaD != null) {
                this.jaD.onChangeSkinType(i);
            }
            if (this.jbm != null) {
                this.jbm.onChangeSkinType();
            }
            if (this.jbr != null) {
                this.jbr.onChangeSkinType(getPageContext(), i);
            }
            if (this.itE != null) {
                com.baidu.tbadk.r.a.a(getPageContext(), this.itE.getRealView());
            }
            if (this.jbn != null) {
                this.jbn.onChangeSkinType(getPageContext(), i);
            }
        }
    }

    public void yp(int i) {
        if (!this.mIsLogin) {
            if (this.jaa != null && this.jaa.getAnti() != null) {
                this.jaa.getAnti().setIfpost(1);
            }
            if (i == 0) {
                bg.skipToLoginActivity(getActivity());
            }
        } else if (this.jaa != null) {
            if (i == 0) {
                com.baidu.tieba.frs.d.m.g(this, 0);
            } else {
                this.jaB.cCx();
            }
        }
    }

    public void refresh() {
        com.baidu.tieba.a.d.bKv().DZ("page_frs");
        refresh(3);
    }

    public void refresh(int i) {
        this.jaM = false;
        cBI();
        if (this.jaB != null && this.jaB.cCm() != null) {
            this.jaB.cCm().cOx();
        }
        if (this.jaT != null) {
            this.jaT.S(i, true);
        }
    }

    private void cBB() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.f.h.mC().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.37
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.Sw(FrsFragment.this.jat);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cBC() {
        cBI();
        try {
            if (this.jaa != null) {
                this.jaB.bXh();
                this.jaB.qs(cBW());
                if (!com.baidu.tieba.frs.vc.h.n(this.jaa) || !com.baidu.tieba.frs.vc.h.m(this.jaa)) {
                }
                if (this.jaa.getForum() != null) {
                    this.jat = this.jaa.getForum().getName();
                    this.forumId = this.jaa.getForum().getId();
                }
                if (this.jaa.getPage() != null) {
                    setHasMore(this.jaa.getPage().bmm());
                }
                this.jaB.setTitle(this.jat);
                this.jaB.setForumName(this.jat);
                TbadkCoreApplication.getInst().setDefaultBubble(this.jaa.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.jaa.getUserData().getBimg_end_time());
                cBB();
                cBD();
                ArrayList<com.baidu.adp.widget.ListView.n> threadList = this.jaa.getThreadList();
                if (threadList != null) {
                    this.jaB.a(threadList, this.jaa);
                    com.baidu.tieba.frs.d.c.A(this.jaB);
                    this.jaU.Ao(getPageNum());
                    this.jaU.j(this.jaa);
                    this.jaV.a(this.jaa, this.jaT.cIs());
                    this.jaB.cCy();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void cBD() {
        if (this.jaa != null) {
            if (this.jaa.getIsNewUrl() == 1) {
                this.jaB.cCI().setFromCDN(true);
            } else {
                this.jaB.cCI().setFromCDN(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.jaW.rl(false);
        this.jaO = false;
        this.jaB.onPause();
        if (this.jaA != null) {
            this.jaA.onPause(getPageContext());
        }
        this.jaB.qz(true);
        if (this.jbc != null) {
            this.jbc.cJt();
        }
        com.baidu.tbadk.BdToken.c.bha().bhl();
        if (this.jbG != null) {
            this.jbG.cJo();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.jaV != null && this.jaV.cKz() != null && (this.jaV.cKz().fragment instanceof BaseFragment)) {
            ((BaseFragment) this.jaV.cKz().fragment).setPrimary(z);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.s.crj().pr(false);
        qk(false);
        if (this.jaa != null && this.jaa.getForum() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            com.baidu.tbadk.distribute.a.bAC().b(getPageContext().getPageActivity(), "frs", this.jaa.getForum().getId(), 0L);
        }
        if (this.jaA != null) {
            this.jaA.onStop(getPageContext());
        }
        if (getListView() != null) {
            getListView().getRecycledViewPool().clear();
        }
        this.jaU.btD();
        com.baidu.tbadk.util.z.bFp();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            if (this.jaU != null) {
                this.jaU.bW(isPrimary());
            }
            if (this.jaB != null) {
                this.jaB.bW(isPrimary());
                this.jaB.qz(!isPrimary());
            }
        }
    }

    private void cBE() {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.nx(2);
        aVar.jE(false);
        FrsBroadcastCopyGuideDialogView frsBroadcastCopyGuideDialogView = new FrsBroadcastCopyGuideDialogView(getPageContext().getPageActivity());
        frsBroadcastCopyGuideDialogView.setConfirmButtonListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.38
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aVar != null) {
                    aVar.dismiss();
                    FrsFragment.this.cBF();
                }
            }
        });
        aVar.br(frsBroadcastCopyGuideDialogView);
        aVar.b(getPageContext()).bqe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cBF() {
        com.baidu.tbadk.k.d.bCj().a(new com.baidu.tbadk.k.a(getContext()));
        com.baidu.tbadk.k.d.bCj().C(85, 0, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds144));
        if (com.baidu.tbadk.k.d.bCj().init()) {
            ((BaseFragmentActivity) getPageContext().getOrignalPage()).grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.frs.FrsFragment.39
                @Override // com.baidu.tbadk.core.e
                public void onPermissionResult(boolean z) {
                    if (!z) {
                        new BdTopToast(FrsFragment.this.getContext()).yS(false).TP(FrsFragment.this.getContext().getString(R.string.forum_broadcast_copy_no_permission_hint)).aR(FrsFragment.this.jaB.cmp());
                        return;
                    }
                    com.baidu.tbadk.k.d.bCj().kZ(true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                    if (FrsFragment.this.jaC != null) {
                        FrsFragment.this.jaC.setVisibility(8);
                    }
                }
            }, true);
        }
    }

    private void cBG() {
        com.baidu.tbadk.k.d.bCj().a(new com.baidu.tbadk.k.b(getContext()));
        com.baidu.tbadk.k.d.bCj().C(85, 0, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds144));
        if (com.baidu.tbadk.k.d.bCj().init()) {
            ((BaseFragmentActivity) getPageContext().getOrignalPage()).grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.frs.FrsFragment.40
                @Override // com.baidu.tbadk.core.e
                public void onPermissionResult(boolean z) {
                    if (z) {
                        com.baidu.tbadk.k.d.bCj().kZ(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                        if (FrsFragment.this.jaC != null) {
                            FrsFragment.this.jaC.setVisibility(8);
                        }
                    }
                }
            }, true);
        }
    }

    public void Ju(String str) {
        new BdTopToast(getContext(), 3000).yS(true).TP(str).aR(this.jaB.cmp());
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (b.cAg().cAa()) {
                b.cAg().reset();
                return true;
            } else if (com.baidu.tieba.frs.a.czZ().cAa()) {
                if (this.jaB != null && this.jaB.cCM()) {
                    this.jaB.cCN();
                    return true;
                }
                com.baidu.tieba.frs.a.czZ().reset();
                return true;
            } else if (this.jaB != null) {
                return this.jaB.cCu();
            }
        } else if (i == 24) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921381, keyEvent));
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.p
    public TbPageContext<?> getTbPageContext() {
        return getPageContext();
    }

    @Override // com.baidu.tieba.recapp.p
    public void a(AdvertAppInfo advertAppInfo, String str) {
        com.baidu.tbadk.distribute.a.bAC().a(advertAppInfo, this.forumId, 0L, "FRS", str, getPn());
    }

    @Override // com.baidu.tieba.recapp.p
    public void cBH() {
        cBd().cBH();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.jaA == null) {
            this.jaA = VoiceManager.instance();
        }
        return this.jaA;
    }

    public BdRecyclerView getListView() {
        if (this.jaB == null) {
            return null;
        }
        return this.jaB.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void cBI() {
        if (this.jaA != null) {
            this.jaA.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.a
    public com.baidu.adp.lib.d.b<TbImageView> bus() {
        if (this.fjw == null) {
            this.fjw = UserIconBox.E(getPageContext().getPageActivity(), 8);
        }
        return this.fjw;
    }

    public void cBJ() {
        if (getFragmentActivity() != null && getFragmentActivity().getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.q onGetPreLoadListView() {
        return getListView().getPreLoadHandle();
    }

    @Override // com.baidu.tieba.frs.ap
    public NavigationBar bUz() {
        if (this.jaB == null) {
            return null;
        }
        return this.jaB.bUz();
    }

    public FRSRefreshButton cBK() {
        return this.jaD;
    }

    public void c(LinearLayout linearLayout) {
        if (linearLayout != null) {
            this.jaE = linearLayout;
        }
    }

    public void a(FRSRefreshButton fRSRefreshButton) {
        if (fRSRefreshButton != null) {
            this.jaD = fRSRefreshButton;
            this.jaD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.47
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (FrsFragment.this.jaV != null) {
                        FrsTabViewController.b cKz = FrsFragment.this.jaV.cKz();
                        if (cKz != null && cKz.fragment != null && (cKz.fragment instanceof ao)) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                            ((ao) cKz.fragment).cAO();
                            ((ao) cKz.fragment).bRN();
                            return;
                        }
                        FrsFragment.this.cBi().startPullRefresh();
                    }
                }
            });
        }
    }

    public void cBL() {
        if (this.jaD != null) {
            this.jaD.hide();
        }
    }

    public void cBM() {
        if (this.jaD != null) {
            this.jaD.show();
        }
    }

    /* loaded from: classes2.dex */
    private final class a implements com.baidu.adp.widget.ListView.w {
        private a() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.w
        public void a(View view, com.baidu.adp.widget.ListView.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null) {
                if (bdUniqueId == u.jep) {
                    if (FrsFragment.this.jaB != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11752").dW("fid", FrsFragment.this.forumId).dW("obj_locate", "1"));
                        FrsFragment.this.jaB.startPullRefresh();
                    }
                } else if (nVar != null && (nVar instanceof by)) {
                    bz bzVar = ((by) nVar).eHK;
                    if (bzVar.boz() == null || bzVar.boz().getGroup_id() == 0 || bg.checkUpIsLogin(FrsFragment.this.getActivity())) {
                        if (bzVar.bok() != 1 || bg.checkUpIsLogin(FrsFragment.this.getActivity())) {
                            if (bzVar.bnJ() != null) {
                                if (bg.checkUpIsLogin(FrsFragment.this.getActivity())) {
                                    String postUrl = bzVar.bnJ().getPostUrl();
                                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.isNetOk()) {
                                        com.baidu.tbadk.browser.a.startInternalWebActivity(FrsFragment.this.getActivity(), postUrl);
                                    }
                                }
                            } else if (bzVar.boK() != null) {
                                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                    bg.skipToLoginActivity(FrsFragment.this.getPageContext().getPageActivity());
                                    return;
                                }
                                com.baidu.tbadk.core.data.s boK = bzVar.boK();
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), boK.getCartoonId(), boK.getChapterId(), 2)));
                            } else {
                                com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                                if (readThreadHistory != null && !readThreadHistory.SC(bzVar.getId())) {
                                    readThreadHistory.SB(bzVar.getId());
                                }
                                boolean z = false;
                                final String bnD = bzVar.bnD();
                                if (bnD != null && !bnD.equals("")) {
                                    z = true;
                                    new Thread(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.a.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            com.baidu.tbadk.core.util.z zVar = new com.baidu.tbadk.core.util.z(bnD);
                                            zVar.brX().bsG().mIsNeedAddCommenParam = false;
                                            zVar.brX().bsG().mIsUseCurrentBDUSS = false;
                                            zVar.getNetData();
                                        }
                                    }).start();
                                }
                                String tid = bzVar.getTid();
                                if (tid == null) {
                                    tid = "";
                                }
                                if (bzVar.bns() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                    be.bsB().b(FrsFragment.this.getPageContext(), new String[]{tid, "", null});
                                    return;
                                }
                                if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && tid.length() > 4) {
                                    bzVar.setId(tid.substring(3));
                                }
                                if (bdUniqueId.getId() == bz.eQd.getId()) {
                                    com.baidu.tieba.frs.d.k.a(bzVar.bnd());
                                } else if (bdUniqueId.getId() == bz.eOD.getId()) {
                                    com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                                    aqVar.dW("obj_type", "2");
                                    aqVar.dW("tid", bzVar.getTid());
                                    TiebaStatic.log(aqVar);
                                }
                                com.baidu.tieba.frs.d.l.a(FrsFragment.this, bzVar, i, z);
                                com.baidu.tieba.frs.d.k.a(FrsFragment.this, FrsFragment.this.jaa, bzVar);
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
            hideNetRefreshView(this.jaB.cCW().cKp());
            showLoadingView(this.jaB.cmp(), true);
            this.jaB.qv(false);
            this.jaT.S(3, true);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData cBN() {
        return this.jaa;
    }

    public boolean cBO() {
        return this.jaB.cBO();
    }

    public void aK(Object obj) {
        if (this.jaY != null && this.jaY.jyZ != null) {
            this.jaY.jyZ.callback(obj);
        }
    }

    public void aL(Object obj) {
        if (this.jaY != null && this.jaY.jza != null) {
            this.jaY.jza.callback(obj);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        this.jaB.getListView().stopScroll();
        if (!this.jaB.cCE()) {
            if (!com.baidu.adp.lib.util.l.isNetOk()) {
                this.jaB.bRO();
            } else if (this.jaT.cIn() == 1) {
                bQN();
                bQy();
            } else if (this.jaT.hasMore()) {
                bQy();
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void onFailed(String str) {
        bQN();
        showToast(str);
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void au(ArrayList<com.baidu.adp.widget.ListView.n> arrayList) {
        boolean isEmpty = com.baidu.tbadk.core.util.x.isEmpty(arrayList);
        setHasMore(isEmpty ? 0 : 1);
        bQN();
        if (!isEmpty) {
            if (!this.jaT.cIx() && TbadkCoreApplication.getInst().isRecAppExist() && this.jaT.cIn() == 1 && !com.baidu.tieba.funad.a.cLz()) {
                this.jaa.addRecommendAppToThreadList(this, arrayList);
            }
            if (this.jaT != null) {
                com.baidu.tieba.frs.b.a.a(getUniqueId(), arrayList, this.jaa.getForum(), this.jaT.getSortType());
            }
            ArrayList<com.baidu.adp.widget.ListView.n> a2 = this.jbe.a(false, false, arrayList, this.jax, false);
            if (a2 != null) {
                this.jaa.setThreadList(a2);
                this.jaB.a(a2, this.jaa);
            }
            if (this.jaT != null) {
                com.baidu.tieba.frs.b.c.a(this.jaa, this.jaT.cIs(), 2, getContext());
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.jaa.getForum()));
        }
    }

    private void bQN() {
        if (cBj() == 1 || this.jbe.dF(this.jaa.getThreadListIds())) {
            if (com.baidu.tbadk.core.util.x.getCount(this.jaa.getThreadList()) > 3) {
                this.jaB.Vo();
            } else {
                this.jaB.cCK();
            }
        } else if (com.baidu.tbadk.core.util.x.isEmpty(this.jaa.getThreadList())) {
            this.jaB.bRO();
        } else {
            this.jaB.Vp();
        }
    }

    @Override // com.baidu.tieba.frs.mc.l
    public void bQy() {
        if (this.jbe != null) {
            this.jbe.a(this.jat, this.forumId, this.jaa);
        }
    }

    public void cBP() {
        if (!com.baidu.tbadk.core.util.ad.requestWriteExternalStorgeAndCameraPermission(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.an.g(getPageContext());
        }
    }

    @Override // androidx.fragment.app.Fragment, com.baidu.l.a.a.InterfaceC0148a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        com.baidu.tieba.frs.d.l.a(this, i, strArr, iArr);
    }

    public void qn(boolean z) {
        if (this.jaZ != null) {
            this.jaZ.qI(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.jba.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a sH(int i) {
        return this.jba.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        this.jbi.b(bVar);
    }

    public boolean cBQ() {
        return this.jap;
    }

    @Override // com.baidu.tieba.frs.am
    public void SM() {
        if (this.jaB != null) {
            showFloatingView();
            this.jaB.getListView().scrollToPosition(0);
            this.jaB.startPullRefresh();
        }
    }

    public ForumWriteData cBR() {
        if (this.jaa == null || this.jaa.getForum() == null) {
            return null;
        }
        ForumData forum = this.jaa.getForum();
        ForumWriteData forumWriteData = new ForumWriteData(forum.getId(), forum.getName(), forum.getPrefixData(), this.jaa.getAnti());
        forumWriteData.avatar = forum.getImage_url();
        forumWriteData.forumLevel = forum.getUser_level();
        forumWriteData.specialForumType = forum.special_forum_type;
        forumWriteData.firstDir = forum.getFirst_class();
        forumWriteData.secondDir = forum.getSecond_class();
        UserData userData = this.jaa.getUserData();
        forumWriteData.privateThread = userData != null ? userData.getPrivateThread() : 0;
        forumWriteData.frsTabInfo = cBS();
        return forumWriteData;
    }

    private FrsTabInfoData cBS() {
        int i;
        if (this.jaT == null || this.jaa == null || this.jaV == null) {
            return null;
        }
        if (this.jaa.getEntelechyTabInfo() == null || com.baidu.tbadk.core.util.x.isEmpty(this.jaa.getEntelechyTabInfo().tab)) {
            return null;
        }
        int cKD = this.jaV.cKD();
        if (cKD == 502) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = -1;
        for (FrsTabInfo frsTabInfo : this.jaa.getEntelechyTabInfo().tab) {
            if (frsTabInfo != null && frsTabInfo.is_general_tab.intValue() == 1) {
                if (frsTabInfo.tab_id.intValue() != 505 || this.jaa.getUserData() == null || this.jaa.getUserData().isForumBusinessAccount()) {
                    arrayList.add(new FrsTabItemData(frsTabInfo));
                    if (cKD == frsTabInfo.tab_id.intValue()) {
                        i = cKD;
                        i2 = i;
                    }
                }
            }
            i = i2;
            i2 = i;
        }
        if (com.baidu.tbadk.core.util.x.isEmpty(arrayList)) {
            return null;
        }
        FrsTabInfoData frsTabInfoData = new FrsTabInfoData();
        frsTabInfoData.tabList = arrayList;
        frsTabInfoData.selectedTabId = i2;
        if (this.jaa.getUserData() != null) {
            frsTabInfoData.isForumBusinessAccount = this.jaa.getUserData().isForumBusinessAccount();
            return frsTabInfoData;
        }
        return frsTabInfoData;
    }

    @Override // com.baidu.tieba.frs.am
    public void btV() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void qo(boolean z) {
        this.jaP = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z) {
        this.jaB.yx(8);
        ((FrsActivity) getActivity()).showLoadingView(view, z);
        ((FrsActivity) getActivity()).j(view, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        this.jaB.yx(0);
        ((FrsActivity) getActivity()).hideLoadingView(view);
        ((FrsActivity) getActivity()).j(view, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        super.showNetRefreshView(view, getResources().getString(R.string.refresh_view_title_text), null, getResources().getString(R.string.refresh_view_button_text), z, getNetRefreshListener());
        this.jaB.yx(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshViewNoClick(View view, String str, boolean z) {
        super.showNetRefreshViewNoClick(view, str, z);
        this.jaB.yx(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        super.hideNetRefreshView(view);
        this.jaB.yx(0);
    }

    public void cBT() {
        FrsTabViewController.b cKz;
        if (this.jaV != null && (cKz = this.jaV.cKz()) != null && cKz.fragment != null && (cKz.fragment instanceof ao)) {
            ((ao) cKz.fragment).cAO();
        }
    }

    public void qp(boolean z) {
        this.jar = z;
    }

    public void b(OvalActionButton ovalActionButton) {
        this.jaC = ovalActionButton;
    }

    public OvalActionButton cBU() {
        return this.jaC;
    }

    public boolean cBV() {
        return this.jar;
    }

    public void Jv(String str) {
        if (TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.util.at.isEmpty(str)) {
            if (this.jbt == null) {
                this.jbt = new AddExperiencedModel(getTbPageContext());
            }
            this.jbt.gj(this.forumId, str);
        }
    }

    public boolean cBW() {
        if (this.jaP && !this.jbw) {
            return (this.jaT != null && this.jaT.cIo() && (b.cAg().cAa() || com.baidu.tieba.frs.a.czZ().cAa())) ? false : true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.g.b
    public boolean videoNeedPreload() {
        if (this.jaa != null) {
            return com.baidu.tbadk.util.ah.rB(2) || (com.baidu.tbadk.util.ah.bFx() && this.jaa.isFrsVideoAutoPlay);
        }
        return super.videoNeedPreload();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cBX() {
        if (!com.baidu.tbadk.core.util.at.isEmpty(this.forumId)) {
            com.baidu.tbadk.BdToken.c.bha().q(com.baidu.tbadk.BdToken.b.eAa, com.baidu.adp.lib.f.b.toLong(this.forumId, 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cBY() {
        String format;
        String str;
        if (isResumed() && this.jbA != null && this.jbA.size() >= 1 && this.jbz <= this.jbA.size() - 1) {
            final LiveHorseRaceData liveHorseRaceData = this.jbA.get(this.jbz);
            if (System.currentTimeMillis() / 1000 >= liveHorseRaceData.getRob_end_tm().longValue()) {
                this.jbz++;
                cBY();
            }
            if (this.jaE != null) {
                final FrsRedpackRunView frsRedpackRunView = new FrsRedpackRunView(getActivity());
                if (liveHorseRaceData.getUser_nickname() == null || TextUtils.isEmpty(liveHorseRaceData.getUser_nickname())) {
                    format = String.format(getResources().getString(R.string.live_horserace_red_envelope), getResources().getString(R.string.frs_horse_none_title_verser));
                } else if (liveHorseRaceData.getUser_nickname().length() > 4) {
                    format = String.format(getResources().getString(R.string.live_horserace_red_envelope), liveHorseRaceData.getUser_nickname().substring(0, 4) + StringHelper.STRING_MORE);
                } else {
                    format = String.format(getResources().getString(R.string.live_horserace_red_envelope), liveHorseRaceData.getUser_nickname());
                }
                frsRedpackRunView.settextTitle(format + format + format);
                frsRedpackRunView.setClickliner(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.53
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        String str2;
                        if (FrsFragment.this.jaa == null) {
                            str2 = "";
                        } else if (FrsFragment.this.jaa.getForum() != null) {
                            str2 = FrsFragment.this.jaa.getForum().getName();
                        } else {
                            str2 = "";
                        }
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13744").an("obj_source", 1).dW("fid", FrsFragment.this.forumId).dW("fname", str2));
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
                this.jbB = ValueAnimator.ofFloat(1.0f, 0.0f);
                this.jbB.setDuration(600L);
                this.jbB.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.FrsFragment.54
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        if (valueAnimator.isRunning()) {
                            frsRedpackRunView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                            frsRedpackRunView.setTranslationX(-(TbadkApplication.getInst().getContext().getResources().getDimensionPixelOffset(R.dimen.tbds850) * valueAnimator.getAnimatedFraction()));
                        }
                    }
                });
                this.jbB.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.FrsFragment.55
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        frsRedpackRunView.setAlpha(0.0f);
                        frsRedpackRunView.setTranslationY(TbadkApplication.getInst().getContext().getResources().getDimensionPixelOffset(R.dimen.tbds660));
                        frsRedpackRunView.hide();
                        FrsFragment.this.jaE.removeView(frsRedpackRunView);
                        if (FrsFragment.this.jbA == null || FrsFragment.this.jbz <= FrsFragment.this.jbA.size() - 1) {
                            FrsFragment.this.cBY();
                            return;
                        }
                        FrsFragment.this.jaE.removeAllViews();
                        FrsFragment.this.jaE.setVisibility(8);
                        FrsFragment.this.jbz = 0;
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        onAnimationEnd(animator);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                this.jbC = new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.57
                    @Override // java.lang.Runnable
                    public void run() {
                        if (FrsFragment.this.jaE != null && frsRedpackRunView != null) {
                            FrsFragment.this.jbB.start();
                        }
                    }
                };
                com.baidu.adp.lib.f.e.mB().postDelayed(this.jbC, 5000L);
                if (this.jaE.getChildCount() == 0) {
                    this.jbz++;
                    this.jaE.addView(frsRedpackRunView);
                    if (this.jaa != null) {
                        str = this.jaa.getForum() != null ? this.jaa.getForum().getName() : "";
                    } else {
                        str = "";
                    }
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13743").an("obj_source", 1).dW("fid", this.forumId).dW("fname", str));
                }
                if (this.jaE != null && this.jaE.getVisibility() == 8 && ((BaseFragment) this.jaV.cKz().fragment).isPrimary() && !this.jaB.cCT() && !this.jaK) {
                    this.jaE.setVisibility(0);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        FrsTabViewController.b cKz;
        if (cBg() == null || (cKz = cBg().cKz()) == null || !(cKz.fragment instanceof BaseFragment)) {
            return null;
        }
        if (cKz.fragment instanceof FrsAllThreadFragment) {
            TbPageTag tbPageTag = super.getTbPageTag();
            int i = -1;
            if (this.jaa != null) {
                i = this.jaa.getSortType();
            }
            tbPageTag.sortType = com.baidu.tieba.frs.d.j.Al(i);
            tbPageTag.locatePage = "a070";
            if (this.jam.equals(cKz.title)) {
                tbPageTag.locatePage = "a071";
            }
            return tbPageTag;
        } else if (cKz.fragment instanceof FrsFragment) {
            return null;
        } else {
            return ((BaseFragment) cKz.fragment).getTbPageTag();
        }
    }

    public void cBZ() {
        if (this.jaa != null) {
            com.baidu.tieba.frs.b.b bVar = new com.baidu.tieba.frs.b.b();
            if (this.jaa.needLog == 1) {
                bVar.jBG = true;
            } else {
                bVar.jBG = false;
            }
            if (this.jaa.getForum() != null) {
                bVar.jBI = this.jaa.getForum().getId();
            }
            if (cBd() != null) {
                bVar.jBH = cBd().cIs();
            }
            if (com.baidu.tieba.frs.b.d.jkJ != null) {
                bVar.jBJ = com.baidu.tieba.frs.b.d.jkJ.jBJ;
                bVar.jBK = com.baidu.tieba.frs.b.d.jkJ.jBK;
            }
            this.jbD = new com.baidu.tieba.frs.live.b(bVar, getTbPageTag(), getUniqueId());
            this.jbD.zO(this.jbF);
            CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_CARD_CLICK, this.jbD);
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
            CustomMessageTask customMessageTask2 = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW, this.jbD);
            customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask2);
            CustomMessageTask customMessageTask3 = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_USER_CLICK, this.jbD);
            customMessageTask3.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask3);
            CustomMessageTask customMessageTask4 = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_VIDEO_CLICK, this.jbD);
            customMessageTask4.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask4);
        }
    }

    public void aH(String str, String str2, String str3) {
        this.jbG = new com.baidu.tieba.frs.d.e(str, str2);
        this.jbG.c(getFragmentActivity(), str3, str2);
    }

    public void qq(boolean z) {
        if (this.funAdController == null) {
            this.funAdController = com.baidu.tieba.funad.a.rC(z);
            if (this.jbe != null) {
                this.jbe.setFunAdController(this.funAdController);
            }
        }
    }
}
