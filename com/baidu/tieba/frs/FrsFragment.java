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
public class FrsFragment extends BaseFragment implements BdListView.e, a.InterfaceC0224a, UserIconBox.b<BdRecyclerView>, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, aq, at, aw, com.baidu.tieba.frs.loadmore.a, com.baidu.tieba.frs.mc.l, com.baidu.tieba.recapp.n {
    public static com.baidu.tieba.tbadkCore.m ipa;
    private com.baidu.adp.lib.d.b<TbImageView> eJH;
    private com.baidu.tbadk.util.aa fkJ;
    private com.baidu.tieba.frs.gametab.b gns;
    private com.baidu.tbadk.core.dialog.a hHW;
    private com.baidu.tieba.frs.entelechy.a ioI;
    private com.baidu.tieba.tbadkCore.data.f ioS;
    private VoiceManager ioV;
    private OvalActionButton ioX;
    private FRSRefreshButton ioY;
    private LinearLayout ioZ;
    private com.baidu.tieba.frs.mc.c ipA;
    private com.baidu.tieba.frs.vc.j ipB;
    private com.baidu.tieba.frs.mc.a ipC;
    private com.baidu.tieba.frs.live.a ipD;
    private p ipE;
    public com.baidu.tieba.frs.vc.c ipF;
    private com.baidu.tieba.frs.mc.e ipG;
    private View.OnTouchListener ipH;
    private com.baidu.tieba.frs.view.a ipI;
    private com.baidu.tieba.frs.vc.e ipJ;
    private boolean ipK;
    private com.baidu.tieba.NEGFeedBack.a ipL;
    private com.baidu.tieba.ala.a ipM;
    private com.baidu.tieba.frs.brand.buttommenu.a ipN;
    private com.baidu.tieba.frs.sportspage.notification.a ipO;
    private AddExperiencedModel ipP;
    private boolean ipR;
    private List<LiveHorseRaceData> ipW;
    private ValueAnimator ipX;
    private Runnable ipY;
    private com.baidu.tieba.frs.live.b ipZ;
    public long ipb;
    private String ipm;
    private com.baidu.card.am ipo;
    private FrsModelController ipp;
    private com.baidu.tieba.frs.vc.h ipq;
    private FrsTabViewController ipr;
    private com.baidu.tieba.frs.mc.h ips;
    private com.baidu.tieba.frs.smartsort.a ipt;
    private com.baidu.tieba.frs.mc.b ipu;
    private ax ipv;
    private com.baidu.tieba.frs.entelechy.b.b ipx;
    private com.baidu.tieba.frs.vc.a ipy;
    private com.baidu.tieba.frs.mc.d ipz;
    private com.baidu.tieba.frs.broadcast.a iqa;
    private int iqb;
    private int iql;
    private View mRootView;
    private String mSchemeUrl;
    public static boolean ioN = false;
    public static volatile long ipd = 0;
    public static volatile long ipe = 0;
    public static volatile int mNetError = 0;
    private String ioH = "";
    public boolean ioJ = false;
    private boolean ioK = false;
    private boolean ioL = false;
    private boolean ioM = true;
    public String ioO = null;
    public String mFrom = null;
    public int mFlag = 0;
    public boolean ioP = false;
    private boolean ioQ = false;
    private String mThreadId = null;
    public String forumId = null;
    private int iow = 0;
    private boolean ioR = false;
    private boolean ioT = false;
    private boolean ioU = false;
    private q ioW = null;
    public final bw akp = null;
    private FrsViewData iou = new FrsViewData();
    public long hRt = -1;
    public long fgW = 0;
    public long fgM = 0;
    public long createTime = 0;
    public long fgN = 0;
    public long fgT = 0;
    public long ipc = 0;
    boolean ipf = false;
    public boolean ipg = false;
    private boolean iph = false;
    private boolean ipi = false;
    public com.baidu.tbadk.n.b ipj = null;
    private boolean ipk = true;
    private boolean ipl = true;
    private a.C0097a ipn = new a.C0097a(2);
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> ipw = new SparseArray<>();
    private boolean fWp = true;
    private boolean hasInit = false;
    private boolean ipQ = false;
    private boolean ipS = false;
    private Date ipT = null;
    private int dvr = 0;
    private int ipU = 0;
    private int ipV = 0;
    public int mHeadLineDefaultNavTabId = -1;
    MessageQueue.IdleHandler iqc = new MessageQueue.IdleHandler() { // from class: com.baidu.tieba.frs.FrsFragment.1
        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            FrsFragment.this.csR();
            return false;
        }
    };
    private final CustomMessageListener iqd = new CustomMessageListener(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED) { // from class: com.baidu.tieba.frs.FrsFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof bw) {
                    com.baidu.tieba.frs.f.j.a(FrsFragment.this.ioW, FrsFragment.this.iou, FrsFragment.this.getForumId(), true, (bw) data);
                }
            }
        }
    };
    private CustomMessageListener iqe = new CustomMessageListener(CmdConfigCustom.CMD_CLOSE_GAME_RANK_CARD) { // from class: com.baidu.tieba.frs.FrsFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.iou != null) {
                FrsFragment.this.iou.removeGameRankListFromThreadList();
                if (FrsFragment.this.ioW != null) {
                    FrsFragment.this.ioW.aVY();
                }
            }
        }
    };
    private CustomMessageListener agA = new CustomMessageListener(2921401) { // from class: com.baidu.tieba.frs.FrsFragment.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && FrsFragment.this.ioY != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() <= 0 || FrsFragment.this.ipr.cAN() == 0 || FrsFragment.this.ipr.cAK() == null || !(FrsFragment.this.ipr.cAK().fragment instanceof BaseFragment) || !((BaseFragment) FrsFragment.this.ipr.cAK().fragment).isPrimary() || FrsFragment.this.ioW.cuo() || KuangFloatingFrsCopyLinkViewController.getInstance().isFloatCopyViewShow()) {
                    if (FrsFragment.this.ipr.cAN() != 0) {
                        FrsFragment.this.ioY.hide();
                        return;
                    }
                    return;
                }
                FrsFragment.this.ioY.show();
            }
        }
    };
    private CustomMessageListener iqf = new CustomMessageListener(2921473) { // from class: com.baidu.tieba.frs.FrsFragment.45
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && FrsFragment.this.ioY != null && FrsFragment.this.ioX != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() == 0) {
                    FrsFragment.this.ioY.setVisibility(8);
                    FrsFragment.this.ioX.setVisibility(8);
                    return;
                }
                FrsFragment.this.ioX.setVisibility(0);
            }
        }
    };
    private CustomMessageListener iqg = new CustomMessageListener(2921467) { // from class: com.baidu.tieba.frs.FrsFragment.56
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && FrsFragment.this.ioY != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() <= 0 || FrsFragment.this.ipr.cAK() == null || !(FrsFragment.this.ipr.cAK().fragment instanceof BaseFragment) || !((BaseFragment) FrsFragment.this.ipr.cAK().fragment).isPrimary() || FrsFragment.this.ioW.cuo()) {
                    FrsFragment.this.ioZ.setVisibility(8);
                    FrsFragment.this.ipf = true;
                    return;
                }
                FrsFragment.this.ioZ.setVisibility(0);
                FrsFragment.this.ipf = false;
            }
        }
    };
    private com.baidu.adp.framework.listener.a iqh = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_FRS_LIVE_HORSE_RACE_LIST, 309667) { // from class: com.baidu.tieba.frs.FrsFragment.60
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if ((responsedMessage instanceof GetLiveHorseRaceHttpResponseMessage) || (responsedMessage instanceof GetLiveHorseRaceSocketResponseMessage)) {
                    List<LiveHorseRaceData> arrayList = new ArrayList<>();
                    if (responsedMessage instanceof GetLiveHorseRaceHttpResponseMessage) {
                        arrayList = ((GetLiveHorseRaceHttpResponseMessage) responsedMessage).getData().cuP();
                    }
                    if (responsedMessage instanceof GetLiveHorseRaceSocketResponseMessage) {
                        arrayList = ((GetLiveHorseRaceSocketResponseMessage) responsedMessage).getData().cuP();
                    }
                    if (FrsFragment.this.ipW != null) {
                        if (FrsFragment.this.ioZ.getVisibility() != 8) {
                            if (FrsFragment.this.ipV >= FrsFragment.this.ipW.size()) {
                                FrsFragment.this.ipW.addAll(arrayList);
                                return;
                            }
                            FrsFragment.this.ipW = FrsFragment.this.ipW.subList(0, FrsFragment.this.ipV);
                            FrsFragment.this.ipW.addAll(arrayList);
                            return;
                        }
                        FrsFragment.this.ipW = new ArrayList();
                        FrsFragment.this.ipW.addAll(arrayList);
                        FrsFragment.this.ipV = 0;
                        FrsFragment.this.cts();
                        return;
                    }
                    FrsFragment.this.ipW = new ArrayList();
                    FrsFragment.this.ipV = 0;
                    FrsFragment.this.ipW.addAll(arrayList);
                    FrsFragment.this.cts();
                }
            }
        }
    };
    private CustomMessageListener iqi = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.FrsFragment.61
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 1) {
                    FrsFragment.this.csV();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                }
            }
        }
    };
    private final av iqj = new av() { // from class: com.baidu.tieba.frs.FrsFragment.62
        @Override // com.baidu.tieba.frs.av
        public void a(int i, int i2, bd bdVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
            FrsFragment.this.csG();
            if (FrsFragment.this.ipx != null) {
                FrsFragment.this.ipq.pT(FrsFragment.this.ipx.yN(i));
            }
            com.baidu.tieba.tbadkCore.f fVar = new com.baidu.tieba.tbadkCore.f();
            if (bdVar != null) {
                fVar.isSuccess = bdVar.errCode == 0;
                fVar.errorCode = bdVar.errCode;
                fVar.errorMsg = bdVar.errMsg;
                if (fVar.isSuccess) {
                    if (com.baidu.tbadk.core.util.y.isEmpty(arrayList)) {
                        FrsFragment.this.ioW.bKU();
                    } else if (bdVar.hasMore) {
                        if (com.baidu.tbadk.core.util.y.getCount(FrsFragment.this.iou.getThreadList()) > 3) {
                            FrsFragment.this.ioW.SI();
                        } else {
                            FrsFragment.this.ioW.cuf();
                        }
                    } else if (bdVar.itV) {
                        FrsFragment.this.ioW.SJ();
                    } else {
                        FrsFragment.this.ioW.bKU();
                    }
                }
            } else {
                bdVar = new bd();
                bdVar.pn = 1;
                bdVar.hasMore = false;
                bdVar.itV = false;
            }
            if (i == 1) {
                FrsFragment.this.ipk = true;
                FrsFragment.this.iqA.a(FrsFragment.this.ipp.getType(), false, fVar);
            } else {
                FrsFragment.this.a(fVar);
                if (FrsFragment.this.ipp.cyf() != null) {
                    FrsFragment.this.iou = FrsFragment.this.ipp.cyf();
                }
                FrsFragment.this.csX();
            }
            if (FrsFragment.this.iqI != null) {
                FrsFragment.this.iqI.a(i, i2, bdVar, arrayList);
            }
        }
    };
    private FrsTabViewController.a iqk = new FrsTabViewController.a() { // from class: com.baidu.tieba.frs.FrsFragment.2
        @Override // com.baidu.tieba.frs.vc.FrsTabViewController.a
        public void ch(int i, int i2) {
            boolean z = false;
            if (i != 1) {
                com.baidu.tieba.card.s.ciJ().nX(false);
                FrsFragment.this.oQ(false);
            }
            if (i == 502) {
                FrsFragment.this.ioX.setIconFade(R.drawable.btn_frs_professional_edit_n);
            } else {
                FrsFragment.this.ioX.setIconFade(0);
            }
            FrsFragment.this.iql = i;
            FrsFragment.this.iqb = i2;
            if (FrsFragment.this.ipZ != null) {
                FrsFragment.this.ipZ.zq(FrsFragment.this.iqb);
            }
            TbSingleton.getInstance().setFrsCurTabType(FrsFragment.this.iqb);
            FrsFragment.this.ctc();
            com.baidu.tieba.frs.d.d.iyS.iNl = i;
            com.baidu.tieba.frs.d.d.iyS.iNo = i2;
            com.baidu.tieba.frs.d.d.iyS.iNm = -1;
            b.crE().S(i == 1 && FrsFragment.this.ipQ, true);
            com.baidu.tieba.frs.a crx = com.baidu.tieba.frs.a.crx();
            if (i == 1 && FrsFragment.this.ipQ) {
                z = true;
            }
            crx.S(z, true);
        }
    };
    private CustomMessageListener iqm = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIVE_COUNT) { // from class: com.baidu.tieba.frs.FrsFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                FrsFragment.this.ipr.Aa(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    };
    private CustomMessageListener iqn = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_LIVE_START) { // from class: com.baidu.tieba.frs.FrsFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && ((Integer) customResponsedMessage.getData()).intValue() == 51 && FrsFragment.this.iou != null) {
                com.baidu.tieba.frs.f.l.a(FrsFragment.this.iou, FrsFragment.this.getPageContext());
            }
        }
    };
    private final CustomMessageListener iqo = new CustomMessageListener(CmdConfigCustom.CMD_FRS_SELECT_ALA_LIVE_TAB) { // from class: com.baidu.tieba.frs.FrsFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                FrsFragment.this.ipr.sL(49);
            }
        }
    };
    private final CustomMessageListener iqp = new CustomMessageListener(2921470) { // from class: com.baidu.tieba.frs.FrsFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                FrsFragment.this.ipr.sL(1);
                FrsFragment.this.csV();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
            }
        }
    };
    private final CustomMessageListener iqq = new CustomMessageListener(CmdConfigCustom.CMD_FRS_EXPERIENCE_TIP) { // from class: com.baidu.tieba.frs.FrsFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.v) && FrsFragment.this.iou != null) {
                FrsFragment.this.iou.updateLikeData((com.baidu.tieba.tbadkCore.v) customResponsedMessage.getData());
                FrsFragment.this.ipq.i(FrsFragment.this.iou);
                FrsFragment.this.ipr.a(FrsFragment.this.iou, FrsFragment.this.ipp.cyJ());
            }
        }
    };
    private final AntiHelper.a iqr = new AntiHelper.a() { // from class: com.baidu.tieba.frs.FrsFragment.8
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).aj("obj_locate", ax.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).aj("obj_locate", ax.a.LOCATE_LIKE_PERSON));
        }
    };
    private CustomMessageListener iqs = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.FrsFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(FrsFragment.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().eQq != null) {
                        if (AntiHelper.a(FrsFragment.this.getActivity(), updateAttentionMessage.getData().eQq, FrsFragment.this.iqr) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).aj("obj_locate", ax.a.LOCATE_LIKE_PERSON));
                        }
                    } else if (updateAttentionMessage.getData().isSucc && updateAttentionMessage.getData().isAttention) {
                        com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getPageContext().getPageActivity(), R.string.attention_success);
                    }
                }
            }
        }
    };
    private CustomMessageListener iqt = new CustomMessageListener(CmdConfigCustom.CMD_GET_ENSURE_CAST_ID) { // from class: com.baidu.tieba.frs.FrsFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsFragment.this.refresh();
        }
    };
    private CustomMessageListener iqu = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.frs.FrsFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && !((PostWriteCallBackData) customResponsedMessage.getData()).isDyamicCallback()) {
                FrsFragment.this.ioW.c((PostWriteCallBackData) customResponsedMessage.getData());
                if (((PostWriteCallBackData) customResponsedMessage.getData()).getGeneralTabId() >= 0) {
                    FrsFragment.this.ipC.zs(((PostWriteCallBackData) customResponsedMessage.getData()).getGeneralTabId());
                }
            }
        }
    };
    private CustomMessageListener iqv = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_REMIND) { // from class: com.baidu.tieba.frs.FrsFragment.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626) {
                NewsRemindMessage newsRemindMessage = (NewsRemindMessage) customResponsedMessage;
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (FrsFragment.this.ioW != null) {
                    FrsFragment.this.ioW.P(notificationCount, z);
                }
            }
        }
    };
    private HttpMessageListener iqw = new HttpMessageListener(CmdConfigHttp.CMD_FRS_MOVE_AREA) { // from class: com.baidu.tieba.frs.FrsFragment.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int i;
            int i2 = 0;
            if (httpResponsedMessage != null && FrsFragment.this.getContext() != null && FrsFragment.this.ioW != null) {
                if (httpResponsedMessage.getError() == 0) {
                    new BdTopToast(FrsFragment.this.getContext()).xK(true).TD(FrsFragment.this.getContext().getString(R.string.frs_move_area_move_suc)).aH(FrsFragment.this.ioW.cew());
                    if (com.baidu.tieba.frs.a.crx().xT(com.baidu.tieba.frs.a.crx().crz())) {
                        FrsCommonTabFragment frsCommonTabFragment = null;
                        if (FrsFragment.this.ipr != null && FrsFragment.this.ipr.cAK() != null && (FrsFragment.this.ipr.cAK().fragment instanceof FrsCommonTabFragment)) {
                            frsCommonTabFragment = (FrsCommonTabFragment) FrsFragment.this.ipr.cAK().fragment;
                        }
                        if (frsCommonTabFragment != null) {
                            frsCommonTabFragment.cvJ();
                        }
                        FrsFragment.this.crC();
                        com.baidu.tieba.frs.a.crx().crC();
                        Iterator<com.baidu.adp.widget.ListView.q> it = FrsFragment.this.iou.getThreadList().iterator();
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
                            FrsFragment.this.bJG();
                        }
                    }
                    com.baidu.tieba.frs.a.crx().reset();
                    return;
                }
                new BdTopToast(FrsFragment.this.getContext()).xK(false).TD(httpResponsedMessage.getErrorString()).aH(FrsFragment.this.ioW.cew());
            }
        }
    };
    private final CustomMessageListener iqx = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.frs.FrsFragment.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.isResumed()) {
                FrsFragment.this.ctr();
            }
        }
    };
    private CustomMessageListener iqy = new CustomMessageListener(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER) { // from class: com.baidu.tieba.frs.FrsFragment.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (FrsFragment.this.ioW != null) {
                    FrsFragment.this.ioW.setExpanded(booleanValue);
                }
            }
        }
    };
    private final CustomMessageListener iqz = new CustomMessageListener(2921463) { // from class: com.baidu.tieba.frs.FrsFragment.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TbadkApplication.getInst().getCurrentActivity() != null && !com.baidu.tbadk.core.util.at.isEmpty(str) && str.equals(FrsFragment.this.forumId)) {
                    com.baidu.tieba.frs.f.g.b(((TbPageContextSupport) TbadkApplication.getInst().getCurrentActivity()).getPageContext(), FrsFragment.this.iou);
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.r iqA = new com.baidu.tieba.tbadkCore.r() { // from class: com.baidu.tieba.frs.FrsFragment.18
        private long startTime = 0;

        @Override // com.baidu.tieba.tbadkCore.r
        public void ya(int i) {
            this.startTime = System.nanoTime();
            if (FrsFragment.this.ioW != null) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsFragment.this.ioW.ctP();
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
            if (FrsFragment.this.fWp) {
                FrsFragment.this.fWp = false;
                com.baidu.tieba.frs.f.j.a(FrsFragment.this.ioW, FrsFragment.this.iou, FrsFragment.this.getForumId(), false, null);
            }
            FrsFragment.this.csG();
            FrsFragment.this.iph = true;
            if (fVar != null && fVar.isSuccess) {
                FrsFragment.this.ioW.cuc().pA(com.baidu.tbadk.core.util.au.bmV().bmW());
                FrsFragment.ipd = 0L;
                FrsFragment.ipe = 0L;
                FrsFragment.mNetError = 0;
            } else {
                FrsFragment.mNetError = 1;
            }
            if (!FrsFragment.this.ipp.cyO() && (i == 3 || i == 6)) {
                FrsFragment.this.ipA.resetData();
            }
            FrsFragment.this.ipb = System.currentTimeMillis();
            if (FrsFragment.this.ipp.cyf() != null) {
                FrsFragment.this.iou = FrsFragment.this.ipp.cyf();
            }
            FrsFragment.this.xW(1);
            FrsFragment.this.csO();
            if (i == 7) {
                FrsFragment.this.xX(FrsFragment.this.iou.getFrsDefaultTabId());
                return;
            }
            if (FrsFragment.this.iou.getPage() != null) {
                FrsFragment.this.setHasMore(FrsFragment.this.iou.getPage().bgX());
            }
            if (i == 4) {
                if (!FrsFragment.this.ipp.cyO() && TbadkCoreApplication.getInst().isRecAppExist() && FrsFragment.this.ipp.cyE() == 1) {
                    FrsFragment.this.iou.addRecommendAppToThreadList(FrsFragment.this);
                }
                ArrayList<com.baidu.adp.widget.ListView.q> a2 = FrsFragment.this.ipA.a(false, false, FrsFragment.this.iou.getThreadList(), FrsFragment.this.ioS, false);
                if (a2 != null) {
                    FrsFragment.this.iou.setThreadList(a2);
                    FrsFragment.this.iou.checkLiveStageInThreadList();
                }
                if (FrsFragment.this.ipp != null) {
                    com.baidu.tieba.frs.d.c.a(FrsFragment.this.iou, FrsFragment.this.ipp.cyJ(), 2, FrsFragment.this.getContext());
                }
                com.baidu.tieba.frs.f.a.a(FrsFragment.this, FrsFragment.this.iou.getForum(), FrsFragment.this.iou.getThreadList(), false, FrsFragment.this.getPn());
                FrsFragment.this.ioW.a(a2, FrsFragment.this.iou);
                FrsFragment.this.csH();
                return;
            }
            FrsFragment.this.csH();
            switch (i) {
                case 1:
                    FrsFragment.this.ioW.ctP();
                    break;
                case 2:
                    FrsFragment.this.ioW.ctP();
                    break;
                case 3:
                case 6:
                    if (FrsFragment.this.iou != null) {
                        FrsFragment.this.iou.clearPostThreadCount();
                    }
                    if (FrsFragment.this.ipF != null) {
                        FrsFragment.this.ipF.refresh();
                        break;
                    }
                    break;
            }
            FrsFragment.this.csP();
            if (fVar == null || fVar.errorCode == 0) {
                if (FrsFragment.this.iou != null) {
                    FrsFragment.this.a(FrsFragment.this.iou);
                    FrsFragment.this.U(false, i == 5);
                    if (FrsFragment.this.ipp != null) {
                        if (FrsFragment.this.iou.getActivityHeadData() != null && FrsFragment.this.iou.getActivityHeadData().bgl() != null && FrsFragment.this.iou.getActivityHeadData().bgl().size() > 0) {
                            com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), 1, FrsFragment.this.iou.getForum(), FrsFragment.this.ipp.getSortType(), 1);
                        }
                        if (FrsFragment.this.iou.getThreadList() != null && FrsFragment.this.iou.getThreadList().size() > 0) {
                            Iterator<com.baidu.adp.widget.ListView.q> it = FrsFragment.this.iou.getThreadList().iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    com.baidu.adp.widget.ListView.q next = it.next();
                                    if ((next instanceof bw) && ((bw) next).getType() == bw.erk) {
                                        com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), 1, FrsFragment.this.iou.getForum(), FrsFragment.this.ipp.getSortType(), 2);
                                    }
                                }
                            }
                        }
                        com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), FrsFragment.this.iou.getThreadList(), FrsFragment.this.iou.getForum(), FrsFragment.this.ipp.getSortType());
                    }
                    FrsFragment.this.ioW.yn(i);
                    FrsFragment.ipd = (System.nanoTime() - this.startTime) / TimeUtils.NANOS_PER_MS;
                    if (fVar != null) {
                        FrsFragment.ipe = fVar.mBR;
                    }
                } else {
                    return;
                }
            } else if (FrsFragment.this.iou == null || com.baidu.tbadk.core.util.y.isEmpty(FrsFragment.this.iou.getThreadList())) {
                FrsFragment.this.a(fVar);
            } else if (fVar.hYP) {
                FrsFragment.this.showToast(FrsFragment.this.getPageContext().getResources().getString(R.string.net_error_text, fVar.errorMsg, Integer.valueOf(fVar.errorCode)));
            }
            FrsFragment.this.csL();
            FrsFragment.this.csM();
            if (FrsFragment.this.iou.getAccessFlag() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11384"));
            }
            if (FrsFragment.this.ioT && FrsFragment.this.ipr.sL(49)) {
                FrsFragment.this.ioT = false;
            }
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.r
        public void c(com.baidu.tieba.tbadkCore.m mVar) {
            if ((mVar != null && ("normal_page".equals(FrsFragment.this.ipp.getPageType()) || "frs_page".equals(FrsFragment.this.ipp.getPageType()) || "book_page".equals(FrsFragment.this.ipp.getPageType()))) || "brand_page".equals(FrsFragment.this.ipp.getPageType())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE, mVar));
                FrsFragment.this.b(mVar);
                FrsFragment.ipa = mVar;
            }
        }

        @Override // com.baidu.tieba.tbadkCore.r
        public void csR() {
            FrsFragment.this.csR();
        }
    };
    private final CustomMessageListener iqB = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.frs.FrsFragment.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.m) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                FrsFragment.this.iou.updateCurrentUserPendant((com.baidu.tbadk.data.m) customResponsedMessage.getData());
                FrsFragment.this.ioW.cuc().notifyDataSetChanged();
            }
        }
    };
    private final CustomMessageListener mMemListener = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_MEM) { // from class: com.baidu.tieba.frs.FrsFragment.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && FrsFragment.this.iou != null && (userData = FrsFragment.this.iou.getUserData()) != null) {
                userData.setIsMem(num.intValue());
                if (num.intValue() != 0) {
                    FrsFragment.this.ipq.o(num);
                }
            }
        }
    };
    private final f.a iqC = new AnonymousClass29();
    private final com.baidu.tieba.frs.mc.k iqD = new com.baidu.tieba.frs.mc.k() { // from class: com.baidu.tieba.frs.FrsFragment.30
        @Override // com.baidu.tieba.frs.mc.k
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, boolean z3) {
            if (FrsFragment.this.ipt != null && FrsFragment.this.ipp != null && FrsFragment.this.ipp.cyO() && z && !z2 && !z3) {
                FrsFragment.this.ipt.zx(i2);
            }
        }
    };
    public final View.OnTouchListener fkK = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.FrsFragment.31
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (FrsFragment.this.ipH != null) {
                FrsFragment.this.ipH.onTouch(view, motionEvent);
            }
            if (FrsFragment.this.ipv != null && FrsFragment.this.ipv.cuQ() != null) {
                FrsFragment.this.ipv.cuQ().onTouchEvent(motionEvent);
            }
            if (FrsFragment.this.gns != null) {
                FrsFragment.this.gns.b(view, motionEvent);
            }
            if (FrsFragment.this.ipq != null) {
                FrsFragment.this.ipq.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private final CustomMessageListener iqE = new CustomMessageListener(CmdConfigCustom.CMD_GOTOLIVE_HOST_UPGRADE) { // from class: com.baidu.tieba.frs.FrsFragment.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.blO().getInt(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.PHOTOLIVE_HOSTLEVEL, -1) != -1 && FrsFragment.this.iou.getForum() != null) {
                FrsFragment.this.iou.getForum().setCanAddPhotoLivePost(true);
            }
        }
    };
    public final View.OnClickListener iqF = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.38
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsFragment.this.ioW != null && view == FrsFragment.this.ioW.ctN() && FrsFragment.this.getActivity() != null) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, FrsFragment.this.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            if (view.getId() == R.id.game_activity_egg_layout && com.baidu.adp.lib.util.l.isNetOk()) {
                TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_CLICK);
                if (FrsFragment.this.ioW == null || !FrsFragment.this.ioW.ctZ()) {
                    String activityUrl = FrsFragment.this.iou.getForum().getYuleData().bkB().getActivityUrl();
                    if (!StringUtils.isNull(activityUrl)) {
                        com.baidu.tbadk.browser.a.startInternalWebActivity(FrsFragment.this.getPageContext().getPageActivity(), activityUrl);
                    }
                } else {
                    FrsFragment.this.ioW.cua();
                }
            }
            if (FrsFragment.this.ioW != null && view == FrsFragment.this.ioW.cug() && FrsFragment.this.ipp != null && FrsFragment.this.ipp.hasMore()) {
                FrsFragment.this.ioW.SI();
                FrsFragment.this.bJG();
            }
            if (view != null && FrsFragment.this.ioW != null && view == FrsFragment.this.ioW.ctW()) {
                if (com.baidu.tbadk.core.util.bg.checkUpIsLogin(FrsFragment.this.getContext())) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).aj("obj_locate", 2));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MessageCenterActivityConfig(FrsFragment.this.getContext())));
                } else {
                    return;
                }
            }
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (FrsFragment.this.iou != null && FrsFragment.this.iou.getForum() != null) {
                    if (FrsFragment.this.ioW != null && view == FrsFragment.this.ioW.ctU()) {
                        if (FrsFragment.this.iou != null && FrsFragment.this.iou.getForum() != null && !StringUtils.isNull(FrsFragment.this.iou.getForum().getId()) && !StringUtils.isNull(FrsFragment.this.iou.getForum().getName())) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_SHARE_CLICK).dK("fid", FrsFragment.this.iou.getForum().getId()).aj("obj_locate", 11));
                            com.baidu.tieba.frs.f.g.a(FrsFragment.this.getPageContext(), FrsFragment.this.iou, FrsFragment.this.iou.getForum().getId());
                        } else {
                            return;
                        }
                    }
                    if (FrsFragment.this.ioW != null && view == FrsFragment.this.ioW.ctT()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12402").dK("fid", FrsFragment.this.iou.getForum().getId()).dK("uid", TbadkCoreApplication.getCurrentAccount()).dK("fname", FrsFragment.this.iou.getForum().getName()));
                        if (!StringUtils.isNull(FrsFragment.this.iou.getForum().getName())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PostSearchActivityConfig(FrsFragment.this.getContext(), FrsFragment.this.iou.getForum().getName(), FrsFragment.this.iou.getForum().getId())));
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
        private int ird = 0;
        private int fSe = 0;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsFragment.this.ipU += i2;
            if (FrsFragment.this.ipU >= FrsFragment.this.dvr * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
            if (FrsFragment.this.ipy != null) {
                FrsFragment.this.ipy.czG();
            }
            this.ird = 0;
            this.fSe = 0;
            if (recyclerView != null && (recyclerView instanceof BdRecyclerView)) {
                this.ird = ((BdRecyclerView) recyclerView).getFirstVisiblePosition();
                this.fSe = ((BdRecyclerView) recyclerView).getLastVisiblePosition();
            }
            if (FrsFragment.this.ipJ != null) {
                FrsFragment.this.ipJ.a(recyclerView, this.ird, this.fSe);
            }
            if (FrsFragment.this.iou != null && FrsFragment.this.ioW != null && FrsFragment.this.ioW.cuc() != null) {
                FrsFragment.this.ioW.ck(this.ird, this.fSe);
                if (FrsFragment.this.ipo != null && FrsFragment.this.ipo.tW() != null) {
                    FrsFragment.this.ipo.tW().b(FrsFragment.this.ipn);
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (FrsFragment.this.ipq != null) {
                FrsFragment.this.ipq.setScrollState(i);
            }
            if ((i == 2 || i == 1) && !FrsFragment.this.ipi) {
                FrsFragment.this.ipi = true;
                FrsFragment.this.ioW.cue();
            }
            if (FrsFragment.this.ipj == null && !FrsFragment.this.ctk()) {
                FrsFragment.this.ipj = new com.baidu.tbadk.n.b();
                FrsFragment.this.ipj.setSubType(1000);
            }
            if (i == 0) {
                if (FrsFragment.this.ipj != null) {
                    FrsFragment.this.ipj.bxT();
                }
                com.baidu.tieba.card.s.ciJ().nX(true);
                FrsFragment.this.oQ(true);
                FrsFragment.this.ioW.cj(this.ird, this.fSe);
            } else if (FrsFragment.this.ipj != null) {
                FrsFragment.this.ipj.bxS();
            }
            if (FrsFragment.this.ipJ != null) {
                FrsFragment.this.ipJ.onScrollStateChanged(recyclerView, i);
            }
            if (i == 0) {
                com.baidu.tieba.frs.f.j.a(FrsFragment.this.ioW, FrsFragment.this.iou, FrsFragment.this.getForumId(), false, null);
            }
            if (FrsFragment.this.ipr != null && i == 1) {
                FrsFragment.this.ipr.cAM();
            }
            if (FrsFragment.this.ipo == null) {
                if (FrsFragment.this.ioW.ctG() != null && !FrsFragment.this.ioW.cti() && FrsFragment.this.ioW.ctG().drn() != null && (FrsFragment.this.ioW.ctG().drn().getTag() instanceof com.baidu.card.am)) {
                    FrsFragment.this.ipo = (com.baidu.card.am) FrsFragment.this.ioW.ctG().drn().getTag();
                }
            } else if (i == 0 && FrsFragment.this.ioW.ctG() != null && !FrsFragment.this.ioW.cti() && FrsFragment.this.ioW.ctG().drn() != null && (FrsFragment.this.ioW.ctG().drn().getTag() instanceof com.baidu.card.am)) {
                FrsFragment.this.ipo = (com.baidu.card.am) FrsFragment.this.ioW.ctG().drn().getTag();
            }
            if (i == 1) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921418));
            }
        }
    };
    private final f iqG = new f() { // from class: com.baidu.tieba.frs.FrsFragment.40
        @Override // com.baidu.tieba.frs.f
        public void a(int i, int i2, View view, View view2, bw bwVar) {
            if (i != FrsFragment.this.ioW.cuc().cwv()) {
                if (i != FrsFragment.this.ioW.cuc().cww()) {
                    if (i == FrsFragment.this.ioW.cuc().cwt() && FrsFragment.this.iou != null && FrsFragment.this.iou.getUserData() != null && FrsFragment.this.iou.getUserData().isBawu()) {
                        String bawuCenterUrl = FrsFragment.this.iou.getBawuCenterUrl();
                        if (!com.baidu.tbadk.core.util.at.isEmpty(bawuCenterUrl) && FrsFragment.this.iou.getForum() != null) {
                            com.baidu.tbadk.browser.a.startWebActivity(FrsFragment.this.getPageContext().getPageActivity(), bawuCenterUrl);
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10502").dK("fid", FrsFragment.this.iou.getForum().getId()).dK("uid", FrsFragment.this.iou.getUserData().getUserId()));
                        }
                    }
                } else if (com.baidu.tbadk.core.util.bg.checkUpIsLogin(FrsFragment.this.getPageContext().getPageActivity())) {
                    TiebaStatic.log(CommonStatisticKey.MY_SERVICE_CK);
                    if (FrsFragment.this.iou != null && FrsFragment.this.iou.getForum() != null) {
                        ForumData forum = FrsFragment.this.iou.getForum();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(forum.getId(), 0L), forum.getName(), forum.getImage_url(), 0)));
                    }
                }
            } else if (com.baidu.tbadk.core.util.bg.checkUpIsLogin(FrsFragment.this.getActivity())) {
                TiebaStatic.log("forum_fortune_click");
                com.baidu.tieba.frs.f.k.c(FrsFragment.this.getPageContext(), FrsFragment.this.iou);
            }
        }
    };
    private final NoNetworkView.a ime = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.FrsFragment.41
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (FrsFragment.this.ipp.cyE() == 1 && z && !FrsFragment.this.ioW.cti()) {
                if (FrsFragment.this.iou == null || com.baidu.tbadk.core.util.y.isEmpty(FrsFragment.this.iou.getThreadList())) {
                    FrsFragment.this.hideNetRefreshView(FrsFragment.this.ioW.cur().cAA());
                    FrsFragment.this.showLoadingView(FrsFragment.this.ioW.cew(), true);
                    FrsFragment.this.ioW.pa(false);
                    FrsFragment.this.refresh();
                    return;
                }
                FrsFragment.this.ioW.ctP();
            }
        }
    };
    private final CustomMessageListener eQI = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.FrsFragment.42
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                com.baidu.tieba.frs.f.c.a(customResponsedMessage, FrsFragment.this.ioW, FrsFragment.this.iou);
            }
        }
    };
    private com.baidu.adp.widget.ListView.ab iqH = new a();
    private av iqI = new av() { // from class: com.baidu.tieba.frs.FrsFragment.44
        @Override // com.baidu.tieba.frs.av
        public void a(int i, int i2, bd bdVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
            com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.44.1
                @Override // java.lang.Runnable
                public void run() {
                    if (FrsFragment.this.ioW != null && FrsFragment.this.ioW.cuj()) {
                        FrsFragment.this.bJG();
                    }
                }
            });
        }
    };
    private CustomMessageListener iqJ = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.frs.FrsFragment.46
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    FrsFragment.this.ipK = true;
                }
            }
        }
    };
    private CustomMessageListener iqK = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.frs.FrsFragment.47
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                    if (FrsFragment.this.ipo == null && FrsFragment.this.ioW.ctG() != null && !FrsFragment.this.ioW.cti() && FrsFragment.this.ioW.ctG().drn() != null && (FrsFragment.this.ioW.ctG().drn().getTag() instanceof com.baidu.card.am)) {
                        FrsFragment.this.ipo = (com.baidu.card.am) FrsFragment.this.ioW.ctG().drn().getTag();
                    }
                    if (FrsFragment.this.ipo != null && FrsFragment.this.ipo.tW() != null) {
                        FrsFragment.this.ipo.tW().b(new a.C0097a(3));
                    }
                }
            }
        }
    };
    private CustomMessageListener iqL = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.FrsFragment.48
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.ioW != null) {
                FrsFragment.this.ioW.FS();
            }
        }
    };
    private CustomMessageListener iqM = new CustomMessageListener(2921437) { // from class: com.baidu.tieba.frs.FrsFragment.49
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && FrsFragment.this.isResumed()) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (FrsFragment.this.ioY != null) {
                    if (booleanValue) {
                        if (FrsFragment.this.ipr.cAN() != 0 && !FrsFragment.this.ioW.cuo() && !KuangFloatingFrsCopyLinkViewController.getInstance().isFloatCopyViewShow()) {
                            FrsFragment.this.ioY.show();
                            return;
                        }
                        return;
                    }
                    FrsFragment.this.ioY.hide();
                }
            }
        }
    };
    private CustomMessageListener iqN = new CustomMessageListener(2921462) { // from class: com.baidu.tieba.frs.FrsFragment.54
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && FrsFragment.this.iou.getToLoadHorseData().intValue() == 1 && FrsFragment.this.mIsLogin) {
                LiveHorseRaceRequestMessage liveHorseRaceRequestMessage = new LiveHorseRaceRequestMessage();
                liveHorseRaceRequestMessage.setForum_id(Long.valueOf(FrsFragment.this.forumId));
                FrsFragment.this.sendMessage(liveHorseRaceRequestMessage);
            }
        }
    };
    private CustomMessageListener iqO = new CustomMessageListener(2001223) { // from class: com.baidu.tieba.frs.FrsFragment.55
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Date)) {
                FrsFragment.this.ipT = (Date) customResponsedMessage.getData();
            }
        }
    };
    private CustomMessageListener iqP = new CustomMessageListener(2921469) { // from class: com.baidu.tieba.frs.FrsFragment.57
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.x) && FrsFragment.this.isResumed()) {
                com.baidu.tbadk.core.data.x xVar = (com.baidu.tbadk.core.data.x) customResponsedMessage.getData();
                if (FrsFragment.this.iqa == null) {
                    FrsFragment.this.iqa = new com.baidu.tieba.frs.broadcast.a(FrsFragment.this.getPageContext());
                }
                if (FrsFragment.this.iou != null && FrsFragment.this.iou.getForum() != null && !TextUtils.isEmpty(FrsFragment.this.iou.getForum().getId())) {
                    FrsFragment.this.iqa.e(xVar.type, FrsFragment.this.iou.getForum().getId(), FrsFragment.this.iou.getForum().getName(), xVar.tid);
                }
            }
        }
    };
    private CustomMessageListener iqQ = new CustomMessageListener(2921475) { // from class: com.baidu.tieba.frs.FrsFragment.58
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bw bwVar = (bw) customResponsedMessage.getData();
            if (bwVar != null && FrsFragment.this.isResumed()) {
                FrsFragment.this.ipm = bwVar.getTid() + "";
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE_NUMBER);
                httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
                httpMessage.addParam("forum_id", bwVar.getFid());
                MessageManager.getInstance().sendMessage(httpMessage);
            }
        }
    };
    private HttpMessageListener iqR = new HttpMessageListener(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE_NUMBER) { // from class: com.baidu.tieba.frs.FrsFragment.59
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if ((httpResponsedMessage instanceof ForumManagerRightsResMsg) && FrsFragment.this.isResumed()) {
                ForumManagerRightsResMsg forumManagerRightsResMsg = (ForumManagerRightsResMsg) httpResponsedMessage;
                if (forumManagerRightsResMsg.broadcastTotalCount - forumManagerRightsResMsg.broadcastUsedCount <= 0) {
                    new ScreenTopToast(FrsFragment.this.getContext()).TH(FrsFragment.this.getString(R.string.frs_forum_bawu_send_broadcast_none_tip)).TJ(FrsFragment.this.getString(R.string.frs_recommend_fail_tip_btn)).ak(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.59.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("_forumId", FrsFragment.this.iou.getForum().getId());
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new com.baidu.tieba.tbadkCore.data.m(FrsFragment.this.getContext(), "ForumGradePage", hashMap)));
                        }
                    }).aH((ViewGroup) FrsFragment.this.mRootView.findViewById(R.id.frs));
                    return;
                }
                com.baidu.tbadk.core.util.o oVar = new com.baidu.tbadk.core.util.o(TbadkCoreApplication.getInst());
                oVar.ac(FrsFragment.this.iou.getForum().getId(), FrsFragment.this.iou.getForum().getName(), "6");
                oVar.Bd(FrsFragment.this.ipm);
                oVar.start();
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.frs.loadmore.a
    public /* bridge */ /* synthetic */ com.baidu.adp.base.e getPageContext() {
        return super.getPageContext();
    }

    public com.baidu.tieba.frs.entelechy.b.b csu() {
        return this.ipx;
    }

    public com.baidu.adp.widget.ListView.ab csv() {
        return this.iqH;
    }

    public com.baidu.tieba.frs.mc.d csw() {
        return this.ipz;
    }

    public com.baidu.tieba.frs.smartsort.a csx() {
        return this.ipt;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public FrsModelController csy() {
        return this.ipp;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public com.baidu.tieba.frs.mc.c csz() {
        return this.ipA;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public com.baidu.tieba.frs.vc.h csA() {
        return this.ipq;
    }

    public FrsTabViewController csB() {
        return this.ipr;
    }

    public ax csC() {
        return this.ipv;
    }

    public void oP(boolean z) {
        this.ipS = z;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public q csD() {
        return this.ioW;
    }

    @Override // com.baidu.tieba.frs.aw
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.aw, com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.ioO;
    }

    public void setForumName(String str) {
        this.ioO = str;
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
        if (this.ipA == null) {
            return 1;
        }
        return this.ipA.getPn();
    }

    public int getPn() {
        if (this.ipA == null) {
            return 1;
        }
        return this.ipA.getPn();
    }

    public void setPn(int i) {
        if (this.ipA != null) {
            this.ipA.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.ipA != null) {
            this.ipA.setHasMore(i);
        }
    }

    public int csE() {
        if (this.ipA == null) {
            return -1;
        }
        return this.ipA.csE();
    }

    public boolean csF() {
        return this.ioU;
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
            this.ioW.ctJ();
            showNetRefreshView(this.ioW.cew(), string, true);
        } else if (340001 == fVar.errorCode) {
            a(fVar, this.iou.getRecm_forum_list());
        } else {
            if (com.baidu.tbadk.core.util.y.isEmpty(this.iou.getThreadList())) {
                b(fVar);
            }
            if (ctk()) {
                setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds280));
            } else {
                setNetRefreshViewEmotionDefMarginTop();
            }
        }
    }

    public void a(View view, String str, boolean z, List<RecmForumInfo> list) {
        this.ioW.ctJ();
        this.ioW.yh(8);
        if (this.ipI == null) {
            this.ipI = new com.baidu.tieba.frs.view.a(getPageContext(), getNetRefreshListener());
        }
        this.ipI.setSubText(str);
        this.ipI.setListData(list);
        this.ipI.attachView(view, z);
    }

    private void a(com.baidu.tieba.tbadkCore.f fVar, List<RecmForumInfo> list) {
        if (this.ioW != null) {
            this.ioW.ctJ();
            this.ioW.setTitle(this.ioO);
            a(this.ioW.cew(), fVar.errorMsg, true, list);
        }
    }

    private void b(com.baidu.tieba.tbadkCore.f fVar) {
        this.ioW.ctJ();
        if (fVar.hYP) {
            showNetRefreshView(this.ioW.cew(), TbadkCoreApplication.getInst().getString(R.string.net_error_text, new Object[]{fVar.errorMsg, Integer.valueOf(fVar.errorCode)}), true);
        } else {
            showNetRefreshView(this.ioW.cur().cAA(), fVar.errorMsg, true);
        }
    }

    public void csG() {
        hideLoadingView(this.ioW.cew());
        this.ioW.bKf();
        if (this.ioW.ctH() instanceof com.baidu.tieba.frs.tab.c) {
            ((com.baidu.tieba.frs.tab.c) this.ioW.ctH()).czl();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csH() {
        if (csE() == 0 && com.baidu.tbadk.core.util.y.isEmpty(this.iou.getThreadListIds())) {
            if (com.baidu.tbadk.core.util.y.isEmpty(this.iou.getThreadList())) {
                this.ioW.bKU();
            } else {
                this.ioW.SJ();
            }
        } else if (com.baidu.tbadk.core.util.y.getCount(this.iou.getThreadList()) > 3) {
            this.ioW.SI();
        } else {
            this.ioW.cuf();
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
            csG();
            this.ioW.ctP();
            com.baidu.tieba.tbadkCore.f cyA = this.ipp.cyA();
            boolean isEmpty = com.baidu.tbadk.core.util.y.isEmpty(this.iou.getThreadList());
            if (cyA != null && isEmpty) {
                if (this.ipp.cyC() != 0) {
                    this.ipp.cyH();
                    this.ioW.ctP();
                } else {
                    a(cyA);
                }
                this.ioW.V(this.iou.isStarForum(), false);
                return;
            }
            a(cyA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(com.baidu.tieba.tbadkCore.m mVar) {
        if (mVar != null && mVar.getEntelechyTabInfo() != null && mVar.getEntelechyTabInfo().tab != null) {
            for (FrsTabInfo frsTabInfo : mVar.getEntelechyTabInfo().tab) {
                if (frsTabInfo.tab_id.intValue() == 502 && com.baidu.tbadk.core.sharedPref.b.blO().getBoolean("first_into_tab_profession", true)) {
                    return false;
                }
            }
        }
        return new com.baidu.tieba.frs.ad.f(getTbPageContext()).d(mVar);
    }

    public boolean csI() {
        return csJ() && !csK();
    }

    private boolean csJ() {
        if (cth() == null) {
            return false;
        }
        FrsViewData cth = cth();
        com.baidu.tbadk.core.data.y yVar = null;
        if (cth.getStar() != null && !StringUtils.isNull(cth.getStar().dDC())) {
            yVar = new com.baidu.tbadk.core.data.y();
        } else if (cth.getActivityHeadData() != null && com.baidu.tbadk.core.util.y.getCount(cth.getActivityHeadData().bgl()) >= 1) {
            yVar = cth.getActivityHeadData().bgl().get(0);
        }
        return yVar != null;
    }

    public boolean csK() {
        if (cth() == null) {
            return false;
        }
        FrsViewData cth = cth();
        return (com.baidu.tbadk.core.util.y.isEmpty(cth.getShowTopThreadList()) && cth.getBusinessPromot() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csL() {
        boolean b;
        if (!csN()) {
            final PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
            privateForumPopInfoData.a(this.iou.getPrivateForumTotalInfo().getPrivatePopInfo());
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(getActivity());
            if (this.iou.getPrivateForumTotalInfo().bhe().private_forum_status.intValue() == 1 && (com.baidu.tbadk.core.util.at.isEmpty(privateForumPopInfoData.bhg()) || privateForumPopInfoData.bhj() != Integer.valueOf(this.forumId))) {
                privateForumPopInfoData.Ak("create_success");
                privateForumPopInfoData.Al(TbadkCoreApplication.getInst().getString(R.string.frs_private_create_hint));
                privateForumPopInfoData.Am("https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.ioO + "&nomenu=1");
                privateForumPopInfoData.k(Integer.valueOf(this.forumId));
                b = frsPrivateCommonDialogView.b(privateForumPopInfoData);
            } else {
                b = privateForumPopInfoData.bhj() == Integer.valueOf(this.forumId) ? frsPrivateCommonDialogView.b(privateForumPopInfoData) : false;
            }
            if (b) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
                aVar.oe(2);
                aVar.ba(frsPrivateCommonDialogView);
                aVar.iA(false);
                frsPrivateCommonDialogView.setConfirmButton(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.19
                    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.frs.FrsFragment */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        com.baidu.tbadk.core.util.be.bmY().b(FrsFragment.this.getPageContext(), new String[]{privateForumPopInfoData.bhi()});
                        aVar.dismiss();
                    }
                });
                aVar.a(new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.20
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(getPageContext()).bkJ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csM() {
        if (csN() || this.iou.getPrivateForumTotalInfo().bhe().private_forum_status.intValue() != 1) {
            a((Integer) null, (Integer) null, true);
        } else {
            a(this.iou.getPrivateForumTotalInfo().bhe().private_forum_audit_status, this.iou.getPrivateForumTotalInfo().bhf(), false);
        }
    }

    public void a(Integer num, Integer num2, boolean z) {
        final String str;
        final int i = 2;
        if (this.ioW.ctV() != null) {
            TextView ctV = this.ioW.ctV();
            if (z) {
                ctV.setVisibility(8);
                return;
            }
            if (num.intValue() == 2) {
                ctV.setText("修改实名认证信息");
                ctV.setVisibility(0);
                str = "https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + this.forumId + "&nomenu=1";
            } else if (num2.intValue() >= 0 && num2.intValue() <= 100) {
                ctV.setText("目标已完成" + String.valueOf(num2) + "%");
                ctV.setVisibility(0);
                str = "https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.ioO + "&nomenu=1";
                i = 1;
            } else {
                ctV.setVisibility(8);
                i = 0;
                str = "";
            }
            ctV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.21
                /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13387").dK("fid", FrsFragment.this.forumId).dK("uid", TbadkCoreApplication.getCurrentAccount()).aj("obj_type", i));
                    com.baidu.tbadk.core.util.be.bmY().b(FrsFragment.this.getPageContext(), new String[]{str});
                }
            });
        }
    }

    private boolean csN() {
        return this.iou == null || this.iou.getPrivateForumTotalInfo() == null || this.iou.getPrivateForumTotalInfo().bhe() == null || this.iou.getUserData().getIs_manager() != 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xW(int i) {
        List<WindowToast> list;
        if (TbadkCoreApplication.isLogin() && this.iou != null && (list = this.iou.mWindowToast) != null && list.size() > 0) {
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
    public void csO() {
        if (getActivity() != null && getActivity().getIntent() != null) {
            String stringExtra = getActivity().getIntent().getStringExtra(FrsActivityConfig.KEY_ACHIEVEMENT_URL);
            if (!TextUtils.isEmpty(stringExtra)) {
                getActivity().getIntent().removeExtra(FrsActivityConfig.KEY_ACHIEVEMENT_URL);
                AchievementActivityConfig achievementActivityConfig = new AchievementActivityConfig(getActivity());
                achievementActivityConfig.setUrl(stringExtra);
                if (this.iou != null && this.iou.getForumActiveInfo() != null) {
                    achievementActivityConfig.setShareUrl(this.iou.getForumActiveInfo().forum_share_url);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, achievementActivityConfig));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csP() {
        if (this.iou == null || this.iou.getForum() != null) {
            this.ioW.cub();
        } else if (this.iou.getForum().getYuleData() != null && this.iou.getForum().getYuleData().bkA()) {
            TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_VIEW);
            this.ioW.a(this.iou.getForum().getYuleData().bkB());
        } else {
            this.ioW.cub();
        }
    }

    private void T(boolean z, boolean z2) {
        if (this.ipp != null && this.iou != null && this.ioW != null && z) {
            if (!this.ipp.cyO() && this.ipp.cyE() == 1) {
                if (!this.ipp.cyM()) {
                    this.iou.addCardVideoInfoToThreadList();
                    this.iou.addVideoInfoToThreadListInTenAndFifteenFloor();
                }
                boolean z3 = false;
                if (this.ioW.cuc().r(com.baidu.tieba.card.data.o.hJy)) {
                    z3 = this.iou.addHotTopicDataToThreadList();
                }
                if (!z3) {
                    this.iou.addFeedForumDataToThreadList();
                }
                if (TbadkCoreApplication.getInst().isRecAppExist()) {
                    this.iou.addRecommendAppToThreadList(this);
                }
                if (!this.ioW.cuc().r(bw.epI)) {
                    this.iou.removeAlaLiveThreadData();
                }
                this.iou.addSchoolRecommendToThreadList();
            }
            if (!this.ioW.cuc().r(bw.epI)) {
                this.iou.removeAlaInsertLiveData();
                this.iou.removeAlaStageLiveDat();
            } else {
                this.iou.addInsertLiveDataToThreadList();
                this.iou.addStageLiveDataToThreadList();
            }
            this.iou.checkLiveStageInThreadList();
            this.iou.addNoticeThreadToThreadList();
            if (this.ioW.cuc().r(com.baidu.tieba.h.b.iXj)) {
                this.iou.addGameRankListToThreadList(z2);
            }
            if (TbadkCoreApplication.isLogin() && (!this.ipp.cyO() || this.ipp.isNetFirstLoad)) {
                this.iou.addUserRecommendToThreadList();
            }
            this.iou.addVideoActivityToTop();
        }
    }

    public boolean csQ() {
        if (this.ipq != null && this.ipp != null) {
            this.ipq.a(this.ipp.getPageType(), this.iou);
        }
        boolean z = false;
        if (this.iou != null) {
            z = this.iou.hasTab();
        }
        csT();
        if (this.ioW != null) {
            this.ioW.cup();
            this.ioW.cuq();
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xX(int i) {
        ba baVar = null;
        csQ();
        ctc();
        try {
            if (this.iou != null) {
                this.ioW.a((ArrayList<com.baidu.adp.widget.ListView.q>) null, this.iou);
                this.ipq.zQ(1);
                this.ioW.ctS();
                this.ipr.a(this.iou, this.ipp.cyJ());
                com.baidu.tieba.frs.tab.d zZ = this.ipr.zZ(this.iou.getFrsDefaultTabId());
                if (zZ != null && !TextUtils.isEmpty(zZ.url)) {
                    baVar = new ba();
                    baVar.ext = zZ.url;
                    baVar.stType = zZ.name;
                }
                this.ipp.a(this.iou.getFrsDefaultTabId(), 0, baVar);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(boolean z, boolean z2) {
        try {
            if (this.iou != null && this.ipr != null && this.ipp != null) {
                if (!this.ioW.cuc().r(bw.epI)) {
                    this.iou.removeAlaLiveThreadData();
                }
                boolean isEmpty = com.baidu.tbadk.core.util.y.isEmpty(this.iou.getGameTabInfo());
                this.ioW.oY(isEmpty);
                if (!isEmpty) {
                    if (this.ipJ == null) {
                        this.ipJ = new com.baidu.tieba.frs.vc.e(this, (NoPressedRelativeLayout) this.mRootView);
                    }
                    if (this.gns == null) {
                        this.gns = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
                    }
                } else {
                    this.ipJ = null;
                    this.gns = null;
                }
                if (this.iou.getForum() != null) {
                    this.ioO = this.iou.getForum().getName();
                    this.forumId = this.iou.getForum().getId();
                }
                if (this.iou.hasTab()) {
                    this.ipr.a(this.iou, this.ipp.cyJ());
                }
                if (z) {
                    T(true, z);
                } else {
                    T(this.ipk, z);
                }
                csQ();
                if (this.ipx != null) {
                    this.ipx.a(this.ipq, this.iou);
                }
                if (this.iou.getPage() != null) {
                    setHasMore(this.iou.getPage().bgX());
                }
                ArrayList<com.baidu.adp.widget.ListView.q> a2 = this.ipA.a(z2, true, this.iou.getThreadList(), null, z, false);
                if (a2 != null) {
                    this.iou.setThreadList(a2);
                }
                this.iou.removeRedundantUserRecommendData();
                this.iow = this.iou.getTopThreadSize();
                if (this.ioS != null) {
                    this.ioR = true;
                    this.ioS.IU(this.iow);
                    com.baidu.tieba.frs.f.a.a(this, this.iou.getForum(), this.iou.getThreadList(), this.ioR, getPn());
                }
                if (this.ipp.cyE() == 1) {
                    csX();
                    if (!z && this.ipp.getPn() == 1) {
                        csS();
                    }
                }
                if (this.ipy != null) {
                    this.ipy.cz(this.ipr.cAJ());
                }
                csG();
                this.ioW.ctK();
                this.ioW.V(true, false);
                if (z && this.iou.isFirstTabEqualAllThread()) {
                    com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.22
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!FrsFragment.this.iph && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                FrsFragment.this.ioW.cun();
                            }
                        }
                    });
                }
                if (this.iou.getForum() != null) {
                    this.ioW.JB(this.iou.getForum().getWarningMsg());
                }
                if (this.iou != null && this.iou.getFrsVideoActivityData() != null && com.baidu.tbadk.core.sharedPref.b.blO().getLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 0L) == 0) {
                    com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.24
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsFragment.this.ioW.cul();
                        }
                    }, 1000L);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FRS_SHOW_AR_ENTRY, this));
                this.ioW.ctE();
                if (this.iou != null && this.iou.getForum() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ENTER_FORUM, new VisitedForumData(this.iou.getForum().getId(), this.iou.getForum().getName(), this.iou.getForum().getImage_url(), String.valueOf(System.currentTimeMillis() / 1000), ConstantData.Forum.SPECAIL_FORUM_TYPE_LIVE.equals(this.iou.getForum().special_forum_type), this.iou.getForum().getThemeColorInfo(), this.iou.getForum().getMember_num())));
                }
                this.ipN.a(this.iou.bottomMenuList, this.iou.getForum());
                ctr();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void csR() {
        if (this.ipp != null && this.ipp.cyE() == 1) {
            this.ipq.j(this.iou);
        }
    }

    public void oQ(boolean z) {
        com.baidu.tieba.s.c.dDn().b(getUniqueId(), z);
    }

    public void csS() {
        if (this.ipD == null) {
            this.ipD = new com.baidu.tieba.frs.live.a(this, com.baidu.adp.lib.f.b.toInt(this.forumId, 0));
        }
        this.ipD.cyl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.tbadkCore.m mVar) {
        try {
            if (!this.iph && mVar != null && this.iou != null) {
                this.iou.receiveData(mVar);
                U(true, false);
                Looper.myQueue().addIdleHandler(this.iqc);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void csT() {
        if (this.ipp != null) {
            JA(this.ipp.getPageType());
        } else {
            JA("normal_page");
        }
    }

    private void JA(String str) {
        oR("frs_page".equals(str));
        if (this.ipx != null) {
            this.ipx.a(this.ipq, this.ioW, this.iou);
        }
    }

    public void oR(boolean z) {
        if (this.ipB != null) {
            this.ipB.cAv();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.s.c.dDn().z(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.frs_activity, viewGroup, false);
            this.ioI = new com.baidu.tieba.frs.entelechy.a();
            this.ipx = this.ioI.cvY();
            this.ioH = TbadkCoreApplication.getInst().getString(R.string.frs_title_new_area);
            this.ipq = new com.baidu.tieba.frs.vc.h(this, this.ioI, (FrsHeaderViewContainer) this.mRootView.findViewById(R.id.header_view_container));
            this.ipr = new FrsTabViewController(this, this.mRootView);
            this.ipr.registerListener();
            this.ipq.a(this.ipr);
            this.ipr.a(this.iqk);
            Intent intent = getActivity().getIntent();
            if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                this.ioK = true;
            }
            this.ioW = new q(this, this.iqF, this.ioI, this.ioK, this.ipq);
            this.ipN = new com.baidu.tieba.frs.brand.buttommenu.a(getPageContext(), this.mRootView);
        } else {
            if (this.mRootView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            if (this.ipr != null) {
                this.ipr.registerListener();
            }
            this.ioW.cuk();
            this.mRootView.setLeft(0);
            this.mRootView.setRight(com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getContext()));
        }
        this.ipR = true;
        this.fgN = System.currentTimeMillis() - currentTimeMillis;
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        ArrayList<com.baidu.adp.widget.ListView.q> arrayList = null;
        this.hRt = System.currentTimeMillis();
        long j = this.hRt;
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.ioT = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.hRt = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            R(intent);
        }
        this.fgM = j - this.hRt;
        this.ioS = new com.baidu.tieba.tbadkCore.data.f("frs", com.baidu.tieba.tbadkCore.data.f.mDG);
        if (this.ipp == null) {
            this.ipp = new FrsModelController(this, this.iqA);
            this.ipp.a(this.iqj);
            this.ipp.init();
        }
        this.ipp.setSchemeUrl(this.mSchemeUrl);
        if (intent != null) {
            this.ipp.aj(intent.getExtras());
        } else if (bundle != null) {
            this.ipp.aj(bundle);
        } else {
            this.ipp.aj(null);
        }
        if (intent != null) {
            this.ipq.aq(intent.getExtras());
        } else if (bundle != null) {
            this.ipq.aq(bundle);
        } else {
            this.ipq.aq(null);
        }
        this.ioV = getVoiceManager();
        this.ipE = new p(getPageContext(), this);
        initUI();
        initData(bundle);
        if (!ctk()) {
            this.ipv = new ax(getActivity(), this.ioW, this.ipq);
            this.ipv.pn(true);
        }
        this.ioV = getVoiceManager();
        if (this.ioV != null) {
            this.ioV.onCreate(getPageContext());
        }
        if (FrsActivityConfig.FRS_FROM_FLUTTER_BCASTEDIT.equals(getFrom()) && !this.hasInit) {
            int i = com.baidu.tbadk.core.sharedPref.b.blO().getInt("key_forum_broadcast_edit_tip_number", 0);
            if (i < 2) {
                com.baidu.tbadk.core.sharedPref.b.blO().putInt("key_forum_broadcast_edit_tip_number", i + 1);
                csZ();
            } else if (Build.VERSION.SDK_INT >= 23) {
                if (Settings.canDrawOverlays(getContext())) {
                    cta();
                } else {
                    new BdTopToast(getContext()).xK(false).TD(getContext().getString(R.string.forum_broadcast_copy_no_permission_hint)).aH(this.ioW.cew());
                }
            } else {
                cta();
            }
        }
        if (KuangFloatingFrsCopyLinkViewController.getInstance().isFloatCopyViewShow()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
            if (this.ioX != null) {
                this.ioX.setVisibility(8);
            }
        }
        new com.baidu.tieba.frs.mc.i();
        int i2 = -1;
        if (this.ipA != null && this.ipA.cyw() != null) {
            i2 = this.ipA.cyw().csE();
            arrayList = this.ipA.cyw().getDataList();
        }
        this.ipA = new com.baidu.tieba.frs.mc.c(this, this.iqD);
        this.ipA.cyw().setHasMore(i2);
        if (arrayList != null && arrayList.size() > 0) {
            this.ipA.cyw().aE(arrayList);
        }
        this.ipt = new com.baidu.tieba.frs.smartsort.a(this);
        this.ipB = new com.baidu.tieba.frs.vc.j(this);
        this.ipy = new com.baidu.tieba.frs.vc.a(getPageContext(), this.ipp.cyL());
        this.ipu = new com.baidu.tieba.frs.mc.b(this);
        this.ipz = new com.baidu.tieba.frs.mc.d(this);
        this.ips = new com.baidu.tieba.frs.mc.h(this);
        this.ipC = new com.baidu.tieba.frs.mc.a(this);
        this.ipF = new com.baidu.tieba.frs.vc.c(this);
        this.ipG = new com.baidu.tieba.frs.mc.e(this, getUniqueId());
        this.ipL = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "frs");
        this.ipM = new com.baidu.tieba.ala.a(getPageContext());
        this.ipO = new com.baidu.tieba.frs.sportspage.notification.a(getPageContext());
        registerListener(this.iqs);
        registerListener(this.mMemListener);
        registerListener(this.iqq);
        registerListener(this.iqE);
        registerListener(this.iqB);
        registerListener(this.iqm);
        registerListener(this.iqn);
        registerListener(this.iqo);
        registerListener(this.iqp);
        registerListener(this.iqd);
        registerListener(this.iqe);
        registerListener(this.agA);
        registerListener(this.iqf);
        registerListener(this.iqJ);
        registerListener(this.iqu);
        registerListener(this.iqi);
        registerListener(this.iqv);
        registerListener(this.iqt);
        registerListener(this.iqx);
        registerListener(this.iqy);
        registerListener(this.iqz);
        this.iqK.setTag(getPageContext().getUniqueId());
        MessageManager.getInstance().registerListener(this.iqK);
        registerListener(this.iqL);
        registerListener(this.iqM);
        registerListener(this.iqN);
        registerListener(this.iqh);
        registerListener(this.iqO);
        registerListener(this.iqw);
        registerListener(this.iqg);
        registerListener(this.iqP);
        registerListener(this.iqQ);
        registerListener(this.iqR);
        this.ioW.pa(false);
        if (!ctk() && !this.hasInit) {
            showLoadingView(this.ioW.cew(), true);
            this.ipp.T(3, false);
        }
        ay ayVar = new ay() { // from class: com.baidu.tieba.frs.FrsFragment.27
            @Override // com.baidu.tieba.frs.ay
            public void d(boolean z, boolean z2, int i3) {
                if (FrsFragment.this.ioW != null) {
                    if (i3 == 1) {
                        FrsFragment.this.ioW.yi(z ? 0 : 8);
                    } else if (i3 == 2) {
                        FrsFragment.this.ioW.yk(z ? 0 : 8);
                    }
                    if (!z2) {
                        FrsFragment.this.ipQ = z;
                    }
                    if (FrsFragment.this.ioW.cuc() != null && (i3 == 2 || (FrsFragment.this.ipp != null && FrsFragment.this.ipp.cyF()))) {
                        FrsFragment.this.ioW.cuc().notifyDataSetChanged();
                    }
                    if (FrsFragment.this.csB() != null) {
                        FrsTabViewController.b cAK = FrsFragment.this.csB().cAK();
                        if (cAK != null) {
                            if ((cAK.fragment instanceof FrsCommonTabFragment) && (i3 == 2 || cAK.tabId == 502)) {
                                ((FrsCommonTabFragment) cAK.fragment).cvO();
                            } else if ((cAK.fragment instanceof FrsNewAreaFragment) && (i3 == 2 || cAK.tabId == 503)) {
                                FrsNewAreaFragment frsNewAreaFragment = (FrsNewAreaFragment) cAK.fragment;
                                frsNewAreaFragment.cvO();
                                if (frsNewAreaFragment.cyW() != null) {
                                    com.baidu.tieba.frs.mc.g cyW = frsNewAreaFragment.cyW();
                                    cyW.pp(!z);
                                    if (i3 == 1) {
                                        cyW.pd(!z);
                                    } else if (i3 == 2) {
                                        cyW.pd(true);
                                    }
                                }
                            } else if (cAK.fragment instanceof FrsGoodFragment) {
                                ((FrsGoodFragment) cAK.fragment).cvO();
                            }
                        }
                        if (FrsFragment.this.csB().cAB() != null) {
                            FrsFragment.this.csB().cAB().setmDisallowSlip(z);
                            FrsFragment.this.csB().pU(z);
                        }
                    }
                    if (FrsFragment.this.ioW.ctI() != null) {
                        FrsFragment.this.ioW.oX(!z);
                    }
                    if (FrsFragment.this.getActivity() instanceof FrsActivity) {
                        ((FrsActivity) FrsFragment.this.getActivity()).oO(!z);
                    }
                    if (FrsFragment.this.ipN != null) {
                        FrsFragment.this.ipN.pv(!z);
                    }
                    FrsFragment.this.ioW.pc(!z);
                    if (i3 == 1) {
                        FrsFragment.this.ioW.pd(z ? false : true);
                    } else if (i3 == 2) {
                        FrsFragment.this.ioW.pd(true);
                    }
                }
            }

            @Override // com.baidu.tieba.frs.ay
            public void ci(int i3, int i4) {
                if (FrsFragment.this.ioW != null) {
                    if (i4 == 1) {
                        FrsFragment.this.ioW.yj(i3);
                    } else if (i4 == 2) {
                        FrsFragment.this.ioW.yl(i3);
                    }
                }
            }

            @Override // com.baidu.tieba.frs.ay
            public void yb(int i3) {
                if (FrsFragment.this.getContext() != null) {
                    if (i3 == 1) {
                        com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getContext(), R.string.frs_multi_delete_max_num);
                    } else if (i3 == 2 && FrsFragment.this.ioW != null) {
                        new BdTopToast(FrsFragment.this.getContext()).xK(false).TD(FrsFragment.this.getContext().getString(R.string.frs_move_area_max_num)).aH(FrsFragment.this.ioW.cew());
                    }
                }
            }
        };
        b.crE().a(ayVar);
        com.baidu.tieba.frs.a.crx().a(ayVar);
        this.ioW.b(new d.a() { // from class: com.baidu.tieba.frs.FrsFragment.28
            @Override // com.baidu.tieba.NEGFeedBack.d.a
            public void a(DeleteThreadHttpResponseMessage deleteThreadHttpResponseMessage) {
                boolean z;
                int i3 = 0;
                if (deleteThreadHttpResponseMessage != null) {
                    FrsFragment.this.ioW.bEe();
                    FrsFragment.this.ioW.cum();
                    FrsNewAreaFragment frsNewAreaFragment = null;
                    if (FrsFragment.this.ipr == null || FrsFragment.this.ipr.cAK() == null || !(FrsFragment.this.ipr.cAK().fragment instanceof FrsNewAreaFragment)) {
                        z = false;
                    } else {
                        frsNewAreaFragment = (FrsNewAreaFragment) FrsFragment.this.ipr.cAK().fragment;
                        z = true;
                    }
                    if (deleteThreadHttpResponseMessage.getError() == 0) {
                        String text = !TextUtils.isEmpty(deleteThreadHttpResponseMessage.getText()) ? deleteThreadHttpResponseMessage.getText() : FrsFragment.this.getString(R.string.delete_fail);
                        if (deleteThreadHttpResponseMessage.getRetType() == 1211066) {
                            if (FrsFragment.this.hHW == null) {
                                FrsFragment.this.hHW = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.hHW.AH(text);
                            FrsFragment.this.hHW.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.28.1
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.hHW.iA(false);
                            FrsFragment.this.hHW.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.hHW.bkJ();
                        } else if (deleteThreadHttpResponseMessage.getRetType() == 1211067) {
                            if (FrsFragment.this.hHW == null) {
                                FrsFragment.this.hHW = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.hHW.AH(text);
                            FrsFragment.this.hHW.a(R.string.know, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.28.2
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.hHW.iA(false);
                            FrsFragment.this.hHW.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.hHW.bkJ();
                        } else {
                            FrsFragment.this.ioW.aM(deleteThreadHttpResponseMessage.getText(), ContextCompat.getColor(FrsFragment.this.getContext(), deleteThreadHttpResponseMessage.getRetType() == 1 ? R.color.nav_bar_tip_error : R.color.cp_link_tip_a_alpha95));
                        }
                        if (z && frsNewAreaFragment != null) {
                            frsNewAreaFragment.cY(deleteThreadHttpResponseMessage.getSuccessItems());
                        }
                        FrsFragment.this.cM(deleteThreadHttpResponseMessage.getSuccessItems());
                        b.crE().cL(deleteThreadHttpResponseMessage.getSuccessItems());
                        for (com.baidu.adp.widget.ListView.q qVar : FrsFragment.this.iou.getThreadList()) {
                            if (qVar instanceof bv) {
                                i3++;
                                continue;
                            }
                            if (i3 >= 6) {
                                break;
                            }
                        }
                        if (i3 < 6) {
                            FrsFragment.this.bJG();
                            return;
                        }
                        return;
                    }
                    com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getActivity(), deleteThreadHttpResponseMessage.getErrorString());
                }
            }
        });
        this.dvr = UtilHelper.getScreenHeight(getActivity());
        this.hasInit = true;
        xY(1);
        super.onActivityCreated(bundle);
        this.createTime = System.currentTimeMillis() - j;
    }

    public void oS(boolean z) {
        if (this.ipr != null) {
            this.ipr.iRB = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cM(List<String> list) {
        if (!com.baidu.tbadk.core.util.y.isEmpty(list)) {
            ArrayList<com.baidu.adp.widget.ListView.q> threadList = this.iou.getThreadList();
            if (!com.baidu.tbadk.core.util.y.isEmpty(threadList) && this.ioW.getListView() != null && this.ioW.getListView().getData() != null) {
                Iterator<com.baidu.adp.widget.ListView.q> it = threadList.iterator();
                List<com.baidu.adp.widget.ListView.q> data = this.ioW.getListView().getData();
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.q next = it.next();
                    if (next instanceof bv) {
                        bw bwVar = ((bv) next).eji;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= list.size()) {
                                break;
                            } else if (!com.baidu.tbadk.core.util.at.equals(list.get(i2), bwVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.ipA.d(next);
                                this.ioW.getListView().getAdapter().notifyItemRemoved(i);
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
    public void crC() {
        if (!com.baidu.tbadk.core.util.y.isEmpty(com.baidu.tieba.frs.a.crx().crB()) && this.ioW.getListView() != null && this.ioW.getListView().getData() != null) {
            ArrayList<com.baidu.adp.widget.ListView.q> threadList = this.iou.getThreadList();
            if (!com.baidu.tbadk.core.util.y.isEmpty(threadList)) {
                Iterator<com.baidu.adp.widget.ListView.q> it = threadList.iterator();
                List<com.baidu.adp.widget.ListView.q> data = this.ioW.getListView().getData();
                int count = com.baidu.tbadk.core.util.y.getCount(com.baidu.tieba.frs.a.crx().crB());
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.q next = it.next();
                    if (next instanceof bv) {
                        bw bwVar = ((bv) next).eji;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= count) {
                                break;
                            } else if (!com.baidu.tbadk.core.util.at.equals(com.baidu.tieba.frs.a.crx().crB().get(i2).getId(), bwVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.ipA.d(next);
                                this.ioW.getListView().getAdapter().notifyItemRemoved(i);
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
    public void bKa() {
        if (isAdded() && this.fWp && !isLoadingViewAttached()) {
            showLoadingView(this.ioW.cew(), true);
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void bKb() {
        if (isAdded() && this.fWp && isLoadingViewAttached()) {
            hideLoadingView(this.ioW.cew());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (ctk()) {
            showLoadingView(this.ioW.cew(), true);
            this.ioW.ym(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.ipp.S(3, true);
            boH().scrollToPosition(0);
        }
    }

    private void xY(int i) {
        String str = "";
        if (this.iou != null && this.iou.getForum() != null) {
            str = this.iou.getForum().getId();
        }
        if (!StringUtils.isNull(str)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13008").dK("fid", str).dK("obj_type", "4").aj("obj_locate", i).dK("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.ab abVar) {
        if (abVar != null) {
            this.fkJ = abVar.bzA();
            this.ipH = abVar.bzB();
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void showFloatingView() {
        if (this.fkJ != null) {
            this.fkJ.showFloatingView(true);
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
                this.ioO = uri.getQueryParameter("name");
                this.mFrom = uri.getQueryParameter("from");
                if (!StringUtils.isNull(this.ioO)) {
                    intent.putExtra("name", this.ioO);
                }
                if (!StringUtils.isNull(this.mFrom)) {
                    intent.putExtra("from", this.mFrom);
                }
                TiebaStatic.log(TbadkCoreStatisticKey.AS_INVOKE_TIEBA);
            }
            if (StringUtils.isNull(this.ioO) && uri != null) {
                if (com.baidu.tbadk.BdToken.f.p(uri)) {
                    com.baidu.tbadk.BdToken.f.bcg().b(uri, this.iqC);
                } else {
                    com.baidu.tieba.frs.f.f U = com.baidu.tieba.frs.f.k.U(intent);
                    if (U != null) {
                        this.ioO = U.forumName;
                        if (U.iPh == null || U.iPh.equals("aidou")) {
                        }
                    }
                }
                if (!StringUtils.isNull(this.ioO)) {
                    intent.putExtra("name", this.ioO);
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
                if (hashMap.get(com.baidu.tbadk.BdToken.f.edq) instanceof String) {
                    FrsFragment.this.ioO = (String) hashMap.get(com.baidu.tbadk.BdToken.f.edq);
                }
                if ((hashMap.get(com.baidu.tbadk.BdToken.f.edI) instanceof String) && !TextUtils.isEmpty((String) hashMap.get(com.baidu.tbadk.BdToken.f.edI))) {
                    com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.29.1
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsFragment.this.ipr.sL(301);
                            final long j = com.baidu.adp.lib.f.b.toLong((String) hashMap.get(com.baidu.tbadk.BdToken.f.edr), 0L);
                            final int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
                            final int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
                            final float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                            final int i = 1;
                            if (com.baidu.tbadk.core.util.au.bmV().bmW()) {
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
        this.ioV = getVoiceManager();
        if (this.ioV != null) {
            this.ioV.onStart(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        Intent intent;
        long j = 0;
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.eQI);
        if (bundle != null) {
            this.ioO = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            j = bundle.getLong(FrsActivityConfig.FRS_FAKE_THREAD_ID, 0L);
        } else if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
            this.ioO = intent.getStringExtra("name");
            this.mFrom = intent.getStringExtra("from");
            this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
            j = intent.getLongExtra(FrsActivityConfig.FRS_FAKE_THREAD_ID, 0L);
        }
        if (getArguments() != null) {
            this.ioP = getArguments().getBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, false);
        }
        if (TextUtils.isEmpty(this.mFrom) || FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
        }
        if (this.mIsLogin) {
            registerListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL, this.eQI);
        }
        this.ipq.aq(bundle);
        fh(j);
    }

    private void fh(final long j) {
        if (j > 0) {
            final int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
            final int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
            final float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            final int i = 1;
            if (com.baidu.tbadk.core.util.au.bmV().bmW()) {
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
        com.baidu.tieba.s.c.dDn().A(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.iqJ);
        this.ipB.destroy();
        ipa = null;
        if (this.ioV != null) {
            this.ioV.onDestory(getPageContext());
        }
        com.baidu.tieba.recapp.report.a.remove("FRS");
        this.ioV = null;
        com.baidu.tieba.card.s.ciJ().nX(false);
        if (this.iou != null && this.iou.getForum() != null) {
            ak.cuM().fi(com.baidu.adp.lib.f.b.toLong(this.iou.getForum().getId(), 0L));
        }
        if (this.ipD != null) {
            this.ipD.onDestory();
        }
        if (this.ioW != null) {
            com.baidu.tieba.frs.f.j.a(this.ioW, this.iou, getForumId(), false, null);
            this.ioW.onDestroy();
        }
        if (this.ioZ != null) {
            this.ioZ.removeAllViews();
            this.ioZ.setVisibility(8);
        }
        if (this.ipX != null) {
            this.ipX.cancel();
        }
        if (this.ipY != null) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.ipY);
        }
        this.ipW = null;
        super.onDestroy();
        try {
            if (this.ipj != null) {
                this.ipj.bxU();
            }
            if (this.ioW != null) {
                this.ioW.release();
            }
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.ipq.cyd();
        Looper.myQueue().removeIdleHandler(this.iqc);
        if (this.ipp != null) {
            this.ipp.bQq();
        }
        if (this.ipv != null) {
            this.ipv.cuU();
        }
        if (this.ipy != null) {
            this.ipy.destory();
        }
        if (this.ipt != null) {
            this.ipt.onDestroy();
        }
        if (this.ipJ != null) {
            this.ipJ.onDestory();
        }
        if (this.ipC != null) {
            this.ipC.onDestroy();
        }
        if (this.ipL != null) {
            this.ipL.onDestroy();
        }
        if (this.ipM != null) {
            this.ipM.onDestroy();
        }
        com.baidu.tieba.recapp.d.a.dvt().dvw();
        com.baidu.tieba.frs.f.l.czD();
        if (this.ipr != null) {
            this.ipr.a((FrsTabViewController.a) null);
            this.ipr.cAM();
        }
        if (this.ipP != null) {
            this.ipP.onDestroy();
        }
        b.crE().a(null);
        com.baidu.tieba.frs.a.crx().a(null);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.ioO);
        bundle.putString("from", this.mFrom);
        this.ipp.onSaveInstanceState(bundle);
        if (this.ioV != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            this.ioV.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.ipC != null) {
            this.ipC.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.ioW != null) {
            this.ioW.ctP();
            this.ioW.onResume();
        }
        this.ips.pM(true);
        this.ipk = true;
        if (ioN) {
            ioN = false;
            if (this.ioW != null) {
                this.ioW.startPullRefresh();
                return;
            }
            return;
        }
        if (this.ioV != null) {
            this.ioV.onResume(getPageContext());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_RESUME));
        if (this.ioW != null) {
            this.ioW.pe(false);
        }
        if (this.ipK) {
            refresh(6);
            this.ipK = false;
        }
        if (this.ipT != null && getActivity() != null) {
            if (NotificationManagerCompat.from(getActivity()).areNotificationsEnabled()) {
                com.baidu.tbadk.coreExtra.messageCenter.f.bsy().setSignAlertOn(true);
                com.baidu.tbadk.coreExtra.messageCenter.f.bsy().setSignAlertTime(this.ipT.getHours(), this.ipT.getMinutes());
                if (this.ioW != null) {
                    com.baidu.tbadk.coreExtra.messageCenter.f.bsy().a(getTbPageContext().getPageActivity(), this.ioW.cew());
                }
            }
            this.ipT = null;
        }
        ctr();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
    }

    public boolean csU() {
        Intent intent;
        if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
            return false;
        }
        return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
    }

    public void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.ioO = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.ioQ = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.ioQ) {
                csV();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csV() {
        this.ioW.startPullRefresh();
    }

    public void closeActivity() {
        com.baidu.tieba.frs.f.k.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.mFrom);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.ioW.setTitle(this.ioO);
        } else {
            this.ioW.setTitle("");
            this.mFlag = 1;
        }
        this.ioW.a(this.iqH);
        this.ioW.addOnScrollListener(this.mScrollListener);
        this.ioW.g(this.ime);
        this.ioW.cuc().a(this.iqG);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.ipR) {
            this.ioW.onChangeSkinType(i);
            this.ipq.zP(i);
            this.ipr.onChangeSkinType(i);
            if (this.ioY != null) {
                this.ioY.onChangeSkinType(i);
            }
            if (this.ipI != null) {
                this.ipI.onChangeSkinType();
            }
            if (this.ipN != null) {
                this.ipN.onChangeSkinType(getPageContext(), i);
            }
            if (this.hHW != null) {
                com.baidu.tbadk.r.a.a(getPageContext(), this.hHW.getRealView());
            }
            if (this.ipJ != null) {
                this.ipJ.onChangeSkinType(getPageContext(), i);
            }
        }
    }

    public void xZ(int i) {
        if (!this.mIsLogin) {
            if (this.iou != null && this.iou.getAnti() != null) {
                this.iou.getAnti().setIfpost(1);
            }
            if (i == 0) {
                com.baidu.tbadk.core.util.bg.skipToLoginActivity(getActivity());
            }
        } else if (this.iou != null) {
            if (i == 0) {
                com.baidu.tieba.frs.f.l.g(this, 0);
            } else {
                this.ioW.ctR();
            }
        }
    }

    public void refresh() {
        com.baidu.tieba.a.d.bEz().Er("page_frs");
        refresh(3);
    }

    public void refresh(int i) {
        this.iph = false;
        ctc();
        if (this.ioW != null && this.ioW.ctG() != null) {
            this.ioW.ctG().cEF();
        }
        if (this.ipp != null) {
            this.ipp.S(i, true);
        }
    }

    private void csW() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.f.h.mZ().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.35
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.Sf(FrsFragment.this.ioO);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csX() {
        ctc();
        try {
            if (this.iou != null) {
                this.ioW.bPU();
                this.ioW.oX(ctq());
                if (!com.baidu.tieba.frs.vc.h.m(this.iou) || !com.baidu.tieba.frs.vc.h.l(this.iou)) {
                }
                if (this.iou.getForum() != null) {
                    this.ioO = this.iou.getForum().getName();
                    this.forumId = this.iou.getForum().getId();
                }
                if (this.iou.getPage() != null) {
                    setHasMore(this.iou.getPage().bgX());
                }
                this.ioW.setTitle(this.ioO);
                this.ioW.setForumName(this.ioO);
                TbadkCoreApplication.getInst().setDefaultBubble(this.iou.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.iou.getUserData().getBimg_end_time());
                csW();
                csY();
                ArrayList<com.baidu.adp.widget.ListView.q> threadList = this.iou.getThreadList();
                if (threadList != null) {
                    this.ioW.a(threadList, this.iou);
                    com.baidu.tieba.frs.f.c.A(this.ioW);
                    this.ipq.zQ(getPageNum());
                    this.ipq.i(this.iou);
                    this.ipr.a(this.iou, this.ipp.cyJ());
                    this.ioW.ctS();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void csY() {
        if (this.iou != null) {
            if (this.iou.getIsNewUrl() == 1) {
                this.ioW.cuc().setFromCDN(true);
            } else {
                this.ioW.cuc().setFromCDN(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.ips.pM(false);
        this.ipk = false;
        this.ioW.onPause();
        if (this.ioV != null) {
            this.ioV.onPause(getPageContext());
        }
        this.ioW.pe(true);
        if (this.ipy != null) {
            this.ipy.czG();
        }
        com.baidu.tbadk.BdToken.c.bbM().bbX();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.ipr != null && this.ipr.cAK() != null && (this.ipr.cAK().fragment instanceof BaseFragment)) {
            ((BaseFragment) this.ipr.cAK().fragment).setPrimary(z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.s.ciJ().nX(false);
        oQ(false);
        if (this.iou != null && this.iou.getForum() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            com.baidu.tbadk.distribute.a.buS().b(getPageContext().getPageActivity(), "frs", this.iou.getForum().getId(), 0L);
        }
        if (this.ioV != null) {
            this.ioV.onStop(getPageContext());
        }
        if (boH() != null) {
            boH().getRecycledViewPool().clear();
        }
        this.ipq.bnV();
        com.baidu.tbadk.util.ac.bzD();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            if (this.ipq != null) {
                this.ipq.bO(isPrimary());
            }
            if (this.ioW != null) {
                this.ioW.bO(isPrimary());
                this.ioW.pe(!isPrimary());
            }
        }
    }

    private void csZ() {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.oe(2);
        aVar.iA(false);
        FrsBroadcastCopyGuideDialogView frsBroadcastCopyGuideDialogView = new FrsBroadcastCopyGuideDialogView(getPageContext().getPageActivity());
        frsBroadcastCopyGuideDialogView.setConfirmButtonListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.36
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aVar != null) {
                    aVar.dismiss();
                    FrsFragment.this.cta();
                }
            }
        });
        aVar.ba(frsBroadcastCopyGuideDialogView);
        aVar.b(getPageContext()).bkJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cta() {
        if (KuangFloatingFrsCopyLinkViewController.getInstance().init()) {
            ((BaseFragmentActivity) getPageContext().getOrignalPage()).grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.frs.FrsFragment.37
                @Override // com.baidu.tbadk.core.e
                public void onPermissionResult(boolean z) {
                    if (!z) {
                        new BdTopToast(FrsFragment.this.getContext()).xK(false).TD(FrsFragment.this.getContext().getString(R.string.forum_broadcast_copy_no_permission_hint)).aH(FrsFragment.this.ioW.cew());
                        return;
                    }
                    KuangFloatingFrsCopyLinkViewController.getInstance().showFloatingView(true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                    if (FrsFragment.this.ioX != null) {
                        FrsFragment.this.ioX.setVisibility(8);
                    }
                }
            }, true);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (b.crE().cry()) {
                b.crE().reset();
                return true;
            } else if (com.baidu.tieba.frs.a.crx().cry()) {
                if (this.ioW != null && this.ioW.cuh()) {
                    this.ioW.cui();
                    return true;
                }
                com.baidu.tieba.frs.a.crx().reset();
                return true;
            } else if (this.ioW != null) {
                return this.ioW.ctO();
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
        com.baidu.tbadk.distribute.a.buS().a(advertAppInfo, this.forumId, 0L, "FRS", str, getPn());
    }

    @Override // com.baidu.tieba.recapp.n
    public void ctb() {
        csy().ctb();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.ioV == null) {
            this.ioV = VoiceManager.instance();
        }
        return this.ioV;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdRecyclerView boH() {
        if (this.ioW == null) {
            return null;
        }
        return this.ioW.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void ctc() {
        if (this.ioV != null) {
            this.ioV.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> boI() {
        if (this.eJH == null) {
            this.eJH = UserIconBox.u(getPageContext().getPageActivity(), 8);
        }
        return this.eJH;
    }

    public void ctd() {
        if (getFragmentActivity() != null && getFragmentActivity().getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.t onGetPreLoadListView() {
        return boH().getPreLoadHandle();
    }

    @Override // com.baidu.tieba.frs.at
    public NavigationBar bNC() {
        if (this.ioW == null) {
            return null;
        }
        return this.ioW.bNC();
    }

    public FRSRefreshButton cte() {
        return this.ioY;
    }

    public void c(LinearLayout linearLayout) {
        if (linearLayout != null) {
            this.ioZ = linearLayout;
        }
    }

    public void a(FRSRefreshButton fRSRefreshButton) {
        if (fRSRefreshButton != null) {
            this.ioY = fRSRefreshButton;
            this.ioY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.43
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (FrsFragment.this.ipr != null) {
                        FrsTabViewController.b cAK = FrsFragment.this.ipr.cAK();
                        if (cAK != null && cAK.fragment != null && (cAK.fragment instanceof as)) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                            ((as) cAK.fragment).csk();
                            ((as) cAK.fragment).bKT();
                            return;
                        }
                        FrsFragment.this.csD().startPullRefresh();
                    }
                }
            });
        }
    }

    public void ctf() {
        if (this.ioY != null) {
            this.ioY.hide();
        }
    }

    public void ctg() {
        if (this.ioY != null) {
            this.ioY.show();
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
                if (bdUniqueId == w.isL) {
                    if (FrsFragment.this.ioW != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11752").dK("fid", FrsFragment.this.forumId).dK("obj_locate", "1"));
                        FrsFragment.this.ioW.startPullRefresh();
                    }
                } else if (qVar != null && (qVar instanceof bv)) {
                    bw bwVar = ((bv) qVar).eji;
                    if (bwVar.bjh() == null || bwVar.bjh().getGroup_id() == 0 || com.baidu.tbadk.core.util.bg.checkUpIsLogin(FrsFragment.this.getActivity())) {
                        if (bwVar.biU() != 1 || com.baidu.tbadk.core.util.bg.checkUpIsLogin(FrsFragment.this.getActivity())) {
                            if (bwVar.bit() != null) {
                                if (com.baidu.tbadk.core.util.bg.checkUpIsLogin(FrsFragment.this.getActivity())) {
                                    String postUrl = bwVar.bit().getPostUrl();
                                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.isNetOk()) {
                                        com.baidu.tbadk.browser.a.startInternalWebActivity(FrsFragment.this.getActivity(), postUrl);
                                    }
                                }
                            } else if (bwVar.bjs() != null) {
                                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                    com.baidu.tbadk.core.util.bg.skipToLoginActivity(FrsFragment.this.getPageContext().getPageActivity());
                                    return;
                                }
                                com.baidu.tbadk.core.data.r bjs = bwVar.bjs();
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), bjs.getCartoonId(), bjs.getChapterId(), 2)));
                            } else {
                                com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                                if (readThreadHistory != null && !readThreadHistory.Sl(bwVar.getId())) {
                                    readThreadHistory.Sk(bwVar.getId());
                                }
                                boolean z = false;
                                final String bin = bwVar.bin();
                                if (bin != null && !bin.equals("")) {
                                    z = true;
                                    new Thread(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.a.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            com.baidu.tbadk.core.util.aa aaVar = new com.baidu.tbadk.core.util.aa(bin);
                                            aaVar.bmu().bna().mIsNeedAddCommenParam = false;
                                            aaVar.bmu().bna().mIsUseCurrentBDUSS = false;
                                            aaVar.getNetData();
                                        }
                                    }).start();
                                }
                                String tid = bwVar.getTid();
                                if (tid == null) {
                                    tid = "";
                                }
                                if (bwVar.bic() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                    com.baidu.tbadk.core.util.be.bmY().b(FrsFragment.this.getPageContext(), new String[]{tid, "", null});
                                    return;
                                }
                                if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && tid.length() > 4) {
                                    bwVar.setId(tid.substring(3));
                                }
                                if (bdUniqueId.getId() == bw.erk.getId()) {
                                    com.baidu.tieba.frs.f.j.a(bwVar.bhN());
                                } else if (bdUniqueId.getId() == bw.epL.getId()) {
                                    com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                                    aqVar.dK("obj_type", "2");
                                    aqVar.dK("tid", bwVar.getTid());
                                    TiebaStatic.log(aqVar);
                                }
                                com.baidu.tieba.frs.f.k.a(FrsFragment.this, bwVar, i, z);
                                com.baidu.tieba.frs.f.j.a(FrsFragment.this, FrsFragment.this.iou, bwVar);
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
            hideNetRefreshView(this.ioW.cur().cAA());
            showLoadingView(this.ioW.cew(), true);
            this.ioW.pa(false);
            this.ipp.S(3, true);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData cth() {
        return this.iou;
    }

    public boolean cti() {
        return this.ioW.cti();
    }

    public void aH(Object obj) {
        if (this.ipu != null && this.ipu.iKy != null) {
            this.ipu.iKy.callback(obj);
        }
    }

    public void aI(Object obj) {
        if (this.ipu != null && this.ipu.iKz != null) {
            this.ipu.iKz.callback(obj);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        this.ioW.getListView().stopScroll();
        if (!this.ioW.ctY()) {
            if (!com.baidu.adp.lib.util.l.isNetOk()) {
                this.ioW.bKU();
            } else if (this.ipp.cyE() == 1) {
                bJV();
                bJG();
            } else if (this.ipp.hasMore()) {
                bJG();
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void onFailed(String str) {
        bJV();
        showToast(str);
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void aw(ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        boolean isEmpty = com.baidu.tbadk.core.util.y.isEmpty(arrayList);
        setHasMore(isEmpty ? 0 : 1);
        bJV();
        if (!isEmpty) {
            if (!this.ipp.cyO() && TbadkCoreApplication.getInst().isRecAppExist() && this.ipp.cyE() == 1) {
                this.iou.addRecommendAppToThreadList(this, arrayList);
            }
            if (this.ipp != null) {
                com.baidu.tieba.frs.d.a.a(getUniqueId(), arrayList, this.iou.getForum(), this.ipp.getSortType());
            }
            ArrayList<com.baidu.adp.widget.ListView.q> a2 = this.ipA.a(false, false, arrayList, this.ioS, false);
            if (a2 != null) {
                this.iou.setThreadList(a2);
                this.ioW.a(a2, this.iou);
            }
            if (this.ipp != null) {
                com.baidu.tieba.frs.d.c.a(this.iou, this.ipp.cyJ(), 2, getContext());
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.iou.getForum()));
        }
    }

    private void bJV() {
        if (csE() == 1 || this.ipA.cX(this.iou.getThreadListIds())) {
            if (com.baidu.tbadk.core.util.y.getCount(this.iou.getThreadList()) > 3) {
                this.ioW.SI();
            } else {
                this.ioW.cuf();
            }
        } else if (com.baidu.tbadk.core.util.y.isEmpty(this.iou.getThreadList())) {
            this.ioW.bKU();
        } else {
            this.ioW.SJ();
        }
    }

    @Override // com.baidu.tieba.frs.mc.l
    public void bJG() {
        if (this.ipA != null) {
            this.ipA.a(this.ioO, this.forumId, this.iou);
        }
    }

    public void ctj() {
        if (!com.baidu.tbadk.core.util.ae.requestWriteExternalStorgeAndCameraPermission(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.ao.g(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment, com.baidu.m.a.a.InterfaceC0224a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        com.baidu.tieba.frs.f.k.a(this, i, strArr, iArr);
    }

    public void oT(boolean z) {
        if (this.ipv != null) {
            this.ipv.pn(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.ipw.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a sF(int i) {
        return this.ipw.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        this.ipE.b(bVar);
    }

    public boolean ctk() {
        return this.ioK;
    }

    @Override // com.baidu.tieba.frs.aq
    public void Qi() {
        if (this.ioW != null) {
            showFloatingView();
            this.ioW.getListView().scrollToPosition(0);
            this.ioW.startPullRefresh();
        }
    }

    public ForumWriteData ctl() {
        if (this.iou == null || this.iou.getForum() == null) {
            return null;
        }
        ForumData forum = this.iou.getForum();
        ForumWriteData forumWriteData = new ForumWriteData(forum.getId(), forum.getName(), forum.getPrefixData(), this.iou.getAnti());
        forumWriteData.avatar = forum.getImage_url();
        forumWriteData.forumLevel = forum.getUser_level();
        forumWriteData.specialForumType = forum.special_forum_type;
        forumWriteData.firstDir = forum.getFirst_class();
        forumWriteData.secondDir = forum.getSecond_class();
        UserData userData = this.iou.getUserData();
        forumWriteData.privateThread = userData != null ? userData.getPrivateThread() : 0;
        forumWriteData.frsTabInfo = ctm();
        return forumWriteData;
    }

    private FrsTabInfoData ctm() {
        int i;
        if (this.ipp == null || this.iou == null || this.ipr == null) {
            return null;
        }
        if (this.iou.getEntelechyTabInfo() == null || com.baidu.tbadk.core.util.y.isEmpty(this.iou.getEntelechyTabInfo().tab)) {
            return null;
        }
        int cAO = this.ipr.cAO();
        if (cAO == 502) {
            return null;
        }
        int i2 = -1;
        ArrayList arrayList = new ArrayList();
        Iterator<FrsTabInfo> it = this.iou.getEntelechyTabInfo().tab.iterator();
        while (true) {
            i = i2;
            if (!it.hasNext()) {
                break;
            }
            FrsTabInfo next = it.next();
            if (next != null && next.is_general_tab.intValue() == 1) {
                arrayList.add(new FrsTabItemData(next));
                if (cAO == next.tab_id.intValue()) {
                    i2 = cAO;
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
    public void bok() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void oU(boolean z) {
        this.ipl = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z) {
        this.ioW.yh(8);
        ((FrsActivity) getActivity()).showLoadingView(view, z);
        ((FrsActivity) getActivity()).i(view, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        this.ioW.yh(0);
        ((FrsActivity) getActivity()).hideLoadingView(view);
        ((FrsActivity) getActivity()).i(view, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        super.showNetRefreshView(view, getResources().getString(R.string.refresh_view_title_text), null, getResources().getString(R.string.refresh_view_button_text), z, getNetRefreshListener());
        this.ioW.yh(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshViewNoClick(View view, String str, boolean z) {
        super.showNetRefreshViewNoClick(view, str, z);
        this.ioW.yh(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        super.hideNetRefreshView(view);
        this.ioW.yh(0);
    }

    public void ctn() {
        FrsTabViewController.b cAK;
        if (this.ipr != null && (cAK = this.ipr.cAK()) != null && cAK.fragment != null && (cAK.fragment instanceof as)) {
            ((as) cAK.fragment).csk();
        }
    }

    public void oV(boolean z) {
        this.ioM = z;
    }

    public void b(OvalActionButton ovalActionButton) {
        this.ioX = ovalActionButton;
    }

    public OvalActionButton cto() {
        return this.ioX;
    }

    public boolean ctp() {
        return this.ioM;
    }

    public void onShareSuccess(String str) {
        if (TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.util.at.isEmpty(str)) {
            if (this.ipP == null) {
                this.ipP = new AddExperiencedModel(getTbPageContext());
            }
            this.ipP.gd(this.forumId, str);
        }
    }

    public boolean ctq() {
        if (this.ipl && !this.ipS) {
            return (this.ipp != null && this.ipp.cyF() && (b.crE().cry() || com.baidu.tieba.frs.a.crx().cry())) ? false : true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.f.b
    public boolean videoNeedPreload() {
        if (this.iou != null) {
            return com.baidu.tbadk.util.ai.rA(2) || (com.baidu.tbadk.util.ai.bzJ() && this.iou.isFrsVideoAutoPlay);
        }
        return super.videoNeedPreload();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctr() {
        if (!com.baidu.tbadk.core.util.at.isEmpty(this.forumId)) {
            com.baidu.tbadk.BdToken.c.bbM().r(com.baidu.tbadk.BdToken.b.ebO, com.baidu.adp.lib.f.b.toLong(this.forumId, 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cts() {
        String format;
        String str;
        if (isResumed() && this.ipW != null && this.ipW.size() >= 1 && this.ipV <= this.ipW.size() - 1) {
            final LiveHorseRaceData liveHorseRaceData = this.ipW.get(this.ipV);
            if (System.currentTimeMillis() / 1000 >= liveHorseRaceData.getRob_end_tm().longValue()) {
                this.ipV++;
                cts();
            }
            if (this.ioZ != null) {
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
                        if (FrsFragment.this.iou == null) {
                            str2 = "";
                        } else if (FrsFragment.this.iou.getForum() != null) {
                            str2 = FrsFragment.this.iou.getForum().getName();
                        } else {
                            str2 = "";
                        }
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13744").aj("obj_source", 1).dK("fid", FrsFragment.this.forumId).dK("fname", str2));
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
                this.ipX = ValueAnimator.ofFloat(1.0f, 0.0f);
                this.ipX.setDuration(600L);
                this.ipX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.FrsFragment.51
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        if (valueAnimator.isRunning()) {
                            frsRedpackRunView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                            frsRedpackRunView.setTranslationX(-(TbadkApplication.getInst().getContext().getResources().getDimensionPixelOffset(R.dimen.tbds850) * valueAnimator.getAnimatedFraction()));
                        }
                    }
                });
                this.ipX.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.FrsFragment.52
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        frsRedpackRunView.setAlpha(0.0f);
                        frsRedpackRunView.setTranslationY(TbadkApplication.getInst().getContext().getResources().getDimensionPixelOffset(R.dimen.tbds660));
                        frsRedpackRunView.hide();
                        FrsFragment.this.ioZ.removeView(frsRedpackRunView);
                        if (FrsFragment.this.ipV > FrsFragment.this.ipW.size() - 1) {
                            FrsFragment.this.ioZ.removeAllViews();
                            FrsFragment.this.ioZ.setVisibility(8);
                            FrsFragment.this.ipV = 0;
                            return;
                        }
                        FrsFragment.this.cts();
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        onAnimationEnd(animator);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                this.ipY = new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.53
                    @Override // java.lang.Runnable
                    public void run() {
                        if (FrsFragment.this.ioZ != null && frsRedpackRunView != null) {
                            FrsFragment.this.ipX.start();
                        }
                    }
                };
                com.baidu.adp.lib.f.e.mY().postDelayed(this.ipY, 5000L);
                if (this.ioZ.getChildCount() == 0) {
                    this.ipV++;
                    this.ioZ.addView(frsRedpackRunView);
                    if (this.iou != null) {
                        str = this.iou.getForum() != null ? this.iou.getForum().getName() : "";
                    } else {
                        str = "";
                    }
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13743").aj("obj_source", 1).dK("fid", this.forumId).dK("fname", str));
                }
                if (this.ioZ.getVisibility() == 8 && ((BaseFragment) this.ipr.cAK().fragment).isPrimary() && !this.ioW.cuo() && !this.ipf) {
                    this.ioZ.setVisibility(0);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        FrsTabViewController.b cAK;
        if (csB() == null || (cAK = csB().cAK()) == null || !(cAK.fragment instanceof BaseFragment)) {
            return null;
        }
        if (cAK.fragment instanceof FrsAllThreadFragment) {
            TbPageTag tbPageTag = super.getTbPageTag();
            int i = -1;
            if (this.iou != null) {
                i = this.iou.getSortType();
            }
            tbPageTag.sortType = com.baidu.tieba.frs.f.i.zN(i);
            tbPageTag.locatePage = "a070";
            if (this.ioH.equals(cAK.title)) {
                tbPageTag.locatePage = "a071";
            }
            return tbPageTag;
        } else if (cAK.fragment instanceof FrsFragment) {
            return null;
        } else {
            return ((BaseFragment) cAK.fragment).getTbPageTag();
        }
    }

    public void ctt() {
        if (this.iou != null) {
            com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
            if (this.iou.needLog == 1) {
                bVar.iNi = true;
            } else {
                bVar.iNi = false;
            }
            if (this.iou.getForum() != null) {
                bVar.iNk = this.iou.getForum().getId();
            }
            if (csy() != null) {
                bVar.iNj = csy().cyJ();
            }
            if (com.baidu.tieba.frs.d.d.iyS != null) {
                bVar.iNl = com.baidu.tieba.frs.d.d.iyS.iNl;
                bVar.iNm = com.baidu.tieba.frs.d.d.iyS.iNm;
            }
            this.ipZ = new com.baidu.tieba.frs.live.b(bVar, getTbPageTag(), getUniqueId());
            this.ipZ.zq(this.iqb);
            CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_CARD_CLICK, this.ipZ);
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
            CustomMessageTask customMessageTask2 = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW, this.ipZ);
            customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask2);
            CustomMessageTask customMessageTask3 = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_USER_CLICK, this.ipZ);
            customMessageTask3.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask3);
            CustomMessageTask customMessageTask4 = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_VIDEO_CLICK, this.ipZ);
            customMessageTask4.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask4);
        }
    }
}
