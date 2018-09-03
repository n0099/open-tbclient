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
import com.baidu.tbadk.core.util.az;
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
import com.baidu.tieba.f;
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
    public static boolean dmf = false;
    public static volatile long dmq = 0;
    public static volatile long dmr = 0;
    public static volatile int dms = 0;
    private com.baidu.tbadk.util.r aWE;
    private com.baidu.adp.lib.e.b<TbImageView> ayP;
    private com.baidu.tieba.frs.gametab.b bFD;
    private com.baidu.tbadk.core.dialog.a cBc;
    private com.baidu.tieba.frs.vc.f dmA;
    private FrsTabViewController dmB;
    private com.baidu.tieba.frs.mc.f dmC;
    private com.baidu.tieba.frs.smartsort.b dmD;
    private com.baidu.tieba.frs.mc.b dmE;
    private an dmF;
    private com.baidu.tieba.frs.entelechy.b.b dmH;
    private com.baidu.tbadk.i.a dmI;
    private com.baidu.tieba.frs.vc.a dmJ;
    private com.baidu.tieba.frs.mc.d dmK;
    private com.baidu.tieba.frs.mc.c dmL;
    private com.baidu.tieba.frs.vc.h dmM;
    private com.baidu.tieba.frs.mc.a dmN;
    private com.baidu.tieba.frs.live.a dmO;
    private j dmP;
    public com.baidu.tieba.frs.vc.c dmQ;
    private com.baidu.tieba.frs.mc.e dmR;
    private int dmS;
    private View.OnTouchListener dmT;
    private com.baidu.tieba.frs.view.a dmU;
    private com.baidu.tieba.frs.vc.e dmV;
    private boolean dmW;
    private com.baidu.tieba.NEGFeedBack.a dmY;
    private com.baidu.tieba.ala.a dmZ;
    private com.baidu.tieba.frs.entelechy.b dma;
    private com.baidu.tieba.tbadkCore.data.e dmk;
    private VoiceManager dmn;
    private FrsModelController dmz;
    private com.baidu.tbadk.core.dialog.h dna;
    private com.baidu.tieba.frs.brand.buttommenu.a dnb;
    private AddExperiencedModel dnc;
    private int dnl;
    public View mRootView;
    public boolean dmb = false;
    private boolean dmc = false;
    private boolean dmd = false;
    private boolean dme = true;
    public String dmg = null;
    public String mFrom = null;
    public int mFlag = 0;
    public boolean dmh = false;
    private boolean dmi = false;
    private String mThreadId = null;
    public String forumId = null;
    private int dlT = 0;
    private boolean dmj = false;
    private boolean dml = false;
    private boolean dmm = false;
    private k dmo = null;
    public final bb buy = null;
    private com.baidu.tieba.tbadkCore.l dlQ = new com.baidu.tieba.tbadkCore.l();
    public long cSK = -1;
    public long aTT = 0;
    public long aTL = 0;
    public long createTime = 0;
    public long beginTime = -1;
    public long dmp = 0;
    public Pair<Integer, Integer> dmt = null;
    public boolean dmu = false;
    private boolean dmv = false;
    private boolean dmw = false;
    public com.baidu.tbadk.l.b dmx = null;
    private boolean dmy = true;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> dmG = new SparseArray<>();
    private boolean byZ = true;
    private boolean dmX = false;
    private boolean dnd = false;
    private AddExperiencedModel.a dne = new AddExperiencedModel.a() { // from class: com.baidu.tieba.frs.FrsFragment.1
        @Override // com.baidu.tieba.share.AddExperiencedModel.a
        public void b(ContriInfo contriInfo) {
            if (contriInfo != null && contriInfo.isShowToast()) {
                FrsFragment.this.a(contriInfo);
            }
        }
    };
    private HttpMessageListener dnf = new HttpMessageListener(CmdConfigHttp.CMD_PB_FLOOR_AGREE, true) { // from class: com.baidu.tieba.frs.FrsFragment.12
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
    private final CustomMessageListener dng = new CustomMessageListener(2016495) { // from class: com.baidu.tieba.frs.FrsFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof bb) {
                    com.baidu.tieba.frs.f.h.a(FrsFragment.this.dmo, FrsFragment.this.dlQ, FrsFragment.this.getForumId(), true, (bb) data);
                }
            }
        }
    };
    private CustomMessageListener dnh = new CustomMessageListener(2921005) { // from class: com.baidu.tieba.frs.FrsFragment.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.dlQ != null) {
                FrsFragment.this.dlQ.bvi();
                if (FrsFragment.this.dmo != null) {
                    FrsFragment.this.dmo.akf();
                }
            }
        }
    };
    private CustomMessageListener dni = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.FrsFragment.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 1) {
                    FrsFragment.this.auv();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                }
            }
        }
    };
    private final al dnj = new al() { // from class: com.baidu.tieba.frs.FrsFragment.35
        @Override // com.baidu.tieba.frs.al
        public void a(int i, int i2, ar arVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
            FrsFragment.this.auo();
            if (FrsFragment.this.dmH != null) {
                FrsFragment.this.dmA.go(FrsFragment.this.dmH.kQ(i));
            }
            d.a aVar = new d.a();
            if (arVar != null) {
                aVar.isSuccess = arVar.errCode == 0;
                aVar.errorCode = arVar.errCode;
                aVar.errorMsg = arVar.errMsg;
                if (aVar.isSuccess) {
                    if (com.baidu.tbadk.core.util.w.z(arrayList)) {
                        FrsFragment.this.dmo.Uq();
                    } else if (arVar.hasMore) {
                        if (com.baidu.tbadk.core.util.w.y(FrsFragment.this.dlQ.getThreadList()) > 3) {
                            FrsFragment.this.dmo.Uo();
                        } else {
                            FrsFragment.this.dmo.avw();
                        }
                    } else if (arVar.dpO) {
                        FrsFragment.this.dmo.Up();
                    } else {
                        FrsFragment.this.dmo.Uq();
                    }
                }
            } else {
                arVar = new ar();
                arVar.pn = 1;
                arVar.hasMore = false;
                arVar.dpO = false;
            }
            if (i == 1) {
                FrsFragment.this.dmy = true;
                FrsFragment.this.dnv.a(FrsFragment.this.dmz.getType(), false, aVar);
            } else {
                FrsFragment.this.a(aVar);
                if (FrsFragment.this.dmz.azd() != null) {
                    FrsFragment.this.dlQ = FrsFragment.this.dmz.azd();
                }
                FrsFragment.this.aux();
            }
            if (FrsFragment.this.dnC != null) {
                FrsFragment.this.dnC.a(i, i2, arVar, arrayList);
            }
        }
    };
    private FrsTabViewController.a dnk = new FrsTabViewController.a() { // from class: com.baidu.tieba.frs.FrsFragment.36
        @Override // com.baidu.tieba.frs.vc.FrsTabViewController.a
        public void eY(int i) {
            boolean z = false;
            if (i != 1) {
                com.baidu.tieba.card.v.ajb().ey(false);
            }
            if (i == 303 && i != FrsFragment.this.dnl) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13121").ae(ImageViewerConfig.FORUM_ID, FrsFragment.this.forumId).ae("uid", TbadkCoreApplication.getCurrentAccount()));
            }
            FrsFragment.this.dnl = i;
            FrsFragment.this.auA();
            com.baidu.tieba.frs.e.c.dtV.dED = i;
            com.baidu.tieba.frs.e.c.dtV.dEE = -1;
            com.baidu.tieba.frs.a atC = com.baidu.tieba.frs.a.atC();
            if (i == 1 && FrsFragment.this.dnd) {
                z = true;
            }
            atC.s(z, true);
        }
    };
    private CustomMessageListener dnm = new CustomMessageListener(2001606) { // from class: com.baidu.tieba.frs.FrsFragment.37
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                FrsFragment.this.dmB.lS(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    };
    private CustomMessageListener dnn = new CustomMessageListener(2001607) { // from class: com.baidu.tieba.frs.FrsFragment.38
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && ((Integer) customResponsedMessage.getData()).intValue() == 51 && FrsFragment.this.dlQ != null) {
                com.baidu.tieba.frs.f.j.a(FrsFragment.this.dlQ, FrsFragment.this.getPageContext());
            }
        }
    };
    private final CustomMessageListener dno = new CustomMessageListener(2003019) { // from class: com.baidu.tieba.frs.FrsFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                FrsFragment.this.dmB.lQ(49);
            }
        }
    };
    private final CustomMessageListener dnp = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.frs.FrsFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && FrsFragment.this.dlQ != null && FrsFragment.this.dlQ.aZg() != null) {
                SignData signData = (SignData) customResponsedMessage.getData();
                int user_level = FrsFragment.this.dlQ.aZg().getUser_level();
                if (signData.forumId != null && signData.forumId.equals(FrsFragment.this.dlQ.aZg().getId())) {
                    FrsFragment.this.dlQ.d(signData);
                    FrsFragment.this.dmA.i(FrsFragment.this.dlQ);
                    if (FrsFragment.this.dmA.aAF()) {
                        i = FrsFragment.this.dlQ.aZg().getUser_level();
                        if (user_level >= i) {
                            i++;
                        }
                    } else {
                        i = user_level;
                    }
                    TbadkCoreApplication.getInst().addSignedForum(FrsFragment.this.dlQ.aZg().getName(), signData.sign_bonus_point, i);
                }
            }
        }
    };
    private final CustomMessageListener dnq = new CustomMessageListener(2001352) { // from class: com.baidu.tieba.frs.FrsFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.r) && FrsFragment.this.dlQ != null) {
                FrsFragment.this.dlQ.c((com.baidu.tieba.tbadkCore.r) customResponsedMessage.getData());
                FrsFragment.this.dmA.h(FrsFragment.this.dlQ);
                FrsFragment.this.dmB.a(FrsFragment.this.dlQ, FrsFragment.this.dmz.azI());
            }
        }
    };
    private final AntiHelper.a dnr = new AntiHelper.a() { // from class: com.baidu.tieba.frs.FrsFragment.5
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12536").r("obj_locate", at.a.arr));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12535").r("obj_locate", at.a.arr));
        }
    };
    private CustomMessageListener bCr = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.frs.FrsFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(FrsFragment.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().aDt != null) {
                        if (AntiHelper.a(FrsFragment.this.getActivity(), updateAttentionMessage.getData().aDt, FrsFragment.this.dnr) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12534").r("obj_locate", at.a.arr));
                        }
                    } else if (updateAttentionMessage.getData().Gp && updateAttentionMessage.getData().isAttention) {
                        com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getPageContext().getPageActivity(), f.j.attention_success);
                    }
                }
            }
        }
    };
    private CustomMessageListener dns = new CustomMessageListener(2921346) { // from class: com.baidu.tieba.frs.FrsFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsFragment.this.refresh();
        }
    };
    private CustomMessageListener dnt = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.frs.FrsFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                FrsFragment.this.dmo.c((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener dnu = new CustomMessageListener(2001626) { // from class: com.baidu.tieba.frs.FrsFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewsRemindMessage newsRemindMessage;
            if (customResponsedMessage != null && (customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626 && (newsRemindMessage = (NewsRemindMessage) customResponsedMessage) != null) {
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (FrsFragment.this.dmo != null) {
                    FrsFragment.this.dmo.o(notificationCount, z);
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.n dnv = new com.baidu.tieba.tbadkCore.n() { // from class: com.baidu.tieba.frs.FrsFragment.10
        private long startTime = 0;

        @Override // com.baidu.tieba.tbadkCore.n
        public void kt(int i) {
            this.startTime = System.nanoTime();
            if (FrsFragment.this.dmo != null) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsFragment.this.dmo.avj();
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
            if (FrsFragment.this.byZ) {
                FrsFragment.this.byZ = false;
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.dmo, FrsFragment.this.dlQ, FrsFragment.this.getForumId(), false, null);
            }
            FrsFragment.this.auo();
            FrsFragment.this.dmv = true;
            if (aVar != null && aVar.isSuccess) {
                FrsFragment.this.dmo.avt().fZ(com.baidu.tbadk.core.util.ar.zu().zw());
                FrsFragment.dmq = 0L;
                FrsFragment.dmr = 0L;
                FrsFragment.dms = 0;
            } else {
                FrsFragment.dms = 1;
            }
            if (!FrsFragment.this.dmz.azM() && (i == 3 || i == 6)) {
                FrsFragment.this.dmL.resetData();
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (FrsFragment.this.dmz.azd() != null) {
                FrsFragment.this.dlQ = FrsFragment.this.dmz.azd();
            }
            FrsFragment.this.dmo.b(FrsFragment.this.dlQ.buQ());
            FrsFragment.this.kq(1);
            if (i == 7) {
                FrsFragment.this.kr(FrsFragment.this.dlQ.buv());
                return;
            }
            if (FrsFragment.this.dlQ.uv() != null) {
                FrsFragment.this.setHasMore(FrsFragment.this.dlQ.uv().ur());
            }
            if (i == 4) {
                if (!FrsFragment.this.dmz.azM() && TbadkCoreApplication.getInst().isRecAppExist() && FrsFragment.this.dmz.azC() == 1) {
                    FrsFragment.this.dlQ.a(FrsFragment.this);
                }
                ArrayList<com.baidu.adp.widget.ListView.h> a2 = FrsFragment.this.dmL.a(false, false, FrsFragment.this.dlQ.getThreadList(), FrsFragment.this.dmk, false);
                if (a2 != null) {
                    FrsFragment.this.dlQ.ax(a2);
                    FrsFragment.this.dlQ.buZ();
                    FrsFragment.this.dmo.a(a2, FrsFragment.this.dlQ);
                }
                if (FrsFragment.this.dmz != null) {
                    com.baidu.tieba.frs.e.b.a(FrsFragment.this.dlQ, FrsFragment.this.dmz.azI(), 2);
                }
                com.baidu.tieba.frs.f.a.a(FrsFragment.this, FrsFragment.this.dlQ.aZg(), FrsFragment.this.dlQ.getThreadList(), false, FrsFragment.this.getPn());
                FrsFragment.this.aTT = System.currentTimeMillis() - currentTimeMillis;
                FrsFragment.this.aup();
                return;
            }
            FrsFragment.this.aup();
            switch (i) {
                case 1:
                    FrsFragment.this.dmo.avj();
                    break;
                case 2:
                    FrsFragment.this.dmo.avj();
                    break;
                case 3:
                case 6:
                    if (FrsFragment.this.dlQ != null) {
                        FrsFragment.this.dlQ.buX();
                    }
                    if (FrsFragment.this.dmQ != null) {
                        FrsFragment.this.dmQ.refresh();
                        break;
                    }
                    break;
            }
            FrsFragment.this.auq();
            if (aVar == null || aVar.errorCode == 0) {
                if (FrsFragment.this.dlQ != null) {
                    FrsFragment.this.v(false, i == 5);
                    FrsFragment.this.dmo.kB(i);
                    FrsFragment.dmq = (System.nanoTime() - this.startTime) / 1000000;
                    if (aVar != null) {
                        FrsFragment.dmr = aVar.gKE;
                    }
                } else {
                    return;
                }
            } else if (FrsFragment.this.dlQ == null || com.baidu.tbadk.core.util.w.z(FrsFragment.this.dlQ.getThreadList())) {
                FrsFragment.this.a(aVar);
            } else if (aVar.gKD) {
                FrsFragment.this.showToast(FrsFragment.this.getPageContext().getResources().getString(f.j.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
            }
            if (FrsFragment.this.dlQ.buf() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11384"));
            }
            if (FrsFragment.this.cSK > -1 && !FrsFragment.this.dmX) {
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.dmz, FrsFragment.this.cSK);
                FrsFragment.this.cSK = -1L;
                FrsFragment.this.dmX = true;
            }
            if (FrsFragment.this.dml && FrsFragment.this.dmB.lQ(49)) {
                FrsFragment.this.dml = false;
            }
            FrsFragment.this.aTT = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void b(com.baidu.tieba.tbadkCore.i iVar) {
            if ((iVar != null && ("normal_page".equals(FrsFragment.this.dmz.getPageType()) || "frs_page".equals(FrsFragment.this.dmz.getPageType()) || "book_page".equals(FrsFragment.this.dmz.getPageType()))) || "brand_page".equals(FrsFragment.this.dmz.getPageType())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001615, iVar));
                FrsFragment.this.a(iVar);
            }
        }
    };
    private final CustomMessageListener dnw = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.frs.FrsFragment.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.i) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                FrsFragment.this.dlQ.a((com.baidu.tbadk.data.i) customResponsedMessage.getData());
                FrsFragment.this.dmo.avt().notifyDataSetChanged();
            }
        }
    };
    private final CustomMessageListener mMemListener = new CustomMessageListener(2001194) { // from class: com.baidu.tieba.frs.FrsFragment.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && FrsFragment.this.dlQ != null && (userData = FrsFragment.this.dlQ.getUserData()) != null) {
                userData.setIsMem(num.intValue());
                if (num.intValue() != 0) {
                    FrsFragment.this.dmA.g(num);
                }
            }
        }
    };
    private final com.baidu.tieba.frs.mc.i dnx = new com.baidu.tieba.frs.mc.i() { // from class: com.baidu.tieba.frs.FrsFragment.18
        @Override // com.baidu.tieba.frs.mc.i
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.h> arrayList, boolean z3) {
            if (FrsFragment.this.dmD != null && FrsFragment.this.dmz != null && FrsFragment.this.dmz.azM() && z && !z2 && !z3) {
                FrsFragment.this.dmD.lv(i2);
            }
        }
    };
    public final View.OnTouchListener aWF = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.FrsFragment.19
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (FrsFragment.this.dmT != null) {
                FrsFragment.this.dmT.onTouch(view, motionEvent);
            }
            if (FrsFragment.this.dmF != null && FrsFragment.this.dmF.avM() != null) {
                FrsFragment.this.dmF.avM().onTouchEvent(motionEvent);
            }
            if (FrsFragment.this.bFD != null) {
                FrsFragment.this.bFD.d(view, motionEvent);
            }
            if (FrsFragment.this.dmA != null) {
                FrsFragment.this.dmA.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private final CustomMessageListener dny = new CustomMessageListener(2004507) { // from class: com.baidu.tieba.frs.FrsFragment.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "photolive_hostLevel", -1) != -1 && FrsFragment.this.dlQ.aZg() != null) {
                FrsFragment.this.dlQ.aZg().setCanAddPhotoLivePost(true);
            }
        }
    };
    public final View.OnClickListener dnz = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.25
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsFragment.this.dmo == null || view != FrsFragment.this.dmo.avh() || FrsFragment.this.getActivity() == null) {
                if (FrsFragment.this.dlQ != null && FrsFragment.this.dlQ.aZg() != null && FrsFragment.this.dmo != null && view == FrsFragment.this.dmo.avn()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12402").ae(ImageViewerConfig.FORUM_ID, FrsFragment.this.dlQ.aZg().getId()).ae("uid", TbadkCoreApplication.getCurrentAccount()).ae(ImageViewerConfig.FORUM_NAME, FrsFragment.this.dlQ.aZg().getName()));
                    if (!StringUtils.isNull(FrsFragment.this.dlQ.aZg().getName())) {
                        FrsFragment.this.sendMessage(new CustomMessage(2002001, new PostSearchActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), FrsFragment.this.dlQ.aZg().getName(), FrsFragment.this.dlQ.aZg().getId())));
                        return;
                    }
                    return;
                }
                if (view.getId() == f.g.game_activity_egg_layout && com.baidu.adp.lib.util.l.jV()) {
                    TiebaStatic.log("c10853");
                    if (FrsFragment.this.dmo.avq()) {
                        FrsFragment.this.dmo.avr();
                    } else {
                        String activityUrl = FrsFragment.this.dlQ.aZg().getYuleData().wX().getActivityUrl();
                        if (!StringUtils.isNull(activityUrl)) {
                            com.baidu.tbadk.browser.a.S(FrsFragment.this.getPageContext().getPageActivity(), activityUrl);
                        }
                    }
                }
                if (view == FrsFragment.this.dmo.avx() && FrsFragment.this.dmz != null && FrsFragment.this.dmz.hasMore()) {
                    FrsFragment.this.dmo.Uo();
                    FrsFragment.this.Tq();
                }
                if (view != null && view == FrsFragment.this.dmo.avo() && com.baidu.tbadk.core.util.bb.aU(FrsFragment.this.getContext())) {
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
        private int dnG = 0;
        private int buc = 0;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (FrsFragment.this.dmJ != null) {
                FrsFragment.this.dmJ.aAk();
            }
            this.dnG = 0;
            this.buc = 0;
            if (recyclerView != null && (recyclerView instanceof BdRecyclerView)) {
                this.dnG = ((BdRecyclerView) recyclerView).getFirstVisiblePosition();
                this.buc = ((BdRecyclerView) recyclerView).getLastVisiblePosition();
            }
            if (FrsFragment.this.dmV != null) {
                FrsFragment.this.dmV.a(recyclerView, this.dnG, this.buc);
            }
            if (FrsFragment.this.dlQ != null && FrsFragment.this.dmo != null && FrsFragment.this.dmo.avt() != null) {
                FrsFragment.this.dmo.aC(this.dnG, this.buc);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (FrsFragment.this.dmA != null) {
                FrsFragment.this.dmA.setScrollState(i);
            }
            if ((i == 2 || i == 1) && !FrsFragment.this.dmw) {
                FrsFragment.this.dmw = true;
                FrsFragment.this.dmo.avv();
            }
            if (FrsFragment.this.dmx == null && !FrsFragment.this.auE()) {
                FrsFragment.this.dmx = new com.baidu.tbadk.l.b();
                FrsFragment.this.dmx.fl(1000);
            }
            if (i == 0) {
                if (FrsFragment.this.dmx != null) {
                    FrsFragment.this.dmx.KA();
                }
                com.baidu.tieba.card.v.ajb().ey(true);
                FrsFragment.this.dmo.aB(this.dnG, this.buc);
            } else if (FrsFragment.this.dmx != null) {
                FrsFragment.this.dmx.Kz();
            }
            if (FrsFragment.this.dmV != null) {
                FrsFragment.this.dmV.onScrollStateChanged(recyclerView, i);
            }
            if (i == 0) {
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.dmo, FrsFragment.this.dlQ, FrsFragment.this.getForumId(), false, null);
            }
            if (FrsFragment.this.dmB != null && i == 1) {
                FrsFragment.this.dmB.aAO();
            }
        }
    };
    private final d dnA = new d() { // from class: com.baidu.tieba.frs.FrsFragment.27
        @Override // com.baidu.tieba.frs.d
        public void a(int i, int i2, View view, View view2, bb bbVar) {
            if (i != FrsFragment.this.dmo.avt().axa()) {
                if (i != FrsFragment.this.dmo.avt().axb()) {
                    if (i == FrsFragment.this.dmo.avt().axc() && FrsFragment.this.dlQ != null && FrsFragment.this.dlQ.getUserData() != null && FrsFragment.this.dlQ.getUserData().isBawu()) {
                        String but = FrsFragment.this.dlQ.but();
                        if (!com.baidu.tbadk.core.util.ap.isEmpty(but) && FrsFragment.this.dlQ.aZg() != null) {
                            com.baidu.tbadk.browser.a.Q(FrsFragment.this.getPageContext().getPageActivity(), but);
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10502").ae(ImageViewerConfig.FORUM_ID, FrsFragment.this.dlQ.aZg().getId()).ae("uid", FrsFragment.this.dlQ.getUserData().getUserId()));
                        }
                    }
                } else if (com.baidu.tbadk.core.util.bb.aU(FrsFragment.this.getPageContext().getPageActivity())) {
                    TiebaStatic.log("my_service_ck");
                    if (FrsFragment.this.dlQ != null && FrsFragment.this.dlQ.aZg() != null) {
                        ForumData aZg = FrsFragment.this.dlQ.aZg();
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(aZg.getId(), 0L), aZg.getName(), aZg.getImage_url(), 0)));
                    }
                }
            } else if (com.baidu.tbadk.core.util.bb.aU(FrsFragment.this.getActivity())) {
                TiebaStatic.log("forum_fortune_click");
                com.baidu.tieba.frs.f.i.b(FrsFragment.this.getPageContext(), FrsFragment.this.dlQ);
            }
        }
    };
    private final NoNetworkView.a dkd = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.FrsFragment.28
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aR(boolean z) {
            if (FrsFragment.this.dmz.azC() == 1 && z && !FrsFragment.this.dmo.auD()) {
                if (FrsFragment.this.dlQ == null || com.baidu.tbadk.core.util.w.z(FrsFragment.this.dlQ.getThreadList())) {
                    FrsFragment.this.hideNetRefreshView(FrsFragment.this.dmo.aef());
                    FrsFragment.this.showLoadingView(FrsFragment.this.dmo.aef(), true);
                    FrsFragment.this.dmo.fF(false);
                    FrsFragment.this.refresh();
                    return;
                }
                FrsFragment.this.dmo.avj();
            }
        }
    };
    private final CustomMessageListener aDW = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.FrsFragment.29
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                com.baidu.tieba.frs.f.c.a(customResponsedMessage, FrsFragment.this.dmo, FrsFragment.this.dlQ);
            }
        }
    };
    private com.baidu.adp.widget.ListView.n dnB = new a();
    private al dnC = new al() { // from class: com.baidu.tieba.frs.FrsFragment.30
        @Override // com.baidu.tieba.frs.al
        public void a(int i, int i2, ar arVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
            com.baidu.adp.lib.g.e.in().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.30.1
                @Override // java.lang.Runnable
                public void run() {
                    if (FrsFragment.this.dmo != null && FrsFragment.this.dmo.ajX()) {
                        FrsFragment.this.Tq();
                    }
                }
            });
        }
    };
    private CustomMessageListener dnD = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.frs.FrsFragment.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    FrsFragment.this.dmW = true;
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.frs.loadmore.a
    public /* bridge */ /* synthetic */ com.baidu.adp.base.e getPageContext() {
        return super.getPageContext();
    }

    public com.baidu.tieba.frs.entelechy.b.b auc() {
        return this.dmH;
    }

    public com.baidu.adp.widget.ListView.n aud() {
        return this.dnB;
    }

    public com.baidu.tieba.frs.mc.d aue() {
        return this.dmK;
    }

    public com.baidu.tieba.frs.smartsort.b auf() {
        return this.dmD;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public FrsModelController aug() {
        return this.dmz;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public com.baidu.tieba.frs.mc.c auh() {
        return this.dmL;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public com.baidu.tieba.frs.vc.f aui() {
        return this.dmA;
    }

    public com.baidu.tieba.frs.vc.j auj() {
        return this.dmB;
    }

    public an auk() {
        return this.dmF;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public k aul() {
        return this.dmo;
    }

    @Override // com.baidu.tieba.frs.am
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.am, com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.dmg;
    }

    public void setForumName(String str) {
        this.dmg = str;
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
        if (this.dmL == null) {
            return 1;
        }
        return this.dmL.getPn();
    }

    public int getPn() {
        if (this.dmL == null) {
            return 1;
        }
        return this.dmL.getPn();
    }

    public void setPn(int i) {
        if (this.dmL != null) {
            this.dmL.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.dmL != null) {
            this.dmL.setHasMore(i);
        }
    }

    public int aum() {
        if (this.dmL == null) {
            return -1;
        }
        return this.dmL.aum();
    }

    public boolean aun() {
        return this.dmm;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d.a aVar) {
        if (aVar == null) {
            String string = TbadkCoreApplication.getInst().getString(f.j.error_unkown_try_again);
            this.dmo.ave();
            showNetRefreshView(this.dmo.aef(), string, true);
        } else if (340001 == aVar.errorCode) {
            a(aVar, this.dlQ.buc());
        } else {
            if (com.baidu.tbadk.core.util.w.z(this.dlQ.getThreadList())) {
                b(aVar);
            }
            if (auE()) {
                setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst(), f.e.ds280));
            } else {
                setNetRefreshViewEmotionDefMarginTop();
            }
        }
    }

    public void a(View view, String str, boolean z, List<RecmForumInfo> list) {
        this.dmo.ave();
        this.dmo.kx(8);
        if (this.dmU == null) {
            this.dmU = new com.baidu.tieba.frs.view.a(getPageContext(), getNetRefreshListener());
        }
        this.dmU.hk(str);
        this.dmU.bB(list);
        this.dmU.c(view, z);
    }

    private void a(d.a aVar, List<RecmForumInfo> list) {
        if (this.dmo != null) {
            this.dmo.ave();
            this.dmo.setTitle(this.dmg);
            a(this.dmo.aef(), aVar.errorMsg, true, list);
        }
    }

    private void b(d.a aVar) {
        this.dmo.ave();
        if (aVar.gKD) {
            showNetRefreshView(this.dmo.aef(), TbadkCoreApplication.getInst().getString(f.j.net_error_text, new Object[]{aVar.errorMsg, Integer.valueOf(aVar.errorCode)}), true);
        } else {
            showNetRefreshView(this.dmo.aef(), aVar.errorMsg, true);
        }
    }

    public void auo() {
        hideLoadingView(this.dmo.aef());
        if (!this.dmo.auD()) {
            this.dmo.fG(false);
        } else {
            this.dmo.fG(true);
        }
        if (this.dmo.avc() instanceof com.baidu.tieba.frs.tab.c) {
            ((com.baidu.tieba.frs.tab.c) this.dmo.avc()).aAe();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aup() {
        if (aum() == 0 && com.baidu.tbadk.core.util.w.z(this.dlQ.bul())) {
            if (com.baidu.tbadk.core.util.w.z(this.dlQ.getThreadList())) {
                this.dmo.Uq();
            } else {
                this.dmo.Up();
            }
        } else if (com.baidu.tbadk.core.util.w.y(this.dlQ.getThreadList()) > 3) {
            this.dmo.Uo();
        } else {
            this.dmo.avw();
        }
    }

    public void a(ErrorData errorData) {
        auo();
        this.dmo.avj();
        d.a azz = this.dmz.azz();
        boolean z = com.baidu.tbadk.core.util.w.z(this.dlQ.getThreadList());
        if (azz != null && z) {
            if (this.dmz.azA() != 0) {
                this.dmz.azG();
                this.dmo.avj();
            } else {
                a(azz);
            }
            this.dmo.w(this.dlQ.bvp(), false);
            return;
        }
        a(azz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kq(int i) {
        List<WindowToast> list;
        if (TbadkCoreApplication.isLogin() && this.dlQ != null && (list = this.dlQ.gMh) != null && list.size() > 0) {
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
    public void auq() {
        if (this.dlQ == null || this.dlQ.aZg() != null) {
            this.dmo.avs();
        } else if (this.dlQ.aZg().getYuleData() != null && this.dlQ.aZg().getYuleData().wW()) {
            TiebaStatic.log("c10852");
            this.dmo.a(this.dlQ.aZg().getYuleData().wX());
        } else {
            this.dmo.avs();
        }
    }

    private void u(boolean z, boolean z2) {
        if (this.dmz != null && this.dlQ != null && this.dmo != null && z) {
            if (!this.dmz.azM() && this.dmz.azC() == 1) {
                if (!this.dmz.azK()) {
                    this.dlQ.bvf();
                    this.dlQ.bvg();
                }
                boolean z3 = false;
                if (this.dmo.avt().k(com.baidu.tieba.card.data.n.cCt)) {
                    z3 = this.dlQ.bvj();
                }
                if (!z3) {
                    this.dlQ.bvh();
                }
                if (TbadkCoreApplication.getInst().isRecAppExist()) {
                    this.dlQ.a(this);
                }
                if (!this.dmo.avt().k(bb.ahB)) {
                    this.dlQ.buY();
                }
                this.dlQ.bvk();
            }
            if (!this.dmo.avt().k(bb.ahB)) {
                this.dlQ.bve();
                this.dlQ.bvc();
            } else {
                this.dlQ.bvd();
                this.dlQ.bvb();
            }
            this.dlQ.buZ();
            this.dlQ.buW();
            if (this.dmo.avt().k(com.baidu.tieba.h.b.dNm)) {
                this.dlQ.mp(z2);
            }
            if (TbadkCoreApplication.isLogin() && (!this.dmz.azM() || this.dmz.isNetFirstLoad)) {
                this.dlQ.bvl();
            }
            this.dlQ.bvn();
        }
    }

    public boolean aur() {
        if (this.dmA != null && this.dmz != null) {
            this.dmA.a(this.dmz.getPageType(), this.dlQ);
        }
        boolean z = false;
        if (this.dlQ != null) {
            z = this.dlQ.bvq();
        }
        aut();
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kr(int i) {
        ao aoVar = null;
        aur();
        auA();
        try {
            if (this.dlQ != null) {
                this.dmo.a((ArrayList<com.baidu.adp.widget.ListView.h>) null, this.dlQ);
                this.dmA.lL(1);
                this.dmo.avm();
                this.dmB.a(this.dlQ, this.dmz.azI());
                com.baidu.tieba.frs.tab.d lR = this.dmB.lR(this.dlQ.buv());
                if (lR != null && !TextUtils.isEmpty(lR.url)) {
                    aoVar = new ao();
                    aoVar.dpL = lR.url;
                    aoVar.stType = lR.name;
                }
                this.dmz.a(this.dlQ.buv(), 0, aoVar);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(boolean z, boolean z2) {
        try {
            if (this.dlQ != null && this.dmB != null && this.dmz != null) {
                if (!this.dmo.avt().k(bb.ahB)) {
                    this.dlQ.buY();
                }
                boolean z3 = com.baidu.tbadk.core.util.w.z(this.dlQ.buJ());
                this.dmo.fD(z3);
                if (!z3) {
                    if (this.dmV == null) {
                        this.dmV = new com.baidu.tieba.frs.vc.e(this, (NoPressedRelativeLayout) this.mRootView);
                    }
                    if (this.bFD == null) {
                        this.bFD = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
                    }
                } else {
                    this.dmV = null;
                    this.bFD = null;
                }
                if (this.dlQ.aZg() != null) {
                    this.dmg = this.dlQ.aZg().getName();
                    this.forumId = this.dlQ.aZg().getId();
                }
                if (this.dlQ.bvq()) {
                    this.dmB.a(this.dlQ, this.dmz.azI());
                }
                if (z) {
                    u(true, z);
                } else {
                    u(this.dmy, z);
                }
                aur();
                if (this.dmH != null) {
                    this.dmH.a(this.dmA, this.dlQ);
                }
                if (this.dlQ.uv() != null) {
                    setHasMore(this.dlQ.uv().ur());
                }
                ArrayList<com.baidu.adp.widget.ListView.h> a2 = this.dmL.a(z2, true, this.dlQ.getThreadList(), null, z, false);
                if (a2 != null) {
                    this.dlQ.ax(a2);
                }
                this.dlQ.bvm();
                if (this.dmz.azC() == 1) {
                    aux();
                    if (!z && this.dmz.getPn() == 1) {
                        aus();
                    }
                }
                this.dlT = this.dlQ.azE();
                if (this.dmk != null) {
                    this.dmj = true;
                    this.dmk.tF(this.dlT);
                    com.baidu.tieba.frs.f.a.a(this, this.dlQ.aZg(), this.dlQ.getThreadList(), this.dmj, getPn());
                }
                if (this.dmJ != null) {
                    this.dmJ.aC(this.dmB.aAL());
                }
                auo();
                this.dmo.avf();
                this.dmo.w(true, false);
                if (this.dlQ.aZg() != null) {
                    this.dmo.mw(this.dlQ.aZg().getWarningMsg());
                }
                if (this.dlQ != null && this.dlQ.buM() != null && com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("frs_video_activity_guide", 0L) == 0) {
                    com.baidu.adp.lib.g.e.in().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.11
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsFragment.this.dmo.avB();
                        }
                    }, 1000L);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2921326, this));
                this.dmo.auY();
                if (this.dlQ != null && this.dlQ.aZg() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016564, new VisitedForumData(this.dlQ.aZg().getId(), this.dlQ.aZg().getName(), this.dlQ.aZg().getImage_url(), String.valueOf(System.currentTimeMillis() / 1000), "showlive".equals(this.dlQ.aZg().special_forum_type))));
                }
                this.dnb.a(this.dlQ.gMm, this.dlQ.aZg());
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void aus() {
        if (this.dmO == null) {
            this.dmO = new com.baidu.tieba.frs.live.a(this, com.baidu.adp.lib.g.b.g(this.forumId, 0));
        }
        this.dmO.azl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.i iVar) {
        try {
            if (!this.dmv && iVar != null && this.dlQ != null) {
                this.dlQ.e(iVar);
                v(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void aut() {
        if (this.dmz != null) {
            mu(this.dmz.getPageType());
        } else {
            mu("normal_page");
        }
    }

    private void mu(String str) {
        fw("frs_page".equals(str));
        if (this.dmH != null) {
            this.dmH.a(this.dmA, this.dmo, this.dlQ);
        }
    }

    public void fw(boolean z) {
        if (this.dmM != null) {
            this.dmM.c(this.dmo, z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(f.h.frs_activity, viewGroup, false);
            this.dma = new com.baidu.tieba.frs.entelechy.b();
            this.dmH = this.dma.awB();
            this.dmA = new com.baidu.tieba.frs.vc.f(this, this.dma, (FrsHeaderViewContainer) this.mRootView.findViewById(f.g.header_view_container));
            this.dmB = new FrsTabViewController(this, this.mRootView);
            this.dmA.a(this.dmB);
            this.dmB.a(this.dnk);
            Intent intent = getActivity().getIntent();
            if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                this.dmc = true;
            }
            this.dmo = new k(this, this.dnz, this.dma, this.dmc, this.dmA);
            this.dmo.setHeaderViewHeight(this.dmS);
            this.dnb = new com.baidu.tieba.frs.brand.buttommenu.a(getPageContext(), this.mRootView);
        } else {
            if (this.mRootView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            this.dmB.resetData();
            this.dmo.avA();
        }
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        this.cSK = System.currentTimeMillis();
        this.beginTime = this.cSK;
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.dml = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.cSK = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            I(intent);
        }
        this.aTL = this.beginTime - this.cSK;
        this.dmk = new com.baidu.tieba.tbadkCore.data.e("frs", com.baidu.tieba.tbadkCore.data.e.gNu);
        this.dmz = new FrsModelController(this, this.dnv);
        this.dmz.a(this.dnj);
        this.dmz.init();
        if (intent != null) {
            this.dmz.i(intent.getExtras());
        } else if (bundle != null) {
            this.dmz.i(bundle);
        } else {
            this.dmz.i(null);
        }
        if (intent != null) {
            this.dmA.m(intent.getExtras());
        } else if (bundle != null) {
            this.dmA.m(bundle);
        } else {
            this.dmA.m((Bundle) null);
        }
        this.dmn = getVoiceManager();
        this.dmP = new j(getPageContext(), this);
        initUI();
        initData(bundle);
        if (this.mFrom != null && this.mFrom.equals("from_tieba_kuang")) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12264").r("obj_type", 1).ae(ImageViewerConfig.FORUM_NAME, this.dmz.getForumName()));
            KuangFloatingViewController.getInstance().setNeedShowFloatingView(true);
            if (KuangFloatingViewController.getInstance().init()) {
                ((BaseFragmentActivity) getPageContext().getOrignalPage()).grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.frs.FrsFragment.15
                    @Override // com.baidu.tbadk.core.e
                    public void ak(boolean z) {
                        if (z) {
                            KuangFloatingViewController.getInstance().showFloatingView();
                        }
                    }
                });
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SCHEMA_UPLOAD);
                httpMessage.addParam("call_url", com.baidu.adp.lib.util.k.bh("shoubai://internal?type=frs&param=" + this.dmg));
                MessageManager.getInstance().sendMessage(httpMessage);
            }
        }
        if (!auE()) {
            this.dmF = new an(getActivity(), this.dmo, this.dmA);
            this.dmF.fO(true);
        }
        this.dmn = getVoiceManager();
        if (this.dmn != null) {
            this.dmn.onCreate(getPageContext());
        }
        new com.baidu.tieba.frs.mc.g();
        this.dmL = new com.baidu.tieba.frs.mc.c(this, this.dnx);
        this.dmD = new com.baidu.tieba.frs.smartsort.b(this);
        this.dmM = new com.baidu.tieba.frs.vc.h(this);
        this.dmJ = new com.baidu.tieba.frs.vc.a(getPageContext(), this.dmz.azJ());
        this.dmE = new com.baidu.tieba.frs.mc.b(this);
        this.dmK = new com.baidu.tieba.frs.mc.d(this);
        this.dmC = new com.baidu.tieba.frs.mc.f(this);
        this.dmN = new com.baidu.tieba.frs.mc.a(this);
        this.dmQ = new com.baidu.tieba.frs.vc.c(this);
        this.dmR = new com.baidu.tieba.frs.mc.e(this, getUniqueId());
        this.dmY = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "frs");
        this.dmZ = new com.baidu.tieba.ala.a(getPageContext());
        registerListener(this.bCr);
        registerListener(this.mMemListener);
        registerListener(this.dnq);
        registerListener(this.dny);
        registerListener(this.dnp);
        registerListener(this.dnw);
        registerListener(this.dnm);
        registerListener(this.dnn);
        registerListener(this.dno);
        registerListener(this.dng);
        registerListener(this.dnh);
        registerListener(this.dnD);
        registerListener(this.dnt);
        registerListener(this.dni);
        registerListener(this.dnu);
        registerListener(this.dns);
        this.dnf.setTag(getPageContext().getUniqueId());
        registerListener(this.dnf);
        this.dmo.fF(false);
        if (!auE()) {
            showLoadingView(this.dmo.aef(), true);
            this.dmz.q(3, false);
        }
        com.baidu.tieba.frs.a.atC().a(new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.16
            @Override // com.baidu.tieba.frs.a.b
            public void t(boolean z, boolean z2) {
                if (FrsFragment.this.dmo != null) {
                    FrsFragment.this.dmo.ky(z ? 0 : 8);
                    if (!z2) {
                        FrsFragment.this.dnd = z;
                    }
                    if (FrsFragment.this.dmo.avt() != null && FrsFragment.this.dmz != null && FrsFragment.this.dmz.azD()) {
                        FrsFragment.this.dmo.avt().notifyDataSetChanged();
                    }
                    if (FrsFragment.this.dmo.avd() != null) {
                        FrsFragment.this.dmo.fC(!z);
                    }
                    if (FrsFragment.this.getActivity() instanceof FrsActivity) {
                        ((FrsActivity) FrsFragment.this.getActivity()).fv(!z);
                    }
                    if (FrsFragment.this.dnb != null) {
                        FrsFragment.this.dnb.fX(!z);
                    }
                    FrsFragment.this.dmo.fH(!z);
                    FrsFragment.this.dmo.fI(z ? false : true);
                }
            }

            @Override // com.baidu.tieba.frs.a.b
            public void kn(int i) {
                if (FrsFragment.this.dmo != null) {
                    FrsFragment.this.dmo.kz(i);
                }
            }

            @Override // com.baidu.tieba.frs.a.b
            public void atH() {
                com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getContext(), f.j.frs_multi_delete_max_num);
            }
        });
        this.dmo.b(new d.a() { // from class: com.baidu.tieba.frs.FrsFragment.17
            @Override // com.baidu.tieba.NEGFeedBack.d.a
            public void a(DeleteThreadHttpResponseMessage deleteThreadHttpResponseMessage) {
                if (deleteThreadHttpResponseMessage != null) {
                    FrsFragment.this.dmo.PB();
                    FrsFragment.this.dmo.avC();
                    if (deleteThreadHttpResponseMessage.getError() == 0) {
                        if (deleteThreadHttpResponseMessage.getRetType() != 1211066) {
                            FrsFragment.this.dmo.S(deleteThreadHttpResponseMessage.getText(), ContextCompat.getColor(FrsFragment.this.getContext(), deleteThreadHttpResponseMessage.getRetType() == 1 ? f.d.nav_bar_tip_error : f.d.cp_link_tip_a_alpha95));
                        } else {
                            String text = !TextUtils.isEmpty(deleteThreadHttpResponseMessage.getText()) ? deleteThreadHttpResponseMessage.getText() : FrsFragment.this.getString(f.j.delete_fail);
                            if (FrsFragment.this.cBc == null) {
                                FrsFragment.this.cBc = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                                FrsFragment.this.cBc.dB(text);
                                FrsFragment.this.cBc.a(f.j.dialog_known, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.17.1
                                    @Override // com.baidu.tbadk.core.dialog.a.b
                                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                        if (aVar != null) {
                                            aVar.dismiss();
                                        }
                                    }
                                });
                                FrsFragment.this.cBc.av(true);
                                FrsFragment.this.cBc.b(FrsFragment.this.getPageContext());
                            }
                            FrsFragment.this.cBc.xe();
                        }
                        FrsFragment.this.bl(deleteThreadHttpResponseMessage.getSuccessItems());
                        com.baidu.tieba.frs.a.atC().bk(deleteThreadHttpResponseMessage.getSuccessItems());
                        int i = 0;
                        Iterator<com.baidu.adp.widget.ListView.h> it = FrsFragment.this.dlQ.getThreadList().iterator();
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
                            FrsFragment.this.Tq();
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
        if (this.dmB != null) {
            this.dmB.dHh = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bl(List<String> list) {
        if (!com.baidu.tbadk.core.util.w.z(list)) {
            ArrayList<com.baidu.adp.widget.ListView.h> threadList = this.dlQ.getThreadList();
            if (!com.baidu.tbadk.core.util.w.z(threadList) && this.dmo.getListView() != null && this.dmo.getListView().getData() != null) {
                Iterator<com.baidu.adp.widget.ListView.h> it = threadList.iterator();
                List<com.baidu.adp.widget.ListView.h> data = this.dmo.getListView().getData();
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
                                this.dmL.aa(bbVar);
                                this.dmo.getListView().getAdapter().notifyItemRemoved(i);
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
    public void TQ() {
        if (isAdded() && this.byZ && !isLoadingViewAttached()) {
            showLoadingView(this.dmo.aef(), true);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void TR() {
        if (isAdded() && this.byZ && isLoadingViewAttached()) {
            hideLoadingView(this.dmo.aef());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (auE()) {
            showLoadingView(this.dmo.aef(), true);
            this.dmo.kA(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.dmz.q(3, true);
            AP().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void setHeaderViewHeight(int i) {
        this.dmS = i;
        if (this.dmo != null) {
            this.dmo.setHeaderViewHeight(this.dmS);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.s sVar) {
        if (sVar != null) {
            this.aWE = sVar.Ly();
            this.dmT = sVar.Lz();
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void showFloatingView() {
        if (this.aWE != null) {
            this.aWE.cf(true);
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
            this.dmg = data.getQueryParameter("name");
            this.mFrom = data.getQueryParameter("from");
            if (!StringUtils.isNull(this.dmg)) {
                intent.putExtra("name", this.dmg);
            }
            if (!StringUtils.isNull(this.mFrom)) {
                intent.putExtra("from", this.mFrom);
            }
            TiebaStatic.log("c10105");
        }
        if (StringUtils.isNull(this.dmg)) {
            com.baidu.tieba.frs.f.d K = com.baidu.tieba.frs.f.i.K(intent);
            if (K != null) {
                this.dmg = K.forumName;
                if (K.dFE != null && K.dFE.equals("aidou")) {
                    com.baidu.tbadk.core.dialog.h.alx = System.currentTimeMillis();
                }
            }
            if (!StringUtils.isNull(this.dmg)) {
                intent.putExtra("name", this.dmg);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.dmn = getVoiceManager();
        if (this.dmn != null) {
            this.dmn.onStart(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        Intent intent;
        registerListener(2001118, this.aDW);
        if (bundle != null) {
            this.dmg = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
            this.dmg = intent.getStringExtra("name");
            this.mFrom = intent.getStringExtra("from");
            this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
        }
        if (getArguments() != null) {
            this.dmh = getArguments().getBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, false);
        }
        if (TextUtils.isEmpty(this.mFrom) || FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
        }
        if (this.mIsLogin) {
            registerListener(2001120, this.aDW);
        }
        this.dmA.m(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dnD);
        if (this.dmn != null) {
            this.dmn.onDestory(getPageContext());
        }
        com.baidu.tieba.recapp.report.a.remove("FRS");
        this.dmn = null;
        com.baidu.tieba.card.v.ajb().ey(false);
        if (this.dlQ != null && this.dlQ.aZg() != null) {
            ac.avJ().bH(com.baidu.adp.lib.g.b.c(this.dlQ.aZg().getId(), 0L));
        }
        if (this.dmO != null) {
            this.dmO.onDestory();
        }
        if (this.dmo != null) {
            com.baidu.tieba.frs.f.h.a(this.dmo, this.dlQ, getForumId(), false, null);
            this.dmo.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.dmx != null) {
                this.dmx.KB();
            }
            this.dmo.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.dmz.onActivityDestroy();
        this.dmA.onActivityDestroy();
        if (this.dmz != null) {
            this.dmz.VA();
        }
        if (this.dmF != null) {
            this.dmF.Lx();
        }
        if (this.dmI != null) {
            this.dmI.destory();
        }
        if (this.dmJ != null) {
            this.dmJ.destory();
        }
        if (this.dmD != null) {
            this.dmD.onDestroy();
        }
        if (this.dmV != null) {
            this.dmV.onDestory();
        }
        if (this.dmN != null) {
            this.dmN.onDestroy();
        }
        if (this.dmY != null) {
            this.dmY.onDestroy();
        }
        if (this.dmZ != null) {
            this.dmZ.onDestroy();
        }
        com.baidu.tieba.recapp.d.a.boe().bog();
        com.baidu.tieba.frs.f.j.aAh();
        if (this.dmB != null) {
            this.dmB.a((FrsTabViewController.a) null);
            this.dmB.aAO();
        }
        if (this.dna != null) {
            this.dna.onDestroy();
        }
        if (this.dnc != null) {
            this.dnc.onDestroy();
        }
        com.baidu.tieba.frs.a.atC().a(null);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.dmg);
        bundle.putString("from", this.mFrom);
        this.dmz.onSaveInstanceState(bundle);
        if (this.dmn != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            this.dmn.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.dmN != null) {
            this.dmN.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dmo != null) {
            this.dmo.avj();
            this.dmo.onResume();
        }
        this.dmC.gm(true);
        this.dmy = true;
        if (dmf) {
            dmf = false;
            this.dmo.startPullRefresh();
            return;
        }
        if (this.dmn != null) {
            this.dmn.onResume(getPageContext());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921338));
        this.dmo.fJ(false);
        if (this.dmW) {
            refresh(6);
            this.dmW = false;
        }
        if (KuangFloatingViewController.getInstance().init()) {
            ((BaseFragmentActivity) getPageContext().getOrignalPage()).grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.frs.FrsFragment.21
                @Override // com.baidu.tbadk.core.e
                public void ak(boolean z) {
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

    public boolean auu() {
        Intent intent;
        if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
            return false;
        }
        return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
    }

    public void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.dmg = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.dmi = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.dmi) {
                auv();
            }
            if (this.mFrom != null && this.mFrom.equals("from_tieba_kuang")) {
                KuangFloatingViewController.getInstance().setNeedShowFloatingView(true);
                if (KuangFloatingViewController.getInstance().init()) {
                    ((BaseFragmentActivity) getPageContext().getOrignalPage()).grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.frs.FrsFragment.22
                        @Override // com.baidu.tbadk.core.e
                        public void ak(boolean z) {
                            if (z) {
                                KuangFloatingViewController.getInstance().showFloatingView();
                            }
                        }
                    });
                }
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SCHEMA_UPLOAD);
                httpMessage.addParam("call_url", com.baidu.adp.lib.util.k.bh("shoubai://internal?type=frs&param=" + this.dmg));
                MessageManager.getInstance().sendMessage(httpMessage);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auv() {
        this.dmo.startPullRefresh();
    }

    public void closeActivity() {
        com.baidu.tieba.frs.f.i.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.mFrom);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.dmo.setTitle(this.dmg);
        } else {
            this.dmo.setTitle("");
            this.mFlag = 1;
        }
        this.dmo.setOnAdapterItemClickListener(this.dnB);
        this.dmo.addOnScrollListener(this.mScrollListener);
        this.dmo.h(this.dkd);
        this.dmo.avt().a(this.dnA);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dmo.onChangeSkinType(i);
        this.dmA.lK(i);
        this.dmB.onChangeSkinType(i);
        if (this.dmU != null) {
            this.dmU.onChangeSkinType();
        }
        if (this.dna != null) {
            this.dna.onChangeSkinType(i);
        }
        if (this.dnb != null) {
            this.dnb.d(getPageContext(), i);
        }
        if (this.cBc != null) {
            com.baidu.tbadk.o.a.a(getPageContext(), this.cBc.xf());
        }
    }

    public void ks(int i) {
        if (!this.mIsLogin) {
            if (this.dlQ != null && this.dlQ.ug() != null) {
                this.dlQ.ug().setIfpost(1);
            }
            if (i == 0) {
                com.baidu.tbadk.core.util.bb.aT(getActivity());
            }
        } else if (this.dlQ != null) {
            if (i == 0) {
                com.baidu.tieba.frs.f.j.d(this, 0);
            } else {
                this.dmo.avl();
            }
        }
    }

    public void refresh() {
        com.baidu.tieba.a.d.QN().iA("page_frs");
        refresh(3);
    }

    public void refresh(int i) {
        this.dmv = false;
        auA();
        if (this.dmo.avb() != null) {
            this.dmo.avb().aFA();
        }
        this.dmz.q(i, true);
    }

    private void auw() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.g.h.io().d(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.24
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.tW(FrsFragment.this.dmg);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aux() {
        auA();
        try {
            if (this.dlQ != null) {
                this.dmo.agP();
                this.dmo.fC(auJ());
                if (!com.baidu.tieba.frs.vc.f.k(this.dlQ) || !com.baidu.tieba.frs.vc.f.j(this.dlQ)) {
                }
                if (this.dlQ.aZg() != null) {
                    this.dmg = this.dlQ.aZg().getName();
                    this.forumId = this.dlQ.aZg().getId();
                }
                if (this.dlQ.uv() != null) {
                    setHasMore(this.dlQ.uv().ur());
                }
                this.dmo.setTitle(this.dmg);
                this.dmo.setForumName(this.dmg);
                TbadkCoreApplication.getInst().setDefaultBubble(this.dlQ.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.dlQ.getUserData().getBimg_end_time());
                auw();
                auy();
                ArrayList<com.baidu.adp.widget.ListView.h> threadList = this.dlQ.getThreadList();
                if (threadList != null) {
                    this.dmo.a(threadList, this.dlQ);
                    com.baidu.tieba.frs.f.c.w(this.dmo);
                    this.dmA.lL(getPageNum());
                    this.dmA.h(this.dlQ);
                    this.dmB.a(this.dlQ, this.dmz.azI());
                    this.dmo.avm();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void auy() {
        if (this.dlQ != null) {
            if (this.dlQ.aZv() == 1) {
                this.dmo.avt().setFromCDN(true);
            } else {
                this.dmo.avt().setFromCDN(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.dmC.gm(false);
        this.dmy = false;
        this.dmo.onPause();
        if (this.dmn != null) {
            this.dmn.onPause(getPageContext());
        }
        this.dmo.fJ(true);
        if (this.dmJ != null) {
            this.dmJ.aAk();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.dmB != null && this.dmB.aAM() != null && (this.dmB.aAM().fragment instanceof BaseFragment)) {
            ((BaseFragment) this.dmB.aAM().fragment).setPrimary(z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.v.ajb().ey(false);
        if (this.dlQ != null && this.dlQ.aZg() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            com.baidu.tbadk.distribute.a.Hf().a(getPageContext().getPageActivity(), "frs", this.dlQ.aZg().getId(), 0L);
        }
        if (this.dmn != null) {
            this.dmn.onStop(getPageContext());
        }
        if (AP() != null) {
            AP().getRecycledViewPool().clear();
        }
        this.dmA.onActivityStop();
        com.baidu.tbadk.util.t.LB();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            if (this.dmA != null) {
                this.dmA.fA(isPrimary());
            }
            if (this.dmo != null) {
                this.dmo.fA(isPrimary());
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (com.baidu.tieba.frs.a.atC().atD()) {
                com.baidu.tieba.frs.a.atC().reset();
                return true;
            } else if (this.dmo != null) {
                return this.dmo.avi();
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.n
    public TbPageContext<?> aiB() {
        return getPageContext();
    }

    @Override // com.baidu.tieba.recapp.n
    public void a(AdvertAppInfo advertAppInfo, String str) {
        com.baidu.tbadk.distribute.a.Hf().a(advertAppInfo, this.forumId, 0L, "FRS", str, getPn());
    }

    @Override // com.baidu.tieba.recapp.n
    public void auz() {
        aug().auz();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dmn == null) {
            this.dmn = VoiceManager.instance();
        }
        return this.dmn;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdRecyclerView AP() {
        if (this.dmo == null) {
            return null;
        }
        return this.dmo.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void auA() {
        if (this.dmn != null) {
            this.dmn.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> AQ() {
        if (this.ayP == null) {
            this.ayP = UserIconBox.i(getPageContext().getPageActivity(), 8);
        }
        return this.ayP;
    }

    public void auB() {
        if (getFragmentActivity() != null && getFragmentActivity().getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.a(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.k onGetPreLoadListView() {
        return AP().getPreLoadHandle();
    }

    @Override // com.baidu.tieba.frs.ak
    public NavigationBar Vj() {
        if (this.dmo == null) {
            return null;
        }
        return this.dmo.Vj();
    }

    @Override // com.baidu.tbadk.core.view.NavigationBar.a
    public void b(Pair<Integer, Integer> pair) {
        this.dmt = pair;
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
                if (bdUniqueId == p.doY) {
                    if (FrsFragment.this.dmo != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11752").ae(ImageViewerConfig.FORUM_ID, FrsFragment.this.forumId).ae("obj_locate", "1"));
                        FrsFragment.this.dmo.startPullRefresh();
                    }
                } else if (hVar != null && (hVar instanceof bb)) {
                    bb bbVar = (bb) hVar;
                    if (bbVar.vT() == null || bbVar.vT().getGroup_id() == 0 || com.baidu.tbadk.core.util.bb.aU(FrsFragment.this.getActivity())) {
                        if (bbVar.vM() != 1 || com.baidu.tbadk.core.util.bb.aU(FrsFragment.this.getActivity())) {
                            if (bbVar.vx() != null) {
                                if (com.baidu.tbadk.core.util.bb.aU(FrsFragment.this.getActivity())) {
                                    String postUrl = bbVar.vx().getPostUrl();
                                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.jV()) {
                                        com.baidu.tbadk.browser.a.S(FrsFragment.this.getActivity(), postUrl);
                                    }
                                }
                            } else if (bbVar.wc() != null) {
                                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                    com.baidu.tbadk.core.util.bb.aT(FrsFragment.this.getPageContext().getPageActivity());
                                    return;
                                }
                                com.baidu.tbadk.core.data.m wc = bbVar.wc();
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), wc.getCartoonId(), wc.getChapterId(), 2)));
                            } else {
                                com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                                if (readThreadHistory != null && !readThreadHistory.uc(bbVar.getId())) {
                                    readThreadHistory.ub(bbVar.getId());
                                }
                                boolean z = false;
                                final String vr = bbVar.vr();
                                if (vr != null && !vr.equals("")) {
                                    z = true;
                                    new Thread(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.a.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            com.baidu.tbadk.core.util.y yVar = new com.baidu.tbadk.core.util.y(vr);
                                            yVar.yM().zK().mIsNeedAddCommenParam = false;
                                            yVar.yM().zK().mIsUseCurrentBDUSS = false;
                                            yVar.yp();
                                        }
                                    }).start();
                                }
                                String tid = bbVar.getTid();
                                if (tid == null) {
                                    tid = "";
                                }
                                if (bbVar.ve() == 2 && !tid.startsWith("pb:")) {
                                    az.zI().c(FrsFragment.this.getPageContext(), new String[]{tid, "", null});
                                    return;
                                }
                                if (tid.startsWith("pb:")) {
                                    bbVar.setId(tid.substring(3));
                                }
                                if (bdUniqueId.getId() == bb.aiT.getId()) {
                                    com.baidu.tieba.frs.f.h.a(bbVar.uQ());
                                } else if (bdUniqueId.getId() == bb.ahE.getId()) {
                                    com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c12940");
                                    anVar.ae("obj_type", "2");
                                    anVar.ae("tid", bbVar.getTid());
                                    TiebaStatic.log(anVar);
                                }
                                com.baidu.tieba.frs.f.i.a(FrsFragment.this, bbVar, i, z);
                                com.baidu.tieba.frs.f.h.a(FrsFragment.this, FrsFragment.this.dlQ, bbVar);
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
            hideNetRefreshView(this.dmo.aef());
            showLoadingView(this.dmo.aef(), true);
            this.dmo.fF(false);
            this.dmz.q(3, true);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public com.baidu.tieba.tbadkCore.l auC() {
        return this.dlQ;
    }

    public boolean auD() {
        return this.dmo.auD();
    }

    public void W(Object obj) {
        if (this.dmE != null && this.dmE.dDq != null) {
            this.dmE.dDq.i(obj);
        }
    }

    public void X(Object obj) {
        if (this.dmE != null && this.dmE.dDr != null) {
            this.dmE.dDr.i(obj);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        this.dmo.getListView().stopScroll();
        if (!this.dmo.avp()) {
            if (!com.baidu.adp.lib.util.l.jV()) {
                this.dmo.Uq();
            } else if (this.dmz.azC() == 1) {
                TE();
                Tq();
            } else if (this.dmz.hasMore()) {
                Tq();
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void md(String str) {
        TE();
        showToast(str);
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void O(ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        boolean z = com.baidu.tbadk.core.util.w.z(arrayList);
        setHasMore(z ? 0 : 1);
        TE();
        if (!z) {
            if (!this.dmz.azM() && TbadkCoreApplication.getInst().isRecAppExist() && this.dmz.azC() == 1) {
                this.dlQ.a(this, arrayList);
            }
            ArrayList<com.baidu.adp.widget.ListView.h> a2 = this.dmL.a(false, false, arrayList, this.dmk, false);
            if (a2 != null) {
                this.dlQ.ax(a2);
                this.dmo.a(a2, this.dlQ);
            }
            if (this.dmz != null) {
                com.baidu.tieba.frs.e.b.a(this.dlQ, this.dmz.azI(), 2);
            }
        }
    }

    private void TE() {
        if (aum() == 1 || this.dmL.bx(this.dlQ.bul())) {
            if (com.baidu.tbadk.core.util.w.y(this.dlQ.getThreadList()) > 3) {
                this.dmo.Uo();
            } else {
                this.dmo.avw();
            }
        } else if (com.baidu.tbadk.core.util.w.z(this.dlQ.getThreadList())) {
            this.dmo.Uq();
        } else {
            this.dmo.Up();
        }
    }

    @Override // com.baidu.tieba.frs.mc.j
    public void Tq() {
        if (this.dmL != null) {
            this.dmL.a(this.dmg, this.forumId, this.dlQ);
        }
    }

    public void takePhoto() {
        if (!com.baidu.tbadk.core.util.ac.e(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.al.b(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        if (this.dmu) {
            return null;
        }
        if (auE()) {
            return "a034";
        }
        return "a006";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (!auE()) {
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
        if (this.dmF != null) {
            this.dmF.fO(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.dmG.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a gh(int i) {
        return this.dmG.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        this.dmP.b(bVar);
    }

    public boolean auE() {
        return this.dmc;
    }

    @Override // com.baidu.tieba.frs.ah
    public void TP() {
        if (this.dmo != null) {
            showFloatingView();
            this.dmo.getListView().scrollToPosition(0);
            this.dmo.startPullRefresh();
        }
    }

    public ForumWriteData auF() {
        if (this.dlQ == null || this.dlQ.aZg() == null) {
            return null;
        }
        ForumData aZg = this.dlQ.aZg();
        ForumWriteData forumWriteData = new ForumWriteData(aZg.getId(), aZg.getName(), aZg.getPrefixData(), this.dlQ.ug());
        forumWriteData.avatar = aZg.getImage_url();
        forumWriteData.forumLevel = aZg.getUser_level();
        forumWriteData.specialForumType = aZg.special_forum_type;
        forumWriteData.firstDir = aZg.getFirst_class();
        forumWriteData.secondDir = aZg.getSecond_class();
        UserData userData = this.dlQ.getUserData();
        forumWriteData.privateThread = userData != null ? userData.getPrivateThread() : 0;
        return forumWriteData;
    }

    @Override // com.baidu.tieba.frs.ah
    public void AD() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.frs.ah
    public void setVideoThreadId(String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z) {
        super.showLoadingView(view, z);
        this.dmo.kx(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        super.hideLoadingView(view);
        this.dmo.kx(0);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        super.showNetRefreshView(view, str, z);
        this.dmo.kx(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshViewNoClick(View view, String str, boolean z) {
        super.showNetRefreshViewNoClick(view, str, z);
        this.dmo.kx(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        super.hideNetRefreshView(view);
        this.dmo.kx(0);
    }

    public void auG() {
        FrsTabViewController.b aAM;
        if (this.dmB != null && (aAM = this.dmB.aAM()) != null && aAM.fragment != null && (aAM.fragment instanceof aj)) {
            ((aj) aAM.fragment).atX();
        }
    }

    public void a(ContriInfo contriInfo) {
        if (this.dna == null) {
            this.dna = new com.baidu.tbadk.core.dialog.h(aiB());
            this.dna.a(new h.a() { // from class: com.baidu.tieba.frs.FrsFragment.32
                @Override // com.baidu.tbadk.core.dialog.h.a
                public void aD(boolean z) {
                    if (z) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13061"));
                    }
                }
            });
        }
        this.dna.a(contriInfo, -1L);
    }

    public void fz(boolean z) {
        this.dme = z;
    }

    public boolean auH() {
        return this.dme;
    }

    public void mv(String str) {
        if (TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.util.ap.isEmpty(str)) {
            if (this.dnc == null) {
                this.dnc = new AddExperiencedModel(aiB());
                this.dnc.a(this.dne);
            }
            this.dnc.ce(this.forumId, str);
        }
    }

    public com.baidu.tieba.frs.entelechy.b auI() {
        return this.dma;
    }

    public boolean auJ() {
        return (this.dmz != null && this.dmz.azD() && com.baidu.tieba.frs.a.atC().atD()) ? false : true;
    }
}
