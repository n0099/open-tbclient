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
import com.baidu.m.a.a;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.baidu.tbadk.BdToken.f;
import com.baidu.tbadk.KuangFloatingFrsCopyLinkViewController;
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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ax;
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
/* loaded from: classes16.dex */
public class FrsFragment extends BaseFragment implements BdListView.e, a.InterfaceC0210a, UserIconBox.b<BdRecyclerView>, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, aq, at, aw, com.baidu.tieba.frs.loadmore.a, com.baidu.tieba.frs.mc.l, com.baidu.tieba.recapp.n {
    public static com.baidu.tieba.tbadkCore.m hST;
    private com.baidu.tbadk.util.z eVC;
    private com.baidu.adp.lib.d.b<TbImageView> evp;
    private com.baidu.tieba.frs.gametab.b fXJ;
    private com.baidu.tieba.frs.entelechy.a hSB;
    private com.baidu.tieba.tbadkCore.data.f hSL;
    private VoiceManager hSO;
    private OvalActionButton hSQ;
    private FRSRefreshButton hSR;
    private LinearLayout hSS;
    public long hSU;
    private View.OnTouchListener hTA;
    private com.baidu.tieba.frs.view.a hTB;
    private com.baidu.tieba.frs.vc.e hTC;
    private boolean hTD;
    private com.baidu.tieba.NEGFeedBack.a hTE;
    private com.baidu.tieba.ala.a hTF;
    private com.baidu.tieba.frs.brand.buttommenu.a hTG;
    private com.baidu.tieba.frs.sportspage.notification.a hTH;
    private AddExperiencedModel hTI;
    private boolean hTK;
    private List<LiveHorseRaceData> hTP;
    private ValueAnimator hTQ;
    private Runnable hTR;
    private com.baidu.tieba.frs.live.b hTS;
    private com.baidu.tieba.frs.broadcast.a hTT;
    private int hTU;
    private String hTf;
    private com.baidu.card.al hTh;
    private FrsModelController hTi;
    private com.baidu.tieba.frs.vc.h hTj;
    private FrsTabViewController hTk;
    private com.baidu.tieba.frs.mc.h hTl;
    private com.baidu.tieba.frs.smartsort.a hTm;
    private com.baidu.tieba.frs.mc.b hTn;
    private ax hTo;
    private com.baidu.tieba.frs.entelechy.b.b hTq;
    private com.baidu.tieba.frs.vc.a hTr;
    private com.baidu.tieba.frs.mc.d hTs;
    private com.baidu.tieba.frs.mc.c hTt;
    private com.baidu.tieba.frs.vc.j hTu;
    private com.baidu.tieba.frs.mc.a hTv;
    private com.baidu.tieba.frs.live.a hTw;
    private p hTx;
    public com.baidu.tieba.frs.vc.c hTy;
    private com.baidu.tieba.frs.mc.e hTz;
    private int hUe;
    private com.baidu.tbadk.core.dialog.a hlV;
    private View mRootView;
    private String mSchemeUrl;
    public static boolean hSG = false;
    public static volatile long hSW = 0;
    public static volatile long hSX = 0;
    public static volatile int mNetError = 0;
    private String hSA = "";
    public boolean hSC = false;
    private boolean hSD = false;
    private boolean hSE = false;
    private boolean hSF = true;
    public String hSH = null;
    public String mFrom = null;
    public int mFlag = 0;
    public boolean hSI = false;
    private boolean hSJ = false;
    private String mThreadId = null;
    public String forumId = null;
    private int hSp = 0;
    private boolean hSK = false;
    private boolean hSM = false;
    private boolean hSN = false;
    private q hSP = null;
    public final bw ajx = null;
    private FrsViewData hSn = new FrsViewData();
    public long hvn = -1;
    public long eRT = 0;
    public long eRJ = 0;
    public long createTime = 0;
    public long eRK = 0;
    public long eRQ = 0;
    public long hSV = 0;
    boolean hSY = false;
    public boolean hSZ = false;
    private boolean hTa = false;
    private boolean hTb = false;
    public com.baidu.tbadk.n.b hTc = null;
    private boolean hTd = true;
    private boolean hTe = true;
    private a.C0095a hTg = new a.C0095a(2);
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> hTp = new SparseArray<>();
    private boolean fGI = true;
    private boolean hasInit = false;
    private boolean hTJ = false;
    private boolean hTL = false;
    private Date hTM = null;
    private int dhe = 0;
    private int hTN = 0;
    private int hTO = 0;
    public int mHeadLineDefaultNavTabId = -1;
    MessageQueue.IdleHandler hTV = new MessageQueue.IdleHandler() { // from class: com.baidu.tieba.frs.FrsFragment.1
        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            FrsFragment.this.cmg();
            return false;
        }
    };
    private final CustomMessageListener hTW = new CustomMessageListener(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED) { // from class: com.baidu.tieba.frs.FrsFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof bw) {
                    com.baidu.tieba.frs.f.h.a(FrsFragment.this.hSP, FrsFragment.this.hSn, FrsFragment.this.getForumId(), true, (bw) data);
                }
            }
        }
    };
    private CustomMessageListener hTX = new CustomMessageListener(CmdConfigCustom.CMD_CLOSE_GAME_RANK_CARD) { // from class: com.baidu.tieba.frs.FrsFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.hSn != null) {
                FrsFragment.this.hSn.removeGameRankListFromThreadList();
                if (FrsFragment.this.hSP != null) {
                    FrsFragment.this.hSP.aSD();
                }
            }
        }
    };
    private CustomMessageListener afN = new CustomMessageListener(2921401) { // from class: com.baidu.tieba.frs.FrsFragment.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && FrsFragment.this.hSR != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() <= 0 || FrsFragment.this.hTk.ctW() == 0 || FrsFragment.this.hTk.ctT() == null || !(FrsFragment.this.hTk.ctT().fragment instanceof BaseFragment) || !((BaseFragment) FrsFragment.this.hTk.ctT().fragment).isPrimary() || FrsFragment.this.hSP.cnD() || KuangFloatingFrsCopyLinkViewController.getInstance().isFloatCopyViewShow()) {
                    if (FrsFragment.this.hTk.ctW() != 0) {
                        FrsFragment.this.hSR.hide();
                        return;
                    }
                    return;
                }
                FrsFragment.this.hSR.show();
            }
        }
    };
    private CustomMessageListener hTY = new CustomMessageListener(2921473) { // from class: com.baidu.tieba.frs.FrsFragment.45
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && FrsFragment.this.hSR != null && FrsFragment.this.hSQ != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() == 0) {
                    FrsFragment.this.hSR.setVisibility(8);
                    FrsFragment.this.hSQ.setVisibility(8);
                    return;
                }
                FrsFragment.this.hSQ.setVisibility(0);
            }
        }
    };
    private CustomMessageListener hTZ = new CustomMessageListener(2921467) { // from class: com.baidu.tieba.frs.FrsFragment.56
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && FrsFragment.this.hSR != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() <= 0 || FrsFragment.this.hTk.ctT() == null || !(FrsFragment.this.hTk.ctT().fragment instanceof BaseFragment) || !((BaseFragment) FrsFragment.this.hTk.ctT().fragment).isPrimary() || FrsFragment.this.hSP.cnD()) {
                    FrsFragment.this.hSS.setVisibility(8);
                    FrsFragment.this.hSY = true;
                    return;
                }
                FrsFragment.this.hSS.setVisibility(0);
                FrsFragment.this.hSY = false;
            }
        }
    };
    private com.baidu.adp.framework.listener.a hUa = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_FRS_LIVE_HORSE_RACE_LIST, 309667) { // from class: com.baidu.tieba.frs.FrsFragment.61
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if ((responsedMessage instanceof GetLiveHorseRaceHttpResponseMessage) || (responsedMessage instanceof GetLiveHorseRaceSocketResponseMessage)) {
                    List<LiveHorseRaceData> arrayList = new ArrayList<>();
                    if (responsedMessage instanceof GetLiveHorseRaceHttpResponseMessage) {
                        arrayList = ((GetLiveHorseRaceHttpResponseMessage) responsedMessage).getData().cod();
                    }
                    if (responsedMessage instanceof GetLiveHorseRaceSocketResponseMessage) {
                        arrayList = ((GetLiveHorseRaceSocketResponseMessage) responsedMessage).getData().cod();
                    }
                    if (FrsFragment.this.hTP != null) {
                        if (FrsFragment.this.hSS.getVisibility() != 8) {
                            if (FrsFragment.this.hTO >= FrsFragment.this.hTP.size()) {
                                FrsFragment.this.hTP.addAll(arrayList);
                                return;
                            }
                            FrsFragment.this.hTP = FrsFragment.this.hTP.subList(0, FrsFragment.this.hTO);
                            FrsFragment.this.hTP.addAll(arrayList);
                            return;
                        }
                        FrsFragment.this.hTP = new ArrayList();
                        FrsFragment.this.hTP.addAll(arrayList);
                        FrsFragment.this.hTO = 0;
                        FrsFragment.this.cmH();
                        return;
                    }
                    FrsFragment.this.hTP = new ArrayList();
                    FrsFragment.this.hTO = 0;
                    FrsFragment.this.hTP.addAll(arrayList);
                    FrsFragment.this.cmH();
                }
            }
        }
    };
    private CustomMessageListener hUb = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.FrsFragment.62
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 1) {
                    FrsFragment.this.cmk();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                }
            }
        }
    };
    private final av hUc = new av() { // from class: com.baidu.tieba.frs.FrsFragment.63
        @Override // com.baidu.tieba.frs.av
        public void a(int i, int i2, bd bdVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
            FrsFragment.this.clV();
            if (FrsFragment.this.hTq != null) {
                FrsFragment.this.hTj.pg(FrsFragment.this.hTq.xI(i));
            }
            com.baidu.tieba.tbadkCore.f fVar = new com.baidu.tieba.tbadkCore.f();
            if (bdVar != null) {
                fVar.isSuccess = bdVar.errCode == 0;
                fVar.errorCode = bdVar.errCode;
                fVar.errorMsg = bdVar.errMsg;
                if (fVar.isSuccess) {
                    if (com.baidu.tbadk.core.util.y.isEmpty(arrayList)) {
                        FrsFragment.this.hSP.bGT();
                    } else if (bdVar.hasMore) {
                        if (com.baidu.tbadk.core.util.y.getCount(FrsFragment.this.hSn.getThreadList()) > 3) {
                            FrsFragment.this.hSP.bGR();
                        } else {
                            FrsFragment.this.hSP.cnu();
                        }
                    } else if (bdVar.hXO) {
                        FrsFragment.this.hSP.bGS();
                    } else {
                        FrsFragment.this.hSP.bGT();
                    }
                }
            } else {
                bdVar = new bd();
                bdVar.pn = 1;
                bdVar.hasMore = false;
                bdVar.hXO = false;
            }
            if (i == 1) {
                FrsFragment.this.hTd = true;
                FrsFragment.this.hUt.a(FrsFragment.this.hTi.getType(), false, fVar);
            } else {
                FrsFragment.this.a(fVar);
                if (FrsFragment.this.hTi.crs() != null) {
                    FrsFragment.this.hSn = FrsFragment.this.hTi.crs();
                }
                FrsFragment.this.cmm();
            }
            if (FrsFragment.this.hUB != null) {
                FrsFragment.this.hUB.a(i, i2, bdVar, arrayList);
            }
        }
    };
    private FrsTabViewController.a hUd = new FrsTabViewController.a() { // from class: com.baidu.tieba.frs.FrsFragment.2
        @Override // com.baidu.tieba.frs.vc.FrsTabViewController.a
        public void ce(int i, int i2) {
            boolean z = false;
            if (i != 1) {
                com.baidu.tieba.card.s.cbX().nk(false);
                FrsFragment.this.od(false);
            }
            if (i == 502) {
                FrsFragment.this.hSQ.setIconFade(R.drawable.btn_frs_professional_edit_n);
            } else {
                FrsFragment.this.hSQ.setIconFade(0);
            }
            FrsFragment.this.hUe = i;
            FrsFragment.this.hTU = i2;
            if (FrsFragment.this.hTS != null) {
                FrsFragment.this.hTS.yl(FrsFragment.this.hTU);
            }
            TbSingleton.getInstance().setFrsCurTabType(FrsFragment.this.hTU);
            FrsFragment.this.cmr();
            com.baidu.tieba.frs.d.d.icL.iqW = i;
            com.baidu.tieba.frs.d.d.icL.iqZ = i2;
            com.baidu.tieba.frs.d.d.icL.iqX = -1;
            b.ckS().R(i == 1 && FrsFragment.this.hTJ, true);
            com.baidu.tieba.frs.a ckL = com.baidu.tieba.frs.a.ckL();
            if (i == 1 && FrsFragment.this.hTJ) {
                z = true;
            }
            ckL.R(z, true);
        }
    };
    private CustomMessageListener hUf = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIVE_COUNT) { // from class: com.baidu.tieba.frs.FrsFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                FrsFragment.this.hTk.yW(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    };
    private CustomMessageListener hUg = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_LIVE_START) { // from class: com.baidu.tieba.frs.FrsFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && ((Integer) customResponsedMessage.getData()).intValue() == 51 && FrsFragment.this.hSn != null) {
                com.baidu.tieba.frs.f.j.a(FrsFragment.this.hSn, FrsFragment.this.getPageContext());
            }
        }
    };
    private final CustomMessageListener hUh = new CustomMessageListener(CmdConfigCustom.CMD_FRS_SELECT_ALA_LIVE_TAB) { // from class: com.baidu.tieba.frs.FrsFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                FrsFragment.this.hTk.yU(49);
            }
        }
    };
    private final CustomMessageListener hUi = new CustomMessageListener(2921470) { // from class: com.baidu.tieba.frs.FrsFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                FrsFragment.this.hTk.yU(1);
                FrsFragment.this.cmk();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
            }
        }
    };
    private final CustomMessageListener hUj = new CustomMessageListener(CmdConfigCustom.CMD_FRS_EXPERIENCE_TIP) { // from class: com.baidu.tieba.frs.FrsFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.v) && FrsFragment.this.hSn != null) {
                FrsFragment.this.hSn.updateLikeData((com.baidu.tieba.tbadkCore.v) customResponsedMessage.getData());
                FrsFragment.this.hTj.i(FrsFragment.this.hSn);
                FrsFragment.this.hTk.a(FrsFragment.this.hSn, FrsFragment.this.hTi.crW());
            }
        }
    };
    private final AntiHelper.a hUk = new AntiHelper.a() { // from class: com.baidu.tieba.frs.FrsFragment.8
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ai("obj_locate", ax.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ai("obj_locate", ax.a.LOCATE_LIKE_PERSON));
        }
    };
    private CustomMessageListener hUl = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.FrsFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(FrsFragment.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().eCa != null) {
                        if (AntiHelper.a(FrsFragment.this.getActivity(), updateAttentionMessage.getData().eCa, FrsFragment.this.hUk) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ai("obj_locate", ax.a.LOCATE_LIKE_PERSON));
                        }
                    } else if (updateAttentionMessage.getData().isSucc && updateAttentionMessage.getData().isAttention) {
                        com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getPageContext().getPageActivity(), R.string.attention_success);
                    }
                }
            }
        }
    };
    private CustomMessageListener hUm = new CustomMessageListener(CmdConfigCustom.CMD_GET_ENSURE_CAST_ID) { // from class: com.baidu.tieba.frs.FrsFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsFragment.this.refresh();
        }
    };
    private CustomMessageListener hUn = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.frs.FrsFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && !((PostWriteCallBackData) customResponsedMessage.getData()).isDyamicCallback()) {
                FrsFragment.this.hSP.c((PostWriteCallBackData) customResponsedMessage.getData());
                if (((PostWriteCallBackData) customResponsedMessage.getData()).getGeneralTabId() >= 0) {
                    FrsFragment.this.hTv.yn(((PostWriteCallBackData) customResponsedMessage.getData()).getGeneralTabId());
                }
            }
        }
    };
    private CustomMessageListener hUo = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_REMIND) { // from class: com.baidu.tieba.frs.FrsFragment.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626) {
                NewsRemindMessage newsRemindMessage = (NewsRemindMessage) customResponsedMessage;
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (FrsFragment.this.hSP != null) {
                    FrsFragment.this.hSP.N(notificationCount, z);
                }
            }
        }
    };
    private HttpMessageListener hUp = new HttpMessageListener(CmdConfigHttp.CMD_FRS_MOVE_AREA) { // from class: com.baidu.tieba.frs.FrsFragment.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int i;
            int i2 = 0;
            if (httpResponsedMessage != null && FrsFragment.this.getContext() != null && FrsFragment.this.hSP != null) {
                if (httpResponsedMessage.getError() == 0) {
                    new BdTopToast(FrsFragment.this.getContext()).wS(true).Sp(FrsFragment.this.getContext().getString(R.string.frs_move_area_move_suc)).aE(FrsFragment.this.hSP.bZb());
                    if (com.baidu.tieba.frs.a.ckL().wO(com.baidu.tieba.frs.a.ckL().ckN())) {
                        FrsCommonTabFragment frsCommonTabFragment = null;
                        if (FrsFragment.this.hTk != null && FrsFragment.this.hTk.ctT() != null && (FrsFragment.this.hTk.ctT().fragment instanceof FrsCommonTabFragment)) {
                            frsCommonTabFragment = (FrsCommonTabFragment) FrsFragment.this.hTk.ctT().fragment;
                        }
                        if (frsCommonTabFragment != null) {
                            frsCommonTabFragment.coY();
                        }
                        FrsFragment.this.ckQ();
                        com.baidu.tieba.frs.a.ckL().ckQ();
                        Iterator<com.baidu.adp.widget.ListView.q> it = FrsFragment.this.hSn.getThreadList().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                i = i2;
                                break;
                            }
                            i = it.next() instanceof bv ? i2 + 1 : i2;
                            if (i >= 6) {
                                break;
                            }
                            i2 = i;
                        }
                        if (i < 6) {
                            FrsFragment.this.bFD();
                        }
                    }
                    com.baidu.tieba.frs.a.ckL().reset();
                    return;
                }
                new BdTopToast(FrsFragment.this.getContext()).wS(false).Sp(httpResponsedMessage.getErrorString()).aE(FrsFragment.this.hSP.bZb());
            }
        }
    };
    private final CustomMessageListener hUq = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.frs.FrsFragment.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.isResumed()) {
                FrsFragment.this.cmG();
            }
        }
    };
    private CustomMessageListener hUr = new CustomMessageListener(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER) { // from class: com.baidu.tieba.frs.FrsFragment.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (FrsFragment.this.hSP != null) {
                    FrsFragment.this.hSP.setExpanded(booleanValue);
                }
            }
        }
    };
    private final CustomMessageListener hUs = new CustomMessageListener(2921463) { // from class: com.baidu.tieba.frs.FrsFragment.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TbadkApplication.getInst().getCurrentActivity() != null && !com.baidu.tbadk.core.util.at.isEmpty(str) && str.equals(FrsFragment.this.forumId)) {
                    com.baidu.tieba.frs.f.e.b(((TbPageContextSupport) TbadkApplication.getInst().getCurrentActivity()).getPageContext(), FrsFragment.this.hSn);
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.r hUt = new com.baidu.tieba.tbadkCore.r() { // from class: com.baidu.tieba.frs.FrsFragment.18
        private long startTime = 0;

        @Override // com.baidu.tieba.tbadkCore.r
        public void wV(int i) {
            this.startTime = System.nanoTime();
            if (FrsFragment.this.hSP != null) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsFragment.this.hSP.cne();
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

        @Override // com.baidu.tieba.tbadkCore.r
        public void a(int i, boolean z, com.baidu.tieba.tbadkCore.f fVar) {
            if (FrsFragment.this.fGI) {
                FrsFragment.this.fGI = false;
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.hSP, FrsFragment.this.hSn, FrsFragment.this.getForumId(), false, null);
            }
            FrsFragment.this.clV();
            FrsFragment.this.hTa = true;
            if (fVar != null && fVar.isSuccess) {
                FrsFragment.this.hSP.cnr().oN(com.baidu.tbadk.core.util.au.bjr().bjs());
                FrsFragment.hSW = 0L;
                FrsFragment.hSX = 0L;
                FrsFragment.mNetError = 0;
            } else {
                FrsFragment.mNetError = 1;
            }
            if (!FrsFragment.this.hTi.csb() && (i == 3 || i == 6)) {
                FrsFragment.this.hTt.resetData();
            }
            FrsFragment.this.hSU = System.currentTimeMillis();
            if (FrsFragment.this.hTi.crs() != null) {
                FrsFragment.this.hSn = FrsFragment.this.hTi.crs();
            }
            FrsFragment.this.wR(1);
            FrsFragment.this.cmd();
            if (i == 7) {
                FrsFragment.this.wS(FrsFragment.this.hSn.getFrsDefaultTabId());
                return;
            }
            if (FrsFragment.this.hSn.getPage() != null) {
                FrsFragment.this.setHasMore(FrsFragment.this.hSn.getPage().bdu());
            }
            if (i == 4) {
                if (!FrsFragment.this.hTi.csb() && TbadkCoreApplication.getInst().isRecAppExist() && FrsFragment.this.hTi.crR() == 1) {
                    FrsFragment.this.hSn.addRecommendAppToThreadList(FrsFragment.this);
                }
                ArrayList<com.baidu.adp.widget.ListView.q> a2 = FrsFragment.this.hTt.a(false, false, FrsFragment.this.hSn.getThreadList(), FrsFragment.this.hSL, false);
                if (a2 != null) {
                    FrsFragment.this.hSn.setThreadList(a2);
                    FrsFragment.this.hSn.checkLiveStageInThreadList();
                }
                if (FrsFragment.this.hTi != null) {
                    com.baidu.tieba.frs.d.c.a(FrsFragment.this.hSn, FrsFragment.this.hTi.crW(), 2, FrsFragment.this.getContext());
                }
                com.baidu.tieba.frs.f.a.a(FrsFragment.this, FrsFragment.this.hSn.getForum(), FrsFragment.this.hSn.getThreadList(), false, FrsFragment.this.getPn());
                FrsFragment.this.hSP.a(a2, FrsFragment.this.hSn);
                FrsFragment.this.clW();
                return;
            }
            FrsFragment.this.clW();
            switch (i) {
                case 1:
                    FrsFragment.this.hSP.cne();
                    break;
                case 2:
                    FrsFragment.this.hSP.cne();
                    break;
                case 3:
                case 6:
                    if (FrsFragment.this.hSn != null) {
                        FrsFragment.this.hSn.clearPostThreadCount();
                    }
                    if (FrsFragment.this.hTy != null) {
                        FrsFragment.this.hTy.refresh();
                        break;
                    }
                    break;
            }
            FrsFragment.this.cme();
            if (fVar == null || fVar.errorCode == 0) {
                if (FrsFragment.this.hSn != null) {
                    FrsFragment.this.a(FrsFragment.this.hSn);
                    FrsFragment.this.T(false, i == 5);
                    if (FrsFragment.this.hTi != null) {
                        if (FrsFragment.this.hSn.getActivityHeadData() != null && FrsFragment.this.hSn.getActivityHeadData().bcI() != null && FrsFragment.this.hSn.getActivityHeadData().bcI().size() > 0) {
                            com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), 1, FrsFragment.this.hSn.getForum(), FrsFragment.this.hTi.getSortType(), 1);
                        }
                        if (FrsFragment.this.hSn.getThreadList() != null && FrsFragment.this.hSn.getThreadList().size() > 0) {
                            Iterator<com.baidu.adp.widget.ListView.q> it = FrsFragment.this.hSn.getThreadList().iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    com.baidu.adp.widget.ListView.q next = it.next();
                                    if ((next instanceof bw) && ((bw) next).getType() == bw.ecR) {
                                        com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), 1, FrsFragment.this.hSn.getForum(), FrsFragment.this.hTi.getSortType(), 2);
                                    }
                                }
                            }
                        }
                        com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), FrsFragment.this.hSn.getThreadList(), FrsFragment.this.hSn.getForum(), FrsFragment.this.hTi.getSortType());
                    }
                    FrsFragment.this.hSP.xi(i);
                    FrsFragment.hSW = (System.nanoTime() - this.startTime) / TimeUtils.NANOS_PER_MS;
                    if (fVar != null) {
                        FrsFragment.hSX = fVar.mcA;
                    }
                } else {
                    return;
                }
            } else if (FrsFragment.this.hSn == null || com.baidu.tbadk.core.util.y.isEmpty(FrsFragment.this.hSn.getThreadList())) {
                FrsFragment.this.a(fVar);
            } else if (fVar.hCM) {
                FrsFragment.this.showToast(FrsFragment.this.getPageContext().getResources().getString(R.string.net_error_text, fVar.errorMsg, Integer.valueOf(fVar.errorCode)));
            }
            FrsFragment.this.cma();
            FrsFragment.this.cmb();
            if (FrsFragment.this.hSn.getAccessFlag() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11384"));
            }
            if (FrsFragment.this.hSM && FrsFragment.this.hTk.yU(49)) {
                FrsFragment.this.hSM = false;
            }
            FrsFragment.this.b(FrsFragment.this.hSn.getForum());
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.r
        public void c(com.baidu.tieba.tbadkCore.m mVar) {
            if ((mVar != null && ("normal_page".equals(FrsFragment.this.hTi.getPageType()) || "frs_page".equals(FrsFragment.this.hTi.getPageType()) || "book_page".equals(FrsFragment.this.hTi.getPageType()))) || "brand_page".equals(FrsFragment.this.hTi.getPageType())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE, mVar));
                FrsFragment.this.b(mVar);
                FrsFragment.hST = mVar;
            }
        }

        @Override // com.baidu.tieba.tbadkCore.r
        public void cmg() {
            FrsFragment.this.cmg();
        }
    };
    private final CustomMessageListener hUu = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.frs.FrsFragment.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                FrsFragment.this.hSn.updateCurrentUserPendant((com.baidu.tbadk.data.l) customResponsedMessage.getData());
                FrsFragment.this.hSP.cnr().notifyDataSetChanged();
            }
        }
    };
    private final CustomMessageListener mMemListener = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_MEM) { // from class: com.baidu.tieba.frs.FrsFragment.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && FrsFragment.this.hSn != null && (userData = FrsFragment.this.hSn.getUserData()) != null) {
                userData.setIsMem(num.intValue());
                if (num.intValue() != 0) {
                    FrsFragment.this.hTj.m(num);
                }
            }
        }
    };
    private final f.a hUv = new AnonymousClass30();
    private final com.baidu.tieba.frs.mc.k hUw = new com.baidu.tieba.frs.mc.k() { // from class: com.baidu.tieba.frs.FrsFragment.31
        @Override // com.baidu.tieba.frs.mc.k
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, boolean z3) {
            if (FrsFragment.this.hTm != null && FrsFragment.this.hTi != null && FrsFragment.this.hTi.csb() && z && !z2 && !z3) {
                FrsFragment.this.hTm.ys(i2);
            }
        }
    };
    public final View.OnTouchListener eVD = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.FrsFragment.32
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (FrsFragment.this.hTA != null) {
                FrsFragment.this.hTA.onTouch(view, motionEvent);
            }
            if (FrsFragment.this.hTo != null && FrsFragment.this.hTo.coe() != null) {
                FrsFragment.this.hTo.coe().onTouchEvent(motionEvent);
            }
            if (FrsFragment.this.fXJ != null) {
                FrsFragment.this.fXJ.b(view, motionEvent);
            }
            if (FrsFragment.this.hTj != null) {
                FrsFragment.this.hTj.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private final CustomMessageListener hUx = new CustomMessageListener(CmdConfigCustom.CMD_GOTOLIVE_HOST_UPGRADE) { // from class: com.baidu.tieba.frs.FrsFragment.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.bik().getInt(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.PHOTOLIVE_HOSTLEVEL, -1) != -1 && FrsFragment.this.hSn.getForum() != null) {
                FrsFragment.this.hSn.getForum().setCanAddPhotoLivePost(true);
            }
        }
    };
    public final View.OnClickListener hUy = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.39
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsFragment.this.hSP != null && view == FrsFragment.this.hSP.cnc() && FrsFragment.this.getActivity() != null) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, FrsFragment.this.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            if (view.getId() == R.id.game_activity_egg_layout && com.baidu.adp.lib.util.l.isNetOk()) {
                TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_CLICK);
                if (FrsFragment.this.hSP == null || !FrsFragment.this.hSP.cno()) {
                    String activityUrl = FrsFragment.this.hSn.getForum().getYuleData().bgY().getActivityUrl();
                    if (!StringUtils.isNull(activityUrl)) {
                        com.baidu.tbadk.browser.a.startInternalWebActivity(FrsFragment.this.getPageContext().getPageActivity(), activityUrl);
                    }
                } else {
                    FrsFragment.this.hSP.cnp();
                }
            }
            if (FrsFragment.this.hSP != null && view == FrsFragment.this.hSP.cnv() && FrsFragment.this.hTi != null && FrsFragment.this.hTi.hasMore()) {
                FrsFragment.this.hSP.bGR();
                FrsFragment.this.bFD();
            }
            if (view != null && FrsFragment.this.hSP != null && view == FrsFragment.this.hSP.cnl()) {
                if (com.baidu.tbadk.core.util.bg.checkUpIsLogin(FrsFragment.this.getContext())) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).ai("obj_locate", 2));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MessageCenterActivityConfig(FrsFragment.this.getContext())));
                } else {
                    return;
                }
            }
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (FrsFragment.this.hSn != null && FrsFragment.this.hSn.getForum() != null) {
                    if (FrsFragment.this.hSP != null && view == FrsFragment.this.hSP.cnj()) {
                        if (FrsFragment.this.hSn != null && FrsFragment.this.hSn.getForum() != null && !StringUtils.isNull(FrsFragment.this.hSn.getForum().getId()) && !StringUtils.isNull(FrsFragment.this.hSn.getForum().getName())) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_SHARE_CLICK).dD("fid", FrsFragment.this.hSn.getForum().getId()).ai("obj_locate", 11));
                            com.baidu.tieba.frs.f.e.a(FrsFragment.this.getPageContext(), FrsFragment.this.hSn, FrsFragment.this.hSn.getForum().getId());
                        } else {
                            return;
                        }
                    }
                    if (FrsFragment.this.hSP != null && view == FrsFragment.this.hSP.cni()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12402").dD("fid", FrsFragment.this.hSn.getForum().getId()).dD("uid", TbadkCoreApplication.getCurrentAccount()).dD("fname", FrsFragment.this.hSn.getForum().getName()));
                        if (!StringUtils.isNull(FrsFragment.this.hSn.getForum().getName())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PostSearchActivityConfig(FrsFragment.this.getContext(), FrsFragment.this.hSn.getForum().getName(), FrsFragment.this.hSn.getForum().getId())));
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
        private int hUW = 0;
        private int fCF = 0;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsFragment.this.hTN += i2;
            if (FrsFragment.this.hTN >= FrsFragment.this.dhe * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
            if (FrsFragment.this.hTr != null) {
                FrsFragment.this.hTr.csR();
            }
            this.hUW = 0;
            this.fCF = 0;
            if (recyclerView != null && (recyclerView instanceof BdRecyclerView)) {
                this.hUW = ((BdRecyclerView) recyclerView).getFirstVisiblePosition();
                this.fCF = ((BdRecyclerView) recyclerView).getLastVisiblePosition();
            }
            if (FrsFragment.this.hTC != null) {
                FrsFragment.this.hTC.a(recyclerView, this.hUW, this.fCF);
            }
            if (FrsFragment.this.hSn != null && FrsFragment.this.hSP != null && FrsFragment.this.hSP.cnr() != null) {
                FrsFragment.this.hSP.ch(this.hUW, this.fCF);
                if (FrsFragment.this.hTh != null && FrsFragment.this.hTh.tR() != null) {
                    FrsFragment.this.hTh.tR().b(FrsFragment.this.hTg);
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (FrsFragment.this.hTj != null) {
                FrsFragment.this.hTj.setScrollState(i);
            }
            if ((i == 2 || i == 1) && !FrsFragment.this.hTb) {
                FrsFragment.this.hTb = true;
                FrsFragment.this.hSP.cnt();
            }
            if (FrsFragment.this.hTc == null && !FrsFragment.this.cmz()) {
                FrsFragment.this.hTc = new com.baidu.tbadk.n.b();
                FrsFragment.this.hTc.setSubType(1000);
            }
            if (i == 0) {
                if (FrsFragment.this.hTc != null) {
                    FrsFragment.this.hTc.bue();
                }
                com.baidu.tieba.card.s.cbX().nk(true);
                FrsFragment.this.od(true);
                FrsFragment.this.hSP.cg(this.hUW, this.fCF);
            } else if (FrsFragment.this.hTc != null) {
                FrsFragment.this.hTc.bud();
            }
            if (FrsFragment.this.hTC != null) {
                FrsFragment.this.hTC.onScrollStateChanged(recyclerView, i);
            }
            if (i == 0) {
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.hSP, FrsFragment.this.hSn, FrsFragment.this.getForumId(), false, null);
            }
            if (FrsFragment.this.hTk != null && i == 1) {
                FrsFragment.this.hTk.ctV();
            }
            if (FrsFragment.this.hTh == null) {
                if (FrsFragment.this.hSP.cmV() != null && !FrsFragment.this.hSP.cmx() && FrsFragment.this.hSP.cmV().djT() != null && (FrsFragment.this.hSP.cmV().djT().getTag() instanceof com.baidu.card.al)) {
                    FrsFragment.this.hTh = (com.baidu.card.al) FrsFragment.this.hSP.cmV().djT().getTag();
                }
            } else if (i == 0 && FrsFragment.this.hSP.cmV() != null && !FrsFragment.this.hSP.cmx() && FrsFragment.this.hSP.cmV().djT() != null && (FrsFragment.this.hSP.cmV().djT().getTag() instanceof com.baidu.card.al)) {
                FrsFragment.this.hTh = (com.baidu.card.al) FrsFragment.this.hSP.cmV().djT().getTag();
            }
            if (i == 1) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921418));
            }
        }
    };
    private final f hUz = new f() { // from class: com.baidu.tieba.frs.FrsFragment.41
        @Override // com.baidu.tieba.frs.f
        public void a(int i, int i2, View view, View view2, bw bwVar) {
            if (i != FrsFragment.this.hSP.cnr().cpK()) {
                if (i != FrsFragment.this.hSP.cnr().cpL()) {
                    if (i == FrsFragment.this.hSP.cnr().cpI() && FrsFragment.this.hSn != null && FrsFragment.this.hSn.getUserData() != null && FrsFragment.this.hSn.getUserData().isBawu()) {
                        String bawuCenterUrl = FrsFragment.this.hSn.getBawuCenterUrl();
                        if (!com.baidu.tbadk.core.util.at.isEmpty(bawuCenterUrl) && FrsFragment.this.hSn.getForum() != null) {
                            com.baidu.tbadk.browser.a.startWebActivity(FrsFragment.this.getPageContext().getPageActivity(), bawuCenterUrl);
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10502").dD("fid", FrsFragment.this.hSn.getForum().getId()).dD("uid", FrsFragment.this.hSn.getUserData().getUserId()));
                        }
                    }
                } else if (com.baidu.tbadk.core.util.bg.checkUpIsLogin(FrsFragment.this.getPageContext().getPageActivity())) {
                    TiebaStatic.log(CommonStatisticKey.MY_SERVICE_CK);
                    if (FrsFragment.this.hSn != null && FrsFragment.this.hSn.getForum() != null) {
                        ForumData forum = FrsFragment.this.hSn.getForum();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(forum.getId(), 0L), forum.getName(), forum.getImage_url(), 0)));
                    }
                }
            } else if (com.baidu.tbadk.core.util.bg.checkUpIsLogin(FrsFragment.this.getActivity())) {
                TiebaStatic.log("forum_fortune_click");
                com.baidu.tieba.frs.f.i.c(FrsFragment.this.getPageContext(), FrsFragment.this.hSn);
            }
        }
    };
    private final NoNetworkView.a hPZ = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.FrsFragment.42
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (FrsFragment.this.hTi.crR() == 1 && z && !FrsFragment.this.hSP.cmx()) {
                if (FrsFragment.this.hSn == null || com.baidu.tbadk.core.util.y.isEmpty(FrsFragment.this.hSn.getThreadList())) {
                    FrsFragment.this.hideNetRefreshView(FrsFragment.this.hSP.bZb());
                    FrsFragment.this.showLoadingView(FrsFragment.this.hSP.bZb(), true);
                    FrsFragment.this.hSP.on(false);
                    FrsFragment.this.refresh();
                    return;
                }
                FrsFragment.this.hSP.cne();
            }
        }
    };
    private final CustomMessageListener eCs = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.FrsFragment.43
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                com.baidu.tieba.frs.f.c.a(customResponsedMessage, FrsFragment.this.hSP, FrsFragment.this.hSn);
            }
        }
    };
    private com.baidu.adp.widget.ListView.ab hUA = new a();
    private av hUB = new av() { // from class: com.baidu.tieba.frs.FrsFragment.46
        @Override // com.baidu.tieba.frs.av
        public void a(int i, int i2, bd bdVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
            com.baidu.adp.lib.f.e.mS().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.46.1
                @Override // java.lang.Runnable
                public void run() {
                    if (FrsFragment.this.hSP != null && FrsFragment.this.hSP.cny()) {
                        FrsFragment.this.bFD();
                    }
                }
            });
        }
    };
    private CustomMessageListener hUC = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.frs.FrsFragment.47
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    FrsFragment.this.hTD = true;
                }
            }
        }
    };
    private CustomMessageListener hUD = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.frs.FrsFragment.48
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                    if (FrsFragment.this.hTh == null && FrsFragment.this.hSP.cmV() != null && !FrsFragment.this.hSP.cmx() && FrsFragment.this.hSP.cmV().djT() != null && (FrsFragment.this.hSP.cmV().djT().getTag() instanceof com.baidu.card.al)) {
                        FrsFragment.this.hTh = (com.baidu.card.al) FrsFragment.this.hSP.cmV().djT().getTag();
                    }
                    if (FrsFragment.this.hTh != null && FrsFragment.this.hTh.tR() != null) {
                        FrsFragment.this.hTh.tR().b(new a.C0095a(3));
                    }
                }
            }
        }
    };
    private CustomMessageListener hUE = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.FrsFragment.49
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.hSP != null) {
                FrsFragment.this.hSP.EF();
            }
        }
    };
    private CustomMessageListener hUF = new CustomMessageListener(2921437) { // from class: com.baidu.tieba.frs.FrsFragment.50
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && FrsFragment.this.isResumed()) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (FrsFragment.this.hSR != null) {
                    if (booleanValue) {
                        if (FrsFragment.this.hTk.ctW() != 0 && !FrsFragment.this.hSP.cnD() && !KuangFloatingFrsCopyLinkViewController.getInstance().isFloatCopyViewShow()) {
                            FrsFragment.this.hSR.show();
                            return;
                        }
                        return;
                    }
                    FrsFragment.this.hSR.hide();
                }
            }
        }
    };
    private CustomMessageListener hUG = new CustomMessageListener(2921462) { // from class: com.baidu.tieba.frs.FrsFragment.55
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && FrsFragment.this.hSn.getToLoadHorseData().intValue() == 1 && FrsFragment.this.mIsLogin) {
                LiveHorseRaceRequestMessage liveHorseRaceRequestMessage = new LiveHorseRaceRequestMessage();
                liveHorseRaceRequestMessage.setForum_id(Long.valueOf(FrsFragment.this.forumId));
                FrsFragment.this.sendMessage(liveHorseRaceRequestMessage);
            }
        }
    };
    private CustomMessageListener hUH = new CustomMessageListener(2001223) { // from class: com.baidu.tieba.frs.FrsFragment.57
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Date)) {
                FrsFragment.this.hTM = (Date) customResponsedMessage.getData();
            }
        }
    };
    private CustomMessageListener hUI = new CustomMessageListener(2921469) { // from class: com.baidu.tieba.frs.FrsFragment.58
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.x) && FrsFragment.this.isResumed()) {
                com.baidu.tbadk.core.data.x xVar = (com.baidu.tbadk.core.data.x) customResponsedMessage.getData();
                if (FrsFragment.this.hTT == null) {
                    FrsFragment.this.hTT = new com.baidu.tieba.frs.broadcast.a(FrsFragment.this.getPageContext());
                }
                if (FrsFragment.this.hSn != null && FrsFragment.this.hSn.getForum() != null && !TextUtils.isEmpty(FrsFragment.this.hSn.getForum().getId())) {
                    FrsFragment.this.hTT.e(xVar.type, FrsFragment.this.hSn.getForum().getId(), FrsFragment.this.hSn.getForum().getName(), xVar.tid);
                }
            }
        }
    };
    private CustomMessageListener hUJ = new CustomMessageListener(2921475) { // from class: com.baidu.tieba.frs.FrsFragment.59
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bw bwVar = (bw) customResponsedMessage.getData();
            if (bwVar != null && FrsFragment.this.isResumed()) {
                FrsFragment.this.hTf = bwVar.getTid() + "";
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE_NUMBER);
                httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
                httpMessage.addParam("forum_id", bwVar.getFid());
                MessageManager.getInstance().sendMessage(httpMessage);
            }
        }
    };
    private HttpMessageListener hUK = new HttpMessageListener(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE_NUMBER) { // from class: com.baidu.tieba.frs.FrsFragment.60
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if ((httpResponsedMessage instanceof ForumManagerRightsResMsg) && FrsFragment.this.isResumed()) {
                ForumManagerRightsResMsg forumManagerRightsResMsg = (ForumManagerRightsResMsg) httpResponsedMessage;
                if (forumManagerRightsResMsg.broadcastTotalCount - forumManagerRightsResMsg.broadcastUsedCount <= 0) {
                    new ScreenTopToast(FrsFragment.this.getContext()).St(FrsFragment.this.getString(R.string.frs_forum_bawu_send_broadcast_none_tip)).Sv(FrsFragment.this.getString(R.string.frs_recommend_fail_tip_btn)).ak(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.60.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("_forumId", FrsFragment.this.hSn.getForum().getId());
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new com.baidu.tieba.tbadkCore.data.m(FrsFragment.this.getContext(), "ForumGradePage", hashMap)));
                        }
                    }).aE((ViewGroup) FrsFragment.this.mRootView.findViewById(R.id.frs));
                    return;
                }
                com.baidu.tbadk.core.util.o oVar = new com.baidu.tbadk.core.util.o(TbadkCoreApplication.getInst());
                oVar.ab(FrsFragment.this.hSn.getForum().getId(), FrsFragment.this.hSn.getForum().getName(), "6");
                oVar.zU(FrsFragment.this.hTf);
                oVar.start();
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.frs.loadmore.a
    public /* bridge */ /* synthetic */ com.baidu.adp.base.e getPageContext() {
        return super.getPageContext();
    }

    public com.baidu.tieba.frs.entelechy.b.b clJ() {
        return this.hTq;
    }

    public com.baidu.adp.widget.ListView.ab clK() {
        return this.hUA;
    }

    public com.baidu.tieba.frs.mc.d clL() {
        return this.hTs;
    }

    public com.baidu.tieba.frs.smartsort.a clM() {
        return this.hTm;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public FrsModelController clN() {
        return this.hTi;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public com.baidu.tieba.frs.mc.c clO() {
        return this.hTt;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public com.baidu.tieba.frs.vc.h clP() {
        return this.hTj;
    }

    public FrsTabViewController clQ() {
        return this.hTk;
    }

    public ax clR() {
        return this.hTo;
    }

    public void oc(boolean z) {
        this.hTL = z;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public q clS() {
        return this.hSP;
    }

    @Override // com.baidu.tieba.frs.aw
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.aw, com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.hSH;
    }

    public void setForumName(String str) {
        this.hSH = str;
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
        if (this.hTt == null) {
            return 1;
        }
        return this.hTt.getPn();
    }

    public int getPn() {
        if (this.hTt == null) {
            return 1;
        }
        return this.hTt.getPn();
    }

    public void setPn(int i) {
        if (this.hTt != null) {
            this.hTt.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.hTt != null) {
            this.hTt.setHasMore(i);
        }
    }

    public int clT() {
        if (this.hTt == null) {
            return -1;
        }
        return this.hTt.clT();
    }

    public boolean clU() {
        return this.hSN;
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
            this.hSP.cmY();
            showNetRefreshView(this.hSP.bZb(), string, true);
        } else if (340001 == fVar.errorCode) {
            a(fVar, this.hSn.getRecm_forum_list());
        } else {
            if (com.baidu.tbadk.core.util.y.isEmpty(this.hSn.getThreadList())) {
                b(fVar);
            }
            if (cmz()) {
                setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds280));
            } else {
                setNetRefreshViewEmotionDefMarginTop();
            }
        }
    }

    public void a(View view, String str, boolean z, List<RecmForumInfo> list) {
        this.hSP.cmY();
        this.hSP.xc(8);
        if (this.hTB == null) {
            this.hTB = new com.baidu.tieba.frs.view.a(getPageContext(), getNetRefreshListener());
        }
        this.hTB.setSubText(str);
        this.hTB.setListData(list);
        this.hTB.attachView(view, z);
    }

    private void a(com.baidu.tieba.tbadkCore.f fVar, List<RecmForumInfo> list) {
        if (this.hSP != null) {
            this.hSP.cmY();
            this.hSP.setTitle(this.hSH);
            a(this.hSP.bZb(), fVar.errorMsg, true, list);
        }
    }

    private void b(com.baidu.tieba.tbadkCore.f fVar) {
        this.hSP.cmY();
        if (fVar.hCM) {
            showNetRefreshView(this.hSP.bZb(), TbadkCoreApplication.getInst().getString(R.string.net_error_text, new Object[]{fVar.errorMsg, Integer.valueOf(fVar.errorCode)}), true);
        } else {
            showNetRefreshView(this.hSP.bZb(), fVar.errorMsg, true);
        }
    }

    public void clV() {
        hideLoadingView(this.hSP.bZb());
        this.hSP.bGd();
        if (this.hSP.cmW() instanceof com.baidu.tieba.frs.tab.c) {
            ((com.baidu.tieba.frs.tab.c) this.hSP.cmW()).csy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clW() {
        if (clT() == 0 && com.baidu.tbadk.core.util.y.isEmpty(this.hSn.getThreadListIds())) {
            if (com.baidu.tbadk.core.util.y.isEmpty(this.hSn.getThreadList())) {
                this.hSP.bGT();
            } else {
                this.hSP.bGS();
            }
        } else if (com.baidu.tbadk.core.util.y.getCount(this.hSn.getThreadList()) > 3) {
            this.hSP.bGR();
        } else {
            this.hSP.cnu();
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
            clV();
            this.hSP.cne();
            com.baidu.tieba.tbadkCore.f crN = this.hTi.crN();
            boolean isEmpty = com.baidu.tbadk.core.util.y.isEmpty(this.hSn.getThreadList());
            if (crN != null && isEmpty) {
                if (this.hTi.crP() != 0) {
                    this.hTi.crU();
                    this.hSP.cne();
                } else {
                    a(crN);
                }
                this.hSP.U(this.hSn.isStarForum(), false);
                return;
            }
            a(crN);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(com.baidu.tieba.tbadkCore.m mVar) {
        if (mVar != null && mVar.getEntelechyTabInfo() != null && mVar.getEntelechyTabInfo().tab != null) {
            for (FrsTabInfo frsTabInfo : mVar.getEntelechyTabInfo().tab) {
                if (frsTabInfo.tab_id.intValue() == 502 && com.baidu.tbadk.core.sharedPref.b.bik().getBoolean("first_into_tab_profession", true)) {
                    return false;
                }
            }
        }
        return new com.baidu.tieba.frs.ad.f(getTbPageContext()).d(mVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ForumData forumData) {
        if (!com.baidu.tbadk.core.util.at.isEmpty(forumData.getRiskTipPop()) && !com.baidu.tbadk.core.util.at.isEmpty(forumData.getRiskTipPopTitle())) {
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
            aVar.zy(forumData.getRiskTipPopTitle());
            aVar.setTitleShowCenter(true);
            aVar.zz(forumData.getRiskTipPop());
            aVar.a(R.string.frs_risk_dialog_button_text, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.19
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                }
            });
            aVar.b(getPageContext()).bhg();
        }
    }

    public boolean clX() {
        return clY() && !clZ();
    }

    private boolean clY() {
        if (cmw() == null) {
            return false;
        }
        FrsViewData cmw = cmw();
        com.baidu.tbadk.core.data.y yVar = null;
        if (cmw.getStar() != null && !StringUtils.isNull(cmw.getStar().dvT())) {
            yVar = new com.baidu.tbadk.core.data.y();
        } else if (cmw.getActivityHeadData() != null && com.baidu.tbadk.core.util.y.getCount(cmw.getActivityHeadData().bcI()) >= 1) {
            yVar = cmw.getActivityHeadData().bcI().get(0);
        }
        return yVar != null;
    }

    public boolean clZ() {
        if (cmw() == null) {
            return false;
        }
        FrsViewData cmw = cmw();
        return (com.baidu.tbadk.core.util.y.isEmpty(cmw.getShowTopThreadList()) && cmw.getBusinessPromot() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cma() {
        boolean b;
        if (!cmc()) {
            final PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
            privateForumPopInfoData.a(this.hSn.getPrivateForumTotalInfo().getPrivatePopInfo());
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(getActivity());
            if (this.hSn.getPrivateForumTotalInfo().bdB().private_forum_status.intValue() == 1 && (com.baidu.tbadk.core.util.at.isEmpty(privateForumPopInfoData.bdD()) || privateForumPopInfoData.bdG() != Integer.valueOf(this.forumId))) {
                privateForumPopInfoData.zc("create_success");
                privateForumPopInfoData.zd(TbadkCoreApplication.getInst().getString(R.string.frs_private_create_hint));
                privateForumPopInfoData.ze("https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.hSH + "&nomenu=1");
                privateForumPopInfoData.i(Integer.valueOf(this.forumId));
                b = frsPrivateCommonDialogView.b(privateForumPopInfoData);
            } else {
                b = privateForumPopInfoData.bdG() == Integer.valueOf(this.forumId) ? frsPrivateCommonDialogView.b(privateForumPopInfoData) : false;
            }
            if (b) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
                aVar.nw(2);
                aVar.aX(frsPrivateCommonDialogView);
                aVar.ig(false);
                frsPrivateCommonDialogView.setConfirmButton(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.20
                    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.frs.FrsFragment */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        com.baidu.tbadk.core.util.be.bju().b(FrsFragment.this.getPageContext(), new String[]{privateForumPopInfoData.bdF()});
                        aVar.dismiss();
                    }
                });
                aVar.a(new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.21
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(getPageContext()).bhg();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmb() {
        if (cmc() || this.hSn.getPrivateForumTotalInfo().bdB().private_forum_status.intValue() != 1) {
            a((Integer) null, (Integer) null, true);
        } else {
            a(this.hSn.getPrivateForumTotalInfo().bdB().private_forum_audit_status, this.hSn.getPrivateForumTotalInfo().bdC(), false);
        }
    }

    public void a(Integer num, Integer num2, boolean z) {
        final String str;
        final int i = 2;
        if (this.hSP.cnk() != null) {
            TextView cnk = this.hSP.cnk();
            if (z) {
                cnk.setVisibility(8);
                return;
            }
            if (num.intValue() == 2) {
                cnk.setText("修改实名认证信息");
                cnk.setVisibility(0);
                str = "https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + this.forumId + "&nomenu=1";
            } else if (num2.intValue() >= 0 && num2.intValue() <= 100) {
                cnk.setText("目标已完成" + String.valueOf(num2) + "%");
                cnk.setVisibility(0);
                str = "https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.hSH + "&nomenu=1";
                i = 1;
            } else {
                cnk.setVisibility(8);
                i = 0;
                str = "";
            }
            cnk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.22
                /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13387").dD("fid", FrsFragment.this.forumId).dD("uid", TbadkCoreApplication.getCurrentAccount()).ai("obj_type", i));
                    com.baidu.tbadk.core.util.be.bju().b(FrsFragment.this.getPageContext(), new String[]{str});
                }
            });
        }
    }

    private boolean cmc() {
        return this.hSn == null || this.hSn.getPrivateForumTotalInfo() == null || this.hSn.getPrivateForumTotalInfo().bdB() == null || this.hSn.getUserData().getIs_manager() != 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wR(int i) {
        List<WindowToast> list;
        if (TbadkCoreApplication.isLogin() && this.hSn != null && (list = this.hSn.mWindowToast) != null && list.size() > 0) {
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
    public void cmd() {
        if (getActivity() != null && getActivity().getIntent() != null) {
            String stringExtra = getActivity().getIntent().getStringExtra(FrsActivityConfig.KEY_ACHIEVEMENT_URL);
            if (!TextUtils.isEmpty(stringExtra)) {
                getActivity().getIntent().removeExtra(FrsActivityConfig.KEY_ACHIEVEMENT_URL);
                AchievementActivityConfig achievementActivityConfig = new AchievementActivityConfig(getActivity());
                achievementActivityConfig.setUrl(stringExtra);
                if (this.hSn != null && this.hSn.getForumActiveInfo() != null) {
                    achievementActivityConfig.setShareUrl(this.hSn.getForumActiveInfo().forum_share_url);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, achievementActivityConfig));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cme() {
        if (this.hSn == null || this.hSn.getForum() != null) {
            this.hSP.cnq();
        } else if (this.hSn.getForum().getYuleData() != null && this.hSn.getForum().getYuleData().bgX()) {
            TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_VIEW);
            this.hSP.a(this.hSn.getForum().getYuleData().bgY());
        } else {
            this.hSP.cnq();
        }
    }

    private void S(boolean z, boolean z2) {
        if (this.hTi != null && this.hSn != null && this.hSP != null && z) {
            if (!this.hTi.csb() && this.hTi.crR() == 1) {
                if (!this.hTi.crZ()) {
                    this.hSn.addCardVideoInfoToThreadList();
                    this.hSn.addVideoInfoToThreadListInTenAndFifteenFloor();
                }
                boolean z3 = false;
                if (this.hSP.cnr().s(com.baidu.tieba.card.data.o.hnv)) {
                    z3 = this.hSn.addHotTopicDataToThreadList();
                }
                if (!z3) {
                    this.hSn.addFeedForumDataToThreadList();
                }
                if (TbadkCoreApplication.getInst().isRecAppExist()) {
                    this.hSn.addRecommendAppToThreadList(this);
                }
                if (!this.hSP.cnr().s(bw.ebp)) {
                    this.hSn.removeAlaLiveThreadData();
                }
                this.hSn.addSchoolRecommendToThreadList();
            }
            if (!this.hSP.cnr().s(bw.ebp)) {
                this.hSn.removeAlaInsertLiveData();
                this.hSn.removeAlaStageLiveDat();
            } else {
                this.hSn.addInsertLiveDataToThreadList();
                this.hSn.addStageLiveDataToThreadList();
            }
            this.hSn.checkLiveStageInThreadList();
            this.hSn.addNoticeThreadToThreadList();
            if (this.hSP.cnr().s(com.baidu.tieba.h.b.iAQ)) {
                this.hSn.addGameRankListToThreadList(z2);
            }
            if (TbadkCoreApplication.isLogin() && (!this.hTi.csb() || this.hTi.isNetFirstLoad)) {
                this.hSn.addUserRecommendToThreadList();
            }
            this.hSn.addVideoActivityToTop();
        }
    }

    public boolean cmf() {
        if (this.hTj != null && this.hTi != null) {
            this.hTj.a(this.hTi.getPageType(), this.hSn);
        }
        boolean z = false;
        if (this.hSn != null) {
            z = this.hSn.hasTab();
        }
        cmi();
        if (this.hSP != null) {
            this.hSP.cnE();
            this.hSP.cnF();
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wS(int i) {
        ba baVar = null;
        cmf();
        cmr();
        try {
            if (this.hSn != null) {
                this.hSP.a((ArrayList<com.baidu.adp.widget.ListView.q>) null, this.hSn);
                this.hTj.yL(1);
                this.hSP.cnh();
                this.hTk.a(this.hSn, this.hTi.crW());
                com.baidu.tieba.frs.tab.d yV = this.hTk.yV(this.hSn.getFrsDefaultTabId());
                if (yV != null && !TextUtils.isEmpty(yV.url)) {
                    baVar = new ba();
                    baVar.ext = yV.url;
                    baVar.stType = yV.name;
                }
                this.hTi.a(this.hSn.getFrsDefaultTabId(), 0, baVar);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(boolean z, boolean z2) {
        try {
            if (this.hSn != null && this.hTk != null && this.hTi != null) {
                if (!this.hSP.cnr().s(bw.ebp)) {
                    this.hSn.removeAlaLiveThreadData();
                }
                boolean isEmpty = com.baidu.tbadk.core.util.y.isEmpty(this.hSn.getGameTabInfo());
                this.hSP.ol(isEmpty);
                if (!isEmpty) {
                    if (this.hTC == null) {
                        this.hTC = new com.baidu.tieba.frs.vc.e(this, (NoPressedRelativeLayout) this.mRootView);
                    }
                    if (this.fXJ == null) {
                        this.fXJ = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
                    }
                } else {
                    this.hTC = null;
                    this.fXJ = null;
                }
                if (this.hSn.getForum() != null) {
                    this.hSH = this.hSn.getForum().getName();
                    this.forumId = this.hSn.getForum().getId();
                }
                if (this.hSn.hasTab()) {
                    this.hTk.a(this.hSn, this.hTi.crW());
                }
                if (z) {
                    S(true, z);
                } else {
                    S(this.hTd, z);
                }
                cmf();
                if (this.hTq != null) {
                    this.hTq.a(this.hTj, this.hSn);
                }
                if (this.hSn.getPage() != null) {
                    setHasMore(this.hSn.getPage().bdu());
                }
                ArrayList<com.baidu.adp.widget.ListView.q> a2 = this.hTt.a(z2, true, this.hSn.getThreadList(), null, z, false);
                if (a2 != null) {
                    this.hSn.setThreadList(a2);
                }
                this.hSn.removeRedundantUserRecommendData();
                this.hSp = this.hSn.getTopThreadSize();
                if (this.hSL != null) {
                    this.hSK = true;
                    this.hSL.HL(this.hSp);
                    com.baidu.tieba.frs.f.a.a(this, this.hSn.getForum(), this.hSn.getThreadList(), this.hSK, getPn());
                }
                if (this.hTi.crR() == 1) {
                    cmm();
                    if (!z && this.hTi.getPn() == 1) {
                        cmh();
                    }
                }
                if (this.hTr != null) {
                    this.hTr.cm(this.hTk.ctS());
                }
                clV();
                this.hSP.cmZ();
                this.hSP.U(true, false);
                if (z && this.hSn.isFirstTabEqualAllThread()) {
                    com.baidu.adp.lib.f.e.mS().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.24
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!FrsFragment.this.hTa && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                FrsFragment.this.hSP.cnC();
                            }
                        }
                    });
                }
                if (this.hSn.getForum() != null) {
                    this.hSP.Iq(this.hSn.getForum().getWarningMsg());
                }
                if (this.hSn != null && this.hSn.getFrsVideoActivityData() != null && com.baidu.tbadk.core.sharedPref.b.bik().getLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 0L) == 0) {
                    com.baidu.adp.lib.f.e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.25
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsFragment.this.hSP.cnA();
                        }
                    }, 1000L);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FRS_SHOW_AR_ENTRY, this));
                this.hSP.cmT();
                if (this.hSn != null && this.hSn.getForum() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ENTER_FORUM, new VisitedForumData(this.hSn.getForum().getId(), this.hSn.getForum().getName(), this.hSn.getForum().getImage_url(), String.valueOf(System.currentTimeMillis() / 1000), ConstantData.Forum.SPECAIL_FORUM_TYPE_LIVE.equals(this.hSn.getForum().special_forum_type), this.hSn.getForum().getThemeColorInfo(), this.hSn.getForum().getMember_num())));
                }
                this.hTG.a(this.hSn.bottomMenuList, this.hSn.getForum());
                cmG();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void cmg() {
        if (this.hTi != null && this.hTi.crR() == 1) {
            this.hTj.j(this.hSn);
        }
    }

    public void od(boolean z) {
        com.baidu.tieba.s.c.dvE().b(getUniqueId(), z);
    }

    public void cmh() {
        if (this.hTw == null) {
            this.hTw = new com.baidu.tieba.frs.live.a(this, com.baidu.adp.lib.f.b.toInt(this.forumId, 0));
        }
        this.hTw.cry();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.tbadkCore.m mVar) {
        try {
            if (!this.hTa && mVar != null && this.hSn != null) {
                this.hSn.receiveData(mVar);
                T(true, false);
                Looper.myQueue().addIdleHandler(this.hTV);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void cmi() {
        if (this.hTi != null) {
            Ip(this.hTi.getPageType());
        } else {
            Ip("normal_page");
        }
    }

    private void Ip(String str) {
        oe("frs_page".equals(str));
        if (this.hTq != null) {
            this.hTq.a(this.hTj, this.hSP, this.hSn);
        }
    }

    public void oe(boolean z) {
        if (this.hTu != null) {
            this.hTu.ctF();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.s.c.dvE().A(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.frs_activity, viewGroup, false);
            this.hSB = new com.baidu.tieba.frs.entelechy.a();
            this.hTq = this.hSB.cpn();
            this.hSA = TbadkCoreApplication.getInst().getString(R.string.frs_title_new_area);
            this.hTj = new com.baidu.tieba.frs.vc.h(this, this.hSB, (FrsHeaderViewContainer) this.mRootView.findViewById(R.id.header_view_container));
            this.hTk = new FrsTabViewController(this, this.mRootView);
            this.hTk.registerListener();
            this.hTj.a(this.hTk);
            this.hTk.a(this.hUd);
            Intent intent = getActivity().getIntent();
            if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                this.hSD = true;
            }
            this.hSP = new q(this, this.hUy, this.hSB, this.hSD, this.hTj);
            this.hTG = new com.baidu.tieba.frs.brand.buttommenu.a(getPageContext(), this.mRootView);
        } else {
            if (this.mRootView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            if (this.hTk != null) {
                this.hTk.registerListener();
            }
            this.hSP.cnz();
            this.mRootView.setLeft(0);
            this.mRootView.setRight(com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getContext()));
        }
        this.hTK = true;
        this.eRK = System.currentTimeMillis() - currentTimeMillis;
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        ArrayList<com.baidu.adp.widget.ListView.q> arrayList = null;
        this.hvn = System.currentTimeMillis();
        long j = this.hvn;
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.hSM = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.hvn = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            U(intent);
        }
        this.eRJ = j - this.hvn;
        this.hSL = new com.baidu.tieba.tbadkCore.data.f("frs", com.baidu.tieba.tbadkCore.data.f.mel);
        if (this.hTi == null) {
            this.hTi = new FrsModelController(this, this.hUt);
            this.hTi.a(this.hUc);
            this.hTi.init();
        }
        this.hTi.setSchemeUrl(this.mSchemeUrl);
        if (intent != null) {
            this.hTi.aj(intent.getExtras());
        } else if (bundle != null) {
            this.hTi.aj(bundle);
        } else {
            this.hTi.aj(null);
        }
        if (intent != null) {
            this.hTj.aq(intent.getExtras());
        } else if (bundle != null) {
            this.hTj.aq(bundle);
        } else {
            this.hTj.aq(null);
        }
        this.hSO = getVoiceManager();
        this.hTx = new p(getPageContext(), this);
        initUI();
        initData(bundle);
        if (!cmz()) {
            this.hTo = new ax(getActivity(), this.hSP, this.hTj);
            this.hTo.oA(true);
        }
        this.hSO = getVoiceManager();
        if (this.hSO != null) {
            this.hSO.onCreate(getPageContext());
        }
        if (FrsActivityConfig.FRS_FROM_FLUTTER_BCASTEDIT.equals(getFrom()) && !this.hasInit) {
            int i = com.baidu.tbadk.core.sharedPref.b.bik().getInt("key_forum_broadcast_edit_tip_number", 0);
            if (i < 2) {
                com.baidu.tbadk.core.sharedPref.b.bik().putInt("key_forum_broadcast_edit_tip_number", i + 1);
                cmo();
            } else if (Build.VERSION.SDK_INT >= 23) {
                if (Settings.canDrawOverlays(getContext())) {
                    cmp();
                } else {
                    new BdTopToast(getContext()).wS(false).Sp(getContext().getString(R.string.forum_broadcast_copy_no_permission_hint)).aE(this.hSP.bZb());
                }
            } else {
                cmp();
            }
        }
        if (KuangFloatingFrsCopyLinkViewController.getInstance().isFloatCopyViewShow()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
            if (this.hSQ != null) {
                this.hSQ.setVisibility(8);
            }
        }
        new com.baidu.tieba.frs.mc.i();
        int i2 = -1;
        if (this.hTt != null && this.hTt.crJ() != null) {
            i2 = this.hTt.crJ().clT();
            arrayList = this.hTt.crJ().getDataList();
        }
        this.hTt = new com.baidu.tieba.frs.mc.c(this, this.hUw);
        this.hTt.crJ().setHasMore(i2);
        if (arrayList != null && arrayList.size() > 0) {
            this.hTt.crJ().aC(arrayList);
        }
        this.hTm = new com.baidu.tieba.frs.smartsort.a(this);
        this.hTu = new com.baidu.tieba.frs.vc.j(this);
        this.hTr = new com.baidu.tieba.frs.vc.a(getPageContext(), this.hTi.crY());
        this.hTn = new com.baidu.tieba.frs.mc.b(this);
        this.hTs = new com.baidu.tieba.frs.mc.d(this);
        this.hTl = new com.baidu.tieba.frs.mc.h(this);
        this.hTv = new com.baidu.tieba.frs.mc.a(this);
        this.hTy = new com.baidu.tieba.frs.vc.c(this);
        this.hTz = new com.baidu.tieba.frs.mc.e(this, getUniqueId());
        this.hTE = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "frs");
        this.hTF = new com.baidu.tieba.ala.a(getPageContext());
        this.hTH = new com.baidu.tieba.frs.sportspage.notification.a(getPageContext());
        registerListener(this.hUl);
        registerListener(this.mMemListener);
        registerListener(this.hUj);
        registerListener(this.hUx);
        registerListener(this.hUu);
        registerListener(this.hUf);
        registerListener(this.hUg);
        registerListener(this.hUh);
        registerListener(this.hUi);
        registerListener(this.hTW);
        registerListener(this.hTX);
        registerListener(this.afN);
        registerListener(this.hTY);
        registerListener(this.hUC);
        registerListener(this.hUn);
        registerListener(this.hUb);
        registerListener(this.hUo);
        registerListener(this.hUm);
        registerListener(this.hUq);
        registerListener(this.hUr);
        registerListener(this.hUs);
        this.hUD.setTag(getPageContext().getUniqueId());
        MessageManager.getInstance().registerListener(this.hUD);
        registerListener(this.hUE);
        registerListener(this.hUF);
        registerListener(this.hUG);
        registerListener(this.hUa);
        registerListener(this.hUH);
        registerListener(this.hUp);
        registerListener(this.hTZ);
        registerListener(this.hUI);
        registerListener(this.hUJ);
        registerListener(this.hUK);
        this.hSP.on(false);
        if (!cmz() && !this.hasInit) {
            showLoadingView(this.hSP.bZb(), true);
            this.hTi.R(3, false);
        }
        ay ayVar = new ay() { // from class: com.baidu.tieba.frs.FrsFragment.28
            @Override // com.baidu.tieba.frs.ay
            public void d(boolean z, boolean z2, int i3) {
                if (FrsFragment.this.hSP != null) {
                    if (i3 == 1) {
                        FrsFragment.this.hSP.xd(z ? 0 : 8);
                    } else if (i3 == 2) {
                        FrsFragment.this.hSP.xf(z ? 0 : 8);
                    }
                    if (!z2) {
                        FrsFragment.this.hTJ = z;
                    }
                    if (FrsFragment.this.hSP.cnr() != null && (i3 == 2 || (FrsFragment.this.hTi != null && FrsFragment.this.hTi.crS()))) {
                        FrsFragment.this.hSP.cnr().notifyDataSetChanged();
                    }
                    if (FrsFragment.this.clQ() != null) {
                        FrsTabViewController.b ctT = FrsFragment.this.clQ().ctT();
                        if (ctT != null) {
                            if ((ctT.fragment instanceof FrsCommonTabFragment) && (i3 == 2 || ctT.tabId == 502)) {
                                ((FrsCommonTabFragment) ctT.fragment).cpd();
                            } else if ((ctT.fragment instanceof FrsNewAreaFragment) && (i3 == 2 || ctT.tabId == 503)) {
                                FrsNewAreaFragment frsNewAreaFragment = (FrsNewAreaFragment) ctT.fragment;
                                frsNewAreaFragment.cpd();
                                if (frsNewAreaFragment.csj() != null) {
                                    com.baidu.tieba.frs.mc.g csj = frsNewAreaFragment.csj();
                                    csj.oC(!z);
                                    if (i3 == 1) {
                                        csj.oq(!z);
                                    } else if (i3 == 2) {
                                        csj.oq(true);
                                    }
                                }
                            } else if (ctT.fragment instanceof FrsGoodFragment) {
                                ((FrsGoodFragment) ctT.fragment).cpd();
                            }
                        }
                        if (FrsFragment.this.clQ().ctK() != null) {
                            FrsFragment.this.clQ().ctK().setmDisallowSlip(z);
                            FrsFragment.this.clQ().ph(z);
                        }
                    }
                    if (FrsFragment.this.hSP.cmX() != null) {
                        FrsFragment.this.hSP.ok(!z);
                    }
                    if (FrsFragment.this.getActivity() instanceof FrsActivity) {
                        ((FrsActivity) FrsFragment.this.getActivity()).ob(!z);
                    }
                    if (FrsFragment.this.hTG != null) {
                        FrsFragment.this.hTG.oI(!z);
                    }
                    FrsFragment.this.hSP.op(!z);
                    if (i3 == 1) {
                        FrsFragment.this.hSP.oq(z ? false : true);
                    } else if (i3 == 2) {
                        FrsFragment.this.hSP.oq(true);
                    }
                }
            }

            @Override // com.baidu.tieba.frs.ay
            public void cf(int i3, int i4) {
                if (FrsFragment.this.hSP != null) {
                    if (i4 == 1) {
                        FrsFragment.this.hSP.xe(i3);
                    } else if (i4 == 2) {
                        FrsFragment.this.hSP.xg(i3);
                    }
                }
            }

            @Override // com.baidu.tieba.frs.ay
            public void wW(int i3) {
                if (FrsFragment.this.getContext() != null) {
                    if (i3 == 1) {
                        com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getContext(), R.string.frs_multi_delete_max_num);
                    } else if (i3 == 2 && FrsFragment.this.hSP != null) {
                        new BdTopToast(FrsFragment.this.getContext()).wS(false).Sp(FrsFragment.this.getContext().getString(R.string.frs_move_area_max_num)).aE(FrsFragment.this.hSP.bZb());
                    }
                }
            }
        };
        b.ckS().a(ayVar);
        com.baidu.tieba.frs.a.ckL().a(ayVar);
        this.hSP.b(new d.a() { // from class: com.baidu.tieba.frs.FrsFragment.29
            @Override // com.baidu.tieba.NEGFeedBack.d.a
            public void a(DeleteThreadHttpResponseMessage deleteThreadHttpResponseMessage) {
                boolean z;
                int i3 = 0;
                if (deleteThreadHttpResponseMessage != null) {
                    FrsFragment.this.hSP.bAi();
                    FrsFragment.this.hSP.cnB();
                    FrsNewAreaFragment frsNewAreaFragment = null;
                    if (FrsFragment.this.hTk == null || FrsFragment.this.hTk.ctT() == null || !(FrsFragment.this.hTk.ctT().fragment instanceof FrsNewAreaFragment)) {
                        z = false;
                    } else {
                        frsNewAreaFragment = (FrsNewAreaFragment) FrsFragment.this.hTk.ctT().fragment;
                        z = true;
                    }
                    if (deleteThreadHttpResponseMessage.getError() == 0) {
                        String text = !TextUtils.isEmpty(deleteThreadHttpResponseMessage.getText()) ? deleteThreadHttpResponseMessage.getText() : FrsFragment.this.getString(R.string.delete_fail);
                        if (deleteThreadHttpResponseMessage.getRetType() == 1211066) {
                            if (FrsFragment.this.hlV == null) {
                                FrsFragment.this.hlV = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.hlV.zz(text);
                            FrsFragment.this.hlV.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.29.1
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.hlV.ig(false);
                            FrsFragment.this.hlV.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.hlV.bhg();
                        } else if (deleteThreadHttpResponseMessage.getRetType() == 1211067) {
                            if (FrsFragment.this.hlV == null) {
                                FrsFragment.this.hlV = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.hlV.zz(text);
                            FrsFragment.this.hlV.a(R.string.know, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.29.2
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.hlV.ig(false);
                            FrsFragment.this.hlV.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.hlV.bhg();
                        } else {
                            FrsFragment.this.hSP.aL(deleteThreadHttpResponseMessage.getText(), ContextCompat.getColor(FrsFragment.this.getContext(), deleteThreadHttpResponseMessage.getRetType() == 1 ? R.color.nav_bar_tip_error : R.color.cp_link_tip_a_alpha95));
                        }
                        if (z && frsNewAreaFragment != null) {
                            frsNewAreaFragment.cP(deleteThreadHttpResponseMessage.getSuccessItems());
                        }
                        FrsFragment.this.cD(deleteThreadHttpResponseMessage.getSuccessItems());
                        b.ckS().cC(deleteThreadHttpResponseMessage.getSuccessItems());
                        for (com.baidu.adp.widget.ListView.q qVar : FrsFragment.this.hSn.getThreadList()) {
                            if (qVar instanceof bv) {
                                i3++;
                                continue;
                            }
                            if (i3 >= 6) {
                                break;
                            }
                        }
                        if (i3 < 6) {
                            FrsFragment.this.bFD();
                            return;
                        }
                        return;
                    }
                    com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getActivity(), deleteThreadHttpResponseMessage.getErrorString());
                }
            }
        });
        this.dhe = UtilHelper.getScreenHeight(getActivity());
        this.hasInit = true;
        wT(1);
        super.onActivityCreated(bundle);
        this.createTime = System.currentTimeMillis() - j;
    }

    public void of(boolean z) {
        if (this.hTk != null) {
            this.hTk.ivj = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cD(List<String> list) {
        if (!com.baidu.tbadk.core.util.y.isEmpty(list)) {
            ArrayList<com.baidu.adp.widget.ListView.q> threadList = this.hSn.getThreadList();
            if (!com.baidu.tbadk.core.util.y.isEmpty(threadList) && this.hSP.getListView() != null && this.hSP.getListView().getData() != null) {
                Iterator<com.baidu.adp.widget.ListView.q> it = threadList.iterator();
                List<com.baidu.adp.widget.ListView.q> data = this.hSP.getListView().getData();
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.q next = it.next();
                    if (next instanceof bv) {
                        bw bwVar = ((bv) next).dUS;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= list.size()) {
                                break;
                            } else if (!com.baidu.tbadk.core.util.at.equals(list.get(i2), bwVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.hTt.d(next);
                                this.hSP.getListView().getAdapter().notifyItemRemoved(i);
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
    public void ckQ() {
        if (!com.baidu.tbadk.core.util.y.isEmpty(com.baidu.tieba.frs.a.ckL().ckP()) && this.hSP.getListView() != null && this.hSP.getListView().getData() != null) {
            ArrayList<com.baidu.adp.widget.ListView.q> threadList = this.hSn.getThreadList();
            if (!com.baidu.tbadk.core.util.y.isEmpty(threadList)) {
                Iterator<com.baidu.adp.widget.ListView.q> it = threadList.iterator();
                List<com.baidu.adp.widget.ListView.q> data = this.hSP.getListView().getData();
                int count = com.baidu.tbadk.core.util.y.getCount(com.baidu.tieba.frs.a.ckL().ckP());
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.q next = it.next();
                    if (next instanceof bv) {
                        bw bwVar = ((bv) next).dUS;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= count) {
                                break;
                            } else if (!com.baidu.tbadk.core.util.at.equals(com.baidu.tieba.frs.a.ckL().ckP().get(i2).getId(), bwVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.hTt.d(next);
                                this.hSP.getListView().getAdapter().notifyItemRemoved(i);
                                break;
                            }
                        }
                    }
                    i++;
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void bFY() {
        if (isAdded() && this.fGI && !isLoadingViewAttached()) {
            showLoadingView(this.hSP.bZb(), true);
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void bFZ() {
        if (isAdded() && this.fGI && isLoadingViewAttached()) {
            hideLoadingView(this.hSP.bZb());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (cmz()) {
            showLoadingView(this.hSP.bZb(), true);
            this.hSP.xh(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.hTi.Q(3, true);
            blc().scrollToPosition(0);
        }
    }

    private void wT(int i) {
        String str = "";
        if (this.hSn != null && this.hSn.getForum() != null) {
            str = this.hSn.getForum().getId();
        }
        if (!StringUtils.isNull(str)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13008").dD("fid", str).dD("obj_type", "4").ai("obj_locate", i).dD("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.aa aaVar) {
        if (aaVar != null) {
            this.eVC = aaVar.bvG();
            this.hTA = aaVar.bvH();
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void showFloatingView() {
        if (this.eVC != null) {
            this.eVC.showFloatingView(true);
        }
    }

    private void U(Intent intent) {
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
                this.hSH = uri.getQueryParameter("name");
                this.mFrom = uri.getQueryParameter("from");
                if (!StringUtils.isNull(this.hSH)) {
                    intent.putExtra("name", this.hSH);
                }
                if (!StringUtils.isNull(this.mFrom)) {
                    intent.putExtra("from", this.mFrom);
                }
                TiebaStatic.log(TbadkCoreStatisticKey.AS_INVOKE_TIEBA);
            }
            if (StringUtils.isNull(this.hSH) && uri != null) {
                if (com.baidu.tbadk.BdToken.f.p(uri)) {
                    com.baidu.tbadk.BdToken.f.aYL().b(uri, this.hUv);
                } else {
                    com.baidu.tieba.frs.f.d X = com.baidu.tieba.frs.f.i.X(intent);
                    if (X != null) {
                        this.hSH = X.forumName;
                        if (X.isN == null || X.isN.equals("aidou")) {
                        }
                    }
                }
                if (!StringUtils.isNull(this.hSH)) {
                    intent.putExtra("name", this.hSH);
                }
                intent.putExtra(FrsActivityConfig.FRS_CALL_FROM, 12);
            }
        }
    }

    /* renamed from: com.baidu.tieba.frs.FrsFragment$30  reason: invalid class name */
    /* loaded from: classes16.dex */
    class AnonymousClass30 implements f.a {
        AnonymousClass30() {
        }

        @Override // com.baidu.tbadk.BdToken.f.a
        public void z(final HashMap<String, Object> hashMap) {
            if (hashMap != null) {
                if (hashMap.get(com.baidu.tbadk.BdToken.f.dPf) instanceof String) {
                    FrsFragment.this.hSH = (String) hashMap.get(com.baidu.tbadk.BdToken.f.dPf);
                }
                if ((hashMap.get(com.baidu.tbadk.BdToken.f.dPx) instanceof String) && !TextUtils.isEmpty((String) hashMap.get(com.baidu.tbadk.BdToken.f.dPx))) {
                    com.baidu.adp.lib.f.e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.30.1
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsFragment.this.hTk.yU(301);
                            final long j = com.baidu.adp.lib.f.b.toLong((String) hashMap.get(com.baidu.tbadk.BdToken.f.dPg), 0L);
                            final int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
                            final int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
                            final float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                            final int i = 1;
                            if (com.baidu.tbadk.core.util.au.bjr().bjs()) {
                                i = 2;
                            }
                            com.baidu.adp.lib.f.e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.30.1.1
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
        this.hSO = getVoiceManager();
        if (this.hSO != null) {
            this.hSO.onStart(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        Intent intent;
        long j = 0;
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.eCs);
        if (bundle != null) {
            this.hSH = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            j = bundle.getLong(FrsActivityConfig.FRS_FAKE_THREAD_ID, 0L);
        } else if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
            this.hSH = intent.getStringExtra("name");
            this.mFrom = intent.getStringExtra("from");
            this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
            j = intent.getLongExtra(FrsActivityConfig.FRS_FAKE_THREAD_ID, 0L);
        }
        if (getArguments() != null) {
            this.hSI = getArguments().getBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, false);
        }
        if (TextUtils.isEmpty(this.mFrom) || FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
        }
        if (this.mIsLogin) {
            registerListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL, this.eCs);
        }
        this.hTj.aq(bundle);
        eG(j);
    }

    private void eG(final long j) {
        if (j > 0) {
            final int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
            final int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
            final float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            final int i = 1;
            if (com.baidu.tbadk.core.util.au.bjr().bjs()) {
                i = 2;
            }
            com.baidu.adp.lib.f.e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.35
                @Override // java.lang.Runnable
                public void run() {
                    RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                    requestGetMyPostNetMessage.setParams(j, 0L, 0L, equipmentWidth, equipmentHeight, f, i);
                    requestGetMyPostNetMessage.setTag(FrsFragment.this.getUniqueId());
                    MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
                }
            }, 1000L);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.s.c.dvE().B(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.hUC);
        this.hTu.destroy();
        hST = null;
        if (this.hSO != null) {
            this.hSO.onDestory(getPageContext());
        }
        com.baidu.tieba.recapp.report.a.remove("FRS");
        this.hSO = null;
        com.baidu.tieba.card.s.cbX().nk(false);
        if (this.hSn != null && this.hSn.getForum() != null) {
            ak.coa().eH(com.baidu.adp.lib.f.b.toLong(this.hSn.getForum().getId(), 0L));
        }
        if (this.hTw != null) {
            this.hTw.onDestory();
        }
        if (this.hSP != null) {
            com.baidu.tieba.frs.f.h.a(this.hSP, this.hSn, getForumId(), false, null);
            this.hSP.onDestroy();
        }
        if (this.hSS != null) {
            this.hSS.removeAllViews();
            this.hSS.setVisibility(8);
        }
        if (this.hTQ != null) {
            this.hTQ.cancel();
        }
        if (this.hTR != null) {
            com.baidu.adp.lib.f.e.mS().removeCallbacks(this.hTR);
        }
        this.hTP = null;
        super.onDestroy();
        try {
            if (this.hTc != null) {
                this.hTc.buf();
            }
            if (this.hSP != null) {
                this.hSP.release();
            }
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.hTj.crq();
        Looper.myQueue().removeIdleHandler(this.hTV);
        if (this.hTi != null) {
            this.hTi.bLO();
        }
        if (this.hTo != null) {
            this.hTo.coi();
        }
        if (this.hTr != null) {
            this.hTr.destory();
        }
        if (this.hTm != null) {
            this.hTm.onDestroy();
        }
        if (this.hTC != null) {
            this.hTC.onDestory();
        }
        if (this.hTv != null) {
            this.hTv.onDestroy();
        }
        if (this.hTE != null) {
            this.hTE.onDestroy();
        }
        if (this.hTF != null) {
            this.hTF.onDestroy();
        }
        com.baidu.tieba.recapp.d.a.dnW().dnZ();
        com.baidu.tieba.frs.f.j.csO();
        if (this.hTk != null) {
            this.hTk.a((FrsTabViewController.a) null);
            this.hTk.ctV();
        }
        if (this.hTI != null) {
            this.hTI.onDestroy();
        }
        b.ckS().a(null);
        com.baidu.tieba.frs.a.ckL().a(null);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.hSH);
        bundle.putString("from", this.mFrom);
        this.hTi.onSaveInstanceState(bundle);
        if (this.hSO != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            this.hSO.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.hTv != null) {
            this.hTv.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.hSP != null) {
            this.hSP.cne();
            this.hSP.onResume();
        }
        this.hTl.oZ(true);
        this.hTd = true;
        if (hSG) {
            hSG = false;
            if (this.hSP != null) {
                this.hSP.startPullRefresh();
                return;
            }
            return;
        }
        if (this.hSO != null) {
            this.hSO.onResume(getPageContext());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_RESUME));
        if (this.hSP != null) {
            this.hSP.or(false);
        }
        if (this.hTD) {
            refresh(6);
            this.hTD = false;
        }
        if (this.hTM != null && getActivity() != null) {
            if (NotificationManagerCompat.from(getActivity()).areNotificationsEnabled()) {
                com.baidu.tbadk.coreExtra.messageCenter.f.boT().setSignAlertOn(true);
                com.baidu.tbadk.coreExtra.messageCenter.f.boT().setSignAlertTime(this.hTM.getHours(), this.hTM.getMinutes());
                if (this.hSP != null) {
                    com.baidu.tbadk.coreExtra.messageCenter.f.boT().a(getTbPageContext().getPageActivity(), this.hSP.bZb());
                }
            }
            this.hTM = null;
        }
        cmG();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
    }

    public boolean cmj() {
        Intent intent;
        if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
            return false;
        }
        return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
    }

    public void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.hSH = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.hSJ = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.hSJ) {
                cmk();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmk() {
        this.hSP.startPullRefresh();
    }

    public void closeActivity() {
        com.baidu.tieba.frs.f.i.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.mFrom);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.hSP.setTitle(this.hSH);
        } else {
            this.hSP.setTitle("");
            this.mFlag = 1;
        }
        this.hSP.a(this.hUA);
        this.hSP.addOnScrollListener(this.mScrollListener);
        this.hSP.g(this.hPZ);
        this.hSP.cnr().a(this.hUz);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hTK) {
            this.hSP.onChangeSkinType(i);
            this.hTj.yK(i);
            this.hTk.onChangeSkinType(i);
            if (this.hSR != null) {
                this.hSR.onChangeSkinType(i);
            }
            if (this.hTB != null) {
                this.hTB.onChangeSkinType();
            }
            if (this.hTG != null) {
                this.hTG.onChangeSkinType(getPageContext(), i);
            }
            if (this.hlV != null) {
                com.baidu.tbadk.r.a.a(getPageContext(), this.hlV.getRealView());
            }
            if (this.hTC != null) {
                this.hTC.onChangeSkinType(getPageContext(), i);
            }
        }
    }

    public void wU(int i) {
        if (!this.mIsLogin) {
            if (this.hSn != null && this.hSn.getAnti() != null) {
                this.hSn.getAnti().setIfpost(1);
            }
            if (i == 0) {
                com.baidu.tbadk.core.util.bg.skipToLoginActivity(getActivity());
            }
        } else if (this.hSn != null) {
            if (i == 0) {
                com.baidu.tieba.frs.f.j.g(this, 0);
            } else {
                this.hSP.cng();
            }
        }
    }

    public void refresh() {
        com.baidu.tieba.a.d.bAA().Di("page_frs");
        refresh(3);
    }

    public void refresh(int i) {
        this.hTa = false;
        cmr();
        if (this.hSP != null && this.hSP.cmV() != null) {
            this.hSP.cmV().cxp();
        }
        if (this.hTi != null) {
            this.hTi.Q(i, true);
        }
    }

    private void cml() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.f.h.mT().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.36
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.QR(FrsFragment.this.hSH);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmm() {
        cmr();
        try {
            if (this.hSn != null) {
                this.hSP.bLs();
                this.hSP.ok(cmF());
                if (!com.baidu.tieba.frs.vc.h.m(this.hSn) || !com.baidu.tieba.frs.vc.h.l(this.hSn)) {
                }
                if (this.hSn.getForum() != null) {
                    this.hSH = this.hSn.getForum().getName();
                    this.forumId = this.hSn.getForum().getId();
                }
                if (this.hSn.getPage() != null) {
                    setHasMore(this.hSn.getPage().bdu());
                }
                this.hSP.setTitle(this.hSH);
                this.hSP.setForumName(this.hSH);
                TbadkCoreApplication.getInst().setDefaultBubble(this.hSn.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.hSn.getUserData().getBimg_end_time());
                cml();
                cmn();
                ArrayList<com.baidu.adp.widget.ListView.q> threadList = this.hSn.getThreadList();
                if (threadList != null) {
                    this.hSP.a(threadList, this.hSn);
                    com.baidu.tieba.frs.f.c.A(this.hSP);
                    this.hTj.yL(getPageNum());
                    this.hTj.i(this.hSn);
                    this.hTk.a(this.hSn, this.hTi.crW());
                    this.hSP.cnh();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void cmn() {
        if (this.hSn != null) {
            if (this.hSn.getIsNewUrl() == 1) {
                this.hSP.cnr().setFromCDN(true);
            } else {
                this.hSP.cnr().setFromCDN(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.hTl.oZ(false);
        this.hTd = false;
        this.hSP.onPause();
        if (this.hSO != null) {
            this.hSO.onPause(getPageContext());
        }
        this.hSP.or(true);
        if (this.hTr != null) {
            this.hTr.csR();
        }
        com.baidu.tbadk.BdToken.c.aYs().aYC();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.hTk != null && this.hTk.ctT() != null && (this.hTk.ctT().fragment instanceof BaseFragment)) {
            ((BaseFragment) this.hTk.ctT().fragment).setPrimary(z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.s.cbX().nk(false);
        od(false);
        if (this.hSn != null && this.hSn.getForum() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            com.baidu.tbadk.distribute.a.bri().b(getPageContext().getPageActivity(), "frs", this.hSn.getForum().getId(), 0L);
        }
        if (this.hSO != null) {
            this.hSO.onStop(getPageContext());
        }
        if (blc() != null) {
            blc().getRecycledViewPool().clear();
        }
        this.hTj.bkq();
        com.baidu.tbadk.util.ab.bvJ();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            if (this.hTj != null) {
                this.hTj.bJ(isPrimary());
            }
            if (this.hSP != null) {
                this.hSP.bJ(isPrimary());
                this.hSP.or(!isPrimary());
            }
        }
    }

    private void cmo() {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.nw(2);
        aVar.ig(false);
        FrsBroadcastCopyGuideDialogView frsBroadcastCopyGuideDialogView = new FrsBroadcastCopyGuideDialogView(getPageContext().getPageActivity());
        frsBroadcastCopyGuideDialogView.setConfirmButtonListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.37
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aVar != null) {
                    aVar.dismiss();
                    FrsFragment.this.cmp();
                }
            }
        });
        aVar.aX(frsBroadcastCopyGuideDialogView);
        aVar.b(getPageContext()).bhg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmp() {
        if (KuangFloatingFrsCopyLinkViewController.getInstance().init()) {
            ((BaseFragmentActivity) getPageContext().getOrignalPage()).grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.frs.FrsFragment.38
                @Override // com.baidu.tbadk.core.e
                public void onPermissionResult(boolean z) {
                    if (!z) {
                        new BdTopToast(FrsFragment.this.getContext()).wS(false).Sp(FrsFragment.this.getContext().getString(R.string.forum_broadcast_copy_no_permission_hint)).aE(FrsFragment.this.hSP.bZb());
                        return;
                    }
                    KuangFloatingFrsCopyLinkViewController.getInstance().showFloatingView(true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                    if (FrsFragment.this.hSQ != null) {
                        FrsFragment.this.hSQ.setVisibility(8);
                    }
                }
            }, true);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (b.ckS().ckM()) {
                b.ckS().reset();
                return true;
            } else if (com.baidu.tieba.frs.a.ckL().ckM()) {
                if (this.hSP != null && this.hSP.cnw()) {
                    this.hSP.cnx();
                    return true;
                }
                com.baidu.tieba.frs.a.ckL().reset();
                return true;
            } else if (this.hSP != null) {
                return this.hSP.cnd();
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
        com.baidu.tbadk.distribute.a.bri().a(advertAppInfo, this.forumId, 0L, "FRS", str, getPn());
    }

    @Override // com.baidu.tieba.recapp.n
    public void cmq() {
        clN().cmq();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.hSO == null) {
            this.hSO = VoiceManager.instance();
        }
        return this.hSO;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdRecyclerView blc() {
        if (this.hSP == null) {
            return null;
        }
        return this.hSP.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void cmr() {
        if (this.hSO != null) {
            this.hSO.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> bld() {
        if (this.evp == null) {
            this.evp = UserIconBox.u(getPageContext().getPageActivity(), 8);
        }
        return this.evp;
    }

    public void cms() {
        if (getFragmentActivity() != null && getFragmentActivity().getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.t onGetPreLoadListView() {
        return blc().getPreLoadHandle();
    }

    @Override // com.baidu.tieba.frs.at
    public NavigationBar bJH() {
        if (this.hSP == null) {
            return null;
        }
        return this.hSP.bJH();
    }

    public FRSRefreshButton cmt() {
        return this.hSR;
    }

    public void c(LinearLayout linearLayout) {
        if (linearLayout != null) {
            this.hSS = linearLayout;
        }
    }

    public void a(FRSRefreshButton fRSRefreshButton) {
        if (fRSRefreshButton != null) {
            this.hSR = fRSRefreshButton;
            this.hSR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.44
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (FrsFragment.this.hTk != null) {
                        FrsTabViewController.b ctT = FrsFragment.this.hTk.ctT();
                        if (ctT != null && ctT.fragment != null && (ctT.fragment instanceof as)) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                            ((as) ctT.fragment).clz();
                            ((as) ctT.fragment).bGQ();
                            return;
                        }
                        FrsFragment.this.clS().startPullRefresh();
                    }
                }
            });
        }
    }

    public void cmu() {
        if (this.hSR != null) {
            this.hSR.hide();
        }
    }

    public void cmv() {
        if (this.hSR != null) {
            this.hSR.show();
        }
    }

    /* loaded from: classes16.dex */
    private final class a implements com.baidu.adp.widget.ListView.ab {
        private a() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.ab
        public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null) {
                if (bdUniqueId == w.hWE) {
                    if (FrsFragment.this.hSP != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11752").dD("fid", FrsFragment.this.forumId).dD("obj_locate", "1"));
                        FrsFragment.this.hSP.startPullRefresh();
                    }
                } else if (qVar != null && (qVar instanceof bv)) {
                    bw bwVar = ((bv) qVar).dUS;
                    if (bwVar.bfE() == null || bwVar.bfE().getGroup_id() == 0 || com.baidu.tbadk.core.util.bg.checkUpIsLogin(FrsFragment.this.getActivity())) {
                        if (bwVar.bfr() != 1 || com.baidu.tbadk.core.util.bg.checkUpIsLogin(FrsFragment.this.getActivity())) {
                            if (bwVar.beQ() != null) {
                                if (com.baidu.tbadk.core.util.bg.checkUpIsLogin(FrsFragment.this.getActivity())) {
                                    String postUrl = bwVar.beQ().getPostUrl();
                                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.isNetOk()) {
                                        com.baidu.tbadk.browser.a.startInternalWebActivity(FrsFragment.this.getActivity(), postUrl);
                                    }
                                }
                            } else if (bwVar.bfP() != null) {
                                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                    com.baidu.tbadk.core.util.bg.skipToLoginActivity(FrsFragment.this.getPageContext().getPageActivity());
                                    return;
                                }
                                com.baidu.tbadk.core.data.r bfP = bwVar.bfP();
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), bfP.getCartoonId(), bfP.getChapterId(), 2)));
                            } else {
                                com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                                if (readThreadHistory != null && !readThreadHistory.QX(bwVar.getId())) {
                                    readThreadHistory.QW(bwVar.getId());
                                }
                                boolean z = false;
                                final String beK = bwVar.beK();
                                if (beK != null && !beK.equals("")) {
                                    z = true;
                                    new Thread(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.a.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            com.baidu.tbadk.core.util.aa aaVar = new com.baidu.tbadk.core.util.aa(beK);
                                            aaVar.biQ().bjv().mIsNeedAddCommenParam = false;
                                            aaVar.biQ().bjv().mIsUseCurrentBDUSS = false;
                                            aaVar.getNetData();
                                        }
                                    }).start();
                                }
                                String tid = bwVar.getTid();
                                if (tid == null) {
                                    tid = "";
                                }
                                if (bwVar.bez() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                    com.baidu.tbadk.core.util.be.bju().b(FrsFragment.this.getPageContext(), new String[]{tid, "", null});
                                    return;
                                }
                                if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && tid.length() > 4) {
                                    bwVar.setId(tid.substring(3));
                                }
                                if (bdUniqueId.getId() == bw.ecR.getId()) {
                                    com.baidu.tieba.frs.f.h.a(bwVar.bek());
                                } else if (bdUniqueId.getId() == bw.ebs.getId()) {
                                    com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                                    aqVar.dD("obj_type", "2");
                                    aqVar.dD("tid", bwVar.getTid());
                                    TiebaStatic.log(aqVar);
                                }
                                com.baidu.tieba.frs.f.i.a(FrsFragment.this, bwVar, i, z);
                                com.baidu.tieba.frs.f.h.a(FrsFragment.this, FrsFragment.this.hSn, bwVar);
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
            hideNetRefreshView(this.hSP.bZb());
            showLoadingView(this.hSP.bZb(), true);
            this.hSP.on(false);
            this.hTi.Q(3, true);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData cmw() {
        return this.hSn;
    }

    public boolean cmx() {
        return this.hSP.cmx();
    }

    public void aC(Object obj) {
        if (this.hTn != null && this.hTn.ioj != null) {
            this.hTn.ioj.callback(obj);
        }
    }

    public void aD(Object obj) {
        if (this.hTn != null && this.hTn.iok != null) {
            this.hTn.iok.callback(obj);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        this.hSP.getListView().stopScroll();
        if (!this.hSP.cnn()) {
            if (!com.baidu.adp.lib.util.l.isNetOk()) {
                this.hSP.bGT();
            } else if (this.hTi.crR() == 1) {
                bFS();
                bFD();
            } else if (this.hTi.hasMore()) {
                bFD();
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void onFailed(String str) {
        bFS();
        showToast(str);
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void au(ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        boolean isEmpty = com.baidu.tbadk.core.util.y.isEmpty(arrayList);
        setHasMore(isEmpty ? 0 : 1);
        bFS();
        if (!isEmpty) {
            if (!this.hTi.csb() && TbadkCoreApplication.getInst().isRecAppExist() && this.hTi.crR() == 1) {
                this.hSn.addRecommendAppToThreadList(this, arrayList);
            }
            if (this.hTi != null) {
                com.baidu.tieba.frs.d.a.a(getUniqueId(), arrayList, this.hSn.getForum(), this.hTi.getSortType());
            }
            ArrayList<com.baidu.adp.widget.ListView.q> a2 = this.hTt.a(false, false, arrayList, this.hSL, false);
            if (a2 != null) {
                this.hSn.setThreadList(a2);
                this.hSP.a(a2, this.hSn);
            }
            if (this.hTi != null) {
                com.baidu.tieba.frs.d.c.a(this.hSn, this.hTi.crW(), 2, getContext());
            }
        }
    }

    private void bFS() {
        if (clT() == 1 || this.hTt.cO(this.hSn.getThreadListIds())) {
            if (com.baidu.tbadk.core.util.y.getCount(this.hSn.getThreadList()) > 3) {
                this.hSP.bGR();
            } else {
                this.hSP.cnu();
            }
        } else if (com.baidu.tbadk.core.util.y.isEmpty(this.hSn.getThreadList())) {
            this.hSP.bGT();
        } else {
            this.hSP.bGS();
        }
    }

    @Override // com.baidu.tieba.frs.mc.l
    public void bFD() {
        if (this.hTt != null) {
            this.hTt.a(this.hSH, this.forumId, this.hSn);
        }
    }

    public void cmy() {
        if (!com.baidu.tbadk.core.util.ae.requestWriteExternalStorgeAndCameraPermission(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.ao.g(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment, com.baidu.m.a.a.InterfaceC0210a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        com.baidu.tieba.frs.f.i.a(this, i, strArr, iArr);
    }

    public void og(boolean z) {
        if (this.hTo != null) {
            this.hTo.oA(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.hTp.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a rQ(int i) {
        return this.hTp.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        this.hTx.b(bVar);
    }

    public boolean cmz() {
        return this.hSD;
    }

    @Override // com.baidu.tieba.frs.aq
    public void OA() {
        if (this.hSP != null) {
            showFloatingView();
            this.hSP.getListView().scrollToPosition(0);
            this.hSP.startPullRefresh();
        }
    }

    public ForumWriteData cmA() {
        if (this.hSn == null || this.hSn.getForum() == null) {
            return null;
        }
        ForumData forum = this.hSn.getForum();
        ForumWriteData forumWriteData = new ForumWriteData(forum.getId(), forum.getName(), forum.getPrefixData(), this.hSn.getAnti());
        forumWriteData.avatar = forum.getImage_url();
        forumWriteData.forumLevel = forum.getUser_level();
        forumWriteData.specialForumType = forum.special_forum_type;
        forumWriteData.firstDir = forum.getFirst_class();
        forumWriteData.secondDir = forum.getSecond_class();
        UserData userData = this.hSn.getUserData();
        forumWriteData.privateThread = userData != null ? userData.getPrivateThread() : 0;
        forumWriteData.frsTabInfo = cmB();
        return forumWriteData;
    }

    private FrsTabInfoData cmB() {
        int i;
        if (this.hTi == null || this.hSn == null || this.hTk == null) {
            return null;
        }
        if (this.hSn.getEntelechyTabInfo() == null || com.baidu.tbadk.core.util.y.isEmpty(this.hSn.getEntelechyTabInfo().tab)) {
            return null;
        }
        int ctX = this.hTk.ctX();
        if (ctX == 502) {
            return null;
        }
        int i2 = -1;
        ArrayList arrayList = new ArrayList();
        Iterator<FrsTabInfo> it = this.hSn.getEntelechyTabInfo().tab.iterator();
        while (true) {
            i = i2;
            if (!it.hasNext()) {
                break;
            }
            FrsTabInfo next = it.next();
            if (next != null && next.is_general_tab.intValue() == 1) {
                arrayList.add(new FrsTabItemData(next));
                if (ctX == next.tab_id.intValue()) {
                    i2 = ctX;
                }
            }
            i2 = i;
        }
        if (com.baidu.tbadk.core.util.y.isEmpty(arrayList)) {
            return null;
        }
        FrsTabInfoData frsTabInfoData = new FrsTabInfoData();
        frsTabInfoData.tabList = arrayList;
        frsTabInfoData.selectedTabId = i;
        return frsTabInfoData;
    }

    @Override // com.baidu.tieba.frs.aq
    public void bkF() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void oh(boolean z) {
        this.hTe = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z) {
        this.hSP.xc(8);
        ((FrsActivity) getActivity()).showLoadingView(view, z);
        ((FrsActivity) getActivity()).i(view, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        this.hSP.xc(0);
        ((FrsActivity) getActivity()).hideLoadingView(view);
        ((FrsActivity) getActivity()).i(view, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        super.showNetRefreshView(view, getResources().getString(R.string.refresh_view_title_text), null, getResources().getString(R.string.refresh_view_button_text), z, getNetRefreshListener());
        this.hSP.xc(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshViewNoClick(View view, String str, boolean z) {
        super.showNetRefreshViewNoClick(view, str, z);
        this.hSP.xc(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        super.hideNetRefreshView(view);
        this.hSP.xc(0);
    }

    public void cmC() {
        FrsTabViewController.b ctT;
        if (this.hTk != null && (ctT = this.hTk.ctT()) != null && ctT.fragment != null && (ctT.fragment instanceof as)) {
            ((as) ctT.fragment).clz();
        }
    }

    public void oi(boolean z) {
        this.hSF = z;
    }

    public void b(OvalActionButton ovalActionButton) {
        this.hSQ = ovalActionButton;
    }

    public OvalActionButton cmD() {
        return this.hSQ;
    }

    public boolean cmE() {
        return this.hSF;
    }

    public void onShareSuccess(String str) {
        if (TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.util.at.isEmpty(str)) {
            if (this.hTI == null) {
                this.hTI = new AddExperiencedModel(getTbPageContext());
            }
            this.hTI.fJ(this.forumId, str);
        }
    }

    public boolean cmF() {
        if (this.hTe && !this.hTL) {
            return (this.hTi != null && this.hTi.crS() && (b.ckS().ckM() || com.baidu.tieba.frs.a.ckL().ckM())) ? false : true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.f.b
    public boolean videoNeedPreload() {
        if (this.hSn != null) {
            return com.baidu.tbadk.util.ah.qL(2) || (com.baidu.tbadk.util.ah.bvP() && this.hSn.isFrsVideoAutoPlay);
        }
        return super.videoNeedPreload();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmG() {
        if (!com.baidu.tbadk.core.util.at.isEmpty(this.forumId)) {
            com.baidu.tbadk.BdToken.c.aYs().q(com.baidu.tbadk.BdToken.b.dNG, com.baidu.adp.lib.f.b.toLong(this.forumId, 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmH() {
        String format;
        String str;
        if (isResumed() && this.hTP != null && this.hTP.size() >= 1 && this.hTO <= this.hTP.size() - 1) {
            final LiveHorseRaceData liveHorseRaceData = this.hTP.get(this.hTO);
            if (System.currentTimeMillis() / 1000 >= liveHorseRaceData.getRob_end_tm().longValue()) {
                this.hTO++;
                cmH();
            }
            if (this.hSS != null) {
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
                        if (FrsFragment.this.hSn == null) {
                            str2 = "";
                        } else if (FrsFragment.this.hSn.getForum() != null) {
                            str2 = FrsFragment.this.hSn.getForum().getName();
                        } else {
                            str2 = "";
                        }
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13744").ai("obj_source", 1).dD("fid", FrsFragment.this.forumId).dD("fname", str2));
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
                this.hTQ = ValueAnimator.ofFloat(1.0f, 0.0f);
                this.hTQ.setDuration(600L);
                this.hTQ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.FrsFragment.52
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        if (valueAnimator.isRunning()) {
                            frsRedpackRunView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                            frsRedpackRunView.setTranslationX(-(TbadkApplication.getInst().getContext().getResources().getDimensionPixelOffset(R.dimen.tbds850) * valueAnimator.getAnimatedFraction()));
                        }
                    }
                });
                this.hTQ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.FrsFragment.53
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        frsRedpackRunView.setAlpha(0.0f);
                        frsRedpackRunView.setTranslationY(TbadkApplication.getInst().getContext().getResources().getDimensionPixelOffset(R.dimen.tbds660));
                        frsRedpackRunView.hide();
                        FrsFragment.this.hSS.removeView(frsRedpackRunView);
                        if (FrsFragment.this.hTO > FrsFragment.this.hTP.size() - 1) {
                            FrsFragment.this.hSS.removeAllViews();
                            FrsFragment.this.hSS.setVisibility(8);
                            FrsFragment.this.hTO = 0;
                            return;
                        }
                        FrsFragment.this.cmH();
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        onAnimationEnd(animator);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                this.hTR = new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.54
                    @Override // java.lang.Runnable
                    public void run() {
                        if (FrsFragment.this.hSS != null && frsRedpackRunView != null) {
                            FrsFragment.this.hTQ.start();
                        }
                    }
                };
                com.baidu.adp.lib.f.e.mS().postDelayed(this.hTR, 5000L);
                if (this.hSS.getChildCount() == 0) {
                    this.hTO++;
                    this.hSS.addView(frsRedpackRunView);
                    if (this.hSn != null) {
                        str = this.hSn.getForum() != null ? this.hSn.getForum().getName() : "";
                    } else {
                        str = "";
                    }
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13743").ai("obj_source", 1).dD("fid", this.forumId).dD("fname", str));
                }
                if (this.hSS.getVisibility() == 8 && ((BaseFragment) this.hTk.ctT().fragment).isPrimary() && !this.hSP.cnD() && !this.hSY) {
                    this.hSS.setVisibility(0);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        FrsTabViewController.b ctT;
        if (clQ() == null || (ctT = clQ().ctT()) == null || !(ctT.fragment instanceof BaseFragment)) {
            return null;
        }
        if (ctT.fragment instanceof FrsAllThreadFragment) {
            TbPageTag tbPageTag = super.getTbPageTag();
            int i = -1;
            if (this.hSn != null) {
                i = this.hSn.getSortType();
            }
            tbPageTag.sortType = com.baidu.tieba.frs.f.g.yI(i);
            tbPageTag.locatePage = "a070";
            if (this.hSA.equals(ctT.title)) {
                tbPageTag.locatePage = "a071";
            }
            return tbPageTag;
        } else if (ctT.fragment instanceof FrsFragment) {
            return null;
        } else {
            return ((BaseFragment) ctT.fragment).getTbPageTag();
        }
    }

    public void cmI() {
        if (this.hSn != null) {
            com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
            if (this.hSn.needLog == 1) {
                bVar.iqT = true;
            } else {
                bVar.iqT = false;
            }
            if (this.hSn.getForum() != null) {
                bVar.iqV = this.hSn.getForum().getId();
            }
            if (clN() != null) {
                bVar.iqU = clN().crW();
            }
            if (com.baidu.tieba.frs.d.d.icL != null) {
                bVar.iqW = com.baidu.tieba.frs.d.d.icL.iqW;
                bVar.iqX = com.baidu.tieba.frs.d.d.icL.iqX;
            }
            this.hTS = new com.baidu.tieba.frs.live.b(bVar, getTbPageTag(), getUniqueId());
            this.hTS.yl(this.hTU);
            CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_CARD_CLICK, this.hTS);
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
            CustomMessageTask customMessageTask2 = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW, this.hTS);
            customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask2);
            CustomMessageTask customMessageTask3 = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_USER_CLICK, this.hTS);
            customMessageTask3.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask3);
            CustomMessageTask customMessageTask4 = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_VIDEO_CLICK, this.hTS);
            customMessageTask4.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask4);
        }
    }
}
