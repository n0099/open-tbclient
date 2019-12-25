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
/* loaded from: classes6.dex */
public class FrsFragment extends BaseFragment implements BdListView.e, a.InterfaceC0072a, UserIconBox.b<BdRecyclerView>, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, af, ai, ak, com.baidu.tieba.frs.loadmore.a, com.baidu.tieba.frs.mc.l, com.baidu.tieba.recapp.n {
    public static com.baidu.tieba.tbadkCore.l gjd;
    private com.baidu.tbadk.util.y dCz;
    private com.baidu.adp.lib.d.b<TbImageView> deJ;
    private com.baidu.tieba.frs.gametab.b ewJ;
    private com.baidu.tbadk.core.dialog.a fGg;
    private com.baidu.tieba.frs.entelechy.a giM;
    private com.baidu.tieba.tbadkCore.data.f giW;
    private VoiceManager giZ;
    private com.baidu.tieba.frs.mc.c gjA;
    private com.baidu.tieba.frs.vc.j gjB;
    private com.baidu.tieba.frs.mc.a gjC;
    private com.baidu.tieba.frs.live.a gjD;
    private k gjE;
    public com.baidu.tieba.frs.vc.c gjF;
    private com.baidu.tieba.frs.mc.e gjG;
    private View.OnTouchListener gjH;
    private com.baidu.tieba.frs.view.a gjI;
    private com.baidu.tieba.frs.view.c gjJ;
    private com.baidu.tieba.frs.vc.e gjK;
    private boolean gjL;
    private com.baidu.tieba.NEGFeedBack.a gjN;
    private com.baidu.tieba.ala.a gjO;
    private com.baidu.tieba.frs.brand.buttommenu.a gjP;
    private com.baidu.tieba.frs.sportspage.notification.a gjQ;
    private AddExperiencedModel gjR;
    private boolean gjT;
    private OvalActionButton gjb;
    private FRSRefreshButton gjc;
    private com.baidu.card.af gjo;
    private FrsModelController gjp;
    private com.baidu.tieba.frs.vc.h gjq;
    private FrsTabViewController gjr;
    private com.baidu.tieba.frs.mc.h gjs;
    private com.baidu.tieba.frs.smartsort.a gjt;
    private com.baidu.tieba.frs.mc.b gju;
    private al gjv;
    private com.baidu.tieba.frs.entelechy.b.b gjx;
    private com.baidu.tieba.frs.vc.a gjy;
    private com.baidu.tieba.frs.mc.d gjz;
    private int gkb;
    private View mRootView;
    public static boolean giR = false;
    public static volatile long gjf = 0;
    public static volatile long gjg = 0;
    public static volatile int mNetError = 0;
    private String giL = "";
    public boolean giN = false;
    private boolean giO = false;
    private boolean giP = false;
    private boolean giQ = true;
    public String giS = null;
    public String mFrom = null;
    public int mFlag = 0;
    public boolean giT = false;
    private boolean giU = false;
    private String mThreadId = null;
    public String forumId = null;
    private int giC = 0;
    private boolean giV = false;
    private boolean giX = false;
    private boolean giY = false;
    private l gja = null;
    public final bj Nl = null;
    private FrsViewData giA = new FrsViewData();
    public long fPB = -1;
    public long dzt = 0;
    public long dzl = 0;
    public long createTime = 0;
    public long beginTime = -1;
    public long gje = 0;
    public boolean gjh = false;
    private boolean gji = false;
    private boolean gjj = false;
    public com.baidu.tbadk.n.b gjk = null;
    private boolean gjl = true;
    private boolean gjm = true;
    private a.C0050a gjn = new a.C0050a(2);
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> gjw = new SparseArray<>();
    private boolean eiV = true;
    private boolean gjM = false;
    private boolean hasInit = false;
    private boolean gjS = false;
    private boolean gjU = false;
    private int bZc = 0;
    private int gjV = 0;
    public int mHeadLineDefaultNavTabId = -1;
    private final CustomMessageListener gjW = new CustomMessageListener(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED) { // from class: com.baidu.tieba.frs.FrsFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof bj) {
                    com.baidu.tieba.frs.f.h.a(FrsFragment.this.gja, FrsFragment.this.giA, FrsFragment.this.getForumId(), true, (bj) data);
                }
            }
        }
    };
    private CustomMessageListener gjX = new CustomMessageListener(CmdConfigCustom.CMD_CLOSE_GAME_RANK_CARD) { // from class: com.baidu.tieba.frs.FrsFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.giA != null) {
                FrsFragment.this.giA.removeGameRankListFromThreadList();
                if (FrsFragment.this.gja != null) {
                    FrsFragment.this.gja.aqe();
                }
            }
        }
    };
    private CustomMessageListener Km = new CustomMessageListener(2921401) { // from class: com.baidu.tieba.frs.FrsFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && FrsFragment.this.gjc != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() <= 0 || FrsFragment.this.gjr.bIw() == 0 || FrsFragment.this.gjr.bIt() == null || !(FrsFragment.this.gjr.bIt().fragment instanceof BaseFragment) || !((BaseFragment) FrsFragment.this.gjr.bIt().fragment).isPrimary() || FrsFragment.this.gja.bCI()) {
                    if (FrsFragment.this.gjr.bIw() != 0) {
                        FrsFragment.this.gjc.hide();
                        return;
                    }
                    return;
                }
                FrsFragment.this.gjc.show();
            }
        }
    };
    private CustomMessageListener gjY = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.FrsFragment.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 1) {
                    FrsFragment.this.bBy();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                }
            }
        }
    };
    private final aj gjZ = new aj() { // from class: com.baidu.tieba.frs.FrsFragment.39
        @Override // com.baidu.tieba.frs.aj
        public void a(int i, int i2, aq aqVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
            FrsFragment.this.bBl();
            if (FrsFragment.this.gjx != null) {
                FrsFragment.this.gjq.lT(FrsFragment.this.gjx.sZ(i));
            }
            e.b bVar = new e.b();
            if (aqVar != null) {
                bVar.isSuccess = aqVar.errCode == 0;
                bVar.errorCode = aqVar.errCode;
                bVar.errorMsg = aqVar.errMsg;
                if (bVar.isSuccess) {
                    if (com.baidu.tbadk.core.util.v.isEmpty(arrayList)) {
                        FrsFragment.this.gja.baH();
                    } else if (aqVar.hasMore) {
                        if (com.baidu.tbadk.core.util.v.getCount(FrsFragment.this.giA.getThreadList()) > 3) {
                            FrsFragment.this.gja.baF();
                        } else {
                            FrsFragment.this.gja.bCB();
                        }
                    } else if (aqVar.gnh) {
                        FrsFragment.this.gja.baG();
                    } else {
                        FrsFragment.this.gja.baH();
                    }
                }
            } else {
                aqVar = new aq();
                aqVar.pn = 1;
                aqVar.hasMore = false;
                aqVar.gnh = false;
            }
            if (i == 1) {
                FrsFragment.this.gjl = true;
                FrsFragment.this.gkn.a(FrsFragment.this.gjp.getType(), false, bVar);
            } else {
                FrsFragment.this.a(bVar);
                if (FrsFragment.this.gjp.bGh() != null) {
                    FrsFragment.this.giA = FrsFragment.this.gjp.bGh();
                }
                FrsFragment.this.bBA();
            }
            if (FrsFragment.this.gku != null) {
                FrsFragment.this.gku.a(i, i2, aqVar, arrayList);
            }
        }
    };
    private FrsTabViewController.a gka = new FrsTabViewController.a() { // from class: com.baidu.tieba.frs.FrsFragment.40
        @Override // com.baidu.tieba.frs.vc.FrsTabViewController.a
        public void mi(int i) {
            boolean z = false;
            if (i != 1) {
                com.baidu.tieba.card.r.bsy().kc(false);
                FrsFragment.this.kP(false);
            }
            if (i == 303 && i != FrsFragment.this.gkb) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13121").cp("fid", FrsFragment.this.forumId).cp("uid", TbadkCoreApplication.getCurrentAccount()));
            }
            if (i == 502) {
                FrsFragment.this.gjb.setIconFade(R.drawable.btn_frs_professional_edit_n);
            } else {
                FrsFragment.this.gjb.setIconFade(0);
            }
            FrsFragment.this.gkb = i;
            FrsFragment.this.bBD();
            com.baidu.tieba.frs.d.d.gre.gDZ = i;
            com.baidu.tieba.frs.d.d.gre.gEa = -1;
            com.baidu.tieba.frs.a bAp = com.baidu.tieba.frs.a.bAp();
            if (i == 1 && FrsFragment.this.gjS) {
                z = true;
            }
            bAp.G(z, true);
        }
    };
    private CustomMessageListener gkc = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIVE_COUNT) { // from class: com.baidu.tieba.frs.FrsFragment.41
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                FrsFragment.this.gjr.uh(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    };
    private CustomMessageListener gkd = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_LIVE_START) { // from class: com.baidu.tieba.frs.FrsFragment.42
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && ((Integer) customResponsedMessage.getData()).intValue() == 51 && FrsFragment.this.giA != null) {
                com.baidu.tieba.frs.f.j.a(FrsFragment.this.giA, FrsFragment.this.getPageContext());
            }
        }
    };
    private final CustomMessageListener gke = new CustomMessageListener(CmdConfigCustom.CMD_FRS_SELECT_ALA_LIVE_TAB) { // from class: com.baidu.tieba.frs.FrsFragment.43
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                FrsFragment.this.gjr.uf(49);
            }
        }
    };
    private final CustomMessageListener gkf = new CustomMessageListener(CmdConfigCustom.CMD_FRS_EXPERIENCE_TIP) { // from class: com.baidu.tieba.frs.FrsFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.t) && FrsFragment.this.giA != null) {
                FrsFragment.this.giA.updateLikeData((com.baidu.tieba.tbadkCore.t) customResponsedMessage.getData());
                FrsFragment.this.gjq.i(FrsFragment.this.giA);
                FrsFragment.this.gjr.a(FrsFragment.this.giA, FrsFragment.this.gjp.bGJ());
            }
        }
    };
    private final AntiHelper.a gkg = new AntiHelper.a() { // from class: com.baidu.tieba.frs.FrsFragment.3
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).Z("obj_locate", at.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).Z("obj_locate", at.a.LOCATE_LIKE_PERSON));
        }
    };
    private CustomMessageListener gkh = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.FrsFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(FrsFragment.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().djy != null) {
                        if (AntiHelper.a(FrsFragment.this.getActivity(), updateAttentionMessage.getData().djy, FrsFragment.this.gkg) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).Z("obj_locate", at.a.LOCATE_LIKE_PERSON));
                        }
                    } else if (updateAttentionMessage.getData().isSucc && updateAttentionMessage.getData().isAttention) {
                        com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getPageContext().getPageActivity(), (int) R.string.attention_success);
                    }
                }
            }
        }
    };
    private CustomMessageListener gki = new CustomMessageListener(2921346) { // from class: com.baidu.tieba.frs.FrsFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsFragment.this.refresh();
        }
    };
    private CustomMessageListener gkj = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.frs.FrsFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                FrsFragment.this.gja.c((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener gkk = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_REMIND) { // from class: com.baidu.tieba.frs.FrsFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewsRemindMessage newsRemindMessage;
            if (customResponsedMessage != null && (customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626 && (newsRemindMessage = (NewsRemindMessage) customResponsedMessage) != null) {
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (FrsFragment.this.gja != null) {
                    FrsFragment.this.gja.E(notificationCount, z);
                }
            }
        }
    };
    private final CustomMessageListener gkl = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.frs.FrsFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.isResumed()) {
                FrsFragment.this.bBR();
            }
        }
    };
    private CustomMessageListener gkm = new CustomMessageListener(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER) { // from class: com.baidu.tieba.frs.FrsFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (FrsFragment.this.gja != null) {
                    FrsFragment.this.gja.setExpanded(booleanValue);
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.p gkn = new com.baidu.tieba.tbadkCore.p() { // from class: com.baidu.tieba.frs.FrsFragment.10
        private long startTime = 0;

        @Override // com.baidu.tieba.tbadkCore.p
        public void sv(int i) {
            this.startTime = System.nanoTime();
            if (FrsFragment.this.gja != null) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsFragment.this.gja.bCm();
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
            if (FrsFragment.this.eiV) {
                FrsFragment.this.eiV = false;
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.gja, FrsFragment.this.giA, FrsFragment.this.getForumId(), false, null);
            }
            FrsFragment.this.bBl();
            FrsFragment.this.gji = true;
            if (bVar != null && bVar.isSuccess) {
                FrsFragment.this.gja.bCy().lA(com.baidu.tbadk.core.util.ar.aDX().aDY());
                FrsFragment.gjf = 0L;
                FrsFragment.gjg = 0L;
                FrsFragment.mNetError = 0;
            } else {
                FrsFragment.mNetError = 1;
            }
            if (!FrsFragment.this.gjp.bGN() && (i == 3 || i == 6)) {
                FrsFragment.this.gjA.resetData();
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (FrsFragment.this.gjp.bGh() != null) {
                FrsFragment.this.giA = FrsFragment.this.gjp.bGh();
            }
            FrsFragment.this.gja.b(FrsFragment.this.giA.getRedpacketRainData());
            FrsFragment.this.sr(1);
            if (i == 7) {
                FrsFragment.this.ss(FrsFragment.this.giA.getFrsDefaultTabId());
                return;
            }
            if (FrsFragment.this.giA.getPage() != null) {
                FrsFragment.this.setHasMore(FrsFragment.this.giA.getPage().ayy());
            }
            if (i == 4) {
                if (!FrsFragment.this.gjp.bGN() && TbadkCoreApplication.getInst().isRecAppExist() && FrsFragment.this.gjp.bGE() == 1) {
                    FrsFragment.this.giA.addRecommendAppToThreadList(FrsFragment.this);
                }
                ArrayList<com.baidu.adp.widget.ListView.m> a2 = FrsFragment.this.gjA.a(false, false, FrsFragment.this.giA.getThreadList(), FrsFragment.this.giW, false);
                if (a2 != null) {
                    FrsFragment.this.giA.setThreadList(a2);
                    FrsFragment.this.giA.checkLiveStageInThreadList();
                }
                if (FrsFragment.this.gjp != null) {
                    com.baidu.tieba.frs.d.c.a(FrsFragment.this.giA, FrsFragment.this.gjp.bGJ(), 2, FrsFragment.this.getContext());
                }
                com.baidu.tieba.frs.f.a.a(FrsFragment.this, FrsFragment.this.giA.getForum(), FrsFragment.this.giA.getThreadList(), false, FrsFragment.this.getPn());
                FrsFragment.this.dzt = System.currentTimeMillis() - currentTimeMillis;
                FrsFragment.this.gja.a(a2, FrsFragment.this.giA);
                FrsFragment.this.bBm();
                return;
            }
            FrsFragment.this.bBm();
            switch (i) {
                case 1:
                    FrsFragment.this.gja.bCm();
                    break;
                case 2:
                    FrsFragment.this.gja.bCm();
                    break;
                case 3:
                case 6:
                    if (FrsFragment.this.giA != null) {
                        FrsFragment.this.giA.clearPostThreadCount();
                    }
                    if (FrsFragment.this.gjF != null) {
                        FrsFragment.this.gjF.refresh();
                        break;
                    }
                    break;
            }
            FrsFragment.this.bBt();
            if (bVar == null || bVar.errorCode == 0) {
                if (FrsFragment.this.giA != null) {
                    FrsFragment.this.a(FrsFragment.this.giA);
                    FrsFragment.this.J(false, i == 5);
                    if (FrsFragment.this.gjp != null) {
                        if (FrsFragment.this.giA.getActivityHeadData() != null && FrsFragment.this.giA.getActivityHeadData().axO() != null && FrsFragment.this.giA.getActivityHeadData().axO().size() > 0) {
                            com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), 1, FrsFragment.this.giA.getForum(), FrsFragment.this.gjp.getSortType(), 1);
                        }
                        if (FrsFragment.this.giA.getThreadList() != null && FrsFragment.this.giA.getThreadList().size() > 0) {
                            Iterator<com.baidu.adp.widget.ListView.m> it = FrsFragment.this.giA.getThreadList().iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    com.baidu.adp.widget.ListView.m next = it.next();
                                    if ((next instanceof bj) && ((bj) next).getType() == bj.cOQ) {
                                        com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), 1, FrsFragment.this.giA.getForum(), FrsFragment.this.gjp.getSortType(), 2);
                                    }
                                }
                            }
                        }
                        com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), FrsFragment.this.giA.getThreadList(), FrsFragment.this.giA.getForum(), FrsFragment.this.gjp.getSortType());
                    }
                    FrsFragment.this.gja.sE(i);
                    FrsFragment.gjf = (System.nanoTime() - this.startTime) / TimeUtils.NANOS_PER_MS;
                    if (bVar != null) {
                        FrsFragment.gjg = bVar.jZz;
                    }
                } else {
                    return;
                }
            } else if (FrsFragment.this.giA == null || com.baidu.tbadk.core.util.v.isEmpty(FrsFragment.this.giA.getThreadList())) {
                FrsFragment.this.a(bVar);
            } else if (bVar.fUe) {
                FrsFragment.this.showToast(FrsFragment.this.getPageContext().getResources().getString(R.string.net_error_text, bVar.errorMsg, Integer.valueOf(bVar.errorCode)));
            }
            FrsFragment.this.bBq();
            FrsFragment.this.bBr();
            if (FrsFragment.this.giA.getAccessFlag() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11384"));
            }
            if (FrsFragment.this.fPB > -1 && !FrsFragment.this.gjM) {
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.gjp, FrsFragment.this.fPB);
                FrsFragment.this.fPB = -1L;
                FrsFragment.this.gjM = true;
            }
            if (FrsFragment.this.giX && FrsFragment.this.gjr.uf(49)) {
                FrsFragment.this.giX = false;
            }
            FrsFragment.this.dzt = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.p
        public void c(com.baidu.tieba.tbadkCore.l lVar) {
            if ((lVar != null && ("normal_page".equals(FrsFragment.this.gjp.getPageType()) || "frs_page".equals(FrsFragment.this.gjp.getPageType()) || "book_page".equals(FrsFragment.this.gjp.getPageType()))) || "brand_page".equals(FrsFragment.this.gjp.getPageType())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE, lVar));
                FrsFragment.this.b(lVar);
                FrsFragment.gjd = lVar;
            }
        }
    };
    private final CustomMessageListener gko = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.frs.FrsFragment.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.m) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                FrsFragment.this.giA.updateCurrentUserPendant((com.baidu.tbadk.data.m) customResponsedMessage.getData());
                FrsFragment.this.gja.bCy().notifyDataSetChanged();
            }
        }
    };
    private final CustomMessageListener mMemListener = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_MEM) { // from class: com.baidu.tieba.frs.FrsFragment.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && FrsFragment.this.giA != null && (userData = FrsFragment.this.giA.getUserData()) != null) {
                userData.setIsMem(num.intValue());
                if (num.intValue() != 0) {
                    FrsFragment.this.gjq.k(num);
                }
            }
        }
    };
    private final com.baidu.tieba.frs.mc.k gkp = new com.baidu.tieba.frs.mc.k() { // from class: com.baidu.tieba.frs.FrsFragment.22
        @Override // com.baidu.tieba.frs.mc.k
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.m> arrayList, boolean z3) {
            if (FrsFragment.this.gjt != null && FrsFragment.this.gjp != null && FrsFragment.this.gjp.bGN() && z && !z2 && !z3) {
                FrsFragment.this.gjt.tF(i2);
            }
        }
    };
    public final View.OnTouchListener dne = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.FrsFragment.24
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (FrsFragment.this.gjH != null) {
                FrsFragment.this.gjH.onTouch(view, motionEvent);
            }
            if (FrsFragment.this.gjv != null && FrsFragment.this.gjv.bDf() != null) {
                FrsFragment.this.gjv.bDf().onTouchEvent(motionEvent);
            }
            if (FrsFragment.this.ewJ != null) {
                FrsFragment.this.ewJ.c(view, motionEvent);
            }
            if (FrsFragment.this.gjq != null) {
                FrsFragment.this.gjq.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private final CustomMessageListener gkq = new CustomMessageListener(CmdConfigCustom.CMD_GOTOLIVE_HOST_UPGRADE) { // from class: com.baidu.tieba.frs.FrsFragment.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.aCY().getInt(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.PHOTOLIVE_HOSTLEVEL, -1) != -1 && FrsFragment.this.giA.getForum() != null) {
                FrsFragment.this.giA.getForum().setCanAddPhotoLivePost(true);
            }
        }
    };
    public final View.OnClickListener gkr = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.27
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsFragment.this.gja == null || view != FrsFragment.this.gja.bCk() || FrsFragment.this.getActivity() == null) {
                if (FrsFragment.this.giA != null && FrsFragment.this.giA.getForum() != null && FrsFragment.this.gja != null && view == FrsFragment.this.gja.bCq()) {
                    if (FrsFragment.this.gjJ == null) {
                        FrsFragment.this.gjJ = new com.baidu.tieba.frs.view.c(FrsFragment.this.getPageContext());
                    }
                    FrsFragment.this.gjJ.m(FrsFragment.this.giA);
                    FrsFragment.this.gjJ.showDialog();
                    return;
                }
                if (view.getId() == R.id.game_activity_egg_layout && com.baidu.adp.lib.util.l.isNetOk()) {
                    TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_CLICK);
                    if (FrsFragment.this.gja.bCv()) {
                        FrsFragment.this.gja.bCw();
                    } else {
                        String activityUrl = FrsFragment.this.giA.getForum().getYuleData().aBS().getActivityUrl();
                        if (!StringUtils.isNull(activityUrl)) {
                            com.baidu.tbadk.browser.a.startInternalWebActivity(FrsFragment.this.getPageContext().getPageActivity(), activityUrl);
                        }
                    }
                }
                if (view == FrsFragment.this.gja.bCC() && FrsFragment.this.gjp != null && FrsFragment.this.gjp.hasMore()) {
                    FrsFragment.this.gja.baF();
                    FrsFragment.this.aZs();
                }
                if (view != null && view == FrsFragment.this.gja.bCs() && bc.checkUpIsLogin(FrsFragment.this.getContext())) {
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
        private int gkE = 0;
        private int efC = 0;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsFragment.this.gjV += i2;
            if (FrsFragment.this.gjV >= FrsFragment.this.bZc * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
            if (FrsFragment.this.gjy != null) {
                FrsFragment.this.gjy.bHA();
            }
            this.gkE = 0;
            this.efC = 0;
            if (recyclerView != null && (recyclerView instanceof BdRecyclerView)) {
                this.gkE = ((BdRecyclerView) recyclerView).getFirstVisiblePosition();
                this.efC = ((BdRecyclerView) recyclerView).getLastVisiblePosition();
            }
            if (FrsFragment.this.gjK != null) {
                FrsFragment.this.gjK.a(recyclerView, this.gkE, this.efC);
            }
            if (FrsFragment.this.giA != null && FrsFragment.this.gja != null && FrsFragment.this.gja.bCy() != null) {
                FrsFragment.this.gja.bE(this.gkE, this.efC);
                if (FrsFragment.this.gjo != null && FrsFragment.this.gjo.mT() != null) {
                    FrsFragment.this.gjo.mT().b(FrsFragment.this.gjn);
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (FrsFragment.this.gjq != null) {
                FrsFragment.this.gjq.setScrollState(i);
            }
            if ((i == 2 || i == 1) && !FrsFragment.this.gjj) {
                FrsFragment.this.gjj = true;
                FrsFragment.this.gja.bCA();
            }
            if (FrsFragment.this.gjk == null && !FrsFragment.this.bBL()) {
                FrsFragment.this.gjk = new com.baidu.tbadk.n.b();
                FrsFragment.this.gjk.setSubType(1000);
            }
            if (i == 0) {
                if (FrsFragment.this.gjk != null) {
                    FrsFragment.this.gjk.aOr();
                }
                com.baidu.tieba.card.r.bsy().kc(true);
                FrsFragment.this.kP(true);
                FrsFragment.this.gja.bD(this.gkE, this.efC);
            } else if (FrsFragment.this.gjk != null) {
                FrsFragment.this.gjk.aOq();
            }
            if (FrsFragment.this.gjK != null) {
                FrsFragment.this.gjK.onScrollStateChanged(recyclerView, i);
            }
            if (i == 0) {
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.gja, FrsFragment.this.giA, FrsFragment.this.getForumId(), false, null);
            }
            if (FrsFragment.this.gjr != null && i == 1) {
                FrsFragment.this.gjr.bIv();
            }
            if (FrsFragment.this.gjo == null) {
                if (FrsFragment.this.gja.bCd() != null && !FrsFragment.this.gja.bBJ() && FrsFragment.this.gja.bCd().cwe() != null && (FrsFragment.this.gja.bCd().cwe().getTag() instanceof com.baidu.card.af)) {
                    FrsFragment.this.gjo = (com.baidu.card.af) FrsFragment.this.gja.bCd().cwe().getTag();
                }
            } else if (i == 0 && FrsFragment.this.gja.bCd() != null && !FrsFragment.this.gja.bBJ() && FrsFragment.this.gja.bCd().cwe() != null && (FrsFragment.this.gja.bCd().cwe().getTag() instanceof com.baidu.card.af)) {
                FrsFragment.this.gjo = (com.baidu.card.af) FrsFragment.this.gja.bCd().cwe().getTag();
            }
            if (i == 1) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921418));
            }
        }
    };
    private final d gks = new d() { // from class: com.baidu.tieba.frs.FrsFragment.29
        @Override // com.baidu.tieba.frs.d
        public void a(int i, int i2, View view, View view2, bj bjVar) {
            if (i != FrsFragment.this.gja.bCy().bEx()) {
                if (i != FrsFragment.this.gja.bCy().bEy()) {
                    if (i == FrsFragment.this.gja.bCy().bEv() && FrsFragment.this.giA != null && FrsFragment.this.giA.getUserData() != null && FrsFragment.this.giA.getUserData().isBawu()) {
                        String bawuCenterUrl = FrsFragment.this.giA.getBawuCenterUrl();
                        if (!com.baidu.tbadk.core.util.aq.isEmpty(bawuCenterUrl) && FrsFragment.this.giA.getForum() != null) {
                            com.baidu.tbadk.browser.a.startWebActivity(FrsFragment.this.getPageContext().getPageActivity(), bawuCenterUrl);
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10502").cp("fid", FrsFragment.this.giA.getForum().getId()).cp("uid", FrsFragment.this.giA.getUserData().getUserId()));
                        }
                    }
                } else if (bc.checkUpIsLogin(FrsFragment.this.getPageContext().getPageActivity())) {
                    TiebaStatic.log(CommonStatisticKey.MY_SERVICE_CK);
                    if (FrsFragment.this.giA != null && FrsFragment.this.giA.getForum() != null) {
                        ForumData forum = FrsFragment.this.giA.getForum();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(forum.getId(), 0L), forum.getName(), forum.getImage_url(), 0)));
                    }
                }
            } else if (bc.checkUpIsLogin(FrsFragment.this.getActivity())) {
                TiebaStatic.log("forum_fortune_click");
                com.baidu.tieba.frs.f.i.b(FrsFragment.this.getPageContext(), FrsFragment.this.giA);
            }
        }
    };
    private final NoNetworkView.a ggy = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.FrsFragment.30
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (FrsFragment.this.gjp.bGE() == 1 && z && !FrsFragment.this.gja.bBJ()) {
                if (FrsFragment.this.giA == null || com.baidu.tbadk.core.util.v.isEmpty(FrsFragment.this.giA.getThreadList())) {
                    FrsFragment.this.hideNetRefreshView(FrsFragment.this.gja.bpX());
                    FrsFragment.this.showLoadingView(FrsFragment.this.gja.bpX(), true);
                    FrsFragment.this.gja.la(false);
                    FrsFragment.this.refresh();
                    return;
                }
                FrsFragment.this.gja.bCm();
            }
        }
    };
    private final CustomMessageListener djU = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.FrsFragment.31
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                com.baidu.tieba.frs.f.c.a(customResponsedMessage, FrsFragment.this.gja, FrsFragment.this.giA);
            }
        }
    };
    private com.baidu.adp.widget.ListView.s gkt = new a();
    private aj gku = new aj() { // from class: com.baidu.tieba.frs.FrsFragment.33
        @Override // com.baidu.tieba.frs.aj
        public void a(int i, int i2, aq aqVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
            com.baidu.adp.lib.f.e.gy().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.33.1
                @Override // java.lang.Runnable
                public void run() {
                    if (FrsFragment.this.gja != null && FrsFragment.this.gja.bCD()) {
                        FrsFragment.this.aZs();
                    }
                }
            });
        }
    };
    private CustomMessageListener gkv = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.frs.FrsFragment.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    FrsFragment.this.gjL = true;
                }
            }
        }
    };
    private CustomMessageListener gkw = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.frs.FrsFragment.36
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                    if (FrsFragment.this.gjo == null && FrsFragment.this.gja.bCd() != null && !FrsFragment.this.gja.bBJ() && FrsFragment.this.gja.bCd().cwe() != null && (FrsFragment.this.gja.bCd().cwe().getTag() instanceof com.baidu.card.af)) {
                        FrsFragment.this.gjo = (com.baidu.card.af) FrsFragment.this.gja.bCd().cwe().getTag();
                    }
                    if (FrsFragment.this.gjo != null && FrsFragment.this.gjo.mT() != null) {
                        FrsFragment.this.gjo.mT().b(new a.C0050a(3));
                    }
                }
            }
        }
    };
    private CustomMessageListener gkx = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.FrsFragment.37
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.gja != null) {
                FrsFragment.this.gja.qZ();
            }
        }
    };
    private CustomMessageListener gky = new CustomMessageListener(2921437) { // from class: com.baidu.tieba.frs.FrsFragment.38
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && FrsFragment.this.isResumed()) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (FrsFragment.this.gjc != null) {
                    if (booleanValue) {
                        if (FrsFragment.this.gjr.bIw() != 0 && !FrsFragment.this.gja.bCI()) {
                            FrsFragment.this.gjc.show();
                            return;
                        }
                        return;
                    }
                    FrsFragment.this.gjc.hide();
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.frs.loadmore.a
    public /* bridge */ /* synthetic */ com.baidu.adp.base.e getPageContext() {
        return super.getPageContext();
    }

    public com.baidu.tieba.frs.entelechy.b.b bAZ() {
        return this.gjx;
    }

    public com.baidu.adp.widget.ListView.s bBa() {
        return this.gkt;
    }

    public com.baidu.tieba.frs.mc.d bBb() {
        return this.gjz;
    }

    public com.baidu.tieba.frs.smartsort.a bBc() {
        return this.gjt;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public FrsModelController bBd() {
        return this.gjp;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public com.baidu.tieba.frs.mc.c bBe() {
        return this.gjA;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public com.baidu.tieba.frs.vc.h bBf() {
        return this.gjq;
    }

    public FrsTabViewController bBg() {
        return this.gjr;
    }

    public al bBh() {
        return this.gjv;
    }

    public void kO(boolean z) {
        this.gjU = z;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public l bBi() {
        return this.gja;
    }

    @Override // com.baidu.tieba.frs.ak
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.ak, com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.giS;
    }

    public void setForumName(String str) {
        this.giS = str;
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
        if (this.gjA == null) {
            return 1;
        }
        return this.gjA.getPn();
    }

    public int getPn() {
        if (this.gjA == null) {
            return 1;
        }
        return this.gjA.getPn();
    }

    public void setPn(int i) {
        if (this.gjA != null) {
            this.gjA.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.gjA != null) {
            this.gjA.setHasMore(i);
        }
    }

    public int bBj() {
        if (this.gjA == null) {
            return -1;
        }
        return this.gjA.bBj();
    }

    public boolean bBk() {
        return this.giY;
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
            this.gja.bCg();
            showNetRefreshView(this.gja.bpX(), string, true);
        } else if (340001 == bVar.errorCode) {
            a(bVar, this.giA.getRecm_forum_list());
        } else {
            if (com.baidu.tbadk.core.util.v.isEmpty(this.giA.getThreadList())) {
                b(bVar);
            }
            if (bBL()) {
                setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds280));
            } else {
                setNetRefreshViewEmotionDefMarginTop();
            }
        }
    }

    public void a(View view, String str, boolean z, List<RecmForumInfo> list) {
        this.gja.bCg();
        this.gja.sA(8);
        if (this.gjI == null) {
            this.gjI = new com.baidu.tieba.frs.view.a(getPageContext(), getNetRefreshListener());
        }
        this.gjI.setSubText(str);
        this.gjI.cx(list);
        this.gjI.attachView(view, z);
    }

    private void a(e.b bVar, List<RecmForumInfo> list) {
        if (this.gja != null) {
            this.gja.bCg();
            this.gja.setTitle(this.giS);
            a(this.gja.bpX(), bVar.errorMsg, true, list);
        }
    }

    private void b(e.b bVar) {
        this.gja.bCg();
        if (bVar.fUe) {
            showNetRefreshView(this.gja.bpX(), TbadkCoreApplication.getInst().getString(R.string.net_error_text, new Object[]{bVar.errorMsg, Integer.valueOf(bVar.errorCode)}), true);
        } else {
            showNetRefreshView(this.gja.bpX(), bVar.errorMsg, true);
        }
    }

    public void bBl() {
        hideLoadingView(this.gja.bpX());
        this.gja.lc(false);
        if (this.gja.bCe() instanceof com.baidu.tieba.frs.tab.c) {
            ((com.baidu.tieba.frs.tab.c) this.gja.bCe()).bHh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBm() {
        if (bBj() == 0 && com.baidu.tbadk.core.util.v.isEmpty(this.giA.getThreadListIds())) {
            if (com.baidu.tbadk.core.util.v.isEmpty(this.giA.getThreadList())) {
                this.gja.baH();
            } else {
                this.gja.baG();
            }
        } else if (com.baidu.tbadk.core.util.v.getCount(this.giA.getThreadList()) > 3) {
            this.gja.baF();
        } else {
            this.gja.bCB();
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
            bBl();
            this.gja.bCm();
            e.b bGB = this.gjp.bGB();
            boolean isEmpty = com.baidu.tbadk.core.util.v.isEmpty(this.giA.getThreadList());
            if (bGB != null && isEmpty) {
                if (this.gjp.bGC() != 0) {
                    this.gjp.bGH();
                    this.gja.bCm();
                } else {
                    a(bGB);
                }
                this.gja.K(this.giA.isStarForum(), false);
                return;
            }
            a(bGB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.l lVar) {
        if (lVar != null && lVar.getEntelechyTabInfo() != null && lVar.getEntelechyTabInfo().tab != null) {
            for (FrsTabInfo frsTabInfo : lVar.getEntelechyTabInfo().tab) {
                if (frsTabInfo.tab_id.intValue() == 502 && com.baidu.tbadk.core.sharedPref.b.aCY().getBoolean("first_into_tab_profession", true)) {
                    return;
                }
            }
        }
        new com.baidu.tieba.frs.ad.f(getTbPageContext()).a(lVar);
    }

    public boolean bBn() {
        return bBo() && !bBp();
    }

    private boolean bBo() {
        if (bBI() == null) {
            return false;
        }
        FrsViewData bBI = bBI();
        com.baidu.tbadk.core.data.t tVar = null;
        if (bBI.getStar() != null && !StringUtils.isNull(bBI.getStar().cHD())) {
            tVar = new com.baidu.tbadk.core.data.t();
        } else if (bBI.getActivityHeadData() != null && com.baidu.tbadk.core.util.v.getCount(bBI.getActivityHeadData().axO()) >= 1) {
            tVar = bBI.getActivityHeadData().axO().get(0);
        }
        return tVar != null;
    }

    public boolean bBp() {
        if (bBI() == null) {
            return false;
        }
        FrsViewData bBI = bBI();
        return (com.baidu.tbadk.core.util.v.isEmpty(bBI.getShowTopThreadList()) && bBI.getBusinessPromot() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBq() {
        boolean b;
        if (!bBs()) {
            final PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
            privateForumPopInfoData.a(this.giA.getPrivateForumTotalInfo().getPrivatePopInfo());
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(getActivity());
            if (this.giA.getPrivateForumTotalInfo().ayF().private_forum_status.intValue() == 1 && (com.baidu.tbadk.core.util.aq.isEmpty(privateForumPopInfoData.ayH()) || privateForumPopInfoData.ayK() != Integer.valueOf(this.forumId))) {
                privateForumPopInfoData.se("create_success");
                privateForumPopInfoData.sf(TbadkCoreApplication.getInst().getString(R.string.frs_private_create_hint));
                privateForumPopInfoData.sg("https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.giS + "&nomenu=1");
                privateForumPopInfoData.g(Integer.valueOf(this.forumId));
                b = frsPrivateCommonDialogView.b(privateForumPopInfoData);
            } else {
                b = privateForumPopInfoData.ayK() == Integer.valueOf(this.forumId) ? frsPrivateCommonDialogView.b(privateForumPopInfoData) : false;
            }
            if (b) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
                aVar.jI(2);
                aVar.aK(frsPrivateCommonDialogView);
                aVar.fv(false);
                frsPrivateCommonDialogView.setConfirmButton(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.11
                    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.frs.FrsFragment */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ba.aEa().b(FrsFragment.this.getPageContext(), new String[]{privateForumPopInfoData.ayJ()});
                        aVar.dismiss();
                    }
                });
                aVar.a(new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.13
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(getPageContext()).aBW();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBr() {
        if (bBs() || this.giA.getPrivateForumTotalInfo().ayF().private_forum_status.intValue() != 1) {
            a((Integer) null, (Integer) null, true);
        } else {
            a(this.giA.getPrivateForumTotalInfo().ayF().private_forum_audit_status, this.giA.getPrivateForumTotalInfo().ayG(), false);
        }
    }

    public void a(Integer num, Integer num2, boolean z) {
        final String str;
        final int i = 2;
        if (this.gja.bCr() != null) {
            TextView bCr = this.gja.bCr();
            if (z) {
                bCr.setVisibility(8);
                return;
            }
            if (num.intValue() == 2) {
                bCr.setText("修改实名认证信息");
                bCr.setVisibility(0);
                str = "https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + this.forumId + "&nomenu=1";
            } else if (num2.intValue() >= 0 && num2.intValue() <= 100) {
                bCr.setText("目标已完成" + String.valueOf(num2) + "%");
                bCr.setVisibility(0);
                str = "https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.giS + "&nomenu=1";
                i = 1;
            } else {
                bCr.setVisibility(8);
                i = 0;
                str = "";
            }
            bCr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.14
                /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13387").cp("fid", FrsFragment.this.forumId).cp("uid", TbadkCoreApplication.getCurrentAccount()).Z("obj_type", i));
                    ba.aEa().b(FrsFragment.this.getPageContext(), new String[]{str});
                }
            });
        }
    }

    private boolean bBs() {
        return this.giA == null || !this.giA.isPrivateForum() || this.giA.getPrivateForumTotalInfo() == null || this.giA.getPrivateForumTotalInfo().ayF() == null || this.giA.getUserData().getIs_manager() != 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sr(int i) {
        List<WindowToast> list;
        if (TbadkCoreApplication.isLogin() && this.giA != null && (list = this.giA.mWindowToast) != null && list.size() > 0) {
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
    public void bBt() {
        if (this.giA == null || this.giA.getForum() != null) {
            this.gja.bCx();
        } else if (this.giA.getForum().getYuleData() != null && this.giA.getForum().getYuleData().aBR()) {
            TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_VIEW);
            this.gja.a(this.giA.getForum().getYuleData().aBS());
        } else {
            this.gja.bCx();
        }
    }

    private void I(boolean z, boolean z2) {
        if (this.gjp != null && this.giA != null && this.gja != null && z) {
            if (!this.gjp.bGN() && this.gjp.bGE() == 1) {
                if (!this.gjp.bGL()) {
                    this.giA.addCardVideoInfoToThreadList();
                    this.giA.addVideoInfoToThreadListInTenAndFifteenFloor();
                }
                boolean z3 = false;
                if (this.gja.bCy().p(com.baidu.tieba.card.data.n.fHO)) {
                    z3 = this.giA.addHotTopicDataToThreadList();
                }
                if (!z3) {
                    this.giA.addFeedForumDataToThreadList();
                }
                if (TbadkCoreApplication.getInst().isRecAppExist()) {
                    this.giA.addRecommendAppToThreadList(this);
                }
                if (!this.gja.bCy().p(bj.cNm)) {
                    this.giA.removeAlaLiveThreadData();
                }
                this.giA.addSchoolRecommendToThreadList();
            }
            if (!this.gja.bCy().p(bj.cNm)) {
                this.giA.removeAlaInsertLiveData();
                this.giA.removeAlaStageLiveDat();
            } else {
                this.giA.addInsertLiveDataToThreadList();
                this.giA.addStageLiveDataToThreadList();
            }
            this.giA.checkLiveStageInThreadList();
            this.giA.addNoticeThreadToThreadList();
            if (this.gja.bCy().p(com.baidu.tieba.h.b.gMc)) {
                this.giA.addGameRankListToThreadList(z2);
            }
            if (TbadkCoreApplication.isLogin() && (!this.gjp.bGN() || this.gjp.isNetFirstLoad)) {
                this.giA.addUserRecommendToThreadList();
            }
            this.giA.addVideoActivityToTop();
        }
    }

    public boolean bBu() {
        if (this.gjq != null && this.gjp != null) {
            this.gjq.a(this.gjp.getPageType(), this.giA);
        }
        boolean z = false;
        if (this.giA != null) {
            z = this.giA.hasTab();
        }
        bBw();
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ss(int i) {
        an anVar = null;
        bBu();
        bBD();
        try {
            if (this.giA != null) {
                this.gja.a((ArrayList<com.baidu.adp.widget.ListView.m>) null, this.giA);
                this.gjq.tZ(1);
                this.gja.bCp();
                this.gjr.a(this.giA, this.gjp.bGJ());
                com.baidu.tieba.frs.tab.d ug = this.gjr.ug(this.giA.getFrsDefaultTabId());
                if (ug != null && !TextUtils.isEmpty(ug.url)) {
                    anVar = new an();
                    anVar.ext = ug.url;
                    anVar.stType = ug.name;
                }
                this.gjp.a(this.giA.getFrsDefaultTabId(), 0, anVar);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(boolean z, boolean z2) {
        try {
            if (this.giA != null && this.gjr != null && this.gjp != null) {
                if (!this.gja.bCy().p(bj.cNm)) {
                    this.giA.removeAlaLiveThreadData();
                }
                boolean isEmpty = com.baidu.tbadk.core.util.v.isEmpty(this.giA.getGameTabInfo());
                this.gja.kY(isEmpty);
                if (!isEmpty) {
                    if (this.gjK == null) {
                        this.gjK = new com.baidu.tieba.frs.vc.e(this, (NoPressedRelativeLayout) this.mRootView);
                    }
                    if (this.ewJ == null) {
                        this.ewJ = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
                    }
                } else {
                    this.gjK = null;
                    this.ewJ = null;
                }
                if (this.giA.getForum() != null) {
                    this.giS = this.giA.getForum().getName();
                    this.forumId = this.giA.getForum().getId();
                }
                if (this.giA.hasTab()) {
                    this.gjr.a(this.giA, this.gjp.bGJ());
                }
                if (z) {
                    I(true, z);
                } else {
                    I(this.gjl, z);
                }
                bBu();
                if (this.gjx != null) {
                    this.gjx.a(this.gjq, this.giA);
                }
                if (this.giA.getPage() != null) {
                    setHasMore(this.giA.getPage().ayy());
                }
                ArrayList<com.baidu.adp.widget.ListView.m> a2 = this.gjA.a(z2, true, this.giA.getThreadList(), null, z, false);
                if (a2 != null) {
                    this.giA.setThreadList(a2);
                }
                this.giA.removeRedundantUserRecommendData();
                this.giC = this.giA.getTopThreadSize();
                if (this.giW != null) {
                    this.giV = true;
                    this.giW.Ch(this.giC);
                    com.baidu.tieba.frs.f.a.a(this, this.giA.getForum(), this.giA.getThreadList(), this.giV, getPn());
                }
                if (this.gjp.bGE() == 1) {
                    bBA();
                    if (!z && this.gjp.getPn() == 1) {
                        bBv();
                    }
                }
                if (this.gjy != null) {
                    this.gjy.bQ(this.gjr.bIs());
                }
                bBl();
                this.gja.bCh();
                this.gja.K(true, false);
                if (z && this.giA.isFirstTabEqualAllThread()) {
                    com.baidu.adp.lib.f.e.gy().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.15
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!FrsFragment.this.gji && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                FrsFragment.this.gja.bCH();
                            }
                        }
                    });
                }
                if (this.giA.getForum() != null) {
                    this.gja.AE(this.giA.getForum().getWarningMsg());
                }
                if (this.giA != null && this.giA.getFrsVideoActivityData() != null && com.baidu.tbadk.core.sharedPref.b.aCY().getLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 0L) == 0) {
                    com.baidu.adp.lib.f.e.gy().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.16
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsFragment.this.gja.bCF();
                        }
                    }, 1000L);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FRS_SHOW_AR_ENTRY, this));
                this.gja.bCb();
                if (this.giA != null && this.giA.getForum() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ENTER_FORUM, new VisitedForumData(this.giA.getForum().getId(), this.giA.getForum().getName(), this.giA.getForum().getImage_url(), String.valueOf(System.currentTimeMillis() / 1000), ConstantData.Forum.SPECAIL_FORUM_TYPE_LIVE.equals(this.giA.getForum().special_forum_type), this.giA.getForum().getThemeColorInfo(), this.giA.getForum().getMember_num())));
                }
                this.gjP.a(this.giA.bottomMenuList, this.giA.getForum());
                bBR();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void kP(boolean z) {
        com.baidu.tieba.r.c.cHo().b(getUniqueId(), z);
    }

    public void bBv() {
        if (this.gjD == null) {
            this.gjD = new com.baidu.tieba.frs.live.a(this, com.baidu.adp.lib.f.b.toInt(this.forumId, 0));
        }
        this.gjD.bGm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.tbadkCore.l lVar) {
        try {
            if (!this.gji && lVar != null && this.giA != null) {
                this.giA.receiveData(lVar);
                J(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void bBw() {
        if (this.gjp != null) {
            AD(this.gjp.getPageType());
        } else {
            AD("normal_page");
        }
    }

    private void AD(String str) {
        kQ("frs_page".equals(str));
        if (this.gjx != null) {
            this.gjx.a(this.gjq, this.gja, this.giA);
        }
    }

    public void kQ(boolean z) {
        if (this.gjB != null) {
            this.gjB.bIl();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.r.c.cHo().w(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.frs_activity, viewGroup, false);
            this.giM = new com.baidu.tieba.frs.entelechy.a();
            this.gjx = this.giM.bEb();
            this.giL = TbadkCoreApplication.getInst().getString(R.string.frs_title_new_area);
            this.gjq = new com.baidu.tieba.frs.vc.h(this, this.giM, (FrsHeaderViewContainer) this.mRootView.findViewById(R.id.header_view_container));
            this.gjr = new FrsTabViewController(this, this.mRootView);
            this.gjr.registerListener();
            this.gjq.a(this.gjr);
            this.gjr.a(this.gka);
            Intent intent = getActivity().getIntent();
            if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                this.giO = true;
            }
            this.gja = new l(this, this.gkr, this.giM, this.giO, this.gjq);
            this.gjP = new com.baidu.tieba.frs.brand.buttommenu.a(getPageContext(), this.mRootView);
        } else {
            if (this.mRootView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            if (this.gjr != null) {
                this.gjr.registerListener();
            }
            this.gja.bCE();
            this.mRootView.setLeft(0);
            this.mRootView.setRight(com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getContext()));
        }
        this.gjT = true;
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        ArrayList<com.baidu.adp.widget.ListView.m> arrayList = null;
        this.fPB = System.currentTimeMillis();
        this.beginTime = this.fPB;
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.giX = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.fPB = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            ai(intent);
        }
        this.dzl = this.beginTime - this.fPB;
        this.giW = new com.baidu.tieba.tbadkCore.data.f("frs", com.baidu.tieba.tbadkCore.data.f.kbi);
        if (this.gjp == null) {
            this.gjp = new FrsModelController(this, this.gkn);
            this.gjp.a(this.gjZ);
            this.gjp.init();
        }
        if (intent != null) {
            this.gjp.ad(intent.getExtras());
        } else if (bundle != null) {
            this.gjp.ad(bundle);
        } else {
            this.gjp.ad(null);
        }
        if (intent != null) {
            this.gjq.aj(intent.getExtras());
        } else if (bundle != null) {
            this.gjq.aj(bundle);
        } else {
            this.gjq.aj(null);
        }
        this.giZ = getVoiceManager();
        this.gjE = new k(getPageContext(), this);
        initUI();
        initData(bundle);
        if (!bBL()) {
            this.gjv = new al(getActivity(), this.gja, this.gjq);
            this.gjv.lp(true);
        }
        this.giZ = getVoiceManager();
        if (this.giZ != null) {
            this.giZ.onCreate(getPageContext());
        }
        new com.baidu.tieba.frs.mc.i();
        int i = -1;
        if (this.gjA != null && this.gjA.bGx() != null) {
            i = this.gjA.bGx().bBj();
            arrayList = this.gjA.bGx().getDataList();
        }
        this.gjA = new com.baidu.tieba.frs.mc.c(this, this.gkp);
        this.gjA.bGx().setHasMore(i);
        if (arrayList != null && arrayList.size() > 0) {
            this.gjA.bGx().at(arrayList);
        }
        this.gjt = new com.baidu.tieba.frs.smartsort.a(this);
        this.gjB = new com.baidu.tieba.frs.vc.j(this);
        this.gjy = new com.baidu.tieba.frs.vc.a(getPageContext(), this.gjp.bGK());
        this.gju = new com.baidu.tieba.frs.mc.b(this);
        this.gjz = new com.baidu.tieba.frs.mc.d(this);
        this.gjs = new com.baidu.tieba.frs.mc.h(this);
        this.gjC = new com.baidu.tieba.frs.mc.a(this);
        this.gjF = new com.baidu.tieba.frs.vc.c(this);
        this.gjG = new com.baidu.tieba.frs.mc.e(this, getUniqueId());
        this.gjN = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "frs");
        this.gjO = new com.baidu.tieba.ala.a(getPageContext());
        this.gjQ = new com.baidu.tieba.frs.sportspage.notification.a(getPageContext());
        registerListener(this.gkh);
        registerListener(this.mMemListener);
        registerListener(this.gkf);
        registerListener(this.gkq);
        registerListener(this.gko);
        registerListener(this.gkc);
        registerListener(this.gkd);
        registerListener(this.gke);
        registerListener(this.gjW);
        registerListener(this.gjX);
        registerListener(this.Km);
        registerListener(this.gkv);
        registerListener(this.gkj);
        registerListener(this.gjY);
        registerListener(this.gkk);
        registerListener(this.gki);
        registerListener(this.gkl);
        registerListener(this.gkm);
        this.gkw.setTag(getPageContext().getUniqueId());
        MessageManager.getInstance().registerListener(this.gkw);
        registerListener(this.gkx);
        registerListener(this.gky);
        this.gja.la(false);
        if (!bBL() && !this.hasInit) {
            showLoadingView(this.gja.bpX(), true);
            this.gjp.G(3, false);
        }
        com.baidu.tieba.frs.a.bAp().a(new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.19
            @Override // com.baidu.tieba.frs.a.b
            public void H(boolean z, boolean z2) {
                if (FrsFragment.this.gja != null) {
                    FrsFragment.this.gja.sB(z ? 0 : 8);
                    if (!z2) {
                        FrsFragment.this.gjS = z;
                    }
                    if (FrsFragment.this.gja.bCy() != null && FrsFragment.this.gjp != null && FrsFragment.this.gjp.bGF()) {
                        FrsFragment.this.gja.bCy().notifyDataSetChanged();
                    }
                    if (FrsFragment.this.bBg() != null) {
                        FrsTabViewController.b bIt = FrsFragment.this.bBg().bIt();
                        if (bIt != null && bIt.tabId == 502 && (bIt.fragment instanceof FrsCommonTabFragment)) {
                            ((FrsCommonTabFragment) bIt.fragment).bDW();
                        } else if (bIt != null && bIt.tabId == 503 && (bIt.fragment instanceof FrsNewAreaFragment)) {
                            FrsNewAreaFragment frsNewAreaFragment = (FrsNewAreaFragment) bIt.fragment;
                            frsNewAreaFragment.bDW();
                            if (frsNewAreaFragment.bGR() != null) {
                                com.baidu.tieba.frs.mc.g bGR = frsNewAreaFragment.bGR();
                                bGR.ld(!z);
                                bGR.le(!z);
                            }
                        }
                        if (FrsFragment.this.bBg().bIm() != null) {
                            FrsFragment.this.bBg().bIm().setmDisallowSlip(z);
                            FrsFragment.this.bBg().lU(z);
                        }
                    }
                    if (FrsFragment.this.gja.bCf() != null) {
                        FrsFragment.this.gja.kX(!z);
                    }
                    if (FrsFragment.this.getActivity() instanceof FrsActivity) {
                        ((FrsActivity) FrsFragment.this.getActivity()).kN(!z);
                    }
                    if (FrsFragment.this.gjP != null) {
                        FrsFragment.this.gjP.lw(!z);
                    }
                    FrsFragment.this.gja.ld(!z);
                    FrsFragment.this.gja.le(z ? false : true);
                }
            }

            @Override // com.baidu.tieba.frs.a.b
            public void so(int i2) {
                if (FrsFragment.this.gja != null) {
                    FrsFragment.this.gja.sC(i2);
                }
            }

            @Override // com.baidu.tieba.frs.a.b
            public void bAw() {
                com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getContext(), (int) R.string.frs_multi_delete_max_num);
            }
        });
        this.gja.b(new d.a() { // from class: com.baidu.tieba.frs.FrsFragment.20
            @Override // com.baidu.tieba.NEGFeedBack.d.a
            public void a(DeleteThreadHttpResponseMessage deleteThreadHttpResponseMessage) {
                boolean z;
                int i2 = 0;
                if (deleteThreadHttpResponseMessage != null) {
                    FrsFragment.this.gja.aTB();
                    FrsFragment.this.gja.bCG();
                    FrsNewAreaFragment frsNewAreaFragment = null;
                    if (FrsFragment.this.gjr == null || FrsFragment.this.gjr.bIt() == null || !(FrsFragment.this.gjr.bIt().fragment instanceof FrsNewAreaFragment)) {
                        z = false;
                    } else {
                        frsNewAreaFragment = (FrsNewAreaFragment) FrsFragment.this.gjr.bIt().fragment;
                        z = true;
                    }
                    if (deleteThreadHttpResponseMessage.getError() == 0) {
                        String text = !TextUtils.isEmpty(deleteThreadHttpResponseMessage.getText()) ? deleteThreadHttpResponseMessage.getText() : FrsFragment.this.getString(R.string.delete_fail);
                        if (deleteThreadHttpResponseMessage.getRetType() == 1211066) {
                            if (FrsFragment.this.fGg == null) {
                                FrsFragment.this.fGg = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.fGg.sz(text);
                            FrsFragment.this.fGg.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.20.1
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.fGg.fv(false);
                            FrsFragment.this.fGg.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.fGg.aBW();
                        } else if (deleteThreadHttpResponseMessage.getRetType() == 1211067) {
                            if (FrsFragment.this.fGg == null) {
                                FrsFragment.this.fGg = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.fGg.sz(text);
                            FrsFragment.this.fGg.a(R.string.know, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.20.2
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.fGg.fv(false);
                            FrsFragment.this.fGg.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.fGg.aBW();
                        } else {
                            FrsFragment.this.gja.aA(deleteThreadHttpResponseMessage.getText(), ContextCompat.getColor(FrsFragment.this.getContext(), deleteThreadHttpResponseMessage.getRetType() == 1 ? R.color.nav_bar_tip_error : R.color.cp_link_tip_a_alpha95));
                        }
                        if (z && frsNewAreaFragment != null) {
                            frsNewAreaFragment.cs(deleteThreadHttpResponseMessage.getSuccessItems());
                        }
                        FrsFragment.this.ch(deleteThreadHttpResponseMessage.getSuccessItems());
                        com.baidu.tieba.frs.a.bAp().cg(deleteThreadHttpResponseMessage.getSuccessItems());
                        for (com.baidu.adp.widget.ListView.m mVar : FrsFragment.this.giA.getThreadList()) {
                            if (mVar instanceof bi) {
                                i2++;
                                continue;
                            }
                            if (i2 >= 6) {
                                break;
                            }
                        }
                        if (i2 < 6) {
                            FrsFragment.this.aZs();
                            return;
                        }
                        return;
                    }
                    com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getActivity(), deleteThreadHttpResponseMessage.getErrorString());
                }
            }
        });
        this.bZc = UtilHelper.getScreenHeight(getActivity());
        this.hasInit = true;
        st(1);
        super.onActivityCreated(bundle);
        this.createTime = System.currentTimeMillis() - this.beginTime;
    }

    public void kR(boolean z) {
        if (this.gjr != null) {
            this.gjr.gHD = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ch(List<String> list) {
        if (!com.baidu.tbadk.core.util.v.isEmpty(list)) {
            ArrayList<com.baidu.adp.widget.ListView.m> threadList = this.giA.getThreadList();
            if (!com.baidu.tbadk.core.util.v.isEmpty(threadList) && this.gja.getListView() != null && this.gja.getListView().getData() != null) {
                Iterator<com.baidu.adp.widget.ListView.m> it = threadList.iterator();
                List<com.baidu.adp.widget.ListView.m> data = this.gja.getListView().getData();
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.m next = it.next();
                    if (next instanceof bi) {
                        bj bjVar = ((bi) next).cMR;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= list.size()) {
                                break;
                            } else if (!com.baidu.tbadk.core.util.aq.equals(list.get(i2), bjVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.gjA.d(next);
                                this.gja.getListView().getAdapter().notifyItemRemoved(i);
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
    public void aZL() {
        if (isAdded() && this.eiV && !isLoadingViewAttached()) {
            showLoadingView(this.gja.bpX(), true);
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void aZM() {
        if (isAdded() && this.eiV && isLoadingViewAttached()) {
            hideLoadingView(this.gja.bpX());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (bBL()) {
            showLoadingView(this.gja.bpX(), true);
            this.gja.sD(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.gjp.G(3, true);
            aFx().scrollToPosition(0);
        }
    }

    private void st(int i) {
        String str = "";
        if (this.giA != null && this.giA.getForum() != null) {
            str = this.giA.getForum().getId();
        }
        if (!StringUtils.isNull(str)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13008").cp("fid", str).cp("obj_type", "4").Z("obj_locate", i).cp("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.z zVar) {
        if (zVar != null) {
            this.dCz = zVar.aPC();
            this.gjH = zVar.aPD();
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void showFloatingView() {
        if (this.dCz != null) {
            this.dCz.gR(true);
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
                this.giS = data.getQueryParameter("name");
                this.mFrom = data.getQueryParameter("from");
                if (!StringUtils.isNull(this.giS)) {
                    intent.putExtra("name", this.giS);
                }
                if (!StringUtils.isNull(this.mFrom)) {
                    intent.putExtra("from", this.mFrom);
                }
                TiebaStatic.log(TbadkCoreStatisticKey.AS_INVOKE_TIEBA);
            }
            if (StringUtils.isNull(this.giS) && intent != null && intent.getData() != null) {
                Uri data2 = intent.getData();
                if (com.baidu.tbadk.BdToken.f.m(data2)) {
                    com.baidu.tbadk.BdToken.f.avg().b(data2, new f.a() { // from class: com.baidu.tieba.frs.FrsFragment.21
                        @Override // com.baidu.tbadk.BdToken.f.a
                        public void n(HashMap<String, Object> hashMap) {
                            if (hashMap != null && (hashMap.get(com.baidu.tbadk.BdToken.f.cDY) instanceof String)) {
                                FrsFragment.this.giS = (String) hashMap.get(com.baidu.tbadk.BdToken.f.cDY);
                            }
                        }
                    });
                } else {
                    com.baidu.tieba.frs.f.d al = com.baidu.tieba.frs.f.i.al(intent);
                    if (al != null) {
                        this.giS = al.forumName;
                        if (al.gFM == null || al.gFM.equals("aidou")) {
                        }
                    }
                }
                if (!StringUtils.isNull(this.giS)) {
                    intent.putExtra("name", this.giS);
                }
                intent.putExtra(FrsActivityConfig.FRS_CALL_FROM, 12);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.giZ = getVoiceManager();
        if (this.giZ != null) {
            this.giZ.onStart(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        Intent intent;
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.djU);
        if (bundle != null) {
            this.giS = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
            this.giS = intent.getStringExtra("name");
            this.mFrom = intent.getStringExtra("from");
            this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
        }
        if (getArguments() != null) {
            this.giT = getArguments().getBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, false);
        }
        if (TextUtils.isEmpty(this.mFrom) || FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
        }
        if (this.mIsLogin) {
            registerListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL, this.djU);
        }
        this.gjq.aj(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.r.c.cHo().x(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.gkv);
        gjd = null;
        if (this.giZ != null) {
            this.giZ.onDestory(getPageContext());
        }
        com.baidu.tieba.recapp.report.a.remove("FRS");
        this.giZ = null;
        com.baidu.tieba.card.r.bsy().kc(false);
        if (this.giA != null && this.giA.getForum() != null) {
            ab.bDc().dq(com.baidu.adp.lib.f.b.toLong(this.giA.getForum().getId(), 0L));
        }
        if (this.gjD != null) {
            this.gjD.onDestory();
        }
        if (this.gja != null) {
            com.baidu.tieba.frs.f.h.a(this.gja, this.giA, getForumId(), false, null);
            this.gja.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.gjk != null) {
                this.gjk.aOs();
            }
            this.gja.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.gjq.afZ();
        if (this.gjp != null) {
            this.gjp.bep();
        }
        if (this.gjv != null) {
            this.gjv.aTW();
        }
        if (this.gjy != null) {
            this.gjy.destory();
        }
        if (this.gjt != null) {
            this.gjt.onDestroy();
        }
        if (this.gjK != null) {
            this.gjK.onDestory();
        }
        if (this.gjC != null) {
            this.gjC.onDestroy();
        }
        if (this.gjN != null) {
            this.gjN.onDestroy();
        }
        if (this.gjO != null) {
            this.gjO.onDestroy();
        }
        com.baidu.tieba.recapp.d.a.cAE().cAG();
        com.baidu.tieba.frs.f.j.bHx();
        if (this.gjr != null) {
            this.gjr.a((FrsTabViewController.a) null);
            this.gjr.bIv();
        }
        if (this.gjR != null) {
            this.gjR.onDestroy();
        }
        com.baidu.tieba.frs.a.bAp().a(null);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.giS);
        bundle.putString("from", this.mFrom);
        this.gjp.onSaveInstanceState(bundle);
        if (this.giZ != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            this.giZ.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.gjC != null) {
            this.gjC.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.gja != null) {
            this.gja.bCm();
            this.gja.onResume();
        }
        this.gjs.lM(true);
        this.gjl = true;
        if (giR) {
            giR = false;
            this.gja.startPullRefresh();
            return;
        }
        if (this.giZ != null) {
            this.giZ.onResume(getPageContext());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_RESUME));
        this.gja.lf(false);
        if (this.gjL) {
            refresh(6);
            this.gjL = false;
        }
        bBR();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
    }

    public boolean bBx() {
        Intent intent;
        if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
            return false;
        }
        return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
    }

    public void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.giS = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.giU = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.giU) {
                bBy();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBy() {
        this.gja.startPullRefresh();
    }

    public void closeActivity() {
        com.baidu.tieba.frs.f.i.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.mFrom);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.gja.setTitle(this.giS);
        } else {
            this.gja.setTitle("");
            this.mFlag = 1;
        }
        this.gja.a(this.gkt);
        this.gja.addOnScrollListener(this.mScrollListener);
        this.gja.g(this.ggy);
        this.gja.bCy().a(this.gks);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gjT) {
            this.gja.onChangeSkinType(i);
            this.gjq.tY(i);
            this.gjr.onChangeSkinType(i);
            if (this.gjc != null) {
                this.gjc.onChangeSkinType(i);
            }
            if (this.gjI != null) {
                this.gjI.onChangeSkinType();
            }
            if (this.gjP != null) {
                this.gjP.onChangeSkinType(getPageContext(), i);
            }
            if (this.fGg != null) {
                com.baidu.tbadk.q.a.a(getPageContext(), this.fGg.getRealView());
            }
            if (this.gjJ != null) {
                this.gjJ.onChangeSkinType();
            }
            if (this.gjK != null) {
                this.gjK.onChangeSkinType(getPageContext(), i);
            }
        }
    }

    public void su(int i) {
        if (!this.mIsLogin) {
            if (this.giA != null && this.giA.getAnti() != null) {
                this.giA.getAnti().setIfpost(1);
            }
            if (i == 0) {
                bc.skipToLoginActivity(getActivity());
            }
        } else if (this.giA != null) {
            if (i == 0) {
                com.baidu.tieba.frs.f.j.e(this, 0);
            } else {
                this.gja.bCo();
            }
        }
    }

    public void refresh() {
        com.baidu.tieba.a.d.aUV().wp("page_frs");
        refresh(3);
    }

    public void refresh(int i) {
        this.gji = false;
        bBD();
        if (this.gja != null && this.gja.bCd() != null) {
            this.gja.bCd().bLD();
        }
        if (this.gjp != null) {
            this.gjp.G(i, true);
        }
    }

    private void bBz() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.f.h.gz().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.26
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.IL(FrsFragment.this.giS);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBA() {
        bBD();
        try {
            if (this.giA != null) {
                this.gja.bdR();
                this.gja.kX(bBQ());
                if (!com.baidu.tieba.frs.vc.h.l(this.giA) || !com.baidu.tieba.frs.vc.h.k(this.giA)) {
                }
                if (this.giA.getForum() != null) {
                    this.giS = this.giA.getForum().getName();
                    this.forumId = this.giA.getForum().getId();
                }
                if (this.giA.getPage() != null) {
                    setHasMore(this.giA.getPage().ayy());
                }
                this.gja.setTitle(this.giS);
                this.gja.setForumName(this.giS);
                TbadkCoreApplication.getInst().setDefaultBubble(this.giA.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.giA.getUserData().getBimg_end_time());
                bBz();
                bBB();
                ArrayList<com.baidu.adp.widget.ListView.m> threadList = this.giA.getThreadList();
                if (threadList != null) {
                    this.gja.a(threadList, this.giA);
                    com.baidu.tieba.frs.f.c.y(this.gja);
                    this.gjq.tZ(getPageNum());
                    this.gjq.i(this.giA);
                    this.gjr.a(this.giA, this.gjp.bGJ());
                    this.gja.bCp();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void bBB() {
        if (this.giA != null) {
            if (this.giA.getIsNewUrl() == 1) {
                this.gja.bCy().setFromCDN(true);
            } else {
                this.gja.bCy().setFromCDN(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.gjs.lM(false);
        this.gjl = false;
        this.gja.onPause();
        if (this.giZ != null) {
            this.giZ.onPause(getPageContext());
        }
        this.gja.lf(true);
        if (this.gjy != null) {
            this.gjy.bHA();
        }
        com.baidu.tbadk.BdToken.c.auQ().auV();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.gjr != null && this.gjr.bIt() != null && (this.gjr.bIt().fragment instanceof BaseFragment)) {
            ((BaseFragment) this.gjr.bIt().fragment).setPrimary(z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.r.bsy().kc(false);
        kP(false);
        if (this.giA != null && this.giA.getForum() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            com.baidu.tbadk.distribute.a.aLq().a(getPageContext().getPageActivity(), "frs", this.giA.getForum().getId(), 0L);
        }
        if (this.giZ != null) {
            this.giZ.onStop(getPageContext());
        }
        if (aFx() != null) {
            aFx().getRecycledViewPool().clear();
        }
        this.gjq.aEU();
        com.baidu.tbadk.util.aa.aPF();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            if (this.gjq != null) {
                this.gjq.kV(isPrimary());
            }
            if (this.gja != null) {
                this.gja.kV(isPrimary());
                this.gja.lf(!isPrimary());
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (com.baidu.tieba.frs.a.bAp().bAq()) {
                com.baidu.tieba.frs.a.bAp().reset();
                return true;
            } else if (this.gja != null) {
                return this.gja.bCl();
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
        com.baidu.tbadk.distribute.a.aLq().a(advertAppInfo, this.forumId, 0L, "FRS", str, getPn());
    }

    @Override // com.baidu.tieba.recapp.n
    public void bBC() {
        bBd().bBC();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.giZ == null) {
            this.giZ = VoiceManager.instance();
        }
        return this.giZ;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdRecyclerView aFx() {
        if (this.gja == null) {
            return null;
        }
        return this.gja.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void bBD() {
        if (this.giZ != null) {
            this.giZ.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> aFy() {
        if (this.deJ == null) {
            this.deJ = UserIconBox.x(getPageContext().getPageActivity(), 8);
        }
        return this.deJ;
    }

    public void bBE() {
        if (getFragmentActivity() != null && getFragmentActivity().getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.p onGetPreLoadListView() {
        return aFx().getPreLoadHandle();
    }

    @Override // com.baidu.tieba.frs.ai
    public NavigationBar bcb() {
        if (this.gja == null) {
            return null;
        }
        return this.gja.bcb();
    }

    public FRSRefreshButton bBF() {
        return this.gjc;
    }

    public void a(FRSRefreshButton fRSRefreshButton) {
        if (fRSRefreshButton != null) {
            this.gjc = fRSRefreshButton;
            this.gjc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.32
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (FrsFragment.this.gjr != null) {
                        FrsTabViewController.b bIt = FrsFragment.this.gjr.bIt();
                        if (bIt != null && bIt.fragment != null && (bIt.fragment instanceof ah)) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                            ((ah) bIt.fragment).scrollToTop();
                            ((ah) bIt.fragment).baE();
                            return;
                        }
                        FrsFragment.this.bBi().startPullRefresh();
                    }
                }
            });
        }
    }

    public void bBG() {
        if (this.gjc != null) {
            this.gjc.hide();
        }
    }

    public void bBH() {
        if (this.gjc != null) {
            this.gjc.show();
        }
    }

    /* loaded from: classes6.dex */
    private final class a implements com.baidu.adp.widget.ListView.s {
        private a() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.s
        public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null) {
                if (bdUniqueId == q.gmd) {
                    if (FrsFragment.this.gja != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11752").cp("fid", FrsFragment.this.forumId).cp("obj_locate", "1"));
                        FrsFragment.this.gja.startPullRefresh();
                    }
                } else if (mVar != null && (mVar instanceof bi)) {
                    bj bjVar = ((bi) mVar).cMR;
                    if (bjVar.aAC() == null || bjVar.aAC().getGroup_id() == 0 || bc.checkUpIsLogin(FrsFragment.this.getActivity())) {
                        if (bjVar.aAo() != 1 || bc.checkUpIsLogin(FrsFragment.this.getActivity())) {
                            if (bjVar.azR() != null) {
                                if (bc.checkUpIsLogin(FrsFragment.this.getActivity())) {
                                    String postUrl = bjVar.azR().getPostUrl();
                                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.isNetOk()) {
                                        com.baidu.tbadk.browser.a.startInternalWebActivity(FrsFragment.this.getActivity(), postUrl);
                                    }
                                }
                            } else if (bjVar.aAN() != null) {
                                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                    bc.skipToLoginActivity(FrsFragment.this.getPageContext().getPageActivity());
                                    return;
                                }
                                com.baidu.tbadk.core.data.p aAN = bjVar.aAN();
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), aAN.getCartoonId(), aAN.getChapterId(), 2)));
                            } else {
                                com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                                if (readThreadHistory != null && !readThreadHistory.IR(bjVar.getId())) {
                                    readThreadHistory.IQ(bjVar.getId());
                                }
                                boolean z = false;
                                final String azL = bjVar.azL();
                                if (azL != null && !azL.equals("")) {
                                    z = true;
                                    new Thread(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.a.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(azL);
                                            xVar.aDB().aEb().mIsNeedAddCommenParam = false;
                                            xVar.aDB().aEb().mIsUseCurrentBDUSS = false;
                                            xVar.getNetData();
                                        }
                                    }).start();
                                }
                                String tid = bjVar.getTid();
                                if (tid == null) {
                                    tid = "";
                                }
                                if (bjVar.azz() == 2 && !tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                    ba.aEa().b(FrsFragment.this.getPageContext(), new String[]{tid, "", null});
                                    return;
                                }
                                if (tid.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                    bjVar.setId(tid.substring(3));
                                }
                                if (bdUniqueId.getId() == bj.cOQ.getId()) {
                                    com.baidu.tieba.frs.f.h.a(bjVar.azj());
                                } else if (bdUniqueId.getId() == bj.cNp.getId()) {
                                    com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                                    anVar.cp("obj_type", "2");
                                    anVar.cp("tid", bjVar.getTid());
                                    TiebaStatic.log(anVar);
                                }
                                com.baidu.tieba.frs.f.i.a(FrsFragment.this, bjVar, i, z);
                                com.baidu.tieba.frs.f.h.a(FrsFragment.this, FrsFragment.this.giA, bjVar);
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
            hideNetRefreshView(this.gja.bpX());
            showLoadingView(this.gja.bpX(), true);
            this.gja.la(false);
            this.gjp.G(3, true);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData bBI() {
        return this.giA;
    }

    public boolean bBJ() {
        return this.gja.bBJ();
    }

    public void ar(Object obj) {
        if (this.gju != null && this.gju.gBr != null) {
            this.gju.gBr.callback(obj);
        }
    }

    public void as(Object obj) {
        if (this.gju != null && this.gju.gBs != null) {
            this.gju.gBs.callback(obj);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        this.gja.getListView().stopScroll();
        if (!this.gja.bCu()) {
            if (!com.baidu.adp.lib.util.l.isNetOk()) {
                this.gja.baH();
            } else if (this.gjp.bGE() == 1) {
                aZH();
                aZs();
            } else if (this.gjp.hasMore()) {
                aZs();
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void onFailed(String str) {
        aZH();
        showToast(str);
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void al(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        boolean isEmpty = com.baidu.tbadk.core.util.v.isEmpty(arrayList);
        setHasMore(isEmpty ? 0 : 1);
        aZH();
        if (!isEmpty) {
            if (!this.gjp.bGN() && TbadkCoreApplication.getInst().isRecAppExist() && this.gjp.bGE() == 1) {
                this.giA.addRecommendAppToThreadList(this, arrayList);
            }
            if (this.gjp != null) {
                com.baidu.tieba.frs.d.a.a(getUniqueId(), arrayList, this.giA.getForum(), this.gjp.getSortType());
            }
            ArrayList<com.baidu.adp.widget.ListView.m> a2 = this.gjA.a(false, false, arrayList, this.giW, false);
            if (a2 != null) {
                this.giA.setThreadList(a2);
                this.gja.a(a2, this.giA);
            }
            if (this.gjp != null) {
                com.baidu.tieba.frs.d.c.a(this.giA, this.gjp.bGJ(), 2, getContext());
            }
        }
    }

    private void aZH() {
        if (bBj() == 1 || this.gjA.cr(this.giA.getThreadListIds())) {
            if (com.baidu.tbadk.core.util.v.getCount(this.giA.getThreadList()) > 3) {
                this.gja.baF();
            } else {
                this.gja.bCB();
            }
        } else if (com.baidu.tbadk.core.util.v.isEmpty(this.giA.getThreadList())) {
            this.gja.baH();
        } else {
            this.gja.baG();
        }
    }

    @Override // com.baidu.tieba.frs.mc.l
    public void aZs() {
        if (this.gjA != null) {
            this.gjA.a(this.giS, this.forumId, this.giA);
        }
    }

    public void bBK() {
        if (!com.baidu.tbadk.core.util.ab.requestWriteExternalStorgeAndCameraPermission(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.al.e(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment, com.baidu.k.a.a.InterfaceC0072a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        com.baidu.tieba.frs.f.i.a(this, i, strArr, iArr);
    }

    public void kS(boolean z) {
        if (this.gjv != null) {
            this.gjv.lp(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.gjw.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a nB(int i) {
        return this.gjw.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        this.gjE.b(bVar);
    }

    public boolean bBL() {
        return this.giO;
    }

    @Override // com.baidu.tieba.frs.af
    public void xT() {
        if (this.gja != null) {
            showFloatingView();
            this.gja.getListView().scrollToPosition(0);
            this.gja.startPullRefresh();
        }
    }

    public ForumWriteData bBM() {
        if (this.giA == null || this.giA.getForum() == null) {
            return null;
        }
        ForumData forum = this.giA.getForum();
        ForumWriteData forumWriteData = new ForumWriteData(forum.getId(), forum.getName(), forum.getPrefixData(), this.giA.getAnti());
        forumWriteData.avatar = forum.getImage_url();
        forumWriteData.forumLevel = forum.getUser_level();
        forumWriteData.specialForumType = forum.special_forum_type;
        forumWriteData.firstDir = forum.getFirst_class();
        forumWriteData.secondDir = forum.getSecond_class();
        UserData userData = this.giA.getUserData();
        forumWriteData.privateThread = userData != null ? userData.getPrivateThread() : 0;
        return forumWriteData;
    }

    @Override // com.baidu.tieba.frs.af
    public void aFd() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void kT(boolean z) {
        this.gjm = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z) {
        super.showLoadingView(view, z);
        this.gja.sA(8);
        ((FrsActivity) getActivity()).g(view, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        super.hideLoadingView(view);
        this.gja.sA(0);
        ((FrsActivity) getActivity()).g(view, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        super.showNetRefreshView(view, getResources().getString(R.string.refresh_view_title_text), null, getResources().getString(R.string.refresh_view_button_text), z, getNetRefreshListener());
        this.gja.sA(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshViewNoClick(View view, String str, boolean z) {
        super.showNetRefreshViewNoClick(view, str, z);
        this.gja.sA(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        super.hideNetRefreshView(view);
        this.gja.sA(0);
    }

    public void bBN() {
        FrsTabViewController.b bIt;
        if (this.gjr != null && (bIt = this.gjr.bIt()) != null && bIt.fragment != null && (bIt.fragment instanceof ah)) {
            ((ah) bIt.fragment).scrollToTop();
        }
    }

    public void kU(boolean z) {
        this.giQ = z;
    }

    public void b(OvalActionButton ovalActionButton) {
        this.gjb = ovalActionButton;
    }

    public OvalActionButton bBO() {
        return this.gjb;
    }

    public boolean bBP() {
        return this.giQ;
    }

    public void onShareSuccess(String str) {
        if (TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.util.aq.isEmpty(str)) {
            if (this.gjR == null) {
                this.gjR = new AddExperiencedModel(getTbPageContext());
            }
            this.gjR.ek(this.forumId, str);
        }
    }

    public boolean bBQ() {
        if (this.gjm && !this.gjU) {
            return (this.gjp != null && this.gjp.bGF() && com.baidu.tieba.frs.a.bAp().bAq()) ? false : true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.g.c
    public boolean videoNeedPreload() {
        if (this.giA != null) {
            return com.baidu.tbadk.util.af.mC(2) || (com.baidu.tbadk.util.af.aPK() && this.giA.isFrsVideoAutoPlay);
        }
        return super.videoNeedPreload();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.g.c
    public boolean isCyberVideoUsedThisPage() {
        return com.baidu.tbadk.a.b.rp("cyber_player_test");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBR() {
        if (!com.baidu.tbadk.core.util.aq.isEmpty(this.forumId)) {
            com.baidu.tbadk.BdToken.c.auQ().p(com.baidu.tbadk.BdToken.b.cCC, com.baidu.adp.lib.f.b.toLong(this.forumId, 0L));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        FrsTabViewController.b bIt;
        if (bBg() == null || (bIt = bBg().bIt()) == null || !(bIt.fragment instanceof BaseFragment)) {
            return null;
        }
        if (bIt.fragment instanceof FrsAllThreadFragment) {
            TbPageTag tbPageTag = super.getTbPageTag();
            int i = -1;
            if (this.giA != null) {
                i = this.giA.getSortType();
            }
            tbPageTag.sortType = com.baidu.tieba.frs.f.g.tW(i);
            tbPageTag.locatePage = "a070";
            if (this.giL.equals(bIt.title)) {
                tbPageTag.locatePage = "a071";
            }
            return tbPageTag;
        } else if (bIt.fragment instanceof FrsFragment) {
            return null;
        } else {
            return ((BaseFragment) bIt.fragment).getTbPageTag();
        }
    }
}
