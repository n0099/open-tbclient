package com.baidu.tieba.frs;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
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
import com.baidu.h.a.a;
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
import com.baidu.tbadk.core.atomData.PostSearchActivityConfig;
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
import com.baidu.tbadk.core.frameworkData.IntentConfig;
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
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsPage.RecmForumInfo;
import tbclient.FrsTabInfo;
import tbclient.WindowToast;
/* loaded from: classes9.dex */
public class FrsFragment extends BaseFragment implements BdListView.e, a.InterfaceC0100a, UserIconBox.b<BdRecyclerView>, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, aj, am, ap, com.baidu.tieba.frs.loadmore.a, com.baidu.tieba.frs.mc.l, com.baidu.tieba.recapp.m {
    public static com.baidu.tieba.tbadkCore.m gYt;
    private com.baidu.adp.lib.d.b<TbImageView> dJv;
    private com.baidu.tbadk.util.y egY;
    private com.baidu.tieba.frs.gametab.b fhh;
    private com.baidu.card.af gYF;
    private FrsModelController gYG;
    private com.baidu.tieba.frs.vc.h gYH;
    private FrsTabViewController gYI;
    private com.baidu.tieba.frs.mc.h gYJ;
    private com.baidu.tieba.frs.smartsort.a gYK;
    private com.baidu.tieba.frs.mc.b gYL;
    private aq gYM;
    private com.baidu.tieba.frs.entelechy.b.b gYO;
    private com.baidu.tieba.frs.vc.a gYP;
    private com.baidu.tieba.frs.mc.d gYQ;
    private com.baidu.tieba.frs.mc.c gYR;
    private com.baidu.tieba.frs.vc.j gYS;
    private com.baidu.tieba.frs.mc.a gYT;
    private com.baidu.tieba.frs.live.a gYU;
    private m gYV;
    public com.baidu.tieba.frs.vc.c gYW;
    private com.baidu.tieba.frs.mc.e gYX;
    private View.OnTouchListener gYY;
    private com.baidu.tieba.frs.view.a gYZ;
    private com.baidu.tieba.frs.entelechy.a gYc;
    private com.baidu.tieba.tbadkCore.data.f gYm;
    private VoiceManager gYp;
    private OvalActionButton gYr;
    private FRSRefreshButton gYs;
    public long gYu;
    private com.baidu.tieba.frs.vc.e gZa;
    private boolean gZb;
    private com.baidu.tieba.NEGFeedBack.a gZc;
    private com.baidu.tieba.ala.a gZd;
    private com.baidu.tieba.frs.brand.buttommenu.a gZe;
    private com.baidu.tieba.frs.sportspage.notification.a gZf;
    private AddExperiencedModel gZg;
    private boolean gZi;
    private int gZr;
    private com.baidu.tbadk.core.dialog.a grr;
    private View mRootView;
    private String mSchemeUrl;
    public static boolean gYh = false;
    public static volatile long gYw = 0;
    public static volatile long gYx = 0;
    public static volatile int mNetError = 0;
    private String gYb = "";
    public boolean gYd = false;
    private boolean gYe = false;
    private boolean gYf = false;
    private boolean gYg = true;
    public String gYi = null;
    public String mFrom = null;
    public int mFlag = 0;
    public boolean gYj = false;
    private boolean gYk = false;
    private String mThreadId = null;
    public String forumId = null;
    private int gXQ = 0;
    private boolean gYl = false;
    private boolean gYn = false;
    private boolean gYo = false;
    private n gYq = null;
    public final bj agz = null;
    private FrsViewData gXO = new FrsViewData();
    public long gAV = -1;
    public long edO = 0;
    public long edE = 0;
    public long createTime = 0;
    public long edF = 0;
    public long edL = 0;
    public long gYv = 0;
    public boolean gYy = false;
    private boolean gYz = false;
    private boolean gYA = false;
    public com.baidu.tbadk.n.b gYB = null;
    private boolean gYC = true;
    private boolean gYD = true;
    private a.C0074a gYE = new a.C0074a(2);
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> gYN = new SparseArray<>();
    private boolean eRW = true;
    private boolean hasInit = false;
    private boolean gZh = false;
    private boolean gZj = false;
    private Date gZk = null;
    private int cCF = 0;
    private int gZl = 0;
    public int mHeadLineDefaultNavTabId = -1;
    private final CustomMessageListener gZm = new CustomMessageListener(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED) { // from class: com.baidu.tieba.frs.FrsFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof bj) {
                    com.baidu.tieba.frs.f.h.a(FrsFragment.this.gYq, FrsFragment.this.gXO, FrsFragment.this.getForumId(), true, (bj) data);
                }
            }
        }
    };
    private CustomMessageListener gZn = new CustomMessageListener(CmdConfigCustom.CMD_CLOSE_GAME_RANK_CARD) { // from class: com.baidu.tieba.frs.FrsFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.gXO != null) {
                FrsFragment.this.gXO.removeGameRankListFromThreadList();
                if (FrsFragment.this.gYq != null) {
                    FrsFragment.this.gYq.aBa();
                }
            }
        }
    };
    private CustomMessageListener adK = new CustomMessageListener(2921401) { // from class: com.baidu.tieba.frs.FrsFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && FrsFragment.this.gYs != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() <= 0 || FrsFragment.this.gYI.bVU() == 0 || FrsFragment.this.gYI.bVR() == null || !(FrsFragment.this.gYI.bVR().fragment instanceof BaseFragment) || !((BaseFragment) FrsFragment.this.gYI.bVR().fragment).isPrimary() || FrsFragment.this.gYq.bQb()) {
                    if (FrsFragment.this.gYI.bVU() != 0) {
                        FrsFragment.this.gYs.hide();
                        return;
                    }
                    return;
                }
                FrsFragment.this.gYs.show();
            }
        }
    };
    private CustomMessageListener gZo = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.FrsFragment.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 1) {
                    FrsFragment.this.bOO();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                }
            }
        }
    };
    private final ao gZp = new ao() { // from class: com.baidu.tieba.frs.FrsFragment.40
        @Override // com.baidu.tieba.frs.ao
        public void a(int i, int i2, av avVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
            FrsFragment.this.bOA();
            if (FrsFragment.this.gYO != null) {
                FrsFragment.this.gYH.nq(FrsFragment.this.gYO.tM(i));
            }
            com.baidu.tieba.tbadkCore.f fVar = new com.baidu.tieba.tbadkCore.f();
            if (avVar != null) {
                fVar.isSuccess = avVar.errCode == 0;
                fVar.errorCode = avVar.errCode;
                fVar.errorMsg = avVar.errMsg;
                if (fVar.isSuccess) {
                    if (com.baidu.tbadk.core.util.v.isEmpty(arrayList)) {
                        FrsFragment.this.gYq.bmq();
                    } else if (avVar.hasMore) {
                        if (com.baidu.tbadk.core.util.v.getCount(FrsFragment.this.gXO.getThreadList()) > 3) {
                            FrsFragment.this.gYq.bmo();
                        } else {
                            FrsFragment.this.gYq.bPU();
                        }
                    } else if (avVar.hcv) {
                        FrsFragment.this.gYq.bmp();
                    } else {
                        FrsFragment.this.gYq.bmq();
                    }
                }
            } else {
                avVar = new av();
                avVar.pn = 1;
                avVar.hasMore = false;
                avVar.hcv = false;
            }
            if (i == 1) {
                FrsFragment.this.gYC = true;
                FrsFragment.this.gZD.a(FrsFragment.this.gYG.getType(), false, fVar);
            } else {
                FrsFragment.this.a(fVar);
                if (FrsFragment.this.gYG.bTw() != null) {
                    FrsFragment.this.gXO = FrsFragment.this.gYG.bTw();
                }
                FrsFragment.this.bOQ();
            }
            if (FrsFragment.this.gZL != null) {
                FrsFragment.this.gZL.a(i, i2, avVar, arrayList);
            }
        }
    };
    private FrsTabViewController.a gZq = new FrsTabViewController.a() { // from class: com.baidu.tieba.frs.FrsFragment.41
        @Override // com.baidu.tieba.frs.vc.FrsTabViewController.a
        public void mN(int i) {
            boolean z = false;
            if (i != 1) {
                com.baidu.tieba.card.r.bEY().lx(false);
                FrsFragment.this.mo(false);
            }
            if (i == 502) {
                FrsFragment.this.gYr.setIconFade(R.drawable.btn_frs_professional_edit_n);
            } else {
                FrsFragment.this.gYr.setIconFade(0);
            }
            FrsFragment.this.gZr = i;
            FrsFragment.this.bOT();
            com.baidu.tieba.frs.d.d.hgG.htX = i;
            com.baidu.tieba.frs.d.d.hgG.htY = -1;
            com.baidu.tieba.frs.a bND = com.baidu.tieba.frs.a.bND();
            if (i == 1 && FrsFragment.this.gZh) {
                z = true;
            }
            bND.I(z, true);
        }
    };
    private CustomMessageListener gZs = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIVE_COUNT) { // from class: com.baidu.tieba.frs.FrsFragment.42
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                FrsFragment.this.gYI.uX(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    };
    private CustomMessageListener gZt = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_LIVE_START) { // from class: com.baidu.tieba.frs.FrsFragment.43
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && ((Integer) customResponsedMessage.getData()).intValue() == 51 && FrsFragment.this.gXO != null) {
                com.baidu.tieba.frs.f.j.a(FrsFragment.this.gXO, FrsFragment.this.getPageContext());
            }
        }
    };
    private final CustomMessageListener gZu = new CustomMessageListener(CmdConfigCustom.CMD_FRS_SELECT_ALA_LIVE_TAB) { // from class: com.baidu.tieba.frs.FrsFragment.44
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                FrsFragment.this.gYI.uV(49);
            }
        }
    };
    private final CustomMessageListener gZv = new CustomMessageListener(CmdConfigCustom.CMD_FRS_EXPERIENCE_TIP) { // from class: com.baidu.tieba.frs.FrsFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.u) && FrsFragment.this.gXO != null) {
                FrsFragment.this.gXO.updateLikeData((com.baidu.tieba.tbadkCore.u) customResponsedMessage.getData());
                FrsFragment.this.gYH.i(FrsFragment.this.gXO);
                FrsFragment.this.gYI.a(FrsFragment.this.gXO, FrsFragment.this.gYG.bUa());
            }
        }
    };
    private final AntiHelper.a gZw = new AntiHelper.a() { // from class: com.baidu.tieba.frs.FrsFragment.3
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).af("obj_locate", at.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).af("obj_locate", at.a.LOCATE_LIKE_PERSON));
        }
    };
    private CustomMessageListener gZx = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.FrsFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(FrsFragment.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().dOo != null) {
                        if (AntiHelper.a(FrsFragment.this.getActivity(), updateAttentionMessage.getData().dOo, FrsFragment.this.gZw) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).af("obj_locate", at.a.LOCATE_LIKE_PERSON));
                        }
                    } else if (updateAttentionMessage.getData().isSucc && updateAttentionMessage.getData().isAttention) {
                        com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getPageContext().getPageActivity(), (int) R.string.attention_success);
                    }
                }
            }
        }
    };
    private CustomMessageListener gZy = new CustomMessageListener(CmdConfigCustom.CMD_GET_ENSURE_CAST_ID) { // from class: com.baidu.tieba.frs.FrsFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsFragment.this.refresh();
        }
    };
    private CustomMessageListener gZz = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.frs.FrsFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && !((PostWriteCallBackData) customResponsedMessage.getData()).isDyamicCallback()) {
                FrsFragment.this.gYq.c((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener gZA = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_REMIND) { // from class: com.baidu.tieba.frs.FrsFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewsRemindMessage newsRemindMessage;
            if (customResponsedMessage != null && (customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626 && (newsRemindMessage = (NewsRemindMessage) customResponsedMessage) != null) {
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (FrsFragment.this.gYq != null) {
                    FrsFragment.this.gYq.G(notificationCount, z);
                }
            }
        }
    };
    private final CustomMessageListener gZB = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.frs.FrsFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.isResumed()) {
                FrsFragment.this.bPi();
            }
        }
    };
    private CustomMessageListener gZC = new CustomMessageListener(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER) { // from class: com.baidu.tieba.frs.FrsFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (FrsFragment.this.gYq != null) {
                    FrsFragment.this.gYq.setExpanded(booleanValue);
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.q gZD = new com.baidu.tieba.tbadkCore.q() { // from class: com.baidu.tieba.frs.FrsFragment.10
        private long startTime = 0;

        @Override // com.baidu.tieba.tbadkCore.q
        public void tf(int i) {
            this.startTime = System.nanoTime();
            if (FrsFragment.this.gYq != null) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsFragment.this.gYq.bPE();
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
            if (FrsFragment.this.eRW) {
                FrsFragment.this.eRW = false;
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.gYq, FrsFragment.this.gXO, FrsFragment.this.getForumId(), false, null);
            }
            FrsFragment.this.bOA();
            FrsFragment.this.gYz = true;
            if (fVar != null && fVar.isSuccess) {
                FrsFragment.this.gYq.bPR().mX(com.baidu.tbadk.core.util.ar.aOV().aOW());
                FrsFragment.gYw = 0L;
                FrsFragment.gYx = 0L;
                FrsFragment.mNetError = 0;
            } else {
                FrsFragment.mNetError = 1;
            }
            if (!FrsFragment.this.gYG.bUe() && (i == 3 || i == 6)) {
                FrsFragment.this.gYR.resetData();
            }
            FrsFragment.this.gYu = System.currentTimeMillis();
            if (FrsFragment.this.gYG.bTw() != null) {
                FrsFragment.this.gXO = FrsFragment.this.gYG.bTw();
            }
            FrsFragment.this.gYq.b(FrsFragment.this.gXO.getRedpacketRainData());
            FrsFragment.this.tb(1);
            if (i == 7) {
                FrsFragment.this.tc(FrsFragment.this.gXO.getFrsDefaultTabId());
                return;
            }
            if (FrsFragment.this.gXO.getPage() != null) {
                FrsFragment.this.setHasMore(FrsFragment.this.gXO.getPage().aJA());
            }
            if (i == 4) {
                if (!FrsFragment.this.gYG.bUe() && TbadkCoreApplication.getInst().isRecAppExist() && FrsFragment.this.gYG.bTV() == 1) {
                    FrsFragment.this.gXO.addRecommendAppToThreadList(FrsFragment.this);
                }
                ArrayList<com.baidu.adp.widget.ListView.m> a2 = FrsFragment.this.gYR.a(false, false, FrsFragment.this.gXO.getThreadList(), FrsFragment.this.gYm, false);
                if (a2 != null) {
                    FrsFragment.this.gXO.setThreadList(a2);
                    FrsFragment.this.gXO.checkLiveStageInThreadList();
                }
                if (FrsFragment.this.gYG != null) {
                    com.baidu.tieba.frs.d.c.a(FrsFragment.this.gXO, FrsFragment.this.gYG.bUa(), 2, FrsFragment.this.getContext());
                }
                com.baidu.tieba.frs.f.a.a(FrsFragment.this, FrsFragment.this.gXO.getForum(), FrsFragment.this.gXO.getThreadList(), false, FrsFragment.this.getPn());
                FrsFragment.this.gYq.a(a2, FrsFragment.this.gXO);
                FrsFragment.this.bOB();
                return;
            }
            FrsFragment.this.bOB();
            switch (i) {
                case 1:
                    FrsFragment.this.gYq.bPE();
                    break;
                case 2:
                    FrsFragment.this.gYq.bPE();
                    break;
                case 3:
                case 6:
                    if (FrsFragment.this.gXO != null) {
                        FrsFragment.this.gXO.clearPostThreadCount();
                    }
                    if (FrsFragment.this.gYW != null) {
                        FrsFragment.this.gYW.refresh();
                        break;
                    }
                    break;
            }
            FrsFragment.this.bOJ();
            if (fVar == null || fVar.errorCode == 0) {
                if (FrsFragment.this.gXO != null) {
                    if (!FrsFragment.this.a(FrsFragment.this.gXO)) {
                        FrsFragment.this.bOI();
                    }
                    FrsFragment.this.L(false, i == 5);
                    if (FrsFragment.this.gYG != null) {
                        if (FrsFragment.this.gXO.getActivityHeadData() != null && FrsFragment.this.gXO.getActivityHeadData().aIN() != null && FrsFragment.this.gXO.getActivityHeadData().aIN().size() > 0) {
                            com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), 1, FrsFragment.this.gXO.getForum(), FrsFragment.this.gYG.getSortType(), 1);
                        }
                        if (FrsFragment.this.gXO.getThreadList() != null && FrsFragment.this.gXO.getThreadList().size() > 0) {
                            Iterator<com.baidu.adp.widget.ListView.m> it = FrsFragment.this.gXO.getThreadList().iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    com.baidu.adp.widget.ListView.m next = it.next();
                                    if ((next instanceof bj) && ((bj) next).getType() == bj.dsB) {
                                        com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), 1, FrsFragment.this.gXO.getForum(), FrsFragment.this.gYG.getSortType(), 2);
                                    }
                                }
                            }
                        }
                        com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), FrsFragment.this.gXO.getThreadList(), FrsFragment.this.gXO.getForum(), FrsFragment.this.gYG.getSortType());
                    }
                    FrsFragment.this.gYq.tp(i);
                    FrsFragment.gYw = (System.nanoTime() - this.startTime) / TimeUtils.NANOS_PER_MS;
                    if (fVar != null) {
                        FrsFragment.gYx = fVar.kQc;
                    }
                } else {
                    return;
                }
            } else if (FrsFragment.this.gXO == null || com.baidu.tbadk.core.util.v.isEmpty(FrsFragment.this.gXO.getThreadList())) {
                FrsFragment.this.a(fVar);
            } else if (fVar.gIu) {
                FrsFragment.this.showToast(FrsFragment.this.getPageContext().getResources().getString(R.string.net_error_text, fVar.errorMsg, Integer.valueOf(fVar.errorCode)));
            }
            FrsFragment.this.bOF();
            FrsFragment.this.bOG();
            if (FrsFragment.this.gXO.getAccessFlag() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11384"));
            }
            if (FrsFragment.this.gYn && FrsFragment.this.gYI.uV(49)) {
                FrsFragment.this.gYn = false;
            }
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.q
        public void c(com.baidu.tieba.tbadkCore.m mVar) {
            if ((mVar != null && ("normal_page".equals(FrsFragment.this.gYG.getPageType()) || "frs_page".equals(FrsFragment.this.gYG.getPageType()) || "book_page".equals(FrsFragment.this.gYG.getPageType()))) || "brand_page".equals(FrsFragment.this.gYG.getPageType())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE, mVar));
                FrsFragment.this.b(mVar);
                FrsFragment.gYt = mVar;
            }
        }
    };
    private final CustomMessageListener gZE = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.frs.FrsFragment.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.k) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                FrsFragment.this.gXO.updateCurrentUserPendant((com.baidu.tbadk.data.k) customResponsedMessage.getData());
                FrsFragment.this.gYq.bPR().notifyDataSetChanged();
            }
        }
    };
    private final CustomMessageListener mMemListener = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_MEM) { // from class: com.baidu.tieba.frs.FrsFragment.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && FrsFragment.this.gXO != null && (userData = FrsFragment.this.gXO.getUserData()) != null) {
                userData.setIsMem(num.intValue());
                if (num.intValue() != 0) {
                    FrsFragment.this.gYH.k(num);
                }
            }
        }
    };
    private final f.a gZF = new f.a() { // from class: com.baidu.tieba.frs.FrsFragment.21
        @Override // com.baidu.tbadk.BdToken.f.a
        public void B(HashMap<String, Object> hashMap) {
            if (hashMap != null && (hashMap.get(com.baidu.tbadk.BdToken.f.dhv) instanceof String)) {
                FrsFragment.this.gYi = (String) hashMap.get(com.baidu.tbadk.BdToken.f.dhv);
            }
        }
    };
    private final com.baidu.tieba.frs.mc.k gZG = new com.baidu.tieba.frs.mc.k() { // from class: com.baidu.tieba.frs.FrsFragment.22
        @Override // com.baidu.tieba.frs.mc.k
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.m> arrayList, boolean z3) {
            if (FrsFragment.this.gYK != null && FrsFragment.this.gYG != null && FrsFragment.this.gYG.bUe() && z && !z2 && !z3) {
                FrsFragment.this.gYK.uu(i2);
            }
        }
    };
    public final View.OnTouchListener dRW = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.FrsFragment.24
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (FrsFragment.this.gYY != null) {
                FrsFragment.this.gYY.onTouch(view, motionEvent);
            }
            if (FrsFragment.this.gYM != null && FrsFragment.this.gYM.bQz() != null) {
                FrsFragment.this.gYM.bQz().onTouchEvent(motionEvent);
            }
            if (FrsFragment.this.fhh != null) {
                FrsFragment.this.fhh.c(view, motionEvent);
            }
            if (FrsFragment.this.gYH != null) {
                FrsFragment.this.gYH.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private final CustomMessageListener gZH = new CustomMessageListener(CmdConfigCustom.CMD_GOTOLIVE_HOST_UPGRADE) { // from class: com.baidu.tieba.frs.FrsFragment.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.aNV().getInt(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.PHOTOLIVE_HOSTLEVEL, -1) != -1 && FrsFragment.this.gXO.getForum() != null) {
                FrsFragment.this.gXO.getForum().setCanAddPhotoLivePost(true);
            }
        }
    };
    public final View.OnClickListener gZI = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.27
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsFragment.this.gYq != null && view == FrsFragment.this.gYq.bPC() && FrsFragment.this.getActivity() != null) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, FrsFragment.this.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            if (view.getId() == R.id.game_activity_egg_layout && com.baidu.adp.lib.util.l.isNetOk()) {
                TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_CLICK);
                if (FrsFragment.this.gYq == null || !FrsFragment.this.gYq.bPO()) {
                    String activityUrl = FrsFragment.this.gXO.getForum().getYuleData().aMQ().getActivityUrl();
                    if (!StringUtils.isNull(activityUrl)) {
                        com.baidu.tbadk.browser.a.startInternalWebActivity(FrsFragment.this.getPageContext().getPageActivity(), activityUrl);
                    }
                } else {
                    FrsFragment.this.gYq.bPP();
                }
            }
            if (FrsFragment.this.gYq != null && view == FrsFragment.this.gYq.bPV() && FrsFragment.this.gYG != null && FrsFragment.this.gYG.hasMore()) {
                FrsFragment.this.gYq.bmo();
                FrsFragment.this.blb();
            }
            if (view != null && FrsFragment.this.gYq != null && view == FrsFragment.this.gYq.bPL()) {
                if (bc.checkUpIsLogin(FrsFragment.this.getContext())) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).af("obj_locate", 2));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MessageCenterActivityConfig(FrsFragment.this.getContext())));
                } else {
                    return;
                }
            }
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (FrsFragment.this.gXO != null && FrsFragment.this.gXO.getForum() != null) {
                    if (FrsFragment.this.gYq != null && view == FrsFragment.this.gYq.bPJ()) {
                        if (FrsFragment.this.gXO != null && FrsFragment.this.gXO.getForum() != null && !StringUtils.isNull(FrsFragment.this.gXO.getForum().getId()) && !StringUtils.isNull(FrsFragment.this.gXO.getForum().getName())) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_SHARE_CLICK).cI("fid", FrsFragment.this.gXO.getForum().getId()).af("obj_locate", 11));
                            com.baidu.tieba.frs.f.e.a(FrsFragment.this.getPageContext(), FrsFragment.this.gXO, FrsFragment.this.gXO.getForum().getId());
                        } else {
                            return;
                        }
                    }
                    if (FrsFragment.this.gYq != null && view == FrsFragment.this.gYq.bPI()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12402").cI("fid", FrsFragment.this.gXO.getForum().getId()).cI("uid", TbadkCoreApplication.getCurrentAccount()).cI("fname", FrsFragment.this.gXO.getForum().getName()));
                        if (!StringUtils.isNull(FrsFragment.this.gXO.getForum().getName())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PostSearchActivityConfig(FrsFragment.this.getContext(), FrsFragment.this.gXO.getForum().getName(), FrsFragment.this.gXO.getForum().getId())));
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getContext().getApplicationContext(), (int) R.string.network_not_available);
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.FrsFragment.28
        private int gZW = 0;
        private int eNU = 0;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsFragment.this.gZl += i2;
            if (FrsFragment.this.gZl >= FrsFragment.this.cCF * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
            if (FrsFragment.this.gYP != null) {
                FrsFragment.this.gYP.bUR();
            }
            this.gZW = 0;
            this.eNU = 0;
            if (recyclerView != null && (recyclerView instanceof BdRecyclerView)) {
                this.gZW = ((BdRecyclerView) recyclerView).getFirstVisiblePosition();
                this.eNU = ((BdRecyclerView) recyclerView).getLastVisiblePosition();
            }
            if (FrsFragment.this.gZa != null) {
                FrsFragment.this.gZa.a(recyclerView, this.gZW, this.eNU);
            }
            if (FrsFragment.this.gXO != null && FrsFragment.this.gYq != null && FrsFragment.this.gYq.bPR() != null) {
                FrsFragment.this.gYq.bL(this.gZW, this.eNU);
                if (FrsFragment.this.gYF != null && FrsFragment.this.gYF.rD() != null) {
                    FrsFragment.this.gYF.rD().b(FrsFragment.this.gYE);
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (FrsFragment.this.gYH != null) {
                FrsFragment.this.gYH.setScrollState(i);
            }
            if ((i == 2 || i == 1) && !FrsFragment.this.gYA) {
                FrsFragment.this.gYA = true;
                FrsFragment.this.gYq.bPT();
            }
            if (FrsFragment.this.gYB == null && !FrsFragment.this.bPb()) {
                FrsFragment.this.gYB = new com.baidu.tbadk.n.b();
                FrsFragment.this.gYB.setSubType(1000);
            }
            if (i == 0) {
                if (FrsFragment.this.gYB != null) {
                    FrsFragment.this.gYB.aZr();
                }
                com.baidu.tieba.card.r.bEY().lx(true);
                FrsFragment.this.mo(true);
                FrsFragment.this.gYq.bK(this.gZW, this.eNU);
            } else if (FrsFragment.this.gYB != null) {
                FrsFragment.this.gYB.aZq();
            }
            if (FrsFragment.this.gZa != null) {
                FrsFragment.this.gZa.onScrollStateChanged(recyclerView, i);
            }
            if (i == 0) {
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.gYq, FrsFragment.this.gXO, FrsFragment.this.getForumId(), false, null);
            }
            if (FrsFragment.this.gYI != null && i == 1) {
                FrsFragment.this.gYI.bVT();
            }
            if (FrsFragment.this.gYF == null) {
                if (FrsFragment.this.gYq.bPv() != null && !FrsFragment.this.gYq.bOZ() && FrsFragment.this.gYq.bPv().cJH() != null && (FrsFragment.this.gYq.bPv().cJH().getTag() instanceof com.baidu.card.af)) {
                    FrsFragment.this.gYF = (com.baidu.card.af) FrsFragment.this.gYq.bPv().cJH().getTag();
                }
            } else if (i == 0 && FrsFragment.this.gYq.bPv() != null && !FrsFragment.this.gYq.bOZ() && FrsFragment.this.gYq.bPv().cJH() != null && (FrsFragment.this.gYq.bPv().cJH().getTag() instanceof com.baidu.card.af)) {
                FrsFragment.this.gYF = (com.baidu.card.af) FrsFragment.this.gYq.bPv().cJH().getTag();
            }
            if (i == 1) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921418));
            }
        }
    };
    private final d gZJ = new d() { // from class: com.baidu.tieba.frs.FrsFragment.29
        @Override // com.baidu.tieba.frs.d
        public void a(int i, int i2, View view, View view2, bj bjVar) {
            if (i != FrsFragment.this.gYq.bPR().bRU()) {
                if (i != FrsFragment.this.gYq.bPR().bRV()) {
                    if (i == FrsFragment.this.gYq.bPR().bRS() && FrsFragment.this.gXO != null && FrsFragment.this.gXO.getUserData() != null && FrsFragment.this.gXO.getUserData().isBawu()) {
                        String bawuCenterUrl = FrsFragment.this.gXO.getBawuCenterUrl();
                        if (!com.baidu.tbadk.core.util.aq.isEmpty(bawuCenterUrl) && FrsFragment.this.gXO.getForum() != null) {
                            com.baidu.tbadk.browser.a.startWebActivity(FrsFragment.this.getPageContext().getPageActivity(), bawuCenterUrl);
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10502").cI("fid", FrsFragment.this.gXO.getForum().getId()).cI("uid", FrsFragment.this.gXO.getUserData().getUserId()));
                        }
                    }
                } else if (bc.checkUpIsLogin(FrsFragment.this.getPageContext().getPageActivity())) {
                    TiebaStatic.log(CommonStatisticKey.MY_SERVICE_CK);
                    if (FrsFragment.this.gXO != null && FrsFragment.this.gXO.getForum() != null) {
                        ForumData forum = FrsFragment.this.gXO.getForum();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(forum.getId(), 0L), forum.getName(), forum.getImage_url(), 0)));
                    }
                }
            } else if (bc.checkUpIsLogin(FrsFragment.this.getActivity())) {
                TiebaStatic.log("forum_fortune_click");
                com.baidu.tieba.frs.f.i.b(FrsFragment.this.getPageContext(), FrsFragment.this.gXO);
            }
        }
    };
    private final NoNetworkView.a gVM = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.FrsFragment.30
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (FrsFragment.this.gYG.bTV() == 1 && z && !FrsFragment.this.gYq.bOZ()) {
                if (FrsFragment.this.gXO == null || com.baidu.tbadk.core.util.v.isEmpty(FrsFragment.this.gXO.getThreadList())) {
                    FrsFragment.this.hideNetRefreshView(FrsFragment.this.gYq.bCt());
                    FrsFragment.this.showLoadingView(FrsFragment.this.gYq.bCt(), true);
                    FrsFragment.this.gYq.my(false);
                    FrsFragment.this.refresh();
                    return;
                }
                FrsFragment.this.gYq.bPE();
            }
        }
    };
    private final CustomMessageListener dOK = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.FrsFragment.31
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                com.baidu.tieba.frs.f.c.a(customResponsedMessage, FrsFragment.this.gYq, FrsFragment.this.gXO);
            }
        }
    };
    private com.baidu.adp.widget.ListView.v gZK = new a();
    private ao gZL = new ao() { // from class: com.baidu.tieba.frs.FrsFragment.33
        @Override // com.baidu.tieba.frs.ao
        public void a(int i, int i2, av avVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
            com.baidu.adp.lib.f.e.lb().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.33.1
                @Override // java.lang.Runnable
                public void run() {
                    if (FrsFragment.this.gYq != null && FrsFragment.this.gYq.bPW()) {
                        FrsFragment.this.blb();
                    }
                }
            });
        }
    };
    private CustomMessageListener gZM = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.frs.FrsFragment.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    FrsFragment.this.gZb = true;
                }
            }
        }
    };
    private CustomMessageListener gZN = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.frs.FrsFragment.36
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                    if (FrsFragment.this.gYF == null && FrsFragment.this.gYq.bPv() != null && !FrsFragment.this.gYq.bOZ() && FrsFragment.this.gYq.bPv().cJH() != null && (FrsFragment.this.gYq.bPv().cJH().getTag() instanceof com.baidu.card.af)) {
                        FrsFragment.this.gYF = (com.baidu.card.af) FrsFragment.this.gYq.bPv().cJH().getTag();
                    }
                    if (FrsFragment.this.gYF != null && FrsFragment.this.gYF.rD() != null) {
                        FrsFragment.this.gYF.rD().b(new a.C0074a(3));
                    }
                }
            }
        }
    };
    private CustomMessageListener gZO = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.FrsFragment.37
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.gYq != null) {
                FrsFragment.this.gYq.wK();
            }
        }
    };
    private CustomMessageListener gZP = new CustomMessageListener(2921437) { // from class: com.baidu.tieba.frs.FrsFragment.38
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && FrsFragment.this.isResumed()) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (FrsFragment.this.gYs != null) {
                    if (booleanValue) {
                        if (FrsFragment.this.gYI.bVU() != 0 && !FrsFragment.this.gYq.bQb()) {
                            FrsFragment.this.gYs.show();
                            return;
                        }
                        return;
                    }
                    FrsFragment.this.gYs.hide();
                }
            }
        }
    };
    private CustomMessageListener gZQ = new CustomMessageListener(2001223) { // from class: com.baidu.tieba.frs.FrsFragment.39
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Date)) {
                FrsFragment.this.gZk = (Date) customResponsedMessage.getData();
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.frs.loadmore.a
    public /* bridge */ /* synthetic */ com.baidu.adp.base.e getPageContext() {
        return super.getPageContext();
    }

    public com.baidu.tieba.frs.entelechy.b.b bOo() {
        return this.gYO;
    }

    public com.baidu.adp.widget.ListView.v bOp() {
        return this.gZK;
    }

    public com.baidu.tieba.frs.mc.d bOq() {
        return this.gYQ;
    }

    public com.baidu.tieba.frs.smartsort.a bOr() {
        return this.gYK;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public FrsModelController bOs() {
        return this.gYG;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public com.baidu.tieba.frs.mc.c bOt() {
        return this.gYR;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public com.baidu.tieba.frs.vc.h bOu() {
        return this.gYH;
    }

    public FrsTabViewController bOv() {
        return this.gYI;
    }

    public aq bOw() {
        return this.gYM;
    }

    public void mn(boolean z) {
        this.gZj = z;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public n bOx() {
        return this.gYq;
    }

    @Override // com.baidu.tieba.frs.ap
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.ap, com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.gYi;
    }

    public void setForumName(String str) {
        this.gYi = str;
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

    @Override // com.baidu.tieba.recapp.m
    public String getFid() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.recapp.m
    public int getPageNum() {
        if (this.gYR == null) {
            return 1;
        }
        return this.gYR.getPn();
    }

    public int getPn() {
        if (this.gYR == null) {
            return 1;
        }
        return this.gYR.getPn();
    }

    public void setPn(int i) {
        if (this.gYR != null) {
            this.gYR.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.gYR != null) {
            this.gYR.setHasMore(i);
        }
    }

    public int bOy() {
        if (this.gYR == null) {
            return -1;
        }
        return this.gYR.bOy();
    }

    public boolean bOz() {
        return this.gYo;
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
            this.gYq.bPy();
            showNetRefreshView(this.gYq.bCt(), string, true);
        } else if (340001 == fVar.errorCode) {
            a(fVar, this.gXO.getRecm_forum_list());
        } else {
            if (com.baidu.tbadk.core.util.v.isEmpty(this.gXO.getThreadList())) {
                b(fVar);
            }
            if (bPb()) {
                setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds280));
            } else {
                setNetRefreshViewEmotionDefMarginTop();
            }
        }
    }

    public void a(View view, String str, boolean z, List<RecmForumInfo> list) {
        this.gYq.bPy();
        this.gYq.tl(8);
        if (this.gYZ == null) {
            this.gYZ = new com.baidu.tieba.frs.view.a(getPageContext(), getNetRefreshListener());
        }
        this.gYZ.setSubText(str);
        this.gYZ.cE(list);
        this.gYZ.attachView(view, z);
    }

    private void a(com.baidu.tieba.tbadkCore.f fVar, List<RecmForumInfo> list) {
        if (this.gYq != null) {
            this.gYq.bPy();
            this.gYq.setTitle(this.gYi);
            a(this.gYq.bCt(), fVar.errorMsg, true, list);
        }
    }

    private void b(com.baidu.tieba.tbadkCore.f fVar) {
        this.gYq.bPy();
        if (fVar.gIu) {
            showNetRefreshView(this.gYq.bCt(), TbadkCoreApplication.getInst().getString(R.string.net_error_text, new Object[]{fVar.errorMsg, Integer.valueOf(fVar.errorCode)}), true);
        } else {
            showNetRefreshView(this.gYq.bCt(), fVar.errorMsg, true);
        }
    }

    public void bOA() {
        hideLoadingView(this.gYq.bCt());
        this.gYq.blz();
        if (this.gYq.bPw() instanceof com.baidu.tieba.frs.tab.c) {
            ((com.baidu.tieba.frs.tab.c) this.gYq.bPw()).bUy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOB() {
        if (bOy() == 0 && com.baidu.tbadk.core.util.v.isEmpty(this.gXO.getThreadListIds())) {
            if (com.baidu.tbadk.core.util.v.isEmpty(this.gXO.getThreadList())) {
                this.gYq.bmq();
            } else {
                this.gYq.bmp();
            }
        } else if (com.baidu.tbadk.core.util.v.getCount(this.gXO.getThreadList()) > 3) {
            this.gYq.bmo();
        } else {
            this.gYq.bPU();
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
            bOA();
            this.gYq.bPE();
            com.baidu.tieba.tbadkCore.f bTR = this.gYG.bTR();
            boolean isEmpty = com.baidu.tbadk.core.util.v.isEmpty(this.gXO.getThreadList());
            if (bTR != null && isEmpty) {
                if (this.gYG.bTT() != 0) {
                    this.gYG.bTY();
                    this.gYq.bPE();
                } else {
                    a(bTR);
                }
                this.gYq.M(this.gXO.isStarForum(), false);
                return;
            }
            a(bTR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(com.baidu.tieba.tbadkCore.m mVar) {
        if (mVar != null && mVar.getEntelechyTabInfo() != null && mVar.getEntelechyTabInfo().tab != null) {
            for (FrsTabInfo frsTabInfo : mVar.getEntelechyTabInfo().tab) {
                if (frsTabInfo.tab_id.intValue() == 502 && com.baidu.tbadk.core.sharedPref.b.aNV().getBoolean("first_into_tab_profession", true)) {
                    return false;
                }
            }
        }
        return new com.baidu.tieba.frs.ad.f(getTbPageContext()).d(mVar);
    }

    public boolean bOC() {
        return bOD() && !bOE();
    }

    private boolean bOD() {
        if (bOY() == null) {
            return false;
        }
        FrsViewData bOY = bOY();
        com.baidu.tbadk.core.data.t tVar = null;
        if (bOY.getStar() != null && !StringUtils.isNull(bOY.getStar().cVG())) {
            tVar = new com.baidu.tbadk.core.data.t();
        } else if (bOY.getActivityHeadData() != null && com.baidu.tbadk.core.util.v.getCount(bOY.getActivityHeadData().aIN()) >= 1) {
            tVar = bOY.getActivityHeadData().aIN().get(0);
        }
        return tVar != null;
    }

    public boolean bOE() {
        if (bOY() == null) {
            return false;
        }
        FrsViewData bOY = bOY();
        return (com.baidu.tbadk.core.util.v.isEmpty(bOY.getShowTopThreadList()) && bOY.getBusinessPromot() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOF() {
        boolean b;
        if (!bOH()) {
            final PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
            privateForumPopInfoData.a(this.gXO.getPrivateForumTotalInfo().getPrivatePopInfo());
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(getActivity());
            if (this.gXO.getPrivateForumTotalInfo().aJH().private_forum_status.intValue() == 1 && (com.baidu.tbadk.core.util.aq.isEmpty(privateForumPopInfoData.aJJ()) || privateForumPopInfoData.aJM() != Integer.valueOf(this.forumId))) {
                privateForumPopInfoData.tL("create_success");
                privateForumPopInfoData.tM(TbadkCoreApplication.getInst().getString(R.string.frs_private_create_hint));
                privateForumPopInfoData.tN("https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.gYi + "&nomenu=1");
                privateForumPopInfoData.g(Integer.valueOf(this.forumId));
                b = frsPrivateCommonDialogView.b(privateForumPopInfoData);
            } else {
                b = privateForumPopInfoData.aJM() == Integer.valueOf(this.forumId) ? frsPrivateCommonDialogView.b(privateForumPopInfoData) : false;
            }
            if (b) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
                aVar.kg(2);
                aVar.aP(frsPrivateCommonDialogView);
                aVar.gF(false);
                frsPrivateCommonDialogView.setConfirmButton(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.11
                    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.frs.FrsFragment */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ba.aOY().b(FrsFragment.this.getPageContext(), new String[]{privateForumPopInfoData.aJL()});
                        aVar.dismiss();
                    }
                });
                aVar.a(new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.13
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(getPageContext()).aMU();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOG() {
        if (bOH() || this.gXO.getPrivateForumTotalInfo().aJH().private_forum_status.intValue() != 1) {
            a((Integer) null, (Integer) null, true);
        } else {
            a(this.gXO.getPrivateForumTotalInfo().aJH().private_forum_audit_status, this.gXO.getPrivateForumTotalInfo().aJI(), false);
        }
    }

    public void a(Integer num, Integer num2, boolean z) {
        final String str;
        final int i = 2;
        if (this.gYq.bPK() != null) {
            TextView bPK = this.gYq.bPK();
            if (z) {
                bPK.setVisibility(8);
                return;
            }
            if (num.intValue() == 2) {
                bPK.setText("修改实名认证信息");
                bPK.setVisibility(0);
                str = "https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + this.forumId + "&nomenu=1";
            } else if (num2.intValue() >= 0 && num2.intValue() <= 100) {
                bPK.setText("目标已完成" + String.valueOf(num2) + "%");
                bPK.setVisibility(0);
                str = "https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.gYi + "&nomenu=1";
                i = 1;
            } else {
                bPK.setVisibility(8);
                i = 0;
                str = "";
            }
            bPK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.14
                /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13387").cI("fid", FrsFragment.this.forumId).cI("uid", TbadkCoreApplication.getCurrentAccount()).af("obj_type", i));
                    ba.aOY().b(FrsFragment.this.getPageContext(), new String[]{str});
                }
            });
        }
    }

    private boolean bOH() {
        return this.gXO == null || this.gXO.getPrivateForumTotalInfo() == null || this.gXO.getPrivateForumTotalInfo().aJH() == null || this.gXO.getUserData().getIs_manager() != 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOI() {
        boolean z;
        boolean z2;
        if (this.gXO == null || this.gXO.getEntelechyTabInfo() == null || this.gXO.getEntelechyTabInfo().tab == null) {
            z = false;
        } else {
            z = false;
            for (FrsTabInfo frsTabInfo : this.gXO.getEntelechyTabInfo().tab) {
                if (frsTabInfo.tab_id.intValue() == 502) {
                    if (com.baidu.tbadk.core.sharedPref.b.aNV().getBoolean("first_into_tab_profession", true)) {
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
        if (z && com.baidu.tbadk.core.sharedPref.b.aNV().getBoolean("first_into_tab_general", true)) {
            j.a(getActivity(), getPageContext());
            com.baidu.tbadk.core.sharedPref.b.aNV().putBoolean("first_into_tab_general", false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tb(int i) {
        List<WindowToast> list;
        if (TbadkCoreApplication.isLogin() && this.gXO != null && (list = this.gXO.mWindowToast) != null && list.size() > 0) {
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
    public void bOJ() {
        if (this.gXO == null || this.gXO.getForum() != null) {
            this.gYq.bPQ();
        } else if (this.gXO.getForum().getYuleData() != null && this.gXO.getForum().getYuleData().aMP()) {
            TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_VIEW);
            this.gYq.a(this.gXO.getForum().getYuleData().aMQ());
        } else {
            this.gYq.bPQ();
        }
    }

    private void K(boolean z, boolean z2) {
        if (this.gYG != null && this.gXO != null && this.gYq != null && z) {
            if (!this.gYG.bUe() && this.gYG.bTV() == 1) {
                if (!this.gYG.bUc()) {
                    this.gXO.addCardVideoInfoToThreadList();
                    this.gXO.addVideoInfoToThreadListInTenAndFifteenFloor();
                }
                boolean z3 = false;
                if (this.gYq.bPR().p(com.baidu.tieba.card.data.n.gsY)) {
                    z3 = this.gXO.addHotTopicDataToThreadList();
                }
                if (!z3) {
                    this.gXO.addFeedForumDataToThreadList();
                }
                if (TbadkCoreApplication.getInst().isRecAppExist()) {
                    this.gXO.addRecommendAppToThreadList(this);
                }
                if (!this.gYq.bPR().p(bj.dqW)) {
                    this.gXO.removeAlaLiveThreadData();
                }
                this.gXO.addSchoolRecommendToThreadList();
            }
            if (!this.gYq.bPR().p(bj.dqW)) {
                this.gXO.removeAlaInsertLiveData();
                this.gXO.removeAlaStageLiveDat();
            } else {
                this.gXO.addInsertLiveDataToThreadList();
                this.gXO.addStageLiveDataToThreadList();
            }
            this.gXO.checkLiveStageInThreadList();
            this.gXO.addNoticeThreadToThreadList();
            if (this.gYq.bPR().p(com.baidu.tieba.h.b.hCG)) {
                this.gXO.addGameRankListToThreadList(z2);
            }
            if (TbadkCoreApplication.isLogin() && (!this.gYG.bUe() || this.gYG.isNetFirstLoad)) {
                this.gXO.addUserRecommendToThreadList();
            }
            this.gXO.addVideoActivityToTop();
        }
    }

    public boolean bOK() {
        if (this.gYH != null && this.gYG != null) {
            this.gYH.a(this.gYG.getPageType(), this.gXO);
        }
        boolean z = false;
        if (this.gXO != null) {
            z = this.gXO.hasTab();
        }
        bOM();
        if (this.gYq != null) {
            this.gYq.bQc();
            this.gYq.bQd();
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tc(int i) {
        as asVar = null;
        bOK();
        bOT();
        try {
            if (this.gXO != null) {
                this.gYq.a((ArrayList<com.baidu.adp.widget.ListView.m>) null, this.gXO);
                this.gYH.uN(1);
                this.gYq.bPH();
                this.gYI.a(this.gXO, this.gYG.bUa());
                com.baidu.tieba.frs.tab.d uW = this.gYI.uW(this.gXO.getFrsDefaultTabId());
                if (uW != null && !TextUtils.isEmpty(uW.url)) {
                    asVar = new as();
                    asVar.ext = uW.url;
                    asVar.stType = uW.name;
                }
                this.gYG.a(this.gXO.getFrsDefaultTabId(), 0, asVar);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(boolean z, boolean z2) {
        try {
            if (this.gXO != null && this.gYI != null && this.gYG != null) {
                if (!this.gYq.bPR().p(bj.dqW)) {
                    this.gXO.removeAlaLiveThreadData();
                }
                boolean isEmpty = com.baidu.tbadk.core.util.v.isEmpty(this.gXO.getGameTabInfo());
                this.gYq.mw(isEmpty);
                if (!isEmpty) {
                    if (this.gZa == null) {
                        this.gZa = new com.baidu.tieba.frs.vc.e(this, (NoPressedRelativeLayout) this.mRootView);
                    }
                    if (this.fhh == null) {
                        this.fhh = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
                    }
                } else {
                    this.gZa = null;
                    this.fhh = null;
                }
                if (this.gXO.getForum() != null) {
                    this.gYi = this.gXO.getForum().getName();
                    this.forumId = this.gXO.getForum().getId();
                }
                if (this.gXO.hasTab()) {
                    this.gYI.a(this.gXO, this.gYG.bUa());
                }
                if (z) {
                    K(true, z);
                } else {
                    K(this.gYC, z);
                }
                bOK();
                if (this.gYO != null) {
                    this.gYO.a(this.gYH, this.gXO);
                }
                if (this.gXO.getPage() != null) {
                    setHasMore(this.gXO.getPage().aJA());
                }
                ArrayList<com.baidu.adp.widget.ListView.m> a2 = this.gYR.a(z2, true, this.gXO.getThreadList(), null, z, false);
                if (a2 != null) {
                    this.gXO.setThreadList(a2);
                }
                this.gXO.removeRedundantUserRecommendData();
                this.gXQ = this.gXO.getTopThreadSize();
                if (this.gYm != null) {
                    this.gYl = true;
                    this.gYm.De(this.gXQ);
                    com.baidu.tieba.frs.f.a.a(this, this.gXO.getForum(), this.gXO.getThreadList(), this.gYl, getPn());
                }
                if (this.gYG.bTV() == 1) {
                    bOQ();
                    if (!z && this.gYG.getPn() == 1) {
                        bOL();
                    }
                }
                if (this.gYP != null) {
                    this.gYP.cd(this.gYI.bVQ());
                }
                bOA();
                this.gYq.bPz();
                this.gYq.M(true, false);
                if (z && this.gXO.isFirstTabEqualAllThread()) {
                    com.baidu.adp.lib.f.e.lb().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.15
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!FrsFragment.this.gYz && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                FrsFragment.this.gYq.bQa();
                            }
                        }
                    });
                }
                if (this.gXO.getForum() != null) {
                    this.gYq.CR(this.gXO.getForum().getWarningMsg());
                }
                if (this.gXO != null && this.gXO.getFrsVideoActivityData() != null && com.baidu.tbadk.core.sharedPref.b.aNV().getLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 0L) == 0) {
                    com.baidu.adp.lib.f.e.lb().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.16
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsFragment.this.gYq.bPY();
                        }
                    }, 1000L);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FRS_SHOW_AR_ENTRY, this));
                this.gYq.bPt();
                if (this.gXO != null && this.gXO.getForum() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ENTER_FORUM, new VisitedForumData(this.gXO.getForum().getId(), this.gXO.getForum().getName(), this.gXO.getForum().getImage_url(), String.valueOf(System.currentTimeMillis() / 1000), ConstantData.Forum.SPECAIL_FORUM_TYPE_LIVE.equals(this.gXO.getForum().special_forum_type), this.gXO.getForum().getThemeColorInfo(), this.gXO.getForum().getMember_num())));
                }
                this.gZe.a(this.gXO.bottomMenuList, this.gXO.getForum());
                bPi();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void mo(boolean z) {
        com.baidu.tieba.s.c.cVr().b(getUniqueId(), z);
    }

    public void bOL() {
        if (this.gYU == null) {
            this.gYU = new com.baidu.tieba.frs.live.a(this, com.baidu.adp.lib.f.b.toInt(this.forumId, 0));
        }
        this.gYU.bTC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.tbadkCore.m mVar) {
        try {
            if (!this.gYz && mVar != null && this.gXO != null) {
                this.gXO.receiveData(mVar);
                L(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void bOM() {
        if (this.gYG != null) {
            CQ(this.gYG.getPageType());
        } else {
            CQ("normal_page");
        }
    }

    private void CQ(String str) {
        mp("frs_page".equals(str));
        if (this.gYO != null) {
            this.gYO.a(this.gYH, this.gYq, this.gXO);
        }
    }

    public void mp(boolean z) {
        if (this.gYS != null) {
            this.gYS.bVE();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.s.c.cVr().w(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.frs_activity, viewGroup, false);
            this.gYc = new com.baidu.tieba.frs.entelechy.a();
            this.gYO = this.gYc.bRy();
            this.gYb = TbadkCoreApplication.getInst().getString(R.string.frs_title_new_area);
            this.gYH = new com.baidu.tieba.frs.vc.h(this, this.gYc, (FrsHeaderViewContainer) this.mRootView.findViewById(R.id.header_view_container));
            this.gYI = new FrsTabViewController(this, this.mRootView);
            this.gYI.registerListener();
            this.gYH.a(this.gYI);
            this.gYI.a(this.gZq);
            Intent intent = getActivity().getIntent();
            if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                this.gYe = true;
            }
            this.gYq = new n(this, this.gZI, this.gYc, this.gYe, this.gYH);
            this.gZe = new com.baidu.tieba.frs.brand.buttommenu.a(getPageContext(), this.mRootView);
        } else {
            if (this.mRootView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            if (this.gYI != null) {
                this.gYI.registerListener();
            }
            this.gYq.bPX();
            this.mRootView.setLeft(0);
            this.mRootView.setRight(com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getContext()));
        }
        this.gZi = true;
        this.edF = System.currentTimeMillis() - currentTimeMillis;
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        ArrayList<com.baidu.adp.widget.ListView.m> arrayList = null;
        this.gAV = System.currentTimeMillis();
        long j = this.gAV;
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.gYn = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.gAV = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            ah(intent);
        }
        this.edE = j - this.gAV;
        this.gYm = new com.baidu.tieba.tbadkCore.data.f("frs", com.baidu.tieba.tbadkCore.data.f.kRN);
        if (this.gYG == null) {
            this.gYG = new FrsModelController(this, this.gZD);
            this.gYG.a(this.gZp);
            this.gYG.init();
        }
        this.gYG.setSchemeUrl(this.mSchemeUrl);
        if (intent != null) {
            this.gYG.ad(intent.getExtras());
        } else if (bundle != null) {
            this.gYG.ad(bundle);
        } else {
            this.gYG.ad(null);
        }
        if (intent != null) {
            this.gYH.aj(intent.getExtras());
        } else if (bundle != null) {
            this.gYH.aj(bundle);
        } else {
            this.gYH.aj(null);
        }
        this.gYp = getVoiceManager();
        this.gYV = new m(getPageContext(), this);
        initUI();
        initData(bundle);
        if (!bPb()) {
            this.gYM = new aq(getActivity(), this.gYq, this.gYH);
            this.gYM.mL(true);
        }
        this.gYp = getVoiceManager();
        if (this.gYp != null) {
            this.gYp.onCreate(getPageContext());
        }
        new com.baidu.tieba.frs.mc.i();
        int i = -1;
        if (this.gYR != null && this.gYR.bTN() != null) {
            i = this.gYR.bTN().bOy();
            arrayList = this.gYR.bTN().getDataList();
        }
        this.gYR = new com.baidu.tieba.frs.mc.c(this, this.gZG);
        this.gYR.bTN().setHasMore(i);
        if (arrayList != null && arrayList.size() > 0) {
            this.gYR.bTN().av(arrayList);
        }
        this.gYK = new com.baidu.tieba.frs.smartsort.a(this);
        this.gYS = new com.baidu.tieba.frs.vc.j(this);
        this.gYP = new com.baidu.tieba.frs.vc.a(getPageContext(), this.gYG.bUb());
        this.gYL = new com.baidu.tieba.frs.mc.b(this);
        this.gYQ = new com.baidu.tieba.frs.mc.d(this);
        this.gYJ = new com.baidu.tieba.frs.mc.h(this);
        this.gYT = new com.baidu.tieba.frs.mc.a(this);
        this.gYW = new com.baidu.tieba.frs.vc.c(this);
        this.gYX = new com.baidu.tieba.frs.mc.e(this, getUniqueId());
        this.gZc = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "frs");
        this.gZd = new com.baidu.tieba.ala.a(getPageContext());
        this.gZf = new com.baidu.tieba.frs.sportspage.notification.a(getPageContext());
        registerListener(this.gZx);
        registerListener(this.mMemListener);
        registerListener(this.gZv);
        registerListener(this.gZH);
        registerListener(this.gZE);
        registerListener(this.gZs);
        registerListener(this.gZt);
        registerListener(this.gZu);
        registerListener(this.gZm);
        registerListener(this.gZn);
        registerListener(this.adK);
        registerListener(this.gZM);
        registerListener(this.gZz);
        registerListener(this.gZo);
        registerListener(this.gZA);
        registerListener(this.gZy);
        registerListener(this.gZB);
        registerListener(this.gZC);
        this.gZN.setTag(getPageContext().getUniqueId());
        MessageManager.getInstance().registerListener(this.gZN);
        registerListener(this.gZO);
        registerListener(this.gZP);
        registerListener(this.gZQ);
        this.gYq.my(false);
        if (!bPb() && !this.hasInit) {
            showLoadingView(this.gYq.bCt(), true);
            this.gYG.J(3, false);
        }
        com.baidu.tieba.frs.a.bND().a(new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.19
            @Override // com.baidu.tieba.frs.a.b
            public void J(boolean z, boolean z2) {
                if (FrsFragment.this.gYq != null) {
                    FrsFragment.this.gYq.tm(z ? 0 : 8);
                    if (!z2) {
                        FrsFragment.this.gZh = z;
                    }
                    if (FrsFragment.this.gYq.bPR() != null && FrsFragment.this.gYG != null && FrsFragment.this.gYG.bTW()) {
                        FrsFragment.this.gYq.bPR().notifyDataSetChanged();
                    }
                    if (FrsFragment.this.bOv() != null) {
                        FrsTabViewController.b bVR = FrsFragment.this.bOv().bVR();
                        if (bVR != null && bVR.tabId == 502 && (bVR.fragment instanceof FrsCommonTabFragment)) {
                            ((FrsCommonTabFragment) bVR.fragment).bRq();
                        } else if (bVR != null && bVR.tabId == 503 && (bVR.fragment instanceof FrsNewAreaFragment)) {
                            FrsNewAreaFragment frsNewAreaFragment = (FrsNewAreaFragment) bVR.fragment;
                            frsNewAreaFragment.bRq();
                            if (frsNewAreaFragment.bUi() != null) {
                                com.baidu.tieba.frs.mc.g bUi = frsNewAreaFragment.bUi();
                                bUi.mN(!z);
                                bUi.mB(!z);
                            }
                        }
                        if (FrsFragment.this.bOv().bVJ() != null) {
                            FrsFragment.this.bOv().bVJ().setmDisallowSlip(z);
                            FrsFragment.this.bOv().nr(z);
                        }
                    }
                    if (FrsFragment.this.gYq.bPx() != null) {
                        FrsFragment.this.gYq.mv(!z);
                    }
                    if (FrsFragment.this.getActivity() instanceof FrsActivity) {
                        ((FrsActivity) FrsFragment.this.getActivity()).mm(!z);
                    }
                    if (FrsFragment.this.gZe != null) {
                        FrsFragment.this.gZe.mT(!z);
                    }
                    FrsFragment.this.gYq.mA(!z);
                    FrsFragment.this.gYq.mB(z ? false : true);
                }
            }

            @Override // com.baidu.tieba.frs.a.b
            public void sY(int i2) {
                if (FrsFragment.this.gYq != null) {
                    FrsFragment.this.gYq.tn(i2);
                }
            }

            @Override // com.baidu.tieba.frs.a.b
            public void bNJ() {
                com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getContext(), (int) R.string.frs_multi_delete_max_num);
            }
        });
        this.gYq.b(new d.a() { // from class: com.baidu.tieba.frs.FrsFragment.20
            @Override // com.baidu.tieba.NEGFeedBack.d.a
            public void a(DeleteThreadHttpResponseMessage deleteThreadHttpResponseMessage) {
                boolean z;
                int i2 = 0;
                if (deleteThreadHttpResponseMessage != null) {
                    FrsFragment.this.gYq.beD();
                    FrsFragment.this.gYq.bPZ();
                    FrsNewAreaFragment frsNewAreaFragment = null;
                    if (FrsFragment.this.gYI == null || FrsFragment.this.gYI.bVR() == null || !(FrsFragment.this.gYI.bVR().fragment instanceof FrsNewAreaFragment)) {
                        z = false;
                    } else {
                        frsNewAreaFragment = (FrsNewAreaFragment) FrsFragment.this.gYI.bVR().fragment;
                        z = true;
                    }
                    if (deleteThreadHttpResponseMessage.getError() == 0) {
                        String text = !TextUtils.isEmpty(deleteThreadHttpResponseMessage.getText()) ? deleteThreadHttpResponseMessage.getText() : FrsFragment.this.getString(R.string.delete_fail);
                        if (deleteThreadHttpResponseMessage.getRetType() == 1211066) {
                            if (FrsFragment.this.grr == null) {
                                FrsFragment.this.grr = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.grr.uf(text);
                            FrsFragment.this.grr.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.20.1
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.grr.gF(false);
                            FrsFragment.this.grr.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.grr.aMU();
                        } else if (deleteThreadHttpResponseMessage.getRetType() == 1211067) {
                            if (FrsFragment.this.grr == null) {
                                FrsFragment.this.grr = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.grr.uf(text);
                            FrsFragment.this.grr.a(R.string.know, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.20.2
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.grr.gF(false);
                            FrsFragment.this.grr.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.grr.aMU();
                        } else {
                            FrsFragment.this.gYq.aJ(deleteThreadHttpResponseMessage.getText(), ContextCompat.getColor(FrsFragment.this.getContext(), deleteThreadHttpResponseMessage.getRetType() == 1 ? R.color.nav_bar_tip_error : R.color.cp_link_tip_a_alpha95));
                        }
                        if (z && frsNewAreaFragment != null) {
                            frsNewAreaFragment.cA(deleteThreadHttpResponseMessage.getSuccessItems());
                        }
                        FrsFragment.this.cp(deleteThreadHttpResponseMessage.getSuccessItems());
                        com.baidu.tieba.frs.a.bND().co(deleteThreadHttpResponseMessage.getSuccessItems());
                        for (com.baidu.adp.widget.ListView.m mVar : FrsFragment.this.gXO.getThreadList()) {
                            if (mVar instanceof bi) {
                                i2++;
                                continue;
                            }
                            if (i2 >= 6) {
                                break;
                            }
                        }
                        if (i2 < 6) {
                            FrsFragment.this.blb();
                            return;
                        }
                        return;
                    }
                    com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getActivity(), deleteThreadHttpResponseMessage.getErrorString());
                }
            }
        });
        this.cCF = UtilHelper.getScreenHeight(getActivity());
        this.hasInit = true;
        td(1);
        super.onActivityCreated(bundle);
        this.createTime = System.currentTimeMillis() - j;
    }

    public void mq(boolean z) {
        if (this.gYI != null) {
            this.gYI.hyj = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cp(List<String> list) {
        if (!com.baidu.tbadk.core.util.v.isEmpty(list)) {
            ArrayList<com.baidu.adp.widget.ListView.m> threadList = this.gXO.getThreadList();
            if (!com.baidu.tbadk.core.util.v.isEmpty(threadList) && this.gYq.getListView() != null && this.gYq.getListView().getData() != null) {
                Iterator<com.baidu.adp.widget.ListView.m> it = threadList.iterator();
                List<com.baidu.adp.widget.ListView.m> data = this.gYq.getListView().getData();
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.m next = it.next();
                    if (next instanceof bi) {
                        bj bjVar = ((bi) next).dqA;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= list.size()) {
                                break;
                            } else if (!com.baidu.tbadk.core.util.aq.equals(list.get(i2), bjVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.gYR.d(next);
                                this.gYq.getListView().getAdapter().notifyItemRemoved(i);
                                break;
                            }
                        }
                    }
                    i++;
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void blv() {
        if (isAdded() && this.eRW && !isLoadingViewAttached()) {
            showLoadingView(this.gYq.bCt(), true);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void blw() {
        if (isAdded() && this.eRW && isLoadingViewAttached()) {
            hideLoadingView(this.gYq.bCt());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (bPb()) {
            showLoadingView(this.gYq.bCt(), true);
            this.gYq.to(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.gYG.J(3, true);
            aQI().scrollToPosition(0);
        }
    }

    private void td(int i) {
        String str = "";
        if (this.gXO != null && this.gXO.getForum() != null) {
            str = this.gXO.getForum().getId();
        }
        if (!StringUtils.isNull(str)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13008").cI("fid", str).cI("obj_type", "4").af("obj_locate", i).cI("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.z zVar) {
        if (zVar != null) {
            this.egY = zVar.baC();
            this.gYY = zVar.baD();
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void showFloatingView() {
        if (this.egY != null) {
            this.egY.ic(true);
        }
    }

    private void ah(Intent intent) {
        if (intent != null) {
            if (intent != null) {
                if (!com.baidu.tieba.frs.f.f.a(this, getForumName(), "from", intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false)) && getActivity() != null) {
                    getActivity().finish();
                    return;
                }
            }
            Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
            this.mSchemeUrl = uri != null ? uri.toString() : null;
            if (uri != null) {
                this.gYi = uri.getQueryParameter("name");
                this.mFrom = uri.getQueryParameter("from");
                if (!StringUtils.isNull(this.gYi)) {
                    intent.putExtra("name", this.gYi);
                }
                if (!StringUtils.isNull(this.mFrom)) {
                    intent.putExtra("from", this.mFrom);
                }
                TiebaStatic.log(TbadkCoreStatisticKey.AS_INVOKE_TIEBA);
            }
            if (StringUtils.isNull(this.gYi) && uri != null) {
                if (com.baidu.tbadk.BdToken.f.n(uri)) {
                    com.baidu.tbadk.BdToken.f.aGd().b(uri, this.gZF);
                } else {
                    com.baidu.tieba.frs.f.d ak = com.baidu.tieba.frs.f.i.ak(intent);
                    if (ak != null) {
                        this.gYi = ak.forumName;
                        if (ak.hvN == null || ak.hvN.equals("aidou")) {
                        }
                    }
                }
                if (!StringUtils.isNull(this.gYi)) {
                    intent.putExtra("name", this.gYi);
                }
                intent.putExtra(FrsActivityConfig.FRS_CALL_FROM, 12);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.gYp = getVoiceManager();
        if (this.gYp != null) {
            this.gYp.onStart(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        Intent intent;
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.dOK);
        if (bundle != null) {
            this.gYi = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
            this.gYi = intent.getStringExtra("name");
            this.mFrom = intent.getStringExtra("from");
            this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
        }
        if (getArguments() != null) {
            this.gYj = getArguments().getBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, false);
        }
        if (TextUtils.isEmpty(this.mFrom) || FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
        }
        if (this.mIsLogin) {
            registerListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL, this.dOK);
        }
        this.gYH.aj(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.s.c.cVr().x(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.gZM);
        gYt = null;
        if (this.gYp != null) {
            this.gYp.onDestory(getPageContext());
        }
        com.baidu.tieba.recapp.report.a.remove("FRS");
        this.gYp = null;
        com.baidu.tieba.card.r.bEY().lx(false);
        if (this.gXO != null && this.gXO.getForum() != null) {
            af.bQw().ee(com.baidu.adp.lib.f.b.toLong(this.gXO.getForum().getId(), 0L));
        }
        if (this.gYU != null) {
            this.gYU.onDestory();
        }
        if (this.gYq != null) {
            com.baidu.tieba.frs.f.h.a(this.gYq, this.gXO, getForumId(), false, null);
            this.gYq.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.gYB != null) {
                this.gYB.aZs();
            }
            if (this.gYq != null) {
                this.gYq.release();
            }
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.gYH.aqT();
        if (this.gYG != null) {
            this.gYG.bqt();
        }
        if (this.gYM != null) {
            this.gYM.beT();
        }
        if (this.gYP != null) {
            this.gYP.destory();
        }
        if (this.gYK != null) {
            this.gYK.onDestroy();
        }
        if (this.gZa != null) {
            this.gZa.onDestory();
        }
        if (this.gYT != null) {
            this.gYT.onDestroy();
        }
        if (this.gZc != null) {
            this.gZc.onDestroy();
        }
        if (this.gZd != null) {
            this.gZd.onDestroy();
        }
        com.baidu.tieba.recapp.d.a.cOb().cOd();
        com.baidu.tieba.frs.f.j.bUO();
        if (this.gYI != null) {
            this.gYI.a((FrsTabViewController.a) null);
            this.gYI.bVT();
        }
        if (this.gZg != null) {
            this.gZg.onDestroy();
        }
        com.baidu.tieba.frs.a.bND().a(null);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.gYi);
        bundle.putString("from", this.mFrom);
        this.gYG.onSaveInstanceState(bundle);
        if (this.gYp != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            this.gYp.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.gYT != null) {
            this.gYT.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.gYq != null) {
            this.gYq.bPE();
            this.gYq.onResume();
        }
        this.gYJ.nj(true);
        this.gYC = true;
        if (gYh) {
            gYh = false;
            if (this.gYq != null) {
                this.gYq.startPullRefresh();
                return;
            }
            return;
        }
        if (this.gYp != null) {
            this.gYp.onResume(getPageContext());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_RESUME));
        if (this.gYq != null) {
            this.gYq.mC(false);
        }
        if (this.gZb) {
            refresh(6);
            this.gZb = false;
        }
        if (this.gZk != null && getActivity() != null) {
            if (NotificationManagerCompat.from(getActivity()).areNotificationsEnabled()) {
                com.baidu.tbadk.coreExtra.messageCenter.f.aUi().setSignAlertOn(true);
                com.baidu.tbadk.coreExtra.messageCenter.f.aUi().setSignAlertTime(this.gZk.getHours(), this.gZk.getMinutes());
                com.baidu.tbadk.coreExtra.messageCenter.f.aUi().a(getTbPageContext().getPageActivity(), this.gYq.bCt());
            }
            this.gZk = null;
        }
        bPi();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
    }

    public boolean bON() {
        Intent intent;
        if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
            return false;
        }
        return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
    }

    public void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.gYi = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.gYk = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.gYk) {
                bOO();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOO() {
        this.gYq.startPullRefresh();
    }

    public void closeActivity() {
        com.baidu.tieba.frs.f.i.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.mFrom);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.gYq.setTitle(this.gYi);
        } else {
            this.gYq.setTitle("");
            this.mFlag = 1;
        }
        this.gYq.a(this.gZK);
        this.gYq.addOnScrollListener(this.mScrollListener);
        this.gYq.g(this.gVM);
        this.gYq.bPR().a(this.gZJ);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gZi) {
            this.gYq.onChangeSkinType(i);
            this.gYH.uM(i);
            this.gYI.onChangeSkinType(i);
            if (this.gYs != null) {
                this.gYs.onChangeSkinType(i);
            }
            if (this.gYZ != null) {
                this.gYZ.onChangeSkinType();
            }
            if (this.gZe != null) {
                this.gZe.onChangeSkinType(getPageContext(), i);
            }
            if (this.grr != null) {
                com.baidu.tbadk.q.a.a(getPageContext(), this.grr.getRealView());
            }
            if (this.gZa != null) {
                this.gZa.onChangeSkinType(getPageContext(), i);
            }
        }
    }

    public void te(int i) {
        if (!this.mIsLogin) {
            if (this.gXO != null && this.gXO.getAnti() != null) {
                this.gXO.getAnti().setIfpost(1);
            }
            if (i == 0) {
                bc.skipToLoginActivity(getActivity());
            }
        } else if (this.gXO != null) {
            if (i == 0) {
                com.baidu.tieba.frs.f.j.e(this, 0);
            } else {
                this.gYq.bPG();
            }
        }
    }

    public void refresh() {
        com.baidu.tieba.a.d.bfP().yb("page_frs");
        refresh(3);
    }

    public void refresh(int i) {
        this.gYz = false;
        bOT();
        if (this.gYq != null && this.gYq.bPv() != null) {
            this.gYq.bPv().bZf();
        }
        if (this.gYG != null) {
            this.gYG.J(i, true);
        }
    }

    private void bOP() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.f.h.lc().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.26
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.KS(FrsFragment.this.gYi);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOQ() {
        bOT();
        try {
            if (this.gXO != null) {
                this.gYq.bpV();
                this.gYq.mv(bPh());
                if (!com.baidu.tieba.frs.vc.h.l(this.gXO) || !com.baidu.tieba.frs.vc.h.k(this.gXO)) {
                }
                if (this.gXO.getForum() != null) {
                    this.gYi = this.gXO.getForum().getName();
                    this.forumId = this.gXO.getForum().getId();
                }
                if (this.gXO.getPage() != null) {
                    setHasMore(this.gXO.getPage().aJA());
                }
                this.gYq.setTitle(this.gYi);
                this.gYq.setForumName(this.gYi);
                TbadkCoreApplication.getInst().setDefaultBubble(this.gXO.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.gXO.getUserData().getBimg_end_time());
                bOP();
                bOR();
                ArrayList<com.baidu.adp.widget.ListView.m> threadList = this.gXO.getThreadList();
                if (threadList != null) {
                    this.gYq.a(threadList, this.gXO);
                    com.baidu.tieba.frs.f.c.A(this.gYq);
                    this.gYH.uN(getPageNum());
                    this.gYH.i(this.gXO);
                    this.gYI.a(this.gXO, this.gYG.bUa());
                    this.gYq.bPH();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void bOR() {
        if (this.gXO != null) {
            if (this.gXO.getIsNewUrl() == 1) {
                this.gYq.bPR().setFromCDN(true);
            } else {
                this.gYq.bPR().setFromCDN(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.gYJ.nj(false);
        this.gYC = false;
        this.gYq.onPause();
        if (this.gYp != null) {
            this.gYp.onPause(getPageContext());
        }
        this.gYq.mC(true);
        if (this.gYP != null) {
            this.gYP.bUR();
        }
        com.baidu.tbadk.BdToken.c.aFN().aFS();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.gYI != null && this.gYI.bVR() != null && (this.gYI.bVR().fragment instanceof BaseFragment)) {
            ((BaseFragment) this.gYI.bVR().fragment).setPrimary(z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.r.bEY().lx(false);
        mo(false);
        if (this.gXO != null && this.gXO.getForum() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            com.baidu.tbadk.distribute.a.aWD().a(getPageContext().getPageActivity(), "frs", this.gXO.getForum().getId(), 0L);
        }
        if (this.gYp != null) {
            this.gYp.onStop(getPageContext());
        }
        if (aQI() != null) {
            aQI().getRecycledViewPool().clear();
        }
        this.gYH.aPY();
        com.baidu.tbadk.util.aa.baF();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            if (this.gYH != null) {
                this.gYH.jb(isPrimary());
            }
            if (this.gYq != null) {
                this.gYq.jb(isPrimary());
                this.gYq.mC(!isPrimary());
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (com.baidu.tieba.frs.a.bND().bNE()) {
                com.baidu.tieba.frs.a.bND().reset();
                return true;
            } else if (this.gYq != null) {
                return this.gYq.bPD();
            }
        } else if (i == 24) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921381, keyEvent));
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.m
    public TbPageContext<?> getTbPageContext() {
        return getPageContext();
    }

    @Override // com.baidu.tieba.recapp.m
    public void a(AdvertAppInfo advertAppInfo, String str) {
        com.baidu.tbadk.distribute.a.aWD().a(advertAppInfo, this.forumId, 0L, "FRS", str, getPn());
    }

    @Override // com.baidu.tieba.recapp.m
    public void bOS() {
        bOs().bOS();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.gYp == null) {
            this.gYp = VoiceManager.instance();
        }
        return this.gYp;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdRecyclerView aQI() {
        if (this.gYq == null) {
            return null;
        }
        return this.gYq.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void bOT() {
        if (this.gYp != null) {
            this.gYp.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> aQJ() {
        if (this.dJv == null) {
            this.dJv = UserIconBox.s(getPageContext().getPageActivity(), 8);
        }
        return this.dJv;
    }

    public void bOU() {
        if (getFragmentActivity() != null && getFragmentActivity().getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.p onGetPreLoadListView() {
        return aQI().getPreLoadHandle();
    }

    @Override // com.baidu.tieba.frs.am
    public NavigationBar boh() {
        if (this.gYq == null) {
            return null;
        }
        return this.gYq.boh();
    }

    public FRSRefreshButton bOV() {
        return this.gYs;
    }

    public void a(FRSRefreshButton fRSRefreshButton) {
        if (fRSRefreshButton != null) {
            this.gYs = fRSRefreshButton;
            this.gYs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.32
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (FrsFragment.this.gYI != null) {
                        FrsTabViewController.b bVR = FrsFragment.this.gYI.bVR();
                        if (bVR != null && bVR.fragment != null && (bVR.fragment instanceof al)) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                            ((al) bVR.fragment).bOe();
                            ((al) bVR.fragment).bmn();
                            return;
                        }
                        FrsFragment.this.bOx().startPullRefresh();
                    }
                }
            });
        }
    }

    public void bOW() {
        if (this.gYs != null) {
            this.gYs.hide();
        }
    }

    public void bOX() {
        if (this.gYs != null) {
            this.gYs.show();
        }
    }

    /* loaded from: classes9.dex */
    private final class a implements com.baidu.adp.widget.ListView.v {
        private a() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.v
        public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null) {
                if (bdUniqueId == t.hby) {
                    if (FrsFragment.this.gYq != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11752").cI("fid", FrsFragment.this.forumId).cI("obj_locate", "1"));
                        FrsFragment.this.gYq.startPullRefresh();
                    }
                } else if (mVar != null && (mVar instanceof bi)) {
                    bj bjVar = ((bi) mVar).dqA;
                    if (bjVar.aLB() == null || bjVar.aLB().getGroup_id() == 0 || bc.checkUpIsLogin(FrsFragment.this.getActivity())) {
                        if (bjVar.aLo() != 1 || bc.checkUpIsLogin(FrsFragment.this.getActivity())) {
                            if (bjVar.aKR() != null) {
                                if (bc.checkUpIsLogin(FrsFragment.this.getActivity())) {
                                    String postUrl = bjVar.aKR().getPostUrl();
                                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.isNetOk()) {
                                        com.baidu.tbadk.browser.a.startInternalWebActivity(FrsFragment.this.getActivity(), postUrl);
                                    }
                                }
                            } else if (bjVar.aLM() != null) {
                                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                    bc.skipToLoginActivity(FrsFragment.this.getPageContext().getPageActivity());
                                    return;
                                }
                                com.baidu.tbadk.core.data.p aLM = bjVar.aLM();
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), aLM.getCartoonId(), aLM.getChapterId(), 2)));
                            } else {
                                com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                                if (readThreadHistory != null && !readThreadHistory.KY(bjVar.getId())) {
                                    readThreadHistory.KX(bjVar.getId());
                                }
                                boolean z = false;
                                final String aKL = bjVar.aKL();
                                if (aKL != null && !aKL.equals("")) {
                                    z = true;
                                    new Thread(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.a.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(aKL);
                                            xVar.aOy().aOZ().mIsNeedAddCommenParam = false;
                                            xVar.aOy().aOZ().mIsUseCurrentBDUSS = false;
                                            xVar.getNetData();
                                        }
                                    }).start();
                                }
                                String tid = bjVar.getTid();
                                if (tid == null) {
                                    tid = "";
                                }
                                if (bjVar.aKz() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                    ba.aOY().b(FrsFragment.this.getPageContext(), new String[]{tid, "", null});
                                    return;
                                }
                                if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && tid.length() > 4 && tid.length() > 4) {
                                    bjVar.setId(tid.substring(3));
                                }
                                if (bdUniqueId.getId() == bj.dsB.getId()) {
                                    com.baidu.tieba.frs.f.h.a(bjVar.aKk());
                                } else if (bdUniqueId.getId() == bj.dqZ.getId()) {
                                    com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                                    anVar.cI("obj_type", "2");
                                    anVar.cI("tid", bjVar.getTid());
                                    TiebaStatic.log(anVar);
                                }
                                com.baidu.tieba.frs.f.i.a(FrsFragment.this, bjVar, i, z);
                                com.baidu.tieba.frs.f.h.a(FrsFragment.this, FrsFragment.this.gXO, bjVar);
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
            hideNetRefreshView(this.gYq.bCt());
            showLoadingView(this.gYq.bCt(), true);
            this.gYq.my(false);
            this.gYG.J(3, true);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData bOY() {
        return this.gXO;
    }

    public boolean bOZ() {
        return this.gYq.bOZ();
    }

    public void av(Object obj) {
        if (this.gYL != null && this.gYL.hrf != null) {
            this.gYL.hrf.callback(obj);
        }
    }

    public void aw(Object obj) {
        if (this.gYL != null && this.gYL.hrg != null) {
            this.gYL.hrg.callback(obj);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        this.gYq.getListView().stopScroll();
        if (!this.gYq.bPN()) {
            if (!com.baidu.adp.lib.util.l.isNetOk()) {
                this.gYq.bmq();
            } else if (this.gYG.bTV() == 1) {
                blq();
                blb();
            } else if (this.gYG.hasMore()) {
                blb();
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void onFailed(String str) {
        blq();
        showToast(str);
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void an(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        boolean isEmpty = com.baidu.tbadk.core.util.v.isEmpty(arrayList);
        setHasMore(isEmpty ? 0 : 1);
        blq();
        if (!isEmpty) {
            if (!this.gYG.bUe() && TbadkCoreApplication.getInst().isRecAppExist() && this.gYG.bTV() == 1) {
                this.gXO.addRecommendAppToThreadList(this, arrayList);
            }
            if (this.gYG != null) {
                com.baidu.tieba.frs.d.a.a(getUniqueId(), arrayList, this.gXO.getForum(), this.gYG.getSortType());
            }
            ArrayList<com.baidu.adp.widget.ListView.m> a2 = this.gYR.a(false, false, arrayList, this.gYm, false);
            if (a2 != null) {
                this.gXO.setThreadList(a2);
                this.gYq.a(a2, this.gXO);
            }
            if (this.gYG != null) {
                com.baidu.tieba.frs.d.c.a(this.gXO, this.gYG.bUa(), 2, getContext());
            }
        }
    }

    private void blq() {
        if (bOy() == 1 || this.gYR.cz(this.gXO.getThreadListIds())) {
            if (com.baidu.tbadk.core.util.v.getCount(this.gXO.getThreadList()) > 3) {
                this.gYq.bmo();
            } else {
                this.gYq.bPU();
            }
        } else if (com.baidu.tbadk.core.util.v.isEmpty(this.gXO.getThreadList())) {
            this.gYq.bmq();
        } else {
            this.gYq.bmp();
        }
    }

    @Override // com.baidu.tieba.frs.mc.l
    public void blb() {
        if (this.gYR != null) {
            this.gYR.a(this.gYi, this.forumId, this.gXO);
        }
    }

    public void bPa() {
        if (!com.baidu.tbadk.core.util.ab.requestWriteExternalStorgeAndCameraPermission(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.al.e(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment, com.baidu.h.a.a.InterfaceC0100a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        com.baidu.tieba.frs.f.i.a(this, i, strArr, iArr);
    }

    public void mr(boolean z) {
        if (this.gYM != null) {
            this.gYM.mL(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.gYN.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a oh(int i) {
        return this.gYN.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        this.gYV.b(bVar);
    }

    public boolean bPb() {
        return this.gYe;
    }

    @Override // com.baidu.tieba.frs.aj
    public void FH() {
        if (this.gYq != null) {
            showFloatingView();
            this.gYq.getListView().scrollToPosition(0);
            this.gYq.startPullRefresh();
        }
    }

    public ForumWriteData bPc() {
        if (this.gXO == null || this.gXO.getForum() == null) {
            return null;
        }
        ForumData forum = this.gXO.getForum();
        ForumWriteData forumWriteData = new ForumWriteData(forum.getId(), forum.getName(), forum.getPrefixData(), this.gXO.getAnti());
        forumWriteData.avatar = forum.getImage_url();
        forumWriteData.forumLevel = forum.getUser_level();
        forumWriteData.specialForumType = forum.special_forum_type;
        forumWriteData.firstDir = forum.getFirst_class();
        forumWriteData.secondDir = forum.getSecond_class();
        UserData userData = this.gXO.getUserData();
        forumWriteData.privateThread = userData != null ? userData.getPrivateThread() : 0;
        forumWriteData.frsTabInfo = bPd();
        return forumWriteData;
    }

    private FrsTabInfoData bPd() {
        int i;
        if (this.gYG == null || this.gXO == null || this.gYI == null) {
            return null;
        }
        if (this.gXO.getEntelechyTabInfo() == null || com.baidu.tbadk.core.util.v.isEmpty(this.gXO.getEntelechyTabInfo().tab)) {
            return null;
        }
        int bVV = this.gYI.bVV();
        if (bVV == 502) {
            return null;
        }
        int i2 = -1;
        ArrayList arrayList = new ArrayList();
        Iterator<FrsTabInfo> it = this.gXO.getEntelechyTabInfo().tab.iterator();
        while (true) {
            i = i2;
            if (!it.hasNext()) {
                break;
            }
            FrsTabInfo next = it.next();
            if (next != null && next.is_general_tab.intValue() == 1) {
                arrayList.add(new FrsTabItemData(next));
                if (bVV == next.tab_id.intValue()) {
                    i2 = bVV;
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

    @Override // com.baidu.tieba.frs.aj
    public void aQp() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void ms(boolean z) {
        this.gYD = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z) {
        this.gYq.tl(8);
        ((FrsActivity) getActivity()).showLoadingView(view, z);
        ((FrsActivity) getActivity()).g(view, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        this.gYq.tl(0);
        ((FrsActivity) getActivity()).hideLoadingView(view);
        ((FrsActivity) getActivity()).g(view, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        super.showNetRefreshView(view, getResources().getString(R.string.refresh_view_title_text), null, getResources().getString(R.string.refresh_view_button_text), z, getNetRefreshListener());
        this.gYq.tl(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshViewNoClick(View view, String str, boolean z) {
        super.showNetRefreshViewNoClick(view, str, z);
        this.gYq.tl(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        super.hideNetRefreshView(view);
        this.gYq.tl(0);
    }

    public void bPe() {
        FrsTabViewController.b bVR;
        if (this.gYI != null && (bVR = this.gYI.bVR()) != null && bVR.fragment != null && (bVR.fragment instanceof al)) {
            ((al) bVR.fragment).bOe();
        }
    }

    public void mt(boolean z) {
        this.gYg = z;
    }

    public void b(OvalActionButton ovalActionButton) {
        this.gYr = ovalActionButton;
    }

    public OvalActionButton bPf() {
        return this.gYr;
    }

    public boolean bPg() {
        return this.gYg;
    }

    public void onShareSuccess(String str) {
        if (TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.util.aq.isEmpty(str)) {
            if (this.gZg == null) {
                this.gZg = new AddExperiencedModel(getTbPageContext());
            }
            this.gZg.eI(this.forumId, str);
        }
    }

    public boolean bPh() {
        if (this.gYD && !this.gZj) {
            return (this.gYG != null && this.gYG.bTW() && com.baidu.tieba.frs.a.bND().bNE()) ? false : true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.f.c
    public boolean videoNeedPreload() {
        if (this.gXO != null) {
            return com.baidu.tbadk.util.af.ng(2) || (com.baidu.tbadk.util.af.baK() && this.gXO.isFrsVideoAutoPlay);
        }
        return super.videoNeedPreload();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.f.c
    public boolean isCyberVideoUsedThisPage() {
        return com.baidu.tbadk.a.b.sV("cyber_player_test") || com.baidu.tbadk.a.b.sU("cyber_player_test");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPi() {
        if (!com.baidu.tbadk.core.util.aq.isEmpty(this.forumId)) {
            com.baidu.tbadk.BdToken.c.aFN().p(com.baidu.tbadk.BdToken.b.dfZ, com.baidu.adp.lib.f.b.toLong(this.forumId, 0L));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        FrsTabViewController.b bVR;
        if (bOv() == null || (bVR = bOv().bVR()) == null || !(bVR.fragment instanceof BaseFragment)) {
            return null;
        }
        if (bVR.fragment instanceof FrsAllThreadFragment) {
            TbPageTag tbPageTag = super.getTbPageTag();
            int i = -1;
            if (this.gXO != null) {
                i = this.gXO.getSortType();
            }
            tbPageTag.sortType = com.baidu.tieba.frs.f.g.uK(i);
            tbPageTag.locatePage = "a070";
            if (this.gYb.equals(bVR.title)) {
                tbPageTag.locatePage = "a071";
            }
            return tbPageTag;
        } else if (bVR.fragment instanceof FrsFragment) {
            return null;
        } else {
            return ((BaseFragment) bVR.fragment).getTbPageTag();
        }
    }
}
