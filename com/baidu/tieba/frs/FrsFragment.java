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
public class FrsFragment extends BaseFragment implements BdListView.e, a.InterfaceC0121a, UserIconBox.b<BdRecyclerView>, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, aj, am, ap, com.baidu.tieba.frs.loadmore.a, com.baidu.tieba.frs.mc.l, com.baidu.tieba.recapp.m {
    public static com.baidu.tieba.tbadkCore.m gYz;
    private com.baidu.adp.lib.d.b<TbImageView> dJz;
    private com.baidu.tbadk.util.y ehd;
    private com.baidu.tieba.frs.gametab.b fhm;
    public long gYA;
    private com.baidu.card.af gYL;
    private FrsModelController gYM;
    private com.baidu.tieba.frs.vc.h gYN;
    private FrsTabViewController gYO;
    private com.baidu.tieba.frs.mc.h gYP;
    private com.baidu.tieba.frs.smartsort.a gYQ;
    private com.baidu.tieba.frs.mc.b gYR;
    private aq gYS;
    private com.baidu.tieba.frs.entelechy.b.b gYU;
    private com.baidu.tieba.frs.vc.a gYV;
    private com.baidu.tieba.frs.mc.d gYW;
    private com.baidu.tieba.frs.mc.c gYX;
    private com.baidu.tieba.frs.vc.j gYY;
    private com.baidu.tieba.frs.mc.a gYZ;
    private com.baidu.tieba.frs.entelechy.a gYi;
    private com.baidu.tieba.tbadkCore.data.f gYs;
    private VoiceManager gYv;
    private OvalActionButton gYx;
    private FRSRefreshButton gYy;
    private com.baidu.tieba.frs.live.a gZa;
    private m gZb;
    public com.baidu.tieba.frs.vc.c gZc;
    private com.baidu.tieba.frs.mc.e gZd;
    private View.OnTouchListener gZe;
    private com.baidu.tieba.frs.view.a gZf;
    private com.baidu.tieba.frs.vc.e gZg;
    private boolean gZh;
    private com.baidu.tieba.NEGFeedBack.a gZi;
    private com.baidu.tieba.ala.a gZj;
    private com.baidu.tieba.frs.brand.buttommenu.a gZk;
    private com.baidu.tieba.frs.sportspage.notification.a gZl;
    private AddExperiencedModel gZm;
    private boolean gZo;
    private int gZx;
    private com.baidu.tbadk.core.dialog.a grx;
    private View mRootView;
    private String mSchemeUrl;
    public static boolean gYn = false;
    public static volatile long gYC = 0;
    public static volatile long gYD = 0;
    public static volatile int mNetError = 0;
    private String gYh = "";
    public boolean gYj = false;
    private boolean gYk = false;
    private boolean gYl = false;
    private boolean gYm = true;
    public String gYo = null;
    public String mFrom = null;
    public int mFlag = 0;
    public boolean gYp = false;
    private boolean gYq = false;
    private String mThreadId = null;
    public String forumId = null;
    private int gXW = 0;
    private boolean gYr = false;
    private boolean gYt = false;
    private boolean gYu = false;
    private n gYw = null;
    public final bj agC = null;
    private FrsViewData gXU = new FrsViewData();
    public long gBb = -1;
    public long edT = 0;
    public long edJ = 0;
    public long createTime = 0;
    public long edK = 0;
    public long edQ = 0;
    public long gYB = 0;
    public boolean gYE = false;
    private boolean gYF = false;
    private boolean gYG = false;
    public com.baidu.tbadk.n.b gYH = null;
    private boolean gYI = true;
    private boolean gYJ = true;
    private a.C0095a gYK = new a.C0095a(2);
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> gYT = new SparseArray<>();
    private boolean eSb = true;
    private boolean hasInit = false;
    private boolean gZn = false;
    private boolean gZp = false;
    private Date gZq = null;
    private int cCL = 0;
    private int gZr = 0;
    public int mHeadLineDefaultNavTabId = -1;
    private final CustomMessageListener gZs = new CustomMessageListener(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED) { // from class: com.baidu.tieba.frs.FrsFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof bj) {
                    com.baidu.tieba.frs.f.h.a(FrsFragment.this.gYw, FrsFragment.this.gXU, FrsFragment.this.getForumId(), true, (bj) data);
                }
            }
        }
    };
    private CustomMessageListener gZt = new CustomMessageListener(CmdConfigCustom.CMD_CLOSE_GAME_RANK_CARD) { // from class: com.baidu.tieba.frs.FrsFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.gXU != null) {
                FrsFragment.this.gXU.removeGameRankListFromThreadList();
                if (FrsFragment.this.gYw != null) {
                    FrsFragment.this.gYw.aBa();
                }
            }
        }
    };
    private CustomMessageListener adN = new CustomMessageListener(2921401) { // from class: com.baidu.tieba.frs.FrsFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && FrsFragment.this.gYy != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() <= 0 || FrsFragment.this.gYO.bVT() == 0 || FrsFragment.this.gYO.bVQ() == null || !(FrsFragment.this.gYO.bVQ().fragment instanceof BaseFragment) || !((BaseFragment) FrsFragment.this.gYO.bVQ().fragment).isPrimary() || FrsFragment.this.gYw.bQa()) {
                    if (FrsFragment.this.gYO.bVT() != 0) {
                        FrsFragment.this.gYy.hide();
                        return;
                    }
                    return;
                }
                FrsFragment.this.gYy.show();
            }
        }
    };
    private CustomMessageListener gZu = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.FrsFragment.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 1) {
                    FrsFragment.this.bON();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                }
            }
        }
    };
    private final ao gZv = new ao() { // from class: com.baidu.tieba.frs.FrsFragment.40
        @Override // com.baidu.tieba.frs.ao
        public void a(int i, int i2, av avVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
            FrsFragment.this.bOz();
            if (FrsFragment.this.gYU != null) {
                FrsFragment.this.gYN.nq(FrsFragment.this.gYU.tM(i));
            }
            com.baidu.tieba.tbadkCore.f fVar = new com.baidu.tieba.tbadkCore.f();
            if (avVar != null) {
                fVar.isSuccess = avVar.errCode == 0;
                fVar.errorCode = avVar.errCode;
                fVar.errorMsg = avVar.errMsg;
                if (fVar.isSuccess) {
                    if (com.baidu.tbadk.core.util.v.isEmpty(arrayList)) {
                        FrsFragment.this.gYw.bmo();
                    } else if (avVar.hasMore) {
                        if (com.baidu.tbadk.core.util.v.getCount(FrsFragment.this.gXU.getThreadList()) > 3) {
                            FrsFragment.this.gYw.bmm();
                        } else {
                            FrsFragment.this.gYw.bPT();
                        }
                    } else if (avVar.hcB) {
                        FrsFragment.this.gYw.bmn();
                    } else {
                        FrsFragment.this.gYw.bmo();
                    }
                }
            } else {
                avVar = new av();
                avVar.pn = 1;
                avVar.hasMore = false;
                avVar.hcB = false;
            }
            if (i == 1) {
                FrsFragment.this.gYI = true;
                FrsFragment.this.gZJ.a(FrsFragment.this.gYM.getType(), false, fVar);
            } else {
                FrsFragment.this.a(fVar);
                if (FrsFragment.this.gYM.bTv() != null) {
                    FrsFragment.this.gXU = FrsFragment.this.gYM.bTv();
                }
                FrsFragment.this.bOP();
            }
            if (FrsFragment.this.gZR != null) {
                FrsFragment.this.gZR.a(i, i2, avVar, arrayList);
            }
        }
    };
    private FrsTabViewController.a gZw = new FrsTabViewController.a() { // from class: com.baidu.tieba.frs.FrsFragment.41
        @Override // com.baidu.tieba.frs.vc.FrsTabViewController.a
        public void mN(int i) {
            boolean z = false;
            if (i != 1) {
                com.baidu.tieba.card.r.bEX().lx(false);
                FrsFragment.this.mo(false);
            }
            if (i == 502) {
                FrsFragment.this.gYx.setIconFade(R.drawable.btn_frs_professional_edit_n);
            } else {
                FrsFragment.this.gYx.setIconFade(0);
            }
            FrsFragment.this.gZx = i;
            FrsFragment.this.bOS();
            com.baidu.tieba.frs.d.d.hgM.hud = i;
            com.baidu.tieba.frs.d.d.hgM.hue = -1;
            com.baidu.tieba.frs.a bNC = com.baidu.tieba.frs.a.bNC();
            if (i == 1 && FrsFragment.this.gZn) {
                z = true;
            }
            bNC.I(z, true);
        }
    };
    private CustomMessageListener gZy = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIVE_COUNT) { // from class: com.baidu.tieba.frs.FrsFragment.42
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                FrsFragment.this.gYO.uX(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    };
    private CustomMessageListener gZz = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_LIVE_START) { // from class: com.baidu.tieba.frs.FrsFragment.43
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && ((Integer) customResponsedMessage.getData()).intValue() == 51 && FrsFragment.this.gXU != null) {
                com.baidu.tieba.frs.f.j.a(FrsFragment.this.gXU, FrsFragment.this.getPageContext());
            }
        }
    };
    private final CustomMessageListener gZA = new CustomMessageListener(CmdConfigCustom.CMD_FRS_SELECT_ALA_LIVE_TAB) { // from class: com.baidu.tieba.frs.FrsFragment.44
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                FrsFragment.this.gYO.uV(49);
            }
        }
    };
    private final CustomMessageListener gZB = new CustomMessageListener(CmdConfigCustom.CMD_FRS_EXPERIENCE_TIP) { // from class: com.baidu.tieba.frs.FrsFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.u) && FrsFragment.this.gXU != null) {
                FrsFragment.this.gXU.updateLikeData((com.baidu.tieba.tbadkCore.u) customResponsedMessage.getData());
                FrsFragment.this.gYN.i(FrsFragment.this.gXU);
                FrsFragment.this.gYO.a(FrsFragment.this.gXU, FrsFragment.this.gYM.bTZ());
            }
        }
    };
    private final AntiHelper.a gZC = new AntiHelper.a() { // from class: com.baidu.tieba.frs.FrsFragment.3
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).af("obj_locate", at.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).af("obj_locate", at.a.LOCATE_LIKE_PERSON));
        }
    };
    private CustomMessageListener gZD = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.FrsFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(FrsFragment.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().dOt != null) {
                        if (AntiHelper.a(FrsFragment.this.getActivity(), updateAttentionMessage.getData().dOt, FrsFragment.this.gZC) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).af("obj_locate", at.a.LOCATE_LIKE_PERSON));
                        }
                    } else if (updateAttentionMessage.getData().isSucc && updateAttentionMessage.getData().isAttention) {
                        com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getPageContext().getPageActivity(), (int) R.string.attention_success);
                    }
                }
            }
        }
    };
    private CustomMessageListener gZE = new CustomMessageListener(CmdConfigCustom.CMD_GET_ENSURE_CAST_ID) { // from class: com.baidu.tieba.frs.FrsFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsFragment.this.refresh();
        }
    };
    private CustomMessageListener gZF = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.frs.FrsFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && !((PostWriteCallBackData) customResponsedMessage.getData()).isDyamicCallback()) {
                FrsFragment.this.gYw.c((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener gZG = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_REMIND) { // from class: com.baidu.tieba.frs.FrsFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewsRemindMessage newsRemindMessage;
            if (customResponsedMessage != null && (customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626 && (newsRemindMessage = (NewsRemindMessage) customResponsedMessage) != null) {
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (FrsFragment.this.gYw != null) {
                    FrsFragment.this.gYw.G(notificationCount, z);
                }
            }
        }
    };
    private final CustomMessageListener gZH = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.frs.FrsFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.isResumed()) {
                FrsFragment.this.bPh();
            }
        }
    };
    private CustomMessageListener gZI = new CustomMessageListener(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER) { // from class: com.baidu.tieba.frs.FrsFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (FrsFragment.this.gYw != null) {
                    FrsFragment.this.gYw.setExpanded(booleanValue);
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.q gZJ = new com.baidu.tieba.tbadkCore.q() { // from class: com.baidu.tieba.frs.FrsFragment.10
        private long startTime = 0;

        @Override // com.baidu.tieba.tbadkCore.q
        public void tf(int i) {
            this.startTime = System.nanoTime();
            if (FrsFragment.this.gYw != null) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsFragment.this.gYw.bPD();
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
            if (FrsFragment.this.eSb) {
                FrsFragment.this.eSb = false;
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.gYw, FrsFragment.this.gXU, FrsFragment.this.getForumId(), false, null);
            }
            FrsFragment.this.bOz();
            FrsFragment.this.gYF = true;
            if (fVar != null && fVar.isSuccess) {
                FrsFragment.this.gYw.bPQ().mX(com.baidu.tbadk.core.util.ar.aOS().aOT());
                FrsFragment.gYC = 0L;
                FrsFragment.gYD = 0L;
                FrsFragment.mNetError = 0;
            } else {
                FrsFragment.mNetError = 1;
            }
            if (!FrsFragment.this.gYM.bUd() && (i == 3 || i == 6)) {
                FrsFragment.this.gYX.resetData();
            }
            FrsFragment.this.gYA = System.currentTimeMillis();
            if (FrsFragment.this.gYM.bTv() != null) {
                FrsFragment.this.gXU = FrsFragment.this.gYM.bTv();
            }
            FrsFragment.this.gYw.b(FrsFragment.this.gXU.getRedpacketRainData());
            FrsFragment.this.tb(1);
            if (i == 7) {
                FrsFragment.this.tc(FrsFragment.this.gXU.getFrsDefaultTabId());
                return;
            }
            if (FrsFragment.this.gXU.getPage() != null) {
                FrsFragment.this.setHasMore(FrsFragment.this.gXU.getPage().aJy());
            }
            if (i == 4) {
                if (!FrsFragment.this.gYM.bUd() && TbadkCoreApplication.getInst().isRecAppExist() && FrsFragment.this.gYM.bTU() == 1) {
                    FrsFragment.this.gXU.addRecommendAppToThreadList(FrsFragment.this);
                }
                ArrayList<com.baidu.adp.widget.ListView.m> a2 = FrsFragment.this.gYX.a(false, false, FrsFragment.this.gXU.getThreadList(), FrsFragment.this.gYs, false);
                if (a2 != null) {
                    FrsFragment.this.gXU.setThreadList(a2);
                    FrsFragment.this.gXU.checkLiveStageInThreadList();
                }
                if (FrsFragment.this.gYM != null) {
                    com.baidu.tieba.frs.d.c.a(FrsFragment.this.gXU, FrsFragment.this.gYM.bTZ(), 2, FrsFragment.this.getContext());
                }
                com.baidu.tieba.frs.f.a.a(FrsFragment.this, FrsFragment.this.gXU.getForum(), FrsFragment.this.gXU.getThreadList(), false, FrsFragment.this.getPn());
                FrsFragment.this.gYw.a(a2, FrsFragment.this.gXU);
                FrsFragment.this.bOA();
                return;
            }
            FrsFragment.this.bOA();
            switch (i) {
                case 1:
                    FrsFragment.this.gYw.bPD();
                    break;
                case 2:
                    FrsFragment.this.gYw.bPD();
                    break;
                case 3:
                case 6:
                    if (FrsFragment.this.gXU != null) {
                        FrsFragment.this.gXU.clearPostThreadCount();
                    }
                    if (FrsFragment.this.gZc != null) {
                        FrsFragment.this.gZc.refresh();
                        break;
                    }
                    break;
            }
            FrsFragment.this.bOI();
            if (fVar == null || fVar.errorCode == 0) {
                if (FrsFragment.this.gXU != null) {
                    if (!FrsFragment.this.a(FrsFragment.this.gXU)) {
                        FrsFragment.this.bOH();
                    }
                    FrsFragment.this.L(false, i == 5);
                    if (FrsFragment.this.gYM != null) {
                        if (FrsFragment.this.gXU.getActivityHeadData() != null && FrsFragment.this.gXU.getActivityHeadData().aIL() != null && FrsFragment.this.gXU.getActivityHeadData().aIL().size() > 0) {
                            com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), 1, FrsFragment.this.gXU.getForum(), FrsFragment.this.gYM.getSortType(), 1);
                        }
                        if (FrsFragment.this.gXU.getThreadList() != null && FrsFragment.this.gXU.getThreadList().size() > 0) {
                            Iterator<com.baidu.adp.widget.ListView.m> it = FrsFragment.this.gXU.getThreadList().iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    com.baidu.adp.widget.ListView.m next = it.next();
                                    if ((next instanceof bj) && ((bj) next).getType() == bj.dsF) {
                                        com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), 1, FrsFragment.this.gXU.getForum(), FrsFragment.this.gYM.getSortType(), 2);
                                    }
                                }
                            }
                        }
                        com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), FrsFragment.this.gXU.getThreadList(), FrsFragment.this.gXU.getForum(), FrsFragment.this.gYM.getSortType());
                    }
                    FrsFragment.this.gYw.tp(i);
                    FrsFragment.gYC = (System.nanoTime() - this.startTime) / TimeUtils.NANOS_PER_MS;
                    if (fVar != null) {
                        FrsFragment.gYD = fVar.kQg;
                    }
                } else {
                    return;
                }
            } else if (FrsFragment.this.gXU == null || com.baidu.tbadk.core.util.v.isEmpty(FrsFragment.this.gXU.getThreadList())) {
                FrsFragment.this.a(fVar);
            } else if (fVar.gIA) {
                FrsFragment.this.showToast(FrsFragment.this.getPageContext().getResources().getString(R.string.net_error_text, fVar.errorMsg, Integer.valueOf(fVar.errorCode)));
            }
            FrsFragment.this.bOE();
            FrsFragment.this.bOF();
            if (FrsFragment.this.gXU.getAccessFlag() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11384"));
            }
            if (FrsFragment.this.gYt && FrsFragment.this.gYO.uV(49)) {
                FrsFragment.this.gYt = false;
            }
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.q
        public void c(com.baidu.tieba.tbadkCore.m mVar) {
            if ((mVar != null && ("normal_page".equals(FrsFragment.this.gYM.getPageType()) || "frs_page".equals(FrsFragment.this.gYM.getPageType()) || "book_page".equals(FrsFragment.this.gYM.getPageType()))) || "brand_page".equals(FrsFragment.this.gYM.getPageType())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE, mVar));
                FrsFragment.this.b(mVar);
                FrsFragment.gYz = mVar;
            }
        }
    };
    private final CustomMessageListener gZK = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.frs.FrsFragment.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.k) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                FrsFragment.this.gXU.updateCurrentUserPendant((com.baidu.tbadk.data.k) customResponsedMessage.getData());
                FrsFragment.this.gYw.bPQ().notifyDataSetChanged();
            }
        }
    };
    private final CustomMessageListener mMemListener = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_MEM) { // from class: com.baidu.tieba.frs.FrsFragment.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && FrsFragment.this.gXU != null && (userData = FrsFragment.this.gXU.getUserData()) != null) {
                userData.setIsMem(num.intValue());
                if (num.intValue() != 0) {
                    FrsFragment.this.gYN.k(num);
                }
            }
        }
    };
    private final f.a gZL = new f.a() { // from class: com.baidu.tieba.frs.FrsFragment.21
        @Override // com.baidu.tbadk.BdToken.f.a
        public void B(HashMap<String, Object> hashMap) {
            if (hashMap != null && (hashMap.get(com.baidu.tbadk.BdToken.f.dhA) instanceof String)) {
                FrsFragment.this.gYo = (String) hashMap.get(com.baidu.tbadk.BdToken.f.dhA);
            }
        }
    };
    private final com.baidu.tieba.frs.mc.k gZM = new com.baidu.tieba.frs.mc.k() { // from class: com.baidu.tieba.frs.FrsFragment.22
        @Override // com.baidu.tieba.frs.mc.k
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.m> arrayList, boolean z3) {
            if (FrsFragment.this.gYQ != null && FrsFragment.this.gYM != null && FrsFragment.this.gYM.bUd() && z && !z2 && !z3) {
                FrsFragment.this.gYQ.uu(i2);
            }
        }
    };
    public final View.OnTouchListener dSb = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.FrsFragment.24
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (FrsFragment.this.gZe != null) {
                FrsFragment.this.gZe.onTouch(view, motionEvent);
            }
            if (FrsFragment.this.gYS != null && FrsFragment.this.gYS.bQy() != null) {
                FrsFragment.this.gYS.bQy().onTouchEvent(motionEvent);
            }
            if (FrsFragment.this.fhm != null) {
                FrsFragment.this.fhm.c(view, motionEvent);
            }
            if (FrsFragment.this.gYN != null) {
                FrsFragment.this.gYN.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private final CustomMessageListener gZN = new CustomMessageListener(CmdConfigCustom.CMD_GOTOLIVE_HOST_UPGRADE) { // from class: com.baidu.tieba.frs.FrsFragment.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.aNT().getInt(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.PHOTOLIVE_HOSTLEVEL, -1) != -1 && FrsFragment.this.gXU.getForum() != null) {
                FrsFragment.this.gXU.getForum().setCanAddPhotoLivePost(true);
            }
        }
    };
    public final View.OnClickListener gZO = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.27
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsFragment.this.gYw != null && view == FrsFragment.this.gYw.bPB() && FrsFragment.this.getActivity() != null) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, FrsFragment.this.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            if (view.getId() == R.id.game_activity_egg_layout && com.baidu.adp.lib.util.l.isNetOk()) {
                TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_CLICK);
                if (FrsFragment.this.gYw == null || !FrsFragment.this.gYw.bPN()) {
                    String activityUrl = FrsFragment.this.gXU.getForum().getYuleData().aMO().getActivityUrl();
                    if (!StringUtils.isNull(activityUrl)) {
                        com.baidu.tbadk.browser.a.startInternalWebActivity(FrsFragment.this.getPageContext().getPageActivity(), activityUrl);
                    }
                } else {
                    FrsFragment.this.gYw.bPO();
                }
            }
            if (FrsFragment.this.gYw != null && view == FrsFragment.this.gYw.bPU() && FrsFragment.this.gYM != null && FrsFragment.this.gYM.hasMore()) {
                FrsFragment.this.gYw.bmm();
                FrsFragment.this.bkZ();
            }
            if (view != null && FrsFragment.this.gYw != null && view == FrsFragment.this.gYw.bPK()) {
                if (bc.checkUpIsLogin(FrsFragment.this.getContext())) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).af("obj_locate", 2));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MessageCenterActivityConfig(FrsFragment.this.getContext())));
                } else {
                    return;
                }
            }
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (FrsFragment.this.gXU != null && FrsFragment.this.gXU.getForum() != null) {
                    if (FrsFragment.this.gYw != null && view == FrsFragment.this.gYw.bPI()) {
                        if (FrsFragment.this.gXU != null && FrsFragment.this.gXU.getForum() != null && !StringUtils.isNull(FrsFragment.this.gXU.getForum().getId()) && !StringUtils.isNull(FrsFragment.this.gXU.getForum().getName())) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_SHARE_CLICK).cI("fid", FrsFragment.this.gXU.getForum().getId()).af("obj_locate", 11));
                            com.baidu.tieba.frs.f.e.a(FrsFragment.this.getPageContext(), FrsFragment.this.gXU, FrsFragment.this.gXU.getForum().getId());
                        } else {
                            return;
                        }
                    }
                    if (FrsFragment.this.gYw != null && view == FrsFragment.this.gYw.bPH()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12402").cI("fid", FrsFragment.this.gXU.getForum().getId()).cI("uid", TbadkCoreApplication.getCurrentAccount()).cI("fname", FrsFragment.this.gXU.getForum().getName()));
                        if (!StringUtils.isNull(FrsFragment.this.gXU.getForum().getName())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PostSearchActivityConfig(FrsFragment.this.getContext(), FrsFragment.this.gXU.getForum().getName(), FrsFragment.this.gXU.getForum().getId())));
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
        private int hac = 0;
        private int eNZ = 0;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsFragment.this.gZr += i2;
            if (FrsFragment.this.gZr >= FrsFragment.this.cCL * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
            if (FrsFragment.this.gYV != null) {
                FrsFragment.this.gYV.bUQ();
            }
            this.hac = 0;
            this.eNZ = 0;
            if (recyclerView != null && (recyclerView instanceof BdRecyclerView)) {
                this.hac = ((BdRecyclerView) recyclerView).getFirstVisiblePosition();
                this.eNZ = ((BdRecyclerView) recyclerView).getLastVisiblePosition();
            }
            if (FrsFragment.this.gZg != null) {
                FrsFragment.this.gZg.a(recyclerView, this.hac, this.eNZ);
            }
            if (FrsFragment.this.gXU != null && FrsFragment.this.gYw != null && FrsFragment.this.gYw.bPQ() != null) {
                FrsFragment.this.gYw.bL(this.hac, this.eNZ);
                if (FrsFragment.this.gYL != null && FrsFragment.this.gYL.rD() != null) {
                    FrsFragment.this.gYL.rD().b(FrsFragment.this.gYK);
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (FrsFragment.this.gYN != null) {
                FrsFragment.this.gYN.setScrollState(i);
            }
            if ((i == 2 || i == 1) && !FrsFragment.this.gYG) {
                FrsFragment.this.gYG = true;
                FrsFragment.this.gYw.bPS();
            }
            if (FrsFragment.this.gYH == null && !FrsFragment.this.bPa()) {
                FrsFragment.this.gYH = new com.baidu.tbadk.n.b();
                FrsFragment.this.gYH.setSubType(1000);
            }
            if (i == 0) {
                if (FrsFragment.this.gYH != null) {
                    FrsFragment.this.gYH.aZp();
                }
                com.baidu.tieba.card.r.bEX().lx(true);
                FrsFragment.this.mo(true);
                FrsFragment.this.gYw.bK(this.hac, this.eNZ);
            } else if (FrsFragment.this.gYH != null) {
                FrsFragment.this.gYH.aZo();
            }
            if (FrsFragment.this.gZg != null) {
                FrsFragment.this.gZg.onScrollStateChanged(recyclerView, i);
            }
            if (i == 0) {
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.gYw, FrsFragment.this.gXU, FrsFragment.this.getForumId(), false, null);
            }
            if (FrsFragment.this.gYO != null && i == 1) {
                FrsFragment.this.gYO.bVS();
            }
            if (FrsFragment.this.gYL == null) {
                if (FrsFragment.this.gYw.bPu() != null && !FrsFragment.this.gYw.bOY() && FrsFragment.this.gYw.bPu().cJF() != null && (FrsFragment.this.gYw.bPu().cJF().getTag() instanceof com.baidu.card.af)) {
                    FrsFragment.this.gYL = (com.baidu.card.af) FrsFragment.this.gYw.bPu().cJF().getTag();
                }
            } else if (i == 0 && FrsFragment.this.gYw.bPu() != null && !FrsFragment.this.gYw.bOY() && FrsFragment.this.gYw.bPu().cJF() != null && (FrsFragment.this.gYw.bPu().cJF().getTag() instanceof com.baidu.card.af)) {
                FrsFragment.this.gYL = (com.baidu.card.af) FrsFragment.this.gYw.bPu().cJF().getTag();
            }
            if (i == 1) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921418));
            }
        }
    };
    private final d gZP = new d() { // from class: com.baidu.tieba.frs.FrsFragment.29
        @Override // com.baidu.tieba.frs.d
        public void a(int i, int i2, View view, View view2, bj bjVar) {
            if (i != FrsFragment.this.gYw.bPQ().bRT()) {
                if (i != FrsFragment.this.gYw.bPQ().bRU()) {
                    if (i == FrsFragment.this.gYw.bPQ().bRR() && FrsFragment.this.gXU != null && FrsFragment.this.gXU.getUserData() != null && FrsFragment.this.gXU.getUserData().isBawu()) {
                        String bawuCenterUrl = FrsFragment.this.gXU.getBawuCenterUrl();
                        if (!com.baidu.tbadk.core.util.aq.isEmpty(bawuCenterUrl) && FrsFragment.this.gXU.getForum() != null) {
                            com.baidu.tbadk.browser.a.startWebActivity(FrsFragment.this.getPageContext().getPageActivity(), bawuCenterUrl);
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10502").cI("fid", FrsFragment.this.gXU.getForum().getId()).cI("uid", FrsFragment.this.gXU.getUserData().getUserId()));
                        }
                    }
                } else if (bc.checkUpIsLogin(FrsFragment.this.getPageContext().getPageActivity())) {
                    TiebaStatic.log(CommonStatisticKey.MY_SERVICE_CK);
                    if (FrsFragment.this.gXU != null && FrsFragment.this.gXU.getForum() != null) {
                        ForumData forum = FrsFragment.this.gXU.getForum();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(forum.getId(), 0L), forum.getName(), forum.getImage_url(), 0)));
                    }
                }
            } else if (bc.checkUpIsLogin(FrsFragment.this.getActivity())) {
                TiebaStatic.log("forum_fortune_click");
                com.baidu.tieba.frs.f.i.b(FrsFragment.this.getPageContext(), FrsFragment.this.gXU);
            }
        }
    };
    private final NoNetworkView.a gVS = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.FrsFragment.30
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (FrsFragment.this.gYM.bTU() == 1 && z && !FrsFragment.this.gYw.bOY()) {
                if (FrsFragment.this.gXU == null || com.baidu.tbadk.core.util.v.isEmpty(FrsFragment.this.gXU.getThreadList())) {
                    FrsFragment.this.hideNetRefreshView(FrsFragment.this.gYw.bCr());
                    FrsFragment.this.showLoadingView(FrsFragment.this.gYw.bCr(), true);
                    FrsFragment.this.gYw.my(false);
                    FrsFragment.this.refresh();
                    return;
                }
                FrsFragment.this.gYw.bPD();
            }
        }
    };
    private final CustomMessageListener dOP = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.FrsFragment.31
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                com.baidu.tieba.frs.f.c.a(customResponsedMessage, FrsFragment.this.gYw, FrsFragment.this.gXU);
            }
        }
    };
    private com.baidu.adp.widget.ListView.v gZQ = new a();
    private ao gZR = new ao() { // from class: com.baidu.tieba.frs.FrsFragment.33
        @Override // com.baidu.tieba.frs.ao
        public void a(int i, int i2, av avVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
            com.baidu.adp.lib.f.e.lb().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.33.1
                @Override // java.lang.Runnable
                public void run() {
                    if (FrsFragment.this.gYw != null && FrsFragment.this.gYw.bPV()) {
                        FrsFragment.this.bkZ();
                    }
                }
            });
        }
    };
    private CustomMessageListener gZS = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.frs.FrsFragment.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    FrsFragment.this.gZh = true;
                }
            }
        }
    };
    private CustomMessageListener gZT = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.frs.FrsFragment.36
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                    if (FrsFragment.this.gYL == null && FrsFragment.this.gYw.bPu() != null && !FrsFragment.this.gYw.bOY() && FrsFragment.this.gYw.bPu().cJF() != null && (FrsFragment.this.gYw.bPu().cJF().getTag() instanceof com.baidu.card.af)) {
                        FrsFragment.this.gYL = (com.baidu.card.af) FrsFragment.this.gYw.bPu().cJF().getTag();
                    }
                    if (FrsFragment.this.gYL != null && FrsFragment.this.gYL.rD() != null) {
                        FrsFragment.this.gYL.rD().b(new a.C0095a(3));
                    }
                }
            }
        }
    };
    private CustomMessageListener gZU = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.FrsFragment.37
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.gYw != null) {
                FrsFragment.this.gYw.wJ();
            }
        }
    };
    private CustomMessageListener gZV = new CustomMessageListener(2921437) { // from class: com.baidu.tieba.frs.FrsFragment.38
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && FrsFragment.this.isResumed()) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (FrsFragment.this.gYy != null) {
                    if (booleanValue) {
                        if (FrsFragment.this.gYO.bVT() != 0 && !FrsFragment.this.gYw.bQa()) {
                            FrsFragment.this.gYy.show();
                            return;
                        }
                        return;
                    }
                    FrsFragment.this.gYy.hide();
                }
            }
        }
    };
    private CustomMessageListener gZW = new CustomMessageListener(2001223) { // from class: com.baidu.tieba.frs.FrsFragment.39
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Date)) {
                FrsFragment.this.gZq = (Date) customResponsedMessage.getData();
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.frs.loadmore.a
    public /* bridge */ /* synthetic */ com.baidu.adp.base.e getPageContext() {
        return super.getPageContext();
    }

    public com.baidu.tieba.frs.entelechy.b.b bOn() {
        return this.gYU;
    }

    public com.baidu.adp.widget.ListView.v bOo() {
        return this.gZQ;
    }

    public com.baidu.tieba.frs.mc.d bOp() {
        return this.gYW;
    }

    public com.baidu.tieba.frs.smartsort.a bOq() {
        return this.gYQ;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public FrsModelController bOr() {
        return this.gYM;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public com.baidu.tieba.frs.mc.c bOs() {
        return this.gYX;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public com.baidu.tieba.frs.vc.h bOt() {
        return this.gYN;
    }

    public FrsTabViewController bOu() {
        return this.gYO;
    }

    public aq bOv() {
        return this.gYS;
    }

    public void mn(boolean z) {
        this.gZp = z;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public n bOw() {
        return this.gYw;
    }

    @Override // com.baidu.tieba.frs.ap
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.ap, com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.gYo;
    }

    public void setForumName(String str) {
        this.gYo = str;
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
        if (this.gYX == null) {
            return 1;
        }
        return this.gYX.getPn();
    }

    public int getPn() {
        if (this.gYX == null) {
            return 1;
        }
        return this.gYX.getPn();
    }

    public void setPn(int i) {
        if (this.gYX != null) {
            this.gYX.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.gYX != null) {
            this.gYX.setHasMore(i);
        }
    }

    public int bOx() {
        if (this.gYX == null) {
            return -1;
        }
        return this.gYX.bOx();
    }

    public boolean bOy() {
        return this.gYu;
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
            this.gYw.bPx();
            showNetRefreshView(this.gYw.bCr(), string, true);
        } else if (340001 == fVar.errorCode) {
            a(fVar, this.gXU.getRecm_forum_list());
        } else {
            if (com.baidu.tbadk.core.util.v.isEmpty(this.gXU.getThreadList())) {
                b(fVar);
            }
            if (bPa()) {
                setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds280));
            } else {
                setNetRefreshViewEmotionDefMarginTop();
            }
        }
    }

    public void a(View view, String str, boolean z, List<RecmForumInfo> list) {
        this.gYw.bPx();
        this.gYw.tl(8);
        if (this.gZf == null) {
            this.gZf = new com.baidu.tieba.frs.view.a(getPageContext(), getNetRefreshListener());
        }
        this.gZf.setSubText(str);
        this.gZf.cE(list);
        this.gZf.attachView(view, z);
    }

    private void a(com.baidu.tieba.tbadkCore.f fVar, List<RecmForumInfo> list) {
        if (this.gYw != null) {
            this.gYw.bPx();
            this.gYw.setTitle(this.gYo);
            a(this.gYw.bCr(), fVar.errorMsg, true, list);
        }
    }

    private void b(com.baidu.tieba.tbadkCore.f fVar) {
        this.gYw.bPx();
        if (fVar.gIA) {
            showNetRefreshView(this.gYw.bCr(), TbadkCoreApplication.getInst().getString(R.string.net_error_text, new Object[]{fVar.errorMsg, Integer.valueOf(fVar.errorCode)}), true);
        } else {
            showNetRefreshView(this.gYw.bCr(), fVar.errorMsg, true);
        }
    }

    public void bOz() {
        hideLoadingView(this.gYw.bCr());
        this.gYw.blx();
        if (this.gYw.bPv() instanceof com.baidu.tieba.frs.tab.c) {
            ((com.baidu.tieba.frs.tab.c) this.gYw.bPv()).bUx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOA() {
        if (bOx() == 0 && com.baidu.tbadk.core.util.v.isEmpty(this.gXU.getThreadListIds())) {
            if (com.baidu.tbadk.core.util.v.isEmpty(this.gXU.getThreadList())) {
                this.gYw.bmo();
            } else {
                this.gYw.bmn();
            }
        } else if (com.baidu.tbadk.core.util.v.getCount(this.gXU.getThreadList()) > 3) {
            this.gYw.bmm();
        } else {
            this.gYw.bPT();
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
            bOz();
            this.gYw.bPD();
            com.baidu.tieba.tbadkCore.f bTQ = this.gYM.bTQ();
            boolean isEmpty = com.baidu.tbadk.core.util.v.isEmpty(this.gXU.getThreadList());
            if (bTQ != null && isEmpty) {
                if (this.gYM.bTS() != 0) {
                    this.gYM.bTX();
                    this.gYw.bPD();
                } else {
                    a(bTQ);
                }
                this.gYw.M(this.gXU.isStarForum(), false);
                return;
            }
            a(bTQ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(com.baidu.tieba.tbadkCore.m mVar) {
        if (mVar != null && mVar.getEntelechyTabInfo() != null && mVar.getEntelechyTabInfo().tab != null) {
            for (FrsTabInfo frsTabInfo : mVar.getEntelechyTabInfo().tab) {
                if (frsTabInfo.tab_id.intValue() == 502 && com.baidu.tbadk.core.sharedPref.b.aNT().getBoolean("first_into_tab_profession", true)) {
                    return false;
                }
            }
        }
        return new com.baidu.tieba.frs.ad.f(getTbPageContext()).d(mVar);
    }

    public boolean bOB() {
        return bOC() && !bOD();
    }

    private boolean bOC() {
        if (bOX() == null) {
            return false;
        }
        FrsViewData bOX = bOX();
        com.baidu.tbadk.core.data.t tVar = null;
        if (bOX.getStar() != null && !StringUtils.isNull(bOX.getStar().cVE())) {
            tVar = new com.baidu.tbadk.core.data.t();
        } else if (bOX.getActivityHeadData() != null && com.baidu.tbadk.core.util.v.getCount(bOX.getActivityHeadData().aIL()) >= 1) {
            tVar = bOX.getActivityHeadData().aIL().get(0);
        }
        return tVar != null;
    }

    public boolean bOD() {
        if (bOX() == null) {
            return false;
        }
        FrsViewData bOX = bOX();
        return (com.baidu.tbadk.core.util.v.isEmpty(bOX.getShowTopThreadList()) && bOX.getBusinessPromot() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOE() {
        boolean b;
        if (!bOG()) {
            final PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
            privateForumPopInfoData.a(this.gXU.getPrivateForumTotalInfo().getPrivatePopInfo());
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(getActivity());
            if (this.gXU.getPrivateForumTotalInfo().aJF().private_forum_status.intValue() == 1 && (com.baidu.tbadk.core.util.aq.isEmpty(privateForumPopInfoData.aJH()) || privateForumPopInfoData.aJK() != Integer.valueOf(this.forumId))) {
                privateForumPopInfoData.tO("create_success");
                privateForumPopInfoData.tP(TbadkCoreApplication.getInst().getString(R.string.frs_private_create_hint));
                privateForumPopInfoData.tQ("https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.gYo + "&nomenu=1");
                privateForumPopInfoData.g(Integer.valueOf(this.forumId));
                b = frsPrivateCommonDialogView.b(privateForumPopInfoData);
            } else {
                b = privateForumPopInfoData.aJK() == Integer.valueOf(this.forumId) ? frsPrivateCommonDialogView.b(privateForumPopInfoData) : false;
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
                        ba.aOV().b(FrsFragment.this.getPageContext(), new String[]{privateForumPopInfoData.aJJ()});
                        aVar.dismiss();
                    }
                });
                aVar.a(new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.13
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(getPageContext()).aMS();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOF() {
        if (bOG() || this.gXU.getPrivateForumTotalInfo().aJF().private_forum_status.intValue() != 1) {
            a((Integer) null, (Integer) null, true);
        } else {
            a(this.gXU.getPrivateForumTotalInfo().aJF().private_forum_audit_status, this.gXU.getPrivateForumTotalInfo().aJG(), false);
        }
    }

    public void a(Integer num, Integer num2, boolean z) {
        final String str;
        final int i = 2;
        if (this.gYw.bPJ() != null) {
            TextView bPJ = this.gYw.bPJ();
            if (z) {
                bPJ.setVisibility(8);
                return;
            }
            if (num.intValue() == 2) {
                bPJ.setText("修改实名认证信息");
                bPJ.setVisibility(0);
                str = "https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + this.forumId + "&nomenu=1";
            } else if (num2.intValue() >= 0 && num2.intValue() <= 100) {
                bPJ.setText("目标已完成" + String.valueOf(num2) + "%");
                bPJ.setVisibility(0);
                str = "https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.gYo + "&nomenu=1";
                i = 1;
            } else {
                bPJ.setVisibility(8);
                i = 0;
                str = "";
            }
            bPJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.14
                /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13387").cI("fid", FrsFragment.this.forumId).cI("uid", TbadkCoreApplication.getCurrentAccount()).af("obj_type", i));
                    ba.aOV().b(FrsFragment.this.getPageContext(), new String[]{str});
                }
            });
        }
    }

    private boolean bOG() {
        return this.gXU == null || this.gXU.getPrivateForumTotalInfo() == null || this.gXU.getPrivateForumTotalInfo().aJF() == null || this.gXU.getUserData().getIs_manager() != 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOH() {
        boolean z;
        boolean z2;
        if (this.gXU == null || this.gXU.getEntelechyTabInfo() == null || this.gXU.getEntelechyTabInfo().tab == null) {
            z = false;
        } else {
            z = false;
            for (FrsTabInfo frsTabInfo : this.gXU.getEntelechyTabInfo().tab) {
                if (frsTabInfo.tab_id.intValue() == 502) {
                    if (com.baidu.tbadk.core.sharedPref.b.aNT().getBoolean("first_into_tab_profession", true)) {
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
        if (z && com.baidu.tbadk.core.sharedPref.b.aNT().getBoolean("first_into_tab_general", true)) {
            j.a(getActivity(), getPageContext());
            com.baidu.tbadk.core.sharedPref.b.aNT().putBoolean("first_into_tab_general", false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tb(int i) {
        List<WindowToast> list;
        if (TbadkCoreApplication.isLogin() && this.gXU != null && (list = this.gXU.mWindowToast) != null && list.size() > 0) {
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
    public void bOI() {
        if (this.gXU == null || this.gXU.getForum() != null) {
            this.gYw.bPP();
        } else if (this.gXU.getForum().getYuleData() != null && this.gXU.getForum().getYuleData().aMN()) {
            TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_VIEW);
            this.gYw.a(this.gXU.getForum().getYuleData().aMO());
        } else {
            this.gYw.bPP();
        }
    }

    private void K(boolean z, boolean z2) {
        if (this.gYM != null && this.gXU != null && this.gYw != null && z) {
            if (!this.gYM.bUd() && this.gYM.bTU() == 1) {
                if (!this.gYM.bUb()) {
                    this.gXU.addCardVideoInfoToThreadList();
                    this.gXU.addVideoInfoToThreadListInTenAndFifteenFloor();
                }
                boolean z3 = false;
                if (this.gYw.bPQ().p(com.baidu.tieba.card.data.n.gte)) {
                    z3 = this.gXU.addHotTopicDataToThreadList();
                }
                if (!z3) {
                    this.gXU.addFeedForumDataToThreadList();
                }
                if (TbadkCoreApplication.getInst().isRecAppExist()) {
                    this.gXU.addRecommendAppToThreadList(this);
                }
                if (!this.gYw.bPQ().p(bj.dra)) {
                    this.gXU.removeAlaLiveThreadData();
                }
                this.gXU.addSchoolRecommendToThreadList();
            }
            if (!this.gYw.bPQ().p(bj.dra)) {
                this.gXU.removeAlaInsertLiveData();
                this.gXU.removeAlaStageLiveDat();
            } else {
                this.gXU.addInsertLiveDataToThreadList();
                this.gXU.addStageLiveDataToThreadList();
            }
            this.gXU.checkLiveStageInThreadList();
            this.gXU.addNoticeThreadToThreadList();
            if (this.gYw.bPQ().p(com.baidu.tieba.h.b.hCM)) {
                this.gXU.addGameRankListToThreadList(z2);
            }
            if (TbadkCoreApplication.isLogin() && (!this.gYM.bUd() || this.gYM.isNetFirstLoad)) {
                this.gXU.addUserRecommendToThreadList();
            }
            this.gXU.addVideoActivityToTop();
        }
    }

    public boolean bOJ() {
        if (this.gYN != null && this.gYM != null) {
            this.gYN.a(this.gYM.getPageType(), this.gXU);
        }
        boolean z = false;
        if (this.gXU != null) {
            z = this.gXU.hasTab();
        }
        bOL();
        if (this.gYw != null) {
            this.gYw.bQb();
            this.gYw.bQc();
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tc(int i) {
        as asVar = null;
        bOJ();
        bOS();
        try {
            if (this.gXU != null) {
                this.gYw.a((ArrayList<com.baidu.adp.widget.ListView.m>) null, this.gXU);
                this.gYN.uN(1);
                this.gYw.bPG();
                this.gYO.a(this.gXU, this.gYM.bTZ());
                com.baidu.tieba.frs.tab.d uW = this.gYO.uW(this.gXU.getFrsDefaultTabId());
                if (uW != null && !TextUtils.isEmpty(uW.url)) {
                    asVar = new as();
                    asVar.ext = uW.url;
                    asVar.stType = uW.name;
                }
                this.gYM.a(this.gXU.getFrsDefaultTabId(), 0, asVar);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(boolean z, boolean z2) {
        try {
            if (this.gXU != null && this.gYO != null && this.gYM != null) {
                if (!this.gYw.bPQ().p(bj.dra)) {
                    this.gXU.removeAlaLiveThreadData();
                }
                boolean isEmpty = com.baidu.tbadk.core.util.v.isEmpty(this.gXU.getGameTabInfo());
                this.gYw.mw(isEmpty);
                if (!isEmpty) {
                    if (this.gZg == null) {
                        this.gZg = new com.baidu.tieba.frs.vc.e(this, (NoPressedRelativeLayout) this.mRootView);
                    }
                    if (this.fhm == null) {
                        this.fhm = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
                    }
                } else {
                    this.gZg = null;
                    this.fhm = null;
                }
                if (this.gXU.getForum() != null) {
                    this.gYo = this.gXU.getForum().getName();
                    this.forumId = this.gXU.getForum().getId();
                }
                if (this.gXU.hasTab()) {
                    this.gYO.a(this.gXU, this.gYM.bTZ());
                }
                if (z) {
                    K(true, z);
                } else {
                    K(this.gYI, z);
                }
                bOJ();
                if (this.gYU != null) {
                    this.gYU.a(this.gYN, this.gXU);
                }
                if (this.gXU.getPage() != null) {
                    setHasMore(this.gXU.getPage().aJy());
                }
                ArrayList<com.baidu.adp.widget.ListView.m> a2 = this.gYX.a(z2, true, this.gXU.getThreadList(), null, z, false);
                if (a2 != null) {
                    this.gXU.setThreadList(a2);
                }
                this.gXU.removeRedundantUserRecommendData();
                this.gXW = this.gXU.getTopThreadSize();
                if (this.gYs != null) {
                    this.gYr = true;
                    this.gYs.De(this.gXW);
                    com.baidu.tieba.frs.f.a.a(this, this.gXU.getForum(), this.gXU.getThreadList(), this.gYr, getPn());
                }
                if (this.gYM.bTU() == 1) {
                    bOP();
                    if (!z && this.gYM.getPn() == 1) {
                        bOK();
                    }
                }
                if (this.gYV != null) {
                    this.gYV.cd(this.gYO.bVP());
                }
                bOz();
                this.gYw.bPy();
                this.gYw.M(true, false);
                if (z && this.gXU.isFirstTabEqualAllThread()) {
                    com.baidu.adp.lib.f.e.lb().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.15
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!FrsFragment.this.gYF && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                FrsFragment.this.gYw.bPZ();
                            }
                        }
                    });
                }
                if (this.gXU.getForum() != null) {
                    this.gYw.CU(this.gXU.getForum().getWarningMsg());
                }
                if (this.gXU != null && this.gXU.getFrsVideoActivityData() != null && com.baidu.tbadk.core.sharedPref.b.aNT().getLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 0L) == 0) {
                    com.baidu.adp.lib.f.e.lb().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.16
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsFragment.this.gYw.bPX();
                        }
                    }, 1000L);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FRS_SHOW_AR_ENTRY, this));
                this.gYw.bPs();
                if (this.gXU != null && this.gXU.getForum() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ENTER_FORUM, new VisitedForumData(this.gXU.getForum().getId(), this.gXU.getForum().getName(), this.gXU.getForum().getImage_url(), String.valueOf(System.currentTimeMillis() / 1000), ConstantData.Forum.SPECAIL_FORUM_TYPE_LIVE.equals(this.gXU.getForum().special_forum_type), this.gXU.getForum().getThemeColorInfo(), this.gXU.getForum().getMember_num())));
                }
                this.gZk.a(this.gXU.bottomMenuList, this.gXU.getForum());
                bPh();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void mo(boolean z) {
        com.baidu.tieba.s.c.cVp().b(getUniqueId(), z);
    }

    public void bOK() {
        if (this.gZa == null) {
            this.gZa = new com.baidu.tieba.frs.live.a(this, com.baidu.adp.lib.f.b.toInt(this.forumId, 0));
        }
        this.gZa.bTB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.tbadkCore.m mVar) {
        try {
            if (!this.gYF && mVar != null && this.gXU != null) {
                this.gXU.receiveData(mVar);
                L(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void bOL() {
        if (this.gYM != null) {
            CT(this.gYM.getPageType());
        } else {
            CT("normal_page");
        }
    }

    private void CT(String str) {
        mp("frs_page".equals(str));
        if (this.gYU != null) {
            this.gYU.a(this.gYN, this.gYw, this.gXU);
        }
    }

    public void mp(boolean z) {
        if (this.gYY != null) {
            this.gYY.bVD();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.s.c.cVp().w(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.frs_activity, viewGroup, false);
            this.gYi = new com.baidu.tieba.frs.entelechy.a();
            this.gYU = this.gYi.bRx();
            this.gYh = TbadkCoreApplication.getInst().getString(R.string.frs_title_new_area);
            this.gYN = new com.baidu.tieba.frs.vc.h(this, this.gYi, (FrsHeaderViewContainer) this.mRootView.findViewById(R.id.header_view_container));
            this.gYO = new FrsTabViewController(this, this.mRootView);
            this.gYO.registerListener();
            this.gYN.a(this.gYO);
            this.gYO.a(this.gZw);
            Intent intent = getActivity().getIntent();
            if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                this.gYk = true;
            }
            this.gYw = new n(this, this.gZO, this.gYi, this.gYk, this.gYN);
            this.gZk = new com.baidu.tieba.frs.brand.buttommenu.a(getPageContext(), this.mRootView);
        } else {
            if (this.mRootView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            if (this.gYO != null) {
                this.gYO.registerListener();
            }
            this.gYw.bPW();
            this.mRootView.setLeft(0);
            this.mRootView.setRight(com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getContext()));
        }
        this.gZo = true;
        this.edK = System.currentTimeMillis() - currentTimeMillis;
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        ArrayList<com.baidu.adp.widget.ListView.m> arrayList = null;
        this.gBb = System.currentTimeMillis();
        long j = this.gBb;
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.gYt = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.gBb = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            U(intent);
        }
        this.edJ = j - this.gBb;
        this.gYs = new com.baidu.tieba.tbadkCore.data.f("frs", com.baidu.tieba.tbadkCore.data.f.kRR);
        if (this.gYM == null) {
            this.gYM = new FrsModelController(this, this.gZJ);
            this.gYM.a(this.gZv);
            this.gYM.init();
        }
        this.gYM.setSchemeUrl(this.mSchemeUrl);
        if (intent != null) {
            this.gYM.ad(intent.getExtras());
        } else if (bundle != null) {
            this.gYM.ad(bundle);
        } else {
            this.gYM.ad(null);
        }
        if (intent != null) {
            this.gYN.aj(intent.getExtras());
        } else if (bundle != null) {
            this.gYN.aj(bundle);
        } else {
            this.gYN.aj(null);
        }
        this.gYv = getVoiceManager();
        this.gZb = new m(getPageContext(), this);
        initUI();
        initData(bundle);
        if (!bPa()) {
            this.gYS = new aq(getActivity(), this.gYw, this.gYN);
            this.gYS.mL(true);
        }
        this.gYv = getVoiceManager();
        if (this.gYv != null) {
            this.gYv.onCreate(getPageContext());
        }
        new com.baidu.tieba.frs.mc.i();
        int i = -1;
        if (this.gYX != null && this.gYX.bTM() != null) {
            i = this.gYX.bTM().bOx();
            arrayList = this.gYX.bTM().getDataList();
        }
        this.gYX = new com.baidu.tieba.frs.mc.c(this, this.gZM);
        this.gYX.bTM().setHasMore(i);
        if (arrayList != null && arrayList.size() > 0) {
            this.gYX.bTM().av(arrayList);
        }
        this.gYQ = new com.baidu.tieba.frs.smartsort.a(this);
        this.gYY = new com.baidu.tieba.frs.vc.j(this);
        this.gYV = new com.baidu.tieba.frs.vc.a(getPageContext(), this.gYM.bUa());
        this.gYR = new com.baidu.tieba.frs.mc.b(this);
        this.gYW = new com.baidu.tieba.frs.mc.d(this);
        this.gYP = new com.baidu.tieba.frs.mc.h(this);
        this.gYZ = new com.baidu.tieba.frs.mc.a(this);
        this.gZc = new com.baidu.tieba.frs.vc.c(this);
        this.gZd = new com.baidu.tieba.frs.mc.e(this, getUniqueId());
        this.gZi = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "frs");
        this.gZj = new com.baidu.tieba.ala.a(getPageContext());
        this.gZl = new com.baidu.tieba.frs.sportspage.notification.a(getPageContext());
        registerListener(this.gZD);
        registerListener(this.mMemListener);
        registerListener(this.gZB);
        registerListener(this.gZN);
        registerListener(this.gZK);
        registerListener(this.gZy);
        registerListener(this.gZz);
        registerListener(this.gZA);
        registerListener(this.gZs);
        registerListener(this.gZt);
        registerListener(this.adN);
        registerListener(this.gZS);
        registerListener(this.gZF);
        registerListener(this.gZu);
        registerListener(this.gZG);
        registerListener(this.gZE);
        registerListener(this.gZH);
        registerListener(this.gZI);
        this.gZT.setTag(getPageContext().getUniqueId());
        MessageManager.getInstance().registerListener(this.gZT);
        registerListener(this.gZU);
        registerListener(this.gZV);
        registerListener(this.gZW);
        this.gYw.my(false);
        if (!bPa() && !this.hasInit) {
            showLoadingView(this.gYw.bCr(), true);
            this.gYM.J(3, false);
        }
        com.baidu.tieba.frs.a.bNC().a(new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.19
            @Override // com.baidu.tieba.frs.a.b
            public void J(boolean z, boolean z2) {
                if (FrsFragment.this.gYw != null) {
                    FrsFragment.this.gYw.tm(z ? 0 : 8);
                    if (!z2) {
                        FrsFragment.this.gZn = z;
                    }
                    if (FrsFragment.this.gYw.bPQ() != null && FrsFragment.this.gYM != null && FrsFragment.this.gYM.bTV()) {
                        FrsFragment.this.gYw.bPQ().notifyDataSetChanged();
                    }
                    if (FrsFragment.this.bOu() != null) {
                        FrsTabViewController.b bVQ = FrsFragment.this.bOu().bVQ();
                        if (bVQ != null && bVQ.tabId == 502 && (bVQ.fragment instanceof FrsCommonTabFragment)) {
                            ((FrsCommonTabFragment) bVQ.fragment).bRp();
                        } else if (bVQ != null && bVQ.tabId == 503 && (bVQ.fragment instanceof FrsNewAreaFragment)) {
                            FrsNewAreaFragment frsNewAreaFragment = (FrsNewAreaFragment) bVQ.fragment;
                            frsNewAreaFragment.bRp();
                            if (frsNewAreaFragment.bUh() != null) {
                                com.baidu.tieba.frs.mc.g bUh = frsNewAreaFragment.bUh();
                                bUh.mN(!z);
                                bUh.mB(!z);
                            }
                        }
                        if (FrsFragment.this.bOu().bVI() != null) {
                            FrsFragment.this.bOu().bVI().setmDisallowSlip(z);
                            FrsFragment.this.bOu().nr(z);
                        }
                    }
                    if (FrsFragment.this.gYw.bPw() != null) {
                        FrsFragment.this.gYw.mv(!z);
                    }
                    if (FrsFragment.this.getActivity() instanceof FrsActivity) {
                        ((FrsActivity) FrsFragment.this.getActivity()).mm(!z);
                    }
                    if (FrsFragment.this.gZk != null) {
                        FrsFragment.this.gZk.mT(!z);
                    }
                    FrsFragment.this.gYw.mA(!z);
                    FrsFragment.this.gYw.mB(z ? false : true);
                }
            }

            @Override // com.baidu.tieba.frs.a.b
            public void sY(int i2) {
                if (FrsFragment.this.gYw != null) {
                    FrsFragment.this.gYw.tn(i2);
                }
            }

            @Override // com.baidu.tieba.frs.a.b
            public void bNI() {
                com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getContext(), (int) R.string.frs_multi_delete_max_num);
            }
        });
        this.gYw.b(new d.a() { // from class: com.baidu.tieba.frs.FrsFragment.20
            @Override // com.baidu.tieba.NEGFeedBack.d.a
            public void a(DeleteThreadHttpResponseMessage deleteThreadHttpResponseMessage) {
                boolean z;
                int i2 = 0;
                if (deleteThreadHttpResponseMessage != null) {
                    FrsFragment.this.gYw.beB();
                    FrsFragment.this.gYw.bPY();
                    FrsNewAreaFragment frsNewAreaFragment = null;
                    if (FrsFragment.this.gYO == null || FrsFragment.this.gYO.bVQ() == null || !(FrsFragment.this.gYO.bVQ().fragment instanceof FrsNewAreaFragment)) {
                        z = false;
                    } else {
                        frsNewAreaFragment = (FrsNewAreaFragment) FrsFragment.this.gYO.bVQ().fragment;
                        z = true;
                    }
                    if (deleteThreadHttpResponseMessage.getError() == 0) {
                        String text = !TextUtils.isEmpty(deleteThreadHttpResponseMessage.getText()) ? deleteThreadHttpResponseMessage.getText() : FrsFragment.this.getString(R.string.delete_fail);
                        if (deleteThreadHttpResponseMessage.getRetType() == 1211066) {
                            if (FrsFragment.this.grx == null) {
                                FrsFragment.this.grx = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.grx.ui(text);
                            FrsFragment.this.grx.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.20.1
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.grx.gF(false);
                            FrsFragment.this.grx.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.grx.aMS();
                        } else if (deleteThreadHttpResponseMessage.getRetType() == 1211067) {
                            if (FrsFragment.this.grx == null) {
                                FrsFragment.this.grx = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.grx.ui(text);
                            FrsFragment.this.grx.a(R.string.know, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.20.2
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.grx.gF(false);
                            FrsFragment.this.grx.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.grx.aMS();
                        } else {
                            FrsFragment.this.gYw.aJ(deleteThreadHttpResponseMessage.getText(), ContextCompat.getColor(FrsFragment.this.getContext(), deleteThreadHttpResponseMessage.getRetType() == 1 ? R.color.nav_bar_tip_error : R.color.cp_link_tip_a_alpha95));
                        }
                        if (z && frsNewAreaFragment != null) {
                            frsNewAreaFragment.cA(deleteThreadHttpResponseMessage.getSuccessItems());
                        }
                        FrsFragment.this.cp(deleteThreadHttpResponseMessage.getSuccessItems());
                        com.baidu.tieba.frs.a.bNC().co(deleteThreadHttpResponseMessage.getSuccessItems());
                        for (com.baidu.adp.widget.ListView.m mVar : FrsFragment.this.gXU.getThreadList()) {
                            if (mVar instanceof bi) {
                                i2++;
                                continue;
                            }
                            if (i2 >= 6) {
                                break;
                            }
                        }
                        if (i2 < 6) {
                            FrsFragment.this.bkZ();
                            return;
                        }
                        return;
                    }
                    com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getActivity(), deleteThreadHttpResponseMessage.getErrorString());
                }
            }
        });
        this.cCL = UtilHelper.getScreenHeight(getActivity());
        this.hasInit = true;
        td(1);
        super.onActivityCreated(bundle);
        this.createTime = System.currentTimeMillis() - j;
    }

    public void mq(boolean z) {
        if (this.gYO != null) {
            this.gYO.hyp = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cp(List<String> list) {
        if (!com.baidu.tbadk.core.util.v.isEmpty(list)) {
            ArrayList<com.baidu.adp.widget.ListView.m> threadList = this.gXU.getThreadList();
            if (!com.baidu.tbadk.core.util.v.isEmpty(threadList) && this.gYw.getListView() != null && this.gYw.getListView().getData() != null) {
                Iterator<com.baidu.adp.widget.ListView.m> it = threadList.iterator();
                List<com.baidu.adp.widget.ListView.m> data = this.gYw.getListView().getData();
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.m next = it.next();
                    if (next instanceof bi) {
                        bj bjVar = ((bi) next).dqE;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= list.size()) {
                                break;
                            } else if (!com.baidu.tbadk.core.util.aq.equals(list.get(i2), bjVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.gYX.d(next);
                                this.gYw.getListView().getAdapter().notifyItemRemoved(i);
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
    public void blt() {
        if (isAdded() && this.eSb && !isLoadingViewAttached()) {
            showLoadingView(this.gYw.bCr(), true);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void blu() {
        if (isAdded() && this.eSb && isLoadingViewAttached()) {
            hideLoadingView(this.gYw.bCr());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (bPa()) {
            showLoadingView(this.gYw.bCr(), true);
            this.gYw.to(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.gYM.J(3, true);
            aQF().scrollToPosition(0);
        }
    }

    private void td(int i) {
        String str = "";
        if (this.gXU != null && this.gXU.getForum() != null) {
            str = this.gXU.getForum().getId();
        }
        if (!StringUtils.isNull(str)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13008").cI("fid", str).cI("obj_type", "4").af("obj_locate", i).cI("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.z zVar) {
        if (zVar != null) {
            this.ehd = zVar.baA();
            this.gZe = zVar.baB();
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void showFloatingView() {
        if (this.ehd != null) {
            this.ehd.ic(true);
        }
    }

    private void U(Intent intent) {
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
                this.gYo = uri.getQueryParameter("name");
                this.mFrom = uri.getQueryParameter("from");
                if (!StringUtils.isNull(this.gYo)) {
                    intent.putExtra("name", this.gYo);
                }
                if (!StringUtils.isNull(this.mFrom)) {
                    intent.putExtra("from", this.mFrom);
                }
                TiebaStatic.log(TbadkCoreStatisticKey.AS_INVOKE_TIEBA);
            }
            if (StringUtils.isNull(this.gYo) && uri != null) {
                if (com.baidu.tbadk.BdToken.f.n(uri)) {
                    com.baidu.tbadk.BdToken.f.aGb().b(uri, this.gZL);
                } else {
                    com.baidu.tieba.frs.f.d X = com.baidu.tieba.frs.f.i.X(intent);
                    if (X != null) {
                        this.gYo = X.forumName;
                        if (X.hvT == null || X.hvT.equals("aidou")) {
                        }
                    }
                }
                if (!StringUtils.isNull(this.gYo)) {
                    intent.putExtra("name", this.gYo);
                }
                intent.putExtra(FrsActivityConfig.FRS_CALL_FROM, 12);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.gYv = getVoiceManager();
        if (this.gYv != null) {
            this.gYv.onStart(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        Intent intent;
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.dOP);
        if (bundle != null) {
            this.gYo = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
            this.gYo = intent.getStringExtra("name");
            this.mFrom = intent.getStringExtra("from");
            this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
        }
        if (getArguments() != null) {
            this.gYp = getArguments().getBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, false);
        }
        if (TextUtils.isEmpty(this.mFrom) || FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
        }
        if (this.mIsLogin) {
            registerListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL, this.dOP);
        }
        this.gYN.aj(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.s.c.cVp().x(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.gZS);
        gYz = null;
        if (this.gYv != null) {
            this.gYv.onDestory(getPageContext());
        }
        com.baidu.tieba.recapp.report.a.remove("FRS");
        this.gYv = null;
        com.baidu.tieba.card.r.bEX().lx(false);
        if (this.gXU != null && this.gXU.getForum() != null) {
            af.bQv().ee(com.baidu.adp.lib.f.b.toLong(this.gXU.getForum().getId(), 0L));
        }
        if (this.gZa != null) {
            this.gZa.onDestory();
        }
        if (this.gYw != null) {
            com.baidu.tieba.frs.f.h.a(this.gYw, this.gXU, getForumId(), false, null);
            this.gYw.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.gYH != null) {
                this.gYH.aZq();
            }
            if (this.gYw != null) {
                this.gYw.release();
            }
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.gYN.aqS();
        if (this.gYM != null) {
            this.gYM.bqr();
        }
        if (this.gYS != null) {
            this.gYS.beR();
        }
        if (this.gYV != null) {
            this.gYV.destory();
        }
        if (this.gYQ != null) {
            this.gYQ.onDestroy();
        }
        if (this.gZg != null) {
            this.gZg.onDestory();
        }
        if (this.gYZ != null) {
            this.gYZ.onDestroy();
        }
        if (this.gZi != null) {
            this.gZi.onDestroy();
        }
        if (this.gZj != null) {
            this.gZj.onDestroy();
        }
        com.baidu.tieba.recapp.d.a.cNZ().cOb();
        com.baidu.tieba.frs.f.j.bUN();
        if (this.gYO != null) {
            this.gYO.a((FrsTabViewController.a) null);
            this.gYO.bVS();
        }
        if (this.gZm != null) {
            this.gZm.onDestroy();
        }
        com.baidu.tieba.frs.a.bNC().a(null);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.gYo);
        bundle.putString("from", this.mFrom);
        this.gYM.onSaveInstanceState(bundle);
        if (this.gYv != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            this.gYv.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.gYZ != null) {
            this.gYZ.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.gYw != null) {
            this.gYw.bPD();
            this.gYw.onResume();
        }
        this.gYP.nj(true);
        this.gYI = true;
        if (gYn) {
            gYn = false;
            if (this.gYw != null) {
                this.gYw.startPullRefresh();
                return;
            }
            return;
        }
        if (this.gYv != null) {
            this.gYv.onResume(getPageContext());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_RESUME));
        if (this.gYw != null) {
            this.gYw.mC(false);
        }
        if (this.gZh) {
            refresh(6);
            this.gZh = false;
        }
        if (this.gZq != null && getActivity() != null) {
            if (NotificationManagerCompat.from(getActivity()).areNotificationsEnabled()) {
                com.baidu.tbadk.coreExtra.messageCenter.f.aUg().setSignAlertOn(true);
                com.baidu.tbadk.coreExtra.messageCenter.f.aUg().setSignAlertTime(this.gZq.getHours(), this.gZq.getMinutes());
                com.baidu.tbadk.coreExtra.messageCenter.f.aUg().a(getTbPageContext().getPageActivity(), this.gYw.bCr());
            }
            this.gZq = null;
        }
        bPh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
    }

    public boolean bOM() {
        Intent intent;
        if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
            return false;
        }
        return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
    }

    public void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.gYo = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.gYq = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.gYq) {
                bON();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bON() {
        this.gYw.startPullRefresh();
    }

    public void closeActivity() {
        com.baidu.tieba.frs.f.i.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.mFrom);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.gYw.setTitle(this.gYo);
        } else {
            this.gYw.setTitle("");
            this.mFlag = 1;
        }
        this.gYw.a(this.gZQ);
        this.gYw.addOnScrollListener(this.mScrollListener);
        this.gYw.g(this.gVS);
        this.gYw.bPQ().a(this.gZP);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gZo) {
            this.gYw.onChangeSkinType(i);
            this.gYN.uM(i);
            this.gYO.onChangeSkinType(i);
            if (this.gYy != null) {
                this.gYy.onChangeSkinType(i);
            }
            if (this.gZf != null) {
                this.gZf.onChangeSkinType();
            }
            if (this.gZk != null) {
                this.gZk.onChangeSkinType(getPageContext(), i);
            }
            if (this.grx != null) {
                com.baidu.tbadk.q.a.a(getPageContext(), this.grx.getRealView());
            }
            if (this.gZg != null) {
                this.gZg.onChangeSkinType(getPageContext(), i);
            }
        }
    }

    public void te(int i) {
        if (!this.mIsLogin) {
            if (this.gXU != null && this.gXU.getAnti() != null) {
                this.gXU.getAnti().setIfpost(1);
            }
            if (i == 0) {
                bc.skipToLoginActivity(getActivity());
            }
        } else if (this.gXU != null) {
            if (i == 0) {
                com.baidu.tieba.frs.f.j.e(this, 0);
            } else {
                this.gYw.bPF();
            }
        }
    }

    public void refresh() {
        com.baidu.tieba.a.d.bfN().ye("page_frs");
        refresh(3);
    }

    public void refresh(int i) {
        this.gYF = false;
        bOS();
        if (this.gYw != null && this.gYw.bPu() != null) {
            this.gYw.bPu().bZe();
        }
        if (this.gYM != null) {
            this.gYM.J(i, true);
        }
    }

    private void bOO() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.f.h.lc().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.26
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.KV(FrsFragment.this.gYo);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOP() {
        bOS();
        try {
            if (this.gXU != null) {
                this.gYw.bpT();
                this.gYw.mv(bPg());
                if (!com.baidu.tieba.frs.vc.h.l(this.gXU) || !com.baidu.tieba.frs.vc.h.k(this.gXU)) {
                }
                if (this.gXU.getForum() != null) {
                    this.gYo = this.gXU.getForum().getName();
                    this.forumId = this.gXU.getForum().getId();
                }
                if (this.gXU.getPage() != null) {
                    setHasMore(this.gXU.getPage().aJy());
                }
                this.gYw.setTitle(this.gYo);
                this.gYw.setForumName(this.gYo);
                TbadkCoreApplication.getInst().setDefaultBubble(this.gXU.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.gXU.getUserData().getBimg_end_time());
                bOO();
                bOQ();
                ArrayList<com.baidu.adp.widget.ListView.m> threadList = this.gXU.getThreadList();
                if (threadList != null) {
                    this.gYw.a(threadList, this.gXU);
                    com.baidu.tieba.frs.f.c.A(this.gYw);
                    this.gYN.uN(getPageNum());
                    this.gYN.i(this.gXU);
                    this.gYO.a(this.gXU, this.gYM.bTZ());
                    this.gYw.bPG();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void bOQ() {
        if (this.gXU != null) {
            if (this.gXU.getIsNewUrl() == 1) {
                this.gYw.bPQ().setFromCDN(true);
            } else {
                this.gYw.bPQ().setFromCDN(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.gYP.nj(false);
        this.gYI = false;
        this.gYw.onPause();
        if (this.gYv != null) {
            this.gYv.onPause(getPageContext());
        }
        this.gYw.mC(true);
        if (this.gYV != null) {
            this.gYV.bUQ();
        }
        com.baidu.tbadk.BdToken.c.aFN().aFS();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.gYO != null && this.gYO.bVQ() != null && (this.gYO.bVQ().fragment instanceof BaseFragment)) {
            ((BaseFragment) this.gYO.bVQ().fragment).setPrimary(z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.r.bEX().lx(false);
        mo(false);
        if (this.gXU != null && this.gXU.getForum() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            com.baidu.tbadk.distribute.a.aWB().b(getPageContext().getPageActivity(), "frs", this.gXU.getForum().getId(), 0L);
        }
        if (this.gYv != null) {
            this.gYv.onStop(getPageContext());
        }
        if (aQF() != null) {
            aQF().getRecycledViewPool().clear();
        }
        this.gYN.aPV();
        com.baidu.tbadk.util.aa.baD();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            if (this.gYN != null) {
                this.gYN.jb(isPrimary());
            }
            if (this.gYw != null) {
                this.gYw.jb(isPrimary());
                this.gYw.mC(!isPrimary());
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (com.baidu.tieba.frs.a.bNC().bND()) {
                com.baidu.tieba.frs.a.bNC().reset();
                return true;
            } else if (this.gYw != null) {
                return this.gYw.bPC();
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
        com.baidu.tbadk.distribute.a.aWB().a(advertAppInfo, this.forumId, 0L, "FRS", str, getPn());
    }

    @Override // com.baidu.tieba.recapp.m
    public void bOR() {
        bOr().bOR();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.gYv == null) {
            this.gYv = VoiceManager.instance();
        }
        return this.gYv;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdRecyclerView aQF() {
        if (this.gYw == null) {
            return null;
        }
        return this.gYw.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void bOS() {
        if (this.gYv != null) {
            this.gYv.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> aQG() {
        if (this.dJz == null) {
            this.dJz = UserIconBox.s(getPageContext().getPageActivity(), 8);
        }
        return this.dJz;
    }

    public void bOT() {
        if (getFragmentActivity() != null && getFragmentActivity().getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.p onGetPreLoadListView() {
        return aQF().getPreLoadHandle();
    }

    @Override // com.baidu.tieba.frs.am
    public NavigationBar bof() {
        if (this.gYw == null) {
            return null;
        }
        return this.gYw.bof();
    }

    public FRSRefreshButton bOU() {
        return this.gYy;
    }

    public void a(FRSRefreshButton fRSRefreshButton) {
        if (fRSRefreshButton != null) {
            this.gYy = fRSRefreshButton;
            this.gYy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.32
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (FrsFragment.this.gYO != null) {
                        FrsTabViewController.b bVQ = FrsFragment.this.gYO.bVQ();
                        if (bVQ != null && bVQ.fragment != null && (bVQ.fragment instanceof al)) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                            ((al) bVQ.fragment).bOd();
                            ((al) bVQ.fragment).bml();
                            return;
                        }
                        FrsFragment.this.bOw().startPullRefresh();
                    }
                }
            });
        }
    }

    public void bOV() {
        if (this.gYy != null) {
            this.gYy.hide();
        }
    }

    public void bOW() {
        if (this.gYy != null) {
            this.gYy.show();
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
                if (bdUniqueId == t.hbE) {
                    if (FrsFragment.this.gYw != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11752").cI("fid", FrsFragment.this.forumId).cI("obj_locate", "1"));
                        FrsFragment.this.gYw.startPullRefresh();
                    }
                } else if (mVar != null && (mVar instanceof bi)) {
                    bj bjVar = ((bi) mVar).dqE;
                    if (bjVar.aLz() == null || bjVar.aLz().getGroup_id() == 0 || bc.checkUpIsLogin(FrsFragment.this.getActivity())) {
                        if (bjVar.aLm() != 1 || bc.checkUpIsLogin(FrsFragment.this.getActivity())) {
                            if (bjVar.aKP() != null) {
                                if (bc.checkUpIsLogin(FrsFragment.this.getActivity())) {
                                    String postUrl = bjVar.aKP().getPostUrl();
                                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.isNetOk()) {
                                        com.baidu.tbadk.browser.a.startInternalWebActivity(FrsFragment.this.getActivity(), postUrl);
                                    }
                                }
                            } else if (bjVar.aLK() != null) {
                                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                    bc.skipToLoginActivity(FrsFragment.this.getPageContext().getPageActivity());
                                    return;
                                }
                                com.baidu.tbadk.core.data.p aLK = bjVar.aLK();
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), aLK.getCartoonId(), aLK.getChapterId(), 2)));
                            } else {
                                com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                                if (readThreadHistory != null && !readThreadHistory.Lb(bjVar.getId())) {
                                    readThreadHistory.La(bjVar.getId());
                                }
                                boolean z = false;
                                final String aKJ = bjVar.aKJ();
                                if (aKJ != null && !aKJ.equals("")) {
                                    z = true;
                                    new Thread(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.a.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(aKJ);
                                            xVar.aOw().aOW().mIsNeedAddCommenParam = false;
                                            xVar.aOw().aOW().mIsUseCurrentBDUSS = false;
                                            xVar.getNetData();
                                        }
                                    }).start();
                                }
                                String tid = bjVar.getTid();
                                if (tid == null) {
                                    tid = "";
                                }
                                if (bjVar.aKx() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                    ba.aOV().b(FrsFragment.this.getPageContext(), new String[]{tid, "", null});
                                    return;
                                }
                                if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB) && tid.length() > 4 && tid.length() > 4) {
                                    bjVar.setId(tid.substring(3));
                                }
                                if (bdUniqueId.getId() == bj.dsF.getId()) {
                                    com.baidu.tieba.frs.f.h.a(bjVar.aKi());
                                } else if (bdUniqueId.getId() == bj.drd.getId()) {
                                    com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                                    anVar.cI("obj_type", "2");
                                    anVar.cI("tid", bjVar.getTid());
                                    TiebaStatic.log(anVar);
                                }
                                com.baidu.tieba.frs.f.i.a(FrsFragment.this, bjVar, i, z);
                                com.baidu.tieba.frs.f.h.a(FrsFragment.this, FrsFragment.this.gXU, bjVar);
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
            hideNetRefreshView(this.gYw.bCr());
            showLoadingView(this.gYw.bCr(), true);
            this.gYw.my(false);
            this.gYM.J(3, true);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData bOX() {
        return this.gXU;
    }

    public boolean bOY() {
        return this.gYw.bOY();
    }

    public void aw(Object obj) {
        if (this.gYR != null && this.gYR.hrl != null) {
            this.gYR.hrl.callback(obj);
        }
    }

    public void ax(Object obj) {
        if (this.gYR != null && this.gYR.hrm != null) {
            this.gYR.hrm.callback(obj);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        this.gYw.getListView().stopScroll();
        if (!this.gYw.bPM()) {
            if (!com.baidu.adp.lib.util.l.isNetOk()) {
                this.gYw.bmo();
            } else if (this.gYM.bTU() == 1) {
                blo();
                bkZ();
            } else if (this.gYM.hasMore()) {
                bkZ();
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void onFailed(String str) {
        blo();
        showToast(str);
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void an(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        boolean isEmpty = com.baidu.tbadk.core.util.v.isEmpty(arrayList);
        setHasMore(isEmpty ? 0 : 1);
        blo();
        if (!isEmpty) {
            if (!this.gYM.bUd() && TbadkCoreApplication.getInst().isRecAppExist() && this.gYM.bTU() == 1) {
                this.gXU.addRecommendAppToThreadList(this, arrayList);
            }
            if (this.gYM != null) {
                com.baidu.tieba.frs.d.a.a(getUniqueId(), arrayList, this.gXU.getForum(), this.gYM.getSortType());
            }
            ArrayList<com.baidu.adp.widget.ListView.m> a2 = this.gYX.a(false, false, arrayList, this.gYs, false);
            if (a2 != null) {
                this.gXU.setThreadList(a2);
                this.gYw.a(a2, this.gXU);
            }
            if (this.gYM != null) {
                com.baidu.tieba.frs.d.c.a(this.gXU, this.gYM.bTZ(), 2, getContext());
            }
        }
    }

    private void blo() {
        if (bOx() == 1 || this.gYX.cz(this.gXU.getThreadListIds())) {
            if (com.baidu.tbadk.core.util.v.getCount(this.gXU.getThreadList()) > 3) {
                this.gYw.bmm();
            } else {
                this.gYw.bPT();
            }
        } else if (com.baidu.tbadk.core.util.v.isEmpty(this.gXU.getThreadList())) {
            this.gYw.bmo();
        } else {
            this.gYw.bmn();
        }
    }

    @Override // com.baidu.tieba.frs.mc.l
    public void bkZ() {
        if (this.gYX != null) {
            this.gYX.a(this.gYo, this.forumId, this.gXU);
        }
    }

    public void bOZ() {
        if (!com.baidu.tbadk.core.util.ab.requestWriteExternalStorgeAndCameraPermission(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.al.e(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment, com.baidu.h.a.a.InterfaceC0121a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        com.baidu.tieba.frs.f.i.a(this, i, strArr, iArr);
    }

    public void mr(boolean z) {
        if (this.gYS != null) {
            this.gYS.mL(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.gYT.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a oh(int i) {
        return this.gYT.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        this.gZb.b(bVar);
    }

    public boolean bPa() {
        return this.gYk;
    }

    @Override // com.baidu.tieba.frs.aj
    public void FG() {
        if (this.gYw != null) {
            showFloatingView();
            this.gYw.getListView().scrollToPosition(0);
            this.gYw.startPullRefresh();
        }
    }

    public ForumWriteData bPb() {
        if (this.gXU == null || this.gXU.getForum() == null) {
            return null;
        }
        ForumData forum = this.gXU.getForum();
        ForumWriteData forumWriteData = new ForumWriteData(forum.getId(), forum.getName(), forum.getPrefixData(), this.gXU.getAnti());
        forumWriteData.avatar = forum.getImage_url();
        forumWriteData.forumLevel = forum.getUser_level();
        forumWriteData.specialForumType = forum.special_forum_type;
        forumWriteData.firstDir = forum.getFirst_class();
        forumWriteData.secondDir = forum.getSecond_class();
        UserData userData = this.gXU.getUserData();
        forumWriteData.privateThread = userData != null ? userData.getPrivateThread() : 0;
        forumWriteData.frsTabInfo = bPc();
        return forumWriteData;
    }

    private FrsTabInfoData bPc() {
        int i;
        if (this.gYM == null || this.gXU == null || this.gYO == null) {
            return null;
        }
        if (this.gXU.getEntelechyTabInfo() == null || com.baidu.tbadk.core.util.v.isEmpty(this.gXU.getEntelechyTabInfo().tab)) {
            return null;
        }
        int bVU = this.gYO.bVU();
        if (bVU == 502) {
            return null;
        }
        int i2 = -1;
        ArrayList arrayList = new ArrayList();
        Iterator<FrsTabInfo> it = this.gXU.getEntelechyTabInfo().tab.iterator();
        while (true) {
            i = i2;
            if (!it.hasNext()) {
                break;
            }
            FrsTabInfo next = it.next();
            if (next != null && next.is_general_tab.intValue() == 1) {
                arrayList.add(new FrsTabItemData(next));
                if (bVU == next.tab_id.intValue()) {
                    i2 = bVU;
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
    public void aQm() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void ms(boolean z) {
        this.gYJ = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z) {
        this.gYw.tl(8);
        ((FrsActivity) getActivity()).showLoadingView(view, z);
        ((FrsActivity) getActivity()).g(view, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        this.gYw.tl(0);
        ((FrsActivity) getActivity()).hideLoadingView(view);
        ((FrsActivity) getActivity()).g(view, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        super.showNetRefreshView(view, getResources().getString(R.string.refresh_view_title_text), null, getResources().getString(R.string.refresh_view_button_text), z, getNetRefreshListener());
        this.gYw.tl(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshViewNoClick(View view, String str, boolean z) {
        super.showNetRefreshViewNoClick(view, str, z);
        this.gYw.tl(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        super.hideNetRefreshView(view);
        this.gYw.tl(0);
    }

    public void bPd() {
        FrsTabViewController.b bVQ;
        if (this.gYO != null && (bVQ = this.gYO.bVQ()) != null && bVQ.fragment != null && (bVQ.fragment instanceof al)) {
            ((al) bVQ.fragment).bOd();
        }
    }

    public void mt(boolean z) {
        this.gYm = z;
    }

    public void b(OvalActionButton ovalActionButton) {
        this.gYx = ovalActionButton;
    }

    public OvalActionButton bPe() {
        return this.gYx;
    }

    public boolean bPf() {
        return this.gYm;
    }

    public void onShareSuccess(String str) {
        if (TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.util.aq.isEmpty(str)) {
            if (this.gZm == null) {
                this.gZm = new AddExperiencedModel(getTbPageContext());
            }
            this.gZm.eI(this.forumId, str);
        }
    }

    public boolean bPg() {
        if (this.gYJ && !this.gZp) {
            return (this.gYM != null && this.gYM.bTV() && com.baidu.tieba.frs.a.bNC().bND()) ? false : true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.f.c
    public boolean videoNeedPreload() {
        if (this.gXU != null) {
            return com.baidu.tbadk.util.af.ng(2) || (com.baidu.tbadk.util.af.baI() && this.gXU.isFrsVideoAutoPlay);
        }
        return super.videoNeedPreload();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.f.c
    public boolean isCyberVideoUsedThisPage() {
        return com.baidu.tbadk.a.b.sY("cyber_player_test") || com.baidu.tbadk.a.b.sX("cyber_player_test");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPh() {
        if (!com.baidu.tbadk.core.util.aq.isEmpty(this.forumId)) {
            com.baidu.tbadk.BdToken.c.aFN().p(com.baidu.tbadk.BdToken.b.dge, com.baidu.adp.lib.f.b.toLong(this.forumId, 0L));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        FrsTabViewController.b bVQ;
        if (bOu() == null || (bVQ = bOu().bVQ()) == null || !(bVQ.fragment instanceof BaseFragment)) {
            return null;
        }
        if (bVQ.fragment instanceof FrsAllThreadFragment) {
            TbPageTag tbPageTag = super.getTbPageTag();
            int i = -1;
            if (this.gXU != null) {
                i = this.gXU.getSortType();
            }
            tbPageTag.sortType = com.baidu.tieba.frs.f.g.uK(i);
            tbPageTag.locatePage = "a070";
            if (this.gYh.equals(bVQ.title)) {
                tbPageTag.locatePage = "a071";
            }
            return tbPageTag;
        } else if (bVQ.fragment instanceof FrsFragment) {
            return null;
        } else {
            return ((BaseFragment) bVQ.fragment).getTbPageTag();
        }
    }
}
