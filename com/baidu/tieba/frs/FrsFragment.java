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
/* loaded from: classes22.dex */
public class FrsFragment extends BaseFragment implements BdListView.e, a.InterfaceC0238a, UserIconBox.b<BdRecyclerView>, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, aq, at, aw, com.baidu.tieba.frs.loadmore.a, com.baidu.tieba.frs.mc.l, com.baidu.tieba.recapp.n {
    public static com.baidu.tieba.tbadkCore.m iBw;
    private com.baidu.adp.lib.d.b<TbImageView> eSd;
    private com.baidu.tbadk.util.aa fti;
    private com.baidu.tieba.frs.gametab.b gxx;
    private com.baidu.tbadk.core.dialog.a hUt;
    private String iBI;
    private com.baidu.card.am iBK;
    private FrsModelController iBL;
    private com.baidu.tieba.frs.vc.h iBM;
    private FrsTabViewController iBN;
    private com.baidu.tieba.frs.mc.h iBO;
    private com.baidu.tieba.frs.smartsort.a iBP;
    private com.baidu.tieba.frs.mc.b iBQ;
    private ax iBR;
    private com.baidu.tieba.frs.entelechy.b.b iBT;
    private com.baidu.tieba.frs.vc.a iBU;
    private com.baidu.tieba.frs.mc.d iBV;
    private com.baidu.tieba.frs.mc.c iBW;
    private com.baidu.tieba.frs.vc.j iBX;
    private com.baidu.tieba.frs.mc.a iBY;
    private com.baidu.tieba.frs.live.a iBZ;
    private com.baidu.tieba.frs.entelechy.a iBe;
    private com.baidu.tieba.tbadkCore.data.f iBo;
    private VoiceManager iBr;
    private OvalActionButton iBt;
    private FRSRefreshButton iBu;
    private LinearLayout iBv;
    public long iBx;
    private int iCH;
    private p iCa;
    public com.baidu.tieba.frs.vc.c iCb;
    private com.baidu.tieba.frs.mc.e iCc;
    private View.OnTouchListener iCd;
    private com.baidu.tieba.frs.view.a iCe;
    private com.baidu.tieba.frs.vc.e iCf;
    private boolean iCg;
    private com.baidu.tieba.NEGFeedBack.a iCh;
    private com.baidu.tieba.ala.a iCi;
    private com.baidu.tieba.frs.brand.buttommenu.a iCj;
    private com.baidu.tieba.frs.sportspage.notification.a iCk;
    private AddExperiencedModel iCl;
    private boolean iCn;
    private List<LiveHorseRaceData> iCs;
    private ValueAnimator iCt;
    private Runnable iCu;
    private com.baidu.tieba.frs.live.b iCv;
    private com.baidu.tieba.frs.broadcast.a iCw;
    private int iCx;
    private View mRootView;
    private String mSchemeUrl;
    public static boolean iBj = false;
    public static volatile long iBz = 0;
    public static volatile long iBA = 0;
    public static volatile int mNetError = 0;
    private String iBd = "";
    public boolean iBf = false;
    private boolean iBg = false;
    private boolean iBh = false;
    private boolean iBi = true;
    public String iBk = null;
    public String mFrom = null;
    public int mFlag = 0;
    public boolean iBl = false;
    private boolean iBm = false;
    private String mThreadId = null;
    public String forumId = null;
    private int iAS = 0;
    private boolean iBn = false;
    private boolean iBp = false;
    private boolean iBq = false;
    private q iBs = null;
    public final bw akq = null;
    private FrsViewData iAQ = new FrsViewData();
    public long idU = -1;
    public long fpw = 0;
    public long fpl = 0;
    public long createTime = 0;
    public long fpm = 0;
    public long fpt = 0;
    public long iBy = 0;
    boolean iBB = false;
    public boolean iBC = false;
    private boolean iBD = false;
    private boolean iBE = false;
    public com.baidu.tbadk.n.b iBF = null;
    private boolean iBG = true;
    private boolean iBH = true;
    private a.C0097a iBJ = new a.C0097a(2);
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> iBS = new SparseArray<>();
    private boolean ggt = true;
    private boolean hasInit = false;
    private boolean iCm = false;
    private boolean iCo = false;
    private Date iCp = null;
    private int dDO = 0;
    private int iCq = 0;
    private int iCr = 0;
    public int mHeadLineDefaultNavTabId = -1;
    MessageQueue.IdleHandler iCy = new MessageQueue.IdleHandler() { // from class: com.baidu.tieba.frs.FrsFragment.1
        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            FrsFragment.this.cvY();
            return false;
        }
    };
    private final CustomMessageListener iCz = new CustomMessageListener(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED) { // from class: com.baidu.tieba.frs.FrsFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof bw) {
                    com.baidu.tieba.frs.f.j.a(FrsFragment.this.iBs, FrsFragment.this.iAQ, FrsFragment.this.getForumId(), true, (bw) data);
                }
            }
        }
    };
    private CustomMessageListener iCA = new CustomMessageListener(CmdConfigCustom.CMD_CLOSE_GAME_RANK_CARD) { // from class: com.baidu.tieba.frs.FrsFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.iAQ != null) {
                FrsFragment.this.iAQ.removeGameRankListFromThreadList();
                if (FrsFragment.this.iBs != null) {
                    FrsFragment.this.iBs.aXR();
                }
            }
        }
    };
    private CustomMessageListener agB = new CustomMessageListener(2921401) { // from class: com.baidu.tieba.frs.FrsFragment.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && FrsFragment.this.iBu != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() <= 0 || FrsFragment.this.iBN.cDU() == 0 || FrsFragment.this.iBN.cDR() == null || !(FrsFragment.this.iBN.cDR().fragment instanceof BaseFragment) || !((BaseFragment) FrsFragment.this.iBN.cDR().fragment).isPrimary() || FrsFragment.this.iBs.cxv() || KuangFloatingFrsCopyLinkViewController.getInstance().isFloatCopyViewShow()) {
                    if (FrsFragment.this.iBN.cDU() != 0) {
                        FrsFragment.this.iBu.hide();
                        return;
                    }
                    return;
                }
                FrsFragment.this.iBu.show();
            }
        }
    };
    private CustomMessageListener iCB = new CustomMessageListener(2921473) { // from class: com.baidu.tieba.frs.FrsFragment.45
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && FrsFragment.this.iBu != null && FrsFragment.this.iBt != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() == 0) {
                    FrsFragment.this.iBu.setVisibility(8);
                    FrsFragment.this.iBt.setVisibility(8);
                    return;
                }
                FrsFragment.this.iBt.setVisibility(0);
            }
        }
    };
    private CustomMessageListener iCC = new CustomMessageListener(2921467) { // from class: com.baidu.tieba.frs.FrsFragment.56
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && FrsFragment.this.iBu != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() <= 0 || FrsFragment.this.iBN.cDR() == null || !(FrsFragment.this.iBN.cDR().fragment instanceof BaseFragment) || !((BaseFragment) FrsFragment.this.iBN.cDR().fragment).isPrimary() || FrsFragment.this.iBs.cxv()) {
                    FrsFragment.this.iBv.setVisibility(8);
                    FrsFragment.this.iBB = true;
                    return;
                }
                FrsFragment.this.iBv.setVisibility(0);
                FrsFragment.this.iBB = false;
            }
        }
    };
    private com.baidu.adp.framework.listener.a iCD = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_FRS_LIVE_HORSE_RACE_LIST, 309667) { // from class: com.baidu.tieba.frs.FrsFragment.60
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if ((responsedMessage instanceof GetLiveHorseRaceHttpResponseMessage) || (responsedMessage instanceof GetLiveHorseRaceSocketResponseMessage)) {
                    List<LiveHorseRaceData> arrayList = new ArrayList<>();
                    if (responsedMessage instanceof GetLiveHorseRaceHttpResponseMessage) {
                        arrayList = ((GetLiveHorseRaceHttpResponseMessage) responsedMessage).getData().cxW();
                    }
                    if (responsedMessage instanceof GetLiveHorseRaceSocketResponseMessage) {
                        arrayList = ((GetLiveHorseRaceSocketResponseMessage) responsedMessage).getData().cxW();
                    }
                    if (FrsFragment.this.iCs != null) {
                        if (FrsFragment.this.iBv.getVisibility() != 8) {
                            if (FrsFragment.this.iCr >= FrsFragment.this.iCs.size()) {
                                FrsFragment.this.iCs.addAll(arrayList);
                                return;
                            }
                            FrsFragment.this.iCs = FrsFragment.this.iCs.subList(0, FrsFragment.this.iCr);
                            FrsFragment.this.iCs.addAll(arrayList);
                            return;
                        }
                        FrsFragment.this.iCs = new ArrayList();
                        FrsFragment.this.iCs.addAll(arrayList);
                        FrsFragment.this.iCr = 0;
                        FrsFragment.this.cwz();
                        return;
                    }
                    FrsFragment.this.iCs = new ArrayList();
                    FrsFragment.this.iCr = 0;
                    FrsFragment.this.iCs.addAll(arrayList);
                    FrsFragment.this.cwz();
                }
            }
        }
    };
    private CustomMessageListener iCE = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.FrsFragment.61
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 1) {
                    FrsFragment.this.cwc();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                }
            }
        }
    };
    private final av iCF = new av() { // from class: com.baidu.tieba.frs.FrsFragment.62
        @Override // com.baidu.tieba.frs.av
        public void a(int i, int i2, bd bdVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
            FrsFragment.this.cvN();
            if (FrsFragment.this.iBT != null) {
                FrsFragment.this.iBM.ql(FrsFragment.this.iBT.zg(i));
            }
            com.baidu.tieba.tbadkCore.f fVar = new com.baidu.tieba.tbadkCore.f();
            if (bdVar != null) {
                fVar.isSuccess = bdVar.errCode == 0;
                fVar.errorCode = bdVar.errCode;
                fVar.errorMsg = bdVar.errMsg;
                if (fVar.isSuccess) {
                    if (com.baidu.tbadk.core.util.y.isEmpty(arrayList)) {
                        FrsFragment.this.iBs.bNw();
                    } else if (bdVar.hasMore) {
                        if (com.baidu.tbadk.core.util.y.getCount(FrsFragment.this.iAQ.getThreadList()) > 3) {
                            FrsFragment.this.iBs.TI();
                        } else {
                            FrsFragment.this.iBs.cxm();
                        }
                    } else if (bdVar.iGr) {
                        FrsFragment.this.iBs.TJ();
                    } else {
                        FrsFragment.this.iBs.bNw();
                    }
                }
            } else {
                bdVar = new bd();
                bdVar.pn = 1;
                bdVar.hasMore = false;
                bdVar.iGr = false;
            }
            if (i == 1) {
                FrsFragment.this.iBG = true;
                FrsFragment.this.iCW.a(FrsFragment.this.iBL.getType(), false, fVar);
            } else {
                FrsFragment.this.a(fVar);
                if (FrsFragment.this.iBL.cBm() != null) {
                    FrsFragment.this.iAQ = FrsFragment.this.iBL.cBm();
                }
                FrsFragment.this.cwe();
            }
            if (FrsFragment.this.iDe != null) {
                FrsFragment.this.iDe.a(i, i2, bdVar, arrayList);
            }
        }
    };
    private FrsTabViewController.a iCG = new FrsTabViewController.a() { // from class: com.baidu.tieba.frs.FrsFragment.2
        @Override // com.baidu.tieba.frs.vc.FrsTabViewController.a
        public void cj(int i, int i2) {
            boolean z = false;
            if (i != 1) {
                com.baidu.tieba.card.t.clQ().op(false);
                FrsFragment.this.pi(false);
            }
            if (i == 502) {
                FrsFragment.this.iBt.setIconFade(R.drawable.btn_frs_professional_edit_n);
            } else {
                FrsFragment.this.iBt.setIconFade(0);
            }
            FrsFragment.this.iCH = i;
            FrsFragment.this.iCx = i2;
            if (FrsFragment.this.iCv != null) {
                FrsFragment.this.iCv.zJ(FrsFragment.this.iCx);
            }
            TbSingleton.getInstance().setFrsCurTabType(FrsFragment.this.iCx);
            FrsFragment.this.cwj();
            com.baidu.tieba.frs.d.d.iLo.iZH = i;
            com.baidu.tieba.frs.d.d.iLo.iZK = i2;
            com.baidu.tieba.frs.d.d.iLo.iZI = -1;
            b.cuL().V(i == 1 && FrsFragment.this.iCm, true);
            com.baidu.tieba.frs.a cuE = com.baidu.tieba.frs.a.cuE();
            if (i == 1 && FrsFragment.this.iCm) {
                z = true;
            }
            cuE.V(z, true);
        }
    };
    private CustomMessageListener iCI = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIVE_COUNT) { // from class: com.baidu.tieba.frs.FrsFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                FrsFragment.this.iBN.At(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    };
    private CustomMessageListener iCJ = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_LIVE_START) { // from class: com.baidu.tieba.frs.FrsFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && ((Integer) customResponsedMessage.getData()).intValue() == 51 && FrsFragment.this.iAQ != null) {
                com.baidu.tieba.frs.f.l.a(FrsFragment.this.iAQ, FrsFragment.this.getPageContext());
            }
        }
    };
    private final CustomMessageListener iCK = new CustomMessageListener(CmdConfigCustom.CMD_FRS_SELECT_ALA_LIVE_TAB) { // from class: com.baidu.tieba.frs.FrsFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                FrsFragment.this.iBN.sW(49);
            }
        }
    };
    private final CustomMessageListener iCL = new CustomMessageListener(2921470) { // from class: com.baidu.tieba.frs.FrsFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                FrsFragment.this.iBN.sW(1);
                FrsFragment.this.cwc();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
            }
        }
    };
    private final CustomMessageListener iCM = new CustomMessageListener(CmdConfigCustom.CMD_FRS_EXPERIENCE_TIP) { // from class: com.baidu.tieba.frs.FrsFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.v) && FrsFragment.this.iAQ != null) {
                FrsFragment.this.iAQ.updateLikeData((com.baidu.tieba.tbadkCore.v) customResponsedMessage.getData());
                FrsFragment.this.iBM.i(FrsFragment.this.iAQ);
                FrsFragment.this.iBN.a(FrsFragment.this.iAQ, FrsFragment.this.iBL.cBQ());
            }
        }
    };
    private final AntiHelper.a iCN = new AntiHelper.a() { // from class: com.baidu.tieba.frs.FrsFragment.8
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).aj("obj_locate", ax.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).aj("obj_locate", ax.a.LOCATE_LIKE_PERSON));
        }
    };
    private CustomMessageListener iCO = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.FrsFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(FrsFragment.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().eYM != null) {
                        if (AntiHelper.a(FrsFragment.this.getActivity(), updateAttentionMessage.getData().eYM, FrsFragment.this.iCN) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).aj("obj_locate", ax.a.LOCATE_LIKE_PERSON));
                        }
                    } else if (updateAttentionMessage.getData().isSucc && updateAttentionMessage.getData().isAttention) {
                        com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getPageContext().getPageActivity(), R.string.attention_success);
                    }
                }
            }
        }
    };
    private CustomMessageListener iCP = new CustomMessageListener(CmdConfigCustom.CMD_GET_ENSURE_CAST_ID) { // from class: com.baidu.tieba.frs.FrsFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsFragment.this.refresh();
        }
    };
    private CustomMessageListener iCQ = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.frs.FrsFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && !((PostWriteCallBackData) customResponsedMessage.getData()).isDyamicCallback()) {
                FrsFragment.this.iBs.c((PostWriteCallBackData) customResponsedMessage.getData());
                if (((PostWriteCallBackData) customResponsedMessage.getData()).getGeneralTabId() >= 0) {
                    FrsFragment.this.iBY.zL(((PostWriteCallBackData) customResponsedMessage.getData()).getGeneralTabId());
                }
            }
        }
    };
    private CustomMessageListener iCR = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_REMIND) { // from class: com.baidu.tieba.frs.FrsFragment.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626) {
                NewsRemindMessage newsRemindMessage = (NewsRemindMessage) customResponsedMessage;
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (FrsFragment.this.iBs != null) {
                    FrsFragment.this.iBs.P(notificationCount, z);
                }
            }
        }
    };
    private HttpMessageListener iCS = new HttpMessageListener(CmdConfigHttp.CMD_FRS_MOVE_AREA) { // from class: com.baidu.tieba.frs.FrsFragment.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int i;
            int i2 = 0;
            if (httpResponsedMessage != null && FrsFragment.this.getContext() != null && FrsFragment.this.iBs != null) {
                if (httpResponsedMessage.getError() == 0) {
                    new BdTopToast(FrsFragment.this.getContext()).yb(true).Uc(FrsFragment.this.getContext().getString(R.string.frs_move_area_move_suc)).aH(FrsFragment.this.iBs.chy());
                    if (com.baidu.tieba.frs.a.cuE().ym(com.baidu.tieba.frs.a.cuE().cuG())) {
                        FrsCommonTabFragment frsCommonTabFragment = null;
                        if (FrsFragment.this.iBN != null && FrsFragment.this.iBN.cDR() != null && (FrsFragment.this.iBN.cDR().fragment instanceof FrsCommonTabFragment)) {
                            frsCommonTabFragment = (FrsCommonTabFragment) FrsFragment.this.iBN.cDR().fragment;
                        }
                        if (frsCommonTabFragment != null) {
                            frsCommonTabFragment.cyQ();
                        }
                        FrsFragment.this.cuJ();
                        com.baidu.tieba.frs.a.cuE().cuJ();
                        Iterator<com.baidu.adp.widget.ListView.q> it = FrsFragment.this.iAQ.getThreadList().iterator();
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
                            FrsFragment.this.bMi();
                        }
                    }
                    com.baidu.tieba.frs.a.cuE().reset();
                    return;
                }
                new BdTopToast(FrsFragment.this.getContext()).yb(false).Uc(httpResponsedMessage.getErrorString()).aH(FrsFragment.this.iBs.chy());
            }
        }
    };
    private final CustomMessageListener iCT = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.frs.FrsFragment.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.isResumed()) {
                FrsFragment.this.cwy();
            }
        }
    };
    private CustomMessageListener iCU = new CustomMessageListener(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER) { // from class: com.baidu.tieba.frs.FrsFragment.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (FrsFragment.this.iBs != null) {
                    FrsFragment.this.iBs.setExpanded(booleanValue);
                }
            }
        }
    };
    private final CustomMessageListener iCV = new CustomMessageListener(2921463) { // from class: com.baidu.tieba.frs.FrsFragment.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TbadkApplication.getInst().getCurrentActivity() != null && !com.baidu.tbadk.core.util.at.isEmpty(str) && str.equals(FrsFragment.this.forumId)) {
                    com.baidu.tieba.frs.f.g.b(((TbPageContextSupport) TbadkApplication.getInst().getCurrentActivity()).getPageContext(), FrsFragment.this.iAQ);
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.r iCW = new com.baidu.tieba.tbadkCore.r() { // from class: com.baidu.tieba.frs.FrsFragment.18
        private long startTime = 0;

        @Override // com.baidu.tieba.tbadkCore.r
        public void yt(int i) {
            this.startTime = System.nanoTime();
            if (FrsFragment.this.iBs != null) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsFragment.this.iBs.cwW();
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
            if (FrsFragment.this.ggt) {
                FrsFragment.this.ggt = false;
                com.baidu.tieba.frs.f.j.a(FrsFragment.this.iBs, FrsFragment.this.iAQ, FrsFragment.this.getForumId(), false, null);
            }
            FrsFragment.this.cvN();
            FrsFragment.this.iBD = true;
            if (fVar != null && fVar.isSuccess) {
                FrsFragment.this.iBs.cxj().pS(com.baidu.tbadk.core.util.au.boO().boP());
                FrsFragment.iBz = 0L;
                FrsFragment.iBA = 0L;
                FrsFragment.mNetError = 0;
            } else {
                FrsFragment.mNetError = 1;
            }
            if (!FrsFragment.this.iBL.cBV() && (i == 3 || i == 6)) {
                FrsFragment.this.iBW.resetData();
            }
            FrsFragment.this.iBx = System.currentTimeMillis();
            if (FrsFragment.this.iBL.cBm() != null) {
                FrsFragment.this.iAQ = FrsFragment.this.iBL.cBm();
            }
            FrsFragment.this.yp(1);
            FrsFragment.this.cvV();
            if (i == 7) {
                FrsFragment.this.yq(FrsFragment.this.iAQ.getFrsDefaultTabId());
                return;
            }
            if (FrsFragment.this.iAQ.getPage() != null) {
                FrsFragment.this.setHasMore(FrsFragment.this.iAQ.getPage().biQ());
            }
            if (i == 4) {
                if (!FrsFragment.this.iBL.cBV() && TbadkCoreApplication.getInst().isRecAppExist() && FrsFragment.this.iBL.cBL() == 1) {
                    FrsFragment.this.iAQ.addRecommendAppToThreadList(FrsFragment.this);
                }
                ArrayList<com.baidu.adp.widget.ListView.q> a2 = FrsFragment.this.iBW.a(false, false, FrsFragment.this.iAQ.getThreadList(), FrsFragment.this.iBo, false);
                if (a2 != null) {
                    FrsFragment.this.iAQ.setThreadList(a2);
                    FrsFragment.this.iAQ.checkLiveStageInThreadList();
                }
                if (FrsFragment.this.iBL != null) {
                    com.baidu.tieba.frs.d.c.a(FrsFragment.this.iAQ, FrsFragment.this.iBL.cBQ(), 2, FrsFragment.this.getContext());
                }
                com.baidu.tieba.frs.f.a.a(FrsFragment.this, FrsFragment.this.iAQ.getForum(), FrsFragment.this.iAQ.getThreadList(), false, FrsFragment.this.getPn());
                FrsFragment.this.iBs.a(a2, FrsFragment.this.iAQ);
                FrsFragment.this.cvO();
                return;
            }
            FrsFragment.this.cvO();
            switch (i) {
                case 1:
                    FrsFragment.this.iBs.cwW();
                    break;
                case 2:
                    FrsFragment.this.iBs.cwW();
                    break;
                case 3:
                case 6:
                    if (FrsFragment.this.iAQ != null) {
                        FrsFragment.this.iAQ.clearPostThreadCount();
                    }
                    if (FrsFragment.this.iCb != null) {
                        FrsFragment.this.iCb.refresh();
                        break;
                    }
                    break;
            }
            FrsFragment.this.cvW();
            if (fVar == null || fVar.errorCode == 0) {
                if (FrsFragment.this.iAQ != null) {
                    FrsFragment.this.a(FrsFragment.this.iAQ);
                    FrsFragment.this.X(false, i == 5);
                    if (FrsFragment.this.iBL != null) {
                        if (FrsFragment.this.iAQ.getActivityHeadData() != null && FrsFragment.this.iAQ.getActivityHeadData().bie() != null && FrsFragment.this.iAQ.getActivityHeadData().bie().size() > 0) {
                            com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), 1, FrsFragment.this.iAQ.getForum(), FrsFragment.this.iBL.getSortType(), 1);
                        }
                        if (FrsFragment.this.iAQ.getThreadList() != null && FrsFragment.this.iAQ.getThreadList().size() > 0) {
                            Iterator<com.baidu.adp.widget.ListView.q> it = FrsFragment.this.iAQ.getThreadList().iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    com.baidu.adp.widget.ListView.q next = it.next();
                                    if ((next instanceof bw) && ((bw) next).getType() == bw.ezL) {
                                        com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), 1, FrsFragment.this.iAQ.getForum(), FrsFragment.this.iBL.getSortType(), 2);
                                    }
                                }
                            }
                        }
                        com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), FrsFragment.this.iAQ.getThreadList(), FrsFragment.this.iAQ.getForum(), FrsFragment.this.iBL.getSortType());
                    }
                    FrsFragment.this.iBs.yG(i);
                    FrsFragment.iBz = (System.nanoTime() - this.startTime) / TimeUtils.NANOS_PER_MS;
                    if (fVar != null) {
                        FrsFragment.iBA = fVar.mOA;
                    }
                } else {
                    return;
                }
            } else if (FrsFragment.this.iAQ == null || com.baidu.tbadk.core.util.y.isEmpty(FrsFragment.this.iAQ.getThreadList())) {
                FrsFragment.this.a(fVar);
            } else if (fVar.ilp) {
                FrsFragment.this.showToast(FrsFragment.this.getPageContext().getResources().getString(R.string.net_error_text, fVar.errorMsg, Integer.valueOf(fVar.errorCode)));
            }
            FrsFragment.this.cvS();
            FrsFragment.this.cvT();
            if (FrsFragment.this.iAQ.getAccessFlag() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11384"));
            }
            if (FrsFragment.this.iBp && FrsFragment.this.iBN.sW(49)) {
                FrsFragment.this.iBp = false;
            }
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.r
        public void c(com.baidu.tieba.tbadkCore.m mVar) {
            if ((mVar != null && ("normal_page".equals(FrsFragment.this.iBL.getPageType()) || "frs_page".equals(FrsFragment.this.iBL.getPageType()) || "book_page".equals(FrsFragment.this.iBL.getPageType()))) || "brand_page".equals(FrsFragment.this.iBL.getPageType())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE, mVar));
                FrsFragment.this.b(mVar);
                FrsFragment.iBw = mVar;
            }
        }

        @Override // com.baidu.tieba.tbadkCore.r
        public void cvY() {
            FrsFragment.this.cvY();
        }
    };
    private final CustomMessageListener iCX = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.frs.FrsFragment.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.m) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                FrsFragment.this.iAQ.updateCurrentUserPendant((com.baidu.tbadk.data.m) customResponsedMessage.getData());
                FrsFragment.this.iBs.cxj().notifyDataSetChanged();
            }
        }
    };
    private final CustomMessageListener mMemListener = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_MEM) { // from class: com.baidu.tieba.frs.FrsFragment.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && FrsFragment.this.iAQ != null && (userData = FrsFragment.this.iAQ.getUserData()) != null) {
                userData.setIsMem(num.intValue());
                if (num.intValue() != 0) {
                    FrsFragment.this.iBM.o(num);
                }
            }
        }
    };
    private final f.a iCY = new AnonymousClass29();
    private final com.baidu.tieba.frs.mc.k iCZ = new com.baidu.tieba.frs.mc.k() { // from class: com.baidu.tieba.frs.FrsFragment.30
        @Override // com.baidu.tieba.frs.mc.k
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, boolean z3) {
            if (FrsFragment.this.iBP != null && FrsFragment.this.iBL != null && FrsFragment.this.iBL.cBV() && z && !z2 && !z3) {
                FrsFragment.this.iBP.zQ(i2);
            }
        }
    };
    public final View.OnTouchListener ftj = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.FrsFragment.31
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (FrsFragment.this.iCd != null) {
                FrsFragment.this.iCd.onTouch(view, motionEvent);
            }
            if (FrsFragment.this.iBR != null && FrsFragment.this.iBR.cxX() != null) {
                FrsFragment.this.iBR.cxX().onTouchEvent(motionEvent);
            }
            if (FrsFragment.this.gxx != null) {
                FrsFragment.this.gxx.b(view, motionEvent);
            }
            if (FrsFragment.this.iBM != null) {
                FrsFragment.this.iBM.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private final CustomMessageListener iDa = new CustomMessageListener(CmdConfigCustom.CMD_GOTOLIVE_HOST_UPGRADE) { // from class: com.baidu.tieba.frs.FrsFragment.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.bnH().getInt(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.PHOTOLIVE_HOSTLEVEL, -1) != -1 && FrsFragment.this.iAQ.getForum() != null) {
                FrsFragment.this.iAQ.getForum().setCanAddPhotoLivePost(true);
            }
        }
    };
    public final View.OnClickListener iDb = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.38
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsFragment.this.iBs != null && view == FrsFragment.this.iBs.cwU() && FrsFragment.this.getActivity() != null) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, FrsFragment.this.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            if (view.getId() == R.id.game_activity_egg_layout && com.baidu.adp.lib.util.l.isNetOk()) {
                TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_CLICK);
                if (FrsFragment.this.iBs == null || !FrsFragment.this.iBs.cxg()) {
                    String activityUrl = FrsFragment.this.iAQ.getForum().getYuleData().bmu().getActivityUrl();
                    if (!StringUtils.isNull(activityUrl)) {
                        com.baidu.tbadk.browser.a.startInternalWebActivity(FrsFragment.this.getPageContext().getPageActivity(), activityUrl);
                    }
                } else {
                    FrsFragment.this.iBs.cxh();
                }
            }
            if (FrsFragment.this.iBs != null && view == FrsFragment.this.iBs.cxn() && FrsFragment.this.iBL != null && FrsFragment.this.iBL.hasMore()) {
                FrsFragment.this.iBs.TI();
                FrsFragment.this.bMi();
            }
            if (view != null && FrsFragment.this.iBs != null && view == FrsFragment.this.iBs.cxd()) {
                if (com.baidu.tbadk.core.util.bg.checkUpIsLogin(FrsFragment.this.getContext())) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).aj("obj_locate", 2));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MessageCenterActivityConfig(FrsFragment.this.getContext())));
                } else {
                    return;
                }
            }
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (FrsFragment.this.iAQ != null && FrsFragment.this.iAQ.getForum() != null) {
                    if (FrsFragment.this.iBs != null && view == FrsFragment.this.iBs.cxb()) {
                        if (FrsFragment.this.iAQ != null && FrsFragment.this.iAQ.getForum() != null && !StringUtils.isNull(FrsFragment.this.iAQ.getForum().getId()) && !StringUtils.isNull(FrsFragment.this.iAQ.getForum().getName())) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_SHARE_CLICK).dR("fid", FrsFragment.this.iAQ.getForum().getId()).aj("obj_locate", 11));
                            com.baidu.tieba.frs.f.g.a(FrsFragment.this.getPageContext(), FrsFragment.this.iAQ, FrsFragment.this.iAQ.getForum().getId());
                        } else {
                            return;
                        }
                    }
                    if (FrsFragment.this.iBs != null && view == FrsFragment.this.iBs.cxa()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12402").dR("fid", FrsFragment.this.iAQ.getForum().getId()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fname", FrsFragment.this.iAQ.getForum().getName()));
                        if (!StringUtils.isNull(FrsFragment.this.iAQ.getForum().getName())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PostSearchActivityConfig(FrsFragment.this.getContext(), FrsFragment.this.iAQ.getForum().getName(), FrsFragment.this.iAQ.getForum().getId())));
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
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.FrsFragment.39
        private int iDz = 0;
        private int gch = 0;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsFragment.this.iCq += i2;
            if (FrsFragment.this.iCq >= FrsFragment.this.dDO * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
            if (FrsFragment.this.iBU != null) {
                FrsFragment.this.iBU.cCN();
            }
            this.iDz = 0;
            this.gch = 0;
            if (recyclerView != null && (recyclerView instanceof BdRecyclerView)) {
                this.iDz = ((BdRecyclerView) recyclerView).getFirstVisiblePosition();
                this.gch = ((BdRecyclerView) recyclerView).getLastVisiblePosition();
            }
            if (FrsFragment.this.iCf != null) {
                FrsFragment.this.iCf.a(recyclerView, this.iDz, this.gch);
            }
            if (FrsFragment.this.iAQ != null && FrsFragment.this.iBs != null && FrsFragment.this.iBs.cxj() != null) {
                FrsFragment.this.iBs.cm(this.iDz, this.gch);
                if (FrsFragment.this.iBK != null && FrsFragment.this.iBK.tW() != null) {
                    FrsFragment.this.iBK.tW().b(FrsFragment.this.iBJ);
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (FrsFragment.this.iBM != null) {
                FrsFragment.this.iBM.setScrollState(i);
            }
            if ((i == 2 || i == 1) && !FrsFragment.this.iBE) {
                FrsFragment.this.iBE = true;
                FrsFragment.this.iBs.cxl();
            }
            if (FrsFragment.this.iBF == null && !FrsFragment.this.cwr()) {
                FrsFragment.this.iBF = new com.baidu.tbadk.n.b();
                FrsFragment.this.iBF.setSubType(1000);
            }
            if (i == 0) {
                if (FrsFragment.this.iBF != null) {
                    FrsFragment.this.iBF.bzM();
                }
                com.baidu.tieba.card.t.clQ().op(true);
                FrsFragment.this.pi(true);
                FrsFragment.this.iBs.cl(this.iDz, this.gch);
            } else if (FrsFragment.this.iBF != null) {
                FrsFragment.this.iBF.bzL();
            }
            if (FrsFragment.this.iCf != null) {
                FrsFragment.this.iCf.onScrollStateChanged(recyclerView, i);
            }
            if (i == 0) {
                com.baidu.tieba.frs.f.j.a(FrsFragment.this.iBs, FrsFragment.this.iAQ, FrsFragment.this.getForumId(), false, null);
            }
            if (FrsFragment.this.iBN != null && i == 1) {
                FrsFragment.this.iBN.cDT();
            }
            if (FrsFragment.this.iBK == null) {
                if (FrsFragment.this.iBs.cwN() != null && !FrsFragment.this.iBs.cwp() && FrsFragment.this.iBs.cwN().duu() != null && (FrsFragment.this.iBs.cwN().duu().getTag() instanceof com.baidu.card.am)) {
                    FrsFragment.this.iBK = (com.baidu.card.am) FrsFragment.this.iBs.cwN().duu().getTag();
                }
            } else if (i == 0 && FrsFragment.this.iBs.cwN() != null && !FrsFragment.this.iBs.cwp() && FrsFragment.this.iBs.cwN().duu() != null && (FrsFragment.this.iBs.cwN().duu().getTag() instanceof com.baidu.card.am)) {
                FrsFragment.this.iBK = (com.baidu.card.am) FrsFragment.this.iBs.cwN().duu().getTag();
            }
            if (i == 1) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921418));
            }
        }
    };
    private final f iDc = new f() { // from class: com.baidu.tieba.frs.FrsFragment.40
        @Override // com.baidu.tieba.frs.f
        public void a(int i, int i2, View view, View view2, bw bwVar) {
            if (i != FrsFragment.this.iBs.cxj().czC()) {
                if (i != FrsFragment.this.iBs.cxj().czD()) {
                    if (i == FrsFragment.this.iBs.cxj().czA() && FrsFragment.this.iAQ != null && FrsFragment.this.iAQ.getUserData() != null && FrsFragment.this.iAQ.getUserData().isBawu()) {
                        String bawuCenterUrl = FrsFragment.this.iAQ.getBawuCenterUrl();
                        if (!com.baidu.tbadk.core.util.at.isEmpty(bawuCenterUrl) && FrsFragment.this.iAQ.getForum() != null) {
                            com.baidu.tbadk.browser.a.startWebActivity(FrsFragment.this.getPageContext().getPageActivity(), bawuCenterUrl);
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10502").dR("fid", FrsFragment.this.iAQ.getForum().getId()).dR("uid", FrsFragment.this.iAQ.getUserData().getUserId()));
                        }
                    }
                } else if (com.baidu.tbadk.core.util.bg.checkUpIsLogin(FrsFragment.this.getPageContext().getPageActivity())) {
                    TiebaStatic.log(CommonStatisticKey.MY_SERVICE_CK);
                    if (FrsFragment.this.iAQ != null && FrsFragment.this.iAQ.getForum() != null) {
                        ForumData forum = FrsFragment.this.iAQ.getForum();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(forum.getId(), 0L), forum.getName(), forum.getImage_url(), 0)));
                    }
                }
            } else if (com.baidu.tbadk.core.util.bg.checkUpIsLogin(FrsFragment.this.getActivity())) {
                TiebaStatic.log("forum_fortune_click");
                com.baidu.tieba.frs.f.k.c(FrsFragment.this.getPageContext(), FrsFragment.this.iAQ);
            }
        }
    };
    private final NoNetworkView.a iyC = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.FrsFragment.41
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (FrsFragment.this.iBL.cBL() == 1 && z && !FrsFragment.this.iBs.cwp()) {
                if (FrsFragment.this.iAQ == null || com.baidu.tbadk.core.util.y.isEmpty(FrsFragment.this.iAQ.getThreadList())) {
                    FrsFragment.this.hideNetRefreshView(FrsFragment.this.iBs.cxy().cDH());
                    FrsFragment.this.showLoadingView(FrsFragment.this.iBs.chy(), true);
                    FrsFragment.this.iBs.ps(false);
                    FrsFragment.this.refresh();
                    return;
                }
                FrsFragment.this.iBs.cwW();
            }
        }
    };
    private final CustomMessageListener eZe = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.FrsFragment.42
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                com.baidu.tieba.frs.f.c.a(customResponsedMessage, FrsFragment.this.iBs, FrsFragment.this.iAQ);
            }
        }
    };
    private com.baidu.adp.widget.ListView.ab iDd = new a();
    private av iDe = new av() { // from class: com.baidu.tieba.frs.FrsFragment.44
        @Override // com.baidu.tieba.frs.av
        public void a(int i, int i2, bd bdVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
            com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.44.1
                @Override // java.lang.Runnable
                public void run() {
                    if (FrsFragment.this.iBs != null && FrsFragment.this.iBs.cxq()) {
                        FrsFragment.this.bMi();
                    }
                }
            });
        }
    };
    private CustomMessageListener iDf = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.frs.FrsFragment.46
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    FrsFragment.this.iCg = true;
                }
            }
        }
    };
    private CustomMessageListener iDg = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.frs.FrsFragment.47
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                    if (FrsFragment.this.iBK == null && FrsFragment.this.iBs.cwN() != null && !FrsFragment.this.iBs.cwp() && FrsFragment.this.iBs.cwN().duu() != null && (FrsFragment.this.iBs.cwN().duu().getTag() instanceof com.baidu.card.am)) {
                        FrsFragment.this.iBK = (com.baidu.card.am) FrsFragment.this.iBs.cwN().duu().getTag();
                    }
                    if (FrsFragment.this.iBK != null && FrsFragment.this.iBK.tW() != null) {
                        FrsFragment.this.iBK.tW().b(new a.C0097a(3));
                    }
                }
            }
        }
    };
    private CustomMessageListener iDh = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.FrsFragment.48
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.iBs != null) {
                FrsFragment.this.iBs.Gh();
            }
        }
    };
    private CustomMessageListener iDi = new CustomMessageListener(2921437) { // from class: com.baidu.tieba.frs.FrsFragment.49
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && FrsFragment.this.isResumed()) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (FrsFragment.this.iBu != null) {
                    if (booleanValue) {
                        if (FrsFragment.this.iBN.cDU() != 0 && !FrsFragment.this.iBs.cxv() && !KuangFloatingFrsCopyLinkViewController.getInstance().isFloatCopyViewShow()) {
                            FrsFragment.this.iBu.show();
                            return;
                        }
                        return;
                    }
                    FrsFragment.this.iBu.hide();
                }
            }
        }
    };
    private CustomMessageListener iDj = new CustomMessageListener(2921462) { // from class: com.baidu.tieba.frs.FrsFragment.54
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && FrsFragment.this.iAQ.getToLoadHorseData().intValue() == 1 && FrsFragment.this.mIsLogin) {
                LiveHorseRaceRequestMessage liveHorseRaceRequestMessage = new LiveHorseRaceRequestMessage();
                liveHorseRaceRequestMessage.setForum_id(Long.valueOf(FrsFragment.this.forumId));
                FrsFragment.this.sendMessage(liveHorseRaceRequestMessage);
            }
        }
    };
    private CustomMessageListener iDk = new CustomMessageListener(2001223) { // from class: com.baidu.tieba.frs.FrsFragment.55
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Date)) {
                FrsFragment.this.iCp = (Date) customResponsedMessage.getData();
            }
        }
    };
    private CustomMessageListener iDl = new CustomMessageListener(2921469) { // from class: com.baidu.tieba.frs.FrsFragment.57
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.x) && FrsFragment.this.isResumed()) {
                com.baidu.tbadk.core.data.x xVar = (com.baidu.tbadk.core.data.x) customResponsedMessage.getData();
                if (FrsFragment.this.iCw == null) {
                    FrsFragment.this.iCw = new com.baidu.tieba.frs.broadcast.a(FrsFragment.this.getPageContext());
                }
                if (FrsFragment.this.iAQ != null && FrsFragment.this.iAQ.getForum() != null && !TextUtils.isEmpty(FrsFragment.this.iAQ.getForum().getId())) {
                    FrsFragment.this.iCw.e(xVar.type, FrsFragment.this.iAQ.getForum().getId(), FrsFragment.this.iAQ.getForum().getName(), xVar.tid);
                }
            }
        }
    };
    private CustomMessageListener iDm = new CustomMessageListener(2921475) { // from class: com.baidu.tieba.frs.FrsFragment.58
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bw bwVar = (bw) customResponsedMessage.getData();
            if (bwVar != null && FrsFragment.this.isResumed()) {
                FrsFragment.this.iBI = bwVar.getTid() + "";
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE_NUMBER);
                httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
                httpMessage.addParam("forum_id", bwVar.getFid());
                MessageManager.getInstance().sendMessage(httpMessage);
            }
        }
    };
    private HttpMessageListener iDn = new HttpMessageListener(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE_NUMBER) { // from class: com.baidu.tieba.frs.FrsFragment.59
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if ((httpResponsedMessage instanceof ForumManagerRightsResMsg) && FrsFragment.this.isResumed()) {
                ForumManagerRightsResMsg forumManagerRightsResMsg = (ForumManagerRightsResMsg) httpResponsedMessage;
                if (forumManagerRightsResMsg.broadcastTotalCount - forumManagerRightsResMsg.broadcastUsedCount <= 0) {
                    new ScreenTopToast(FrsFragment.this.getContext()).Ug(FrsFragment.this.getString(R.string.frs_forum_bawu_send_broadcast_none_tip)).Ui(FrsFragment.this.getString(R.string.frs_recommend_fail_tip_btn)).ak(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.59.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("_forumId", FrsFragment.this.iAQ.getForum().getId());
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new com.baidu.tieba.tbadkCore.data.m(FrsFragment.this.getContext(), "ForumGradePage", hashMap)));
                        }
                    }).aH((ViewGroup) FrsFragment.this.mRootView.findViewById(R.id.frs));
                    return;
                }
                com.baidu.tbadk.core.util.o oVar = new com.baidu.tbadk.core.util.o(TbadkCoreApplication.getInst());
                oVar.aj(FrsFragment.this.iAQ.getForum().getId(), FrsFragment.this.iAQ.getForum().getName(), "6");
                oVar.Bw(FrsFragment.this.iBI);
                oVar.start();
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.frs.loadmore.a
    public /* bridge */ /* synthetic */ com.baidu.adp.base.e getPageContext() {
        return super.getPageContext();
    }

    public com.baidu.tieba.frs.entelechy.b.b cvB() {
        return this.iBT;
    }

    public com.baidu.adp.widget.ListView.ab cvC() {
        return this.iDd;
    }

    public com.baidu.tieba.frs.mc.d cvD() {
        return this.iBV;
    }

    public com.baidu.tieba.frs.smartsort.a cvE() {
        return this.iBP;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public FrsModelController cvF() {
        return this.iBL;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public com.baidu.tieba.frs.mc.c cvG() {
        return this.iBW;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public com.baidu.tieba.frs.vc.h cvH() {
        return this.iBM;
    }

    public FrsTabViewController cvI() {
        return this.iBN;
    }

    public ax cvJ() {
        return this.iBR;
    }

    public void ph(boolean z) {
        this.iCo = z;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public q cvK() {
        return this.iBs;
    }

    @Override // com.baidu.tieba.frs.aw
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.aw, com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.iBk;
    }

    public void setForumName(String str) {
        this.iBk = str;
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
        if (this.iBW == null) {
            return 1;
        }
        return this.iBW.getPn();
    }

    public int getPn() {
        if (this.iBW == null) {
            return 1;
        }
        return this.iBW.getPn();
    }

    public void setPn(int i) {
        if (this.iBW != null) {
            this.iBW.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.iBW != null) {
            this.iBW.setHasMore(i);
        }
    }

    public int cvL() {
        if (this.iBW == null) {
            return -1;
        }
        return this.iBW.cvL();
    }

    public boolean cvM() {
        return this.iBq;
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
            this.iBs.cwQ();
            showNetRefreshView(this.iBs.chy(), string, true);
        } else if (340001 == fVar.errorCode) {
            a(fVar, this.iAQ.getRecm_forum_list());
        } else {
            if (com.baidu.tbadk.core.util.y.isEmpty(this.iAQ.getThreadList())) {
                b(fVar);
            }
            if (cwr()) {
                setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds280));
            } else {
                setNetRefreshViewEmotionDefMarginTop();
            }
        }
    }

    public void a(View view, String str, boolean z, List<RecmForumInfo> list) {
        this.iBs.cwQ();
        this.iBs.yA(8);
        if (this.iCe == null) {
            this.iCe = new com.baidu.tieba.frs.view.a(getPageContext(), getNetRefreshListener());
        }
        this.iCe.setSubText(str);
        this.iCe.setListData(list);
        this.iCe.attachView(view, z);
    }

    private void a(com.baidu.tieba.tbadkCore.f fVar, List<RecmForumInfo> list) {
        if (this.iBs != null) {
            this.iBs.cwQ();
            this.iBs.setTitle(this.iBk);
            a(this.iBs.chy(), fVar.errorMsg, true, list);
        }
    }

    private void b(com.baidu.tieba.tbadkCore.f fVar) {
        this.iBs.cwQ();
        if (fVar.ilp) {
            showNetRefreshView(this.iBs.chy(), TbadkCoreApplication.getInst().getString(R.string.net_error_text, new Object[]{fVar.errorMsg, Integer.valueOf(fVar.errorCode)}), true);
        } else {
            showNetRefreshView(this.iBs.cxy().cDH(), fVar.errorMsg, true);
        }
    }

    public void cvN() {
        hideLoadingView(this.iBs.chy());
        this.iBs.bMH();
        if (this.iBs.cwO() instanceof com.baidu.tieba.frs.tab.c) {
            ((com.baidu.tieba.frs.tab.c) this.iBs.cwO()).cCs();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cvO() {
        if (cvL() == 0 && com.baidu.tbadk.core.util.y.isEmpty(this.iAQ.getThreadListIds())) {
            if (com.baidu.tbadk.core.util.y.isEmpty(this.iAQ.getThreadList())) {
                this.iBs.bNw();
            } else {
                this.iBs.TJ();
            }
        } else if (com.baidu.tbadk.core.util.y.getCount(this.iAQ.getThreadList()) > 3) {
            this.iBs.TI();
        } else {
            this.iBs.cxm();
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
            cvN();
            this.iBs.cwW();
            com.baidu.tieba.tbadkCore.f cBH = this.iBL.cBH();
            boolean isEmpty = com.baidu.tbadk.core.util.y.isEmpty(this.iAQ.getThreadList());
            if (cBH != null && isEmpty) {
                if (this.iBL.cBJ() != 0) {
                    this.iBL.cBO();
                    this.iBs.cwW();
                } else {
                    a(cBH);
                }
                this.iBs.Y(this.iAQ.isStarForum(), false);
                return;
            }
            a(cBH);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(com.baidu.tieba.tbadkCore.m mVar) {
        if (mVar != null && mVar.getEntelechyTabInfo() != null && mVar.getEntelechyTabInfo().tab != null) {
            for (FrsTabInfo frsTabInfo : mVar.getEntelechyTabInfo().tab) {
                if (frsTabInfo.tab_id.intValue() == 502 && com.baidu.tbadk.core.sharedPref.b.bnH().getBoolean("first_into_tab_profession", true)) {
                    return false;
                }
            }
        }
        return new com.baidu.tieba.frs.ad.f(getTbPageContext()).d(mVar);
    }

    public boolean cvP() {
        return cvQ() && !cvR();
    }

    private boolean cvQ() {
        if (cwo() == null) {
            return false;
        }
        FrsViewData cwo = cwo();
        com.baidu.tbadk.core.data.y yVar = null;
        if (cwo.getStar() != null && !StringUtils.isNull(cwo.getStar().dGK())) {
            yVar = new com.baidu.tbadk.core.data.y();
        } else if (cwo.getActivityHeadData() != null && com.baidu.tbadk.core.util.y.getCount(cwo.getActivityHeadData().bie()) >= 1) {
            yVar = cwo.getActivityHeadData().bie().get(0);
        }
        return yVar != null;
    }

    public boolean cvR() {
        if (cwo() == null) {
            return false;
        }
        FrsViewData cwo = cwo();
        return (com.baidu.tbadk.core.util.y.isEmpty(cwo.getShowTopThreadList()) && cwo.getBusinessPromot() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cvS() {
        boolean b;
        if (!cvU()) {
            final PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
            privateForumPopInfoData.a(this.iAQ.getPrivateForumTotalInfo().getPrivatePopInfo());
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(getActivity());
            if (this.iAQ.getPrivateForumTotalInfo().biX().private_forum_status.intValue() == 1 && (com.baidu.tbadk.core.util.at.isEmpty(privateForumPopInfoData.biZ()) || privateForumPopInfoData.bjc() != Integer.valueOf(this.forumId))) {
                privateForumPopInfoData.AD("create_success");
                privateForumPopInfoData.AE(TbadkCoreApplication.getInst().getString(R.string.frs_private_create_hint));
                privateForumPopInfoData.AF("https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.iBk + "&nomenu=1");
                privateForumPopInfoData.k(Integer.valueOf(this.forumId));
                b = frsPrivateCommonDialogView.b(privateForumPopInfoData);
            } else {
                b = privateForumPopInfoData.bjc() == Integer.valueOf(this.forumId) ? frsPrivateCommonDialogView.b(privateForumPopInfoData) : false;
            }
            if (b) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
                aVar.op(2);
                aVar.bb(frsPrivateCommonDialogView);
                aVar.iN(false);
                frsPrivateCommonDialogView.setConfirmButton(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.19
                    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.frs.FrsFragment */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        com.baidu.tbadk.core.util.be.boR().b(FrsFragment.this.getPageContext(), new String[]{privateForumPopInfoData.bjb()});
                        aVar.dismiss();
                    }
                });
                aVar.a(new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.20
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(getPageContext()).bmC();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cvT() {
        if (cvU() || this.iAQ.getPrivateForumTotalInfo().biX().private_forum_status.intValue() != 1) {
            a((Integer) null, (Integer) null, true);
        } else {
            a(this.iAQ.getPrivateForumTotalInfo().biX().private_forum_audit_status, this.iAQ.getPrivateForumTotalInfo().biY(), false);
        }
    }

    public void a(Integer num, Integer num2, boolean z) {
        final String str;
        final int i = 2;
        if (this.iBs.cxc() != null) {
            TextView cxc = this.iBs.cxc();
            if (z) {
                cxc.setVisibility(8);
                return;
            }
            if (num.intValue() == 2) {
                cxc.setText("修改实名认证信息");
                cxc.setVisibility(0);
                str = "https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + this.forumId + "&nomenu=1";
            } else if (num2.intValue() >= 0 && num2.intValue() <= 100) {
                cxc.setText("目标已完成" + String.valueOf(num2) + "%");
                cxc.setVisibility(0);
                str = "https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.iBk + "&nomenu=1";
                i = 1;
            } else {
                cxc.setVisibility(8);
                i = 0;
                str = "";
            }
            cxc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.21
                /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13387").dR("fid", FrsFragment.this.forumId).dR("uid", TbadkCoreApplication.getCurrentAccount()).aj("obj_type", i));
                    com.baidu.tbadk.core.util.be.boR().b(FrsFragment.this.getPageContext(), new String[]{str});
                }
            });
        }
    }

    private boolean cvU() {
        return this.iAQ == null || this.iAQ.getPrivateForumTotalInfo() == null || this.iAQ.getPrivateForumTotalInfo().biX() == null || this.iAQ.getUserData().getIs_manager() != 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yp(int i) {
        List<WindowToast> list;
        if (TbadkCoreApplication.isLogin() && this.iAQ != null && (list = this.iAQ.mWindowToast) != null && list.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < list.size()) {
                    WindowToast windowToast = list.get(i3);
                    if (windowToast == null || windowToast.toast_type.intValue() != i) {
                        i2 = i3 + 1;
                    } else if (!com.baidu.tbadk.core.util.at.isEmpty(windowToast.toast_link)) {
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
    public void cvV() {
        if (getActivity() != null && getActivity().getIntent() != null) {
            String stringExtra = getActivity().getIntent().getStringExtra(FrsActivityConfig.KEY_ACHIEVEMENT_URL);
            if (!TextUtils.isEmpty(stringExtra)) {
                getActivity().getIntent().removeExtra(FrsActivityConfig.KEY_ACHIEVEMENT_URL);
                AchievementActivityConfig achievementActivityConfig = new AchievementActivityConfig(getActivity());
                achievementActivityConfig.setUrl(stringExtra);
                if (this.iAQ != null && this.iAQ.getForumActiveInfo() != null) {
                    achievementActivityConfig.setShareUrl(this.iAQ.getForumActiveInfo().forum_share_url);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, achievementActivityConfig));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cvW() {
        if (this.iAQ == null || this.iAQ.getForum() != null) {
            this.iBs.cxi();
        } else if (this.iAQ.getForum().getYuleData() != null && this.iAQ.getForum().getYuleData().bmt()) {
            TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_VIEW);
            this.iBs.a(this.iAQ.getForum().getYuleData().bmu());
        } else {
            this.iBs.cxi();
        }
    }

    private void W(boolean z, boolean z2) {
        if (this.iBL != null && this.iAQ != null && this.iBs != null && z) {
            if (!this.iBL.cBV() && this.iBL.cBL() == 1) {
                if (!this.iBL.cBT()) {
                    this.iAQ.addCardVideoInfoToThreadList();
                    this.iAQ.addVideoInfoToThreadListInTenAndFifteenFloor();
                }
                boolean z3 = false;
                if (this.iBs.cxj().r(com.baidu.tieba.card.data.o.hVV)) {
                    z3 = this.iAQ.addHotTopicDataToThreadList();
                }
                if (!z3) {
                    this.iAQ.addFeedForumDataToThreadList();
                }
                if (TbadkCoreApplication.getInst().isRecAppExist()) {
                    this.iAQ.addRecommendAppToThreadList(this);
                }
                if (!this.iBs.cxj().r(bw.eyh)) {
                    this.iAQ.removeAlaLiveThreadData();
                }
                this.iAQ.addSchoolRecommendToThreadList();
            }
            if (!this.iBs.cxj().r(bw.eyh)) {
                this.iAQ.removeAlaInsertLiveData();
                this.iAQ.removeAlaStageLiveDat();
            } else {
                this.iAQ.addInsertLiveDataToThreadList();
                this.iAQ.addStageLiveDataToThreadList();
            }
            this.iAQ.checkLiveStageInThreadList();
            this.iAQ.addNoticeThreadToThreadList();
            if (this.iBs.cxj().r(com.baidu.tieba.h.b.jjG)) {
                this.iAQ.addGameRankListToThreadList(z2);
            }
            if (TbadkCoreApplication.isLogin() && (!this.iBL.cBV() || this.iBL.isNetFirstLoad)) {
                this.iAQ.addUserRecommendToThreadList();
            }
            this.iAQ.addVideoActivityToTop();
        }
    }

    public boolean cvX() {
        if (this.iBM != null && this.iBL != null) {
            this.iBM.a(this.iBL.getPageType(), this.iAQ);
        }
        boolean z = false;
        if (this.iAQ != null) {
            z = this.iAQ.hasTab();
        }
        cwa();
        if (this.iBs != null) {
            this.iBs.cxw();
            this.iBs.cxx();
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yq(int i) {
        ba baVar = null;
        cvX();
        cwj();
        try {
            if (this.iAQ != null) {
                this.iBs.a((ArrayList<com.baidu.adp.widget.ListView.q>) null, this.iAQ);
                this.iBM.Aj(1);
                this.iBs.cwZ();
                this.iBN.a(this.iAQ, this.iBL.cBQ());
                com.baidu.tieba.frs.tab.d As = this.iBN.As(this.iAQ.getFrsDefaultTabId());
                if (As != null && !TextUtils.isEmpty(As.url)) {
                    baVar = new ba();
                    baVar.ext = As.url;
                    baVar.stType = As.name;
                }
                this.iBL.a(this.iAQ.getFrsDefaultTabId(), 0, baVar);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(boolean z, boolean z2) {
        try {
            if (this.iAQ != null && this.iBN != null && this.iBL != null) {
                if (!this.iBs.cxj().r(bw.eyh)) {
                    this.iAQ.removeAlaLiveThreadData();
                }
                boolean isEmpty = com.baidu.tbadk.core.util.y.isEmpty(this.iAQ.getGameTabInfo());
                this.iBs.pq(isEmpty);
                if (!isEmpty) {
                    if (this.iCf == null) {
                        this.iCf = new com.baidu.tieba.frs.vc.e(this, (NoPressedRelativeLayout) this.mRootView);
                    }
                    if (this.gxx == null) {
                        this.gxx = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
                    }
                } else {
                    this.iCf = null;
                    this.gxx = null;
                }
                if (this.iAQ.getForum() != null) {
                    this.iBk = this.iAQ.getForum().getName();
                    this.forumId = this.iAQ.getForum().getId();
                }
                if (this.iAQ.hasTab()) {
                    this.iBN.a(this.iAQ, this.iBL.cBQ());
                }
                if (z) {
                    W(true, z);
                } else {
                    W(this.iBG, z);
                }
                cvX();
                if (this.iBT != null) {
                    this.iBT.a(this.iBM, this.iAQ);
                }
                if (this.iAQ.getPage() != null) {
                    setHasMore(this.iAQ.getPage().biQ());
                }
                ArrayList<com.baidu.adp.widget.ListView.q> a2 = this.iBW.a(z2, true, this.iAQ.getThreadList(), null, z, false);
                if (a2 != null) {
                    this.iAQ.setThreadList(a2);
                }
                this.iAQ.removeRedundantUserRecommendData();
                this.iAS = this.iAQ.getTopThreadSize();
                if (this.iBo != null) {
                    this.iBn = true;
                    this.iBo.Jm(this.iAS);
                    com.baidu.tieba.frs.f.a.a(this, this.iAQ.getForum(), this.iAQ.getThreadList(), this.iBn, getPn());
                }
                if (this.iBL.cBL() == 1) {
                    cwe();
                    if (!z && this.iBL.getPn() == 1) {
                        cvZ();
                    }
                }
                if (this.iBU != null) {
                    this.iBU.cD(this.iBN.cDQ());
                }
                cvN();
                this.iBs.cwR();
                this.iBs.Y(true, false);
                if (z && this.iAQ.isFirstTabEqualAllThread()) {
                    com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.22
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!FrsFragment.this.iBD && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                FrsFragment.this.iBs.cxu();
                            }
                        }
                    });
                }
                if (this.iAQ.getForum() != null) {
                    this.iBs.Ka(this.iAQ.getForum().getWarningMsg());
                }
                if (this.iAQ != null && this.iAQ.getFrsVideoActivityData() != null && com.baidu.tbadk.core.sharedPref.b.bnH().getLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 0L) == 0) {
                    com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.24
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsFragment.this.iBs.cxs();
                        }
                    }, 1000L);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FRS_SHOW_AR_ENTRY, this));
                this.iBs.cwL();
                if (this.iAQ != null && this.iAQ.getForum() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ENTER_FORUM, new VisitedForumData(this.iAQ.getForum().getId(), this.iAQ.getForum().getName(), this.iAQ.getForum().getImage_url(), String.valueOf(System.currentTimeMillis() / 1000), ConstantData.Forum.SPECAIL_FORUM_TYPE_LIVE.equals(this.iAQ.getForum().special_forum_type), this.iAQ.getForum().getThemeColorInfo(), this.iAQ.getForum().getMember_num())));
                }
                this.iCj.a(this.iAQ.bottomMenuList, this.iAQ.getForum());
                cwy();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void cvY() {
        if (this.iBL != null && this.iBL.cBL() == 1) {
            this.iBM.j(this.iAQ);
        }
    }

    public void pi(boolean z) {
        com.baidu.tieba.s.c.dGv().b(getUniqueId(), z);
    }

    public void cvZ() {
        if (this.iBZ == null) {
            this.iBZ = new com.baidu.tieba.frs.live.a(this, com.baidu.adp.lib.f.b.toInt(this.forumId, 0));
        }
        this.iBZ.cBs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.tbadkCore.m mVar) {
        try {
            if (!this.iBD && mVar != null && this.iAQ != null) {
                this.iAQ.receiveData(mVar);
                X(true, false);
                Looper.myQueue().addIdleHandler(this.iCy);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void cwa() {
        if (this.iBL != null) {
            JZ(this.iBL.getPageType());
        } else {
            JZ("normal_page");
        }
    }

    private void JZ(String str) {
        pj("frs_page".equals(str));
        if (this.iBT != null) {
            this.iBT.a(this.iBM, this.iBs, this.iAQ);
        }
    }

    public void pj(boolean z) {
        if (this.iBX != null) {
            this.iBX.cDC();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.s.c.dGv().z(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.frs_activity, viewGroup, false);
            this.iBe = new com.baidu.tieba.frs.entelechy.a();
            this.iBT = this.iBe.czf();
            this.iBd = TbadkCoreApplication.getInst().getString(R.string.frs_title_new_area);
            this.iBM = new com.baidu.tieba.frs.vc.h(this, this.iBe, (FrsHeaderViewContainer) this.mRootView.findViewById(R.id.header_view_container));
            this.iBN = new FrsTabViewController(this, this.mRootView);
            this.iBN.registerListener();
            this.iBM.a(this.iBN);
            this.iBN.a(this.iCG);
            Intent intent = getActivity().getIntent();
            if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                this.iBg = true;
            }
            this.iBs = new q(this, this.iDb, this.iBe, this.iBg, this.iBM);
            this.iCj = new com.baidu.tieba.frs.brand.buttommenu.a(getPageContext(), this.mRootView);
        } else {
            if (this.mRootView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            if (this.iBN != null) {
                this.iBN.registerListener();
            }
            this.iBs.cxr();
            this.mRootView.setLeft(0);
            this.mRootView.setRight(com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getContext()));
        }
        this.iCn = true;
        this.fpm = System.currentTimeMillis() - currentTimeMillis;
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        ArrayList<com.baidu.adp.widget.ListView.q> arrayList = null;
        this.idU = System.currentTimeMillis();
        long j = this.idU;
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.iBp = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.idU = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            R(intent);
        }
        this.fpl = j - this.idU;
        this.iBo = new com.baidu.tieba.tbadkCore.data.f("frs", com.baidu.tieba.tbadkCore.data.f.mQm);
        if (this.iBL == null) {
            this.iBL = new FrsModelController(this, this.iCW);
            this.iBL.a(this.iCF);
            this.iBL.init();
        }
        this.iBL.setSchemeUrl(this.mSchemeUrl);
        if (intent != null) {
            this.iBL.aj(intent.getExtras());
        } else if (bundle != null) {
            this.iBL.aj(bundle);
        } else {
            this.iBL.aj(null);
        }
        if (intent != null) {
            this.iBM.aq(intent.getExtras());
        } else if (bundle != null) {
            this.iBM.aq(bundle);
        } else {
            this.iBM.aq(null);
        }
        this.iBr = getVoiceManager();
        this.iCa = new p(getPageContext(), this);
        initUI();
        initData(bundle);
        if (!cwr()) {
            this.iBR = new ax(getActivity(), this.iBs, this.iBM);
            this.iBR.pF(true);
        }
        this.iBr = getVoiceManager();
        if (this.iBr != null) {
            this.iBr.onCreate(getPageContext());
        }
        if (FrsActivityConfig.FRS_FROM_FLUTTER_BCASTEDIT.equals(getFrom()) && !this.hasInit) {
            int i = com.baidu.tbadk.core.sharedPref.b.bnH().getInt("key_forum_broadcast_edit_tip_number", 0);
            if (i < 2) {
                com.baidu.tbadk.core.sharedPref.b.bnH().putInt("key_forum_broadcast_edit_tip_number", i + 1);
                cwg();
            } else if (Build.VERSION.SDK_INT >= 23) {
                if (Settings.canDrawOverlays(getContext())) {
                    cwh();
                } else {
                    new BdTopToast(getContext()).yb(false).Uc(getContext().getString(R.string.forum_broadcast_copy_no_permission_hint)).aH(this.iBs.chy());
                }
            } else {
                cwh();
            }
        }
        if (KuangFloatingFrsCopyLinkViewController.getInstance().isFloatCopyViewShow()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
            if (this.iBt != null) {
                this.iBt.setVisibility(8);
            }
        }
        new com.baidu.tieba.frs.mc.i();
        int i2 = -1;
        if (this.iBW != null && this.iBW.cBD() != null) {
            i2 = this.iBW.cBD().cvL();
            arrayList = this.iBW.cBD().getDataList();
        }
        this.iBW = new com.baidu.tieba.frs.mc.c(this, this.iCZ);
        this.iBW.cBD().setHasMore(i2);
        if (arrayList != null && arrayList.size() > 0) {
            this.iBW.cBD().aF(arrayList);
        }
        this.iBP = new com.baidu.tieba.frs.smartsort.a(this);
        this.iBX = new com.baidu.tieba.frs.vc.j(this);
        this.iBU = new com.baidu.tieba.frs.vc.a(getPageContext(), this.iBL.cBS());
        this.iBQ = new com.baidu.tieba.frs.mc.b(this);
        this.iBV = new com.baidu.tieba.frs.mc.d(this);
        this.iBO = new com.baidu.tieba.frs.mc.h(this);
        this.iBY = new com.baidu.tieba.frs.mc.a(this);
        this.iCb = new com.baidu.tieba.frs.vc.c(this);
        this.iCc = new com.baidu.tieba.frs.mc.e(this, getUniqueId());
        this.iCh = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "frs");
        this.iCi = new com.baidu.tieba.ala.a(getPageContext());
        this.iCk = new com.baidu.tieba.frs.sportspage.notification.a(getPageContext());
        registerListener(this.iCO);
        registerListener(this.mMemListener);
        registerListener(this.iCM);
        registerListener(this.iDa);
        registerListener(this.iCX);
        registerListener(this.iCI);
        registerListener(this.iCJ);
        registerListener(this.iCK);
        registerListener(this.iCL);
        registerListener(this.iCz);
        registerListener(this.iCA);
        registerListener(this.agB);
        registerListener(this.iCB);
        registerListener(this.iDf);
        registerListener(this.iCQ);
        registerListener(this.iCE);
        registerListener(this.iCR);
        registerListener(this.iCP);
        registerListener(this.iCT);
        registerListener(this.iCU);
        registerListener(this.iCV);
        this.iDg.setTag(getPageContext().getUniqueId());
        MessageManager.getInstance().registerListener(this.iDg);
        registerListener(this.iDh);
        registerListener(this.iDi);
        registerListener(this.iDj);
        registerListener(this.iCD);
        registerListener(this.iDk);
        registerListener(this.iCS);
        registerListener(this.iCC);
        registerListener(this.iDl);
        registerListener(this.iDm);
        registerListener(this.iDn);
        this.iBs.ps(false);
        if (!cwr() && !this.hasInit) {
            showLoadingView(this.iBs.chy(), true);
            this.iBL.T(3, false);
        }
        ay ayVar = new ay() { // from class: com.baidu.tieba.frs.FrsFragment.27
            @Override // com.baidu.tieba.frs.ay
            public void d(boolean z, boolean z2, int i3) {
                if (FrsFragment.this.iBs != null) {
                    if (i3 == 1) {
                        FrsFragment.this.iBs.yB(z ? 0 : 8);
                    } else if (i3 == 2) {
                        FrsFragment.this.iBs.yD(z ? 0 : 8);
                    }
                    if (!z2) {
                        FrsFragment.this.iCm = z;
                    }
                    if (FrsFragment.this.iBs.cxj() != null && (i3 == 2 || (FrsFragment.this.iBL != null && FrsFragment.this.iBL.cBM()))) {
                        FrsFragment.this.iBs.cxj().notifyDataSetChanged();
                    }
                    if (FrsFragment.this.cvI() != null) {
                        FrsTabViewController.b cDR = FrsFragment.this.cvI().cDR();
                        if (cDR != null) {
                            if ((cDR.fragment instanceof FrsCommonTabFragment) && (i3 == 2 || cDR.tabId == 502)) {
                                ((FrsCommonTabFragment) cDR.fragment).cyV();
                            } else if ((cDR.fragment instanceof FrsNewAreaFragment) && (i3 == 2 || cDR.tabId == 503)) {
                                FrsNewAreaFragment frsNewAreaFragment = (FrsNewAreaFragment) cDR.fragment;
                                frsNewAreaFragment.cyV();
                                if (frsNewAreaFragment.cCd() != null) {
                                    com.baidu.tieba.frs.mc.g cCd = frsNewAreaFragment.cCd();
                                    cCd.pH(!z);
                                    if (i3 == 1) {
                                        cCd.pv(!z);
                                    } else if (i3 == 2) {
                                        cCd.pv(true);
                                    }
                                }
                            } else if (cDR.fragment instanceof FrsGoodFragment) {
                                ((FrsGoodFragment) cDR.fragment).cyV();
                            }
                        }
                        if (FrsFragment.this.cvI().cDI() != null) {
                            FrsFragment.this.cvI().cDI().setmDisallowSlip(z);
                            FrsFragment.this.cvI().qm(z);
                        }
                    }
                    if (FrsFragment.this.iBs.cwP() != null) {
                        FrsFragment.this.iBs.pp(!z);
                    }
                    if (FrsFragment.this.getActivity() instanceof FrsActivity) {
                        ((FrsActivity) FrsFragment.this.getActivity()).pg(!z);
                    }
                    if (FrsFragment.this.iCj != null) {
                        FrsFragment.this.iCj.pN(!z);
                    }
                    FrsFragment.this.iBs.pu(!z);
                    if (i3 == 1) {
                        FrsFragment.this.iBs.pv(z ? false : true);
                    } else if (i3 == 2) {
                        FrsFragment.this.iBs.pv(true);
                    }
                }
            }

            @Override // com.baidu.tieba.frs.ay
            public void ck(int i3, int i4) {
                if (FrsFragment.this.iBs != null) {
                    if (i4 == 1) {
                        FrsFragment.this.iBs.yC(i3);
                    } else if (i4 == 2) {
                        FrsFragment.this.iBs.yE(i3);
                    }
                }
            }

            @Override // com.baidu.tieba.frs.ay
            public void yu(int i3) {
                if (FrsFragment.this.getContext() != null) {
                    if (i3 == 1) {
                        com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getContext(), R.string.frs_multi_delete_max_num);
                    } else if (i3 == 2 && FrsFragment.this.iBs != null) {
                        new BdTopToast(FrsFragment.this.getContext()).yb(false).Uc(FrsFragment.this.getContext().getString(R.string.frs_move_area_max_num)).aH(FrsFragment.this.iBs.chy());
                    }
                }
            }
        };
        b.cuL().a(ayVar);
        com.baidu.tieba.frs.a.cuE().a(ayVar);
        this.iBs.b(new d.a() { // from class: com.baidu.tieba.frs.FrsFragment.28
            @Override // com.baidu.tieba.NEGFeedBack.d.a
            public void a(DeleteThreadHttpResponseMessage deleteThreadHttpResponseMessage) {
                boolean z;
                int i3 = 0;
                if (deleteThreadHttpResponseMessage != null) {
                    FrsFragment.this.iBs.bFX();
                    FrsFragment.this.iBs.cxt();
                    FrsNewAreaFragment frsNewAreaFragment = null;
                    if (FrsFragment.this.iBN == null || FrsFragment.this.iBN.cDR() == null || !(FrsFragment.this.iBN.cDR().fragment instanceof FrsNewAreaFragment)) {
                        z = false;
                    } else {
                        frsNewAreaFragment = (FrsNewAreaFragment) FrsFragment.this.iBN.cDR().fragment;
                        z = true;
                    }
                    if (deleteThreadHttpResponseMessage.getError() == 0) {
                        String text = !TextUtils.isEmpty(deleteThreadHttpResponseMessage.getText()) ? deleteThreadHttpResponseMessage.getText() : FrsFragment.this.getString(R.string.delete_fail);
                        if (deleteThreadHttpResponseMessage.getRetType() == 1211066) {
                            if (FrsFragment.this.hUt == null) {
                                FrsFragment.this.hUt = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.hUt.Ba(text);
                            FrsFragment.this.hUt.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.28.1
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.hUt.iN(false);
                            FrsFragment.this.hUt.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.hUt.bmC();
                        } else if (deleteThreadHttpResponseMessage.getRetType() == 1211067) {
                            if (FrsFragment.this.hUt == null) {
                                FrsFragment.this.hUt = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.hUt.Ba(text);
                            FrsFragment.this.hUt.a(R.string.know, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.28.2
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.hUt.iN(false);
                            FrsFragment.this.hUt.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.hUt.bmC();
                        } else {
                            FrsFragment.this.iBs.aN(deleteThreadHttpResponseMessage.getText(), ContextCompat.getColor(FrsFragment.this.getContext(), deleteThreadHttpResponseMessage.getRetType() == 1 ? R.color.nav_bar_tip_error : R.color.cp_link_tip_a_alpha95));
                        }
                        if (z && frsNewAreaFragment != null) {
                            frsNewAreaFragment.dh(deleteThreadHttpResponseMessage.getSuccessItems());
                        }
                        FrsFragment.this.cV(deleteThreadHttpResponseMessage.getSuccessItems());
                        b.cuL().cU(deleteThreadHttpResponseMessage.getSuccessItems());
                        for (com.baidu.adp.widget.ListView.q qVar : FrsFragment.this.iAQ.getThreadList()) {
                            if (qVar instanceof bv) {
                                i3++;
                                continue;
                            }
                            if (i3 >= 6) {
                                break;
                            }
                        }
                        if (i3 < 6) {
                            FrsFragment.this.bMi();
                            return;
                        }
                        return;
                    }
                    com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getActivity(), deleteThreadHttpResponseMessage.getErrorString());
                }
            }
        });
        this.dDO = UtilHelper.getScreenHeight(getActivity());
        this.hasInit = true;
        yr(1);
        super.onActivityCreated(bundle);
        this.createTime = System.currentTimeMillis() - j;
    }

    public void pk(boolean z) {
        if (this.iBN != null) {
            this.iBN.jdX = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cV(List<String> list) {
        if (!com.baidu.tbadk.core.util.y.isEmpty(list)) {
            ArrayList<com.baidu.adp.widget.ListView.q> threadList = this.iAQ.getThreadList();
            if (!com.baidu.tbadk.core.util.y.isEmpty(threadList) && this.iBs.getListView() != null && this.iBs.getListView().getData() != null) {
                Iterator<com.baidu.adp.widget.ListView.q> it = threadList.iterator();
                List<com.baidu.adp.widget.ListView.q> data = this.iBs.getListView().getData();
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.q next = it.next();
                    if (next instanceof bv) {
                        bw bwVar = ((bv) next).erH;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= list.size()) {
                                break;
                            } else if (!com.baidu.tbadk.core.util.at.equals(list.get(i2), bwVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.iBW.d(next);
                                this.iBs.getListView().getAdapter().notifyItemRemoved(i);
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
    public void cuJ() {
        if (!com.baidu.tbadk.core.util.y.isEmpty(com.baidu.tieba.frs.a.cuE().cuI()) && this.iBs.getListView() != null && this.iBs.getListView().getData() != null) {
            ArrayList<com.baidu.adp.widget.ListView.q> threadList = this.iAQ.getThreadList();
            if (!com.baidu.tbadk.core.util.y.isEmpty(threadList)) {
                Iterator<com.baidu.adp.widget.ListView.q> it = threadList.iterator();
                List<com.baidu.adp.widget.ListView.q> data = this.iBs.getListView().getData();
                int count = com.baidu.tbadk.core.util.y.getCount(com.baidu.tieba.frs.a.cuE().cuI());
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.q next = it.next();
                    if (next instanceof bv) {
                        bw bwVar = ((bv) next).erH;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= count) {
                                break;
                            } else if (!com.baidu.tbadk.core.util.at.equals(com.baidu.tieba.frs.a.cuE().cuI().get(i2).getId(), bwVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.iBW.d(next);
                                this.iBs.getListView().getAdapter().notifyItemRemoved(i);
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
    public void bMC() {
        if (isAdded() && this.ggt && !isLoadingViewAttached()) {
            showLoadingView(this.iBs.chy(), true);
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void bMD() {
        if (isAdded() && this.ggt && isLoadingViewAttached()) {
            hideLoadingView(this.iBs.chy());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (cwr()) {
            showLoadingView(this.iBs.chy(), true);
            this.iBs.yF(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.iBL.S(3, true);
            bqA().scrollToPosition(0);
        }
    }

    private void yr(int i) {
        String str = "";
        if (this.iAQ != null && this.iAQ.getForum() != null) {
            str = this.iAQ.getForum().getId();
        }
        if (!StringUtils.isNull(str)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13008").dR("fid", str).dR("obj_type", "4").aj("obj_locate", i).dR("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.ab abVar) {
        if (abVar != null) {
            this.fti = abVar.bBt();
            this.iCd = abVar.bBu();
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void showFloatingView() {
        if (this.fti != null) {
            this.fti.showFloatingView(true);
        }
    }

    private void R(Intent intent) {
        if (intent != null) {
            if (intent != null) {
                if (!com.baidu.tieba.frs.f.h.a(this, getForumName(), "from", intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false)) && getActivity() != null) {
                    getActivity().finish();
                    return;
                }
            }
            Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
            this.mSchemeUrl = uri != null ? uri.toString() : null;
            if (uri != null) {
                this.iBk = uri.getQueryParameter("name");
                this.mFrom = uri.getQueryParameter("from");
                if (!StringUtils.isNull(this.iBk)) {
                    intent.putExtra("name", this.iBk);
                }
                if (!StringUtils.isNull(this.mFrom)) {
                    intent.putExtra("from", this.mFrom);
                }
                TiebaStatic.log(TbadkCoreStatisticKey.AS_INVOKE_TIEBA);
            }
            if (StringUtils.isNull(this.iBk) && uri != null) {
                if (com.baidu.tbadk.BdToken.f.p(uri)) {
                    com.baidu.tbadk.BdToken.f.bdZ().b(uri, this.iCY);
                } else {
                    com.baidu.tieba.frs.f.f U = com.baidu.tieba.frs.f.k.U(intent);
                    if (U != null) {
                        this.iBk = U.forumName;
                        if (U.jbD == null || U.jbD.equals("aidou")) {
                        }
                    }
                }
                if (!StringUtils.isNull(this.iBk)) {
                    intent.putExtra("name", this.iBk);
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
        public void B(final HashMap<String, Object> hashMap) {
            if (hashMap != null) {
                if (hashMap.get(com.baidu.tbadk.BdToken.f.elM) instanceof String) {
                    FrsFragment.this.iBk = (String) hashMap.get(com.baidu.tbadk.BdToken.f.elM);
                }
                if ((hashMap.get(com.baidu.tbadk.BdToken.f.eme) instanceof String) && !TextUtils.isEmpty((String) hashMap.get(com.baidu.tbadk.BdToken.f.eme))) {
                    com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.29.1
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsFragment.this.iBN.sW(301);
                            final long j = com.baidu.adp.lib.f.b.toLong((String) hashMap.get(com.baidu.tbadk.BdToken.f.elN), 0L);
                            final int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
                            final int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
                            final float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                            final int i = 1;
                            if (com.baidu.tbadk.core.util.au.boO().boP()) {
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
        this.iBr = getVoiceManager();
        if (this.iBr != null) {
            this.iBr.onStart(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        Intent intent;
        long j = 0;
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.eZe);
        if (bundle != null) {
            this.iBk = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            j = bundle.getLong(FrsActivityConfig.FRS_FAKE_THREAD_ID, 0L);
        } else if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
            this.iBk = intent.getStringExtra("name");
            this.mFrom = intent.getStringExtra("from");
            this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
            j = intent.getLongExtra(FrsActivityConfig.FRS_FAKE_THREAD_ID, 0L);
        }
        if (getArguments() != null) {
            this.iBl = getArguments().getBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, false);
        }
        if (TextUtils.isEmpty(this.mFrom) || FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
        }
        if (this.mIsLogin) {
            registerListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL, this.eZe);
        }
        this.iBM.aq(bundle);
        fi(j);
    }

    private void fi(final long j) {
        if (j > 0) {
            final int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
            final int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
            final float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            final int i = 1;
            if (com.baidu.tbadk.core.util.au.boO().boP()) {
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
        com.baidu.tieba.s.c.dGv().A(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.iDf);
        this.iBX.destroy();
        iBw = null;
        if (this.iBr != null) {
            this.iBr.onDestory(getPageContext());
        }
        com.baidu.tieba.recapp.report.a.remove("FRS");
        this.iBr = null;
        com.baidu.tieba.card.t.clQ().op(false);
        if (this.iAQ != null && this.iAQ.getForum() != null) {
            ak.cxT().fj(com.baidu.adp.lib.f.b.toLong(this.iAQ.getForum().getId(), 0L));
        }
        if (this.iBZ != null) {
            this.iBZ.onDestory();
        }
        if (this.iBs != null) {
            com.baidu.tieba.frs.f.j.a(this.iBs, this.iAQ, getForumId(), false, null);
            this.iBs.onDestroy();
        }
        if (this.iBv != null) {
            this.iBv.removeAllViews();
            this.iBv.setVisibility(8);
        }
        if (this.iCt != null) {
            this.iCt.cancel();
        }
        if (this.iCu != null) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.iCu);
        }
        this.iCs = null;
        super.onDestroy();
        try {
            if (this.iBF != null) {
                this.iBF.bzN();
            }
            if (this.iBs != null) {
                this.iBs.release();
            }
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.iBM.cBk();
        Looper.myQueue().removeIdleHandler(this.iCy);
        if (this.iBL != null) {
            this.iBL.bTn();
        }
        if (this.iBR != null) {
            this.iBR.cyb();
        }
        if (this.iBU != null) {
            this.iBU.destory();
        }
        if (this.iBP != null) {
            this.iBP.onDestroy();
        }
        if (this.iCf != null) {
            this.iCf.onDestory();
        }
        if (this.iBY != null) {
            this.iBY.onDestroy();
        }
        if (this.iCh != null) {
            this.iCh.onDestroy();
        }
        if (this.iCi != null) {
            this.iCi.onDestroy();
        }
        com.baidu.tieba.recapp.d.a.dyA().dyD();
        com.baidu.tieba.frs.f.l.cCK();
        if (this.iBN != null) {
            this.iBN.a((FrsTabViewController.a) null);
            this.iBN.cDT();
        }
        if (this.iCl != null) {
            this.iCl.onDestroy();
        }
        b.cuL().a(null);
        com.baidu.tieba.frs.a.cuE().a(null);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.iBk);
        bundle.putString("from", this.mFrom);
        this.iBL.onSaveInstanceState(bundle);
        if (this.iBr != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            this.iBr.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.iBY != null) {
            this.iBY.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.iBs != null) {
            this.iBs.cwW();
            this.iBs.onResume();
        }
        this.iBO.qe(true);
        this.iBG = true;
        if (iBj) {
            iBj = false;
            if (this.iBs != null) {
                this.iBs.startPullRefresh();
                return;
            }
            return;
        }
        if (this.iBr != null) {
            this.iBr.onResume(getPageContext());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_RESUME));
        if (this.iBs != null) {
            this.iBs.pw(false);
        }
        if (this.iCg) {
            refresh(6);
            this.iCg = false;
        }
        if (this.iCp != null && getActivity() != null) {
            if (NotificationManagerCompat.from(getActivity()).areNotificationsEnabled()) {
                com.baidu.tbadk.coreExtra.messageCenter.f.bur().setSignAlertOn(true);
                com.baidu.tbadk.coreExtra.messageCenter.f.bur().setSignAlertTime(this.iCp.getHours(), this.iCp.getMinutes());
                if (this.iBs != null) {
                    com.baidu.tbadk.coreExtra.messageCenter.f.bur().a(getTbPageContext().getPageActivity(), this.iBs.chy());
                }
            }
            this.iCp = null;
        }
        cwy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
    }

    public boolean cwb() {
        Intent intent;
        if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
            return false;
        }
        return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
    }

    public void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.iBk = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.iBm = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.iBm) {
                cwc();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwc() {
        this.iBs.startPullRefresh();
    }

    public void closeActivity() {
        com.baidu.tieba.frs.f.k.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.mFrom);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.iBs.setTitle(this.iBk);
        } else {
            this.iBs.setTitle("");
            this.mFlag = 1;
        }
        this.iBs.a(this.iDd);
        this.iBs.addOnScrollListener(this.mScrollListener);
        this.iBs.g(this.iyC);
        this.iBs.cxj().a(this.iDc);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.iCn) {
            this.iBs.onChangeSkinType(i);
            this.iBM.Ai(i);
            this.iBN.onChangeSkinType(i);
            if (this.iBu != null) {
                this.iBu.onChangeSkinType(i);
            }
            if (this.iCe != null) {
                this.iCe.onChangeSkinType();
            }
            if (this.iCj != null) {
                this.iCj.onChangeSkinType(getPageContext(), i);
            }
            if (this.hUt != null) {
                com.baidu.tbadk.r.a.a(getPageContext(), this.hUt.getRealView());
            }
            if (this.iCf != null) {
                this.iCf.onChangeSkinType(getPageContext(), i);
            }
        }
    }

    public void ys(int i) {
        if (!this.mIsLogin) {
            if (this.iAQ != null && this.iAQ.getAnti() != null) {
                this.iAQ.getAnti().setIfpost(1);
            }
            if (i == 0) {
                com.baidu.tbadk.core.util.bg.skipToLoginActivity(getActivity());
            }
        } else if (this.iAQ != null) {
            if (i == 0) {
                com.baidu.tieba.frs.f.l.g(this, 0);
            } else {
                this.iBs.cwY();
            }
        }
    }

    public void refresh() {
        com.baidu.tieba.a.d.bGs().EK("page_frs");
        refresh(3);
    }

    public void refresh(int i) {
        this.iBD = false;
        cwj();
        if (this.iBs != null && this.iBs.cwN() != null) {
            this.iBs.cwN().cHM();
        }
        if (this.iBL != null) {
            this.iBL.S(i, true);
        }
    }

    private void cwd() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.f.h.mZ().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.35
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.SE(FrsFragment.this.iBk);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwe() {
        cwj();
        try {
            if (this.iAQ != null) {
                this.iBs.bSR();
                this.iBs.pp(cwx());
                if (!com.baidu.tieba.frs.vc.h.m(this.iAQ) || !com.baidu.tieba.frs.vc.h.l(this.iAQ)) {
                }
                if (this.iAQ.getForum() != null) {
                    this.iBk = this.iAQ.getForum().getName();
                    this.forumId = this.iAQ.getForum().getId();
                }
                if (this.iAQ.getPage() != null) {
                    setHasMore(this.iAQ.getPage().biQ());
                }
                this.iBs.setTitle(this.iBk);
                this.iBs.setForumName(this.iBk);
                TbadkCoreApplication.getInst().setDefaultBubble(this.iAQ.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.iAQ.getUserData().getBimg_end_time());
                cwd();
                cwf();
                ArrayList<com.baidu.adp.widget.ListView.q> threadList = this.iAQ.getThreadList();
                if (threadList != null) {
                    this.iBs.a(threadList, this.iAQ);
                    com.baidu.tieba.frs.f.c.A(this.iBs);
                    this.iBM.Aj(getPageNum());
                    this.iBM.i(this.iAQ);
                    this.iBN.a(this.iAQ, this.iBL.cBQ());
                    this.iBs.cwZ();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void cwf() {
        if (this.iAQ != null) {
            if (this.iAQ.getIsNewUrl() == 1) {
                this.iBs.cxj().setFromCDN(true);
            } else {
                this.iBs.cxj().setFromCDN(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.iBO.qe(false);
        this.iBG = false;
        this.iBs.onPause();
        if (this.iBr != null) {
            this.iBr.onPause(getPageContext());
        }
        this.iBs.pw(true);
        if (this.iBU != null) {
            this.iBU.cCN();
        }
        com.baidu.tbadk.BdToken.c.bdF().bdQ();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.iBN != null && this.iBN.cDR() != null && (this.iBN.cDR().fragment instanceof BaseFragment)) {
            ((BaseFragment) this.iBN.cDR().fragment).setPrimary(z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.t.clQ().op(false);
        pi(false);
        if (this.iAQ != null && this.iAQ.getForum() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            com.baidu.tbadk.distribute.a.bwL().b(getPageContext().getPageActivity(), "frs", this.iAQ.getForum().getId(), 0L);
        }
        if (this.iBr != null) {
            this.iBr.onStop(getPageContext());
        }
        if (bqA() != null) {
            bqA().getRecycledViewPool().clear();
        }
        this.iBM.bpO();
        com.baidu.tbadk.util.ac.bBw();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            if (this.iBM != null) {
                this.iBM.bP(isPrimary());
            }
            if (this.iBs != null) {
                this.iBs.bP(isPrimary());
                this.iBs.pw(!isPrimary());
            }
        }
    }

    private void cwg() {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.op(2);
        aVar.iN(false);
        FrsBroadcastCopyGuideDialogView frsBroadcastCopyGuideDialogView = new FrsBroadcastCopyGuideDialogView(getPageContext().getPageActivity());
        frsBroadcastCopyGuideDialogView.setConfirmButtonListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.36
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aVar != null) {
                    aVar.dismiss();
                    FrsFragment.this.cwh();
                }
            }
        });
        aVar.bb(frsBroadcastCopyGuideDialogView);
        aVar.b(getPageContext()).bmC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwh() {
        if (KuangFloatingFrsCopyLinkViewController.getInstance().init()) {
            ((BaseFragmentActivity) getPageContext().getOrignalPage()).grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.frs.FrsFragment.37
                @Override // com.baidu.tbadk.core.e
                public void onPermissionResult(boolean z) {
                    if (!z) {
                        new BdTopToast(FrsFragment.this.getContext()).yb(false).Uc(FrsFragment.this.getContext().getString(R.string.forum_broadcast_copy_no_permission_hint)).aH(FrsFragment.this.iBs.chy());
                        return;
                    }
                    KuangFloatingFrsCopyLinkViewController.getInstance().showFloatingView(true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                    if (FrsFragment.this.iBt != null) {
                        FrsFragment.this.iBt.setVisibility(8);
                    }
                }
            }, true);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (b.cuL().cuF()) {
                b.cuL().reset();
                return true;
            } else if (com.baidu.tieba.frs.a.cuE().cuF()) {
                if (this.iBs != null && this.iBs.cxo()) {
                    this.iBs.cxp();
                    return true;
                }
                com.baidu.tieba.frs.a.cuE().reset();
                return true;
            } else if (this.iBs != null) {
                return this.iBs.cwV();
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
        com.baidu.tbadk.distribute.a.bwL().a(advertAppInfo, this.forumId, 0L, "FRS", str, getPn());
    }

    @Override // com.baidu.tieba.recapp.n
    public void cwi() {
        cvF().cwi();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.iBr == null) {
            this.iBr = VoiceManager.instance();
        }
        return this.iBr;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdRecyclerView bqA() {
        if (this.iBs == null) {
            return null;
        }
        return this.iBs.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void cwj() {
        if (this.iBr != null) {
            this.iBr.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> bqB() {
        if (this.eSd == null) {
            this.eSd = UserIconBox.u(getPageContext().getPageActivity(), 8);
        }
        return this.eSd;
    }

    public void cwk() {
        if (getFragmentActivity() != null && getFragmentActivity().getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.t onGetPreLoadListView() {
        return bqA().getPreLoadHandle();
    }

    @Override // com.baidu.tieba.frs.at
    public NavigationBar bQh() {
        if (this.iBs == null) {
            return null;
        }
        return this.iBs.bQh();
    }

    public FRSRefreshButton cwl() {
        return this.iBu;
    }

    public void c(LinearLayout linearLayout) {
        if (linearLayout != null) {
            this.iBv = linearLayout;
        }
    }

    public void a(FRSRefreshButton fRSRefreshButton) {
        if (fRSRefreshButton != null) {
            this.iBu = fRSRefreshButton;
            this.iBu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.43
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (FrsFragment.this.iBN != null) {
                        FrsTabViewController.b cDR = FrsFragment.this.iBN.cDR();
                        if (cDR != null && cDR.fragment != null && (cDR.fragment instanceof as)) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                            ((as) cDR.fragment).cvr();
                            ((as) cDR.fragment).bNv();
                            return;
                        }
                        FrsFragment.this.cvK().startPullRefresh();
                    }
                }
            });
        }
    }

    public void cwm() {
        if (this.iBu != null) {
            this.iBu.hide();
        }
    }

    public void cwn() {
        if (this.iBu != null) {
            this.iBu.show();
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
                if (bdUniqueId == w.iFh) {
                    if (FrsFragment.this.iBs != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11752").dR("fid", FrsFragment.this.forumId).dR("obj_locate", "1"));
                        FrsFragment.this.iBs.startPullRefresh();
                    }
                } else if (qVar != null && (qVar instanceof bv)) {
                    bw bwVar = ((bv) qVar).erH;
                    if (bwVar.bla() == null || bwVar.bla().getGroup_id() == 0 || com.baidu.tbadk.core.util.bg.checkUpIsLogin(FrsFragment.this.getActivity())) {
                        if (bwVar.bkN() != 1 || com.baidu.tbadk.core.util.bg.checkUpIsLogin(FrsFragment.this.getActivity())) {
                            if (bwVar.bkm() != null) {
                                if (com.baidu.tbadk.core.util.bg.checkUpIsLogin(FrsFragment.this.getActivity())) {
                                    String postUrl = bwVar.bkm().getPostUrl();
                                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.isNetOk()) {
                                        com.baidu.tbadk.browser.a.startInternalWebActivity(FrsFragment.this.getActivity(), postUrl);
                                    }
                                }
                            } else if (bwVar.bll() != null) {
                                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                    com.baidu.tbadk.core.util.bg.skipToLoginActivity(FrsFragment.this.getPageContext().getPageActivity());
                                    return;
                                }
                                com.baidu.tbadk.core.data.r bll = bwVar.bll();
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), bll.getCartoonId(), bll.getChapterId(), 2)));
                            } else {
                                com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                                if (readThreadHistory != null && !readThreadHistory.SK(bwVar.getId())) {
                                    readThreadHistory.SJ(bwVar.getId());
                                }
                                boolean z = false;
                                final String bkg = bwVar.bkg();
                                if (bkg != null && !bkg.equals("")) {
                                    z = true;
                                    new Thread(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.a.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            com.baidu.tbadk.core.util.aa aaVar = new com.baidu.tbadk.core.util.aa(bkg);
                                            aaVar.bon().boT().mIsNeedAddCommenParam = false;
                                            aaVar.bon().boT().mIsUseCurrentBDUSS = false;
                                            aaVar.getNetData();
                                        }
                                    }).start();
                                }
                                String tid = bwVar.getTid();
                                if (tid == null) {
                                    tid = "";
                                }
                                if (bwVar.bjV() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                    com.baidu.tbadk.core.util.be.boR().b(FrsFragment.this.getPageContext(), new String[]{tid, "", null});
                                    return;
                                }
                                if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && tid.length() > 4) {
                                    bwVar.setId(tid.substring(3));
                                }
                                if (bdUniqueId.getId() == bw.ezL.getId()) {
                                    com.baidu.tieba.frs.f.j.a(bwVar.bjG());
                                } else if (bdUniqueId.getId() == bw.eyl.getId()) {
                                    com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                                    aqVar.dR("obj_type", "2");
                                    aqVar.dR("tid", bwVar.getTid());
                                    TiebaStatic.log(aqVar);
                                }
                                com.baidu.tieba.frs.f.k.a(FrsFragment.this, bwVar, i, z);
                                com.baidu.tieba.frs.f.j.a(FrsFragment.this, FrsFragment.this.iAQ, bwVar);
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
            hideNetRefreshView(this.iBs.cxy().cDH());
            showLoadingView(this.iBs.chy(), true);
            this.iBs.ps(false);
            this.iBL.S(3, true);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData cwo() {
        return this.iAQ;
    }

    public boolean cwp() {
        return this.iBs.cwp();
    }

    public void aI(Object obj) {
        if (this.iBQ != null && this.iBQ.iWU != null) {
            this.iBQ.iWU.callback(obj);
        }
    }

    public void aJ(Object obj) {
        if (this.iBQ != null && this.iBQ.iWV != null) {
            this.iBQ.iWV.callback(obj);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        this.iBs.getListView().stopScroll();
        if (!this.iBs.cxf()) {
            if (!com.baidu.adp.lib.util.l.isNetOk()) {
                this.iBs.bNw();
            } else if (this.iBL.cBL() == 1) {
                bMx();
                bMi();
            } else if (this.iBL.hasMore()) {
                bMi();
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void onFailed(String str) {
        bMx();
        showToast(str);
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void ax(ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        boolean isEmpty = com.baidu.tbadk.core.util.y.isEmpty(arrayList);
        setHasMore(isEmpty ? 0 : 1);
        bMx();
        if (!isEmpty) {
            if (!this.iBL.cBV() && TbadkCoreApplication.getInst().isRecAppExist() && this.iBL.cBL() == 1) {
                this.iAQ.addRecommendAppToThreadList(this, arrayList);
            }
            if (this.iBL != null) {
                com.baidu.tieba.frs.d.a.a(getUniqueId(), arrayList, this.iAQ.getForum(), this.iBL.getSortType());
            }
            ArrayList<com.baidu.adp.widget.ListView.q> a2 = this.iBW.a(false, false, arrayList, this.iBo, false);
            if (a2 != null) {
                this.iAQ.setThreadList(a2);
                this.iBs.a(a2, this.iAQ);
            }
            if (this.iBL != null) {
                com.baidu.tieba.frs.d.c.a(this.iAQ, this.iBL.cBQ(), 2, getContext());
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.iAQ.getForum()));
        }
    }

    private void bMx() {
        if (cvL() == 1 || this.iBW.dg(this.iAQ.getThreadListIds())) {
            if (com.baidu.tbadk.core.util.y.getCount(this.iAQ.getThreadList()) > 3) {
                this.iBs.TI();
            } else {
                this.iBs.cxm();
            }
        } else if (com.baidu.tbadk.core.util.y.isEmpty(this.iAQ.getThreadList())) {
            this.iBs.bNw();
        } else {
            this.iBs.TJ();
        }
    }

    @Override // com.baidu.tieba.frs.mc.l
    public void bMi() {
        if (this.iBW != null) {
            this.iBW.a(this.iBk, this.forumId, this.iAQ);
        }
    }

    public void cwq() {
        if (!com.baidu.tbadk.core.util.ae.requestWriteExternalStorgeAndCameraPermission(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.ao.g(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment, com.baidu.m.a.a.InterfaceC0238a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        com.baidu.tieba.frs.f.k.a(this, i, strArr, iArr);
    }

    public void pl(boolean z) {
        if (this.iBR != null) {
            this.iBR.pF(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.iBS.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a sQ(int i) {
        return this.iBS.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        this.iCa.b(bVar);
    }

    public boolean cwr() {
        return this.iBg;
    }

    @Override // com.baidu.tieba.frs.aq
    public void Rd() {
        if (this.iBs != null) {
            showFloatingView();
            this.iBs.getListView().scrollToPosition(0);
            this.iBs.startPullRefresh();
        }
    }

    public ForumWriteData cws() {
        if (this.iAQ == null || this.iAQ.getForum() == null) {
            return null;
        }
        ForumData forum = this.iAQ.getForum();
        ForumWriteData forumWriteData = new ForumWriteData(forum.getId(), forum.getName(), forum.getPrefixData(), this.iAQ.getAnti());
        forumWriteData.avatar = forum.getImage_url();
        forumWriteData.forumLevel = forum.getUser_level();
        forumWriteData.specialForumType = forum.special_forum_type;
        forumWriteData.firstDir = forum.getFirst_class();
        forumWriteData.secondDir = forum.getSecond_class();
        UserData userData = this.iAQ.getUserData();
        forumWriteData.privateThread = userData != null ? userData.getPrivateThread() : 0;
        forumWriteData.frsTabInfo = cwt();
        return forumWriteData;
    }

    private FrsTabInfoData cwt() {
        int i;
        if (this.iBL == null || this.iAQ == null || this.iBN == null) {
            return null;
        }
        if (this.iAQ.getEntelechyTabInfo() == null || com.baidu.tbadk.core.util.y.isEmpty(this.iAQ.getEntelechyTabInfo().tab)) {
            return null;
        }
        int cDV = this.iBN.cDV();
        if (cDV == 502) {
            return null;
        }
        int i2 = -1;
        ArrayList arrayList = new ArrayList();
        Iterator<FrsTabInfo> it = this.iAQ.getEntelechyTabInfo().tab.iterator();
        while (true) {
            i = i2;
            if (!it.hasNext()) {
                break;
            }
            FrsTabInfo next = it.next();
            if (next != null && next.is_general_tab.intValue() == 1) {
                arrayList.add(new FrsTabItemData(next));
                if (cDV == next.tab_id.intValue()) {
                    i2 = cDV;
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
    public void bqd() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void pm(boolean z) {
        this.iBH = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z) {
        this.iBs.yA(8);
        ((FrsActivity) getActivity()).showLoadingView(view, z);
        ((FrsActivity) getActivity()).i(view, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        this.iBs.yA(0);
        ((FrsActivity) getActivity()).hideLoadingView(view);
        ((FrsActivity) getActivity()).i(view, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        super.showNetRefreshView(view, getResources().getString(R.string.refresh_view_title_text), null, getResources().getString(R.string.refresh_view_button_text), z, getNetRefreshListener());
        this.iBs.yA(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshViewNoClick(View view, String str, boolean z) {
        super.showNetRefreshViewNoClick(view, str, z);
        this.iBs.yA(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        super.hideNetRefreshView(view);
        this.iBs.yA(0);
    }

    public void cwu() {
        FrsTabViewController.b cDR;
        if (this.iBN != null && (cDR = this.iBN.cDR()) != null && cDR.fragment != null && (cDR.fragment instanceof as)) {
            ((as) cDR.fragment).cvr();
        }
    }

    public void pn(boolean z) {
        this.iBi = z;
    }

    public void b(OvalActionButton ovalActionButton) {
        this.iBt = ovalActionButton;
    }

    public OvalActionButton cwv() {
        return this.iBt;
    }

    public boolean cww() {
        return this.iBi;
    }

    public void onShareSuccess(String str) {
        if (TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.util.at.isEmpty(str)) {
            if (this.iCl == null) {
                this.iCl = new AddExperiencedModel(getTbPageContext());
            }
            this.iCl.gi(this.forumId, str);
        }
    }

    public boolean cwx() {
        if (this.iBH && !this.iCo) {
            return (this.iBL != null && this.iBL.cBM() && (b.cuL().cuF() || com.baidu.tieba.frs.a.cuE().cuF())) ? false : true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.f.b
    public boolean videoNeedPreload() {
        if (this.iAQ != null) {
            return com.baidu.tbadk.util.ai.rL(2) || (com.baidu.tbadk.util.ai.bBC() && this.iAQ.isFrsVideoAutoPlay);
        }
        return super.videoNeedPreload();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwy() {
        if (!com.baidu.tbadk.core.util.at.isEmpty(this.forumId)) {
            com.baidu.tbadk.BdToken.c.bdF().r(com.baidu.tbadk.BdToken.b.ekk, com.baidu.adp.lib.f.b.toLong(this.forumId, 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwz() {
        String format;
        String str;
        if (isResumed() && this.iCs != null && this.iCs.size() >= 1 && this.iCr <= this.iCs.size() - 1) {
            final LiveHorseRaceData liveHorseRaceData = this.iCs.get(this.iCr);
            if (System.currentTimeMillis() / 1000 >= liveHorseRaceData.getRob_end_tm().longValue()) {
                this.iCr++;
                cwz();
            }
            if (this.iBv != null) {
                final FrsRedpackRunView frsRedpackRunView = new FrsRedpackRunView(getActivity());
                if (liveHorseRaceData.getUser_nickname() == null || TextUtils.isEmpty(liveHorseRaceData.getUser_nickname())) {
                    format = String.format(getResources().getString(R.string.live_horserace_red_envelope), getResources().getString(R.string.frs_horse_none_title_verser));
                } else if (liveHorseRaceData.getUser_nickname().length() > 4) {
                    format = String.format(getResources().getString(R.string.live_horserace_red_envelope), liveHorseRaceData.getUser_nickname().substring(0, 4) + StringHelper.STRING_MORE);
                } else {
                    format = String.format(getResources().getString(R.string.live_horserace_red_envelope), liveHorseRaceData.getUser_nickname());
                }
                frsRedpackRunView.settextTitle(format + format + format);
                frsRedpackRunView.setClickliner(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.50
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        String str2;
                        if (FrsFragment.this.iAQ == null) {
                            str2 = "";
                        } else if (FrsFragment.this.iAQ.getForum() != null) {
                            str2 = FrsFragment.this.iAQ.getForum().getName();
                        } else {
                            str2 = "";
                        }
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13744").aj("obj_source", 1).dR("fid", FrsFragment.this.forumId).dR("fname", str2));
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
                this.iCt = ValueAnimator.ofFloat(1.0f, 0.0f);
                this.iCt.setDuration(600L);
                this.iCt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.FrsFragment.51
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        if (valueAnimator.isRunning()) {
                            frsRedpackRunView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                            frsRedpackRunView.setTranslationX(-(TbadkApplication.getInst().getContext().getResources().getDimensionPixelOffset(R.dimen.tbds850) * valueAnimator.getAnimatedFraction()));
                        }
                    }
                });
                this.iCt.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.FrsFragment.52
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        frsRedpackRunView.setAlpha(0.0f);
                        frsRedpackRunView.setTranslationY(TbadkApplication.getInst().getContext().getResources().getDimensionPixelOffset(R.dimen.tbds660));
                        frsRedpackRunView.hide();
                        FrsFragment.this.iBv.removeView(frsRedpackRunView);
                        if (FrsFragment.this.iCr > FrsFragment.this.iCs.size() - 1) {
                            FrsFragment.this.iBv.removeAllViews();
                            FrsFragment.this.iBv.setVisibility(8);
                            FrsFragment.this.iCr = 0;
                            return;
                        }
                        FrsFragment.this.cwz();
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        onAnimationEnd(animator);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                this.iCu = new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.53
                    @Override // java.lang.Runnable
                    public void run() {
                        if (FrsFragment.this.iBv != null && frsRedpackRunView != null) {
                            FrsFragment.this.iCt.start();
                        }
                    }
                };
                com.baidu.adp.lib.f.e.mY().postDelayed(this.iCu, 5000L);
                if (this.iBv.getChildCount() == 0) {
                    this.iCr++;
                    this.iBv.addView(frsRedpackRunView);
                    if (this.iAQ != null) {
                        str = this.iAQ.getForum() != null ? this.iAQ.getForum().getName() : "";
                    } else {
                        str = "";
                    }
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13743").aj("obj_source", 1).dR("fid", this.forumId).dR("fname", str));
                }
                if (this.iBv.getVisibility() == 8 && ((BaseFragment) this.iBN.cDR().fragment).isPrimary() && !this.iBs.cxv() && !this.iBB) {
                    this.iBv.setVisibility(0);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        FrsTabViewController.b cDR;
        if (cvI() == null || (cDR = cvI().cDR()) == null || !(cDR.fragment instanceof BaseFragment)) {
            return null;
        }
        if (cDR.fragment instanceof FrsAllThreadFragment) {
            TbPageTag tbPageTag = super.getTbPageTag();
            int i = -1;
            if (this.iAQ != null) {
                i = this.iAQ.getSortType();
            }
            tbPageTag.sortType = com.baidu.tieba.frs.f.i.Ag(i);
            tbPageTag.locatePage = "a070";
            if (this.iBd.equals(cDR.title)) {
                tbPageTag.locatePage = "a071";
            }
            return tbPageTag;
        } else if (cDR.fragment instanceof FrsFragment) {
            return null;
        } else {
            return ((BaseFragment) cDR.fragment).getTbPageTag();
        }
    }

    public void cwA() {
        if (this.iAQ != null) {
            com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
            if (this.iAQ.needLog == 1) {
                bVar.iZE = true;
            } else {
                bVar.iZE = false;
            }
            if (this.iAQ.getForum() != null) {
                bVar.iZG = this.iAQ.getForum().getId();
            }
            if (cvF() != null) {
                bVar.iZF = cvF().cBQ();
            }
            if (com.baidu.tieba.frs.d.d.iLo != null) {
                bVar.iZH = com.baidu.tieba.frs.d.d.iLo.iZH;
                bVar.iZI = com.baidu.tieba.frs.d.d.iLo.iZI;
            }
            this.iCv = new com.baidu.tieba.frs.live.b(bVar, getTbPageTag(), getUniqueId());
            this.iCv.zJ(this.iCx);
            CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_CARD_CLICK, this.iCv);
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
            CustomMessageTask customMessageTask2 = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW, this.iCv);
            customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask2);
            CustomMessageTask customMessageTask3 = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_USER_CLICK, this.iCv);
            customMessageTask3.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask3);
            CustomMessageTask customMessageTask4 = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_VIDEO_CLICK, this.iCv);
            customMessageTask4.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask4);
        }
    }
}
