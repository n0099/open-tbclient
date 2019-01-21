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
    private com.baidu.adp.lib.e.b<TbImageView> aLs;
    private com.baidu.tieba.frs.gametab.b bZp;
    private com.baidu.tbadk.util.u bjC;
    private VoiceManager dLA;
    private FrsModelController dLL;
    private com.baidu.tieba.frs.vc.f dLM;
    private FrsTabViewController dLN;
    private com.baidu.tieba.frs.mc.f dLO;
    private com.baidu.tieba.frs.smartsort.b dLP;
    private com.baidu.tieba.frs.mc.b dLQ;
    private an dLR;
    private com.baidu.tieba.frs.entelechy.b.b dLT;
    private com.baidu.tbadk.i.a dLU;
    private com.baidu.tieba.frs.vc.a dLV;
    private com.baidu.tieba.frs.mc.d dLW;
    private com.baidu.tieba.frs.mc.c dLX;
    private com.baidu.tieba.frs.vc.h dLY;
    private com.baidu.tieba.frs.mc.a dLZ;
    private com.baidu.tieba.frs.entelechy.b dLn;
    private com.baidu.tieba.tbadkCore.data.e dLx;
    private com.baidu.tieba.frs.live.a dMa;
    private j dMb;
    public com.baidu.tieba.frs.vc.c dMc;
    private com.baidu.tieba.frs.mc.e dMd;
    private int dMe;
    private View.OnTouchListener dMf;
    private com.baidu.tieba.frs.view.a dMg;
    private com.baidu.tieba.frs.vc.e dMh;
    private boolean dMi;
    private com.baidu.tieba.NEGFeedBack.a dMk;
    private com.baidu.tieba.ala.a dMl;
    private com.baidu.tbadk.core.dialog.h dMm;
    private com.baidu.tieba.frs.brand.buttommenu.a dMn;
    private AddExperiencedModel dMo;
    private boolean dMq;
    private int dMy;
    private com.baidu.tbadk.core.dialog.a daF;
    public View mRootView;
    public static boolean dLs = false;
    public static volatile long dLD = 0;
    public static volatile long dLE = 0;
    public static volatile int mNetError = 0;
    public boolean dLo = false;
    private boolean dLp = false;
    private boolean dLq = false;
    private boolean dLr = true;
    public String dLt = null;
    public String mFrom = null;
    public int mFlag = 0;
    public boolean dLu = false;
    private boolean dLv = false;
    private String mThreadId = null;
    public String forumId = null;
    private int dLg = 0;
    private boolean dLw = false;
    private boolean dLy = false;
    private boolean dLz = false;
    private k dLB = null;
    public final bb bOl = null;
    private com.baidu.tieba.tbadkCore.l dLd = new com.baidu.tieba.tbadkCore.l();
    public long dse = -1;
    public long bgK = 0;
    public long bgC = 0;
    public long createTime = 0;
    public long beginTime = -1;
    public long dLC = 0;
    public Pair<Integer, Integer> dLF = null;
    public boolean dLG = false;
    private boolean dLH = false;
    private boolean dLI = false;
    public com.baidu.tbadk.l.b dLJ = null;
    private boolean dLK = true;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> dLS = new SparseArray<>();
    private boolean bSI = true;
    private boolean dMj = false;
    private boolean hasInit = false;
    private boolean dMp = false;
    private AddExperiencedModel.a dMr = new AddExperiencedModel.a() { // from class: com.baidu.tieba.frs.FrsFragment.1
        @Override // com.baidu.tieba.share.AddExperiencedModel.a
        public void b(ContriInfo contriInfo) {
            if (contriInfo != null && contriInfo.isShowToast()) {
                FrsFragment.this.a(contriInfo);
            }
        }
    };
    private HttpMessageListener dMs = new HttpMessageListener(CmdConfigHttp.CMD_PB_FLOOR_AGREE, true) { // from class: com.baidu.tieba.frs.FrsFragment.12
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
    private final CustomMessageListener dMt = new CustomMessageListener(2016495) { // from class: com.baidu.tieba.frs.FrsFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof bb) {
                    com.baidu.tieba.frs.f.h.a(FrsFragment.this.dLB, FrsFragment.this.dLd, FrsFragment.this.getForumId(), true, (bb) data);
                }
            }
        }
    };
    private CustomMessageListener dMu = new CustomMessageListener(2921005) { // from class: com.baidu.tieba.frs.FrsFragment.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.dLd != null) {
                FrsFragment.this.dLd.bDU();
                if (FrsFragment.this.dLB != null) {
                    FrsFragment.this.dLB.notifyDataChanged();
                }
            }
        }
    };
    private CustomMessageListener dMv = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.FrsFragment.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 1) {
                    FrsFragment.this.aCe();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                }
            }
        }
    };
    private final al dMw = new al() { // from class: com.baidu.tieba.frs.FrsFragment.34
        @Override // com.baidu.tieba.frs.al
        public void a(int i, int i2, ar arVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
            FrsFragment.this.aBX();
            if (FrsFragment.this.dLT != null) {
                FrsFragment.this.dLM.hu(FrsFragment.this.dLT.mM(i));
            }
            d.a aVar = new d.a();
            if (arVar != null) {
                aVar.isSuccess = arVar.errCode == 0;
                aVar.errorCode = arVar.errCode;
                aVar.errorMsg = arVar.errMsg;
                if (aVar.isSuccess) {
                    if (com.baidu.tbadk.core.util.v.I(arrayList)) {
                        FrsFragment.this.dLB.abA();
                    } else if (arVar.hasMore) {
                        if (com.baidu.tbadk.core.util.v.H(FrsFragment.this.dLd.getThreadList()) > 3) {
                            FrsFragment.this.dLB.aby();
                        } else {
                            FrsFragment.this.dLB.aDf();
                        }
                    } else if (arVar.dPq) {
                        FrsFragment.this.dLB.abz();
                    } else {
                        FrsFragment.this.dLB.abA();
                    }
                }
            } else {
                arVar = new ar();
                arVar.pn = 1;
                arVar.hasMore = false;
                arVar.dPq = false;
            }
            if (i == 1) {
                FrsFragment.this.dLK = true;
                FrsFragment.this.dMI.a(FrsFragment.this.dLL.getType(), false, aVar);
            } else {
                FrsFragment.this.a(aVar);
                if (FrsFragment.this.dLL.aGY() != null) {
                    FrsFragment.this.dLd = FrsFragment.this.dLL.aGY();
                }
                FrsFragment.this.aCg();
            }
            if (FrsFragment.this.dMP != null) {
                FrsFragment.this.dMP.a(i, i2, arVar, arrayList);
            }
        }
    };
    private FrsTabViewController.a dMx = new FrsTabViewController.a() { // from class: com.baidu.tieba.frs.FrsFragment.35
        @Override // com.baidu.tieba.frs.vc.FrsTabViewController.a
        public void fW(int i) {
            boolean z = false;
            if (i != 1) {
                com.baidu.tieba.card.v.aqP().fy(false);
                FrsFragment.this.gv(false);
            }
            if (i == 303 && i != FrsFragment.this.dMy) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13121").aB(ImageViewerConfig.FORUM_ID, FrsFragment.this.forumId).aB("uid", TbadkCoreApplication.getCurrentAccount()));
            }
            FrsFragment.this.dMy = i;
            FrsFragment.this.aCj();
            com.baidu.tieba.frs.e.d.dTG.eeN = i;
            com.baidu.tieba.frs.e.d.dTG.eeO = -1;
            com.baidu.tieba.frs.a aBg = com.baidu.tieba.frs.a.aBg();
            if (i == 1 && FrsFragment.this.dMp) {
                z = true;
            }
            aBg.x(z, true);
        }
    };
    private CustomMessageListener dMz = new CustomMessageListener(2001606) { // from class: com.baidu.tieba.frs.FrsFragment.36
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                FrsFragment.this.dLN.nO(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    };
    private CustomMessageListener dMA = new CustomMessageListener(2001607) { // from class: com.baidu.tieba.frs.FrsFragment.37
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && ((Integer) customResponsedMessage.getData()).intValue() == 51 && FrsFragment.this.dLd != null) {
                com.baidu.tieba.frs.f.j.a(FrsFragment.this.dLd, FrsFragment.this.getPageContext());
            }
        }
    };
    private final CustomMessageListener dMB = new CustomMessageListener(2003019) { // from class: com.baidu.tieba.frs.FrsFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                FrsFragment.this.dLN.nM(49);
            }
        }
    };
    private final CustomMessageListener dMC = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.frs.FrsFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && FrsFragment.this.dLd != null && FrsFragment.this.dLd.bhx() != null) {
                SignData signData = (SignData) customResponsedMessage.getData();
                int user_level = FrsFragment.this.dLd.bhx().getUser_level();
                if (signData.forumId != null && signData.forumId.equals(FrsFragment.this.dLd.bhx().getId())) {
                    FrsFragment.this.dLd.d(signData);
                    FrsFragment.this.dLM.j(FrsFragment.this.dLd);
                    if (FrsFragment.this.dLM.aIA()) {
                        i = FrsFragment.this.dLd.bhx().getUser_level();
                        if (user_level >= i) {
                            i++;
                        }
                    } else {
                        i = user_level;
                    }
                    TbadkCoreApplication.getInst().addSignedForum(FrsFragment.this.dLd.bhx().getName(), signData.sign_bonus_point, i);
                }
            }
        }
    };
    private final CustomMessageListener dMD = new CustomMessageListener(2001352) { // from class: com.baidu.tieba.frs.FrsFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.r) && FrsFragment.this.dLd != null) {
                FrsFragment.this.dLd.c((com.baidu.tieba.tbadkCore.r) customResponsedMessage.getData());
                FrsFragment.this.dLM.i(FrsFragment.this.dLd);
                FrsFragment.this.dLN.a(FrsFragment.this.dLd, FrsFragment.this.dLL.aHE());
            }
        }
    };
    private final AntiHelper.a dME = new AntiHelper.a() { // from class: com.baidu.tieba.frs.FrsFragment.5
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12536").y("obj_locate", as.a.aDr));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12535").y("obj_locate", as.a.aDr));
        }
    };
    private CustomMessageListener bVZ = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.frs.FrsFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(FrsFragment.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().aPY != null) {
                        if (AntiHelper.a(FrsFragment.this.getActivity(), updateAttentionMessage.getData().aPY, FrsFragment.this.dME) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12534").y("obj_locate", as.a.aDr));
                        }
                    } else if (updateAttentionMessage.getData().Jr && updateAttentionMessage.getData().isAttention) {
                        com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getPageContext().getPageActivity(), e.j.attention_success);
                    }
                }
            }
        }
    };
    private CustomMessageListener dMF = new CustomMessageListener(2921346) { // from class: com.baidu.tieba.frs.FrsFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsFragment.this.refresh();
        }
    };
    private CustomMessageListener dMG = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.frs.FrsFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                FrsFragment.this.dLB.c((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener dMH = new CustomMessageListener(2001626) { // from class: com.baidu.tieba.frs.FrsFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewsRemindMessage newsRemindMessage;
            if (customResponsedMessage != null && (customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626 && (newsRemindMessage = (NewsRemindMessage) customResponsedMessage) != null) {
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (FrsFragment.this.dLB != null) {
                    FrsFragment.this.dLB.p(notificationCount, z);
                }
            }
        }
    };
    private final CustomMessageListener akJ = new CustomMessageListener(2921383) { // from class: com.baidu.tieba.frs.FrsFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.isResumed()) {
                FrsFragment.this.aCt();
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.n dMI = new com.baidu.tieba.tbadkCore.n() { // from class: com.baidu.tieba.frs.FrsFragment.11
        private long startTime = 0;

        @Override // com.baidu.tieba.tbadkCore.n
        public void mm(int i) {
            this.startTime = System.nanoTime();
            if (FrsFragment.this.dLB != null) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsFragment.this.dLB.aCR();
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
            if (FrsFragment.this.bSI) {
                FrsFragment.this.bSI = false;
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.dLB, FrsFragment.this.dLd, FrsFragment.this.getForumId(), false, null);
            }
            FrsFragment.this.aBX();
            FrsFragment.this.dLH = true;
            if (aVar != null && aVar.isSuccess) {
                FrsFragment.this.dLB.aDb().hg(com.baidu.tbadk.core.util.aq.Ee().Eg());
                FrsFragment.dLD = 0L;
                FrsFragment.dLE = 0L;
                FrsFragment.mNetError = 0;
            } else {
                FrsFragment.mNetError = 1;
            }
            if (!FrsFragment.this.dLL.aHI() && (i == 3 || i == 6)) {
                FrsFragment.this.dLX.resetData();
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (FrsFragment.this.dLL.aGY() != null) {
                FrsFragment.this.dLd = FrsFragment.this.dLL.aGY();
            }
            FrsFragment.this.dLB.b(FrsFragment.this.dLd.bDB());
            FrsFragment.this.mj(1);
            if (i == 7) {
                FrsFragment.this.mk(FrsFragment.this.dLd.bDg());
                return;
            }
            if (FrsFragment.this.dLd.zf() != null) {
                FrsFragment.this.setHasMore(FrsFragment.this.dLd.zf().zc());
            }
            if (i == 4) {
                if (!FrsFragment.this.dLL.aHI() && TbadkCoreApplication.getInst().isRecAppExist() && FrsFragment.this.dLL.aHy() == 1) {
                    FrsFragment.this.dLd.a(FrsFragment.this);
                }
                ArrayList<com.baidu.adp.widget.ListView.h> a2 = FrsFragment.this.dLX.a(false, false, FrsFragment.this.dLd.getThreadList(), FrsFragment.this.dLx, false);
                if (a2 != null) {
                    FrsFragment.this.dLd.ay(a2);
                    FrsFragment.this.dLd.bDK();
                    FrsFragment.this.dLB.a(a2, FrsFragment.this.dLd);
                }
                if (FrsFragment.this.dLL != null) {
                    com.baidu.tieba.frs.e.c.a(FrsFragment.this.dLd, FrsFragment.this.dLL.aHE(), 2);
                }
                com.baidu.tieba.frs.f.a.a(FrsFragment.this, FrsFragment.this.dLd.bhx(), FrsFragment.this.dLd.getThreadList(), false, FrsFragment.this.getPn());
                FrsFragment.this.bgK = System.currentTimeMillis() - currentTimeMillis;
                FrsFragment.this.aBY();
                return;
            }
            FrsFragment.this.aBY();
            switch (i) {
                case 1:
                    FrsFragment.this.dLB.aCR();
                    break;
                case 2:
                    FrsFragment.this.dLB.aCR();
                    break;
                case 3:
                case 6:
                    if (FrsFragment.this.dLd != null) {
                        FrsFragment.this.dLd.bDI();
                    }
                    if (FrsFragment.this.dMc != null) {
                        FrsFragment.this.dMc.refresh();
                        break;
                    }
                    break;
            }
            FrsFragment.this.aBZ();
            if (aVar == null || aVar.errorCode == 0) {
                if (FrsFragment.this.dLd != null) {
                    FrsFragment.this.A(false, i == 5);
                    if (FrsFragment.this.dLL != null) {
                        com.baidu.tieba.frs.e.a.a(FrsFragment.this.getUniqueId(), FrsFragment.this.dLd.getThreadList(), FrsFragment.this.dLd.bhx(), FrsFragment.this.dLL.acy());
                    }
                    FrsFragment.this.dLB.mu(i);
                    FrsFragment.dLD = (System.nanoTime() - this.startTime) / 1000000;
                    if (aVar != null) {
                        FrsFragment.dLE = aVar.hmi;
                    }
                } else {
                    return;
                }
            } else if (FrsFragment.this.dLd == null || com.baidu.tbadk.core.util.v.I(FrsFragment.this.dLd.getThreadList())) {
                FrsFragment.this.a(aVar);
            } else if (aVar.hmh) {
                FrsFragment.this.showToast(FrsFragment.this.getPageContext().getResources().getString(e.j.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
            }
            if (FrsFragment.this.dLd.bCQ() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11384"));
            }
            if (FrsFragment.this.dse > -1 && !FrsFragment.this.dMj) {
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.dLL, FrsFragment.this.dse);
                FrsFragment.this.dse = -1L;
                FrsFragment.this.dMj = true;
            }
            if (FrsFragment.this.dLy && FrsFragment.this.dLN.nM(49)) {
                FrsFragment.this.dLy = false;
            }
            FrsFragment.this.bgK = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void b(com.baidu.tieba.tbadkCore.i iVar) {
            if ((iVar != null && ("normal_page".equals(FrsFragment.this.dLL.getPageType()) || "frs_page".equals(FrsFragment.this.dLL.getPageType()) || "book_page".equals(FrsFragment.this.dLL.getPageType()))) || "brand_page".equals(FrsFragment.this.dLL.getPageType())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001615, iVar));
                FrsFragment.this.a(iVar);
            }
        }
    };
    private final CustomMessageListener dMJ = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.frs.FrsFragment.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                FrsFragment.this.dLd.a((com.baidu.tbadk.data.l) customResponsedMessage.getData());
                FrsFragment.this.dLB.aDb().notifyDataSetChanged();
            }
        }
    };
    private final CustomMessageListener mMemListener = new CustomMessageListener(2001194) { // from class: com.baidu.tieba.frs.FrsFragment.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && FrsFragment.this.dLd != null && (userData = FrsFragment.this.dLd.getUserData()) != null) {
                userData.setIsMem(num.intValue());
                if (num.intValue() != 0) {
                    FrsFragment.this.dLM.g(num);
                }
            }
        }
    };
    private final com.baidu.tieba.frs.mc.i dMK = new com.baidu.tieba.frs.mc.i() { // from class: com.baidu.tieba.frs.FrsFragment.19
        @Override // com.baidu.tieba.frs.mc.i
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.h> arrayList, boolean z3) {
            if (FrsFragment.this.dLP != null && FrsFragment.this.dLL != null && FrsFragment.this.dLL.aHI() && z && !z2 && !z3) {
                FrsFragment.this.dLP.nr(i2);
            }
        }
    };
    public final View.OnTouchListener bjD = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.FrsFragment.20
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (FrsFragment.this.dMf != null) {
                FrsFragment.this.dMf.onTouch(view, motionEvent);
            }
            if (FrsFragment.this.dLR != null && FrsFragment.this.dLR.aDM() != null) {
                FrsFragment.this.dLR.aDM().onTouchEvent(motionEvent);
            }
            if (FrsFragment.this.bZp != null) {
                FrsFragment.this.bZp.d(view, motionEvent);
            }
            if (FrsFragment.this.dLM != null) {
                FrsFragment.this.dLM.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private final CustomMessageListener dML = new CustomMessageListener(2004507) { // from class: com.baidu.tieba.frs.FrsFragment.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "photolive_hostLevel", -1) != -1 && FrsFragment.this.dLd.bhx() != null) {
                FrsFragment.this.dLd.bhx().setCanAddPhotoLivePost(true);
            }
        }
    };
    public final View.OnClickListener dMM = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.24
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsFragment.this.dLB == null || view != FrsFragment.this.dLB.aCP() || FrsFragment.this.getActivity() == null) {
                if (FrsFragment.this.dLd != null && FrsFragment.this.dLd.bhx() != null && FrsFragment.this.dLB != null && view == FrsFragment.this.dLB.aCV()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12402").aB(ImageViewerConfig.FORUM_ID, FrsFragment.this.dLd.bhx().getId()).aB("uid", TbadkCoreApplication.getCurrentAccount()).aB(ImageViewerConfig.FORUM_NAME, FrsFragment.this.dLd.bhx().getName()));
                    if (!StringUtils.isNull(FrsFragment.this.dLd.bhx().getName())) {
                        FrsFragment.this.sendMessage(new CustomMessage(2002001, new PostSearchActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), FrsFragment.this.dLd.bhx().getName(), FrsFragment.this.dLd.bhx().getId())));
                        return;
                    }
                    return;
                }
                if (view.getId() == e.g.game_activity_egg_layout && com.baidu.adp.lib.util.l.ll()) {
                    TiebaStatic.log("c10853");
                    if (FrsFragment.this.dLB.aCY()) {
                        FrsFragment.this.dLB.aCZ();
                    } else {
                        String activityUrl = FrsFragment.this.dLd.bhx().getYuleData().BL().getActivityUrl();
                        if (!StringUtils.isNull(activityUrl)) {
                            com.baidu.tbadk.browser.a.af(FrsFragment.this.getPageContext().getPageActivity(), activityUrl);
                        }
                    }
                }
                if (view == FrsFragment.this.dLB.aDg() && FrsFragment.this.dLL != null && FrsFragment.this.dLL.hasMore()) {
                    FrsFragment.this.dLB.aby();
                    FrsFragment.this.aaA();
                }
                if (view != null && view == FrsFragment.this.dLB.aCW() && ba.bJ(FrsFragment.this.getContext())) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12924").y("obj_locate", 2));
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
        private int dMT = 0;
        private int bNQ = 0;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (FrsFragment.this.dLV != null) {
                FrsFragment.this.dLV.aIf();
            }
            this.dMT = 0;
            this.bNQ = 0;
            if (recyclerView != null && (recyclerView instanceof BdRecyclerView)) {
                this.dMT = ((BdRecyclerView) recyclerView).getFirstVisiblePosition();
                this.bNQ = ((BdRecyclerView) recyclerView).getLastVisiblePosition();
            }
            if (FrsFragment.this.dMh != null) {
                FrsFragment.this.dMh.a(recyclerView, this.dMT, this.bNQ);
            }
            if (FrsFragment.this.dLd != null && FrsFragment.this.dLB != null && FrsFragment.this.dLB.aDb() != null) {
                FrsFragment.this.dLB.aM(this.dMT, this.bNQ);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (FrsFragment.this.dLM != null) {
                FrsFragment.this.dLM.setScrollState(i);
            }
            if ((i == 2 || i == 1) && !FrsFragment.this.dLI) {
                FrsFragment.this.dLI = true;
                FrsFragment.this.dLB.aDe();
            }
            if (FrsFragment.this.dLJ == null && !FrsFragment.this.aCn()) {
                FrsFragment.this.dLJ = new com.baidu.tbadk.l.b();
                FrsFragment.this.dLJ.gj(1000);
            }
            if (i == 0) {
                if (FrsFragment.this.dLJ != null) {
                    FrsFragment.this.dLJ.Pu();
                }
                com.baidu.tieba.card.v.aqP().fy(true);
                FrsFragment.this.gv(true);
                FrsFragment.this.dLB.aL(this.dMT, this.bNQ);
            } else if (FrsFragment.this.dLJ != null) {
                FrsFragment.this.dLJ.Pt();
            }
            if (FrsFragment.this.dMh != null) {
                FrsFragment.this.dMh.onScrollStateChanged(recyclerView, i);
            }
            if (i == 0) {
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.dLB, FrsFragment.this.dLd, FrsFragment.this.getForumId(), false, null);
            }
            if (FrsFragment.this.dLN != null && i == 1) {
                FrsFragment.this.dLN.aIK();
            }
        }
    };
    private final d dMN = new d() { // from class: com.baidu.tieba.frs.FrsFragment.26
        @Override // com.baidu.tieba.frs.d
        public void a(int i, int i2, View view, View view2, bb bbVar) {
            if (i != FrsFragment.this.dLB.aDb().aFa()) {
                if (i != FrsFragment.this.dLB.aDb().aFb()) {
                    if (i == FrsFragment.this.dLB.aDb().aFc() && FrsFragment.this.dLd != null && FrsFragment.this.dLd.getUserData() != null && FrsFragment.this.dLd.getUserData().isBawu()) {
                        String bDe = FrsFragment.this.dLd.bDe();
                        if (!com.baidu.tbadk.core.util.ao.isEmpty(bDe) && FrsFragment.this.dLd.bhx() != null) {
                            com.baidu.tbadk.browser.a.ad(FrsFragment.this.getPageContext().getPageActivity(), bDe);
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10502").aB(ImageViewerConfig.FORUM_ID, FrsFragment.this.dLd.bhx().getId()).aB("uid", FrsFragment.this.dLd.getUserData().getUserId()));
                        }
                    }
                } else if (ba.bJ(FrsFragment.this.getPageContext().getPageActivity())) {
                    TiebaStatic.log("my_service_ck");
                    if (FrsFragment.this.dLd != null && FrsFragment.this.dLd.bhx() != null) {
                        ForumData bhx = FrsFragment.this.dLd.bhx();
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(bhx.getId(), 0L), bhx.getName(), bhx.getImage_url(), 0)));
                    }
                }
            } else if (ba.bJ(FrsFragment.this.getActivity())) {
                TiebaStatic.log("forum_fortune_click");
                com.baidu.tieba.frs.f.i.b(FrsFragment.this.getPageContext(), FrsFragment.this.dLd);
            }
        }
    };
    private final NoNetworkView.a dJn = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.FrsFragment.27
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bG(boolean z) {
            if (FrsFragment.this.dLL.aHy() == 1 && z && !FrsFragment.this.dLB.aCm()) {
                if (FrsFragment.this.dLd == null || com.baidu.tbadk.core.util.v.I(FrsFragment.this.dLd.getThreadList())) {
                    FrsFragment.this.hideNetRefreshView(FrsFragment.this.dLB.aDc());
                    FrsFragment.this.showLoadingView(FrsFragment.this.dLB.aDc(), true);
                    FrsFragment.this.dLB.gF(false);
                    FrsFragment.this.refresh();
                    return;
                }
                FrsFragment.this.dLB.aCR();
            }
        }
    };
    private final CustomMessageListener aQB = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.FrsFragment.28
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                com.baidu.tieba.frs.f.c.a(customResponsedMessage, FrsFragment.this.dLB, FrsFragment.this.dLd);
            }
        }
    };
    private com.baidu.adp.widget.ListView.n dMO = new a();
    private al dMP = new al() { // from class: com.baidu.tieba.frs.FrsFragment.29
        @Override // com.baidu.tieba.frs.al
        public void a(int i, int i2, ar arVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
            com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.29.1
                @Override // java.lang.Runnable
                public void run() {
                    if (FrsFragment.this.dLB != null && FrsFragment.this.dLB.arM()) {
                        FrsFragment.this.aaA();
                    }
                }
            });
        }
    };
    private CustomMessageListener dMQ = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.frs.FrsFragment.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    FrsFragment.this.dMi = true;
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.frs.loadmore.a
    public /* bridge */ /* synthetic */ com.baidu.adp.base.e getPageContext() {
        return super.getPageContext();
    }

    public com.baidu.tieba.frs.entelechy.b.b aBL() {
        return this.dLT;
    }

    public com.baidu.adp.widget.ListView.n aBM() {
        return this.dMO;
    }

    public com.baidu.tieba.frs.mc.d aBN() {
        return this.dLW;
    }

    public com.baidu.tieba.frs.smartsort.b aBO() {
        return this.dLP;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public FrsModelController aBP() {
        return this.dLL;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public com.baidu.tieba.frs.mc.c aBQ() {
        return this.dLX;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public com.baidu.tieba.frs.vc.f aBR() {
        return this.dLM;
    }

    public com.baidu.tieba.frs.vc.k aBS() {
        return this.dLN;
    }

    public an aBT() {
        return this.dLR;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public k aBU() {
        return this.dLB;
    }

    @Override // com.baidu.tieba.frs.am
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.am, com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.dLt;
    }

    public void setForumName(String str) {
        this.dLt = str;
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
        if (this.dLX == null) {
            return 1;
        }
        return this.dLX.getPn();
    }

    public int getPn() {
        if (this.dLX == null) {
            return 1;
        }
        return this.dLX.getPn();
    }

    public void setPn(int i) {
        if (this.dLX != null) {
            this.dLX.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.dLX != null) {
            this.dLX.setHasMore(i);
        }
    }

    public int aBV() {
        if (this.dLX == null) {
            return -1;
        }
        return this.dLX.aBV();
    }

    public boolean aBW() {
        return this.dLz;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d.a aVar) {
        if (aVar == null) {
            String string = TbadkCoreApplication.getInst().getString(e.j.error_unkown_try_again);
            this.dLB.aCM();
            showNetRefreshView(this.dLB.aDc(), string, true);
        } else if (340001 == aVar.errorCode) {
            a(aVar, this.dLd.bCN());
        } else {
            if (com.baidu.tbadk.core.util.v.I(this.dLd.getThreadList())) {
                b(aVar);
            }
            if (aCn()) {
                setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst(), e.C0210e.ds280));
            } else {
                setNetRefreshViewEmotionDefMarginTop();
            }
        }
    }

    public void a(View view, String str, boolean z, List<RecmForumInfo> list) {
        this.dLB.aCM();
        this.dLB.mq(8);
        if (this.dMg == null) {
            this.dMg = new com.baidu.tieba.frs.view.a(getPageContext(), getNetRefreshListener());
        }
        this.dMg.iC(str);
        this.dMg.bU(list);
        this.dMg.attachView(view, z);
    }

    private void a(d.a aVar, List<RecmForumInfo> list) {
        if (this.dLB != null) {
            this.dLB.aCM();
            this.dLB.setTitle(this.dLt);
            a(this.dLB.aDc(), aVar.errorMsg, true, list);
        }
    }

    private void b(d.a aVar) {
        this.dLB.aCM();
        if (aVar.hmh) {
            showNetRefreshView(this.dLB.aDc(), TbadkCoreApplication.getInst().getString(e.j.net_error_text, new Object[]{aVar.errorMsg, Integer.valueOf(aVar.errorCode)}), true);
        } else {
            showNetRefreshView(this.dLB.aDc(), aVar.errorMsg, true);
        }
    }

    public void aBX() {
        hideLoadingView(this.dLB.aDc());
        if (!this.dLB.aCm()) {
            this.dLB.gG(false);
        } else {
            this.dLB.gG(true);
        }
        if (this.dLB.aCK() instanceof com.baidu.tieba.frs.tab.c) {
            ((com.baidu.tieba.frs.tab.c) this.dLB.aCK()).aIa();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBY() {
        if (aBV() == 0 && com.baidu.tbadk.core.util.v.I(this.dLd.bCW())) {
            if (com.baidu.tbadk.core.util.v.I(this.dLd.getThreadList())) {
                this.dLB.abA();
            } else {
                this.dLB.abz();
            }
        } else if (com.baidu.tbadk.core.util.v.H(this.dLd.getThreadList()) > 3) {
            this.dLB.aby();
        } else {
            this.dLB.aDf();
        }
    }

    public void a(ErrorData errorData) {
        aBX();
        this.dLB.aCR();
        d.a aHv = this.dLL.aHv();
        boolean I = com.baidu.tbadk.core.util.v.I(this.dLd.getThreadList());
        if (aHv != null && I) {
            if (this.dLL.aHw() != 0) {
                this.dLL.aHC();
                this.dLB.aCR();
            } else {
                a(aHv);
            }
            this.dLB.B(this.dLd.bEb(), false);
            return;
        }
        a(aHv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mj(int i) {
        List<WindowToast> list;
        if (TbadkCoreApplication.isLogin() && this.dLd != null && (list = this.dLd.hnM) != null && list.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < list.size()) {
                    WindowToast windowToast = list.get(i3);
                    if (windowToast == null || windowToast.toast_type.intValue() != i) {
                        i2 = i3 + 1;
                    } else if (!com.baidu.tbadk.core.util.ao.isEmpty(windowToast.toast_link)) {
                        sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(getPageContext().getPageActivity(), "", com.baidu.tbadk.util.ac.jh(windowToast.toast_link), true)));
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
    public void aBZ() {
        if (this.dLd == null || this.dLd.bhx() != null) {
            this.dLB.aDa();
        } else if (this.dLd.bhx().getYuleData() != null && this.dLd.bhx().getYuleData().BK()) {
            TiebaStatic.log("c10852");
            this.dLB.a(this.dLd.bhx().getYuleData().BL());
        } else {
            this.dLB.aDa();
        }
    }

    private void z(boolean z, boolean z2) {
        if (this.dLL != null && this.dLd != null && this.dLB != null && z) {
            if (!this.dLL.aHI() && this.dLL.aHy() == 1) {
                if (!this.dLL.aHG()) {
                    this.dLd.bDQ();
                    this.dLd.bDR();
                }
                boolean z3 = false;
                if (this.dLB.aDb().k(com.baidu.tieba.card.data.n.dbV)) {
                    z3 = this.dLd.bDV();
                }
                if (!z3) {
                    this.dLd.bDT();
                }
                if (TbadkCoreApplication.getInst().isRecAppExist()) {
                    this.dLd.a(this);
                }
                if (!this.dLB.aDb().k(bb.atN)) {
                    this.dLd.bDJ();
                }
                this.dLd.bDW();
            }
            if (!this.dLB.aDb().k(bb.atN)) {
                this.dLd.bDP();
                this.dLd.bDN();
            } else {
                this.dLd.bDO();
                this.dLd.bDM();
            }
            this.dLd.bDK();
            this.dLd.bDH();
            if (this.dLB.aDb().k(com.baidu.tieba.h.b.eoj)) {
                this.dLd.nu(z2);
            }
            if (TbadkCoreApplication.isLogin() && (!this.dLL.aHI() || this.dLL.isNetFirstLoad)) {
                this.dLd.bDX();
            }
            this.dLd.bDZ();
        }
    }

    public boolean aCa() {
        if (this.dLM != null && this.dLL != null) {
            this.dLM.a(this.dLL.getPageType(), this.dLd);
        }
        boolean z = false;
        if (this.dLd != null) {
            z = this.dLd.bEc();
        }
        aCc();
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mk(int i) {
        ao aoVar = null;
        aCa();
        aCj();
        try {
            if (this.dLd != null) {
                this.dLB.a((ArrayList<com.baidu.adp.widget.ListView.h>) null, this.dLd);
                this.dLM.nH(1);
                this.dLB.aCU();
                this.dLN.a(this.dLd, this.dLL.aHE());
                com.baidu.tieba.frs.tab.d nN = this.dLN.nN(this.dLd.bDg());
                if (nN != null && !TextUtils.isEmpty(nN.url)) {
                    aoVar = new ao();
                    aoVar.dPn = nN.url;
                    aoVar.stType = nN.name;
                }
                this.dLL.a(this.dLd.bDg(), 0, aoVar);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(boolean z, boolean z2) {
        try {
            if (this.dLd != null && this.dLN != null && this.dLL != null) {
                if (!this.dLB.aDb().k(bb.atN)) {
                    this.dLd.bDJ();
                }
                boolean I = com.baidu.tbadk.core.util.v.I(this.dLd.bDu());
                this.dLB.gD(I);
                if (!I) {
                    if (this.dMh == null) {
                        this.dMh = new com.baidu.tieba.frs.vc.e(this, (NoPressedRelativeLayout) this.mRootView);
                    }
                    if (this.bZp == null) {
                        this.bZp = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
                    }
                } else {
                    this.dMh = null;
                    this.bZp = null;
                }
                if (this.dLd.bhx() != null) {
                    this.dLt = this.dLd.bhx().getName();
                    this.forumId = this.dLd.bhx().getId();
                }
                if (this.dLd.bEc()) {
                    this.dLN.a(this.dLd, this.dLL.aHE());
                }
                if (z) {
                    z(true, z);
                } else {
                    z(this.dLK, z);
                }
                aCa();
                if (this.dLT != null) {
                    this.dLT.a(this.dLM, this.dLd);
                }
                if (this.dLd.zf() != null) {
                    setHasMore(this.dLd.zf().zc());
                }
                ArrayList<com.baidu.adp.widget.ListView.h> a2 = this.dLX.a(z2, true, this.dLd.getThreadList(), null, z, false);
                if (a2 != null) {
                    this.dLd.ay(a2);
                }
                this.dLd.bDY();
                if (this.dLL.aHy() == 1) {
                    aCg();
                    if (!z && this.dLL.getPn() == 1) {
                        aCb();
                    }
                }
                this.dLg = this.dLd.aHA();
                if (this.dLx != null) {
                    this.dLw = true;
                    this.dLx.vH(this.dLg);
                    com.baidu.tieba.frs.f.a.a(this, this.dLd.bhx(), this.dLd.getThreadList(), this.dLw, getPn());
                }
                if (this.dLV != null) {
                    this.dLV.aV(this.dLN.aIH());
                }
                aBX();
                this.dLB.aCN();
                this.dLB.B(true, false);
                if (this.dLd.bhx() != null) {
                    this.dLB.ov(this.dLd.bhx().getWarningMsg());
                }
                if (this.dLd != null && this.dLd.bDx() != null && com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("frs_video_activity_guide", 0L) == 0) {
                    com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.13
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsFragment.this.dLB.aDk();
                        }
                    }, 1000L);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2921326, this));
                this.dLB.aCG();
                if (this.dLd != null && this.dLd.bhx() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016564, new VisitedForumData(this.dLd.bhx().getId(), this.dLd.bhx().getName(), this.dLd.bhx().getImage_url(), String.valueOf(System.currentTimeMillis() / 1000), "showlive".equals(this.dLd.bhx().special_forum_type))));
                }
                this.dMn.a(this.dLd.hnR, this.dLd.bhx());
                aCt();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void gv(boolean z) {
        com.baidu.tieba.q.c.bCC().b(getUniqueId(), z);
    }

    public void aCb() {
        if (this.dMa == null) {
            this.dMa = new com.baidu.tieba.frs.live.a(this, com.baidu.adp.lib.g.b.l(this.forumId, 0));
        }
        this.dMa.aHg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.i iVar) {
        try {
            if (!this.dLH && iVar != null && this.dLd != null) {
                this.dLd.g(iVar);
                A(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void aCc() {
        if (this.dLL != null) {
            ot(this.dLL.getPageType());
        } else {
            ot("normal_page");
        }
    }

    private void ot(String str) {
        gw("frs_page".equals(str));
        if (this.dLT != null) {
            this.dLT.a(this.dLM, this.dLB, this.dLd);
        }
    }

    public void gw(boolean z) {
        if (this.dLY != null) {
            this.dLY.c(this.dLB, z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.q.c.bCC().r(getUniqueId());
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(e.h.frs_activity, viewGroup, false);
            this.dLn = new com.baidu.tieba.frs.entelechy.b();
            this.dLT = this.dLn.aEz();
            this.dLM = new com.baidu.tieba.frs.vc.f(this, this.dLn, (FrsHeaderViewContainer) this.mRootView.findViewById(e.g.header_view_container));
            this.dLN = new FrsTabViewController(this, this.mRootView);
            this.dLN.registerListener();
            this.dLM.a(this.dLN);
            this.dLN.a(this.dMx);
            Intent intent = getActivity().getIntent();
            if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                this.dLp = true;
            }
            this.dLB = new k(this, this.dMM, this.dLn, this.dLp, this.dLM);
            this.dLB.setHeaderViewHeight(this.dMe);
            this.dMn = new com.baidu.tieba.frs.brand.buttommenu.a(getPageContext(), this.mRootView);
        } else {
            if (this.mRootView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            if (this.dLN != null) {
                this.dLN.registerListener();
            }
            this.dLB.aDj();
        }
        this.dMq = true;
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        this.dse = System.currentTimeMillis();
        this.beginTime = this.dse;
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.dLy = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.dse = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            M(intent);
        }
        this.bgC = this.beginTime - this.dse;
        this.dLx = new com.baidu.tieba.tbadkCore.data.e("frs", com.baidu.tieba.tbadkCore.data.e.hpc);
        if (this.dLL == null) {
            this.dLL = new FrsModelController(this, this.dMI);
            this.dLL.a(this.dMw);
            this.dLL.init();
        }
        if (intent != null) {
            this.dLL.p(intent.getExtras());
        } else if (bundle != null) {
            this.dLL.p(bundle);
        } else {
            this.dLL.p(null);
        }
        if (intent != null) {
            this.dLM.t(intent.getExtras());
        } else if (bundle != null) {
            this.dLM.t(bundle);
        } else {
            this.dLM.t(null);
        }
        this.dLA = getVoiceManager();
        this.dMb = new j(getPageContext(), this);
        initUI();
        initData(bundle);
        if (!aCn()) {
            this.dLR = new an(getActivity(), this.dLB, this.dLM);
            this.dLR.gU(true);
        }
        this.dLA = getVoiceManager();
        if (this.dLA != null) {
            this.dLA.onCreate(getPageContext());
        }
        new com.baidu.tieba.frs.mc.g();
        this.dLX = new com.baidu.tieba.frs.mc.c(this, this.dMK);
        this.dLP = new com.baidu.tieba.frs.smartsort.b(this);
        this.dLY = new com.baidu.tieba.frs.vc.h(this);
        this.dLV = new com.baidu.tieba.frs.vc.a(getPageContext(), this.dLL.aHF());
        this.dLQ = new com.baidu.tieba.frs.mc.b(this);
        this.dLW = new com.baidu.tieba.frs.mc.d(this);
        this.dLO = new com.baidu.tieba.frs.mc.f(this);
        this.dLZ = new com.baidu.tieba.frs.mc.a(this);
        this.dMc = new com.baidu.tieba.frs.vc.c(this);
        this.dMd = new com.baidu.tieba.frs.mc.e(this, getUniqueId());
        this.dMk = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "frs");
        this.dMl = new com.baidu.tieba.ala.a(getPageContext());
        registerListener(this.bVZ);
        registerListener(this.mMemListener);
        registerListener(this.dMD);
        registerListener(this.dML);
        registerListener(this.dMC);
        registerListener(this.dMJ);
        registerListener(this.dMz);
        registerListener(this.dMA);
        registerListener(this.dMB);
        registerListener(this.dMt);
        registerListener(this.dMu);
        registerListener(this.dMQ);
        registerListener(this.dMG);
        registerListener(this.dMv);
        registerListener(this.dMH);
        registerListener(this.dMF);
        this.dMs.setTag(getPageContext().getUniqueId());
        registerListener(this.dMs);
        registerListener(this.akJ);
        this.dLB.gF(false);
        if (!aCn() && !this.hasInit) {
            showLoadingView(this.dLB.aDc(), true);
            this.dLL.r(3, false);
        }
        com.baidu.tieba.frs.a.aBg().a(new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.16
            @Override // com.baidu.tieba.frs.a.b
            public void y(boolean z, boolean z2) {
                if (FrsFragment.this.dLB != null) {
                    FrsFragment.this.dLB.mr(z ? 0 : 8);
                    if (!z2) {
                        FrsFragment.this.dMp = z;
                    }
                    if (FrsFragment.this.dLB.aDb() != null && FrsFragment.this.dLL != null && FrsFragment.this.dLL.aHz()) {
                        FrsFragment.this.dLB.aDb().notifyDataSetChanged();
                    }
                    if (FrsFragment.this.dLB.aCL() != null) {
                        FrsFragment.this.dLB.gC(!z);
                    }
                    if (FrsFragment.this.getActivity() instanceof FrsActivity) {
                        ((FrsActivity) FrsFragment.this.getActivity()).gu(!z);
                    }
                    if (FrsFragment.this.dMn != null) {
                        FrsFragment.this.dMn.hd(!z);
                    }
                    FrsFragment.this.dLB.gH(!z);
                    FrsFragment.this.dLB.gI(z ? false : true);
                }
            }

            @Override // com.baidu.tieba.frs.a.b
            public void mg(int i) {
                if (FrsFragment.this.dLB != null) {
                    FrsFragment.this.dLB.ms(i);
                }
            }

            @Override // com.baidu.tieba.frs.a.b
            public void aBm() {
                com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getContext(), e.j.frs_multi_delete_max_num);
            }
        });
        this.dLB.b(new d.a() { // from class: com.baidu.tieba.frs.FrsFragment.17
            @Override // com.baidu.tieba.NEGFeedBack.d.a
            public void a(DeleteThreadHttpResponseMessage deleteThreadHttpResponseMessage) {
                int i;
                int i2 = 0;
                if (deleteThreadHttpResponseMessage != null) {
                    FrsFragment.this.dLB.UX();
                    FrsFragment.this.dLB.aDl();
                    if (deleteThreadHttpResponseMessage.getError() == 0) {
                        String text = !TextUtils.isEmpty(deleteThreadHttpResponseMessage.getText()) ? deleteThreadHttpResponseMessage.getText() : FrsFragment.this.getString(e.j.delete_fail);
                        if (deleteThreadHttpResponseMessage.getRetType() == 1211066) {
                            if (FrsFragment.this.daF == null) {
                                FrsFragment.this.daF = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.daF.eK(text);
                            FrsFragment.this.daF.a(e.j.dialog_known, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.17.1
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.daF.bh(false);
                            FrsFragment.this.daF.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.daF.BS();
                        } else if (deleteThreadHttpResponseMessage.getRetType() == 1211067) {
                            if (FrsFragment.this.daF == null) {
                                FrsFragment.this.daF = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.daF.eK(text);
                            FrsFragment.this.daF.a(e.j.know, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.17.2
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.daF.bh(false);
                            FrsFragment.this.daF.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.daF.BS();
                        } else {
                            FrsFragment.this.dLB.ad(deleteThreadHttpResponseMessage.getText(), ContextCompat.getColor(FrsFragment.this.getContext(), deleteThreadHttpResponseMessage.getRetType() == 1 ? e.d.nav_bar_tip_error : e.d.cp_link_tip_a_alpha95));
                        }
                        FrsFragment.this.bE(deleteThreadHttpResponseMessage.getSuccessItems());
                        com.baidu.tieba.frs.a.aBg().bD(deleteThreadHttpResponseMessage.getSuccessItems());
                        Iterator<com.baidu.adp.widget.ListView.h> it = FrsFragment.this.dLd.getThreadList().iterator();
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
                            FrsFragment.this.aaA();
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

    public void gx(boolean z) {
        if (this.dLN != null) {
            this.dLN.ehw = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bE(List<String> list) {
        if (!com.baidu.tbadk.core.util.v.I(list)) {
            ArrayList<com.baidu.adp.widget.ListView.h> threadList = this.dLd.getThreadList();
            if (!com.baidu.tbadk.core.util.v.I(threadList) && this.dLB.getListView() != null && this.dLB.getListView().getData() != null) {
                Iterator<com.baidu.adp.widget.ListView.h> it = threadList.iterator();
                List<com.baidu.adp.widget.ListView.h> data = this.dLB.getListView().getData();
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
                                this.dLX.ab(bbVar);
                                this.dLB.getListView().getAdapter().notifyItemRemoved(i);
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
    public void aba() {
        if (isAdded() && this.bSI && !isLoadingViewAttached()) {
            showLoadingView(this.dLB.aDc(), true);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void abb() {
        if (isAdded() && this.bSI && isLoadingViewAttached()) {
            hideLoadingView(this.dLB.aDc());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (aCn()) {
            showLoadingView(this.dLB.aDc(), true);
            this.dLB.mt(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.dLL.r(3, true);
            FI().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void setHeaderViewHeight(int i) {
        this.dMe = i;
        if (this.dLB != null) {
            this.dLB.setHeaderViewHeight(this.dMe);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.v vVar) {
        if (vVar != null) {
            this.bjC = vVar.QA();
            this.dMf = vVar.QB();
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void showFloatingView() {
        if (this.bjC != null) {
            this.bjC.cV(true);
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
                this.dLt = data.getQueryParameter("name");
                this.mFrom = data.getQueryParameter("from");
                if (!StringUtils.isNull(this.dLt)) {
                    intent.putExtra("name", this.dLt);
                }
                if (!StringUtils.isNull(this.mFrom)) {
                    intent.putExtra("from", this.mFrom);
                }
                TiebaStatic.log("c10105");
            }
            if (StringUtils.isNull(this.dLt) && intent != null && intent.getData() != null) {
                Uri data2 = intent.getData();
                if (com.baidu.tbadk.BdToken.f.e(data2)) {
                    com.baidu.tbadk.BdToken.f.vJ().b(data2, new f.a() { // from class: com.baidu.tieba.frs.FrsFragment.18
                        @Override // com.baidu.tbadk.BdToken.f.a
                        public void n(HashMap<String, Object> hashMap) {
                            if (hashMap != null && (hashMap.get(com.baidu.tbadk.BdToken.f.alc) instanceof String)) {
                                FrsFragment.this.dLt = (String) hashMap.get(com.baidu.tbadk.BdToken.f.alc);
                            }
                        }
                    });
                } else {
                    com.baidu.tieba.frs.f.d O = com.baidu.tieba.frs.f.i.O(intent);
                    if (O != null) {
                        this.dLt = O.forumName;
                        if (O.efO != null && O.efO.equals("aidou")) {
                            com.baidu.tbadk.core.dialog.h.axL = System.currentTimeMillis();
                        }
                    }
                }
                if (!StringUtils.isNull(this.dLt)) {
                    intent.putExtra("name", this.dLt);
                }
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.dLA = getVoiceManager();
        if (this.dLA != null) {
            this.dLA.onStart(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        Intent intent;
        registerListener(2001118, this.aQB);
        if (bundle != null) {
            this.dLt = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
            this.dLt = intent.getStringExtra("name");
            this.mFrom = intent.getStringExtra("from");
            this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
        }
        if (getArguments() != null) {
            this.dLu = getArguments().getBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, false);
        }
        if (TextUtils.isEmpty(this.mFrom) || FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
        }
        if (this.mIsLogin) {
            registerListener(2001120, this.aQB);
        }
        this.dLM.t(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.q.c.bCC().s(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.dMQ);
        if (this.dLA != null) {
            this.dLA.onDestory(getPageContext());
        }
        com.baidu.tieba.recapp.report.a.remove("FRS");
        this.dLA = null;
        com.baidu.tieba.card.v.aqP().fy(false);
        if (this.dLd != null && this.dLd.bhx() != null) {
            ac.aDJ().ca(com.baidu.adp.lib.g.b.d(this.dLd.bhx().getId(), 0L));
        }
        if (this.dMa != null) {
            this.dMa.onDestory();
        }
        if (this.dLB != null) {
            com.baidu.tieba.frs.f.h.a(this.dLB, this.dLd, getForumId(), false, null);
            this.dLB.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.dLJ != null) {
                this.dLJ.Pv();
            }
            this.dLB.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.dLM.onActivityDestroy();
        if (this.dLL != null) {
            this.dLL.acK();
        }
        if (this.dLR != null) {
            this.dLR.Qz();
        }
        if (this.dLU != null) {
            this.dLU.destory();
        }
        if (this.dLV != null) {
            this.dLV.destory();
        }
        if (this.dLP != null) {
            this.dLP.onDestroy();
        }
        if (this.dMh != null) {
            this.dMh.onDestory();
        }
        if (this.dLZ != null) {
            this.dLZ.onDestroy();
        }
        if (this.dMk != null) {
            this.dMk.onDestroy();
        }
        if (this.dMl != null) {
            this.dMl.onDestroy();
        }
        com.baidu.tieba.recapp.d.a.bwJ().bwL();
        com.baidu.tieba.frs.f.j.aIc();
        if (this.dLN != null) {
            this.dLN.a((FrsTabViewController.a) null);
            this.dLN.aIK();
        }
        if (this.dMm != null) {
            this.dMm.onDestroy();
        }
        if (this.dMo != null) {
            this.dMo.onDestroy();
        }
        com.baidu.tieba.frs.a.aBg().a(null);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.dLt);
        bundle.putString("from", this.mFrom);
        this.dLL.onSaveInstanceState(bundle);
        if (this.dLA != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            this.dLA.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.dLZ != null) {
            this.dLZ.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dLB != null) {
            this.dLB.aCR();
            this.dLB.onResume();
        }
        this.dLO.hs(true);
        this.dLK = true;
        if (dLs) {
            dLs = false;
            this.dLB.startPullRefresh();
            return;
        }
        if (this.dLA != null) {
            this.dLA.onResume(getPageContext());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921338));
        this.dLB.gJ(false);
        if (this.dMi) {
            refresh(6);
            this.dMi = false;
        }
        aCt();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
    }

    public boolean aCd() {
        Intent intent;
        if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
            return false;
        }
        return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
    }

    public void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.dLt = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.dLv = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.dLv) {
                aCe();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCe() {
        this.dLB.startPullRefresh();
    }

    public void closeActivity() {
        com.baidu.tieba.frs.f.i.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.mFrom);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.dLB.setTitle(this.dLt);
        } else {
            this.dLB.setTitle("");
            this.mFlag = 1;
        }
        this.dLB.setOnAdapterItemClickListener(this.dMO);
        this.dLB.addOnScrollListener(this.mScrollListener);
        this.dLB.h(this.dJn);
        this.dLB.aDb().a(this.dMN);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dMq) {
            this.dLB.onChangeSkinType(i);
            this.dLM.nG(i);
            this.dLN.onChangeSkinType(i);
            if (this.dMg != null) {
                this.dMg.onChangeSkinType();
            }
            if (this.dMm != null) {
                this.dMm.onChangeSkinType(i);
            }
            if (this.dMn != null) {
                this.dMn.d(getPageContext(), i);
            }
            if (this.daF != null) {
                com.baidu.tbadk.o.a.a(getPageContext(), this.daF.BT());
            }
        }
    }

    public void ml(int i) {
        if (!this.mIsLogin) {
            if (this.dLd != null && this.dLd.yR() != null) {
                this.dLd.yR().setIfpost(1);
            }
            if (i == 0) {
                ba.bI(getActivity());
            }
        } else if (this.dLd != null) {
            if (i == 0) {
                com.baidu.tieba.frs.f.j.d(this, 0);
            } else {
                this.dLB.aCT();
            }
        }
    }

    public void refresh() {
        com.baidu.tieba.a.d.Wk().ka("page_frs");
        refresh(3);
    }

    public void refresh(int i) {
        this.dLH = false;
        aCj();
        if (this.dLB.aCJ() != null) {
            this.dLB.aCJ().aNK();
        }
        this.dLL.r(i, true);
    }

    private void aCf() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.g.h.jH().d(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.22
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.we(FrsFragment.this.dLt);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCg() {
        aCj();
        try {
            if (this.dLd != null) {
                this.dLB.anM();
                this.dLB.gC(aCs());
                if (!com.baidu.tieba.frs.vc.f.l(this.dLd) || !com.baidu.tieba.frs.vc.f.k(this.dLd)) {
                }
                if (this.dLd.bhx() != null) {
                    this.dLt = this.dLd.bhx().getName();
                    this.forumId = this.dLd.bhx().getId();
                }
                if (this.dLd.zf() != null) {
                    setHasMore(this.dLd.zf().zc());
                }
                this.dLB.setTitle(this.dLt);
                this.dLB.setForumName(this.dLt);
                TbadkCoreApplication.getInst().setDefaultBubble(this.dLd.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.dLd.getUserData().getBimg_end_time());
                aCf();
                aCh();
                ArrayList<com.baidu.adp.widget.ListView.h> threadList = this.dLd.getThreadList();
                if (threadList != null) {
                    this.dLB.a(threadList, this.dLd);
                    com.baidu.tieba.frs.f.c.w(this.dLB);
                    this.dLM.nH(getPageNum());
                    this.dLM.i(this.dLd);
                    this.dLN.a(this.dLd, this.dLL.aHE());
                    this.dLB.aCU();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void aCh() {
        if (this.dLd != null) {
            if (this.dLd.bhM() == 1) {
                this.dLB.aDb().setFromCDN(true);
            } else {
                this.dLB.aDb().setFromCDN(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.dLO.hs(false);
        this.dLK = false;
        this.dLB.onPause();
        if (this.dLA != null) {
            this.dLA.onPause(getPageContext());
        }
        this.dLB.gJ(true);
        if (this.dLV != null) {
            this.dLV.aIf();
        }
        com.baidu.tbadk.BdToken.c.vy().vz();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.dLN != null && this.dLN.aII() != null && (this.dLN.aII().fragment instanceof BaseFragment)) {
            ((BaseFragment) this.dLN.aII().fragment).setPrimary(z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.v.aqP().fy(false);
        gv(false);
        if (this.dLd != null && this.dLd.bhx() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            com.baidu.tbadk.distribute.a.Mc().a(getPageContext().getPageActivity(), "frs", this.dLd.bhx().getId(), 0L);
        }
        if (this.dLA != null) {
            this.dLA.onStop(getPageContext());
        }
        if (FI() != null) {
            FI().getRecycledViewPool().clear();
        }
        this.dLM.onActivityStop();
        com.baidu.tbadk.util.w.QD();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            if (this.dLM != null) {
                this.dLM.gA(isPrimary());
            }
            if (this.dLB != null) {
                this.dLB.gA(isPrimary());
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (com.baidu.tieba.frs.a.aBg().aBh()) {
                com.baidu.tieba.frs.a.aBg().reset();
                return true;
            } else if (this.dLB != null) {
                return this.dLB.aCQ();
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
        com.baidu.tbadk.distribute.a.Mc().a(advertAppInfo, this.forumId, 0L, "FRS", str, getPn());
    }

    @Override // com.baidu.tieba.recapp.n
    public void aCi() {
        aBP().aCi();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dLA == null) {
            this.dLA = VoiceManager.instance();
        }
        return this.dLA;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdRecyclerView FI() {
        if (this.dLB == null) {
            return null;
        }
        return this.dLB.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void aCj() {
        if (this.dLA != null) {
            this.dLA.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> FJ() {
        if (this.aLs == null) {
            this.aLs = UserIconBox.l(getPageContext().getPageActivity(), 8);
        }
        return this.aLs;
    }

    public void aCk() {
        if (getFragmentActivity() != null && getFragmentActivity().getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.b(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.k onGetPreLoadListView() {
        return FI().getPreLoadHandle();
    }

    @Override // com.baidu.tieba.frs.ak
    public NavigationBar act() {
        if (this.dLB == null) {
            return null;
        }
        return this.dLB.act();
    }

    @Override // com.baidu.tbadk.core.view.NavigationBar.a
    public void b(Pair<Integer, Integer> pair) {
        this.dLF = pair;
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
                if (bdUniqueId == p.dOj) {
                    if (FrsFragment.this.dLB != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11752").aB(ImageViewerConfig.FORUM_ID, FrsFragment.this.forumId).aB("obj_locate", "1"));
                        FrsFragment.this.dLB.startPullRefresh();
                    }
                } else if (hVar != null && (hVar instanceof bb)) {
                    bb bbVar = (bb) hVar;
                    if (bbVar.AF() == null || bbVar.AF().getGroup_id() == 0 || ba.bJ(FrsFragment.this.getActivity())) {
                        if (bbVar.Ax() != 1 || ba.bJ(FrsFragment.this.getActivity())) {
                            if (bbVar.Ah() != null) {
                                if (ba.bJ(FrsFragment.this.getActivity())) {
                                    String postUrl = bbVar.Ah().getPostUrl();
                                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.ll()) {
                                        com.baidu.tbadk.browser.a.af(FrsFragment.this.getActivity(), postUrl);
                                    }
                                }
                            } else if (bbVar.AO() != null) {
                                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                    ba.bI(FrsFragment.this.getPageContext().getPageActivity());
                                    return;
                                }
                                com.baidu.tbadk.core.data.m AO = bbVar.AO();
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), AO.getCartoonId(), AO.getChapterId(), 2)));
                            } else {
                                com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                                if (readThreadHistory != null && !readThreadHistory.wk(bbVar.getId())) {
                                    readThreadHistory.wj(bbVar.getId());
                                }
                                boolean z = false;
                                final String Ab = bbVar.Ab();
                                if (Ab != null && !Ab.equals("")) {
                                    z = true;
                                    new Thread(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.a.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(Ab);
                                            xVar.Dw().Eu().mIsNeedAddCommenParam = false;
                                            xVar.Dw().Eu().mIsUseCurrentBDUSS = false;
                                            xVar.CZ();
                                        }
                                    }).start();
                                }
                                String tid = bbVar.getTid();
                                if (tid == null) {
                                    tid = "";
                                }
                                if (bbVar.zO() == 2 && !tid.startsWith("pb:")) {
                                    ay.Es().c(FrsFragment.this.getPageContext(), new String[]{tid, "", null});
                                    return;
                                }
                                if (tid.startsWith("pb:")) {
                                    bbVar.setId(tid.substring(3));
                                }
                                if (bdUniqueId.getId() == bb.avg.getId()) {
                                    com.baidu.tieba.frs.f.h.a(bbVar.zA());
                                } else if (bdUniqueId.getId() == bb.atQ.getId()) {
                                    com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c12940");
                                    amVar.aB("obj_type", "2");
                                    amVar.aB("tid", bbVar.getTid());
                                    TiebaStatic.log(amVar);
                                }
                                com.baidu.tieba.frs.f.i.a(FrsFragment.this, bbVar, i, z);
                                com.baidu.tieba.frs.f.h.a(FrsFragment.this, FrsFragment.this.dLd, bbVar);
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
            hideNetRefreshView(this.dLB.aDc());
            showLoadingView(this.dLB.aDc(), true);
            this.dLB.gF(false);
            this.dLL.r(3, true);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public com.baidu.tieba.tbadkCore.l aCl() {
        return this.dLd;
    }

    public boolean aCm() {
        return this.dLB.aCm();
    }

    public void ac(Object obj) {
        if (this.dLQ != null && this.dLQ.edk != null) {
            this.dLQ.edk.m(obj);
        }
    }

    public void ad(Object obj) {
        if (this.dLQ != null && this.dLQ.edl != null) {
            this.dLQ.edl.m(obj);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        this.dLB.getListView().stopScroll();
        if (!this.dLB.aCX()) {
            if (!com.baidu.adp.lib.util.l.ll()) {
                this.dLB.abA();
            } else if (this.dLL.aHy() == 1) {
                aaO();
                aaA();
            } else if (this.dLL.hasMore()) {
                aaA();
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void oa(String str) {
        aaO();
        showToast(str);
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void O(ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        boolean I = com.baidu.tbadk.core.util.v.I(arrayList);
        setHasMore(I ? 0 : 1);
        aaO();
        if (!I) {
            if (!this.dLL.aHI() && TbadkCoreApplication.getInst().isRecAppExist() && this.dLL.aHy() == 1) {
                this.dLd.a(this, arrayList);
            }
            if (this.dLL != null) {
                com.baidu.tieba.frs.e.a.a(getUniqueId(), arrayList, this.dLd.bhx(), this.dLL.acy());
            }
            ArrayList<com.baidu.adp.widget.ListView.h> a2 = this.dLX.a(false, false, arrayList, this.dLx, false);
            if (a2 != null) {
                this.dLd.ay(a2);
                this.dLB.a(a2, this.dLd);
            }
            if (this.dLL != null) {
                com.baidu.tieba.frs.e.c.a(this.dLd, this.dLL.aHE(), 2);
            }
        }
    }

    private void aaO() {
        if (aBV() == 1 || this.dLX.bQ(this.dLd.bCW())) {
            if (com.baidu.tbadk.core.util.v.H(this.dLd.getThreadList()) > 3) {
                this.dLB.aby();
            } else {
                this.dLB.aDf();
            }
        } else if (com.baidu.tbadk.core.util.v.I(this.dLd.getThreadList())) {
            this.dLB.abA();
        } else {
            this.dLB.abz();
        }
    }

    @Override // com.baidu.tieba.frs.mc.j
    public void aaA() {
        if (this.dLX != null) {
            this.dLX.a(this.dLt, this.forumId, this.dLd);
        }
    }

    public void takePhoto() {
        if (!com.baidu.tbadk.core.util.ab.e(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.ak.b(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        if (this.dLG) {
            return null;
        }
        if (aCn()) {
            return "a034";
        }
        return "a006";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (!aCn()) {
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

    public void gy(boolean z) {
        if (this.dLR != null) {
            this.dLR.gU(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.dLS.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a ht(int i) {
        return this.dLS.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        this.dMb.b(bVar);
    }

    public boolean aCn() {
        return this.dLp;
    }

    @Override // com.baidu.tieba.frs.ah
    public void aaZ() {
        if (this.dLB != null) {
            showFloatingView();
            this.dLB.getListView().scrollToPosition(0);
            this.dLB.startPullRefresh();
        }
    }

    public ForumWriteData aCo() {
        if (this.dLd == null || this.dLd.bhx() == null) {
            return null;
        }
        ForumData bhx = this.dLd.bhx();
        ForumWriteData forumWriteData = new ForumWriteData(bhx.getId(), bhx.getName(), bhx.getPrefixData(), this.dLd.yR());
        forumWriteData.avatar = bhx.getImage_url();
        forumWriteData.forumLevel = bhx.getUser_level();
        forumWriteData.specialForumType = bhx.special_forum_type;
        forumWriteData.firstDir = bhx.getFirst_class();
        forumWriteData.secondDir = bhx.getSecond_class();
        UserData userData = this.dLd.getUserData();
        forumWriteData.privateThread = userData != null ? userData.getPrivateThread() : 0;
        return forumWriteData;
    }

    @Override // com.baidu.tieba.frs.ah
    public void Fw() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.frs.ah
    public void setVideoThreadId(String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z) {
        super.showLoadingView(view, z);
        this.dLB.mq(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        super.hideLoadingView(view);
        this.dLB.mq(0);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        super.showNetRefreshView(view, str, z);
        this.dLB.mq(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshViewNoClick(View view, String str, boolean z) {
        super.showNetRefreshViewNoClick(view, str, z);
        this.dLB.mq(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        super.hideNetRefreshView(view);
        this.dLB.mq(0);
    }

    public void aCp() {
        FrsTabViewController.b aII;
        if (this.dLN != null && (aII = this.dLN.aII()) != null && aII.fragment != null && (aII.fragment instanceof aj)) {
            ((aj) aII.fragment).aBE();
        }
    }

    public void a(ContriInfo contriInfo) {
        if (this.dMm == null) {
            this.dMm = new com.baidu.tbadk.core.dialog.h(getTbPageContext());
            this.dMm.a(new h.a() { // from class: com.baidu.tieba.frs.FrsFragment.31
                @Override // com.baidu.tbadk.core.dialog.h.a
                public void bo(boolean z) {
                    if (z) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13061"));
                    }
                }
            });
        }
        this.dMm.a(contriInfo, -1L);
    }

    public void gz(boolean z) {
        this.dLr = z;
    }

    public boolean aCq() {
        return this.dLr;
    }

    public void ou(String str) {
        if (TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.util.ao.isEmpty(str)) {
            if (this.dMo == null) {
                this.dMo = new AddExperiencedModel(getTbPageContext());
                this.dMo.a(this.dMr);
            }
            this.dMo.cF(this.forumId, str);
        }
    }

    public com.baidu.tieba.frs.entelechy.b aCr() {
        return this.dLn;
    }

    public boolean aCs() {
        return (this.dLL != null && this.dLL.aHz() && com.baidu.tieba.frs.a.aBg().aBh()) ? false : true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.e.c
    public boolean videoNeedPreload() {
        if (this.dLd != null) {
            return com.baidu.tbadk.util.ab.QK() && (this.dLd.hnT || com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("auto_play_video_frs", 0) == 1);
        }
        return super.videoNeedPreload();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCt() {
        if (!com.baidu.tbadk.core.util.ao.isEmpty(this.forumId)) {
            com.baidu.tbadk.BdToken.c.vy().g(com.baidu.tbadk.BdToken.b.ajY, com.baidu.adp.lib.g.b.d(this.forumId, 0L));
        }
    }
}
