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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.data.bx;
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
public class FrsFragment extends BaseFragment implements BdListView.e, a.InterfaceC0248a, UserIconBox.b<BdRecyclerView>, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, aq, at, aw, com.baidu.tieba.frs.loadmore.a, com.baidu.tieba.frs.mc.l, com.baidu.tieba.recapp.o {
    public static com.baidu.tieba.tbadkCore.m iIh;
    private com.baidu.adp.lib.d.b<TbImageView> eWZ;
    private com.baidu.tbadk.util.y fyn;
    private com.baidu.tieba.frs.gametab.b gCS;
    private com.baidu.tieba.frs.entelechy.a iHP;
    private com.baidu.tieba.tbadkCore.data.f iHZ;
    private com.baidu.tieba.frs.smartsort.a iIA;
    private com.baidu.tieba.frs.mc.b iIB;
    private ax iIC;
    private com.baidu.tieba.frs.entelechy.b.b iIE;
    private com.baidu.tieba.frs.vc.a iIF;
    private com.baidu.tieba.frs.mc.d iIG;
    private com.baidu.tieba.frs.mc.c iIH;
    private com.baidu.tieba.frs.vc.j iII;
    private com.baidu.tieba.frs.mc.a iIJ;
    private com.baidu.tieba.frs.live.a iIK;
    private p iIL;
    public com.baidu.tieba.frs.vc.c iIM;
    private com.baidu.tieba.frs.mc.e iIN;
    private View.OnTouchListener iIO;
    private com.baidu.tieba.frs.view.a iIP;
    private com.baidu.tieba.frs.vc.e iIQ;
    private boolean iIR;
    private com.baidu.tieba.NEGFeedBack.a iIS;
    private com.baidu.tieba.ala.a iIT;
    private com.baidu.tieba.frs.brand.buttommenu.a iIU;
    private com.baidu.tieba.frs.sportspage.notification.a iIV;
    private AddExperiencedModel iIW;
    private boolean iIY;
    private VoiceManager iIc;
    private OvalActionButton iIe;
    private FRSRefreshButton iIf;
    private LinearLayout iIg;
    public long iIi;
    private String iIt;
    private com.baidu.card.am iIv;
    private FrsModelController iIw;
    private com.baidu.tieba.frs.vc.h iIx;
    private FrsTabViewController iIy;
    private com.baidu.tieba.frs.mc.h iIz;
    private List<LiveHorseRaceData> iJd;
    private ValueAnimator iJe;
    private Runnable iJf;
    private com.baidu.tieba.frs.live.b iJg;
    private com.baidu.tieba.frs.broadcast.a iJh;
    private int iJi;
    private int iJs;
    private com.baidu.tbadk.core.dialog.a iaS;
    private View mRootView;
    private String mSchemeUrl;
    public static boolean iHU = false;
    public static volatile long iIk = 0;
    public static volatile long iIl = 0;
    public static volatile int mNetError = 0;
    private String iHO = "";
    public boolean iHQ = false;
    private boolean iHR = false;
    private boolean iHS = false;
    private boolean iHT = true;
    public String iHV = null;
    public String mFrom = null;
    public int mFlag = 0;
    public boolean iHW = false;
    private boolean iHX = false;
    private String mThreadId = null;
    public String forumId = null;
    private int iHD = 0;
    private boolean iHY = false;
    private boolean iIa = false;
    private boolean iIb = false;
    private q iId = null;
    public final bx akt = null;
    private FrsViewData iHB = new FrsViewData();
    public long ikF = -1;
    public long fuA = 0;
    public long fuq = 0;
    public long createTime = 0;
    public long fur = 0;
    public long fux = 0;
    public long iIj = 0;
    boolean iIm = false;
    public boolean iIn = false;
    private boolean iIo = false;
    private boolean iIp = false;
    public com.baidu.tbadk.n.b iIq = null;
    private boolean iIr = true;
    private boolean iIs = true;
    private a.C0096a iIu = new a.C0096a(2);
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> iID = new SparseArray<>();
    private boolean glO = true;
    private boolean hasInit = false;
    private boolean iIX = false;
    private boolean iIZ = false;
    private Date iJa = null;
    private int dHY = 0;
    private int iJb = 0;
    private int iJc = 0;
    public int mHeadLineDefaultNavTabId = -1;
    MessageQueue.IdleHandler iJj = new MessageQueue.IdleHandler() { // from class: com.baidu.tieba.frs.FrsFragment.1
        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            FrsFragment.this.cyc();
            return false;
        }
    };
    private final CustomMessageListener iJk = new CustomMessageListener(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED) { // from class: com.baidu.tieba.frs.FrsFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof bx) {
                    com.baidu.tieba.frs.f.j.a(FrsFragment.this.iId, FrsFragment.this.iHB, FrsFragment.this.getForumId(), true, (bx) data);
                }
            }
        }
    };
    private CustomMessageListener iJl = new CustomMessageListener(CmdConfigCustom.CMD_CLOSE_GAME_RANK_CARD) { // from class: com.baidu.tieba.frs.FrsFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.iHB != null) {
                FrsFragment.this.iHB.removeGameRankListFromThreadList();
                if (FrsFragment.this.iId != null) {
                    FrsFragment.this.iId.aZK();
                }
            }
        }
    };
    private CustomMessageListener agD = new CustomMessageListener(2921401) { // from class: com.baidu.tieba.frs.FrsFragment.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && FrsFragment.this.iIf != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() <= 0 || FrsFragment.this.iIy.cGa() == 0 || FrsFragment.this.iIy.cFX() == null || !(FrsFragment.this.iIy.cFX().fragment instanceof BaseFragment) || !((BaseFragment) FrsFragment.this.iIy.cFX().fragment).isPrimary() || FrsFragment.this.iId.czz() || KuangFloatingFrsCopyLinkViewController.getInstance().isFloatCopyViewShow()) {
                    if (FrsFragment.this.iIy.cGa() != 0) {
                        FrsFragment.this.iIf.hide();
                        return;
                    }
                    return;
                }
                FrsFragment.this.iIf.show();
            }
        }
    };
    private CustomMessageListener iJm = new CustomMessageListener(2921473) { // from class: com.baidu.tieba.frs.FrsFragment.45
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && FrsFragment.this.iIf != null && FrsFragment.this.iIe != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() == 0) {
                    FrsFragment.this.iIf.setVisibility(8);
                    FrsFragment.this.iIe.setVisibility(8);
                    return;
                }
                FrsFragment.this.iIe.setVisibility(0);
            }
        }
    };
    private CustomMessageListener iJn = new CustomMessageListener(2921467) { // from class: com.baidu.tieba.frs.FrsFragment.56
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && FrsFragment.this.iIf != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() <= 0 || FrsFragment.this.iIy.cFX() == null || !(FrsFragment.this.iIy.cFX().fragment instanceof BaseFragment) || !((BaseFragment) FrsFragment.this.iIy.cFX().fragment).isPrimary() || FrsFragment.this.iId.czz()) {
                    FrsFragment.this.iIg.setVisibility(8);
                    FrsFragment.this.iIm = true;
                    return;
                }
                FrsFragment.this.iIg.setVisibility(0);
                FrsFragment.this.iIm = false;
            }
        }
    };
    private com.baidu.adp.framework.listener.a iJo = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_FRS_LIVE_HORSE_RACE_LIST, 309667) { // from class: com.baidu.tieba.frs.FrsFragment.60
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if ((responsedMessage instanceof GetLiveHorseRaceHttpResponseMessage) || (responsedMessage instanceof GetLiveHorseRaceSocketResponseMessage)) {
                    List<LiveHorseRaceData> arrayList = new ArrayList<>();
                    if (responsedMessage instanceof GetLiveHorseRaceHttpResponseMessage) {
                        arrayList = ((GetLiveHorseRaceHttpResponseMessage) responsedMessage).getData().cAa();
                    }
                    if (responsedMessage instanceof GetLiveHorseRaceSocketResponseMessage) {
                        arrayList = ((GetLiveHorseRaceSocketResponseMessage) responsedMessage).getData().cAa();
                    }
                    if (FrsFragment.this.iJd != null) {
                        if (FrsFragment.this.iIg.getVisibility() != 8) {
                            if (FrsFragment.this.iJc >= FrsFragment.this.iJd.size()) {
                                FrsFragment.this.iJd.addAll(arrayList);
                                return;
                            }
                            FrsFragment.this.iJd = FrsFragment.this.iJd.subList(0, FrsFragment.this.iJc);
                            FrsFragment.this.iJd.addAll(arrayList);
                            return;
                        }
                        FrsFragment.this.iJd = new ArrayList();
                        FrsFragment.this.iJd.addAll(arrayList);
                        FrsFragment.this.iJc = 0;
                        FrsFragment.this.cyD();
                        return;
                    }
                    FrsFragment.this.iJd = new ArrayList();
                    FrsFragment.this.iJc = 0;
                    FrsFragment.this.iJd.addAll(arrayList);
                    FrsFragment.this.cyD();
                }
            }
        }
    };
    private CustomMessageListener iJp = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.FrsFragment.61
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 1) {
                    FrsFragment.this.cyg();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                }
            }
        }
    };
    private final av iJq = new av() { // from class: com.baidu.tieba.frs.FrsFragment.62
        @Override // com.baidu.tieba.frs.av
        public void a(int i, int i2, bd bdVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
            FrsFragment.this.cxR();
            if (FrsFragment.this.iIE != null) {
                FrsFragment.this.iIx.qx(FrsFragment.this.iIE.zR(i));
            }
            com.baidu.tieba.tbadkCore.f fVar = new com.baidu.tieba.tbadkCore.f();
            if (bdVar != null) {
                fVar.isSuccess = bdVar.errCode == 0;
                fVar.errorCode = bdVar.errCode;
                fVar.errorMsg = bdVar.errMsg;
                if (fVar.isSuccess) {
                    if (com.baidu.tbadk.core.util.y.isEmpty(arrayList)) {
                        FrsFragment.this.iId.bPp();
                    } else if (bdVar.hasMore) {
                        if (com.baidu.tbadk.core.util.y.getCount(FrsFragment.this.iHB.getThreadList()) > 3) {
                            FrsFragment.this.iId.Vz();
                        } else {
                            FrsFragment.this.iId.czq();
                        }
                    } else if (bdVar.iNb) {
                        FrsFragment.this.iId.VA();
                    } else {
                        FrsFragment.this.iId.bPp();
                    }
                }
            } else {
                bdVar = new bd();
                bdVar.pn = 1;
                bdVar.hasMore = false;
                bdVar.iNb = false;
            }
            if (i == 1) {
                FrsFragment.this.iIr = true;
                FrsFragment.this.iJH.a(FrsFragment.this.iIw.getType(), false, fVar);
            } else {
                FrsFragment.this.a(fVar);
                if (FrsFragment.this.iIw.cDr() != null) {
                    FrsFragment.this.iHB = FrsFragment.this.iIw.cDr();
                }
                FrsFragment.this.cyi();
            }
            if (FrsFragment.this.iJP != null) {
                FrsFragment.this.iJP.a(i, i2, bdVar, arrayList);
            }
        }
    };
    private FrsTabViewController.a iJr = new FrsTabViewController.a() { // from class: com.baidu.tieba.frs.FrsFragment.2
        @Override // com.baidu.tieba.frs.vc.FrsTabViewController.a
        public void cl(int i, int i2) {
            boolean z = false;
            if (i != 1) {
                com.baidu.tieba.card.t.cnT().oB(false);
                FrsFragment.this.pu(false);
            }
            if (i == 502) {
                FrsFragment.this.iIe.setIconFade(R.drawable.btn_frs_professional_edit_n);
            } else {
                FrsFragment.this.iIe.setIconFade(0);
            }
            FrsFragment.this.iJs = i;
            FrsFragment.this.iJi = i2;
            if (FrsFragment.this.iJg != null) {
                FrsFragment.this.iJg.Au(FrsFragment.this.iJi);
            }
            TbSingleton.getInstance().setFrsCurTabType(FrsFragment.this.iJi);
            FrsFragment.this.cyn();
            com.baidu.tieba.frs.d.d.iRY.jgp = i;
            com.baidu.tieba.frs.d.d.iRY.jgs = i2;
            com.baidu.tieba.frs.d.d.iRY.jgq = -1;
            b.cwO().V(i == 1 && FrsFragment.this.iIX, true);
            com.baidu.tieba.frs.a cwH = com.baidu.tieba.frs.a.cwH();
            if (i == 1 && FrsFragment.this.iIX) {
                z = true;
            }
            cwH.V(z, true);
        }
    };
    private CustomMessageListener iJt = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIVE_COUNT) { // from class: com.baidu.tieba.frs.FrsFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                FrsFragment.this.iIy.Be(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    };
    private CustomMessageListener iJu = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_LIVE_START) { // from class: com.baidu.tieba.frs.FrsFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && ((Integer) customResponsedMessage.getData()).intValue() == 51 && FrsFragment.this.iHB != null) {
                com.baidu.tieba.frs.f.l.a(FrsFragment.this.iHB, FrsFragment.this.getPageContext());
            }
        }
    };
    private final CustomMessageListener iJv = new CustomMessageListener(CmdConfigCustom.CMD_FRS_SELECT_ALA_LIVE_TAB) { // from class: com.baidu.tieba.frs.FrsFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                FrsFragment.this.iIy.tE(49);
            }
        }
    };
    private final CustomMessageListener iJw = new CustomMessageListener(2921470) { // from class: com.baidu.tieba.frs.FrsFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                FrsFragment.this.iIy.tE(1);
                FrsFragment.this.cyg();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
            }
        }
    };
    private final CustomMessageListener iJx = new CustomMessageListener(CmdConfigCustom.CMD_FRS_EXPERIENCE_TIP) { // from class: com.baidu.tieba.frs.FrsFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.v) && FrsFragment.this.iHB != null) {
                FrsFragment.this.iHB.updateLikeData((com.baidu.tieba.tbadkCore.v) customResponsedMessage.getData());
                FrsFragment.this.iIx.j(FrsFragment.this.iHB);
                FrsFragment.this.iIy.a(FrsFragment.this.iHB, FrsFragment.this.iIw.cDV());
            }
        }
    };
    private final AntiHelper.a iJy = new AntiHelper.a() { // from class: com.baidu.tieba.frs.FrsFragment.8
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ak("obj_locate", ay.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ak("obj_locate", ay.a.LOCATE_LIKE_PERSON));
        }
    };
    private CustomMessageListener iJz = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.FrsFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(FrsFragment.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().fdL != null) {
                        if (AntiHelper.a(FrsFragment.this.getActivity(), updateAttentionMessage.getData().fdL, FrsFragment.this.iJy) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ak("obj_locate", ay.a.LOCATE_LIKE_PERSON));
                        }
                    } else if (updateAttentionMessage.getData().isSucc && updateAttentionMessage.getData().isAttention) {
                        com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getPageContext().getPageActivity(), R.string.attention_success);
                    }
                }
            }
        }
    };
    private CustomMessageListener iJA = new CustomMessageListener(CmdConfigCustom.CMD_GET_ENSURE_CAST_ID) { // from class: com.baidu.tieba.frs.FrsFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsFragment.this.refresh();
        }
    };
    private CustomMessageListener iJB = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.frs.FrsFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && !((PostWriteCallBackData) customResponsedMessage.getData()).isDyamicCallback()) {
                FrsFragment.this.iId.c((PostWriteCallBackData) customResponsedMessage.getData());
                if (((PostWriteCallBackData) customResponsedMessage.getData()).getGeneralTabId() >= 0) {
                    FrsFragment.this.iIJ.Aw(((PostWriteCallBackData) customResponsedMessage.getData()).getGeneralTabId());
                }
            }
        }
    };
    private CustomMessageListener iJC = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_REMIND) { // from class: com.baidu.tieba.frs.FrsFragment.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626) {
                NewsRemindMessage newsRemindMessage = (NewsRemindMessage) customResponsedMessage;
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (FrsFragment.this.iId != null) {
                    FrsFragment.this.iId.P(notificationCount, z);
                }
            }
        }
    };
    private HttpMessageListener iJD = new HttpMessageListener(CmdConfigHttp.CMD_FRS_MOVE_AREA) { // from class: com.baidu.tieba.frs.FrsFragment.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int i;
            int i2 = 0;
            if (httpResponsedMessage != null && FrsFragment.this.getContext() != null && FrsFragment.this.iId != null) {
                if (httpResponsedMessage.getError() == 0) {
                    new BdTopToast(FrsFragment.this.getContext()).yr(true).Ue(FrsFragment.this.getContext().getString(R.string.frs_move_area_move_suc)).aF(FrsFragment.this.iId.cjt());
                    if (com.baidu.tieba.frs.a.cwH().yX(com.baidu.tieba.frs.a.cwH().cwJ())) {
                        FrsCommonTabFragment frsCommonTabFragment = null;
                        if (FrsFragment.this.iIy != null && FrsFragment.this.iIy.cFX() != null && (FrsFragment.this.iIy.cFX().fragment instanceof FrsCommonTabFragment)) {
                            frsCommonTabFragment = (FrsCommonTabFragment) FrsFragment.this.iIy.cFX().fragment;
                        }
                        if (frsCommonTabFragment != null) {
                            frsCommonTabFragment.cAU();
                        }
                        FrsFragment.this.cwM();
                        com.baidu.tieba.frs.a.cwH().cwM();
                        Iterator<com.baidu.adp.widget.ListView.q> it = FrsFragment.this.iHB.getThreadList().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                i = i2;
                                break;
                            }
                            i = it.next() instanceof bw ? i2 + 1 : i2;
                            if (i >= 6) {
                                break;
                            }
                            i2 = i;
                        }
                        if (i < 6) {
                            FrsFragment.this.bOb();
                        }
                    }
                    com.baidu.tieba.frs.a.cwH().reset();
                    return;
                }
                new BdTopToast(FrsFragment.this.getContext()).yr(false).Ue(httpResponsedMessage.getErrorString()).aF(FrsFragment.this.iId.cjt());
            }
        }
    };
    private final CustomMessageListener iJE = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.frs.FrsFragment.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.isResumed()) {
                FrsFragment.this.cyC();
            }
        }
    };
    private CustomMessageListener iJF = new CustomMessageListener(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER) { // from class: com.baidu.tieba.frs.FrsFragment.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (FrsFragment.this.iId != null) {
                    FrsFragment.this.iId.setExpanded(booleanValue);
                }
            }
        }
    };
    private final CustomMessageListener iJG = new CustomMessageListener(2921463) { // from class: com.baidu.tieba.frs.FrsFragment.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TbadkApplication.getInst().getCurrentActivity() != null && !com.baidu.tbadk.core.util.au.isEmpty(str) && str.equals(FrsFragment.this.forumId)) {
                    com.baidu.tieba.frs.f.g.b(((TbPageContextSupport) TbadkApplication.getInst().getCurrentActivity()).getPageContext(), FrsFragment.this.iHB);
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.r iJH = new com.baidu.tieba.tbadkCore.r() { // from class: com.baidu.tieba.frs.FrsFragment.18
        private long startTime = 0;

        @Override // com.baidu.tieba.tbadkCore.r
        public void ze(int i) {
            this.startTime = System.nanoTime();
            if (FrsFragment.this.iId != null) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsFragment.this.iId.cza();
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
            if (FrsFragment.this.glO) {
                FrsFragment.this.glO = false;
                com.baidu.tieba.frs.f.j.a(FrsFragment.this.iId, FrsFragment.this.iHB, FrsFragment.this.getForumId(), false, null);
            }
            FrsFragment.this.cxR();
            FrsFragment.this.iIo = true;
            if (fVar != null && fVar.isSuccess) {
                FrsFragment.this.iId.czn().qe(com.baidu.tbadk.core.util.av.bqC().bqD());
                FrsFragment.iIk = 0L;
                FrsFragment.iIl = 0L;
                FrsFragment.mNetError = 0;
            } else {
                FrsFragment.mNetError = 1;
            }
            if (!FrsFragment.this.iIw.cEa() && (i == 3 || i == 6)) {
                FrsFragment.this.iIH.resetData();
            }
            FrsFragment.this.iIi = System.currentTimeMillis();
            if (FrsFragment.this.iIw.cDr() != null) {
                FrsFragment.this.iHB = FrsFragment.this.iIw.cDr();
            }
            FrsFragment.this.za(1);
            FrsFragment.this.cxZ();
            if (i == 7) {
                FrsFragment.this.zb(FrsFragment.this.iHB.getFrsDefaultTabId());
                return;
            }
            if (FrsFragment.this.iHB.getPage() != null) {
                FrsFragment.this.setHasMore(FrsFragment.this.iHB.getPage().bks());
            }
            if (i == 4) {
                if (!FrsFragment.this.iIw.cEa() && TbadkCoreApplication.getInst().isRecAppExist() && FrsFragment.this.iIw.cDQ() == 1) {
                    FrsFragment.this.iHB.addRecommendAppToThreadList(FrsFragment.this);
                }
                ArrayList<com.baidu.adp.widget.ListView.q> a2 = FrsFragment.this.iIH.a(false, false, FrsFragment.this.iHB.getThreadList(), FrsFragment.this.iHZ, false);
                if (a2 != null) {
                    FrsFragment.this.iHB.setThreadList(a2);
                    FrsFragment.this.iHB.checkLiveStageInThreadList();
                }
                if (FrsFragment.this.iIw != null) {
                    com.baidu.tieba.frs.d.c.a(FrsFragment.this.iHB, FrsFragment.this.iIw.cDV(), 2, FrsFragment.this.getContext());
                }
                com.baidu.tieba.frs.f.a.a(FrsFragment.this, FrsFragment.this.iHB.getForum(), FrsFragment.this.iHB.getThreadList(), false, FrsFragment.this.getPn());
                FrsFragment.this.iId.a(a2, FrsFragment.this.iHB);
                FrsFragment.this.cxS();
                return;
            }
            FrsFragment.this.cxS();
            switch (i) {
                case 1:
                    FrsFragment.this.iId.cza();
                    break;
                case 2:
                    FrsFragment.this.iId.cza();
                    break;
                case 3:
                case 6:
                    if (FrsFragment.this.iHB != null) {
                        FrsFragment.this.iHB.clearPostThreadCount();
                    }
                    if (FrsFragment.this.iIM != null) {
                        FrsFragment.this.iIM.refresh();
                        break;
                    }
                    break;
            }
            FrsFragment.this.cya();
            if (fVar == null || fVar.errorCode == 0) {
                if (FrsFragment.this.iHB != null) {
                    FrsFragment.this.a(FrsFragment.this.iHB);
                    FrsFragment.this.X(false, i == 5);
                    if (FrsFragment.this.iIw != null) {
                        if (FrsFragment.this.iHB.getActivityHeadData() != null && FrsFragment.this.iHB.getActivityHeadData().bjG() != null && FrsFragment.this.iHB.getActivityHeadData().bjG().size() > 0) {
                            com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), 1, FrsFragment.this.iHB.getForum(), FrsFragment.this.iIw.getSortType(), 1);
                        }
                        if (FrsFragment.this.iHB.getThreadList() != null && FrsFragment.this.iHB.getThreadList().size() > 0) {
                            Iterator<com.baidu.adp.widget.ListView.q> it = FrsFragment.this.iHB.getThreadList().iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    com.baidu.adp.widget.ListView.q next = it.next();
                                    if ((next instanceof bx) && ((bx) next).getType() == bx.eDS) {
                                        com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), 1, FrsFragment.this.iHB.getForum(), FrsFragment.this.iIw.getSortType(), 2);
                                    }
                                }
                            }
                        }
                        com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), FrsFragment.this.iHB.getThreadList(), FrsFragment.this.iHB.getForum(), FrsFragment.this.iIw.getSortType());
                    }
                    FrsFragment.this.iId.zr(i);
                    FrsFragment.iIk = (System.nanoTime() - this.startTime) / TimeUtils.NANOS_PER_MS;
                    if (fVar != null) {
                        FrsFragment.iIl = fVar.mVx;
                    }
                } else {
                    return;
                }
            } else if (FrsFragment.this.iHB == null || com.baidu.tbadk.core.util.y.isEmpty(FrsFragment.this.iHB.getThreadList())) {
                FrsFragment.this.a(fVar);
            } else if (fVar.isc) {
                FrsFragment.this.showToast(FrsFragment.this.getPageContext().getResources().getString(R.string.net_error_text, fVar.errorMsg, Integer.valueOf(fVar.errorCode)));
            }
            FrsFragment.this.cxW();
            FrsFragment.this.cxX();
            if (FrsFragment.this.iHB.getAccessFlag() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11384"));
            }
            if (FrsFragment.this.iIa && FrsFragment.this.iIy.tE(49)) {
                FrsFragment.this.iIa = false;
            }
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.r
        public void c(com.baidu.tieba.tbadkCore.m mVar) {
            if ((mVar != null && ("normal_page".equals(FrsFragment.this.iIw.getPageType()) || "frs_page".equals(FrsFragment.this.iIw.getPageType()) || "book_page".equals(FrsFragment.this.iIw.getPageType()))) || "brand_page".equals(FrsFragment.this.iIw.getPageType())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE, mVar));
                FrsFragment.this.b(mVar);
                FrsFragment.iIh = mVar;
            }
        }

        @Override // com.baidu.tieba.tbadkCore.r
        public void cyc() {
            FrsFragment.this.cyc();
        }
    };
    private final CustomMessageListener iJI = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.frs.FrsFragment.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.m) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                FrsFragment.this.iHB.updateCurrentUserPendant((com.baidu.tbadk.data.m) customResponsedMessage.getData());
                FrsFragment.this.iId.czn().notifyDataSetChanged();
            }
        }
    };
    private final CustomMessageListener mMemListener = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_MEM) { // from class: com.baidu.tieba.frs.FrsFragment.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && FrsFragment.this.iHB != null && (userData = FrsFragment.this.iHB.getUserData()) != null) {
                userData.setIsMem(num.intValue());
                if (num.intValue() != 0) {
                    FrsFragment.this.iIx.o(num);
                }
            }
        }
    };
    private final f.a iJJ = new AnonymousClass29();
    private final com.baidu.tieba.frs.mc.k iJK = new com.baidu.tieba.frs.mc.k() { // from class: com.baidu.tieba.frs.FrsFragment.30
        @Override // com.baidu.tieba.frs.mc.k
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, boolean z3) {
            if (FrsFragment.this.iIA != null && FrsFragment.this.iIw != null && FrsFragment.this.iIw.cEa() && z && !z2 && !z3) {
                FrsFragment.this.iIA.AB(i2);
            }
        }
    };
    public final View.OnTouchListener fyo = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.FrsFragment.31
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (FrsFragment.this.iIO != null) {
                FrsFragment.this.iIO.onTouch(view, motionEvent);
            }
            if (FrsFragment.this.iIC != null && FrsFragment.this.iIC.cAb() != null) {
                FrsFragment.this.iIC.cAb().onTouchEvent(motionEvent);
            }
            if (FrsFragment.this.gCS != null) {
                FrsFragment.this.gCS.b(view, motionEvent);
            }
            if (FrsFragment.this.iIx != null) {
                FrsFragment.this.iIx.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private final CustomMessageListener iJL = new CustomMessageListener(CmdConfigCustom.CMD_GOTOLIVE_HOST_UPGRADE) { // from class: com.baidu.tieba.frs.FrsFragment.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.bpu().getInt(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.PHOTOLIVE_HOSTLEVEL, -1) != -1 && FrsFragment.this.iHB.getForum() != null) {
                FrsFragment.this.iHB.getForum().setCanAddPhotoLivePost(true);
            }
        }
    };
    public final View.OnClickListener iJM = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.38
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsFragment.this.iId != null && view == FrsFragment.this.iId.cyY() && FrsFragment.this.getActivity() != null) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, FrsFragment.this.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            if (view.getId() == R.id.game_activity_egg_layout && com.baidu.adp.lib.util.l.isNetOk()) {
                TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_CLICK);
                if (FrsFragment.this.iId == null || !FrsFragment.this.iId.czk()) {
                    String activityUrl = FrsFragment.this.iHB.getForum().getYuleData().bnY().getActivityUrl();
                    if (!StringUtils.isNull(activityUrl)) {
                        com.baidu.tbadk.browser.a.startInternalWebActivity(FrsFragment.this.getPageContext().getPageActivity(), activityUrl);
                    }
                } else {
                    FrsFragment.this.iId.czl();
                }
            }
            if (FrsFragment.this.iId != null && view == FrsFragment.this.iId.czr() && FrsFragment.this.iIw != null && FrsFragment.this.iIw.hasMore()) {
                FrsFragment.this.iId.Vz();
                FrsFragment.this.bOb();
            }
            if (view != null && FrsFragment.this.iId != null && view == FrsFragment.this.iId.czh()) {
                if (bh.checkUpIsLogin(FrsFragment.this.getContext())) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).ak("obj_locate", 2));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MessageCenterActivityConfig(FrsFragment.this.getContext())));
                } else {
                    return;
                }
            }
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (FrsFragment.this.iHB != null && FrsFragment.this.iHB.getForum() != null) {
                    if (FrsFragment.this.iId != null && view == FrsFragment.this.iId.czf()) {
                        if (FrsFragment.this.iHB != null && FrsFragment.this.iHB.getForum() != null && !StringUtils.isNull(FrsFragment.this.iHB.getForum().getId()) && !StringUtils.isNull(FrsFragment.this.iHB.getForum().getName())) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.KEY_SHARE_CLICK).dR("fid", FrsFragment.this.iHB.getForum().getId()).ak("obj_locate", 11));
                            com.baidu.tieba.frs.f.g.a(FrsFragment.this.getPageContext(), FrsFragment.this.iHB, FrsFragment.this.iHB.getForum().getId());
                        } else {
                            return;
                        }
                    }
                    if (FrsFragment.this.iId != null && view == FrsFragment.this.iId.cze()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12402").dR("fid", FrsFragment.this.iHB.getForum().getId()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fname", FrsFragment.this.iHB.getForum().getName()));
                        if (!StringUtils.isNull(FrsFragment.this.iHB.getForum().getName())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PostSearchActivityConfig(FrsFragment.this.getContext(), FrsFragment.this.iHB.getForum().getName(), FrsFragment.this.iHB.getForum().getId())));
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
        private int iKj = 0;
        private int ghD = 0;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsFragment.this.iJb += i2;
            if (FrsFragment.this.iJb >= FrsFragment.this.dHY * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
            if (FrsFragment.this.iIF != null) {
                FrsFragment.this.iIF.cET();
            }
            this.iKj = 0;
            this.ghD = 0;
            if (recyclerView != null && (recyclerView instanceof BdRecyclerView)) {
                this.iKj = ((BdRecyclerView) recyclerView).getFirstVisiblePosition();
                this.ghD = ((BdRecyclerView) recyclerView).getLastVisiblePosition();
            }
            if (FrsFragment.this.iIQ != null) {
                FrsFragment.this.iIQ.a(recyclerView, this.iKj, this.ghD);
            }
            if (FrsFragment.this.iHB != null && FrsFragment.this.iId != null && FrsFragment.this.iId.czn() != null) {
                FrsFragment.this.iId.co(this.iKj, this.ghD);
                if (FrsFragment.this.iIv != null && FrsFragment.this.iIv.tW() != null) {
                    FrsFragment.this.iIv.tW().b(FrsFragment.this.iIu);
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (FrsFragment.this.iIx != null) {
                FrsFragment.this.iIx.setScrollState(i);
            }
            if ((i == 2 || i == 1) && !FrsFragment.this.iIp) {
                FrsFragment.this.iIp = true;
                FrsFragment.this.iId.czp();
            }
            if (FrsFragment.this.iIq == null && !FrsFragment.this.cyv()) {
                FrsFragment.this.iIq = new com.baidu.tbadk.n.b();
                FrsFragment.this.iIq.setSubType(1000);
            }
            if (i == 0) {
                if (FrsFragment.this.iIq != null) {
                    FrsFragment.this.iIq.bBB();
                }
                com.baidu.tieba.card.t.cnT().oB(true);
                FrsFragment.this.pu(true);
                FrsFragment.this.iId.cn(this.iKj, this.ghD);
            } else if (FrsFragment.this.iIq != null) {
                FrsFragment.this.iIq.bBA();
            }
            if (FrsFragment.this.iIQ != null) {
                FrsFragment.this.iIQ.onScrollStateChanged(recyclerView, i);
            }
            if (i == 0) {
                com.baidu.tieba.frs.f.j.a(FrsFragment.this.iId, FrsFragment.this.iHB, FrsFragment.this.getForumId(), false, null);
            }
            if (FrsFragment.this.iIy != null && i == 1) {
                FrsFragment.this.iIy.cFZ();
            }
            if (FrsFragment.this.iIv == null) {
                if (FrsFragment.this.iId.cyR() != null && !FrsFragment.this.iId.cyt() && FrsFragment.this.iId.cyR().dww() != null && (FrsFragment.this.iId.cyR().dww().getTag() instanceof com.baidu.card.am)) {
                    FrsFragment.this.iIv = (com.baidu.card.am) FrsFragment.this.iId.cyR().dww().getTag();
                }
            } else if (i == 0 && FrsFragment.this.iId.cyR() != null && !FrsFragment.this.iId.cyt() && FrsFragment.this.iId.cyR().dww() != null && (FrsFragment.this.iId.cyR().dww().getTag() instanceof com.baidu.card.am)) {
                FrsFragment.this.iIv = (com.baidu.card.am) FrsFragment.this.iId.cyR().dww().getTag();
            }
            if (i == 1) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921418));
            }
        }
    };
    private final f iJN = new f() { // from class: com.baidu.tieba.frs.FrsFragment.40
        @Override // com.baidu.tieba.frs.f
        public void a(int i, int i2, View view, View view2, bx bxVar) {
            if (i != FrsFragment.this.iId.czn().cBG()) {
                if (i != FrsFragment.this.iId.czn().cBH()) {
                    if (i == FrsFragment.this.iId.czn().cBE() && FrsFragment.this.iHB != null && FrsFragment.this.iHB.getUserData() != null && FrsFragment.this.iHB.getUserData().isBawu()) {
                        String bawuCenterUrl = FrsFragment.this.iHB.getBawuCenterUrl();
                        if (!com.baidu.tbadk.core.util.au.isEmpty(bawuCenterUrl) && FrsFragment.this.iHB.getForum() != null) {
                            com.baidu.tbadk.browser.a.startWebActivity(FrsFragment.this.getPageContext().getPageActivity(), bawuCenterUrl);
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10502").dR("fid", FrsFragment.this.iHB.getForum().getId()).dR("uid", FrsFragment.this.iHB.getUserData().getUserId()));
                        }
                    }
                } else if (bh.checkUpIsLogin(FrsFragment.this.getPageContext().getPageActivity())) {
                    TiebaStatic.log(CommonStatisticKey.MY_SERVICE_CK);
                    if (FrsFragment.this.iHB != null && FrsFragment.this.iHB.getForum() != null) {
                        ForumData forum = FrsFragment.this.iHB.getForum();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(forum.getId(), 0L), forum.getName(), forum.getImage_url(), 0)));
                    }
                }
            } else if (bh.checkUpIsLogin(FrsFragment.this.getActivity())) {
                TiebaStatic.log("forum_fortune_click");
                com.baidu.tieba.frs.f.k.c(FrsFragment.this.getPageContext(), FrsFragment.this.iHB);
            }
        }
    };
    private final NoNetworkView.a iFn = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.FrsFragment.41
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (FrsFragment.this.iIw.cDQ() == 1 && z && !FrsFragment.this.iId.cyt()) {
                if (FrsFragment.this.iHB == null || com.baidu.tbadk.core.util.y.isEmpty(FrsFragment.this.iHB.getThreadList())) {
                    FrsFragment.this.hideNetRefreshView(FrsFragment.this.iId.czC().cFN());
                    FrsFragment.this.showLoadingView(FrsFragment.this.iId.cjt(), true);
                    FrsFragment.this.iId.pE(false);
                    FrsFragment.this.refresh();
                    return;
                }
                FrsFragment.this.iId.cza();
            }
        }
    };
    private final CustomMessageListener fed = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.FrsFragment.42
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                com.baidu.tieba.frs.f.c.a(customResponsedMessage, FrsFragment.this.iId, FrsFragment.this.iHB);
            }
        }
    };
    private com.baidu.adp.widget.ListView.ab iJO = new a();
    private av iJP = new av() { // from class: com.baidu.tieba.frs.FrsFragment.44
        @Override // com.baidu.tieba.frs.av
        public void a(int i, int i2, bd bdVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
            com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.44.1
                @Override // java.lang.Runnable
                public void run() {
                    if (FrsFragment.this.iId != null && FrsFragment.this.iId.czu()) {
                        FrsFragment.this.bOb();
                    }
                }
            });
        }
    };
    private CustomMessageListener iJQ = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.frs.FrsFragment.46
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    FrsFragment.this.iIR = true;
                }
            }
        }
    };
    private CustomMessageListener iJR = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.frs.FrsFragment.47
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                    if (FrsFragment.this.iIv == null && FrsFragment.this.iId.cyR() != null && !FrsFragment.this.iId.cyt() && FrsFragment.this.iId.cyR().dww() != null && (FrsFragment.this.iId.cyR().dww().getTag() instanceof com.baidu.card.am)) {
                        FrsFragment.this.iIv = (com.baidu.card.am) FrsFragment.this.iId.cyR().dww().getTag();
                    }
                    if (FrsFragment.this.iIv != null && FrsFragment.this.iIv.tW() != null) {
                        FrsFragment.this.iIv.tW().b(new a.C0096a(3));
                    }
                }
            }
        }
    };
    private CustomMessageListener iJS = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.FrsFragment.48
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.iId != null) {
                FrsFragment.this.iId.FZ();
            }
        }
    };
    private CustomMessageListener iJT = new CustomMessageListener(2921437) { // from class: com.baidu.tieba.frs.FrsFragment.49
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && FrsFragment.this.isResumed()) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (FrsFragment.this.iIf != null) {
                    if (booleanValue) {
                        if (FrsFragment.this.iIy.cGa() != 0 && !FrsFragment.this.iId.czz() && !KuangFloatingFrsCopyLinkViewController.getInstance().isFloatCopyViewShow()) {
                            FrsFragment.this.iIf.show();
                            return;
                        }
                        return;
                    }
                    FrsFragment.this.iIf.hide();
                }
            }
        }
    };
    private CustomMessageListener iJU = new CustomMessageListener(2921462) { // from class: com.baidu.tieba.frs.FrsFragment.54
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && FrsFragment.this.iHB.getToLoadHorseData().intValue() == 1 && FrsFragment.this.mIsLogin) {
                LiveHorseRaceRequestMessage liveHorseRaceRequestMessage = new LiveHorseRaceRequestMessage();
                liveHorseRaceRequestMessage.setForum_id(Long.valueOf(FrsFragment.this.forumId));
                FrsFragment.this.sendMessage(liveHorseRaceRequestMessage);
            }
        }
    };
    private CustomMessageListener iJV = new CustomMessageListener(2001223) { // from class: com.baidu.tieba.frs.FrsFragment.55
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Date)) {
                FrsFragment.this.iJa = (Date) customResponsedMessage.getData();
            }
        }
    };
    private CustomMessageListener iJW = new CustomMessageListener(2921469) { // from class: com.baidu.tieba.frs.FrsFragment.57
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.y) && FrsFragment.this.isResumed()) {
                com.baidu.tbadk.core.data.y yVar = (com.baidu.tbadk.core.data.y) customResponsedMessage.getData();
                if (FrsFragment.this.iJh == null) {
                    FrsFragment.this.iJh = new com.baidu.tieba.frs.broadcast.a(FrsFragment.this.getPageContext());
                }
                if (FrsFragment.this.iHB != null && FrsFragment.this.iHB.getForum() != null && !TextUtils.isEmpty(FrsFragment.this.iHB.getForum().getId())) {
                    FrsFragment.this.iJh.e(yVar.type, FrsFragment.this.iHB.getForum().getId(), FrsFragment.this.iHB.getForum().getName(), yVar.tid);
                }
            }
        }
    };
    private CustomMessageListener iJX = new CustomMessageListener(2921475) { // from class: com.baidu.tieba.frs.FrsFragment.58
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bx bxVar = (bx) customResponsedMessage.getData();
            if (bxVar != null && FrsFragment.this.isResumed()) {
                FrsFragment.this.iIt = bxVar.getTid() + "";
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE_NUMBER);
                httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
                httpMessage.addParam("forum_id", bxVar.getFid());
                MessageManager.getInstance().sendMessage(httpMessage);
            }
        }
    };
    private HttpMessageListener iJY = new HttpMessageListener(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE_NUMBER) { // from class: com.baidu.tieba.frs.FrsFragment.59
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if ((httpResponsedMessage instanceof ForumManagerRightsResMsg) && FrsFragment.this.isResumed()) {
                ForumManagerRightsResMsg forumManagerRightsResMsg = (ForumManagerRightsResMsg) httpResponsedMessage;
                if (forumManagerRightsResMsg.broadcastTotalCount - forumManagerRightsResMsg.broadcastUsedCount <= 0) {
                    new ScreenTopToast(FrsFragment.this.getContext()).Ui(FrsFragment.this.getString(R.string.frs_forum_bawu_send_broadcast_none_tip)).Uk(FrsFragment.this.getString(R.string.frs_recommend_fail_tip_btn)).al(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.59.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("_forumId", FrsFragment.this.iHB.getForum().getId());
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new com.baidu.tieba.tbadkCore.data.m(FrsFragment.this.getContext(), "ForumGradePage", hashMap)));
                        }
                    }).aF((ViewGroup) FrsFragment.this.mRootView.findViewById(R.id.frs));
                    return;
                }
                com.baidu.tbadk.core.util.o oVar = new com.baidu.tbadk.core.util.o(TbadkCoreApplication.getInst());
                oVar.aj(FrsFragment.this.iHB.getForum().getId(), FrsFragment.this.iHB.getForum().getName(), "6");
                oVar.Bj(FrsFragment.this.iIt);
                oVar.start();
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.frs.loadmore.a
    public /* bridge */ /* synthetic */ com.baidu.adp.base.e getPageContext() {
        return super.getPageContext();
    }

    public com.baidu.tieba.frs.entelechy.b.b cxF() {
        return this.iIE;
    }

    public com.baidu.adp.widget.ListView.ab cxG() {
        return this.iJO;
    }

    public com.baidu.tieba.frs.mc.d cxH() {
        return this.iIG;
    }

    public com.baidu.tieba.frs.smartsort.a cxI() {
        return this.iIA;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public FrsModelController cxJ() {
        return this.iIw;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public com.baidu.tieba.frs.mc.c cxK() {
        return this.iIH;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public com.baidu.tieba.frs.vc.h cxL() {
        return this.iIx;
    }

    public FrsTabViewController cxM() {
        return this.iIy;
    }

    public ax cxN() {
        return this.iIC;
    }

    public void pt(boolean z) {
        this.iIZ = z;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public q cxO() {
        return this.iId;
    }

    @Override // com.baidu.tieba.frs.aw
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.aw, com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.iHV;
    }

    public void setForumName(String str) {
        this.iHV = str;
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

    @Override // com.baidu.tieba.recapp.o
    public String getFid() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.recapp.o
    public int getPageNum() {
        if (this.iIH == null) {
            return 1;
        }
        return this.iIH.getPn();
    }

    public int getPn() {
        if (this.iIH == null) {
            return 1;
        }
        return this.iIH.getPn();
    }

    public void setPn(int i) {
        if (this.iIH != null) {
            this.iIH.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.iIH != null) {
            this.iIH.setHasMore(i);
        }
    }

    public int cxP() {
        if (this.iIH == null) {
            return -1;
        }
        return this.iIH.cxP();
    }

    public boolean cxQ() {
        return this.iIb;
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
            this.iId.cyU();
            showNetRefreshView(this.iId.cjt(), string, true);
        } else if (340001 == fVar.errorCode) {
            a(fVar, this.iHB.getRecm_forum_list());
        } else {
            if (com.baidu.tbadk.core.util.y.isEmpty(this.iHB.getThreadList())) {
                b(fVar);
            }
            if (cyv()) {
                setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds280));
            } else {
                setNetRefreshViewEmotionDefMarginTop();
            }
        }
    }

    public void a(View view, String str, boolean z, List<RecmForumInfo> list) {
        this.iId.cyU();
        this.iId.zl(8);
        if (this.iIP == null) {
            this.iIP = new com.baidu.tieba.frs.view.a(getPageContext(), getNetRefreshListener());
        }
        this.iIP.setSubText(str);
        this.iIP.setListData(list);
        this.iIP.attachView(view, z);
    }

    private void a(com.baidu.tieba.tbadkCore.f fVar, List<RecmForumInfo> list) {
        if (this.iId != null) {
            this.iId.cyU();
            this.iId.setTitle(this.iHV);
            a(this.iId.cjt(), fVar.errorMsg, true, list);
        }
    }

    private void b(com.baidu.tieba.tbadkCore.f fVar) {
        this.iId.cyU();
        if (fVar.isc) {
            showNetRefreshView(this.iId.cjt(), TbadkCoreApplication.getInst().getString(R.string.net_error_text, new Object[]{fVar.errorMsg, Integer.valueOf(fVar.errorCode)}), true);
        } else {
            showNetRefreshView(this.iId.czC().cFN(), fVar.errorMsg, true);
        }
    }

    public void cxR() {
        hideLoadingView(this.iId.cjt());
        this.iId.bOA();
        if (this.iId.cyS() instanceof com.baidu.tieba.frs.tab.c) {
            ((com.baidu.tieba.frs.tab.c) this.iId.cyS()).cEy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxS() {
        if (cxP() == 0 && com.baidu.tbadk.core.util.y.isEmpty(this.iHB.getThreadListIds())) {
            if (com.baidu.tbadk.core.util.y.isEmpty(this.iHB.getThreadList())) {
                this.iId.bPp();
            } else {
                this.iId.VA();
            }
        } else if (com.baidu.tbadk.core.util.y.getCount(this.iHB.getThreadList()) > 3) {
            this.iId.Vz();
        } else {
            this.iId.czq();
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
            cxR();
            this.iId.cza();
            com.baidu.tieba.tbadkCore.f cDM = this.iIw.cDM();
            boolean isEmpty = com.baidu.tbadk.core.util.y.isEmpty(this.iHB.getThreadList());
            if (cDM != null && isEmpty) {
                if (this.iIw.cDO() != 0) {
                    this.iIw.cDT();
                    this.iId.cza();
                } else {
                    a(cDM);
                }
                this.iId.Y(this.iHB.isStarForum(), false);
                return;
            }
            a(cDM);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(com.baidu.tieba.tbadkCore.m mVar) {
        if (mVar != null && mVar.getEntelechyTabInfo() != null && mVar.getEntelechyTabInfo().tab != null) {
            for (FrsTabInfo frsTabInfo : mVar.getEntelechyTabInfo().tab) {
                if (frsTabInfo.tab_id.intValue() == 502 && com.baidu.tbadk.core.sharedPref.b.bpu().getBoolean("first_into_tab_profession", true)) {
                    return false;
                }
            }
        }
        return new com.baidu.tieba.frs.ad.f(getTbPageContext()).d(mVar);
    }

    public boolean cxT() {
        return cxU() && !cxV();
    }

    private boolean cxU() {
        if (cys() == null) {
            return false;
        }
        FrsViewData cys = cys();
        com.baidu.tbadk.core.data.z zVar = null;
        if (cys.getStar() != null && !StringUtils.isNull(cys.getStar().dJd())) {
            zVar = new com.baidu.tbadk.core.data.z();
        } else if (cys.getActivityHeadData() != null && com.baidu.tbadk.core.util.y.getCount(cys.getActivityHeadData().bjG()) >= 1) {
            zVar = cys.getActivityHeadData().bjG().get(0);
        }
        return zVar != null;
    }

    public boolean cxV() {
        if (cys() == null) {
            return false;
        }
        FrsViewData cys = cys();
        return (com.baidu.tbadk.core.util.y.isEmpty(cys.getShowTopThreadList()) && cys.getBusinessPromot() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxW() {
        boolean b;
        if (!cxY()) {
            final PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
            privateForumPopInfoData.a(this.iHB.getPrivateForumTotalInfo().getPrivatePopInfo());
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(getActivity());
            if (this.iHB.getPrivateForumTotalInfo().bkz().private_forum_status.intValue() == 1 && (com.baidu.tbadk.core.util.au.isEmpty(privateForumPopInfoData.bkB()) || privateForumPopInfoData.bkE() != Integer.valueOf(this.forumId))) {
                privateForumPopInfoData.Am("create_success");
                privateForumPopInfoData.An(TbadkCoreApplication.getInst().getString(R.string.frs_private_create_hint));
                privateForumPopInfoData.Ao("https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.iHV + "&nomenu=1");
                privateForumPopInfoData.k(Integer.valueOf(this.forumId));
                b = frsPrivateCommonDialogView.b(privateForumPopInfoData);
            } else {
                b = privateForumPopInfoData.bkE() == Integer.valueOf(this.forumId) ? frsPrivateCommonDialogView.b(privateForumPopInfoData) : false;
            }
            if (b) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
                aVar.ov(2);
                aVar.bg(frsPrivateCommonDialogView);
                aVar.iX(false);
                frsPrivateCommonDialogView.setConfirmButton(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.19
                    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.frs.FrsFragment */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        com.baidu.tbadk.core.util.bf.bqF().b(FrsFragment.this.getPageContext(), new String[]{privateForumPopInfoData.bkD()});
                        aVar.dismiss();
                    }
                });
                aVar.a(new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.20
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(getPageContext()).bog();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxX() {
        if (cxY() || this.iHB.getPrivateForumTotalInfo().bkz().private_forum_status.intValue() != 1) {
            a((Integer) null, (Integer) null, true);
        } else {
            a(this.iHB.getPrivateForumTotalInfo().bkz().private_forum_audit_status, this.iHB.getPrivateForumTotalInfo().bkA(), false);
        }
    }

    public void a(Integer num, Integer num2, boolean z) {
        final String str;
        final int i = 2;
        if (this.iId.czg() != null) {
            TextView czg = this.iId.czg();
            if (z) {
                czg.setVisibility(8);
                return;
            }
            if (num.intValue() == 2) {
                czg.setText("修改实名认证信息");
                czg.setVisibility(0);
                str = "https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + this.forumId + "&nomenu=1";
            } else if (num2.intValue() >= 0 && num2.intValue() <= 100) {
                czg.setText("目标已完成" + String.valueOf(num2) + "%");
                czg.setVisibility(0);
                str = "https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.iHV + "&nomenu=1";
                i = 1;
            } else {
                czg.setVisibility(8);
                i = 0;
                str = "";
            }
            czg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.21
                /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13387").dR("fid", FrsFragment.this.forumId).dR("uid", TbadkCoreApplication.getCurrentAccount()).ak("obj_type", i));
                    com.baidu.tbadk.core.util.bf.bqF().b(FrsFragment.this.getPageContext(), new String[]{str});
                }
            });
        }
    }

    private boolean cxY() {
        return this.iHB == null || this.iHB.getPrivateForumTotalInfo() == null || this.iHB.getPrivateForumTotalInfo().bkz() == null || this.iHB.getUserData().getIs_manager() != 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void za(int i) {
        List<WindowToast> list;
        if (TbadkCoreApplication.isLogin() && this.iHB != null && (list = this.iHB.mWindowToast) != null && list.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < list.size()) {
                    WindowToast windowToast = list.get(i3);
                    if (windowToast == null || windowToast.toast_type.intValue() != i) {
                        i2 = i3 + 1;
                    } else if (!com.baidu.tbadk.core.util.au.isEmpty(windowToast.toast_link)) {
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
    public void cxZ() {
        if (getActivity() != null && getActivity().getIntent() != null) {
            String stringExtra = getActivity().getIntent().getStringExtra(FrsActivityConfig.KEY_ACHIEVEMENT_URL);
            if (!TextUtils.isEmpty(stringExtra)) {
                getActivity().getIntent().removeExtra(FrsActivityConfig.KEY_ACHIEVEMENT_URL);
                AchievementActivityConfig achievementActivityConfig = new AchievementActivityConfig(getActivity());
                achievementActivityConfig.setUrl(stringExtra);
                if (this.iHB != null && this.iHB.getForumActiveInfo() != null) {
                    achievementActivityConfig.setShareUrl(this.iHB.getForumActiveInfo().forum_share_url);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, achievementActivityConfig));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cya() {
        if (this.iHB == null || this.iHB.getForum() != null) {
            this.iId.czm();
        } else if (this.iHB.getForum().getYuleData() != null && this.iHB.getForum().getYuleData().bnX()) {
            TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_VIEW);
            this.iId.a(this.iHB.getForum().getYuleData().bnY());
        } else {
            this.iId.czm();
        }
    }

    private void W(boolean z, boolean z2) {
        if (this.iIw != null && this.iHB != null && this.iId != null && z) {
            if (!this.iIw.cEa() && this.iIw.cDQ() == 1) {
                if (!this.iIw.cDY()) {
                    this.iHB.addCardVideoInfoToThreadList();
                    this.iHB.addVideoInfoToThreadListInTenAndFifteenFloor();
                }
                boolean z3 = false;
                if (this.iId.czn().r(com.baidu.tieba.card.data.n.icG)) {
                    z3 = this.iHB.addHotTopicDataToThreadList();
                }
                if (!z3) {
                    this.iHB.addFeedForumDataToThreadList();
                }
                if (TbadkCoreApplication.getInst().isRecAppExist()) {
                    this.iHB.addRecommendAppToThreadList(this);
                }
                if (!this.iId.czn().r(bx.eCp)) {
                    this.iHB.removeAlaLiveThreadData();
                }
                this.iHB.addSchoolRecommendToThreadList();
            }
            if (!this.iId.czn().r(bx.eCp)) {
                this.iHB.removeAlaInsertLiveData();
                this.iHB.removeAlaStageLiveDat();
            } else {
                this.iHB.addInsertLiveDataToThreadList();
                this.iHB.addStageLiveDataToThreadList();
            }
            this.iHB.checkLiveStageInThreadList();
            this.iHB.addNoticeThreadToThreadList();
            if (this.iId.czn().r(com.baidu.tieba.i.b.jql)) {
                this.iHB.addGameRankListToThreadList(z2);
            }
            if (TbadkCoreApplication.isLogin() && (!this.iIw.cEa() || this.iIw.isNetFirstLoad)) {
                this.iHB.addUserRecommendToThreadList();
            }
            this.iHB.addVideoActivityToTop();
        }
    }

    public boolean cyb() {
        if (this.iIx != null && this.iIw != null) {
            this.iIx.a(this.iIw.getPageType(), this.iHB);
        }
        boolean z = false;
        if (this.iHB != null) {
            z = this.iHB.hasTab();
        }
        cye();
        if (this.iId != null) {
            this.iId.czA();
            this.iId.czB();
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zb(int i) {
        ba baVar = null;
        cyb();
        cyn();
        try {
            if (this.iHB != null) {
                this.iId.a((ArrayList<com.baidu.adp.widget.ListView.q>) null, this.iHB);
                this.iIx.AU(1);
                this.iId.czd();
                this.iIy.a(this.iHB, this.iIw.cDV());
                com.baidu.tieba.frs.tab.d Bd = this.iIy.Bd(this.iHB.getFrsDefaultTabId());
                if (Bd != null && !TextUtils.isEmpty(Bd.url)) {
                    baVar = new ba();
                    baVar.ext = Bd.url;
                    baVar.stType = Bd.name;
                }
                this.iIw.a(this.iHB.getFrsDefaultTabId(), 0, baVar);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(boolean z, boolean z2) {
        try {
            if (this.iHB != null && this.iIy != null && this.iIw != null) {
                if (!this.iId.czn().r(bx.eCp)) {
                    this.iHB.removeAlaLiveThreadData();
                }
                boolean isEmpty = com.baidu.tbadk.core.util.y.isEmpty(this.iHB.getGameTabInfo());
                this.iId.pC(isEmpty);
                if (!isEmpty) {
                    if (this.iIQ == null) {
                        this.iIQ = new com.baidu.tieba.frs.vc.e(this, (NoPressedRelativeLayout) this.mRootView);
                    }
                    if (this.gCS == null) {
                        this.gCS = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
                    }
                } else {
                    this.iIQ = null;
                    this.gCS = null;
                }
                if (this.iHB.getForum() != null) {
                    this.iHV = this.iHB.getForum().getName();
                    this.forumId = this.iHB.getForum().getId();
                }
                if (this.iHB.hasTab()) {
                    this.iIy.a(this.iHB, this.iIw.cDV());
                }
                if (z) {
                    W(true, z);
                } else {
                    W(this.iIr, z);
                }
                cyb();
                if (this.iIE != null) {
                    this.iIE.a(this.iIx, this.iHB);
                }
                if (this.iHB.getPage() != null) {
                    setHasMore(this.iHB.getPage().bks());
                }
                ArrayList<com.baidu.adp.widget.ListView.q> a2 = this.iIH.a(z2, true, this.iHB.getThreadList(), null, z, false);
                if (a2 != null) {
                    this.iHB.setThreadList(a2);
                }
                this.iHB.removeRedundantUserRecommendData();
                this.iHD = this.iHB.getTopThreadSize();
                if (this.iHZ != null) {
                    this.iHY = true;
                    this.iHZ.Kb(this.iHD);
                    com.baidu.tieba.frs.f.a.a(this, this.iHB.getForum(), this.iHB.getThreadList(), this.iHY, getPn());
                }
                if (this.iIw.cDQ() == 1) {
                    cyi();
                    if (!z && this.iIw.getPn() == 1) {
                        cyd();
                    }
                }
                if (this.iIF != null) {
                    this.iIF.cM(this.iIy.cFW());
                }
                cxR();
                this.iId.cyV();
                this.iId.Y(true, false);
                if (z && this.iHB.isFirstTabEqualAllThread()) {
                    com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.22
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!FrsFragment.this.iIo && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                FrsFragment.this.iId.czy();
                            }
                        }
                    });
                }
                if (this.iHB.getForum() != null) {
                    this.iId.JS(this.iHB.getForum().getWarningMsg());
                }
                if (this.iHB != null && this.iHB.getFrsVideoActivityData() != null && com.baidu.tbadk.core.sharedPref.b.bpu().getLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 0L) == 0) {
                    com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.24
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsFragment.this.iId.czw();
                        }
                    }, 1000L);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FRS_SHOW_AR_ENTRY, this));
                this.iId.cyP();
                if (this.iHB != null && this.iHB.getForum() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ENTER_FORUM, new VisitedForumData(this.iHB.getForum().getId(), this.iHB.getForum().getName(), this.iHB.getForum().getImage_url(), String.valueOf(System.currentTimeMillis() / 1000), ConstantData.Forum.SPECAIL_FORUM_TYPE_LIVE.equals(this.iHB.getForum().special_forum_type), this.iHB.getForum().getThemeColorInfo(), this.iHB.getForum().getMember_num())));
                }
                this.iIU.a(this.iHB.bottomMenuList, this.iHB.getForum());
                cyC();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void cyc() {
        if (this.iIw != null && this.iIw.cDQ() == 1) {
            this.iIx.k(this.iHB);
        }
    }

    public void pu(boolean z) {
        com.baidu.tieba.t.c.dIO().b(getUniqueId(), z);
    }

    public void cyd() {
        if (this.iIK == null) {
            this.iIK = new com.baidu.tieba.frs.live.a(this, com.baidu.adp.lib.f.b.toInt(this.forumId, 0));
        }
        this.iIK.cDx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.tbadkCore.m mVar) {
        try {
            if (!this.iIo && mVar != null && this.iHB != null) {
                this.iHB.receiveData(mVar);
                X(true, false);
                Looper.myQueue().addIdleHandler(this.iJj);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void cye() {
        if (this.iIw != null) {
            JR(this.iIw.getPageType());
        } else {
            JR("normal_page");
        }
    }

    private void JR(String str) {
        pv("frs_page".equals(str));
        if (this.iIE != null) {
            this.iIE.a(this.iIx, this.iId, this.iHB);
        }
    }

    public void pv(boolean z) {
        if (this.iII != null) {
            this.iII.cFI();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.t.c.dIO().z(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.frs_activity, viewGroup, false);
            this.iHP = new com.baidu.tieba.frs.entelechy.a();
            this.iIE = this.iHP.cBj();
            this.iHO = TbadkCoreApplication.getInst().getString(R.string.frs_title_new_area);
            this.iIx = new com.baidu.tieba.frs.vc.h(this, this.iHP, (FrsHeaderViewContainer) this.mRootView.findViewById(R.id.header_view_container));
            this.iIy = new FrsTabViewController(this, this.mRootView);
            this.iIy.registerListener();
            this.iIx.a(this.iIy);
            this.iIy.a(this.iJr);
            Intent intent = getActivity().getIntent();
            if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                this.iHR = true;
            }
            this.iId = new q(this, this.iJM, this.iHP, this.iHR, this.iIx);
            this.iIU = new com.baidu.tieba.frs.brand.buttommenu.a(getPageContext(), this.mRootView);
        } else {
            if (this.mRootView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            if (this.iIy != null) {
                this.iIy.registerListener();
            }
            this.iId.czv();
            this.mRootView.setLeft(0);
            this.mRootView.setRight(com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getContext()));
        }
        this.iIY = true;
        this.fur = System.currentTimeMillis() - currentTimeMillis;
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        ArrayList<com.baidu.adp.widget.ListView.q> arrayList = null;
        this.ikF = System.currentTimeMillis();
        long j = this.ikF;
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.iIa = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.ikF = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            R(intent);
        }
        this.fuq = j - this.ikF;
        this.iHZ = new com.baidu.tieba.tbadkCore.data.f("frs", com.baidu.tieba.tbadkCore.data.f.mXi);
        if (this.iIw == null) {
            this.iIw = new FrsModelController(this, this.iJH);
            this.iIw.a(this.iJq);
            this.iIw.init();
        }
        this.iIw.setSchemeUrl(this.mSchemeUrl);
        if (intent != null) {
            this.iIw.aj(intent.getExtras());
        } else if (bundle != null) {
            this.iIw.aj(bundle);
        } else {
            this.iIw.aj(null);
        }
        if (intent != null) {
            this.iIx.aq(intent.getExtras());
        } else if (bundle != null) {
            this.iIx.aq(bundle);
        } else {
            this.iIx.aq(null);
        }
        this.iIc = getVoiceManager();
        this.iIL = new p(getPageContext(), this);
        initUI();
        initData(bundle);
        if (!cyv()) {
            this.iIC = new ax(getActivity(), this.iId, this.iIx);
            this.iIC.pR(true);
        }
        this.iIc = getVoiceManager();
        if (this.iIc != null) {
            this.iIc.onCreate(getPageContext());
        }
        if (FrsActivityConfig.FRS_FROM_FLUTTER_BCASTEDIT.equals(getFrom()) && !this.hasInit) {
            int i = com.baidu.tbadk.core.sharedPref.b.bpu().getInt("key_forum_broadcast_edit_tip_number", 0);
            if (i < 2) {
                com.baidu.tbadk.core.sharedPref.b.bpu().putInt("key_forum_broadcast_edit_tip_number", i + 1);
                cyk();
            } else if (Build.VERSION.SDK_INT >= 23) {
                if (Settings.canDrawOverlays(getContext())) {
                    cyl();
                } else {
                    new BdTopToast(getContext()).yr(false).Ue(getContext().getString(R.string.forum_broadcast_copy_no_permission_hint)).aF(this.iId.cjt());
                }
            } else {
                cyl();
            }
        }
        if (KuangFloatingFrsCopyLinkViewController.getInstance().isFloatCopyViewShow()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
            if (this.iIe != null) {
                this.iIe.setVisibility(8);
            }
        }
        new com.baidu.tieba.frs.mc.i();
        int i2 = -1;
        if (this.iIH != null && this.iIH.cDI() != null) {
            i2 = this.iIH.cDI().cxP();
            arrayList = this.iIH.cDI().getDataList();
        }
        this.iIH = new com.baidu.tieba.frs.mc.c(this, this.iJK);
        this.iIH.cDI().setHasMore(i2);
        if (arrayList != null && arrayList.size() > 0) {
            this.iIH.cDI().aG(arrayList);
        }
        this.iIA = new com.baidu.tieba.frs.smartsort.a(this);
        this.iII = new com.baidu.tieba.frs.vc.j(this);
        this.iIF = new com.baidu.tieba.frs.vc.a(getPageContext(), this.iIw.cDX());
        this.iIB = new com.baidu.tieba.frs.mc.b(this);
        this.iIG = new com.baidu.tieba.frs.mc.d(this);
        this.iIz = new com.baidu.tieba.frs.mc.h(this);
        this.iIJ = new com.baidu.tieba.frs.mc.a(this);
        this.iIM = new com.baidu.tieba.frs.vc.c(this);
        this.iIN = new com.baidu.tieba.frs.mc.e(this, getUniqueId());
        this.iIS = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "frs");
        this.iIT = new com.baidu.tieba.ala.a(getPageContext());
        this.iIV = new com.baidu.tieba.frs.sportspage.notification.a(getPageContext());
        registerListener(this.iJz);
        registerListener(this.mMemListener);
        registerListener(this.iJx);
        registerListener(this.iJL);
        registerListener(this.iJI);
        registerListener(this.iJt);
        registerListener(this.iJu);
        registerListener(this.iJv);
        registerListener(this.iJw);
        registerListener(this.iJk);
        registerListener(this.iJl);
        registerListener(this.agD);
        registerListener(this.iJm);
        registerListener(this.iJQ);
        registerListener(this.iJB);
        registerListener(this.iJp);
        registerListener(this.iJC);
        registerListener(this.iJA);
        registerListener(this.iJE);
        registerListener(this.iJF);
        registerListener(this.iJG);
        this.iJR.setTag(getPageContext().getUniqueId());
        MessageManager.getInstance().registerListener(this.iJR);
        registerListener(this.iJS);
        registerListener(this.iJT);
        registerListener(this.iJU);
        registerListener(this.iJo);
        registerListener(this.iJV);
        registerListener(this.iJD);
        registerListener(this.iJn);
        registerListener(this.iJW);
        registerListener(this.iJX);
        registerListener(this.iJY);
        this.iId.pE(false);
        if (!cyv() && !this.hasInit) {
            showLoadingView(this.iId.cjt(), true);
            this.iIw.T(3, false);
        }
        ay ayVar = new ay() { // from class: com.baidu.tieba.frs.FrsFragment.27
            @Override // com.baidu.tieba.frs.ay
            public void d(boolean z, boolean z2, int i3) {
                if (FrsFragment.this.iId != null) {
                    if (i3 == 1) {
                        FrsFragment.this.iId.zm(z ? 0 : 8);
                    } else if (i3 == 2) {
                        FrsFragment.this.iId.zo(z ? 0 : 8);
                    }
                    if (!z2) {
                        FrsFragment.this.iIX = z;
                    }
                    if (FrsFragment.this.iId.czn() != null && (i3 == 2 || (FrsFragment.this.iIw != null && FrsFragment.this.iIw.cDR()))) {
                        FrsFragment.this.iId.czn().notifyDataSetChanged();
                    }
                    if (FrsFragment.this.cxM() != null) {
                        FrsTabViewController.b cFX = FrsFragment.this.cxM().cFX();
                        if (cFX != null) {
                            if ((cFX.fragment instanceof FrsCommonTabFragment) && (i3 == 2 || cFX.tabId == 502)) {
                                ((FrsCommonTabFragment) cFX.fragment).cAZ();
                            } else if ((cFX.fragment instanceof FrsNewAreaFragment) && (i3 == 2 || cFX.tabId == 503)) {
                                FrsNewAreaFragment frsNewAreaFragment = (FrsNewAreaFragment) cFX.fragment;
                                frsNewAreaFragment.cAZ();
                                if (frsNewAreaFragment.cEi() != null) {
                                    com.baidu.tieba.frs.mc.g cEi = frsNewAreaFragment.cEi();
                                    cEi.pT(!z);
                                    if (i3 == 1) {
                                        cEi.pH(!z);
                                    } else if (i3 == 2) {
                                        cEi.pH(true);
                                    }
                                }
                            } else if (cFX.fragment instanceof FrsGoodFragment) {
                                ((FrsGoodFragment) cFX.fragment).cAZ();
                            }
                        }
                        if (FrsFragment.this.cxM().cFO() != null) {
                            FrsFragment.this.cxM().cFO().setmDisallowSlip(z);
                            FrsFragment.this.cxM().qy(z);
                        }
                    }
                    if (FrsFragment.this.iId.cyT() != null) {
                        FrsFragment.this.iId.pB(!z);
                    }
                    if (FrsFragment.this.getActivity() instanceof FrsActivity) {
                        ((FrsActivity) FrsFragment.this.getActivity()).ps(!z);
                    }
                    if (FrsFragment.this.iIU != null) {
                        FrsFragment.this.iIU.pZ(!z);
                    }
                    FrsFragment.this.iId.pG(!z);
                    if (i3 == 1) {
                        FrsFragment.this.iId.pH(z ? false : true);
                    } else if (i3 == 2) {
                        FrsFragment.this.iId.pH(true);
                    }
                }
            }

            @Override // com.baidu.tieba.frs.ay
            public void cm(int i3, int i4) {
                if (FrsFragment.this.iId != null) {
                    if (i4 == 1) {
                        FrsFragment.this.iId.zn(i3);
                    } else if (i4 == 2) {
                        FrsFragment.this.iId.zp(i3);
                    }
                }
            }

            @Override // com.baidu.tieba.frs.ay
            public void zf(int i3) {
                if (FrsFragment.this.getContext() != null) {
                    if (i3 == 1) {
                        com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getContext(), R.string.frs_multi_delete_max_num);
                    } else if (i3 == 2 && FrsFragment.this.iId != null) {
                        new BdTopToast(FrsFragment.this.getContext()).yr(false).Ue(FrsFragment.this.getContext().getString(R.string.frs_move_area_max_num)).aF(FrsFragment.this.iId.cjt());
                    }
                }
            }
        };
        b.cwO().a(ayVar);
        com.baidu.tieba.frs.a.cwH().a(ayVar);
        this.iId.b(new d.a() { // from class: com.baidu.tieba.frs.FrsFragment.28
            @Override // com.baidu.tieba.NEGFeedBack.d.a
            public void a(DeleteThreadHttpResponseMessage deleteThreadHttpResponseMessage) {
                boolean z;
                int i3 = 0;
                if (deleteThreadHttpResponseMessage != null) {
                    FrsFragment.this.iId.bHP();
                    FrsFragment.this.iId.czx();
                    FrsNewAreaFragment frsNewAreaFragment = null;
                    if (FrsFragment.this.iIy == null || FrsFragment.this.iIy.cFX() == null || !(FrsFragment.this.iIy.cFX().fragment instanceof FrsNewAreaFragment)) {
                        z = false;
                    } else {
                        frsNewAreaFragment = (FrsNewAreaFragment) FrsFragment.this.iIy.cFX().fragment;
                        z = true;
                    }
                    if (deleteThreadHttpResponseMessage.getError() == 0) {
                        String text = !TextUtils.isEmpty(deleteThreadHttpResponseMessage.getText()) ? deleteThreadHttpResponseMessage.getText() : FrsFragment.this.getString(R.string.delete_fail);
                        if (deleteThreadHttpResponseMessage.getRetType() == 1211066) {
                            if (FrsFragment.this.iaS == null) {
                                FrsFragment.this.iaS = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.iaS.AJ(text);
                            FrsFragment.this.iaS.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.28.1
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.iaS.iX(false);
                            FrsFragment.this.iaS.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.iaS.bog();
                        } else if (deleteThreadHttpResponseMessage.getRetType() == 1211067) {
                            if (FrsFragment.this.iaS == null) {
                                FrsFragment.this.iaS = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.iaS.AJ(text);
                            FrsFragment.this.iaS.a(R.string.know, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.28.2
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.iaS.iX(false);
                            FrsFragment.this.iaS.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.iaS.bog();
                        } else {
                            FrsFragment.this.iId.aO(deleteThreadHttpResponseMessage.getText(), ContextCompat.getColor(FrsFragment.this.getContext(), deleteThreadHttpResponseMessage.getRetType() == 1 ? R.color.nav_bar_tip_error : R.color.cp_link_tip_a_alpha95));
                        }
                        if (z && frsNewAreaFragment != null) {
                            frsNewAreaFragment.dp(deleteThreadHttpResponseMessage.getSuccessItems());
                        }
                        FrsFragment.this.dd(deleteThreadHttpResponseMessage.getSuccessItems());
                        b.cwO().dc(deleteThreadHttpResponseMessage.getSuccessItems());
                        for (com.baidu.adp.widget.ListView.q qVar : FrsFragment.this.iHB.getThreadList()) {
                            if (qVar instanceof bw) {
                                i3++;
                                continue;
                            }
                            if (i3 >= 6) {
                                break;
                            }
                        }
                        if (i3 < 6) {
                            FrsFragment.this.bOb();
                            return;
                        }
                        return;
                    }
                    com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getActivity(), deleteThreadHttpResponseMessage.getErrorString());
                }
            }
        });
        this.dHY = UtilHelper.getScreenHeight(getActivity());
        this.hasInit = true;
        zc(1);
        super.onActivityCreated(bundle);
        this.createTime = System.currentTimeMillis() - j;
    }

    public void pw(boolean z) {
        if (this.iIy != null) {
            this.iIy.jkF = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dd(List<String> list) {
        if (!com.baidu.tbadk.core.util.y.isEmpty(list)) {
            ArrayList<com.baidu.adp.widget.ListView.q> threadList = this.iHB.getThreadList();
            if (!com.baidu.tbadk.core.util.y.isEmpty(threadList) && this.iId.getListView() != null && this.iId.getListView().getData() != null) {
                Iterator<com.baidu.adp.widget.ListView.q> it = threadList.iterator();
                List<com.baidu.adp.widget.ListView.q> data = this.iId.getListView().getData();
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.q next = it.next();
                    if (next instanceof bw) {
                        bx bxVar = ((bw) next).evQ;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= list.size()) {
                                break;
                            } else if (!com.baidu.tbadk.core.util.au.equals(list.get(i2), bxVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.iIH.d(next);
                                this.iId.getListView().getAdapter().notifyItemRemoved(i);
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
    public void cwM() {
        if (!com.baidu.tbadk.core.util.y.isEmpty(com.baidu.tieba.frs.a.cwH().cwL()) && this.iId.getListView() != null && this.iId.getListView().getData() != null) {
            ArrayList<com.baidu.adp.widget.ListView.q> threadList = this.iHB.getThreadList();
            if (!com.baidu.tbadk.core.util.y.isEmpty(threadList)) {
                Iterator<com.baidu.adp.widget.ListView.q> it = threadList.iterator();
                List<com.baidu.adp.widget.ListView.q> data = this.iId.getListView().getData();
                int count = com.baidu.tbadk.core.util.y.getCount(com.baidu.tieba.frs.a.cwH().cwL());
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.q next = it.next();
                    if (next instanceof bw) {
                        bx bxVar = ((bw) next).evQ;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= count) {
                                break;
                            } else if (!com.baidu.tbadk.core.util.au.equals(com.baidu.tieba.frs.a.cwH().cwL().get(i2).getId(), bxVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.iIH.d(next);
                                this.iId.getListView().getAdapter().notifyItemRemoved(i);
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
    public void bOv() {
        if (isAdded() && this.glO && !isLoadingViewAttached()) {
            showLoadingView(this.iId.cjt(), true);
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void bOw() {
        if (isAdded() && this.glO && isLoadingViewAttached()) {
            hideLoadingView(this.iId.cjt());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (cyv()) {
            showLoadingView(this.iId.cjt(), true);
            this.iId.zq(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.iIw.S(3, true);
            bsq().scrollToPosition(0);
        }
    }

    private void zc(int i) {
        String str = "";
        if (this.iHB != null && this.iHB.getForum() != null) {
            str = this.iHB.getForum().getId();
        }
        if (!StringUtils.isNull(str)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13008").dR("fid", str).dR("obj_type", "4").ak("obj_locate", i).dR("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.z zVar) {
        if (zVar != null) {
            this.fyn = zVar.bDj();
            this.iIO = zVar.bDk();
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void showFloatingView() {
        if (this.fyn != null) {
            this.fyn.showFloatingView(true);
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
                this.iHV = uri.getQueryParameter("name");
                this.mFrom = uri.getQueryParameter("from");
                if (!StringUtils.isNull(this.iHV)) {
                    intent.putExtra("name", this.iHV);
                }
                if (!StringUtils.isNull(this.mFrom)) {
                    intent.putExtra("from", this.mFrom);
                }
                TiebaStatic.log(TbadkCoreStatisticKey.AS_INVOKE_TIEBA);
            }
            if (StringUtils.isNull(this.iHV) && uri != null) {
                if (com.baidu.tbadk.BdToken.f.p(uri)) {
                    com.baidu.tbadk.BdToken.f.bfS().b(uri, this.iJJ);
                } else {
                    com.baidu.tieba.frs.f.f U = com.baidu.tieba.frs.f.k.U(intent);
                    if (U != null) {
                        this.iHV = U.forumName;
                        if (U.jim == null || U.jim.equals("aidou")) {
                        }
                    }
                }
                if (!StringUtils.isNull(this.iHV)) {
                    intent.putExtra("name", this.iHV);
                }
                intent.putExtra(FrsActivityConfig.FRS_CALL_FROM, 12);
            }
        }
    }

    /* renamed from: com.baidu.tieba.frs.FrsFragment$29  reason: invalid class name */
    /* loaded from: classes21.dex */
    class AnonymousClass29 implements f.a {
        AnonymousClass29() {
        }

        @Override // com.baidu.tbadk.BdToken.f.a
        public void onCallBack(final HashMap<String, Object> hashMap) {
            if (hashMap != null) {
                if (hashMap.get(com.baidu.tbadk.BdToken.f.eqb) instanceof String) {
                    FrsFragment.this.iHV = (String) hashMap.get(com.baidu.tbadk.BdToken.f.eqb);
                }
                if ((hashMap.get(com.baidu.tbadk.BdToken.f.eqt) instanceof String) && !TextUtils.isEmpty((String) hashMap.get(com.baidu.tbadk.BdToken.f.eqt))) {
                    com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.29.1
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsFragment.this.iIy.tE(301);
                            final long j = com.baidu.adp.lib.f.b.toLong((String) hashMap.get(com.baidu.tbadk.BdToken.f.eqc), 0L);
                            final int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
                            final int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
                            final float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                            final int i = 1;
                            if (com.baidu.tbadk.core.util.av.bqC().bqD()) {
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
        this.iIc = getVoiceManager();
        if (this.iIc != null) {
            this.iIc.onStart(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        Intent intent;
        long j = 0;
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.fed);
        if (bundle != null) {
            this.iHV = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            j = bundle.getLong(FrsActivityConfig.FRS_FAKE_THREAD_ID, 0L);
        } else if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
            this.iHV = intent.getStringExtra("name");
            this.mFrom = intent.getStringExtra("from");
            this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
            j = intent.getLongExtra(FrsActivityConfig.FRS_FAKE_THREAD_ID, 0L);
        }
        if (getArguments() != null) {
            this.iHW = getArguments().getBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, false);
        }
        if (TextUtils.isEmpty(this.mFrom) || FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
        }
        if (this.mIsLogin) {
            registerListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL, this.fed);
        }
        this.iIx.aq(bundle);
        fH(j);
    }

    private void fH(final long j) {
        if (j > 0) {
            final int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
            final int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
            final float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            final int i = 1;
            if (com.baidu.tbadk.core.util.av.bqC().bqD()) {
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
        com.baidu.tieba.t.c.dIO().A(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.iJQ);
        this.iII.destroy();
        iIh = null;
        if (this.iIc != null) {
            this.iIc.onDestory(getPageContext());
        }
        com.baidu.tieba.recapp.report.a.remove("FRS");
        this.iIc = null;
        com.baidu.tieba.card.t.cnT().oB(false);
        if (this.iHB != null && this.iHB.getForum() != null) {
            ak.czX().fI(com.baidu.adp.lib.f.b.toLong(this.iHB.getForum().getId(), 0L));
        }
        if (this.iIK != null) {
            this.iIK.onDestory();
        }
        if (this.iId != null) {
            com.baidu.tieba.frs.f.j.a(this.iId, this.iHB, getForumId(), false, null);
            this.iId.onDestroy();
        }
        if (this.iIg != null) {
            this.iIg.removeAllViews();
            this.iIg.setVisibility(8);
        }
        if (this.iJe != null) {
            this.iJe.cancel();
        }
        if (this.iJf != null) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.iJf);
        }
        this.iJd = null;
        super.onDestroy();
        try {
            if (this.iIq != null) {
                this.iIq.bBC();
            }
            if (this.iId != null) {
                this.iId.release();
            }
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.iIx.cDp();
        Looper.myQueue().removeIdleHandler(this.iJj);
        if (this.iIw != null) {
            this.iIw.bVo();
        }
        if (this.iIC != null) {
            this.iIC.cAf();
        }
        if (this.iIF != null) {
            this.iIF.destory();
        }
        if (this.iIA != null) {
            this.iIA.onDestroy();
        }
        if (this.iIQ != null) {
            this.iIQ.onDestory();
        }
        if (this.iIJ != null) {
            this.iIJ.onDestroy();
        }
        if (this.iIS != null) {
            this.iIS.onDestroy();
        }
        if (this.iIT != null) {
            this.iIT.onDestroy();
        }
        com.baidu.tieba.recapp.d.a.dAG().dAJ();
        com.baidu.tieba.frs.f.l.cEQ();
        if (this.iIy != null) {
            this.iIy.a((FrsTabViewController.a) null);
            this.iIy.cFZ();
        }
        if (this.iIW != null) {
            this.iIW.onDestroy();
        }
        b.cwO().a(null);
        com.baidu.tieba.frs.a.cwH().a(null);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.iHV);
        bundle.putString("from", this.mFrom);
        this.iIw.onSaveInstanceState(bundle);
        if (this.iIc != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            this.iIc.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.iIJ != null) {
            this.iIJ.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.iId != null) {
            this.iId.cza();
            this.iId.onResume();
        }
        this.iIz.qq(true);
        this.iIr = true;
        if (iHU) {
            iHU = false;
            if (this.iId != null) {
                this.iId.startPullRefresh();
                return;
            }
            return;
        }
        if (this.iIc != null) {
            this.iIc.onResume(getPageContext());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_RESUME));
        if (this.iId != null) {
            this.iId.pI(false);
        }
        if (this.iIR) {
            refresh(6);
            this.iIR = false;
        }
        if (this.iJa != null && getActivity() != null) {
            if (NotificationManagerCompat.from(getActivity()).areNotificationsEnabled()) {
                com.baidu.tbadk.coreExtra.messageCenter.f.bwh().setSignAlertOn(true);
                com.baidu.tbadk.coreExtra.messageCenter.f.bwh().setSignAlertTime(this.iJa.getHours(), this.iJa.getMinutes());
                if (this.iId != null) {
                    com.baidu.tbadk.coreExtra.messageCenter.f.bwh().a(getTbPageContext().getPageActivity(), this.iId.cjt());
                }
            }
            this.iJa = null;
        }
        cyC();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
    }

    public boolean cyf() {
        Intent intent;
        if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
            return false;
        }
        return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
    }

    public void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.iHV = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.iHX = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.iHX) {
                cyg();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyg() {
        this.iId.startPullRefresh();
    }

    public void closeActivity() {
        com.baidu.tieba.frs.f.k.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.mFrom);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.iId.setTitle(this.iHV);
        } else {
            this.iId.setTitle("");
            this.mFlag = 1;
        }
        this.iId.a(this.iJO);
        this.iId.addOnScrollListener(this.mScrollListener);
        this.iId.g(this.iFn);
        this.iId.czn().a(this.iJN);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.iIY) {
            this.iId.onChangeSkinType(i);
            this.iIx.AT(i);
            this.iIy.onChangeSkinType(i);
            if (this.iIf != null) {
                this.iIf.onChangeSkinType(i);
            }
            if (this.iIP != null) {
                this.iIP.onChangeSkinType();
            }
            if (this.iIU != null) {
                this.iIU.onChangeSkinType(getPageContext(), i);
            }
            if (this.iaS != null) {
                com.baidu.tbadk.r.a.a(getPageContext(), this.iaS.getRealView());
            }
            if (this.iIQ != null) {
                this.iIQ.onChangeSkinType(getPageContext(), i);
            }
        }
    }

    public void zd(int i) {
        if (!this.mIsLogin) {
            if (this.iHB != null && this.iHB.getAnti() != null) {
                this.iHB.getAnti().setIfpost(1);
            }
            if (i == 0) {
                bh.skipToLoginActivity(getActivity());
            }
        } else if (this.iHB != null) {
            if (i == 0) {
                com.baidu.tieba.frs.f.l.g(this, 0);
            } else {
                this.iId.czc();
            }
        }
    }

    public void refresh() {
        com.baidu.tieba.a.d.bIl().Ez("page_frs");
        refresh(3);
    }

    public void refresh(int i) {
        this.iIo = false;
        cyn();
        if (this.iId != null && this.iId.cyR() != null) {
            this.iId.cyR().cJS();
        }
        if (this.iIw != null) {
            this.iIw.S(i, true);
        }
    }

    private void cyh() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.f.h.mZ().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.35
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.SG(FrsFragment.this.iHV);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyi() {
        cyn();
        try {
            if (this.iHB != null) {
                this.iId.bUJ();
                this.iId.pB(cyB());
                if (!com.baidu.tieba.frs.vc.h.n(this.iHB) || !com.baidu.tieba.frs.vc.h.m(this.iHB)) {
                }
                if (this.iHB.getForum() != null) {
                    this.iHV = this.iHB.getForum().getName();
                    this.forumId = this.iHB.getForum().getId();
                }
                if (this.iHB.getPage() != null) {
                    setHasMore(this.iHB.getPage().bks());
                }
                this.iId.setTitle(this.iHV);
                this.iId.setForumName(this.iHV);
                TbadkCoreApplication.getInst().setDefaultBubble(this.iHB.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.iHB.getUserData().getBimg_end_time());
                cyh();
                cyj();
                ArrayList<com.baidu.adp.widget.ListView.q> threadList = this.iHB.getThreadList();
                if (threadList != null) {
                    this.iId.a(threadList, this.iHB);
                    com.baidu.tieba.frs.f.c.A(this.iId);
                    this.iIx.AU(getPageNum());
                    this.iIx.j(this.iHB);
                    this.iIy.a(this.iHB, this.iIw.cDV());
                    this.iId.czd();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void cyj() {
        if (this.iHB != null) {
            if (this.iHB.getIsNewUrl() == 1) {
                this.iId.czn().setFromCDN(true);
            } else {
                this.iId.czn().setFromCDN(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.iIz.qq(false);
        this.iIr = false;
        this.iId.onPause();
        if (this.iIc != null) {
            this.iIc.onPause(getPageContext());
        }
        this.iId.pI(true);
        if (this.iIF != null) {
            this.iIF.cET();
        }
        com.baidu.tbadk.BdToken.c.bfy().bfJ();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.iIy != null && this.iIy.cFX() != null && (this.iIy.cFX().fragment instanceof BaseFragment)) {
            ((BaseFragment) this.iIy.cFX().fragment).setPrimary(z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.t.cnT().oB(false);
        pu(false);
        if (this.iHB != null && this.iHB.getForum() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            com.baidu.tbadk.distribute.a.byA().b(getPageContext().getPageActivity(), "frs", this.iHB.getForum().getId(), 0L);
        }
        if (this.iIc != null) {
            this.iIc.onStop(getPageContext());
        }
        if (bsq() != null) {
            bsq().getRecycledViewPool().clear();
        }
        this.iIx.brC();
        com.baidu.tbadk.util.aa.bDm();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            if (this.iIx != null) {
                this.iIx.bS(isPrimary());
            }
            if (this.iId != null) {
                this.iId.bS(isPrimary());
                this.iId.pI(!isPrimary());
            }
        }
    }

    private void cyk() {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.ov(2);
        aVar.iX(false);
        FrsBroadcastCopyGuideDialogView frsBroadcastCopyGuideDialogView = new FrsBroadcastCopyGuideDialogView(getPageContext().getPageActivity());
        frsBroadcastCopyGuideDialogView.setConfirmButtonListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.36
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aVar != null) {
                    aVar.dismiss();
                    FrsFragment.this.cyl();
                }
            }
        });
        aVar.bg(frsBroadcastCopyGuideDialogView);
        aVar.b(getPageContext()).bog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyl() {
        if (KuangFloatingFrsCopyLinkViewController.getInstance().init()) {
            ((BaseFragmentActivity) getPageContext().getOrignalPage()).grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.frs.FrsFragment.37
                @Override // com.baidu.tbadk.core.e
                public void onPermissionResult(boolean z) {
                    if (!z) {
                        new BdTopToast(FrsFragment.this.getContext()).yr(false).Ue(FrsFragment.this.getContext().getString(R.string.forum_broadcast_copy_no_permission_hint)).aF(FrsFragment.this.iId.cjt());
                        return;
                    }
                    KuangFloatingFrsCopyLinkViewController.getInstance().showFloatingView(true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921473, 0));
                    if (FrsFragment.this.iIe != null) {
                        FrsFragment.this.iIe.setVisibility(8);
                    }
                }
            }, true);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (b.cwO().cwI()) {
                b.cwO().reset();
                return true;
            } else if (com.baidu.tieba.frs.a.cwH().cwI()) {
                if (this.iId != null && this.iId.czs()) {
                    this.iId.czt();
                    return true;
                }
                com.baidu.tieba.frs.a.cwH().reset();
                return true;
            } else if (this.iId != null) {
                return this.iId.cyZ();
            }
        } else if (i == 24) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921381, keyEvent));
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.o
    public TbPageContext<?> getTbPageContext() {
        return getPageContext();
    }

    @Override // com.baidu.tieba.recapp.o
    public void a(AdvertAppInfo advertAppInfo, String str) {
        com.baidu.tbadk.distribute.a.byA().a(advertAppInfo, this.forumId, 0L, "FRS", str, getPn());
    }

    @Override // com.baidu.tieba.recapp.o
    public void cym() {
        cxJ().cym();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.iIc == null) {
            this.iIc = VoiceManager.instance();
        }
        return this.iIc;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdRecyclerView bsq() {
        if (this.iId == null) {
            return null;
        }
        return this.iId.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void cyn() {
        if (this.iIc != null) {
            this.iIc.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> bsr() {
        if (this.eWZ == null) {
            this.eWZ = UserIconBox.u(getPageContext().getPageActivity(), 8);
        }
        return this.eWZ;
    }

    public void cyo() {
        if (getFragmentActivity() != null && getFragmentActivity().getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.t onGetPreLoadListView() {
        return bsq().getPreLoadHandle();
    }

    @Override // com.baidu.tieba.frs.at
    public NavigationBar bSa() {
        if (this.iId == null) {
            return null;
        }
        return this.iId.bSa();
    }

    public FRSRefreshButton cyp() {
        return this.iIf;
    }

    public void c(LinearLayout linearLayout) {
        if (linearLayout != null) {
            this.iIg = linearLayout;
        }
    }

    public void a(FRSRefreshButton fRSRefreshButton) {
        if (fRSRefreshButton != null) {
            this.iIf = fRSRefreshButton;
            this.iIf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.43
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (FrsFragment.this.iIy != null) {
                        FrsTabViewController.b cFX = FrsFragment.this.iIy.cFX();
                        if (cFX != null && cFX.fragment != null && (cFX.fragment instanceof as)) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                            ((as) cFX.fragment).cxv();
                            ((as) cFX.fragment).bPo();
                            return;
                        }
                        FrsFragment.this.cxO().startPullRefresh();
                    }
                }
            });
        }
    }

    public void cyq() {
        if (this.iIf != null) {
            this.iIf.hide();
        }
    }

    public void cyr() {
        if (this.iIf != null) {
            this.iIf.show();
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
                if (bdUniqueId == w.iLR) {
                    if (FrsFragment.this.iId != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11752").dR("fid", FrsFragment.this.forumId).dR("obj_locate", "1"));
                        FrsFragment.this.iId.startPullRefresh();
                    }
                } else if (qVar != null && (qVar instanceof bw)) {
                    bx bxVar = ((bw) qVar).evQ;
                    if (bxVar.bmE() == null || bxVar.bmE().getGroup_id() == 0 || bh.checkUpIsLogin(FrsFragment.this.getActivity())) {
                        if (bxVar.bmp() != 1 || bh.checkUpIsLogin(FrsFragment.this.getActivity())) {
                            if (bxVar.blO() != null) {
                                if (bh.checkUpIsLogin(FrsFragment.this.getActivity())) {
                                    String postUrl = bxVar.blO().getPostUrl();
                                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.isNetOk()) {
                                        com.baidu.tbadk.browser.a.startInternalWebActivity(FrsFragment.this.getActivity(), postUrl);
                                    }
                                }
                            } else if (bxVar.bmP() != null) {
                                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                    bh.skipToLoginActivity(FrsFragment.this.getPageContext().getPageActivity());
                                    return;
                                }
                                com.baidu.tbadk.core.data.s bmP = bxVar.bmP();
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), bmP.getCartoonId(), bmP.getChapterId(), 2)));
                            } else {
                                com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                                if (readThreadHistory != null && !readThreadHistory.SM(bxVar.getId())) {
                                    readThreadHistory.SL(bxVar.getId());
                                }
                                boolean z = false;
                                final String blI = bxVar.blI();
                                if (blI != null && !blI.equals("")) {
                                    z = true;
                                    new Thread(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.a.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            com.baidu.tbadk.core.util.aa aaVar = new com.baidu.tbadk.core.util.aa(blI);
                                            aaVar.bqa().bqH().mIsNeedAddCommenParam = false;
                                            aaVar.bqa().bqH().mIsUseCurrentBDUSS = false;
                                            aaVar.getNetData();
                                        }
                                    }).start();
                                }
                                String tid = bxVar.getTid();
                                if (tid == null) {
                                    tid = "";
                                }
                                if (bxVar.blx() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                    com.baidu.tbadk.core.util.bf.bqF().b(FrsFragment.this.getPageContext(), new String[]{tid, "", null});
                                    return;
                                }
                                if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && tid.length() > 4) {
                                    bxVar.setId(tid.substring(3));
                                }
                                if (bdUniqueId.getId() == bx.eDS.getId()) {
                                    com.baidu.tieba.frs.f.j.a(bxVar.bli());
                                } else if (bdUniqueId.getId() == bx.eCt.getId()) {
                                    com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                                    arVar.dR("obj_type", "2");
                                    arVar.dR("tid", bxVar.getTid());
                                    TiebaStatic.log(arVar);
                                }
                                com.baidu.tieba.frs.f.k.a(FrsFragment.this, bxVar, i, z);
                                com.baidu.tieba.frs.f.j.a(FrsFragment.this, FrsFragment.this.iHB, bxVar);
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
            hideNetRefreshView(this.iId.czC().cFN());
            showLoadingView(this.iId.cjt(), true);
            this.iId.pE(false);
            this.iIw.S(3, true);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData cys() {
        return this.iHB;
    }

    public boolean cyt() {
        return this.iId.cyt();
    }

    public void aJ(Object obj) {
        if (this.iIB != null && this.iIB.jdE != null) {
            this.iIB.jdE.callback(obj);
        }
    }

    public void aK(Object obj) {
        if (this.iIB != null && this.iIB.jdF != null) {
            this.iIB.jdF.callback(obj);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        this.iId.getListView().stopScroll();
        if (!this.iId.czj()) {
            if (!com.baidu.adp.lib.util.l.isNetOk()) {
                this.iId.bPp();
            } else if (this.iIw.cDQ() == 1) {
                bOq();
                bOb();
            } else if (this.iIw.hasMore()) {
                bOb();
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void onFailed(String str) {
        bOq();
        showToast(str);
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void ay(ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        boolean isEmpty = com.baidu.tbadk.core.util.y.isEmpty(arrayList);
        setHasMore(isEmpty ? 0 : 1);
        bOq();
        if (!isEmpty) {
            if (!this.iIw.cEa() && TbadkCoreApplication.getInst().isRecAppExist() && this.iIw.cDQ() == 1) {
                this.iHB.addRecommendAppToThreadList(this, arrayList);
            }
            if (this.iIw != null) {
                com.baidu.tieba.frs.d.a.a(getUniqueId(), arrayList, this.iHB.getForum(), this.iIw.getSortType());
            }
            ArrayList<com.baidu.adp.widget.ListView.q> a2 = this.iIH.a(false, false, arrayList, this.iHZ, false);
            if (a2 != null) {
                this.iHB.setThreadList(a2);
                this.iId.a(a2, this.iHB);
            }
            if (this.iIw != null) {
                com.baidu.tieba.frs.d.c.a(this.iHB, this.iIw.cDV(), 2, getContext());
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.iHB.getForum()));
        }
    }

    private void bOq() {
        if (cxP() == 1 || this.iIH.m41do(this.iHB.getThreadListIds())) {
            if (com.baidu.tbadk.core.util.y.getCount(this.iHB.getThreadList()) > 3) {
                this.iId.Vz();
            } else {
                this.iId.czq();
            }
        } else if (com.baidu.tbadk.core.util.y.isEmpty(this.iHB.getThreadList())) {
            this.iId.bPp();
        } else {
            this.iId.VA();
        }
    }

    @Override // com.baidu.tieba.frs.mc.l
    public void bOb() {
        if (this.iIH != null) {
            this.iIH.a(this.iHV, this.forumId, this.iHB);
        }
    }

    public void cyu() {
        if (!com.baidu.tbadk.core.util.ae.requestWriteExternalStorgeAndCameraPermission(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.ao.g(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment, com.baidu.m.a.a.InterfaceC0248a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        com.baidu.tieba.frs.f.k.a(this, i, strArr, iArr);
    }

    public void px(boolean z) {
        if (this.iIC != null) {
            this.iIC.pR(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.iID.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a ty(int i) {
        return this.iID.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        this.iIL.b(bVar);
    }

    public boolean cyv() {
        return this.iHR;
    }

    @Override // com.baidu.tieba.frs.aq
    public void Tc() {
        if (this.iId != null) {
            showFloatingView();
            this.iId.getListView().scrollToPosition(0);
            this.iId.startPullRefresh();
        }
    }

    public ForumWriteData cyw() {
        if (this.iHB == null || this.iHB.getForum() == null) {
            return null;
        }
        ForumData forum = this.iHB.getForum();
        ForumWriteData forumWriteData = new ForumWriteData(forum.getId(), forum.getName(), forum.getPrefixData(), this.iHB.getAnti());
        forumWriteData.avatar = forum.getImage_url();
        forumWriteData.forumLevel = forum.getUser_level();
        forumWriteData.specialForumType = forum.special_forum_type;
        forumWriteData.firstDir = forum.getFirst_class();
        forumWriteData.secondDir = forum.getSecond_class();
        UserData userData = this.iHB.getUserData();
        forumWriteData.privateThread = userData != null ? userData.getPrivateThread() : 0;
        forumWriteData.frsTabInfo = cyx();
        return forumWriteData;
    }

    private FrsTabInfoData cyx() {
        int i;
        if (this.iIw == null || this.iHB == null || this.iIy == null) {
            return null;
        }
        if (this.iHB.getEntelechyTabInfo() == null || com.baidu.tbadk.core.util.y.isEmpty(this.iHB.getEntelechyTabInfo().tab)) {
            return null;
        }
        int cGb = this.iIy.cGb();
        if (cGb == 502) {
            return null;
        }
        int i2 = -1;
        ArrayList arrayList = new ArrayList();
        Iterator<FrsTabInfo> it = this.iHB.getEntelechyTabInfo().tab.iterator();
        while (true) {
            i = i2;
            if (!it.hasNext()) {
                break;
            }
            FrsTabInfo next = it.next();
            if (next != null && next.is_general_tab.intValue() == 1) {
                arrayList.add(new FrsTabItemData(next));
                if (cGb == next.tab_id.intValue()) {
                    i2 = cGb;
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
    public void brT() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void py(boolean z) {
        this.iIs = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z) {
        this.iId.zl(8);
        ((FrsActivity) getActivity()).showLoadingView(view, z);
        ((FrsActivity) getActivity()).k(view, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        this.iId.zl(0);
        ((FrsActivity) getActivity()).hideLoadingView(view);
        ((FrsActivity) getActivity()).k(view, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        super.showNetRefreshView(view, getResources().getString(R.string.refresh_view_title_text), null, getResources().getString(R.string.refresh_view_button_text), z, getNetRefreshListener());
        this.iId.zl(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshViewNoClick(View view, String str, boolean z) {
        super.showNetRefreshViewNoClick(view, str, z);
        this.iId.zl(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        super.hideNetRefreshView(view);
        this.iId.zl(0);
    }

    public void cyy() {
        FrsTabViewController.b cFX;
        if (this.iIy != null && (cFX = this.iIy.cFX()) != null && cFX.fragment != null && (cFX.fragment instanceof as)) {
            ((as) cFX.fragment).cxv();
        }
    }

    public void pz(boolean z) {
        this.iHT = z;
    }

    public void b(OvalActionButton ovalActionButton) {
        this.iIe = ovalActionButton;
    }

    public OvalActionButton cyz() {
        return this.iIe;
    }

    public boolean cyA() {
        return this.iHT;
    }

    public void onShareSuccess(String str) {
        if (TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.util.au.isEmpty(str)) {
            if (this.iIW == null) {
                this.iIW = new AddExperiencedModel(getTbPageContext());
            }
            this.iIW.gi(this.forumId, str);
        }
    }

    public boolean cyB() {
        if (this.iIs && !this.iIZ) {
            return (this.iIw != null && this.iIw.cDR() && (b.cwO().cwI() || com.baidu.tieba.frs.a.cwH().cwI())) ? false : true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.f.b
    public boolean videoNeedPreload() {
        if (this.iHB != null) {
            return com.baidu.tbadk.util.ah.st(2) || (com.baidu.tbadk.util.ah.bDu() && this.iHB.isFrsVideoAutoPlay);
        }
        return super.videoNeedPreload();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyC() {
        if (!com.baidu.tbadk.core.util.au.isEmpty(this.forumId)) {
            com.baidu.tbadk.BdToken.c.bfy().q(com.baidu.tbadk.BdToken.b.eox, com.baidu.adp.lib.f.b.toLong(this.forumId, 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyD() {
        String format;
        String str;
        if (isResumed() && this.iJd != null && this.iJd.size() >= 1 && this.iJc <= this.iJd.size() - 1) {
            final LiveHorseRaceData liveHorseRaceData = this.iJd.get(this.iJc);
            if (System.currentTimeMillis() / 1000 >= liveHorseRaceData.getRob_end_tm().longValue()) {
                this.iJc++;
                cyD();
            }
            if (this.iIg != null) {
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
                        if (FrsFragment.this.iHB == null) {
                            str2 = "";
                        } else if (FrsFragment.this.iHB.getForum() != null) {
                            str2 = FrsFragment.this.iHB.getForum().getName();
                        } else {
                            str2 = "";
                        }
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13744").ak("obj_source", 1).dR("fid", FrsFragment.this.forumId).dR("fname", str2));
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
                this.iJe = ValueAnimator.ofFloat(1.0f, 0.0f);
                this.iJe.setDuration(600L);
                this.iJe.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.FrsFragment.51
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        if (valueAnimator.isRunning()) {
                            frsRedpackRunView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                            frsRedpackRunView.setTranslationX(-(TbadkApplication.getInst().getContext().getResources().getDimensionPixelOffset(R.dimen.tbds850) * valueAnimator.getAnimatedFraction()));
                        }
                    }
                });
                this.iJe.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.FrsFragment.52
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        frsRedpackRunView.setAlpha(0.0f);
                        frsRedpackRunView.setTranslationY(TbadkApplication.getInst().getContext().getResources().getDimensionPixelOffset(R.dimen.tbds660));
                        frsRedpackRunView.hide();
                        FrsFragment.this.iIg.removeView(frsRedpackRunView);
                        if (FrsFragment.this.iJd == null || FrsFragment.this.iJc <= FrsFragment.this.iJd.size() - 1) {
                            FrsFragment.this.cyD();
                            return;
                        }
                        FrsFragment.this.iIg.removeAllViews();
                        FrsFragment.this.iIg.setVisibility(8);
                        FrsFragment.this.iJc = 0;
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        onAnimationEnd(animator);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                this.iJf = new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.53
                    @Override // java.lang.Runnable
                    public void run() {
                        if (FrsFragment.this.iIg != null && frsRedpackRunView != null) {
                            FrsFragment.this.iJe.start();
                        }
                    }
                };
                com.baidu.adp.lib.f.e.mY().postDelayed(this.iJf, 5000L);
                if (this.iIg.getChildCount() == 0) {
                    this.iJc++;
                    this.iIg.addView(frsRedpackRunView);
                    if (this.iHB != null) {
                        str = this.iHB.getForum() != null ? this.iHB.getForum().getName() : "";
                    } else {
                        str = "";
                    }
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13743").ak("obj_source", 1).dR("fid", this.forumId).dR("fname", str));
                }
                if (this.iIg.getVisibility() == 8 && ((BaseFragment) this.iIy.cFX().fragment).isPrimary() && !this.iId.czz() && !this.iIm) {
                    this.iIg.setVisibility(0);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        FrsTabViewController.b cFX;
        if (cxM() == null || (cFX = cxM().cFX()) == null || !(cFX.fragment instanceof BaseFragment)) {
            return null;
        }
        if (cFX.fragment instanceof FrsAllThreadFragment) {
            TbPageTag tbPageTag = super.getTbPageTag();
            int i = -1;
            if (this.iHB != null) {
                i = this.iHB.getSortType();
            }
            tbPageTag.sortType = com.baidu.tieba.frs.f.i.AR(i);
            tbPageTag.locatePage = "a070";
            if (this.iHO.equals(cFX.title)) {
                tbPageTag.locatePage = "a071";
            }
            return tbPageTag;
        } else if (cFX.fragment instanceof FrsFragment) {
            return null;
        } else {
            return ((BaseFragment) cFX.fragment).getTbPageTag();
        }
    }

    public void cyE() {
        if (this.iHB != null) {
            com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
            if (this.iHB.needLog == 1) {
                bVar.jgm = true;
            } else {
                bVar.jgm = false;
            }
            if (this.iHB.getForum() != null) {
                bVar.jgo = this.iHB.getForum().getId();
            }
            if (cxJ() != null) {
                bVar.jgn = cxJ().cDV();
            }
            if (com.baidu.tieba.frs.d.d.iRY != null) {
                bVar.jgp = com.baidu.tieba.frs.d.d.iRY.jgp;
                bVar.jgq = com.baidu.tieba.frs.d.d.iRY.jgq;
            }
            this.iJg = new com.baidu.tieba.frs.live.b(bVar, getTbPageTag(), getUniqueId());
            this.iJg.Au(this.iJi);
            CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_CARD_CLICK, this.iJg);
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
            CustomMessageTask customMessageTask2 = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW, this.iJg);
            customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask2);
            CustomMessageTask customMessageTask3 = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_USER_CLICK, this.iJg);
            customMessageTask3.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask3);
            CustomMessageTask customMessageTask4 = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_VIDEO_CLICK, this.iJg);
            customMessageTask4.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask4);
        }
    }
}
