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
import com.baidu.i.a.a;
import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.bf;
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
public class FrsFragment extends BaseFragment implements BdListView.e, a.InterfaceC0153a, UserIconBox.b<BdRecyclerView>, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, ao, ar, au, com.baidu.tieba.frs.loadmore.a, com.baidu.tieba.frs.mc.l, com.baidu.tieba.recapp.n {
    public static com.baidu.tieba.tbadkCore.m hFD;
    private com.baidu.tbadk.util.z eKX;
    private com.baidu.adp.lib.d.b<TbImageView> elu;
    private com.baidu.tieba.frs.gametab.b fLL;
    private com.baidu.tbadk.core.dialog.a gZc;
    private OvalActionButton hFA;
    private FRSRefreshButton hFB;
    private LinearLayout hFC;
    public long hFE;
    private String hFP;
    private com.baidu.card.ak hFR;
    private FrsModelController hFS;
    private com.baidu.tieba.frs.vc.h hFT;
    private FrsTabViewController hFU;
    private com.baidu.tieba.frs.mc.h hFV;
    private com.baidu.tieba.frs.smartsort.a hFW;
    private com.baidu.tieba.frs.mc.b hFX;
    private av hFY;
    private com.baidu.tieba.frs.entelechy.a hFl;
    private com.baidu.tieba.tbadkCore.data.f hFv;
    private VoiceManager hFy;
    private ValueAnimator hGA;
    private Runnable hGB;
    private com.baidu.tieba.frs.live.b hGC;
    private com.baidu.tieba.frs.broadcast.a hGD;
    private int hGE;
    private int hGO;
    private com.baidu.tieba.frs.entelechy.b.b hGa;
    private com.baidu.tieba.frs.vc.a hGb;
    private com.baidu.tieba.frs.mc.d hGc;
    private com.baidu.tieba.frs.mc.c hGd;
    private com.baidu.tieba.frs.vc.j hGe;
    private com.baidu.tieba.frs.mc.a hGf;
    private com.baidu.tieba.frs.live.a hGg;
    private o hGh;
    public com.baidu.tieba.frs.vc.c hGi;
    private com.baidu.tieba.frs.mc.e hGj;
    private View.OnTouchListener hGk;
    private com.baidu.tieba.frs.view.a hGl;
    private com.baidu.tieba.frs.vc.e hGm;
    private boolean hGn;
    private com.baidu.tieba.NEGFeedBack.a hGo;
    private com.baidu.tieba.ala.a hGp;
    private com.baidu.tieba.frs.brand.buttommenu.a hGq;
    private com.baidu.tieba.frs.sportspage.notification.a hGr;
    private AddExperiencedModel hGs;
    private boolean hGu;
    private List<LiveHorseRaceData> hGz;
    private View mRootView;
    private String mSchemeUrl;
    public static boolean hFq = false;
    public static volatile long hFG = 0;
    public static volatile long hFH = 0;
    public static volatile int mNetError = 0;
    private String hFk = "";
    public boolean hFm = false;
    private boolean hFn = false;
    private boolean hFo = false;
    private boolean hFp = true;
    public String hFr = null;
    public String mFrom = null;
    public int mFlag = 0;
    public boolean hFs = false;
    private boolean hFt = false;
    private String mThreadId = null;
    public String forumId = null;
    private int hEZ = 0;
    private boolean hFu = false;
    private boolean hFw = false;
    private boolean hFx = false;
    private p hFz = null;
    public final bv aii = null;
    private FrsViewData hEX = new FrsViewData();
    public long hio = -1;
    public long eHn = 0;
    public long eHd = 0;
    public long createTime = 0;
    public long eHe = 0;
    public long eHk = 0;
    public long hFF = 0;
    boolean hFI = false;
    public boolean hFJ = false;
    private boolean hFK = false;
    private boolean hFL = false;
    public com.baidu.tbadk.n.b hFM = null;
    private boolean hFN = true;
    private boolean hFO = true;
    private a.C0096a hFQ = new a.C0096a(2);
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> hFZ = new SparseArray<>();
    private boolean fvp = true;
    private boolean hasInit = false;
    private boolean hGt = false;
    private boolean hGv = false;
    private Date hGw = null;
    private int cXV = 0;
    private int hGx = 0;
    private int hGy = 0;
    public int mHeadLineDefaultNavTabId = -1;
    MessageQueue.IdleHandler hGF = new MessageQueue.IdleHandler() { // from class: com.baidu.tieba.frs.FrsFragment.1
        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            FrsFragment.this.cbJ();
            return false;
        }
    };
    private final CustomMessageListener hGG = new CustomMessageListener(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED) { // from class: com.baidu.tieba.frs.FrsFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof bv) {
                    com.baidu.tieba.frs.f.h.a(FrsFragment.this.hFz, FrsFragment.this.hEX, FrsFragment.this.getForumId(), true, (bv) data);
                }
            }
        }
    };
    private CustomMessageListener hGH = new CustomMessageListener(CmdConfigCustom.CMD_CLOSE_GAME_RANK_CARD) { // from class: com.baidu.tieba.frs.FrsFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.hEX != null) {
                FrsFragment.this.hEX.removeGameRankListFromThreadList();
                if (FrsFragment.this.hFz != null) {
                    FrsFragment.this.hFz.aJP();
                }
            }
        }
    };
    private CustomMessageListener aeE = new CustomMessageListener(2921401) { // from class: com.baidu.tieba.frs.FrsFragment.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && FrsFragment.this.hFB != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() <= 0 || FrsFragment.this.hFU.cjs() == 0 || FrsFragment.this.hFU.cjp() == null || !(FrsFragment.this.hFU.cjp().fragment instanceof BaseFragment) || !((BaseFragment) FrsFragment.this.hFU.cjp().fragment).isPrimary() || FrsFragment.this.hFz.cdg() || KuangFloatingFrsCopyLinkViewController.getInstance().isFloatCopyViewShow()) {
                    if (FrsFragment.this.hFU.cjs() != 0) {
                        FrsFragment.this.hFB.hide();
                        return;
                    }
                    return;
                }
                FrsFragment.this.hFB.show();
            }
        }
    };
    private CustomMessageListener hGI = new CustomMessageListener(2921473) { // from class: com.baidu.tieba.frs.FrsFragment.45
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && FrsFragment.this.hFB != null && FrsFragment.this.hFA != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() == 0) {
                    FrsFragment.this.hFB.setVisibility(8);
                    FrsFragment.this.hFA.setVisibility(8);
                    return;
                }
                FrsFragment.this.hFA.setVisibility(0);
            }
        }
    };
    private CustomMessageListener hGJ = new CustomMessageListener(2921467) { // from class: com.baidu.tieba.frs.FrsFragment.56
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && FrsFragment.this.hFB != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() <= 0 || FrsFragment.this.hFU.cjp() == null || !(FrsFragment.this.hFU.cjp().fragment instanceof BaseFragment) || !((BaseFragment) FrsFragment.this.hFU.cjp().fragment).isPrimary() || FrsFragment.this.hFz.cdg()) {
                    FrsFragment.this.hFC.setVisibility(8);
                    FrsFragment.this.hFI = true;
                    return;
                }
                FrsFragment.this.hFC.setVisibility(0);
                FrsFragment.this.hFI = false;
            }
        }
    };
    private com.baidu.adp.framework.listener.a hGK = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_FRS_LIVE_HORSE_RACE_LIST, 309667) { // from class: com.baidu.tieba.frs.FrsFragment.59
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if ((responsedMessage instanceof GetLiveHorseRaceHttpResponseMessage) || (responsedMessage instanceof GetLiveHorseRaceSocketResponseMessage)) {
                    List<LiveHorseRaceData> arrayList = new ArrayList<>();
                    if (responsedMessage instanceof GetLiveHorseRaceHttpResponseMessage) {
                        arrayList = ((GetLiveHorseRaceHttpResponseMessage) responsedMessage).getData().cdE();
                    }
                    if (responsedMessage instanceof GetLiveHorseRaceSocketResponseMessage) {
                        arrayList = ((GetLiveHorseRaceSocketResponseMessage) responsedMessage).getData().cdE();
                    }
                    if (FrsFragment.this.hGz != null) {
                        if (FrsFragment.this.hFC.getVisibility() != 8) {
                            if (FrsFragment.this.hGy >= FrsFragment.this.hGz.size()) {
                                FrsFragment.this.hGz.addAll(arrayList);
                                return;
                            }
                            FrsFragment.this.hGz = FrsFragment.this.hGz.subList(0, FrsFragment.this.hGy);
                            FrsFragment.this.hGz.addAll(arrayList);
                            return;
                        }
                        FrsFragment.this.hGz = new ArrayList();
                        FrsFragment.this.hGz.addAll(arrayList);
                        FrsFragment.this.hGy = 0;
                        FrsFragment.this.cck();
                        return;
                    }
                    FrsFragment.this.hGz = new ArrayList();
                    FrsFragment.this.hGy = 0;
                    FrsFragment.this.hGz.addAll(arrayList);
                    FrsFragment.this.cck();
                }
            }
        }
    };
    private CustomMessageListener hGL = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.FrsFragment.60
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 1) {
                    FrsFragment.this.cbN();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                }
            }
        }
    };
    private final at hGM = new at() { // from class: com.baidu.tieba.frs.FrsFragment.61
        @Override // com.baidu.tieba.frs.at
        public void a(int i, int i2, bb bbVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
            FrsFragment.this.cbz();
            if (FrsFragment.this.hGa != null) {
                FrsFragment.this.hFT.oC(FrsFragment.this.hGa.vq(i));
            }
            com.baidu.tieba.tbadkCore.f fVar = new com.baidu.tieba.tbadkCore.f();
            if (bbVar != null) {
                fVar.isSuccess = bbVar.errCode == 0;
                fVar.errorCode = bbVar.errCode;
                fVar.errorMsg = bbVar.errMsg;
                if (fVar.isSuccess) {
                    if (com.baidu.tbadk.core.util.x.isEmpty(arrayList)) {
                        FrsFragment.this.hFz.bxU();
                    } else if (bbVar.hasMore) {
                        if (com.baidu.tbadk.core.util.x.getCount(FrsFragment.this.hEX.getThreadList()) > 3) {
                            FrsFragment.this.hFz.bxS();
                        } else {
                            FrsFragment.this.hFz.ccX();
                        }
                    } else if (bbVar.hKp) {
                        FrsFragment.this.hFz.bxT();
                    } else {
                        FrsFragment.this.hFz.bxU();
                    }
                }
            } else {
                bbVar = new bb();
                bbVar.pn = 1;
                bbVar.hasMore = false;
                bbVar.hKp = false;
            }
            if (i == 1) {
                FrsFragment.this.hFN = true;
                FrsFragment.this.hHd.a(FrsFragment.this.hFS.getType(), false, fVar);
            } else {
                FrsFragment.this.a(fVar);
                if (FrsFragment.this.hFS.cgN() != null) {
                    FrsFragment.this.hEX = FrsFragment.this.hFS.cgN();
                }
                FrsFragment.this.cbP();
            }
            if (FrsFragment.this.hHl != null) {
                FrsFragment.this.hHl.a(i, i2, bbVar, arrayList);
            }
        }
    };
    private FrsTabViewController.a hGN = new FrsTabViewController.a() { // from class: com.baidu.tieba.frs.FrsFragment.2
        @Override // com.baidu.tieba.frs.vc.FrsTabViewController.a
        public void bW(int i, int i2) {
            boolean z = false;
            if (i != 1) {
                com.baidu.tieba.card.s.bRL().mH(false);
                FrsFragment.this.nz(false);
            }
            if (i == 502) {
                FrsFragment.this.hFA.setIconFade(R.drawable.btn_frs_professional_edit_n);
            } else {
                FrsFragment.this.hFA.setIconFade(0);
            }
            FrsFragment.this.hGO = i;
            FrsFragment.this.hGE = i2;
            if (FrsFragment.this.hGC != null) {
                FrsFragment.this.hGC.vS(FrsFragment.this.hGE);
            }
            TbSingleton.getInstance().setFrsCurTabType(FrsFragment.this.hGE);
            FrsFragment.this.cbU();
            com.baidu.tieba.frs.d.d.hOE.icN = i;
            com.baidu.tieba.frs.d.d.hOE.icO = -1;
            b.caw().N(i == 1 && FrsFragment.this.hGt, true);
            com.baidu.tieba.frs.a cap = com.baidu.tieba.frs.a.cap();
            if (i == 1 && FrsFragment.this.hGt) {
                z = true;
            }
            cap.N(z, true);
        }
    };
    private CustomMessageListener hGP = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIVE_COUNT) { // from class: com.baidu.tieba.frs.FrsFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                FrsFragment.this.hFU.wC(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    };
    private CustomMessageListener hGQ = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_LIVE_START) { // from class: com.baidu.tieba.frs.FrsFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && ((Integer) customResponsedMessage.getData()).intValue() == 51 && FrsFragment.this.hEX != null) {
                com.baidu.tieba.frs.f.j.a(FrsFragment.this.hEX, FrsFragment.this.getPageContext());
            }
        }
    };
    private final CustomMessageListener hGR = new CustomMessageListener(CmdConfigCustom.CMD_FRS_SELECT_ALA_LIVE_TAB) { // from class: com.baidu.tieba.frs.FrsFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                FrsFragment.this.hFU.wA(49);
            }
        }
    };
    private final CustomMessageListener hGS = new CustomMessageListener(2921470) { // from class: com.baidu.tieba.frs.FrsFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                FrsFragment.this.hFU.wA(1);
                FrsFragment.this.cbN();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
            }
        }
    };
    private final CustomMessageListener hGT = new CustomMessageListener(CmdConfigCustom.CMD_FRS_EXPERIENCE_TIP) { // from class: com.baidu.tieba.frs.FrsFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.u) && FrsFragment.this.hEX != null) {
                FrsFragment.this.hEX.updateLikeData((com.baidu.tieba.tbadkCore.u) customResponsedMessage.getData());
                FrsFragment.this.hFT.i(FrsFragment.this.hEX);
                FrsFragment.this.hFU.a(FrsFragment.this.hEX, FrsFragment.this.hFS.chr());
            }
        }
    };
    private final AntiHelper.a hGU = new AntiHelper.a() { // from class: com.baidu.tieba.frs.FrsFragment.8
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ap(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ah("obj_locate", aw.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ap(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ah("obj_locate", aw.a.LOCATE_LIKE_PERSON));
        }
    };
    private CustomMessageListener hGV = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.FrsFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(FrsFragment.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().erH != null) {
                        if (AntiHelper.a(FrsFragment.this.getActivity(), updateAttentionMessage.getData().erH, FrsFragment.this.hGU) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ap(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ah("obj_locate", aw.a.LOCATE_LIKE_PERSON));
                        }
                    } else if (updateAttentionMessage.getData().isSucc && updateAttentionMessage.getData().isAttention) {
                        com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getPageContext().getPageActivity(), R.string.attention_success);
                    }
                }
            }
        }
    };
    private CustomMessageListener hGW = new CustomMessageListener(CmdConfigCustom.CMD_GET_ENSURE_CAST_ID) { // from class: com.baidu.tieba.frs.FrsFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsFragment.this.refresh();
        }
    };
    private CustomMessageListener hGX = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.frs.FrsFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && !((PostWriteCallBackData) customResponsedMessage.getData()).isDyamicCallback()) {
                FrsFragment.this.hFz.c((PostWriteCallBackData) customResponsedMessage.getData());
                if (((PostWriteCallBackData) customResponsedMessage.getData()).getGeneralTabId() >= 0) {
                    FrsFragment.this.hGf.vU(((PostWriteCallBackData) customResponsedMessage.getData()).getGeneralTabId());
                }
            }
        }
    };
    private CustomMessageListener hGY = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_REMIND) { // from class: com.baidu.tieba.frs.FrsFragment.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626) {
                NewsRemindMessage newsRemindMessage = (NewsRemindMessage) customResponsedMessage;
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (FrsFragment.this.hFz != null) {
                    FrsFragment.this.hFz.L(notificationCount, z);
                }
            }
        }
    };
    private HttpMessageListener hGZ = new HttpMessageListener(CmdConfigHttp.CMD_FRS_MOVE_AREA) { // from class: com.baidu.tieba.frs.FrsFragment.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int i;
            int i2 = 0;
            if (httpResponsedMessage != null && FrsFragment.this.getContext() != null && FrsFragment.this.hFz != null) {
                if (httpResponsedMessage.getError() == 0) {
                    new BdTopToast(FrsFragment.this.getContext()).wd(true).Pr(FrsFragment.this.getContext().getString(R.string.frs_move_area_move_suc)).aF(FrsFragment.this.hFz.bPb());
                    if (com.baidu.tieba.frs.a.cap().uz(com.baidu.tieba.frs.a.cap().car())) {
                        FrsCommonTabFragment frsCommonTabFragment = null;
                        if (FrsFragment.this.hFU != null && FrsFragment.this.hFU.cjp() != null && (FrsFragment.this.hFU.cjp().fragment instanceof FrsCommonTabFragment)) {
                            frsCommonTabFragment = (FrsCommonTabFragment) FrsFragment.this.hFU.cjp().fragment;
                        }
                        if (frsCommonTabFragment != null) {
                            frsCommonTabFragment.ceu();
                        }
                        FrsFragment.this.cau();
                        com.baidu.tieba.frs.a.cap().cau();
                        Iterator<com.baidu.adp.widget.ListView.q> it = FrsFragment.this.hEX.getThreadList().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                i = i2;
                                break;
                            }
                            i = it.next() instanceof bu ? i2 + 1 : i2;
                            if (i >= 6) {
                                break;
                            }
                            i2 = i;
                        }
                        if (i < 6) {
                            FrsFragment.this.bwE();
                        }
                    }
                    com.baidu.tieba.frs.a.cap().reset();
                    return;
                }
                new BdTopToast(FrsFragment.this.getContext()).wd(false).Pr(httpResponsedMessage.getErrorString()).aF(FrsFragment.this.hFz.bPb());
            }
        }
    };
    private final CustomMessageListener hHa = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.frs.FrsFragment.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.isResumed()) {
                FrsFragment.this.ccj();
            }
        }
    };
    private CustomMessageListener hHb = new CustomMessageListener(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER) { // from class: com.baidu.tieba.frs.FrsFragment.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (FrsFragment.this.hFz != null) {
                    FrsFragment.this.hFz.setExpanded(booleanValue);
                }
            }
        }
    };
    private final CustomMessageListener hHc = new CustomMessageListener(2921463) { // from class: com.baidu.tieba.frs.FrsFragment.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TbadkApplication.getInst().getCurrentActivity() != null && !com.baidu.tbadk.core.util.as.isEmpty(str) && str.equals(FrsFragment.this.forumId)) {
                    com.baidu.tieba.frs.f.e.b(((TbPageContextSupport) TbadkApplication.getInst().getCurrentActivity()).getPageContext(), FrsFragment.this.hEX);
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.q hHd = new com.baidu.tieba.tbadkCore.q() { // from class: com.baidu.tieba.frs.FrsFragment.18
        private long startTime = 0;

        @Override // com.baidu.tieba.tbadkCore.q
        public void uG(int i) {
            this.startTime = System.nanoTime();
            if (FrsFragment.this.hFz != null) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsFragment.this.hFz.ccH();
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
            if (FrsFragment.this.fvp) {
                FrsFragment.this.fvp = false;
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.hFz, FrsFragment.this.hEX, FrsFragment.this.getForumId(), false, null);
            }
            FrsFragment.this.cbz();
            FrsFragment.this.hFK = true;
            if (fVar != null && fVar.isSuccess) {
                FrsFragment.this.hFz.ccU().oj(com.baidu.tbadk.core.util.at.baS().baT());
                FrsFragment.hFG = 0L;
                FrsFragment.hFH = 0L;
                FrsFragment.mNetError = 0;
            } else {
                FrsFragment.mNetError = 1;
            }
            if (!FrsFragment.this.hFS.chw() && (i == 3 || i == 6)) {
                FrsFragment.this.hGd.resetData();
            }
            FrsFragment.this.hFE = System.currentTimeMillis();
            if (FrsFragment.this.hFS.cgN() != null) {
                FrsFragment.this.hEX = FrsFragment.this.hFS.cgN();
            }
            FrsFragment.this.uC(1);
            if (i == 7) {
                FrsFragment.this.uD(FrsFragment.this.hEX.getFrsDefaultTabId());
                return;
            }
            if (FrsFragment.this.hEX.getPage() != null) {
                FrsFragment.this.setHasMore(FrsFragment.this.hEX.getPage().aVb());
            }
            if (i == 4) {
                if (!FrsFragment.this.hFS.chw() && TbadkCoreApplication.getInst().isRecAppExist() && FrsFragment.this.hFS.chm() == 1) {
                    FrsFragment.this.hEX.addRecommendAppToThreadList(FrsFragment.this);
                }
                ArrayList<com.baidu.adp.widget.ListView.q> a2 = FrsFragment.this.hGd.a(false, false, FrsFragment.this.hEX.getThreadList(), FrsFragment.this.hFv, false);
                if (a2 != null) {
                    FrsFragment.this.hEX.setThreadList(a2);
                    FrsFragment.this.hEX.checkLiveStageInThreadList();
                }
                if (FrsFragment.this.hFS != null) {
                    com.baidu.tieba.frs.d.c.a(FrsFragment.this.hEX, FrsFragment.this.hFS.chr(), 2, FrsFragment.this.getContext());
                }
                com.baidu.tieba.frs.f.a.a(FrsFragment.this, FrsFragment.this.hEX.getForum(), FrsFragment.this.hEX.getThreadList(), false, FrsFragment.this.getPn());
                FrsFragment.this.hFz.a(a2, FrsFragment.this.hEX);
                FrsFragment.this.cbA();
                return;
            }
            FrsFragment.this.cbA();
            switch (i) {
                case 1:
                    FrsFragment.this.hFz.ccH();
                    break;
                case 2:
                    FrsFragment.this.hFz.ccH();
                    break;
                case 3:
                case 6:
                    if (FrsFragment.this.hEX != null) {
                        FrsFragment.this.hEX.clearPostThreadCount();
                    }
                    if (FrsFragment.this.hGi != null) {
                        FrsFragment.this.hGi.refresh();
                        break;
                    }
                    break;
            }
            FrsFragment.this.cbH();
            if (fVar == null || fVar.errorCode == 0) {
                if (FrsFragment.this.hEX != null) {
                    FrsFragment.this.P(false, i == 5);
                    if (FrsFragment.this.hFS != null) {
                        if (FrsFragment.this.hEX.getActivityHeadData() != null && FrsFragment.this.hEX.getActivityHeadData().aUp() != null && FrsFragment.this.hEX.getActivityHeadData().aUp().size() > 0) {
                            com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), 1, FrsFragment.this.hEX.getForum(), FrsFragment.this.hFS.getSortType(), 1);
                        }
                        if (FrsFragment.this.hEX.getThreadList() != null && FrsFragment.this.hEX.getThreadList().size() > 0) {
                            Iterator<com.baidu.adp.widget.ListView.q> it = FrsFragment.this.hEX.getThreadList().iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    com.baidu.adp.widget.ListView.q next = it.next();
                                    if ((next instanceof bv) && ((bv) next).getType() == bv.dTv) {
                                        com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), 1, FrsFragment.this.hEX.getForum(), FrsFragment.this.hFS.getSortType(), 2);
                                    }
                                }
                            }
                        }
                        com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), FrsFragment.this.hEX.getThreadList(), FrsFragment.this.hEX.getForum(), FrsFragment.this.hFS.getSortType());
                    }
                    FrsFragment.this.hFz.uT(i);
                    FrsFragment.hFG = (System.nanoTime() - this.startTime) / TimeUtils.NANOS_PER_MS;
                    if (fVar != null) {
                        FrsFragment.hFH = fVar.lKP;
                    }
                } else {
                    return;
                }
            } else if (FrsFragment.this.hEX == null || com.baidu.tbadk.core.util.x.isEmpty(FrsFragment.this.hEX.getThreadList())) {
                FrsFragment.this.a(fVar);
            } else if (fVar.hpV) {
                FrsFragment.this.showToast(FrsFragment.this.getPageContext().getResources().getString(R.string.net_error_text, fVar.errorMsg, Integer.valueOf(fVar.errorCode)));
            }
            FrsFragment.this.cbE();
            FrsFragment.this.cbF();
            if (FrsFragment.this.hEX.getAccessFlag() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c11384"));
            }
            if (FrsFragment.this.hFw && FrsFragment.this.hFU.wA(49)) {
                FrsFragment.this.hFw = false;
            }
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.q
        public void b(com.baidu.tieba.tbadkCore.m mVar) {
            if ((mVar != null && ("normal_page".equals(FrsFragment.this.hFS.getPageType()) || "frs_page".equals(FrsFragment.this.hFS.getPageType()) || "book_page".equals(FrsFragment.this.hFS.getPageType()))) || "brand_page".equals(FrsFragment.this.hFS.getPageType())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE, mVar));
                FrsFragment.this.a(mVar);
                FrsFragment.hFD = mVar;
            }
        }

        @Override // com.baidu.tieba.tbadkCore.q
        public void cbJ() {
            FrsFragment.this.cbJ();
        }
    };
    private final CustomMessageListener hHe = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.frs.FrsFragment.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                FrsFragment.this.hEX.updateCurrentUserPendant((com.baidu.tbadk.data.l) customResponsedMessage.getData());
                FrsFragment.this.hFz.ccU().notifyDataSetChanged();
            }
        }
    };
    private final CustomMessageListener mMemListener = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_MEM) { // from class: com.baidu.tieba.frs.FrsFragment.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && FrsFragment.this.hEX != null && (userData = FrsFragment.this.hEX.getUserData()) != null) {
                userData.setIsMem(num.intValue());
                if (num.intValue() != 0) {
                    FrsFragment.this.hFT.l(num);
                }
            }
        }
    };
    private final f.a hHf = new AnonymousClass29();
    private final com.baidu.tieba.frs.mc.k hHg = new com.baidu.tieba.frs.mc.k() { // from class: com.baidu.tieba.frs.FrsFragment.30
        @Override // com.baidu.tieba.frs.mc.k
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, boolean z3) {
            if (FrsFragment.this.hFW != null && FrsFragment.this.hFS != null && FrsFragment.this.hFS.chw() && z && !z2 && !z3) {
                FrsFragment.this.hFW.vZ(i2);
            }
        }
    };
    public final View.OnTouchListener eKY = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.FrsFragment.31
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (FrsFragment.this.hGk != null) {
                FrsFragment.this.hGk.onTouch(view, motionEvent);
            }
            if (FrsFragment.this.hFY != null && FrsFragment.this.hFY.cdF() != null) {
                FrsFragment.this.hFY.cdF().onTouchEvent(motionEvent);
            }
            if (FrsFragment.this.fLL != null) {
                FrsFragment.this.fLL.b(view, motionEvent);
            }
            if (FrsFragment.this.hFT != null) {
                FrsFragment.this.hFT.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private final CustomMessageListener hHh = new CustomMessageListener(CmdConfigCustom.CMD_GOTOLIVE_HOST_UPGRADE) { // from class: com.baidu.tieba.frs.FrsFragment.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.aZP().getInt(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.PHOTOLIVE_HOSTLEVEL, -1) != -1 && FrsFragment.this.hEX.getForum() != null) {
                FrsFragment.this.hEX.getForum().setCanAddPhotoLivePost(true);
            }
        }
    };
    public final View.OnClickListener hHi = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.37
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsFragment.this.hFz != null && view == FrsFragment.this.hFz.ccF() && FrsFragment.this.getActivity() != null) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, FrsFragment.this.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            if (view.getId() == R.id.game_activity_egg_layout && com.baidu.adp.lib.util.l.isNetOk()) {
                TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_CLICK);
                if (FrsFragment.this.hFz == null || !FrsFragment.this.hFz.ccR()) {
                    String activityUrl = FrsFragment.this.hEX.getForum().getYuleData().aYD().getActivityUrl();
                    if (!StringUtils.isNull(activityUrl)) {
                        com.baidu.tbadk.browser.a.startInternalWebActivity(FrsFragment.this.getPageContext().getPageActivity(), activityUrl);
                    }
                } else {
                    FrsFragment.this.hFz.ccS();
                }
            }
            if (FrsFragment.this.hFz != null && view == FrsFragment.this.hFz.ccY() && FrsFragment.this.hFS != null && FrsFragment.this.hFS.hasMore()) {
                FrsFragment.this.hFz.bxS();
                FrsFragment.this.bwE();
            }
            if (view != null && FrsFragment.this.hFz != null && view == FrsFragment.this.hFz.ccO()) {
                if (bf.checkUpIsLogin(FrsFragment.this.getContext())) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ap(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).ah("obj_locate", 2));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MessageCenterActivityConfig(FrsFragment.this.getContext())));
                } else {
                    return;
                }
            }
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (FrsFragment.this.hEX != null && FrsFragment.this.hEX.getForum() != null) {
                    if (FrsFragment.this.hFz != null && view == FrsFragment.this.hFz.ccM()) {
                        if (FrsFragment.this.hEX != null && FrsFragment.this.hEX.getForum() != null && !StringUtils.isNull(FrsFragment.this.hEX.getForum().getId()) && !StringUtils.isNull(FrsFragment.this.hEX.getForum().getName())) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ap(TbadkCoreStatisticKey.KEY_SHARE_CLICK).dn("fid", FrsFragment.this.hEX.getForum().getId()).ah("obj_locate", 11));
                            com.baidu.tieba.frs.f.e.a(FrsFragment.this.getPageContext(), FrsFragment.this.hEX, FrsFragment.this.hEX.getForum().getId());
                        } else {
                            return;
                        }
                    }
                    if (FrsFragment.this.hFz != null && view == FrsFragment.this.hFz.ccL()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c12402").dn("fid", FrsFragment.this.hEX.getForum().getId()).dn("uid", TbadkCoreApplication.getCurrentAccount()).dn("fname", FrsFragment.this.hEX.getForum().getName()));
                        if (!StringUtils.isNull(FrsFragment.this.hEX.getForum().getName())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PostSearchActivityConfig(FrsFragment.this.getContext(), FrsFragment.this.hEX.getForum().getName(), FrsFragment.this.hEX.getForum().getId())));
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
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.FrsFragment.38
        private int hHG = 0;
        private int frk = 0;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsFragment.this.hGx += i2;
            if (FrsFragment.this.hGx >= FrsFragment.this.cXV * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
            if (FrsFragment.this.hGb != null) {
                FrsFragment.this.hGb.cin();
            }
            this.hHG = 0;
            this.frk = 0;
            if (recyclerView != null && (recyclerView instanceof BdRecyclerView)) {
                this.hHG = ((BdRecyclerView) recyclerView).getFirstVisiblePosition();
                this.frk = ((BdRecyclerView) recyclerView).getLastVisiblePosition();
            }
            if (FrsFragment.this.hGm != null) {
                FrsFragment.this.hGm.a(recyclerView, this.hHG, this.frk);
            }
            if (FrsFragment.this.hEX != null && FrsFragment.this.hFz != null && FrsFragment.this.hFz.ccU() != null) {
                FrsFragment.this.hFz.bZ(this.hHG, this.frk);
                if (FrsFragment.this.hFR != null && FrsFragment.this.hFR.sg() != null) {
                    FrsFragment.this.hFR.sg().b(FrsFragment.this.hFQ);
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (FrsFragment.this.hFT != null) {
                FrsFragment.this.hFT.setScrollState(i);
            }
            if ((i == 2 || i == 1) && !FrsFragment.this.hFL) {
                FrsFragment.this.hFL = true;
                FrsFragment.this.hFz.ccW();
            }
            if (FrsFragment.this.hFM == null && !FrsFragment.this.ccc()) {
                FrsFragment.this.hFM = new com.baidu.tbadk.n.b();
                FrsFragment.this.hFM.setSubType(1000);
            }
            if (i == 0) {
                if (FrsFragment.this.hFM != null) {
                    FrsFragment.this.hFM.blr();
                }
                com.baidu.tieba.card.s.bRL().mH(true);
                FrsFragment.this.nz(true);
                FrsFragment.this.hFz.bY(this.hHG, this.frk);
            } else if (FrsFragment.this.hFM != null) {
                FrsFragment.this.hFM.blq();
            }
            if (FrsFragment.this.hGm != null) {
                FrsFragment.this.hGm.onScrollStateChanged(recyclerView, i);
            }
            if (i == 0) {
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.hFz, FrsFragment.this.hEX, FrsFragment.this.getForumId(), false, null);
            }
            if (FrsFragment.this.hFU != null && i == 1) {
                FrsFragment.this.hFU.cjr();
            }
            if (FrsFragment.this.hFR == null) {
                if (FrsFragment.this.hFz.ccy() != null && !FrsFragment.this.hFz.cca() && FrsFragment.this.hFz.ccy().cYQ() != null && (FrsFragment.this.hFz.ccy().cYQ().getTag() instanceof com.baidu.card.ak)) {
                    FrsFragment.this.hFR = (com.baidu.card.ak) FrsFragment.this.hFz.ccy().cYQ().getTag();
                }
            } else if (i == 0 && FrsFragment.this.hFz.ccy() != null && !FrsFragment.this.hFz.cca() && FrsFragment.this.hFz.ccy().cYQ() != null && (FrsFragment.this.hFz.ccy().cYQ().getTag() instanceof com.baidu.card.ak)) {
                FrsFragment.this.hFR = (com.baidu.card.ak) FrsFragment.this.hFz.ccy().cYQ().getTag();
            }
            if (i == 1) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921418));
            }
        }
    };
    private final f hHj = new f() { // from class: com.baidu.tieba.frs.FrsFragment.39
        @Override // com.baidu.tieba.frs.f
        public void a(int i, int i2, View view, View view2, bv bvVar) {
            if (i != FrsFragment.this.hFz.ccU().cff()) {
                if (i != FrsFragment.this.hFz.ccU().cfg()) {
                    if (i == FrsFragment.this.hFz.ccU().cfd() && FrsFragment.this.hEX != null && FrsFragment.this.hEX.getUserData() != null && FrsFragment.this.hEX.getUserData().isBawu()) {
                        String bawuCenterUrl = FrsFragment.this.hEX.getBawuCenterUrl();
                        if (!com.baidu.tbadk.core.util.as.isEmpty(bawuCenterUrl) && FrsFragment.this.hEX.getForum() != null) {
                            com.baidu.tbadk.browser.a.startWebActivity(FrsFragment.this.getPageContext().getPageActivity(), bawuCenterUrl);
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c10502").dn("fid", FrsFragment.this.hEX.getForum().getId()).dn("uid", FrsFragment.this.hEX.getUserData().getUserId()));
                        }
                    }
                } else if (bf.checkUpIsLogin(FrsFragment.this.getPageContext().getPageActivity())) {
                    TiebaStatic.log(CommonStatisticKey.MY_SERVICE_CK);
                    if (FrsFragment.this.hEX != null && FrsFragment.this.hEX.getForum() != null) {
                        ForumData forum = FrsFragment.this.hEX.getForum();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(forum.getId(), 0L), forum.getName(), forum.getImage_url(), 0)));
                    }
                }
            } else if (bf.checkUpIsLogin(FrsFragment.this.getActivity())) {
                TiebaStatic.log("forum_fortune_click");
                com.baidu.tieba.frs.f.i.c(FrsFragment.this.getPageContext(), FrsFragment.this.hEX);
            }
        }
    };
    private final NoNetworkView.a hCK = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.FrsFragment.40
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (FrsFragment.this.hFS.chm() == 1 && z && !FrsFragment.this.hFz.cca()) {
                if (FrsFragment.this.hEX == null || com.baidu.tbadk.core.util.x.isEmpty(FrsFragment.this.hEX.getThreadList())) {
                    FrsFragment.this.hideNetRefreshView(FrsFragment.this.hFz.bPb());
                    FrsFragment.this.showLoadingView(FrsFragment.this.hFz.bPb(), true);
                    FrsFragment.this.hFz.nJ(false);
                    FrsFragment.this.refresh();
                    return;
                }
                FrsFragment.this.hFz.ccH();
            }
        }
    };
    private final CustomMessageListener erZ = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.FrsFragment.41
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                com.baidu.tieba.frs.f.c.a(customResponsedMessage, FrsFragment.this.hFz, FrsFragment.this.hEX);
            }
        }
    };
    private com.baidu.adp.widget.ListView.z hHk = new a();
    private at hHl = new at() { // from class: com.baidu.tieba.frs.FrsFragment.43
        @Override // com.baidu.tieba.frs.at
        public void a(int i, int i2, bb bbVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
            com.baidu.adp.lib.f.e.lt().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.43.1
                @Override // java.lang.Runnable
                public void run() {
                    if (FrsFragment.this.hFz != null && FrsFragment.this.hFz.cdb()) {
                        FrsFragment.this.bwE();
                    }
                }
            });
        }
    };
    private CustomMessageListener hHm = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.frs.FrsFragment.44
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    FrsFragment.this.hGn = true;
                }
            }
        }
    };
    private CustomMessageListener hHn = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.frs.FrsFragment.46
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                    if (FrsFragment.this.hFR == null && FrsFragment.this.hFz.ccy() != null && !FrsFragment.this.hFz.cca() && FrsFragment.this.hFz.ccy().cYQ() != null && (FrsFragment.this.hFz.ccy().cYQ().getTag() instanceof com.baidu.card.ak)) {
                        FrsFragment.this.hFR = (com.baidu.card.ak) FrsFragment.this.hFz.ccy().cYQ().getTag();
                    }
                    if (FrsFragment.this.hFR != null && FrsFragment.this.hFR.sg() != null) {
                        FrsFragment.this.hFR.sg().b(new a.C0096a(3));
                    }
                }
            }
        }
    };
    private CustomMessageListener hHo = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.FrsFragment.47
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.hFz != null) {
                FrsFragment.this.hFz.zc();
            }
        }
    };
    private CustomMessageListener hHp = new CustomMessageListener(2921437) { // from class: com.baidu.tieba.frs.FrsFragment.48
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && FrsFragment.this.isResumed()) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (FrsFragment.this.hFB != null) {
                    if (booleanValue) {
                        if (FrsFragment.this.hFU.cjs() != 0 && !FrsFragment.this.hFz.cdg() && !KuangFloatingFrsCopyLinkViewController.getInstance().isFloatCopyViewShow()) {
                            FrsFragment.this.hFB.show();
                            return;
                        }
                        return;
                    }
                    FrsFragment.this.hFB.hide();
                }
            }
        }
    };
    private CustomMessageListener hHq = new CustomMessageListener(2921462) { // from class: com.baidu.tieba.frs.FrsFragment.53
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && FrsFragment.this.hEX.getToLoadHorseData().intValue() == 1 && FrsFragment.this.mIsLogin) {
                LiveHorseRaceRequestMessage liveHorseRaceRequestMessage = new LiveHorseRaceRequestMessage();
                liveHorseRaceRequestMessage.setForum_id(Long.valueOf(FrsFragment.this.forumId));
                FrsFragment.this.sendMessage(liveHorseRaceRequestMessage);
            }
        }
    };
    private CustomMessageListener hHr = new CustomMessageListener(2001223) { // from class: com.baidu.tieba.frs.FrsFragment.54
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Date)) {
                FrsFragment.this.hGw = (Date) customResponsedMessage.getData();
            }
        }
    };
    private CustomMessageListener hHs = new CustomMessageListener(2921469) { // from class: com.baidu.tieba.frs.FrsFragment.55
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.w) && FrsFragment.this.isResumed()) {
                com.baidu.tbadk.core.data.w wVar = (com.baidu.tbadk.core.data.w) customResponsedMessage.getData();
                if (FrsFragment.this.hGD == null) {
                    FrsFragment.this.hGD = new com.baidu.tieba.frs.broadcast.a(FrsFragment.this.getPageContext());
                }
                if (FrsFragment.this.hEX != null && FrsFragment.this.hEX.getForum() != null && !TextUtils.isEmpty(FrsFragment.this.hEX.getForum().getId())) {
                    FrsFragment.this.hGD.e(wVar.type, FrsFragment.this.hEX.getForum().getId(), FrsFragment.this.hEX.getForum().getName(), wVar.tid);
                }
            }
        }
    };
    private CustomMessageListener hHt = new CustomMessageListener(2921475) { // from class: com.baidu.tieba.frs.FrsFragment.57
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bv bvVar = (bv) customResponsedMessage.getData();
            if (bvVar != null && FrsFragment.this.isResumed()) {
                FrsFragment.this.hFP = bvVar.getTid() + "";
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE_NUMBER);
                httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
                httpMessage.addParam("forum_id", bvVar.getFid());
                MessageManager.getInstance().sendMessage(httpMessage);
            }
        }
    };
    private HttpMessageListener hHu = new HttpMessageListener(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE_NUMBER) { // from class: com.baidu.tieba.frs.FrsFragment.58
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if ((httpResponsedMessage instanceof ForumManagerRightsResMsg) && FrsFragment.this.isResumed()) {
                ForumManagerRightsResMsg forumManagerRightsResMsg = (ForumManagerRightsResMsg) httpResponsedMessage;
                if (forumManagerRightsResMsg.broadcastTotalCount - forumManagerRightsResMsg.broadcastUsedCount <= 0) {
                    new ScreenTopToast(FrsFragment.this.getContext()).Pv(FrsFragment.this.getString(R.string.frs_forum_bawu_send_broadcast_none_tip)).Px(FrsFragment.this.getString(R.string.frs_recommend_fail_tip_btn)).aj(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.58.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("_forumId", FrsFragment.this.hEX.getForum().getId());
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new com.baidu.tieba.tbadkCore.data.m(FrsFragment.this.getContext(), "ForumGradePage", hashMap)));
                        }
                    }).aF((ViewGroup) FrsFragment.this.mRootView.findViewById(R.id.frs));
                    return;
                }
                com.baidu.tbadk.core.util.o oVar = new com.baidu.tbadk.core.util.o(TbadkCoreApplication.getInst());
                oVar.ab(FrsFragment.this.hEX.getForum().getId(), FrsFragment.this.hEX.getForum().getName(), "6");
                oVar.xG(FrsFragment.this.hFP);
                oVar.start();
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.frs.loadmore.a
    public /* bridge */ /* synthetic */ com.baidu.adp.base.e getPageContext() {
        return super.getPageContext();
    }

    public com.baidu.tieba.frs.entelechy.b.b cbn() {
        return this.hGa;
    }

    public com.baidu.adp.widget.ListView.z cbo() {
        return this.hHk;
    }

    public com.baidu.tieba.frs.mc.d cbp() {
        return this.hGc;
    }

    public com.baidu.tieba.frs.smartsort.a cbq() {
        return this.hFW;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public FrsModelController cbr() {
        return this.hFS;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public com.baidu.tieba.frs.mc.c cbs() {
        return this.hGd;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public com.baidu.tieba.frs.vc.h cbt() {
        return this.hFT;
    }

    public FrsTabViewController cbu() {
        return this.hFU;
    }

    public av cbv() {
        return this.hFY;
    }

    public void ny(boolean z) {
        this.hGv = z;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public p cbw() {
        return this.hFz;
    }

    @Override // com.baidu.tieba.frs.au
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.au, com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.hFr;
    }

    public void setForumName(String str) {
        this.hFr = str;
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
        if (this.hGd == null) {
            return 1;
        }
        return this.hGd.getPn();
    }

    public int getPn() {
        if (this.hGd == null) {
            return 1;
        }
        return this.hGd.getPn();
    }

    public void setPn(int i) {
        if (this.hGd != null) {
            this.hGd.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.hGd != null) {
            this.hGd.setHasMore(i);
        }
    }

    public int cbx() {
        if (this.hGd == null) {
            return -1;
        }
        return this.hGd.cbx();
    }

    public boolean cby() {
        return this.hFx;
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
            this.hFz.ccB();
            showNetRefreshView(this.hFz.bPb(), string, true);
        } else if (340001 == fVar.errorCode) {
            a(fVar, this.hEX.getRecm_forum_list());
        } else {
            if (com.baidu.tbadk.core.util.x.isEmpty(this.hEX.getThreadList())) {
                b(fVar);
            }
            if (ccc()) {
                setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds280));
            } else {
                setNetRefreshViewEmotionDefMarginTop();
            }
        }
    }

    public void a(View view, String str, boolean z, List<RecmForumInfo> list) {
        this.hFz.ccB();
        this.hFz.uN(8);
        if (this.hGl == null) {
            this.hGl = new com.baidu.tieba.frs.view.a(getPageContext(), getNetRefreshListener());
        }
        this.hGl.setSubText(str);
        this.hGl.cR(list);
        this.hGl.attachView(view, z);
    }

    private void a(com.baidu.tieba.tbadkCore.f fVar, List<RecmForumInfo> list) {
        if (this.hFz != null) {
            this.hFz.ccB();
            this.hFz.setTitle(this.hFr);
            a(this.hFz.bPb(), fVar.errorMsg, true, list);
        }
    }

    private void b(com.baidu.tieba.tbadkCore.f fVar) {
        this.hFz.ccB();
        if (fVar.hpV) {
            showNetRefreshView(this.hFz.bPb(), TbadkCoreApplication.getInst().getString(R.string.net_error_text, new Object[]{fVar.errorMsg, Integer.valueOf(fVar.errorCode)}), true);
        } else {
            showNetRefreshView(this.hFz.bPb(), fVar.errorMsg, true);
        }
    }

    public void cbz() {
        hideLoadingView(this.hFz.bPb());
        this.hFz.bxe();
        if (this.hFz.ccz() instanceof com.baidu.tieba.frs.tab.c) {
            ((com.baidu.tieba.frs.tab.c) this.hFz.ccz()).chU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbA() {
        if (cbx() == 0 && com.baidu.tbadk.core.util.x.isEmpty(this.hEX.getThreadListIds())) {
            if (com.baidu.tbadk.core.util.x.isEmpty(this.hEX.getThreadList())) {
                this.hFz.bxU();
            } else {
                this.hFz.bxT();
            }
        } else if (com.baidu.tbadk.core.util.x.getCount(this.hEX.getThreadList()) > 3) {
            this.hFz.bxS();
        } else {
            this.hFz.ccX();
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
            cbz();
            this.hFz.ccH();
            com.baidu.tieba.tbadkCore.f chi = this.hFS.chi();
            boolean isEmpty = com.baidu.tbadk.core.util.x.isEmpty(this.hEX.getThreadList());
            if (chi != null && isEmpty) {
                if (this.hFS.chk() != 0) {
                    this.hFS.chp();
                    this.hFz.ccH();
                } else {
                    a(chi);
                }
                this.hFz.Q(this.hEX.isStarForum(), false);
                return;
            }
            a(chi);
        }
    }

    public boolean cbB() {
        return cbC() && !cbD();
    }

    private boolean cbC() {
        if (cbZ() == null) {
            return false;
        }
        FrsViewData cbZ = cbZ();
        com.baidu.tbadk.core.data.x xVar = null;
        if (cbZ.getStar() != null && !StringUtils.isNull(cbZ.getStar().dkv())) {
            xVar = new com.baidu.tbadk.core.data.x();
        } else if (cbZ.getActivityHeadData() != null && com.baidu.tbadk.core.util.x.getCount(cbZ.getActivityHeadData().aUp()) >= 1) {
            xVar = cbZ.getActivityHeadData().aUp().get(0);
        }
        return xVar != null;
    }

    public boolean cbD() {
        if (cbZ() == null) {
            return false;
        }
        FrsViewData cbZ = cbZ();
        return (com.baidu.tbadk.core.util.x.isEmpty(cbZ.getShowTopThreadList()) && cbZ.getBusinessPromot() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbE() {
        boolean b;
        if (!cbG()) {
            final PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
            privateForumPopInfoData.a(this.hEX.getPrivateForumTotalInfo().getPrivatePopInfo());
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(getActivity());
            if (this.hEX.getPrivateForumTotalInfo().aVi().private_forum_status.intValue() == 1 && (com.baidu.tbadk.core.util.as.isEmpty(privateForumPopInfoData.aVk()) || privateForumPopInfoData.aVn() != Integer.valueOf(this.forumId))) {
                privateForumPopInfoData.wO("create_success");
                privateForumPopInfoData.wP(TbadkCoreApplication.getInst().getString(R.string.frs_private_create_hint));
                privateForumPopInfoData.wQ("https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.hFr + "&nomenu=1");
                privateForumPopInfoData.h(Integer.valueOf(this.forumId));
                b = frsPrivateCommonDialogView.b(privateForumPopInfoData);
            } else {
                b = privateForumPopInfoData.aVn() == Integer.valueOf(this.forumId) ? frsPrivateCommonDialogView.b(privateForumPopInfoData) : false;
            }
            if (b) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
                aVar.lq(2);
                aVar.aV(frsPrivateCommonDialogView);
                aVar.hK(false);
                frsPrivateCommonDialogView.setConfirmButton(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.19
                    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.frs.FrsFragment */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        com.baidu.tbadk.core.util.bd.baV().b(FrsFragment.this.getPageContext(), new String[]{privateForumPopInfoData.aVm()});
                        aVar.dismiss();
                    }
                });
                aVar.a(new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.20
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(getPageContext()).aYL();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbF() {
        if (cbG() || this.hEX.getPrivateForumTotalInfo().aVi().private_forum_status.intValue() != 1) {
            a((Integer) null, (Integer) null, true);
        } else {
            a(this.hEX.getPrivateForumTotalInfo().aVi().private_forum_audit_status, this.hEX.getPrivateForumTotalInfo().aVj(), false);
        }
    }

    public void a(Integer num, Integer num2, boolean z) {
        final String str;
        final int i = 2;
        if (this.hFz.ccN() != null) {
            TextView ccN = this.hFz.ccN();
            if (z) {
                ccN.setVisibility(8);
                return;
            }
            if (num.intValue() == 2) {
                ccN.setText("修改实名认证信息");
                ccN.setVisibility(0);
                str = "https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + this.forumId + "&nomenu=1";
            } else if (num2.intValue() >= 0 && num2.intValue() <= 100) {
                ccN.setText("目标已完成" + String.valueOf(num2) + "%");
                ccN.setVisibility(0);
                str = "https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.hFr + "&nomenu=1";
                i = 1;
            } else {
                ccN.setVisibility(8);
                i = 0;
                str = "";
            }
            ccN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.21
                /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c13387").dn("fid", FrsFragment.this.forumId).dn("uid", TbadkCoreApplication.getCurrentAccount()).ah("obj_type", i));
                    com.baidu.tbadk.core.util.bd.baV().b(FrsFragment.this.getPageContext(), new String[]{str});
                }
            });
        }
    }

    private boolean cbG() {
        return this.hEX == null || this.hEX.getPrivateForumTotalInfo() == null || this.hEX.getPrivateForumTotalInfo().aVi() == null || this.hEX.getUserData().getIs_manager() != 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uC(int i) {
        List<WindowToast> list;
        if (TbadkCoreApplication.isLogin() && this.hEX != null && (list = this.hEX.mWindowToast) != null && list.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < list.size()) {
                    WindowToast windowToast = list.get(i3);
                    if (windowToast == null || windowToast.toast_type.intValue() != i) {
                        i2 = i3 + 1;
                    } else if (!com.baidu.tbadk.core.util.as.isEmpty(windowToast.toast_link)) {
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
    public void cbH() {
        if (this.hEX == null || this.hEX.getForum() != null) {
            this.hFz.ccT();
        } else if (this.hEX.getForum().getYuleData() != null && this.hEX.getForum().getYuleData().aYC()) {
            TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_VIEW);
            this.hFz.a(this.hEX.getForum().getYuleData().aYD());
        } else {
            this.hFz.ccT();
        }
    }

    private void O(boolean z, boolean z2) {
        if (this.hFS != null && this.hEX != null && this.hFz != null && z) {
            if (!this.hFS.chw() && this.hFS.chm() == 1) {
                if (!this.hFS.chu()) {
                    this.hEX.addCardVideoInfoToThreadList();
                    this.hEX.addVideoInfoToThreadListInTenAndFifteenFloor();
                }
                boolean z3 = false;
                if (this.hFz.ccU().s(com.baidu.tieba.card.data.n.haE)) {
                    z3 = this.hEX.addHotTopicDataToThreadList();
                }
                if (!z3) {
                    this.hEX.addFeedForumDataToThreadList();
                }
                if (TbadkCoreApplication.getInst().isRecAppExist()) {
                    this.hEX.addRecommendAppToThreadList(this);
                }
                if (!this.hFz.ccU().s(bv.dRT)) {
                    this.hEX.removeAlaLiveThreadData();
                }
                this.hEX.addSchoolRecommendToThreadList();
            }
            if (!this.hFz.ccU().s(bv.dRT)) {
                this.hEX.removeAlaInsertLiveData();
                this.hEX.removeAlaStageLiveDat();
            } else {
                this.hEX.addInsertLiveDataToThreadList();
                this.hEX.addStageLiveDataToThreadList();
            }
            this.hEX.checkLiveStageInThreadList();
            this.hEX.addNoticeThreadToThreadList();
            if (this.hFz.ccU().s(com.baidu.tieba.h.b.imK)) {
                this.hEX.addGameRankListToThreadList(z2);
            }
            if (TbadkCoreApplication.isLogin() && (!this.hFS.chw() || this.hFS.isNetFirstLoad)) {
                this.hEX.addUserRecommendToThreadList();
            }
            this.hEX.addVideoActivityToTop();
        }
    }

    public boolean cbI() {
        if (this.hFT != null && this.hFS != null) {
            this.hFT.a(this.hFS.getPageType(), this.hEX);
        }
        boolean z = false;
        if (this.hEX != null) {
            z = this.hEX.hasTab();
        }
        cbL();
        if (this.hFz != null) {
            this.hFz.cdh();
            this.hFz.cdi();
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uD(int i) {
        ay ayVar = null;
        cbI();
        cbU();
        try {
            if (this.hEX != null) {
                this.hFz.a((ArrayList<com.baidu.adp.widget.ListView.q>) null, this.hEX);
                this.hFT.ws(1);
                this.hFz.ccK();
                this.hFU.a(this.hEX, this.hFS.chr());
                com.baidu.tieba.frs.tab.d wB = this.hFU.wB(this.hEX.getFrsDefaultTabId());
                if (wB != null && !TextUtils.isEmpty(wB.url)) {
                    ayVar = new ay();
                    ayVar.ext = wB.url;
                    ayVar.stType = wB.name;
                }
                this.hFS.a(this.hEX.getFrsDefaultTabId(), 0, ayVar);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(boolean z, boolean z2) {
        try {
            if (this.hEX != null && this.hFU != null && this.hFS != null) {
                if (!this.hFz.ccU().s(bv.dRT)) {
                    this.hEX.removeAlaLiveThreadData();
                }
                boolean isEmpty = com.baidu.tbadk.core.util.x.isEmpty(this.hEX.getGameTabInfo());
                this.hFz.nH(isEmpty);
                if (!isEmpty) {
                    if (this.hGm == null) {
                        this.hGm = new com.baidu.tieba.frs.vc.e(this, (NoPressedRelativeLayout) this.mRootView);
                    }
                    if (this.fLL == null) {
                        this.fLL = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
                    }
                } else {
                    this.hGm = null;
                    this.fLL = null;
                }
                if (this.hEX.getForum() != null) {
                    this.hFr = this.hEX.getForum().getName();
                    this.forumId = this.hEX.getForum().getId();
                }
                if (this.hEX.hasTab()) {
                    this.hFU.a(this.hEX, this.hFS.chr());
                }
                if (z) {
                    O(true, z);
                } else {
                    O(this.hFN, z);
                }
                cbI();
                if (this.hGa != null) {
                    this.hGa.a(this.hFT, this.hEX);
                }
                if (this.hEX.getPage() != null) {
                    setHasMore(this.hEX.getPage().aVb());
                }
                ArrayList<com.baidu.adp.widget.ListView.q> a2 = this.hGd.a(z2, true, this.hEX.getThreadList(), null, z, false);
                if (a2 != null) {
                    this.hEX.setThreadList(a2);
                }
                this.hEX.removeRedundantUserRecommendData();
                this.hEZ = this.hEX.getTopThreadSize();
                if (this.hFv != null) {
                    this.hFu = true;
                    this.hFv.Fo(this.hEZ);
                    com.baidu.tieba.frs.f.a.a(this, this.hEX.getForum(), this.hEX.getThreadList(), this.hFu, getPn());
                }
                if (this.hFS.chm() == 1) {
                    cbP();
                    if (!z && this.hFS.getPn() == 1) {
                        cbK();
                    }
                }
                if (this.hGb != null) {
                    this.hGb.ck(this.hFU.cjo());
                }
                cbz();
                this.hFz.ccC();
                this.hFz.Q(true, false);
                if (z && this.hEX.isFirstTabEqualAllThread()) {
                    com.baidu.adp.lib.f.e.lt().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.22
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!FrsFragment.this.hFK && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                FrsFragment.this.hFz.cdf();
                            }
                        }
                    });
                }
                if (this.hEX.getForum() != null) {
                    this.hFz.FP(this.hEX.getForum().getWarningMsg());
                }
                if (this.hEX != null && this.hEX.getFrsVideoActivityData() != null && com.baidu.tbadk.core.sharedPref.b.aZP().getLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 0L) == 0) {
                    com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.24
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsFragment.this.hFz.cdd();
                        }
                    }, 1000L);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FRS_SHOW_AR_ENTRY, this));
                this.hFz.ccw();
                if (this.hEX != null && this.hEX.getForum() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ENTER_FORUM, new VisitedForumData(this.hEX.getForum().getId(), this.hEX.getForum().getName(), this.hEX.getForum().getImage_url(), String.valueOf(System.currentTimeMillis() / 1000), ConstantData.Forum.SPECAIL_FORUM_TYPE_LIVE.equals(this.hEX.getForum().special_forum_type), this.hEX.getForum().getThemeColorInfo(), this.hEX.getForum().getMember_num())));
                }
                this.hGq.a(this.hEX.bottomMenuList, this.hEX.getForum());
                ccj();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void cbJ() {
        if (this.hFS != null && this.hFS.chm() == 1) {
            this.hFT.j(this.hEX);
        }
    }

    public void nz(boolean z) {
        com.baidu.tieba.s.c.dkh().b(getUniqueId(), z);
    }

    public void cbK() {
        if (this.hGg == null) {
            this.hGg = new com.baidu.tieba.frs.live.a(this, com.baidu.adp.lib.f.b.toInt(this.forumId, 0));
        }
        this.hGg.cgT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.m mVar) {
        try {
            if (!this.hFK && mVar != null && this.hEX != null) {
                this.hEX.receiveData(mVar);
                P(true, false);
                Looper.myQueue().addIdleHandler(this.hGF);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void cbL() {
        if (this.hFS != null) {
            FO(this.hFS.getPageType());
        } else {
            FO("normal_page");
        }
    }

    private void FO(String str) {
        nA("frs_page".equals(str));
        if (this.hGa != null) {
            this.hGa.a(this.hFT, this.hFz, this.hEX);
        }
    }

    public void nA(boolean z) {
        if (this.hGe != null) {
            this.hGe.cjb();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.s.c.dkh().A(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.frs_activity, viewGroup, false);
            this.hFl = new com.baidu.tieba.frs.entelechy.a();
            this.hGa = this.hFl.ceJ();
            this.hFk = TbadkCoreApplication.getInst().getString(R.string.frs_title_new_area);
            this.hFT = new com.baidu.tieba.frs.vc.h(this, this.hFl, (FrsHeaderViewContainer) this.mRootView.findViewById(R.id.header_view_container));
            this.hFU = new FrsTabViewController(this, this.mRootView);
            this.hFU.registerListener();
            this.hFT.a(this.hFU);
            this.hFU.a(this.hGN);
            Intent intent = getActivity().getIntent();
            if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                this.hFn = true;
            }
            this.hFz = new p(this, this.hHi, this.hFl, this.hFn, this.hFT);
            this.hGq = new com.baidu.tieba.frs.brand.buttommenu.a(getPageContext(), this.mRootView);
        } else {
            if (this.mRootView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            if (this.hFU != null) {
                this.hFU.registerListener();
            }
            this.hFz.cdc();
            this.mRootView.setLeft(0);
            this.mRootView.setRight(com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getContext()));
        }
        this.hGu = true;
        this.eHe = System.currentTimeMillis() - currentTimeMillis;
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        ArrayList<com.baidu.adp.widget.ListView.q> arrayList = null;
        this.hio = System.currentTimeMillis();
        long j = this.hio;
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.hFw = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.hio = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            S(intent);
        }
        this.eHd = j - this.hio;
        this.hFv = new com.baidu.tieba.tbadkCore.data.f("frs", com.baidu.tieba.tbadkCore.data.f.lMA);
        if (this.hFS == null) {
            this.hFS = new FrsModelController(this, this.hHd);
            this.hFS.a(this.hGM);
            this.hFS.init();
        }
        this.hFS.setSchemeUrl(this.mSchemeUrl);
        if (intent != null) {
            this.hFS.ak(intent.getExtras());
        } else if (bundle != null) {
            this.hFS.ak(bundle);
        } else {
            this.hFS.ak(null);
        }
        if (intent != null) {
            this.hFT.ar(intent.getExtras());
        } else if (bundle != null) {
            this.hFT.ar(bundle);
        } else {
            this.hFT.ar(null);
        }
        this.hFy = getVoiceManager();
        this.hGh = new o(getPageContext(), this);
        initUI();
        initData(bundle);
        if (!ccc()) {
            this.hFY = new av(getActivity(), this.hFz, this.hFT);
            this.hFY.nW(true);
        }
        this.hFy = getVoiceManager();
        if (this.hFy != null) {
            this.hFy.onCreate(getPageContext());
        }
        if (FrsActivityConfig.FRS_FROM_FLUTTER_BCASTEDIT.equals(getFrom()) && !this.hasInit) {
            int i = com.baidu.tbadk.core.sharedPref.b.aZP().getInt("key_forum_broadcast_edit_tip_number", 0);
            if (i < 2) {
                com.baidu.tbadk.core.sharedPref.b.aZP().putInt("key_forum_broadcast_edit_tip_number", i + 1);
                cbR();
            } else if (Build.VERSION.SDK_INT >= 23) {
                if (Settings.canDrawOverlays(getContext())) {
                    cbS();
                } else {
                    new BdTopToast(getContext()).wd(false).Pr(getContext().getString(R.string.forum_broadcast_copy_no_permission_hint)).aF(this.hFz.bPb());
                }
            } else {
                cbS();
            }
        }
        if (KuangFloatingFrsCopyLinkViewController.getInstance().isFloatCopyViewShow()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
            if (this.hFA != null) {
                this.hFA.setVisibility(8);
            }
        }
        new com.baidu.tieba.frs.mc.i();
        int i2 = -1;
        if (this.hGd != null && this.hGd.che() != null) {
            i2 = this.hGd.che().cbx();
            arrayList = this.hGd.che().getDataList();
        }
        this.hGd = new com.baidu.tieba.frs.mc.c(this, this.hHg);
        this.hGd.che().setHasMore(i2);
        if (arrayList != null && arrayList.size() > 0) {
            this.hGd.che().aw(arrayList);
        }
        this.hFW = new com.baidu.tieba.frs.smartsort.a(this);
        this.hGe = new com.baidu.tieba.frs.vc.j(this);
        this.hGb = new com.baidu.tieba.frs.vc.a(getPageContext(), this.hFS.cht());
        this.hFX = new com.baidu.tieba.frs.mc.b(this);
        this.hGc = new com.baidu.tieba.frs.mc.d(this);
        this.hFV = new com.baidu.tieba.frs.mc.h(this);
        this.hGf = new com.baidu.tieba.frs.mc.a(this);
        this.hGi = new com.baidu.tieba.frs.vc.c(this);
        this.hGj = new com.baidu.tieba.frs.mc.e(this, getUniqueId());
        this.hGo = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "frs");
        this.hGp = new com.baidu.tieba.ala.a(getPageContext());
        this.hGr = new com.baidu.tieba.frs.sportspage.notification.a(getPageContext());
        registerListener(this.hGV);
        registerListener(this.mMemListener);
        registerListener(this.hGT);
        registerListener(this.hHh);
        registerListener(this.hHe);
        registerListener(this.hGP);
        registerListener(this.hGQ);
        registerListener(this.hGR);
        registerListener(this.hGS);
        registerListener(this.hGG);
        registerListener(this.hGH);
        registerListener(this.aeE);
        registerListener(this.hGI);
        registerListener(this.hHm);
        registerListener(this.hGX);
        registerListener(this.hGL);
        registerListener(this.hGY);
        registerListener(this.hGW);
        registerListener(this.hHa);
        registerListener(this.hHb);
        registerListener(this.hHc);
        this.hHn.setTag(getPageContext().getUniqueId());
        MessageManager.getInstance().registerListener(this.hHn);
        registerListener(this.hHo);
        registerListener(this.hHp);
        registerListener(this.hHq);
        registerListener(this.hGK);
        registerListener(this.hHr);
        registerListener(this.hGZ);
        registerListener(this.hGJ);
        registerListener(this.hHs);
        registerListener(this.hHt);
        registerListener(this.hHu);
        this.hFz.nJ(false);
        if (!ccc() && !this.hasInit) {
            showLoadingView(this.hFz.bPb(), true);
            this.hFS.P(3, false);
        }
        aw awVar = new aw() { // from class: com.baidu.tieba.frs.FrsFragment.27
            @Override // com.baidu.tieba.frs.aw
            public void d(boolean z, boolean z2, int i3) {
                if (FrsFragment.this.hFz != null) {
                    if (i3 == 1) {
                        FrsFragment.this.hFz.uO(z ? 0 : 8);
                    } else if (i3 == 2) {
                        FrsFragment.this.hFz.uQ(z ? 0 : 8);
                    }
                    if (!z2) {
                        FrsFragment.this.hGt = z;
                    }
                    if (FrsFragment.this.hFz.ccU() != null && (i3 == 2 || (FrsFragment.this.hFS != null && FrsFragment.this.hFS.chn()))) {
                        FrsFragment.this.hFz.ccU().notifyDataSetChanged();
                    }
                    if (FrsFragment.this.cbu() != null) {
                        FrsTabViewController.b cjp = FrsFragment.this.cbu().cjp();
                        if (cjp != null) {
                            if ((cjp.fragment instanceof FrsCommonTabFragment) && (i3 == 2 || cjp.tabId == 502)) {
                                ((FrsCommonTabFragment) cjp.fragment).cez();
                            } else if ((cjp.fragment instanceof FrsNewAreaFragment) && (i3 == 2 || cjp.tabId == 503)) {
                                FrsNewAreaFragment frsNewAreaFragment = (FrsNewAreaFragment) cjp.fragment;
                                frsNewAreaFragment.cez();
                                if (frsNewAreaFragment.chF() != null) {
                                    com.baidu.tieba.frs.mc.g chF = frsNewAreaFragment.chF();
                                    chF.nY(!z);
                                    if (i3 == 1) {
                                        chF.nM(!z);
                                    } else if (i3 == 2) {
                                        chF.nM(true);
                                    }
                                }
                            } else if (cjp.fragment instanceof FrsGoodFragment) {
                                ((FrsGoodFragment) cjp.fragment).cez();
                            }
                        }
                        if (FrsFragment.this.cbu().cjg() != null) {
                            FrsFragment.this.cbu().cjg().setmDisallowSlip(z);
                            FrsFragment.this.cbu().oD(z);
                        }
                    }
                    if (FrsFragment.this.hFz.ccA() != null) {
                        FrsFragment.this.hFz.nG(!z);
                    }
                    if (FrsFragment.this.getActivity() instanceof FrsActivity) {
                        ((FrsActivity) FrsFragment.this.getActivity()).nx(!z);
                    }
                    if (FrsFragment.this.hGq != null) {
                        FrsFragment.this.hGq.oe(!z);
                    }
                    FrsFragment.this.hFz.nL(!z);
                    if (i3 == 1) {
                        FrsFragment.this.hFz.nM(z ? false : true);
                    } else if (i3 == 2) {
                        FrsFragment.this.hFz.nM(true);
                    }
                }
            }

            @Override // com.baidu.tieba.frs.aw
            public void bX(int i3, int i4) {
                if (FrsFragment.this.hFz != null) {
                    if (i4 == 1) {
                        FrsFragment.this.hFz.uP(i3);
                    } else if (i4 == 2) {
                        FrsFragment.this.hFz.uR(i3);
                    }
                }
            }

            @Override // com.baidu.tieba.frs.aw
            public void uH(int i3) {
                if (FrsFragment.this.getContext() != null) {
                    if (i3 == 1) {
                        com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getContext(), R.string.frs_multi_delete_max_num);
                    } else if (i3 == 2 && FrsFragment.this.hFz != null) {
                        new BdTopToast(FrsFragment.this.getContext()).wd(false).Pr(FrsFragment.this.getContext().getString(R.string.frs_move_area_max_num)).aF(FrsFragment.this.hFz.bPb());
                    }
                }
            }
        };
        b.caw().a(awVar);
        com.baidu.tieba.frs.a.cap().a(awVar);
        this.hFz.b(new d.a() { // from class: com.baidu.tieba.frs.FrsFragment.28
            @Override // com.baidu.tieba.NEGFeedBack.d.a
            public void a(DeleteThreadHttpResponseMessage deleteThreadHttpResponseMessage) {
                boolean z;
                int i3 = 0;
                if (deleteThreadHttpResponseMessage != null) {
                    FrsFragment.this.hFz.brl();
                    FrsFragment.this.hFz.cde();
                    FrsNewAreaFragment frsNewAreaFragment = null;
                    if (FrsFragment.this.hFU == null || FrsFragment.this.hFU.cjp() == null || !(FrsFragment.this.hFU.cjp().fragment instanceof FrsNewAreaFragment)) {
                        z = false;
                    } else {
                        frsNewAreaFragment = (FrsNewAreaFragment) FrsFragment.this.hFU.cjp().fragment;
                        z = true;
                    }
                    if (deleteThreadHttpResponseMessage.getError() == 0) {
                        String text = !TextUtils.isEmpty(deleteThreadHttpResponseMessage.getText()) ? deleteThreadHttpResponseMessage.getText() : FrsFragment.this.getString(R.string.delete_fail);
                        if (deleteThreadHttpResponseMessage.getRetType() == 1211066) {
                            if (FrsFragment.this.gZc == null) {
                                FrsFragment.this.gZc = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.gZc.xl(text);
                            FrsFragment.this.gZc.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.28.1
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.gZc.hK(false);
                            FrsFragment.this.gZc.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.gZc.aYL();
                        } else if (deleteThreadHttpResponseMessage.getRetType() == 1211067) {
                            if (FrsFragment.this.gZc == null) {
                                FrsFragment.this.gZc = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.gZc.xl(text);
                            FrsFragment.this.gZc.a(R.string.know, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.28.2
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.gZc.hK(false);
                            FrsFragment.this.gZc.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.gZc.aYL();
                        } else {
                            FrsFragment.this.hFz.aI(deleteThreadHttpResponseMessage.getText(), ContextCompat.getColor(FrsFragment.this.getContext(), deleteThreadHttpResponseMessage.getRetType() == 1 ? R.color.nav_bar_tip_error : R.color.cp_link_tip_a_alpha95));
                        }
                        if (z && frsNewAreaFragment != null) {
                            frsNewAreaFragment.cN(deleteThreadHttpResponseMessage.getSuccessItems());
                        }
                        FrsFragment.this.cB(deleteThreadHttpResponseMessage.getSuccessItems());
                        b.caw().cA(deleteThreadHttpResponseMessage.getSuccessItems());
                        for (com.baidu.adp.widget.ListView.q qVar : FrsFragment.this.hEX.getThreadList()) {
                            if (qVar instanceof bu) {
                                i3++;
                                continue;
                            }
                            if (i3 >= 6) {
                                break;
                            }
                        }
                        if (i3 < 6) {
                            FrsFragment.this.bwE();
                            return;
                        }
                        return;
                    }
                    com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getActivity(), deleteThreadHttpResponseMessage.getErrorString());
                }
            }
        });
        this.cXV = UtilHelper.getScreenHeight(getActivity());
        this.hasInit = true;
        uE(1);
        super.onActivityCreated(bundle);
        this.createTime = System.currentTimeMillis() - j;
    }

    public void nB(boolean z) {
        if (this.hFU != null) {
            this.hFU.ihd = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cB(List<String> list) {
        if (!com.baidu.tbadk.core.util.x.isEmpty(list)) {
            ArrayList<com.baidu.adp.widget.ListView.q> threadList = this.hEX.getThreadList();
            if (!com.baidu.tbadk.core.util.x.isEmpty(threadList) && this.hFz.getListView() != null && this.hFz.getListView().getData() != null) {
                Iterator<com.baidu.adp.widget.ListView.q> it = threadList.iterator();
                List<com.baidu.adp.widget.ListView.q> data = this.hFz.getListView().getData();
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.q next = it.next();
                    if (next instanceof bu) {
                        bv bvVar = ((bu) next).dLK;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= list.size()) {
                                break;
                            } else if (!com.baidu.tbadk.core.util.as.equals(list.get(i2), bvVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.hGd.d(next);
                                this.hFz.getListView().getAdapter().notifyItemRemoved(i);
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
    public void cau() {
        if (!com.baidu.tbadk.core.util.x.isEmpty(com.baidu.tieba.frs.a.cap().cat()) && this.hFz.getListView() != null && this.hFz.getListView().getData() != null) {
            ArrayList<com.baidu.adp.widget.ListView.q> threadList = this.hEX.getThreadList();
            if (!com.baidu.tbadk.core.util.x.isEmpty(threadList)) {
                Iterator<com.baidu.adp.widget.ListView.q> it = threadList.iterator();
                List<com.baidu.adp.widget.ListView.q> data = this.hFz.getListView().getData();
                int count = com.baidu.tbadk.core.util.x.getCount(com.baidu.tieba.frs.a.cap().cat());
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.q next = it.next();
                    if (next instanceof bu) {
                        bv bvVar = ((bu) next).dLK;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= count) {
                                break;
                            } else if (!com.baidu.tbadk.core.util.as.equals(com.baidu.tieba.frs.a.cap().cat().get(i2).getId(), bvVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.hGd.d(next);
                                this.hFz.getListView().getAdapter().notifyItemRemoved(i);
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
    public void bwZ() {
        if (isAdded() && this.fvp && !isLoadingViewAttached()) {
            showLoadingView(this.hFz.bPb(), true);
        }
    }

    @Override // com.baidu.tieba.frs.ao
    public void bxa() {
        if (isAdded() && this.fvp && isLoadingViewAttached()) {
            hideLoadingView(this.hFz.bPb());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (ccc()) {
            showLoadingView(this.hFz.bPb(), true);
            this.hFz.uS(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.hFS.O(3, true);
            bcE().scrollToPosition(0);
        }
    }

    private void uE(int i) {
        String str = "";
        if (this.hEX != null && this.hEX.getForum() != null) {
            str = this.hEX.getForum().getId();
        }
        if (!StringUtils.isNull(str)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c13008").dn("fid", str).dn("obj_type", "4").ah("obj_locate", i).dn("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    @Override // com.baidu.tieba.frs.ao
    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.aa aaVar) {
        if (aaVar != null) {
            this.eKX = aaVar.bmT();
            this.hGk = aaVar.bmU();
        }
    }

    @Override // com.baidu.tieba.frs.ao
    public void showFloatingView() {
        if (this.eKX != null) {
            this.eKX.showFloatingView(true);
        }
    }

    private void S(Intent intent) {
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
                this.hFr = uri.getQueryParameter("name");
                this.mFrom = uri.getQueryParameter("from");
                if (!StringUtils.isNull(this.hFr)) {
                    intent.putExtra("name", this.hFr);
                }
                if (!StringUtils.isNull(this.mFrom)) {
                    intent.putExtra("from", this.mFrom);
                }
                TiebaStatic.log(TbadkCoreStatisticKey.AS_INVOKE_TIEBA);
            }
            if (StringUtils.isNull(this.hFr) && uri != null) {
                if (com.baidu.tbadk.BdToken.f.p(uri)) {
                    com.baidu.tbadk.BdToken.f.aQv().b(uri, this.hHf);
                } else {
                    com.baidu.tieba.frs.f.d V = com.baidu.tieba.frs.f.i.V(intent);
                    if (V != null) {
                        this.hFr = V.forumName;
                        if (V.ieH == null || V.ieH.equals("aidou")) {
                        }
                    }
                }
                if (!StringUtils.isNull(this.hFr)) {
                    intent.putExtra("name", this.hFr);
                }
                intent.putExtra(FrsActivityConfig.FRS_CALL_FROM, 12);
            }
        }
    }

    /* renamed from: com.baidu.tieba.frs.FrsFragment$29  reason: invalid class name */
    /* loaded from: classes16.dex */
    class AnonymousClass29 implements f.a {
        AnonymousClass29() {
        }

        @Override // com.baidu.tbadk.BdToken.f.a
        public void B(final HashMap<String, Object> hashMap) {
            if (hashMap != null) {
                if (hashMap.get(com.baidu.tbadk.BdToken.f.dFX) instanceof String) {
                    FrsFragment.this.hFr = (String) hashMap.get(com.baidu.tbadk.BdToken.f.dFX);
                }
                if ((hashMap.get(com.baidu.tbadk.BdToken.f.dGp) instanceof String) && !TextUtils.isEmpty((String) hashMap.get(com.baidu.tbadk.BdToken.f.dGp))) {
                    com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.29.1
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsFragment.this.hFU.wA(301);
                            final long j = com.baidu.adp.lib.f.b.toLong((String) hashMap.get(com.baidu.tbadk.BdToken.f.dFY), 0L);
                            final int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
                            final int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
                            final float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                            final int i = 1;
                            if (com.baidu.tbadk.core.util.at.baS().baT()) {
                                i = 2;
                            }
                            com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.29.1.1
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
        this.hFy = getVoiceManager();
        if (this.hFy != null) {
            this.hFy.onStart(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        Intent intent;
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.erZ);
        if (bundle != null) {
            this.hFr = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
            this.hFr = intent.getStringExtra("name");
            this.mFrom = intent.getStringExtra("from");
            this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
        }
        if (getArguments() != null) {
            this.hFs = getArguments().getBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, false);
        }
        if (TextUtils.isEmpty(this.mFrom) || FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
        }
        if (this.mIsLogin) {
            registerListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL, this.erZ);
        }
        this.hFT.ar(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.s.c.dkh().B(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.hHm);
        this.hGe.destroy();
        hFD = null;
        if (this.hFy != null) {
            this.hFy.onDestory(getPageContext());
        }
        com.baidu.tieba.recapp.report.a.remove("FRS");
        this.hFy = null;
        com.baidu.tieba.card.s.bRL().mH(false);
        if (this.hEX != null && this.hEX.getForum() != null) {
            ai.cdB().ev(com.baidu.adp.lib.f.b.toLong(this.hEX.getForum().getId(), 0L));
        }
        if (this.hGg != null) {
            this.hGg.onDestory();
        }
        if (this.hFz != null) {
            com.baidu.tieba.frs.f.h.a(this.hFz, this.hEX, getForumId(), false, null);
            this.hFz.onDestroy();
        }
        if (this.hFC != null) {
            this.hFC.removeAllViews();
            this.hFC.setVisibility(8);
        }
        if (this.hGA != null) {
            this.hGA.cancel();
        }
        if (this.hGB != null) {
            com.baidu.adp.lib.f.e.lt().removeCallbacks(this.hGB);
        }
        this.hGz = null;
        super.onDestroy();
        try {
            if (this.hFM != null) {
                this.hFM.bls();
            }
            if (this.hFz != null) {
                this.hFz.release();
            }
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.hFT.cgL();
        Looper.myQueue().removeIdleHandler(this.hGF);
        if (this.hFS != null) {
            this.hFS.bCu();
        }
        if (this.hFY != null) {
            this.hFY.cdJ();
        }
        if (this.hGb != null) {
            this.hGb.destory();
        }
        if (this.hFW != null) {
            this.hFW.onDestroy();
        }
        if (this.hGm != null) {
            this.hGm.onDestory();
        }
        if (this.hGf != null) {
            this.hGf.onDestroy();
        }
        if (this.hGo != null) {
            this.hGo.onDestroy();
        }
        if (this.hGp != null) {
            this.hGp.onDestroy();
        }
        com.baidu.tieba.recapp.d.a.dcN().dcP();
        com.baidu.tieba.frs.f.j.cik();
        if (this.hFU != null) {
            this.hFU.a((FrsTabViewController.a) null);
            this.hFU.cjr();
        }
        if (this.hGs != null) {
            this.hGs.onDestroy();
        }
        b.caw().a(null);
        com.baidu.tieba.frs.a.cap().a(null);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.hFr);
        bundle.putString("from", this.mFrom);
        this.hFS.onSaveInstanceState(bundle);
        if (this.hFy != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            this.hFy.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.hGf != null) {
            this.hGf.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.hFz != null) {
            this.hFz.ccH();
            this.hFz.onResume();
        }
        this.hFV.ov(true);
        this.hFN = true;
        if (hFq) {
            hFq = false;
            if (this.hFz != null) {
                this.hFz.startPullRefresh();
                return;
            }
            return;
        }
        if (this.hFy != null) {
            this.hFy.onResume(getPageContext());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_RESUME));
        if (this.hFz != null) {
            this.hFz.nN(false);
        }
        if (this.hGn) {
            refresh(6);
            this.hGn = false;
        }
        if (this.hGw != null && getActivity() != null) {
            if (NotificationManagerCompat.from(getActivity()).areNotificationsEnabled()) {
                com.baidu.tbadk.coreExtra.messageCenter.f.bgj().setSignAlertOn(true);
                com.baidu.tbadk.coreExtra.messageCenter.f.bgj().setSignAlertTime(this.hGw.getHours(), this.hGw.getMinutes());
                if (this.hFz != null) {
                    com.baidu.tbadk.coreExtra.messageCenter.f.bgj().a(getTbPageContext().getPageActivity(), this.hFz.bPb());
                }
            }
            this.hGw = null;
        }
        ccj();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
    }

    public boolean cbM() {
        Intent intent;
        if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
            return false;
        }
        return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
    }

    public void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.hFr = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.hFt = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.hFt) {
                cbN();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbN() {
        this.hFz.startPullRefresh();
    }

    public void closeActivity() {
        com.baidu.tieba.frs.f.i.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.mFrom);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.hFz.setTitle(this.hFr);
        } else {
            this.hFz.setTitle("");
            this.mFlag = 1;
        }
        this.hFz.a(this.hHk);
        this.hFz.addOnScrollListener(this.mScrollListener);
        this.hFz.g(this.hCK);
        this.hFz.ccU().a(this.hHj);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hGu) {
            this.hFz.onChangeSkinType(i);
            this.hFT.wr(i);
            this.hFU.onChangeSkinType(i);
            if (this.hFB != null) {
                this.hFB.onChangeSkinType(i);
            }
            if (this.hGl != null) {
                this.hGl.onChangeSkinType();
            }
            if (this.hGq != null) {
                this.hGq.onChangeSkinType(getPageContext(), i);
            }
            if (this.gZc != null) {
                com.baidu.tbadk.r.a.a(getPageContext(), this.gZc.getRealView());
            }
            if (this.hGm != null) {
                this.hGm.onChangeSkinType(getPageContext(), i);
            }
        }
    }

    public void uF(int i) {
        if (!this.mIsLogin) {
            if (this.hEX != null && this.hEX.getAnti() != null) {
                this.hEX.getAnti().setIfpost(1);
            }
            if (i == 0) {
                bf.skipToLoginActivity(getActivity());
            }
        } else if (this.hEX != null) {
            if (i == 0) {
                com.baidu.tieba.frs.f.j.g(this, 0);
            } else {
                this.hFz.ccJ();
            }
        }
    }

    public void refresh() {
        com.baidu.tieba.a.d.brD().AO("page_frs");
        refresh(3);
    }

    public void refresh(int i) {
        this.hFK = false;
        cbU();
        if (this.hFz != null && this.hFz.ccy() != null) {
            this.hFz.ccy().cmG();
        }
        if (this.hFS != null) {
            this.hFS.O(i, true);
        }
    }

    private void cbO() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.f.h.lu().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.33
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.NT(FrsFragment.this.hFr);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbP() {
        cbU();
        try {
            if (this.hEX != null) {
                this.hFz.bBY();
                this.hFz.nG(cci());
                if (!com.baidu.tieba.frs.vc.h.m(this.hEX) || !com.baidu.tieba.frs.vc.h.l(this.hEX)) {
                }
                if (this.hEX.getForum() != null) {
                    this.hFr = this.hEX.getForum().getName();
                    this.forumId = this.hEX.getForum().getId();
                }
                if (this.hEX.getPage() != null) {
                    setHasMore(this.hEX.getPage().aVb());
                }
                this.hFz.setTitle(this.hFr);
                this.hFz.setForumName(this.hFr);
                TbadkCoreApplication.getInst().setDefaultBubble(this.hEX.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.hEX.getUserData().getBimg_end_time());
                cbO();
                cbQ();
                ArrayList<com.baidu.adp.widget.ListView.q> threadList = this.hEX.getThreadList();
                if (threadList != null) {
                    this.hFz.a(threadList, this.hEX);
                    com.baidu.tieba.frs.f.c.A(this.hFz);
                    this.hFT.ws(getPageNum());
                    this.hFT.i(this.hEX);
                    this.hFU.a(this.hEX, this.hFS.chr());
                    this.hFz.ccK();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void cbQ() {
        if (this.hEX != null) {
            if (this.hEX.getIsNewUrl() == 1) {
                this.hFz.ccU().setFromCDN(true);
            } else {
                this.hFz.ccU().setFromCDN(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.hFV.ov(false);
        this.hFN = false;
        this.hFz.onPause();
        if (this.hFy != null) {
            this.hFy.onPause(getPageContext());
        }
        this.hFz.nN(true);
        if (this.hGb != null) {
            this.hGb.cin();
        }
        com.baidu.tbadk.BdToken.c.aQc().aQm();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.hFU != null && this.hFU.cjp() != null && (this.hFU.cjp().fragment instanceof BaseFragment)) {
            ((BaseFragment) this.hFU.cjp().fragment).setPrimary(z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.s.bRL().mH(false);
        nz(false);
        if (this.hEX != null && this.hEX.getForum() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            com.baidu.tbadk.distribute.a.biw().b(getPageContext().getPageActivity(), "frs", this.hEX.getForum().getId(), 0L);
        }
        if (this.hFy != null) {
            this.hFy.onStop(getPageContext());
        }
        if (bcE() != null) {
            bcE().getRecycledViewPool().clear();
        }
        this.hFT.bbU();
        com.baidu.tbadk.util.ab.bmW();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            if (this.hFT != null) {
                this.hFT.bE(isPrimary());
            }
            if (this.hFz != null) {
                this.hFz.bE(isPrimary());
                this.hFz.nN(!isPrimary());
            }
        }
    }

    private void cbR() {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.lq(2);
        aVar.hK(false);
        FrsBroadcastCopyGuideDialogView frsBroadcastCopyGuideDialogView = new FrsBroadcastCopyGuideDialogView(getPageContext().getPageActivity());
        frsBroadcastCopyGuideDialogView.setConfirmButtonListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.35
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aVar != null) {
                    aVar.dismiss();
                    FrsFragment.this.cbS();
                }
            }
        });
        aVar.aV(frsBroadcastCopyGuideDialogView);
        aVar.b(getPageContext()).aYL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbS() {
        if (KuangFloatingFrsCopyLinkViewController.getInstance().init()) {
            ((BaseFragmentActivity) getPageContext().getOrignalPage()).grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.frs.FrsFragment.36
                @Override // com.baidu.tbadk.core.e
                public void onPermissionResult(boolean z) {
                    if (!z) {
                        new BdTopToast(FrsFragment.this.getContext()).wd(false).Pr(FrsFragment.this.getContext().getString(R.string.forum_broadcast_copy_no_permission_hint)).aF(FrsFragment.this.hFz.bPb());
                        return;
                    }
                    KuangFloatingFrsCopyLinkViewController.getInstance().showFloatingView(true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                    if (FrsFragment.this.hFA != null) {
                        FrsFragment.this.hFA.setVisibility(8);
                    }
                }
            }, true);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (b.caw().caq()) {
                b.caw().reset();
                return true;
            } else if (com.baidu.tieba.frs.a.cap().caq()) {
                if (this.hFz != null && this.hFz.ccZ()) {
                    this.hFz.cda();
                    return true;
                }
                com.baidu.tieba.frs.a.cap().reset();
                return true;
            } else if (this.hFz != null) {
                return this.hFz.ccG();
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
        com.baidu.tbadk.distribute.a.biw().a(advertAppInfo, this.forumId, 0L, "FRS", str, getPn());
    }

    @Override // com.baidu.tieba.recapp.n
    public void cbT() {
        cbr().cbT();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.hFy == null) {
            this.hFy = VoiceManager.instance();
        }
        return this.hFy;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdRecyclerView bcE() {
        if (this.hFz == null) {
            return null;
        }
        return this.hFz.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void cbU() {
        if (this.hFy != null) {
            this.hFy.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> bcF() {
        if (this.elu == null) {
            this.elu = UserIconBox.t(getPageContext().getPageActivity(), 8);
        }
        return this.elu;
    }

    public void cbV() {
        if (getFragmentActivity() != null && getFragmentActivity().getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.t onGetPreLoadListView() {
        return bcE().getPreLoadHandle();
    }

    @Override // com.baidu.tieba.frs.ar
    public NavigationBar bAm() {
        if (this.hFz == null) {
            return null;
        }
        return this.hFz.bAm();
    }

    public FRSRefreshButton cbW() {
        return this.hFB;
    }

    public void c(LinearLayout linearLayout) {
        if (linearLayout != null) {
            this.hFC = linearLayout;
        }
    }

    public void a(FRSRefreshButton fRSRefreshButton) {
        if (fRSRefreshButton != null) {
            this.hFB = fRSRefreshButton;
            this.hFB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.42
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (FrsFragment.this.hFU != null) {
                        FrsTabViewController.b cjp = FrsFragment.this.hFU.cjp();
                        if (cjp != null && cjp.fragment != null && (cjp.fragment instanceof aq)) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                            ((aq) cjp.fragment).cbd();
                            ((aq) cjp.fragment).bxR();
                            return;
                        }
                        FrsFragment.this.cbw().startPullRefresh();
                    }
                }
            });
        }
    }

    public void cbX() {
        if (this.hFB != null) {
            this.hFB.hide();
        }
    }

    public void cbY() {
        if (this.hFB != null) {
            this.hFB.show();
        }
    }

    /* loaded from: classes16.dex */
    private final class a implements com.baidu.adp.widget.ListView.z {
        private a() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.z
        public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null) {
                if (bdUniqueId == v.hJk) {
                    if (FrsFragment.this.hFz != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c11752").dn("fid", FrsFragment.this.forumId).dn("obj_locate", "1"));
                        FrsFragment.this.hFz.startPullRefresh();
                    }
                } else if (qVar != null && (qVar instanceof bu)) {
                    bv bvVar = ((bu) qVar).dLK;
                    if (bvVar.aXl() == null || bvVar.aXl().getGroup_id() == 0 || bf.checkUpIsLogin(FrsFragment.this.getActivity())) {
                        if (bvVar.aWY() != 1 || bf.checkUpIsLogin(FrsFragment.this.getActivity())) {
                            if (bvVar.aWx() != null) {
                                if (bf.checkUpIsLogin(FrsFragment.this.getActivity())) {
                                    String postUrl = bvVar.aWx().getPostUrl();
                                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.isNetOk()) {
                                        com.baidu.tbadk.browser.a.startInternalWebActivity(FrsFragment.this.getActivity(), postUrl);
                                    }
                                }
                            } else if (bvVar.aXw() != null) {
                                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                    bf.skipToLoginActivity(FrsFragment.this.getPageContext().getPageActivity());
                                    return;
                                }
                                com.baidu.tbadk.core.data.r aXw = bvVar.aXw();
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), aXw.getCartoonId(), aXw.getChapterId(), 2)));
                            } else {
                                com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                                if (readThreadHistory != null && !readThreadHistory.NZ(bvVar.getId())) {
                                    readThreadHistory.NY(bvVar.getId());
                                }
                                boolean z = false;
                                final String aWr = bvVar.aWr();
                                if (aWr != null && !aWr.equals("")) {
                                    z = true;
                                    new Thread(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.a.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            com.baidu.tbadk.core.util.z zVar = new com.baidu.tbadk.core.util.z(aWr);
                                            zVar.bav().baW().mIsNeedAddCommenParam = false;
                                            zVar.bav().baW().mIsUseCurrentBDUSS = false;
                                            zVar.getNetData();
                                        }
                                    }).start();
                                }
                                String tid = bvVar.getTid();
                                if (tid == null) {
                                    tid = "";
                                }
                                if (bvVar.aWg() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                    com.baidu.tbadk.core.util.bd.baV().b(FrsFragment.this.getPageContext(), new String[]{tid, "", null});
                                    return;
                                }
                                if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && tid.length() > 4) {
                                    bvVar.setId(tid.substring(3));
                                }
                                if (bdUniqueId.getId() == bv.dTv.getId()) {
                                    com.baidu.tieba.frs.f.h.a(bvVar.aVR());
                                } else if (bdUniqueId.getId() == bv.dRW.getId()) {
                                    com.baidu.tbadk.core.util.ap apVar = new com.baidu.tbadk.core.util.ap(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                                    apVar.dn("obj_type", "2");
                                    apVar.dn("tid", bvVar.getTid());
                                    TiebaStatic.log(apVar);
                                }
                                com.baidu.tieba.frs.f.i.a(FrsFragment.this, bvVar, i, z);
                                com.baidu.tieba.frs.f.h.a(FrsFragment.this, FrsFragment.this.hEX, bvVar);
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
            hideNetRefreshView(this.hFz.bPb());
            showLoadingView(this.hFz.bPb(), true);
            this.hFz.nJ(false);
            this.hFS.O(3, true);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData cbZ() {
        return this.hEX;
    }

    public boolean cca() {
        return this.hFz.cca();
    }

    public void aA(Object obj) {
        if (this.hFX != null && this.hFX.hZZ != null) {
            this.hFX.hZZ.callback(obj);
        }
    }

    public void aB(Object obj) {
        if (this.hFX != null && this.hFX.iaa != null) {
            this.hFX.iaa.callback(obj);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        this.hFz.getListView().stopScroll();
        if (!this.hFz.ccQ()) {
            if (!com.baidu.adp.lib.util.l.isNetOk()) {
                this.hFz.bxU();
            } else if (this.hFS.chm() == 1) {
                bwT();
                bwE();
            } else if (this.hFS.hasMore()) {
                bwE();
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void onFailed(String str) {
        bwT();
        showToast(str);
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void ao(ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        boolean isEmpty = com.baidu.tbadk.core.util.x.isEmpty(arrayList);
        setHasMore(isEmpty ? 0 : 1);
        bwT();
        if (!isEmpty) {
            if (!this.hFS.chw() && TbadkCoreApplication.getInst().isRecAppExist() && this.hFS.chm() == 1) {
                this.hEX.addRecommendAppToThreadList(this, arrayList);
            }
            if (this.hFS != null) {
                com.baidu.tieba.frs.d.a.a(getUniqueId(), arrayList, this.hEX.getForum(), this.hFS.getSortType());
            }
            ArrayList<com.baidu.adp.widget.ListView.q> a2 = this.hGd.a(false, false, arrayList, this.hFv, false);
            if (a2 != null) {
                this.hEX.setThreadList(a2);
                this.hFz.a(a2, this.hEX);
            }
            if (this.hFS != null) {
                com.baidu.tieba.frs.d.c.a(this.hEX, this.hFS.chr(), 2, getContext());
            }
        }
    }

    private void bwT() {
        if (cbx() == 1 || this.hGd.cM(this.hEX.getThreadListIds())) {
            if (com.baidu.tbadk.core.util.x.getCount(this.hEX.getThreadList()) > 3) {
                this.hFz.bxS();
            } else {
                this.hFz.ccX();
            }
        } else if (com.baidu.tbadk.core.util.x.isEmpty(this.hEX.getThreadList())) {
            this.hFz.bxU();
        } else {
            this.hFz.bxT();
        }
    }

    @Override // com.baidu.tieba.frs.mc.l
    public void bwE() {
        if (this.hGd != null) {
            this.hGd.a(this.hFr, this.forumId, this.hEX);
        }
    }

    public void ccb() {
        if (!com.baidu.tbadk.core.util.ad.requestWriteExternalStorgeAndCameraPermission(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.an.g(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment, com.baidu.i.a.a.InterfaceC0153a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        com.baidu.tieba.frs.f.i.a(this, i, strArr, iArr);
    }

    public void nC(boolean z) {
        if (this.hFY != null) {
            this.hFY.nW(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.hFZ.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a pE(int i) {
        return this.hFZ.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        this.hGh.b(bVar);
    }

    public boolean ccc() {
        return this.hFn;
    }

    @Override // com.baidu.tieba.frs.ao
    public void IH() {
        if (this.hFz != null) {
            showFloatingView();
            this.hFz.getListView().scrollToPosition(0);
            this.hFz.startPullRefresh();
        }
    }

    public ForumWriteData ccd() {
        if (this.hEX == null || this.hEX.getForum() == null) {
            return null;
        }
        ForumData forum = this.hEX.getForum();
        ForumWriteData forumWriteData = new ForumWriteData(forum.getId(), forum.getName(), forum.getPrefixData(), this.hEX.getAnti());
        forumWriteData.avatar = forum.getImage_url();
        forumWriteData.forumLevel = forum.getUser_level();
        forumWriteData.specialForumType = forum.special_forum_type;
        forumWriteData.firstDir = forum.getFirst_class();
        forumWriteData.secondDir = forum.getSecond_class();
        UserData userData = this.hEX.getUserData();
        forumWriteData.privateThread = userData != null ? userData.getPrivateThread() : 0;
        forumWriteData.frsTabInfo = cce();
        return forumWriteData;
    }

    private FrsTabInfoData cce() {
        int i;
        if (this.hFS == null || this.hEX == null || this.hFU == null) {
            return null;
        }
        if (this.hEX.getEntelechyTabInfo() == null || com.baidu.tbadk.core.util.x.isEmpty(this.hEX.getEntelechyTabInfo().tab)) {
            return null;
        }
        int cjt = this.hFU.cjt();
        if (cjt == 502) {
            return null;
        }
        int i2 = -1;
        ArrayList arrayList = new ArrayList();
        Iterator<FrsTabInfo> it = this.hEX.getEntelechyTabInfo().tab.iterator();
        while (true) {
            i = i2;
            if (!it.hasNext()) {
                break;
            }
            FrsTabInfo next = it.next();
            if (next != null && next.is_general_tab.intValue() == 1) {
                arrayList.add(new FrsTabItemData(next));
                if (cjt == next.tab_id.intValue()) {
                    i2 = cjt;
                }
            }
            i2 = i;
        }
        if (com.baidu.tbadk.core.util.x.isEmpty(arrayList)) {
            return null;
        }
        FrsTabInfoData frsTabInfoData = new FrsTabInfoData();
        frsTabInfoData.tabList = arrayList;
        frsTabInfoData.selectedTabId = i;
        return frsTabInfoData;
    }

    @Override // com.baidu.tieba.frs.ao
    public void bci() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void nD(boolean z) {
        this.hFO = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z) {
        this.hFz.uN(8);
        ((FrsActivity) getActivity()).showLoadingView(view, z);
        ((FrsActivity) getActivity()).j(view, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        this.hFz.uN(0);
        ((FrsActivity) getActivity()).hideLoadingView(view);
        ((FrsActivity) getActivity()).j(view, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        super.showNetRefreshView(view, getResources().getString(R.string.refresh_view_title_text), null, getResources().getString(R.string.refresh_view_button_text), z, getNetRefreshListener());
        this.hFz.uN(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshViewNoClick(View view, String str, boolean z) {
        super.showNetRefreshViewNoClick(view, str, z);
        this.hFz.uN(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        super.hideNetRefreshView(view);
        this.hFz.uN(0);
    }

    public void ccf() {
        FrsTabViewController.b cjp;
        if (this.hFU != null && (cjp = this.hFU.cjp()) != null && cjp.fragment != null && (cjp.fragment instanceof aq)) {
            ((aq) cjp.fragment).cbd();
        }
    }

    public void nE(boolean z) {
        this.hFp = z;
    }

    public void b(OvalActionButton ovalActionButton) {
        this.hFA = ovalActionButton;
    }

    public OvalActionButton ccg() {
        return this.hFA;
    }

    public boolean cch() {
        return this.hFp;
    }

    public void onShareSuccess(String str) {
        if (TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.util.as.isEmpty(str)) {
            if (this.hGs == null) {
                this.hGs = new AddExperiencedModel(getTbPageContext());
            }
            this.hGs.fs(this.forumId, str);
        }
    }

    public boolean cci() {
        if (this.hFO && !this.hGv) {
            return (this.hFS != null && this.hFS.chn() && (b.caw().caq() || com.baidu.tieba.frs.a.cap().caq())) ? false : true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.f.b
    public boolean videoNeedPreload() {
        if (this.hEX != null) {
            return com.baidu.tbadk.util.ag.oz(2) || (com.baidu.tbadk.util.ag.bnb() && this.hEX.isFrsVideoAutoPlay);
        }
        return super.videoNeedPreload();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccj() {
        if (!com.baidu.tbadk.core.util.as.isEmpty(this.forumId)) {
            com.baidu.tbadk.BdToken.c.aQc().q(com.baidu.tbadk.BdToken.b.dEy, com.baidu.adp.lib.f.b.toLong(this.forumId, 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cck() {
        String format;
        String str;
        if (isResumed() && this.hGz != null && this.hGz.size() >= 1 && this.hGy <= this.hGz.size() - 1) {
            final LiveHorseRaceData liveHorseRaceData = this.hGz.get(this.hGy);
            if (System.currentTimeMillis() / 1000 >= liveHorseRaceData.getRob_end_tm().longValue()) {
                this.hGy++;
                cck();
            }
            if (this.hFC != null) {
                final FrsRedpackRunView frsRedpackRunView = new FrsRedpackRunView(getActivity());
                if (liveHorseRaceData.getUser_nickname() == null || TextUtils.isEmpty(liveHorseRaceData.getUser_nickname())) {
                    format = String.format(getResources().getString(R.string.live_horserace_red_envelope), getResources().getString(R.string.frs_horse_none_title_verser));
                } else if (liveHorseRaceData.getUser_nickname().length() > 4) {
                    format = String.format(getResources().getString(R.string.live_horserace_red_envelope), liveHorseRaceData.getUser_nickname().substring(0, 4) + StringHelper.STRING_MORE);
                } else {
                    format = String.format(getResources().getString(R.string.live_horserace_red_envelope), liveHorseRaceData.getUser_nickname());
                }
                frsRedpackRunView.settextTitle(format + format + format);
                frsRedpackRunView.setClickliner(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.49
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        String str2;
                        if (FrsFragment.this.hEX == null) {
                            str2 = "";
                        } else if (FrsFragment.this.hEX.getForum() != null) {
                            str2 = FrsFragment.this.hEX.getForum().getName();
                        } else {
                            str2 = "";
                        }
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c13744").ah("obj_source", 1).dn("fid", FrsFragment.this.forumId).dn("fname", str2));
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
                this.hGA = ValueAnimator.ofFloat(1.0f, 0.0f);
                this.hGA.setDuration(600L);
                this.hGA.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.FrsFragment.50
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        if (valueAnimator.isRunning()) {
                            frsRedpackRunView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                            frsRedpackRunView.setTranslationX(-(TbadkApplication.getInst().getContext().getResources().getDimensionPixelOffset(R.dimen.tbds850) * valueAnimator.getAnimatedFraction()));
                        }
                    }
                });
                this.hGA.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.FrsFragment.51
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        frsRedpackRunView.setAlpha(0.0f);
                        frsRedpackRunView.setTranslationY(TbadkApplication.getInst().getContext().getResources().getDimensionPixelOffset(R.dimen.tbds660));
                        frsRedpackRunView.hide();
                        FrsFragment.this.hFC.removeView(frsRedpackRunView);
                        if (FrsFragment.this.hGy > FrsFragment.this.hGz.size() - 1) {
                            FrsFragment.this.hFC.removeAllViews();
                            FrsFragment.this.hFC.setVisibility(8);
                            FrsFragment.this.hGy = 0;
                            return;
                        }
                        FrsFragment.this.cck();
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        onAnimationEnd(animator);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                this.hGB = new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.52
                    @Override // java.lang.Runnable
                    public void run() {
                        if (FrsFragment.this.hFC != null && frsRedpackRunView != null) {
                            FrsFragment.this.hGA.start();
                        }
                    }
                };
                com.baidu.adp.lib.f.e.lt().postDelayed(this.hGB, 5000L);
                if (this.hFC.getChildCount() == 0) {
                    this.hGy++;
                    this.hFC.addView(frsRedpackRunView);
                    if (this.hEX != null) {
                        str = this.hEX.getForum() != null ? this.hEX.getForum().getName() : "";
                    } else {
                        str = "";
                    }
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c13743").ah("obj_source", 1).dn("fid", this.forumId).dn("fname", str));
                }
                if (this.hFC.getVisibility() == 8 && ((BaseFragment) this.hFU.cjp().fragment).isPrimary() && !this.hFz.cdg() && !this.hFI) {
                    this.hFC.setVisibility(0);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        FrsTabViewController.b cjp;
        if (cbu() == null || (cjp = cbu().cjp()) == null || !(cjp.fragment instanceof BaseFragment)) {
            return null;
        }
        if (cjp.fragment instanceof FrsAllThreadFragment) {
            TbPageTag tbPageTag = super.getTbPageTag();
            int i = -1;
            if (this.hEX != null) {
                i = this.hEX.getSortType();
            }
            tbPageTag.sortType = com.baidu.tieba.frs.f.g.wp(i);
            tbPageTag.locatePage = "a070";
            if (this.hFk.equals(cjp.title)) {
                tbPageTag.locatePage = "a071";
            }
            return tbPageTag;
        } else if (cjp.fragment instanceof FrsFragment) {
            return null;
        } else {
            return ((BaseFragment) cjp.fragment).getTbPageTag();
        }
    }

    public void ccl() {
        if (this.hEX != null) {
            com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
            if (this.hEX.needLog == 1) {
                bVar.icK = true;
            } else {
                bVar.icK = false;
            }
            if (this.hEX.getForum() != null) {
                bVar.icM = this.hEX.getForum().getId();
            }
            if (cbr() != null) {
                bVar.icL = cbr().chr();
            }
            if (com.baidu.tieba.frs.d.d.hOE != null) {
                bVar.icN = com.baidu.tieba.frs.d.d.hOE.icN;
                bVar.icO = com.baidu.tieba.frs.d.d.hOE.icO;
            }
            this.hGC = new com.baidu.tieba.frs.live.b(bVar, getTbPageTag(), getUniqueId());
            this.hGC.vS(this.hGE);
            CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_CARD_CLICK, this.hGC);
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
            CustomMessageTask customMessageTask2 = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW, this.hGC);
            customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask2);
            CustomMessageTask customMessageTask3 = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_USER_CLICK, this.hGC);
            customMessageTask3.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask3);
            CustomMessageTask customMessageTask4 = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_VIDEO_CLICK, this.hGC);
            customMessageTask4.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask4);
        }
    }
}
