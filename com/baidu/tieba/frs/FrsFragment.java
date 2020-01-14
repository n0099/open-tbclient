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
/* loaded from: classes7.dex */
public class FrsFragment extends BaseFragment implements BdListView.e, a.InterfaceC0072a, UserIconBox.b<BdRecyclerView>, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, af, ai, ak, com.baidu.tieba.frs.loadmore.a, com.baidu.tieba.frs.mc.l, com.baidu.tieba.recapp.n {
    public static com.baidu.tieba.tbadkCore.l gmm;
    private com.baidu.tbadk.util.y dCJ;
    private com.baidu.adp.lib.d.b<TbImageView> deV;
    private com.baidu.tieba.frs.gametab.b exV;
    private com.baidu.tbadk.core.dialog.a fJq;
    private com.baidu.tieba.frs.entelechy.a glV;
    private com.baidu.tieba.frs.vc.h gmA;
    private FrsTabViewController gmB;
    private com.baidu.tieba.frs.mc.h gmC;
    private com.baidu.tieba.frs.smartsort.a gmD;
    private com.baidu.tieba.frs.mc.b gmE;
    private al gmF;
    private com.baidu.tieba.frs.entelechy.b.b gmH;
    private com.baidu.tieba.frs.vc.a gmI;
    private com.baidu.tieba.frs.mc.d gmJ;
    private com.baidu.tieba.frs.mc.c gmK;
    private com.baidu.tieba.frs.vc.j gmL;
    private com.baidu.tieba.frs.mc.a gmM;
    private com.baidu.tieba.frs.live.a gmN;
    private k gmO;
    public com.baidu.tieba.frs.vc.c gmP;
    private com.baidu.tieba.frs.mc.e gmQ;
    private View.OnTouchListener gmR;
    private com.baidu.tieba.frs.view.a gmS;
    private com.baidu.tieba.frs.view.c gmT;
    private com.baidu.tieba.frs.vc.e gmU;
    private boolean gmV;
    private com.baidu.tieba.NEGFeedBack.a gmW;
    private com.baidu.tieba.ala.a gmX;
    private com.baidu.tieba.frs.brand.buttommenu.a gmY;
    private com.baidu.tieba.frs.sportspage.notification.a gmZ;
    private com.baidu.tieba.tbadkCore.data.f gmf;
    private VoiceManager gmi;
    private OvalActionButton gmk;
    private FRSRefreshButton gml;
    public long gmn;
    private com.baidu.card.af gmy;
    private FrsModelController gmz;
    private AddExperiencedModel gna;
    private boolean gnc;
    private int gnk;
    private View mRootView;
    public static boolean gma = false;
    public static volatile long gmp = 0;
    public static volatile long gmq = 0;
    public static volatile int mNetError = 0;
    private String glU = "";
    public boolean glW = false;
    private boolean glX = false;
    private boolean glY = false;
    private boolean glZ = true;
    public String gmb = null;
    public String mFrom = null;
    public int mFlag = 0;
    public boolean gmc = false;
    private boolean gmd = false;
    private String mThreadId = null;
    public String forumId = null;
    private int glL = 0;
    private boolean gme = false;
    private boolean gmg = false;
    private boolean gmh = false;
    private l gmj = null;
    public final bj Np = null;
    private FrsViewData glJ = new FrsViewData();
    public long fSK = -1;
    public long dzB = 0;
    public long dzt = 0;
    public long createTime = 0;
    public long beginTime = -1;
    public long gmo = 0;
    public boolean gmr = false;
    private boolean gms = false;
    private boolean gmt = false;
    public com.baidu.tbadk.n.b gmu = null;
    private boolean gmv = true;
    private boolean gmw = true;
    private a.C0050a gmx = new a.C0050a(2);
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> gmG = new SparseArray<>();
    private boolean ejJ = true;
    private boolean hasInit = false;
    private boolean gnb = false;
    private boolean gnd = false;
    private int bZo = 0;
    private int gne = 0;
    public int mHeadLineDefaultNavTabId = -1;
    private final CustomMessageListener gnf = new CustomMessageListener(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED) { // from class: com.baidu.tieba.frs.FrsFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof bj) {
                    com.baidu.tieba.frs.f.h.a(FrsFragment.this.gmj, FrsFragment.this.glJ, FrsFragment.this.getForumId(), true, (bj) data);
                }
            }
        }
    };
    private CustomMessageListener gng = new CustomMessageListener(CmdConfigCustom.CMD_CLOSE_GAME_RANK_CARD) { // from class: com.baidu.tieba.frs.FrsFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.glJ != null) {
                FrsFragment.this.glJ.removeGameRankListFromThreadList();
                if (FrsFragment.this.gmj != null) {
                    FrsFragment.this.gmj.aqx();
                }
            }
        }
    };
    private CustomMessageListener Kr = new CustomMessageListener(2921401) { // from class: com.baidu.tieba.frs.FrsFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && FrsFragment.this.gml != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() <= 0 || FrsFragment.this.gmB.bJy() == 0 || FrsFragment.this.gmB.bJv() == null || !(FrsFragment.this.gmB.bJv().fragment instanceof BaseFragment) || !((BaseFragment) FrsFragment.this.gmB.bJv().fragment).isPrimary() || FrsFragment.this.gmj.bDK()) {
                    if (FrsFragment.this.gmB.bJy() != 0) {
                        FrsFragment.this.gml.hide();
                        return;
                    }
                    return;
                }
                FrsFragment.this.gml.show();
            }
        }
    };
    private CustomMessageListener gnh = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.FrsFragment.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 1) {
                    FrsFragment.this.bCA();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                }
            }
        }
    };
    private final aj gni = new aj() { // from class: com.baidu.tieba.frs.FrsFragment.39
        @Override // com.baidu.tieba.frs.aj
        public void a(int i, int i2, aq aqVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
            FrsFragment.this.bCn();
            if (FrsFragment.this.gmH != null) {
                FrsFragment.this.gmA.me(FrsFragment.this.gmH.te(i));
            }
            e.b bVar = new e.b();
            if (aqVar != null) {
                bVar.isSuccess = aqVar.errCode == 0;
                bVar.errorCode = aqVar.errCode;
                bVar.errorMsg = aqVar.errMsg;
                if (bVar.isSuccess) {
                    if (com.baidu.tbadk.core.util.v.isEmpty(arrayList)) {
                        FrsFragment.this.gmj.bbc();
                    } else if (aqVar.hasMore) {
                        if (com.baidu.tbadk.core.util.v.getCount(FrsFragment.this.glJ.getThreadList()) > 3) {
                            FrsFragment.this.gmj.bba();
                        } else {
                            FrsFragment.this.gmj.bDD();
                        }
                    } else if (aqVar.gqq) {
                        FrsFragment.this.gmj.bbb();
                    } else {
                        FrsFragment.this.gmj.bbc();
                    }
                }
            } else {
                aqVar = new aq();
                aqVar.pn = 1;
                aqVar.hasMore = false;
                aqVar.gqq = false;
            }
            if (i == 1) {
                FrsFragment.this.gmv = true;
                FrsFragment.this.gnw.a(FrsFragment.this.gmz.getType(), false, bVar);
            } else {
                FrsFragment.this.a(bVar);
                if (FrsFragment.this.gmz.bHj() != null) {
                    FrsFragment.this.glJ = FrsFragment.this.gmz.bHj();
                }
                FrsFragment.this.bCC();
            }
            if (FrsFragment.this.gnD != null) {
                FrsFragment.this.gnD.a(i, i2, aqVar, arrayList);
            }
        }
    };
    private FrsTabViewController.a gnj = new FrsTabViewController.a() { // from class: com.baidu.tieba.frs.FrsFragment.40
        @Override // com.baidu.tieba.frs.vc.FrsTabViewController.a
        public void mi(int i) {
            boolean z = false;
            if (i != 1) {
                com.baidu.tieba.card.r.btA().kn(false);
                FrsFragment.this.la(false);
            }
            if (i == 303 && i != FrsFragment.this.gnk) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13121").cp("fid", FrsFragment.this.forumId).cp("uid", TbadkCoreApplication.getCurrentAccount()));
            }
            if (i == 502) {
                FrsFragment.this.gmk.setIconFade(R.drawable.btn_frs_professional_edit_n);
            } else {
                FrsFragment.this.gmk.setIconFade(0);
            }
            FrsFragment.this.gnk = i;
            FrsFragment.this.bCF();
            com.baidu.tieba.frs.d.d.gun.gHo = i;
            com.baidu.tieba.frs.d.d.gun.gHp = -1;
            com.baidu.tieba.frs.a bBr = com.baidu.tieba.frs.a.bBr();
            if (i == 1 && FrsFragment.this.gnb) {
                z = true;
            }
            bBr.G(z, true);
        }
    };
    private CustomMessageListener gnl = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIVE_COUNT) { // from class: com.baidu.tieba.frs.FrsFragment.41
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                FrsFragment.this.gmB.um(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    };
    private CustomMessageListener gnm = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_LIVE_START) { // from class: com.baidu.tieba.frs.FrsFragment.42
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && ((Integer) customResponsedMessage.getData()).intValue() == 51 && FrsFragment.this.glJ != null) {
                com.baidu.tieba.frs.f.j.a(FrsFragment.this.glJ, FrsFragment.this.getPageContext());
            }
        }
    };
    private final CustomMessageListener gnn = new CustomMessageListener(CmdConfigCustom.CMD_FRS_SELECT_ALA_LIVE_TAB) { // from class: com.baidu.tieba.frs.FrsFragment.43
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                FrsFragment.this.gmB.uk(49);
            }
        }
    };
    private final CustomMessageListener gno = new CustomMessageListener(CmdConfigCustom.CMD_FRS_EXPERIENCE_TIP) { // from class: com.baidu.tieba.frs.FrsFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.t) && FrsFragment.this.glJ != null) {
                FrsFragment.this.glJ.updateLikeData((com.baidu.tieba.tbadkCore.t) customResponsedMessage.getData());
                FrsFragment.this.gmA.i(FrsFragment.this.glJ);
                FrsFragment.this.gmB.a(FrsFragment.this.glJ, FrsFragment.this.gmz.bHL());
            }
        }
    };
    private final AntiHelper.a gnp = new AntiHelper.a() { // from class: com.baidu.tieba.frs.FrsFragment.3
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).Z("obj_locate", at.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).Z("obj_locate", at.a.LOCATE_LIKE_PERSON));
        }
    };
    private CustomMessageListener gnq = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.FrsFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(FrsFragment.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().djO != null) {
                        if (AntiHelper.a(FrsFragment.this.getActivity(), updateAttentionMessage.getData().djO, FrsFragment.this.gnp) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).Z("obj_locate", at.a.LOCATE_LIKE_PERSON));
                        }
                    } else if (updateAttentionMessage.getData().isSucc && updateAttentionMessage.getData().isAttention) {
                        com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getPageContext().getPageActivity(), (int) R.string.attention_success);
                    }
                }
            }
        }
    };
    private CustomMessageListener gnr = new CustomMessageListener(2921346) { // from class: com.baidu.tieba.frs.FrsFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsFragment.this.refresh();
        }
    };
    private CustomMessageListener gns = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.frs.FrsFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                FrsFragment.this.gmj.c((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener gnt = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_REMIND) { // from class: com.baidu.tieba.frs.FrsFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewsRemindMessage newsRemindMessage;
            if (customResponsedMessage != null && (customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626 && (newsRemindMessage = (NewsRemindMessage) customResponsedMessage) != null) {
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (FrsFragment.this.gmj != null) {
                    FrsFragment.this.gmj.E(notificationCount, z);
                }
            }
        }
    };
    private final CustomMessageListener gnu = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.frs.FrsFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.isResumed()) {
                FrsFragment.this.bCT();
            }
        }
    };
    private CustomMessageListener gnv = new CustomMessageListener(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER) { // from class: com.baidu.tieba.frs.FrsFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (FrsFragment.this.gmj != null) {
                    FrsFragment.this.gmj.setExpanded(booleanValue);
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.p gnw = new com.baidu.tieba.tbadkCore.p() { // from class: com.baidu.tieba.frs.FrsFragment.10
        private long startTime = 0;

        @Override // com.baidu.tieba.tbadkCore.p
        public void sA(int i) {
            this.startTime = System.nanoTime();
            if (FrsFragment.this.gmj != null) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsFragment.this.gmj.bDo();
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
            if (FrsFragment.this.ejJ) {
                FrsFragment.this.ejJ = false;
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.gmj, FrsFragment.this.glJ, FrsFragment.this.getForumId(), false, null);
            }
            FrsFragment.this.bCn();
            FrsFragment.this.gms = true;
            if (bVar != null && bVar.isSuccess) {
                FrsFragment.this.gmj.bDA().lL(com.baidu.tbadk.core.util.ar.aEq().aEr());
                FrsFragment.gmp = 0L;
                FrsFragment.gmq = 0L;
                FrsFragment.mNetError = 0;
            } else {
                FrsFragment.mNetError = 1;
            }
            if (!FrsFragment.this.gmz.bHP() && (i == 3 || i == 6)) {
                FrsFragment.this.gmK.resetData();
            }
            FrsFragment.this.gmn = System.currentTimeMillis();
            if (FrsFragment.this.gmz.bHj() != null) {
                FrsFragment.this.glJ = FrsFragment.this.gmz.bHj();
            }
            FrsFragment.this.gmj.b(FrsFragment.this.glJ.getRedpacketRainData());
            FrsFragment.this.sw(1);
            if (i == 7) {
                FrsFragment.this.sx(FrsFragment.this.glJ.getFrsDefaultTabId());
                return;
            }
            if (FrsFragment.this.glJ.getPage() != null) {
                FrsFragment.this.setHasMore(FrsFragment.this.glJ.getPage().ayR());
            }
            if (i == 4) {
                if (!FrsFragment.this.gmz.bHP() && TbadkCoreApplication.getInst().isRecAppExist() && FrsFragment.this.gmz.bHG() == 1) {
                    FrsFragment.this.glJ.addRecommendAppToThreadList(FrsFragment.this);
                }
                ArrayList<com.baidu.adp.widget.ListView.m> a2 = FrsFragment.this.gmK.a(false, false, FrsFragment.this.glJ.getThreadList(), FrsFragment.this.gmf, false);
                if (a2 != null) {
                    FrsFragment.this.glJ.setThreadList(a2);
                    FrsFragment.this.glJ.checkLiveStageInThreadList();
                }
                if (FrsFragment.this.gmz != null) {
                    com.baidu.tieba.frs.d.c.a(FrsFragment.this.glJ, FrsFragment.this.gmz.bHL(), 2, FrsFragment.this.getContext());
                }
                com.baidu.tieba.frs.f.a.a(FrsFragment.this, FrsFragment.this.glJ.getForum(), FrsFragment.this.glJ.getThreadList(), false, FrsFragment.this.getPn());
                FrsFragment.this.gmj.a(a2, FrsFragment.this.glJ);
                FrsFragment.this.bCo();
                return;
            }
            FrsFragment.this.bCo();
            switch (i) {
                case 1:
                    FrsFragment.this.gmj.bDo();
                    break;
                case 2:
                    FrsFragment.this.gmj.bDo();
                    break;
                case 3:
                case 6:
                    if (FrsFragment.this.glJ != null) {
                        FrsFragment.this.glJ.clearPostThreadCount();
                    }
                    if (FrsFragment.this.gmP != null) {
                        FrsFragment.this.gmP.refresh();
                        break;
                    }
                    break;
            }
            FrsFragment.this.bCv();
            if (bVar == null || bVar.errorCode == 0) {
                if (FrsFragment.this.glJ != null) {
                    FrsFragment.this.a(FrsFragment.this.glJ);
                    FrsFragment.this.J(false, i == 5);
                    if (FrsFragment.this.gmz != null) {
                        if (FrsFragment.this.glJ.getActivityHeadData() != null && FrsFragment.this.glJ.getActivityHeadData().ayh() != null && FrsFragment.this.glJ.getActivityHeadData().ayh().size() > 0) {
                            com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), 1, FrsFragment.this.glJ.getForum(), FrsFragment.this.gmz.getSortType(), 1);
                        }
                        if (FrsFragment.this.glJ.getThreadList() != null && FrsFragment.this.glJ.getThreadList().size() > 0) {
                            Iterator<com.baidu.adp.widget.ListView.m> it = FrsFragment.this.glJ.getThreadList().iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    com.baidu.adp.widget.ListView.m next = it.next();
                                    if ((next instanceof bj) && ((bj) next).getType() == bj.cPa) {
                                        com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), 1, FrsFragment.this.glJ.getForum(), FrsFragment.this.gmz.getSortType(), 2);
                                    }
                                }
                            }
                        }
                        com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), FrsFragment.this.glJ.getThreadList(), FrsFragment.this.glJ.getForum(), FrsFragment.this.gmz.getSortType());
                    }
                    FrsFragment.this.gmj.sJ(i);
                    FrsFragment.gmp = (System.nanoTime() - this.startTime) / TimeUtils.NANOS_PER_MS;
                    if (bVar != null) {
                        FrsFragment.gmq = bVar.kdh;
                    }
                } else {
                    return;
                }
            } else if (FrsFragment.this.glJ == null || com.baidu.tbadk.core.util.v.isEmpty(FrsFragment.this.glJ.getThreadList())) {
                FrsFragment.this.a(bVar);
            } else if (bVar.fXn) {
                FrsFragment.this.showToast(FrsFragment.this.getPageContext().getResources().getString(R.string.net_error_text, bVar.errorMsg, Integer.valueOf(bVar.errorCode)));
            }
            FrsFragment.this.bCs();
            FrsFragment.this.bCt();
            if (FrsFragment.this.glJ.getAccessFlag() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11384"));
            }
            if (FrsFragment.this.gmg && FrsFragment.this.gmB.uk(49)) {
                FrsFragment.this.gmg = false;
            }
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.p
        public void c(com.baidu.tieba.tbadkCore.l lVar) {
            if ((lVar != null && ("normal_page".equals(FrsFragment.this.gmz.getPageType()) || "frs_page".equals(FrsFragment.this.gmz.getPageType()) || "book_page".equals(FrsFragment.this.gmz.getPageType()))) || "brand_page".equals(FrsFragment.this.gmz.getPageType())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE, lVar));
                FrsFragment.this.b(lVar);
                FrsFragment.gmm = lVar;
            }
        }
    };
    private final CustomMessageListener gnx = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.frs.FrsFragment.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.m) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                FrsFragment.this.glJ.updateCurrentUserPendant((com.baidu.tbadk.data.m) customResponsedMessage.getData());
                FrsFragment.this.gmj.bDA().notifyDataSetChanged();
            }
        }
    };
    private final CustomMessageListener mMemListener = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_MEM) { // from class: com.baidu.tieba.frs.FrsFragment.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && FrsFragment.this.glJ != null && (userData = FrsFragment.this.glJ.getUserData()) != null) {
                userData.setIsMem(num.intValue());
                if (num.intValue() != 0) {
                    FrsFragment.this.gmA.k(num);
                }
            }
        }
    };
    private final com.baidu.tieba.frs.mc.k gny = new com.baidu.tieba.frs.mc.k() { // from class: com.baidu.tieba.frs.FrsFragment.22
        @Override // com.baidu.tieba.frs.mc.k
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.m> arrayList, boolean z3) {
            if (FrsFragment.this.gmD != null && FrsFragment.this.gmz != null && FrsFragment.this.gmz.bHP() && z && !z2 && !z3) {
                FrsFragment.this.gmD.tK(i2);
            }
        }
    };
    public final View.OnTouchListener dnp = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.FrsFragment.24
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (FrsFragment.this.gmR != null) {
                FrsFragment.this.gmR.onTouch(view, motionEvent);
            }
            if (FrsFragment.this.gmF != null && FrsFragment.this.gmF.bEh() != null) {
                FrsFragment.this.gmF.bEh().onTouchEvent(motionEvent);
            }
            if (FrsFragment.this.exV != null) {
                FrsFragment.this.exV.c(view, motionEvent);
            }
            if (FrsFragment.this.gmA != null) {
                FrsFragment.this.gmA.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private final CustomMessageListener gnz = new CustomMessageListener(CmdConfigCustom.CMD_GOTOLIVE_HOST_UPGRADE) { // from class: com.baidu.tieba.frs.FrsFragment.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.aDr().getInt(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.PHOTOLIVE_HOSTLEVEL, -1) != -1 && FrsFragment.this.glJ.getForum() != null) {
                FrsFragment.this.glJ.getForum().setCanAddPhotoLivePost(true);
            }
        }
    };
    public final View.OnClickListener gnA = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.27
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsFragment.this.gmj == null || view != FrsFragment.this.gmj.bDm() || FrsFragment.this.getActivity() == null) {
                if (FrsFragment.this.glJ != null && FrsFragment.this.glJ.getForum() != null && FrsFragment.this.gmj != null && view == FrsFragment.this.gmj.bDs()) {
                    if (FrsFragment.this.gmT == null) {
                        FrsFragment.this.gmT = new com.baidu.tieba.frs.view.c(FrsFragment.this.getPageContext());
                    }
                    FrsFragment.this.gmT.m(FrsFragment.this.glJ);
                    FrsFragment.this.gmT.showDialog();
                    return;
                }
                if (view.getId() == R.id.game_activity_egg_layout && com.baidu.adp.lib.util.l.isNetOk()) {
                    TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_CLICK);
                    if (FrsFragment.this.gmj.bDx()) {
                        FrsFragment.this.gmj.bDy();
                    } else {
                        String activityUrl = FrsFragment.this.glJ.getForum().getYuleData().aCl().getActivityUrl();
                        if (!StringUtils.isNull(activityUrl)) {
                            com.baidu.tbadk.browser.a.startInternalWebActivity(FrsFragment.this.getPageContext().getPageActivity(), activityUrl);
                        }
                    }
                }
                if (view == FrsFragment.this.gmj.bDE() && FrsFragment.this.gmz != null && FrsFragment.this.gmz.hasMore()) {
                    FrsFragment.this.gmj.bba();
                    FrsFragment.this.aZN();
                }
                if (view != null && view == FrsFragment.this.gmj.bDu() && bc.checkUpIsLogin(FrsFragment.this.getContext())) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).Z("obj_locate", 2));
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
        private int gnN = 0;
        private int efM = 0;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsFragment.this.gne += i2;
            if (FrsFragment.this.gne >= FrsFragment.this.bZo * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
            if (FrsFragment.this.gmI != null) {
                FrsFragment.this.gmI.bIC();
            }
            this.gnN = 0;
            this.efM = 0;
            if (recyclerView != null && (recyclerView instanceof BdRecyclerView)) {
                this.gnN = ((BdRecyclerView) recyclerView).getFirstVisiblePosition();
                this.efM = ((BdRecyclerView) recyclerView).getLastVisiblePosition();
            }
            if (FrsFragment.this.gmU != null) {
                FrsFragment.this.gmU.a(recyclerView, this.gnN, this.efM);
            }
            if (FrsFragment.this.glJ != null && FrsFragment.this.gmj != null && FrsFragment.this.gmj.bDA() != null) {
                FrsFragment.this.gmj.bD(this.gnN, this.efM);
                if (FrsFragment.this.gmy != null && FrsFragment.this.gmy.mU() != null) {
                    FrsFragment.this.gmy.mU().b(FrsFragment.this.gmx);
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (FrsFragment.this.gmA != null) {
                FrsFragment.this.gmA.setScrollState(i);
            }
            if ((i == 2 || i == 1) && !FrsFragment.this.gmt) {
                FrsFragment.this.gmt = true;
                FrsFragment.this.gmj.bDC();
            }
            if (FrsFragment.this.gmu == null && !FrsFragment.this.bCN()) {
                FrsFragment.this.gmu = new com.baidu.tbadk.n.b();
                FrsFragment.this.gmu.setSubType(1000);
            }
            if (i == 0) {
                if (FrsFragment.this.gmu != null) {
                    FrsFragment.this.gmu.aOK();
                }
                com.baidu.tieba.card.r.btA().kn(true);
                FrsFragment.this.la(true);
                FrsFragment.this.gmj.bC(this.gnN, this.efM);
            } else if (FrsFragment.this.gmu != null) {
                FrsFragment.this.gmu.aOJ();
            }
            if (FrsFragment.this.gmU != null) {
                FrsFragment.this.gmU.onScrollStateChanged(recyclerView, i);
            }
            if (i == 0) {
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.gmj, FrsFragment.this.glJ, FrsFragment.this.getForumId(), false, null);
            }
            if (FrsFragment.this.gmB != null && i == 1) {
                FrsFragment.this.gmB.bJx();
            }
            if (FrsFragment.this.gmy == null) {
                if (FrsFragment.this.gmj.bDf() != null && !FrsFragment.this.gmj.bCL() && FrsFragment.this.gmj.bDf().cxn() != null && (FrsFragment.this.gmj.bDf().cxn().getTag() instanceof com.baidu.card.af)) {
                    FrsFragment.this.gmy = (com.baidu.card.af) FrsFragment.this.gmj.bDf().cxn().getTag();
                }
            } else if (i == 0 && FrsFragment.this.gmj.bDf() != null && !FrsFragment.this.gmj.bCL() && FrsFragment.this.gmj.bDf().cxn() != null && (FrsFragment.this.gmj.bDf().cxn().getTag() instanceof com.baidu.card.af)) {
                FrsFragment.this.gmy = (com.baidu.card.af) FrsFragment.this.gmj.bDf().cxn().getTag();
            }
            if (i == 1) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921418));
            }
        }
    };
    private final d gnB = new d() { // from class: com.baidu.tieba.frs.FrsFragment.29
        @Override // com.baidu.tieba.frs.d
        public void a(int i, int i2, View view, View view2, bj bjVar) {
            if (i != FrsFragment.this.gmj.bDA().bFz()) {
                if (i != FrsFragment.this.gmj.bDA().bFA()) {
                    if (i == FrsFragment.this.gmj.bDA().bFx() && FrsFragment.this.glJ != null && FrsFragment.this.glJ.getUserData() != null && FrsFragment.this.glJ.getUserData().isBawu()) {
                        String bawuCenterUrl = FrsFragment.this.glJ.getBawuCenterUrl();
                        if (!com.baidu.tbadk.core.util.aq.isEmpty(bawuCenterUrl) && FrsFragment.this.glJ.getForum() != null) {
                            com.baidu.tbadk.browser.a.startWebActivity(FrsFragment.this.getPageContext().getPageActivity(), bawuCenterUrl);
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10502").cp("fid", FrsFragment.this.glJ.getForum().getId()).cp("uid", FrsFragment.this.glJ.getUserData().getUserId()));
                        }
                    }
                } else if (bc.checkUpIsLogin(FrsFragment.this.getPageContext().getPageActivity())) {
                    TiebaStatic.log(CommonStatisticKey.MY_SERVICE_CK);
                    if (FrsFragment.this.glJ != null && FrsFragment.this.glJ.getForum() != null) {
                        ForumData forum = FrsFragment.this.glJ.getForum();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(forum.getId(), 0L), forum.getName(), forum.getImage_url(), 0)));
                    }
                }
            } else if (bc.checkUpIsLogin(FrsFragment.this.getActivity())) {
                TiebaStatic.log("forum_fortune_click");
                com.baidu.tieba.frs.f.i.b(FrsFragment.this.getPageContext(), FrsFragment.this.glJ);
            }
        }
    };
    private final NoNetworkView.a gjI = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.FrsFragment.30
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (FrsFragment.this.gmz.bHG() == 1 && z && !FrsFragment.this.gmj.bCL()) {
                if (FrsFragment.this.glJ == null || com.baidu.tbadk.core.util.v.isEmpty(FrsFragment.this.glJ.getThreadList())) {
                    FrsFragment.this.hideNetRefreshView(FrsFragment.this.gmj.bqY());
                    FrsFragment.this.showLoadingView(FrsFragment.this.gmj.bqY(), true);
                    FrsFragment.this.gmj.ll(false);
                    FrsFragment.this.refresh();
                    return;
                }
                FrsFragment.this.gmj.bDo();
            }
        }
    };
    private final CustomMessageListener dkk = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.FrsFragment.31
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                com.baidu.tieba.frs.f.c.a(customResponsedMessage, FrsFragment.this.gmj, FrsFragment.this.glJ);
            }
        }
    };
    private com.baidu.adp.widget.ListView.s gnC = new a();
    private aj gnD = new aj() { // from class: com.baidu.tieba.frs.FrsFragment.33
        @Override // com.baidu.tieba.frs.aj
        public void a(int i, int i2, aq aqVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
            com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.33.1
                @Override // java.lang.Runnable
                public void run() {
                    if (FrsFragment.this.gmj != null && FrsFragment.this.gmj.bDF()) {
                        FrsFragment.this.aZN();
                    }
                }
            });
        }
    };
    private CustomMessageListener gnE = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.frs.FrsFragment.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    FrsFragment.this.gmV = true;
                }
            }
        }
    };
    private CustomMessageListener gnF = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.frs.FrsFragment.36
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                    if (FrsFragment.this.gmy == null && FrsFragment.this.gmj.bDf() != null && !FrsFragment.this.gmj.bCL() && FrsFragment.this.gmj.bDf().cxn() != null && (FrsFragment.this.gmj.bDf().cxn().getTag() instanceof com.baidu.card.af)) {
                        FrsFragment.this.gmy = (com.baidu.card.af) FrsFragment.this.gmj.bDf().cxn().getTag();
                    }
                    if (FrsFragment.this.gmy != null && FrsFragment.this.gmy.mU() != null) {
                        FrsFragment.this.gmy.mU().b(new a.C0050a(3));
                    }
                }
            }
        }
    };
    private CustomMessageListener gnG = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.FrsFragment.37
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.gmj != null) {
                FrsFragment.this.gmj.rl();
            }
        }
    };
    private CustomMessageListener gnH = new CustomMessageListener(2921437) { // from class: com.baidu.tieba.frs.FrsFragment.38
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && FrsFragment.this.isResumed()) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (FrsFragment.this.gml != null) {
                    if (booleanValue) {
                        if (FrsFragment.this.gmB.bJy() != 0 && !FrsFragment.this.gmj.bDK()) {
                            FrsFragment.this.gml.show();
                            return;
                        }
                        return;
                    }
                    FrsFragment.this.gml.hide();
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.frs.loadmore.a
    public /* bridge */ /* synthetic */ com.baidu.adp.base.e getPageContext() {
        return super.getPageContext();
    }

    public com.baidu.tieba.frs.entelechy.b.b bCb() {
        return this.gmH;
    }

    public com.baidu.adp.widget.ListView.s bCc() {
        return this.gnC;
    }

    public com.baidu.tieba.frs.mc.d bCd() {
        return this.gmJ;
    }

    public com.baidu.tieba.frs.smartsort.a bCe() {
        return this.gmD;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public FrsModelController bCf() {
        return this.gmz;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public com.baidu.tieba.frs.mc.c bCg() {
        return this.gmK;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public com.baidu.tieba.frs.vc.h bCh() {
        return this.gmA;
    }

    public FrsTabViewController bCi() {
        return this.gmB;
    }

    public al bCj() {
        return this.gmF;
    }

    public void kZ(boolean z) {
        this.gnd = z;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public l bCk() {
        return this.gmj;
    }

    @Override // com.baidu.tieba.frs.ak
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.ak, com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.gmb;
    }

    public void setForumName(String str) {
        this.gmb = str;
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
        if (this.gmK == null) {
            return 1;
        }
        return this.gmK.getPn();
    }

    public int getPn() {
        if (this.gmK == null) {
            return 1;
        }
        return this.gmK.getPn();
    }

    public void setPn(int i) {
        if (this.gmK != null) {
            this.gmK.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.gmK != null) {
            this.gmK.setHasMore(i);
        }
    }

    public int bCl() {
        if (this.gmK == null) {
            return -1;
        }
        return this.gmK.bCl();
    }

    public boolean bCm() {
        return this.gmh;
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
            this.gmj.bDi();
            showNetRefreshView(this.gmj.bqY(), string, true);
        } else if (340001 == bVar.errorCode) {
            a(bVar, this.glJ.getRecm_forum_list());
        } else {
            if (com.baidu.tbadk.core.util.v.isEmpty(this.glJ.getThreadList())) {
                b(bVar);
            }
            if (bCN()) {
                setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds280));
            } else {
                setNetRefreshViewEmotionDefMarginTop();
            }
        }
    }

    public void a(View view, String str, boolean z, List<RecmForumInfo> list) {
        this.gmj.bDi();
        this.gmj.sF(8);
        if (this.gmS == null) {
            this.gmS = new com.baidu.tieba.frs.view.a(getPageContext(), getNetRefreshListener());
        }
        this.gmS.setSubText(str);
        this.gmS.cx(list);
        this.gmS.attachView(view, z);
    }

    private void a(e.b bVar, List<RecmForumInfo> list) {
        if (this.gmj != null) {
            this.gmj.bDi();
            this.gmj.setTitle(this.gmb);
            a(this.gmj.bqY(), bVar.errorMsg, true, list);
        }
    }

    private void b(e.b bVar) {
        this.gmj.bDi();
        if (bVar.fXn) {
            showNetRefreshView(this.gmj.bqY(), TbadkCoreApplication.getInst().getString(R.string.net_error_text, new Object[]{bVar.errorMsg, Integer.valueOf(bVar.errorCode)}), true);
        } else {
            showNetRefreshView(this.gmj.bqY(), bVar.errorMsg, true);
        }
    }

    public void bCn() {
        hideLoadingView(this.gmj.bqY());
        this.gmj.ln(false);
        if (this.gmj.bDg() instanceof com.baidu.tieba.frs.tab.c) {
            ((com.baidu.tieba.frs.tab.c) this.gmj.bDg()).bIj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCo() {
        if (bCl() == 0 && com.baidu.tbadk.core.util.v.isEmpty(this.glJ.getThreadListIds())) {
            if (com.baidu.tbadk.core.util.v.isEmpty(this.glJ.getThreadList())) {
                this.gmj.bbc();
            } else {
                this.gmj.bbb();
            }
        } else if (com.baidu.tbadk.core.util.v.getCount(this.glJ.getThreadList()) > 3) {
            this.gmj.bba();
        } else {
            this.gmj.bDD();
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
            bCn();
            this.gmj.bDo();
            e.b bHD = this.gmz.bHD();
            boolean isEmpty = com.baidu.tbadk.core.util.v.isEmpty(this.glJ.getThreadList());
            if (bHD != null && isEmpty) {
                if (this.gmz.bHE() != 0) {
                    this.gmz.bHJ();
                    this.gmj.bDo();
                } else {
                    a(bHD);
                }
                this.gmj.K(this.glJ.isStarForum(), false);
                return;
            }
            a(bHD);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.l lVar) {
        if (lVar != null && lVar.getEntelechyTabInfo() != null && lVar.getEntelechyTabInfo().tab != null) {
            for (FrsTabInfo frsTabInfo : lVar.getEntelechyTabInfo().tab) {
                if (frsTabInfo.tab_id.intValue() == 502 && com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean("first_into_tab_profession", true)) {
                    return;
                }
            }
        }
        new com.baidu.tieba.frs.ad.f(getTbPageContext()).a(lVar);
    }

    public boolean bCp() {
        return bCq() && !bCr();
    }

    private boolean bCq() {
        if (bCK() == null) {
            return false;
        }
        FrsViewData bCK = bCK();
        com.baidu.tbadk.core.data.t tVar = null;
        if (bCK.getStar() != null && !StringUtils.isNull(bCK.getStar().cIJ())) {
            tVar = new com.baidu.tbadk.core.data.t();
        } else if (bCK.getActivityHeadData() != null && com.baidu.tbadk.core.util.v.getCount(bCK.getActivityHeadData().ayh()) >= 1) {
            tVar = bCK.getActivityHeadData().ayh().get(0);
        }
        return tVar != null;
    }

    public boolean bCr() {
        if (bCK() == null) {
            return false;
        }
        FrsViewData bCK = bCK();
        return (com.baidu.tbadk.core.util.v.isEmpty(bCK.getShowTopThreadList()) && bCK.getBusinessPromot() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCs() {
        boolean b;
        if (!bCu()) {
            final PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
            privateForumPopInfoData.a(this.glJ.getPrivateForumTotalInfo().getPrivatePopInfo());
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(getActivity());
            if (this.glJ.getPrivateForumTotalInfo().ayY().private_forum_status.intValue() == 1 && (com.baidu.tbadk.core.util.aq.isEmpty(privateForumPopInfoData.aza()) || privateForumPopInfoData.azd() != Integer.valueOf(this.forumId))) {
                privateForumPopInfoData.sh("create_success");
                privateForumPopInfoData.si(TbadkCoreApplication.getInst().getString(R.string.frs_private_create_hint));
                privateForumPopInfoData.sj("https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.gmb + "&nomenu=1");
                privateForumPopInfoData.g(Integer.valueOf(this.forumId));
                b = frsPrivateCommonDialogView.b(privateForumPopInfoData);
            } else {
                b = privateForumPopInfoData.azd() == Integer.valueOf(this.forumId) ? frsPrivateCommonDialogView.b(privateForumPopInfoData) : false;
            }
            if (b) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
                aVar.jI(2);
                aVar.aO(frsPrivateCommonDialogView);
                aVar.fA(false);
                frsPrivateCommonDialogView.setConfirmButton(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.11
                    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.frs.FrsFragment */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ba.aEt().b(FrsFragment.this.getPageContext(), new String[]{privateForumPopInfoData.azc()});
                        aVar.dismiss();
                    }
                });
                aVar.a(new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.13
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(getPageContext()).aCp();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCt() {
        if (bCu() || this.glJ.getPrivateForumTotalInfo().ayY().private_forum_status.intValue() != 1) {
            a((Integer) null, (Integer) null, true);
        } else {
            a(this.glJ.getPrivateForumTotalInfo().ayY().private_forum_audit_status, this.glJ.getPrivateForumTotalInfo().ayZ(), false);
        }
    }

    public void a(Integer num, Integer num2, boolean z) {
        final String str;
        final int i = 2;
        if (this.gmj.bDt() != null) {
            TextView bDt = this.gmj.bDt();
            if (z) {
                bDt.setVisibility(8);
                return;
            }
            if (num.intValue() == 2) {
                bDt.setText("修改实名认证信息");
                bDt.setVisibility(0);
                str = "https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + this.forumId + "&nomenu=1";
            } else if (num2.intValue() >= 0 && num2.intValue() <= 100) {
                bDt.setText("目标已完成" + String.valueOf(num2) + "%");
                bDt.setVisibility(0);
                str = "https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.gmb + "&nomenu=1";
                i = 1;
            } else {
                bDt.setVisibility(8);
                i = 0;
                str = "";
            }
            bDt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.14
                /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13387").cp("fid", FrsFragment.this.forumId).cp("uid", TbadkCoreApplication.getCurrentAccount()).Z("obj_type", i));
                    ba.aEt().b(FrsFragment.this.getPageContext(), new String[]{str});
                }
            });
        }
    }

    private boolean bCu() {
        return this.glJ == null || !this.glJ.isPrivateForum() || this.glJ.getPrivateForumTotalInfo() == null || this.glJ.getPrivateForumTotalInfo().ayY() == null || this.glJ.getUserData().getIs_manager() != 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sw(int i) {
        List<WindowToast> list;
        if (TbadkCoreApplication.isLogin() && this.glJ != null && (list = this.glJ.mWindowToast) != null && list.size() > 0) {
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
    public void bCv() {
        if (this.glJ == null || this.glJ.getForum() != null) {
            this.gmj.bDz();
        } else if (this.glJ.getForum().getYuleData() != null && this.glJ.getForum().getYuleData().aCk()) {
            TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_VIEW);
            this.gmj.a(this.glJ.getForum().getYuleData().aCl());
        } else {
            this.gmj.bDz();
        }
    }

    private void I(boolean z, boolean z2) {
        if (this.gmz != null && this.glJ != null && this.gmj != null && z) {
            if (!this.gmz.bHP() && this.gmz.bHG() == 1) {
                if (!this.gmz.bHN()) {
                    this.glJ.addCardVideoInfoToThreadList();
                    this.glJ.addVideoInfoToThreadListInTenAndFifteenFloor();
                }
                boolean z3 = false;
                if (this.gmj.bDA().p(com.baidu.tieba.card.data.n.fKY)) {
                    z3 = this.glJ.addHotTopicDataToThreadList();
                }
                if (!z3) {
                    this.glJ.addFeedForumDataToThreadList();
                }
                if (TbadkCoreApplication.getInst().isRecAppExist()) {
                    this.glJ.addRecommendAppToThreadList(this);
                }
                if (!this.gmj.bDA().p(bj.cNw)) {
                    this.glJ.removeAlaLiveThreadData();
                }
                this.glJ.addSchoolRecommendToThreadList();
            }
            if (!this.gmj.bDA().p(bj.cNw)) {
                this.glJ.removeAlaInsertLiveData();
                this.glJ.removeAlaStageLiveDat();
            } else {
                this.glJ.addInsertLiveDataToThreadList();
                this.glJ.addStageLiveDataToThreadList();
            }
            this.glJ.checkLiveStageInThreadList();
            this.glJ.addNoticeThreadToThreadList();
            if (this.gmj.bDA().p(com.baidu.tieba.h.b.gPw)) {
                this.glJ.addGameRankListToThreadList(z2);
            }
            if (TbadkCoreApplication.isLogin() && (!this.gmz.bHP() || this.gmz.isNetFirstLoad)) {
                this.glJ.addUserRecommendToThreadList();
            }
            this.glJ.addVideoActivityToTop();
        }
    }

    public boolean bCw() {
        if (this.gmA != null && this.gmz != null) {
            this.gmA.a(this.gmz.getPageType(), this.glJ);
        }
        boolean z = false;
        if (this.glJ != null) {
            z = this.glJ.hasTab();
        }
        bCy();
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sx(int i) {
        an anVar = null;
        bCw();
        bCF();
        try {
            if (this.glJ != null) {
                this.gmj.a((ArrayList<com.baidu.adp.widget.ListView.m>) null, this.glJ);
                this.gmA.ue(1);
                this.gmj.bDr();
                this.gmB.a(this.glJ, this.gmz.bHL());
                com.baidu.tieba.frs.tab.d ul = this.gmB.ul(this.glJ.getFrsDefaultTabId());
                if (ul != null && !TextUtils.isEmpty(ul.url)) {
                    anVar = new an();
                    anVar.ext = ul.url;
                    anVar.stType = ul.name;
                }
                this.gmz.a(this.glJ.getFrsDefaultTabId(), 0, anVar);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(boolean z, boolean z2) {
        try {
            if (this.glJ != null && this.gmB != null && this.gmz != null) {
                if (!this.gmj.bDA().p(bj.cNw)) {
                    this.glJ.removeAlaLiveThreadData();
                }
                boolean isEmpty = com.baidu.tbadk.core.util.v.isEmpty(this.glJ.getGameTabInfo());
                this.gmj.lj(isEmpty);
                if (!isEmpty) {
                    if (this.gmU == null) {
                        this.gmU = new com.baidu.tieba.frs.vc.e(this, (NoPressedRelativeLayout) this.mRootView);
                    }
                    if (this.exV == null) {
                        this.exV = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
                    }
                } else {
                    this.gmU = null;
                    this.exV = null;
                }
                if (this.glJ.getForum() != null) {
                    this.gmb = this.glJ.getForum().getName();
                    this.forumId = this.glJ.getForum().getId();
                }
                if (this.glJ.hasTab()) {
                    this.gmB.a(this.glJ, this.gmz.bHL());
                }
                if (z) {
                    I(true, z);
                } else {
                    I(this.gmv, z);
                }
                bCw();
                if (this.gmH != null) {
                    this.gmH.a(this.gmA, this.glJ);
                }
                if (this.glJ.getPage() != null) {
                    setHasMore(this.glJ.getPage().ayR());
                }
                ArrayList<com.baidu.adp.widget.ListView.m> a2 = this.gmK.a(z2, true, this.glJ.getThreadList(), null, z, false);
                if (a2 != null) {
                    this.glJ.setThreadList(a2);
                }
                this.glJ.removeRedundantUserRecommendData();
                this.glL = this.glJ.getTopThreadSize();
                if (this.gmf != null) {
                    this.gme = true;
                    this.gmf.Cm(this.glL);
                    com.baidu.tieba.frs.f.a.a(this, this.glJ.getForum(), this.glJ.getThreadList(), this.gme, getPn());
                }
                if (this.gmz.bHG() == 1) {
                    bCC();
                    if (!z && this.gmz.getPn() == 1) {
                        bCx();
                    }
                }
                if (this.gmI != null) {
                    this.gmI.bV(this.gmB.bJu());
                }
                bCn();
                this.gmj.bDj();
                this.gmj.K(true, false);
                if (z && this.glJ.isFirstTabEqualAllThread()) {
                    com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.15
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!FrsFragment.this.gms && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                FrsFragment.this.gmj.bDJ();
                            }
                        }
                    });
                }
                if (this.glJ.getForum() != null) {
                    this.gmj.AO(this.glJ.getForum().getWarningMsg());
                }
                if (this.glJ != null && this.glJ.getFrsVideoActivityData() != null && com.baidu.tbadk.core.sharedPref.b.aDr().getLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 0L) == 0) {
                    com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.16
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsFragment.this.gmj.bDH();
                        }
                    }, 1000L);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FRS_SHOW_AR_ENTRY, this));
                this.gmj.bDd();
                if (this.glJ != null && this.glJ.getForum() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ENTER_FORUM, new VisitedForumData(this.glJ.getForum().getId(), this.glJ.getForum().getName(), this.glJ.getForum().getImage_url(), String.valueOf(System.currentTimeMillis() / 1000), ConstantData.Forum.SPECAIL_FORUM_TYPE_LIVE.equals(this.glJ.getForum().special_forum_type), this.glJ.getForum().getThemeColorInfo(), this.glJ.getForum().getMember_num())));
                }
                this.gmY.a(this.glJ.bottomMenuList, this.glJ.getForum());
                bCT();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void la(boolean z) {
        com.baidu.tieba.r.c.cIu().b(getUniqueId(), z);
    }

    public void bCx() {
        if (this.gmN == null) {
            this.gmN = new com.baidu.tieba.frs.live.a(this, com.baidu.adp.lib.f.b.toInt(this.forumId, 0));
        }
        this.gmN.bHo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.tbadkCore.l lVar) {
        try {
            if (!this.gms && lVar != null && this.glJ != null) {
                this.glJ.receiveData(lVar);
                J(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void bCy() {
        if (this.gmz != null) {
            AN(this.gmz.getPageType());
        } else {
            AN("normal_page");
        }
    }

    private void AN(String str) {
        lb("frs_page".equals(str));
        if (this.gmH != null) {
            this.gmH.a(this.gmA, this.gmj, this.glJ);
        }
    }

    public void lb(boolean z) {
        if (this.gmL != null) {
            this.gmL.bJn();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.r.c.cIu().w(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.frs_activity, viewGroup, false);
            this.glV = new com.baidu.tieba.frs.entelechy.a();
            this.gmH = this.glV.bFd();
            this.glU = TbadkCoreApplication.getInst().getString(R.string.frs_title_new_area);
            this.gmA = new com.baidu.tieba.frs.vc.h(this, this.glV, (FrsHeaderViewContainer) this.mRootView.findViewById(R.id.header_view_container));
            this.gmB = new FrsTabViewController(this, this.mRootView);
            this.gmB.registerListener();
            this.gmA.a(this.gmB);
            this.gmB.a(this.gnj);
            Intent intent = getActivity().getIntent();
            if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                this.glX = true;
            }
            this.gmj = new l(this, this.gnA, this.glV, this.glX, this.gmA);
            this.gmY = new com.baidu.tieba.frs.brand.buttommenu.a(getPageContext(), this.mRootView);
        } else {
            if (this.mRootView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            if (this.gmB != null) {
                this.gmB.registerListener();
            }
            this.gmj.bDG();
            this.mRootView.setLeft(0);
            this.mRootView.setRight(com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getContext()));
        }
        this.gnc = true;
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        ArrayList<com.baidu.adp.widget.ListView.m> arrayList = null;
        this.fSK = System.currentTimeMillis();
        this.beginTime = this.fSK;
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.gmg = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.fSK = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            ai(intent);
        }
        this.dzt = this.beginTime - this.fSK;
        this.gmf = new com.baidu.tieba.tbadkCore.data.f("frs", com.baidu.tieba.tbadkCore.data.f.keR);
        if (this.gmz == null) {
            this.gmz = new FrsModelController(this, this.gnw);
            this.gmz.a(this.gni);
            this.gmz.init();
        }
        if (intent != null) {
            this.gmz.ad(intent.getExtras());
        } else if (bundle != null) {
            this.gmz.ad(bundle);
        } else {
            this.gmz.ad(null);
        }
        if (intent != null) {
            this.gmA.aj(intent.getExtras());
        } else if (bundle != null) {
            this.gmA.aj(bundle);
        } else {
            this.gmA.aj(null);
        }
        this.gmi = getVoiceManager();
        this.gmO = new k(getPageContext(), this);
        initUI();
        initData(bundle);
        if (!bCN()) {
            this.gmF = new al(getActivity(), this.gmj, this.gmA);
            this.gmF.lA(true);
        }
        this.gmi = getVoiceManager();
        if (this.gmi != null) {
            this.gmi.onCreate(getPageContext());
        }
        new com.baidu.tieba.frs.mc.i();
        int i = -1;
        if (this.gmK != null && this.gmK.bHz() != null) {
            i = this.gmK.bHz().bCl();
            arrayList = this.gmK.bHz().getDataList();
        }
        this.gmK = new com.baidu.tieba.frs.mc.c(this, this.gny);
        this.gmK.bHz().setHasMore(i);
        if (arrayList != null && arrayList.size() > 0) {
            this.gmK.bHz().at(arrayList);
        }
        this.gmD = new com.baidu.tieba.frs.smartsort.a(this);
        this.gmL = new com.baidu.tieba.frs.vc.j(this);
        this.gmI = new com.baidu.tieba.frs.vc.a(getPageContext(), this.gmz.bHM());
        this.gmE = new com.baidu.tieba.frs.mc.b(this);
        this.gmJ = new com.baidu.tieba.frs.mc.d(this);
        this.gmC = new com.baidu.tieba.frs.mc.h(this);
        this.gmM = new com.baidu.tieba.frs.mc.a(this);
        this.gmP = new com.baidu.tieba.frs.vc.c(this);
        this.gmQ = new com.baidu.tieba.frs.mc.e(this, getUniqueId());
        this.gmW = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "frs");
        this.gmX = new com.baidu.tieba.ala.a(getPageContext());
        this.gmZ = new com.baidu.tieba.frs.sportspage.notification.a(getPageContext());
        registerListener(this.gnq);
        registerListener(this.mMemListener);
        registerListener(this.gno);
        registerListener(this.gnz);
        registerListener(this.gnx);
        registerListener(this.gnl);
        registerListener(this.gnm);
        registerListener(this.gnn);
        registerListener(this.gnf);
        registerListener(this.gng);
        registerListener(this.Kr);
        registerListener(this.gnE);
        registerListener(this.gns);
        registerListener(this.gnh);
        registerListener(this.gnt);
        registerListener(this.gnr);
        registerListener(this.gnu);
        registerListener(this.gnv);
        this.gnF.setTag(getPageContext().getUniqueId());
        MessageManager.getInstance().registerListener(this.gnF);
        registerListener(this.gnG);
        registerListener(this.gnH);
        this.gmj.ll(false);
        if (!bCN() && !this.hasInit) {
            showLoadingView(this.gmj.bqY(), true);
            this.gmz.G(3, false);
        }
        com.baidu.tieba.frs.a.bBr().a(new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.19
            @Override // com.baidu.tieba.frs.a.b
            public void H(boolean z, boolean z2) {
                if (FrsFragment.this.gmj != null) {
                    FrsFragment.this.gmj.sG(z ? 0 : 8);
                    if (!z2) {
                        FrsFragment.this.gnb = z;
                    }
                    if (FrsFragment.this.gmj.bDA() != null && FrsFragment.this.gmz != null && FrsFragment.this.gmz.bHH()) {
                        FrsFragment.this.gmj.bDA().notifyDataSetChanged();
                    }
                    if (FrsFragment.this.bCi() != null) {
                        FrsTabViewController.b bJv = FrsFragment.this.bCi().bJv();
                        if (bJv != null && bJv.tabId == 502 && (bJv.fragment instanceof FrsCommonTabFragment)) {
                            ((FrsCommonTabFragment) bJv.fragment).bEY();
                        } else if (bJv != null && bJv.tabId == 503 && (bJv.fragment instanceof FrsNewAreaFragment)) {
                            FrsNewAreaFragment frsNewAreaFragment = (FrsNewAreaFragment) bJv.fragment;
                            frsNewAreaFragment.bEY();
                            if (frsNewAreaFragment.bHT() != null) {
                                com.baidu.tieba.frs.mc.g bHT = frsNewAreaFragment.bHT();
                                bHT.lo(!z);
                                bHT.lp(!z);
                            }
                        }
                        if (FrsFragment.this.bCi().bJo() != null) {
                            FrsFragment.this.bCi().bJo().setmDisallowSlip(z);
                            FrsFragment.this.bCi().mf(z);
                        }
                    }
                    if (FrsFragment.this.gmj.bDh() != null) {
                        FrsFragment.this.gmj.li(!z);
                    }
                    if (FrsFragment.this.getActivity() instanceof FrsActivity) {
                        ((FrsActivity) FrsFragment.this.getActivity()).kY(!z);
                    }
                    if (FrsFragment.this.gmY != null) {
                        FrsFragment.this.gmY.lH(!z);
                    }
                    FrsFragment.this.gmj.lo(!z);
                    FrsFragment.this.gmj.lp(z ? false : true);
                }
            }

            @Override // com.baidu.tieba.frs.a.b
            public void st(int i2) {
                if (FrsFragment.this.gmj != null) {
                    FrsFragment.this.gmj.sH(i2);
                }
            }

            @Override // com.baidu.tieba.frs.a.b
            public void bBy() {
                com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getContext(), (int) R.string.frs_multi_delete_max_num);
            }
        });
        this.gmj.b(new d.a() { // from class: com.baidu.tieba.frs.FrsFragment.20
            @Override // com.baidu.tieba.NEGFeedBack.d.a
            public void a(DeleteThreadHttpResponseMessage deleteThreadHttpResponseMessage) {
                boolean z;
                int i2 = 0;
                if (deleteThreadHttpResponseMessage != null) {
                    FrsFragment.this.gmj.aTV();
                    FrsFragment.this.gmj.bDI();
                    FrsNewAreaFragment frsNewAreaFragment = null;
                    if (FrsFragment.this.gmB == null || FrsFragment.this.gmB.bJv() == null || !(FrsFragment.this.gmB.bJv().fragment instanceof FrsNewAreaFragment)) {
                        z = false;
                    } else {
                        frsNewAreaFragment = (FrsNewAreaFragment) FrsFragment.this.gmB.bJv().fragment;
                        z = true;
                    }
                    if (deleteThreadHttpResponseMessage.getError() == 0) {
                        String text = !TextUtils.isEmpty(deleteThreadHttpResponseMessage.getText()) ? deleteThreadHttpResponseMessage.getText() : FrsFragment.this.getString(R.string.delete_fail);
                        if (deleteThreadHttpResponseMessage.getRetType() == 1211066) {
                            if (FrsFragment.this.fJq == null) {
                                FrsFragment.this.fJq = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.fJq.sC(text);
                            FrsFragment.this.fJq.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.20.1
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.fJq.fA(false);
                            FrsFragment.this.fJq.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.fJq.aCp();
                        } else if (deleteThreadHttpResponseMessage.getRetType() == 1211067) {
                            if (FrsFragment.this.fJq == null) {
                                FrsFragment.this.fJq = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.fJq.sC(text);
                            FrsFragment.this.fJq.a(R.string.know, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.20.2
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.fJq.fA(false);
                            FrsFragment.this.fJq.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.fJq.aCp();
                        } else {
                            FrsFragment.this.gmj.aB(deleteThreadHttpResponseMessage.getText(), ContextCompat.getColor(FrsFragment.this.getContext(), deleteThreadHttpResponseMessage.getRetType() == 1 ? R.color.nav_bar_tip_error : R.color.cp_link_tip_a_alpha95));
                        }
                        if (z && frsNewAreaFragment != null) {
                            frsNewAreaFragment.cs(deleteThreadHttpResponseMessage.getSuccessItems());
                        }
                        FrsFragment.this.ch(deleteThreadHttpResponseMessage.getSuccessItems());
                        com.baidu.tieba.frs.a.bBr().cg(deleteThreadHttpResponseMessage.getSuccessItems());
                        for (com.baidu.adp.widget.ListView.m mVar : FrsFragment.this.glJ.getThreadList()) {
                            if (mVar instanceof bi) {
                                i2++;
                                continue;
                            }
                            if (i2 >= 6) {
                                break;
                            }
                        }
                        if (i2 < 6) {
                            FrsFragment.this.aZN();
                            return;
                        }
                        return;
                    }
                    com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getActivity(), deleteThreadHttpResponseMessage.getErrorString());
                }
            }
        });
        this.bZo = UtilHelper.getScreenHeight(getActivity());
        this.hasInit = true;
        sy(1);
        super.onActivityCreated(bundle);
        this.createTime = System.currentTimeMillis() - this.beginTime;
    }

    public void lc(boolean z) {
        if (this.gmB != null) {
            this.gmB.gKQ = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ch(List<String> list) {
        if (!com.baidu.tbadk.core.util.v.isEmpty(list)) {
            ArrayList<com.baidu.adp.widget.ListView.m> threadList = this.glJ.getThreadList();
            if (!com.baidu.tbadk.core.util.v.isEmpty(threadList) && this.gmj.getListView() != null && this.gmj.getListView().getData() != null) {
                Iterator<com.baidu.adp.widget.ListView.m> it = threadList.iterator();
                List<com.baidu.adp.widget.ListView.m> data = this.gmj.getListView().getData();
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.m next = it.next();
                    if (next instanceof bi) {
                        bj bjVar = ((bi) next).cNb;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= list.size()) {
                                break;
                            } else if (!com.baidu.tbadk.core.util.aq.equals(list.get(i2), bjVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.gmK.d(next);
                                this.gmj.getListView().getAdapter().notifyItemRemoved(i);
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
    public void bah() {
        if (isAdded() && this.ejJ && !isLoadingViewAttached()) {
            showLoadingView(this.gmj.bqY(), true);
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void bai() {
        if (isAdded() && this.ejJ && isLoadingViewAttached()) {
            hideLoadingView(this.gmj.bqY());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (bCN()) {
            showLoadingView(this.gmj.bqY(), true);
            this.gmj.sI(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.gmz.G(3, true);
            aFQ().scrollToPosition(0);
        }
    }

    private void sy(int i) {
        String str = "";
        if (this.glJ != null && this.glJ.getForum() != null) {
            str = this.glJ.getForum().getId();
        }
        if (!StringUtils.isNull(str)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13008").cp("fid", str).cp("obj_type", "4").Z("obj_locate", i).cp("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.z zVar) {
        if (zVar != null) {
            this.dCJ = zVar.aPV();
            this.gmR = zVar.aPW();
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void showFloatingView() {
        if (this.dCJ != null) {
            this.dCJ.gW(true);
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
            if (intent != null && intent.getData() != null) {
                Uri data = intent.getData();
                this.gmb = data.getQueryParameter("name");
                this.mFrom = data.getQueryParameter("from");
                if (!StringUtils.isNull(this.gmb)) {
                    intent.putExtra("name", this.gmb);
                }
                if (!StringUtils.isNull(this.mFrom)) {
                    intent.putExtra("from", this.mFrom);
                }
                TiebaStatic.log(TbadkCoreStatisticKey.AS_INVOKE_TIEBA);
            }
            if (StringUtils.isNull(this.gmb) && intent != null && intent.getData() != null) {
                Uri data2 = intent.getData();
                if (com.baidu.tbadk.BdToken.f.m(data2)) {
                    com.baidu.tbadk.BdToken.f.avz().b(data2, new f.a() { // from class: com.baidu.tieba.frs.FrsFragment.21
                        @Override // com.baidu.tbadk.BdToken.f.a
                        public void n(HashMap<String, Object> hashMap) {
                            if (hashMap != null && (hashMap.get(com.baidu.tbadk.BdToken.f.cEj) instanceof String)) {
                                FrsFragment.this.gmb = (String) hashMap.get(com.baidu.tbadk.BdToken.f.cEj);
                            }
                        }
                    });
                } else {
                    com.baidu.tieba.frs.f.d al = com.baidu.tieba.frs.f.i.al(intent);
                    if (al != null) {
                        this.gmb = al.forumName;
                        if (al.gJb == null || al.gJb.equals("aidou")) {
                        }
                    }
                }
                if (!StringUtils.isNull(this.gmb)) {
                    intent.putExtra("name", this.gmb);
                }
                intent.putExtra(FrsActivityConfig.FRS_CALL_FROM, 12);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.gmi = getVoiceManager();
        if (this.gmi != null) {
            this.gmi.onStart(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        Intent intent;
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.dkk);
        if (bundle != null) {
            this.gmb = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
            this.gmb = intent.getStringExtra("name");
            this.mFrom = intent.getStringExtra("from");
            this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
        }
        if (getArguments() != null) {
            this.gmc = getArguments().getBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, false);
        }
        if (TextUtils.isEmpty(this.mFrom) || FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
        }
        if (this.mIsLogin) {
            registerListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL, this.dkk);
        }
        this.gmA.aj(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.r.c.cIu().x(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.gnE);
        gmm = null;
        if (this.gmi != null) {
            this.gmi.onDestory(getPageContext());
        }
        com.baidu.tieba.recapp.report.a.remove("FRS");
        this.gmi = null;
        com.baidu.tieba.card.r.btA().kn(false);
        if (this.glJ != null && this.glJ.getForum() != null) {
            ab.bEe().dv(com.baidu.adp.lib.f.b.toLong(this.glJ.getForum().getId(), 0L));
        }
        if (this.gmN != null) {
            this.gmN.onDestory();
        }
        if (this.gmj != null) {
            com.baidu.tieba.frs.f.h.a(this.gmj, this.glJ, getForumId(), false, null);
            this.gmj.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.gmu != null) {
                this.gmu.aOL();
            }
            this.gmj.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.gmA.ags();
        if (this.gmz != null) {
            this.gmz.beK();
        }
        if (this.gmF != null) {
            this.gmF.aUq();
        }
        if (this.gmI != null) {
            this.gmI.destory();
        }
        if (this.gmD != null) {
            this.gmD.onDestroy();
        }
        if (this.gmU != null) {
            this.gmU.onDestory();
        }
        if (this.gmM != null) {
            this.gmM.onDestroy();
        }
        if (this.gmW != null) {
            this.gmW.onDestroy();
        }
        if (this.gmX != null) {
            this.gmX.onDestroy();
        }
        com.baidu.tieba.recapp.d.a.cBM().cBO();
        com.baidu.tieba.frs.f.j.bIz();
        if (this.gmB != null) {
            this.gmB.a((FrsTabViewController.a) null);
            this.gmB.bJx();
        }
        if (this.gna != null) {
            this.gna.onDestroy();
        }
        com.baidu.tieba.frs.a.bBr().a(null);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.gmb);
        bundle.putString("from", this.mFrom);
        this.gmz.onSaveInstanceState(bundle);
        if (this.gmi != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            this.gmi.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.gmM != null) {
            this.gmM.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.gmj != null) {
            this.gmj.bDo();
            this.gmj.onResume();
        }
        this.gmC.lX(true);
        this.gmv = true;
        if (gma) {
            gma = false;
            this.gmj.startPullRefresh();
            return;
        }
        if (this.gmi != null) {
            this.gmi.onResume(getPageContext());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_RESUME));
        this.gmj.lq(false);
        if (this.gmV) {
            refresh(6);
            this.gmV = false;
        }
        bCT();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
    }

    public boolean bCz() {
        Intent intent;
        if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
            return false;
        }
        return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
    }

    public void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.gmb = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.gmd = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.gmd) {
                bCA();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCA() {
        this.gmj.startPullRefresh();
    }

    public void closeActivity() {
        com.baidu.tieba.frs.f.i.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.mFrom);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.gmj.setTitle(this.gmb);
        } else {
            this.gmj.setTitle("");
            this.mFlag = 1;
        }
        this.gmj.a(this.gnC);
        this.gmj.addOnScrollListener(this.mScrollListener);
        this.gmj.g(this.gjI);
        this.gmj.bDA().a(this.gnB);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gnc) {
            this.gmj.onChangeSkinType(i);
            this.gmA.ud(i);
            this.gmB.onChangeSkinType(i);
            if (this.gml != null) {
                this.gml.onChangeSkinType(i);
            }
            if (this.gmS != null) {
                this.gmS.onChangeSkinType();
            }
            if (this.gmY != null) {
                this.gmY.onChangeSkinType(getPageContext(), i);
            }
            if (this.fJq != null) {
                com.baidu.tbadk.q.a.a(getPageContext(), this.fJq.getRealView());
            }
            if (this.gmT != null) {
                this.gmT.onChangeSkinType();
            }
            if (this.gmU != null) {
                this.gmU.onChangeSkinType(getPageContext(), i);
            }
        }
    }

    public void sz(int i) {
        if (!this.mIsLogin) {
            if (this.glJ != null && this.glJ.getAnti() != null) {
                this.glJ.getAnti().setIfpost(1);
            }
            if (i == 0) {
                bc.skipToLoginActivity(getActivity());
            }
        } else if (this.glJ != null) {
            if (i == 0) {
                com.baidu.tieba.frs.f.j.e(this, 0);
            } else {
                this.gmj.bDq();
            }
        }
    }

    public void refresh() {
        com.baidu.tieba.a.d.aVo().wt("page_frs");
        refresh(3);
    }

    public void refresh(int i) {
        this.gms = false;
        bCF();
        if (this.gmj != null && this.gmj.bDf() != null) {
            this.gmj.bDf().bML();
        }
        if (this.gmz != null) {
            this.gmz.G(i, true);
        }
    }

    private void bCB() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.f.h.gy().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.26
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.IV(FrsFragment.this.gmb);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCC() {
        bCF();
        try {
            if (this.glJ != null) {
                this.gmj.bem();
                this.gmj.li(bCS());
                if (!com.baidu.tieba.frs.vc.h.l(this.glJ) || !com.baidu.tieba.frs.vc.h.k(this.glJ)) {
                }
                if (this.glJ.getForum() != null) {
                    this.gmb = this.glJ.getForum().getName();
                    this.forumId = this.glJ.getForum().getId();
                }
                if (this.glJ.getPage() != null) {
                    setHasMore(this.glJ.getPage().ayR());
                }
                this.gmj.setTitle(this.gmb);
                this.gmj.setForumName(this.gmb);
                TbadkCoreApplication.getInst().setDefaultBubble(this.glJ.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.glJ.getUserData().getBimg_end_time());
                bCB();
                bCD();
                ArrayList<com.baidu.adp.widget.ListView.m> threadList = this.glJ.getThreadList();
                if (threadList != null) {
                    this.gmj.a(threadList, this.glJ);
                    com.baidu.tieba.frs.f.c.y(this.gmj);
                    this.gmA.ue(getPageNum());
                    this.gmA.i(this.glJ);
                    this.gmB.a(this.glJ, this.gmz.bHL());
                    this.gmj.bDr();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void bCD() {
        if (this.glJ != null) {
            if (this.glJ.getIsNewUrl() == 1) {
                this.gmj.bDA().setFromCDN(true);
            } else {
                this.gmj.bDA().setFromCDN(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.gmC.lX(false);
        this.gmv = false;
        this.gmj.onPause();
        if (this.gmi != null) {
            this.gmi.onPause(getPageContext());
        }
        this.gmj.lq(true);
        if (this.gmI != null) {
            this.gmI.bIC();
        }
        com.baidu.tbadk.BdToken.c.avj().avo();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.gmB != null && this.gmB.bJv() != null && (this.gmB.bJv().fragment instanceof BaseFragment)) {
            ((BaseFragment) this.gmB.bJv().fragment).setPrimary(z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.r.btA().kn(false);
        la(false);
        if (this.glJ != null && this.glJ.getForum() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            com.baidu.tbadk.distribute.a.aLJ().a(getPageContext().getPageActivity(), "frs", this.glJ.getForum().getId(), 0L);
        }
        if (this.gmi != null) {
            this.gmi.onStop(getPageContext());
        }
        if (aFQ() != null) {
            aFQ().getRecycledViewPool().clear();
        }
        this.gmA.aFn();
        com.baidu.tbadk.util.aa.aPY();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            if (this.gmA != null) {
                this.gmA.lg(isPrimary());
            }
            if (this.gmj != null) {
                this.gmj.lg(isPrimary());
                this.gmj.lq(!isPrimary());
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (com.baidu.tieba.frs.a.bBr().bBs()) {
                com.baidu.tieba.frs.a.bBr().reset();
                return true;
            } else if (this.gmj != null) {
                return this.gmj.bDn();
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
        com.baidu.tbadk.distribute.a.aLJ().a(advertAppInfo, this.forumId, 0L, "FRS", str, getPn());
    }

    @Override // com.baidu.tieba.recapp.n
    public void bCE() {
        bCf().bCE();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.gmi == null) {
            this.gmi = VoiceManager.instance();
        }
        return this.gmi;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdRecyclerView aFQ() {
        if (this.gmj == null) {
            return null;
        }
        return this.gmj.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void bCF() {
        if (this.gmi != null) {
            this.gmi.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> aFR() {
        if (this.deV == null) {
            this.deV = UserIconBox.x(getPageContext().getPageActivity(), 8);
        }
        return this.deV;
    }

    public void bCG() {
        if (getFragmentActivity() != null && getFragmentActivity().getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.p onGetPreLoadListView() {
        return aFQ().getPreLoadHandle();
    }

    @Override // com.baidu.tieba.frs.ai
    public NavigationBar bcw() {
        if (this.gmj == null) {
            return null;
        }
        return this.gmj.bcw();
    }

    public FRSRefreshButton bCH() {
        return this.gml;
    }

    public void a(FRSRefreshButton fRSRefreshButton) {
        if (fRSRefreshButton != null) {
            this.gml = fRSRefreshButton;
            this.gml.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.32
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (FrsFragment.this.gmB != null) {
                        FrsTabViewController.b bJv = FrsFragment.this.gmB.bJv();
                        if (bJv != null && bJv.fragment != null && (bJv.fragment instanceof ah)) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                            ((ah) bJv.fragment).scrollToTop();
                            ((ah) bJv.fragment).baZ();
                            return;
                        }
                        FrsFragment.this.bCk().startPullRefresh();
                    }
                }
            });
        }
    }

    public void bCI() {
        if (this.gml != null) {
            this.gml.hide();
        }
    }

    public void bCJ() {
        if (this.gml != null) {
            this.gml.show();
        }
    }

    /* loaded from: classes7.dex */
    private final class a implements com.baidu.adp.widget.ListView.s {
        private a() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.s
        public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null) {
                if (bdUniqueId == q.gpm) {
                    if (FrsFragment.this.gmj != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11752").cp("fid", FrsFragment.this.forumId).cp("obj_locate", "1"));
                        FrsFragment.this.gmj.startPullRefresh();
                    }
                } else if (mVar != null && (mVar instanceof bi)) {
                    bj bjVar = ((bi) mVar).cNb;
                    if (bjVar.aAV() == null || bjVar.aAV().getGroup_id() == 0 || bc.checkUpIsLogin(FrsFragment.this.getActivity())) {
                        if (bjVar.aAH() != 1 || bc.checkUpIsLogin(FrsFragment.this.getActivity())) {
                            if (bjVar.aAk() != null) {
                                if (bc.checkUpIsLogin(FrsFragment.this.getActivity())) {
                                    String postUrl = bjVar.aAk().getPostUrl();
                                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.isNetOk()) {
                                        com.baidu.tbadk.browser.a.startInternalWebActivity(FrsFragment.this.getActivity(), postUrl);
                                    }
                                }
                            } else if (bjVar.aBg() != null) {
                                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                    bc.skipToLoginActivity(FrsFragment.this.getPageContext().getPageActivity());
                                    return;
                                }
                                com.baidu.tbadk.core.data.p aBg = bjVar.aBg();
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), aBg.getCartoonId(), aBg.getChapterId(), 2)));
                            } else {
                                com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                                if (readThreadHistory != null && !readThreadHistory.Jb(bjVar.getId())) {
                                    readThreadHistory.Ja(bjVar.getId());
                                }
                                boolean z = false;
                                final String aAe = bjVar.aAe();
                                if (aAe != null && !aAe.equals("")) {
                                    z = true;
                                    new Thread(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.a.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(aAe);
                                            xVar.aDU().aEu().mIsNeedAddCommenParam = false;
                                            xVar.aDU().aEu().mIsUseCurrentBDUSS = false;
                                            xVar.getNetData();
                                        }
                                    }).start();
                                }
                                String tid = bjVar.getTid();
                                if (tid == null) {
                                    tid = "";
                                }
                                if (bjVar.azS() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                    ba.aEt().b(FrsFragment.this.getPageContext(), new String[]{tid, "", null});
                                    return;
                                }
                                if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                    bjVar.setId(tid.substring(3));
                                }
                                if (bdUniqueId.getId() == bj.cPa.getId()) {
                                    com.baidu.tieba.frs.f.h.a(bjVar.azC());
                                } else if (bdUniqueId.getId() == bj.cNz.getId()) {
                                    com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                                    anVar.cp("obj_type", "2");
                                    anVar.cp("tid", bjVar.getTid());
                                    TiebaStatic.log(anVar);
                                }
                                com.baidu.tieba.frs.f.i.a(FrsFragment.this, bjVar, i, z);
                                com.baidu.tieba.frs.f.h.a(FrsFragment.this, FrsFragment.this.glJ, bjVar);
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
            hideNetRefreshView(this.gmj.bqY());
            showLoadingView(this.gmj.bqY(), true);
            this.gmj.ll(false);
            this.gmz.G(3, true);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData bCK() {
        return this.glJ;
    }

    public boolean bCL() {
        return this.gmj.bCL();
    }

    public void ar(Object obj) {
        if (this.gmE != null && this.gmE.gEB != null) {
            this.gmE.gEB.callback(obj);
        }
    }

    public void as(Object obj) {
        if (this.gmE != null && this.gmE.gEC != null) {
            this.gmE.gEC.callback(obj);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        this.gmj.getListView().stopScroll();
        if (!this.gmj.bDw()) {
            if (!com.baidu.adp.lib.util.l.isNetOk()) {
                this.gmj.bbc();
            } else if (this.gmz.bHG() == 1) {
                bac();
                aZN();
            } else if (this.gmz.hasMore()) {
                aZN();
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void onFailed(String str) {
        bac();
        showToast(str);
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void al(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        boolean isEmpty = com.baidu.tbadk.core.util.v.isEmpty(arrayList);
        setHasMore(isEmpty ? 0 : 1);
        bac();
        if (!isEmpty) {
            if (!this.gmz.bHP() && TbadkCoreApplication.getInst().isRecAppExist() && this.gmz.bHG() == 1) {
                this.glJ.addRecommendAppToThreadList(this, arrayList);
            }
            if (this.gmz != null) {
                com.baidu.tieba.frs.d.a.a(getUniqueId(), arrayList, this.glJ.getForum(), this.gmz.getSortType());
            }
            ArrayList<com.baidu.adp.widget.ListView.m> a2 = this.gmK.a(false, false, arrayList, this.gmf, false);
            if (a2 != null) {
                this.glJ.setThreadList(a2);
                this.gmj.a(a2, this.glJ);
            }
            if (this.gmz != null) {
                com.baidu.tieba.frs.d.c.a(this.glJ, this.gmz.bHL(), 2, getContext());
            }
        }
    }

    private void bac() {
        if (bCl() == 1 || this.gmK.cr(this.glJ.getThreadListIds())) {
            if (com.baidu.tbadk.core.util.v.getCount(this.glJ.getThreadList()) > 3) {
                this.gmj.bba();
            } else {
                this.gmj.bDD();
            }
        } else if (com.baidu.tbadk.core.util.v.isEmpty(this.glJ.getThreadList())) {
            this.gmj.bbc();
        } else {
            this.gmj.bbb();
        }
    }

    @Override // com.baidu.tieba.frs.mc.l
    public void aZN() {
        if (this.gmK != null) {
            this.gmK.a(this.gmb, this.forumId, this.glJ);
        }
    }

    public void bCM() {
        if (!com.baidu.tbadk.core.util.ab.requestWriteExternalStorgeAndCameraPermission(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.al.e(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment, com.baidu.k.a.a.InterfaceC0072a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        com.baidu.tieba.frs.f.i.a(this, i, strArr, iArr);
    }

    public void ld(boolean z) {
        if (this.gmF != null) {
            this.gmF.lA(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.gmG.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a nB(int i) {
        return this.gmG.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        this.gmO.b(bVar);
    }

    public boolean bCN() {
        return this.glX;
    }

    @Override // com.baidu.tieba.frs.af
    public void yj() {
        if (this.gmj != null) {
            showFloatingView();
            this.gmj.getListView().scrollToPosition(0);
            this.gmj.startPullRefresh();
        }
    }

    public ForumWriteData bCO() {
        if (this.glJ == null || this.glJ.getForum() == null) {
            return null;
        }
        ForumData forum = this.glJ.getForum();
        ForumWriteData forumWriteData = new ForumWriteData(forum.getId(), forum.getName(), forum.getPrefixData(), this.glJ.getAnti());
        forumWriteData.avatar = forum.getImage_url();
        forumWriteData.forumLevel = forum.getUser_level();
        forumWriteData.specialForumType = forum.special_forum_type;
        forumWriteData.firstDir = forum.getFirst_class();
        forumWriteData.secondDir = forum.getSecond_class();
        UserData userData = this.glJ.getUserData();
        forumWriteData.privateThread = userData != null ? userData.getPrivateThread() : 0;
        return forumWriteData;
    }

    @Override // com.baidu.tieba.frs.af
    public void aFw() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void le(boolean z) {
        this.gmw = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z) {
        this.gmj.sF(8);
        ((FrsActivity) getActivity()).showLoadingView(view, z);
        ((FrsActivity) getActivity()).g(view, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        this.gmj.sF(0);
        ((FrsActivity) getActivity()).hideLoadingView(view);
        ((FrsActivity) getActivity()).g(view, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        super.showNetRefreshView(view, getResources().getString(R.string.refresh_view_title_text), null, getResources().getString(R.string.refresh_view_button_text), z, getNetRefreshListener());
        this.gmj.sF(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshViewNoClick(View view, String str, boolean z) {
        super.showNetRefreshViewNoClick(view, str, z);
        this.gmj.sF(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        super.hideNetRefreshView(view);
        this.gmj.sF(0);
    }

    public void bCP() {
        FrsTabViewController.b bJv;
        if (this.gmB != null && (bJv = this.gmB.bJv()) != null && bJv.fragment != null && (bJv.fragment instanceof ah)) {
            ((ah) bJv.fragment).scrollToTop();
        }
    }

    public void lf(boolean z) {
        this.glZ = z;
    }

    public void b(OvalActionButton ovalActionButton) {
        this.gmk = ovalActionButton;
    }

    public OvalActionButton bCQ() {
        return this.gmk;
    }

    public boolean bCR() {
        return this.glZ;
    }

    public void onShareSuccess(String str) {
        if (TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.util.aq.isEmpty(str)) {
            if (this.gna == null) {
                this.gna = new AddExperiencedModel(getTbPageContext());
            }
            this.gna.em(this.forumId, str);
        }
    }

    public boolean bCS() {
        if (this.gmw && !this.gnd) {
            return (this.gmz != null && this.gmz.bHH() && com.baidu.tieba.frs.a.bBr().bBs()) ? false : true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.g.c
    public boolean videoNeedPreload() {
        if (this.glJ != null) {
            return com.baidu.tbadk.util.af.mC(2) || (com.baidu.tbadk.util.af.aQd() && this.glJ.isFrsVideoAutoPlay);
        }
        return super.videoNeedPreload();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.g.c
    public boolean isCyberVideoUsedThisPage() {
        return com.baidu.tbadk.a.b.rs("cyber_player_test");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCT() {
        if (!com.baidu.tbadk.core.util.aq.isEmpty(this.forumId)) {
            com.baidu.tbadk.BdToken.c.avj().p(com.baidu.tbadk.BdToken.b.cCN, com.baidu.adp.lib.f.b.toLong(this.forumId, 0L));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        FrsTabViewController.b bJv;
        if (bCi() == null || (bJv = bCi().bJv()) == null || !(bJv.fragment instanceof BaseFragment)) {
            return null;
        }
        if (bJv.fragment instanceof FrsAllThreadFragment) {
            TbPageTag tbPageTag = super.getTbPageTag();
            int i = -1;
            if (this.glJ != null) {
                i = this.glJ.getSortType();
            }
            tbPageTag.sortType = com.baidu.tieba.frs.f.g.ub(i);
            tbPageTag.locatePage = "a070";
            if (this.glU.equals(bJv.title)) {
                tbPageTag.locatePage = "a071";
            }
            return tbPageTag;
        } else if (bJv.fragment instanceof FrsFragment) {
            return null;
        } else {
            return ((BaseFragment) bJv.fragment).getTbPageTag();
        }
    }
}
