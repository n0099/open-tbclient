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
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
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
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bh;
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
/* loaded from: classes22.dex */
public class FrsFragment extends BaseFragment implements BdListView.e, a.InterfaceC0276a, UserIconBox.b<BdRecyclerView>, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, ap, as, av, com.baidu.tieba.frs.loadmore.a, com.baidu.tieba.frs.mc.l, com.baidu.tieba.recapp.p {
    public static com.baidu.tieba.tbadkCore.m iSZ;
    private com.baidu.tbadk.util.y fGc;
    private com.baidu.adp.lib.d.b<TbImageView> few;
    private com.baidu.tieba.frs.gametab.b gLP;
    private com.baidu.tieba.frs.entelechy.a iSH;
    private com.baidu.tieba.tbadkCore.data.f iSR;
    private VoiceManager iSU;
    private OvalActionButton iSW;
    private FRSRefreshButton iSX;
    private LinearLayout iSY;
    private com.baidu.tieba.frs.mc.a iTA;
    private com.baidu.tieba.frs.live.a iTB;
    private p iTC;
    public com.baidu.tieba.frs.vc.c iTD;
    private com.baidu.tieba.frs.mc.e iTE;
    private View.OnTouchListener iTF;
    private com.baidu.tieba.frs.view.a iTG;
    private com.baidu.tieba.frs.vc.e iTH;
    private boolean iTI;
    private com.baidu.tieba.NEGFeedBack.a iTJ;
    private com.baidu.tieba.ala.a iTK;
    private com.baidu.tieba.frs.brand.buttommenu.a iTL;
    private com.baidu.tieba.frs.sportspage.notification.a iTM;
    private AddExperiencedModel iTN;
    private boolean iTP;
    private List<LiveHorseRaceData> iTU;
    private ValueAnimator iTV;
    private Runnable iTW;
    private com.baidu.tieba.frs.live.b iTX;
    private com.baidu.tieba.frs.broadcast.a iTY;
    private int iTZ;
    public long iTa;
    private String iTk;
    private com.baidu.card.am iTm;
    private FrsModelController iTn;
    private com.baidu.tieba.frs.vc.h iTo;
    private FrsTabViewController iTp;
    private com.baidu.tieba.frs.mc.h iTq;
    private com.baidu.tieba.frs.smartsort.a iTr;
    private com.baidu.tieba.frs.mc.b iTs;
    private aw iTt;
    private com.baidu.tieba.frs.entelechy.b.b iTv;
    private com.baidu.tieba.frs.vc.a iTw;
    private com.baidu.tieba.frs.mc.d iTx;
    private com.baidu.tieba.frs.mc.c iTy;
    private com.baidu.tieba.frs.vc.j iTz;
    private com.baidu.tieba.frs.f.e iUa;
    private int iUk;
    private com.baidu.tbadk.core.dialog.a ilO;
    private View mRootView;
    private String mSchemeUrl;
    public static boolean iSM = false;
    public static volatile long iTc = 0;
    public static volatile long iTd = 0;
    public static volatile int mNetError = 0;
    private String iSG = "";
    public boolean iSI = false;
    private boolean iSJ = false;
    private boolean iSK = false;
    private boolean iSL = true;
    public String iSN = null;
    public String mFrom = null;
    public int mFlag = 0;
    public boolean iSO = false;
    private boolean iSP = false;
    private String mThreadId = null;
    public String forumId = null;
    private int iSv = 0;
    private boolean iSQ = false;
    private boolean iSS = false;
    private boolean iST = false;
    private q iSV = null;
    public final by alu = null;
    private FrsViewData iSt = new FrsViewData();
    public long ivy = -1;
    public long fCl = 0;
    public long fCb = 0;
    public long createTime = 0;
    public long fCc = 0;
    public long fCi = 0;
    public long iTb = 0;
    boolean iTe = false;
    public boolean iTf = false;
    private boolean iTg = false;
    public com.baidu.tbadk.n.b iTh = null;
    private boolean iTi = true;
    private boolean iTj = true;
    private a.C0097a iTl = new a.C0097a(2);
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> iTu = new SparseArray<>();
    private boolean gtX = true;
    private boolean hasInit = false;
    private boolean iTO = false;
    private boolean iTQ = false;
    private Date iTR = null;
    private int dOW = 0;
    private int iTS = 0;
    private int iTT = 0;
    public int mHeadLineDefaultNavTabId = -1;
    MessageQueue.IdleHandler iUb = new MessageQueue.IdleHandler() { // from class: com.baidu.tieba.frs.FrsFragment.1
        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            FrsFragment.this.cCs();
            return false;
        }
    };
    private final CustomMessageListener iUc = new CustomMessageListener(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED) { // from class: com.baidu.tieba.frs.FrsFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof by) {
                    com.baidu.tieba.frs.f.k.a(FrsFragment.this.iSV, FrsFragment.this.iSt, FrsFragment.this.getForumId(), true, (by) data);
                }
            }
        }
    };
    private CustomMessageListener iUd = new CustomMessageListener(CmdConfigCustom.CMD_CLOSE_GAME_RANK_CARD) { // from class: com.baidu.tieba.frs.FrsFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.iSt != null) {
                FrsFragment.this.iSt.removeGameRankListFromThreadList();
                if (FrsFragment.this.iSV != null) {
                    FrsFragment.this.iSV.bcP();
                }
            }
        }
    };
    private CustomMessageListener ahC = new CustomMessageListener(2921401) { // from class: com.baidu.tieba.frs.FrsFragment.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && FrsFragment.this.iSX != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() <= 0 || FrsFragment.this.iTp.cLp() == 0 || FrsFragment.this.iTp.cLm() == null || !(FrsFragment.this.iTp.cLm().fragment instanceof BaseFragment) || !((BaseFragment) FrsFragment.this.iTp.cLm().fragment).isPrimary() || FrsFragment.this.iSV.cDP() || com.baidu.tbadk.k.d.bDH().bDI()) {
                    if (FrsFragment.this.iTp.cLp() != 0) {
                        FrsFragment.this.iSX.hide();
                        return;
                    }
                    return;
                }
                FrsFragment.this.iSX.show();
            }
        }
    };
    private CustomMessageListener iUe = new CustomMessageListener(2921473) { // from class: com.baidu.tieba.frs.FrsFragment.45
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && FrsFragment.this.iSX != null && FrsFragment.this.iSW != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() == 0) {
                    FrsFragment.this.iSX.setVisibility(8);
                    FrsFragment.this.iSW.setVisibility(8);
                    return;
                }
                FrsFragment.this.iSW.setVisibility(0);
            }
        }
    };
    private CustomMessageListener iUf = new CustomMessageListener(2921467) { // from class: com.baidu.tieba.frs.FrsFragment.56
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && FrsFragment.this.iSX != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() <= 0 || FrsFragment.this.iTp.cLm() == null || !(FrsFragment.this.iTp.cLm().fragment instanceof BaseFragment) || !((BaseFragment) FrsFragment.this.iTp.cLm().fragment).isPrimary() || FrsFragment.this.iSV.cDP()) {
                    FrsFragment.this.iSY.setVisibility(8);
                    FrsFragment.this.iTe = true;
                    return;
                }
                FrsFragment.this.iSY.setVisibility(0);
                FrsFragment.this.iTe = false;
            }
        }
    };
    private com.baidu.adp.framework.listener.a iUg = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_FRS_LIVE_HORSE_RACE_LIST, 309667) { // from class: com.baidu.tieba.frs.FrsFragment.62
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if ((responsedMessage instanceof GetLiveHorseRaceHttpResponseMessage) || (responsedMessage instanceof GetLiveHorseRaceSocketResponseMessage)) {
                    List<LiveHorseRaceData> arrayList = new ArrayList<>();
                    if (responsedMessage instanceof GetLiveHorseRaceHttpResponseMessage) {
                        arrayList = ((GetLiveHorseRaceHttpResponseMessage) responsedMessage).getData().cEq();
                    }
                    if (responsedMessage instanceof GetLiveHorseRaceSocketResponseMessage) {
                        arrayList = ((GetLiveHorseRaceSocketResponseMessage) responsedMessage).getData().cEq();
                    }
                    if (FrsFragment.this.iTU != null) {
                        if (FrsFragment.this.iSY.getVisibility() != 8) {
                            if (FrsFragment.this.iTT >= FrsFragment.this.iTU.size()) {
                                FrsFragment.this.iTU.addAll(arrayList);
                                return;
                            }
                            FrsFragment.this.iTU = FrsFragment.this.iTU.subList(0, FrsFragment.this.iTT);
                            FrsFragment.this.iTU.addAll(arrayList);
                            return;
                        }
                        FrsFragment.this.iTU = new ArrayList();
                        FrsFragment.this.iTU.addAll(arrayList);
                        FrsFragment.this.iTT = 0;
                        FrsFragment.this.cCU();
                        return;
                    }
                    FrsFragment.this.iTU = new ArrayList();
                    FrsFragment.this.iTT = 0;
                    FrsFragment.this.iTU.addAll(arrayList);
                    FrsFragment.this.cCU();
                }
            }
        }
    };
    private CustomMessageListener iUh = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.FrsFragment.63
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 1) {
                    FrsFragment.this.cCw();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                }
            }
        }
    };
    private final au iUi = new au() { // from class: com.baidu.tieba.frs.FrsFragment.64
        @Override // com.baidu.tieba.frs.au
        public void a(int i, int i2, bd bdVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
            FrsFragment.this.cCh();
            if (FrsFragment.this.iTv != null) {
                FrsFragment.this.iTo.qY(FrsFragment.this.iTv.Aw(i));
            }
            com.baidu.tieba.tbadkCore.f fVar = new com.baidu.tieba.tbadkCore.f();
            if (bdVar != null) {
                fVar.isSuccess = bdVar.errCode == 0;
                fVar.errorCode = bdVar.errCode;
                fVar.errorMsg = bdVar.errMsg;
                if (fVar.isSuccess) {
                    if (com.baidu.tbadk.core.util.y.isEmpty(arrayList)) {
                        FrsFragment.this.iSV.bTa();
                    } else if (bdVar.hasMore) {
                        if (com.baidu.tbadk.core.util.y.getCount(FrsFragment.this.iSt.getThreadList()) > 3) {
                            FrsFragment.this.iSV.XZ();
                        } else {
                            FrsFragment.this.iSV.cDG();
                        }
                    } else if (bdVar.iXS) {
                        FrsFragment.this.iSV.Ya();
                    } else {
                        FrsFragment.this.iSV.bTa();
                    }
                }
            } else {
                bdVar = new bd();
                bdVar.pn = 1;
                bdVar.hasMore = false;
                bdVar.iXS = false;
            }
            if (i == 1) {
                FrsFragment.this.iTi = true;
                FrsFragment.this.iUz.a(FrsFragment.this.iTn.getType(), false, fVar);
            } else {
                FrsFragment.this.a(fVar);
                if (FrsFragment.this.iTn.cIE() != null) {
                    FrsFragment.this.iSt = FrsFragment.this.iTn.cIE();
                }
                FrsFragment.this.cCy();
            }
            if (FrsFragment.this.iUH != null) {
                FrsFragment.this.iUH.a(i, i2, bdVar, arrayList);
            }
        }
    };
    private FrsTabViewController.a iUj = new FrsTabViewController.a() { // from class: com.baidu.tieba.frs.FrsFragment.2
        @Override // com.baidu.tieba.frs.vc.FrsTabViewController.a
        public void cp(int i, int i2) {
            boolean z = false;
            if (i != 1) {
                com.baidu.tieba.card.t.csg().oX(false);
                FrsFragment.this.pR(false);
            }
            if (i == 502) {
                FrsFragment.this.iSW.setIconFade(R.drawable.btn_frs_professional_edit_n);
            } else {
                FrsFragment.this.iSW.setIconFade(0);
            }
            FrsFragment.this.iUk = i;
            FrsFragment.this.iTZ = i2;
            if (FrsFragment.this.iTX != null) {
                FrsFragment.this.iTX.Bi(FrsFragment.this.iTZ);
            }
            TbSingleton.getInstance().setFrsCurTabType(FrsFragment.this.iTZ);
            FrsFragment.this.cCE();
            com.baidu.tieba.frs.d.d.jcS.jtS = i;
            com.baidu.tieba.frs.d.d.jcS.jtV = i2;
            com.baidu.tieba.frs.d.d.jcS.jtT = -1;
            b.cBd().V(i == 1 && FrsFragment.this.iTO, true);
            com.baidu.tieba.frs.a cAW = com.baidu.tieba.frs.a.cAW();
            if (i == 1 && FrsFragment.this.iTO) {
                z = true;
            }
            cAW.V(z, true);
        }
    };
    private CustomMessageListener iUl = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIVE_COUNT) { // from class: com.baidu.tieba.frs.FrsFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                FrsFragment.this.iTp.BS(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    };
    private CustomMessageListener iUm = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_LIVE_START) { // from class: com.baidu.tieba.frs.FrsFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && ((Integer) customResponsedMessage.getData()).intValue() == 51 && FrsFragment.this.iSt != null) {
                com.baidu.tieba.frs.f.m.a(FrsFragment.this.iSt, FrsFragment.this.getPageContext());
            }
        }
    };
    private final CustomMessageListener iUn = new CustomMessageListener(CmdConfigCustom.CMD_FRS_SELECT_ALA_LIVE_TAB) { // from class: com.baidu.tieba.frs.FrsFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                FrsFragment.this.iTp.ui(49);
            }
        }
    };
    private final CustomMessageListener iUo = new CustomMessageListener(2921470) { // from class: com.baidu.tieba.frs.FrsFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                FrsFragment.this.iTp.ui(1);
                FrsFragment.this.cCw();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
            }
        }
    };
    private final CustomMessageListener iUp = new CustomMessageListener(CmdConfigCustom.CMD_FRS_EXPERIENCE_TIP) { // from class: com.baidu.tieba.frs.FrsFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.w) && FrsFragment.this.iSt != null) {
                FrsFragment.this.iSt.updateLikeData((com.baidu.tieba.tbadkCore.w) customResponsedMessage.getData());
                FrsFragment.this.iTo.j(FrsFragment.this.iSt);
                FrsFragment.this.iTp.a(FrsFragment.this.iSt, FrsFragment.this.iTn.cJi());
            }
        }
    };
    private final AntiHelper.a iUq = new AntiHelper.a() { // from class: com.baidu.tieba.frs.FrsFragment.8
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).al("obj_locate", ay.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).al("obj_locate", ay.a.LOCATE_LIKE_PERSON));
        }
    };
    private CustomMessageListener iUr = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.FrsFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(FrsFragment.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().flk != null) {
                        if (AntiHelper.a(FrsFragment.this.getActivity(), updateAttentionMessage.getData().flk, FrsFragment.this.iUq) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).al("obj_locate", ay.a.LOCATE_LIKE_PERSON));
                        }
                    } else if (updateAttentionMessage.getData().isSucc && updateAttentionMessage.getData().isAttention) {
                        com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getPageContext().getPageActivity(), R.string.attention_success);
                    }
                }
            }
        }
    };
    private CustomMessageListener iUs = new CustomMessageListener(CmdConfigCustom.CMD_GET_ENSURE_CAST_ID) { // from class: com.baidu.tieba.frs.FrsFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsFragment.this.refresh();
        }
    };
    private CustomMessageListener iUt = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.frs.FrsFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && !((PostWriteCallBackData) customResponsedMessage.getData()).isDyamicCallback()) {
                FrsFragment.this.iSV.c((PostWriteCallBackData) customResponsedMessage.getData());
                if (((PostWriteCallBackData) customResponsedMessage.getData()).getGeneralTabId() >= 0) {
                    FrsFragment.this.iTA.Bk(((PostWriteCallBackData) customResponsedMessage.getData()).getGeneralTabId());
                }
            }
        }
    };
    private CustomMessageListener iUu = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_REMIND) { // from class: com.baidu.tieba.frs.FrsFragment.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626) {
                NewsRemindMessage newsRemindMessage = (NewsRemindMessage) customResponsedMessage;
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (FrsFragment.this.iSV != null) {
                    FrsFragment.this.iSV.P(notificationCount, z);
                }
            }
        }
    };
    private HttpMessageListener iUv = new HttpMessageListener(CmdConfigHttp.CMD_FRS_MOVE_AREA) { // from class: com.baidu.tieba.frs.FrsFragment.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int i;
            int i2 = 0;
            if (httpResponsedMessage != null && FrsFragment.this.getContext() != null && FrsFragment.this.iSV != null) {
                if (httpResponsedMessage.getError() == 0) {
                    new BdTopToast(FrsFragment.this.getContext()).yW(true).Vt(FrsFragment.this.getContext().getString(R.string.frs_move_area_move_suc)).aF(FrsFragment.this.iSV.cnn());
                    if (com.baidu.tieba.frs.a.cAW().zC(com.baidu.tieba.frs.a.cAW().cAY())) {
                        FrsCommonTabFragment frsCommonTabFragment = null;
                        if (FrsFragment.this.iTp != null && FrsFragment.this.iTp.cLm() != null && (FrsFragment.this.iTp.cLm().fragment instanceof FrsCommonTabFragment)) {
                            frsCommonTabFragment = (FrsCommonTabFragment) FrsFragment.this.iTp.cLm().fragment;
                        }
                        if (frsCommonTabFragment != null) {
                            frsCommonTabFragment.cFk();
                        }
                        FrsFragment.this.cBb();
                        com.baidu.tieba.frs.a.cAW().cBb();
                        Iterator<com.baidu.adp.widget.ListView.q> it = FrsFragment.this.iSt.getThreadList().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                i = i2;
                                break;
                            }
                            i = it.next() instanceof bx ? i2 + 1 : i2;
                            if (i >= 6) {
                                break;
                            }
                            i2 = i;
                        }
                        if (i < 6) {
                            FrsFragment.this.bRM();
                        }
                    }
                    com.baidu.tieba.frs.a.cAW().reset();
                    return;
                }
                new BdTopToast(FrsFragment.this.getContext()).yW(false).Vt(httpResponsedMessage.getErrorString()).aF(FrsFragment.this.iSV.cnn());
            }
        }
    };
    private final CustomMessageListener iUw = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.frs.FrsFragment.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.isResumed()) {
                FrsFragment.this.cCT();
            }
        }
    };
    private CustomMessageListener iUx = new CustomMessageListener(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER) { // from class: com.baidu.tieba.frs.FrsFragment.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (FrsFragment.this.iSV != null) {
                    FrsFragment.this.iSV.setExpanded(booleanValue);
                }
            }
        }
    };
    private final CustomMessageListener iUy = new CustomMessageListener(2921463) { // from class: com.baidu.tieba.frs.FrsFragment.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TbadkApplication.getInst().getCurrentActivity() != null && !com.baidu.tbadk.core.util.au.isEmpty(str) && str.equals(FrsFragment.this.forumId)) {
                    com.baidu.tieba.frs.f.h.b(((TbPageContextSupport) TbadkApplication.getInst().getCurrentActivity()).getPageContext(), FrsFragment.this.iSt);
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.s iUz = new com.baidu.tieba.tbadkCore.s() { // from class: com.baidu.tieba.frs.FrsFragment.18
        private long startTime = 0;

        @Override // com.baidu.tieba.tbadkCore.s
        public void zJ(int i) {
            this.startTime = System.nanoTime();
            if (FrsFragment.this.iSV != null) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsFragment.this.iSV.cDr();
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
            if (FrsFragment.this.gtX) {
                FrsFragment.this.gtX = false;
                com.baidu.tieba.frs.f.k.a(FrsFragment.this.iSV, FrsFragment.this.iSt, FrsFragment.this.getForumId(), false, null);
            }
            FrsFragment.this.cCh();
            FrsFragment.this.iTg = true;
            if (fVar != null && fVar.isSuccess) {
                FrsFragment.this.iSV.cDE().qB(com.baidu.tbadk.core.util.av.btX().btY());
                FrsFragment.iTc = 0L;
                FrsFragment.iTd = 0L;
                FrsFragment.mNetError = 0;
            } else {
                FrsFragment.mNetError = 1;
            }
            if (!FrsFragment.this.iTn.cJn() && (i == 3 || i == 6)) {
                FrsFragment.this.iTy.resetData();
            }
            FrsFragment.this.iTa = System.currentTimeMillis();
            if (FrsFragment.this.iTn.cIE() != null) {
                FrsFragment.this.iSt = FrsFragment.this.iTn.cIE();
            }
            FrsFragment.this.zF(1);
            FrsFragment.this.cCp();
            if (i == 7) {
                FrsFragment.this.zG(FrsFragment.this.iSt.getFrsDefaultTabId());
                return;
            }
            if (FrsFragment.this.iSt.getPage() != null) {
                FrsFragment.this.setHasMore(FrsFragment.this.iSt.getPage().bnF());
            }
            if (i == 4) {
                if (!FrsFragment.this.iTn.cJn() && TbadkCoreApplication.getInst().isRecAppExist() && FrsFragment.this.iTn.cJd() == 1) {
                    FrsFragment.this.iSt.addRecommendAppToThreadList(FrsFragment.this);
                }
                ArrayList<com.baidu.adp.widget.ListView.q> a2 = FrsFragment.this.iTy.a(false, false, FrsFragment.this.iSt.getThreadList(), FrsFragment.this.iSR, false);
                if (a2 != null) {
                    FrsFragment.this.iSt.setThreadList(a2);
                    FrsFragment.this.iSt.checkLiveStageInThreadList();
                }
                if (FrsFragment.this.iTn != null) {
                    com.baidu.tieba.frs.d.c.a(FrsFragment.this.iSt, FrsFragment.this.iTn.cJi(), 2, FrsFragment.this.getContext());
                }
                com.baidu.tieba.frs.f.a.a(FrsFragment.this, FrsFragment.this.iSt.getForum(), FrsFragment.this.iSt.getThreadList(), false, FrsFragment.this.getPn());
                FrsFragment.this.iSV.a(a2, FrsFragment.this.iSt);
                FrsFragment.this.cCi();
                return;
            }
            FrsFragment.this.cCi();
            switch (i) {
                case 1:
                    FrsFragment.this.iSV.cDr();
                    break;
                case 2:
                    FrsFragment.this.iSV.cDr();
                    break;
                case 3:
                case 6:
                    if (FrsFragment.this.iSt != null) {
                        FrsFragment.this.iSt.clearPostThreadCount();
                    }
                    if (FrsFragment.this.iTD != null) {
                        FrsFragment.this.iTD.refresh();
                        break;
                    }
                    break;
            }
            FrsFragment.this.cCq();
            if (fVar == null || fVar.errorCode == 0) {
                if (FrsFragment.this.iSt != null) {
                    FrsFragment.this.a(FrsFragment.this.iSt);
                    FrsFragment.this.X(false, i == 5);
                    if (FrsFragment.this.iTn != null) {
                        if (FrsFragment.this.iSt.getActivityHeadData() != null && FrsFragment.this.iSt.getActivityHeadData().bmT() != null && FrsFragment.this.iSt.getActivityHeadData().bmT().size() > 0) {
                            com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), 1, FrsFragment.this.iSt.getForum(), FrsFragment.this.iTn.getSortType(), 1);
                        }
                        if (FrsFragment.this.iSt.getThreadList() != null && FrsFragment.this.iSt.getThreadList().size() > 0) {
                            Iterator<com.baidu.adp.widget.ListView.q> it = FrsFragment.this.iSt.getThreadList().iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    com.baidu.adp.widget.ListView.q next = it.next();
                                    if ((next instanceof by) && ((by) next).getType() == by.eKU) {
                                        com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), 1, FrsFragment.this.iSt.getForum(), FrsFragment.this.iTn.getSortType(), 2);
                                    }
                                }
                            }
                        }
                        com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), FrsFragment.this.iSt.getThreadList(), FrsFragment.this.iSt.getForum(), FrsFragment.this.iTn.getSortType());
                    }
                    FrsFragment.this.iSV.zW(i);
                    FrsFragment.iTc = (System.nanoTime() - this.startTime) / TimeUtils.NANOS_PER_MS;
                    if (fVar != null) {
                        FrsFragment.iTd = fVar.njv;
                    }
                } else {
                    return;
                }
            } else if (FrsFragment.this.iSt == null || com.baidu.tbadk.core.util.y.isEmpty(FrsFragment.this.iSt.getThreadList())) {
                FrsFragment.this.a(fVar);
            } else if (fVar.iCU) {
                FrsFragment.this.showToast(FrsFragment.this.getPageContext().getResources().getString(R.string.net_error_text, fVar.errorMsg, Integer.valueOf(fVar.errorCode)));
            }
            FrsFragment.this.cCm();
            FrsFragment.this.cCn();
            if (FrsFragment.this.iSt.getAccessFlag() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11384"));
            }
            if (FrsFragment.this.iSS && FrsFragment.this.iTp.ui(49)) {
                FrsFragment.this.iSS = false;
            }
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.s
        public void c(com.baidu.tieba.tbadkCore.m mVar) {
            if ((mVar != null && ("normal_page".equals(FrsFragment.this.iTn.getPageType()) || "frs_page".equals(FrsFragment.this.iTn.getPageType()) || "book_page".equals(FrsFragment.this.iTn.getPageType()))) || "brand_page".equals(FrsFragment.this.iTn.getPageType())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE, mVar));
                FrsFragment.this.b(mVar);
                FrsFragment.iSZ = mVar;
            }
        }

        @Override // com.baidu.tieba.tbadkCore.s
        public void cCs() {
            FrsFragment.this.cCs();
        }
    };
    private final CustomMessageListener iUA = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.frs.FrsFragment.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.n) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                FrsFragment.this.iSt.updateCurrentUserPendant((com.baidu.tbadk.data.n) customResponsedMessage.getData());
                FrsFragment.this.iSV.cDE().notifyDataSetChanged();
            }
        }
    };
    private final CustomMessageListener mMemListener = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_MEM) { // from class: com.baidu.tieba.frs.FrsFragment.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && FrsFragment.this.iSt != null && (userData = FrsFragment.this.iSt.getUserData()) != null) {
                userData.setIsMem(num.intValue());
                if (num.intValue() != 0) {
                    FrsFragment.this.iTo.o(num);
                }
            }
        }
    };
    private final f.a iUB = new AnonymousClass29();
    private final com.baidu.tieba.frs.mc.k iUC = new com.baidu.tieba.frs.mc.k() { // from class: com.baidu.tieba.frs.FrsFragment.30
        @Override // com.baidu.tieba.frs.mc.k
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, boolean z3) {
            if (FrsFragment.this.iTr != null && FrsFragment.this.iTn != null && FrsFragment.this.iTn.cJn() && z && !z2 && !z3) {
                FrsFragment.this.iTr.Bp(i2);
            }
        }
    };
    public final View.OnTouchListener fGd = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.FrsFragment.31
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (FrsFragment.this.iTF != null) {
                FrsFragment.this.iTF.onTouch(view, motionEvent);
            }
            if (FrsFragment.this.iTt != null && FrsFragment.this.iTt.cEr() != null) {
                FrsFragment.this.iTt.cEr().onTouchEvent(motionEvent);
            }
            if (FrsFragment.this.gLP != null) {
                FrsFragment.this.gLP.b(view, motionEvent);
            }
            if (FrsFragment.this.iTo != null) {
                FrsFragment.this.iTo.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private final CustomMessageListener iUD = new CustomMessageListener(CmdConfigCustom.CMD_GOTOLIVE_HOST_UPGRADE) { // from class: com.baidu.tieba.frs.FrsFragment.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.bsO().getInt(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.PHOTOLIVE_HOSTLEVEL, -1) != -1 && FrsFragment.this.iSt.getForum() != null) {
                FrsFragment.this.iSt.getForum().setCanAddPhotoLivePost(true);
            }
        }
    };
    public final View.OnClickListener iUE = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.39
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsFragment.this.iSV != null && view == FrsFragment.this.iSV.cDp() && FrsFragment.this.getActivity() != null) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, FrsFragment.this.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            if (view.getId() == R.id.game_activity_egg_layout && com.baidu.adp.lib.util.l.isNetOk()) {
                TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_CLICK);
                if (FrsFragment.this.iSV == null || !FrsFragment.this.iSV.cDB()) {
                    String activityUrl = FrsFragment.this.iSt.getForum().getYuleData().brn().getActivityUrl();
                    if (!StringUtils.isNull(activityUrl)) {
                        com.baidu.tbadk.browser.a.startInternalWebActivity(FrsFragment.this.getPageContext().getPageActivity(), activityUrl);
                    }
                } else {
                    FrsFragment.this.iSV.cDC();
                }
            }
            if (FrsFragment.this.iSV != null && view == FrsFragment.this.iSV.cDH() && FrsFragment.this.iTn != null && FrsFragment.this.iTn.hasMore()) {
                FrsFragment.this.iSV.XZ();
                FrsFragment.this.bRM();
            }
            if (view != null && FrsFragment.this.iSV != null && view == FrsFragment.this.iSV.cDy()) {
                if (bh.checkUpIsLogin(FrsFragment.this.getContext())) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).al("obj_locate", 2));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MessageCenterActivityConfig(FrsFragment.this.getContext())));
                } else {
                    return;
                }
            }
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (FrsFragment.this.iSt != null && FrsFragment.this.iSt.getForum() != null) {
                    if (FrsFragment.this.iSV != null && view == FrsFragment.this.iSV.cDw()) {
                        if (FrsFragment.this.iSt != null && FrsFragment.this.iSt.getForum() != null && !StringUtils.isNull(FrsFragment.this.iSt.getForum().getId()) && !StringUtils.isNull(FrsFragment.this.iSt.getForum().getName())) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.KEY_SHARE_CLICK).dY("fid", FrsFragment.this.iSt.getForum().getId()).al("obj_locate", 11));
                            com.baidu.tieba.frs.f.h.a(FrsFragment.this.getPageContext(), FrsFragment.this.iSt, FrsFragment.this.iSt.getForum().getId());
                        } else {
                            return;
                        }
                    }
                    if (FrsFragment.this.iSV != null && view == FrsFragment.this.iSV.cDv()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12402").dY("fid", FrsFragment.this.iSt.getForum().getId()).dY("uid", TbadkCoreApplication.getCurrentAccount()).dY("fname", FrsFragment.this.iSt.getForum().getName()));
                        if (!StringUtils.isNull(FrsFragment.this.iSt.getForum().getName())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PostSearchActivityConfig(FrsFragment.this.getContext(), FrsFragment.this.iSt.getForum().getName(), FrsFragment.this.iSt.getForum().getId())));
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
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.FrsFragment.40
        private int iVc = 0;
        private int gpN = 0;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsFragment.this.iTS += i2;
            if (FrsFragment.this.iTS >= FrsFragment.this.dOW * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
            if (FrsFragment.this.iTw != null) {
                FrsFragment.this.iTw.cKi();
            }
            this.iVc = 0;
            this.gpN = 0;
            if (recyclerView != null && (recyclerView instanceof BdRecyclerView)) {
                this.iVc = ((BdRecyclerView) recyclerView).getFirstVisiblePosition();
                this.gpN = ((BdRecyclerView) recyclerView).getLastVisiblePosition();
            }
            if (FrsFragment.this.iTH != null) {
                FrsFragment.this.iTH.a(recyclerView, this.iVc, this.gpN);
            }
            if (FrsFragment.this.iSt != null && FrsFragment.this.iSV != null && FrsFragment.this.iSV.cDE() != null) {
                FrsFragment.this.iSV.cs(this.iVc, this.gpN);
                if (FrsFragment.this.iTm != null && FrsFragment.this.iTm.tZ() != null) {
                    FrsFragment.this.iTm.tZ().b(FrsFragment.this.iTl);
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (FrsFragment.this.iTo != null) {
                FrsFragment.this.iTo.setScrollState(i);
                if (i == 1) {
                    FrsFragment.this.iTo.cKK();
                }
            }
            if (FrsFragment.this.iTh == null && !FrsFragment.this.cCM()) {
                FrsFragment.this.iTh = new com.baidu.tbadk.n.b();
                FrsFragment.this.iTh.setSubType(1000);
            }
            if (i == 0) {
                if (FrsFragment.this.iTh != null) {
                    FrsFragment.this.iTh.bFe();
                }
                com.baidu.tieba.card.t.csg().oX(true);
                FrsFragment.this.pR(true);
                FrsFragment.this.iSV.cr(this.iVc, this.gpN);
            } else if (FrsFragment.this.iTh != null) {
                FrsFragment.this.iTh.bFd();
            }
            if (FrsFragment.this.iTH != null) {
                FrsFragment.this.iTH.onScrollStateChanged(recyclerView, i);
            }
            if (i == 0) {
                com.baidu.tieba.frs.f.k.a(FrsFragment.this.iSV, FrsFragment.this.iSt, FrsFragment.this.getForumId(), false, null);
            }
            if (FrsFragment.this.iTp != null && i == 1) {
                FrsFragment.this.iTp.cLo();
            }
            if (FrsFragment.this.iTm == null) {
                if (FrsFragment.this.iSV.cDi() != null && !FrsFragment.this.iSV.cCK() && FrsFragment.this.iSV.cDi().dBO() != null && (FrsFragment.this.iSV.cDi().dBO().getTag() instanceof com.baidu.card.am)) {
                    FrsFragment.this.iTm = (com.baidu.card.am) FrsFragment.this.iSV.cDi().dBO().getTag();
                }
            } else if (i == 0 && FrsFragment.this.iSV.cDi() != null && !FrsFragment.this.iSV.cCK() && FrsFragment.this.iSV.cDi().dBO() != null && (FrsFragment.this.iSV.cDi().dBO().getTag() instanceof com.baidu.card.am)) {
                FrsFragment.this.iTm = (com.baidu.card.am) FrsFragment.this.iSV.cDi().dBO().getTag();
            }
            if (i == 1) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921418));
            }
        }
    };
    private final f iUF = new f() { // from class: com.baidu.tieba.frs.FrsFragment.41
        @Override // com.baidu.tieba.frs.f
        public void a(int i, int i2, View view, View view2, by byVar) {
            if (i != FrsFragment.this.iSV.cDE().cFZ()) {
                if (i != FrsFragment.this.iSV.cDE().cGa()) {
                    if (i == FrsFragment.this.iSV.cDE().cFX() && FrsFragment.this.iSt != null && FrsFragment.this.iSt.getUserData() != null && FrsFragment.this.iSt.getUserData().isBawu()) {
                        String bawuCenterUrl = FrsFragment.this.iSt.getBawuCenterUrl();
                        if (!com.baidu.tbadk.core.util.au.isEmpty(bawuCenterUrl) && FrsFragment.this.iSt.getForum() != null) {
                            com.baidu.tbadk.browser.a.startWebActivity(FrsFragment.this.getPageContext().getPageActivity(), bawuCenterUrl);
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10502").dY("fid", FrsFragment.this.iSt.getForum().getId()).dY("uid", FrsFragment.this.iSt.getUserData().getUserId()));
                        }
                    }
                } else if (bh.checkUpIsLogin(FrsFragment.this.getPageContext().getPageActivity())) {
                    TiebaStatic.log(CommonStatisticKey.MY_SERVICE_CK);
                    if (FrsFragment.this.iSt != null && FrsFragment.this.iSt.getForum() != null) {
                        ForumData forum = FrsFragment.this.iSt.getForum();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(forum.getId(), 0L), forum.getName(), forum.getImage_url(), 0)));
                    }
                }
            } else if (bh.checkUpIsLogin(FrsFragment.this.getActivity())) {
                TiebaStatic.log("forum_fortune_click");
                com.baidu.tieba.frs.f.l.c(FrsFragment.this.getPageContext(), FrsFragment.this.iSt);
            }
        }
    };
    private final NoNetworkView.a iQf = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.FrsFragment.42
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (FrsFragment.this.iTn.cJd() == 1 && z && !FrsFragment.this.iSV.cCK()) {
                if (FrsFragment.this.iSt == null || com.baidu.tbadk.core.util.y.isEmpty(FrsFragment.this.iSt.getThreadList())) {
                    FrsFragment.this.hideNetRefreshView(FrsFragment.this.iSV.cDS().cLd());
                    FrsFragment.this.showLoadingView(FrsFragment.this.iSV.cnn(), true);
                    FrsFragment.this.iSV.qb(false);
                    FrsFragment.this.refresh();
                    return;
                }
                FrsFragment.this.iSV.cDr();
            }
        }
    };
    private final CustomMessageListener flC = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.FrsFragment.43
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                com.baidu.tieba.frs.f.c.a(customResponsedMessage, FrsFragment.this.iSV, FrsFragment.this.iSt);
            }
        }
    };
    private com.baidu.adp.widget.ListView.ab iUG = new a();
    private au iUH = new au() { // from class: com.baidu.tieba.frs.FrsFragment.46
        @Override // com.baidu.tieba.frs.au
        public void a(int i, int i2, bd bdVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
            com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.46.1
                @Override // java.lang.Runnable
                public void run() {
                    if (FrsFragment.this.iSV != null && FrsFragment.this.iSV.cDK()) {
                        FrsFragment.this.bRM();
                    }
                }
            });
        }
    };
    private CustomMessageListener iUI = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.frs.FrsFragment.47
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    FrsFragment.this.iTI = true;
                }
            }
        }
    };
    private CustomMessageListener iUJ = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.frs.FrsFragment.48
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                    if (FrsFragment.this.iTm == null && FrsFragment.this.iSV.cDi() != null && !FrsFragment.this.iSV.cCK() && FrsFragment.this.iSV.cDi().dBO() != null && (FrsFragment.this.iSV.cDi().dBO().getTag() instanceof com.baidu.card.am)) {
                        FrsFragment.this.iTm = (com.baidu.card.am) FrsFragment.this.iSV.cDi().dBO().getTag();
                    }
                    if (FrsFragment.this.iTm != null && FrsFragment.this.iTm.tZ() != null) {
                        FrsFragment.this.iTm.tZ().b(new a.C0097a(3));
                    }
                }
            }
        }
    };
    private CustomMessageListener iUK = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.FrsFragment.49
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.iSV != null) {
                FrsFragment.this.iSV.HO();
            }
        }
    };
    private CustomMessageListener iUL = new CustomMessageListener(2921437) { // from class: com.baidu.tieba.frs.FrsFragment.50
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && FrsFragment.this.isResumed()) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (FrsFragment.this.iSX != null) {
                    if (booleanValue) {
                        if (FrsFragment.this.iTp.cLp() != 0 && !FrsFragment.this.iSV.cDP() && !com.baidu.tbadk.k.d.bDH().bDI()) {
                            FrsFragment.this.iSX.show();
                            return;
                        }
                        return;
                    }
                    FrsFragment.this.iSX.hide();
                }
            }
        }
    };
    private CustomMessageListener iUM = new CustomMessageListener(2921462) { // from class: com.baidu.tieba.frs.FrsFragment.55
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && FrsFragment.this.iSt.getToLoadHorseData().intValue() == 1 && FrsFragment.this.mIsLogin) {
                LiveHorseRaceRequestMessage liveHorseRaceRequestMessage = new LiveHorseRaceRequestMessage();
                liveHorseRaceRequestMessage.setForum_id(Long.valueOf(FrsFragment.this.forumId));
                FrsFragment.this.sendMessage(liveHorseRaceRequestMessage);
            }
        }
    };
    private CustomMessageListener iUN = new CustomMessageListener(2001223) { // from class: com.baidu.tieba.frs.FrsFragment.57
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Date)) {
                FrsFragment.this.iTR = (Date) customResponsedMessage.getData();
            }
        }
    };
    private CustomMessageListener iUO = new CustomMessageListener(2921469) { // from class: com.baidu.tieba.frs.FrsFragment.58
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.y) && FrsFragment.this.isResumed()) {
                com.baidu.tbadk.core.data.y yVar = (com.baidu.tbadk.core.data.y) customResponsedMessage.getData();
                if (FrsFragment.this.iTY == null) {
                    FrsFragment.this.iTY = new com.baidu.tieba.frs.broadcast.a(FrsFragment.this.getPageContext());
                }
                if (FrsFragment.this.iSt != null && FrsFragment.this.iSt.getForum() != null && !TextUtils.isEmpty(FrsFragment.this.iSt.getForum().getId())) {
                    FrsFragment.this.iTY.e(yVar.type, FrsFragment.this.iSt.getForum().getId(), FrsFragment.this.iSt.getForum().getName(), yVar.tid);
                }
            }
        }
    };
    private CustomMessageListener iUP = new CustomMessageListener(2921475) { // from class: com.baidu.tieba.frs.FrsFragment.59
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            by byVar = (by) customResponsedMessage.getData();
            if (byVar != null && FrsFragment.this.isResumed()) {
                FrsFragment.this.iTk = byVar.getTid() + "";
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE_NUMBER);
                httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
                httpMessage.addParam("forum_id", byVar.getFid());
                MessageManager.getInstance().sendMessage(httpMessage);
            }
        }
    };
    private HttpMessageListener iUQ = new HttpMessageListener(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE_NUMBER) { // from class: com.baidu.tieba.frs.FrsFragment.60
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if ((httpResponsedMessage instanceof ForumManagerRightsResMsg) && FrsFragment.this.isResumed()) {
                ForumManagerRightsResMsg forumManagerRightsResMsg = (ForumManagerRightsResMsg) httpResponsedMessage;
                if (forumManagerRightsResMsg.broadcastTotalCount - forumManagerRightsResMsg.broadcastUsedCount <= 0) {
                    new ScreenTopToast(FrsFragment.this.getContext()).Vx(FrsFragment.this.getString(R.string.frs_forum_bawu_send_broadcast_none_tip)).Vz(FrsFragment.this.getString(R.string.frs_recommend_fail_tip_btn)).al(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.60.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("_forumId", FrsFragment.this.iSt.getForum().getId());
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new com.baidu.tieba.tbadkCore.data.m(FrsFragment.this.getContext(), "ForumGradePage", hashMap)));
                        }
                    }).aF((ViewGroup) FrsFragment.this.mRootView.findViewById(R.id.frs));
                    return;
                }
                com.baidu.tbadk.core.util.o oVar = new com.baidu.tbadk.core.util.o(TbadkCoreApplication.getInst());
                oVar.al(FrsFragment.this.iSt.getForum().getId(), FrsFragment.this.iSt.getForum().getName(), "6");
                oVar.BQ(FrsFragment.this.iTk);
                oVar.start();
            }
        }
    };
    private CustomMessageListener iUR = new CustomMessageListener(2921515) { // from class: com.baidu.tieba.frs.FrsFragment.61
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                com.baidu.tieba.NEGFeedBack.g gVar = (com.baidu.tieba.NEGFeedBack.g) customResponsedMessage.getData();
                if (FrsFragment.this.iSt == null || FrsFragment.this.iSt.getForum() == null || FrsFragment.this.iSt.getForum().getDeletedReasonInfo() == null) {
                    com.baidu.tieba.NEGFeedBack.d.a(0, FrsFragment.this.getPageContext(), gVar, null, FrsFragment.this.iSt.getUserData());
                    return;
                }
                com.baidu.tieba.NEGFeedBack.h hVar = new com.baidu.tieba.NEGFeedBack.h(FrsFragment.this.iSt.getForum().getDeletedReasonInfo().is_grays_cale_forum.intValue(), FrsFragment.this.iSt.getForum().getDeletedReasonInfo().is_boomgrow.intValue(), FrsFragment.this.iSt.forumRule != null ? FrsFragment.this.iSt.forumRule.has_forum_rule.intValue() : 0);
                hVar.ek(FrsFragment.this.iSt.getForum().getId(), FrsFragment.this.iSt.getForum().getName());
                hVar.setForumHeadUrl(FrsFragment.this.iSt.getForum().getImage_url());
                hVar.setUserLevel(FrsFragment.this.iSt.getForum().getUser_level());
                com.baidu.tieba.NEGFeedBack.d.a(hVar.bLz(), FrsFragment.this.getPageContext(), gVar, hVar, FrsFragment.this.iSt.getUserData());
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.frs.loadmore.a
    public /* bridge */ /* synthetic */ com.baidu.adp.base.e getPageContext() {
        return super.getPageContext();
    }

    public com.baidu.tieba.frs.entelechy.b.b cBV() {
        return this.iTv;
    }

    public com.baidu.adp.widget.ListView.ab cBW() {
        return this.iUG;
    }

    public com.baidu.tieba.frs.mc.d cBX() {
        return this.iTx;
    }

    public com.baidu.tieba.frs.smartsort.a cBY() {
        return this.iTr;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public FrsModelController cBZ() {
        return this.iTn;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public com.baidu.tieba.frs.mc.c cCa() {
        return this.iTy;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public com.baidu.tieba.frs.vc.h cCb() {
        return this.iTo;
    }

    public FrsTabViewController cCc() {
        return this.iTp;
    }

    public aw cCd() {
        return this.iTt;
    }

    public void pQ(boolean z) {
        this.iTQ = z;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public q cCe() {
        return this.iSV;
    }

    @Override // com.baidu.tieba.frs.av
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.av, com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.iSN;
    }

    public void setForumName(String str) {
        this.iSN = str;
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
        if (this.iTy == null) {
            return 1;
        }
        return this.iTy.getPn();
    }

    public int getPn() {
        if (this.iTy == null) {
            return 1;
        }
        return this.iTy.getPn();
    }

    public void setPn(int i) {
        if (this.iTy != null) {
            this.iTy.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.iTy != null) {
            this.iTy.setHasMore(i);
        }
    }

    public int cCf() {
        if (this.iTy == null) {
            return -1;
        }
        return this.iTy.cCf();
    }

    public boolean cCg() {
        return this.iST;
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
            this.iSV.cDl();
            showNetRefreshView(this.iSV.cnn(), string, true);
        } else if (340001 == fVar.errorCode) {
            a(fVar, this.iSt.getRecm_forum_list());
        } else {
            if (com.baidu.tbadk.core.util.y.isEmpty(this.iSt.getThreadList())) {
                b(fVar);
            }
            if (cCM()) {
                setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds280));
            } else {
                setNetRefreshViewEmotionDefMarginTop();
            }
        }
    }

    public void a(View view, String str, boolean z, List<RecmForumInfo> list) {
        this.iSV.cDl();
        this.iSV.zQ(8);
        if (this.iTG == null) {
            this.iTG = new com.baidu.tieba.frs.view.a(getPageContext(), getNetRefreshListener());
        }
        this.iTG.setSubText(str);
        this.iTG.setListData(list);
        this.iTG.attachView(view, z);
    }

    private void a(com.baidu.tieba.tbadkCore.f fVar, List<RecmForumInfo> list) {
        if (this.iSV != null) {
            this.iSV.cDl();
            this.iSV.setTitle(this.iSN);
            a(this.iSV.cnn(), fVar.errorMsg, true, list);
        }
    }

    private void b(com.baidu.tieba.tbadkCore.f fVar) {
        this.iSV.cDl();
        if (fVar.iCU) {
            showNetRefreshView(this.iSV.cnn(), TbadkCoreApplication.getInst().getString(R.string.net_error_text, new Object[]{fVar.errorMsg, Integer.valueOf(fVar.errorCode)}), true);
        } else {
            showNetRefreshView(this.iSV.cDS().cLd(), fVar.errorMsg, true);
        }
    }

    public void cCh() {
        hideLoadingView(this.iSV.cnn());
        this.iSV.bSl();
        if (this.iSV.cDj() instanceof com.baidu.tieba.frs.tab.c) {
            ((com.baidu.tieba.frs.tab.c) this.iSV.cDj()).cJL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCi() {
        if (cCf() == 0 && com.baidu.tbadk.core.util.y.isEmpty(this.iSt.getThreadListIds())) {
            if (com.baidu.tbadk.core.util.y.isEmpty(this.iSt.getThreadList())) {
                this.iSV.bTa();
            } else {
                this.iSV.Ya();
            }
        } else if (com.baidu.tbadk.core.util.y.getCount(this.iSt.getThreadList()) > 3) {
            this.iSV.XZ();
        } else {
            this.iSV.cDG();
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
            cCh();
            this.iSV.cDr();
            com.baidu.tieba.tbadkCore.f cIZ = this.iTn.cIZ();
            boolean isEmpty = com.baidu.tbadk.core.util.y.isEmpty(this.iSt.getThreadList());
            if (cIZ != null && isEmpty) {
                if (this.iTn.cJb() != 0) {
                    this.iTn.cJg();
                    this.iSV.cDr();
                } else {
                    a(cIZ);
                }
                this.iSV.Y(this.iSt.isStarForum(), false);
                return;
            }
            a(cIZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(com.baidu.tieba.tbadkCore.m mVar) {
        if (mVar != null && mVar.getEntelechyTabInfo() != null && mVar.getEntelechyTabInfo().tab != null) {
            for (FrsTabInfo frsTabInfo : mVar.getEntelechyTabInfo().tab) {
                if (frsTabInfo.tab_id.intValue() == 502 && com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean("first_into_tab_profession", true)) {
                    return false;
                }
            }
        }
        return new com.baidu.tieba.frs.ad.f(getTbPageContext()).d(mVar);
    }

    public boolean cCj() {
        return cCk() && !cCl();
    }

    private boolean cCk() {
        if (cCJ() == null) {
            return false;
        }
        FrsViewData cCJ = cCJ();
        com.baidu.tbadk.core.data.z zVar = null;
        if (cCJ.getStar() != null && !StringUtils.isNull(cCJ.getStar().dOt())) {
            zVar = new com.baidu.tbadk.core.data.z();
        } else if (cCJ.getActivityHeadData() != null && com.baidu.tbadk.core.util.y.getCount(cCJ.getActivityHeadData().bmT()) >= 1) {
            zVar = cCJ.getActivityHeadData().bmT().get(0);
        }
        return zVar != null;
    }

    public boolean cCl() {
        if (cCJ() == null) {
            return false;
        }
        FrsViewData cCJ = cCJ();
        return (com.baidu.tbadk.core.util.y.isEmpty(cCJ.getShowTopThreadList()) && cCJ.getBusinessPromot() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCm() {
        boolean b;
        if (!cCo()) {
            final PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
            privateForumPopInfoData.a(this.iSt.getPrivateForumTotalInfo().getPrivatePopInfo());
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(getActivity());
            if (this.iSt.getPrivateForumTotalInfo().bnM().private_forum_status.intValue() == 1 && (com.baidu.tbadk.core.util.au.isEmpty(privateForumPopInfoData.bnO()) || privateForumPopInfoData.bnR() != Integer.valueOf(this.forumId))) {
                privateForumPopInfoData.AT("create_success");
                privateForumPopInfoData.AU(TbadkCoreApplication.getInst().getString(R.string.frs_private_create_hint));
                privateForumPopInfoData.AV("https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.iSN + "&nomenu=1");
                privateForumPopInfoData.k(Integer.valueOf(this.forumId));
                b = frsPrivateCommonDialogView.b(privateForumPopInfoData);
            } else {
                b = privateForumPopInfoData.bnR() == Integer.valueOf(this.forumId) ? frsPrivateCommonDialogView.b(privateForumPopInfoData) : false;
            }
            if (b) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
                aVar.oT(2);
                aVar.bi(frsPrivateCommonDialogView);
                aVar.jm(false);
                frsPrivateCommonDialogView.setConfirmButton(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.19
                    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.frs.FrsFragment */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        com.baidu.tbadk.core.util.bf.bua().b(FrsFragment.this.getPageContext(), new String[]{privateForumPopInfoData.bnQ()});
                        aVar.dismiss();
                    }
                });
                aVar.a(new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.20
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(getPageContext()).brv();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCn() {
        if (cCo() || this.iSt.getPrivateForumTotalInfo().bnM().private_forum_status.intValue() != 1) {
            a((Integer) null, (Integer) null, true);
        } else {
            a(this.iSt.getPrivateForumTotalInfo().bnM().private_forum_audit_status, this.iSt.getPrivateForumTotalInfo().bnN(), false);
        }
    }

    public void a(Integer num, Integer num2, boolean z) {
        final String str;
        final int i = 2;
        if (this.iSV.cDx() != null) {
            TextView cDx = this.iSV.cDx();
            if (z) {
                cDx.setVisibility(8);
                return;
            }
            if (num.intValue() == 2) {
                cDx.setText("修改实名认证信息");
                cDx.setVisibility(0);
                str = "https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + this.forumId + "&nomenu=1";
            } else if (num2.intValue() >= 0 && num2.intValue() <= 100) {
                cDx.setText("目标已完成" + String.valueOf(num2) + "%");
                cDx.setVisibility(0);
                str = "https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.iSN + "&nomenu=1";
                i = 1;
            } else {
                cDx.setVisibility(8);
                i = 0;
                str = "";
            }
            cDx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.21
                /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13387").dY("fid", FrsFragment.this.forumId).dY("uid", TbadkCoreApplication.getCurrentAccount()).al("obj_type", i));
                    com.baidu.tbadk.core.util.bf.bua().b(FrsFragment.this.getPageContext(), new String[]{str});
                }
            });
        }
    }

    private boolean cCo() {
        return this.iSt == null || this.iSt.getPrivateForumTotalInfo() == null || this.iSt.getPrivateForumTotalInfo().bnM() == null || this.iSt.getUserData().getIs_manager() != 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zF(int i) {
        List<WindowToast> list;
        if (TbadkCoreApplication.isLogin() && this.iSt != null && (list = this.iSt.mWindowToast) != null && list.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < list.size()) {
                    WindowToast windowToast = list.get(i3);
                    if (windowToast == null || windowToast.toast_type.intValue() != i) {
                        i2 = i3 + 1;
                    } else if (!com.baidu.tbadk.core.util.au.isEmpty(windowToast.toast_link)) {
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), "", com.baidu.tbadk.util.aj.addParamsForPageTranslucent(windowToast.toast_link), true)));
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
    public void cCp() {
        if (getActivity() != null && getActivity().getIntent() != null) {
            String stringExtra = getActivity().getIntent().getStringExtra(FrsActivityConfig.KEY_ACHIEVEMENT_URL);
            if (!TextUtils.isEmpty(stringExtra)) {
                getActivity().getIntent().removeExtra(FrsActivityConfig.KEY_ACHIEVEMENT_URL);
                AchievementActivityConfig achievementActivityConfig = new AchievementActivityConfig(getActivity());
                achievementActivityConfig.setUrl(stringExtra);
                if (this.iSt != null && this.iSt.getForumActiveInfo() != null) {
                    achievementActivityConfig.setShareUrl(this.iSt.getForumActiveInfo().forum_share_url);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, achievementActivityConfig));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCq() {
        if (this.iSt == null || this.iSt.getForum() != null) {
            this.iSV.cDD();
        } else if (this.iSt.getForum().getYuleData() != null && this.iSt.getForum().getYuleData().brm()) {
            TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_VIEW);
            this.iSV.a(this.iSt.getForum().getYuleData().brn());
        } else {
            this.iSV.cDD();
        }
    }

    private void W(boolean z, boolean z2) {
        if (this.iTn != null && this.iSt != null && this.iSV != null && z) {
            if (!this.iTn.cJn() && this.iTn.cJd() == 1) {
                if (!this.iTn.cJl()) {
                    this.iSt.addCardVideoInfoToThreadList();
                    this.iSt.addVideoInfoToThreadListInTenAndFifteenFloor();
                }
                boolean z3 = false;
                if (this.iSV.cDE().r(com.baidu.tieba.card.data.n.inE)) {
                    z3 = this.iSt.addHotTopicDataToThreadList();
                }
                if (!z3) {
                    this.iSt.addFeedForumDataToThreadList();
                }
                if (TbadkCoreApplication.getInst().isRecAppExist()) {
                    this.iSt.addRecommendAppToThreadList(this);
                }
                if (!this.iSV.cDE().r(by.eJr)) {
                    this.iSt.removeAlaLiveThreadData();
                }
                this.iSt.addSchoolRecommendToThreadList();
            }
            if (!this.iSV.cDE().r(by.eJr)) {
                this.iSt.removeAlaInsertLiveData();
                this.iSt.removeAlaStageLiveDat();
            } else {
                this.iSt.addInsertLiveDataToThreadList();
                this.iSt.addStageLiveDataToThreadList();
            }
            this.iSt.checkLiveStageInThreadList();
            this.iSt.addNoticeThreadToThreadList();
            if (this.iSV.cDE().r(com.baidu.tieba.i.b.jDL)) {
                this.iSt.addGameRankListToThreadList(z2);
            }
            if (TbadkCoreApplication.isLogin() && (!this.iTn.cJn() || this.iTn.isNetFirstLoad)) {
                this.iSt.addUserRecommendToThreadList();
            }
            this.iSt.addVideoActivityToTop();
        }
    }

    public boolean cCr() {
        if (this.iTo != null && this.iTn != null) {
            this.iTo.a(this.iTn.getPageType(), this.iSt);
        }
        boolean z = false;
        if (this.iSt != null) {
            z = this.iSt.hasTab();
        }
        cCu();
        if (this.iSV != null) {
            this.iSV.cDQ();
            this.iSV.cDR();
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zG(int i) {
        ba baVar = null;
        cCr();
        cCE();
        try {
            if (this.iSt != null) {
                this.iSV.a((ArrayList<com.baidu.adp.widget.ListView.q>) null, this.iSt);
                this.iTo.BI(1);
                this.iSV.cDu();
                this.iTp.a(this.iSt, this.iTn.cJi());
                com.baidu.tieba.frs.tab.d BR = this.iTp.BR(this.iSt.getFrsDefaultTabId());
                if (BR != null && !TextUtils.isEmpty(BR.url)) {
                    baVar = new ba();
                    baVar.ext = BR.url;
                    baVar.stType = BR.name;
                }
                this.iTn.a(this.iSt.getFrsDefaultTabId(), 0, baVar);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(boolean z, boolean z2) {
        try {
            if (this.iSt != null && this.iTp != null && this.iTn != null) {
                if (!this.iSV.cDE().r(by.eJr)) {
                    this.iSt.removeAlaLiveThreadData();
                }
                boolean isEmpty = com.baidu.tbadk.core.util.y.isEmpty(this.iSt.getGameTabInfo());
                this.iSV.pZ(isEmpty);
                if (!isEmpty) {
                    if (this.iTH == null) {
                        this.iTH = new com.baidu.tieba.frs.vc.e(this, (NoPressedRelativeLayout) this.mRootView);
                    }
                    if (this.gLP == null) {
                        this.gLP = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
                    }
                } else {
                    this.iTH = null;
                    this.gLP = null;
                }
                if (this.iSt.getForum() != null) {
                    this.iSN = this.iSt.getForum().getName();
                    this.forumId = this.iSt.getForum().getId();
                }
                if (this.iSt.hasTab()) {
                    this.iTp.a(this.iSt, this.iTn.cJi());
                }
                if (z) {
                    W(true, z);
                } else {
                    W(this.iTi, z);
                }
                cCr();
                if (this.iTv != null) {
                    this.iTv.a(this.iTo, this.iSt);
                }
                if (this.iSt.getPage() != null) {
                    setHasMore(this.iSt.getPage().bnF());
                }
                ArrayList<com.baidu.adp.widget.ListView.q> a2 = this.iTy.a(z2, true, this.iSt.getThreadList(), null, z, false);
                if (a2 != null) {
                    this.iSt.setThreadList(a2);
                }
                this.iSt.removeRedundantUserRecommendData();
                this.iSv = this.iSt.getTopThreadSize();
                if (this.iSR != null) {
                    this.iSQ = true;
                    this.iSR.KR(this.iSv);
                    com.baidu.tieba.frs.f.a.a(this, this.iSt.getForum(), this.iSt.getThreadList(), this.iSQ, getPn());
                }
                if (this.iTn.cJd() == 1) {
                    cCy();
                    if (!z && this.iTn.getPn() == 1) {
                        cCt();
                    }
                }
                if (this.iTw != null) {
                    this.iTw.cT(this.iTp.cLl());
                }
                cCh();
                this.iSV.cDm();
                this.iSV.Y(true, false);
                if (z && this.iSt.isFirstTabEqualAllThread()) {
                    com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.22
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!FrsFragment.this.iTg && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                FrsFragment.this.iSV.cDO();
                            }
                        }
                    });
                }
                if (this.iSt.getForum() != null) {
                    this.iSV.KJ(this.iSt.getForum().getWarningMsg());
                }
                if (this.iSt != null && this.iSt.getFrsVideoActivityData() != null && com.baidu.tbadk.core.sharedPref.b.bsO().getLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 0L) == 0) {
                    com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.24
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsFragment.this.iSV.cDM();
                        }
                    }, 1000L);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FRS_SHOW_AR_ENTRY, this));
                this.iSV.cDg();
                if (this.iSt != null && this.iSt.getForum() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ENTER_FORUM, new VisitedForumData(this.iSt.getForum().getId(), this.iSt.getForum().getName(), this.iSt.getForum().getImage_url(), String.valueOf(System.currentTimeMillis() / 1000), ConstantData.Forum.SPECAIL_FORUM_TYPE_LIVE.equals(this.iSt.getForum().special_forum_type), this.iSt.getForum().getThemeColorInfo(), this.iSt.getForum().getMember_num())));
                }
                this.iTL.a(this.iSt.bottomMenuList, this.iSt.getForum());
                cCT();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void cCs() {
        if (this.iTn != null && this.iTn.cJd() == 1) {
            this.iTo.k(this.iSt);
        }
    }

    public void pR(boolean z) {
        com.baidu.tieba.t.c.dOe().b(getUniqueId(), z);
    }

    public void cCt() {
        if (this.iTB == null) {
            this.iTB = new com.baidu.tieba.frs.live.a(this, com.baidu.adp.lib.f.b.toInt(this.forumId, 0));
        }
        this.iTB.cIK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.tbadkCore.m mVar) {
        try {
            if (!this.iTg && mVar != null && this.iSt != null) {
                this.iSt.receiveData(mVar);
                X(true, false);
                Looper.myQueue().addIdleHandler(this.iUb);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void cCu() {
        if (this.iTn != null) {
            KH(this.iTn.getPageType());
        } else {
            KH("normal_page");
        }
    }

    private void KH(String str) {
        pS("frs_page".equals(str));
        if (this.iTv != null) {
            this.iTv.a(this.iTo, this.iSV, this.iSt);
        }
    }

    public void pS(boolean z) {
        if (this.iTz != null) {
            this.iTz.cKX();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.t.c.dOe().z(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.frs_activity, viewGroup, false);
            this.iSH = new com.baidu.tieba.frs.entelechy.a();
            this.iTv = this.iSH.cFz();
            this.iSG = TbadkCoreApplication.getInst().getString(R.string.frs_title_new_area);
            this.iTo = new com.baidu.tieba.frs.vc.h(this, this.iSH, (FrsHeaderViewContainer) this.mRootView.findViewById(R.id.header_view_container));
            this.iTp = new FrsTabViewController(this, this.mRootView);
            this.iTp.registerListener();
            this.iTo.a(this.iTp);
            this.iTp.a(this.iUj);
            Intent intent = getActivity().getIntent();
            if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                this.iSJ = true;
            }
            this.iSV = new q(this, this.iUE, this.iSH, this.iSJ, this.iTo);
            this.iTL = new com.baidu.tieba.frs.brand.buttommenu.a(getPageContext(), this.mRootView);
        } else {
            if (this.mRootView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            if (this.iTp != null) {
                this.iTp.registerListener();
            }
            this.iSV.cDL();
            this.mRootView.setLeft(0);
            this.mRootView.setRight(com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getContext()));
        }
        this.iTP = true;
        this.fCc = System.currentTimeMillis() - currentTimeMillis;
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        ArrayList<com.baidu.adp.widget.ListView.q> arrayList = null;
        this.ivy = System.currentTimeMillis();
        long j = this.ivy;
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.iSS = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.ivy = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            R(intent);
        }
        this.fCb = j - this.ivy;
        this.iSR = new com.baidu.tieba.tbadkCore.data.f("frs", com.baidu.tieba.tbadkCore.data.f.nlg);
        if (this.iTn == null) {
            this.iTn = new FrsModelController(this, this.iUz);
            this.iTn.a(this.iUi);
            this.iTn.init();
        }
        this.iTn.setSchemeUrl(this.mSchemeUrl);
        if (intent != null) {
            this.iTn.aj(intent.getExtras());
        } else if (bundle != null) {
            this.iTn.aj(bundle);
        } else {
            this.iTn.aj(null);
        }
        if (intent != null) {
            this.iTo.as(intent.getExtras());
        } else if (bundle != null) {
            this.iTo.as(bundle);
        } else {
            this.iTo.as(null);
        }
        this.iSU = getVoiceManager();
        this.iTC = new p(getPageContext(), this);
        initUI();
        initData(bundle);
        if (!cCM()) {
            this.iTt = new aw(getActivity(), this.iSV, this.iTo);
            this.iTt.qo(true);
        }
        this.iSU = getVoiceManager();
        if (this.iSU != null) {
            this.iSU.onCreate(getPageContext());
        }
        if (FrsActivityConfig.FRS_FROM_FLUTTER_BCASTEDIT.equals(getFrom()) && !this.hasInit) {
            int i = com.baidu.tbadk.core.sharedPref.b.bsO().getInt("key_forum_broadcast_edit_tip_number", 0);
            if (i < 2) {
                com.baidu.tbadk.core.sharedPref.b.bsO().putInt("key_forum_broadcast_edit_tip_number", i + 1);
                cCA();
            } else if (Build.VERSION.SDK_INT >= 23) {
                if (Settings.canDrawOverlays(getContext())) {
                    cCB();
                } else {
                    new BdTopToast(getContext()).yW(false).Vt(getContext().getString(R.string.forum_broadcast_copy_no_permission_hint)).aF(this.iSV.cnn());
                }
            } else {
                cCB();
            }
        }
        if (FrsActivityConfig.FRS_FROM_FORUM_RULE_EDIT.equals(getFrom()) && !this.hasInit) {
            if (Build.VERSION.SDK_INT >= 23) {
                if (Settings.canDrawOverlays(getContext())) {
                    cCC();
                } else if (Build.VERSION.SDK_INT < 23 || !com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean("key_forum_rule_dialog_show_frs", false)) {
                    cCC();
                    com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean("key_forum_rule_dialog_show_frs", true);
                }
            } else {
                cCC();
            }
        }
        if (com.baidu.tbadk.k.d.bDH().bDI()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
            if (this.iSW != null) {
                this.iSW.setVisibility(8);
            }
        }
        new com.baidu.tieba.frs.mc.i();
        int i2 = -1;
        if (this.iTy != null && this.iTy.cIV() != null) {
            i2 = this.iTy.cIV().cCf();
            arrayList = this.iTy.cIV().getDataList();
        }
        this.iTy = new com.baidu.tieba.frs.mc.c(this, this.iUC);
        this.iTy.cIV().setHasMore(i2);
        if (arrayList != null && arrayList.size() > 0) {
            this.iTy.cIV().aI(arrayList);
        }
        this.iTr = new com.baidu.tieba.frs.smartsort.a(this);
        this.iTz = new com.baidu.tieba.frs.vc.j(this);
        this.iTw = new com.baidu.tieba.frs.vc.a(getPageContext(), this.iTn.cJk());
        this.iTs = new com.baidu.tieba.frs.mc.b(this);
        this.iTx = new com.baidu.tieba.frs.mc.d(this);
        this.iTq = new com.baidu.tieba.frs.mc.h(this);
        this.iTA = new com.baidu.tieba.frs.mc.a(this);
        this.iTD = new com.baidu.tieba.frs.vc.c(this);
        this.iTE = new com.baidu.tieba.frs.mc.e(this, getUniqueId());
        this.iTJ = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "frs");
        this.iTK = new com.baidu.tieba.ala.a(getPageContext());
        this.iTM = new com.baidu.tieba.frs.sportspage.notification.a(getPageContext());
        registerListener(this.iUr);
        registerListener(this.mMemListener);
        registerListener(this.iUp);
        registerListener(this.iUD);
        registerListener(this.iUA);
        registerListener(this.iUl);
        registerListener(this.iUm);
        registerListener(this.iUn);
        registerListener(this.iUo);
        registerListener(this.iUc);
        registerListener(this.iUd);
        registerListener(this.ahC);
        registerListener(this.iUe);
        registerListener(this.iUI);
        registerListener(this.iUt);
        registerListener(this.iUh);
        registerListener(this.iUu);
        registerListener(this.iUs);
        registerListener(this.iUw);
        registerListener(this.iUx);
        registerListener(this.iUy);
        this.iUJ.setTag(getPageContext().getUniqueId());
        MessageManager.getInstance().registerListener(this.iUJ);
        registerListener(this.iUK);
        registerListener(this.iUL);
        registerListener(this.iUM);
        registerListener(this.iUg);
        registerListener(this.iUN);
        registerListener(this.iUv);
        registerListener(this.iUf);
        registerListener(this.iUO);
        registerListener(this.iUP);
        registerListener(this.iUQ);
        registerListener(this.iUR);
        this.iSV.qb(false);
        if (!cCM() && !this.hasInit) {
            showLoadingView(this.iSV.cnn(), true);
            this.iTn.T(3, false);
        }
        ay ayVar = new ay() { // from class: com.baidu.tieba.frs.FrsFragment.27
            @Override // com.baidu.tieba.frs.ay
            public void d(boolean z, boolean z2, int i3) {
                if (FrsFragment.this.iSV != null) {
                    if (i3 == 1) {
                        FrsFragment.this.iSV.zR(z ? 0 : 8);
                    } else if (i3 == 2) {
                        FrsFragment.this.iSV.zT(z ? 0 : 8);
                    }
                    if (!z2) {
                        FrsFragment.this.iTO = z;
                    }
                    if (FrsFragment.this.iSV.cDE() != null && (i3 == 2 || (FrsFragment.this.iTn != null && FrsFragment.this.iTn.cJe()))) {
                        FrsFragment.this.iSV.cDE().notifyDataSetChanged();
                    }
                    if (FrsFragment.this.cCc() != null) {
                        FrsTabViewController.b cLm = FrsFragment.this.cCc().cLm();
                        if (cLm != null) {
                            if ((cLm.fragment instanceof FrsCommonTabFragment) && (i3 == 2 || cLm.tabId == 502)) {
                                ((FrsCommonTabFragment) cLm.fragment).cFp();
                            } else if ((cLm.fragment instanceof FrsNewAreaFragment) && (i3 == 2 || cLm.tabId == 503)) {
                                FrsNewAreaFragment frsNewAreaFragment = (FrsNewAreaFragment) cLm.fragment;
                                frsNewAreaFragment.cFp();
                                if (frsNewAreaFragment.cJv() != null) {
                                    com.baidu.tieba.frs.mc.g cJv = frsNewAreaFragment.cJv();
                                    cJv.qq(!z);
                                    if (i3 == 1) {
                                        cJv.qe(!z);
                                    } else if (i3 == 2) {
                                        cJv.qe(true);
                                    }
                                }
                            } else if (cLm.fragment instanceof FrsGoodFragment) {
                                ((FrsGoodFragment) cLm.fragment).cFp();
                            }
                        }
                        if (FrsFragment.this.cCc().cLe() != null) {
                            FrsFragment.this.cCc().cLe().setmDisallowSlip(z);
                            FrsFragment.this.cCc().qZ(z);
                        }
                    }
                    if (FrsFragment.this.iSV.cDk() != null) {
                        FrsFragment.this.iSV.pY(!z);
                    }
                    if (FrsFragment.this.getActivity() instanceof FrsActivity) {
                        ((FrsActivity) FrsFragment.this.getActivity()).pP(!z);
                    }
                    if (FrsFragment.this.iTL != null) {
                        FrsFragment.this.iTL.qw(!z);
                    }
                    FrsFragment.this.iSV.qd(!z);
                    if (i3 == 1) {
                        FrsFragment.this.iSV.qe(z ? false : true);
                    } else if (i3 == 2) {
                        FrsFragment.this.iSV.qe(true);
                    }
                }
            }

            @Override // com.baidu.tieba.frs.ay
            public void cq(int i3, int i4) {
                if (FrsFragment.this.iSV != null) {
                    if (i4 == 1) {
                        FrsFragment.this.iSV.zS(i3);
                    } else if (i4 == 2) {
                        FrsFragment.this.iSV.zU(i3);
                    }
                }
            }

            @Override // com.baidu.tieba.frs.ay
            public void zK(int i3) {
                if (FrsFragment.this.getContext() != null) {
                    if (i3 == 1) {
                        com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getContext(), R.string.frs_multi_delete_max_num);
                    } else if (i3 == 2 && FrsFragment.this.iSV != null) {
                        new BdTopToast(FrsFragment.this.getContext()).yW(false).Vt(FrsFragment.this.getContext().getString(R.string.frs_move_area_max_num)).aF(FrsFragment.this.iSV.cnn());
                    }
                }
            }
        };
        b.cBd().a(ayVar);
        com.baidu.tieba.frs.a.cAW().a(ayVar);
        this.iSV.b(new e.a() { // from class: com.baidu.tieba.frs.FrsFragment.28
            @Override // com.baidu.tieba.NEGFeedBack.e.a
            public void a(DeleteThreadHttpResponseMessage deleteThreadHttpResponseMessage) {
                boolean z;
                int i3 = 0;
                if (deleteThreadHttpResponseMessage != null) {
                    FrsFragment.this.iSV.bLp();
                    FrsFragment.this.iSV.cDN();
                    FrsNewAreaFragment frsNewAreaFragment = null;
                    if (FrsFragment.this.iTp == null || FrsFragment.this.iTp.cLm() == null || !(FrsFragment.this.iTp.cLm().fragment instanceof FrsNewAreaFragment)) {
                        z = false;
                    } else {
                        frsNewAreaFragment = (FrsNewAreaFragment) FrsFragment.this.iTp.cLm().fragment;
                        z = true;
                    }
                    if (deleteThreadHttpResponseMessage.getError() == 0) {
                        String text = !TextUtils.isEmpty(deleteThreadHttpResponseMessage.getText()) ? deleteThreadHttpResponseMessage.getText() : FrsFragment.this.getString(R.string.delete_fail);
                        if (deleteThreadHttpResponseMessage.getRetType() == 1211066) {
                            if (FrsFragment.this.ilO == null) {
                                FrsFragment.this.ilO = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.ilO.Bq(text);
                            FrsFragment.this.ilO.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.28.1
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.ilO.jm(false);
                            FrsFragment.this.ilO.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.ilO.brv();
                        } else if (deleteThreadHttpResponseMessage.getRetType() == 1211067) {
                            if (FrsFragment.this.ilO == null) {
                                FrsFragment.this.ilO = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.ilO.Bq(text);
                            FrsFragment.this.ilO.a(R.string.know, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.28.2
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.ilO.jm(false);
                            FrsFragment.this.ilO.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.ilO.brv();
                        } else {
                            FrsFragment.this.iSV.aP(deleteThreadHttpResponseMessage.getText(), ContextCompat.getColor(FrsFragment.this.getContext(), deleteThreadHttpResponseMessage.getRetType() == 1 ? R.color.nav_bar_tip_error : R.color.cp_link_tip_a_alpha95));
                        }
                        if (z && frsNewAreaFragment != null) {
                            frsNewAreaFragment.dy(deleteThreadHttpResponseMessage.getSuccessItems());
                        }
                        FrsFragment.this.dh(deleteThreadHttpResponseMessage.getSuccessItems());
                        b.cBd().dg(deleteThreadHttpResponseMessage.getSuccessItems());
                        for (com.baidu.adp.widget.ListView.q qVar : FrsFragment.this.iSt.getThreadList()) {
                            if (qVar instanceof bx) {
                                i3++;
                                continue;
                            }
                            if (i3 >= 6) {
                                break;
                            }
                        }
                        if (i3 < 6) {
                            FrsFragment.this.bRM();
                            return;
                        }
                        return;
                    }
                    com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getActivity(), deleteThreadHttpResponseMessage.getErrorString());
                }
            }
        });
        this.dOW = UtilHelper.getScreenHeight(getActivity());
        this.hasInit = true;
        zH(1);
        super.onActivityCreated(bundle);
        this.createTime = System.currentTimeMillis() - j;
    }

    public void pT(boolean z) {
        if (this.iTp != null) {
            this.iTp.jyi = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dh(List<String> list) {
        if (!com.baidu.tbadk.core.util.y.isEmpty(list)) {
            ArrayList<com.baidu.adp.widget.ListView.q> threadList = this.iSt.getThreadList();
            if (!com.baidu.tbadk.core.util.y.isEmpty(threadList) && this.iSV.getListView() != null && this.iSV.getListView().getData() != null) {
                Iterator<com.baidu.adp.widget.ListView.q> it = threadList.iterator();
                List<com.baidu.adp.widget.ListView.q> data = this.iSV.getListView().getData();
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.q next = it.next();
                    if (next instanceof bx) {
                        by byVar = ((bx) next).eCR;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= list.size()) {
                                break;
                            } else if (!com.baidu.tbadk.core.util.au.equals(list.get(i2), byVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.iTy.d(next);
                                this.iSV.getListView().getAdapter().notifyItemRemoved(i);
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
    public void cBb() {
        if (!com.baidu.tbadk.core.util.y.isEmpty(com.baidu.tieba.frs.a.cAW().cBa()) && this.iSV.getListView() != null && this.iSV.getListView().getData() != null) {
            ArrayList<com.baidu.adp.widget.ListView.q> threadList = this.iSt.getThreadList();
            if (!com.baidu.tbadk.core.util.y.isEmpty(threadList)) {
                Iterator<com.baidu.adp.widget.ListView.q> it = threadList.iterator();
                List<com.baidu.adp.widget.ListView.q> data = this.iSV.getListView().getData();
                int count = com.baidu.tbadk.core.util.y.getCount(com.baidu.tieba.frs.a.cAW().cBa());
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.q next = it.next();
                    if (next instanceof bx) {
                        by byVar = ((bx) next).eCR;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= count) {
                                break;
                            } else if (!com.baidu.tbadk.core.util.au.equals(com.baidu.tieba.frs.a.cAW().cBa().get(i2).getId(), byVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.iTy.d(next);
                                this.iSV.getListView().getAdapter().notifyItemRemoved(i);
                                break;
                            }
                        }
                    }
                    i++;
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.ap
    public void bSg() {
        if (isAdded() && this.gtX && !isLoadingViewAttached()) {
            showLoadingView(this.iSV.cnn(), true);
        }
    }

    @Override // com.baidu.tieba.frs.ap
    public void bSh() {
        if (isAdded() && this.gtX && isLoadingViewAttached()) {
            hideLoadingView(this.iSV.cnn());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (cCM()) {
            showLoadingView(this.iSV.cnn(), true);
            this.iSV.zV(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.iTn.S(3, true);
            bvQ().scrollToPosition(0);
        }
    }

    private void zH(int i) {
        String str = "";
        if (this.iSt != null && this.iSt.getForum() != null) {
            str = this.iSt.getForum().getId();
        }
        if (!StringUtils.isNull(str)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13008").dY("fid", str).dY("obj_type", "4").al("obj_locate", i).dY("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    @Override // com.baidu.tieba.frs.ap
    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.z zVar) {
        if (zVar != null) {
            this.fGc = zVar.bGK();
            this.iTF = zVar.bGL();
        }
    }

    @Override // com.baidu.tieba.frs.ap
    public void showFloatingView() {
        if (this.fGc != null) {
            this.fGc.kH(true);
        }
    }

    private void R(Intent intent) {
        if (intent != null) {
            if (intent != null) {
                if (!com.baidu.tieba.frs.f.i.a(this, getForumName(), "from", intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false)) && getActivity() != null) {
                    getActivity().finish();
                    return;
                }
            }
            Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
            this.mSchemeUrl = uri != null ? uri.toString() : null;
            if (uri != null) {
                this.iSN = uri.getQueryParameter("name");
                this.mFrom = uri.getQueryParameter("from");
                if (!StringUtils.isNull(this.iSN)) {
                    intent.putExtra("name", this.iSN);
                }
                if (!StringUtils.isNull(this.mFrom)) {
                    intent.putExtra("from", this.mFrom);
                }
                TiebaStatic.log(TbadkCoreStatisticKey.AS_INVOKE_TIEBA);
            }
            if (StringUtils.isNull(this.iSN) && uri != null) {
                if (com.baidu.tbadk.BdToken.f.p(uri)) {
                    com.baidu.tbadk.BdToken.f.biX().b(uri, this.iUB);
                } else {
                    com.baidu.tieba.frs.f.g U = com.baidu.tieba.frs.f.l.U(intent);
                    if (U != null) {
                        this.iSN = U.forumName;
                        if (U.jvP == null || U.jvP.equals("aidou")) {
                        }
                    }
                }
                if (!StringUtils.isNull(this.iSN)) {
                    intent.putExtra("name", this.iSN);
                }
                intent.putExtra(FrsActivityConfig.FRS_CALL_FROM, 12);
            }
        }
    }

    /* renamed from: com.baidu.tieba.frs.FrsFragment$29  reason: invalid class name */
    /* loaded from: classes22.dex */
    class AnonymousClass29 implements f.a {
        AnonymousClass29() {
        }

        @Override // com.baidu.tbadk.BdToken.f.a
        public void onCallBack(final HashMap<String, Object> hashMap) {
            if (hashMap != null) {
                if (hashMap.get(com.baidu.tbadk.BdToken.f.exb) instanceof String) {
                    FrsFragment.this.iSN = (String) hashMap.get(com.baidu.tbadk.BdToken.f.exb);
                }
                if ((hashMap.get(com.baidu.tbadk.BdToken.f.exu) instanceof String) && !TextUtils.isEmpty((String) hashMap.get(com.baidu.tbadk.BdToken.f.exu))) {
                    com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.29.1
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsFragment.this.iTp.ui(301);
                            final long j = com.baidu.adp.lib.f.b.toLong((String) hashMap.get(com.baidu.tbadk.BdToken.f.exc), 0L);
                            final int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
                            final int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
                            final float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                            final int i = 1;
                            if (com.baidu.tbadk.core.util.av.btX().btY()) {
                                i = 2;
                            }
                            com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.29.1.1
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
        this.iSU = getVoiceManager();
        if (this.iSU != null) {
            this.iSU.onStart(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        Intent intent;
        long j = 0;
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.flC);
        if (bundle != null) {
            this.iSN = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            j = bundle.getLong(FrsActivityConfig.FRS_FAKE_THREAD_ID, 0L);
        } else if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
            this.iSN = intent.getStringExtra("name");
            this.mFrom = intent.getStringExtra("from");
            this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
            j = intent.getLongExtra(FrsActivityConfig.FRS_FAKE_THREAD_ID, 0L);
        }
        if (getArguments() != null) {
            this.iSO = getArguments().getBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, false);
        }
        if (TextUtils.isEmpty(this.mFrom) || FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
        }
        if (this.mIsLogin) {
            registerListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL, this.flC);
        }
        this.iTo.as(bundle);
        gl(j);
    }

    private void gl(final long j) {
        if (j > 0) {
            final int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
            final int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
            final float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            final int i = 1;
            if (com.baidu.tbadk.core.util.av.btX().btY()) {
                i = 2;
            }
            com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.33
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

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.t.c.dOe().A(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.iUI);
        this.iTz.destroy();
        iSZ = null;
        if (this.iSU != null) {
            this.iSU.onDestory(getPageContext());
        }
        com.baidu.tieba.recapp.report.a.remove("FRS");
        this.iSU = null;
        com.baidu.tieba.card.t.csg().oX(false);
        if (this.iSt != null && this.iSt.getForum() != null) {
            aj.cEn().gm(com.baidu.adp.lib.f.b.toLong(this.iSt.getForum().getId(), 0L));
        }
        if (this.iTB != null) {
            this.iTB.onDestory();
        }
        if (this.iSV != null) {
            com.baidu.tieba.frs.f.k.a(this.iSV, this.iSt, getForumId(), false, null);
            this.iSV.onDestroy();
        }
        if (this.iSY != null) {
            this.iSY.removeAllViews();
            this.iSY.setVisibility(8);
        }
        if (this.iTV != null) {
            this.iTV.cancel();
        }
        if (this.iTW != null) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.iTW);
        }
        this.iTU = null;
        super.onDestroy();
        try {
            if (this.iTh != null) {
                this.iTh.bFf();
            }
            if (this.iSV != null) {
                this.iSV.release();
            }
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.iTo.cIC();
        Looper.myQueue().removeIdleHandler(this.iUb);
        if (this.iTn != null) {
            this.iTn.bYY();
        }
        if (this.iTt != null) {
            this.iTt.cEv();
        }
        if (this.iTw != null) {
            this.iTw.destory();
        }
        if (this.iTr != null) {
            this.iTr.onDestroy();
        }
        if (this.iTH != null) {
            this.iTH.onDestory();
        }
        if (this.iTA != null) {
            this.iTA.onDestroy();
        }
        if (this.iTJ != null) {
            this.iTJ.onDestroy();
        }
        if (this.iTK != null) {
            this.iTK.onDestroy();
        }
        com.baidu.tieba.recapp.d.a.dFX().dGa();
        com.baidu.tieba.frs.f.m.cKf();
        if (this.iTp != null) {
            this.iTp.a((FrsTabViewController.a) null);
            this.iTp.cLo();
        }
        if (this.iTN != null) {
            this.iTN.onDestroy();
        }
        b.cBd().a(null);
        com.baidu.tieba.frs.a.cAW().a(null);
        if (this.iUa != null) {
            this.iUa.cKd();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.iSN);
        bundle.putString("from", this.mFrom);
        this.iTn.onSaveInstanceState(bundle);
        if (this.iSU != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            this.iSU.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.iTA != null) {
            this.iTA.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.iSV != null) {
            this.iSV.cDr();
            this.iSV.onResume();
        }
        this.iTq.qR(true);
        this.iTi = true;
        if (iSM) {
            iSM = false;
            if (this.iSV != null) {
                this.iSV.startPullRefresh();
                return;
            }
            return;
        }
        if (this.iSU != null) {
            this.iSU.onResume(getPageContext());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_RESUME));
        if (this.iSV != null) {
            this.iSV.qf(false);
        }
        if (this.iTI) {
            refresh(6);
            this.iTI = false;
        }
        if (this.iTR != null && getActivity() != null) {
            if (NotificationManagerCompat.from(getActivity()).areNotificationsEnabled()) {
                com.baidu.tbadk.coreExtra.messageCenter.f.bzH().setSignAlertOn(true);
                com.baidu.tbadk.coreExtra.messageCenter.f.bzH().setSignAlertTime(this.iTR.getHours(), this.iTR.getMinutes());
                if (this.iSV != null) {
                    com.baidu.tbadk.coreExtra.messageCenter.f.bzH().a(getTbPageContext().getPageActivity(), this.iSV.cnn());
                }
            }
            this.iTR = null;
        }
        cCT();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
    }

    public boolean cCv() {
        Intent intent;
        if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
            return false;
        }
        return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
    }

    public void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.iSN = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.iSP = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.iSP) {
                cCw();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCw() {
        this.iSV.startPullRefresh();
    }

    public void closeActivity() {
        com.baidu.tieba.frs.f.l.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.mFrom);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.iSV.setTitle(this.iSN);
        } else {
            this.iSV.setTitle("");
            this.mFlag = 1;
        }
        this.iSV.a(this.iUG);
        this.iSV.addOnScrollListener(this.mScrollListener);
        this.iSV.g(this.iQf);
        this.iSV.cDE().a(this.iUF);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.iTP) {
            this.iSV.onChangeSkinType(i);
            this.iTo.BH(i);
            this.iTp.onChangeSkinType(i);
            if (this.iSX != null) {
                this.iSX.onChangeSkinType(i);
            }
            if (this.iTG != null) {
                this.iTG.onChangeSkinType();
            }
            if (this.iTL != null) {
                this.iTL.onChangeSkinType(getPageContext(), i);
            }
            if (this.ilO != null) {
                com.baidu.tbadk.r.a.a(getPageContext(), this.ilO.getRealView());
            }
            if (this.iTH != null) {
                this.iTH.onChangeSkinType(getPageContext(), i);
            }
        }
    }

    public void zI(int i) {
        if (!this.mIsLogin) {
            if (this.iSt != null && this.iSt.getAnti() != null) {
                this.iSt.getAnti().setIfpost(1);
            }
            if (i == 0) {
                bh.skipToLoginActivity(getActivity());
            }
        } else if (this.iSt != null) {
            if (i == 0) {
                com.baidu.tieba.frs.f.m.g(this, 0);
            } else {
                this.iSV.cDt();
            }
        }
    }

    public void refresh() {
        com.baidu.tieba.a.d.bLT().Fn("page_frs");
        refresh(3);
    }

    public void refresh(int i) {
        this.iTg = false;
        cCE();
        if (this.iSV != null && this.iSV.cDi() != null) {
            this.iSV.cDi().cPh();
        }
        if (this.iTn != null) {
            this.iTn.S(i, true);
        }
    }

    private void cCx() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.f.h.mZ().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.35
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.TV(FrsFragment.this.iSN);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCy() {
        cCE();
        try {
            if (this.iSt != null) {
                this.iSV.bYs();
                this.iSV.pY(cCS());
                if (!com.baidu.tieba.frs.vc.h.n(this.iSt) || !com.baidu.tieba.frs.vc.h.m(this.iSt)) {
                }
                if (this.iSt.getForum() != null) {
                    this.iSN = this.iSt.getForum().getName();
                    this.forumId = this.iSt.getForum().getId();
                }
                if (this.iSt.getPage() != null) {
                    setHasMore(this.iSt.getPage().bnF());
                }
                this.iSV.setTitle(this.iSN);
                this.iSV.setForumName(this.iSN);
                TbadkCoreApplication.getInst().setDefaultBubble(this.iSt.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.iSt.getUserData().getBimg_end_time());
                cCx();
                cCz();
                ArrayList<com.baidu.adp.widget.ListView.q> threadList = this.iSt.getThreadList();
                if (threadList != null) {
                    this.iSV.a(threadList, this.iSt);
                    com.baidu.tieba.frs.f.c.A(this.iSV);
                    this.iTo.BI(getPageNum());
                    this.iTo.j(this.iSt);
                    this.iTp.a(this.iSt, this.iTn.cJi());
                    this.iSV.cDu();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void cCz() {
        if (this.iSt != null) {
            if (this.iSt.getIsNewUrl() == 1) {
                this.iSV.cDE().setFromCDN(true);
            } else {
                this.iSV.cDE().setFromCDN(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.iTq.qR(false);
        this.iTi = false;
        this.iSV.onPause();
        if (this.iSU != null) {
            this.iSU.onPause(getPageContext());
        }
        this.iSV.qf(true);
        if (this.iTw != null) {
            this.iTw.cKi();
        }
        com.baidu.tbadk.BdToken.c.biD().biO();
        if (this.iUa != null) {
            this.iUa.cKd();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.iTp != null && this.iTp.cLm() != null && (this.iTp.cLm().fragment instanceof BaseFragment)) {
            ((BaseFragment) this.iTp.cLm().fragment).setPrimary(z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.t.csg().oX(false);
        pR(false);
        if (this.iSt != null && this.iSt.getForum() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            com.baidu.tbadk.distribute.a.bCa().b(getPageContext().getPageActivity(), "frs", this.iSt.getForum().getId(), 0L);
        }
        if (this.iSU != null) {
            this.iSU.onStop(getPageContext());
        }
        if (bvQ() != null) {
            bvQ().getRecycledViewPool().clear();
        }
        this.iTo.bvb();
        com.baidu.tbadk.util.aa.bGN();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            if (this.iTo != null) {
                this.iTo.cb(isPrimary());
            }
            if (this.iSV != null) {
                this.iSV.cb(isPrimary());
                this.iSV.qf(!isPrimary());
            }
        }
    }

    private void cCA() {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.oT(2);
        aVar.jm(false);
        FrsBroadcastCopyGuideDialogView frsBroadcastCopyGuideDialogView = new FrsBroadcastCopyGuideDialogView(getPageContext().getPageActivity());
        frsBroadcastCopyGuideDialogView.setConfirmButtonListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.36
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aVar != null) {
                    aVar.dismiss();
                    FrsFragment.this.cCB();
                }
            }
        });
        aVar.bi(frsBroadcastCopyGuideDialogView);
        aVar.b(getPageContext()).brv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCB() {
        com.baidu.tbadk.k.d.bDH().a(new com.baidu.tbadk.k.a(getContext()));
        if (com.baidu.tbadk.k.d.bDH().init()) {
            ((BaseFragmentActivity) getPageContext().getOrignalPage()).grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.frs.FrsFragment.37
                @Override // com.baidu.tbadk.core.e
                public void onPermissionResult(boolean z) {
                    if (!z) {
                        new BdTopToast(FrsFragment.this.getContext()).yW(false).Vt(FrsFragment.this.getContext().getString(R.string.forum_broadcast_copy_no_permission_hint)).aF(FrsFragment.this.iSV.cnn());
                        return;
                    }
                    com.baidu.tbadk.k.d.bDH().kH(true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                    if (FrsFragment.this.iSW != null) {
                        FrsFragment.this.iSW.setVisibility(8);
                    }
                }
            }, true);
        }
    }

    private void cCC() {
        com.baidu.tbadk.k.d.bDH().a(new com.baidu.tbadk.k.b(getContext()));
        if (com.baidu.tbadk.k.d.bDH().init()) {
            ((BaseFragmentActivity) getPageContext().getOrignalPage()).grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.frs.FrsFragment.38
                @Override // com.baidu.tbadk.core.e
                public void onPermissionResult(boolean z) {
                    if (z) {
                        com.baidu.tbadk.k.d.bDH().kH(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                        if (FrsFragment.this.iSW != null) {
                            FrsFragment.this.iSW.setVisibility(8);
                        }
                    }
                }
            }, true);
        }
    }

    public void KI(String str) {
        new BdTopToast(getContext(), 3000).yW(true).Vt(str).aF(this.iSV.cnn());
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (b.cBd().cAX()) {
                b.cBd().reset();
                return true;
            } else if (com.baidu.tieba.frs.a.cAW().cAX()) {
                if (this.iSV != null && this.iSV.cDI()) {
                    this.iSV.cDJ();
                    return true;
                }
                com.baidu.tieba.frs.a.cAW().reset();
                return true;
            } else if (this.iSV != null) {
                return this.iSV.cDq();
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
        com.baidu.tbadk.distribute.a.bCa().a(advertAppInfo, this.forumId, 0L, "FRS", str, getPn());
    }

    @Override // com.baidu.tieba.recapp.p
    public void cCD() {
        cBZ().cCD();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.iSU == null) {
            this.iSU = VoiceManager.instance();
        }
        return this.iSU;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdRecyclerView bvQ() {
        if (this.iSV == null) {
            return null;
        }
        return this.iSV.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void cCE() {
        if (this.iSU != null) {
            this.iSU.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> bvR() {
        if (this.few == null) {
            this.few = UserIconBox.D(getPageContext().getPageActivity(), 8);
        }
        return this.few;
    }

    public void cCF() {
        if (getFragmentActivity() != null && getFragmentActivity().getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.t onGetPreLoadListView() {
        return bvQ().getPreLoadHandle();
    }

    @Override // com.baidu.tieba.frs.as
    public NavigationBar bVK() {
        if (this.iSV == null) {
            return null;
        }
        return this.iSV.bVK();
    }

    public FRSRefreshButton cCG() {
        return this.iSX;
    }

    public void c(LinearLayout linearLayout) {
        if (linearLayout != null) {
            this.iSY = linearLayout;
        }
    }

    public void a(FRSRefreshButton fRSRefreshButton) {
        if (fRSRefreshButton != null) {
            this.iSX = fRSRefreshButton;
            this.iSX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.44
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (FrsFragment.this.iTp != null) {
                        FrsTabViewController.b cLm = FrsFragment.this.iTp.cLm();
                        if (cLm != null && cLm.fragment != null && (cLm.fragment instanceof ar)) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                            ((ar) cLm.fragment).cBL();
                            ((ar) cLm.fragment).bSZ();
                            return;
                        }
                        FrsFragment.this.cCe().startPullRefresh();
                    }
                }
            });
        }
    }

    public void cCH() {
        if (this.iSX != null) {
            this.iSX.hide();
        }
    }

    public void cCI() {
        if (this.iSX != null) {
            this.iSX.show();
        }
    }

    /* loaded from: classes22.dex */
    private final class a implements com.baidu.adp.widget.ListView.ab {
        private a() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.ab
        public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null) {
                if (bdUniqueId == v.iWI) {
                    if (FrsFragment.this.iSV != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11752").dY("fid", FrsFragment.this.forumId).dY("obj_locate", "1"));
                        FrsFragment.this.iSV.startPullRefresh();
                    }
                } else if (qVar != null && (qVar instanceof bx)) {
                    by byVar = ((bx) qVar).eCR;
                    if (byVar.bpR() == null || byVar.bpR().getGroup_id() == 0 || bh.checkUpIsLogin(FrsFragment.this.getActivity())) {
                        if (byVar.bpC() != 1 || bh.checkUpIsLogin(FrsFragment.this.getActivity())) {
                            if (byVar.bpb() != null) {
                                if (bh.checkUpIsLogin(FrsFragment.this.getActivity())) {
                                    String postUrl = byVar.bpb().getPostUrl();
                                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.isNetOk()) {
                                        com.baidu.tbadk.browser.a.startInternalWebActivity(FrsFragment.this.getActivity(), postUrl);
                                    }
                                }
                            } else if (byVar.bqc() != null) {
                                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                    bh.skipToLoginActivity(FrsFragment.this.getPageContext().getPageActivity());
                                    return;
                                }
                                com.baidu.tbadk.core.data.s bqc = byVar.bqc();
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), bqc.getCartoonId(), bqc.getChapterId(), 2)));
                            } else {
                                com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                                if (readThreadHistory != null && !readThreadHistory.Ub(byVar.getId())) {
                                    readThreadHistory.Ua(byVar.getId());
                                }
                                boolean z = false;
                                final String boV = byVar.boV();
                                if (boV != null && !boV.equals("")) {
                                    z = true;
                                    new Thread(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.a.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            com.baidu.tbadk.core.util.aa aaVar = new com.baidu.tbadk.core.util.aa(boV);
                                            aaVar.btv().bue().mIsNeedAddCommenParam = false;
                                            aaVar.btv().bue().mIsUseCurrentBDUSS = false;
                                            aaVar.getNetData();
                                        }
                                    }).start();
                                }
                                String tid = byVar.getTid();
                                if (tid == null) {
                                    tid = "";
                                }
                                if (byVar.boK() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                    com.baidu.tbadk.core.util.bf.bua().b(FrsFragment.this.getPageContext(), new String[]{tid, "", null});
                                    return;
                                }
                                if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && tid.length() > 4) {
                                    byVar.setId(tid.substring(3));
                                }
                                if (bdUniqueId.getId() == by.eKU.getId()) {
                                    com.baidu.tieba.frs.f.k.a(byVar.bov());
                                } else if (bdUniqueId.getId() == by.eJv.getId()) {
                                    com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                                    arVar.dY("obj_type", "2");
                                    arVar.dY("tid", byVar.getTid());
                                    TiebaStatic.log(arVar);
                                }
                                com.baidu.tieba.frs.f.l.a(FrsFragment.this, byVar, i, z);
                                com.baidu.tieba.frs.f.k.a(FrsFragment.this, FrsFragment.this.iSt, byVar);
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
            hideNetRefreshView(this.iSV.cDS().cLd());
            showLoadingView(this.iSV.cnn(), true);
            this.iSV.qb(false);
            this.iTn.S(3, true);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData cCJ() {
        return this.iSt;
    }

    public boolean cCK() {
        return this.iSV.cCK();
    }

    public void aJ(Object obj) {
        if (this.iTs != null && this.iTs.jrh != null) {
            this.iTs.jrh.callback(obj);
        }
    }

    public void aK(Object obj) {
        if (this.iTs != null && this.iTs.jri != null) {
            this.iTs.jri.callback(obj);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        this.iSV.getListView().stopScroll();
        if (!this.iSV.cDA()) {
            if (!com.baidu.adp.lib.util.l.isNetOk()) {
                this.iSV.bTa();
            } else if (this.iTn.cJd() == 1) {
                bSb();
                bRM();
            } else if (this.iTn.hasMore()) {
                bRM();
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void onFailed(String str) {
        bSb();
        showToast(str);
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void az(ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        boolean isEmpty = com.baidu.tbadk.core.util.y.isEmpty(arrayList);
        setHasMore(isEmpty ? 0 : 1);
        bSb();
        if (!isEmpty) {
            if (!this.iTn.cJn() && TbadkCoreApplication.getInst().isRecAppExist() && this.iTn.cJd() == 1) {
                this.iSt.addRecommendAppToThreadList(this, arrayList);
            }
            if (this.iTn != null) {
                com.baidu.tieba.frs.d.a.a(getUniqueId(), arrayList, this.iSt.getForum(), this.iTn.getSortType());
            }
            ArrayList<com.baidu.adp.widget.ListView.q> a2 = this.iTy.a(false, false, arrayList, this.iSR, false);
            if (a2 != null) {
                this.iSt.setThreadList(a2);
                this.iSV.a(a2, this.iSt);
            }
            if (this.iTn != null) {
                com.baidu.tieba.frs.d.c.a(this.iSt, this.iTn.cJi(), 2, getContext());
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.iSt.getForum()));
        }
    }

    private void bSb() {
        if (cCf() == 1 || this.iTy.dx(this.iSt.getThreadListIds())) {
            if (com.baidu.tbadk.core.util.y.getCount(this.iSt.getThreadList()) > 3) {
                this.iSV.XZ();
            } else {
                this.iSV.cDG();
            }
        } else if (com.baidu.tbadk.core.util.y.isEmpty(this.iSt.getThreadList())) {
            this.iSV.bTa();
        } else {
            this.iSV.Ya();
        }
    }

    @Override // com.baidu.tieba.frs.mc.l
    public void bRM() {
        if (this.iTy != null) {
            this.iTy.a(this.iSN, this.forumId, this.iSt);
        }
    }

    public void cCL() {
        if (!com.baidu.tbadk.core.util.ae.requestWriteExternalStorgeAndCameraPermission(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.ao.g(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment, com.baidu.n.a.a.InterfaceC0276a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        com.baidu.tieba.frs.f.l.a(this, i, strArr, iArr);
    }

    public void pU(boolean z) {
        if (this.iTt != null) {
            this.iTt.qo(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.iTu.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a ub(int i) {
        return this.iTu.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        this.iTC.b(bVar);
    }

    public boolean cCM() {
        return this.iSJ;
    }

    @Override // com.baidu.tieba.frs.ap
    public void VC() {
        if (this.iSV != null) {
            showFloatingView();
            this.iSV.getListView().scrollToPosition(0);
            this.iSV.startPullRefresh();
        }
    }

    public ForumWriteData cCN() {
        if (this.iSt == null || this.iSt.getForum() == null) {
            return null;
        }
        ForumData forum = this.iSt.getForum();
        ForumWriteData forumWriteData = new ForumWriteData(forum.getId(), forum.getName(), forum.getPrefixData(), this.iSt.getAnti());
        forumWriteData.avatar = forum.getImage_url();
        forumWriteData.forumLevel = forum.getUser_level();
        forumWriteData.specialForumType = forum.special_forum_type;
        forumWriteData.firstDir = forum.getFirst_class();
        forumWriteData.secondDir = forum.getSecond_class();
        UserData userData = this.iSt.getUserData();
        forumWriteData.privateThread = userData != null ? userData.getPrivateThread() : 0;
        forumWriteData.frsTabInfo = cCO();
        return forumWriteData;
    }

    private FrsTabInfoData cCO() {
        int i;
        if (this.iTn == null || this.iSt == null || this.iTp == null) {
            return null;
        }
        if (this.iSt.getEntelechyTabInfo() == null || com.baidu.tbadk.core.util.y.isEmpty(this.iSt.getEntelechyTabInfo().tab)) {
            return null;
        }
        int cLq = this.iTp.cLq();
        if (cLq == 502) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = -1;
        for (FrsTabInfo frsTabInfo : this.iSt.getEntelechyTabInfo().tab) {
            if (frsTabInfo != null && frsTabInfo.is_general_tab.intValue() == 1) {
                if (frsTabInfo.tab_id.intValue() != 505 || this.iSt.getUserData() == null || this.iSt.getUserData().isForumBusinessAccount()) {
                    arrayList.add(new FrsTabItemData(frsTabInfo));
                    if (cLq == frsTabInfo.tab_id.intValue()) {
                        i = cLq;
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
        if (this.iSt.getUserData() != null) {
            frsTabInfoData.isForumBusinessAccount = this.iSt.getUserData().isForumBusinessAccount();
            return frsTabInfoData;
        }
        return frsTabInfoData;
    }

    @Override // com.baidu.tieba.frs.ap
    public void bvt() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void pV(boolean z) {
        this.iTj = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z) {
        this.iSV.zQ(8);
        ((FrsActivity) getActivity()).showLoadingView(view, z);
        ((FrsActivity) getActivity()).k(view, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        this.iSV.zQ(0);
        ((FrsActivity) getActivity()).hideLoadingView(view);
        ((FrsActivity) getActivity()).k(view, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        super.showNetRefreshView(view, getResources().getString(R.string.refresh_view_title_text), null, getResources().getString(R.string.refresh_view_button_text), z, getNetRefreshListener());
        this.iSV.zQ(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshViewNoClick(View view, String str, boolean z) {
        super.showNetRefreshViewNoClick(view, str, z);
        this.iSV.zQ(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        super.hideNetRefreshView(view);
        this.iSV.zQ(0);
    }

    public void cCP() {
        FrsTabViewController.b cLm;
        if (this.iTp != null && (cLm = this.iTp.cLm()) != null && cLm.fragment != null && (cLm.fragment instanceof ar)) {
            ((ar) cLm.fragment).cBL();
        }
    }

    public void pW(boolean z) {
        this.iSL = z;
    }

    public void b(OvalActionButton ovalActionButton) {
        this.iSW = ovalActionButton;
    }

    public OvalActionButton cCQ() {
        return this.iSW;
    }

    public boolean cCR() {
        return this.iSL;
    }

    public void onShareSuccess(String str) {
        if (TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.util.au.isEmpty(str)) {
            if (this.iTN == null) {
                this.iTN = new AddExperiencedModel(getTbPageContext());
            }
            this.iTN.gn(this.forumId, str);
        }
    }

    public boolean cCS() {
        if (this.iTj && !this.iTQ) {
            return (this.iTn != null && this.iTn.cJe() && (b.cBd().cAX() || com.baidu.tieba.frs.a.cAW().cAX())) ? false : true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.f.b
    public boolean videoNeedPreload() {
        if (this.iSt != null) {
            return com.baidu.tbadk.util.ai.sW(2) || (com.baidu.tbadk.util.ai.bGV() && this.iSt.isFrsVideoAutoPlay);
        }
        return super.videoNeedPreload();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCT() {
        if (!com.baidu.tbadk.core.util.au.isEmpty(this.forumId)) {
            com.baidu.tbadk.BdToken.c.biD().q(com.baidu.tbadk.BdToken.b.evw, com.baidu.adp.lib.f.b.toLong(this.forumId, 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCU() {
        String format;
        String str;
        if (isResumed() && this.iTU != null && this.iTU.size() >= 1 && this.iTT <= this.iTU.size() - 1) {
            final LiveHorseRaceData liveHorseRaceData = this.iTU.get(this.iTT);
            if (System.currentTimeMillis() / 1000 >= liveHorseRaceData.getRob_end_tm().longValue()) {
                this.iTT++;
                cCU();
            }
            if (this.iSY != null) {
                final FrsRedpackRunView frsRedpackRunView = new FrsRedpackRunView(getActivity());
                if (liveHorseRaceData.getUser_nickname() == null || TextUtils.isEmpty(liveHorseRaceData.getUser_nickname())) {
                    format = String.format(getResources().getString(R.string.live_horserace_red_envelope), getResources().getString(R.string.frs_horse_none_title_verser));
                } else if (liveHorseRaceData.getUser_nickname().length() > 4) {
                    format = String.format(getResources().getString(R.string.live_horserace_red_envelope), liveHorseRaceData.getUser_nickname().substring(0, 4) + StringHelper.STRING_MORE);
                } else {
                    format = String.format(getResources().getString(R.string.live_horserace_red_envelope), liveHorseRaceData.getUser_nickname());
                }
                frsRedpackRunView.settextTitle(format + format + format);
                frsRedpackRunView.setClickliner(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.51
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        String str2;
                        if (FrsFragment.this.iSt == null) {
                            str2 = "";
                        } else if (FrsFragment.this.iSt.getForum() != null) {
                            str2 = FrsFragment.this.iSt.getForum().getName();
                        } else {
                            str2 = "";
                        }
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13744").al("obj_source", 1).dY("fid", FrsFragment.this.forumId).dY("fname", str2));
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
                this.iTV = ValueAnimator.ofFloat(1.0f, 0.0f);
                this.iTV.setDuration(600L);
                this.iTV.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.FrsFragment.52
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        if (valueAnimator.isRunning()) {
                            frsRedpackRunView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                            frsRedpackRunView.setTranslationX(-(TbadkApplication.getInst().getContext().getResources().getDimensionPixelOffset(R.dimen.tbds850) * valueAnimator.getAnimatedFraction()));
                        }
                    }
                });
                this.iTV.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.FrsFragment.53
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        frsRedpackRunView.setAlpha(0.0f);
                        frsRedpackRunView.setTranslationY(TbadkApplication.getInst().getContext().getResources().getDimensionPixelOffset(R.dimen.tbds660));
                        frsRedpackRunView.hide();
                        FrsFragment.this.iSY.removeView(frsRedpackRunView);
                        if (FrsFragment.this.iTU == null || FrsFragment.this.iTT <= FrsFragment.this.iTU.size() - 1) {
                            FrsFragment.this.cCU();
                            return;
                        }
                        FrsFragment.this.iSY.removeAllViews();
                        FrsFragment.this.iSY.setVisibility(8);
                        FrsFragment.this.iTT = 0;
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        onAnimationEnd(animator);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                this.iTW = new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.54
                    @Override // java.lang.Runnable
                    public void run() {
                        if (FrsFragment.this.iSY != null && frsRedpackRunView != null) {
                            FrsFragment.this.iTV.start();
                        }
                    }
                };
                com.baidu.adp.lib.f.e.mY().postDelayed(this.iTW, 5000L);
                if (this.iSY.getChildCount() == 0) {
                    this.iTT++;
                    this.iSY.addView(frsRedpackRunView);
                    if (this.iSt != null) {
                        str = this.iSt.getForum() != null ? this.iSt.getForum().getName() : "";
                    } else {
                        str = "";
                    }
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13743").al("obj_source", 1).dY("fid", this.forumId).dY("fname", str));
                }
                if (this.iSY.getVisibility() == 8 && ((BaseFragment) this.iTp.cLm().fragment).isPrimary() && !this.iSV.cDP() && !this.iTe) {
                    this.iSY.setVisibility(0);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        FrsTabViewController.b cLm;
        if (cCc() == null || (cLm = cCc().cLm()) == null || !(cLm.fragment instanceof BaseFragment)) {
            return null;
        }
        if (cLm.fragment instanceof FrsAllThreadFragment) {
            TbPageTag tbPageTag = super.getTbPageTag();
            int i = -1;
            if (this.iSt != null) {
                i = this.iSt.getSortType();
            }
            tbPageTag.sortType = com.baidu.tieba.frs.f.j.BF(i);
            tbPageTag.locatePage = "a070";
            if (this.iSG.equals(cLm.title)) {
                tbPageTag.locatePage = "a071";
            }
            return tbPageTag;
        } else if (cLm.fragment instanceof FrsFragment) {
            return null;
        } else {
            return ((BaseFragment) cLm.fragment).getTbPageTag();
        }
    }

    public void cCV() {
        if (this.iSt != null) {
            com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
            if (this.iSt.needLog == 1) {
                bVar.jtP = true;
            } else {
                bVar.jtP = false;
            }
            if (this.iSt.getForum() != null) {
                bVar.jtR = this.iSt.getForum().getId();
            }
            if (cBZ() != null) {
                bVar.jtQ = cBZ().cJi();
            }
            if (com.baidu.tieba.frs.d.d.jcS != null) {
                bVar.jtS = com.baidu.tieba.frs.d.d.jcS.jtS;
                bVar.jtT = com.baidu.tieba.frs.d.d.jcS.jtT;
            }
            this.iTX = new com.baidu.tieba.frs.live.b(bVar, getTbPageTag(), getUniqueId());
            this.iTX.Bi(this.iTZ);
            CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_CARD_CLICK, this.iTX);
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
            CustomMessageTask customMessageTask2 = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW, this.iTX);
            customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask2);
            CustomMessageTask customMessageTask3 = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_USER_CLICK, this.iTX);
            customMessageTask3.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask3);
            CustomMessageTask customMessageTask4 = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_VIDEO_CLICK, this.iTX);
            customMessageTask4.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask4);
        }
    }

    public void aF(String str, String str2, String str3) {
        this.iUa = new com.baidu.tieba.frs.f.e(str, str2);
        this.iUa.c(getFragmentActivity(), str3, str2);
    }
}
