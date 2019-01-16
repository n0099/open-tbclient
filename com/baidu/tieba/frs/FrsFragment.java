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
    private com.baidu.adp.lib.e.b<TbImageView> aLr;
    private com.baidu.tieba.frs.gametab.b bZo;
    private com.baidu.tbadk.util.u bjB;
    private FrsModelController dLK;
    private com.baidu.tieba.frs.vc.f dLL;
    private FrsTabViewController dLM;
    private com.baidu.tieba.frs.mc.f dLN;
    private com.baidu.tieba.frs.smartsort.b dLO;
    private com.baidu.tieba.frs.mc.b dLP;
    private an dLQ;
    private com.baidu.tieba.frs.entelechy.b.b dLS;
    private com.baidu.tbadk.i.a dLT;
    private com.baidu.tieba.frs.vc.a dLU;
    private com.baidu.tieba.frs.mc.d dLV;
    private com.baidu.tieba.frs.mc.c dLW;
    private com.baidu.tieba.frs.vc.h dLX;
    private com.baidu.tieba.frs.mc.a dLY;
    private com.baidu.tieba.frs.live.a dLZ;
    private com.baidu.tieba.frs.entelechy.b dLm;
    private com.baidu.tieba.tbadkCore.data.e dLw;
    private VoiceManager dLz;
    private j dMa;
    public com.baidu.tieba.frs.vc.c dMb;
    private com.baidu.tieba.frs.mc.e dMc;
    private int dMd;
    private View.OnTouchListener dMe;
    private com.baidu.tieba.frs.view.a dMf;
    private com.baidu.tieba.frs.vc.e dMg;
    private boolean dMh;
    private com.baidu.tieba.NEGFeedBack.a dMj;
    private com.baidu.tieba.ala.a dMk;
    private com.baidu.tbadk.core.dialog.h dMl;
    private com.baidu.tieba.frs.brand.buttommenu.a dMm;
    private AddExperiencedModel dMn;
    private boolean dMp;
    private int dMx;
    private com.baidu.tbadk.core.dialog.a daE;
    public View mRootView;
    public static boolean dLr = false;
    public static volatile long dLC = 0;
    public static volatile long dLD = 0;
    public static volatile int mNetError = 0;
    public boolean dLn = false;
    private boolean dLo = false;
    private boolean dLp = false;
    private boolean dLq = true;
    public String dLs = null;
    public String mFrom = null;
    public int mFlag = 0;
    public boolean dLt = false;
    private boolean dLu = false;
    private String mThreadId = null;
    public String forumId = null;
    private int dLf = 0;
    private boolean dLv = false;
    private boolean dLx = false;
    private boolean dLy = false;
    private k dLA = null;
    public final bb bOk = null;
    private com.baidu.tieba.tbadkCore.l dLc = new com.baidu.tieba.tbadkCore.l();
    public long dsd = -1;
    public long bgJ = 0;
    public long bgB = 0;
    public long createTime = 0;
    public long beginTime = -1;
    public long dLB = 0;
    public Pair<Integer, Integer> dLE = null;
    public boolean dLF = false;
    private boolean dLG = false;
    private boolean dLH = false;
    public com.baidu.tbadk.l.b dLI = null;
    private boolean dLJ = true;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> dLR = new SparseArray<>();
    private boolean bSH = true;
    private boolean dMi = false;
    private boolean hasInit = false;
    private boolean dMo = false;
    private AddExperiencedModel.a dMq = new AddExperiencedModel.a() { // from class: com.baidu.tieba.frs.FrsFragment.1
        @Override // com.baidu.tieba.share.AddExperiencedModel.a
        public void b(ContriInfo contriInfo) {
            if (contriInfo != null && contriInfo.isShowToast()) {
                FrsFragment.this.a(contriInfo);
            }
        }
    };
    private HttpMessageListener dMr = new HttpMessageListener(CmdConfigHttp.CMD_PB_FLOOR_AGREE, true) { // from class: com.baidu.tieba.frs.FrsFragment.12
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
    private final CustomMessageListener dMs = new CustomMessageListener(2016495) { // from class: com.baidu.tieba.frs.FrsFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof bb) {
                    com.baidu.tieba.frs.f.h.a(FrsFragment.this.dLA, FrsFragment.this.dLc, FrsFragment.this.getForumId(), true, (bb) data);
                }
            }
        }
    };
    private CustomMessageListener dMt = new CustomMessageListener(2921005) { // from class: com.baidu.tieba.frs.FrsFragment.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.dLc != null) {
                FrsFragment.this.dLc.bDU();
                if (FrsFragment.this.dLA != null) {
                    FrsFragment.this.dLA.notifyDataChanged();
                }
            }
        }
    };
    private CustomMessageListener dMu = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.FrsFragment.33
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
    private final al dMv = new al() { // from class: com.baidu.tieba.frs.FrsFragment.34
        @Override // com.baidu.tieba.frs.al
        public void a(int i, int i2, ar arVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
            FrsFragment.this.aBX();
            if (FrsFragment.this.dLS != null) {
                FrsFragment.this.dLL.hu(FrsFragment.this.dLS.mM(i));
            }
            d.a aVar = new d.a();
            if (arVar != null) {
                aVar.isSuccess = arVar.errCode == 0;
                aVar.errorCode = arVar.errCode;
                aVar.errorMsg = arVar.errMsg;
                if (aVar.isSuccess) {
                    if (com.baidu.tbadk.core.util.v.I(arrayList)) {
                        FrsFragment.this.dLA.abA();
                    } else if (arVar.hasMore) {
                        if (com.baidu.tbadk.core.util.v.H(FrsFragment.this.dLc.getThreadList()) > 3) {
                            FrsFragment.this.dLA.aby();
                        } else {
                            FrsFragment.this.dLA.aDf();
                        }
                    } else if (arVar.dPp) {
                        FrsFragment.this.dLA.abz();
                    } else {
                        FrsFragment.this.dLA.abA();
                    }
                }
            } else {
                arVar = new ar();
                arVar.pn = 1;
                arVar.hasMore = false;
                arVar.dPp = false;
            }
            if (i == 1) {
                FrsFragment.this.dLJ = true;
                FrsFragment.this.dMH.a(FrsFragment.this.dLK.getType(), false, aVar);
            } else {
                FrsFragment.this.a(aVar);
                if (FrsFragment.this.dLK.aGY() != null) {
                    FrsFragment.this.dLc = FrsFragment.this.dLK.aGY();
                }
                FrsFragment.this.aCg();
            }
            if (FrsFragment.this.dMO != null) {
                FrsFragment.this.dMO.a(i, i2, arVar, arrayList);
            }
        }
    };
    private FrsTabViewController.a dMw = new FrsTabViewController.a() { // from class: com.baidu.tieba.frs.FrsFragment.35
        @Override // com.baidu.tieba.frs.vc.FrsTabViewController.a
        public void fW(int i) {
            boolean z = false;
            if (i != 1) {
                com.baidu.tieba.card.v.aqP().fy(false);
                FrsFragment.this.gv(false);
            }
            if (i == 303 && i != FrsFragment.this.dMx) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13121").aB(ImageViewerConfig.FORUM_ID, FrsFragment.this.forumId).aB("uid", TbadkCoreApplication.getCurrentAccount()));
            }
            FrsFragment.this.dMx = i;
            FrsFragment.this.aCj();
            com.baidu.tieba.frs.e.d.dTF.eeM = i;
            com.baidu.tieba.frs.e.d.dTF.eeN = -1;
            com.baidu.tieba.frs.a aBg = com.baidu.tieba.frs.a.aBg();
            if (i == 1 && FrsFragment.this.dMo) {
                z = true;
            }
            aBg.x(z, true);
        }
    };
    private CustomMessageListener dMy = new CustomMessageListener(2001606) { // from class: com.baidu.tieba.frs.FrsFragment.36
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                FrsFragment.this.dLM.nO(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    };
    private CustomMessageListener dMz = new CustomMessageListener(2001607) { // from class: com.baidu.tieba.frs.FrsFragment.37
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && ((Integer) customResponsedMessage.getData()).intValue() == 51 && FrsFragment.this.dLc != null) {
                com.baidu.tieba.frs.f.j.a(FrsFragment.this.dLc, FrsFragment.this.getPageContext());
            }
        }
    };
    private final CustomMessageListener dMA = new CustomMessageListener(2003019) { // from class: com.baidu.tieba.frs.FrsFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                FrsFragment.this.dLM.nM(49);
            }
        }
    };
    private final CustomMessageListener dMB = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.frs.FrsFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && FrsFragment.this.dLc != null && FrsFragment.this.dLc.bhx() != null) {
                SignData signData = (SignData) customResponsedMessage.getData();
                int user_level = FrsFragment.this.dLc.bhx().getUser_level();
                if (signData.forumId != null && signData.forumId.equals(FrsFragment.this.dLc.bhx().getId())) {
                    FrsFragment.this.dLc.d(signData);
                    FrsFragment.this.dLL.j(FrsFragment.this.dLc);
                    if (FrsFragment.this.dLL.aIA()) {
                        i = FrsFragment.this.dLc.bhx().getUser_level();
                        if (user_level >= i) {
                            i++;
                        }
                    } else {
                        i = user_level;
                    }
                    TbadkCoreApplication.getInst().addSignedForum(FrsFragment.this.dLc.bhx().getName(), signData.sign_bonus_point, i);
                }
            }
        }
    };
    private final CustomMessageListener dMC = new CustomMessageListener(2001352) { // from class: com.baidu.tieba.frs.FrsFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.r) && FrsFragment.this.dLc != null) {
                FrsFragment.this.dLc.c((com.baidu.tieba.tbadkCore.r) customResponsedMessage.getData());
                FrsFragment.this.dLL.i(FrsFragment.this.dLc);
                FrsFragment.this.dLM.a(FrsFragment.this.dLc, FrsFragment.this.dLK.aHE());
            }
        }
    };
    private final AntiHelper.a dMD = new AntiHelper.a() { // from class: com.baidu.tieba.frs.FrsFragment.5
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12536").y("obj_locate", as.a.aDq));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12535").y("obj_locate", as.a.aDq));
        }
    };
    private CustomMessageListener bVY = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.frs.FrsFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(FrsFragment.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().aPX != null) {
                        if (AntiHelper.a(FrsFragment.this.getActivity(), updateAttentionMessage.getData().aPX, FrsFragment.this.dMD) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12534").y("obj_locate", as.a.aDq));
                        }
                    } else if (updateAttentionMessage.getData().Jr && updateAttentionMessage.getData().isAttention) {
                        com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getPageContext().getPageActivity(), e.j.attention_success);
                    }
                }
            }
        }
    };
    private CustomMessageListener dME = new CustomMessageListener(2921346) { // from class: com.baidu.tieba.frs.FrsFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsFragment.this.refresh();
        }
    };
    private CustomMessageListener dMF = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.frs.FrsFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                FrsFragment.this.dLA.c((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener dMG = new CustomMessageListener(2001626) { // from class: com.baidu.tieba.frs.FrsFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewsRemindMessage newsRemindMessage;
            if (customResponsedMessage != null && (customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626 && (newsRemindMessage = (NewsRemindMessage) customResponsedMessage) != null) {
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (FrsFragment.this.dLA != null) {
                    FrsFragment.this.dLA.p(notificationCount, z);
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
    public final com.baidu.tieba.tbadkCore.n dMH = new com.baidu.tieba.tbadkCore.n() { // from class: com.baidu.tieba.frs.FrsFragment.11
        private long startTime = 0;

        @Override // com.baidu.tieba.tbadkCore.n
        public void mm(int i) {
            this.startTime = System.nanoTime();
            if (FrsFragment.this.dLA != null) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsFragment.this.dLA.aCR();
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
            if (FrsFragment.this.bSH) {
                FrsFragment.this.bSH = false;
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.dLA, FrsFragment.this.dLc, FrsFragment.this.getForumId(), false, null);
            }
            FrsFragment.this.aBX();
            FrsFragment.this.dLG = true;
            if (aVar != null && aVar.isSuccess) {
                FrsFragment.this.dLA.aDb().hg(com.baidu.tbadk.core.util.aq.Ee().Eg());
                FrsFragment.dLC = 0L;
                FrsFragment.dLD = 0L;
                FrsFragment.mNetError = 0;
            } else {
                FrsFragment.mNetError = 1;
            }
            if (!FrsFragment.this.dLK.aHI() && (i == 3 || i == 6)) {
                FrsFragment.this.dLW.resetData();
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (FrsFragment.this.dLK.aGY() != null) {
                FrsFragment.this.dLc = FrsFragment.this.dLK.aGY();
            }
            FrsFragment.this.dLA.b(FrsFragment.this.dLc.bDB());
            FrsFragment.this.mj(1);
            if (i == 7) {
                FrsFragment.this.mk(FrsFragment.this.dLc.bDg());
                return;
            }
            if (FrsFragment.this.dLc.zf() != null) {
                FrsFragment.this.setHasMore(FrsFragment.this.dLc.zf().zc());
            }
            if (i == 4) {
                if (!FrsFragment.this.dLK.aHI() && TbadkCoreApplication.getInst().isRecAppExist() && FrsFragment.this.dLK.aHy() == 1) {
                    FrsFragment.this.dLc.a(FrsFragment.this);
                }
                ArrayList<com.baidu.adp.widget.ListView.h> a2 = FrsFragment.this.dLW.a(false, false, FrsFragment.this.dLc.getThreadList(), FrsFragment.this.dLw, false);
                if (a2 != null) {
                    FrsFragment.this.dLc.ay(a2);
                    FrsFragment.this.dLc.bDK();
                    FrsFragment.this.dLA.a(a2, FrsFragment.this.dLc);
                }
                if (FrsFragment.this.dLK != null) {
                    com.baidu.tieba.frs.e.c.a(FrsFragment.this.dLc, FrsFragment.this.dLK.aHE(), 2);
                }
                com.baidu.tieba.frs.f.a.a(FrsFragment.this, FrsFragment.this.dLc.bhx(), FrsFragment.this.dLc.getThreadList(), false, FrsFragment.this.getPn());
                FrsFragment.this.bgJ = System.currentTimeMillis() - currentTimeMillis;
                FrsFragment.this.aBY();
                return;
            }
            FrsFragment.this.aBY();
            switch (i) {
                case 1:
                    FrsFragment.this.dLA.aCR();
                    break;
                case 2:
                    FrsFragment.this.dLA.aCR();
                    break;
                case 3:
                case 6:
                    if (FrsFragment.this.dLc != null) {
                        FrsFragment.this.dLc.bDI();
                    }
                    if (FrsFragment.this.dMb != null) {
                        FrsFragment.this.dMb.refresh();
                        break;
                    }
                    break;
            }
            FrsFragment.this.aBZ();
            if (aVar == null || aVar.errorCode == 0) {
                if (FrsFragment.this.dLc != null) {
                    FrsFragment.this.A(false, i == 5);
                    if (FrsFragment.this.dLK != null) {
                        com.baidu.tieba.frs.e.a.a(FrsFragment.this.getUniqueId(), FrsFragment.this.dLc.getThreadList(), FrsFragment.this.dLc.bhx(), FrsFragment.this.dLK.acy());
                    }
                    FrsFragment.this.dLA.mu(i);
                    FrsFragment.dLC = (System.nanoTime() - this.startTime) / 1000000;
                    if (aVar != null) {
                        FrsFragment.dLD = aVar.hmh;
                    }
                } else {
                    return;
                }
            } else if (FrsFragment.this.dLc == null || com.baidu.tbadk.core.util.v.I(FrsFragment.this.dLc.getThreadList())) {
                FrsFragment.this.a(aVar);
            } else if (aVar.hmg) {
                FrsFragment.this.showToast(FrsFragment.this.getPageContext().getResources().getString(e.j.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
            }
            if (FrsFragment.this.dLc.bCQ() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11384"));
            }
            if (FrsFragment.this.dsd > -1 && !FrsFragment.this.dMi) {
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.dLK, FrsFragment.this.dsd);
                FrsFragment.this.dsd = -1L;
                FrsFragment.this.dMi = true;
            }
            if (FrsFragment.this.dLx && FrsFragment.this.dLM.nM(49)) {
                FrsFragment.this.dLx = false;
            }
            FrsFragment.this.bgJ = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void b(com.baidu.tieba.tbadkCore.i iVar) {
            if ((iVar != null && ("normal_page".equals(FrsFragment.this.dLK.getPageType()) || "frs_page".equals(FrsFragment.this.dLK.getPageType()) || "book_page".equals(FrsFragment.this.dLK.getPageType()))) || "brand_page".equals(FrsFragment.this.dLK.getPageType())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001615, iVar));
                FrsFragment.this.a(iVar);
            }
        }
    };
    private final CustomMessageListener dMI = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.frs.FrsFragment.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                FrsFragment.this.dLc.a((com.baidu.tbadk.data.l) customResponsedMessage.getData());
                FrsFragment.this.dLA.aDb().notifyDataSetChanged();
            }
        }
    };
    private final CustomMessageListener mMemListener = new CustomMessageListener(2001194) { // from class: com.baidu.tieba.frs.FrsFragment.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && FrsFragment.this.dLc != null && (userData = FrsFragment.this.dLc.getUserData()) != null) {
                userData.setIsMem(num.intValue());
                if (num.intValue() != 0) {
                    FrsFragment.this.dLL.g(num);
                }
            }
        }
    };
    private final com.baidu.tieba.frs.mc.i dMJ = new com.baidu.tieba.frs.mc.i() { // from class: com.baidu.tieba.frs.FrsFragment.19
        @Override // com.baidu.tieba.frs.mc.i
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.h> arrayList, boolean z3) {
            if (FrsFragment.this.dLO != null && FrsFragment.this.dLK != null && FrsFragment.this.dLK.aHI() && z && !z2 && !z3) {
                FrsFragment.this.dLO.nr(i2);
            }
        }
    };
    public final View.OnTouchListener bjC = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.FrsFragment.20
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (FrsFragment.this.dMe != null) {
                FrsFragment.this.dMe.onTouch(view, motionEvent);
            }
            if (FrsFragment.this.dLQ != null && FrsFragment.this.dLQ.aDM() != null) {
                FrsFragment.this.dLQ.aDM().onTouchEvent(motionEvent);
            }
            if (FrsFragment.this.bZo != null) {
                FrsFragment.this.bZo.d(view, motionEvent);
            }
            if (FrsFragment.this.dLL != null) {
                FrsFragment.this.dLL.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private final CustomMessageListener dMK = new CustomMessageListener(2004507) { // from class: com.baidu.tieba.frs.FrsFragment.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "photolive_hostLevel", -1) != -1 && FrsFragment.this.dLc.bhx() != null) {
                FrsFragment.this.dLc.bhx().setCanAddPhotoLivePost(true);
            }
        }
    };
    public final View.OnClickListener dML = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.24
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsFragment.this.dLA == null || view != FrsFragment.this.dLA.aCP() || FrsFragment.this.getActivity() == null) {
                if (FrsFragment.this.dLc != null && FrsFragment.this.dLc.bhx() != null && FrsFragment.this.dLA != null && view == FrsFragment.this.dLA.aCV()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12402").aB(ImageViewerConfig.FORUM_ID, FrsFragment.this.dLc.bhx().getId()).aB("uid", TbadkCoreApplication.getCurrentAccount()).aB(ImageViewerConfig.FORUM_NAME, FrsFragment.this.dLc.bhx().getName()));
                    if (!StringUtils.isNull(FrsFragment.this.dLc.bhx().getName())) {
                        FrsFragment.this.sendMessage(new CustomMessage(2002001, new PostSearchActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), FrsFragment.this.dLc.bhx().getName(), FrsFragment.this.dLc.bhx().getId())));
                        return;
                    }
                    return;
                }
                if (view.getId() == e.g.game_activity_egg_layout && com.baidu.adp.lib.util.l.ll()) {
                    TiebaStatic.log("c10853");
                    if (FrsFragment.this.dLA.aCY()) {
                        FrsFragment.this.dLA.aCZ();
                    } else {
                        String activityUrl = FrsFragment.this.dLc.bhx().getYuleData().BL().getActivityUrl();
                        if (!StringUtils.isNull(activityUrl)) {
                            com.baidu.tbadk.browser.a.af(FrsFragment.this.getPageContext().getPageActivity(), activityUrl);
                        }
                    }
                }
                if (view == FrsFragment.this.dLA.aDg() && FrsFragment.this.dLK != null && FrsFragment.this.dLK.hasMore()) {
                    FrsFragment.this.dLA.aby();
                    FrsFragment.this.aaA();
                }
                if (view != null && view == FrsFragment.this.dLA.aCW() && ba.bJ(FrsFragment.this.getContext())) {
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
        private int dMS = 0;
        private int bNP = 0;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (FrsFragment.this.dLU != null) {
                FrsFragment.this.dLU.aIf();
            }
            this.dMS = 0;
            this.bNP = 0;
            if (recyclerView != null && (recyclerView instanceof BdRecyclerView)) {
                this.dMS = ((BdRecyclerView) recyclerView).getFirstVisiblePosition();
                this.bNP = ((BdRecyclerView) recyclerView).getLastVisiblePosition();
            }
            if (FrsFragment.this.dMg != null) {
                FrsFragment.this.dMg.a(recyclerView, this.dMS, this.bNP);
            }
            if (FrsFragment.this.dLc != null && FrsFragment.this.dLA != null && FrsFragment.this.dLA.aDb() != null) {
                FrsFragment.this.dLA.aM(this.dMS, this.bNP);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (FrsFragment.this.dLL != null) {
                FrsFragment.this.dLL.setScrollState(i);
            }
            if ((i == 2 || i == 1) && !FrsFragment.this.dLH) {
                FrsFragment.this.dLH = true;
                FrsFragment.this.dLA.aDe();
            }
            if (FrsFragment.this.dLI == null && !FrsFragment.this.aCn()) {
                FrsFragment.this.dLI = new com.baidu.tbadk.l.b();
                FrsFragment.this.dLI.gj(1000);
            }
            if (i == 0) {
                if (FrsFragment.this.dLI != null) {
                    FrsFragment.this.dLI.Pu();
                }
                com.baidu.tieba.card.v.aqP().fy(true);
                FrsFragment.this.gv(true);
                FrsFragment.this.dLA.aL(this.dMS, this.bNP);
            } else if (FrsFragment.this.dLI != null) {
                FrsFragment.this.dLI.Pt();
            }
            if (FrsFragment.this.dMg != null) {
                FrsFragment.this.dMg.onScrollStateChanged(recyclerView, i);
            }
            if (i == 0) {
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.dLA, FrsFragment.this.dLc, FrsFragment.this.getForumId(), false, null);
            }
            if (FrsFragment.this.dLM != null && i == 1) {
                FrsFragment.this.dLM.aIK();
            }
        }
    };
    private final d dMM = new d() { // from class: com.baidu.tieba.frs.FrsFragment.26
        @Override // com.baidu.tieba.frs.d
        public void a(int i, int i2, View view, View view2, bb bbVar) {
            if (i != FrsFragment.this.dLA.aDb().aFa()) {
                if (i != FrsFragment.this.dLA.aDb().aFb()) {
                    if (i == FrsFragment.this.dLA.aDb().aFc() && FrsFragment.this.dLc != null && FrsFragment.this.dLc.getUserData() != null && FrsFragment.this.dLc.getUserData().isBawu()) {
                        String bDe = FrsFragment.this.dLc.bDe();
                        if (!com.baidu.tbadk.core.util.ao.isEmpty(bDe) && FrsFragment.this.dLc.bhx() != null) {
                            com.baidu.tbadk.browser.a.ad(FrsFragment.this.getPageContext().getPageActivity(), bDe);
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10502").aB(ImageViewerConfig.FORUM_ID, FrsFragment.this.dLc.bhx().getId()).aB("uid", FrsFragment.this.dLc.getUserData().getUserId()));
                        }
                    }
                } else if (ba.bJ(FrsFragment.this.getPageContext().getPageActivity())) {
                    TiebaStatic.log("my_service_ck");
                    if (FrsFragment.this.dLc != null && FrsFragment.this.dLc.bhx() != null) {
                        ForumData bhx = FrsFragment.this.dLc.bhx();
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(bhx.getId(), 0L), bhx.getName(), bhx.getImage_url(), 0)));
                    }
                }
            } else if (ba.bJ(FrsFragment.this.getActivity())) {
                TiebaStatic.log("forum_fortune_click");
                com.baidu.tieba.frs.f.i.b(FrsFragment.this.getPageContext(), FrsFragment.this.dLc);
            }
        }
    };
    private final NoNetworkView.a dJm = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.FrsFragment.27
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bG(boolean z) {
            if (FrsFragment.this.dLK.aHy() == 1 && z && !FrsFragment.this.dLA.aCm()) {
                if (FrsFragment.this.dLc == null || com.baidu.tbadk.core.util.v.I(FrsFragment.this.dLc.getThreadList())) {
                    FrsFragment.this.hideNetRefreshView(FrsFragment.this.dLA.aDc());
                    FrsFragment.this.showLoadingView(FrsFragment.this.dLA.aDc(), true);
                    FrsFragment.this.dLA.gF(false);
                    FrsFragment.this.refresh();
                    return;
                }
                FrsFragment.this.dLA.aCR();
            }
        }
    };
    private final CustomMessageListener aQA = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.FrsFragment.28
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                com.baidu.tieba.frs.f.c.a(customResponsedMessage, FrsFragment.this.dLA, FrsFragment.this.dLc);
            }
        }
    };
    private com.baidu.adp.widget.ListView.n dMN = new a();
    private al dMO = new al() { // from class: com.baidu.tieba.frs.FrsFragment.29
        @Override // com.baidu.tieba.frs.al
        public void a(int i, int i2, ar arVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
            com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.29.1
                @Override // java.lang.Runnable
                public void run() {
                    if (FrsFragment.this.dLA != null && FrsFragment.this.dLA.arM()) {
                        FrsFragment.this.aaA();
                    }
                }
            });
        }
    };
    private CustomMessageListener dMP = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.frs.FrsFragment.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    FrsFragment.this.dMh = true;
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.frs.loadmore.a
    public /* bridge */ /* synthetic */ com.baidu.adp.base.e getPageContext() {
        return super.getPageContext();
    }

    public com.baidu.tieba.frs.entelechy.b.b aBL() {
        return this.dLS;
    }

    public com.baidu.adp.widget.ListView.n aBM() {
        return this.dMN;
    }

    public com.baidu.tieba.frs.mc.d aBN() {
        return this.dLV;
    }

    public com.baidu.tieba.frs.smartsort.b aBO() {
        return this.dLO;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public FrsModelController aBP() {
        return this.dLK;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public com.baidu.tieba.frs.mc.c aBQ() {
        return this.dLW;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public com.baidu.tieba.frs.vc.f aBR() {
        return this.dLL;
    }

    public com.baidu.tieba.frs.vc.k aBS() {
        return this.dLM;
    }

    public an aBT() {
        return this.dLQ;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public k aBU() {
        return this.dLA;
    }

    @Override // com.baidu.tieba.frs.am
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.am, com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.dLs;
    }

    public void setForumName(String str) {
        this.dLs = str;
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
        if (this.dLW == null) {
            return 1;
        }
        return this.dLW.getPn();
    }

    public int getPn() {
        if (this.dLW == null) {
            return 1;
        }
        return this.dLW.getPn();
    }

    public void setPn(int i) {
        if (this.dLW != null) {
            this.dLW.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.dLW != null) {
            this.dLW.setHasMore(i);
        }
    }

    public int aBV() {
        if (this.dLW == null) {
            return -1;
        }
        return this.dLW.aBV();
    }

    public boolean aBW() {
        return this.dLy;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d.a aVar) {
        if (aVar == null) {
            String string = TbadkCoreApplication.getInst().getString(e.j.error_unkown_try_again);
            this.dLA.aCM();
            showNetRefreshView(this.dLA.aDc(), string, true);
        } else if (340001 == aVar.errorCode) {
            a(aVar, this.dLc.bCN());
        } else {
            if (com.baidu.tbadk.core.util.v.I(this.dLc.getThreadList())) {
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
        this.dLA.aCM();
        this.dLA.mq(8);
        if (this.dMf == null) {
            this.dMf = new com.baidu.tieba.frs.view.a(getPageContext(), getNetRefreshListener());
        }
        this.dMf.iC(str);
        this.dMf.bU(list);
        this.dMf.attachView(view, z);
    }

    private void a(d.a aVar, List<RecmForumInfo> list) {
        if (this.dLA != null) {
            this.dLA.aCM();
            this.dLA.setTitle(this.dLs);
            a(this.dLA.aDc(), aVar.errorMsg, true, list);
        }
    }

    private void b(d.a aVar) {
        this.dLA.aCM();
        if (aVar.hmg) {
            showNetRefreshView(this.dLA.aDc(), TbadkCoreApplication.getInst().getString(e.j.net_error_text, new Object[]{aVar.errorMsg, Integer.valueOf(aVar.errorCode)}), true);
        } else {
            showNetRefreshView(this.dLA.aDc(), aVar.errorMsg, true);
        }
    }

    public void aBX() {
        hideLoadingView(this.dLA.aDc());
        if (!this.dLA.aCm()) {
            this.dLA.gG(false);
        } else {
            this.dLA.gG(true);
        }
        if (this.dLA.aCK() instanceof com.baidu.tieba.frs.tab.c) {
            ((com.baidu.tieba.frs.tab.c) this.dLA.aCK()).aIa();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBY() {
        if (aBV() == 0 && com.baidu.tbadk.core.util.v.I(this.dLc.bCW())) {
            if (com.baidu.tbadk.core.util.v.I(this.dLc.getThreadList())) {
                this.dLA.abA();
            } else {
                this.dLA.abz();
            }
        } else if (com.baidu.tbadk.core.util.v.H(this.dLc.getThreadList()) > 3) {
            this.dLA.aby();
        } else {
            this.dLA.aDf();
        }
    }

    public void a(ErrorData errorData) {
        aBX();
        this.dLA.aCR();
        d.a aHv = this.dLK.aHv();
        boolean I = com.baidu.tbadk.core.util.v.I(this.dLc.getThreadList());
        if (aHv != null && I) {
            if (this.dLK.aHw() != 0) {
                this.dLK.aHC();
                this.dLA.aCR();
            } else {
                a(aHv);
            }
            this.dLA.B(this.dLc.bEb(), false);
            return;
        }
        a(aHv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mj(int i) {
        List<WindowToast> list;
        if (TbadkCoreApplication.isLogin() && this.dLc != null && (list = this.dLc.hnL) != null && list.size() > 0) {
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
        if (this.dLc == null || this.dLc.bhx() != null) {
            this.dLA.aDa();
        } else if (this.dLc.bhx().getYuleData() != null && this.dLc.bhx().getYuleData().BK()) {
            TiebaStatic.log("c10852");
            this.dLA.a(this.dLc.bhx().getYuleData().BL());
        } else {
            this.dLA.aDa();
        }
    }

    private void z(boolean z, boolean z2) {
        if (this.dLK != null && this.dLc != null && this.dLA != null && z) {
            if (!this.dLK.aHI() && this.dLK.aHy() == 1) {
                if (!this.dLK.aHG()) {
                    this.dLc.bDQ();
                    this.dLc.bDR();
                }
                boolean z3 = false;
                if (this.dLA.aDb().k(com.baidu.tieba.card.data.n.dbU)) {
                    z3 = this.dLc.bDV();
                }
                if (!z3) {
                    this.dLc.bDT();
                }
                if (TbadkCoreApplication.getInst().isRecAppExist()) {
                    this.dLc.a(this);
                }
                if (!this.dLA.aDb().k(bb.atM)) {
                    this.dLc.bDJ();
                }
                this.dLc.bDW();
            }
            if (!this.dLA.aDb().k(bb.atM)) {
                this.dLc.bDP();
                this.dLc.bDN();
            } else {
                this.dLc.bDO();
                this.dLc.bDM();
            }
            this.dLc.bDK();
            this.dLc.bDH();
            if (this.dLA.aDb().k(com.baidu.tieba.h.b.eoi)) {
                this.dLc.nu(z2);
            }
            if (TbadkCoreApplication.isLogin() && (!this.dLK.aHI() || this.dLK.isNetFirstLoad)) {
                this.dLc.bDX();
            }
            this.dLc.bDZ();
        }
    }

    public boolean aCa() {
        if (this.dLL != null && this.dLK != null) {
            this.dLL.a(this.dLK.getPageType(), this.dLc);
        }
        boolean z = false;
        if (this.dLc != null) {
            z = this.dLc.bEc();
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
            if (this.dLc != null) {
                this.dLA.a((ArrayList<com.baidu.adp.widget.ListView.h>) null, this.dLc);
                this.dLL.nH(1);
                this.dLA.aCU();
                this.dLM.a(this.dLc, this.dLK.aHE());
                com.baidu.tieba.frs.tab.d nN = this.dLM.nN(this.dLc.bDg());
                if (nN != null && !TextUtils.isEmpty(nN.url)) {
                    aoVar = new ao();
                    aoVar.dPm = nN.url;
                    aoVar.stType = nN.name;
                }
                this.dLK.a(this.dLc.bDg(), 0, aoVar);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(boolean z, boolean z2) {
        try {
            if (this.dLc != null && this.dLM != null && this.dLK != null) {
                if (!this.dLA.aDb().k(bb.atM)) {
                    this.dLc.bDJ();
                }
                boolean I = com.baidu.tbadk.core.util.v.I(this.dLc.bDu());
                this.dLA.gD(I);
                if (!I) {
                    if (this.dMg == null) {
                        this.dMg = new com.baidu.tieba.frs.vc.e(this, (NoPressedRelativeLayout) this.mRootView);
                    }
                    if (this.bZo == null) {
                        this.bZo = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
                    }
                } else {
                    this.dMg = null;
                    this.bZo = null;
                }
                if (this.dLc.bhx() != null) {
                    this.dLs = this.dLc.bhx().getName();
                    this.forumId = this.dLc.bhx().getId();
                }
                if (this.dLc.bEc()) {
                    this.dLM.a(this.dLc, this.dLK.aHE());
                }
                if (z) {
                    z(true, z);
                } else {
                    z(this.dLJ, z);
                }
                aCa();
                if (this.dLS != null) {
                    this.dLS.a(this.dLL, this.dLc);
                }
                if (this.dLc.zf() != null) {
                    setHasMore(this.dLc.zf().zc());
                }
                ArrayList<com.baidu.adp.widget.ListView.h> a2 = this.dLW.a(z2, true, this.dLc.getThreadList(), null, z, false);
                if (a2 != null) {
                    this.dLc.ay(a2);
                }
                this.dLc.bDY();
                if (this.dLK.aHy() == 1) {
                    aCg();
                    if (!z && this.dLK.getPn() == 1) {
                        aCb();
                    }
                }
                this.dLf = this.dLc.aHA();
                if (this.dLw != null) {
                    this.dLv = true;
                    this.dLw.vH(this.dLf);
                    com.baidu.tieba.frs.f.a.a(this, this.dLc.bhx(), this.dLc.getThreadList(), this.dLv, getPn());
                }
                if (this.dLU != null) {
                    this.dLU.aV(this.dLM.aIH());
                }
                aBX();
                this.dLA.aCN();
                this.dLA.B(true, false);
                if (this.dLc.bhx() != null) {
                    this.dLA.ov(this.dLc.bhx().getWarningMsg());
                }
                if (this.dLc != null && this.dLc.bDx() != null && com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("frs_video_activity_guide", 0L) == 0) {
                    com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.13
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsFragment.this.dLA.aDk();
                        }
                    }, 1000L);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2921326, this));
                this.dLA.aCG();
                if (this.dLc != null && this.dLc.bhx() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016564, new VisitedForumData(this.dLc.bhx().getId(), this.dLc.bhx().getName(), this.dLc.bhx().getImage_url(), String.valueOf(System.currentTimeMillis() / 1000), "showlive".equals(this.dLc.bhx().special_forum_type))));
                }
                this.dMm.a(this.dLc.hnQ, this.dLc.bhx());
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
        if (this.dLZ == null) {
            this.dLZ = new com.baidu.tieba.frs.live.a(this, com.baidu.adp.lib.g.b.l(this.forumId, 0));
        }
        this.dLZ.aHg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.i iVar) {
        try {
            if (!this.dLG && iVar != null && this.dLc != null) {
                this.dLc.g(iVar);
                A(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void aCc() {
        if (this.dLK != null) {
            ot(this.dLK.getPageType());
        } else {
            ot("normal_page");
        }
    }

    private void ot(String str) {
        gw("frs_page".equals(str));
        if (this.dLS != null) {
            this.dLS.a(this.dLL, this.dLA, this.dLc);
        }
    }

    public void gw(boolean z) {
        if (this.dLX != null) {
            this.dLX.c(this.dLA, z);
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
            this.dLm = new com.baidu.tieba.frs.entelechy.b();
            this.dLS = this.dLm.aEz();
            this.dLL = new com.baidu.tieba.frs.vc.f(this, this.dLm, (FrsHeaderViewContainer) this.mRootView.findViewById(e.g.header_view_container));
            this.dLM = new FrsTabViewController(this, this.mRootView);
            this.dLM.registerListener();
            this.dLL.a(this.dLM);
            this.dLM.a(this.dMw);
            Intent intent = getActivity().getIntent();
            if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                this.dLo = true;
            }
            this.dLA = new k(this, this.dML, this.dLm, this.dLo, this.dLL);
            this.dLA.setHeaderViewHeight(this.dMd);
            this.dMm = new com.baidu.tieba.frs.brand.buttommenu.a(getPageContext(), this.mRootView);
        } else {
            if (this.mRootView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            if (this.dLM != null) {
                this.dLM.registerListener();
            }
            this.dLA.aDj();
        }
        this.dMp = true;
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        this.dsd = System.currentTimeMillis();
        this.beginTime = this.dsd;
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.dLx = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.dsd = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            M(intent);
        }
        this.bgB = this.beginTime - this.dsd;
        this.dLw = new com.baidu.tieba.tbadkCore.data.e("frs", com.baidu.tieba.tbadkCore.data.e.hpb);
        if (this.dLK == null) {
            this.dLK = new FrsModelController(this, this.dMH);
            this.dLK.a(this.dMv);
            this.dLK.init();
        }
        if (intent != null) {
            this.dLK.p(intent.getExtras());
        } else if (bundle != null) {
            this.dLK.p(bundle);
        } else {
            this.dLK.p(null);
        }
        if (intent != null) {
            this.dLL.t(intent.getExtras());
        } else if (bundle != null) {
            this.dLL.t(bundle);
        } else {
            this.dLL.t(null);
        }
        this.dLz = getVoiceManager();
        this.dMa = new j(getPageContext(), this);
        initUI();
        initData(bundle);
        if (!aCn()) {
            this.dLQ = new an(getActivity(), this.dLA, this.dLL);
            this.dLQ.gU(true);
        }
        this.dLz = getVoiceManager();
        if (this.dLz != null) {
            this.dLz.onCreate(getPageContext());
        }
        new com.baidu.tieba.frs.mc.g();
        this.dLW = new com.baidu.tieba.frs.mc.c(this, this.dMJ);
        this.dLO = new com.baidu.tieba.frs.smartsort.b(this);
        this.dLX = new com.baidu.tieba.frs.vc.h(this);
        this.dLU = new com.baidu.tieba.frs.vc.a(getPageContext(), this.dLK.aHF());
        this.dLP = new com.baidu.tieba.frs.mc.b(this);
        this.dLV = new com.baidu.tieba.frs.mc.d(this);
        this.dLN = new com.baidu.tieba.frs.mc.f(this);
        this.dLY = new com.baidu.tieba.frs.mc.a(this);
        this.dMb = new com.baidu.tieba.frs.vc.c(this);
        this.dMc = new com.baidu.tieba.frs.mc.e(this, getUniqueId());
        this.dMj = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "frs");
        this.dMk = new com.baidu.tieba.ala.a(getPageContext());
        registerListener(this.bVY);
        registerListener(this.mMemListener);
        registerListener(this.dMC);
        registerListener(this.dMK);
        registerListener(this.dMB);
        registerListener(this.dMI);
        registerListener(this.dMy);
        registerListener(this.dMz);
        registerListener(this.dMA);
        registerListener(this.dMs);
        registerListener(this.dMt);
        registerListener(this.dMP);
        registerListener(this.dMF);
        registerListener(this.dMu);
        registerListener(this.dMG);
        registerListener(this.dME);
        this.dMr.setTag(getPageContext().getUniqueId());
        registerListener(this.dMr);
        registerListener(this.akJ);
        this.dLA.gF(false);
        if (!aCn() && !this.hasInit) {
            showLoadingView(this.dLA.aDc(), true);
            this.dLK.r(3, false);
        }
        com.baidu.tieba.frs.a.aBg().a(new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.16
            @Override // com.baidu.tieba.frs.a.b
            public void y(boolean z, boolean z2) {
                if (FrsFragment.this.dLA != null) {
                    FrsFragment.this.dLA.mr(z ? 0 : 8);
                    if (!z2) {
                        FrsFragment.this.dMo = z;
                    }
                    if (FrsFragment.this.dLA.aDb() != null && FrsFragment.this.dLK != null && FrsFragment.this.dLK.aHz()) {
                        FrsFragment.this.dLA.aDb().notifyDataSetChanged();
                    }
                    if (FrsFragment.this.dLA.aCL() != null) {
                        FrsFragment.this.dLA.gC(!z);
                    }
                    if (FrsFragment.this.getActivity() instanceof FrsActivity) {
                        ((FrsActivity) FrsFragment.this.getActivity()).gu(!z);
                    }
                    if (FrsFragment.this.dMm != null) {
                        FrsFragment.this.dMm.hd(!z);
                    }
                    FrsFragment.this.dLA.gH(!z);
                    FrsFragment.this.dLA.gI(z ? false : true);
                }
            }

            @Override // com.baidu.tieba.frs.a.b
            public void mg(int i) {
                if (FrsFragment.this.dLA != null) {
                    FrsFragment.this.dLA.ms(i);
                }
            }

            @Override // com.baidu.tieba.frs.a.b
            public void aBm() {
                com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getContext(), e.j.frs_multi_delete_max_num);
            }
        });
        this.dLA.b(new d.a() { // from class: com.baidu.tieba.frs.FrsFragment.17
            @Override // com.baidu.tieba.NEGFeedBack.d.a
            public void a(DeleteThreadHttpResponseMessage deleteThreadHttpResponseMessage) {
                int i;
                int i2 = 0;
                if (deleteThreadHttpResponseMessage != null) {
                    FrsFragment.this.dLA.UX();
                    FrsFragment.this.dLA.aDl();
                    if (deleteThreadHttpResponseMessage.getError() == 0) {
                        String text = !TextUtils.isEmpty(deleteThreadHttpResponseMessage.getText()) ? deleteThreadHttpResponseMessage.getText() : FrsFragment.this.getString(e.j.delete_fail);
                        if (deleteThreadHttpResponseMessage.getRetType() == 1211066) {
                            if (FrsFragment.this.daE == null) {
                                FrsFragment.this.daE = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.daE.eK(text);
                            FrsFragment.this.daE.a(e.j.dialog_known, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.17.1
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.daE.bh(false);
                            FrsFragment.this.daE.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.daE.BS();
                        } else if (deleteThreadHttpResponseMessage.getRetType() == 1211067) {
                            if (FrsFragment.this.daE == null) {
                                FrsFragment.this.daE = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.daE.eK(text);
                            FrsFragment.this.daE.a(e.j.know, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.17.2
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.daE.bh(false);
                            FrsFragment.this.daE.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.daE.BS();
                        } else {
                            FrsFragment.this.dLA.ad(deleteThreadHttpResponseMessage.getText(), ContextCompat.getColor(FrsFragment.this.getContext(), deleteThreadHttpResponseMessage.getRetType() == 1 ? e.d.nav_bar_tip_error : e.d.cp_link_tip_a_alpha95));
                        }
                        FrsFragment.this.bE(deleteThreadHttpResponseMessage.getSuccessItems());
                        com.baidu.tieba.frs.a.aBg().bD(deleteThreadHttpResponseMessage.getSuccessItems());
                        Iterator<com.baidu.adp.widget.ListView.h> it = FrsFragment.this.dLc.getThreadList().iterator();
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
        if (this.dLM != null) {
            this.dLM.ehv = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bE(List<String> list) {
        if (!com.baidu.tbadk.core.util.v.I(list)) {
            ArrayList<com.baidu.adp.widget.ListView.h> threadList = this.dLc.getThreadList();
            if (!com.baidu.tbadk.core.util.v.I(threadList) && this.dLA.getListView() != null && this.dLA.getListView().getData() != null) {
                Iterator<com.baidu.adp.widget.ListView.h> it = threadList.iterator();
                List<com.baidu.adp.widget.ListView.h> data = this.dLA.getListView().getData();
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
                                this.dLW.ab(bbVar);
                                this.dLA.getListView().getAdapter().notifyItemRemoved(i);
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
        if (isAdded() && this.bSH && !isLoadingViewAttached()) {
            showLoadingView(this.dLA.aDc(), true);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void abb() {
        if (isAdded() && this.bSH && isLoadingViewAttached()) {
            hideLoadingView(this.dLA.aDc());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (aCn()) {
            showLoadingView(this.dLA.aDc(), true);
            this.dLA.mt(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.dLK.r(3, true);
            FI().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void setHeaderViewHeight(int i) {
        this.dMd = i;
        if (this.dLA != null) {
            this.dLA.setHeaderViewHeight(this.dMd);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.v vVar) {
        if (vVar != null) {
            this.bjB = vVar.QA();
            this.dMe = vVar.QB();
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void showFloatingView() {
        if (this.bjB != null) {
            this.bjB.cV(true);
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
                this.dLs = data.getQueryParameter("name");
                this.mFrom = data.getQueryParameter("from");
                if (!StringUtils.isNull(this.dLs)) {
                    intent.putExtra("name", this.dLs);
                }
                if (!StringUtils.isNull(this.mFrom)) {
                    intent.putExtra("from", this.mFrom);
                }
                TiebaStatic.log("c10105");
            }
            if (StringUtils.isNull(this.dLs) && intent != null && intent.getData() != null) {
                Uri data2 = intent.getData();
                if (com.baidu.tbadk.BdToken.f.e(data2)) {
                    com.baidu.tbadk.BdToken.f.vJ().b(data2, new f.a() { // from class: com.baidu.tieba.frs.FrsFragment.18
                        @Override // com.baidu.tbadk.BdToken.f.a
                        public void n(HashMap<String, Object> hashMap) {
                            if (hashMap != null && (hashMap.get(com.baidu.tbadk.BdToken.f.alc) instanceof String)) {
                                FrsFragment.this.dLs = (String) hashMap.get(com.baidu.tbadk.BdToken.f.alc);
                            }
                        }
                    });
                } else {
                    com.baidu.tieba.frs.f.d O = com.baidu.tieba.frs.f.i.O(intent);
                    if (O != null) {
                        this.dLs = O.forumName;
                        if (O.efN != null && O.efN.equals("aidou")) {
                            com.baidu.tbadk.core.dialog.h.axK = System.currentTimeMillis();
                        }
                    }
                }
                if (!StringUtils.isNull(this.dLs)) {
                    intent.putExtra("name", this.dLs);
                }
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.dLz = getVoiceManager();
        if (this.dLz != null) {
            this.dLz.onStart(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        Intent intent;
        registerListener(2001118, this.aQA);
        if (bundle != null) {
            this.dLs = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
            this.dLs = intent.getStringExtra("name");
            this.mFrom = intent.getStringExtra("from");
            this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
        }
        if (getArguments() != null) {
            this.dLt = getArguments().getBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, false);
        }
        if (TextUtils.isEmpty(this.mFrom) || FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
        }
        if (this.mIsLogin) {
            registerListener(2001120, this.aQA);
        }
        this.dLL.t(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.q.c.bCC().s(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.dMP);
        if (this.dLz != null) {
            this.dLz.onDestory(getPageContext());
        }
        com.baidu.tieba.recapp.report.a.remove("FRS");
        this.dLz = null;
        com.baidu.tieba.card.v.aqP().fy(false);
        if (this.dLc != null && this.dLc.bhx() != null) {
            ac.aDJ().ca(com.baidu.adp.lib.g.b.d(this.dLc.bhx().getId(), 0L));
        }
        if (this.dLZ != null) {
            this.dLZ.onDestory();
        }
        if (this.dLA != null) {
            com.baidu.tieba.frs.f.h.a(this.dLA, this.dLc, getForumId(), false, null);
            this.dLA.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.dLI != null) {
                this.dLI.Pv();
            }
            this.dLA.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.dLL.onActivityDestroy();
        if (this.dLK != null) {
            this.dLK.acK();
        }
        if (this.dLQ != null) {
            this.dLQ.Qz();
        }
        if (this.dLT != null) {
            this.dLT.destory();
        }
        if (this.dLU != null) {
            this.dLU.destory();
        }
        if (this.dLO != null) {
            this.dLO.onDestroy();
        }
        if (this.dMg != null) {
            this.dMg.onDestory();
        }
        if (this.dLY != null) {
            this.dLY.onDestroy();
        }
        if (this.dMj != null) {
            this.dMj.onDestroy();
        }
        if (this.dMk != null) {
            this.dMk.onDestroy();
        }
        com.baidu.tieba.recapp.d.a.bwJ().bwL();
        com.baidu.tieba.frs.f.j.aIc();
        if (this.dLM != null) {
            this.dLM.a((FrsTabViewController.a) null);
            this.dLM.aIK();
        }
        if (this.dMl != null) {
            this.dMl.onDestroy();
        }
        if (this.dMn != null) {
            this.dMn.onDestroy();
        }
        com.baidu.tieba.frs.a.aBg().a(null);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.dLs);
        bundle.putString("from", this.mFrom);
        this.dLK.onSaveInstanceState(bundle);
        if (this.dLz != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            this.dLz.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.dLY != null) {
            this.dLY.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dLA != null) {
            this.dLA.aCR();
            this.dLA.onResume();
        }
        this.dLN.hs(true);
        this.dLJ = true;
        if (dLr) {
            dLr = false;
            this.dLA.startPullRefresh();
            return;
        }
        if (this.dLz != null) {
            this.dLz.onResume(getPageContext());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921338));
        this.dLA.gJ(false);
        if (this.dMh) {
            refresh(6);
            this.dMh = false;
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
                this.dLs = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.dLu = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.dLu) {
                aCe();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCe() {
        this.dLA.startPullRefresh();
    }

    public void closeActivity() {
        com.baidu.tieba.frs.f.i.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.mFrom);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.dLA.setTitle(this.dLs);
        } else {
            this.dLA.setTitle("");
            this.mFlag = 1;
        }
        this.dLA.setOnAdapterItemClickListener(this.dMN);
        this.dLA.addOnScrollListener(this.mScrollListener);
        this.dLA.h(this.dJm);
        this.dLA.aDb().a(this.dMM);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dMp) {
            this.dLA.onChangeSkinType(i);
            this.dLL.nG(i);
            this.dLM.onChangeSkinType(i);
            if (this.dMf != null) {
                this.dMf.onChangeSkinType();
            }
            if (this.dMl != null) {
                this.dMl.onChangeSkinType(i);
            }
            if (this.dMm != null) {
                this.dMm.d(getPageContext(), i);
            }
            if (this.daE != null) {
                com.baidu.tbadk.o.a.a(getPageContext(), this.daE.BT());
            }
        }
    }

    public void ml(int i) {
        if (!this.mIsLogin) {
            if (this.dLc != null && this.dLc.yR() != null) {
                this.dLc.yR().setIfpost(1);
            }
            if (i == 0) {
                ba.bI(getActivity());
            }
        } else if (this.dLc != null) {
            if (i == 0) {
                com.baidu.tieba.frs.f.j.d(this, 0);
            } else {
                this.dLA.aCT();
            }
        }
    }

    public void refresh() {
        com.baidu.tieba.a.d.Wk().ka("page_frs");
        refresh(3);
    }

    public void refresh(int i) {
        this.dLG = false;
        aCj();
        if (this.dLA.aCJ() != null) {
            this.dLA.aCJ().aNK();
        }
        this.dLK.r(i, true);
    }

    private void aCf() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.g.h.jH().d(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.22
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.we(FrsFragment.this.dLs);
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
            if (this.dLc != null) {
                this.dLA.anM();
                this.dLA.gC(aCs());
                if (!com.baidu.tieba.frs.vc.f.l(this.dLc) || !com.baidu.tieba.frs.vc.f.k(this.dLc)) {
                }
                if (this.dLc.bhx() != null) {
                    this.dLs = this.dLc.bhx().getName();
                    this.forumId = this.dLc.bhx().getId();
                }
                if (this.dLc.zf() != null) {
                    setHasMore(this.dLc.zf().zc());
                }
                this.dLA.setTitle(this.dLs);
                this.dLA.setForumName(this.dLs);
                TbadkCoreApplication.getInst().setDefaultBubble(this.dLc.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.dLc.getUserData().getBimg_end_time());
                aCf();
                aCh();
                ArrayList<com.baidu.adp.widget.ListView.h> threadList = this.dLc.getThreadList();
                if (threadList != null) {
                    this.dLA.a(threadList, this.dLc);
                    com.baidu.tieba.frs.f.c.w(this.dLA);
                    this.dLL.nH(getPageNum());
                    this.dLL.i(this.dLc);
                    this.dLM.a(this.dLc, this.dLK.aHE());
                    this.dLA.aCU();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void aCh() {
        if (this.dLc != null) {
            if (this.dLc.bhM() == 1) {
                this.dLA.aDb().setFromCDN(true);
            } else {
                this.dLA.aDb().setFromCDN(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.dLN.hs(false);
        this.dLJ = false;
        this.dLA.onPause();
        if (this.dLz != null) {
            this.dLz.onPause(getPageContext());
        }
        this.dLA.gJ(true);
        if (this.dLU != null) {
            this.dLU.aIf();
        }
        com.baidu.tbadk.BdToken.c.vy().vz();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.dLM != null && this.dLM.aII() != null && (this.dLM.aII().fragment instanceof BaseFragment)) {
            ((BaseFragment) this.dLM.aII().fragment).setPrimary(z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.v.aqP().fy(false);
        gv(false);
        if (this.dLc != null && this.dLc.bhx() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            com.baidu.tbadk.distribute.a.Mc().a(getPageContext().getPageActivity(), "frs", this.dLc.bhx().getId(), 0L);
        }
        if (this.dLz != null) {
            this.dLz.onStop(getPageContext());
        }
        if (FI() != null) {
            FI().getRecycledViewPool().clear();
        }
        this.dLL.onActivityStop();
        com.baidu.tbadk.util.w.QD();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            if (this.dLL != null) {
                this.dLL.gA(isPrimary());
            }
            if (this.dLA != null) {
                this.dLA.gA(isPrimary());
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (com.baidu.tieba.frs.a.aBg().aBh()) {
                com.baidu.tieba.frs.a.aBg().reset();
                return true;
            } else if (this.dLA != null) {
                return this.dLA.aCQ();
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
        if (this.dLz == null) {
            this.dLz = VoiceManager.instance();
        }
        return this.dLz;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdRecyclerView FI() {
        if (this.dLA == null) {
            return null;
        }
        return this.dLA.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void aCj() {
        if (this.dLz != null) {
            this.dLz.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> FJ() {
        if (this.aLr == null) {
            this.aLr = UserIconBox.l(getPageContext().getPageActivity(), 8);
        }
        return this.aLr;
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
        if (this.dLA == null) {
            return null;
        }
        return this.dLA.act();
    }

    @Override // com.baidu.tbadk.core.view.NavigationBar.a
    public void b(Pair<Integer, Integer> pair) {
        this.dLE = pair;
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
                if (bdUniqueId == p.dOi) {
                    if (FrsFragment.this.dLA != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11752").aB(ImageViewerConfig.FORUM_ID, FrsFragment.this.forumId).aB("obj_locate", "1"));
                        FrsFragment.this.dLA.startPullRefresh();
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
                                if (bdUniqueId.getId() == bb.avf.getId()) {
                                    com.baidu.tieba.frs.f.h.a(bbVar.zA());
                                } else if (bdUniqueId.getId() == bb.atP.getId()) {
                                    com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c12940");
                                    amVar.aB("obj_type", "2");
                                    amVar.aB("tid", bbVar.getTid());
                                    TiebaStatic.log(amVar);
                                }
                                com.baidu.tieba.frs.f.i.a(FrsFragment.this, bbVar, i, z);
                                com.baidu.tieba.frs.f.h.a(FrsFragment.this, FrsFragment.this.dLc, bbVar);
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
            hideNetRefreshView(this.dLA.aDc());
            showLoadingView(this.dLA.aDc(), true);
            this.dLA.gF(false);
            this.dLK.r(3, true);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public com.baidu.tieba.tbadkCore.l aCl() {
        return this.dLc;
    }

    public boolean aCm() {
        return this.dLA.aCm();
    }

    public void ac(Object obj) {
        if (this.dLP != null && this.dLP.edj != null) {
            this.dLP.edj.m(obj);
        }
    }

    public void ad(Object obj) {
        if (this.dLP != null && this.dLP.edk != null) {
            this.dLP.edk.m(obj);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        this.dLA.getListView().stopScroll();
        if (!this.dLA.aCX()) {
            if (!com.baidu.adp.lib.util.l.ll()) {
                this.dLA.abA();
            } else if (this.dLK.aHy() == 1) {
                aaO();
                aaA();
            } else if (this.dLK.hasMore()) {
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
            if (!this.dLK.aHI() && TbadkCoreApplication.getInst().isRecAppExist() && this.dLK.aHy() == 1) {
                this.dLc.a(this, arrayList);
            }
            if (this.dLK != null) {
                com.baidu.tieba.frs.e.a.a(getUniqueId(), arrayList, this.dLc.bhx(), this.dLK.acy());
            }
            ArrayList<com.baidu.adp.widget.ListView.h> a2 = this.dLW.a(false, false, arrayList, this.dLw, false);
            if (a2 != null) {
                this.dLc.ay(a2);
                this.dLA.a(a2, this.dLc);
            }
            if (this.dLK != null) {
                com.baidu.tieba.frs.e.c.a(this.dLc, this.dLK.aHE(), 2);
            }
        }
    }

    private void aaO() {
        if (aBV() == 1 || this.dLW.bQ(this.dLc.bCW())) {
            if (com.baidu.tbadk.core.util.v.H(this.dLc.getThreadList()) > 3) {
                this.dLA.aby();
            } else {
                this.dLA.aDf();
            }
        } else if (com.baidu.tbadk.core.util.v.I(this.dLc.getThreadList())) {
            this.dLA.abA();
        } else {
            this.dLA.abz();
        }
    }

    @Override // com.baidu.tieba.frs.mc.j
    public void aaA() {
        if (this.dLW != null) {
            this.dLW.a(this.dLs, this.forumId, this.dLc);
        }
    }

    public void takePhoto() {
        if (!com.baidu.tbadk.core.util.ab.e(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.ak.b(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        if (this.dLF) {
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
        if (this.dLQ != null) {
            this.dLQ.gU(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.dLR.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a ht(int i) {
        return this.dLR.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        this.dMa.b(bVar);
    }

    public boolean aCn() {
        return this.dLo;
    }

    @Override // com.baidu.tieba.frs.ah
    public void aaZ() {
        if (this.dLA != null) {
            showFloatingView();
            this.dLA.getListView().scrollToPosition(0);
            this.dLA.startPullRefresh();
        }
    }

    public ForumWriteData aCo() {
        if (this.dLc == null || this.dLc.bhx() == null) {
            return null;
        }
        ForumData bhx = this.dLc.bhx();
        ForumWriteData forumWriteData = new ForumWriteData(bhx.getId(), bhx.getName(), bhx.getPrefixData(), this.dLc.yR());
        forumWriteData.avatar = bhx.getImage_url();
        forumWriteData.forumLevel = bhx.getUser_level();
        forumWriteData.specialForumType = bhx.special_forum_type;
        forumWriteData.firstDir = bhx.getFirst_class();
        forumWriteData.secondDir = bhx.getSecond_class();
        UserData userData = this.dLc.getUserData();
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
        this.dLA.mq(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        super.hideLoadingView(view);
        this.dLA.mq(0);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        super.showNetRefreshView(view, str, z);
        this.dLA.mq(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshViewNoClick(View view, String str, boolean z) {
        super.showNetRefreshViewNoClick(view, str, z);
        this.dLA.mq(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        super.hideNetRefreshView(view);
        this.dLA.mq(0);
    }

    public void aCp() {
        FrsTabViewController.b aII;
        if (this.dLM != null && (aII = this.dLM.aII()) != null && aII.fragment != null && (aII.fragment instanceof aj)) {
            ((aj) aII.fragment).aBE();
        }
    }

    public void a(ContriInfo contriInfo) {
        if (this.dMl == null) {
            this.dMl = new com.baidu.tbadk.core.dialog.h(getTbPageContext());
            this.dMl.a(new h.a() { // from class: com.baidu.tieba.frs.FrsFragment.31
                @Override // com.baidu.tbadk.core.dialog.h.a
                public void bo(boolean z) {
                    if (z) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13061"));
                    }
                }
            });
        }
        this.dMl.a(contriInfo, -1L);
    }

    public void gz(boolean z) {
        this.dLq = z;
    }

    public boolean aCq() {
        return this.dLq;
    }

    public void ou(String str) {
        if (TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.util.ao.isEmpty(str)) {
            if (this.dMn == null) {
                this.dMn = new AddExperiencedModel(getTbPageContext());
                this.dMn.a(this.dMq);
            }
            this.dMn.cF(this.forumId, str);
        }
    }

    public com.baidu.tieba.frs.entelechy.b aCr() {
        return this.dLm;
    }

    public boolean aCs() {
        return (this.dLK != null && this.dLK.aHz() && com.baidu.tieba.frs.a.aBg().aBh()) ? false : true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.e.c
    public boolean videoNeedPreload() {
        if (this.dLc != null) {
            return com.baidu.tbadk.util.ab.QK() && (this.dLc.hnS || com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("auto_play_video_frs", 0) == 1);
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
