package com.baidu.tieba.frs;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.card.a.a;
import com.baidu.k.a.a;
import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.baidu.tbadk.BdToken.f;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CreateBarGuideActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.core.atomData.MessageCenterActivityConfig;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.PrivateForumPopInfoData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
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
import com.baidu.tieba.frs.a;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.frs.mc.FrsNewAreaFragment;
import com.baidu.tieba.frs.vc.FrsTabViewController;
import com.baidu.tieba.frs.view.FrsHeaderViewContainer;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.e;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsPage.RecmForumInfo;
import tbclient.FrsTabInfo;
import tbclient.WindowToast;
/* loaded from: classes9.dex */
public class FrsFragment extends BaseFragment implements BdListView.e, a.InterfaceC0078a, UserIconBox.b<BdRecyclerView>, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, af, ai, ak, com.baidu.tieba.frs.loadmore.a, com.baidu.tieba.frs.mc.l, com.baidu.tieba.recapp.n {
    public static com.baidu.tieba.tbadkCore.l goC;
    private com.baidu.tbadk.util.y dHb;
    private com.baidu.adp.lib.d.b<TbImageView> djp;
    private com.baidu.tieba.frs.gametab.b eCs;
    private com.baidu.tbadk.core.dialog.a fMc;
    private OvalActionButton goA;
    private FRSRefreshButton goB;
    public long goD;
    private com.baidu.card.af goO;
    private FrsModelController goP;
    private com.baidu.tieba.frs.vc.h goQ;
    private FrsTabViewController goR;
    private com.baidu.tieba.frs.mc.h goS;
    private com.baidu.tieba.frs.smartsort.a goT;
    private com.baidu.tieba.frs.mc.b goU;
    private al goV;
    private com.baidu.tieba.frs.entelechy.b.b goX;
    private com.baidu.tieba.frs.vc.a goY;
    private com.baidu.tieba.frs.mc.d goZ;
    private com.baidu.tieba.frs.entelechy.a gol;
    private com.baidu.tieba.tbadkCore.data.f gov;
    private VoiceManager goy;
    private int gpA;
    private com.baidu.tieba.frs.mc.c gpa;
    private com.baidu.tieba.frs.vc.j gpb;
    private com.baidu.tieba.frs.mc.a gpc;
    private com.baidu.tieba.frs.live.a gpd;
    private k gpe;
    public com.baidu.tieba.frs.vc.c gpf;
    private com.baidu.tieba.frs.mc.e gpg;
    private View.OnTouchListener gph;
    private com.baidu.tieba.frs.view.a gpi;
    private com.baidu.tieba.frs.view.c gpj;
    private com.baidu.tieba.frs.vc.e gpk;
    private boolean gpl;
    private com.baidu.tieba.NEGFeedBack.a gpm;
    private com.baidu.tieba.ala.a gpn;
    private com.baidu.tieba.frs.brand.buttommenu.a gpo;
    private com.baidu.tieba.frs.sportspage.notification.a gpp;
    private AddExperiencedModel gpq;
    private boolean gps;
    private View mRootView;
    public static boolean goq = false;
    public static volatile long goF = 0;
    public static volatile long goG = 0;
    public static volatile int mNetError = 0;
    private String gok = "";
    public boolean gom = false;
    private boolean gon = false;
    private boolean goo = false;
    private boolean gop = true;
    public String gor = null;
    public String mFrom = null;
    public int mFlag = 0;
    public boolean gos = false;
    private boolean got = false;
    private String mThreadId = null;
    public String forumId = null;
    private int gob = 0;
    private boolean gou = false;
    private boolean gow = false;
    private boolean gox = false;
    private l goz = null;
    public final bj NQ = null;
    private FrsViewData gnZ = new FrsViewData();
    public long fVt = -1;
    public long dDR = 0;
    public long dDJ = 0;
    public long createTime = 0;
    public long beginTime = -1;
    public long goE = 0;
    public boolean goH = false;
    private boolean goI = false;
    private boolean goJ = false;
    public com.baidu.tbadk.n.b goK = null;
    private boolean goL = true;
    private boolean goM = true;
    private a.C0052a goN = new a.C0052a(2);
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> goW = new SparseArray<>();
    private boolean eoi = true;
    private boolean hasInit = false;
    private boolean gpr = false;
    private boolean gpt = false;
    private int cdw = 0;
    private int gpu = 0;
    public int mHeadLineDefaultNavTabId = -1;
    private final CustomMessageListener gpv = new CustomMessageListener(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED) { // from class: com.baidu.tieba.frs.FrsFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof bj) {
                    com.baidu.tieba.frs.f.h.a(FrsFragment.this.goz, FrsFragment.this.gnZ, FrsFragment.this.getForumId(), true, (bj) data);
                }
            }
        }
    };
    private CustomMessageListener gpw = new CustomMessageListener(CmdConfigCustom.CMD_CLOSE_GAME_RANK_CARD) { // from class: com.baidu.tieba.frs.FrsFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.gnZ != null) {
                FrsFragment.this.gnZ.removeGameRankListFromThreadList();
                if (FrsFragment.this.goz != null) {
                    FrsFragment.this.goz.asN();
                }
            }
        }
    };
    private CustomMessageListener KN = new CustomMessageListener(2921401) { // from class: com.baidu.tieba.frs.FrsFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && FrsFragment.this.goB != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() <= 0 || FrsFragment.this.goR.bLc() == 0 || FrsFragment.this.goR.bKZ() == null || !(FrsFragment.this.goR.bKZ().fragment instanceof BaseFragment) || !((BaseFragment) FrsFragment.this.goR.bKZ().fragment).isPrimary() || FrsFragment.this.goz.bFq()) {
                    if (FrsFragment.this.goR.bLc() != 0) {
                        FrsFragment.this.goB.hide();
                        return;
                    }
                    return;
                }
                FrsFragment.this.goB.show();
            }
        }
    };
    private CustomMessageListener gpx = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.FrsFragment.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 1) {
                    FrsFragment.this.bEg();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                }
            }
        }
    };
    private final aj gpy = new aj() { // from class: com.baidu.tieba.frs.FrsFragment.39
        @Override // com.baidu.tieba.frs.aj
        public void a(int i, int i2, aq aqVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
            FrsFragment.this.bDT();
            if (FrsFragment.this.goX != null) {
                FrsFragment.this.goQ.mg(FrsFragment.this.goX.tk(i));
            }
            e.b bVar = new e.b();
            if (aqVar != null) {
                bVar.isSuccess = aqVar.errCode == 0;
                bVar.errorCode = aqVar.errCode;
                bVar.errorMsg = aqVar.errMsg;
                if (bVar.isSuccess) {
                    if (com.baidu.tbadk.core.util.v.isEmpty(arrayList)) {
                        FrsFragment.this.goz.bdu();
                    } else if (aqVar.hasMore) {
                        if (com.baidu.tbadk.core.util.v.getCount(FrsFragment.this.gnZ.getThreadList()) > 3) {
                            FrsFragment.this.goz.bds();
                        } else {
                            FrsFragment.this.goz.bFj();
                        }
                    } else if (aqVar.gsG) {
                        FrsFragment.this.goz.bdt();
                    } else {
                        FrsFragment.this.goz.bdu();
                    }
                }
            } else {
                aqVar = new aq();
                aqVar.pn = 1;
                aqVar.hasMore = false;
                aqVar.gsG = false;
            }
            if (i == 1) {
                FrsFragment.this.goL = true;
                FrsFragment.this.gpM.a(FrsFragment.this.goP.getType(), false, bVar);
            } else {
                FrsFragment.this.a(bVar);
                if (FrsFragment.this.goP.bIN() != null) {
                    FrsFragment.this.gnZ = FrsFragment.this.goP.bIN();
                }
                FrsFragment.this.bEi();
            }
            if (FrsFragment.this.gpT != null) {
                FrsFragment.this.gpT.a(i, i2, aqVar, arrayList);
            }
        }
    };
    private FrsTabViewController.a gpz = new FrsTabViewController.a() { // from class: com.baidu.tieba.frs.FrsFragment.40
        @Override // com.baidu.tieba.frs.vc.FrsTabViewController.a
        public void mA(int i) {
            boolean z = false;
            if (i != 1) {
                com.baidu.tieba.card.r.bvh().kp(false);
                FrsFragment.this.le(false);
            }
            if (i == 502) {
                FrsFragment.this.goA.setIconFade(R.drawable.btn_frs_professional_edit_n);
            } else {
                FrsFragment.this.goA.setIconFade(0);
            }
            FrsFragment.this.gpA = i;
            FrsFragment.this.bEl();
            com.baidu.tieba.frs.d.d.gwC.gJB = i;
            com.baidu.tieba.frs.d.d.gwC.gJC = -1;
            com.baidu.tieba.frs.a bCW = com.baidu.tieba.frs.a.bCW();
            if (i == 1 && FrsFragment.this.gpr) {
                z = true;
            }
            bCW.I(z, true);
        }
    };
    private CustomMessageListener gpB = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIVE_COUNT) { // from class: com.baidu.tieba.frs.FrsFragment.41
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                FrsFragment.this.goR.us(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    };
    private CustomMessageListener gpC = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_LIVE_START) { // from class: com.baidu.tieba.frs.FrsFragment.42
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && ((Integer) customResponsedMessage.getData()).intValue() == 51 && FrsFragment.this.gnZ != null) {
                com.baidu.tieba.frs.f.j.a(FrsFragment.this.gnZ, FrsFragment.this.getPageContext());
            }
        }
    };
    private final CustomMessageListener gpD = new CustomMessageListener(CmdConfigCustom.CMD_FRS_SELECT_ALA_LIVE_TAB) { // from class: com.baidu.tieba.frs.FrsFragment.43
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                FrsFragment.this.goR.uq(49);
            }
        }
    };
    private final CustomMessageListener gpE = new CustomMessageListener(CmdConfigCustom.CMD_FRS_EXPERIENCE_TIP) { // from class: com.baidu.tieba.frs.FrsFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.t) && FrsFragment.this.gnZ != null) {
                FrsFragment.this.gnZ.updateLikeData((com.baidu.tieba.tbadkCore.t) customResponsedMessage.getData());
                FrsFragment.this.goQ.i(FrsFragment.this.gnZ);
                FrsFragment.this.goR.a(FrsFragment.this.gnZ, FrsFragment.this.goP.bJq());
            }
        }
    };
    private final AntiHelper.a gpF = new AntiHelper.a() { // from class: com.baidu.tieba.frs.FrsFragment.3
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).X("obj_locate", at.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).X("obj_locate", at.a.LOCATE_LIKE_PERSON));
        }
    };
    private CustomMessageListener gpG = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.FrsFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(FrsFragment.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().doi != null) {
                        if (AntiHelper.a(FrsFragment.this.getActivity(), updateAttentionMessage.getData().doi, FrsFragment.this.gpF) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).X("obj_locate", at.a.LOCATE_LIKE_PERSON));
                        }
                    } else if (updateAttentionMessage.getData().isSucc && updateAttentionMessage.getData().isAttention) {
                        com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getPageContext().getPageActivity(), (int) R.string.attention_success);
                    }
                }
            }
        }
    };
    private CustomMessageListener gpH = new CustomMessageListener(2921346) { // from class: com.baidu.tieba.frs.FrsFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsFragment.this.refresh();
        }
    };
    private CustomMessageListener gpI = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.frs.FrsFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                FrsFragment.this.goz.c((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener gpJ = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_REMIND) { // from class: com.baidu.tieba.frs.FrsFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewsRemindMessage newsRemindMessage;
            if (customResponsedMessage != null && (customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626 && (newsRemindMessage = (NewsRemindMessage) customResponsedMessage) != null) {
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (FrsFragment.this.goz != null) {
                    FrsFragment.this.goz.D(notificationCount, z);
                }
            }
        }
    };
    private final CustomMessageListener gpK = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.frs.FrsFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.isResumed()) {
                FrsFragment.this.bEz();
            }
        }
    };
    private CustomMessageListener gpL = new CustomMessageListener(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER) { // from class: com.baidu.tieba.frs.FrsFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (FrsFragment.this.goz != null) {
                    FrsFragment.this.goz.setExpanded(booleanValue);
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.p gpM = new com.baidu.tieba.tbadkCore.p() { // from class: com.baidu.tieba.frs.FrsFragment.10
        private long startTime = 0;

        @Override // com.baidu.tieba.tbadkCore.p
        public void sG(int i) {
            this.startTime = System.nanoTime();
            if (FrsFragment.this.goz != null) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsFragment.this.goz.bEU();
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

        @Override // com.baidu.tieba.tbadkCore.p
        public void a(int i, boolean z, e.b bVar) {
            if (FrsFragment.this.eoi) {
                FrsFragment.this.eoi = false;
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.goz, FrsFragment.this.gnZ, FrsFragment.this.getForumId(), false, null);
            }
            FrsFragment.this.bDT();
            FrsFragment.this.goI = true;
            if (bVar != null && bVar.isSuccess) {
                FrsFragment.this.goz.bFg().lO(com.baidu.tbadk.core.util.ar.aGD().aGE());
                FrsFragment.goF = 0L;
                FrsFragment.goG = 0L;
                FrsFragment.mNetError = 0;
            } else {
                FrsFragment.mNetError = 1;
            }
            if (!FrsFragment.this.goP.bJu() && (i == 3 || i == 6)) {
                FrsFragment.this.gpa.resetData();
            }
            FrsFragment.this.goD = System.currentTimeMillis();
            if (FrsFragment.this.goP.bIN() != null) {
                FrsFragment.this.gnZ = FrsFragment.this.goP.bIN();
            }
            FrsFragment.this.goz.b(FrsFragment.this.gnZ.getRedpacketRainData());
            FrsFragment.this.sC(1);
            if (i == 7) {
                FrsFragment.this.sD(FrsFragment.this.gnZ.getFrsDefaultTabId());
                return;
            }
            if (FrsFragment.this.gnZ.getPage() != null) {
                FrsFragment.this.setHasMore(FrsFragment.this.gnZ.getPage().aBk());
            }
            if (i == 4) {
                if (!FrsFragment.this.goP.bJu() && TbadkCoreApplication.getInst().isRecAppExist() && FrsFragment.this.goP.bJl() == 1) {
                    FrsFragment.this.gnZ.addRecommendAppToThreadList(FrsFragment.this);
                }
                ArrayList<com.baidu.adp.widget.ListView.m> a2 = FrsFragment.this.gpa.a(false, false, FrsFragment.this.gnZ.getThreadList(), FrsFragment.this.gov, false);
                if (a2 != null) {
                    FrsFragment.this.gnZ.setThreadList(a2);
                    FrsFragment.this.gnZ.checkLiveStageInThreadList();
                }
                if (FrsFragment.this.goP != null) {
                    com.baidu.tieba.frs.d.c.a(FrsFragment.this.gnZ, FrsFragment.this.goP.bJq(), 2, FrsFragment.this.getContext());
                }
                com.baidu.tieba.frs.f.a.a(FrsFragment.this, FrsFragment.this.gnZ.getForum(), FrsFragment.this.gnZ.getThreadList(), false, FrsFragment.this.getPn());
                FrsFragment.this.goz.a(a2, FrsFragment.this.gnZ);
                FrsFragment.this.bDU();
                return;
            }
            FrsFragment.this.bDU();
            switch (i) {
                case 1:
                    FrsFragment.this.goz.bEU();
                    break;
                case 2:
                    FrsFragment.this.goz.bEU();
                    break;
                case 3:
                case 6:
                    if (FrsFragment.this.gnZ != null) {
                        FrsFragment.this.gnZ.clearPostThreadCount();
                    }
                    if (FrsFragment.this.gpf != null) {
                        FrsFragment.this.gpf.refresh();
                        break;
                    }
                    break;
            }
            FrsFragment.this.bEb();
            if (bVar == null || bVar.errorCode == 0) {
                if (FrsFragment.this.gnZ != null) {
                    FrsFragment.this.a(FrsFragment.this.gnZ);
                    FrsFragment.this.L(false, i == 5);
                    if (FrsFragment.this.goP != null) {
                        if (FrsFragment.this.gnZ.getActivityHeadData() != null && FrsFragment.this.gnZ.getActivityHeadData().aAx() != null && FrsFragment.this.gnZ.getActivityHeadData().aAx().size() > 0) {
                            com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), 1, FrsFragment.this.gnZ.getForum(), FrsFragment.this.goP.getSortType(), 1);
                        }
                        if (FrsFragment.this.gnZ.getThreadList() != null && FrsFragment.this.gnZ.getThreadList().size() > 0) {
                            Iterator<com.baidu.adp.widget.ListView.m> it = FrsFragment.this.gnZ.getThreadList().iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    com.baidu.adp.widget.ListView.m next = it.next();
                                    if ((next instanceof bj) && ((bj) next).getType() == bj.cTe) {
                                        com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), 1, FrsFragment.this.gnZ.getForum(), FrsFragment.this.goP.getSortType(), 2);
                                    }
                                }
                            }
                        }
                        com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), FrsFragment.this.gnZ.getThreadList(), FrsFragment.this.gnZ.getForum(), FrsFragment.this.goP.getSortType());
                    }
                    FrsFragment.this.goz.sP(i);
                    FrsFragment.goF = (System.nanoTime() - this.startTime) / TimeUtils.NANOS_PER_MS;
                    if (bVar != null) {
                        FrsFragment.goG = bVar.keu;
                    }
                } else {
                    return;
                }
            } else if (FrsFragment.this.gnZ == null || com.baidu.tbadk.core.util.v.isEmpty(FrsFragment.this.gnZ.getThreadList())) {
                FrsFragment.this.a(bVar);
            } else if (bVar.fZC) {
                FrsFragment.this.showToast(FrsFragment.this.getPageContext().getResources().getString(R.string.net_error_text, bVar.errorMsg, Integer.valueOf(bVar.errorCode)));
            }
            FrsFragment.this.bDY();
            FrsFragment.this.bDZ();
            if (FrsFragment.this.gnZ.getAccessFlag() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11384"));
            }
            if (FrsFragment.this.gow && FrsFragment.this.goR.uq(49)) {
                FrsFragment.this.gow = false;
            }
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.p
        public void c(com.baidu.tieba.tbadkCore.l lVar) {
            if ((lVar != null && ("normal_page".equals(FrsFragment.this.goP.getPageType()) || "frs_page".equals(FrsFragment.this.goP.getPageType()) || "book_page".equals(FrsFragment.this.goP.getPageType()))) || "brand_page".equals(FrsFragment.this.goP.getPageType())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE, lVar));
                FrsFragment.this.b(lVar);
                FrsFragment.goC = lVar;
            }
        }
    };
    private final CustomMessageListener gpN = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.frs.FrsFragment.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.m) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                FrsFragment.this.gnZ.updateCurrentUserPendant((com.baidu.tbadk.data.m) customResponsedMessage.getData());
                FrsFragment.this.goz.bFg().notifyDataSetChanged();
            }
        }
    };
    private final CustomMessageListener mMemListener = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_MEM) { // from class: com.baidu.tieba.frs.FrsFragment.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && FrsFragment.this.gnZ != null && (userData = FrsFragment.this.gnZ.getUserData()) != null) {
                userData.setIsMem(num.intValue());
                if (num.intValue() != 0) {
                    FrsFragment.this.goQ.k(num);
                }
            }
        }
    };
    private final com.baidu.tieba.frs.mc.k gpO = new com.baidu.tieba.frs.mc.k() { // from class: com.baidu.tieba.frs.FrsFragment.22
        @Override // com.baidu.tieba.frs.mc.k
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.m> arrayList, boolean z3) {
            if (FrsFragment.this.goT != null && FrsFragment.this.goP != null && FrsFragment.this.goP.bJu() && z && !z2 && !z3) {
                FrsFragment.this.goT.tQ(i2);
            }
        }
    };
    public final View.OnTouchListener drN = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.FrsFragment.24
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (FrsFragment.this.gph != null) {
                FrsFragment.this.gph.onTouch(view, motionEvent);
            }
            if (FrsFragment.this.goV != null && FrsFragment.this.goV.bFM() != null) {
                FrsFragment.this.goV.bFM().onTouchEvent(motionEvent);
            }
            if (FrsFragment.this.eCs != null) {
                FrsFragment.this.eCs.c(view, motionEvent);
            }
            if (FrsFragment.this.goQ != null) {
                FrsFragment.this.goQ.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private final CustomMessageListener gpP = new CustomMessageListener(CmdConfigCustom.CMD_GOTOLIVE_HOST_UPGRADE) { // from class: com.baidu.tieba.frs.FrsFragment.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.aFD().getInt(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.PHOTOLIVE_HOSTLEVEL, -1) != -1 && FrsFragment.this.gnZ.getForum() != null) {
                FrsFragment.this.gnZ.getForum().setCanAddPhotoLivePost(true);
            }
        }
    };
    public final View.OnClickListener gpQ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.27
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsFragment.this.goz == null || view != FrsFragment.this.goz.bES() || FrsFragment.this.getActivity() == null) {
                if (FrsFragment.this.gnZ != null && FrsFragment.this.gnZ.getForum() != null && FrsFragment.this.goz != null && view == FrsFragment.this.goz.bEY()) {
                    if (FrsFragment.this.gpj == null) {
                        FrsFragment.this.gpj = new com.baidu.tieba.frs.view.c(FrsFragment.this.getPageContext());
                    }
                    FrsFragment.this.gpj.m(FrsFragment.this.gnZ);
                    FrsFragment.this.gpj.showDialog();
                    return;
                }
                if (view.getId() == R.id.game_activity_egg_layout && com.baidu.adp.lib.util.l.isNetOk()) {
                    TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_CLICK);
                    if (FrsFragment.this.goz.bFd()) {
                        FrsFragment.this.goz.bFe();
                    } else {
                        String activityUrl = FrsFragment.this.gnZ.getForum().getYuleData().aEy().getActivityUrl();
                        if (!StringUtils.isNull(activityUrl)) {
                            com.baidu.tbadk.browser.a.startInternalWebActivity(FrsFragment.this.getPageContext().getPageActivity(), activityUrl);
                        }
                    }
                }
                if (view == FrsFragment.this.goz.bFk() && FrsFragment.this.goP != null && FrsFragment.this.goP.hasMore()) {
                    FrsFragment.this.goz.bds();
                    FrsFragment.this.bcg();
                }
                if (view != null && view == FrsFragment.this.goz.bFa() && bc.checkUpIsLogin(FrsFragment.this.getContext())) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).X("obj_locate", 2));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MessageCenterActivityConfig(FrsFragment.this.getContext())));
                    return;
                }
                return;
            }
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
            customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, FrsFragment.this.getPageContext().getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.FrsFragment.28
        private int gqd = 0;
        private int eke = 0;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsFragment.this.gpu += i2;
            if (FrsFragment.this.gpu >= FrsFragment.this.cdw * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
            if (FrsFragment.this.goY != null) {
                FrsFragment.this.goY.bKh();
            }
            this.gqd = 0;
            this.eke = 0;
            if (recyclerView != null && (recyclerView instanceof BdRecyclerView)) {
                this.gqd = ((BdRecyclerView) recyclerView).getFirstVisiblePosition();
                this.eke = ((BdRecyclerView) recyclerView).getLastVisiblePosition();
            }
            if (FrsFragment.this.gpk != null) {
                FrsFragment.this.gpk.a(recyclerView, this.gqd, this.eke);
            }
            if (FrsFragment.this.gnZ != null && FrsFragment.this.goz != null && FrsFragment.this.goz.bFg() != null) {
                FrsFragment.this.goz.bE(this.gqd, this.eke);
                if (FrsFragment.this.goO != null && FrsFragment.this.goO.nk() != null) {
                    FrsFragment.this.goO.nk().b(FrsFragment.this.goN);
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (FrsFragment.this.goQ != null) {
                FrsFragment.this.goQ.setScrollState(i);
            }
            if ((i == 2 || i == 1) && !FrsFragment.this.goJ) {
                FrsFragment.this.goJ = true;
                FrsFragment.this.goz.bFi();
            }
            if (FrsFragment.this.goK == null && !FrsFragment.this.bEt()) {
                FrsFragment.this.goK = new com.baidu.tbadk.n.b();
                FrsFragment.this.goK.setSubType(1000);
            }
            if (i == 0) {
                if (FrsFragment.this.goK != null) {
                    FrsFragment.this.goK.aRd();
                }
                com.baidu.tieba.card.r.bvh().kp(true);
                FrsFragment.this.le(true);
                FrsFragment.this.goz.bD(this.gqd, this.eke);
            } else if (FrsFragment.this.goK != null) {
                FrsFragment.this.goK.aRc();
            }
            if (FrsFragment.this.gpk != null) {
                FrsFragment.this.gpk.onScrollStateChanged(recyclerView, i);
            }
            if (i == 0) {
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.goz, FrsFragment.this.gnZ, FrsFragment.this.getForumId(), false, null);
            }
            if (FrsFragment.this.goR != null && i == 1) {
                FrsFragment.this.goR.bLb();
            }
            if (FrsFragment.this.goO == null) {
                if (FrsFragment.this.goz.bEL() != null && !FrsFragment.this.goz.bEr() && FrsFragment.this.goz.bEL().cyJ() != null && (FrsFragment.this.goz.bEL().cyJ().getTag() instanceof com.baidu.card.af)) {
                    FrsFragment.this.goO = (com.baidu.card.af) FrsFragment.this.goz.bEL().cyJ().getTag();
                }
            } else if (i == 0 && FrsFragment.this.goz.bEL() != null && !FrsFragment.this.goz.bEr() && FrsFragment.this.goz.bEL().cyJ() != null && (FrsFragment.this.goz.bEL().cyJ().getTag() instanceof com.baidu.card.af)) {
                FrsFragment.this.goO = (com.baidu.card.af) FrsFragment.this.goz.bEL().cyJ().getTag();
            }
            if (i == 1) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921418));
            }
        }
    };
    private final d gpR = new d() { // from class: com.baidu.tieba.frs.FrsFragment.29
        @Override // com.baidu.tieba.frs.d
        public void a(int i, int i2, View view, View view2, bj bjVar) {
            if (i != FrsFragment.this.goz.bFg().bHe()) {
                if (i != FrsFragment.this.goz.bFg().bHf()) {
                    if (i == FrsFragment.this.goz.bFg().bHc() && FrsFragment.this.gnZ != null && FrsFragment.this.gnZ.getUserData() != null && FrsFragment.this.gnZ.getUserData().isBawu()) {
                        String bawuCenterUrl = FrsFragment.this.gnZ.getBawuCenterUrl();
                        if (!com.baidu.tbadk.core.util.aq.isEmpty(bawuCenterUrl) && FrsFragment.this.gnZ.getForum() != null) {
                            com.baidu.tbadk.browser.a.startWebActivity(FrsFragment.this.getPageContext().getPageActivity(), bawuCenterUrl);
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10502").cy("fid", FrsFragment.this.gnZ.getForum().getId()).cy("uid", FrsFragment.this.gnZ.getUserData().getUserId()));
                        }
                    }
                } else if (bc.checkUpIsLogin(FrsFragment.this.getPageContext().getPageActivity())) {
                    TiebaStatic.log(CommonStatisticKey.MY_SERVICE_CK);
                    if (FrsFragment.this.gnZ != null && FrsFragment.this.gnZ.getForum() != null) {
                        ForumData forum = FrsFragment.this.gnZ.getForum();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(forum.getId(), 0L), forum.getName(), forum.getImage_url(), 0)));
                    }
                }
            } else if (bc.checkUpIsLogin(FrsFragment.this.getActivity())) {
                TiebaStatic.log("forum_fortune_click");
                com.baidu.tieba.frs.f.i.b(FrsFragment.this.getPageContext(), FrsFragment.this.gnZ);
            }
        }
    };
    private final NoNetworkView.a glY = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.FrsFragment.30
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (FrsFragment.this.goP.bJl() == 1 && z && !FrsFragment.this.goz.bEr()) {
                if (FrsFragment.this.gnZ == null || com.baidu.tbadk.core.util.v.isEmpty(FrsFragment.this.gnZ.getThreadList())) {
                    FrsFragment.this.hideNetRefreshView(FrsFragment.this.goz.bsF());
                    FrsFragment.this.showLoadingView(FrsFragment.this.goz.bsF(), true);
                    FrsFragment.this.goz.lo(false);
                    FrsFragment.this.refresh();
                    return;
                }
                FrsFragment.this.goz.bEU();
            }
        }
    };
    private final CustomMessageListener doF = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.FrsFragment.31
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                com.baidu.tieba.frs.f.c.a(customResponsedMessage, FrsFragment.this.goz, FrsFragment.this.gnZ);
            }
        }
    };
    private com.baidu.adp.widget.ListView.s gpS = new a();
    private aj gpT = new aj() { // from class: com.baidu.tieba.frs.FrsFragment.33
        @Override // com.baidu.tieba.frs.aj
        public void a(int i, int i2, aq aqVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
            com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.33.1
                @Override // java.lang.Runnable
                public void run() {
                    if (FrsFragment.this.goz != null && FrsFragment.this.goz.bFl()) {
                        FrsFragment.this.bcg();
                    }
                }
            });
        }
    };
    private CustomMessageListener gpU = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.frs.FrsFragment.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    FrsFragment.this.gpl = true;
                }
            }
        }
    };
    private CustomMessageListener gpV = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.frs.FrsFragment.36
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                    if (FrsFragment.this.goO == null && FrsFragment.this.goz.bEL() != null && !FrsFragment.this.goz.bEr() && FrsFragment.this.goz.bEL().cyJ() != null && (FrsFragment.this.goz.bEL().cyJ().getTag() instanceof com.baidu.card.af)) {
                        FrsFragment.this.goO = (com.baidu.card.af) FrsFragment.this.goz.bEL().cyJ().getTag();
                    }
                    if (FrsFragment.this.goO != null && FrsFragment.this.goO.nk() != null) {
                        FrsFragment.this.goO.nk().b(new a.C0052a(3));
                    }
                }
            }
        }
    };
    private CustomMessageListener gpW = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.FrsFragment.37
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.goz != null) {
                FrsFragment.this.goz.sm();
            }
        }
    };
    private CustomMessageListener gpX = new CustomMessageListener(2921437) { // from class: com.baidu.tieba.frs.FrsFragment.38
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && FrsFragment.this.isResumed()) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (FrsFragment.this.goB != null) {
                    if (booleanValue) {
                        if (FrsFragment.this.goR.bLc() != 0 && !FrsFragment.this.goz.bFq()) {
                            FrsFragment.this.goB.show();
                            return;
                        }
                        return;
                    }
                    FrsFragment.this.goB.hide();
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.frs.loadmore.a
    public /* bridge */ /* synthetic */ com.baidu.adp.base.e getPageContext() {
        return super.getPageContext();
    }

    public com.baidu.tieba.frs.entelechy.b.b bDH() {
        return this.goX;
    }

    public com.baidu.adp.widget.ListView.s bDI() {
        return this.gpS;
    }

    public com.baidu.tieba.frs.mc.d bDJ() {
        return this.goZ;
    }

    public com.baidu.tieba.frs.smartsort.a bDK() {
        return this.goT;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public FrsModelController bDL() {
        return this.goP;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public com.baidu.tieba.frs.mc.c bDM() {
        return this.gpa;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public com.baidu.tieba.frs.vc.h bDN() {
        return this.goQ;
    }

    public FrsTabViewController bDO() {
        return this.goR;
    }

    public al bDP() {
        return this.goV;
    }

    public void ld(boolean z) {
        this.gpt = z;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public l bDQ() {
        return this.goz;
    }

    @Override // com.baidu.tieba.frs.ak
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.ak, com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.gor;
    }

    public void setForumName(String str) {
        this.gor = str;
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
        if (this.gpa == null) {
            return 1;
        }
        return this.gpa.getPn();
    }

    public int getPn() {
        if (this.gpa == null) {
            return 1;
        }
        return this.gpa.getPn();
    }

    public void setPn(int i) {
        if (this.gpa != null) {
            this.gpa.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.gpa != null) {
            this.gpa.setHasMore(i);
        }
    }

    public int bDR() {
        if (this.gpa == null) {
            return -1;
        }
        return this.gpa.bDR();
    }

    public boolean bDS() {
        return this.gox;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public View getRootView() {
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e.b bVar) {
        if (bVar == null) {
            String string = TbadkCoreApplication.getInst().getString(R.string.error_unkown_try_again);
            this.goz.bEO();
            showNetRefreshView(this.goz.bsF(), string, true);
        } else if (340001 == bVar.errorCode) {
            a(bVar, this.gnZ.getRecm_forum_list());
        } else {
            if (com.baidu.tbadk.core.util.v.isEmpty(this.gnZ.getThreadList())) {
                b(bVar);
            }
            if (bEt()) {
                setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds280));
            } else {
                setNetRefreshViewEmotionDefMarginTop();
            }
        }
    }

    public void a(View view, String str, boolean z, List<RecmForumInfo> list) {
        this.goz.bEO();
        this.goz.sL(8);
        if (this.gpi == null) {
            this.gpi = new com.baidu.tieba.frs.view.a(getPageContext(), getNetRefreshListener());
        }
        this.gpi.setSubText(str);
        this.gpi.ct(list);
        this.gpi.attachView(view, z);
    }

    private void a(e.b bVar, List<RecmForumInfo> list) {
        if (this.goz != null) {
            this.goz.bEO();
            this.goz.setTitle(this.gor);
            a(this.goz.bsF(), bVar.errorMsg, true, list);
        }
    }

    private void b(e.b bVar) {
        this.goz.bEO();
        if (bVar.fZC) {
            showNetRefreshView(this.goz.bsF(), TbadkCoreApplication.getInst().getString(R.string.net_error_text, new Object[]{bVar.errorMsg, Integer.valueOf(bVar.errorCode)}), true);
        } else {
            showNetRefreshView(this.goz.bsF(), bVar.errorMsg, true);
        }
    }

    public void bDT() {
        hideLoadingView(this.goz.bsF());
        this.goz.lq(false);
        if (this.goz.bEM() instanceof com.baidu.tieba.frs.tab.c) {
            ((com.baidu.tieba.frs.tab.c) this.goz.bEM()).bJO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDU() {
        if (bDR() == 0 && com.baidu.tbadk.core.util.v.isEmpty(this.gnZ.getThreadListIds())) {
            if (com.baidu.tbadk.core.util.v.isEmpty(this.gnZ.getThreadList())) {
                this.goz.bdu();
            } else {
                this.goz.bdt();
            }
        } else if (com.baidu.tbadk.core.util.v.getCount(this.gnZ.getThreadList()) > 3) {
            this.goz.bds();
        } else {
            this.goz.bFj();
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
            bDT();
            this.goz.bEU();
            e.b bJi = this.goP.bJi();
            boolean isEmpty = com.baidu.tbadk.core.util.v.isEmpty(this.gnZ.getThreadList());
            if (bJi != null && isEmpty) {
                if (this.goP.bJj() != 0) {
                    this.goP.bJo();
                    this.goz.bEU();
                } else {
                    a(bJi);
                }
                this.goz.M(this.gnZ.isStarForum(), false);
                return;
            }
            a(bJi);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.l lVar) {
        if (lVar != null && lVar.getEntelechyTabInfo() != null && lVar.getEntelechyTabInfo().tab != null) {
            for (FrsTabInfo frsTabInfo : lVar.getEntelechyTabInfo().tab) {
                if (frsTabInfo.tab_id.intValue() == 502 && com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean("first_into_tab_profession", true)) {
                    return;
                }
            }
        }
        new com.baidu.tieba.frs.ad.f(getTbPageContext()).a(lVar);
    }

    public boolean bDV() {
        return bDW() && !bDX();
    }

    private boolean bDW() {
        if (bEq() == null) {
            return false;
        }
        FrsViewData bEq = bEq();
        com.baidu.tbadk.core.data.t tVar = null;
        if (bEq.getStar() != null && !StringUtils.isNull(bEq.getStar().cKq())) {
            tVar = new com.baidu.tbadk.core.data.t();
        } else if (bEq.getActivityHeadData() != null && com.baidu.tbadk.core.util.v.getCount(bEq.getActivityHeadData().aAx()) >= 1) {
            tVar = bEq.getActivityHeadData().aAx().get(0);
        }
        return tVar != null;
    }

    public boolean bDX() {
        if (bEq() == null) {
            return false;
        }
        FrsViewData bEq = bEq();
        return (com.baidu.tbadk.core.util.v.isEmpty(bEq.getShowTopThreadList()) && bEq.getBusinessPromot() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDY() {
        boolean b;
        if (!bEa()) {
            final PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
            privateForumPopInfoData.a(this.gnZ.getPrivateForumTotalInfo().getPrivatePopInfo());
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(getActivity());
            if (this.gnZ.getPrivateForumTotalInfo().aBr().private_forum_status.intValue() == 1 && (com.baidu.tbadk.core.util.aq.isEmpty(privateForumPopInfoData.aBt()) || privateForumPopInfoData.aBw() != Integer.valueOf(this.forumId))) {
                privateForumPopInfoData.sy("create_success");
                privateForumPopInfoData.sz(TbadkCoreApplication.getInst().getString(R.string.frs_private_create_hint));
                privateForumPopInfoData.sA("https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.gor + "&nomenu=1");
                privateForumPopInfoData.g(Integer.valueOf(this.forumId));
                b = frsPrivateCommonDialogView.b(privateForumPopInfoData);
            } else {
                b = privateForumPopInfoData.aBw() == Integer.valueOf(this.forumId) ? frsPrivateCommonDialogView.b(privateForumPopInfoData) : false;
            }
            if (b) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
                aVar.jZ(2);
                aVar.aO(frsPrivateCommonDialogView);
                aVar.fH(false);
                frsPrivateCommonDialogView.setConfirmButton(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.11
                    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.frs.FrsFragment */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ba.aGG().b(FrsFragment.this.getPageContext(), new String[]{privateForumPopInfoData.aBv()});
                        aVar.dismiss();
                    }
                });
                aVar.a(new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.13
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(getPageContext()).aEC();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDZ() {
        if (bEa() || this.gnZ.getPrivateForumTotalInfo().aBr().private_forum_status.intValue() != 1) {
            a((Integer) null, (Integer) null, true);
        } else {
            a(this.gnZ.getPrivateForumTotalInfo().aBr().private_forum_audit_status, this.gnZ.getPrivateForumTotalInfo().aBs(), false);
        }
    }

    public void a(Integer num, Integer num2, boolean z) {
        final String str;
        final int i = 2;
        if (this.goz.bEZ() != null) {
            TextView bEZ = this.goz.bEZ();
            if (z) {
                bEZ.setVisibility(8);
                return;
            }
            if (num.intValue() == 2) {
                bEZ.setText("修改实名认证信息");
                bEZ.setVisibility(0);
                str = "https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + this.forumId + "&nomenu=1";
            } else if (num2.intValue() >= 0 && num2.intValue() <= 100) {
                bEZ.setText("目标已完成" + String.valueOf(num2) + "%");
                bEZ.setVisibility(0);
                str = "https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.gor + "&nomenu=1";
                i = 1;
            } else {
                bEZ.setVisibility(8);
                i = 0;
                str = "";
            }
            bEZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.14
                /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13387").cy("fid", FrsFragment.this.forumId).cy("uid", TbadkCoreApplication.getCurrentAccount()).X("obj_type", i));
                    ba.aGG().b(FrsFragment.this.getPageContext(), new String[]{str});
                }
            });
        }
    }

    private boolean bEa() {
        return this.gnZ == null || !this.gnZ.isPrivateForum() || this.gnZ.getPrivateForumTotalInfo() == null || this.gnZ.getPrivateForumTotalInfo().aBr() == null || this.gnZ.getUserData().getIs_manager() != 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sC(int i) {
        List<WindowToast> list;
        if (TbadkCoreApplication.isLogin() && this.gnZ != null && (list = this.gnZ.mWindowToast) != null && list.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < list.size()) {
                    WindowToast windowToast = list.get(i3);
                    if (windowToast == null || windowToast.toast_type.intValue() != i) {
                        i2 = i3 + 1;
                    } else if (!com.baidu.tbadk.core.util.aq.isEmpty(windowToast.toast_link)) {
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), "", com.baidu.tbadk.util.ag.addParamsForPageTranslucent(windowToast.toast_link), true)));
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
    public void bEb() {
        if (this.gnZ == null || this.gnZ.getForum() != null) {
            this.goz.bFf();
        } else if (this.gnZ.getForum().getYuleData() != null && this.gnZ.getForum().getYuleData().aEx()) {
            TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_VIEW);
            this.goz.a(this.gnZ.getForum().getYuleData().aEy());
        } else {
            this.goz.bFf();
        }
    }

    private void K(boolean z, boolean z2) {
        if (this.goP != null && this.gnZ != null && this.goz != null && z) {
            if (!this.goP.bJu() && this.goP.bJl() == 1) {
                if (!this.goP.bJs()) {
                    this.gnZ.addCardVideoInfoToThreadList();
                    this.gnZ.addVideoInfoToThreadListInTenAndFifteenFloor();
                }
                boolean z3 = false;
                if (this.goz.bFg().p(com.baidu.tieba.card.data.n.fNJ)) {
                    z3 = this.gnZ.addHotTopicDataToThreadList();
                }
                if (!z3) {
                    this.gnZ.addFeedForumDataToThreadList();
                }
                if (TbadkCoreApplication.getInst().isRecAppExist()) {
                    this.gnZ.addRecommendAppToThreadList(this);
                }
                if (!this.goz.bFg().p(bj.cRB)) {
                    this.gnZ.removeAlaLiveThreadData();
                }
                this.gnZ.addSchoolRecommendToThreadList();
            }
            if (!this.goz.bFg().p(bj.cRB)) {
                this.gnZ.removeAlaInsertLiveData();
                this.gnZ.removeAlaStageLiveDat();
            } else {
                this.gnZ.addInsertLiveDataToThreadList();
                this.gnZ.addStageLiveDataToThreadList();
            }
            this.gnZ.checkLiveStageInThreadList();
            this.gnZ.addNoticeThreadToThreadList();
            if (this.goz.bFg().p(com.baidu.tieba.h.b.gRK)) {
                this.gnZ.addGameRankListToThreadList(z2);
            }
            if (TbadkCoreApplication.isLogin() && (!this.goP.bJu() || this.goP.isNetFirstLoad)) {
                this.gnZ.addUserRecommendToThreadList();
            }
            this.gnZ.addVideoActivityToTop();
        }
    }

    public boolean bEc() {
        if (this.goQ != null && this.goP != null) {
            this.goQ.a(this.goP.getPageType(), this.gnZ);
        }
        boolean z = false;
        if (this.gnZ != null) {
            z = this.gnZ.hasTab();
        }
        bEe();
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sD(int i) {
        an anVar = null;
        bEc();
        bEl();
        try {
            if (this.gnZ != null) {
                this.goz.a((ArrayList<com.baidu.adp.widget.ListView.m>) null, this.gnZ);
                this.goQ.uk(1);
                this.goz.bEX();
                this.goR.a(this.gnZ, this.goP.bJq());
                com.baidu.tieba.frs.tab.d ur = this.goR.ur(this.gnZ.getFrsDefaultTabId());
                if (ur != null && !TextUtils.isEmpty(ur.url)) {
                    anVar = new an();
                    anVar.ext = ur.url;
                    anVar.stType = ur.name;
                }
                this.goP.a(this.gnZ.getFrsDefaultTabId(), 0, anVar);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(boolean z, boolean z2) {
        try {
            if (this.gnZ != null && this.goR != null && this.goP != null) {
                if (!this.goz.bFg().p(bj.cRB)) {
                    this.gnZ.removeAlaLiveThreadData();
                }
                boolean isEmpty = com.baidu.tbadk.core.util.v.isEmpty(this.gnZ.getGameTabInfo());
                this.goz.lm(isEmpty);
                if (!isEmpty) {
                    if (this.gpk == null) {
                        this.gpk = new com.baidu.tieba.frs.vc.e(this, (NoPressedRelativeLayout) this.mRootView);
                    }
                    if (this.eCs == null) {
                        this.eCs = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
                    }
                } else {
                    this.gpk = null;
                    this.eCs = null;
                }
                if (this.gnZ.getForum() != null) {
                    this.gor = this.gnZ.getForum().getName();
                    this.forumId = this.gnZ.getForum().getId();
                }
                if (this.gnZ.hasTab()) {
                    this.goR.a(this.gnZ, this.goP.bJq());
                }
                if (z) {
                    K(true, z);
                } else {
                    K(this.goL, z);
                }
                bEc();
                if (this.goX != null) {
                    this.goX.a(this.goQ, this.gnZ);
                }
                if (this.gnZ.getPage() != null) {
                    setHasMore(this.gnZ.getPage().aBk());
                }
                ArrayList<com.baidu.adp.widget.ListView.m> a2 = this.gpa.a(z2, true, this.gnZ.getThreadList(), null, z, false);
                if (a2 != null) {
                    this.gnZ.setThreadList(a2);
                }
                this.gnZ.removeRedundantUserRecommendData();
                this.gob = this.gnZ.getTopThreadSize();
                if (this.gov != null) {
                    this.gou = true;
                    this.gov.Cs(this.gob);
                    com.baidu.tieba.frs.f.a.a(this, this.gnZ.getForum(), this.gnZ.getThreadList(), this.gou, getPn());
                }
                if (this.goP.bJl() == 1) {
                    bEi();
                    if (!z && this.goP.getPn() == 1) {
                        bEd();
                    }
                }
                if (this.goY != null) {
                    this.goY.bV(this.goR.bKY());
                }
                bDT();
                this.goz.bEP();
                this.goz.M(true, false);
                if (z && this.gnZ.isFirstTabEqualAllThread()) {
                    com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.15
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!FrsFragment.this.goI && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                FrsFragment.this.goz.bFp();
                            }
                        }
                    });
                }
                if (this.gnZ.getForum() != null) {
                    this.goz.Bf(this.gnZ.getForum().getWarningMsg());
                }
                if (this.gnZ != null && this.gnZ.getFrsVideoActivityData() != null && com.baidu.tbadk.core.sharedPref.b.aFD().getLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 0L) == 0) {
                    com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.16
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsFragment.this.goz.bFn();
                        }
                    }, 1000L);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FRS_SHOW_AR_ENTRY, this));
                this.goz.bEJ();
                if (this.gnZ != null && this.gnZ.getForum() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ENTER_FORUM, new VisitedForumData(this.gnZ.getForum().getId(), this.gnZ.getForum().getName(), this.gnZ.getForum().getImage_url(), String.valueOf(System.currentTimeMillis() / 1000), ConstantData.Forum.SPECAIL_FORUM_TYPE_LIVE.equals(this.gnZ.getForum().special_forum_type), this.gnZ.getForum().getThemeColorInfo(), this.gnZ.getForum().getMember_num())));
                }
                this.gpo.a(this.gnZ.bottomMenuList, this.gnZ.getForum());
                bEz();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void le(boolean z) {
        com.baidu.tieba.s.c.cKb().b(getUniqueId(), z);
    }

    public void bEd() {
        if (this.gpd == null) {
            this.gpd = new com.baidu.tieba.frs.live.a(this, com.baidu.adp.lib.f.b.toInt(this.forumId, 0));
        }
        this.gpd.bIT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.tbadkCore.l lVar) {
        try {
            if (!this.goI && lVar != null && this.gnZ != null) {
                this.gnZ.receiveData(lVar);
                L(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void bEe() {
        if (this.goP != null) {
            Be(this.goP.getPageType());
        } else {
            Be("normal_page");
        }
    }

    private void Be(String str) {
        lf("frs_page".equals(str));
        if (this.goX != null) {
            this.goX.a(this.goQ, this.goz, this.gnZ);
        }
    }

    public void lf(boolean z) {
        if (this.gpb != null) {
            this.gpb.bKR();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.s.c.cKb().w(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.frs_activity, viewGroup, false);
            this.gol = new com.baidu.tieba.frs.entelechy.a();
            this.goX = this.gol.bGI();
            this.gok = TbadkCoreApplication.getInst().getString(R.string.frs_title_new_area);
            this.goQ = new com.baidu.tieba.frs.vc.h(this, this.gol, (FrsHeaderViewContainer) this.mRootView.findViewById(R.id.header_view_container));
            this.goR = new FrsTabViewController(this, this.mRootView);
            this.goR.registerListener();
            this.goQ.a(this.goR);
            this.goR.a(this.gpz);
            Intent intent = getActivity().getIntent();
            if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                this.gon = true;
            }
            this.goz = new l(this, this.gpQ, this.gol, this.gon, this.goQ);
            this.gpo = new com.baidu.tieba.frs.brand.buttommenu.a(getPageContext(), this.mRootView);
        } else {
            if (this.mRootView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            if (this.goR != null) {
                this.goR.registerListener();
            }
            this.goz.bFm();
            this.mRootView.setLeft(0);
            this.mRootView.setRight(com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getContext()));
        }
        this.gps = true;
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        ArrayList<com.baidu.adp.widget.ListView.m> arrayList = null;
        this.fVt = System.currentTimeMillis();
        this.beginTime = this.fVt;
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.gow = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.fVt = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            ai(intent);
        }
        this.dDJ = this.beginTime - this.fVt;
        this.gov = new com.baidu.tieba.tbadkCore.data.f("frs", com.baidu.tieba.tbadkCore.data.f.kge);
        if (this.goP == null) {
            this.goP = new FrsModelController(this, this.gpM);
            this.goP.a(this.gpy);
            this.goP.init();
        }
        if (intent != null) {
            this.goP.ad(intent.getExtras());
        } else if (bundle != null) {
            this.goP.ad(bundle);
        } else {
            this.goP.ad(null);
        }
        if (intent != null) {
            this.goQ.aj(intent.getExtras());
        } else if (bundle != null) {
            this.goQ.aj(bundle);
        } else {
            this.goQ.aj(null);
        }
        this.goy = getVoiceManager();
        this.gpe = new k(getPageContext(), this);
        initUI();
        initData(bundle);
        if (!bEt()) {
            this.goV = new al(getActivity(), this.goz, this.goQ);
            this.goV.lD(true);
        }
        this.goy = getVoiceManager();
        if (this.goy != null) {
            this.goy.onCreate(getPageContext());
        }
        new com.baidu.tieba.frs.mc.i();
        int i = -1;
        if (this.gpa != null && this.gpa.bJe() != null) {
            i = this.gpa.bJe().bDR();
            arrayList = this.gpa.bJe().getDataList();
        }
        this.gpa = new com.baidu.tieba.frs.mc.c(this, this.gpO);
        this.gpa.bJe().setHasMore(i);
        if (arrayList != null && arrayList.size() > 0) {
            this.gpa.bJe().at(arrayList);
        }
        this.goT = new com.baidu.tieba.frs.smartsort.a(this);
        this.gpb = new com.baidu.tieba.frs.vc.j(this);
        this.goY = new com.baidu.tieba.frs.vc.a(getPageContext(), this.goP.bJr());
        this.goU = new com.baidu.tieba.frs.mc.b(this);
        this.goZ = new com.baidu.tieba.frs.mc.d(this);
        this.goS = new com.baidu.tieba.frs.mc.h(this);
        this.gpc = new com.baidu.tieba.frs.mc.a(this);
        this.gpf = new com.baidu.tieba.frs.vc.c(this);
        this.gpg = new com.baidu.tieba.frs.mc.e(this, getUniqueId());
        this.gpm = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "frs");
        this.gpn = new com.baidu.tieba.ala.a(getPageContext());
        this.gpp = new com.baidu.tieba.frs.sportspage.notification.a(getPageContext());
        registerListener(this.gpG);
        registerListener(this.mMemListener);
        registerListener(this.gpE);
        registerListener(this.gpP);
        registerListener(this.gpN);
        registerListener(this.gpB);
        registerListener(this.gpC);
        registerListener(this.gpD);
        registerListener(this.gpv);
        registerListener(this.gpw);
        registerListener(this.KN);
        registerListener(this.gpU);
        registerListener(this.gpI);
        registerListener(this.gpx);
        registerListener(this.gpJ);
        registerListener(this.gpH);
        registerListener(this.gpK);
        registerListener(this.gpL);
        this.gpV.setTag(getPageContext().getUniqueId());
        MessageManager.getInstance().registerListener(this.gpV);
        registerListener(this.gpW);
        registerListener(this.gpX);
        this.goz.lo(false);
        if (!bEt() && !this.hasInit) {
            showLoadingView(this.goz.bsF(), true);
            this.goP.F(3, false);
        }
        com.baidu.tieba.frs.a.bCW().a(new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.19
            @Override // com.baidu.tieba.frs.a.b
            public void J(boolean z, boolean z2) {
                if (FrsFragment.this.goz != null) {
                    FrsFragment.this.goz.sM(z ? 0 : 8);
                    if (!z2) {
                        FrsFragment.this.gpr = z;
                    }
                    if (FrsFragment.this.goz.bFg() != null && FrsFragment.this.goP != null && FrsFragment.this.goP.bJm()) {
                        FrsFragment.this.goz.bFg().notifyDataSetChanged();
                    }
                    if (FrsFragment.this.bDO() != null) {
                        FrsTabViewController.b bKZ = FrsFragment.this.bDO().bKZ();
                        if (bKZ != null && bKZ.tabId == 502 && (bKZ.fragment instanceof FrsCommonTabFragment)) {
                            ((FrsCommonTabFragment) bKZ.fragment).bGD();
                        } else if (bKZ != null && bKZ.tabId == 503 && (bKZ.fragment instanceof FrsNewAreaFragment)) {
                            FrsNewAreaFragment frsNewAreaFragment = (FrsNewAreaFragment) bKZ.fragment;
                            frsNewAreaFragment.bGD();
                            if (frsNewAreaFragment.bJy() != null) {
                                com.baidu.tieba.frs.mc.g bJy = frsNewAreaFragment.bJy();
                                bJy.lr(!z);
                                bJy.ls(!z);
                            }
                        }
                        if (FrsFragment.this.bDO().bKS() != null) {
                            FrsFragment.this.bDO().bKS().setmDisallowSlip(z);
                            FrsFragment.this.bDO().mh(z);
                        }
                    }
                    if (FrsFragment.this.goz.bEN() != null) {
                        FrsFragment.this.goz.ll(!z);
                    }
                    if (FrsFragment.this.getActivity() instanceof FrsActivity) {
                        ((FrsActivity) FrsFragment.this.getActivity()).lc(!z);
                    }
                    if (FrsFragment.this.gpo != null) {
                        FrsFragment.this.gpo.lK(!z);
                    }
                    FrsFragment.this.goz.lr(!z);
                    FrsFragment.this.goz.ls(z ? false : true);
                }
            }

            @Override // com.baidu.tieba.frs.a.b
            public void sz(int i2) {
                if (FrsFragment.this.goz != null) {
                    FrsFragment.this.goz.sN(i2);
                }
            }

            @Override // com.baidu.tieba.frs.a.b
            public void bDd() {
                com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getContext(), (int) R.string.frs_multi_delete_max_num);
            }
        });
        this.goz.b(new d.a() { // from class: com.baidu.tieba.frs.FrsFragment.20
            @Override // com.baidu.tieba.NEGFeedBack.d.a
            public void a(DeleteThreadHttpResponseMessage deleteThreadHttpResponseMessage) {
                boolean z;
                int i2 = 0;
                if (deleteThreadHttpResponseMessage != null) {
                    FrsFragment.this.goz.aWo();
                    FrsFragment.this.goz.bFo();
                    FrsNewAreaFragment frsNewAreaFragment = null;
                    if (FrsFragment.this.goR == null || FrsFragment.this.goR.bKZ() == null || !(FrsFragment.this.goR.bKZ().fragment instanceof FrsNewAreaFragment)) {
                        z = false;
                    } else {
                        frsNewAreaFragment = (FrsNewAreaFragment) FrsFragment.this.goR.bKZ().fragment;
                        z = true;
                    }
                    if (deleteThreadHttpResponseMessage.getError() == 0) {
                        String text = !TextUtils.isEmpty(deleteThreadHttpResponseMessage.getText()) ? deleteThreadHttpResponseMessage.getText() : FrsFragment.this.getString(R.string.delete_fail);
                        if (deleteThreadHttpResponseMessage.getRetType() == 1211066) {
                            if (FrsFragment.this.fMc == null) {
                                FrsFragment.this.fMc = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.fMc.sS(text);
                            FrsFragment.this.fMc.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.20.1
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.fMc.fH(false);
                            FrsFragment.this.fMc.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.fMc.aEC();
                        } else if (deleteThreadHttpResponseMessage.getRetType() == 1211067) {
                            if (FrsFragment.this.fMc == null) {
                                FrsFragment.this.fMc = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.fMc.sS(text);
                            FrsFragment.this.fMc.a(R.string.know, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.20.2
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.fMc.fH(false);
                            FrsFragment.this.fMc.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.fMc.aEC();
                        } else {
                            FrsFragment.this.goz.az(deleteThreadHttpResponseMessage.getText(), ContextCompat.getColor(FrsFragment.this.getContext(), deleteThreadHttpResponseMessage.getRetType() == 1 ? R.color.nav_bar_tip_error : R.color.cp_link_tip_a_alpha95));
                        }
                        if (z && frsNewAreaFragment != null) {
                            frsNewAreaFragment.co(deleteThreadHttpResponseMessage.getSuccessItems());
                        }
                        FrsFragment.this.cd(deleteThreadHttpResponseMessage.getSuccessItems());
                        com.baidu.tieba.frs.a.bCW().cc(deleteThreadHttpResponseMessage.getSuccessItems());
                        for (com.baidu.adp.widget.ListView.m mVar : FrsFragment.this.gnZ.getThreadList()) {
                            if (mVar instanceof bi) {
                                i2++;
                                continue;
                            }
                            if (i2 >= 6) {
                                break;
                            }
                        }
                        if (i2 < 6) {
                            FrsFragment.this.bcg();
                            return;
                        }
                        return;
                    }
                    com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getActivity(), deleteThreadHttpResponseMessage.getErrorString());
                }
            }
        });
        this.cdw = UtilHelper.getScreenHeight(getActivity());
        this.hasInit = true;
        sE(1);
        super.onActivityCreated(bundle);
        this.createTime = System.currentTimeMillis() - this.beginTime;
    }

    public void lg(boolean z) {
        if (this.goR != null) {
            this.goR.gNd = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cd(List<String> list) {
        if (!com.baidu.tbadk.core.util.v.isEmpty(list)) {
            ArrayList<com.baidu.adp.widget.ListView.m> threadList = this.gnZ.getThreadList();
            if (!com.baidu.tbadk.core.util.v.isEmpty(threadList) && this.goz.getListView() != null && this.goz.getListView().getData() != null) {
                Iterator<com.baidu.adp.widget.ListView.m> it = threadList.iterator();
                List<com.baidu.adp.widget.ListView.m> data = this.goz.getListView().getData();
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.m next = it.next();
                    if (next instanceof bi) {
                        bj bjVar = ((bi) next).cRg;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= list.size()) {
                                break;
                            } else if (!com.baidu.tbadk.core.util.aq.equals(list.get(i2), bjVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.gpa.d(next);
                                this.goz.getListView().getAdapter().notifyItemRemoved(i);
                                break;
                            }
                        }
                    }
                    i++;
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void bcA() {
        if (isAdded() && this.eoi && !isLoadingViewAttached()) {
            showLoadingView(this.goz.bsF(), true);
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void bcB() {
        if (isAdded() && this.eoi && isLoadingViewAttached()) {
            hideLoadingView(this.goz.bsF());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (bEt()) {
            showLoadingView(this.goz.bsF(), true);
            this.goz.sO(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.goP.F(3, true);
            aIi().scrollToPosition(0);
        }
    }

    private void sE(int i) {
        String str = "";
        if (this.gnZ != null && this.gnZ.getForum() != null) {
            str = this.gnZ.getForum().getId();
        }
        if (!StringUtils.isNull(str)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13008").cy("fid", str).cy("obj_type", "4").X("obj_locate", i).cy("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.z zVar) {
        if (zVar != null) {
            this.dHb = zVar.aSp();
            this.gph = zVar.aSq();
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void showFloatingView() {
        if (this.dHb != null) {
            this.dHb.hd(true);
        }
    }

    private void ai(Intent intent) {
        if (intent != null) {
            if (intent != null) {
                if (!com.baidu.tieba.frs.f.f.a(this, getForumName(), "from", intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false)) && getActivity() != null) {
                    getActivity().finish();
                    return;
                }
            }
            if (intent != null && intent.getParcelableExtra("key_uri") != null) {
                Uri uri = (Uri) intent.getParcelableExtra("key_uri");
                this.gor = uri.getQueryParameter("name");
                this.mFrom = uri.getQueryParameter("from");
                if (!StringUtils.isNull(this.gor)) {
                    intent.putExtra("name", this.gor);
                }
                if (!StringUtils.isNull(this.mFrom)) {
                    intent.putExtra("from", this.mFrom);
                }
                TiebaStatic.log(TbadkCoreStatisticKey.AS_INVOKE_TIEBA);
            }
            if (StringUtils.isNull(this.gor) && intent != null && intent.getParcelableExtra("key_uri") != null) {
                Uri uri2 = (Uri) intent.getParcelableExtra("key_uri");
                if (com.baidu.tbadk.BdToken.f.n(uri2)) {
                    com.baidu.tbadk.BdToken.f.axP().b(uri2, new f.a() { // from class: com.baidu.tieba.frs.FrsFragment.21
                        @Override // com.baidu.tbadk.BdToken.f.a
                        public void n(HashMap<String, Object> hashMap) {
                            if (hashMap != null && (hashMap.get(com.baidu.tbadk.BdToken.f.cIj) instanceof String)) {
                                FrsFragment.this.gor = (String) hashMap.get(com.baidu.tbadk.BdToken.f.cIj);
                            }
                        }
                    });
                } else {
                    com.baidu.tieba.frs.f.d al = com.baidu.tieba.frs.f.i.al(intent);
                    if (al != null) {
                        this.gor = al.forumName;
                        if (al.gLo == null || al.gLo.equals("aidou")) {
                        }
                    }
                }
                if (!StringUtils.isNull(this.gor)) {
                    intent.putExtra("name", this.gor);
                }
                intent.putExtra(FrsActivityConfig.FRS_CALL_FROM, 12);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.goy = getVoiceManager();
        if (this.goy != null) {
            this.goy.onStart(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        Intent intent;
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.doF);
        if (bundle != null) {
            this.gor = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
            this.gor = intent.getStringExtra("name");
            this.mFrom = intent.getStringExtra("from");
            this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
        }
        if (getArguments() != null) {
            this.gos = getArguments().getBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, false);
        }
        if (TextUtils.isEmpty(this.mFrom) || FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
        }
        if (this.mIsLogin) {
            registerListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL, this.doF);
        }
        this.goQ.aj(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.s.c.cKb().x(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.gpU);
        goC = null;
        if (this.goy != null) {
            this.goy.onDestory(getPageContext());
        }
        com.baidu.tieba.recapp.report.a.remove("FRS");
        this.goy = null;
        com.baidu.tieba.card.r.bvh().kp(false);
        if (this.gnZ != null && this.gnZ.getForum() != null) {
            ab.bFK().dv(com.baidu.adp.lib.f.b.toLong(this.gnZ.getForum().getId(), 0L));
        }
        if (this.gpd != null) {
            this.gpd.onDestory();
        }
        if (this.goz != null) {
            com.baidu.tieba.frs.f.h.a(this.goz, this.gnZ, getForumId(), false, null);
            this.goz.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.goK != null) {
                this.goK.aRe();
            }
            this.goz.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.goQ.aiI();
        if (this.goP != null) {
            this.goP.bgX();
        }
        if (this.goV != null) {
            this.goV.aWJ();
        }
        if (this.goY != null) {
            this.goY.destory();
        }
        if (this.goT != null) {
            this.goT.onDestroy();
        }
        if (this.gpk != null) {
            this.gpk.onDestory();
        }
        if (this.gpc != null) {
            this.gpc.onDestroy();
        }
        if (this.gpm != null) {
            this.gpm.onDestroy();
        }
        if (this.gpn != null) {
            this.gpn.onDestroy();
        }
        com.baidu.tieba.recapp.d.a.cDl().cDn();
        com.baidu.tieba.frs.f.j.bKe();
        if (this.goR != null) {
            this.goR.a((FrsTabViewController.a) null);
            this.goR.bLb();
        }
        if (this.gpq != null) {
            this.gpq.onDestroy();
        }
        com.baidu.tieba.frs.a.bCW().a(null);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.gor);
        bundle.putString("from", this.mFrom);
        this.goP.onSaveInstanceState(bundle);
        if (this.goy != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            this.goy.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.gpc != null) {
            this.gpc.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.goz != null) {
            this.goz.bEU();
            this.goz.onResume();
        }
        this.goS.lZ(true);
        this.goL = true;
        if (goq) {
            goq = false;
            this.goz.startPullRefresh();
            return;
        }
        if (this.goy != null) {
            this.goy.onResume(getPageContext());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_RESUME));
        this.goz.lt(false);
        if (this.gpl) {
            refresh(6);
            this.gpl = false;
        }
        bEz();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
    }

    public boolean bEf() {
        Intent intent;
        if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
            return false;
        }
        return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
    }

    public void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.gor = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.got = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.got) {
                bEg();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEg() {
        this.goz.startPullRefresh();
    }

    public void closeActivity() {
        com.baidu.tieba.frs.f.i.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.mFrom);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.goz.setTitle(this.gor);
        } else {
            this.goz.setTitle("");
            this.mFlag = 1;
        }
        this.goz.a(this.gpS);
        this.goz.addOnScrollListener(this.mScrollListener);
        this.goz.g(this.glY);
        this.goz.bFg().a(this.gpR);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gps) {
            this.goz.onChangeSkinType(i);
            this.goQ.uj(i);
            this.goR.onChangeSkinType(i);
            if (this.goB != null) {
                this.goB.onChangeSkinType(i);
            }
            if (this.gpi != null) {
                this.gpi.onChangeSkinType();
            }
            if (this.gpo != null) {
                this.gpo.onChangeSkinType(getPageContext(), i);
            }
            if (this.fMc != null) {
                com.baidu.tbadk.q.a.a(getPageContext(), this.fMc.getRealView());
            }
            if (this.gpj != null) {
                this.gpj.onChangeSkinType();
            }
            if (this.gpk != null) {
                this.gpk.onChangeSkinType(getPageContext(), i);
            }
        }
    }

    public void sF(int i) {
        if (!this.mIsLogin) {
            if (this.gnZ != null && this.gnZ.getAnti() != null) {
                this.gnZ.getAnti().setIfpost(1);
            }
            if (i == 0) {
                bc.skipToLoginActivity(getActivity());
            }
        } else if (this.gnZ != null) {
            if (i == 0) {
                com.baidu.tieba.frs.f.j.e(this, 0);
            } else {
                this.goz.bEW();
            }
        }
    }

    public void refresh() {
        com.baidu.tieba.a.d.aXG().wO("page_frs");
        refresh(3);
    }

    public void refresh(int i) {
        this.goI = false;
        bEl();
        if (this.goz != null && this.goz.bEL() != null) {
            this.goz.bEL().bOq();
        }
        if (this.goP != null) {
            this.goP.F(i, true);
        }
    }

    private void bEh() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.f.h.gy().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.26
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.Jj(FrsFragment.this.gor);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEi() {
        bEl();
        try {
            if (this.gnZ != null) {
                this.goz.bgz();
                this.goz.ll(bEy());
                if (!com.baidu.tieba.frs.vc.h.l(this.gnZ) || !com.baidu.tieba.frs.vc.h.k(this.gnZ)) {
                }
                if (this.gnZ.getForum() != null) {
                    this.gor = this.gnZ.getForum().getName();
                    this.forumId = this.gnZ.getForum().getId();
                }
                if (this.gnZ.getPage() != null) {
                    setHasMore(this.gnZ.getPage().aBk());
                }
                this.goz.setTitle(this.gor);
                this.goz.setForumName(this.gor);
                TbadkCoreApplication.getInst().setDefaultBubble(this.gnZ.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.gnZ.getUserData().getBimg_end_time());
                bEh();
                bEj();
                ArrayList<com.baidu.adp.widget.ListView.m> threadList = this.gnZ.getThreadList();
                if (threadList != null) {
                    this.goz.a(threadList, this.gnZ);
                    com.baidu.tieba.frs.f.c.y(this.goz);
                    this.goQ.uk(getPageNum());
                    this.goQ.i(this.gnZ);
                    this.goR.a(this.gnZ, this.goP.bJq());
                    this.goz.bEX();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void bEj() {
        if (this.gnZ != null) {
            if (this.gnZ.getIsNewUrl() == 1) {
                this.goz.bFg().setFromCDN(true);
            } else {
                this.goz.bFg().setFromCDN(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.goS.lZ(false);
        this.goL = false;
        this.goz.onPause();
        if (this.goy != null) {
            this.goy.onPause(getPageContext());
        }
        this.goz.lt(true);
        if (this.goY != null) {
            this.goY.bKh();
        }
        com.baidu.tbadk.BdToken.c.axz().axE();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.goR != null && this.goR.bKZ() != null && (this.goR.bKZ().fragment instanceof BaseFragment)) {
            ((BaseFragment) this.goR.bKZ().fragment).setPrimary(z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.r.bvh().kp(false);
        le(false);
        if (this.gnZ != null && this.gnZ.getForum() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            com.baidu.tbadk.distribute.a.aOi().a(getPageContext().getPageActivity(), "frs", this.gnZ.getForum().getId(), 0L);
        }
        if (this.goy != null) {
            this.goy.onStop(getPageContext());
        }
        if (aIi() != null) {
            aIi().getRecycledViewPool().clear();
        }
        this.goQ.aHC();
        com.baidu.tbadk.util.aa.aSs();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            if (this.goQ != null) {
                this.goQ.onPrimary(isPrimary());
            }
            if (this.goz != null) {
                this.goz.onPrimary(isPrimary());
                this.goz.lt(!isPrimary());
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (com.baidu.tieba.frs.a.bCW().bCX()) {
                com.baidu.tieba.frs.a.bCW().reset();
                return true;
            } else if (this.goz != null) {
                return this.goz.bET();
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
        com.baidu.tbadk.distribute.a.aOi().a(advertAppInfo, this.forumId, 0L, "FRS", str, getPn());
    }

    @Override // com.baidu.tieba.recapp.n
    public void bEk() {
        bDL().bEk();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.goy == null) {
            this.goy = VoiceManager.instance();
        }
        return this.goy;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdRecyclerView aIi() {
        if (this.goz == null) {
            return null;
        }
        return this.goz.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void bEl() {
        if (this.goy != null) {
            this.goy.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> aIj() {
        if (this.djp == null) {
            this.djp = UserIconBox.x(getPageContext().getPageActivity(), 8);
        }
        return this.djp;
    }

    public void bEm() {
        if (getFragmentActivity() != null && getFragmentActivity().getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.p onGetPreLoadListView() {
        return aIi().getPreLoadHandle();
    }

    @Override // com.baidu.tieba.frs.ai
    public NavigationBar beM() {
        if (this.goz == null) {
            return null;
        }
        return this.goz.beM();
    }

    public FRSRefreshButton bEn() {
        return this.goB;
    }

    public void a(FRSRefreshButton fRSRefreshButton) {
        if (fRSRefreshButton != null) {
            this.goB = fRSRefreshButton;
            this.goB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.32
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (FrsFragment.this.goR != null) {
                        FrsTabViewController.b bKZ = FrsFragment.this.goR.bKZ();
                        if (bKZ != null && bKZ.fragment != null && (bKZ.fragment instanceof ah)) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                            ((ah) bKZ.fragment).scrollToTop();
                            ((ah) bKZ.fragment).bdr();
                            return;
                        }
                        FrsFragment.this.bDQ().startPullRefresh();
                    }
                }
            });
        }
    }

    public void bEo() {
        if (this.goB != null) {
            this.goB.hide();
        }
    }

    public void bEp() {
        if (this.goB != null) {
            this.goB.show();
        }
    }

    /* loaded from: classes9.dex */
    private final class a implements com.baidu.adp.widget.ListView.s {
        private a() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.s
        public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null) {
                if (bdUniqueId == q.grC) {
                    if (FrsFragment.this.goz != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11752").cy("fid", FrsFragment.this.forumId).cy("obj_locate", "1"));
                        FrsFragment.this.goz.startPullRefresh();
                    }
                } else if (mVar != null && (mVar instanceof bi)) {
                    bj bjVar = ((bi) mVar).cRg;
                    if (bjVar.aDl() == null || bjVar.aDl().getGroup_id() == 0 || bc.checkUpIsLogin(FrsFragment.this.getActivity())) {
                        if (bjVar.aCY() != 1 || bc.checkUpIsLogin(FrsFragment.this.getActivity())) {
                            if (bjVar.aCB() != null) {
                                if (bc.checkUpIsLogin(FrsFragment.this.getActivity())) {
                                    String postUrl = bjVar.aCB().getPostUrl();
                                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.isNetOk()) {
                                        com.baidu.tbadk.browser.a.startInternalWebActivity(FrsFragment.this.getActivity(), postUrl);
                                    }
                                }
                            } else if (bjVar.aDv() != null) {
                                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                    bc.skipToLoginActivity(FrsFragment.this.getPageContext().getPageActivity());
                                    return;
                                }
                                com.baidu.tbadk.core.data.p aDv = bjVar.aDv();
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), aDv.getCartoonId(), aDv.getChapterId(), 2)));
                            } else {
                                com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                                if (readThreadHistory != null && !readThreadHistory.Jp(bjVar.getId())) {
                                    readThreadHistory.Jo(bjVar.getId());
                                }
                                boolean z = false;
                                final String aCv = bjVar.aCv();
                                if (aCv != null && !aCv.equals("")) {
                                    z = true;
                                    new Thread(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.a.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(aCv);
                                            xVar.aGg().aGH().mIsNeedAddCommenParam = false;
                                            xVar.aGg().aGH().mIsUseCurrentBDUSS = false;
                                            xVar.getNetData();
                                        }
                                    }).start();
                                }
                                String tid = bjVar.getTid();
                                if (tid == null) {
                                    tid = "";
                                }
                                if (bjVar.aCj() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                    ba.aGG().b(FrsFragment.this.getPageContext(), new String[]{tid, "", null});
                                    return;
                                }
                                if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                    bjVar.setId(tid.substring(3));
                                }
                                if (bdUniqueId.getId() == bj.cTe.getId()) {
                                    com.baidu.tieba.frs.f.h.a(bjVar.aBU());
                                } else if (bdUniqueId.getId() == bj.cRE.getId()) {
                                    com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                                    anVar.cy("obj_type", "2");
                                    anVar.cy("tid", bjVar.getTid());
                                    TiebaStatic.log(anVar);
                                }
                                com.baidu.tieba.frs.f.i.a(FrsFragment.this, bjVar, i, z);
                                com.baidu.tieba.frs.f.h.a(FrsFragment.this, FrsFragment.this.gnZ, bjVar);
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
            hideNetRefreshView(this.goz.bsF());
            showLoadingView(this.goz.bsF(), true);
            this.goz.lo(false);
            this.goP.F(3, true);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData bEq() {
        return this.gnZ;
    }

    public boolean bEr() {
        return this.goz.bEr();
    }

    public void at(Object obj) {
        if (this.goU != null && this.goU.gGO != null) {
            this.goU.gGO.callback(obj);
        }
    }

    public void au(Object obj) {
        if (this.goU != null && this.goU.gGP != null) {
            this.goU.gGP.callback(obj);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        this.goz.getListView().stopScroll();
        if (!this.goz.bFc()) {
            if (!com.baidu.adp.lib.util.l.isNetOk()) {
                this.goz.bdu();
            } else if (this.goP.bJl() == 1) {
                bcv();
                bcg();
            } else if (this.goP.hasMore()) {
                bcg();
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void onFailed(String str) {
        bcv();
        showToast(str);
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void al(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        boolean isEmpty = com.baidu.tbadk.core.util.v.isEmpty(arrayList);
        setHasMore(isEmpty ? 0 : 1);
        bcv();
        if (!isEmpty) {
            if (!this.goP.bJu() && TbadkCoreApplication.getInst().isRecAppExist() && this.goP.bJl() == 1) {
                this.gnZ.addRecommendAppToThreadList(this, arrayList);
            }
            if (this.goP != null) {
                com.baidu.tieba.frs.d.a.a(getUniqueId(), arrayList, this.gnZ.getForum(), this.goP.getSortType());
            }
            ArrayList<com.baidu.adp.widget.ListView.m> a2 = this.gpa.a(false, false, arrayList, this.gov, false);
            if (a2 != null) {
                this.gnZ.setThreadList(a2);
                this.goz.a(a2, this.gnZ);
            }
            if (this.goP != null) {
                com.baidu.tieba.frs.d.c.a(this.gnZ, this.goP.bJq(), 2, getContext());
            }
        }
    }

    private void bcv() {
        if (bDR() == 1 || this.gpa.cn(this.gnZ.getThreadListIds())) {
            if (com.baidu.tbadk.core.util.v.getCount(this.gnZ.getThreadList()) > 3) {
                this.goz.bds();
            } else {
                this.goz.bFj();
            }
        } else if (com.baidu.tbadk.core.util.v.isEmpty(this.gnZ.getThreadList())) {
            this.goz.bdu();
        } else {
            this.goz.bdt();
        }
    }

    @Override // com.baidu.tieba.frs.mc.l
    public void bcg() {
        if (this.gpa != null) {
            this.gpa.a(this.gor, this.forumId, this.gnZ);
        }
    }

    public void bEs() {
        if (!com.baidu.tbadk.core.util.ab.requestWriteExternalStorgeAndCameraPermission(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.al.e(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment, com.baidu.k.a.a.InterfaceC0078a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        com.baidu.tieba.frs.f.i.a(this, i, strArr, iArr);
    }

    public void lh(boolean z) {
        if (this.goV != null) {
            this.goV.lD(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.goW.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a nS(int i) {
        return this.goW.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        this.gpe.b(bVar);
    }

    public boolean bEt() {
        return this.gon;
    }

    @Override // com.baidu.tieba.frs.af
    public void AC() {
        if (this.goz != null) {
            showFloatingView();
            this.goz.getListView().scrollToPosition(0);
            this.goz.startPullRefresh();
        }
    }

    public ForumWriteData bEu() {
        if (this.gnZ == null || this.gnZ.getForum() == null) {
            return null;
        }
        ForumData forum = this.gnZ.getForum();
        ForumWriteData forumWriteData = new ForumWriteData(forum.getId(), forum.getName(), forum.getPrefixData(), this.gnZ.getAnti());
        forumWriteData.avatar = forum.getImage_url();
        forumWriteData.forumLevel = forum.getUser_level();
        forumWriteData.specialForumType = forum.special_forum_type;
        forumWriteData.firstDir = forum.getFirst_class();
        forumWriteData.secondDir = forum.getSecond_class();
        UserData userData = this.gnZ.getUserData();
        forumWriteData.privateThread = userData != null ? userData.getPrivateThread() : 0;
        return forumWriteData;
    }

    @Override // com.baidu.tieba.frs.af
    public void aHO() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void li(boolean z) {
        this.goM = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z) {
        this.goz.sL(8);
        ((FrsActivity) getActivity()).showLoadingView(view, z);
        ((FrsActivity) getActivity()).g(view, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        this.goz.sL(0);
        ((FrsActivity) getActivity()).hideLoadingView(view);
        ((FrsActivity) getActivity()).g(view, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        super.showNetRefreshView(view, getResources().getString(R.string.refresh_view_title_text), null, getResources().getString(R.string.refresh_view_button_text), z, getNetRefreshListener());
        this.goz.sL(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshViewNoClick(View view, String str, boolean z) {
        super.showNetRefreshViewNoClick(view, str, z);
        this.goz.sL(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        super.hideNetRefreshView(view);
        this.goz.sL(0);
    }

    public void bEv() {
        FrsTabViewController.b bKZ;
        if (this.goR != null && (bKZ = this.goR.bKZ()) != null && bKZ.fragment != null && (bKZ.fragment instanceof ah)) {
            ((ah) bKZ.fragment).scrollToTop();
        }
    }

    public void lj(boolean z) {
        this.gop = z;
    }

    public void b(OvalActionButton ovalActionButton) {
        this.goA = ovalActionButton;
    }

    public OvalActionButton bEw() {
        return this.goA;
    }

    public boolean bEx() {
        return this.gop;
    }

    public void onShareSuccess(String str) {
        if (TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.util.aq.isEmpty(str)) {
            if (this.gpq == null) {
                this.gpq = new AddExperiencedModel(getTbPageContext());
            }
            this.gpq.ev(this.forumId, str);
        }
    }

    public boolean bEy() {
        if (this.goM && !this.gpt) {
            return (this.goP != null && this.goP.bJm() && com.baidu.tieba.frs.a.bCW().bCX()) ? false : true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.f.c
    public boolean videoNeedPreload() {
        if (this.gnZ != null) {
            return com.baidu.tbadk.util.af.mT(2) || (com.baidu.tbadk.util.af.aSx() && this.gnZ.isFrsVideoAutoPlay);
        }
        return super.videoNeedPreload();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.f.c
    public boolean isCyberVideoUsedThisPage() {
        return com.baidu.tbadk.a.b.rH("cyber_player_test");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEz() {
        if (!com.baidu.tbadk.core.util.aq.isEmpty(this.forumId)) {
            com.baidu.tbadk.BdToken.c.axz().p(com.baidu.tbadk.BdToken.b.cGN, com.baidu.adp.lib.f.b.toLong(this.forumId, 0L));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        FrsTabViewController.b bKZ;
        if (bDO() == null || (bKZ = bDO().bKZ()) == null || !(bKZ.fragment instanceof BaseFragment)) {
            return null;
        }
        if (bKZ.fragment instanceof FrsAllThreadFragment) {
            TbPageTag tbPageTag = super.getTbPageTag();
            int i = -1;
            if (this.gnZ != null) {
                i = this.gnZ.getSortType();
            }
            tbPageTag.sortType = com.baidu.tieba.frs.f.g.uh(i);
            tbPageTag.locatePage = "a070";
            if (this.gok.equals(bKZ.title)) {
                tbPageTag.locatePage = "a071";
            }
            return tbPageTag;
        } else if (bKZ.fragment instanceof FrsFragment) {
            return null;
        } else {
            return ((BaseFragment) bKZ.fragment).getTbPageTag();
        }
    }
}
