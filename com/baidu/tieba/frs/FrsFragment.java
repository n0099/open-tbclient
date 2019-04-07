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
import com.baidu.tbadk.BdToken.f;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.core.atomData.MessageCenterActivityConfig;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.PostSearchActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.PrivateForumPopInfoData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
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
import com.baidu.tieba.d;
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
import tbclient.WindowToast;
/* loaded from: classes4.dex */
public class FrsFragment extends BaseFragment implements BdListView.e, a.InterfaceC0042a, UserIconBox.b<BdRecyclerView>, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, ae, ah, aj, com.baidu.tieba.frs.loadmore.a, com.baidu.tieba.frs.mc.l, com.baidu.tieba.recapp.n {
    public static com.baidu.tieba.tbadkCore.j eYI;
    private com.baidu.adp.lib.e.b<TbImageView> bTU;
    private com.baidu.tbadk.util.w ctI;
    private com.baidu.tieba.frs.gametab.b doq;
    private com.baidu.tieba.tbadkCore.data.f eYA;
    private VoiceManager eYD;
    private OvalActionButton eYF;
    private FRSRefreshButton eYG;
    private com.baidu.card.z eYU;
    private FrsModelController eYV;
    private com.baidu.tieba.frs.vc.f eYW;
    private FrsTabViewController eYX;
    private com.baidu.tieba.frs.mc.h eYY;
    private com.baidu.tieba.frs.smartsort.b eYZ;
    private com.baidu.tieba.frs.entelechy.a eYq;
    private int eZJ;
    private com.baidu.tieba.frs.mc.b eZa;
    private ak eZb;
    private com.baidu.tieba.frs.entelechy.b.b eZd;
    private com.baidu.tbadk.k.a eZe;
    private com.baidu.tieba.frs.vc.a eZf;
    private com.baidu.tieba.frs.mc.d eZg;
    private com.baidu.tieba.frs.mc.c eZh;
    private com.baidu.tieba.frs.vc.h eZi;
    private com.baidu.tieba.frs.mc.a eZj;
    private com.baidu.tieba.frs.live.a eZk;
    private j eZl;
    public com.baidu.tieba.frs.vc.c eZm;
    private com.baidu.tieba.frs.mc.e eZn;
    private View.OnTouchListener eZo;
    private com.baidu.tieba.frs.view.a eZp;
    private com.baidu.tieba.frs.view.c eZq;
    private com.baidu.tieba.frs.vc.e eZr;
    private boolean eZs;
    private com.baidu.tieba.NEGFeedBack.a eZu;
    private com.baidu.tieba.ala.a eZv;
    private com.baidu.tieba.frs.brand.buttommenu.a eZw;
    private AddExperiencedModel eZx;
    private boolean eZz;
    private com.baidu.tbadk.core.dialog.a eka;
    private View mRootView;
    public static boolean eYv = false;
    public static volatile long eYK = 0;
    public static volatile long eYL = 0;
    public static volatile int eYM = 0;
    public boolean eYr = false;
    private boolean eYs = false;
    private boolean eYt = false;
    private boolean eYu = true;
    public String eYw = null;
    public String mFrom = null;
    public int mFlag = 0;
    public boolean eYx = false;
    private boolean eYy = false;
    private String mThreadId = null;
    public String forumId = null;
    private int eYj = 0;
    private boolean eYz = false;
    private boolean eYB = false;
    private boolean eYC = false;
    private k eYE = null;
    private boolean eYH = false;
    public final bg bTn = null;
    private FrsViewData eYh = new FrsViewData();
    public long eCw = -1;
    public long cqx = 0;
    public long cqp = 0;
    public long createTime = 0;
    public long beginTime = -1;
    public long eYJ = 0;
    public boolean eYN = false;
    private boolean eYO = false;
    private boolean eYP = false;
    public com.baidu.tbadk.o.b eYQ = null;
    private boolean eYR = true;
    private boolean eYS = true;
    private a.C0039a eYT = new a.C0039a(2);
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> eZc = new SparseArray<>();
    private boolean ddg = true;
    private boolean eZt = false;
    private boolean hasInit = false;
    private boolean eZy = false;
    private AlphaAnimation eZA = null;
    private AlphaAnimation eZB = null;
    private AddExperiencedModel.a eZC = new AddExperiencedModel.a() { // from class: com.baidu.tieba.frs.FrsFragment.1
        @Override // com.baidu.tieba.share.AddExperiencedModel.a
        public void a(ContriInfo contriInfo) {
        }
    };
    private HttpMessageListener eZD = new HttpMessageListener(CmdConfigHttp.CMD_PB_FLOOR_AGREE, true) { // from class: com.baidu.tieba.frs.FrsFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof PbFloorAgreeResponseMessage)) {
                PbFloorAgreeResponseMessage pbFloorAgreeResponseMessage = (PbFloorAgreeResponseMessage) httpResponsedMessage;
            }
        }
    };
    private final CustomMessageListener eZE = new CustomMessageListener(2016495) { // from class: com.baidu.tieba.frs.FrsFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof bg) {
                    com.baidu.tieba.frs.f.h.a(FrsFragment.this.eYE, FrsFragment.this.eYh, FrsFragment.this.getForumId(), true, (bg) data);
                }
            }
        }
    };
    private CustomMessageListener eZF = new CustomMessageListener(2921005) { // from class: com.baidu.tieba.frs.FrsFragment.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.eYh != null) {
                FrsFragment.this.eYh.removeGameRankListFromThreadList();
                if (FrsFragment.this.eYE != null) {
                    FrsFragment.this.eYE.Rs();
                }
            }
        }
    };
    private CustomMessageListener XW = new CustomMessageListener(2921401) { // from class: com.baidu.tieba.frs.FrsFragment.40
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && FrsFragment.this.eYG != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() <= 0 || FrsFragment.this.eYX.bjv() == 0) {
                    if (FrsFragment.this.eYX.bjv() != 0) {
                        FrsFragment.this.bcN();
                        return;
                    }
                    return;
                }
                FrsFragment.this.bcO();
            }
        }
    };
    private CustomMessageListener eZG = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.FrsFragment.41
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 1) {
                    FrsFragment.this.bcF();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                }
            }
        }
    };
    private final ai eZH = new ai() { // from class: com.baidu.tieba.frs.FrsFragment.42
        @Override // com.baidu.tieba.frs.ai
        public void a(int i, int i2, ap apVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
            FrsFragment.this.bcv();
            if (FrsFragment.this.eZd != null) {
                FrsFragment.this.eYW.jP(FrsFragment.this.eZd.qv(i));
            }
            e.b bVar = new e.b();
            if (apVar != null) {
                bVar.isSuccess = apVar.errCode == 0;
                bVar.errorCode = apVar.errCode;
                bVar.errorMsg = apVar.errMsg;
                if (bVar.isSuccess) {
                    if (com.baidu.tbadk.core.util.v.T(arrayList)) {
                        FrsFragment.this.eYE.aCt();
                    } else if (apVar.hasMore) {
                        if (com.baidu.tbadk.core.util.v.S(FrsFragment.this.eYh.getThreadList()) > 3) {
                            FrsFragment.this.eYE.aCr();
                        } else {
                            FrsFragment.this.eYE.bdM();
                        }
                    } else if (apVar.fcQ) {
                        FrsFragment.this.eYE.aCs();
                    } else {
                        FrsFragment.this.eYE.aCt();
                    }
                }
            } else {
                apVar = new ap();
                apVar.pn = 1;
                apVar.hasMore = false;
                apVar.fcQ = false;
            }
            if (i == 1) {
                FrsFragment.this.eYR = true;
                FrsFragment.this.eZU.a(FrsFragment.this.eYV.getType(), false, bVar);
            } else {
                FrsFragment.this.a(bVar);
                if (FrsFragment.this.eYV.bhm() != null) {
                    FrsFragment.this.eYh = FrsFragment.this.eYV.bhm();
                }
                FrsFragment.this.bcH();
            }
            if (FrsFragment.this.fab != null) {
                FrsFragment.this.fab.a(i, i2, apVar, arrayList);
            }
        }
    };
    private FrsTabViewController.a eZI = new FrsTabViewController.a() { // from class: com.baidu.tieba.frs.FrsFragment.43
        @Override // com.baidu.tieba.frs.vc.FrsTabViewController.a
        public void jG(int i) {
            boolean z = false;
            if (i != 1) {
                com.baidu.tieba.card.t.aQD().hQ(false);
                FrsFragment.this.iS(false);
            }
            if (i == 303 && i != FrsFragment.this.eZJ) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13121").bJ(ImageViewerConfig.FORUM_ID, FrsFragment.this.forumId).bJ("uid", TbadkCoreApplication.getCurrentAccount()));
            }
            if (i == 502) {
                FrsFragment.this.eYF.setIconFade(d.f.btn_frs_professional_edit_n);
            } else {
                FrsFragment.this.eYF.setIconFade(0);
            }
            FrsFragment.this.eZJ = i;
            FrsFragment.this.bcK();
            com.baidu.tieba.frs.d.d.fgQ.fsP = i;
            com.baidu.tieba.frs.d.d.fgQ.fsQ = -1;
            com.baidu.tieba.frs.a bbD = com.baidu.tieba.frs.a.bbD();
            if (i == 1 && FrsFragment.this.eZy) {
                z = true;
            }
            bbD.z(z, true);
        }
    };
    private CustomMessageListener eZK = new CustomMessageListener(2001606) { // from class: com.baidu.tieba.frs.FrsFragment.44
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                FrsFragment.this.eYX.rA(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    };
    private CustomMessageListener eZL = new CustomMessageListener(2001607) { // from class: com.baidu.tieba.frs.FrsFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && ((Integer) customResponsedMessage.getData()).intValue() == 51 && FrsFragment.this.eYh != null) {
                com.baidu.tieba.frs.f.j.a(FrsFragment.this.eYh, FrsFragment.this.getPageContext());
            }
        }
    };
    private final CustomMessageListener eZM = new CustomMessageListener(2003019) { // from class: com.baidu.tieba.frs.FrsFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                FrsFragment.this.eYX.ry(49);
            }
        }
    };
    private final CustomMessageListener eZN = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.frs.FrsFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && FrsFragment.this.eYh != null && FrsFragment.this.eYh.getForum() != null) {
                SignData signData = (SignData) customResponsedMessage.getData();
                int user_level = FrsFragment.this.eYh.getForum().getUser_level();
                if (signData.forumId != null && signData.forumId.equals(FrsFragment.this.eYh.getForum().getId())) {
                    FrsFragment.this.eYh.updateSignData(signData);
                    FrsFragment.this.eYW.i(FrsFragment.this.eYh);
                    if (FrsFragment.this.eYW.bjg()) {
                        i = FrsFragment.this.eYh.getForum().getUser_level();
                        if (user_level >= i) {
                            i++;
                        }
                    } else {
                        i = user_level;
                    }
                    TbadkCoreApplication.getInst().addSignedForum(FrsFragment.this.eYh.getForum().getName(), signData.sign_bonus_point, i);
                }
            }
        }
    };
    private final CustomMessageListener eZO = new CustomMessageListener(2001352) { // from class: com.baidu.tieba.frs.FrsFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.r) && FrsFragment.this.eYh != null) {
                FrsFragment.this.eYh.updateLikeData((com.baidu.tieba.tbadkCore.r) customResponsedMessage.getData());
                FrsFragment.this.eYW.h(FrsFragment.this.eYh);
                FrsFragment.this.eYX.a(FrsFragment.this.eYh, FrsFragment.this.eYV.bhN());
            }
        }
    };
    private final AntiHelper.a eZP = new AntiHelper.a() { // from class: com.baidu.tieba.frs.FrsFragment.6
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12536").T("obj_locate", at.a.bLp));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12535").T("obj_locate", at.a.bLp));
        }
    };
    private CustomMessageListener ddr = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.frs.FrsFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(FrsFragment.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().bYB != null) {
                        if (AntiHelper.a(FrsFragment.this.getActivity(), updateAttentionMessage.getData().bYB, FrsFragment.this.eZP) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12534").T("obj_locate", at.a.bLp));
                        }
                    } else if (updateAttentionMessage.getData().Jy && updateAttentionMessage.getData().isAttention) {
                        com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getPageContext().getPageActivity(), d.j.attention_success);
                    }
                }
            }
        }
    };
    private CustomMessageListener eZQ = new CustomMessageListener(2921346) { // from class: com.baidu.tieba.frs.FrsFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsFragment.this.refresh();
        }
    };
    private CustomMessageListener eZR = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.frs.FrsFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                FrsFragment.this.eYE.c((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener eZS = new CustomMessageListener(2001626) { // from class: com.baidu.tieba.frs.FrsFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewsRemindMessage newsRemindMessage;
            if (customResponsedMessage != null && (customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626 && (newsRemindMessage = (NewsRemindMessage) customResponsedMessage) != null) {
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (FrsFragment.this.eYE != null) {
                    FrsFragment.this.eYE.w(notificationCount, z);
                }
            }
        }
    };
    private final CustomMessageListener brs = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.frs.FrsFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.isResumed()) {
                FrsFragment.this.bcX();
            }
        }
    };
    private CustomMessageListener eZT = new CustomMessageListener(2003020) { // from class: com.baidu.tieba.frs.FrsFragment.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (FrsFragment.this.eYE != null) {
                    FrsFragment.this.eYE.setExpanded(booleanValue);
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.n eZU = new com.baidu.tieba.tbadkCore.n() { // from class: com.baidu.tieba.frs.FrsFragment.14
        private long startTime = 0;

        @Override // com.baidu.tieba.tbadkCore.n
        public void pT(int i) {
            this.startTime = System.nanoTime();
            if (FrsFragment.this.eYE != null) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsFragment.this.eYE.bdv();
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

        @Override // com.baidu.tieba.tbadkCore.n
        public void a(int i, boolean z, e.b bVar) {
            if (FrsFragment.this.ddg) {
                FrsFragment.this.ddg = false;
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.eYE, FrsFragment.this.eYh, FrsFragment.this.getForumId(), false, null);
            }
            FrsFragment.this.bcv();
            FrsFragment.this.eYO = true;
            if (bVar != null && bVar.isSuccess) {
                FrsFragment.this.eYE.bdI().jC(com.baidu.tbadk.core.util.ar.adm().ado());
                FrsFragment.eYK = 0L;
                FrsFragment.eYL = 0L;
                FrsFragment.eYM = 0;
            } else {
                FrsFragment.eYM = 1;
            }
            if (!FrsFragment.this.eYV.bhR() && (i == 3 || i == 6)) {
                FrsFragment.this.eZh.resetData();
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (FrsFragment.this.eYV.bhm() != null) {
                FrsFragment.this.eYh = FrsFragment.this.eYV.bhm();
            }
            FrsFragment.this.eYE.b(FrsFragment.this.eYh.getRedpacketRainData());
            FrsFragment.this.pQ(1);
            if (i == 7) {
                FrsFragment.this.pR(FrsFragment.this.eYh.getFrsDefaultTabId());
                return;
            }
            if (FrsFragment.this.eYh.getPage() != null) {
                FrsFragment.this.setHasMore(FrsFragment.this.eYh.getPage().XH());
            }
            if (i == 4) {
                if (!FrsFragment.this.eYV.bhR() && TbadkCoreApplication.getInst().isRecAppExist() && FrsFragment.this.eYV.bhI() == 1) {
                    FrsFragment.this.eYh.addRecommendAppToThreadList(FrsFragment.this);
                }
                ArrayList<com.baidu.adp.widget.ListView.m> a2 = FrsFragment.this.eZh.a(false, false, FrsFragment.this.eYh.getThreadList(), FrsFragment.this.eYA, false);
                if (a2 != null) {
                    FrsFragment.this.eYh.setThreadList(a2);
                    FrsFragment.this.eYh.updateInterviewTaskInfoDataInThreadList();
                }
                if (FrsFragment.this.eYV != null) {
                    com.baidu.tieba.frs.d.c.a(FrsFragment.this.eYh, FrsFragment.this.eYV.bhN(), 2);
                }
                com.baidu.tieba.frs.f.a.a(FrsFragment.this, FrsFragment.this.eYh.getForum(), FrsFragment.this.eYh.getThreadList(), false, FrsFragment.this.getPn());
                FrsFragment.this.cqx = System.currentTimeMillis() - currentTimeMillis;
                FrsFragment.this.eYE.a(a2, FrsFragment.this.eYh);
                FrsFragment.this.bcw();
                return;
            }
            FrsFragment.this.bcw();
            switch (i) {
                case 1:
                    FrsFragment.this.eYE.bdv();
                    break;
                case 2:
                    FrsFragment.this.eYE.bdv();
                    break;
                case 3:
                case 6:
                    if (FrsFragment.this.eYh != null) {
                        FrsFragment.this.eYh.clearPostThreadCount();
                    }
                    if (FrsFragment.this.eZm != null) {
                        FrsFragment.this.eZm.refresh();
                        break;
                    }
                    break;
            }
            FrsFragment.this.bcA();
            if (bVar == null || bVar.errorCode == 0) {
                if (FrsFragment.this.eYh != null) {
                    FrsFragment.this.C(false, i == 5);
                    if (FrsFragment.this.eYV != null) {
                        com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), FrsFragment.this.eYh.getThreadList(), FrsFragment.this.eYh.getForum(), FrsFragment.this.eYV.getSortType());
                    }
                    FrsFragment.this.eYE.qc(i);
                    FrsFragment.eYK = (System.nanoTime() - this.startTime) / 1000000;
                    if (bVar != null) {
                        FrsFragment.eYL = bVar.iDB;
                    }
                } else {
                    return;
                }
            } else if (FrsFragment.this.eYh == null || com.baidu.tbadk.core.util.v.T(FrsFragment.this.eYh.getThreadList())) {
                FrsFragment.this.a(bVar);
            } else if (bVar.iDA) {
                FrsFragment.this.showToast(FrsFragment.this.getPageContext().getResources().getString(d.j.net_error_text, bVar.errorMsg, Integer.valueOf(bVar.errorCode)));
            }
            FrsFragment.this.bcx();
            FrsFragment.this.bcy();
            if (FrsFragment.this.eYh.getAccessFlag() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11384"));
            }
            if (FrsFragment.this.eCw > -1 && !FrsFragment.this.eZt) {
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.eYV, FrsFragment.this.eCw);
                FrsFragment.this.eCw = -1L;
                FrsFragment.this.eZt = true;
            }
            if (FrsFragment.this.eYB && FrsFragment.this.eYX.ry(49)) {
                FrsFragment.this.eYB = false;
            }
            FrsFragment.this.cqx = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void b(com.baidu.tieba.tbadkCore.j jVar) {
            if ((jVar != null && ("normal_page".equals(FrsFragment.this.eYV.getPageType()) || "frs_page".equals(FrsFragment.this.eYV.getPageType()) || "book_page".equals(FrsFragment.this.eYV.getPageType()))) || "brand_page".equals(FrsFragment.this.eYV.getPageType())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001615, jVar));
                FrsFragment.this.a(jVar);
                FrsFragment.eYI = jVar;
            }
        }
    };
    private final CustomMessageListener eZV = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.frs.FrsFragment.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                FrsFragment.this.eYh.updateCurrentUserPendant((com.baidu.tbadk.data.l) customResponsedMessage.getData());
                FrsFragment.this.eYE.bdI().notifyDataSetChanged();
            }
        }
    };
    private final CustomMessageListener mMemListener = new CustomMessageListener(2001194) { // from class: com.baidu.tieba.frs.FrsFragment.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && FrsFragment.this.eYh != null && (userData = FrsFragment.this.eYh.getUserData()) != null) {
                userData.setIsMem(num.intValue());
                if (num.intValue() != 0) {
                    FrsFragment.this.eYW.h(num);
                }
            }
        }
    };
    private final com.baidu.tieba.frs.mc.k eZW = new com.baidu.tieba.frs.mc.k() { // from class: com.baidu.tieba.frs.FrsFragment.26
        @Override // com.baidu.tieba.frs.mc.k
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.m> arrayList, boolean z3) {
            if (FrsFragment.this.eYZ != null && FrsFragment.this.eYV != null && FrsFragment.this.eYV.bhR() && z && !z2 && !z3) {
                FrsFragment.this.eYZ.rb(i2);
            }
        }
    };
    public final View.OnTouchListener ccW = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.FrsFragment.27
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (FrsFragment.this.eZo != null) {
                FrsFragment.this.eZo.onTouch(view, motionEvent);
            }
            if (FrsFragment.this.eZb != null && FrsFragment.this.eZb.beq() != null) {
                FrsFragment.this.eZb.beq().onTouchEvent(motionEvent);
            }
            if (FrsFragment.this.doq != null) {
                FrsFragment.this.doq.f(view, motionEvent);
            }
            if (FrsFragment.this.eYW != null) {
                FrsFragment.this.eYW.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private final CustomMessageListener eZX = new CustomMessageListener(2004507) { // from class: com.baidu.tieba.frs.FrsFragment.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "photolive_hostLevel", -1) != -1 && FrsFragment.this.eYh.getForum() != null) {
                FrsFragment.this.eYh.getForum().setCanAddPhotoLivePost(true);
            }
        }
    };
    public final View.OnClickListener eZY = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.30
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsFragment.this.eYE == null || view != FrsFragment.this.eYE.bdt() || FrsFragment.this.getActivity() == null) {
                if (FrsFragment.this.eYh == null || FrsFragment.this.eYh.getForum() == null || FrsFragment.this.eYE == null || view != FrsFragment.this.eYE.bdz()) {
                    if (FrsFragment.this.eYh != null && FrsFragment.this.eYh.getForum() != null && FrsFragment.this.eYE != null && view == FrsFragment.this.eYE.bdA()) {
                        if (FrsFragment.this.eZq == null) {
                            FrsFragment.this.eZq = new com.baidu.tieba.frs.view.c(FrsFragment.this.getPageContext());
                        }
                        FrsFragment.this.eZq.l(FrsFragment.this.eYh);
                        FrsFragment.this.eZq.showDialog();
                        return;
                    }
                    if (view.getId() == d.g.game_activity_egg_layout && com.baidu.adp.lib.util.l.lo()) {
                        TiebaStatic.log("c10853");
                        if (FrsFragment.this.eYE.bdF()) {
                            FrsFragment.this.eYE.bdG();
                        } else {
                            String activityUrl = FrsFragment.this.eYh.getForum().getYuleData().aaQ().getActivityUrl();
                            if (!StringUtils.isNull(activityUrl)) {
                                com.baidu.tbadk.browser.a.as(FrsFragment.this.getPageContext().getPageActivity(), activityUrl);
                            }
                        }
                    }
                    if (view == FrsFragment.this.eYE.bdN() && FrsFragment.this.eYV != null && FrsFragment.this.eYV.hasMore()) {
                        FrsFragment.this.eYE.aCr();
                        FrsFragment.this.aAZ();
                    }
                    if (view != null && view == FrsFragment.this.eYE.bdC() && bc.cZ(FrsFragment.this.getContext())) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12924").T("obj_locate", 2));
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(FrsFragment.this.getContext())));
                        return;
                    }
                    return;
                }
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12402").bJ(ImageViewerConfig.FORUM_ID, FrsFragment.this.eYh.getForum().getId()).bJ("uid", TbadkCoreApplication.getCurrentAccount()).bJ(ImageViewerConfig.FORUM_NAME, FrsFragment.this.eYh.getForum().getName()));
                if (!StringUtils.isNull(FrsFragment.this.eYh.getForum().getName())) {
                    FrsFragment.this.sendMessage(new CustomMessage(2002001, new PostSearchActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), FrsFragment.this.eYh.getForum().getName(), FrsFragment.this.eYh.getForum().getId())));
                    return;
                }
                return;
            }
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
            customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, FrsFragment.this.getPageContext().getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.FrsFragment.31
        private int faj = 0;
        private int cZU = 0;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (FrsFragment.this.eZf != null) {
                FrsFragment.this.eZf.biG();
            }
            this.faj = 0;
            this.cZU = 0;
            if (recyclerView != null && (recyclerView instanceof BdRecyclerView)) {
                this.faj = ((BdRecyclerView) recyclerView).getFirstVisiblePosition();
                this.cZU = ((BdRecyclerView) recyclerView).getLastVisiblePosition();
            }
            if (FrsFragment.this.eZr != null) {
                FrsFragment.this.eZr.a(recyclerView, this.faj, this.cZU);
            }
            if (FrsFragment.this.eYh != null && FrsFragment.this.eYE != null && FrsFragment.this.eYE.bdI() != null) {
                FrsFragment.this.eYE.bh(this.faj, this.cZU);
                if (FrsFragment.this.eYU != null && FrsFragment.this.eYU.rx() != null) {
                    FrsFragment.this.eYU.rx().b(FrsFragment.this.eYT);
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (FrsFragment.this.eYW != null) {
                FrsFragment.this.eYW.setScrollState(i);
            }
            if (i == 0) {
                FrsFragment.this.eYE.bdR();
            }
            if ((i == 2 || i == 1) && !FrsFragment.this.eYP) {
                FrsFragment.this.eYP = true;
                FrsFragment.this.eYE.bdL();
            }
            if (FrsFragment.this.eYQ == null && !FrsFragment.this.bcR()) {
                FrsFragment.this.eYQ = new com.baidu.tbadk.o.b();
                FrsFragment.this.eYQ.jW(1000);
            }
            if (i == 0) {
                if (FrsFragment.this.eYQ != null) {
                    FrsFragment.this.eYQ.aoX();
                }
                com.baidu.tieba.card.t.aQD().hQ(true);
                FrsFragment.this.iS(true);
                FrsFragment.this.eYE.bg(this.faj, this.cZU);
            } else if (FrsFragment.this.eYQ != null) {
                FrsFragment.this.eYQ.aoW();
            }
            if (FrsFragment.this.eZr != null) {
                FrsFragment.this.eZr.onScrollStateChanged(recyclerView, i);
            }
            if (i == 0) {
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.eYE, FrsFragment.this.eYh, FrsFragment.this.getForumId(), false, null);
            }
            if (FrsFragment.this.eYX != null && i == 1) {
                FrsFragment.this.eYX.bju();
            }
            if (FrsFragment.this.eYU == null) {
                if (FrsFragment.this.eYE.bdm() != null && !FrsFragment.this.eYE.bcQ() && FrsFragment.this.eYE.bdm().bTj() != null && (FrsFragment.this.eYE.bdm().bTj().getTag() instanceof com.baidu.card.z)) {
                    FrsFragment.this.eYU = (com.baidu.card.z) FrsFragment.this.eYE.bdm().bTj().getTag();
                }
            } else if (i == 0 && FrsFragment.this.eYE.bdm() != null && !FrsFragment.this.eYE.bcQ() && FrsFragment.this.eYE.bdm().bTj() != null && (FrsFragment.this.eYE.bdm().bTj().getTag() instanceof com.baidu.card.z)) {
                FrsFragment.this.eYU = (com.baidu.card.z) FrsFragment.this.eYE.bdm().bTj().getTag();
            }
        }
    };
    private final d eZZ = new d() { // from class: com.baidu.tieba.frs.FrsFragment.32
        @Override // com.baidu.tieba.frs.d
        public void a(int i, int i2, View view, View view2, bg bgVar) {
            if (i != FrsFragment.this.eYE.bdI().bfB()) {
                if (i != FrsFragment.this.eYE.bdI().bfC()) {
                    if (i == FrsFragment.this.eYE.bdI().bfz() && FrsFragment.this.eYh != null && FrsFragment.this.eYh.getUserData() != null && FrsFragment.this.eYh.getUserData().isBawu()) {
                        String bawuCenterUrl = FrsFragment.this.eYh.getBawuCenterUrl();
                        if (!com.baidu.tbadk.core.util.ap.isEmpty(bawuCenterUrl) && FrsFragment.this.eYh.getForum() != null) {
                            com.baidu.tbadk.browser.a.ar(FrsFragment.this.getPageContext().getPageActivity(), bawuCenterUrl);
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10502").bJ(ImageViewerConfig.FORUM_ID, FrsFragment.this.eYh.getForum().getId()).bJ("uid", FrsFragment.this.eYh.getUserData().getUserId()));
                        }
                    }
                } else if (bc.cZ(FrsFragment.this.getPageContext().getPageActivity())) {
                    TiebaStatic.log("my_service_ck");
                    if (FrsFragment.this.eYh != null && FrsFragment.this.eYh.getForum() != null) {
                        ForumData forum = FrsFragment.this.eYh.getForum();
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(forum.getId(), 0L), forum.getName(), forum.getImage_url(), 0)));
                    }
                }
            } else if (bc.cZ(FrsFragment.this.getActivity())) {
                TiebaStatic.log("forum_fortune_click");
                com.baidu.tieba.frs.f.i.b(FrsFragment.this.getPageContext(), FrsFragment.this.eYh);
            }
        }
    };
    private final NoNetworkView.a eWp = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.FrsFragment.33
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void dP(boolean z) {
            if (FrsFragment.this.eYV.bhI() == 1 && z && !FrsFragment.this.eYE.bcQ()) {
                if (FrsFragment.this.eYh == null || com.baidu.tbadk.core.util.v.T(FrsFragment.this.eYh.getThreadList())) {
                    FrsFragment.this.hideNetRefreshView(FrsFragment.this.eYE.bdJ());
                    FrsFragment.this.showLoadingView(FrsFragment.this.eYE.bdJ(), true);
                    FrsFragment.this.eYE.jd(false);
                    FrsFragment.this.refresh();
                    return;
                }
                FrsFragment.this.eYE.bdv();
            }
        }
    };
    private final CustomMessageListener bZe = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.FrsFragment.35
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                com.baidu.tieba.frs.f.c.a(customResponsedMessage, FrsFragment.this.eYE, FrsFragment.this.eYh);
            }
        }
    };
    private com.baidu.adp.widget.ListView.s faa = new a();
    private ai fab = new ai() { // from class: com.baidu.tieba.frs.FrsFragment.37
        @Override // com.baidu.tieba.frs.ai
        public void a(int i, int i2, ap apVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
            com.baidu.adp.lib.g.e.jH().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.37.1
                @Override // java.lang.Runnable
                public void run() {
                    if (FrsFragment.this.eYE != null && FrsFragment.this.eYE.aRB()) {
                        FrsFragment.this.aAZ();
                    }
                }
            });
        }
    };
    private CustomMessageListener fac = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.frs.FrsFragment.38
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    FrsFragment.this.eZs = true;
                }
            }
        }
    };
    private CustomMessageListener fad = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.frs.FrsFragment.39
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && FrsFragment.this.eYU != null && FrsFragment.this.eYU.rx() != null) {
                    FrsFragment.this.eYU.rx().b(new a.C0039a(3));
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.frs.loadmore.a
    public /* bridge */ /* synthetic */ com.baidu.adp.base.e getPageContext() {
        return super.getPageContext();
    }

    public com.baidu.tieba.frs.entelechy.b.b bcj() {
        return this.eZd;
    }

    public com.baidu.adp.widget.ListView.s bck() {
        return this.faa;
    }

    public com.baidu.tieba.frs.mc.d bcl() {
        return this.eZg;
    }

    public com.baidu.tieba.frs.smartsort.b bcm() {
        return this.eYZ;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public FrsModelController bcn() {
        return this.eYV;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public com.baidu.tieba.frs.mc.c bco() {
        return this.eZh;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public com.baidu.tieba.frs.vc.f bcp() {
        return this.eYW;
    }

    public FrsTabViewController bcq() {
        return this.eYX;
    }

    public ak bcr() {
        return this.eZb;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public k bcs() {
        return this.eYE;
    }

    @Override // com.baidu.tieba.frs.aj
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.aj, com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.eYw;
    }

    public void setForumName(String str) {
        this.eYw = str;
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
        if (this.eZh == null) {
            return 1;
        }
        return this.eZh.getPn();
    }

    public int getPn() {
        if (this.eZh == null) {
            return 1;
        }
        return this.eZh.getPn();
    }

    public void setPn(int i) {
        if (this.eZh != null) {
            this.eZh.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.eZh != null) {
            this.eZh.setHasMore(i);
        }
    }

    public int bct() {
        if (this.eZh == null) {
            return -1;
        }
        return this.eZh.bct();
    }

    public boolean bcu() {
        return this.eYC;
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
            String string = TbadkCoreApplication.getInst().getString(d.j.error_unkown_try_again);
            this.eYE.bdp();
            showNetRefreshView(this.eYE.bdJ(), string, true);
        } else if (340001 == bVar.errorCode) {
            a(bVar, this.eYh.getRecm_forum_list());
        } else {
            if (com.baidu.tbadk.core.util.v.T(this.eYh.getThreadList())) {
                b(bVar);
            }
            if (bcR()) {
                setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst(), d.e.ds280));
            } else {
                setNetRefreshViewEmotionDefMarginTop();
            }
        }
    }

    public void a(View view, String str, boolean z, List<RecmForumInfo> list) {
        this.eYE.bdp();
        this.eYE.pY(8);
        if (this.eZp == null) {
            this.eZp = new com.baidu.tieba.frs.view.a(getPageContext(), getNetRefreshListener());
        }
        this.eZp.pp(str);
        this.eZp.cg(list);
        this.eZp.attachView(view, z);
    }

    private void a(e.b bVar, List<RecmForumInfo> list) {
        if (this.eYE != null) {
            this.eYE.bdp();
            this.eYE.setTitle(this.eYw);
            a(this.eYE.bdJ(), bVar.errorMsg, true, list);
        }
    }

    private void b(e.b bVar) {
        this.eYE.bdp();
        if (bVar.iDA) {
            showNetRefreshView(this.eYE.bdJ(), TbadkCoreApplication.getInst().getString(d.j.net_error_text, new Object[]{bVar.errorMsg, Integer.valueOf(bVar.errorCode)}), true);
        } else {
            showNetRefreshView(this.eYE.bdJ(), bVar.errorMsg, true);
        }
    }

    public void bcv() {
        hideLoadingView(this.eYE.bdJ());
        this.eYE.jf(false);
        if (this.eYE.bdn() instanceof com.baidu.tieba.frs.tab.c) {
            ((com.baidu.tieba.frs.tab.c) this.eYE.bdn()).bin();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcw() {
        if (bct() == 0 && com.baidu.tbadk.core.util.v.T(this.eYh.getThreadListIds())) {
            if (com.baidu.tbadk.core.util.v.T(this.eYh.getThreadList())) {
                this.eYE.aCt();
            } else {
                this.eYE.aCs();
            }
        } else if (com.baidu.tbadk.core.util.v.S(this.eYh.getThreadList()) > 3) {
            this.eYE.aCr();
        } else {
            this.eYE.bdM();
        }
    }

    public void a(ErrorData errorData) {
        bcv();
        this.eYE.bdv();
        e.b bhF = this.eYV.bhF();
        boolean T = com.baidu.tbadk.core.util.v.T(this.eYh.getThreadList());
        if (bhF != null && T) {
            if (this.eYV.bhG() != 0) {
                this.eYV.bhL();
                this.eYE.bdv();
            } else {
                a(bhF);
            }
            this.eYE.D(this.eYh.isStarForum(), false);
            return;
        }
        a(bhF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcx() {
        boolean b;
        if (!bcz()) {
            final PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
            privateForumPopInfoData.a(this.eYh.getPrivateForumTotalInfo().getPrivatePopInfo());
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(getActivity());
            if (this.eYh.getPrivateForumTotalInfo().XP().private_forum_status.intValue() == 1 && (com.baidu.tbadk.core.util.ap.isEmpty(privateForumPopInfoData.XR()) || privateForumPopInfoData.XU() != Integer.valueOf(this.forumId))) {
                privateForumPopInfoData.lc("create_success");
                privateForumPopInfoData.ld(TbadkCoreApplication.getInst().getString(d.j.frs_private_create_hint));
                privateForumPopInfoData.le("https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.eYw + "&nomenu=1");
                privateForumPopInfoData.b(Integer.valueOf(this.forumId));
                b = frsPrivateCommonDialogView.b(privateForumPopInfoData);
            } else {
                b = privateForumPopInfoData.XU() == Integer.valueOf(this.forumId) ? frsPrivateCommonDialogView.b(privateForumPopInfoData) : false;
            }
            if (b) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
                aVar.gE(2);
                aVar.az(frsPrivateCommonDialogView);
                aVar.dr(false);
                frsPrivateCommonDialogView.setConfirmButton(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.15
                    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.frs.FrsFragment */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ba.adA().c(FrsFragment.this.getPageContext(), new String[]{privateForumPopInfoData.XT()});
                        aVar.dismiss();
                    }
                });
                aVar.a(new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.16
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(getPageContext()).aaW();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcy() {
        if (bcz() || this.eYh.getPrivateForumTotalInfo().XP().private_forum_status.intValue() != 1) {
            a((Integer) null, (Integer) null, true);
        } else {
            a(this.eYh.getPrivateForumTotalInfo().XP().private_forum_audit_status, this.eYh.getPrivateForumTotalInfo().XQ(), false);
        }
    }

    public void a(Integer num, Integer num2, boolean z) {
        final String str;
        final int i = 2;
        if (this.eYE.bdB() != null) {
            TextView bdB = this.eYE.bdB();
            if (z) {
                bdB.setVisibility(8);
                return;
            }
            if (num.intValue() == 2) {
                bdB.setText("修改实名认证信息");
                bdB.setVisibility(0);
                str = "https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + this.forumId + "&nomenu=1";
            } else if (num2.intValue() >= 0 && num2.intValue() <= 100) {
                bdB.setText("目标已完成" + String.valueOf(num2) + "%");
                bdB.setVisibility(0);
                str = "https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.eYw + "&nomenu=1";
                i = 1;
            } else {
                bdB.setVisibility(8);
                i = 0;
                str = "";
            }
            bdB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.17
                /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13387").bJ(ImageViewerConfig.FORUM_ID, FrsFragment.this.forumId).bJ("uid", TbadkCoreApplication.getCurrentAccount()).T("obj_type", i));
                    ba.adA().c(FrsFragment.this.getPageContext(), new String[]{str});
                }
            });
        }
    }

    private boolean bcz() {
        return this.eYh == null || !this.eYh.isPrivateForum() || this.eYh.getPrivateForumTotalInfo() == null || this.eYh.getPrivateForumTotalInfo().XP() == null || this.eYh.getUserData().getIs_manager() != 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pQ(int i) {
        List<WindowToast> list;
        if (TbadkCoreApplication.isLogin() && this.eYh != null && (list = this.eYh.mWindowToast) != null && list.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < list.size()) {
                    WindowToast windowToast = list.get(i3);
                    if (windowToast == null || windowToast.toast_type.intValue() != i) {
                        i2 = i3 + 1;
                    } else if (!com.baidu.tbadk.core.util.ap.isEmpty(windowToast.toast_link)) {
                        sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(getPageContext().getPageActivity(), "", com.baidu.tbadk.util.ae.pS(windowToast.toast_link), true)));
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
    public void bcA() {
        if (this.eYh == null || this.eYh.getForum() != null) {
            this.eYE.bdH();
        } else if (this.eYh.getForum().getYuleData() != null && this.eYh.getForum().getYuleData().aaP()) {
            TiebaStatic.log("c10852");
            this.eYE.a(this.eYh.getForum().getYuleData().aaQ());
        } else {
            this.eYE.bdH();
        }
    }

    private void B(boolean z, boolean z2) {
        if (this.eYV != null && this.eYh != null && this.eYE != null && z) {
            if (!this.eYV.bhR() && this.eYV.bhI() == 1) {
                if (!this.eYV.bhP()) {
                    this.eYh.addCardVideoInfoToThreadList();
                    this.eYh.addVideoInfoToThreadListInTenAndFifteenFloor();
                }
                boolean z3 = false;
                if (this.eYE.bdI().l(com.baidu.tieba.card.data.n.elE)) {
                    z3 = this.eYh.addHotTopicDataToThreadList();
                }
                if (!z3) {
                    this.eYh.addFeedForumDataToThreadList();
                }
                if (TbadkCoreApplication.getInst().isRecAppExist()) {
                    this.eYh.addRecommendAppToThreadList(this);
                }
                if (!this.eYE.bdI().l(bg.bBh)) {
                    this.eYh.removeAlaLiveThreadData();
                }
                this.eYh.addSchoolRecommendToThreadList();
            }
            if (!this.eYE.bdI().l(bg.bBh)) {
                this.eYh.removeAlaInsertLiveData();
                this.eYh.removeAlaStageLiveDat();
            } else {
                this.eYh.addInsertLiveDataToThreadList();
                this.eYh.addStageLiveDataToThreadList();
            }
            this.eYh.updateInterviewTaskInfoDataInThreadList();
            this.eYh.addNoticeThreadToThreadList();
            if (this.eYE.bdI().l(com.baidu.tieba.h.b.fAw)) {
                this.eYh.addGameRankListToThreadList(z2);
            }
            if (TbadkCoreApplication.isLogin() && (!this.eYV.bhR() || this.eYV.isNetFirstLoad)) {
                this.eYh.addUserRecommendToThreadList();
            }
            this.eYh.addVideoActivityToTop();
        }
    }

    public boolean bcB() {
        if (this.eYW != null && this.eYV != null) {
            this.eYW.a(this.eYV.getPageType(), this.eYh);
        }
        boolean z = false;
        if (this.eYh != null) {
            z = this.eYh.hasTab();
        }
        bcD();
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pR(int i) {
        am amVar = null;
        bcB();
        bcK();
        try {
            if (this.eYh != null) {
                this.eYE.a((ArrayList<com.baidu.adp.widget.ListView.m>) null, this.eYh);
                this.eYW.rs(1);
                this.eYE.bdy();
                this.eYX.a(this.eYh, this.eYV.bhN());
                com.baidu.tieba.frs.tab.d rz = this.eYX.rz(this.eYh.getFrsDefaultTabId());
                if (rz != null && !TextUtils.isEmpty(rz.url)) {
                    amVar = new am();
                    amVar.fcN = rz.url;
                    amVar.stType = rz.name;
                }
                this.eYV.a(this.eYh.getFrsDefaultTabId(), 0, amVar);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(boolean z, boolean z2) {
        try {
            if (this.eYh != null && this.eYX != null && this.eYV != null) {
                if (!this.eYE.bdI().l(bg.bBh)) {
                    this.eYh.removeAlaLiveThreadData();
                }
                boolean T = com.baidu.tbadk.core.util.v.T(this.eYh.getGameTabInfo());
                this.eYE.jb(T);
                if (!T) {
                    if (this.eZr == null) {
                        this.eZr = new com.baidu.tieba.frs.vc.e(this, (NoPressedRelativeLayout) this.mRootView);
                    }
                    if (this.doq == null) {
                        this.doq = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
                    }
                } else {
                    this.eZr = null;
                    this.doq = null;
                }
                if (this.eYh.getForum() != null) {
                    this.eYw = this.eYh.getForum().getName();
                    this.forumId = this.eYh.getForum().getId();
                }
                if (this.eYh.hasTab()) {
                    this.eYX.a(this.eYh, this.eYV.bhN());
                }
                if (z) {
                    B(true, z);
                } else {
                    B(this.eYR, z);
                }
                bcB();
                if (this.eZd != null) {
                    this.eZd.a(this.eYW, this.eYh);
                }
                if (this.eYh.getPage() != null) {
                    setHasMore(this.eYh.getPage().XH());
                }
                ArrayList<com.baidu.adp.widget.ListView.m> a2 = this.eZh.a(z2, true, this.eYh.getThreadList(), null, z, false);
                if (a2 != null) {
                    this.eYh.setThreadList(a2);
                }
                this.eYh.removeRedundantUserRecommendData();
                this.eYj = this.eYh.getTopThreadSize();
                if (this.eYA != null) {
                    this.eYz = true;
                    this.eYA.zm(this.eYj);
                    com.baidu.tieba.frs.f.a.a(this, this.eYh.getForum(), this.eYh.getThreadList(), this.eYz, getPn());
                }
                if (this.eYV.bhI() == 1) {
                    bcH();
                    if (!z && this.eYV.getPn() == 1) {
                        bcC();
                    }
                }
                if (this.eZf != null) {
                    this.eZf.bN(this.eYX.bjr());
                }
                bcv();
                this.eYE.bdq();
                this.eYE.D(true, false);
                if (z && this.eYh.isFirstTabEqualAllThread()) {
                    com.baidu.adp.lib.g.e.jH().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.18
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!FrsFragment.this.eYO) {
                                FrsFragment.this.eYE.bdS();
                            }
                        }
                    });
                }
                if (this.eYh.getForum() != null) {
                    this.eYE.uX(this.eYh.getForum().getWarningMsg());
                }
                if (this.eYh != null && this.eYh.getFrsVideoActivityData() != null && com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("frs_video_activity_guide", 0L) == 0) {
                    com.baidu.adp.lib.g.e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.19
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsFragment.this.eYE.bdP();
                        }
                    }, 1000L);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2921326, this));
                this.eYE.bdk();
                if (this.eYh != null && this.eYh.getForum() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016564, new VisitedForumData(this.eYh.getForum().getId(), this.eYh.getForum().getName(), this.eYh.getForum().getImage_url(), String.valueOf(System.currentTimeMillis() / 1000), "showlive".equals(this.eYh.getForum().special_forum_type), this.eYh.getForum().getThemeColorInfo(), this.eYh.getForum().getMember_num())));
                }
                this.eZw.a(this.eYh.bottomMenuList, this.eYh.getForum());
                bcX();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void iS(boolean z) {
        com.baidu.tieba.q.c.cdp().b(getUniqueId(), z);
    }

    public void bcC() {
        if (this.eZk == null) {
            this.eZk = new com.baidu.tieba.frs.live.a(this, com.baidu.adp.lib.g.b.l(this.forumId, 0));
        }
        this.eZk.bhr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.j jVar) {
        try {
            if (!this.eYO && jVar != null && this.eYh != null) {
                this.eYh.receiveData(jVar);
                C(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void bcD() {
        if (this.eYV != null) {
            uV(this.eYV.getPageType());
        } else {
            uV("normal_page");
        }
    }

    private void uV(String str) {
        iT("frs_page".equals(str));
        if (this.eZd != null) {
            this.eZd.a(this.eYW, this.eYE, this.eYh);
        }
    }

    public void iT(boolean z) {
        if (this.eZi != null) {
            this.eZi.bjl();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.q.c.cdp().s(getUniqueId());
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(d.h.frs_activity, viewGroup, false);
            this.eYq = new com.baidu.tieba.frs.entelechy.a();
            this.eZd = this.eYq.bfg();
            this.eYW = new com.baidu.tieba.frs.vc.f(this, this.eYq, (FrsHeaderViewContainer) this.mRootView.findViewById(d.g.header_view_container));
            this.eYX = new FrsTabViewController(this, this.mRootView);
            this.eYX.registerListener();
            this.eYW.a(this.eYX);
            this.eYX.a(this.eZI);
            Intent intent = getActivity().getIntent();
            if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                this.eYs = true;
            }
            this.eYE = new k(this, this.eZY, this.eYq, this.eYs, this.eYW);
            this.eZw = new com.baidu.tieba.frs.brand.buttommenu.a(getPageContext(), this.mRootView);
        } else {
            if (this.mRootView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            if (this.eYX != null) {
                this.eYX.registerListener();
            }
            this.eYE.bdO();
        }
        this.eZz = true;
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        ArrayList<com.baidu.adp.widget.ListView.m> arrayList = null;
        this.eCw = System.currentTimeMillis();
        this.beginTime = this.eCw;
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.eYB = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.eCw = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            ac(intent);
        }
        this.cqp = this.beginTime - this.eCw;
        this.eYA = new com.baidu.tieba.tbadkCore.data.f("frs", com.baidu.tieba.tbadkCore.data.f.iFk);
        if (this.eYV == null) {
            this.eYV = new FrsModelController(this, this.eZU);
            this.eYV.a(this.eZH);
            this.eYV.init();
        }
        if (intent != null) {
            this.eYV.J(intent.getExtras());
        } else if (bundle != null) {
            this.eYV.J(bundle);
        } else {
            this.eYV.J(null);
        }
        if (intent != null) {
            this.eYW.Q(intent.getExtras());
        } else if (bundle != null) {
            this.eYW.Q(bundle);
        } else {
            this.eYW.Q(null);
        }
        this.eYD = getVoiceManager();
        this.eZl = new j(getPageContext(), this);
        initUI();
        initData(bundle);
        if (!bcR()) {
            this.eZb = new ak(getActivity(), this.eYE, this.eYW);
            this.eZb.js(true);
        }
        this.eYD = getVoiceManager();
        if (this.eYD != null) {
            this.eYD.onCreate(getPageContext());
        }
        new com.baidu.tieba.frs.mc.i();
        int i = -1;
        if (this.eZh != null && this.eZh.bhC() != null) {
            i = this.eZh.bhC().bct();
            arrayList = this.eZh.bhC().getDataList();
        }
        this.eZh = new com.baidu.tieba.frs.mc.c(this, this.eZW);
        this.eZh.bhC().setHasMore(i);
        if (arrayList != null && arrayList.size() > 0) {
            this.eZh.bhC().Z(arrayList);
        }
        this.eYZ = new com.baidu.tieba.frs.smartsort.b(this);
        this.eZi = new com.baidu.tieba.frs.vc.h(this);
        this.eZf = new com.baidu.tieba.frs.vc.a(getPageContext(), this.eYV.bhO());
        this.eZa = new com.baidu.tieba.frs.mc.b(this);
        this.eZg = new com.baidu.tieba.frs.mc.d(this);
        this.eYY = new com.baidu.tieba.frs.mc.h(this);
        this.eZj = new com.baidu.tieba.frs.mc.a(this);
        this.eZm = new com.baidu.tieba.frs.vc.c(this);
        this.eZn = new com.baidu.tieba.frs.mc.e(this, getUniqueId());
        this.eZu = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "frs");
        this.eZv = new com.baidu.tieba.ala.a(getPageContext());
        registerListener(this.ddr);
        registerListener(this.mMemListener);
        registerListener(this.eZO);
        registerListener(this.eZX);
        registerListener(this.eZN);
        registerListener(this.eZV);
        registerListener(this.eZK);
        registerListener(this.eZL);
        registerListener(this.eZM);
        registerListener(this.eZE);
        registerListener(this.eZF);
        registerListener(this.XW);
        registerListener(this.fac);
        registerListener(this.eZR);
        registerListener(this.eZG);
        registerListener(this.eZS);
        registerListener(this.eZQ);
        this.eZD.setTag(getPageContext().getUniqueId());
        registerListener(this.eZD);
        registerListener(this.brs);
        registerListener(this.eZT);
        this.fad.setTag(getPageContext().getUniqueId());
        MessageManager.getInstance().registerListener(this.fad);
        this.eYE.jd(false);
        if (!bcR() && !this.hasInit) {
            showLoadingView(this.eYE.bdJ(), true);
            this.eYV.y(3, false);
        }
        com.baidu.tieba.frs.a.bbD().a(new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.22
            @Override // com.baidu.tieba.frs.a.b
            public void A(boolean z, boolean z2) {
                if (FrsFragment.this.eYE != null) {
                    FrsFragment.this.eYE.pZ(z ? 0 : 8);
                    if (!z2) {
                        FrsFragment.this.eZy = z;
                    }
                    if (FrsFragment.this.eYE.bdI() != null && FrsFragment.this.eYV != null && FrsFragment.this.eYV.bhJ()) {
                        FrsFragment.this.eYE.bdI().notifyDataSetChanged();
                    }
                    if (FrsFragment.this.bcq() != null) {
                        FrsTabViewController.b bjs = FrsFragment.this.bcq().bjs();
                        if (bjs != null && bjs.tabId == 502 && (bjs.fragment instanceof FrsCommonTabFragment)) {
                            ((FrsCommonTabFragment) bjs.fragment).bfe();
                        } else if (bjs != null && bjs.tabId == 503 && (bjs.fragment instanceof FrsNewAreaFragment)) {
                            FrsNewAreaFragment frsNewAreaFragment = (FrsNewAreaFragment) bjs.fragment;
                            frsNewAreaFragment.bfe();
                            if (frsNewAreaFragment.bhU() != null) {
                                com.baidu.tieba.frs.mc.g bhU = frsNewAreaFragment.bhU();
                                bhU.jg(!z);
                                bhU.jh(!z);
                            }
                        }
                        if (FrsFragment.this.bcq().bjm() != null) {
                            FrsFragment.this.bcq().bjm().setmDisallowSlip(z);
                            FrsFragment.this.bcq().jR(z);
                        }
                    }
                    if (FrsFragment.this.eYE.bdo() != null) {
                        FrsFragment.this.eYE.ja(!z);
                    }
                    if (FrsFragment.this.getActivity() instanceof FrsActivity) {
                        ((FrsActivity) FrsFragment.this.getActivity()).iR(!z);
                    }
                    if (FrsFragment.this.eZw != null) {
                        FrsFragment.this.eZw.jA(!z);
                    }
                    FrsFragment.this.eYE.jg(!z);
                    FrsFragment.this.eYE.jh(z ? false : true);
                }
            }

            @Override // com.baidu.tieba.frs.a.b
            public void pN(int i2) {
                if (FrsFragment.this.eYE != null) {
                    FrsFragment.this.eYE.qa(i2);
                }
            }

            @Override // com.baidu.tieba.frs.a.b
            public void bbJ() {
                com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getContext(), d.j.frs_multi_delete_max_num);
            }
        });
        this.eYE.b(new d.a() { // from class: com.baidu.tieba.frs.FrsFragment.24
            @Override // com.baidu.tieba.NEGFeedBack.d.a
            public void a(DeleteThreadHttpResponseMessage deleteThreadHttpResponseMessage) {
                boolean z;
                int i2 = 0;
                if (deleteThreadHttpResponseMessage != null) {
                    FrsFragment.this.eYE.auR();
                    FrsFragment.this.eYE.bdQ();
                    FrsNewAreaFragment frsNewAreaFragment = null;
                    if (FrsFragment.this.eYX == null || FrsFragment.this.eYX.bjs() == null || !(FrsFragment.this.eYX.bjs().fragment instanceof FrsNewAreaFragment)) {
                        z = false;
                    } else {
                        frsNewAreaFragment = (FrsNewAreaFragment) FrsFragment.this.eYX.bjs().fragment;
                        z = true;
                    }
                    if (deleteThreadHttpResponseMessage.getError() == 0) {
                        String text = !TextUtils.isEmpty(deleteThreadHttpResponseMessage.getText()) ? deleteThreadHttpResponseMessage.getText() : FrsFragment.this.getString(d.j.delete_fail);
                        if (deleteThreadHttpResponseMessage.getRetType() == 1211066) {
                            if (FrsFragment.this.eka == null) {
                                FrsFragment.this.eka = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.eka.lz(text);
                            FrsFragment.this.eka.a(d.j.dialog_known, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.24.1
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.eka.dr(false);
                            FrsFragment.this.eka.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.eka.aaW();
                        } else if (deleteThreadHttpResponseMessage.getRetType() == 1211067) {
                            if (FrsFragment.this.eka == null) {
                                FrsFragment.this.eka = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.eka.lz(text);
                            FrsFragment.this.eka.a(d.j.know, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.24.2
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.eka.dr(false);
                            FrsFragment.this.eka.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.eka.aaW();
                        } else {
                            FrsFragment.this.eYE.ax(deleteThreadHttpResponseMessage.getText(), ContextCompat.getColor(FrsFragment.this.getContext(), deleteThreadHttpResponseMessage.getRetType() == 1 ? d.C0277d.nav_bar_tip_error : d.C0277d.cp_link_tip_a_alpha95));
                        }
                        if (z && frsNewAreaFragment != null) {
                            frsNewAreaFragment.cb(deleteThreadHttpResponseMessage.getSuccessItems());
                        }
                        FrsFragment.this.bP(deleteThreadHttpResponseMessage.getSuccessItems());
                        com.baidu.tieba.frs.a.bbD().bO(deleteThreadHttpResponseMessage.getSuccessItems());
                        for (com.baidu.adp.widget.ListView.m mVar : FrsFragment.this.eYh.getThreadList()) {
                            if (mVar instanceof bf) {
                                i2++;
                                continue;
                            }
                            if (i2 >= 6) {
                                break;
                            }
                        }
                        if (i2 < 6) {
                            FrsFragment.this.aAZ();
                            return;
                        }
                        return;
                    }
                    com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getActivity(), deleteThreadHttpResponseMessage.getErrorString());
                }
            }
        });
        this.hasInit = true;
        super.onActivityCreated(bundle);
        this.createTime = System.currentTimeMillis() - this.beginTime;
    }

    public void iU(boolean z) {
        if (this.eYX != null) {
            this.eYX.fwg = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bP(List<String> list) {
        if (!com.baidu.tbadk.core.util.v.T(list)) {
            ArrayList<com.baidu.adp.widget.ListView.m> threadList = this.eYh.getThreadList();
            if (!com.baidu.tbadk.core.util.v.T(threadList) && this.eYE.getListView() != null && this.eYE.getListView().getData() != null) {
                Iterator<com.baidu.adp.widget.ListView.m> it = threadList.iterator();
                List<com.baidu.adp.widget.ListView.m> data = this.eYE.getListView().getData();
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.m next = it.next();
                    if (next instanceof bf) {
                        bg bgVar = ((bf) next).threadData;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= list.size()) {
                                break;
                            } else if (!com.baidu.tbadk.core.util.ap.equals(list.get(i2), bgVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.eZh.e(next);
                                this.eYE.getListView().getAdapter().notifyItemRemoved(i);
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
    public void aBs() {
        if (isAdded() && this.ddg && !isLoadingViewAttached()) {
            showLoadingView(this.eYE.bdJ(), true);
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void aBt() {
        if (isAdded() && this.ddg && isLoadingViewAttached()) {
            hideLoadingView(this.eYE.bdJ());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (bcR()) {
            showLoadingView(this.eYE.bdJ(), true);
            this.eYE.qb(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.eYV.y(3, true);
            aeZ().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void setHeaderViewHeight(int i) {
    }

    @Override // com.baidu.tieba.frs.ae
    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.x xVar) {
        if (xVar != null) {
            this.ctI = xVar.aqi();
            this.eZo = xVar.aqj();
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void showFloatingView() {
        if (this.ctI != null) {
            this.ctI.fl(true);
        }
    }

    private void ac(Intent intent) {
        if (intent != null) {
            if (intent != null) {
                if (!com.baidu.tieba.frs.f.f.a(this, getForumName(), "from", intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false)) && getActivity() != null) {
                    getActivity().finish();
                    return;
                }
            }
            if (intent != null && intent.getData() != null) {
                Uri data = intent.getData();
                this.eYw = data.getQueryParameter("name");
                this.mFrom = data.getQueryParameter("from");
                if (!StringUtils.isNull(this.eYw)) {
                    intent.putExtra("name", this.eYw);
                }
                if (!StringUtils.isNull(this.mFrom)) {
                    intent.putExtra("from", this.mFrom);
                }
                TiebaStatic.log("c10105");
            }
            if (StringUtils.isNull(this.eYw) && intent != null && intent.getData() != null) {
                Uri data2 = intent.getData();
                if (com.baidu.tbadk.BdToken.f.m(data2)) {
                    com.baidu.tbadk.BdToken.f.Ui().b(data2, new f.a() { // from class: com.baidu.tieba.frs.FrsFragment.25
                        @Override // com.baidu.tbadk.BdToken.f.a
                        public void o(HashMap<String, Object> hashMap) {
                            if (hashMap != null && (hashMap.get(com.baidu.tbadk.BdToken.f.brL) instanceof String)) {
                                FrsFragment.this.eYw = (String) hashMap.get(com.baidu.tbadk.BdToken.f.brL);
                            }
                        }
                    });
                } else {
                    com.baidu.tieba.frs.f.d af = com.baidu.tieba.frs.f.i.af(intent);
                    if (af != null) {
                        this.eYw = af.forumName;
                        if (af.fuC == null || af.fuC.equals("aidou")) {
                        }
                    }
                }
                if (!StringUtils.isNull(this.eYw)) {
                    intent.putExtra("name", this.eYw);
                }
                intent.putExtra(FrsActivityConfig.FRS_CALL_FROM, 12);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.eYD = getVoiceManager();
        if (this.eYD != null) {
            this.eYD.onStart(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        Intent intent;
        registerListener(2001118, this.bZe);
        if (bundle != null) {
            this.eYw = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
            this.eYw = intent.getStringExtra("name");
            this.mFrom = intent.getStringExtra("from");
            this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
        }
        if (getArguments() != null) {
            this.eYx = getArguments().getBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, false);
        }
        if (TextUtils.isEmpty(this.mFrom) || FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
        }
        if (this.mIsLogin) {
            registerListener(2001120, this.bZe);
        }
        this.eYW.Q(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.q.c.cdp().t(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.fac);
        eYI = null;
        if (this.eYD != null) {
            this.eYD.onDestory(getPageContext());
        }
        com.baidu.tieba.recapp.report.a.remove("FRS");
        this.eYD = null;
        com.baidu.tieba.card.t.aQD().hQ(false);
        if (this.eYh != null && this.eYh.getForum() != null) {
            aa.ben().cF(com.baidu.adp.lib.g.b.d(this.eYh.getForum().getId(), 0L));
        }
        if (this.eZk != null) {
            this.eZk.onDestory();
        }
        if (this.eYE != null) {
            com.baidu.tieba.frs.f.h.a(this.eYE, this.eYh, getForumId(), false, null);
            this.eYE.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.eYQ != null) {
                this.eYQ.aoY();
            }
            this.eYE.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.eYW.onActivityDestroy();
        if (this.eYV != null) {
            this.eYV.aDC();
        }
        if (this.eZb != null) {
            this.eZb.aqh();
        }
        if (this.eZe != null) {
            this.eZe.destory();
        }
        if (this.eZf != null) {
            this.eZf.destory();
        }
        if (this.eYZ != null) {
            this.eYZ.onDestroy();
        }
        if (this.eZr != null) {
            this.eZr.onDestory();
        }
        if (this.eZj != null) {
            this.eZj.onDestroy();
        }
        if (this.eZu != null) {
            this.eZu.onDestroy();
        }
        if (this.eZv != null) {
            this.eZv.onDestroy();
        }
        com.baidu.tieba.recapp.d.a.bXv().bXx();
        com.baidu.tieba.frs.f.j.biD();
        if (this.eYX != null) {
            this.eYX.a((FrsTabViewController.a) null);
            this.eYX.bju();
        }
        if (this.eZx != null) {
            this.eZx.onDestroy();
        }
        com.baidu.tieba.frs.a.bbD().a(null);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.eYw);
        bundle.putString("from", this.mFrom);
        this.eYV.onSaveInstanceState(bundle);
        if (this.eYD != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            this.eYD.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.eZj != null) {
            this.eZj.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.eYE != null) {
            this.eYE.bdv();
            this.eYE.onResume();
        }
        this.eYY.jN(true);
        this.eYR = true;
        if (eYv) {
            eYv = false;
            this.eYE.startPullRefresh();
            return;
        }
        if (this.eYD != null) {
            this.eYD.onResume(getPageContext());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921338));
        this.eYE.ji(false);
        if (this.eZs) {
            refresh(6);
            this.eZs = false;
        }
        bcX();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
    }

    public boolean bcE() {
        Intent intent;
        if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
            return false;
        }
        return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
    }

    public void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.eYw = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.eYy = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.eYy) {
                bcF();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcF() {
        this.eYE.startPullRefresh();
    }

    public void closeActivity() {
        com.baidu.tieba.frs.f.i.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.mFrom);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.eYE.setTitle(this.eYw);
        } else {
            this.eYE.setTitle("");
            this.mFlag = 1;
        }
        this.eYE.setOnAdapterItemClickListener(this.faa);
        this.eYE.addOnScrollListener(this.mScrollListener);
        this.eYE.h(this.eWp);
        this.eYE.bdI().a(this.eZZ);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.eZz) {
            this.eYE.onChangeSkinType(i);
            this.eYW.rr(i);
            this.eYX.onChangeSkinType(i);
            if (this.eYG != null) {
                this.eYG.onChangeSkinType(i);
            }
            if (this.eZp != null) {
                this.eZp.onChangeSkinType();
            }
            if (this.eZw != null) {
                this.eZw.onChangeSkinType(getPageContext(), i);
            }
            if (this.eka != null) {
                com.baidu.tbadk.r.a.a(getPageContext(), this.eka.aaX());
            }
            if (this.eZq != null) {
                this.eZq.onChangeSkinType();
            }
        }
    }

    public void pS(int i) {
        if (!this.mIsLogin) {
            if (this.eYh != null && this.eYh.getAnti() != null) {
                this.eYh.getAnti().setIfpost(1);
            }
            if (i == 0) {
                bc.cY(getActivity());
            }
        } else if (this.eYh != null) {
            if (i == 0) {
                com.baidu.tieba.frs.f.j.d(this, 0);
            } else {
                this.eYE.bdx();
            }
        }
    }

    public void refresh() {
        com.baidu.tieba.a.d.awh().qL("page_frs");
        refresh(3);
    }

    public void refresh(int i) {
        this.eYO = false;
        bcK();
        if (this.eYE.bdm() != null) {
            this.eYE.bdm().bol();
        }
        this.eYV.y(i, true);
    }

    private void bcG() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.g.h.jI().d(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.29
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.CG(FrsFragment.this.eYw);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcH() {
        bcK();
        try {
            if (this.eYh != null) {
                this.eYE.aOs();
                this.eYE.ja(bcW());
                if (!com.baidu.tieba.frs.vc.f.k(this.eYh) || !com.baidu.tieba.frs.vc.f.j(this.eYh)) {
                }
                if (this.eYh.getForum() != null) {
                    this.eYw = this.eYh.getForum().getName();
                    this.forumId = this.eYh.getForum().getId();
                }
                if (this.eYh.getPage() != null) {
                    setHasMore(this.eYh.getPage().XH());
                }
                this.eYE.setTitle(this.eYw);
                this.eYE.setForumName(this.eYw);
                TbadkCoreApplication.getInst().setDefaultBubble(this.eYh.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.eYh.getUserData().getBimg_end_time());
                bcG();
                bcI();
                ArrayList<com.baidu.adp.widget.ListView.m> threadList = this.eYh.getThreadList();
                if (threadList != null) {
                    this.eYE.a(threadList, this.eYh);
                    com.baidu.tieba.frs.f.c.w(this.eYE);
                    this.eYW.rs(getPageNum());
                    this.eYW.h(this.eYh);
                    this.eYX.a(this.eYh, this.eYV.bhN());
                    this.eYE.bdy();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void bcI() {
        if (this.eYh != null) {
            if (this.eYh.getIsNewUrl() == 1) {
                this.eYE.bdI().setFromCDN(true);
            } else {
                this.eYE.bdI().setFromCDN(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.eYY.jN(false);
        this.eYR = false;
        this.eYE.onPause();
        if (this.eYD != null) {
            this.eYD.onPause(getPageContext());
        }
        this.eYE.ji(true);
        if (this.eZf != null) {
            this.eZf.biG();
        }
        com.baidu.tbadk.BdToken.c.TX().TY();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.eYX != null && this.eYX.bjs() != null && (this.eYX.bjs().fragment instanceof BaseFragment)) {
            ((BaseFragment) this.eYX.bjs().fragment).setPrimary(z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.t.aQD().hQ(false);
        iS(false);
        if (this.eYh != null && this.eYh.getForum() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            com.baidu.tbadk.distribute.a.alC().a(getPageContext().getPageActivity(), "frs", this.eYh.getForum().getId(), 0L);
        }
        if (this.eYD != null) {
            this.eYD.onStop(getPageContext());
        }
        if (aeZ() != null) {
            aeZ().getRecycledViewPool().clear();
        }
        this.eYW.onActivityStop();
        com.baidu.tbadk.util.y.aql();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            if (this.eYW != null) {
                this.eYW.iY(isPrimary());
            }
            if (this.eYE != null) {
                this.eYE.iY(isPrimary());
                this.eYE.ji(!isPrimary());
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (com.baidu.tieba.frs.a.bbD().bbE()) {
                com.baidu.tieba.frs.a.bbD().reset();
                return true;
            } else if (this.eYE != null) {
                return this.eYE.bdu();
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.n
    public TbPageContext<?> getTbPageContext() {
        return getPageContext();
    }

    @Override // com.baidu.tieba.recapp.n
    public void a(AdvertAppInfo advertAppInfo, String str) {
        com.baidu.tbadk.distribute.a.alC().a(advertAppInfo, this.forumId, 0L, "FRS", str, getPn());
    }

    @Override // com.baidu.tieba.recapp.n
    public void bcJ() {
        bcn().bcJ();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.eYD == null) {
            this.eYD = VoiceManager.instance();
        }
        return this.eYD;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdRecyclerView aeZ() {
        if (this.eYE == null) {
            return null;
        }
        return this.eYE.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void bcK() {
        if (this.eYD != null) {
            this.eYD.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> afa() {
        if (this.bTU == null) {
            this.bTU = UserIconBox.q(getPageContext().getPageActivity(), 8);
        }
        return this.bTU;
    }

    public void bcL() {
        if (getFragmentActivity() != null && getFragmentActivity().getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.b(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.p onGetPreLoadListView() {
        return aeZ().getPreLoadHandle();
    }

    @Override // com.baidu.tieba.frs.ah
    public NavigationBar aDm() {
        if (this.eYE == null) {
            return null;
        }
        return this.eYE.aDm();
    }

    public FRSRefreshButton bcM() {
        return this.eYG;
    }

    public void a(FRSRefreshButton fRSRefreshButton) {
        if (fRSRefreshButton != null) {
            this.eYG = fRSRefreshButton;
            this.eYG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.36
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (FrsFragment.this.eYX != null) {
                        FrsTabViewController.b bjs = FrsFragment.this.eYX.bjs();
                        if (bjs != null && bjs.fragment != null && (bjs.fragment instanceof ag)) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                            ((ag) bjs.fragment).bcb();
                            ((ag) bjs.fragment).aCq();
                            return;
                        }
                        FrsFragment.this.bcs().startPullRefresh();
                    }
                }
            });
        }
    }

    public void bcN() {
        if (this.eYG != null && this.eYH) {
            if (this.eZA != null) {
                this.eZA.cancel();
            }
            this.eZA = new AlphaAnimation(1.0f, 0.0f);
            this.eZA.setDuration(300L);
            this.eZA.setFillAfter(true);
            this.eYG.startAnimation(this.eZA);
            this.eYH = false;
        }
    }

    public void bcO() {
        if (this.eYG != null && !this.eYH && this.eYX.bjv() != 0) {
            this.eYG.setVisibility(0);
            if (this.eZB != null) {
                this.eZB.cancel();
            }
            this.eZB = new AlphaAnimation(0.0f, 1.0f);
            this.eZB.setDuration(300L);
            this.eZB.setFillAfter(true);
            this.eYG.startAnimation(this.eZB);
            this.eYH = true;
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
                if (bdUniqueId == p.fbL) {
                    if (FrsFragment.this.eYE != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11752").bJ(ImageViewerConfig.FORUM_ID, FrsFragment.this.forumId).bJ("obj_locate", "1"));
                        FrsFragment.this.eYE.startPullRefresh();
                    }
                } else if (mVar != null && (mVar instanceof bf)) {
                    bg bgVar = ((bf) mVar).threadData;
                    if (bgVar.ZG() == null || bgVar.ZG().getGroup_id() == 0 || bc.cZ(FrsFragment.this.getActivity())) {
                        if (bgVar.Zy() != 1 || bc.cZ(FrsFragment.this.getActivity())) {
                            if (bgVar.Zb() != null) {
                                if (bc.cZ(FrsFragment.this.getActivity())) {
                                    String postUrl = bgVar.Zb().getPostUrl();
                                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.lo()) {
                                        com.baidu.tbadk.browser.a.as(FrsFragment.this.getActivity(), postUrl);
                                    }
                                }
                            } else if (bgVar.ZR() != null) {
                                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                    bc.cY(FrsFragment.this.getPageContext().getPageActivity());
                                    return;
                                }
                                com.baidu.tbadk.core.data.o ZR = bgVar.ZR();
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), ZR.getCartoonId(), ZR.getChapterId(), 2)));
                            } else {
                                com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                                if (readThreadHistory != null && !readThreadHistory.CM(bgVar.getId())) {
                                    readThreadHistory.CL(bgVar.getId());
                                }
                                boolean z = false;
                                final String YV = bgVar.YV();
                                if (YV != null && !YV.equals("")) {
                                    z = true;
                                    new Thread(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.a.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(YV);
                                            xVar.acE().adC().mIsNeedAddCommenParam = false;
                                            xVar.acE().adC().mIsUseCurrentBDUSS = false;
                                            xVar.ach();
                                        }
                                    }).start();
                                }
                                String tid = bgVar.getTid();
                                if (tid == null) {
                                    tid = "";
                                }
                                if (bgVar.YJ() == 2 && !tid.startsWith("pb:")) {
                                    ba.adA().c(FrsFragment.this.getPageContext(), new String[]{tid, "", null});
                                    return;
                                }
                                if (tid.startsWith("pb:")) {
                                    bgVar.setId(tid.substring(3));
                                }
                                if (bdUniqueId.getId() == bg.bCD.getId()) {
                                    com.baidu.tieba.frs.f.h.a(bgVar.Yu());
                                } else if (bdUniqueId.getId() == bg.bBk.getId()) {
                                    com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c12940");
                                    amVar.bJ("obj_type", "2");
                                    amVar.bJ("tid", bgVar.getTid());
                                    TiebaStatic.log(amVar);
                                }
                                com.baidu.tieba.frs.f.i.a(FrsFragment.this, bgVar, i, z);
                                com.baidu.tieba.frs.f.h.a(FrsFragment.this, FrsFragment.this.eYh, bgVar);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.l.lo()) {
            hideNetRefreshView(this.eYE.bdJ());
            showLoadingView(this.eYE.bdJ(), true);
            this.eYE.jd(false);
            this.eYV.y(3, true);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData bcP() {
        return this.eYh;
    }

    public boolean bcQ() {
        return this.eYE.bcQ();
    }

    public void ap(Object obj) {
        if (this.eZa != null && this.eZa.fqB != null) {
            this.eZa.fqB.m(obj);
        }
    }

    public void aq(Object obj) {
        if (this.eZa != null && this.eZa.fqC != null) {
            this.eZa.fqC.m(obj);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        this.eYE.getListView().stopScroll();
        if (!this.eYE.bdE()) {
            if (!com.baidu.adp.lib.util.l.lo()) {
                this.eYE.aCt();
            } else if (this.eYV.bhI() == 1) {
                aBn();
                aAZ();
            } else if (this.eYV.hasMore()) {
                aAZ();
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void uE(String str) {
        aBn();
        showToast(str);
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void R(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        boolean T = com.baidu.tbadk.core.util.v.T(arrayList);
        setHasMore(T ? 0 : 1);
        aBn();
        if (!T) {
            if (!this.eYV.bhR() && TbadkCoreApplication.getInst().isRecAppExist() && this.eYV.bhI() == 1) {
                this.eYh.addRecommendAppToThreadList(this, arrayList);
            }
            if (this.eYV != null) {
                com.baidu.tieba.frs.d.a.a(getUniqueId(), arrayList, this.eYh.getForum(), this.eYV.getSortType());
            }
            ArrayList<com.baidu.adp.widget.ListView.m> a2 = this.eZh.a(false, false, arrayList, this.eYA, false);
            if (a2 != null) {
                this.eYh.setThreadList(a2);
                this.eYE.a(a2, this.eYh);
            }
            if (this.eYV != null) {
                com.baidu.tieba.frs.d.c.a(this.eYh, this.eYV.bhN(), 2);
            }
        }
    }

    private void aBn() {
        if (bct() == 1 || this.eZh.ca(this.eYh.getThreadListIds())) {
            if (com.baidu.tbadk.core.util.v.S(this.eYh.getThreadList()) > 3) {
                this.eYE.aCr();
            } else {
                this.eYE.bdM();
            }
        } else if (com.baidu.tbadk.core.util.v.T(this.eYh.getThreadList())) {
            this.eYE.aCt();
        } else {
            this.eYE.aCs();
        }
    }

    @Override // com.baidu.tieba.frs.mc.l
    public void aAZ() {
        if (this.eZh != null) {
            this.eZh.a(this.eYw, this.forumId, this.eYh);
        }
    }

    public void takePhoto() {
        if (!com.baidu.tbadk.core.util.ab.e(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.ak.c(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        if (this.eYN) {
            return null;
        }
        if (bcR()) {
            return "a034";
        }
        return "a006";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (!bcR()) {
            return super.getCurrentPageSourceKeyList();
        }
        if (super.getCurrentPageSourceKeyList() != null) {
            arrayList = new ArrayList(super.getCurrentPageSourceKeyList());
        } else {
            arrayList = new ArrayList();
        }
        if (!"a001".equals(com.baidu.tbadk.core.util.v.c(arrayList, arrayList.size() - 1))) {
            arrayList.add("a001");
            return arrayList;
        }
        return arrayList;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.d(getForumId(), 0L));
        }
        return pageStayDurationItem;
    }

    @Override // android.support.v4.app.Fragment, com.baidu.e.a.a.InterfaceC0042a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        com.baidu.tieba.frs.f.i.a(this, i, strArr, iArr);
    }

    public void iV(boolean z) {
        if (this.eZb != null) {
            this.eZb.js(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.eZc.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a li(int i) {
        return this.eZc.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        this.eZl.b(bVar);
    }

    public boolean bcR() {
        return this.eYs;
    }

    @Override // com.baidu.tieba.frs.ae
    public void aBr() {
        if (this.eYE != null) {
            showFloatingView();
            this.eYE.getListView().scrollToPosition(0);
            this.eYE.startPullRefresh();
        }
    }

    public ForumWriteData bcS() {
        if (this.eYh == null || this.eYh.getForum() == null) {
            return null;
        }
        ForumData forum = this.eYh.getForum();
        ForumWriteData forumWriteData = new ForumWriteData(forum.getId(), forum.getName(), forum.getPrefixData(), this.eYh.getAnti());
        forumWriteData.avatar = forum.getImage_url();
        forumWriteData.forumLevel = forum.getUser_level();
        forumWriteData.specialForumType = forum.special_forum_type;
        forumWriteData.firstDir = forum.getFirst_class();
        forumWriteData.secondDir = forum.getSecond_class();
        UserData userData = this.eYh.getUserData();
        forumWriteData.privateThread = userData != null ? userData.getPrivateThread() : 0;
        return forumWriteData;
    }

    @Override // com.baidu.tieba.frs.ae
    public void aeH() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.frs.ae
    public void setVideoThreadId(String str) {
    }

    public void iW(boolean z) {
        this.eYS = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z) {
        super.showLoadingView(view, z);
        this.eYE.pY(8);
        ((FrsActivity) getActivity()).i(view, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        super.hideLoadingView(view);
        this.eYE.pY(0);
        ((FrsActivity) getActivity()).i(view, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        super.showNetRefreshView(view, str, z);
        this.eYE.pY(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshViewNoClick(View view, String str, boolean z) {
        super.showNetRefreshViewNoClick(view, str, z);
        this.eYE.pY(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        super.hideNetRefreshView(view);
        this.eYE.pY(0);
    }

    public void bcT() {
        FrsTabViewController.b bjs;
        if (this.eYX != null && (bjs = this.eYX.bjs()) != null && bjs.fragment != null && (bjs.fragment instanceof ag)) {
            ((ag) bjs.fragment).bcb();
        }
    }

    public void iX(boolean z) {
        this.eYu = z;
    }

    public void b(OvalActionButton ovalActionButton) {
        this.eYF = ovalActionButton;
    }

    public OvalActionButton bcU() {
        return this.eYF;
    }

    public boolean bcV() {
        return this.eYu;
    }

    public void uW(String str) {
        if (TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.util.ap.isEmpty(str)) {
            if (this.eZx == null) {
                this.eZx = new AddExperiencedModel(getTbPageContext());
                this.eZx.a(this.eZC);
            }
            this.eZx.dP(this.forumId, str);
        }
    }

    public boolean bcW() {
        if (this.eYS) {
            return (this.eYV != null && this.eYV.bhJ() && com.baidu.tieba.frs.a.bbD().bbE()) ? false : true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.e.c
    public boolean videoNeedPreload() {
        if (this.eYh != null) {
            return com.baidu.tbadk.util.ad.aqs() && (this.eYh.isFrsVideoAutoPlay || com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("auto_play_video_frs", 0) == 1);
        }
        return super.videoNeedPreload();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcX() {
        if (!com.baidu.tbadk.core.util.ap.isEmpty(this.forumId)) {
            com.baidu.tbadk.BdToken.c.TX().g(com.baidu.tbadk.BdToken.b.bqH, com.baidu.adp.lib.g.b.d(this.forumId, 0L));
        }
    }
}
