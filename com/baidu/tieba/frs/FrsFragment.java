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
/* loaded from: classes21.dex */
public class FrsFragment extends BaseFragment implements BdListView.e, a.InterfaceC0209a, UserIconBox.b<BdRecyclerView>, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, aq, at, aw, com.baidu.tieba.frs.loadmore.a, com.baidu.tieba.frs.mc.l, com.baidu.tieba.recapp.n {
    public static com.baidu.tieba.tbadkCore.m hZZ;
    private com.baidu.tbadk.util.aa eYx;
    private com.baidu.adp.lib.d.b<TbImageView> exy;
    private com.baidu.tieba.frs.gametab.b gbb;
    private com.baidu.tieba.frs.entelechy.a hZH;
    private com.baidu.tieba.tbadkCore.data.f hZR;
    private VoiceManager hZU;
    private OvalActionButton hZW;
    private FRSRefreshButton hZX;
    private LinearLayout hZY;
    private com.baidu.tbadk.core.dialog.a htc;
    private com.baidu.tieba.frs.vc.j iaA;
    private com.baidu.tieba.frs.mc.a iaB;
    private com.baidu.tieba.frs.live.a iaC;
    private p iaD;
    public com.baidu.tieba.frs.vc.c iaE;
    private com.baidu.tieba.frs.mc.e iaF;
    private View.OnTouchListener iaG;
    private com.baidu.tieba.frs.view.a iaH;
    private com.baidu.tieba.frs.vc.e iaI;
    private boolean iaJ;
    private com.baidu.tieba.NEGFeedBack.a iaK;
    private com.baidu.tieba.ala.a iaL;
    private com.baidu.tieba.frs.brand.buttommenu.a iaM;
    private com.baidu.tieba.frs.sportspage.notification.a iaN;
    private AddExperiencedModel iaO;
    private boolean iaQ;
    private List<LiveHorseRaceData> iaV;
    private ValueAnimator iaW;
    private Runnable iaX;
    private com.baidu.tieba.frs.live.b iaY;
    private com.baidu.tieba.frs.broadcast.a iaZ;
    public long iaa;
    private String ial;
    private com.baidu.card.am ian;
    private FrsModelController iao;
    private com.baidu.tieba.frs.vc.h iap;
    private FrsTabViewController iaq;
    private com.baidu.tieba.frs.mc.h iar;
    private com.baidu.tieba.frs.smartsort.a ias;
    private com.baidu.tieba.frs.mc.b iat;
    private ax iau;
    private com.baidu.tieba.frs.entelechy.b.b iaw;
    private com.baidu.tieba.frs.vc.a iax;
    private com.baidu.tieba.frs.mc.d iay;
    private com.baidu.tieba.frs.mc.c iaz;
    private int iba;
    private int ibk;
    private View mRootView;
    private String mSchemeUrl;
    public static boolean hZM = false;
    public static volatile long iac = 0;
    public static volatile long iad = 0;
    public static volatile int mNetError = 0;
    private String hZG = "";
    public boolean hZI = false;
    private boolean hZJ = false;
    private boolean hZK = false;
    private boolean hZL = true;
    public String hZN = null;
    public String mFrom = null;
    public int mFlag = 0;
    public boolean hZO = false;
    private boolean hZP = false;
    private String mThreadId = null;
    public String forumId = null;
    private int hZv = 0;
    private boolean hZQ = false;
    private boolean hZS = false;
    private boolean hZT = false;
    private q hZV = null;
    public final bw ajX = null;
    private FrsViewData hZt = new FrsViewData();
    public long hCy = -1;
    public long eUN = 0;
    public long eUE = 0;
    public long createTime = 0;
    public long eUF = 0;
    public long eUK = 0;
    public long iab = 0;
    boolean iae = false;
    public boolean iaf = false;
    private boolean iag = false;
    private boolean iah = false;
    public com.baidu.tbadk.n.b iai = null;
    private boolean iaj = true;
    private boolean iak = true;
    private a.C0096a iam = new a.C0096a(2);
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> iav = new SparseArray<>();
    private boolean fJY = true;
    private boolean hasInit = false;
    private boolean iaP = false;
    private boolean iaR = false;
    private Date iaS = null;
    private int djl = 0;
    private int iaT = 0;
    private int iaU = 0;
    public int mHeadLineDefaultNavTabId = -1;
    MessageQueue.IdleHandler ibb = new MessageQueue.IdleHandler() { // from class: com.baidu.tieba.frs.FrsFragment.1
        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            FrsFragment.this.cpt();
            return false;
        }
    };
    private final CustomMessageListener ibc = new CustomMessageListener(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED) { // from class: com.baidu.tieba.frs.FrsFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof bw) {
                    com.baidu.tieba.frs.f.j.a(FrsFragment.this.hZV, FrsFragment.this.hZt, FrsFragment.this.getForumId(), true, (bw) data);
                }
            }
        }
    };
    private CustomMessageListener ibd = new CustomMessageListener(CmdConfigCustom.CMD_CLOSE_GAME_RANK_CARD) { // from class: com.baidu.tieba.frs.FrsFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.hZt != null) {
                FrsFragment.this.hZt.removeGameRankListFromThreadList();
                if (FrsFragment.this.hZV != null) {
                    FrsFragment.this.hZV.aTp();
                }
            }
        }
    };
    private CustomMessageListener agj = new CustomMessageListener(2921401) { // from class: com.baidu.tieba.frs.FrsFragment.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && FrsFragment.this.hZX != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() <= 0 || FrsFragment.this.iaq.cxq() == 0 || FrsFragment.this.iaq.cxn() == null || !(FrsFragment.this.iaq.cxn().fragment instanceof BaseFragment) || !((BaseFragment) FrsFragment.this.iaq.cxn().fragment).isPrimary() || FrsFragment.this.hZV.cqQ() || KuangFloatingFrsCopyLinkViewController.getInstance().isFloatCopyViewShow()) {
                    if (FrsFragment.this.iaq.cxq() != 0) {
                        FrsFragment.this.hZX.hide();
                        return;
                    }
                    return;
                }
                FrsFragment.this.hZX.show();
            }
        }
    };
    private CustomMessageListener ibe = new CustomMessageListener(2921473) { // from class: com.baidu.tieba.frs.FrsFragment.45
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && FrsFragment.this.hZX != null && FrsFragment.this.hZW != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() == 0) {
                    FrsFragment.this.hZX.setVisibility(8);
                    FrsFragment.this.hZW.setVisibility(8);
                    return;
                }
                FrsFragment.this.hZW.setVisibility(0);
            }
        }
    };
    private CustomMessageListener ibf = new CustomMessageListener(2921467) { // from class: com.baidu.tieba.frs.FrsFragment.56
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && FrsFragment.this.hZX != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() <= 0 || FrsFragment.this.iaq.cxn() == null || !(FrsFragment.this.iaq.cxn().fragment instanceof BaseFragment) || !((BaseFragment) FrsFragment.this.iaq.cxn().fragment).isPrimary() || FrsFragment.this.hZV.cqQ()) {
                    FrsFragment.this.hZY.setVisibility(8);
                    FrsFragment.this.iae = true;
                    return;
                }
                FrsFragment.this.hZY.setVisibility(0);
                FrsFragment.this.iae = false;
            }
        }
    };
    private com.baidu.adp.framework.listener.a ibg = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_FRS_LIVE_HORSE_RACE_LIST, 309667) { // from class: com.baidu.tieba.frs.FrsFragment.61
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if ((responsedMessage instanceof GetLiveHorseRaceHttpResponseMessage) || (responsedMessage instanceof GetLiveHorseRaceSocketResponseMessage)) {
                    List<LiveHorseRaceData> arrayList = new ArrayList<>();
                    if (responsedMessage instanceof GetLiveHorseRaceHttpResponseMessage) {
                        arrayList = ((GetLiveHorseRaceHttpResponseMessage) responsedMessage).getData().crr();
                    }
                    if (responsedMessage instanceof GetLiveHorseRaceSocketResponseMessage) {
                        arrayList = ((GetLiveHorseRaceSocketResponseMessage) responsedMessage).getData().crr();
                    }
                    if (FrsFragment.this.iaV != null) {
                        if (FrsFragment.this.hZY.getVisibility() != 8) {
                            if (FrsFragment.this.iaU >= FrsFragment.this.iaV.size()) {
                                FrsFragment.this.iaV.addAll(arrayList);
                                return;
                            }
                            FrsFragment.this.iaV = FrsFragment.this.iaV.subList(0, FrsFragment.this.iaU);
                            FrsFragment.this.iaV.addAll(arrayList);
                            return;
                        }
                        FrsFragment.this.iaV = new ArrayList();
                        FrsFragment.this.iaV.addAll(arrayList);
                        FrsFragment.this.iaU = 0;
                        FrsFragment.this.cpU();
                        return;
                    }
                    FrsFragment.this.iaV = new ArrayList();
                    FrsFragment.this.iaU = 0;
                    FrsFragment.this.iaV.addAll(arrayList);
                    FrsFragment.this.cpU();
                }
            }
        }
    };
    private CustomMessageListener ibh = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.FrsFragment.62
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 1) {
                    FrsFragment.this.cpx();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                }
            }
        }
    };
    private final av ibi = new av() { // from class: com.baidu.tieba.frs.FrsFragment.63
        @Override // com.baidu.tieba.frs.av
        public void a(int i, int i2, bd bdVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
            FrsFragment.this.cpi();
            if (FrsFragment.this.iaw != null) {
                FrsFragment.this.iap.po(FrsFragment.this.iaw.yh(i));
            }
            com.baidu.tieba.tbadkCore.f fVar = new com.baidu.tieba.tbadkCore.f();
            if (bdVar != null) {
                fVar.isSuccess = bdVar.errCode == 0;
                fVar.errorCode = bdVar.errCode;
                fVar.errorMsg = bdVar.errMsg;
                if (fVar.isSuccess) {
                    if (com.baidu.tbadk.core.util.y.isEmpty(arrayList)) {
                        FrsFragment.this.hZV.bIk();
                    } else if (bdVar.hasMore) {
                        if (com.baidu.tbadk.core.util.y.getCount(FrsFragment.this.hZt.getThreadList()) > 3) {
                            FrsFragment.this.hZV.bIi();
                        } else {
                            FrsFragment.this.hZV.cqH();
                        }
                    } else if (bdVar.ieY) {
                        FrsFragment.this.hZV.bIj();
                    } else {
                        FrsFragment.this.hZV.bIk();
                    }
                }
            } else {
                bdVar = new bd();
                bdVar.pn = 1;
                bdVar.hasMore = false;
                bdVar.ieY = false;
            }
            if (i == 1) {
                FrsFragment.this.iaj = true;
                FrsFragment.this.ibz.a(FrsFragment.this.iao.getType(), false, fVar);
            } else {
                FrsFragment.this.a(fVar);
                if (FrsFragment.this.iao.cuI() != null) {
                    FrsFragment.this.hZt = FrsFragment.this.iao.cuI();
                }
                FrsFragment.this.cpz();
            }
            if (FrsFragment.this.ibH != null) {
                FrsFragment.this.ibH.a(i, i2, bdVar, arrayList);
            }
        }
    };
    private FrsTabViewController.a ibj = new FrsTabViewController.a() { // from class: com.baidu.tieba.frs.FrsFragment.2
        @Override // com.baidu.tieba.frs.vc.FrsTabViewController.a
        public void ch(int i, int i2) {
            boolean z = false;
            if (i != 1) {
                com.baidu.tieba.card.s.cfn().ns(false);
                FrsFragment.this.ol(false);
            }
            if (i == 502) {
                FrsFragment.this.hZW.setIconFade(R.drawable.btn_frs_professional_edit_n);
            } else {
                FrsFragment.this.hZW.setIconFade(0);
            }
            FrsFragment.this.ibk = i;
            FrsFragment.this.iba = i2;
            if (FrsFragment.this.iaY != null) {
                FrsFragment.this.iaY.yK(FrsFragment.this.iba);
            }
            TbSingleton.getInstance().setFrsCurTabType(FrsFragment.this.iba);
            FrsFragment.this.cpE();
            com.baidu.tieba.frs.d.d.ijV.iys = i;
            com.baidu.tieba.frs.d.d.ijV.iyv = i2;
            com.baidu.tieba.frs.d.d.ijV.iyt = -1;
            b.cog().T(i == 1 && FrsFragment.this.iaP, true);
            com.baidu.tieba.frs.a cnZ = com.baidu.tieba.frs.a.cnZ();
            if (i == 1 && FrsFragment.this.iaP) {
                z = true;
            }
            cnZ.T(z, true);
        }
    };
    private CustomMessageListener ibl = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIVE_COUNT) { // from class: com.baidu.tieba.frs.FrsFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                FrsFragment.this.iaq.zu(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    };
    private CustomMessageListener ibm = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_LIVE_START) { // from class: com.baidu.tieba.frs.FrsFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && ((Integer) customResponsedMessage.getData()).intValue() == 51 && FrsFragment.this.hZt != null) {
                com.baidu.tieba.frs.f.l.a(FrsFragment.this.hZt, FrsFragment.this.getPageContext());
            }
        }
    };
    private final CustomMessageListener ibn = new CustomMessageListener(CmdConfigCustom.CMD_FRS_SELECT_ALA_LIVE_TAB) { // from class: com.baidu.tieba.frs.FrsFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                FrsFragment.this.iaq.sn(49);
            }
        }
    };
    private final CustomMessageListener ibo = new CustomMessageListener(2921470) { // from class: com.baidu.tieba.frs.FrsFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                FrsFragment.this.iaq.sn(1);
                FrsFragment.this.cpx();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
            }
        }
    };
    private final CustomMessageListener ibp = new CustomMessageListener(CmdConfigCustom.CMD_FRS_EXPERIENCE_TIP) { // from class: com.baidu.tieba.frs.FrsFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.v) && FrsFragment.this.hZt != null) {
                FrsFragment.this.hZt.updateLikeData((com.baidu.tieba.tbadkCore.v) customResponsedMessage.getData());
                FrsFragment.this.iap.i(FrsFragment.this.hZt);
                FrsFragment.this.iaq.a(FrsFragment.this.hZt, FrsFragment.this.iao.cvm());
            }
        }
    };
    private final AntiHelper.a ibq = new AntiHelper.a() { // from class: com.baidu.tieba.frs.FrsFragment.8
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ai("obj_locate", ax.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ai("obj_locate", ax.a.LOCATE_LIKE_PERSON));
        }
    };
    private CustomMessageListener ibr = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.FrsFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(FrsFragment.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().eEj != null) {
                        if (AntiHelper.a(FrsFragment.this.getActivity(), updateAttentionMessage.getData().eEj, FrsFragment.this.ibq) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ai("obj_locate", ax.a.LOCATE_LIKE_PERSON));
                        }
                    } else if (updateAttentionMessage.getData().isSucc && updateAttentionMessage.getData().isAttention) {
                        com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getPageContext().getPageActivity(), R.string.attention_success);
                    }
                }
            }
        }
    };
    private CustomMessageListener ibs = new CustomMessageListener(CmdConfigCustom.CMD_GET_ENSURE_CAST_ID) { // from class: com.baidu.tieba.frs.FrsFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsFragment.this.refresh();
        }
    };
    private CustomMessageListener ibt = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.frs.FrsFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && !((PostWriteCallBackData) customResponsedMessage.getData()).isDyamicCallback()) {
                FrsFragment.this.hZV.c((PostWriteCallBackData) customResponsedMessage.getData());
                if (((PostWriteCallBackData) customResponsedMessage.getData()).getGeneralTabId() >= 0) {
                    FrsFragment.this.iaB.yM(((PostWriteCallBackData) customResponsedMessage.getData()).getGeneralTabId());
                }
            }
        }
    };
    private CustomMessageListener ibu = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_REMIND) { // from class: com.baidu.tieba.frs.FrsFragment.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626) {
                NewsRemindMessage newsRemindMessage = (NewsRemindMessage) customResponsedMessage;
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (FrsFragment.this.hZV != null) {
                    FrsFragment.this.hZV.N(notificationCount, z);
                }
            }
        }
    };
    private HttpMessageListener ibv = new HttpMessageListener(CmdConfigHttp.CMD_FRS_MOVE_AREA) { // from class: com.baidu.tieba.frs.FrsFragment.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int i;
            int i2 = 0;
            if (httpResponsedMessage != null && FrsFragment.this.getContext() != null && FrsFragment.this.hZV != null) {
                if (httpResponsedMessage.getError() == 0) {
                    new BdTopToast(FrsFragment.this.getContext()).xd(true).SP(FrsFragment.this.getContext().getString(R.string.frs_move_area_move_suc)).aF(FrsFragment.this.hZV.caY());
                    if (com.baidu.tieba.frs.a.cnZ().xn(com.baidu.tieba.frs.a.cnZ().cob())) {
                        FrsCommonTabFragment frsCommonTabFragment = null;
                        if (FrsFragment.this.iaq != null && FrsFragment.this.iaq.cxn() != null && (FrsFragment.this.iaq.cxn().fragment instanceof FrsCommonTabFragment)) {
                            frsCommonTabFragment = (FrsCommonTabFragment) FrsFragment.this.iaq.cxn().fragment;
                        }
                        if (frsCommonTabFragment != null) {
                            frsCommonTabFragment.csm();
                        }
                        FrsFragment.this.coe();
                        com.baidu.tieba.frs.a.cnZ().coe();
                        Iterator<com.baidu.adp.widget.ListView.q> it = FrsFragment.this.hZt.getThreadList().iterator();
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
                            FrsFragment.this.bGU();
                        }
                    }
                    com.baidu.tieba.frs.a.cnZ().reset();
                    return;
                }
                new BdTopToast(FrsFragment.this.getContext()).xd(false).SP(httpResponsedMessage.getErrorString()).aF(FrsFragment.this.hZV.caY());
            }
        }
    };
    private final CustomMessageListener ibw = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.frs.FrsFragment.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.isResumed()) {
                FrsFragment.this.cpT();
            }
        }
    };
    private CustomMessageListener ibx = new CustomMessageListener(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER) { // from class: com.baidu.tieba.frs.FrsFragment.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (FrsFragment.this.hZV != null) {
                    FrsFragment.this.hZV.setExpanded(booleanValue);
                }
            }
        }
    };
    private final CustomMessageListener iby = new CustomMessageListener(2921463) { // from class: com.baidu.tieba.frs.FrsFragment.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TbadkApplication.getInst().getCurrentActivity() != null && !com.baidu.tbadk.core.util.at.isEmpty(str) && str.equals(FrsFragment.this.forumId)) {
                    com.baidu.tieba.frs.f.g.b(((TbPageContextSupport) TbadkApplication.getInst().getCurrentActivity()).getPageContext(), FrsFragment.this.hZt);
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.r ibz = new com.baidu.tieba.tbadkCore.r() { // from class: com.baidu.tieba.frs.FrsFragment.18
        private long startTime = 0;

        @Override // com.baidu.tieba.tbadkCore.r
        public void xu(int i) {
            this.startTime = System.nanoTime();
            if (FrsFragment.this.hZV != null) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsFragment.this.hZV.cqr();
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
            if (FrsFragment.this.fJY) {
                FrsFragment.this.fJY = false;
                com.baidu.tieba.frs.f.j.a(FrsFragment.this.hZV, FrsFragment.this.hZt, FrsFragment.this.getForumId(), false, null);
            }
            FrsFragment.this.cpi();
            FrsFragment.this.iag = true;
            if (fVar != null && fVar.isSuccess) {
                FrsFragment.this.hZV.cqE().oV(com.baidu.tbadk.core.util.au.bkm().bkn());
                FrsFragment.iac = 0L;
                FrsFragment.iad = 0L;
                FrsFragment.mNetError = 0;
            } else {
                FrsFragment.mNetError = 1;
            }
            if (!FrsFragment.this.iao.cvr() && (i == 3 || i == 6)) {
                FrsFragment.this.iaz.resetData();
            }
            FrsFragment.this.iaa = System.currentTimeMillis();
            if (FrsFragment.this.iao.cuI() != null) {
                FrsFragment.this.hZt = FrsFragment.this.iao.cuI();
            }
            FrsFragment.this.xq(1);
            FrsFragment.this.cpq();
            if (i == 7) {
                FrsFragment.this.xr(FrsFragment.this.hZt.getFrsDefaultTabId());
                return;
            }
            if (FrsFragment.this.hZt.getPage() != null) {
                FrsFragment.this.setHasMore(FrsFragment.this.hZt.getPage().beo());
            }
            if (i == 4) {
                if (!FrsFragment.this.iao.cvr() && TbadkCoreApplication.getInst().isRecAppExist() && FrsFragment.this.iao.cvh() == 1) {
                    FrsFragment.this.hZt.addRecommendAppToThreadList(FrsFragment.this);
                }
                ArrayList<com.baidu.adp.widget.ListView.q> a2 = FrsFragment.this.iaz.a(false, false, FrsFragment.this.hZt.getThreadList(), FrsFragment.this.hZR, false);
                if (a2 != null) {
                    FrsFragment.this.hZt.setThreadList(a2);
                    FrsFragment.this.hZt.checkLiveStageInThreadList();
                }
                if (FrsFragment.this.iao != null) {
                    com.baidu.tieba.frs.d.c.a(FrsFragment.this.hZt, FrsFragment.this.iao.cvm(), 2, FrsFragment.this.getContext());
                }
                com.baidu.tieba.frs.f.a.a(FrsFragment.this, FrsFragment.this.hZt.getForum(), FrsFragment.this.hZt.getThreadList(), false, FrsFragment.this.getPn());
                FrsFragment.this.hZV.a(a2, FrsFragment.this.hZt);
                FrsFragment.this.cpj();
                return;
            }
            FrsFragment.this.cpj();
            switch (i) {
                case 1:
                    FrsFragment.this.hZV.cqr();
                    break;
                case 2:
                    FrsFragment.this.hZV.cqr();
                    break;
                case 3:
                case 6:
                    if (FrsFragment.this.hZt != null) {
                        FrsFragment.this.hZt.clearPostThreadCount();
                    }
                    if (FrsFragment.this.iaE != null) {
                        FrsFragment.this.iaE.refresh();
                        break;
                    }
                    break;
            }
            FrsFragment.this.cpr();
            if (fVar == null || fVar.errorCode == 0) {
                if (FrsFragment.this.hZt != null) {
                    FrsFragment.this.a(FrsFragment.this.hZt);
                    FrsFragment.this.V(false, i == 5);
                    if (FrsFragment.this.iao != null) {
                        if (FrsFragment.this.hZt.getActivityHeadData() != null && FrsFragment.this.hZt.getActivityHeadData().bdC() != null && FrsFragment.this.hZt.getActivityHeadData().bdC().size() > 0) {
                            com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), 1, FrsFragment.this.hZt.getForum(), FrsFragment.this.iao.getSortType(), 1);
                        }
                        if (FrsFragment.this.hZt.getThreadList() != null && FrsFragment.this.hZt.getThreadList().size() > 0) {
                            Iterator<com.baidu.adp.widget.ListView.q> it = FrsFragment.this.hZt.getThreadList().iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    com.baidu.adp.widget.ListView.q next = it.next();
                                    if ((next instanceof bw) && ((bw) next).getType() == bw.eff) {
                                        com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), 1, FrsFragment.this.hZt.getForum(), FrsFragment.this.iao.getSortType(), 2);
                                    }
                                }
                            }
                        }
                        com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), FrsFragment.this.hZt.getThreadList(), FrsFragment.this.hZt.getForum(), FrsFragment.this.iao.getSortType());
                    }
                    FrsFragment.this.hZV.xH(i);
                    FrsFragment.iac = (System.nanoTime() - this.startTime) / TimeUtils.NANOS_PER_MS;
                    if (fVar != null) {
                        FrsFragment.iad = fVar.mmp;
                    }
                } else {
                    return;
                }
            } else if (FrsFragment.this.hZt == null || com.baidu.tbadk.core.util.y.isEmpty(FrsFragment.this.hZt.getThreadList())) {
                FrsFragment.this.a(fVar);
            } else if (fVar.hJU) {
                FrsFragment.this.showToast(FrsFragment.this.getPageContext().getResources().getString(R.string.net_error_text, fVar.errorMsg, Integer.valueOf(fVar.errorCode)));
            }
            FrsFragment.this.cpn();
            FrsFragment.this.cpo();
            if (FrsFragment.this.hZt.getAccessFlag() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11384"));
            }
            if (FrsFragment.this.hZS && FrsFragment.this.iaq.sn(49)) {
                FrsFragment.this.hZS = false;
            }
            FrsFragment.this.b(FrsFragment.this.hZt.getForum());
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.r
        public void c(com.baidu.tieba.tbadkCore.m mVar) {
            if ((mVar != null && ("normal_page".equals(FrsFragment.this.iao.getPageType()) || "frs_page".equals(FrsFragment.this.iao.getPageType()) || "book_page".equals(FrsFragment.this.iao.getPageType()))) || "brand_page".equals(FrsFragment.this.iao.getPageType())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE, mVar));
                FrsFragment.this.b(mVar);
                FrsFragment.hZZ = mVar;
            }
        }

        @Override // com.baidu.tieba.tbadkCore.r
        public void cpt() {
            FrsFragment.this.cpt();
        }
    };
    private final CustomMessageListener ibA = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.frs.FrsFragment.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.m) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                FrsFragment.this.hZt.updateCurrentUserPendant((com.baidu.tbadk.data.m) customResponsedMessage.getData());
                FrsFragment.this.hZV.cqE().notifyDataSetChanged();
            }
        }
    };
    private final CustomMessageListener mMemListener = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_MEM) { // from class: com.baidu.tieba.frs.FrsFragment.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && FrsFragment.this.hZt != null && (userData = FrsFragment.this.hZt.getUserData()) != null) {
                userData.setIsMem(num.intValue());
                if (num.intValue() != 0) {
                    FrsFragment.this.iap.m(num);
                }
            }
        }
    };
    private final f.a ibB = new AnonymousClass30();
    private final com.baidu.tieba.frs.mc.k ibC = new com.baidu.tieba.frs.mc.k() { // from class: com.baidu.tieba.frs.FrsFragment.31
        @Override // com.baidu.tieba.frs.mc.k
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, boolean z3) {
            if (FrsFragment.this.ias != null && FrsFragment.this.iao != null && FrsFragment.this.iao.cvr() && z && !z2 && !z3) {
                FrsFragment.this.ias.yR(i2);
            }
        }
    };
    public final View.OnTouchListener eYy = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.FrsFragment.32
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (FrsFragment.this.iaG != null) {
                FrsFragment.this.iaG.onTouch(view, motionEvent);
            }
            if (FrsFragment.this.iau != null && FrsFragment.this.iau.crs() != null) {
                FrsFragment.this.iau.crs().onTouchEvent(motionEvent);
            }
            if (FrsFragment.this.gbb != null) {
                FrsFragment.this.gbb.b(view, motionEvent);
            }
            if (FrsFragment.this.iap != null) {
                FrsFragment.this.iap.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private final CustomMessageListener ibD = new CustomMessageListener(CmdConfigCustom.CMD_GOTOLIVE_HOST_UPGRADE) { // from class: com.baidu.tieba.frs.FrsFragment.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.bjf().getInt(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.PHOTOLIVE_HOSTLEVEL, -1) != -1 && FrsFragment.this.hZt.getForum() != null) {
                FrsFragment.this.hZt.getForum().setCanAddPhotoLivePost(true);
            }
        }
    };
    public final View.OnClickListener ibE = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.39
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsFragment.this.hZV != null && view == FrsFragment.this.hZV.cqp() && FrsFragment.this.getActivity() != null) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, FrsFragment.this.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            if (view.getId() == R.id.game_activity_egg_layout && com.baidu.adp.lib.util.l.isNetOk()) {
                TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_CLICK);
                if (FrsFragment.this.hZV == null || !FrsFragment.this.hZV.cqB()) {
                    String activityUrl = FrsFragment.this.hZt.getForum().getYuleData().bhS().getActivityUrl();
                    if (!StringUtils.isNull(activityUrl)) {
                        com.baidu.tbadk.browser.a.startInternalWebActivity(FrsFragment.this.getPageContext().getPageActivity(), activityUrl);
                    }
                } else {
                    FrsFragment.this.hZV.cqC();
                }
            }
            if (FrsFragment.this.hZV != null && view == FrsFragment.this.hZV.cqI() && FrsFragment.this.iao != null && FrsFragment.this.iao.hasMore()) {
                FrsFragment.this.hZV.bIi();
                FrsFragment.this.bGU();
            }
            if (view != null && FrsFragment.this.hZV != null && view == FrsFragment.this.hZV.cqy()) {
                if (com.baidu.tbadk.core.util.bg.checkUpIsLogin(FrsFragment.this.getContext())) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).ai("obj_locate", 2));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MessageCenterActivityConfig(FrsFragment.this.getContext())));
                } else {
                    return;
                }
            }
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (FrsFragment.this.hZt != null && FrsFragment.this.hZt.getForum() != null) {
                    if (FrsFragment.this.hZV != null && view == FrsFragment.this.hZV.cqw()) {
                        if (FrsFragment.this.hZt != null && FrsFragment.this.hZt.getForum() != null && !StringUtils.isNull(FrsFragment.this.hZt.getForum().getId()) && !StringUtils.isNull(FrsFragment.this.hZt.getForum().getName())) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq(TbadkCoreStatisticKey.KEY_SHARE_CLICK).dF("fid", FrsFragment.this.hZt.getForum().getId()).ai("obj_locate", 11));
                            com.baidu.tieba.frs.f.g.a(FrsFragment.this.getPageContext(), FrsFragment.this.hZt, FrsFragment.this.hZt.getForum().getId());
                        } else {
                            return;
                        }
                    }
                    if (FrsFragment.this.hZV != null && view == FrsFragment.this.hZV.cqv()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12402").dF("fid", FrsFragment.this.hZt.getForum().getId()).dF("uid", TbadkCoreApplication.getCurrentAccount()).dF("fname", FrsFragment.this.hZt.getForum().getName()));
                        if (!StringUtils.isNull(FrsFragment.this.hZt.getForum().getName())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PostSearchActivityConfig(FrsFragment.this.getContext(), FrsFragment.this.hZt.getForum().getName(), FrsFragment.this.hZt.getForum().getId())));
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
        private int icc = 0;
        private int fFV = 0;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsFragment.this.iaT += i2;
            if (FrsFragment.this.iaT >= FrsFragment.this.djl * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
            if (FrsFragment.this.iax != null) {
                FrsFragment.this.iax.cwj();
            }
            this.icc = 0;
            this.fFV = 0;
            if (recyclerView != null && (recyclerView instanceof BdRecyclerView)) {
                this.icc = ((BdRecyclerView) recyclerView).getFirstVisiblePosition();
                this.fFV = ((BdRecyclerView) recyclerView).getLastVisiblePosition();
            }
            if (FrsFragment.this.iaI != null) {
                FrsFragment.this.iaI.a(recyclerView, this.icc, this.fFV);
            }
            if (FrsFragment.this.hZt != null && FrsFragment.this.hZV != null && FrsFragment.this.hZV.cqE() != null) {
                FrsFragment.this.hZV.ck(this.icc, this.fFV);
                if (FrsFragment.this.ian != null && FrsFragment.this.ian.tW() != null) {
                    FrsFragment.this.ian.tW().b(FrsFragment.this.iam);
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (FrsFragment.this.iap != null) {
                FrsFragment.this.iap.setScrollState(i);
            }
            if ((i == 2 || i == 1) && !FrsFragment.this.iah) {
                FrsFragment.this.iah = true;
                FrsFragment.this.hZV.cqG();
            }
            if (FrsFragment.this.iai == null && !FrsFragment.this.cpM()) {
                FrsFragment.this.iai = new com.baidu.tbadk.n.b();
                FrsFragment.this.iai.setSubType(1000);
            }
            if (i == 0) {
                if (FrsFragment.this.iai != null) {
                    FrsFragment.this.iai.bvj();
                }
                com.baidu.tieba.card.s.cfn().ns(true);
                FrsFragment.this.ol(true);
                FrsFragment.this.hZV.cj(this.icc, this.fFV);
            } else if (FrsFragment.this.iai != null) {
                FrsFragment.this.iai.bvi();
            }
            if (FrsFragment.this.iaI != null) {
                FrsFragment.this.iaI.onScrollStateChanged(recyclerView, i);
            }
            if (i == 0) {
                com.baidu.tieba.frs.f.j.a(FrsFragment.this.hZV, FrsFragment.this.hZt, FrsFragment.this.getForumId(), false, null);
            }
            if (FrsFragment.this.iaq != null && i == 1) {
                FrsFragment.this.iaq.cxp();
            }
            if (FrsFragment.this.ian == null) {
                if (FrsFragment.this.hZV.cqi() != null && !FrsFragment.this.hZV.cpK() && FrsFragment.this.hZV.cqi().dnC() != null && (FrsFragment.this.hZV.cqi().dnC().getTag() instanceof com.baidu.card.am)) {
                    FrsFragment.this.ian = (com.baidu.card.am) FrsFragment.this.hZV.cqi().dnC().getTag();
                }
            } else if (i == 0 && FrsFragment.this.hZV.cqi() != null && !FrsFragment.this.hZV.cpK() && FrsFragment.this.hZV.cqi().dnC() != null && (FrsFragment.this.hZV.cqi().dnC().getTag() instanceof com.baidu.card.am)) {
                FrsFragment.this.ian = (com.baidu.card.am) FrsFragment.this.hZV.cqi().dnC().getTag();
            }
            if (i == 1) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921418));
            }
        }
    };
    private final f ibF = new f() { // from class: com.baidu.tieba.frs.FrsFragment.41
        @Override // com.baidu.tieba.frs.f
        public void a(int i, int i2, View view, View view2, bw bwVar) {
            if (i != FrsFragment.this.hZV.cqE().csY()) {
                if (i != FrsFragment.this.hZV.cqE().csZ()) {
                    if (i == FrsFragment.this.hZV.cqE().csW() && FrsFragment.this.hZt != null && FrsFragment.this.hZt.getUserData() != null && FrsFragment.this.hZt.getUserData().isBawu()) {
                        String bawuCenterUrl = FrsFragment.this.hZt.getBawuCenterUrl();
                        if (!com.baidu.tbadk.core.util.at.isEmpty(bawuCenterUrl) && FrsFragment.this.hZt.getForum() != null) {
                            com.baidu.tbadk.browser.a.startWebActivity(FrsFragment.this.getPageContext().getPageActivity(), bawuCenterUrl);
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10502").dF("fid", FrsFragment.this.hZt.getForum().getId()).dF("uid", FrsFragment.this.hZt.getUserData().getUserId()));
                        }
                    }
                } else if (com.baidu.tbadk.core.util.bg.checkUpIsLogin(FrsFragment.this.getPageContext().getPageActivity())) {
                    TiebaStatic.log(CommonStatisticKey.MY_SERVICE_CK);
                    if (FrsFragment.this.hZt != null && FrsFragment.this.hZt.getForum() != null) {
                        ForumData forum = FrsFragment.this.hZt.getForum();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(forum.getId(), 0L), forum.getName(), forum.getImage_url(), 0)));
                    }
                }
            } else if (com.baidu.tbadk.core.util.bg.checkUpIsLogin(FrsFragment.this.getActivity())) {
                TiebaStatic.log("forum_fortune_click");
                com.baidu.tieba.frs.f.k.c(FrsFragment.this.getPageContext(), FrsFragment.this.hZt);
            }
        }
    };
    private final NoNetworkView.a hXf = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.FrsFragment.42
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (FrsFragment.this.iao.cvh() == 1 && z && !FrsFragment.this.hZV.cpK()) {
                if (FrsFragment.this.hZt == null || com.baidu.tbadk.core.util.y.isEmpty(FrsFragment.this.hZt.getThreadList())) {
                    FrsFragment.this.hideNetRefreshView(FrsFragment.this.hZV.cqT().cxd());
                    FrsFragment.this.showLoadingView(FrsFragment.this.hZV.caY(), true);
                    FrsFragment.this.hZV.ov(false);
                    FrsFragment.this.refresh();
                    return;
                }
                FrsFragment.this.hZV.cqr();
            }
        }
    };
    private final CustomMessageListener eEB = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.FrsFragment.43
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                com.baidu.tieba.frs.f.c.a(customResponsedMessage, FrsFragment.this.hZV, FrsFragment.this.hZt);
            }
        }
    };
    private com.baidu.adp.widget.ListView.ab ibG = new a();
    private av ibH = new av() { // from class: com.baidu.tieba.frs.FrsFragment.46
        @Override // com.baidu.tieba.frs.av
        public void a(int i, int i2, bd bdVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
            com.baidu.adp.lib.f.e.mX().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.46.1
                @Override // java.lang.Runnable
                public void run() {
                    if (FrsFragment.this.hZV != null && FrsFragment.this.hZV.cqL()) {
                        FrsFragment.this.bGU();
                    }
                }
            });
        }
    };
    private CustomMessageListener ibI = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.frs.FrsFragment.47
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    FrsFragment.this.iaJ = true;
                }
            }
        }
    };
    private CustomMessageListener ibJ = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.frs.FrsFragment.48
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                    if (FrsFragment.this.ian == null && FrsFragment.this.hZV.cqi() != null && !FrsFragment.this.hZV.cpK() && FrsFragment.this.hZV.cqi().dnC() != null && (FrsFragment.this.hZV.cqi().dnC().getTag() instanceof com.baidu.card.am)) {
                        FrsFragment.this.ian = (com.baidu.card.am) FrsFragment.this.hZV.cqi().dnC().getTag();
                    }
                    if (FrsFragment.this.ian != null && FrsFragment.this.ian.tW() != null) {
                        FrsFragment.this.ian.tW().b(new a.C0096a(3));
                    }
                }
            }
        }
    };
    private CustomMessageListener ibK = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.FrsFragment.49
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.hZV != null) {
                FrsFragment.this.hZV.EW();
            }
        }
    };
    private CustomMessageListener ibL = new CustomMessageListener(2921437) { // from class: com.baidu.tieba.frs.FrsFragment.50
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && FrsFragment.this.isResumed()) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (FrsFragment.this.hZX != null) {
                    if (booleanValue) {
                        if (FrsFragment.this.iaq.cxq() != 0 && !FrsFragment.this.hZV.cqQ() && !KuangFloatingFrsCopyLinkViewController.getInstance().isFloatCopyViewShow()) {
                            FrsFragment.this.hZX.show();
                            return;
                        }
                        return;
                    }
                    FrsFragment.this.hZX.hide();
                }
            }
        }
    };
    private CustomMessageListener ibM = new CustomMessageListener(2921462) { // from class: com.baidu.tieba.frs.FrsFragment.55
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && FrsFragment.this.hZt.getToLoadHorseData().intValue() == 1 && FrsFragment.this.mIsLogin) {
                LiveHorseRaceRequestMessage liveHorseRaceRequestMessage = new LiveHorseRaceRequestMessage();
                liveHorseRaceRequestMessage.setForum_id(Long.valueOf(FrsFragment.this.forumId));
                FrsFragment.this.sendMessage(liveHorseRaceRequestMessage);
            }
        }
    };
    private CustomMessageListener ibN = new CustomMessageListener(2001223) { // from class: com.baidu.tieba.frs.FrsFragment.57
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Date)) {
                FrsFragment.this.iaS = (Date) customResponsedMessage.getData();
            }
        }
    };
    private CustomMessageListener ibO = new CustomMessageListener(2921469) { // from class: com.baidu.tieba.frs.FrsFragment.58
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.x) && FrsFragment.this.isResumed()) {
                com.baidu.tbadk.core.data.x xVar = (com.baidu.tbadk.core.data.x) customResponsedMessage.getData();
                if (FrsFragment.this.iaZ == null) {
                    FrsFragment.this.iaZ = new com.baidu.tieba.frs.broadcast.a(FrsFragment.this.getPageContext());
                }
                if (FrsFragment.this.hZt != null && FrsFragment.this.hZt.getForum() != null && !TextUtils.isEmpty(FrsFragment.this.hZt.getForum().getId())) {
                    FrsFragment.this.iaZ.e(xVar.type, FrsFragment.this.hZt.getForum().getId(), FrsFragment.this.hZt.getForum().getName(), xVar.tid);
                }
            }
        }
    };
    private CustomMessageListener ibP = new CustomMessageListener(2921475) { // from class: com.baidu.tieba.frs.FrsFragment.59
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bw bwVar = (bw) customResponsedMessage.getData();
            if (bwVar != null && FrsFragment.this.isResumed()) {
                FrsFragment.this.ial = bwVar.getTid() + "";
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE_NUMBER);
                httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
                httpMessage.addParam("forum_id", bwVar.getFid());
                MessageManager.getInstance().sendMessage(httpMessage);
            }
        }
    };
    private HttpMessageListener ibQ = new HttpMessageListener(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE_NUMBER) { // from class: com.baidu.tieba.frs.FrsFragment.60
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if ((httpResponsedMessage instanceof ForumManagerRightsResMsg) && FrsFragment.this.isResumed()) {
                ForumManagerRightsResMsg forumManagerRightsResMsg = (ForumManagerRightsResMsg) httpResponsedMessage;
                if (forumManagerRightsResMsg.broadcastTotalCount - forumManagerRightsResMsg.broadcastUsedCount <= 0) {
                    new ScreenTopToast(FrsFragment.this.getContext()).ST(FrsFragment.this.getString(R.string.frs_forum_bawu_send_broadcast_none_tip)).SV(FrsFragment.this.getString(R.string.frs_recommend_fail_tip_btn)).ak(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.60.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("_forumId", FrsFragment.this.hZt.getForum().getId());
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new com.baidu.tieba.tbadkCore.data.m(FrsFragment.this.getContext(), "ForumGradePage", hashMap)));
                        }
                    }).aF((ViewGroup) FrsFragment.this.mRootView.findViewById(R.id.frs));
                    return;
                }
                com.baidu.tbadk.core.util.o oVar = new com.baidu.tbadk.core.util.o(TbadkCoreApplication.getInst());
                oVar.ab(FrsFragment.this.hZt.getForum().getId(), FrsFragment.this.hZt.getForum().getName(), "6");
                oVar.Ar(FrsFragment.this.ial);
                oVar.start();
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.frs.loadmore.a
    public /* bridge */ /* synthetic */ com.baidu.adp.base.e getPageContext() {
        return super.getPageContext();
    }

    public com.baidu.tieba.frs.entelechy.b.b coW() {
        return this.iaw;
    }

    public com.baidu.adp.widget.ListView.ab coX() {
        return this.ibG;
    }

    public com.baidu.tieba.frs.mc.d coY() {
        return this.iay;
    }

    public com.baidu.tieba.frs.smartsort.a coZ() {
        return this.ias;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public FrsModelController cpa() {
        return this.iao;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public com.baidu.tieba.frs.mc.c cpb() {
        return this.iaz;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public com.baidu.tieba.frs.vc.h cpc() {
        return this.iap;
    }

    public FrsTabViewController cpd() {
        return this.iaq;
    }

    public ax cpe() {
        return this.iau;
    }

    public void ok(boolean z) {
        this.iaR = z;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public q cpf() {
        return this.hZV;
    }

    @Override // com.baidu.tieba.frs.aw
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.aw, com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.hZN;
    }

    public void setForumName(String str) {
        this.hZN = str;
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
        if (this.iaz == null) {
            return 1;
        }
        return this.iaz.getPn();
    }

    public int getPn() {
        if (this.iaz == null) {
            return 1;
        }
        return this.iaz.getPn();
    }

    public void setPn(int i) {
        if (this.iaz != null) {
            this.iaz.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.iaz != null) {
            this.iaz.setHasMore(i);
        }
    }

    public int cpg() {
        if (this.iaz == null) {
            return -1;
        }
        return this.iaz.cpg();
    }

    public boolean cph() {
        return this.hZT;
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
            this.hZV.cql();
            showNetRefreshView(this.hZV.caY(), string, true);
        } else if (340001 == fVar.errorCode) {
            a(fVar, this.hZt.getRecm_forum_list());
        } else {
            if (com.baidu.tbadk.core.util.y.isEmpty(this.hZt.getThreadList())) {
                b(fVar);
            }
            if (cpM()) {
                setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds280));
            } else {
                setNetRefreshViewEmotionDefMarginTop();
            }
        }
    }

    public void a(View view, String str, boolean z, List<RecmForumInfo> list) {
        this.hZV.cql();
        this.hZV.xB(8);
        if (this.iaH == null) {
            this.iaH = new com.baidu.tieba.frs.view.a(getPageContext(), getNetRefreshListener());
        }
        this.iaH.setSubText(str);
        this.iaH.setListData(list);
        this.iaH.attachView(view, z);
    }

    private void a(com.baidu.tieba.tbadkCore.f fVar, List<RecmForumInfo> list) {
        if (this.hZV != null) {
            this.hZV.cql();
            this.hZV.setTitle(this.hZN);
            a(this.hZV.caY(), fVar.errorMsg, true, list);
        }
    }

    private void b(com.baidu.tieba.tbadkCore.f fVar) {
        this.hZV.cql();
        if (fVar.hJU) {
            showNetRefreshView(this.hZV.caY(), TbadkCoreApplication.getInst().getString(R.string.net_error_text, new Object[]{fVar.errorMsg, Integer.valueOf(fVar.errorCode)}), true);
        } else {
            showNetRefreshView(this.hZV.cqT().cxd(), fVar.errorMsg, true);
        }
    }

    public void cpi() {
        hideLoadingView(this.hZV.caY());
        this.hZV.bHu();
        if (this.hZV.cqj() instanceof com.baidu.tieba.frs.tab.c) {
            ((com.baidu.tieba.frs.tab.c) this.hZV.cqj()).cvO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpj() {
        if (cpg() == 0 && com.baidu.tbadk.core.util.y.isEmpty(this.hZt.getThreadListIds())) {
            if (com.baidu.tbadk.core.util.y.isEmpty(this.hZt.getThreadList())) {
                this.hZV.bIk();
            } else {
                this.hZV.bIj();
            }
        } else if (com.baidu.tbadk.core.util.y.getCount(this.hZt.getThreadList()) > 3) {
            this.hZV.bIi();
        } else {
            this.hZV.cqH();
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
            cpi();
            this.hZV.cqr();
            com.baidu.tieba.tbadkCore.f cvd = this.iao.cvd();
            boolean isEmpty = com.baidu.tbadk.core.util.y.isEmpty(this.hZt.getThreadList());
            if (cvd != null && isEmpty) {
                if (this.iao.cvf() != 0) {
                    this.iao.cvk();
                    this.hZV.cqr();
                } else {
                    a(cvd);
                }
                this.hZV.W(this.hZt.isStarForum(), false);
                return;
            }
            a(cvd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(com.baidu.tieba.tbadkCore.m mVar) {
        if (mVar != null && mVar.getEntelechyTabInfo() != null && mVar.getEntelechyTabInfo().tab != null) {
            for (FrsTabInfo frsTabInfo : mVar.getEntelechyTabInfo().tab) {
                if (frsTabInfo.tab_id.intValue() == 502 && com.baidu.tbadk.core.sharedPref.b.bjf().getBoolean("first_into_tab_profession", true)) {
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
            aVar.zU(forumData.getRiskTipPopTitle());
            aVar.setTitleShowCenter(true);
            aVar.zV(forumData.getRiskTipPop());
            aVar.a(R.string.frs_risk_dialog_button_text, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.19
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                }
            });
            aVar.b(getPageContext()).bia();
        }
    }

    public boolean cpk() {
        return cpl() && !cpm();
    }

    private boolean cpl() {
        if (cpJ() == null) {
            return false;
        }
        FrsViewData cpJ = cpJ();
        com.baidu.tbadk.core.data.y yVar = null;
        if (cpJ.getStar() != null && !StringUtils.isNull(cpJ.getStar().dzR())) {
            yVar = new com.baidu.tbadk.core.data.y();
        } else if (cpJ.getActivityHeadData() != null && com.baidu.tbadk.core.util.y.getCount(cpJ.getActivityHeadData().bdC()) >= 1) {
            yVar = cpJ.getActivityHeadData().bdC().get(0);
        }
        return yVar != null;
    }

    public boolean cpm() {
        if (cpJ() == null) {
            return false;
        }
        FrsViewData cpJ = cpJ();
        return (com.baidu.tbadk.core.util.y.isEmpty(cpJ.getShowTopThreadList()) && cpJ.getBusinessPromot() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpn() {
        boolean b;
        if (!cpp()) {
            final PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
            privateForumPopInfoData.a(this.hZt.getPrivateForumTotalInfo().getPrivatePopInfo());
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(getActivity());
            if (this.hZt.getPrivateForumTotalInfo().bev().private_forum_status.intValue() == 1 && (com.baidu.tbadk.core.util.at.isEmpty(privateForumPopInfoData.bex()) || privateForumPopInfoData.beA() != Integer.valueOf(this.forumId))) {
                privateForumPopInfoData.zy("create_success");
                privateForumPopInfoData.zz(TbadkCoreApplication.getInst().getString(R.string.frs_private_create_hint));
                privateForumPopInfoData.zA("https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.hZN + "&nomenu=1");
                privateForumPopInfoData.i(Integer.valueOf(this.forumId));
                b = frsPrivateCommonDialogView.b(privateForumPopInfoData);
            } else {
                b = privateForumPopInfoData.beA() == Integer.valueOf(this.forumId) ? frsPrivateCommonDialogView.b(privateForumPopInfoData) : false;
            }
            if (b) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
                aVar.nH(2);
                aVar.aZ(frsPrivateCommonDialogView);
                aVar.ie(false);
                frsPrivateCommonDialogView.setConfirmButton(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.20
                    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.frs.FrsFragment */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        com.baidu.tbadk.core.util.be.bkp().b(FrsFragment.this.getPageContext(), new String[]{privateForumPopInfoData.bez()});
                        aVar.dismiss();
                    }
                });
                aVar.a(new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.21
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(getPageContext()).bia();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpo() {
        if (cpp() || this.hZt.getPrivateForumTotalInfo().bev().private_forum_status.intValue() != 1) {
            a((Integer) null, (Integer) null, true);
        } else {
            a(this.hZt.getPrivateForumTotalInfo().bev().private_forum_audit_status, this.hZt.getPrivateForumTotalInfo().bew(), false);
        }
    }

    public void a(Integer num, Integer num2, boolean z) {
        final String str;
        final int i = 2;
        if (this.hZV.cqx() != null) {
            TextView cqx = this.hZV.cqx();
            if (z) {
                cqx.setVisibility(8);
                return;
            }
            if (num.intValue() == 2) {
                cqx.setText("修改实名认证信息");
                cqx.setVisibility(0);
                str = "https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + this.forumId + "&nomenu=1";
            } else if (num2.intValue() >= 0 && num2.intValue() <= 100) {
                cqx.setText("目标已完成" + String.valueOf(num2) + "%");
                cqx.setVisibility(0);
                str = "https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.hZN + "&nomenu=1";
                i = 1;
            } else {
                cqx.setVisibility(8);
                i = 0;
                str = "";
            }
            cqx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.22
                /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13387").dF("fid", FrsFragment.this.forumId).dF("uid", TbadkCoreApplication.getCurrentAccount()).ai("obj_type", i));
                    com.baidu.tbadk.core.util.be.bkp().b(FrsFragment.this.getPageContext(), new String[]{str});
                }
            });
        }
    }

    private boolean cpp() {
        return this.hZt == null || this.hZt.getPrivateForumTotalInfo() == null || this.hZt.getPrivateForumTotalInfo().bev() == null || this.hZt.getUserData().getIs_manager() != 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xq(int i) {
        List<WindowToast> list;
        if (TbadkCoreApplication.isLogin() && this.hZt != null && (list = this.hZt.mWindowToast) != null && list.size() > 0) {
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
    public void cpq() {
        if (getActivity() != null && getActivity().getIntent() != null) {
            String stringExtra = getActivity().getIntent().getStringExtra(FrsActivityConfig.KEY_ACHIEVEMENT_URL);
            if (!TextUtils.isEmpty(stringExtra)) {
                getActivity().getIntent().removeExtra(FrsActivityConfig.KEY_ACHIEVEMENT_URL);
                AchievementActivityConfig achievementActivityConfig = new AchievementActivityConfig(getActivity());
                achievementActivityConfig.setUrl(stringExtra);
                if (this.hZt != null && this.hZt.getForumActiveInfo() != null) {
                    achievementActivityConfig.setShareUrl(this.hZt.getForumActiveInfo().forum_share_url);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, achievementActivityConfig));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpr() {
        if (this.hZt == null || this.hZt.getForum() != null) {
            this.hZV.cqD();
        } else if (this.hZt.getForum().getYuleData() != null && this.hZt.getForum().getYuleData().bhR()) {
            TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_VIEW);
            this.hZV.a(this.hZt.getForum().getYuleData().bhS());
        } else {
            this.hZV.cqD();
        }
    }

    private void U(boolean z, boolean z2) {
        if (this.iao != null && this.hZt != null && this.hZV != null && z) {
            if (!this.iao.cvr() && this.iao.cvh() == 1) {
                if (!this.iao.cvp()) {
                    this.hZt.addCardVideoInfoToThreadList();
                    this.hZt.addVideoInfoToThreadListInTenAndFifteenFloor();
                }
                boolean z3 = false;
                if (this.hZV.cqE().r(com.baidu.tieba.card.data.o.huD)) {
                    z3 = this.hZt.addHotTopicDataToThreadList();
                }
                if (!z3) {
                    this.hZt.addFeedForumDataToThreadList();
                }
                if (TbadkCoreApplication.getInst().isRecAppExist()) {
                    this.hZt.addRecommendAppToThreadList(this);
                }
                if (!this.hZV.cqE().r(bw.edD)) {
                    this.hZt.removeAlaLiveThreadData();
                }
                this.hZt.addSchoolRecommendToThreadList();
            }
            if (!this.hZV.cqE().r(bw.edD)) {
                this.hZt.removeAlaInsertLiveData();
                this.hZt.removeAlaStageLiveDat();
            } else {
                this.hZt.addInsertLiveDataToThreadList();
                this.hZt.addStageLiveDataToThreadList();
            }
            this.hZt.checkLiveStageInThreadList();
            this.hZt.addNoticeThreadToThreadList();
            if (this.hZV.cqE().r(com.baidu.tieba.h.b.iIr)) {
                this.hZt.addGameRankListToThreadList(z2);
            }
            if (TbadkCoreApplication.isLogin() && (!this.iao.cvr() || this.iao.isNetFirstLoad)) {
                this.hZt.addUserRecommendToThreadList();
            }
            this.hZt.addVideoActivityToTop();
        }
    }

    public boolean cps() {
        if (this.iap != null && this.iao != null) {
            this.iap.a(this.iao.getPageType(), this.hZt);
        }
        boolean z = false;
        if (this.hZt != null) {
            z = this.hZt.hasTab();
        }
        cpv();
        if (this.hZV != null) {
            this.hZV.cqR();
            this.hZV.cqS();
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr(int i) {
        ba baVar = null;
        cps();
        cpE();
        try {
            if (this.hZt != null) {
                this.hZV.a((ArrayList<com.baidu.adp.widget.ListView.q>) null, this.hZt);
                this.iap.zk(1);
                this.hZV.cqu();
                this.iaq.a(this.hZt, this.iao.cvm());
                com.baidu.tieba.frs.tab.d zt = this.iaq.zt(this.hZt.getFrsDefaultTabId());
                if (zt != null && !TextUtils.isEmpty(zt.url)) {
                    baVar = new ba();
                    baVar.ext = zt.url;
                    baVar.stType = zt.name;
                }
                this.iao.a(this.hZt.getFrsDefaultTabId(), 0, baVar);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(boolean z, boolean z2) {
        try {
            if (this.hZt != null && this.iaq != null && this.iao != null) {
                if (!this.hZV.cqE().r(bw.edD)) {
                    this.hZt.removeAlaLiveThreadData();
                }
                boolean isEmpty = com.baidu.tbadk.core.util.y.isEmpty(this.hZt.getGameTabInfo());
                this.hZV.ot(isEmpty);
                if (!isEmpty) {
                    if (this.iaI == null) {
                        this.iaI = new com.baidu.tieba.frs.vc.e(this, (NoPressedRelativeLayout) this.mRootView);
                    }
                    if (this.gbb == null) {
                        this.gbb = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
                    }
                } else {
                    this.iaI = null;
                    this.gbb = null;
                }
                if (this.hZt.getForum() != null) {
                    this.hZN = this.hZt.getForum().getName();
                    this.forumId = this.hZt.getForum().getId();
                }
                if (this.hZt.hasTab()) {
                    this.iaq.a(this.hZt, this.iao.cvm());
                }
                if (z) {
                    U(true, z);
                } else {
                    U(this.iaj, z);
                }
                cps();
                if (this.iaw != null) {
                    this.iaw.a(this.iap, this.hZt);
                }
                if (this.hZt.getPage() != null) {
                    setHasMore(this.hZt.getPage().beo());
                }
                ArrayList<com.baidu.adp.widget.ListView.q> a2 = this.iaz.a(z2, true, this.hZt.getThreadList(), null, z, false);
                if (a2 != null) {
                    this.hZt.setThreadList(a2);
                }
                this.hZt.removeRedundantUserRecommendData();
                this.hZv = this.hZt.getTopThreadSize();
                if (this.hZR != null) {
                    this.hZQ = true;
                    this.hZR.Io(this.hZv);
                    com.baidu.tieba.frs.f.a.a(this, this.hZt.getForum(), this.hZt.getThreadList(), this.hZQ, getPn());
                }
                if (this.iao.cvh() == 1) {
                    cpz();
                    if (!z && this.iao.getPn() == 1) {
                        cpu();
                    }
                }
                if (this.iax != null) {
                    this.iax.cv(this.iaq.cxm());
                }
                cpi();
                this.hZV.cqm();
                this.hZV.W(true, false);
                if (z && this.hZt.isFirstTabEqualAllThread()) {
                    com.baidu.adp.lib.f.e.mX().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.24
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!FrsFragment.this.iag && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                FrsFragment.this.hZV.cqP();
                            }
                        }
                    });
                }
                if (this.hZt.getForum() != null) {
                    this.hZV.IO(this.hZt.getForum().getWarningMsg());
                }
                if (this.hZt != null && this.hZt.getFrsVideoActivityData() != null && com.baidu.tbadk.core.sharedPref.b.bjf().getLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 0L) == 0) {
                    com.baidu.adp.lib.f.e.mX().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.25
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsFragment.this.hZV.cqN();
                        }
                    }, 1000L);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FRS_SHOW_AR_ENTRY, this));
                this.hZV.cqg();
                if (this.hZt != null && this.hZt.getForum() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ENTER_FORUM, new VisitedForumData(this.hZt.getForum().getId(), this.hZt.getForum().getName(), this.hZt.getForum().getImage_url(), String.valueOf(System.currentTimeMillis() / 1000), ConstantData.Forum.SPECAIL_FORUM_TYPE_LIVE.equals(this.hZt.getForum().special_forum_type), this.hZt.getForum().getThemeColorInfo(), this.hZt.getForum().getMember_num())));
                }
                this.iaM.a(this.hZt.bottomMenuList, this.hZt.getForum());
                cpT();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void cpt() {
        if (this.iao != null && this.iao.cvh() == 1) {
            this.iap.j(this.hZt);
        }
    }

    public void ol(boolean z) {
        com.baidu.tieba.s.c.dzC().b(getUniqueId(), z);
    }

    public void cpu() {
        if (this.iaC == null) {
            this.iaC = new com.baidu.tieba.frs.live.a(this, com.baidu.adp.lib.f.b.toInt(this.forumId, 0));
        }
        this.iaC.cuO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.tbadkCore.m mVar) {
        try {
            if (!this.iag && mVar != null && this.hZt != null) {
                this.hZt.receiveData(mVar);
                V(true, false);
                Looper.myQueue().addIdleHandler(this.ibb);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void cpv() {
        if (this.iao != null) {
            IN(this.iao.getPageType());
        } else {
            IN("normal_page");
        }
    }

    private void IN(String str) {
        om("frs_page".equals(str));
        if (this.iaw != null) {
            this.iaw.a(this.iap, this.hZV, this.hZt);
        }
    }

    public void om(boolean z) {
        if (this.iaA != null) {
            this.iaA.cwY();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.s.c.dzC().z(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.frs_activity, viewGroup, false);
            this.hZH = new com.baidu.tieba.frs.entelechy.a();
            this.iaw = this.hZH.csB();
            this.hZG = TbadkCoreApplication.getInst().getString(R.string.frs_title_new_area);
            this.iap = new com.baidu.tieba.frs.vc.h(this, this.hZH, (FrsHeaderViewContainer) this.mRootView.findViewById(R.id.header_view_container));
            this.iaq = new FrsTabViewController(this, this.mRootView);
            this.iaq.registerListener();
            this.iap.a(this.iaq);
            this.iaq.a(this.ibj);
            Intent intent = getActivity().getIntent();
            if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                this.hZJ = true;
            }
            this.hZV = new q(this, this.ibE, this.hZH, this.hZJ, this.iap);
            this.iaM = new com.baidu.tieba.frs.brand.buttommenu.a(getPageContext(), this.mRootView);
        } else {
            if (this.mRootView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            if (this.iaq != null) {
                this.iaq.registerListener();
            }
            this.hZV.cqM();
            this.mRootView.setLeft(0);
            this.mRootView.setRight(com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getContext()));
        }
        this.iaQ = true;
        this.eUF = System.currentTimeMillis() - currentTimeMillis;
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        ArrayList<com.baidu.adp.widget.ListView.q> arrayList = null;
        this.hCy = System.currentTimeMillis();
        long j = this.hCy;
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.hZS = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.hCy = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            T(intent);
        }
        this.eUE = j - this.hCy;
        this.hZR = new com.baidu.tieba.tbadkCore.data.f("frs", com.baidu.tieba.tbadkCore.data.f.mnZ);
        if (this.iao == null) {
            this.iao = new FrsModelController(this, this.ibz);
            this.iao.a(this.ibi);
            this.iao.init();
        }
        this.iao.setSchemeUrl(this.mSchemeUrl);
        if (intent != null) {
            this.iao.aj(intent.getExtras());
        } else if (bundle != null) {
            this.iao.aj(bundle);
        } else {
            this.iao.aj(null);
        }
        if (intent != null) {
            this.iap.aq(intent.getExtras());
        } else if (bundle != null) {
            this.iap.aq(bundle);
        } else {
            this.iap.aq(null);
        }
        this.hZU = getVoiceManager();
        this.iaD = new p(getPageContext(), this);
        initUI();
        initData(bundle);
        if (!cpM()) {
            this.iau = new ax(getActivity(), this.hZV, this.iap);
            this.iau.oI(true);
        }
        this.hZU = getVoiceManager();
        if (this.hZU != null) {
            this.hZU.onCreate(getPageContext());
        }
        if (FrsActivityConfig.FRS_FROM_FLUTTER_BCASTEDIT.equals(getFrom()) && !this.hasInit) {
            int i = com.baidu.tbadk.core.sharedPref.b.bjf().getInt("key_forum_broadcast_edit_tip_number", 0);
            if (i < 2) {
                com.baidu.tbadk.core.sharedPref.b.bjf().putInt("key_forum_broadcast_edit_tip_number", i + 1);
                cpB();
            } else if (Build.VERSION.SDK_INT >= 23) {
                if (Settings.canDrawOverlays(getContext())) {
                    cpC();
                } else {
                    new BdTopToast(getContext()).xd(false).SP(getContext().getString(R.string.forum_broadcast_copy_no_permission_hint)).aF(this.hZV.caY());
                }
            } else {
                cpC();
            }
        }
        if (KuangFloatingFrsCopyLinkViewController.getInstance().isFloatCopyViewShow()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
            if (this.hZW != null) {
                this.hZW.setVisibility(8);
            }
        }
        new com.baidu.tieba.frs.mc.i();
        int i2 = -1;
        if (this.iaz != null && this.iaz.cuZ() != null) {
            i2 = this.iaz.cuZ().cpg();
            arrayList = this.iaz.cuZ().getDataList();
        }
        this.iaz = new com.baidu.tieba.frs.mc.c(this, this.ibC);
        this.iaz.cuZ().setHasMore(i2);
        if (arrayList != null && arrayList.size() > 0) {
            this.iaz.cuZ().aE(arrayList);
        }
        this.ias = new com.baidu.tieba.frs.smartsort.a(this);
        this.iaA = new com.baidu.tieba.frs.vc.j(this);
        this.iax = new com.baidu.tieba.frs.vc.a(getPageContext(), this.iao.cvo());
        this.iat = new com.baidu.tieba.frs.mc.b(this);
        this.iay = new com.baidu.tieba.frs.mc.d(this);
        this.iar = new com.baidu.tieba.frs.mc.h(this);
        this.iaB = new com.baidu.tieba.frs.mc.a(this);
        this.iaE = new com.baidu.tieba.frs.vc.c(this);
        this.iaF = new com.baidu.tieba.frs.mc.e(this, getUniqueId());
        this.iaK = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "frs");
        this.iaL = new com.baidu.tieba.ala.a(getPageContext());
        this.iaN = new com.baidu.tieba.frs.sportspage.notification.a(getPageContext());
        registerListener(this.ibr);
        registerListener(this.mMemListener);
        registerListener(this.ibp);
        registerListener(this.ibD);
        registerListener(this.ibA);
        registerListener(this.ibl);
        registerListener(this.ibm);
        registerListener(this.ibn);
        registerListener(this.ibo);
        registerListener(this.ibc);
        registerListener(this.ibd);
        registerListener(this.agj);
        registerListener(this.ibe);
        registerListener(this.ibI);
        registerListener(this.ibt);
        registerListener(this.ibh);
        registerListener(this.ibu);
        registerListener(this.ibs);
        registerListener(this.ibw);
        registerListener(this.ibx);
        registerListener(this.iby);
        this.ibJ.setTag(getPageContext().getUniqueId());
        MessageManager.getInstance().registerListener(this.ibJ);
        registerListener(this.ibK);
        registerListener(this.ibL);
        registerListener(this.ibM);
        registerListener(this.ibg);
        registerListener(this.ibN);
        registerListener(this.ibv);
        registerListener(this.ibf);
        registerListener(this.ibO);
        registerListener(this.ibP);
        registerListener(this.ibQ);
        this.hZV.ov(false);
        if (!cpM() && !this.hasInit) {
            showLoadingView(this.hZV.caY(), true);
            this.iao.R(3, false);
        }
        ay ayVar = new ay() { // from class: com.baidu.tieba.frs.FrsFragment.28
            @Override // com.baidu.tieba.frs.ay
            public void d(boolean z, boolean z2, int i3) {
                if (FrsFragment.this.hZV != null) {
                    if (i3 == 1) {
                        FrsFragment.this.hZV.xC(z ? 0 : 8);
                    } else if (i3 == 2) {
                        FrsFragment.this.hZV.xE(z ? 0 : 8);
                    }
                    if (!z2) {
                        FrsFragment.this.iaP = z;
                    }
                    if (FrsFragment.this.hZV.cqE() != null && (i3 == 2 || (FrsFragment.this.iao != null && FrsFragment.this.iao.cvi()))) {
                        FrsFragment.this.hZV.cqE().notifyDataSetChanged();
                    }
                    if (FrsFragment.this.cpd() != null) {
                        FrsTabViewController.b cxn = FrsFragment.this.cpd().cxn();
                        if (cxn != null) {
                            if ((cxn.fragment instanceof FrsCommonTabFragment) && (i3 == 2 || cxn.tabId == 502)) {
                                ((FrsCommonTabFragment) cxn.fragment).csr();
                            } else if ((cxn.fragment instanceof FrsNewAreaFragment) && (i3 == 2 || cxn.tabId == 503)) {
                                FrsNewAreaFragment frsNewAreaFragment = (FrsNewAreaFragment) cxn.fragment;
                                frsNewAreaFragment.csr();
                                if (frsNewAreaFragment.cvz() != null) {
                                    com.baidu.tieba.frs.mc.g cvz = frsNewAreaFragment.cvz();
                                    cvz.oK(!z);
                                    if (i3 == 1) {
                                        cvz.oy(!z);
                                    } else if (i3 == 2) {
                                        cvz.oy(true);
                                    }
                                }
                            } else if (cxn.fragment instanceof FrsGoodFragment) {
                                ((FrsGoodFragment) cxn.fragment).csr();
                            }
                        }
                        if (FrsFragment.this.cpd().cxe() != null) {
                            FrsFragment.this.cpd().cxe().setmDisallowSlip(z);
                            FrsFragment.this.cpd().pp(z);
                        }
                    }
                    if (FrsFragment.this.hZV.cqk() != null) {
                        FrsFragment.this.hZV.os(!z);
                    }
                    if (FrsFragment.this.getActivity() instanceof FrsActivity) {
                        ((FrsActivity) FrsFragment.this.getActivity()).oj(!z);
                    }
                    if (FrsFragment.this.iaM != null) {
                        FrsFragment.this.iaM.oQ(!z);
                    }
                    FrsFragment.this.hZV.ox(!z);
                    if (i3 == 1) {
                        FrsFragment.this.hZV.oy(z ? false : true);
                    } else if (i3 == 2) {
                        FrsFragment.this.hZV.oy(true);
                    }
                }
            }

            @Override // com.baidu.tieba.frs.ay
            public void ci(int i3, int i4) {
                if (FrsFragment.this.hZV != null) {
                    if (i4 == 1) {
                        FrsFragment.this.hZV.xD(i3);
                    } else if (i4 == 2) {
                        FrsFragment.this.hZV.xF(i3);
                    }
                }
            }

            @Override // com.baidu.tieba.frs.ay
            public void xv(int i3) {
                if (FrsFragment.this.getContext() != null) {
                    if (i3 == 1) {
                        com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getContext(), R.string.frs_multi_delete_max_num);
                    } else if (i3 == 2 && FrsFragment.this.hZV != null) {
                        new BdTopToast(FrsFragment.this.getContext()).xd(false).SP(FrsFragment.this.getContext().getString(R.string.frs_move_area_max_num)).aF(FrsFragment.this.hZV.caY());
                    }
                }
            }
        };
        b.cog().a(ayVar);
        com.baidu.tieba.frs.a.cnZ().a(ayVar);
        this.hZV.b(new d.a() { // from class: com.baidu.tieba.frs.FrsFragment.29
            @Override // com.baidu.tieba.NEGFeedBack.d.a
            public void a(DeleteThreadHttpResponseMessage deleteThreadHttpResponseMessage) {
                boolean z;
                int i3 = 0;
                if (deleteThreadHttpResponseMessage != null) {
                    FrsFragment.this.hZV.bBs();
                    FrsFragment.this.hZV.cqO();
                    FrsNewAreaFragment frsNewAreaFragment = null;
                    if (FrsFragment.this.iaq == null || FrsFragment.this.iaq.cxn() == null || !(FrsFragment.this.iaq.cxn().fragment instanceof FrsNewAreaFragment)) {
                        z = false;
                    } else {
                        frsNewAreaFragment = (FrsNewAreaFragment) FrsFragment.this.iaq.cxn().fragment;
                        z = true;
                    }
                    if (deleteThreadHttpResponseMessage.getError() == 0) {
                        String text = !TextUtils.isEmpty(deleteThreadHttpResponseMessage.getText()) ? deleteThreadHttpResponseMessage.getText() : FrsFragment.this.getString(R.string.delete_fail);
                        if (deleteThreadHttpResponseMessage.getRetType() == 1211066) {
                            if (FrsFragment.this.htc == null) {
                                FrsFragment.this.htc = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.htc.zV(text);
                            FrsFragment.this.htc.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.29.1
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.htc.ie(false);
                            FrsFragment.this.htc.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.htc.bia();
                        } else if (deleteThreadHttpResponseMessage.getRetType() == 1211067) {
                            if (FrsFragment.this.htc == null) {
                                FrsFragment.this.htc = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.htc.zV(text);
                            FrsFragment.this.htc.a(R.string.know, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.29.2
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.htc.ie(false);
                            FrsFragment.this.htc.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.htc.bia();
                        } else {
                            FrsFragment.this.hZV.aL(deleteThreadHttpResponseMessage.getText(), ContextCompat.getColor(FrsFragment.this.getContext(), deleteThreadHttpResponseMessage.getRetType() == 1 ? R.color.nav_bar_tip_error : R.color.cp_link_tip_a_alpha95));
                        }
                        if (z && frsNewAreaFragment != null) {
                            frsNewAreaFragment.cV(deleteThreadHttpResponseMessage.getSuccessItems());
                        }
                        FrsFragment.this.cJ(deleteThreadHttpResponseMessage.getSuccessItems());
                        b.cog().cI(deleteThreadHttpResponseMessage.getSuccessItems());
                        for (com.baidu.adp.widget.ListView.q qVar : FrsFragment.this.hZt.getThreadList()) {
                            if (qVar instanceof bv) {
                                i3++;
                                continue;
                            }
                            if (i3 >= 6) {
                                break;
                            }
                        }
                        if (i3 < 6) {
                            FrsFragment.this.bGU();
                            return;
                        }
                        return;
                    }
                    com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getActivity(), deleteThreadHttpResponseMessage.getErrorString());
                }
            }
        });
        this.djl = UtilHelper.getScreenHeight(getActivity());
        this.hasInit = true;
        xs(1);
        super.onActivityCreated(bundle);
        this.createTime = System.currentTimeMillis() - j;
    }

    public void on(boolean z) {
        if (this.iaq != null) {
            this.iaq.iCL = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJ(List<String> list) {
        if (!com.baidu.tbadk.core.util.y.isEmpty(list)) {
            ArrayList<com.baidu.adp.widget.ListView.q> threadList = this.hZt.getThreadList();
            if (!com.baidu.tbadk.core.util.y.isEmpty(threadList) && this.hZV.getListView() != null && this.hZV.getListView().getData() != null) {
                Iterator<com.baidu.adp.widget.ListView.q> it = threadList.iterator();
                List<com.baidu.adp.widget.ListView.q> data = this.hZV.getListView().getData();
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.q next = it.next();
                    if (next instanceof bv) {
                        bw bwVar = ((bv) next).dXg;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= list.size()) {
                                break;
                            } else if (!com.baidu.tbadk.core.util.at.equals(list.get(i2), bwVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.iaz.d(next);
                                this.hZV.getListView().getAdapter().notifyItemRemoved(i);
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
    public void coe() {
        if (!com.baidu.tbadk.core.util.y.isEmpty(com.baidu.tieba.frs.a.cnZ().cod()) && this.hZV.getListView() != null && this.hZV.getListView().getData() != null) {
            ArrayList<com.baidu.adp.widget.ListView.q> threadList = this.hZt.getThreadList();
            if (!com.baidu.tbadk.core.util.y.isEmpty(threadList)) {
                Iterator<com.baidu.adp.widget.ListView.q> it = threadList.iterator();
                List<com.baidu.adp.widget.ListView.q> data = this.hZV.getListView().getData();
                int count = com.baidu.tbadk.core.util.y.getCount(com.baidu.tieba.frs.a.cnZ().cod());
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.q next = it.next();
                    if (next instanceof bv) {
                        bw bwVar = ((bv) next).dXg;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= count) {
                                break;
                            } else if (!com.baidu.tbadk.core.util.at.equals(com.baidu.tieba.frs.a.cnZ().cod().get(i2).getId(), bwVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.iaz.d(next);
                                this.hZV.getListView().getAdapter().notifyItemRemoved(i);
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
    public void bHp() {
        if (isAdded() && this.fJY && !isLoadingViewAttached()) {
            showLoadingView(this.hZV.caY(), true);
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void bHq() {
        if (isAdded() && this.fJY && isLoadingViewAttached()) {
            hideLoadingView(this.hZV.caY());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (cpM()) {
            showLoadingView(this.hZV.caY(), true);
            this.hZV.xG(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.iao.Q(3, true);
            blX().scrollToPosition(0);
        }
    }

    private void xs(int i) {
        String str = "";
        if (this.hZt != null && this.hZt.getForum() != null) {
            str = this.hZt.getForum().getId();
        }
        if (!StringUtils.isNull(str)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13008").dF("fid", str).dF("obj_type", "4").ai("obj_locate", i).dF("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.ab abVar) {
        if (abVar != null) {
            this.eYx = abVar.bwQ();
            this.iaG = abVar.bwR();
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void showFloatingView() {
        if (this.eYx != null) {
            this.eYx.showFloatingView(true);
        }
    }

    private void T(Intent intent) {
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
                this.hZN = uri.getQueryParameter("name");
                this.mFrom = uri.getQueryParameter("from");
                if (!StringUtils.isNull(this.hZN)) {
                    intent.putExtra("name", this.hZN);
                }
                if (!StringUtils.isNull(this.mFrom)) {
                    intent.putExtra("from", this.mFrom);
                }
                TiebaStatic.log(TbadkCoreStatisticKey.AS_INVOKE_TIEBA);
            }
            if (StringUtils.isNull(this.hZN) && uri != null) {
                if (com.baidu.tbadk.BdToken.f.p(uri)) {
                    com.baidu.tbadk.BdToken.f.aZy().b(uri, this.ibB);
                } else {
                    com.baidu.tieba.frs.f.f W = com.baidu.tieba.frs.f.k.W(intent);
                    if (W != null) {
                        this.hZN = W.forumName;
                        if (W.iAp == null || W.iAp.equals("aidou")) {
                        }
                    }
                }
                if (!StringUtils.isNull(this.hZN)) {
                    intent.putExtra("name", this.hZN);
                }
                intent.putExtra(FrsActivityConfig.FRS_CALL_FROM, 12);
            }
        }
    }

    /* renamed from: com.baidu.tieba.frs.FrsFragment$30  reason: invalid class name */
    /* loaded from: classes21.dex */
    class AnonymousClass30 implements f.a {
        AnonymousClass30() {
        }

        @Override // com.baidu.tbadk.BdToken.f.a
        public void z(final HashMap<String, Object> hashMap) {
            if (hashMap != null) {
                if (hashMap.get(com.baidu.tbadk.BdToken.f.dRp) instanceof String) {
                    FrsFragment.this.hZN = (String) hashMap.get(com.baidu.tbadk.BdToken.f.dRp);
                }
                if ((hashMap.get(com.baidu.tbadk.BdToken.f.dRH) instanceof String) && !TextUtils.isEmpty((String) hashMap.get(com.baidu.tbadk.BdToken.f.dRH))) {
                    com.baidu.adp.lib.f.e.mX().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.30.1
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsFragment.this.iaq.sn(301);
                            final long j = com.baidu.adp.lib.f.b.toLong((String) hashMap.get(com.baidu.tbadk.BdToken.f.dRq), 0L);
                            final int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
                            final int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
                            final float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                            final int i = 1;
                            if (com.baidu.tbadk.core.util.au.bkm().bkn()) {
                                i = 2;
                            }
                            com.baidu.adp.lib.f.e.mX().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.30.1.1
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
        this.hZU = getVoiceManager();
        if (this.hZU != null) {
            this.hZU.onStart(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        Intent intent;
        long j = 0;
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.eEB);
        if (bundle != null) {
            this.hZN = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            j = bundle.getLong(FrsActivityConfig.FRS_FAKE_THREAD_ID, 0L);
        } else if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
            this.hZN = intent.getStringExtra("name");
            this.mFrom = intent.getStringExtra("from");
            this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
            j = intent.getLongExtra(FrsActivityConfig.FRS_FAKE_THREAD_ID, 0L);
        }
        if (getArguments() != null) {
            this.hZO = getArguments().getBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, false);
        }
        if (TextUtils.isEmpty(this.mFrom) || FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
        }
        if (this.mIsLogin) {
            registerListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL, this.eEB);
        }
        this.iap.aq(bundle);
        eQ(j);
    }

    private void eQ(final long j) {
        if (j > 0) {
            final int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
            final int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
            final float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            final int i = 1;
            if (com.baidu.tbadk.core.util.au.bkm().bkn()) {
                i = 2;
            }
            com.baidu.adp.lib.f.e.mX().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.35
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
        com.baidu.tieba.s.c.dzC().A(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.ibI);
        this.iaA.destroy();
        hZZ = null;
        if (this.hZU != null) {
            this.hZU.onDestory(getPageContext());
        }
        com.baidu.tieba.recapp.report.a.remove("FRS");
        this.hZU = null;
        com.baidu.tieba.card.s.cfn().ns(false);
        if (this.hZt != null && this.hZt.getForum() != null) {
            ak.cro().eR(com.baidu.adp.lib.f.b.toLong(this.hZt.getForum().getId(), 0L));
        }
        if (this.iaC != null) {
            this.iaC.onDestory();
        }
        if (this.hZV != null) {
            com.baidu.tieba.frs.f.j.a(this.hZV, this.hZt, getForumId(), false, null);
            this.hZV.onDestroy();
        }
        if (this.hZY != null) {
            this.hZY.removeAllViews();
            this.hZY.setVisibility(8);
        }
        if (this.iaW != null) {
            this.iaW.cancel();
        }
        if (this.iaX != null) {
            com.baidu.adp.lib.f.e.mX().removeCallbacks(this.iaX);
        }
        this.iaV = null;
        super.onDestroy();
        try {
            if (this.iai != null) {
                this.iai.bvk();
            }
            if (this.hZV != null) {
                this.hZV.release();
            }
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.iap.cuG();
        Looper.myQueue().removeIdleHandler(this.ibb);
        if (this.iao != null) {
            this.iao.bMZ();
        }
        if (this.iau != null) {
            this.iau.crw();
        }
        if (this.iax != null) {
            this.iax.destory();
        }
        if (this.ias != null) {
            this.ias.onDestroy();
        }
        if (this.iaI != null) {
            this.iaI.onDestory();
        }
        if (this.iaB != null) {
            this.iaB.onDestroy();
        }
        if (this.iaK != null) {
            this.iaK.onDestroy();
        }
        if (this.iaL != null) {
            this.iaL.onDestroy();
        }
        com.baidu.tieba.recapp.d.a.drI().drL();
        com.baidu.tieba.frs.f.l.cwg();
        if (this.iaq != null) {
            this.iaq.a((FrsTabViewController.a) null);
            this.iaq.cxp();
        }
        if (this.iaO != null) {
            this.iaO.onDestroy();
        }
        b.cog().a(null);
        com.baidu.tieba.frs.a.cnZ().a(null);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.hZN);
        bundle.putString("from", this.mFrom);
        this.iao.onSaveInstanceState(bundle);
        if (this.hZU != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            this.hZU.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.iaB != null) {
            this.iaB.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.hZV != null) {
            this.hZV.cqr();
            this.hZV.onResume();
        }
        this.iar.ph(true);
        this.iaj = true;
        if (hZM) {
            hZM = false;
            if (this.hZV != null) {
                this.hZV.startPullRefresh();
                return;
            }
            return;
        }
        if (this.hZU != null) {
            this.hZU.onResume(getPageContext());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_RESUME));
        if (this.hZV != null) {
            this.hZV.oz(false);
        }
        if (this.iaJ) {
            refresh(6);
            this.iaJ = false;
        }
        if (this.iaS != null && getActivity() != null) {
            if (NotificationManagerCompat.from(getActivity()).areNotificationsEnabled()) {
                com.baidu.tbadk.coreExtra.messageCenter.f.bpO().setSignAlertOn(true);
                com.baidu.tbadk.coreExtra.messageCenter.f.bpO().setSignAlertTime(this.iaS.getHours(), this.iaS.getMinutes());
                if (this.hZV != null) {
                    com.baidu.tbadk.coreExtra.messageCenter.f.bpO().a(getTbPageContext().getPageActivity(), this.hZV.caY());
                }
            }
            this.iaS = null;
        }
        cpT();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
    }

    public boolean cpw() {
        Intent intent;
        if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
            return false;
        }
        return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
    }

    public void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.hZN = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.hZP = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.hZP) {
                cpx();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpx() {
        this.hZV.startPullRefresh();
    }

    public void closeActivity() {
        com.baidu.tieba.frs.f.k.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.mFrom);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.hZV.setTitle(this.hZN);
        } else {
            this.hZV.setTitle("");
            this.mFlag = 1;
        }
        this.hZV.a(this.ibG);
        this.hZV.addOnScrollListener(this.mScrollListener);
        this.hZV.g(this.hXf);
        this.hZV.cqE().a(this.ibF);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.iaQ) {
            this.hZV.onChangeSkinType(i);
            this.iap.zj(i);
            this.iaq.onChangeSkinType(i);
            if (this.hZX != null) {
                this.hZX.onChangeSkinType(i);
            }
            if (this.iaH != null) {
                this.iaH.onChangeSkinType();
            }
            if (this.iaM != null) {
                this.iaM.onChangeSkinType(getPageContext(), i);
            }
            if (this.htc != null) {
                com.baidu.tbadk.r.a.a(getPageContext(), this.htc.getRealView());
            }
            if (this.iaI != null) {
                this.iaI.onChangeSkinType(getPageContext(), i);
            }
        }
    }

    public void xt(int i) {
        if (!this.mIsLogin) {
            if (this.hZt != null && this.hZt.getAnti() != null) {
                this.hZt.getAnti().setIfpost(1);
            }
            if (i == 0) {
                com.baidu.tbadk.core.util.bg.skipToLoginActivity(getActivity());
            }
        } else if (this.hZt != null) {
            if (i == 0) {
                com.baidu.tieba.frs.f.l.g(this, 0);
            } else {
                this.hZV.cqt();
            }
        }
    }

    public void refresh() {
        com.baidu.tieba.a.d.bBN().DG("page_frs");
        refresh(3);
    }

    public void refresh(int i) {
        this.iag = false;
        cpE();
        if (this.hZV != null && this.hZV.cqi() != null) {
            this.hZV.cqi().cAY();
        }
        if (this.iao != null) {
            this.iao.Q(i, true);
        }
    }

    private void cpy() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.f.h.mY().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.36
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.Rr(FrsFragment.this.hZN);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpz() {
        cpE();
        try {
            if (this.hZt != null) {
                this.hZV.bMD();
                this.hZV.os(cpS());
                if (!com.baidu.tieba.frs.vc.h.m(this.hZt) || !com.baidu.tieba.frs.vc.h.l(this.hZt)) {
                }
                if (this.hZt.getForum() != null) {
                    this.hZN = this.hZt.getForum().getName();
                    this.forumId = this.hZt.getForum().getId();
                }
                if (this.hZt.getPage() != null) {
                    setHasMore(this.hZt.getPage().beo());
                }
                this.hZV.setTitle(this.hZN);
                this.hZV.setForumName(this.hZN);
                TbadkCoreApplication.getInst().setDefaultBubble(this.hZt.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.hZt.getUserData().getBimg_end_time());
                cpy();
                cpA();
                ArrayList<com.baidu.adp.widget.ListView.q> threadList = this.hZt.getThreadList();
                if (threadList != null) {
                    this.hZV.a(threadList, this.hZt);
                    com.baidu.tieba.frs.f.c.A(this.hZV);
                    this.iap.zk(getPageNum());
                    this.iap.i(this.hZt);
                    this.iaq.a(this.hZt, this.iao.cvm());
                    this.hZV.cqu();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void cpA() {
        if (this.hZt != null) {
            if (this.hZt.getIsNewUrl() == 1) {
                this.hZV.cqE().setFromCDN(true);
            } else {
                this.hZV.cqE().setFromCDN(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.iar.ph(false);
        this.iaj = false;
        this.hZV.onPause();
        if (this.hZU != null) {
            this.hZU.onPause(getPageContext());
        }
        this.hZV.oz(true);
        if (this.iax != null) {
            this.iax.cwj();
        }
        com.baidu.tbadk.BdToken.c.aZe().aZp();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.iaq != null && this.iaq.cxn() != null && (this.iaq.cxn().fragment instanceof BaseFragment)) {
            ((BaseFragment) this.iaq.cxn().fragment).setPrimary(z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.s.cfn().ns(false);
        ol(false);
        if (this.hZt != null && this.hZt.getForum() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            com.baidu.tbadk.distribute.a.bsi().b(getPageContext().getPageActivity(), "frs", this.hZt.getForum().getId(), 0L);
        }
        if (this.hZU != null) {
            this.hZU.onStop(getPageContext());
        }
        if (blX() != null) {
            blX().getRecycledViewPool().clear();
        }
        this.iap.bll();
        com.baidu.tbadk.util.ac.bwT();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            if (this.iap != null) {
                this.iap.bL(isPrimary());
            }
            if (this.hZV != null) {
                this.hZV.bL(isPrimary());
                this.hZV.oz(!isPrimary());
            }
        }
    }

    private void cpB() {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.nH(2);
        aVar.ie(false);
        FrsBroadcastCopyGuideDialogView frsBroadcastCopyGuideDialogView = new FrsBroadcastCopyGuideDialogView(getPageContext().getPageActivity());
        frsBroadcastCopyGuideDialogView.setConfirmButtonListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.37
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aVar != null) {
                    aVar.dismiss();
                    FrsFragment.this.cpC();
                }
            }
        });
        aVar.aZ(frsBroadcastCopyGuideDialogView);
        aVar.b(getPageContext()).bia();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpC() {
        if (KuangFloatingFrsCopyLinkViewController.getInstance().init()) {
            ((BaseFragmentActivity) getPageContext().getOrignalPage()).grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.frs.FrsFragment.38
                @Override // com.baidu.tbadk.core.e
                public void onPermissionResult(boolean z) {
                    if (!z) {
                        new BdTopToast(FrsFragment.this.getContext()).xd(false).SP(FrsFragment.this.getContext().getString(R.string.forum_broadcast_copy_no_permission_hint)).aF(FrsFragment.this.hZV.caY());
                        return;
                    }
                    KuangFloatingFrsCopyLinkViewController.getInstance().showFloatingView(true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                    if (FrsFragment.this.hZW != null) {
                        FrsFragment.this.hZW.setVisibility(8);
                    }
                }
            }, true);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (b.cog().coa()) {
                b.cog().reset();
                return true;
            } else if (com.baidu.tieba.frs.a.cnZ().coa()) {
                if (this.hZV != null && this.hZV.cqJ()) {
                    this.hZV.cqK();
                    return true;
                }
                com.baidu.tieba.frs.a.cnZ().reset();
                return true;
            } else if (this.hZV != null) {
                return this.hZV.cqq();
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
        com.baidu.tbadk.distribute.a.bsi().a(advertAppInfo, this.forumId, 0L, "FRS", str, getPn());
    }

    @Override // com.baidu.tieba.recapp.n
    public void cpD() {
        cpa().cpD();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.hZU == null) {
            this.hZU = VoiceManager.instance();
        }
        return this.hZU;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdRecyclerView blX() {
        if (this.hZV == null) {
            return null;
        }
        return this.hZV.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void cpE() {
        if (this.hZU != null) {
            this.hZU.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> blY() {
        if (this.exy == null) {
            this.exy = UserIconBox.u(getPageContext().getPageActivity(), 8);
        }
        return this.exy;
    }

    public void cpF() {
        if (getFragmentActivity() != null && getFragmentActivity().getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.t onGetPreLoadListView() {
        return blX().getPreLoadHandle();
    }

    @Override // com.baidu.tieba.frs.at
    public NavigationBar bKS() {
        if (this.hZV == null) {
            return null;
        }
        return this.hZV.bKS();
    }

    public FRSRefreshButton cpG() {
        return this.hZX;
    }

    public void c(LinearLayout linearLayout) {
        if (linearLayout != null) {
            this.hZY = linearLayout;
        }
    }

    public void a(FRSRefreshButton fRSRefreshButton) {
        if (fRSRefreshButton != null) {
            this.hZX = fRSRefreshButton;
            this.hZX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.44
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (FrsFragment.this.iaq != null) {
                        FrsTabViewController.b cxn = FrsFragment.this.iaq.cxn();
                        if (cxn != null && cxn.fragment != null && (cxn.fragment instanceof as)) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                            ((as) cxn.fragment).coM();
                            ((as) cxn.fragment).bIh();
                            return;
                        }
                        FrsFragment.this.cpf().startPullRefresh();
                    }
                }
            });
        }
    }

    public void cpH() {
        if (this.hZX != null) {
            this.hZX.hide();
        }
    }

    public void cpI() {
        if (this.hZX != null) {
            this.hZX.show();
        }
    }

    /* loaded from: classes21.dex */
    private final class a implements com.baidu.adp.widget.ListView.ab {
        private a() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.ab
        public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null) {
                if (bdUniqueId == w.idO) {
                    if (FrsFragment.this.hZV != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11752").dF("fid", FrsFragment.this.forumId).dF("obj_locate", "1"));
                        FrsFragment.this.hZV.startPullRefresh();
                    }
                } else if (qVar != null && (qVar instanceof bv)) {
                    bw bwVar = ((bv) qVar).dXg;
                    if (bwVar.bgy() == null || bwVar.bgy().getGroup_id() == 0 || com.baidu.tbadk.core.util.bg.checkUpIsLogin(FrsFragment.this.getActivity())) {
                        if (bwVar.bgl() != 1 || com.baidu.tbadk.core.util.bg.checkUpIsLogin(FrsFragment.this.getActivity())) {
                            if (bwVar.bfK() != null) {
                                if (com.baidu.tbadk.core.util.bg.checkUpIsLogin(FrsFragment.this.getActivity())) {
                                    String postUrl = bwVar.bfK().getPostUrl();
                                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.isNetOk()) {
                                        com.baidu.tbadk.browser.a.startInternalWebActivity(FrsFragment.this.getActivity(), postUrl);
                                    }
                                }
                            } else if (bwVar.bgJ() != null) {
                                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                    com.baidu.tbadk.core.util.bg.skipToLoginActivity(FrsFragment.this.getPageContext().getPageActivity());
                                    return;
                                }
                                com.baidu.tbadk.core.data.r bgJ = bwVar.bgJ();
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), bgJ.getCartoonId(), bgJ.getChapterId(), 2)));
                            } else {
                                com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                                if (readThreadHistory != null && !readThreadHistory.Rx(bwVar.getId())) {
                                    readThreadHistory.Rw(bwVar.getId());
                                }
                                boolean z = false;
                                final String bfE = bwVar.bfE();
                                if (bfE != null && !bfE.equals("")) {
                                    z = true;
                                    new Thread(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.a.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            com.baidu.tbadk.core.util.aa aaVar = new com.baidu.tbadk.core.util.aa(bfE);
                                            aaVar.bjL().bkq().mIsNeedAddCommenParam = false;
                                            aaVar.bjL().bkq().mIsUseCurrentBDUSS = false;
                                            aaVar.getNetData();
                                        }
                                    }).start();
                                }
                                String tid = bwVar.getTid();
                                if (tid == null) {
                                    tid = "";
                                }
                                if (bwVar.bft() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                    com.baidu.tbadk.core.util.be.bkp().b(FrsFragment.this.getPageContext(), new String[]{tid, "", null});
                                    return;
                                }
                                if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && tid.length() > 4) {
                                    bwVar.setId(tid.substring(3));
                                }
                                if (bdUniqueId.getId() == bw.eff.getId()) {
                                    com.baidu.tieba.frs.f.j.a(bwVar.bfe());
                                } else if (bdUniqueId.getId() == bw.edG.getId()) {
                                    com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                                    aqVar.dF("obj_type", "2");
                                    aqVar.dF("tid", bwVar.getTid());
                                    TiebaStatic.log(aqVar);
                                }
                                com.baidu.tieba.frs.f.k.a(FrsFragment.this, bwVar, i, z);
                                com.baidu.tieba.frs.f.j.a(FrsFragment.this, FrsFragment.this.hZt, bwVar);
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
            hideNetRefreshView(this.hZV.cqT().cxd());
            showLoadingView(this.hZV.caY(), true);
            this.hZV.ov(false);
            this.iao.Q(3, true);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData cpJ() {
        return this.hZt;
    }

    public boolean cpK() {
        return this.hZV.cpK();
    }

    public void aE(Object obj) {
        if (this.iat != null && this.iat.ivF != null) {
            this.iat.ivF.callback(obj);
        }
    }

    public void aF(Object obj) {
        if (this.iat != null && this.iat.ivG != null) {
            this.iat.ivG.callback(obj);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        this.hZV.getListView().stopScroll();
        if (!this.hZV.cqA()) {
            if (!com.baidu.adp.lib.util.l.isNetOk()) {
                this.hZV.bIk();
            } else if (this.iao.cvh() == 1) {
                bHj();
                bGU();
            } else if (this.iao.hasMore()) {
                bGU();
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void onFailed(String str) {
        bHj();
        showToast(str);
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void aw(ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        boolean isEmpty = com.baidu.tbadk.core.util.y.isEmpty(arrayList);
        setHasMore(isEmpty ? 0 : 1);
        bHj();
        if (!isEmpty) {
            if (!this.iao.cvr() && TbadkCoreApplication.getInst().isRecAppExist() && this.iao.cvh() == 1) {
                this.hZt.addRecommendAppToThreadList(this, arrayList);
            }
            if (this.iao != null) {
                com.baidu.tieba.frs.d.a.a(getUniqueId(), arrayList, this.hZt.getForum(), this.iao.getSortType());
            }
            ArrayList<com.baidu.adp.widget.ListView.q> a2 = this.iaz.a(false, false, arrayList, this.hZR, false);
            if (a2 != null) {
                this.hZt.setThreadList(a2);
                this.hZV.a(a2, this.hZt);
            }
            if (this.iao != null) {
                com.baidu.tieba.frs.d.c.a(this.hZt, this.iao.cvm(), 2, getContext());
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.hZt.getForum()));
        }
    }

    private void bHj() {
        if (cpg() == 1 || this.iaz.cU(this.hZt.getThreadListIds())) {
            if (com.baidu.tbadk.core.util.y.getCount(this.hZt.getThreadList()) > 3) {
                this.hZV.bIi();
            } else {
                this.hZV.cqH();
            }
        } else if (com.baidu.tbadk.core.util.y.isEmpty(this.hZt.getThreadList())) {
            this.hZV.bIk();
        } else {
            this.hZV.bIj();
        }
    }

    @Override // com.baidu.tieba.frs.mc.l
    public void bGU() {
        if (this.iaz != null) {
            this.iaz.a(this.hZN, this.forumId, this.hZt);
        }
    }

    public void cpL() {
        if (!com.baidu.tbadk.core.util.ae.requestWriteExternalStorgeAndCameraPermission(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.ao.g(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment, com.baidu.m.a.a.InterfaceC0209a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        com.baidu.tieba.frs.f.k.a(this, i, strArr, iArr);
    }

    public void oo(boolean z) {
        if (this.iau != null) {
            this.iau.oI(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.iav.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a sh(int i) {
        return this.iav.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        this.iaD.b(bVar);
    }

    public boolean cpM() {
        return this.hZJ;
    }

    @Override // com.baidu.tieba.frs.aq
    public void Pd() {
        if (this.hZV != null) {
            showFloatingView();
            this.hZV.getListView().scrollToPosition(0);
            this.hZV.startPullRefresh();
        }
    }

    public ForumWriteData cpN() {
        if (this.hZt == null || this.hZt.getForum() == null) {
            return null;
        }
        ForumData forum = this.hZt.getForum();
        ForumWriteData forumWriteData = new ForumWriteData(forum.getId(), forum.getName(), forum.getPrefixData(), this.hZt.getAnti());
        forumWriteData.avatar = forum.getImage_url();
        forumWriteData.forumLevel = forum.getUser_level();
        forumWriteData.specialForumType = forum.special_forum_type;
        forumWriteData.firstDir = forum.getFirst_class();
        forumWriteData.secondDir = forum.getSecond_class();
        UserData userData = this.hZt.getUserData();
        forumWriteData.privateThread = userData != null ? userData.getPrivateThread() : 0;
        forumWriteData.frsTabInfo = cpO();
        return forumWriteData;
    }

    private FrsTabInfoData cpO() {
        int i;
        if (this.iao == null || this.hZt == null || this.iaq == null) {
            return null;
        }
        if (this.hZt.getEntelechyTabInfo() == null || com.baidu.tbadk.core.util.y.isEmpty(this.hZt.getEntelechyTabInfo().tab)) {
            return null;
        }
        int cxr = this.iaq.cxr();
        if (cxr == 502) {
            return null;
        }
        int i2 = -1;
        ArrayList arrayList = new ArrayList();
        Iterator<FrsTabInfo> it = this.hZt.getEntelechyTabInfo().tab.iterator();
        while (true) {
            i = i2;
            if (!it.hasNext()) {
                break;
            }
            FrsTabInfo next = it.next();
            if (next != null && next.is_general_tab.intValue() == 1) {
                arrayList.add(new FrsTabItemData(next));
                if (cxr == next.tab_id.intValue()) {
                    i2 = cxr;
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
    public void blA() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void op(boolean z) {
        this.iak = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z) {
        this.hZV.xB(8);
        ((FrsActivity) getActivity()).showLoadingView(view, z);
        ((FrsActivity) getActivity()).i(view, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        this.hZV.xB(0);
        ((FrsActivity) getActivity()).hideLoadingView(view);
        ((FrsActivity) getActivity()).i(view, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        super.showNetRefreshView(view, getResources().getString(R.string.refresh_view_title_text), null, getResources().getString(R.string.refresh_view_button_text), z, getNetRefreshListener());
        this.hZV.xB(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshViewNoClick(View view, String str, boolean z) {
        super.showNetRefreshViewNoClick(view, str, z);
        this.hZV.xB(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        super.hideNetRefreshView(view);
        this.hZV.xB(0);
    }

    public void cpP() {
        FrsTabViewController.b cxn;
        if (this.iaq != null && (cxn = this.iaq.cxn()) != null && cxn.fragment != null && (cxn.fragment instanceof as)) {
            ((as) cxn.fragment).coM();
        }
    }

    public void oq(boolean z) {
        this.hZL = z;
    }

    public void b(OvalActionButton ovalActionButton) {
        this.hZW = ovalActionButton;
    }

    public OvalActionButton cpQ() {
        return this.hZW;
    }

    public boolean cpR() {
        return this.hZL;
    }

    public void onShareSuccess(String str) {
        if (TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.util.at.isEmpty(str)) {
            if (this.iaO == null) {
                this.iaO = new AddExperiencedModel(getTbPageContext());
            }
            this.iaO.fW(this.forumId, str);
        }
    }

    public boolean cpS() {
        if (this.iak && !this.iaR) {
            return (this.iao != null && this.iao.cvi() && (b.cog().coa() || com.baidu.tieba.frs.a.cnZ().coa())) ? false : true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.f.b
    public boolean videoNeedPreload() {
        if (this.hZt != null) {
            return com.baidu.tbadk.util.ai.rc(2) || (com.baidu.tbadk.util.ai.bwZ() && this.hZt.isFrsVideoAutoPlay);
        }
        return super.videoNeedPreload();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpT() {
        if (!com.baidu.tbadk.core.util.at.isEmpty(this.forumId)) {
            com.baidu.tbadk.BdToken.c.aZe().q(com.baidu.tbadk.BdToken.b.dPN, com.baidu.adp.lib.f.b.toLong(this.forumId, 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpU() {
        String format;
        String str;
        if (isResumed() && this.iaV != null && this.iaV.size() >= 1 && this.iaU <= this.iaV.size() - 1) {
            final LiveHorseRaceData liveHorseRaceData = this.iaV.get(this.iaU);
            if (System.currentTimeMillis() / 1000 >= liveHorseRaceData.getRob_end_tm().longValue()) {
                this.iaU++;
                cpU();
            }
            if (this.hZY != null) {
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
                        if (FrsFragment.this.hZt == null) {
                            str2 = "";
                        } else if (FrsFragment.this.hZt.getForum() != null) {
                            str2 = FrsFragment.this.hZt.getForum().getName();
                        } else {
                            str2 = "";
                        }
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13744").ai("obj_source", 1).dF("fid", FrsFragment.this.forumId).dF("fname", str2));
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
                this.iaW = ValueAnimator.ofFloat(1.0f, 0.0f);
                this.iaW.setDuration(600L);
                this.iaW.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.FrsFragment.52
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        if (valueAnimator.isRunning()) {
                            frsRedpackRunView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                            frsRedpackRunView.setTranslationX(-(TbadkApplication.getInst().getContext().getResources().getDimensionPixelOffset(R.dimen.tbds850) * valueAnimator.getAnimatedFraction()));
                        }
                    }
                });
                this.iaW.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.FrsFragment.53
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        frsRedpackRunView.setAlpha(0.0f);
                        frsRedpackRunView.setTranslationY(TbadkApplication.getInst().getContext().getResources().getDimensionPixelOffset(R.dimen.tbds660));
                        frsRedpackRunView.hide();
                        FrsFragment.this.hZY.removeView(frsRedpackRunView);
                        if (FrsFragment.this.iaU > FrsFragment.this.iaV.size() - 1) {
                            FrsFragment.this.hZY.removeAllViews();
                            FrsFragment.this.hZY.setVisibility(8);
                            FrsFragment.this.iaU = 0;
                            return;
                        }
                        FrsFragment.this.cpU();
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        onAnimationEnd(animator);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                this.iaX = new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.54
                    @Override // java.lang.Runnable
                    public void run() {
                        if (FrsFragment.this.hZY != null && frsRedpackRunView != null) {
                            FrsFragment.this.iaW.start();
                        }
                    }
                };
                com.baidu.adp.lib.f.e.mX().postDelayed(this.iaX, 5000L);
                if (this.hZY.getChildCount() == 0) {
                    this.iaU++;
                    this.hZY.addView(frsRedpackRunView);
                    if (this.hZt != null) {
                        str = this.hZt.getForum() != null ? this.hZt.getForum().getName() : "";
                    } else {
                        str = "";
                    }
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13743").ai("obj_source", 1).dF("fid", this.forumId).dF("fname", str));
                }
                if (this.hZY.getVisibility() == 8 && ((BaseFragment) this.iaq.cxn().fragment).isPrimary() && !this.hZV.cqQ() && !this.iae) {
                    this.hZY.setVisibility(0);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        FrsTabViewController.b cxn;
        if (cpd() == null || (cxn = cpd().cxn()) == null || !(cxn.fragment instanceof BaseFragment)) {
            return null;
        }
        if (cxn.fragment instanceof FrsAllThreadFragment) {
            TbPageTag tbPageTag = super.getTbPageTag();
            int i = -1;
            if (this.hZt != null) {
                i = this.hZt.getSortType();
            }
            tbPageTag.sortType = com.baidu.tieba.frs.f.i.zh(i);
            tbPageTag.locatePage = "a070";
            if (this.hZG.equals(cxn.title)) {
                tbPageTag.locatePage = "a071";
            }
            return tbPageTag;
        } else if (cxn.fragment instanceof FrsFragment) {
            return null;
        } else {
            return ((BaseFragment) cxn.fragment).getTbPageTag();
        }
    }

    public void cpV() {
        if (this.hZt != null) {
            com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
            if (this.hZt.needLog == 1) {
                bVar.iyp = true;
            } else {
                bVar.iyp = false;
            }
            if (this.hZt.getForum() != null) {
                bVar.iyr = this.hZt.getForum().getId();
            }
            if (cpa() != null) {
                bVar.iyq = cpa().cvm();
            }
            if (com.baidu.tieba.frs.d.d.ijV != null) {
                bVar.iys = com.baidu.tieba.frs.d.d.ijV.iys;
                bVar.iyt = com.baidu.tieba.frs.d.d.ijV.iyt;
            }
            this.iaY = new com.baidu.tieba.frs.live.b(bVar, getTbPageTag(), getUniqueId());
            this.iaY.yK(this.iba);
            CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_CARD_CLICK, this.iaY);
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
            CustomMessageTask customMessageTask2 = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW, this.iaY);
            customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask2);
            CustomMessageTask customMessageTask3 = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_USER_CLICK, this.iaY);
            customMessageTask3.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask3);
            CustomMessageTask customMessageTask4 = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_VIDEO_CLICK, this.iaY);
            customMessageTask4.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask4);
        }
    }
}
