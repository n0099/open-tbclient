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
public class FrsFragment extends BaseFragment implements BdListView.e, a.InterfaceC0148a, UserIconBox.a<BdRecyclerView>, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, am, ap, as, com.baidu.tieba.frs.loadmore.a, com.baidu.tieba.frs.mc.l, com.baidu.tieba.recapp.p {
    public static com.baidu.tieba.tbadkCore.m jgl;
    private com.baidu.tbadk.util.z fNk;
    private com.baidu.adp.lib.d.b<TbImageView> flN;
    private com.baidu.tieba.funad.a funAdController;
    private com.baidu.tieba.frs.gametab.b gVH;
    private com.baidu.tbadk.core.dialog.a izo;
    private com.baidu.tieba.frs.entelechy.a jfT;
    private com.baidu.tieba.frs.vc.h jgA;
    private FrsTabViewController jgB;
    private com.baidu.tieba.frs.mc.h jgC;
    private com.baidu.tieba.frs.smartsort.a jgD;
    private com.baidu.tieba.frs.mc.b jgE;
    private at jgF;
    private com.baidu.tieba.frs.entelechy.a.b jgH;
    private com.baidu.tieba.frs.vc.a jgI;
    private com.baidu.tieba.frs.mc.d jgJ;
    private com.baidu.tieba.frs.mc.c jgK;
    private com.baidu.tieba.frs.vc.j jgL;
    private com.baidu.tieba.frs.mc.a jgM;
    private com.baidu.tieba.frs.live.a jgN;
    private p jgO;
    public com.baidu.tieba.frs.vc.c jgP;
    private com.baidu.tieba.frs.mc.e jgQ;
    private View.OnTouchListener jgR;
    private com.baidu.tieba.frs.view.a jgS;
    private com.baidu.tieba.frs.vc.e jgT;
    private boolean jgU;
    private com.baidu.tieba.NEGFeedBack.a jgV;
    private com.baidu.tieba.ala.b jgW;
    private com.baidu.tieba.frs.brand.buttommenu.a jgX;
    private com.baidu.tieba.frs.sportspage.notification.a jgY;
    private AddExperiencedModel jgZ;
    private com.baidu.tieba.tbadkCore.data.f jgd;
    private VoiceManager jgg;
    private OvalActionButton jgi;
    private FRSRefreshButton jgj;
    private LinearLayout jgk;
    public long jgm;
    private String jgw;
    private ThreadCardViewHolder jgy;
    private FrsModelController jgz;
    private boolean jhb;
    private List<LiveHorseRaceData> jhg;
    private ValueAnimator jhh;
    private Runnable jhi;
    private com.baidu.tieba.frs.live.b jhj;
    private com.baidu.tieba.frs.broadcast.a jhk;
    private int jhl;
    private com.baidu.tieba.frs.d.e jhm;
    private int jhw;
    private View mRootView;
    private String mSchemeUrl;
    public static boolean jfY = false;
    public static volatile long jgo = 0;
    public static volatile long jgp = 0;
    public static volatile int mNetError = 0;
    private String jfS = "";
    public boolean jfU = false;
    private boolean jfV = false;
    private boolean jfW = false;
    private boolean jfX = true;
    public String jfZ = null;
    public String mFrom = null;
    public int mFlag = 0;
    public boolean jga = false;
    private boolean jgb = false;
    private String mThreadId = null;
    public String forumId = null;
    private int jfI = 0;
    private boolean jgc = false;
    private boolean jge = false;
    private boolean jgf = false;
    private q jgh = null;
    public final cb akU = null;
    private FrsViewData jfG = new FrsViewData();
    public long iIQ = -1;
    public long fJu = 0;
    public long fJl = 0;
    public long createTime = 0;
    public long fJm = 0;
    public long fJr = 0;
    public long jgn = 0;
    boolean jgq = false;
    public boolean jgr = false;
    private boolean jgs = false;
    public com.baidu.tbadk.n.b jgt = null;
    private boolean jgu = true;
    private boolean jgv = true;
    private a.C0089a jgx = new a.C0089a(2);
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> jgG = new SparseArray<>();
    private boolean gDb = true;
    private boolean hasInit = false;
    private boolean jha = false;
    private boolean jhc = false;
    private Date jhd = null;
    private int dVi = 0;
    private int jhe = 0;
    private int jhf = 0;
    public int mHeadLineDefaultNavTabId = -1;
    MessageQueue.IdleHandler jhn = new MessageQueue.IdleHandler() { // from class: com.baidu.tieba.frs.FrsFragment.1
        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            FrsFragment.this.cCI();
            return false;
        }
    };
    private final CustomMessageListener jho = new CustomMessageListener(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED) { // from class: com.baidu.tieba.frs.FrsFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof cb) {
                    com.baidu.tieba.frs.d.k.a(FrsFragment.this.jgh, FrsFragment.this.jfG, FrsFragment.this.getForumId(), true, (cb) data);
                }
            }
        }
    };
    private CustomMessageListener jhp = new CustomMessageListener(CmdConfigCustom.CMD_CLOSE_GAME_RANK_CARD) { // from class: com.baidu.tieba.frs.FrsFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.jfG != null) {
                FrsFragment.this.jfG.removeGameRankListFromThreadList();
                if (FrsFragment.this.jgh != null) {
                    FrsFragment.this.jgh.bbC();
                }
            }
        }
    };
    private CustomMessageListener ahl = new CustomMessageListener(2921401) { // from class: com.baidu.tieba.frs.FrsFragment.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && FrsFragment.this.jgj != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() <= 0 || FrsFragment.this.jgB.cLQ() == 0 || FrsFragment.this.jgB.cLN() == null || !(FrsFragment.this.jgB.cLN().fragment instanceof BaseFragment) || !((BaseFragment) FrsFragment.this.jgB.cLN().fragment).isPrimary() || FrsFragment.this.jgh.cEf() || com.baidu.tbadk.k.d.bCB().bCC()) {
                    if (FrsFragment.this.jgB.cLQ() != 0) {
                        FrsFragment.this.jgj.hide();
                        return;
                    }
                    return;
                }
                FrsFragment.this.jgj.show();
            }
        }
    };
    private CustomMessageListener jhq = new CustomMessageListener(2921473) { // from class: com.baidu.tieba.frs.FrsFragment.45
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && FrsFragment.this.jgj != null && FrsFragment.this.jgi != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() == 0) {
                    FrsFragment.this.jgj.setVisibility(8);
                    FrsFragment.this.jgi.setVisibility(8);
                    return;
                }
                FrsFragment.this.jgi.setVisibility(0);
            }
        }
    };
    private CustomMessageListener jhr = new CustomMessageListener(2921467) { // from class: com.baidu.tieba.frs.FrsFragment.56
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && FrsFragment.this.jgj != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() <= 0 || FrsFragment.this.jgB.cLN() == null || !(FrsFragment.this.jgB.cLN().fragment instanceof BaseFragment) || !((BaseFragment) FrsFragment.this.jgB.cLN().fragment).isPrimary() || FrsFragment.this.jgh.cEf()) {
                    FrsFragment.this.jgk.setVisibility(8);
                    FrsFragment.this.jgq = true;
                    return;
                }
                FrsFragment.this.jgk.setVisibility(0);
                FrsFragment.this.jgq = false;
            }
        }
    };
    private com.baidu.adp.framework.listener.a jhs = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_FRS_LIVE_HORSE_RACE_LIST, 309667) { // from class: com.baidu.tieba.frs.FrsFragment.64
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if ((responsedMessage instanceof GetLiveHorseRaceHttpResponseMessage) || (responsedMessage instanceof GetLiveHorseRaceSocketResponseMessage)) {
                    List<LiveHorseRaceData> arrayList = new ArrayList<>();
                    if (responsedMessage instanceof GetLiveHorseRaceHttpResponseMessage) {
                        arrayList = ((GetLiveHorseRaceHttpResponseMessage) responsedMessage).getData().cEH();
                    }
                    if (responsedMessage instanceof GetLiveHorseRaceSocketResponseMessage) {
                        arrayList = ((GetLiveHorseRaceSocketResponseMessage) responsedMessage).getData().cEH();
                    }
                    if (FrsFragment.this.jhg != null) {
                        if (FrsFragment.this.jgk == null || FrsFragment.this.jgk.getVisibility() != 8) {
                            if (FrsFragment.this.jhf >= FrsFragment.this.jhg.size()) {
                                FrsFragment.this.jhg.addAll(arrayList);
                                return;
                            }
                            FrsFragment.this.jhg = FrsFragment.this.jhg.subList(0, FrsFragment.this.jhf);
                            FrsFragment.this.jhg.addAll(arrayList);
                            return;
                        }
                        FrsFragment.this.jhg = new ArrayList();
                        FrsFragment.this.jhg.addAll(arrayList);
                        FrsFragment.this.jhf = 0;
                        FrsFragment.this.cDk();
                        return;
                    }
                    FrsFragment.this.jhg = new ArrayList();
                    FrsFragment.this.jhf = 0;
                    FrsFragment.this.jhg.addAll(arrayList);
                    FrsFragment.this.cDk();
                }
            }
        }
    };
    private CustomMessageListener jht = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.FrsFragment.65
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 1) {
                    FrsFragment.this.cCM();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                }
            }
        }
    };
    private final ar jhu = new ar() { // from class: com.baidu.tieba.frs.FrsFragment.66
        @Override // com.baidu.tieba.frs.ar
        public void a(int i, int i2, ba baVar, ArrayList<com.baidu.adp.widget.ListView.n> arrayList) {
            FrsFragment.this.cCx();
            if (FrsFragment.this.jgH != null) {
                FrsFragment.this.jgA.rD(FrsFragment.this.jgH.zm(i));
            }
            com.baidu.tieba.tbadkCore.f fVar = new com.baidu.tieba.tbadkCore.f();
            if (baVar != null) {
                fVar.isSuccess = baVar.errCode == 0;
                fVar.errorCode = baVar.errCode;
                fVar.errorMsg = baVar.errMsg;
                if (fVar.isSuccess) {
                    if (com.baidu.tbadk.core.util.y.isEmpty(arrayList)) {
                        FrsFragment.this.jgh.bSr();
                    } else if (baVar.hasMore) {
                        if (com.baidu.tbadk.core.util.y.getCount(FrsFragment.this.jfG.getThreadList()) > 3) {
                            FrsFragment.this.jgh.WX();
                        } else {
                            FrsFragment.this.jgh.cDW();
                        }
                    } else if (baVar.jlh) {
                        FrsFragment.this.jgh.WY();
                    } else {
                        FrsFragment.this.jgh.bSr();
                    }
                }
            } else {
                baVar = new ba();
                baVar.pn = 1;
                baVar.hasMore = false;
                baVar.jlh = false;
            }
            if (i == 1) {
                FrsFragment.this.jgu = true;
                FrsFragment.this.jhM.a(FrsFragment.this.jgz.getType(), false, fVar);
            } else {
                FrsFragment.this.a(fVar);
                if (FrsFragment.this.jgz.cJb() != null) {
                    FrsFragment.this.jfG = FrsFragment.this.jgz.cJb();
                }
                FrsFragment.this.cCO();
            }
            if (FrsFragment.this.jhU != null) {
                FrsFragment.this.jhU.a(i, i2, baVar, arrayList);
            }
        }
    };
    private FrsTabViewController.a jhv = new FrsTabViewController.a() { // from class: com.baidu.tieba.frs.FrsFragment.2
        @Override // com.baidu.tieba.frs.vc.FrsTabViewController.a
        public void l(int i, int i2, String str) {
            boolean z = false;
            if (i != 1) {
                com.baidu.tieba.card.t.csu().pB(false);
                FrsFragment.this.qu(false);
            }
            if (i == 502) {
                FrsFragment.this.jgi.setIconFade(R.drawable.btn_frs_professional_edit_n);
            } else {
                FrsFragment.this.jgi.setIconFade(0);
            }
            FrsFragment.this.jhw = i;
            FrsFragment.this.jhl = i2;
            if (FrsFragment.this.jhj != null) {
                FrsFragment.this.jhj.zX(FrsFragment.this.jhl);
            }
            TbSingleton.getInstance().setFrsCurTabType(FrsFragment.this.jhl);
            FrsFragment.this.cCU();
            com.baidu.tieba.frs.b.d.jqq.jHn = i;
            com.baidu.tieba.frs.b.d.jqq.jHq = i2;
            com.baidu.tieba.frs.b.d.jqq.jHo = -1;
            b.cBr().X(i == 1 && FrsFragment.this.jha, true);
            com.baidu.tieba.frs.a cBk = com.baidu.tieba.frs.a.cBk();
            if (i == 1 && FrsFragment.this.jha) {
                z = true;
            }
            cBk.X(z, true);
        }
    };
    private CustomMessageListener jhx = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIVE_COUNT) { // from class: com.baidu.tieba.frs.FrsFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                FrsFragment.this.jgB.AI(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    };
    private CustomMessageListener jhy = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_LIVE_START) { // from class: com.baidu.tieba.frs.FrsFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && ((Integer) customResponsedMessage.getData()).intValue() == 51 && FrsFragment.this.jfG != null) {
                com.baidu.tieba.frs.d.m.a(FrsFragment.this.jfG, FrsFragment.this.getPageContext());
            }
        }
    };
    private final CustomMessageListener jhz = new CustomMessageListener(CmdConfigCustom.CMD_FRS_SELECT_ALA_LIVE_TAB) { // from class: com.baidu.tieba.frs.FrsFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                FrsFragment.this.jgB.sT(49);
            }
        }
    };
    private final CustomMessageListener jhA = new CustomMessageListener(2921470) { // from class: com.baidu.tieba.frs.FrsFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                FrsFragment.this.jgB.sT(1);
                FrsFragment.this.cCM();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
            }
        }
    };
    private final CustomMessageListener jhB = new CustomMessageListener(CmdConfigCustom.CMD_FRS_EXPERIENCE_TIP) { // from class: com.baidu.tieba.frs.FrsFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.w) && FrsFragment.this.jfG != null) {
                FrsFragment.this.jfG.updateLikeData((com.baidu.tieba.tbadkCore.w) customResponsedMessage.getData());
                FrsFragment.this.jgA.j(FrsFragment.this.jfG);
                FrsFragment.this.jgB.a(FrsFragment.this.jfG, FrsFragment.this.jgz.cJF());
            }
        }
    };
    private final AntiHelper.a jhC = new AntiHelper.a() { // from class: com.baidu.tieba.frs.FrsFragment.8
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ap("obj_locate", ay.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ap("obj_locate", ay.a.LOCATE_LIKE_PERSON));
        }
    };
    private CustomMessageListener jhD = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.FrsFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(FrsFragment.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().fsD != null) {
                        if (AntiHelper.a(FrsFragment.this.getActivity(), updateAttentionMessage.getData().fsD, FrsFragment.this.jhC) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ap("obj_locate", ay.a.LOCATE_LIKE_PERSON));
                        }
                    } else if (updateAttentionMessage.getData().isSucc && updateAttentionMessage.getData().isAttention) {
                        com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getPageContext().getPageActivity(), R.string.attention_success);
                    }
                }
            }
        }
    };
    private CustomMessageListener jhE = new CustomMessageListener(CmdConfigCustom.CMD_GET_ENSURE_CAST_ID) { // from class: com.baidu.tieba.frs.FrsFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsFragment.this.refresh();
        }
    };
    private CustomMessageListener jhF = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.frs.FrsFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                FrsFragment.this.jgh.c((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener jhG = new CustomMessageListener(2001378) { // from class: com.baidu.tieba.frs.FrsFragment.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof WriteData) && com.baidu.tbadk.core.util.au.equals(((WriteData) customResponsedMessage.getData()).getForumId(), FrsFragment.this.forumId)) {
                FrsFragment.this.jgM.zZ(((WriteData) customResponsedMessage.getData()).getTabId());
                MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
            }
        }
    };
    private CustomMessageListener jhH = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_REMIND) { // from class: com.baidu.tieba.frs.FrsFragment.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626) {
                NewsRemindMessage newsRemindMessage = (NewsRemindMessage) customResponsedMessage;
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (FrsFragment.this.jgh != null) {
                    FrsFragment.this.jgh.P(notificationCount, z);
                }
            }
        }
    };
    private HttpMessageListener jhI = new HttpMessageListener(CmdConfigHttp.CMD_FRS_MOVE_AREA) { // from class: com.baidu.tieba.frs.FrsFragment.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int i;
            int i2 = 0;
            if (httpResponsedMessage != null && FrsFragment.this.getContext() != null && FrsFragment.this.jgh != null) {
                if (httpResponsedMessage.getError() == 0) {
                    new BdTopToast(FrsFragment.this.getContext()).zn(true).UN(FrsFragment.this.getContext().getString(R.string.frs_move_area_move_suc)).aR(FrsFragment.this.jgh.cnn());
                    if (com.baidu.tieba.frs.a.cBk().yt(com.baidu.tieba.frs.a.cBk().cBm())) {
                        FrsCommonTabFragment frsCommonTabFragment = null;
                        if (FrsFragment.this.jgB != null && FrsFragment.this.jgB.cLN() != null && (FrsFragment.this.jgB.cLN().fragment instanceof FrsCommonTabFragment)) {
                            frsCommonTabFragment = (FrsCommonTabFragment) FrsFragment.this.jgB.cLN().fragment;
                        }
                        if (frsCommonTabFragment != null) {
                            frsCommonTabFragment.cFC();
                        }
                        FrsFragment.this.cBp();
                        com.baidu.tieba.frs.a.cBk().cBp();
                        Iterator<com.baidu.adp.widget.ListView.n> it = FrsFragment.this.jfG.getThreadList().iterator();
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
                            FrsFragment.this.bRc();
                        }
                    }
                    com.baidu.tieba.frs.a.cBk().reset();
                    return;
                }
                new BdTopToast(FrsFragment.this.getContext()).zn(false).UN(httpResponsedMessage.getErrorString()).aR(FrsFragment.this.jgh.cnn());
            }
        }
    };
    private com.baidu.tbadk.mutiprocess.h mTopToastEventListener = new com.baidu.tbadk.mutiprocess.h<TopToastEvent>() { // from class: com.baidu.tieba.frs.FrsFragment.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.mutiprocess.b
        public boolean a(TopToastEvent topToastEvent) {
            new BdTopToast(FrsFragment.this.getContext()).zn(topToastEvent.isSuccess()).UN(topToastEvent.getContent()).aR(FrsFragment.this.jgh.cnn());
            return false;
        }
    };
    private final CustomMessageListener jhJ = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.frs.FrsFragment.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.isResumed()) {
                FrsFragment.this.cDj();
            }
        }
    };
    private CustomMessageListener jhK = new CustomMessageListener(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER) { // from class: com.baidu.tieba.frs.FrsFragment.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (FrsFragment.this.jgh != null) {
                    FrsFragment.this.jgh.setExpanded(booleanValue);
                }
            }
        }
    };
    private final CustomMessageListener jhL = new CustomMessageListener(2921463) { // from class: com.baidu.tieba.frs.FrsFragment.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TbadkApplication.getInst().getCurrentActivity() != null && !com.baidu.tbadk.core.util.au.isEmpty(str) && str.equals(FrsFragment.this.forumId)) {
                    com.baidu.tieba.frs.d.h.b(((TbPageContextSupport) TbadkApplication.getInst().getCurrentActivity()).getPageContext(), FrsFragment.this.jfG);
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.s jhM = new com.baidu.tieba.tbadkCore.s() { // from class: com.baidu.tieba.frs.FrsFragment.20
        private long startTime = 0;

        @Override // com.baidu.tieba.tbadkCore.s
        public void yA(int i) {
            this.startTime = System.nanoTime();
            if (FrsFragment.this.jgh != null) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsFragment.this.jgh.cDH();
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
            if (FrsFragment.this.gDb) {
                FrsFragment.this.gDb = false;
                com.baidu.tieba.frs.d.k.a(FrsFragment.this.jgh, FrsFragment.this.jfG, FrsFragment.this.getForumId(), false, null);
            }
            FrsFragment.this.cCx();
            FrsFragment.this.jgs = true;
            if (fVar != null && fVar.isSuccess) {
                FrsFragment.this.jgh.cDU().rf(com.baidu.tbadk.core.util.av.bsS().bsT());
                FrsFragment.jgo = 0L;
                FrsFragment.jgp = 0L;
                FrsFragment.mNetError = 0;
            } else {
                FrsFragment.mNetError = 1;
            }
            if (!FrsFragment.this.jgz.cJK() && (i == 3 || i == 6)) {
                FrsFragment.this.jgK.resetData();
            }
            FrsFragment.this.jgm = System.currentTimeMillis();
            if (FrsFragment.this.jgz.cJb() != null) {
                FrsFragment.this.jfG = FrsFragment.this.jgz.cJb();
            }
            FrsFragment.this.yw(1);
            FrsFragment.this.cCF();
            if (i == 7) {
                FrsFragment.this.yx(FrsFragment.this.jfG.getFrsDefaultTabId());
                return;
            }
            if (FrsFragment.this.jfG.getPage() != null) {
                FrsFragment.this.setHasMore(FrsFragment.this.jfG.getPage().bmF());
            }
            if (i == 4) {
                if (!FrsFragment.this.jgz.cJK() && TbadkCoreApplication.getInst().isRecAppExist() && FrsFragment.this.jgz.cJA() == 1 && !com.baidu.tieba.funad.a.cNn()) {
                    FrsFragment.this.jfG.addRecommendAppToThreadList(FrsFragment.this);
                }
                ArrayList<com.baidu.adp.widget.ListView.n> a2 = FrsFragment.this.jgK.a(false, false, FrsFragment.this.jfG.getThreadList(), FrsFragment.this.jgd, false);
                if (a2 != null) {
                    FrsFragment.this.jfG.setThreadList(a2);
                    FrsFragment.this.jfG.checkLiveStageInThreadList();
                }
                if (FrsFragment.this.jgz != null) {
                    com.baidu.tieba.frs.b.c.a(FrsFragment.this.jfG, FrsFragment.this.jgz.cJF(), 2, FrsFragment.this.getContext());
                }
                com.baidu.tieba.frs.d.a.a(FrsFragment.this, FrsFragment.this.jfG.getForum(), FrsFragment.this.jfG.getThreadList(), false, FrsFragment.this.getPn());
                FrsFragment.this.jgh.a(a2, FrsFragment.this.jfG);
                FrsFragment.this.cCy();
                return;
            }
            FrsFragment.this.cCy();
            switch (i) {
                case 1:
                    FrsFragment.this.jgh.cDH();
                    break;
                case 2:
                    FrsFragment.this.jgh.cDH();
                    break;
                case 3:
                case 6:
                    if (FrsFragment.this.jfG != null) {
                        FrsFragment.this.jfG.clearPostThreadCount();
                    }
                    if (FrsFragment.this.jgP != null) {
                        FrsFragment.this.jgP.refresh();
                        break;
                    }
                    break;
            }
            FrsFragment.this.cCG();
            if (fVar == null || fVar.errorCode == 0) {
                if (FrsFragment.this.jfG != null) {
                    FrsFragment.this.a(FrsFragment.this.jfG);
                    FrsFragment.this.Z(false, i == 5);
                    if (FrsFragment.this.jgz != null) {
                        if (FrsFragment.this.jfG.getActivityHeadData() != null && FrsFragment.this.jfG.getActivityHeadData().blR() != null && FrsFragment.this.jfG.getActivityHeadData().blR().size() > 0) {
                            com.baidu.tieba.frs.b.a.a(FrsFragment.this.getUniqueId(), 1, FrsFragment.this.jfG.getForum(), FrsFragment.this.jgz.getSortType(), 1);
                        }
                        if (FrsFragment.this.jfG.getThreadList() != null && FrsFragment.this.jfG.getThreadList().size() > 0) {
                            Iterator<com.baidu.adp.widget.ListView.n> it = FrsFragment.this.jfG.getThreadList().iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    com.baidu.adp.widget.ListView.n next = it.next();
                                    if ((next instanceof cb) && ((cb) next).getType() == cb.eSp) {
                                        com.baidu.tieba.frs.b.a.a(FrsFragment.this.getUniqueId(), 1, FrsFragment.this.jfG.getForum(), FrsFragment.this.jgz.getSortType(), 2);
                                    }
                                }
                            }
                        }
                        com.baidu.tieba.frs.b.a.a(FrsFragment.this.getUniqueId(), FrsFragment.this.jfG.getThreadList(), FrsFragment.this.jfG.getForum(), FrsFragment.this.jgz.getSortType());
                    }
                    FrsFragment.this.jgh.yN(i);
                    FrsFragment.jgo = (System.nanoTime() - this.startTime) / TimeUtils.NANOS_PER_MS;
                    if (fVar != null) {
                        FrsFragment.jgp = fVar.nuf;
                    }
                } else {
                    return;
                }
            } else if (FrsFragment.this.jfG == null || com.baidu.tbadk.core.util.y.isEmpty(FrsFragment.this.jfG.getThreadList())) {
                FrsFragment.this.a(fVar);
            } else if (fVar.iQj) {
                FrsFragment.this.showToast(FrsFragment.this.getPageContext().getResources().getString(R.string.net_error_text, fVar.errorMsg, Integer.valueOf(fVar.errorCode)));
            }
            FrsFragment.this.cCC();
            FrsFragment.this.cCD();
            if (FrsFragment.this.jfG.getAccessFlag() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11384"));
            }
            if (FrsFragment.this.jge && FrsFragment.this.jgB.sT(49)) {
                FrsFragment.this.jge = false;
            }
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.s
        public void c(com.baidu.tieba.tbadkCore.m mVar) {
            if ((mVar != null && ("normal_page".equals(FrsFragment.this.jgz.getPageType()) || "frs_page".equals(FrsFragment.this.jgz.getPageType()) || "book_page".equals(FrsFragment.this.jgz.getPageType()))) || "brand_page".equals(FrsFragment.this.jgz.getPageType())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE, mVar));
                FrsFragment.this.b(mVar);
                FrsFragment.jgl = mVar;
            }
        }

        @Override // com.baidu.tieba.tbadkCore.s
        public void cCI() {
            FrsFragment.this.cCI();
        }
    };
    private final CustomMessageListener jhN = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.frs.FrsFragment.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.n) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                FrsFragment.this.jfG.updateCurrentUserPendant((com.baidu.tbadk.data.n) customResponsedMessage.getData());
                FrsFragment.this.jgh.cDU().notifyDataSetChanged();
            }
        }
    };
    private final CustomMessageListener mMemListener = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_MEM) { // from class: com.baidu.tieba.frs.FrsFragment.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && FrsFragment.this.jfG != null && (userData = FrsFragment.this.jfG.getUserData()) != null) {
                userData.setIsMem(num.intValue());
                if (num.intValue() != 0) {
                    FrsFragment.this.jgA.q(num);
                }
            }
        }
    };
    private final f.a jhO = new AnonymousClass31();
    private final com.baidu.tieba.frs.mc.k jhP = new com.baidu.tieba.frs.mc.k() { // from class: com.baidu.tieba.frs.FrsFragment.32
        @Override // com.baidu.tieba.frs.mc.k
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.n> arrayList, boolean z3) {
            if (FrsFragment.this.jgD != null && FrsFragment.this.jgz != null && FrsFragment.this.jgz.cJK() && z && !z2 && !z3) {
                FrsFragment.this.jgD.Af(i2);
            }
        }
    };
    public final View.OnTouchListener bST = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.FrsFragment.33
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (FrsFragment.this.jgR != null) {
                FrsFragment.this.jgR.onTouch(view, motionEvent);
            }
            if (FrsFragment.this.jgF != null && FrsFragment.this.jgF.cEI() != null) {
                FrsFragment.this.jgF.cEI().onTouchEvent(motionEvent);
            }
            if (FrsFragment.this.gVH != null) {
                FrsFragment.this.gVH.i(view, motionEvent);
            }
            if (FrsFragment.this.jgA != null) {
                FrsFragment.this.jgA.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private final CustomMessageListener jhQ = new CustomMessageListener(CmdConfigCustom.CMD_GOTOLIVE_HOST_UPGRADE) { // from class: com.baidu.tieba.frs.FrsFragment.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.brQ().getInt(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.PHOTOLIVE_HOSTLEVEL, -1) != -1 && FrsFragment.this.jfG.getForum() != null) {
                FrsFragment.this.jfG.getForum().setCanAddPhotoLivePost(true);
            }
        }
    };
    public final View.OnClickListener jhR = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.41
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsFragment.this.jgh != null && view == FrsFragment.this.jgh.cDF() && FrsFragment.this.getActivity() != null) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, FrsFragment.this.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            if (view.getId() == R.id.game_activity_egg_layout && com.baidu.adp.lib.util.l.isNetOk()) {
                TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_CLICK);
                if (FrsFragment.this.jgh == null || !FrsFragment.this.jgh.cDR()) {
                    String activityUrl = FrsFragment.this.jfG.getForum().getYuleData().bqo().getActivityUrl();
                    if (!StringUtils.isNull(activityUrl)) {
                        com.baidu.tbadk.browser.a.startInternalWebActivity(FrsFragment.this.getPageContext().getPageActivity(), activityUrl);
                    }
                } else {
                    FrsFragment.this.jgh.cDS();
                }
            }
            if (FrsFragment.this.jgh != null && view == FrsFragment.this.jgh.cDX() && FrsFragment.this.jgz != null && FrsFragment.this.jgz.hasMore()) {
                FrsFragment.this.jgh.WX();
                FrsFragment.this.bRc();
            }
            if (view != null && FrsFragment.this.jgh != null && view == FrsFragment.this.jgh.cDO()) {
                if (bh.checkUpIsLogin(FrsFragment.this.getContext())) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).ap("obj_locate", 2));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MessageCenterActivityConfig(FrsFragment.this.getContext())));
                } else {
                    return;
                }
            }
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (FrsFragment.this.jfG != null && FrsFragment.this.jfG.getForum() != null) {
                    if (FrsFragment.this.jgh != null && view == FrsFragment.this.jgh.cDM()) {
                        if (FrsFragment.this.jfG != null && FrsFragment.this.jfG.getForum() != null && !StringUtils.isNull(FrsFragment.this.jfG.getForum().getId()) && !StringUtils.isNull(FrsFragment.this.jfG.getForum().getName())) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.KEY_SHARE_CLICK).dR("fid", FrsFragment.this.jfG.getForum().getId()).ap("obj_locate", 11));
                            com.baidu.tieba.frs.d.h.a(FrsFragment.this.getPageContext(), FrsFragment.this.jfG, FrsFragment.this.jfG.getForum().getId());
                        } else {
                            return;
                        }
                    }
                    if (FrsFragment.this.jgh != null && view == FrsFragment.this.jgh.cDL()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12402").dR("fid", FrsFragment.this.jfG.getForum().getId()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fname", FrsFragment.this.jfG.getForum().getName()));
                        if (!StringUtils.isNull(FrsFragment.this.jfG.getForum().getName())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PostSearchActivityConfig(FrsFragment.this.getContext(), FrsFragment.this.jfG.getForum().getName(), FrsFragment.this.jfG.getForum().getId())));
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
        private int jiq = 0;
        private int gyR = 0;

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsFragment.this.jhe += i2;
            if (FrsFragment.this.jhe >= FrsFragment.this.dVi * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
            if (FrsFragment.this.jgI != null) {
                FrsFragment.this.jgI.cKG();
            }
            this.jiq = 0;
            this.gyR = 0;
            if (recyclerView != null && (recyclerView instanceof BdRecyclerView)) {
                this.jiq = ((BdRecyclerView) recyclerView).getFirstVisiblePosition();
                this.gyR = ((BdRecyclerView) recyclerView).getLastVisiblePosition();
            }
            if (FrsFragment.this.jgT != null) {
                FrsFragment.this.jgT.a(recyclerView, this.jiq, this.gyR);
            }
            if (FrsFragment.this.jfG != null && FrsFragment.this.jgh != null && FrsFragment.this.jgh.cDU() != null) {
                FrsFragment.this.jgh.cn(this.jiq, this.gyR);
                if (FrsFragment.this.jgy != null && FrsFragment.this.jgy.tj() != null) {
                    FrsFragment.this.jgy.tj().b(FrsFragment.this.jgx);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (FrsFragment.this.jgA != null) {
                FrsFragment.this.jgA.setScrollState(i);
                if (i == 1) {
                    FrsFragment.this.jgA.cLi();
                }
            }
            if (FrsFragment.this.jgt == null && !FrsFragment.this.cDc()) {
                FrsFragment.this.jgt = new com.baidu.tbadk.n.b();
                FrsFragment.this.jgt.setSubType(1000);
            }
            if (i == 0) {
                if (FrsFragment.this.jgt != null) {
                    FrsFragment.this.jgt.bDZ();
                }
                com.baidu.tieba.card.t.csu().pB(true);
                FrsFragment.this.qu(true);
                FrsFragment.this.jgh.cm(this.jiq, this.gyR);
            } else if (FrsFragment.this.jgt != null) {
                FrsFragment.this.jgt.bDY();
            }
            if (FrsFragment.this.jgT != null) {
                FrsFragment.this.jgT.onScrollStateChanged(recyclerView, i);
            }
            if (i == 0) {
                com.baidu.tieba.frs.d.k.a(FrsFragment.this.jgh, FrsFragment.this.jfG, FrsFragment.this.getForumId(), false, null);
            }
            if (FrsFragment.this.jgB != null && i == 1) {
                FrsFragment.this.jgB.cLP();
            }
            if (FrsFragment.this.jgy == null) {
                if (FrsFragment.this.jgh.cDy() != null && !FrsFragment.this.jgh.cDa() && FrsFragment.this.jgh.cDy().dzV() != null && (FrsFragment.this.jgh.cDy().dzV().getTag() instanceof ThreadCardViewHolder)) {
                    FrsFragment.this.jgy = (ThreadCardViewHolder) FrsFragment.this.jgh.cDy().dzV().getTag();
                }
            } else if (i == 0 && FrsFragment.this.jgh.cDy() != null && !FrsFragment.this.jgh.cDa() && FrsFragment.this.jgh.cDy().dzV() != null && (FrsFragment.this.jgh.cDy().dzV().getTag() instanceof ThreadCardViewHolder)) {
                FrsFragment.this.jgy = (ThreadCardViewHolder) FrsFragment.this.jgh.cDy().dzV().getTag();
            }
            if (i == 1) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921418));
            }
        }
    };
    private final f jhS = new f() { // from class: com.baidu.tieba.frs.FrsFragment.43
        @Override // com.baidu.tieba.frs.f
        public void a(int i, int i2, View view, View view2, cb cbVar) {
            if (i != FrsFragment.this.jgh.cDU().cGv()) {
                if (i != FrsFragment.this.jgh.cDU().cGw()) {
                    if (i == FrsFragment.this.jgh.cDU().cGt() && FrsFragment.this.jfG != null && FrsFragment.this.jfG.getUserData() != null && FrsFragment.this.jfG.getUserData().isBawu()) {
                        String bawuCenterUrl = FrsFragment.this.jfG.getBawuCenterUrl();
                        if (!com.baidu.tbadk.core.util.au.isEmpty(bawuCenterUrl) && FrsFragment.this.jfG.getForum() != null) {
                            com.baidu.tbadk.browser.a.startWebActivity(FrsFragment.this.getPageContext().getPageActivity(), bawuCenterUrl);
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10502").dR("fid", FrsFragment.this.jfG.getForum().getId()).dR("uid", FrsFragment.this.jfG.getUserData().getUserId()));
                        }
                    }
                } else if (bh.checkUpIsLogin(FrsFragment.this.getPageContext().getPageActivity())) {
                    TiebaStatic.log(CommonStatisticKey.MY_SERVICE_CK);
                    if (FrsFragment.this.jfG != null && FrsFragment.this.jfG.getForum() != null) {
                        ForumData forum = FrsFragment.this.jfG.getForum();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(forum.getId(), 0L), forum.getName(), forum.getImage_url(), 0)));
                    }
                }
            } else if (bh.checkUpIsLogin(FrsFragment.this.getActivity())) {
                TiebaStatic.log("forum_fortune_click");
                com.baidu.tieba.frs.d.l.c(FrsFragment.this.getPageContext(), FrsFragment.this.jfG);
            }
        }
    };
    private final NoNetworkView.a jdt = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.FrsFragment.44
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (FrsFragment.this.jgz.cJA() == 1 && z && !FrsFragment.this.jgh.cDa()) {
                if (FrsFragment.this.jfG == null || com.baidu.tbadk.core.util.y.isEmpty(FrsFragment.this.jfG.getThreadList())) {
                    FrsFragment.this.hideNetRefreshView(FrsFragment.this.jgh.cEi().cLD());
                    FrsFragment.this.showLoadingView(FrsFragment.this.jgh.cnn(), true);
                    FrsFragment.this.jgh.qF(false);
                    FrsFragment.this.refresh();
                    return;
                }
                FrsFragment.this.jgh.cDH();
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
                com.baidu.tieba.frs.d.c.a(customResponsedMessage, FrsFragment.this.jgh, FrsFragment.this.jfG);
            }
        }
    };
    private com.baidu.adp.widget.ListView.w jhT = new a();
    private ar jhU = new ar() { // from class: com.baidu.tieba.frs.FrsFragment.48
        @Override // com.baidu.tieba.frs.ar
        public void a(int i, int i2, ba baVar, ArrayList<com.baidu.adp.widget.ListView.n> arrayList) {
            com.baidu.adp.lib.f.e.mA().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.48.1
                @Override // java.lang.Runnable
                public void run() {
                    if (FrsFragment.this.jgh != null && FrsFragment.this.jgh.cEa()) {
                        FrsFragment.this.bRc();
                    }
                }
            });
        }
    };
    private CustomMessageListener jhV = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.frs.FrsFragment.49
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    FrsFragment.this.jgU = true;
                }
            }
        }
    };
    private CustomMessageListener jhW = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.frs.FrsFragment.50
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                    if (FrsFragment.this.jgy == null && FrsFragment.this.jgh.cDy() != null && !FrsFragment.this.jgh.cDa() && FrsFragment.this.jgh.cDy().dzV() != null && (FrsFragment.this.jgh.cDy().dzV().getTag() instanceof ThreadCardViewHolder)) {
                        FrsFragment.this.jgy = (ThreadCardViewHolder) FrsFragment.this.jgh.cDy().dzV().getTag();
                    }
                    if (FrsFragment.this.jgy != null && FrsFragment.this.jgy.tj() != null) {
                        FrsFragment.this.jgy.tj().b(new a.C0089a(3));
                    }
                }
            }
        }
    };
    private CustomMessageListener jhX = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.FrsFragment.51
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.jgh != null) {
                FrsFragment.this.jgh.EK();
            }
        }
    };
    private CustomMessageListener jhY = new CustomMessageListener(2921437) { // from class: com.baidu.tieba.frs.FrsFragment.52
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && FrsFragment.this.isResumed()) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (FrsFragment.this.jgj != null) {
                    if (booleanValue) {
                        if (FrsFragment.this.jgB.cLQ() != 0 && !FrsFragment.this.jgh.cEf() && !com.baidu.tbadk.k.d.bCB().bCC()) {
                            FrsFragment.this.jgj.show();
                            return;
                        }
                        return;
                    }
                    FrsFragment.this.jgj.hide();
                }
            }
        }
    };
    private CustomMessageListener jhZ = new CustomMessageListener(2921462) { // from class: com.baidu.tieba.frs.FrsFragment.58
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && FrsFragment.this.jfG.getToLoadHorseData().intValue() == 1 && FrsFragment.this.mIsLogin) {
                LiveHorseRaceRequestMessage liveHorseRaceRequestMessage = new LiveHorseRaceRequestMessage();
                liveHorseRaceRequestMessage.setForum_id(Long.valueOf(FrsFragment.this.forumId));
                FrsFragment.this.sendMessage(liveHorseRaceRequestMessage);
            }
        }
    };
    private CustomMessageListener jia = new CustomMessageListener(2001223) { // from class: com.baidu.tieba.frs.FrsFragment.59
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Date)) {
                FrsFragment.this.jhd = (Date) customResponsedMessage.getData();
            }
        }
    };
    private CustomMessageListener jib = new CustomMessageListener(2921469) { // from class: com.baidu.tieba.frs.FrsFragment.60
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.z) && FrsFragment.this.isResumed()) {
                com.baidu.tbadk.core.data.z zVar = (com.baidu.tbadk.core.data.z) customResponsedMessage.getData();
                if (FrsFragment.this.jhk == null) {
                    FrsFragment.this.jhk = new com.baidu.tieba.frs.broadcast.a(FrsFragment.this.getPageContext());
                }
                if (FrsFragment.this.jfG != null && FrsFragment.this.jfG.getForum() != null && !TextUtils.isEmpty(FrsFragment.this.jfG.getForum().getId())) {
                    FrsFragment.this.jhk.e(zVar.type, FrsFragment.this.jfG.getForum().getId(), FrsFragment.this.jfG.getForum().getName(), zVar.tid);
                }
            }
        }
    };
    private CustomMessageListener jic = new CustomMessageListener(2921475) { // from class: com.baidu.tieba.frs.FrsFragment.61
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            cb cbVar = (cb) customResponsedMessage.getData();
            if (cbVar != null && FrsFragment.this.isResumed()) {
                FrsFragment.this.jgw = cbVar.getTid() + "";
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE_NUMBER);
                httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
                httpMessage.addParam("forum_id", cbVar.getFid());
                MessageManager.getInstance().sendMessage(httpMessage);
            }
        }
    };
    private HttpMessageListener jie = new HttpMessageListener(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE_NUMBER) { // from class: com.baidu.tieba.frs.FrsFragment.62
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if ((httpResponsedMessage instanceof ForumManagerRightsResMsg) && FrsFragment.this.isResumed()) {
                ForumManagerRightsResMsg forumManagerRightsResMsg = (ForumManagerRightsResMsg) httpResponsedMessage;
                if (forumManagerRightsResMsg.broadcastTotalCount - forumManagerRightsResMsg.broadcastUsedCount <= 0) {
                    new ScreenTopToast(FrsFragment.this.getContext()).US(FrsFragment.this.getString(R.string.frs_forum_bawu_send_broadcast_none_tip)).UU(FrsFragment.this.getString(R.string.frs_recommend_fail_tip_btn)).an(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.62.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("_forumId", FrsFragment.this.jfG.getForum().getId());
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new com.baidu.tieba.tbadkCore.data.m(FrsFragment.this.getContext(), "ForumGradePage", hashMap)));
                        }
                    }).aR((ViewGroup) FrsFragment.this.mRootView.findViewById(R.id.frs));
                    return;
                }
                com.baidu.tbadk.core.util.p pVar = new com.baidu.tbadk.core.util.p(TbadkCoreApplication.getInst());
                pVar.ap(FrsFragment.this.jfG.getForum().getId(), FrsFragment.this.jfG.getForum().getName(), "6");
                pVar.AU(FrsFragment.this.jgw);
                pVar.start();
            }
        }
    };
    private CustomMessageListener jif = new CustomMessageListener(2921515) { // from class: com.baidu.tieba.frs.FrsFragment.63
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                com.baidu.tieba.NEGFeedBack.g gVar = (com.baidu.tieba.NEGFeedBack.g) customResponsedMessage.getData();
                if (FrsFragment.this.jfG == null || FrsFragment.this.jfG.getForum() == null || FrsFragment.this.jfG.getForum().getDeletedReasonInfo() == null) {
                    com.baidu.tieba.NEGFeedBack.d.a(0, FrsFragment.this.getPageContext(), gVar, null, FrsFragment.this.jfG.getUserData());
                    return;
                }
                com.baidu.tieba.NEGFeedBack.h hVar = new com.baidu.tieba.NEGFeedBack.h(FrsFragment.this.jfG.getForum().getDeletedReasonInfo().is_grays_cale_forum.intValue(), FrsFragment.this.jfG.getForum().getDeletedReasonInfo().is_boomgrow.intValue(), FrsFragment.this.jfG.forumRule != null ? FrsFragment.this.jfG.forumRule.has_forum_rule.intValue() : 0);
                hVar.eg(FrsFragment.this.jfG.getForum().getId(), FrsFragment.this.jfG.getForum().getName());
                hVar.setForumHeadUrl(FrsFragment.this.jfG.getForum().getImage_url());
                hVar.setUserLevel(FrsFragment.this.jfG.getForum().getUser_level());
                com.baidu.tieba.NEGFeedBack.d.a(hVar.bKv(), FrsFragment.this.getPageContext(), gVar, hVar, FrsFragment.this.jfG.getUserData());
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.frs.loadmore.a
    public /* bridge */ /* synthetic */ com.baidu.adp.base.f getPageContext() {
        return super.getPageContext();
    }

    public com.baidu.tieba.frs.entelechy.a.b cCl() {
        return this.jgH;
    }

    public com.baidu.adp.widget.ListView.w cCm() {
        return this.jhT;
    }

    public com.baidu.tieba.frs.mc.d cCn() {
        return this.jgJ;
    }

    public com.baidu.tieba.frs.smartsort.a cCo() {
        return this.jgD;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public FrsModelController cCp() {
        return this.jgz;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public com.baidu.tieba.frs.mc.c cCq() {
        return this.jgK;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public com.baidu.tieba.frs.vc.h cCr() {
        return this.jgA;
    }

    public FrsTabViewController cCs() {
        return this.jgB;
    }

    public at cCt() {
        return this.jgF;
    }

    public void qt(boolean z) {
        this.jhc = z;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public q cCu() {
        return this.jgh;
    }

    @Override // com.baidu.tieba.frs.as
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.as, com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.jfZ;
    }

    public void setForumName(String str) {
        this.jfZ = str;
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
        if (this.jgK == null) {
            return 1;
        }
        return this.jgK.getPn();
    }

    public int getPn() {
        if (this.jgK == null) {
            return 1;
        }
        return this.jgK.getPn();
    }

    public void setPn(int i) {
        if (this.jgK != null) {
            this.jgK.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.jgK != null) {
            this.jgK.setHasMore(i);
        }
    }

    public int cCv() {
        if (this.jgK == null) {
            return -1;
        }
        return this.jgK.cCv();
    }

    public boolean cCw() {
        return this.jgf;
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
            this.jgh.cDB();
            showNetRefreshView(this.jgh.cnn(), string, true);
        } else if (340001 == fVar.errorCode) {
            a(fVar, this.jfG.getRecm_forum_list());
        } else {
            if (com.baidu.tbadk.core.util.y.isEmpty(this.jfG.getThreadList())) {
                b(fVar);
            }
            if (cDc()) {
                setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds280));
            } else {
                setNetRefreshViewEmotionDefMarginTop();
            }
        }
    }

    public void a(View view, String str, boolean z, List<RecmForumInfo> list) {
        this.jgh.cDB();
        this.jgh.yH(8);
        if (this.jgS == null) {
            this.jgS = new com.baidu.tieba.frs.view.a(getPageContext(), getNetRefreshListener());
        }
        this.jgS.setSubText(str);
        this.jgS.setListData(list);
        this.jgS.attachView(view, z);
    }

    private void a(com.baidu.tieba.tbadkCore.f fVar, List<RecmForumInfo> list) {
        if (this.jgh != null) {
            this.jgh.cDB();
            this.jgh.setTitle(this.jfZ);
            a(this.jgh.cnn(), fVar.errorMsg, true, list);
        }
    }

    private void b(com.baidu.tieba.tbadkCore.f fVar) {
        this.jgh.cDB();
        if (fVar.iQj) {
            showNetRefreshView(this.jgh.cnn(), TbadkCoreApplication.getInst().getString(R.string.net_error_text, new Object[]{fVar.errorMsg, Integer.valueOf(fVar.errorCode)}), true);
        } else {
            showNetRefreshView(this.jgh.cEi().cLD(), fVar.errorMsg, true);
        }
    }

    public void cCx() {
        hideLoadingView(this.jgh.cnn());
        this.jgh.bRB();
        if (this.jgh.cDz() instanceof com.baidu.tieba.frs.tab.c) {
            ((com.baidu.tieba.frs.tab.c) this.jgh.cDz()).cKi();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCy() {
        if (cCv() == 0 && com.baidu.tbadk.core.util.y.isEmpty(this.jfG.getThreadListIds())) {
            if (com.baidu.tbadk.core.util.y.isEmpty(this.jfG.getThreadList())) {
                this.jgh.bSr();
            } else {
                this.jgh.WY();
            }
        } else if (com.baidu.tbadk.core.util.y.getCount(this.jfG.getThreadList()) > 3) {
            this.jgh.WX();
        } else {
            this.jgh.cDW();
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
            cCx();
            this.jgh.cDH();
            com.baidu.tieba.tbadkCore.f cJw = this.jgz.cJw();
            boolean isEmpty = com.baidu.tbadk.core.util.y.isEmpty(this.jfG.getThreadList());
            if (cJw != null && isEmpty) {
                if (this.jgz.cJy() != 0) {
                    this.jgz.cJD();
                    this.jgh.cDH();
                } else {
                    a(cJw);
                }
                this.jgh.aa(this.jfG.isStarForum(), false);
                return;
            }
            a(cJw);
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

    public boolean cCz() {
        return cCA() && !cCB();
    }

    private boolean cCA() {
        if (cCZ() == null) {
            return false;
        }
        FrsViewData cCZ = cCZ();
        com.baidu.tbadk.core.data.aa aaVar = null;
        if (cCZ.getStar() != null && !StringUtils.isNull(cCZ.getStar().dMG())) {
            aaVar = new com.baidu.tbadk.core.data.aa();
        } else if (cCZ.getActivityHeadData() != null && com.baidu.tbadk.core.util.y.getCount(cCZ.getActivityHeadData().blR()) >= 1) {
            aaVar = cCZ.getActivityHeadData().blR().get(0);
        }
        return aaVar != null;
    }

    public boolean cCB() {
        if (cCZ() == null) {
            return false;
        }
        FrsViewData cCZ = cCZ();
        return (com.baidu.tbadk.core.util.y.isEmpty(cCZ.getShowTopThreadList()) && cCZ.getBusinessPromot() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCC() {
        boolean b2;
        if (!cCE()) {
            final PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
            privateForumPopInfoData.a(this.jfG.getPrivateForumTotalInfo().getPrivatePopInfo());
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(getActivity());
            if (this.jfG.getPrivateForumTotalInfo().bmM().private_forum_status.intValue() == 1 && (com.baidu.tbadk.core.util.au.isEmpty(privateForumPopInfoData.bmO()) || privateForumPopInfoData.bmR() != Integer.valueOf(this.forumId))) {
                privateForumPopInfoData.zW("create_success");
                privateForumPopInfoData.zX(TbadkCoreApplication.getInst().getString(R.string.frs_private_create_hint));
                privateForumPopInfoData.zY("https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.jfZ + "&nomenu=1");
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
    public void cCD() {
        if (cCE() || this.jfG.getPrivateForumTotalInfo().bmM().private_forum_status.intValue() != 1) {
            a((Integer) null, (Integer) null, true);
        } else {
            a(this.jfG.getPrivateForumTotalInfo().bmM().private_forum_audit_status, this.jfG.getPrivateForumTotalInfo().bmN(), false);
        }
    }

    public void a(Integer num, Integer num2, boolean z) {
        final int i = 2;
        if (this.jgh.cDN() != null) {
            TextView cDN = this.jgh.cDN();
            if (z) {
                cDN.setVisibility(8);
                return;
            }
            final String str = "";
            if (num.intValue() == 2) {
                cDN.setText("修改实名认证信息");
                cDN.setVisibility(0);
                str = "https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + this.forumId + "&nomenu=1";
            } else if (num2.intValue() >= 0 && num2.intValue() <= 100) {
                cDN.setText("目标已完成" + String.valueOf(num2) + "%");
                cDN.setVisibility(0);
                i = 1;
                str = "https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.jfZ + "&nomenu=1";
            } else {
                cDN.setVisibility(8);
                i = 0;
            }
            cDN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.24
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

    private boolean cCE() {
        return this.jfG == null || this.jfG.getPrivateForumTotalInfo() == null || this.jfG.getPrivateForumTotalInfo().bmM() == null || this.jfG.getUserData().getIs_manager() != 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yw(int i) {
        List<WindowToast> list;
        if (TbadkCoreApplication.isLogin() && this.jfG != null && (list = this.jfG.mWindowToast) != null && list.size() > 0) {
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
    public void cCF() {
        if (getActivity() != null && getActivity().getIntent() != null) {
            String stringExtra = getActivity().getIntent().getStringExtra(FrsActivityConfig.KEY_ACHIEVEMENT_URL);
            if (!TextUtils.isEmpty(stringExtra)) {
                getActivity().getIntent().removeExtra(FrsActivityConfig.KEY_ACHIEVEMENT_URL);
                AchievementActivityConfig achievementActivityConfig = new AchievementActivityConfig(getActivity());
                achievementActivityConfig.setUrl(stringExtra);
                if (this.jfG != null && this.jfG.getForumActiveInfo() != null) {
                    achievementActivityConfig.setShareUrl(this.jfG.getForumActiveInfo().forum_share_url);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, achievementActivityConfig));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCG() {
        if (this.jfG == null || this.jfG.getForum() != null) {
            this.jgh.cDT();
        } else if (this.jfG.getForum().getYuleData() != null && this.jfG.getForum().getYuleData().bqn()) {
            TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_VIEW);
            this.jgh.a(this.jfG.getForum().getYuleData().bqo());
        } else {
            this.jgh.cDT();
        }
    }

    private void Y(boolean z, boolean z2) {
        if (this.jgz != null && this.jfG != null && this.jgh != null && z) {
            if (!this.jgz.cJK() && this.jgz.cJA() == 1) {
                if (!this.jgz.cJI()) {
                    this.jfG.addCardVideoInfoToThreadList();
                    this.jfG.addVideoInfoToThreadListInTenAndFifteenFloor();
                }
                boolean z3 = false;
                if (this.jgh.cDU().r(com.baidu.tieba.card.data.n.iBd)) {
                    z3 = this.jfG.addHotTopicDataToThreadList();
                }
                if (!z3) {
                    this.jfG.addFeedForumDataToThreadList();
                }
                if (TbadkCoreApplication.getInst().isRecAppExist() && !com.baidu.tieba.funad.a.cNn()) {
                    this.jfG.addRecommendAppToThreadList(this);
                }
                if (!this.jgh.cDU().r(cb.eQL)) {
                    this.jfG.removeAlaLiveThreadData();
                }
                this.jfG.addSchoolRecommendToThreadList();
            }
            if (!this.jgh.cDU().r(cb.eQL)) {
                this.jfG.removeAlaInsertLiveData();
                this.jfG.removeAlaStageLiveDat();
            } else {
                this.jfG.addInsertLiveDataToThreadList();
                this.jfG.addStageLiveDataToThreadList();
            }
            this.jfG.checkLiveStageInThreadList();
            this.jfG.addNoticeThreadToThreadList();
            if (this.jgh.cDU().r(com.baidu.tieba.i.b.jUc)) {
                this.jfG.addGameRankListToThreadList(z2);
            }
            if (TbadkCoreApplication.isLogin() && (!this.jgz.cJK() || this.jgz.isNetFirstLoad)) {
                this.jfG.addUserRecommendToThreadList();
            }
            this.jfG.addVideoActivityToTop();
        }
    }

    public boolean cCH() {
        if (this.jgA != null && this.jgz != null) {
            this.jgA.a(this.jgz.getPageType(), this.jfG);
        }
        boolean z = false;
        if (this.jfG != null) {
            z = this.jfG.hasTab();
        }
        cCK();
        if (this.jgh != null) {
            this.jgh.cEg();
            this.jgh.cEh();
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yx(int i) {
        ax axVar = null;
        cCH();
        cCU();
        try {
            if (this.jfG != null) {
                this.jgh.a((ArrayList<com.baidu.adp.widget.ListView.n>) null, this.jfG);
                this.jgA.Ay(1);
                this.jgh.cDK();
                this.jgB.a(this.jfG, this.jgz.cJF());
                com.baidu.tieba.frs.tab.d AH = this.jgB.AH(this.jfG.getFrsDefaultTabId());
                if (AH != null && !TextUtils.isEmpty(AH.url)) {
                    axVar = new ax();
                    axVar.ext = AH.url;
                    axVar.stType = AH.name;
                }
                this.jgz.a(this.jfG.getFrsDefaultTabId(), 0, axVar);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(boolean z, boolean z2) {
        try {
            if (this.jfG != null && this.jgB != null && this.jgz != null) {
                if (!this.jgh.cDU().r(cb.eQL)) {
                    this.jfG.removeAlaLiveThreadData();
                }
                boolean isEmpty = com.baidu.tbadk.core.util.y.isEmpty(this.jfG.getGameTabInfo());
                this.jgh.qD(isEmpty);
                if (!isEmpty) {
                    if (this.jgT == null) {
                        this.jgT = new com.baidu.tieba.frs.vc.e(this, (NoPressedRelativeLayout) this.mRootView);
                    }
                    if (this.gVH == null) {
                        this.gVH = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
                    }
                } else {
                    this.jgT = null;
                    this.gVH = null;
                }
                if (this.jfG.getForum() != null) {
                    this.jfZ = this.jfG.getForum().getName();
                    this.forumId = this.jfG.getForum().getId();
                }
                if (this.jfG.hasTab()) {
                    this.jgB.a(this.jfG, this.jgz.cJF());
                }
                if (z) {
                    Y(true, z);
                } else {
                    Y(this.jgu, z);
                }
                cCH();
                if (this.jgH != null) {
                    this.jgH.a(this.jgA, this.jfG);
                }
                if (this.jfG.getPage() != null) {
                    setHasMore(this.jfG.getPage().bmF());
                }
                ArrayList<com.baidu.adp.widget.ListView.n> a2 = this.jgK.a(z2, true, this.jfG.getThreadList(), null, z, false);
                if (a2 != null) {
                    this.jfG.setThreadList(a2);
                }
                this.jfG.removeRedundantUserRecommendData();
                this.jfI = this.jfG.getTopThreadSize();
                if (this.jgd != null) {
                    this.jgc = true;
                    this.jgd.JA(this.jfI);
                    com.baidu.tieba.frs.d.a.a(this, this.jfG.getForum(), this.jfG.getThreadList(), this.jgc, getPn());
                }
                if (this.jgz.cJA() == 1) {
                    cCO();
                    if (!z && this.jgz.getPn() == 1) {
                        cCJ();
                    }
                }
                if (this.jgI != null) {
                    this.jgI.db(this.jgB.cLM());
                }
                cCx();
                this.jgh.cDC();
                this.jgh.aa(true, false);
                if (z && this.jfG.isFirstTabEqualAllThread()) {
                    com.baidu.adp.lib.f.e.mA().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.25
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!FrsFragment.this.jgs && com.baidu.adp.lib.util.j.isNetWorkAvailable() && !FrsFragment.this.jgh.cEj()) {
                                FrsFragment.this.jgh.cEe();
                            }
                        }
                    });
                }
                if (this.jfG.getForum() != null) {
                    this.jgh.Kh(this.jfG.getForum().getWarningMsg());
                }
                if (this.jfG != null && this.jfG.getFrsVideoActivityData() != null && com.baidu.tbadk.core.sharedPref.b.brQ().getLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 0L) == 0) {
                    com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.26
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsFragment.this.jgh.cEc();
                        }
                    }, 1000L);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FRS_SHOW_AR_ENTRY, this));
                this.jgh.cDw();
                if (this.jfG != null && this.jfG.getForum() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ENTER_FORUM, new VisitedForumData(this.jfG.getForum().getId(), this.jfG.getForum().getName(), this.jfG.getForum().getImage_url(), String.valueOf(System.currentTimeMillis() / 1000), ConstantData.Forum.SPECAIL_FORUM_TYPE_LIVE.equals(this.jfG.getForum().special_forum_type), this.jfG.getForum().getThemeColorInfo(), this.jfG.getForum().getMember_num())));
                }
                this.jgX.a(this.jfG.bottomMenuList, this.jfG.getForum());
                cDj();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void cCI() {
        if (this.jgz != null && this.jgz.cJA() == 1) {
            this.jgA.k(this.jfG);
        }
    }

    public void qu(boolean z) {
        com.baidu.tieba.s.c.dMr().b(getUniqueId(), z);
    }

    public void cCJ() {
        if (this.jgN == null) {
            this.jgN = new com.baidu.tieba.frs.live.a(this, com.baidu.adp.lib.f.b.toInt(this.forumId, 0));
        }
        this.jgN.cJh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.tbadkCore.m mVar) {
        try {
            if (!this.jgs && mVar != null && this.jfG != null) {
                this.jfG.receiveData(mVar);
                Z(true, false);
                Looper.myQueue().addIdleHandler(this.jhn);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void cCK() {
        if (this.jgz != null) {
            Ke(this.jgz.getPageType());
        } else {
            Ke("normal_page");
        }
    }

    private void Ke(String str) {
        qv("frs_page".equals(str));
        if (this.jgH != null) {
            this.jgH.a(this.jgA, this.jgh, this.jfG);
        }
    }

    public void qv(boolean z) {
        if (this.jgL != null) {
            this.jgL.cLw();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.s.c.dMr().A(getUniqueId());
        registerResponsedEventListener(TopToastEvent.class, this.mTopToastEventListener);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.frs_activity, viewGroup, false);
            this.jfT = new com.baidu.tieba.frs.entelechy.a();
            this.jgH = this.jfT.cFS();
            this.jfS = TbadkCoreApplication.getInst().getString(R.string.frs_title_new_area);
            this.jgA = new com.baidu.tieba.frs.vc.h(this, this.jfT, (FrsHeaderViewContainer) this.mRootView.findViewById(R.id.header_view_container));
            this.jgB = new FrsTabViewController(this, this.mRootView);
            this.jgB.registerListener();
            this.jgA.a(this.jgB);
            this.jgB.a(this.jhv);
            Intent intent = getActivity().getIntent();
            if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                this.jfV = true;
            }
            this.jgh = new q(this, this.jhR, this.jfT, this.jfV, this.jgA);
            this.jgX = new com.baidu.tieba.frs.brand.buttommenu.a(getPageContext(), this.mRootView);
        } else {
            if (this.mRootView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            if (this.jgB != null) {
                this.jgB.registerListener();
            }
            this.jgh.cEb();
            this.mRootView.setLeft(0);
            this.mRootView.setRight(com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getContext()));
        }
        this.jhb = true;
        this.fJm = System.currentTimeMillis() - currentTimeMillis;
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        ArrayList<com.baidu.adp.widget.ListView.n> arrayList = null;
        this.iIQ = System.currentTimeMillis();
        long j = this.iIQ;
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.jge = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.iIQ = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            S(intent);
        }
        this.fJl = j - this.iIQ;
        this.jgd = new com.baidu.tieba.tbadkCore.data.f("frs", com.baidu.tieba.tbadkCore.data.f.nvS);
        if (this.jgz == null) {
            this.jgz = new FrsModelController(this, this.jhM);
            this.jgz.a(this.jhu);
            this.jgz.init();
        }
        this.jgz.setSchemeUrl(this.mSchemeUrl);
        if (intent != null) {
            this.jgz.aj(intent.getExtras());
        } else if (bundle != null) {
            this.jgz.aj(bundle);
        } else {
            this.jgz.aj(null);
        }
        if (intent != null) {
            this.jgA.as(intent.getExtras());
        } else if (bundle != null) {
            this.jgA.as(bundle);
        } else {
            this.jgA.as(null);
        }
        this.jgg = getVoiceManager();
        this.jgO = new p(getPageContext(), this);
        initUI();
        initData(bundle);
        if (!cDc()) {
            this.jgF = new at(getActivity(), this.jgh, this.jgA);
            this.jgF.qS(true);
        }
        this.jgg = getVoiceManager();
        if (this.jgg != null) {
            this.jgg.onCreate(getPageContext());
        }
        if (FrsActivityConfig.FRS_FROM_FLUTTER_BCASTEDIT.equals(getFrom()) && !this.hasInit) {
            int i = com.baidu.tbadk.core.sharedPref.b.brQ().getInt("key_forum_broadcast_edit_tip_number", 0);
            if (i < 2) {
                com.baidu.tbadk.core.sharedPref.b.brQ().putInt("key_forum_broadcast_edit_tip_number", i + 1);
                cCQ();
            } else if (Build.VERSION.SDK_INT >= 23) {
                if (Settings.canDrawOverlays(getContext())) {
                    cCR();
                } else {
                    new BdTopToast(getContext()).zn(false).UN(getContext().getString(R.string.forum_broadcast_copy_no_permission_hint)).aR(this.jgh.cnn());
                }
            } else {
                cCR();
            }
        }
        if (FrsActivityConfig.FRS_FROM_FORUM_RULE_EDIT.equals(getFrom()) && !this.hasInit) {
            if (Build.VERSION.SDK_INT >= 23) {
                if (Settings.canDrawOverlays(getContext())) {
                    cCS();
                } else if (Build.VERSION.SDK_INT < 23 || !com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean("key_forum_rule_dialog_show_frs", false)) {
                    cCS();
                    com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean("key_forum_rule_dialog_show_frs", true);
                }
            } else {
                cCS();
            }
        }
        if (com.baidu.tbadk.k.d.bCB().bCC()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
            if (this.jgi != null) {
                this.jgi.setVisibility(8);
            }
        }
        new com.baidu.tieba.frs.mc.i();
        int i2 = -1;
        if (this.jgK != null && this.jgK.cJs() != null) {
            i2 = this.jgK.cJs().cCv();
            arrayList = this.jgK.cJs().getDataList();
        }
        this.jgK = new com.baidu.tieba.frs.mc.c(this, this.jhP);
        this.jgK.cJs().setHasMore(i2);
        if (arrayList != null && arrayList.size() > 0) {
            this.jgK.cJs().aC(arrayList);
        }
        this.jgD = new com.baidu.tieba.frs.smartsort.a(this);
        this.jgL = new com.baidu.tieba.frs.vc.j(this);
        this.jgI = new com.baidu.tieba.frs.vc.a(getPageContext(), this.jgz.cJH());
        this.jgE = new com.baidu.tieba.frs.mc.b(this);
        this.jgJ = new com.baidu.tieba.frs.mc.d(this);
        this.jgC = new com.baidu.tieba.frs.mc.h(this);
        this.jgM = new com.baidu.tieba.frs.mc.a(this);
        this.jgP = new com.baidu.tieba.frs.vc.c(this);
        this.jgQ = new com.baidu.tieba.frs.mc.e(this, getUniqueId());
        this.jgV = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "frs");
        this.jgW = new com.baidu.tieba.ala.b(getPageContext());
        this.jgY = new com.baidu.tieba.frs.sportspage.notification.a(getPageContext());
        registerListener(this.jhD);
        registerListener(this.mMemListener);
        registerListener(this.jhB);
        registerListener(this.jhQ);
        registerListener(this.jhN);
        registerListener(this.jhx);
        registerListener(this.jhy);
        registerListener(this.jhz);
        registerListener(this.jhA);
        registerListener(this.jho);
        registerListener(this.jhp);
        registerListener(this.ahl);
        registerListener(this.jhq);
        registerListener(this.jhV);
        registerListener(this.jhF);
        this.jhG.setSelfListener(true);
        this.jhG.setTag(getPageContext().getUniqueId());
        registerListener(this.jhG);
        registerListener(this.jht);
        registerListener(this.jhH);
        registerListener(this.jhE);
        registerListener(this.jhJ);
        registerListener(this.jhK);
        registerListener(this.jhL);
        this.jhW.setTag(getPageContext().getUniqueId());
        MessageManager.getInstance().registerListener(this.jhW);
        registerListener(this.jhX);
        registerListener(this.jhY);
        registerListener(this.jhZ);
        registerListener(this.jhs);
        registerListener(this.jia);
        registerListener(this.jhI);
        registerListener(this.jhr);
        registerListener(this.jib);
        registerListener(this.jic);
        registerListener(this.jie);
        registerListener(this.jif);
        this.jgh.qF(false);
        if (!cDc() && !this.hasInit) {
            showLoadingView(this.jgh.cnn(), true);
            this.jgz.T(3, false);
        }
        av avVar = new av() { // from class: com.baidu.tieba.frs.FrsFragment.29
            @Override // com.baidu.tieba.frs.av
            public void g(boolean z, boolean z2, int i3) {
                if (FrsFragment.this.jgh != null) {
                    if (i3 == 1) {
                        FrsFragment.this.jgh.yI(z ? 0 : 8);
                    } else if (i3 == 2) {
                        FrsFragment.this.jgh.yK(z ? 0 : 8);
                    }
                    if (!z2) {
                        FrsFragment.this.jha = z;
                    }
                    if (FrsFragment.this.jgh.cDU() != null && (i3 == 2 || (FrsFragment.this.jgz != null && FrsFragment.this.jgz.cJB()))) {
                        FrsFragment.this.jgh.cDU().notifyDataSetChanged();
                    }
                    if (FrsFragment.this.cCs() != null) {
                        FrsTabViewController.b cLN = FrsFragment.this.cCs().cLN();
                        if (cLN != null) {
                            if ((cLN.fragment instanceof FrsCommonTabFragment) && (i3 == 2 || cLN.tabId == 502)) {
                                ((FrsCommonTabFragment) cLN.fragment).cFH();
                            } else if ((cLN.fragment instanceof FrsNewAreaFragment) && (i3 == 2 || cLN.tabId == 503)) {
                                FrsNewAreaFragment frsNewAreaFragment = (FrsNewAreaFragment) cLN.fragment;
                                frsNewAreaFragment.cFH();
                                if (frsNewAreaFragment.cJS() != null) {
                                    com.baidu.tieba.frs.mc.g cJS = frsNewAreaFragment.cJS();
                                    cJS.qU(!z);
                                    if (i3 == 1) {
                                        cJS.qI(!z);
                                    } else if (i3 == 2) {
                                        cJS.qI(true);
                                    }
                                }
                            } else if (cLN.fragment instanceof FrsGoodFragment) {
                                ((FrsGoodFragment) cLN.fragment).cFH();
                            }
                        }
                        if (FrsFragment.this.cCs().cLE() != null) {
                            FrsFragment.this.cCs().cLE().setmDisallowSlip(z);
                            FrsFragment.this.cCs().rE(z);
                        }
                    }
                    if (FrsFragment.this.jgh.cDA() != null) {
                        FrsFragment.this.jgh.qC(!z);
                    }
                    if (FrsFragment.this.getActivity() instanceof FrsActivity) {
                        ((FrsActivity) FrsFragment.this.getActivity()).qs(!z);
                    }
                    if (FrsFragment.this.jgX != null) {
                        FrsFragment.this.jgX.ra(!z);
                    }
                    FrsFragment.this.jgh.qH(!z);
                    if (i3 == 1) {
                        FrsFragment.this.jgh.qI(z ? false : true);
                    } else if (i3 == 2) {
                        FrsFragment.this.jgh.qI(true);
                    }
                }
            }

            @Override // com.baidu.tieba.frs.av
            public void cl(int i3, int i4) {
                if (FrsFragment.this.jgh != null) {
                    if (i4 == 1) {
                        FrsFragment.this.jgh.yJ(i3);
                    } else if (i4 == 2) {
                        FrsFragment.this.jgh.yL(i3);
                    }
                }
            }

            @Override // com.baidu.tieba.frs.av
            public void yB(int i3) {
                if (FrsFragment.this.getContext() != null) {
                    if (i3 == 1) {
                        com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getContext(), R.string.frs_multi_delete_max_num);
                    } else if (i3 == 2 && FrsFragment.this.jgh != null) {
                        new BdTopToast(FrsFragment.this.getContext()).zn(false).UN(FrsFragment.this.getContext().getString(R.string.frs_move_area_max_num)).aR(FrsFragment.this.jgh.cnn());
                    }
                }
            }
        };
        b.cBr().a(avVar);
        com.baidu.tieba.frs.a.cBk().a(avVar);
        this.jgh.b(new e.a() { // from class: com.baidu.tieba.frs.FrsFragment.30
            @Override // com.baidu.tieba.NEGFeedBack.e.a
            public void a(DeleteThreadHttpResponseMessage deleteThreadHttpResponseMessage) {
                boolean z;
                int i3 = 0;
                if (deleteThreadHttpResponseMessage != null) {
                    FrsFragment.this.jgh.bKl();
                    FrsFragment.this.jgh.cEd();
                    FrsNewAreaFragment frsNewAreaFragment = null;
                    if (FrsFragment.this.jgB == null || FrsFragment.this.jgB.cLN() == null || !(FrsFragment.this.jgB.cLN().fragment instanceof FrsNewAreaFragment)) {
                        z = false;
                    } else {
                        frsNewAreaFragment = (FrsNewAreaFragment) FrsFragment.this.jgB.cLN().fragment;
                        z = true;
                    }
                    if (deleteThreadHttpResponseMessage.getError() == 0) {
                        String text = !TextUtils.isEmpty(deleteThreadHttpResponseMessage.getText()) ? deleteThreadHttpResponseMessage.getText() : FrsFragment.this.getString(R.string.delete_fail);
                        if (deleteThreadHttpResponseMessage.getRetType() == 1211066) {
                            if (FrsFragment.this.izo == null) {
                                FrsFragment.this.izo = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.izo.Au(text);
                            FrsFragment.this.izo.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.30.1
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.izo.jG(false);
                            FrsFragment.this.izo.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.izo.bqx();
                        } else if (deleteThreadHttpResponseMessage.getRetType() == 1211067) {
                            if (FrsFragment.this.izo == null) {
                                FrsFragment.this.izo = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.izo.Au(text);
                            FrsFragment.this.izo.a(R.string.know, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.30.2
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.izo.jG(false);
                            FrsFragment.this.izo.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.izo.bqx();
                        } else {
                            FrsFragment.this.jgh.aX(deleteThreadHttpResponseMessage.getText(), ContextCompat.getColor(FrsFragment.this.getContext(), deleteThreadHttpResponseMessage.getRetType() == 1 ? R.color.nav_bar_tip_error : R.color.cp_link_tip_a_alpha95));
                        }
                        if (z && frsNewAreaFragment != null) {
                            frsNewAreaFragment.dB(deleteThreadHttpResponseMessage.getSuccessItems());
                        }
                        FrsFragment.this.dj(deleteThreadHttpResponseMessage.getSuccessItems());
                        b.cBr().di(deleteThreadHttpResponseMessage.getSuccessItems());
                        for (com.baidu.adp.widget.ListView.n nVar : FrsFragment.this.jfG.getThreadList()) {
                            if (nVar instanceof ca) {
                                i3++;
                                continue;
                            }
                            if (i3 >= 6) {
                                break;
                            }
                        }
                        if (i3 < 6) {
                            FrsFragment.this.bRc();
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
        if (this.jgB != null) {
            this.jgB.jLG = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dj(List<String> list) {
        if (!com.baidu.tbadk.core.util.y.isEmpty(list)) {
            ArrayList<com.baidu.adp.widget.ListView.n> threadList = this.jfG.getThreadList();
            if (!com.baidu.tbadk.core.util.y.isEmpty(threadList) && this.jgh.getListView() != null && this.jgh.getListView().getData() != null) {
                Iterator<com.baidu.adp.widget.ListView.n> it = threadList.iterator();
                List<com.baidu.adp.widget.ListView.n> data = this.jgh.getListView().getData();
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
                                this.jgK.d(next);
                                this.jgh.getListView().getAdapter().notifyItemRemoved(i);
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
    public void cBp() {
        if (!com.baidu.tbadk.core.util.y.isEmpty(com.baidu.tieba.frs.a.cBk().cBo()) && this.jgh.getListView() != null && this.jgh.getListView().getData() != null) {
            ArrayList<com.baidu.adp.widget.ListView.n> threadList = this.jfG.getThreadList();
            if (!com.baidu.tbadk.core.util.y.isEmpty(threadList)) {
                Iterator<com.baidu.adp.widget.ListView.n> it = threadList.iterator();
                List<com.baidu.adp.widget.ListView.n> data = this.jgh.getListView().getData();
                int count = com.baidu.tbadk.core.util.y.getCount(com.baidu.tieba.frs.a.cBk().cBo());
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.n next = it.next();
                    if (next instanceof ca) {
                        cb cbVar = ((ca) next).eJQ;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= count) {
                                break;
                            } else if (!com.baidu.tbadk.core.util.au.equals(com.baidu.tieba.frs.a.cBk().cBo().get(i2).getId(), cbVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.jgK.d(next);
                                this.jgh.getListView().getAdapter().notifyItemRemoved(i);
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
    public void bRw() {
        if (isAdded() && this.gDb && !isLoadingViewAttached()) {
            showLoadingView(this.jgh.cnn(), true);
        }
    }

    @Override // com.baidu.tieba.frs.am
    public void bRx() {
        if (isAdded() && this.gDb && isLoadingViewAttached()) {
            hideLoadingView(this.jgh.cnn());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (cDc()) {
            showLoadingView(this.jgh.cnn(), true);
            this.jgh.yM(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.jgz.S(3, true);
            getListView().scrollToPosition(0);
        }
    }

    private void yy(int i) {
        String str = "";
        if (this.jfG != null && this.jfG.getForum() != null) {
            str = this.jfG.getForum().getId();
        }
        if (!StringUtils.isNull(str)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13008").dR("fid", str).dR("obj_type", "4").ap("obj_locate", i).dR("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    @Override // com.baidu.tieba.frs.am
    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.aa aaVar) {
        if (aaVar != null) {
            this.fNk = aaVar.bFF();
            this.jgR = aaVar.bFG();
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
                this.jfZ = uri.getQueryParameter("name");
                this.mFrom = uri.getQueryParameter("from");
                if (!StringUtils.isNull(this.jfZ)) {
                    intent.putExtra("name", this.jfZ);
                }
                if (!StringUtils.isNull(this.mFrom)) {
                    intent.putExtra("from", this.mFrom);
                }
                TiebaStatic.log(TbadkCoreStatisticKey.AS_INVOKE_TIEBA);
            }
            if (StringUtils.isNull(this.jfZ) && uri != null) {
                if (com.baidu.tbadk.BdToken.f.r(uri)) {
                    com.baidu.tbadk.BdToken.f.bhH().b(uri, this.jhO);
                } else {
                    com.baidu.tieba.frs.d.g V = com.baidu.tieba.frs.d.l.V(intent);
                    if (V != null) {
                        this.jfZ = V.forumName;
                        if (V.jJk == null || V.jJk.equals("aidou")) {
                        }
                    }
                }
                if (!StringUtils.isNull(this.jfZ)) {
                    intent.putExtra("name", this.jfZ);
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
                    FrsFragment.this.jfZ = (String) hashMap.get(com.baidu.tbadk.BdToken.f.eDL);
                }
                if ((hashMap.get(com.baidu.tbadk.BdToken.f.eEd) instanceof String) && !TextUtils.isEmpty((String) hashMap.get(com.baidu.tbadk.BdToken.f.eEd))) {
                    com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.31.1
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsFragment.this.jgB.sT(301);
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
        this.jgg = getVoiceManager();
        if (this.jgg != null) {
            this.jgg.onStart(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        Intent intent;
        long j = 0;
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.fsV);
        if (bundle != null) {
            this.jfZ = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            j = bundle.getLong(FrsActivityConfig.FRS_FAKE_THREAD_ID, 0L);
        } else if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
            this.jfZ = intent.getStringExtra("name");
            this.mFrom = intent.getStringExtra("from");
            this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
            j = intent.getLongExtra(FrsActivityConfig.FRS_FAKE_THREAD_ID, 0L);
        }
        if (getArguments() != null) {
            this.jga = getArguments().getBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, false);
        }
        if (TextUtils.isEmpty(this.mFrom) || FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
        }
        if (this.mIsLogin) {
            registerListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL, this.fsV);
        }
        this.jgA.as(bundle);
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
        com.baidu.tieba.s.c.dMr().B(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.jhV);
        MessageManager.getInstance().unRegisterListener(this.jhG);
        unRegisterResponsedEventListener();
        this.jgL.destroy();
        jgl = null;
        if (this.jgg != null) {
            this.jgg.onDestory(getPageContext());
        }
        com.baidu.tieba.recapp.report.a.remove("FRS");
        this.jgg = null;
        com.baidu.tieba.card.t.csu().pB(false);
        if (this.jfG != null && this.jfG.getForum() != null) {
            ag.cEE().gr(com.baidu.adp.lib.f.b.toLong(this.jfG.getForum().getId(), 0L));
        }
        if (this.jgN != null) {
            this.jgN.onDestory();
        }
        if (this.jgh != null) {
            com.baidu.tieba.frs.d.k.a(this.jgh, this.jfG, getForumId(), false, null);
            this.jgh.onDestroy();
        }
        if (this.jgk != null) {
            this.jgk.removeAllViews();
            this.jgk.setVisibility(8);
        }
        if (this.jhh != null) {
            this.jhh.cancel();
        }
        if (this.jhi != null) {
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.jhi);
        }
        this.jhg = null;
        super.onDestroy();
        try {
            if (this.jgt != null) {
                this.jgt.bEa();
            }
            if (this.jgh != null) {
                this.jgh.release();
            }
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.jgA.cIZ();
        Looper.myQueue().removeIdleHandler(this.jhn);
        if (this.jgz != null) {
            this.jgz.bYN();
        }
        if (this.jgF != null) {
            this.jgF.cEM();
        }
        if (this.jgI != null) {
            this.jgI.destory();
        }
        if (this.jgD != null) {
            this.jgD.onDestroy();
        }
        if (this.jgT != null) {
            this.jgT.onDestory();
        }
        if (this.jgM != null) {
            this.jgM.onDestroy();
        }
        if (this.jgV != null) {
            this.jgV.onDestroy();
        }
        if (this.jgW != null) {
            this.jgW.onDestroy();
        }
        com.baidu.tieba.recapp.c.a.dEe().dEh();
        com.baidu.tieba.frs.d.m.cKD();
        if (this.jgB != null) {
            this.jgB.a((FrsTabViewController.a) null);
            this.jgB.cLP();
        }
        if (this.jgZ != null) {
            this.jgZ.onDestroy();
        }
        b.cBr().a(null);
        com.baidu.tieba.frs.a.cBk().a(null);
        if (this.jhm != null) {
            this.jhm.cKB();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.jfZ);
        bundle.putString("from", this.mFrom);
        this.jgz.onSaveInstanceState(bundle);
        if (this.jgg != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            this.jgg.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.jgM != null) {
            this.jgM.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.jgh != null) {
            this.jgh.cDH();
            this.jgh.onResume();
        }
        this.jgC.rv(true);
        this.jgu = true;
        if (jfY) {
            jfY = false;
            if (this.jgh != null) {
                this.jgh.startPullRefresh();
                return;
            }
            return;
        }
        if (this.jgg != null) {
            this.jgg.onResume(getPageContext());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_RESUME));
        if (this.jgh != null) {
            this.jgh.qJ(false);
        }
        if (this.jgU) {
            refresh(6);
            this.jgU = false;
        }
        if (this.jhd != null && getActivity() != null) {
            if (NotificationManagerCompat.from(getActivity()).areNotificationsEnabled()) {
                com.baidu.tbadk.coreExtra.messageCenter.f.byA().setSignAlertOn(true);
                com.baidu.tbadk.coreExtra.messageCenter.f.byA().setSignAlertTime(this.jhd.getHours(), this.jhd.getMinutes());
                if (this.jgh != null) {
                    com.baidu.tbadk.coreExtra.messageCenter.f.byA().a(getTbPageContext().getPageActivity(), this.jgh.cnn());
                }
            }
            this.jhd = null;
        }
        cDj();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
    }

    public boolean cCL() {
        Intent intent;
        if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
            return false;
        }
        return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
    }

    public void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.jfZ = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.jgb = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.jgb) {
                cCM();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCM() {
        this.jgh.startPullRefresh();
    }

    public void closeActivity() {
        com.baidu.tieba.frs.d.l.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.mFrom);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.jgh.setTitle(this.jfZ);
        } else {
            this.jgh.setTitle("");
            this.mFlag = 1;
        }
        this.jgh.a(this.jhT);
        this.jgh.addOnScrollListener(this.mScrollListener);
        this.jgh.g(this.jdt);
        this.jgh.cDU().a(this.jhS);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jhb) {
            this.jgh.onChangeSkinType(i);
            this.jgA.Ax(i);
            this.jgB.onChangeSkinType(i);
            if (this.jgj != null) {
                this.jgj.onChangeSkinType(i);
            }
            if (this.jgS != null) {
                this.jgS.onChangeSkinType();
            }
            if (this.jgX != null) {
                this.jgX.onChangeSkinType(getPageContext(), i);
            }
            if (this.izo != null) {
                com.baidu.tbadk.r.a.a(getPageContext(), this.izo.getRealView());
            }
            if (this.jgT != null) {
                this.jgT.onChangeSkinType(getPageContext(), i);
            }
        }
    }

    public void yz(int i) {
        if (!this.mIsLogin) {
            if (this.jfG != null && this.jfG.getAnti() != null) {
                this.jfG.getAnti().setIfpost(1);
            }
            if (i == 0) {
                bh.skipToLoginActivity(getActivity());
            }
        } else if (this.jfG != null) {
            if (i == 0) {
                com.baidu.tieba.frs.d.m.g(this, 0);
            } else {
                this.jgh.cDJ();
            }
        }
    }

    public void refresh() {
        com.baidu.tieba.a.d.bKP().Ex("page_frs");
        refresh(3);
    }

    public void refresh(int i) {
        this.jgs = false;
        cCU();
        if (this.jgh != null && this.jgh.cDy() != null) {
            this.jgh.cDy().cQu();
        }
        if (this.jgz != null) {
            this.jgz.S(i, true);
        }
    }

    private void cCN() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.f.h.mB().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.37
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.Tu(FrsFragment.this.jfZ);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCO() {
        cCU();
        try {
            if (this.jfG != null) {
                this.jgh.bYh();
                this.jgh.qC(cDi());
                if (!com.baidu.tieba.frs.vc.h.n(this.jfG) || !com.baidu.tieba.frs.vc.h.m(this.jfG)) {
                }
                if (this.jfG.getForum() != null) {
                    this.jfZ = this.jfG.getForum().getName();
                    this.forumId = this.jfG.getForum().getId();
                }
                if (this.jfG.getPage() != null) {
                    setHasMore(this.jfG.getPage().bmF());
                }
                this.jgh.setTitle(this.jfZ);
                this.jgh.setForumName(this.jfZ);
                TbadkCoreApplication.getInst().setDefaultBubble(this.jfG.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.jfG.getUserData().getBimg_end_time());
                cCN();
                cCP();
                ArrayList<com.baidu.adp.widget.ListView.n> threadList = this.jfG.getThreadList();
                if (threadList != null) {
                    this.jgh.a(threadList, this.jfG);
                    com.baidu.tieba.frs.d.c.A(this.jgh);
                    this.jgA.Ay(getPageNum());
                    this.jgA.j(this.jfG);
                    this.jgB.a(this.jfG, this.jgz.cJF());
                    this.jgh.cDK();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void cCP() {
        if (this.jfG != null) {
            if (this.jfG.getIsNewUrl() == 1) {
                this.jgh.cDU().setFromCDN(true);
            } else {
                this.jgh.cDU().setFromCDN(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.jgC.rv(false);
        this.jgu = false;
        this.jgh.onPause();
        if (this.jgg != null) {
            this.jgg.onPause(getPageContext());
        }
        this.jgh.qJ(true);
        if (this.jgI != null) {
            this.jgI.cKG();
        }
        com.baidu.tbadk.BdToken.c.bhn().bhy();
        if (this.jhm != null) {
            this.jhm.cKB();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.jgB != null && this.jgB.cLN() != null && (this.jgB.cLN().fragment instanceof BaseFragment)) {
            ((BaseFragment) this.jgB.cLN().fragment).setPrimary(z);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.t.csu().pB(false);
        qu(false);
        if (this.jfG != null && this.jfG.getForum() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            com.baidu.tbadk.distribute.a.bAU().b(getPageContext().getPageActivity(), "frs", this.jfG.getForum().getId(), 0L);
        }
        if (this.jgg != null) {
            this.jgg.onStop(getPageContext());
        }
        if (getListView() != null) {
            getListView().getRecycledViewPool().clear();
        }
        this.jgA.btX();
        com.baidu.tbadk.util.ab.bFI();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            if (this.jgA != null) {
                this.jgA.cb(isPrimary());
            }
            if (this.jgh != null) {
                this.jgh.cb(isPrimary());
                this.jgh.qJ(!isPrimary());
            }
        }
    }

    private void cCQ() {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.nA(2);
        aVar.jG(false);
        FrsBroadcastCopyGuideDialogView frsBroadcastCopyGuideDialogView = new FrsBroadcastCopyGuideDialogView(getPageContext().getPageActivity());
        frsBroadcastCopyGuideDialogView.setConfirmButtonListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.38
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aVar != null) {
                    aVar.dismiss();
                    FrsFragment.this.cCR();
                }
            }
        });
        aVar.bn(frsBroadcastCopyGuideDialogView);
        aVar.b(getPageContext()).bqx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCR() {
        com.baidu.tbadk.k.d.bCB().a(new com.baidu.tbadk.k.a(getContext()));
        com.baidu.tbadk.k.d.bCB().C(85, 0, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds144));
        if (com.baidu.tbadk.k.d.bCB().init()) {
            ((BaseFragmentActivity) getPageContext().getOrignalPage()).grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.frs.FrsFragment.39
                @Override // com.baidu.tbadk.core.e
                public void onPermissionResult(boolean z) {
                    if (!z) {
                        new BdTopToast(FrsFragment.this.getContext()).zn(false).UN(FrsFragment.this.getContext().getString(R.string.forum_broadcast_copy_no_permission_hint)).aR(FrsFragment.this.jgh.cnn());
                        return;
                    }
                    com.baidu.tbadk.k.d.bCB().lc(true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                    if (FrsFragment.this.jgi != null) {
                        FrsFragment.this.jgi.setVisibility(8);
                    }
                }
            }, true);
        }
    }

    private void cCS() {
        com.baidu.tbadk.k.d.bCB().a(new com.baidu.tbadk.k.b(getContext()));
        com.baidu.tbadk.k.d.bCB().C(85, 0, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds144));
        if (com.baidu.tbadk.k.d.bCB().init()) {
            ((BaseFragmentActivity) getPageContext().getOrignalPage()).grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.frs.FrsFragment.40
                @Override // com.baidu.tbadk.core.e
                public void onPermissionResult(boolean z) {
                    if (z) {
                        com.baidu.tbadk.k.d.bCB().lc(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                        if (FrsFragment.this.jgi != null) {
                            FrsFragment.this.jgi.setVisibility(8);
                        }
                    }
                }
            }, true);
        }
    }

    public void Kf(String str) {
        new BdTopToast(getContext(), 3000).zn(true).UN(str).aR(this.jgh.cnn());
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (b.cBr().cBl()) {
                b.cBr().reset();
                return true;
            } else if (com.baidu.tieba.frs.a.cBk().cBl()) {
                if (this.jgh != null && this.jgh.cDY()) {
                    this.jgh.cDZ();
                    return true;
                }
                com.baidu.tieba.frs.a.cBk().reset();
                return true;
            } else if (this.jgh != null) {
                return this.jgh.cDG();
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
        com.baidu.tbadk.distribute.a.bAU().a(advertAppInfo, this.forumId, 0L, "FRS", str, getPn());
    }

    @Override // com.baidu.tieba.recapp.p
    public void cCT() {
        cCp().cCT();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.jgg == null) {
            this.jgg = VoiceManager.instance();
        }
        return this.jgg;
    }

    public BdRecyclerView getListView() {
        if (this.jgh == null) {
            return null;
        }
        return this.jgh.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void cCU() {
        if (this.jgg != null) {
            this.jgg.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.a
    public com.baidu.adp.lib.d.b<TbImageView> buM() {
        if (this.flN == null) {
            this.flN = UserIconBox.E(getPageContext().getPageActivity(), 8);
        }
        return this.flN;
    }

    public void cCV() {
        if (getFragmentActivity() != null && getFragmentActivity().getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.q onGetPreLoadListView() {
        return getListView().getPreLoadHandle();
    }

    @Override // com.baidu.tieba.frs.ap
    public NavigationBar bVd() {
        if (this.jgh == null) {
            return null;
        }
        return this.jgh.bVd();
    }

    public FRSRefreshButton cCW() {
        return this.jgj;
    }

    public void c(LinearLayout linearLayout) {
        if (linearLayout != null) {
            this.jgk = linearLayout;
        }
    }

    public void a(FRSRefreshButton fRSRefreshButton) {
        if (fRSRefreshButton != null) {
            this.jgj = fRSRefreshButton;
            this.jgj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.47
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (FrsFragment.this.jgB != null) {
                        FrsTabViewController.b cLN = FrsFragment.this.jgB.cLN();
                        if (cLN != null && cLN.fragment != null && (cLN.fragment instanceof ao)) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                            ((ao) cLN.fragment).cBZ();
                            ((ao) cLN.fragment).bSq();
                            return;
                        }
                        FrsFragment.this.cCu().startPullRefresh();
                    }
                }
            });
        }
    }

    public void cCX() {
        if (this.jgj != null) {
            this.jgj.hide();
        }
    }

    public void cCY() {
        if (this.jgj != null) {
            this.jgj.show();
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
                if (bdUniqueId == u.jjW) {
                    if (FrsFragment.this.jgh != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11752").dR("fid", FrsFragment.this.forumId).dR("obj_locate", "1"));
                        FrsFragment.this.jgh.startPullRefresh();
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
                                if (readThreadHistory != null && !readThreadHistory.TA(cbVar.getId())) {
                                    readThreadHistory.Tz(cbVar.getId());
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
                                com.baidu.tieba.frs.d.k.a(FrsFragment.this, FrsFragment.this.jfG, cbVar);
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
            hideNetRefreshView(this.jgh.cEi().cLD());
            showLoadingView(this.jgh.cnn(), true);
            this.jgh.qF(false);
            this.jgz.S(3, true);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData cCZ() {
        return this.jfG;
    }

    public boolean cDa() {
        return this.jgh.cDa();
    }

    public void aK(Object obj) {
        if (this.jgE != null && this.jgE.jEE != null) {
            this.jgE.jEE.callback(obj);
        }
    }

    public void aL(Object obj) {
        if (this.jgE != null && this.jgE.jEF != null) {
            this.jgE.jEF.callback(obj);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        this.jgh.getListView().stopScroll();
        if (!this.jgh.cDQ()) {
            if (!com.baidu.adp.lib.util.l.isNetOk()) {
                this.jgh.bSr();
            } else if (this.jgz.cJA() == 1) {
                bRr();
                bRc();
            } else if (this.jgz.hasMore()) {
                bRc();
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void onFailed(String str) {
        bRr();
        showToast(str);
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void at(ArrayList<com.baidu.adp.widget.ListView.n> arrayList) {
        boolean isEmpty = com.baidu.tbadk.core.util.y.isEmpty(arrayList);
        setHasMore(isEmpty ? 0 : 1);
        bRr();
        if (!isEmpty) {
            if (!this.jgz.cJK() && TbadkCoreApplication.getInst().isRecAppExist() && this.jgz.cJA() == 1 && !com.baidu.tieba.funad.a.cNn()) {
                this.jfG.addRecommendAppToThreadList(this, arrayList);
            }
            if (this.jgz != null) {
                com.baidu.tieba.frs.b.a.a(getUniqueId(), arrayList, this.jfG.getForum(), this.jgz.getSortType());
            }
            ArrayList<com.baidu.adp.widget.ListView.n> a2 = this.jgK.a(false, false, arrayList, this.jgd, false);
            if (a2 != null) {
                this.jfG.setThreadList(a2);
                this.jgh.a(a2, this.jfG);
            }
            if (this.jgz != null) {
                com.baidu.tieba.frs.b.c.a(this.jfG, this.jgz.cJF(), 2, getContext());
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.jfG.getForum()));
        }
    }

    private void bRr() {
        if (cCv() == 1 || this.jgK.dA(this.jfG.getThreadListIds())) {
            if (com.baidu.tbadk.core.util.y.getCount(this.jfG.getThreadList()) > 3) {
                this.jgh.WX();
            } else {
                this.jgh.cDW();
            }
        } else if (com.baidu.tbadk.core.util.y.isEmpty(this.jfG.getThreadList())) {
            this.jgh.bSr();
        } else {
            this.jgh.WY();
        }
    }

    @Override // com.baidu.tieba.frs.mc.l
    public void bRc() {
        if (this.jgK != null) {
            this.jgK.a(this.jfZ, this.forumId, this.jfG);
        }
    }

    public void cDb() {
        if (!com.baidu.tbadk.core.util.ae.requestWriteExternalStorgeAndCameraPermission(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.ao.g(getPageContext());
        }
    }

    @Override // androidx.fragment.app.Fragment, com.baidu.l.a.a.InterfaceC0148a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        com.baidu.tieba.frs.d.l.a(this, i, strArr, iArr);
    }

    public void qx(boolean z) {
        if (this.jgF != null) {
            this.jgF.qS(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.jgG.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a sM(int i) {
        return this.jgG.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        this.jgO.b(bVar);
    }

    public boolean cDc() {
        return this.jfV;
    }

    @Override // com.baidu.tieba.frs.am
    public void Ut() {
        if (this.jgh != null) {
            showFloatingView();
            this.jgh.getListView().scrollToPosition(0);
            this.jgh.startPullRefresh();
        }
    }

    public ForumWriteData cDd() {
        if (this.jfG == null || this.jfG.getForum() == null) {
            return null;
        }
        ForumData forum = this.jfG.getForum();
        ForumWriteData forumWriteData = new ForumWriteData(forum.getId(), forum.getName(), forum.getPrefixData(), this.jfG.getAnti());
        forumWriteData.avatar = forum.getImage_url();
        forumWriteData.forumLevel = forum.getUser_level();
        forumWriteData.specialForumType = forum.special_forum_type;
        forumWriteData.firstDir = forum.getFirst_class();
        forumWriteData.secondDir = forum.getSecond_class();
        UserData userData = this.jfG.getUserData();
        forumWriteData.privateThread = userData != null ? userData.getPrivateThread() : 0;
        forumWriteData.frsTabInfo = cDe();
        return forumWriteData;
    }

    private FrsTabInfoData cDe() {
        int i;
        if (this.jgz == null || this.jfG == null || this.jgB == null) {
            return null;
        }
        if (this.jfG.getEntelechyTabInfo() == null || com.baidu.tbadk.core.util.y.isEmpty(this.jfG.getEntelechyTabInfo().tab)) {
            return null;
        }
        int cLR = this.jgB.cLR();
        if (cLR == 502) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = -1;
        for (FrsTabInfo frsTabInfo : this.jfG.getEntelechyTabInfo().tab) {
            if (frsTabInfo != null && frsTabInfo.is_general_tab.intValue() == 1) {
                if (frsTabInfo.tab_id.intValue() != 505 || this.jfG.getUserData() == null || this.jfG.getUserData().isForumBusinessAccount()) {
                    arrayList.add(new FrsTabItemData(frsTabInfo));
                    if (cLR == frsTabInfo.tab_id.intValue()) {
                        i = cLR;
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
        if (this.jfG.getUserData() != null) {
            frsTabInfoData.isForumBusinessAccount = this.jfG.getUserData().isForumBusinessAccount();
            return frsTabInfoData;
        }
        return frsTabInfoData;
    }

    @Override // com.baidu.tieba.frs.am
    public void bup() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void qy(boolean z) {
        this.jgv = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z) {
        this.jgh.yH(8);
        ((FrsActivity) getActivity()).showLoadingView(view, z);
        ((FrsActivity) getActivity()).j(view, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        this.jgh.yH(0);
        ((FrsActivity) getActivity()).hideLoadingView(view);
        ((FrsActivity) getActivity()).j(view, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        super.showNetRefreshView(view, getResources().getString(R.string.refresh_view_title_text), null, getResources().getString(R.string.refresh_view_button_text), z, getNetRefreshListener());
        this.jgh.yH(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshViewNoClick(View view, String str, boolean z) {
        super.showNetRefreshViewNoClick(view, str, z);
        this.jgh.yH(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        super.hideNetRefreshView(view);
        this.jgh.yH(0);
    }

    public void cDf() {
        FrsTabViewController.b cLN;
        if (this.jgB != null && (cLN = this.jgB.cLN()) != null && cLN.fragment != null && (cLN.fragment instanceof ao)) {
            ((ao) cLN.fragment).cBZ();
        }
    }

    public void qz(boolean z) {
        this.jfX = z;
    }

    public void b(OvalActionButton ovalActionButton) {
        this.jgi = ovalActionButton;
    }

    public OvalActionButton cDg() {
        return this.jgi;
    }

    public boolean cDh() {
        return this.jfX;
    }

    public void Kg(String str) {
        if (TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.util.au.isEmpty(str)) {
            if (this.jgZ == null) {
                this.jgZ = new AddExperiencedModel(getTbPageContext());
            }
            this.jgZ.gp(this.forumId, str);
        }
    }

    public boolean cDi() {
        if (this.jgv && !this.jhc) {
            return (this.jgz != null && this.jgz.cJB() && (b.cBr().cBl() || com.baidu.tieba.frs.a.cBk().cBl())) ? false : true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.g.b
    public boolean videoNeedPreload() {
        if (this.jfG != null) {
            return com.baidu.tbadk.util.ak.rG(2) || (com.baidu.tbadk.util.ak.bFR() && this.jfG.isFrsVideoAutoPlay);
        }
        return super.videoNeedPreload();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDj() {
        if (!com.baidu.tbadk.core.util.au.isEmpty(this.forumId)) {
            com.baidu.tbadk.BdToken.c.bhn().r(com.baidu.tbadk.BdToken.b.eCg, com.baidu.adp.lib.f.b.toLong(this.forumId, 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDk() {
        String format;
        String str;
        if (isResumed() && this.jhg != null && this.jhg.size() >= 1 && this.jhf <= this.jhg.size() - 1) {
            final LiveHorseRaceData liveHorseRaceData = this.jhg.get(this.jhf);
            if (System.currentTimeMillis() / 1000 >= liveHorseRaceData.getRob_end_tm().longValue()) {
                this.jhf++;
                cDk();
            }
            if (this.jgk != null) {
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
                        if (FrsFragment.this.jfG == null) {
                            str2 = "";
                        } else if (FrsFragment.this.jfG.getForum() != null) {
                            str2 = FrsFragment.this.jfG.getForum().getName();
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
                this.jhh = ValueAnimator.ofFloat(1.0f, 0.0f);
                this.jhh.setDuration(600L);
                this.jhh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.FrsFragment.54
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        if (valueAnimator.isRunning()) {
                            frsRedpackRunView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                            frsRedpackRunView.setTranslationX(-(TbadkApplication.getInst().getContext().getResources().getDimensionPixelOffset(R.dimen.tbds850) * valueAnimator.getAnimatedFraction()));
                        }
                    }
                });
                this.jhh.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.FrsFragment.55
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        frsRedpackRunView.setAlpha(0.0f);
                        frsRedpackRunView.setTranslationY(TbadkApplication.getInst().getContext().getResources().getDimensionPixelOffset(R.dimen.tbds660));
                        frsRedpackRunView.hide();
                        FrsFragment.this.jgk.removeView(frsRedpackRunView);
                        if (FrsFragment.this.jhg == null || FrsFragment.this.jhf <= FrsFragment.this.jhg.size() - 1) {
                            FrsFragment.this.cDk();
                            return;
                        }
                        FrsFragment.this.jgk.removeAllViews();
                        FrsFragment.this.jgk.setVisibility(8);
                        FrsFragment.this.jhf = 0;
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        onAnimationEnd(animator);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                this.jhi = new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.57
                    @Override // java.lang.Runnable
                    public void run() {
                        if (FrsFragment.this.jgk != null && frsRedpackRunView != null) {
                            FrsFragment.this.jhh.start();
                        }
                    }
                };
                com.baidu.adp.lib.f.e.mA().postDelayed(this.jhi, 5000L);
                if (this.jgk.getChildCount() == 0) {
                    this.jhf++;
                    this.jgk.addView(frsRedpackRunView);
                    if (this.jfG != null) {
                        str = this.jfG.getForum() != null ? this.jfG.getForum().getName() : "";
                    } else {
                        str = "";
                    }
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13743").ap("obj_source", 1).dR("fid", this.forumId).dR("fname", str));
                }
                if (this.jgk != null && this.jgk.getVisibility() == 8 && ((BaseFragment) this.jgB.cLN().fragment).isPrimary() && !this.jgh.cEf() && !this.jgq) {
                    this.jgk.setVisibility(0);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        FrsTabViewController.b cLN;
        if (cCs() == null || (cLN = cCs().cLN()) == null || !(cLN.fragment instanceof BaseFragment)) {
            return null;
        }
        if (cLN.fragment instanceof FrsAllThreadFragment) {
            TbPageTag tbPageTag = super.getTbPageTag();
            int i = -1;
            if (this.jfG != null) {
                i = this.jfG.getSortType();
            }
            tbPageTag.sortType = com.baidu.tieba.frs.d.j.Av(i);
            tbPageTag.locatePage = "a070";
            if (this.jfS.equals(cLN.title)) {
                tbPageTag.locatePage = "a071";
            }
            return tbPageTag;
        } else if (cLN.fragment instanceof FrsFragment) {
            return null;
        } else {
            return ((BaseFragment) cLN.fragment).getTbPageTag();
        }
    }

    public void cDl() {
        if (this.jfG != null) {
            com.baidu.tieba.frs.b.b bVar = new com.baidu.tieba.frs.b.b();
            if (this.jfG.needLog == 1) {
                bVar.jHk = true;
            } else {
                bVar.jHk = false;
            }
            if (this.jfG.getForum() != null) {
                bVar.jHm = this.jfG.getForum().getId();
            }
            if (cCp() != null) {
                bVar.jHl = cCp().cJF();
            }
            if (com.baidu.tieba.frs.b.d.jqq != null) {
                bVar.jHn = com.baidu.tieba.frs.b.d.jqq.jHn;
                bVar.jHo = com.baidu.tieba.frs.b.d.jqq.jHo;
            }
            this.jhj = new com.baidu.tieba.frs.live.b(bVar, getTbPageTag(), getUniqueId());
            this.jhj.zX(this.jhl);
            CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_CARD_CLICK, this.jhj);
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
            CustomMessageTask customMessageTask2 = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW, this.jhj);
            customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask2);
            CustomMessageTask customMessageTask3 = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_USER_CLICK, this.jhj);
            customMessageTask3.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask3);
            CustomMessageTask customMessageTask4 = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_VIDEO_CLICK, this.jhj);
            customMessageTask4.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask4);
        }
    }

    public void aI(String str, String str2, String str3) {
        this.jhm = new com.baidu.tieba.frs.d.e(str, str2);
        this.jhm.c(getFragmentActivity(), str3, str2);
    }

    public void qA(boolean z) {
        if (this.funAdController == null) {
            this.funAdController = com.baidu.tieba.funad.a.rM(z);
            if (this.jgK != null) {
                this.jgK.setFunAdController(this.funAdController);
            }
        }
    }
}
