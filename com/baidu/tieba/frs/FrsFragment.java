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
    public static com.baidu.tieba.tbadkCore.j eYJ;
    private com.baidu.adp.lib.e.b<TbImageView> bTV;
    private com.baidu.tbadk.util.w ctJ;
    private com.baidu.tieba.frs.gametab.b dor;
    private com.baidu.tieba.tbadkCore.data.f eYB;
    private VoiceManager eYE;
    private OvalActionButton eYG;
    private FRSRefreshButton eYH;
    private com.baidu.card.z eYV;
    private FrsModelController eYW;
    private com.baidu.tieba.frs.vc.f eYX;
    private FrsTabViewController eYY;
    private com.baidu.tieba.frs.mc.h eYZ;
    private com.baidu.tieba.frs.entelechy.a eYr;
    private boolean eZA;
    private int eZK;
    private com.baidu.tieba.frs.smartsort.b eZa;
    private com.baidu.tieba.frs.mc.b eZb;
    private ak eZc;
    private com.baidu.tieba.frs.entelechy.b.b eZe;
    private com.baidu.tbadk.k.a eZf;
    private com.baidu.tieba.frs.vc.a eZg;
    private com.baidu.tieba.frs.mc.d eZh;
    private com.baidu.tieba.frs.mc.c eZi;
    private com.baidu.tieba.frs.vc.h eZj;
    private com.baidu.tieba.frs.mc.a eZk;
    private com.baidu.tieba.frs.live.a eZl;
    private j eZm;
    public com.baidu.tieba.frs.vc.c eZn;
    private com.baidu.tieba.frs.mc.e eZo;
    private View.OnTouchListener eZp;
    private com.baidu.tieba.frs.view.a eZq;
    private com.baidu.tieba.frs.view.c eZr;
    private com.baidu.tieba.frs.vc.e eZs;
    private boolean eZt;
    private com.baidu.tieba.NEGFeedBack.a eZv;
    private com.baidu.tieba.ala.a eZw;
    private com.baidu.tieba.frs.brand.buttommenu.a eZx;
    private AddExperiencedModel eZy;
    private com.baidu.tbadk.core.dialog.a ekb;
    private View mRootView;
    public static boolean eYw = false;
    public static volatile long eYL = 0;
    public static volatile long eYM = 0;
    public static volatile int eYN = 0;
    public boolean eYs = false;
    private boolean eYt = false;
    private boolean eYu = false;
    private boolean eYv = true;
    public String eYx = null;
    public String mFrom = null;
    public int mFlag = 0;
    public boolean eYy = false;
    private boolean eYz = false;
    private String mThreadId = null;
    public String forumId = null;
    private int eYk = 0;
    private boolean eYA = false;
    private boolean eYC = false;
    private boolean eYD = false;
    private k eYF = null;
    private boolean eYI = false;
    public final bg bTo = null;
    private FrsViewData eYi = new FrsViewData();
    public long eCx = -1;
    public long cqy = 0;
    public long cqq = 0;
    public long createTime = 0;
    public long beginTime = -1;
    public long eYK = 0;
    public boolean eYO = false;
    private boolean eYP = false;
    private boolean eYQ = false;
    public com.baidu.tbadk.o.b eYR = null;
    private boolean eYS = true;
    private boolean eYT = true;
    private a.C0039a eYU = new a.C0039a(2);
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> eZd = new SparseArray<>();
    private boolean ddh = true;
    private boolean eZu = false;
    private boolean hasInit = false;
    private boolean eZz = false;
    private AlphaAnimation eZB = null;
    private AlphaAnimation eZC = null;
    private AddExperiencedModel.a eZD = new AddExperiencedModel.a() { // from class: com.baidu.tieba.frs.FrsFragment.1
        @Override // com.baidu.tieba.share.AddExperiencedModel.a
        public void a(ContriInfo contriInfo) {
        }
    };
    private HttpMessageListener eZE = new HttpMessageListener(CmdConfigHttp.CMD_PB_FLOOR_AGREE, true) { // from class: com.baidu.tieba.frs.FrsFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof PbFloorAgreeResponseMessage)) {
                PbFloorAgreeResponseMessage pbFloorAgreeResponseMessage = (PbFloorAgreeResponseMessage) httpResponsedMessage;
            }
        }
    };
    private final CustomMessageListener eZF = new CustomMessageListener(2016495) { // from class: com.baidu.tieba.frs.FrsFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof bg) {
                    com.baidu.tieba.frs.f.h.a(FrsFragment.this.eYF, FrsFragment.this.eYi, FrsFragment.this.getForumId(), true, (bg) data);
                }
            }
        }
    };
    private CustomMessageListener eZG = new CustomMessageListener(2921005) { // from class: com.baidu.tieba.frs.FrsFragment.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.eYi != null) {
                FrsFragment.this.eYi.removeGameRankListFromThreadList();
                if (FrsFragment.this.eYF != null) {
                    FrsFragment.this.eYF.Rs();
                }
            }
        }
    };
    private CustomMessageListener XX = new CustomMessageListener(2921401) { // from class: com.baidu.tieba.frs.FrsFragment.40
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && FrsFragment.this.eYH != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() <= 0 || FrsFragment.this.eYY.bjv() == 0) {
                    if (FrsFragment.this.eYY.bjv() != 0) {
                        FrsFragment.this.bcN();
                        return;
                    }
                    return;
                }
                FrsFragment.this.bcO();
            }
        }
    };
    private CustomMessageListener eZH = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.FrsFragment.41
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
    private final ai eZI = new ai() { // from class: com.baidu.tieba.frs.FrsFragment.42
        @Override // com.baidu.tieba.frs.ai
        public void a(int i, int i2, ap apVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
            FrsFragment.this.bcv();
            if (FrsFragment.this.eZe != null) {
                FrsFragment.this.eYX.jP(FrsFragment.this.eZe.qv(i));
            }
            e.b bVar = new e.b();
            if (apVar != null) {
                bVar.isSuccess = apVar.errCode == 0;
                bVar.errorCode = apVar.errCode;
                bVar.errorMsg = apVar.errMsg;
                if (bVar.isSuccess) {
                    if (com.baidu.tbadk.core.util.v.T(arrayList)) {
                        FrsFragment.this.eYF.aCt();
                    } else if (apVar.hasMore) {
                        if (com.baidu.tbadk.core.util.v.S(FrsFragment.this.eYi.getThreadList()) > 3) {
                            FrsFragment.this.eYF.aCr();
                        } else {
                            FrsFragment.this.eYF.bdM();
                        }
                    } else if (apVar.fcQ) {
                        FrsFragment.this.eYF.aCs();
                    } else {
                        FrsFragment.this.eYF.aCt();
                    }
                }
            } else {
                apVar = new ap();
                apVar.pn = 1;
                apVar.hasMore = false;
                apVar.fcQ = false;
            }
            if (i == 1) {
                FrsFragment.this.eYS = true;
                FrsFragment.this.eZV.a(FrsFragment.this.eYW.getType(), false, bVar);
            } else {
                FrsFragment.this.a(bVar);
                if (FrsFragment.this.eYW.bhm() != null) {
                    FrsFragment.this.eYi = FrsFragment.this.eYW.bhm();
                }
                FrsFragment.this.bcH();
            }
            if (FrsFragment.this.fac != null) {
                FrsFragment.this.fac.a(i, i2, apVar, arrayList);
            }
        }
    };
    private FrsTabViewController.a eZJ = new FrsTabViewController.a() { // from class: com.baidu.tieba.frs.FrsFragment.43
        @Override // com.baidu.tieba.frs.vc.FrsTabViewController.a
        public void jG(int i) {
            boolean z = false;
            if (i != 1) {
                com.baidu.tieba.card.t.aQD().hQ(false);
                FrsFragment.this.iS(false);
            }
            if (i == 303 && i != FrsFragment.this.eZK) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13121").bJ(ImageViewerConfig.FORUM_ID, FrsFragment.this.forumId).bJ("uid", TbadkCoreApplication.getCurrentAccount()));
            }
            if (i == 502) {
                FrsFragment.this.eYG.setIconFade(d.f.btn_frs_professional_edit_n);
            } else {
                FrsFragment.this.eYG.setIconFade(0);
            }
            FrsFragment.this.eZK = i;
            FrsFragment.this.bcK();
            com.baidu.tieba.frs.d.d.fgQ.fsP = i;
            com.baidu.tieba.frs.d.d.fgQ.fsQ = -1;
            com.baidu.tieba.frs.a bbD = com.baidu.tieba.frs.a.bbD();
            if (i == 1 && FrsFragment.this.eZz) {
                z = true;
            }
            bbD.z(z, true);
        }
    };
    private CustomMessageListener eZL = new CustomMessageListener(2001606) { // from class: com.baidu.tieba.frs.FrsFragment.44
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                FrsFragment.this.eYY.rA(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    };
    private CustomMessageListener eZM = new CustomMessageListener(2001607) { // from class: com.baidu.tieba.frs.FrsFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && ((Integer) customResponsedMessage.getData()).intValue() == 51 && FrsFragment.this.eYi != null) {
                com.baidu.tieba.frs.f.j.a(FrsFragment.this.eYi, FrsFragment.this.getPageContext());
            }
        }
    };
    private final CustomMessageListener eZN = new CustomMessageListener(2003019) { // from class: com.baidu.tieba.frs.FrsFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                FrsFragment.this.eYY.ry(49);
            }
        }
    };
    private final CustomMessageListener eZO = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.frs.FrsFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && FrsFragment.this.eYi != null && FrsFragment.this.eYi.getForum() != null) {
                SignData signData = (SignData) customResponsedMessage.getData();
                int user_level = FrsFragment.this.eYi.getForum().getUser_level();
                if (signData.forumId != null && signData.forumId.equals(FrsFragment.this.eYi.getForum().getId())) {
                    FrsFragment.this.eYi.updateSignData(signData);
                    FrsFragment.this.eYX.i(FrsFragment.this.eYi);
                    if (FrsFragment.this.eYX.bjg()) {
                        i = FrsFragment.this.eYi.getForum().getUser_level();
                        if (user_level >= i) {
                            i++;
                        }
                    } else {
                        i = user_level;
                    }
                    TbadkCoreApplication.getInst().addSignedForum(FrsFragment.this.eYi.getForum().getName(), signData.sign_bonus_point, i);
                }
            }
        }
    };
    private final CustomMessageListener eZP = new CustomMessageListener(2001352) { // from class: com.baidu.tieba.frs.FrsFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.r) && FrsFragment.this.eYi != null) {
                FrsFragment.this.eYi.updateLikeData((com.baidu.tieba.tbadkCore.r) customResponsedMessage.getData());
                FrsFragment.this.eYX.h(FrsFragment.this.eYi);
                FrsFragment.this.eYY.a(FrsFragment.this.eYi, FrsFragment.this.eYW.bhN());
            }
        }
    };
    private final AntiHelper.a eZQ = new AntiHelper.a() { // from class: com.baidu.tieba.frs.FrsFragment.6
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12536").T("obj_locate", at.a.bLq));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12535").T("obj_locate", at.a.bLq));
        }
    };
    private CustomMessageListener dds = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.frs.FrsFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(FrsFragment.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().bYC != null) {
                        if (AntiHelper.a(FrsFragment.this.getActivity(), updateAttentionMessage.getData().bYC, FrsFragment.this.eZQ) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12534").T("obj_locate", at.a.bLq));
                        }
                    } else if (updateAttentionMessage.getData().Jy && updateAttentionMessage.getData().isAttention) {
                        com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getPageContext().getPageActivity(), d.j.attention_success);
                    }
                }
            }
        }
    };
    private CustomMessageListener eZR = new CustomMessageListener(2921346) { // from class: com.baidu.tieba.frs.FrsFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsFragment.this.refresh();
        }
    };
    private CustomMessageListener eZS = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.frs.FrsFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                FrsFragment.this.eYF.c((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener eZT = new CustomMessageListener(2001626) { // from class: com.baidu.tieba.frs.FrsFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewsRemindMessage newsRemindMessage;
            if (customResponsedMessage != null && (customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626 && (newsRemindMessage = (NewsRemindMessage) customResponsedMessage) != null) {
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (FrsFragment.this.eYF != null) {
                    FrsFragment.this.eYF.w(notificationCount, z);
                }
            }
        }
    };
    private final CustomMessageListener brt = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.frs.FrsFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.isResumed()) {
                FrsFragment.this.bcX();
            }
        }
    };
    private CustomMessageListener eZU = new CustomMessageListener(2003020) { // from class: com.baidu.tieba.frs.FrsFragment.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (FrsFragment.this.eYF != null) {
                    FrsFragment.this.eYF.setExpanded(booleanValue);
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.n eZV = new com.baidu.tieba.tbadkCore.n() { // from class: com.baidu.tieba.frs.FrsFragment.14
        private long startTime = 0;

        @Override // com.baidu.tieba.tbadkCore.n
        public void pT(int i) {
            this.startTime = System.nanoTime();
            if (FrsFragment.this.eYF != null) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsFragment.this.eYF.bdv();
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
            if (FrsFragment.this.ddh) {
                FrsFragment.this.ddh = false;
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.eYF, FrsFragment.this.eYi, FrsFragment.this.getForumId(), false, null);
            }
            FrsFragment.this.bcv();
            FrsFragment.this.eYP = true;
            if (bVar != null && bVar.isSuccess) {
                FrsFragment.this.eYF.bdI().jC(com.baidu.tbadk.core.util.ar.adm().ado());
                FrsFragment.eYL = 0L;
                FrsFragment.eYM = 0L;
                FrsFragment.eYN = 0;
            } else {
                FrsFragment.eYN = 1;
            }
            if (!FrsFragment.this.eYW.bhR() && (i == 3 || i == 6)) {
                FrsFragment.this.eZi.resetData();
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (FrsFragment.this.eYW.bhm() != null) {
                FrsFragment.this.eYi = FrsFragment.this.eYW.bhm();
            }
            FrsFragment.this.eYF.b(FrsFragment.this.eYi.getRedpacketRainData());
            FrsFragment.this.pQ(1);
            if (i == 7) {
                FrsFragment.this.pR(FrsFragment.this.eYi.getFrsDefaultTabId());
                return;
            }
            if (FrsFragment.this.eYi.getPage() != null) {
                FrsFragment.this.setHasMore(FrsFragment.this.eYi.getPage().XH());
            }
            if (i == 4) {
                if (!FrsFragment.this.eYW.bhR() && TbadkCoreApplication.getInst().isRecAppExist() && FrsFragment.this.eYW.bhI() == 1) {
                    FrsFragment.this.eYi.addRecommendAppToThreadList(FrsFragment.this);
                }
                ArrayList<com.baidu.adp.widget.ListView.m> a2 = FrsFragment.this.eZi.a(false, false, FrsFragment.this.eYi.getThreadList(), FrsFragment.this.eYB, false);
                if (a2 != null) {
                    FrsFragment.this.eYi.setThreadList(a2);
                    FrsFragment.this.eYi.updateInterviewTaskInfoDataInThreadList();
                }
                if (FrsFragment.this.eYW != null) {
                    com.baidu.tieba.frs.d.c.a(FrsFragment.this.eYi, FrsFragment.this.eYW.bhN(), 2);
                }
                com.baidu.tieba.frs.f.a.a(FrsFragment.this, FrsFragment.this.eYi.getForum(), FrsFragment.this.eYi.getThreadList(), false, FrsFragment.this.getPn());
                FrsFragment.this.cqy = System.currentTimeMillis() - currentTimeMillis;
                FrsFragment.this.eYF.a(a2, FrsFragment.this.eYi);
                FrsFragment.this.bcw();
                return;
            }
            FrsFragment.this.bcw();
            switch (i) {
                case 1:
                    FrsFragment.this.eYF.bdv();
                    break;
                case 2:
                    FrsFragment.this.eYF.bdv();
                    break;
                case 3:
                case 6:
                    if (FrsFragment.this.eYi != null) {
                        FrsFragment.this.eYi.clearPostThreadCount();
                    }
                    if (FrsFragment.this.eZn != null) {
                        FrsFragment.this.eZn.refresh();
                        break;
                    }
                    break;
            }
            FrsFragment.this.bcA();
            if (bVar == null || bVar.errorCode == 0) {
                if (FrsFragment.this.eYi != null) {
                    FrsFragment.this.C(false, i == 5);
                    if (FrsFragment.this.eYW != null) {
                        com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), FrsFragment.this.eYi.getThreadList(), FrsFragment.this.eYi.getForum(), FrsFragment.this.eYW.getSortType());
                    }
                    FrsFragment.this.eYF.qc(i);
                    FrsFragment.eYL = (System.nanoTime() - this.startTime) / 1000000;
                    if (bVar != null) {
                        FrsFragment.eYM = bVar.iDC;
                    }
                } else {
                    return;
                }
            } else if (FrsFragment.this.eYi == null || com.baidu.tbadk.core.util.v.T(FrsFragment.this.eYi.getThreadList())) {
                FrsFragment.this.a(bVar);
            } else if (bVar.iDB) {
                FrsFragment.this.showToast(FrsFragment.this.getPageContext().getResources().getString(d.j.net_error_text, bVar.errorMsg, Integer.valueOf(bVar.errorCode)));
            }
            FrsFragment.this.bcx();
            FrsFragment.this.bcy();
            if (FrsFragment.this.eYi.getAccessFlag() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11384"));
            }
            if (FrsFragment.this.eCx > -1 && !FrsFragment.this.eZu) {
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.eYW, FrsFragment.this.eCx);
                FrsFragment.this.eCx = -1L;
                FrsFragment.this.eZu = true;
            }
            if (FrsFragment.this.eYC && FrsFragment.this.eYY.ry(49)) {
                FrsFragment.this.eYC = false;
            }
            FrsFragment.this.cqy = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void b(com.baidu.tieba.tbadkCore.j jVar) {
            if ((jVar != null && ("normal_page".equals(FrsFragment.this.eYW.getPageType()) || "frs_page".equals(FrsFragment.this.eYW.getPageType()) || "book_page".equals(FrsFragment.this.eYW.getPageType()))) || "brand_page".equals(FrsFragment.this.eYW.getPageType())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001615, jVar));
                FrsFragment.this.a(jVar);
                FrsFragment.eYJ = jVar;
            }
        }
    };
    private final CustomMessageListener eZW = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.frs.FrsFragment.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                FrsFragment.this.eYi.updateCurrentUserPendant((com.baidu.tbadk.data.l) customResponsedMessage.getData());
                FrsFragment.this.eYF.bdI().notifyDataSetChanged();
            }
        }
    };
    private final CustomMessageListener mMemListener = new CustomMessageListener(2001194) { // from class: com.baidu.tieba.frs.FrsFragment.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && FrsFragment.this.eYi != null && (userData = FrsFragment.this.eYi.getUserData()) != null) {
                userData.setIsMem(num.intValue());
                if (num.intValue() != 0) {
                    FrsFragment.this.eYX.h(num);
                }
            }
        }
    };
    private final com.baidu.tieba.frs.mc.k eZX = new com.baidu.tieba.frs.mc.k() { // from class: com.baidu.tieba.frs.FrsFragment.26
        @Override // com.baidu.tieba.frs.mc.k
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.m> arrayList, boolean z3) {
            if (FrsFragment.this.eZa != null && FrsFragment.this.eYW != null && FrsFragment.this.eYW.bhR() && z && !z2 && !z3) {
                FrsFragment.this.eZa.rb(i2);
            }
        }
    };
    public final View.OnTouchListener ccX = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.FrsFragment.27
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (FrsFragment.this.eZp != null) {
                FrsFragment.this.eZp.onTouch(view, motionEvent);
            }
            if (FrsFragment.this.eZc != null && FrsFragment.this.eZc.beq() != null) {
                FrsFragment.this.eZc.beq().onTouchEvent(motionEvent);
            }
            if (FrsFragment.this.dor != null) {
                FrsFragment.this.dor.f(view, motionEvent);
            }
            if (FrsFragment.this.eYX != null) {
                FrsFragment.this.eYX.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private final CustomMessageListener eZY = new CustomMessageListener(2004507) { // from class: com.baidu.tieba.frs.FrsFragment.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "photolive_hostLevel", -1) != -1 && FrsFragment.this.eYi.getForum() != null) {
                FrsFragment.this.eYi.getForum().setCanAddPhotoLivePost(true);
            }
        }
    };
    public final View.OnClickListener eZZ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.30
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsFragment.this.eYF == null || view != FrsFragment.this.eYF.bdt() || FrsFragment.this.getActivity() == null) {
                if (FrsFragment.this.eYi == null || FrsFragment.this.eYi.getForum() == null || FrsFragment.this.eYF == null || view != FrsFragment.this.eYF.bdz()) {
                    if (FrsFragment.this.eYi != null && FrsFragment.this.eYi.getForum() != null && FrsFragment.this.eYF != null && view == FrsFragment.this.eYF.bdA()) {
                        if (FrsFragment.this.eZr == null) {
                            FrsFragment.this.eZr = new com.baidu.tieba.frs.view.c(FrsFragment.this.getPageContext());
                        }
                        FrsFragment.this.eZr.l(FrsFragment.this.eYi);
                        FrsFragment.this.eZr.showDialog();
                        return;
                    }
                    if (view.getId() == d.g.game_activity_egg_layout && com.baidu.adp.lib.util.l.lo()) {
                        TiebaStatic.log("c10853");
                        if (FrsFragment.this.eYF.bdF()) {
                            FrsFragment.this.eYF.bdG();
                        } else {
                            String activityUrl = FrsFragment.this.eYi.getForum().getYuleData().aaQ().getActivityUrl();
                            if (!StringUtils.isNull(activityUrl)) {
                                com.baidu.tbadk.browser.a.as(FrsFragment.this.getPageContext().getPageActivity(), activityUrl);
                            }
                        }
                    }
                    if (view == FrsFragment.this.eYF.bdN() && FrsFragment.this.eYW != null && FrsFragment.this.eYW.hasMore()) {
                        FrsFragment.this.eYF.aCr();
                        FrsFragment.this.aAZ();
                    }
                    if (view != null && view == FrsFragment.this.eYF.bdC() && bc.cZ(FrsFragment.this.getContext())) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12924").T("obj_locate", 2));
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(FrsFragment.this.getContext())));
                        return;
                    }
                    return;
                }
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12402").bJ(ImageViewerConfig.FORUM_ID, FrsFragment.this.eYi.getForum().getId()).bJ("uid", TbadkCoreApplication.getCurrentAccount()).bJ(ImageViewerConfig.FORUM_NAME, FrsFragment.this.eYi.getForum().getName()));
                if (!StringUtils.isNull(FrsFragment.this.eYi.getForum().getName())) {
                    FrsFragment.this.sendMessage(new CustomMessage(2002001, new PostSearchActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), FrsFragment.this.eYi.getForum().getName(), FrsFragment.this.eYi.getForum().getId())));
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
        private int fak = 0;
        private int cZV = 0;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (FrsFragment.this.eZg != null) {
                FrsFragment.this.eZg.biG();
            }
            this.fak = 0;
            this.cZV = 0;
            if (recyclerView != null && (recyclerView instanceof BdRecyclerView)) {
                this.fak = ((BdRecyclerView) recyclerView).getFirstVisiblePosition();
                this.cZV = ((BdRecyclerView) recyclerView).getLastVisiblePosition();
            }
            if (FrsFragment.this.eZs != null) {
                FrsFragment.this.eZs.a(recyclerView, this.fak, this.cZV);
            }
            if (FrsFragment.this.eYi != null && FrsFragment.this.eYF != null && FrsFragment.this.eYF.bdI() != null) {
                FrsFragment.this.eYF.bh(this.fak, this.cZV);
                if (FrsFragment.this.eYV != null && FrsFragment.this.eYV.rx() != null) {
                    FrsFragment.this.eYV.rx().b(FrsFragment.this.eYU);
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (FrsFragment.this.eYX != null) {
                FrsFragment.this.eYX.setScrollState(i);
            }
            if (i == 0) {
                FrsFragment.this.eYF.bdR();
            }
            if ((i == 2 || i == 1) && !FrsFragment.this.eYQ) {
                FrsFragment.this.eYQ = true;
                FrsFragment.this.eYF.bdL();
            }
            if (FrsFragment.this.eYR == null && !FrsFragment.this.bcR()) {
                FrsFragment.this.eYR = new com.baidu.tbadk.o.b();
                FrsFragment.this.eYR.jW(1000);
            }
            if (i == 0) {
                if (FrsFragment.this.eYR != null) {
                    FrsFragment.this.eYR.aoX();
                }
                com.baidu.tieba.card.t.aQD().hQ(true);
                FrsFragment.this.iS(true);
                FrsFragment.this.eYF.bg(this.fak, this.cZV);
            } else if (FrsFragment.this.eYR != null) {
                FrsFragment.this.eYR.aoW();
            }
            if (FrsFragment.this.eZs != null) {
                FrsFragment.this.eZs.onScrollStateChanged(recyclerView, i);
            }
            if (i == 0) {
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.eYF, FrsFragment.this.eYi, FrsFragment.this.getForumId(), false, null);
            }
            if (FrsFragment.this.eYY != null && i == 1) {
                FrsFragment.this.eYY.bju();
            }
            if (FrsFragment.this.eYV == null) {
                if (FrsFragment.this.eYF.bdm() != null && !FrsFragment.this.eYF.bcQ() && FrsFragment.this.eYF.bdm().bTj() != null && (FrsFragment.this.eYF.bdm().bTj().getTag() instanceof com.baidu.card.z)) {
                    FrsFragment.this.eYV = (com.baidu.card.z) FrsFragment.this.eYF.bdm().bTj().getTag();
                }
            } else if (i == 0 && FrsFragment.this.eYF.bdm() != null && !FrsFragment.this.eYF.bcQ() && FrsFragment.this.eYF.bdm().bTj() != null && (FrsFragment.this.eYF.bdm().bTj().getTag() instanceof com.baidu.card.z)) {
                FrsFragment.this.eYV = (com.baidu.card.z) FrsFragment.this.eYF.bdm().bTj().getTag();
            }
        }
    };
    private final d faa = new d() { // from class: com.baidu.tieba.frs.FrsFragment.32
        @Override // com.baidu.tieba.frs.d
        public void a(int i, int i2, View view, View view2, bg bgVar) {
            if (i != FrsFragment.this.eYF.bdI().bfB()) {
                if (i != FrsFragment.this.eYF.bdI().bfC()) {
                    if (i == FrsFragment.this.eYF.bdI().bfz() && FrsFragment.this.eYi != null && FrsFragment.this.eYi.getUserData() != null && FrsFragment.this.eYi.getUserData().isBawu()) {
                        String bawuCenterUrl = FrsFragment.this.eYi.getBawuCenterUrl();
                        if (!com.baidu.tbadk.core.util.ap.isEmpty(bawuCenterUrl) && FrsFragment.this.eYi.getForum() != null) {
                            com.baidu.tbadk.browser.a.ar(FrsFragment.this.getPageContext().getPageActivity(), bawuCenterUrl);
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10502").bJ(ImageViewerConfig.FORUM_ID, FrsFragment.this.eYi.getForum().getId()).bJ("uid", FrsFragment.this.eYi.getUserData().getUserId()));
                        }
                    }
                } else if (bc.cZ(FrsFragment.this.getPageContext().getPageActivity())) {
                    TiebaStatic.log("my_service_ck");
                    if (FrsFragment.this.eYi != null && FrsFragment.this.eYi.getForum() != null) {
                        ForumData forum = FrsFragment.this.eYi.getForum();
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(forum.getId(), 0L), forum.getName(), forum.getImage_url(), 0)));
                    }
                }
            } else if (bc.cZ(FrsFragment.this.getActivity())) {
                TiebaStatic.log("forum_fortune_click");
                com.baidu.tieba.frs.f.i.b(FrsFragment.this.getPageContext(), FrsFragment.this.eYi);
            }
        }
    };
    private final NoNetworkView.a eWq = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.FrsFragment.33
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void dP(boolean z) {
            if (FrsFragment.this.eYW.bhI() == 1 && z && !FrsFragment.this.eYF.bcQ()) {
                if (FrsFragment.this.eYi == null || com.baidu.tbadk.core.util.v.T(FrsFragment.this.eYi.getThreadList())) {
                    FrsFragment.this.hideNetRefreshView(FrsFragment.this.eYF.bdJ());
                    FrsFragment.this.showLoadingView(FrsFragment.this.eYF.bdJ(), true);
                    FrsFragment.this.eYF.jd(false);
                    FrsFragment.this.refresh();
                    return;
                }
                FrsFragment.this.eYF.bdv();
            }
        }
    };
    private final CustomMessageListener bZf = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.FrsFragment.35
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                com.baidu.tieba.frs.f.c.a(customResponsedMessage, FrsFragment.this.eYF, FrsFragment.this.eYi);
            }
        }
    };
    private com.baidu.adp.widget.ListView.s fab = new a();
    private ai fac = new ai() { // from class: com.baidu.tieba.frs.FrsFragment.37
        @Override // com.baidu.tieba.frs.ai
        public void a(int i, int i2, ap apVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
            com.baidu.adp.lib.g.e.jH().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.37.1
                @Override // java.lang.Runnable
                public void run() {
                    if (FrsFragment.this.eYF != null && FrsFragment.this.eYF.aRB()) {
                        FrsFragment.this.aAZ();
                    }
                }
            });
        }
    };
    private CustomMessageListener fad = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.frs.FrsFragment.38
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    FrsFragment.this.eZt = true;
                }
            }
        }
    };
    private CustomMessageListener fae = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.frs.FrsFragment.39
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && FrsFragment.this.eYV != null && FrsFragment.this.eYV.rx() != null) {
                    FrsFragment.this.eYV.rx().b(new a.C0039a(3));
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.frs.loadmore.a
    public /* bridge */ /* synthetic */ com.baidu.adp.base.e getPageContext() {
        return super.getPageContext();
    }

    public com.baidu.tieba.frs.entelechy.b.b bcj() {
        return this.eZe;
    }

    public com.baidu.adp.widget.ListView.s bck() {
        return this.fab;
    }

    public com.baidu.tieba.frs.mc.d bcl() {
        return this.eZh;
    }

    public com.baidu.tieba.frs.smartsort.b bcm() {
        return this.eZa;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public FrsModelController bcn() {
        return this.eYW;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public com.baidu.tieba.frs.mc.c bco() {
        return this.eZi;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public com.baidu.tieba.frs.vc.f bcp() {
        return this.eYX;
    }

    public FrsTabViewController bcq() {
        return this.eYY;
    }

    public ak bcr() {
        return this.eZc;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public k bcs() {
        return this.eYF;
    }

    @Override // com.baidu.tieba.frs.aj
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.aj, com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.eYx;
    }

    public void setForumName(String str) {
        this.eYx = str;
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
        if (this.eZi == null) {
            return 1;
        }
        return this.eZi.getPn();
    }

    public int getPn() {
        if (this.eZi == null) {
            return 1;
        }
        return this.eZi.getPn();
    }

    public void setPn(int i) {
        if (this.eZi != null) {
            this.eZi.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.eZi != null) {
            this.eZi.setHasMore(i);
        }
    }

    public int bct() {
        if (this.eZi == null) {
            return -1;
        }
        return this.eZi.bct();
    }

    public boolean bcu() {
        return this.eYD;
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
            this.eYF.bdp();
            showNetRefreshView(this.eYF.bdJ(), string, true);
        } else if (340001 == bVar.errorCode) {
            a(bVar, this.eYi.getRecm_forum_list());
        } else {
            if (com.baidu.tbadk.core.util.v.T(this.eYi.getThreadList())) {
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
        this.eYF.bdp();
        this.eYF.pY(8);
        if (this.eZq == null) {
            this.eZq = new com.baidu.tieba.frs.view.a(getPageContext(), getNetRefreshListener());
        }
        this.eZq.pp(str);
        this.eZq.cg(list);
        this.eZq.attachView(view, z);
    }

    private void a(e.b bVar, List<RecmForumInfo> list) {
        if (this.eYF != null) {
            this.eYF.bdp();
            this.eYF.setTitle(this.eYx);
            a(this.eYF.bdJ(), bVar.errorMsg, true, list);
        }
    }

    private void b(e.b bVar) {
        this.eYF.bdp();
        if (bVar.iDB) {
            showNetRefreshView(this.eYF.bdJ(), TbadkCoreApplication.getInst().getString(d.j.net_error_text, new Object[]{bVar.errorMsg, Integer.valueOf(bVar.errorCode)}), true);
        } else {
            showNetRefreshView(this.eYF.bdJ(), bVar.errorMsg, true);
        }
    }

    public void bcv() {
        hideLoadingView(this.eYF.bdJ());
        this.eYF.jf(false);
        if (this.eYF.bdn() instanceof com.baidu.tieba.frs.tab.c) {
            ((com.baidu.tieba.frs.tab.c) this.eYF.bdn()).bin();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcw() {
        if (bct() == 0 && com.baidu.tbadk.core.util.v.T(this.eYi.getThreadListIds())) {
            if (com.baidu.tbadk.core.util.v.T(this.eYi.getThreadList())) {
                this.eYF.aCt();
            } else {
                this.eYF.aCs();
            }
        } else if (com.baidu.tbadk.core.util.v.S(this.eYi.getThreadList()) > 3) {
            this.eYF.aCr();
        } else {
            this.eYF.bdM();
        }
    }

    public void a(ErrorData errorData) {
        bcv();
        this.eYF.bdv();
        e.b bhF = this.eYW.bhF();
        boolean T = com.baidu.tbadk.core.util.v.T(this.eYi.getThreadList());
        if (bhF != null && T) {
            if (this.eYW.bhG() != 0) {
                this.eYW.bhL();
                this.eYF.bdv();
            } else {
                a(bhF);
            }
            this.eYF.D(this.eYi.isStarForum(), false);
            return;
        }
        a(bhF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcx() {
        boolean b;
        if (!bcz()) {
            final PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
            privateForumPopInfoData.a(this.eYi.getPrivateForumTotalInfo().getPrivatePopInfo());
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(getActivity());
            if (this.eYi.getPrivateForumTotalInfo().XP().private_forum_status.intValue() == 1 && (com.baidu.tbadk.core.util.ap.isEmpty(privateForumPopInfoData.XR()) || privateForumPopInfoData.XU() != Integer.valueOf(this.forumId))) {
                privateForumPopInfoData.lc("create_success");
                privateForumPopInfoData.ld(TbadkCoreApplication.getInst().getString(d.j.frs_private_create_hint));
                privateForumPopInfoData.le("https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.eYx + "&nomenu=1");
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
        if (bcz() || this.eYi.getPrivateForumTotalInfo().XP().private_forum_status.intValue() != 1) {
            a((Integer) null, (Integer) null, true);
        } else {
            a(this.eYi.getPrivateForumTotalInfo().XP().private_forum_audit_status, this.eYi.getPrivateForumTotalInfo().XQ(), false);
        }
    }

    public void a(Integer num, Integer num2, boolean z) {
        final String str;
        final int i = 2;
        if (this.eYF.bdB() != null) {
            TextView bdB = this.eYF.bdB();
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
                str = "https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.eYx + "&nomenu=1";
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
        return this.eYi == null || !this.eYi.isPrivateForum() || this.eYi.getPrivateForumTotalInfo() == null || this.eYi.getPrivateForumTotalInfo().XP() == null || this.eYi.getUserData().getIs_manager() != 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pQ(int i) {
        List<WindowToast> list;
        if (TbadkCoreApplication.isLogin() && this.eYi != null && (list = this.eYi.mWindowToast) != null && list.size() > 0) {
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
        if (this.eYi == null || this.eYi.getForum() != null) {
            this.eYF.bdH();
        } else if (this.eYi.getForum().getYuleData() != null && this.eYi.getForum().getYuleData().aaP()) {
            TiebaStatic.log("c10852");
            this.eYF.a(this.eYi.getForum().getYuleData().aaQ());
        } else {
            this.eYF.bdH();
        }
    }

    private void B(boolean z, boolean z2) {
        if (this.eYW != null && this.eYi != null && this.eYF != null && z) {
            if (!this.eYW.bhR() && this.eYW.bhI() == 1) {
                if (!this.eYW.bhP()) {
                    this.eYi.addCardVideoInfoToThreadList();
                    this.eYi.addVideoInfoToThreadListInTenAndFifteenFloor();
                }
                boolean z3 = false;
                if (this.eYF.bdI().l(com.baidu.tieba.card.data.n.elF)) {
                    z3 = this.eYi.addHotTopicDataToThreadList();
                }
                if (!z3) {
                    this.eYi.addFeedForumDataToThreadList();
                }
                if (TbadkCoreApplication.getInst().isRecAppExist()) {
                    this.eYi.addRecommendAppToThreadList(this);
                }
                if (!this.eYF.bdI().l(bg.bBi)) {
                    this.eYi.removeAlaLiveThreadData();
                }
                this.eYi.addSchoolRecommendToThreadList();
            }
            if (!this.eYF.bdI().l(bg.bBi)) {
                this.eYi.removeAlaInsertLiveData();
                this.eYi.removeAlaStageLiveDat();
            } else {
                this.eYi.addInsertLiveDataToThreadList();
                this.eYi.addStageLiveDataToThreadList();
            }
            this.eYi.updateInterviewTaskInfoDataInThreadList();
            this.eYi.addNoticeThreadToThreadList();
            if (this.eYF.bdI().l(com.baidu.tieba.h.b.fAw)) {
                this.eYi.addGameRankListToThreadList(z2);
            }
            if (TbadkCoreApplication.isLogin() && (!this.eYW.bhR() || this.eYW.isNetFirstLoad)) {
                this.eYi.addUserRecommendToThreadList();
            }
            this.eYi.addVideoActivityToTop();
        }
    }

    public boolean bcB() {
        if (this.eYX != null && this.eYW != null) {
            this.eYX.a(this.eYW.getPageType(), this.eYi);
        }
        boolean z = false;
        if (this.eYi != null) {
            z = this.eYi.hasTab();
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
            if (this.eYi != null) {
                this.eYF.a((ArrayList<com.baidu.adp.widget.ListView.m>) null, this.eYi);
                this.eYX.rs(1);
                this.eYF.bdy();
                this.eYY.a(this.eYi, this.eYW.bhN());
                com.baidu.tieba.frs.tab.d rz = this.eYY.rz(this.eYi.getFrsDefaultTabId());
                if (rz != null && !TextUtils.isEmpty(rz.url)) {
                    amVar = new am();
                    amVar.fcN = rz.url;
                    amVar.stType = rz.name;
                }
                this.eYW.a(this.eYi.getFrsDefaultTabId(), 0, amVar);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(boolean z, boolean z2) {
        try {
            if (this.eYi != null && this.eYY != null && this.eYW != null) {
                if (!this.eYF.bdI().l(bg.bBi)) {
                    this.eYi.removeAlaLiveThreadData();
                }
                boolean T = com.baidu.tbadk.core.util.v.T(this.eYi.getGameTabInfo());
                this.eYF.jb(T);
                if (!T) {
                    if (this.eZs == null) {
                        this.eZs = new com.baidu.tieba.frs.vc.e(this, (NoPressedRelativeLayout) this.mRootView);
                    }
                    if (this.dor == null) {
                        this.dor = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
                    }
                } else {
                    this.eZs = null;
                    this.dor = null;
                }
                if (this.eYi.getForum() != null) {
                    this.eYx = this.eYi.getForum().getName();
                    this.forumId = this.eYi.getForum().getId();
                }
                if (this.eYi.hasTab()) {
                    this.eYY.a(this.eYi, this.eYW.bhN());
                }
                if (z) {
                    B(true, z);
                } else {
                    B(this.eYS, z);
                }
                bcB();
                if (this.eZe != null) {
                    this.eZe.a(this.eYX, this.eYi);
                }
                if (this.eYi.getPage() != null) {
                    setHasMore(this.eYi.getPage().XH());
                }
                ArrayList<com.baidu.adp.widget.ListView.m> a2 = this.eZi.a(z2, true, this.eYi.getThreadList(), null, z, false);
                if (a2 != null) {
                    this.eYi.setThreadList(a2);
                }
                this.eYi.removeRedundantUserRecommendData();
                this.eYk = this.eYi.getTopThreadSize();
                if (this.eYB != null) {
                    this.eYA = true;
                    this.eYB.zm(this.eYk);
                    com.baidu.tieba.frs.f.a.a(this, this.eYi.getForum(), this.eYi.getThreadList(), this.eYA, getPn());
                }
                if (this.eYW.bhI() == 1) {
                    bcH();
                    if (!z && this.eYW.getPn() == 1) {
                        bcC();
                    }
                }
                if (this.eZg != null) {
                    this.eZg.bN(this.eYY.bjr());
                }
                bcv();
                this.eYF.bdq();
                this.eYF.D(true, false);
                if (z && this.eYi.isFirstTabEqualAllThread()) {
                    com.baidu.adp.lib.g.e.jH().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.18
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!FrsFragment.this.eYP) {
                                FrsFragment.this.eYF.bdS();
                            }
                        }
                    });
                }
                if (this.eYi.getForum() != null) {
                    this.eYF.uX(this.eYi.getForum().getWarningMsg());
                }
                if (this.eYi != null && this.eYi.getFrsVideoActivityData() != null && com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("frs_video_activity_guide", 0L) == 0) {
                    com.baidu.adp.lib.g.e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.19
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsFragment.this.eYF.bdP();
                        }
                    }, 1000L);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2921326, this));
                this.eYF.bdk();
                if (this.eYi != null && this.eYi.getForum() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016564, new VisitedForumData(this.eYi.getForum().getId(), this.eYi.getForum().getName(), this.eYi.getForum().getImage_url(), String.valueOf(System.currentTimeMillis() / 1000), "showlive".equals(this.eYi.getForum().special_forum_type), this.eYi.getForum().getThemeColorInfo(), this.eYi.getForum().getMember_num())));
                }
                this.eZx.a(this.eYi.bottomMenuList, this.eYi.getForum());
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
        if (this.eZl == null) {
            this.eZl = new com.baidu.tieba.frs.live.a(this, com.baidu.adp.lib.g.b.l(this.forumId, 0));
        }
        this.eZl.bhr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.j jVar) {
        try {
            if (!this.eYP && jVar != null && this.eYi != null) {
                this.eYi.receiveData(jVar);
                C(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void bcD() {
        if (this.eYW != null) {
            uV(this.eYW.getPageType());
        } else {
            uV("normal_page");
        }
    }

    private void uV(String str) {
        iT("frs_page".equals(str));
        if (this.eZe != null) {
            this.eZe.a(this.eYX, this.eYF, this.eYi);
        }
    }

    public void iT(boolean z) {
        if (this.eZj != null) {
            this.eZj.bjl();
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
            this.eYr = new com.baidu.tieba.frs.entelechy.a();
            this.eZe = this.eYr.bfg();
            this.eYX = new com.baidu.tieba.frs.vc.f(this, this.eYr, (FrsHeaderViewContainer) this.mRootView.findViewById(d.g.header_view_container));
            this.eYY = new FrsTabViewController(this, this.mRootView);
            this.eYY.registerListener();
            this.eYX.a(this.eYY);
            this.eYY.a(this.eZJ);
            Intent intent = getActivity().getIntent();
            if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                this.eYt = true;
            }
            this.eYF = new k(this, this.eZZ, this.eYr, this.eYt, this.eYX);
            this.eZx = new com.baidu.tieba.frs.brand.buttommenu.a(getPageContext(), this.mRootView);
        } else {
            if (this.mRootView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            if (this.eYY != null) {
                this.eYY.registerListener();
            }
            this.eYF.bdO();
        }
        this.eZA = true;
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        ArrayList<com.baidu.adp.widget.ListView.m> arrayList = null;
        this.eCx = System.currentTimeMillis();
        this.beginTime = this.eCx;
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.eYC = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.eCx = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            ac(intent);
        }
        this.cqq = this.beginTime - this.eCx;
        this.eYB = new com.baidu.tieba.tbadkCore.data.f("frs", com.baidu.tieba.tbadkCore.data.f.iFl);
        if (this.eYW == null) {
            this.eYW = new FrsModelController(this, this.eZV);
            this.eYW.a(this.eZI);
            this.eYW.init();
        }
        if (intent != null) {
            this.eYW.J(intent.getExtras());
        } else if (bundle != null) {
            this.eYW.J(bundle);
        } else {
            this.eYW.J(null);
        }
        if (intent != null) {
            this.eYX.Q(intent.getExtras());
        } else if (bundle != null) {
            this.eYX.Q(bundle);
        } else {
            this.eYX.Q(null);
        }
        this.eYE = getVoiceManager();
        this.eZm = new j(getPageContext(), this);
        initUI();
        initData(bundle);
        if (!bcR()) {
            this.eZc = new ak(getActivity(), this.eYF, this.eYX);
            this.eZc.js(true);
        }
        this.eYE = getVoiceManager();
        if (this.eYE != null) {
            this.eYE.onCreate(getPageContext());
        }
        new com.baidu.tieba.frs.mc.i();
        int i = -1;
        if (this.eZi != null && this.eZi.bhC() != null) {
            i = this.eZi.bhC().bct();
            arrayList = this.eZi.bhC().getDataList();
        }
        this.eZi = new com.baidu.tieba.frs.mc.c(this, this.eZX);
        this.eZi.bhC().setHasMore(i);
        if (arrayList != null && arrayList.size() > 0) {
            this.eZi.bhC().Z(arrayList);
        }
        this.eZa = new com.baidu.tieba.frs.smartsort.b(this);
        this.eZj = new com.baidu.tieba.frs.vc.h(this);
        this.eZg = new com.baidu.tieba.frs.vc.a(getPageContext(), this.eYW.bhO());
        this.eZb = new com.baidu.tieba.frs.mc.b(this);
        this.eZh = new com.baidu.tieba.frs.mc.d(this);
        this.eYZ = new com.baidu.tieba.frs.mc.h(this);
        this.eZk = new com.baidu.tieba.frs.mc.a(this);
        this.eZn = new com.baidu.tieba.frs.vc.c(this);
        this.eZo = new com.baidu.tieba.frs.mc.e(this, getUniqueId());
        this.eZv = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "frs");
        this.eZw = new com.baidu.tieba.ala.a(getPageContext());
        registerListener(this.dds);
        registerListener(this.mMemListener);
        registerListener(this.eZP);
        registerListener(this.eZY);
        registerListener(this.eZO);
        registerListener(this.eZW);
        registerListener(this.eZL);
        registerListener(this.eZM);
        registerListener(this.eZN);
        registerListener(this.eZF);
        registerListener(this.eZG);
        registerListener(this.XX);
        registerListener(this.fad);
        registerListener(this.eZS);
        registerListener(this.eZH);
        registerListener(this.eZT);
        registerListener(this.eZR);
        this.eZE.setTag(getPageContext().getUniqueId());
        registerListener(this.eZE);
        registerListener(this.brt);
        registerListener(this.eZU);
        this.fae.setTag(getPageContext().getUniqueId());
        MessageManager.getInstance().registerListener(this.fae);
        this.eYF.jd(false);
        if (!bcR() && !this.hasInit) {
            showLoadingView(this.eYF.bdJ(), true);
            this.eYW.y(3, false);
        }
        com.baidu.tieba.frs.a.bbD().a(new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.22
            @Override // com.baidu.tieba.frs.a.b
            public void A(boolean z, boolean z2) {
                if (FrsFragment.this.eYF != null) {
                    FrsFragment.this.eYF.pZ(z ? 0 : 8);
                    if (!z2) {
                        FrsFragment.this.eZz = z;
                    }
                    if (FrsFragment.this.eYF.bdI() != null && FrsFragment.this.eYW != null && FrsFragment.this.eYW.bhJ()) {
                        FrsFragment.this.eYF.bdI().notifyDataSetChanged();
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
                    if (FrsFragment.this.eYF.bdo() != null) {
                        FrsFragment.this.eYF.ja(!z);
                    }
                    if (FrsFragment.this.getActivity() instanceof FrsActivity) {
                        ((FrsActivity) FrsFragment.this.getActivity()).iR(!z);
                    }
                    if (FrsFragment.this.eZx != null) {
                        FrsFragment.this.eZx.jA(!z);
                    }
                    FrsFragment.this.eYF.jg(!z);
                    FrsFragment.this.eYF.jh(z ? false : true);
                }
            }

            @Override // com.baidu.tieba.frs.a.b
            public void pN(int i2) {
                if (FrsFragment.this.eYF != null) {
                    FrsFragment.this.eYF.qa(i2);
                }
            }

            @Override // com.baidu.tieba.frs.a.b
            public void bbJ() {
                com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getContext(), d.j.frs_multi_delete_max_num);
            }
        });
        this.eYF.b(new d.a() { // from class: com.baidu.tieba.frs.FrsFragment.24
            @Override // com.baidu.tieba.NEGFeedBack.d.a
            public void a(DeleteThreadHttpResponseMessage deleteThreadHttpResponseMessage) {
                boolean z;
                int i2 = 0;
                if (deleteThreadHttpResponseMessage != null) {
                    FrsFragment.this.eYF.auR();
                    FrsFragment.this.eYF.bdQ();
                    FrsNewAreaFragment frsNewAreaFragment = null;
                    if (FrsFragment.this.eYY == null || FrsFragment.this.eYY.bjs() == null || !(FrsFragment.this.eYY.bjs().fragment instanceof FrsNewAreaFragment)) {
                        z = false;
                    } else {
                        frsNewAreaFragment = (FrsNewAreaFragment) FrsFragment.this.eYY.bjs().fragment;
                        z = true;
                    }
                    if (deleteThreadHttpResponseMessage.getError() == 0) {
                        String text = !TextUtils.isEmpty(deleteThreadHttpResponseMessage.getText()) ? deleteThreadHttpResponseMessage.getText() : FrsFragment.this.getString(d.j.delete_fail);
                        if (deleteThreadHttpResponseMessage.getRetType() == 1211066) {
                            if (FrsFragment.this.ekb == null) {
                                FrsFragment.this.ekb = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.ekb.lz(text);
                            FrsFragment.this.ekb.a(d.j.dialog_known, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.24.1
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.ekb.dr(false);
                            FrsFragment.this.ekb.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.ekb.aaW();
                        } else if (deleteThreadHttpResponseMessage.getRetType() == 1211067) {
                            if (FrsFragment.this.ekb == null) {
                                FrsFragment.this.ekb = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.ekb.lz(text);
                            FrsFragment.this.ekb.a(d.j.know, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.24.2
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.ekb.dr(false);
                            FrsFragment.this.ekb.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.ekb.aaW();
                        } else {
                            FrsFragment.this.eYF.ax(deleteThreadHttpResponseMessage.getText(), ContextCompat.getColor(FrsFragment.this.getContext(), deleteThreadHttpResponseMessage.getRetType() == 1 ? d.C0277d.nav_bar_tip_error : d.C0277d.cp_link_tip_a_alpha95));
                        }
                        if (z && frsNewAreaFragment != null) {
                            frsNewAreaFragment.cb(deleteThreadHttpResponseMessage.getSuccessItems());
                        }
                        FrsFragment.this.bP(deleteThreadHttpResponseMessage.getSuccessItems());
                        com.baidu.tieba.frs.a.bbD().bO(deleteThreadHttpResponseMessage.getSuccessItems());
                        for (com.baidu.adp.widget.ListView.m mVar : FrsFragment.this.eYi.getThreadList()) {
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
        if (this.eYY != null) {
            this.eYY.fwg = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bP(List<String> list) {
        if (!com.baidu.tbadk.core.util.v.T(list)) {
            ArrayList<com.baidu.adp.widget.ListView.m> threadList = this.eYi.getThreadList();
            if (!com.baidu.tbadk.core.util.v.T(threadList) && this.eYF.getListView() != null && this.eYF.getListView().getData() != null) {
                Iterator<com.baidu.adp.widget.ListView.m> it = threadList.iterator();
                List<com.baidu.adp.widget.ListView.m> data = this.eYF.getListView().getData();
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
                                this.eZi.e(next);
                                this.eYF.getListView().getAdapter().notifyItemRemoved(i);
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
        if (isAdded() && this.ddh && !isLoadingViewAttached()) {
            showLoadingView(this.eYF.bdJ(), true);
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void aBt() {
        if (isAdded() && this.ddh && isLoadingViewAttached()) {
            hideLoadingView(this.eYF.bdJ());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (bcR()) {
            showLoadingView(this.eYF.bdJ(), true);
            this.eYF.qb(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.eYW.y(3, true);
            aeZ().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void setHeaderViewHeight(int i) {
    }

    @Override // com.baidu.tieba.frs.ae
    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.x xVar) {
        if (xVar != null) {
            this.ctJ = xVar.aqi();
            this.eZp = xVar.aqj();
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void showFloatingView() {
        if (this.ctJ != null) {
            this.ctJ.fl(true);
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
                this.eYx = data.getQueryParameter("name");
                this.mFrom = data.getQueryParameter("from");
                if (!StringUtils.isNull(this.eYx)) {
                    intent.putExtra("name", this.eYx);
                }
                if (!StringUtils.isNull(this.mFrom)) {
                    intent.putExtra("from", this.mFrom);
                }
                TiebaStatic.log("c10105");
            }
            if (StringUtils.isNull(this.eYx) && intent != null && intent.getData() != null) {
                Uri data2 = intent.getData();
                if (com.baidu.tbadk.BdToken.f.m(data2)) {
                    com.baidu.tbadk.BdToken.f.Ui().b(data2, new f.a() { // from class: com.baidu.tieba.frs.FrsFragment.25
                        @Override // com.baidu.tbadk.BdToken.f.a
                        public void o(HashMap<String, Object> hashMap) {
                            if (hashMap != null && (hashMap.get(com.baidu.tbadk.BdToken.f.brM) instanceof String)) {
                                FrsFragment.this.eYx = (String) hashMap.get(com.baidu.tbadk.BdToken.f.brM);
                            }
                        }
                    });
                } else {
                    com.baidu.tieba.frs.f.d af = com.baidu.tieba.frs.f.i.af(intent);
                    if (af != null) {
                        this.eYx = af.forumName;
                        if (af.fuC == null || af.fuC.equals("aidou")) {
                        }
                    }
                }
                if (!StringUtils.isNull(this.eYx)) {
                    intent.putExtra("name", this.eYx);
                }
                intent.putExtra(FrsActivityConfig.FRS_CALL_FROM, 12);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.eYE = getVoiceManager();
        if (this.eYE != null) {
            this.eYE.onStart(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        Intent intent;
        registerListener(2001118, this.bZf);
        if (bundle != null) {
            this.eYx = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
            this.eYx = intent.getStringExtra("name");
            this.mFrom = intent.getStringExtra("from");
            this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
        }
        if (getArguments() != null) {
            this.eYy = getArguments().getBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, false);
        }
        if (TextUtils.isEmpty(this.mFrom) || FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
        }
        if (this.mIsLogin) {
            registerListener(2001120, this.bZf);
        }
        this.eYX.Q(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.q.c.cdp().t(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.fad);
        eYJ = null;
        if (this.eYE != null) {
            this.eYE.onDestory(getPageContext());
        }
        com.baidu.tieba.recapp.report.a.remove("FRS");
        this.eYE = null;
        com.baidu.tieba.card.t.aQD().hQ(false);
        if (this.eYi != null && this.eYi.getForum() != null) {
            aa.ben().cF(com.baidu.adp.lib.g.b.d(this.eYi.getForum().getId(), 0L));
        }
        if (this.eZl != null) {
            this.eZl.onDestory();
        }
        if (this.eYF != null) {
            com.baidu.tieba.frs.f.h.a(this.eYF, this.eYi, getForumId(), false, null);
            this.eYF.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.eYR != null) {
                this.eYR.aoY();
            }
            this.eYF.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.eYX.onActivityDestroy();
        if (this.eYW != null) {
            this.eYW.aDC();
        }
        if (this.eZc != null) {
            this.eZc.aqh();
        }
        if (this.eZf != null) {
            this.eZf.destory();
        }
        if (this.eZg != null) {
            this.eZg.destory();
        }
        if (this.eZa != null) {
            this.eZa.onDestroy();
        }
        if (this.eZs != null) {
            this.eZs.onDestory();
        }
        if (this.eZk != null) {
            this.eZk.onDestroy();
        }
        if (this.eZv != null) {
            this.eZv.onDestroy();
        }
        if (this.eZw != null) {
            this.eZw.onDestroy();
        }
        com.baidu.tieba.recapp.d.a.bXv().bXx();
        com.baidu.tieba.frs.f.j.biD();
        if (this.eYY != null) {
            this.eYY.a((FrsTabViewController.a) null);
            this.eYY.bju();
        }
        if (this.eZy != null) {
            this.eZy.onDestroy();
        }
        com.baidu.tieba.frs.a.bbD().a(null);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.eYx);
        bundle.putString("from", this.mFrom);
        this.eYW.onSaveInstanceState(bundle);
        if (this.eYE != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            this.eYE.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.eZk != null) {
            this.eZk.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.eYF != null) {
            this.eYF.bdv();
            this.eYF.onResume();
        }
        this.eYZ.jN(true);
        this.eYS = true;
        if (eYw) {
            eYw = false;
            this.eYF.startPullRefresh();
            return;
        }
        if (this.eYE != null) {
            this.eYE.onResume(getPageContext());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921338));
        this.eYF.ji(false);
        if (this.eZt) {
            refresh(6);
            this.eZt = false;
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
                this.eYx = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.eYz = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.eYz) {
                bcF();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcF() {
        this.eYF.startPullRefresh();
    }

    public void closeActivity() {
        com.baidu.tieba.frs.f.i.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.mFrom);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.eYF.setTitle(this.eYx);
        } else {
            this.eYF.setTitle("");
            this.mFlag = 1;
        }
        this.eYF.setOnAdapterItemClickListener(this.fab);
        this.eYF.addOnScrollListener(this.mScrollListener);
        this.eYF.h(this.eWq);
        this.eYF.bdI().a(this.faa);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.eZA) {
            this.eYF.onChangeSkinType(i);
            this.eYX.rr(i);
            this.eYY.onChangeSkinType(i);
            if (this.eYH != null) {
                this.eYH.onChangeSkinType(i);
            }
            if (this.eZq != null) {
                this.eZq.onChangeSkinType();
            }
            if (this.eZx != null) {
                this.eZx.onChangeSkinType(getPageContext(), i);
            }
            if (this.ekb != null) {
                com.baidu.tbadk.r.a.a(getPageContext(), this.ekb.aaX());
            }
            if (this.eZr != null) {
                this.eZr.onChangeSkinType();
            }
        }
    }

    public void pS(int i) {
        if (!this.mIsLogin) {
            if (this.eYi != null && this.eYi.getAnti() != null) {
                this.eYi.getAnti().setIfpost(1);
            }
            if (i == 0) {
                bc.cY(getActivity());
            }
        } else if (this.eYi != null) {
            if (i == 0) {
                com.baidu.tieba.frs.f.j.d(this, 0);
            } else {
                this.eYF.bdx();
            }
        }
    }

    public void refresh() {
        com.baidu.tieba.a.d.awh().qL("page_frs");
        refresh(3);
    }

    public void refresh(int i) {
        this.eYP = false;
        bcK();
        if (this.eYF.bdm() != null) {
            this.eYF.bdm().bol();
        }
        this.eYW.y(i, true);
    }

    private void bcG() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.g.h.jI().d(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.29
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.CG(FrsFragment.this.eYx);
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
            if (this.eYi != null) {
                this.eYF.aOs();
                this.eYF.ja(bcW());
                if (!com.baidu.tieba.frs.vc.f.k(this.eYi) || !com.baidu.tieba.frs.vc.f.j(this.eYi)) {
                }
                if (this.eYi.getForum() != null) {
                    this.eYx = this.eYi.getForum().getName();
                    this.forumId = this.eYi.getForum().getId();
                }
                if (this.eYi.getPage() != null) {
                    setHasMore(this.eYi.getPage().XH());
                }
                this.eYF.setTitle(this.eYx);
                this.eYF.setForumName(this.eYx);
                TbadkCoreApplication.getInst().setDefaultBubble(this.eYi.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.eYi.getUserData().getBimg_end_time());
                bcG();
                bcI();
                ArrayList<com.baidu.adp.widget.ListView.m> threadList = this.eYi.getThreadList();
                if (threadList != null) {
                    this.eYF.a(threadList, this.eYi);
                    com.baidu.tieba.frs.f.c.w(this.eYF);
                    this.eYX.rs(getPageNum());
                    this.eYX.h(this.eYi);
                    this.eYY.a(this.eYi, this.eYW.bhN());
                    this.eYF.bdy();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void bcI() {
        if (this.eYi != null) {
            if (this.eYi.getIsNewUrl() == 1) {
                this.eYF.bdI().setFromCDN(true);
            } else {
                this.eYF.bdI().setFromCDN(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.eYZ.jN(false);
        this.eYS = false;
        this.eYF.onPause();
        if (this.eYE != null) {
            this.eYE.onPause(getPageContext());
        }
        this.eYF.ji(true);
        if (this.eZg != null) {
            this.eZg.biG();
        }
        com.baidu.tbadk.BdToken.c.TX().TY();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.eYY != null && this.eYY.bjs() != null && (this.eYY.bjs().fragment instanceof BaseFragment)) {
            ((BaseFragment) this.eYY.bjs().fragment).setPrimary(z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.t.aQD().hQ(false);
        iS(false);
        if (this.eYi != null && this.eYi.getForum() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            com.baidu.tbadk.distribute.a.alC().a(getPageContext().getPageActivity(), "frs", this.eYi.getForum().getId(), 0L);
        }
        if (this.eYE != null) {
            this.eYE.onStop(getPageContext());
        }
        if (aeZ() != null) {
            aeZ().getRecycledViewPool().clear();
        }
        this.eYX.onActivityStop();
        com.baidu.tbadk.util.y.aql();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            if (this.eYX != null) {
                this.eYX.iY(isPrimary());
            }
            if (this.eYF != null) {
                this.eYF.iY(isPrimary());
                this.eYF.ji(!isPrimary());
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (com.baidu.tieba.frs.a.bbD().bbE()) {
                com.baidu.tieba.frs.a.bbD().reset();
                return true;
            } else if (this.eYF != null) {
                return this.eYF.bdu();
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
        if (this.eYE == null) {
            this.eYE = VoiceManager.instance();
        }
        return this.eYE;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdRecyclerView aeZ() {
        if (this.eYF == null) {
            return null;
        }
        return this.eYF.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void bcK() {
        if (this.eYE != null) {
            this.eYE.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> afa() {
        if (this.bTV == null) {
            this.bTV = UserIconBox.q(getPageContext().getPageActivity(), 8);
        }
        return this.bTV;
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
        if (this.eYF == null) {
            return null;
        }
        return this.eYF.aDm();
    }

    public FRSRefreshButton bcM() {
        return this.eYH;
    }

    public void a(FRSRefreshButton fRSRefreshButton) {
        if (fRSRefreshButton != null) {
            this.eYH = fRSRefreshButton;
            this.eYH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.36
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (FrsFragment.this.eYY != null) {
                        FrsTabViewController.b bjs = FrsFragment.this.eYY.bjs();
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
        if (this.eYH != null && this.eYI) {
            if (this.eZB != null) {
                this.eZB.cancel();
            }
            this.eZB = new AlphaAnimation(1.0f, 0.0f);
            this.eZB.setDuration(300L);
            this.eZB.setFillAfter(true);
            this.eYH.startAnimation(this.eZB);
            this.eYI = false;
        }
    }

    public void bcO() {
        if (this.eYH != null && !this.eYI && this.eYY.bjv() != 0) {
            this.eYH.setVisibility(0);
            if (this.eZC != null) {
                this.eZC.cancel();
            }
            this.eZC = new AlphaAnimation(0.0f, 1.0f);
            this.eZC.setDuration(300L);
            this.eZC.setFillAfter(true);
            this.eYH.startAnimation(this.eZC);
            this.eYI = true;
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
                    if (FrsFragment.this.eYF != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11752").bJ(ImageViewerConfig.FORUM_ID, FrsFragment.this.forumId).bJ("obj_locate", "1"));
                        FrsFragment.this.eYF.startPullRefresh();
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
                                if (bdUniqueId.getId() == bg.bCE.getId()) {
                                    com.baidu.tieba.frs.f.h.a(bgVar.Yu());
                                } else if (bdUniqueId.getId() == bg.bBl.getId()) {
                                    com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c12940");
                                    amVar.bJ("obj_type", "2");
                                    amVar.bJ("tid", bgVar.getTid());
                                    TiebaStatic.log(amVar);
                                }
                                com.baidu.tieba.frs.f.i.a(FrsFragment.this, bgVar, i, z);
                                com.baidu.tieba.frs.f.h.a(FrsFragment.this, FrsFragment.this.eYi, bgVar);
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
            hideNetRefreshView(this.eYF.bdJ());
            showLoadingView(this.eYF.bdJ(), true);
            this.eYF.jd(false);
            this.eYW.y(3, true);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData bcP() {
        return this.eYi;
    }

    public boolean bcQ() {
        return this.eYF.bcQ();
    }

    public void ap(Object obj) {
        if (this.eZb != null && this.eZb.fqB != null) {
            this.eZb.fqB.m(obj);
        }
    }

    public void aq(Object obj) {
        if (this.eZb != null && this.eZb.fqC != null) {
            this.eZb.fqC.m(obj);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        this.eYF.getListView().stopScroll();
        if (!this.eYF.bdE()) {
            if (!com.baidu.adp.lib.util.l.lo()) {
                this.eYF.aCt();
            } else if (this.eYW.bhI() == 1) {
                aBn();
                aAZ();
            } else if (this.eYW.hasMore()) {
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
            if (!this.eYW.bhR() && TbadkCoreApplication.getInst().isRecAppExist() && this.eYW.bhI() == 1) {
                this.eYi.addRecommendAppToThreadList(this, arrayList);
            }
            if (this.eYW != null) {
                com.baidu.tieba.frs.d.a.a(getUniqueId(), arrayList, this.eYi.getForum(), this.eYW.getSortType());
            }
            ArrayList<com.baidu.adp.widget.ListView.m> a2 = this.eZi.a(false, false, arrayList, this.eYB, false);
            if (a2 != null) {
                this.eYi.setThreadList(a2);
                this.eYF.a(a2, this.eYi);
            }
            if (this.eYW != null) {
                com.baidu.tieba.frs.d.c.a(this.eYi, this.eYW.bhN(), 2);
            }
        }
    }

    private void aBn() {
        if (bct() == 1 || this.eZi.ca(this.eYi.getThreadListIds())) {
            if (com.baidu.tbadk.core.util.v.S(this.eYi.getThreadList()) > 3) {
                this.eYF.aCr();
            } else {
                this.eYF.bdM();
            }
        } else if (com.baidu.tbadk.core.util.v.T(this.eYi.getThreadList())) {
            this.eYF.aCt();
        } else {
            this.eYF.aCs();
        }
    }

    @Override // com.baidu.tieba.frs.mc.l
    public void aAZ() {
        if (this.eZi != null) {
            this.eZi.a(this.eYx, this.forumId, this.eYi);
        }
    }

    public void takePhoto() {
        if (!com.baidu.tbadk.core.util.ab.e(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.ak.c(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        if (this.eYO) {
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
        if (this.eZc != null) {
            this.eZc.js(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.eZd.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a li(int i) {
        return this.eZd.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        this.eZm.b(bVar);
    }

    public boolean bcR() {
        return this.eYt;
    }

    @Override // com.baidu.tieba.frs.ae
    public void aBr() {
        if (this.eYF != null) {
            showFloatingView();
            this.eYF.getListView().scrollToPosition(0);
            this.eYF.startPullRefresh();
        }
    }

    public ForumWriteData bcS() {
        if (this.eYi == null || this.eYi.getForum() == null) {
            return null;
        }
        ForumData forum = this.eYi.getForum();
        ForumWriteData forumWriteData = new ForumWriteData(forum.getId(), forum.getName(), forum.getPrefixData(), this.eYi.getAnti());
        forumWriteData.avatar = forum.getImage_url();
        forumWriteData.forumLevel = forum.getUser_level();
        forumWriteData.specialForumType = forum.special_forum_type;
        forumWriteData.firstDir = forum.getFirst_class();
        forumWriteData.secondDir = forum.getSecond_class();
        UserData userData = this.eYi.getUserData();
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
        this.eYT = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z) {
        super.showLoadingView(view, z);
        this.eYF.pY(8);
        ((FrsActivity) getActivity()).i(view, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        super.hideLoadingView(view);
        this.eYF.pY(0);
        ((FrsActivity) getActivity()).i(view, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        super.showNetRefreshView(view, str, z);
        this.eYF.pY(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshViewNoClick(View view, String str, boolean z) {
        super.showNetRefreshViewNoClick(view, str, z);
        this.eYF.pY(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        super.hideNetRefreshView(view);
        this.eYF.pY(0);
    }

    public void bcT() {
        FrsTabViewController.b bjs;
        if (this.eYY != null && (bjs = this.eYY.bjs()) != null && bjs.fragment != null && (bjs.fragment instanceof ag)) {
            ((ag) bjs.fragment).bcb();
        }
    }

    public void iX(boolean z) {
        this.eYv = z;
    }

    public void b(OvalActionButton ovalActionButton) {
        this.eYG = ovalActionButton;
    }

    public OvalActionButton bcU() {
        return this.eYG;
    }

    public boolean bcV() {
        return this.eYv;
    }

    public void uW(String str) {
        if (TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.util.ap.isEmpty(str)) {
            if (this.eZy == null) {
                this.eZy = new AddExperiencedModel(getTbPageContext());
                this.eZy.a(this.eZD);
            }
            this.eZy.dP(this.forumId, str);
        }
    }

    public boolean bcW() {
        if (this.eYT) {
            return (this.eYW != null && this.eYW.bhJ() && com.baidu.tieba.frs.a.bbD().bbE()) ? false : true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.e.c
    public boolean videoNeedPreload() {
        if (this.eYi != null) {
            return com.baidu.tbadk.util.ad.aqs() && (this.eYi.isFrsVideoAutoPlay || com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("auto_play_video_frs", 0) == 1);
        }
        return super.videoNeedPreload();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcX() {
        if (!com.baidu.tbadk.core.util.ap.isEmpty(this.forumId)) {
            com.baidu.tbadk.BdToken.c.TX().g(com.baidu.tbadk.BdToken.b.bqI, com.baidu.adp.lib.g.b.d(this.forumId, 0L));
        }
    }
}
