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
    public static com.baidu.tieba.tbadkCore.m iTb;
    private com.baidu.tbadk.util.y fGc;
    private com.baidu.adp.lib.d.b<TbImageView> few;
    private com.baidu.tieba.frs.gametab.b gLR;
    private com.baidu.tieba.frs.entelechy.a iSJ;
    private com.baidu.tieba.tbadkCore.data.f iST;
    private VoiceManager iSW;
    private OvalActionButton iSY;
    private FRSRefreshButton iSZ;
    private com.baidu.tieba.frs.mc.c iTA;
    private com.baidu.tieba.frs.vc.j iTB;
    private com.baidu.tieba.frs.mc.a iTC;
    private com.baidu.tieba.frs.live.a iTD;
    private p iTE;
    public com.baidu.tieba.frs.vc.c iTF;
    private com.baidu.tieba.frs.mc.e iTG;
    private View.OnTouchListener iTH;
    private com.baidu.tieba.frs.view.a iTI;
    private com.baidu.tieba.frs.vc.e iTJ;
    private boolean iTK;
    private com.baidu.tieba.NEGFeedBack.a iTL;
    private com.baidu.tieba.ala.a iTM;
    private com.baidu.tieba.frs.brand.buttommenu.a iTN;
    private com.baidu.tieba.frs.sportspage.notification.a iTO;
    private AddExperiencedModel iTP;
    private boolean iTR;
    private List<LiveHorseRaceData> iTW;
    private ValueAnimator iTX;
    private Runnable iTY;
    private com.baidu.tieba.frs.live.b iTZ;
    private LinearLayout iTa;
    public long iTc;
    private String iTm;
    private com.baidu.card.am iTo;
    private FrsModelController iTp;
    private com.baidu.tieba.frs.vc.h iTq;
    private FrsTabViewController iTr;
    private com.baidu.tieba.frs.mc.h iTs;
    private com.baidu.tieba.frs.smartsort.a iTt;
    private com.baidu.tieba.frs.mc.b iTu;
    private aw iTv;
    private com.baidu.tieba.frs.entelechy.b.b iTx;
    private com.baidu.tieba.frs.vc.a iTy;
    private com.baidu.tieba.frs.mc.d iTz;
    private com.baidu.tieba.frs.broadcast.a iUa;
    private int iUb;
    private com.baidu.tieba.frs.f.e iUc;
    private int iUm;
    private com.baidu.tbadk.core.dialog.a ilQ;
    private View mRootView;
    private String mSchemeUrl;
    public static boolean iSO = false;
    public static volatile long iTe = 0;
    public static volatile long iTf = 0;
    public static volatile int mNetError = 0;
    private String iSI = "";
    public boolean iSK = false;
    private boolean iSL = false;
    private boolean iSM = false;
    private boolean iSN = true;
    public String iSP = null;
    public String mFrom = null;
    public int mFlag = 0;
    public boolean iSQ = false;
    private boolean iSR = false;
    private String mThreadId = null;
    public String forumId = null;
    private int iSx = 0;
    private boolean iSS = false;
    private boolean iSU = false;
    private boolean iSV = false;
    private q iSX = null;
    public final by alu = null;
    private FrsViewData iSv = new FrsViewData();
    public long ivA = -1;
    public long fCl = 0;
    public long fCb = 0;
    public long createTime = 0;
    public long fCc = 0;
    public long fCi = 0;
    public long iTd = 0;
    boolean iTg = false;
    public boolean iTh = false;
    private boolean iTi = false;
    public com.baidu.tbadk.n.b iTj = null;
    private boolean iTk = true;
    private boolean iTl = true;
    private a.C0097a iTn = new a.C0097a(2);
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> iTw = new SparseArray<>();
    private boolean gtZ = true;
    private boolean hasInit = false;
    private boolean iTQ = false;
    private boolean iTS = false;
    private Date iTT = null;
    private int dOW = 0;
    private int iTU = 0;
    private int iTV = 0;
    public int mHeadLineDefaultNavTabId = -1;
    MessageQueue.IdleHandler iUd = new MessageQueue.IdleHandler() { // from class: com.baidu.tieba.frs.FrsFragment.1
        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            FrsFragment.this.cCt();
            return false;
        }
    };
    private final CustomMessageListener iUe = new CustomMessageListener(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED) { // from class: com.baidu.tieba.frs.FrsFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof by) {
                    com.baidu.tieba.frs.f.k.a(FrsFragment.this.iSX, FrsFragment.this.iSv, FrsFragment.this.getForumId(), true, (by) data);
                }
            }
        }
    };
    private CustomMessageListener iUf = new CustomMessageListener(CmdConfigCustom.CMD_CLOSE_GAME_RANK_CARD) { // from class: com.baidu.tieba.frs.FrsFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.iSv != null) {
                FrsFragment.this.iSv.removeGameRankListFromThreadList();
                if (FrsFragment.this.iSX != null) {
                    FrsFragment.this.iSX.bcP();
                }
            }
        }
    };
    private CustomMessageListener ahC = new CustomMessageListener(2921401) { // from class: com.baidu.tieba.frs.FrsFragment.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && FrsFragment.this.iSZ != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() <= 0 || FrsFragment.this.iTr.cLq() == 0 || FrsFragment.this.iTr.cLn() == null || !(FrsFragment.this.iTr.cLn().fragment instanceof BaseFragment) || !((BaseFragment) FrsFragment.this.iTr.cLn().fragment).isPrimary() || FrsFragment.this.iSX.cDQ() || com.baidu.tbadk.k.d.bDH().bDI()) {
                    if (FrsFragment.this.iTr.cLq() != 0) {
                        FrsFragment.this.iSZ.hide();
                        return;
                    }
                    return;
                }
                FrsFragment.this.iSZ.show();
            }
        }
    };
    private CustomMessageListener iUg = new CustomMessageListener(2921473) { // from class: com.baidu.tieba.frs.FrsFragment.45
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && FrsFragment.this.iSZ != null && FrsFragment.this.iSY != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() == 0) {
                    FrsFragment.this.iSZ.setVisibility(8);
                    FrsFragment.this.iSY.setVisibility(8);
                    return;
                }
                FrsFragment.this.iSY.setVisibility(0);
            }
        }
    };
    private CustomMessageListener iUh = new CustomMessageListener(2921467) { // from class: com.baidu.tieba.frs.FrsFragment.56
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && FrsFragment.this.iSZ != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() <= 0 || FrsFragment.this.iTr.cLn() == null || !(FrsFragment.this.iTr.cLn().fragment instanceof BaseFragment) || !((BaseFragment) FrsFragment.this.iTr.cLn().fragment).isPrimary() || FrsFragment.this.iSX.cDQ()) {
                    FrsFragment.this.iTa.setVisibility(8);
                    FrsFragment.this.iTg = true;
                    return;
                }
                FrsFragment.this.iTa.setVisibility(0);
                FrsFragment.this.iTg = false;
            }
        }
    };
    private com.baidu.adp.framework.listener.a iUi = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_FRS_LIVE_HORSE_RACE_LIST, 309667) { // from class: com.baidu.tieba.frs.FrsFragment.62
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if ((responsedMessage instanceof GetLiveHorseRaceHttpResponseMessage) || (responsedMessage instanceof GetLiveHorseRaceSocketResponseMessage)) {
                    List<LiveHorseRaceData> arrayList = new ArrayList<>();
                    if (responsedMessage instanceof GetLiveHorseRaceHttpResponseMessage) {
                        arrayList = ((GetLiveHorseRaceHttpResponseMessage) responsedMessage).getData().cEr();
                    }
                    if (responsedMessage instanceof GetLiveHorseRaceSocketResponseMessage) {
                        arrayList = ((GetLiveHorseRaceSocketResponseMessage) responsedMessage).getData().cEr();
                    }
                    if (FrsFragment.this.iTW != null) {
                        if (FrsFragment.this.iTa.getVisibility() != 8) {
                            if (FrsFragment.this.iTV >= FrsFragment.this.iTW.size()) {
                                FrsFragment.this.iTW.addAll(arrayList);
                                return;
                            }
                            FrsFragment.this.iTW = FrsFragment.this.iTW.subList(0, FrsFragment.this.iTV);
                            FrsFragment.this.iTW.addAll(arrayList);
                            return;
                        }
                        FrsFragment.this.iTW = new ArrayList();
                        FrsFragment.this.iTW.addAll(arrayList);
                        FrsFragment.this.iTV = 0;
                        FrsFragment.this.cCV();
                        return;
                    }
                    FrsFragment.this.iTW = new ArrayList();
                    FrsFragment.this.iTV = 0;
                    FrsFragment.this.iTW.addAll(arrayList);
                    FrsFragment.this.cCV();
                }
            }
        }
    };
    private CustomMessageListener iUj = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.FrsFragment.63
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 1) {
                    FrsFragment.this.cCx();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                }
            }
        }
    };
    private final au iUk = new au() { // from class: com.baidu.tieba.frs.FrsFragment.64
        @Override // com.baidu.tieba.frs.au
        public void a(int i, int i2, bd bdVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
            FrsFragment.this.cCi();
            if (FrsFragment.this.iTx != null) {
                FrsFragment.this.iTq.qY(FrsFragment.this.iTx.Aw(i));
            }
            com.baidu.tieba.tbadkCore.f fVar = new com.baidu.tieba.tbadkCore.f();
            if (bdVar != null) {
                fVar.isSuccess = bdVar.errCode == 0;
                fVar.errorCode = bdVar.errCode;
                fVar.errorMsg = bdVar.errMsg;
                if (fVar.isSuccess) {
                    if (com.baidu.tbadk.core.util.y.isEmpty(arrayList)) {
                        FrsFragment.this.iSX.bTb();
                    } else if (bdVar.hasMore) {
                        if (com.baidu.tbadk.core.util.y.getCount(FrsFragment.this.iSv.getThreadList()) > 3) {
                            FrsFragment.this.iSX.XZ();
                        } else {
                            FrsFragment.this.iSX.cDH();
                        }
                    } else if (bdVar.iXU) {
                        FrsFragment.this.iSX.Ya();
                    } else {
                        FrsFragment.this.iSX.bTb();
                    }
                }
            } else {
                bdVar = new bd();
                bdVar.pn = 1;
                bdVar.hasMore = false;
                bdVar.iXU = false;
            }
            if (i == 1) {
                FrsFragment.this.iTk = true;
                FrsFragment.this.iUB.a(FrsFragment.this.iTp.getType(), false, fVar);
            } else {
                FrsFragment.this.a(fVar);
                if (FrsFragment.this.iTp.cIF() != null) {
                    FrsFragment.this.iSv = FrsFragment.this.iTp.cIF();
                }
                FrsFragment.this.cCz();
            }
            if (FrsFragment.this.iUJ != null) {
                FrsFragment.this.iUJ.a(i, i2, bdVar, arrayList);
            }
        }
    };
    private FrsTabViewController.a iUl = new FrsTabViewController.a() { // from class: com.baidu.tieba.frs.FrsFragment.2
        @Override // com.baidu.tieba.frs.vc.FrsTabViewController.a
        public void cp(int i, int i2) {
            boolean z = false;
            if (i != 1) {
                com.baidu.tieba.card.t.csh().oX(false);
                FrsFragment.this.pR(false);
            }
            if (i == 502) {
                FrsFragment.this.iSY.setIconFade(R.drawable.btn_frs_professional_edit_n);
            } else {
                FrsFragment.this.iSY.setIconFade(0);
            }
            FrsFragment.this.iUm = i;
            FrsFragment.this.iUb = i2;
            if (FrsFragment.this.iTZ != null) {
                FrsFragment.this.iTZ.Bi(FrsFragment.this.iUb);
            }
            TbSingleton.getInstance().setFrsCurTabType(FrsFragment.this.iUb);
            FrsFragment.this.cCF();
            com.baidu.tieba.frs.d.d.jcU.jtU = i;
            com.baidu.tieba.frs.d.d.jcU.jtX = i2;
            com.baidu.tieba.frs.d.d.jcU.jtV = -1;
            b.cBe().V(i == 1 && FrsFragment.this.iTQ, true);
            com.baidu.tieba.frs.a cAX = com.baidu.tieba.frs.a.cAX();
            if (i == 1 && FrsFragment.this.iTQ) {
                z = true;
            }
            cAX.V(z, true);
        }
    };
    private CustomMessageListener iUn = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIVE_COUNT) { // from class: com.baidu.tieba.frs.FrsFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                FrsFragment.this.iTr.BS(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    };
    private CustomMessageListener iUo = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_LIVE_START) { // from class: com.baidu.tieba.frs.FrsFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && ((Integer) customResponsedMessage.getData()).intValue() == 51 && FrsFragment.this.iSv != null) {
                com.baidu.tieba.frs.f.m.a(FrsFragment.this.iSv, FrsFragment.this.getPageContext());
            }
        }
    };
    private final CustomMessageListener iUp = new CustomMessageListener(CmdConfigCustom.CMD_FRS_SELECT_ALA_LIVE_TAB) { // from class: com.baidu.tieba.frs.FrsFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                FrsFragment.this.iTr.ui(49);
            }
        }
    };
    private final CustomMessageListener iUq = new CustomMessageListener(2921470) { // from class: com.baidu.tieba.frs.FrsFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                FrsFragment.this.iTr.ui(1);
                FrsFragment.this.cCx();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
            }
        }
    };
    private final CustomMessageListener iUr = new CustomMessageListener(CmdConfigCustom.CMD_FRS_EXPERIENCE_TIP) { // from class: com.baidu.tieba.frs.FrsFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.w) && FrsFragment.this.iSv != null) {
                FrsFragment.this.iSv.updateLikeData((com.baidu.tieba.tbadkCore.w) customResponsedMessage.getData());
                FrsFragment.this.iTq.j(FrsFragment.this.iSv);
                FrsFragment.this.iTr.a(FrsFragment.this.iSv, FrsFragment.this.iTp.cJj());
            }
        }
    };
    private final AntiHelper.a iUs = new AntiHelper.a() { // from class: com.baidu.tieba.frs.FrsFragment.8
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).al("obj_locate", ay.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).al("obj_locate", ay.a.LOCATE_LIKE_PERSON));
        }
    };
    private CustomMessageListener iUt = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.FrsFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(FrsFragment.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().flk != null) {
                        if (AntiHelper.a(FrsFragment.this.getActivity(), updateAttentionMessage.getData().flk, FrsFragment.this.iUs) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).al("obj_locate", ay.a.LOCATE_LIKE_PERSON));
                        }
                    } else if (updateAttentionMessage.getData().isSucc && updateAttentionMessage.getData().isAttention) {
                        com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getPageContext().getPageActivity(), R.string.attention_success);
                    }
                }
            }
        }
    };
    private CustomMessageListener iUu = new CustomMessageListener(CmdConfigCustom.CMD_GET_ENSURE_CAST_ID) { // from class: com.baidu.tieba.frs.FrsFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsFragment.this.refresh();
        }
    };
    private CustomMessageListener iUv = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.frs.FrsFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && !((PostWriteCallBackData) customResponsedMessage.getData()).isDyamicCallback()) {
                FrsFragment.this.iSX.c((PostWriteCallBackData) customResponsedMessage.getData());
                if (((PostWriteCallBackData) customResponsedMessage.getData()).getGeneralTabId() >= 0) {
                    FrsFragment.this.iTC.Bk(((PostWriteCallBackData) customResponsedMessage.getData()).getGeneralTabId());
                }
            }
        }
    };
    private CustomMessageListener iUw = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_REMIND) { // from class: com.baidu.tieba.frs.FrsFragment.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626) {
                NewsRemindMessage newsRemindMessage = (NewsRemindMessage) customResponsedMessage;
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (FrsFragment.this.iSX != null) {
                    FrsFragment.this.iSX.P(notificationCount, z);
                }
            }
        }
    };
    private HttpMessageListener iUx = new HttpMessageListener(CmdConfigHttp.CMD_FRS_MOVE_AREA) { // from class: com.baidu.tieba.frs.FrsFragment.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int i;
            int i2 = 0;
            if (httpResponsedMessage != null && FrsFragment.this.getContext() != null && FrsFragment.this.iSX != null) {
                if (httpResponsedMessage.getError() == 0) {
                    new BdTopToast(FrsFragment.this.getContext()).yW(true).Vt(FrsFragment.this.getContext().getString(R.string.frs_move_area_move_suc)).aF(FrsFragment.this.iSX.cno());
                    if (com.baidu.tieba.frs.a.cAX().zC(com.baidu.tieba.frs.a.cAX().cAZ())) {
                        FrsCommonTabFragment frsCommonTabFragment = null;
                        if (FrsFragment.this.iTr != null && FrsFragment.this.iTr.cLn() != null && (FrsFragment.this.iTr.cLn().fragment instanceof FrsCommonTabFragment)) {
                            frsCommonTabFragment = (FrsCommonTabFragment) FrsFragment.this.iTr.cLn().fragment;
                        }
                        if (frsCommonTabFragment != null) {
                            frsCommonTabFragment.cFl();
                        }
                        FrsFragment.this.cBc();
                        com.baidu.tieba.frs.a.cAX().cBc();
                        Iterator<com.baidu.adp.widget.ListView.q> it = FrsFragment.this.iSv.getThreadList().iterator();
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
                            FrsFragment.this.bRN();
                        }
                    }
                    com.baidu.tieba.frs.a.cAX().reset();
                    return;
                }
                new BdTopToast(FrsFragment.this.getContext()).yW(false).Vt(httpResponsedMessage.getErrorString()).aF(FrsFragment.this.iSX.cno());
            }
        }
    };
    private final CustomMessageListener iUy = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.frs.FrsFragment.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.isResumed()) {
                FrsFragment.this.cCU();
            }
        }
    };
    private CustomMessageListener iUz = new CustomMessageListener(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER) { // from class: com.baidu.tieba.frs.FrsFragment.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (FrsFragment.this.iSX != null) {
                    FrsFragment.this.iSX.setExpanded(booleanValue);
                }
            }
        }
    };
    private final CustomMessageListener iUA = new CustomMessageListener(2921463) { // from class: com.baidu.tieba.frs.FrsFragment.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TbadkApplication.getInst().getCurrentActivity() != null && !com.baidu.tbadk.core.util.au.isEmpty(str) && str.equals(FrsFragment.this.forumId)) {
                    com.baidu.tieba.frs.f.h.b(((TbPageContextSupport) TbadkApplication.getInst().getCurrentActivity()).getPageContext(), FrsFragment.this.iSv);
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.s iUB = new com.baidu.tieba.tbadkCore.s() { // from class: com.baidu.tieba.frs.FrsFragment.18
        private long startTime = 0;

        @Override // com.baidu.tieba.tbadkCore.s
        public void zJ(int i) {
            this.startTime = System.nanoTime();
            if (FrsFragment.this.iSX != null) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsFragment.this.iSX.cDs();
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
            if (FrsFragment.this.gtZ) {
                FrsFragment.this.gtZ = false;
                com.baidu.tieba.frs.f.k.a(FrsFragment.this.iSX, FrsFragment.this.iSv, FrsFragment.this.getForumId(), false, null);
            }
            FrsFragment.this.cCi();
            FrsFragment.this.iTi = true;
            if (fVar != null && fVar.isSuccess) {
                FrsFragment.this.iSX.cDF().qB(com.baidu.tbadk.core.util.av.btX().btY());
                FrsFragment.iTe = 0L;
                FrsFragment.iTf = 0L;
                FrsFragment.mNetError = 0;
            } else {
                FrsFragment.mNetError = 1;
            }
            if (!FrsFragment.this.iTp.cJo() && (i == 3 || i == 6)) {
                FrsFragment.this.iTA.resetData();
            }
            FrsFragment.this.iTc = System.currentTimeMillis();
            if (FrsFragment.this.iTp.cIF() != null) {
                FrsFragment.this.iSv = FrsFragment.this.iTp.cIF();
            }
            FrsFragment.this.zF(1);
            FrsFragment.this.cCq();
            if (i == 7) {
                FrsFragment.this.zG(FrsFragment.this.iSv.getFrsDefaultTabId());
                return;
            }
            if (FrsFragment.this.iSv.getPage() != null) {
                FrsFragment.this.setHasMore(FrsFragment.this.iSv.getPage().bnF());
            }
            if (i == 4) {
                if (!FrsFragment.this.iTp.cJo() && TbadkCoreApplication.getInst().isRecAppExist() && FrsFragment.this.iTp.cJe() == 1) {
                    FrsFragment.this.iSv.addRecommendAppToThreadList(FrsFragment.this);
                }
                ArrayList<com.baidu.adp.widget.ListView.q> a2 = FrsFragment.this.iTA.a(false, false, FrsFragment.this.iSv.getThreadList(), FrsFragment.this.iST, false);
                if (a2 != null) {
                    FrsFragment.this.iSv.setThreadList(a2);
                    FrsFragment.this.iSv.checkLiveStageInThreadList();
                }
                if (FrsFragment.this.iTp != null) {
                    com.baidu.tieba.frs.d.c.a(FrsFragment.this.iSv, FrsFragment.this.iTp.cJj(), 2, FrsFragment.this.getContext());
                }
                com.baidu.tieba.frs.f.a.a(FrsFragment.this, FrsFragment.this.iSv.getForum(), FrsFragment.this.iSv.getThreadList(), false, FrsFragment.this.getPn());
                FrsFragment.this.iSX.a(a2, FrsFragment.this.iSv);
                FrsFragment.this.cCj();
                return;
            }
            FrsFragment.this.cCj();
            switch (i) {
                case 1:
                    FrsFragment.this.iSX.cDs();
                    break;
                case 2:
                    FrsFragment.this.iSX.cDs();
                    break;
                case 3:
                case 6:
                    if (FrsFragment.this.iSv != null) {
                        FrsFragment.this.iSv.clearPostThreadCount();
                    }
                    if (FrsFragment.this.iTF != null) {
                        FrsFragment.this.iTF.refresh();
                        break;
                    }
                    break;
            }
            FrsFragment.this.cCr();
            if (fVar == null || fVar.errorCode == 0) {
                if (FrsFragment.this.iSv != null) {
                    FrsFragment.this.a(FrsFragment.this.iSv);
                    FrsFragment.this.X(false, i == 5);
                    if (FrsFragment.this.iTp != null) {
                        if (FrsFragment.this.iSv.getActivityHeadData() != null && FrsFragment.this.iSv.getActivityHeadData().bmT() != null && FrsFragment.this.iSv.getActivityHeadData().bmT().size() > 0) {
                            com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), 1, FrsFragment.this.iSv.getForum(), FrsFragment.this.iTp.getSortType(), 1);
                        }
                        if (FrsFragment.this.iSv.getThreadList() != null && FrsFragment.this.iSv.getThreadList().size() > 0) {
                            Iterator<com.baidu.adp.widget.ListView.q> it = FrsFragment.this.iSv.getThreadList().iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    com.baidu.adp.widget.ListView.q next = it.next();
                                    if ((next instanceof by) && ((by) next).getType() == by.eKU) {
                                        com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), 1, FrsFragment.this.iSv.getForum(), FrsFragment.this.iTp.getSortType(), 2);
                                    }
                                }
                            }
                        }
                        com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), FrsFragment.this.iSv.getThreadList(), FrsFragment.this.iSv.getForum(), FrsFragment.this.iTp.getSortType());
                    }
                    FrsFragment.this.iSX.zW(i);
                    FrsFragment.iTe = (System.nanoTime() - this.startTime) / TimeUtils.NANOS_PER_MS;
                    if (fVar != null) {
                        FrsFragment.iTf = fVar.njx;
                    }
                } else {
                    return;
                }
            } else if (FrsFragment.this.iSv == null || com.baidu.tbadk.core.util.y.isEmpty(FrsFragment.this.iSv.getThreadList())) {
                FrsFragment.this.a(fVar);
            } else if (fVar.iCW) {
                FrsFragment.this.showToast(FrsFragment.this.getPageContext().getResources().getString(R.string.net_error_text, fVar.errorMsg, Integer.valueOf(fVar.errorCode)));
            }
            FrsFragment.this.cCn();
            FrsFragment.this.cCo();
            if (FrsFragment.this.iSv.getAccessFlag() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11384"));
            }
            if (FrsFragment.this.iSU && FrsFragment.this.iTr.ui(49)) {
                FrsFragment.this.iSU = false;
            }
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.s
        public void c(com.baidu.tieba.tbadkCore.m mVar) {
            if ((mVar != null && ("normal_page".equals(FrsFragment.this.iTp.getPageType()) || "frs_page".equals(FrsFragment.this.iTp.getPageType()) || "book_page".equals(FrsFragment.this.iTp.getPageType()))) || "brand_page".equals(FrsFragment.this.iTp.getPageType())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE, mVar));
                FrsFragment.this.b(mVar);
                FrsFragment.iTb = mVar;
            }
        }

        @Override // com.baidu.tieba.tbadkCore.s
        public void cCt() {
            FrsFragment.this.cCt();
        }
    };
    private final CustomMessageListener iUC = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.frs.FrsFragment.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.n) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                FrsFragment.this.iSv.updateCurrentUserPendant((com.baidu.tbadk.data.n) customResponsedMessage.getData());
                FrsFragment.this.iSX.cDF().notifyDataSetChanged();
            }
        }
    };
    private final CustomMessageListener mMemListener = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_MEM) { // from class: com.baidu.tieba.frs.FrsFragment.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && FrsFragment.this.iSv != null && (userData = FrsFragment.this.iSv.getUserData()) != null) {
                userData.setIsMem(num.intValue());
                if (num.intValue() != 0) {
                    FrsFragment.this.iTq.o(num);
                }
            }
        }
    };
    private final f.a iUD = new AnonymousClass29();
    private final com.baidu.tieba.frs.mc.k iUE = new com.baidu.tieba.frs.mc.k() { // from class: com.baidu.tieba.frs.FrsFragment.30
        @Override // com.baidu.tieba.frs.mc.k
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, boolean z3) {
            if (FrsFragment.this.iTt != null && FrsFragment.this.iTp != null && FrsFragment.this.iTp.cJo() && z && !z2 && !z3) {
                FrsFragment.this.iTt.Bp(i2);
            }
        }
    };
    public final View.OnTouchListener fGd = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.FrsFragment.31
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (FrsFragment.this.iTH != null) {
                FrsFragment.this.iTH.onTouch(view, motionEvent);
            }
            if (FrsFragment.this.iTv != null && FrsFragment.this.iTv.cEs() != null) {
                FrsFragment.this.iTv.cEs().onTouchEvent(motionEvent);
            }
            if (FrsFragment.this.gLR != null) {
                FrsFragment.this.gLR.b(view, motionEvent);
            }
            if (FrsFragment.this.iTq != null) {
                FrsFragment.this.iTq.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private final CustomMessageListener iUF = new CustomMessageListener(CmdConfigCustom.CMD_GOTOLIVE_HOST_UPGRADE) { // from class: com.baidu.tieba.frs.FrsFragment.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.bsO().getInt(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.PHOTOLIVE_HOSTLEVEL, -1) != -1 && FrsFragment.this.iSv.getForum() != null) {
                FrsFragment.this.iSv.getForum().setCanAddPhotoLivePost(true);
            }
        }
    };
    public final View.OnClickListener iUG = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.39
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsFragment.this.iSX != null && view == FrsFragment.this.iSX.cDq() && FrsFragment.this.getActivity() != null) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, FrsFragment.this.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            if (view.getId() == R.id.game_activity_egg_layout && com.baidu.adp.lib.util.l.isNetOk()) {
                TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_CLICK);
                if (FrsFragment.this.iSX == null || !FrsFragment.this.iSX.cDC()) {
                    String activityUrl = FrsFragment.this.iSv.getForum().getYuleData().brn().getActivityUrl();
                    if (!StringUtils.isNull(activityUrl)) {
                        com.baidu.tbadk.browser.a.startInternalWebActivity(FrsFragment.this.getPageContext().getPageActivity(), activityUrl);
                    }
                } else {
                    FrsFragment.this.iSX.cDD();
                }
            }
            if (FrsFragment.this.iSX != null && view == FrsFragment.this.iSX.cDI() && FrsFragment.this.iTp != null && FrsFragment.this.iTp.hasMore()) {
                FrsFragment.this.iSX.XZ();
                FrsFragment.this.bRN();
            }
            if (view != null && FrsFragment.this.iSX != null && view == FrsFragment.this.iSX.cDz()) {
                if (bh.checkUpIsLogin(FrsFragment.this.getContext())) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).al("obj_locate", 2));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MessageCenterActivityConfig(FrsFragment.this.getContext())));
                } else {
                    return;
                }
            }
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (FrsFragment.this.iSv != null && FrsFragment.this.iSv.getForum() != null) {
                    if (FrsFragment.this.iSX != null && view == FrsFragment.this.iSX.cDx()) {
                        if (FrsFragment.this.iSv != null && FrsFragment.this.iSv.getForum() != null && !StringUtils.isNull(FrsFragment.this.iSv.getForum().getId()) && !StringUtils.isNull(FrsFragment.this.iSv.getForum().getName())) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.KEY_SHARE_CLICK).dY("fid", FrsFragment.this.iSv.getForum().getId()).al("obj_locate", 11));
                            com.baidu.tieba.frs.f.h.a(FrsFragment.this.getPageContext(), FrsFragment.this.iSv, FrsFragment.this.iSv.getForum().getId());
                        } else {
                            return;
                        }
                    }
                    if (FrsFragment.this.iSX != null && view == FrsFragment.this.iSX.cDw()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12402").dY("fid", FrsFragment.this.iSv.getForum().getId()).dY("uid", TbadkCoreApplication.getCurrentAccount()).dY("fname", FrsFragment.this.iSv.getForum().getName()));
                        if (!StringUtils.isNull(FrsFragment.this.iSv.getForum().getName())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PostSearchActivityConfig(FrsFragment.this.getContext(), FrsFragment.this.iSv.getForum().getName(), FrsFragment.this.iSv.getForum().getId())));
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
        private int iVe = 0;
        private int gpP = 0;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsFragment.this.iTU += i2;
            if (FrsFragment.this.iTU >= FrsFragment.this.dOW * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
            if (FrsFragment.this.iTy != null) {
                FrsFragment.this.iTy.cKj();
            }
            this.iVe = 0;
            this.gpP = 0;
            if (recyclerView != null && (recyclerView instanceof BdRecyclerView)) {
                this.iVe = ((BdRecyclerView) recyclerView).getFirstVisiblePosition();
                this.gpP = ((BdRecyclerView) recyclerView).getLastVisiblePosition();
            }
            if (FrsFragment.this.iTJ != null) {
                FrsFragment.this.iTJ.a(recyclerView, this.iVe, this.gpP);
            }
            if (FrsFragment.this.iSv != null && FrsFragment.this.iSX != null && FrsFragment.this.iSX.cDF() != null) {
                FrsFragment.this.iSX.cs(this.iVe, this.gpP);
                if (FrsFragment.this.iTo != null && FrsFragment.this.iTo.tZ() != null) {
                    FrsFragment.this.iTo.tZ().b(FrsFragment.this.iTn);
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (FrsFragment.this.iTq != null) {
                FrsFragment.this.iTq.setScrollState(i);
                if (i == 1) {
                    FrsFragment.this.iTq.cKL();
                }
            }
            if (FrsFragment.this.iTj == null && !FrsFragment.this.cCN()) {
                FrsFragment.this.iTj = new com.baidu.tbadk.n.b();
                FrsFragment.this.iTj.setSubType(1000);
            }
            if (i == 0) {
                if (FrsFragment.this.iTj != null) {
                    FrsFragment.this.iTj.bFe();
                }
                com.baidu.tieba.card.t.csh().oX(true);
                FrsFragment.this.pR(true);
                FrsFragment.this.iSX.cr(this.iVe, this.gpP);
            } else if (FrsFragment.this.iTj != null) {
                FrsFragment.this.iTj.bFd();
            }
            if (FrsFragment.this.iTJ != null) {
                FrsFragment.this.iTJ.onScrollStateChanged(recyclerView, i);
            }
            if (i == 0) {
                com.baidu.tieba.frs.f.k.a(FrsFragment.this.iSX, FrsFragment.this.iSv, FrsFragment.this.getForumId(), false, null);
            }
            if (FrsFragment.this.iTr != null && i == 1) {
                FrsFragment.this.iTr.cLp();
            }
            if (FrsFragment.this.iTo == null) {
                if (FrsFragment.this.iSX.cDj() != null && !FrsFragment.this.iSX.cCL() && FrsFragment.this.iSX.cDj().dBP() != null && (FrsFragment.this.iSX.cDj().dBP().getTag() instanceof com.baidu.card.am)) {
                    FrsFragment.this.iTo = (com.baidu.card.am) FrsFragment.this.iSX.cDj().dBP().getTag();
                }
            } else if (i == 0 && FrsFragment.this.iSX.cDj() != null && !FrsFragment.this.iSX.cCL() && FrsFragment.this.iSX.cDj().dBP() != null && (FrsFragment.this.iSX.cDj().dBP().getTag() instanceof com.baidu.card.am)) {
                FrsFragment.this.iTo = (com.baidu.card.am) FrsFragment.this.iSX.cDj().dBP().getTag();
            }
            if (i == 1) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921418));
            }
        }
    };
    private final f iUH = new f() { // from class: com.baidu.tieba.frs.FrsFragment.41
        @Override // com.baidu.tieba.frs.f
        public void a(int i, int i2, View view, View view2, by byVar) {
            if (i != FrsFragment.this.iSX.cDF().cGa()) {
                if (i != FrsFragment.this.iSX.cDF().cGb()) {
                    if (i == FrsFragment.this.iSX.cDF().cFY() && FrsFragment.this.iSv != null && FrsFragment.this.iSv.getUserData() != null && FrsFragment.this.iSv.getUserData().isBawu()) {
                        String bawuCenterUrl = FrsFragment.this.iSv.getBawuCenterUrl();
                        if (!com.baidu.tbadk.core.util.au.isEmpty(bawuCenterUrl) && FrsFragment.this.iSv.getForum() != null) {
                            com.baidu.tbadk.browser.a.startWebActivity(FrsFragment.this.getPageContext().getPageActivity(), bawuCenterUrl);
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10502").dY("fid", FrsFragment.this.iSv.getForum().getId()).dY("uid", FrsFragment.this.iSv.getUserData().getUserId()));
                        }
                    }
                } else if (bh.checkUpIsLogin(FrsFragment.this.getPageContext().getPageActivity())) {
                    TiebaStatic.log(CommonStatisticKey.MY_SERVICE_CK);
                    if (FrsFragment.this.iSv != null && FrsFragment.this.iSv.getForum() != null) {
                        ForumData forum = FrsFragment.this.iSv.getForum();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(forum.getId(), 0L), forum.getName(), forum.getImage_url(), 0)));
                    }
                }
            } else if (bh.checkUpIsLogin(FrsFragment.this.getActivity())) {
                TiebaStatic.log("forum_fortune_click");
                com.baidu.tieba.frs.f.l.c(FrsFragment.this.getPageContext(), FrsFragment.this.iSv);
            }
        }
    };
    private final NoNetworkView.a iQh = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.FrsFragment.42
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (FrsFragment.this.iTp.cJe() == 1 && z && !FrsFragment.this.iSX.cCL()) {
                if (FrsFragment.this.iSv == null || com.baidu.tbadk.core.util.y.isEmpty(FrsFragment.this.iSv.getThreadList())) {
                    FrsFragment.this.hideNetRefreshView(FrsFragment.this.iSX.cDT().cLe());
                    FrsFragment.this.showLoadingView(FrsFragment.this.iSX.cno(), true);
                    FrsFragment.this.iSX.qb(false);
                    FrsFragment.this.refresh();
                    return;
                }
                FrsFragment.this.iSX.cDs();
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
                com.baidu.tieba.frs.f.c.a(customResponsedMessage, FrsFragment.this.iSX, FrsFragment.this.iSv);
            }
        }
    };
    private com.baidu.adp.widget.ListView.ab iUI = new a();
    private au iUJ = new au() { // from class: com.baidu.tieba.frs.FrsFragment.46
        @Override // com.baidu.tieba.frs.au
        public void a(int i, int i2, bd bdVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
            com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.46.1
                @Override // java.lang.Runnable
                public void run() {
                    if (FrsFragment.this.iSX != null && FrsFragment.this.iSX.cDL()) {
                        FrsFragment.this.bRN();
                    }
                }
            });
        }
    };
    private CustomMessageListener iUK = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.frs.FrsFragment.47
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    FrsFragment.this.iTK = true;
                }
            }
        }
    };
    private CustomMessageListener iUL = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.frs.FrsFragment.48
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                    if (FrsFragment.this.iTo == null && FrsFragment.this.iSX.cDj() != null && !FrsFragment.this.iSX.cCL() && FrsFragment.this.iSX.cDj().dBP() != null && (FrsFragment.this.iSX.cDj().dBP().getTag() instanceof com.baidu.card.am)) {
                        FrsFragment.this.iTo = (com.baidu.card.am) FrsFragment.this.iSX.cDj().dBP().getTag();
                    }
                    if (FrsFragment.this.iTo != null && FrsFragment.this.iTo.tZ() != null) {
                        FrsFragment.this.iTo.tZ().b(new a.C0097a(3));
                    }
                }
            }
        }
    };
    private CustomMessageListener iUM = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.FrsFragment.49
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.iSX != null) {
                FrsFragment.this.iSX.HO();
            }
        }
    };
    private CustomMessageListener iUN = new CustomMessageListener(2921437) { // from class: com.baidu.tieba.frs.FrsFragment.50
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && FrsFragment.this.isResumed()) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (FrsFragment.this.iSZ != null) {
                    if (booleanValue) {
                        if (FrsFragment.this.iTr.cLq() != 0 && !FrsFragment.this.iSX.cDQ() && !com.baidu.tbadk.k.d.bDH().bDI()) {
                            FrsFragment.this.iSZ.show();
                            return;
                        }
                        return;
                    }
                    FrsFragment.this.iSZ.hide();
                }
            }
        }
    };
    private CustomMessageListener iUO = new CustomMessageListener(2921462) { // from class: com.baidu.tieba.frs.FrsFragment.55
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && FrsFragment.this.iSv.getToLoadHorseData().intValue() == 1 && FrsFragment.this.mIsLogin) {
                LiveHorseRaceRequestMessage liveHorseRaceRequestMessage = new LiveHorseRaceRequestMessage();
                liveHorseRaceRequestMessage.setForum_id(Long.valueOf(FrsFragment.this.forumId));
                FrsFragment.this.sendMessage(liveHorseRaceRequestMessage);
            }
        }
    };
    private CustomMessageListener iUP = new CustomMessageListener(2001223) { // from class: com.baidu.tieba.frs.FrsFragment.57
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Date)) {
                FrsFragment.this.iTT = (Date) customResponsedMessage.getData();
            }
        }
    };
    private CustomMessageListener iUQ = new CustomMessageListener(2921469) { // from class: com.baidu.tieba.frs.FrsFragment.58
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.y) && FrsFragment.this.isResumed()) {
                com.baidu.tbadk.core.data.y yVar = (com.baidu.tbadk.core.data.y) customResponsedMessage.getData();
                if (FrsFragment.this.iUa == null) {
                    FrsFragment.this.iUa = new com.baidu.tieba.frs.broadcast.a(FrsFragment.this.getPageContext());
                }
                if (FrsFragment.this.iSv != null && FrsFragment.this.iSv.getForum() != null && !TextUtils.isEmpty(FrsFragment.this.iSv.getForum().getId())) {
                    FrsFragment.this.iUa.e(yVar.type, FrsFragment.this.iSv.getForum().getId(), FrsFragment.this.iSv.getForum().getName(), yVar.tid);
                }
            }
        }
    };
    private CustomMessageListener iUR = new CustomMessageListener(2921475) { // from class: com.baidu.tieba.frs.FrsFragment.59
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            by byVar = (by) customResponsedMessage.getData();
            if (byVar != null && FrsFragment.this.isResumed()) {
                FrsFragment.this.iTm = byVar.getTid() + "";
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE_NUMBER);
                httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
                httpMessage.addParam("forum_id", byVar.getFid());
                MessageManager.getInstance().sendMessage(httpMessage);
            }
        }
    };
    private HttpMessageListener iUS = new HttpMessageListener(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE_NUMBER) { // from class: com.baidu.tieba.frs.FrsFragment.60
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
                            hashMap.put("_forumId", FrsFragment.this.iSv.getForum().getId());
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new com.baidu.tieba.tbadkCore.data.m(FrsFragment.this.getContext(), "ForumGradePage", hashMap)));
                        }
                    }).aF((ViewGroup) FrsFragment.this.mRootView.findViewById(R.id.frs));
                    return;
                }
                com.baidu.tbadk.core.util.o oVar = new com.baidu.tbadk.core.util.o(TbadkCoreApplication.getInst());
                oVar.al(FrsFragment.this.iSv.getForum().getId(), FrsFragment.this.iSv.getForum().getName(), "6");
                oVar.BQ(FrsFragment.this.iTm);
                oVar.start();
            }
        }
    };
    private CustomMessageListener iUT = new CustomMessageListener(2921515) { // from class: com.baidu.tieba.frs.FrsFragment.61
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                com.baidu.tieba.NEGFeedBack.g gVar = (com.baidu.tieba.NEGFeedBack.g) customResponsedMessage.getData();
                if (FrsFragment.this.iSv == null || FrsFragment.this.iSv.getForum() == null || FrsFragment.this.iSv.getForum().getDeletedReasonInfo() == null) {
                    com.baidu.tieba.NEGFeedBack.d.a(0, FrsFragment.this.getPageContext(), gVar, null, FrsFragment.this.iSv.getUserData());
                    return;
                }
                com.baidu.tieba.NEGFeedBack.h hVar = new com.baidu.tieba.NEGFeedBack.h(FrsFragment.this.iSv.getForum().getDeletedReasonInfo().is_grays_cale_forum.intValue(), FrsFragment.this.iSv.getForum().getDeletedReasonInfo().is_boomgrow.intValue(), FrsFragment.this.iSv.forumRule != null ? FrsFragment.this.iSv.forumRule.has_forum_rule.intValue() : 0);
                hVar.ek(FrsFragment.this.iSv.getForum().getId(), FrsFragment.this.iSv.getForum().getName());
                hVar.setForumHeadUrl(FrsFragment.this.iSv.getForum().getImage_url());
                hVar.setUserLevel(FrsFragment.this.iSv.getForum().getUser_level());
                com.baidu.tieba.NEGFeedBack.d.a(hVar.bLA(), FrsFragment.this.getPageContext(), gVar, hVar, FrsFragment.this.iSv.getUserData());
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.frs.loadmore.a
    public /* bridge */ /* synthetic */ com.baidu.adp.base.e getPageContext() {
        return super.getPageContext();
    }

    public com.baidu.tieba.frs.entelechy.b.b cBW() {
        return this.iTx;
    }

    public com.baidu.adp.widget.ListView.ab cBX() {
        return this.iUI;
    }

    public com.baidu.tieba.frs.mc.d cBY() {
        return this.iTz;
    }

    public com.baidu.tieba.frs.smartsort.a cBZ() {
        return this.iTt;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public FrsModelController cCa() {
        return this.iTp;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public com.baidu.tieba.frs.mc.c cCb() {
        return this.iTA;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public com.baidu.tieba.frs.vc.h cCc() {
        return this.iTq;
    }

    public FrsTabViewController cCd() {
        return this.iTr;
    }

    public aw cCe() {
        return this.iTv;
    }

    public void pQ(boolean z) {
        this.iTS = z;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public q cCf() {
        return this.iSX;
    }

    @Override // com.baidu.tieba.frs.av
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.av, com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.iSP;
    }

    public void setForumName(String str) {
        this.iSP = str;
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
        if (this.iTA == null) {
            return 1;
        }
        return this.iTA.getPn();
    }

    public int getPn() {
        if (this.iTA == null) {
            return 1;
        }
        return this.iTA.getPn();
    }

    public void setPn(int i) {
        if (this.iTA != null) {
            this.iTA.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.iTA != null) {
            this.iTA.setHasMore(i);
        }
    }

    public int cCg() {
        if (this.iTA == null) {
            return -1;
        }
        return this.iTA.cCg();
    }

    public boolean cCh() {
        return this.iSV;
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
            this.iSX.cDm();
            showNetRefreshView(this.iSX.cno(), string, true);
        } else if (340001 == fVar.errorCode) {
            a(fVar, this.iSv.getRecm_forum_list());
        } else {
            if (com.baidu.tbadk.core.util.y.isEmpty(this.iSv.getThreadList())) {
                b(fVar);
            }
            if (cCN()) {
                setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds280));
            } else {
                setNetRefreshViewEmotionDefMarginTop();
            }
        }
    }

    public void a(View view, String str, boolean z, List<RecmForumInfo> list) {
        this.iSX.cDm();
        this.iSX.zQ(8);
        if (this.iTI == null) {
            this.iTI = new com.baidu.tieba.frs.view.a(getPageContext(), getNetRefreshListener());
        }
        this.iTI.setSubText(str);
        this.iTI.setListData(list);
        this.iTI.attachView(view, z);
    }

    private void a(com.baidu.tieba.tbadkCore.f fVar, List<RecmForumInfo> list) {
        if (this.iSX != null) {
            this.iSX.cDm();
            this.iSX.setTitle(this.iSP);
            a(this.iSX.cno(), fVar.errorMsg, true, list);
        }
    }

    private void b(com.baidu.tieba.tbadkCore.f fVar) {
        this.iSX.cDm();
        if (fVar.iCW) {
            showNetRefreshView(this.iSX.cno(), TbadkCoreApplication.getInst().getString(R.string.net_error_text, new Object[]{fVar.errorMsg, Integer.valueOf(fVar.errorCode)}), true);
        } else {
            showNetRefreshView(this.iSX.cDT().cLe(), fVar.errorMsg, true);
        }
    }

    public void cCi() {
        hideLoadingView(this.iSX.cno());
        this.iSX.bSm();
        if (this.iSX.cDk() instanceof com.baidu.tieba.frs.tab.c) {
            ((com.baidu.tieba.frs.tab.c) this.iSX.cDk()).cJM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCj() {
        if (cCg() == 0 && com.baidu.tbadk.core.util.y.isEmpty(this.iSv.getThreadListIds())) {
            if (com.baidu.tbadk.core.util.y.isEmpty(this.iSv.getThreadList())) {
                this.iSX.bTb();
            } else {
                this.iSX.Ya();
            }
        } else if (com.baidu.tbadk.core.util.y.getCount(this.iSv.getThreadList()) > 3) {
            this.iSX.XZ();
        } else {
            this.iSX.cDH();
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
            cCi();
            this.iSX.cDs();
            com.baidu.tieba.tbadkCore.f cJa = this.iTp.cJa();
            boolean isEmpty = com.baidu.tbadk.core.util.y.isEmpty(this.iSv.getThreadList());
            if (cJa != null && isEmpty) {
                if (this.iTp.cJc() != 0) {
                    this.iTp.cJh();
                    this.iSX.cDs();
                } else {
                    a(cJa);
                }
                this.iSX.Y(this.iSv.isStarForum(), false);
                return;
            }
            a(cJa);
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

    public boolean cCk() {
        return cCl() && !cCm();
    }

    private boolean cCl() {
        if (cCK() == null) {
            return false;
        }
        FrsViewData cCK = cCK();
        com.baidu.tbadk.core.data.z zVar = null;
        if (cCK.getStar() != null && !StringUtils.isNull(cCK.getStar().dOu())) {
            zVar = new com.baidu.tbadk.core.data.z();
        } else if (cCK.getActivityHeadData() != null && com.baidu.tbadk.core.util.y.getCount(cCK.getActivityHeadData().bmT()) >= 1) {
            zVar = cCK.getActivityHeadData().bmT().get(0);
        }
        return zVar != null;
    }

    public boolean cCm() {
        if (cCK() == null) {
            return false;
        }
        FrsViewData cCK = cCK();
        return (com.baidu.tbadk.core.util.y.isEmpty(cCK.getShowTopThreadList()) && cCK.getBusinessPromot() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCn() {
        boolean b;
        if (!cCp()) {
            final PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
            privateForumPopInfoData.a(this.iSv.getPrivateForumTotalInfo().getPrivatePopInfo());
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(getActivity());
            if (this.iSv.getPrivateForumTotalInfo().bnM().private_forum_status.intValue() == 1 && (com.baidu.tbadk.core.util.au.isEmpty(privateForumPopInfoData.bnO()) || privateForumPopInfoData.bnR() != Integer.valueOf(this.forumId))) {
                privateForumPopInfoData.AT("create_success");
                privateForumPopInfoData.AU(TbadkCoreApplication.getInst().getString(R.string.frs_private_create_hint));
                privateForumPopInfoData.AV("https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.iSP + "&nomenu=1");
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
    public void cCo() {
        if (cCp() || this.iSv.getPrivateForumTotalInfo().bnM().private_forum_status.intValue() != 1) {
            a((Integer) null, (Integer) null, true);
        } else {
            a(this.iSv.getPrivateForumTotalInfo().bnM().private_forum_audit_status, this.iSv.getPrivateForumTotalInfo().bnN(), false);
        }
    }

    public void a(Integer num, Integer num2, boolean z) {
        final String str;
        final int i = 2;
        if (this.iSX.cDy() != null) {
            TextView cDy = this.iSX.cDy();
            if (z) {
                cDy.setVisibility(8);
                return;
            }
            if (num.intValue() == 2) {
                cDy.setText("修改实名认证信息");
                cDy.setVisibility(0);
                str = "https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + this.forumId + "&nomenu=1";
            } else if (num2.intValue() >= 0 && num2.intValue() <= 100) {
                cDy.setText("目标已完成" + String.valueOf(num2) + "%");
                cDy.setVisibility(0);
                str = "https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.iSP + "&nomenu=1";
                i = 1;
            } else {
                cDy.setVisibility(8);
                i = 0;
                str = "";
            }
            cDy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.21
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

    private boolean cCp() {
        return this.iSv == null || this.iSv.getPrivateForumTotalInfo() == null || this.iSv.getPrivateForumTotalInfo().bnM() == null || this.iSv.getUserData().getIs_manager() != 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zF(int i) {
        List<WindowToast> list;
        if (TbadkCoreApplication.isLogin() && this.iSv != null && (list = this.iSv.mWindowToast) != null && list.size() > 0) {
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
    public void cCq() {
        if (getActivity() != null && getActivity().getIntent() != null) {
            String stringExtra = getActivity().getIntent().getStringExtra(FrsActivityConfig.KEY_ACHIEVEMENT_URL);
            if (!TextUtils.isEmpty(stringExtra)) {
                getActivity().getIntent().removeExtra(FrsActivityConfig.KEY_ACHIEVEMENT_URL);
                AchievementActivityConfig achievementActivityConfig = new AchievementActivityConfig(getActivity());
                achievementActivityConfig.setUrl(stringExtra);
                if (this.iSv != null && this.iSv.getForumActiveInfo() != null) {
                    achievementActivityConfig.setShareUrl(this.iSv.getForumActiveInfo().forum_share_url);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, achievementActivityConfig));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCr() {
        if (this.iSv == null || this.iSv.getForum() != null) {
            this.iSX.cDE();
        } else if (this.iSv.getForum().getYuleData() != null && this.iSv.getForum().getYuleData().brm()) {
            TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_VIEW);
            this.iSX.a(this.iSv.getForum().getYuleData().brn());
        } else {
            this.iSX.cDE();
        }
    }

    private void W(boolean z, boolean z2) {
        if (this.iTp != null && this.iSv != null && this.iSX != null && z) {
            if (!this.iTp.cJo() && this.iTp.cJe() == 1) {
                if (!this.iTp.cJm()) {
                    this.iSv.addCardVideoInfoToThreadList();
                    this.iSv.addVideoInfoToThreadListInTenAndFifteenFloor();
                }
                boolean z3 = false;
                if (this.iSX.cDF().r(com.baidu.tieba.card.data.n.inG)) {
                    z3 = this.iSv.addHotTopicDataToThreadList();
                }
                if (!z3) {
                    this.iSv.addFeedForumDataToThreadList();
                }
                if (TbadkCoreApplication.getInst().isRecAppExist()) {
                    this.iSv.addRecommendAppToThreadList(this);
                }
                if (!this.iSX.cDF().r(by.eJr)) {
                    this.iSv.removeAlaLiveThreadData();
                }
                this.iSv.addSchoolRecommendToThreadList();
            }
            if (!this.iSX.cDF().r(by.eJr)) {
                this.iSv.removeAlaInsertLiveData();
                this.iSv.removeAlaStageLiveDat();
            } else {
                this.iSv.addInsertLiveDataToThreadList();
                this.iSv.addStageLiveDataToThreadList();
            }
            this.iSv.checkLiveStageInThreadList();
            this.iSv.addNoticeThreadToThreadList();
            if (this.iSX.cDF().r(com.baidu.tieba.i.b.jDN)) {
                this.iSv.addGameRankListToThreadList(z2);
            }
            if (TbadkCoreApplication.isLogin() && (!this.iTp.cJo() || this.iTp.isNetFirstLoad)) {
                this.iSv.addUserRecommendToThreadList();
            }
            this.iSv.addVideoActivityToTop();
        }
    }

    public boolean cCs() {
        if (this.iTq != null && this.iTp != null) {
            this.iTq.a(this.iTp.getPageType(), this.iSv);
        }
        boolean z = false;
        if (this.iSv != null) {
            z = this.iSv.hasTab();
        }
        cCv();
        if (this.iSX != null) {
            this.iSX.cDR();
            this.iSX.cDS();
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zG(int i) {
        ba baVar = null;
        cCs();
        cCF();
        try {
            if (this.iSv != null) {
                this.iSX.a((ArrayList<com.baidu.adp.widget.ListView.q>) null, this.iSv);
                this.iTq.BI(1);
                this.iSX.cDv();
                this.iTr.a(this.iSv, this.iTp.cJj());
                com.baidu.tieba.frs.tab.d BR = this.iTr.BR(this.iSv.getFrsDefaultTabId());
                if (BR != null && !TextUtils.isEmpty(BR.url)) {
                    baVar = new ba();
                    baVar.ext = BR.url;
                    baVar.stType = BR.name;
                }
                this.iTp.a(this.iSv.getFrsDefaultTabId(), 0, baVar);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(boolean z, boolean z2) {
        try {
            if (this.iSv != null && this.iTr != null && this.iTp != null) {
                if (!this.iSX.cDF().r(by.eJr)) {
                    this.iSv.removeAlaLiveThreadData();
                }
                boolean isEmpty = com.baidu.tbadk.core.util.y.isEmpty(this.iSv.getGameTabInfo());
                this.iSX.pZ(isEmpty);
                if (!isEmpty) {
                    if (this.iTJ == null) {
                        this.iTJ = new com.baidu.tieba.frs.vc.e(this, (NoPressedRelativeLayout) this.mRootView);
                    }
                    if (this.gLR == null) {
                        this.gLR = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
                    }
                } else {
                    this.iTJ = null;
                    this.gLR = null;
                }
                if (this.iSv.getForum() != null) {
                    this.iSP = this.iSv.getForum().getName();
                    this.forumId = this.iSv.getForum().getId();
                }
                if (this.iSv.hasTab()) {
                    this.iTr.a(this.iSv, this.iTp.cJj());
                }
                if (z) {
                    W(true, z);
                } else {
                    W(this.iTk, z);
                }
                cCs();
                if (this.iTx != null) {
                    this.iTx.a(this.iTq, this.iSv);
                }
                if (this.iSv.getPage() != null) {
                    setHasMore(this.iSv.getPage().bnF());
                }
                ArrayList<com.baidu.adp.widget.ListView.q> a2 = this.iTA.a(z2, true, this.iSv.getThreadList(), null, z, false);
                if (a2 != null) {
                    this.iSv.setThreadList(a2);
                }
                this.iSv.removeRedundantUserRecommendData();
                this.iSx = this.iSv.getTopThreadSize();
                if (this.iST != null) {
                    this.iSS = true;
                    this.iST.KR(this.iSx);
                    com.baidu.tieba.frs.f.a.a(this, this.iSv.getForum(), this.iSv.getThreadList(), this.iSS, getPn());
                }
                if (this.iTp.cJe() == 1) {
                    cCz();
                    if (!z && this.iTp.getPn() == 1) {
                        cCu();
                    }
                }
                if (this.iTy != null) {
                    this.iTy.cT(this.iTr.cLm());
                }
                cCi();
                this.iSX.cDn();
                this.iSX.Y(true, false);
                if (z && this.iSv.isFirstTabEqualAllThread()) {
                    com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.22
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!FrsFragment.this.iTi && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                FrsFragment.this.iSX.cDP();
                            }
                        }
                    });
                }
                if (this.iSv.getForum() != null) {
                    this.iSX.KJ(this.iSv.getForum().getWarningMsg());
                }
                if (this.iSv != null && this.iSv.getFrsVideoActivityData() != null && com.baidu.tbadk.core.sharedPref.b.bsO().getLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 0L) == 0) {
                    com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.24
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsFragment.this.iSX.cDN();
                        }
                    }, 1000L);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FRS_SHOW_AR_ENTRY, this));
                this.iSX.cDh();
                if (this.iSv != null && this.iSv.getForum() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ENTER_FORUM, new VisitedForumData(this.iSv.getForum().getId(), this.iSv.getForum().getName(), this.iSv.getForum().getImage_url(), String.valueOf(System.currentTimeMillis() / 1000), ConstantData.Forum.SPECAIL_FORUM_TYPE_LIVE.equals(this.iSv.getForum().special_forum_type), this.iSv.getForum().getThemeColorInfo(), this.iSv.getForum().getMember_num())));
                }
                this.iTN.a(this.iSv.bottomMenuList, this.iSv.getForum());
                cCU();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void cCt() {
        if (this.iTp != null && this.iTp.cJe() == 1) {
            this.iTq.k(this.iSv);
        }
    }

    public void pR(boolean z) {
        com.baidu.tieba.t.c.dOf().b(getUniqueId(), z);
    }

    public void cCu() {
        if (this.iTD == null) {
            this.iTD = new com.baidu.tieba.frs.live.a(this, com.baidu.adp.lib.f.b.toInt(this.forumId, 0));
        }
        this.iTD.cIL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.tbadkCore.m mVar) {
        try {
            if (!this.iTi && mVar != null && this.iSv != null) {
                this.iSv.receiveData(mVar);
                X(true, false);
                Looper.myQueue().addIdleHandler(this.iUd);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void cCv() {
        if (this.iTp != null) {
            KH(this.iTp.getPageType());
        } else {
            KH("normal_page");
        }
    }

    private void KH(String str) {
        pS("frs_page".equals(str));
        if (this.iTx != null) {
            this.iTx.a(this.iTq, this.iSX, this.iSv);
        }
    }

    public void pS(boolean z) {
        if (this.iTB != null) {
            this.iTB.cKY();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.t.c.dOf().z(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.frs_activity, viewGroup, false);
            this.iSJ = new com.baidu.tieba.frs.entelechy.a();
            this.iTx = this.iSJ.cFA();
            this.iSI = TbadkCoreApplication.getInst().getString(R.string.frs_title_new_area);
            this.iTq = new com.baidu.tieba.frs.vc.h(this, this.iSJ, (FrsHeaderViewContainer) this.mRootView.findViewById(R.id.header_view_container));
            this.iTr = new FrsTabViewController(this, this.mRootView);
            this.iTr.registerListener();
            this.iTq.a(this.iTr);
            this.iTr.a(this.iUl);
            Intent intent = getActivity().getIntent();
            if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                this.iSL = true;
            }
            this.iSX = new q(this, this.iUG, this.iSJ, this.iSL, this.iTq);
            this.iTN = new com.baidu.tieba.frs.brand.buttommenu.a(getPageContext(), this.mRootView);
        } else {
            if (this.mRootView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            if (this.iTr != null) {
                this.iTr.registerListener();
            }
            this.iSX.cDM();
            this.mRootView.setLeft(0);
            this.mRootView.setRight(com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getContext()));
        }
        this.iTR = true;
        this.fCc = System.currentTimeMillis() - currentTimeMillis;
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        ArrayList<com.baidu.adp.widget.ListView.q> arrayList = null;
        this.ivA = System.currentTimeMillis();
        long j = this.ivA;
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.iSU = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.ivA = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            R(intent);
        }
        this.fCb = j - this.ivA;
        this.iST = new com.baidu.tieba.tbadkCore.data.f("frs", com.baidu.tieba.tbadkCore.data.f.nli);
        if (this.iTp == null) {
            this.iTp = new FrsModelController(this, this.iUB);
            this.iTp.a(this.iUk);
            this.iTp.init();
        }
        this.iTp.setSchemeUrl(this.mSchemeUrl);
        if (intent != null) {
            this.iTp.aj(intent.getExtras());
        } else if (bundle != null) {
            this.iTp.aj(bundle);
        } else {
            this.iTp.aj(null);
        }
        if (intent != null) {
            this.iTq.as(intent.getExtras());
        } else if (bundle != null) {
            this.iTq.as(bundle);
        } else {
            this.iTq.as(null);
        }
        this.iSW = getVoiceManager();
        this.iTE = new p(getPageContext(), this);
        initUI();
        initData(bundle);
        if (!cCN()) {
            this.iTv = new aw(getActivity(), this.iSX, this.iTq);
            this.iTv.qo(true);
        }
        this.iSW = getVoiceManager();
        if (this.iSW != null) {
            this.iSW.onCreate(getPageContext());
        }
        if (FrsActivityConfig.FRS_FROM_FLUTTER_BCASTEDIT.equals(getFrom()) && !this.hasInit) {
            int i = com.baidu.tbadk.core.sharedPref.b.bsO().getInt("key_forum_broadcast_edit_tip_number", 0);
            if (i < 2) {
                com.baidu.tbadk.core.sharedPref.b.bsO().putInt("key_forum_broadcast_edit_tip_number", i + 1);
                cCB();
            } else if (Build.VERSION.SDK_INT >= 23) {
                if (Settings.canDrawOverlays(getContext())) {
                    cCC();
                } else {
                    new BdTopToast(getContext()).yW(false).Vt(getContext().getString(R.string.forum_broadcast_copy_no_permission_hint)).aF(this.iSX.cno());
                }
            } else {
                cCC();
            }
        }
        if (FrsActivityConfig.FRS_FROM_FORUM_RULE_EDIT.equals(getFrom()) && !this.hasInit) {
            if (Build.VERSION.SDK_INT >= 23) {
                if (Settings.canDrawOverlays(getContext())) {
                    cCD();
                } else if (Build.VERSION.SDK_INT < 23 || !com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean("key_forum_rule_dialog_show_frs", false)) {
                    cCD();
                    com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean("key_forum_rule_dialog_show_frs", true);
                }
            } else {
                cCD();
            }
        }
        if (com.baidu.tbadk.k.d.bDH().bDI()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
            if (this.iSY != null) {
                this.iSY.setVisibility(8);
            }
        }
        new com.baidu.tieba.frs.mc.i();
        int i2 = -1;
        if (this.iTA != null && this.iTA.cIW() != null) {
            i2 = this.iTA.cIW().cCg();
            arrayList = this.iTA.cIW().getDataList();
        }
        this.iTA = new com.baidu.tieba.frs.mc.c(this, this.iUE);
        this.iTA.cIW().setHasMore(i2);
        if (arrayList != null && arrayList.size() > 0) {
            this.iTA.cIW().aI(arrayList);
        }
        this.iTt = new com.baidu.tieba.frs.smartsort.a(this);
        this.iTB = new com.baidu.tieba.frs.vc.j(this);
        this.iTy = new com.baidu.tieba.frs.vc.a(getPageContext(), this.iTp.cJl());
        this.iTu = new com.baidu.tieba.frs.mc.b(this);
        this.iTz = new com.baidu.tieba.frs.mc.d(this);
        this.iTs = new com.baidu.tieba.frs.mc.h(this);
        this.iTC = new com.baidu.tieba.frs.mc.a(this);
        this.iTF = new com.baidu.tieba.frs.vc.c(this);
        this.iTG = new com.baidu.tieba.frs.mc.e(this, getUniqueId());
        this.iTL = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "frs");
        this.iTM = new com.baidu.tieba.ala.a(getPageContext());
        this.iTO = new com.baidu.tieba.frs.sportspage.notification.a(getPageContext());
        registerListener(this.iUt);
        registerListener(this.mMemListener);
        registerListener(this.iUr);
        registerListener(this.iUF);
        registerListener(this.iUC);
        registerListener(this.iUn);
        registerListener(this.iUo);
        registerListener(this.iUp);
        registerListener(this.iUq);
        registerListener(this.iUe);
        registerListener(this.iUf);
        registerListener(this.ahC);
        registerListener(this.iUg);
        registerListener(this.iUK);
        registerListener(this.iUv);
        registerListener(this.iUj);
        registerListener(this.iUw);
        registerListener(this.iUu);
        registerListener(this.iUy);
        registerListener(this.iUz);
        registerListener(this.iUA);
        this.iUL.setTag(getPageContext().getUniqueId());
        MessageManager.getInstance().registerListener(this.iUL);
        registerListener(this.iUM);
        registerListener(this.iUN);
        registerListener(this.iUO);
        registerListener(this.iUi);
        registerListener(this.iUP);
        registerListener(this.iUx);
        registerListener(this.iUh);
        registerListener(this.iUQ);
        registerListener(this.iUR);
        registerListener(this.iUS);
        registerListener(this.iUT);
        this.iSX.qb(false);
        if (!cCN() && !this.hasInit) {
            showLoadingView(this.iSX.cno(), true);
            this.iTp.T(3, false);
        }
        ay ayVar = new ay() { // from class: com.baidu.tieba.frs.FrsFragment.27
            @Override // com.baidu.tieba.frs.ay
            public void d(boolean z, boolean z2, int i3) {
                if (FrsFragment.this.iSX != null) {
                    if (i3 == 1) {
                        FrsFragment.this.iSX.zR(z ? 0 : 8);
                    } else if (i3 == 2) {
                        FrsFragment.this.iSX.zT(z ? 0 : 8);
                    }
                    if (!z2) {
                        FrsFragment.this.iTQ = z;
                    }
                    if (FrsFragment.this.iSX.cDF() != null && (i3 == 2 || (FrsFragment.this.iTp != null && FrsFragment.this.iTp.cJf()))) {
                        FrsFragment.this.iSX.cDF().notifyDataSetChanged();
                    }
                    if (FrsFragment.this.cCd() != null) {
                        FrsTabViewController.b cLn = FrsFragment.this.cCd().cLn();
                        if (cLn != null) {
                            if ((cLn.fragment instanceof FrsCommonTabFragment) && (i3 == 2 || cLn.tabId == 502)) {
                                ((FrsCommonTabFragment) cLn.fragment).cFq();
                            } else if ((cLn.fragment instanceof FrsNewAreaFragment) && (i3 == 2 || cLn.tabId == 503)) {
                                FrsNewAreaFragment frsNewAreaFragment = (FrsNewAreaFragment) cLn.fragment;
                                frsNewAreaFragment.cFq();
                                if (frsNewAreaFragment.cJw() != null) {
                                    com.baidu.tieba.frs.mc.g cJw = frsNewAreaFragment.cJw();
                                    cJw.qq(!z);
                                    if (i3 == 1) {
                                        cJw.qe(!z);
                                    } else if (i3 == 2) {
                                        cJw.qe(true);
                                    }
                                }
                            } else if (cLn.fragment instanceof FrsGoodFragment) {
                                ((FrsGoodFragment) cLn.fragment).cFq();
                            }
                        }
                        if (FrsFragment.this.cCd().cLf() != null) {
                            FrsFragment.this.cCd().cLf().setmDisallowSlip(z);
                            FrsFragment.this.cCd().qZ(z);
                        }
                    }
                    if (FrsFragment.this.iSX.cDl() != null) {
                        FrsFragment.this.iSX.pY(!z);
                    }
                    if (FrsFragment.this.getActivity() instanceof FrsActivity) {
                        ((FrsActivity) FrsFragment.this.getActivity()).pP(!z);
                    }
                    if (FrsFragment.this.iTN != null) {
                        FrsFragment.this.iTN.qw(!z);
                    }
                    FrsFragment.this.iSX.qd(!z);
                    if (i3 == 1) {
                        FrsFragment.this.iSX.qe(z ? false : true);
                    } else if (i3 == 2) {
                        FrsFragment.this.iSX.qe(true);
                    }
                }
            }

            @Override // com.baidu.tieba.frs.ay
            public void cq(int i3, int i4) {
                if (FrsFragment.this.iSX != null) {
                    if (i4 == 1) {
                        FrsFragment.this.iSX.zS(i3);
                    } else if (i4 == 2) {
                        FrsFragment.this.iSX.zU(i3);
                    }
                }
            }

            @Override // com.baidu.tieba.frs.ay
            public void zK(int i3) {
                if (FrsFragment.this.getContext() != null) {
                    if (i3 == 1) {
                        com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getContext(), R.string.frs_multi_delete_max_num);
                    } else if (i3 == 2 && FrsFragment.this.iSX != null) {
                        new BdTopToast(FrsFragment.this.getContext()).yW(false).Vt(FrsFragment.this.getContext().getString(R.string.frs_move_area_max_num)).aF(FrsFragment.this.iSX.cno());
                    }
                }
            }
        };
        b.cBe().a(ayVar);
        com.baidu.tieba.frs.a.cAX().a(ayVar);
        this.iSX.b(new e.a() { // from class: com.baidu.tieba.frs.FrsFragment.28
            @Override // com.baidu.tieba.NEGFeedBack.e.a
            public void a(DeleteThreadHttpResponseMessage deleteThreadHttpResponseMessage) {
                boolean z;
                int i3 = 0;
                if (deleteThreadHttpResponseMessage != null) {
                    FrsFragment.this.iSX.bLq();
                    FrsFragment.this.iSX.cDO();
                    FrsNewAreaFragment frsNewAreaFragment = null;
                    if (FrsFragment.this.iTr == null || FrsFragment.this.iTr.cLn() == null || !(FrsFragment.this.iTr.cLn().fragment instanceof FrsNewAreaFragment)) {
                        z = false;
                    } else {
                        frsNewAreaFragment = (FrsNewAreaFragment) FrsFragment.this.iTr.cLn().fragment;
                        z = true;
                    }
                    if (deleteThreadHttpResponseMessage.getError() == 0) {
                        String text = !TextUtils.isEmpty(deleteThreadHttpResponseMessage.getText()) ? deleteThreadHttpResponseMessage.getText() : FrsFragment.this.getString(R.string.delete_fail);
                        if (deleteThreadHttpResponseMessage.getRetType() == 1211066) {
                            if (FrsFragment.this.ilQ == null) {
                                FrsFragment.this.ilQ = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.ilQ.Bq(text);
                            FrsFragment.this.ilQ.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.28.1
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.ilQ.jm(false);
                            FrsFragment.this.ilQ.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.ilQ.brv();
                        } else if (deleteThreadHttpResponseMessage.getRetType() == 1211067) {
                            if (FrsFragment.this.ilQ == null) {
                                FrsFragment.this.ilQ = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.ilQ.Bq(text);
                            FrsFragment.this.ilQ.a(R.string.know, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.28.2
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.ilQ.jm(false);
                            FrsFragment.this.ilQ.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.ilQ.brv();
                        } else {
                            FrsFragment.this.iSX.aP(deleteThreadHttpResponseMessage.getText(), ContextCompat.getColor(FrsFragment.this.getContext(), deleteThreadHttpResponseMessage.getRetType() == 1 ? R.color.nav_bar_tip_error : R.color.cp_link_tip_a_alpha95));
                        }
                        if (z && frsNewAreaFragment != null) {
                            frsNewAreaFragment.dy(deleteThreadHttpResponseMessage.getSuccessItems());
                        }
                        FrsFragment.this.dh(deleteThreadHttpResponseMessage.getSuccessItems());
                        b.cBe().dg(deleteThreadHttpResponseMessage.getSuccessItems());
                        for (com.baidu.adp.widget.ListView.q qVar : FrsFragment.this.iSv.getThreadList()) {
                            if (qVar instanceof bx) {
                                i3++;
                                continue;
                            }
                            if (i3 >= 6) {
                                break;
                            }
                        }
                        if (i3 < 6) {
                            FrsFragment.this.bRN();
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
        if (this.iTr != null) {
            this.iTr.jyk = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dh(List<String> list) {
        if (!com.baidu.tbadk.core.util.y.isEmpty(list)) {
            ArrayList<com.baidu.adp.widget.ListView.q> threadList = this.iSv.getThreadList();
            if (!com.baidu.tbadk.core.util.y.isEmpty(threadList) && this.iSX.getListView() != null && this.iSX.getListView().getData() != null) {
                Iterator<com.baidu.adp.widget.ListView.q> it = threadList.iterator();
                List<com.baidu.adp.widget.ListView.q> data = this.iSX.getListView().getData();
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
                                this.iTA.d(next);
                                this.iSX.getListView().getAdapter().notifyItemRemoved(i);
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
    public void cBc() {
        if (!com.baidu.tbadk.core.util.y.isEmpty(com.baidu.tieba.frs.a.cAX().cBb()) && this.iSX.getListView() != null && this.iSX.getListView().getData() != null) {
            ArrayList<com.baidu.adp.widget.ListView.q> threadList = this.iSv.getThreadList();
            if (!com.baidu.tbadk.core.util.y.isEmpty(threadList)) {
                Iterator<com.baidu.adp.widget.ListView.q> it = threadList.iterator();
                List<com.baidu.adp.widget.ListView.q> data = this.iSX.getListView().getData();
                int count = com.baidu.tbadk.core.util.y.getCount(com.baidu.tieba.frs.a.cAX().cBb());
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.q next = it.next();
                    if (next instanceof bx) {
                        by byVar = ((bx) next).eCR;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= count) {
                                break;
                            } else if (!com.baidu.tbadk.core.util.au.equals(com.baidu.tieba.frs.a.cAX().cBb().get(i2).getId(), byVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.iTA.d(next);
                                this.iSX.getListView().getAdapter().notifyItemRemoved(i);
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
    public void bSh() {
        if (isAdded() && this.gtZ && !isLoadingViewAttached()) {
            showLoadingView(this.iSX.cno(), true);
        }
    }

    @Override // com.baidu.tieba.frs.ap
    public void bSi() {
        if (isAdded() && this.gtZ && isLoadingViewAttached()) {
            hideLoadingView(this.iSX.cno());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (cCN()) {
            showLoadingView(this.iSX.cno(), true);
            this.iSX.zV(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.iTp.S(3, true);
            bvQ().scrollToPosition(0);
        }
    }

    private void zH(int i) {
        String str = "";
        if (this.iSv != null && this.iSv.getForum() != null) {
            str = this.iSv.getForum().getId();
        }
        if (!StringUtils.isNull(str)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13008").dY("fid", str).dY("obj_type", "4").al("obj_locate", i).dY("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    @Override // com.baidu.tieba.frs.ap
    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.z zVar) {
        if (zVar != null) {
            this.fGc = zVar.bGK();
            this.iTH = zVar.bGL();
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
                this.iSP = uri.getQueryParameter("name");
                this.mFrom = uri.getQueryParameter("from");
                if (!StringUtils.isNull(this.iSP)) {
                    intent.putExtra("name", this.iSP);
                }
                if (!StringUtils.isNull(this.mFrom)) {
                    intent.putExtra("from", this.mFrom);
                }
                TiebaStatic.log(TbadkCoreStatisticKey.AS_INVOKE_TIEBA);
            }
            if (StringUtils.isNull(this.iSP) && uri != null) {
                if (com.baidu.tbadk.BdToken.f.p(uri)) {
                    com.baidu.tbadk.BdToken.f.biX().b(uri, this.iUD);
                } else {
                    com.baidu.tieba.frs.f.g U = com.baidu.tieba.frs.f.l.U(intent);
                    if (U != null) {
                        this.iSP = U.forumName;
                        if (U.jvR == null || U.jvR.equals("aidou")) {
                        }
                    }
                }
                if (!StringUtils.isNull(this.iSP)) {
                    intent.putExtra("name", this.iSP);
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
                    FrsFragment.this.iSP = (String) hashMap.get(com.baidu.tbadk.BdToken.f.exb);
                }
                if ((hashMap.get(com.baidu.tbadk.BdToken.f.exu) instanceof String) && !TextUtils.isEmpty((String) hashMap.get(com.baidu.tbadk.BdToken.f.exu))) {
                    com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.29.1
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsFragment.this.iTr.ui(301);
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
        this.iSW = getVoiceManager();
        if (this.iSW != null) {
            this.iSW.onStart(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        Intent intent;
        long j = 0;
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.flC);
        if (bundle != null) {
            this.iSP = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            j = bundle.getLong(FrsActivityConfig.FRS_FAKE_THREAD_ID, 0L);
        } else if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
            this.iSP = intent.getStringExtra("name");
            this.mFrom = intent.getStringExtra("from");
            this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
            j = intent.getLongExtra(FrsActivityConfig.FRS_FAKE_THREAD_ID, 0L);
        }
        if (getArguments() != null) {
            this.iSQ = getArguments().getBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, false);
        }
        if (TextUtils.isEmpty(this.mFrom) || FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
        }
        if (this.mIsLogin) {
            registerListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL, this.flC);
        }
        this.iTq.as(bundle);
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
        com.baidu.tieba.t.c.dOf().A(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.iUK);
        this.iTB.destroy();
        iTb = null;
        if (this.iSW != null) {
            this.iSW.onDestory(getPageContext());
        }
        com.baidu.tieba.recapp.report.a.remove("FRS");
        this.iSW = null;
        com.baidu.tieba.card.t.csh().oX(false);
        if (this.iSv != null && this.iSv.getForum() != null) {
            aj.cEo().gm(com.baidu.adp.lib.f.b.toLong(this.iSv.getForum().getId(), 0L));
        }
        if (this.iTD != null) {
            this.iTD.onDestory();
        }
        if (this.iSX != null) {
            com.baidu.tieba.frs.f.k.a(this.iSX, this.iSv, getForumId(), false, null);
            this.iSX.onDestroy();
        }
        if (this.iTa != null) {
            this.iTa.removeAllViews();
            this.iTa.setVisibility(8);
        }
        if (this.iTX != null) {
            this.iTX.cancel();
        }
        if (this.iTY != null) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.iTY);
        }
        this.iTW = null;
        super.onDestroy();
        try {
            if (this.iTj != null) {
                this.iTj.bFf();
            }
            if (this.iSX != null) {
                this.iSX.release();
            }
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.iTq.cID();
        Looper.myQueue().removeIdleHandler(this.iUd);
        if (this.iTp != null) {
            this.iTp.bYZ();
        }
        if (this.iTv != null) {
            this.iTv.cEw();
        }
        if (this.iTy != null) {
            this.iTy.destory();
        }
        if (this.iTt != null) {
            this.iTt.onDestroy();
        }
        if (this.iTJ != null) {
            this.iTJ.onDestory();
        }
        if (this.iTC != null) {
            this.iTC.onDestroy();
        }
        if (this.iTL != null) {
            this.iTL.onDestroy();
        }
        if (this.iTM != null) {
            this.iTM.onDestroy();
        }
        com.baidu.tieba.recapp.d.a.dFY().dGb();
        com.baidu.tieba.frs.f.m.cKg();
        if (this.iTr != null) {
            this.iTr.a((FrsTabViewController.a) null);
            this.iTr.cLp();
        }
        if (this.iTP != null) {
            this.iTP.onDestroy();
        }
        b.cBe().a(null);
        com.baidu.tieba.frs.a.cAX().a(null);
        if (this.iUc != null) {
            this.iUc.cKe();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.iSP);
        bundle.putString("from", this.mFrom);
        this.iTp.onSaveInstanceState(bundle);
        if (this.iSW != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            this.iSW.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.iTC != null) {
            this.iTC.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.iSX != null) {
            this.iSX.cDs();
            this.iSX.onResume();
        }
        this.iTs.qR(true);
        this.iTk = true;
        if (iSO) {
            iSO = false;
            if (this.iSX != null) {
                this.iSX.startPullRefresh();
                return;
            }
            return;
        }
        if (this.iSW != null) {
            this.iSW.onResume(getPageContext());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_RESUME));
        if (this.iSX != null) {
            this.iSX.qf(false);
        }
        if (this.iTK) {
            refresh(6);
            this.iTK = false;
        }
        if (this.iTT != null && getActivity() != null) {
            if (NotificationManagerCompat.from(getActivity()).areNotificationsEnabled()) {
                com.baidu.tbadk.coreExtra.messageCenter.f.bzH().setSignAlertOn(true);
                com.baidu.tbadk.coreExtra.messageCenter.f.bzH().setSignAlertTime(this.iTT.getHours(), this.iTT.getMinutes());
                if (this.iSX != null) {
                    com.baidu.tbadk.coreExtra.messageCenter.f.bzH().a(getTbPageContext().getPageActivity(), this.iSX.cno());
                }
            }
            this.iTT = null;
        }
        cCU();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
    }

    public boolean cCw() {
        Intent intent;
        if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
            return false;
        }
        return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
    }

    public void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.iSP = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.iSR = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.iSR) {
                cCx();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCx() {
        this.iSX.startPullRefresh();
    }

    public void closeActivity() {
        com.baidu.tieba.frs.f.l.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.mFrom);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.iSX.setTitle(this.iSP);
        } else {
            this.iSX.setTitle("");
            this.mFlag = 1;
        }
        this.iSX.a(this.iUI);
        this.iSX.addOnScrollListener(this.mScrollListener);
        this.iSX.g(this.iQh);
        this.iSX.cDF().a(this.iUH);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.iTR) {
            this.iSX.onChangeSkinType(i);
            this.iTq.BH(i);
            this.iTr.onChangeSkinType(i);
            if (this.iSZ != null) {
                this.iSZ.onChangeSkinType(i);
            }
            if (this.iTI != null) {
                this.iTI.onChangeSkinType();
            }
            if (this.iTN != null) {
                this.iTN.onChangeSkinType(getPageContext(), i);
            }
            if (this.ilQ != null) {
                com.baidu.tbadk.r.a.a(getPageContext(), this.ilQ.getRealView());
            }
            if (this.iTJ != null) {
                this.iTJ.onChangeSkinType(getPageContext(), i);
            }
        }
    }

    public void zI(int i) {
        if (!this.mIsLogin) {
            if (this.iSv != null && this.iSv.getAnti() != null) {
                this.iSv.getAnti().setIfpost(1);
            }
            if (i == 0) {
                bh.skipToLoginActivity(getActivity());
            }
        } else if (this.iSv != null) {
            if (i == 0) {
                com.baidu.tieba.frs.f.m.g(this, 0);
            } else {
                this.iSX.cDu();
            }
        }
    }

    public void refresh() {
        com.baidu.tieba.a.d.bLU().Fn("page_frs");
        refresh(3);
    }

    public void refresh(int i) {
        this.iTi = false;
        cCF();
        if (this.iSX != null && this.iSX.cDj() != null) {
            this.iSX.cDj().cPi();
        }
        if (this.iTp != null) {
            this.iTp.S(i, true);
        }
    }

    private void cCy() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.f.h.mZ().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.35
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.TV(FrsFragment.this.iSP);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCz() {
        cCF();
        try {
            if (this.iSv != null) {
                this.iSX.bYt();
                this.iSX.pY(cCT());
                if (!com.baidu.tieba.frs.vc.h.n(this.iSv) || !com.baidu.tieba.frs.vc.h.m(this.iSv)) {
                }
                if (this.iSv.getForum() != null) {
                    this.iSP = this.iSv.getForum().getName();
                    this.forumId = this.iSv.getForum().getId();
                }
                if (this.iSv.getPage() != null) {
                    setHasMore(this.iSv.getPage().bnF());
                }
                this.iSX.setTitle(this.iSP);
                this.iSX.setForumName(this.iSP);
                TbadkCoreApplication.getInst().setDefaultBubble(this.iSv.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.iSv.getUserData().getBimg_end_time());
                cCy();
                cCA();
                ArrayList<com.baidu.adp.widget.ListView.q> threadList = this.iSv.getThreadList();
                if (threadList != null) {
                    this.iSX.a(threadList, this.iSv);
                    com.baidu.tieba.frs.f.c.A(this.iSX);
                    this.iTq.BI(getPageNum());
                    this.iTq.j(this.iSv);
                    this.iTr.a(this.iSv, this.iTp.cJj());
                    this.iSX.cDv();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void cCA() {
        if (this.iSv != null) {
            if (this.iSv.getIsNewUrl() == 1) {
                this.iSX.cDF().setFromCDN(true);
            } else {
                this.iSX.cDF().setFromCDN(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.iTs.qR(false);
        this.iTk = false;
        this.iSX.onPause();
        if (this.iSW != null) {
            this.iSW.onPause(getPageContext());
        }
        this.iSX.qf(true);
        if (this.iTy != null) {
            this.iTy.cKj();
        }
        com.baidu.tbadk.BdToken.c.biD().biO();
        if (this.iUc != null) {
            this.iUc.cKe();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.iTr != null && this.iTr.cLn() != null && (this.iTr.cLn().fragment instanceof BaseFragment)) {
            ((BaseFragment) this.iTr.cLn().fragment).setPrimary(z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.t.csh().oX(false);
        pR(false);
        if (this.iSv != null && this.iSv.getForum() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            com.baidu.tbadk.distribute.a.bCa().b(getPageContext().getPageActivity(), "frs", this.iSv.getForum().getId(), 0L);
        }
        if (this.iSW != null) {
            this.iSW.onStop(getPageContext());
        }
        if (bvQ() != null) {
            bvQ().getRecycledViewPool().clear();
        }
        this.iTq.bvb();
        com.baidu.tbadk.util.aa.bGN();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            if (this.iTq != null) {
                this.iTq.cb(isPrimary());
            }
            if (this.iSX != null) {
                this.iSX.cb(isPrimary());
                this.iSX.qf(!isPrimary());
            }
        }
    }

    private void cCB() {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.oT(2);
        aVar.jm(false);
        FrsBroadcastCopyGuideDialogView frsBroadcastCopyGuideDialogView = new FrsBroadcastCopyGuideDialogView(getPageContext().getPageActivity());
        frsBroadcastCopyGuideDialogView.setConfirmButtonListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.36
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aVar != null) {
                    aVar.dismiss();
                    FrsFragment.this.cCC();
                }
            }
        });
        aVar.bi(frsBroadcastCopyGuideDialogView);
        aVar.b(getPageContext()).brv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCC() {
        com.baidu.tbadk.k.d.bDH().a(new com.baidu.tbadk.k.a(getContext()));
        if (com.baidu.tbadk.k.d.bDH().init()) {
            ((BaseFragmentActivity) getPageContext().getOrignalPage()).grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.frs.FrsFragment.37
                @Override // com.baidu.tbadk.core.e
                public void onPermissionResult(boolean z) {
                    if (!z) {
                        new BdTopToast(FrsFragment.this.getContext()).yW(false).Vt(FrsFragment.this.getContext().getString(R.string.forum_broadcast_copy_no_permission_hint)).aF(FrsFragment.this.iSX.cno());
                        return;
                    }
                    com.baidu.tbadk.k.d.bDH().kH(true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                    if (FrsFragment.this.iSY != null) {
                        FrsFragment.this.iSY.setVisibility(8);
                    }
                }
            }, true);
        }
    }

    private void cCD() {
        com.baidu.tbadk.k.d.bDH().a(new com.baidu.tbadk.k.b(getContext()));
        if (com.baidu.tbadk.k.d.bDH().init()) {
            ((BaseFragmentActivity) getPageContext().getOrignalPage()).grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.frs.FrsFragment.38
                @Override // com.baidu.tbadk.core.e
                public void onPermissionResult(boolean z) {
                    if (z) {
                        com.baidu.tbadk.k.d.bDH().kH(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                        if (FrsFragment.this.iSY != null) {
                            FrsFragment.this.iSY.setVisibility(8);
                        }
                    }
                }
            }, true);
        }
    }

    public void KI(String str) {
        new BdTopToast(getContext(), 3000).yW(true).Vt(str).aF(this.iSX.cno());
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (b.cBe().cAY()) {
                b.cBe().reset();
                return true;
            } else if (com.baidu.tieba.frs.a.cAX().cAY()) {
                if (this.iSX != null && this.iSX.cDJ()) {
                    this.iSX.cDK();
                    return true;
                }
                com.baidu.tieba.frs.a.cAX().reset();
                return true;
            } else if (this.iSX != null) {
                return this.iSX.cDr();
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
    public void cCE() {
        cCa().cCE();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.iSW == null) {
            this.iSW = VoiceManager.instance();
        }
        return this.iSW;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdRecyclerView bvQ() {
        if (this.iSX == null) {
            return null;
        }
        return this.iSX.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void cCF() {
        if (this.iSW != null) {
            this.iSW.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> bvR() {
        if (this.few == null) {
            this.few = UserIconBox.D(getPageContext().getPageActivity(), 8);
        }
        return this.few;
    }

    public void cCG() {
        if (getFragmentActivity() != null && getFragmentActivity().getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.t onGetPreLoadListView() {
        return bvQ().getPreLoadHandle();
    }

    @Override // com.baidu.tieba.frs.as
    public NavigationBar bVL() {
        if (this.iSX == null) {
            return null;
        }
        return this.iSX.bVL();
    }

    public FRSRefreshButton cCH() {
        return this.iSZ;
    }

    public void c(LinearLayout linearLayout) {
        if (linearLayout != null) {
            this.iTa = linearLayout;
        }
    }

    public void a(FRSRefreshButton fRSRefreshButton) {
        if (fRSRefreshButton != null) {
            this.iSZ = fRSRefreshButton;
            this.iSZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.44
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (FrsFragment.this.iTr != null) {
                        FrsTabViewController.b cLn = FrsFragment.this.iTr.cLn();
                        if (cLn != null && cLn.fragment != null && (cLn.fragment instanceof ar)) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                            ((ar) cLn.fragment).cBM();
                            ((ar) cLn.fragment).bTa();
                            return;
                        }
                        FrsFragment.this.cCf().startPullRefresh();
                    }
                }
            });
        }
    }

    public void cCI() {
        if (this.iSZ != null) {
            this.iSZ.hide();
        }
    }

    public void cCJ() {
        if (this.iSZ != null) {
            this.iSZ.show();
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
                if (bdUniqueId == v.iWK) {
                    if (FrsFragment.this.iSX != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11752").dY("fid", FrsFragment.this.forumId).dY("obj_locate", "1"));
                        FrsFragment.this.iSX.startPullRefresh();
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
                                com.baidu.tieba.frs.f.k.a(FrsFragment.this, FrsFragment.this.iSv, byVar);
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
            hideNetRefreshView(this.iSX.cDT().cLe());
            showLoadingView(this.iSX.cno(), true);
            this.iSX.qb(false);
            this.iTp.S(3, true);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData cCK() {
        return this.iSv;
    }

    public boolean cCL() {
        return this.iSX.cCL();
    }

    public void aJ(Object obj) {
        if (this.iTu != null && this.iTu.jrj != null) {
            this.iTu.jrj.callback(obj);
        }
    }

    public void aK(Object obj) {
        if (this.iTu != null && this.iTu.jrk != null) {
            this.iTu.jrk.callback(obj);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        this.iSX.getListView().stopScroll();
        if (!this.iSX.cDB()) {
            if (!com.baidu.adp.lib.util.l.isNetOk()) {
                this.iSX.bTb();
            } else if (this.iTp.cJe() == 1) {
                bSc();
                bRN();
            } else if (this.iTp.hasMore()) {
                bRN();
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void onFailed(String str) {
        bSc();
        showToast(str);
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void az(ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        boolean isEmpty = com.baidu.tbadk.core.util.y.isEmpty(arrayList);
        setHasMore(isEmpty ? 0 : 1);
        bSc();
        if (!isEmpty) {
            if (!this.iTp.cJo() && TbadkCoreApplication.getInst().isRecAppExist() && this.iTp.cJe() == 1) {
                this.iSv.addRecommendAppToThreadList(this, arrayList);
            }
            if (this.iTp != null) {
                com.baidu.tieba.frs.d.a.a(getUniqueId(), arrayList, this.iSv.getForum(), this.iTp.getSortType());
            }
            ArrayList<com.baidu.adp.widget.ListView.q> a2 = this.iTA.a(false, false, arrayList, this.iST, false);
            if (a2 != null) {
                this.iSv.setThreadList(a2);
                this.iSX.a(a2, this.iSv);
            }
            if (this.iTp != null) {
                com.baidu.tieba.frs.d.c.a(this.iSv, this.iTp.cJj(), 2, getContext());
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.iSv.getForum()));
        }
    }

    private void bSc() {
        if (cCg() == 1 || this.iTA.dx(this.iSv.getThreadListIds())) {
            if (com.baidu.tbadk.core.util.y.getCount(this.iSv.getThreadList()) > 3) {
                this.iSX.XZ();
            } else {
                this.iSX.cDH();
            }
        } else if (com.baidu.tbadk.core.util.y.isEmpty(this.iSv.getThreadList())) {
            this.iSX.bTb();
        } else {
            this.iSX.Ya();
        }
    }

    @Override // com.baidu.tieba.frs.mc.l
    public void bRN() {
        if (this.iTA != null) {
            this.iTA.a(this.iSP, this.forumId, this.iSv);
        }
    }

    public void cCM() {
        if (!com.baidu.tbadk.core.util.ae.requestWriteExternalStorgeAndCameraPermission(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.ao.g(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment, com.baidu.n.a.a.InterfaceC0276a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        com.baidu.tieba.frs.f.l.a(this, i, strArr, iArr);
    }

    public void pU(boolean z) {
        if (this.iTv != null) {
            this.iTv.qo(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.iTw.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a ub(int i) {
        return this.iTw.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        this.iTE.b(bVar);
    }

    public boolean cCN() {
        return this.iSL;
    }

    @Override // com.baidu.tieba.frs.ap
    public void VC() {
        if (this.iSX != null) {
            showFloatingView();
            this.iSX.getListView().scrollToPosition(0);
            this.iSX.startPullRefresh();
        }
    }

    public ForumWriteData cCO() {
        if (this.iSv == null || this.iSv.getForum() == null) {
            return null;
        }
        ForumData forum = this.iSv.getForum();
        ForumWriteData forumWriteData = new ForumWriteData(forum.getId(), forum.getName(), forum.getPrefixData(), this.iSv.getAnti());
        forumWriteData.avatar = forum.getImage_url();
        forumWriteData.forumLevel = forum.getUser_level();
        forumWriteData.specialForumType = forum.special_forum_type;
        forumWriteData.firstDir = forum.getFirst_class();
        forumWriteData.secondDir = forum.getSecond_class();
        UserData userData = this.iSv.getUserData();
        forumWriteData.privateThread = userData != null ? userData.getPrivateThread() : 0;
        forumWriteData.frsTabInfo = cCP();
        return forumWriteData;
    }

    private FrsTabInfoData cCP() {
        int i;
        if (this.iTp == null || this.iSv == null || this.iTr == null) {
            return null;
        }
        if (this.iSv.getEntelechyTabInfo() == null || com.baidu.tbadk.core.util.y.isEmpty(this.iSv.getEntelechyTabInfo().tab)) {
            return null;
        }
        int cLr = this.iTr.cLr();
        if (cLr == 502) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = -1;
        for (FrsTabInfo frsTabInfo : this.iSv.getEntelechyTabInfo().tab) {
            if (frsTabInfo != null && frsTabInfo.is_general_tab.intValue() == 1) {
                if (frsTabInfo.tab_id.intValue() != 505 || this.iSv.getUserData() == null || this.iSv.getUserData().isForumBusinessAccount()) {
                    arrayList.add(new FrsTabItemData(frsTabInfo));
                    if (cLr == frsTabInfo.tab_id.intValue()) {
                        i = cLr;
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
        if (this.iSv.getUserData() != null) {
            frsTabInfoData.isForumBusinessAccount = this.iSv.getUserData().isForumBusinessAccount();
            return frsTabInfoData;
        }
        return frsTabInfoData;
    }

    @Override // com.baidu.tieba.frs.ap
    public void bvt() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void pV(boolean z) {
        this.iTl = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z) {
        this.iSX.zQ(8);
        ((FrsActivity) getActivity()).showLoadingView(view, z);
        ((FrsActivity) getActivity()).k(view, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        this.iSX.zQ(0);
        ((FrsActivity) getActivity()).hideLoadingView(view);
        ((FrsActivity) getActivity()).k(view, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        super.showNetRefreshView(view, getResources().getString(R.string.refresh_view_title_text), null, getResources().getString(R.string.refresh_view_button_text), z, getNetRefreshListener());
        this.iSX.zQ(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshViewNoClick(View view, String str, boolean z) {
        super.showNetRefreshViewNoClick(view, str, z);
        this.iSX.zQ(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        super.hideNetRefreshView(view);
        this.iSX.zQ(0);
    }

    public void cCQ() {
        FrsTabViewController.b cLn;
        if (this.iTr != null && (cLn = this.iTr.cLn()) != null && cLn.fragment != null && (cLn.fragment instanceof ar)) {
            ((ar) cLn.fragment).cBM();
        }
    }

    public void pW(boolean z) {
        this.iSN = z;
    }

    public void b(OvalActionButton ovalActionButton) {
        this.iSY = ovalActionButton;
    }

    public OvalActionButton cCR() {
        return this.iSY;
    }

    public boolean cCS() {
        return this.iSN;
    }

    public void onShareSuccess(String str) {
        if (TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.util.au.isEmpty(str)) {
            if (this.iTP == null) {
                this.iTP = new AddExperiencedModel(getTbPageContext());
            }
            this.iTP.gn(this.forumId, str);
        }
    }

    public boolean cCT() {
        if (this.iTl && !this.iTS) {
            return (this.iTp != null && this.iTp.cJf() && (b.cBe().cAY() || com.baidu.tieba.frs.a.cAX().cAY())) ? false : true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.f.b
    public boolean videoNeedPreload() {
        if (this.iSv != null) {
            return com.baidu.tbadk.util.ai.sW(2) || (com.baidu.tbadk.util.ai.bGV() && this.iSv.isFrsVideoAutoPlay);
        }
        return super.videoNeedPreload();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCU() {
        if (!com.baidu.tbadk.core.util.au.isEmpty(this.forumId)) {
            com.baidu.tbadk.BdToken.c.biD().q(com.baidu.tbadk.BdToken.b.evw, com.baidu.adp.lib.f.b.toLong(this.forumId, 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCV() {
        String format;
        String str;
        if (isResumed() && this.iTW != null && this.iTW.size() >= 1 && this.iTV <= this.iTW.size() - 1) {
            final LiveHorseRaceData liveHorseRaceData = this.iTW.get(this.iTV);
            if (System.currentTimeMillis() / 1000 >= liveHorseRaceData.getRob_end_tm().longValue()) {
                this.iTV++;
                cCV();
            }
            if (this.iTa != null) {
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
                        if (FrsFragment.this.iSv == null) {
                            str2 = "";
                        } else if (FrsFragment.this.iSv.getForum() != null) {
                            str2 = FrsFragment.this.iSv.getForum().getName();
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
                this.iTX = ValueAnimator.ofFloat(1.0f, 0.0f);
                this.iTX.setDuration(600L);
                this.iTX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.FrsFragment.52
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        if (valueAnimator.isRunning()) {
                            frsRedpackRunView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                            frsRedpackRunView.setTranslationX(-(TbadkApplication.getInst().getContext().getResources().getDimensionPixelOffset(R.dimen.tbds850) * valueAnimator.getAnimatedFraction()));
                        }
                    }
                });
                this.iTX.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.FrsFragment.53
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        frsRedpackRunView.setAlpha(0.0f);
                        frsRedpackRunView.setTranslationY(TbadkApplication.getInst().getContext().getResources().getDimensionPixelOffset(R.dimen.tbds660));
                        frsRedpackRunView.hide();
                        FrsFragment.this.iTa.removeView(frsRedpackRunView);
                        if (FrsFragment.this.iTW == null || FrsFragment.this.iTV <= FrsFragment.this.iTW.size() - 1) {
                            FrsFragment.this.cCV();
                            return;
                        }
                        FrsFragment.this.iTa.removeAllViews();
                        FrsFragment.this.iTa.setVisibility(8);
                        FrsFragment.this.iTV = 0;
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        onAnimationEnd(animator);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                this.iTY = new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.54
                    @Override // java.lang.Runnable
                    public void run() {
                        if (FrsFragment.this.iTa != null && frsRedpackRunView != null) {
                            FrsFragment.this.iTX.start();
                        }
                    }
                };
                com.baidu.adp.lib.f.e.mY().postDelayed(this.iTY, 5000L);
                if (this.iTa.getChildCount() == 0) {
                    this.iTV++;
                    this.iTa.addView(frsRedpackRunView);
                    if (this.iSv != null) {
                        str = this.iSv.getForum() != null ? this.iSv.getForum().getName() : "";
                    } else {
                        str = "";
                    }
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13743").al("obj_source", 1).dY("fid", this.forumId).dY("fname", str));
                }
                if (this.iTa.getVisibility() == 8 && ((BaseFragment) this.iTr.cLn().fragment).isPrimary() && !this.iSX.cDQ() && !this.iTg) {
                    this.iTa.setVisibility(0);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        FrsTabViewController.b cLn;
        if (cCd() == null || (cLn = cCd().cLn()) == null || !(cLn.fragment instanceof BaseFragment)) {
            return null;
        }
        if (cLn.fragment instanceof FrsAllThreadFragment) {
            TbPageTag tbPageTag = super.getTbPageTag();
            int i = -1;
            if (this.iSv != null) {
                i = this.iSv.getSortType();
            }
            tbPageTag.sortType = com.baidu.tieba.frs.f.j.BF(i);
            tbPageTag.locatePage = "a070";
            if (this.iSI.equals(cLn.title)) {
                tbPageTag.locatePage = "a071";
            }
            return tbPageTag;
        } else if (cLn.fragment instanceof FrsFragment) {
            return null;
        } else {
            return ((BaseFragment) cLn.fragment).getTbPageTag();
        }
    }

    public void cCW() {
        if (this.iSv != null) {
            com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
            if (this.iSv.needLog == 1) {
                bVar.jtR = true;
            } else {
                bVar.jtR = false;
            }
            if (this.iSv.getForum() != null) {
                bVar.jtT = this.iSv.getForum().getId();
            }
            if (cCa() != null) {
                bVar.jtS = cCa().cJj();
            }
            if (com.baidu.tieba.frs.d.d.jcU != null) {
                bVar.jtU = com.baidu.tieba.frs.d.d.jcU.jtU;
                bVar.jtV = com.baidu.tieba.frs.d.d.jcU.jtV;
            }
            this.iTZ = new com.baidu.tieba.frs.live.b(bVar, getTbPageTag(), getUniqueId());
            this.iTZ.Bi(this.iUb);
            CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_CARD_CLICK, this.iTZ);
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
            CustomMessageTask customMessageTask2 = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW, this.iTZ);
            customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask2);
            CustomMessageTask customMessageTask3 = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_USER_CLICK, this.iTZ);
            customMessageTask3.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask3);
            CustomMessageTask customMessageTask4 = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_VIDEO_CLICK, this.iTZ);
            customMessageTask4.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask4);
        }
    }

    public void aF(String str, String str2, String str3) {
        this.iUc = new com.baidu.tieba.frs.f.e(str, str2);
        this.iUc.c(getFragmentActivity(), str3, str2);
    }
}
