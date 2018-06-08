package com.baidu.tieba.frs;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
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
import com.baidu.d.a.a;
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
import com.baidu.tbadk.core.data.bd;
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
import com.baidu.tieba.d;
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
import java.util.List;
import tbclient.FrsPage.RecmForumInfo;
import tbclient.WindowToast;
/* loaded from: classes2.dex */
public class FrsFragment extends BaseFragment implements BdListView.e, a.InterfaceC0061a, NavigationBar.a, UserIconBox.b<BdRecyclerView>, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, af, ai, ak, com.baidu.tieba.frs.loadmore.a, com.baidu.tieba.frs.mc.j, com.baidu.tieba.recapp.n {
    private com.baidu.tbadk.util.s aVH;
    private com.baidu.adp.lib.e.b<TbImageView> ayn;
    private com.baidu.tieba.frs.gametab.b bCQ;
    private VoiceManager dhB;
    private FrsModelController dhN;
    private com.baidu.tieba.frs.vc.f dhO;
    private FrsTabViewController dhP;
    private com.baidu.tieba.frs.mc.f dhQ;
    private com.baidu.tieba.frs.smartsort.b dhR;
    private com.baidu.tieba.frs.mc.b dhS;
    private al dhT;
    private com.baidu.tieba.frs.entelechy.b.b dhV;
    private com.baidu.tbadk.h.a dhW;
    private com.baidu.tieba.frs.vc.a dhX;
    private com.baidu.tieba.frs.mc.d dhY;
    private com.baidu.tieba.frs.mc.c dhZ;
    private com.baidu.tieba.frs.entelechy.b dhp;
    private com.baidu.tieba.tbadkCore.data.e dhy;
    private com.baidu.tieba.frs.vc.h dia;
    private com.baidu.tieba.frs.mc.a dib;
    private com.baidu.tieba.frs.live.a dic;
    private h did;
    public com.baidu.tieba.frs.vc.c die;
    private com.baidu.tieba.frs.mc.e dif;
    private int dig;
    private View.OnTouchListener dih;
    private com.baidu.tieba.frs.view.a dii;
    private com.baidu.tieba.frs.vc.e dij;
    private boolean dik;
    private com.baidu.tieba.NEGFeedBack.a dim;
    private com.baidu.tieba.ala.a din;
    private com.baidu.tbadk.core.dialog.h dio;
    private AddExperiencedModel dip;
    public View mRootView;
    public static boolean dhu = false;
    public static volatile long dhE = 0;
    public static volatile long dhF = 0;
    public static volatile int dhG = 0;
    public boolean dhq = false;
    private boolean dhr = false;
    private boolean dhs = false;
    private boolean dht = true;
    public String dhv = null;
    public String mFrom = null;
    public int mFlag = 0;
    private boolean dhw = false;
    private String mThreadId = null;
    public String forumId = null;
    private int dhi = 0;
    private boolean dhx = false;
    private boolean dhz = false;
    private boolean dhA = false;
    private i dhC = null;
    public final bd bso = null;
    private com.baidu.tieba.tbadkCore.l dhf = new com.baidu.tieba.tbadkCore.l();
    public long cSd = -1;
    public long aSW = 0;
    public long aSO = 0;
    public long createTime = 0;
    public long beginTime = -1;
    public long dhD = 0;
    public Pair<Integer, Integer> dhH = null;
    public boolean dhI = false;
    private boolean dhJ = false;
    private boolean dhK = false;
    public com.baidu.tbadk.k.b dhL = null;
    private boolean dhM = true;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> dhU = new SparseArray<>();
    private boolean bEd = true;
    private boolean dil = false;
    private AddExperiencedModel.a diq = new AddExperiencedModel.a() { // from class: com.baidu.tieba.frs.FrsFragment.1
        @Override // com.baidu.tieba.share.AddExperiencedModel.a
        public void b(ContriInfo contriInfo) {
            if (contriInfo != null && contriInfo.isShowToast()) {
                FrsFragment.this.a(contriInfo);
            }
        }
    };
    private HttpMessageListener dir = new HttpMessageListener(CmdConfigHttp.CMD_PB_FLOOR_AGREE, true) { // from class: com.baidu.tieba.frs.FrsFragment.12
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
    private final CustomMessageListener dis = new CustomMessageListener(2016495) { // from class: com.baidu.tieba.frs.FrsFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof bd) {
                    com.baidu.tieba.frs.f.h.a(FrsFragment.this.dhC, FrsFragment.this.dhf, FrsFragment.this.getForumId(), true, (bd) data);
                }
            }
        }
    };
    private CustomMessageListener dit = new CustomMessageListener(2921005) { // from class: com.baidu.tieba.frs.FrsFragment.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.dhf != null) {
                FrsFragment.this.dhf.bwc();
                if (FrsFragment.this.dhC != null) {
                    FrsFragment.this.dhC.akl();
                }
            }
        }
    };
    private CustomMessageListener diu = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.FrsFragment.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 1) {
                    FrsFragment.this.atB();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                }
            }
        }
    };
    private final aj div = new aj() { // from class: com.baidu.tieba.frs.FrsFragment.33
        @Override // com.baidu.tieba.frs.aj
        public void a(int i, int i2, ap apVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
            FrsFragment.this.atu();
            if (FrsFragment.this.dhV != null) {
                FrsFragment.this.dhO.gc(FrsFragment.this.dhV.kz(i));
            }
            d.a aVar = new d.a();
            if (apVar != null) {
                aVar.isSuccess = apVar.errCode == 0;
                aVar.errorCode = apVar.errCode;
                aVar.errorMsg = apVar.errMsg;
                if (aVar.isSuccess) {
                    if (com.baidu.tbadk.core.util.w.z(arrayList)) {
                        FrsFragment.this.dhC.TL();
                    } else if (apVar.hasMore) {
                        if (com.baidu.tbadk.core.util.w.y(FrsFragment.this.dhf.getThreadList()) > 3) {
                            FrsFragment.this.dhC.TJ();
                        } else {
                            FrsFragment.this.dhC.auA();
                        }
                    } else if (apVar.dkR) {
                        FrsFragment.this.dhC.TK();
                    } else {
                        FrsFragment.this.dhC.TL();
                    }
                }
            } else {
                apVar = new ap();
                apVar.pn = 1;
                apVar.hasMore = false;
                apVar.dkR = false;
            }
            if (i == 1) {
                FrsFragment.this.dhM = true;
                FrsFragment.this.diG.a(FrsFragment.this.dhN.getType(), false, aVar);
            } else {
                FrsFragment.this.a(aVar);
                if (FrsFragment.this.dhN.axV() != null) {
                    FrsFragment.this.dhf = FrsFragment.this.dhN.axV();
                }
                FrsFragment.this.atD();
            }
            if (FrsFragment.this.diN != null) {
                FrsFragment.this.diN.a(i, i2, apVar, arrayList);
            }
        }
    };
    private FrsTabViewController.a diw = new FrsTabViewController.a() { // from class: com.baidu.tieba.frs.FrsFragment.34
        @Override // com.baidu.tieba.frs.vc.FrsTabViewController.a
        public void eX(int i) {
            if (i != 1) {
                com.baidu.tieba.card.v.ajh().ey(false);
            }
            FrsFragment.this.atG();
            com.baidu.tieba.frs.e.c.dyP.dyG = i;
            com.baidu.tieba.frs.e.c.dyP.dyH = -1;
        }
    };
    private CustomMessageListener dix = new CustomMessageListener(2001606) { // from class: com.baidu.tieba.frs.FrsFragment.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                FrsFragment.this.dhP.lA(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    };
    private CustomMessageListener diy = new CustomMessageListener(2001607) { // from class: com.baidu.tieba.frs.FrsFragment.36
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && ((Integer) customResponsedMessage.getData()).intValue() == 51 && FrsFragment.this.dhf != null) {
                com.baidu.tieba.frs.f.j.a(FrsFragment.this.dhf, FrsFragment.this.getPageContext());
            }
        }
    };
    private final CustomMessageListener diz = new CustomMessageListener(2003019) { // from class: com.baidu.tieba.frs.FrsFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                FrsFragment.this.dhP.ly(49);
            }
        }
    };
    private final CustomMessageListener diA = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.frs.FrsFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && FrsFragment.this.dhf != null && FrsFragment.this.dhf.bam() != null) {
                SignData signData = (SignData) customResponsedMessage.getData();
                int user_level = FrsFragment.this.dhf.bam().getUser_level();
                if (signData.forumId != null && signData.forumId.equals(FrsFragment.this.dhf.bam().getId())) {
                    FrsFragment.this.dhf.d(signData);
                    FrsFragment.this.dhO.h(FrsFragment.this.dhf);
                    if (FrsFragment.this.dhO.azv()) {
                        i = FrsFragment.this.dhf.bam().getUser_level();
                        if (user_level >= i) {
                            i++;
                        }
                    } else {
                        i = user_level;
                    }
                    TbadkCoreApplication.getInst().addSignedForum(FrsFragment.this.dhf.bam().getName(), signData.sign_bonus_point, i);
                }
            }
        }
    };
    private final CustomMessageListener diB = new CustomMessageListener(2001352) { // from class: com.baidu.tieba.frs.FrsFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.r) && FrsFragment.this.dhf != null) {
                FrsFragment.this.dhf.c((com.baidu.tieba.tbadkCore.r) customResponsedMessage.getData());
                FrsFragment.this.dhO.g(FrsFragment.this.dhf);
                FrsFragment.this.dhP.a(FrsFragment.this.dhf, FrsFragment.this.dhN.ayz());
            }
        }
    };
    private final AntiHelper.a diC = new AntiHelper.a() { // from class: com.baidu.tieba.frs.FrsFragment.5
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12536").r("obj_locate", as.a.arm));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12535").r("obj_locate", as.a.arm));
        }
    };
    private CustomMessageListener bzI = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.frs.FrsFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(FrsFragment.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().aCA != null) {
                        if (AntiHelper.a(FrsFragment.this.getActivity(), updateAttentionMessage.getData().aCA, FrsFragment.this.diC) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12534").r("obj_locate", as.a.arm));
                        }
                    } else if (updateAttentionMessage.getData().Gp && updateAttentionMessage.getData().isAttention) {
                        com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getPageContext().getPageActivity(), d.k.attention_success);
                    }
                }
            }
        }
    };
    private CustomMessageListener diD = new CustomMessageListener(2921346) { // from class: com.baidu.tieba.frs.FrsFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsFragment.this.refresh();
        }
    };
    private CustomMessageListener diE = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.frs.FrsFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                FrsFragment.this.dhC.c((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener diF = new CustomMessageListener(2001626) { // from class: com.baidu.tieba.frs.FrsFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewsRemindMessage newsRemindMessage;
            if (customResponsedMessage != null && (customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626 && (newsRemindMessage = (NewsRemindMessage) customResponsedMessage) != null) {
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (FrsFragment.this.dhC != null) {
                    FrsFragment.this.dhC.q(notificationCount, z);
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.n diG = new com.baidu.tieba.tbadkCore.n() { // from class: com.baidu.tieba.frs.FrsFragment.10
        private long startTime = 0;

        @Override // com.baidu.tieba.tbadkCore.n
        public void kf(int i) {
            this.startTime = System.nanoTime();
            if (FrsFragment.this.dhC != null) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsFragment.this.dhC.auo();
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
            if (FrsFragment.this.bEd) {
                FrsFragment.this.bEd = false;
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.dhC, FrsFragment.this.dhf, FrsFragment.this.getForumId(), false, null);
            }
            FrsFragment.this.atu();
            FrsFragment.this.dhJ = true;
            if (aVar != null && aVar.isSuccess) {
                FrsFragment.this.dhC.aux().fP(com.baidu.tbadk.core.util.aq.zq().zs());
                FrsFragment.dhE = 0L;
                FrsFragment.dhF = 0L;
                FrsFragment.dhG = 0;
            } else {
                FrsFragment.dhG = 1;
            }
            if (!FrsFragment.this.dhN.ayD() && (i == 3 || i == 6)) {
                FrsFragment.this.dhZ.resetData();
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (FrsFragment.this.dhN.axV() != null) {
                FrsFragment.this.dhf = FrsFragment.this.dhN.axV();
            }
            FrsFragment.this.dhC.b(FrsFragment.this.dhf.bvL());
            FrsFragment.this.kc(1);
            if (i == 7) {
                FrsFragment.this.kd(FrsFragment.this.dhf.bvq());
                return;
            }
            if (FrsFragment.this.dhf.uB() != null) {
                FrsFragment.this.setHasMore(FrsFragment.this.dhf.uB().ux());
            }
            FrsFragment.this.atv();
            if (i == 4) {
                if (!FrsFragment.this.dhN.ayD() && TbadkCoreApplication.getInst().isRecAppExist() && FrsFragment.this.dhN.ayt() == 1) {
                    FrsFragment.this.dhf.a(FrsFragment.this);
                }
                ArrayList<com.baidu.adp.widget.ListView.h> a2 = FrsFragment.this.dhZ.a(false, false, FrsFragment.this.dhf.getThreadList(), FrsFragment.this.dhy, false);
                if (a2 != null) {
                    FrsFragment.this.dhf.av(a2);
                    FrsFragment.this.dhf.bvU();
                    FrsFragment.this.dhC.a(a2, FrsFragment.this.dhf);
                }
                if (FrsFragment.this.dhN != null) {
                    com.baidu.tieba.frs.e.b.a(FrsFragment.this.dhf, FrsFragment.this.dhN.ayz(), 2);
                }
                FrsFragment.this.aSW = System.currentTimeMillis() - currentTimeMillis;
                return;
            }
            switch (i) {
                case 1:
                    FrsFragment.this.dhC.auo();
                    break;
                case 2:
                    FrsFragment.this.dhC.auo();
                    break;
                case 3:
                case 6:
                    if (FrsFragment.this.dhf != null) {
                        FrsFragment.this.dhf.bvS();
                    }
                    if (FrsFragment.this.die != null) {
                        FrsFragment.this.die.refresh();
                        break;
                    }
                    break;
            }
            FrsFragment.this.atw();
            if (aVar == null || aVar.errorCode == 0) {
                if (FrsFragment.this.dhf != null) {
                    FrsFragment.this.t(false, i == 5);
                    FrsFragment.this.dhC.kl(i);
                    FrsFragment.dhE = (System.nanoTime() - this.startTime) / 1000000;
                    if (aVar != null) {
                        FrsFragment.dhF = aVar.gFN;
                    }
                } else {
                    return;
                }
            } else if (FrsFragment.this.dhf == null || com.baidu.tbadk.core.util.w.z(FrsFragment.this.dhf.getThreadList())) {
                FrsFragment.this.a(aVar);
            } else if (aVar.gFM) {
                FrsFragment.this.showToast(FrsFragment.this.getPageContext().getResources().getString(d.k.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
            }
            if (FrsFragment.this.dhf.bva() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11384"));
            }
            if (FrsFragment.this.cSd > -1 && !FrsFragment.this.dil) {
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.dhN, FrsFragment.this.cSd);
                FrsFragment.this.cSd = -1L;
                FrsFragment.this.dil = true;
            }
            if (FrsFragment.this.dhz && FrsFragment.this.dhP.ly(49)) {
                FrsFragment.this.dhz = false;
            }
            FrsFragment.this.aSW = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void b(com.baidu.tieba.tbadkCore.i iVar) {
            if (iVar != null) {
                if ("normal_page".equals(FrsFragment.this.dhN.ayp()) || "frs_page".equals(FrsFragment.this.dhN.ayp()) || "book_page".equals(FrsFragment.this.dhN.ayp())) {
                    FrsFragment.this.a(iVar);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001615, iVar));
                }
            }
        }
    };
    private final CustomMessageListener diH = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.frs.FrsFragment.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.i) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                FrsFragment.this.dhf.a((com.baidu.tbadk.data.i) customResponsedMessage.getData());
                FrsFragment.this.dhC.aux().notifyDataSetChanged();
            }
        }
    };
    private final CustomMessageListener mMemListener = new CustomMessageListener(2001194) { // from class: com.baidu.tieba.frs.FrsFragment.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && FrsFragment.this.dhf != null && (userData = FrsFragment.this.dhf.getUserData()) != null) {
                userData.setIsMem(num.intValue());
                if (num.intValue() != 0) {
                    FrsFragment.this.dhO.g(num);
                }
            }
        }
    };
    private final com.baidu.tieba.frs.mc.i diI = new com.baidu.tieba.frs.mc.i() { // from class: com.baidu.tieba.frs.FrsFragment.16
        @Override // com.baidu.tieba.frs.mc.i
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.h> arrayList, boolean z3) {
            if (FrsFragment.this.dhR != null && FrsFragment.this.dhN != null && FrsFragment.this.dhN.ayD() && z && !z2 && !z3) {
                FrsFragment.this.dhR.ld(i2);
            }
        }
    };
    public final View.OnTouchListener aVI = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.FrsFragment.17
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (FrsFragment.this.dih != null) {
                FrsFragment.this.dih.onTouch(view, motionEvent);
            }
            if (FrsFragment.this.dhT != null && FrsFragment.this.dhT.auO() != null) {
                FrsFragment.this.dhT.auO().onTouchEvent(motionEvent);
            }
            if (FrsFragment.this.bCQ != null) {
                FrsFragment.this.bCQ.d(view, motionEvent);
            }
            if (FrsFragment.this.dhO != null) {
                FrsFragment.this.dhO.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private final CustomMessageListener diJ = new CustomMessageListener(2004507) { // from class: com.baidu.tieba.frs.FrsFragment.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "photolive_hostLevel", -1) != -1 && FrsFragment.this.dhf.bam() != null) {
                FrsFragment.this.dhf.bam().setCanAddPhotoLivePost(true);
            }
        }
    };
    public final View.OnClickListener diK = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.22
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsFragment.this.dhC == null || view != FrsFragment.this.dhC.aum() || FrsFragment.this.getActivity() == null) {
                if (FrsFragment.this.dhf != null && FrsFragment.this.dhf.bam() != null && FrsFragment.this.dhC != null && view == FrsFragment.this.dhC.aus()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12402").ah(ImageViewerConfig.FORUM_ID, FrsFragment.this.dhf.bam().getId()).ah("uid", TbadkCoreApplication.getCurrentAccount()).ah(ImageViewerConfig.FORUM_NAME, FrsFragment.this.dhf.bam().getName()));
                    if (!StringUtils.isNull(FrsFragment.this.dhf.bam().getName())) {
                        FrsFragment.this.sendMessage(new CustomMessage(2002001, new PostSearchActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), FrsFragment.this.dhf.bam().getName(), FrsFragment.this.dhf.bam().getId())));
                        return;
                    }
                    return;
                }
                if (view.getId() == d.g.game_activity_egg_layout && com.baidu.adp.lib.util.l.jU()) {
                    TiebaStatic.log("c10853");
                    if (FrsFragment.this.dhC.auu()) {
                        FrsFragment.this.dhC.auv();
                    } else {
                        String activityUrl = FrsFragment.this.dhf.bam().getYuleData().wT().getActivityUrl();
                        if (!StringUtils.isNull(activityUrl)) {
                            com.baidu.tbadk.browser.a.Q(FrsFragment.this.getPageContext().getPageActivity(), activityUrl);
                        }
                    }
                }
                if (view == FrsFragment.this.dhC.auB() && FrsFragment.this.dhN != null && FrsFragment.this.dhN.hasMore()) {
                    FrsFragment.this.dhC.TJ();
                    FrsFragment.this.SJ();
                }
                if (view != null && view == FrsFragment.this.dhC.aut() && ba.aU(FrsFragment.this.getContext())) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12924").r("obj_locate", 2));
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
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.FrsFragment.24
        private int diQ = 0;
        private int brT = 0;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (FrsFragment.this.dhX != null) {
                FrsFragment.this.dhX.aza();
            }
            this.diQ = 0;
            this.brT = 0;
            if (recyclerView != null && (recyclerView instanceof BdRecyclerView)) {
                this.diQ = ((BdRecyclerView) recyclerView).getFirstVisiblePosition();
                this.brT = ((BdRecyclerView) recyclerView).getLastVisiblePosition();
            }
            if (FrsFragment.this.dij != null) {
                FrsFragment.this.dij.a(recyclerView, this.diQ, this.brT);
            }
            if (FrsFragment.this.dhf != null && FrsFragment.this.dhC != null && FrsFragment.this.dhC.aux() != null) {
                FrsFragment.this.dhC.aA(this.diQ, this.brT);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (FrsFragment.this.dhO != null) {
                FrsFragment.this.dhO.setScrollState(i);
            }
            if ((i == 2 || i == 1) && !FrsFragment.this.dhK) {
                FrsFragment.this.dhK = true;
                FrsFragment.this.dhC.auz();
            }
            if (FrsFragment.this.dhL == null && !FrsFragment.this.atK()) {
                FrsFragment.this.dhL = new com.baidu.tbadk.k.b();
                FrsFragment.this.dhL.fk(1000);
            }
            if (i == 0) {
                if (FrsFragment.this.dhL != null) {
                    FrsFragment.this.dhL.Kj();
                }
                com.baidu.tieba.card.v.ajh().ey(true);
                FrsFragment.this.dhC.az(this.diQ, this.brT);
            } else if (FrsFragment.this.dhL != null) {
                FrsFragment.this.dhL.Ki();
            }
            if (FrsFragment.this.dij != null) {
                FrsFragment.this.dij.onScrollStateChanged(recyclerView, i);
            }
            if (i == 0) {
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.dhC, FrsFragment.this.dhf, FrsFragment.this.getForumId(), false, null);
            }
            if (FrsFragment.this.dhP != null && i == 1) {
                FrsFragment.this.dhP.azD();
            }
        }
    };
    private final b diL = new b() { // from class: com.baidu.tieba.frs.FrsFragment.25
        @Override // com.baidu.tieba.frs.b
        public void a(int i, int i2, View view, View view2, bd bdVar) {
            if (i != FrsFragment.this.dhC.aux().avS()) {
                if (i != FrsFragment.this.dhC.aux().avT()) {
                    if (i == FrsFragment.this.dhC.aux().avU() && FrsFragment.this.dhf != null && FrsFragment.this.dhf.getUserData() != null && FrsFragment.this.dhf.getUserData().isBawu()) {
                        String bvo = FrsFragment.this.dhf.bvo();
                        if (!com.baidu.tbadk.core.util.ao.isEmpty(bvo) && FrsFragment.this.dhf.bam() != null) {
                            com.baidu.tbadk.browser.a.O(FrsFragment.this.getPageContext().getPageActivity(), bvo);
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10502").ah(ImageViewerConfig.FORUM_ID, FrsFragment.this.dhf.bam().getId()).ah("uid", FrsFragment.this.dhf.getUserData().getUserId()));
                        }
                    }
                } else if (ba.aU(FrsFragment.this.getPageContext().getPageActivity())) {
                    TiebaStatic.log("my_service_ck");
                    if (FrsFragment.this.dhf != null && FrsFragment.this.dhf.bam() != null) {
                        ForumData bam = FrsFragment.this.dhf.bam();
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(bam.getId(), 0L), bam.getName(), bam.getImage_url(), 0)));
                    }
                }
            } else if (ba.aU(FrsFragment.this.getActivity())) {
                TiebaStatic.log("forum_fortune_click");
                com.baidu.tieba.frs.f.i.b(FrsFragment.this.getPageContext(), FrsFragment.this.dhf);
            }
        }
    };
    private final NoNetworkView.a dfy = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.FrsFragment.26
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aQ(boolean z) {
            if (FrsFragment.this.dhN.ayt() == 1 && z && !FrsFragment.this.dhC.atJ()) {
                if (FrsFragment.this.dhf == null || com.baidu.tbadk.core.util.w.z(FrsFragment.this.dhf.getThreadList())) {
                    FrsFragment.this.hideNetRefreshView(FrsFragment.this.dhC.adh());
                    FrsFragment.this.showLoadingView(FrsFragment.this.dhC.adh(), true);
                    FrsFragment.this.dhC.fB(false);
                    FrsFragment.this.refresh();
                    return;
                }
                FrsFragment.this.dhC.auo();
            }
        }
    };
    private final CustomMessageListener aDd = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.FrsFragment.27
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                com.baidu.tieba.frs.f.c.a(customResponsedMessage, FrsFragment.this.dhC, FrsFragment.this.dhf);
            }
        }
    };
    private com.baidu.adp.widget.ListView.n diM = new a();
    private aj diN = new aj() { // from class: com.baidu.tieba.frs.FrsFragment.28
        @Override // com.baidu.tieba.frs.aj
        public void a(int i, int i2, ap apVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
            com.baidu.adp.lib.g.e.im().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.28.1
                @Override // java.lang.Runnable
                public void run() {
                    if (FrsFragment.this.dhC != null && FrsFragment.this.dhC.akc()) {
                        FrsFragment.this.SJ();
                    }
                }
            });
        }
    };
    private CustomMessageListener diO = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.frs.FrsFragment.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    FrsFragment.this.dik = true;
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.frs.loadmore.a
    public /* bridge */ /* synthetic */ com.baidu.adp.base.e getPageContext() {
        return super.getPageContext();
    }

    public com.baidu.tieba.frs.entelechy.b.b ati() {
        return this.dhV;
    }

    public com.baidu.adp.widget.ListView.n atj() {
        return this.diM;
    }

    public com.baidu.tieba.frs.mc.d atk() {
        return this.dhY;
    }

    public com.baidu.tieba.frs.smartsort.b atl() {
        return this.dhR;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public FrsModelController atm() {
        return this.dhN;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public com.baidu.tieba.frs.mc.c atn() {
        return this.dhZ;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public com.baidu.tieba.frs.vc.f ato() {
        return this.dhO;
    }

    public com.baidu.tieba.frs.vc.j atp() {
        return this.dhP;
    }

    public al atq() {
        return this.dhT;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public i atr() {
        return this.dhC;
    }

    @Override // com.baidu.tieba.frs.ak
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.ak, com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.dhv;
    }

    public void setForumName(String str) {
        this.dhv = str;
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
        if (this.dhZ == null) {
            return 1;
        }
        return this.dhZ.getPn();
    }

    public int getPn() {
        if (this.dhZ == null) {
            return 1;
        }
        return this.dhZ.getPn();
    }

    public void setPn(int i) {
        if (this.dhZ != null) {
            this.dhZ.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.dhZ != null) {
            this.dhZ.setHasMore(i);
        }
    }

    public int ats() {
        if (this.dhZ == null) {
            return -1;
        }
        return this.dhZ.ats();
    }

    public boolean att() {
        return this.dhA;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d.a aVar) {
        if (aVar == null) {
            String string = TbadkCoreApplication.getInst().getString(d.k.error_unkown_try_again);
            this.dhC.auj();
            showNetRefreshView(this.dhC.adh(), string, true);
        } else if (340001 == aVar.errorCode) {
            a(aVar, this.dhf.buX());
        } else {
            if (com.baidu.tbadk.core.util.w.z(this.dhf.getThreadList())) {
                b(aVar);
            }
            if (atK()) {
                setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst(), d.e.ds280));
            } else {
                setNetRefreshViewEmotionDefMarginTop();
            }
        }
    }

    public void a(View view, String str, boolean z, List<RecmForumInfo> list) {
        this.dhC.auj();
        this.dhC.kj(8);
        if (this.dii == null) {
            this.dii = new com.baidu.tieba.frs.view.a(getPageContext(), getNetRefreshListener());
        }
        this.dii.setSubText(str);
        this.dii.by(list);
        this.dii.d(view, z);
    }

    private void a(d.a aVar, List<RecmForumInfo> list) {
        if (this.dhC != null) {
            this.dhC.auj();
            this.dhC.setTitle(this.dhv);
            a(this.dhC.adh(), aVar.errorMsg, true, list);
        }
    }

    private void b(d.a aVar) {
        this.dhC.auj();
        if (aVar.gFM) {
            showNetRefreshView(this.dhC.adh(), TbadkCoreApplication.getInst().getString(d.k.net_error_text, new Object[]{aVar.errorMsg, Integer.valueOf(aVar.errorCode)}), true);
        } else {
            showNetRefreshView(this.dhC.adh(), aVar.errorMsg, true);
        }
    }

    public void atu() {
        hideLoadingView(this.dhC.adh());
        if (!this.dhC.atJ()) {
            this.dhC.fC(false);
        } else {
            this.dhC.fC(true);
        }
        if (this.dhC.auh() instanceof com.baidu.tieba.frs.tab.c) {
            ((com.baidu.tieba.frs.tab.c) this.dhC.auh()).ayU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atv() {
        if (ats() == 0 && com.baidu.tbadk.core.util.w.z(this.dhf.bvg())) {
            if (com.baidu.tbadk.core.util.w.z(this.dhf.getThreadList())) {
                this.dhC.TL();
            } else {
                this.dhC.TK();
            }
        } else if (com.baidu.tbadk.core.util.w.y(this.dhf.getThreadList()) > 3) {
            this.dhC.TJ();
        } else {
            this.dhC.auA();
        }
    }

    public void a(ErrorData errorData) {
        atu();
        this.dhC.auo();
        d.a ayq = this.dhN.ayq();
        boolean z = com.baidu.tbadk.core.util.w.z(this.dhf.getThreadList());
        if (ayq != null && z) {
            if (this.dhN.ayr() != 0) {
                this.dhN.ayx();
                this.dhC.auo();
            } else {
                a(ayq);
            }
            this.dhC.u(this.dhf.bwj(), false);
            return;
        }
        a(ayq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kc(int i) {
        List<WindowToast> list;
        if (TbadkCoreApplication.isLogin() && this.dhf != null && (list = this.dhf.gHn) != null && list.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < list.size()) {
                    WindowToast windowToast = list.get(i3);
                    if (windowToast == null || windowToast.toast_type.intValue() != i) {
                        i2 = i3 + 1;
                    } else if (!com.baidu.tbadk.core.util.ao.isEmpty(windowToast.toast_link)) {
                        sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(getPageContext().getPageActivity(), "", com.baidu.tbadk.util.aa.hK(windowToast.toast_link), true)));
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
    public void atw() {
        if (this.dhf == null || this.dhf.bam() != null) {
            this.dhC.auw();
        } else if (this.dhf.bam().getYuleData() != null && this.dhf.bam().getYuleData().wS()) {
            TiebaStatic.log("c10852");
            this.dhC.a(this.dhf.bam().getYuleData().wT());
        } else {
            this.dhC.auw();
        }
    }

    private void s(boolean z, boolean z2) {
        if (this.dhN != null && this.dhf != null && this.dhC != null && z) {
            if (!this.dhN.ayD() && this.dhN.ayt() == 1) {
                if (!this.dhN.ayB()) {
                    this.dhf.bvZ();
                    this.dhf.bwa();
                }
                boolean z3 = false;
                if (this.dhC.aux().k(com.baidu.tieba.card.data.n.cBX)) {
                    z3 = this.dhf.bwd();
                }
                if (!z3) {
                    this.dhf.bwb();
                }
                if (TbadkCoreApplication.getInst().isRecAppExist()) {
                    this.dhf.a(this);
                }
                if (!this.dhC.aux().k(bd.ahN)) {
                    this.dhf.bvT();
                }
                this.dhf.bwe();
            }
            if (!this.dhC.aux().k(bd.ahN)) {
                this.dhf.bvY();
                this.dhf.bvW();
            } else {
                this.dhf.bvX();
                this.dhf.bvV();
            }
            this.dhf.bvU();
            this.dhf.bvR();
            if (this.dhC.aux().k(com.baidu.tieba.h.b.dHk)) {
                this.dhf.mt(z2);
            }
            if (TbadkCoreApplication.isLogin() && (!this.dhN.ayD() || this.dhN.isNetFirstLoad)) {
                this.dhf.bwf();
            }
            this.dhf.bwh();
        }
    }

    public boolean atx() {
        if (this.dhO != null && this.dhN != null) {
            this.dhO.a(this.dhN.ayp(), this.dhf);
        }
        boolean z = false;
        if (this.dhf != null) {
            z = this.dhf.bwk();
        }
        atz();
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kd(int i) {
        am amVar = null;
        atx();
        atG();
        try {
            if (this.dhf != null) {
                this.dhC.a((ArrayList<com.baidu.adp.widget.ListView.h>) null, this.dhf);
                this.dhO.lt(1);
                this.dhC.aur();
                this.dhP.a(this.dhf, this.dhN.ayz());
                com.baidu.tieba.frs.tab.d lz = this.dhP.lz(this.dhf.bvq());
                if (lz != null && !TextUtils.isEmpty(lz.url)) {
                    amVar = new am();
                    amVar.dkO = lz.url;
                    amVar.stType = lz.name;
                }
                this.dhN.a(this.dhf.bvq(), 0, amVar);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(boolean z, boolean z2) {
        try {
            if (this.dhf != null && this.dhP != null && this.dhN != null) {
                if (!this.dhC.aux().k(bd.ahN)) {
                    this.dhf.bvT();
                }
                boolean z3 = com.baidu.tbadk.core.util.w.z(this.dhf.bvE());
                this.dhC.fz(z3);
                if (!z3) {
                    if (this.dij == null) {
                        this.dij = new com.baidu.tieba.frs.vc.e(this, (NoPressedRelativeLayout) this.mRootView);
                    }
                    if (this.bCQ == null) {
                        this.bCQ = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
                    }
                } else {
                    this.dij = null;
                    this.bCQ = null;
                }
                if (this.dhf.bam() != null) {
                    this.dhv = this.dhf.bam().getName();
                    this.forumId = this.dhf.bam().getId();
                }
                if (this.dhf.bwk()) {
                    this.dhP.a(this.dhf, this.dhN.ayz());
                }
                if (z) {
                    s(true, z);
                } else {
                    s(this.dhM, z);
                }
                atx();
                if (this.dhV != null) {
                    this.dhV.a(this.dhO, this.dhf);
                }
                if (this.dhf.uB() != null) {
                    setHasMore(this.dhf.uB().ux());
                }
                ArrayList<com.baidu.adp.widget.ListView.h> a2 = this.dhZ.a(z2, true, this.dhf.getThreadList(), null, z, false);
                if (a2 != null) {
                    this.dhf.av(a2);
                }
                this.dhf.bwg();
                if (this.dhN.ayt() == 1) {
                    atD();
                    if (!z && this.dhN.getPn() == 1) {
                        aty();
                    }
                }
                this.dhi = this.dhf.ayv();
                if (this.dhy != null) {
                    this.dhx = true;
                    this.dhy.tv(this.dhi);
                    com.baidu.tieba.frs.f.a.a(this, this.dhf.bam(), this.dhf.getThreadList(), this.dhx, getPn());
                }
                if (this.dhX != null) {
                    this.dhX.ax(this.dhP.azA());
                }
                atu();
                this.dhC.auk();
                this.dhC.u(true, false);
                if (this.dhf.bam() != null) {
                    this.dhC.mv(this.dhf.bam().getWarningMsg());
                }
                if (this.dhf != null && this.dhf.bvH() != null && com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("frs_video_activity_guide", 0L) == 0) {
                    com.baidu.adp.lib.g.e.im().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.11
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsFragment.this.dhC.auF();
                        }
                    }, 1000L);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2921326, this));
                this.dhC.aud();
                if (this.dhf != null && this.dhf.bam() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016564, new VisitedForumData(this.dhf.bam().getId(), this.dhf.bam().getName(), this.dhf.bam().getImage_url(), String.valueOf(System.currentTimeMillis() / 1000), "showlive".equals(this.dhf.bam().special_forum_type))));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void aty() {
        if (this.dic == null) {
            this.dic = new com.baidu.tieba.frs.live.a(this, com.baidu.adp.lib.g.b.g(this.forumId, 0));
        }
        this.dic.ayc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.i iVar) {
        try {
            if (!this.dhJ && iVar != null && this.dhf != null) {
                this.dhf.e(iVar);
                t(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void atz() {
        if (this.dhN != null) {
            mt(this.dhN.ayp());
        } else {
            mt("normal_page");
        }
    }

    private void mt(String str) {
        ft("frs_page".equals(str));
        if (this.dhV != null) {
            this.dhV.a(this.dhO, this.dhC, this.dhf);
        }
    }

    public void ft(boolean z) {
        if (this.dia != null) {
            this.dia.c(this.dhC, z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(d.i.frs_activity, viewGroup, false);
            this.dhp = new com.baidu.tieba.frs.entelechy.b();
            this.dhV = this.dhp.avv();
            this.dhO = new com.baidu.tieba.frs.vc.f(this, this.dhp, (FrsHeaderViewContainer) this.mRootView.findViewById(d.g.header_view_container));
            this.dhP = new FrsTabViewController(this, this.mRootView);
            this.dhO.a(this.dhP);
            this.dhP.a(this.diw);
            Intent intent = getActivity().getIntent();
            if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                this.dhr = true;
            }
            this.dhC = new i(this, this.diK, this.dhp, this.dhr, this.dhO);
            this.dhC.setHeaderViewHeight(this.dig);
        } else {
            if (this.mRootView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            this.dhP.resetData();
            this.dhC.auE();
        }
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        this.cSd = System.currentTimeMillis();
        this.beginTime = this.cSd;
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.dhz = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.cSd = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            I(intent);
        }
        this.aSO = this.beginTime - this.cSd;
        this.dhy = new com.baidu.tieba.tbadkCore.data.e("frs", com.baidu.tieba.tbadkCore.data.e.gIu);
        this.dhN = new FrsModelController(this, this.diG);
        this.dhN.a(this.div);
        this.dhN.init();
        if (intent != null) {
            this.dhN.i(intent.getExtras());
        } else if (bundle != null) {
            this.dhN.i(bundle);
        } else {
            this.dhN.i(null);
        }
        if (intent != null) {
            this.dhO.m(intent.getExtras());
        } else if (bundle != null) {
            this.dhO.m(bundle);
        } else {
            this.dhO.m((Bundle) null);
        }
        this.dhB = getVoiceManager();
        this.did = new h(getPageContext(), this);
        initUI();
        initData(bundle);
        if (this.mFrom != null && this.mFrom.equals("from_tieba_kuang")) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12264").r("obj_type", 1).ah(ImageViewerConfig.FORUM_NAME, this.dhN.getForumName()));
            KuangFloatingViewController.getInstance().setNeedShowFloatingView(true);
            if (KuangFloatingViewController.getInstance().init()) {
                ((BaseFragmentActivity) getPageContext().getOrignalPage()).grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.frs.FrsFragment.15
                    @Override // com.baidu.tbadk.core.e
                    public void an(boolean z) {
                        if (z) {
                            KuangFloatingViewController.getInstance().showFloatingView();
                        }
                    }
                });
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SCHEMA_UPLOAD);
                httpMessage.addParam("call_url", com.baidu.adp.lib.util.k.be("shoubai://internal?type=frs&param=" + this.dhv));
                MessageManager.getInstance().sendMessage(httpMessage);
            }
        }
        if (!atK()) {
            this.dhT = new al(getActivity(), this.dhC, this.dhO);
            this.dhT.fI(true);
        }
        this.dhB = getVoiceManager();
        if (this.dhB != null) {
            this.dhB.onCreate(getPageContext());
        }
        new com.baidu.tieba.frs.mc.g();
        this.dhZ = new com.baidu.tieba.frs.mc.c(this, this.diI);
        this.dhR = new com.baidu.tieba.frs.smartsort.b(this);
        this.dia = new com.baidu.tieba.frs.vc.h(this);
        this.dhX = new com.baidu.tieba.frs.vc.a(getPageContext(), this.dhN.ayA());
        this.dhS = new com.baidu.tieba.frs.mc.b(this);
        this.dhY = new com.baidu.tieba.frs.mc.d(this);
        this.dhQ = new com.baidu.tieba.frs.mc.f(this);
        this.dib = new com.baidu.tieba.frs.mc.a(this);
        this.die = new com.baidu.tieba.frs.vc.c(this);
        this.dif = new com.baidu.tieba.frs.mc.e(this, getUniqueId());
        this.dim = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "frs");
        this.din = new com.baidu.tieba.ala.a(getPageContext());
        registerListener(this.bzI);
        registerListener(this.mMemListener);
        registerListener(this.diB);
        registerListener(this.diJ);
        registerListener(this.diA);
        registerListener(this.diH);
        registerListener(this.dix);
        registerListener(this.diy);
        registerListener(this.diz);
        registerListener(this.dis);
        registerListener(this.dit);
        registerListener(this.diO);
        registerListener(this.diE);
        registerListener(this.diu);
        registerListener(this.diF);
        registerListener(this.diD);
        this.dir.setTag(getPageContext().getUniqueId());
        registerListener(this.dir);
        this.dhC.fB(false);
        if (!atK()) {
            showLoadingView(this.dhC.adh(), true);
            this.dhN.t(3, true);
        }
        super.onActivityCreated(bundle);
        this.createTime = System.currentTimeMillis() - this.beginTime;
    }

    @Override // com.baidu.tieba.frs.af
    public void Tl() {
        if (isAdded() && this.bEd && !isLoadingViewAttached()) {
            showLoadingView(this.dhC.adh(), true);
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void Tm() {
        if (isAdded() && this.bEd && isLoadingViewAttached()) {
            hideLoadingView(this.dhC.adh());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (atK()) {
            showLoadingView(this.dhC.adh(), true);
            this.dhC.kk(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.dhN.t(3, true);
            AJ().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void setHeaderViewHeight(int i) {
        this.dig = i;
        if (this.dhC != null) {
            this.dhC.setHeaderViewHeight(this.dig);
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.t tVar) {
        if (tVar != null) {
            this.aVH = tVar.Lh();
            this.dih = tVar.Li();
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void showFloatingView() {
        if (this.aVH != null) {
            this.aVH.cd(true);
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
            this.dhv = data.getQueryParameter("name");
            this.mFrom = data.getQueryParameter("from");
            if (!StringUtils.isNull(this.dhv)) {
                intent.putExtra("name", this.dhv);
            }
            if (!StringUtils.isNull(this.mFrom)) {
                intent.putExtra("from", this.mFrom);
            }
            TiebaStatic.log("c10105");
        }
        if (StringUtils.isNull(this.dhv)) {
            com.baidu.tieba.frs.f.d K = com.baidu.tieba.frs.f.i.K(intent);
            if (K != null) {
                this.dhv = K.forumName;
                if (K.dzK != null && K.dzK.equals("aidou")) {
                    com.baidu.tbadk.core.dialog.h.aly = System.currentTimeMillis();
                }
            }
            if (!StringUtils.isNull(this.dhv)) {
                intent.putExtra("name", this.dhv);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.dhB = getVoiceManager();
        if (this.dhB != null) {
            this.dhB.onStart(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        Intent intent;
        registerListener(2001118, this.aDd);
        if (bundle != null) {
            this.dhv = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
            this.dhv = intent.getStringExtra("name");
            this.mFrom = intent.getStringExtra("from");
            this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
        }
        if (TextUtils.isEmpty(this.mFrom) || FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
        }
        if (this.mIsLogin) {
            registerListener(2001120, this.aDd);
        }
        this.dhO.m(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.diO);
        if (this.dhB != null) {
            this.dhB.onDestory(getPageContext());
        }
        this.dhB = null;
        com.baidu.tieba.card.v.ajh().ey(false);
        if (this.dhf != null && this.dhf.bam() != null) {
            aa.auL().bG(com.baidu.adp.lib.g.b.c(this.dhf.bam().getId(), 0L));
        }
        if (this.dic != null) {
            this.dic.onDestory();
        }
        if (this.dhC != null) {
            com.baidu.tieba.frs.f.h.a(this.dhC, this.dhf, getForumId(), false, null);
            this.dhC.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.dhL != null) {
                this.dhL.Kk();
            }
            this.dhC.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.dhN.onActivityDestroy();
        this.dhO.onActivityDestroy();
        if (this.dhN != null) {
            this.dhN.UT();
        }
        if (this.dhT != null) {
            this.dhT.Lg();
        }
        if (this.dhW != null) {
            this.dhW.destory();
        }
        if (this.dhX != null) {
            this.dhX.destory();
        }
        if (this.dhR != null) {
            this.dhR.onDestroy();
        }
        if (this.dij != null) {
            this.dij.onDestory();
        }
        if (this.dib != null) {
            this.dib.onDestroy();
        }
        if (this.dim != null) {
            this.dim.onDestroy();
        }
        if (this.din != null) {
            this.din.onDestroy();
        }
        com.baidu.tieba.recapp.d.a.boX().boZ();
        com.baidu.tieba.frs.f.j.ayX();
        if (this.dhP != null) {
            this.dhP.a((FrsTabViewController.a) null);
            this.dhP.azD();
        }
        if (this.dio != null) {
            this.dio.onDestroy();
        }
        if (this.dip != null) {
            this.dip.onDestroy();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.dhv);
        bundle.putString("from", this.mFrom);
        this.dhN.onSaveInstanceState(bundle);
        if (this.dhB != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            this.dhB.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.dib != null) {
            this.dib.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dhC != null) {
            this.dhC.auo();
            this.dhC.onResume();
        }
        this.dhQ.ga(true);
        this.dhM = true;
        if (dhu) {
            dhu = false;
            this.dhC.startPullRefresh();
            return;
        }
        if (this.dhB != null) {
            this.dhB.onResume(getPageContext());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921338));
        this.dhC.fD(false);
        if (this.dik) {
            refresh(6);
            this.dik = false;
        }
        if (KuangFloatingViewController.getInstance().init()) {
            ((BaseFragmentActivity) getPageContext().getOrignalPage()).grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.frs.FrsFragment.19
                @Override // com.baidu.tbadk.core.e
                public void an(boolean z) {
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
        refresh();
    }

    public boolean atA() {
        Intent intent;
        if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
            return false;
        }
        return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
    }

    public void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.dhv = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.dhw = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.dhw) {
                atB();
            }
            if (this.mFrom != null && this.mFrom.equals("from_tieba_kuang")) {
                KuangFloatingViewController.getInstance().setNeedShowFloatingView(true);
                if (KuangFloatingViewController.getInstance().init()) {
                    ((BaseFragmentActivity) getPageContext().getOrignalPage()).grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.frs.FrsFragment.20
                        @Override // com.baidu.tbadk.core.e
                        public void an(boolean z) {
                            if (z) {
                                KuangFloatingViewController.getInstance().showFloatingView();
                            }
                        }
                    });
                }
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SCHEMA_UPLOAD);
                httpMessage.addParam("call_url", com.baidu.adp.lib.util.k.be("shoubai://internal?type=frs&param=" + this.dhv));
                MessageManager.getInstance().sendMessage(httpMessage);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atB() {
        this.dhC.startPullRefresh();
    }

    public void closeActivity() {
        com.baidu.tieba.frs.f.i.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.mFrom);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.dhC.setTitle(this.dhv);
        } else {
            this.dhC.setTitle("");
            this.mFlag = 1;
        }
        this.dhC.setOnAdapterItemClickListener(this.diM);
        this.dhC.addOnScrollListener(this.mScrollListener);
        this.dhC.h(this.dfy);
        this.dhC.aux().a(this.diL);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dhC.onChangeSkinType(i);
        this.dhO.ls(i);
        this.dhP.onChangeSkinType(i);
        if (this.dii != null) {
            this.dii.onChangeSkinType();
        }
        if (this.dio != null) {
            this.dio.onChangeSkinType(i);
        }
    }

    public void ke(int i) {
        if (!this.mIsLogin) {
            if (this.dhf != null && this.dhf.uo() != null) {
                this.dhf.uo().setIfpost(1);
            }
            if (i == 0) {
                ba.aT(getActivity());
            }
        } else if (this.dhf != null) {
            if (i == 0) {
                com.baidu.tieba.frs.f.j.c(this, 0);
            } else {
                this.dhC.auq();
            }
        }
    }

    public void refresh() {
        com.baidu.tieba.a.d.Qe().ix("page_frs");
        refresh(3);
    }

    public void refresh(int i) {
        this.dhJ = false;
        atG();
        if (this.dhC.aug() != null) {
            this.dhC.aug().aDT();
        }
        this.dhN.t(i, true);
    }

    private void atC() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.g.h.in().d(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.21
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.tU(FrsFragment.this.dhv);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atD() {
        atG();
        try {
            if (this.dhf != null) {
                this.dhC.showListView();
                this.dhC.fy(this.dhN.ayu());
                if (!com.baidu.tieba.frs.vc.f.j(this.dhf) || !com.baidu.tieba.frs.vc.f.i(this.dhf)) {
                }
                if (this.dhf.bam() != null) {
                    this.dhv = this.dhf.bam().getName();
                    this.forumId = this.dhf.bam().getId();
                }
                if (this.dhf.uB() != null) {
                    setHasMore(this.dhf.uB().ux());
                }
                this.dhC.setTitle(this.dhv);
                this.dhC.setForumName(this.dhv);
                TbadkCoreApplication.getInst().setDefaultBubble(this.dhf.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.dhf.getUserData().getBimg_end_time());
                atC();
                atE();
                ArrayList<com.baidu.adp.widget.ListView.h> threadList = this.dhf.getThreadList();
                if (threadList != null) {
                    this.dhC.a(threadList, this.dhf);
                    com.baidu.tieba.frs.f.c.v(this.dhC);
                    this.dhO.lt(getPageNum());
                    this.dhO.g(this.dhf);
                    this.dhP.a(this.dhf, this.dhN.ayz());
                    this.dhC.aur();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void atE() {
        if (this.dhf != null) {
            if (this.dhf.baB() == 1) {
                this.dhC.aux().setFromCDN(true);
            } else {
                this.dhC.aux().setFromCDN(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.dhQ.ga(false);
        this.dhM = false;
        this.dhC.onPause();
        if (this.dhB != null) {
            this.dhB.onPause(getPageContext());
        }
        this.dhC.fD(true);
        if (this.dhX != null) {
            this.dhX.aza();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.dhP != null && this.dhP.azB() != null && (this.dhP.azB().fragment instanceof BaseFragment)) {
            ((BaseFragment) this.dhP.azB().fragment).setPrimary(z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.v.ajh().ey(false);
        if (this.dhf != null && this.dhf.bam() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            com.baidu.tbadk.distribute.a.GR().a(getPageContext().getPageActivity(), "frs", this.dhf.bam().getId(), 0L);
        }
        if (this.dhB != null) {
            this.dhB.onStop(getPageContext());
        }
        if (AJ() != null) {
            AJ().getRecycledViewPool().clear();
        }
        this.dhO.onActivityStop();
        com.baidu.tbadk.util.u.Lk();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            if (this.dhO != null) {
                this.dhO.fw(isPrimary());
            }
            if (this.dhC != null) {
                this.dhC.fw(isPrimary());
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || this.dhC == null) {
            return false;
        }
        return this.dhC.aun();
    }

    @Override // com.baidu.tieba.recapp.n
    public TbPageContext<?> aiH() {
        return getPageContext();
    }

    @Override // com.baidu.tieba.recapp.n
    public void a(AdvertAppInfo advertAppInfo, String str) {
        com.baidu.tbadk.distribute.a.GR().a(advertAppInfo, this.forumId, 0L, "FRS", str, getPn());
    }

    @Override // com.baidu.tieba.recapp.n
    public void atF() {
        atm().atF();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dhB == null) {
            this.dhB = VoiceManager.instance();
        }
        return this.dhB;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdRecyclerView AJ() {
        if (this.dhC == null) {
            return null;
        }
        return this.dhC.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void atG() {
        if (this.dhB != null) {
            this.dhB.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> AK() {
        if (this.ayn == null) {
            this.ayn = UserIconBox.h(getPageContext().getPageActivity(), 8);
        }
        return this.ayn;
    }

    public void atH() {
        if (getFragmentActivity() != null && getFragmentActivity().getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.b(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.k onGetPreLoadListView() {
        return AJ().getPreLoadHandle();
    }

    @Override // com.baidu.tieba.frs.ai
    public NavigationBar UB() {
        if (this.dhC == null) {
            return null;
        }
        return this.dhC.UB();
    }

    @Override // com.baidu.tbadk.core.view.NavigationBar.a
    public void b(Pair<Integer, Integer> pair) {
        this.dhH = pair;
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
                if (bdUniqueId == n.dkb) {
                    if (FrsFragment.this.dhC != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11752").ah(ImageViewerConfig.FORUM_ID, FrsFragment.this.forumId).ah("obj_locate", "1"));
                        FrsFragment.this.dhC.startPullRefresh();
                    }
                } else if (hVar != null && (hVar instanceof bd)) {
                    bd bdVar = (bd) hVar;
                    if (bdVar.vV() == null || bdVar.vV().getGroup_id() == 0 || ba.aU(FrsFragment.this.getActivity())) {
                        if (bdVar.vO() != 1 || ba.aU(FrsFragment.this.getActivity())) {
                            if (bdVar.vz() != null) {
                                if (ba.aU(FrsFragment.this.getActivity())) {
                                    String postUrl = bdVar.vz().getPostUrl();
                                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.jU()) {
                                        com.baidu.tbadk.browser.a.Q(FrsFragment.this.getActivity(), postUrl);
                                    }
                                }
                            } else if (bdVar.we() != null) {
                                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                    ba.aT(FrsFragment.this.getPageContext().getPageActivity());
                                    return;
                                }
                                com.baidu.tbadk.core.data.n we = bdVar.we();
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), we.getCartoonId(), we.getChapterId(), 2)));
                            } else {
                                com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                                if (readThreadHistory != null && !readThreadHistory.ua(bdVar.getId())) {
                                    readThreadHistory.tZ(bdVar.getId());
                                }
                                boolean z = false;
                                final String vt = bdVar.vt();
                                if (vt != null && !vt.equals("")) {
                                    z = true;
                                    new Thread(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.a.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            com.baidu.tbadk.core.util.y yVar = new com.baidu.tbadk.core.util.y(vt);
                                            yVar.yJ().zI().mIsNeedAddCommenParam = false;
                                            yVar.yJ().zI().mIsUseCurrentBDUSS = false;
                                            yVar.ym();
                                        }
                                    }).start();
                                }
                                String tid = bdVar.getTid();
                                if (tid == null) {
                                    tid = "";
                                }
                                if (bdVar.vh() == 2 && !tid.startsWith("pb:")) {
                                    ay.zG().c(FrsFragment.this.getPageContext(), new String[]{tid, "", null});
                                    return;
                                }
                                if (tid.startsWith("pb:")) {
                                    bdVar.setId(tid.substring(3));
                                }
                                if (bdUniqueId.getId() == bd.ajb.getId()) {
                                    com.baidu.tieba.frs.f.h.a(bdVar.uV());
                                } else if (bdUniqueId.getId() == bd.ahQ.getId()) {
                                    com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c12940");
                                    amVar.ah("obj_type", "2");
                                    amVar.ah("tid", bdVar.getTid());
                                    TiebaStatic.log(amVar);
                                }
                                com.baidu.tieba.frs.f.i.a(FrsFragment.this, bdVar, i, z);
                                com.baidu.tieba.frs.f.h.a(FrsFragment.this, FrsFragment.this.dhf, bdVar);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.l.jU()) {
            hideNetRefreshView(this.dhC.adh());
            showLoadingView(this.dhC.adh(), true);
            this.dhC.fB(false);
            this.dhN.t(3, true);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public com.baidu.tieba.tbadkCore.l atI() {
        return this.dhf;
    }

    public boolean atJ() {
        return this.dhC.atJ();
    }

    public void U(Object obj) {
        if (this.dhS != null && this.dhS.dxt != null) {
            this.dhS.dxt.i(obj);
        }
    }

    public void V(Object obj) {
        if (this.dhS != null && this.dhS.dxu != null) {
            this.dhS.dxu.i(obj);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        this.dhC.getListView().stopScroll();
        if (!com.baidu.adp.lib.util.l.jU()) {
            this.dhC.TL();
        } else if (this.dhN.ayt() == 1) {
            SX();
            SJ();
        } else if (this.dhN.hasMore()) {
            SJ();
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void mg(String str) {
        SX();
        showToast(str);
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void I(ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        SX();
        if (!com.baidu.tbadk.core.util.w.z(arrayList)) {
            if (!this.dhN.ayD() && TbadkCoreApplication.getInst().isRecAppExist() && this.dhN.ayt() == 1) {
                this.dhf.a(this, arrayList);
            }
            ArrayList<com.baidu.adp.widget.ListView.h> a2 = this.dhZ.a(false, false, arrayList, this.dhy, false);
            if (a2 != null) {
                this.dhf.av(a2);
                this.dhC.a(a2, this.dhf);
            }
            if (this.dhN != null) {
                com.baidu.tieba.frs.e.b.a(this.dhf, this.dhN.ayz(), 2);
            }
        }
    }

    private void SX() {
        if (ats() == 1 || this.dhZ.bu(this.dhf.bvg())) {
            if (com.baidu.tbadk.core.util.w.y(this.dhf.getThreadList()) > 3) {
                this.dhC.TJ();
            } else {
                this.dhC.auA();
            }
        } else if (com.baidu.tbadk.core.util.w.z(this.dhf.getThreadList())) {
            this.dhC.TL();
        } else {
            this.dhC.TK();
        }
    }

    @Override // com.baidu.tieba.frs.mc.j
    public void SJ() {
        if (this.dhZ != null) {
            this.dhZ.a(this.dhv, this.forumId, this.dhf);
        }
    }

    public void takePhoto() {
        if (!com.baidu.tbadk.core.util.ac.e(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.ak.b(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        if (this.dhI) {
            return null;
        }
        if (atK()) {
            return "a034";
        }
        return "a006";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (!atK()) {
            return super.getCurrentPageSourceKeyList();
        }
        if (super.getCurrentPageSourceKeyList() != null) {
            arrayList = new ArrayList(super.getCurrentPageSourceKeyList());
        } else {
            arrayList = new ArrayList();
        }
        if (!"a001".equals(com.baidu.tbadk.core.util.w.c(arrayList, arrayList.size() - 1))) {
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

    public void fu(boolean z) {
        if (this.dhT != null) {
            this.dhT.fI(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.dhU.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a gc(int i) {
        return this.dhU.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        this.did.b(bVar);
    }

    public boolean atK() {
        return this.dhr;
    }

    @Override // com.baidu.tieba.frs.af
    public void Tk() {
        if (this.dhC != null) {
            showFloatingView();
            this.dhC.getListView().scrollToPosition(0);
            this.dhC.startPullRefresh();
        }
    }

    public ForumWriteData atL() {
        if (this.dhf == null || this.dhf.bam() == null) {
            return null;
        }
        ForumData bam = this.dhf.bam();
        ForumWriteData forumWriteData = new ForumWriteData(bam.getId(), bam.getName(), bam.getPrefixData(), this.dhf.uo());
        forumWriteData.avatar = bam.getImage_url();
        forumWriteData.forumLevel = bam.getUser_level();
        forumWriteData.specialForumType = bam.special_forum_type;
        forumWriteData.firstDir = bam.getFirst_class();
        forumWriteData.secondDir = bam.getSecond_class();
        UserData userData = this.dhf.getUserData();
        forumWriteData.privateThread = userData != null ? userData.getPrivateThread() : 0;
        return forumWriteData;
    }

    @Override // com.baidu.tieba.frs.af
    public void Ay() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.frs.af
    public void setVideoThreadId(String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z) {
        super.showLoadingView(view, z);
        this.dhC.kj(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        super.hideLoadingView(view);
        this.dhC.kj(0);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        super.showNetRefreshView(view, str, z);
        this.dhC.kj(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshViewNoClick(View view, String str, boolean z) {
        super.showNetRefreshViewNoClick(view, str, z);
        this.dhC.kj(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        super.hideNetRefreshView(view);
        this.dhC.kj(0);
    }

    public void atM() {
        FrsTabViewController.b azB;
        if (this.dhP != null && (azB = this.dhP.azB()) != null && azB.fragment != null && (azB.fragment instanceof ah)) {
            ((ah) azB.fragment).atd();
        }
    }

    public void a(ContriInfo contriInfo) {
        if (this.dio == null) {
            this.dio = new com.baidu.tbadk.core.dialog.h(aiH());
            this.dio.a(new h.a() { // from class: com.baidu.tieba.frs.FrsFragment.30
                @Override // com.baidu.tbadk.core.dialog.h.a
                public void aC(boolean z) {
                    if (z) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13061"));
                    }
                }
            });
        }
        this.dio.a(contriInfo, -1L);
    }

    public void fv(boolean z) {
        this.dht = z;
    }

    public boolean atN() {
        return this.dht;
    }

    public void mu(String str) {
        if (TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.util.ao.isEmpty(str)) {
            if (this.dip == null) {
                this.dip = new AddExperiencedModel(aiH());
                this.dip.a(this.diq);
            }
            this.dip.cd(this.forumId, str);
        }
    }

    public com.baidu.tieba.frs.entelechy.b atO() {
        return this.dhp;
    }
}
