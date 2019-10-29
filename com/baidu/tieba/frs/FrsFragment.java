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
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.card.a.a;
import com.baidu.e.a.a;
import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
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
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
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
import com.baidu.tieba.pb.data.ContriInfo;
import com.baidu.tieba.pb.data.PbFloorAgreeResponseMessage;
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
/* loaded from: classes4.dex */
public class FrsFragment extends BaseFragment implements BdListView.e, a.InterfaceC0055a, UserIconBox.b<BdRecyclerView>, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, ae, ah, aj, com.baidu.tieba.frs.loadmore.a, com.baidu.tieba.frs.mc.l, com.baidu.tieba.recapp.n {
    public static com.baidu.tieba.tbadkCore.l fvs;
    private com.baidu.tbadk.util.v cPo;
    private com.baidu.adp.lib.e.b<TbImageView> csh;
    private com.baidu.tieba.frs.gametab.b dJn;
    private com.baidu.tbadk.core.dialog.a ePj;
    private com.baidu.card.z fvE;
    private FrsModelController fvF;
    private com.baidu.tieba.frs.vc.f fvG;
    private FrsTabViewController fvH;
    private com.baidu.tieba.frs.mc.h fvI;
    private com.baidu.tieba.frs.smartsort.a fvJ;
    private com.baidu.tieba.frs.mc.b fvK;
    private ak fvL;
    private com.baidu.tieba.frs.entelechy.b.b fvN;
    private com.baidu.tbadk.k.a fvO;
    private com.baidu.tieba.frs.vc.a fvP;
    private com.baidu.tieba.frs.mc.d fvQ;
    private com.baidu.tieba.frs.mc.c fvR;
    private com.baidu.tieba.frs.vc.h fvS;
    private com.baidu.tieba.frs.mc.a fvT;
    private com.baidu.tieba.frs.live.a fvU;
    private j fvV;
    public com.baidu.tieba.frs.vc.c fvW;
    private com.baidu.tieba.frs.mc.e fvX;
    private View.OnTouchListener fvY;
    private com.baidu.tieba.frs.view.a fvZ;
    private com.baidu.tieba.frs.entelechy.a fva;
    private com.baidu.tieba.tbadkCore.data.f fvk;
    private VoiceManager fvn;
    private OvalActionButton fvp;
    private FRSRefreshButton fvq;
    private com.baidu.tieba.frs.view.c fwa;
    private com.baidu.tieba.frs.vc.e fwb;
    private boolean fwc;
    private com.baidu.tieba.NEGFeedBack.a fwe;
    private com.baidu.tieba.ala.a fwf;
    private com.baidu.tieba.frs.brand.buttommenu.a fwg;
    private com.baidu.tieba.frs.sportspage.notification.a fwh;
    private AddExperiencedModel fwi;
    private boolean fwk;
    private int fwv;
    private View mRootView;
    public static boolean fvf = false;
    public static volatile long fvu = 0;
    public static volatile long fvv = 0;
    public static volatile int fvw = 0;
    public boolean fvb = false;
    private boolean fvc = false;
    private boolean fvd = false;
    private boolean fve = true;
    public String fvg = null;
    public String mFrom = null;
    public int mFlag = 0;
    public boolean fvh = false;
    private boolean fvi = false;
    private String mThreadId = null;
    public String forumId = null;
    private int fuT = 0;
    private boolean fvj = false;
    private boolean fvl = false;
    private boolean fvm = false;
    private k fvo = null;
    private boolean fvr = false;
    public final bh cry = null;
    private FrsViewData fuR = new FrsViewData();
    public long fbN = -1;
    public long cMh = 0;
    public long cLZ = 0;
    public long createTime = 0;
    public long beginTime = -1;
    public long fvt = 0;
    public boolean fvx = false;
    private boolean fvy = false;
    private boolean fvz = false;
    public com.baidu.tbadk.p.b fvA = null;
    private boolean fvB = true;
    private boolean fvC = true;
    private a.C0044a fvD = new a.C0044a(2);
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> fvM = new SparseArray<>();
    private boolean dyK = true;
    private boolean fwd = false;
    private boolean hasInit = false;
    private boolean fwj = false;
    private boolean fwl = false;
    private AlphaAnimation fwm = null;
    private AlphaAnimation fwn = null;
    private AddExperiencedModel.a fwo = new AddExperiencedModel.a() { // from class: com.baidu.tieba.frs.FrsFragment.1
        @Override // com.baidu.tieba.share.AddExperiencedModel.a
        public void a(ContriInfo contriInfo) {
        }
    };
    public int mHeadLineDefaultNavTabId = -1;
    private HttpMessageListener fwp = new HttpMessageListener(1001601, true) { // from class: com.baidu.tieba.frs.FrsFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof PbFloorAgreeResponseMessage)) {
                PbFloorAgreeResponseMessage pbFloorAgreeResponseMessage = (PbFloorAgreeResponseMessage) httpResponsedMessage;
            }
        }
    };
    private final CustomMessageListener fwq = new CustomMessageListener(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED) { // from class: com.baidu.tieba.frs.FrsFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof bh) {
                    com.baidu.tieba.frs.f.h.a(FrsFragment.this.fvo, FrsFragment.this.fuR, FrsFragment.this.getForumId(), true, (bh) data);
                }
            }
        }
    };
    private CustomMessageListener fwr = new CustomMessageListener(CmdConfigCustom.CMD_CLOSE_GAME_RANK_CARD) { // from class: com.baidu.tieba.frs.FrsFragment.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.fuR != null) {
                FrsFragment.this.fuR.removeGameRankListFromThreadList();
                if (FrsFragment.this.fvo != null) {
                    FrsFragment.this.fvo.aaQ();
                }
            }
        }
    };
    private CustomMessageListener FX = new CustomMessageListener(2921401) { // from class: com.baidu.tieba.frs.FrsFragment.41
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && FrsFragment.this.fvq != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() <= 0 || FrsFragment.this.fvH.bqX() == 0 || FrsFragment.this.fvH.bqU() == null || !(FrsFragment.this.fvH.bqU().fragment instanceof BaseFragment) || !((BaseFragment) FrsFragment.this.fvH.bqU().fragment).isPrimary()) {
                    if (FrsFragment.this.fvH.bqX() != 0) {
                        FrsFragment.this.bkn();
                        return;
                    }
                    return;
                }
                FrsFragment.this.bko();
            }
        }
    };
    private CustomMessageListener fws = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.FrsFragment.42
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 1) {
                    FrsFragment.this.bkf();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                }
            }
        }
    };
    private final ai fwt = new ai() { // from class: com.baidu.tieba.frs.FrsFragment.43
        @Override // com.baidu.tieba.frs.ai
        public void a(int i, int i2, ap apVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
            FrsFragment.this.bjS();
            if (FrsFragment.this.fvN != null) {
                FrsFragment.this.fvG.kF(FrsFragment.this.fvN.qU(i));
            }
            e.b bVar = new e.b();
            if (apVar != null) {
                bVar.isSuccess = apVar.errCode == 0;
                bVar.errorCode = apVar.errCode;
                bVar.errorMsg = apVar.errMsg;
                if (bVar.isSuccess) {
                    if (com.baidu.tbadk.core.util.v.isEmpty(arrayList)) {
                        FrsFragment.this.fvo.aKk();
                    } else if (apVar.hasMore) {
                        if (com.baidu.tbadk.core.util.v.getCount(FrsFragment.this.fuR.getThreadList()) > 3) {
                            FrsFragment.this.fvo.aKi();
                        } else {
                            FrsFragment.this.fvo.blh();
                        }
                    } else if (apVar.fzB) {
                        FrsFragment.this.fvo.aKj();
                    } else {
                        FrsFragment.this.fvo.aKk();
                    }
                }
            } else {
                apVar = new ap();
                apVar.pn = 1;
                apVar.hasMore = false;
                apVar.fzB = false;
            }
            if (i == 1) {
                FrsFragment.this.fvB = true;
                FrsFragment.this.fwI.a(FrsFragment.this.fvF.getType(), false, bVar);
            } else {
                FrsFragment.this.a(bVar);
                if (FrsFragment.this.fvF.boM() != null) {
                    FrsFragment.this.fuR = FrsFragment.this.fvF.boM();
                }
                FrsFragment.this.bkh();
            }
            if (FrsFragment.this.fwP != null) {
                FrsFragment.this.fwP.a(i, i2, apVar, arrayList);
            }
        }
    };
    private FrsTabViewController.a fwu = new FrsTabViewController.a() { // from class: com.baidu.tieba.frs.FrsFragment.44
        @Override // com.baidu.tieba.frs.vc.FrsTabViewController.a
        public void jW(int i) {
            boolean z = false;
            if (i != 1) {
                com.baidu.tieba.card.t.baw().iK(false);
                FrsFragment.this.jD(false);
            }
            if (i == 303 && i != FrsFragment.this.fwv) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13121").bS("fid", FrsFragment.this.forumId).bS("uid", TbadkCoreApplication.getCurrentAccount()));
            }
            if (i == 502) {
                FrsFragment.this.fvp.setIconFade(R.drawable.btn_frs_professional_edit_n);
            } else {
                FrsFragment.this.fvp.setIconFade(0);
            }
            FrsFragment.this.fwv = i;
            FrsFragment.this.bkk();
            com.baidu.tieba.frs.d.d.fDZ.fQE = i;
            com.baidu.tieba.frs.d.d.fDZ.fQF = -1;
            com.baidu.tieba.frs.a biW = com.baidu.tieba.frs.a.biW();
            if (i == 1 && FrsFragment.this.fwj) {
                z = true;
            }
            biW.G(z, true);
        }
    };
    private CustomMessageListener fww = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIVE_COUNT) { // from class: com.baidu.tieba.frs.FrsFragment.45
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                FrsFragment.this.fvH.sa(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    };
    private CustomMessageListener fwx = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_LIVE_START) { // from class: com.baidu.tieba.frs.FrsFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && ((Integer) customResponsedMessage.getData()).intValue() == 51 && FrsFragment.this.fuR != null) {
                com.baidu.tieba.frs.f.j.a(FrsFragment.this.fuR, FrsFragment.this.getPageContext());
            }
        }
    };
    private final CustomMessageListener fwy = new CustomMessageListener(CmdConfigCustom.CMD_FRS_SELECT_ALA_LIVE_TAB) { // from class: com.baidu.tieba.frs.FrsFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                FrsFragment.this.fvH.rY(49);
            }
        }
    };
    private final CustomMessageListener fwz = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.frs.FrsFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && FrsFragment.this.fuR != null && FrsFragment.this.fuR.getForum() != null) {
                SignData signData = (SignData) customResponsedMessage.getData();
                int user_level = FrsFragment.this.fuR.getForum().getUser_level();
                if (signData.forumId != null && signData.forumId.equals(FrsFragment.this.fuR.getForum().getId())) {
                    FrsFragment.this.fuR.updateSignData(signData);
                    FrsFragment.this.fvG.j(FrsFragment.this.fuR);
                    if (FrsFragment.this.fvG.bqH()) {
                        i = FrsFragment.this.fuR.getForum().getUser_level();
                        if (user_level >= i) {
                            i++;
                        }
                    } else {
                        i = user_level;
                    }
                    TbadkCoreApplication.getInst().addSignedForum(FrsFragment.this.fuR.getForum().getName(), signData.sign_bonus_point, i);
                }
            }
        }
    };
    private final CustomMessageListener fwA = new CustomMessageListener(CmdConfigCustom.CMD_FRS_EXPERIENCE_TIP) { // from class: com.baidu.tieba.frs.FrsFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.t) && FrsFragment.this.fuR != null) {
                FrsFragment.this.fuR.updateLikeData((com.baidu.tieba.tbadkCore.t) customResponsedMessage.getData());
                FrsFragment.this.fvG.i(FrsFragment.this.fuR);
                FrsFragment.this.fvH.a(FrsFragment.this.fuR, FrsFragment.this.fvF.bpp());
            }
        }
    };
    private final AntiHelper.a fwB = new AntiHelper.a() { // from class: com.baidu.tieba.frs.FrsFragment.6
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).O("obj_locate", at.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).O("obj_locate", at.a.LOCATE_LIKE_PERSON));
        }
    };
    private CustomMessageListener fwC = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.FrsFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(FrsFragment.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().cwD != null) {
                        if (AntiHelper.a(FrsFragment.this.getActivity(), updateAttentionMessage.getData().cwD, FrsFragment.this.fwB) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).O("obj_locate", at.a.LOCATE_LIKE_PERSON));
                        }
                    } else if (updateAttentionMessage.getData().isSucc && updateAttentionMessage.getData().isAttention) {
                        com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getPageContext().getPageActivity(), (int) R.string.attention_success);
                    }
                }
            }
        }
    };
    private CustomMessageListener fwD = new CustomMessageListener(2921346) { // from class: com.baidu.tieba.frs.FrsFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsFragment.this.refresh();
        }
    };
    private CustomMessageListener fwE = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.frs.FrsFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                FrsFragment.this.fvo.c((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener fwF = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_REMIND) { // from class: com.baidu.tieba.frs.FrsFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewsRemindMessage newsRemindMessage;
            if (customResponsedMessage != null && (customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626 && (newsRemindMessage = (NewsRemindMessage) customResponsedMessage) != null) {
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (FrsFragment.this.fvo != null) {
                    FrsFragment.this.fvo.C(notificationCount, z);
                }
            }
        }
    };
    private final CustomMessageListener fwG = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.frs.FrsFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.isResumed()) {
                FrsFragment.this.bkx();
            }
        }
    };
    private CustomMessageListener fwH = new CustomMessageListener(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER) { // from class: com.baidu.tieba.frs.FrsFragment.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (FrsFragment.this.fvo != null) {
                    FrsFragment.this.fvo.setExpanded(booleanValue);
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.p fwI = new com.baidu.tieba.tbadkCore.p() { // from class: com.baidu.tieba.frs.FrsFragment.14
        private long startTime = 0;

        @Override // com.baidu.tieba.tbadkCore.p
        public void qq(int i) {
            this.startTime = System.nanoTime();
            if (FrsFragment.this.fvo != null) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsFragment.this.fvo.bkS();
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
            if (FrsFragment.this.dyK) {
                FrsFragment.this.dyK = false;
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.fvo, FrsFragment.this.fuR, FrsFragment.this.getForumId(), false, null);
            }
            FrsFragment.this.bjS();
            FrsFragment.this.fvy = true;
            if (bVar != null && bVar.isSuccess) {
                FrsFragment.this.fvo.ble().ko(com.baidu.tbadk.core.util.ar.amO().isFrsShowBigImage());
                FrsFragment.fvu = 0L;
                FrsFragment.fvv = 0L;
                FrsFragment.fvw = 0;
            } else {
                FrsFragment.fvw = 1;
            }
            if (!FrsFragment.this.fvF.bpt() && (i == 3 || i == 6)) {
                FrsFragment.this.fvR.resetData();
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (FrsFragment.this.fvF.boM() != null) {
                FrsFragment.this.fuR = FrsFragment.this.fvF.boM();
            }
            FrsFragment.this.fvo.b(FrsFragment.this.fuR.getRedpacketRainData());
            FrsFragment.this.qm(1);
            if (i == 7) {
                FrsFragment.this.qn(FrsFragment.this.fuR.getFrsDefaultTabId());
                return;
            }
            if (FrsFragment.this.fuR.getPage() != null) {
                FrsFragment.this.setHasMore(FrsFragment.this.fuR.getPage().ahA());
            }
            if (i == 4) {
                if (!FrsFragment.this.fvF.bpt() && TbadkCoreApplication.getInst().isRecAppExist() && FrsFragment.this.fvF.bpk() == 1) {
                    FrsFragment.this.fuR.addRecommendAppToThreadList(FrsFragment.this);
                }
                ArrayList<com.baidu.adp.widget.ListView.m> a2 = FrsFragment.this.fvR.a(false, false, FrsFragment.this.fuR.getThreadList(), FrsFragment.this.fvk, false);
                if (a2 != null) {
                    FrsFragment.this.fuR.setThreadList(a2);
                    FrsFragment.this.fuR.checkLiveStageInThreadList();
                }
                if (FrsFragment.this.fvF != null) {
                    com.baidu.tieba.frs.d.c.a(FrsFragment.this.fuR, FrsFragment.this.fvF.bpp(), 2);
                }
                com.baidu.tieba.frs.f.a.a(FrsFragment.this, FrsFragment.this.fuR.getForum(), FrsFragment.this.fuR.getThreadList(), false, FrsFragment.this.getPn());
                FrsFragment.this.cMh = System.currentTimeMillis() - currentTimeMillis;
                FrsFragment.this.fvo.a(a2, FrsFragment.this.fuR);
                FrsFragment.this.bjT();
                return;
            }
            FrsFragment.this.bjT();
            switch (i) {
                case 1:
                    FrsFragment.this.fvo.bkS();
                    break;
                case 2:
                    FrsFragment.this.fvo.bkS();
                    break;
                case 3:
                case 6:
                    if (FrsFragment.this.fuR != null) {
                        FrsFragment.this.fuR.clearPostThreadCount();
                    }
                    if (FrsFragment.this.fvW != null) {
                        FrsFragment.this.fvW.refresh();
                        break;
                    }
                    break;
            }
            FrsFragment.this.bka();
            if (bVar == null || bVar.errorCode == 0) {
                if (FrsFragment.this.fuR != null) {
                    FrsFragment.this.a(FrsFragment.this.fuR);
                    FrsFragment.this.J(false, i == 5);
                    if (FrsFragment.this.fvF != null) {
                        if (FrsFragment.this.fuR.getActivityHeadData() != null && FrsFragment.this.fuR.getActivityHeadData().agW() != null && FrsFragment.this.fuR.getActivityHeadData().agW().size() > 0) {
                            com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), 1, FrsFragment.this.fuR.getForum(), FrsFragment.this.fvF.getSortType(), 1);
                        }
                        if (FrsFragment.this.fuR.getThreadList() != null && FrsFragment.this.fuR.getThreadList().size() > 0) {
                            Iterator<com.baidu.adp.widget.ListView.m> it = FrsFragment.this.fuR.getThreadList().iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    com.baidu.adp.widget.ListView.m next = it.next();
                                    if ((next instanceof bh) && ((bh) next).getType() == bh.cdh) {
                                        com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), 1, FrsFragment.this.fuR.getForum(), FrsFragment.this.fvF.getSortType(), 2);
                                    }
                                }
                            }
                        }
                        com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), FrsFragment.this.fuR.getThreadList(), FrsFragment.this.fuR.getForum(), FrsFragment.this.fvF.getSortType());
                    }
                    FrsFragment.this.fvo.qz(i);
                    FrsFragment.fvu = (System.nanoTime() - this.startTime) / 1000000;
                    if (bVar != null) {
                        FrsFragment.fvv = bVar.jgd;
                    }
                } else {
                    return;
                }
            } else if (FrsFragment.this.fuR == null || com.baidu.tbadk.core.util.v.isEmpty(FrsFragment.this.fuR.getThreadList())) {
                FrsFragment.this.a(bVar);
            } else if (bVar.fgr) {
                FrsFragment.this.showToast(FrsFragment.this.getPageContext().getResources().getString(R.string.net_error_text, bVar.errorMsg, Integer.valueOf(bVar.errorCode)));
            }
            FrsFragment.this.bjX();
            FrsFragment.this.bjY();
            if (FrsFragment.this.fuR.getAccessFlag() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11384"));
            }
            if (FrsFragment.this.fbN > -1 && !FrsFragment.this.fwd) {
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.fvF, FrsFragment.this.fbN);
                FrsFragment.this.fbN = -1L;
                FrsFragment.this.fwd = true;
            }
            if (FrsFragment.this.fvl && FrsFragment.this.fvH.rY(49)) {
                FrsFragment.this.fvl = false;
            }
            FrsFragment.this.cMh = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.p
        public void c(com.baidu.tieba.tbadkCore.l lVar) {
            if ((lVar != null && ("normal_page".equals(FrsFragment.this.fvF.getPageType()) || "frs_page".equals(FrsFragment.this.fvF.getPageType()) || "book_page".equals(FrsFragment.this.fvF.getPageType()))) || "brand_page".equals(FrsFragment.this.fvF.getPageType())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE, lVar));
                FrsFragment.this.b(lVar);
                FrsFragment.fvs = lVar;
            }
        }
    };
    private final CustomMessageListener fwJ = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.frs.FrsFragment.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                FrsFragment.this.fuR.updateCurrentUserPendant((com.baidu.tbadk.data.l) customResponsedMessage.getData());
                FrsFragment.this.fvo.ble().notifyDataSetChanged();
            }
        }
    };
    private final CustomMessageListener mMemListener = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_MEM) { // from class: com.baidu.tieba.frs.FrsFragment.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && FrsFragment.this.fuR != null && (userData = FrsFragment.this.fuR.getUserData()) != null) {
                userData.setIsMem(num.intValue());
                if (num.intValue() != 0) {
                    FrsFragment.this.fvG.e(num);
                }
            }
        }
    };
    private final com.baidu.tieba.frs.mc.k fwK = new com.baidu.tieba.frs.mc.k() { // from class: com.baidu.tieba.frs.FrsFragment.26
        @Override // com.baidu.tieba.frs.mc.k
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.m> arrayList, boolean z3) {
            if (FrsFragment.this.fvJ != null && FrsFragment.this.fvF != null && FrsFragment.this.fvF.bpt() && z && !z2 && !z3) {
                FrsFragment.this.fvJ.rA(i2);
            }
        }
    };
    public final View.OnTouchListener cAp = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.FrsFragment.27
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (FrsFragment.this.fvY != null) {
                FrsFragment.this.fvY.onTouch(view, motionEvent);
            }
            if (FrsFragment.this.fvL != null && FrsFragment.this.fvL.blL() != null) {
                FrsFragment.this.fvL.blL().onTouchEvent(motionEvent);
            }
            if (FrsFragment.this.dJn != null) {
                FrsFragment.this.dJn.c(view, motionEvent);
            }
            if (FrsFragment.this.fvG != null) {
                FrsFragment.this.fvG.C(motionEvent);
                return false;
            }
            return false;
        }
    };
    private final CustomMessageListener fwL = new CustomMessageListener(CmdConfigCustom.CMD_GOTOLIVE_HOST_UPGRADE) { // from class: com.baidu.tieba.frs.FrsFragment.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.alR().getInt(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.PHOTOLIVE_HOSTLEVEL, -1) != -1 && FrsFragment.this.fuR.getForum() != null) {
                FrsFragment.this.fuR.getForum().setCanAddPhotoLivePost(true);
            }
        }
    };
    public final View.OnClickListener fwM = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.30
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsFragment.this.fvo == null || view != FrsFragment.this.fvo.bkQ() || FrsFragment.this.getActivity() == null) {
                if (FrsFragment.this.fuR != null && FrsFragment.this.fuR.getForum() != null && FrsFragment.this.fvo != null && view == FrsFragment.this.fvo.bkW()) {
                    if (FrsFragment.this.fwa == null) {
                        FrsFragment.this.fwa = new com.baidu.tieba.frs.view.c(FrsFragment.this.getPageContext());
                    }
                    FrsFragment.this.fwa.m(FrsFragment.this.fuR);
                    FrsFragment.this.fwa.showDialog();
                    return;
                }
                if (view.getId() == R.id.game_activity_egg_layout && com.baidu.adp.lib.util.l.isNetOk()) {
                    TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_CLICK);
                    if (FrsFragment.this.fvo.blb()) {
                        FrsFragment.this.fvo.blc();
                    } else {
                        String activityUrl = FrsFragment.this.fuR.getForum().getYuleData().akK().getActivityUrl();
                        if (!StringUtils.isNull(activityUrl)) {
                            com.baidu.tbadk.browser.a.startInternalWebActivity(FrsFragment.this.getPageContext().getPageActivity(), activityUrl);
                        }
                    }
                }
                if (view == FrsFragment.this.fvo.bli() && FrsFragment.this.fvF != null && FrsFragment.this.fvF.hasMore()) {
                    FrsFragment.this.fvo.aKi();
                    FrsFragment.this.aIW();
                }
                if (view != null && view == FrsFragment.this.fvo.bkY() && bc.checkUpIsLogin(FrsFragment.this.getContext())) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).O("obj_locate", 2));
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
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.FrsFragment.31
        private int fwY = 0;
        private int dvr = 0;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (FrsFragment.this.fvP != null) {
                FrsFragment.this.fvP.bqh();
            }
            this.fwY = 0;
            this.dvr = 0;
            if (recyclerView != null && (recyclerView instanceof BdRecyclerView)) {
                this.fwY = ((BdRecyclerView) recyclerView).getFirstVisiblePosition();
                this.dvr = ((BdRecyclerView) recyclerView).getLastVisiblePosition();
            }
            if (FrsFragment.this.fwb != null) {
                FrsFragment.this.fwb.a(recyclerView, this.fwY, this.dvr);
            }
            if (FrsFragment.this.fuR != null && FrsFragment.this.fvo != null && FrsFragment.this.fvo.ble() != null) {
                FrsFragment.this.fvo.bo(this.fwY, this.dvr);
                if (FrsFragment.this.fvE != null && FrsFragment.this.fvE.lV() != null) {
                    FrsFragment.this.fvE.lV().b(FrsFragment.this.fvD);
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (FrsFragment.this.fvG != null) {
                FrsFragment.this.fvG.setScrollState(i);
            }
            if (i == 0) {
                FrsFragment.this.fvo.blm();
            }
            if ((i == 2 || i == 1) && !FrsFragment.this.fvz) {
                FrsFragment.this.fvz = true;
                FrsFragment.this.fvo.blg();
            }
            if (FrsFragment.this.fvA == null && !FrsFragment.this.bkr()) {
                FrsFragment.this.fvA = new com.baidu.tbadk.p.b();
                FrsFragment.this.fvA.setSubType(1000);
            }
            if (i == 0) {
                if (FrsFragment.this.fvA != null) {
                    FrsFragment.this.fvA.awE();
                }
                com.baidu.tieba.card.t.baw().iK(true);
                FrsFragment.this.jD(true);
                FrsFragment.this.fvo.bn(this.fwY, this.dvr);
            } else if (FrsFragment.this.fvA != null) {
                FrsFragment.this.fvA.awD();
            }
            if (FrsFragment.this.fwb != null) {
                FrsFragment.this.fwb.onScrollStateChanged(recyclerView, i);
            }
            if (i == 0) {
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.fvo, FrsFragment.this.fuR, FrsFragment.this.getForumId(), false, null);
            }
            if (FrsFragment.this.fvH != null && i == 1) {
                FrsFragment.this.fvH.bqW();
            }
            if (FrsFragment.this.fvE == null) {
                if (FrsFragment.this.fvo.bkJ() != null && !FrsFragment.this.fvo.bkq() && FrsFragment.this.fvo.bkJ().ccm() != null && (FrsFragment.this.fvo.bkJ().ccm().getTag() instanceof com.baidu.card.z)) {
                    FrsFragment.this.fvE = (com.baidu.card.z) FrsFragment.this.fvo.bkJ().ccm().getTag();
                }
            } else if (i == 0 && FrsFragment.this.fvo.bkJ() != null && !FrsFragment.this.fvo.bkq() && FrsFragment.this.fvo.bkJ().ccm() != null && (FrsFragment.this.fvo.bkJ().ccm().getTag() instanceof com.baidu.card.z)) {
                FrsFragment.this.fvE = (com.baidu.card.z) FrsFragment.this.fvo.bkJ().ccm().getTag();
            }
            if (i == 1) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921418));
            }
        }
    };
    private final d fwN = new d() { // from class: com.baidu.tieba.frs.FrsFragment.32
        @Override // com.baidu.tieba.frs.d
        public void a(int i, int i2, View view, View view2, bh bhVar) {
            if (i != FrsFragment.this.fvo.ble().bnb()) {
                if (i != FrsFragment.this.fvo.ble().bnc()) {
                    if (i == FrsFragment.this.fvo.ble().bmZ() && FrsFragment.this.fuR != null && FrsFragment.this.fuR.getUserData() != null && FrsFragment.this.fuR.getUserData().isBawu()) {
                        String bawuCenterUrl = FrsFragment.this.fuR.getBawuCenterUrl();
                        if (!com.baidu.tbadk.core.util.aq.isEmpty(bawuCenterUrl) && FrsFragment.this.fuR.getForum() != null) {
                            com.baidu.tbadk.browser.a.startWebActivity(FrsFragment.this.getPageContext().getPageActivity(), bawuCenterUrl);
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10502").bS("fid", FrsFragment.this.fuR.getForum().getId()).bS("uid", FrsFragment.this.fuR.getUserData().getUserId()));
                        }
                    }
                } else if (bc.checkUpIsLogin(FrsFragment.this.getPageContext().getPageActivity())) {
                    TiebaStatic.log(CommonStatisticKey.MY_SERVICE_CK);
                    if (FrsFragment.this.fuR != null && FrsFragment.this.fuR.getForum() != null) {
                        ForumData forum = FrsFragment.this.fuR.getForum();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.toLong(forum.getId(), 0L), forum.getName(), forum.getImage_url(), 0)));
                    }
                }
            } else if (bc.checkUpIsLogin(FrsFragment.this.getActivity())) {
                TiebaStatic.log("forum_fortune_click");
                com.baidu.tieba.frs.f.i.b(FrsFragment.this.getPageContext(), FrsFragment.this.fuR);
            }
        }
    };
    private final NoNetworkView.a fsT = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.FrsFragment.33
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (FrsFragment.this.fvF.bpk() == 1 && z && !FrsFragment.this.fvo.bkq()) {
                if (FrsFragment.this.fuR == null || com.baidu.tbadk.core.util.v.isEmpty(FrsFragment.this.fuR.getThreadList())) {
                    FrsFragment.this.hideNetRefreshView(FrsFragment.this.fvo.aYd());
                    FrsFragment.this.showLoadingView(FrsFragment.this.fvo.aYd(), true);
                    FrsFragment.this.fvo.jO(false);
                    FrsFragment.this.refresh();
                    return;
                }
                FrsFragment.this.fvo.bkS();
            }
        }
    };
    private final CustomMessageListener cwZ = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.FrsFragment.35
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                com.baidu.tieba.frs.f.c.a(customResponsedMessage, FrsFragment.this.fvo, FrsFragment.this.fuR);
            }
        }
    };
    private com.baidu.adp.widget.ListView.s fwO = new a();
    private ai fwP = new ai() { // from class: com.baidu.tieba.frs.FrsFragment.37
        @Override // com.baidu.tieba.frs.ai
        public void a(int i, int i2, ap apVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
            com.baidu.adp.lib.g.e.fZ().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.37.1
                @Override // java.lang.Runnable
                public void run() {
                    if (FrsFragment.this.fvo != null && FrsFragment.this.fvo.bbw()) {
                        FrsFragment.this.aIW();
                    }
                }
            });
        }
    };
    private CustomMessageListener fwQ = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.frs.FrsFragment.38
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    FrsFragment.this.fwc = true;
                }
            }
        }
    };
    private CustomMessageListener fwR = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.frs.FrsFragment.39
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                    if (FrsFragment.this.fvE == null && FrsFragment.this.fvo.bkJ() != null && !FrsFragment.this.fvo.bkq() && FrsFragment.this.fvo.bkJ().ccm() != null && (FrsFragment.this.fvo.bkJ().ccm().getTag() instanceof com.baidu.card.z)) {
                        FrsFragment.this.fvE = (com.baidu.card.z) FrsFragment.this.fvo.bkJ().ccm().getTag();
                    }
                    if (FrsFragment.this.fvE != null && FrsFragment.this.fvE.lV() != null) {
                        FrsFragment.this.fvE.lV().b(new a.C0044a(3));
                    }
                }
            }
        }
    };
    private CustomMessageListener fwS = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.FrsFragment.40
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.fvo != null) {
                FrsFragment.this.fvo.pC();
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.frs.loadmore.a
    public /* bridge */ /* synthetic */ com.baidu.adp.base.e getPageContext() {
        return super.getPageContext();
    }

    public com.baidu.tieba.frs.entelechy.b.b bjG() {
        return this.fvN;
    }

    public com.baidu.adp.widget.ListView.s bjH() {
        return this.fwO;
    }

    public com.baidu.tieba.frs.mc.d bjI() {
        return this.fvQ;
    }

    public com.baidu.tieba.frs.smartsort.a bjJ() {
        return this.fvJ;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public FrsModelController bjK() {
        return this.fvF;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public com.baidu.tieba.frs.mc.c bjL() {
        return this.fvR;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public com.baidu.tieba.frs.vc.f bjM() {
        return this.fvG;
    }

    public FrsTabViewController bjN() {
        return this.fvH;
    }

    public ak bjO() {
        return this.fvL;
    }

    public void jC(boolean z) {
        this.fwl = z;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public k bjP() {
        return this.fvo;
    }

    @Override // com.baidu.tieba.frs.aj
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.aj, com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.fvg;
    }

    public void setForumName(String str) {
        this.fvg = str;
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
        if (this.fvR == null) {
            return 1;
        }
        return this.fvR.getPn();
    }

    public int getPn() {
        if (this.fvR == null) {
            return 1;
        }
        return this.fvR.getPn();
    }

    public void setPn(int i) {
        if (this.fvR != null) {
            this.fvR.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.fvR != null) {
            this.fvR.setHasMore(i);
        }
    }

    public int bjQ() {
        if (this.fvR == null) {
            return -1;
        }
        return this.fvR.bjQ();
    }

    public boolean bjR() {
        return this.fvm;
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
            this.fvo.bkM();
            showNetRefreshView(this.fvo.aYd(), string, true);
        } else if (340001 == bVar.errorCode) {
            a(bVar, this.fuR.getRecm_forum_list());
        } else {
            if (com.baidu.tbadk.core.util.v.isEmpty(this.fuR.getThreadList())) {
                b(bVar);
            }
            if (bkr()) {
                setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds280));
            } else {
                setNetRefreshViewEmotionDefMarginTop();
            }
        }
    }

    public void a(View view, String str, boolean z, List<RecmForumInfo> list) {
        this.fvo.bkM();
        this.fvo.qv(8);
        if (this.fvZ == null) {
            this.fvZ = new com.baidu.tieba.frs.view.a(getPageContext(), getNetRefreshListener());
        }
        this.fvZ.setSubText(str);
        this.fvZ.cB(list);
        this.fvZ.attachView(view, z);
    }

    private void a(e.b bVar, List<RecmForumInfo> list) {
        if (this.fvo != null) {
            this.fvo.bkM();
            this.fvo.setTitle(this.fvg);
            a(this.fvo.aYd(), bVar.errorMsg, true, list);
        }
    }

    private void b(e.b bVar) {
        this.fvo.bkM();
        if (bVar.fgr) {
            showNetRefreshView(this.fvo.aYd(), TbadkCoreApplication.getInst().getString(R.string.net_error_text, new Object[]{bVar.errorMsg, Integer.valueOf(bVar.errorCode)}), true);
        } else {
            showNetRefreshView(this.fvo.aYd(), bVar.errorMsg, true);
        }
    }

    public void bjS() {
        hideLoadingView(this.fvo.aYd());
        this.fvo.jQ(false);
        if (this.fvo.bkK() instanceof com.baidu.tieba.frs.tab.c) {
            ((com.baidu.tieba.frs.tab.c) this.fvo.bkK()).bpN();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjT() {
        if (bjQ() == 0 && com.baidu.tbadk.core.util.v.isEmpty(this.fuR.getThreadListIds())) {
            if (com.baidu.tbadk.core.util.v.isEmpty(this.fuR.getThreadList())) {
                this.fvo.aKk();
            } else {
                this.fvo.aKj();
            }
        } else if (com.baidu.tbadk.core.util.v.getCount(this.fuR.getThreadList()) > 3) {
            this.fvo.aKi();
        } else {
            this.fvo.blh();
        }
    }

    public void a(ErrorData errorData) {
        String stringExtra = getActivity().getIntent().getStringExtra("name");
        if (getActivity().getIntent().getIntExtra(FrsActivityConfig.FRS_CALL_FROM, -1) == 12 && errorData != null && errorData.error_code == 3 && !StringUtils.isNull(stringExtra) && TbadkCoreApplication.isLogin()) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateBarGuideActivityConfig(getContext(), stringExtra)));
            getActivity().finish();
            return;
        }
        bjS();
        this.fvo.bkS();
        e.b bph = this.fvF.bph();
        boolean isEmpty = com.baidu.tbadk.core.util.v.isEmpty(this.fuR.getThreadList());
        if (bph != null && isEmpty) {
            if (this.fvF.bpi() != 0) {
                this.fvF.bpn();
                this.fvo.bkS();
            } else {
                a(bph);
            }
            this.fvo.K(this.fuR.isStarForum(), false);
            return;
        }
        a(bph);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.l lVar) {
        if (lVar != null && lVar.getEntelechyTabInfo() != null && lVar.getEntelechyTabInfo().tab != null) {
            for (FrsTabInfo frsTabInfo : lVar.getEntelechyTabInfo().tab) {
                if (frsTabInfo.tab_id.intValue() == 502 && com.baidu.tbadk.core.sharedPref.b.alR().getBoolean("first_into_tab_profession", true)) {
                    return;
                }
            }
        }
        new com.baidu.tieba.frs.ad.f(getTbPageContext()).a(lVar);
    }

    public boolean bjU() {
        return bjV() && !bjW();
    }

    private boolean bjV() {
        if (bkp() == null) {
            return false;
        }
        FrsViewData bkp = bkp();
        com.baidu.tbadk.core.data.s sVar = null;
        if (bkp.getStar() != null && !StringUtils.isNull(bkp.getStar().cnz())) {
            sVar = new com.baidu.tbadk.core.data.s();
        } else if (bkp.getActivityHeadData() != null && com.baidu.tbadk.core.util.v.getCount(bkp.getActivityHeadData().agW()) >= 1) {
            sVar = bkp.getActivityHeadData().agW().get(0);
        }
        return sVar != null;
    }

    public boolean bjW() {
        if (bkp() == null) {
            return false;
        }
        FrsViewData bkp = bkp();
        return (com.baidu.tbadk.core.util.v.isEmpty(bkp.getShowTopThreadList()) && bkp.getBusinessPromot() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjX() {
        boolean b;
        if (!bjZ()) {
            final PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
            privateForumPopInfoData.a(this.fuR.getPrivateForumTotalInfo().getPrivatePopInfo());
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(getActivity());
            if (this.fuR.getPrivateForumTotalInfo().ahH().private_forum_status.intValue() == 1 && (com.baidu.tbadk.core.util.aq.isEmpty(privateForumPopInfoData.ahJ()) || privateForumPopInfoData.ahM() != Integer.valueOf(this.forumId))) {
                privateForumPopInfoData.mQ("create_success");
                privateForumPopInfoData.mR(TbadkCoreApplication.getInst().getString(R.string.frs_private_create_hint));
                privateForumPopInfoData.mS("https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.fvg + "&nomenu=1");
                privateForumPopInfoData.b(Integer.valueOf(this.forumId));
                b = frsPrivateCommonDialogView.b(privateForumPopInfoData);
            } else {
                b = privateForumPopInfoData.ahM() == Integer.valueOf(this.forumId) ? frsPrivateCommonDialogView.b(privateForumPopInfoData) : false;
            }
            if (b) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
                aVar.hX(2);
                aVar.aM(frsPrivateCommonDialogView);
                aVar.eh(false);
                frsPrivateCommonDialogView.setConfirmButton(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.15
                    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.frs.FrsFragment */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ba.amQ().b(FrsFragment.this.getPageContext(), new String[]{privateForumPopInfoData.ahL()});
                        aVar.dismiss();
                    }
                });
                aVar.a(new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.16
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(getPageContext()).akO();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjY() {
        if (bjZ() || this.fuR.getPrivateForumTotalInfo().ahH().private_forum_status.intValue() != 1) {
            a((Integer) null, (Integer) null, true);
        } else {
            a(this.fuR.getPrivateForumTotalInfo().ahH().private_forum_audit_status, this.fuR.getPrivateForumTotalInfo().ahI(), false);
        }
    }

    public void a(Integer num, Integer num2, boolean z) {
        final String str;
        final int i = 2;
        if (this.fvo.bkX() != null) {
            TextView bkX = this.fvo.bkX();
            if (z) {
                bkX.setVisibility(8);
                return;
            }
            if (num.intValue() == 2) {
                bkX.setText("修改实名认证信息");
                bkX.setVisibility(0);
                str = "https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + this.forumId + "&nomenu=1";
            } else if (num2.intValue() >= 0 && num2.intValue() <= 100) {
                bkX.setText("目标已完成" + String.valueOf(num2) + "%");
                bkX.setVisibility(0);
                str = "https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.fvg + "&nomenu=1";
                i = 1;
            } else {
                bkX.setVisibility(8);
                i = 0;
                str = "";
            }
            bkX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.17
                /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13387").bS("fid", FrsFragment.this.forumId).bS("uid", TbadkCoreApplication.getCurrentAccount()).O("obj_type", i));
                    ba.amQ().b(FrsFragment.this.getPageContext(), new String[]{str});
                }
            });
        }
    }

    private boolean bjZ() {
        return this.fuR == null || !this.fuR.isPrivateForum() || this.fuR.getPrivateForumTotalInfo() == null || this.fuR.getPrivateForumTotalInfo().ahH() == null || this.fuR.getUserData().getIs_manager() != 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qm(int i) {
        List<WindowToast> list;
        if (TbadkCoreApplication.isLogin() && this.fuR != null && (list = this.fuR.mWindowToast) != null && list.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < list.size()) {
                    WindowToast windowToast = list.get(i3);
                    if (windowToast == null || windowToast.toast_type.intValue() != i) {
                        i2 = i3 + 1;
                    } else if (!com.baidu.tbadk.core.util.aq.isEmpty(windowToast.toast_link)) {
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), "", com.baidu.tbadk.util.ad.addParamsForPageTranslucent(windowToast.toast_link), true)));
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
    public void bka() {
        if (this.fuR == null || this.fuR.getForum() != null) {
            this.fvo.bld();
        } else if (this.fuR.getForum().getYuleData() != null && this.fuR.getForum().getYuleData().akJ()) {
            TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_VIEW);
            this.fvo.a(this.fuR.getForum().getYuleData().akK());
        } else {
            this.fvo.bld();
        }
    }

    private void I(boolean z, boolean z2) {
        if (this.fvF != null && this.fuR != null && this.fvo != null && z) {
            if (!this.fvF.bpt() && this.fvF.bpk() == 1) {
                if (!this.fvF.bpr()) {
                    this.fuR.addCardVideoInfoToThreadList();
                    this.fuR.addVideoInfoToThreadListInTenAndFifteenFloor();
                }
                boolean z3 = false;
                if (this.fvo.ble().o(com.baidu.tieba.card.data.n.eQK)) {
                    z3 = this.fuR.addHotTopicDataToThreadList();
                }
                if (!z3) {
                    this.fuR.addFeedForumDataToThreadList();
                }
                if (TbadkCoreApplication.getInst().isRecAppExist()) {
                    this.fuR.addRecommendAppToThreadList(this);
                }
                if (!this.fvo.ble().o(bh.cbJ)) {
                    this.fuR.removeAlaLiveThreadData();
                }
                this.fuR.addSchoolRecommendToThreadList();
            }
            if (!this.fvo.ble().o(bh.cbJ)) {
                this.fuR.removeAlaInsertLiveData();
                this.fuR.removeAlaStageLiveDat();
            } else {
                this.fuR.addInsertLiveDataToThreadList();
                this.fuR.addStageLiveDataToThreadList();
            }
            this.fuR.checkLiveStageInThreadList();
            this.fuR.addNoticeThreadToThreadList();
            if (this.fvo.ble().o(com.baidu.tieba.h.b.fYv)) {
                this.fuR.addGameRankListToThreadList(z2);
            }
            if (TbadkCoreApplication.isLogin() && (!this.fvF.bpt() || this.fvF.isNetFirstLoad)) {
                this.fuR.addUserRecommendToThreadList();
            }
            this.fuR.addVideoActivityToTop();
        }
    }

    public boolean bkb() {
        if (this.fvG != null && this.fvF != null) {
            this.fvG.a(this.fvF.getPageType(), this.fuR);
        }
        boolean z = false;
        if (this.fuR != null) {
            z = this.fuR.hasTab();
        }
        bkd();
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qn(int i) {
        am amVar = null;
        bkb();
        bkk();
        try {
            if (this.fuR != null) {
                this.fvo.a((ArrayList<com.baidu.adp.widget.ListView.m>) null, this.fuR);
                this.fvG.rS(1);
                this.fvo.bkV();
                this.fvH.a(this.fuR, this.fvF.bpp());
                com.baidu.tieba.frs.tab.d rZ = this.fvH.rZ(this.fuR.getFrsDefaultTabId());
                if (rZ != null && !TextUtils.isEmpty(rZ.url)) {
                    amVar = new am();
                    amVar.ext = rZ.url;
                    amVar.stType = rZ.name;
                }
                this.fvF.a(this.fuR.getFrsDefaultTabId(), 0, amVar);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(boolean z, boolean z2) {
        try {
            if (this.fuR != null && this.fvH != null && this.fvF != null) {
                if (!this.fvo.ble().o(bh.cbJ)) {
                    this.fuR.removeAlaLiveThreadData();
                }
                boolean isEmpty = com.baidu.tbadk.core.util.v.isEmpty(this.fuR.getGameTabInfo());
                this.fvo.jM(isEmpty);
                if (!isEmpty) {
                    if (this.fwb == null) {
                        this.fwb = new com.baidu.tieba.frs.vc.e(this, (NoPressedRelativeLayout) this.mRootView);
                    }
                    if (this.dJn == null) {
                        this.dJn = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
                    }
                } else {
                    this.fwb = null;
                    this.dJn = null;
                }
                if (this.fuR.getForum() != null) {
                    this.fvg = this.fuR.getForum().getName();
                    this.forumId = this.fuR.getForum().getId();
                }
                if (this.fuR.hasTab()) {
                    this.fvH.a(this.fuR, this.fvF.bpp());
                }
                if (z) {
                    I(true, z);
                } else {
                    I(this.fvB, z);
                }
                bkb();
                if (this.fvN != null) {
                    this.fvN.a(this.fvG, this.fuR);
                }
                if (this.fuR.getPage() != null) {
                    setHasMore(this.fuR.getPage().ahA());
                }
                ArrayList<com.baidu.adp.widget.ListView.m> a2 = this.fvR.a(z2, true, this.fuR.getThreadList(), null, z, false);
                if (a2 != null) {
                    this.fuR.setThreadList(a2);
                }
                this.fuR.removeRedundantUserRecommendData();
                this.fuT = this.fuR.getTopThreadSize();
                if (this.fvk != null) {
                    this.fvj = true;
                    this.fvk.zN(this.fuT);
                    com.baidu.tieba.frs.f.a.a(this, this.fuR.getForum(), this.fuR.getThreadList(), this.fvj, getPn());
                }
                if (this.fvF.bpk() == 1) {
                    bkh();
                    if (!z && this.fvF.getPn() == 1) {
                        bkc();
                    }
                }
                if (this.fvP != null) {
                    this.fvP.bV(this.fvH.bqT());
                }
                bjS();
                this.fvo.bkN();
                this.fvo.K(true, false);
                if (z && this.fuR.isFirstTabEqualAllThread()) {
                    com.baidu.adp.lib.g.e.fZ().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.18
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!FrsFragment.this.fvy) {
                                FrsFragment.this.fvo.bln();
                            }
                        }
                    });
                }
                if (this.fuR.getForum() != null) {
                    this.fvo.vN(this.fuR.getForum().getWarningMsg());
                }
                if (this.fuR != null && this.fuR.getFrsVideoActivityData() != null && com.baidu.tbadk.core.sharedPref.b.alR().getLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 0L) == 0) {
                    com.baidu.adp.lib.g.e.fZ().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.19
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsFragment.this.fvo.blk();
                        }
                    }, 1000L);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FRS_SHOW_AR_ENTRY, this));
                this.fvo.bkH();
                if (this.fuR != null && this.fuR.getForum() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ENTER_FORUM, new VisitedForumData(this.fuR.getForum().getId(), this.fuR.getForum().getName(), this.fuR.getForum().getImage_url(), String.valueOf(System.currentTimeMillis() / 1000), ConstantData.Forum.SPECAIL_FORUM_TYPE_LIVE.equals(this.fuR.getForum().special_forum_type), this.fuR.getForum().getThemeColorInfo(), this.fuR.getForum().getMember_num())));
                }
                this.fwg.a(this.fuR.bottomMenuList, this.fuR.getForum());
                bkx();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void jD(boolean z) {
        com.baidu.tieba.q.c.cnk().b(getUniqueId(), z);
    }

    public void bkc() {
        if (this.fvU == null) {
            this.fvU = new com.baidu.tieba.frs.live.a(this, com.baidu.adp.lib.g.b.toInt(this.forumId, 0));
        }
        this.fvU.boS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.tbadkCore.l lVar) {
        try {
            if (!this.fvy && lVar != null && this.fuR != null) {
                this.fuR.receiveData(lVar);
                J(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void bkd() {
        if (this.fvF != null) {
            vL(this.fvF.getPageType());
        } else {
            vL("normal_page");
        }
    }

    private void vL(String str) {
        jE("frs_page".equals(str));
        if (this.fvN != null) {
            this.fvN.a(this.fvG, this.fvo, this.fuR);
        }
    }

    public void jE(boolean z) {
        if (this.fvS != null) {
            this.fvS.bqM();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.q.c.cnk().v(getUniqueId());
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.frs_activity, viewGroup, false);
            this.fva = new com.baidu.tieba.frs.entelechy.a();
            this.fvN = this.fva.bmG();
            this.fvG = new com.baidu.tieba.frs.vc.f(this, this.fva, (FrsHeaderViewContainer) this.mRootView.findViewById(R.id.header_view_container));
            this.fvH = new FrsTabViewController(this, this.mRootView);
            this.fvH.registerListener();
            this.fvG.a(this.fvH);
            this.fvH.a(this.fwu);
            Intent intent = getActivity().getIntent();
            if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                this.fvc = true;
            }
            this.fvo = new k(this, this.fwM, this.fva, this.fvc, this.fvG);
            this.fwg = new com.baidu.tieba.frs.brand.buttommenu.a(getPageContext(), this.mRootView);
        } else {
            if (this.mRootView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            if (this.fvH != null) {
                this.fvH.registerListener();
            }
            this.fvo.blj();
            this.mRootView.setLeft(0);
            this.mRootView.setRight(com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getContext()));
        }
        this.fwk = true;
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        ArrayList<com.baidu.adp.widget.ListView.m> arrayList = null;
        this.fbN = System.currentTimeMillis();
        this.beginTime = this.fbN;
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.fvl = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.fbN = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            ap(intent);
        }
        this.cLZ = this.beginTime - this.fbN;
        this.fvk = new com.baidu.tieba.tbadkCore.data.f("frs", com.baidu.tieba.tbadkCore.data.f.jhM);
        if (this.fvF == null) {
            this.fvF = new FrsModelController(this, this.fwI);
            this.fvF.a(this.fwt);
            this.fvF.init();
        }
        if (intent != null) {
            this.fvF.K(intent.getExtras());
        } else if (bundle != null) {
            this.fvF.K(bundle);
        } else {
            this.fvF.K(null);
        }
        if (intent != null) {
            this.fvG.Q(intent.getExtras());
        } else if (bundle != null) {
            this.fvG.Q(bundle);
        } else {
            this.fvG.Q(null);
        }
        this.fvn = getVoiceManager();
        this.fvV = new j(getPageContext(), this);
        initUI();
        initData(bundle);
        if (!bkr()) {
            this.fvL = new ak(getActivity(), this.fvo, this.fvG);
            this.fvL.kd(true);
        }
        this.fvn = getVoiceManager();
        if (this.fvn != null) {
            this.fvn.onCreate(getPageContext());
        }
        new com.baidu.tieba.frs.mc.i();
        int i = -1;
        if (this.fvR != null && this.fvR.bpd() != null) {
            i = this.fvR.bpd().bjQ();
            arrayList = this.fvR.bpd().getDataList();
        }
        this.fvR = new com.baidu.tieba.frs.mc.c(this, this.fwK);
        this.fvR.bpd().setHasMore(i);
        if (arrayList != null && arrayList.size() > 0) {
            this.fvR.bpd().ai(arrayList);
        }
        this.fvJ = new com.baidu.tieba.frs.smartsort.a(this);
        this.fvS = new com.baidu.tieba.frs.vc.h(this);
        this.fvP = new com.baidu.tieba.frs.vc.a(getPageContext(), this.fvF.bpq());
        this.fvK = new com.baidu.tieba.frs.mc.b(this);
        this.fvQ = new com.baidu.tieba.frs.mc.d(this);
        this.fvI = new com.baidu.tieba.frs.mc.h(this);
        this.fvT = new com.baidu.tieba.frs.mc.a(this);
        this.fvW = new com.baidu.tieba.frs.vc.c(this);
        this.fvX = new com.baidu.tieba.frs.mc.e(this, getUniqueId());
        this.fwe = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "frs");
        this.fwf = new com.baidu.tieba.ala.a(getPageContext());
        this.fwh = new com.baidu.tieba.frs.sportspage.notification.a(getPageContext());
        registerListener(this.fwC);
        registerListener(this.mMemListener);
        registerListener(this.fwA);
        registerListener(this.fwL);
        registerListener(this.fwz);
        registerListener(this.fwJ);
        registerListener(this.fww);
        registerListener(this.fwx);
        registerListener(this.fwy);
        registerListener(this.fwq);
        registerListener(this.fwr);
        registerListener(this.FX);
        registerListener(this.fwQ);
        registerListener(this.fwE);
        registerListener(this.fws);
        registerListener(this.fwF);
        registerListener(this.fwD);
        this.fwp.setTag(getPageContext().getUniqueId());
        registerListener(this.fwp);
        registerListener(this.fwG);
        registerListener(this.fwH);
        this.fwR.setTag(getPageContext().getUniqueId());
        MessageManager.getInstance().registerListener(this.fwR);
        registerListener(this.fwS);
        this.fvo.jO(false);
        if (!bkr() && !this.hasInit) {
            showLoadingView(this.fvo.aYd(), true);
            this.fvF.E(3, false);
        }
        com.baidu.tieba.frs.a.biW().a(new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.22
            @Override // com.baidu.tieba.frs.a.b
            public void H(boolean z, boolean z2) {
                if (FrsFragment.this.fvo != null) {
                    FrsFragment.this.fvo.qw(z ? 0 : 8);
                    if (!z2) {
                        FrsFragment.this.fwj = z;
                    }
                    if (FrsFragment.this.fvo.ble() != null && FrsFragment.this.fvF != null && FrsFragment.this.fvF.bpl()) {
                        FrsFragment.this.fvo.ble().notifyDataSetChanged();
                    }
                    if (FrsFragment.this.bjN() != null) {
                        FrsTabViewController.b bqU = FrsFragment.this.bjN().bqU();
                        if (bqU != null && bqU.tabId == 502 && (bqU.fragment instanceof FrsCommonTabFragment)) {
                            ((FrsCommonTabFragment) bqU.fragment).bmC();
                        } else if (bqU != null && bqU.tabId == 503 && (bqU.fragment instanceof FrsNewAreaFragment)) {
                            FrsNewAreaFragment frsNewAreaFragment = (FrsNewAreaFragment) bqU.fragment;
                            frsNewAreaFragment.bmC();
                            if (frsNewAreaFragment.bpx() != null) {
                                com.baidu.tieba.frs.mc.g bpx = frsNewAreaFragment.bpx();
                                bpx.jR(!z);
                                bpx.jS(!z);
                            }
                        }
                        if (FrsFragment.this.bjN().bqN() != null) {
                            FrsFragment.this.bjN().bqN().setmDisallowSlip(z);
                            FrsFragment.this.bjN().kH(z);
                        }
                    }
                    if (FrsFragment.this.fvo.bkL() != null) {
                        FrsFragment.this.fvo.jL(!z);
                    }
                    if (FrsFragment.this.getActivity() instanceof FrsActivity) {
                        ((FrsActivity) FrsFragment.this.getActivity()).jB(!z);
                    }
                    if (FrsFragment.this.fwg != null) {
                        FrsFragment.this.fwg.kk(!z);
                    }
                    FrsFragment.this.fvo.jR(!z);
                    FrsFragment.this.fvo.jS(z ? false : true);
                }
            }

            @Override // com.baidu.tieba.frs.a.b
            public void qj(int i2) {
                if (FrsFragment.this.fvo != null) {
                    FrsFragment.this.fvo.qx(i2);
                }
            }

            @Override // com.baidu.tieba.frs.a.b
            public void bjd() {
                com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getContext(), (int) R.string.frs_multi_delete_max_num);
            }
        });
        this.fvo.b(new d.a() { // from class: com.baidu.tieba.frs.FrsFragment.24
            @Override // com.baidu.tieba.NEGFeedBack.d.a
            public void a(DeleteThreadHttpResponseMessage deleteThreadHttpResponseMessage) {
                boolean z;
                int i2 = 0;
                if (deleteThreadHttpResponseMessage != null) {
                    FrsFragment.this.fvo.aBO();
                    FrsFragment.this.fvo.bll();
                    FrsNewAreaFragment frsNewAreaFragment = null;
                    if (FrsFragment.this.fvH == null || FrsFragment.this.fvH.bqU() == null || !(FrsFragment.this.fvH.bqU().fragment instanceof FrsNewAreaFragment)) {
                        z = false;
                    } else {
                        frsNewAreaFragment = (FrsNewAreaFragment) FrsFragment.this.fvH.bqU().fragment;
                        z = true;
                    }
                    if (deleteThreadHttpResponseMessage.getError() == 0) {
                        String text = !TextUtils.isEmpty(deleteThreadHttpResponseMessage.getText()) ? deleteThreadHttpResponseMessage.getText() : FrsFragment.this.getString(R.string.delete_fail);
                        if (deleteThreadHttpResponseMessage.getRetType() == 1211066) {
                            if (FrsFragment.this.ePj == null) {
                                FrsFragment.this.ePj = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.ePj.nn(text);
                            FrsFragment.this.ePj.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.24.1
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.ePj.eh(false);
                            FrsFragment.this.ePj.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.ePj.akO();
                        } else if (deleteThreadHttpResponseMessage.getRetType() == 1211067) {
                            if (FrsFragment.this.ePj == null) {
                                FrsFragment.this.ePj = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.ePj.nn(text);
                            FrsFragment.this.ePj.a(R.string.know, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.24.2
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.ePj.eh(false);
                            FrsFragment.this.ePj.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.ePj.akO();
                        } else {
                            FrsFragment.this.fvo.ar(deleteThreadHttpResponseMessage.getText(), ContextCompat.getColor(FrsFragment.this.getContext(), deleteThreadHttpResponseMessage.getRetType() == 1 ? R.color.nav_bar_tip_error : R.color.cp_link_tip_a_alpha95));
                        }
                        if (z && frsNewAreaFragment != null) {
                            frsNewAreaFragment.cw(deleteThreadHttpResponseMessage.getSuccessItems());
                        }
                        FrsFragment.this.cl(deleteThreadHttpResponseMessage.getSuccessItems());
                        com.baidu.tieba.frs.a.biW().ck(deleteThreadHttpResponseMessage.getSuccessItems());
                        for (com.baidu.adp.widget.ListView.m mVar : FrsFragment.this.fuR.getThreadList()) {
                            if (mVar instanceof bg) {
                                i2++;
                                continue;
                            }
                            if (i2 >= 6) {
                                break;
                            }
                        }
                        if (i2 < 6) {
                            FrsFragment.this.aIW();
                            return;
                        }
                        return;
                    }
                    com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getActivity(), deleteThreadHttpResponseMessage.getErrorString());
                }
            }
        });
        this.hasInit = true;
        qo(1);
        super.onActivityCreated(bundle);
        this.createTime = System.currentTimeMillis() - this.beginTime;
    }

    public void jF(boolean z) {
        if (this.fvH != null) {
            this.fvH.fTV = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cl(List<String> list) {
        if (!com.baidu.tbadk.core.util.v.isEmpty(list)) {
            ArrayList<com.baidu.adp.widget.ListView.m> threadList = this.fuR.getThreadList();
            if (!com.baidu.tbadk.core.util.v.isEmpty(threadList) && this.fvo.getListView() != null && this.fvo.getListView().getData() != null) {
                Iterator<com.baidu.adp.widget.ListView.m> it = threadList.iterator();
                List<com.baidu.adp.widget.ListView.m> data = this.fvo.getListView().getData();
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.m next = it.next();
                    if (next instanceof bg) {
                        bh bhVar = ((bg) next).cbq;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= list.size()) {
                                break;
                            } else if (!com.baidu.tbadk.core.util.aq.equals(list.get(i2), bhVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.fvR.d(next);
                                this.fvo.getListView().getAdapter().notifyItemRemoved(i);
                                break;
                            }
                        }
                    }
                    i++;
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void aJp() {
        if (isAdded() && this.dyK && !isLoadingViewAttached()) {
            showLoadingView(this.fvo.aYd(), true);
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void aJq() {
        if (isAdded() && this.dyK && isLoadingViewAttached()) {
            hideLoadingView(this.fvo.aYd());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (bkr()) {
            showLoadingView(this.fvo.aYd(), true);
            this.fvo.qy(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.fvF.E(3, true);
            aof().scrollToPosition(0);
        }
    }

    private void qo(int i) {
        String str = "";
        if (this.fuR != null && this.fuR.getForum() != null) {
            str = this.fuR.getForum().getId();
        }
        if (!StringUtils.isNull(str)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13008").bS("fid", str).bS("obj_type", "4").O("obj_locate", i).bS("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.w wVar) {
        if (wVar != null) {
            this.cPo = wVar.axN();
            this.fvY = wVar.axO();
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void showFloatingView() {
        if (this.cPo != null) {
            this.cPo.fE(true);
        }
    }

    private void ap(Intent intent) {
        if (intent != null) {
            if (intent != null) {
                if (!com.baidu.tieba.frs.f.f.a(this, getForumName(), "from", intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false)) && getActivity() != null) {
                    getActivity().finish();
                    return;
                }
            }
            if (intent != null && intent.getData() != null) {
                Uri data = intent.getData();
                this.fvg = data.getQueryParameter("name");
                this.mFrom = data.getQueryParameter("from");
                if (!StringUtils.isNull(this.fvg)) {
                    intent.putExtra("name", this.fvg);
                }
                if (!StringUtils.isNull(this.mFrom)) {
                    intent.putExtra("from", this.mFrom);
                }
                TiebaStatic.log(TbadkCoreStatisticKey.AS_INVOKE_TIEBA);
            }
            if (StringUtils.isNull(this.fvg) && intent != null && intent.getData() != null) {
                Uri data2 = intent.getData();
                if (com.baidu.tbadk.BdToken.f.k(data2)) {
                    com.baidu.tbadk.BdToken.f.aep().b(data2, new f.a() { // from class: com.baidu.tieba.frs.FrsFragment.25
                        @Override // com.baidu.tbadk.BdToken.f.a
                        public void o(HashMap<String, Object> hashMap) {
                            if (hashMap != null && (hashMap.get(com.baidu.tbadk.BdToken.f.bSp) instanceof String)) {
                                FrsFragment.this.fvg = (String) hashMap.get(com.baidu.tbadk.BdToken.f.bSp);
                            }
                        }
                    });
                } else {
                    com.baidu.tieba.frs.f.d as = com.baidu.tieba.frs.f.i.as(intent);
                    if (as != null) {
                        this.fvg = as.forumName;
                        if (as.fSs == null || as.fSs.equals("aidou")) {
                        }
                    }
                }
                if (!StringUtils.isNull(this.fvg)) {
                    intent.putExtra("name", this.fvg);
                }
                intent.putExtra(FrsActivityConfig.FRS_CALL_FROM, 12);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.fvn = getVoiceManager();
        if (this.fvn != null) {
            this.fvn.onStart(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        Intent intent;
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.cwZ);
        if (bundle != null) {
            this.fvg = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
            this.fvg = intent.getStringExtra("name");
            this.mFrom = intent.getStringExtra("from");
            this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
        }
        if (getArguments() != null) {
            this.fvh = getArguments().getBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, false);
        }
        if (TextUtils.isEmpty(this.mFrom) || FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
        }
        if (this.mIsLogin) {
            registerListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL, this.cwZ);
        }
        this.fvG.Q(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.q.c.cnk().w(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.fwQ);
        fvs = null;
        if (this.fvn != null) {
            this.fvn.onDestory(getPageContext());
        }
        com.baidu.tieba.recapp.report.a.remove("FRS");
        this.fvn = null;
        com.baidu.tieba.card.t.baw().iK(false);
        if (this.fuR != null && this.fuR.getForum() != null) {
            aa.blI().cL(com.baidu.adp.lib.g.b.toLong(this.fuR.getForum().getId(), 0L));
        }
        if (this.fvU != null) {
            this.fvU.onDestory();
        }
        if (this.fvo != null) {
            com.baidu.tieba.frs.f.h.a(this.fvo, this.fuR, getForumId(), false, null);
            this.fvo.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.fvA != null) {
                this.fvA.awF();
            }
            this.fvo.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.fvG.aGH();
        if (this.fvF != null) {
            this.fvF.aMM();
        }
        if (this.fvL != null) {
            this.fvL.axM();
        }
        if (this.fvO != null) {
            this.fvO.destory();
        }
        if (this.fvP != null) {
            this.fvP.destory();
        }
        if (this.fvJ != null) {
            this.fvJ.onDestroy();
        }
        if (this.fwb != null) {
            this.fwb.onDestory();
        }
        if (this.fvT != null) {
            this.fvT.onDestroy();
        }
        if (this.fwe != null) {
            this.fwe.onDestroy();
        }
        if (this.fwf != null) {
            this.fwf.onDestroy();
        }
        com.baidu.tieba.recapp.d.a.cgD().cgF();
        com.baidu.tieba.frs.f.j.bqe();
        if (this.fvH != null) {
            this.fvH.a((FrsTabViewController.a) null);
            this.fvH.bqW();
        }
        if (this.fwi != null) {
            this.fwi.onDestroy();
        }
        com.baidu.tieba.frs.a.biW().a(null);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.fvg);
        bundle.putString("from", this.mFrom);
        this.fvF.onSaveInstanceState(bundle);
        if (this.fvn != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            this.fvn.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.fvT != null) {
            this.fvT.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.fvo != null) {
            this.fvo.bkS();
            this.fvo.onResume();
        }
        this.fvI.kA(true);
        this.fvB = true;
        if (fvf) {
            fvf = false;
            this.fvo.startPullRefresh();
            return;
        }
        if (this.fvn != null) {
            this.fvn.onResume(getPageContext());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_RESUME));
        this.fvo.jT(false);
        if (this.fwc) {
            refresh(6);
            this.fwc = false;
        }
        bkx();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
    }

    public boolean bke() {
        Intent intent;
        if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
            return false;
        }
        return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
    }

    public void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.fvg = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.fvi = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.fvi) {
                bkf();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkf() {
        this.fvo.startPullRefresh();
    }

    public void closeActivity() {
        com.baidu.tieba.frs.f.i.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.mFrom);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.fvo.setTitle(this.fvg);
        } else {
            this.fvo.setTitle("");
            this.mFlag = 1;
        }
        this.fvo.a(this.fwO);
        this.fvo.addOnScrollListener(this.mScrollListener);
        this.fvo.h(this.fsT);
        this.fvo.ble().a(this.fwN);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fwk) {
            this.fvo.onChangeSkinType(i);
            this.fvG.rR(i);
            this.fvH.onChangeSkinType(i);
            if (this.fvq != null) {
                this.fvq.onChangeSkinType(i);
            }
            if (this.fvZ != null) {
                this.fvZ.onChangeSkinType();
            }
            if (this.fwg != null) {
                this.fwg.onChangeSkinType(getPageContext(), i);
            }
            if (this.ePj != null) {
                com.baidu.tbadk.s.a.a(getPageContext(), this.ePj.getRealView());
            }
            if (this.fwa != null) {
                this.fwa.onChangeSkinType();
            }
        }
    }

    public void qp(int i) {
        if (!this.mIsLogin) {
            if (this.fuR != null && this.fuR.getAnti() != null) {
                this.fuR.getAnti().setIfpost(1);
            }
            if (i == 0) {
                bc.skipToLoginActivity(getActivity());
            }
        } else if (this.fuR != null) {
            if (i == 0) {
                com.baidu.tieba.frs.f.j.d(this, 0);
            } else {
                this.fvo.bkU();
            }
        }
    }

    public void refresh() {
        com.baidu.tieba.a.d.aDe().rg("page_frs");
        refresh(3);
    }

    public void refresh(int i) {
        this.fvy = false;
        bkk();
        if (this.fvo != null && this.fvo.bkJ() != null) {
            this.fvo.bkJ().bur();
        }
        if (this.fvF != null) {
            this.fvF.E(i, true);
        }
    }

    private void bkg() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.g.h.ga().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.29
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.DW(FrsFragment.this.fvg);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkh() {
        bkk();
        try {
            if (this.fuR != null) {
                this.fvo.aMq();
                this.fvo.jL(bkw());
                if (!com.baidu.tieba.frs.vc.f.l(this.fuR) || !com.baidu.tieba.frs.vc.f.k(this.fuR)) {
                }
                if (this.fuR.getForum() != null) {
                    this.fvg = this.fuR.getForum().getName();
                    this.forumId = this.fuR.getForum().getId();
                }
                if (this.fuR.getPage() != null) {
                    setHasMore(this.fuR.getPage().ahA());
                }
                this.fvo.setTitle(this.fvg);
                this.fvo.setForumName(this.fvg);
                TbadkCoreApplication.getInst().setDefaultBubble(this.fuR.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.fuR.getUserData().getBimg_end_time());
                bkg();
                bki();
                ArrayList<com.baidu.adp.widget.ListView.m> threadList = this.fuR.getThreadList();
                if (threadList != null) {
                    this.fvo.a(threadList, this.fuR);
                    com.baidu.tieba.frs.f.c.y(this.fvo);
                    this.fvG.rS(getPageNum());
                    this.fvG.i(this.fuR);
                    this.fvH.a(this.fuR, this.fvF.bpp());
                    this.fvo.bkV();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void bki() {
        if (this.fuR != null) {
            if (this.fuR.getIsNewUrl() == 1) {
                this.fvo.ble().setFromCDN(true);
            } else {
                this.fvo.ble().setFromCDN(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.fvI.kA(false);
        this.fvB = false;
        this.fvo.onPause();
        if (this.fvn != null) {
            this.fvn.onPause(getPageContext());
        }
        this.fvo.jT(true);
        if (this.fvP != null) {
            this.fvP.bqh();
        }
        com.baidu.tbadk.BdToken.c.adZ().aee();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.fvH != null && this.fvH.bqU() != null && (this.fvH.bqU().fragment instanceof BaseFragment)) {
            ((BaseFragment) this.fvH.bqU().fragment).setPrimary(z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.t.baw().iK(false);
        jD(false);
        if (this.fuR != null && this.fuR.getForum() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            com.baidu.tbadk.distribute.a.atN().a(getPageContext().getPageActivity(), "frs", this.fuR.getForum().getId(), 0L);
        }
        if (this.fvn != null) {
            this.fvn.onStop(getPageContext());
        }
        if (aof() != null) {
            aof().getRecycledViewPool().clear();
        }
        this.fvG.anG();
        com.baidu.tbadk.util.x.axQ();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            if (this.fvG != null) {
                this.fvG.jJ(isPrimary());
            }
            if (this.fvo != null) {
                this.fvo.jJ(isPrimary());
                this.fvo.jT(!isPrimary());
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (com.baidu.tieba.frs.a.biW().biX()) {
                com.baidu.tieba.frs.a.biW().reset();
                return true;
            } else if (this.fvo != null) {
                return this.fvo.bkR();
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
        com.baidu.tbadk.distribute.a.atN().a(advertAppInfo, this.forumId, 0L, "FRS", str, getPn());
    }

    @Override // com.baidu.tieba.recapp.n
    public void bkj() {
        bjK().bkj();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.fvn == null) {
            this.fvn = VoiceManager.instance();
        }
        return this.fvn;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdRecyclerView aof() {
        if (this.fvo == null) {
            return null;
        }
        return this.fvo.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void bkk() {
        if (this.fvn != null) {
            this.fvn.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> aog() {
        if (this.csh == null) {
            this.csh = UserIconBox.o(getPageContext().getPageActivity(), 8);
        }
        return this.csh;
    }

    public void bkl() {
        if (getFragmentActivity() != null && getFragmentActivity().getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.p onGetPreLoadListView() {
        return aof().getPreLoadHandle();
    }

    @Override // com.baidu.tieba.frs.ah
    public NavigationBar aKR() {
        if (this.fvo == null) {
            return null;
        }
        return this.fvo.aKR();
    }

    public FRSRefreshButton bkm() {
        return this.fvq;
    }

    public void a(FRSRefreshButton fRSRefreshButton) {
        if (fRSRefreshButton != null) {
            this.fvq = fRSRefreshButton;
            this.fvq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.36
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (FrsFragment.this.fvH != null) {
                        FrsTabViewController.b bqU = FrsFragment.this.fvH.bqU();
                        if (bqU != null && bqU.fragment != null && (bqU.fragment instanceof ag)) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                            ((ag) bqU.fragment).bjy();
                            ((ag) bqU.fragment).aKh();
                            return;
                        }
                        FrsFragment.this.bjP().startPullRefresh();
                    }
                }
            });
        }
    }

    public void bkn() {
        if (this.fvq != null && this.fvr) {
            if (this.fwm != null) {
                this.fwm.cancel();
            }
            this.fwm = new AlphaAnimation(1.0f, 0.0f);
            this.fwm.setDuration(300L);
            this.fwm.setFillAfter(true);
            this.fvq.startAnimation(this.fwm);
            this.fvq.setClickable(false);
            this.fvr = false;
        }
    }

    public void bko() {
        if (this.fvq != null && !this.fvr && this.fvH.bqX() != 0) {
            this.fvq.setVisibility(0);
            if (this.fwn != null) {
                this.fwn.cancel();
            }
            this.fwn = new AlphaAnimation(0.0f, 1.0f);
            this.fwn.setDuration(300L);
            this.fwn.setFillAfter(true);
            this.fvq.startAnimation(this.fwn);
            this.fvq.setClickable(true);
            this.fvr = true;
        }
    }

    /* loaded from: classes4.dex */
    private final class a implements com.baidu.adp.widget.ListView.s {
        private a() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.s
        public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null) {
                if (bdUniqueId == p.fyx) {
                    if (FrsFragment.this.fvo != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11752").bS("fid", FrsFragment.this.forumId).bS("obj_locate", "1"));
                        FrsFragment.this.fvo.startPullRefresh();
                    }
                } else if (mVar != null && (mVar instanceof bg)) {
                    bh bhVar = ((bg) mVar).cbq;
                    if (bhVar.ajy() == null || bhVar.ajy().getGroup_id() == 0 || bc.checkUpIsLogin(FrsFragment.this.getActivity())) {
                        if (bhVar.ajq() != 1 || bc.checkUpIsLogin(FrsFragment.this.getActivity())) {
                            if (bhVar.aiT() != null) {
                                if (bc.checkUpIsLogin(FrsFragment.this.getActivity())) {
                                    String postUrl = bhVar.aiT().getPostUrl();
                                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.isNetOk()) {
                                        com.baidu.tbadk.browser.a.startInternalWebActivity(FrsFragment.this.getActivity(), postUrl);
                                    }
                                }
                            } else if (bhVar.ajJ() != null) {
                                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                    bc.skipToLoginActivity(FrsFragment.this.getPageContext().getPageActivity());
                                    return;
                                }
                                com.baidu.tbadk.core.data.o ajJ = bhVar.ajJ();
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), ajJ.getCartoonId(), ajJ.getChapterId(), 2)));
                            } else {
                                com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                                if (readThreadHistory != null && !readThreadHistory.Ec(bhVar.getId())) {
                                    readThreadHistory.Eb(bhVar.getId());
                                }
                                boolean z = false;
                                final String aiN = bhVar.aiN();
                                if (aiN != null && !aiN.equals("")) {
                                    z = true;
                                    new Thread(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.a.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(aiN);
                                            xVar.amr().amR().mIsNeedAddCommenParam = false;
                                            xVar.amr().amR().mIsUseCurrentBDUSS = false;
                                            xVar.getNetData();
                                        }
                                    }).start();
                                }
                                String tid = bhVar.getTid();
                                if (tid == null) {
                                    tid = "";
                                }
                                if (bhVar.aiB() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                    ba.amQ().b(FrsFragment.this.getPageContext(), new String[]{tid, "", null});
                                    return;
                                }
                                if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                    bhVar.setId(tid.substring(3));
                                }
                                if (bdUniqueId.getId() == bh.cdh.getId()) {
                                    com.baidu.tieba.frs.f.h.a(bhVar.aim());
                                } else if (bdUniqueId.getId() == bh.cbM.getId()) {
                                    com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                                    anVar.bS("obj_type", "2");
                                    anVar.bS("tid", bhVar.getTid());
                                    TiebaStatic.log(anVar);
                                }
                                com.baidu.tieba.frs.f.i.a(FrsFragment.this, bhVar, i, z);
                                com.baidu.tieba.frs.f.h.a(FrsFragment.this, FrsFragment.this.fuR, bhVar);
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
            hideNetRefreshView(this.fvo.aYd());
            showLoadingView(this.fvo.aYd(), true);
            this.fvo.jO(false);
            this.fvF.E(3, true);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData bkp() {
        return this.fuR;
    }

    public boolean bkq() {
        return this.fvo.bkq();
    }

    public void am(Object obj) {
        if (this.fvK != null && this.fvK.fNV != null) {
            this.fvK.fNV.callback(obj);
        }
    }

    public void an(Object obj) {
        if (this.fvK != null && this.fvK.fNW != null) {
            this.fvK.fNW.callback(obj);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        this.fvo.getListView().stopScroll();
        if (!this.fvo.bla()) {
            if (!com.baidu.adp.lib.util.l.isNetOk()) {
                this.fvo.aKk();
            } else if (this.fvF.bpk() == 1) {
                aJl();
                aIW();
            } else if (this.fvF.hasMore()) {
                aIW();
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void onFailed(String str) {
        aJl();
        showToast(str);
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void aa(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        boolean isEmpty = com.baidu.tbadk.core.util.v.isEmpty(arrayList);
        setHasMore(isEmpty ? 0 : 1);
        aJl();
        if (!isEmpty) {
            if (!this.fvF.bpt() && TbadkCoreApplication.getInst().isRecAppExist() && this.fvF.bpk() == 1) {
                this.fuR.addRecommendAppToThreadList(this, arrayList);
            }
            if (this.fvF != null) {
                com.baidu.tieba.frs.d.a.a(getUniqueId(), arrayList, this.fuR.getForum(), this.fvF.getSortType());
            }
            ArrayList<com.baidu.adp.widget.ListView.m> a2 = this.fvR.a(false, false, arrayList, this.fvk, false);
            if (a2 != null) {
                this.fuR.setThreadList(a2);
                this.fvo.a(a2, this.fuR);
            }
            if (this.fvF != null) {
                com.baidu.tieba.frs.d.c.a(this.fuR, this.fvF.bpp(), 2);
            }
        }
    }

    private void aJl() {
        if (bjQ() == 1 || this.fvR.cv(this.fuR.getThreadListIds())) {
            if (com.baidu.tbadk.core.util.v.getCount(this.fuR.getThreadList()) > 3) {
                this.fvo.aKi();
            } else {
                this.fvo.blh();
            }
        } else if (com.baidu.tbadk.core.util.v.isEmpty(this.fuR.getThreadList())) {
            this.fvo.aKk();
        } else {
            this.fvo.aKj();
        }
    }

    @Override // com.baidu.tieba.frs.mc.l
    public void aIW() {
        if (this.fvR != null) {
            this.fvR.a(this.fvg, this.forumId, this.fuR);
        }
    }

    public void takePhoto() {
        if (!com.baidu.tbadk.core.util.ab.requestWriteExternalStorgeAndCameraPermission(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.al.c(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment, com.baidu.e.a.a.InterfaceC0055a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        com.baidu.tieba.frs.f.i.a(this, i, strArr, iArr);
    }

    public void jG(boolean z) {
        if (this.fvL != null) {
            this.fvL.kd(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.fvM.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a lo(int i) {
        return this.fvM.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        this.fvV.b(bVar);
    }

    public boolean bkr() {
        return this.fvc;
    }

    @Override // com.baidu.tieba.frs.ae
    public void vU() {
        if (this.fvo != null) {
            showFloatingView();
            this.fvo.getListView().scrollToPosition(0);
            this.fvo.startPullRefresh();
        }
    }

    public ForumWriteData bks() {
        if (this.fuR == null || this.fuR.getForum() == null) {
            return null;
        }
        ForumData forum = this.fuR.getForum();
        ForumWriteData forumWriteData = new ForumWriteData(forum.getId(), forum.getName(), forum.getPrefixData(), this.fuR.getAnti());
        forumWriteData.avatar = forum.getImage_url();
        forumWriteData.forumLevel = forum.getUser_level();
        forumWriteData.specialForumType = forum.special_forum_type;
        forumWriteData.firstDir = forum.getFirst_class();
        forumWriteData.secondDir = forum.getSecond_class();
        UserData userData = this.fuR.getUserData();
        forumWriteData.privateThread = userData != null ? userData.getPrivateThread() : 0;
        return forumWriteData;
    }

    @Override // com.baidu.tieba.frs.ae
    public void anO() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.frs.ae
    public void setVideoThreadId(String str) {
    }

    public void jH(boolean z) {
        this.fvC = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z) {
        super.showLoadingView(view, z);
        this.fvo.qv(8);
        ((FrsActivity) getActivity()).g(view, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        super.hideLoadingView(view);
        this.fvo.qv(0);
        ((FrsActivity) getActivity()).g(view, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        super.showNetRefreshView(view, str, z);
        this.fvo.qv(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshViewNoClick(View view, String str, boolean z) {
        super.showNetRefreshViewNoClick(view, str, z);
        this.fvo.qv(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        super.hideNetRefreshView(view);
        this.fvo.qv(0);
    }

    public void bkt() {
        FrsTabViewController.b bqU;
        if (this.fvH != null && (bqU = this.fvH.bqU()) != null && bqU.fragment != null && (bqU.fragment instanceof ag)) {
            ((ag) bqU.fragment).bjy();
        }
    }

    public void jI(boolean z) {
        this.fve = z;
    }

    public void b(OvalActionButton ovalActionButton) {
        this.fvp = ovalActionButton;
    }

    public OvalActionButton bku() {
        return this.fvp;
    }

    public boolean bkv() {
        return this.fve;
    }

    public void vM(String str) {
        if (TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.util.aq.isEmpty(str)) {
            if (this.fwi == null) {
                this.fwi = new AddExperiencedModel(getTbPageContext());
                this.fwi.a(this.fwo);
            }
            this.fwi.dR(this.forumId, str);
        }
    }

    public boolean bkw() {
        if (this.fvC && !this.fwl) {
            return (this.fvF != null && this.fvF.bpl() && com.baidu.tieba.frs.a.biW().biX()) ? false : true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.g.c
    public boolean videoNeedPreload() {
        if (this.fuR != null) {
            return com.baidu.tbadk.util.ac.axV() && (this.fuR.isFrsVideoAutoPlay || com.baidu.tbadk.core.sharedPref.b.alR().getInt(SharedPrefConfig.AUTO_PLAY_VIDEO_FRS, 0) == 1);
        }
        return super.videoNeedPreload();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.g.c
    public boolean isCyberVideoUsedThisPage() {
        return com.baidu.tbadk.a.b.mb("cyber_player_test");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkx() {
        if (!com.baidu.tbadk.core.util.aq.isEmpty(this.forumId)) {
            com.baidu.tbadk.BdToken.c.adZ().l(com.baidu.tbadk.BdToken.b.bQS, com.baidu.adp.lib.g.b.toLong(this.forumId, 0L));
        }
    }
}
