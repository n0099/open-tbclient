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
    public static com.baidu.tieba.tbadkCore.m hSZ;
    private com.baidu.tbadk.util.z eVG;
    private com.baidu.adp.lib.d.b<TbImageView> evt;
    private com.baidu.tieba.frs.gametab.b fXN;
    private com.baidu.tieba.frs.entelechy.a hSH;
    private com.baidu.tieba.tbadkCore.data.f hSR;
    private VoiceManager hSU;
    private OvalActionButton hSW;
    private FRSRefreshButton hSX;
    private LinearLayout hSY;
    private com.baidu.tieba.frs.vc.j hTA;
    private com.baidu.tieba.frs.mc.a hTB;
    private com.baidu.tieba.frs.live.a hTC;
    private p hTD;
    public com.baidu.tieba.frs.vc.c hTE;
    private com.baidu.tieba.frs.mc.e hTF;
    private View.OnTouchListener hTG;
    private com.baidu.tieba.frs.view.a hTH;
    private com.baidu.tieba.frs.vc.e hTI;
    private boolean hTJ;
    private com.baidu.tieba.NEGFeedBack.a hTK;
    private com.baidu.tieba.ala.a hTL;
    private com.baidu.tieba.frs.brand.buttommenu.a hTM;
    private com.baidu.tieba.frs.sportspage.notification.a hTN;
    private AddExperiencedModel hTO;
    private boolean hTQ;
    private List<LiveHorseRaceData> hTV;
    private ValueAnimator hTW;
    private Runnable hTX;
    private com.baidu.tieba.frs.live.b hTY;
    private com.baidu.tieba.frs.broadcast.a hTZ;
    public long hTa;
    private String hTl;
    private com.baidu.card.al hTn;
    private FrsModelController hTo;
    private com.baidu.tieba.frs.vc.h hTp;
    private FrsTabViewController hTq;
    private com.baidu.tieba.frs.mc.h hTr;
    private com.baidu.tieba.frs.smartsort.a hTs;
    private com.baidu.tieba.frs.mc.b hTt;
    private ax hTu;
    private com.baidu.tieba.frs.entelechy.b.b hTw;
    private com.baidu.tieba.frs.vc.a hTx;
    private com.baidu.tieba.frs.mc.d hTy;
    private com.baidu.tieba.frs.mc.c hTz;
    private int hUa;
    private int hUk;
    private com.baidu.tbadk.core.dialog.a hlZ;
    private View mRootView;
    private String mSchemeUrl;
    public static boolean hSM = false;
    public static volatile long hTc = 0;
    public static volatile long hTd = 0;
    public static volatile int mNetError = 0;
    private String hSG = "";
    public boolean hSI = false;
    private boolean hSJ = false;
    private boolean hSK = false;
    private boolean hSL = true;
    public String hSN = null;
    public String mFrom = null;
    public int mFlag = 0;
    public boolean hSO = false;
    private boolean hSP = false;
    private String mThreadId = null;
    public String forumId = null;
    private int hSv = 0;
    private boolean hSQ = false;
    private boolean hSS = false;
    private boolean hST = false;
    private q hSV = null;
    public final bw ajz = null;
    private FrsViewData hSt = new FrsViewData();
    public long hvt = -1;
    public long eRX = 0;
    public long eRN = 0;
    public long createTime = 0;
    public long eRO = 0;
    public long eRU = 0;
    public long hTb = 0;
    boolean hTe = false;
    public boolean hTf = false;
    private boolean hTg = false;
    private boolean hTh = false;
    public com.baidu.tbadk.n.b hTi = null;
    private boolean hTj = true;
    private boolean hTk = true;
    private a.C0095a hTm = new a.C0095a(2);
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> hTv = new SparseArray<>();
    private boolean fGM = true;
    private boolean hasInit = false;
    private boolean hTP = false;
    private boolean hTR = false;
    private Date hTS = null;
    private int dhi = 0;
    private int hTT = 0;
    private int hTU = 0;
    public int mHeadLineDefaultNavTabId = -1;
    MessageQueue.IdleHandler hUb = new MessageQueue.IdleHandler() { // from class: com.baidu.tieba.frs.FrsFragment.1
        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            FrsFragment.this.cmh();
            return false;
        }
    };
    private final CustomMessageListener hUc = new CustomMessageListener(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED) { // from class: com.baidu.tieba.frs.FrsFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof bw) {
                    com.baidu.tieba.frs.f.h.a(FrsFragment.this.hSV, FrsFragment.this.hSt, FrsFragment.this.getForumId(), true, (bw) data);
                }
            }
        }
    };
    private CustomMessageListener hUd = new CustomMessageListener(CmdConfigCustom.CMD_CLOSE_GAME_RANK_CARD) { // from class: com.baidu.tieba.frs.FrsFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.hSt != null) {
                FrsFragment.this.hSt.removeGameRankListFromThreadList();
                if (FrsFragment.this.hSV != null) {
                    FrsFragment.this.hSV.aSD();
                }
            }
        }
    };
    private CustomMessageListener afP = new CustomMessageListener(2921401) { // from class: com.baidu.tieba.frs.FrsFragment.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && FrsFragment.this.hSX != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() <= 0 || FrsFragment.this.hTq.ctX() == 0 || FrsFragment.this.hTq.ctU() == null || !(FrsFragment.this.hTq.ctU().fragment instanceof BaseFragment) || !((BaseFragment) FrsFragment.this.hTq.ctU().fragment).isPrimary() || FrsFragment.this.hSV.cnE() || KuangFloatingFrsCopyLinkViewController.getInstance().isFloatCopyViewShow()) {
                    if (FrsFragment.this.hTq.ctX() != 0) {
                        FrsFragment.this.hSX.hide();
                        return;
                    }
                    return;
                }
                FrsFragment.this.hSX.show();
            }
        }
    };
    private CustomMessageListener hUe = new CustomMessageListener(2921473) { // from class: com.baidu.tieba.frs.FrsFragment.45
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && FrsFragment.this.hSX != null && FrsFragment.this.hSW != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() == 0) {
                    FrsFragment.this.hSX.setVisibility(8);
                    FrsFragment.this.hSW.setVisibility(8);
                    return;
                }
                FrsFragment.this.hSW.setVisibility(0);
            }
        }
    };
    private CustomMessageListener hUf = new CustomMessageListener(2921467) { // from class: com.baidu.tieba.frs.FrsFragment.56
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && FrsFragment.this.hSX != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() <= 0 || FrsFragment.this.hTq.ctU() == null || !(FrsFragment.this.hTq.ctU().fragment instanceof BaseFragment) || !((BaseFragment) FrsFragment.this.hTq.ctU().fragment).isPrimary() || FrsFragment.this.hSV.cnE()) {
                    FrsFragment.this.hSY.setVisibility(8);
                    FrsFragment.this.hTe = true;
                    return;
                }
                FrsFragment.this.hSY.setVisibility(0);
                FrsFragment.this.hTe = false;
            }
        }
    };
    private com.baidu.adp.framework.listener.a hUg = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_FRS_LIVE_HORSE_RACE_LIST, 309667) { // from class: com.baidu.tieba.frs.FrsFragment.61
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if ((responsedMessage instanceof GetLiveHorseRaceHttpResponseMessage) || (responsedMessage instanceof GetLiveHorseRaceSocketResponseMessage)) {
                    List<LiveHorseRaceData> arrayList = new ArrayList<>();
                    if (responsedMessage instanceof GetLiveHorseRaceHttpResponseMessage) {
                        arrayList = ((GetLiveHorseRaceHttpResponseMessage) responsedMessage).getData().coe();
                    }
                    if (responsedMessage instanceof GetLiveHorseRaceSocketResponseMessage) {
                        arrayList = ((GetLiveHorseRaceSocketResponseMessage) responsedMessage).getData().coe();
                    }
                    if (FrsFragment.this.hTV != null) {
                        if (FrsFragment.this.hSY.getVisibility() != 8) {
                            if (FrsFragment.this.hTU >= FrsFragment.this.hTV.size()) {
                                FrsFragment.this.hTV.addAll(arrayList);
                                return;
                            }
                            FrsFragment.this.hTV = FrsFragment.this.hTV.subList(0, FrsFragment.this.hTU);
                            FrsFragment.this.hTV.addAll(arrayList);
                            return;
                        }
                        FrsFragment.this.hTV = new ArrayList();
                        FrsFragment.this.hTV.addAll(arrayList);
                        FrsFragment.this.hTU = 0;
                        FrsFragment.this.cmI();
                        return;
                    }
                    FrsFragment.this.hTV = new ArrayList();
                    FrsFragment.this.hTU = 0;
                    FrsFragment.this.hTV.addAll(arrayList);
                    FrsFragment.this.cmI();
                }
            }
        }
    };
    private CustomMessageListener hUh = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.FrsFragment.62
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 1) {
                    FrsFragment.this.cml();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                }
            }
        }
    };
    private final av hUi = new av() { // from class: com.baidu.tieba.frs.FrsFragment.63
        @Override // com.baidu.tieba.frs.av
        public void a(int i, int i2, bd bdVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
            FrsFragment.this.clW();
            if (FrsFragment.this.hTw != null) {
                FrsFragment.this.hTp.pi(FrsFragment.this.hTw.xI(i));
            }
            com.baidu.tieba.tbadkCore.f fVar = new com.baidu.tieba.tbadkCore.f();
            if (bdVar != null) {
                fVar.isSuccess = bdVar.errCode == 0;
                fVar.errorCode = bdVar.errCode;
                fVar.errorMsg = bdVar.errMsg;
                if (fVar.isSuccess) {
                    if (com.baidu.tbadk.core.util.y.isEmpty(arrayList)) {
                        FrsFragment.this.hSV.bGU();
                    } else if (bdVar.hasMore) {
                        if (com.baidu.tbadk.core.util.y.getCount(FrsFragment.this.hSt.getThreadList()) > 3) {
                            FrsFragment.this.hSV.bGS();
                        } else {
                            FrsFragment.this.hSV.cnv();
                        }
                    } else if (bdVar.hXU) {
                        FrsFragment.this.hSV.bGT();
                    } else {
                        FrsFragment.this.hSV.bGU();
                    }
                }
            } else {
                bdVar = new bd();
                bdVar.pn = 1;
                bdVar.hasMore = false;
                bdVar.hXU = false;
            }
            if (i == 1) {
                FrsFragment.this.hTj = true;
                FrsFragment.this.hUz.a(FrsFragment.this.hTo.getType(), false, fVar);
            } else {
                FrsFragment.this.a(fVar);
                if (FrsFragment.this.hTo.crt() != null) {
                    FrsFragment.this.hSt = FrsFragment.this.hTo.crt();
                }
                FrsFragment.this.cmn();
            }
            if (FrsFragment.this.hUH != null) {
                FrsFragment.this.hUH.a(i, i2, bdVar, arrayList);
            }
        }
    };
    private FrsTabViewController.a hUj = new FrsTabViewController.a() { // from class: com.baidu.tieba.frs.FrsFragment.2
        @Override // com.baidu.tieba.frs.vc.FrsTabViewController.a
        public void ce(int i, int i2) {
            boolean z = false;
            if (i != 1) {
                com.baidu.tieba.card.s.cbY().nm(false);
                FrsFragment.this.of(false);
            }
            if (i == 502) {
                FrsFragment.this.hSW.setIconFade(R.drawable.btn_frs_professional_edit_n);
            } else {
                FrsFragment.this.hSW.setIconFade(0);
            }
            FrsFragment.this.hUk = i;
            FrsFragment.this.hUa = i2;
            if (FrsFragment.this.hTY != null) {
                FrsFragment.this.hTY.yl(FrsFragment.this.hUa);
            }
            TbSingleton.getInstance().setFrsCurTabType(FrsFragment.this.hUa);
            FrsFragment.this.cms();
            com.baidu.tieba.frs.d.d.icR.irc = i;
            com.baidu.tieba.frs.d.d.icR.irf = i2;
            com.baidu.tieba.frs.d.d.icR.ird = -1;
            b.ckT().R(i == 1 && FrsFragment.this.hTP, true);
            com.baidu.tieba.frs.a ckM = com.baidu.tieba.frs.a.ckM();
            if (i == 1 && FrsFragment.this.hTP) {
                z = true;
            }
            ckM.R(z, true);
        }
    };
    private CustomMessageListener hUl = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIVE_COUNT) { // from class: com.baidu.tieba.frs.FrsFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                FrsFragment.this.hTq.yW(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    };
    private CustomMessageListener hUm = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_LIVE_START) { // from class: com.baidu.tieba.frs.FrsFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && ((Integer) customResponsedMessage.getData()).intValue() == 51 && FrsFragment.this.hSt != null) {
                com.baidu.tieba.frs.f.j.a(FrsFragment.this.hSt, FrsFragment.this.getPageContext());
            }
        }
    };
    private final CustomMessageListener hUn = new CustomMessageListener(CmdConfigCustom.CMD_FRS_SELECT_ALA_LIVE_TAB) { // from class: com.baidu.tieba.frs.FrsFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                FrsFragment.this.hTq.yU(49);
            }
        }
    };
    private final CustomMessageListener hUo = new CustomMessageListener(2921470) { // from class: com.baidu.tieba.frs.FrsFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                FrsFragment.this.hTq.yU(1);
                FrsFragment.this.cml();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
            }
        }
    };
    private final CustomMessageListener hUp = new CustomMessageListener(CmdConfigCustom.CMD_FRS_EXPERIENCE_TIP) { // from class: com.baidu.tieba.frs.FrsFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.v) && FrsFragment.this.hSt != null) {
                FrsFragment.this.hSt.updateLikeData((com.baidu.tieba.tbadkCore.v) customResponsedMessage.getData());
                FrsFragment.this.hTp.i(FrsFragment.this.hSt);
                FrsFragment.this.hTq.a(FrsFragment.this.hSt, FrsFragment.this.hTo.crX());
            }
        }
    };
    private final AntiHelper.a hUq = new AntiHelper.a() { // from class: com.baidu.tieba.frs.FrsFragment.8
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ai("obj_locate", ax.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ai("obj_locate", ax.a.LOCATE_LIKE_PERSON));
        }
    };
    private CustomMessageListener hUr = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.FrsFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(FrsFragment.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().eCe != null) {
                        if (AntiHelper.a(FrsFragment.this.getActivity(), updateAttentionMessage.getData().eCe, FrsFragment.this.hUq) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ai("obj_locate", ax.a.LOCATE_LIKE_PERSON));
                        }
                    } else if (updateAttentionMessage.getData().isSucc && updateAttentionMessage.getData().isAttention) {
                        com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getPageContext().getPageActivity(), R.string.attention_success);
                    }
                }
            }
        }
    };
    private CustomMessageListener hUs = new CustomMessageListener(CmdConfigCustom.CMD_GET_ENSURE_CAST_ID) { // from class: com.baidu.tieba.frs.FrsFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsFragment.this.refresh();
        }
    };
    private CustomMessageListener hUt = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.frs.FrsFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && !((PostWriteCallBackData) customResponsedMessage.getData()).isDyamicCallback()) {
                FrsFragment.this.hSV.c((PostWriteCallBackData) customResponsedMessage.getData());
                if (((PostWriteCallBackData) customResponsedMessage.getData()).getGeneralTabId() >= 0) {
                    FrsFragment.this.hTB.yn(((PostWriteCallBackData) customResponsedMessage.getData()).getGeneralTabId());
                }
            }
        }
    };
    private CustomMessageListener hUu = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_REMIND) { // from class: com.baidu.tieba.frs.FrsFragment.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626) {
                NewsRemindMessage newsRemindMessage = (NewsRemindMessage) customResponsedMessage;
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (FrsFragment.this.hSV != null) {
                    FrsFragment.this.hSV.N(notificationCount, z);
                }
            }
        }
    };
    private HttpMessageListener hUv = new HttpMessageListener(CmdConfigHttp.CMD_FRS_MOVE_AREA) { // from class: com.baidu.tieba.frs.FrsFragment.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int i;
            int i2 = 0;
            if (httpResponsedMessage != null && FrsFragment.this.getContext() != null && FrsFragment.this.hSV != null) {
                if (httpResponsedMessage.getError() == 0) {
                    new BdTopToast(FrsFragment.this.getContext()).wU(true).Sp(FrsFragment.this.getContext().getString(R.string.frs_move_area_move_suc)).aE(FrsFragment.this.hSV.bZc());
                    if (com.baidu.tieba.frs.a.ckM().wO(com.baidu.tieba.frs.a.ckM().ckO())) {
                        FrsCommonTabFragment frsCommonTabFragment = null;
                        if (FrsFragment.this.hTq != null && FrsFragment.this.hTq.ctU() != null && (FrsFragment.this.hTq.ctU().fragment instanceof FrsCommonTabFragment)) {
                            frsCommonTabFragment = (FrsCommonTabFragment) FrsFragment.this.hTq.ctU().fragment;
                        }
                        if (frsCommonTabFragment != null) {
                            frsCommonTabFragment.coZ();
                        }
                        FrsFragment.this.ckR();
                        com.baidu.tieba.frs.a.ckM().ckR();
                        Iterator<com.baidu.adp.widget.ListView.q> it = FrsFragment.this.hSt.getThreadList().iterator();
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
                            FrsFragment.this.bFE();
                        }
                    }
                    com.baidu.tieba.frs.a.ckM().reset();
                    return;
                }
                new BdTopToast(FrsFragment.this.getContext()).wU(false).Sp(httpResponsedMessage.getErrorString()).aE(FrsFragment.this.hSV.bZc());
            }
        }
    };
    private final CustomMessageListener hUw = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.frs.FrsFragment.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.isResumed()) {
                FrsFragment.this.cmH();
            }
        }
    };
    private CustomMessageListener hUx = new CustomMessageListener(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER) { // from class: com.baidu.tieba.frs.FrsFragment.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (FrsFragment.this.hSV != null) {
                    FrsFragment.this.hSV.setExpanded(booleanValue);
                }
            }
        }
    };
    private final CustomMessageListener hUy = new CustomMessageListener(2921463) { // from class: com.baidu.tieba.frs.FrsFragment.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TbadkApplication.getInst().getCurrentActivity() != null && !com.baidu.tbadk.core.util.at.isEmpty(str) && str.equals(FrsFragment.this.forumId)) {
                    com.baidu.tieba.frs.f.e.b(((TbPageContextSupport) TbadkApplication.getInst().getCurrentActivity()).getPageContext(), FrsFragment.this.hSt);
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.r hUz = new com.baidu.tieba.tbadkCore.r() { // from class: com.baidu.tieba.frs.FrsFragment.18
        private long startTime = 0;

        @Override // com.baidu.tieba.tbadkCore.r
        public void wV(int i) {
            this.startTime = System.nanoTime();
            if (FrsFragment.this.hSV != null) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsFragment.this.hSV.cnf();
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
            if (FrsFragment.this.fGM) {
                FrsFragment.this.fGM = false;
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.hSV, FrsFragment.this.hSt, FrsFragment.this.getForumId(), false, null);
            }
            FrsFragment.this.clW();
            FrsFragment.this.hTg = true;
            if (fVar != null && fVar.isSuccess) {
                FrsFragment.this.hSV.cns().oP(com.baidu.tbadk.core.util.au.bjr().bjs());
                FrsFragment.hTc = 0L;
                FrsFragment.hTd = 0L;
                FrsFragment.mNetError = 0;
            } else {
                FrsFragment.mNetError = 1;
            }
            if (!FrsFragment.this.hTo.csc() && (i == 3 || i == 6)) {
                FrsFragment.this.hTz.resetData();
            }
            FrsFragment.this.hTa = System.currentTimeMillis();
            if (FrsFragment.this.hTo.crt() != null) {
                FrsFragment.this.hSt = FrsFragment.this.hTo.crt();
            }
            FrsFragment.this.wR(1);
            FrsFragment.this.cme();
            if (i == 7) {
                FrsFragment.this.wS(FrsFragment.this.hSt.getFrsDefaultTabId());
                return;
            }
            if (FrsFragment.this.hSt.getPage() != null) {
                FrsFragment.this.setHasMore(FrsFragment.this.hSt.getPage().bdu());
            }
            if (i == 4) {
                if (!FrsFragment.this.hTo.csc() && TbadkCoreApplication.getInst().isRecAppExist() && FrsFragment.this.hTo.crS() == 1) {
                    FrsFragment.this.hSt.addRecommendAppToThreadList(FrsFragment.this);
                }
                ArrayList<com.baidu.adp.widget.ListView.q> a2 = FrsFragment.this.hTz.a(false, false, FrsFragment.this.hSt.getThreadList(), FrsFragment.this.hSR, false);
                if (a2 != null) {
                    FrsFragment.this.hSt.setThreadList(a2);
                    FrsFragment.this.hSt.checkLiveStageInThreadList();
                }
                if (FrsFragment.this.hTo != null) {
                    com.baidu.tieba.frs.d.c.a(FrsFragment.this.hSt, FrsFragment.this.hTo.crX(), 2, FrsFragment.this.getContext());
                }
                com.baidu.tieba.frs.f.a.a(FrsFragment.this, FrsFragment.this.hSt.getForum(), FrsFragment.this.hSt.getThreadList(), false, FrsFragment.this.getPn());
                FrsFragment.this.hSV.a(a2, FrsFragment.this.hSt);
                FrsFragment.this.clX();
                return;
            }
            FrsFragment.this.clX();
            switch (i) {
                case 1:
                    FrsFragment.this.hSV.cnf();
                    break;
                case 2:
                    FrsFragment.this.hSV.cnf();
                    break;
                case 3:
                case 6:
                    if (FrsFragment.this.hSt != null) {
                        FrsFragment.this.hSt.clearPostThreadCount();
                    }
                    if (FrsFragment.this.hTE != null) {
                        FrsFragment.this.hTE.refresh();
                        break;
                    }
                    break;
            }
            FrsFragment.this.cmf();
            if (fVar == null || fVar.errorCode == 0) {
                if (FrsFragment.this.hSt != null) {
                    FrsFragment.this.a(FrsFragment.this.hSt);
                    FrsFragment.this.T(false, i == 5);
                    if (FrsFragment.this.hTo != null) {
                        if (FrsFragment.this.hSt.getActivityHeadData() != null && FrsFragment.this.hSt.getActivityHeadData().bcI() != null && FrsFragment.this.hSt.getActivityHeadData().bcI().size() > 0) {
                            com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), 1, FrsFragment.this.hSt.getForum(), FrsFragment.this.hTo.getSortType(), 1);
                        }
                        if (FrsFragment.this.hSt.getThreadList() != null && FrsFragment.this.hSt.getThreadList().size() > 0) {
                            Iterator<com.baidu.adp.widget.ListView.q> it = FrsFragment.this.hSt.getThreadList().iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    com.baidu.adp.widget.ListView.q next = it.next();
                                    if ((next instanceof bw) && ((bw) next).getType() == bw.ecV) {
                                        com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), 1, FrsFragment.this.hSt.getForum(), FrsFragment.this.hTo.getSortType(), 2);
                                    }
                                }
                            }
                        }
                        com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), FrsFragment.this.hSt.getThreadList(), FrsFragment.this.hSt.getForum(), FrsFragment.this.hTo.getSortType());
                    }
                    FrsFragment.this.hSV.xi(i);
                    FrsFragment.hTc = (System.nanoTime() - this.startTime) / TimeUtils.NANOS_PER_MS;
                    if (fVar != null) {
                        FrsFragment.hTd = fVar.mcP;
                    }
                } else {
                    return;
                }
            } else if (FrsFragment.this.hSt == null || com.baidu.tbadk.core.util.y.isEmpty(FrsFragment.this.hSt.getThreadList())) {
                FrsFragment.this.a(fVar);
            } else if (fVar.hCS) {
                FrsFragment.this.showToast(FrsFragment.this.getPageContext().getResources().getString(R.string.net_error_text, fVar.errorMsg, Integer.valueOf(fVar.errorCode)));
            }
            FrsFragment.this.cmb();
            FrsFragment.this.cmc();
            if (FrsFragment.this.hSt.getAccessFlag() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11384"));
            }
            if (FrsFragment.this.hSS && FrsFragment.this.hTq.yU(49)) {
                FrsFragment.this.hSS = false;
            }
            FrsFragment.this.b(FrsFragment.this.hSt.getForum());
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.r
        public void c(com.baidu.tieba.tbadkCore.m mVar) {
            if ((mVar != null && ("normal_page".equals(FrsFragment.this.hTo.getPageType()) || "frs_page".equals(FrsFragment.this.hTo.getPageType()) || "book_page".equals(FrsFragment.this.hTo.getPageType()))) || "brand_page".equals(FrsFragment.this.hTo.getPageType())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE, mVar));
                FrsFragment.this.b(mVar);
                FrsFragment.hSZ = mVar;
            }
        }

        @Override // com.baidu.tieba.tbadkCore.r
        public void cmh() {
            FrsFragment.this.cmh();
        }
    };
    private final CustomMessageListener hUA = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.frs.FrsFragment.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                FrsFragment.this.hSt.updateCurrentUserPendant((com.baidu.tbadk.data.l) customResponsedMessage.getData());
                FrsFragment.this.hSV.cns().notifyDataSetChanged();
            }
        }
    };
    private final CustomMessageListener mMemListener = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_MEM) { // from class: com.baidu.tieba.frs.FrsFragment.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && FrsFragment.this.hSt != null && (userData = FrsFragment.this.hSt.getUserData()) != null) {
                userData.setIsMem(num.intValue());
                if (num.intValue() != 0) {
                    FrsFragment.this.hTp.m(num);
                }
            }
        }
    };
    private final f.a hUB = new AnonymousClass30();
    private final com.baidu.tieba.frs.mc.k hUC = new com.baidu.tieba.frs.mc.k() { // from class: com.baidu.tieba.frs.FrsFragment.31
        @Override // com.baidu.tieba.frs.mc.k
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, boolean z3) {
            if (FrsFragment.this.hTs != null && FrsFragment.this.hTo != null && FrsFragment.this.hTo.csc() && z && !z2 && !z3) {
                FrsFragment.this.hTs.ys(i2);
            }
        }
    };
    public final View.OnTouchListener eVH = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.FrsFragment.32
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (FrsFragment.this.hTG != null) {
                FrsFragment.this.hTG.onTouch(view, motionEvent);
            }
            if (FrsFragment.this.hTu != null && FrsFragment.this.hTu.cof() != null) {
                FrsFragment.this.hTu.cof().onTouchEvent(motionEvent);
            }
            if (FrsFragment.this.fXN != null) {
                FrsFragment.this.fXN.b(view, motionEvent);
            }
            if (FrsFragment.this.hTp != null) {
                FrsFragment.this.hTp.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private final CustomMessageListener hUD = new CustomMessageListener(CmdConfigCustom.CMD_GOTOLIVE_HOST_UPGRADE) { // from class: com.baidu.tieba.frs.FrsFragment.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.bik().getInt(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.PHOTOLIVE_HOSTLEVEL, -1) != -1 && FrsFragment.this.hSt.getForum() != null) {
                FrsFragment.this.hSt.getForum().setCanAddPhotoLivePost(true);
            }
        }
    };
    public final View.OnClickListener hUE = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.39
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsFragment.this.hSV != null && view == FrsFragment.this.hSV.cnd() && FrsFragment.this.getActivity() != null) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, FrsFragment.this.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            if (view.getId() == R.id.game_activity_egg_layout && com.baidu.adp.lib.util.l.isNetOk()) {
                TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_CLICK);
                if (FrsFragment.this.hSV == null || !FrsFragment.this.hSV.cnp()) {
                    String activityUrl = FrsFragment.this.hSt.getForum().getYuleData().bgY().getActivityUrl();
                    if (!StringUtils.isNull(activityUrl)) {
                        com.baidu.tbadk.browser.a.startInternalWebActivity(FrsFragment.this.getPageContext().getPageActivity(), activityUrl);
                    }
                } else {
                    FrsFragment.this.hSV.cnq();
                }
            }
            if (FrsFragment.this.hSV != null && view == FrsFragment.this.hSV.cnw() && FrsFragment.this.hTo != null && FrsFragment.this.hTo.hasMore()) {
                FrsFragment.this.hSV.bGS();
                FrsFragment.this.bFE();
            }
            if (view != null && FrsFragment.this.hSV != null && view == FrsFragment.this.hSV.cnm()) {
                if (com.baidu.tbadk.core.util.bg.checkUpIsLogin(FrsFragment.this.getContext())) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).ai("obj_locate", 2));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MessageCenterActivityConfig(FrsFragment.this.getContext())));
                } else {
                    return;
                }
            }
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (FrsFragment.this.hSt != null && FrsFragment.this.hSt.getForum() != null) {
                    if (FrsFragment.this.hSV != null && view == FrsFragment.this.hSV.cnk()) {
                        if (FrsFragment.this.hSt != null && FrsFragment.this.hSt.getForum() != null && !StringUtils.isNull(FrsFragment.this.hSt.getForum().getId()) && !StringUtils.isNull(FrsFragment.this.hSt.getForum().getName())) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_SHARE_CLICK).dD("fid", FrsFragment.this.hSt.getForum().getId()).ai("obj_locate", 11));
                            com.baidu.tieba.frs.f.e.a(FrsFragment.this.getPageContext(), FrsFragment.this.hSt, FrsFragment.this.hSt.getForum().getId());
                        } else {
                            return;
                        }
                    }
                    if (FrsFragment.this.hSV != null && view == FrsFragment.this.hSV.cnj()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12402").dD("fid", FrsFragment.this.hSt.getForum().getId()).dD("uid", TbadkCoreApplication.getCurrentAccount()).dD("fname", FrsFragment.this.hSt.getForum().getName()));
                        if (!StringUtils.isNull(FrsFragment.this.hSt.getForum().getName())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PostSearchActivityConfig(FrsFragment.this.getContext(), FrsFragment.this.hSt.getForum().getName(), FrsFragment.this.hSt.getForum().getId())));
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
        private int hVc = 0;
        private int fCJ = 0;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsFragment.this.hTT += i2;
            if (FrsFragment.this.hTT >= FrsFragment.this.dhi * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
            if (FrsFragment.this.hTx != null) {
                FrsFragment.this.hTx.csS();
            }
            this.hVc = 0;
            this.fCJ = 0;
            if (recyclerView != null && (recyclerView instanceof BdRecyclerView)) {
                this.hVc = ((BdRecyclerView) recyclerView).getFirstVisiblePosition();
                this.fCJ = ((BdRecyclerView) recyclerView).getLastVisiblePosition();
            }
            if (FrsFragment.this.hTI != null) {
                FrsFragment.this.hTI.a(recyclerView, this.hVc, this.fCJ);
            }
            if (FrsFragment.this.hSt != null && FrsFragment.this.hSV != null && FrsFragment.this.hSV.cns() != null) {
                FrsFragment.this.hSV.ch(this.hVc, this.fCJ);
                if (FrsFragment.this.hTn != null && FrsFragment.this.hTn.tR() != null) {
                    FrsFragment.this.hTn.tR().b(FrsFragment.this.hTm);
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (FrsFragment.this.hTp != null) {
                FrsFragment.this.hTp.setScrollState(i);
            }
            if ((i == 2 || i == 1) && !FrsFragment.this.hTh) {
                FrsFragment.this.hTh = true;
                FrsFragment.this.hSV.cnu();
            }
            if (FrsFragment.this.hTi == null && !FrsFragment.this.cmA()) {
                FrsFragment.this.hTi = new com.baidu.tbadk.n.b();
                FrsFragment.this.hTi.setSubType(1000);
            }
            if (i == 0) {
                if (FrsFragment.this.hTi != null) {
                    FrsFragment.this.hTi.buf();
                }
                com.baidu.tieba.card.s.cbY().nm(true);
                FrsFragment.this.of(true);
                FrsFragment.this.hSV.cg(this.hVc, this.fCJ);
            } else if (FrsFragment.this.hTi != null) {
                FrsFragment.this.hTi.bue();
            }
            if (FrsFragment.this.hTI != null) {
                FrsFragment.this.hTI.onScrollStateChanged(recyclerView, i);
            }
            if (i == 0) {
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.hSV, FrsFragment.this.hSt, FrsFragment.this.getForumId(), false, null);
            }
            if (FrsFragment.this.hTq != null && i == 1) {
                FrsFragment.this.hTq.ctW();
            }
            if (FrsFragment.this.hTn == null) {
                if (FrsFragment.this.hSV.cmW() != null && !FrsFragment.this.hSV.cmy() && FrsFragment.this.hSV.cmW().djW() != null && (FrsFragment.this.hSV.cmW().djW().getTag() instanceof com.baidu.card.al)) {
                    FrsFragment.this.hTn = (com.baidu.card.al) FrsFragment.this.hSV.cmW().djW().getTag();
                }
            } else if (i == 0 && FrsFragment.this.hSV.cmW() != null && !FrsFragment.this.hSV.cmy() && FrsFragment.this.hSV.cmW().djW() != null && (FrsFragment.this.hSV.cmW().djW().getTag() instanceof com.baidu.card.al)) {
                FrsFragment.this.hTn = (com.baidu.card.al) FrsFragment.this.hSV.cmW().djW().getTag();
            }
            if (i == 1) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921418));
            }
        }
    };
    private final f hUF = new f() { // from class: com.baidu.tieba.frs.FrsFragment.41
        @Override // com.baidu.tieba.frs.f
        public void a(int i, int i2, View view, View view2, bw bwVar) {
            if (i != FrsFragment.this.hSV.cns().cpL()) {
                if (i != FrsFragment.this.hSV.cns().cpM()) {
                    if (i == FrsFragment.this.hSV.cns().cpJ() && FrsFragment.this.hSt != null && FrsFragment.this.hSt.getUserData() != null && FrsFragment.this.hSt.getUserData().isBawu()) {
                        String bawuCenterUrl = FrsFragment.this.hSt.getBawuCenterUrl();
                        if (!com.baidu.tbadk.core.util.at.isEmpty(bawuCenterUrl) && FrsFragment.this.hSt.getForum() != null) {
                            com.baidu.tbadk.browser.a.startWebActivity(FrsFragment.this.getPageContext().getPageActivity(), bawuCenterUrl);
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10502").dD("fid", FrsFragment.this.hSt.getForum().getId()).dD("uid", FrsFragment.this.hSt.getUserData().getUserId()));
                        }
                    }
                } else if (com.baidu.tbadk.core.util.bg.checkUpIsLogin(FrsFragment.this.getPageContext().getPageActivity())) {
                    TiebaStatic.log(CommonStatisticKey.MY_SERVICE_CK);
                    if (FrsFragment.this.hSt != null && FrsFragment.this.hSt.getForum() != null) {
                        ForumData forum = FrsFragment.this.hSt.getForum();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(forum.getId(), 0L), forum.getName(), forum.getImage_url(), 0)));
                    }
                }
            } else if (com.baidu.tbadk.core.util.bg.checkUpIsLogin(FrsFragment.this.getActivity())) {
                TiebaStatic.log("forum_fortune_click");
                com.baidu.tieba.frs.f.i.c(FrsFragment.this.getPageContext(), FrsFragment.this.hSt);
            }
        }
    };
    private final NoNetworkView.a hQf = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.FrsFragment.42
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (FrsFragment.this.hTo.crS() == 1 && z && !FrsFragment.this.hSV.cmy()) {
                if (FrsFragment.this.hSt == null || com.baidu.tbadk.core.util.y.isEmpty(FrsFragment.this.hSt.getThreadList())) {
                    FrsFragment.this.hideNetRefreshView(FrsFragment.this.hSV.bZc());
                    FrsFragment.this.showLoadingView(FrsFragment.this.hSV.bZc(), true);
                    FrsFragment.this.hSV.op(false);
                    FrsFragment.this.refresh();
                    return;
                }
                FrsFragment.this.hSV.cnf();
            }
        }
    };
    private final CustomMessageListener eCw = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.FrsFragment.43
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                com.baidu.tieba.frs.f.c.a(customResponsedMessage, FrsFragment.this.hSV, FrsFragment.this.hSt);
            }
        }
    };
    private com.baidu.adp.widget.ListView.ab hUG = new a();
    private av hUH = new av() { // from class: com.baidu.tieba.frs.FrsFragment.46
        @Override // com.baidu.tieba.frs.av
        public void a(int i, int i2, bd bdVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
            com.baidu.adp.lib.f.e.mS().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.46.1
                @Override // java.lang.Runnable
                public void run() {
                    if (FrsFragment.this.hSV != null && FrsFragment.this.hSV.cnz()) {
                        FrsFragment.this.bFE();
                    }
                }
            });
        }
    };
    private CustomMessageListener hUI = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.frs.FrsFragment.47
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    FrsFragment.this.hTJ = true;
                }
            }
        }
    };
    private CustomMessageListener hUJ = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.frs.FrsFragment.48
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                    if (FrsFragment.this.hTn == null && FrsFragment.this.hSV.cmW() != null && !FrsFragment.this.hSV.cmy() && FrsFragment.this.hSV.cmW().djW() != null && (FrsFragment.this.hSV.cmW().djW().getTag() instanceof com.baidu.card.al)) {
                        FrsFragment.this.hTn = (com.baidu.card.al) FrsFragment.this.hSV.cmW().djW().getTag();
                    }
                    if (FrsFragment.this.hTn != null && FrsFragment.this.hTn.tR() != null) {
                        FrsFragment.this.hTn.tR().b(new a.C0095a(3));
                    }
                }
            }
        }
    };
    private CustomMessageListener hUK = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.FrsFragment.49
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.hSV != null) {
                FrsFragment.this.hSV.EF();
            }
        }
    };
    private CustomMessageListener hUL = new CustomMessageListener(2921437) { // from class: com.baidu.tieba.frs.FrsFragment.50
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && FrsFragment.this.isResumed()) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (FrsFragment.this.hSX != null) {
                    if (booleanValue) {
                        if (FrsFragment.this.hTq.ctX() != 0 && !FrsFragment.this.hSV.cnE() && !KuangFloatingFrsCopyLinkViewController.getInstance().isFloatCopyViewShow()) {
                            FrsFragment.this.hSX.show();
                            return;
                        }
                        return;
                    }
                    FrsFragment.this.hSX.hide();
                }
            }
        }
    };
    private CustomMessageListener hUM = new CustomMessageListener(2921462) { // from class: com.baidu.tieba.frs.FrsFragment.55
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && FrsFragment.this.hSt.getToLoadHorseData().intValue() == 1 && FrsFragment.this.mIsLogin) {
                LiveHorseRaceRequestMessage liveHorseRaceRequestMessage = new LiveHorseRaceRequestMessage();
                liveHorseRaceRequestMessage.setForum_id(Long.valueOf(FrsFragment.this.forumId));
                FrsFragment.this.sendMessage(liveHorseRaceRequestMessage);
            }
        }
    };
    private CustomMessageListener hUN = new CustomMessageListener(2001223) { // from class: com.baidu.tieba.frs.FrsFragment.57
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Date)) {
                FrsFragment.this.hTS = (Date) customResponsedMessage.getData();
            }
        }
    };
    private CustomMessageListener hUO = new CustomMessageListener(2921469) { // from class: com.baidu.tieba.frs.FrsFragment.58
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.x) && FrsFragment.this.isResumed()) {
                com.baidu.tbadk.core.data.x xVar = (com.baidu.tbadk.core.data.x) customResponsedMessage.getData();
                if (FrsFragment.this.hTZ == null) {
                    FrsFragment.this.hTZ = new com.baidu.tieba.frs.broadcast.a(FrsFragment.this.getPageContext());
                }
                if (FrsFragment.this.hSt != null && FrsFragment.this.hSt.getForum() != null && !TextUtils.isEmpty(FrsFragment.this.hSt.getForum().getId())) {
                    FrsFragment.this.hTZ.e(xVar.type, FrsFragment.this.hSt.getForum().getId(), FrsFragment.this.hSt.getForum().getName(), xVar.tid);
                }
            }
        }
    };
    private CustomMessageListener hUP = new CustomMessageListener(2921475) { // from class: com.baidu.tieba.frs.FrsFragment.59
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bw bwVar = (bw) customResponsedMessage.getData();
            if (bwVar != null && FrsFragment.this.isResumed()) {
                FrsFragment.this.hTl = bwVar.getTid() + "";
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE_NUMBER);
                httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
                httpMessage.addParam("forum_id", bwVar.getFid());
                MessageManager.getInstance().sendMessage(httpMessage);
            }
        }
    };
    private HttpMessageListener hUQ = new HttpMessageListener(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE_NUMBER) { // from class: com.baidu.tieba.frs.FrsFragment.60
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
                            hashMap.put("_forumId", FrsFragment.this.hSt.getForum().getId());
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new com.baidu.tieba.tbadkCore.data.m(FrsFragment.this.getContext(), "ForumGradePage", hashMap)));
                        }
                    }).aE((ViewGroup) FrsFragment.this.mRootView.findViewById(R.id.frs));
                    return;
                }
                com.baidu.tbadk.core.util.o oVar = new com.baidu.tbadk.core.util.o(TbadkCoreApplication.getInst());
                oVar.ab(FrsFragment.this.hSt.getForum().getId(), FrsFragment.this.hSt.getForum().getName(), "6");
                oVar.zV(FrsFragment.this.hTl);
                oVar.start();
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.frs.loadmore.a
    public /* bridge */ /* synthetic */ com.baidu.adp.base.e getPageContext() {
        return super.getPageContext();
    }

    public com.baidu.tieba.frs.entelechy.b.b clK() {
        return this.hTw;
    }

    public com.baidu.adp.widget.ListView.ab clL() {
        return this.hUG;
    }

    public com.baidu.tieba.frs.mc.d clM() {
        return this.hTy;
    }

    public com.baidu.tieba.frs.smartsort.a clN() {
        return this.hTs;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public FrsModelController clO() {
        return this.hTo;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public com.baidu.tieba.frs.mc.c clP() {
        return this.hTz;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public com.baidu.tieba.frs.vc.h clQ() {
        return this.hTp;
    }

    public FrsTabViewController clR() {
        return this.hTq;
    }

    public ax clS() {
        return this.hTu;
    }

    public void oe(boolean z) {
        this.hTR = z;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public q clT() {
        return this.hSV;
    }

    @Override // com.baidu.tieba.frs.aw
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.aw, com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.hSN;
    }

    public void setForumName(String str) {
        this.hSN = str;
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
        if (this.hTz == null) {
            return 1;
        }
        return this.hTz.getPn();
    }

    public int getPn() {
        if (this.hTz == null) {
            return 1;
        }
        return this.hTz.getPn();
    }

    public void setPn(int i) {
        if (this.hTz != null) {
            this.hTz.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.hTz != null) {
            this.hTz.setHasMore(i);
        }
    }

    public int clU() {
        if (this.hTz == null) {
            return -1;
        }
        return this.hTz.clU();
    }

    public boolean clV() {
        return this.hST;
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
            this.hSV.cmZ();
            showNetRefreshView(this.hSV.bZc(), string, true);
        } else if (340001 == fVar.errorCode) {
            a(fVar, this.hSt.getRecm_forum_list());
        } else {
            if (com.baidu.tbadk.core.util.y.isEmpty(this.hSt.getThreadList())) {
                b(fVar);
            }
            if (cmA()) {
                setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds280));
            } else {
                setNetRefreshViewEmotionDefMarginTop();
            }
        }
    }

    public void a(View view, String str, boolean z, List<RecmForumInfo> list) {
        this.hSV.cmZ();
        this.hSV.xc(8);
        if (this.hTH == null) {
            this.hTH = new com.baidu.tieba.frs.view.a(getPageContext(), getNetRefreshListener());
        }
        this.hTH.setSubText(str);
        this.hTH.setListData(list);
        this.hTH.attachView(view, z);
    }

    private void a(com.baidu.tieba.tbadkCore.f fVar, List<RecmForumInfo> list) {
        if (this.hSV != null) {
            this.hSV.cmZ();
            this.hSV.setTitle(this.hSN);
            a(this.hSV.bZc(), fVar.errorMsg, true, list);
        }
    }

    private void b(com.baidu.tieba.tbadkCore.f fVar) {
        this.hSV.cmZ();
        if (fVar.hCS) {
            showNetRefreshView(this.hSV.bZc(), TbadkCoreApplication.getInst().getString(R.string.net_error_text, new Object[]{fVar.errorMsg, Integer.valueOf(fVar.errorCode)}), true);
        } else {
            showNetRefreshView(this.hSV.bZc(), fVar.errorMsg, true);
        }
    }

    public void clW() {
        hideLoadingView(this.hSV.bZc());
        this.hSV.bGe();
        if (this.hSV.cmX() instanceof com.baidu.tieba.frs.tab.c) {
            ((com.baidu.tieba.frs.tab.c) this.hSV.cmX()).csz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clX() {
        if (clU() == 0 && com.baidu.tbadk.core.util.y.isEmpty(this.hSt.getThreadListIds())) {
            if (com.baidu.tbadk.core.util.y.isEmpty(this.hSt.getThreadList())) {
                this.hSV.bGU();
            } else {
                this.hSV.bGT();
            }
        } else if (com.baidu.tbadk.core.util.y.getCount(this.hSt.getThreadList()) > 3) {
            this.hSV.bGS();
        } else {
            this.hSV.cnv();
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
            clW();
            this.hSV.cnf();
            com.baidu.tieba.tbadkCore.f crO = this.hTo.crO();
            boolean isEmpty = com.baidu.tbadk.core.util.y.isEmpty(this.hSt.getThreadList());
            if (crO != null && isEmpty) {
                if (this.hTo.crQ() != 0) {
                    this.hTo.crV();
                    this.hSV.cnf();
                } else {
                    a(crO);
                }
                this.hSV.U(this.hSt.isStarForum(), false);
                return;
            }
            a(crO);
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
            aVar.zz(forumData.getRiskTipPopTitle());
            aVar.setTitleShowCenter(true);
            aVar.zA(forumData.getRiskTipPop());
            aVar.a(R.string.frs_risk_dialog_button_text, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.19
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                }
            });
            aVar.b(getPageContext()).bhg();
        }
    }

    public boolean clY() {
        return clZ() && !cma();
    }

    private boolean clZ() {
        if (cmx() == null) {
            return false;
        }
        FrsViewData cmx = cmx();
        com.baidu.tbadk.core.data.y yVar = null;
        if (cmx.getStar() != null && !StringUtils.isNull(cmx.getStar().dvY())) {
            yVar = new com.baidu.tbadk.core.data.y();
        } else if (cmx.getActivityHeadData() != null && com.baidu.tbadk.core.util.y.getCount(cmx.getActivityHeadData().bcI()) >= 1) {
            yVar = cmx.getActivityHeadData().bcI().get(0);
        }
        return yVar != null;
    }

    public boolean cma() {
        if (cmx() == null) {
            return false;
        }
        FrsViewData cmx = cmx();
        return (com.baidu.tbadk.core.util.y.isEmpty(cmx.getShowTopThreadList()) && cmx.getBusinessPromot() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmb() {
        boolean b;
        if (!cmd()) {
            final PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
            privateForumPopInfoData.a(this.hSt.getPrivateForumTotalInfo().getPrivatePopInfo());
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(getActivity());
            if (this.hSt.getPrivateForumTotalInfo().bdB().private_forum_status.intValue() == 1 && (com.baidu.tbadk.core.util.at.isEmpty(privateForumPopInfoData.bdD()) || privateForumPopInfoData.bdG() != Integer.valueOf(this.forumId))) {
                privateForumPopInfoData.zd("create_success");
                privateForumPopInfoData.ze(TbadkCoreApplication.getInst().getString(R.string.frs_private_create_hint));
                privateForumPopInfoData.zf("https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.hSN + "&nomenu=1");
                privateForumPopInfoData.i(Integer.valueOf(this.forumId));
                b = frsPrivateCommonDialogView.b(privateForumPopInfoData);
            } else {
                b = privateForumPopInfoData.bdG() == Integer.valueOf(this.forumId) ? frsPrivateCommonDialogView.b(privateForumPopInfoData) : false;
            }
            if (b) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
                aVar.nw(2);
                aVar.aX(frsPrivateCommonDialogView);
                aVar.ih(false);
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
    public void cmc() {
        if (cmd() || this.hSt.getPrivateForumTotalInfo().bdB().private_forum_status.intValue() != 1) {
            a((Integer) null, (Integer) null, true);
        } else {
            a(this.hSt.getPrivateForumTotalInfo().bdB().private_forum_audit_status, this.hSt.getPrivateForumTotalInfo().bdC(), false);
        }
    }

    public void a(Integer num, Integer num2, boolean z) {
        final String str;
        final int i = 2;
        if (this.hSV.cnl() != null) {
            TextView cnl = this.hSV.cnl();
            if (z) {
                cnl.setVisibility(8);
                return;
            }
            if (num.intValue() == 2) {
                cnl.setText("修改实名认证信息");
                cnl.setVisibility(0);
                str = "https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + this.forumId + "&nomenu=1";
            } else if (num2.intValue() >= 0 && num2.intValue() <= 100) {
                cnl.setText("目标已完成" + String.valueOf(num2) + "%");
                cnl.setVisibility(0);
                str = "https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.hSN + "&nomenu=1";
                i = 1;
            } else {
                cnl.setVisibility(8);
                i = 0;
                str = "";
            }
            cnl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.22
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

    private boolean cmd() {
        return this.hSt == null || this.hSt.getPrivateForumTotalInfo() == null || this.hSt.getPrivateForumTotalInfo().bdB() == null || this.hSt.getUserData().getIs_manager() != 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wR(int i) {
        List<WindowToast> list;
        if (TbadkCoreApplication.isLogin() && this.hSt != null && (list = this.hSt.mWindowToast) != null && list.size() > 0) {
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
    public void cme() {
        if (getActivity() != null && getActivity().getIntent() != null) {
            String stringExtra = getActivity().getIntent().getStringExtra(FrsActivityConfig.KEY_ACHIEVEMENT_URL);
            if (!TextUtils.isEmpty(stringExtra)) {
                getActivity().getIntent().removeExtra(FrsActivityConfig.KEY_ACHIEVEMENT_URL);
                AchievementActivityConfig achievementActivityConfig = new AchievementActivityConfig(getActivity());
                achievementActivityConfig.setUrl(stringExtra);
                if (this.hSt != null && this.hSt.getForumActiveInfo() != null) {
                    achievementActivityConfig.setShareUrl(this.hSt.getForumActiveInfo().forum_share_url);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, achievementActivityConfig));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmf() {
        if (this.hSt == null || this.hSt.getForum() != null) {
            this.hSV.cnr();
        } else if (this.hSt.getForum().getYuleData() != null && this.hSt.getForum().getYuleData().bgX()) {
            TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_VIEW);
            this.hSV.a(this.hSt.getForum().getYuleData().bgY());
        } else {
            this.hSV.cnr();
        }
    }

    private void S(boolean z, boolean z2) {
        if (this.hTo != null && this.hSt != null && this.hSV != null && z) {
            if (!this.hTo.csc() && this.hTo.crS() == 1) {
                if (!this.hTo.csa()) {
                    this.hSt.addCardVideoInfoToThreadList();
                    this.hSt.addVideoInfoToThreadListInTenAndFifteenFloor();
                }
                boolean z3 = false;
                if (this.hSV.cns().s(com.baidu.tieba.card.data.o.hnz)) {
                    z3 = this.hSt.addHotTopicDataToThreadList();
                }
                if (!z3) {
                    this.hSt.addFeedForumDataToThreadList();
                }
                if (TbadkCoreApplication.getInst().isRecAppExist()) {
                    this.hSt.addRecommendAppToThreadList(this);
                }
                if (!this.hSV.cns().s(bw.ebt)) {
                    this.hSt.removeAlaLiveThreadData();
                }
                this.hSt.addSchoolRecommendToThreadList();
            }
            if (!this.hSV.cns().s(bw.ebt)) {
                this.hSt.removeAlaInsertLiveData();
                this.hSt.removeAlaStageLiveDat();
            } else {
                this.hSt.addInsertLiveDataToThreadList();
                this.hSt.addStageLiveDataToThreadList();
            }
            this.hSt.checkLiveStageInThreadList();
            this.hSt.addNoticeThreadToThreadList();
            if (this.hSV.cns().s(com.baidu.tieba.h.b.iAW)) {
                this.hSt.addGameRankListToThreadList(z2);
            }
            if (TbadkCoreApplication.isLogin() && (!this.hTo.csc() || this.hTo.isNetFirstLoad)) {
                this.hSt.addUserRecommendToThreadList();
            }
            this.hSt.addVideoActivityToTop();
        }
    }

    public boolean cmg() {
        if (this.hTp != null && this.hTo != null) {
            this.hTp.a(this.hTo.getPageType(), this.hSt);
        }
        boolean z = false;
        if (this.hSt != null) {
            z = this.hSt.hasTab();
        }
        cmj();
        if (this.hSV != null) {
            this.hSV.cnF();
            this.hSV.cnG();
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wS(int i) {
        ba baVar = null;
        cmg();
        cms();
        try {
            if (this.hSt != null) {
                this.hSV.a((ArrayList<com.baidu.adp.widget.ListView.q>) null, this.hSt);
                this.hTp.yL(1);
                this.hSV.cni();
                this.hTq.a(this.hSt, this.hTo.crX());
                com.baidu.tieba.frs.tab.d yV = this.hTq.yV(this.hSt.getFrsDefaultTabId());
                if (yV != null && !TextUtils.isEmpty(yV.url)) {
                    baVar = new ba();
                    baVar.ext = yV.url;
                    baVar.stType = yV.name;
                }
                this.hTo.a(this.hSt.getFrsDefaultTabId(), 0, baVar);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(boolean z, boolean z2) {
        try {
            if (this.hSt != null && this.hTq != null && this.hTo != null) {
                if (!this.hSV.cns().s(bw.ebt)) {
                    this.hSt.removeAlaLiveThreadData();
                }
                boolean isEmpty = com.baidu.tbadk.core.util.y.isEmpty(this.hSt.getGameTabInfo());
                this.hSV.on(isEmpty);
                if (!isEmpty) {
                    if (this.hTI == null) {
                        this.hTI = new com.baidu.tieba.frs.vc.e(this, (NoPressedRelativeLayout) this.mRootView);
                    }
                    if (this.fXN == null) {
                        this.fXN = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
                    }
                } else {
                    this.hTI = null;
                    this.fXN = null;
                }
                if (this.hSt.getForum() != null) {
                    this.hSN = this.hSt.getForum().getName();
                    this.forumId = this.hSt.getForum().getId();
                }
                if (this.hSt.hasTab()) {
                    this.hTq.a(this.hSt, this.hTo.crX());
                }
                if (z) {
                    S(true, z);
                } else {
                    S(this.hTj, z);
                }
                cmg();
                if (this.hTw != null) {
                    this.hTw.a(this.hTp, this.hSt);
                }
                if (this.hSt.getPage() != null) {
                    setHasMore(this.hSt.getPage().bdu());
                }
                ArrayList<com.baidu.adp.widget.ListView.q> a2 = this.hTz.a(z2, true, this.hSt.getThreadList(), null, z, false);
                if (a2 != null) {
                    this.hSt.setThreadList(a2);
                }
                this.hSt.removeRedundantUserRecommendData();
                this.hSv = this.hSt.getTopThreadSize();
                if (this.hSR != null) {
                    this.hSQ = true;
                    this.hSR.HL(this.hSv);
                    com.baidu.tieba.frs.f.a.a(this, this.hSt.getForum(), this.hSt.getThreadList(), this.hSQ, getPn());
                }
                if (this.hTo.crS() == 1) {
                    cmn();
                    if (!z && this.hTo.getPn() == 1) {
                        cmi();
                    }
                }
                if (this.hTx != null) {
                    this.hTx.cm(this.hTq.ctT());
                }
                clW();
                this.hSV.cna();
                this.hSV.U(true, false);
                if (z && this.hSt.isFirstTabEqualAllThread()) {
                    com.baidu.adp.lib.f.e.mS().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.24
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!FrsFragment.this.hTg && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                FrsFragment.this.hSV.cnD();
                            }
                        }
                    });
                }
                if (this.hSt.getForum() != null) {
                    this.hSV.Ir(this.hSt.getForum().getWarningMsg());
                }
                if (this.hSt != null && this.hSt.getFrsVideoActivityData() != null && com.baidu.tbadk.core.sharedPref.b.bik().getLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 0L) == 0) {
                    com.baidu.adp.lib.f.e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.25
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsFragment.this.hSV.cnB();
                        }
                    }, 1000L);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FRS_SHOW_AR_ENTRY, this));
                this.hSV.cmU();
                if (this.hSt != null && this.hSt.getForum() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ENTER_FORUM, new VisitedForumData(this.hSt.getForum().getId(), this.hSt.getForum().getName(), this.hSt.getForum().getImage_url(), String.valueOf(System.currentTimeMillis() / 1000), ConstantData.Forum.SPECAIL_FORUM_TYPE_LIVE.equals(this.hSt.getForum().special_forum_type), this.hSt.getForum().getThemeColorInfo(), this.hSt.getForum().getMember_num())));
                }
                this.hTM.a(this.hSt.bottomMenuList, this.hSt.getForum());
                cmH();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void cmh() {
        if (this.hTo != null && this.hTo.crS() == 1) {
            this.hTp.j(this.hSt);
        }
    }

    public void of(boolean z) {
        com.baidu.tieba.s.c.dvJ().b(getUniqueId(), z);
    }

    public void cmi() {
        if (this.hTC == null) {
            this.hTC = new com.baidu.tieba.frs.live.a(this, com.baidu.adp.lib.f.b.toInt(this.forumId, 0));
        }
        this.hTC.crz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.tbadkCore.m mVar) {
        try {
            if (!this.hTg && mVar != null && this.hSt != null) {
                this.hSt.receiveData(mVar);
                T(true, false);
                Looper.myQueue().addIdleHandler(this.hUb);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void cmj() {
        if (this.hTo != null) {
            Iq(this.hTo.getPageType());
        } else {
            Iq("normal_page");
        }
    }

    private void Iq(String str) {
        og("frs_page".equals(str));
        if (this.hTw != null) {
            this.hTw.a(this.hTp, this.hSV, this.hSt);
        }
    }

    public void og(boolean z) {
        if (this.hTA != null) {
            this.hTA.ctG();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.s.c.dvJ().A(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.frs_activity, viewGroup, false);
            this.hSH = new com.baidu.tieba.frs.entelechy.a();
            this.hTw = this.hSH.cpo();
            this.hSG = TbadkCoreApplication.getInst().getString(R.string.frs_title_new_area);
            this.hTp = new com.baidu.tieba.frs.vc.h(this, this.hSH, (FrsHeaderViewContainer) this.mRootView.findViewById(R.id.header_view_container));
            this.hTq = new FrsTabViewController(this, this.mRootView);
            this.hTq.registerListener();
            this.hTp.a(this.hTq);
            this.hTq.a(this.hUj);
            Intent intent = getActivity().getIntent();
            if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                this.hSJ = true;
            }
            this.hSV = new q(this, this.hUE, this.hSH, this.hSJ, this.hTp);
            this.hTM = new com.baidu.tieba.frs.brand.buttommenu.a(getPageContext(), this.mRootView);
        } else {
            if (this.mRootView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            if (this.hTq != null) {
                this.hTq.registerListener();
            }
            this.hSV.cnA();
            this.mRootView.setLeft(0);
            this.mRootView.setRight(com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getContext()));
        }
        this.hTQ = true;
        this.eRO = System.currentTimeMillis() - currentTimeMillis;
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        ArrayList<com.baidu.adp.widget.ListView.q> arrayList = null;
        this.hvt = System.currentTimeMillis();
        long j = this.hvt;
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.hSS = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.hvt = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            U(intent);
        }
        this.eRN = j - this.hvt;
        this.hSR = new com.baidu.tieba.tbadkCore.data.f("frs", com.baidu.tieba.tbadkCore.data.f.meB);
        if (this.hTo == null) {
            this.hTo = new FrsModelController(this, this.hUz);
            this.hTo.a(this.hUi);
            this.hTo.init();
        }
        this.hTo.setSchemeUrl(this.mSchemeUrl);
        if (intent != null) {
            this.hTo.aj(intent.getExtras());
        } else if (bundle != null) {
            this.hTo.aj(bundle);
        } else {
            this.hTo.aj(null);
        }
        if (intent != null) {
            this.hTp.aq(intent.getExtras());
        } else if (bundle != null) {
            this.hTp.aq(bundle);
        } else {
            this.hTp.aq(null);
        }
        this.hSU = getVoiceManager();
        this.hTD = new p(getPageContext(), this);
        initUI();
        initData(bundle);
        if (!cmA()) {
            this.hTu = new ax(getActivity(), this.hSV, this.hTp);
            this.hTu.oC(true);
        }
        this.hSU = getVoiceManager();
        if (this.hSU != null) {
            this.hSU.onCreate(getPageContext());
        }
        if (FrsActivityConfig.FRS_FROM_FLUTTER_BCASTEDIT.equals(getFrom()) && !this.hasInit) {
            int i = com.baidu.tbadk.core.sharedPref.b.bik().getInt("key_forum_broadcast_edit_tip_number", 0);
            if (i < 2) {
                com.baidu.tbadk.core.sharedPref.b.bik().putInt("key_forum_broadcast_edit_tip_number", i + 1);
                cmp();
            } else if (Build.VERSION.SDK_INT >= 23) {
                if (Settings.canDrawOverlays(getContext())) {
                    cmq();
                } else {
                    new BdTopToast(getContext()).wU(false).Sp(getContext().getString(R.string.forum_broadcast_copy_no_permission_hint)).aE(this.hSV.bZc());
                }
            } else {
                cmq();
            }
        }
        if (KuangFloatingFrsCopyLinkViewController.getInstance().isFloatCopyViewShow()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
            if (this.hSW != null) {
                this.hSW.setVisibility(8);
            }
        }
        new com.baidu.tieba.frs.mc.i();
        int i2 = -1;
        if (this.hTz != null && this.hTz.crK() != null) {
            i2 = this.hTz.crK().clU();
            arrayList = this.hTz.crK().getDataList();
        }
        this.hTz = new com.baidu.tieba.frs.mc.c(this, this.hUC);
        this.hTz.crK().setHasMore(i2);
        if (arrayList != null && arrayList.size() > 0) {
            this.hTz.crK().aC(arrayList);
        }
        this.hTs = new com.baidu.tieba.frs.smartsort.a(this);
        this.hTA = new com.baidu.tieba.frs.vc.j(this);
        this.hTx = new com.baidu.tieba.frs.vc.a(getPageContext(), this.hTo.crZ());
        this.hTt = new com.baidu.tieba.frs.mc.b(this);
        this.hTy = new com.baidu.tieba.frs.mc.d(this);
        this.hTr = new com.baidu.tieba.frs.mc.h(this);
        this.hTB = new com.baidu.tieba.frs.mc.a(this);
        this.hTE = new com.baidu.tieba.frs.vc.c(this);
        this.hTF = new com.baidu.tieba.frs.mc.e(this, getUniqueId());
        this.hTK = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "frs");
        this.hTL = new com.baidu.tieba.ala.a(getPageContext());
        this.hTN = new com.baidu.tieba.frs.sportspage.notification.a(getPageContext());
        registerListener(this.hUr);
        registerListener(this.mMemListener);
        registerListener(this.hUp);
        registerListener(this.hUD);
        registerListener(this.hUA);
        registerListener(this.hUl);
        registerListener(this.hUm);
        registerListener(this.hUn);
        registerListener(this.hUo);
        registerListener(this.hUc);
        registerListener(this.hUd);
        registerListener(this.afP);
        registerListener(this.hUe);
        registerListener(this.hUI);
        registerListener(this.hUt);
        registerListener(this.hUh);
        registerListener(this.hUu);
        registerListener(this.hUs);
        registerListener(this.hUw);
        registerListener(this.hUx);
        registerListener(this.hUy);
        this.hUJ.setTag(getPageContext().getUniqueId());
        MessageManager.getInstance().registerListener(this.hUJ);
        registerListener(this.hUK);
        registerListener(this.hUL);
        registerListener(this.hUM);
        registerListener(this.hUg);
        registerListener(this.hUN);
        registerListener(this.hUv);
        registerListener(this.hUf);
        registerListener(this.hUO);
        registerListener(this.hUP);
        registerListener(this.hUQ);
        this.hSV.op(false);
        if (!cmA() && !this.hasInit) {
            showLoadingView(this.hSV.bZc(), true);
            this.hTo.R(3, false);
        }
        ay ayVar = new ay() { // from class: com.baidu.tieba.frs.FrsFragment.28
            @Override // com.baidu.tieba.frs.ay
            public void d(boolean z, boolean z2, int i3) {
                if (FrsFragment.this.hSV != null) {
                    if (i3 == 1) {
                        FrsFragment.this.hSV.xd(z ? 0 : 8);
                    } else if (i3 == 2) {
                        FrsFragment.this.hSV.xf(z ? 0 : 8);
                    }
                    if (!z2) {
                        FrsFragment.this.hTP = z;
                    }
                    if (FrsFragment.this.hSV.cns() != null && (i3 == 2 || (FrsFragment.this.hTo != null && FrsFragment.this.hTo.crT()))) {
                        FrsFragment.this.hSV.cns().notifyDataSetChanged();
                    }
                    if (FrsFragment.this.clR() != null) {
                        FrsTabViewController.b ctU = FrsFragment.this.clR().ctU();
                        if (ctU != null) {
                            if ((ctU.fragment instanceof FrsCommonTabFragment) && (i3 == 2 || ctU.tabId == 502)) {
                                ((FrsCommonTabFragment) ctU.fragment).cpe();
                            } else if ((ctU.fragment instanceof FrsNewAreaFragment) && (i3 == 2 || ctU.tabId == 503)) {
                                FrsNewAreaFragment frsNewAreaFragment = (FrsNewAreaFragment) ctU.fragment;
                                frsNewAreaFragment.cpe();
                                if (frsNewAreaFragment.csk() != null) {
                                    com.baidu.tieba.frs.mc.g csk = frsNewAreaFragment.csk();
                                    csk.oE(!z);
                                    if (i3 == 1) {
                                        csk.os(!z);
                                    } else if (i3 == 2) {
                                        csk.os(true);
                                    }
                                }
                            } else if (ctU.fragment instanceof FrsGoodFragment) {
                                ((FrsGoodFragment) ctU.fragment).cpe();
                            }
                        }
                        if (FrsFragment.this.clR().ctL() != null) {
                            FrsFragment.this.clR().ctL().setmDisallowSlip(z);
                            FrsFragment.this.clR().pj(z);
                        }
                    }
                    if (FrsFragment.this.hSV.cmY() != null) {
                        FrsFragment.this.hSV.om(!z);
                    }
                    if (FrsFragment.this.getActivity() instanceof FrsActivity) {
                        ((FrsActivity) FrsFragment.this.getActivity()).od(!z);
                    }
                    if (FrsFragment.this.hTM != null) {
                        FrsFragment.this.hTM.oK(!z);
                    }
                    FrsFragment.this.hSV.or(!z);
                    if (i3 == 1) {
                        FrsFragment.this.hSV.os(z ? false : true);
                    } else if (i3 == 2) {
                        FrsFragment.this.hSV.os(true);
                    }
                }
            }

            @Override // com.baidu.tieba.frs.ay
            public void cf(int i3, int i4) {
                if (FrsFragment.this.hSV != null) {
                    if (i4 == 1) {
                        FrsFragment.this.hSV.xe(i3);
                    } else if (i4 == 2) {
                        FrsFragment.this.hSV.xg(i3);
                    }
                }
            }

            @Override // com.baidu.tieba.frs.ay
            public void wW(int i3) {
                if (FrsFragment.this.getContext() != null) {
                    if (i3 == 1) {
                        com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getContext(), R.string.frs_multi_delete_max_num);
                    } else if (i3 == 2 && FrsFragment.this.hSV != null) {
                        new BdTopToast(FrsFragment.this.getContext()).wU(false).Sp(FrsFragment.this.getContext().getString(R.string.frs_move_area_max_num)).aE(FrsFragment.this.hSV.bZc());
                    }
                }
            }
        };
        b.ckT().a(ayVar);
        com.baidu.tieba.frs.a.ckM().a(ayVar);
        this.hSV.b(new d.a() { // from class: com.baidu.tieba.frs.FrsFragment.29
            @Override // com.baidu.tieba.NEGFeedBack.d.a
            public void a(DeleteThreadHttpResponseMessage deleteThreadHttpResponseMessage) {
                boolean z;
                int i3 = 0;
                if (deleteThreadHttpResponseMessage != null) {
                    FrsFragment.this.hSV.bAj();
                    FrsFragment.this.hSV.cnC();
                    FrsNewAreaFragment frsNewAreaFragment = null;
                    if (FrsFragment.this.hTq == null || FrsFragment.this.hTq.ctU() == null || !(FrsFragment.this.hTq.ctU().fragment instanceof FrsNewAreaFragment)) {
                        z = false;
                    } else {
                        frsNewAreaFragment = (FrsNewAreaFragment) FrsFragment.this.hTq.ctU().fragment;
                        z = true;
                    }
                    if (deleteThreadHttpResponseMessage.getError() == 0) {
                        String text = !TextUtils.isEmpty(deleteThreadHttpResponseMessage.getText()) ? deleteThreadHttpResponseMessage.getText() : FrsFragment.this.getString(R.string.delete_fail);
                        if (deleteThreadHttpResponseMessage.getRetType() == 1211066) {
                            if (FrsFragment.this.hlZ == null) {
                                FrsFragment.this.hlZ = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.hlZ.zA(text);
                            FrsFragment.this.hlZ.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.29.1
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.hlZ.ih(false);
                            FrsFragment.this.hlZ.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.hlZ.bhg();
                        } else if (deleteThreadHttpResponseMessage.getRetType() == 1211067) {
                            if (FrsFragment.this.hlZ == null) {
                                FrsFragment.this.hlZ = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.hlZ.zA(text);
                            FrsFragment.this.hlZ.a(R.string.know, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.29.2
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.hlZ.ih(false);
                            FrsFragment.this.hlZ.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.hlZ.bhg();
                        } else {
                            FrsFragment.this.hSV.aL(deleteThreadHttpResponseMessage.getText(), ContextCompat.getColor(FrsFragment.this.getContext(), deleteThreadHttpResponseMessage.getRetType() == 1 ? R.color.nav_bar_tip_error : R.color.cp_link_tip_a_alpha95));
                        }
                        if (z && frsNewAreaFragment != null) {
                            frsNewAreaFragment.cP(deleteThreadHttpResponseMessage.getSuccessItems());
                        }
                        FrsFragment.this.cD(deleteThreadHttpResponseMessage.getSuccessItems());
                        b.ckT().cC(deleteThreadHttpResponseMessage.getSuccessItems());
                        for (com.baidu.adp.widget.ListView.q qVar : FrsFragment.this.hSt.getThreadList()) {
                            if (qVar instanceof bv) {
                                i3++;
                                continue;
                            }
                            if (i3 >= 6) {
                                break;
                            }
                        }
                        if (i3 < 6) {
                            FrsFragment.this.bFE();
                            return;
                        }
                        return;
                    }
                    com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getActivity(), deleteThreadHttpResponseMessage.getErrorString());
                }
            }
        });
        this.dhi = UtilHelper.getScreenHeight(getActivity());
        this.hasInit = true;
        wT(1);
        super.onActivityCreated(bundle);
        this.createTime = System.currentTimeMillis() - j;
    }

    public void oh(boolean z) {
        if (this.hTq != null) {
            this.hTq.ivp = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cD(List<String> list) {
        if (!com.baidu.tbadk.core.util.y.isEmpty(list)) {
            ArrayList<com.baidu.adp.widget.ListView.q> threadList = this.hSt.getThreadList();
            if (!com.baidu.tbadk.core.util.y.isEmpty(threadList) && this.hSV.getListView() != null && this.hSV.getListView().getData() != null) {
                Iterator<com.baidu.adp.widget.ListView.q> it = threadList.iterator();
                List<com.baidu.adp.widget.ListView.q> data = this.hSV.getListView().getData();
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.q next = it.next();
                    if (next instanceof bv) {
                        bw bwVar = ((bv) next).dUW;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= list.size()) {
                                break;
                            } else if (!com.baidu.tbadk.core.util.at.equals(list.get(i2), bwVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.hTz.d(next);
                                this.hSV.getListView().getAdapter().notifyItemRemoved(i);
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
    public void ckR() {
        if (!com.baidu.tbadk.core.util.y.isEmpty(com.baidu.tieba.frs.a.ckM().ckQ()) && this.hSV.getListView() != null && this.hSV.getListView().getData() != null) {
            ArrayList<com.baidu.adp.widget.ListView.q> threadList = this.hSt.getThreadList();
            if (!com.baidu.tbadk.core.util.y.isEmpty(threadList)) {
                Iterator<com.baidu.adp.widget.ListView.q> it = threadList.iterator();
                List<com.baidu.adp.widget.ListView.q> data = this.hSV.getListView().getData();
                int count = com.baidu.tbadk.core.util.y.getCount(com.baidu.tieba.frs.a.ckM().ckQ());
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.q next = it.next();
                    if (next instanceof bv) {
                        bw bwVar = ((bv) next).dUW;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= count) {
                                break;
                            } else if (!com.baidu.tbadk.core.util.at.equals(com.baidu.tieba.frs.a.ckM().ckQ().get(i2).getId(), bwVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.hTz.d(next);
                                this.hSV.getListView().getAdapter().notifyItemRemoved(i);
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
    public void bFZ() {
        if (isAdded() && this.fGM && !isLoadingViewAttached()) {
            showLoadingView(this.hSV.bZc(), true);
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void bGa() {
        if (isAdded() && this.fGM && isLoadingViewAttached()) {
            hideLoadingView(this.hSV.bZc());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (cmA()) {
            showLoadingView(this.hSV.bZc(), true);
            this.hSV.xh(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.hTo.Q(3, true);
            blc().scrollToPosition(0);
        }
    }

    private void wT(int i) {
        String str = "";
        if (this.hSt != null && this.hSt.getForum() != null) {
            str = this.hSt.getForum().getId();
        }
        if (!StringUtils.isNull(str)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13008").dD("fid", str).dD("obj_type", "4").ai("obj_locate", i).dD("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.aa aaVar) {
        if (aaVar != null) {
            this.eVG = aaVar.bvH();
            this.hTG = aaVar.bvI();
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void showFloatingView() {
        if (this.eVG != null) {
            this.eVG.showFloatingView(true);
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
                this.hSN = uri.getQueryParameter("name");
                this.mFrom = uri.getQueryParameter("from");
                if (!StringUtils.isNull(this.hSN)) {
                    intent.putExtra("name", this.hSN);
                }
                if (!StringUtils.isNull(this.mFrom)) {
                    intent.putExtra("from", this.mFrom);
                }
                TiebaStatic.log(TbadkCoreStatisticKey.AS_INVOKE_TIEBA);
            }
            if (StringUtils.isNull(this.hSN) && uri != null) {
                if (com.baidu.tbadk.BdToken.f.p(uri)) {
                    com.baidu.tbadk.BdToken.f.aYL().b(uri, this.hUB);
                } else {
                    com.baidu.tieba.frs.f.d X = com.baidu.tieba.frs.f.i.X(intent);
                    if (X != null) {
                        this.hSN = X.forumName;
                        if (X.isT == null || X.isT.equals("aidou")) {
                        }
                    }
                }
                if (!StringUtils.isNull(this.hSN)) {
                    intent.putExtra("name", this.hSN);
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
                if (hashMap.get(com.baidu.tbadk.BdToken.f.dPj) instanceof String) {
                    FrsFragment.this.hSN = (String) hashMap.get(com.baidu.tbadk.BdToken.f.dPj);
                }
                if ((hashMap.get(com.baidu.tbadk.BdToken.f.dPB) instanceof String) && !TextUtils.isEmpty((String) hashMap.get(com.baidu.tbadk.BdToken.f.dPB))) {
                    com.baidu.adp.lib.f.e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.30.1
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsFragment.this.hTq.yU(301);
                            final long j = com.baidu.adp.lib.f.b.toLong((String) hashMap.get(com.baidu.tbadk.BdToken.f.dPk), 0L);
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
        this.hSU = getVoiceManager();
        if (this.hSU != null) {
            this.hSU.onStart(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        Intent intent;
        long j = 0;
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.eCw);
        if (bundle != null) {
            this.hSN = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            j = bundle.getLong(FrsActivityConfig.FRS_FAKE_THREAD_ID, 0L);
        } else if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
            this.hSN = intent.getStringExtra("name");
            this.mFrom = intent.getStringExtra("from");
            this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
            j = intent.getLongExtra(FrsActivityConfig.FRS_FAKE_THREAD_ID, 0L);
        }
        if (getArguments() != null) {
            this.hSO = getArguments().getBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, false);
        }
        if (TextUtils.isEmpty(this.mFrom) || FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
        }
        if (this.mIsLogin) {
            registerListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL, this.eCw);
        }
        this.hTp.aq(bundle);
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
                    requestGetMyPostNetMessage.setHideErrorToast(true);
                    MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
                }
            }, 1000L);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.s.c.dvJ().B(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.hUI);
        this.hTA.destroy();
        hSZ = null;
        if (this.hSU != null) {
            this.hSU.onDestory(getPageContext());
        }
        com.baidu.tieba.recapp.report.a.remove("FRS");
        this.hSU = null;
        com.baidu.tieba.card.s.cbY().nm(false);
        if (this.hSt != null && this.hSt.getForum() != null) {
            ak.cob().eH(com.baidu.adp.lib.f.b.toLong(this.hSt.getForum().getId(), 0L));
        }
        if (this.hTC != null) {
            this.hTC.onDestory();
        }
        if (this.hSV != null) {
            com.baidu.tieba.frs.f.h.a(this.hSV, this.hSt, getForumId(), false, null);
            this.hSV.onDestroy();
        }
        if (this.hSY != null) {
            this.hSY.removeAllViews();
            this.hSY.setVisibility(8);
        }
        if (this.hTW != null) {
            this.hTW.cancel();
        }
        if (this.hTX != null) {
            com.baidu.adp.lib.f.e.mS().removeCallbacks(this.hTX);
        }
        this.hTV = null;
        super.onDestroy();
        try {
            if (this.hTi != null) {
                this.hTi.bug();
            }
            if (this.hSV != null) {
                this.hSV.release();
            }
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.hTp.crr();
        Looper.myQueue().removeIdleHandler(this.hUb);
        if (this.hTo != null) {
            this.hTo.bLP();
        }
        if (this.hTu != null) {
            this.hTu.coj();
        }
        if (this.hTx != null) {
            this.hTx.destory();
        }
        if (this.hTs != null) {
            this.hTs.onDestroy();
        }
        if (this.hTI != null) {
            this.hTI.onDestory();
        }
        if (this.hTB != null) {
            this.hTB.onDestroy();
        }
        if (this.hTK != null) {
            this.hTK.onDestroy();
        }
        if (this.hTL != null) {
            this.hTL.onDestroy();
        }
        com.baidu.tieba.recapp.d.a.dnZ().doc();
        com.baidu.tieba.frs.f.j.csP();
        if (this.hTq != null) {
            this.hTq.a((FrsTabViewController.a) null);
            this.hTq.ctW();
        }
        if (this.hTO != null) {
            this.hTO.onDestroy();
        }
        b.ckT().a(null);
        com.baidu.tieba.frs.a.ckM().a(null);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.hSN);
        bundle.putString("from", this.mFrom);
        this.hTo.onSaveInstanceState(bundle);
        if (this.hSU != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            this.hSU.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.hTB != null) {
            this.hTB.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.hSV != null) {
            this.hSV.cnf();
            this.hSV.onResume();
        }
        this.hTr.pb(true);
        this.hTj = true;
        if (hSM) {
            hSM = false;
            if (this.hSV != null) {
                this.hSV.startPullRefresh();
                return;
            }
            return;
        }
        if (this.hSU != null) {
            this.hSU.onResume(getPageContext());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_RESUME));
        if (this.hSV != null) {
            this.hSV.ot(false);
        }
        if (this.hTJ) {
            refresh(6);
            this.hTJ = false;
        }
        if (this.hTS != null && getActivity() != null) {
            if (NotificationManagerCompat.from(getActivity()).areNotificationsEnabled()) {
                com.baidu.tbadk.coreExtra.messageCenter.f.boU().setSignAlertOn(true);
                com.baidu.tbadk.coreExtra.messageCenter.f.boU().setSignAlertTime(this.hTS.getHours(), this.hTS.getMinutes());
                if (this.hSV != null) {
                    com.baidu.tbadk.coreExtra.messageCenter.f.boU().a(getTbPageContext().getPageActivity(), this.hSV.bZc());
                }
            }
            this.hTS = null;
        }
        cmH();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
    }

    public boolean cmk() {
        Intent intent;
        if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
            return false;
        }
        return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
    }

    public void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.hSN = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.hSP = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.hSP) {
                cml();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cml() {
        this.hSV.startPullRefresh();
    }

    public void closeActivity() {
        com.baidu.tieba.frs.f.i.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.mFrom);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.hSV.setTitle(this.hSN);
        } else {
            this.hSV.setTitle("");
            this.mFlag = 1;
        }
        this.hSV.a(this.hUG);
        this.hSV.addOnScrollListener(this.mScrollListener);
        this.hSV.g(this.hQf);
        this.hSV.cns().a(this.hUF);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hTQ) {
            this.hSV.onChangeSkinType(i);
            this.hTp.yK(i);
            this.hTq.onChangeSkinType(i);
            if (this.hSX != null) {
                this.hSX.onChangeSkinType(i);
            }
            if (this.hTH != null) {
                this.hTH.onChangeSkinType();
            }
            if (this.hTM != null) {
                this.hTM.onChangeSkinType(getPageContext(), i);
            }
            if (this.hlZ != null) {
                com.baidu.tbadk.r.a.a(getPageContext(), this.hlZ.getRealView());
            }
            if (this.hTI != null) {
                this.hTI.onChangeSkinType(getPageContext(), i);
            }
        }
    }

    public void wU(int i) {
        if (!this.mIsLogin) {
            if (this.hSt != null && this.hSt.getAnti() != null) {
                this.hSt.getAnti().setIfpost(1);
            }
            if (i == 0) {
                com.baidu.tbadk.core.util.bg.skipToLoginActivity(getActivity());
            }
        } else if (this.hSt != null) {
            if (i == 0) {
                com.baidu.tieba.frs.f.j.g(this, 0);
            } else {
                this.hSV.cnh();
            }
        }
    }

    public void refresh() {
        com.baidu.tieba.a.d.bAB().Dj("page_frs");
        refresh(3);
    }

    public void refresh(int i) {
        this.hTg = false;
        cms();
        if (this.hSV != null && this.hSV.cmW() != null) {
            this.hSV.cmW().cxq();
        }
        if (this.hTo != null) {
            this.hTo.Q(i, true);
        }
    }

    private void cmm() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.f.h.mT().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.36
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.QR(FrsFragment.this.hSN);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmn() {
        cms();
        try {
            if (this.hSt != null) {
                this.hSV.bLt();
                this.hSV.om(cmG());
                if (!com.baidu.tieba.frs.vc.h.m(this.hSt) || !com.baidu.tieba.frs.vc.h.l(this.hSt)) {
                }
                if (this.hSt.getForum() != null) {
                    this.hSN = this.hSt.getForum().getName();
                    this.forumId = this.hSt.getForum().getId();
                }
                if (this.hSt.getPage() != null) {
                    setHasMore(this.hSt.getPage().bdu());
                }
                this.hSV.setTitle(this.hSN);
                this.hSV.setForumName(this.hSN);
                TbadkCoreApplication.getInst().setDefaultBubble(this.hSt.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.hSt.getUserData().getBimg_end_time());
                cmm();
                cmo();
                ArrayList<com.baidu.adp.widget.ListView.q> threadList = this.hSt.getThreadList();
                if (threadList != null) {
                    this.hSV.a(threadList, this.hSt);
                    com.baidu.tieba.frs.f.c.A(this.hSV);
                    this.hTp.yL(getPageNum());
                    this.hTp.i(this.hSt);
                    this.hTq.a(this.hSt, this.hTo.crX());
                    this.hSV.cni();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void cmo() {
        if (this.hSt != null) {
            if (this.hSt.getIsNewUrl() == 1) {
                this.hSV.cns().setFromCDN(true);
            } else {
                this.hSV.cns().setFromCDN(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.hTr.pb(false);
        this.hTj = false;
        this.hSV.onPause();
        if (this.hSU != null) {
            this.hSU.onPause(getPageContext());
        }
        this.hSV.ot(true);
        if (this.hTx != null) {
            this.hTx.csS();
        }
        com.baidu.tbadk.BdToken.c.aYs().aYC();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.hTq != null && this.hTq.ctU() != null && (this.hTq.ctU().fragment instanceof BaseFragment)) {
            ((BaseFragment) this.hTq.ctU().fragment).setPrimary(z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.s.cbY().nm(false);
        of(false);
        if (this.hSt != null && this.hSt.getForum() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            com.baidu.tbadk.distribute.a.brj().b(getPageContext().getPageActivity(), "frs", this.hSt.getForum().getId(), 0L);
        }
        if (this.hSU != null) {
            this.hSU.onStop(getPageContext());
        }
        if (blc() != null) {
            blc().getRecycledViewPool().clear();
        }
        this.hTp.bkq();
        com.baidu.tbadk.util.ab.bvK();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            if (this.hTp != null) {
                this.hTp.bJ(isPrimary());
            }
            if (this.hSV != null) {
                this.hSV.bJ(isPrimary());
                this.hSV.ot(!isPrimary());
            }
        }
    }

    private void cmp() {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.nw(2);
        aVar.ih(false);
        FrsBroadcastCopyGuideDialogView frsBroadcastCopyGuideDialogView = new FrsBroadcastCopyGuideDialogView(getPageContext().getPageActivity());
        frsBroadcastCopyGuideDialogView.setConfirmButtonListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.37
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aVar != null) {
                    aVar.dismiss();
                    FrsFragment.this.cmq();
                }
            }
        });
        aVar.aX(frsBroadcastCopyGuideDialogView);
        aVar.b(getPageContext()).bhg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmq() {
        if (KuangFloatingFrsCopyLinkViewController.getInstance().init()) {
            ((BaseFragmentActivity) getPageContext().getOrignalPage()).grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.frs.FrsFragment.38
                @Override // com.baidu.tbadk.core.e
                public void onPermissionResult(boolean z) {
                    if (!z) {
                        new BdTopToast(FrsFragment.this.getContext()).wU(false).Sp(FrsFragment.this.getContext().getString(R.string.forum_broadcast_copy_no_permission_hint)).aE(FrsFragment.this.hSV.bZc());
                        return;
                    }
                    KuangFloatingFrsCopyLinkViewController.getInstance().showFloatingView(true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                    if (FrsFragment.this.hSW != null) {
                        FrsFragment.this.hSW.setVisibility(8);
                    }
                }
            }, true);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (b.ckT().ckN()) {
                b.ckT().reset();
                return true;
            } else if (com.baidu.tieba.frs.a.ckM().ckN()) {
                if (this.hSV != null && this.hSV.cnx()) {
                    this.hSV.cny();
                    return true;
                }
                com.baidu.tieba.frs.a.ckM().reset();
                return true;
            } else if (this.hSV != null) {
                return this.hSV.cne();
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
        com.baidu.tbadk.distribute.a.brj().a(advertAppInfo, this.forumId, 0L, "FRS", str, getPn());
    }

    @Override // com.baidu.tieba.recapp.n
    public void cmr() {
        clO().cmr();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.hSU == null) {
            this.hSU = VoiceManager.instance();
        }
        return this.hSU;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdRecyclerView blc() {
        if (this.hSV == null) {
            return null;
        }
        return this.hSV.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void cms() {
        if (this.hSU != null) {
            this.hSU.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> bld() {
        if (this.evt == null) {
            this.evt = UserIconBox.u(getPageContext().getPageActivity(), 8);
        }
        return this.evt;
    }

    public void cmt() {
        if (getFragmentActivity() != null && getFragmentActivity().getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.t onGetPreLoadListView() {
        return blc().getPreLoadHandle();
    }

    @Override // com.baidu.tieba.frs.at
    public NavigationBar bJI() {
        if (this.hSV == null) {
            return null;
        }
        return this.hSV.bJI();
    }

    public FRSRefreshButton cmu() {
        return this.hSX;
    }

    public void c(LinearLayout linearLayout) {
        if (linearLayout != null) {
            this.hSY = linearLayout;
        }
    }

    public void a(FRSRefreshButton fRSRefreshButton) {
        if (fRSRefreshButton != null) {
            this.hSX = fRSRefreshButton;
            this.hSX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.44
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (FrsFragment.this.hTq != null) {
                        FrsTabViewController.b ctU = FrsFragment.this.hTq.ctU();
                        if (ctU != null && ctU.fragment != null && (ctU.fragment instanceof as)) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                            ((as) ctU.fragment).clA();
                            ((as) ctU.fragment).bGR();
                            return;
                        }
                        FrsFragment.this.clT().startPullRefresh();
                    }
                }
            });
        }
    }

    public void cmv() {
        if (this.hSX != null) {
            this.hSX.hide();
        }
    }

    public void cmw() {
        if (this.hSX != null) {
            this.hSX.show();
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
                if (bdUniqueId == w.hWK) {
                    if (FrsFragment.this.hSV != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11752").dD("fid", FrsFragment.this.forumId).dD("obj_locate", "1"));
                        FrsFragment.this.hSV.startPullRefresh();
                    }
                } else if (qVar != null && (qVar instanceof bv)) {
                    bw bwVar = ((bv) qVar).dUW;
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
                                if (bdUniqueId.getId() == bw.ecV.getId()) {
                                    com.baidu.tieba.frs.f.h.a(bwVar.bek());
                                } else if (bdUniqueId.getId() == bw.ebw.getId()) {
                                    com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                                    aqVar.dD("obj_type", "2");
                                    aqVar.dD("tid", bwVar.getTid());
                                    TiebaStatic.log(aqVar);
                                }
                                com.baidu.tieba.frs.f.i.a(FrsFragment.this, bwVar, i, z);
                                com.baidu.tieba.frs.f.h.a(FrsFragment.this, FrsFragment.this.hSt, bwVar);
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
            hideNetRefreshView(this.hSV.bZc());
            showLoadingView(this.hSV.bZc(), true);
            this.hSV.op(false);
            this.hTo.Q(3, true);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData cmx() {
        return this.hSt;
    }

    public boolean cmy() {
        return this.hSV.cmy();
    }

    public void aC(Object obj) {
        if (this.hTt != null && this.hTt.iop != null) {
            this.hTt.iop.callback(obj);
        }
    }

    public void aD(Object obj) {
        if (this.hTt != null && this.hTt.ioq != null) {
            this.hTt.ioq.callback(obj);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        this.hSV.getListView().stopScroll();
        if (!this.hSV.cno()) {
            if (!com.baidu.adp.lib.util.l.isNetOk()) {
                this.hSV.bGU();
            } else if (this.hTo.crS() == 1) {
                bFT();
                bFE();
            } else if (this.hTo.hasMore()) {
                bFE();
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void onFailed(String str) {
        bFT();
        showToast(str);
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void au(ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        boolean isEmpty = com.baidu.tbadk.core.util.y.isEmpty(arrayList);
        setHasMore(isEmpty ? 0 : 1);
        bFT();
        if (!isEmpty) {
            if (!this.hTo.csc() && TbadkCoreApplication.getInst().isRecAppExist() && this.hTo.crS() == 1) {
                this.hSt.addRecommendAppToThreadList(this, arrayList);
            }
            if (this.hTo != null) {
                com.baidu.tieba.frs.d.a.a(getUniqueId(), arrayList, this.hSt.getForum(), this.hTo.getSortType());
            }
            ArrayList<com.baidu.adp.widget.ListView.q> a2 = this.hTz.a(false, false, arrayList, this.hSR, false);
            if (a2 != null) {
                this.hSt.setThreadList(a2);
                this.hSV.a(a2, this.hSt);
            }
            if (this.hTo != null) {
                com.baidu.tieba.frs.d.c.a(this.hSt, this.hTo.crX(), 2, getContext());
            }
        }
    }

    private void bFT() {
        if (clU() == 1 || this.hTz.cO(this.hSt.getThreadListIds())) {
            if (com.baidu.tbadk.core.util.y.getCount(this.hSt.getThreadList()) > 3) {
                this.hSV.bGS();
            } else {
                this.hSV.cnv();
            }
        } else if (com.baidu.tbadk.core.util.y.isEmpty(this.hSt.getThreadList())) {
            this.hSV.bGU();
        } else {
            this.hSV.bGT();
        }
    }

    @Override // com.baidu.tieba.frs.mc.l
    public void bFE() {
        if (this.hTz != null) {
            this.hTz.a(this.hSN, this.forumId, this.hSt);
        }
    }

    public void cmz() {
        if (!com.baidu.tbadk.core.util.ae.requestWriteExternalStorgeAndCameraPermission(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.ao.g(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment, com.baidu.m.a.a.InterfaceC0210a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        com.baidu.tieba.frs.f.i.a(this, i, strArr, iArr);
    }

    public void oi(boolean z) {
        if (this.hTu != null) {
            this.hTu.oC(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.hTv.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a rQ(int i) {
        return this.hTv.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        this.hTD.b(bVar);
    }

    public boolean cmA() {
        return this.hSJ;
    }

    @Override // com.baidu.tieba.frs.aq
    public void OA() {
        if (this.hSV != null) {
            showFloatingView();
            this.hSV.getListView().scrollToPosition(0);
            this.hSV.startPullRefresh();
        }
    }

    public ForumWriteData cmB() {
        if (this.hSt == null || this.hSt.getForum() == null) {
            return null;
        }
        ForumData forum = this.hSt.getForum();
        ForumWriteData forumWriteData = new ForumWriteData(forum.getId(), forum.getName(), forum.getPrefixData(), this.hSt.getAnti());
        forumWriteData.avatar = forum.getImage_url();
        forumWriteData.forumLevel = forum.getUser_level();
        forumWriteData.specialForumType = forum.special_forum_type;
        forumWriteData.firstDir = forum.getFirst_class();
        forumWriteData.secondDir = forum.getSecond_class();
        UserData userData = this.hSt.getUserData();
        forumWriteData.privateThread = userData != null ? userData.getPrivateThread() : 0;
        forumWriteData.frsTabInfo = cmC();
        return forumWriteData;
    }

    private FrsTabInfoData cmC() {
        int i;
        if (this.hTo == null || this.hSt == null || this.hTq == null) {
            return null;
        }
        if (this.hSt.getEntelechyTabInfo() == null || com.baidu.tbadk.core.util.y.isEmpty(this.hSt.getEntelechyTabInfo().tab)) {
            return null;
        }
        int ctY = this.hTq.ctY();
        if (ctY == 502) {
            return null;
        }
        int i2 = -1;
        ArrayList arrayList = new ArrayList();
        Iterator<FrsTabInfo> it = this.hSt.getEntelechyTabInfo().tab.iterator();
        while (true) {
            i = i2;
            if (!it.hasNext()) {
                break;
            }
            FrsTabInfo next = it.next();
            if (next != null && next.is_general_tab.intValue() == 1) {
                arrayList.add(new FrsTabItemData(next));
                if (ctY == next.tab_id.intValue()) {
                    i2 = ctY;
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

    public void oj(boolean z) {
        this.hTk = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z) {
        this.hSV.xc(8);
        ((FrsActivity) getActivity()).showLoadingView(view, z);
        ((FrsActivity) getActivity()).i(view, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        this.hSV.xc(0);
        ((FrsActivity) getActivity()).hideLoadingView(view);
        ((FrsActivity) getActivity()).i(view, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        super.showNetRefreshView(view, getResources().getString(R.string.refresh_view_title_text), null, getResources().getString(R.string.refresh_view_button_text), z, getNetRefreshListener());
        this.hSV.xc(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshViewNoClick(View view, String str, boolean z) {
        super.showNetRefreshViewNoClick(view, str, z);
        this.hSV.xc(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        super.hideNetRefreshView(view);
        this.hSV.xc(0);
    }

    public void cmD() {
        FrsTabViewController.b ctU;
        if (this.hTq != null && (ctU = this.hTq.ctU()) != null && ctU.fragment != null && (ctU.fragment instanceof as)) {
            ((as) ctU.fragment).clA();
        }
    }

    public void ok(boolean z) {
        this.hSL = z;
    }

    public void b(OvalActionButton ovalActionButton) {
        this.hSW = ovalActionButton;
    }

    public OvalActionButton cmE() {
        return this.hSW;
    }

    public boolean cmF() {
        return this.hSL;
    }

    public void onShareSuccess(String str) {
        if (TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.util.at.isEmpty(str)) {
            if (this.hTO == null) {
                this.hTO = new AddExperiencedModel(getTbPageContext());
            }
            this.hTO.fK(this.forumId, str);
        }
    }

    public boolean cmG() {
        if (this.hTk && !this.hTR) {
            return (this.hTo != null && this.hTo.crT() && (b.ckT().ckN() || com.baidu.tieba.frs.a.ckM().ckN())) ? false : true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.f.b
    public boolean videoNeedPreload() {
        if (this.hSt != null) {
            return com.baidu.tbadk.util.ah.qL(2) || (com.baidu.tbadk.util.ah.bvQ() && this.hSt.isFrsVideoAutoPlay);
        }
        return super.videoNeedPreload();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmH() {
        if (!com.baidu.tbadk.core.util.at.isEmpty(this.forumId)) {
            com.baidu.tbadk.BdToken.c.aYs().q(com.baidu.tbadk.BdToken.b.dNK, com.baidu.adp.lib.f.b.toLong(this.forumId, 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmI() {
        String format;
        String str;
        if (isResumed() && this.hTV != null && this.hTV.size() >= 1 && this.hTU <= this.hTV.size() - 1) {
            final LiveHorseRaceData liveHorseRaceData = this.hTV.get(this.hTU);
            if (System.currentTimeMillis() / 1000 >= liveHorseRaceData.getRob_end_tm().longValue()) {
                this.hTU++;
                cmI();
            }
            if (this.hSY != null) {
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
                        if (FrsFragment.this.hSt == null) {
                            str2 = "";
                        } else if (FrsFragment.this.hSt.getForum() != null) {
                            str2 = FrsFragment.this.hSt.getForum().getName();
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
                this.hTW = ValueAnimator.ofFloat(1.0f, 0.0f);
                this.hTW.setDuration(600L);
                this.hTW.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.FrsFragment.52
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        if (valueAnimator.isRunning()) {
                            frsRedpackRunView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                            frsRedpackRunView.setTranslationX(-(TbadkApplication.getInst().getContext().getResources().getDimensionPixelOffset(R.dimen.tbds850) * valueAnimator.getAnimatedFraction()));
                        }
                    }
                });
                this.hTW.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.FrsFragment.53
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        frsRedpackRunView.setAlpha(0.0f);
                        frsRedpackRunView.setTranslationY(TbadkApplication.getInst().getContext().getResources().getDimensionPixelOffset(R.dimen.tbds660));
                        frsRedpackRunView.hide();
                        FrsFragment.this.hSY.removeView(frsRedpackRunView);
                        if (FrsFragment.this.hTU > FrsFragment.this.hTV.size() - 1) {
                            FrsFragment.this.hSY.removeAllViews();
                            FrsFragment.this.hSY.setVisibility(8);
                            FrsFragment.this.hTU = 0;
                            return;
                        }
                        FrsFragment.this.cmI();
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        onAnimationEnd(animator);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                this.hTX = new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.54
                    @Override // java.lang.Runnable
                    public void run() {
                        if (FrsFragment.this.hSY != null && frsRedpackRunView != null) {
                            FrsFragment.this.hTW.start();
                        }
                    }
                };
                com.baidu.adp.lib.f.e.mS().postDelayed(this.hTX, 5000L);
                if (this.hSY.getChildCount() == 0) {
                    this.hTU++;
                    this.hSY.addView(frsRedpackRunView);
                    if (this.hSt != null) {
                        str = this.hSt.getForum() != null ? this.hSt.getForum().getName() : "";
                    } else {
                        str = "";
                    }
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13743").ai("obj_source", 1).dD("fid", this.forumId).dD("fname", str));
                }
                if (this.hSY.getVisibility() == 8 && ((BaseFragment) this.hTq.ctU().fragment).isPrimary() && !this.hSV.cnE() && !this.hTe) {
                    this.hSY.setVisibility(0);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        FrsTabViewController.b ctU;
        if (clR() == null || (ctU = clR().ctU()) == null || !(ctU.fragment instanceof BaseFragment)) {
            return null;
        }
        if (ctU.fragment instanceof FrsAllThreadFragment) {
            TbPageTag tbPageTag = super.getTbPageTag();
            int i = -1;
            if (this.hSt != null) {
                i = this.hSt.getSortType();
            }
            tbPageTag.sortType = com.baidu.tieba.frs.f.g.yI(i);
            tbPageTag.locatePage = "a070";
            if (this.hSG.equals(ctU.title)) {
                tbPageTag.locatePage = "a071";
            }
            return tbPageTag;
        } else if (ctU.fragment instanceof FrsFragment) {
            return null;
        } else {
            return ((BaseFragment) ctU.fragment).getTbPageTag();
        }
    }

    public void cmJ() {
        if (this.hSt != null) {
            com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
            if (this.hSt.needLog == 1) {
                bVar.iqZ = true;
            } else {
                bVar.iqZ = false;
            }
            if (this.hSt.getForum() != null) {
                bVar.irb = this.hSt.getForum().getId();
            }
            if (clO() != null) {
                bVar.ira = clO().crX();
            }
            if (com.baidu.tieba.frs.d.d.icR != null) {
                bVar.irc = com.baidu.tieba.frs.d.d.icR.irc;
                bVar.ird = com.baidu.tieba.frs.d.d.icR.ird;
            }
            this.hTY = new com.baidu.tieba.frs.live.b(bVar, getTbPageTag(), getUniqueId());
            this.hTY.yl(this.hUa);
            CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_CARD_CLICK, this.hTY);
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
            CustomMessageTask customMessageTask2 = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW, this.hTY);
            customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask2);
            CustomMessageTask customMessageTask3 = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_USER_CLICK, this.hTY);
            customMessageTask3.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask3);
            CustomMessageTask customMessageTask4 = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_VIDEO_CLICK, this.hTY);
            customMessageTask4.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask4);
        }
    }
}
