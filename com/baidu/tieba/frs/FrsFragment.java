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
import com.baidu.f.a.a;
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
import java.util.Iterator;
import java.util.List;
import tbclient.FrsPage.RecmForumInfo;
import tbclient.WindowToast;
/* loaded from: classes6.dex */
public class FrsFragment extends BaseFragment implements BdListView.e, a.InterfaceC0073a, NavigationBar.a, UserIconBox.b<BdRecyclerView>, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, ah, ak, am, com.baidu.tieba.frs.loadmore.a, com.baidu.tieba.frs.mc.j, com.baidu.tieba.recapp.n {
    public static boolean dAe = false;
    public static volatile long dAp = 0;
    public static volatile long dAq = 0;
    public static volatile int mNetError = 0;
    private com.baidu.adp.lib.e.b<TbImageView> aGx;
    private com.baidu.tieba.frs.gametab.b bTU;
    private com.baidu.tbadk.util.t bey;
    private com.baidu.tbadk.core.dialog.a cPo;
    private com.baidu.tieba.frs.mc.f dAA;
    private com.baidu.tieba.frs.smartsort.b dAB;
    private com.baidu.tieba.frs.mc.b dAC;
    private an dAD;
    private com.baidu.tieba.frs.entelechy.b.b dAF;
    private com.baidu.tbadk.i.a dAG;
    private com.baidu.tieba.frs.vc.a dAH;
    private com.baidu.tieba.frs.mc.d dAI;
    private com.baidu.tieba.frs.mc.c dAJ;
    private com.baidu.tieba.frs.vc.h dAK;
    private com.baidu.tieba.frs.mc.a dAL;
    private com.baidu.tieba.frs.live.a dAM;
    private j dAN;
    public com.baidu.tieba.frs.vc.c dAO;
    private com.baidu.tieba.frs.mc.e dAP;
    private int dAQ;
    private View.OnTouchListener dAR;
    private com.baidu.tieba.frs.view.a dAS;
    private com.baidu.tieba.frs.vc.e dAT;
    private boolean dAU;
    private com.baidu.tieba.NEGFeedBack.a dAW;
    private com.baidu.tieba.ala.a dAX;
    private com.baidu.tbadk.core.dialog.h dAY;
    private com.baidu.tieba.frs.brand.buttommenu.a dAZ;
    private com.baidu.tieba.tbadkCore.data.e dAj;
    private VoiceManager dAm;
    private FrsModelController dAx;
    private com.baidu.tieba.frs.vc.f dAy;
    private FrsTabViewController dAz;
    private AddExperiencedModel dBa;
    private boolean dBc;
    private int dBk;
    private com.baidu.tieba.frs.entelechy.b dzZ;
    public View mRootView;
    public boolean dAa = false;
    private boolean dAb = false;
    private boolean dAc = false;
    private boolean dAd = true;
    public String dAf = null;
    public String mFrom = null;
    public int mFlag = 0;
    public boolean dAg = false;
    private boolean dAh = false;
    private String mThreadId = null;
    public String forumId = null;
    private int dzS = 0;
    private boolean dAi = false;
    private boolean dAk = false;
    private boolean dAl = false;
    private k dAn = null;
    public final bb bIV = null;
    private com.baidu.tieba.tbadkCore.l dzP = new com.baidu.tieba.tbadkCore.l();
    public long dgR = -1;
    public long bbI = 0;
    public long bbA = 0;
    public long createTime = 0;
    public long beginTime = -1;
    public long dAo = 0;
    public Pair<Integer, Integer> dAr = null;
    public boolean dAs = false;
    private boolean dAt = false;
    private boolean dAu = false;
    public com.baidu.tbadk.l.b dAv = null;
    private boolean dAw = true;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> dAE = new SparseArray<>();
    private boolean bNr = true;
    private boolean dAV = false;
    private boolean hasInit = false;
    private boolean dBb = false;
    private AddExperiencedModel.a dBd = new AddExperiencedModel.a() { // from class: com.baidu.tieba.frs.FrsFragment.1
        @Override // com.baidu.tieba.share.AddExperiencedModel.a
        public void b(ContriInfo contriInfo) {
            if (contriInfo != null && contriInfo.isShowToast()) {
                FrsFragment.this.a(contriInfo);
            }
        }
    };
    private HttpMessageListener dBe = new HttpMessageListener(CmdConfigHttp.CMD_PB_FLOOR_AGREE, true) { // from class: com.baidu.tieba.frs.FrsFragment.12
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
    private final CustomMessageListener dBf = new CustomMessageListener(2016495) { // from class: com.baidu.tieba.frs.FrsFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof bb) {
                    com.baidu.tieba.frs.f.h.a(FrsFragment.this.dAn, FrsFragment.this.dzP, FrsFragment.this.getForumId(), true, (bb) data);
                }
            }
        }
    };
    private CustomMessageListener dBg = new CustomMessageListener(2921005) { // from class: com.baidu.tieba.frs.FrsFragment.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.dzP != null) {
                FrsFragment.this.dzP.bBd();
                if (FrsFragment.this.dAn != null) {
                    FrsFragment.this.dAn.notifyDataChanged();
                }
            }
        }
    };
    private CustomMessageListener dBh = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.FrsFragment.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 1) {
                    FrsFragment.this.azL();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                }
            }
        }
    };
    private final al dBi = new al() { // from class: com.baidu.tieba.frs.FrsFragment.32
        @Override // com.baidu.tieba.frs.al
        public void a(int i, int i2, ar arVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
            FrsFragment.this.azE();
            if (FrsFragment.this.dAF != null) {
                FrsFragment.this.dAy.hc(FrsFragment.this.dAF.lR(i));
            }
            d.a aVar = new d.a();
            if (arVar != null) {
                aVar.isSuccess = arVar.errCode == 0;
                aVar.errorCode = arVar.errCode;
                aVar.errorMsg = arVar.errMsg;
                if (aVar.isSuccess) {
                    if (com.baidu.tbadk.core.util.v.J(arrayList)) {
                        FrsFragment.this.dAn.ZL();
                    } else if (arVar.hasMore) {
                        if (com.baidu.tbadk.core.util.v.I(FrsFragment.this.dzP.getThreadList()) > 3) {
                            FrsFragment.this.dAn.ZJ();
                        } else {
                            FrsFragment.this.dAn.aAM();
                        }
                    } else if (arVar.dEd) {
                        FrsFragment.this.dAn.ZK();
                    } else {
                        FrsFragment.this.dAn.ZL();
                    }
                }
            } else {
                arVar = new ar();
                arVar.pn = 1;
                arVar.hasMore = false;
                arVar.dEd = false;
            }
            if (i == 1) {
                FrsFragment.this.dAw = true;
                FrsFragment.this.dBu.a(FrsFragment.this.dAx.getType(), false, aVar);
            } else {
                FrsFragment.this.a(aVar);
                if (FrsFragment.this.dAx.aEE() != null) {
                    FrsFragment.this.dzP = FrsFragment.this.dAx.aEE();
                }
                FrsFragment.this.azN();
            }
            if (FrsFragment.this.dBB != null) {
                FrsFragment.this.dBB.a(i, i2, arVar, arrayList);
            }
        }
    };
    private FrsTabViewController.a dBj = new FrsTabViewController.a() { // from class: com.baidu.tieba.frs.FrsFragment.33
        @Override // com.baidu.tieba.frs.vc.FrsTabViewController.a
        public void ft(int i) {
            boolean z = false;
            if (i != 1) {
                com.baidu.tieba.card.v.aop().fh(false);
            }
            if (i == 303 && i != FrsFragment.this.dBk) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13121").ax(ImageViewerConfig.FORUM_ID, FrsFragment.this.forumId).ax("uid", TbadkCoreApplication.getCurrentAccount()));
            }
            FrsFragment.this.dBk = i;
            FrsFragment.this.azQ();
            com.baidu.tieba.frs.e.c.dIB.dTG = i;
            com.baidu.tieba.frs.e.c.dIB.dTH = -1;
            com.baidu.tieba.frs.a ayN = com.baidu.tieba.frs.a.ayN();
            if (i == 1 && FrsFragment.this.dBb) {
                z = true;
            }
            ayN.v(z, true);
        }
    };
    private CustomMessageListener dBl = new CustomMessageListener(2001606) { // from class: com.baidu.tieba.frs.FrsFragment.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                FrsFragment.this.dAz.mS(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    };
    private CustomMessageListener dBm = new CustomMessageListener(2001607) { // from class: com.baidu.tieba.frs.FrsFragment.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && ((Integer) customResponsedMessage.getData()).intValue() == 51 && FrsFragment.this.dzP != null) {
                com.baidu.tieba.frs.f.j.a(FrsFragment.this.dzP, FrsFragment.this.getPageContext());
            }
        }
    };
    private final CustomMessageListener dBn = new CustomMessageListener(2003019) { // from class: com.baidu.tieba.frs.FrsFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                FrsFragment.this.dAz.mQ(49);
            }
        }
    };
    private final CustomMessageListener dBo = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.frs.FrsFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && FrsFragment.this.dzP != null && FrsFragment.this.dzP.beT() != null) {
                SignData signData = (SignData) customResponsedMessage.getData();
                int user_level = FrsFragment.this.dzP.beT().getUser_level();
                if (signData.forumId != null && signData.forumId.equals(FrsFragment.this.dzP.beT().getId())) {
                    FrsFragment.this.dzP.d(signData);
                    FrsFragment.this.dAy.i(FrsFragment.this.dzP);
                    if (FrsFragment.this.dAy.aGg()) {
                        i = FrsFragment.this.dzP.beT().getUser_level();
                        if (user_level >= i) {
                            i++;
                        }
                    } else {
                        i = user_level;
                    }
                    TbadkCoreApplication.getInst().addSignedForum(FrsFragment.this.dzP.beT().getName(), signData.sign_bonus_point, i);
                }
            }
        }
    };
    private final CustomMessageListener dBp = new CustomMessageListener(2001352) { // from class: com.baidu.tieba.frs.FrsFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.r) && FrsFragment.this.dzP != null) {
                FrsFragment.this.dzP.c((com.baidu.tieba.tbadkCore.r) customResponsedMessage.getData());
                FrsFragment.this.dAy.h(FrsFragment.this.dzP);
                FrsFragment.this.dAz.a(FrsFragment.this.dzP, FrsFragment.this.dAx.aFk());
            }
        }
    };
    private final AntiHelper.a dBq = new AntiHelper.a() { // from class: com.baidu.tieba.frs.FrsFragment.5
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12536").x("obj_locate", as.a.ayA));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12535").x("obj_locate", as.a.ayA));
        }
    };
    private CustomMessageListener bQJ = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.frs.FrsFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(FrsFragment.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().aLc != null) {
                        if (AntiHelper.a(FrsFragment.this.getActivity(), updateAttentionMessage.getData().aLc, FrsFragment.this.dBq) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12534").x("obj_locate", as.a.ayA));
                        }
                    } else if (updateAttentionMessage.getData().Jo && updateAttentionMessage.getData().isAttention) {
                        com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getPageContext().getPageActivity(), e.j.attention_success);
                    }
                }
            }
        }
    };
    private CustomMessageListener dBr = new CustomMessageListener(2921346) { // from class: com.baidu.tieba.frs.FrsFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsFragment.this.refresh();
        }
    };
    private CustomMessageListener dBs = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.frs.FrsFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                FrsFragment.this.dAn.c((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener dBt = new CustomMessageListener(2001626) { // from class: com.baidu.tieba.frs.FrsFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewsRemindMessage newsRemindMessage;
            if (customResponsedMessage != null && (customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626 && (newsRemindMessage = (NewsRemindMessage) customResponsedMessage) != null) {
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (FrsFragment.this.dAn != null) {
                    FrsFragment.this.dAn.p(notificationCount, z);
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.n dBu = new com.baidu.tieba.tbadkCore.n() { // from class: com.baidu.tieba.frs.FrsFragment.10
        private long startTime = 0;

        @Override // com.baidu.tieba.tbadkCore.n
        public void lq(int i) {
            this.startTime = System.nanoTime();
            if (FrsFragment.this.dAn != null) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsFragment.this.dAn.aAy();
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
            if (FrsFragment.this.bNr) {
                FrsFragment.this.bNr = false;
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.dAn, FrsFragment.this.dzP, FrsFragment.this.getForumId(), false, null);
            }
            FrsFragment.this.azE();
            FrsFragment.this.dAt = true;
            if (aVar != null && aVar.isSuccess) {
                FrsFragment.this.dAn.aAI().gP(com.baidu.tbadk.core.util.aq.CG().CI());
                FrsFragment.dAp = 0L;
                FrsFragment.dAq = 0L;
                FrsFragment.mNetError = 0;
            } else {
                FrsFragment.mNetError = 1;
            }
            if (!FrsFragment.this.dAx.aFo() && (i == 3 || i == 6)) {
                FrsFragment.this.dAJ.resetData();
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (FrsFragment.this.dAx.aEE() != null) {
                FrsFragment.this.dzP = FrsFragment.this.dAx.aEE();
            }
            FrsFragment.this.dAn.b(FrsFragment.this.dzP.bAL());
            FrsFragment.this.ln(1);
            if (i == 7) {
                FrsFragment.this.lo(FrsFragment.this.dzP.bAq());
                return;
            }
            if (FrsFragment.this.dzP.xH() != null) {
                FrsFragment.this.setHasMore(FrsFragment.this.dzP.xH().xD());
            }
            if (i == 4) {
                if (!FrsFragment.this.dAx.aFo() && TbadkCoreApplication.getInst().isRecAppExist() && FrsFragment.this.dAx.aFe() == 1) {
                    FrsFragment.this.dzP.a(FrsFragment.this);
                }
                ArrayList<com.baidu.adp.widget.ListView.h> a2 = FrsFragment.this.dAJ.a(false, false, FrsFragment.this.dzP.getThreadList(), FrsFragment.this.dAj, false);
                if (a2 != null) {
                    FrsFragment.this.dzP.ay(a2);
                    FrsFragment.this.dzP.bAU();
                    FrsFragment.this.dAn.a(a2, FrsFragment.this.dzP);
                }
                if (FrsFragment.this.dAx != null) {
                    com.baidu.tieba.frs.e.b.a(FrsFragment.this.dzP, FrsFragment.this.dAx.aFk(), 2);
                }
                com.baidu.tieba.frs.f.a.a(FrsFragment.this, FrsFragment.this.dzP.beT(), FrsFragment.this.dzP.getThreadList(), false, FrsFragment.this.getPn());
                FrsFragment.this.bbI = System.currentTimeMillis() - currentTimeMillis;
                FrsFragment.this.azF();
                return;
            }
            FrsFragment.this.azF();
            switch (i) {
                case 1:
                    FrsFragment.this.dAn.aAy();
                    break;
                case 2:
                    FrsFragment.this.dAn.aAy();
                    break;
                case 3:
                case 6:
                    if (FrsFragment.this.dzP != null) {
                        FrsFragment.this.dzP.bAS();
                    }
                    if (FrsFragment.this.dAO != null) {
                        FrsFragment.this.dAO.refresh();
                        break;
                    }
                    break;
            }
            FrsFragment.this.azG();
            if (aVar == null || aVar.errorCode == 0) {
                if (FrsFragment.this.dzP != null) {
                    FrsFragment.this.y(false, i == 5);
                    FrsFragment.this.dAn.ly(i);
                    FrsFragment.dAp = (System.nanoTime() - this.startTime) / 1000000;
                    if (aVar != null) {
                        FrsFragment.dAq = aVar.gZB;
                    }
                } else {
                    return;
                }
            } else if (FrsFragment.this.dzP == null || com.baidu.tbadk.core.util.v.J(FrsFragment.this.dzP.getThreadList())) {
                FrsFragment.this.a(aVar);
            } else if (aVar.gZA) {
                FrsFragment.this.showToast(FrsFragment.this.getPageContext().getResources().getString(e.j.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
            }
            if (FrsFragment.this.dzP.bAa() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11384"));
            }
            if (FrsFragment.this.dgR > -1 && !FrsFragment.this.dAV) {
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.dAx, FrsFragment.this.dgR);
                FrsFragment.this.dgR = -1L;
                FrsFragment.this.dAV = true;
            }
            if (FrsFragment.this.dAk && FrsFragment.this.dAz.mQ(49)) {
                FrsFragment.this.dAk = false;
            }
            FrsFragment.this.bbI = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void b(com.baidu.tieba.tbadkCore.i iVar) {
            if ((iVar != null && ("normal_page".equals(FrsFragment.this.dAx.getPageType()) || "frs_page".equals(FrsFragment.this.dAx.getPageType()) || "book_page".equals(FrsFragment.this.dAx.getPageType()))) || "brand_page".equals(FrsFragment.this.dAx.getPageType())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001615, iVar));
                FrsFragment.this.a(iVar);
            }
        }
    };
    private final CustomMessageListener dBv = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.frs.FrsFragment.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                FrsFragment.this.dzP.a((com.baidu.tbadk.data.j) customResponsedMessage.getData());
                FrsFragment.this.dAn.aAI().notifyDataSetChanged();
            }
        }
    };
    private final CustomMessageListener mMemListener = new CustomMessageListener(2001194) { // from class: com.baidu.tieba.frs.FrsFragment.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && FrsFragment.this.dzP != null && (userData = FrsFragment.this.dzP.getUserData()) != null) {
                userData.setIsMem(num.intValue());
                if (num.intValue() != 0) {
                    FrsFragment.this.dAy.g(num);
                }
            }
        }
    };
    private final com.baidu.tieba.frs.mc.i dBw = new com.baidu.tieba.frs.mc.i() { // from class: com.baidu.tieba.frs.FrsFragment.17
        @Override // com.baidu.tieba.frs.mc.i
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.h> arrayList, boolean z3) {
            if (FrsFragment.this.dAB != null && FrsFragment.this.dAx != null && FrsFragment.this.dAx.aFo() && z && !z2 && !z3) {
                FrsFragment.this.dAB.mv(i2);
            }
        }
    };
    public final View.OnTouchListener bez = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.FrsFragment.18
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (FrsFragment.this.dAR != null) {
                FrsFragment.this.dAR.onTouch(view, motionEvent);
            }
            if (FrsFragment.this.dAD != null && FrsFragment.this.dAD.aBt() != null) {
                FrsFragment.this.dAD.aBt().onTouchEvent(motionEvent);
            }
            if (FrsFragment.this.bTU != null) {
                FrsFragment.this.bTU.d(view, motionEvent);
            }
            if (FrsFragment.this.dAy != null) {
                FrsFragment.this.dAy.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private final CustomMessageListener dBx = new CustomMessageListener(2004507) { // from class: com.baidu.tieba.frs.FrsFragment.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "photolive_hostLevel", -1) != -1 && FrsFragment.this.dzP.beT() != null) {
                FrsFragment.this.dzP.beT().setCanAddPhotoLivePost(true);
            }
        }
    };
    public final View.OnClickListener dBy = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.21
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsFragment.this.dAn == null || view != FrsFragment.this.dAn.aAw() || FrsFragment.this.getActivity() == null) {
                if (FrsFragment.this.dzP != null && FrsFragment.this.dzP.beT() != null && FrsFragment.this.dAn != null && view == FrsFragment.this.dAn.aAC()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12402").ax(ImageViewerConfig.FORUM_ID, FrsFragment.this.dzP.beT().getId()).ax("uid", TbadkCoreApplication.getCurrentAccount()).ax(ImageViewerConfig.FORUM_NAME, FrsFragment.this.dzP.beT().getName()));
                    if (!StringUtils.isNull(FrsFragment.this.dzP.beT().getName())) {
                        FrsFragment.this.sendMessage(new CustomMessage(2002001, new PostSearchActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), FrsFragment.this.dzP.beT().getName(), FrsFragment.this.dzP.beT().getId())));
                        return;
                    }
                    return;
                }
                if (view.getId() == e.g.game_activity_egg_layout && com.baidu.adp.lib.util.l.lo()) {
                    TiebaStatic.log("c10853");
                    if (FrsFragment.this.dAn.aAF()) {
                        FrsFragment.this.dAn.aAG();
                    } else {
                        String activityUrl = FrsFragment.this.dzP.beT().getYuleData().An().getActivityUrl();
                        if (!StringUtils.isNull(activityUrl)) {
                            com.baidu.tbadk.browser.a.ag(FrsFragment.this.getPageContext().getPageActivity(), activityUrl);
                        }
                    }
                }
                if (view == FrsFragment.this.dAn.aAN() && FrsFragment.this.dAx != null && FrsFragment.this.dAx.hasMore()) {
                    FrsFragment.this.dAn.ZJ();
                    FrsFragment.this.YL();
                }
                if (view != null && view == FrsFragment.this.dAn.aAD() && ba.bI(FrsFragment.this.getContext())) {
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
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.FrsFragment.22
        private int dBF = 0;
        private int bIA = 0;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (FrsFragment.this.dAH != null) {
                FrsFragment.this.dAH.aFL();
            }
            this.dBF = 0;
            this.bIA = 0;
            if (recyclerView != null && (recyclerView instanceof BdRecyclerView)) {
                this.dBF = ((BdRecyclerView) recyclerView).getFirstVisiblePosition();
                this.bIA = ((BdRecyclerView) recyclerView).getLastVisiblePosition();
            }
            if (FrsFragment.this.dAT != null) {
                FrsFragment.this.dAT.a(recyclerView, this.dBF, this.bIA);
            }
            if (FrsFragment.this.dzP != null && FrsFragment.this.dAn != null && FrsFragment.this.dAn.aAI() != null) {
                FrsFragment.this.dAn.aJ(this.dBF, this.bIA);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (FrsFragment.this.dAy != null) {
                FrsFragment.this.dAy.setScrollState(i);
            }
            if ((i == 2 || i == 1) && !FrsFragment.this.dAu) {
                FrsFragment.this.dAu = true;
                FrsFragment.this.dAn.aAL();
            }
            if (FrsFragment.this.dAv == null && !FrsFragment.this.azU()) {
                FrsFragment.this.dAv = new com.baidu.tbadk.l.b();
                FrsFragment.this.dAv.fG(1000);
            }
            if (i == 0) {
                if (FrsFragment.this.dAv != null) {
                    FrsFragment.this.dAv.NO();
                }
                com.baidu.tieba.card.v.aop().fh(true);
                FrsFragment.this.dAn.aI(this.dBF, this.bIA);
            } else if (FrsFragment.this.dAv != null) {
                FrsFragment.this.dAv.NN();
            }
            if (FrsFragment.this.dAT != null) {
                FrsFragment.this.dAT.onScrollStateChanged(recyclerView, i);
            }
            if (i == 0) {
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.dAn, FrsFragment.this.dzP, FrsFragment.this.getForumId(), false, null);
            }
            if (FrsFragment.this.dAz != null && i == 1) {
                FrsFragment.this.dAz.aGq();
            }
        }
    };
    private final d dBz = new d() { // from class: com.baidu.tieba.frs.FrsFragment.24
        @Override // com.baidu.tieba.frs.d
        public void a(int i, int i2, View view, View view2, bb bbVar) {
            if (i != FrsFragment.this.dAn.aAI().aCI()) {
                if (i != FrsFragment.this.dAn.aAI().aCJ()) {
                    if (i == FrsFragment.this.dAn.aAI().aCK() && FrsFragment.this.dzP != null && FrsFragment.this.dzP.getUserData() != null && FrsFragment.this.dzP.getUserData().isBawu()) {
                        String bAo = FrsFragment.this.dzP.bAo();
                        if (!com.baidu.tbadk.core.util.ao.isEmpty(bAo) && FrsFragment.this.dzP.beT() != null) {
                            com.baidu.tbadk.browser.a.ae(FrsFragment.this.getPageContext().getPageActivity(), bAo);
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10502").ax(ImageViewerConfig.FORUM_ID, FrsFragment.this.dzP.beT().getId()).ax("uid", FrsFragment.this.dzP.getUserData().getUserId()));
                        }
                    }
                } else if (ba.bI(FrsFragment.this.getPageContext().getPageActivity())) {
                    TiebaStatic.log("my_service_ck");
                    if (FrsFragment.this.dzP != null && FrsFragment.this.dzP.beT() != null) {
                        ForumData beT = FrsFragment.this.dzP.beT();
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(beT.getId(), 0L), beT.getName(), beT.getImage_url(), 0)));
                    }
                }
            } else if (ba.bI(FrsFragment.this.getActivity())) {
                TiebaStatic.log("forum_fortune_click");
                com.baidu.tieba.frs.f.i.b(FrsFragment.this.getPageContext(), FrsFragment.this.dzP);
            }
        }
    };
    private final NoNetworkView.a dxY = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.FrsFragment.25
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bn(boolean z) {
            if (FrsFragment.this.dAx.aFe() == 1 && z && !FrsFragment.this.dAn.azT()) {
                if (FrsFragment.this.dzP == null || com.baidu.tbadk.core.util.v.J(FrsFragment.this.dzP.getThreadList())) {
                    FrsFragment.this.hideNetRefreshView(FrsFragment.this.dAn.aAJ());
                    FrsFragment.this.showLoadingView(FrsFragment.this.dAn.aAJ(), true);
                    FrsFragment.this.dAn.go(false);
                    FrsFragment.this.refresh();
                    return;
                }
                FrsFragment.this.dAn.aAy();
            }
        }
    };
    private final CustomMessageListener aLF = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.FrsFragment.26
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                com.baidu.tieba.frs.f.c.a(customResponsedMessage, FrsFragment.this.dAn, FrsFragment.this.dzP);
            }
        }
    };
    private com.baidu.adp.widget.ListView.n dBA = new a();
    private al dBB = new al() { // from class: com.baidu.tieba.frs.FrsFragment.27
        @Override // com.baidu.tieba.frs.al
        public void a(int i, int i2, ar arVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
            com.baidu.adp.lib.g.e.jI().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.27.1
                @Override // java.lang.Runnable
                public void run() {
                    if (FrsFragment.this.dAn != null && FrsFragment.this.dAn.apm()) {
                        FrsFragment.this.YL();
                    }
                }
            });
        }
    };
    private CustomMessageListener dBC = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.frs.FrsFragment.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    FrsFragment.this.dAU = true;
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.frs.loadmore.a
    public /* bridge */ /* synthetic */ com.baidu.adp.base.e getPageContext() {
        return super.getPageContext();
    }

    public com.baidu.tieba.frs.entelechy.b.b azs() {
        return this.dAF;
    }

    public com.baidu.adp.widget.ListView.n azt() {
        return this.dBA;
    }

    public com.baidu.tieba.frs.mc.d azu() {
        return this.dAI;
    }

    public com.baidu.tieba.frs.smartsort.b azv() {
        return this.dAB;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public FrsModelController azw() {
        return this.dAx;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public com.baidu.tieba.frs.mc.c azx() {
        return this.dAJ;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public com.baidu.tieba.frs.vc.f azy() {
        return this.dAy;
    }

    public com.baidu.tieba.frs.vc.j azz() {
        return this.dAz;
    }

    public an azA() {
        return this.dAD;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public k azB() {
        return this.dAn;
    }

    @Override // com.baidu.tieba.frs.am
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.am, com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.dAf;
    }

    public void setForumName(String str) {
        this.dAf = str;
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
        if (this.dAJ == null) {
            return 1;
        }
        return this.dAJ.getPn();
    }

    public int getPn() {
        if (this.dAJ == null) {
            return 1;
        }
        return this.dAJ.getPn();
    }

    public void setPn(int i) {
        if (this.dAJ != null) {
            this.dAJ.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.dAJ != null) {
            this.dAJ.setHasMore(i);
        }
    }

    public int azC() {
        if (this.dAJ == null) {
            return -1;
        }
        return this.dAJ.azC();
    }

    public boolean azD() {
        return this.dAl;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d.a aVar) {
        if (aVar == null) {
            String string = TbadkCoreApplication.getInst().getString(e.j.error_unkown_try_again);
            this.dAn.aAt();
            showNetRefreshView(this.dAn.aAJ(), string, true);
        } else if (340001 == aVar.errorCode) {
            a(aVar, this.dzP.bzX());
        } else {
            if (com.baidu.tbadk.core.util.v.J(this.dzP.getThreadList())) {
                b(aVar);
            }
            if (azU()) {
                setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst(), e.C0175e.ds280));
            } else {
                setNetRefreshViewEmotionDefMarginTop();
            }
        }
    }

    public void a(View view, String str, boolean z, List<RecmForumInfo> list) {
        this.dAn.aAt();
        this.dAn.lu(8);
        if (this.dAS == null) {
            this.dAS = new com.baidu.tieba.frs.view.a(getPageContext(), getNetRefreshListener());
        }
        this.dAS.hU(str);
        this.dAS.bS(list);
        this.dAS.c(view, z);
    }

    private void a(d.a aVar, List<RecmForumInfo> list) {
        if (this.dAn != null) {
            this.dAn.aAt();
            this.dAn.setTitle(this.dAf);
            a(this.dAn.aAJ(), aVar.errorMsg, true, list);
        }
    }

    private void b(d.a aVar) {
        this.dAn.aAt();
        if (aVar.gZA) {
            showNetRefreshView(this.dAn.aAJ(), TbadkCoreApplication.getInst().getString(e.j.net_error_text, new Object[]{aVar.errorMsg, Integer.valueOf(aVar.errorCode)}), true);
        } else {
            showNetRefreshView(this.dAn.aAJ(), aVar.errorMsg, true);
        }
    }

    public void azE() {
        hideLoadingView(this.dAn.aAJ());
        if (!this.dAn.azT()) {
            this.dAn.gp(false);
        } else {
            this.dAn.gp(true);
        }
        if (this.dAn.aAr() instanceof com.baidu.tieba.frs.tab.c) {
            ((com.baidu.tieba.frs.tab.c) this.dAn.aAr()).aFG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azF() {
        if (azC() == 0 && com.baidu.tbadk.core.util.v.J(this.dzP.bAg())) {
            if (com.baidu.tbadk.core.util.v.J(this.dzP.getThreadList())) {
                this.dAn.ZL();
            } else {
                this.dAn.ZK();
            }
        } else if (com.baidu.tbadk.core.util.v.I(this.dzP.getThreadList()) > 3) {
            this.dAn.ZJ();
        } else {
            this.dAn.aAM();
        }
    }

    public void a(ErrorData errorData) {
        azE();
        this.dAn.aAy();
        d.a aFb = this.dAx.aFb();
        boolean J = com.baidu.tbadk.core.util.v.J(this.dzP.getThreadList());
        if (aFb != null && J) {
            if (this.dAx.aFc() != 0) {
                this.dAx.aFi();
                this.dAn.aAy();
            } else {
                a(aFb);
            }
            this.dAn.z(this.dzP.bBk(), false);
            return;
        }
        a(aFb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ln(int i) {
        List<WindowToast> list;
        if (TbadkCoreApplication.isLogin() && this.dzP != null && (list = this.dzP.hbf) != null && list.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < list.size()) {
                    WindowToast windowToast = list.get(i3);
                    if (windowToast == null || windowToast.toast_type.intValue() != i) {
                        i2 = i3 + 1;
                    } else if (!com.baidu.tbadk.core.util.ao.isEmpty(windowToast.toast_link)) {
                        sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(getPageContext().getPageActivity(), "", com.baidu.tbadk.util.ab.iw(windowToast.toast_link), true)));
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
    public void azG() {
        if (this.dzP == null || this.dzP.beT() != null) {
            this.dAn.aAH();
        } else if (this.dzP.beT().getYuleData() != null && this.dzP.beT().getYuleData().Am()) {
            TiebaStatic.log("c10852");
            this.dAn.a(this.dzP.beT().getYuleData().An());
        } else {
            this.dAn.aAH();
        }
    }

    private void x(boolean z, boolean z2) {
        if (this.dAx != null && this.dzP != null && this.dAn != null && z) {
            if (!this.dAx.aFo() && this.dAx.aFe() == 1) {
                if (!this.dAx.aFm()) {
                    this.dzP.bBa();
                    this.dzP.bBb();
                }
                boolean z3 = false;
                if (this.dAn.aAI().k(com.baidu.tieba.card.data.n.cQD)) {
                    z3 = this.dzP.bBe();
                }
                if (!z3) {
                    this.dzP.bBc();
                }
                if (TbadkCoreApplication.getInst().isRecAppExist()) {
                    this.dzP.a(this);
                }
                if (!this.dAn.aAI().k(bb.aoW)) {
                    this.dzP.bAT();
                }
                this.dzP.bBf();
            }
            if (!this.dAn.aAI().k(bb.aoW)) {
                this.dzP.bAZ();
                this.dzP.bAX();
            } else {
                this.dzP.bAY();
                this.dzP.bAW();
            }
            this.dzP.bAU();
            this.dzP.bAR();
            if (this.dAn.aAI().k(com.baidu.tieba.h.b.ecy)) {
                this.dzP.nd(z2);
            }
            if (TbadkCoreApplication.isLogin() && (!this.dAx.aFo() || this.dAx.isNetFirstLoad)) {
                this.dzP.bBg();
            }
            this.dzP.bBi();
        }
    }

    public boolean azH() {
        if (this.dAy != null && this.dAx != null) {
            this.dAy.a(this.dAx.getPageType(), this.dzP);
        }
        boolean z = false;
        if (this.dzP != null) {
            z = this.dzP.bBl();
        }
        azJ();
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lo(int i) {
        ao aoVar = null;
        azH();
        azQ();
        try {
            if (this.dzP != null) {
                this.dAn.a((ArrayList<com.baidu.adp.widget.ListView.h>) null, this.dzP);
                this.dAy.mL(1);
                this.dAn.aAB();
                this.dAz.a(this.dzP, this.dAx.aFk());
                com.baidu.tieba.frs.tab.d mR = this.dAz.mR(this.dzP.bAq());
                if (mR != null && !TextUtils.isEmpty(mR.url)) {
                    aoVar = new ao();
                    aoVar.dEa = mR.url;
                    aoVar.stType = mR.name;
                }
                this.dAx.a(this.dzP.bAq(), 0, aoVar);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(boolean z, boolean z2) {
        try {
            if (this.dzP != null && this.dAz != null && this.dAx != null) {
                if (!this.dAn.aAI().k(bb.aoW)) {
                    this.dzP.bAT();
                }
                boolean J = com.baidu.tbadk.core.util.v.J(this.dzP.bAE());
                this.dAn.gm(J);
                if (!J) {
                    if (this.dAT == null) {
                        this.dAT = new com.baidu.tieba.frs.vc.e(this, (NoPressedRelativeLayout) this.mRootView);
                    }
                    if (this.bTU == null) {
                        this.bTU = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
                    }
                } else {
                    this.dAT = null;
                    this.bTU = null;
                }
                if (this.dzP.beT() != null) {
                    this.dAf = this.dzP.beT().getName();
                    this.forumId = this.dzP.beT().getId();
                }
                if (this.dzP.bBl()) {
                    this.dAz.a(this.dzP, this.dAx.aFk());
                }
                if (z) {
                    x(true, z);
                } else {
                    x(this.dAw, z);
                }
                azH();
                if (this.dAF != null) {
                    this.dAF.a(this.dAy, this.dzP);
                }
                if (this.dzP.xH() != null) {
                    setHasMore(this.dzP.xH().xD());
                }
                ArrayList<com.baidu.adp.widget.ListView.h> a2 = this.dAJ.a(z2, true, this.dzP.getThreadList(), null, z, false);
                if (a2 != null) {
                    this.dzP.ay(a2);
                }
                this.dzP.bBh();
                if (this.dAx.aFe() == 1) {
                    azN();
                    if (!z && this.dAx.getPn() == 1) {
                        azI();
                    }
                }
                this.dzS = this.dzP.aFg();
                if (this.dAj != null) {
                    this.dAi = true;
                    this.dAj.uC(this.dzS);
                    com.baidu.tieba.frs.f.a.a(this, this.dzP.beT(), this.dzP.getThreadList(), this.dAi, getPn());
                }
                if (this.dAH != null) {
                    this.dAH.aQ(this.dAz.aGn());
                }
                azE();
                this.dAn.aAu();
                this.dAn.z(true, false);
                if (this.dzP.beT() != null) {
                    this.dAn.nA(this.dzP.beT().getWarningMsg());
                }
                if (this.dzP != null && this.dzP.bAH() != null && com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("frs_video_activity_guide", 0L) == 0) {
                    com.baidu.adp.lib.g.e.jI().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.11
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsFragment.this.dAn.aAR();
                        }
                    }, 1000L);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2921326, this));
                this.dAn.aAn();
                if (this.dzP != null && this.dzP.beT() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016564, new VisitedForumData(this.dzP.beT().getId(), this.dzP.beT().getName(), this.dzP.beT().getImage_url(), String.valueOf(System.currentTimeMillis() / 1000), "showlive".equals(this.dzP.beT().special_forum_type))));
                }
                this.dAZ.a(this.dzP.hbk, this.dzP.beT());
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void azI() {
        if (this.dAM == null) {
            this.dAM = new com.baidu.tieba.frs.live.a(this, com.baidu.adp.lib.g.b.l(this.forumId, 0));
        }
        this.dAM.aEM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.i iVar) {
        try {
            if (!this.dAt && iVar != null && this.dzP != null) {
                this.dzP.f(iVar);
                y(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void azJ() {
        if (this.dAx != null) {
            ny(this.dAx.getPageType());
        } else {
            ny("normal_page");
        }
    }

    private void ny(String str) {
        gf("frs_page".equals(str));
        if (this.dAF != null) {
            this.dAF.a(this.dAy, this.dAn, this.dzP);
        }
    }

    public void gf(boolean z) {
        if (this.dAK != null) {
            this.dAK.c(this.dAn, z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(e.h.frs_activity, viewGroup, false);
            this.dzZ = new com.baidu.tieba.frs.entelechy.b();
            this.dAF = this.dzZ.aCj();
            this.dAy = new com.baidu.tieba.frs.vc.f(this, this.dzZ, (FrsHeaderViewContainer) this.mRootView.findViewById(e.g.header_view_container));
            this.dAz = new FrsTabViewController(this, this.mRootView);
            this.dAy.a(this.dAz);
            this.dAz.a(this.dBj);
            Intent intent = getActivity().getIntent();
            if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                this.dAb = true;
            }
            this.dAn = new k(this, this.dBy, this.dzZ, this.dAb, this.dAy);
            this.dAn.setHeaderViewHeight(this.dAQ);
            this.dAZ = new com.baidu.tieba.frs.brand.buttommenu.a(getPageContext(), this.mRootView);
        } else {
            if (this.mRootView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            this.dAn.aAQ();
        }
        this.dBc = true;
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        this.dgR = System.currentTimeMillis();
        this.beginTime = this.dgR;
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.dAk = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.dgR = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            M(intent);
        }
        this.bbA = this.beginTime - this.dgR;
        this.dAj = new com.baidu.tieba.tbadkCore.data.e("frs", com.baidu.tieba.tbadkCore.data.e.hcu);
        this.dAx = new FrsModelController(this, this.dBu);
        this.dAx.a(this.dBi);
        this.dAx.init();
        if (intent != null) {
            this.dAx.j(intent.getExtras());
        } else if (bundle != null) {
            this.dAx.j(bundle);
        } else {
            this.dAx.j(null);
        }
        if (intent != null) {
            this.dAy.n(intent.getExtras());
        } else if (bundle != null) {
            this.dAy.n(bundle);
        } else {
            this.dAy.n((Bundle) null);
        }
        this.dAm = getVoiceManager();
        this.dAN = new j(getPageContext(), this);
        initUI();
        initData(bundle);
        if (!azU()) {
            this.dAD = new an(getActivity(), this.dAn, this.dAy);
            this.dAD.gD(true);
        }
        this.dAm = getVoiceManager();
        if (this.dAm != null) {
            this.dAm.onCreate(getPageContext());
        }
        new com.baidu.tieba.frs.mc.g();
        this.dAJ = new com.baidu.tieba.frs.mc.c(this, this.dBw);
        this.dAB = new com.baidu.tieba.frs.smartsort.b(this);
        this.dAK = new com.baidu.tieba.frs.vc.h(this);
        this.dAH = new com.baidu.tieba.frs.vc.a(getPageContext(), this.dAx.aFl());
        this.dAC = new com.baidu.tieba.frs.mc.b(this);
        this.dAI = new com.baidu.tieba.frs.mc.d(this);
        this.dAA = new com.baidu.tieba.frs.mc.f(this);
        this.dAL = new com.baidu.tieba.frs.mc.a(this);
        this.dAO = new com.baidu.tieba.frs.vc.c(this);
        this.dAP = new com.baidu.tieba.frs.mc.e(this, getUniqueId());
        this.dAW = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "frs");
        this.dAX = new com.baidu.tieba.ala.a(getPageContext());
        registerListener(this.bQJ);
        registerListener(this.mMemListener);
        registerListener(this.dBp);
        registerListener(this.dBx);
        registerListener(this.dBo);
        registerListener(this.dBv);
        registerListener(this.dBl);
        registerListener(this.dBm);
        registerListener(this.dBn);
        registerListener(this.dBf);
        registerListener(this.dBg);
        registerListener(this.dBC);
        registerListener(this.dBs);
        registerListener(this.dBh);
        registerListener(this.dBt);
        registerListener(this.dBr);
        this.dBe.setTag(getPageContext().getUniqueId());
        registerListener(this.dBe);
        this.dAn.go(false);
        if (!azU() && !this.hasInit) {
            showLoadingView(this.dAn.aAJ(), true);
            this.dAx.r(3, false);
        }
        com.baidu.tieba.frs.a.ayN().a(new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.15
            @Override // com.baidu.tieba.frs.a.b
            public void w(boolean z, boolean z2) {
                if (FrsFragment.this.dAn != null) {
                    FrsFragment.this.dAn.lv(z ? 0 : 8);
                    if (!z2) {
                        FrsFragment.this.dBb = z;
                    }
                    if (FrsFragment.this.dAn.aAI() != null && FrsFragment.this.dAx != null && FrsFragment.this.dAx.aFf()) {
                        FrsFragment.this.dAn.aAI().notifyDataSetChanged();
                    }
                    if (FrsFragment.this.dAn.aAs() != null) {
                        FrsFragment.this.dAn.gl(!z);
                    }
                    if (FrsFragment.this.getActivity() instanceof FrsActivity) {
                        ((FrsActivity) FrsFragment.this.getActivity()).ge(!z);
                    }
                    if (FrsFragment.this.dAZ != null) {
                        FrsFragment.this.dAZ.gM(!z);
                    }
                    FrsFragment.this.dAn.gq(!z);
                    FrsFragment.this.dAn.gr(z ? false : true);
                }
            }

            @Override // com.baidu.tieba.frs.a.b
            public void lk(int i) {
                if (FrsFragment.this.dAn != null) {
                    FrsFragment.this.dAn.lw(i);
                }
            }

            @Override // com.baidu.tieba.frs.a.b
            public void ayT() {
                com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getContext(), e.j.frs_multi_delete_max_num);
            }
        });
        this.dAn.b(new d.a() { // from class: com.baidu.tieba.frs.FrsFragment.16
            @Override // com.baidu.tieba.NEGFeedBack.d.a
            public void a(DeleteThreadHttpResponseMessage deleteThreadHttpResponseMessage) {
                int i;
                int i2 = 0;
                if (deleteThreadHttpResponseMessage != null) {
                    FrsFragment.this.dAn.Tk();
                    FrsFragment.this.dAn.aAS();
                    if (deleteThreadHttpResponseMessage.getError() == 0) {
                        String text = !TextUtils.isEmpty(deleteThreadHttpResponseMessage.getText()) ? deleteThreadHttpResponseMessage.getText() : FrsFragment.this.getString(e.j.delete_fail);
                        if (deleteThreadHttpResponseMessage.getRetType() == 1211066) {
                            if (FrsFragment.this.cPo == null) {
                                FrsFragment.this.cPo = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.cPo.ej(text);
                            FrsFragment.this.cPo.a(e.j.dialog_known, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.16.1
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.cPo.aP(false);
                            FrsFragment.this.cPo.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.cPo.Au();
                        } else if (deleteThreadHttpResponseMessage.getRetType() == 1211067) {
                            if (FrsFragment.this.cPo == null) {
                                FrsFragment.this.cPo = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.cPo.ej(text);
                            FrsFragment.this.cPo.a(e.j.know, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.16.2
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.cPo.aP(false);
                            FrsFragment.this.cPo.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.cPo.Au();
                        } else {
                            FrsFragment.this.dAn.ab(deleteThreadHttpResponseMessage.getText(), ContextCompat.getColor(FrsFragment.this.getContext(), deleteThreadHttpResponseMessage.getRetType() == 1 ? e.d.nav_bar_tip_error : e.d.cp_link_tip_a_alpha95));
                        }
                        FrsFragment.this.bC(deleteThreadHttpResponseMessage.getSuccessItems());
                        com.baidu.tieba.frs.a.ayN().bB(deleteThreadHttpResponseMessage.getSuccessItems());
                        Iterator<com.baidu.adp.widget.ListView.h> it = FrsFragment.this.dzP.getThreadList().iterator();
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
                            FrsFragment.this.YL();
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

    public void gg(boolean z) {
        if (this.dAz != null) {
            this.dAz.dWo = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bC(List<String> list) {
        if (!com.baidu.tbadk.core.util.v.J(list)) {
            ArrayList<com.baidu.adp.widget.ListView.h> threadList = this.dzP.getThreadList();
            if (!com.baidu.tbadk.core.util.v.J(threadList) && this.dAn.getListView() != null && this.dAn.getListView().getData() != null) {
                Iterator<com.baidu.adp.widget.ListView.h> it = threadList.iterator();
                List<com.baidu.adp.widget.ListView.h> data = this.dAn.getListView().getData();
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
                                this.dAJ.ab(bbVar);
                                this.dAn.getListView().getAdapter().notifyItemRemoved(i);
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
    public void Zl() {
        if (isAdded() && this.bNr && !isLoadingViewAttached()) {
            showLoadingView(this.dAn.aAJ(), true);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void Zm() {
        if (isAdded() && this.bNr && isLoadingViewAttached()) {
            hideLoadingView(this.dAn.aAJ());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (azU()) {
            showLoadingView(this.dAn.aAJ(), true);
            this.dAn.lx(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.dAx.r(3, true);
            Eg().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void setHeaderViewHeight(int i) {
        this.dAQ = i;
        if (this.dAn != null) {
            this.dAn.setHeaderViewHeight(this.dAQ);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.u uVar) {
        if (uVar != null) {
            this.bey = uVar.OO();
            this.dAR = uVar.OP();
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void showFloatingView() {
        if (this.bey != null) {
            this.bey.cA(true);
        }
    }

    private void M(Intent intent) {
        if (intent != null) {
            if (!com.baidu.tieba.frs.f.f.a(this, getForumName(), "from", intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false)) && getActivity() != null) {
                getActivity().finish();
                return;
            }
        }
        if (intent != null && intent.getData() != null) {
            Uri data = intent.getData();
            this.dAf = data.getQueryParameter("name");
            this.mFrom = data.getQueryParameter("from");
            if (!StringUtils.isNull(this.dAf)) {
                intent.putExtra("name", this.dAf);
            }
            if (!StringUtils.isNull(this.mFrom)) {
                intent.putExtra("from", this.mFrom);
            }
            TiebaStatic.log("c10105");
        }
        if (StringUtils.isNull(this.dAf)) {
            com.baidu.tieba.frs.f.d O = com.baidu.tieba.frs.f.i.O(intent);
            if (O != null) {
                this.dAf = O.forumName;
                if (O.dUH != null && O.dUH.equals("aidou")) {
                    com.baidu.tbadk.core.dialog.h.asU = System.currentTimeMillis();
                }
            }
            if (!StringUtils.isNull(this.dAf)) {
                intent.putExtra("name", this.dAf);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.dAm = getVoiceManager();
        if (this.dAm != null) {
            this.dAm.onStart(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        Intent intent;
        registerListener(2001118, this.aLF);
        if (bundle != null) {
            this.dAf = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
            this.dAf = intent.getStringExtra("name");
            this.mFrom = intent.getStringExtra("from");
            this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
        }
        if (getArguments() != null) {
            this.dAg = getArguments().getBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, false);
        }
        if (TextUtils.isEmpty(this.mFrom) || FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
        }
        if (this.mIsLogin) {
            registerListener(2001120, this.aLF);
        }
        this.dAy.n(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dBC);
        if (this.dAm != null) {
            this.dAm.onDestory(getPageContext());
        }
        com.baidu.tieba.recapp.report.a.remove("FRS");
        this.dAm = null;
        com.baidu.tieba.card.v.aop().fh(false);
        if (this.dzP != null && this.dzP.beT() != null) {
            ac.aBq().bS(com.baidu.adp.lib.g.b.d(this.dzP.beT().getId(), 0L));
        }
        if (this.dAM != null) {
            this.dAM.onDestory();
        }
        if (this.dAn != null) {
            com.baidu.tieba.frs.f.h.a(this.dAn, this.dzP, getForumId(), false, null);
            this.dAn.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.dAv != null) {
                this.dAv.NP();
            }
            this.dAn.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.dAx.onActivityDestroy();
        this.dAy.onActivityDestroy();
        if (this.dAx != null) {
            this.dAx.aaV();
        }
        if (this.dAD != null) {
            this.dAD.ON();
        }
        if (this.dAG != null) {
            this.dAG.destory();
        }
        if (this.dAH != null) {
            this.dAH.destory();
        }
        if (this.dAB != null) {
            this.dAB.onDestroy();
        }
        if (this.dAT != null) {
            this.dAT.onDestory();
        }
        if (this.dAL != null) {
            this.dAL.onDestroy();
        }
        if (this.dAW != null) {
            this.dAW.onDestroy();
        }
        if (this.dAX != null) {
            this.dAX.onDestroy();
        }
        com.baidu.tieba.recapp.d.a.bua().buc();
        com.baidu.tieba.frs.f.j.aFI();
        if (this.dAz != null) {
            this.dAz.a((FrsTabViewController.a) null);
            this.dAz.aGq();
        }
        if (this.dAY != null) {
            this.dAY.onDestroy();
        }
        if (this.dBa != null) {
            this.dBa.onDestroy();
        }
        com.baidu.tieba.frs.a.ayN().a(null);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.dAf);
        bundle.putString("from", this.mFrom);
        this.dAx.onSaveInstanceState(bundle);
        if (this.dAm != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            this.dAm.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.dAL != null) {
            this.dAL.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dAn != null) {
            this.dAn.aAy();
            this.dAn.onResume();
        }
        this.dAA.ha(true);
        this.dAw = true;
        if (dAe) {
            dAe = false;
            this.dAn.startPullRefresh();
            return;
        }
        if (this.dAm != null) {
            this.dAm.onResume(getPageContext());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921338));
        this.dAn.gs(false);
        if (this.dAU) {
            refresh(6);
            this.dAU = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
    }

    public boolean azK() {
        Intent intent;
        if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
            return false;
        }
        return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
    }

    public void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.dAf = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.dAh = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.dAh) {
                azL();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azL() {
        this.dAn.startPullRefresh();
    }

    public void closeActivity() {
        com.baidu.tieba.frs.f.i.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.mFrom);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.dAn.setTitle(this.dAf);
        } else {
            this.dAn.setTitle("");
            this.mFlag = 1;
        }
        this.dAn.setOnAdapterItemClickListener(this.dBA);
        this.dAn.addOnScrollListener(this.mScrollListener);
        this.dAn.h(this.dxY);
        this.dAn.aAI().a(this.dBz);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dBc) {
            this.dAn.onChangeSkinType(i);
            this.dAy.mK(i);
            this.dAz.onChangeSkinType(i);
            if (this.dAS != null) {
                this.dAS.onChangeSkinType();
            }
            if (this.dAY != null) {
                this.dAY.onChangeSkinType(i);
            }
            if (this.dAZ != null) {
                this.dAZ.d(getPageContext(), i);
            }
            if (this.cPo != null) {
                com.baidu.tbadk.o.a.a(getPageContext(), this.cPo.Av());
            }
        }
    }

    public void lp(int i) {
        if (!this.mIsLogin) {
            if (this.dzP != null && this.dzP.xs() != null) {
                this.dzP.xs().setIfpost(1);
            }
            if (i == 0) {
                ba.bH(getActivity());
            }
        } else if (this.dzP != null) {
            if (i == 0) {
                com.baidu.tieba.frs.f.j.d(this, 0);
            } else {
                this.dAn.aAA();
            }
        }
    }

    public void refresh() {
        com.baidu.tieba.a.d.Ux().jp("page_frs");
        refresh(3);
    }

    public void refresh(int i) {
        this.dAt = false;
        azQ();
        if (this.dAn.aAq() != null) {
            this.dAn.aAq().aLh();
        }
        this.dAx.r(i, true);
    }

    private void azM() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.g.h.jJ().d(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.20
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.vf(FrsFragment.this.dAf);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azN() {
        azQ();
        try {
            if (this.dzP != null) {
                this.dAn.amh();
                this.dAn.gl(azZ());
                if (!com.baidu.tieba.frs.vc.f.k(this.dzP) || !com.baidu.tieba.frs.vc.f.j(this.dzP)) {
                }
                if (this.dzP.beT() != null) {
                    this.dAf = this.dzP.beT().getName();
                    this.forumId = this.dzP.beT().getId();
                }
                if (this.dzP.xH() != null) {
                    setHasMore(this.dzP.xH().xD());
                }
                this.dAn.setTitle(this.dAf);
                this.dAn.setForumName(this.dAf);
                TbadkCoreApplication.getInst().setDefaultBubble(this.dzP.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.dzP.getUserData().getBimg_end_time());
                azM();
                azO();
                ArrayList<com.baidu.adp.widget.ListView.h> threadList = this.dzP.getThreadList();
                if (threadList != null) {
                    this.dAn.a(threadList, this.dzP);
                    com.baidu.tieba.frs.f.c.w(this.dAn);
                    this.dAy.mL(getPageNum());
                    this.dAy.h(this.dzP);
                    this.dAz.a(this.dzP, this.dAx.aFk());
                    this.dAn.aAB();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void azO() {
        if (this.dzP != null) {
            if (this.dzP.bfi() == 1) {
                this.dAn.aAI().setFromCDN(true);
            } else {
                this.dAn.aAI().setFromCDN(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.dAA.ha(false);
        this.dAw = false;
        this.dAn.onPause();
        if (this.dAm != null) {
            this.dAm.onPause(getPageContext());
        }
        this.dAn.gs(true);
        if (this.dAH != null) {
            this.dAH.aFL();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.dAz != null && this.dAz.aGo() != null && (this.dAz.aGo().fragment instanceof BaseFragment)) {
            ((BaseFragment) this.dAz.aGo().fragment).setPrimary(z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.v.aop().fh(false);
        if (this.dzP != null && this.dzP.beT() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            com.baidu.tbadk.distribute.a.Ku().a(getPageContext().getPageActivity(), "frs", this.dzP.beT().getId(), 0L);
        }
        if (this.dAm != null) {
            this.dAm.onStop(getPageContext());
        }
        if (Eg() != null) {
            Eg().getRecycledViewPool().clear();
        }
        this.dAy.onActivityStop();
        com.baidu.tbadk.util.v.OR();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            if (this.dAy != null) {
                this.dAy.gj(isPrimary());
            }
            if (this.dAn != null) {
                this.dAn.gj(isPrimary());
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (com.baidu.tieba.frs.a.ayN().ayO()) {
                com.baidu.tieba.frs.a.ayN().reset();
                return true;
            } else if (this.dAn != null) {
                return this.dAn.aAx();
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
        com.baidu.tbadk.distribute.a.Ku().a(advertAppInfo, this.forumId, 0L, "FRS", str, getPn());
    }

    @Override // com.baidu.tieba.recapp.n
    public void azP() {
        azw().azP();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dAm == null) {
            this.dAm = VoiceManager.instance();
        }
        return this.dAm;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdRecyclerView Eg() {
        if (this.dAn == null) {
            return null;
        }
        return this.dAn.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void azQ() {
        if (this.dAm != null) {
            this.dAm.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> Eh() {
        if (this.aGx == null) {
            this.aGx = UserIconBox.l(getPageContext().getPageActivity(), 8);
        }
        return this.aGx;
    }

    public void azR() {
        if (getFragmentActivity() != null && getFragmentActivity().getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.a(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.k onGetPreLoadListView() {
        return Eg().getPreLoadHandle();
    }

    @Override // com.baidu.tieba.frs.ak
    public NavigationBar aaE() {
        if (this.dAn == null) {
            return null;
        }
        return this.dAn.aaE();
    }

    @Override // com.baidu.tbadk.core.view.NavigationBar.a
    public void b(Pair<Integer, Integer> pair) {
        this.dAr = pair;
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
                if (bdUniqueId == p.dCW) {
                    if (FrsFragment.this.dAn != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11752").ax(ImageViewerConfig.FORUM_ID, FrsFragment.this.forumId).ax("obj_locate", "1"));
                        FrsFragment.this.dAn.startPullRefresh();
                    }
                } else if (hVar != null && (hVar instanceof bb)) {
                    bb bbVar = (bb) hVar;
                    if (bbVar.zh() == null || bbVar.zh().getGroup_id() == 0 || ba.bI(FrsFragment.this.getActivity())) {
                        if (bbVar.yZ() != 1 || ba.bI(FrsFragment.this.getActivity())) {
                            if (bbVar.yJ() != null) {
                                if (ba.bI(FrsFragment.this.getActivity())) {
                                    String postUrl = bbVar.yJ().getPostUrl();
                                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.lo()) {
                                        com.baidu.tbadk.browser.a.ag(FrsFragment.this.getActivity(), postUrl);
                                    }
                                }
                            } else if (bbVar.zq() != null) {
                                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                    ba.bH(FrsFragment.this.getPageContext().getPageActivity());
                                    return;
                                }
                                com.baidu.tbadk.core.data.m zq = bbVar.zq();
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), zq.getCartoonId(), zq.getChapterId(), 2)));
                            } else {
                                com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                                if (readThreadHistory != null && !readThreadHistory.vl(bbVar.getId())) {
                                    readThreadHistory.vk(bbVar.getId());
                                }
                                boolean z = false;
                                final String yD = bbVar.yD();
                                if (yD != null && !yD.equals("")) {
                                    z = true;
                                    new Thread(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.a.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(yD);
                                            xVar.BY().CW().mIsNeedAddCommenParam = false;
                                            xVar.BY().CW().mIsUseCurrentBDUSS = false;
                                            xVar.BB();
                                        }
                                    }).start();
                                }
                                String tid = bbVar.getTid();
                                if (tid == null) {
                                    tid = "";
                                }
                                if (bbVar.yq() == 2 && !tid.startsWith("pb:")) {
                                    ay.CU().c(FrsFragment.this.getPageContext(), new String[]{tid, "", null});
                                    return;
                                }
                                if (tid.startsWith("pb:")) {
                                    bbVar.setId(tid.substring(3));
                                }
                                if (bdUniqueId.getId() == bb.aqq.getId()) {
                                    com.baidu.tieba.frs.f.h.a(bbVar.yc());
                                } else if (bdUniqueId.getId() == bb.aoZ.getId()) {
                                    com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c12940");
                                    amVar.ax("obj_type", "2");
                                    amVar.ax("tid", bbVar.getTid());
                                    TiebaStatic.log(amVar);
                                }
                                com.baidu.tieba.frs.f.i.a(FrsFragment.this, bbVar, i, z);
                                com.baidu.tieba.frs.f.h.a(FrsFragment.this, FrsFragment.this.dzP, bbVar);
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
            hideNetRefreshView(this.dAn.aAJ());
            showLoadingView(this.dAn.aAJ(), true);
            this.dAn.go(false);
            this.dAx.r(3, true);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public com.baidu.tieba.tbadkCore.l azS() {
        return this.dzP;
    }

    public boolean azT() {
        return this.dAn.azT();
    }

    public void ad(Object obj) {
        if (this.dAC != null && this.dAC.dSd != null) {
            this.dAC.dSd.m(obj);
        }
    }

    public void ae(Object obj) {
        if (this.dAC != null && this.dAC.dSe != null) {
            this.dAC.dSe.m(obj);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        this.dAn.getListView().stopScroll();
        if (!this.dAn.aAE()) {
            if (!com.baidu.adp.lib.util.l.lo()) {
                this.dAn.ZL();
            } else if (this.dAx.aFe() == 1) {
                YZ();
                YL();
            } else if (this.dAx.hasMore()) {
                YL();
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void nh(String str) {
        YZ();
        showToast(str);
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void O(ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        boolean J = com.baidu.tbadk.core.util.v.J(arrayList);
        setHasMore(J ? 0 : 1);
        YZ();
        if (!J) {
            if (!this.dAx.aFo() && TbadkCoreApplication.getInst().isRecAppExist() && this.dAx.aFe() == 1) {
                this.dzP.a(this, arrayList);
            }
            ArrayList<com.baidu.adp.widget.ListView.h> a2 = this.dAJ.a(false, false, arrayList, this.dAj, false);
            if (a2 != null) {
                this.dzP.ay(a2);
                this.dAn.a(a2, this.dzP);
            }
            if (this.dAx != null) {
                com.baidu.tieba.frs.e.b.a(this.dzP, this.dAx.aFk(), 2);
            }
        }
    }

    private void YZ() {
        if (azC() == 1 || this.dAJ.bO(this.dzP.bAg())) {
            if (com.baidu.tbadk.core.util.v.I(this.dzP.getThreadList()) > 3) {
                this.dAn.ZJ();
            } else {
                this.dAn.aAM();
            }
        } else if (com.baidu.tbadk.core.util.v.J(this.dzP.getThreadList())) {
            this.dAn.ZL();
        } else {
            this.dAn.ZK();
        }
    }

    @Override // com.baidu.tieba.frs.mc.j
    public void YL() {
        if (this.dAJ != null) {
            this.dAJ.a(this.dAf, this.forumId, this.dzP);
        }
    }

    public void takePhoto() {
        if (!com.baidu.tbadk.core.util.ab.e(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.ak.b(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        if (this.dAs) {
            return null;
        }
        if (azU()) {
            return "a034";
        }
        return "a006";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (!azU()) {
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

    public void gh(boolean z) {
        if (this.dAD != null) {
            this.dAD.gD(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.dAE.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a gQ(int i) {
        return this.dAE.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        this.dAN.b(bVar);
    }

    public boolean azU() {
        return this.dAb;
    }

    @Override // com.baidu.tieba.frs.ah
    public void Zk() {
        if (this.dAn != null) {
            showFloatingView();
            this.dAn.getListView().scrollToPosition(0);
            this.dAn.startPullRefresh();
        }
    }

    public ForumWriteData azV() {
        if (this.dzP == null || this.dzP.beT() == null) {
            return null;
        }
        ForumData beT = this.dzP.beT();
        ForumWriteData forumWriteData = new ForumWriteData(beT.getId(), beT.getName(), beT.getPrefixData(), this.dzP.xs());
        forumWriteData.avatar = beT.getImage_url();
        forumWriteData.forumLevel = beT.getUser_level();
        forumWriteData.specialForumType = beT.special_forum_type;
        forumWriteData.firstDir = beT.getFirst_class();
        forumWriteData.secondDir = beT.getSecond_class();
        UserData userData = this.dzP.getUserData();
        forumWriteData.privateThread = userData != null ? userData.getPrivateThread() : 0;
        return forumWriteData;
    }

    @Override // com.baidu.tieba.frs.ah
    public void DV() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.frs.ah
    public void setVideoThreadId(String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z) {
        super.showLoadingView(view, z);
        this.dAn.lu(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        super.hideLoadingView(view);
        this.dAn.lu(0);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        super.showNetRefreshView(view, str, z);
        this.dAn.lu(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshViewNoClick(View view, String str, boolean z) {
        super.showNetRefreshViewNoClick(view, str, z);
        this.dAn.lu(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        super.hideNetRefreshView(view);
        this.dAn.lu(0);
    }

    public void azW() {
        FrsTabViewController.b aGo;
        if (this.dAz != null && (aGo = this.dAz.aGo()) != null && aGo.fragment != null && (aGo.fragment instanceof aj)) {
            ((aj) aGo.fragment).azl();
        }
    }

    public void a(ContriInfo contriInfo) {
        if (this.dAY == null) {
            this.dAY = new com.baidu.tbadk.core.dialog.h(getTbPageContext());
            this.dAY.a(new h.a() { // from class: com.baidu.tieba.frs.FrsFragment.29
                @Override // com.baidu.tbadk.core.dialog.h.a
                public void aW(boolean z) {
                    if (z) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13061"));
                    }
                }
            });
        }
        this.dAY.a(contriInfo, -1L);
    }

    public void gi(boolean z) {
        this.dAd = z;
    }

    public boolean azX() {
        return this.dAd;
    }

    public void nz(String str) {
        if (TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.util.ao.isEmpty(str)) {
            if (this.dBa == null) {
                this.dBa = new AddExperiencedModel(getTbPageContext());
                this.dBa.a(this.dBd);
            }
            this.dBa.cz(this.forumId, str);
        }
    }

    public com.baidu.tieba.frs.entelechy.b azY() {
        return this.dzZ;
    }

    public boolean azZ() {
        return (this.dAx != null && this.dAx.aFf() && com.baidu.tieba.frs.a.ayN().ayO()) ? false : true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.e.c
    public boolean videoNeedPreload() {
        if (this.dzP != null) {
            return com.baidu.tbadk.util.aa.OY() && (this.dzP.hbm || com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("auto_play_video_frs", 0) == 1);
        }
        return super.videoNeedPreload();
    }
}
