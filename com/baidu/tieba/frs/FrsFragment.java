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
public class FrsFragment extends BaseFragment implements BdListView.e, a.InterfaceC0148a, UserIconBox.a<BdRecyclerView>, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, am, ap, as, com.baidu.tieba.frs.loadmore.a, com.baidu.tieba.frs.mc.l, com.baidu.tieba.recapp.q {
    public static com.baidu.tieba.tbadkCore.m jgz;
    private com.baidu.tbadk.util.z fNk;
    private com.baidu.adp.lib.d.b<TbImageView> flN;
    private com.baidu.tieba.funad.a funAdController;
    private com.baidu.tieba.frs.gametab.b gVV;
    private com.baidu.tbadk.core.dialog.a izC;
    public long jgA;
    private String jgK;
    private ThreadCardViewHolder jgM;
    private FrsModelController jgN;
    private com.baidu.tieba.frs.vc.h jgO;
    private FrsTabViewController jgP;
    private com.baidu.tieba.frs.mc.h jgQ;
    private com.baidu.tieba.frs.smartsort.a jgR;
    private com.baidu.tieba.frs.mc.b jgS;
    private at jgT;
    private com.baidu.tieba.frs.entelechy.a.b jgV;
    private com.baidu.tieba.frs.vc.a jgW;
    private com.baidu.tieba.frs.mc.d jgX;
    private com.baidu.tieba.frs.mc.c jgY;
    private com.baidu.tieba.frs.vc.j jgZ;
    private com.baidu.tieba.frs.entelechy.a jgh;
    private com.baidu.tieba.tbadkCore.data.f jgr;
    private VoiceManager jgu;
    private OvalActionButton jgw;
    private FRSRefreshButton jgx;
    private LinearLayout jgy;
    private com.baidu.tieba.frs.d.e jhA;
    private int jhK;
    private com.baidu.tieba.frs.mc.a jha;
    private com.baidu.tieba.frs.live.a jhb;
    private p jhc;
    public com.baidu.tieba.frs.vc.c jhd;
    private com.baidu.tieba.frs.mc.e jhe;
    private View.OnTouchListener jhf;
    private com.baidu.tieba.frs.view.a jhg;
    private com.baidu.tieba.frs.vc.e jhh;
    private boolean jhi;
    private com.baidu.tieba.NEGFeedBack.a jhj;
    private com.baidu.tieba.ala.b jhk;
    private com.baidu.tieba.frs.brand.buttommenu.a jhl;
    private com.baidu.tieba.frs.sportspage.notification.a jhm;
    private AddExperiencedModel jhn;
    private boolean jhp;
    private List<LiveHorseRaceData> jhu;
    private ValueAnimator jhv;
    private Runnable jhw;
    private com.baidu.tieba.frs.live.b jhx;
    private com.baidu.tieba.frs.broadcast.a jhy;
    private int jhz;
    private View mRootView;
    private String mSchemeUrl;
    public static boolean jgm = false;
    public static volatile long jgC = 0;
    public static volatile long jgD = 0;
    public static volatile int mNetError = 0;
    private String jgg = "";
    public boolean jgi = false;
    private boolean jgj = false;
    private boolean jgk = false;
    private boolean jgl = true;
    public String jgn = null;
    public String mFrom = null;
    public int mFlag = 0;
    public boolean jgo = false;
    private boolean jgp = false;
    private String mThreadId = null;
    public String forumId = null;
    private int jfW = 0;
    private boolean jgq = false;
    private boolean jgs = false;
    private boolean jgt = false;
    private q jgv = null;
    public final cb akU = null;
    private FrsViewData jfU = new FrsViewData();
    public long iJe = -1;
    public long fJu = 0;
    public long fJl = 0;
    public long createTime = 0;
    public long fJm = 0;
    public long fJr = 0;
    public long jgB = 0;
    boolean jgE = false;
    public boolean jgF = false;
    private boolean jgG = false;
    public com.baidu.tbadk.n.b jgH = null;
    private boolean jgI = true;
    private boolean jgJ = true;
    private a.C0089a jgL = new a.C0089a(2);
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> jgU = new SparseArray<>();
    private boolean gDp = true;
    private boolean hasInit = false;
    private boolean jho = false;
    private boolean jhq = false;
    private Date jhr = null;
    private int dVi = 0;
    private int jhs = 0;
    private int jht = 0;
    public int mHeadLineDefaultNavTabId = -1;
    MessageQueue.IdleHandler jhB = new MessageQueue.IdleHandler() { // from class: com.baidu.tieba.frs.FrsFragment.1
        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            FrsFragment.this.cCP();
            return false;
        }
    };
    private final CustomMessageListener jhC = new CustomMessageListener(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED) { // from class: com.baidu.tieba.frs.FrsFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof cb) {
                    com.baidu.tieba.frs.d.k.a(FrsFragment.this.jgv, FrsFragment.this.jfU, FrsFragment.this.getForumId(), true, (cb) data);
                }
            }
        }
    };
    private CustomMessageListener jhD = new CustomMessageListener(CmdConfigCustom.CMD_CLOSE_GAME_RANK_CARD) { // from class: com.baidu.tieba.frs.FrsFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.jfU != null) {
                FrsFragment.this.jfU.removeGameRankListFromThreadList();
                if (FrsFragment.this.jgv != null) {
                    FrsFragment.this.jgv.bbC();
                }
            }
        }
    };
    private CustomMessageListener ahl = new CustomMessageListener(2921401) { // from class: com.baidu.tieba.frs.FrsFragment.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && FrsFragment.this.jgx != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() <= 0 || FrsFragment.this.jgP.cLX() == 0 || FrsFragment.this.jgP.cLU() == null || !(FrsFragment.this.jgP.cLU().fragment instanceof BaseFragment) || !((BaseFragment) FrsFragment.this.jgP.cLU().fragment).isPrimary() || FrsFragment.this.jgv.cEm() || com.baidu.tbadk.k.d.bCB().bCC()) {
                    if (FrsFragment.this.jgP.cLX() != 0) {
                        FrsFragment.this.jgx.hide();
                        return;
                    }
                    return;
                }
                FrsFragment.this.jgx.show();
            }
        }
    };
    private CustomMessageListener jhE = new CustomMessageListener(2921473) { // from class: com.baidu.tieba.frs.FrsFragment.45
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && FrsFragment.this.jgx != null && FrsFragment.this.jgw != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() == 0) {
                    FrsFragment.this.jgx.setVisibility(8);
                    FrsFragment.this.jgw.setVisibility(8);
                    return;
                }
                FrsFragment.this.jgw.setVisibility(0);
            }
        }
    };
    private CustomMessageListener jhF = new CustomMessageListener(2921467) { // from class: com.baidu.tieba.frs.FrsFragment.56
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && FrsFragment.this.jgx != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() <= 0 || FrsFragment.this.jgP.cLU() == null || !(FrsFragment.this.jgP.cLU().fragment instanceof BaseFragment) || !((BaseFragment) FrsFragment.this.jgP.cLU().fragment).isPrimary() || FrsFragment.this.jgv.cEm()) {
                    FrsFragment.this.jgy.setVisibility(8);
                    FrsFragment.this.jgE = true;
                    return;
                }
                FrsFragment.this.jgy.setVisibility(0);
                FrsFragment.this.jgE = false;
            }
        }
    };
    private com.baidu.adp.framework.listener.a jhG = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_FRS_LIVE_HORSE_RACE_LIST, 309667) { // from class: com.baidu.tieba.frs.FrsFragment.64
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if ((responsedMessage instanceof GetLiveHorseRaceHttpResponseMessage) || (responsedMessage instanceof GetLiveHorseRaceSocketResponseMessage)) {
                    List<LiveHorseRaceData> arrayList = new ArrayList<>();
                    if (responsedMessage instanceof GetLiveHorseRaceHttpResponseMessage) {
                        arrayList = ((GetLiveHorseRaceHttpResponseMessage) responsedMessage).getData().cEO();
                    }
                    if (responsedMessage instanceof GetLiveHorseRaceSocketResponseMessage) {
                        arrayList = ((GetLiveHorseRaceSocketResponseMessage) responsedMessage).getData().cEO();
                    }
                    if (FrsFragment.this.jhu != null) {
                        if (FrsFragment.this.jgy == null || FrsFragment.this.jgy.getVisibility() != 8) {
                            if (FrsFragment.this.jht >= FrsFragment.this.jhu.size()) {
                                FrsFragment.this.jhu.addAll(arrayList);
                                return;
                            }
                            FrsFragment.this.jhu = FrsFragment.this.jhu.subList(0, FrsFragment.this.jht);
                            FrsFragment.this.jhu.addAll(arrayList);
                            return;
                        }
                        FrsFragment.this.jhu = new ArrayList();
                        FrsFragment.this.jhu.addAll(arrayList);
                        FrsFragment.this.jht = 0;
                        FrsFragment.this.cDr();
                        return;
                    }
                    FrsFragment.this.jhu = new ArrayList();
                    FrsFragment.this.jht = 0;
                    FrsFragment.this.jhu.addAll(arrayList);
                    FrsFragment.this.cDr();
                }
            }
        }
    };
    private CustomMessageListener jhH = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.FrsFragment.65
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 1) {
                    FrsFragment.this.cCT();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                }
            }
        }
    };
    private final ar jhI = new ar() { // from class: com.baidu.tieba.frs.FrsFragment.66
        @Override // com.baidu.tieba.frs.ar
        public void a(int i, int i2, ba baVar, ArrayList<com.baidu.adp.widget.ListView.n> arrayList) {
            FrsFragment.this.cCE();
            if (FrsFragment.this.jgV != null) {
                FrsFragment.this.jgO.rD(FrsFragment.this.jgV.zm(i));
            }
            com.baidu.tieba.tbadkCore.f fVar = new com.baidu.tieba.tbadkCore.f();
            if (baVar != null) {
                fVar.isSuccess = baVar.errCode == 0;
                fVar.errorCode = baVar.errCode;
                fVar.errorMsg = baVar.errMsg;
                if (fVar.isSuccess) {
                    if (com.baidu.tbadk.core.util.y.isEmpty(arrayList)) {
                        FrsFragment.this.jgv.bSy();
                    } else if (baVar.hasMore) {
                        if (com.baidu.tbadk.core.util.y.getCount(FrsFragment.this.jfU.getThreadList()) > 3) {
                            FrsFragment.this.jgv.WX();
                        } else {
                            FrsFragment.this.jgv.cEd();
                        }
                    } else if (baVar.jlv) {
                        FrsFragment.this.jgv.WY();
                    } else {
                        FrsFragment.this.jgv.bSy();
                    }
                }
            } else {
                baVar = new ba();
                baVar.pn = 1;
                baVar.hasMore = false;
                baVar.jlv = false;
            }
            if (i == 1) {
                FrsFragment.this.jgI = true;
                FrsFragment.this.jia.a(FrsFragment.this.jgN.getType(), false, fVar);
            } else {
                FrsFragment.this.a(fVar);
                if (FrsFragment.this.jgN.cJi() != null) {
                    FrsFragment.this.jfU = FrsFragment.this.jgN.cJi();
                }
                FrsFragment.this.cCV();
            }
            if (FrsFragment.this.jij != null) {
                FrsFragment.this.jij.a(i, i2, baVar, arrayList);
            }
        }
    };
    private FrsTabViewController.a jhJ = new FrsTabViewController.a() { // from class: com.baidu.tieba.frs.FrsFragment.2
        @Override // com.baidu.tieba.frs.vc.FrsTabViewController.a
        public void l(int i, int i2, String str) {
            boolean z = false;
            if (i != 1) {
                com.baidu.tieba.card.t.csB().pB(false);
                FrsFragment.this.qu(false);
            }
            if (i == 502) {
                FrsFragment.this.jgw.setIconFade(R.drawable.btn_frs_professional_edit_n);
            } else {
                FrsFragment.this.jgw.setIconFade(0);
            }
            FrsFragment.this.jhK = i;
            FrsFragment.this.jhz = i2;
            if (FrsFragment.this.jhx != null) {
                FrsFragment.this.jhx.zX(FrsFragment.this.jhz);
            }
            TbSingleton.getInstance().setFrsCurTabType(FrsFragment.this.jhz);
            FrsFragment.this.cDb();
            com.baidu.tieba.frs.b.d.jqE.jHB = i;
            com.baidu.tieba.frs.b.d.jqE.jHE = i2;
            com.baidu.tieba.frs.b.d.jqE.jHC = -1;
            b.cBy().X(i == 1 && FrsFragment.this.jho, true);
            com.baidu.tieba.frs.a cBr = com.baidu.tieba.frs.a.cBr();
            if (i == 1 && FrsFragment.this.jho) {
                z = true;
            }
            cBr.X(z, true);
        }
    };
    private CustomMessageListener jhL = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIVE_COUNT) { // from class: com.baidu.tieba.frs.FrsFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                FrsFragment.this.jgP.AI(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    };
    private CustomMessageListener jhM = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_LIVE_START) { // from class: com.baidu.tieba.frs.FrsFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && ((Integer) customResponsedMessage.getData()).intValue() == 51 && FrsFragment.this.jfU != null) {
                com.baidu.tieba.frs.d.m.a(FrsFragment.this.jfU, FrsFragment.this.getPageContext());
            }
        }
    };
    private final CustomMessageListener jhN = new CustomMessageListener(CmdConfigCustom.CMD_FRS_SELECT_ALA_LIVE_TAB) { // from class: com.baidu.tieba.frs.FrsFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                FrsFragment.this.jgP.sT(49);
            }
        }
    };
    private final CustomMessageListener jhO = new CustomMessageListener(2921470) { // from class: com.baidu.tieba.frs.FrsFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                FrsFragment.this.jgP.sT(1);
                FrsFragment.this.cCT();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
            }
        }
    };
    private final CustomMessageListener jhP = new CustomMessageListener(CmdConfigCustom.CMD_FRS_EXPERIENCE_TIP) { // from class: com.baidu.tieba.frs.FrsFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.w) && FrsFragment.this.jfU != null) {
                FrsFragment.this.jfU.updateLikeData((com.baidu.tieba.tbadkCore.w) customResponsedMessage.getData());
                FrsFragment.this.jgO.j(FrsFragment.this.jfU);
                FrsFragment.this.jgP.a(FrsFragment.this.jfU, FrsFragment.this.jgN.cJM());
            }
        }
    };
    private final AntiHelper.a jhQ = new AntiHelper.a() { // from class: com.baidu.tieba.frs.FrsFragment.8
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ap("obj_locate", ay.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ap("obj_locate", ay.a.LOCATE_LIKE_PERSON));
        }
    };
    private CustomMessageListener jhR = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.FrsFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(FrsFragment.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().fsD != null) {
                        if (AntiHelper.a(FrsFragment.this.getActivity(), updateAttentionMessage.getData().fsD, FrsFragment.this.jhQ) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ap("obj_locate", ay.a.LOCATE_LIKE_PERSON));
                        }
                    } else if (updateAttentionMessage.getData().isSucc && updateAttentionMessage.getData().isAttention) {
                        com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getPageContext().getPageActivity(), R.string.attention_success);
                    }
                }
            }
        }
    };
    private CustomMessageListener jhS = new CustomMessageListener(CmdConfigCustom.CMD_GET_ENSURE_CAST_ID) { // from class: com.baidu.tieba.frs.FrsFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsFragment.this.refresh();
        }
    };
    private CustomMessageListener jhT = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.frs.FrsFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                FrsFragment.this.jgv.c((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener jhU = new CustomMessageListener(2001378) { // from class: com.baidu.tieba.frs.FrsFragment.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof WriteData) && com.baidu.tbadk.core.util.au.equals(((WriteData) customResponsedMessage.getData()).getForumId(), FrsFragment.this.forumId)) {
                FrsFragment.this.jha.zZ(((WriteData) customResponsedMessage.getData()).getTabId());
                MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
            }
        }
    };
    private CustomMessageListener jhV = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_REMIND) { // from class: com.baidu.tieba.frs.FrsFragment.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626) {
                NewsRemindMessage newsRemindMessage = (NewsRemindMessage) customResponsedMessage;
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (FrsFragment.this.jgv != null) {
                    FrsFragment.this.jgv.P(notificationCount, z);
                }
            }
        }
    };
    private HttpMessageListener jhW = new HttpMessageListener(CmdConfigHttp.CMD_FRS_MOVE_AREA) { // from class: com.baidu.tieba.frs.FrsFragment.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int i;
            int i2 = 0;
            if (httpResponsedMessage != null && FrsFragment.this.getContext() != null && FrsFragment.this.jgv != null) {
                if (httpResponsedMessage.getError() == 0) {
                    new BdTopToast(FrsFragment.this.getContext()).zn(true).UZ(FrsFragment.this.getContext().getString(R.string.frs_move_area_move_suc)).aR(FrsFragment.this.jgv.cnu());
                    if (com.baidu.tieba.frs.a.cBr().yt(com.baidu.tieba.frs.a.cBr().cBt())) {
                        FrsCommonTabFragment frsCommonTabFragment = null;
                        if (FrsFragment.this.jgP != null && FrsFragment.this.jgP.cLU() != null && (FrsFragment.this.jgP.cLU().fragment instanceof FrsCommonTabFragment)) {
                            frsCommonTabFragment = (FrsCommonTabFragment) FrsFragment.this.jgP.cLU().fragment;
                        }
                        if (frsCommonTabFragment != null) {
                            frsCommonTabFragment.cFJ();
                        }
                        FrsFragment.this.cBw();
                        com.baidu.tieba.frs.a.cBr().cBw();
                        Iterator<com.baidu.adp.widget.ListView.n> it = FrsFragment.this.jfU.getThreadList().iterator();
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
                            FrsFragment.this.bRj();
                        }
                    }
                    com.baidu.tieba.frs.a.cBr().reset();
                    return;
                }
                new BdTopToast(FrsFragment.this.getContext()).zn(false).UZ(httpResponsedMessage.getErrorString()).aR(FrsFragment.this.jgv.cnu());
            }
        }
    };
    private com.baidu.tbadk.mutiprocess.h mTopToastEventListener = new com.baidu.tbadk.mutiprocess.h<TopToastEvent>() { // from class: com.baidu.tieba.frs.FrsFragment.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.mutiprocess.b
        public boolean a(TopToastEvent topToastEvent) {
            new BdTopToast(FrsFragment.this.getContext()).zn(topToastEvent.isSuccess()).UZ(topToastEvent.getContent()).aR(FrsFragment.this.jgv.cnu());
            return false;
        }
    };
    private final CustomMessageListener jhX = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.frs.FrsFragment.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.isResumed()) {
                FrsFragment.this.cDq();
            }
        }
    };
    private CustomMessageListener jhY = new CustomMessageListener(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER) { // from class: com.baidu.tieba.frs.FrsFragment.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (FrsFragment.this.jgv != null) {
                    FrsFragment.this.jgv.setExpanded(booleanValue);
                }
            }
        }
    };
    private final CustomMessageListener jhZ = new CustomMessageListener(2921463) { // from class: com.baidu.tieba.frs.FrsFragment.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TbadkApplication.getInst().getCurrentActivity() != null && !com.baidu.tbadk.core.util.au.isEmpty(str) && str.equals(FrsFragment.this.forumId)) {
                    com.baidu.tieba.frs.d.h.b(((TbPageContextSupport) TbadkApplication.getInst().getCurrentActivity()).getPageContext(), FrsFragment.this.jfU);
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.s jia = new com.baidu.tieba.tbadkCore.s() { // from class: com.baidu.tieba.frs.FrsFragment.20
        private long startTime = 0;

        @Override // com.baidu.tieba.tbadkCore.s
        public void yA(int i) {
            this.startTime = System.nanoTime();
            if (FrsFragment.this.jgv != null) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsFragment.this.jgv.cDO();
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
            if (FrsFragment.this.gDp) {
                FrsFragment.this.gDp = false;
                com.baidu.tieba.frs.d.k.a(FrsFragment.this.jgv, FrsFragment.this.jfU, FrsFragment.this.getForumId(), false, null);
            }
            FrsFragment.this.cCE();
            FrsFragment.this.jgG = true;
            if (fVar != null && fVar.isSuccess) {
                FrsFragment.this.jgv.cEb().rf(com.baidu.tbadk.core.util.av.bsS().bsT());
                FrsFragment.jgC = 0L;
                FrsFragment.jgD = 0L;
                FrsFragment.mNetError = 0;
            } else {
                FrsFragment.mNetError = 1;
            }
            if (!FrsFragment.this.jgN.cJR() && (i == 3 || i == 6)) {
                FrsFragment.this.jgY.resetData();
            }
            FrsFragment.this.jgA = System.currentTimeMillis();
            if (FrsFragment.this.jgN.cJi() != null) {
                FrsFragment.this.jfU = FrsFragment.this.jgN.cJi();
            }
            FrsFragment.this.yw(1);
            FrsFragment.this.cCM();
            if (i == 7) {
                FrsFragment.this.yx(FrsFragment.this.jfU.getFrsDefaultTabId());
                return;
            }
            if (FrsFragment.this.jfU.getPage() != null) {
                FrsFragment.this.setHasMore(FrsFragment.this.jfU.getPage().bmF());
            }
            if (i == 4) {
                if (!FrsFragment.this.jgN.cJR() && TbadkCoreApplication.getInst().isRecAppExist() && FrsFragment.this.jgN.cJH() == 1 && !com.baidu.tieba.funad.a.cNu()) {
                    FrsFragment.this.jfU.addRecommendAppToThreadList(FrsFragment.this);
                }
                ArrayList<com.baidu.adp.widget.ListView.n> a2 = FrsFragment.this.jgY.a(false, false, FrsFragment.this.jfU.getThreadList(), FrsFragment.this.jgr, false);
                if (a2 != null) {
                    FrsFragment.this.jfU.setThreadList(a2);
                    FrsFragment.this.jfU.checkLiveStageInThreadList();
                }
                if (FrsFragment.this.jgN != null) {
                    com.baidu.tieba.frs.b.c.a(FrsFragment.this.jfU, FrsFragment.this.jgN.cJM(), 2, FrsFragment.this.getContext());
                }
                com.baidu.tieba.frs.d.a.a(FrsFragment.this, FrsFragment.this.jfU.getForum(), FrsFragment.this.jfU.getThreadList(), false, FrsFragment.this.getPn());
                FrsFragment.this.jgv.a(a2, FrsFragment.this.jfU);
                FrsFragment.this.cCF();
                return;
            }
            FrsFragment.this.cCF();
            switch (i) {
                case 1:
                    FrsFragment.this.jgv.cDO();
                    break;
                case 2:
                    FrsFragment.this.jgv.cDO();
                    break;
                case 3:
                case 6:
                    if (FrsFragment.this.jfU != null) {
                        FrsFragment.this.jfU.clearPostThreadCount();
                    }
                    if (FrsFragment.this.jhd != null) {
                        FrsFragment.this.jhd.refresh();
                        break;
                    }
                    break;
            }
            FrsFragment.this.cCN();
            if (fVar == null || fVar.errorCode == 0) {
                if (FrsFragment.this.jfU != null) {
                    FrsFragment.this.a(FrsFragment.this.jfU);
                    FrsFragment.this.Z(false, i == 5);
                    if (FrsFragment.this.jgN != null) {
                        if (FrsFragment.this.jfU.getActivityHeadData() != null && FrsFragment.this.jfU.getActivityHeadData().blR() != null && FrsFragment.this.jfU.getActivityHeadData().blR().size() > 0) {
                            com.baidu.tieba.frs.b.a.a(FrsFragment.this.getUniqueId(), 1, FrsFragment.this.jfU.getForum(), FrsFragment.this.jgN.getSortType(), 1);
                        }
                        if (FrsFragment.this.jfU.getThreadList() != null && FrsFragment.this.jfU.getThreadList().size() > 0) {
                            Iterator<com.baidu.adp.widget.ListView.n> it = FrsFragment.this.jfU.getThreadList().iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    com.baidu.adp.widget.ListView.n next = it.next();
                                    if ((next instanceof cb) && ((cb) next).getType() == cb.eSp) {
                                        com.baidu.tieba.frs.b.a.a(FrsFragment.this.getUniqueId(), 1, FrsFragment.this.jfU.getForum(), FrsFragment.this.jgN.getSortType(), 2);
                                    }
                                }
                            }
                        }
                        com.baidu.tieba.frs.b.a.a(FrsFragment.this.getUniqueId(), FrsFragment.this.jfU.getThreadList(), FrsFragment.this.jfU.getForum(), FrsFragment.this.jgN.getSortType());
                    }
                    FrsFragment.this.jgv.yN(i);
                    FrsFragment.jgC = (System.nanoTime() - this.startTime) / TimeUtils.NANOS_PER_MS;
                    if (fVar != null) {
                        FrsFragment.jgD = fVar.nuG;
                    }
                } else {
                    return;
                }
            } else if (FrsFragment.this.jfU == null || com.baidu.tbadk.core.util.y.isEmpty(FrsFragment.this.jfU.getThreadList())) {
                FrsFragment.this.a(fVar);
            } else if (fVar.iQx) {
                FrsFragment.this.showToast(FrsFragment.this.getPageContext().getResources().getString(R.string.net_error_text, fVar.errorMsg, Integer.valueOf(fVar.errorCode)));
            }
            FrsFragment.this.cCJ();
            FrsFragment.this.cCK();
            if (FrsFragment.this.jfU.getAccessFlag() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11384"));
            }
            if (FrsFragment.this.jgs && FrsFragment.this.jgP.sT(49)) {
                FrsFragment.this.jgs = false;
            }
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.s
        public void c(com.baidu.tieba.tbadkCore.m mVar) {
            if ((mVar != null && ("normal_page".equals(FrsFragment.this.jgN.getPageType()) || "frs_page".equals(FrsFragment.this.jgN.getPageType()) || "book_page".equals(FrsFragment.this.jgN.getPageType()))) || "brand_page".equals(FrsFragment.this.jgN.getPageType())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE, mVar));
                FrsFragment.this.b(mVar);
                FrsFragment.jgz = mVar;
            }
        }

        @Override // com.baidu.tieba.tbadkCore.s
        public void cCP() {
            FrsFragment.this.cCP();
        }
    };
    private final CustomMessageListener jib = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.frs.FrsFragment.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.n) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                FrsFragment.this.jfU.updateCurrentUserPendant((com.baidu.tbadk.data.n) customResponsedMessage.getData());
                FrsFragment.this.jgv.cEb().notifyDataSetChanged();
            }
        }
    };
    private final CustomMessageListener mMemListener = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_MEM) { // from class: com.baidu.tieba.frs.FrsFragment.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && FrsFragment.this.jfU != null && (userData = FrsFragment.this.jfU.getUserData()) != null) {
                userData.setIsMem(num.intValue());
                if (num.intValue() != 0) {
                    FrsFragment.this.jgO.q(num);
                }
            }
        }
    };
    private final f.a jic = new AnonymousClass31();
    private final com.baidu.tieba.frs.mc.k jie = new com.baidu.tieba.frs.mc.k() { // from class: com.baidu.tieba.frs.FrsFragment.32
        @Override // com.baidu.tieba.frs.mc.k
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.n> arrayList, boolean z3) {
            if (FrsFragment.this.jgR != null && FrsFragment.this.jgN != null && FrsFragment.this.jgN.cJR() && z && !z2 && !z3) {
                FrsFragment.this.jgR.Af(i2);
            }
        }
    };
    public final View.OnTouchListener bST = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.FrsFragment.33
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (FrsFragment.this.jhf != null) {
                FrsFragment.this.jhf.onTouch(view, motionEvent);
            }
            if (FrsFragment.this.jgT != null && FrsFragment.this.jgT.cEP() != null) {
                FrsFragment.this.jgT.cEP().onTouchEvent(motionEvent);
            }
            if (FrsFragment.this.gVV != null) {
                FrsFragment.this.gVV.i(view, motionEvent);
            }
            if (FrsFragment.this.jgO != null) {
                FrsFragment.this.jgO.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private final CustomMessageListener jif = new CustomMessageListener(CmdConfigCustom.CMD_GOTOLIVE_HOST_UPGRADE) { // from class: com.baidu.tieba.frs.FrsFragment.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.brQ().getInt(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.PHOTOLIVE_HOSTLEVEL, -1) != -1 && FrsFragment.this.jfU.getForum() != null) {
                FrsFragment.this.jfU.getForum().setCanAddPhotoLivePost(true);
            }
        }
    };
    public final View.OnClickListener jig = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.41
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsFragment.this.jgv != null && view == FrsFragment.this.jgv.cDM() && FrsFragment.this.getActivity() != null) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, FrsFragment.this.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            if (view.getId() == R.id.game_activity_egg_layout && com.baidu.adp.lib.util.l.isNetOk()) {
                TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_CLICK);
                if (FrsFragment.this.jgv == null || !FrsFragment.this.jgv.cDY()) {
                    String activityUrl = FrsFragment.this.jfU.getForum().getYuleData().bqo().getActivityUrl();
                    if (!StringUtils.isNull(activityUrl)) {
                        com.baidu.tbadk.browser.a.startInternalWebActivity(FrsFragment.this.getPageContext().getPageActivity(), activityUrl);
                    }
                } else {
                    FrsFragment.this.jgv.cDZ();
                }
            }
            if (FrsFragment.this.jgv != null && view == FrsFragment.this.jgv.cEe() && FrsFragment.this.jgN != null && FrsFragment.this.jgN.hasMore()) {
                FrsFragment.this.jgv.WX();
                FrsFragment.this.bRj();
            }
            if (view != null && FrsFragment.this.jgv != null && view == FrsFragment.this.jgv.cDV()) {
                if (bh.checkUpIsLogin(FrsFragment.this.getContext())) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).ap("obj_locate", 2));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MessageCenterActivityConfig(FrsFragment.this.getContext())));
                } else {
                    return;
                }
            }
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (FrsFragment.this.jfU != null && FrsFragment.this.jfU.getForum() != null) {
                    if (FrsFragment.this.jgv != null && view == FrsFragment.this.jgv.cDT()) {
                        if (FrsFragment.this.jfU != null && FrsFragment.this.jfU.getForum() != null && !StringUtils.isNull(FrsFragment.this.jfU.getForum().getId()) && !StringUtils.isNull(FrsFragment.this.jfU.getForum().getName())) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.KEY_SHARE_CLICK).dR("fid", FrsFragment.this.jfU.getForum().getId()).ap("obj_locate", 11));
                            com.baidu.tieba.frs.d.h.a(FrsFragment.this.getPageContext(), FrsFragment.this.jfU, FrsFragment.this.jfU.getForum().getId());
                        } else {
                            return;
                        }
                    }
                    if (FrsFragment.this.jgv != null && view == FrsFragment.this.jgv.cDS()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12402").dR("fid", FrsFragment.this.jfU.getForum().getId()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fname", FrsFragment.this.jfU.getForum().getName()));
                        if (!StringUtils.isNull(FrsFragment.this.jfU.getForum().getName())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PostSearchActivityConfig(FrsFragment.this.getContext(), FrsFragment.this.jfU.getForum().getName(), FrsFragment.this.jfU.getForum().getId())));
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
        private int jiE = 0;
        private int gzf = 0;

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsFragment.this.jhs += i2;
            if (FrsFragment.this.jhs >= FrsFragment.this.dVi * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
            if (FrsFragment.this.jgW != null) {
                FrsFragment.this.jgW.cKN();
            }
            this.jiE = 0;
            this.gzf = 0;
            if (recyclerView != null && (recyclerView instanceof BdRecyclerView)) {
                this.jiE = ((BdRecyclerView) recyclerView).getFirstVisiblePosition();
                this.gzf = ((BdRecyclerView) recyclerView).getLastVisiblePosition();
            }
            if (FrsFragment.this.jhh != null) {
                FrsFragment.this.jhh.a(recyclerView, this.jiE, this.gzf);
            }
            if (FrsFragment.this.jfU != null && FrsFragment.this.jgv != null && FrsFragment.this.jgv.cEb() != null) {
                FrsFragment.this.jgv.co(this.jiE, this.gzf);
                if (FrsFragment.this.jgM != null && FrsFragment.this.jgM.tj() != null) {
                    FrsFragment.this.jgM.tj().b(FrsFragment.this.jgL);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (FrsFragment.this.jgO != null) {
                FrsFragment.this.jgO.setScrollState(i);
                if (i == 1) {
                    FrsFragment.this.jgO.cLp();
                }
            }
            if (FrsFragment.this.jgH == null && !FrsFragment.this.cDj()) {
                FrsFragment.this.jgH = new com.baidu.tbadk.n.b();
                FrsFragment.this.jgH.setSubType(1000);
            }
            if (i == 0) {
                if (FrsFragment.this.jgH != null) {
                    FrsFragment.this.jgH.bDZ();
                }
                com.baidu.tieba.card.t.csB().pB(true);
                FrsFragment.this.qu(true);
                FrsFragment.this.jgv.cn(this.jiE, this.gzf);
            } else if (FrsFragment.this.jgH != null) {
                FrsFragment.this.jgH.bDY();
            }
            if (FrsFragment.this.jhh != null) {
                FrsFragment.this.jhh.onScrollStateChanged(recyclerView, i);
            }
            if (i == 0) {
                com.baidu.tieba.frs.d.k.a(FrsFragment.this.jgv, FrsFragment.this.jfU, FrsFragment.this.getForumId(), false, null);
            }
            if (FrsFragment.this.jgP != null && i == 1) {
                FrsFragment.this.jgP.cLW();
            }
            if (FrsFragment.this.jgM == null) {
                if (FrsFragment.this.jgv.cDF() != null && !FrsFragment.this.jgv.cDh() && FrsFragment.this.jgv.cDF().dAc() != null && (FrsFragment.this.jgv.cDF().dAc().getTag() instanceof ThreadCardViewHolder)) {
                    FrsFragment.this.jgM = (ThreadCardViewHolder) FrsFragment.this.jgv.cDF().dAc().getTag();
                }
            } else if (i == 0 && FrsFragment.this.jgv.cDF() != null && !FrsFragment.this.jgv.cDh() && FrsFragment.this.jgv.cDF().dAc() != null && (FrsFragment.this.jgv.cDF().dAc().getTag() instanceof ThreadCardViewHolder)) {
                FrsFragment.this.jgM = (ThreadCardViewHolder) FrsFragment.this.jgv.cDF().dAc().getTag();
            }
            if (i == 1) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921418));
            }
        }
    };
    private final f jih = new f() { // from class: com.baidu.tieba.frs.FrsFragment.43
        @Override // com.baidu.tieba.frs.f
        public void a(int i, int i2, View view, View view2, cb cbVar) {
            if (i != FrsFragment.this.jgv.cEb().cGC()) {
                if (i != FrsFragment.this.jgv.cEb().cGD()) {
                    if (i == FrsFragment.this.jgv.cEb().cGA() && FrsFragment.this.jfU != null && FrsFragment.this.jfU.getUserData() != null && FrsFragment.this.jfU.getUserData().isBawu()) {
                        String bawuCenterUrl = FrsFragment.this.jfU.getBawuCenterUrl();
                        if (!com.baidu.tbadk.core.util.au.isEmpty(bawuCenterUrl) && FrsFragment.this.jfU.getForum() != null) {
                            com.baidu.tbadk.browser.a.startWebActivity(FrsFragment.this.getPageContext().getPageActivity(), bawuCenterUrl);
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10502").dR("fid", FrsFragment.this.jfU.getForum().getId()).dR("uid", FrsFragment.this.jfU.getUserData().getUserId()));
                        }
                    }
                } else if (bh.checkUpIsLogin(FrsFragment.this.getPageContext().getPageActivity())) {
                    TiebaStatic.log(CommonStatisticKey.MY_SERVICE_CK);
                    if (FrsFragment.this.jfU != null && FrsFragment.this.jfU.getForum() != null) {
                        ForumData forum = FrsFragment.this.jfU.getForum();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(forum.getId(), 0L), forum.getName(), forum.getImage_url(), 0)));
                    }
                }
            } else if (bh.checkUpIsLogin(FrsFragment.this.getActivity())) {
                TiebaStatic.log("forum_fortune_click");
                com.baidu.tieba.frs.d.l.c(FrsFragment.this.getPageContext(), FrsFragment.this.jfU);
            }
        }
    };
    private final NoNetworkView.a jdH = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.FrsFragment.44
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (FrsFragment.this.jgN.cJH() == 1 && z && !FrsFragment.this.jgv.cDh()) {
                if (FrsFragment.this.jfU == null || com.baidu.tbadk.core.util.y.isEmpty(FrsFragment.this.jfU.getThreadList())) {
                    FrsFragment.this.hideNetRefreshView(FrsFragment.this.jgv.cEp().cLK());
                    FrsFragment.this.showLoadingView(FrsFragment.this.jgv.cnu(), true);
                    FrsFragment.this.jgv.qF(false);
                    FrsFragment.this.refresh();
                    return;
                }
                FrsFragment.this.jgv.cDO();
            }
        }
    };
    private final CustomMessageListener fsV = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.FrsFragment.46
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                com.baidu.tieba.frs.d.c.a(customResponsedMessage, FrsFragment.this.jgv, FrsFragment.this.jfU);
            }
        }
    };
    private com.baidu.adp.widget.ListView.w jii = new a();
    private ar jij = new ar() { // from class: com.baidu.tieba.frs.FrsFragment.48
        @Override // com.baidu.tieba.frs.ar
        public void a(int i, int i2, ba baVar, ArrayList<com.baidu.adp.widget.ListView.n> arrayList) {
            com.baidu.adp.lib.f.e.mA().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.48.1
                @Override // java.lang.Runnable
                public void run() {
                    if (FrsFragment.this.jgv != null && FrsFragment.this.jgv.cEh()) {
                        FrsFragment.this.bRj();
                    }
                }
            });
        }
    };
    private CustomMessageListener jik = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.frs.FrsFragment.49
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    FrsFragment.this.jhi = true;
                }
            }
        }
    };
    private CustomMessageListener jil = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.frs.FrsFragment.50
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                    if (FrsFragment.this.jgM == null && FrsFragment.this.jgv.cDF() != null && !FrsFragment.this.jgv.cDh() && FrsFragment.this.jgv.cDF().dAc() != null && (FrsFragment.this.jgv.cDF().dAc().getTag() instanceof ThreadCardViewHolder)) {
                        FrsFragment.this.jgM = (ThreadCardViewHolder) FrsFragment.this.jgv.cDF().dAc().getTag();
                    }
                    if (FrsFragment.this.jgM != null && FrsFragment.this.jgM.tj() != null) {
                        FrsFragment.this.jgM.tj().b(new a.C0089a(3));
                    }
                }
            }
        }
    };
    private CustomMessageListener jim = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.FrsFragment.51
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.jgv != null) {
                FrsFragment.this.jgv.EK();
            }
        }
    };
    private CustomMessageListener jin = new CustomMessageListener(2921437) { // from class: com.baidu.tieba.frs.FrsFragment.52
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && FrsFragment.this.isResumed()) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (FrsFragment.this.jgx != null) {
                    if (booleanValue) {
                        if (FrsFragment.this.jgP.cLX() != 0 && !FrsFragment.this.jgv.cEm() && !com.baidu.tbadk.k.d.bCB().bCC()) {
                            FrsFragment.this.jgx.show();
                            return;
                        }
                        return;
                    }
                    FrsFragment.this.jgx.hide();
                }
            }
        }
    };
    private CustomMessageListener jio = new CustomMessageListener(2921462) { // from class: com.baidu.tieba.frs.FrsFragment.58
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && FrsFragment.this.jfU.getToLoadHorseData().intValue() == 1 && FrsFragment.this.mIsLogin) {
                LiveHorseRaceRequestMessage liveHorseRaceRequestMessage = new LiveHorseRaceRequestMessage();
                liveHorseRaceRequestMessage.setForum_id(Long.valueOf(FrsFragment.this.forumId));
                FrsFragment.this.sendMessage(liveHorseRaceRequestMessage);
            }
        }
    };
    private CustomMessageListener jip = new CustomMessageListener(2001223) { // from class: com.baidu.tieba.frs.FrsFragment.59
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Date)) {
                FrsFragment.this.jhr = (Date) customResponsedMessage.getData();
            }
        }
    };
    private CustomMessageListener jiq = new CustomMessageListener(2921469) { // from class: com.baidu.tieba.frs.FrsFragment.60
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.z) && FrsFragment.this.isResumed()) {
                com.baidu.tbadk.core.data.z zVar = (com.baidu.tbadk.core.data.z) customResponsedMessage.getData();
                if (FrsFragment.this.jhy == null) {
                    FrsFragment.this.jhy = new com.baidu.tieba.frs.broadcast.a(FrsFragment.this.getPageContext());
                }
                if (FrsFragment.this.jfU != null && FrsFragment.this.jfU.getForum() != null && !TextUtils.isEmpty(FrsFragment.this.jfU.getForum().getId())) {
                    FrsFragment.this.jhy.e(zVar.type, FrsFragment.this.jfU.getForum().getId(), FrsFragment.this.jfU.getForum().getName(), zVar.tid);
                }
            }
        }
    };
    private CustomMessageListener jir = new CustomMessageListener(2921475) { // from class: com.baidu.tieba.frs.FrsFragment.61
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            cb cbVar = (cb) customResponsedMessage.getData();
            if (cbVar != null && FrsFragment.this.isResumed()) {
                FrsFragment.this.jgK = cbVar.getTid() + "";
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE_NUMBER);
                httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
                httpMessage.addParam("forum_id", cbVar.getFid());
                MessageManager.getInstance().sendMessage(httpMessage);
            }
        }
    };
    private HttpMessageListener jis = new HttpMessageListener(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE_NUMBER) { // from class: com.baidu.tieba.frs.FrsFragment.62
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if ((httpResponsedMessage instanceof ForumManagerRightsResMsg) && FrsFragment.this.isResumed()) {
                ForumManagerRightsResMsg forumManagerRightsResMsg = (ForumManagerRightsResMsg) httpResponsedMessage;
                if (forumManagerRightsResMsg.broadcastTotalCount - forumManagerRightsResMsg.broadcastUsedCount <= 0) {
                    new ScreenTopToast(FrsFragment.this.getContext()).Ve(FrsFragment.this.getString(R.string.frs_forum_bawu_send_broadcast_none_tip)).Vg(FrsFragment.this.getString(R.string.frs_recommend_fail_tip_btn)).an(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.62.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("_forumId", FrsFragment.this.jfU.getForum().getId());
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new com.baidu.tieba.tbadkCore.data.m(FrsFragment.this.getContext(), "ForumGradePage", hashMap)));
                        }
                    }).aR((ViewGroup) FrsFragment.this.mRootView.findViewById(R.id.frs));
                    return;
                }
                com.baidu.tbadk.core.util.p pVar = new com.baidu.tbadk.core.util.p(TbadkCoreApplication.getInst());
                pVar.ap(FrsFragment.this.jfU.getForum().getId(), FrsFragment.this.jfU.getForum().getName(), "6");
                pVar.AU(FrsFragment.this.jgK);
                pVar.start();
            }
        }
    };
    private CustomMessageListener jit = new CustomMessageListener(2921515) { // from class: com.baidu.tieba.frs.FrsFragment.63
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                com.baidu.tieba.NEGFeedBack.g gVar = (com.baidu.tieba.NEGFeedBack.g) customResponsedMessage.getData();
                if (FrsFragment.this.jfU == null || FrsFragment.this.jfU.getForum() == null || FrsFragment.this.jfU.getForum().getDeletedReasonInfo() == null) {
                    com.baidu.tieba.NEGFeedBack.d.a(0, FrsFragment.this.getPageContext(), gVar, null, FrsFragment.this.jfU.getUserData());
                    return;
                }
                com.baidu.tieba.NEGFeedBack.h hVar = new com.baidu.tieba.NEGFeedBack.h(FrsFragment.this.jfU.getForum().getDeletedReasonInfo().is_grays_cale_forum.intValue(), FrsFragment.this.jfU.getForum().getDeletedReasonInfo().is_boomgrow.intValue(), FrsFragment.this.jfU.forumRule != null ? FrsFragment.this.jfU.forumRule.has_forum_rule.intValue() : 0);
                hVar.eg(FrsFragment.this.jfU.getForum().getId(), FrsFragment.this.jfU.getForum().getName());
                hVar.setForumHeadUrl(FrsFragment.this.jfU.getForum().getImage_url());
                hVar.setUserLevel(FrsFragment.this.jfU.getForum().getUser_level());
                com.baidu.tieba.NEGFeedBack.d.a(hVar.bKA(), FrsFragment.this.getPageContext(), gVar, hVar, FrsFragment.this.jfU.getUserData());
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.frs.loadmore.a
    public /* bridge */ /* synthetic */ com.baidu.adp.base.f getPageContext() {
        return super.getPageContext();
    }

    public com.baidu.tieba.frs.entelechy.a.b cCs() {
        return this.jgV;
    }

    public com.baidu.adp.widget.ListView.w cCt() {
        return this.jii;
    }

    public com.baidu.tieba.frs.mc.d cCu() {
        return this.jgX;
    }

    public com.baidu.tieba.frs.smartsort.a cCv() {
        return this.jgR;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public FrsModelController cCw() {
        return this.jgN;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public com.baidu.tieba.frs.mc.c cCx() {
        return this.jgY;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public com.baidu.tieba.frs.vc.h cCy() {
        return this.jgO;
    }

    public FrsTabViewController cCz() {
        return this.jgP;
    }

    public at cCA() {
        return this.jgT;
    }

    public void qt(boolean z) {
        this.jhq = z;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public q cCB() {
        return this.jgv;
    }

    @Override // com.baidu.tieba.frs.as
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.as, com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.jgn;
    }

    public void setForumName(String str) {
        this.jgn = str;
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
        if (this.jgY == null) {
            return 1;
        }
        return this.jgY.getPn();
    }

    public int getPn() {
        if (this.jgY == null) {
            return 1;
        }
        return this.jgY.getPn();
    }

    public void setPn(int i) {
        if (this.jgY != null) {
            this.jgY.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.jgY != null) {
            this.jgY.setHasMore(i);
        }
    }

    public int cCC() {
        if (this.jgY == null) {
            return -1;
        }
        return this.jgY.cCC();
    }

    public boolean cCD() {
        return this.jgt;
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
            this.jgv.cDI();
            showNetRefreshView(this.jgv.cnu(), string, true);
        } else if (340001 == fVar.errorCode) {
            a(fVar, this.jfU.getRecm_forum_list());
        } else {
            if (com.baidu.tbadk.core.util.y.isEmpty(this.jfU.getThreadList())) {
                b(fVar);
            }
            if (cDj()) {
                setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds280));
            } else {
                setNetRefreshViewEmotionDefMarginTop();
            }
        }
    }

    public void a(View view, String str, boolean z, List<RecmForumInfo> list) {
        this.jgv.cDI();
        this.jgv.yH(8);
        if (this.jhg == null) {
            this.jhg = new com.baidu.tieba.frs.view.a(getPageContext(), getNetRefreshListener());
        }
        this.jhg.setSubText(str);
        this.jhg.setListData(list);
        this.jhg.attachView(view, z);
    }

    private void a(com.baidu.tieba.tbadkCore.f fVar, List<RecmForumInfo> list) {
        if (this.jgv != null) {
            this.jgv.cDI();
            this.jgv.setTitle(this.jgn);
            a(this.jgv.cnu(), fVar.errorMsg, true, list);
        }
    }

    private void b(com.baidu.tieba.tbadkCore.f fVar) {
        this.jgv.cDI();
        if (fVar.iQx) {
            showNetRefreshView(this.jgv.cnu(), TbadkCoreApplication.getInst().getString(R.string.net_error_text, new Object[]{fVar.errorMsg, Integer.valueOf(fVar.errorCode)}), true);
        } else {
            showNetRefreshView(this.jgv.cEp().cLK(), fVar.errorMsg, true);
        }
    }

    public void cCE() {
        hideLoadingView(this.jgv.cnu());
        this.jgv.bRI();
        if (this.jgv.cDG() instanceof com.baidu.tieba.frs.tab.c) {
            ((com.baidu.tieba.frs.tab.c) this.jgv.cDG()).cKp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCF() {
        if (cCC() == 0 && com.baidu.tbadk.core.util.y.isEmpty(this.jfU.getThreadListIds())) {
            if (com.baidu.tbadk.core.util.y.isEmpty(this.jfU.getThreadList())) {
                this.jgv.bSy();
            } else {
                this.jgv.WY();
            }
        } else if (com.baidu.tbadk.core.util.y.getCount(this.jfU.getThreadList()) > 3) {
            this.jgv.WX();
        } else {
            this.jgv.cEd();
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
            cCE();
            this.jgv.cDO();
            com.baidu.tieba.tbadkCore.f cJD = this.jgN.cJD();
            boolean isEmpty = com.baidu.tbadk.core.util.y.isEmpty(this.jfU.getThreadList());
            if (cJD != null && isEmpty) {
                if (this.jgN.cJF() != 0) {
                    this.jgN.cJK();
                    this.jgv.cDO();
                } else {
                    a(cJD);
                }
                this.jgv.aa(this.jfU.isStarForum(), false);
                return;
            }
            a(cJD);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(com.baidu.tieba.tbadkCore.m mVar) {
        if (mVar != null && mVar.getEntelechyTabInfo() != null && mVar.getEntelechyTabInfo().tab != null) {
            for (FrsTabInfo frsTabInfo : mVar.getEntelechyTabInfo().tab) {
                if (frsTabInfo.tab_id.intValue() == 502 && com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean("first_into_tab_profession", true)) {
                    return false;
                }
            }
        }
        return new com.baidu.tieba.frs.ad.f(getTbPageContext()).d(mVar);
    }

    public boolean cCG() {
        return cCH() && !cCI();
    }

    private boolean cCH() {
        if (cDg() == null) {
            return false;
        }
        FrsViewData cDg = cDg();
        com.baidu.tbadk.core.data.aa aaVar = null;
        if (cDg.getStar() != null && !StringUtils.isNull(cDg.getStar().dMO())) {
            aaVar = new com.baidu.tbadk.core.data.aa();
        } else if (cDg.getActivityHeadData() != null && com.baidu.tbadk.core.util.y.getCount(cDg.getActivityHeadData().blR()) >= 1) {
            aaVar = cDg.getActivityHeadData().blR().get(0);
        }
        return aaVar != null;
    }

    public boolean cCI() {
        if (cDg() == null) {
            return false;
        }
        FrsViewData cDg = cDg();
        return (com.baidu.tbadk.core.util.y.isEmpty(cDg.getShowTopThreadList()) && cDg.getBusinessPromot() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCJ() {
        boolean b2;
        if (!cCL()) {
            final PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
            privateForumPopInfoData.a(this.jfU.getPrivateForumTotalInfo().getPrivatePopInfo());
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(getActivity());
            if (this.jfU.getPrivateForumTotalInfo().bmM().private_forum_status.intValue() == 1 && (com.baidu.tbadk.core.util.au.isEmpty(privateForumPopInfoData.bmO()) || privateForumPopInfoData.bmR() != Integer.valueOf(this.forumId))) {
                privateForumPopInfoData.zW("create_success");
                privateForumPopInfoData.zX(TbadkCoreApplication.getInst().getString(R.string.frs_private_create_hint));
                privateForumPopInfoData.zY("https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.jgn + "&nomenu=1");
                privateForumPopInfoData.m(Integer.valueOf(this.forumId));
                b2 = frsPrivateCommonDialogView.b(privateForumPopInfoData);
            } else {
                b2 = privateForumPopInfoData.bmR() == Integer.valueOf(this.forumId) ? frsPrivateCommonDialogView.b(privateForumPopInfoData) : false;
            }
            if (b2) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
                aVar.nA(2);
                aVar.bn(frsPrivateCommonDialogView);
                aVar.jG(false);
                frsPrivateCommonDialogView.setConfirmButton(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.21
                    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.frs.FrsFragment */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        bf.bsV().b(FrsFragment.this.getPageContext(), new String[]{privateForumPopInfoData.bmQ()});
                        aVar.dismiss();
                    }
                });
                aVar.a(new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.22
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(getPageContext()).bqx();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCK() {
        if (cCL() || this.jfU.getPrivateForumTotalInfo().bmM().private_forum_status.intValue() != 1) {
            a((Integer) null, (Integer) null, true);
        } else {
            a(this.jfU.getPrivateForumTotalInfo().bmM().private_forum_audit_status, this.jfU.getPrivateForumTotalInfo().bmN(), false);
        }
    }

    public void a(Integer num, Integer num2, boolean z) {
        final int i = 2;
        if (this.jgv.cDU() != null) {
            TextView cDU = this.jgv.cDU();
            if (z) {
                cDU.setVisibility(8);
                return;
            }
            final String str = "";
            if (num.intValue() == 2) {
                cDU.setText("修改实名认证信息");
                cDU.setVisibility(0);
                str = "https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + this.forumId + "&nomenu=1";
            } else if (num2.intValue() >= 0 && num2.intValue() <= 100) {
                cDU.setText("目标已完成" + String.valueOf(num2) + "%");
                cDU.setVisibility(0);
                i = 1;
                str = "https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.jgn + "&nomenu=1";
            } else {
                cDU.setVisibility(8);
                i = 0;
            }
            cDU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.24
                /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13387").dR("fid", FrsFragment.this.forumId).dR("uid", TbadkCoreApplication.getCurrentAccount()).ap("obj_type", i));
                    bf.bsV().b(FrsFragment.this.getPageContext(), new String[]{str});
                }
            });
        }
    }

    private boolean cCL() {
        return this.jfU == null || this.jfU.getPrivateForumTotalInfo() == null || this.jfU.getPrivateForumTotalInfo().bmM() == null || this.jfU.getUserData().getIs_manager() != 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yw(int i) {
        List<WindowToast> list;
        if (TbadkCoreApplication.isLogin() && this.jfU != null && (list = this.jfU.mWindowToast) != null && list.size() > 0) {
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
    public void cCM() {
        if (getActivity() != null && getActivity().getIntent() != null) {
            String stringExtra = getActivity().getIntent().getStringExtra(FrsActivityConfig.KEY_ACHIEVEMENT_URL);
            if (!TextUtils.isEmpty(stringExtra)) {
                getActivity().getIntent().removeExtra(FrsActivityConfig.KEY_ACHIEVEMENT_URL);
                AchievementActivityConfig achievementActivityConfig = new AchievementActivityConfig(getActivity());
                achievementActivityConfig.setUrl(stringExtra);
                if (this.jfU != null && this.jfU.getForumActiveInfo() != null) {
                    achievementActivityConfig.setShareUrl(this.jfU.getForumActiveInfo().forum_share_url);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, achievementActivityConfig));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCN() {
        if (this.jfU == null || this.jfU.getForum() != null) {
            this.jgv.cEa();
        } else if (this.jfU.getForum().getYuleData() != null && this.jfU.getForum().getYuleData().bqn()) {
            TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_VIEW);
            this.jgv.a(this.jfU.getForum().getYuleData().bqo());
        } else {
            this.jgv.cEa();
        }
    }

    private void Y(boolean z, boolean z2) {
        if (this.jgN != null && this.jfU != null && this.jgv != null && z) {
            if (!this.jgN.cJR() && this.jgN.cJH() == 1) {
                if (!this.jgN.cJP()) {
                    this.jfU.addCardVideoInfoToThreadList();
                    this.jfU.addVideoInfoToThreadListInTenAndFifteenFloor();
                }
                boolean z3 = false;
                if (this.jgv.cEb().r(com.baidu.tieba.card.data.n.iBr)) {
                    z3 = this.jfU.addHotTopicDataToThreadList();
                }
                if (!z3) {
                    this.jfU.addFeedForumDataToThreadList();
                }
                if (TbadkCoreApplication.getInst().isRecAppExist() && !com.baidu.tieba.funad.a.cNu()) {
                    this.jfU.addRecommendAppToThreadList(this);
                }
                if (!this.jgv.cEb().r(cb.eQL)) {
                    this.jfU.removeAlaLiveThreadData();
                }
                this.jfU.addSchoolRecommendToThreadList();
            }
            if (!this.jgv.cEb().r(cb.eQL)) {
                this.jfU.removeAlaInsertLiveData();
                this.jfU.removeAlaStageLiveDat();
            } else {
                this.jfU.addInsertLiveDataToThreadList();
                this.jfU.addStageLiveDataToThreadList();
            }
            this.jfU.checkLiveStageInThreadList();
            this.jfU.addNoticeThreadToThreadList();
            if (this.jgv.cEb().r(com.baidu.tieba.i.b.jUq)) {
                this.jfU.addGameRankListToThreadList(z2);
            }
            if (TbadkCoreApplication.isLogin() && (!this.jgN.cJR() || this.jgN.isNetFirstLoad)) {
                this.jfU.addUserRecommendToThreadList();
            }
            this.jfU.addVideoActivityToTop();
        }
    }

    public boolean cCO() {
        if (this.jgO != null && this.jgN != null) {
            this.jgO.a(this.jgN.getPageType(), this.jfU);
        }
        boolean z = false;
        if (this.jfU != null) {
            z = this.jfU.hasTab();
        }
        cCR();
        if (this.jgv != null) {
            this.jgv.cEn();
            this.jgv.cEo();
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yx(int i) {
        ax axVar = null;
        cCO();
        cDb();
        try {
            if (this.jfU != null) {
                this.jgv.a((ArrayList<com.baidu.adp.widget.ListView.n>) null, this.jfU);
                this.jgO.Ay(1);
                this.jgv.cDR();
                this.jgP.a(this.jfU, this.jgN.cJM());
                com.baidu.tieba.frs.tab.d AH = this.jgP.AH(this.jfU.getFrsDefaultTabId());
                if (AH != null && !TextUtils.isEmpty(AH.url)) {
                    axVar = new ax();
                    axVar.ext = AH.url;
                    axVar.stType = AH.name;
                }
                this.jgN.a(this.jfU.getFrsDefaultTabId(), 0, axVar);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(boolean z, boolean z2) {
        try {
            if (this.jfU != null && this.jgP != null && this.jgN != null) {
                if (!this.jgv.cEb().r(cb.eQL)) {
                    this.jfU.removeAlaLiveThreadData();
                }
                boolean isEmpty = com.baidu.tbadk.core.util.y.isEmpty(this.jfU.getGameTabInfo());
                this.jgv.qD(isEmpty);
                if (!isEmpty) {
                    if (this.jhh == null) {
                        this.jhh = new com.baidu.tieba.frs.vc.e(this, (NoPressedRelativeLayout) this.mRootView);
                    }
                    if (this.gVV == null) {
                        this.gVV = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
                    }
                } else {
                    this.jhh = null;
                    this.gVV = null;
                }
                if (this.jfU.getForum() != null) {
                    this.jgn = this.jfU.getForum().getName();
                    this.forumId = this.jfU.getForum().getId();
                }
                if (this.jfU.hasTab()) {
                    this.jgP.a(this.jfU, this.jgN.cJM());
                }
                if (z) {
                    Y(true, z);
                } else {
                    Y(this.jgI, z);
                }
                cCO();
                if (this.jgV != null) {
                    this.jgV.a(this.jgO, this.jfU);
                }
                if (this.jfU.getPage() != null) {
                    setHasMore(this.jfU.getPage().bmF());
                }
                ArrayList<com.baidu.adp.widget.ListView.n> a2 = this.jgY.a(z2, true, this.jfU.getThreadList(), null, z, false);
                if (a2 != null) {
                    this.jfU.setThreadList(a2);
                }
                this.jfU.removeRedundantUserRecommendData();
                this.jfW = this.jfU.getTopThreadSize();
                if (this.jgr != null) {
                    this.jgq = true;
                    this.jgr.JA(this.jfW);
                    com.baidu.tieba.frs.d.a.a(this, this.jfU.getForum(), this.jfU.getThreadList(), this.jgq, getPn());
                }
                if (this.jgN.cJH() == 1) {
                    cCV();
                    if (!z && this.jgN.getPn() == 1) {
                        cCQ();
                    }
                }
                if (this.jgW != null) {
                    this.jgW.db(this.jgP.cLT());
                }
                cCE();
                this.jgv.cDJ();
                this.jgv.aa(true, false);
                if (z && this.jfU.isFirstTabEqualAllThread()) {
                    com.baidu.adp.lib.f.e.mA().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.25
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!FrsFragment.this.jgG && com.baidu.adp.lib.util.j.isNetWorkAvailable() && !FrsFragment.this.jgv.cEq()) {
                                FrsFragment.this.jgv.cEl();
                            }
                        }
                    });
                }
                if (this.jfU.getForum() != null) {
                    this.jgv.Ki(this.jfU.getForum().getWarningMsg());
                }
                if (this.jfU != null && this.jfU.getFrsVideoActivityData() != null && com.baidu.tbadk.core.sharedPref.b.brQ().getLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 0L) == 0) {
                    com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.26
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsFragment.this.jgv.cEj();
                        }
                    }, 1000L);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FRS_SHOW_AR_ENTRY, this));
                this.jgv.cDD();
                if (this.jfU != null && this.jfU.getForum() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ENTER_FORUM, new VisitedForumData(this.jfU.getForum().getId(), this.jfU.getForum().getName(), this.jfU.getForum().getImage_url(), String.valueOf(System.currentTimeMillis() / 1000), ConstantData.Forum.SPECAIL_FORUM_TYPE_LIVE.equals(this.jfU.getForum().special_forum_type), this.jfU.getForum().getThemeColorInfo(), this.jfU.getForum().getMember_num())));
                }
                this.jhl.a(this.jfU.bottomMenuList, this.jfU.getForum());
                cDq();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void cCP() {
        if (this.jgN != null && this.jgN.cJH() == 1) {
            this.jgO.k(this.jfU);
        }
    }

    public void qu(boolean z) {
        com.baidu.tieba.s.c.dMz().b(getUniqueId(), z);
    }

    public void cCQ() {
        if (this.jhb == null) {
            this.jhb = new com.baidu.tieba.frs.live.a(this, com.baidu.adp.lib.f.b.toInt(this.forumId, 0));
        }
        this.jhb.cJo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.tbadkCore.m mVar) {
        try {
            if (!this.jgG && mVar != null && this.jfU != null) {
                this.jfU.receiveData(mVar);
                Z(true, false);
                Looper.myQueue().addIdleHandler(this.jhB);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void cCR() {
        if (this.jgN != null) {
            Kf(this.jgN.getPageType());
        } else {
            Kf("normal_page");
        }
    }

    private void Kf(String str) {
        qv("frs_page".equals(str));
        if (this.jgV != null) {
            this.jgV.a(this.jgO, this.jgv, this.jfU);
        }
    }

    public void qv(boolean z) {
        if (this.jgZ != null) {
            this.jgZ.cLD();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.s.c.dMz().A(getUniqueId());
        registerResponsedEventListener(TopToastEvent.class, this.mTopToastEventListener);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.frs_activity, viewGroup, false);
            this.jgh = new com.baidu.tieba.frs.entelechy.a();
            this.jgV = this.jgh.cFZ();
            this.jgg = TbadkCoreApplication.getInst().getString(R.string.frs_title_new_area);
            this.jgO = new com.baidu.tieba.frs.vc.h(this, this.jgh, (FrsHeaderViewContainer) this.mRootView.findViewById(R.id.header_view_container));
            this.jgP = new FrsTabViewController(this, this.mRootView);
            this.jgP.registerListener();
            this.jgO.a(this.jgP);
            this.jgP.a(this.jhJ);
            Intent intent = getActivity().getIntent();
            if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                this.jgj = true;
            }
            this.jgv = new q(this, this.jig, this.jgh, this.jgj, this.jgO);
            this.jhl = new com.baidu.tieba.frs.brand.buttommenu.a(getPageContext(), this.mRootView);
        } else {
            if (this.mRootView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            if (this.jgP != null) {
                this.jgP.registerListener();
            }
            this.jgv.cEi();
            this.mRootView.setLeft(0);
            this.mRootView.setRight(com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getContext()));
        }
        this.jhp = true;
        this.fJm = System.currentTimeMillis() - currentTimeMillis;
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        ArrayList<com.baidu.adp.widget.ListView.n> arrayList = null;
        this.iJe = System.currentTimeMillis();
        long j = this.iJe;
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.jgs = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.iJe = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            S(intent);
        }
        this.fJl = j - this.iJe;
        this.jgr = new com.baidu.tieba.tbadkCore.data.f("frs", com.baidu.tieba.tbadkCore.data.f.nws);
        if (this.jgN == null) {
            this.jgN = new FrsModelController(this, this.jia);
            this.jgN.a(this.jhI);
            this.jgN.init();
        }
        this.jgN.setSchemeUrl(this.mSchemeUrl);
        if (intent != null) {
            this.jgN.aj(intent.getExtras());
        } else if (bundle != null) {
            this.jgN.aj(bundle);
        } else {
            this.jgN.aj(null);
        }
        if (intent != null) {
            this.jgO.as(intent.getExtras());
        } else if (bundle != null) {
            this.jgO.as(bundle);
        } else {
            this.jgO.as(null);
        }
        this.jgu = getVoiceManager();
        this.jhc = new p(getPageContext(), this);
        initUI();
        initData(bundle);
        if (!cDj()) {
            this.jgT = new at(getActivity(), this.jgv, this.jgO);
            this.jgT.qS(true);
        }
        this.jgu = getVoiceManager();
        if (this.jgu != null) {
            this.jgu.onCreate(getPageContext());
        }
        if (FrsActivityConfig.FRS_FROM_FLUTTER_BCASTEDIT.equals(getFrom()) && !this.hasInit) {
            int i = com.baidu.tbadk.core.sharedPref.b.brQ().getInt("key_forum_broadcast_edit_tip_number", 0);
            if (i < 2) {
                com.baidu.tbadk.core.sharedPref.b.brQ().putInt("key_forum_broadcast_edit_tip_number", i + 1);
                cCX();
            } else if (Build.VERSION.SDK_INT >= 23) {
                if (Settings.canDrawOverlays(getContext())) {
                    cCY();
                } else {
                    new BdTopToast(getContext()).zn(false).UZ(getContext().getString(R.string.forum_broadcast_copy_no_permission_hint)).aR(this.jgv.cnu());
                }
            } else {
                cCY();
            }
        }
        if (FrsActivityConfig.FRS_FROM_FORUM_RULE_EDIT.equals(getFrom()) && !this.hasInit) {
            if (Build.VERSION.SDK_INT >= 23) {
                if (Settings.canDrawOverlays(getContext())) {
                    cCZ();
                } else if (Build.VERSION.SDK_INT < 23 || !com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean("key_forum_rule_dialog_show_frs", false)) {
                    cCZ();
                    com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean("key_forum_rule_dialog_show_frs", true);
                }
            } else {
                cCZ();
            }
        }
        if (com.baidu.tbadk.k.d.bCB().bCC()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
            if (this.jgw != null) {
                this.jgw.setVisibility(8);
            }
        }
        new com.baidu.tieba.frs.mc.i();
        int i2 = -1;
        if (this.jgY != null && this.jgY.cJz() != null) {
            i2 = this.jgY.cJz().cCC();
            arrayList = this.jgY.cJz().getDataList();
        }
        this.jgY = new com.baidu.tieba.frs.mc.c(this, this.jie);
        this.jgY.cJz().setHasMore(i2);
        if (arrayList != null && arrayList.size() > 0) {
            this.jgY.cJz().aC(arrayList);
        }
        this.jgR = new com.baidu.tieba.frs.smartsort.a(this);
        this.jgZ = new com.baidu.tieba.frs.vc.j(this);
        this.jgW = new com.baidu.tieba.frs.vc.a(getPageContext(), this.jgN.cJO());
        this.jgS = new com.baidu.tieba.frs.mc.b(this);
        this.jgX = new com.baidu.tieba.frs.mc.d(this);
        this.jgQ = new com.baidu.tieba.frs.mc.h(this);
        this.jha = new com.baidu.tieba.frs.mc.a(this);
        this.jhd = new com.baidu.tieba.frs.vc.c(this);
        this.jhe = new com.baidu.tieba.frs.mc.e(this, getUniqueId());
        this.jhj = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "frs");
        this.jhk = new com.baidu.tieba.ala.b(getPageContext());
        this.jhm = new com.baidu.tieba.frs.sportspage.notification.a(getPageContext());
        registerListener(this.jhR);
        registerListener(this.mMemListener);
        registerListener(this.jhP);
        registerListener(this.jif);
        registerListener(this.jib);
        registerListener(this.jhL);
        registerListener(this.jhM);
        registerListener(this.jhN);
        registerListener(this.jhO);
        registerListener(this.jhC);
        registerListener(this.jhD);
        registerListener(this.ahl);
        registerListener(this.jhE);
        registerListener(this.jik);
        registerListener(this.jhT);
        this.jhU.setSelfListener(true);
        this.jhU.setTag(getPageContext().getUniqueId());
        registerListener(this.jhU);
        registerListener(this.jhH);
        registerListener(this.jhV);
        registerListener(this.jhS);
        registerListener(this.jhX);
        registerListener(this.jhY);
        registerListener(this.jhZ);
        this.jil.setTag(getPageContext().getUniqueId());
        MessageManager.getInstance().registerListener(this.jil);
        registerListener(this.jim);
        registerListener(this.jin);
        registerListener(this.jio);
        registerListener(this.jhG);
        registerListener(this.jip);
        registerListener(this.jhW);
        registerListener(this.jhF);
        registerListener(this.jiq);
        registerListener(this.jir);
        registerListener(this.jis);
        registerListener(this.jit);
        this.jgv.qF(false);
        if (!cDj() && !this.hasInit) {
            showLoadingView(this.jgv.cnu(), true);
            this.jgN.T(3, false);
        }
        av avVar = new av() { // from class: com.baidu.tieba.frs.FrsFragment.29
            @Override // com.baidu.tieba.frs.av
            public void g(boolean z, boolean z2, int i3) {
                if (FrsFragment.this.jgv != null) {
                    if (i3 == 1) {
                        FrsFragment.this.jgv.yI(z ? 0 : 8);
                    } else if (i3 == 2) {
                        FrsFragment.this.jgv.yK(z ? 0 : 8);
                    }
                    if (!z2) {
                        FrsFragment.this.jho = z;
                    }
                    if (FrsFragment.this.jgv.cEb() != null && (i3 == 2 || (FrsFragment.this.jgN != null && FrsFragment.this.jgN.cJI()))) {
                        FrsFragment.this.jgv.cEb().notifyDataSetChanged();
                    }
                    if (FrsFragment.this.cCz() != null) {
                        FrsTabViewController.b cLU = FrsFragment.this.cCz().cLU();
                        if (cLU != null) {
                            if ((cLU.fragment instanceof FrsCommonTabFragment) && (i3 == 2 || cLU.tabId == 502)) {
                                ((FrsCommonTabFragment) cLU.fragment).cFO();
                            } else if ((cLU.fragment instanceof FrsNewAreaFragment) && (i3 == 2 || cLU.tabId == 503)) {
                                FrsNewAreaFragment frsNewAreaFragment = (FrsNewAreaFragment) cLU.fragment;
                                frsNewAreaFragment.cFO();
                                if (frsNewAreaFragment.cJZ() != null) {
                                    com.baidu.tieba.frs.mc.g cJZ = frsNewAreaFragment.cJZ();
                                    cJZ.qU(!z);
                                    if (i3 == 1) {
                                        cJZ.qI(!z);
                                    } else if (i3 == 2) {
                                        cJZ.qI(true);
                                    }
                                }
                            } else if (cLU.fragment instanceof FrsGoodFragment) {
                                ((FrsGoodFragment) cLU.fragment).cFO();
                            }
                        }
                        if (FrsFragment.this.cCz().cLL() != null) {
                            FrsFragment.this.cCz().cLL().setmDisallowSlip(z);
                            FrsFragment.this.cCz().rE(z);
                        }
                    }
                    if (FrsFragment.this.jgv.cDH() != null) {
                        FrsFragment.this.jgv.qC(!z);
                    }
                    if (FrsFragment.this.getActivity() instanceof FrsActivity) {
                        ((FrsActivity) FrsFragment.this.getActivity()).qs(!z);
                    }
                    if (FrsFragment.this.jhl != null) {
                        FrsFragment.this.jhl.ra(!z);
                    }
                    FrsFragment.this.jgv.qH(!z);
                    if (i3 == 1) {
                        FrsFragment.this.jgv.qI(z ? false : true);
                    } else if (i3 == 2) {
                        FrsFragment.this.jgv.qI(true);
                    }
                }
            }

            @Override // com.baidu.tieba.frs.av
            public void cm(int i3, int i4) {
                if (FrsFragment.this.jgv != null) {
                    if (i4 == 1) {
                        FrsFragment.this.jgv.yJ(i3);
                    } else if (i4 == 2) {
                        FrsFragment.this.jgv.yL(i3);
                    }
                }
            }

            @Override // com.baidu.tieba.frs.av
            public void yB(int i3) {
                if (FrsFragment.this.getContext() != null) {
                    if (i3 == 1) {
                        com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getContext(), R.string.frs_multi_delete_max_num);
                    } else if (i3 == 2 && FrsFragment.this.jgv != null) {
                        new BdTopToast(FrsFragment.this.getContext()).zn(false).UZ(FrsFragment.this.getContext().getString(R.string.frs_move_area_max_num)).aR(FrsFragment.this.jgv.cnu());
                    }
                }
            }
        };
        b.cBy().a(avVar);
        com.baidu.tieba.frs.a.cBr().a(avVar);
        this.jgv.b(new e.a() { // from class: com.baidu.tieba.frs.FrsFragment.30
            @Override // com.baidu.tieba.NEGFeedBack.e.a
            public void a(DeleteThreadHttpResponseMessage deleteThreadHttpResponseMessage) {
                boolean z;
                int i3 = 0;
                if (deleteThreadHttpResponseMessage != null) {
                    FrsFragment.this.jgv.bKq();
                    FrsFragment.this.jgv.cEk();
                    FrsNewAreaFragment frsNewAreaFragment = null;
                    if (FrsFragment.this.jgP == null || FrsFragment.this.jgP.cLU() == null || !(FrsFragment.this.jgP.cLU().fragment instanceof FrsNewAreaFragment)) {
                        z = false;
                    } else {
                        frsNewAreaFragment = (FrsNewAreaFragment) FrsFragment.this.jgP.cLU().fragment;
                        z = true;
                    }
                    if (deleteThreadHttpResponseMessage.getError() == 0) {
                        String text = !TextUtils.isEmpty(deleteThreadHttpResponseMessage.getText()) ? deleteThreadHttpResponseMessage.getText() : FrsFragment.this.getString(R.string.delete_fail);
                        if (deleteThreadHttpResponseMessage.getRetType() == 1211066) {
                            if (FrsFragment.this.izC == null) {
                                FrsFragment.this.izC = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.izC.Au(text);
                            FrsFragment.this.izC.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.30.1
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.izC.jG(false);
                            FrsFragment.this.izC.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.izC.bqx();
                        } else if (deleteThreadHttpResponseMessage.getRetType() == 1211067) {
                            if (FrsFragment.this.izC == null) {
                                FrsFragment.this.izC = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.izC.Au(text);
                            FrsFragment.this.izC.a(R.string.know, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.30.2
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.izC.jG(false);
                            FrsFragment.this.izC.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.izC.bqx();
                        } else {
                            FrsFragment.this.jgv.aX(deleteThreadHttpResponseMessage.getText(), ContextCompat.getColor(FrsFragment.this.getContext(), deleteThreadHttpResponseMessage.getRetType() == 1 ? R.color.nav_bar_tip_error : R.color.cp_link_tip_a_alpha95));
                        }
                        if (z && frsNewAreaFragment != null) {
                            frsNewAreaFragment.dB(deleteThreadHttpResponseMessage.getSuccessItems());
                        }
                        FrsFragment.this.dj(deleteThreadHttpResponseMessage.getSuccessItems());
                        b.cBy().di(deleteThreadHttpResponseMessage.getSuccessItems());
                        for (com.baidu.adp.widget.ListView.n nVar : FrsFragment.this.jfU.getThreadList()) {
                            if (nVar instanceof ca) {
                                i3++;
                                continue;
                            }
                            if (i3 >= 6) {
                                break;
                            }
                        }
                        if (i3 < 6) {
                            FrsFragment.this.bRj();
                            return;
                        }
                        return;
                    }
                    com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getActivity(), deleteThreadHttpResponseMessage.getErrorString());
                }
            }
        });
        this.dVi = UtilHelper.getScreenHeight(getActivity());
        this.hasInit = true;
        yy(1);
        super.onActivityCreated(bundle);
        this.createTime = System.currentTimeMillis() - j;
    }

    public void qw(boolean z) {
        if (this.jgP != null) {
            this.jgP.jLU = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dj(List<String> list) {
        if (!com.baidu.tbadk.core.util.y.isEmpty(list)) {
            ArrayList<com.baidu.adp.widget.ListView.n> threadList = this.jfU.getThreadList();
            if (!com.baidu.tbadk.core.util.y.isEmpty(threadList) && this.jgv.getListView() != null && this.jgv.getListView().getData() != null) {
                Iterator<com.baidu.adp.widget.ListView.n> it = threadList.iterator();
                List<com.baidu.adp.widget.ListView.n> data = this.jgv.getListView().getData();
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.n next = it.next();
                    if (next instanceof ca) {
                        cb cbVar = ((ca) next).eJQ;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= list.size()) {
                                break;
                            } else if (!com.baidu.tbadk.core.util.au.equals(list.get(i2), cbVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.jgY.d(next);
                                this.jgv.getListView().getAdapter().notifyItemRemoved(i);
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
    public void cBw() {
        if (!com.baidu.tbadk.core.util.y.isEmpty(com.baidu.tieba.frs.a.cBr().cBv()) && this.jgv.getListView() != null && this.jgv.getListView().getData() != null) {
            ArrayList<com.baidu.adp.widget.ListView.n> threadList = this.jfU.getThreadList();
            if (!com.baidu.tbadk.core.util.y.isEmpty(threadList)) {
                Iterator<com.baidu.adp.widget.ListView.n> it = threadList.iterator();
                List<com.baidu.adp.widget.ListView.n> data = this.jgv.getListView().getData();
                int count = com.baidu.tbadk.core.util.y.getCount(com.baidu.tieba.frs.a.cBr().cBv());
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.n next = it.next();
                    if (next instanceof ca) {
                        cb cbVar = ((ca) next).eJQ;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= count) {
                                break;
                            } else if (!com.baidu.tbadk.core.util.au.equals(com.baidu.tieba.frs.a.cBr().cBv().get(i2).getId(), cbVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.jgY.d(next);
                                this.jgv.getListView().getAdapter().notifyItemRemoved(i);
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
    public void bRD() {
        if (isAdded() && this.gDp && !isLoadingViewAttached()) {
            showLoadingView(this.jgv.cnu(), true);
        }
    }

    @Override // com.baidu.tieba.frs.am
    public void bRE() {
        if (isAdded() && this.gDp && isLoadingViewAttached()) {
            hideLoadingView(this.jgv.cnu());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (cDj()) {
            showLoadingView(this.jgv.cnu(), true);
            this.jgv.yM(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.jgN.S(3, true);
            getListView().scrollToPosition(0);
        }
    }

    private void yy(int i) {
        String str = "";
        if (this.jfU != null && this.jfU.getForum() != null) {
            str = this.jfU.getForum().getId();
        }
        if (!StringUtils.isNull(str)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13008").dR("fid", str).dR("obj_type", "4").ap("obj_locate", i).dR("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    @Override // com.baidu.tieba.frs.am
    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.aa aaVar) {
        if (aaVar != null) {
            this.fNk = aaVar.bFF();
            this.jhf = aaVar.bFG();
        }
    }

    @Override // com.baidu.tieba.frs.am
    public void showFloatingView() {
        if (this.fNk != null) {
            this.fNk.lc(true);
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
                this.jgn = uri.getQueryParameter("name");
                this.mFrom = uri.getQueryParameter("from");
                if (!StringUtils.isNull(this.jgn)) {
                    intent.putExtra("name", this.jgn);
                }
                if (!StringUtils.isNull(this.mFrom)) {
                    intent.putExtra("from", this.mFrom);
                }
                TiebaStatic.log(TbadkCoreStatisticKey.AS_INVOKE_TIEBA);
            }
            if (StringUtils.isNull(this.jgn) && uri != null) {
                if (com.baidu.tbadk.BdToken.f.r(uri)) {
                    com.baidu.tbadk.BdToken.f.bhH().b(uri, this.jic);
                } else {
                    com.baidu.tieba.frs.d.g V = com.baidu.tieba.frs.d.l.V(intent);
                    if (V != null) {
                        this.jgn = V.forumName;
                        if (V.jJy == null || V.jJy.equals("aidou")) {
                        }
                    }
                }
                if (!StringUtils.isNull(this.jgn)) {
                    intent.putExtra("name", this.jgn);
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
                if (hashMap.get(com.baidu.tbadk.BdToken.f.eDL) instanceof String) {
                    FrsFragment.this.jgn = (String) hashMap.get(com.baidu.tbadk.BdToken.f.eDL);
                }
                if ((hashMap.get(com.baidu.tbadk.BdToken.f.eEd) instanceof String) && !TextUtils.isEmpty((String) hashMap.get(com.baidu.tbadk.BdToken.f.eEd))) {
                    com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.31.1
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsFragment.this.jgP.sT(301);
                            final long j = com.baidu.adp.lib.f.b.toLong((String) hashMap.get(com.baidu.tbadk.BdToken.f.eDM), 0L);
                            final int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
                            final int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
                            final float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                            final int i = 1;
                            if (com.baidu.tbadk.core.util.av.bsS().bsT()) {
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
        this.jgu = getVoiceManager();
        if (this.jgu != null) {
            this.jgu.onStart(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        Intent intent;
        long j = 0;
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.fsV);
        if (bundle != null) {
            this.jgn = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            j = bundle.getLong(FrsActivityConfig.FRS_FAKE_THREAD_ID, 0L);
        } else if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
            this.jgn = intent.getStringExtra("name");
            this.mFrom = intent.getStringExtra("from");
            this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
            j = intent.getLongExtra(FrsActivityConfig.FRS_FAKE_THREAD_ID, 0L);
        }
        if (getArguments() != null) {
            this.jgo = getArguments().getBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, false);
        }
        if (TextUtils.isEmpty(this.mFrom) || FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
        }
        if (this.mIsLogin) {
            registerListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL, this.fsV);
        }
        this.jgO.as(bundle);
        gq(j);
    }

    private void gq(final long j) {
        if (j > 0) {
            final int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
            final int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
            final float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            final int i = 1;
            if (com.baidu.tbadk.core.util.av.bsS().bsT()) {
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
        com.baidu.tieba.s.c.dMz().B(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.jik);
        MessageManager.getInstance().unRegisterListener(this.jhU);
        unRegisterResponsedEventListener();
        this.jgZ.destroy();
        jgz = null;
        if (this.jgu != null) {
            this.jgu.onDestory(getPageContext());
        }
        com.baidu.tieba.recapp.report.a.remove("FRS");
        this.jgu = null;
        com.baidu.tieba.card.t.csB().pB(false);
        if (this.jfU != null && this.jfU.getForum() != null) {
            ag.cEL().gr(com.baidu.adp.lib.f.b.toLong(this.jfU.getForum().getId(), 0L));
        }
        if (this.jhb != null) {
            this.jhb.onDestory();
        }
        if (this.jgv != null) {
            com.baidu.tieba.frs.d.k.a(this.jgv, this.jfU, getForumId(), false, null);
            this.jgv.onDestroy();
        }
        if (this.jgy != null) {
            this.jgy.removeAllViews();
            this.jgy.setVisibility(8);
        }
        if (this.jhv != null) {
            this.jhv.cancel();
        }
        if (this.jhw != null) {
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.jhw);
        }
        this.jhu = null;
        super.onDestroy();
        try {
            if (this.jgH != null) {
                this.jgH.bEa();
            }
            if (this.jgv != null) {
                this.jgv.release();
            }
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.jgO.cJg();
        Looper.myQueue().removeIdleHandler(this.jhB);
        if (this.jgN != null) {
            this.jgN.bYU();
        }
        if (this.jgT != null) {
            this.jgT.cET();
        }
        if (this.jgW != null) {
            this.jgW.destory();
        }
        if (this.jgR != null) {
            this.jgR.onDestroy();
        }
        if (this.jhh != null) {
            this.jhh.onDestory();
        }
        if (this.jha != null) {
            this.jha.onDestroy();
        }
        if (this.jhj != null) {
            this.jhj.onDestroy();
        }
        if (this.jhk != null) {
            this.jhk.onDestroy();
        }
        com.baidu.tieba.recapp.c.a.dEm().dEp();
        com.baidu.tieba.frs.d.m.cKK();
        if (this.jgP != null) {
            this.jgP.a((FrsTabViewController.a) null);
            this.jgP.cLW();
        }
        if (this.jhn != null) {
            this.jhn.onDestroy();
        }
        b.cBy().a(null);
        com.baidu.tieba.frs.a.cBr().a(null);
        if (this.jhA != null) {
            this.jhA.cKI();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.jgn);
        bundle.putString("from", this.mFrom);
        this.jgN.onSaveInstanceState(bundle);
        if (this.jgu != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            this.jgu.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.jha != null) {
            this.jha.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.jgv != null) {
            this.jgv.cDO();
            this.jgv.onResume();
        }
        this.jgQ.rv(true);
        this.jgI = true;
        if (jgm) {
            jgm = false;
            if (this.jgv != null) {
                this.jgv.startPullRefresh();
                return;
            }
            return;
        }
        if (this.jgu != null) {
            this.jgu.onResume(getPageContext());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_RESUME));
        if (this.jgv != null) {
            this.jgv.qJ(false);
        }
        if (this.jhi) {
            refresh(6);
            this.jhi = false;
        }
        if (this.jhr != null && getActivity() != null) {
            if (NotificationManagerCompat.from(getActivity()).areNotificationsEnabled()) {
                com.baidu.tbadk.coreExtra.messageCenter.f.byA().setSignAlertOn(true);
                com.baidu.tbadk.coreExtra.messageCenter.f.byA().setSignAlertTime(this.jhr.getHours(), this.jhr.getMinutes());
                if (this.jgv != null) {
                    com.baidu.tbadk.coreExtra.messageCenter.f.byA().a(getTbPageContext().getPageActivity(), this.jgv.cnu());
                }
            }
            this.jhr = null;
        }
        cDq();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
    }

    public boolean cCS() {
        Intent intent;
        if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
            return false;
        }
        return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
    }

    public void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.jgn = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.jgp = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.jgp) {
                cCT();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCT() {
        this.jgv.startPullRefresh();
    }

    public void closeActivity() {
        com.baidu.tieba.frs.d.l.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.mFrom);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.jgv.setTitle(this.jgn);
        } else {
            this.jgv.setTitle("");
            this.mFlag = 1;
        }
        this.jgv.a(this.jii);
        this.jgv.addOnScrollListener(this.mScrollListener);
        this.jgv.g(this.jdH);
        this.jgv.cEb().a(this.jih);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jhp) {
            this.jgv.onChangeSkinType(i);
            this.jgO.Ax(i);
            this.jgP.onChangeSkinType(i);
            if (this.jgx != null) {
                this.jgx.onChangeSkinType(i);
            }
            if (this.jhg != null) {
                this.jhg.onChangeSkinType();
            }
            if (this.jhl != null) {
                this.jhl.onChangeSkinType(getPageContext(), i);
            }
            if (this.izC != null) {
                com.baidu.tbadk.r.a.a(getPageContext(), this.izC.getRealView());
            }
            if (this.jhh != null) {
                this.jhh.onChangeSkinType(getPageContext(), i);
            }
        }
    }

    public void yz(int i) {
        if (!this.mIsLogin) {
            if (this.jfU != null && this.jfU.getAnti() != null) {
                this.jfU.getAnti().setIfpost(1);
            }
            if (i == 0) {
                bh.skipToLoginActivity(getActivity());
            }
        } else if (this.jfU != null) {
            if (i == 0) {
                com.baidu.tieba.frs.d.m.g(this, 0);
            } else {
                this.jgv.cDQ();
            }
        }
    }

    public void refresh() {
        com.baidu.tieba.a.d.bKU().Ev("page_frs");
        refresh(3);
    }

    public void refresh(int i) {
        this.jgG = false;
        cDb();
        if (this.jgv != null && this.jgv.cDF() != null) {
            this.jgv.cDF().cQB();
        }
        if (this.jgN != null) {
            this.jgN.S(i, true);
        }
    }

    private void cCU() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.f.h.mB().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.37
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.TG(FrsFragment.this.jgn);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCV() {
        cDb();
        try {
            if (this.jfU != null) {
                this.jgv.bYo();
                this.jgv.qC(cDp());
                if (!com.baidu.tieba.frs.vc.h.n(this.jfU) || !com.baidu.tieba.frs.vc.h.m(this.jfU)) {
                }
                if (this.jfU.getForum() != null) {
                    this.jgn = this.jfU.getForum().getName();
                    this.forumId = this.jfU.getForum().getId();
                }
                if (this.jfU.getPage() != null) {
                    setHasMore(this.jfU.getPage().bmF());
                }
                this.jgv.setTitle(this.jgn);
                this.jgv.setForumName(this.jgn);
                TbadkCoreApplication.getInst().setDefaultBubble(this.jfU.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.jfU.getUserData().getBimg_end_time());
                cCU();
                cCW();
                ArrayList<com.baidu.adp.widget.ListView.n> threadList = this.jfU.getThreadList();
                if (threadList != null) {
                    this.jgv.a(threadList, this.jfU);
                    com.baidu.tieba.frs.d.c.A(this.jgv);
                    this.jgO.Ay(getPageNum());
                    this.jgO.j(this.jfU);
                    this.jgP.a(this.jfU, this.jgN.cJM());
                    this.jgv.cDR();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void cCW() {
        if (this.jfU != null) {
            if (this.jfU.getIsNewUrl() == 1) {
                this.jgv.cEb().setFromCDN(true);
            } else {
                this.jgv.cEb().setFromCDN(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.jgQ.rv(false);
        this.jgI = false;
        this.jgv.onPause();
        if (this.jgu != null) {
            this.jgu.onPause(getPageContext());
        }
        this.jgv.qJ(true);
        if (this.jgW != null) {
            this.jgW.cKN();
        }
        com.baidu.tbadk.BdToken.c.bhn().bhy();
        if (this.jhA != null) {
            this.jhA.cKI();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.jgP != null && this.jgP.cLU() != null && (this.jgP.cLU().fragment instanceof BaseFragment)) {
            ((BaseFragment) this.jgP.cLU().fragment).setPrimary(z);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.t.csB().pB(false);
        qu(false);
        if (this.jfU != null && this.jfU.getForum() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            com.baidu.tbadk.distribute.a.bAU().b(getPageContext().getPageActivity(), "frs", this.jfU.getForum().getId(), 0L);
        }
        if (this.jgu != null) {
            this.jgu.onStop(getPageContext());
        }
        if (getListView() != null) {
            getListView().getRecycledViewPool().clear();
        }
        this.jgO.btX();
        com.baidu.tbadk.util.ab.bFI();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            if (this.jgO != null) {
                this.jgO.cb(isPrimary());
            }
            if (this.jgv != null) {
                this.jgv.cb(isPrimary());
                this.jgv.qJ(!isPrimary());
            }
        }
    }

    private void cCX() {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.nA(2);
        aVar.jG(false);
        FrsBroadcastCopyGuideDialogView frsBroadcastCopyGuideDialogView = new FrsBroadcastCopyGuideDialogView(getPageContext().getPageActivity());
        frsBroadcastCopyGuideDialogView.setConfirmButtonListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.38
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aVar != null) {
                    aVar.dismiss();
                    FrsFragment.this.cCY();
                }
            }
        });
        aVar.bn(frsBroadcastCopyGuideDialogView);
        aVar.b(getPageContext()).bqx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCY() {
        com.baidu.tbadk.k.d.bCB().a(new com.baidu.tbadk.k.a(getContext()));
        com.baidu.tbadk.k.d.bCB().C(85, 0, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds144));
        if (com.baidu.tbadk.k.d.bCB().init()) {
            ((BaseFragmentActivity) getPageContext().getOrignalPage()).grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.frs.FrsFragment.39
                @Override // com.baidu.tbadk.core.e
                public void onPermissionResult(boolean z) {
                    if (!z) {
                        new BdTopToast(FrsFragment.this.getContext()).zn(false).UZ(FrsFragment.this.getContext().getString(R.string.forum_broadcast_copy_no_permission_hint)).aR(FrsFragment.this.jgv.cnu());
                        return;
                    }
                    com.baidu.tbadk.k.d.bCB().lc(true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                    if (FrsFragment.this.jgw != null) {
                        FrsFragment.this.jgw.setVisibility(8);
                    }
                }
            }, true);
        }
    }

    private void cCZ() {
        com.baidu.tbadk.k.d.bCB().a(new com.baidu.tbadk.k.b(getContext()));
        com.baidu.tbadk.k.d.bCB().C(85, 0, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds144));
        if (com.baidu.tbadk.k.d.bCB().init()) {
            ((BaseFragmentActivity) getPageContext().getOrignalPage()).grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.frs.FrsFragment.40
                @Override // com.baidu.tbadk.core.e
                public void onPermissionResult(boolean z) {
                    if (z) {
                        com.baidu.tbadk.k.d.bCB().lc(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                        if (FrsFragment.this.jgw != null) {
                            FrsFragment.this.jgw.setVisibility(8);
                        }
                    }
                }
            }, true);
        }
    }

    public void Kg(String str) {
        new BdTopToast(getContext(), 3000).zn(true).UZ(str).aR(this.jgv.cnu());
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (b.cBy().cBs()) {
                b.cBy().reset();
                return true;
            } else if (com.baidu.tieba.frs.a.cBr().cBs()) {
                if (this.jgv != null && this.jgv.cEf()) {
                    this.jgv.cEg();
                    return true;
                }
                com.baidu.tieba.frs.a.cBr().reset();
                return true;
            } else if (this.jgv != null) {
                return this.jgv.cDN();
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
        com.baidu.tbadk.distribute.a.bAU().a(advertAppInfo, this.forumId, 0L, "FRS", str, getPn());
    }

    @Override // com.baidu.tieba.recapp.q
    public void cDa() {
        cCw().cDa();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.jgu == null) {
            this.jgu = VoiceManager.instance();
        }
        return this.jgu;
    }

    public BdRecyclerView getListView() {
        if (this.jgv == null) {
            return null;
        }
        return this.jgv.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void cDb() {
        if (this.jgu != null) {
            this.jgu.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.a
    public com.baidu.adp.lib.d.b<TbImageView> buM() {
        if (this.flN == null) {
            this.flN = UserIconBox.E(getPageContext().getPageActivity(), 8);
        }
        return this.flN;
    }

    public void cDc() {
        if (getFragmentActivity() != null && getFragmentActivity().getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.q onGetPreLoadListView() {
        return getListView().getPreLoadHandle();
    }

    @Override // com.baidu.tieba.frs.ap
    public NavigationBar bVk() {
        if (this.jgv == null) {
            return null;
        }
        return this.jgv.bVk();
    }

    public FRSRefreshButton cDd() {
        return this.jgx;
    }

    public void c(LinearLayout linearLayout) {
        if (linearLayout != null) {
            this.jgy = linearLayout;
        }
    }

    public void a(FRSRefreshButton fRSRefreshButton) {
        if (fRSRefreshButton != null) {
            this.jgx = fRSRefreshButton;
            this.jgx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.47
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (FrsFragment.this.jgP != null) {
                        FrsTabViewController.b cLU = FrsFragment.this.jgP.cLU();
                        if (cLU != null && cLU.fragment != null && (cLU.fragment instanceof ao)) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                            ((ao) cLU.fragment).cCg();
                            ((ao) cLU.fragment).bSx();
                            return;
                        }
                        FrsFragment.this.cCB().startPullRefresh();
                    }
                }
            });
        }
    }

    public void cDe() {
        if (this.jgx != null) {
            this.jgx.hide();
        }
    }

    public void cDf() {
        if (this.jgx != null) {
            this.jgx.show();
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
                if (bdUniqueId == u.jkk) {
                    if (FrsFragment.this.jgv != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11752").dR("fid", FrsFragment.this.forumId).dR("obj_locate", "1"));
                        FrsFragment.this.jgv.startPullRefresh();
                    }
                } else if (nVar != null && (nVar instanceof ca)) {
                    cb cbVar = ((ca) nVar).eJQ;
                    if (cbVar.boR() == null || cbVar.boR().getGroup_id() == 0 || bh.checkUpIsLogin(FrsFragment.this.getActivity())) {
                        if (cbVar.boC() != 1 || bh.checkUpIsLogin(FrsFragment.this.getActivity())) {
                            if (cbVar.boc() != null) {
                                if (bh.checkUpIsLogin(FrsFragment.this.getActivity())) {
                                    String postUrl = cbVar.boc().getPostUrl();
                                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.isNetOk()) {
                                        com.baidu.tbadk.browser.a.startInternalWebActivity(FrsFragment.this.getActivity(), postUrl);
                                    }
                                }
                            } else if (cbVar.bpc() != null) {
                                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                    bh.skipToLoginActivity(FrsFragment.this.getPageContext().getPageActivity());
                                    return;
                                }
                                com.baidu.tbadk.core.data.t bpc = cbVar.bpc();
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), bpc.getCartoonId(), bpc.getChapterId(), 2)));
                            } else {
                                com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                                if (readThreadHistory != null && !readThreadHistory.TM(cbVar.getId())) {
                                    readThreadHistory.TL(cbVar.getId());
                                }
                                boolean z = false;
                                final String bnW = cbVar.bnW();
                                if (bnW != null && !bnW.equals("")) {
                                    z = true;
                                    new Thread(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.a.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            com.baidu.tbadk.core.util.aa aaVar = new com.baidu.tbadk.core.util.aa(bnW);
                                            aaVar.bsr().bta().mIsNeedAddCommenParam = false;
                                            aaVar.bsr().bta().mIsUseCurrentBDUSS = false;
                                            aaVar.getNetData();
                                        }
                                    }).start();
                                }
                                String tid = cbVar.getTid();
                                if (tid == null) {
                                    tid = "";
                                }
                                if (cbVar.bnL() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                    bf.bsV().b(FrsFragment.this.getPageContext(), new String[]{tid, "", null});
                                    return;
                                }
                                if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && tid.length() > 4) {
                                    cbVar.setId(tid.substring(3));
                                }
                                if (bdUniqueId.getId() == cb.eSp.getId()) {
                                    com.baidu.tieba.frs.d.k.a(cbVar.bnw());
                                } else if (bdUniqueId.getId() == cb.eQP.getId()) {
                                    com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                                    arVar.dR("obj_type", "2");
                                    arVar.dR("tid", cbVar.getTid());
                                    TiebaStatic.log(arVar);
                                }
                                com.baidu.tieba.frs.d.l.a(FrsFragment.this, cbVar, i, z);
                                com.baidu.tieba.frs.d.k.a(FrsFragment.this, FrsFragment.this.jfU, cbVar);
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
            hideNetRefreshView(this.jgv.cEp().cLK());
            showLoadingView(this.jgv.cnu(), true);
            this.jgv.qF(false);
            this.jgN.S(3, true);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData cDg() {
        return this.jfU;
    }

    public boolean cDh() {
        return this.jgv.cDh();
    }

    public void aK(Object obj) {
        if (this.jgS != null && this.jgS.jES != null) {
            this.jgS.jES.callback(obj);
        }
    }

    public void aL(Object obj) {
        if (this.jgS != null && this.jgS.jET != null) {
            this.jgS.jET.callback(obj);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        this.jgv.getListView().stopScroll();
        if (!this.jgv.cDX()) {
            if (!com.baidu.adp.lib.util.l.isNetOk()) {
                this.jgv.bSy();
            } else if (this.jgN.cJH() == 1) {
                bRy();
                bRj();
            } else if (this.jgN.hasMore()) {
                bRj();
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void onFailed(String str) {
        bRy();
        showToast(str);
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void at(ArrayList<com.baidu.adp.widget.ListView.n> arrayList) {
        boolean isEmpty = com.baidu.tbadk.core.util.y.isEmpty(arrayList);
        setHasMore(isEmpty ? 0 : 1);
        bRy();
        if (!isEmpty) {
            if (!this.jgN.cJR() && TbadkCoreApplication.getInst().isRecAppExist() && this.jgN.cJH() == 1 && !com.baidu.tieba.funad.a.cNu()) {
                this.jfU.addRecommendAppToThreadList(this, arrayList);
            }
            if (this.jgN != null) {
                com.baidu.tieba.frs.b.a.a(getUniqueId(), arrayList, this.jfU.getForum(), this.jgN.getSortType());
            }
            ArrayList<com.baidu.adp.widget.ListView.n> a2 = this.jgY.a(false, false, arrayList, this.jgr, false);
            if (a2 != null) {
                this.jfU.setThreadList(a2);
                this.jgv.a(a2, this.jfU);
            }
            if (this.jgN != null) {
                com.baidu.tieba.frs.b.c.a(this.jfU, this.jgN.cJM(), 2, getContext());
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.jfU.getForum()));
        }
    }

    private void bRy() {
        if (cCC() == 1 || this.jgY.dA(this.jfU.getThreadListIds())) {
            if (com.baidu.tbadk.core.util.y.getCount(this.jfU.getThreadList()) > 3) {
                this.jgv.WX();
            } else {
                this.jgv.cEd();
            }
        } else if (com.baidu.tbadk.core.util.y.isEmpty(this.jfU.getThreadList())) {
            this.jgv.bSy();
        } else {
            this.jgv.WY();
        }
    }

    @Override // com.baidu.tieba.frs.mc.l
    public void bRj() {
        if (this.jgY != null) {
            this.jgY.a(this.jgn, this.forumId, this.jfU);
        }
    }

    public void cDi() {
        if (!com.baidu.tbadk.core.util.ae.requestWriteExternalStorgeAndCameraPermission(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.ao.g(getPageContext());
        }
    }

    @Override // androidx.fragment.app.Fragment, com.baidu.l.a.a.InterfaceC0148a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        com.baidu.tieba.frs.d.l.a(this, i, strArr, iArr);
    }

    public void qx(boolean z) {
        if (this.jgT != null) {
            this.jgT.qS(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.jgU.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a sM(int i) {
        return this.jgU.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        this.jhc.b(bVar);
    }

    public boolean cDj() {
        return this.jgj;
    }

    @Override // com.baidu.tieba.frs.am
    public void Ut() {
        if (this.jgv != null) {
            showFloatingView();
            this.jgv.getListView().scrollToPosition(0);
            this.jgv.startPullRefresh();
        }
    }

    public ForumWriteData cDk() {
        if (this.jfU == null || this.jfU.getForum() == null) {
            return null;
        }
        ForumData forum = this.jfU.getForum();
        ForumWriteData forumWriteData = new ForumWriteData(forum.getId(), forum.getName(), forum.getPrefixData(), this.jfU.getAnti());
        forumWriteData.avatar = forum.getImage_url();
        forumWriteData.forumLevel = forum.getUser_level();
        forumWriteData.specialForumType = forum.special_forum_type;
        forumWriteData.firstDir = forum.getFirst_class();
        forumWriteData.secondDir = forum.getSecond_class();
        UserData userData = this.jfU.getUserData();
        forumWriteData.privateThread = userData != null ? userData.getPrivateThread() : 0;
        forumWriteData.frsTabInfo = cDl();
        return forumWriteData;
    }

    private FrsTabInfoData cDl() {
        int i;
        if (this.jgN == null || this.jfU == null || this.jgP == null) {
            return null;
        }
        if (this.jfU.getEntelechyTabInfo() == null || com.baidu.tbadk.core.util.y.isEmpty(this.jfU.getEntelechyTabInfo().tab)) {
            return null;
        }
        int cLY = this.jgP.cLY();
        if (cLY == 502) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = -1;
        for (FrsTabInfo frsTabInfo : this.jfU.getEntelechyTabInfo().tab) {
            if (frsTabInfo != null && frsTabInfo.is_general_tab.intValue() == 1) {
                if (frsTabInfo.tab_id.intValue() != 505 || this.jfU.getUserData() == null || this.jfU.getUserData().isForumBusinessAccount()) {
                    arrayList.add(new FrsTabItemData(frsTabInfo));
                    if (cLY == frsTabInfo.tab_id.intValue()) {
                        i = cLY;
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
        if (this.jfU.getUserData() != null) {
            frsTabInfoData.isForumBusinessAccount = this.jfU.getUserData().isForumBusinessAccount();
            return frsTabInfoData;
        }
        return frsTabInfoData;
    }

    @Override // com.baidu.tieba.frs.am
    public void bup() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void qy(boolean z) {
        this.jgJ = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z) {
        this.jgv.yH(8);
        ((FrsActivity) getActivity()).showLoadingView(view, z);
        ((FrsActivity) getActivity()).j(view, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        this.jgv.yH(0);
        ((FrsActivity) getActivity()).hideLoadingView(view);
        ((FrsActivity) getActivity()).j(view, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        super.showNetRefreshView(view, getResources().getString(R.string.refresh_view_title_text), null, getResources().getString(R.string.refresh_view_button_text), z, getNetRefreshListener());
        this.jgv.yH(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshViewNoClick(View view, String str, boolean z) {
        super.showNetRefreshViewNoClick(view, str, z);
        this.jgv.yH(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        super.hideNetRefreshView(view);
        this.jgv.yH(0);
    }

    public void cDm() {
        FrsTabViewController.b cLU;
        if (this.jgP != null && (cLU = this.jgP.cLU()) != null && cLU.fragment != null && (cLU.fragment instanceof ao)) {
            ((ao) cLU.fragment).cCg();
        }
    }

    public void qz(boolean z) {
        this.jgl = z;
    }

    public void b(OvalActionButton ovalActionButton) {
        this.jgw = ovalActionButton;
    }

    public OvalActionButton cDn() {
        return this.jgw;
    }

    public boolean cDo() {
        return this.jgl;
    }

    public void Kh(String str) {
        if (TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.util.au.isEmpty(str)) {
            if (this.jhn == null) {
                this.jhn = new AddExperiencedModel(getTbPageContext());
            }
            this.jhn.gr(this.forumId, str);
        }
    }

    public boolean cDp() {
        if (this.jgJ && !this.jhq) {
            return (this.jgN != null && this.jgN.cJI() && (b.cBy().cBs() || com.baidu.tieba.frs.a.cBr().cBs())) ? false : true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.g.b
    public boolean videoNeedPreload() {
        if (this.jfU != null) {
            return com.baidu.tbadk.util.ak.rG(2) || (com.baidu.tbadk.util.ak.bFR() && this.jfU.isFrsVideoAutoPlay);
        }
        return super.videoNeedPreload();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDq() {
        if (!com.baidu.tbadk.core.util.au.isEmpty(this.forumId)) {
            com.baidu.tbadk.BdToken.c.bhn().r(com.baidu.tbadk.BdToken.b.eCg, com.baidu.adp.lib.f.b.toLong(this.forumId, 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDr() {
        String format;
        String str;
        if (isResumed() && this.jhu != null && this.jhu.size() >= 1 && this.jht <= this.jhu.size() - 1) {
            final LiveHorseRaceData liveHorseRaceData = this.jhu.get(this.jht);
            if (System.currentTimeMillis() / 1000 >= liveHorseRaceData.getRob_end_tm().longValue()) {
                this.jht++;
                cDr();
            }
            if (this.jgy != null) {
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
                        if (FrsFragment.this.jfU == null) {
                            str2 = "";
                        } else if (FrsFragment.this.jfU.getForum() != null) {
                            str2 = FrsFragment.this.jfU.getForum().getName();
                        } else {
                            str2 = "";
                        }
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13744").ap("obj_source", 1).dR("fid", FrsFragment.this.forumId).dR("fname", str2));
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
                this.jhv = ValueAnimator.ofFloat(1.0f, 0.0f);
                this.jhv.setDuration(600L);
                this.jhv.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.FrsFragment.54
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        if (valueAnimator.isRunning()) {
                            frsRedpackRunView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                            frsRedpackRunView.setTranslationX(-(TbadkApplication.getInst().getContext().getResources().getDimensionPixelOffset(R.dimen.tbds850) * valueAnimator.getAnimatedFraction()));
                        }
                    }
                });
                this.jhv.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.FrsFragment.55
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        frsRedpackRunView.setAlpha(0.0f);
                        frsRedpackRunView.setTranslationY(TbadkApplication.getInst().getContext().getResources().getDimensionPixelOffset(R.dimen.tbds660));
                        frsRedpackRunView.hide();
                        FrsFragment.this.jgy.removeView(frsRedpackRunView);
                        if (FrsFragment.this.jhu == null || FrsFragment.this.jht <= FrsFragment.this.jhu.size() - 1) {
                            FrsFragment.this.cDr();
                            return;
                        }
                        FrsFragment.this.jgy.removeAllViews();
                        FrsFragment.this.jgy.setVisibility(8);
                        FrsFragment.this.jht = 0;
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        onAnimationEnd(animator);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                this.jhw = new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.57
                    @Override // java.lang.Runnable
                    public void run() {
                        if (FrsFragment.this.jgy != null && frsRedpackRunView != null) {
                            FrsFragment.this.jhv.start();
                        }
                    }
                };
                com.baidu.adp.lib.f.e.mA().postDelayed(this.jhw, 5000L);
                if (this.jgy.getChildCount() == 0) {
                    this.jht++;
                    this.jgy.addView(frsRedpackRunView);
                    if (this.jfU != null) {
                        str = this.jfU.getForum() != null ? this.jfU.getForum().getName() : "";
                    } else {
                        str = "";
                    }
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13743").ap("obj_source", 1).dR("fid", this.forumId).dR("fname", str));
                }
                if (this.jgy != null && this.jgy.getVisibility() == 8 && ((BaseFragment) this.jgP.cLU().fragment).isPrimary() && !this.jgv.cEm() && !this.jgE) {
                    this.jgy.setVisibility(0);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        FrsTabViewController.b cLU;
        if (cCz() == null || (cLU = cCz().cLU()) == null || !(cLU.fragment instanceof BaseFragment)) {
            return null;
        }
        if (cLU.fragment instanceof FrsAllThreadFragment) {
            TbPageTag tbPageTag = super.getTbPageTag();
            int i = -1;
            if (this.jfU != null) {
                i = this.jfU.getSortType();
            }
            tbPageTag.sortType = com.baidu.tieba.frs.d.j.Av(i);
            tbPageTag.locatePage = "a070";
            if (this.jgg.equals(cLU.title)) {
                tbPageTag.locatePage = "a071";
            }
            return tbPageTag;
        } else if (cLU.fragment instanceof FrsFragment) {
            return null;
        } else {
            return ((BaseFragment) cLU.fragment).getTbPageTag();
        }
    }

    public void cDs() {
        if (this.jfU != null) {
            com.baidu.tieba.frs.b.b bVar = new com.baidu.tieba.frs.b.b();
            if (this.jfU.needLog == 1) {
                bVar.jHy = true;
            } else {
                bVar.jHy = false;
            }
            if (this.jfU.getForum() != null) {
                bVar.jHA = this.jfU.getForum().getId();
            }
            if (cCw() != null) {
                bVar.jHz = cCw().cJM();
            }
            if (com.baidu.tieba.frs.b.d.jqE != null) {
                bVar.jHB = com.baidu.tieba.frs.b.d.jqE.jHB;
                bVar.jHC = com.baidu.tieba.frs.b.d.jqE.jHC;
            }
            this.jhx = new com.baidu.tieba.frs.live.b(bVar, getTbPageTag(), getUniqueId());
            this.jhx.zX(this.jhz);
            CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_CARD_CLICK, this.jhx);
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
            CustomMessageTask customMessageTask2 = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW, this.jhx);
            customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask2);
            CustomMessageTask customMessageTask3 = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_USER_CLICK, this.jhx);
            customMessageTask3.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask3);
            CustomMessageTask customMessageTask4 = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_VIDEO_CLICK, this.jhx);
            customMessageTask4.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask4);
        }
    }

    public void aI(String str, String str2, String str3) {
        this.jhA = new com.baidu.tieba.frs.d.e(str, str2);
        this.jhA.c(getFragmentActivity(), str3, str2);
    }

    public void qA(boolean z) {
        if (this.funAdController == null) {
            this.funAdController = com.baidu.tieba.funad.a.rM(z);
            if (this.jgY != null) {
                this.jgY.setFunAdController(this.funAdController);
            }
        }
    }
}
