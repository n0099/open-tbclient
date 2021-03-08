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
import com.baidu.tbadk.core.data.ca;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bh;
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
public class FrsFragment extends BaseFragment implements BdListView.e, a.InterfaceC0154a, UserIconBox.a<BdRecyclerView>, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, am, ap, as, com.baidu.tieba.frs.loadmore.a, com.baidu.tieba.frs.mc.l, com.baidu.tieba.recapp.q {
    public static com.baidu.tieba.tbadkCore.m jij;
    private com.baidu.tbadk.util.z fOK;
    private com.baidu.adp.lib.d.b<TbImageView> fnn;
    private com.baidu.tieba.funad.a funAdController;
    private com.baidu.tieba.frs.gametab.b gXE;
    private com.baidu.tbadk.core.dialog.a iBl;
    private com.baidu.tieba.frs.entelechy.a jhQ;
    private com.baidu.tieba.frs.mc.h jiA;
    private com.baidu.tieba.frs.smartsort.a jiB;
    private com.baidu.tieba.frs.mc.b jiC;
    private at jiD;
    private com.baidu.tieba.frs.entelechy.a.b jiF;
    private com.baidu.tieba.frs.vc.a jiG;
    private com.baidu.tieba.frs.mc.d jiH;
    private com.baidu.tieba.frs.mc.c jiI;
    private com.baidu.tieba.frs.vc.j jiJ;
    private com.baidu.tieba.frs.mc.a jiK;
    private com.baidu.tieba.frs.live.a jiL;
    private p jiM;
    public com.baidu.tieba.frs.vc.c jiN;
    private com.baidu.tieba.frs.mc.e jiO;
    private View.OnTouchListener jiP;
    private com.baidu.tieba.frs.view.a jiQ;
    private com.baidu.tieba.frs.vc.e jiR;
    private boolean jiS;
    private com.baidu.tieba.NEGFeedBack.a jiT;
    private com.baidu.tieba.ala.b jiU;
    private com.baidu.tieba.frs.brand.buttommenu.a jiV;
    private com.baidu.tieba.frs.sportspage.notification.a jiW;
    private AddExperiencedModel jiX;
    private boolean jiZ;
    private com.baidu.tieba.tbadkCore.data.f jia;
    private VoiceManager jie;
    private OvalActionButton jig;
    private FRSRefreshButton jih;
    private LinearLayout jii;
    public long jik;
    private String jiu;
    private ThreadCardViewHolder jiw;
    private FrsModelController jix;
    private com.baidu.tieba.frs.vc.h jiy;
    private FrsTabViewController jiz;
    private List<LiveHorseRaceData> jje;
    private ValueAnimator jjf;
    private Runnable jjg;
    private com.baidu.tieba.frs.live.b jjh;
    private com.baidu.tieba.frs.broadcast.a jji;
    private int jjj;
    private com.baidu.tieba.frs.d.e jjk;
    private int jju;
    private View mRootView;
    private String mSchemeUrl;
    public static boolean jhV = false;
    public static volatile long jim = 0;
    public static volatile long jin = 0;
    public static volatile int mNetError = 0;
    private String jhP = "";
    public boolean jhR = false;
    private boolean jhS = false;
    private boolean jhT = false;
    private boolean jhU = true;
    public String jhW = null;
    public String mFrom = null;
    public int mFlag = 0;
    public boolean jhX = false;
    private boolean jhY = false;
    private String mThreadId = null;
    public String forumId = null;
    private int jhF = 0;
    private boolean jhZ = false;
    private boolean jib = false;
    private boolean jic = false;
    private q jif = null;
    public final cb amn = null;
    private FrsViewData jhD = new FrsViewData();
    public long iKN = -1;
    public long fKU = 0;
    public long fKL = 0;
    public long createTime = 0;
    public long fKM = 0;
    public long fKR = 0;
    public long jil = 0;
    boolean jio = false;
    public boolean jip = false;
    private boolean jiq = false;
    public com.baidu.tbadk.n.b jir = null;
    private boolean jis = true;
    private boolean jit = true;
    private a.C0095a jiv = new a.C0095a(2);
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> jiE = new SparseArray<>();
    private boolean gEY = true;
    private boolean hasInit = false;
    private boolean jiY = false;
    private boolean jja = false;
    private Date jjb = null;
    private int dWJ = 0;
    private int jjc = 0;
    private int jjd = 0;
    public int mHeadLineDefaultNavTabId = -1;
    MessageQueue.IdleHandler jjl = new MessageQueue.IdleHandler() { // from class: com.baidu.tieba.frs.FrsFragment.1
        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            FrsFragment.this.cCV();
            return false;
        }
    };
    private final CustomMessageListener jjm = new CustomMessageListener(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED) { // from class: com.baidu.tieba.frs.FrsFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof cb) {
                    com.baidu.tieba.frs.d.k.a(FrsFragment.this.jif, FrsFragment.this.jhD, FrsFragment.this.getForumId(), true, (cb) data);
                }
            }
        }
    };
    private CustomMessageListener jjn = new CustomMessageListener(CmdConfigCustom.CMD_CLOSE_GAME_RANK_CARD) { // from class: com.baidu.tieba.frs.FrsFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.jhD != null) {
                FrsFragment.this.jhD.removeGameRankListFromThreadList();
                if (FrsFragment.this.jif != null) {
                    FrsFragment.this.jif.bbE();
                }
            }
        }
    };
    private CustomMessageListener aiE = new CustomMessageListener(2921401) { // from class: com.baidu.tieba.frs.FrsFragment.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && FrsFragment.this.jih != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() <= 0 || FrsFragment.this.jiz.cMd() == 0 || FrsFragment.this.jiz.cMa() == null || !(FrsFragment.this.jiz.cMa().fragment instanceof BaseFragment) || !((BaseFragment) FrsFragment.this.jiz.cMa().fragment).isPrimary() || FrsFragment.this.jif.cEs() || com.baidu.tbadk.k.d.bCE().bCF()) {
                    if (FrsFragment.this.jiz.cMd() != 0) {
                        FrsFragment.this.jih.hide();
                        return;
                    }
                    return;
                }
                FrsFragment.this.jih.show();
            }
        }
    };
    private CustomMessageListener jjo = new CustomMessageListener(2921473) { // from class: com.baidu.tieba.frs.FrsFragment.45
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && FrsFragment.this.jih != null && FrsFragment.this.jig != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() == 0) {
                    FrsFragment.this.jih.setVisibility(8);
                    FrsFragment.this.jig.setVisibility(8);
                    return;
                }
                FrsFragment.this.jig.setVisibility(0);
            }
        }
    };
    private CustomMessageListener jjp = new CustomMessageListener(2921467) { // from class: com.baidu.tieba.frs.FrsFragment.56
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && FrsFragment.this.jih != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() <= 0 || FrsFragment.this.jiz.cMa() == null || !(FrsFragment.this.jiz.cMa().fragment instanceof BaseFragment) || !((BaseFragment) FrsFragment.this.jiz.cMa().fragment).isPrimary() || FrsFragment.this.jif.cEs()) {
                    FrsFragment.this.jii.setVisibility(8);
                    FrsFragment.this.jio = true;
                    return;
                }
                FrsFragment.this.jii.setVisibility(0);
                FrsFragment.this.jio = false;
            }
        }
    };
    private com.baidu.adp.framework.listener.a jjq = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_FRS_LIVE_HORSE_RACE_LIST, 309667) { // from class: com.baidu.tieba.frs.FrsFragment.64
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if ((responsedMessage instanceof GetLiveHorseRaceHttpResponseMessage) || (responsedMessage instanceof GetLiveHorseRaceSocketResponseMessage)) {
                    List<LiveHorseRaceData> arrayList = new ArrayList<>();
                    if (responsedMessage instanceof GetLiveHorseRaceHttpResponseMessage) {
                        arrayList = ((GetLiveHorseRaceHttpResponseMessage) responsedMessage).getData().cEU();
                    }
                    if (responsedMessage instanceof GetLiveHorseRaceSocketResponseMessage) {
                        arrayList = ((GetLiveHorseRaceSocketResponseMessage) responsedMessage).getData().cEU();
                    }
                    if (FrsFragment.this.jje != null) {
                        if (FrsFragment.this.jii == null || FrsFragment.this.jii.getVisibility() != 8) {
                            if (FrsFragment.this.jjd >= FrsFragment.this.jje.size()) {
                                FrsFragment.this.jje.addAll(arrayList);
                                return;
                            }
                            FrsFragment.this.jje = FrsFragment.this.jje.subList(0, FrsFragment.this.jjd);
                            FrsFragment.this.jje.addAll(arrayList);
                            return;
                        }
                        FrsFragment.this.jje = new ArrayList();
                        FrsFragment.this.jje.addAll(arrayList);
                        FrsFragment.this.jjd = 0;
                        FrsFragment.this.cDx();
                        return;
                    }
                    FrsFragment.this.jje = new ArrayList();
                    FrsFragment.this.jjd = 0;
                    FrsFragment.this.jje.addAll(arrayList);
                    FrsFragment.this.cDx();
                }
            }
        }
    };
    private CustomMessageListener jjr = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.FrsFragment.65
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 1) {
                    FrsFragment.this.cCZ();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                }
            }
        }
    };
    private final ar jjs = new ar() { // from class: com.baidu.tieba.frs.FrsFragment.66
        @Override // com.baidu.tieba.frs.ar
        public void a(int i, int i2, ba baVar, ArrayList<com.baidu.adp.widget.ListView.n> arrayList) {
            FrsFragment.this.cCK();
            if (FrsFragment.this.jiF != null) {
                FrsFragment.this.jiy.rD(FrsFragment.this.jiF.zn(i));
            }
            com.baidu.tieba.tbadkCore.f fVar = new com.baidu.tieba.tbadkCore.f();
            if (baVar != null) {
                fVar.isSuccess = baVar.errCode == 0;
                fVar.errorCode = baVar.errCode;
                fVar.errorMsg = baVar.errMsg;
                if (fVar.isSuccess) {
                    if (com.baidu.tbadk.core.util.y.isEmpty(arrayList)) {
                        FrsFragment.this.jif.bSE();
                    } else if (baVar.hasMore) {
                        if (com.baidu.tbadk.core.util.y.getCount(FrsFragment.this.jhD.getThreadList()) > 3) {
                            FrsFragment.this.jif.Xa();
                        } else {
                            FrsFragment.this.jif.cEj();
                        }
                    } else if (baVar.jnf) {
                        FrsFragment.this.jif.Xb();
                    } else {
                        FrsFragment.this.jif.bSE();
                    }
                }
            } else {
                baVar = new ba();
                baVar.pn = 1;
                baVar.hasMore = false;
                baVar.jnf = false;
            }
            if (i == 1) {
                FrsFragment.this.jis = true;
                FrsFragment.this.jjK.a(FrsFragment.this.jix.getType(), false, fVar);
            } else {
                FrsFragment.this.a(fVar);
                if (FrsFragment.this.jix.cJo() != null) {
                    FrsFragment.this.jhD = FrsFragment.this.jix.cJo();
                }
                FrsFragment.this.cDb();
            }
            if (FrsFragment.this.jjS != null) {
                FrsFragment.this.jjS.a(i, i2, baVar, arrayList);
            }
        }
    };
    private FrsTabViewController.a jjt = new FrsTabViewController.a() { // from class: com.baidu.tieba.frs.FrsFragment.2
        @Override // com.baidu.tieba.frs.vc.FrsTabViewController.a
        public void l(int i, int i2, String str) {
            boolean z = false;
            if (i != 1) {
                com.baidu.tieba.card.t.csH().pB(false);
                FrsFragment.this.qu(false);
            }
            if (i == 502) {
                FrsFragment.this.jig.setIconFade(R.drawable.btn_frs_professional_edit_n);
            } else {
                FrsFragment.this.jig.setIconFade(0);
            }
            FrsFragment.this.jju = i;
            FrsFragment.this.jjj = i2;
            if (FrsFragment.this.jjh != null) {
                FrsFragment.this.jjh.zY(FrsFragment.this.jjj);
            }
            TbSingleton.getInstance().setFrsCurTabType(FrsFragment.this.jjj);
            FrsFragment.this.cDh();
            com.baidu.tieba.frs.b.d.jsn.jJk = i;
            com.baidu.tieba.frs.b.d.jsn.jJn = i2;
            com.baidu.tieba.frs.b.d.jsn.jJl = -1;
            b.cBE().X(i == 1 && FrsFragment.this.jiY, true);
            com.baidu.tieba.frs.a cBx = com.baidu.tieba.frs.a.cBx();
            if (i == 1 && FrsFragment.this.jiY) {
                z = true;
            }
            cBx.X(z, true);
        }
    };
    private CustomMessageListener jjv = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIVE_COUNT) { // from class: com.baidu.tieba.frs.FrsFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                FrsFragment.this.jiz.AJ(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    };
    private CustomMessageListener jjw = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_LIVE_START) { // from class: com.baidu.tieba.frs.FrsFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && ((Integer) customResponsedMessage.getData()).intValue() == 51 && FrsFragment.this.jhD != null) {
                com.baidu.tieba.frs.d.m.a(FrsFragment.this.jhD, FrsFragment.this.getPageContext());
            }
        }
    };
    private final CustomMessageListener jjx = new CustomMessageListener(CmdConfigCustom.CMD_FRS_SELECT_ALA_LIVE_TAB) { // from class: com.baidu.tieba.frs.FrsFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                FrsFragment.this.jiz.sV(49);
            }
        }
    };
    private final CustomMessageListener jjy = new CustomMessageListener(2921470) { // from class: com.baidu.tieba.frs.FrsFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                FrsFragment.this.jiz.sV(1);
                FrsFragment.this.cCZ();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
            }
        }
    };
    private final CustomMessageListener jjz = new CustomMessageListener(CmdConfigCustom.CMD_FRS_EXPERIENCE_TIP) { // from class: com.baidu.tieba.frs.FrsFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.w) && FrsFragment.this.jhD != null) {
                FrsFragment.this.jhD.updateLikeData((com.baidu.tieba.tbadkCore.w) customResponsedMessage.getData());
                FrsFragment.this.jiy.j(FrsFragment.this.jhD);
                FrsFragment.this.jiz.a(FrsFragment.this.jhD, FrsFragment.this.jix.cJS());
            }
        }
    };
    private final AntiHelper.a jjA = new AntiHelper.a() { // from class: com.baidu.tieba.frs.FrsFragment.8
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).aq("obj_locate", ay.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).aq("obj_locate", ay.a.LOCATE_LIKE_PERSON));
        }
    };
    private CustomMessageListener jjB = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.FrsFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(FrsFragment.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().fud != null) {
                        if (AntiHelper.a(FrsFragment.this.getActivity(), updateAttentionMessage.getData().fud, FrsFragment.this.jjA) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).aq("obj_locate", ay.a.LOCATE_LIKE_PERSON));
                        }
                    } else if (updateAttentionMessage.getData().isSucc && updateAttentionMessage.getData().isAttention) {
                        com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getPageContext().getPageActivity(), R.string.attention_success);
                    }
                }
            }
        }
    };
    private CustomMessageListener jjC = new CustomMessageListener(CmdConfigCustom.CMD_GET_ENSURE_CAST_ID) { // from class: com.baidu.tieba.frs.FrsFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsFragment.this.refresh();
        }
    };
    private CustomMessageListener jjD = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.frs.FrsFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                FrsFragment.this.jif.c((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener jjE = new CustomMessageListener(2001378) { // from class: com.baidu.tieba.frs.FrsFragment.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof WriteData) && com.baidu.tbadk.core.util.au.equals(((WriteData) customResponsedMessage.getData()).getForumId(), FrsFragment.this.forumId)) {
                FrsFragment.this.jiK.Aa(((WriteData) customResponsedMessage.getData()).getTabId());
                MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
            }
        }
    };
    private CustomMessageListener jjF = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_REMIND) { // from class: com.baidu.tieba.frs.FrsFragment.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626) {
                NewsRemindMessage newsRemindMessage = (NewsRemindMessage) customResponsedMessage;
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (FrsFragment.this.jif != null) {
                    FrsFragment.this.jif.P(notificationCount, z);
                }
            }
        }
    };
    private HttpMessageListener jjG = new HttpMessageListener(CmdConfigHttp.CMD_FRS_MOVE_AREA) { // from class: com.baidu.tieba.frs.FrsFragment.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int i;
            int i2 = 0;
            if (httpResponsedMessage != null && FrsFragment.this.getContext() != null && FrsFragment.this.jif != null) {
                if (httpResponsedMessage.getError() == 0) {
                    new BdTopToast(FrsFragment.this.getContext()).zm(true).Vg(FrsFragment.this.getContext().getString(R.string.frs_move_area_move_suc)).aR(FrsFragment.this.jif.cnA());
                    if (com.baidu.tieba.frs.a.cBx().yu(com.baidu.tieba.frs.a.cBx().cBz())) {
                        FrsCommonTabFragment frsCommonTabFragment = null;
                        if (FrsFragment.this.jiz != null && FrsFragment.this.jiz.cMa() != null && (FrsFragment.this.jiz.cMa().fragment instanceof FrsCommonTabFragment)) {
                            frsCommonTabFragment = (FrsCommonTabFragment) FrsFragment.this.jiz.cMa().fragment;
                        }
                        if (frsCommonTabFragment != null) {
                            frsCommonTabFragment.cFP();
                        }
                        FrsFragment.this.cBC();
                        com.baidu.tieba.frs.a.cBx().cBC();
                        Iterator<com.baidu.adp.widget.ListView.n> it = FrsFragment.this.jhD.getThreadList().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                i = i2;
                                break;
                            }
                            i = it.next() instanceof ca ? i2 + 1 : i2;
                            if (i >= 6) {
                                break;
                            }
                            i2 = i;
                        }
                        if (i < 6) {
                            FrsFragment.this.bRp();
                        }
                    }
                    com.baidu.tieba.frs.a.cBx().reset();
                    return;
                }
                new BdTopToast(FrsFragment.this.getContext()).zm(false).Vg(httpResponsedMessage.getErrorString()).aR(FrsFragment.this.jif.cnA());
            }
        }
    };
    private com.baidu.tbadk.mutiprocess.h mTopToastEventListener = new com.baidu.tbadk.mutiprocess.h<TopToastEvent>() { // from class: com.baidu.tieba.frs.FrsFragment.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.mutiprocess.b
        public boolean a(TopToastEvent topToastEvent) {
            new BdTopToast(FrsFragment.this.getContext()).zm(topToastEvent.isSuccess()).Vg(topToastEvent.getContent()).aR(FrsFragment.this.jif.cnA());
            return false;
        }
    };
    private final CustomMessageListener jjH = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.frs.FrsFragment.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.isResumed()) {
                FrsFragment.this.cDw();
            }
        }
    };
    private CustomMessageListener jjI = new CustomMessageListener(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER) { // from class: com.baidu.tieba.frs.FrsFragment.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (FrsFragment.this.jif != null) {
                    FrsFragment.this.jif.setExpanded(booleanValue);
                }
            }
        }
    };
    private final CustomMessageListener jjJ = new CustomMessageListener(2921463) { // from class: com.baidu.tieba.frs.FrsFragment.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TbadkApplication.getInst().getCurrentActivity() != null && !com.baidu.tbadk.core.util.au.isEmpty(str) && str.equals(FrsFragment.this.forumId)) {
                    com.baidu.tieba.frs.d.h.b(((TbPageContextSupport) TbadkApplication.getInst().getCurrentActivity()).getPageContext(), FrsFragment.this.jhD);
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.s jjK = new com.baidu.tieba.tbadkCore.s() { // from class: com.baidu.tieba.frs.FrsFragment.20
        private long startTime = 0;

        @Override // com.baidu.tieba.tbadkCore.s
        public void yB(int i) {
            this.startTime = System.nanoTime();
            if (FrsFragment.this.jif != null) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsFragment.this.jif.cDU();
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
            if (FrsFragment.this.gEY) {
                FrsFragment.this.gEY = false;
                com.baidu.tieba.frs.d.k.a(FrsFragment.this.jif, FrsFragment.this.jhD, FrsFragment.this.getForumId(), false, null);
            }
            FrsFragment.this.cCK();
            FrsFragment.this.jiq = true;
            if (fVar != null && fVar.isSuccess) {
                FrsFragment.this.jif.cEh().rf(com.baidu.tbadk.core.util.av.bsV().bsW());
                FrsFragment.jim = 0L;
                FrsFragment.jin = 0L;
                FrsFragment.mNetError = 0;
            } else {
                FrsFragment.mNetError = 1;
            }
            if (!FrsFragment.this.jix.cJX() && (i == 3 || i == 6)) {
                FrsFragment.this.jiI.resetData();
            }
            FrsFragment.this.jik = System.currentTimeMillis();
            if (FrsFragment.this.jix.cJo() != null) {
                FrsFragment.this.jhD = FrsFragment.this.jix.cJo();
            }
            FrsFragment.this.yx(1);
            FrsFragment.this.cCS();
            if (i == 7) {
                FrsFragment.this.yy(FrsFragment.this.jhD.getFrsDefaultTabId());
                return;
            }
            if (FrsFragment.this.jhD.getPage() != null) {
                FrsFragment.this.setHasMore(FrsFragment.this.jhD.getPage().bmH());
            }
            if (i == 4) {
                if (!FrsFragment.this.jix.cJX() && TbadkCoreApplication.getInst().isRecAppExist() && FrsFragment.this.jix.cJN() == 1 && !com.baidu.tieba.funad.a.cNC()) {
                    FrsFragment.this.jhD.addRecommendAppToThreadList(FrsFragment.this);
                }
                ArrayList<com.baidu.adp.widget.ListView.n> a2 = FrsFragment.this.jiI.a(false, false, FrsFragment.this.jhD.getThreadList(), FrsFragment.this.jia, false);
                if (a2 != null) {
                    FrsFragment.this.jhD.setThreadList(a2);
                    FrsFragment.this.jhD.checkLiveStageInThreadList();
                }
                if (FrsFragment.this.jix != null) {
                    com.baidu.tieba.frs.b.c.a(FrsFragment.this.jhD, FrsFragment.this.jix.cJS(), 2, FrsFragment.this.getContext());
                }
                com.baidu.tieba.frs.d.a.a(FrsFragment.this, FrsFragment.this.jhD.getForum(), FrsFragment.this.jhD.getThreadList(), false, FrsFragment.this.getPn());
                FrsFragment.this.jif.a(a2, FrsFragment.this.jhD);
                FrsFragment.this.cCL();
                return;
            }
            FrsFragment.this.cCL();
            switch (i) {
                case 1:
                    FrsFragment.this.jif.cDU();
                    break;
                case 2:
                    FrsFragment.this.jif.cDU();
                    break;
                case 3:
                case 6:
                    if (FrsFragment.this.jhD != null) {
                        FrsFragment.this.jhD.clearPostThreadCount();
                    }
                    if (FrsFragment.this.jiN != null) {
                        FrsFragment.this.jiN.refresh();
                        break;
                    }
                    break;
            }
            FrsFragment.this.cCT();
            if (fVar == null || fVar.errorCode == 0) {
                if (FrsFragment.this.jhD != null) {
                    FrsFragment.this.a(FrsFragment.this.jhD);
                    FrsFragment.this.Z(false, i == 5);
                    if (FrsFragment.this.jix != null) {
                        if (FrsFragment.this.jhD.getActivityHeadData() != null && FrsFragment.this.jhD.getActivityHeadData().blT() != null && FrsFragment.this.jhD.getActivityHeadData().blT().size() > 0) {
                            com.baidu.tieba.frs.b.a.a(FrsFragment.this.getUniqueId(), 1, FrsFragment.this.jhD.getForum(), FrsFragment.this.jix.getSortType(), 1);
                        }
                        if (FrsFragment.this.jhD.getThreadList() != null && FrsFragment.this.jhD.getThreadList().size() > 0) {
                            Iterator<com.baidu.adp.widget.ListView.n> it = FrsFragment.this.jhD.getThreadList().iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    com.baidu.adp.widget.ListView.n next = it.next();
                                    if ((next instanceof cb) && ((cb) next).getType() == cb.eTQ) {
                                        com.baidu.tieba.frs.b.a.a(FrsFragment.this.getUniqueId(), 1, FrsFragment.this.jhD.getForum(), FrsFragment.this.jix.getSortType(), 2);
                                    }
                                }
                            }
                        }
                        com.baidu.tieba.frs.b.a.a(FrsFragment.this.getUniqueId(), FrsFragment.this.jhD.getThreadList(), FrsFragment.this.jhD.getForum(), FrsFragment.this.jix.getSortType());
                    }
                    FrsFragment.this.jif.yO(i);
                    FrsFragment.jim = (System.nanoTime() - this.startTime) / TimeUtils.NANOS_PER_MS;
                    if (fVar != null) {
                        FrsFragment.jin = fVar.nwK;
                    }
                } else {
                    return;
                }
            } else if (FrsFragment.this.jhD == null || com.baidu.tbadk.core.util.y.isEmpty(FrsFragment.this.jhD.getThreadList())) {
                FrsFragment.this.a(fVar);
            } else if (fVar.iSg) {
                FrsFragment.this.showToast(FrsFragment.this.getPageContext().getResources().getString(R.string.net_error_text, fVar.errorMsg, Integer.valueOf(fVar.errorCode)));
            }
            FrsFragment.this.cCP();
            FrsFragment.this.cCQ();
            if (FrsFragment.this.jhD.getAccessFlag() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11384"));
            }
            if (FrsFragment.this.jib && FrsFragment.this.jiz.sV(49)) {
                FrsFragment.this.jib = false;
            }
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.s
        public void c(com.baidu.tieba.tbadkCore.m mVar) {
            if ((mVar != null && ("normal_page".equals(FrsFragment.this.jix.getPageType()) || "frs_page".equals(FrsFragment.this.jix.getPageType()) || "book_page".equals(FrsFragment.this.jix.getPageType()))) || "brand_page".equals(FrsFragment.this.jix.getPageType())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE, mVar));
                FrsFragment.this.b(mVar);
                FrsFragment.jij = mVar;
            }
        }

        @Override // com.baidu.tieba.tbadkCore.s
        public void cCV() {
            FrsFragment.this.cCV();
        }
    };
    private final CustomMessageListener jjL = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.frs.FrsFragment.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.n) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                FrsFragment.this.jhD.updateCurrentUserPendant((com.baidu.tbadk.data.n) customResponsedMessage.getData());
                FrsFragment.this.jif.cEh().notifyDataSetChanged();
            }
        }
    };
    private final CustomMessageListener mMemListener = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_MEM) { // from class: com.baidu.tieba.frs.FrsFragment.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && FrsFragment.this.jhD != null && (userData = FrsFragment.this.jhD.getUserData()) != null) {
                userData.setIsMem(num.intValue());
                if (num.intValue() != 0) {
                    FrsFragment.this.jiy.q(num);
                }
            }
        }
    };
    private final f.a jjM = new AnonymousClass31();
    private final com.baidu.tieba.frs.mc.k jjN = new com.baidu.tieba.frs.mc.k() { // from class: com.baidu.tieba.frs.FrsFragment.32
        @Override // com.baidu.tieba.frs.mc.k
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.n> arrayList, boolean z3) {
            if (FrsFragment.this.jiB != null && FrsFragment.this.jix != null && FrsFragment.this.jix.cJX() && z && !z2 && !z3) {
                FrsFragment.this.jiB.Ag(i2);
            }
        }
    };
    public final View.OnTouchListener bUt = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.FrsFragment.33
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (FrsFragment.this.jiP != null) {
                FrsFragment.this.jiP.onTouch(view, motionEvent);
            }
            if (FrsFragment.this.jiD != null && FrsFragment.this.jiD.cEV() != null) {
                FrsFragment.this.jiD.cEV().onTouchEvent(motionEvent);
            }
            if (FrsFragment.this.gXE != null) {
                FrsFragment.this.gXE.i(view, motionEvent);
            }
            if (FrsFragment.this.jiy != null) {
                FrsFragment.this.jiy.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private final CustomMessageListener jjO = new CustomMessageListener(CmdConfigCustom.CMD_GOTOLIVE_HOST_UPGRADE) { // from class: com.baidu.tieba.frs.FrsFragment.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.brR().getInt(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.PHOTOLIVE_HOSTLEVEL, -1) != -1 && FrsFragment.this.jhD.getForum() != null) {
                FrsFragment.this.jhD.getForum().setCanAddPhotoLivePost(true);
            }
        }
    };
    public final View.OnClickListener jjP = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.41
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsFragment.this.jif != null && view == FrsFragment.this.jif.cDS() && FrsFragment.this.getActivity() != null) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, FrsFragment.this.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            if (view.getId() == R.id.game_activity_egg_layout && com.baidu.adp.lib.util.l.isNetOk()) {
                TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_CLICK);
                if (FrsFragment.this.jif == null || !FrsFragment.this.jif.cEe()) {
                    String activityUrl = FrsFragment.this.jhD.getForum().getYuleData().bqq().getActivityUrl();
                    if (!StringUtils.isNull(activityUrl)) {
                        com.baidu.tbadk.browser.a.startInternalWebActivity(FrsFragment.this.getPageContext().getPageActivity(), activityUrl);
                    }
                } else {
                    FrsFragment.this.jif.cEf();
                }
            }
            if (FrsFragment.this.jif != null && view == FrsFragment.this.jif.cEk() && FrsFragment.this.jix != null && FrsFragment.this.jix.hasMore()) {
                FrsFragment.this.jif.Xa();
                FrsFragment.this.bRp();
            }
            if (view != null && FrsFragment.this.jif != null && view == FrsFragment.this.jif.cEb()) {
                if (bh.checkUpIsLogin(FrsFragment.this.getContext())) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).aq("obj_locate", 2));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MessageCenterActivityConfig(FrsFragment.this.getContext())));
                } else {
                    return;
                }
            }
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (FrsFragment.this.jhD != null && FrsFragment.this.jhD.getForum() != null) {
                    if (FrsFragment.this.jif != null && view == FrsFragment.this.jif.cDZ()) {
                        if (FrsFragment.this.jhD != null && FrsFragment.this.jhD.getForum() != null && !StringUtils.isNull(FrsFragment.this.jhD.getForum().getId()) && !StringUtils.isNull(FrsFragment.this.jhD.getForum().getName())) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.KEY_SHARE_CLICK).dR("fid", FrsFragment.this.jhD.getForum().getId()).aq("obj_locate", 11));
                            com.baidu.tieba.frs.d.h.a(FrsFragment.this.getPageContext(), FrsFragment.this.jhD, FrsFragment.this.jhD.getForum().getId());
                        } else {
                            return;
                        }
                    }
                    if (FrsFragment.this.jif != null && view == FrsFragment.this.jif.cDY()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12402").dR("fid", FrsFragment.this.jhD.getForum().getId()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fname", FrsFragment.this.jhD.getForum().getName()));
                        if (!StringUtils.isNull(FrsFragment.this.jhD.getForum().getName())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PostSearchActivityConfig(FrsFragment.this.getContext(), FrsFragment.this.jhD.getForum().getName(), FrsFragment.this.jhD.getForum().getId())));
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
        private int jkn = 0;
        private int gAO = 0;

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsFragment.this.jjc += i2;
            if (FrsFragment.this.jjc >= FrsFragment.this.dWJ * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
            if (FrsFragment.this.jiG != null) {
                FrsFragment.this.jiG.cKT();
            }
            this.jkn = 0;
            this.gAO = 0;
            if (recyclerView != null && (recyclerView instanceof BdRecyclerView)) {
                this.jkn = ((BdRecyclerView) recyclerView).getFirstVisiblePosition();
                this.gAO = ((BdRecyclerView) recyclerView).getLastVisiblePosition();
            }
            if (FrsFragment.this.jiR != null) {
                FrsFragment.this.jiR.a(recyclerView, this.jkn, this.gAO);
            }
            if (FrsFragment.this.jhD != null && FrsFragment.this.jif != null && FrsFragment.this.jif.cEh() != null) {
                FrsFragment.this.jif.co(this.jkn, this.gAO);
                if (FrsFragment.this.jiw != null && FrsFragment.this.jiw.tj() != null) {
                    FrsFragment.this.jiw.tj().b(FrsFragment.this.jiv);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (FrsFragment.this.jiy != null) {
                FrsFragment.this.jiy.setScrollState(i);
                if (i == 1) {
                    FrsFragment.this.jiy.cLv();
                }
            }
            if (FrsFragment.this.jir == null && !FrsFragment.this.cDp()) {
                FrsFragment.this.jir = new com.baidu.tbadk.n.b();
                FrsFragment.this.jir.setSubType(1000);
            }
            if (i == 0) {
                if (FrsFragment.this.jir != null) {
                    FrsFragment.this.jir.bEd();
                }
                com.baidu.tieba.card.t.csH().pB(true);
                FrsFragment.this.qu(true);
                FrsFragment.this.jif.cn(this.jkn, this.gAO);
            } else if (FrsFragment.this.jir != null) {
                FrsFragment.this.jir.bEc();
            }
            if (FrsFragment.this.jiR != null) {
                FrsFragment.this.jiR.onScrollStateChanged(recyclerView, i);
            }
            if (i == 0) {
                com.baidu.tieba.frs.d.k.a(FrsFragment.this.jif, FrsFragment.this.jhD, FrsFragment.this.getForumId(), false, null);
            }
            if (FrsFragment.this.jiz != null && i == 1) {
                FrsFragment.this.jiz.cMc();
            }
            if (FrsFragment.this.jiw == null) {
                if (FrsFragment.this.jif.cDL() != null && !FrsFragment.this.jif.cDn() && FrsFragment.this.jif.cDL().dAk() != null && (FrsFragment.this.jif.cDL().dAk().getTag() instanceof ThreadCardViewHolder)) {
                    FrsFragment.this.jiw = (ThreadCardViewHolder) FrsFragment.this.jif.cDL().dAk().getTag();
                }
            } else if (i == 0 && FrsFragment.this.jif.cDL() != null && !FrsFragment.this.jif.cDn() && FrsFragment.this.jif.cDL().dAk() != null && (FrsFragment.this.jif.cDL().dAk().getTag() instanceof ThreadCardViewHolder)) {
                FrsFragment.this.jiw = (ThreadCardViewHolder) FrsFragment.this.jif.cDL().dAk().getTag();
            }
            if (i == 1) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921418));
            }
        }
    };
    private final f jjQ = new f() { // from class: com.baidu.tieba.frs.FrsFragment.43
        @Override // com.baidu.tieba.frs.f
        public void a(int i, int i2, View view, View view2, cb cbVar) {
            if (i != FrsFragment.this.jif.cEh().cGI()) {
                if (i != FrsFragment.this.jif.cEh().cGJ()) {
                    if (i == FrsFragment.this.jif.cEh().cGG() && FrsFragment.this.jhD != null && FrsFragment.this.jhD.getUserData() != null && FrsFragment.this.jhD.getUserData().isBawu()) {
                        String bawuCenterUrl = FrsFragment.this.jhD.getBawuCenterUrl();
                        if (!com.baidu.tbadk.core.util.au.isEmpty(bawuCenterUrl) && FrsFragment.this.jhD.getForum() != null) {
                            com.baidu.tbadk.browser.a.startWebActivity(FrsFragment.this.getPageContext().getPageActivity(), bawuCenterUrl);
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10502").dR("fid", FrsFragment.this.jhD.getForum().getId()).dR("uid", FrsFragment.this.jhD.getUserData().getUserId()));
                        }
                    }
                } else if (bh.checkUpIsLogin(FrsFragment.this.getPageContext().getPageActivity())) {
                    TiebaStatic.log(CommonStatisticKey.MY_SERVICE_CK);
                    if (FrsFragment.this.jhD != null && FrsFragment.this.jhD.getForum() != null) {
                        ForumData forum = FrsFragment.this.jhD.getForum();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(forum.getId(), 0L), forum.getName(), forum.getImage_url(), 0)));
                    }
                }
            } else if (bh.checkUpIsLogin(FrsFragment.this.getActivity())) {
                TiebaStatic.log("forum_fortune_click");
                com.baidu.tieba.frs.d.l.c(FrsFragment.this.getPageContext(), FrsFragment.this.jhD);
            }
        }
    };
    private final NoNetworkView.a jfq = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.FrsFragment.44
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (FrsFragment.this.jix.cJN() == 1 && z && !FrsFragment.this.jif.cDn()) {
                if (FrsFragment.this.jhD == null || com.baidu.tbadk.core.util.y.isEmpty(FrsFragment.this.jhD.getThreadList())) {
                    FrsFragment.this.hideNetRefreshView(FrsFragment.this.jif.cEv().cLQ());
                    FrsFragment.this.showLoadingView(FrsFragment.this.jif.cnA(), true);
                    FrsFragment.this.jif.qF(false);
                    FrsFragment.this.refresh();
                    return;
                }
                FrsFragment.this.jif.cDU();
            }
        }
    };
    private final CustomMessageListener fuv = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.FrsFragment.46
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                com.baidu.tieba.frs.d.c.a(customResponsedMessage, FrsFragment.this.jif, FrsFragment.this.jhD);
            }
        }
    };
    private com.baidu.adp.widget.ListView.w jjR = new a();
    private ar jjS = new ar() { // from class: com.baidu.tieba.frs.FrsFragment.48
        @Override // com.baidu.tieba.frs.ar
        public void a(int i, int i2, ba baVar, ArrayList<com.baidu.adp.widget.ListView.n> arrayList) {
            com.baidu.adp.lib.f.e.mA().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.48.1
                @Override // java.lang.Runnable
                public void run() {
                    if (FrsFragment.this.jif != null && FrsFragment.this.jif.cEn()) {
                        FrsFragment.this.bRp();
                    }
                }
            });
        }
    };
    private CustomMessageListener jjT = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.frs.FrsFragment.49
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    FrsFragment.this.jiS = true;
                }
            }
        }
    };
    private CustomMessageListener jjU = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.frs.FrsFragment.50
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                    if (FrsFragment.this.jiw == null && FrsFragment.this.jif.cDL() != null && !FrsFragment.this.jif.cDn() && FrsFragment.this.jif.cDL().dAk() != null && (FrsFragment.this.jif.cDL().dAk().getTag() instanceof ThreadCardViewHolder)) {
                        FrsFragment.this.jiw = (ThreadCardViewHolder) FrsFragment.this.jif.cDL().dAk().getTag();
                    }
                    if (FrsFragment.this.jiw != null && FrsFragment.this.jiw.tj() != null) {
                        FrsFragment.this.jiw.tj().b(new a.C0095a(3));
                    }
                }
            }
        }
    };
    private CustomMessageListener jjV = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.FrsFragment.51
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.jif != null) {
                FrsFragment.this.jif.EN();
            }
        }
    };
    private CustomMessageListener jjW = new CustomMessageListener(2921437) { // from class: com.baidu.tieba.frs.FrsFragment.52
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && FrsFragment.this.isResumed()) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (FrsFragment.this.jih != null) {
                    if (booleanValue) {
                        if (FrsFragment.this.jiz.cMd() != 0 && !FrsFragment.this.jif.cEs() && !com.baidu.tbadk.k.d.bCE().bCF()) {
                            FrsFragment.this.jih.show();
                            return;
                        }
                        return;
                    }
                    FrsFragment.this.jih.hide();
                }
            }
        }
    };
    private CustomMessageListener jjX = new CustomMessageListener(2921462) { // from class: com.baidu.tieba.frs.FrsFragment.58
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && FrsFragment.this.jhD.getToLoadHorseData().intValue() == 1 && FrsFragment.this.mIsLogin) {
                LiveHorseRaceRequestMessage liveHorseRaceRequestMessage = new LiveHorseRaceRequestMessage();
                liveHorseRaceRequestMessage.setForum_id(Long.valueOf(FrsFragment.this.forumId));
                FrsFragment.this.sendMessage(liveHorseRaceRequestMessage);
            }
        }
    };
    private CustomMessageListener jjY = new CustomMessageListener(2001223) { // from class: com.baidu.tieba.frs.FrsFragment.59
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Date)) {
                FrsFragment.this.jjb = (Date) customResponsedMessage.getData();
            }
        }
    };
    private CustomMessageListener jjZ = new CustomMessageListener(2921469) { // from class: com.baidu.tieba.frs.FrsFragment.60
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.z) && FrsFragment.this.isResumed()) {
                com.baidu.tbadk.core.data.z zVar = (com.baidu.tbadk.core.data.z) customResponsedMessage.getData();
                if (FrsFragment.this.jji == null) {
                    FrsFragment.this.jji = new com.baidu.tieba.frs.broadcast.a(FrsFragment.this.getPageContext());
                }
                if (FrsFragment.this.jhD != null && FrsFragment.this.jhD.getForum() != null && !TextUtils.isEmpty(FrsFragment.this.jhD.getForum().getId())) {
                    FrsFragment.this.jji.e(zVar.type, FrsFragment.this.jhD.getForum().getId(), FrsFragment.this.jhD.getForum().getName(), zVar.tid);
                }
            }
        }
    };
    private CustomMessageListener jka = new CustomMessageListener(2921475) { // from class: com.baidu.tieba.frs.FrsFragment.61
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            cb cbVar = (cb) customResponsedMessage.getData();
            if (cbVar != null && FrsFragment.this.isResumed()) {
                FrsFragment.this.jiu = cbVar.getTid() + "";
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE_NUMBER);
                httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
                httpMessage.addParam("forum_id", cbVar.getFid());
                MessageManager.getInstance().sendMessage(httpMessage);
            }
        }
    };
    private HttpMessageListener jkb = new HttpMessageListener(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE_NUMBER) { // from class: com.baidu.tieba.frs.FrsFragment.62
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if ((httpResponsedMessage instanceof ForumManagerRightsResMsg) && FrsFragment.this.isResumed()) {
                ForumManagerRightsResMsg forumManagerRightsResMsg = (ForumManagerRightsResMsg) httpResponsedMessage;
                if (forumManagerRightsResMsg.broadcastTotalCount - forumManagerRightsResMsg.broadcastUsedCount <= 0) {
                    new ScreenTopToast(FrsFragment.this.getContext()).Vl(FrsFragment.this.getString(R.string.frs_forum_bawu_send_broadcast_none_tip)).Vn(FrsFragment.this.getString(R.string.frs_recommend_fail_tip_btn)).ao(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.62.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("_forumId", FrsFragment.this.jhD.getForum().getId());
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new com.baidu.tieba.tbadkCore.data.m(FrsFragment.this.getContext(), "ForumGradePage", hashMap)));
                        }
                    }).aR((ViewGroup) FrsFragment.this.mRootView.findViewById(R.id.frs));
                    return;
                }
                com.baidu.tbadk.core.util.p pVar = new com.baidu.tbadk.core.util.p(TbadkCoreApplication.getInst());
                pVar.ap(FrsFragment.this.jhD.getForum().getId(), FrsFragment.this.jhD.getForum().getName(), "6");
                pVar.Bb(FrsFragment.this.jiu);
                pVar.start();
            }
        }
    };
    private CustomMessageListener jkc = new CustomMessageListener(2921515) { // from class: com.baidu.tieba.frs.FrsFragment.63
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                com.baidu.tieba.NEGFeedBack.g gVar = (com.baidu.tieba.NEGFeedBack.g) customResponsedMessage.getData();
                if (FrsFragment.this.jhD == null || FrsFragment.this.jhD.getForum() == null || FrsFragment.this.jhD.getForum().getDeletedReasonInfo() == null) {
                    com.baidu.tieba.NEGFeedBack.d.a(0, FrsFragment.this.getPageContext(), gVar, null, FrsFragment.this.jhD.getUserData());
                    return;
                }
                com.baidu.tieba.NEGFeedBack.h hVar = new com.baidu.tieba.NEGFeedBack.h(FrsFragment.this.jhD.getForum().getDeletedReasonInfo().is_grays_cale_forum.intValue(), FrsFragment.this.jhD.getForum().getDeletedReasonInfo().is_boomgrow.intValue(), FrsFragment.this.jhD.forumRule != null ? FrsFragment.this.jhD.forumRule.has_forum_rule.intValue() : 0);
                hVar.eg(FrsFragment.this.jhD.getForum().getId(), FrsFragment.this.jhD.getForum().getName());
                hVar.setForumHeadUrl(FrsFragment.this.jhD.getForum().getImage_url());
                hVar.setUserLevel(FrsFragment.this.jhD.getForum().getUser_level());
                com.baidu.tieba.NEGFeedBack.d.a(hVar.bKE(), FrsFragment.this.getPageContext(), gVar, hVar, FrsFragment.this.jhD.getUserData());
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.frs.loadmore.a
    public /* bridge */ /* synthetic */ com.baidu.adp.base.f getPageContext() {
        return super.getPageContext();
    }

    public com.baidu.tieba.frs.entelechy.a.b cCy() {
        return this.jiF;
    }

    public com.baidu.adp.widget.ListView.w cCz() {
        return this.jjR;
    }

    public com.baidu.tieba.frs.mc.d cCA() {
        return this.jiH;
    }

    public com.baidu.tieba.frs.smartsort.a cCB() {
        return this.jiB;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public FrsModelController cCC() {
        return this.jix;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public com.baidu.tieba.frs.mc.c cCD() {
        return this.jiI;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public com.baidu.tieba.frs.vc.h cCE() {
        return this.jiy;
    }

    public FrsTabViewController cCF() {
        return this.jiz;
    }

    public at cCG() {
        return this.jiD;
    }

    public void qt(boolean z) {
        this.jja = z;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public q cCH() {
        return this.jif;
    }

    @Override // com.baidu.tieba.frs.as
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.as, com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.jhW;
    }

    public void setForumName(String str) {
        this.jhW = str;
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

    @Override // com.baidu.tieba.recapp.q
    public String getFid() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.recapp.q
    public int getPageNum() {
        if (this.jiI == null) {
            return 1;
        }
        return this.jiI.getPn();
    }

    public int getPn() {
        if (this.jiI == null) {
            return 1;
        }
        return this.jiI.getPn();
    }

    public void setPn(int i) {
        if (this.jiI != null) {
            this.jiI.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.jiI != null) {
            this.jiI.setHasMore(i);
        }
    }

    public int cCI() {
        if (this.jiI == null) {
            return -1;
        }
        return this.jiI.cCI();
    }

    public boolean cCJ() {
        return this.jic;
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
            this.jif.cDO();
            showNetRefreshView(this.jif.cnA(), string, true);
        } else if (340001 == fVar.errorCode) {
            a(fVar, this.jhD.getRecm_forum_list());
        } else {
            if (com.baidu.tbadk.core.util.y.isEmpty(this.jhD.getThreadList())) {
                b(fVar);
            }
            if (cDp()) {
                setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds280));
            } else {
                setNetRefreshViewEmotionDefMarginTop();
            }
        }
    }

    public void a(View view, String str, boolean z, List<RecmForumInfo> list) {
        this.jif.cDO();
        this.jif.yI(8);
        if (this.jiQ == null) {
            this.jiQ = new com.baidu.tieba.frs.view.a(getPageContext(), getNetRefreshListener());
        }
        this.jiQ.setSubText(str);
        this.jiQ.setListData(list);
        this.jiQ.attachView(view, z);
    }

    private void a(com.baidu.tieba.tbadkCore.f fVar, List<RecmForumInfo> list) {
        if (this.jif != null) {
            this.jif.cDO();
            this.jif.setTitle(this.jhW);
            a(this.jif.cnA(), fVar.errorMsg, true, list);
        }
    }

    private void b(com.baidu.tieba.tbadkCore.f fVar) {
        this.jif.cDO();
        if (fVar.iSg) {
            showNetRefreshView(this.jif.cnA(), TbadkCoreApplication.getInst().getString(R.string.net_error_text, new Object[]{fVar.errorMsg, Integer.valueOf(fVar.errorCode)}), true);
        } else {
            showNetRefreshView(this.jif.cEv().cLQ(), fVar.errorMsg, true);
        }
    }

    public void cCK() {
        hideLoadingView(this.jif.cnA());
        this.jif.bRO();
        if (this.jif.cDM() instanceof com.baidu.tieba.frs.tab.c) {
            ((com.baidu.tieba.frs.tab.c) this.jif.cDM()).cKv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCL() {
        if (cCI() == 0 && com.baidu.tbadk.core.util.y.isEmpty(this.jhD.getThreadListIds())) {
            if (com.baidu.tbadk.core.util.y.isEmpty(this.jhD.getThreadList())) {
                this.jif.bSE();
            } else {
                this.jif.Xb();
            }
        } else if (com.baidu.tbadk.core.util.y.getCount(this.jhD.getThreadList()) > 3) {
            this.jif.Xa();
        } else {
            this.jif.cEj();
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
            cCK();
            this.jif.cDU();
            com.baidu.tieba.tbadkCore.f cJJ = this.jix.cJJ();
            boolean isEmpty = com.baidu.tbadk.core.util.y.isEmpty(this.jhD.getThreadList());
            if (cJJ != null && isEmpty) {
                if (this.jix.cJL() != 0) {
                    this.jix.cJQ();
                    this.jif.cDU();
                } else {
                    a(cJJ);
                }
                this.jif.aa(this.jhD.isStarForum(), false);
                return;
            }
            a(cJJ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(com.baidu.tieba.tbadkCore.m mVar) {
        if (mVar != null && mVar.getEntelechyTabInfo() != null && mVar.getEntelechyTabInfo().tab != null) {
            for (FrsTabInfo frsTabInfo : mVar.getEntelechyTabInfo().tab) {
                if (frsTabInfo.tab_id.intValue() == 502 && com.baidu.tbadk.core.sharedPref.b.brR().getBoolean("first_into_tab_profession", true)) {
                    return false;
                }
            }
        }
        return new com.baidu.tieba.frs.ad.f(getTbPageContext()).d(mVar);
    }

    public boolean cCM() {
        return cCN() && !cCO();
    }

    private boolean cCN() {
        if (cDm() == null) {
            return false;
        }
        FrsViewData cDm = cDm();
        com.baidu.tbadk.core.data.aa aaVar = null;
        if (cDm.getStar() != null && !StringUtils.isNull(cDm.getStar().dMW())) {
            aaVar = new com.baidu.tbadk.core.data.aa();
        } else if (cDm.getActivityHeadData() != null && com.baidu.tbadk.core.util.y.getCount(cDm.getActivityHeadData().blT()) >= 1) {
            aaVar = cDm.getActivityHeadData().blT().get(0);
        }
        return aaVar != null;
    }

    public boolean cCO() {
        if (cDm() == null) {
            return false;
        }
        FrsViewData cDm = cDm();
        return (com.baidu.tbadk.core.util.y.isEmpty(cDm.getShowTopThreadList()) && cDm.getBusinessPromot() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCP() {
        boolean b;
        if (!cCR()) {
            final PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
            privateForumPopInfoData.a(this.jhD.getPrivateForumTotalInfo().getPrivatePopInfo());
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(getActivity());
            if (this.jhD.getPrivateForumTotalInfo().bmO().private_forum_status.intValue() == 1 && (com.baidu.tbadk.core.util.au.isEmpty(privateForumPopInfoData.bmQ()) || privateForumPopInfoData.bmT() != Integer.valueOf(this.forumId))) {
                privateForumPopInfoData.Ad("create_success");
                privateForumPopInfoData.Ae(TbadkCoreApplication.getInst().getString(R.string.frs_private_create_hint));
                privateForumPopInfoData.Af("https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.jhW + "&nomenu=1");
                privateForumPopInfoData.m(Integer.valueOf(this.forumId));
                b = frsPrivateCommonDialogView.b(privateForumPopInfoData);
            } else {
                b = privateForumPopInfoData.bmT() == Integer.valueOf(this.forumId) ? frsPrivateCommonDialogView.b(privateForumPopInfoData) : false;
            }
            if (b) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
                aVar.nB(2);
                aVar.bn(frsPrivateCommonDialogView);
                aVar.jG(false);
                frsPrivateCommonDialogView.setConfirmButton(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.21
                    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.frs.FrsFragment */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        bf.bsY().b(FrsFragment.this.getPageContext(), new String[]{privateForumPopInfoData.bmS()});
                        aVar.dismiss();
                    }
                });
                aVar.a(new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.22
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(getPageContext()).bqz();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCQ() {
        if (cCR() || this.jhD.getPrivateForumTotalInfo().bmO().private_forum_status.intValue() != 1) {
            a((Integer) null, (Integer) null, true);
        } else {
            a(this.jhD.getPrivateForumTotalInfo().bmO().private_forum_audit_status, this.jhD.getPrivateForumTotalInfo().bmP(), false);
        }
    }

    public void a(Integer num, Integer num2, boolean z) {
        final int i = 2;
        if (this.jif.cEa() != null) {
            TextView cEa = this.jif.cEa();
            if (z) {
                cEa.setVisibility(8);
                return;
            }
            final String str = "";
            if (num.intValue() == 2) {
                cEa.setText("修改实名认证信息");
                cEa.setVisibility(0);
                str = "https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + this.forumId + "&nomenu=1";
            } else if (num2.intValue() >= 0 && num2.intValue() <= 100) {
                cEa.setText("目标已完成" + String.valueOf(num2) + "%");
                cEa.setVisibility(0);
                i = 1;
                str = "https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.jhW + "&nomenu=1";
            } else {
                cEa.setVisibility(8);
                i = 0;
            }
            cEa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.24
                /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13387").dR("fid", FrsFragment.this.forumId).dR("uid", TbadkCoreApplication.getCurrentAccount()).aq("obj_type", i));
                    bf.bsY().b(FrsFragment.this.getPageContext(), new String[]{str});
                }
            });
        }
    }

    private boolean cCR() {
        return this.jhD == null || this.jhD.getPrivateForumTotalInfo() == null || this.jhD.getPrivateForumTotalInfo().bmO() == null || this.jhD.getUserData().getIs_manager() != 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yx(int i) {
        List<WindowToast> list;
        if (TbadkCoreApplication.isLogin() && this.jhD != null && (list = this.jhD.mWindowToast) != null && list.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < list.size()) {
                    WindowToast windowToast = list.get(i3);
                    if (windowToast == null || windowToast.toast_type.intValue() != i) {
                        i2 = i3 + 1;
                    } else if (!com.baidu.tbadk.core.util.au.isEmpty(windowToast.toast_link)) {
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), "", com.baidu.tbadk.util.al.addParamsForPageTranslucent(windowToast.toast_link), true)));
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
    public void cCS() {
        if (getActivity() != null && getActivity().getIntent() != null) {
            String stringExtra = getActivity().getIntent().getStringExtra(FrsActivityConfig.KEY_ACHIEVEMENT_URL);
            if (!TextUtils.isEmpty(stringExtra)) {
                getActivity().getIntent().removeExtra(FrsActivityConfig.KEY_ACHIEVEMENT_URL);
                AchievementActivityConfig achievementActivityConfig = new AchievementActivityConfig(getActivity());
                achievementActivityConfig.setUrl(stringExtra);
                if (this.jhD != null && this.jhD.getForumActiveInfo() != null) {
                    achievementActivityConfig.setShareUrl(this.jhD.getForumActiveInfo().forum_share_url);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, achievementActivityConfig));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCT() {
        if (this.jhD == null || this.jhD.getForum() != null) {
            this.jif.cEg();
        } else if (this.jhD.getForum().getYuleData() != null && this.jhD.getForum().getYuleData().bqp()) {
            TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_VIEW);
            this.jif.a(this.jhD.getForum().getYuleData().bqq());
        } else {
            this.jif.cEg();
        }
    }

    private void Y(boolean z, boolean z2) {
        if (this.jix != null && this.jhD != null && this.jif != null && z) {
            if (!this.jix.cJX() && this.jix.cJN() == 1) {
                if (!this.jix.cJV()) {
                    this.jhD.addCardVideoInfoToThreadList();
                    this.jhD.addVideoInfoToThreadListInTenAndFifteenFloor();
                }
                boolean z3 = false;
                if (this.jif.cEh().r(com.baidu.tieba.card.data.n.iDa)) {
                    z3 = this.jhD.addHotTopicDataToThreadList();
                }
                if (!z3) {
                    this.jhD.addFeedForumDataToThreadList();
                }
                if (TbadkCoreApplication.getInst().isRecAppExist() && !com.baidu.tieba.funad.a.cNC()) {
                    this.jhD.addRecommendAppToThreadList(this);
                }
                if (!this.jif.cEh().r(cb.eSm)) {
                    this.jhD.removeAlaLiveThreadData();
                }
                this.jhD.addSchoolRecommendToThreadList();
            }
            if (!this.jif.cEh().r(cb.eSm)) {
                this.jhD.removeAlaInsertLiveData();
                this.jhD.removeAlaStageLiveDat();
            } else {
                this.jhD.addInsertLiveDataToThreadList();
                this.jhD.addStageLiveDataToThreadList();
            }
            this.jhD.checkLiveStageInThreadList();
            this.jhD.addNoticeThreadToThreadList();
            if (this.jif.cEh().r(com.baidu.tieba.i.b.jWs)) {
                this.jhD.addGameRankListToThreadList(z2);
            }
            if (TbadkCoreApplication.isLogin() && (!this.jix.cJX() || this.jix.isNetFirstLoad)) {
                this.jhD.addUserRecommendToThreadList();
            }
            this.jhD.addVideoActivityToTop();
        }
    }

    public boolean cCU() {
        if (this.jiy != null && this.jix != null) {
            this.jiy.a(this.jix.getPageType(), this.jhD);
        }
        boolean z = false;
        if (this.jhD != null) {
            z = this.jhD.hasTab();
        }
        cCX();
        if (this.jif != null) {
            this.jif.cEt();
            this.jif.cEu();
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yy(int i) {
        ax axVar = null;
        cCU();
        cDh();
        try {
            if (this.jhD != null) {
                this.jif.a((ArrayList<com.baidu.adp.widget.ListView.n>) null, this.jhD);
                this.jiy.Az(1);
                this.jif.cDX();
                this.jiz.a(this.jhD, this.jix.cJS());
                com.baidu.tieba.frs.tab.d AI = this.jiz.AI(this.jhD.getFrsDefaultTabId());
                if (AI != null && !TextUtils.isEmpty(AI.url)) {
                    axVar = new ax();
                    axVar.ext = AI.url;
                    axVar.stType = AI.name;
                }
                this.jix.a(this.jhD.getFrsDefaultTabId(), 0, axVar);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(boolean z, boolean z2) {
        try {
            if (this.jhD != null && this.jiz != null && this.jix != null) {
                if (!this.jif.cEh().r(cb.eSm)) {
                    this.jhD.removeAlaLiveThreadData();
                }
                boolean isEmpty = com.baidu.tbadk.core.util.y.isEmpty(this.jhD.getGameTabInfo());
                this.jif.qD(isEmpty);
                if (!isEmpty) {
                    if (this.jiR == null) {
                        this.jiR = new com.baidu.tieba.frs.vc.e(this, (NoPressedRelativeLayout) this.mRootView);
                    }
                    if (this.gXE == null) {
                        this.gXE = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
                    }
                } else {
                    this.jiR = null;
                    this.gXE = null;
                }
                if (this.jhD.getForum() != null) {
                    this.jhW = this.jhD.getForum().getName();
                    this.forumId = this.jhD.getForum().getId();
                }
                if (this.jhD.hasTab()) {
                    this.jiz.a(this.jhD, this.jix.cJS());
                }
                if (z) {
                    Y(true, z);
                } else {
                    Y(this.jis, z);
                }
                cCU();
                if (this.jiF != null) {
                    this.jiF.a(this.jiy, this.jhD);
                }
                if (this.jhD.getPage() != null) {
                    setHasMore(this.jhD.getPage().bmH());
                }
                ArrayList<com.baidu.adp.widget.ListView.n> a2 = this.jiI.a(z2, true, this.jhD.getThreadList(), null, z, false);
                if (a2 != null) {
                    this.jhD.setThreadList(a2);
                }
                this.jhD.removeRedundantUserRecommendData();
                this.jhF = this.jhD.getTopThreadSize();
                if (this.jia != null) {
                    this.jhZ = true;
                    this.jia.JE(this.jhF);
                    com.baidu.tieba.frs.d.a.a(this, this.jhD.getForum(), this.jhD.getThreadList(), this.jhZ, getPn());
                }
                if (this.jix.cJN() == 1) {
                    cDb();
                    if (!z && this.jix.getPn() == 1) {
                        cCW();
                    }
                }
                if (this.jiG != null) {
                    this.jiG.db(this.jiz.cLZ());
                }
                cCK();
                this.jif.cDP();
                this.jif.aa(true, false);
                if (z && this.jhD.isFirstTabEqualAllThread()) {
                    com.baidu.adp.lib.f.e.mA().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.25
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!FrsFragment.this.jiq && com.baidu.adp.lib.util.j.isNetWorkAvailable() && !FrsFragment.this.jif.cEw()) {
                                FrsFragment.this.jif.cEr();
                            }
                        }
                    });
                }
                if (this.jhD.getForum() != null) {
                    this.jif.Kr(this.jhD.getForum().getWarningMsg());
                }
                if (this.jhD != null && this.jhD.getFrsVideoActivityData() != null && com.baidu.tbadk.core.sharedPref.b.brR().getLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 0L) == 0) {
                    com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.26
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsFragment.this.jif.cEp();
                        }
                    }, 1000L);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FRS_SHOW_AR_ENTRY, this));
                this.jif.cDJ();
                if (this.jhD != null && this.jhD.getForum() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ENTER_FORUM, new VisitedForumData(this.jhD.getForum().getId(), this.jhD.getForum().getName(), this.jhD.getForum().getImage_url(), String.valueOf(System.currentTimeMillis() / 1000), ConstantData.Forum.SPECAIL_FORUM_TYPE_LIVE.equals(this.jhD.getForum().special_forum_type), this.jhD.getForum().getThemeColorInfo(), this.jhD.getForum().getMember_num())));
                }
                this.jiV.a(this.jhD.bottomMenuList, this.jhD.getForum());
                cDw();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void cCV() {
        if (this.jix != null && this.jix.cJN() == 1) {
            this.jiy.k(this.jhD);
        }
    }

    public void qu(boolean z) {
        com.baidu.tieba.s.c.dMH().b(getUniqueId(), z);
    }

    public void cCW() {
        if (this.jiL == null) {
            this.jiL = new com.baidu.tieba.frs.live.a(this, com.baidu.adp.lib.f.b.toInt(this.forumId, 0));
        }
        this.jiL.cJu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.tbadkCore.m mVar) {
        try {
            if (!this.jiq && mVar != null && this.jhD != null) {
                this.jhD.receiveData(mVar);
                Z(true, false);
                Looper.myQueue().addIdleHandler(this.jjl);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void cCX() {
        if (this.jix != null) {
            Ko(this.jix.getPageType());
        } else {
            Ko("normal_page");
        }
    }

    private void Ko(String str) {
        qv("frs_page".equals(str));
        if (this.jiF != null) {
            this.jiF.a(this.jiy, this.jif, this.jhD);
        }
    }

    public void qv(boolean z) {
        if (this.jiJ != null) {
            this.jiJ.cLJ();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.s.c.dMH().B(getUniqueId());
        registerResponsedEventListener(TopToastEvent.class, this.mTopToastEventListener);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.frs_activity, viewGroup, false);
            this.jhQ = new com.baidu.tieba.frs.entelechy.a();
            this.jiF = this.jhQ.cGf();
            this.jhP = TbadkCoreApplication.getInst().getString(R.string.frs_title_new_area);
            this.jiy = new com.baidu.tieba.frs.vc.h(this, this.jhQ, (FrsHeaderViewContainer) this.mRootView.findViewById(R.id.header_view_container));
            this.jiz = new FrsTabViewController(this, this.mRootView);
            this.jiz.registerListener();
            this.jiy.a(this.jiz);
            this.jiz.a(this.jjt);
            Intent intent = getActivity().getIntent();
            if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                this.jhS = true;
            }
            this.jif = new q(this, this.jjP, this.jhQ, this.jhS, this.jiy);
            this.jiV = new com.baidu.tieba.frs.brand.buttommenu.a(getPageContext(), this.mRootView);
        } else {
            if (this.mRootView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            if (this.jiz != null) {
                this.jiz.registerListener();
            }
            this.jif.cEo();
            this.mRootView.setLeft(0);
            this.mRootView.setRight(com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getContext()));
        }
        this.jiZ = true;
        this.fKM = System.currentTimeMillis() - currentTimeMillis;
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        ArrayList<com.baidu.adp.widget.ListView.n> arrayList = null;
        this.iKN = System.currentTimeMillis();
        long j = this.iKN;
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.jib = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.iKN = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            S(intent);
        }
        this.fKL = j - this.iKN;
        this.jia = new com.baidu.tieba.tbadkCore.data.f("frs", com.baidu.tieba.tbadkCore.data.f.nyw);
        if (this.jix == null) {
            this.jix = new FrsModelController(this, this.jjK);
            this.jix.a(this.jjs);
            this.jix.init();
        }
        this.jix.setSchemeUrl(this.mSchemeUrl);
        if (intent != null) {
            this.jix.aj(intent.getExtras());
        } else if (bundle != null) {
            this.jix.aj(bundle);
        } else {
            this.jix.aj(null);
        }
        if (intent != null) {
            this.jiy.as(intent.getExtras());
        } else if (bundle != null) {
            this.jiy.as(bundle);
        } else {
            this.jiy.as(null);
        }
        this.jie = getVoiceManager();
        this.jiM = new p(getPageContext(), this);
        initUI();
        initData(bundle);
        if (!cDp()) {
            this.jiD = new at(getActivity(), this.jif, this.jiy);
            this.jiD.qS(true);
        }
        this.jie = getVoiceManager();
        if (this.jie != null) {
            this.jie.onCreate(getPageContext());
        }
        if (FrsActivityConfig.FRS_FROM_FLUTTER_BCASTEDIT.equals(getFrom()) && !this.hasInit) {
            int i = com.baidu.tbadk.core.sharedPref.b.brR().getInt("key_forum_broadcast_edit_tip_number", 0);
            if (i < 2) {
                com.baidu.tbadk.core.sharedPref.b.brR().putInt("key_forum_broadcast_edit_tip_number", i + 1);
                cDd();
            } else if (Build.VERSION.SDK_INT >= 23) {
                if (Settings.canDrawOverlays(getContext())) {
                    cDe();
                } else {
                    new BdTopToast(getContext()).zm(false).Vg(getContext().getString(R.string.forum_broadcast_copy_no_permission_hint)).aR(this.jif.cnA());
                }
            } else {
                cDe();
            }
        }
        if (FrsActivityConfig.FRS_FROM_FORUM_RULE_EDIT.equals(getFrom()) && !this.hasInit) {
            if (Build.VERSION.SDK_INT >= 23) {
                if (Settings.canDrawOverlays(getContext())) {
                    cDf();
                } else if (Build.VERSION.SDK_INT < 23 || !com.baidu.tbadk.core.sharedPref.b.brR().getBoolean("key_forum_rule_dialog_show_frs", false)) {
                    cDf();
                    com.baidu.tbadk.core.sharedPref.b.brR().putBoolean("key_forum_rule_dialog_show_frs", true);
                }
            } else {
                cDf();
            }
        }
        if (com.baidu.tbadk.k.d.bCE().bCF()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
            if (this.jig != null) {
                this.jig.setVisibility(8);
            }
        }
        new com.baidu.tieba.frs.mc.i();
        int i2 = -1;
        if (this.jiI != null && this.jiI.cJF() != null) {
            i2 = this.jiI.cJF().cCI();
            arrayList = this.jiI.cJF().getDataList();
        }
        this.jiI = new com.baidu.tieba.frs.mc.c(this, this.jjN);
        this.jiI.cJF().setHasMore(i2);
        if (arrayList != null && arrayList.size() > 0) {
            this.jiI.cJF().aC(arrayList);
        }
        this.jiB = new com.baidu.tieba.frs.smartsort.a(this);
        this.jiJ = new com.baidu.tieba.frs.vc.j(this);
        this.jiG = new com.baidu.tieba.frs.vc.a(getPageContext(), this.jix.cJU());
        this.jiC = new com.baidu.tieba.frs.mc.b(this);
        this.jiH = new com.baidu.tieba.frs.mc.d(this);
        this.jiA = new com.baidu.tieba.frs.mc.h(this);
        this.jiK = new com.baidu.tieba.frs.mc.a(this);
        this.jiN = new com.baidu.tieba.frs.vc.c(this);
        this.jiO = new com.baidu.tieba.frs.mc.e(this, getUniqueId());
        this.jiT = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "frs");
        this.jiU = new com.baidu.tieba.ala.b(getPageContext());
        this.jiW = new com.baidu.tieba.frs.sportspage.notification.a(getPageContext());
        registerListener(this.jjB);
        registerListener(this.mMemListener);
        registerListener(this.jjz);
        registerListener(this.jjO);
        registerListener(this.jjL);
        registerListener(this.jjv);
        registerListener(this.jjw);
        registerListener(this.jjx);
        registerListener(this.jjy);
        registerListener(this.jjm);
        registerListener(this.jjn);
        registerListener(this.aiE);
        registerListener(this.jjo);
        registerListener(this.jjT);
        registerListener(this.jjD);
        this.jjE.setSelfListener(true);
        this.jjE.setTag(getPageContext().getUniqueId());
        registerListener(this.jjE);
        registerListener(this.jjr);
        registerListener(this.jjF);
        registerListener(this.jjC);
        registerListener(this.jjH);
        registerListener(this.jjI);
        registerListener(this.jjJ);
        this.jjU.setTag(getPageContext().getUniqueId());
        MessageManager.getInstance().registerListener(this.jjU);
        registerListener(this.jjV);
        registerListener(this.jjW);
        registerListener(this.jjX);
        registerListener(this.jjq);
        registerListener(this.jjY);
        registerListener(this.jjG);
        registerListener(this.jjp);
        registerListener(this.jjZ);
        registerListener(this.jka);
        registerListener(this.jkb);
        registerListener(this.jkc);
        this.jif.qF(false);
        if (!cDp() && !this.hasInit) {
            showLoadingView(this.jif.cnA(), true);
            this.jix.T(3, false);
        }
        av avVar = new av() { // from class: com.baidu.tieba.frs.FrsFragment.29
            @Override // com.baidu.tieba.frs.av
            public void g(boolean z, boolean z2, int i3) {
                if (FrsFragment.this.jif != null) {
                    if (i3 == 1) {
                        FrsFragment.this.jif.yJ(z ? 0 : 8);
                    } else if (i3 == 2) {
                        FrsFragment.this.jif.yL(z ? 0 : 8);
                    }
                    if (!z2) {
                        FrsFragment.this.jiY = z;
                    }
                    if (FrsFragment.this.jif.cEh() != null && (i3 == 2 || (FrsFragment.this.jix != null && FrsFragment.this.jix.cJO()))) {
                        FrsFragment.this.jif.cEh().notifyDataSetChanged();
                    }
                    if (FrsFragment.this.cCF() != null) {
                        FrsTabViewController.b cMa = FrsFragment.this.cCF().cMa();
                        if (cMa != null) {
                            if ((cMa.fragment instanceof FrsCommonTabFragment) && (i3 == 2 || cMa.tabId == 502)) {
                                ((FrsCommonTabFragment) cMa.fragment).cFU();
                            } else if ((cMa.fragment instanceof FrsNewAreaFragment) && (i3 == 2 || cMa.tabId == 503)) {
                                FrsNewAreaFragment frsNewAreaFragment = (FrsNewAreaFragment) cMa.fragment;
                                frsNewAreaFragment.cFU();
                                if (frsNewAreaFragment.cKf() != null) {
                                    com.baidu.tieba.frs.mc.g cKf = frsNewAreaFragment.cKf();
                                    cKf.qU(!z);
                                    if (i3 == 1) {
                                        cKf.qI(!z);
                                    } else if (i3 == 2) {
                                        cKf.qI(true);
                                    }
                                }
                            } else if (cMa.fragment instanceof FrsGoodFragment) {
                                ((FrsGoodFragment) cMa.fragment).cFU();
                            }
                        }
                        if (FrsFragment.this.cCF().cLR() != null) {
                            FrsFragment.this.cCF().cLR().setmDisallowSlip(z);
                            FrsFragment.this.cCF().rE(z);
                        }
                    }
                    if (FrsFragment.this.jif.cDN() != null) {
                        FrsFragment.this.jif.qC(!z);
                    }
                    if (FrsFragment.this.getActivity() instanceof FrsActivity) {
                        ((FrsActivity) FrsFragment.this.getActivity()).qs(!z);
                    }
                    if (FrsFragment.this.jiV != null) {
                        FrsFragment.this.jiV.ra(!z);
                    }
                    FrsFragment.this.jif.qH(!z);
                    if (i3 == 1) {
                        FrsFragment.this.jif.qI(z ? false : true);
                    } else if (i3 == 2) {
                        FrsFragment.this.jif.qI(true);
                    }
                }
            }

            @Override // com.baidu.tieba.frs.av
            public void cm(int i3, int i4) {
                if (FrsFragment.this.jif != null) {
                    if (i4 == 1) {
                        FrsFragment.this.jif.yK(i3);
                    } else if (i4 == 2) {
                        FrsFragment.this.jif.yM(i3);
                    }
                }
            }

            @Override // com.baidu.tieba.frs.av
            public void yC(int i3) {
                if (FrsFragment.this.getContext() != null) {
                    if (i3 == 1) {
                        com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getContext(), R.string.frs_multi_delete_max_num);
                    } else if (i3 == 2 && FrsFragment.this.jif != null) {
                        new BdTopToast(FrsFragment.this.getContext()).zm(false).Vg(FrsFragment.this.getContext().getString(R.string.frs_move_area_max_num)).aR(FrsFragment.this.jif.cnA());
                    }
                }
            }
        };
        b.cBE().a(avVar);
        com.baidu.tieba.frs.a.cBx().a(avVar);
        this.jif.b(new e.a() { // from class: com.baidu.tieba.frs.FrsFragment.30
            @Override // com.baidu.tieba.NEGFeedBack.e.a
            public void a(DeleteThreadHttpResponseMessage deleteThreadHttpResponseMessage) {
                boolean z;
                int i3 = 0;
                if (deleteThreadHttpResponseMessage != null) {
                    FrsFragment.this.jif.bKu();
                    FrsFragment.this.jif.cEq();
                    FrsNewAreaFragment frsNewAreaFragment = null;
                    if (FrsFragment.this.jiz == null || FrsFragment.this.jiz.cMa() == null || !(FrsFragment.this.jiz.cMa().fragment instanceof FrsNewAreaFragment)) {
                        z = false;
                    } else {
                        frsNewAreaFragment = (FrsNewAreaFragment) FrsFragment.this.jiz.cMa().fragment;
                        z = true;
                    }
                    if (deleteThreadHttpResponseMessage.getError() == 0) {
                        String text = !TextUtils.isEmpty(deleteThreadHttpResponseMessage.getText()) ? deleteThreadHttpResponseMessage.getText() : FrsFragment.this.getString(R.string.delete_fail);
                        if (deleteThreadHttpResponseMessage.getRetType() == 1211066) {
                            if (FrsFragment.this.iBl == null) {
                                FrsFragment.this.iBl = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.iBl.AB(text);
                            FrsFragment.this.iBl.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.30.1
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.iBl.jG(false);
                            FrsFragment.this.iBl.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.iBl.bqz();
                        } else if (deleteThreadHttpResponseMessage.getRetType() == 1211067) {
                            if (FrsFragment.this.iBl == null) {
                                FrsFragment.this.iBl = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.iBl.AB(text);
                            FrsFragment.this.iBl.a(R.string.know, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.30.2
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.iBl.jG(false);
                            FrsFragment.this.iBl.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.iBl.bqz();
                        } else {
                            FrsFragment.this.jif.aY(deleteThreadHttpResponseMessage.getText(), ContextCompat.getColor(FrsFragment.this.getContext(), deleteThreadHttpResponseMessage.getRetType() == 1 ? R.color.nav_bar_tip_error : R.color.cp_link_tip_a_alpha95));
                        }
                        if (z && frsNewAreaFragment != null) {
                            frsNewAreaFragment.dB(deleteThreadHttpResponseMessage.getSuccessItems());
                        }
                        FrsFragment.this.dj(deleteThreadHttpResponseMessage.getSuccessItems());
                        b.cBE().di(deleteThreadHttpResponseMessage.getSuccessItems());
                        for (com.baidu.adp.widget.ListView.n nVar : FrsFragment.this.jhD.getThreadList()) {
                            if (nVar instanceof ca) {
                                i3++;
                                continue;
                            }
                            if (i3 >= 6) {
                                break;
                            }
                        }
                        if (i3 < 6) {
                            FrsFragment.this.bRp();
                            return;
                        }
                        return;
                    }
                    com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getActivity(), deleteThreadHttpResponseMessage.getErrorString());
                }
            }
        });
        this.dWJ = UtilHelper.getScreenHeight(getActivity());
        this.hasInit = true;
        yz(1);
        super.onActivityCreated(bundle);
        this.createTime = System.currentTimeMillis() - j;
    }

    public void qw(boolean z) {
        if (this.jiz != null) {
            this.jiz.jND = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dj(List<String> list) {
        if (!com.baidu.tbadk.core.util.y.isEmpty(list)) {
            ArrayList<com.baidu.adp.widget.ListView.n> threadList = this.jhD.getThreadList();
            if (!com.baidu.tbadk.core.util.y.isEmpty(threadList) && this.jif.getListView() != null && this.jif.getListView().getData() != null) {
                Iterator<com.baidu.adp.widget.ListView.n> it = threadList.iterator();
                List<com.baidu.adp.widget.ListView.n> data = this.jif.getListView().getData();
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.n next = it.next();
                    if (next instanceof ca) {
                        cb cbVar = ((ca) next).eLr;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= list.size()) {
                                break;
                            } else if (!com.baidu.tbadk.core.util.au.equals(list.get(i2), cbVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.jiI.d(next);
                                this.jif.getListView().getAdapter().notifyItemRemoved(i);
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
    public void cBC() {
        if (!com.baidu.tbadk.core.util.y.isEmpty(com.baidu.tieba.frs.a.cBx().cBB()) && this.jif.getListView() != null && this.jif.getListView().getData() != null) {
            ArrayList<com.baidu.adp.widget.ListView.n> threadList = this.jhD.getThreadList();
            if (!com.baidu.tbadk.core.util.y.isEmpty(threadList)) {
                Iterator<com.baidu.adp.widget.ListView.n> it = threadList.iterator();
                List<com.baidu.adp.widget.ListView.n> data = this.jif.getListView().getData();
                int count = com.baidu.tbadk.core.util.y.getCount(com.baidu.tieba.frs.a.cBx().cBB());
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.n next = it.next();
                    if (next instanceof ca) {
                        cb cbVar = ((ca) next).eLr;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= count) {
                                break;
                            } else if (!com.baidu.tbadk.core.util.au.equals(com.baidu.tieba.frs.a.cBx().cBB().get(i2).getId(), cbVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.jiI.d(next);
                                this.jif.getListView().getAdapter().notifyItemRemoved(i);
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
    public void bRJ() {
        if (isAdded() && this.gEY && !isLoadingViewAttached()) {
            showLoadingView(this.jif.cnA(), true);
        }
    }

    @Override // com.baidu.tieba.frs.am
    public void bRK() {
        if (isAdded() && this.gEY && isLoadingViewAttached()) {
            hideLoadingView(this.jif.cnA());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (cDp()) {
            showLoadingView(this.jif.cnA(), true);
            this.jif.yN(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.jix.S(3, true);
            getListView().scrollToPosition(0);
        }
    }

    private void yz(int i) {
        String str = "";
        if (this.jhD != null && this.jhD.getForum() != null) {
            str = this.jhD.getForum().getId();
        }
        if (!StringUtils.isNull(str)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13008").dR("fid", str).dR("obj_type", "4").aq("obj_locate", i).dR("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    @Override // com.baidu.tieba.frs.am
    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.aa aaVar) {
        if (aaVar != null) {
            this.fOK = aaVar.bFJ();
            this.jiP = aaVar.bFK();
        }
    }

    @Override // com.baidu.tieba.frs.am
    public void showFloatingView() {
        if (this.fOK != null) {
            this.fOK.lc(true);
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
                this.jhW = uri.getQueryParameter("name");
                this.mFrom = uri.getQueryParameter("from");
                if (!StringUtils.isNull(this.jhW)) {
                    intent.putExtra("name", this.jhW);
                }
                if (!StringUtils.isNull(this.mFrom)) {
                    intent.putExtra("from", this.mFrom);
                }
                TiebaStatic.log(TbadkCoreStatisticKey.AS_INVOKE_TIEBA);
            }
            if (StringUtils.isNull(this.jhW) && uri != null) {
                if (com.baidu.tbadk.BdToken.f.r(uri)) {
                    com.baidu.tbadk.BdToken.f.bhJ().b(uri, this.jjM);
                } else {
                    com.baidu.tieba.frs.d.g V = com.baidu.tieba.frs.d.l.V(intent);
                    if (V != null) {
                        this.jhW = V.forumName;
                        if (V.jLh == null || V.jLh.equals("aidou")) {
                        }
                    }
                }
                if (!StringUtils.isNull(this.jhW)) {
                    intent.putExtra("name", this.jhW);
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
                if (hashMap.get(com.baidu.tbadk.BdToken.f.eFm) instanceof String) {
                    FrsFragment.this.jhW = (String) hashMap.get(com.baidu.tbadk.BdToken.f.eFm);
                }
                if ((hashMap.get(com.baidu.tbadk.BdToken.f.eFE) instanceof String) && !TextUtils.isEmpty((String) hashMap.get(com.baidu.tbadk.BdToken.f.eFE))) {
                    com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.31.1
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsFragment.this.jiz.sV(301);
                            final long j = com.baidu.adp.lib.f.b.toLong((String) hashMap.get(com.baidu.tbadk.BdToken.f.eFn), 0L);
                            final int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
                            final int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
                            final float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                            final int i = 1;
                            if (com.baidu.tbadk.core.util.av.bsV().bsW()) {
                                i = 2;
                            }
                            com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.31.1.1
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
        this.jie = getVoiceManager();
        if (this.jie != null) {
            this.jie.onStart(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        Intent intent;
        long j = 0;
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.fuv);
        if (bundle != null) {
            this.jhW = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            j = bundle.getLong(FrsActivityConfig.FRS_FAKE_THREAD_ID, 0L);
        } else if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
            this.jhW = intent.getStringExtra("name");
            this.mFrom = intent.getStringExtra("from");
            this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
            j = intent.getLongExtra(FrsActivityConfig.FRS_FAKE_THREAD_ID, 0L);
        }
        if (getArguments() != null) {
            this.jhX = getArguments().getBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, false);
        }
        if (TextUtils.isEmpty(this.mFrom) || FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
        }
        if (this.mIsLogin) {
            registerListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL, this.fuv);
        }
        this.jiy.as(bundle);
        gq(j);
    }

    private void gq(final long j) {
        if (j > 0) {
            final int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
            final int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
            final float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            final int i = 1;
            if (com.baidu.tbadk.core.util.av.bsV().bsW()) {
                i = 2;
            }
            com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.36
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
        com.baidu.tieba.s.c.dMH().C(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.jjT);
        MessageManager.getInstance().unRegisterListener(this.jjE);
        unRegisterResponsedEventListener();
        this.jiJ.destroy();
        jij = null;
        if (this.jie != null) {
            this.jie.onDestory(getPageContext());
        }
        com.baidu.tieba.recapp.report.a.remove("FRS");
        this.jie = null;
        com.baidu.tieba.card.t.csH().pB(false);
        if (this.jhD != null && this.jhD.getForum() != null) {
            ag.cER().gr(com.baidu.adp.lib.f.b.toLong(this.jhD.getForum().getId(), 0L));
        }
        if (this.jiL != null) {
            this.jiL.onDestory();
        }
        if (this.jif != null) {
            com.baidu.tieba.frs.d.k.a(this.jif, this.jhD, getForumId(), false, null);
            this.jif.onDestroy();
        }
        if (this.jii != null) {
            this.jii.removeAllViews();
            this.jii.setVisibility(8);
        }
        if (this.jjf != null) {
            this.jjf.cancel();
        }
        if (this.jjg != null) {
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.jjg);
        }
        this.jje = null;
        super.onDestroy();
        try {
            if (this.jir != null) {
                this.jir.bEe();
            }
            if (this.jif != null) {
                this.jif.release();
            }
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.jiy.cJm();
        Looper.myQueue().removeIdleHandler(this.jjl);
        if (this.jix != null) {
            this.jix.bZa();
        }
        if (this.jiD != null) {
            this.jiD.cEZ();
        }
        if (this.jiG != null) {
            this.jiG.destory();
        }
        if (this.jiB != null) {
            this.jiB.onDestroy();
        }
        if (this.jiR != null) {
            this.jiR.onDestory();
        }
        if (this.jiK != null) {
            this.jiK.onDestroy();
        }
        if (this.jiT != null) {
            this.jiT.onDestroy();
        }
        if (this.jiU != null) {
            this.jiU.onDestroy();
        }
        com.baidu.tieba.recapp.c.a.dEu().dEx();
        com.baidu.tieba.frs.d.m.cKQ();
        if (this.jiz != null) {
            this.jiz.a((FrsTabViewController.a) null);
            this.jiz.cMc();
        }
        if (this.jiX != null) {
            this.jiX.onDestroy();
        }
        b.cBE().a(null);
        com.baidu.tieba.frs.a.cBx().a(null);
        if (this.jjk != null) {
            this.jjk.cKO();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.jhW);
        bundle.putString("from", this.mFrom);
        this.jix.onSaveInstanceState(bundle);
        if (this.jie != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            this.jie.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.jiK != null) {
            this.jiK.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.jif != null) {
            this.jif.cDU();
            this.jif.onResume();
        }
        this.jiA.rv(true);
        this.jis = true;
        if (jhV) {
            jhV = false;
            if (this.jif != null) {
                this.jif.startPullRefresh();
                return;
            }
            return;
        }
        if (this.jie != null) {
            this.jie.onResume(getPageContext());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_RESUME));
        if (this.jif != null) {
            this.jif.qJ(false);
        }
        if (this.jiS) {
            refresh(6);
            this.jiS = false;
        }
        if (this.jjb != null && getActivity() != null) {
            if (NotificationManagerCompat.from(getActivity()).areNotificationsEnabled()) {
                com.baidu.tbadk.coreExtra.messageCenter.f.byD().setSignAlertOn(true);
                com.baidu.tbadk.coreExtra.messageCenter.f.byD().setSignAlertTime(this.jjb.getHours(), this.jjb.getMinutes());
                if (this.jif != null) {
                    com.baidu.tbadk.coreExtra.messageCenter.f.byD().a(getTbPageContext().getPageActivity(), this.jif.cnA());
                }
            }
            this.jjb = null;
        }
        cDw();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
    }

    public boolean cCY() {
        Intent intent;
        if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
            return false;
        }
        return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
    }

    public void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.jhW = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.jhY = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.jhY) {
                cCZ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCZ() {
        this.jif.startPullRefresh();
    }

    public void closeActivity() {
        com.baidu.tieba.frs.d.l.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.mFrom);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.jif.setTitle(this.jhW);
        } else {
            this.jif.setTitle("");
            this.mFlag = 1;
        }
        this.jif.a(this.jjR);
        this.jif.addOnScrollListener(this.mScrollListener);
        this.jif.g(this.jfq);
        this.jif.cEh().a(this.jjQ);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jiZ) {
            this.jif.onChangeSkinType(i);
            this.jiy.Ay(i);
            this.jiz.onChangeSkinType(i);
            if (this.jih != null) {
                this.jih.onChangeSkinType(i);
            }
            if (this.jiQ != null) {
                this.jiQ.onChangeSkinType();
            }
            if (this.jiV != null) {
                this.jiV.onChangeSkinType(getPageContext(), i);
            }
            if (this.iBl != null) {
                com.baidu.tbadk.r.a.a(getPageContext(), this.iBl.getRealView());
            }
            if (this.jiR != null) {
                this.jiR.onChangeSkinType(getPageContext(), i);
            }
        }
    }

    public void yA(int i) {
        if (!this.mIsLogin) {
            if (this.jhD != null && this.jhD.getAnti() != null) {
                this.jhD.getAnti().setIfpost(1);
            }
            if (i == 0) {
                bh.skipToLoginActivity(getActivity());
            }
        } else if (this.jhD != null) {
            if (i == 0) {
                com.baidu.tieba.frs.d.m.g(this, 0);
            } else {
                this.jif.cDW();
            }
        }
    }

    public void refresh() {
        com.baidu.tieba.a.d.bKY().EC("page_frs");
        refresh(3);
    }

    public void refresh(int i) {
        this.jiq = false;
        cDh();
        if (this.jif != null && this.jif.cDL() != null) {
            this.jif.cDL().cQI();
        }
        if (this.jix != null) {
            this.jix.S(i, true);
        }
    }

    private void cDa() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.f.h.mB().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.37
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.TN(FrsFragment.this.jhW);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDb() {
        cDh();
        try {
            if (this.jhD != null) {
                this.jif.bYu();
                this.jif.qC(cDv());
                if (!com.baidu.tieba.frs.vc.h.n(this.jhD) || !com.baidu.tieba.frs.vc.h.m(this.jhD)) {
                }
                if (this.jhD.getForum() != null) {
                    this.jhW = this.jhD.getForum().getName();
                    this.forumId = this.jhD.getForum().getId();
                }
                if (this.jhD.getPage() != null) {
                    setHasMore(this.jhD.getPage().bmH());
                }
                this.jif.setTitle(this.jhW);
                this.jif.setForumName(this.jhW);
                TbadkCoreApplication.getInst().setDefaultBubble(this.jhD.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.jhD.getUserData().getBimg_end_time());
                cDa();
                cDc();
                ArrayList<com.baidu.adp.widget.ListView.n> threadList = this.jhD.getThreadList();
                if (threadList != null) {
                    this.jif.a(threadList, this.jhD);
                    com.baidu.tieba.frs.d.c.A(this.jif);
                    this.jiy.Az(getPageNum());
                    this.jiy.j(this.jhD);
                    this.jiz.a(this.jhD, this.jix.cJS());
                    this.jif.cDX();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void cDc() {
        if (this.jhD != null) {
            if (this.jhD.getIsNewUrl() == 1) {
                this.jif.cEh().setFromCDN(true);
            } else {
                this.jif.cEh().setFromCDN(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.jiA.rv(false);
        this.jis = false;
        this.jif.onPause();
        if (this.jie != null) {
            this.jie.onPause(getPageContext());
        }
        this.jif.qJ(true);
        if (this.jiG != null) {
            this.jiG.cKT();
        }
        com.baidu.tbadk.BdToken.c.bhp().bhA();
        if (this.jjk != null) {
            this.jjk.cKO();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.jiz != null && this.jiz.cMa() != null && (this.jiz.cMa().fragment instanceof BaseFragment)) {
            ((BaseFragment) this.jiz.cMa().fragment).setPrimary(z);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.t.csH().pB(false);
        qu(false);
        if (this.jhD != null && this.jhD.getForum() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            com.baidu.tbadk.distribute.a.bAX().b(getPageContext().getPageActivity(), "frs", this.jhD.getForum().getId(), 0L);
        }
        if (this.jie != null) {
            this.jie.onStop(getPageContext());
        }
        if (getListView() != null) {
            getListView().getRecycledViewPool().clear();
        }
        this.jiy.bua();
        com.baidu.tbadk.util.ab.bFM();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            if (this.jiy != null) {
                this.jiy.cb(isPrimary());
            }
            if (this.jif != null) {
                this.jif.cb(isPrimary());
                this.jif.qJ(!isPrimary());
            }
        }
    }

    private void cDd() {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.nB(2);
        aVar.jG(false);
        FrsBroadcastCopyGuideDialogView frsBroadcastCopyGuideDialogView = new FrsBroadcastCopyGuideDialogView(getPageContext().getPageActivity());
        frsBroadcastCopyGuideDialogView.setConfirmButtonListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.38
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aVar != null) {
                    aVar.dismiss();
                    FrsFragment.this.cDe();
                }
            }
        });
        aVar.bn(frsBroadcastCopyGuideDialogView);
        aVar.b(getPageContext()).bqz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDe() {
        com.baidu.tbadk.k.d.bCE().a(new com.baidu.tbadk.k.a(getContext()));
        com.baidu.tbadk.k.d.bCE().C(85, 0, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds144));
        if (com.baidu.tbadk.k.d.bCE().init()) {
            ((BaseFragmentActivity) getPageContext().getOrignalPage()).grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.frs.FrsFragment.39
                @Override // com.baidu.tbadk.core.e
                public void onPermissionResult(boolean z) {
                    if (!z) {
                        new BdTopToast(FrsFragment.this.getContext()).zm(false).Vg(FrsFragment.this.getContext().getString(R.string.forum_broadcast_copy_no_permission_hint)).aR(FrsFragment.this.jif.cnA());
                        return;
                    }
                    com.baidu.tbadk.k.d.bCE().lc(true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                    if (FrsFragment.this.jig != null) {
                        FrsFragment.this.jig.setVisibility(8);
                    }
                }
            }, true);
        }
    }

    private void cDf() {
        com.baidu.tbadk.k.d.bCE().a(new com.baidu.tbadk.k.b(getContext()));
        com.baidu.tbadk.k.d.bCE().C(85, 0, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds144));
        if (com.baidu.tbadk.k.d.bCE().init()) {
            ((BaseFragmentActivity) getPageContext().getOrignalPage()).grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.frs.FrsFragment.40
                @Override // com.baidu.tbadk.core.e
                public void onPermissionResult(boolean z) {
                    if (z) {
                        com.baidu.tbadk.k.d.bCE().lc(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                        if (FrsFragment.this.jig != null) {
                            FrsFragment.this.jig.setVisibility(8);
                        }
                    }
                }
            }, true);
        }
    }

    public void Kp(String str) {
        new BdTopToast(getContext(), 3000).zm(true).Vg(str).aR(this.jif.cnA());
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (b.cBE().cBy()) {
                b.cBE().reset();
                return true;
            } else if (com.baidu.tieba.frs.a.cBx().cBy()) {
                if (this.jif != null && this.jif.cEl()) {
                    this.jif.cEm();
                    return true;
                }
                com.baidu.tieba.frs.a.cBx().reset();
                return true;
            } else if (this.jif != null) {
                return this.jif.cDT();
            }
        } else if (i == 24) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921381, keyEvent));
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.q
    public TbPageContext<?> getTbPageContext() {
        return getPageContext();
    }

    @Override // com.baidu.tieba.recapp.q
    public void a(AdvertAppInfo advertAppInfo, String str) {
        com.baidu.tbadk.distribute.a.bAX().a(advertAppInfo, this.forumId, 0L, "FRS", str, getPn());
    }

    @Override // com.baidu.tieba.recapp.q
    public void cDg() {
        cCC().cDg();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.jie == null) {
            this.jie = VoiceManager.instance();
        }
        return this.jie;
    }

    public BdRecyclerView getListView() {
        if (this.jif == null) {
            return null;
        }
        return this.jif.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void cDh() {
        if (this.jie != null) {
            this.jie.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.a
    public com.baidu.adp.lib.d.b<TbImageView> buP() {
        if (this.fnn == null) {
            this.fnn = UserIconBox.E(getPageContext().getPageActivity(), 8);
        }
        return this.fnn;
    }

    public void cDi() {
        if (getFragmentActivity() != null && getFragmentActivity().getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.q onGetPreLoadListView() {
        return getListView().getPreLoadHandle();
    }

    @Override // com.baidu.tieba.frs.ap
    public NavigationBar bVq() {
        if (this.jif == null) {
            return null;
        }
        return this.jif.bVq();
    }

    public FRSRefreshButton cDj() {
        return this.jih;
    }

    public void c(LinearLayout linearLayout) {
        if (linearLayout != null) {
            this.jii = linearLayout;
        }
    }

    public void a(FRSRefreshButton fRSRefreshButton) {
        if (fRSRefreshButton != null) {
            this.jih = fRSRefreshButton;
            this.jih.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.47
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (FrsFragment.this.jiz != null) {
                        FrsTabViewController.b cMa = FrsFragment.this.jiz.cMa();
                        if (cMa != null && cMa.fragment != null && (cMa.fragment instanceof ao)) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                            ((ao) cMa.fragment).cCm();
                            ((ao) cMa.fragment).bSD();
                            return;
                        }
                        FrsFragment.this.cCH().startPullRefresh();
                    }
                }
            });
        }
    }

    public void cDk() {
        if (this.jih != null) {
            this.jih.hide();
        }
    }

    public void cDl() {
        if (this.jih != null) {
            this.jih.show();
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
                if (bdUniqueId == u.jlT) {
                    if (FrsFragment.this.jif != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11752").dR("fid", FrsFragment.this.forumId).dR("obj_locate", "1"));
                        FrsFragment.this.jif.startPullRefresh();
                    }
                } else if (nVar != null && (nVar instanceof ca)) {
                    cb cbVar = ((ca) nVar).eLr;
                    if (cbVar.boT() == null || cbVar.boT().getGroup_id() == 0 || bh.checkUpIsLogin(FrsFragment.this.getActivity())) {
                        if (cbVar.boE() != 1 || bh.checkUpIsLogin(FrsFragment.this.getActivity())) {
                            if (cbVar.boe() != null) {
                                if (bh.checkUpIsLogin(FrsFragment.this.getActivity())) {
                                    String postUrl = cbVar.boe().getPostUrl();
                                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.isNetOk()) {
                                        com.baidu.tbadk.browser.a.startInternalWebActivity(FrsFragment.this.getActivity(), postUrl);
                                    }
                                }
                            } else if (cbVar.bpe() != null) {
                                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                    bh.skipToLoginActivity(FrsFragment.this.getPageContext().getPageActivity());
                                    return;
                                }
                                com.baidu.tbadk.core.data.t bpe = cbVar.bpe();
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), bpe.getCartoonId(), bpe.getChapterId(), 2)));
                            } else {
                                com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                                if (readThreadHistory != null && !readThreadHistory.TT(cbVar.getId())) {
                                    readThreadHistory.TS(cbVar.getId());
                                }
                                boolean z = false;
                                final String bnY = cbVar.bnY();
                                if (bnY != null && !bnY.equals("")) {
                                    z = true;
                                    new Thread(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.a.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            com.baidu.tbadk.core.util.aa aaVar = new com.baidu.tbadk.core.util.aa(bnY);
                                            aaVar.bsu().btd().mIsNeedAddCommenParam = false;
                                            aaVar.bsu().btd().mIsUseCurrentBDUSS = false;
                                            aaVar.getNetData();
                                        }
                                    }).start();
                                }
                                String tid = cbVar.getTid();
                                if (tid == null) {
                                    tid = "";
                                }
                                if (cbVar.bnN() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                    bf.bsY().b(FrsFragment.this.getPageContext(), new String[]{tid, "", null});
                                    return;
                                }
                                if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && tid.length() > 4) {
                                    cbVar.setId(tid.substring(3));
                                }
                                if (bdUniqueId.getId() == cb.eTQ.getId()) {
                                    com.baidu.tieba.frs.d.k.a(cbVar.bny());
                                } else if (bdUniqueId.getId() == cb.eSq.getId()) {
                                    com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                                    arVar.dR("obj_type", "2");
                                    arVar.dR("tid", cbVar.getTid());
                                    TiebaStatic.log(arVar);
                                }
                                com.baidu.tieba.frs.d.l.a(FrsFragment.this, cbVar, i, z);
                                com.baidu.tieba.frs.d.k.a(FrsFragment.this, FrsFragment.this.jhD, cbVar);
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
            hideNetRefreshView(this.jif.cEv().cLQ());
            showLoadingView(this.jif.cnA(), true);
            this.jif.qF(false);
            this.jix.S(3, true);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData cDm() {
        return this.jhD;
    }

    public boolean cDn() {
        return this.jif.cDn();
    }

    public void aM(Object obj) {
        if (this.jiC != null && this.jiC.jGB != null) {
            this.jiC.jGB.callback(obj);
        }
    }

    public void aN(Object obj) {
        if (this.jiC != null && this.jiC.jGC != null) {
            this.jiC.jGC.callback(obj);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        this.jif.getListView().stopScroll();
        if (!this.jif.cEd()) {
            if (!com.baidu.adp.lib.util.l.isNetOk()) {
                this.jif.bSE();
            } else if (this.jix.cJN() == 1) {
                bRE();
                bRp();
            } else if (this.jix.hasMore()) {
                bRp();
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void onFailed(String str) {
        bRE();
        showToast(str);
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void at(ArrayList<com.baidu.adp.widget.ListView.n> arrayList) {
        boolean isEmpty = com.baidu.tbadk.core.util.y.isEmpty(arrayList);
        setHasMore(isEmpty ? 0 : 1);
        bRE();
        if (!isEmpty) {
            if (!this.jix.cJX() && TbadkCoreApplication.getInst().isRecAppExist() && this.jix.cJN() == 1 && !com.baidu.tieba.funad.a.cNC()) {
                this.jhD.addRecommendAppToThreadList(this, arrayList);
            }
            if (this.jix != null) {
                com.baidu.tieba.frs.b.a.a(getUniqueId(), arrayList, this.jhD.getForum(), this.jix.getSortType());
            }
            ArrayList<com.baidu.adp.widget.ListView.n> a2 = this.jiI.a(false, false, arrayList, this.jia, false);
            if (a2 != null) {
                this.jhD.setThreadList(a2);
                this.jif.a(a2, this.jhD);
            }
            if (this.jix != null) {
                com.baidu.tieba.frs.b.c.a(this.jhD, this.jix.cJS(), 2, getContext());
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.jhD.getForum()));
        }
    }

    private void bRE() {
        if (cCI() == 1 || this.jiI.dA(this.jhD.getThreadListIds())) {
            if (com.baidu.tbadk.core.util.y.getCount(this.jhD.getThreadList()) > 3) {
                this.jif.Xa();
            } else {
                this.jif.cEj();
            }
        } else if (com.baidu.tbadk.core.util.y.isEmpty(this.jhD.getThreadList())) {
            this.jif.bSE();
        } else {
            this.jif.Xb();
        }
    }

    @Override // com.baidu.tieba.frs.mc.l
    public void bRp() {
        if (this.jiI != null) {
            this.jiI.a(this.jhW, this.forumId, this.jhD);
        }
    }

    public void cDo() {
        if (!com.baidu.tbadk.core.util.ae.requestWriteExternalStorgeAndCameraPermission(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.ao.g(getPageContext());
        }
    }

    @Override // androidx.fragment.app.Fragment, com.baidu.l.a.a.InterfaceC0154a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        com.baidu.tieba.frs.d.l.a(this, i, strArr, iArr);
    }

    public void qx(boolean z) {
        if (this.jiD != null) {
            this.jiD.qS(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.jiE.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a sO(int i) {
        return this.jiE.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        this.jiM.b(bVar);
    }

    public boolean cDp() {
        return this.jhS;
    }

    @Override // com.baidu.tieba.frs.am
    public void Uw() {
        if (this.jif != null) {
            showFloatingView();
            this.jif.getListView().scrollToPosition(0);
            this.jif.startPullRefresh();
        }
    }

    public ForumWriteData cDq() {
        if (this.jhD == null || this.jhD.getForum() == null) {
            return null;
        }
        ForumData forum = this.jhD.getForum();
        ForumWriteData forumWriteData = new ForumWriteData(forum.getId(), forum.getName(), forum.getPrefixData(), this.jhD.getAnti());
        forumWriteData.avatar = forum.getImage_url();
        forumWriteData.forumLevel = forum.getUser_level();
        forumWriteData.specialForumType = forum.special_forum_type;
        forumWriteData.firstDir = forum.getFirst_class();
        forumWriteData.secondDir = forum.getSecond_class();
        UserData userData = this.jhD.getUserData();
        forumWriteData.privateThread = userData != null ? userData.getPrivateThread() : 0;
        forumWriteData.frsTabInfo = cDr();
        return forumWriteData;
    }

    private FrsTabInfoData cDr() {
        int i;
        if (this.jix == null || this.jhD == null || this.jiz == null) {
            return null;
        }
        if (this.jhD.getEntelechyTabInfo() == null || com.baidu.tbadk.core.util.y.isEmpty(this.jhD.getEntelechyTabInfo().tab)) {
            return null;
        }
        int cMe = this.jiz.cMe();
        if (cMe == 502) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = -1;
        for (FrsTabInfo frsTabInfo : this.jhD.getEntelechyTabInfo().tab) {
            if (frsTabInfo != null && frsTabInfo.is_general_tab.intValue() == 1) {
                if (frsTabInfo.tab_id.intValue() != 505 || this.jhD.getUserData() == null || this.jhD.getUserData().isForumBusinessAccount()) {
                    arrayList.add(new FrsTabItemData(frsTabInfo));
                    if (cMe == frsTabInfo.tab_id.intValue()) {
                        i = cMe;
                        i2 = i;
                    }
                }
            }
            i = i2;
            i2 = i;
        }
        if (com.baidu.tbadk.core.util.y.isEmpty(arrayList)) {
            return null;
        }
        FrsTabInfoData frsTabInfoData = new FrsTabInfoData();
        frsTabInfoData.tabList = arrayList;
        frsTabInfoData.selectedTabId = i2;
        if (this.jhD.getUserData() != null) {
            frsTabInfoData.isForumBusinessAccount = this.jhD.getUserData().isForumBusinessAccount();
            return frsTabInfoData;
        }
        return frsTabInfoData;
    }

    @Override // com.baidu.tieba.frs.am
    public void bus() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void qy(boolean z) {
        this.jit = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z) {
        this.jif.yI(8);
        ((FrsActivity) getActivity()).showLoadingView(view, z);
        ((FrsActivity) getActivity()).j(view, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        this.jif.yI(0);
        ((FrsActivity) getActivity()).hideLoadingView(view);
        ((FrsActivity) getActivity()).j(view, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        super.showNetRefreshView(view, getResources().getString(R.string.refresh_view_title_text), null, getResources().getString(R.string.refresh_view_button_text), z, getNetRefreshListener());
        this.jif.yI(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshViewNoClick(View view, String str, boolean z) {
        super.showNetRefreshViewNoClick(view, str, z);
        this.jif.yI(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        super.hideNetRefreshView(view);
        this.jif.yI(0);
    }

    public void cDs() {
        FrsTabViewController.b cMa;
        if (this.jiz != null && (cMa = this.jiz.cMa()) != null && cMa.fragment != null && (cMa.fragment instanceof ao)) {
            ((ao) cMa.fragment).cCm();
        }
    }

    public void qz(boolean z) {
        this.jhU = z;
    }

    public void b(OvalActionButton ovalActionButton) {
        this.jig = ovalActionButton;
    }

    public OvalActionButton cDt() {
        return this.jig;
    }

    public boolean cDu() {
        return this.jhU;
    }

    public void Kq(String str) {
        if (TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.util.au.isEmpty(str)) {
            if (this.jiX == null) {
                this.jiX = new AddExperiencedModel(getTbPageContext());
            }
            this.jiX.gr(this.forumId, str);
        }
    }

    public boolean cDv() {
        if (this.jit && !this.jja) {
            return (this.jix != null && this.jix.cJO() && (b.cBE().cBy() || com.baidu.tieba.frs.a.cBx().cBy())) ? false : true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.g.b
    public boolean videoNeedPreload() {
        if (this.jhD != null) {
            return com.baidu.tbadk.util.ak.rI(2) || (com.baidu.tbadk.util.ak.bFV() && this.jhD.isFrsVideoAutoPlay);
        }
        return super.videoNeedPreload();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDw() {
        if (!com.baidu.tbadk.core.util.au.isEmpty(this.forumId)) {
            com.baidu.tbadk.BdToken.c.bhp().r(com.baidu.tbadk.BdToken.b.eDH, com.baidu.adp.lib.f.b.toLong(this.forumId, 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDx() {
        String format;
        String str;
        if (isResumed() && this.jje != null && this.jje.size() >= 1 && this.jjd <= this.jje.size() - 1) {
            final LiveHorseRaceData liveHorseRaceData = this.jje.get(this.jjd);
            if (System.currentTimeMillis() / 1000 >= liveHorseRaceData.getRob_end_tm().longValue()) {
                this.jjd++;
                cDx();
            }
            if (this.jii != null) {
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
                        if (FrsFragment.this.jhD == null) {
                            str2 = "";
                        } else if (FrsFragment.this.jhD.getForum() != null) {
                            str2 = FrsFragment.this.jhD.getForum().getName();
                        } else {
                            str2 = "";
                        }
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13744").aq("obj_source", 1).dR("fid", FrsFragment.this.forumId).dR("fname", str2));
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
                this.jjf = ValueAnimator.ofFloat(1.0f, 0.0f);
                this.jjf.setDuration(600L);
                this.jjf.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.FrsFragment.54
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        if (valueAnimator.isRunning()) {
                            frsRedpackRunView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                            frsRedpackRunView.setTranslationX(-(TbadkApplication.getInst().getContext().getResources().getDimensionPixelOffset(R.dimen.tbds850) * valueAnimator.getAnimatedFraction()));
                        }
                    }
                });
                this.jjf.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.FrsFragment.55
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        frsRedpackRunView.setAlpha(0.0f);
                        frsRedpackRunView.setTranslationY(TbadkApplication.getInst().getContext().getResources().getDimensionPixelOffset(R.dimen.tbds660));
                        frsRedpackRunView.hide();
                        FrsFragment.this.jii.removeView(frsRedpackRunView);
                        if (FrsFragment.this.jje == null || FrsFragment.this.jjd <= FrsFragment.this.jje.size() - 1) {
                            FrsFragment.this.cDx();
                            return;
                        }
                        FrsFragment.this.jii.removeAllViews();
                        FrsFragment.this.jii.setVisibility(8);
                        FrsFragment.this.jjd = 0;
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        onAnimationEnd(animator);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                this.jjg = new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.57
                    @Override // java.lang.Runnable
                    public void run() {
                        if (FrsFragment.this.jii != null && frsRedpackRunView != null) {
                            FrsFragment.this.jjf.start();
                        }
                    }
                };
                com.baidu.adp.lib.f.e.mA().postDelayed(this.jjg, 5000L);
                if (this.jii.getChildCount() == 0) {
                    this.jjd++;
                    this.jii.addView(frsRedpackRunView);
                    if (this.jhD != null) {
                        str = this.jhD.getForum() != null ? this.jhD.getForum().getName() : "";
                    } else {
                        str = "";
                    }
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13743").aq("obj_source", 1).dR("fid", this.forumId).dR("fname", str));
                }
                if (this.jii != null && this.jii.getVisibility() == 8 && ((BaseFragment) this.jiz.cMa().fragment).isPrimary() && !this.jif.cEs() && !this.jio) {
                    this.jii.setVisibility(0);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        FrsTabViewController.b cMa;
        if (cCF() == null || (cMa = cCF().cMa()) == null || !(cMa.fragment instanceof BaseFragment)) {
            return null;
        }
        if (cMa.fragment instanceof FrsAllThreadFragment) {
            TbPageTag tbPageTag = super.getTbPageTag();
            int i = -1;
            if (this.jhD != null) {
                i = this.jhD.getSortType();
            }
            tbPageTag.sortType = com.baidu.tieba.frs.d.j.Aw(i);
            tbPageTag.locatePage = "a070";
            if (this.jhP.equals(cMa.title)) {
                tbPageTag.locatePage = "a071";
            }
            return tbPageTag;
        } else if (cMa.fragment instanceof FrsFragment) {
            return null;
        } else {
            return ((BaseFragment) cMa.fragment).getTbPageTag();
        }
    }

    public void cDy() {
        if (this.jhD != null) {
            com.baidu.tieba.frs.b.b bVar = new com.baidu.tieba.frs.b.b();
            if (this.jhD.needLog == 1) {
                bVar.jJh = true;
            } else {
                bVar.jJh = false;
            }
            if (this.jhD.getForum() != null) {
                bVar.jJj = this.jhD.getForum().getId();
            }
            if (cCC() != null) {
                bVar.jJi = cCC().cJS();
            }
            if (com.baidu.tieba.frs.b.d.jsn != null) {
                bVar.jJk = com.baidu.tieba.frs.b.d.jsn.jJk;
                bVar.jJl = com.baidu.tieba.frs.b.d.jsn.jJl;
            }
            this.jjh = new com.baidu.tieba.frs.live.b(bVar, getTbPageTag(), getUniqueId());
            this.jjh.zY(this.jjj);
            CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_CARD_CLICK, this.jjh);
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
            CustomMessageTask customMessageTask2 = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW, this.jjh);
            customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask2);
            CustomMessageTask customMessageTask3 = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_USER_CLICK, this.jjh);
            customMessageTask3.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask3);
            CustomMessageTask customMessageTask4 = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_VIDEO_CLICK, this.jjh);
            customMessageTask4.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask4);
        }
    }

    public void aI(String str, String str2, String str3) {
        this.jjk = new com.baidu.tieba.frs.d.e(str, str2);
        this.jjk.c(getFragmentActivity(), str3, str2);
    }

    public void qA(boolean z) {
        if (this.funAdController == null) {
            this.funAdController = com.baidu.tieba.funad.a.rM(z);
            if (this.jiI != null) {
                this.jiI.setFunAdController(this.funAdController);
            }
        }
    }
}
