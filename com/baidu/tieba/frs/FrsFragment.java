package com.baidu.tieba.frs;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
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
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.h;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.coreExtra.messageCenter.NewsRemindMessage;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.d;
import com.baidu.tieba.deletethread.DeleteThreadHttpResponseMessage;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.a;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.frs.vc.FrsTabViewController;
import com.baidu.tieba.frs.view.FrsHeaderViewContainer;
import com.baidu.tieba.pb.data.ContriInfo;
import com.baidu.tieba.pb.data.PbFloorAgreeResponseMessage;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.tbadkCore.d;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsPage.RecmForumInfo;
import tbclient.WindowToast;
/* loaded from: classes6.dex */
public class FrsFragment extends BaseFragment implements BdListView.e, a.InterfaceC0073a, NavigationBar.a, UserIconBox.b<BdRecyclerView>, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, ah, ak, am, com.baidu.tieba.frs.loadmore.a, com.baidu.tieba.frs.mc.j, com.baidu.tieba.recapp.n {
    public static boolean dKI = false;
    public static volatile long dKT = 0;
    public static volatile long dKU = 0;
    public static volatile int mNetError = 0;
    private com.baidu.adp.lib.e.b<TbImageView> aKP;
    private com.baidu.tieba.frs.gametab.b bYD;
    private com.baidu.tbadk.util.t biO;
    private com.baidu.tbadk.core.dialog.a cZR;
    private com.baidu.tieba.frs.entelechy.b dKD;
    private com.baidu.tieba.tbadkCore.data.e dKN;
    private VoiceManager dKQ;
    private com.baidu.tieba.NEGFeedBack.a dLA;
    private com.baidu.tieba.ala.a dLB;
    private com.baidu.tbadk.core.dialog.h dLC;
    private com.baidu.tieba.frs.brand.buttommenu.a dLD;
    private AddExperiencedModel dLE;
    private boolean dLG;
    private int dLO;
    private FrsModelController dLb;
    private com.baidu.tieba.frs.vc.f dLc;
    private FrsTabViewController dLd;
    private com.baidu.tieba.frs.mc.f dLe;
    private com.baidu.tieba.frs.smartsort.b dLf;
    private com.baidu.tieba.frs.mc.b dLg;
    private an dLh;
    private com.baidu.tieba.frs.entelechy.b.b dLj;
    private com.baidu.tbadk.i.a dLk;
    private com.baidu.tieba.frs.vc.a dLl;
    private com.baidu.tieba.frs.mc.d dLm;
    private com.baidu.tieba.frs.mc.c dLn;
    private com.baidu.tieba.frs.vc.h dLo;
    private com.baidu.tieba.frs.mc.a dLp;
    private com.baidu.tieba.frs.live.a dLq;
    private j dLr;
    public com.baidu.tieba.frs.vc.c dLs;
    private com.baidu.tieba.frs.mc.e dLt;
    private int dLu;
    private View.OnTouchListener dLv;
    private com.baidu.tieba.frs.view.a dLw;
    private com.baidu.tieba.frs.vc.e dLx;
    private boolean dLy;
    public View mRootView;
    public boolean dKE = false;
    private boolean dKF = false;
    private boolean dKG = false;
    private boolean dKH = true;
    public String dKJ = null;
    public String mFrom = null;
    public int mFlag = 0;
    public boolean dKK = false;
    private boolean dKL = false;
    private String mThreadId = null;
    public String forumId = null;
    private int dKw = 0;
    private boolean dKM = false;
    private boolean dKO = false;
    private boolean dKP = false;
    private k dKR = null;
    public final bb bNy = null;
    private com.baidu.tieba.tbadkCore.l dKt = new com.baidu.tieba.tbadkCore.l();
    public long dru = -1;
    public long bfY = 0;
    public long bfQ = 0;
    public long createTime = 0;
    public long beginTime = -1;
    public long dKS = 0;
    public Pair<Integer, Integer> dKV = null;
    public boolean dKW = false;
    private boolean dKX = false;
    private boolean dKY = false;
    public com.baidu.tbadk.l.b dKZ = null;
    private boolean dLa = true;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> dLi = new SparseArray<>();
    private boolean bRW = true;
    private boolean dLz = false;
    private boolean hasInit = false;
    private boolean dLF = false;
    private AddExperiencedModel.a dLH = new AddExperiencedModel.a() { // from class: com.baidu.tieba.frs.FrsFragment.1
        @Override // com.baidu.tieba.share.AddExperiencedModel.a
        public void b(ContriInfo contriInfo) {
            if (contriInfo != null && contriInfo.isShowToast()) {
                FrsFragment.this.a(contriInfo);
            }
        }
    };
    private HttpMessageListener dLI = new HttpMessageListener(CmdConfigHttp.CMD_PB_FLOOR_AGREE, true) { // from class: com.baidu.tieba.frs.FrsFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof PbFloorAgreeResponseMessage)) {
                PbFloorAgreeResponseMessage pbFloorAgreeResponseMessage = (PbFloorAgreeResponseMessage) httpResponsedMessage;
                if (pbFloorAgreeResponseMessage.getContriInfo() != null && pbFloorAgreeResponseMessage.getContriInfo().isShowToast()) {
                    FrsFragment.this.a(pbFloorAgreeResponseMessage.getContriInfo());
                }
            }
        }
    };
    private final CustomMessageListener dLJ = new CustomMessageListener(2016495) { // from class: com.baidu.tieba.frs.FrsFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof bb) {
                    com.baidu.tieba.frs.f.h.a(FrsFragment.this.dKR, FrsFragment.this.dKt, FrsFragment.this.getForumId(), true, (bb) data);
                }
            }
        }
    };
    private CustomMessageListener dLK = new CustomMessageListener(2921005) { // from class: com.baidu.tieba.frs.FrsFragment.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.dKt != null) {
                FrsFragment.this.dKt.bDl();
                if (FrsFragment.this.dKR != null) {
                    FrsFragment.this.dKR.notifyDataChanged();
                }
            }
        }
    };
    private CustomMessageListener dLL = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.FrsFragment.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 1) {
                    FrsFragment.this.aBH();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                }
            }
        }
    };
    private final al dLM = new al() { // from class: com.baidu.tieba.frs.FrsFragment.34
        @Override // com.baidu.tieba.frs.al
        public void a(int i, int i2, ar arVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
            FrsFragment.this.aBA();
            if (FrsFragment.this.dLj != null) {
                FrsFragment.this.dLc.hr(FrsFragment.this.dLj.mL(i));
            }
            d.a aVar = new d.a();
            if (arVar != null) {
                aVar.isSuccess = arVar.errCode == 0;
                aVar.errorCode = arVar.errCode;
                aVar.errorMsg = arVar.errMsg;
                if (aVar.isSuccess) {
                    if (com.baidu.tbadk.core.util.v.I(arrayList)) {
                        FrsFragment.this.dKR.abd();
                    } else if (arVar.hasMore) {
                        if (com.baidu.tbadk.core.util.v.H(FrsFragment.this.dKt.getThreadList()) > 3) {
                            FrsFragment.this.dKR.abb();
                        } else {
                            FrsFragment.this.dKR.aCI();
                        }
                    } else if (arVar.dOG) {
                        FrsFragment.this.dKR.abc();
                    } else {
                        FrsFragment.this.dKR.abd();
                    }
                }
            } else {
                arVar = new ar();
                arVar.pn = 1;
                arVar.hasMore = false;
                arVar.dOG = false;
            }
            if (i == 1) {
                FrsFragment.this.dLa = true;
                FrsFragment.this.dLY.a(FrsFragment.this.dLb.getType(), false, aVar);
            } else {
                FrsFragment.this.a(aVar);
                if (FrsFragment.this.dLb.aGB() != null) {
                    FrsFragment.this.dKt = FrsFragment.this.dLb.aGB();
                }
                FrsFragment.this.aBJ();
            }
            if (FrsFragment.this.dMf != null) {
                FrsFragment.this.dMf.a(i, i2, arVar, arrayList);
            }
        }
    };
    private FrsTabViewController.a dLN = new FrsTabViewController.a() { // from class: com.baidu.tieba.frs.FrsFragment.35
        @Override // com.baidu.tieba.frs.vc.FrsTabViewController.a
        public void fW(int i) {
            boolean z = false;
            if (i != 1) {
                com.baidu.tieba.card.v.aqs().fv(false);
                FrsFragment.this.gs(false);
            }
            if (i == 303 && i != FrsFragment.this.dLO) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13121").aA(ImageViewerConfig.FORUM_ID, FrsFragment.this.forumId).aA("uid", TbadkCoreApplication.getCurrentAccount()));
            }
            FrsFragment.this.dLO = i;
            FrsFragment.this.aBM();
            com.baidu.tieba.frs.e.d.dSZ.eeg = i;
            com.baidu.tieba.frs.e.d.dSZ.eeh = -1;
            com.baidu.tieba.frs.a aAJ = com.baidu.tieba.frs.a.aAJ();
            if (i == 1 && FrsFragment.this.dLF) {
                z = true;
            }
            aAJ.x(z, true);
        }
    };
    private CustomMessageListener dLP = new CustomMessageListener(2001606) { // from class: com.baidu.tieba.frs.FrsFragment.36
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                FrsFragment.this.dLd.nN(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    };
    private CustomMessageListener dLQ = new CustomMessageListener(2001607) { // from class: com.baidu.tieba.frs.FrsFragment.37
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && ((Integer) customResponsedMessage.getData()).intValue() == 51 && FrsFragment.this.dKt != null) {
                com.baidu.tieba.frs.f.j.a(FrsFragment.this.dKt, FrsFragment.this.getPageContext());
            }
        }
    };
    private final CustomMessageListener dLR = new CustomMessageListener(2003019) { // from class: com.baidu.tieba.frs.FrsFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                FrsFragment.this.dLd.nL(49);
            }
        }
    };
    private final CustomMessageListener dLS = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.frs.FrsFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && FrsFragment.this.dKt != null && FrsFragment.this.dKt.bgT() != null) {
                SignData signData = (SignData) customResponsedMessage.getData();
                int user_level = FrsFragment.this.dKt.bgT().getUser_level();
                if (signData.forumId != null && signData.forumId.equals(FrsFragment.this.dKt.bgT().getId())) {
                    FrsFragment.this.dKt.d(signData);
                    FrsFragment.this.dLc.j(FrsFragment.this.dKt);
                    if (FrsFragment.this.dLc.aId()) {
                        i = FrsFragment.this.dKt.bgT().getUser_level();
                        if (user_level >= i) {
                            i++;
                        }
                    } else {
                        i = user_level;
                    }
                    TbadkCoreApplication.getInst().addSignedForum(FrsFragment.this.dKt.bgT().getName(), signData.sign_bonus_point, i);
                }
            }
        }
    };
    private final CustomMessageListener dLT = new CustomMessageListener(2001352) { // from class: com.baidu.tieba.frs.FrsFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.r) && FrsFragment.this.dKt != null) {
                FrsFragment.this.dKt.c((com.baidu.tieba.tbadkCore.r) customResponsedMessage.getData());
                FrsFragment.this.dLc.i(FrsFragment.this.dKt);
                FrsFragment.this.dLd.a(FrsFragment.this.dKt, FrsFragment.this.dLb.aHh());
            }
        }
    };
    private final AntiHelper.a dLU = new AntiHelper.a() { // from class: com.baidu.tieba.frs.FrsFragment.5
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12536").x("obj_locate", as.a.aCO));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12535").x("obj_locate", as.a.aCO));
        }
    };
    private CustomMessageListener bVn = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.frs.FrsFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(FrsFragment.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().aPt != null) {
                        if (AntiHelper.a(FrsFragment.this.getActivity(), updateAttentionMessage.getData().aPt, FrsFragment.this.dLU) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12534").x("obj_locate", as.a.aCO));
                        }
                    } else if (updateAttentionMessage.getData().Jr && updateAttentionMessage.getData().isAttention) {
                        com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getPageContext().getPageActivity(), e.j.attention_success);
                    }
                }
            }
        }
    };
    private CustomMessageListener dLV = new CustomMessageListener(2921346) { // from class: com.baidu.tieba.frs.FrsFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsFragment.this.refresh();
        }
    };
    private CustomMessageListener dLW = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.frs.FrsFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                FrsFragment.this.dKR.c((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener dLX = new CustomMessageListener(2001626) { // from class: com.baidu.tieba.frs.FrsFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewsRemindMessage newsRemindMessage;
            if (customResponsedMessage != null && (customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626 && (newsRemindMessage = (NewsRemindMessage) customResponsedMessage) != null) {
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (FrsFragment.this.dKR != null) {
                    FrsFragment.this.dKR.p(notificationCount, z);
                }
            }
        }
    };
    private final CustomMessageListener akA = new CustomMessageListener(2921383) { // from class: com.baidu.tieba.frs.FrsFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.isResumed()) {
                FrsFragment.this.aBW();
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.n dLY = new com.baidu.tieba.tbadkCore.n() { // from class: com.baidu.tieba.frs.FrsFragment.11
        private long startTime = 0;

        @Override // com.baidu.tieba.tbadkCore.n
        public void ml(int i) {
            this.startTime = System.nanoTime();
            if (FrsFragment.this.dKR != null) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsFragment.this.dKR.aCu();
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
        public void a(int i, boolean z, d.a aVar) {
            if (FrsFragment.this.bRW) {
                FrsFragment.this.bRW = false;
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.dKR, FrsFragment.this.dKt, FrsFragment.this.getForumId(), false, null);
            }
            FrsFragment.this.aBA();
            FrsFragment.this.dKX = true;
            if (aVar != null && aVar.isSuccess) {
                FrsFragment.this.dKR.aCE().hd(com.baidu.tbadk.core.util.aq.DR().DT());
                FrsFragment.dKT = 0L;
                FrsFragment.dKU = 0L;
                FrsFragment.mNetError = 0;
            } else {
                FrsFragment.mNetError = 1;
            }
            if (!FrsFragment.this.dLb.aHl() && (i == 3 || i == 6)) {
                FrsFragment.this.dLn.resetData();
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (FrsFragment.this.dLb.aGB() != null) {
                FrsFragment.this.dKt = FrsFragment.this.dLb.aGB();
            }
            FrsFragment.this.dKR.b(FrsFragment.this.dKt.bCS());
            FrsFragment.this.mi(1);
            if (i == 7) {
                FrsFragment.this.mj(FrsFragment.this.dKt.bCx());
                return;
            }
            if (FrsFragment.this.dKt.yS() != null) {
                FrsFragment.this.setHasMore(FrsFragment.this.dKt.yS().yP());
            }
            if (i == 4) {
                if (!FrsFragment.this.dLb.aHl() && TbadkCoreApplication.getInst().isRecAppExist() && FrsFragment.this.dLb.aHb() == 1) {
                    FrsFragment.this.dKt.a(FrsFragment.this);
                }
                ArrayList<com.baidu.adp.widget.ListView.h> a2 = FrsFragment.this.dLn.a(false, false, FrsFragment.this.dKt.getThreadList(), FrsFragment.this.dKN, false);
                if (a2 != null) {
                    FrsFragment.this.dKt.ay(a2);
                    FrsFragment.this.dKt.bDb();
                    FrsFragment.this.dKR.a(a2, FrsFragment.this.dKt);
                }
                if (FrsFragment.this.dLb != null) {
                    com.baidu.tieba.frs.e.c.a(FrsFragment.this.dKt, FrsFragment.this.dLb.aHh(), 2);
                }
                com.baidu.tieba.frs.f.a.a(FrsFragment.this, FrsFragment.this.dKt.bgT(), FrsFragment.this.dKt.getThreadList(), false, FrsFragment.this.getPn());
                FrsFragment.this.bfY = System.currentTimeMillis() - currentTimeMillis;
                FrsFragment.this.aBB();
                return;
            }
            FrsFragment.this.aBB();
            switch (i) {
                case 1:
                    FrsFragment.this.dKR.aCu();
                    break;
                case 2:
                    FrsFragment.this.dKR.aCu();
                    break;
                case 3:
                case 6:
                    if (FrsFragment.this.dKt != null) {
                        FrsFragment.this.dKt.bCZ();
                    }
                    if (FrsFragment.this.dLs != null) {
                        FrsFragment.this.dLs.refresh();
                        break;
                    }
                    break;
            }
            FrsFragment.this.aBC();
            if (aVar == null || aVar.errorCode == 0) {
                if (FrsFragment.this.dKt != null) {
                    FrsFragment.this.A(false, i == 5);
                    if (FrsFragment.this.dLb != null) {
                        com.baidu.tieba.frs.e.a.a(FrsFragment.this.getUniqueId(), FrsFragment.this.dKt.getThreadList(), FrsFragment.this.dKt.bgT(), FrsFragment.this.dLb.acb());
                    }
                    FrsFragment.this.dKR.mt(i);
                    FrsFragment.dKT = (System.nanoTime() - this.startTime) / 1000000;
                    if (aVar != null) {
                        FrsFragment.dKU = aVar.hld;
                    }
                } else {
                    return;
                }
            } else if (FrsFragment.this.dKt == null || com.baidu.tbadk.core.util.v.I(FrsFragment.this.dKt.getThreadList())) {
                FrsFragment.this.a(aVar);
            } else if (aVar.hlc) {
                FrsFragment.this.showToast(FrsFragment.this.getPageContext().getResources().getString(e.j.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
            }
            if (FrsFragment.this.dKt.bCh() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11384"));
            }
            if (FrsFragment.this.dru > -1 && !FrsFragment.this.dLz) {
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.dLb, FrsFragment.this.dru);
                FrsFragment.this.dru = -1L;
                FrsFragment.this.dLz = true;
            }
            if (FrsFragment.this.dKO && FrsFragment.this.dLd.nL(49)) {
                FrsFragment.this.dKO = false;
            }
            FrsFragment.this.bfY = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void b(com.baidu.tieba.tbadkCore.i iVar) {
            if ((iVar != null && ("normal_page".equals(FrsFragment.this.dLb.getPageType()) || "frs_page".equals(FrsFragment.this.dLb.getPageType()) || "book_page".equals(FrsFragment.this.dLb.getPageType()))) || "brand_page".equals(FrsFragment.this.dLb.getPageType())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001615, iVar));
                FrsFragment.this.a(iVar);
            }
        }
    };
    private final CustomMessageListener dLZ = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.frs.FrsFragment.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                FrsFragment.this.dKt.a((com.baidu.tbadk.data.j) customResponsedMessage.getData());
                FrsFragment.this.dKR.aCE().notifyDataSetChanged();
            }
        }
    };
    private final CustomMessageListener mMemListener = new CustomMessageListener(2001194) { // from class: com.baidu.tieba.frs.FrsFragment.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && FrsFragment.this.dKt != null && (userData = FrsFragment.this.dKt.getUserData()) != null) {
                userData.setIsMem(num.intValue());
                if (num.intValue() != 0) {
                    FrsFragment.this.dLc.g(num);
                }
            }
        }
    };
    private final com.baidu.tieba.frs.mc.i dMa = new com.baidu.tieba.frs.mc.i() { // from class: com.baidu.tieba.frs.FrsFragment.19
        @Override // com.baidu.tieba.frs.mc.i
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.h> arrayList, boolean z3) {
            if (FrsFragment.this.dLf != null && FrsFragment.this.dLb != null && FrsFragment.this.dLb.aHl() && z && !z2 && !z3) {
                FrsFragment.this.dLf.nq(i2);
            }
        }
    };
    public final View.OnTouchListener biP = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.FrsFragment.20
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (FrsFragment.this.dLv != null) {
                FrsFragment.this.dLv.onTouch(view, motionEvent);
            }
            if (FrsFragment.this.dLh != null && FrsFragment.this.dLh.aDp() != null) {
                FrsFragment.this.dLh.aDp().onTouchEvent(motionEvent);
            }
            if (FrsFragment.this.bYD != null) {
                FrsFragment.this.bYD.d(view, motionEvent);
            }
            if (FrsFragment.this.dLc != null) {
                FrsFragment.this.dLc.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private final CustomMessageListener dMb = new CustomMessageListener(2004507) { // from class: com.baidu.tieba.frs.FrsFragment.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "photolive_hostLevel", -1) != -1 && FrsFragment.this.dKt.bgT() != null) {
                FrsFragment.this.dKt.bgT().setCanAddPhotoLivePost(true);
            }
        }
    };
    public final View.OnClickListener dMc = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.24
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsFragment.this.dKR == null || view != FrsFragment.this.dKR.aCs() || FrsFragment.this.getActivity() == null) {
                if (FrsFragment.this.dKt != null && FrsFragment.this.dKt.bgT() != null && FrsFragment.this.dKR != null && view == FrsFragment.this.dKR.aCy()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12402").aA(ImageViewerConfig.FORUM_ID, FrsFragment.this.dKt.bgT().getId()).aA("uid", TbadkCoreApplication.getCurrentAccount()).aA(ImageViewerConfig.FORUM_NAME, FrsFragment.this.dKt.bgT().getName()));
                    if (!StringUtils.isNull(FrsFragment.this.dKt.bgT().getName())) {
                        FrsFragment.this.sendMessage(new CustomMessage(2002001, new PostSearchActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), FrsFragment.this.dKt.bgT().getName(), FrsFragment.this.dKt.bgT().getId())));
                        return;
                    }
                    return;
                }
                if (view.getId() == e.g.game_activity_egg_layout && com.baidu.adp.lib.util.l.ll()) {
                    TiebaStatic.log("c10853");
                    if (FrsFragment.this.dKR.aCB()) {
                        FrsFragment.this.dKR.aCC();
                    } else {
                        String activityUrl = FrsFragment.this.dKt.bgT().getYuleData().By().getActivityUrl();
                        if (!StringUtils.isNull(activityUrl)) {
                            com.baidu.tbadk.browser.a.af(FrsFragment.this.getPageContext().getPageActivity(), activityUrl);
                        }
                    }
                }
                if (view == FrsFragment.this.dKR.aCJ() && FrsFragment.this.dLb != null && FrsFragment.this.dLb.hasMore()) {
                    FrsFragment.this.dKR.abb();
                    FrsFragment.this.aad();
                }
                if (view != null && view == FrsFragment.this.dKR.aCz() && ba.bJ(FrsFragment.this.getContext())) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12924").x("obj_locate", 2));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(FrsFragment.this.getContext())));
                    return;
                }
                return;
            }
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
            customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, FrsFragment.this.getPageContext().getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.FrsFragment.25
        private int dMj = 0;
        private int bNd = 0;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (FrsFragment.this.dLl != null) {
                FrsFragment.this.dLl.aHI();
            }
            this.dMj = 0;
            this.bNd = 0;
            if (recyclerView != null && (recyclerView instanceof BdRecyclerView)) {
                this.dMj = ((BdRecyclerView) recyclerView).getFirstVisiblePosition();
                this.bNd = ((BdRecyclerView) recyclerView).getLastVisiblePosition();
            }
            if (FrsFragment.this.dLx != null) {
                FrsFragment.this.dLx.a(recyclerView, this.dMj, this.bNd);
            }
            if (FrsFragment.this.dKt != null && FrsFragment.this.dKR != null && FrsFragment.this.dKR.aCE() != null) {
                FrsFragment.this.dKR.aM(this.dMj, this.bNd);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (FrsFragment.this.dLc != null) {
                FrsFragment.this.dLc.setScrollState(i);
            }
            if ((i == 2 || i == 1) && !FrsFragment.this.dKY) {
                FrsFragment.this.dKY = true;
                FrsFragment.this.dKR.aCH();
            }
            if (FrsFragment.this.dKZ == null && !FrsFragment.this.aBQ()) {
                FrsFragment.this.dKZ = new com.baidu.tbadk.l.b();
                FrsFragment.this.dKZ.gj(1000);
            }
            if (i == 0) {
                if (FrsFragment.this.dKZ != null) {
                    FrsFragment.this.dKZ.Pc();
                }
                com.baidu.tieba.card.v.aqs().fv(true);
                FrsFragment.this.gs(true);
                FrsFragment.this.dKR.aL(this.dMj, this.bNd);
            } else if (FrsFragment.this.dKZ != null) {
                FrsFragment.this.dKZ.Pb();
            }
            if (FrsFragment.this.dLx != null) {
                FrsFragment.this.dLx.onScrollStateChanged(recyclerView, i);
            }
            if (i == 0) {
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.dKR, FrsFragment.this.dKt, FrsFragment.this.getForumId(), false, null);
            }
            if (FrsFragment.this.dLd != null && i == 1) {
                FrsFragment.this.dLd.aIn();
            }
        }
    };
    private final d dMd = new d() { // from class: com.baidu.tieba.frs.FrsFragment.26
        @Override // com.baidu.tieba.frs.d
        public void a(int i, int i2, View view, View view2, bb bbVar) {
            if (i != FrsFragment.this.dKR.aCE().aED()) {
                if (i != FrsFragment.this.dKR.aCE().aEE()) {
                    if (i == FrsFragment.this.dKR.aCE().aEF() && FrsFragment.this.dKt != null && FrsFragment.this.dKt.getUserData() != null && FrsFragment.this.dKt.getUserData().isBawu()) {
                        String bCv = FrsFragment.this.dKt.bCv();
                        if (!com.baidu.tbadk.core.util.ao.isEmpty(bCv) && FrsFragment.this.dKt.bgT() != null) {
                            com.baidu.tbadk.browser.a.ad(FrsFragment.this.getPageContext().getPageActivity(), bCv);
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10502").aA(ImageViewerConfig.FORUM_ID, FrsFragment.this.dKt.bgT().getId()).aA("uid", FrsFragment.this.dKt.getUserData().getUserId()));
                        }
                    }
                } else if (ba.bJ(FrsFragment.this.getPageContext().getPageActivity())) {
                    TiebaStatic.log("my_service_ck");
                    if (FrsFragment.this.dKt != null && FrsFragment.this.dKt.bgT() != null) {
                        ForumData bgT = FrsFragment.this.dKt.bgT();
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(bgT.getId(), 0L), bgT.getName(), bgT.getImage_url(), 0)));
                    }
                }
            } else if (ba.bJ(FrsFragment.this.getActivity())) {
                TiebaStatic.log("forum_fortune_click");
                com.baidu.tieba.frs.f.i.b(FrsFragment.this.getPageContext(), FrsFragment.this.dKt);
            }
        }
    };
    private final NoNetworkView.a dID = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.FrsFragment.27
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bF(boolean z) {
            if (FrsFragment.this.dLb.aHb() == 1 && z && !FrsFragment.this.dKR.aBP()) {
                if (FrsFragment.this.dKt == null || com.baidu.tbadk.core.util.v.I(FrsFragment.this.dKt.getThreadList())) {
                    FrsFragment.this.hideNetRefreshView(FrsFragment.this.dKR.aCF());
                    FrsFragment.this.showLoadingView(FrsFragment.this.dKR.aCF(), true);
                    FrsFragment.this.dKR.gC(false);
                    FrsFragment.this.refresh();
                    return;
                }
                FrsFragment.this.dKR.aCu();
            }
        }
    };
    private final CustomMessageListener aPW = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.FrsFragment.28
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                com.baidu.tieba.frs.f.c.a(customResponsedMessage, FrsFragment.this.dKR, FrsFragment.this.dKt);
            }
        }
    };
    private com.baidu.adp.widget.ListView.n dMe = new a();
    private al dMf = new al() { // from class: com.baidu.tieba.frs.FrsFragment.29
        @Override // com.baidu.tieba.frs.al
        public void a(int i, int i2, ar arVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
            com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.29.1
                @Override // java.lang.Runnable
                public void run() {
                    if (FrsFragment.this.dKR != null && FrsFragment.this.dKR.aro()) {
                        FrsFragment.this.aad();
                    }
                }
            });
        }
    };
    private CustomMessageListener dMg = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.frs.FrsFragment.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    FrsFragment.this.dLy = true;
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.frs.loadmore.a
    public /* bridge */ /* synthetic */ com.baidu.adp.base.e getPageContext() {
        return super.getPageContext();
    }

    public com.baidu.tieba.frs.entelechy.b.b aBo() {
        return this.dLj;
    }

    public com.baidu.adp.widget.ListView.n aBp() {
        return this.dMe;
    }

    public com.baidu.tieba.frs.mc.d aBq() {
        return this.dLm;
    }

    public com.baidu.tieba.frs.smartsort.b aBr() {
        return this.dLf;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public FrsModelController aBs() {
        return this.dLb;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public com.baidu.tieba.frs.mc.c aBt() {
        return this.dLn;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public com.baidu.tieba.frs.vc.f aBu() {
        return this.dLc;
    }

    public com.baidu.tieba.frs.vc.k aBv() {
        return this.dLd;
    }

    public an aBw() {
        return this.dLh;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public k aBx() {
        return this.dKR;
    }

    @Override // com.baidu.tieba.frs.am
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.am, com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.dKJ;
    }

    public void setForumName(String str) {
        this.dKJ = str;
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
        if (this.dLn == null) {
            return 1;
        }
        return this.dLn.getPn();
    }

    public int getPn() {
        if (this.dLn == null) {
            return 1;
        }
        return this.dLn.getPn();
    }

    public void setPn(int i) {
        if (this.dLn != null) {
            this.dLn.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.dLn != null) {
            this.dLn.setHasMore(i);
        }
    }

    public int aBy() {
        if (this.dLn == null) {
            return -1;
        }
        return this.dLn.aBy();
    }

    public boolean aBz() {
        return this.dKP;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d.a aVar) {
        if (aVar == null) {
            String string = TbadkCoreApplication.getInst().getString(e.j.error_unkown_try_again);
            this.dKR.aCp();
            showNetRefreshView(this.dKR.aCF(), string, true);
        } else if (340001 == aVar.errorCode) {
            a(aVar, this.dKt.bCe());
        } else {
            if (com.baidu.tbadk.core.util.v.I(this.dKt.getThreadList())) {
                b(aVar);
            }
            if (aBQ()) {
                setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst(), e.C0210e.ds280));
            } else {
                setNetRefreshViewEmotionDefMarginTop();
            }
        }
    }

    public void a(View view, String str, boolean z, List<RecmForumInfo> list) {
        this.dKR.aCp();
        this.dKR.mp(8);
        if (this.dLw == null) {
            this.dLw = new com.baidu.tieba.frs.view.a(getPageContext(), getNetRefreshListener());
        }
        this.dLw.io(str);
        this.dLw.bT(list);
        this.dLw.attachView(view, z);
    }

    private void a(d.a aVar, List<RecmForumInfo> list) {
        if (this.dKR != null) {
            this.dKR.aCp();
            this.dKR.setTitle(this.dKJ);
            a(this.dKR.aCF(), aVar.errorMsg, true, list);
        }
    }

    private void b(d.a aVar) {
        this.dKR.aCp();
        if (aVar.hlc) {
            showNetRefreshView(this.dKR.aCF(), TbadkCoreApplication.getInst().getString(e.j.net_error_text, new Object[]{aVar.errorMsg, Integer.valueOf(aVar.errorCode)}), true);
        } else {
            showNetRefreshView(this.dKR.aCF(), aVar.errorMsg, true);
        }
    }

    public void aBA() {
        hideLoadingView(this.dKR.aCF());
        if (!this.dKR.aBP()) {
            this.dKR.gD(false);
        } else {
            this.dKR.gD(true);
        }
        if (this.dKR.aCn() instanceof com.baidu.tieba.frs.tab.c) {
            ((com.baidu.tieba.frs.tab.c) this.dKR.aCn()).aHD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBB() {
        if (aBy() == 0 && com.baidu.tbadk.core.util.v.I(this.dKt.bCn())) {
            if (com.baidu.tbadk.core.util.v.I(this.dKt.getThreadList())) {
                this.dKR.abd();
            } else {
                this.dKR.abc();
            }
        } else if (com.baidu.tbadk.core.util.v.H(this.dKt.getThreadList()) > 3) {
            this.dKR.abb();
        } else {
            this.dKR.aCI();
        }
    }

    public void a(ErrorData errorData) {
        aBA();
        this.dKR.aCu();
        d.a aGY = this.dLb.aGY();
        boolean I = com.baidu.tbadk.core.util.v.I(this.dKt.getThreadList());
        if (aGY != null && I) {
            if (this.dLb.aGZ() != 0) {
                this.dLb.aHf();
                this.dKR.aCu();
            } else {
                a(aGY);
            }
            this.dKR.B(this.dKt.bDs(), false);
            return;
        }
        a(aGY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mi(int i) {
        List<WindowToast> list;
        if (TbadkCoreApplication.isLogin() && this.dKt != null && (list = this.dKt.hmG) != null && list.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < list.size()) {
                    WindowToast windowToast = list.get(i3);
                    if (windowToast == null || windowToast.toast_type.intValue() != i) {
                        i2 = i3 + 1;
                    } else if (!com.baidu.tbadk.core.util.ao.isEmpty(windowToast.toast_link)) {
                        sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(getPageContext().getPageActivity(), "", com.baidu.tbadk.util.ab.iR(windowToast.toast_link), true)));
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
    public void aBC() {
        if (this.dKt == null || this.dKt.bgT() != null) {
            this.dKR.aCD();
        } else if (this.dKt.bgT().getYuleData() != null && this.dKt.bgT().getYuleData().Bx()) {
            TiebaStatic.log("c10852");
            this.dKR.a(this.dKt.bgT().getYuleData().By());
        } else {
            this.dKR.aCD();
        }
    }

    private void z(boolean z, boolean z2) {
        if (this.dLb != null && this.dKt != null && this.dKR != null && z) {
            if (!this.dLb.aHl() && this.dLb.aHb() == 1) {
                if (!this.dLb.aHj()) {
                    this.dKt.bDh();
                    this.dKt.bDi();
                }
                boolean z3 = false;
                if (this.dKR.aCE().k(com.baidu.tieba.card.data.n.dbi)) {
                    z3 = this.dKt.bDm();
                }
                if (!z3) {
                    this.dKt.bDk();
                }
                if (TbadkCoreApplication.getInst().isRecAppExist()) {
                    this.dKt.a(this);
                }
                if (!this.dKR.aCE().k(bb.atk)) {
                    this.dKt.bDa();
                }
                this.dKt.bDn();
            }
            if (!this.dKR.aCE().k(bb.atk)) {
                this.dKt.bDg();
                this.dKt.bDe();
            } else {
                this.dKt.bDf();
                this.dKt.bDd();
            }
            this.dKt.bDb();
            this.dKt.bCY();
            if (this.dKR.aCE().k(com.baidu.tieba.h.b.enB)) {
                this.dKt.nt(z2);
            }
            if (TbadkCoreApplication.isLogin() && (!this.dLb.aHl() || this.dLb.isNetFirstLoad)) {
                this.dKt.bDo();
            }
            this.dKt.bDq();
        }
    }

    public boolean aBD() {
        if (this.dLc != null && this.dLb != null) {
            this.dLc.a(this.dLb.getPageType(), this.dKt);
        }
        boolean z = false;
        if (this.dKt != null) {
            z = this.dKt.bDt();
        }
        aBF();
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mj(int i) {
        ao aoVar = null;
        aBD();
        aBM();
        try {
            if (this.dKt != null) {
                this.dKR.a((ArrayList<com.baidu.adp.widget.ListView.h>) null, this.dKt);
                this.dLc.nG(1);
                this.dKR.aCx();
                this.dLd.a(this.dKt, this.dLb.aHh());
                com.baidu.tieba.frs.tab.d nM = this.dLd.nM(this.dKt.bCx());
                if (nM != null && !TextUtils.isEmpty(nM.url)) {
                    aoVar = new ao();
                    aoVar.dOD = nM.url;
                    aoVar.stType = nM.name;
                }
                this.dLb.a(this.dKt.bCx(), 0, aoVar);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(boolean z, boolean z2) {
        try {
            if (this.dKt != null && this.dLd != null && this.dLb != null) {
                if (!this.dKR.aCE().k(bb.atk)) {
                    this.dKt.bDa();
                }
                boolean I = com.baidu.tbadk.core.util.v.I(this.dKt.bCL());
                this.dKR.gA(I);
                if (!I) {
                    if (this.dLx == null) {
                        this.dLx = new com.baidu.tieba.frs.vc.e(this, (NoPressedRelativeLayout) this.mRootView);
                    }
                    if (this.bYD == null) {
                        this.bYD = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
                    }
                } else {
                    this.dLx = null;
                    this.bYD = null;
                }
                if (this.dKt.bgT() != null) {
                    this.dKJ = this.dKt.bgT().getName();
                    this.forumId = this.dKt.bgT().getId();
                }
                if (this.dKt.bDt()) {
                    this.dLd.a(this.dKt, this.dLb.aHh());
                }
                if (z) {
                    z(true, z);
                } else {
                    z(this.dLa, z);
                }
                aBD();
                if (this.dLj != null) {
                    this.dLj.a(this.dLc, this.dKt);
                }
                if (this.dKt.yS() != null) {
                    setHasMore(this.dKt.yS().yP());
                }
                ArrayList<com.baidu.adp.widget.ListView.h> a2 = this.dLn.a(z2, true, this.dKt.getThreadList(), null, z, false);
                if (a2 != null) {
                    this.dKt.ay(a2);
                }
                this.dKt.bDp();
                if (this.dLb.aHb() == 1) {
                    aBJ();
                    if (!z && this.dLb.getPn() == 1) {
                        aBE();
                    }
                }
                this.dKw = this.dKt.aHd();
                if (this.dKN != null) {
                    this.dKM = true;
                    this.dKN.vE(this.dKw);
                    com.baidu.tieba.frs.f.a.a(this, this.dKt.bgT(), this.dKt.getThreadList(), this.dKM, getPn());
                }
                if (this.dLl != null) {
                    this.dLl.aV(this.dLd.aIk());
                }
                aBA();
                this.dKR.aCq();
                this.dKR.B(true, false);
                if (this.dKt.bgT() != null) {
                    this.dKR.od(this.dKt.bgT().getWarningMsg());
                }
                if (this.dKt != null && this.dKt.bCO() != null && com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("frs_video_activity_guide", 0L) == 0) {
                    com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.13
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsFragment.this.dKR.aCN();
                        }
                    }, 1000L);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2921326, this));
                this.dKR.aCj();
                if (this.dKt != null && this.dKt.bgT() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016564, new VisitedForumData(this.dKt.bgT().getId(), this.dKt.bgT().getName(), this.dKt.bgT().getImage_url(), String.valueOf(System.currentTimeMillis() / 1000), "showlive".equals(this.dKt.bgT().special_forum_type))));
                }
                this.dLD.a(this.dKt.hmL, this.dKt.bgT());
                aBW();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void gs(boolean z) {
        com.baidu.tieba.q.c.bBT().b(getUniqueId(), z);
    }

    public void aBE() {
        if (this.dLq == null) {
            this.dLq = new com.baidu.tieba.frs.live.a(this, com.baidu.adp.lib.g.b.l(this.forumId, 0));
        }
        this.dLq.aGJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.i iVar) {
        try {
            if (!this.dKX && iVar != null && this.dKt != null) {
                this.dKt.g(iVar);
                A(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void aBF() {
        if (this.dLb != null) {
            ob(this.dLb.getPageType());
        } else {
            ob("normal_page");
        }
    }

    private void ob(String str) {
        gt("frs_page".equals(str));
        if (this.dLj != null) {
            this.dLj.a(this.dLc, this.dKR, this.dKt);
        }
    }

    public void gt(boolean z) {
        if (this.dLo != null) {
            this.dLo.c(this.dKR, z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.q.c.bBT().r(getUniqueId());
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(e.h.frs_activity, viewGroup, false);
            this.dKD = new com.baidu.tieba.frs.entelechy.b();
            this.dLj = this.dKD.aEc();
            this.dLc = new com.baidu.tieba.frs.vc.f(this, this.dKD, (FrsHeaderViewContainer) this.mRootView.findViewById(e.g.header_view_container));
            this.dLd = new FrsTabViewController(this, this.mRootView);
            this.dLd.registerListener();
            this.dLc.a(this.dLd);
            this.dLd.a(this.dLN);
            Intent intent = getActivity().getIntent();
            if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                this.dKF = true;
            }
            this.dKR = new k(this, this.dMc, this.dKD, this.dKF, this.dLc);
            this.dKR.setHeaderViewHeight(this.dLu);
            this.dLD = new com.baidu.tieba.frs.brand.buttommenu.a(getPageContext(), this.mRootView);
        } else {
            if (this.mRootView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            if (this.dLd != null) {
                this.dLd.registerListener();
            }
            this.dKR.aCM();
        }
        this.dLG = true;
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        this.dru = System.currentTimeMillis();
        this.beginTime = this.dru;
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.dKO = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.dru = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            M(intent);
        }
        this.bfQ = this.beginTime - this.dru;
        this.dKN = new com.baidu.tieba.tbadkCore.data.e("frs", com.baidu.tieba.tbadkCore.data.e.hnW);
        if (this.dLb == null) {
            this.dLb = new FrsModelController(this, this.dLY);
            this.dLb.a(this.dLM);
            this.dLb.init();
        }
        if (intent != null) {
            this.dLb.p(intent.getExtras());
        } else if (bundle != null) {
            this.dLb.p(bundle);
        } else {
            this.dLb.p(null);
        }
        if (intent != null) {
            this.dLc.t(intent.getExtras());
        } else if (bundle != null) {
            this.dLc.t(bundle);
        } else {
            this.dLc.t(null);
        }
        this.dKQ = getVoiceManager();
        this.dLr = new j(getPageContext(), this);
        initUI();
        initData(bundle);
        if (!aBQ()) {
            this.dLh = new an(getActivity(), this.dKR, this.dLc);
            this.dLh.gR(true);
        }
        this.dKQ = getVoiceManager();
        if (this.dKQ != null) {
            this.dKQ.onCreate(getPageContext());
        }
        new com.baidu.tieba.frs.mc.g();
        this.dLn = new com.baidu.tieba.frs.mc.c(this, this.dMa);
        this.dLf = new com.baidu.tieba.frs.smartsort.b(this);
        this.dLo = new com.baidu.tieba.frs.vc.h(this);
        this.dLl = new com.baidu.tieba.frs.vc.a(getPageContext(), this.dLb.aHi());
        this.dLg = new com.baidu.tieba.frs.mc.b(this);
        this.dLm = new com.baidu.tieba.frs.mc.d(this);
        this.dLe = new com.baidu.tieba.frs.mc.f(this);
        this.dLp = new com.baidu.tieba.frs.mc.a(this);
        this.dLs = new com.baidu.tieba.frs.vc.c(this);
        this.dLt = new com.baidu.tieba.frs.mc.e(this, getUniqueId());
        this.dLA = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "frs");
        this.dLB = new com.baidu.tieba.ala.a(getPageContext());
        registerListener(this.bVn);
        registerListener(this.mMemListener);
        registerListener(this.dLT);
        registerListener(this.dMb);
        registerListener(this.dLS);
        registerListener(this.dLZ);
        registerListener(this.dLP);
        registerListener(this.dLQ);
        registerListener(this.dLR);
        registerListener(this.dLJ);
        registerListener(this.dLK);
        registerListener(this.dMg);
        registerListener(this.dLW);
        registerListener(this.dLL);
        registerListener(this.dLX);
        registerListener(this.dLV);
        this.dLI.setTag(getPageContext().getUniqueId());
        registerListener(this.dLI);
        registerListener(this.akA);
        this.dKR.gC(false);
        if (!aBQ() && !this.hasInit) {
            showLoadingView(this.dKR.aCF(), true);
            this.dLb.r(3, false);
        }
        com.baidu.tieba.frs.a.aAJ().a(new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.16
            @Override // com.baidu.tieba.frs.a.b
            public void y(boolean z, boolean z2) {
                if (FrsFragment.this.dKR != null) {
                    FrsFragment.this.dKR.mq(z ? 0 : 8);
                    if (!z2) {
                        FrsFragment.this.dLF = z;
                    }
                    if (FrsFragment.this.dKR.aCE() != null && FrsFragment.this.dLb != null && FrsFragment.this.dLb.aHc()) {
                        FrsFragment.this.dKR.aCE().notifyDataSetChanged();
                    }
                    if (FrsFragment.this.dKR.aCo() != null) {
                        FrsFragment.this.dKR.gz(!z);
                    }
                    if (FrsFragment.this.getActivity() instanceof FrsActivity) {
                        ((FrsActivity) FrsFragment.this.getActivity()).gr(!z);
                    }
                    if (FrsFragment.this.dLD != null) {
                        FrsFragment.this.dLD.ha(!z);
                    }
                    FrsFragment.this.dKR.gE(!z);
                    FrsFragment.this.dKR.gF(z ? false : true);
                }
            }

            @Override // com.baidu.tieba.frs.a.b
            public void mf(int i) {
                if (FrsFragment.this.dKR != null) {
                    FrsFragment.this.dKR.mr(i);
                }
            }

            @Override // com.baidu.tieba.frs.a.b
            public void aAP() {
                com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getContext(), e.j.frs_multi_delete_max_num);
            }
        });
        this.dKR.b(new d.a() { // from class: com.baidu.tieba.frs.FrsFragment.17
            @Override // com.baidu.tieba.NEGFeedBack.d.a
            public void a(DeleteThreadHttpResponseMessage deleteThreadHttpResponseMessage) {
                int i;
                int i2 = 0;
                if (deleteThreadHttpResponseMessage != null) {
                    FrsFragment.this.dKR.UB();
                    FrsFragment.this.dKR.aCO();
                    if (deleteThreadHttpResponseMessage.getError() == 0) {
                        String text = !TextUtils.isEmpty(deleteThreadHttpResponseMessage.getText()) ? deleteThreadHttpResponseMessage.getText() : FrsFragment.this.getString(e.j.delete_fail);
                        if (deleteThreadHttpResponseMessage.getRetType() == 1211066) {
                            if (FrsFragment.this.cZR == null) {
                                FrsFragment.this.cZR = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.cZR.eB(text);
                            FrsFragment.this.cZR.a(e.j.dialog_known, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.17.1
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.cZR.bg(false);
                            FrsFragment.this.cZR.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.cZR.BF();
                        } else if (deleteThreadHttpResponseMessage.getRetType() == 1211067) {
                            if (FrsFragment.this.cZR == null) {
                                FrsFragment.this.cZR = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.cZR.eB(text);
                            FrsFragment.this.cZR.a(e.j.know, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.17.2
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.cZR.bg(false);
                            FrsFragment.this.cZR.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.cZR.BF();
                        } else {
                            FrsFragment.this.dKR.ad(deleteThreadHttpResponseMessage.getText(), ContextCompat.getColor(FrsFragment.this.getContext(), deleteThreadHttpResponseMessage.getRetType() == 1 ? e.d.nav_bar_tip_error : e.d.cp_link_tip_a_alpha95));
                        }
                        FrsFragment.this.bD(deleteThreadHttpResponseMessage.getSuccessItems());
                        com.baidu.tieba.frs.a.aAJ().bC(deleteThreadHttpResponseMessage.getSuccessItems());
                        Iterator<com.baidu.adp.widget.ListView.h> it = FrsFragment.this.dKt.getThreadList().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                i = i2;
                                break;
                            }
                            i = it.next() instanceof bb ? i2 + 1 : i2;
                            if (i >= 6) {
                                break;
                            }
                            i2 = i;
                        }
                        if (i < 6) {
                            FrsFragment.this.aad();
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

    public void gu(boolean z) {
        if (this.dLd != null) {
            this.dLd.egP = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bD(List<String> list) {
        if (!com.baidu.tbadk.core.util.v.I(list)) {
            ArrayList<com.baidu.adp.widget.ListView.h> threadList = this.dKt.getThreadList();
            if (!com.baidu.tbadk.core.util.v.I(threadList) && this.dKR.getListView() != null && this.dKR.getListView().getData() != null) {
                Iterator<com.baidu.adp.widget.ListView.h> it = threadList.iterator();
                List<com.baidu.adp.widget.ListView.h> data = this.dKR.getListView().getData();
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.h next = it.next();
                    if (next instanceof bb) {
                        bb bbVar = (bb) next;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= list.size()) {
                                break;
                            } else if (!com.baidu.tbadk.core.util.ao.equals(list.get(i2), bbVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(bbVar);
                                this.dLn.ab(bbVar);
                                this.dKR.getListView().getAdapter().notifyItemRemoved(i);
                                break;
                            }
                        }
                    }
                    i++;
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void aaD() {
        if (isAdded() && this.bRW && !isLoadingViewAttached()) {
            showLoadingView(this.dKR.aCF(), true);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void aaE() {
        if (isAdded() && this.bRW && isLoadingViewAttached()) {
            hideLoadingView(this.dKR.aCF());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (aBQ()) {
            showLoadingView(this.dKR.aCF(), true);
            this.dKR.ms(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.dLb.r(3, true);
            Fv().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void setHeaderViewHeight(int i) {
        this.dLu = i;
        if (this.dKR != null) {
            this.dKR.setHeaderViewHeight(this.dLu);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.u uVar) {
        if (uVar != null) {
            this.biO = uVar.Qf();
            this.dLv = uVar.Qg();
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void showFloatingView() {
        if (this.biO != null) {
            this.biO.cS(true);
        }
    }

    private void M(Intent intent) {
        if (intent != null) {
            if (intent != null) {
                if (!com.baidu.tieba.frs.f.f.a(this, getForumName(), "from", intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false)) && getActivity() != null) {
                    getActivity().finish();
                    return;
                }
            }
            if (intent != null && intent.getData() != null) {
                Uri data = intent.getData();
                this.dKJ = data.getQueryParameter("name");
                this.mFrom = data.getQueryParameter("from");
                if (!StringUtils.isNull(this.dKJ)) {
                    intent.putExtra("name", this.dKJ);
                }
                if (!StringUtils.isNull(this.mFrom)) {
                    intent.putExtra("from", this.mFrom);
                }
                TiebaStatic.log("c10105");
            }
            if (StringUtils.isNull(this.dKJ) && intent != null && intent.getData() != null) {
                Uri data2 = intent.getData();
                if (com.baidu.tbadk.BdToken.f.e(data2)) {
                    com.baidu.tbadk.BdToken.f.vF().b(data2, new f.a() { // from class: com.baidu.tieba.frs.FrsFragment.18
                        @Override // com.baidu.tbadk.BdToken.f.a
                        public void n(HashMap<String, Object> hashMap) {
                            if (hashMap != null && (hashMap.get(com.baidu.tbadk.BdToken.f.akS) instanceof String)) {
                                FrsFragment.this.dKJ = (String) hashMap.get(com.baidu.tbadk.BdToken.f.akS);
                            }
                        }
                    });
                } else {
                    com.baidu.tieba.frs.f.d O = com.baidu.tieba.frs.f.i.O(intent);
                    if (O != null) {
                        this.dKJ = O.forumName;
                        if (O.efh != null && O.efh.equals("aidou")) {
                            com.baidu.tbadk.core.dialog.h.axi = System.currentTimeMillis();
                        }
                    }
                }
                if (!StringUtils.isNull(this.dKJ)) {
                    intent.putExtra("name", this.dKJ);
                }
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.dKQ = getVoiceManager();
        if (this.dKQ != null) {
            this.dKQ.onStart(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        Intent intent;
        registerListener(2001118, this.aPW);
        if (bundle != null) {
            this.dKJ = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
            this.dKJ = intent.getStringExtra("name");
            this.mFrom = intent.getStringExtra("from");
            this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
        }
        if (getArguments() != null) {
            this.dKK = getArguments().getBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, false);
        }
        if (TextUtils.isEmpty(this.mFrom) || FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
        }
        if (this.mIsLogin) {
            registerListener(2001120, this.aPW);
        }
        this.dLc.t(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.q.c.bBT().s(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.dMg);
        if (this.dKQ != null) {
            this.dKQ.onDestory(getPageContext());
        }
        com.baidu.tieba.recapp.report.a.remove("FRS");
        this.dKQ = null;
        com.baidu.tieba.card.v.aqs().fv(false);
        if (this.dKt != null && this.dKt.bgT() != null) {
            ac.aDm().ca(com.baidu.adp.lib.g.b.d(this.dKt.bgT().getId(), 0L));
        }
        if (this.dLq != null) {
            this.dLq.onDestory();
        }
        if (this.dKR != null) {
            com.baidu.tieba.frs.f.h.a(this.dKR, this.dKt, getForumId(), false, null);
            this.dKR.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.dKZ != null) {
                this.dKZ.Pd();
            }
            this.dKR.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.dLc.onActivityDestroy();
        if (this.dLb != null) {
            this.dLb.acn();
        }
        if (this.dLh != null) {
            this.dLh.Qe();
        }
        if (this.dLk != null) {
            this.dLk.destory();
        }
        if (this.dLl != null) {
            this.dLl.destory();
        }
        if (this.dLf != null) {
            this.dLf.onDestroy();
        }
        if (this.dLx != null) {
            this.dLx.onDestory();
        }
        if (this.dLp != null) {
            this.dLp.onDestroy();
        }
        if (this.dLA != null) {
            this.dLA.onDestroy();
        }
        if (this.dLB != null) {
            this.dLB.onDestroy();
        }
        com.baidu.tieba.recapp.d.a.bwa().bwc();
        com.baidu.tieba.frs.f.j.aHF();
        if (this.dLd != null) {
            this.dLd.a((FrsTabViewController.a) null);
            this.dLd.aIn();
        }
        if (this.dLC != null) {
            this.dLC.onDestroy();
        }
        if (this.dLE != null) {
            this.dLE.onDestroy();
        }
        com.baidu.tieba.frs.a.aAJ().a(null);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.dKJ);
        bundle.putString("from", this.mFrom);
        this.dLb.onSaveInstanceState(bundle);
        if (this.dKQ != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            this.dKQ.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.dLp != null) {
            this.dLp.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dKR != null) {
            this.dKR.aCu();
            this.dKR.onResume();
        }
        this.dLe.hp(true);
        this.dLa = true;
        if (dKI) {
            dKI = false;
            this.dKR.startPullRefresh();
            return;
        }
        if (this.dKQ != null) {
            this.dKQ.onResume(getPageContext());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921338));
        this.dKR.gG(false);
        if (this.dLy) {
            refresh(6);
            this.dLy = false;
        }
        aBW();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
    }

    public boolean aBG() {
        Intent intent;
        if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
            return false;
        }
        return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
    }

    public void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.dKJ = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.dKL = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.dKL) {
                aBH();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBH() {
        this.dKR.startPullRefresh();
    }

    public void closeActivity() {
        com.baidu.tieba.frs.f.i.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.mFrom);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.dKR.setTitle(this.dKJ);
        } else {
            this.dKR.setTitle("");
            this.mFlag = 1;
        }
        this.dKR.setOnAdapterItemClickListener(this.dMe);
        this.dKR.addOnScrollListener(this.mScrollListener);
        this.dKR.h(this.dID);
        this.dKR.aCE().a(this.dMd);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dLG) {
            this.dKR.onChangeSkinType(i);
            this.dLc.nF(i);
            this.dLd.onChangeSkinType(i);
            if (this.dLw != null) {
                this.dLw.onChangeSkinType();
            }
            if (this.dLC != null) {
                this.dLC.onChangeSkinType(i);
            }
            if (this.dLD != null) {
                this.dLD.d(getPageContext(), i);
            }
            if (this.cZR != null) {
                com.baidu.tbadk.o.a.a(getPageContext(), this.cZR.BG());
            }
        }
    }

    public void mk(int i) {
        if (!this.mIsLogin) {
            if (this.dKt != null && this.dKt.yE() != null) {
                this.dKt.yE().setIfpost(1);
            }
            if (i == 0) {
                ba.bI(getActivity());
            }
        } else if (this.dKt != null) {
            if (i == 0) {
                com.baidu.tieba.frs.f.j.d(this, 0);
            } else {
                this.dKR.aCw();
            }
        }
    }

    public void refresh() {
        com.baidu.tieba.a.d.VO().jK("page_frs");
        refresh(3);
    }

    public void refresh(int i) {
        this.dKX = false;
        aBM();
        if (this.dKR.aCm() != null) {
            this.dKR.aCm().aNk();
        }
        this.dLb.r(i, true);
    }

    private void aBI() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.g.h.jH().d(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.22
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.vO(FrsFragment.this.dKJ);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBJ() {
        aBM();
        try {
            if (this.dKt != null) {
                this.dKR.anp();
                this.dKR.gz(aBV());
                if (!com.baidu.tieba.frs.vc.f.l(this.dKt) || !com.baidu.tieba.frs.vc.f.k(this.dKt)) {
                }
                if (this.dKt.bgT() != null) {
                    this.dKJ = this.dKt.bgT().getName();
                    this.forumId = this.dKt.bgT().getId();
                }
                if (this.dKt.yS() != null) {
                    setHasMore(this.dKt.yS().yP());
                }
                this.dKR.setTitle(this.dKJ);
                this.dKR.setForumName(this.dKJ);
                TbadkCoreApplication.getInst().setDefaultBubble(this.dKt.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.dKt.getUserData().getBimg_end_time());
                aBI();
                aBK();
                ArrayList<com.baidu.adp.widget.ListView.h> threadList = this.dKt.getThreadList();
                if (threadList != null) {
                    this.dKR.a(threadList, this.dKt);
                    com.baidu.tieba.frs.f.c.w(this.dKR);
                    this.dLc.nG(getPageNum());
                    this.dLc.i(this.dKt);
                    this.dLd.a(this.dKt, this.dLb.aHh());
                    this.dKR.aCx();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void aBK() {
        if (this.dKt != null) {
            if (this.dKt.bhi() == 1) {
                this.dKR.aCE().setFromCDN(true);
            } else {
                this.dKR.aCE().setFromCDN(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.dLe.hp(false);
        this.dLa = false;
        this.dKR.onPause();
        if (this.dKQ != null) {
            this.dKQ.onPause(getPageContext());
        }
        this.dKR.gG(true);
        if (this.dLl != null) {
            this.dLl.aHI();
        }
        com.baidu.tbadk.BdToken.c.vu().vv();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.dLd != null && this.dLd.aIl() != null && (this.dLd.aIl().fragment instanceof BaseFragment)) {
            ((BaseFragment) this.dLd.aIl().fragment).setPrimary(z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.v.aqs().fv(false);
        gs(false);
        if (this.dKt != null && this.dKt.bgT() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            com.baidu.tbadk.distribute.a.LL().a(getPageContext().getPageActivity(), "frs", this.dKt.bgT().getId(), 0L);
        }
        if (this.dKQ != null) {
            this.dKQ.onStop(getPageContext());
        }
        if (Fv() != null) {
            Fv().getRecycledViewPool().clear();
        }
        this.dLc.onActivityStop();
        com.baidu.tbadk.util.v.Qi();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            if (this.dLc != null) {
                this.dLc.gx(isPrimary());
            }
            if (this.dKR != null) {
                this.dKR.gx(isPrimary());
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (com.baidu.tieba.frs.a.aAJ().aAK()) {
                com.baidu.tieba.frs.a.aAJ().reset();
                return true;
            } else if (this.dKR != null) {
                return this.dKR.aCt();
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
        com.baidu.tbadk.distribute.a.LL().a(advertAppInfo, this.forumId, 0L, "FRS", str, getPn());
    }

    @Override // com.baidu.tieba.recapp.n
    public void aBL() {
        aBs().aBL();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dKQ == null) {
            this.dKQ = VoiceManager.instance();
        }
        return this.dKQ;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdRecyclerView Fv() {
        if (this.dKR == null) {
            return null;
        }
        return this.dKR.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void aBM() {
        if (this.dKQ != null) {
            this.dKQ.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> Fw() {
        if (this.aKP == null) {
            this.aKP = UserIconBox.l(getPageContext().getPageActivity(), 8);
        }
        return this.aKP;
    }

    public void aBN() {
        if (getFragmentActivity() != null && getFragmentActivity().getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.b(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.k onGetPreLoadListView() {
        return Fv().getPreLoadHandle();
    }

    @Override // com.baidu.tieba.frs.ak
    public NavigationBar abW() {
        if (this.dKR == null) {
            return null;
        }
        return this.dKR.abW();
    }

    @Override // com.baidu.tbadk.core.view.NavigationBar.a
    public void b(Pair<Integer, Integer> pair) {
        this.dKV = pair;
    }

    /* loaded from: classes6.dex */
    private final class a implements com.baidu.adp.widget.ListView.n {
        private a() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v13, resolved type: com.baidu.tieba.frs.FrsFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.n
        public void a(View view, com.baidu.adp.widget.ListView.h hVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null) {
                if (bdUniqueId == p.dNz) {
                    if (FrsFragment.this.dKR != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11752").aA(ImageViewerConfig.FORUM_ID, FrsFragment.this.forumId).aA("obj_locate", "1"));
                        FrsFragment.this.dKR.startPullRefresh();
                    }
                } else if (hVar != null && (hVar instanceof bb)) {
                    bb bbVar = (bb) hVar;
                    if (bbVar.As() == null || bbVar.As().getGroup_id() == 0 || ba.bJ(FrsFragment.this.getActivity())) {
                        if (bbVar.Ak() != 1 || ba.bJ(FrsFragment.this.getActivity())) {
                            if (bbVar.zU() != null) {
                                if (ba.bJ(FrsFragment.this.getActivity())) {
                                    String postUrl = bbVar.zU().getPostUrl();
                                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.ll()) {
                                        com.baidu.tbadk.browser.a.af(FrsFragment.this.getActivity(), postUrl);
                                    }
                                }
                            } else if (bbVar.AB() != null) {
                                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                    ba.bI(FrsFragment.this.getPageContext().getPageActivity());
                                    return;
                                }
                                com.baidu.tbadk.core.data.m AB = bbVar.AB();
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), AB.getCartoonId(), AB.getChapterId(), 2)));
                            } else {
                                com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                                if (readThreadHistory != null && !readThreadHistory.vU(bbVar.getId())) {
                                    readThreadHistory.vT(bbVar.getId());
                                }
                                boolean z = false;
                                final String zO = bbVar.zO();
                                if (zO != null && !zO.equals("")) {
                                    z = true;
                                    new Thread(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.a.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(zO);
                                            xVar.Dj().Eh().mIsNeedAddCommenParam = false;
                                            xVar.Dj().Eh().mIsUseCurrentBDUSS = false;
                                            xVar.CM();
                                        }
                                    }).start();
                                }
                                String tid = bbVar.getTid();
                                if (tid == null) {
                                    tid = "";
                                }
                                if (bbVar.zB() == 2 && !tid.startsWith("pb:")) {
                                    ay.Ef().c(FrsFragment.this.getPageContext(), new String[]{tid, "", null});
                                    return;
                                }
                                if (tid.startsWith("pb:")) {
                                    bbVar.setId(tid.substring(3));
                                }
                                if (bdUniqueId.getId() == bb.auD.getId()) {
                                    com.baidu.tieba.frs.f.h.a(bbVar.zn());
                                } else if (bdUniqueId.getId() == bb.atn.getId()) {
                                    com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c12940");
                                    amVar.aA("obj_type", "2");
                                    amVar.aA("tid", bbVar.getTid());
                                    TiebaStatic.log(amVar);
                                }
                                com.baidu.tieba.frs.f.i.a(FrsFragment.this, bbVar, i, z);
                                com.baidu.tieba.frs.f.h.a(FrsFragment.this, FrsFragment.this.dKt, bbVar);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.l.ll()) {
            hideNetRefreshView(this.dKR.aCF());
            showLoadingView(this.dKR.aCF(), true);
            this.dKR.gC(false);
            this.dLb.r(3, true);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public com.baidu.tieba.tbadkCore.l aBO() {
        return this.dKt;
    }

    public boolean aBP() {
        return this.dKR.aBP();
    }

    public void ac(Object obj) {
        if (this.dLg != null && this.dLg.ecD != null) {
            this.dLg.ecD.m(obj);
        }
    }

    public void ad(Object obj) {
        if (this.dLg != null && this.dLg.ecE != null) {
            this.dLg.ecE.m(obj);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        this.dKR.getListView().stopScroll();
        if (!this.dKR.aCA()) {
            if (!com.baidu.adp.lib.util.l.ll()) {
                this.dKR.abd();
            } else if (this.dLb.aHb() == 1) {
                aar();
                aad();
            } else if (this.dLb.hasMore()) {
                aad();
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void nK(String str) {
        aar();
        showToast(str);
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void O(ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        boolean I = com.baidu.tbadk.core.util.v.I(arrayList);
        setHasMore(I ? 0 : 1);
        aar();
        if (!I) {
            if (!this.dLb.aHl() && TbadkCoreApplication.getInst().isRecAppExist() && this.dLb.aHb() == 1) {
                this.dKt.a(this, arrayList);
            }
            if (this.dLb != null) {
                com.baidu.tieba.frs.e.a.a(getUniqueId(), arrayList, this.dKt.bgT(), this.dLb.acb());
            }
            ArrayList<com.baidu.adp.widget.ListView.h> a2 = this.dLn.a(false, false, arrayList, this.dKN, false);
            if (a2 != null) {
                this.dKt.ay(a2);
                this.dKR.a(a2, this.dKt);
            }
            if (this.dLb != null) {
                com.baidu.tieba.frs.e.c.a(this.dKt, this.dLb.aHh(), 2);
            }
        }
    }

    private void aar() {
        if (aBy() == 1 || this.dLn.bP(this.dKt.bCn())) {
            if (com.baidu.tbadk.core.util.v.H(this.dKt.getThreadList()) > 3) {
                this.dKR.abb();
            } else {
                this.dKR.aCI();
            }
        } else if (com.baidu.tbadk.core.util.v.I(this.dKt.getThreadList())) {
            this.dKR.abd();
        } else {
            this.dKR.abc();
        }
    }

    @Override // com.baidu.tieba.frs.mc.j
    public void aad() {
        if (this.dLn != null) {
            this.dLn.a(this.dKJ, this.forumId, this.dKt);
        }
    }

    public void takePhoto() {
        if (!com.baidu.tbadk.core.util.ab.e(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.ak.b(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        if (this.dKW) {
            return null;
        }
        if (aBQ()) {
            return "a034";
        }
        return "a006";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (!aBQ()) {
            return super.getCurrentPageSourceKeyList();
        }
        if (super.getCurrentPageSourceKeyList() != null) {
            arrayList = new ArrayList(super.getCurrentPageSourceKeyList());
        } else {
            arrayList = new ArrayList();
        }
        if (!"a001".equals(com.baidu.tbadk.core.util.v.d(arrayList, arrayList.size() - 1))) {
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

    @Override // android.support.v4.app.Fragment
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        com.baidu.tieba.frs.f.i.a(this, i, strArr, iArr);
    }

    public void gv(boolean z) {
        if (this.dLh != null) {
            this.dLh.gR(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.dLi.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a ht(int i) {
        return this.dLi.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        this.dLr.b(bVar);
    }

    public boolean aBQ() {
        return this.dKF;
    }

    @Override // com.baidu.tieba.frs.ah
    public void aaC() {
        if (this.dKR != null) {
            showFloatingView();
            this.dKR.getListView().scrollToPosition(0);
            this.dKR.startPullRefresh();
        }
    }

    public ForumWriteData aBR() {
        if (this.dKt == null || this.dKt.bgT() == null) {
            return null;
        }
        ForumData bgT = this.dKt.bgT();
        ForumWriteData forumWriteData = new ForumWriteData(bgT.getId(), bgT.getName(), bgT.getPrefixData(), this.dKt.yE());
        forumWriteData.avatar = bgT.getImage_url();
        forumWriteData.forumLevel = bgT.getUser_level();
        forumWriteData.specialForumType = bgT.special_forum_type;
        forumWriteData.firstDir = bgT.getFirst_class();
        forumWriteData.secondDir = bgT.getSecond_class();
        UserData userData = this.dKt.getUserData();
        forumWriteData.privateThread = userData != null ? userData.getPrivateThread() : 0;
        return forumWriteData;
    }

    @Override // com.baidu.tieba.frs.ah
    public void Fj() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.frs.ah
    public void setVideoThreadId(String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z) {
        super.showLoadingView(view, z);
        this.dKR.mp(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        super.hideLoadingView(view);
        this.dKR.mp(0);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        super.showNetRefreshView(view, str, z);
        this.dKR.mp(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshViewNoClick(View view, String str, boolean z) {
        super.showNetRefreshViewNoClick(view, str, z);
        this.dKR.mp(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        super.hideNetRefreshView(view);
        this.dKR.mp(0);
    }

    public void aBS() {
        FrsTabViewController.b aIl;
        if (this.dLd != null && (aIl = this.dLd.aIl()) != null && aIl.fragment != null && (aIl.fragment instanceof aj)) {
            ((aj) aIl.fragment).aBh();
        }
    }

    public void a(ContriInfo contriInfo) {
        if (this.dLC == null) {
            this.dLC = new com.baidu.tbadk.core.dialog.h(getTbPageContext());
            this.dLC.a(new h.a() { // from class: com.baidu.tieba.frs.FrsFragment.31
                @Override // com.baidu.tbadk.core.dialog.h.a
                public void bn(boolean z) {
                    if (z) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13061"));
                    }
                }
            });
        }
        this.dLC.a(contriInfo, -1L);
    }

    public void gw(boolean z) {
        this.dKH = z;
    }

    public boolean aBT() {
        return this.dKH;
    }

    public void oc(String str) {
        if (TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.util.ao.isEmpty(str)) {
            if (this.dLE == null) {
                this.dLE = new AddExperiencedModel(getTbPageContext());
                this.dLE.a(this.dLH);
            }
            this.dLE.cE(this.forumId, str);
        }
    }

    public com.baidu.tieba.frs.entelechy.b aBU() {
        return this.dKD;
    }

    public boolean aBV() {
        return (this.dLb != null && this.dLb.aHc() && com.baidu.tieba.frs.a.aAJ().aAK()) ? false : true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.e.c
    public boolean videoNeedPreload() {
        if (this.dKt != null) {
            return com.baidu.tbadk.util.aa.Qp() && (this.dKt.hmN || com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("auto_play_video_frs", 0) == 1);
        }
        return super.videoNeedPreload();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBW() {
        if (!com.baidu.tbadk.core.util.ao.isEmpty(this.forumId)) {
            com.baidu.tbadk.BdToken.c.vu().g(com.baidu.tbadk.BdToken.b.ajP, com.baidu.adp.lib.g.b.d(this.forumId, 0L));
        }
    }
}
