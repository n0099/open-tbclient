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
public class FrsFragment extends BaseFragment implements BdListView.e, a.InterfaceC0078a, UserIconBox.b<BdRecyclerView>, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, ag, aj, al, com.baidu.tieba.frs.loadmore.a, com.baidu.tieba.frs.mc.l, com.baidu.tieba.recapp.n {
    public static com.baidu.tieba.tbadkCore.m gpm;
    private com.baidu.tbadk.util.y dHr;
    private com.baidu.adp.lib.d.b<TbImageView> djC;
    private com.baidu.tieba.frs.gametab.b eCO;
    private com.baidu.tbadk.core.dialog.a fMK;
    private com.baidu.tieba.frs.entelechy.a goV;
    private com.baidu.tieba.frs.vc.h gpA;
    private FrsTabViewController gpB;
    private com.baidu.tieba.frs.mc.h gpC;
    private com.baidu.tieba.frs.smartsort.a gpD;
    private com.baidu.tieba.frs.mc.b gpE;
    private am gpF;
    private com.baidu.tieba.frs.entelechy.b.b gpH;
    private com.baidu.tieba.frs.vc.a gpI;
    private com.baidu.tieba.frs.mc.d gpJ;
    private com.baidu.tieba.frs.mc.c gpK;
    private com.baidu.tieba.frs.vc.j gpL;
    private com.baidu.tieba.frs.mc.a gpM;
    private com.baidu.tieba.frs.live.a gpN;
    private l gpO;
    public com.baidu.tieba.frs.vc.c gpP;
    private com.baidu.tieba.frs.mc.e gpQ;
    private View.OnTouchListener gpR;
    private com.baidu.tieba.frs.view.a gpS;
    private com.baidu.tieba.frs.view.c gpT;
    private com.baidu.tieba.frs.vc.e gpU;
    private boolean gpV;
    private com.baidu.tieba.NEGFeedBack.a gpW;
    private com.baidu.tieba.ala.a gpX;
    private com.baidu.tieba.frs.brand.buttommenu.a gpY;
    private com.baidu.tieba.frs.sportspage.notification.a gpZ;
    private com.baidu.tieba.tbadkCore.data.f gpf;
    private VoiceManager gpi;
    private OvalActionButton gpk;
    private FRSRefreshButton gpl;
    public long gpn;
    private com.baidu.card.af gpy;
    private FrsModelController gpz;
    private AddExperiencedModel gqa;
    private boolean gqc;
    private int gqk;
    private View mRootView;
    public static boolean gpa = false;
    public static volatile long gpp = 0;
    public static volatile long gpq = 0;
    public static volatile int mNetError = 0;
    private String goU = "";
    public boolean goW = false;
    private boolean goX = false;
    private boolean goY = false;
    private boolean goZ = true;
    public String gpb = null;
    public String mFrom = null;
    public int mFlag = 0;
    public boolean gpc = false;
    private boolean gpd = false;
    private String mThreadId = null;
    public String forumId = null;
    private int goL = 0;
    private boolean gpe = false;
    private boolean gpg = false;
    private boolean gph = false;
    private m gpj = null;
    public final bj NR = null;
    private FrsViewData goJ = new FrsViewData();
    public long fWb = -1;
    public long dEh = 0;
    public long dDX = 0;
    public long createTime = 0;
    public long dDY = 0;
    public long dEe = 0;
    public long gpo = 0;
    public boolean gpr = false;
    private boolean gps = false;
    private boolean gpt = false;
    public com.baidu.tbadk.n.b gpu = null;
    private boolean gpv = true;
    private boolean gpw = true;
    private a.C0052a gpx = new a.C0052a(2);
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> gpG = new SparseArray<>();
    private boolean eoz = true;
    private boolean hasInit = false;
    private boolean gqb = false;
    private boolean gqd = false;
    private int cdH = 0;
    private int gqe = 0;
    public int mHeadLineDefaultNavTabId = -1;
    private final CustomMessageListener gqf = new CustomMessageListener(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED) { // from class: com.baidu.tieba.frs.FrsFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof bj) {
                    com.baidu.tieba.frs.f.h.a(FrsFragment.this.gpj, FrsFragment.this.goJ, FrsFragment.this.getForumId(), true, (bj) data);
                }
            }
        }
    };
    private CustomMessageListener gqg = new CustomMessageListener(CmdConfigCustom.CMD_CLOSE_GAME_RANK_CARD) { // from class: com.baidu.tieba.frs.FrsFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.goJ != null) {
                FrsFragment.this.goJ.removeGameRankListFromThreadList();
                if (FrsFragment.this.gpj != null) {
                    FrsFragment.this.gpj.asQ();
                }
            }
        }
    };
    private CustomMessageListener KN = new CustomMessageListener(2921401) { // from class: com.baidu.tieba.frs.FrsFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && FrsFragment.this.gpl != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() <= 0 || FrsFragment.this.gpB.bLq() == 0 || FrsFragment.this.gpB.bLn() == null || !(FrsFragment.this.gpB.bLn().fragment instanceof BaseFragment) || !((BaseFragment) FrsFragment.this.gpB.bLn().fragment).isPrimary() || FrsFragment.this.gpj.bFA()) {
                    if (FrsFragment.this.gpB.bLq() != 0) {
                        FrsFragment.this.gpl.hide();
                        return;
                    }
                    return;
                }
                FrsFragment.this.gpl.show();
            }
        }
    };
    private CustomMessageListener gqh = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.FrsFragment.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 1) {
                    FrsFragment.this.bEp();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                }
            }
        }
    };
    private final ak gqi = new ak() { // from class: com.baidu.tieba.frs.FrsFragment.39
        @Override // com.baidu.tieba.frs.ak
        public void a(int i, int i2, ar arVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
            FrsFragment.this.bEb();
            if (FrsFragment.this.gpH != null) {
                FrsFragment.this.gpA.mm(FrsFragment.this.gpH.to(i));
            }
            com.baidu.tieba.tbadkCore.f fVar = new com.baidu.tieba.tbadkCore.f();
            if (arVar != null) {
                fVar.isSuccess = arVar.errCode == 0;
                fVar.errorCode = arVar.errCode;
                fVar.errorMsg = arVar.errMsg;
                if (fVar.isSuccess) {
                    if (com.baidu.tbadk.core.util.v.isEmpty(arrayList)) {
                        FrsFragment.this.gpj.bdz();
                    } else if (arVar.hasMore) {
                        if (com.baidu.tbadk.core.util.v.getCount(FrsFragment.this.goJ.getThreadList()) > 3) {
                            FrsFragment.this.gpj.bdx();
                        } else {
                            FrsFragment.this.gpj.bFt();
                        }
                    } else if (arVar.gtk) {
                        FrsFragment.this.gpj.bdy();
                    } else {
                        FrsFragment.this.gpj.bdz();
                    }
                }
            } else {
                arVar = new ar();
                arVar.pn = 1;
                arVar.hasMore = false;
                arVar.gtk = false;
            }
            if (i == 1) {
                FrsFragment.this.gpv = true;
                FrsFragment.this.gqw.a(FrsFragment.this.gpz.getType(), false, fVar);
            } else {
                FrsFragment.this.a(fVar);
                if (FrsFragment.this.gpz.bIZ() != null) {
                    FrsFragment.this.goJ = FrsFragment.this.gpz.bIZ();
                }
                FrsFragment.this.bEr();
            }
            if (FrsFragment.this.gqD != null) {
                FrsFragment.this.gqD.a(i, i2, arVar, arrayList);
            }
        }
    };
    private FrsTabViewController.a gqj = new FrsTabViewController.a() { // from class: com.baidu.tieba.frs.FrsFragment.40
        @Override // com.baidu.tieba.frs.vc.FrsTabViewController.a
        public void mC(int i) {
            boolean z = false;
            if (i != 1) {
                com.baidu.tieba.card.r.bvm().ku(false);
                FrsFragment.this.lk(false);
            }
            if (i == 502) {
                FrsFragment.this.gpk.setIconFade(R.drawable.btn_frs_professional_edit_n);
            } else {
                FrsFragment.this.gpk.setIconFade(0);
            }
            FrsFragment.this.gqk = i;
            FrsFragment.this.bEu();
            com.baidu.tieba.frs.d.d.gxl.gKG = i;
            com.baidu.tieba.frs.d.d.gxl.gKH = -1;
            com.baidu.tieba.frs.a bDd = com.baidu.tieba.frs.a.bDd();
            if (i == 1 && FrsFragment.this.gqb) {
                z = true;
            }
            bDd.I(z, true);
        }
    };
    private CustomMessageListener gql = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIVE_COUNT) { // from class: com.baidu.tieba.frs.FrsFragment.41
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                FrsFragment.this.gpB.uz(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    };
    private CustomMessageListener gqm = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_LIVE_START) { // from class: com.baidu.tieba.frs.FrsFragment.42
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && ((Integer) customResponsedMessage.getData()).intValue() == 51 && FrsFragment.this.goJ != null) {
                com.baidu.tieba.frs.f.j.a(FrsFragment.this.goJ, FrsFragment.this.getPageContext());
            }
        }
    };
    private final CustomMessageListener gqn = new CustomMessageListener(CmdConfigCustom.CMD_FRS_SELECT_ALA_LIVE_TAB) { // from class: com.baidu.tieba.frs.FrsFragment.43
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                FrsFragment.this.gpB.ux(49);
            }
        }
    };
    private final CustomMessageListener gqo = new CustomMessageListener(CmdConfigCustom.CMD_FRS_EXPERIENCE_TIP) { // from class: com.baidu.tieba.frs.FrsFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.u) && FrsFragment.this.goJ != null) {
                FrsFragment.this.goJ.updateLikeData((com.baidu.tieba.tbadkCore.u) customResponsedMessage.getData());
                FrsFragment.this.gpA.i(FrsFragment.this.goJ);
                FrsFragment.this.gpB.a(FrsFragment.this.goJ, FrsFragment.this.gpz.bJD());
            }
        }
    };
    private final AntiHelper.a gqp = new AntiHelper.a() { // from class: com.baidu.tieba.frs.FrsFragment.3
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).X("obj_locate", at.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).X("obj_locate", at.a.LOCATE_LIKE_PERSON));
        }
    };
    private CustomMessageListener gqq = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.FrsFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(FrsFragment.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().dow != null) {
                        if (AntiHelper.a(FrsFragment.this.getActivity(), updateAttentionMessage.getData().dow, FrsFragment.this.gqp) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).X("obj_locate", at.a.LOCATE_LIKE_PERSON));
                        }
                    } else if (updateAttentionMessage.getData().isSucc && updateAttentionMessage.getData().isAttention) {
                        com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getPageContext().getPageActivity(), (int) R.string.attention_success);
                    }
                }
            }
        }
    };
    private CustomMessageListener gqr = new CustomMessageListener(2921346) { // from class: com.baidu.tieba.frs.FrsFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsFragment.this.refresh();
        }
    };
    private CustomMessageListener gqs = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.frs.FrsFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                FrsFragment.this.gpj.c((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener gqt = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_REMIND) { // from class: com.baidu.tieba.frs.FrsFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewsRemindMessage newsRemindMessage;
            if (customResponsedMessage != null && (customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626 && (newsRemindMessage = (NewsRemindMessage) customResponsedMessage) != null) {
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (FrsFragment.this.gpj != null) {
                    FrsFragment.this.gpj.D(notificationCount, z);
                }
            }
        }
    };
    private final CustomMessageListener gqu = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.frs.FrsFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.isResumed()) {
                FrsFragment.this.bEJ();
            }
        }
    };
    private CustomMessageListener gqv = new CustomMessageListener(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER) { // from class: com.baidu.tieba.frs.FrsFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (FrsFragment.this.gpj != null) {
                    FrsFragment.this.gpj.setExpanded(booleanValue);
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.q gqw = new com.baidu.tieba.tbadkCore.q() { // from class: com.baidu.tieba.frs.FrsFragment.10
        private long startTime = 0;

        @Override // com.baidu.tieba.tbadkCore.q
        public void sI(int i) {
            this.startTime = System.nanoTime();
            if (FrsFragment.this.gpj != null) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsFragment.this.gpj.bFe();
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
            if (FrsFragment.this.eoz) {
                FrsFragment.this.eoz = false;
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.gpj, FrsFragment.this.goJ, FrsFragment.this.getForumId(), false, null);
            }
            FrsFragment.this.bEb();
            FrsFragment.this.gps = true;
            if (fVar != null && fVar.isSuccess) {
                FrsFragment.this.gpj.bFq().lT(com.baidu.tbadk.core.util.ar.aGH().aGI());
                FrsFragment.gpp = 0L;
                FrsFragment.gpq = 0L;
                FrsFragment.mNetError = 0;
            } else {
                FrsFragment.mNetError = 1;
            }
            if (!FrsFragment.this.gpz.bJH() && (i == 3 || i == 6)) {
                FrsFragment.this.gpK.resetData();
            }
            FrsFragment.this.gpn = System.currentTimeMillis();
            if (FrsFragment.this.gpz.bIZ() != null) {
                FrsFragment.this.goJ = FrsFragment.this.gpz.bIZ();
            }
            FrsFragment.this.gpj.b(FrsFragment.this.goJ.getRedpacketRainData());
            FrsFragment.this.sE(1);
            if (i == 7) {
                FrsFragment.this.sF(FrsFragment.this.goJ.getFrsDefaultTabId());
                return;
            }
            if (FrsFragment.this.goJ.getPage() != null) {
                FrsFragment.this.setHasMore(FrsFragment.this.goJ.getPage().aBn());
            }
            if (i == 4) {
                if (!FrsFragment.this.gpz.bJH() && TbadkCoreApplication.getInst().isRecAppExist() && FrsFragment.this.gpz.bJy() == 1) {
                    FrsFragment.this.goJ.addRecommendAppToThreadList(FrsFragment.this);
                }
                ArrayList<com.baidu.adp.widget.ListView.m> a2 = FrsFragment.this.gpK.a(false, false, FrsFragment.this.goJ.getThreadList(), FrsFragment.this.gpf, false);
                if (a2 != null) {
                    FrsFragment.this.goJ.setThreadList(a2);
                    FrsFragment.this.goJ.checkLiveStageInThreadList();
                }
                if (FrsFragment.this.gpz != null) {
                    com.baidu.tieba.frs.d.c.a(FrsFragment.this.goJ, FrsFragment.this.gpz.bJD(), 2, FrsFragment.this.getContext());
                }
                com.baidu.tieba.frs.f.a.a(FrsFragment.this, FrsFragment.this.goJ.getForum(), FrsFragment.this.goJ.getThreadList(), false, FrsFragment.this.getPn());
                FrsFragment.this.gpj.a(a2, FrsFragment.this.goJ);
                FrsFragment.this.bEc();
                return;
            }
            FrsFragment.this.bEc();
            switch (i) {
                case 1:
                    FrsFragment.this.gpj.bFe();
                    break;
                case 2:
                    FrsFragment.this.gpj.bFe();
                    break;
                case 3:
                case 6:
                    if (FrsFragment.this.goJ != null) {
                        FrsFragment.this.goJ.clearPostThreadCount();
                    }
                    if (FrsFragment.this.gpP != null) {
                        FrsFragment.this.gpP.refresh();
                        break;
                    }
                    break;
            }
            FrsFragment.this.bEk();
            if (fVar == null || fVar.errorCode == 0) {
                if (FrsFragment.this.goJ != null) {
                    if (!FrsFragment.this.a(FrsFragment.this.goJ)) {
                        FrsFragment.this.bEj();
                    }
                    FrsFragment.this.L(false, i == 5);
                    if (FrsFragment.this.gpz != null) {
                        if (FrsFragment.this.goJ.getActivityHeadData() != null && FrsFragment.this.goJ.getActivityHeadData().aAA() != null && FrsFragment.this.goJ.getActivityHeadData().aAA().size() > 0) {
                            com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), 1, FrsFragment.this.goJ.getForum(), FrsFragment.this.gpz.getSortType(), 1);
                        }
                        if (FrsFragment.this.goJ.getThreadList() != null && FrsFragment.this.goJ.getThreadList().size() > 0) {
                            Iterator<com.baidu.adp.widget.ListView.m> it = FrsFragment.this.goJ.getThreadList().iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    com.baidu.adp.widget.ListView.m next = it.next();
                                    if ((next instanceof bj) && ((bj) next).getType() == bj.cTr) {
                                        com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), 1, FrsFragment.this.goJ.getForum(), FrsFragment.this.gpz.getSortType(), 2);
                                    }
                                }
                            }
                        }
                        com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), FrsFragment.this.goJ.getThreadList(), FrsFragment.this.goJ.getForum(), FrsFragment.this.gpz.getSortType());
                    }
                    FrsFragment.this.gpj.sR(i);
                    FrsFragment.gpp = (System.nanoTime() - this.startTime) / TimeUtils.NANOS_PER_MS;
                    if (fVar != null) {
                        FrsFragment.gpq = fVar.kfX;
                    }
                } else {
                    return;
                }
            } else if (FrsFragment.this.goJ == null || com.baidu.tbadk.core.util.v.isEmpty(FrsFragment.this.goJ.getThreadList())) {
                FrsFragment.this.a(fVar);
            } else if (fVar.gak) {
                FrsFragment.this.showToast(FrsFragment.this.getPageContext().getResources().getString(R.string.net_error_text, fVar.errorMsg, Integer.valueOf(fVar.errorCode)));
            }
            FrsFragment.this.bEg();
            FrsFragment.this.bEh();
            if (FrsFragment.this.goJ.getAccessFlag() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11384"));
            }
            if (FrsFragment.this.gpg && FrsFragment.this.gpB.ux(49)) {
                FrsFragment.this.gpg = false;
            }
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.q
        public void c(com.baidu.tieba.tbadkCore.m mVar) {
            if ((mVar != null && ("normal_page".equals(FrsFragment.this.gpz.getPageType()) || "frs_page".equals(FrsFragment.this.gpz.getPageType()) || "book_page".equals(FrsFragment.this.gpz.getPageType()))) || "brand_page".equals(FrsFragment.this.gpz.getPageType())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE, mVar));
                FrsFragment.this.b(mVar);
                FrsFragment.gpm = mVar;
            }
        }
    };
    private final CustomMessageListener gqx = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.frs.FrsFragment.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.m) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                FrsFragment.this.goJ.updateCurrentUserPendant((com.baidu.tbadk.data.m) customResponsedMessage.getData());
                FrsFragment.this.gpj.bFq().notifyDataSetChanged();
            }
        }
    };
    private final CustomMessageListener mMemListener = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_MEM) { // from class: com.baidu.tieba.frs.FrsFragment.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && FrsFragment.this.goJ != null && (userData = FrsFragment.this.goJ.getUserData()) != null) {
                userData.setIsMem(num.intValue());
                if (num.intValue() != 0) {
                    FrsFragment.this.gpA.k(num);
                }
            }
        }
    };
    private final com.baidu.tieba.frs.mc.k gqy = new com.baidu.tieba.frs.mc.k() { // from class: com.baidu.tieba.frs.FrsFragment.22
        @Override // com.baidu.tieba.frs.mc.k
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.m> arrayList, boolean z3) {
            if (FrsFragment.this.gpD != null && FrsFragment.this.gpz != null && FrsFragment.this.gpz.bJH() && z && !z2 && !z3) {
                FrsFragment.this.gpD.tW(i2);
            }
        }
    };
    public final View.OnTouchListener dsa = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.FrsFragment.24
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (FrsFragment.this.gpR != null) {
                FrsFragment.this.gpR.onTouch(view, motionEvent);
            }
            if (FrsFragment.this.gpF != null && FrsFragment.this.gpF.bFX() != null) {
                FrsFragment.this.gpF.bFX().onTouchEvent(motionEvent);
            }
            if (FrsFragment.this.eCO != null) {
                FrsFragment.this.eCO.c(view, motionEvent);
            }
            if (FrsFragment.this.gpA != null) {
                FrsFragment.this.gpA.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private final CustomMessageListener gqz = new CustomMessageListener(CmdConfigCustom.CMD_GOTOLIVE_HOST_UPGRADE) { // from class: com.baidu.tieba.frs.FrsFragment.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.aFH().getInt(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.PHOTOLIVE_HOSTLEVEL, -1) != -1 && FrsFragment.this.goJ.getForum() != null) {
                FrsFragment.this.goJ.getForum().setCanAddPhotoLivePost(true);
            }
        }
    };
    public final View.OnClickListener gqA = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.27
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsFragment.this.gpj == null || view != FrsFragment.this.gpj.bFc() || FrsFragment.this.getActivity() == null) {
                if (FrsFragment.this.goJ != null && FrsFragment.this.goJ.getForum() != null && FrsFragment.this.gpj != null && view == FrsFragment.this.gpj.bFi()) {
                    if (FrsFragment.this.gpT == null) {
                        FrsFragment.this.gpT = new com.baidu.tieba.frs.view.c(FrsFragment.this.getPageContext());
                    }
                    FrsFragment.this.gpT.m(FrsFragment.this.goJ);
                    FrsFragment.this.gpT.showDialog();
                    return;
                }
                if (view.getId() == R.id.game_activity_egg_layout && com.baidu.adp.lib.util.l.isNetOk()) {
                    TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_CLICK);
                    if (FrsFragment.this.gpj == null || !FrsFragment.this.gpj.bFn()) {
                        String activityUrl = FrsFragment.this.goJ.getForum().getYuleData().aEC().getActivityUrl();
                        if (!StringUtils.isNull(activityUrl)) {
                            com.baidu.tbadk.browser.a.startInternalWebActivity(FrsFragment.this.getPageContext().getPageActivity(), activityUrl);
                        }
                    } else {
                        FrsFragment.this.gpj.bFo();
                    }
                }
                if (FrsFragment.this.gpj != null && view == FrsFragment.this.gpj.bFu() && FrsFragment.this.gpz != null && FrsFragment.this.gpz.hasMore()) {
                    FrsFragment.this.gpj.bdx();
                    FrsFragment.this.bck();
                }
                if (view != null && FrsFragment.this.gpj != null && view == FrsFragment.this.gpj.bFk() && bc.checkUpIsLogin(FrsFragment.this.getContext())) {
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
        private int gqN = 0;
        private int eku = 0;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsFragment.this.gqe += i2;
            if (FrsFragment.this.gqe >= FrsFragment.this.cdH * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
            if (FrsFragment.this.gpI != null) {
                FrsFragment.this.gpI.bKu();
            }
            this.gqN = 0;
            this.eku = 0;
            if (recyclerView != null && (recyclerView instanceof BdRecyclerView)) {
                this.gqN = ((BdRecyclerView) recyclerView).getFirstVisiblePosition();
                this.eku = ((BdRecyclerView) recyclerView).getLastVisiblePosition();
            }
            if (FrsFragment.this.gpU != null) {
                FrsFragment.this.gpU.a(recyclerView, this.gqN, this.eku);
            }
            if (FrsFragment.this.goJ != null && FrsFragment.this.gpj != null && FrsFragment.this.gpj.bFq() != null) {
                FrsFragment.this.gpj.bF(this.gqN, this.eku);
                if (FrsFragment.this.gpy != null && FrsFragment.this.gpy.nk() != null) {
                    FrsFragment.this.gpy.nk().b(FrsFragment.this.gpx);
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (FrsFragment.this.gpA != null) {
                FrsFragment.this.gpA.setScrollState(i);
            }
            if ((i == 2 || i == 1) && !FrsFragment.this.gpt) {
                FrsFragment.this.gpt = true;
                FrsFragment.this.gpj.bFs();
            }
            if (FrsFragment.this.gpu == null && !FrsFragment.this.bEC()) {
                FrsFragment.this.gpu = new com.baidu.tbadk.n.b();
                FrsFragment.this.gpu.setSubType(1000);
            }
            if (i == 0) {
                if (FrsFragment.this.gpu != null) {
                    FrsFragment.this.gpu.aRh();
                }
                com.baidu.tieba.card.r.bvm().ku(true);
                FrsFragment.this.lk(true);
                FrsFragment.this.gpj.bE(this.gqN, this.eku);
            } else if (FrsFragment.this.gpu != null) {
                FrsFragment.this.gpu.aRg();
            }
            if (FrsFragment.this.gpU != null) {
                FrsFragment.this.gpU.onScrollStateChanged(recyclerView, i);
            }
            if (i == 0) {
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.gpj, FrsFragment.this.goJ, FrsFragment.this.getForumId(), false, null);
            }
            if (FrsFragment.this.gpB != null && i == 1) {
                FrsFragment.this.gpB.bLp();
            }
            if (FrsFragment.this.gpy == null) {
                if (FrsFragment.this.gpj.bEV() != null && !FrsFragment.this.gpj.bEA() && FrsFragment.this.gpj.bEV().czc() != null && (FrsFragment.this.gpj.bEV().czc().getTag() instanceof com.baidu.card.af)) {
                    FrsFragment.this.gpy = (com.baidu.card.af) FrsFragment.this.gpj.bEV().czc().getTag();
                }
            } else if (i == 0 && FrsFragment.this.gpj.bEV() != null && !FrsFragment.this.gpj.bEA() && FrsFragment.this.gpj.bEV().czc() != null && (FrsFragment.this.gpj.bEV().czc().getTag() instanceof com.baidu.card.af)) {
                FrsFragment.this.gpy = (com.baidu.card.af) FrsFragment.this.gpj.bEV().czc().getTag();
            }
            if (i == 1) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921418));
            }
        }
    };
    private final d gqB = new d() { // from class: com.baidu.tieba.frs.FrsFragment.29
        @Override // com.baidu.tieba.frs.d
        public void a(int i, int i2, View view, View view2, bj bjVar) {
            if (i != FrsFragment.this.gpj.bFq().bHt()) {
                if (i != FrsFragment.this.gpj.bFq().bHu()) {
                    if (i == FrsFragment.this.gpj.bFq().bHr() && FrsFragment.this.goJ != null && FrsFragment.this.goJ.getUserData() != null && FrsFragment.this.goJ.getUserData().isBawu()) {
                        String bawuCenterUrl = FrsFragment.this.goJ.getBawuCenterUrl();
                        if (!com.baidu.tbadk.core.util.aq.isEmpty(bawuCenterUrl) && FrsFragment.this.goJ.getForum() != null) {
                            com.baidu.tbadk.browser.a.startWebActivity(FrsFragment.this.getPageContext().getPageActivity(), bawuCenterUrl);
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10502").cx("fid", FrsFragment.this.goJ.getForum().getId()).cx("uid", FrsFragment.this.goJ.getUserData().getUserId()));
                        }
                    }
                } else if (bc.checkUpIsLogin(FrsFragment.this.getPageContext().getPageActivity())) {
                    TiebaStatic.log(CommonStatisticKey.MY_SERVICE_CK);
                    if (FrsFragment.this.goJ != null && FrsFragment.this.goJ.getForum() != null) {
                        ForumData forum = FrsFragment.this.goJ.getForum();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(forum.getId(), 0L), forum.getName(), forum.getImage_url(), 0)));
                    }
                }
            } else if (bc.checkUpIsLogin(FrsFragment.this.getActivity())) {
                TiebaStatic.log("forum_fortune_click");
                com.baidu.tieba.frs.f.i.b(FrsFragment.this.getPageContext(), FrsFragment.this.goJ);
            }
        }
    };
    private final NoNetworkView.a gmG = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.FrsFragment.30
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (FrsFragment.this.gpz.bJy() == 1 && z && !FrsFragment.this.gpj.bEA()) {
                if (FrsFragment.this.goJ == null || com.baidu.tbadk.core.util.v.isEmpty(FrsFragment.this.goJ.getThreadList())) {
                    FrsFragment.this.hideNetRefreshView(FrsFragment.this.gpj.bsL());
                    FrsFragment.this.showLoadingView(FrsFragment.this.gpj.bsL(), true);
                    FrsFragment.this.gpj.lu(false);
                    FrsFragment.this.refresh();
                    return;
                }
                FrsFragment.this.gpj.bFe();
            }
        }
    };
    private final CustomMessageListener doS = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.FrsFragment.31
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                com.baidu.tieba.frs.f.c.a(customResponsedMessage, FrsFragment.this.gpj, FrsFragment.this.goJ);
            }
        }
    };
    private com.baidu.adp.widget.ListView.s gqC = new a();
    private ak gqD = new ak() { // from class: com.baidu.tieba.frs.FrsFragment.33
        @Override // com.baidu.tieba.frs.ak
        public void a(int i, int i2, ar arVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
            com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.33.1
                @Override // java.lang.Runnable
                public void run() {
                    if (FrsFragment.this.gpj != null && FrsFragment.this.gpj.bFv()) {
                        FrsFragment.this.bck();
                    }
                }
            });
        }
    };
    private CustomMessageListener gqE = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.frs.FrsFragment.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    FrsFragment.this.gpV = true;
                }
            }
        }
    };
    private CustomMessageListener gqF = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.frs.FrsFragment.36
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                    if (FrsFragment.this.gpy == null && FrsFragment.this.gpj.bEV() != null && !FrsFragment.this.gpj.bEA() && FrsFragment.this.gpj.bEV().czc() != null && (FrsFragment.this.gpj.bEV().czc().getTag() instanceof com.baidu.card.af)) {
                        FrsFragment.this.gpy = (com.baidu.card.af) FrsFragment.this.gpj.bEV().czc().getTag();
                    }
                    if (FrsFragment.this.gpy != null && FrsFragment.this.gpy.nk() != null) {
                        FrsFragment.this.gpy.nk().b(new a.C0052a(3));
                    }
                }
            }
        }
    };
    private CustomMessageListener gqG = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.FrsFragment.37
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.gpj != null) {
                FrsFragment.this.gpj.sr();
            }
        }
    };
    private CustomMessageListener gqH = new CustomMessageListener(2921437) { // from class: com.baidu.tieba.frs.FrsFragment.38
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && FrsFragment.this.isResumed()) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (FrsFragment.this.gpl != null) {
                    if (booleanValue) {
                        if (FrsFragment.this.gpB.bLq() != 0 && !FrsFragment.this.gpj.bFA()) {
                            FrsFragment.this.gpl.show();
                            return;
                        }
                        return;
                    }
                    FrsFragment.this.gpl.hide();
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.frs.loadmore.a
    public /* bridge */ /* synthetic */ com.baidu.adp.base.e getPageContext() {
        return super.getPageContext();
    }

    public com.baidu.tieba.frs.entelechy.b.b bDP() {
        return this.gpH;
    }

    public com.baidu.adp.widget.ListView.s bDQ() {
        return this.gqC;
    }

    public com.baidu.tieba.frs.mc.d bDR() {
        return this.gpJ;
    }

    public com.baidu.tieba.frs.smartsort.a bDS() {
        return this.gpD;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public FrsModelController bDT() {
        return this.gpz;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public com.baidu.tieba.frs.mc.c bDU() {
        return this.gpK;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public com.baidu.tieba.frs.vc.h bDV() {
        return this.gpA;
    }

    public FrsTabViewController bDW() {
        return this.gpB;
    }

    public am bDX() {
        return this.gpF;
    }

    public void lj(boolean z) {
        this.gqd = z;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public m bDY() {
        return this.gpj;
    }

    @Override // com.baidu.tieba.frs.al
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.al, com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.gpb;
    }

    public void setForumName(String str) {
        this.gpb = str;
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
        if (this.gpK == null) {
            return 1;
        }
        return this.gpK.getPn();
    }

    public int getPn() {
        if (this.gpK == null) {
            return 1;
        }
        return this.gpK.getPn();
    }

    public void setPn(int i) {
        if (this.gpK != null) {
            this.gpK.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.gpK != null) {
            this.gpK.setHasMore(i);
        }
    }

    public int bDZ() {
        if (this.gpK == null) {
            return -1;
        }
        return this.gpK.bDZ();
    }

    public boolean bEa() {
        return this.gph;
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
            this.gpj.bEY();
            showNetRefreshView(this.gpj.bsL(), string, true);
        } else if (340001 == fVar.errorCode) {
            a(fVar, this.goJ.getRecm_forum_list());
        } else {
            if (com.baidu.tbadk.core.util.v.isEmpty(this.goJ.getThreadList())) {
                b(fVar);
            }
            if (bEC()) {
                setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds280));
            } else {
                setNetRefreshViewEmotionDefMarginTop();
            }
        }
    }

    public void a(View view, String str, boolean z, List<RecmForumInfo> list) {
        this.gpj.bEY();
        this.gpj.sN(8);
        if (this.gpS == null) {
            this.gpS = new com.baidu.tieba.frs.view.a(getPageContext(), getNetRefreshListener());
        }
        this.gpS.setSubText(str);
        this.gpS.ct(list);
        this.gpS.attachView(view, z);
    }

    private void a(com.baidu.tieba.tbadkCore.f fVar, List<RecmForumInfo> list) {
        if (this.gpj != null) {
            this.gpj.bEY();
            this.gpj.setTitle(this.gpb);
            a(this.gpj.bsL(), fVar.errorMsg, true, list);
        }
    }

    private void b(com.baidu.tieba.tbadkCore.f fVar) {
        this.gpj.bEY();
        if (fVar.gak) {
            showNetRefreshView(this.gpj.bsL(), TbadkCoreApplication.getInst().getString(R.string.net_error_text, new Object[]{fVar.errorMsg, Integer.valueOf(fVar.errorCode)}), true);
        } else {
            showNetRefreshView(this.gpj.bsL(), fVar.errorMsg, true);
        }
    }

    public void bEb() {
        hideLoadingView(this.gpj.bsL());
        this.gpj.lw(false);
        if (this.gpj.bEW() instanceof com.baidu.tieba.frs.tab.c) {
            ((com.baidu.tieba.frs.tab.c) this.gpj.bEW()).bKb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEc() {
        if (bDZ() == 0 && com.baidu.tbadk.core.util.v.isEmpty(this.goJ.getThreadListIds())) {
            if (com.baidu.tbadk.core.util.v.isEmpty(this.goJ.getThreadList())) {
                this.gpj.bdz();
            } else {
                this.gpj.bdy();
            }
        } else if (com.baidu.tbadk.core.util.v.getCount(this.goJ.getThreadList()) > 3) {
            this.gpj.bdx();
        } else {
            this.gpj.bFt();
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
            bEb();
            this.gpj.bFe();
            com.baidu.tieba.tbadkCore.f bJu = this.gpz.bJu();
            boolean isEmpty = com.baidu.tbadk.core.util.v.isEmpty(this.goJ.getThreadList());
            if (bJu != null && isEmpty) {
                if (this.gpz.bJw() != 0) {
                    this.gpz.bJB();
                    this.gpj.bFe();
                } else {
                    a(bJu);
                }
                this.gpj.M(this.goJ.isStarForum(), false);
                return;
            }
            a(bJu);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(com.baidu.tieba.tbadkCore.m mVar) {
        if (mVar != null && mVar.getEntelechyTabInfo() != null && mVar.getEntelechyTabInfo().tab != null) {
            for (FrsTabInfo frsTabInfo : mVar.getEntelechyTabInfo().tab) {
                if (frsTabInfo.tab_id.intValue() == 502 && com.baidu.tbadk.core.sharedPref.b.aFH().getBoolean("first_into_tab_profession", true)) {
                    return false;
                }
            }
        }
        return new com.baidu.tieba.frs.ad.f(getTbPageContext()).d(mVar);
    }

    public boolean bEd() {
        return bEe() && !bEf();
    }

    private boolean bEe() {
        if (bEz() == null) {
            return false;
        }
        FrsViewData bEz = bEz();
        com.baidu.tbadk.core.data.t tVar = null;
        if (bEz.getStar() != null && !StringUtils.isNull(bEz.getStar().cKK())) {
            tVar = new com.baidu.tbadk.core.data.t();
        } else if (bEz.getActivityHeadData() != null && com.baidu.tbadk.core.util.v.getCount(bEz.getActivityHeadData().aAA()) >= 1) {
            tVar = bEz.getActivityHeadData().aAA().get(0);
        }
        return tVar != null;
    }

    public boolean bEf() {
        if (bEz() == null) {
            return false;
        }
        FrsViewData bEz = bEz();
        return (com.baidu.tbadk.core.util.v.isEmpty(bEz.getShowTopThreadList()) && bEz.getBusinessPromot() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEg() {
        boolean b;
        if (!bEi()) {
            final PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
            privateForumPopInfoData.a(this.goJ.getPrivateForumTotalInfo().getPrivatePopInfo());
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(getActivity());
            if (this.goJ.getPrivateForumTotalInfo().aBu().private_forum_status.intValue() == 1 && (com.baidu.tbadk.core.util.aq.isEmpty(privateForumPopInfoData.aBw()) || privateForumPopInfoData.aBz() != Integer.valueOf(this.forumId))) {
                privateForumPopInfoData.sy("create_success");
                privateForumPopInfoData.sz(TbadkCoreApplication.getInst().getString(R.string.frs_private_create_hint));
                privateForumPopInfoData.sA("https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.gpb + "&nomenu=1");
                privateForumPopInfoData.g(Integer.valueOf(this.forumId));
                b = frsPrivateCommonDialogView.b(privateForumPopInfoData);
            } else {
                b = privateForumPopInfoData.aBz() == Integer.valueOf(this.forumId) ? frsPrivateCommonDialogView.b(privateForumPopInfoData) : false;
            }
            if (b) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
                aVar.jZ(2);
                aVar.aO(frsPrivateCommonDialogView);
                aVar.fI(false);
                frsPrivateCommonDialogView.setConfirmButton(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.11
                    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.frs.FrsFragment */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ba.aGK().b(FrsFragment.this.getPageContext(), new String[]{privateForumPopInfoData.aBy()});
                        aVar.dismiss();
                    }
                });
                aVar.a(new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.13
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(getPageContext()).aEG();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEh() {
        if (bEi() || this.goJ.getPrivateForumTotalInfo().aBu().private_forum_status.intValue() != 1) {
            a((Integer) null, (Integer) null, true);
        } else {
            a(this.goJ.getPrivateForumTotalInfo().aBu().private_forum_audit_status, this.goJ.getPrivateForumTotalInfo().aBv(), false);
        }
    }

    public void a(Integer num, Integer num2, boolean z) {
        final String str;
        final int i = 2;
        if (this.gpj.bFj() != null) {
            TextView bFj = this.gpj.bFj();
            if (z) {
                bFj.setVisibility(8);
                return;
            }
            if (num.intValue() == 2) {
                bFj.setText("修改实名认证信息");
                bFj.setVisibility(0);
                str = "https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + this.forumId + "&nomenu=1";
            } else if (num2.intValue() >= 0 && num2.intValue() <= 100) {
                bFj.setText("目标已完成" + String.valueOf(num2) + "%");
                bFj.setVisibility(0);
                str = "https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.gpb + "&nomenu=1";
                i = 1;
            } else {
                bFj.setVisibility(8);
                i = 0;
                str = "";
            }
            bFj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.14
                /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13387").cx("fid", FrsFragment.this.forumId).cx("uid", TbadkCoreApplication.getCurrentAccount()).X("obj_type", i));
                    ba.aGK().b(FrsFragment.this.getPageContext(), new String[]{str});
                }
            });
        }
    }

    private boolean bEi() {
        return this.goJ == null || !this.goJ.isPrivateForum() || this.goJ.getPrivateForumTotalInfo() == null || this.goJ.getPrivateForumTotalInfo().aBu() == null || this.goJ.getUserData().getIs_manager() != 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEj() {
        boolean z;
        boolean z2;
        if (this.goJ == null || this.goJ.getEntelechyTabInfo() == null || this.goJ.getEntelechyTabInfo().tab == null) {
            z = false;
        } else {
            z = false;
            for (FrsTabInfo frsTabInfo : this.goJ.getEntelechyTabInfo().tab) {
                if (frsTabInfo.tab_id.intValue() == 502) {
                    if (com.baidu.tbadk.core.sharedPref.b.aFH().getBoolean("first_into_tab_profession", true)) {
                        return;
                    }
                } else if (frsTabInfo.is_general_tab.intValue() == 1) {
                    z2 = true;
                    z = z2;
                }
                z2 = z;
                z = z2;
            }
        }
        if (z && com.baidu.tbadk.core.sharedPref.b.aFH().getBoolean("first_into_tab_general", true)) {
            j.a(getActivity(), getPageContext());
            com.baidu.tbadk.core.sharedPref.b.aFH().putBoolean("first_into_tab_general", false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sE(int i) {
        List<WindowToast> list;
        if (TbadkCoreApplication.isLogin() && this.goJ != null && (list = this.goJ.mWindowToast) != null && list.size() > 0) {
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
    public void bEk() {
        if (this.goJ == null || this.goJ.getForum() != null) {
            this.gpj.bFp();
        } else if (this.goJ.getForum().getYuleData() != null && this.goJ.getForum().getYuleData().aEB()) {
            TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_VIEW);
            this.gpj.a(this.goJ.getForum().getYuleData().aEC());
        } else {
            this.gpj.bFp();
        }
    }

    private void K(boolean z, boolean z2) {
        if (this.gpz != null && this.goJ != null && this.gpj != null && z) {
            if (!this.gpz.bJH() && this.gpz.bJy() == 1) {
                if (!this.gpz.bJF()) {
                    this.goJ.addCardVideoInfoToThreadList();
                    this.goJ.addVideoInfoToThreadListInTenAndFifteenFloor();
                }
                boolean z3 = false;
                if (this.gpj.bFq().p(com.baidu.tieba.card.data.n.fOr)) {
                    z3 = this.goJ.addHotTopicDataToThreadList();
                }
                if (!z3) {
                    this.goJ.addFeedForumDataToThreadList();
                }
                if (TbadkCoreApplication.getInst().isRecAppExist()) {
                    this.goJ.addRecommendAppToThreadList(this);
                }
                if (!this.gpj.bFq().p(bj.cRO)) {
                    this.goJ.removeAlaLiveThreadData();
                }
                this.goJ.addSchoolRecommendToThreadList();
            }
            if (!this.gpj.bFq().p(bj.cRO)) {
                this.goJ.removeAlaInsertLiveData();
                this.goJ.removeAlaStageLiveDat();
            } else {
                this.goJ.addInsertLiveDataToThreadList();
                this.goJ.addStageLiveDataToThreadList();
            }
            this.goJ.checkLiveStageInThreadList();
            this.goJ.addNoticeThreadToThreadList();
            if (this.gpj.bFq().p(com.baidu.tieba.h.b.gSR)) {
                this.goJ.addGameRankListToThreadList(z2);
            }
            if (TbadkCoreApplication.isLogin() && (!this.gpz.bJH() || this.gpz.isNetFirstLoad)) {
                this.goJ.addUserRecommendToThreadList();
            }
            this.goJ.addVideoActivityToTop();
        }
    }

    public boolean bEl() {
        if (this.gpA != null && this.gpz != null) {
            this.gpA.a(this.gpz.getPageType(), this.goJ);
        }
        boolean z = false;
        if (this.goJ != null) {
            z = this.goJ.hasTab();
        }
        bEn();
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sF(int i) {
        ao aoVar = null;
        bEl();
        bEu();
        try {
            if (this.goJ != null) {
                this.gpj.a((ArrayList<com.baidu.adp.widget.ListView.m>) null, this.goJ);
                this.gpA.uq(1);
                this.gpj.bFh();
                this.gpB.a(this.goJ, this.gpz.bJD());
                com.baidu.tieba.frs.tab.d uy = this.gpB.uy(this.goJ.getFrsDefaultTabId());
                if (uy != null && !TextUtils.isEmpty(uy.url)) {
                    aoVar = new ao();
                    aoVar.ext = uy.url;
                    aoVar.stType = uy.name;
                }
                this.gpz.a(this.goJ.getFrsDefaultTabId(), 0, aoVar);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(boolean z, boolean z2) {
        try {
            if (this.goJ != null && this.gpB != null && this.gpz != null) {
                if (!this.gpj.bFq().p(bj.cRO)) {
                    this.goJ.removeAlaLiveThreadData();
                }
                boolean isEmpty = com.baidu.tbadk.core.util.v.isEmpty(this.goJ.getGameTabInfo());
                this.gpj.ls(isEmpty);
                if (!isEmpty) {
                    if (this.gpU == null) {
                        this.gpU = new com.baidu.tieba.frs.vc.e(this, (NoPressedRelativeLayout) this.mRootView);
                    }
                    if (this.eCO == null) {
                        this.eCO = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
                    }
                } else {
                    this.gpU = null;
                    this.eCO = null;
                }
                if (this.goJ.getForum() != null) {
                    this.gpb = this.goJ.getForum().getName();
                    this.forumId = this.goJ.getForum().getId();
                }
                if (this.goJ.hasTab()) {
                    this.gpB.a(this.goJ, this.gpz.bJD());
                }
                if (z) {
                    K(true, z);
                } else {
                    K(this.gpv, z);
                }
                bEl();
                if (this.gpH != null) {
                    this.gpH.a(this.gpA, this.goJ);
                }
                if (this.goJ.getPage() != null) {
                    setHasMore(this.goJ.getPage().aBn());
                }
                ArrayList<com.baidu.adp.widget.ListView.m> a2 = this.gpK.a(z2, true, this.goJ.getThreadList(), null, z, false);
                if (a2 != null) {
                    this.goJ.setThreadList(a2);
                }
                this.goJ.removeRedundantUserRecommendData();
                this.goL = this.goJ.getTopThreadSize();
                if (this.gpf != null) {
                    this.gpe = true;
                    this.gpf.CA(this.goL);
                    com.baidu.tieba.frs.f.a.a(this, this.goJ.getForum(), this.goJ.getThreadList(), this.gpe, getPn());
                }
                if (this.gpz.bJy() == 1) {
                    bEr();
                    if (!z && this.gpz.getPn() == 1) {
                        bEm();
                    }
                }
                if (this.gpI != null) {
                    this.gpI.bV(this.gpB.bLm());
                }
                bEb();
                this.gpj.bEZ();
                this.gpj.M(true, false);
                if (z && this.goJ.isFirstTabEqualAllThread()) {
                    com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.15
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!FrsFragment.this.gps && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                FrsFragment.this.gpj.bFz();
                            }
                        }
                    });
                }
                if (this.goJ.getForum() != null) {
                    this.gpj.Bh(this.goJ.getForum().getWarningMsg());
                }
                if (this.goJ != null && this.goJ.getFrsVideoActivityData() != null && com.baidu.tbadk.core.sharedPref.b.aFH().getLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 0L) == 0) {
                    com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.16
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsFragment.this.gpj.bFx();
                        }
                    }, 1000L);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FRS_SHOW_AR_ENTRY, this));
                this.gpj.bET();
                if (this.goJ != null && this.goJ.getForum() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ENTER_FORUM, new VisitedForumData(this.goJ.getForum().getId(), this.goJ.getForum().getName(), this.goJ.getForum().getImage_url(), String.valueOf(System.currentTimeMillis() / 1000), ConstantData.Forum.SPECAIL_FORUM_TYPE_LIVE.equals(this.goJ.getForum().special_forum_type), this.goJ.getForum().getThemeColorInfo(), this.goJ.getForum().getMember_num())));
                }
                this.gpY.a(this.goJ.bottomMenuList, this.goJ.getForum());
                bEJ();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void lk(boolean z) {
        com.baidu.tieba.s.c.cKv().b(getUniqueId(), z);
    }

    public void bEm() {
        if (this.gpN == null) {
            this.gpN = new com.baidu.tieba.frs.live.a(this, com.baidu.adp.lib.f.b.toInt(this.forumId, 0));
        }
        this.gpN.bJf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.tbadkCore.m mVar) {
        try {
            if (!this.gps && mVar != null && this.goJ != null) {
                this.goJ.receiveData(mVar);
                L(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void bEn() {
        if (this.gpz != null) {
            Bg(this.gpz.getPageType());
        } else {
            Bg("normal_page");
        }
    }

    private void Bg(String str) {
        ll("frs_page".equals(str));
        if (this.gpH != null) {
            this.gpH.a(this.gpA, this.gpj, this.goJ);
        }
    }

    public void ll(boolean z) {
        if (this.gpL != null) {
            this.gpL.bLe();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.s.c.cKv().w(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.frs_activity, viewGroup, false);
            this.goV = new com.baidu.tieba.frs.entelechy.a();
            this.gpH = this.goV.bGX();
            this.goU = TbadkCoreApplication.getInst().getString(R.string.frs_title_new_area);
            this.gpA = new com.baidu.tieba.frs.vc.h(this, this.goV, (FrsHeaderViewContainer) this.mRootView.findViewById(R.id.header_view_container));
            this.gpB = new FrsTabViewController(this, this.mRootView);
            this.gpB.registerListener();
            this.gpA.a(this.gpB);
            this.gpB.a(this.gqj);
            Intent intent = getActivity().getIntent();
            if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                this.goX = true;
            }
            this.gpj = new m(this, this.gqA, this.goV, this.goX, this.gpA);
            this.gpY = new com.baidu.tieba.frs.brand.buttommenu.a(getPageContext(), this.mRootView);
        } else {
            if (this.mRootView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            if (this.gpB != null) {
                this.gpB.registerListener();
            }
            this.gpj.bFw();
            this.mRootView.setLeft(0);
            this.mRootView.setRight(com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getContext()));
        }
        this.gqc = true;
        this.dDY = System.currentTimeMillis() - currentTimeMillis;
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        ArrayList<com.baidu.adp.widget.ListView.m> arrayList = null;
        this.fWb = System.currentTimeMillis();
        long j = this.fWb;
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.gpg = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.fWb = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            ai(intent);
        }
        this.dDX = j - this.fWb;
        this.gpf = new com.baidu.tieba.tbadkCore.data.f("frs", com.baidu.tieba.tbadkCore.data.f.khG);
        if (this.gpz == null) {
            this.gpz = new FrsModelController(this, this.gqw);
            this.gpz.a(this.gqi);
            this.gpz.init();
        }
        if (intent != null) {
            this.gpz.ad(intent.getExtras());
        } else if (bundle != null) {
            this.gpz.ad(bundle);
        } else {
            this.gpz.ad(null);
        }
        if (intent != null) {
            this.gpA.aj(intent.getExtras());
        } else if (bundle != null) {
            this.gpA.aj(bundle);
        } else {
            this.gpA.aj(null);
        }
        this.gpi = getVoiceManager();
        this.gpO = new l(getPageContext(), this);
        initUI();
        initData(bundle);
        if (!bEC()) {
            this.gpF = new am(getActivity(), this.gpj, this.gpA);
            this.gpF.lI(true);
        }
        this.gpi = getVoiceManager();
        if (this.gpi != null) {
            this.gpi.onCreate(getPageContext());
        }
        new com.baidu.tieba.frs.mc.i();
        int i = -1;
        if (this.gpK != null && this.gpK.bJq() != null) {
            i = this.gpK.bJq().bDZ();
            arrayList = this.gpK.bJq().getDataList();
        }
        this.gpK = new com.baidu.tieba.frs.mc.c(this, this.gqy);
        this.gpK.bJq().setHasMore(i);
        if (arrayList != null && arrayList.size() > 0) {
            this.gpK.bJq().at(arrayList);
        }
        this.gpD = new com.baidu.tieba.frs.smartsort.a(this);
        this.gpL = new com.baidu.tieba.frs.vc.j(this);
        this.gpI = new com.baidu.tieba.frs.vc.a(getPageContext(), this.gpz.bJE());
        this.gpE = new com.baidu.tieba.frs.mc.b(this);
        this.gpJ = new com.baidu.tieba.frs.mc.d(this);
        this.gpC = new com.baidu.tieba.frs.mc.h(this);
        this.gpM = new com.baidu.tieba.frs.mc.a(this);
        this.gpP = new com.baidu.tieba.frs.vc.c(this);
        this.gpQ = new com.baidu.tieba.frs.mc.e(this, getUniqueId());
        this.gpW = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "frs");
        this.gpX = new com.baidu.tieba.ala.a(getPageContext());
        this.gpZ = new com.baidu.tieba.frs.sportspage.notification.a(getPageContext());
        registerListener(this.gqq);
        registerListener(this.mMemListener);
        registerListener(this.gqo);
        registerListener(this.gqz);
        registerListener(this.gqx);
        registerListener(this.gql);
        registerListener(this.gqm);
        registerListener(this.gqn);
        registerListener(this.gqf);
        registerListener(this.gqg);
        registerListener(this.KN);
        registerListener(this.gqE);
        registerListener(this.gqs);
        registerListener(this.gqh);
        registerListener(this.gqt);
        registerListener(this.gqr);
        registerListener(this.gqu);
        registerListener(this.gqv);
        this.gqF.setTag(getPageContext().getUniqueId());
        MessageManager.getInstance().registerListener(this.gqF);
        registerListener(this.gqG);
        registerListener(this.gqH);
        this.gpj.lu(false);
        if (!bEC() && !this.hasInit) {
            showLoadingView(this.gpj.bsL(), true);
            this.gpz.F(3, false);
        }
        com.baidu.tieba.frs.a.bDd().a(new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.19
            @Override // com.baidu.tieba.frs.a.b
            public void J(boolean z, boolean z2) {
                if (FrsFragment.this.gpj != null) {
                    FrsFragment.this.gpj.sO(z ? 0 : 8);
                    if (!z2) {
                        FrsFragment.this.gqb = z;
                    }
                    if (FrsFragment.this.gpj.bFq() != null && FrsFragment.this.gpz != null && FrsFragment.this.gpz.bJz()) {
                        FrsFragment.this.gpj.bFq().notifyDataSetChanged();
                    }
                    if (FrsFragment.this.bDW() != null) {
                        FrsTabViewController.b bLn = FrsFragment.this.bDW().bLn();
                        if (bLn != null && bLn.tabId == 502 && (bLn.fragment instanceof FrsCommonTabFragment)) {
                            ((FrsCommonTabFragment) bLn.fragment).bGP();
                        } else if (bLn != null && bLn.tabId == 503 && (bLn.fragment instanceof FrsNewAreaFragment)) {
                            FrsNewAreaFragment frsNewAreaFragment = (FrsNewAreaFragment) bLn.fragment;
                            frsNewAreaFragment.bGP();
                            if (frsNewAreaFragment.bJL() != null) {
                                com.baidu.tieba.frs.mc.g bJL = frsNewAreaFragment.bJL();
                                bJL.lx(!z);
                                bJL.ly(!z);
                            }
                        }
                        if (FrsFragment.this.bDW().bLf() != null) {
                            FrsFragment.this.bDW().bLf().setmDisallowSlip(z);
                            FrsFragment.this.bDW().mn(z);
                        }
                    }
                    if (FrsFragment.this.gpj.bEX() != null) {
                        FrsFragment.this.gpj.lr(!z);
                    }
                    if (FrsFragment.this.getActivity() instanceof FrsActivity) {
                        ((FrsActivity) FrsFragment.this.getActivity()).li(!z);
                    }
                    if (FrsFragment.this.gpY != null) {
                        FrsFragment.this.gpY.lP(!z);
                    }
                    FrsFragment.this.gpj.lx(!z);
                    FrsFragment.this.gpj.ly(z ? false : true);
                }
            }

            @Override // com.baidu.tieba.frs.a.b
            public void sB(int i2) {
                if (FrsFragment.this.gpj != null) {
                    FrsFragment.this.gpj.sP(i2);
                }
            }

            @Override // com.baidu.tieba.frs.a.b
            public void bDl() {
                com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getContext(), (int) R.string.frs_multi_delete_max_num);
            }
        });
        this.gpj.b(new d.a() { // from class: com.baidu.tieba.frs.FrsFragment.20
            @Override // com.baidu.tieba.NEGFeedBack.d.a
            public void a(DeleteThreadHttpResponseMessage deleteThreadHttpResponseMessage) {
                boolean z;
                int i2 = 0;
                if (deleteThreadHttpResponseMessage != null) {
                    FrsFragment.this.gpj.aWs();
                    FrsFragment.this.gpj.bFy();
                    FrsNewAreaFragment frsNewAreaFragment = null;
                    if (FrsFragment.this.gpB == null || FrsFragment.this.gpB.bLn() == null || !(FrsFragment.this.gpB.bLn().fragment instanceof FrsNewAreaFragment)) {
                        z = false;
                    } else {
                        frsNewAreaFragment = (FrsNewAreaFragment) FrsFragment.this.gpB.bLn().fragment;
                        z = true;
                    }
                    if (deleteThreadHttpResponseMessage.getError() == 0) {
                        String text = !TextUtils.isEmpty(deleteThreadHttpResponseMessage.getText()) ? deleteThreadHttpResponseMessage.getText() : FrsFragment.this.getString(R.string.delete_fail);
                        if (deleteThreadHttpResponseMessage.getRetType() == 1211066) {
                            if (FrsFragment.this.fMK == null) {
                                FrsFragment.this.fMK = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.fMK.sS(text);
                            FrsFragment.this.fMK.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.20.1
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.fMK.fI(false);
                            FrsFragment.this.fMK.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.fMK.aEG();
                        } else if (deleteThreadHttpResponseMessage.getRetType() == 1211067) {
                            if (FrsFragment.this.fMK == null) {
                                FrsFragment.this.fMK = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.fMK.sS(text);
                            FrsFragment.this.fMK.a(R.string.know, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.20.2
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.fMK.fI(false);
                            FrsFragment.this.fMK.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.fMK.aEG();
                        } else {
                            FrsFragment.this.gpj.az(deleteThreadHttpResponseMessage.getText(), ContextCompat.getColor(FrsFragment.this.getContext(), deleteThreadHttpResponseMessage.getRetType() == 1 ? R.color.nav_bar_tip_error : R.color.cp_link_tip_a_alpha95));
                        }
                        if (z && frsNewAreaFragment != null) {
                            frsNewAreaFragment.co(deleteThreadHttpResponseMessage.getSuccessItems());
                        }
                        FrsFragment.this.cd(deleteThreadHttpResponseMessage.getSuccessItems());
                        com.baidu.tieba.frs.a.bDd().cc(deleteThreadHttpResponseMessage.getSuccessItems());
                        for (com.baidu.adp.widget.ListView.m mVar : FrsFragment.this.goJ.getThreadList()) {
                            if (mVar instanceof bi) {
                                i2++;
                                continue;
                            }
                            if (i2 >= 6) {
                                break;
                            }
                        }
                        if (i2 < 6) {
                            FrsFragment.this.bck();
                            return;
                        }
                        return;
                    }
                    com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getActivity(), deleteThreadHttpResponseMessage.getErrorString());
                }
            }
        });
        this.cdH = UtilHelper.getScreenHeight(getActivity());
        this.hasInit = true;
        sG(1);
        super.onActivityCreated(bundle);
        this.createTime = System.currentTimeMillis() - j;
    }

    public void lm(boolean z) {
        if (this.gpB != null) {
            this.gpB.gOi = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cd(List<String> list) {
        if (!com.baidu.tbadk.core.util.v.isEmpty(list)) {
            ArrayList<com.baidu.adp.widget.ListView.m> threadList = this.goJ.getThreadList();
            if (!com.baidu.tbadk.core.util.v.isEmpty(threadList) && this.gpj.getListView() != null && this.gpj.getListView().getData() != null) {
                Iterator<com.baidu.adp.widget.ListView.m> it = threadList.iterator();
                List<com.baidu.adp.widget.ListView.m> data = this.gpj.getListView().getData();
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.m next = it.next();
                    if (next instanceof bi) {
                        bj bjVar = ((bi) next).cRt;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= list.size()) {
                                break;
                            } else if (!com.baidu.tbadk.core.util.aq.equals(list.get(i2), bjVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.gpK.d(next);
                                this.gpj.getListView().getAdapter().notifyItemRemoved(i);
                                break;
                            }
                        }
                    }
                    i++;
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void bcE() {
        if (isAdded() && this.eoz && !isLoadingViewAttached()) {
            showLoadingView(this.gpj.bsL(), true);
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void bcF() {
        if (isAdded() && this.eoz && isLoadingViewAttached()) {
            hideLoadingView(this.gpj.bsL());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (bEC()) {
            showLoadingView(this.gpj.bsL(), true);
            this.gpj.sQ(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.gpz.F(3, true);
            aIm().scrollToPosition(0);
        }
    }

    private void sG(int i) {
        String str = "";
        if (this.goJ != null && this.goJ.getForum() != null) {
            str = this.goJ.getForum().getId();
        }
        if (!StringUtils.isNull(str)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13008").cx("fid", str).cx("obj_type", "4").X("obj_locate", i).cx("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.z zVar) {
        if (zVar != null) {
            this.dHr = zVar.aSt();
            this.gpR = zVar.aSu();
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void showFloatingView() {
        if (this.dHr != null) {
            this.dHr.he(true);
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
                this.gpb = uri.getQueryParameter("name");
                this.mFrom = uri.getQueryParameter("from");
                if (!StringUtils.isNull(this.gpb)) {
                    intent.putExtra("name", this.gpb);
                }
                if (!StringUtils.isNull(this.mFrom)) {
                    intent.putExtra("from", this.mFrom);
                }
                TiebaStatic.log(TbadkCoreStatisticKey.AS_INVOKE_TIEBA);
            }
            if (StringUtils.isNull(this.gpb) && intent != null && intent.getParcelableExtra("key_uri") != null) {
                Uri uri2 = (Uri) intent.getParcelableExtra("key_uri");
                if (com.baidu.tbadk.BdToken.f.n(uri2)) {
                    com.baidu.tbadk.BdToken.f.axS().b(uri2, new f.a() { // from class: com.baidu.tieba.frs.FrsFragment.21
                        @Override // com.baidu.tbadk.BdToken.f.a
                        public void n(HashMap<String, Object> hashMap) {
                            if (hashMap != null && (hashMap.get(com.baidu.tbadk.BdToken.f.cIu) instanceof String)) {
                                FrsFragment.this.gpb = (String) hashMap.get(com.baidu.tbadk.BdToken.f.cIu);
                            }
                        }
                    });
                } else {
                    com.baidu.tieba.frs.f.d al = com.baidu.tieba.frs.f.i.al(intent);
                    if (al != null) {
                        this.gpb = al.forumName;
                        if (al.gMt == null || al.gMt.equals("aidou")) {
                        }
                    }
                }
                if (!StringUtils.isNull(this.gpb)) {
                    intent.putExtra("name", this.gpb);
                }
                intent.putExtra(FrsActivityConfig.FRS_CALL_FROM, 12);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.gpi = getVoiceManager();
        if (this.gpi != null) {
            this.gpi.onStart(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        Intent intent;
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.doS);
        if (bundle != null) {
            this.gpb = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
            this.gpb = intent.getStringExtra("name");
            this.mFrom = intent.getStringExtra("from");
            this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
        }
        if (getArguments() != null) {
            this.gpc = getArguments().getBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, false);
        }
        if (TextUtils.isEmpty(this.mFrom) || FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
        }
        if (this.mIsLogin) {
            registerListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL, this.doS);
        }
        this.gpA.aj(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.s.c.cKv().x(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.gqE);
        gpm = null;
        if (this.gpi != null) {
            this.gpi.onDestory(getPageContext());
        }
        com.baidu.tieba.recapp.report.a.remove("FRS");
        this.gpi = null;
        com.baidu.tieba.card.r.bvm().ku(false);
        if (this.goJ != null && this.goJ.getForum() != null) {
            ac.bFU().dv(com.baidu.adp.lib.f.b.toLong(this.goJ.getForum().getId(), 0L));
        }
        if (this.gpN != null) {
            this.gpN.onDestory();
        }
        if (this.gpj != null) {
            com.baidu.tieba.frs.f.h.a(this.gpj, this.goJ, getForumId(), false, null);
            this.gpj.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.gpu != null) {
                this.gpu.aRi();
            }
            if (this.gpj != null) {
                this.gpj.release();
            }
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.gpA.aiL();
        if (this.gpz != null) {
            this.gpz.bhc();
        }
        if (this.gpF != null) {
            this.gpF.aWN();
        }
        if (this.gpI != null) {
            this.gpI.destory();
        }
        if (this.gpD != null) {
            this.gpD.onDestroy();
        }
        if (this.gpU != null) {
            this.gpU.onDestory();
        }
        if (this.gpM != null) {
            this.gpM.onDestroy();
        }
        if (this.gpW != null) {
            this.gpW.onDestroy();
        }
        if (this.gpX != null) {
            this.gpX.onDestroy();
        }
        com.baidu.tieba.recapp.d.a.cDF().cDH();
        com.baidu.tieba.frs.f.j.bKr();
        if (this.gpB != null) {
            this.gpB.a((FrsTabViewController.a) null);
            this.gpB.bLp();
        }
        if (this.gqa != null) {
            this.gqa.onDestroy();
        }
        com.baidu.tieba.frs.a.bDd().a(null);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.gpb);
        bundle.putString("from", this.mFrom);
        this.gpz.onSaveInstanceState(bundle);
        if (this.gpi != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            this.gpi.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.gpM != null) {
            this.gpM.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.gpj != null) {
            this.gpj.bFe();
            this.gpj.onResume();
        }
        this.gpC.mf(true);
        this.gpv = true;
        if (gpa) {
            gpa = false;
            if (this.gpj != null) {
                this.gpj.startPullRefresh();
                return;
            }
            return;
        }
        if (this.gpi != null) {
            this.gpi.onResume(getPageContext());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_RESUME));
        this.gpj.lz(false);
        if (this.gpV) {
            refresh(6);
            this.gpV = false;
        }
        bEJ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
    }

    public boolean bEo() {
        Intent intent;
        if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
            return false;
        }
        return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
    }

    public void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.gpb = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.gpd = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.gpd) {
                bEp();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEp() {
        this.gpj.startPullRefresh();
    }

    public void closeActivity() {
        com.baidu.tieba.frs.f.i.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.mFrom);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.gpj.setTitle(this.gpb);
        } else {
            this.gpj.setTitle("");
            this.mFlag = 1;
        }
        this.gpj.a(this.gqC);
        this.gpj.addOnScrollListener(this.mScrollListener);
        this.gpj.g(this.gmG);
        this.gpj.bFq().a(this.gqB);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gqc) {
            this.gpj.onChangeSkinType(i);
            this.gpA.up(i);
            this.gpB.onChangeSkinType(i);
            if (this.gpl != null) {
                this.gpl.onChangeSkinType(i);
            }
            if (this.gpS != null) {
                this.gpS.onChangeSkinType();
            }
            if (this.gpY != null) {
                this.gpY.onChangeSkinType(getPageContext(), i);
            }
            if (this.fMK != null) {
                com.baidu.tbadk.q.a.a(getPageContext(), this.fMK.getRealView());
            }
            if (this.gpT != null) {
                this.gpT.onChangeSkinType();
            }
            if (this.gpU != null) {
                this.gpU.onChangeSkinType(getPageContext(), i);
            }
        }
    }

    public void sH(int i) {
        if (!this.mIsLogin) {
            if (this.goJ != null && this.goJ.getAnti() != null) {
                this.goJ.getAnti().setIfpost(1);
            }
            if (i == 0) {
                bc.skipToLoginActivity(getActivity());
            }
        } else if (this.goJ != null) {
            if (i == 0) {
                com.baidu.tieba.frs.f.j.e(this, 0);
            } else {
                this.gpj.bFg();
            }
        }
    }

    public void refresh() {
        com.baidu.tieba.a.d.aXK().wP("page_frs");
        refresh(3);
    }

    public void refresh(int i) {
        this.gps = false;
        bEu();
        if (this.gpj != null && this.gpj.bEV() != null) {
            this.gpj.bEV().bOE();
        }
        if (this.gpz != null) {
            this.gpz.F(i, true);
        }
    }

    private void bEq() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.f.h.gy().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.26
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.Jj(FrsFragment.this.gpb);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEr() {
        bEu();
        try {
            if (this.goJ != null) {
                this.gpj.bgE();
                this.gpj.lr(bEI());
                if (!com.baidu.tieba.frs.vc.h.l(this.goJ) || !com.baidu.tieba.frs.vc.h.k(this.goJ)) {
                }
                if (this.goJ.getForum() != null) {
                    this.gpb = this.goJ.getForum().getName();
                    this.forumId = this.goJ.getForum().getId();
                }
                if (this.goJ.getPage() != null) {
                    setHasMore(this.goJ.getPage().aBn());
                }
                this.gpj.setTitle(this.gpb);
                this.gpj.setForumName(this.gpb);
                TbadkCoreApplication.getInst().setDefaultBubble(this.goJ.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.goJ.getUserData().getBimg_end_time());
                bEq();
                bEs();
                ArrayList<com.baidu.adp.widget.ListView.m> threadList = this.goJ.getThreadList();
                if (threadList != null) {
                    this.gpj.a(threadList, this.goJ);
                    com.baidu.tieba.frs.f.c.y(this.gpj);
                    this.gpA.uq(getPageNum());
                    this.gpA.i(this.goJ);
                    this.gpB.a(this.goJ, this.gpz.bJD());
                    this.gpj.bFh();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void bEs() {
        if (this.goJ != null) {
            if (this.goJ.getIsNewUrl() == 1) {
                this.gpj.bFq().setFromCDN(true);
            } else {
                this.gpj.bFq().setFromCDN(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.gpC.mf(false);
        this.gpv = false;
        this.gpj.onPause();
        if (this.gpi != null) {
            this.gpi.onPause(getPageContext());
        }
        this.gpj.lz(true);
        if (this.gpI != null) {
            this.gpI.bKu();
        }
        com.baidu.tbadk.BdToken.c.axC().axH();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.gpB != null && this.gpB.bLn() != null && (this.gpB.bLn().fragment instanceof BaseFragment)) {
            ((BaseFragment) this.gpB.bLn().fragment).setPrimary(z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.r.bvm().ku(false);
        lk(false);
        if (this.goJ != null && this.goJ.getForum() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            com.baidu.tbadk.distribute.a.aOm().a(getPageContext().getPageActivity(), "frs", this.goJ.getForum().getId(), 0L);
        }
        if (this.gpi != null) {
            this.gpi.onStop(getPageContext());
        }
        if (aIm() != null) {
            aIm().getRecycledViewPool().clear();
        }
        this.gpA.aHG();
        com.baidu.tbadk.util.aa.aSw();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            if (this.gpA != null) {
                this.gpA.onPrimary(isPrimary());
            }
            if (this.gpj != null) {
                this.gpj.onPrimary(isPrimary());
                this.gpj.lz(!isPrimary());
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (com.baidu.tieba.frs.a.bDd().bDe()) {
                com.baidu.tieba.frs.a.bDd().reset();
                return true;
            } else if (this.gpj != null) {
                return this.gpj.bFd();
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
        com.baidu.tbadk.distribute.a.aOm().a(advertAppInfo, this.forumId, 0L, "FRS", str, getPn());
    }

    @Override // com.baidu.tieba.recapp.n
    public void bEt() {
        bDT().bEt();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.gpi == null) {
            this.gpi = VoiceManager.instance();
        }
        return this.gpi;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdRecyclerView aIm() {
        if (this.gpj == null) {
            return null;
        }
        return this.gpj.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void bEu() {
        if (this.gpi != null) {
            this.gpi.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> aIn() {
        if (this.djC == null) {
            this.djC = UserIconBox.x(getPageContext().getPageActivity(), 8);
        }
        return this.djC;
    }

    public void bEv() {
        if (getFragmentActivity() != null && getFragmentActivity().getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.p onGetPreLoadListView() {
        return aIm().getPreLoadHandle();
    }

    @Override // com.baidu.tieba.frs.aj
    public NavigationBar beR() {
        if (this.gpj == null) {
            return null;
        }
        return this.gpj.beR();
    }

    public FRSRefreshButton bEw() {
        return this.gpl;
    }

    public void a(FRSRefreshButton fRSRefreshButton) {
        if (fRSRefreshButton != null) {
            this.gpl = fRSRefreshButton;
            this.gpl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.32
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (FrsFragment.this.gpB != null) {
                        FrsTabViewController.b bLn = FrsFragment.this.gpB.bLn();
                        if (bLn != null && bLn.fragment != null && (bLn.fragment instanceof ai)) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                            ((ai) bLn.fragment).scrollToTop();
                            ((ai) bLn.fragment).bdw();
                            return;
                        }
                        FrsFragment.this.bDY().startPullRefresh();
                    }
                }
            });
        }
    }

    public void bEx() {
        if (this.gpl != null) {
            this.gpl.hide();
        }
    }

    public void bEy() {
        if (this.gpl != null) {
            this.gpl.show();
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
                if (bdUniqueId == r.gsm) {
                    if (FrsFragment.this.gpj != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11752").cx("fid", FrsFragment.this.forumId).cx("obj_locate", "1"));
                        FrsFragment.this.gpj.startPullRefresh();
                    }
                } else if (mVar != null && (mVar instanceof bi)) {
                    bj bjVar = ((bi) mVar).cRt;
                    if (bjVar.aDo() == null || bjVar.aDo().getGroup_id() == 0 || bc.checkUpIsLogin(FrsFragment.this.getActivity())) {
                        if (bjVar.aDb() != 1 || bc.checkUpIsLogin(FrsFragment.this.getActivity())) {
                            if (bjVar.aCE() != null) {
                                if (bc.checkUpIsLogin(FrsFragment.this.getActivity())) {
                                    String postUrl = bjVar.aCE().getPostUrl();
                                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.isNetOk()) {
                                        com.baidu.tbadk.browser.a.startInternalWebActivity(FrsFragment.this.getActivity(), postUrl);
                                    }
                                }
                            } else if (bjVar.aDz() != null) {
                                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                    bc.skipToLoginActivity(FrsFragment.this.getPageContext().getPageActivity());
                                    return;
                                }
                                com.baidu.tbadk.core.data.p aDz = bjVar.aDz();
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), aDz.getCartoonId(), aDz.getChapterId(), 2)));
                            } else {
                                com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                                if (readThreadHistory != null && !readThreadHistory.Jp(bjVar.getId())) {
                                    readThreadHistory.Jo(bjVar.getId());
                                }
                                boolean z = false;
                                final String aCy = bjVar.aCy();
                                if (aCy != null && !aCy.equals("")) {
                                    z = true;
                                    new Thread(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.a.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(aCy);
                                            xVar.aGk().aGL().mIsNeedAddCommenParam = false;
                                            xVar.aGk().aGL().mIsUseCurrentBDUSS = false;
                                            xVar.getNetData();
                                        }
                                    }).start();
                                }
                                String tid = bjVar.getTid();
                                if (tid == null) {
                                    tid = "";
                                }
                                if (bjVar.aCm() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                    ba.aGK().b(FrsFragment.this.getPageContext(), new String[]{tid, "", null});
                                    return;
                                }
                                if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && tid.length() > 4) {
                                    bjVar.setId(tid.substring(3));
                                }
                                if (bdUniqueId.getId() == bj.cTr.getId()) {
                                    com.baidu.tieba.frs.f.h.a(bjVar.aBX());
                                } else if (bdUniqueId.getId() == bj.cRR.getId()) {
                                    com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                                    anVar.cx("obj_type", "2");
                                    anVar.cx("tid", bjVar.getTid());
                                    TiebaStatic.log(anVar);
                                }
                                com.baidu.tieba.frs.f.i.a(FrsFragment.this, bjVar, i, z);
                                com.baidu.tieba.frs.f.h.a(FrsFragment.this, FrsFragment.this.goJ, bjVar);
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
            hideNetRefreshView(this.gpj.bsL());
            showLoadingView(this.gpj.bsL(), true);
            this.gpj.lu(false);
            this.gpz.F(3, true);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData bEz() {
        return this.goJ;
    }

    public boolean bEA() {
        return this.gpj.bEA();
    }

    public void at(Object obj) {
        if (this.gpE != null && this.gpE.gHM != null) {
            this.gpE.gHM.callback(obj);
        }
    }

    public void au(Object obj) {
        if (this.gpE != null && this.gpE.gHN != null) {
            this.gpE.gHN.callback(obj);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        this.gpj.getListView().stopScroll();
        if (!this.gpj.bFm()) {
            if (!com.baidu.adp.lib.util.l.isNetOk()) {
                this.gpj.bdz();
            } else if (this.gpz.bJy() == 1) {
                bcz();
                bck();
            } else if (this.gpz.hasMore()) {
                bck();
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void onFailed(String str) {
        bcz();
        showToast(str);
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void al(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        boolean isEmpty = com.baidu.tbadk.core.util.v.isEmpty(arrayList);
        setHasMore(isEmpty ? 0 : 1);
        bcz();
        if (!isEmpty) {
            if (!this.gpz.bJH() && TbadkCoreApplication.getInst().isRecAppExist() && this.gpz.bJy() == 1) {
                this.goJ.addRecommendAppToThreadList(this, arrayList);
            }
            if (this.gpz != null) {
                com.baidu.tieba.frs.d.a.a(getUniqueId(), arrayList, this.goJ.getForum(), this.gpz.getSortType());
            }
            ArrayList<com.baidu.adp.widget.ListView.m> a2 = this.gpK.a(false, false, arrayList, this.gpf, false);
            if (a2 != null) {
                this.goJ.setThreadList(a2);
                this.gpj.a(a2, this.goJ);
            }
            if (this.gpz != null) {
                com.baidu.tieba.frs.d.c.a(this.goJ, this.gpz.bJD(), 2, getContext());
            }
        }
    }

    private void bcz() {
        if (bDZ() == 1 || this.gpK.cn(this.goJ.getThreadListIds())) {
            if (com.baidu.tbadk.core.util.v.getCount(this.goJ.getThreadList()) > 3) {
                this.gpj.bdx();
            } else {
                this.gpj.bFt();
            }
        } else if (com.baidu.tbadk.core.util.v.isEmpty(this.goJ.getThreadList())) {
            this.gpj.bdz();
        } else {
            this.gpj.bdy();
        }
    }

    @Override // com.baidu.tieba.frs.mc.l
    public void bck() {
        if (this.gpK != null) {
            this.gpK.a(this.gpb, this.forumId, this.goJ);
        }
    }

    public void bEB() {
        if (!com.baidu.tbadk.core.util.ab.requestWriteExternalStorgeAndCameraPermission(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.al.e(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment, com.baidu.k.a.a.InterfaceC0078a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        com.baidu.tieba.frs.f.i.a(this, i, strArr, iArr);
    }

    public void ln(boolean z) {
        if (this.gpF != null) {
            this.gpF.lI(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.gpG.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a nU(int i) {
        return this.gpG.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        this.gpO.b(bVar);
    }

    public boolean bEC() {
        return this.goX;
    }

    @Override // com.baidu.tieba.frs.ag
    public void AJ() {
        if (this.gpj != null) {
            showFloatingView();
            this.gpj.getListView().scrollToPosition(0);
            this.gpj.startPullRefresh();
        }
    }

    public ForumWriteData bED() {
        if (this.goJ == null || this.goJ.getForum() == null) {
            return null;
        }
        ForumData forum = this.goJ.getForum();
        ForumWriteData forumWriteData = new ForumWriteData(forum.getId(), forum.getName(), forum.getPrefixData(), this.goJ.getAnti());
        forumWriteData.avatar = forum.getImage_url();
        forumWriteData.forumLevel = forum.getUser_level();
        forumWriteData.specialForumType = forum.special_forum_type;
        forumWriteData.firstDir = forum.getFirst_class();
        forumWriteData.secondDir = forum.getSecond_class();
        UserData userData = this.goJ.getUserData();
        forumWriteData.privateThread = userData != null ? userData.getPrivateThread() : 0;
        forumWriteData.frsTabInfo = bEE();
        return forumWriteData;
    }

    private FrsTabInfoData bEE() {
        int i;
        if (this.gpz == null || this.goJ == null || this.gpB == null) {
            return null;
        }
        if (this.goJ.getEntelechyTabInfo() == null || com.baidu.tbadk.core.util.v.isEmpty(this.goJ.getEntelechyTabInfo().tab)) {
            return null;
        }
        int byH = this.gpB.byH();
        if (byH == 502) {
            return null;
        }
        int i2 = -1;
        ArrayList arrayList = new ArrayList();
        Iterator<FrsTabInfo> it = this.goJ.getEntelechyTabInfo().tab.iterator();
        while (true) {
            i = i2;
            if (!it.hasNext()) {
                break;
            }
            FrsTabInfo next = it.next();
            if (next != null && next.is_general_tab.intValue() == 1) {
                arrayList.add(new FrsTabItemData(next));
                if (byH == next.tab_id.intValue()) {
                    i2 = byH;
                }
            }
            i2 = i;
        }
        if (com.baidu.tbadk.core.util.v.isEmpty(arrayList)) {
            return null;
        }
        FrsTabInfoData frsTabInfoData = new FrsTabInfoData();
        frsTabInfoData.tabList = arrayList;
        frsTabInfoData.selectedTabId = i;
        return frsTabInfoData;
    }

    @Override // com.baidu.tieba.frs.ag
    public void aHS() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void lo(boolean z) {
        this.gpw = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z) {
        this.gpj.sN(8);
        ((FrsActivity) getActivity()).showLoadingView(view, z);
        ((FrsActivity) getActivity()).g(view, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        this.gpj.sN(0);
        ((FrsActivity) getActivity()).hideLoadingView(view);
        ((FrsActivity) getActivity()).g(view, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        super.showNetRefreshView(view, getResources().getString(R.string.refresh_view_title_text), null, getResources().getString(R.string.refresh_view_button_text), z, getNetRefreshListener());
        this.gpj.sN(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshViewNoClick(View view, String str, boolean z) {
        super.showNetRefreshViewNoClick(view, str, z);
        this.gpj.sN(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        super.hideNetRefreshView(view);
        this.gpj.sN(0);
    }

    public void bEF() {
        FrsTabViewController.b bLn;
        if (this.gpB != null && (bLn = this.gpB.bLn()) != null && bLn.fragment != null && (bLn.fragment instanceof ai)) {
            ((ai) bLn.fragment).scrollToTop();
        }
    }

    public void lp(boolean z) {
        this.goZ = z;
    }

    public void b(OvalActionButton ovalActionButton) {
        this.gpk = ovalActionButton;
    }

    public OvalActionButton bEG() {
        return this.gpk;
    }

    public boolean bEH() {
        return this.goZ;
    }

    public void onShareSuccess(String str) {
        if (TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.util.aq.isEmpty(str)) {
            if (this.gqa == null) {
                this.gqa = new AddExperiencedModel(getTbPageContext());
            }
            this.gqa.et(this.forumId, str);
        }
    }

    public boolean bEI() {
        if (this.gpw && !this.gqd) {
            return (this.gpz != null && this.gpz.bJz() && com.baidu.tieba.frs.a.bDd().bDe()) ? false : true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.f.c
    public boolean videoNeedPreload() {
        if (this.goJ != null) {
            return com.baidu.tbadk.util.af.mV(2) || (com.baidu.tbadk.util.af.aSB() && this.goJ.isFrsVideoAutoPlay);
        }
        return super.videoNeedPreload();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.f.c
    public boolean isCyberVideoUsedThisPage() {
        return com.baidu.tbadk.a.b.rH("cyber_player_test") || com.baidu.tbadk.a.b.rG("cyber_player_test");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEJ() {
        if (!com.baidu.tbadk.core.util.aq.isEmpty(this.forumId)) {
            com.baidu.tbadk.BdToken.c.axC().p(com.baidu.tbadk.BdToken.b.cGY, com.baidu.adp.lib.f.b.toLong(this.forumId, 0L));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        FrsTabViewController.b bLn;
        if (bDW() == null || (bLn = bDW().bLn()) == null || !(bLn.fragment instanceof BaseFragment)) {
            return null;
        }
        if (bLn.fragment instanceof FrsAllThreadFragment) {
            TbPageTag tbPageTag = super.getTbPageTag();
            int i = -1;
            if (this.goJ != null) {
                i = this.goJ.getSortType();
            }
            tbPageTag.sortType = com.baidu.tieba.frs.f.g.un(i);
            tbPageTag.locatePage = "a070";
            if (this.goU.equals(bLn.title)) {
                tbPageTag.locatePage = "a071";
            }
            return tbPageTag;
        } else if (bLn.fragment instanceof FrsFragment) {
            return null;
        } else {
            return ((BaseFragment) bLn.fragment).getTbPageTag();
        }
    }
}
