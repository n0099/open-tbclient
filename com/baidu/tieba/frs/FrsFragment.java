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
    public static com.baidu.tieba.tbadkCore.l gop;
    private com.baidu.tbadk.util.y dGO;
    private com.baidu.adp.lib.d.b<TbImageView> djc;
    private com.baidu.tieba.frs.gametab.b eCf;
    private com.baidu.tbadk.core.dialog.a fLP;
    private com.baidu.tieba.frs.entelechy.a gnY;
    private com.baidu.card.af goB;
    private FrsModelController goC;
    private com.baidu.tieba.frs.vc.h goD;
    private FrsTabViewController goE;
    private com.baidu.tieba.frs.mc.h goF;
    private com.baidu.tieba.frs.smartsort.a goG;
    private com.baidu.tieba.frs.mc.b goH;
    private al goI;
    private com.baidu.tieba.frs.entelechy.b.b goK;
    private com.baidu.tieba.frs.vc.a goL;
    private com.baidu.tieba.frs.mc.d goM;
    private com.baidu.tieba.frs.mc.c goN;
    private com.baidu.tieba.frs.vc.j goO;
    private com.baidu.tieba.frs.mc.a goP;
    private com.baidu.tieba.frs.live.a goQ;
    private k goR;
    public com.baidu.tieba.frs.vc.c goS;
    private com.baidu.tieba.frs.mc.e goT;
    private View.OnTouchListener goU;
    private com.baidu.tieba.frs.view.a goV;
    private com.baidu.tieba.frs.view.c goW;
    private com.baidu.tieba.frs.vc.e goX;
    private boolean goY;
    private com.baidu.tieba.NEGFeedBack.a goZ;
    private com.baidu.tieba.tbadkCore.data.f goi;
    private VoiceManager gol;
    private OvalActionButton gon;
    private FRSRefreshButton goo;
    public long goq;
    private com.baidu.tieba.ala.a gpa;
    private com.baidu.tieba.frs.brand.buttommenu.a gpb;
    private com.baidu.tieba.frs.sportspage.notification.a gpc;
    private AddExperiencedModel gpd;
    private boolean gpf;
    private int gpn;
    private View mRootView;
    public static boolean god = false;
    public static volatile long gos = 0;
    public static volatile long got = 0;
    public static volatile int mNetError = 0;
    private String gnX = "";
    public boolean gnZ = false;
    private boolean goa = false;
    private boolean gob = false;
    private boolean goc = true;
    public String goe = null;
    public String mFrom = null;
    public int mFlag = 0;
    public boolean gof = false;
    private boolean gog = false;
    private String mThreadId = null;
    public String forumId = null;
    private int gnO = 0;
    private boolean goh = false;
    private boolean goj = false;
    private boolean gok = false;
    private l gom = null;
    public final bj NQ = null;
    private FrsViewData gnM = new FrsViewData();
    public long fVg = -1;
    public long dDE = 0;
    public long dDw = 0;
    public long createTime = 0;
    public long beginTime = -1;
    public long gor = 0;
    public boolean gou = false;
    private boolean gov = false;
    private boolean gow = false;
    public com.baidu.tbadk.n.b gox = null;
    private boolean goy = true;
    private boolean goz = true;
    private a.C0052a goA = new a.C0052a(2);
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> goJ = new SparseArray<>();
    private boolean enU = true;
    private boolean hasInit = false;
    private boolean gpe = false;
    private boolean gpg = false;
    private int cdv = 0;
    private int gph = 0;
    public int mHeadLineDefaultNavTabId = -1;
    private final CustomMessageListener gpi = new CustomMessageListener(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED) { // from class: com.baidu.tieba.frs.FrsFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof bj) {
                    com.baidu.tieba.frs.f.h.a(FrsFragment.this.gom, FrsFragment.this.gnM, FrsFragment.this.getForumId(), true, (bj) data);
                }
            }
        }
    };
    private CustomMessageListener gpj = new CustomMessageListener(CmdConfigCustom.CMD_CLOSE_GAME_RANK_CARD) { // from class: com.baidu.tieba.frs.FrsFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.gnM != null) {
                FrsFragment.this.gnM.removeGameRankListFromThreadList();
                if (FrsFragment.this.gom != null) {
                    FrsFragment.this.gom.asN();
                }
            }
        }
    };
    private CustomMessageListener KN = new CustomMessageListener(2921401) { // from class: com.baidu.tieba.frs.FrsFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && FrsFragment.this.goo != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() <= 0 || FrsFragment.this.goE.bLb() == 0 || FrsFragment.this.goE.bKY() == null || !(FrsFragment.this.goE.bKY().fragment instanceof BaseFragment) || !((BaseFragment) FrsFragment.this.goE.bKY().fragment).isPrimary() || FrsFragment.this.gom.bFp()) {
                    if (FrsFragment.this.goE.bLb() != 0) {
                        FrsFragment.this.goo.hide();
                        return;
                    }
                    return;
                }
                FrsFragment.this.goo.show();
            }
        }
    };
    private CustomMessageListener gpk = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.FrsFragment.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 1) {
                    FrsFragment.this.bEf();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                }
            }
        }
    };
    private final aj gpl = new aj() { // from class: com.baidu.tieba.frs.FrsFragment.39
        @Override // com.baidu.tieba.frs.aj
        public void a(int i, int i2, aq aqVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
            FrsFragment.this.bDS();
            if (FrsFragment.this.goK != null) {
                FrsFragment.this.goD.mg(FrsFragment.this.goK.tk(i));
            }
            e.b bVar = new e.b();
            if (aqVar != null) {
                bVar.isSuccess = aqVar.errCode == 0;
                bVar.errorCode = aqVar.errCode;
                bVar.errorMsg = aqVar.errMsg;
                if (bVar.isSuccess) {
                    if (com.baidu.tbadk.core.util.v.isEmpty(arrayList)) {
                        FrsFragment.this.gom.bdt();
                    } else if (aqVar.hasMore) {
                        if (com.baidu.tbadk.core.util.v.getCount(FrsFragment.this.gnM.getThreadList()) > 3) {
                            FrsFragment.this.gom.bdr();
                        } else {
                            FrsFragment.this.gom.bFi();
                        }
                    } else if (aqVar.gst) {
                        FrsFragment.this.gom.bds();
                    } else {
                        FrsFragment.this.gom.bdt();
                    }
                }
            } else {
                aqVar = new aq();
                aqVar.pn = 1;
                aqVar.hasMore = false;
                aqVar.gst = false;
            }
            if (i == 1) {
                FrsFragment.this.goy = true;
                FrsFragment.this.gpz.a(FrsFragment.this.goC.getType(), false, bVar);
            } else {
                FrsFragment.this.a(bVar);
                if (FrsFragment.this.goC.bIM() != null) {
                    FrsFragment.this.gnM = FrsFragment.this.goC.bIM();
                }
                FrsFragment.this.bEh();
            }
            if (FrsFragment.this.gpG != null) {
                FrsFragment.this.gpG.a(i, i2, aqVar, arrayList);
            }
        }
    };
    private FrsTabViewController.a gpm = new FrsTabViewController.a() { // from class: com.baidu.tieba.frs.FrsFragment.40
        @Override // com.baidu.tieba.frs.vc.FrsTabViewController.a
        public void mA(int i) {
            boolean z = false;
            if (i != 1) {
                com.baidu.tieba.card.r.bvg().kp(false);
                FrsFragment.this.le(false);
            }
            if (i == 502) {
                FrsFragment.this.gon.setIconFade(R.drawable.btn_frs_professional_edit_n);
            } else {
                FrsFragment.this.gon.setIconFade(0);
            }
            FrsFragment.this.gpn = i;
            FrsFragment.this.bEk();
            com.baidu.tieba.frs.d.d.gwq.gJp = i;
            com.baidu.tieba.frs.d.d.gwq.gJq = -1;
            com.baidu.tieba.frs.a bCV = com.baidu.tieba.frs.a.bCV();
            if (i == 1 && FrsFragment.this.gpe) {
                z = true;
            }
            bCV.I(z, true);
        }
    };
    private CustomMessageListener gpo = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIVE_COUNT) { // from class: com.baidu.tieba.frs.FrsFragment.41
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                FrsFragment.this.goE.us(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    };
    private CustomMessageListener gpp = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_LIVE_START) { // from class: com.baidu.tieba.frs.FrsFragment.42
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && ((Integer) customResponsedMessage.getData()).intValue() == 51 && FrsFragment.this.gnM != null) {
                com.baidu.tieba.frs.f.j.a(FrsFragment.this.gnM, FrsFragment.this.getPageContext());
            }
        }
    };
    private final CustomMessageListener gpq = new CustomMessageListener(CmdConfigCustom.CMD_FRS_SELECT_ALA_LIVE_TAB) { // from class: com.baidu.tieba.frs.FrsFragment.43
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                FrsFragment.this.goE.uq(49);
            }
        }
    };
    private final CustomMessageListener gpr = new CustomMessageListener(CmdConfigCustom.CMD_FRS_EXPERIENCE_TIP) { // from class: com.baidu.tieba.frs.FrsFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.t) && FrsFragment.this.gnM != null) {
                FrsFragment.this.gnM.updateLikeData((com.baidu.tieba.tbadkCore.t) customResponsedMessage.getData());
                FrsFragment.this.goD.i(FrsFragment.this.gnM);
                FrsFragment.this.goE.a(FrsFragment.this.gnM, FrsFragment.this.goC.bJp());
            }
        }
    };
    private final AntiHelper.a gps = new AntiHelper.a() { // from class: com.baidu.tieba.frs.FrsFragment.3
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).X("obj_locate", at.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).X("obj_locate", at.a.LOCATE_LIKE_PERSON));
        }
    };
    private CustomMessageListener gpt = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.FrsFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(FrsFragment.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().dnU != null) {
                        if (AntiHelper.a(FrsFragment.this.getActivity(), updateAttentionMessage.getData().dnU, FrsFragment.this.gps) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).X("obj_locate", at.a.LOCATE_LIKE_PERSON));
                        }
                    } else if (updateAttentionMessage.getData().isSucc && updateAttentionMessage.getData().isAttention) {
                        com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getPageContext().getPageActivity(), (int) R.string.attention_success);
                    }
                }
            }
        }
    };
    private CustomMessageListener gpu = new CustomMessageListener(2921346) { // from class: com.baidu.tieba.frs.FrsFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsFragment.this.refresh();
        }
    };
    private CustomMessageListener gpv = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.frs.FrsFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                FrsFragment.this.gom.c((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener gpw = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_REMIND) { // from class: com.baidu.tieba.frs.FrsFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewsRemindMessage newsRemindMessage;
            if (customResponsedMessage != null && (customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626 && (newsRemindMessage = (NewsRemindMessage) customResponsedMessage) != null) {
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (FrsFragment.this.gom != null) {
                    FrsFragment.this.gom.D(notificationCount, z);
                }
            }
        }
    };
    private final CustomMessageListener gpx = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.frs.FrsFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.isResumed()) {
                FrsFragment.this.bEy();
            }
        }
    };
    private CustomMessageListener gpy = new CustomMessageListener(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER) { // from class: com.baidu.tieba.frs.FrsFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (FrsFragment.this.gom != null) {
                    FrsFragment.this.gom.setExpanded(booleanValue);
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.p gpz = new com.baidu.tieba.tbadkCore.p() { // from class: com.baidu.tieba.frs.FrsFragment.10
        private long startTime = 0;

        @Override // com.baidu.tieba.tbadkCore.p
        public void sG(int i) {
            this.startTime = System.nanoTime();
            if (FrsFragment.this.gom != null) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsFragment.this.gom.bET();
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
            if (FrsFragment.this.enU) {
                FrsFragment.this.enU = false;
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.gom, FrsFragment.this.gnM, FrsFragment.this.getForumId(), false, null);
            }
            FrsFragment.this.bDS();
            FrsFragment.this.gov = true;
            if (bVar != null && bVar.isSuccess) {
                FrsFragment.this.gom.bFf().lO(com.baidu.tbadk.core.util.ar.aGD().aGE());
                FrsFragment.gos = 0L;
                FrsFragment.got = 0L;
                FrsFragment.mNetError = 0;
            } else {
                FrsFragment.mNetError = 1;
            }
            if (!FrsFragment.this.goC.bJt() && (i == 3 || i == 6)) {
                FrsFragment.this.goN.resetData();
            }
            FrsFragment.this.goq = System.currentTimeMillis();
            if (FrsFragment.this.goC.bIM() != null) {
                FrsFragment.this.gnM = FrsFragment.this.goC.bIM();
            }
            FrsFragment.this.gom.b(FrsFragment.this.gnM.getRedpacketRainData());
            FrsFragment.this.sC(1);
            if (i == 7) {
                FrsFragment.this.sD(FrsFragment.this.gnM.getFrsDefaultTabId());
                return;
            }
            if (FrsFragment.this.gnM.getPage() != null) {
                FrsFragment.this.setHasMore(FrsFragment.this.gnM.getPage().aBk());
            }
            if (i == 4) {
                if (!FrsFragment.this.goC.bJt() && TbadkCoreApplication.getInst().isRecAppExist() && FrsFragment.this.goC.bJk() == 1) {
                    FrsFragment.this.gnM.addRecommendAppToThreadList(FrsFragment.this);
                }
                ArrayList<com.baidu.adp.widget.ListView.m> a2 = FrsFragment.this.goN.a(false, false, FrsFragment.this.gnM.getThreadList(), FrsFragment.this.goi, false);
                if (a2 != null) {
                    FrsFragment.this.gnM.setThreadList(a2);
                    FrsFragment.this.gnM.checkLiveStageInThreadList();
                }
                if (FrsFragment.this.goC != null) {
                    com.baidu.tieba.frs.d.c.a(FrsFragment.this.gnM, FrsFragment.this.goC.bJp(), 2, FrsFragment.this.getContext());
                }
                com.baidu.tieba.frs.f.a.a(FrsFragment.this, FrsFragment.this.gnM.getForum(), FrsFragment.this.gnM.getThreadList(), false, FrsFragment.this.getPn());
                FrsFragment.this.gom.a(a2, FrsFragment.this.gnM);
                FrsFragment.this.bDT();
                return;
            }
            FrsFragment.this.bDT();
            switch (i) {
                case 1:
                    FrsFragment.this.gom.bET();
                    break;
                case 2:
                    FrsFragment.this.gom.bET();
                    break;
                case 3:
                case 6:
                    if (FrsFragment.this.gnM != null) {
                        FrsFragment.this.gnM.clearPostThreadCount();
                    }
                    if (FrsFragment.this.goS != null) {
                        FrsFragment.this.goS.refresh();
                        break;
                    }
                    break;
            }
            FrsFragment.this.bEa();
            if (bVar == null || bVar.errorCode == 0) {
                if (FrsFragment.this.gnM != null) {
                    FrsFragment.this.a(FrsFragment.this.gnM);
                    FrsFragment.this.L(false, i == 5);
                    if (FrsFragment.this.goC != null) {
                        if (FrsFragment.this.gnM.getActivityHeadData() != null && FrsFragment.this.gnM.getActivityHeadData().aAx() != null && FrsFragment.this.gnM.getActivityHeadData().aAx().size() > 0) {
                            com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), 1, FrsFragment.this.gnM.getForum(), FrsFragment.this.goC.getSortType(), 1);
                        }
                        if (FrsFragment.this.gnM.getThreadList() != null && FrsFragment.this.gnM.getThreadList().size() > 0) {
                            Iterator<com.baidu.adp.widget.ListView.m> it = FrsFragment.this.gnM.getThreadList().iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    com.baidu.adp.widget.ListView.m next = it.next();
                                    if ((next instanceof bj) && ((bj) next).getType() == bj.cTd) {
                                        com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), 1, FrsFragment.this.gnM.getForum(), FrsFragment.this.goC.getSortType(), 2);
                                    }
                                }
                            }
                        }
                        com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), FrsFragment.this.gnM.getThreadList(), FrsFragment.this.gnM.getForum(), FrsFragment.this.goC.getSortType());
                    }
                    FrsFragment.this.gom.sP(i);
                    FrsFragment.gos = (System.nanoTime() - this.startTime) / TimeUtils.NANOS_PER_MS;
                    if (bVar != null) {
                        FrsFragment.got = bVar.kei;
                    }
                } else {
                    return;
                }
            } else if (FrsFragment.this.gnM == null || com.baidu.tbadk.core.util.v.isEmpty(FrsFragment.this.gnM.getThreadList())) {
                FrsFragment.this.a(bVar);
            } else if (bVar.fZp) {
                FrsFragment.this.showToast(FrsFragment.this.getPageContext().getResources().getString(R.string.net_error_text, bVar.errorMsg, Integer.valueOf(bVar.errorCode)));
            }
            FrsFragment.this.bDX();
            FrsFragment.this.bDY();
            if (FrsFragment.this.gnM.getAccessFlag() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11384"));
            }
            if (FrsFragment.this.goj && FrsFragment.this.goE.uq(49)) {
                FrsFragment.this.goj = false;
            }
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.p
        public void c(com.baidu.tieba.tbadkCore.l lVar) {
            if ((lVar != null && ("normal_page".equals(FrsFragment.this.goC.getPageType()) || "frs_page".equals(FrsFragment.this.goC.getPageType()) || "book_page".equals(FrsFragment.this.goC.getPageType()))) || "brand_page".equals(FrsFragment.this.goC.getPageType())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE, lVar));
                FrsFragment.this.b(lVar);
                FrsFragment.gop = lVar;
            }
        }
    };
    private final CustomMessageListener gpA = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.frs.FrsFragment.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.m) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                FrsFragment.this.gnM.updateCurrentUserPendant((com.baidu.tbadk.data.m) customResponsedMessage.getData());
                FrsFragment.this.gom.bFf().notifyDataSetChanged();
            }
        }
    };
    private final CustomMessageListener mMemListener = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_MEM) { // from class: com.baidu.tieba.frs.FrsFragment.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && FrsFragment.this.gnM != null && (userData = FrsFragment.this.gnM.getUserData()) != null) {
                userData.setIsMem(num.intValue());
                if (num.intValue() != 0) {
                    FrsFragment.this.goD.k(num);
                }
            }
        }
    };
    private final com.baidu.tieba.frs.mc.k gpB = new com.baidu.tieba.frs.mc.k() { // from class: com.baidu.tieba.frs.FrsFragment.22
        @Override // com.baidu.tieba.frs.mc.k
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.m> arrayList, boolean z3) {
            if (FrsFragment.this.goG != null && FrsFragment.this.goC != null && FrsFragment.this.goC.bJt() && z && !z2 && !z3) {
                FrsFragment.this.goG.tQ(i2);
            }
        }
    };
    public final View.OnTouchListener drA = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.FrsFragment.24
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (FrsFragment.this.goU != null) {
                FrsFragment.this.goU.onTouch(view, motionEvent);
            }
            if (FrsFragment.this.goI != null && FrsFragment.this.goI.bFL() != null) {
                FrsFragment.this.goI.bFL().onTouchEvent(motionEvent);
            }
            if (FrsFragment.this.eCf != null) {
                FrsFragment.this.eCf.c(view, motionEvent);
            }
            if (FrsFragment.this.goD != null) {
                FrsFragment.this.goD.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private final CustomMessageListener gpC = new CustomMessageListener(CmdConfigCustom.CMD_GOTOLIVE_HOST_UPGRADE) { // from class: com.baidu.tieba.frs.FrsFragment.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.aFD().getInt(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.PHOTOLIVE_HOSTLEVEL, -1) != -1 && FrsFragment.this.gnM.getForum() != null) {
                FrsFragment.this.gnM.getForum().setCanAddPhotoLivePost(true);
            }
        }
    };
    public final View.OnClickListener gpD = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.27
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsFragment.this.gom == null || view != FrsFragment.this.gom.bER() || FrsFragment.this.getActivity() == null) {
                if (FrsFragment.this.gnM != null && FrsFragment.this.gnM.getForum() != null && FrsFragment.this.gom != null && view == FrsFragment.this.gom.bEX()) {
                    if (FrsFragment.this.goW == null) {
                        FrsFragment.this.goW = new com.baidu.tieba.frs.view.c(FrsFragment.this.getPageContext());
                    }
                    FrsFragment.this.goW.m(FrsFragment.this.gnM);
                    FrsFragment.this.goW.showDialog();
                    return;
                }
                if (view.getId() == R.id.game_activity_egg_layout && com.baidu.adp.lib.util.l.isNetOk()) {
                    TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_CLICK);
                    if (FrsFragment.this.gom.bFc()) {
                        FrsFragment.this.gom.bFd();
                    } else {
                        String activityUrl = FrsFragment.this.gnM.getForum().getYuleData().aEy().getActivityUrl();
                        if (!StringUtils.isNull(activityUrl)) {
                            com.baidu.tbadk.browser.a.startInternalWebActivity(FrsFragment.this.getPageContext().getPageActivity(), activityUrl);
                        }
                    }
                }
                if (view == FrsFragment.this.gom.bFj() && FrsFragment.this.goC != null && FrsFragment.this.goC.hasMore()) {
                    FrsFragment.this.gom.bdr();
                    FrsFragment.this.bcf();
                }
                if (view != null && view == FrsFragment.this.gom.bEZ() && bc.checkUpIsLogin(FrsFragment.this.getContext())) {
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
        private int gpQ = 0;
        private int ejR = 0;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsFragment.this.gph += i2;
            if (FrsFragment.this.gph >= FrsFragment.this.cdv * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
            if (FrsFragment.this.goL != null) {
                FrsFragment.this.goL.bKg();
            }
            this.gpQ = 0;
            this.ejR = 0;
            if (recyclerView != null && (recyclerView instanceof BdRecyclerView)) {
                this.gpQ = ((BdRecyclerView) recyclerView).getFirstVisiblePosition();
                this.ejR = ((BdRecyclerView) recyclerView).getLastVisiblePosition();
            }
            if (FrsFragment.this.goX != null) {
                FrsFragment.this.goX.a(recyclerView, this.gpQ, this.ejR);
            }
            if (FrsFragment.this.gnM != null && FrsFragment.this.gom != null && FrsFragment.this.gom.bFf() != null) {
                FrsFragment.this.gom.bE(this.gpQ, this.ejR);
                if (FrsFragment.this.goB != null && FrsFragment.this.goB.nk() != null) {
                    FrsFragment.this.goB.nk().b(FrsFragment.this.goA);
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (FrsFragment.this.goD != null) {
                FrsFragment.this.goD.setScrollState(i);
            }
            if ((i == 2 || i == 1) && !FrsFragment.this.gow) {
                FrsFragment.this.gow = true;
                FrsFragment.this.gom.bFh();
            }
            if (FrsFragment.this.gox == null && !FrsFragment.this.bEs()) {
                FrsFragment.this.gox = new com.baidu.tbadk.n.b();
                FrsFragment.this.gox.setSubType(1000);
            }
            if (i == 0) {
                if (FrsFragment.this.gox != null) {
                    FrsFragment.this.gox.aRc();
                }
                com.baidu.tieba.card.r.bvg().kp(true);
                FrsFragment.this.le(true);
                FrsFragment.this.gom.bD(this.gpQ, this.ejR);
            } else if (FrsFragment.this.gox != null) {
                FrsFragment.this.gox.aRb();
            }
            if (FrsFragment.this.goX != null) {
                FrsFragment.this.goX.onScrollStateChanged(recyclerView, i);
            }
            if (i == 0) {
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.gom, FrsFragment.this.gnM, FrsFragment.this.getForumId(), false, null);
            }
            if (FrsFragment.this.goE != null && i == 1) {
                FrsFragment.this.goE.bLa();
            }
            if (FrsFragment.this.goB == null) {
                if (FrsFragment.this.gom.bEK() != null && !FrsFragment.this.gom.bEq() && FrsFragment.this.gom.bEK().cyI() != null && (FrsFragment.this.gom.bEK().cyI().getTag() instanceof com.baidu.card.af)) {
                    FrsFragment.this.goB = (com.baidu.card.af) FrsFragment.this.gom.bEK().cyI().getTag();
                }
            } else if (i == 0 && FrsFragment.this.gom.bEK() != null && !FrsFragment.this.gom.bEq() && FrsFragment.this.gom.bEK().cyI() != null && (FrsFragment.this.gom.bEK().cyI().getTag() instanceof com.baidu.card.af)) {
                FrsFragment.this.goB = (com.baidu.card.af) FrsFragment.this.gom.bEK().cyI().getTag();
            }
            if (i == 1) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921418));
            }
        }
    };
    private final d gpE = new d() { // from class: com.baidu.tieba.frs.FrsFragment.29
        @Override // com.baidu.tieba.frs.d
        public void a(int i, int i2, View view, View view2, bj bjVar) {
            if (i != FrsFragment.this.gom.bFf().bHd()) {
                if (i != FrsFragment.this.gom.bFf().bHe()) {
                    if (i == FrsFragment.this.gom.bFf().bHb() && FrsFragment.this.gnM != null && FrsFragment.this.gnM.getUserData() != null && FrsFragment.this.gnM.getUserData().isBawu()) {
                        String bawuCenterUrl = FrsFragment.this.gnM.getBawuCenterUrl();
                        if (!com.baidu.tbadk.core.util.aq.isEmpty(bawuCenterUrl) && FrsFragment.this.gnM.getForum() != null) {
                            com.baidu.tbadk.browser.a.startWebActivity(FrsFragment.this.getPageContext().getPageActivity(), bawuCenterUrl);
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10502").cy("fid", FrsFragment.this.gnM.getForum().getId()).cy("uid", FrsFragment.this.gnM.getUserData().getUserId()));
                        }
                    }
                } else if (bc.checkUpIsLogin(FrsFragment.this.getPageContext().getPageActivity())) {
                    TiebaStatic.log(CommonStatisticKey.MY_SERVICE_CK);
                    if (FrsFragment.this.gnM != null && FrsFragment.this.gnM.getForum() != null) {
                        ForumData forum = FrsFragment.this.gnM.getForum();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(forum.getId(), 0L), forum.getName(), forum.getImage_url(), 0)));
                    }
                }
            } else if (bc.checkUpIsLogin(FrsFragment.this.getActivity())) {
                TiebaStatic.log("forum_fortune_click");
                com.baidu.tieba.frs.f.i.b(FrsFragment.this.getPageContext(), FrsFragment.this.gnM);
            }
        }
    };
    private final NoNetworkView.a glL = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.FrsFragment.30
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (FrsFragment.this.goC.bJk() == 1 && z && !FrsFragment.this.gom.bEq()) {
                if (FrsFragment.this.gnM == null || com.baidu.tbadk.core.util.v.isEmpty(FrsFragment.this.gnM.getThreadList())) {
                    FrsFragment.this.hideNetRefreshView(FrsFragment.this.gom.bsE());
                    FrsFragment.this.showLoadingView(FrsFragment.this.gom.bsE(), true);
                    FrsFragment.this.gom.lo(false);
                    FrsFragment.this.refresh();
                    return;
                }
                FrsFragment.this.gom.bET();
            }
        }
    };
    private final CustomMessageListener dor = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.FrsFragment.31
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                com.baidu.tieba.frs.f.c.a(customResponsedMessage, FrsFragment.this.gom, FrsFragment.this.gnM);
            }
        }
    };
    private com.baidu.adp.widget.ListView.s gpF = new a();
    private aj gpG = new aj() { // from class: com.baidu.tieba.frs.FrsFragment.33
        @Override // com.baidu.tieba.frs.aj
        public void a(int i, int i2, aq aqVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
            com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.33.1
                @Override // java.lang.Runnable
                public void run() {
                    if (FrsFragment.this.gom != null && FrsFragment.this.gom.bFk()) {
                        FrsFragment.this.bcf();
                    }
                }
            });
        }
    };
    private CustomMessageListener gpH = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.frs.FrsFragment.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    FrsFragment.this.goY = true;
                }
            }
        }
    };
    private CustomMessageListener gpI = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.frs.FrsFragment.36
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                    if (FrsFragment.this.goB == null && FrsFragment.this.gom.bEK() != null && !FrsFragment.this.gom.bEq() && FrsFragment.this.gom.bEK().cyI() != null && (FrsFragment.this.gom.bEK().cyI().getTag() instanceof com.baidu.card.af)) {
                        FrsFragment.this.goB = (com.baidu.card.af) FrsFragment.this.gom.bEK().cyI().getTag();
                    }
                    if (FrsFragment.this.goB != null && FrsFragment.this.goB.nk() != null) {
                        FrsFragment.this.goB.nk().b(new a.C0052a(3));
                    }
                }
            }
        }
    };
    private CustomMessageListener gpJ = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.frs.FrsFragment.37
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.gom != null) {
                FrsFragment.this.gom.sm();
            }
        }
    };
    private CustomMessageListener gpK = new CustomMessageListener(2921437) { // from class: com.baidu.tieba.frs.FrsFragment.38
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && FrsFragment.this.isResumed()) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (FrsFragment.this.goo != null) {
                    if (booleanValue) {
                        if (FrsFragment.this.goE.bLb() != 0 && !FrsFragment.this.gom.bFp()) {
                            FrsFragment.this.goo.show();
                            return;
                        }
                        return;
                    }
                    FrsFragment.this.goo.hide();
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.frs.loadmore.a
    public /* bridge */ /* synthetic */ com.baidu.adp.base.e getPageContext() {
        return super.getPageContext();
    }

    public com.baidu.tieba.frs.entelechy.b.b bDG() {
        return this.goK;
    }

    public com.baidu.adp.widget.ListView.s bDH() {
        return this.gpF;
    }

    public com.baidu.tieba.frs.mc.d bDI() {
        return this.goM;
    }

    public com.baidu.tieba.frs.smartsort.a bDJ() {
        return this.goG;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public FrsModelController bDK() {
        return this.goC;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public com.baidu.tieba.frs.mc.c bDL() {
        return this.goN;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public com.baidu.tieba.frs.vc.h bDM() {
        return this.goD;
    }

    public FrsTabViewController bDN() {
        return this.goE;
    }

    public al bDO() {
        return this.goI;
    }

    public void ld(boolean z) {
        this.gpg = z;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public l bDP() {
        return this.gom;
    }

    @Override // com.baidu.tieba.frs.ak
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.ak, com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.goe;
    }

    public void setForumName(String str) {
        this.goe = str;
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
        if (this.goN == null) {
            return 1;
        }
        return this.goN.getPn();
    }

    public int getPn() {
        if (this.goN == null) {
            return 1;
        }
        return this.goN.getPn();
    }

    public void setPn(int i) {
        if (this.goN != null) {
            this.goN.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.goN != null) {
            this.goN.setHasMore(i);
        }
    }

    public int bDQ() {
        if (this.goN == null) {
            return -1;
        }
        return this.goN.bDQ();
    }

    public boolean bDR() {
        return this.gok;
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
            this.gom.bEN();
            showNetRefreshView(this.gom.bsE(), string, true);
        } else if (340001 == bVar.errorCode) {
            a(bVar, this.gnM.getRecm_forum_list());
        } else {
            if (com.baidu.tbadk.core.util.v.isEmpty(this.gnM.getThreadList())) {
                b(bVar);
            }
            if (bEs()) {
                setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds280));
            } else {
                setNetRefreshViewEmotionDefMarginTop();
            }
        }
    }

    public void a(View view, String str, boolean z, List<RecmForumInfo> list) {
        this.gom.bEN();
        this.gom.sL(8);
        if (this.goV == null) {
            this.goV = new com.baidu.tieba.frs.view.a(getPageContext(), getNetRefreshListener());
        }
        this.goV.setSubText(str);
        this.goV.ct(list);
        this.goV.attachView(view, z);
    }

    private void a(e.b bVar, List<RecmForumInfo> list) {
        if (this.gom != null) {
            this.gom.bEN();
            this.gom.setTitle(this.goe);
            a(this.gom.bsE(), bVar.errorMsg, true, list);
        }
    }

    private void b(e.b bVar) {
        this.gom.bEN();
        if (bVar.fZp) {
            showNetRefreshView(this.gom.bsE(), TbadkCoreApplication.getInst().getString(R.string.net_error_text, new Object[]{bVar.errorMsg, Integer.valueOf(bVar.errorCode)}), true);
        } else {
            showNetRefreshView(this.gom.bsE(), bVar.errorMsg, true);
        }
    }

    public void bDS() {
        hideLoadingView(this.gom.bsE());
        this.gom.lq(false);
        if (this.gom.bEL() instanceof com.baidu.tieba.frs.tab.c) {
            ((com.baidu.tieba.frs.tab.c) this.gom.bEL()).bJN();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDT() {
        if (bDQ() == 0 && com.baidu.tbadk.core.util.v.isEmpty(this.gnM.getThreadListIds())) {
            if (com.baidu.tbadk.core.util.v.isEmpty(this.gnM.getThreadList())) {
                this.gom.bdt();
            } else {
                this.gom.bds();
            }
        } else if (com.baidu.tbadk.core.util.v.getCount(this.gnM.getThreadList()) > 3) {
            this.gom.bdr();
        } else {
            this.gom.bFi();
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
            bDS();
            this.gom.bET();
            e.b bJh = this.goC.bJh();
            boolean isEmpty = com.baidu.tbadk.core.util.v.isEmpty(this.gnM.getThreadList());
            if (bJh != null && isEmpty) {
                if (this.goC.bJi() != 0) {
                    this.goC.bJn();
                    this.gom.bET();
                } else {
                    a(bJh);
                }
                this.gom.M(this.gnM.isStarForum(), false);
                return;
            }
            a(bJh);
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

    public boolean bDU() {
        return bDV() && !bDW();
    }

    private boolean bDV() {
        if (bEp() == null) {
            return false;
        }
        FrsViewData bEp = bEp();
        com.baidu.tbadk.core.data.t tVar = null;
        if (bEp.getStar() != null && !StringUtils.isNull(bEp.getStar().cKp())) {
            tVar = new com.baidu.tbadk.core.data.t();
        } else if (bEp.getActivityHeadData() != null && com.baidu.tbadk.core.util.v.getCount(bEp.getActivityHeadData().aAx()) >= 1) {
            tVar = bEp.getActivityHeadData().aAx().get(0);
        }
        return tVar != null;
    }

    public boolean bDW() {
        if (bEp() == null) {
            return false;
        }
        FrsViewData bEp = bEp();
        return (com.baidu.tbadk.core.util.v.isEmpty(bEp.getShowTopThreadList()) && bEp.getBusinessPromot() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDX() {
        boolean b;
        if (!bDZ()) {
            final PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
            privateForumPopInfoData.a(this.gnM.getPrivateForumTotalInfo().getPrivatePopInfo());
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(getActivity());
            if (this.gnM.getPrivateForumTotalInfo().aBr().private_forum_status.intValue() == 1 && (com.baidu.tbadk.core.util.aq.isEmpty(privateForumPopInfoData.aBt()) || privateForumPopInfoData.aBw() != Integer.valueOf(this.forumId))) {
                privateForumPopInfoData.sy("create_success");
                privateForumPopInfoData.sz(TbadkCoreApplication.getInst().getString(R.string.frs_private_create_hint));
                privateForumPopInfoData.sA("https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.goe + "&nomenu=1");
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
    public void bDY() {
        if (bDZ() || this.gnM.getPrivateForumTotalInfo().aBr().private_forum_status.intValue() != 1) {
            a((Integer) null, (Integer) null, true);
        } else {
            a(this.gnM.getPrivateForumTotalInfo().aBr().private_forum_audit_status, this.gnM.getPrivateForumTotalInfo().aBs(), false);
        }
    }

    public void a(Integer num, Integer num2, boolean z) {
        final String str;
        final int i = 2;
        if (this.gom.bEY() != null) {
            TextView bEY = this.gom.bEY();
            if (z) {
                bEY.setVisibility(8);
                return;
            }
            if (num.intValue() == 2) {
                bEY.setText("修改实名认证信息");
                bEY.setVisibility(0);
                str = "https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + this.forumId + "&nomenu=1";
            } else if (num2.intValue() >= 0 && num2.intValue() <= 100) {
                bEY.setText("目标已完成" + String.valueOf(num2) + "%");
                bEY.setVisibility(0);
                str = "https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.goe + "&nomenu=1";
                i = 1;
            } else {
                bEY.setVisibility(8);
                i = 0;
                str = "";
            }
            bEY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.14
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

    private boolean bDZ() {
        return this.gnM == null || !this.gnM.isPrivateForum() || this.gnM.getPrivateForumTotalInfo() == null || this.gnM.getPrivateForumTotalInfo().aBr() == null || this.gnM.getUserData().getIs_manager() != 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sC(int i) {
        List<WindowToast> list;
        if (TbadkCoreApplication.isLogin() && this.gnM != null && (list = this.gnM.mWindowToast) != null && list.size() > 0) {
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
    public void bEa() {
        if (this.gnM == null || this.gnM.getForum() != null) {
            this.gom.bFe();
        } else if (this.gnM.getForum().getYuleData() != null && this.gnM.getForum().getYuleData().aEx()) {
            TiebaStatic.log(TbadkCoreStatisticKey.YULE_GAME_EAST_EGG_VIEW);
            this.gom.a(this.gnM.getForum().getYuleData().aEy());
        } else {
            this.gom.bFe();
        }
    }

    private void K(boolean z, boolean z2) {
        if (this.goC != null && this.gnM != null && this.gom != null && z) {
            if (!this.goC.bJt() && this.goC.bJk() == 1) {
                if (!this.goC.bJr()) {
                    this.gnM.addCardVideoInfoToThreadList();
                    this.gnM.addVideoInfoToThreadListInTenAndFifteenFloor();
                }
                boolean z3 = false;
                if (this.gom.bFf().p(com.baidu.tieba.card.data.n.fNw)) {
                    z3 = this.gnM.addHotTopicDataToThreadList();
                }
                if (!z3) {
                    this.gnM.addFeedForumDataToThreadList();
                }
                if (TbadkCoreApplication.getInst().isRecAppExist()) {
                    this.gnM.addRecommendAppToThreadList(this);
                }
                if (!this.gom.bFf().p(bj.cRA)) {
                    this.gnM.removeAlaLiveThreadData();
                }
                this.gnM.addSchoolRecommendToThreadList();
            }
            if (!this.gom.bFf().p(bj.cRA)) {
                this.gnM.removeAlaInsertLiveData();
                this.gnM.removeAlaStageLiveDat();
            } else {
                this.gnM.addInsertLiveDataToThreadList();
                this.gnM.addStageLiveDataToThreadList();
            }
            this.gnM.checkLiveStageInThreadList();
            this.gnM.addNoticeThreadToThreadList();
            if (this.gom.bFf().p(com.baidu.tieba.h.b.gRy)) {
                this.gnM.addGameRankListToThreadList(z2);
            }
            if (TbadkCoreApplication.isLogin() && (!this.goC.bJt() || this.goC.isNetFirstLoad)) {
                this.gnM.addUserRecommendToThreadList();
            }
            this.gnM.addVideoActivityToTop();
        }
    }

    public boolean bEb() {
        if (this.goD != null && this.goC != null) {
            this.goD.a(this.goC.getPageType(), this.gnM);
        }
        boolean z = false;
        if (this.gnM != null) {
            z = this.gnM.hasTab();
        }
        bEd();
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sD(int i) {
        an anVar = null;
        bEb();
        bEk();
        try {
            if (this.gnM != null) {
                this.gom.a((ArrayList<com.baidu.adp.widget.ListView.m>) null, this.gnM);
                this.goD.uk(1);
                this.gom.bEW();
                this.goE.a(this.gnM, this.goC.bJp());
                com.baidu.tieba.frs.tab.d ur = this.goE.ur(this.gnM.getFrsDefaultTabId());
                if (ur != null && !TextUtils.isEmpty(ur.url)) {
                    anVar = new an();
                    anVar.ext = ur.url;
                    anVar.stType = ur.name;
                }
                this.goC.a(this.gnM.getFrsDefaultTabId(), 0, anVar);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(boolean z, boolean z2) {
        try {
            if (this.gnM != null && this.goE != null && this.goC != null) {
                if (!this.gom.bFf().p(bj.cRA)) {
                    this.gnM.removeAlaLiveThreadData();
                }
                boolean isEmpty = com.baidu.tbadk.core.util.v.isEmpty(this.gnM.getGameTabInfo());
                this.gom.lm(isEmpty);
                if (!isEmpty) {
                    if (this.goX == null) {
                        this.goX = new com.baidu.tieba.frs.vc.e(this, (NoPressedRelativeLayout) this.mRootView);
                    }
                    if (this.eCf == null) {
                        this.eCf = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
                    }
                } else {
                    this.goX = null;
                    this.eCf = null;
                }
                if (this.gnM.getForum() != null) {
                    this.goe = this.gnM.getForum().getName();
                    this.forumId = this.gnM.getForum().getId();
                }
                if (this.gnM.hasTab()) {
                    this.goE.a(this.gnM, this.goC.bJp());
                }
                if (z) {
                    K(true, z);
                } else {
                    K(this.goy, z);
                }
                bEb();
                if (this.goK != null) {
                    this.goK.a(this.goD, this.gnM);
                }
                if (this.gnM.getPage() != null) {
                    setHasMore(this.gnM.getPage().aBk());
                }
                ArrayList<com.baidu.adp.widget.ListView.m> a2 = this.goN.a(z2, true, this.gnM.getThreadList(), null, z, false);
                if (a2 != null) {
                    this.gnM.setThreadList(a2);
                }
                this.gnM.removeRedundantUserRecommendData();
                this.gnO = this.gnM.getTopThreadSize();
                if (this.goi != null) {
                    this.goh = true;
                    this.goi.Cs(this.gnO);
                    com.baidu.tieba.frs.f.a.a(this, this.gnM.getForum(), this.gnM.getThreadList(), this.goh, getPn());
                }
                if (this.goC.bJk() == 1) {
                    bEh();
                    if (!z && this.goC.getPn() == 1) {
                        bEc();
                    }
                }
                if (this.goL != null) {
                    this.goL.bV(this.goE.bKX());
                }
                bDS();
                this.gom.bEO();
                this.gom.M(true, false);
                if (z && this.gnM.isFirstTabEqualAllThread()) {
                    com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.15
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!FrsFragment.this.gov && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                FrsFragment.this.gom.bFo();
                            }
                        }
                    });
                }
                if (this.gnM.getForum() != null) {
                    this.gom.Be(this.gnM.getForum().getWarningMsg());
                }
                if (this.gnM != null && this.gnM.getFrsVideoActivityData() != null && com.baidu.tbadk.core.sharedPref.b.aFD().getLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 0L) == 0) {
                    com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.16
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsFragment.this.gom.bFm();
                        }
                    }, 1000L);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FRS_SHOW_AR_ENTRY, this));
                this.gom.bEI();
                if (this.gnM != null && this.gnM.getForum() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ENTER_FORUM, new VisitedForumData(this.gnM.getForum().getId(), this.gnM.getForum().getName(), this.gnM.getForum().getImage_url(), String.valueOf(System.currentTimeMillis() / 1000), ConstantData.Forum.SPECAIL_FORUM_TYPE_LIVE.equals(this.gnM.getForum().special_forum_type), this.gnM.getForum().getThemeColorInfo(), this.gnM.getForum().getMember_num())));
                }
                this.gpb.a(this.gnM.bottomMenuList, this.gnM.getForum());
                bEy();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void le(boolean z) {
        com.baidu.tieba.s.c.cKa().b(getUniqueId(), z);
    }

    public void bEc() {
        if (this.goQ == null) {
            this.goQ = new com.baidu.tieba.frs.live.a(this, com.baidu.adp.lib.f.b.toInt(this.forumId, 0));
        }
        this.goQ.bIS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.tbadkCore.l lVar) {
        try {
            if (!this.gov && lVar != null && this.gnM != null) {
                this.gnM.receiveData(lVar);
                L(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void bEd() {
        if (this.goC != null) {
            Bd(this.goC.getPageType());
        } else {
            Bd("normal_page");
        }
    }

    private void Bd(String str) {
        lf("frs_page".equals(str));
        if (this.goK != null) {
            this.goK.a(this.goD, this.gom, this.gnM);
        }
    }

    public void lf(boolean z) {
        if (this.goO != null) {
            this.goO.bKQ();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.s.c.cKa().w(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.frs_activity, viewGroup, false);
            this.gnY = new com.baidu.tieba.frs.entelechy.a();
            this.goK = this.gnY.bGH();
            this.gnX = TbadkCoreApplication.getInst().getString(R.string.frs_title_new_area);
            this.goD = new com.baidu.tieba.frs.vc.h(this, this.gnY, (FrsHeaderViewContainer) this.mRootView.findViewById(R.id.header_view_container));
            this.goE = new FrsTabViewController(this, this.mRootView);
            this.goE.registerListener();
            this.goD.a(this.goE);
            this.goE.a(this.gpm);
            Intent intent = getActivity().getIntent();
            if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                this.goa = true;
            }
            this.gom = new l(this, this.gpD, this.gnY, this.goa, this.goD);
            this.gpb = new com.baidu.tieba.frs.brand.buttommenu.a(getPageContext(), this.mRootView);
        } else {
            if (this.mRootView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            if (this.goE != null) {
                this.goE.registerListener();
            }
            this.gom.bFl();
            this.mRootView.setLeft(0);
            this.mRootView.setRight(com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getContext()));
        }
        this.gpf = true;
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        ArrayList<com.baidu.adp.widget.ListView.m> arrayList = null;
        this.fVg = System.currentTimeMillis();
        this.beginTime = this.fVg;
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.goj = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.fVg = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            ai(intent);
        }
        this.dDw = this.beginTime - this.fVg;
        this.goi = new com.baidu.tieba.tbadkCore.data.f("frs", com.baidu.tieba.tbadkCore.data.f.kfS);
        if (this.goC == null) {
            this.goC = new FrsModelController(this, this.gpz);
            this.goC.a(this.gpl);
            this.goC.init();
        }
        if (intent != null) {
            this.goC.ad(intent.getExtras());
        } else if (bundle != null) {
            this.goC.ad(bundle);
        } else {
            this.goC.ad(null);
        }
        if (intent != null) {
            this.goD.aj(intent.getExtras());
        } else if (bundle != null) {
            this.goD.aj(bundle);
        } else {
            this.goD.aj(null);
        }
        this.gol = getVoiceManager();
        this.goR = new k(getPageContext(), this);
        initUI();
        initData(bundle);
        if (!bEs()) {
            this.goI = new al(getActivity(), this.gom, this.goD);
            this.goI.lD(true);
        }
        this.gol = getVoiceManager();
        if (this.gol != null) {
            this.gol.onCreate(getPageContext());
        }
        new com.baidu.tieba.frs.mc.i();
        int i = -1;
        if (this.goN != null && this.goN.bJd() != null) {
            i = this.goN.bJd().bDQ();
            arrayList = this.goN.bJd().getDataList();
        }
        this.goN = new com.baidu.tieba.frs.mc.c(this, this.gpB);
        this.goN.bJd().setHasMore(i);
        if (arrayList != null && arrayList.size() > 0) {
            this.goN.bJd().at(arrayList);
        }
        this.goG = new com.baidu.tieba.frs.smartsort.a(this);
        this.goO = new com.baidu.tieba.frs.vc.j(this);
        this.goL = new com.baidu.tieba.frs.vc.a(getPageContext(), this.goC.bJq());
        this.goH = new com.baidu.tieba.frs.mc.b(this);
        this.goM = new com.baidu.tieba.frs.mc.d(this);
        this.goF = new com.baidu.tieba.frs.mc.h(this);
        this.goP = new com.baidu.tieba.frs.mc.a(this);
        this.goS = new com.baidu.tieba.frs.vc.c(this);
        this.goT = new com.baidu.tieba.frs.mc.e(this, getUniqueId());
        this.goZ = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "frs");
        this.gpa = new com.baidu.tieba.ala.a(getPageContext());
        this.gpc = new com.baidu.tieba.frs.sportspage.notification.a(getPageContext());
        registerListener(this.gpt);
        registerListener(this.mMemListener);
        registerListener(this.gpr);
        registerListener(this.gpC);
        registerListener(this.gpA);
        registerListener(this.gpo);
        registerListener(this.gpp);
        registerListener(this.gpq);
        registerListener(this.gpi);
        registerListener(this.gpj);
        registerListener(this.KN);
        registerListener(this.gpH);
        registerListener(this.gpv);
        registerListener(this.gpk);
        registerListener(this.gpw);
        registerListener(this.gpu);
        registerListener(this.gpx);
        registerListener(this.gpy);
        this.gpI.setTag(getPageContext().getUniqueId());
        MessageManager.getInstance().registerListener(this.gpI);
        registerListener(this.gpJ);
        registerListener(this.gpK);
        this.gom.lo(false);
        if (!bEs() && !this.hasInit) {
            showLoadingView(this.gom.bsE(), true);
            this.goC.F(3, false);
        }
        com.baidu.tieba.frs.a.bCV().a(new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.19
            @Override // com.baidu.tieba.frs.a.b
            public void J(boolean z, boolean z2) {
                if (FrsFragment.this.gom != null) {
                    FrsFragment.this.gom.sM(z ? 0 : 8);
                    if (!z2) {
                        FrsFragment.this.gpe = z;
                    }
                    if (FrsFragment.this.gom.bFf() != null && FrsFragment.this.goC != null && FrsFragment.this.goC.bJl()) {
                        FrsFragment.this.gom.bFf().notifyDataSetChanged();
                    }
                    if (FrsFragment.this.bDN() != null) {
                        FrsTabViewController.b bKY = FrsFragment.this.bDN().bKY();
                        if (bKY != null && bKY.tabId == 502 && (bKY.fragment instanceof FrsCommonTabFragment)) {
                            ((FrsCommonTabFragment) bKY.fragment).bGC();
                        } else if (bKY != null && bKY.tabId == 503 && (bKY.fragment instanceof FrsNewAreaFragment)) {
                            FrsNewAreaFragment frsNewAreaFragment = (FrsNewAreaFragment) bKY.fragment;
                            frsNewAreaFragment.bGC();
                            if (frsNewAreaFragment.bJx() != null) {
                                com.baidu.tieba.frs.mc.g bJx = frsNewAreaFragment.bJx();
                                bJx.lr(!z);
                                bJx.ls(!z);
                            }
                        }
                        if (FrsFragment.this.bDN().bKR() != null) {
                            FrsFragment.this.bDN().bKR().setmDisallowSlip(z);
                            FrsFragment.this.bDN().mh(z);
                        }
                    }
                    if (FrsFragment.this.gom.bEM() != null) {
                        FrsFragment.this.gom.ll(!z);
                    }
                    if (FrsFragment.this.getActivity() instanceof FrsActivity) {
                        ((FrsActivity) FrsFragment.this.getActivity()).lc(!z);
                    }
                    if (FrsFragment.this.gpb != null) {
                        FrsFragment.this.gpb.lK(!z);
                    }
                    FrsFragment.this.gom.lr(!z);
                    FrsFragment.this.gom.ls(z ? false : true);
                }
            }

            @Override // com.baidu.tieba.frs.a.b
            public void sz(int i2) {
                if (FrsFragment.this.gom != null) {
                    FrsFragment.this.gom.sN(i2);
                }
            }

            @Override // com.baidu.tieba.frs.a.b
            public void bDc() {
                com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getContext(), (int) R.string.frs_multi_delete_max_num);
            }
        });
        this.gom.b(new d.a() { // from class: com.baidu.tieba.frs.FrsFragment.20
            @Override // com.baidu.tieba.NEGFeedBack.d.a
            public void a(DeleteThreadHttpResponseMessage deleteThreadHttpResponseMessage) {
                boolean z;
                int i2 = 0;
                if (deleteThreadHttpResponseMessage != null) {
                    FrsFragment.this.gom.aWn();
                    FrsFragment.this.gom.bFn();
                    FrsNewAreaFragment frsNewAreaFragment = null;
                    if (FrsFragment.this.goE == null || FrsFragment.this.goE.bKY() == null || !(FrsFragment.this.goE.bKY().fragment instanceof FrsNewAreaFragment)) {
                        z = false;
                    } else {
                        frsNewAreaFragment = (FrsNewAreaFragment) FrsFragment.this.goE.bKY().fragment;
                        z = true;
                    }
                    if (deleteThreadHttpResponseMessage.getError() == 0) {
                        String text = !TextUtils.isEmpty(deleteThreadHttpResponseMessage.getText()) ? deleteThreadHttpResponseMessage.getText() : FrsFragment.this.getString(R.string.delete_fail);
                        if (deleteThreadHttpResponseMessage.getRetType() == 1211066) {
                            if (FrsFragment.this.fLP == null) {
                                FrsFragment.this.fLP = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.fLP.sS(text);
                            FrsFragment.this.fLP.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.20.1
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.fLP.fH(false);
                            FrsFragment.this.fLP.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.fLP.aEC();
                        } else if (deleteThreadHttpResponseMessage.getRetType() == 1211067) {
                            if (FrsFragment.this.fLP == null) {
                                FrsFragment.this.fLP = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.fLP.sS(text);
                            FrsFragment.this.fLP.a(R.string.know, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.20.2
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.fLP.fH(false);
                            FrsFragment.this.fLP.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.fLP.aEC();
                        } else {
                            FrsFragment.this.gom.az(deleteThreadHttpResponseMessage.getText(), ContextCompat.getColor(FrsFragment.this.getContext(), deleteThreadHttpResponseMessage.getRetType() == 1 ? R.color.nav_bar_tip_error : R.color.cp_link_tip_a_alpha95));
                        }
                        if (z && frsNewAreaFragment != null) {
                            frsNewAreaFragment.co(deleteThreadHttpResponseMessage.getSuccessItems());
                        }
                        FrsFragment.this.cd(deleteThreadHttpResponseMessage.getSuccessItems());
                        com.baidu.tieba.frs.a.bCV().cc(deleteThreadHttpResponseMessage.getSuccessItems());
                        for (com.baidu.adp.widget.ListView.m mVar : FrsFragment.this.gnM.getThreadList()) {
                            if (mVar instanceof bi) {
                                i2++;
                                continue;
                            }
                            if (i2 >= 6) {
                                break;
                            }
                        }
                        if (i2 < 6) {
                            FrsFragment.this.bcf();
                            return;
                        }
                        return;
                    }
                    com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getActivity(), deleteThreadHttpResponseMessage.getErrorString());
                }
            }
        });
        this.cdv = UtilHelper.getScreenHeight(getActivity());
        this.hasInit = true;
        sE(1);
        super.onActivityCreated(bundle);
        this.createTime = System.currentTimeMillis() - this.beginTime;
    }

    public void lg(boolean z) {
        if (this.goE != null) {
            this.goE.gMR = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cd(List<String> list) {
        if (!com.baidu.tbadk.core.util.v.isEmpty(list)) {
            ArrayList<com.baidu.adp.widget.ListView.m> threadList = this.gnM.getThreadList();
            if (!com.baidu.tbadk.core.util.v.isEmpty(threadList) && this.gom.getListView() != null && this.gom.getListView().getData() != null) {
                Iterator<com.baidu.adp.widget.ListView.m> it = threadList.iterator();
                List<com.baidu.adp.widget.ListView.m> data = this.gom.getListView().getData();
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.m next = it.next();
                    if (next instanceof bi) {
                        bj bjVar = ((bi) next).cRf;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= list.size()) {
                                break;
                            } else if (!com.baidu.tbadk.core.util.aq.equals(list.get(i2), bjVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.goN.d(next);
                                this.gom.getListView().getAdapter().notifyItemRemoved(i);
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
    public void bcz() {
        if (isAdded() && this.enU && !isLoadingViewAttached()) {
            showLoadingView(this.gom.bsE(), true);
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void bcA() {
        if (isAdded() && this.enU && isLoadingViewAttached()) {
            hideLoadingView(this.gom.bsE());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (bEs()) {
            showLoadingView(this.gom.bsE(), true);
            this.gom.sO(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.goC.F(3, true);
            aIh().scrollToPosition(0);
        }
    }

    private void sE(int i) {
        String str = "";
        if (this.gnM != null && this.gnM.getForum() != null) {
            str = this.gnM.getForum().getId();
        }
        if (!StringUtils.isNull(str)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13008").cy("fid", str).cy("obj_type", "4").X("obj_locate", i).cy("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.z zVar) {
        if (zVar != null) {
            this.dGO = zVar.aSo();
            this.goU = zVar.aSp();
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void showFloatingView() {
        if (this.dGO != null) {
            this.dGO.hd(true);
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
                this.goe = uri.getQueryParameter("name");
                this.mFrom = uri.getQueryParameter("from");
                if (!StringUtils.isNull(this.goe)) {
                    intent.putExtra("name", this.goe);
                }
                if (!StringUtils.isNull(this.mFrom)) {
                    intent.putExtra("from", this.mFrom);
                }
                TiebaStatic.log(TbadkCoreStatisticKey.AS_INVOKE_TIEBA);
            }
            if (StringUtils.isNull(this.goe) && intent != null && intent.getParcelableExtra("key_uri") != null) {
                Uri uri2 = (Uri) intent.getParcelableExtra("key_uri");
                if (com.baidu.tbadk.BdToken.f.n(uri2)) {
                    com.baidu.tbadk.BdToken.f.axP().b(uri2, new f.a() { // from class: com.baidu.tieba.frs.FrsFragment.21
                        @Override // com.baidu.tbadk.BdToken.f.a
                        public void n(HashMap<String, Object> hashMap) {
                            if (hashMap != null && (hashMap.get(com.baidu.tbadk.BdToken.f.cIi) instanceof String)) {
                                FrsFragment.this.goe = (String) hashMap.get(com.baidu.tbadk.BdToken.f.cIi);
                            }
                        }
                    });
                } else {
                    com.baidu.tieba.frs.f.d al = com.baidu.tieba.frs.f.i.al(intent);
                    if (al != null) {
                        this.goe = al.forumName;
                        if (al.gLc == null || al.gLc.equals("aidou")) {
                        }
                    }
                }
                if (!StringUtils.isNull(this.goe)) {
                    intent.putExtra("name", this.goe);
                }
                intent.putExtra(FrsActivityConfig.FRS_CALL_FROM, 12);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.gol = getVoiceManager();
        if (this.gol != null) {
            this.gol.onStart(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        Intent intent;
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.dor);
        if (bundle != null) {
            this.goe = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
            this.goe = intent.getStringExtra("name");
            this.mFrom = intent.getStringExtra("from");
            this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
        }
        if (getArguments() != null) {
            this.gof = getArguments().getBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, false);
        }
        if (TextUtils.isEmpty(this.mFrom) || FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
        }
        if (this.mIsLogin) {
            registerListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL, this.dor);
        }
        this.goD.aj(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.s.c.cKa().x(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.gpH);
        gop = null;
        if (this.gol != null) {
            this.gol.onDestory(getPageContext());
        }
        com.baidu.tieba.recapp.report.a.remove("FRS");
        this.gol = null;
        com.baidu.tieba.card.r.bvg().kp(false);
        if (this.gnM != null && this.gnM.getForum() != null) {
            ab.bFJ().dv(com.baidu.adp.lib.f.b.toLong(this.gnM.getForum().getId(), 0L));
        }
        if (this.goQ != null) {
            this.goQ.onDestory();
        }
        if (this.gom != null) {
            com.baidu.tieba.frs.f.h.a(this.gom, this.gnM, getForumId(), false, null);
            this.gom.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.gox != null) {
                this.gox.aRd();
            }
            this.gom.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.goD.aiI();
        if (this.goC != null) {
            this.goC.bgW();
        }
        if (this.goI != null) {
            this.goI.aWI();
        }
        if (this.goL != null) {
            this.goL.destory();
        }
        if (this.goG != null) {
            this.goG.onDestroy();
        }
        if (this.goX != null) {
            this.goX.onDestory();
        }
        if (this.goP != null) {
            this.goP.onDestroy();
        }
        if (this.goZ != null) {
            this.goZ.onDestroy();
        }
        if (this.gpa != null) {
            this.gpa.onDestroy();
        }
        com.baidu.tieba.recapp.d.a.cDk().cDm();
        com.baidu.tieba.frs.f.j.bKd();
        if (this.goE != null) {
            this.goE.a((FrsTabViewController.a) null);
            this.goE.bLa();
        }
        if (this.gpd != null) {
            this.gpd.onDestroy();
        }
        com.baidu.tieba.frs.a.bCV().a(null);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.goe);
        bundle.putString("from", this.mFrom);
        this.goC.onSaveInstanceState(bundle);
        if (this.gol != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            this.gol.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.goP != null) {
            this.goP.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.gom != null) {
            this.gom.bET();
            this.gom.onResume();
        }
        this.goF.lZ(true);
        this.goy = true;
        if (god) {
            god = false;
            this.gom.startPullRefresh();
            return;
        }
        if (this.gol != null) {
            this.gol.onResume(getPageContext());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_RESUME));
        this.gom.lt(false);
        if (this.goY) {
            refresh(6);
            this.goY = false;
        }
        bEy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
    }

    public boolean bEe() {
        Intent intent;
        if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
            return false;
        }
        return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
    }

    public void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.goe = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.gog = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.gog) {
                bEf();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEf() {
        this.gom.startPullRefresh();
    }

    public void closeActivity() {
        com.baidu.tieba.frs.f.i.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.mFrom);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.gom.setTitle(this.goe);
        } else {
            this.gom.setTitle("");
            this.mFlag = 1;
        }
        this.gom.a(this.gpF);
        this.gom.addOnScrollListener(this.mScrollListener);
        this.gom.g(this.glL);
        this.gom.bFf().a(this.gpE);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gpf) {
            this.gom.onChangeSkinType(i);
            this.goD.uj(i);
            this.goE.onChangeSkinType(i);
            if (this.goo != null) {
                this.goo.onChangeSkinType(i);
            }
            if (this.goV != null) {
                this.goV.onChangeSkinType();
            }
            if (this.gpb != null) {
                this.gpb.onChangeSkinType(getPageContext(), i);
            }
            if (this.fLP != null) {
                com.baidu.tbadk.q.a.a(getPageContext(), this.fLP.getRealView());
            }
            if (this.goW != null) {
                this.goW.onChangeSkinType();
            }
            if (this.goX != null) {
                this.goX.onChangeSkinType(getPageContext(), i);
            }
        }
    }

    public void sF(int i) {
        if (!this.mIsLogin) {
            if (this.gnM != null && this.gnM.getAnti() != null) {
                this.gnM.getAnti().setIfpost(1);
            }
            if (i == 0) {
                bc.skipToLoginActivity(getActivity());
            }
        } else if (this.gnM != null) {
            if (i == 0) {
                com.baidu.tieba.frs.f.j.e(this, 0);
            } else {
                this.gom.bEV();
            }
        }
    }

    public void refresh() {
        com.baidu.tieba.a.d.aXF().wN("page_frs");
        refresh(3);
    }

    public void refresh(int i) {
        this.gov = false;
        bEk();
        if (this.gom != null && this.gom.bEK() != null) {
            this.gom.bEK().bOp();
        }
        if (this.goC != null) {
            this.goC.F(i, true);
        }
    }

    private void bEg() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.f.h.gy().submitTask(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.26
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.Ji(FrsFragment.this.goe);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEh() {
        bEk();
        try {
            if (this.gnM != null) {
                this.gom.bgy();
                this.gom.ll(bEx());
                if (!com.baidu.tieba.frs.vc.h.l(this.gnM) || !com.baidu.tieba.frs.vc.h.k(this.gnM)) {
                }
                if (this.gnM.getForum() != null) {
                    this.goe = this.gnM.getForum().getName();
                    this.forumId = this.gnM.getForum().getId();
                }
                if (this.gnM.getPage() != null) {
                    setHasMore(this.gnM.getPage().aBk());
                }
                this.gom.setTitle(this.goe);
                this.gom.setForumName(this.goe);
                TbadkCoreApplication.getInst().setDefaultBubble(this.gnM.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.gnM.getUserData().getBimg_end_time());
                bEg();
                bEi();
                ArrayList<com.baidu.adp.widget.ListView.m> threadList = this.gnM.getThreadList();
                if (threadList != null) {
                    this.gom.a(threadList, this.gnM);
                    com.baidu.tieba.frs.f.c.y(this.gom);
                    this.goD.uk(getPageNum());
                    this.goD.i(this.gnM);
                    this.goE.a(this.gnM, this.goC.bJp());
                    this.gom.bEW();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void bEi() {
        if (this.gnM != null) {
            if (this.gnM.getIsNewUrl() == 1) {
                this.gom.bFf().setFromCDN(true);
            } else {
                this.gom.bFf().setFromCDN(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.goF.lZ(false);
        this.goy = false;
        this.gom.onPause();
        if (this.gol != null) {
            this.gol.onPause(getPageContext());
        }
        this.gom.lt(true);
        if (this.goL != null) {
            this.goL.bKg();
        }
        com.baidu.tbadk.BdToken.c.axz().axE();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.goE != null && this.goE.bKY() != null && (this.goE.bKY().fragment instanceof BaseFragment)) {
            ((BaseFragment) this.goE.bKY().fragment).setPrimary(z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.r.bvg().kp(false);
        le(false);
        if (this.gnM != null && this.gnM.getForum() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            com.baidu.tbadk.distribute.a.aOh().a(getPageContext().getPageActivity(), "frs", this.gnM.getForum().getId(), 0L);
        }
        if (this.gol != null) {
            this.gol.onStop(getPageContext());
        }
        if (aIh() != null) {
            aIh().getRecycledViewPool().clear();
        }
        this.goD.aHB();
        com.baidu.tbadk.util.aa.aSr();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            if (this.goD != null) {
                this.goD.onPrimary(isPrimary());
            }
            if (this.gom != null) {
                this.gom.onPrimary(isPrimary());
                this.gom.lt(!isPrimary());
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (com.baidu.tieba.frs.a.bCV().bCW()) {
                com.baidu.tieba.frs.a.bCV().reset();
                return true;
            } else if (this.gom != null) {
                return this.gom.bES();
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
        com.baidu.tbadk.distribute.a.aOh().a(advertAppInfo, this.forumId, 0L, "FRS", str, getPn());
    }

    @Override // com.baidu.tieba.recapp.n
    public void bEj() {
        bDK().bEj();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.gol == null) {
            this.gol = VoiceManager.instance();
        }
        return this.gol;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdRecyclerView aIh() {
        if (this.gom == null) {
            return null;
        }
        return this.gom.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void bEk() {
        if (this.gol != null) {
            this.gol.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> aIi() {
        if (this.djc == null) {
            this.djc = UserIconBox.x(getPageContext().getPageActivity(), 8);
        }
        return this.djc;
    }

    public void bEl() {
        if (getFragmentActivity() != null && getFragmentActivity().getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.p onGetPreLoadListView() {
        return aIh().getPreLoadHandle();
    }

    @Override // com.baidu.tieba.frs.ai
    public NavigationBar beL() {
        if (this.gom == null) {
            return null;
        }
        return this.gom.beL();
    }

    public FRSRefreshButton bEm() {
        return this.goo;
    }

    public void a(FRSRefreshButton fRSRefreshButton) {
        if (fRSRefreshButton != null) {
            this.goo = fRSRefreshButton;
            this.goo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.32
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (FrsFragment.this.goE != null) {
                        FrsTabViewController.b bKY = FrsFragment.this.goE.bKY();
                        if (bKY != null && bKY.fragment != null && (bKY.fragment instanceof ah)) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                            ((ah) bKY.fragment).scrollToTop();
                            ((ah) bKY.fragment).bdq();
                            return;
                        }
                        FrsFragment.this.bDP().startPullRefresh();
                    }
                }
            });
        }
    }

    public void bEn() {
        if (this.goo != null) {
            this.goo.hide();
        }
    }

    public void bEo() {
        if (this.goo != null) {
            this.goo.show();
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
                if (bdUniqueId == q.grp) {
                    if (FrsFragment.this.gom != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11752").cy("fid", FrsFragment.this.forumId).cy("obj_locate", "1"));
                        FrsFragment.this.gom.startPullRefresh();
                    }
                } else if (mVar != null && (mVar instanceof bi)) {
                    bj bjVar = ((bi) mVar).cRf;
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
                                if (readThreadHistory != null && !readThreadHistory.Jo(bjVar.getId())) {
                                    readThreadHistory.Jn(bjVar.getId());
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
                                if (bdUniqueId.getId() == bj.cTd.getId()) {
                                    com.baidu.tieba.frs.f.h.a(bjVar.aBU());
                                } else if (bdUniqueId.getId() == bj.cRD.getId()) {
                                    com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                                    anVar.cy("obj_type", "2");
                                    anVar.cy("tid", bjVar.getTid());
                                    TiebaStatic.log(anVar);
                                }
                                com.baidu.tieba.frs.f.i.a(FrsFragment.this, bjVar, i, z);
                                com.baidu.tieba.frs.f.h.a(FrsFragment.this, FrsFragment.this.gnM, bjVar);
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
            hideNetRefreshView(this.gom.bsE());
            showLoadingView(this.gom.bsE(), true);
            this.gom.lo(false);
            this.goC.F(3, true);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData bEp() {
        return this.gnM;
    }

    public boolean bEq() {
        return this.gom.bEq();
    }

    public void at(Object obj) {
        if (this.goH != null && this.goH.gGC != null) {
            this.goH.gGC.callback(obj);
        }
    }

    public void au(Object obj) {
        if (this.goH != null && this.goH.gGD != null) {
            this.goH.gGD.callback(obj);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        this.gom.getListView().stopScroll();
        if (!this.gom.bFb()) {
            if (!com.baidu.adp.lib.util.l.isNetOk()) {
                this.gom.bdt();
            } else if (this.goC.bJk() == 1) {
                bcu();
                bcf();
            } else if (this.goC.hasMore()) {
                bcf();
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void onFailed(String str) {
        bcu();
        showToast(str);
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void al(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        boolean isEmpty = com.baidu.tbadk.core.util.v.isEmpty(arrayList);
        setHasMore(isEmpty ? 0 : 1);
        bcu();
        if (!isEmpty) {
            if (!this.goC.bJt() && TbadkCoreApplication.getInst().isRecAppExist() && this.goC.bJk() == 1) {
                this.gnM.addRecommendAppToThreadList(this, arrayList);
            }
            if (this.goC != null) {
                com.baidu.tieba.frs.d.a.a(getUniqueId(), arrayList, this.gnM.getForum(), this.goC.getSortType());
            }
            ArrayList<com.baidu.adp.widget.ListView.m> a2 = this.goN.a(false, false, arrayList, this.goi, false);
            if (a2 != null) {
                this.gnM.setThreadList(a2);
                this.gom.a(a2, this.gnM);
            }
            if (this.goC != null) {
                com.baidu.tieba.frs.d.c.a(this.gnM, this.goC.bJp(), 2, getContext());
            }
        }
    }

    private void bcu() {
        if (bDQ() == 1 || this.goN.cn(this.gnM.getThreadListIds())) {
            if (com.baidu.tbadk.core.util.v.getCount(this.gnM.getThreadList()) > 3) {
                this.gom.bdr();
            } else {
                this.gom.bFi();
            }
        } else if (com.baidu.tbadk.core.util.v.isEmpty(this.gnM.getThreadList())) {
            this.gom.bdt();
        } else {
            this.gom.bds();
        }
    }

    @Override // com.baidu.tieba.frs.mc.l
    public void bcf() {
        if (this.goN != null) {
            this.goN.a(this.goe, this.forumId, this.gnM);
        }
    }

    public void bEr() {
        if (!com.baidu.tbadk.core.util.ab.requestWriteExternalStorgeAndCameraPermission(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.al.e(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment, com.baidu.k.a.a.InterfaceC0078a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        com.baidu.tieba.frs.f.i.a(this, i, strArr, iArr);
    }

    public void lh(boolean z) {
        if (this.goI != null) {
            this.goI.lD(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.goJ.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a nS(int i) {
        return this.goJ.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        this.goR.b(bVar);
    }

    public boolean bEs() {
        return this.goa;
    }

    @Override // com.baidu.tieba.frs.af
    public void AC() {
        if (this.gom != null) {
            showFloatingView();
            this.gom.getListView().scrollToPosition(0);
            this.gom.startPullRefresh();
        }
    }

    public ForumWriteData bEt() {
        if (this.gnM == null || this.gnM.getForum() == null) {
            return null;
        }
        ForumData forum = this.gnM.getForum();
        ForumWriteData forumWriteData = new ForumWriteData(forum.getId(), forum.getName(), forum.getPrefixData(), this.gnM.getAnti());
        forumWriteData.avatar = forum.getImage_url();
        forumWriteData.forumLevel = forum.getUser_level();
        forumWriteData.specialForumType = forum.special_forum_type;
        forumWriteData.firstDir = forum.getFirst_class();
        forumWriteData.secondDir = forum.getSecond_class();
        UserData userData = this.gnM.getUserData();
        forumWriteData.privateThread = userData != null ? userData.getPrivateThread() : 0;
        return forumWriteData;
    }

    @Override // com.baidu.tieba.frs.af
    public void aHN() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void li(boolean z) {
        this.goz = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z) {
        this.gom.sL(8);
        ((FrsActivity) getActivity()).showLoadingView(view, z);
        ((FrsActivity) getActivity()).g(view, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        this.gom.sL(0);
        ((FrsActivity) getActivity()).hideLoadingView(view);
        ((FrsActivity) getActivity()).g(view, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        super.showNetRefreshView(view, getResources().getString(R.string.refresh_view_title_text), null, getResources().getString(R.string.refresh_view_button_text), z, getNetRefreshListener());
        this.gom.sL(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshViewNoClick(View view, String str, boolean z) {
        super.showNetRefreshViewNoClick(view, str, z);
        this.gom.sL(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        super.hideNetRefreshView(view);
        this.gom.sL(0);
    }

    public void bEu() {
        FrsTabViewController.b bKY;
        if (this.goE != null && (bKY = this.goE.bKY()) != null && bKY.fragment != null && (bKY.fragment instanceof ah)) {
            ((ah) bKY.fragment).scrollToTop();
        }
    }

    public void lj(boolean z) {
        this.goc = z;
    }

    public void b(OvalActionButton ovalActionButton) {
        this.gon = ovalActionButton;
    }

    public OvalActionButton bEv() {
        return this.gon;
    }

    public boolean bEw() {
        return this.goc;
    }

    public void onShareSuccess(String str) {
        if (TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.util.aq.isEmpty(str)) {
            if (this.gpd == null) {
                this.gpd = new AddExperiencedModel(getTbPageContext());
            }
            this.gpd.ev(this.forumId, str);
        }
    }

    public boolean bEx() {
        if (this.goz && !this.gpg) {
            return (this.goC != null && this.goC.bJl() && com.baidu.tieba.frs.a.bCV().bCW()) ? false : true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.g.c
    public boolean videoNeedPreload() {
        if (this.gnM != null) {
            return com.baidu.tbadk.util.af.mT(2) || (com.baidu.tbadk.util.af.aSw() && this.gnM.isFrsVideoAutoPlay);
        }
        return super.videoNeedPreload();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.g.c
    public boolean isCyberVideoUsedThisPage() {
        return com.baidu.tbadk.a.b.rH("cyber_player_test");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEy() {
        if (!com.baidu.tbadk.core.util.aq.isEmpty(this.forumId)) {
            com.baidu.tbadk.BdToken.c.axz().p(com.baidu.tbadk.BdToken.b.cGM, com.baidu.adp.lib.f.b.toLong(this.forumId, 0L));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        FrsTabViewController.b bKY;
        if (bDN() == null || (bKY = bDN().bKY()) == null || !(bKY.fragment instanceof BaseFragment)) {
            return null;
        }
        if (bKY.fragment instanceof FrsAllThreadFragment) {
            TbPageTag tbPageTag = super.getTbPageTag();
            int i = -1;
            if (this.gnM != null) {
                i = this.gnM.getSortType();
            }
            tbPageTag.sortType = com.baidu.tieba.frs.f.g.uh(i);
            tbPageTag.locatePage = "a070";
            if (this.gnX.equals(bKY.title)) {
                tbPageTag.locatePage = "a071";
            }
            return tbPageTag;
        } else if (bKY.fragment instanceof FrsFragment) {
            return null;
        } else {
            return ((BaseFragment) bKY.fragment).getTbPageTag();
        }
    }
}
