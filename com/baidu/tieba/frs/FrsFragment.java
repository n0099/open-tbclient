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
    public static com.baidu.tieba.tbadkCore.l gon;
    private com.baidu.tbadk.util.y dGN;
    private com.baidu.adp.lib.d.b<TbImageView> djb;
    private com.baidu.tieba.frs.gametab.b eCe;
    private com.baidu.tbadk.core.dialog.a fLN;
    private com.baidu.tieba.frs.entelechy.a gnW;
    private FrsModelController goA;
    private com.baidu.tieba.frs.vc.h goB;
    private FrsTabViewController goC;
    private com.baidu.tieba.frs.mc.h goD;
    private com.baidu.tieba.frs.smartsort.a goE;
    private com.baidu.tieba.frs.mc.b goF;
    private al goG;
    private com.baidu.tieba.frs.entelechy.b.b goI;
    private com.baidu.tieba.frs.vc.a goJ;
    private com.baidu.tieba.frs.mc.d goK;
    private com.baidu.tieba.frs.mc.c goL;
    private com.baidu.tieba.frs.vc.j goM;
    private com.baidu.tieba.frs.mc.a goN;
    private com.baidu.tieba.frs.live.a goO;
    private k goP;
    public com.baidu.tieba.frs.vc.c goQ;
    private com.baidu.tieba.frs.mc.e goR;
    private View.OnTouchListener goS;
    private com.baidu.tieba.frs.view.a goT;
    private com.baidu.tieba.frs.view.c goU;
    private com.baidu.tieba.frs.vc.e goV;
    private boolean goW;
    private com.baidu.tieba.NEGFeedBack.a goX;
    private com.baidu.tieba.ala.a goY;
    private com.baidu.tieba.frs.brand.buttommenu.a goZ;
    private com.baidu.tieba.tbadkCore.data.f gog;
    private VoiceManager goj;
    private OvalActionButton gol;
    private FRSRefreshButton gom;
    public long goo;
    private com.baidu.card.af goz;
    private com.baidu.tieba.frs.sportspage.notification.a gpa;
    private AddExperiencedModel gpb;
    private boolean gpd;
    private int gpl;
    private View mRootView;
    public static boolean gob = false;
    public static volatile long goq = 0;
    public static volatile long gor = 0;
    public static volatile int mNetError = 0;
    private String gnV = "";
    public boolean gnX = false;
    private boolean gnY = false;
    private boolean gnZ = false;
    private boolean goa = true;
    public String goc = null;
    public String mFrom = null;
    public int mFlag = 0;
    public boolean god = false;
    private boolean goe = false;
    private String mThreadId = null;
    public String forumId = null;
    private int gnM = 0;
    private boolean gof = false;
    private boolean goh = false;
    private boolean goi = false;
    private l gok = null;
    public final bj NQ = null;
    private FrsViewData gnK = new FrsViewData();
    public long fVe = -1;
    public long dDD = 0;
    public long dDv = 0;
    public long createTime = 0;
    public long beginTime = -1;
    public long gop = 0;
    public boolean gos = false;
    private boolean got = false;
    private boolean gou = false;
    public com.baidu.tbadk.n.b gov = null;
    private boolean gow = true;
    private boolean gox = true;
    private a.C0052a goy = new a.C0052a(2);
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> goH = new SparseArray<>();
    private boolean enT = true;
    private boolean hasInit = false;
    private boolean gpc = false;
    private boolean gpe = false;
    private int cdu = 0;
    private int gpf = 0;
    public int mHeadLineDefaultNavTabId = -1;
    private final CustomMessageListener gpg = new CustomMessageListener(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED) { // from class: com.baidu.tieba.frs.FrsFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof bj) {
                    com.baidu.tieba.frs.f.h.a(FrsFragment.this.gok, FrsFragment.this.gnK, FrsFragment.this.getForumId(), true, (bj) data);
                }
            }
        }
    };
    private CustomMessageListener gph = new CustomMessageListener(CmdConfigCustom.CMD_CLOSE_GAME_RANK_CARD) { // from class: com.baidu.tieba.frs.FrsFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.gnK != null) {
                FrsFragment.this.gnK.removeGameRankListFromThreadList();
                if (FrsFragment.this.gok != null) {
                    FrsFragment.this.gok.asL();
                }
            }
        }
    };
    private CustomMessageListener KN = new CustomMessageListener(2921401) { // from class: com.baidu.tieba.frs.FrsFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && FrsFragment.this.gom != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() <= 0 || FrsFragment.this.goC.bKZ() == 0 || FrsFragment.this.goC.bKW() == null || !(FrsFragment.this.goC.bKW().fragment instanceof BaseFragment) || !((BaseFragment) FrsFragment.this.goC.bKW().fragment).isPrimary() || FrsFragment.this.gok.bFn()) {
                    if (FrsFragment.this.goC.bKZ() != 0) {
                        FrsFragment.this.gom.hide();
                        return;
                    }
                    return;
                }
                FrsFragment.this.gom.show();
            }
        }
    };
    private CustomMessageListener gpi = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.FrsFragment.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 1) {
                    FrsFragment.this.bEd();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                }
            }
        }
    };
    private final aj gpj = new aj() { // from class: com.baidu.tieba.frs.FrsFragment.39
        @Override // com.baidu.tieba.frs.aj
        public void a(int i, int i2, aq aqVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
            FrsFragment.this.bDQ();
            if (FrsFragment.this.goI != null) {
                FrsFragment.this.goB.mg(FrsFragment.this.goI.tk(i));
            }
            e.b bVar = new e.b();
            if (aqVar != null) {
                bVar.isSuccess = aqVar.errCode == 0;
                bVar.errorCode = aqVar.errCode;
                bVar.errorMsg = aqVar.errMsg;
                if (bVar.isSuccess) {
                    if (com.baidu.tbadk.core.util.v.isEmpty(arrayList)) {
                        FrsFragment.this.gok.bdr();
                    } else if (aqVar.hasMore) {
                        if (com.baidu.tbadk.core.util.v.getCount(FrsFragment.this.gnK.getThreadList()) > 3) {
                            FrsFragment.this.gok.bdp();
                        } else {
                            FrsFragment.this.gok.bFg();
                        }
                    } else if (aqVar.gsr) {
                        FrsFragment.this.gok.bdq();
                    } else {
                        FrsFragment.this.gok.bdr();
                    }
                }
            } else {
                aqVar = new aq();
                aqVar.pn = 1;
                aqVar.hasMore = false;
                aqVar.gsr = false;
            }
            if (i == 1) {
                FrsFragment.this.gow = true;
                FrsFragment.this.gpx.a(FrsFragment.this.goA.getType(), false, bVar);
            } else {
                FrsFragment.this.a(bVar);
                if (FrsFragment.this.goA.bIK() != null) {
                    FrsFragment.this.gnK = FrsFragment.this.goA.bIK();
                }
                FrsFragment.this.bEf();
            }
            if (FrsFragment.this.gpE != null) {
                FrsFragment.this.gpE.a(i, i2, aqVar, arrayList);
            }
        }
    };
    private FrsTabViewController.a gpk = new FrsTabViewController.a() { // from class: com.baidu.tieba.frs.FrsFragment.40
        @Override // com.baidu.tieba.frs.vc.FrsTabViewController.a
        public void mA(int i) {
            boolean z = false;
            if (i != 1) {
                com.baidu.tieba.card.r.bve().kp(false);
                FrsFragment.this.le(false);
            }
            if (i == 502) {
                FrsFragment.this.gol.setIconFade(R.drawable.btn_frs_professional_edit_n);
            } else {
                FrsFragment.this.gol.setIconFade(0);
            }
            FrsFragment.this.gpl = i;
            FrsFragment.this.bEi();
            com.baidu.tieba.frs.d.d.gwo.gJn = i;
            com.baidu.tieba.frs.d.d.gwo.gJo = -1;
            com.baidu.tieba.frs.a bCT = com.baidu.tieba.frs.a.bCT();
            if (i == 1 && FrsFragment.this.gpc) {
                z = true;
            }
            bCT.I(z, true);
        }
    };
    private CustomMessageListener gpm = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIVE_COUNT) { // from class: com.baidu.tieba.frs.FrsFragment.41
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                FrsFragment.this.goC.us(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    };
    private CustomMessageListener gpn = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_LIVE_START) { // from class: com.baidu.tieba.frs.FrsFragment.42
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && ((Integer) customResponsedMessage.getData()).intValue() == 51 && FrsFragment.this.gnK != null) {
                com.baidu.tieba.frs.f.j.a(FrsFragment.this.gnK, FrsFragment.this.getPageContext());
            }
        }
    };
    private final CustomMessageListener gpo = new CustomMessageListener(CmdConfigCustom.CMD_FRS_SELECT_ALA_LIVE_TAB) { // from class: com.baidu.tieba.frs.FrsFragment.43
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                FrsFragment.this.goC.uq(49);
            }
        }
    };
    private final CustomMessageListener gpp = new CustomMessageListener(CmdConfigCustom.CMD_FRS_EXPERIENCE_TIP) { // from class: com.baidu.tieba.frs.FrsFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.t) && FrsFragment.this.gnK != null) {
                FrsFragment.this.gnK.updateLikeData((com.baidu.tieba.tbadkCore.t) customResponsedMessage.getData());
                FrsFragment.this.goB.i(FrsFragment.this.gnK);
                FrsFragment.this.goC.a(FrsFragment.this.gnK, FrsFragment.this.goA.bJn());
            }
        }
    };
    private final AntiHelper.a gpq = new AntiHelper.a() { // from class: com.baidu.tieba.frs.FrsFragment.3
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).X("obj_locate", at.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).X("obj_locate", at.a.LOCATE_LIKE_PERSON));
        }
    };
    private CustomMessageListener gpr = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.FrsFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(FrsFragment.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().dnT != null) {
                        if (AntiHelper.a(FrsFragment.this.getActivity(), updateAttentionMessage.getData().dnT, FrsFragment.this.gpq) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).X("obj_locate", at.a.LOCATE_LIKE_PERSON));
                        }
                    } else if (updateAttentionMessage.getData().isSucc && updateAttentionMessage.getData().isAttention) {
                        com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getPageContext().getPageActivity(), (int) R.string.attention_success);
                    }
                }
            }
        }
    };
    private CustomMessageListener gps = new CustomMessageListener(2921346) { // from class: com.baidu.tieba.frs.FrsFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsFragment.this.refresh();
        }
    };
    private CustomMessageListener gpt = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.frs.FrsFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                FrsFragment.this.gok.c((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener gpu = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_REMIND) { // from class: com.baidu.tieba.frs.FrsFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewsRemindMessage newsRemindMessage;
            if (customResponsedMessage != null && (customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626 && (newsRemindMessage = (NewsRemindMessage) customResponsedMessage) != null) {
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (FrsFragment.this.gok != null) {
                    FrsFragment.this.gok.D(notificationCount, z);
                }
            }
        }
    };
    private final CustomMessageListener gpv = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.frs.FrsFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.isResumed()) {
                FrsFragment.this.bEw();
            }
        }
    };
    private CustomMessageListener gpw = new CustomMessageListener(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER) { // from class: com.baidu.tieba.frs.FrsFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (FrsFragment.this.gok != null) {
                    FrsFragment.this.gok.setExpanded(booleanValue);
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.p gpx = new com.baidu.tieba.tbadkCore.p() { // from class: com.baidu.tieba.frs.FrsFragment.10
        private long startTime = 0;

        @Override // com.baidu.tieba.tbadkCore.p
        public void sG(int i) {
            this.startTime = System.nanoTime();
            if (FrsFragment.this.gok != null) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsFragment.this.gok.bER();
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
            if (FrsFragment.this.enT) {
                FrsFragment.this.enT = false;
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.gok, FrsFragment.this.gnK, FrsFragment.this.getForumId(), false, null);
            }
            FrsFragment.this.bDQ();
            FrsFragment.this.got = true;
            if (bVar != null && bVar.isSuccess) {
                FrsFragment.this.gok.bFd().lO(com.baidu.tbadk.core.util.ar.aGB().aGC());
                FrsFragment.goq = 0L;
                FrsFragment.gor = 0L;
                FrsFragment.mNetError = 0;
            } else {
                FrsFragment.mNetError = 1;
            }
            if (!FrsFragment.this.goA.bJr() && (i == 3 || i == 6)) {
                FrsFragment.this.goL.resetData();
            }
            FrsFragment.this.goo = System.currentTimeMillis();
            if (FrsFragment.this.goA.bIK() != null) {
                FrsFragment.this.gnK = FrsFragment.this.goA.bIK();
            }
            FrsFragment.this.gok.b(FrsFragment.this.gnK.getRedpacketRainData());
            FrsFragment.this.sC(1);
            if (i == 7) {
                FrsFragment.this.sD(FrsFragment.this.gnK.getFrsDefaultTabId());
                return;
            }
            if (FrsFragment.this.gnK.getPage() != null) {
                FrsFragment.this.setHasMore(FrsFragment.this.gnK.getPage().aBi());
            }
            if (i == 4) {
                if (!FrsFragment.this.goA.bJr() && TbadkCoreApplication.getInst().isRecAppExist() && FrsFragment.this.goA.bJi() == 1) {
                    FrsFragment.this.gnK.addRecommendAppToThreadList(FrsFragment.this);
                }
                ArrayList<com.baidu.adp.widget.ListView.m> a2 = FrsFragment.this.goL.a(false, false, FrsFragment.this.gnK.getThreadList(), FrsFragment.this.gog, false);
                if (a2 != null) {
                    FrsFragment.this.gnK.setThreadList(a2);
                    FrsFragment.this.gnK.checkLiveStageInThreadList();
                }
                if (FrsFragment.this.goA != null) {
                    com.baidu.tieba.frs.d.c.a(FrsFragment.this.gnK, FrsFragment.this.goA.bJn(), 2, FrsFragment.this.getContext());
                }
                com.baidu.tieba.frs.f.a.a(FrsFragment.this, FrsFragment.this.gnK.getForum(), FrsFragment.this.gnK.getThreadList(), false, FrsFragment.this.getPn());
                FrsFragment.this.gok.a(a2, FrsFragment.this.gnK);
                FrsFragment.this.bDR();
                return;
            }
            FrsFragment.this.bDR();
            switch (i) {
                case 1:
                    FrsFragment.this.gok.bER();
                    break;
                case 2:
                    FrsFragment.this.gok.bER();
                    break;
                case 3:
                case 6:
                    if (FrsFragment.this.gnK != null) {
                        FrsFragment.this.gnK.clearPostThreadCount();
                    }
                    if (FrsFragment.this.goQ != null) {
                        FrsFragment.this.goQ.refresh();
                        break;
                    }
                    break;
            }
            FrsFragment.this.bDY();
            if (bVar == null || bVar.errorCode == 0) {
                if (FrsFragment.this.gnK != null) {
                    FrsFragment.this.a(FrsFragment.this.gnK);
                    FrsFragment.this.L(false, i == 5);
                    if (FrsFragment.this.goA != null) {
                        if (FrsFragment.this.gnK.getActivityHeadData() != null && FrsFragment.this.gnK.getActivityHeadData().aAv() != null && FrsFragment.this.gnK.getActivityHeadData().aAv().size() > 0) {
                            com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), 1, FrsFragment.this.gnK.getForum(), FrsFragment.this.goA.getSortType(), 1);
                        }
                        if (FrsFragment.this.gnK.getThreadList() != null && FrsFragment.this.gnK.getThreadList().size() > 0) {
                            Iterator<com.baidu.adp.widget.ListView.m> it = FrsFragment.this.gnK.getThreadList().iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    com.baidu.adp.widget.ListView.m next = it.next();
                                    if ((next instanceof bj) && ((bj) next).getType() == bj.cTc) {
                                        com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), 1, FrsFragment.this.gnK.getForum(), FrsFragment.this.goA.getSortType(), 2);
                                    }
                                }
                            }
                        }
                        com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), FrsFragment.this.gnK.getThreadList(), FrsFragment.this.gnK.getForum(), FrsFragment.this.goA.getSortType());
                    }
                    FrsFragment.this.gok.sP(i);
                    FrsFragment.goq = (System.nanoTime() - this.startTime) / TimeUtils.NANOS_PER_MS;
                    if (bVar != null) {
                        FrsFragment.gor = bVar.keg;
                    }
                } else {
                    return;
                }
            } else if (FrsFragment.this.gnK == null || com.baidu.tbadk.core.util.v.isEmpty(FrsFragment.this.gnK.getThreadList())) {
                FrsFragment.this.a(bVar);
            } else if (bVar.fZn) {
                FrsFragment.this.showToast(FrsFragment.this.getPageContext().getResources().getString(R.string.net_error_text, bVar.errorMsg, Integer.valueOf(bVar.errorCode)));
            }
            FrsFragment.this.bDV();
            FrsFragment.this.bDW();
            if (FrsFragment.this.gnK.getAccessFlag() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11384"));
            }
            if (FrsFragment.this.goh && FrsFragment.this.goC.uq(49)) {
                FrsFragment.this.goh = false;
            }
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.p
        public void c(com.baidu.tieba.tbadkCore.l lVar) {
            if ((lVar != null && ("normal_page".equals(FrsFragment.this.goA.getPageType()) || "frs_page".equals(FrsFragment.this.goA.getPageType()) || "book_page".equals(FrsFragment.this.goA.getPageType()))) || "brand_page".equals(FrsFragment.this.goA.getPageType())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE, lVar));
                FrsFragment.this.b(lVar);
                FrsFragment.gon = lVar;
            }
        }
    };
    private final CustomMessageListener gpy = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.frs.FrsFragment.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.m) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                FrsFragment.this.gnK.updateCurrentUserPendant((com.baidu.tbadk.data.m) customResponsedMessage.getData());
                FrsFragment.this.gok.bFd().notifyDataSetChanged();
            }
        }
    };
    private final CustomMessageListener mMemListener = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_MEM) { // from class: com.baidu.tieba.frs.FrsFragment.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && FrsFragment.this.gnK != null && (userData = FrsFragment.this.gnK.getUserData()) != null) {
                userData.setIsMem(num.intValue());
                if (num.intValue() != 0) {
                    FrsFragment.this.goB.k(num);
                }
            }
        }
    };
    private final com.baidu.tieba.frs.mc.k gpz = new com.baidu.tieba.frs.mc.k() { // from class: com.baidu.tieba.frs.FrsFragment.22
        @Override // com.baidu.tieba.frs.mc.k
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.m> arrayList, boolean z3) {
            if (FrsFragment.this.goE != null && FrsFragment.this.goA != null && FrsFragment.this.goA.bJr() && z && !z2 && !z3) {
                FrsFragment.this.goE.tQ(i2);
            }
        }
    };
    public final View.OnTouchListener drz = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.FrsFragment.24
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (FrsFragment.this.goS != null) {
                FrsFragment.this.goS.onTouch(view, motionEvent);
            }
            if (FrsFragment.this.goG != null && FrsFragment.this.goG.bFJ() != null) {
                FrsFragment.this.goG.bFJ().onTouchEvent(motionEvent);
            }
            if (FrsFragment.this.eCe != null) {
                FrsFragment.this.eCe.c(view, motionEvent);
            }
            if (FrsFragment.this.goB != null) {
                FrsFragment.this.goB.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private final CustomMessageListener gpA = new CustomMessageListener(CmdConfigCustom.CMD_GOTOLIVE_HOST_UPGRADE) { // from class: com.baidu.tieba.frs.FrsFragment.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.aFB().getInt(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.PHOTOLIVE_HOSTLEVEL, -1) != -1 && FrsFragment.this.gnK.getForum() != null) {
                FrsFragment.this.gnK.getForum().setCanAddPhotoLivePost(true);
            }
        }
    };
    public final View.OnClickListener gpB = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.27
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsFragment.this.gok == null || view != FrsFragment.this.gok.bEP() || FrsFragment.this.getActivity() == null) {
                if (FrsFragment.this.gnK != null && FrsFragment.this.gnK.getForum() != null && FrsFragment.this.gok != null && view == FrsFragment.this.gok.bEV()) {
                    if (FrsFragment.this.goU == null) {
                        FrsFragment.this.goU = new com.baidu.tieba.frs.view.c(FrsFragment.this.getPageContext());
                    }
                    FrsFragment.this.goU.m(FrsFragment.this.gnK);
                    FrsFragment.this.goU.showDialog();
                    return;
                }
                if (view.getId() == R.id.game_activity_egg_layout && com.baidu.adp.lib.util.l.isNetOk()) {
                    TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_CLICK);
                    if (FrsFragment.this.gok.bFa()) {
                        FrsFragment.this.gok.bFb();
                    } else {
                        String activityUrl = FrsFragment.this.gnK.getForum().getYuleData().aEw().getActivityUrl();
                        if (!StringUtils.isNull(activityUrl)) {
                            com.baidu.tbadk.browser.a.startInternalWebActivity(FrsFragment.this.getPageContext().getPageActivity(), activityUrl);
                        }
                    }
                }
                if (view == FrsFragment.this.gok.bFh() && FrsFragment.this.goA != null && FrsFragment.this.goA.hasMore()) {
                    FrsFragment.this.gok.bdp();
                    FrsFragment.this.bcd();
                }
                if (view != null && view == FrsFragment.this.gok.bEX() && bc.checkUpIsLogin(FrsFragment.this.getContext())) {
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
        private int gpO = 0;
        private int ejQ = 0;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsFragment.this.gpf += i2;
            if (FrsFragment.this.gpf >= FrsFragment.this.cdu * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
            if (FrsFragment.this.goJ != null) {
                FrsFragment.this.goJ.bKe();
            }
            this.gpO = 0;
            this.ejQ = 0;
            if (recyclerView != null && (recyclerView instanceof BdRecyclerView)) {
                this.gpO = ((BdRecyclerView) recyclerView).getFirstVisiblePosition();
                this.ejQ = ((BdRecyclerView) recyclerView).getLastVisiblePosition();
            }
            if (FrsFragment.this.goV != null) {
                FrsFragment.this.goV.a(recyclerView, this.gpO, this.ejQ);
            }
            if (FrsFragment.this.gnK != null && FrsFragment.this.gok != null && FrsFragment.this.gok.bFd() != null) {
                FrsFragment.this.gok.bE(this.gpO, this.ejQ);
                if (FrsFragment.this.goz != null && FrsFragment.this.goz.nk() != null) {
                    FrsFragment.this.goz.nk().b(FrsFragment.this.goy);
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (FrsFragment.this.goB != null) {
                FrsFragment.this.goB.setScrollState(i);
            }
            if ((i == 2 || i == 1) && !FrsFragment.this.gou) {
                FrsFragment.this.gou = true;
                FrsFragment.this.gok.bFf();
            }
            if (FrsFragment.this.gov == null && !FrsFragment.this.bEq()) {
                FrsFragment.this.gov = new com.baidu.tbadk.n.b();
                FrsFragment.this.gov.setSubType(1000);
            }
            if (i == 0) {
                if (FrsFragment.this.gov != null) {
                    FrsFragment.this.gov.aRa();
                }
                com.baidu.tieba.card.r.bve().kp(true);
                FrsFragment.this.le(true);
                FrsFragment.this.gok.bD(this.gpO, this.ejQ);
            } else if (FrsFragment.this.gov != null) {
                FrsFragment.this.gov.aQZ();
            }
            if (FrsFragment.this.goV != null) {
                FrsFragment.this.goV.onScrollStateChanged(recyclerView, i);
            }
            if (i == 0) {
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.gok, FrsFragment.this.gnK, FrsFragment.this.getForumId(), false, null);
            }
            if (FrsFragment.this.goC != null && i == 1) {
                FrsFragment.this.goC.bKY();
            }
            if (FrsFragment.this.goz == null) {
                if (FrsFragment.this.gok.bEI() != null && !FrsFragment.this.gok.bEo() && FrsFragment.this.gok.bEI().cyG() != null && (FrsFragment.this.gok.bEI().cyG().getTag() instanceof com.baidu.card.af)) {
                    FrsFragment.this.goz = (com.baidu.card.af) FrsFragment.this.gok.bEI().cyG().getTag();
                }
            } else if (i == 0 && FrsFragment.this.gok.bEI() != null && !FrsFragment.this.gok.bEo() && FrsFragment.this.gok.bEI().cyG() != null && (FrsFragment.this.gok.bEI().cyG().getTag() instanceof com.baidu.card.af)) {
                FrsFragment.this.goz = (com.baidu.card.af) FrsFragment.this.gok.bEI().cyG().getTag();
            }
            if (i == 1) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921418));
            }
        }
    };
    private final d gpC = new d() { // from class: com.baidu.tieba.frs.FrsFragment.29
        @Override // com.baidu.tieba.frs.d
        public void a(int i, int i2, View view, View view2, bj bjVar) {
            if (i != FrsFragment.this.gok.bFd().bHb()) {
                if (i != FrsFragment.this.gok.bFd().bHc()) {
                    if (i == FrsFragment.this.gok.bFd().bGZ() && FrsFragment.this.gnK != null && FrsFragment.this.gnK.getUserData() != null && FrsFragment.this.gnK.getUserData().isBawu()) {
                        String bawuCenterUrl = FrsFragment.this.gnK.getBawuCenterUrl();
                        if (!com.baidu.tbadk.core.util.aq.isEmpty(bawuCenterUrl) && FrsFragment.this.gnK.getForum() != null) {
                            com.baidu.tbadk.browser.a.startWebActivity(FrsFragment.this.getPageContext().getPageActivity(), bawuCenterUrl);
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10502").cy("fid", FrsFragment.this.gnK.getForum().getId()).cy("uid", FrsFragment.this.gnK.getUserData().getUserId()));
                        }
                    }
                } else if (bc.checkUpIsLogin(FrsFragment.this.getPageContext().getPageActivity())) {
                    TiebaStatic.log(CommonStatisticKey.MY_SERVICE_CK);
                    if (FrsFragment.this.gnK != null && FrsFragment.this.gnK.getForum() != null) {
                        ForumData forum = FrsFragment.this.gnK.getForum();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(forum.getId(), 0L), forum.getName(), forum.getImage_url(), 0)));
                    }
                }
            } else if (bc.checkUpIsLogin(FrsFragment.this.getActivity())) {
                TiebaStatic.log("forum_fortune_click");
                com.baidu.tieba.frs.f.i.b(FrsFragment.this.getPageContext(), FrsFragment.this.gnK);
            }
        }
    };
    private final NoNetworkView.a glJ = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.FrsFragment.30
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (FrsFragment.this.goA.bJi() == 1 && z && !FrsFragment.this.gok.bEo()) {
                if (FrsFragment.this.gnK == null || com.baidu.tbadk.core.util.v.isEmpty(FrsFragment.this.gnK.getThreadList())) {
                    FrsFragment.this.hideNetRefreshView(FrsFragment.this.gok.bsC());
                    FrsFragment.this.showLoadingView(FrsFragment.this.gok.bsC(), true);
                    FrsFragment.this.gok.lo(false);
                    FrsFragment.this.refresh();
                    return;
                }
                FrsFragment.this.gok.bER();
            }
        }
    };
    private final CustomMessageListener doq = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.FrsFragment.31
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                com.baidu.tieba.frs.f.c.a(customResponsedMessage, FrsFragment.this.gok, FrsFragment.this.gnK);
            }
        }
    };
    private com.baidu.adp.widget.ListView.s gpD = new a();
    private aj gpE = new aj() { // from class: com.baidu.tieba.frs.FrsFragment.33
        @Override // com.baidu.tieba.frs.aj
        public void a(int i, int i2, aq aqVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
            com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.33.1
                @Override // java.lang.Runnable
                public void run() {
                    if (FrsFragment.this.gok != null && FrsFragment.this.gok.bFi()) {
                        FrsFragment.this.bcd();
                    }
                }
            });
        }
    };
    private CustomMessageListener gpF = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.frs.FrsFragment.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    FrsFragment.this.goW = true;
                }
            }
        }
    };
    private CustomMessageListener gpG = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.frs.FrsFragment.36
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                    if (FrsFragment.this.goz == null && FrsFragment.this.gok.bEI() != null && !FrsFragment.this.gok.bEo() && FrsFragment.this.gok.bEI().cyG() != null && (FrsFragment.this.gok.bEI().cyG().getTag() instanceof com.baidu.card.af)) {
                        FrsFragment.this.goz = (com.baidu.card.af) FrsFragment.this.gok.bEI().cyG().getTag();
                    }
                    if (FrsFragment.this.goz != null && FrsFragment.this.goz.nk() != null) {
                        FrsFragment.this.goz.nk().b(new a.C0052a(3));
                    }
                }
            }
        }
    };
    private CustomMessageListener gpH = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.FrsFragment.37
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.gok != null) {
                FrsFragment.this.gok.sm();
            }
        }
    };
    private CustomMessageListener gpI = new CustomMessageListener(2921437) { // from class: com.baidu.tieba.frs.FrsFragment.38
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && FrsFragment.this.isResumed()) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (FrsFragment.this.gom != null) {
                    if (booleanValue) {
                        if (FrsFragment.this.goC.bKZ() != 0 && !FrsFragment.this.gok.bFn()) {
                            FrsFragment.this.gom.show();
                            return;
                        }
                        return;
                    }
                    FrsFragment.this.gom.hide();
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.frs.loadmore.a
    public /* bridge */ /* synthetic */ com.baidu.adp.base.e getPageContext() {
        return super.getPageContext();
    }

    public com.baidu.tieba.frs.entelechy.b.b bDE() {
        return this.goI;
    }

    public com.baidu.adp.widget.ListView.s bDF() {
        return this.gpD;
    }

    public com.baidu.tieba.frs.mc.d bDG() {
        return this.goK;
    }

    public com.baidu.tieba.frs.smartsort.a bDH() {
        return this.goE;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public FrsModelController bDI() {
        return this.goA;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public com.baidu.tieba.frs.mc.c bDJ() {
        return this.goL;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public com.baidu.tieba.frs.vc.h bDK() {
        return this.goB;
    }

    public FrsTabViewController bDL() {
        return this.goC;
    }

    public al bDM() {
        return this.goG;
    }

    public void ld(boolean z) {
        this.gpe = z;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public l bDN() {
        return this.gok;
    }

    @Override // com.baidu.tieba.frs.ak
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.ak, com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.goc;
    }

    public void setForumName(String str) {
        this.goc = str;
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
        if (this.goL == null) {
            return 1;
        }
        return this.goL.getPn();
    }

    public int getPn() {
        if (this.goL == null) {
            return 1;
        }
        return this.goL.getPn();
    }

    public void setPn(int i) {
        if (this.goL != null) {
            this.goL.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.goL != null) {
            this.goL.setHasMore(i);
        }
    }

    public int bDO() {
        if (this.goL == null) {
            return -1;
        }
        return this.goL.bDO();
    }

    public boolean bDP() {
        return this.goi;
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
            this.gok.bEL();
            showNetRefreshView(this.gok.bsC(), string, true);
        } else if (340001 == bVar.errorCode) {
            a(bVar, this.gnK.getRecm_forum_list());
        } else {
            if (com.baidu.tbadk.core.util.v.isEmpty(this.gnK.getThreadList())) {
                b(bVar);
            }
            if (bEq()) {
                setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds280));
            } else {
                setNetRefreshViewEmotionDefMarginTop();
            }
        }
    }

    public void a(View view, String str, boolean z, List<RecmForumInfo> list) {
        this.gok.bEL();
        this.gok.sL(8);
        if (this.goT == null) {
            this.goT = new com.baidu.tieba.frs.view.a(getPageContext(), getNetRefreshListener());
        }
        this.goT.setSubText(str);
        this.goT.ct(list);
        this.goT.attachView(view, z);
    }

    private void a(e.b bVar, List<RecmForumInfo> list) {
        if (this.gok != null) {
            this.gok.bEL();
            this.gok.setTitle(this.goc);
            a(this.gok.bsC(), bVar.errorMsg, true, list);
        }
    }

    private void b(e.b bVar) {
        this.gok.bEL();
        if (bVar.fZn) {
            showNetRefreshView(this.gok.bsC(), TbadkCoreApplication.getInst().getString(R.string.net_error_text, new Object[]{bVar.errorMsg, Integer.valueOf(bVar.errorCode)}), true);
        } else {
            showNetRefreshView(this.gok.bsC(), bVar.errorMsg, true);
        }
    }

    public void bDQ() {
        hideLoadingView(this.gok.bsC());
        this.gok.lq(false);
        if (this.gok.bEJ() instanceof com.baidu.tieba.frs.tab.c) {
            ((com.baidu.tieba.frs.tab.c) this.gok.bEJ()).bJL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDR() {
        if (bDO() == 0 && com.baidu.tbadk.core.util.v.isEmpty(this.gnK.getThreadListIds())) {
            if (com.baidu.tbadk.core.util.v.isEmpty(this.gnK.getThreadList())) {
                this.gok.bdr();
            } else {
                this.gok.bdq();
            }
        } else if (com.baidu.tbadk.core.util.v.getCount(this.gnK.getThreadList()) > 3) {
            this.gok.bdp();
        } else {
            this.gok.bFg();
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
            bDQ();
            this.gok.bER();
            e.b bJf = this.goA.bJf();
            boolean isEmpty = com.baidu.tbadk.core.util.v.isEmpty(this.gnK.getThreadList());
            if (bJf != null && isEmpty) {
                if (this.goA.bJg() != 0) {
                    this.goA.bJl();
                    this.gok.bER();
                } else {
                    a(bJf);
                }
                this.gok.M(this.gnK.isStarForum(), false);
                return;
            }
            a(bJf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.l lVar) {
        if (lVar != null && lVar.getEntelechyTabInfo() != null && lVar.getEntelechyTabInfo().tab != null) {
            for (FrsTabInfo frsTabInfo : lVar.getEntelechyTabInfo().tab) {
                if (frsTabInfo.tab_id.intValue() == 502 && com.baidu.tbadk.core.sharedPref.b.aFB().getBoolean("first_into_tab_profession", true)) {
                    return;
                }
            }
        }
        new com.baidu.tieba.frs.ad.f(getTbPageContext()).a(lVar);
    }

    public boolean bDS() {
        return bDT() && !bDU();
    }

    private boolean bDT() {
        if (bEn() == null) {
            return false;
        }
        FrsViewData bEn = bEn();
        com.baidu.tbadk.core.data.t tVar = null;
        if (bEn.getStar() != null && !StringUtils.isNull(bEn.getStar().cKn())) {
            tVar = new com.baidu.tbadk.core.data.t();
        } else if (bEn.getActivityHeadData() != null && com.baidu.tbadk.core.util.v.getCount(bEn.getActivityHeadData().aAv()) >= 1) {
            tVar = bEn.getActivityHeadData().aAv().get(0);
        }
        return tVar != null;
    }

    public boolean bDU() {
        if (bEn() == null) {
            return false;
        }
        FrsViewData bEn = bEn();
        return (com.baidu.tbadk.core.util.v.isEmpty(bEn.getShowTopThreadList()) && bEn.getBusinessPromot() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDV() {
        boolean b;
        if (!bDX()) {
            final PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
            privateForumPopInfoData.a(this.gnK.getPrivateForumTotalInfo().getPrivatePopInfo());
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(getActivity());
            if (this.gnK.getPrivateForumTotalInfo().aBp().private_forum_status.intValue() == 1 && (com.baidu.tbadk.core.util.aq.isEmpty(privateForumPopInfoData.aBr()) || privateForumPopInfoData.aBu() != Integer.valueOf(this.forumId))) {
                privateForumPopInfoData.sy("create_success");
                privateForumPopInfoData.sz(TbadkCoreApplication.getInst().getString(R.string.frs_private_create_hint));
                privateForumPopInfoData.sA("https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.goc + "&nomenu=1");
                privateForumPopInfoData.g(Integer.valueOf(this.forumId));
                b = frsPrivateCommonDialogView.b(privateForumPopInfoData);
            } else {
                b = privateForumPopInfoData.aBu() == Integer.valueOf(this.forumId) ? frsPrivateCommonDialogView.b(privateForumPopInfoData) : false;
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
                        ba.aGE().b(FrsFragment.this.getPageContext(), new String[]{privateForumPopInfoData.aBt()});
                        aVar.dismiss();
                    }
                });
                aVar.a(new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.13
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(getPageContext()).aEA();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDW() {
        if (bDX() || this.gnK.getPrivateForumTotalInfo().aBp().private_forum_status.intValue() != 1) {
            a((Integer) null, (Integer) null, true);
        } else {
            a(this.gnK.getPrivateForumTotalInfo().aBp().private_forum_audit_status, this.gnK.getPrivateForumTotalInfo().aBq(), false);
        }
    }

    public void a(Integer num, Integer num2, boolean z) {
        final String str;
        final int i = 2;
        if (this.gok.bEW() != null) {
            TextView bEW = this.gok.bEW();
            if (z) {
                bEW.setVisibility(8);
                return;
            }
            if (num.intValue() == 2) {
                bEW.setText("修改实名认证信息");
                bEW.setVisibility(0);
                str = "https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + this.forumId + "&nomenu=1";
            } else if (num2.intValue() >= 0 && num2.intValue() <= 100) {
                bEW.setText("目标已完成" + String.valueOf(num2) + "%");
                bEW.setVisibility(0);
                str = "https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.goc + "&nomenu=1";
                i = 1;
            } else {
                bEW.setVisibility(8);
                i = 0;
                str = "";
            }
            bEW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.14
                /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13387").cy("fid", FrsFragment.this.forumId).cy("uid", TbadkCoreApplication.getCurrentAccount()).X("obj_type", i));
                    ba.aGE().b(FrsFragment.this.getPageContext(), new String[]{str});
                }
            });
        }
    }

    private boolean bDX() {
        return this.gnK == null || !this.gnK.isPrivateForum() || this.gnK.getPrivateForumTotalInfo() == null || this.gnK.getPrivateForumTotalInfo().aBp() == null || this.gnK.getUserData().getIs_manager() != 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sC(int i) {
        List<WindowToast> list;
        if (TbadkCoreApplication.isLogin() && this.gnK != null && (list = this.gnK.mWindowToast) != null && list.size() > 0) {
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
    public void bDY() {
        if (this.gnK == null || this.gnK.getForum() != null) {
            this.gok.bFc();
        } else if (this.gnK.getForum().getYuleData() != null && this.gnK.getForum().getYuleData().aEv()) {
            TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_VIEW);
            this.gok.a(this.gnK.getForum().getYuleData().aEw());
        } else {
            this.gok.bFc();
        }
    }

    private void K(boolean z, boolean z2) {
        if (this.goA != null && this.gnK != null && this.gok != null && z) {
            if (!this.goA.bJr() && this.goA.bJi() == 1) {
                if (!this.goA.bJp()) {
                    this.gnK.addCardVideoInfoToThreadList();
                    this.gnK.addVideoInfoToThreadListInTenAndFifteenFloor();
                }
                boolean z3 = false;
                if (this.gok.bFd().p(com.baidu.tieba.card.data.n.fNu)) {
                    z3 = this.gnK.addHotTopicDataToThreadList();
                }
                if (!z3) {
                    this.gnK.addFeedForumDataToThreadList();
                }
                if (TbadkCoreApplication.getInst().isRecAppExist()) {
                    this.gnK.addRecommendAppToThreadList(this);
                }
                if (!this.gok.bFd().p(bj.cRz)) {
                    this.gnK.removeAlaLiveThreadData();
                }
                this.gnK.addSchoolRecommendToThreadList();
            }
            if (!this.gok.bFd().p(bj.cRz)) {
                this.gnK.removeAlaInsertLiveData();
                this.gnK.removeAlaStageLiveDat();
            } else {
                this.gnK.addInsertLiveDataToThreadList();
                this.gnK.addStageLiveDataToThreadList();
            }
            this.gnK.checkLiveStageInThreadList();
            this.gnK.addNoticeThreadToThreadList();
            if (this.gok.bFd().p(com.baidu.tieba.h.b.gRw)) {
                this.gnK.addGameRankListToThreadList(z2);
            }
            if (TbadkCoreApplication.isLogin() && (!this.goA.bJr() || this.goA.isNetFirstLoad)) {
                this.gnK.addUserRecommendToThreadList();
            }
            this.gnK.addVideoActivityToTop();
        }
    }

    public boolean bDZ() {
        if (this.goB != null && this.goA != null) {
            this.goB.a(this.goA.getPageType(), this.gnK);
        }
        boolean z = false;
        if (this.gnK != null) {
            z = this.gnK.hasTab();
        }
        bEb();
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sD(int i) {
        an anVar = null;
        bDZ();
        bEi();
        try {
            if (this.gnK != null) {
                this.gok.a((ArrayList<com.baidu.adp.widget.ListView.m>) null, this.gnK);
                this.goB.uk(1);
                this.gok.bEU();
                this.goC.a(this.gnK, this.goA.bJn());
                com.baidu.tieba.frs.tab.d ur = this.goC.ur(this.gnK.getFrsDefaultTabId());
                if (ur != null && !TextUtils.isEmpty(ur.url)) {
                    anVar = new an();
                    anVar.ext = ur.url;
                    anVar.stType = ur.name;
                }
                this.goA.a(this.gnK.getFrsDefaultTabId(), 0, anVar);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(boolean z, boolean z2) {
        try {
            if (this.gnK != null && this.goC != null && this.goA != null) {
                if (!this.gok.bFd().p(bj.cRz)) {
                    this.gnK.removeAlaLiveThreadData();
                }
                boolean isEmpty = com.baidu.tbadk.core.util.v.isEmpty(this.gnK.getGameTabInfo());
                this.gok.lm(isEmpty);
                if (!isEmpty) {
                    if (this.goV == null) {
                        this.goV = new com.baidu.tieba.frs.vc.e(this, (NoPressedRelativeLayout) this.mRootView);
                    }
                    if (this.eCe == null) {
                        this.eCe = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
                    }
                } else {
                    this.goV = null;
                    this.eCe = null;
                }
                if (this.gnK.getForum() != null) {
                    this.goc = this.gnK.getForum().getName();
                    this.forumId = this.gnK.getForum().getId();
                }
                if (this.gnK.hasTab()) {
                    this.goC.a(this.gnK, this.goA.bJn());
                }
                if (z) {
                    K(true, z);
                } else {
                    K(this.gow, z);
                }
                bDZ();
                if (this.goI != null) {
                    this.goI.a(this.goB, this.gnK);
                }
                if (this.gnK.getPage() != null) {
                    setHasMore(this.gnK.getPage().aBi());
                }
                ArrayList<com.baidu.adp.widget.ListView.m> a2 = this.goL.a(z2, true, this.gnK.getThreadList(), null, z, false);
                if (a2 != null) {
                    this.gnK.setThreadList(a2);
                }
                this.gnK.removeRedundantUserRecommendData();
                this.gnM = this.gnK.getTopThreadSize();
                if (this.gog != null) {
                    this.gof = true;
                    this.gog.Cs(this.gnM);
                    com.baidu.tieba.frs.f.a.a(this, this.gnK.getForum(), this.gnK.getThreadList(), this.gof, getPn());
                }
                if (this.goA.bJi() == 1) {
                    bEf();
                    if (!z && this.goA.getPn() == 1) {
                        bEa();
                    }
                }
                if (this.goJ != null) {
                    this.goJ.bV(this.goC.bKV());
                }
                bDQ();
                this.gok.bEM();
                this.gok.M(true, false);
                if (z && this.gnK.isFirstTabEqualAllThread()) {
                    com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.15
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!FrsFragment.this.got && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                FrsFragment.this.gok.bFm();
                            }
                        }
                    });
                }
                if (this.gnK.getForum() != null) {
                    this.gok.Be(this.gnK.getForum().getWarningMsg());
                }
                if (this.gnK != null && this.gnK.getFrsVideoActivityData() != null && com.baidu.tbadk.core.sharedPref.b.aFB().getLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 0L) == 0) {
                    com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.16
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsFragment.this.gok.bFk();
                        }
                    }, 1000L);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FRS_SHOW_AR_ENTRY, this));
                this.gok.bEG();
                if (this.gnK != null && this.gnK.getForum() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ENTER_FORUM, new VisitedForumData(this.gnK.getForum().getId(), this.gnK.getForum().getName(), this.gnK.getForum().getImage_url(), String.valueOf(System.currentTimeMillis() / 1000), ConstantData.Forum.SPECAIL_FORUM_TYPE_LIVE.equals(this.gnK.getForum().special_forum_type), this.gnK.getForum().getThemeColorInfo(), this.gnK.getForum().getMember_num())));
                }
                this.goZ.a(this.gnK.bottomMenuList, this.gnK.getForum());
                bEw();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void le(boolean z) {
        com.baidu.tieba.s.c.cJY().b(getUniqueId(), z);
    }

    public void bEa() {
        if (this.goO == null) {
            this.goO = new com.baidu.tieba.frs.live.a(this, com.baidu.adp.lib.f.b.toInt(this.forumId, 0));
        }
        this.goO.bIQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.tbadkCore.l lVar) {
        try {
            if (!this.got && lVar != null && this.gnK != null) {
                this.gnK.receiveData(lVar);
                L(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void bEb() {
        if (this.goA != null) {
            Bd(this.goA.getPageType());
        } else {
            Bd("normal_page");
        }
    }

    private void Bd(String str) {
        lf("frs_page".equals(str));
        if (this.goI != null) {
            this.goI.a(this.goB, this.gok, this.gnK);
        }
    }

    public void lf(boolean z) {
        if (this.goM != null) {
            this.goM.bKO();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.s.c.cJY().w(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.frs_activity, viewGroup, false);
            this.gnW = new com.baidu.tieba.frs.entelechy.a();
            this.goI = this.gnW.bGF();
            this.gnV = TbadkCoreApplication.getInst().getString(R.string.frs_title_new_area);
            this.goB = new com.baidu.tieba.frs.vc.h(this, this.gnW, (FrsHeaderViewContainer) this.mRootView.findViewById(R.id.header_view_container));
            this.goC = new FrsTabViewController(this, this.mRootView);
            this.goC.registerListener();
            this.goB.a(this.goC);
            this.goC.a(this.gpk);
            Intent intent = getActivity().getIntent();
            if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                this.gnY = true;
            }
            this.gok = new l(this, this.gpB, this.gnW, this.gnY, this.goB);
            this.goZ = new com.baidu.tieba.frs.brand.buttommenu.a(getPageContext(), this.mRootView);
        } else {
            if (this.mRootView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            if (this.goC != null) {
                this.goC.registerListener();
            }
            this.gok.bFj();
            this.mRootView.setLeft(0);
            this.mRootView.setRight(com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getContext()));
        }
        this.gpd = true;
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        ArrayList<com.baidu.adp.widget.ListView.m> arrayList = null;
        this.fVe = System.currentTimeMillis();
        this.beginTime = this.fVe;
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.goh = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.fVe = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            ai(intent);
        }
        this.dDv = this.beginTime - this.fVe;
        this.gog = new com.baidu.tieba.tbadkCore.data.f("frs", com.baidu.tieba.tbadkCore.data.f.kfQ);
        if (this.goA == null) {
            this.goA = new FrsModelController(this, this.gpx);
            this.goA.a(this.gpj);
            this.goA.init();
        }
        if (intent != null) {
            this.goA.ad(intent.getExtras());
        } else if (bundle != null) {
            this.goA.ad(bundle);
        } else {
            this.goA.ad(null);
        }
        if (intent != null) {
            this.goB.aj(intent.getExtras());
        } else if (bundle != null) {
            this.goB.aj(bundle);
        } else {
            this.goB.aj(null);
        }
        this.goj = getVoiceManager();
        this.goP = new k(getPageContext(), this);
        initUI();
        initData(bundle);
        if (!bEq()) {
            this.goG = new al(getActivity(), this.gok, this.goB);
            this.goG.lD(true);
        }
        this.goj = getVoiceManager();
        if (this.goj != null) {
            this.goj.onCreate(getPageContext());
        }
        new com.baidu.tieba.frs.mc.i();
        int i = -1;
        if (this.goL != null && this.goL.bJb() != null) {
            i = this.goL.bJb().bDO();
            arrayList = this.goL.bJb().getDataList();
        }
        this.goL = new com.baidu.tieba.frs.mc.c(this, this.gpz);
        this.goL.bJb().setHasMore(i);
        if (arrayList != null && arrayList.size() > 0) {
            this.goL.bJb().at(arrayList);
        }
        this.goE = new com.baidu.tieba.frs.smartsort.a(this);
        this.goM = new com.baidu.tieba.frs.vc.j(this);
        this.goJ = new com.baidu.tieba.frs.vc.a(getPageContext(), this.goA.bJo());
        this.goF = new com.baidu.tieba.frs.mc.b(this);
        this.goK = new com.baidu.tieba.frs.mc.d(this);
        this.goD = new com.baidu.tieba.frs.mc.h(this);
        this.goN = new com.baidu.tieba.frs.mc.a(this);
        this.goQ = new com.baidu.tieba.frs.vc.c(this);
        this.goR = new com.baidu.tieba.frs.mc.e(this, getUniqueId());
        this.goX = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "frs");
        this.goY = new com.baidu.tieba.ala.a(getPageContext());
        this.gpa = new com.baidu.tieba.frs.sportspage.notification.a(getPageContext());
        registerListener(this.gpr);
        registerListener(this.mMemListener);
        registerListener(this.gpp);
        registerListener(this.gpA);
        registerListener(this.gpy);
        registerListener(this.gpm);
        registerListener(this.gpn);
        registerListener(this.gpo);
        registerListener(this.gpg);
        registerListener(this.gph);
        registerListener(this.KN);
        registerListener(this.gpF);
        registerListener(this.gpt);
        registerListener(this.gpi);
        registerListener(this.gpu);
        registerListener(this.gps);
        registerListener(this.gpv);
        registerListener(this.gpw);
        this.gpG.setTag(getPageContext().getUniqueId());
        MessageManager.getInstance().registerListener(this.gpG);
        registerListener(this.gpH);
        registerListener(this.gpI);
        this.gok.lo(false);
        if (!bEq() && !this.hasInit) {
            showLoadingView(this.gok.bsC(), true);
            this.goA.F(3, false);
        }
        com.baidu.tieba.frs.a.bCT().a(new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.19
            @Override // com.baidu.tieba.frs.a.b
            public void J(boolean z, boolean z2) {
                if (FrsFragment.this.gok != null) {
                    FrsFragment.this.gok.sM(z ? 0 : 8);
                    if (!z2) {
                        FrsFragment.this.gpc = z;
                    }
                    if (FrsFragment.this.gok.bFd() != null && FrsFragment.this.goA != null && FrsFragment.this.goA.bJj()) {
                        FrsFragment.this.gok.bFd().notifyDataSetChanged();
                    }
                    if (FrsFragment.this.bDL() != null) {
                        FrsTabViewController.b bKW = FrsFragment.this.bDL().bKW();
                        if (bKW != null && bKW.tabId == 502 && (bKW.fragment instanceof FrsCommonTabFragment)) {
                            ((FrsCommonTabFragment) bKW.fragment).bGA();
                        } else if (bKW != null && bKW.tabId == 503 && (bKW.fragment instanceof FrsNewAreaFragment)) {
                            FrsNewAreaFragment frsNewAreaFragment = (FrsNewAreaFragment) bKW.fragment;
                            frsNewAreaFragment.bGA();
                            if (frsNewAreaFragment.bJv() != null) {
                                com.baidu.tieba.frs.mc.g bJv = frsNewAreaFragment.bJv();
                                bJv.lr(!z);
                                bJv.ls(!z);
                            }
                        }
                        if (FrsFragment.this.bDL().bKP() != null) {
                            FrsFragment.this.bDL().bKP().setmDisallowSlip(z);
                            FrsFragment.this.bDL().mh(z);
                        }
                    }
                    if (FrsFragment.this.gok.bEK() != null) {
                        FrsFragment.this.gok.ll(!z);
                    }
                    if (FrsFragment.this.getActivity() instanceof FrsActivity) {
                        ((FrsActivity) FrsFragment.this.getActivity()).lc(!z);
                    }
                    if (FrsFragment.this.goZ != null) {
                        FrsFragment.this.goZ.lK(!z);
                    }
                    FrsFragment.this.gok.lr(!z);
                    FrsFragment.this.gok.ls(z ? false : true);
                }
            }

            @Override // com.baidu.tieba.frs.a.b
            public void sz(int i2) {
                if (FrsFragment.this.gok != null) {
                    FrsFragment.this.gok.sN(i2);
                }
            }

            @Override // com.baidu.tieba.frs.a.b
            public void bDa() {
                com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getContext(), (int) R.string.frs_multi_delete_max_num);
            }
        });
        this.gok.b(new d.a() { // from class: com.baidu.tieba.frs.FrsFragment.20
            @Override // com.baidu.tieba.NEGFeedBack.d.a
            public void a(DeleteThreadHttpResponseMessage deleteThreadHttpResponseMessage) {
                boolean z;
                int i2 = 0;
                if (deleteThreadHttpResponseMessage != null) {
                    FrsFragment.this.gok.aWl();
                    FrsFragment.this.gok.bFl();
                    FrsNewAreaFragment frsNewAreaFragment = null;
                    if (FrsFragment.this.goC == null || FrsFragment.this.goC.bKW() == null || !(FrsFragment.this.goC.bKW().fragment instanceof FrsNewAreaFragment)) {
                        z = false;
                    } else {
                        frsNewAreaFragment = (FrsNewAreaFragment) FrsFragment.this.goC.bKW().fragment;
                        z = true;
                    }
                    if (deleteThreadHttpResponseMessage.getError() == 0) {
                        String text = !TextUtils.isEmpty(deleteThreadHttpResponseMessage.getText()) ? deleteThreadHttpResponseMessage.getText() : FrsFragment.this.getString(R.string.delete_fail);
                        if (deleteThreadHttpResponseMessage.getRetType() == 1211066) {
                            if (FrsFragment.this.fLN == null) {
                                FrsFragment.this.fLN = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.fLN.sS(text);
                            FrsFragment.this.fLN.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.20.1
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.fLN.fH(false);
                            FrsFragment.this.fLN.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.fLN.aEA();
                        } else if (deleteThreadHttpResponseMessage.getRetType() == 1211067) {
                            if (FrsFragment.this.fLN == null) {
                                FrsFragment.this.fLN = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.fLN.sS(text);
                            FrsFragment.this.fLN.a(R.string.know, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.20.2
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.fLN.fH(false);
                            FrsFragment.this.fLN.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.fLN.aEA();
                        } else {
                            FrsFragment.this.gok.az(deleteThreadHttpResponseMessage.getText(), ContextCompat.getColor(FrsFragment.this.getContext(), deleteThreadHttpResponseMessage.getRetType() == 1 ? R.color.nav_bar_tip_error : R.color.cp_link_tip_a_alpha95));
                        }
                        if (z && frsNewAreaFragment != null) {
                            frsNewAreaFragment.co(deleteThreadHttpResponseMessage.getSuccessItems());
                        }
                        FrsFragment.this.cd(deleteThreadHttpResponseMessage.getSuccessItems());
                        com.baidu.tieba.frs.a.bCT().cc(deleteThreadHttpResponseMessage.getSuccessItems());
                        for (com.baidu.adp.widget.ListView.m mVar : FrsFragment.this.gnK.getThreadList()) {
                            if (mVar instanceof bi) {
                                i2++;
                                continue;
                            }
                            if (i2 >= 6) {
                                break;
                            }
                        }
                        if (i2 < 6) {
                            FrsFragment.this.bcd();
                            return;
                        }
                        return;
                    }
                    com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getActivity(), deleteThreadHttpResponseMessage.getErrorString());
                }
            }
        });
        this.cdu = UtilHelper.getScreenHeight(getActivity());
        this.hasInit = true;
        sE(1);
        super.onActivityCreated(bundle);
        this.createTime = System.currentTimeMillis() - this.beginTime;
    }

    public void lg(boolean z) {
        if (this.goC != null) {
            this.goC.gMP = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cd(List<String> list) {
        if (!com.baidu.tbadk.core.util.v.isEmpty(list)) {
            ArrayList<com.baidu.adp.widget.ListView.m> threadList = this.gnK.getThreadList();
            if (!com.baidu.tbadk.core.util.v.isEmpty(threadList) && this.gok.getListView() != null && this.gok.getListView().getData() != null) {
                Iterator<com.baidu.adp.widget.ListView.m> it = threadList.iterator();
                List<com.baidu.adp.widget.ListView.m> data = this.gok.getListView().getData();
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.m next = it.next();
                    if (next instanceof bi) {
                        bj bjVar = ((bi) next).cRe;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= list.size()) {
                                break;
                            } else if (!com.baidu.tbadk.core.util.aq.equals(list.get(i2), bjVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.goL.d(next);
                                this.gok.getListView().getAdapter().notifyItemRemoved(i);
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
    public void bcx() {
        if (isAdded() && this.enT && !isLoadingViewAttached()) {
            showLoadingView(this.gok.bsC(), true);
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void bcy() {
        if (isAdded() && this.enT && isLoadingViewAttached()) {
            hideLoadingView(this.gok.bsC());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (bEq()) {
            showLoadingView(this.gok.bsC(), true);
            this.gok.sO(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.goA.F(3, true);
            aIf().scrollToPosition(0);
        }
    }

    private void sE(int i) {
        String str = "";
        if (this.gnK != null && this.gnK.getForum() != null) {
            str = this.gnK.getForum().getId();
        }
        if (!StringUtils.isNull(str)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13008").cy("fid", str).cy("obj_type", "4").X("obj_locate", i).cy("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.z zVar) {
        if (zVar != null) {
            this.dGN = zVar.aSm();
            this.goS = zVar.aSn();
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void showFloatingView() {
        if (this.dGN != null) {
            this.dGN.hd(true);
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
                this.goc = uri.getQueryParameter("name");
                this.mFrom = uri.getQueryParameter("from");
                if (!StringUtils.isNull(this.goc)) {
                    intent.putExtra("name", this.goc);
                }
                if (!StringUtils.isNull(this.mFrom)) {
                    intent.putExtra("from", this.mFrom);
                }
                TiebaStatic.log(TbadkCoreStatisticKey.AS_INVOKE_TIEBA);
            }
            if (StringUtils.isNull(this.goc) && intent != null && intent.getParcelableExtra("key_uri") != null) {
                Uri uri2 = (Uri) intent.getParcelableExtra("key_uri");
                if (com.baidu.tbadk.BdToken.f.n(uri2)) {
                    com.baidu.tbadk.BdToken.f.axN().b(uri2, new f.a() { // from class: com.baidu.tieba.frs.FrsFragment.21
                        @Override // com.baidu.tbadk.BdToken.f.a
                        public void n(HashMap<String, Object> hashMap) {
                            if (hashMap != null && (hashMap.get(com.baidu.tbadk.BdToken.f.cIh) instanceof String)) {
                                FrsFragment.this.goc = (String) hashMap.get(com.baidu.tbadk.BdToken.f.cIh);
                            }
                        }
                    });
                } else {
                    com.baidu.tieba.frs.f.d al = com.baidu.tieba.frs.f.i.al(intent);
                    if (al != null) {
                        this.goc = al.forumName;
                        if (al.gLa == null || al.gLa.equals("aidou")) {
                        }
                    }
                }
                if (!StringUtils.isNull(this.goc)) {
                    intent.putExtra("name", this.goc);
                }
                intent.putExtra(FrsActivityConfig.FRS_CALL_FROM, 12);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.goj = getVoiceManager();
        if (this.goj != null) {
            this.goj.onStart(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        Intent intent;
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.doq);
        if (bundle != null) {
            this.goc = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
            this.goc = intent.getStringExtra("name");
            this.mFrom = intent.getStringExtra("from");
            this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
        }
        if (getArguments() != null) {
            this.god = getArguments().getBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, false);
        }
        if (TextUtils.isEmpty(this.mFrom) || FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
        }
        if (this.mIsLogin) {
            registerListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL, this.doq);
        }
        this.goB.aj(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.s.c.cJY().x(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.gpF);
        gon = null;
        if (this.goj != null) {
            this.goj.onDestory(getPageContext());
        }
        com.baidu.tieba.recapp.report.a.remove("FRS");
        this.goj = null;
        com.baidu.tieba.card.r.bve().kp(false);
        if (this.gnK != null && this.gnK.getForum() != null) {
            ab.bFH().dv(com.baidu.adp.lib.f.b.toLong(this.gnK.getForum().getId(), 0L));
        }
        if (this.goO != null) {
            this.goO.onDestory();
        }
        if (this.gok != null) {
            com.baidu.tieba.frs.f.h.a(this.gok, this.gnK, getForumId(), false, null);
            this.gok.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.gov != null) {
                this.gov.aRb();
            }
            this.gok.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.goB.aiG();
        if (this.goA != null) {
            this.goA.bgU();
        }
        if (this.goG != null) {
            this.goG.aWG();
        }
        if (this.goJ != null) {
            this.goJ.destory();
        }
        if (this.goE != null) {
            this.goE.onDestroy();
        }
        if (this.goV != null) {
            this.goV.onDestory();
        }
        if (this.goN != null) {
            this.goN.onDestroy();
        }
        if (this.goX != null) {
            this.goX.onDestroy();
        }
        if (this.goY != null) {
            this.goY.onDestroy();
        }
        com.baidu.tieba.recapp.d.a.cDi().cDk();
        com.baidu.tieba.frs.f.j.bKb();
        if (this.goC != null) {
            this.goC.a((FrsTabViewController.a) null);
            this.goC.bKY();
        }
        if (this.gpb != null) {
            this.gpb.onDestroy();
        }
        com.baidu.tieba.frs.a.bCT().a(null);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.goc);
        bundle.putString("from", this.mFrom);
        this.goA.onSaveInstanceState(bundle);
        if (this.goj != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            this.goj.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.goN != null) {
            this.goN.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.gok != null) {
            this.gok.bER();
            this.gok.onResume();
        }
        this.goD.lZ(true);
        this.gow = true;
        if (gob) {
            gob = false;
            this.gok.startPullRefresh();
            return;
        }
        if (this.goj != null) {
            this.goj.onResume(getPageContext());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_RESUME));
        this.gok.lt(false);
        if (this.goW) {
            refresh(6);
            this.goW = false;
        }
        bEw();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
    }

    public boolean bEc() {
        Intent intent;
        if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
            return false;
        }
        return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
    }

    public void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.goc = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.goe = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.goe) {
                bEd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEd() {
        this.gok.startPullRefresh();
    }

    public void closeActivity() {
        com.baidu.tieba.frs.f.i.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.mFrom);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.gok.setTitle(this.goc);
        } else {
            this.gok.setTitle("");
            this.mFlag = 1;
        }
        this.gok.a(this.gpD);
        this.gok.addOnScrollListener(this.mScrollListener);
        this.gok.g(this.glJ);
        this.gok.bFd().a(this.gpC);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gpd) {
            this.gok.onChangeSkinType(i);
            this.goB.uj(i);
            this.goC.onChangeSkinType(i);
            if (this.gom != null) {
                this.gom.onChangeSkinType(i);
            }
            if (this.goT != null) {
                this.goT.onChangeSkinType();
            }
            if (this.goZ != null) {
                this.goZ.onChangeSkinType(getPageContext(), i);
            }
            if (this.fLN != null) {
                com.baidu.tbadk.q.a.a(getPageContext(), this.fLN.getRealView());
            }
            if (this.goU != null) {
                this.goU.onChangeSkinType();
            }
            if (this.goV != null) {
                this.goV.onChangeSkinType(getPageContext(), i);
            }
        }
    }

    public void sF(int i) {
        if (!this.mIsLogin) {
            if (this.gnK != null && this.gnK.getAnti() != null) {
                this.gnK.getAnti().setIfpost(1);
            }
            if (i == 0) {
                bc.skipToLoginActivity(getActivity());
            }
        } else if (this.gnK != null) {
            if (i == 0) {
                com.baidu.tieba.frs.f.j.e(this, 0);
            } else {
                this.gok.bET();
            }
        }
    }

    public void refresh() {
        com.baidu.tieba.a.d.aXD().wN("page_frs");
        refresh(3);
    }

    public void refresh(int i) {
        this.got = false;
        bEi();
        if (this.gok != null && this.gok.bEI() != null) {
            this.gok.bEI().bOn();
        }
        if (this.goA != null) {
            this.goA.F(i, true);
        }
    }

    private void bEe() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.f.h.gy().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.26
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.Ji(FrsFragment.this.goc);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEf() {
        bEi();
        try {
            if (this.gnK != null) {
                this.gok.bgw();
                this.gok.ll(bEv());
                if (!com.baidu.tieba.frs.vc.h.l(this.gnK) || !com.baidu.tieba.frs.vc.h.k(this.gnK)) {
                }
                if (this.gnK.getForum() != null) {
                    this.goc = this.gnK.getForum().getName();
                    this.forumId = this.gnK.getForum().getId();
                }
                if (this.gnK.getPage() != null) {
                    setHasMore(this.gnK.getPage().aBi());
                }
                this.gok.setTitle(this.goc);
                this.gok.setForumName(this.goc);
                TbadkCoreApplication.getInst().setDefaultBubble(this.gnK.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.gnK.getUserData().getBimg_end_time());
                bEe();
                bEg();
                ArrayList<com.baidu.adp.widget.ListView.m> threadList = this.gnK.getThreadList();
                if (threadList != null) {
                    this.gok.a(threadList, this.gnK);
                    com.baidu.tieba.frs.f.c.y(this.gok);
                    this.goB.uk(getPageNum());
                    this.goB.i(this.gnK);
                    this.goC.a(this.gnK, this.goA.bJn());
                    this.gok.bEU();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void bEg() {
        if (this.gnK != null) {
            if (this.gnK.getIsNewUrl() == 1) {
                this.gok.bFd().setFromCDN(true);
            } else {
                this.gok.bFd().setFromCDN(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.goD.lZ(false);
        this.gow = false;
        this.gok.onPause();
        if (this.goj != null) {
            this.goj.onPause(getPageContext());
        }
        this.gok.lt(true);
        if (this.goJ != null) {
            this.goJ.bKe();
        }
        com.baidu.tbadk.BdToken.c.axx().axC();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.goC != null && this.goC.bKW() != null && (this.goC.bKW().fragment instanceof BaseFragment)) {
            ((BaseFragment) this.goC.bKW().fragment).setPrimary(z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.r.bve().kp(false);
        le(false);
        if (this.gnK != null && this.gnK.getForum() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            com.baidu.tbadk.distribute.a.aOf().a(getPageContext().getPageActivity(), "frs", this.gnK.getForum().getId(), 0L);
        }
        if (this.goj != null) {
            this.goj.onStop(getPageContext());
        }
        if (aIf() != null) {
            aIf().getRecycledViewPool().clear();
        }
        this.goB.aHz();
        com.baidu.tbadk.util.aa.aSp();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            if (this.goB != null) {
                this.goB.onPrimary(isPrimary());
            }
            if (this.gok != null) {
                this.gok.onPrimary(isPrimary());
                this.gok.lt(!isPrimary());
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (com.baidu.tieba.frs.a.bCT().bCU()) {
                com.baidu.tieba.frs.a.bCT().reset();
                return true;
            } else if (this.gok != null) {
                return this.gok.bEQ();
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
        com.baidu.tbadk.distribute.a.aOf().a(advertAppInfo, this.forumId, 0L, "FRS", str, getPn());
    }

    @Override // com.baidu.tieba.recapp.n
    public void bEh() {
        bDI().bEh();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.goj == null) {
            this.goj = VoiceManager.instance();
        }
        return this.goj;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdRecyclerView aIf() {
        if (this.gok == null) {
            return null;
        }
        return this.gok.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void bEi() {
        if (this.goj != null) {
            this.goj.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> aIg() {
        if (this.djb == null) {
            this.djb = UserIconBox.x(getPageContext().getPageActivity(), 8);
        }
        return this.djb;
    }

    public void bEj() {
        if (getFragmentActivity() != null && getFragmentActivity().getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.p onGetPreLoadListView() {
        return aIf().getPreLoadHandle();
    }

    @Override // com.baidu.tieba.frs.ai
    public NavigationBar beJ() {
        if (this.gok == null) {
            return null;
        }
        return this.gok.beJ();
    }

    public FRSRefreshButton bEk() {
        return this.gom;
    }

    public void a(FRSRefreshButton fRSRefreshButton) {
        if (fRSRefreshButton != null) {
            this.gom = fRSRefreshButton;
            this.gom.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.32
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (FrsFragment.this.goC != null) {
                        FrsTabViewController.b bKW = FrsFragment.this.goC.bKW();
                        if (bKW != null && bKW.fragment != null && (bKW.fragment instanceof ah)) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                            ((ah) bKW.fragment).scrollToTop();
                            ((ah) bKW.fragment).bdo();
                            return;
                        }
                        FrsFragment.this.bDN().startPullRefresh();
                    }
                }
            });
        }
    }

    public void bEl() {
        if (this.gom != null) {
            this.gom.hide();
        }
    }

    public void bEm() {
        if (this.gom != null) {
            this.gom.show();
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
                if (bdUniqueId == q.grn) {
                    if (FrsFragment.this.gok != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11752").cy("fid", FrsFragment.this.forumId).cy("obj_locate", "1"));
                        FrsFragment.this.gok.startPullRefresh();
                    }
                } else if (mVar != null && (mVar instanceof bi)) {
                    bj bjVar = ((bi) mVar).cRe;
                    if (bjVar.aDj() == null || bjVar.aDj().getGroup_id() == 0 || bc.checkUpIsLogin(FrsFragment.this.getActivity())) {
                        if (bjVar.aCW() != 1 || bc.checkUpIsLogin(FrsFragment.this.getActivity())) {
                            if (bjVar.aCz() != null) {
                                if (bc.checkUpIsLogin(FrsFragment.this.getActivity())) {
                                    String postUrl = bjVar.aCz().getPostUrl();
                                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.isNetOk()) {
                                        com.baidu.tbadk.browser.a.startInternalWebActivity(FrsFragment.this.getActivity(), postUrl);
                                    }
                                }
                            } else if (bjVar.aDt() != null) {
                                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                    bc.skipToLoginActivity(FrsFragment.this.getPageContext().getPageActivity());
                                    return;
                                }
                                com.baidu.tbadk.core.data.p aDt = bjVar.aDt();
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), aDt.getCartoonId(), aDt.getChapterId(), 2)));
                            } else {
                                com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                                if (readThreadHistory != null && !readThreadHistory.Jo(bjVar.getId())) {
                                    readThreadHistory.Jn(bjVar.getId());
                                }
                                boolean z = false;
                                final String aCt = bjVar.aCt();
                                if (aCt != null && !aCt.equals("")) {
                                    z = true;
                                    new Thread(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.a.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(aCt);
                                            xVar.aGe().aGF().mIsNeedAddCommenParam = false;
                                            xVar.aGe().aGF().mIsUseCurrentBDUSS = false;
                                            xVar.getNetData();
                                        }
                                    }).start();
                                }
                                String tid = bjVar.getTid();
                                if (tid == null) {
                                    tid = "";
                                }
                                if (bjVar.aCh() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                    ba.aGE().b(FrsFragment.this.getPageContext(), new String[]{tid, "", null});
                                    return;
                                }
                                if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                    bjVar.setId(tid.substring(3));
                                }
                                if (bdUniqueId.getId() == bj.cTc.getId()) {
                                    com.baidu.tieba.frs.f.h.a(bjVar.aBS());
                                } else if (bdUniqueId.getId() == bj.cRC.getId()) {
                                    com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                                    anVar.cy("obj_type", "2");
                                    anVar.cy("tid", bjVar.getTid());
                                    TiebaStatic.log(anVar);
                                }
                                com.baidu.tieba.frs.f.i.a(FrsFragment.this, bjVar, i, z);
                                com.baidu.tieba.frs.f.h.a(FrsFragment.this, FrsFragment.this.gnK, bjVar);
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
            hideNetRefreshView(this.gok.bsC());
            showLoadingView(this.gok.bsC(), true);
            this.gok.lo(false);
            this.goA.F(3, true);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData bEn() {
        return this.gnK;
    }

    public boolean bEo() {
        return this.gok.bEo();
    }

    public void at(Object obj) {
        if (this.goF != null && this.goF.gGA != null) {
            this.goF.gGA.callback(obj);
        }
    }

    public void au(Object obj) {
        if (this.goF != null && this.goF.gGB != null) {
            this.goF.gGB.callback(obj);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        this.gok.getListView().stopScroll();
        if (!this.gok.bEZ()) {
            if (!com.baidu.adp.lib.util.l.isNetOk()) {
                this.gok.bdr();
            } else if (this.goA.bJi() == 1) {
                bcs();
                bcd();
            } else if (this.goA.hasMore()) {
                bcd();
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void onFailed(String str) {
        bcs();
        showToast(str);
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void al(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        boolean isEmpty = com.baidu.tbadk.core.util.v.isEmpty(arrayList);
        setHasMore(isEmpty ? 0 : 1);
        bcs();
        if (!isEmpty) {
            if (!this.goA.bJr() && TbadkCoreApplication.getInst().isRecAppExist() && this.goA.bJi() == 1) {
                this.gnK.addRecommendAppToThreadList(this, arrayList);
            }
            if (this.goA != null) {
                com.baidu.tieba.frs.d.a.a(getUniqueId(), arrayList, this.gnK.getForum(), this.goA.getSortType());
            }
            ArrayList<com.baidu.adp.widget.ListView.m> a2 = this.goL.a(false, false, arrayList, this.gog, false);
            if (a2 != null) {
                this.gnK.setThreadList(a2);
                this.gok.a(a2, this.gnK);
            }
            if (this.goA != null) {
                com.baidu.tieba.frs.d.c.a(this.gnK, this.goA.bJn(), 2, getContext());
            }
        }
    }

    private void bcs() {
        if (bDO() == 1 || this.goL.cn(this.gnK.getThreadListIds())) {
            if (com.baidu.tbadk.core.util.v.getCount(this.gnK.getThreadList()) > 3) {
                this.gok.bdp();
            } else {
                this.gok.bFg();
            }
        } else if (com.baidu.tbadk.core.util.v.isEmpty(this.gnK.getThreadList())) {
            this.gok.bdr();
        } else {
            this.gok.bdq();
        }
    }

    @Override // com.baidu.tieba.frs.mc.l
    public void bcd() {
        if (this.goL != null) {
            this.goL.a(this.goc, this.forumId, this.gnK);
        }
    }

    public void bEp() {
        if (!com.baidu.tbadk.core.util.ab.requestWriteExternalStorgeAndCameraPermission(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.al.e(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment, com.baidu.k.a.a.InterfaceC0078a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        com.baidu.tieba.frs.f.i.a(this, i, strArr, iArr);
    }

    public void lh(boolean z) {
        if (this.goG != null) {
            this.goG.lD(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.goH.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a nS(int i) {
        return this.goH.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        this.goP.b(bVar);
    }

    public boolean bEq() {
        return this.gnY;
    }

    @Override // com.baidu.tieba.frs.af
    public void AA() {
        if (this.gok != null) {
            showFloatingView();
            this.gok.getListView().scrollToPosition(0);
            this.gok.startPullRefresh();
        }
    }

    public ForumWriteData bEr() {
        if (this.gnK == null || this.gnK.getForum() == null) {
            return null;
        }
        ForumData forum = this.gnK.getForum();
        ForumWriteData forumWriteData = new ForumWriteData(forum.getId(), forum.getName(), forum.getPrefixData(), this.gnK.getAnti());
        forumWriteData.avatar = forum.getImage_url();
        forumWriteData.forumLevel = forum.getUser_level();
        forumWriteData.specialForumType = forum.special_forum_type;
        forumWriteData.firstDir = forum.getFirst_class();
        forumWriteData.secondDir = forum.getSecond_class();
        UserData userData = this.gnK.getUserData();
        forumWriteData.privateThread = userData != null ? userData.getPrivateThread() : 0;
        return forumWriteData;
    }

    @Override // com.baidu.tieba.frs.af
    public void aHL() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void li(boolean z) {
        this.gox = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z) {
        this.gok.sL(8);
        ((FrsActivity) getActivity()).showLoadingView(view, z);
        ((FrsActivity) getActivity()).g(view, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        this.gok.sL(0);
        ((FrsActivity) getActivity()).hideLoadingView(view);
        ((FrsActivity) getActivity()).g(view, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        super.showNetRefreshView(view, getResources().getString(R.string.refresh_view_title_text), null, getResources().getString(R.string.refresh_view_button_text), z, getNetRefreshListener());
        this.gok.sL(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshViewNoClick(View view, String str, boolean z) {
        super.showNetRefreshViewNoClick(view, str, z);
        this.gok.sL(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        super.hideNetRefreshView(view);
        this.gok.sL(0);
    }

    public void bEs() {
        FrsTabViewController.b bKW;
        if (this.goC != null && (bKW = this.goC.bKW()) != null && bKW.fragment != null && (bKW.fragment instanceof ah)) {
            ((ah) bKW.fragment).scrollToTop();
        }
    }

    public void lj(boolean z) {
        this.goa = z;
    }

    public void b(OvalActionButton ovalActionButton) {
        this.gol = ovalActionButton;
    }

    public OvalActionButton bEt() {
        return this.gol;
    }

    public boolean bEu() {
        return this.goa;
    }

    public void onShareSuccess(String str) {
        if (TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.util.aq.isEmpty(str)) {
            if (this.gpb == null) {
                this.gpb = new AddExperiencedModel(getTbPageContext());
            }
            this.gpb.ev(this.forumId, str);
        }
    }

    public boolean bEv() {
        if (this.gox && !this.gpe) {
            return (this.goA != null && this.goA.bJj() && com.baidu.tieba.frs.a.bCT().bCU()) ? false : true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.g.c
    public boolean videoNeedPreload() {
        if (this.gnK != null) {
            return com.baidu.tbadk.util.af.mT(2) || (com.baidu.tbadk.util.af.aSu() && this.gnK.isFrsVideoAutoPlay);
        }
        return super.videoNeedPreload();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.g.c
    public boolean isCyberVideoUsedThisPage() {
        return com.baidu.tbadk.a.b.rH("cyber_player_test");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEw() {
        if (!com.baidu.tbadk.core.util.aq.isEmpty(this.forumId)) {
            com.baidu.tbadk.BdToken.c.axx().p(com.baidu.tbadk.BdToken.b.cGL, com.baidu.adp.lib.f.b.toLong(this.forumId, 0L));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        FrsTabViewController.b bKW;
        if (bDL() == null || (bKW = bDL().bKW()) == null || !(bKW.fragment instanceof BaseFragment)) {
            return null;
        }
        if (bKW.fragment instanceof FrsAllThreadFragment) {
            TbPageTag tbPageTag = super.getTbPageTag();
            int i = -1;
            if (this.gnK != null) {
                i = this.gnK.getSortType();
            }
            tbPageTag.sortType = com.baidu.tieba.frs.f.g.uh(i);
            tbPageTag.locatePage = "a070";
            if (this.gnV.equals(bKW.title)) {
                tbPageTag.locatePage = "a071";
            }
            return tbPageTag;
        } else if (bKW.fragment instanceof FrsFragment) {
            return null;
        } else {
            return ((BaseFragment) bKW.fragment).getTbPageTag();
        }
    }
}
