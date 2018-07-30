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
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.e.a.a;
import com.baidu.tbadk.KuangFloatingViewController;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
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
import com.baidu.tbadk.core.util.at;
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
import com.baidu.tieba.d;
import com.baidu.tieba.deletethread.DeleteThreadHttpResponseMessage;
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
/* loaded from: classes2.dex */
public class FrsFragment extends BaseFragment implements BdListView.e, a.InterfaceC0062a, NavigationBar.a, UserIconBox.b<BdRecyclerView>, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, ah, ak, am, com.baidu.tieba.frs.loadmore.a, com.baidu.tieba.frs.mc.j, com.baidu.tieba.recapp.n {
    public static boolean dmh = false;
    public static volatile long dms = 0;
    public static volatile long dmt = 0;
    public static volatile int dmu = 0;
    private com.baidu.tbadk.util.r aWE;
    private com.baidu.adp.lib.e.b<TbImageView> ayS;
    private com.baidu.tieba.frs.gametab.b bFD;
    private com.baidu.tbadk.core.dialog.a cBf;
    private FrsModelController dmB;
    private com.baidu.tieba.frs.vc.f dmC;
    private FrsTabViewController dmD;
    private com.baidu.tieba.frs.mc.f dmE;
    private com.baidu.tieba.frs.smartsort.b dmF;
    private com.baidu.tieba.frs.mc.b dmG;
    private an dmH;
    private com.baidu.tieba.frs.entelechy.b.b dmJ;
    private com.baidu.tbadk.i.a dmK;
    private com.baidu.tieba.frs.vc.a dmL;
    private com.baidu.tieba.frs.mc.d dmM;
    private com.baidu.tieba.frs.mc.c dmN;
    private com.baidu.tieba.frs.vc.h dmO;
    private com.baidu.tieba.frs.mc.a dmP;
    private com.baidu.tieba.frs.live.a dmQ;
    private j dmR;
    public com.baidu.tieba.frs.vc.c dmS;
    private com.baidu.tieba.frs.mc.e dmT;
    private int dmU;
    private View.OnTouchListener dmV;
    private com.baidu.tieba.frs.view.a dmW;
    private com.baidu.tieba.frs.vc.e dmX;
    private boolean dmY;
    private com.baidu.tieba.frs.entelechy.b dmc;
    private com.baidu.tieba.tbadkCore.data.e dmm;
    private VoiceManager dmp;
    private com.baidu.tieba.NEGFeedBack.a dna;
    private com.baidu.tieba.ala.a dnb;
    private com.baidu.tbadk.core.dialog.h dnc;
    private com.baidu.tieba.frs.brand.buttommenu.a dnd;
    private AddExperiencedModel dne;
    private int dnn;
    public View mRootView;
    public boolean dmd = false;
    private boolean dme = false;
    private boolean dmf = false;
    private boolean dmg = true;
    public String dmi = null;
    public String mFrom = null;
    public int mFlag = 0;
    public boolean dmj = false;
    private boolean dmk = false;
    private String mThreadId = null;
    public String forumId = null;
    private int dlV = 0;
    private boolean dml = false;
    private boolean dmn = false;
    private boolean dmo = false;
    private k dmq = null;
    public final bb buw = null;
    private com.baidu.tieba.tbadkCore.l dlS = new com.baidu.tieba.tbadkCore.l();
    public long cSN = -1;
    public long aTT = 0;
    public long aTL = 0;
    public long createTime = 0;
    public long beginTime = -1;
    public long dmr = 0;
    public Pair<Integer, Integer> dmv = null;
    public boolean dmw = false;
    private boolean dmx = false;
    private boolean dmy = false;
    public com.baidu.tbadk.l.b dmz = null;
    private boolean dmA = true;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> dmI = new SparseArray<>();
    private boolean byX = true;
    private boolean dmZ = false;
    private boolean dnf = false;
    private AddExperiencedModel.a dng = new AddExperiencedModel.a() { // from class: com.baidu.tieba.frs.FrsFragment.1
        @Override // com.baidu.tieba.share.AddExperiencedModel.a
        public void b(ContriInfo contriInfo) {
            if (contriInfo != null && contriInfo.isShowToast()) {
                FrsFragment.this.a(contriInfo);
            }
        }
    };
    private HttpMessageListener dnh = new HttpMessageListener(CmdConfigHttp.CMD_PB_FLOOR_AGREE, true) { // from class: com.baidu.tieba.frs.FrsFragment.12
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
    private final CustomMessageListener dni = new CustomMessageListener(2016495) { // from class: com.baidu.tieba.frs.FrsFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof bb) {
                    com.baidu.tieba.frs.f.h.a(FrsFragment.this.dmq, FrsFragment.this.dlS, FrsFragment.this.getForumId(), true, (bb) data);
                }
            }
        }
    };
    private CustomMessageListener dnj = new CustomMessageListener(2921005) { // from class: com.baidu.tieba.frs.FrsFragment.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.dlS != null) {
                FrsFragment.this.dlS.bvh();
                if (FrsFragment.this.dmq != null) {
                    FrsFragment.this.dmq.akd();
                }
            }
        }
    };
    private CustomMessageListener dnk = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.FrsFragment.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 1) {
                    FrsFragment.this.auw();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                }
            }
        }
    };
    private final al dnl = new al() { // from class: com.baidu.tieba.frs.FrsFragment.35
        @Override // com.baidu.tieba.frs.al
        public void a(int i, int i2, ar arVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
            FrsFragment.this.aup();
            if (FrsFragment.this.dmJ != null) {
                FrsFragment.this.dmC.go(FrsFragment.this.dmJ.kR(i));
            }
            d.a aVar = new d.a();
            if (arVar != null) {
                aVar.isSuccess = arVar.errCode == 0;
                aVar.errorCode = arVar.errCode;
                aVar.errorMsg = arVar.errMsg;
                if (aVar.isSuccess) {
                    if (com.baidu.tbadk.core.util.w.z(arrayList)) {
                        FrsFragment.this.dmq.Un();
                    } else if (arVar.hasMore) {
                        if (com.baidu.tbadk.core.util.w.y(FrsFragment.this.dlS.getThreadList()) > 3) {
                            FrsFragment.this.dmq.Ul();
                        } else {
                            FrsFragment.this.dmq.avx();
                        }
                    } else if (arVar.dpQ) {
                        FrsFragment.this.dmq.Um();
                    } else {
                        FrsFragment.this.dmq.Un();
                    }
                }
            } else {
                arVar = new ar();
                arVar.pn = 1;
                arVar.hasMore = false;
                arVar.dpQ = false;
            }
            if (i == 1) {
                FrsFragment.this.dmA = true;
                FrsFragment.this.dnx.a(FrsFragment.this.dmB.getType(), false, aVar);
            } else {
                FrsFragment.this.a(aVar);
                if (FrsFragment.this.dmB.azf() != null) {
                    FrsFragment.this.dlS = FrsFragment.this.dmB.azf();
                }
                FrsFragment.this.auy();
            }
            if (FrsFragment.this.dnE != null) {
                FrsFragment.this.dnE.a(i, i2, arVar, arrayList);
            }
        }
    };
    private FrsTabViewController.a dnm = new FrsTabViewController.a() { // from class: com.baidu.tieba.frs.FrsFragment.36
        @Override // com.baidu.tieba.frs.vc.FrsTabViewController.a
        public void eZ(int i) {
            boolean z = false;
            if (i != 1) {
                com.baidu.tieba.card.v.aiY().ey(false);
            }
            if (i == 303 && i != FrsFragment.this.dnn) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13121").af(ImageViewerConfig.FORUM_ID, FrsFragment.this.forumId).af("uid", TbadkCoreApplication.getCurrentAccount()));
            }
            FrsFragment.this.dnn = i;
            FrsFragment.this.auB();
            com.baidu.tieba.frs.e.c.dtY.dEG = i;
            com.baidu.tieba.frs.e.c.dtY.dEH = -1;
            com.baidu.tieba.frs.a atD = com.baidu.tieba.frs.a.atD();
            if (i == 1 && FrsFragment.this.dnf) {
                z = true;
            }
            atD.s(z, true);
        }
    };
    private CustomMessageListener dno = new CustomMessageListener(2001606) { // from class: com.baidu.tieba.frs.FrsFragment.37
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                FrsFragment.this.dmD.lS(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    };
    private CustomMessageListener dnp = new CustomMessageListener(2001607) { // from class: com.baidu.tieba.frs.FrsFragment.38
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && ((Integer) customResponsedMessage.getData()).intValue() == 51 && FrsFragment.this.dlS != null) {
                com.baidu.tieba.frs.f.j.a(FrsFragment.this.dlS, FrsFragment.this.getPageContext());
            }
        }
    };
    private final CustomMessageListener dnq = new CustomMessageListener(2003019) { // from class: com.baidu.tieba.frs.FrsFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                FrsFragment.this.dmD.lQ(49);
            }
        }
    };
    private final CustomMessageListener dnr = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.frs.FrsFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && FrsFragment.this.dlS != null && FrsFragment.this.dlS.aZl() != null) {
                SignData signData = (SignData) customResponsedMessage.getData();
                int user_level = FrsFragment.this.dlS.aZl().getUser_level();
                if (signData.forumId != null && signData.forumId.equals(FrsFragment.this.dlS.aZl().getId())) {
                    FrsFragment.this.dlS.d(signData);
                    FrsFragment.this.dmC.i(FrsFragment.this.dlS);
                    if (FrsFragment.this.dmC.aAI()) {
                        i = FrsFragment.this.dlS.aZl().getUser_level();
                        if (user_level >= i) {
                            i++;
                        }
                    } else {
                        i = user_level;
                    }
                    TbadkCoreApplication.getInst().addSignedForum(FrsFragment.this.dlS.aZl().getName(), signData.sign_bonus_point, i);
                }
            }
        }
    };
    private final CustomMessageListener dns = new CustomMessageListener(2001352) { // from class: com.baidu.tieba.frs.FrsFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.r) && FrsFragment.this.dlS != null) {
                FrsFragment.this.dlS.c((com.baidu.tieba.tbadkCore.r) customResponsedMessage.getData());
                FrsFragment.this.dmC.h(FrsFragment.this.dlS);
                FrsFragment.this.dmD.a(FrsFragment.this.dlS, FrsFragment.this.dmB.azL());
            }
        }
    };
    private final AntiHelper.a dnt = new AntiHelper.a() { // from class: com.baidu.tieba.frs.FrsFragment.5
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12536").r("obj_locate", at.a.arq));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12535").r("obj_locate", at.a.arq));
        }
    };
    private CustomMessageListener bCp = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.frs.FrsFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(FrsFragment.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().aDu != null) {
                        if (AntiHelper.a(FrsFragment.this.getActivity(), updateAttentionMessage.getData().aDu, FrsFragment.this.dnt) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12534").r("obj_locate", at.a.arq));
                        }
                    } else if (updateAttentionMessage.getData().Gp && updateAttentionMessage.getData().isAttention) {
                        com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getPageContext().getPageActivity(), d.j.attention_success);
                    }
                }
            }
        }
    };
    private CustomMessageListener dnu = new CustomMessageListener(2921346) { // from class: com.baidu.tieba.frs.FrsFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsFragment.this.refresh();
        }
    };
    private CustomMessageListener dnv = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.frs.FrsFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                FrsFragment.this.dmq.c((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener dnw = new CustomMessageListener(2001626) { // from class: com.baidu.tieba.frs.FrsFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewsRemindMessage newsRemindMessage;
            if (customResponsedMessage != null && (customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626 && (newsRemindMessage = (NewsRemindMessage) customResponsedMessage) != null) {
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (FrsFragment.this.dmq != null) {
                    FrsFragment.this.dmq.o(notificationCount, z);
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.n dnx = new com.baidu.tieba.tbadkCore.n() { // from class: com.baidu.tieba.frs.FrsFragment.10
        private long startTime = 0;

        @Override // com.baidu.tieba.tbadkCore.n
        public void ku(int i) {
            this.startTime = System.nanoTime();
            if (FrsFragment.this.dmq != null) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsFragment.this.dmq.avk();
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
            if (FrsFragment.this.byX) {
                FrsFragment.this.byX = false;
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.dmq, FrsFragment.this.dlS, FrsFragment.this.getForumId(), false, null);
            }
            FrsFragment.this.aup();
            FrsFragment.this.dmx = true;
            if (aVar != null && aVar.isSuccess) {
                FrsFragment.this.dmq.avu().fZ(com.baidu.tbadk.core.util.ar.zw().zy());
                FrsFragment.dms = 0L;
                FrsFragment.dmt = 0L;
                FrsFragment.dmu = 0;
            } else {
                FrsFragment.dmu = 1;
            }
            if (!FrsFragment.this.dmB.azP() && (i == 3 || i == 6)) {
                FrsFragment.this.dmN.resetData();
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (FrsFragment.this.dmB.azf() != null) {
                FrsFragment.this.dlS = FrsFragment.this.dmB.azf();
            }
            FrsFragment.this.dmq.b(FrsFragment.this.dlS.buP());
            FrsFragment.this.kr(1);
            if (i == 7) {
                FrsFragment.this.ks(FrsFragment.this.dlS.buu());
                return;
            }
            if (FrsFragment.this.dlS.uw() != null) {
                FrsFragment.this.setHasMore(FrsFragment.this.dlS.uw().us());
            }
            if (i == 4) {
                if (!FrsFragment.this.dmB.azP() && TbadkCoreApplication.getInst().isRecAppExist() && FrsFragment.this.dmB.azF() == 1) {
                    FrsFragment.this.dlS.a(FrsFragment.this);
                }
                ArrayList<com.baidu.adp.widget.ListView.h> a2 = FrsFragment.this.dmN.a(false, false, FrsFragment.this.dlS.getThreadList(), FrsFragment.this.dmm, false);
                if (a2 != null) {
                    FrsFragment.this.dlS.ax(a2);
                    FrsFragment.this.dlS.buY();
                    FrsFragment.this.dmq.a(a2, FrsFragment.this.dlS);
                }
                if (FrsFragment.this.dmB != null) {
                    com.baidu.tieba.frs.e.b.a(FrsFragment.this.dlS, FrsFragment.this.dmB.azL(), 2);
                }
                com.baidu.tieba.frs.f.a.a(FrsFragment.this, FrsFragment.this.dlS.aZl(), FrsFragment.this.dlS.getThreadList(), false, FrsFragment.this.getPn());
                FrsFragment.this.aTT = System.currentTimeMillis() - currentTimeMillis;
                FrsFragment.this.auq();
                return;
            }
            FrsFragment.this.auq();
            switch (i) {
                case 1:
                    FrsFragment.this.dmq.avk();
                    break;
                case 2:
                    FrsFragment.this.dmq.avk();
                    break;
                case 3:
                case 6:
                    if (FrsFragment.this.dlS != null) {
                        FrsFragment.this.dlS.buW();
                    }
                    if (FrsFragment.this.dmS != null) {
                        FrsFragment.this.dmS.refresh();
                        break;
                    }
                    break;
            }
            FrsFragment.this.aur();
            if (aVar == null || aVar.errorCode == 0) {
                if (FrsFragment.this.dlS != null) {
                    FrsFragment.this.v(false, i == 5);
                    FrsFragment.this.dmq.kC(i);
                    FrsFragment.dms = (System.nanoTime() - this.startTime) / 1000000;
                    if (aVar != null) {
                        FrsFragment.dmt = aVar.gKC;
                    }
                } else {
                    return;
                }
            } else if (FrsFragment.this.dlS == null || com.baidu.tbadk.core.util.w.z(FrsFragment.this.dlS.getThreadList())) {
                FrsFragment.this.a(aVar);
            } else if (aVar.gKB) {
                FrsFragment.this.showToast(FrsFragment.this.getPageContext().getResources().getString(d.j.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
            }
            if (FrsFragment.this.dlS.bue() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11384"));
            }
            if (FrsFragment.this.cSN > -1 && !FrsFragment.this.dmZ) {
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.dmB, FrsFragment.this.cSN);
                FrsFragment.this.cSN = -1L;
                FrsFragment.this.dmZ = true;
            }
            if (FrsFragment.this.dmn && FrsFragment.this.dmD.lQ(49)) {
                FrsFragment.this.dmn = false;
            }
            FrsFragment.this.aTT = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void b(com.baidu.tieba.tbadkCore.i iVar) {
            if ((iVar != null && ("normal_page".equals(FrsFragment.this.dmB.azB()) || "frs_page".equals(FrsFragment.this.dmB.azB()) || "book_page".equals(FrsFragment.this.dmB.azB()))) || "brand_page".equals(FrsFragment.this.dmB.azB())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001615, iVar));
                FrsFragment.this.a(iVar);
            }
        }
    };
    private final CustomMessageListener dny = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.frs.FrsFragment.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.i) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                FrsFragment.this.dlS.a((com.baidu.tbadk.data.i) customResponsedMessage.getData());
                FrsFragment.this.dmq.avu().notifyDataSetChanged();
            }
        }
    };
    private final CustomMessageListener mMemListener = new CustomMessageListener(2001194) { // from class: com.baidu.tieba.frs.FrsFragment.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && FrsFragment.this.dlS != null && (userData = FrsFragment.this.dlS.getUserData()) != null) {
                userData.setIsMem(num.intValue());
                if (num.intValue() != 0) {
                    FrsFragment.this.dmC.g(num);
                }
            }
        }
    };
    private final com.baidu.tieba.frs.mc.i dnz = new com.baidu.tieba.frs.mc.i() { // from class: com.baidu.tieba.frs.FrsFragment.18
        @Override // com.baidu.tieba.frs.mc.i
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.h> arrayList, boolean z3) {
            if (FrsFragment.this.dmF != null && FrsFragment.this.dmB != null && FrsFragment.this.dmB.azP() && z && !z2 && !z3) {
                FrsFragment.this.dmF.lv(i2);
            }
        }
    };
    public final View.OnTouchListener aWF = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.FrsFragment.19
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (FrsFragment.this.dmV != null) {
                FrsFragment.this.dmV.onTouch(view, motionEvent);
            }
            if (FrsFragment.this.dmH != null && FrsFragment.this.dmH.avN() != null) {
                FrsFragment.this.dmH.avN().onTouchEvent(motionEvent);
            }
            if (FrsFragment.this.bFD != null) {
                FrsFragment.this.bFD.d(view, motionEvent);
            }
            if (FrsFragment.this.dmC != null) {
                FrsFragment.this.dmC.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private final CustomMessageListener dnA = new CustomMessageListener(2004507) { // from class: com.baidu.tieba.frs.FrsFragment.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "photolive_hostLevel", -1) != -1 && FrsFragment.this.dlS.aZl() != null) {
                FrsFragment.this.dlS.aZl().setCanAddPhotoLivePost(true);
            }
        }
    };
    public final View.OnClickListener dnB = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.25
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsFragment.this.dmq == null || view != FrsFragment.this.dmq.avi() || FrsFragment.this.getActivity() == null) {
                if (FrsFragment.this.dlS != null && FrsFragment.this.dlS.aZl() != null && FrsFragment.this.dmq != null && view == FrsFragment.this.dmq.avo()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12402").af(ImageViewerConfig.FORUM_ID, FrsFragment.this.dlS.aZl().getId()).af("uid", TbadkCoreApplication.getCurrentAccount()).af(ImageViewerConfig.FORUM_NAME, FrsFragment.this.dlS.aZl().getName()));
                    if (!StringUtils.isNull(FrsFragment.this.dlS.aZl().getName())) {
                        FrsFragment.this.sendMessage(new CustomMessage(2002001, new PostSearchActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), FrsFragment.this.dlS.aZl().getName(), FrsFragment.this.dlS.aZl().getId())));
                        return;
                    }
                    return;
                }
                if (view.getId() == d.g.game_activity_egg_layout && com.baidu.adp.lib.util.l.jV()) {
                    TiebaStatic.log("c10853");
                    if (FrsFragment.this.dmq.avr()) {
                        FrsFragment.this.dmq.avs();
                    } else {
                        String activityUrl = FrsFragment.this.dlS.aZl().getYuleData().wY().getActivityUrl();
                        if (!StringUtils.isNull(activityUrl)) {
                            com.baidu.tbadk.browser.a.S(FrsFragment.this.getPageContext().getPageActivity(), activityUrl);
                        }
                    }
                }
                if (view == FrsFragment.this.dmq.avy() && FrsFragment.this.dmB != null && FrsFragment.this.dmB.hasMore()) {
                    FrsFragment.this.dmq.Ul();
                    FrsFragment.this.Tn();
                }
                if (view != null && view == FrsFragment.this.dmq.avp() && ba.aV(FrsFragment.this.getContext())) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12924").r("obj_locate", 2));
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
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.FrsFragment.26
        private int dnI = 0;
        private int bua = 0;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (FrsFragment.this.dmL != null) {
                FrsFragment.this.dmL.aAn();
            }
            this.dnI = 0;
            this.bua = 0;
            if (recyclerView != null && (recyclerView instanceof BdRecyclerView)) {
                this.dnI = ((BdRecyclerView) recyclerView).getFirstVisiblePosition();
                this.bua = ((BdRecyclerView) recyclerView).getLastVisiblePosition();
            }
            if (FrsFragment.this.dmX != null) {
                FrsFragment.this.dmX.a(recyclerView, this.dnI, this.bua);
            }
            if (FrsFragment.this.dlS != null && FrsFragment.this.dmq != null && FrsFragment.this.dmq.avu() != null) {
                FrsFragment.this.dmq.aC(this.dnI, this.bua);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (FrsFragment.this.dmC != null) {
                FrsFragment.this.dmC.setScrollState(i);
            }
            if ((i == 2 || i == 1) && !FrsFragment.this.dmy) {
                FrsFragment.this.dmy = true;
                FrsFragment.this.dmq.avw();
            }
            if (FrsFragment.this.dmz == null && !FrsFragment.this.auF()) {
                FrsFragment.this.dmz = new com.baidu.tbadk.l.b();
                FrsFragment.this.dmz.fm(1000);
            }
            if (i == 0) {
                if (FrsFragment.this.dmz != null) {
                    FrsFragment.this.dmz.Kw();
                }
                com.baidu.tieba.card.v.aiY().ey(true);
                FrsFragment.this.dmq.aB(this.dnI, this.bua);
            } else if (FrsFragment.this.dmz != null) {
                FrsFragment.this.dmz.Kv();
            }
            if (FrsFragment.this.dmX != null) {
                FrsFragment.this.dmX.onScrollStateChanged(recyclerView, i);
            }
            if (i == 0) {
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.dmq, FrsFragment.this.dlS, FrsFragment.this.getForumId(), false, null);
            }
            if (FrsFragment.this.dmD != null && i == 1) {
                FrsFragment.this.dmD.aAR();
            }
        }
    };
    private final d dnC = new d() { // from class: com.baidu.tieba.frs.FrsFragment.27
        @Override // com.baidu.tieba.frs.d
        public void a(int i, int i2, View view, View view2, bb bbVar) {
            if (i != FrsFragment.this.dmq.avu().axb()) {
                if (i != FrsFragment.this.dmq.avu().axc()) {
                    if (i == FrsFragment.this.dmq.avu().axd() && FrsFragment.this.dlS != null && FrsFragment.this.dlS.getUserData() != null && FrsFragment.this.dlS.getUserData().isBawu()) {
                        String bus = FrsFragment.this.dlS.bus();
                        if (!com.baidu.tbadk.core.util.ap.isEmpty(bus) && FrsFragment.this.dlS.aZl() != null) {
                            com.baidu.tbadk.browser.a.Q(FrsFragment.this.getPageContext().getPageActivity(), bus);
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10502").af(ImageViewerConfig.FORUM_ID, FrsFragment.this.dlS.aZl().getId()).af("uid", FrsFragment.this.dlS.getUserData().getUserId()));
                        }
                    }
                } else if (ba.aV(FrsFragment.this.getPageContext().getPageActivity())) {
                    TiebaStatic.log("my_service_ck");
                    if (FrsFragment.this.dlS != null && FrsFragment.this.dlS.aZl() != null) {
                        ForumData aZl = FrsFragment.this.dlS.aZl();
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(aZl.getId(), 0L), aZl.getName(), aZl.getImage_url(), 0)));
                    }
                }
            } else if (ba.aV(FrsFragment.this.getActivity())) {
                TiebaStatic.log("forum_fortune_click");
                com.baidu.tieba.frs.f.i.b(FrsFragment.this.getPageContext(), FrsFragment.this.dlS);
            }
        }
    };
    private final NoNetworkView.a dkf = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.FrsFragment.28
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aQ(boolean z) {
            if (FrsFragment.this.dmB.azF() == 1 && z && !FrsFragment.this.dmq.auE()) {
                if (FrsFragment.this.dlS == null || com.baidu.tbadk.core.util.w.z(FrsFragment.this.dlS.getThreadList())) {
                    FrsFragment.this.hideNetRefreshView(FrsFragment.this.dmq.aed());
                    FrsFragment.this.showLoadingView(FrsFragment.this.dmq.aed(), true);
                    FrsFragment.this.dmq.fF(false);
                    FrsFragment.this.refresh();
                    return;
                }
                FrsFragment.this.dmq.avk();
            }
        }
    };
    private final CustomMessageListener aDX = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.FrsFragment.29
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                com.baidu.tieba.frs.f.c.a(customResponsedMessage, FrsFragment.this.dmq, FrsFragment.this.dlS);
            }
        }
    };
    private com.baidu.adp.widget.ListView.n dnD = new a();
    private al dnE = new al() { // from class: com.baidu.tieba.frs.FrsFragment.30
        @Override // com.baidu.tieba.frs.al
        public void a(int i, int i2, ar arVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
            com.baidu.adp.lib.g.e.in().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.30.1
                @Override // java.lang.Runnable
                public void run() {
                    if (FrsFragment.this.dmq != null && FrsFragment.this.dmq.ajU()) {
                        FrsFragment.this.Tn();
                    }
                }
            });
        }
    };
    private CustomMessageListener dnF = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.frs.FrsFragment.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    FrsFragment.this.dmY = true;
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.frs.loadmore.a
    public /* bridge */ /* synthetic */ com.baidu.adp.base.e getPageContext() {
        return super.getPageContext();
    }

    public com.baidu.tieba.frs.entelechy.b.b aud() {
        return this.dmJ;
    }

    public com.baidu.adp.widget.ListView.n aue() {
        return this.dnD;
    }

    public com.baidu.tieba.frs.mc.d auf() {
        return this.dmM;
    }

    public com.baidu.tieba.frs.smartsort.b aug() {
        return this.dmF;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public FrsModelController auh() {
        return this.dmB;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public com.baidu.tieba.frs.mc.c aui() {
        return this.dmN;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public com.baidu.tieba.frs.vc.f auj() {
        return this.dmC;
    }

    public com.baidu.tieba.frs.vc.j auk() {
        return this.dmD;
    }

    public an aul() {
        return this.dmH;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public k aum() {
        return this.dmq;
    }

    @Override // com.baidu.tieba.frs.am
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.am, com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.dmi;
    }

    public void setForumName(String str) {
        this.dmi = str;
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
        if (this.dmN == null) {
            return 1;
        }
        return this.dmN.getPn();
    }

    public int getPn() {
        if (this.dmN == null) {
            return 1;
        }
        return this.dmN.getPn();
    }

    public void setPn(int i) {
        if (this.dmN != null) {
            this.dmN.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.dmN != null) {
            this.dmN.setHasMore(i);
        }
    }

    public int aun() {
        if (this.dmN == null) {
            return -1;
        }
        return this.dmN.aun();
    }

    public boolean auo() {
        return this.dmo;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d.a aVar) {
        if (aVar == null) {
            String string = TbadkCoreApplication.getInst().getString(d.j.error_unkown_try_again);
            this.dmq.avf();
            showNetRefreshView(this.dmq.aed(), string, true);
        } else if (340001 == aVar.errorCode) {
            a(aVar, this.dlS.bub());
        } else {
            if (com.baidu.tbadk.core.util.w.z(this.dlS.getThreadList())) {
                b(aVar);
            }
            if (auF()) {
                setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst(), d.e.ds280));
            } else {
                setNetRefreshViewEmotionDefMarginTop();
            }
        }
    }

    public void a(View view, String str, boolean z, List<RecmForumInfo> list) {
        this.dmq.avf();
        this.dmq.ky(8);
        if (this.dmW == null) {
            this.dmW = new com.baidu.tieba.frs.view.a(getPageContext(), getNetRefreshListener());
        }
        this.dmW.hk(str);
        this.dmW.bB(list);
        this.dmW.c(view, z);
    }

    private void a(d.a aVar, List<RecmForumInfo> list) {
        if (this.dmq != null) {
            this.dmq.avf();
            this.dmq.setTitle(this.dmi);
            a(this.dmq.aed(), aVar.errorMsg, true, list);
        }
    }

    private void b(d.a aVar) {
        this.dmq.avf();
        if (aVar.gKB) {
            showNetRefreshView(this.dmq.aed(), TbadkCoreApplication.getInst().getString(d.j.net_error_text, new Object[]{aVar.errorMsg, Integer.valueOf(aVar.errorCode)}), true);
        } else {
            showNetRefreshView(this.dmq.aed(), aVar.errorMsg, true);
        }
    }

    public void aup() {
        hideLoadingView(this.dmq.aed());
        if (!this.dmq.auE()) {
            this.dmq.fG(false);
        } else {
            this.dmq.fG(true);
        }
        if (this.dmq.avd() instanceof com.baidu.tieba.frs.tab.c) {
            ((com.baidu.tieba.frs.tab.c) this.dmq.avd()).aAh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auq() {
        if (aun() == 0 && com.baidu.tbadk.core.util.w.z(this.dlS.buk())) {
            if (com.baidu.tbadk.core.util.w.z(this.dlS.getThreadList())) {
                this.dmq.Un();
            } else {
                this.dmq.Um();
            }
        } else if (com.baidu.tbadk.core.util.w.y(this.dlS.getThreadList()) > 3) {
            this.dmq.Ul();
        } else {
            this.dmq.avx();
        }
    }

    public void a(ErrorData errorData) {
        aup();
        this.dmq.avk();
        d.a azC = this.dmB.azC();
        boolean z = com.baidu.tbadk.core.util.w.z(this.dlS.getThreadList());
        if (azC != null && z) {
            if (this.dmB.azD() != 0) {
                this.dmB.azJ();
                this.dmq.avk();
            } else {
                a(azC);
            }
            this.dmq.w(this.dlS.bvo(), false);
            return;
        }
        a(azC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kr(int i) {
        List<WindowToast> list;
        if (TbadkCoreApplication.isLogin() && this.dlS != null && (list = this.dlS.gMf) != null && list.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < list.size()) {
                    WindowToast windowToast = list.get(i3);
                    if (windowToast == null || windowToast.toast_type.intValue() != i) {
                        i2 = i3 + 1;
                    } else if (!com.baidu.tbadk.core.util.ap.isEmpty(windowToast.toast_link)) {
                        sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(getPageContext().getPageActivity(), "", com.baidu.tbadk.util.z.hL(windowToast.toast_link), true)));
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
    public void aur() {
        if (this.dlS == null || this.dlS.aZl() != null) {
            this.dmq.avt();
        } else if (this.dlS.aZl().getYuleData() != null && this.dlS.aZl().getYuleData().wX()) {
            TiebaStatic.log("c10852");
            this.dmq.a(this.dlS.aZl().getYuleData().wY());
        } else {
            this.dmq.avt();
        }
    }

    private void u(boolean z, boolean z2) {
        if (this.dmB != null && this.dlS != null && this.dmq != null && z) {
            if (!this.dmB.azP() && this.dmB.azF() == 1) {
                if (!this.dmB.azN()) {
                    this.dlS.bve();
                    this.dlS.bvf();
                }
                boolean z3 = false;
                if (this.dmq.avu().k(com.baidu.tieba.card.data.n.cCw)) {
                    z3 = this.dlS.bvi();
                }
                if (!z3) {
                    this.dlS.bvg();
                }
                if (TbadkCoreApplication.getInst().isRecAppExist()) {
                    this.dlS.a(this);
                }
                if (!this.dmq.avu().k(bb.ahB)) {
                    this.dlS.buX();
                }
                this.dlS.bvj();
            }
            if (!this.dmq.avu().k(bb.ahB)) {
                this.dlS.bvd();
                this.dlS.bvb();
            } else {
                this.dlS.bvc();
                this.dlS.bva();
            }
            this.dlS.buY();
            this.dlS.buV();
            if (this.dmq.avu().k(com.baidu.tieba.h.b.dNq)) {
                this.dlS.mp(z2);
            }
            if (TbadkCoreApplication.isLogin() && (!this.dmB.azP() || this.dmB.isNetFirstLoad)) {
                this.dlS.bvk();
            }
            this.dlS.bvm();
        }
    }

    public boolean aus() {
        if (this.dmC != null && this.dmB != null) {
            this.dmC.a(this.dmB.azB(), this.dlS);
        }
        boolean z = false;
        if (this.dlS != null) {
            z = this.dlS.bvp();
        }
        auu();
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ks(int i) {
        ao aoVar = null;
        aus();
        auB();
        try {
            if (this.dlS != null) {
                this.dmq.a((ArrayList<com.baidu.adp.widget.ListView.h>) null, this.dlS);
                this.dmC.lL(1);
                this.dmq.avn();
                this.dmD.a(this.dlS, this.dmB.azL());
                com.baidu.tieba.frs.tab.d lR = this.dmD.lR(this.dlS.buu());
                if (lR != null && !TextUtils.isEmpty(lR.url)) {
                    aoVar = new ao();
                    aoVar.dpN = lR.url;
                    aoVar.stType = lR.name;
                }
                this.dmB.a(this.dlS.buu(), 0, aoVar);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(boolean z, boolean z2) {
        try {
            if (this.dlS != null && this.dmD != null && this.dmB != null) {
                if (!this.dmq.avu().k(bb.ahB)) {
                    this.dlS.buX();
                }
                boolean z3 = com.baidu.tbadk.core.util.w.z(this.dlS.buI());
                this.dmq.fD(z3);
                if (!z3) {
                    if (this.dmX == null) {
                        this.dmX = new com.baidu.tieba.frs.vc.e(this, (NoPressedRelativeLayout) this.mRootView);
                    }
                    if (this.bFD == null) {
                        this.bFD = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
                    }
                } else {
                    this.dmX = null;
                    this.bFD = null;
                }
                if (this.dlS.aZl() != null) {
                    this.dmi = this.dlS.aZl().getName();
                    this.forumId = this.dlS.aZl().getId();
                }
                if (this.dlS.bvp()) {
                    this.dmD.a(this.dlS, this.dmB.azL());
                }
                if (z) {
                    u(true, z);
                } else {
                    u(this.dmA, z);
                }
                aus();
                if (this.dmJ != null) {
                    this.dmJ.a(this.dmC, this.dlS);
                }
                if (this.dlS.uw() != null) {
                    setHasMore(this.dlS.uw().us());
                }
                ArrayList<com.baidu.adp.widget.ListView.h> a2 = this.dmN.a(z2, true, this.dlS.getThreadList(), null, z, false);
                if (a2 != null) {
                    this.dlS.ax(a2);
                }
                this.dlS.bvl();
                if (this.dmB.azF() == 1) {
                    auy();
                    if (!z && this.dmB.getPn() == 1) {
                        aut();
                    }
                }
                this.dlV = this.dlS.azH();
                if (this.dmm != null) {
                    this.dml = true;
                    this.dmm.tF(this.dlV);
                    com.baidu.tieba.frs.f.a.a(this, this.dlS.aZl(), this.dlS.getThreadList(), this.dml, getPn());
                }
                if (this.dmL != null) {
                    this.dmL.aC(this.dmD.aAO());
                }
                aup();
                this.dmq.avg();
                this.dmq.w(true, false);
                if (this.dlS.aZl() != null) {
                    this.dmq.mu(this.dlS.aZl().getWarningMsg());
                }
                if (this.dlS != null && this.dlS.buL() != null && com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("frs_video_activity_guide", 0L) == 0) {
                    com.baidu.adp.lib.g.e.in().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.11
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsFragment.this.dmq.avC();
                        }
                    }, 1000L);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2921326, this));
                this.dmq.auZ();
                if (this.dlS != null && this.dlS.aZl() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016564, new VisitedForumData(this.dlS.aZl().getId(), this.dlS.aZl().getName(), this.dlS.aZl().getImage_url(), String.valueOf(System.currentTimeMillis() / 1000), "showlive".equals(this.dlS.aZl().special_forum_type))));
                }
                this.dnd.a(this.dlS.gMk, this.dlS.aZl());
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void aut() {
        if (this.dmQ == null) {
            this.dmQ = new com.baidu.tieba.frs.live.a(this, com.baidu.adp.lib.g.b.g(this.forumId, 0));
        }
        this.dmQ.azn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.i iVar) {
        try {
            if (!this.dmx && iVar != null && this.dlS != null) {
                this.dlS.e(iVar);
                v(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void auu() {
        if (this.dmB != null) {
            ms(this.dmB.azB());
        } else {
            ms("normal_page");
        }
    }

    private void ms(String str) {
        fw("frs_page".equals(str));
        if (this.dmJ != null) {
            this.dmJ.a(this.dmC, this.dmq, this.dlS);
        }
    }

    public void fw(boolean z) {
        if (this.dmO != null) {
            this.dmO.c(this.dmq, z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(d.h.frs_activity, viewGroup, false);
            this.dmc = new com.baidu.tieba.frs.entelechy.b();
            this.dmJ = this.dmc.awC();
            this.dmC = new com.baidu.tieba.frs.vc.f(this, this.dmc, (FrsHeaderViewContainer) this.mRootView.findViewById(d.g.header_view_container));
            this.dmD = new FrsTabViewController(this, this.mRootView);
            this.dmC.a(this.dmD);
            this.dmD.a(this.dnm);
            Intent intent = getActivity().getIntent();
            if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                this.dme = true;
            }
            this.dmq = new k(this, this.dnB, this.dmc, this.dme, this.dmC);
            this.dmq.setHeaderViewHeight(this.dmU);
            this.dnd = new com.baidu.tieba.frs.brand.buttommenu.a(getPageContext(), this.mRootView);
        } else {
            if (this.mRootView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            this.dmD.resetData();
            this.dmq.avB();
        }
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        this.cSN = System.currentTimeMillis();
        this.beginTime = this.cSN;
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.dmn = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.cSN = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            I(intent);
        }
        this.aTL = this.beginTime - this.cSN;
        this.dmm = new com.baidu.tieba.tbadkCore.data.e("frs", com.baidu.tieba.tbadkCore.data.e.gNs);
        this.dmB = new FrsModelController(this, this.dnx);
        this.dmB.a(this.dnl);
        this.dmB.init();
        if (intent != null) {
            this.dmB.i(intent.getExtras());
        } else if (bundle != null) {
            this.dmB.i(bundle);
        } else {
            this.dmB.i(null);
        }
        if (intent != null) {
            this.dmC.m(intent.getExtras());
        } else if (bundle != null) {
            this.dmC.m(bundle);
        } else {
            this.dmC.m((Bundle) null);
        }
        this.dmp = getVoiceManager();
        this.dmR = new j(getPageContext(), this);
        initUI();
        initData(bundle);
        if (this.mFrom != null && this.mFrom.equals("from_tieba_kuang")) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12264").r("obj_type", 1).af(ImageViewerConfig.FORUM_NAME, this.dmB.getForumName()));
            KuangFloatingViewController.getInstance().setNeedShowFloatingView(true);
            if (KuangFloatingViewController.getInstance().init()) {
                ((BaseFragmentActivity) getPageContext().getOrignalPage()).grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.frs.FrsFragment.15
                    @Override // com.baidu.tbadk.core.e
                    public void aj(boolean z) {
                        if (z) {
                            KuangFloatingViewController.getInstance().showFloatingView();
                        }
                    }
                });
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SCHEMA_UPLOAD);
                httpMessage.addParam("call_url", com.baidu.adp.lib.util.k.bh("shoubai://internal?type=frs&param=" + this.dmi));
                MessageManager.getInstance().sendMessage(httpMessage);
            }
        }
        if (!auF()) {
            this.dmH = new an(getActivity(), this.dmq, this.dmC);
            this.dmH.fO(true);
        }
        this.dmp = getVoiceManager();
        if (this.dmp != null) {
            this.dmp.onCreate(getPageContext());
        }
        new com.baidu.tieba.frs.mc.g();
        this.dmN = new com.baidu.tieba.frs.mc.c(this, this.dnz);
        this.dmF = new com.baidu.tieba.frs.smartsort.b(this);
        this.dmO = new com.baidu.tieba.frs.vc.h(this);
        this.dmL = new com.baidu.tieba.frs.vc.a(getPageContext(), this.dmB.azM());
        this.dmG = new com.baidu.tieba.frs.mc.b(this);
        this.dmM = new com.baidu.tieba.frs.mc.d(this);
        this.dmE = new com.baidu.tieba.frs.mc.f(this);
        this.dmP = new com.baidu.tieba.frs.mc.a(this);
        this.dmS = new com.baidu.tieba.frs.vc.c(this);
        this.dmT = new com.baidu.tieba.frs.mc.e(this, getUniqueId());
        this.dna = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "frs");
        this.dnb = new com.baidu.tieba.ala.a(getPageContext());
        registerListener(this.bCp);
        registerListener(this.mMemListener);
        registerListener(this.dns);
        registerListener(this.dnA);
        registerListener(this.dnr);
        registerListener(this.dny);
        registerListener(this.dno);
        registerListener(this.dnp);
        registerListener(this.dnq);
        registerListener(this.dni);
        registerListener(this.dnj);
        registerListener(this.dnF);
        registerListener(this.dnv);
        registerListener(this.dnk);
        registerListener(this.dnw);
        registerListener(this.dnu);
        this.dnh.setTag(getPageContext().getUniqueId());
        registerListener(this.dnh);
        this.dmq.fF(false);
        if (!auF()) {
            showLoadingView(this.dmq.aed(), true);
            this.dmB.q(3, false);
        }
        com.baidu.tieba.frs.a.atD().a(new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.16
            @Override // com.baidu.tieba.frs.a.b
            public void t(boolean z, boolean z2) {
                if (FrsFragment.this.dmq != null) {
                    FrsFragment.this.dmq.kz(z ? 0 : 8);
                    if (!z2) {
                        FrsFragment.this.dnf = z;
                    }
                    if (FrsFragment.this.dmq.avu() != null && FrsFragment.this.dmB != null && FrsFragment.this.dmB.azG()) {
                        FrsFragment.this.dmq.avu().notifyDataSetChanged();
                    }
                    if (FrsFragment.this.dmq.ave() != null) {
                        FrsFragment.this.dmq.fC(!z);
                    }
                    if (FrsFragment.this.getActivity() instanceof FrsActivity) {
                        ((FrsActivity) FrsFragment.this.getActivity()).fv(!z);
                    }
                    if (FrsFragment.this.dnd != null) {
                        FrsFragment.this.dnd.fX(!z);
                    }
                    FrsFragment.this.dmq.fH(!z);
                    FrsFragment.this.dmq.fI(z ? false : true);
                }
            }

            @Override // com.baidu.tieba.frs.a.b
            public void ko(int i) {
                if (FrsFragment.this.dmq != null) {
                    FrsFragment.this.dmq.kA(i);
                }
            }

            @Override // com.baidu.tieba.frs.a.b
            public void atI() {
                com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getContext(), d.j.frs_multi_delete_max_num);
            }
        });
        this.dmq.b(new d.a() { // from class: com.baidu.tieba.frs.FrsFragment.17
            @Override // com.baidu.tieba.NEGFeedBack.d.a
            public void a(DeleteThreadHttpResponseMessage deleteThreadHttpResponseMessage) {
                if (deleteThreadHttpResponseMessage != null) {
                    FrsFragment.this.dmq.Pv();
                    FrsFragment.this.dmq.avD();
                    if (deleteThreadHttpResponseMessage.getError() == 0) {
                        if (deleteThreadHttpResponseMessage.getRetType() != 1211066) {
                            FrsFragment.this.dmq.S(deleteThreadHttpResponseMessage.getText(), ContextCompat.getColor(FrsFragment.this.getContext(), deleteThreadHttpResponseMessage.getRetType() == 1 ? d.C0140d.nav_bar_tip_error : d.C0140d.cp_link_tip_a_alpha95));
                        } else {
                            String text = !TextUtils.isEmpty(deleteThreadHttpResponseMessage.getText()) ? deleteThreadHttpResponseMessage.getText() : FrsFragment.this.getString(d.j.delete_fail);
                            if (FrsFragment.this.cBf == null) {
                                FrsFragment.this.cBf = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                                FrsFragment.this.cBf.dB(text);
                                FrsFragment.this.cBf.a(d.j.dialog_known, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.17.1
                                    @Override // com.baidu.tbadk.core.dialog.a.b
                                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                        if (aVar != null) {
                                            aVar.dismiss();
                                        }
                                    }
                                });
                                FrsFragment.this.cBf.au(true);
                                FrsFragment.this.cBf.b(FrsFragment.this.getPageContext());
                            }
                            FrsFragment.this.cBf.xf();
                        }
                        FrsFragment.this.bl(deleteThreadHttpResponseMessage.getSuccessItems());
                        com.baidu.tieba.frs.a.atD().bk(deleteThreadHttpResponseMessage.getSuccessItems());
                        int i = 0;
                        Iterator<com.baidu.adp.widget.ListView.h> it = FrsFragment.this.dlS.getThreadList().iterator();
                        while (true) {
                            int i2 = i;
                            if (!it.hasNext()) {
                                i = i2;
                                break;
                            }
                            i = it.next() instanceof bb ? i2 + 1 : i2;
                            if (i >= 6) {
                                break;
                            }
                        }
                        if (i < 6) {
                            FrsFragment.this.Tn();
                            return;
                        }
                        return;
                    }
                    com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getActivity(), deleteThreadHttpResponseMessage.getErrorString());
                }
            }
        });
        super.onActivityCreated(bundle);
        this.createTime = System.currentTimeMillis() - this.beginTime;
    }

    public void fx(boolean z) {
        if (this.dmD != null) {
            this.dmD.dHl = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bl(List<String> list) {
        if (!com.baidu.tbadk.core.util.w.z(list)) {
            ArrayList<com.baidu.adp.widget.ListView.h> threadList = this.dlS.getThreadList();
            if (!com.baidu.tbadk.core.util.w.z(threadList) && this.dmq.getListView() != null && this.dmq.getListView().getData() != null) {
                Iterator<com.baidu.adp.widget.ListView.h> it = threadList.iterator();
                List<com.baidu.adp.widget.ListView.h> data = this.dmq.getListView().getData();
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.h next = it.next();
                    if (next instanceof bb) {
                        bb bbVar = (bb) next;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= list.size()) {
                                break;
                            } else if (!com.baidu.tbadk.core.util.ap.equals(list.get(i2), bbVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(bbVar);
                                this.dmN.aa(bbVar);
                                this.dmq.getListView().getAdapter().notifyItemRemoved(i);
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
    public void TN() {
        if (isAdded() && this.byX && !isLoadingViewAttached()) {
            showLoadingView(this.dmq.aed(), true);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void TO() {
        if (isAdded() && this.byX && isLoadingViewAttached()) {
            hideLoadingView(this.dmq.aed());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (auF()) {
            showLoadingView(this.dmq.aed(), true);
            this.dmq.kB(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.dmB.q(3, true);
            AS().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void setHeaderViewHeight(int i) {
        this.dmU = i;
        if (this.dmq != null) {
            this.dmq.setHeaderViewHeight(this.dmU);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.s sVar) {
        if (sVar != null) {
            this.aWE = sVar.Lu();
            this.dmV = sVar.Lv();
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void showFloatingView() {
        if (this.aWE != null) {
            this.aWE.ce(true);
        }
    }

    private void I(Intent intent) {
        if (intent != null) {
            if (!com.baidu.tieba.frs.f.f.a(this, getForumName(), "from", intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false)) && getActivity() != null) {
                getActivity().finish();
                return;
            }
        }
        if (intent != null && intent.getData() != null) {
            Uri data = intent.getData();
            this.dmi = data.getQueryParameter("name");
            this.mFrom = data.getQueryParameter("from");
            if (!StringUtils.isNull(this.dmi)) {
                intent.putExtra("name", this.dmi);
            }
            if (!StringUtils.isNull(this.mFrom)) {
                intent.putExtra("from", this.mFrom);
            }
            TiebaStatic.log("c10105");
        }
        if (StringUtils.isNull(this.dmi)) {
            com.baidu.tieba.frs.f.d K = com.baidu.tieba.frs.f.i.K(intent);
            if (K != null) {
                this.dmi = K.forumName;
                if (K.dFI != null && K.dFI.equals("aidou")) {
                    com.baidu.tbadk.core.dialog.h.aly = System.currentTimeMillis();
                }
            }
            if (!StringUtils.isNull(this.dmi)) {
                intent.putExtra("name", this.dmi);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.dmp = getVoiceManager();
        if (this.dmp != null) {
            this.dmp.onStart(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        Intent intent;
        registerListener(2001118, this.aDX);
        if (bundle != null) {
            this.dmi = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
            this.dmi = intent.getStringExtra("name");
            this.mFrom = intent.getStringExtra("from");
            this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
        }
        if (getArguments() != null) {
            this.dmj = getArguments().getBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, false);
        }
        if (TextUtils.isEmpty(this.mFrom) || FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
        }
        if (this.mIsLogin) {
            registerListener(2001120, this.aDX);
        }
        this.dmC.m(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dnF);
        if (this.dmp != null) {
            this.dmp.onDestory(getPageContext());
        }
        com.baidu.tieba.recapp.report.a.remove("FRS");
        this.dmp = null;
        com.baidu.tieba.card.v.aiY().ey(false);
        if (this.dlS != null && this.dlS.aZl() != null) {
            ac.avK().bH(com.baidu.adp.lib.g.b.c(this.dlS.aZl().getId(), 0L));
        }
        if (this.dmQ != null) {
            this.dmQ.onDestory();
        }
        if (this.dmq != null) {
            com.baidu.tieba.frs.f.h.a(this.dmq, this.dlS, getForumId(), false, null);
            this.dmq.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.dmz != null) {
                this.dmz.Kx();
            }
            this.dmq.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.dmB.onActivityDestroy();
        this.dmC.onActivityDestroy();
        if (this.dmB != null) {
            this.dmB.Vx();
        }
        if (this.dmH != null) {
            this.dmH.Lt();
        }
        if (this.dmK != null) {
            this.dmK.destory();
        }
        if (this.dmL != null) {
            this.dmL.destory();
        }
        if (this.dmF != null) {
            this.dmF.onDestroy();
        }
        if (this.dmX != null) {
            this.dmX.onDestory();
        }
        if (this.dmP != null) {
            this.dmP.onDestroy();
        }
        if (this.dna != null) {
            this.dna.onDestroy();
        }
        if (this.dnb != null) {
            this.dnb.onDestroy();
        }
        com.baidu.tieba.recapp.d.a.bod().bof();
        com.baidu.tieba.frs.f.j.aAk();
        if (this.dmD != null) {
            this.dmD.a((FrsTabViewController.a) null);
            this.dmD.aAR();
        }
        if (this.dnc != null) {
            this.dnc.onDestroy();
        }
        if (this.dne != null) {
            this.dne.onDestroy();
        }
        com.baidu.tieba.frs.a.atD().a(null);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.dmi);
        bundle.putString("from", this.mFrom);
        this.dmB.onSaveInstanceState(bundle);
        if (this.dmp != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            this.dmp.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.dmP != null) {
            this.dmP.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dmq != null) {
            this.dmq.avk();
            this.dmq.onResume();
        }
        this.dmE.gm(true);
        this.dmA = true;
        if (dmh) {
            dmh = false;
            this.dmq.startPullRefresh();
            return;
        }
        if (this.dmp != null) {
            this.dmp.onResume(getPageContext());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921338));
        this.dmq.fJ(false);
        if (this.dmY) {
            refresh(6);
            this.dmY = false;
        }
        if (KuangFloatingViewController.getInstance().init()) {
            ((BaseFragmentActivity) getPageContext().getOrignalPage()).grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.frs.FrsFragment.21
                @Override // com.baidu.tbadk.core.e
                public void aj(boolean z) {
                    if (z) {
                        KuangFloatingViewController.getInstance().showFloatingView();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
    }

    public boolean auv() {
        Intent intent;
        if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
            return false;
        }
        return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
    }

    public void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.dmi = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.dmk = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.dmk) {
                auw();
            }
            if (this.mFrom != null && this.mFrom.equals("from_tieba_kuang")) {
                KuangFloatingViewController.getInstance().setNeedShowFloatingView(true);
                if (KuangFloatingViewController.getInstance().init()) {
                    ((BaseFragmentActivity) getPageContext().getOrignalPage()).grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.frs.FrsFragment.22
                        @Override // com.baidu.tbadk.core.e
                        public void aj(boolean z) {
                            if (z) {
                                KuangFloatingViewController.getInstance().showFloatingView();
                            }
                        }
                    });
                }
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SCHEMA_UPLOAD);
                httpMessage.addParam("call_url", com.baidu.adp.lib.util.k.bh("shoubai://internal?type=frs&param=" + this.dmi));
                MessageManager.getInstance().sendMessage(httpMessage);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auw() {
        this.dmq.startPullRefresh();
    }

    public void closeActivity() {
        com.baidu.tieba.frs.f.i.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.mFrom);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.dmq.setTitle(this.dmi);
        } else {
            this.dmq.setTitle("");
            this.mFlag = 1;
        }
        this.dmq.setOnAdapterItemClickListener(this.dnD);
        this.dmq.addOnScrollListener(this.mScrollListener);
        this.dmq.h(this.dkf);
        this.dmq.avu().a(this.dnC);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dmq.onChangeSkinType(i);
        this.dmC.lK(i);
        this.dmD.onChangeSkinType(i);
        if (this.dmW != null) {
            this.dmW.onChangeSkinType();
        }
        if (this.dnc != null) {
            this.dnc.onChangeSkinType(i);
        }
        if (this.dnd != null) {
            this.dnd.d(getPageContext(), i);
        }
        if (this.cBf != null) {
            com.baidu.tbadk.o.a.a(getPageContext(), this.cBf.xg());
        }
    }

    public void kt(int i) {
        if (!this.mIsLogin) {
            if (this.dlS != null && this.dlS.uh() != null) {
                this.dlS.uh().setIfpost(1);
            }
            if (i == 0) {
                ba.aU(getActivity());
            }
        } else if (this.dlS != null) {
            if (i == 0) {
                com.baidu.tieba.frs.f.j.d(this, 0);
            } else {
                this.dmq.avm();
            }
        }
    }

    public void refresh() {
        com.baidu.tieba.a.d.QI().iz("page_frs");
        refresh(3);
    }

    public void refresh(int i) {
        this.dmx = false;
        auB();
        if (this.dmq.avc() != null) {
            this.dmq.avc().aFD();
        }
        this.dmB.q(i, true);
    }

    private void aux() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.g.h.io().d(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.24
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.tS(FrsFragment.this.dmi);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auy() {
        auB();
        try {
            if (this.dlS != null) {
                this.dmq.agN();
                this.dmq.fC(auK());
                if (!com.baidu.tieba.frs.vc.f.k(this.dlS) || !com.baidu.tieba.frs.vc.f.j(this.dlS)) {
                }
                if (this.dlS.aZl() != null) {
                    this.dmi = this.dlS.aZl().getName();
                    this.forumId = this.dlS.aZl().getId();
                }
                if (this.dlS.uw() != null) {
                    setHasMore(this.dlS.uw().us());
                }
                this.dmq.setTitle(this.dmi);
                this.dmq.setForumName(this.dmi);
                TbadkCoreApplication.getInst().setDefaultBubble(this.dlS.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.dlS.getUserData().getBimg_end_time());
                aux();
                auz();
                ArrayList<com.baidu.adp.widget.ListView.h> threadList = this.dlS.getThreadList();
                if (threadList != null) {
                    this.dmq.a(threadList, this.dlS);
                    com.baidu.tieba.frs.f.c.w(this.dmq);
                    this.dmC.lL(getPageNum());
                    this.dmC.h(this.dlS);
                    this.dmD.a(this.dlS, this.dmB.azL());
                    this.dmq.avn();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void auz() {
        if (this.dlS != null) {
            if (this.dlS.aZA() == 1) {
                this.dmq.avu().setFromCDN(true);
            } else {
                this.dmq.avu().setFromCDN(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.dmE.gm(false);
        this.dmA = false;
        this.dmq.onPause();
        if (this.dmp != null) {
            this.dmp.onPause(getPageContext());
        }
        this.dmq.fJ(true);
        if (this.dmL != null) {
            this.dmL.aAn();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.dmD != null && this.dmD.aAP() != null && (this.dmD.aAP().fragment instanceof BaseFragment)) {
            ((BaseFragment) this.dmD.aAP().fragment).setPrimary(z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.v.aiY().ey(false);
        if (this.dlS != null && this.dlS.aZl() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            com.baidu.tbadk.distribute.a.Hf().a(getPageContext().getPageActivity(), "frs", this.dlS.aZl().getId(), 0L);
        }
        if (this.dmp != null) {
            this.dmp.onStop(getPageContext());
        }
        if (AS() != null) {
            AS().getRecycledViewPool().clear();
        }
        this.dmC.onActivityStop();
        com.baidu.tbadk.util.t.Lx();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            if (this.dmC != null) {
                this.dmC.fA(isPrimary());
            }
            if (this.dmq != null) {
                this.dmq.fA(isPrimary());
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (com.baidu.tieba.frs.a.atD().atE()) {
                com.baidu.tieba.frs.a.atD().reset();
                return true;
            } else if (this.dmq != null) {
                return this.dmq.avj();
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.n
    public TbPageContext<?> aiy() {
        return getPageContext();
    }

    @Override // com.baidu.tieba.recapp.n
    public void a(AdvertAppInfo advertAppInfo, String str) {
        com.baidu.tbadk.distribute.a.Hf().a(advertAppInfo, this.forumId, 0L, "FRS", str, getPn());
    }

    @Override // com.baidu.tieba.recapp.n
    public void auA() {
        auh().auA();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dmp == null) {
            this.dmp = VoiceManager.instance();
        }
        return this.dmp;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdRecyclerView AS() {
        if (this.dmq == null) {
            return null;
        }
        return this.dmq.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void auB() {
        if (this.dmp != null) {
            this.dmp.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> AT() {
        if (this.ayS == null) {
            this.ayS = UserIconBox.i(getPageContext().getPageActivity(), 8);
        }
        return this.ayS;
    }

    public void auC() {
        if (getFragmentActivity() != null && getFragmentActivity().getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.a(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.k onGetPreLoadListView() {
        return AS().getPreLoadHandle();
    }

    @Override // com.baidu.tieba.frs.ak
    public NavigationBar Vf() {
        if (this.dmq == null) {
            return null;
        }
        return this.dmq.Vf();
    }

    @Override // com.baidu.tbadk.core.view.NavigationBar.a
    public void b(Pair<Integer, Integer> pair) {
        this.dmv = pair;
    }

    /* loaded from: classes2.dex */
    private final class a implements com.baidu.adp.widget.ListView.n {
        private a() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v13, resolved type: com.baidu.tieba.frs.FrsFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.n
        public void a(View view, com.baidu.adp.widget.ListView.h hVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null) {
                if (bdUniqueId == p.dpa) {
                    if (FrsFragment.this.dmq != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11752").af(ImageViewerConfig.FORUM_ID, FrsFragment.this.forumId).af("obj_locate", "1"));
                        FrsFragment.this.dmq.startPullRefresh();
                    }
                } else if (hVar != null && (hVar instanceof bb)) {
                    bb bbVar = (bb) hVar;
                    if (bbVar.vU() == null || bbVar.vU().getGroup_id() == 0 || ba.aV(FrsFragment.this.getActivity())) {
                        if (bbVar.vN() != 1 || ba.aV(FrsFragment.this.getActivity())) {
                            if (bbVar.vy() != null) {
                                if (ba.aV(FrsFragment.this.getActivity())) {
                                    String postUrl = bbVar.vy().getPostUrl();
                                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.jV()) {
                                        com.baidu.tbadk.browser.a.S(FrsFragment.this.getActivity(), postUrl);
                                    }
                                }
                            } else if (bbVar.wd() != null) {
                                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                    ba.aU(FrsFragment.this.getPageContext().getPageActivity());
                                    return;
                                }
                                com.baidu.tbadk.core.data.m wd = bbVar.wd();
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), wd.getCartoonId(), wd.getChapterId(), 2)));
                            } else {
                                com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                                if (readThreadHistory != null && !readThreadHistory.tY(bbVar.getId())) {
                                    readThreadHistory.tX(bbVar.getId());
                                }
                                boolean z = false;
                                final String vs = bbVar.vs();
                                if (vs != null && !vs.equals("")) {
                                    z = true;
                                    new Thread(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.a.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            com.baidu.tbadk.core.util.y yVar = new com.baidu.tbadk.core.util.y(vs);
                                            yVar.yO().zM().mIsNeedAddCommenParam = false;
                                            yVar.yO().zM().mIsUseCurrentBDUSS = false;
                                            yVar.yr();
                                        }
                                    }).start();
                                }
                                String tid = bbVar.getTid();
                                if (tid == null) {
                                    tid = "";
                                }
                                if (bbVar.vf() == 2 && !tid.startsWith("pb:")) {
                                    ay.zK().c(FrsFragment.this.getPageContext(), new String[]{tid, "", null});
                                    return;
                                }
                                if (tid.startsWith("pb:")) {
                                    bbVar.setId(tid.substring(3));
                                }
                                if (bdUniqueId.getId() == bb.aiT.getId()) {
                                    com.baidu.tieba.frs.f.h.a(bbVar.uR());
                                } else if (bdUniqueId.getId() == bb.ahE.getId()) {
                                    com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c12940");
                                    anVar.af("obj_type", "2");
                                    anVar.af("tid", bbVar.getTid());
                                    TiebaStatic.log(anVar);
                                }
                                com.baidu.tieba.frs.f.i.a(FrsFragment.this, bbVar, i, z);
                                com.baidu.tieba.frs.f.h.a(FrsFragment.this, FrsFragment.this.dlS, bbVar);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.l.jV()) {
            hideNetRefreshView(this.dmq.aed());
            showLoadingView(this.dmq.aed(), true);
            this.dmq.fF(false);
            this.dmB.q(3, true);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public com.baidu.tieba.tbadkCore.l auD() {
        return this.dlS;
    }

    public boolean auE() {
        return this.dmq.auE();
    }

    public void W(Object obj) {
        if (this.dmG != null && this.dmG.dDt != null) {
            this.dmG.dDt.i(obj);
        }
    }

    public void X(Object obj) {
        if (this.dmG != null && this.dmG.dDu != null) {
            this.dmG.dDu.i(obj);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        this.dmq.getListView().stopScroll();
        if (!this.dmq.avq()) {
            if (!com.baidu.adp.lib.util.l.jV()) {
                this.dmq.Un();
            } else if (this.dmB.azF() == 1) {
                TB();
                Tn();
            } else if (this.dmB.hasMore()) {
                Tn();
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void mb(String str) {
        TB();
        showToast(str);
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void O(ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        boolean z = com.baidu.tbadk.core.util.w.z(arrayList);
        setHasMore(z ? 0 : 1);
        TB();
        if (!z) {
            if (!this.dmB.azP() && TbadkCoreApplication.getInst().isRecAppExist() && this.dmB.azF() == 1) {
                this.dlS.a(this, arrayList);
            }
            ArrayList<com.baidu.adp.widget.ListView.h> a2 = this.dmN.a(false, false, arrayList, this.dmm, false);
            if (a2 != null) {
                this.dlS.ax(a2);
                this.dmq.a(a2, this.dlS);
            }
            if (this.dmB != null) {
                com.baidu.tieba.frs.e.b.a(this.dlS, this.dmB.azL(), 2);
            }
        }
    }

    private void TB() {
        if (aun() == 1 || this.dmN.bx(this.dlS.buk())) {
            if (com.baidu.tbadk.core.util.w.y(this.dlS.getThreadList()) > 3) {
                this.dmq.Ul();
            } else {
                this.dmq.avx();
            }
        } else if (com.baidu.tbadk.core.util.w.z(this.dlS.getThreadList())) {
            this.dmq.Un();
        } else {
            this.dmq.Um();
        }
    }

    @Override // com.baidu.tieba.frs.mc.j
    public void Tn() {
        if (this.dmN != null) {
            this.dmN.a(this.dmi, this.forumId, this.dlS);
        }
    }

    public void takePhoto() {
        if (!com.baidu.tbadk.core.util.ac.e(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.al.b(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        if (this.dmw) {
            return null;
        }
        if (auF()) {
            return "a034";
        }
        return "a006";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (!auF()) {
            return super.getCurrentPageSourceKeyList();
        }
        if (super.getCurrentPageSourceKeyList() != null) {
            arrayList = new ArrayList(super.getCurrentPageSourceKeyList());
        } else {
            arrayList = new ArrayList();
        }
        if (!"a001".equals(com.baidu.tbadk.core.util.w.d(arrayList, arrayList.size() - 1))) {
            arrayList.add("a001");
            return arrayList;
        }
        return arrayList;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(getForumId(), 0L));
        }
        return pageStayDurationItem;
    }

    @Override // android.support.v4.app.Fragment
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        com.baidu.tieba.frs.f.i.a(this, i, strArr, iArr);
    }

    public void fy(boolean z) {
        if (this.dmH != null) {
            this.dmH.fO(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.dmI.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a gi(int i) {
        return this.dmI.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        this.dmR.b(bVar);
    }

    public boolean auF() {
        return this.dme;
    }

    @Override // com.baidu.tieba.frs.ah
    public void TM() {
        if (this.dmq != null) {
            showFloatingView();
            this.dmq.getListView().scrollToPosition(0);
            this.dmq.startPullRefresh();
        }
    }

    public ForumWriteData auG() {
        if (this.dlS == null || this.dlS.aZl() == null) {
            return null;
        }
        ForumData aZl = this.dlS.aZl();
        ForumWriteData forumWriteData = new ForumWriteData(aZl.getId(), aZl.getName(), aZl.getPrefixData(), this.dlS.uh());
        forumWriteData.avatar = aZl.getImage_url();
        forumWriteData.forumLevel = aZl.getUser_level();
        forumWriteData.specialForumType = aZl.special_forum_type;
        forumWriteData.firstDir = aZl.getFirst_class();
        forumWriteData.secondDir = aZl.getSecond_class();
        UserData userData = this.dlS.getUserData();
        forumWriteData.privateThread = userData != null ? userData.getPrivateThread() : 0;
        return forumWriteData;
    }

    @Override // com.baidu.tieba.frs.ah
    public void AG() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.frs.ah
    public void setVideoThreadId(String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z) {
        super.showLoadingView(view, z);
        this.dmq.ky(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        super.hideLoadingView(view);
        this.dmq.ky(0);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        super.showNetRefreshView(view, str, z);
        this.dmq.ky(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshViewNoClick(View view, String str, boolean z) {
        super.showNetRefreshViewNoClick(view, str, z);
        this.dmq.ky(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        super.hideNetRefreshView(view);
        this.dmq.ky(0);
    }

    public void auH() {
        FrsTabViewController.b aAP;
        if (this.dmD != null && (aAP = this.dmD.aAP()) != null && aAP.fragment != null && (aAP.fragment instanceof aj)) {
            ((aj) aAP.fragment).atY();
        }
    }

    public void a(ContriInfo contriInfo) {
        if (this.dnc == null) {
            this.dnc = new com.baidu.tbadk.core.dialog.h(aiy());
            this.dnc.a(new h.a() { // from class: com.baidu.tieba.frs.FrsFragment.32
                @Override // com.baidu.tbadk.core.dialog.h.a
                public void aC(boolean z) {
                    if (z) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13061"));
                    }
                }
            });
        }
        this.dnc.a(contriInfo, -1L);
    }

    public void fz(boolean z) {
        this.dmg = z;
    }

    public boolean auI() {
        return this.dmg;
    }

    public void mt(String str) {
        if (TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.util.ap.isEmpty(str)) {
            if (this.dne == null) {
                this.dne = new AddExperiencedModel(aiy());
                this.dne.a(this.dng);
            }
            this.dne.ce(this.forumId, str);
        }
    }

    public com.baidu.tieba.frs.entelechy.b auJ() {
        return this.dmc;
    }

    public boolean auK() {
        return (this.dmB != null && this.dmB.azG() && com.baidu.tieba.frs.a.atD().atE()) ? false : true;
    }
}
