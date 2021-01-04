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
import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.n.a.a;
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
public class FrsFragment extends BaseFragment implements BdListView.e, a.InterfaceC0277a, UserIconBox.a<BdRecyclerView>, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, am, ap, as, com.baidu.tieba.frs.loadmore.a, com.baidu.tieba.frs.mc.l, com.baidu.tieba.recapp.p {
    public static com.baidu.tieba.tbadkCore.m jfm;
    private com.baidu.tbadk.util.x fPF;
    private com.baidu.adp.lib.d.b<TbImageView> fof;
    private com.baidu.tieba.funad.a funAdController;
    private com.baidu.tieba.frs.gametab.b gXD;
    private com.baidu.tbadk.core.dialog.a iyl;
    private com.baidu.tieba.frs.entelechy.a jeU;
    private FrsModelController jfA;
    private com.baidu.tieba.frs.vc.h jfB;
    private FrsTabViewController jfC;
    private com.baidu.tieba.frs.mc.h jfD;
    private com.baidu.tieba.frs.smartsort.a jfE;
    private com.baidu.tieba.frs.mc.b jfF;
    private at jfG;
    private com.baidu.tieba.frs.entelechy.a.b jfI;
    private com.baidu.tieba.frs.vc.a jfJ;
    private com.baidu.tieba.frs.mc.d jfK;
    private com.baidu.tieba.frs.mc.c jfL;
    private com.baidu.tieba.frs.vc.j jfM;
    private com.baidu.tieba.frs.mc.a jfN;
    private com.baidu.tieba.frs.live.a jfO;
    private p jfP;
    public com.baidu.tieba.frs.vc.c jfQ;
    private com.baidu.tieba.frs.mc.e jfR;
    private View.OnTouchListener jfS;
    private com.baidu.tieba.frs.view.a jfT;
    private com.baidu.tieba.frs.vc.e jfU;
    private boolean jfV;
    private com.baidu.tieba.NEGFeedBack.a jfW;
    private com.baidu.tieba.ala.b jfX;
    private com.baidu.tieba.frs.brand.buttommenu.a jfY;
    private com.baidu.tieba.frs.sportspage.notification.a jfZ;
    private com.baidu.tieba.tbadkCore.data.f jfe;
    private VoiceManager jfh;
    private OvalActionButton jfj;
    private FRSRefreshButton jfk;
    private LinearLayout jfl;
    public long jfn;
    private String jfx;
    private ThreadCardViewHolder jfz;
    private AddExperiencedModel jga;
    private boolean jgc;
    private List<LiveHorseRaceData> jgh;
    private ValueAnimator jgi;
    private Runnable jgj;
    private com.baidu.tieba.frs.live.b jgk;
    private com.baidu.tieba.frs.broadcast.a jgl;
    private int jgm;
    private com.baidu.tieba.frs.d.e jgn;
    private int jgx;
    private View mRootView;
    private String mSchemeUrl;
    public static boolean jeZ = false;
    public static volatile long jfp = 0;
    public static volatile long jfq = 0;
    public static volatile int mNetError = 0;
    private String jeT = "";
    public boolean jeV = false;
    private boolean jeW = false;
    private boolean jeX = false;
    private boolean jeY = true;
    public String jfa = null;
    public String mFrom = null;
    public int mFlag = 0;
    public boolean jfb = false;
    private boolean jfc = false;
    private String mThreadId = null;
    public String forumId = null;
    private int jeJ = 0;
    private boolean jfd = false;
    private boolean jff = false;
    private boolean jfg = false;
    private q jfi = null;
    public final bz alW = null;
    private FrsViewData jeH = new FrsViewData();
    public long iHN = -1;
    public long fLQ = 0;
    public long fLH = 0;
    public long createTime = 0;
    public long fLI = 0;
    public long fLN = 0;
    public long jfo = 0;
    boolean jfr = false;
    public boolean jfs = false;
    private boolean jft = false;
    public com.baidu.tbadk.n.b jfu = null;
    private boolean jfv = true;
    private boolean jfw = true;
    private a.C0090a jfy = new a.C0090a(2);
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> jfH = new SparseArray<>();
    private boolean gEY = true;
    private boolean hasInit = false;
    private boolean jgb = false;
    private boolean jgd = false;
    private Date jge = null;
    private int dXO = 0;
    private int jgf = 0;
    private int jgg = 0;
    public int mHeadLineDefaultNavTabId = -1;
    MessageQueue.IdleHandler jgo = new MessageQueue.IdleHandler() { // from class: com.baidu.tieba.frs.FrsFragment.1
        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            FrsFragment.this.cFn();
            return false;
        }
    };
    private final CustomMessageListener jgp = new CustomMessageListener(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED) { // from class: com.baidu.tieba.frs.FrsFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof bz) {
                    com.baidu.tieba.frs.d.k.a(FrsFragment.this.jfi, FrsFragment.this.jeH, FrsFragment.this.getForumId(), true, (bz) data);
                }
            }
        }
    };
    private CustomMessageListener jgq = new CustomMessageListener(CmdConfigCustom.CMD_CLOSE_GAME_RANK_CARD) { // from class: com.baidu.tieba.frs.FrsFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.jeH != null) {
                FrsFragment.this.jeH.removeGameRankListFromThreadList();
                if (FrsFragment.this.jfi != null) {
                    FrsFragment.this.jfi.bfi();
                }
            }
        }
    };
    private CustomMessageListener aip = new CustomMessageListener(2921401) { // from class: com.baidu.tieba.frs.FrsFragment.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && FrsFragment.this.jfk != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() <= 0 || FrsFragment.this.jfC.cOt() == 0 || FrsFragment.this.jfC.cOq() == null || !(FrsFragment.this.jfC.cOq().fragment instanceof BaseFragment) || !((BaseFragment) FrsFragment.this.jfC.cOq().fragment).isPrimary() || FrsFragment.this.jfi.cGK() || com.baidu.tbadk.k.d.bGb().bGc()) {
                    if (FrsFragment.this.jfC.cOt() != 0) {
                        FrsFragment.this.jfk.hide();
                        return;
                    }
                    return;
                }
                FrsFragment.this.jfk.show();
            }
        }
    };
    private CustomMessageListener jgr = new CustomMessageListener(2921473) { // from class: com.baidu.tieba.frs.FrsFragment.45
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && FrsFragment.this.jfk != null && FrsFragment.this.jfj != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() == 0) {
                    FrsFragment.this.jfk.setVisibility(8);
                    FrsFragment.this.jfj.setVisibility(8);
                    return;
                }
                FrsFragment.this.jfj.setVisibility(0);
            }
        }
    };
    private CustomMessageListener jgs = new CustomMessageListener(2921467) { // from class: com.baidu.tieba.frs.FrsFragment.56
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && FrsFragment.this.jfk != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() <= 0 || FrsFragment.this.jfC.cOq() == null || !(FrsFragment.this.jfC.cOq().fragment instanceof BaseFragment) || !((BaseFragment) FrsFragment.this.jfC.cOq().fragment).isPrimary() || FrsFragment.this.jfi.cGK()) {
                    FrsFragment.this.jfl.setVisibility(8);
                    FrsFragment.this.jfr = true;
                    return;
                }
                FrsFragment.this.jfl.setVisibility(0);
                FrsFragment.this.jfr = false;
            }
        }
    };
    private com.baidu.adp.framework.listener.a jgt = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_FRS_LIVE_HORSE_RACE_LIST, 309667) { // from class: com.baidu.tieba.frs.FrsFragment.64
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if ((responsedMessage instanceof GetLiveHorseRaceHttpResponseMessage) || (responsedMessage instanceof GetLiveHorseRaceSocketResponseMessage)) {
                    List<LiveHorseRaceData> arrayList = new ArrayList<>();
                    if (responsedMessage instanceof GetLiveHorseRaceHttpResponseMessage) {
                        arrayList = ((GetLiveHorseRaceHttpResponseMessage) responsedMessage).getData().cHm();
                    }
                    if (responsedMessage instanceof GetLiveHorseRaceSocketResponseMessage) {
                        arrayList = ((GetLiveHorseRaceSocketResponseMessage) responsedMessage).getData().cHm();
                    }
                    if (FrsFragment.this.jgh != null) {
                        if (FrsFragment.this.jfl == null || FrsFragment.this.jfl.getVisibility() != 8) {
                            if (FrsFragment.this.jgg >= FrsFragment.this.jgh.size()) {
                                FrsFragment.this.jgh.addAll(arrayList);
                                return;
                            }
                            FrsFragment.this.jgh = FrsFragment.this.jgh.subList(0, FrsFragment.this.jgg);
                            FrsFragment.this.jgh.addAll(arrayList);
                            return;
                        }
                        FrsFragment.this.jgh = new ArrayList();
                        FrsFragment.this.jgh.addAll(arrayList);
                        FrsFragment.this.jgg = 0;
                        FrsFragment.this.cFP();
                        return;
                    }
                    FrsFragment.this.jgh = new ArrayList();
                    FrsFragment.this.jgg = 0;
                    FrsFragment.this.jgh.addAll(arrayList);
                    FrsFragment.this.cFP();
                }
            }
        }
    };
    private CustomMessageListener jgu = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.FrsFragment.65
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 1) {
                    FrsFragment.this.cFr();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                }
            }
        }
    };
    private final ar jgv = new ar() { // from class: com.baidu.tieba.frs.FrsFragment.66
        @Override // com.baidu.tieba.frs.ar
        public void a(int i, int i2, ba baVar, ArrayList<com.baidu.adp.widget.ListView.n> arrayList) {
            FrsFragment.this.cFc();
            if (FrsFragment.this.jfI != null) {
                FrsFragment.this.jfB.rx(FrsFragment.this.jfI.AI(i));
            }
            com.baidu.tieba.tbadkCore.f fVar = new com.baidu.tieba.tbadkCore.f();
            if (baVar != null) {
                fVar.isSuccess = baVar.errCode == 0;
                fVar.errorCode = baVar.errCode;
                fVar.errorMsg = baVar.errMsg;
                if (fVar.isSuccess) {
                    if (com.baidu.tbadk.core.util.x.isEmpty(arrayList)) {
                        FrsFragment.this.jfi.bVF();
                    } else if (baVar.hasMore) {
                        if (com.baidu.tbadk.core.util.x.getCount(FrsFragment.this.jeH.getThreadList()) > 3) {
                            FrsFragment.this.jfi.Zg();
                        } else {
                            FrsFragment.this.jfi.cGB();
                        }
                    } else if (baVar.jkh) {
                        FrsFragment.this.jfi.Zh();
                    } else {
                        FrsFragment.this.jfi.bVF();
                    }
                }
            } else {
                baVar = new ba();
                baVar.pn = 1;
                baVar.hasMore = false;
                baVar.jkh = false;
            }
            if (i == 1) {
                FrsFragment.this.jfv = true;
                FrsFragment.this.jgN.a(FrsFragment.this.jfA.getType(), false, fVar);
            } else {
                FrsFragment.this.a(fVar);
                if (FrsFragment.this.jfA.cLF() != null) {
                    FrsFragment.this.jeH = FrsFragment.this.jfA.cLF();
                }
                FrsFragment.this.cFt();
            }
            if (FrsFragment.this.jgV != null) {
                FrsFragment.this.jgV.a(i, i2, baVar, arrayList);
            }
        }
    };
    private FrsTabViewController.a jgw = new FrsTabViewController.a() { // from class: com.baidu.tieba.frs.FrsFragment.2
        @Override // com.baidu.tieba.frs.vc.FrsTabViewController.a
        public void m(int i, int i2, String str) {
            boolean z = false;
            if (i != 1) {
                com.baidu.tieba.card.s.cva().pv(false);
                FrsFragment.this.qo(false);
            }
            if (i == 502) {
                FrsFragment.this.jfj.setIconFade(R.drawable.btn_frs_professional_edit_n);
            } else {
                FrsFragment.this.jfj.setIconFade(0);
            }
            FrsFragment.this.jgx = i;
            FrsFragment.this.jgm = i2;
            if (FrsFragment.this.jgk != null) {
                FrsFragment.this.jgk.Bu(FrsFragment.this.jgm);
            }
            TbSingleton.getInstance().setFrsCurTabType(FrsFragment.this.jgm);
            FrsFragment.this.cFz();
            com.baidu.tieba.frs.b.d.jpq.jGp = i;
            com.baidu.tieba.frs.b.d.jpq.jGs = i2;
            com.baidu.tieba.frs.b.d.jpq.jGq = -1;
            b.cDX().X(i == 1 && FrsFragment.this.jgb, true);
            com.baidu.tieba.frs.a cDQ = com.baidu.tieba.frs.a.cDQ();
            if (i == 1 && FrsFragment.this.jgb) {
                z = true;
            }
            cDQ.X(z, true);
        }
    };
    private CustomMessageListener jgy = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIVE_COUNT) { // from class: com.baidu.tieba.frs.FrsFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                FrsFragment.this.jfC.Ce(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    };
    private CustomMessageListener jgz = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_LIVE_START) { // from class: com.baidu.tieba.frs.FrsFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && ((Integer) customResponsedMessage.getData()).intValue() == 51 && FrsFragment.this.jeH != null) {
                com.baidu.tieba.frs.d.m.a(FrsFragment.this.jeH, FrsFragment.this.getPageContext());
            }
        }
    };
    private final CustomMessageListener jgA = new CustomMessageListener(CmdConfigCustom.CMD_FRS_SELECT_ALA_LIVE_TAB) { // from class: com.baidu.tieba.frs.FrsFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                FrsFragment.this.jfC.uu(49);
            }
        }
    };
    private final CustomMessageListener jgB = new CustomMessageListener(2921470) { // from class: com.baidu.tieba.frs.FrsFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                FrsFragment.this.jfC.uu(1);
                FrsFragment.this.cFr();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
            }
        }
    };
    private final CustomMessageListener jgC = new CustomMessageListener(CmdConfigCustom.CMD_FRS_EXPERIENCE_TIP) { // from class: com.baidu.tieba.frs.FrsFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.w) && FrsFragment.this.jeH != null) {
                FrsFragment.this.jeH.updateLikeData((com.baidu.tieba.tbadkCore.w) customResponsedMessage.getData());
                FrsFragment.this.jfB.j(FrsFragment.this.jeH);
                FrsFragment.this.jfC.a(FrsFragment.this.jeH, FrsFragment.this.jfA.cMj());
            }
        }
    };
    private final AntiHelper.a jgD = new AntiHelper.a() { // from class: com.baidu.tieba.frs.FrsFragment.8
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).an("obj_locate", ax.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).an("obj_locate", ax.a.LOCATE_LIKE_PERSON));
        }
    };
    private CustomMessageListener jgE = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.FrsFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(FrsFragment.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().fuV != null) {
                        if (AntiHelper.a(FrsFragment.this.getActivity(), updateAttentionMessage.getData().fuV, FrsFragment.this.jgD) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).an("obj_locate", ax.a.LOCATE_LIKE_PERSON));
                        }
                    } else if (updateAttentionMessage.getData().isSucc && updateAttentionMessage.getData().isAttention) {
                        com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getPageContext().getPageActivity(), R.string.attention_success);
                    }
                }
            }
        }
    };
    private CustomMessageListener jgF = new CustomMessageListener(CmdConfigCustom.CMD_GET_ENSURE_CAST_ID) { // from class: com.baidu.tieba.frs.FrsFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsFragment.this.refresh();
        }
    };
    private CustomMessageListener jgG = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.frs.FrsFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                FrsFragment.this.jfi.c((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener jgH = new CustomMessageListener(2001378) { // from class: com.baidu.tieba.frs.FrsFragment.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof WriteData) && com.baidu.tbadk.core.util.at.equals(((WriteData) customResponsedMessage.getData()).getForumId(), FrsFragment.this.forumId)) {
                FrsFragment.this.jfN.Bw(((WriteData) customResponsedMessage.getData()).getTabId());
                MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
            }
        }
    };
    private CustomMessageListener jgI = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_REMIND) { // from class: com.baidu.tieba.frs.FrsFragment.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626) {
                NewsRemindMessage newsRemindMessage = (NewsRemindMessage) customResponsedMessage;
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (FrsFragment.this.jfi != null) {
                    FrsFragment.this.jfi.P(notificationCount, z);
                }
            }
        }
    };
    private HttpMessageListener jgJ = new HttpMessageListener(CmdConfigHttp.CMD_FRS_MOVE_AREA) { // from class: com.baidu.tieba.frs.FrsFragment.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int i;
            int i2 = 0;
            if (httpResponsedMessage != null && FrsFragment.this.getContext() != null && FrsFragment.this.jfi != null) {
                if (httpResponsedMessage.getError() == 0) {
                    new BdTopToast(FrsFragment.this.getContext()).yW(true).UY(FrsFragment.this.getContext().getString(R.string.frs_move_area_move_suc)).aR(FrsFragment.this.jfi.cqg());
                    if (com.baidu.tieba.frs.a.cDQ().zP(com.baidu.tieba.frs.a.cDQ().cDS())) {
                        FrsCommonTabFragment frsCommonTabFragment = null;
                        if (FrsFragment.this.jfC != null && FrsFragment.this.jfC.cOq() != null && (FrsFragment.this.jfC.cOq().fragment instanceof FrsCommonTabFragment)) {
                            frsCommonTabFragment = (FrsCommonTabFragment) FrsFragment.this.jfC.cOq().fragment;
                        }
                        if (frsCommonTabFragment != null) {
                            frsCommonTabFragment.cIg();
                        }
                        FrsFragment.this.cDV();
                        com.baidu.tieba.frs.a.cDQ().cDV();
                        Iterator<com.baidu.adp.widget.ListView.n> it = FrsFragment.this.jeH.getThreadList().iterator();
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
                            FrsFragment.this.bUp();
                        }
                    }
                    com.baidu.tieba.frs.a.cDQ().reset();
                    return;
                }
                new BdTopToast(FrsFragment.this.getContext()).yW(false).UY(httpResponsedMessage.getErrorString()).aR(FrsFragment.this.jfi.cqg());
            }
        }
    };
    private com.baidu.tbadk.mutiprocess.h mTopToastEventListener = new com.baidu.tbadk.mutiprocess.h<TopToastEvent>() { // from class: com.baidu.tieba.frs.FrsFragment.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.mutiprocess.b
        public boolean a(TopToastEvent topToastEvent) {
            new BdTopToast(FrsFragment.this.getContext()).yW(topToastEvent.isSuccess()).UY(topToastEvent.getContent()).aR(FrsFragment.this.jfi.cqg());
            return false;
        }
    };
    private final CustomMessageListener jgK = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.frs.FrsFragment.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.isResumed()) {
                FrsFragment.this.cFO();
            }
        }
    };
    private CustomMessageListener jgL = new CustomMessageListener(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER) { // from class: com.baidu.tieba.frs.FrsFragment.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (FrsFragment.this.jfi != null) {
                    FrsFragment.this.jfi.setExpanded(booleanValue);
                }
            }
        }
    };
    private final CustomMessageListener jgM = new CustomMessageListener(2921463) { // from class: com.baidu.tieba.frs.FrsFragment.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TbadkApplication.getInst().getCurrentActivity() != null && !com.baidu.tbadk.core.util.at.isEmpty(str) && str.equals(FrsFragment.this.forumId)) {
                    com.baidu.tieba.frs.d.h.b(((TbPageContextSupport) TbadkApplication.getInst().getCurrentActivity()).getPageContext(), FrsFragment.this.jeH);
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.s jgN = new com.baidu.tieba.tbadkCore.s() { // from class: com.baidu.tieba.frs.FrsFragment.20
        private long startTime = 0;

        @Override // com.baidu.tieba.tbadkCore.s
        public void zW(int i) {
            this.startTime = System.nanoTime();
            if (FrsFragment.this.jfi != null) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsFragment.this.jfi.cGm();
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
                com.baidu.tieba.frs.d.k.a(FrsFragment.this.jfi, FrsFragment.this.jeH, FrsFragment.this.getForumId(), false, null);
            }
            FrsFragment.this.cFc();
            FrsFragment.this.jft = true;
            if (fVar != null && fVar.isSuccess) {
                FrsFragment.this.jfi.cGz().qZ(com.baidu.tbadk.core.util.au.bwr().bws());
                FrsFragment.jfp = 0L;
                FrsFragment.jfq = 0L;
                FrsFragment.mNetError = 0;
            } else {
                FrsFragment.mNetError = 1;
            }
            if (!FrsFragment.this.jfA.cMo() && (i == 3 || i == 6)) {
                FrsFragment.this.jfL.resetData();
            }
            FrsFragment.this.jfn = System.currentTimeMillis();
            if (FrsFragment.this.jfA.cLF() != null) {
                FrsFragment.this.jeH = FrsFragment.this.jfA.cLF();
            }
            FrsFragment.this.zS(1);
            FrsFragment.this.cFk();
            if (i == 7) {
                FrsFragment.this.zT(FrsFragment.this.jeH.getFrsDefaultTabId());
                return;
            }
            if (FrsFragment.this.jeH.getPage() != null) {
                FrsFragment.this.setHasMore(FrsFragment.this.jeH.getPage().bqf());
            }
            if (i == 4) {
                if (!FrsFragment.this.jfA.cMo() && TbadkCoreApplication.getInst().isRecAppExist() && FrsFragment.this.jfA.cMe() == 1 && !com.baidu.tieba.funad.a.cPq()) {
                    FrsFragment.this.jeH.addRecommendAppToThreadList(FrsFragment.this);
                }
                ArrayList<com.baidu.adp.widget.ListView.n> a2 = FrsFragment.this.jfL.a(false, false, FrsFragment.this.jeH.getThreadList(), FrsFragment.this.jfe, false);
                if (a2 != null) {
                    FrsFragment.this.jeH.setThreadList(a2);
                    FrsFragment.this.jeH.checkLiveStageInThreadList();
                }
                if (FrsFragment.this.jfA != null) {
                    com.baidu.tieba.frs.b.c.a(FrsFragment.this.jeH, FrsFragment.this.jfA.cMj(), 2, FrsFragment.this.getContext());
                }
                com.baidu.tieba.frs.d.a.a(FrsFragment.this, FrsFragment.this.jeH.getForum(), FrsFragment.this.jeH.getThreadList(), false, FrsFragment.this.getPn());
                FrsFragment.this.jfi.a(a2, FrsFragment.this.jeH);
                FrsFragment.this.cFd();
                return;
            }
            FrsFragment.this.cFd();
            switch (i) {
                case 1:
                    FrsFragment.this.jfi.cGm();
                    break;
                case 2:
                    FrsFragment.this.jfi.cGm();
                    break;
                case 3:
                case 6:
                    if (FrsFragment.this.jeH != null) {
                        FrsFragment.this.jeH.clearPostThreadCount();
                    }
                    if (FrsFragment.this.jfQ != null) {
                        FrsFragment.this.jfQ.refresh();
                        break;
                    }
                    break;
            }
            FrsFragment.this.cFl();
            if (fVar == null || fVar.errorCode == 0) {
                if (FrsFragment.this.jeH != null) {
                    FrsFragment.this.a(FrsFragment.this.jeH);
                    FrsFragment.this.Z(false, i == 5);
                    if (FrsFragment.this.jfA != null) {
                        if (FrsFragment.this.jeH.getActivityHeadData() != null && FrsFragment.this.jeH.getActivityHeadData().bps() != null && FrsFragment.this.jeH.getActivityHeadData().bps().size() > 0) {
                            com.baidu.tieba.frs.b.a.a(FrsFragment.this.getUniqueId(), 1, FrsFragment.this.jeH.getForum(), FrsFragment.this.jfA.getSortType(), 1);
                        }
                        if (FrsFragment.this.jeH.getThreadList() != null && FrsFragment.this.jeH.getThreadList().size() > 0) {
                            Iterator<com.baidu.adp.widget.ListView.n> it = FrsFragment.this.jeH.getThreadList().iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    com.baidu.adp.widget.ListView.n next = it.next();
                                    if ((next instanceof bz) && ((bz) next).getType() == bz.eUO) {
                                        com.baidu.tieba.frs.b.a.a(FrsFragment.this.getUniqueId(), 1, FrsFragment.this.jeH.getForum(), FrsFragment.this.jfA.getSortType(), 2);
                                    }
                                }
                            }
                        }
                        com.baidu.tieba.frs.b.a.a(FrsFragment.this.getUniqueId(), FrsFragment.this.jeH.getThreadList(), FrsFragment.this.jeH.getForum(), FrsFragment.this.jfA.getSortType());
                    }
                    FrsFragment.this.jfi.Aj(i);
                    FrsFragment.jfp = (System.nanoTime() - this.startTime) / TimeUtils.NANOS_PER_MS;
                    if (fVar != null) {
                        FrsFragment.jfq = fVar.npe;
                    }
                } else {
                    return;
                }
            } else if (FrsFragment.this.jeH == null || com.baidu.tbadk.core.util.x.isEmpty(FrsFragment.this.jeH.getThreadList())) {
                FrsFragment.this.a(fVar);
            } else if (fVar.iPi) {
                FrsFragment.this.showToast(FrsFragment.this.getPageContext().getResources().getString(R.string.net_error_text, fVar.errorMsg, Integer.valueOf(fVar.errorCode)));
            }
            FrsFragment.this.cFh();
            FrsFragment.this.cFi();
            if (FrsFragment.this.jeH.getAccessFlag() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11384"));
            }
            if (FrsFragment.this.jff && FrsFragment.this.jfC.uu(49)) {
                FrsFragment.this.jff = false;
            }
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.s
        public void c(com.baidu.tieba.tbadkCore.m mVar) {
            if ((mVar != null && ("normal_page".equals(FrsFragment.this.jfA.getPageType()) || "frs_page".equals(FrsFragment.this.jfA.getPageType()) || "book_page".equals(FrsFragment.this.jfA.getPageType()))) || "brand_page".equals(FrsFragment.this.jfA.getPageType())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE, mVar));
                FrsFragment.this.b(mVar);
                FrsFragment.jfm = mVar;
            }
        }

        @Override // com.baidu.tieba.tbadkCore.s
        public void cFn() {
            FrsFragment.this.cFn();
        }
    };
    private final CustomMessageListener jgO = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.frs.FrsFragment.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.n) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                FrsFragment.this.jeH.updateCurrentUserPendant((com.baidu.tbadk.data.n) customResponsedMessage.getData());
                FrsFragment.this.jfi.cGz().notifyDataSetChanged();
            }
        }
    };
    private final CustomMessageListener mMemListener = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_MEM) { // from class: com.baidu.tieba.frs.FrsFragment.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && FrsFragment.this.jeH != null && (userData = FrsFragment.this.jeH.getUserData()) != null) {
                userData.setIsMem(num.intValue());
                if (num.intValue() != 0) {
                    FrsFragment.this.jfB.q(num);
                }
            }
        }
    };
    private final f.a jgP = new AnonymousClass31();
    private final com.baidu.tieba.frs.mc.k jgQ = new com.baidu.tieba.frs.mc.k() { // from class: com.baidu.tieba.frs.FrsFragment.32
        @Override // com.baidu.tieba.frs.mc.k
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.n> arrayList, boolean z3) {
            if (FrsFragment.this.jfE != null && FrsFragment.this.jfA != null && FrsFragment.this.jfA.cMo() && z && !z2 && !z3) {
                FrsFragment.this.jfE.BB(i2);
            }
        }
    };
    public final View.OnTouchListener bTP = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.FrsFragment.33
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (FrsFragment.this.jfS != null) {
                FrsFragment.this.jfS.onTouch(view, motionEvent);
            }
            if (FrsFragment.this.jfG != null && FrsFragment.this.jfG.cHn() != null) {
                FrsFragment.this.jfG.cHn().onTouchEvent(motionEvent);
            }
            if (FrsFragment.this.gXD != null) {
                FrsFragment.this.gXD.i(view, motionEvent);
            }
            if (FrsFragment.this.jfB != null) {
                FrsFragment.this.jfB.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private final CustomMessageListener jgR = new CustomMessageListener(CmdConfigCustom.CMD_GOTOLIVE_HOST_UPGRADE) { // from class: com.baidu.tieba.frs.FrsFragment.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.bvq().getInt(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.PHOTOLIVE_HOSTLEVEL, -1) != -1 && FrsFragment.this.jeH.getForum() != null) {
                FrsFragment.this.jeH.getForum().setCanAddPhotoLivePost(true);
            }
        }
    };
    public final View.OnClickListener jgS = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.41
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsFragment.this.jfi != null && view == FrsFragment.this.jfi.cGk() && FrsFragment.this.getActivity() != null) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, FrsFragment.this.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            if (view.getId() == R.id.game_activity_egg_layout && com.baidu.adp.lib.util.l.isNetOk()) {
                TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_CLICK);
                if (FrsFragment.this.jfi == null || !FrsFragment.this.jfi.cGw()) {
                    String activityUrl = FrsFragment.this.jeH.getForum().getYuleData().btP().getActivityUrl();
                    if (!StringUtils.isNull(activityUrl)) {
                        com.baidu.tbadk.browser.a.startInternalWebActivity(FrsFragment.this.getPageContext().getPageActivity(), activityUrl);
                    }
                } else {
                    FrsFragment.this.jfi.cGx();
                }
            }
            if (FrsFragment.this.jfi != null && view == FrsFragment.this.jfi.cGC() && FrsFragment.this.jfA != null && FrsFragment.this.jfA.hasMore()) {
                FrsFragment.this.jfi.Zg();
                FrsFragment.this.bUp();
            }
            if (view != null && FrsFragment.this.jfi != null && view == FrsFragment.this.jfi.cGt()) {
                if (bg.checkUpIsLogin(FrsFragment.this.getContext())) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).an("obj_locate", 2));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MessageCenterActivityConfig(FrsFragment.this.getContext())));
                } else {
                    return;
                }
            }
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (FrsFragment.this.jeH != null && FrsFragment.this.jeH.getForum() != null) {
                    if (FrsFragment.this.jfi != null && view == FrsFragment.this.jfi.cGr()) {
                        if (FrsFragment.this.jeH != null && FrsFragment.this.jeH.getForum() != null && !StringUtils.isNull(FrsFragment.this.jeH.getForum().getId()) && !StringUtils.isNull(FrsFragment.this.jeH.getForum().getName())) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_SHARE_CLICK).dX("fid", FrsFragment.this.jeH.getForum().getId()).an("obj_locate", 11));
                            com.baidu.tieba.frs.d.h.a(FrsFragment.this.getPageContext(), FrsFragment.this.jeH, FrsFragment.this.jeH.getForum().getId());
                        } else {
                            return;
                        }
                    }
                    if (FrsFragment.this.jfi != null && view == FrsFragment.this.jfi.cGq()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12402").dX("fid", FrsFragment.this.jeH.getForum().getId()).dX("uid", TbadkCoreApplication.getCurrentAccount()).dX("fname", FrsFragment.this.jeH.getForum().getName()));
                        if (!StringUtils.isNull(FrsFragment.this.jeH.getForum().getName())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PostSearchActivityConfig(FrsFragment.this.getContext(), FrsFragment.this.jeH.getForum().getName(), FrsFragment.this.jeH.getForum().getId())));
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
        private int jhq = 0;
        private int gAO = 0;

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsFragment.this.jgf += i2;
            if (FrsFragment.this.jgf >= FrsFragment.this.dXO * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
            if (FrsFragment.this.jfJ != null) {
                FrsFragment.this.jfJ.cNk();
            }
            this.jhq = 0;
            this.gAO = 0;
            if (recyclerView != null && (recyclerView instanceof BdRecyclerView)) {
                this.jhq = ((BdRecyclerView) recyclerView).getFirstVisiblePosition();
                this.gAO = ((BdRecyclerView) recyclerView).getLastVisiblePosition();
            }
            if (FrsFragment.this.jfU != null) {
                FrsFragment.this.jfU.a(recyclerView, this.jhq, this.gAO);
            }
            if (FrsFragment.this.jeH != null && FrsFragment.this.jfi != null && FrsFragment.this.jfi.cGz() != null) {
                FrsFragment.this.jfi.cq(this.jhq, this.gAO);
                if (FrsFragment.this.jfz != null && FrsFragment.this.jfz.ty() != null) {
                    FrsFragment.this.jfz.ty().b(FrsFragment.this.jfy);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (FrsFragment.this.jfB != null) {
                FrsFragment.this.jfB.setScrollState(i);
                if (i == 1) {
                    FrsFragment.this.jfB.cNL();
                }
            }
            if (FrsFragment.this.jfu == null && !FrsFragment.this.cFH()) {
                FrsFragment.this.jfu = new com.baidu.tbadk.n.b();
                FrsFragment.this.jfu.setSubType(1000);
            }
            if (i == 0) {
                if (FrsFragment.this.jfu != null) {
                    FrsFragment.this.jfu.bHy();
                }
                com.baidu.tieba.card.s.cva().pv(true);
                FrsFragment.this.qo(true);
                FrsFragment.this.jfi.cp(this.jhq, this.gAO);
            } else if (FrsFragment.this.jfu != null) {
                FrsFragment.this.jfu.bHx();
            }
            if (FrsFragment.this.jfU != null) {
                FrsFragment.this.jfU.onScrollStateChanged(recyclerView, i);
            }
            if (i == 0) {
                com.baidu.tieba.frs.d.k.a(FrsFragment.this.jfi, FrsFragment.this.jeH, FrsFragment.this.getForumId(), false, null);
            }
            if (FrsFragment.this.jfC != null && i == 1) {
                FrsFragment.this.jfC.cOs();
            }
            if (FrsFragment.this.jfz == null) {
                if (FrsFragment.this.jfi.cGd() != null && !FrsFragment.this.jfi.cFF() && FrsFragment.this.jfi.cGd().dBE() != null && (FrsFragment.this.jfi.cGd().dBE().getTag() instanceof ThreadCardViewHolder)) {
                    FrsFragment.this.jfz = (ThreadCardViewHolder) FrsFragment.this.jfi.cGd().dBE().getTag();
                }
            } else if (i == 0 && FrsFragment.this.jfi.cGd() != null && !FrsFragment.this.jfi.cFF() && FrsFragment.this.jfi.cGd().dBE() != null && (FrsFragment.this.jfi.cGd().dBE().getTag() instanceof ThreadCardViewHolder)) {
                FrsFragment.this.jfz = (ThreadCardViewHolder) FrsFragment.this.jfi.cGd().dBE().getTag();
            }
            if (i == 1) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921418));
            }
        }
    };
    private final f jgT = new f() { // from class: com.baidu.tieba.frs.FrsFragment.43
        @Override // com.baidu.tieba.frs.f
        public void a(int i, int i2, View view, View view2, bz bzVar) {
            if (i != FrsFragment.this.jfi.cGz().cIZ()) {
                if (i != FrsFragment.this.jfi.cGz().cJa()) {
                    if (i == FrsFragment.this.jfi.cGz().cIX() && FrsFragment.this.jeH != null && FrsFragment.this.jeH.getUserData() != null && FrsFragment.this.jeH.getUserData().isBawu()) {
                        String bawuCenterUrl = FrsFragment.this.jeH.getBawuCenterUrl();
                        if (!com.baidu.tbadk.core.util.at.isEmpty(bawuCenterUrl) && FrsFragment.this.jeH.getForum() != null) {
                            com.baidu.tbadk.browser.a.startWebActivity(FrsFragment.this.getPageContext().getPageActivity(), bawuCenterUrl);
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10502").dX("fid", FrsFragment.this.jeH.getForum().getId()).dX("uid", FrsFragment.this.jeH.getUserData().getUserId()));
                        }
                    }
                } else if (bg.checkUpIsLogin(FrsFragment.this.getPageContext().getPageActivity())) {
                    TiebaStatic.log(CommonStatisticKey.MY_SERVICE_CK);
                    if (FrsFragment.this.jeH != null && FrsFragment.this.jeH.getForum() != null) {
                        ForumData forum = FrsFragment.this.jeH.getForum();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(forum.getId(), 0L), forum.getName(), forum.getImage_url(), 0)));
                    }
                }
            } else if (bg.checkUpIsLogin(FrsFragment.this.getActivity())) {
                TiebaStatic.log("forum_fortune_click");
                com.baidu.tieba.frs.d.l.c(FrsFragment.this.getPageContext(), FrsFragment.this.jeH);
            }
        }
    };
    private final NoNetworkView.a jct = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.FrsFragment.44
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (FrsFragment.this.jfA.cMe() == 1 && z && !FrsFragment.this.jfi.cFF()) {
                if (FrsFragment.this.jeH == null || com.baidu.tbadk.core.util.x.isEmpty(FrsFragment.this.jeH.getThreadList())) {
                    FrsFragment.this.hideNetRefreshView(FrsFragment.this.jfi.cGN().cOg());
                    FrsFragment.this.showLoadingView(FrsFragment.this.jfi.cqg(), true);
                    FrsFragment.this.jfi.qz(false);
                    FrsFragment.this.refresh();
                    return;
                }
                FrsFragment.this.jfi.cGm();
            }
        }
    };
    private final CustomMessageListener fvn = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.FrsFragment.46
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                com.baidu.tieba.frs.d.c.a(customResponsedMessage, FrsFragment.this.jfi, FrsFragment.this.jeH);
            }
        }
    };
    private com.baidu.adp.widget.ListView.w jgU = new a();
    private ar jgV = new ar() { // from class: com.baidu.tieba.frs.FrsFragment.48
        @Override // com.baidu.tieba.frs.ar
        public void a(int i, int i2, ba baVar, ArrayList<com.baidu.adp.widget.ListView.n> arrayList) {
            com.baidu.adp.lib.f.e.mB().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.48.1
                @Override // java.lang.Runnable
                public void run() {
                    if (FrsFragment.this.jfi != null && FrsFragment.this.jfi.cGF()) {
                        FrsFragment.this.bUp();
                    }
                }
            });
        }
    };
    private CustomMessageListener jgW = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.frs.FrsFragment.49
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    FrsFragment.this.jfV = true;
                }
            }
        }
    };
    private CustomMessageListener jgX = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.frs.FrsFragment.50
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                    if (FrsFragment.this.jfz == null && FrsFragment.this.jfi.cGd() != null && !FrsFragment.this.jfi.cFF() && FrsFragment.this.jfi.cGd().dBE() != null && (FrsFragment.this.jfi.cGd().dBE().getTag() instanceof ThreadCardViewHolder)) {
                        FrsFragment.this.jfz = (ThreadCardViewHolder) FrsFragment.this.jfi.cGd().dBE().getTag();
                    }
                    if (FrsFragment.this.jfz != null && FrsFragment.this.jfz.ty() != null) {
                        FrsFragment.this.jfz.ty().b(new a.C0090a(3));
                    }
                }
            }
        }
    };
    private CustomMessageListener jgY = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.FrsFragment.51
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.jfi != null) {
                FrsFragment.this.jfi.Hp();
            }
        }
    };
    private CustomMessageListener jgZ = new CustomMessageListener(2921437) { // from class: com.baidu.tieba.frs.FrsFragment.52
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && FrsFragment.this.isResumed()) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (FrsFragment.this.jfk != null) {
                    if (booleanValue) {
                        if (FrsFragment.this.jfC.cOt() != 0 && !FrsFragment.this.jfi.cGK() && !com.baidu.tbadk.k.d.bGb().bGc()) {
                            FrsFragment.this.jfk.show();
                            return;
                        }
                        return;
                    }
                    FrsFragment.this.jfk.hide();
                }
            }
        }
    };
    private CustomMessageListener jha = new CustomMessageListener(2921462) { // from class: com.baidu.tieba.frs.FrsFragment.58
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && FrsFragment.this.jeH.getToLoadHorseData().intValue() == 1 && FrsFragment.this.mIsLogin) {
                LiveHorseRaceRequestMessage liveHorseRaceRequestMessage = new LiveHorseRaceRequestMessage();
                liveHorseRaceRequestMessage.setForum_id(Long.valueOf(FrsFragment.this.forumId));
                FrsFragment.this.sendMessage(liveHorseRaceRequestMessage);
            }
        }
    };
    private CustomMessageListener jhb = new CustomMessageListener(2001223) { // from class: com.baidu.tieba.frs.FrsFragment.59
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Date)) {
                FrsFragment.this.jge = (Date) customResponsedMessage.getData();
            }
        }
    };
    private CustomMessageListener jhc = new CustomMessageListener(2921469) { // from class: com.baidu.tieba.frs.FrsFragment.60
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.y) && FrsFragment.this.isResumed()) {
                com.baidu.tbadk.core.data.y yVar = (com.baidu.tbadk.core.data.y) customResponsedMessage.getData();
                if (FrsFragment.this.jgl == null) {
                    FrsFragment.this.jgl = new com.baidu.tieba.frs.broadcast.a(FrsFragment.this.getPageContext());
                }
                if (FrsFragment.this.jeH != null && FrsFragment.this.jeH.getForum() != null && !TextUtils.isEmpty(FrsFragment.this.jeH.getForum().getId())) {
                    FrsFragment.this.jgl.e(yVar.type, FrsFragment.this.jeH.getForum().getId(), FrsFragment.this.jeH.getForum().getName(), yVar.tid);
                }
            }
        }
    };
    private CustomMessageListener jhd = new CustomMessageListener(2921475) { // from class: com.baidu.tieba.frs.FrsFragment.61
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bz bzVar = (bz) customResponsedMessage.getData();
            if (bzVar != null && FrsFragment.this.isResumed()) {
                FrsFragment.this.jfx = bzVar.getTid() + "";
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE_NUMBER);
                httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
                httpMessage.addParam("forum_id", bzVar.getFid());
                MessageManager.getInstance().sendMessage(httpMessage);
            }
        }
    };
    private HttpMessageListener jhe = new HttpMessageListener(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE_NUMBER) { // from class: com.baidu.tieba.frs.FrsFragment.62
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if ((httpResponsedMessage instanceof ForumManagerRightsResMsg) && FrsFragment.this.isResumed()) {
                ForumManagerRightsResMsg forumManagerRightsResMsg = (ForumManagerRightsResMsg) httpResponsedMessage;
                if (forumManagerRightsResMsg.broadcastTotalCount - forumManagerRightsResMsg.broadcastUsedCount <= 0) {
                    new ScreenTopToast(FrsFragment.this.getContext()).Vc(FrsFragment.this.getString(R.string.frs_forum_bawu_send_broadcast_none_tip)).Ve(FrsFragment.this.getString(R.string.frs_recommend_fail_tip_btn)).an(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.62.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("_forumId", FrsFragment.this.jeH.getForum().getId());
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new com.baidu.tieba.tbadkCore.data.m(FrsFragment.this.getContext(), "ForumGradePage", hashMap)));
                        }
                    }).aR((ViewGroup) FrsFragment.this.mRootView.findViewById(R.id.frs));
                    return;
                }
                com.baidu.tbadk.core.util.o oVar = new com.baidu.tbadk.core.util.o(TbadkCoreApplication.getInst());
                oVar.ao(FrsFragment.this.jeH.getForum().getId(), FrsFragment.this.jeH.getForum().getName(), "6");
                oVar.BP(FrsFragment.this.jfx);
                oVar.start();
            }
        }
    };
    private CustomMessageListener jhf = new CustomMessageListener(2921515) { // from class: com.baidu.tieba.frs.FrsFragment.63
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                com.baidu.tieba.NEGFeedBack.g gVar = (com.baidu.tieba.NEGFeedBack.g) customResponsedMessage.getData();
                if (FrsFragment.this.jeH == null || FrsFragment.this.jeH.getForum() == null || FrsFragment.this.jeH.getForum().getDeletedReasonInfo() == null) {
                    com.baidu.tieba.NEGFeedBack.d.a(0, FrsFragment.this.getPageContext(), gVar, null, FrsFragment.this.jeH.getUserData());
                    return;
                }
                com.baidu.tieba.NEGFeedBack.h hVar = new com.baidu.tieba.NEGFeedBack.h(FrsFragment.this.jeH.getForum().getDeletedReasonInfo().is_grays_cale_forum.intValue(), FrsFragment.this.jeH.getForum().getDeletedReasonInfo().is_boomgrow.intValue(), FrsFragment.this.jeH.forumRule != null ? FrsFragment.this.jeH.forumRule.has_forum_rule.intValue() : 0);
                hVar.ej(FrsFragment.this.jeH.getForum().getId(), FrsFragment.this.jeH.getForum().getName());
                hVar.setForumHeadUrl(FrsFragment.this.jeH.getForum().getImage_url());
                hVar.setUserLevel(FrsFragment.this.jeH.getForum().getUser_level());
                com.baidu.tieba.NEGFeedBack.d.a(hVar.bNS(), FrsFragment.this.getPageContext(), gVar, hVar, FrsFragment.this.jeH.getUserData());
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.frs.loadmore.a
    public /* bridge */ /* synthetic */ com.baidu.adp.base.f getPageContext() {
        return super.getPageContext();
    }

    public com.baidu.tieba.frs.entelechy.a.b cEQ() {
        return this.jfI;
    }

    public com.baidu.adp.widget.ListView.w cER() {
        return this.jgU;
    }

    public com.baidu.tieba.frs.mc.d cES() {
        return this.jfK;
    }

    public com.baidu.tieba.frs.smartsort.a cET() {
        return this.jfE;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public FrsModelController cEU() {
        return this.jfA;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public com.baidu.tieba.frs.mc.c cEV() {
        return this.jfL;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public com.baidu.tieba.frs.vc.h cEW() {
        return this.jfB;
    }

    public FrsTabViewController cEX() {
        return this.jfC;
    }

    public at cEY() {
        return this.jfG;
    }

    public void qn(boolean z) {
        this.jgd = z;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public q cEZ() {
        return this.jfi;
    }

    @Override // com.baidu.tieba.frs.as
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.as, com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.jfa;
    }

    public void setForumName(String str) {
        this.jfa = str;
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
        if (this.jfL == null) {
            return 1;
        }
        return this.jfL.getPn();
    }

    public int getPn() {
        if (this.jfL == null) {
            return 1;
        }
        return this.jfL.getPn();
    }

    public void setPn(int i) {
        if (this.jfL != null) {
            this.jfL.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.jfL != null) {
            this.jfL.setHasMore(i);
        }
    }

    public int cFa() {
        if (this.jfL == null) {
            return -1;
        }
        return this.jfL.cFa();
    }

    public boolean cFb() {
        return this.jfg;
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
            this.jfi.cGg();
            showNetRefreshView(this.jfi.cqg(), string, true);
        } else if (340001 == fVar.errorCode) {
            a(fVar, this.jeH.getRecm_forum_list());
        } else {
            if (com.baidu.tbadk.core.util.x.isEmpty(this.jeH.getThreadList())) {
                b(fVar);
            }
            if (cFH()) {
                setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds280));
            } else {
                setNetRefreshViewEmotionDefMarginTop();
            }
        }
    }

    public void a(View view, String str, boolean z, List<RecmForumInfo> list) {
        this.jfi.cGg();
        this.jfi.Ad(8);
        if (this.jfT == null) {
            this.jfT = new com.baidu.tieba.frs.view.a(getPageContext(), getNetRefreshListener());
        }
        this.jfT.setSubText(str);
        this.jfT.setListData(list);
        this.jfT.attachView(view, z);
    }

    private void a(com.baidu.tieba.tbadkCore.f fVar, List<RecmForumInfo> list) {
        if (this.jfi != null) {
            this.jfi.cGg();
            this.jfi.setTitle(this.jfa);
            a(this.jfi.cqg(), fVar.errorMsg, true, list);
        }
    }

    private void b(com.baidu.tieba.tbadkCore.f fVar) {
        this.jfi.cGg();
        if (fVar.iPi) {
            showNetRefreshView(this.jfi.cqg(), TbadkCoreApplication.getInst().getString(R.string.net_error_text, new Object[]{fVar.errorMsg, Integer.valueOf(fVar.errorCode)}), true);
        } else {
            showNetRefreshView(this.jfi.cGN().cOg(), fVar.errorMsg, true);
        }
    }

    public void cFc() {
        hideLoadingView(this.jfi.cqg());
        this.jfi.bUO();
        if (this.jfi.cGe() instanceof com.baidu.tieba.frs.tab.c) {
            ((com.baidu.tieba.frs.tab.c) this.jfi.cGe()).cMM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFd() {
        if (cFa() == 0 && com.baidu.tbadk.core.util.x.isEmpty(this.jeH.getThreadListIds())) {
            if (com.baidu.tbadk.core.util.x.isEmpty(this.jeH.getThreadList())) {
                this.jfi.bVF();
            } else {
                this.jfi.Zh();
            }
        } else if (com.baidu.tbadk.core.util.x.getCount(this.jeH.getThreadList()) > 3) {
            this.jfi.Zg();
        } else {
            this.jfi.cGB();
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
            cFc();
            this.jfi.cGm();
            com.baidu.tieba.tbadkCore.f cMa = this.jfA.cMa();
            boolean isEmpty = com.baidu.tbadk.core.util.x.isEmpty(this.jeH.getThreadList());
            if (cMa != null && isEmpty) {
                if (this.jfA.cMc() != 0) {
                    this.jfA.cMh();
                    this.jfi.cGm();
                } else {
                    a(cMa);
                }
                this.jfi.aa(this.jeH.isStarForum(), false);
                return;
            }
            a(cMa);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(com.baidu.tieba.tbadkCore.m mVar) {
        if (mVar != null && mVar.getEntelechyTabInfo() != null && mVar.getEntelechyTabInfo().tab != null) {
            for (FrsTabInfo frsTabInfo : mVar.getEntelechyTabInfo().tab) {
                if (frsTabInfo.tab_id.intValue() == 502 && com.baidu.tbadk.core.sharedPref.b.bvq().getBoolean("first_into_tab_profession", true)) {
                    return false;
                }
            }
        }
        return new com.baidu.tieba.frs.ad.f(getTbPageContext()).d(mVar);
    }

    public boolean cFe() {
        return cFf() && !cFg();
    }

    private boolean cFf() {
        if (cFE() == null) {
            return false;
        }
        FrsViewData cFE = cFE();
        com.baidu.tbadk.core.data.z zVar = null;
        if (cFE.getStar() != null && !StringUtils.isNull(cFE.getStar().dOm())) {
            zVar = new com.baidu.tbadk.core.data.z();
        } else if (cFE.getActivityHeadData() != null && com.baidu.tbadk.core.util.x.getCount(cFE.getActivityHeadData().bps()) >= 1) {
            zVar = cFE.getActivityHeadData().bps().get(0);
        }
        return zVar != null;
    }

    public boolean cFg() {
        if (cFE() == null) {
            return false;
        }
        FrsViewData cFE = cFE();
        return (com.baidu.tbadk.core.util.x.isEmpty(cFE.getShowTopThreadList()) && cFE.getBusinessPromot() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFh() {
        boolean b2;
        if (!cFj()) {
            final PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
            privateForumPopInfoData.a(this.jeH.getPrivateForumTotalInfo().getPrivatePopInfo());
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(getActivity());
            if (this.jeH.getPrivateForumTotalInfo().bqm().private_forum_status.intValue() == 1 && (com.baidu.tbadk.core.util.at.isEmpty(privateForumPopInfoData.bqo()) || privateForumPopInfoData.bqr() != Integer.valueOf(this.forumId))) {
                privateForumPopInfoData.AR("create_success");
                privateForumPopInfoData.AS(TbadkCoreApplication.getInst().getString(R.string.frs_private_create_hint));
                privateForumPopInfoData.AT("https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.jfa + "&nomenu=1");
                privateForumPopInfoData.m(Integer.valueOf(this.forumId));
                b2 = frsPrivateCommonDialogView.b(privateForumPopInfoData);
            } else {
                b2 = privateForumPopInfoData.bqr() == Integer.valueOf(this.forumId) ? frsPrivateCommonDialogView.b(privateForumPopInfoData) : false;
            }
            if (b2) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
                aVar.pd(2);
                aVar.br(frsPrivateCommonDialogView);
                aVar.jI(false);
                frsPrivateCommonDialogView.setConfirmButton(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.21
                    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.frs.FrsFragment */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        be.bwu().b(FrsFragment.this.getPageContext(), new String[]{privateForumPopInfoData.bqq()});
                        aVar.dismiss();
                    }
                });
                aVar.a(new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.22
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(getPageContext()).btX();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFi() {
        if (cFj() || this.jeH.getPrivateForumTotalInfo().bqm().private_forum_status.intValue() != 1) {
            a((Integer) null, (Integer) null, true);
        } else {
            a(this.jeH.getPrivateForumTotalInfo().bqm().private_forum_audit_status, this.jeH.getPrivateForumTotalInfo().bqn(), false);
        }
    }

    public void a(Integer num, Integer num2, boolean z) {
        final int i = 2;
        if (this.jfi.cGs() != null) {
            TextView cGs = this.jfi.cGs();
            if (z) {
                cGs.setVisibility(8);
                return;
            }
            final String str = "";
            if (num.intValue() == 2) {
                cGs.setText("修改实名认证信息");
                cGs.setVisibility(0);
                str = "https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + this.forumId + "&nomenu=1";
            } else if (num2.intValue() >= 0 && num2.intValue() <= 100) {
                cGs.setText("目标已完成" + String.valueOf(num2) + "%");
                cGs.setVisibility(0);
                i = 1;
                str = "https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.jfa + "&nomenu=1";
            } else {
                cGs.setVisibility(8);
                i = 0;
            }
            cGs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.24
                /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13387").dX("fid", FrsFragment.this.forumId).dX("uid", TbadkCoreApplication.getCurrentAccount()).an("obj_type", i));
                    be.bwu().b(FrsFragment.this.getPageContext(), new String[]{str});
                }
            });
        }
    }

    private boolean cFj() {
        return this.jeH == null || this.jeH.getPrivateForumTotalInfo() == null || this.jeH.getPrivateForumTotalInfo().bqm() == null || this.jeH.getUserData().getIs_manager() != 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zS(int i) {
        List<WindowToast> list;
        if (TbadkCoreApplication.isLogin() && this.jeH != null && (list = this.jeH.mWindowToast) != null && list.size() > 0) {
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
    public void cFk() {
        if (getActivity() != null && getActivity().getIntent() != null) {
            String stringExtra = getActivity().getIntent().getStringExtra(FrsActivityConfig.KEY_ACHIEVEMENT_URL);
            if (!TextUtils.isEmpty(stringExtra)) {
                getActivity().getIntent().removeExtra(FrsActivityConfig.KEY_ACHIEVEMENT_URL);
                AchievementActivityConfig achievementActivityConfig = new AchievementActivityConfig(getActivity());
                achievementActivityConfig.setUrl(stringExtra);
                if (this.jeH != null && this.jeH.getForumActiveInfo() != null) {
                    achievementActivityConfig.setShareUrl(this.jeH.getForumActiveInfo().forum_share_url);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, achievementActivityConfig));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFl() {
        if (this.jeH == null || this.jeH.getForum() != null) {
            this.jfi.cGy();
        } else if (this.jeH.getForum().getYuleData() != null && this.jeH.getForum().getYuleData().btO()) {
            TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_VIEW);
            this.jfi.a(this.jeH.getForum().getYuleData().btP());
        } else {
            this.jfi.cGy();
        }
    }

    private void Y(boolean z, boolean z2) {
        if (this.jfA != null && this.jeH != null && this.jfi != null && z) {
            if (!this.jfA.cMo() && this.jfA.cMe() == 1) {
                if (!this.jfA.cMm()) {
                    this.jeH.addCardVideoInfoToThreadList();
                    this.jeH.addVideoInfoToThreadListInTenAndFifteenFloor();
                }
                boolean z3 = false;
                if (this.jfi.cGz().r(com.baidu.tieba.card.data.n.iAa)) {
                    z3 = this.jeH.addHotTopicDataToThreadList();
                }
                if (!z3) {
                    this.jeH.addFeedForumDataToThreadList();
                }
                if (TbadkCoreApplication.getInst().isRecAppExist() && !com.baidu.tieba.funad.a.cPq()) {
                    this.jeH.addRecommendAppToThreadList(this);
                }
                if (!this.jfi.cGz().r(bz.eTk)) {
                    this.jeH.removeAlaLiveThreadData();
                }
                this.jeH.addSchoolRecommendToThreadList();
            }
            if (!this.jfi.cGz().r(bz.eTk)) {
                this.jeH.removeAlaInsertLiveData();
                this.jeH.removeAlaStageLiveDat();
            } else {
                this.jeH.addInsertLiveDataToThreadList();
                this.jeH.addStageLiveDataToThreadList();
            }
            this.jeH.checkLiveStageInThreadList();
            this.jeH.addNoticeThreadToThreadList();
            if (this.jfi.cGz().r(com.baidu.tieba.i.b.jRf)) {
                this.jeH.addGameRankListToThreadList(z2);
            }
            if (TbadkCoreApplication.isLogin() && (!this.jfA.cMo() || this.jfA.isNetFirstLoad)) {
                this.jeH.addUserRecommendToThreadList();
            }
            this.jeH.addVideoActivityToTop();
        }
    }

    public boolean cFm() {
        if (this.jfB != null && this.jfA != null) {
            this.jfB.a(this.jfA.getPageType(), this.jeH);
        }
        boolean z = false;
        if (this.jeH != null) {
            z = this.jeH.hasTab();
        }
        cFp();
        if (this.jfi != null) {
            this.jfi.cGL();
            this.jfi.cGM();
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zT(int i) {
        ax axVar = null;
        cFm();
        cFz();
        try {
            if (this.jeH != null) {
                this.jfi.a((ArrayList<com.baidu.adp.widget.ListView.n>) null, this.jeH);
                this.jfB.BU(1);
                this.jfi.cGp();
                this.jfC.a(this.jeH, this.jfA.cMj());
                com.baidu.tieba.frs.tab.d Cd = this.jfC.Cd(this.jeH.getFrsDefaultTabId());
                if (Cd != null && !TextUtils.isEmpty(Cd.url)) {
                    axVar = new ax();
                    axVar.ext = Cd.url;
                    axVar.stType = Cd.name;
                }
                this.jfA.a(this.jeH.getFrsDefaultTabId(), 0, axVar);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(boolean z, boolean z2) {
        try {
            if (this.jeH != null && this.jfC != null && this.jfA != null) {
                if (!this.jfi.cGz().r(bz.eTk)) {
                    this.jeH.removeAlaLiveThreadData();
                }
                boolean isEmpty = com.baidu.tbadk.core.util.x.isEmpty(this.jeH.getGameTabInfo());
                this.jfi.qx(isEmpty);
                if (!isEmpty) {
                    if (this.jfU == null) {
                        this.jfU = new com.baidu.tieba.frs.vc.e(this, (NoPressedRelativeLayout) this.mRootView);
                    }
                    if (this.gXD == null) {
                        this.gXD = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
                    }
                } else {
                    this.jfU = null;
                    this.gXD = null;
                }
                if (this.jeH.getForum() != null) {
                    this.jfa = this.jeH.getForum().getName();
                    this.forumId = this.jeH.getForum().getId();
                }
                if (this.jeH.hasTab()) {
                    this.jfC.a(this.jeH, this.jfA.cMj());
                }
                if (z) {
                    Y(true, z);
                } else {
                    Y(this.jfv, z);
                }
                cFm();
                if (this.jfI != null) {
                    this.jfI.a(this.jfB, this.jeH);
                }
                if (this.jeH.getPage() != null) {
                    setHasMore(this.jeH.getPage().bqf());
                }
                ArrayList<com.baidu.adp.widget.ListView.n> a2 = this.jfL.a(z2, true, this.jeH.getThreadList(), null, z, false);
                if (a2 != null) {
                    this.jeH.setThreadList(a2);
                }
                this.jeH.removeRedundantUserRecommendData();
                this.jeJ = this.jeH.getTopThreadSize();
                if (this.jfe != null) {
                    this.jfd = true;
                    this.jfe.KN(this.jeJ);
                    com.baidu.tieba.frs.d.a.a(this, this.jeH.getForum(), this.jeH.getThreadList(), this.jfd, getPn());
                }
                if (this.jfA.cMe() == 1) {
                    cFt();
                    if (!z && this.jfA.getPn() == 1) {
                        cFo();
                    }
                }
                if (this.jfJ != null) {
                    this.jfJ.dd(this.jfC.cOp());
                }
                cFc();
                this.jfi.cGh();
                this.jfi.aa(true, false);
                if (z && this.jeH.isFirstTabEqualAllThread()) {
                    com.baidu.adp.lib.f.e.mB().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.25
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!FrsFragment.this.jft && com.baidu.adp.lib.util.j.isNetWorkAvailable() && !FrsFragment.this.jfi.cGO()) {
                                FrsFragment.this.jfi.cGJ();
                            }
                        }
                    });
                }
                if (this.jeH.getForum() != null) {
                    this.jfi.KI(this.jeH.getForum().getWarningMsg());
                }
                if (this.jeH != null && this.jeH.getFrsVideoActivityData() != null && com.baidu.tbadk.core.sharedPref.b.bvq().getLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 0L) == 0) {
                    com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.26
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsFragment.this.jfi.cGH();
                        }
                    }, 1000L);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FRS_SHOW_AR_ENTRY, this));
                this.jfi.cGb();
                if (this.jeH != null && this.jeH.getForum() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ENTER_FORUM, new VisitedForumData(this.jeH.getForum().getId(), this.jeH.getForum().getName(), this.jeH.getForum().getImage_url(), String.valueOf(System.currentTimeMillis() / 1000), ConstantData.Forum.SPECAIL_FORUM_TYPE_LIVE.equals(this.jeH.getForum().special_forum_type), this.jeH.getForum().getThemeColorInfo(), this.jeH.getForum().getMember_num())));
                }
                this.jfY.a(this.jeH.bottomMenuList, this.jeH.getForum());
                cFO();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void cFn() {
        if (this.jfA != null && this.jfA.cMe() == 1) {
            this.jfB.k(this.jeH);
        }
    }

    public void qo(boolean z) {
        com.baidu.tieba.s.c.dNX().b(getUniqueId(), z);
    }

    public void cFo() {
        if (this.jfO == null) {
            this.jfO = new com.baidu.tieba.frs.live.a(this, com.baidu.adp.lib.f.b.toInt(this.forumId, 0));
        }
        this.jfO.cLL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.tbadkCore.m mVar) {
        try {
            if (!this.jft && mVar != null && this.jeH != null) {
                this.jeH.receiveData(mVar);
                Z(true, false);
                Looper.myQueue().addIdleHandler(this.jgo);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void cFp() {
        if (this.jfA != null) {
            KF(this.jfA.getPageType());
        } else {
            KF("normal_page");
        }
    }

    private void KF(String str) {
        qp("frs_page".equals(str));
        if (this.jfI != null) {
            this.jfI.a(this.jfB, this.jfi, this.jeH);
        }
    }

    public void qp(boolean z) {
        if (this.jfM != null) {
            this.jfM.cNZ();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.s.c.dNX().z(getUniqueId());
        registerResponsedEventListener(TopToastEvent.class, this.mTopToastEventListener);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.frs_activity, viewGroup, false);
            this.jeU = new com.baidu.tieba.frs.entelechy.a();
            this.jfI = this.jeU.cIw();
            this.jeT = TbadkCoreApplication.getInst().getString(R.string.frs_title_new_area);
            this.jfB = new com.baidu.tieba.frs.vc.h(this, this.jeU, (FrsHeaderViewContainer) this.mRootView.findViewById(R.id.header_view_container));
            this.jfC = new FrsTabViewController(this, this.mRootView);
            this.jfC.registerListener();
            this.jfB.a(this.jfC);
            this.jfC.a(this.jgw);
            Intent intent = getActivity().getIntent();
            if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                this.jeW = true;
            }
            this.jfi = new q(this, this.jgS, this.jeU, this.jeW, this.jfB);
            this.jfY = new com.baidu.tieba.frs.brand.buttommenu.a(getPageContext(), this.mRootView);
        } else {
            if (this.mRootView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            if (this.jfC != null) {
                this.jfC.registerListener();
            }
            this.jfi.cGG();
            this.mRootView.setLeft(0);
            this.mRootView.setRight(com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getContext()));
        }
        this.jgc = true;
        this.fLI = System.currentTimeMillis() - currentTimeMillis;
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        ArrayList<com.baidu.adp.widget.ListView.n> arrayList = null;
        this.iHN = System.currentTimeMillis();
        long j = this.iHN;
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.jff = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.iHN = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            S(intent);
        }
        this.fLH = j - this.iHN;
        this.jfe = new com.baidu.tieba.tbadkCore.data.f("frs", com.baidu.tieba.tbadkCore.data.f.nqQ);
        if (this.jfA == null) {
            this.jfA = new FrsModelController(this, this.jgN);
            this.jfA.a(this.jgv);
            this.jfA.init();
        }
        this.jfA.setSchemeUrl(this.mSchemeUrl);
        if (intent != null) {
            this.jfA.aj(intent.getExtras());
        } else if (bundle != null) {
            this.jfA.aj(bundle);
        } else {
            this.jfA.aj(null);
        }
        if (intent != null) {
            this.jfB.as(intent.getExtras());
        } else if (bundle != null) {
            this.jfB.as(bundle);
        } else {
            this.jfB.as(null);
        }
        this.jfh = getVoiceManager();
        this.jfP = new p(getPageContext(), this);
        initUI();
        initData(bundle);
        if (!cFH()) {
            this.jfG = new at(getActivity(), this.jfi, this.jfB);
            this.jfG.qM(true);
        }
        this.jfh = getVoiceManager();
        if (this.jfh != null) {
            this.jfh.onCreate(getPageContext());
        }
        if (FrsActivityConfig.FRS_FROM_FLUTTER_BCASTEDIT.equals(getFrom()) && !this.hasInit) {
            int i = com.baidu.tbadk.core.sharedPref.b.bvq().getInt("key_forum_broadcast_edit_tip_number", 0);
            if (i < 2) {
                com.baidu.tbadk.core.sharedPref.b.bvq().putInt("key_forum_broadcast_edit_tip_number", i + 1);
                cFv();
            } else if (Build.VERSION.SDK_INT >= 23) {
                if (Settings.canDrawOverlays(getContext())) {
                    cFw();
                } else {
                    new BdTopToast(getContext()).yW(false).UY(getContext().getString(R.string.forum_broadcast_copy_no_permission_hint)).aR(this.jfi.cqg());
                }
            } else {
                cFw();
            }
        }
        if (FrsActivityConfig.FRS_FROM_FORUM_RULE_EDIT.equals(getFrom()) && !this.hasInit) {
            if (Build.VERSION.SDK_INT >= 23) {
                if (Settings.canDrawOverlays(getContext())) {
                    cFx();
                } else if (Build.VERSION.SDK_INT < 23 || !com.baidu.tbadk.core.sharedPref.b.bvq().getBoolean("key_forum_rule_dialog_show_frs", false)) {
                    cFx();
                    com.baidu.tbadk.core.sharedPref.b.bvq().putBoolean("key_forum_rule_dialog_show_frs", true);
                }
            } else {
                cFx();
            }
        }
        if (com.baidu.tbadk.k.d.bGb().bGc()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
            if (this.jfj != null) {
                this.jfj.setVisibility(8);
            }
        }
        new com.baidu.tieba.frs.mc.i();
        int i2 = -1;
        if (this.jfL != null && this.jfL.cLW() != null) {
            i2 = this.jfL.cLW().cFa();
            arrayList = this.jfL.cLW().getDataList();
        }
        this.jfL = new com.baidu.tieba.frs.mc.c(this, this.jgQ);
        this.jfL.cLW().setHasMore(i2);
        if (arrayList != null && arrayList.size() > 0) {
            this.jfL.cLW().aI(arrayList);
        }
        this.jfE = new com.baidu.tieba.frs.smartsort.a(this);
        this.jfM = new com.baidu.tieba.frs.vc.j(this);
        this.jfJ = new com.baidu.tieba.frs.vc.a(getPageContext(), this.jfA.cMl());
        this.jfF = new com.baidu.tieba.frs.mc.b(this);
        this.jfK = new com.baidu.tieba.frs.mc.d(this);
        this.jfD = new com.baidu.tieba.frs.mc.h(this);
        this.jfN = new com.baidu.tieba.frs.mc.a(this);
        this.jfQ = new com.baidu.tieba.frs.vc.c(this);
        this.jfR = new com.baidu.tieba.frs.mc.e(this, getUniqueId());
        this.jfW = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "frs");
        this.jfX = new com.baidu.tieba.ala.b(getPageContext());
        this.jfZ = new com.baidu.tieba.frs.sportspage.notification.a(getPageContext());
        registerListener(this.jgE);
        registerListener(this.mMemListener);
        registerListener(this.jgC);
        registerListener(this.jgR);
        registerListener(this.jgO);
        registerListener(this.jgy);
        registerListener(this.jgz);
        registerListener(this.jgA);
        registerListener(this.jgB);
        registerListener(this.jgp);
        registerListener(this.jgq);
        registerListener(this.aip);
        registerListener(this.jgr);
        registerListener(this.jgW);
        registerListener(this.jgG);
        this.jgH.setSelfListener(true);
        this.jgH.setTag(getPageContext().getUniqueId());
        registerListener(this.jgH);
        registerListener(this.jgu);
        registerListener(this.jgI);
        registerListener(this.jgF);
        registerListener(this.jgK);
        registerListener(this.jgL);
        registerListener(this.jgM);
        this.jgX.setTag(getPageContext().getUniqueId());
        MessageManager.getInstance().registerListener(this.jgX);
        registerListener(this.jgY);
        registerListener(this.jgZ);
        registerListener(this.jha);
        registerListener(this.jgt);
        registerListener(this.jhb);
        registerListener(this.jgJ);
        registerListener(this.jgs);
        registerListener(this.jhc);
        registerListener(this.jhd);
        registerListener(this.jhe);
        registerListener(this.jhf);
        this.jfi.qz(false);
        if (!cFH() && !this.hasInit) {
            showLoadingView(this.jfi.cqg(), true);
            this.jfA.T(3, false);
        }
        av avVar = new av() { // from class: com.baidu.tieba.frs.FrsFragment.29
            @Override // com.baidu.tieba.frs.av
            public void e(boolean z, boolean z2, int i3) {
                if (FrsFragment.this.jfi != null) {
                    if (i3 == 1) {
                        FrsFragment.this.jfi.Ae(z ? 0 : 8);
                    } else if (i3 == 2) {
                        FrsFragment.this.jfi.Ag(z ? 0 : 8);
                    }
                    if (!z2) {
                        FrsFragment.this.jgb = z;
                    }
                    if (FrsFragment.this.jfi.cGz() != null && (i3 == 2 || (FrsFragment.this.jfA != null && FrsFragment.this.jfA.cMf()))) {
                        FrsFragment.this.jfi.cGz().notifyDataSetChanged();
                    }
                    if (FrsFragment.this.cEX() != null) {
                        FrsTabViewController.b cOq = FrsFragment.this.cEX().cOq();
                        if (cOq != null) {
                            if ((cOq.fragment instanceof FrsCommonTabFragment) && (i3 == 2 || cOq.tabId == 502)) {
                                ((FrsCommonTabFragment) cOq.fragment).cIl();
                            } else if ((cOq.fragment instanceof FrsNewAreaFragment) && (i3 == 2 || cOq.tabId == 503)) {
                                FrsNewAreaFragment frsNewAreaFragment = (FrsNewAreaFragment) cOq.fragment;
                                frsNewAreaFragment.cIl();
                                if (frsNewAreaFragment.cMw() != null) {
                                    com.baidu.tieba.frs.mc.g cMw = frsNewAreaFragment.cMw();
                                    cMw.qO(!z);
                                    if (i3 == 1) {
                                        cMw.qC(!z);
                                    } else if (i3 == 2) {
                                        cMw.qC(true);
                                    }
                                }
                            } else if (cOq.fragment instanceof FrsGoodFragment) {
                                ((FrsGoodFragment) cOq.fragment).cIl();
                            }
                        }
                        if (FrsFragment.this.cEX().cOh() != null) {
                            FrsFragment.this.cEX().cOh().setmDisallowSlip(z);
                            FrsFragment.this.cEX().ry(z);
                        }
                    }
                    if (FrsFragment.this.jfi.cGf() != null) {
                        FrsFragment.this.jfi.qw(!z);
                    }
                    if (FrsFragment.this.getActivity() instanceof FrsActivity) {
                        ((FrsActivity) FrsFragment.this.getActivity()).qm(!z);
                    }
                    if (FrsFragment.this.jfY != null) {
                        FrsFragment.this.jfY.qU(!z);
                    }
                    FrsFragment.this.jfi.qB(!z);
                    if (i3 == 1) {
                        FrsFragment.this.jfi.qC(z ? false : true);
                    } else if (i3 == 2) {
                        FrsFragment.this.jfi.qC(true);
                    }
                }
            }

            @Override // com.baidu.tieba.frs.av
            public void co(int i3, int i4) {
                if (FrsFragment.this.jfi != null) {
                    if (i4 == 1) {
                        FrsFragment.this.jfi.Af(i3);
                    } else if (i4 == 2) {
                        FrsFragment.this.jfi.Ah(i3);
                    }
                }
            }

            @Override // com.baidu.tieba.frs.av
            public void zX(int i3) {
                if (FrsFragment.this.getContext() != null) {
                    if (i3 == 1) {
                        com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getContext(), R.string.frs_multi_delete_max_num);
                    } else if (i3 == 2 && FrsFragment.this.jfi != null) {
                        new BdTopToast(FrsFragment.this.getContext()).yW(false).UY(FrsFragment.this.getContext().getString(R.string.frs_move_area_max_num)).aR(FrsFragment.this.jfi.cqg());
                    }
                }
            }
        };
        b.cDX().a(avVar);
        com.baidu.tieba.frs.a.cDQ().a(avVar);
        this.jfi.b(new e.a() { // from class: com.baidu.tieba.frs.FrsFragment.30
            @Override // com.baidu.tieba.NEGFeedBack.e.a
            public void a(DeleteThreadHttpResponseMessage deleteThreadHttpResponseMessage) {
                boolean z;
                int i3 = 0;
                if (deleteThreadHttpResponseMessage != null) {
                    FrsFragment.this.jfi.bNI();
                    FrsFragment.this.jfi.cGI();
                    FrsNewAreaFragment frsNewAreaFragment = null;
                    if (FrsFragment.this.jfC == null || FrsFragment.this.jfC.cOq() == null || !(FrsFragment.this.jfC.cOq().fragment instanceof FrsNewAreaFragment)) {
                        z = false;
                    } else {
                        frsNewAreaFragment = (FrsNewAreaFragment) FrsFragment.this.jfC.cOq().fragment;
                        z = true;
                    }
                    if (deleteThreadHttpResponseMessage.getError() == 0) {
                        String text = !TextUtils.isEmpty(deleteThreadHttpResponseMessage.getText()) ? deleteThreadHttpResponseMessage.getText() : FrsFragment.this.getString(R.string.delete_fail);
                        if (deleteThreadHttpResponseMessage.getRetType() == 1211066) {
                            if (FrsFragment.this.iyl == null) {
                                FrsFragment.this.iyl = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.iyl.Bp(text);
                            FrsFragment.this.iyl.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.30.1
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.iyl.jI(false);
                            FrsFragment.this.iyl.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.iyl.btX();
                        } else if (deleteThreadHttpResponseMessage.getRetType() == 1211067) {
                            if (FrsFragment.this.iyl == null) {
                                FrsFragment.this.iyl = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.iyl.Bp(text);
                            FrsFragment.this.iyl.a(R.string.know, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.30.2
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.iyl.jI(false);
                            FrsFragment.this.iyl.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.iyl.btX();
                        } else {
                            FrsFragment.this.jfi.aX(deleteThreadHttpResponseMessage.getText(), ContextCompat.getColor(FrsFragment.this.getContext(), deleteThreadHttpResponseMessage.getRetType() == 1 ? R.color.nav_bar_tip_error : R.color.cp_link_tip_a_alpha95));
                        }
                        if (z && frsNewAreaFragment != null) {
                            frsNewAreaFragment.dG(deleteThreadHttpResponseMessage.getSuccessItems());
                        }
                        FrsFragment.this.m38do(deleteThreadHttpResponseMessage.getSuccessItems());
                        b.cDX().dn(deleteThreadHttpResponseMessage.getSuccessItems());
                        for (com.baidu.adp.widget.ListView.n nVar : FrsFragment.this.jeH.getThreadList()) {
                            if (nVar instanceof by) {
                                i3++;
                                continue;
                            }
                            if (i3 >= 6) {
                                break;
                            }
                        }
                        if (i3 < 6) {
                            FrsFragment.this.bUp();
                            return;
                        }
                        return;
                    }
                    com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getActivity(), deleteThreadHttpResponseMessage.getErrorString());
                }
            }
        });
        this.dXO = UtilHelper.getScreenHeight(getActivity());
        this.hasInit = true;
        zU(1);
        super.onActivityCreated(bundle);
        this.createTime = System.currentTimeMillis() - j;
    }

    public void qq(boolean z) {
        if (this.jfC != null) {
            this.jfC.jKI = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: do  reason: not valid java name */
    public void m38do(List<String> list) {
        if (!com.baidu.tbadk.core.util.x.isEmpty(list)) {
            ArrayList<com.baidu.adp.widget.ListView.n> threadList = this.jeH.getThreadList();
            if (!com.baidu.tbadk.core.util.x.isEmpty(threadList) && this.jfi.getListView() != null && this.jfi.getListView().getData() != null) {
                Iterator<com.baidu.adp.widget.ListView.n> it = threadList.iterator();
                List<com.baidu.adp.widget.ListView.n> data = this.jfi.getListView().getData();
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.n next = it.next();
                    if (next instanceof by) {
                        bz bzVar = ((by) next).eMv;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= list.size()) {
                                break;
                            } else if (!com.baidu.tbadk.core.util.at.equals(list.get(i2), bzVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.jfL.d(next);
                                this.jfi.getListView().getAdapter().notifyItemRemoved(i);
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
    public void cDV() {
        if (!com.baidu.tbadk.core.util.x.isEmpty(com.baidu.tieba.frs.a.cDQ().cDU()) && this.jfi.getListView() != null && this.jfi.getListView().getData() != null) {
            ArrayList<com.baidu.adp.widget.ListView.n> threadList = this.jeH.getThreadList();
            if (!com.baidu.tbadk.core.util.x.isEmpty(threadList)) {
                Iterator<com.baidu.adp.widget.ListView.n> it = threadList.iterator();
                List<com.baidu.adp.widget.ListView.n> data = this.jfi.getListView().getData();
                int count = com.baidu.tbadk.core.util.x.getCount(com.baidu.tieba.frs.a.cDQ().cDU());
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.n next = it.next();
                    if (next instanceof by) {
                        bz bzVar = ((by) next).eMv;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= count) {
                                break;
                            } else if (!com.baidu.tbadk.core.util.at.equals(com.baidu.tieba.frs.a.cDQ().cDU().get(i2).getId(), bzVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.jfL.d(next);
                                this.jfi.getListView().getAdapter().notifyItemRemoved(i);
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
    public void bUJ() {
        if (isAdded() && this.gEY && !isLoadingViewAttached()) {
            showLoadingView(this.jfi.cqg(), true);
        }
    }

    @Override // com.baidu.tieba.frs.am
    public void bUK() {
        if (isAdded() && this.gEY && isLoadingViewAttached()) {
            hideLoadingView(this.jfi.cqg());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (cFH()) {
            showLoadingView(this.jfi.cqg(), true);
            this.jfi.Ai(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.jfA.S(3, true);
            getListView().scrollToPosition(0);
        }
    }

    private void zU(int i) {
        String str = "";
        if (this.jeH != null && this.jeH.getForum() != null) {
            str = this.jeH.getForum().getId();
        }
        if (!StringUtils.isNull(str)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13008").dX("fid", str).dX("obj_type", "4").an("obj_locate", i).dX("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    @Override // com.baidu.tieba.frs.am
    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.y yVar) {
        if (yVar != null) {
            this.fPF = yVar.bJd();
            this.jfS = yVar.bJe();
        }
    }

    @Override // com.baidu.tieba.frs.am
    public void showFloatingView() {
        if (this.fPF != null) {
            this.fPF.ld(true);
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
                this.jfa = uri.getQueryParameter("name");
                this.mFrom = uri.getQueryParameter("from");
                if (!StringUtils.isNull(this.jfa)) {
                    intent.putExtra("name", this.jfa);
                }
                if (!StringUtils.isNull(this.mFrom)) {
                    intent.putExtra("from", this.mFrom);
                }
                TiebaStatic.log(TbadkCoreStatisticKey.AS_INVOKE_TIEBA);
            }
            if (StringUtils.isNull(this.jfa) && uri != null) {
                if (com.baidu.tbadk.BdToken.f.r(uri)) {
                    com.baidu.tbadk.BdToken.f.bln().b(uri, this.jgP);
                } else {
                    com.baidu.tieba.frs.d.g V = com.baidu.tieba.frs.d.l.V(intent);
                    if (V != null) {
                        this.jfa = V.forumName;
                        if (V.jIm == null || V.jIm.equals("aidou")) {
                        }
                    }
                }
                if (!StringUtils.isNull(this.jfa)) {
                    intent.putExtra("name", this.jfa);
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
                if (hashMap.get(com.baidu.tbadk.BdToken.f.eGr) instanceof String) {
                    FrsFragment.this.jfa = (String) hashMap.get(com.baidu.tbadk.BdToken.f.eGr);
                }
                if ((hashMap.get(com.baidu.tbadk.BdToken.f.eGJ) instanceof String) && !TextUtils.isEmpty((String) hashMap.get(com.baidu.tbadk.BdToken.f.eGJ))) {
                    com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.31.1
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsFragment.this.jfC.uu(301);
                            final long j = com.baidu.adp.lib.f.b.toLong((String) hashMap.get(com.baidu.tbadk.BdToken.f.eGs), 0L);
                            final int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
                            final int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
                            final float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                            final int i = 1;
                            if (com.baidu.tbadk.core.util.au.bwr().bws()) {
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
        this.jfh = getVoiceManager();
        if (this.jfh != null) {
            this.jfh.onStart(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        Intent intent;
        long j = 0;
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.fvn);
        if (bundle != null) {
            this.jfa = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            j = bundle.getLong(FrsActivityConfig.FRS_FAKE_THREAD_ID, 0L);
        } else if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
            this.jfa = intent.getStringExtra("name");
            this.mFrom = intent.getStringExtra("from");
            this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
            j = intent.getLongExtra(FrsActivityConfig.FRS_FAKE_THREAD_ID, 0L);
        }
        if (getArguments() != null) {
            this.jfb = getArguments().getBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, false);
        }
        if (TextUtils.isEmpty(this.mFrom) || FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
        }
        if (this.mIsLogin) {
            registerListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL, this.fvn);
        }
        this.jfB.as(bundle);
        gl(j);
    }

    private void gl(final long j) {
        if (j > 0) {
            final int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
            final int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
            final float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            final int i = 1;
            if (com.baidu.tbadk.core.util.au.bwr().bws()) {
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
        com.baidu.tieba.s.c.dNX().A(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.jgW);
        MessageManager.getInstance().unRegisterListener(this.jgH);
        unRegisterResponsedEventListener();
        this.jfM.destroy();
        jfm = null;
        if (this.jfh != null) {
            this.jfh.onDestory(getPageContext());
        }
        com.baidu.tieba.recapp.report.a.remove("FRS");
        this.jfh = null;
        com.baidu.tieba.card.s.cva().pv(false);
        if (this.jeH != null && this.jeH.getForum() != null) {
            ag.cHj().gm(com.baidu.adp.lib.f.b.toLong(this.jeH.getForum().getId(), 0L));
        }
        if (this.jfO != null) {
            this.jfO.onDestory();
        }
        if (this.jfi != null) {
            com.baidu.tieba.frs.d.k.a(this.jfi, this.jeH, getForumId(), false, null);
            this.jfi.onDestroy();
        }
        if (this.jfl != null) {
            this.jfl.removeAllViews();
            this.jfl.setVisibility(8);
        }
        if (this.jgi != null) {
            this.jgi.cancel();
        }
        if (this.jgj != null) {
            com.baidu.adp.lib.f.e.mB().removeCallbacks(this.jgj);
        }
        this.jgh = null;
        super.onDestroy();
        try {
            if (this.jfu != null) {
                this.jfu.bHz();
            }
            if (this.jfi != null) {
                this.jfi.release();
            }
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.jfB.cLD();
        Looper.myQueue().removeIdleHandler(this.jgo);
        if (this.jfA != null) {
            this.jfA.cbG();
        }
        if (this.jfG != null) {
            this.jfG.cHr();
        }
        if (this.jfJ != null) {
            this.jfJ.destory();
        }
        if (this.jfE != null) {
            this.jfE.onDestroy();
        }
        if (this.jfU != null) {
            this.jfU.onDestory();
        }
        if (this.jfN != null) {
            this.jfN.onDestroy();
        }
        if (this.jfW != null) {
            this.jfW.onDestroy();
        }
        if (this.jfX != null) {
            this.jfX.onDestroy();
        }
        com.baidu.tieba.recapp.c.a.dFN().dFQ();
        com.baidu.tieba.frs.d.m.cNh();
        if (this.jfC != null) {
            this.jfC.a((FrsTabViewController.a) null);
            this.jfC.cOs();
        }
        if (this.jga != null) {
            this.jga.onDestroy();
        }
        b.cDX().a(null);
        com.baidu.tieba.frs.a.cDQ().a(null);
        if (this.jgn != null) {
            this.jgn.cNf();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.jfa);
        bundle.putString("from", this.mFrom);
        this.jfA.onSaveInstanceState(bundle);
        if (this.jfh != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            this.jfh.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.jfN != null) {
            this.jfN.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.jfi != null) {
            this.jfi.cGm();
            this.jfi.onResume();
        }
        this.jfD.rp(true);
        this.jfv = true;
        if (jeZ) {
            jeZ = false;
            if (this.jfi != null) {
                this.jfi.startPullRefresh();
                return;
            }
            return;
        }
        if (this.jfh != null) {
            this.jfh.onResume(getPageContext());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_RESUME));
        if (this.jfi != null) {
            this.jfi.qD(false);
        }
        if (this.jfV) {
            refresh(6);
            this.jfV = false;
        }
        if (this.jge != null && getActivity() != null) {
            if (NotificationManagerCompat.from(getActivity()).areNotificationsEnabled()) {
                com.baidu.tbadk.coreExtra.messageCenter.f.bCb().setSignAlertOn(true);
                com.baidu.tbadk.coreExtra.messageCenter.f.bCb().setSignAlertTime(this.jge.getHours(), this.jge.getMinutes());
                if (this.jfi != null) {
                    com.baidu.tbadk.coreExtra.messageCenter.f.bCb().a(getTbPageContext().getPageActivity(), this.jfi.cqg());
                }
            }
            this.jge = null;
        }
        cFO();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
    }

    public boolean cFq() {
        Intent intent;
        if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
            return false;
        }
        return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
    }

    public void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.jfa = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.jfc = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.jfc) {
                cFr();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFr() {
        this.jfi.startPullRefresh();
    }

    public void closeActivity() {
        com.baidu.tieba.frs.d.l.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.mFrom);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.jfi.setTitle(this.jfa);
        } else {
            this.jfi.setTitle("");
            this.mFlag = 1;
        }
        this.jfi.a(this.jgU);
        this.jfi.addOnScrollListener(this.mScrollListener);
        this.jfi.g(this.jct);
        this.jfi.cGz().a(this.jgT);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jgc) {
            this.jfi.onChangeSkinType(i);
            this.jfB.BT(i);
            this.jfC.onChangeSkinType(i);
            if (this.jfk != null) {
                this.jfk.onChangeSkinType(i);
            }
            if (this.jfT != null) {
                this.jfT.onChangeSkinType();
            }
            if (this.jfY != null) {
                this.jfY.onChangeSkinType(getPageContext(), i);
            }
            if (this.iyl != null) {
                com.baidu.tbadk.r.a.a(getPageContext(), this.iyl.getRealView());
            }
            if (this.jfU != null) {
                this.jfU.onChangeSkinType(getPageContext(), i);
            }
        }
    }

    public void zV(int i) {
        if (!this.mIsLogin) {
            if (this.jeH != null && this.jeH.getAnti() != null) {
                this.jeH.getAnti().setIfpost(1);
            }
            if (i == 0) {
                bg.skipToLoginActivity(getActivity());
            }
        } else if (this.jeH != null) {
            if (i == 0) {
                com.baidu.tieba.frs.d.m.g(this, 0);
            } else {
                this.jfi.cGo();
            }
        }
    }

    public void refresh() {
        com.baidu.tieba.a.d.bOm().Fl("page_frs");
        refresh(3);
    }

    public void refresh(int i) {
        this.jft = false;
        cFz();
        if (this.jfi != null && this.jfi.cGd() != null) {
            this.jfi.cGd().cSo();
        }
        if (this.jfA != null) {
            this.jfA.S(i, true);
        }
    }

    private void cFs() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.f.h.mC().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.37
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.TF(FrsFragment.this.jfa);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFt() {
        cFz();
        try {
            if (this.jeH != null) {
                this.jfi.caY();
                this.jfi.qw(cFN());
                if (!com.baidu.tieba.frs.vc.h.n(this.jeH) || !com.baidu.tieba.frs.vc.h.m(this.jeH)) {
                }
                if (this.jeH.getForum() != null) {
                    this.jfa = this.jeH.getForum().getName();
                    this.forumId = this.jeH.getForum().getId();
                }
                if (this.jeH.getPage() != null) {
                    setHasMore(this.jeH.getPage().bqf());
                }
                this.jfi.setTitle(this.jfa);
                this.jfi.setForumName(this.jfa);
                TbadkCoreApplication.getInst().setDefaultBubble(this.jeH.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.jeH.getUserData().getBimg_end_time());
                cFs();
                cFu();
                ArrayList<com.baidu.adp.widget.ListView.n> threadList = this.jeH.getThreadList();
                if (threadList != null) {
                    this.jfi.a(threadList, this.jeH);
                    com.baidu.tieba.frs.d.c.A(this.jfi);
                    this.jfB.BU(getPageNum());
                    this.jfB.j(this.jeH);
                    this.jfC.a(this.jeH, this.jfA.cMj());
                    this.jfi.cGp();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void cFu() {
        if (this.jeH != null) {
            if (this.jeH.getIsNewUrl() == 1) {
                this.jfi.cGz().setFromCDN(true);
            } else {
                this.jfi.cGz().setFromCDN(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.jfD.rp(false);
        this.jfv = false;
        this.jfi.onPause();
        if (this.jfh != null) {
            this.jfh.onPause(getPageContext());
        }
        this.jfi.qD(true);
        if (this.jfJ != null) {
            this.jfJ.cNk();
        }
        com.baidu.tbadk.BdToken.c.bkT().ble();
        if (this.jgn != null) {
            this.jgn.cNf();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.jfC != null && this.jfC.cOq() != null && (this.jfC.cOq().fragment instanceof BaseFragment)) {
            ((BaseFragment) this.jfC.cOq().fragment).setPrimary(z);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.s.cva().pv(false);
        qo(false);
        if (this.jeH != null && this.jeH.getForum() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            com.baidu.tbadk.distribute.a.bEv().b(getPageContext().getPageActivity(), "frs", this.jeH.getForum().getId(), 0L);
        }
        if (this.jfh != null) {
            this.jfh.onStop(getPageContext());
        }
        if (getListView() != null) {
            getListView().getRecycledViewPool().clear();
        }
        this.jfB.bxw();
        com.baidu.tbadk.util.z.bJg();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            if (this.jfB != null) {
                this.jfB.ca(isPrimary());
            }
            if (this.jfi != null) {
                this.jfi.ca(isPrimary());
                this.jfi.qD(!isPrimary());
            }
        }
    }

    private void cFv() {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.pd(2);
        aVar.jI(false);
        FrsBroadcastCopyGuideDialogView frsBroadcastCopyGuideDialogView = new FrsBroadcastCopyGuideDialogView(getPageContext().getPageActivity());
        frsBroadcastCopyGuideDialogView.setConfirmButtonListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.38
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aVar != null) {
                    aVar.dismiss();
                    FrsFragment.this.cFw();
                }
            }
        });
        aVar.br(frsBroadcastCopyGuideDialogView);
        aVar.b(getPageContext()).btX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFw() {
        com.baidu.tbadk.k.d.bGb().a(new com.baidu.tbadk.k.a(getContext()));
        com.baidu.tbadk.k.d.bGb().C(85, 0, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds144));
        if (com.baidu.tbadk.k.d.bGb().init()) {
            ((BaseFragmentActivity) getPageContext().getOrignalPage()).grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.frs.FrsFragment.39
                @Override // com.baidu.tbadk.core.e
                public void onPermissionResult(boolean z) {
                    if (!z) {
                        new BdTopToast(FrsFragment.this.getContext()).yW(false).UY(FrsFragment.this.getContext().getString(R.string.forum_broadcast_copy_no_permission_hint)).aR(FrsFragment.this.jfi.cqg());
                        return;
                    }
                    com.baidu.tbadk.k.d.bGb().ld(true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                    if (FrsFragment.this.jfj != null) {
                        FrsFragment.this.jfj.setVisibility(8);
                    }
                }
            }, true);
        }
    }

    private void cFx() {
        com.baidu.tbadk.k.d.bGb().a(new com.baidu.tbadk.k.b(getContext()));
        com.baidu.tbadk.k.d.bGb().C(85, 0, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds144));
        if (com.baidu.tbadk.k.d.bGb().init()) {
            ((BaseFragmentActivity) getPageContext().getOrignalPage()).grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.frs.FrsFragment.40
                @Override // com.baidu.tbadk.core.e
                public void onPermissionResult(boolean z) {
                    if (z) {
                        com.baidu.tbadk.k.d.bGb().ld(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                        if (FrsFragment.this.jfj != null) {
                            FrsFragment.this.jfj.setVisibility(8);
                        }
                    }
                }
            }, true);
        }
    }

    public void KG(String str) {
        new BdTopToast(getContext(), 3000).yW(true).UY(str).aR(this.jfi.cqg());
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (b.cDX().cDR()) {
                b.cDX().reset();
                return true;
            } else if (com.baidu.tieba.frs.a.cDQ().cDR()) {
                if (this.jfi != null && this.jfi.cGD()) {
                    this.jfi.cGE();
                    return true;
                }
                com.baidu.tieba.frs.a.cDQ().reset();
                return true;
            } else if (this.jfi != null) {
                return this.jfi.cGl();
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
        com.baidu.tbadk.distribute.a.bEv().a(advertAppInfo, this.forumId, 0L, "FRS", str, getPn());
    }

    @Override // com.baidu.tieba.recapp.p
    public void cFy() {
        cEU().cFy();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.jfh == null) {
            this.jfh = VoiceManager.instance();
        }
        return this.jfh;
    }

    public BdRecyclerView getListView() {
        if (this.jfi == null) {
            return null;
        }
        return this.jfi.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void cFz() {
        if (this.jfh != null) {
            this.jfh.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.a
    public com.baidu.adp.lib.d.b<TbImageView> byl() {
        if (this.fof == null) {
            this.fof = UserIconBox.E(getPageContext().getPageActivity(), 8);
        }
        return this.fof;
    }

    public void cFA() {
        if (getFragmentActivity() != null && getFragmentActivity().getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.q onGetPreLoadListView() {
        return getListView().getPreLoadHandle();
    }

    @Override // com.baidu.tieba.frs.ap
    public NavigationBar bYq() {
        if (this.jfi == null) {
            return null;
        }
        return this.jfi.bYq();
    }

    public FRSRefreshButton cFB() {
        return this.jfk;
    }

    public void c(LinearLayout linearLayout) {
        if (linearLayout != null) {
            this.jfl = linearLayout;
        }
    }

    public void a(FRSRefreshButton fRSRefreshButton) {
        if (fRSRefreshButton != null) {
            this.jfk = fRSRefreshButton;
            this.jfk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.47
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (FrsFragment.this.jfC != null) {
                        FrsTabViewController.b cOq = FrsFragment.this.jfC.cOq();
                        if (cOq != null && cOq.fragment != null && (cOq.fragment instanceof ao)) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                            ((ao) cOq.fragment).cEF();
                            ((ao) cOq.fragment).bVE();
                            return;
                        }
                        FrsFragment.this.cEZ().startPullRefresh();
                    }
                }
            });
        }
    }

    public void cFC() {
        if (this.jfk != null) {
            this.jfk.hide();
        }
    }

    public void cFD() {
        if (this.jfk != null) {
            this.jfk.show();
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
                if (bdUniqueId == u.jiX) {
                    if (FrsFragment.this.jfi != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11752").dX("fid", FrsFragment.this.forumId).dX("obj_locate", "1"));
                        FrsFragment.this.jfi.startPullRefresh();
                    }
                } else if (nVar != null && (nVar instanceof by)) {
                    bz bzVar = ((by) nVar).eMv;
                    if (bzVar.bss() == null || bzVar.bss().getGroup_id() == 0 || bg.checkUpIsLogin(FrsFragment.this.getActivity())) {
                        if (bzVar.bsd() != 1 || bg.checkUpIsLogin(FrsFragment.this.getActivity())) {
                            if (bzVar.brC() != null) {
                                if (bg.checkUpIsLogin(FrsFragment.this.getActivity())) {
                                    String postUrl = bzVar.brC().getPostUrl();
                                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.isNetOk()) {
                                        com.baidu.tbadk.browser.a.startInternalWebActivity(FrsFragment.this.getActivity(), postUrl);
                                    }
                                }
                            } else if (bzVar.bsD() != null) {
                                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                    bg.skipToLoginActivity(FrsFragment.this.getPageContext().getPageActivity());
                                    return;
                                }
                                com.baidu.tbadk.core.data.s bsD = bzVar.bsD();
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), bsD.getCartoonId(), bsD.getChapterId(), 2)));
                            } else {
                                com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                                if (readThreadHistory != null && !readThreadHistory.TL(bzVar.getId())) {
                                    readThreadHistory.TK(bzVar.getId());
                                }
                                boolean z = false;
                                final String brw = bzVar.brw();
                                if (brw != null && !brw.equals("")) {
                                    z = true;
                                    new Thread(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.a.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            com.baidu.tbadk.core.util.z zVar = new com.baidu.tbadk.core.util.z(brw);
                                            zVar.bvQ().bwz().mIsNeedAddCommenParam = false;
                                            zVar.bvQ().bwz().mIsUseCurrentBDUSS = false;
                                            zVar.getNetData();
                                        }
                                    }).start();
                                }
                                String tid = bzVar.getTid();
                                if (tid == null) {
                                    tid = "";
                                }
                                if (bzVar.brl() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                    be.bwu().b(FrsFragment.this.getPageContext(), new String[]{tid, "", null});
                                    return;
                                }
                                if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && tid.length() > 4) {
                                    bzVar.setId(tid.substring(3));
                                }
                                if (bdUniqueId.getId() == bz.eUO.getId()) {
                                    com.baidu.tieba.frs.d.k.a(bzVar.bqW());
                                } else if (bdUniqueId.getId() == bz.eTo.getId()) {
                                    com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                                    aqVar.dX("obj_type", "2");
                                    aqVar.dX("tid", bzVar.getTid());
                                    TiebaStatic.log(aqVar);
                                }
                                com.baidu.tieba.frs.d.l.a(FrsFragment.this, bzVar, i, z);
                                com.baidu.tieba.frs.d.k.a(FrsFragment.this, FrsFragment.this.jeH, bzVar);
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
            hideNetRefreshView(this.jfi.cGN().cOg());
            showLoadingView(this.jfi.cqg(), true);
            this.jfi.qz(false);
            this.jfA.S(3, true);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData cFE() {
        return this.jeH;
    }

    public boolean cFF() {
        return this.jfi.cFF();
    }

    public void aK(Object obj) {
        if (this.jfF != null && this.jfF.jDF != null) {
            this.jfF.jDF.callback(obj);
        }
    }

    public void aL(Object obj) {
        if (this.jfF != null && this.jfF.jDG != null) {
            this.jfF.jDG.callback(obj);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        this.jfi.getListView().stopScroll();
        if (!this.jfi.cGv()) {
            if (!com.baidu.adp.lib.util.l.isNetOk()) {
                this.jfi.bVF();
            } else if (this.jfA.cMe() == 1) {
                bUE();
                bUp();
            } else if (this.jfA.hasMore()) {
                bUp();
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void onFailed(String str) {
        bUE();
        showToast(str);
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void az(ArrayList<com.baidu.adp.widget.ListView.n> arrayList) {
        boolean isEmpty = com.baidu.tbadk.core.util.x.isEmpty(arrayList);
        setHasMore(isEmpty ? 0 : 1);
        bUE();
        if (!isEmpty) {
            if (!this.jfA.cMo() && TbadkCoreApplication.getInst().isRecAppExist() && this.jfA.cMe() == 1 && !com.baidu.tieba.funad.a.cPq()) {
                this.jeH.addRecommendAppToThreadList(this, arrayList);
            }
            if (this.jfA != null) {
                com.baidu.tieba.frs.b.a.a(getUniqueId(), arrayList, this.jeH.getForum(), this.jfA.getSortType());
            }
            ArrayList<com.baidu.adp.widget.ListView.n> a2 = this.jfL.a(false, false, arrayList, this.jfe, false);
            if (a2 != null) {
                this.jeH.setThreadList(a2);
                this.jfi.a(a2, this.jeH);
            }
            if (this.jfA != null) {
                com.baidu.tieba.frs.b.c.a(this.jeH, this.jfA.cMj(), 2, getContext());
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.jeH.getForum()));
        }
    }

    private void bUE() {
        if (cFa() == 1 || this.jfL.dF(this.jeH.getThreadListIds())) {
            if (com.baidu.tbadk.core.util.x.getCount(this.jeH.getThreadList()) > 3) {
                this.jfi.Zg();
            } else {
                this.jfi.cGB();
            }
        } else if (com.baidu.tbadk.core.util.x.isEmpty(this.jeH.getThreadList())) {
            this.jfi.bVF();
        } else {
            this.jfi.Zh();
        }
    }

    @Override // com.baidu.tieba.frs.mc.l
    public void bUp() {
        if (this.jfL != null) {
            this.jfL.a(this.jfa, this.forumId, this.jeH);
        }
    }

    public void cFG() {
        if (!com.baidu.tbadk.core.util.ad.requestWriteExternalStorgeAndCameraPermission(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.an.g(getPageContext());
        }
    }

    @Override // androidx.fragment.app.Fragment, com.baidu.n.a.a.InterfaceC0277a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        com.baidu.tieba.frs.d.l.a(this, i, strArr, iArr);
    }

    public void qr(boolean z) {
        if (this.jfG != null) {
            this.jfG.qM(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.jfH.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a un(int i) {
        return this.jfH.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        this.jfP.b(bVar);
    }

    public boolean cFH() {
        return this.jeW;
    }

    @Override // com.baidu.tieba.frs.am
    public void WE() {
        if (this.jfi != null) {
            showFloatingView();
            this.jfi.getListView().scrollToPosition(0);
            this.jfi.startPullRefresh();
        }
    }

    public ForumWriteData cFI() {
        if (this.jeH == null || this.jeH.getForum() == null) {
            return null;
        }
        ForumData forum = this.jeH.getForum();
        ForumWriteData forumWriteData = new ForumWriteData(forum.getId(), forum.getName(), forum.getPrefixData(), this.jeH.getAnti());
        forumWriteData.avatar = forum.getImage_url();
        forumWriteData.forumLevel = forum.getUser_level();
        forumWriteData.specialForumType = forum.special_forum_type;
        forumWriteData.firstDir = forum.getFirst_class();
        forumWriteData.secondDir = forum.getSecond_class();
        UserData userData = this.jeH.getUserData();
        forumWriteData.privateThread = userData != null ? userData.getPrivateThread() : 0;
        forumWriteData.frsTabInfo = cFJ();
        return forumWriteData;
    }

    private FrsTabInfoData cFJ() {
        int i;
        if (this.jfA == null || this.jeH == null || this.jfC == null) {
            return null;
        }
        if (this.jeH.getEntelechyTabInfo() == null || com.baidu.tbadk.core.util.x.isEmpty(this.jeH.getEntelechyTabInfo().tab)) {
            return null;
        }
        int cOu = this.jfC.cOu();
        if (cOu == 502) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = -1;
        for (FrsTabInfo frsTabInfo : this.jeH.getEntelechyTabInfo().tab) {
            if (frsTabInfo != null && frsTabInfo.is_general_tab.intValue() == 1) {
                if (frsTabInfo.tab_id.intValue() != 505 || this.jeH.getUserData() == null || this.jeH.getUserData().isForumBusinessAccount()) {
                    arrayList.add(new FrsTabItemData(frsTabInfo));
                    if (cOu == frsTabInfo.tab_id.intValue()) {
                        i = cOu;
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
        if (this.jeH.getUserData() != null) {
            frsTabInfoData.isForumBusinessAccount = this.jeH.getUserData().isForumBusinessAccount();
            return frsTabInfoData;
        }
        return frsTabInfoData;
    }

    @Override // com.baidu.tieba.frs.am
    public void bxO() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void qs(boolean z) {
        this.jfw = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z) {
        this.jfi.Ad(8);
        ((FrsActivity) getActivity()).showLoadingView(view, z);
        ((FrsActivity) getActivity()).j(view, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        this.jfi.Ad(0);
        ((FrsActivity) getActivity()).hideLoadingView(view);
        ((FrsActivity) getActivity()).j(view, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        super.showNetRefreshView(view, getResources().getString(R.string.refresh_view_title_text), null, getResources().getString(R.string.refresh_view_button_text), z, getNetRefreshListener());
        this.jfi.Ad(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshViewNoClick(View view, String str, boolean z) {
        super.showNetRefreshViewNoClick(view, str, z);
        this.jfi.Ad(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        super.hideNetRefreshView(view);
        this.jfi.Ad(0);
    }

    public void cFK() {
        FrsTabViewController.b cOq;
        if (this.jfC != null && (cOq = this.jfC.cOq()) != null && cOq.fragment != null && (cOq.fragment instanceof ao)) {
            ((ao) cOq.fragment).cEF();
        }
    }

    public void qt(boolean z) {
        this.jeY = z;
    }

    public void b(OvalActionButton ovalActionButton) {
        this.jfj = ovalActionButton;
    }

    public OvalActionButton cFL() {
        return this.jfj;
    }

    public boolean cFM() {
        return this.jeY;
    }

    public void KH(String str) {
        if (TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.util.at.isEmpty(str)) {
            if (this.jga == null) {
                this.jga = new AddExperiencedModel(getTbPageContext());
            }
            this.jga.gk(this.forumId, str);
        }
    }

    public boolean cFN() {
        if (this.jfw && !this.jgd) {
            return (this.jfA != null && this.jfA.cMf() && (b.cDX().cDR() || com.baidu.tieba.frs.a.cDQ().cDR())) ? false : true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.g.b
    public boolean videoNeedPreload() {
        if (this.jeH != null) {
            return com.baidu.tbadk.util.ah.th(2) || (com.baidu.tbadk.util.ah.bJo() && this.jeH.isFrsVideoAutoPlay);
        }
        return super.videoNeedPreload();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFO() {
        if (!com.baidu.tbadk.core.util.at.isEmpty(this.forumId)) {
            com.baidu.tbadk.BdToken.c.bkT().q(com.baidu.tbadk.BdToken.b.eEM, com.baidu.adp.lib.f.b.toLong(this.forumId, 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFP() {
        String format;
        String str;
        if (isResumed() && this.jgh != null && this.jgh.size() >= 1 && this.jgg <= this.jgh.size() - 1) {
            final LiveHorseRaceData liveHorseRaceData = this.jgh.get(this.jgg);
            if (System.currentTimeMillis() / 1000 >= liveHorseRaceData.getRob_end_tm().longValue()) {
                this.jgg++;
                cFP();
            }
            if (this.jfl != null) {
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
                        if (FrsFragment.this.jeH == null) {
                            str2 = "";
                        } else if (FrsFragment.this.jeH.getForum() != null) {
                            str2 = FrsFragment.this.jeH.getForum().getName();
                        } else {
                            str2 = "";
                        }
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13744").an("obj_source", 1).dX("fid", FrsFragment.this.forumId).dX("fname", str2));
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
                this.jgi = ValueAnimator.ofFloat(1.0f, 0.0f);
                this.jgi.setDuration(600L);
                this.jgi.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.FrsFragment.54
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        if (valueAnimator.isRunning()) {
                            frsRedpackRunView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                            frsRedpackRunView.setTranslationX(-(TbadkApplication.getInst().getContext().getResources().getDimensionPixelOffset(R.dimen.tbds850) * valueAnimator.getAnimatedFraction()));
                        }
                    }
                });
                this.jgi.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.FrsFragment.55
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        frsRedpackRunView.setAlpha(0.0f);
                        frsRedpackRunView.setTranslationY(TbadkApplication.getInst().getContext().getResources().getDimensionPixelOffset(R.dimen.tbds660));
                        frsRedpackRunView.hide();
                        FrsFragment.this.jfl.removeView(frsRedpackRunView);
                        if (FrsFragment.this.jgh == null || FrsFragment.this.jgg <= FrsFragment.this.jgh.size() - 1) {
                            FrsFragment.this.cFP();
                            return;
                        }
                        FrsFragment.this.jfl.removeAllViews();
                        FrsFragment.this.jfl.setVisibility(8);
                        FrsFragment.this.jgg = 0;
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        onAnimationEnd(animator);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                this.jgj = new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.57
                    @Override // java.lang.Runnable
                    public void run() {
                        if (FrsFragment.this.jfl != null && frsRedpackRunView != null) {
                            FrsFragment.this.jgi.start();
                        }
                    }
                };
                com.baidu.adp.lib.f.e.mB().postDelayed(this.jgj, 5000L);
                if (this.jfl.getChildCount() == 0) {
                    this.jgg++;
                    this.jfl.addView(frsRedpackRunView);
                    if (this.jeH != null) {
                        str = this.jeH.getForum() != null ? this.jeH.getForum().getName() : "";
                    } else {
                        str = "";
                    }
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13743").an("obj_source", 1).dX("fid", this.forumId).dX("fname", str));
                }
                if (this.jfl != null && this.jfl.getVisibility() == 8 && ((BaseFragment) this.jfC.cOq().fragment).isPrimary() && !this.jfi.cGK() && !this.jfr) {
                    this.jfl.setVisibility(0);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        FrsTabViewController.b cOq;
        if (cEX() == null || (cOq = cEX().cOq()) == null || !(cOq.fragment instanceof BaseFragment)) {
            return null;
        }
        if (cOq.fragment instanceof FrsAllThreadFragment) {
            TbPageTag tbPageTag = super.getTbPageTag();
            int i = -1;
            if (this.jeH != null) {
                i = this.jeH.getSortType();
            }
            tbPageTag.sortType = com.baidu.tieba.frs.d.j.BR(i);
            tbPageTag.locatePage = "a070";
            if (this.jeT.equals(cOq.title)) {
                tbPageTag.locatePage = "a071";
            }
            return tbPageTag;
        } else if (cOq.fragment instanceof FrsFragment) {
            return null;
        } else {
            return ((BaseFragment) cOq.fragment).getTbPageTag();
        }
    }

    public void cFQ() {
        if (this.jeH != null) {
            com.baidu.tieba.frs.b.b bVar = new com.baidu.tieba.frs.b.b();
            if (this.jeH.needLog == 1) {
                bVar.jGm = true;
            } else {
                bVar.jGm = false;
            }
            if (this.jeH.getForum() != null) {
                bVar.jGo = this.jeH.getForum().getId();
            }
            if (cEU() != null) {
                bVar.jGn = cEU().cMj();
            }
            if (com.baidu.tieba.frs.b.d.jpq != null) {
                bVar.jGp = com.baidu.tieba.frs.b.d.jpq.jGp;
                bVar.jGq = com.baidu.tieba.frs.b.d.jpq.jGq;
            }
            this.jgk = new com.baidu.tieba.frs.live.b(bVar, getTbPageTag(), getUniqueId());
            this.jgk.Bu(this.jgm);
            CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_CARD_CLICK, this.jgk);
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
            CustomMessageTask customMessageTask2 = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW, this.jgk);
            customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask2);
            CustomMessageTask customMessageTask3 = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_USER_CLICK, this.jgk);
            customMessageTask3.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask3);
            CustomMessageTask customMessageTask4 = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_VIDEO_CLICK, this.jgk);
            customMessageTask4.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask4);
        }
    }

    public void aI(String str, String str2, String str3) {
        this.jgn = new com.baidu.tieba.frs.d.e(str, str2);
        this.jgn.c(getFragmentActivity(), str3, str2);
    }

    public void qu(boolean z) {
        if (this.funAdController == null) {
            this.funAdController = com.baidu.tieba.funad.a.rG(z);
            if (this.jfL != null) {
                this.jfL.setFunAdController(this.funAdController);
            }
        }
    }
}
