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
public class FrsFragment extends BaseFragment implements BdListView.e, a.InterfaceC0250a, UserIconBox.b<BdRecyclerView>, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, aq, at, aw, com.baidu.tieba.frs.loadmore.a, com.baidu.tieba.frs.mc.l, com.baidu.tieba.recapp.n {
    public static com.baidu.tieba.tbadkCore.m iHt;
    private com.baidu.adp.lib.d.b<TbImageView> eXS;
    private com.baidu.tbadk.util.aa fza;
    private com.baidu.tieba.frs.gametab.b gDl;
    private String iHF;
    private com.baidu.card.am iHH;
    private FrsModelController iHI;
    private com.baidu.tieba.frs.vc.h iHJ;
    private FrsTabViewController iHK;
    private com.baidu.tieba.frs.mc.h iHL;
    private com.baidu.tieba.frs.smartsort.a iHM;
    private com.baidu.tieba.frs.mc.b iHN;
    private ax iHO;
    private com.baidu.tieba.frs.entelechy.b.b iHQ;
    private com.baidu.tieba.frs.vc.a iHR;
    private com.baidu.tieba.frs.mc.d iHS;
    private com.baidu.tieba.frs.mc.c iHT;
    private com.baidu.tieba.frs.vc.j iHU;
    private com.baidu.tieba.frs.mc.a iHV;
    private com.baidu.tieba.frs.live.a iHW;
    private p iHX;
    public com.baidu.tieba.frs.vc.c iHY;
    private com.baidu.tieba.frs.mc.e iHZ;
    private com.baidu.tieba.frs.entelechy.a iHb;
    private com.baidu.tieba.tbadkCore.data.f iHl;
    private VoiceManager iHo;
    private OvalActionButton iHq;
    private FRSRefreshButton iHr;
    private LinearLayout iHs;
    public long iHu;
    private int iIE;
    private View.OnTouchListener iIa;
    private com.baidu.tieba.frs.view.a iIb;
    private com.baidu.tieba.frs.vc.e iIc;
    private boolean iId;
    private com.baidu.tieba.NEGFeedBack.a iIe;
    private com.baidu.tieba.ala.a iIf;
    private com.baidu.tieba.frs.brand.buttommenu.a iIg;
    private com.baidu.tieba.frs.sportspage.notification.a iIh;
    private AddExperiencedModel iIi;
    private boolean iIk;
    private List<LiveHorseRaceData> iIp;
    private ValueAnimator iIq;
    private Runnable iIr;
    private com.baidu.tieba.frs.live.b iIs;
    private com.baidu.tieba.frs.broadcast.a iIt;
    private int iIu;
    private com.baidu.tbadk.core.dialog.a iaq;
    private View mRootView;
    private String mSchemeUrl;
    public static boolean iHg = false;
    public static volatile long iHw = 0;
    public static volatile long iHx = 0;
    public static volatile int mNetError = 0;
    private String iHa = "";
    public boolean iHc = false;
    private boolean iHd = false;
    private boolean iHe = false;
    private boolean iHf = true;
    public String iHh = null;
    public String mFrom = null;
    public int mFlag = 0;
    public boolean iHi = false;
    private boolean iHj = false;
    private String mThreadId = null;
    public String forumId = null;
    private int iGP = 0;
    private boolean iHk = false;
    private boolean iHm = false;
    private boolean iHn = false;
    private q iHp = null;
    public final bw akq = null;
    private FrsViewData iGN = new FrsViewData();
    public long ijR = -1;
    public long fvq = 0;
    public long fvg = 0;
    public long createTime = 0;
    public long fvh = 0;
    public long fvn = 0;
    public long iHv = 0;
    boolean iHy = false;
    public boolean iHz = false;
    private boolean iHA = false;
    private boolean iHB = false;
    public com.baidu.tbadk.n.b iHC = null;
    private boolean iHD = true;
    private boolean iHE = true;
    private a.C0097a iHG = new a.C0097a(2);
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> iHP = new SparseArray<>();
    private boolean gmh = true;
    private boolean hasInit = false;
    private boolean iIj = false;
    private boolean iIl = false;
    private Date iIm = null;
    private int dJG = 0;
    private int iIn = 0;
    private int iIo = 0;
    public int mHeadLineDefaultNavTabId = -1;
    MessageQueue.IdleHandler iIv = new MessageQueue.IdleHandler() { // from class: com.baidu.tieba.frs.FrsFragment.1
        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            FrsFragment.this.cyz();
            return false;
        }
    };
    private final CustomMessageListener iIw = new CustomMessageListener(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED) { // from class: com.baidu.tieba.frs.FrsFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof bw) {
                    com.baidu.tieba.frs.f.j.a(FrsFragment.this.iHp, FrsFragment.this.iGN, FrsFragment.this.getForumId(), true, (bw) data);
                }
            }
        }
    };
    private CustomMessageListener iIx = new CustomMessageListener(CmdConfigCustom.CMD_CLOSE_GAME_RANK_CARD) { // from class: com.baidu.tieba.frs.FrsFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.iGN != null) {
                FrsFragment.this.iGN.removeGameRankListFromThreadList();
                if (FrsFragment.this.iHp != null) {
                    FrsFragment.this.iHp.bar();
                }
            }
        }
    };
    private CustomMessageListener agB = new CustomMessageListener(2921401) { // from class: com.baidu.tieba.frs.FrsFragment.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && FrsFragment.this.iHr != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() <= 0 || FrsFragment.this.iHK.cGv() == 0 || FrsFragment.this.iHK.cGs() == null || !(FrsFragment.this.iHK.cGs().fragment instanceof BaseFragment) || !((BaseFragment) FrsFragment.this.iHK.cGs().fragment).isPrimary() || FrsFragment.this.iHp.czW() || KuangFloatingFrsCopyLinkViewController.getInstance().isFloatCopyViewShow()) {
                    if (FrsFragment.this.iHK.cGv() != 0) {
                        FrsFragment.this.iHr.hide();
                        return;
                    }
                    return;
                }
                FrsFragment.this.iHr.show();
            }
        }
    };
    private CustomMessageListener iIy = new CustomMessageListener(2921473) { // from class: com.baidu.tieba.frs.FrsFragment.45
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && FrsFragment.this.iHr != null && FrsFragment.this.iHq != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() == 0) {
                    FrsFragment.this.iHr.setVisibility(8);
                    FrsFragment.this.iHq.setVisibility(8);
                    return;
                }
                FrsFragment.this.iHq.setVisibility(0);
            }
        }
    };
    private CustomMessageListener iIz = new CustomMessageListener(2921467) { // from class: com.baidu.tieba.frs.FrsFragment.56
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && FrsFragment.this.iHr != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() <= 0 || FrsFragment.this.iHK.cGs() == null || !(FrsFragment.this.iHK.cGs().fragment instanceof BaseFragment) || !((BaseFragment) FrsFragment.this.iHK.cGs().fragment).isPrimary() || FrsFragment.this.iHp.czW()) {
                    FrsFragment.this.iHs.setVisibility(8);
                    FrsFragment.this.iHy = true;
                    return;
                }
                FrsFragment.this.iHs.setVisibility(0);
                FrsFragment.this.iHy = false;
            }
        }
    };
    private com.baidu.adp.framework.listener.a iIA = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_FRS_LIVE_HORSE_RACE_LIST, 309667) { // from class: com.baidu.tieba.frs.FrsFragment.60
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if ((responsedMessage instanceof GetLiveHorseRaceHttpResponseMessage) || (responsedMessage instanceof GetLiveHorseRaceSocketResponseMessage)) {
                    List<LiveHorseRaceData> arrayList = new ArrayList<>();
                    if (responsedMessage instanceof GetLiveHorseRaceHttpResponseMessage) {
                        arrayList = ((GetLiveHorseRaceHttpResponseMessage) responsedMessage).getData().cAx();
                    }
                    if (responsedMessage instanceof GetLiveHorseRaceSocketResponseMessage) {
                        arrayList = ((GetLiveHorseRaceSocketResponseMessage) responsedMessage).getData().cAx();
                    }
                    if (FrsFragment.this.iIp != null) {
                        if (FrsFragment.this.iHs.getVisibility() != 8) {
                            if (FrsFragment.this.iIo >= FrsFragment.this.iIp.size()) {
                                FrsFragment.this.iIp.addAll(arrayList);
                                return;
                            }
                            FrsFragment.this.iIp = FrsFragment.this.iIp.subList(0, FrsFragment.this.iIo);
                            FrsFragment.this.iIp.addAll(arrayList);
                            return;
                        }
                        FrsFragment.this.iIp = new ArrayList();
                        FrsFragment.this.iIp.addAll(arrayList);
                        FrsFragment.this.iIo = 0;
                        FrsFragment.this.cza();
                        return;
                    }
                    FrsFragment.this.iIp = new ArrayList();
                    FrsFragment.this.iIo = 0;
                    FrsFragment.this.iIp.addAll(arrayList);
                    FrsFragment.this.cza();
                }
            }
        }
    };
    private CustomMessageListener iIB = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.FrsFragment.61
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 1) {
                    FrsFragment.this.cyD();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                }
            }
        }
    };
    private final av iIC = new av() { // from class: com.baidu.tieba.frs.FrsFragment.62
        @Override // com.baidu.tieba.frs.av
        public void a(int i, int i2, bd bdVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
            FrsFragment.this.cyo();
            if (FrsFragment.this.iHQ != null) {
                FrsFragment.this.iHJ.qu(FrsFragment.this.iHQ.zt(i));
            }
            com.baidu.tieba.tbadkCore.f fVar = new com.baidu.tieba.tbadkCore.f();
            if (bdVar != null) {
                fVar.isSuccess = bdVar.errCode == 0;
                fVar.errorCode = bdVar.errCode;
                fVar.errorMsg = bdVar.errMsg;
                if (fVar.isSuccess) {
                    if (com.baidu.tbadk.core.util.y.isEmpty(arrayList)) {
                        FrsFragment.this.iHp.bPW();
                    } else if (bdVar.hasMore) {
                        if (com.baidu.tbadk.core.util.y.getCount(FrsFragment.this.iGN.getThreadList()) > 3) {
                            FrsFragment.this.iHp.Wi();
                        } else {
                            FrsFragment.this.iHp.czN();
                        }
                    } else if (bdVar.iMo) {
                        FrsFragment.this.iHp.Wj();
                    } else {
                        FrsFragment.this.iHp.bPW();
                    }
                }
            } else {
                bdVar = new bd();
                bdVar.pn = 1;
                bdVar.hasMore = false;
                bdVar.iMo = false;
            }
            if (i == 1) {
                FrsFragment.this.iHD = true;
                FrsFragment.this.iIT.a(FrsFragment.this.iHI.getType(), false, fVar);
            } else {
                FrsFragment.this.a(fVar);
                if (FrsFragment.this.iHI.cDN() != null) {
                    FrsFragment.this.iGN = FrsFragment.this.iHI.cDN();
                }
                FrsFragment.this.cyF();
            }
            if (FrsFragment.this.iJb != null) {
                FrsFragment.this.iJb.a(i, i2, bdVar, arrayList);
            }
        }
    };
    private FrsTabViewController.a iID = new FrsTabViewController.a() { // from class: com.baidu.tieba.frs.FrsFragment.2
        @Override // com.baidu.tieba.frs.vc.FrsTabViewController.a
        public void cl(int i, int i2) {
            boolean z = false;
            if (i != 1) {
                com.baidu.tieba.card.t.cor().oy(false);
                FrsFragment.this.pr(false);
            }
            if (i == 502) {
                FrsFragment.this.iHq.setIconFade(R.drawable.btn_frs_professional_edit_n);
            } else {
                FrsFragment.this.iHq.setIconFade(0);
            }
            FrsFragment.this.iIE = i;
            FrsFragment.this.iIu = i2;
            if (FrsFragment.this.iIs != null) {
                FrsFragment.this.iIs.zW(FrsFragment.this.iIu);
            }
            TbSingleton.getInstance().setFrsCurTabType(FrsFragment.this.iIu);
            FrsFragment.this.cyK();
            com.baidu.tieba.frs.d.d.iRl.jfE = i;
            com.baidu.tieba.frs.d.d.iRl.jfH = i2;
            com.baidu.tieba.frs.d.d.iRl.jfF = -1;
            b.cxm().V(i == 1 && FrsFragment.this.iIj, true);
            com.baidu.tieba.frs.a cxf = com.baidu.tieba.frs.a.cxf();
            if (i == 1 && FrsFragment.this.iIj) {
                z = true;
            }
            cxf.V(z, true);
        }
    };
    private CustomMessageListener iIF = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIVE_COUNT) { // from class: com.baidu.tieba.frs.FrsFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                FrsFragment.this.iHK.AG(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    };
    private CustomMessageListener iIG = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_LIVE_START) { // from class: com.baidu.tieba.frs.FrsFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && ((Integer) customResponsedMessage.getData()).intValue() == 51 && FrsFragment.this.iGN != null) {
                com.baidu.tieba.frs.f.l.a(FrsFragment.this.iGN, FrsFragment.this.getPageContext());
            }
        }
    };
    private final CustomMessageListener iIH = new CustomMessageListener(CmdConfigCustom.CMD_FRS_SELECT_ALA_LIVE_TAB) { // from class: com.baidu.tieba.frs.FrsFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                FrsFragment.this.iHK.tg(49);
            }
        }
    };
    private final CustomMessageListener iII = new CustomMessageListener(2921470) { // from class: com.baidu.tieba.frs.FrsFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                FrsFragment.this.iHK.tg(1);
                FrsFragment.this.cyD();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
            }
        }
    };
    private final CustomMessageListener iIJ = new CustomMessageListener(CmdConfigCustom.CMD_FRS_EXPERIENCE_TIP) { // from class: com.baidu.tieba.frs.FrsFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.v) && FrsFragment.this.iGN != null) {
                FrsFragment.this.iGN.updateLikeData((com.baidu.tieba.tbadkCore.v) customResponsedMessage.getData());
                FrsFragment.this.iHJ.i(FrsFragment.this.iGN);
                FrsFragment.this.iHK.a(FrsFragment.this.iGN, FrsFragment.this.iHI.cEr());
            }
        }
    };
    private final AntiHelper.a iIK = new AntiHelper.a() { // from class: com.baidu.tieba.frs.FrsFragment.8
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).al("obj_locate", ax.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).al("obj_locate", ax.a.LOCATE_LIKE_PERSON));
        }
    };
    private CustomMessageListener iIL = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.FrsFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(FrsFragment.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().feD != null) {
                        if (AntiHelper.a(FrsFragment.this.getActivity(), updateAttentionMessage.getData().feD, FrsFragment.this.iIK) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).al("obj_locate", ax.a.LOCATE_LIKE_PERSON));
                        }
                    } else if (updateAttentionMessage.getData().isSucc && updateAttentionMessage.getData().isAttention) {
                        com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getPageContext().getPageActivity(), R.string.attention_success);
                    }
                }
            }
        }
    };
    private CustomMessageListener iIM = new CustomMessageListener(CmdConfigCustom.CMD_GET_ENSURE_CAST_ID) { // from class: com.baidu.tieba.frs.FrsFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsFragment.this.refresh();
        }
    };
    private CustomMessageListener iIN = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.frs.FrsFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && !((PostWriteCallBackData) customResponsedMessage.getData()).isDyamicCallback()) {
                FrsFragment.this.iHp.c((PostWriteCallBackData) customResponsedMessage.getData());
                if (((PostWriteCallBackData) customResponsedMessage.getData()).getGeneralTabId() >= 0) {
                    FrsFragment.this.iHV.zY(((PostWriteCallBackData) customResponsedMessage.getData()).getGeneralTabId());
                }
            }
        }
    };
    private CustomMessageListener iIO = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_REMIND) { // from class: com.baidu.tieba.frs.FrsFragment.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626) {
                NewsRemindMessage newsRemindMessage = (NewsRemindMessage) customResponsedMessage;
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (FrsFragment.this.iHp != null) {
                    FrsFragment.this.iHp.P(notificationCount, z);
                }
            }
        }
    };
    private HttpMessageListener iIP = new HttpMessageListener(CmdConfigHttp.CMD_FRS_MOVE_AREA) { // from class: com.baidu.tieba.frs.FrsFragment.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int i;
            int i2 = 0;
            if (httpResponsedMessage != null && FrsFragment.this.getContext() != null && FrsFragment.this.iHp != null) {
                if (httpResponsedMessage.getError() == 0) {
                    new BdTopToast(FrsFragment.this.getContext()).yk(true).Ut(FrsFragment.this.getContext().getString(R.string.frs_move_area_move_suc)).aJ(FrsFragment.this.iHp.cka());
                    if (com.baidu.tieba.frs.a.cxf().yz(com.baidu.tieba.frs.a.cxf().cxh())) {
                        FrsCommonTabFragment frsCommonTabFragment = null;
                        if (FrsFragment.this.iHK != null && FrsFragment.this.iHK.cGs() != null && (FrsFragment.this.iHK.cGs().fragment instanceof FrsCommonTabFragment)) {
                            frsCommonTabFragment = (FrsCommonTabFragment) FrsFragment.this.iHK.cGs().fragment;
                        }
                        if (frsCommonTabFragment != null) {
                            frsCommonTabFragment.cBr();
                        }
                        FrsFragment.this.cxk();
                        com.baidu.tieba.frs.a.cxf().cxk();
                        Iterator<com.baidu.adp.widget.ListView.q> it = FrsFragment.this.iGN.getThreadList().iterator();
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
                            FrsFragment.this.bOI();
                        }
                    }
                    com.baidu.tieba.frs.a.cxf().reset();
                    return;
                }
                new BdTopToast(FrsFragment.this.getContext()).yk(false).Ut(httpResponsedMessage.getErrorString()).aJ(FrsFragment.this.iHp.cka());
            }
        }
    };
    private final CustomMessageListener iIQ = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.frs.FrsFragment.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.isResumed()) {
                FrsFragment.this.cyZ();
            }
        }
    };
    private CustomMessageListener iIR = new CustomMessageListener(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER) { // from class: com.baidu.tieba.frs.FrsFragment.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (FrsFragment.this.iHp != null) {
                    FrsFragment.this.iHp.setExpanded(booleanValue);
                }
            }
        }
    };
    private final CustomMessageListener iIS = new CustomMessageListener(2921463) { // from class: com.baidu.tieba.frs.FrsFragment.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TbadkApplication.getInst().getCurrentActivity() != null && !com.baidu.tbadk.core.util.at.isEmpty(str) && str.equals(FrsFragment.this.forumId)) {
                    com.baidu.tieba.frs.f.g.b(((TbPageContextSupport) TbadkApplication.getInst().getCurrentActivity()).getPageContext(), FrsFragment.this.iGN);
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.r iIT = new com.baidu.tieba.tbadkCore.r() { // from class: com.baidu.tieba.frs.FrsFragment.18
        private long startTime = 0;

        @Override // com.baidu.tieba.tbadkCore.r
        public void yG(int i) {
            this.startTime = System.nanoTime();
            if (FrsFragment.this.iHp != null) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsFragment.this.iHp.czx();
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
            if (FrsFragment.this.gmh) {
                FrsFragment.this.gmh = false;
                com.baidu.tieba.frs.f.j.a(FrsFragment.this.iHp, FrsFragment.this.iGN, FrsFragment.this.getForumId(), false, null);
            }
            FrsFragment.this.cyo();
            FrsFragment.this.iHA = true;
            if (fVar != null && fVar.isSuccess) {
                FrsFragment.this.iHp.czK().qb(com.baidu.tbadk.core.util.au.bro().brp());
                FrsFragment.iHw = 0L;
                FrsFragment.iHx = 0L;
                FrsFragment.mNetError = 0;
            } else {
                FrsFragment.mNetError = 1;
            }
            if (!FrsFragment.this.iHI.cEw() && (i == 3 || i == 6)) {
                FrsFragment.this.iHT.resetData();
            }
            FrsFragment.this.iHu = System.currentTimeMillis();
            if (FrsFragment.this.iHI.cDN() != null) {
                FrsFragment.this.iGN = FrsFragment.this.iHI.cDN();
            }
            FrsFragment.this.yC(1);
            FrsFragment.this.cyw();
            if (i == 7) {
                FrsFragment.this.yD(FrsFragment.this.iGN.getFrsDefaultTabId());
                return;
            }
            if (FrsFragment.this.iGN.getPage() != null) {
                FrsFragment.this.setHasMore(FrsFragment.this.iGN.getPage().blq());
            }
            if (i == 4) {
                if (!FrsFragment.this.iHI.cEw() && TbadkCoreApplication.getInst().isRecAppExist() && FrsFragment.this.iHI.cEm() == 1) {
                    FrsFragment.this.iGN.addRecommendAppToThreadList(FrsFragment.this);
                }
                ArrayList<com.baidu.adp.widget.ListView.q> a2 = FrsFragment.this.iHT.a(false, false, FrsFragment.this.iGN.getThreadList(), FrsFragment.this.iHl, false);
                if (a2 != null) {
                    FrsFragment.this.iGN.setThreadList(a2);
                    FrsFragment.this.iGN.checkLiveStageInThreadList();
                }
                if (FrsFragment.this.iHI != null) {
                    com.baidu.tieba.frs.d.c.a(FrsFragment.this.iGN, FrsFragment.this.iHI.cEr(), 2, FrsFragment.this.getContext());
                }
                com.baidu.tieba.frs.f.a.a(FrsFragment.this, FrsFragment.this.iGN.getForum(), FrsFragment.this.iGN.getThreadList(), false, FrsFragment.this.getPn());
                FrsFragment.this.iHp.a(a2, FrsFragment.this.iGN);
                FrsFragment.this.cyp();
                return;
            }
            FrsFragment.this.cyp();
            switch (i) {
                case 1:
                    FrsFragment.this.iHp.czx();
                    break;
                case 2:
                    FrsFragment.this.iHp.czx();
                    break;
                case 3:
                case 6:
                    if (FrsFragment.this.iGN != null) {
                        FrsFragment.this.iGN.clearPostThreadCount();
                    }
                    if (FrsFragment.this.iHY != null) {
                        FrsFragment.this.iHY.refresh();
                        break;
                    }
                    break;
            }
            FrsFragment.this.cyx();
            if (fVar == null || fVar.errorCode == 0) {
                if (FrsFragment.this.iGN != null) {
                    FrsFragment.this.a(FrsFragment.this.iGN);
                    FrsFragment.this.X(false, i == 5);
                    if (FrsFragment.this.iHI != null) {
                        if (FrsFragment.this.iGN.getActivityHeadData() != null && FrsFragment.this.iGN.getActivityHeadData().bkE() != null && FrsFragment.this.iGN.getActivityHeadData().bkE().size() > 0) {
                            com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), 1, FrsFragment.this.iGN.getForum(), FrsFragment.this.iHI.getSortType(), 1);
                        }
                        if (FrsFragment.this.iGN.getThreadList() != null && FrsFragment.this.iGN.getThreadList().size() > 0) {
                            Iterator<com.baidu.adp.widget.ListView.q> it = FrsFragment.this.iGN.getThreadList().iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    com.baidu.adp.widget.ListView.q next = it.next();
                                    if ((next instanceof bw) && ((bw) next).getType() == bw.eFA) {
                                        com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), 1, FrsFragment.this.iGN.getForum(), FrsFragment.this.iHI.getSortType(), 2);
                                    }
                                }
                            }
                        }
                        com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), FrsFragment.this.iGN.getThreadList(), FrsFragment.this.iGN.getForum(), FrsFragment.this.iHI.getSortType());
                    }
                    FrsFragment.this.iHp.yT(i);
                    FrsFragment.iHw = (System.nanoTime() - this.startTime) / TimeUtils.NANOS_PER_MS;
                    if (fVar != null) {
                        FrsFragment.iHx = fVar.mUE;
                    }
                } else {
                    return;
                }
            } else if (FrsFragment.this.iGN == null || com.baidu.tbadk.core.util.y.isEmpty(FrsFragment.this.iGN.getThreadList())) {
                FrsFragment.this.a(fVar);
            } else if (fVar.iro) {
                FrsFragment.this.showToast(FrsFragment.this.getPageContext().getResources().getString(R.string.net_error_text, fVar.errorMsg, Integer.valueOf(fVar.errorCode)));
            }
            FrsFragment.this.cyt();
            FrsFragment.this.cyu();
            if (FrsFragment.this.iGN.getAccessFlag() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11384"));
            }
            if (FrsFragment.this.iHm && FrsFragment.this.iHK.tg(49)) {
                FrsFragment.this.iHm = false;
            }
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.r
        public void c(com.baidu.tieba.tbadkCore.m mVar) {
            if ((mVar != null && ("normal_page".equals(FrsFragment.this.iHI.getPageType()) || "frs_page".equals(FrsFragment.this.iHI.getPageType()) || "book_page".equals(FrsFragment.this.iHI.getPageType()))) || "brand_page".equals(FrsFragment.this.iHI.getPageType())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE, mVar));
                FrsFragment.this.b(mVar);
                FrsFragment.iHt = mVar;
            }
        }

        @Override // com.baidu.tieba.tbadkCore.r
        public void cyz() {
            FrsFragment.this.cyz();
        }
    };
    private final CustomMessageListener iIU = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.frs.FrsFragment.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.m) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                FrsFragment.this.iGN.updateCurrentUserPendant((com.baidu.tbadk.data.m) customResponsedMessage.getData());
                FrsFragment.this.iHp.czK().notifyDataSetChanged();
            }
        }
    };
    private final CustomMessageListener mMemListener = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_MEM) { // from class: com.baidu.tieba.frs.FrsFragment.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && FrsFragment.this.iGN != null && (userData = FrsFragment.this.iGN.getUserData()) != null) {
                userData.setIsMem(num.intValue());
                if (num.intValue() != 0) {
                    FrsFragment.this.iHJ.o(num);
                }
            }
        }
    };
    private final f.a iIV = new AnonymousClass29();
    private final com.baidu.tieba.frs.mc.k iIW = new com.baidu.tieba.frs.mc.k() { // from class: com.baidu.tieba.frs.FrsFragment.30
        @Override // com.baidu.tieba.frs.mc.k
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, boolean z3) {
            if (FrsFragment.this.iHM != null && FrsFragment.this.iHI != null && FrsFragment.this.iHI.cEw() && z && !z2 && !z3) {
                FrsFragment.this.iHM.Ad(i2);
            }
        }
    };
    public final View.OnTouchListener fzb = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.FrsFragment.31
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (FrsFragment.this.iIa != null) {
                FrsFragment.this.iIa.onTouch(view, motionEvent);
            }
            if (FrsFragment.this.iHO != null && FrsFragment.this.iHO.cAy() != null) {
                FrsFragment.this.iHO.cAy().onTouchEvent(motionEvent);
            }
            if (FrsFragment.this.gDl != null) {
                FrsFragment.this.gDl.b(view, motionEvent);
            }
            if (FrsFragment.this.iHJ != null) {
                FrsFragment.this.iHJ.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private final CustomMessageListener iIX = new CustomMessageListener(CmdConfigCustom.CMD_GOTOLIVE_HOST_UPGRADE) { // from class: com.baidu.tieba.frs.FrsFragment.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.bqh().getInt(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.PHOTOLIVE_HOSTLEVEL, -1) != -1 && FrsFragment.this.iGN.getForum() != null) {
                FrsFragment.this.iGN.getForum().setCanAddPhotoLivePost(true);
            }
        }
    };
    public final View.OnClickListener iIY = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.38
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsFragment.this.iHp != null && view == FrsFragment.this.iHp.czv() && FrsFragment.this.getActivity() != null) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, FrsFragment.this.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            if (view.getId() == R.id.game_activity_egg_layout && com.baidu.adp.lib.util.l.isNetOk()) {
                TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_CLICK);
                if (FrsFragment.this.iHp == null || !FrsFragment.this.iHp.czH()) {
                    String activityUrl = FrsFragment.this.iGN.getForum().getYuleData().boU().getActivityUrl();
                    if (!StringUtils.isNull(activityUrl)) {
                        com.baidu.tbadk.browser.a.startInternalWebActivity(FrsFragment.this.getPageContext().getPageActivity(), activityUrl);
                    }
                } else {
                    FrsFragment.this.iHp.czI();
                }
            }
            if (FrsFragment.this.iHp != null && view == FrsFragment.this.iHp.czO() && FrsFragment.this.iHI != null && FrsFragment.this.iHI.hasMore()) {
                FrsFragment.this.iHp.Wi();
                FrsFragment.this.bOI();
            }
            if (view != null && FrsFragment.this.iHp != null && view == FrsFragment.this.iHp.czE()) {
                if (com.baidu.tbadk.core.util.bg.checkUpIsLogin(FrsFragment.this.getContext())) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).al("obj_locate", 2));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MessageCenterActivityConfig(FrsFragment.this.getContext())));
                } else {
                    return;
                }
            }
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (FrsFragment.this.iGN != null && FrsFragment.this.iGN.getForum() != null) {
                    if (FrsFragment.this.iHp != null && view == FrsFragment.this.iHp.czC()) {
                        if (FrsFragment.this.iGN != null && FrsFragment.this.iGN.getForum() != null && !StringUtils.isNull(FrsFragment.this.iGN.getForum().getId()) && !StringUtils.isNull(FrsFragment.this.iGN.getForum().getName())) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_SHARE_CLICK).dR("fid", FrsFragment.this.iGN.getForum().getId()).al("obj_locate", 11));
                            com.baidu.tieba.frs.f.g.a(FrsFragment.this.getPageContext(), FrsFragment.this.iGN, FrsFragment.this.iGN.getForum().getId());
                        } else {
                            return;
                        }
                    }
                    if (FrsFragment.this.iHp != null && view == FrsFragment.this.iHp.czB()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12402").dR("fid", FrsFragment.this.iGN.getForum().getId()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fname", FrsFragment.this.iGN.getForum().getName()));
                        if (!StringUtils.isNull(FrsFragment.this.iGN.getForum().getName())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PostSearchActivityConfig(FrsFragment.this.getContext(), FrsFragment.this.iGN.getForum().getName(), FrsFragment.this.iGN.getForum().getId())));
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
        private int iJw = 0;
        private int ghW = 0;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsFragment.this.iIn += i2;
            if (FrsFragment.this.iIn >= FrsFragment.this.dJG * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
            if (FrsFragment.this.iHR != null) {
                FrsFragment.this.iHR.cFo();
            }
            this.iJw = 0;
            this.ghW = 0;
            if (recyclerView != null && (recyclerView instanceof BdRecyclerView)) {
                this.iJw = ((BdRecyclerView) recyclerView).getFirstVisiblePosition();
                this.ghW = ((BdRecyclerView) recyclerView).getLastVisiblePosition();
            }
            if (FrsFragment.this.iIc != null) {
                FrsFragment.this.iIc.a(recyclerView, this.iJw, this.ghW);
            }
            if (FrsFragment.this.iGN != null && FrsFragment.this.iHp != null && FrsFragment.this.iHp.czK() != null) {
                FrsFragment.this.iHp.co(this.iJw, this.ghW);
                if (FrsFragment.this.iHH != null && FrsFragment.this.iHH.tW() != null) {
                    FrsFragment.this.iHH.tW().b(FrsFragment.this.iHG);
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (FrsFragment.this.iHJ != null) {
                FrsFragment.this.iHJ.setScrollState(i);
            }
            if ((i == 2 || i == 1) && !FrsFragment.this.iHB) {
                FrsFragment.this.iHB = true;
                FrsFragment.this.iHp.czM();
            }
            if (FrsFragment.this.iHC == null && !FrsFragment.this.cyS()) {
                FrsFragment.this.iHC = new com.baidu.tbadk.n.b();
                FrsFragment.this.iHC.setSubType(1000);
            }
            if (i == 0) {
                if (FrsFragment.this.iHC != null) {
                    FrsFragment.this.iHC.bCl();
                }
                com.baidu.tieba.card.t.cor().oy(true);
                FrsFragment.this.pr(true);
                FrsFragment.this.iHp.cn(this.iJw, this.ghW);
            } else if (FrsFragment.this.iHC != null) {
                FrsFragment.this.iHC.bCk();
            }
            if (FrsFragment.this.iIc != null) {
                FrsFragment.this.iIc.onScrollStateChanged(recyclerView, i);
            }
            if (i == 0) {
                com.baidu.tieba.frs.f.j.a(FrsFragment.this.iHp, FrsFragment.this.iGN, FrsFragment.this.getForumId(), false, null);
            }
            if (FrsFragment.this.iHK != null && i == 1) {
                FrsFragment.this.iHK.cGu();
            }
            if (FrsFragment.this.iHH == null) {
                if (FrsFragment.this.iHp.czo() != null && !FrsFragment.this.iHp.cyQ() && FrsFragment.this.iHp.czo().dwW() != null && (FrsFragment.this.iHp.czo().dwW().getTag() instanceof com.baidu.card.am)) {
                    FrsFragment.this.iHH = (com.baidu.card.am) FrsFragment.this.iHp.czo().dwW().getTag();
                }
            } else if (i == 0 && FrsFragment.this.iHp.czo() != null && !FrsFragment.this.iHp.cyQ() && FrsFragment.this.iHp.czo().dwW() != null && (FrsFragment.this.iHp.czo().dwW().getTag() instanceof com.baidu.card.am)) {
                FrsFragment.this.iHH = (com.baidu.card.am) FrsFragment.this.iHp.czo().dwW().getTag();
            }
            if (i == 1) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921418));
            }
        }
    };
    private final f iIZ = new f() { // from class: com.baidu.tieba.frs.FrsFragment.40
        @Override // com.baidu.tieba.frs.f
        public void a(int i, int i2, View view, View view2, bw bwVar) {
            if (i != FrsFragment.this.iHp.czK().cCd()) {
                if (i != FrsFragment.this.iHp.czK().cCe()) {
                    if (i == FrsFragment.this.iHp.czK().cCb() && FrsFragment.this.iGN != null && FrsFragment.this.iGN.getUserData() != null && FrsFragment.this.iGN.getUserData().isBawu()) {
                        String bawuCenterUrl = FrsFragment.this.iGN.getBawuCenterUrl();
                        if (!com.baidu.tbadk.core.util.at.isEmpty(bawuCenterUrl) && FrsFragment.this.iGN.getForum() != null) {
                            com.baidu.tbadk.browser.a.startWebActivity(FrsFragment.this.getPageContext().getPageActivity(), bawuCenterUrl);
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10502").dR("fid", FrsFragment.this.iGN.getForum().getId()).dR("uid", FrsFragment.this.iGN.getUserData().getUserId()));
                        }
                    }
                } else if (com.baidu.tbadk.core.util.bg.checkUpIsLogin(FrsFragment.this.getPageContext().getPageActivity())) {
                    TiebaStatic.log(CommonStatisticKey.MY_SERVICE_CK);
                    if (FrsFragment.this.iGN != null && FrsFragment.this.iGN.getForum() != null) {
                        ForumData forum = FrsFragment.this.iGN.getForum();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(forum.getId(), 0L), forum.getName(), forum.getImage_url(), 0)));
                    }
                }
            } else if (com.baidu.tbadk.core.util.bg.checkUpIsLogin(FrsFragment.this.getActivity())) {
                TiebaStatic.log("forum_fortune_click");
                com.baidu.tieba.frs.f.k.c(FrsFragment.this.getPageContext(), FrsFragment.this.iGN);
            }
        }
    };
    private final NoNetworkView.a iEz = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.FrsFragment.41
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (FrsFragment.this.iHI.cEm() == 1 && z && !FrsFragment.this.iHp.cyQ()) {
                if (FrsFragment.this.iGN == null || com.baidu.tbadk.core.util.y.isEmpty(FrsFragment.this.iGN.getThreadList())) {
                    FrsFragment.this.hideNetRefreshView(FrsFragment.this.iHp.czZ().cGi());
                    FrsFragment.this.showLoadingView(FrsFragment.this.iHp.cka(), true);
                    FrsFragment.this.iHp.pB(false);
                    FrsFragment.this.refresh();
                    return;
                }
                FrsFragment.this.iHp.czx();
            }
        }
    };
    private final CustomMessageListener feV = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.FrsFragment.42
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                com.baidu.tieba.frs.f.c.a(customResponsedMessage, FrsFragment.this.iHp, FrsFragment.this.iGN);
            }
        }
    };
    private com.baidu.adp.widget.ListView.ab iJa = new a();
    private av iJb = new av() { // from class: com.baidu.tieba.frs.FrsFragment.44
        @Override // com.baidu.tieba.frs.av
        public void a(int i, int i2, bd bdVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
            com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.44.1
                @Override // java.lang.Runnable
                public void run() {
                    if (FrsFragment.this.iHp != null && FrsFragment.this.iHp.czR()) {
                        FrsFragment.this.bOI();
                    }
                }
            });
        }
    };
    private CustomMessageListener iJc = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.frs.FrsFragment.46
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    FrsFragment.this.iId = true;
                }
            }
        }
    };
    private CustomMessageListener iJd = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.frs.FrsFragment.47
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                    if (FrsFragment.this.iHH == null && FrsFragment.this.iHp.czo() != null && !FrsFragment.this.iHp.cyQ() && FrsFragment.this.iHp.czo().dwW() != null && (FrsFragment.this.iHp.czo().dwW().getTag() instanceof com.baidu.card.am)) {
                        FrsFragment.this.iHH = (com.baidu.card.am) FrsFragment.this.iHp.czo().dwW().getTag();
                    }
                    if (FrsFragment.this.iHH != null && FrsFragment.this.iHH.tW() != null) {
                        FrsFragment.this.iHH.tW().b(new a.C0097a(3));
                    }
                }
            }
        }
    };
    private CustomMessageListener iJe = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.FrsFragment.48
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.iHp != null) {
                FrsFragment.this.iHp.GI();
            }
        }
    };
    private CustomMessageListener iJf = new CustomMessageListener(2921437) { // from class: com.baidu.tieba.frs.FrsFragment.49
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && FrsFragment.this.isResumed()) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (FrsFragment.this.iHr != null) {
                    if (booleanValue) {
                        if (FrsFragment.this.iHK.cGv() != 0 && !FrsFragment.this.iHp.czW() && !KuangFloatingFrsCopyLinkViewController.getInstance().isFloatCopyViewShow()) {
                            FrsFragment.this.iHr.show();
                            return;
                        }
                        return;
                    }
                    FrsFragment.this.iHr.hide();
                }
            }
        }
    };
    private CustomMessageListener iJg = new CustomMessageListener(2921462) { // from class: com.baidu.tieba.frs.FrsFragment.54
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && FrsFragment.this.iGN.getToLoadHorseData().intValue() == 1 && FrsFragment.this.mIsLogin) {
                LiveHorseRaceRequestMessage liveHorseRaceRequestMessage = new LiveHorseRaceRequestMessage();
                liveHorseRaceRequestMessage.setForum_id(Long.valueOf(FrsFragment.this.forumId));
                FrsFragment.this.sendMessage(liveHorseRaceRequestMessage);
            }
        }
    };
    private CustomMessageListener iJh = new CustomMessageListener(2001223) { // from class: com.baidu.tieba.frs.FrsFragment.55
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Date)) {
                FrsFragment.this.iIm = (Date) customResponsedMessage.getData();
            }
        }
    };
    private CustomMessageListener iJi = new CustomMessageListener(2921469) { // from class: com.baidu.tieba.frs.FrsFragment.57
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.x) && FrsFragment.this.isResumed()) {
                com.baidu.tbadk.core.data.x xVar = (com.baidu.tbadk.core.data.x) customResponsedMessage.getData();
                if (FrsFragment.this.iIt == null) {
                    FrsFragment.this.iIt = new com.baidu.tieba.frs.broadcast.a(FrsFragment.this.getPageContext());
                }
                if (FrsFragment.this.iGN != null && FrsFragment.this.iGN.getForum() != null && !TextUtils.isEmpty(FrsFragment.this.iGN.getForum().getId())) {
                    FrsFragment.this.iIt.e(xVar.type, FrsFragment.this.iGN.getForum().getId(), FrsFragment.this.iGN.getForum().getName(), xVar.tid);
                }
            }
        }
    };
    private CustomMessageListener iJj = new CustomMessageListener(2921475) { // from class: com.baidu.tieba.frs.FrsFragment.58
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bw bwVar = (bw) customResponsedMessage.getData();
            if (bwVar != null && FrsFragment.this.isResumed()) {
                FrsFragment.this.iHF = bwVar.getTid() + "";
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE_NUMBER);
                httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
                httpMessage.addParam("forum_id", bwVar.getFid());
                MessageManager.getInstance().sendMessage(httpMessage);
            }
        }
    };
    private HttpMessageListener iJk = new HttpMessageListener(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE_NUMBER) { // from class: com.baidu.tieba.frs.FrsFragment.59
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if ((httpResponsedMessage instanceof ForumManagerRightsResMsg) && FrsFragment.this.isResumed()) {
                ForumManagerRightsResMsg forumManagerRightsResMsg = (ForumManagerRightsResMsg) httpResponsedMessage;
                if (forumManagerRightsResMsg.broadcastTotalCount - forumManagerRightsResMsg.broadcastUsedCount <= 0) {
                    new ScreenTopToast(FrsFragment.this.getContext()).Ux(FrsFragment.this.getString(R.string.frs_forum_bawu_send_broadcast_none_tip)).Uz(FrsFragment.this.getString(R.string.frs_recommend_fail_tip_btn)).al(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.59.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("_forumId", FrsFragment.this.iGN.getForum().getId());
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new com.baidu.tieba.tbadkCore.data.m(FrsFragment.this.getContext(), "ForumGradePage", hashMap)));
                        }
                    }).aJ((ViewGroup) FrsFragment.this.mRootView.findViewById(R.id.frs));
                    return;
                }
                com.baidu.tbadk.core.util.o oVar = new com.baidu.tbadk.core.util.o(TbadkCoreApplication.getInst());
                oVar.aj(FrsFragment.this.iGN.getForum().getId(), FrsFragment.this.iGN.getForum().getName(), "6");
                oVar.BK(FrsFragment.this.iHF);
                oVar.start();
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.frs.loadmore.a
    public /* bridge */ /* synthetic */ com.baidu.adp.base.e getPageContext() {
        return super.getPageContext();
    }

    public com.baidu.tieba.frs.entelechy.b.b cyc() {
        return this.iHQ;
    }

    public com.baidu.adp.widget.ListView.ab cyd() {
        return this.iJa;
    }

    public com.baidu.tieba.frs.mc.d cye() {
        return this.iHS;
    }

    public com.baidu.tieba.frs.smartsort.a cyf() {
        return this.iHM;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public FrsModelController cyg() {
        return this.iHI;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public com.baidu.tieba.frs.mc.c cyh() {
        return this.iHT;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public com.baidu.tieba.frs.vc.h cyi() {
        return this.iHJ;
    }

    public FrsTabViewController cyj() {
        return this.iHK;
    }

    public ax cyk() {
        return this.iHO;
    }

    public void pq(boolean z) {
        this.iIl = z;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public q cyl() {
        return this.iHp;
    }

    @Override // com.baidu.tieba.frs.aw
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.aw, com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.iHh;
    }

    public void setForumName(String str) {
        this.iHh = str;
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
        if (this.iHT == null) {
            return 1;
        }
        return this.iHT.getPn();
    }

    public int getPn() {
        if (this.iHT == null) {
            return 1;
        }
        return this.iHT.getPn();
    }

    public void setPn(int i) {
        if (this.iHT != null) {
            this.iHT.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.iHT != null) {
            this.iHT.setHasMore(i);
        }
    }

    public int cym() {
        if (this.iHT == null) {
            return -1;
        }
        return this.iHT.cym();
    }

    public boolean cyn() {
        return this.iHn;
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
            this.iHp.czr();
            showNetRefreshView(this.iHp.cka(), string, true);
        } else if (340001 == fVar.errorCode) {
            a(fVar, this.iGN.getRecm_forum_list());
        } else {
            if (com.baidu.tbadk.core.util.y.isEmpty(this.iGN.getThreadList())) {
                b(fVar);
            }
            if (cyS()) {
                setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds280));
            } else {
                setNetRefreshViewEmotionDefMarginTop();
            }
        }
    }

    public void a(View view, String str, boolean z, List<RecmForumInfo> list) {
        this.iHp.czr();
        this.iHp.yN(8);
        if (this.iIb == null) {
            this.iIb = new com.baidu.tieba.frs.view.a(getPageContext(), getNetRefreshListener());
        }
        this.iIb.setSubText(str);
        this.iIb.setListData(list);
        this.iIb.attachView(view, z);
    }

    private void a(com.baidu.tieba.tbadkCore.f fVar, List<RecmForumInfo> list) {
        if (this.iHp != null) {
            this.iHp.czr();
            this.iHp.setTitle(this.iHh);
            a(this.iHp.cka(), fVar.errorMsg, true, list);
        }
    }

    private void b(com.baidu.tieba.tbadkCore.f fVar) {
        this.iHp.czr();
        if (fVar.iro) {
            showNetRefreshView(this.iHp.cka(), TbadkCoreApplication.getInst().getString(R.string.net_error_text, new Object[]{fVar.errorMsg, Integer.valueOf(fVar.errorCode)}), true);
        } else {
            showNetRefreshView(this.iHp.czZ().cGi(), fVar.errorMsg, true);
        }
    }

    public void cyo() {
        hideLoadingView(this.iHp.cka());
        this.iHp.bPh();
        if (this.iHp.czp() instanceof com.baidu.tieba.frs.tab.c) {
            ((com.baidu.tieba.frs.tab.c) this.iHp.czp()).cET();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyp() {
        if (cym() == 0 && com.baidu.tbadk.core.util.y.isEmpty(this.iGN.getThreadListIds())) {
            if (com.baidu.tbadk.core.util.y.isEmpty(this.iGN.getThreadList())) {
                this.iHp.bPW();
            } else {
                this.iHp.Wj();
            }
        } else if (com.baidu.tbadk.core.util.y.getCount(this.iGN.getThreadList()) > 3) {
            this.iHp.Wi();
        } else {
            this.iHp.czN();
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
            cyo();
            this.iHp.czx();
            com.baidu.tieba.tbadkCore.f cEi = this.iHI.cEi();
            boolean isEmpty = com.baidu.tbadk.core.util.y.isEmpty(this.iGN.getThreadList());
            if (cEi != null && isEmpty) {
                if (this.iHI.cEk() != 0) {
                    this.iHI.cEp();
                    this.iHp.czx();
                } else {
                    a(cEi);
                }
                this.iHp.Y(this.iGN.isStarForum(), false);
                return;
            }
            a(cEi);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(com.baidu.tieba.tbadkCore.m mVar) {
        if (mVar != null && mVar.getEntelechyTabInfo() != null && mVar.getEntelechyTabInfo().tab != null) {
            for (FrsTabInfo frsTabInfo : mVar.getEntelechyTabInfo().tab) {
                if (frsTabInfo.tab_id.intValue() == 502 && com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean("first_into_tab_profession", true)) {
                    return false;
                }
            }
        }
        return new com.baidu.tieba.frs.ad.f(getTbPageContext()).d(mVar);
    }

    public boolean cyq() {
        return cyr() && !cys();
    }

    private boolean cyr() {
        if (cyP() == null) {
            return false;
        }
        FrsViewData cyP = cyP();
        com.baidu.tbadk.core.data.y yVar = null;
        if (cyP.getStar() != null && !StringUtils.isNull(cyP.getStar().dJm())) {
            yVar = new com.baidu.tbadk.core.data.y();
        } else if (cyP.getActivityHeadData() != null && com.baidu.tbadk.core.util.y.getCount(cyP.getActivityHeadData().bkE()) >= 1) {
            yVar = cyP.getActivityHeadData().bkE().get(0);
        }
        return yVar != null;
    }

    public boolean cys() {
        if (cyP() == null) {
            return false;
        }
        FrsViewData cyP = cyP();
        return (com.baidu.tbadk.core.util.y.isEmpty(cyP.getShowTopThreadList()) && cyP.getBusinessPromot() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyt() {
        boolean b;
        if (!cyv()) {
            final PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
            privateForumPopInfoData.a(this.iGN.getPrivateForumTotalInfo().getPrivatePopInfo());
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(getActivity());
            if (this.iGN.getPrivateForumTotalInfo().blx().private_forum_status.intValue() == 1 && (com.baidu.tbadk.core.util.at.isEmpty(privateForumPopInfoData.blz()) || privateForumPopInfoData.blC() != Integer.valueOf(this.forumId))) {
                privateForumPopInfoData.AR("create_success");
                privateForumPopInfoData.AS(TbadkCoreApplication.getInst().getString(R.string.frs_private_create_hint));
                privateForumPopInfoData.AT("https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.iHh + "&nomenu=1");
                privateForumPopInfoData.k(Integer.valueOf(this.forumId));
                b = frsPrivateCommonDialogView.b(privateForumPopInfoData);
            } else {
                b = privateForumPopInfoData.blC() == Integer.valueOf(this.forumId) ? frsPrivateCommonDialogView.b(privateForumPopInfoData) : false;
            }
            if (b) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
                aVar.oz(2);
                aVar.bf(frsPrivateCommonDialogView);
                aVar.iW(false);
                frsPrivateCommonDialogView.setConfirmButton(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.19
                    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.frs.FrsFragment */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        com.baidu.tbadk.core.util.be.brr().b(FrsFragment.this.getPageContext(), new String[]{privateForumPopInfoData.blB()});
                        aVar.dismiss();
                    }
                });
                aVar.a(new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.20
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(getPageContext()).bpc();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyu() {
        if (cyv() || this.iGN.getPrivateForumTotalInfo().blx().private_forum_status.intValue() != 1) {
            a((Integer) null, (Integer) null, true);
        } else {
            a(this.iGN.getPrivateForumTotalInfo().blx().private_forum_audit_status, this.iGN.getPrivateForumTotalInfo().bly(), false);
        }
    }

    public void a(Integer num, Integer num2, boolean z) {
        final String str;
        final int i = 2;
        if (this.iHp.czD() != null) {
            TextView czD = this.iHp.czD();
            if (z) {
                czD.setVisibility(8);
                return;
            }
            if (num.intValue() == 2) {
                czD.setText("修改实名认证信息");
                czD.setVisibility(0);
                str = "https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + this.forumId + "&nomenu=1";
            } else if (num2.intValue() >= 0 && num2.intValue() <= 100) {
                czD.setText("目标已完成" + String.valueOf(num2) + "%");
                czD.setVisibility(0);
                str = "https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.iHh + "&nomenu=1";
                i = 1;
            } else {
                czD.setVisibility(8);
                i = 0;
                str = "";
            }
            czD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.21
                /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13387").dR("fid", FrsFragment.this.forumId).dR("uid", TbadkCoreApplication.getCurrentAccount()).al("obj_type", i));
                    com.baidu.tbadk.core.util.be.brr().b(FrsFragment.this.getPageContext(), new String[]{str});
                }
            });
        }
    }

    private boolean cyv() {
        return this.iGN == null || this.iGN.getPrivateForumTotalInfo() == null || this.iGN.getPrivateForumTotalInfo().blx() == null || this.iGN.getUserData().getIs_manager() != 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yC(int i) {
        List<WindowToast> list;
        if (TbadkCoreApplication.isLogin() && this.iGN != null && (list = this.iGN.mWindowToast) != null && list.size() > 0) {
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
    public void cyw() {
        if (getActivity() != null && getActivity().getIntent() != null) {
            String stringExtra = getActivity().getIntent().getStringExtra(FrsActivityConfig.KEY_ACHIEVEMENT_URL);
            if (!TextUtils.isEmpty(stringExtra)) {
                getActivity().getIntent().removeExtra(FrsActivityConfig.KEY_ACHIEVEMENT_URL);
                AchievementActivityConfig achievementActivityConfig = new AchievementActivityConfig(getActivity());
                achievementActivityConfig.setUrl(stringExtra);
                if (this.iGN != null && this.iGN.getForumActiveInfo() != null) {
                    achievementActivityConfig.setShareUrl(this.iGN.getForumActiveInfo().forum_share_url);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, achievementActivityConfig));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyx() {
        if (this.iGN == null || this.iGN.getForum() != null) {
            this.iHp.czJ();
        } else if (this.iGN.getForum().getYuleData() != null && this.iGN.getForum().getYuleData().boT()) {
            TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_VIEW);
            this.iHp.a(this.iGN.getForum().getYuleData().boU());
        } else {
            this.iHp.czJ();
        }
    }

    private void W(boolean z, boolean z2) {
        if (this.iHI != null && this.iGN != null && this.iHp != null && z) {
            if (!this.iHI.cEw() && this.iHI.cEm() == 1) {
                if (!this.iHI.cEu()) {
                    this.iGN.addCardVideoInfoToThreadList();
                    this.iGN.addVideoInfoToThreadListInTenAndFifteenFloor();
                }
                boolean z3 = false;
                if (this.iHp.czK().r(com.baidu.tieba.card.data.o.ibS)) {
                    z3 = this.iGN.addHotTopicDataToThreadList();
                }
                if (!z3) {
                    this.iGN.addFeedForumDataToThreadList();
                }
                if (TbadkCoreApplication.getInst().isRecAppExist()) {
                    this.iGN.addRecommendAppToThreadList(this);
                }
                if (!this.iHp.czK().r(bw.eDX)) {
                    this.iGN.removeAlaLiveThreadData();
                }
                this.iGN.addSchoolRecommendToThreadList();
            }
            if (!this.iHp.czK().r(bw.eDX)) {
                this.iGN.removeAlaInsertLiveData();
                this.iGN.removeAlaStageLiveDat();
            } else {
                this.iGN.addInsertLiveDataToThreadList();
                this.iGN.addStageLiveDataToThreadList();
            }
            this.iGN.checkLiveStageInThreadList();
            this.iGN.addNoticeThreadToThreadList();
            if (this.iHp.czK().r(com.baidu.tieba.h.b.jpE)) {
                this.iGN.addGameRankListToThreadList(z2);
            }
            if (TbadkCoreApplication.isLogin() && (!this.iHI.cEw() || this.iHI.isNetFirstLoad)) {
                this.iGN.addUserRecommendToThreadList();
            }
            this.iGN.addVideoActivityToTop();
        }
    }

    public boolean cyy() {
        if (this.iHJ != null && this.iHI != null) {
            this.iHJ.a(this.iHI.getPageType(), this.iGN);
        }
        boolean z = false;
        if (this.iGN != null) {
            z = this.iGN.hasTab();
        }
        cyB();
        if (this.iHp != null) {
            this.iHp.czX();
            this.iHp.czY();
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yD(int i) {
        ba baVar = null;
        cyy();
        cyK();
        try {
            if (this.iGN != null) {
                this.iHp.a((ArrayList<com.baidu.adp.widget.ListView.q>) null, this.iGN);
                this.iHJ.Aw(1);
                this.iHp.czA();
                this.iHK.a(this.iGN, this.iHI.cEr());
                com.baidu.tieba.frs.tab.d AF = this.iHK.AF(this.iGN.getFrsDefaultTabId());
                if (AF != null && !TextUtils.isEmpty(AF.url)) {
                    baVar = new ba();
                    baVar.ext = AF.url;
                    baVar.stType = AF.name;
                }
                this.iHI.a(this.iGN.getFrsDefaultTabId(), 0, baVar);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(boolean z, boolean z2) {
        try {
            if (this.iGN != null && this.iHK != null && this.iHI != null) {
                if (!this.iHp.czK().r(bw.eDX)) {
                    this.iGN.removeAlaLiveThreadData();
                }
                boolean isEmpty = com.baidu.tbadk.core.util.y.isEmpty(this.iGN.getGameTabInfo());
                this.iHp.pz(isEmpty);
                if (!isEmpty) {
                    if (this.iIc == null) {
                        this.iIc = new com.baidu.tieba.frs.vc.e(this, (NoPressedRelativeLayout) this.mRootView);
                    }
                    if (this.gDl == null) {
                        this.gDl = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
                    }
                } else {
                    this.iIc = null;
                    this.gDl = null;
                }
                if (this.iGN.getForum() != null) {
                    this.iHh = this.iGN.getForum().getName();
                    this.forumId = this.iGN.getForum().getId();
                }
                if (this.iGN.hasTab()) {
                    this.iHK.a(this.iGN, this.iHI.cEr());
                }
                if (z) {
                    W(true, z);
                } else {
                    W(this.iHD, z);
                }
                cyy();
                if (this.iHQ != null) {
                    this.iHQ.a(this.iHJ, this.iGN);
                }
                if (this.iGN.getPage() != null) {
                    setHasMore(this.iGN.getPage().blq());
                }
                ArrayList<com.baidu.adp.widget.ListView.q> a2 = this.iHT.a(z2, true, this.iGN.getThreadList(), null, z, false);
                if (a2 != null) {
                    this.iGN.setThreadList(a2);
                }
                this.iGN.removeRedundantUserRecommendData();
                this.iGP = this.iGN.getTopThreadSize();
                if (this.iHl != null) {
                    this.iHk = true;
                    this.iHl.Jz(this.iGP);
                    com.baidu.tieba.frs.f.a.a(this, this.iGN.getForum(), this.iGN.getThreadList(), this.iHk, getPn());
                }
                if (this.iHI.cEm() == 1) {
                    cyF();
                    if (!z && this.iHI.getPn() == 1) {
                        cyA();
                    }
                }
                if (this.iHR != null) {
                    this.iHR.cI(this.iHK.cGr());
                }
                cyo();
                this.iHp.czs();
                this.iHp.Y(true, false);
                if (z && this.iGN.isFirstTabEqualAllThread()) {
                    com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.22
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!FrsFragment.this.iHA && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                FrsFragment.this.iHp.czV();
                            }
                        }
                    });
                }
                if (this.iGN.getForum() != null) {
                    this.iHp.Kr(this.iGN.getForum().getWarningMsg());
                }
                if (this.iGN != null && this.iGN.getFrsVideoActivityData() != null && com.baidu.tbadk.core.sharedPref.b.bqh().getLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 0L) == 0) {
                    com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.24
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsFragment.this.iHp.czT();
                        }
                    }, 1000L);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FRS_SHOW_AR_ENTRY, this));
                this.iHp.czm();
                if (this.iGN != null && this.iGN.getForum() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ENTER_FORUM, new VisitedForumData(this.iGN.getForum().getId(), this.iGN.getForum().getName(), this.iGN.getForum().getImage_url(), String.valueOf(System.currentTimeMillis() / 1000), ConstantData.Forum.SPECAIL_FORUM_TYPE_LIVE.equals(this.iGN.getForum().special_forum_type), this.iGN.getForum().getThemeColorInfo(), this.iGN.getForum().getMember_num())));
                }
                this.iIg.a(this.iGN.bottomMenuList, this.iGN.getForum());
                cyZ();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void cyz() {
        if (this.iHI != null && this.iHI.cEm() == 1) {
            this.iHJ.j(this.iGN);
        }
    }

    public void pr(boolean z) {
        com.baidu.tieba.s.c.dIX().b(getUniqueId(), z);
    }

    public void cyA() {
        if (this.iHW == null) {
            this.iHW = new com.baidu.tieba.frs.live.a(this, com.baidu.adp.lib.f.b.toInt(this.forumId, 0));
        }
        this.iHW.cDT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.tbadkCore.m mVar) {
        try {
            if (!this.iHA && mVar != null && this.iGN != null) {
                this.iGN.receiveData(mVar);
                X(true, false);
                Looper.myQueue().addIdleHandler(this.iIv);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void cyB() {
        if (this.iHI != null) {
            Kq(this.iHI.getPageType());
        } else {
            Kq("normal_page");
        }
    }

    private void Kq(String str) {
        ps("frs_page".equals(str));
        if (this.iHQ != null) {
            this.iHQ.a(this.iHJ, this.iHp, this.iGN);
        }
    }

    public void ps(boolean z) {
        if (this.iHU != null) {
            this.iHU.cGd();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.s.c.dIX().z(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.frs_activity, viewGroup, false);
            this.iHb = new com.baidu.tieba.frs.entelechy.a();
            this.iHQ = this.iHb.cBG();
            this.iHa = TbadkCoreApplication.getInst().getString(R.string.frs_title_new_area);
            this.iHJ = new com.baidu.tieba.frs.vc.h(this, this.iHb, (FrsHeaderViewContainer) this.mRootView.findViewById(R.id.header_view_container));
            this.iHK = new FrsTabViewController(this, this.mRootView);
            this.iHK.registerListener();
            this.iHJ.a(this.iHK);
            this.iHK.a(this.iID);
            Intent intent = getActivity().getIntent();
            if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                this.iHd = true;
            }
            this.iHp = new q(this, this.iIY, this.iHb, this.iHd, this.iHJ);
            this.iIg = new com.baidu.tieba.frs.brand.buttommenu.a(getPageContext(), this.mRootView);
        } else {
            if (this.mRootView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            if (this.iHK != null) {
                this.iHK.registerListener();
            }
            this.iHp.czS();
            this.mRootView.setLeft(0);
            this.mRootView.setRight(com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getContext()));
        }
        this.iIk = true;
        this.fvh = System.currentTimeMillis() - currentTimeMillis;
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        ArrayList<com.baidu.adp.widget.ListView.q> arrayList = null;
        this.ijR = System.currentTimeMillis();
        long j = this.ijR;
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.iHm = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.ijR = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            R(intent);
        }
        this.fvg = j - this.ijR;
        this.iHl = new com.baidu.tieba.tbadkCore.data.f("frs", com.baidu.tieba.tbadkCore.data.f.mWp);
        if (this.iHI == null) {
            this.iHI = new FrsModelController(this, this.iIT);
            this.iHI.a(this.iIC);
            this.iHI.init();
        }
        this.iHI.setSchemeUrl(this.mSchemeUrl);
        if (intent != null) {
            this.iHI.aj(intent.getExtras());
        } else if (bundle != null) {
            this.iHI.aj(bundle);
        } else {
            this.iHI.aj(null);
        }
        if (intent != null) {
            this.iHJ.aq(intent.getExtras());
        } else if (bundle != null) {
            this.iHJ.aq(bundle);
        } else {
            this.iHJ.aq(null);
        }
        this.iHo = getVoiceManager();
        this.iHX = new p(getPageContext(), this);
        initUI();
        initData(bundle);
        if (!cyS()) {
            this.iHO = new ax(getActivity(), this.iHp, this.iHJ);
            this.iHO.pO(true);
        }
        this.iHo = getVoiceManager();
        if (this.iHo != null) {
            this.iHo.onCreate(getPageContext());
        }
        if (FrsActivityConfig.FRS_FROM_FLUTTER_BCASTEDIT.equals(getFrom()) && !this.hasInit) {
            int i = com.baidu.tbadk.core.sharedPref.b.bqh().getInt("key_forum_broadcast_edit_tip_number", 0);
            if (i < 2) {
                com.baidu.tbadk.core.sharedPref.b.bqh().putInt("key_forum_broadcast_edit_tip_number", i + 1);
                cyH();
            } else if (Build.VERSION.SDK_INT >= 23) {
                if (Settings.canDrawOverlays(getContext())) {
                    cyI();
                } else {
                    new BdTopToast(getContext()).yk(false).Ut(getContext().getString(R.string.forum_broadcast_copy_no_permission_hint)).aJ(this.iHp.cka());
                }
            } else {
                cyI();
            }
        }
        if (KuangFloatingFrsCopyLinkViewController.getInstance().isFloatCopyViewShow()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
            if (this.iHq != null) {
                this.iHq.setVisibility(8);
            }
        }
        new com.baidu.tieba.frs.mc.i();
        int i2 = -1;
        if (this.iHT != null && this.iHT.cEe() != null) {
            i2 = this.iHT.cEe().cym();
            arrayList = this.iHT.cEe().getDataList();
        }
        this.iHT = new com.baidu.tieba.frs.mc.c(this, this.iIW);
        this.iHT.cEe().setHasMore(i2);
        if (arrayList != null && arrayList.size() > 0) {
            this.iHT.cEe().aF(arrayList);
        }
        this.iHM = new com.baidu.tieba.frs.smartsort.a(this);
        this.iHU = new com.baidu.tieba.frs.vc.j(this);
        this.iHR = new com.baidu.tieba.frs.vc.a(getPageContext(), this.iHI.cEt());
        this.iHN = new com.baidu.tieba.frs.mc.b(this);
        this.iHS = new com.baidu.tieba.frs.mc.d(this);
        this.iHL = new com.baidu.tieba.frs.mc.h(this);
        this.iHV = new com.baidu.tieba.frs.mc.a(this);
        this.iHY = new com.baidu.tieba.frs.vc.c(this);
        this.iHZ = new com.baidu.tieba.frs.mc.e(this, getUniqueId());
        this.iIe = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "frs");
        this.iIf = new com.baidu.tieba.ala.a(getPageContext());
        this.iIh = new com.baidu.tieba.frs.sportspage.notification.a(getPageContext());
        registerListener(this.iIL);
        registerListener(this.mMemListener);
        registerListener(this.iIJ);
        registerListener(this.iIX);
        registerListener(this.iIU);
        registerListener(this.iIF);
        registerListener(this.iIG);
        registerListener(this.iIH);
        registerListener(this.iII);
        registerListener(this.iIw);
        registerListener(this.iIx);
        registerListener(this.agB);
        registerListener(this.iIy);
        registerListener(this.iJc);
        registerListener(this.iIN);
        registerListener(this.iIB);
        registerListener(this.iIO);
        registerListener(this.iIM);
        registerListener(this.iIQ);
        registerListener(this.iIR);
        registerListener(this.iIS);
        this.iJd.setTag(getPageContext().getUniqueId());
        MessageManager.getInstance().registerListener(this.iJd);
        registerListener(this.iJe);
        registerListener(this.iJf);
        registerListener(this.iJg);
        registerListener(this.iIA);
        registerListener(this.iJh);
        registerListener(this.iIP);
        registerListener(this.iIz);
        registerListener(this.iJi);
        registerListener(this.iJj);
        registerListener(this.iJk);
        this.iHp.pB(false);
        if (!cyS() && !this.hasInit) {
            showLoadingView(this.iHp.cka(), true);
            this.iHI.T(3, false);
        }
        ay ayVar = new ay() { // from class: com.baidu.tieba.frs.FrsFragment.27
            @Override // com.baidu.tieba.frs.ay
            public void d(boolean z, boolean z2, int i3) {
                if (FrsFragment.this.iHp != null) {
                    if (i3 == 1) {
                        FrsFragment.this.iHp.yO(z ? 0 : 8);
                    } else if (i3 == 2) {
                        FrsFragment.this.iHp.yQ(z ? 0 : 8);
                    }
                    if (!z2) {
                        FrsFragment.this.iIj = z;
                    }
                    if (FrsFragment.this.iHp.czK() != null && (i3 == 2 || (FrsFragment.this.iHI != null && FrsFragment.this.iHI.cEn()))) {
                        FrsFragment.this.iHp.czK().notifyDataSetChanged();
                    }
                    if (FrsFragment.this.cyj() != null) {
                        FrsTabViewController.b cGs = FrsFragment.this.cyj().cGs();
                        if (cGs != null) {
                            if ((cGs.fragment instanceof FrsCommonTabFragment) && (i3 == 2 || cGs.tabId == 502)) {
                                ((FrsCommonTabFragment) cGs.fragment).cBw();
                            } else if ((cGs.fragment instanceof FrsNewAreaFragment) && (i3 == 2 || cGs.tabId == 503)) {
                                FrsNewAreaFragment frsNewAreaFragment = (FrsNewAreaFragment) cGs.fragment;
                                frsNewAreaFragment.cBw();
                                if (frsNewAreaFragment.cEE() != null) {
                                    com.baidu.tieba.frs.mc.g cEE = frsNewAreaFragment.cEE();
                                    cEE.pQ(!z);
                                    if (i3 == 1) {
                                        cEE.pE(!z);
                                    } else if (i3 == 2) {
                                        cEE.pE(true);
                                    }
                                }
                            } else if (cGs.fragment instanceof FrsGoodFragment) {
                                ((FrsGoodFragment) cGs.fragment).cBw();
                            }
                        }
                        if (FrsFragment.this.cyj().cGj() != null) {
                            FrsFragment.this.cyj().cGj().setmDisallowSlip(z);
                            FrsFragment.this.cyj().qv(z);
                        }
                    }
                    if (FrsFragment.this.iHp.czq() != null) {
                        FrsFragment.this.iHp.py(!z);
                    }
                    if (FrsFragment.this.getActivity() instanceof FrsActivity) {
                        ((FrsActivity) FrsFragment.this.getActivity()).pp(!z);
                    }
                    if (FrsFragment.this.iIg != null) {
                        FrsFragment.this.iIg.pW(!z);
                    }
                    FrsFragment.this.iHp.pD(!z);
                    if (i3 == 1) {
                        FrsFragment.this.iHp.pE(z ? false : true);
                    } else if (i3 == 2) {
                        FrsFragment.this.iHp.pE(true);
                    }
                }
            }

            @Override // com.baidu.tieba.frs.ay
            public void cm(int i3, int i4) {
                if (FrsFragment.this.iHp != null) {
                    if (i4 == 1) {
                        FrsFragment.this.iHp.yP(i3);
                    } else if (i4 == 2) {
                        FrsFragment.this.iHp.yR(i3);
                    }
                }
            }

            @Override // com.baidu.tieba.frs.ay
            public void yH(int i3) {
                if (FrsFragment.this.getContext() != null) {
                    if (i3 == 1) {
                        com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getContext(), R.string.frs_multi_delete_max_num);
                    } else if (i3 == 2 && FrsFragment.this.iHp != null) {
                        new BdTopToast(FrsFragment.this.getContext()).yk(false).Ut(FrsFragment.this.getContext().getString(R.string.frs_move_area_max_num)).aJ(FrsFragment.this.iHp.cka());
                    }
                }
            }
        };
        b.cxm().a(ayVar);
        com.baidu.tieba.frs.a.cxf().a(ayVar);
        this.iHp.b(new d.a() { // from class: com.baidu.tieba.frs.FrsFragment.28
            @Override // com.baidu.tieba.NEGFeedBack.d.a
            public void a(DeleteThreadHttpResponseMessage deleteThreadHttpResponseMessage) {
                boolean z;
                int i3 = 0;
                if (deleteThreadHttpResponseMessage != null) {
                    FrsFragment.this.iHp.bIw();
                    FrsFragment.this.iHp.czU();
                    FrsNewAreaFragment frsNewAreaFragment = null;
                    if (FrsFragment.this.iHK == null || FrsFragment.this.iHK.cGs() == null || !(FrsFragment.this.iHK.cGs().fragment instanceof FrsNewAreaFragment)) {
                        z = false;
                    } else {
                        frsNewAreaFragment = (FrsNewAreaFragment) FrsFragment.this.iHK.cGs().fragment;
                        z = true;
                    }
                    if (deleteThreadHttpResponseMessage.getError() == 0) {
                        String text = !TextUtils.isEmpty(deleteThreadHttpResponseMessage.getText()) ? deleteThreadHttpResponseMessage.getText() : FrsFragment.this.getString(R.string.delete_fail);
                        if (deleteThreadHttpResponseMessage.getRetType() == 1211066) {
                            if (FrsFragment.this.iaq == null) {
                                FrsFragment.this.iaq = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.iaq.Bo(text);
                            FrsFragment.this.iaq.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.28.1
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.iaq.iW(false);
                            FrsFragment.this.iaq.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.iaq.bpc();
                        } else if (deleteThreadHttpResponseMessage.getRetType() == 1211067) {
                            if (FrsFragment.this.iaq == null) {
                                FrsFragment.this.iaq = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.iaq.Bo(text);
                            FrsFragment.this.iaq.a(R.string.know, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.28.2
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.iaq.iW(false);
                            FrsFragment.this.iaq.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.iaq.bpc();
                        } else {
                            FrsFragment.this.iHp.aP(deleteThreadHttpResponseMessage.getText(), ContextCompat.getColor(FrsFragment.this.getContext(), deleteThreadHttpResponseMessage.getRetType() == 1 ? R.color.nav_bar_tip_error : R.color.cp_link_tip_a_alpha95));
                        }
                        if (z && frsNewAreaFragment != null) {
                            frsNewAreaFragment.dp(deleteThreadHttpResponseMessage.getSuccessItems());
                        }
                        FrsFragment.this.dd(deleteThreadHttpResponseMessage.getSuccessItems());
                        b.cxm().dc(deleteThreadHttpResponseMessage.getSuccessItems());
                        for (com.baidu.adp.widget.ListView.q qVar : FrsFragment.this.iGN.getThreadList()) {
                            if (qVar instanceof bv) {
                                i3++;
                                continue;
                            }
                            if (i3 >= 6) {
                                break;
                            }
                        }
                        if (i3 < 6) {
                            FrsFragment.this.bOI();
                            return;
                        }
                        return;
                    }
                    com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getActivity(), deleteThreadHttpResponseMessage.getErrorString());
                }
            }
        });
        this.dJG = UtilHelper.getScreenHeight(getActivity());
        this.hasInit = true;
        yE(1);
        super.onActivityCreated(bundle);
        this.createTime = System.currentTimeMillis() - j;
    }

    public void pt(boolean z) {
        if (this.iHK != null) {
            this.iHK.jjV = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dd(List<String> list) {
        if (!com.baidu.tbadk.core.util.y.isEmpty(list)) {
            ArrayList<com.baidu.adp.widget.ListView.q> threadList = this.iGN.getThreadList();
            if (!com.baidu.tbadk.core.util.y.isEmpty(threadList) && this.iHp.getListView() != null && this.iHp.getListView().getData() != null) {
                Iterator<com.baidu.adp.widget.ListView.q> it = threadList.iterator();
                List<com.baidu.adp.widget.ListView.q> data = this.iHp.getListView().getData();
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.q next = it.next();
                    if (next instanceof bv) {
                        bw bwVar = ((bv) next).exA;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= list.size()) {
                                break;
                            } else if (!com.baidu.tbadk.core.util.at.equals(list.get(i2), bwVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.iHT.d(next);
                                this.iHp.getListView().getAdapter().notifyItemRemoved(i);
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
    public void cxk() {
        if (!com.baidu.tbadk.core.util.y.isEmpty(com.baidu.tieba.frs.a.cxf().cxj()) && this.iHp.getListView() != null && this.iHp.getListView().getData() != null) {
            ArrayList<com.baidu.adp.widget.ListView.q> threadList = this.iGN.getThreadList();
            if (!com.baidu.tbadk.core.util.y.isEmpty(threadList)) {
                Iterator<com.baidu.adp.widget.ListView.q> it = threadList.iterator();
                List<com.baidu.adp.widget.ListView.q> data = this.iHp.getListView().getData();
                int count = com.baidu.tbadk.core.util.y.getCount(com.baidu.tieba.frs.a.cxf().cxj());
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.q next = it.next();
                    if (next instanceof bv) {
                        bw bwVar = ((bv) next).exA;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= count) {
                                break;
                            } else if (!com.baidu.tbadk.core.util.at.equals(com.baidu.tieba.frs.a.cxf().cxj().get(i2).getId(), bwVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.iHT.d(next);
                                this.iHp.getListView().getAdapter().notifyItemRemoved(i);
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
    public void bPc() {
        if (isAdded() && this.gmh && !isLoadingViewAttached()) {
            showLoadingView(this.iHp.cka(), true);
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void bPd() {
        if (isAdded() && this.gmh && isLoadingViewAttached()) {
            hideLoadingView(this.iHp.cka());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (cyS()) {
            showLoadingView(this.iHp.cka(), true);
            this.iHp.yS(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.iHI.S(3, true);
            bta().scrollToPosition(0);
        }
    }

    private void yE(int i) {
        String str = "";
        if (this.iGN != null && this.iGN.getForum() != null) {
            str = this.iGN.getForum().getId();
        }
        if (!StringUtils.isNull(str)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13008").dR("fid", str).dR("obj_type", "4").al("obj_locate", i).dR("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.ab abVar) {
        if (abVar != null) {
            this.fza = abVar.bDS();
            this.iIa = abVar.bDT();
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void showFloatingView() {
        if (this.fza != null) {
            this.fza.showFloatingView(true);
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
                this.iHh = uri.getQueryParameter("name");
                this.mFrom = uri.getQueryParameter("from");
                if (!StringUtils.isNull(this.iHh)) {
                    intent.putExtra("name", this.iHh);
                }
                if (!StringUtils.isNull(this.mFrom)) {
                    intent.putExtra("from", this.mFrom);
                }
                TiebaStatic.log(TbadkCoreStatisticKey.AS_INVOKE_TIEBA);
            }
            if (StringUtils.isNull(this.iHh) && uri != null) {
                if (com.baidu.tbadk.BdToken.f.p(uri)) {
                    com.baidu.tbadk.BdToken.f.bgz().b(uri, this.iIV);
                } else {
                    com.baidu.tieba.frs.f.f U = com.baidu.tieba.frs.f.k.U(intent);
                    if (U != null) {
                        this.iHh = U.forumName;
                        if (U.jhA == null || U.jhA.equals("aidou")) {
                        }
                    }
                }
                if (!StringUtils.isNull(this.iHh)) {
                    intent.putExtra("name", this.iHh);
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
                if (hashMap.get(com.baidu.tbadk.BdToken.f.erH) instanceof String) {
                    FrsFragment.this.iHh = (String) hashMap.get(com.baidu.tbadk.BdToken.f.erH);
                }
                if ((hashMap.get(com.baidu.tbadk.BdToken.f.erZ) instanceof String) && !TextUtils.isEmpty((String) hashMap.get(com.baidu.tbadk.BdToken.f.erZ))) {
                    com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.29.1
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsFragment.this.iHK.tg(301);
                            final long j = com.baidu.adp.lib.f.b.toLong((String) hashMap.get(com.baidu.tbadk.BdToken.f.erI), 0L);
                            final int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
                            final int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
                            final float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                            final int i = 1;
                            if (com.baidu.tbadk.core.util.au.bro().brp()) {
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
        this.iHo = getVoiceManager();
        if (this.iHo != null) {
            this.iHo.onStart(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        Intent intent;
        long j = 0;
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.feV);
        if (bundle != null) {
            this.iHh = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            j = bundle.getLong(FrsActivityConfig.FRS_FAKE_THREAD_ID, 0L);
        } else if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
            this.iHh = intent.getStringExtra("name");
            this.mFrom = intent.getStringExtra("from");
            this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
            j = intent.getLongExtra(FrsActivityConfig.FRS_FAKE_THREAD_ID, 0L);
        }
        if (getArguments() != null) {
            this.iHi = getArguments().getBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, false);
        }
        if (TextUtils.isEmpty(this.mFrom) || FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
        }
        if (this.mIsLogin) {
            registerListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL, this.feV);
        }
        this.iHJ.aq(bundle);
        fE(j);
    }

    private void fE(final long j) {
        if (j > 0) {
            final int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
            final int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
            final float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            final int i = 1;
            if (com.baidu.tbadk.core.util.au.bro().brp()) {
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
        com.baidu.tieba.s.c.dIX().A(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.iJc);
        this.iHU.destroy();
        iHt = null;
        if (this.iHo != null) {
            this.iHo.onDestory(getPageContext());
        }
        com.baidu.tieba.recapp.report.a.remove("FRS");
        this.iHo = null;
        com.baidu.tieba.card.t.cor().oy(false);
        if (this.iGN != null && this.iGN.getForum() != null) {
            ak.cAu().fF(com.baidu.adp.lib.f.b.toLong(this.iGN.getForum().getId(), 0L));
        }
        if (this.iHW != null) {
            this.iHW.onDestory();
        }
        if (this.iHp != null) {
            com.baidu.tieba.frs.f.j.a(this.iHp, this.iGN, getForumId(), false, null);
            this.iHp.onDestroy();
        }
        if (this.iHs != null) {
            this.iHs.removeAllViews();
            this.iHs.setVisibility(8);
        }
        if (this.iIq != null) {
            this.iIq.cancel();
        }
        if (this.iIr != null) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.iIr);
        }
        this.iIp = null;
        super.onDestroy();
        try {
            if (this.iHC != null) {
                this.iHC.bCm();
            }
            if (this.iHp != null) {
                this.iHp.release();
            }
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.iHJ.cDL();
        Looper.myQueue().removeIdleHandler(this.iIv);
        if (this.iHI != null) {
            this.iHI.bVV();
        }
        if (this.iHO != null) {
            this.iHO.cAC();
        }
        if (this.iHR != null) {
            this.iHR.destory();
        }
        if (this.iHM != null) {
            this.iHM.onDestroy();
        }
        if (this.iIc != null) {
            this.iIc.onDestory();
        }
        if (this.iHV != null) {
            this.iHV.onDestroy();
        }
        if (this.iIe != null) {
            this.iIe.onDestroy();
        }
        if (this.iIf != null) {
            this.iIf.onDestroy();
        }
        com.baidu.tieba.recapp.d.a.dBc().dBf();
        com.baidu.tieba.frs.f.l.cFl();
        if (this.iHK != null) {
            this.iHK.a((FrsTabViewController.a) null);
            this.iHK.cGu();
        }
        if (this.iIi != null) {
            this.iIi.onDestroy();
        }
        b.cxm().a(null);
        com.baidu.tieba.frs.a.cxf().a(null);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.iHh);
        bundle.putString("from", this.mFrom);
        this.iHI.onSaveInstanceState(bundle);
        if (this.iHo != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            this.iHo.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.iHV != null) {
            this.iHV.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.iHp != null) {
            this.iHp.czx();
            this.iHp.onResume();
        }
        this.iHL.qn(true);
        this.iHD = true;
        if (iHg) {
            iHg = false;
            if (this.iHp != null) {
                this.iHp.startPullRefresh();
                return;
            }
            return;
        }
        if (this.iHo != null) {
            this.iHo.onResume(getPageContext());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_RESUME));
        if (this.iHp != null) {
            this.iHp.pF(false);
        }
        if (this.iId) {
            refresh(6);
            this.iId = false;
        }
        if (this.iIm != null && getActivity() != null) {
            if (NotificationManagerCompat.from(getActivity()).areNotificationsEnabled()) {
                com.baidu.tbadk.coreExtra.messageCenter.f.bwR().setSignAlertOn(true);
                com.baidu.tbadk.coreExtra.messageCenter.f.bwR().setSignAlertTime(this.iIm.getHours(), this.iIm.getMinutes());
                if (this.iHp != null) {
                    com.baidu.tbadk.coreExtra.messageCenter.f.bwR().a(getTbPageContext().getPageActivity(), this.iHp.cka());
                }
            }
            this.iIm = null;
        }
        cyZ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
    }

    public boolean cyC() {
        Intent intent;
        if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
            return false;
        }
        return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
    }

    public void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.iHh = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.iHj = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.iHj) {
                cyD();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyD() {
        this.iHp.startPullRefresh();
    }

    public void closeActivity() {
        com.baidu.tieba.frs.f.k.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.mFrom);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.iHp.setTitle(this.iHh);
        } else {
            this.iHp.setTitle("");
            this.mFlag = 1;
        }
        this.iHp.a(this.iJa);
        this.iHp.addOnScrollListener(this.mScrollListener);
        this.iHp.g(this.iEz);
        this.iHp.czK().a(this.iIZ);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.iIk) {
            this.iHp.onChangeSkinType(i);
            this.iHJ.Av(i);
            this.iHK.onChangeSkinType(i);
            if (this.iHr != null) {
                this.iHr.onChangeSkinType(i);
            }
            if (this.iIb != null) {
                this.iIb.onChangeSkinType();
            }
            if (this.iIg != null) {
                this.iIg.onChangeSkinType(getPageContext(), i);
            }
            if (this.iaq != null) {
                com.baidu.tbadk.r.a.a(getPageContext(), this.iaq.getRealView());
            }
            if (this.iIc != null) {
                this.iIc.onChangeSkinType(getPageContext(), i);
            }
        }
    }

    public void yF(int i) {
        if (!this.mIsLogin) {
            if (this.iGN != null && this.iGN.getAnti() != null) {
                this.iGN.getAnti().setIfpost(1);
            }
            if (i == 0) {
                com.baidu.tbadk.core.util.bg.skipToLoginActivity(getActivity());
            }
        } else if (this.iGN != null) {
            if (i == 0) {
                com.baidu.tieba.frs.f.l.g(this, 0);
            } else {
                this.iHp.czz();
            }
        }
    }

    public void refresh() {
        com.baidu.tieba.a.d.bIR().EY("page_frs");
        refresh(3);
    }

    public void refresh(int i) {
        this.iHA = false;
        cyK();
        if (this.iHp != null && this.iHp.czo() != null) {
            this.iHp.czo().cKn();
        }
        if (this.iHI != null) {
            this.iHI.S(i, true);
        }
    }

    private void cyE() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.f.h.mZ().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.35
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.SV(FrsFragment.this.iHh);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyF() {
        cyK();
        try {
            if (this.iGN != null) {
                this.iHp.bVq();
                this.iHp.py(cyY());
                if (!com.baidu.tieba.frs.vc.h.m(this.iGN) || !com.baidu.tieba.frs.vc.h.l(this.iGN)) {
                }
                if (this.iGN.getForum() != null) {
                    this.iHh = this.iGN.getForum().getName();
                    this.forumId = this.iGN.getForum().getId();
                }
                if (this.iGN.getPage() != null) {
                    setHasMore(this.iGN.getPage().blq());
                }
                this.iHp.setTitle(this.iHh);
                this.iHp.setForumName(this.iHh);
                TbadkCoreApplication.getInst().setDefaultBubble(this.iGN.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.iGN.getUserData().getBimg_end_time());
                cyE();
                cyG();
                ArrayList<com.baidu.adp.widget.ListView.q> threadList = this.iGN.getThreadList();
                if (threadList != null) {
                    this.iHp.a(threadList, this.iGN);
                    com.baidu.tieba.frs.f.c.A(this.iHp);
                    this.iHJ.Aw(getPageNum());
                    this.iHJ.i(this.iGN);
                    this.iHK.a(this.iGN, this.iHI.cEr());
                    this.iHp.czA();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void cyG() {
        if (this.iGN != null) {
            if (this.iGN.getIsNewUrl() == 1) {
                this.iHp.czK().setFromCDN(true);
            } else {
                this.iHp.czK().setFromCDN(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.iHL.qn(false);
        this.iHD = false;
        this.iHp.onPause();
        if (this.iHo != null) {
            this.iHo.onPause(getPageContext());
        }
        this.iHp.pF(true);
        if (this.iHR != null) {
            this.iHR.cFo();
        }
        com.baidu.tbadk.BdToken.c.bgf().bgq();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.iHK != null && this.iHK.cGs() != null && (this.iHK.cGs().fragment instanceof BaseFragment)) {
            ((BaseFragment) this.iHK.cGs().fragment).setPrimary(z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.t.cor().oy(false);
        pr(false);
        if (this.iGN != null && this.iGN.getForum() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            com.baidu.tbadk.distribute.a.bzk().b(getPageContext().getPageActivity(), "frs", this.iGN.getForum().getId(), 0L);
        }
        if (this.iHo != null) {
            this.iHo.onStop(getPageContext());
        }
        if (bta() != null) {
            bta().getRecycledViewPool().clear();
        }
        this.iHJ.bso();
        com.baidu.tbadk.util.ac.bDV();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            if (this.iHJ != null) {
                this.iHJ.bQ(isPrimary());
            }
            if (this.iHp != null) {
                this.iHp.bQ(isPrimary());
                this.iHp.pF(!isPrimary());
            }
        }
    }

    private void cyH() {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.oz(2);
        aVar.iW(false);
        FrsBroadcastCopyGuideDialogView frsBroadcastCopyGuideDialogView = new FrsBroadcastCopyGuideDialogView(getPageContext().getPageActivity());
        frsBroadcastCopyGuideDialogView.setConfirmButtonListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.36
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aVar != null) {
                    aVar.dismiss();
                    FrsFragment.this.cyI();
                }
            }
        });
        aVar.bf(frsBroadcastCopyGuideDialogView);
        aVar.b(getPageContext()).bpc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyI() {
        if (KuangFloatingFrsCopyLinkViewController.getInstance().init()) {
            ((BaseFragmentActivity) getPageContext().getOrignalPage()).grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.frs.FrsFragment.37
                @Override // com.baidu.tbadk.core.e
                public void onPermissionResult(boolean z) {
                    if (!z) {
                        new BdTopToast(FrsFragment.this.getContext()).yk(false).Ut(FrsFragment.this.getContext().getString(R.string.forum_broadcast_copy_no_permission_hint)).aJ(FrsFragment.this.iHp.cka());
                        return;
                    }
                    KuangFloatingFrsCopyLinkViewController.getInstance().showFloatingView(true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                    if (FrsFragment.this.iHq != null) {
                        FrsFragment.this.iHq.setVisibility(8);
                    }
                }
            }, true);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (b.cxm().cxg()) {
                b.cxm().reset();
                return true;
            } else if (com.baidu.tieba.frs.a.cxf().cxg()) {
                if (this.iHp != null && this.iHp.czP()) {
                    this.iHp.czQ();
                    return true;
                }
                com.baidu.tieba.frs.a.cxf().reset();
                return true;
            } else if (this.iHp != null) {
                return this.iHp.czw();
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
        com.baidu.tbadk.distribute.a.bzk().a(advertAppInfo, this.forumId, 0L, "FRS", str, getPn());
    }

    @Override // com.baidu.tieba.recapp.n
    public void cyJ() {
        cyg().cyJ();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.iHo == null) {
            this.iHo = VoiceManager.instance();
        }
        return this.iHo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdRecyclerView bta() {
        if (this.iHp == null) {
            return null;
        }
        return this.iHp.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void cyK() {
        if (this.iHo != null) {
            this.iHo.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> btb() {
        if (this.eXS == null) {
            this.eXS = UserIconBox.u(getPageContext().getPageActivity(), 8);
        }
        return this.eXS;
    }

    public void cyL() {
        if (getFragmentActivity() != null && getFragmentActivity().getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.t onGetPreLoadListView() {
        return bta().getPreLoadHandle();
    }

    @Override // com.baidu.tieba.frs.at
    public NavigationBar bSH() {
        if (this.iHp == null) {
            return null;
        }
        return this.iHp.bSH();
    }

    public FRSRefreshButton cyM() {
        return this.iHr;
    }

    public void c(LinearLayout linearLayout) {
        if (linearLayout != null) {
            this.iHs = linearLayout;
        }
    }

    public void a(FRSRefreshButton fRSRefreshButton) {
        if (fRSRefreshButton != null) {
            this.iHr = fRSRefreshButton;
            this.iHr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.43
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (FrsFragment.this.iHK != null) {
                        FrsTabViewController.b cGs = FrsFragment.this.iHK.cGs();
                        if (cGs != null && cGs.fragment != null && (cGs.fragment instanceof as)) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                            ((as) cGs.fragment).cxS();
                            ((as) cGs.fragment).bPV();
                            return;
                        }
                        FrsFragment.this.cyl().startPullRefresh();
                    }
                }
            });
        }
    }

    public void cyN() {
        if (this.iHr != null) {
            this.iHr.hide();
        }
    }

    public void cyO() {
        if (this.iHr != null) {
            this.iHr.show();
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
                if (bdUniqueId == w.iLe) {
                    if (FrsFragment.this.iHp != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11752").dR("fid", FrsFragment.this.forumId).dR("obj_locate", "1"));
                        FrsFragment.this.iHp.startPullRefresh();
                    }
                } else if (qVar != null && (qVar instanceof bv)) {
                    bw bwVar = ((bv) qVar).exA;
                    if (bwVar.bnA() == null || bwVar.bnA().getGroup_id() == 0 || com.baidu.tbadk.core.util.bg.checkUpIsLogin(FrsFragment.this.getActivity())) {
                        if (bwVar.bnn() != 1 || com.baidu.tbadk.core.util.bg.checkUpIsLogin(FrsFragment.this.getActivity())) {
                            if (bwVar.bmM() != null) {
                                if (com.baidu.tbadk.core.util.bg.checkUpIsLogin(FrsFragment.this.getActivity())) {
                                    String postUrl = bwVar.bmM().getPostUrl();
                                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.isNetOk()) {
                                        com.baidu.tbadk.browser.a.startInternalWebActivity(FrsFragment.this.getActivity(), postUrl);
                                    }
                                }
                            } else if (bwVar.bnL() != null) {
                                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                    com.baidu.tbadk.core.util.bg.skipToLoginActivity(FrsFragment.this.getPageContext().getPageActivity());
                                    return;
                                }
                                com.baidu.tbadk.core.data.r bnL = bwVar.bnL();
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), bnL.getCartoonId(), bnL.getChapterId(), 2)));
                            } else {
                                com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                                if (readThreadHistory != null && !readThreadHistory.Tb(bwVar.getId())) {
                                    readThreadHistory.Ta(bwVar.getId());
                                }
                                boolean z = false;
                                final String bmG = bwVar.bmG();
                                if (bmG != null && !bmG.equals("")) {
                                    z = true;
                                    new Thread(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.a.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            com.baidu.tbadk.core.util.aa aaVar = new com.baidu.tbadk.core.util.aa(bmG);
                                            aaVar.bqN().brt().mIsNeedAddCommenParam = false;
                                            aaVar.bqN().brt().mIsUseCurrentBDUSS = false;
                                            aaVar.getNetData();
                                        }
                                    }).start();
                                }
                                String tid = bwVar.getTid();
                                if (tid == null) {
                                    tid = "";
                                }
                                if (bwVar.bmv() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                    com.baidu.tbadk.core.util.be.brr().b(FrsFragment.this.getPageContext(), new String[]{tid, "", null});
                                    return;
                                }
                                if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && tid.length() > 4) {
                                    bwVar.setId(tid.substring(3));
                                }
                                if (bdUniqueId.getId() == bw.eFA.getId()) {
                                    com.baidu.tieba.frs.f.j.a(bwVar.bmg());
                                } else if (bdUniqueId.getId() == bw.eEb.getId()) {
                                    com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                                    aqVar.dR("obj_type", "2");
                                    aqVar.dR("tid", bwVar.getTid());
                                    TiebaStatic.log(aqVar);
                                }
                                com.baidu.tieba.frs.f.k.a(FrsFragment.this, bwVar, i, z);
                                com.baidu.tieba.frs.f.j.a(FrsFragment.this, FrsFragment.this.iGN, bwVar);
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
            hideNetRefreshView(this.iHp.czZ().cGi());
            showLoadingView(this.iHp.cka(), true);
            this.iHp.pB(false);
            this.iHI.S(3, true);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData cyP() {
        return this.iGN;
    }

    public boolean cyQ() {
        return this.iHp.cyQ();
    }

    public void aI(Object obj) {
        if (this.iHN != null && this.iHN.jcR != null) {
            this.iHN.jcR.callback(obj);
        }
    }

    public void aJ(Object obj) {
        if (this.iHN != null && this.iHN.jcS != null) {
            this.iHN.jcS.callback(obj);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        this.iHp.getListView().stopScroll();
        if (!this.iHp.czG()) {
            if (!com.baidu.adp.lib.util.l.isNetOk()) {
                this.iHp.bPW();
            } else if (this.iHI.cEm() == 1) {
                bOX();
                bOI();
            } else if (this.iHI.hasMore()) {
                bOI();
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void onFailed(String str) {
        bOX();
        showToast(str);
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void ax(ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        boolean isEmpty = com.baidu.tbadk.core.util.y.isEmpty(arrayList);
        setHasMore(isEmpty ? 0 : 1);
        bOX();
        if (!isEmpty) {
            if (!this.iHI.cEw() && TbadkCoreApplication.getInst().isRecAppExist() && this.iHI.cEm() == 1) {
                this.iGN.addRecommendAppToThreadList(this, arrayList);
            }
            if (this.iHI != null) {
                com.baidu.tieba.frs.d.a.a(getUniqueId(), arrayList, this.iGN.getForum(), this.iHI.getSortType());
            }
            ArrayList<com.baidu.adp.widget.ListView.q> a2 = this.iHT.a(false, false, arrayList, this.iHl, false);
            if (a2 != null) {
                this.iGN.setThreadList(a2);
                this.iHp.a(a2, this.iGN);
            }
            if (this.iHI != null) {
                com.baidu.tieba.frs.d.c.a(this.iGN, this.iHI.cEr(), 2, getContext());
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.iGN.getForum()));
        }
    }

    private void bOX() {
        if (cym() == 1 || this.iHT.m41do(this.iGN.getThreadListIds())) {
            if (com.baidu.tbadk.core.util.y.getCount(this.iGN.getThreadList()) > 3) {
                this.iHp.Wi();
            } else {
                this.iHp.czN();
            }
        } else if (com.baidu.tbadk.core.util.y.isEmpty(this.iGN.getThreadList())) {
            this.iHp.bPW();
        } else {
            this.iHp.Wj();
        }
    }

    @Override // com.baidu.tieba.frs.mc.l
    public void bOI() {
        if (this.iHT != null) {
            this.iHT.a(this.iHh, this.forumId, this.iGN);
        }
    }

    public void cyR() {
        if (!com.baidu.tbadk.core.util.ae.requestWriteExternalStorgeAndCameraPermission(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.ao.g(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment, com.baidu.m.a.a.InterfaceC0250a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        com.baidu.tieba.frs.f.k.a(this, i, strArr, iArr);
    }

    public void pu(boolean z) {
        if (this.iHO != null) {
            this.iHO.pO(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.iHP.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a ta(int i) {
        return this.iHP.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        this.iHX.b(bVar);
    }

    public boolean cyS() {
        return this.iHd;
    }

    @Override // com.baidu.tieba.frs.aq
    public void TL() {
        if (this.iHp != null) {
            showFloatingView();
            this.iHp.getListView().scrollToPosition(0);
            this.iHp.startPullRefresh();
        }
    }

    public ForumWriteData cyT() {
        if (this.iGN == null || this.iGN.getForum() == null) {
            return null;
        }
        ForumData forum = this.iGN.getForum();
        ForumWriteData forumWriteData = new ForumWriteData(forum.getId(), forum.getName(), forum.getPrefixData(), this.iGN.getAnti());
        forumWriteData.avatar = forum.getImage_url();
        forumWriteData.forumLevel = forum.getUser_level();
        forumWriteData.specialForumType = forum.special_forum_type;
        forumWriteData.firstDir = forum.getFirst_class();
        forumWriteData.secondDir = forum.getSecond_class();
        UserData userData = this.iGN.getUserData();
        forumWriteData.privateThread = userData != null ? userData.getPrivateThread() : 0;
        forumWriteData.frsTabInfo = cyU();
        return forumWriteData;
    }

    private FrsTabInfoData cyU() {
        int i;
        if (this.iHI == null || this.iGN == null || this.iHK == null) {
            return null;
        }
        if (this.iGN.getEntelechyTabInfo() == null || com.baidu.tbadk.core.util.y.isEmpty(this.iGN.getEntelechyTabInfo().tab)) {
            return null;
        }
        int cGw = this.iHK.cGw();
        if (cGw == 502) {
            return null;
        }
        int i2 = -1;
        ArrayList arrayList = new ArrayList();
        Iterator<FrsTabInfo> it = this.iGN.getEntelechyTabInfo().tab.iterator();
        while (true) {
            i = i2;
            if (!it.hasNext()) {
                break;
            }
            FrsTabInfo next = it.next();
            if (next != null && next.is_general_tab.intValue() == 1) {
                arrayList.add(new FrsTabItemData(next));
                if (cGw == next.tab_id.intValue()) {
                    i2 = cGw;
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
    public void bsD() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void pv(boolean z) {
        this.iHE = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z) {
        this.iHp.yN(8);
        ((FrsActivity) getActivity()).showLoadingView(view, z);
        ((FrsActivity) getActivity()).j(view, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        this.iHp.yN(0);
        ((FrsActivity) getActivity()).hideLoadingView(view);
        ((FrsActivity) getActivity()).j(view, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        super.showNetRefreshView(view, getResources().getString(R.string.refresh_view_title_text), null, getResources().getString(R.string.refresh_view_button_text), z, getNetRefreshListener());
        this.iHp.yN(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshViewNoClick(View view, String str, boolean z) {
        super.showNetRefreshViewNoClick(view, str, z);
        this.iHp.yN(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        super.hideNetRefreshView(view);
        this.iHp.yN(0);
    }

    public void cyV() {
        FrsTabViewController.b cGs;
        if (this.iHK != null && (cGs = this.iHK.cGs()) != null && cGs.fragment != null && (cGs.fragment instanceof as)) {
            ((as) cGs.fragment).cxS();
        }
    }

    public void pw(boolean z) {
        this.iHf = z;
    }

    public void b(OvalActionButton ovalActionButton) {
        this.iHq = ovalActionButton;
    }

    public OvalActionButton cyW() {
        return this.iHq;
    }

    public boolean cyX() {
        return this.iHf;
    }

    public void onShareSuccess(String str) {
        if (TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.util.at.isEmpty(str)) {
            if (this.iIi == null) {
                this.iIi = new AddExperiencedModel(getTbPageContext());
            }
            this.iIi.gi(this.forumId, str);
        }
    }

    public boolean cyY() {
        if (this.iHE && !this.iIl) {
            return (this.iHI != null && this.iHI.cEn() && (b.cxm().cxg() || com.baidu.tieba.frs.a.cxf().cxg())) ? false : true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.f.b
    public boolean videoNeedPreload() {
        if (this.iGN != null) {
            return com.baidu.tbadk.util.ai.rV(2) || (com.baidu.tbadk.util.ai.bEb() && this.iGN.isFrsVideoAutoPlay);
        }
        return super.videoNeedPreload();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyZ() {
        if (!com.baidu.tbadk.core.util.at.isEmpty(this.forumId)) {
            com.baidu.tbadk.BdToken.c.bgf().q(com.baidu.tbadk.BdToken.b.eqe, com.baidu.adp.lib.f.b.toLong(this.forumId, 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cza() {
        String format;
        String str;
        if (isResumed() && this.iIp != null && this.iIp.size() >= 1 && this.iIo <= this.iIp.size() - 1) {
            final LiveHorseRaceData liveHorseRaceData = this.iIp.get(this.iIo);
            if (System.currentTimeMillis() / 1000 >= liveHorseRaceData.getRob_end_tm().longValue()) {
                this.iIo++;
                cza();
            }
            if (this.iHs != null) {
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
                        if (FrsFragment.this.iGN == null) {
                            str2 = "";
                        } else if (FrsFragment.this.iGN.getForum() != null) {
                            str2 = FrsFragment.this.iGN.getForum().getName();
                        } else {
                            str2 = "";
                        }
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13744").al("obj_source", 1).dR("fid", FrsFragment.this.forumId).dR("fname", str2));
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
                this.iIq = ValueAnimator.ofFloat(1.0f, 0.0f);
                this.iIq.setDuration(600L);
                this.iIq.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.FrsFragment.51
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        if (valueAnimator.isRunning()) {
                            frsRedpackRunView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                            frsRedpackRunView.setTranslationX(-(TbadkApplication.getInst().getContext().getResources().getDimensionPixelOffset(R.dimen.tbds850) * valueAnimator.getAnimatedFraction()));
                        }
                    }
                });
                this.iIq.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.FrsFragment.52
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        frsRedpackRunView.setAlpha(0.0f);
                        frsRedpackRunView.setTranslationY(TbadkApplication.getInst().getContext().getResources().getDimensionPixelOffset(R.dimen.tbds660));
                        frsRedpackRunView.hide();
                        FrsFragment.this.iHs.removeView(frsRedpackRunView);
                        if (FrsFragment.this.iIo > FrsFragment.this.iIp.size() - 1) {
                            FrsFragment.this.iHs.removeAllViews();
                            FrsFragment.this.iHs.setVisibility(8);
                            FrsFragment.this.iIo = 0;
                            return;
                        }
                        FrsFragment.this.cza();
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        onAnimationEnd(animator);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                this.iIr = new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.53
                    @Override // java.lang.Runnable
                    public void run() {
                        if (FrsFragment.this.iHs != null && frsRedpackRunView != null) {
                            FrsFragment.this.iIq.start();
                        }
                    }
                };
                com.baidu.adp.lib.f.e.mY().postDelayed(this.iIr, 5000L);
                if (this.iHs.getChildCount() == 0) {
                    this.iIo++;
                    this.iHs.addView(frsRedpackRunView);
                    if (this.iGN != null) {
                        str = this.iGN.getForum() != null ? this.iGN.getForum().getName() : "";
                    } else {
                        str = "";
                    }
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13743").al("obj_source", 1).dR("fid", this.forumId).dR("fname", str));
                }
                if (this.iHs.getVisibility() == 8 && ((BaseFragment) this.iHK.cGs().fragment).isPrimary() && !this.iHp.czW() && !this.iHy) {
                    this.iHs.setVisibility(0);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        FrsTabViewController.b cGs;
        if (cyj() == null || (cGs = cyj().cGs()) == null || !(cGs.fragment instanceof BaseFragment)) {
            return null;
        }
        if (cGs.fragment instanceof FrsAllThreadFragment) {
            TbPageTag tbPageTag = super.getTbPageTag();
            int i = -1;
            if (this.iGN != null) {
                i = this.iGN.getSortType();
            }
            tbPageTag.sortType = com.baidu.tieba.frs.f.i.At(i);
            tbPageTag.locatePage = "a070";
            if (this.iHa.equals(cGs.title)) {
                tbPageTag.locatePage = "a071";
            }
            return tbPageTag;
        } else if (cGs.fragment instanceof FrsFragment) {
            return null;
        } else {
            return ((BaseFragment) cGs.fragment).getTbPageTag();
        }
    }

    public void czb() {
        if (this.iGN != null) {
            com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
            if (this.iGN.needLog == 1) {
                bVar.jfB = true;
            } else {
                bVar.jfB = false;
            }
            if (this.iGN.getForum() != null) {
                bVar.jfD = this.iGN.getForum().getId();
            }
            if (cyg() != null) {
                bVar.jfC = cyg().cEr();
            }
            if (com.baidu.tieba.frs.d.d.iRl != null) {
                bVar.jfE = com.baidu.tieba.frs.d.d.iRl.jfE;
                bVar.jfF = com.baidu.tieba.frs.d.d.iRl.jfF;
            }
            this.iIs = new com.baidu.tieba.frs.live.b(bVar, getTbPageTag(), getUniqueId());
            this.iIs.zW(this.iIu);
            CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_CARD_CLICK, this.iIs);
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
            CustomMessageTask customMessageTask2 = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW, this.iIs);
            customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask2);
            CustomMessageTask customMessageTask3 = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_USER_CLICK, this.iIs);
            customMessageTask3.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask3);
            CustomMessageTask customMessageTask4 = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_VIDEO_CLICK, this.iIs);
            customMessageTask4.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask4);
        }
    }
}
