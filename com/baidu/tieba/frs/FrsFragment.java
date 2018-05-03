package com.baidu.tieba.frs;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
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
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.ax;
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
import com.baidu.tieba.c.a;
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
public class FrsFragment extends BaseFragment implements BdListView.e, a.InterfaceC0045a, UserIconBox.b<BdRecyclerView>, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, af, ai, ak, com.baidu.tieba.frs.loadmore.a, com.baidu.tieba.frs.mc.j, com.baidu.tieba.recapp.n {
    public static boolean cWZ = false;
    public static volatile long cXi = 0;
    public static volatile long cXj = 0;
    public static volatile int cXk = 0;
    private com.baidu.tbadk.util.r aNJ;
    private com.baidu.adp.lib.e.b<TbImageView> aqg;
    private com.baidu.tieba.frs.gametab.b buc;
    private com.baidu.tieba.frs.entelechy.b cWU;
    private com.baidu.tieba.frs.mc.d cXA;
    private com.baidu.tieba.frs.mc.c cXB;
    private com.baidu.tieba.frs.vc.h cXC;
    private com.baidu.tieba.frs.mc.a cXD;
    private com.baidu.tieba.frs.live.a cXE;
    private h cXF;
    public com.baidu.tieba.frs.vc.c cXG;
    private com.baidu.tieba.frs.mc.e cXH;
    private int cXI;
    private View.OnTouchListener cXJ;
    private com.baidu.tieba.frs.view.a cXK;
    private com.baidu.tieba.frs.vc.e cXL;
    private boolean cXM;
    private com.baidu.tieba.NEGFeedBack.a cXO;
    private com.baidu.tieba.ala.a cXP;
    private com.baidu.tbadk.core.dialog.i cXQ;
    private AddExperiencedModel cXR;
    private com.baidu.tieba.tbadkCore.data.e cXd;
    private VoiceManager cXg;
    private FrsModelController cXp;
    private com.baidu.tieba.frs.vc.f cXq;
    private FrsTabViewController cXr;
    private com.baidu.tieba.frs.mc.f cXs;
    private com.baidu.tieba.frs.smartsort.b cXt;
    private com.baidu.tieba.frs.mc.b cXu;
    private al cXv;
    private com.baidu.tieba.frs.entelechy.b.b cXx;
    private com.baidu.tbadk.h.a cXy;
    private com.baidu.tieba.frs.vc.a cXz;
    public View mRootView;
    public boolean cWV = false;
    private boolean cWW = false;
    private boolean cWX = false;
    private boolean cWY = true;
    public String cXa = null;
    public String mFrom = null;
    public int mFlag = 0;
    private boolean cXb = false;
    private String mThreadId = null;
    public String forumId = null;
    private int cWO = 0;
    private boolean cXc = false;
    private boolean cXe = false;
    private boolean cXf = false;
    private i cXh = null;
    public final bd bjU = null;
    private com.baidu.tieba.tbadkCore.l cWL = new com.baidu.tieba.tbadkCore.l();
    public long cHO = -1;
    public long aKV = 0;
    public long aKN = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean cXl = false;
    private boolean cXm = false;
    public com.baidu.tbadk.k.d cXn = null;
    private boolean cXo = true;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> cXw = new SparseArray<>();
    private boolean bvq = true;
    private boolean cXN = false;
    private AddExperiencedModel.a cXS = new AddExperiencedModel.a() { // from class: com.baidu.tieba.frs.FrsFragment.1
        @Override // com.baidu.tieba.share.AddExperiencedModel.a
        public void b(ContriInfo contriInfo) {
            if (contriInfo != null && contriInfo.isShowToast()) {
                FrsFragment.this.a(contriInfo);
            }
        }
    };
    private HttpMessageListener cXT = new HttpMessageListener(CmdConfigHttp.CMD_PB_FLOOR_AGREE, true) { // from class: com.baidu.tieba.frs.FrsFragment.12
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
    private final CustomMessageListener cXU = new CustomMessageListener(2016495) { // from class: com.baidu.tieba.frs.FrsFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof bd) {
                    com.baidu.tieba.frs.f.g.a(FrsFragment.this.cXh, FrsFragment.this.cWL, FrsFragment.this.getForumId(), true, (bd) data);
                }
            }
        }
    };
    private CustomMessageListener cXV = new CustomMessageListener(2921005) { // from class: com.baidu.tieba.frs.FrsFragment.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.cWL != null) {
                FrsFragment.this.cWL.brc();
                if (FrsFragment.this.cXh != null) {
                    FrsFragment.this.cXh.agD();
                }
            }
        }
    };
    private CustomMessageListener cXW = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.FrsFragment.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 1) {
                    FrsFragment.this.apx();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                }
            }
        }
    };
    private final aj cXX = new aj() { // from class: com.baidu.tieba.frs.FrsFragment.32
        @Override // com.baidu.tieba.frs.aj
        public void a(int i, int i2, ap apVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
            FrsFragment.this.apq();
            if (FrsFragment.this.cXx != null) {
                FrsFragment.this.cXq.fW(FrsFragment.this.cXx.kv(i));
            }
            d.a aVar = new d.a();
            if (apVar != null) {
                aVar.isSuccess = apVar.errCode == 0;
                aVar.errorCode = apVar.errCode;
                aVar.errorMsg = apVar.errMsg;
                if (aVar.isSuccess) {
                    if (com.baidu.tbadk.core.util.v.w(arrayList)) {
                        FrsFragment.this.cXh.Qq();
                    } else if (apVar.hasMore) {
                        if (com.baidu.tbadk.core.util.v.v(FrsFragment.this.cWL.getThreadList()) > 3) {
                            FrsFragment.this.cXh.Qo();
                        } else {
                            FrsFragment.this.cXh.aqw();
                        }
                    } else if (apVar.das) {
                        FrsFragment.this.cXh.Qp();
                    } else {
                        FrsFragment.this.cXh.Qq();
                    }
                }
            } else {
                apVar = new ap();
                apVar.pn = 1;
                apVar.hasMore = false;
                apVar.das = false;
            }
            if (i == 1) {
                FrsFragment.this.cXo = true;
                FrsFragment.this.cYh.a(FrsFragment.this.cXp.getType(), false, aVar);
            } else {
                FrsFragment.this.a(aVar);
                if (FrsFragment.this.cXp.atJ() != null) {
                    FrsFragment.this.cWL = FrsFragment.this.cXp.atJ();
                }
                FrsFragment.this.apz();
            }
            if (FrsFragment.this.cYp != null) {
                FrsFragment.this.cYp.a(i, i2, apVar, arrayList);
            }
        }
    };
    private FrsTabViewController.a cXY = new FrsTabViewController.a() { // from class: com.baidu.tieba.frs.FrsFragment.33
        @Override // com.baidu.tieba.frs.vc.FrsTabViewController.a
        public void eS(int i) {
            if (i != 1) {
                com.baidu.tieba.card.v.afy().et(false);
            }
            FrsFragment.this.apC();
            com.baidu.tieba.frs.e.c.dov.dom = i;
            com.baidu.tieba.frs.e.c.dov.don = -1;
        }
    };
    private CustomMessageListener cXZ = new CustomMessageListener(2001606) { // from class: com.baidu.tieba.frs.FrsFragment.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                FrsFragment.this.cXr.lu(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    };
    private CustomMessageListener cYa = new CustomMessageListener(2001607) { // from class: com.baidu.tieba.frs.FrsFragment.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && ((Integer) customResponsedMessage.getData()).intValue() == 51 && FrsFragment.this.cWL != null) {
                com.baidu.tieba.frs.f.i.a(FrsFragment.this.cWL, FrsFragment.this.getPageContext());
            }
        }
    };
    private final CustomMessageListener cYb = new CustomMessageListener(2003019) { // from class: com.baidu.tieba.frs.FrsFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                FrsFragment.this.cXr.ls(49);
            }
        }
    };
    private final CustomMessageListener cYc = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.frs.FrsFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && FrsFragment.this.cWL != null && FrsFragment.this.cWL.aVq() != null) {
                SignData signData = (SignData) customResponsedMessage.getData();
                int user_level = FrsFragment.this.cWL.aVq().getUser_level();
                if (signData.forumId != null && signData.forumId.equals(FrsFragment.this.cWL.aVq().getId())) {
                    FrsFragment.this.cWL.d(signData);
                    FrsFragment.this.cXq.g(FrsFragment.this.cWL);
                    if (FrsFragment.this.cXq.avn()) {
                        i = FrsFragment.this.cWL.aVq().getUser_level();
                        if (user_level >= i) {
                            i++;
                        }
                    } else {
                        i = user_level;
                    }
                    TbadkCoreApplication.getInst().addSignedForum(FrsFragment.this.cWL.aVq().getName(), signData.sign_bonus_point, i);
                }
            }
        }
    };
    private final CustomMessageListener cYd = new CustomMessageListener(2001352) { // from class: com.baidu.tieba.frs.FrsFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.r) && FrsFragment.this.cWL != null) {
                FrsFragment.this.cWL.c((com.baidu.tieba.tbadkCore.r) customResponsedMessage.getData());
                FrsFragment.this.cXq.f(FrsFragment.this.cWL);
                FrsFragment.this.cXr.a(FrsFragment.this.cWL, FrsFragment.this.cXp.aun());
            }
        }
    };
    private final AntiHelper.a cYe = new AntiHelper.a() { // from class: com.baidu.tieba.frs.FrsFragment.5
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.al("c12536").r("obj_locate", ar.a.aje));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.al("c12535").r("obj_locate", ar.a.aje));
        }
    };
    private CustomMessageListener bro = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.frs.FrsFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(FrsFragment.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().auo != null) {
                        if (AntiHelper.a(FrsFragment.this.getActivity(), updateAttentionMessage.getData().auo, FrsFragment.this.cYe) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.al("c12534").r("obj_locate", ar.a.aje));
                        }
                    } else if (updateAttentionMessage.getData().Aj && updateAttentionMessage.getData().isAttention) {
                        com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getPageContext().getPageActivity(), d.k.attention_success);
                    }
                }
            }
        }
    };
    private CustomMessageListener cYf = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.frs.FrsFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                FrsFragment.this.cXh.c((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener cYg = new CustomMessageListener(2001626) { // from class: com.baidu.tieba.frs.FrsFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewsRemindMessage newsRemindMessage;
            if (customResponsedMessage != null && (customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626 && (newsRemindMessage = (NewsRemindMessage) customResponsedMessage) != null) {
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (FrsFragment.this.cXh != null) {
                    FrsFragment.this.cXh.q(notificationCount, z);
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.n cYh = new com.baidu.tieba.tbadkCore.n() { // from class: com.baidu.tieba.frs.FrsFragment.9
        private long startTime = 0;

        @Override // com.baidu.tieba.tbadkCore.n
        public void kd(int i) {
            this.startTime = System.nanoTime();
            if (FrsFragment.this.cXh != null) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsFragment.this.cXh.aqk();
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
            if (FrsFragment.this.bvq) {
                FrsFragment.this.bvq = false;
                com.baidu.tieba.frs.f.g.a(FrsFragment.this.cXh, FrsFragment.this.cWL, FrsFragment.this.getForumId(), false, null);
            }
            FrsFragment.this.apq();
            FrsFragment.this.cXl = true;
            if (aVar != null && aVar.isSuccess) {
                FrsFragment.this.cXh.aqt().fJ(com.baidu.tbadk.core.util.ap.vQ().vS());
                FrsFragment.cXi = 0L;
                FrsFragment.cXj = 0L;
                FrsFragment.cXk = 0;
            } else {
                FrsFragment.cXk = 1;
            }
            if (!FrsFragment.this.cXp.aur() && (i == 3 || i == 6)) {
                FrsFragment.this.cXB.resetData();
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (FrsFragment.this.cXp.atJ() != null) {
                FrsFragment.this.cWL = FrsFragment.this.cXp.atJ();
            }
            FrsFragment.this.ka(1);
            if (i == 7) {
                FrsFragment.this.kb(FrsFragment.this.cWL.bqs());
                return;
            }
            if (FrsFragment.this.cWL.rg() != null) {
                FrsFragment.this.setHasMore(FrsFragment.this.cWL.rg().rc());
            }
            FrsFragment.this.apr();
            if (i == 4) {
                if (!FrsFragment.this.cXp.aur() && TbadkCoreApplication.getInst().isRecAppExist() && FrsFragment.this.cXp.auh() == 1) {
                    FrsFragment.this.cWL.a(FrsFragment.this);
                }
                ArrayList<com.baidu.adp.widget.ListView.h> a2 = FrsFragment.this.cXB.a(false, false, FrsFragment.this.cWL.getThreadList(), FrsFragment.this.cXd);
                if (a2 != null) {
                    FrsFragment.this.cWL.av(a2);
                    FrsFragment.this.cWL.bqU();
                    FrsFragment.this.cXh.a(a2, FrsFragment.this.cWL);
                }
                if (FrsFragment.this.cXp != null) {
                    com.baidu.tieba.frs.e.b.a(FrsFragment.this.cWL, FrsFragment.this.cXp.aun(), 2);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsFragment.this.cXh.aqk();
                    break;
                case 2:
                    FrsFragment.this.cXh.aqk();
                    break;
                case 3:
                case 6:
                    if (FrsFragment.this.cWL != null) {
                        FrsFragment.this.cWL.bqS();
                    }
                    if (FrsFragment.this.cXG != null) {
                        FrsFragment.this.cXG.refresh();
                        break;
                    }
                    break;
            }
            FrsFragment.this.aps();
            if (aVar == null || aVar.errorCode == 0) {
                if (FrsFragment.this.cWL != null) {
                    FrsFragment.this.t(false, i == 5);
                    FrsFragment.this.cXh.kh(i);
                    FrsFragment.cXi = (System.nanoTime() - this.startTime) / 1000000;
                    if (aVar != null) {
                        FrsFragment.cXj = aVar.gtl;
                    }
                } else {
                    return;
                }
            } else if (FrsFragment.this.cWL == null || com.baidu.tbadk.core.util.v.w(FrsFragment.this.cWL.getThreadList())) {
                FrsFragment.this.a(aVar);
            } else if (aVar.gtk) {
                FrsFragment.this.showToast(FrsFragment.this.getPageContext().getResources().getString(d.k.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
            }
            if (FrsFragment.this.cWL.bqb() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.al("c11384"));
            }
            if (FrsFragment.this.cHO > -1 && !FrsFragment.this.cXN) {
                com.baidu.tieba.frs.f.g.a(FrsFragment.this.cXp, FrsFragment.this.cHO);
                FrsFragment.this.cHO = -1L;
                FrsFragment.this.cXN = true;
            }
            if (FrsFragment.this.cXe && FrsFragment.this.cXr.ls(49)) {
                FrsFragment.this.cXe = false;
            }
            FrsFragment.this.aKV = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void b(com.baidu.tieba.tbadkCore.i iVar) {
            if (iVar != null) {
                if ("normal_page".equals(FrsFragment.this.cXp.aud()) || "frs_page".equals(FrsFragment.this.cXp.aud()) || "book_page".equals(FrsFragment.this.cXp.aud())) {
                    FrsFragment.this.a(iVar);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001615, iVar));
                }
            }
        }
    };
    private final CustomMessageListener cYi = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.frs.FrsFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.h) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                FrsFragment.this.cWL.a((com.baidu.tbadk.data.h) customResponsedMessage.getData());
                FrsFragment.this.cXh.aqt().notifyDataSetChanged();
            }
        }
    };
    private final CustomMessageListener mMemListener = new CustomMessageListener(2001194) { // from class: com.baidu.tieba.frs.FrsFragment.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && FrsFragment.this.cWL != null && (userData = FrsFragment.this.cWL.getUserData()) != null) {
                userData.setIsMem(num.intValue());
                if (num.intValue() != 0) {
                    FrsFragment.this.cXq.g(num);
                }
            }
        }
    };
    private final com.baidu.tieba.frs.mc.i cYj = new com.baidu.tieba.frs.mc.i() { // from class: com.baidu.tieba.frs.FrsFragment.15
        @Override // com.baidu.tieba.frs.mc.i
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.h> arrayList, boolean z3) {
            if (FrsFragment.this.cXt != null && FrsFragment.this.cXp != null && FrsFragment.this.cXp.aur() && z && !z2 && !z3) {
                FrsFragment.this.cXt.kX(i2);
            }
        }
    };
    public final View.OnTouchListener aNK = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.FrsFragment.16
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            if (FrsFragment.this.cXJ != null) {
                FrsFragment.this.cXJ.onTouch(view2, motionEvent);
            }
            if (FrsFragment.this.cXv != null && FrsFragment.this.cXv.aqK() != null) {
                FrsFragment.this.cXv.aqK().onTouchEvent(motionEvent);
            }
            if (FrsFragment.this.buc != null) {
                FrsFragment.this.buc.d(view2, motionEvent);
            }
            if (FrsFragment.this.cXq != null) {
                FrsFragment.this.cXq.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private final CustomMessageListener cYk = new CustomMessageListener(2004507) { // from class: com.baidu.tieba.frs.FrsFragment.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "photolive_hostLevel", -1) != -1 && FrsFragment.this.cWL.aVq() != null) {
                FrsFragment.this.cWL.aVq().setCanAddPhotoLivePost(true);
            }
        }
    };
    private final CustomMessageListener cYl = new CustomMessageListener(2016493) { // from class: com.baidu.tieba.frs.FrsFragment.18
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.frs.FrsFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.al("c11455").ac("obj_locate", "frs"));
                    ax.wg().c(FrsFragment.this.getPageContext(), new String[]{str});
                }
            }
        }
    };
    public final View.OnClickListener cYm = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.22
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (FrsFragment.this.cXh == null || view2 != FrsFragment.this.cXh.aqi() || FrsFragment.this.getActivity() == null) {
                if (FrsFragment.this.cWL != null && FrsFragment.this.cWL.aVq() != null && FrsFragment.this.cXh != null && view2 == FrsFragment.this.cXh.aqo()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.al("c12402").ac(ImageViewerConfig.FORUM_ID, FrsFragment.this.cWL.aVq().getId()).ac("uid", TbadkCoreApplication.getCurrentAccount()).ac(ImageViewerConfig.FORUM_NAME, FrsFragment.this.cWL.aVq().getName()));
                    if (!StringUtils.isNull(FrsFragment.this.cWL.aVq().getName())) {
                        FrsFragment.this.sendMessage(new CustomMessage(2002001, new PostSearchActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), FrsFragment.this.cWL.aVq().getName(), FrsFragment.this.cWL.aVq().getId())));
                        return;
                    }
                    return;
                }
                if (view2.getId() == d.g.game_activity_egg_layout && com.baidu.adp.lib.util.l.hg()) {
                    TiebaStatic.log("c10853");
                    if (FrsFragment.this.cXh.aqq()) {
                        FrsFragment.this.cXh.aqr();
                    } else {
                        String activityUrl = FrsFragment.this.cWL.aVq().getYuleData().tw().getActivityUrl();
                        if (!StringUtils.isNull(activityUrl)) {
                            com.baidu.tbadk.browser.a.N(FrsFragment.this.getPageContext().getPageActivity(), activityUrl);
                        }
                    }
                }
                if (view2 == FrsFragment.this.cXh.aqx() && FrsFragment.this.cXp != null && FrsFragment.this.cXp.hasMore()) {
                    FrsFragment.this.cXh.Qo();
                    FrsFragment.this.Po();
                }
                if (view2 != null && view2 == FrsFragment.this.cXh.aqp() && az.aK(FrsFragment.this.getContext())) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.al("c12924").r("obj_locate", 2));
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
        private int cYs = 0;
        private int bjz = 0;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (FrsFragment.this.cXz != null) {
                FrsFragment.this.cXz.auR();
            }
            this.cYs = 0;
            this.bjz = 0;
            if (recyclerView != null && (recyclerView instanceof BdRecyclerView)) {
                this.cYs = ((BdRecyclerView) recyclerView).getFirstVisiblePosition();
                this.bjz = ((BdRecyclerView) recyclerView).getLastVisiblePosition();
            }
            if (FrsFragment.this.cXL != null) {
                FrsFragment.this.cXL.a(recyclerView, this.cYs, this.bjz);
            }
            if (FrsFragment.this.cWL != null && FrsFragment.this.cXh != null && FrsFragment.this.cXh.aqt() != null) {
                FrsFragment.this.cXh.ay(this.cYs, this.bjz);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (FrsFragment.this.cXq != null) {
                FrsFragment.this.cXq.setScrollState(i);
            }
            if ((i == 2 || i == 1) && !FrsFragment.this.cXm) {
                FrsFragment.this.cXm = true;
                FrsFragment.this.cXh.aqv();
            }
            if (FrsFragment.this.cXn == null && !FrsFragment.this.apG()) {
                FrsFragment.this.cXn = new com.baidu.tbadk.k.d();
                FrsFragment.this.cXn.fi(1000);
            }
            if (i == 0) {
                com.baidu.tieba.card.v.afy().et(true);
                FrsFragment.this.cXh.ax(this.cYs, this.bjz);
            }
            if (FrsFragment.this.cXL != null) {
                FrsFragment.this.cXL.onScrollStateChanged(recyclerView, i);
            }
            if (FrsFragment.this.cXn != null) {
                FrsFragment.this.cXn.GF();
            }
            if (i == 0) {
                com.baidu.tieba.frs.f.g.a(FrsFragment.this.cXh, FrsFragment.this.cWL, FrsFragment.this.getForumId(), false, null);
            }
            if (FrsFragment.this.cXr != null && i == 1) {
                FrsFragment.this.cXr.avv();
            }
        }
    };
    private final b cYn = new b() { // from class: com.baidu.tieba.frs.FrsFragment.25
        @Override // com.baidu.tieba.frs.b
        public void a(int i, int i2, View view2, View view3, bd bdVar) {
            if (i != FrsFragment.this.cXh.aqt().arO()) {
                if (i != FrsFragment.this.cXh.aqt().arP()) {
                    if (i == FrsFragment.this.cXh.aqt().arQ() && FrsFragment.this.cWL != null && FrsFragment.this.cWL.getUserData() != null && FrsFragment.this.cWL.getUserData().isBawu()) {
                        final String bqq = FrsFragment.this.cWL.bqq();
                        if (!com.baidu.tbadk.core.util.an.isEmpty(bqq) && FrsFragment.this.cWL.aVq() != null) {
                            com.baidu.tieba.c.a.a(FrsFragment.this.getPageContext(), FrsFragment.this.cWL.aVq().getId(), FrsFragment.this.cWL.aVq().getName(), new a.InterfaceC0121a() { // from class: com.baidu.tieba.frs.FrsFragment.25.1
                                @Override // com.baidu.tieba.c.a.InterfaceC0121a
                                public void aeX() {
                                    com.baidu.tbadk.browser.a.M(FrsFragment.this.getPageContext().getPageActivity(), bqq);
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.al("c10502").ac(ImageViewerConfig.FORUM_ID, FrsFragment.this.cWL.aVq().getId()).ac("uid", FrsFragment.this.cWL.getUserData().getUserId()));
                                }
                            });
                        }
                    }
                } else if (az.aK(FrsFragment.this.getPageContext().getPageActivity())) {
                    TiebaStatic.log("my_service_ck");
                    if (FrsFragment.this.cWL != null && FrsFragment.this.cWL.aVq() != null) {
                        ForumData aVq = FrsFragment.this.cWL.aVq();
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(aVq.getId(), 0L), aVq.getName(), aVq.getImage_url(), 0)));
                    }
                }
            } else if (az.aK(FrsFragment.this.getActivity())) {
                TiebaStatic.log("forum_fortune_click");
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.getPageContext(), FrsFragment.this.cWL);
            }
        }
    };
    private final NoNetworkView.a cVe = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.FrsFragment.26
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aM(boolean z) {
            if (FrsFragment.this.cXp.auh() == 1 && z && !FrsFragment.this.cXh.apF()) {
                if (FrsFragment.this.cWL == null || com.baidu.tbadk.core.util.v.w(FrsFragment.this.cWL.getThreadList())) {
                    FrsFragment.this.hideNetRefreshView(FrsFragment.this.cXh.ZG());
                    FrsFragment.this.showLoadingView(FrsFragment.this.cXh.ZG(), true);
                    FrsFragment.this.cXh.fv(false);
                    FrsFragment.this.refresh();
                    return;
                }
                FrsFragment.this.cXh.aqk();
            }
        }
    };
    private final CustomMessageListener auR = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.FrsFragment.27
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                com.baidu.tieba.frs.f.c.a(customResponsedMessage, FrsFragment.this.cXh, FrsFragment.this.cWL);
            }
        }
    };
    private com.baidu.adp.widget.ListView.n cYo = new a();
    private aj cYp = new aj() { // from class: com.baidu.tieba.frs.FrsFragment.28
        @Override // com.baidu.tieba.frs.aj
        public void a(int i, int i2, ap apVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
            com.baidu.adp.lib.g.e.fw().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.28.1
                @Override // java.lang.Runnable
                public void run() {
                    if (FrsFragment.this.cXh != null && FrsFragment.this.cXh.agu()) {
                        FrsFragment.this.Po();
                    }
                }
            });
        }
    };
    private CustomMessageListener cYq = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.frs.FrsFragment.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    FrsFragment.this.cXM = true;
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.frs.loadmore.a
    public /* bridge */ /* synthetic */ com.baidu.adp.base.e getPageContext() {
        return super.getPageContext();
    }

    public com.baidu.tieba.frs.entelechy.b.b apd() {
        return this.cXx;
    }

    public com.baidu.adp.widget.ListView.n ape() {
        return this.cYo;
    }

    public com.baidu.tieba.frs.mc.d apf() {
        return this.cXA;
    }

    public com.baidu.tieba.frs.smartsort.b apg() {
        return this.cXt;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public FrsModelController aph() {
        return this.cXp;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public com.baidu.tieba.frs.mc.c apj() {
        return this.cXB;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public com.baidu.tieba.frs.vc.f apk() {
        return this.cXq;
    }

    public com.baidu.tieba.frs.vc.j apl() {
        return this.cXr;
    }

    public al apm() {
        return this.cXv;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public i apn() {
        return this.cXh;
    }

    @Override // com.baidu.tieba.frs.ak
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.ak, com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.cXa;
    }

    public void setForumName(String str) {
        this.cXa = str;
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
        if (this.cXB == null) {
            return 1;
        }
        return this.cXB.getPn();
    }

    public int getPn() {
        if (this.cXB == null) {
            return 1;
        }
        return this.cXB.getPn();
    }

    public void setPn(int i) {
        if (this.cXB != null) {
            this.cXB.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.cXB != null) {
            this.cXB.setHasMore(i);
        }
    }

    public int apo() {
        if (this.cXB == null) {
            return -1;
        }
        return this.cXB.apo();
    }

    public boolean app() {
        return this.cXf;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d.a aVar) {
        if (aVar == null) {
            String string = TbadkCoreApplication.getInst().getString(d.k.error_unkown_try_again);
            this.cXh.aqf();
            showNetRefreshView(this.cXh.ZG(), string, true);
        } else if (340001 == aVar.errorCode) {
            a(aVar, this.cWL.bpY());
        } else {
            if (com.baidu.tbadk.core.util.v.w(this.cWL.getThreadList())) {
                b(aVar);
            }
            if (apG()) {
                setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst(), d.e.ds280));
            } else {
                setNetRefreshViewEmotionDefMarginTop();
            }
        }
    }

    public void a(View view2, String str, boolean z, List<RecmForumInfo> list) {
        this.cXh.aqf();
        this.cXh.kf(8);
        if (this.cXK == null) {
            this.cXK = new com.baidu.tieba.frs.view.a(getPageContext(), getNetRefreshListener());
        }
        this.cXK.setSubText(str);
        this.cXK.bs(list);
        this.cXK.d(view2, z);
    }

    private void a(d.a aVar, List<RecmForumInfo> list) {
        if (this.cXh != null) {
            this.cXh.aqf();
            this.cXh.setTitle(this.cXa);
            a(this.cXh.ZG(), aVar.errorMsg, true, list);
        }
    }

    private void b(d.a aVar) {
        this.cXh.aqf();
        if (aVar.gtk) {
            showNetRefreshView(this.cXh.ZG(), TbadkCoreApplication.getInst().getString(d.k.net_error_text, new Object[]{aVar.errorMsg, Integer.valueOf(aVar.errorCode)}), true);
        } else {
            showNetRefreshView(this.cXh.ZG(), aVar.errorMsg, true);
        }
    }

    public void apq() {
        hideLoadingView(this.cXh.ZG());
        if (!this.cXh.apF()) {
            this.cXh.fw(false);
        } else {
            this.cXh.fw(true);
        }
        if (this.cXh.aqd() instanceof com.baidu.tieba.frs.tab.c) {
            ((com.baidu.tieba.frs.tab.c) this.cXh.aqd()).auL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apr() {
        if (apo() == 0 && com.baidu.tbadk.core.util.v.w(this.cWL.bqh())) {
            if (com.baidu.tbadk.core.util.v.w(this.cWL.getThreadList())) {
                this.cXh.Qq();
            } else {
                this.cXh.Qp();
            }
        } else if (com.baidu.tbadk.core.util.v.v(this.cWL.getThreadList()) > 3) {
            this.cXh.Qo();
        } else {
            this.cXh.aqw();
        }
    }

    public void a(ErrorData errorData) {
        apq();
        this.cXh.aqk();
        d.a aue = this.cXp.aue();
        boolean w = com.baidu.tbadk.core.util.v.w(this.cWL.getThreadList());
        if (aue != null && w) {
            if (this.cXp.auf() != 0) {
                this.cXp.aul();
                this.cXh.aqk();
            } else {
                a(aue);
            }
            this.cXh.u(this.cWL.brj(), false);
            return;
        }
        a(aue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ka(int i) {
        List<WindowToast> list;
        if (TbadkCoreApplication.isLogin() && this.cWL != null && (list = this.cWL.guM) != null && list.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < list.size()) {
                    WindowToast windowToast = list.get(i3);
                    if (windowToast == null || windowToast.toast_type.intValue() != i) {
                        i2 = i3 + 1;
                    } else if (!com.baidu.tbadk.core.util.an.isEmpty(windowToast.toast_link)) {
                        sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(getPageContext().getPageActivity(), "", com.baidu.tbadk.util.z.ho(windowToast.toast_link), true)));
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
    public void aps() {
        if (this.cWL == null || this.cWL.aVq() != null) {
            this.cXh.aqs();
        } else if (this.cWL.aVq().getYuleData() != null && this.cWL.aVq().getYuleData().tv()) {
            TiebaStatic.log("c10852");
            this.cXh.a(this.cWL.aVq().getYuleData().tw());
        } else {
            this.cXh.aqs();
        }
    }

    private void s(boolean z, boolean z2) {
        if (this.cXp != null && this.cWL != null && this.cXh != null && z) {
            if (!this.cXp.aur() && this.cXp.auh() == 1) {
                if (!this.cXp.aup()) {
                    this.cWL.bqZ();
                    this.cWL.bra();
                }
                boolean z3 = false;
                if (this.cXh.aqt().k(com.baidu.tieba.card.data.n.csj)) {
                    z3 = this.cWL.brd();
                }
                if (!z3) {
                    this.cWL.brb();
                }
                if (TbadkCoreApplication.getInst().isRecAppExist()) {
                    this.cWL.a(this);
                }
                if (!this.cXh.aqt().k(bd.ZL)) {
                    this.cWL.bqT();
                }
                this.cWL.bre();
            }
            if (!this.cXh.aqt().k(bd.ZL)) {
                this.cWL.bqY();
                this.cWL.bqW();
            } else {
                this.cWL.bqX();
                this.cWL.bqV();
            }
            this.cWL.bqU();
            this.cWL.bqR();
            if (this.cXh.aqt().k(com.baidu.tieba.h.b.duT)) {
                this.cWL.mm(z2);
            }
            if (TbadkCoreApplication.isLogin() && (!this.cXp.aur() || this.cXp.isNetFirstLoad)) {
                this.cWL.brf();
            }
            this.cWL.brh();
        }
    }

    public boolean apt() {
        if (this.cXq != null && this.cXp != null) {
            this.cXq.a(this.cXp.aud(), this.cWL);
        }
        boolean z = false;
        if (this.cWL != null) {
            z = this.cWL.brk();
        }
        apv();
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kb(int i) {
        am amVar = null;
        apt();
        apC();
        try {
            if (this.cWL != null) {
                this.cXh.a((ArrayList<com.baidu.adp.widget.ListView.h>) null, this.cWL);
                this.cXq.ln(1);
                this.cXh.aqn();
                this.cXr.a(this.cWL, this.cXp.aun());
                com.baidu.tieba.frs.tab.d lt = this.cXr.lt(this.cWL.bqs());
                if (lt != null && !TextUtils.isEmpty(lt.url)) {
                    amVar = new am();
                    amVar.dap = lt.url;
                    amVar.stType = lt.name;
                }
                this.cXp.a(this.cWL.bqs(), 0, amVar);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(boolean z, boolean z2) {
        try {
            if (this.cWL != null && this.cXr != null && this.cXp != null) {
                if (!this.cXh.aqt().k(bd.ZL)) {
                    this.cWL.bqT();
                }
                boolean w = com.baidu.tbadk.core.util.v.w(this.cWL.bqG());
                this.cXh.ft(w);
                if (!w) {
                    if (this.cXL == null) {
                        this.cXL = new com.baidu.tieba.frs.vc.e(this, (NoPressedRelativeLayout) this.mRootView);
                    }
                    if (this.buc == null) {
                        this.buc = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
                    }
                } else {
                    this.cXL = null;
                    this.buc = null;
                }
                if (this.cWL.aVq() != null) {
                    this.cXa = this.cWL.aVq().getName();
                    this.forumId = this.cWL.aVq().getId();
                }
                if (this.cWL.brk()) {
                    this.cXr.a(this.cWL, this.cXp.aun());
                }
                if (z) {
                    s(true, z);
                } else {
                    s(this.cXo, z);
                }
                apt();
                if (this.cXx != null) {
                    this.cXx.a(this.cXq, this.cWL);
                }
                if (this.cWL.rg() != null) {
                    setHasMore(this.cWL.rg().rc());
                }
                ArrayList<com.baidu.adp.widget.ListView.h> a2 = this.cXB.a(z2, true, this.cWL.getThreadList(), null, z);
                if (a2 != null) {
                    this.cWL.av(a2);
                }
                this.cWL.brg();
                if (this.cXp.auh() == 1) {
                    apz();
                    if (!z && this.cXp.getPn() == 1) {
                        apu();
                    }
                }
                this.cWO = this.cWL.auj();
                if (this.cXd != null) {
                    this.cXc = true;
                    this.cXd.tk(this.cWO);
                    com.baidu.tieba.frs.f.a.a(this, this.cWL.aVq(), this.cWL.getThreadList(), this.cXc, getPn());
                }
                if (this.cXz != null) {
                    this.cXz.ax(this.cXr.avs());
                }
                apq();
                this.cXh.aqg();
                this.cXh.u(true, false);
                if (this.cWL.aVq() != null) {
                    this.cXh.lL(this.cWL.aVq().getWarningMsg());
                }
                if (this.cWL != null && this.cWL.bqJ() != null && com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("frs_video_activity_guide", 0L) == 0) {
                    com.baidu.adp.lib.g.e.fw().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.10
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsFragment.this.cXh.aqB();
                        }
                    }, 1000L);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2921326, this));
                this.cXh.apZ();
                if (this.cWL != null && this.cWL.aVq() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016564, new VisitedForumData(this.cWL.aVq().getId(), this.cWL.aVq().getName(), this.cWL.aVq().getImage_url(), String.valueOf(System.currentTimeMillis() / 1000), "showlive".equals(this.cWL.aVq().special_forum_type))));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void apu() {
        if (this.cXE == null) {
            this.cXE = new com.baidu.tieba.frs.live.a(this, com.baidu.adp.lib.g.b.g(this.forumId, 0));
        }
        this.cXE.atQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.i iVar) {
        try {
            if (!this.cXl && iVar != null && this.cWL != null) {
                this.cWL.e(iVar);
                t(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void apv() {
        if (this.cXp != null) {
            lJ(this.cXp.aud());
        } else {
            lJ("normal_page");
        }
    }

    private void lJ(String str) {
        fo("frs_page".equals(str));
        if (this.cXx != null) {
            this.cXx.a(this.cXq, this.cXh, this.cWL);
        }
    }

    public void fo(boolean z) {
        if (this.cXC != null) {
            this.cXC.c(this.cXh, z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(d.i.frs_activity, viewGroup, false);
            this.cWU = new com.baidu.tieba.frs.entelechy.b();
            this.cXx = this.cWU.arr();
            this.cXq = new com.baidu.tieba.frs.vc.f(this, this.cWU, (FrsHeaderViewContainer) this.mRootView.findViewById(d.g.header_view_container));
            this.cXr = new FrsTabViewController(this, this.mRootView);
            this.cXq.a(this.cXr);
            this.cXr.a(this.cXY);
            Intent intent = getActivity().getIntent();
            if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                this.cWW = true;
            }
            this.cXh = new i(this, this.cYm, this.cWU, this.cWW, this.cXq);
            this.cXh.setHeaderViewHeight(this.cXI);
        } else {
            if (this.mRootView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            this.cXr.resetData();
            this.cXh.aqA();
        }
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        this.cHO = System.currentTimeMillis();
        this.beginTime = this.cHO;
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.cXe = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.cHO = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            I(intent);
        }
        this.aKN = this.beginTime - this.cHO;
        this.cXd = new com.baidu.tieba.tbadkCore.data.e("frs", com.baidu.tieba.tbadkCore.data.e.gvR);
        this.cXp = new FrsModelController(this, this.cYh);
        this.cXp.a(this.cXX);
        this.cXp.init();
        if (intent != null) {
            this.cXp.i(intent.getExtras());
        } else if (bundle != null) {
            this.cXp.i(bundle);
        } else {
            this.cXp.i(null);
        }
        if (intent != null) {
            this.cXq.l(intent.getExtras());
        } else if (bundle != null) {
            this.cXq.l(bundle);
        } else {
            this.cXq.l((Bundle) null);
        }
        this.cXg = getVoiceManager();
        this.cXF = new h(getPageContext(), this);
        initUI();
        initData(bundle);
        if (this.mFrom != null && this.mFrom.equals("from_tieba_kuang")) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.al("c12264").r("obj_type", 1).ac(ImageViewerConfig.FORUM_NAME, this.cXp.getForumName()));
            KuangFloatingViewController.getInstance().setNeedShowFloatingView(true);
            if (KuangFloatingViewController.getInstance().init()) {
                ((BaseFragmentActivity) getPageContext().getOrignalPage()).grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.frs.FrsFragment.14
                    @Override // com.baidu.tbadk.core.e
                    public void ak(boolean z) {
                        if (z) {
                            KuangFloatingViewController.getInstance().showFloatingView();
                        }
                    }
                });
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SCHEMA_UPLOAD);
                httpMessage.addParam("call_url", com.baidu.adp.lib.util.k.aS("shoubai://internal?type=frs&param=" + this.cXa));
                MessageManager.getInstance().sendMessage(httpMessage);
            }
        }
        if (!apG()) {
            this.cXv = new al(getActivity(), this.cXh, this.cXq);
            this.cXv.fC(true);
        }
        this.cXg = getVoiceManager();
        if (this.cXg != null) {
            this.cXg.onCreate(getPageContext());
        }
        new com.baidu.tieba.frs.mc.g();
        this.cXB = new com.baidu.tieba.frs.mc.c(this, this.cYj);
        this.cXt = new com.baidu.tieba.frs.smartsort.b(this);
        this.cXC = new com.baidu.tieba.frs.vc.h(this);
        this.cXz = new com.baidu.tieba.frs.vc.a(getPageContext(), this.cXp.auo());
        this.cXu = new com.baidu.tieba.frs.mc.b(this);
        this.cXA = new com.baidu.tieba.frs.mc.d(this);
        this.cXs = new com.baidu.tieba.frs.mc.f(this);
        this.cXD = new com.baidu.tieba.frs.mc.a(this);
        this.cXG = new com.baidu.tieba.frs.vc.c(this);
        this.cXH = new com.baidu.tieba.frs.mc.e(this, getUniqueId());
        this.cXO = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "frs");
        this.cXP = new com.baidu.tieba.ala.a(getPageContext());
        registerListener(this.bro);
        registerListener(this.mMemListener);
        registerListener(this.cYd);
        registerListener(this.cYk);
        registerListener(this.cYc);
        registerListener(this.cYi);
        registerListener(this.cXZ);
        registerListener(this.cYa);
        registerListener(this.cYb);
        registerListener(this.cXU);
        registerListener(this.cXV);
        registerListener(this.cYq);
        registerListener(this.cYf);
        registerListener(this.cXW);
        registerListener(this.cYg);
        this.cXT.setTag(getPageContext().getUniqueId());
        registerListener(this.cXT);
        this.cXh.fv(false);
        if (!apG()) {
            showLoadingView(this.cXh.ZG(), true);
            this.cXp.t(3, true);
        }
        super.onActivityCreated(bundle);
        this.createTime = System.currentTimeMillis() - this.beginTime;
    }

    @Override // com.baidu.tieba.frs.af
    public void PQ() {
        if (isAdded() && this.bvq && !isLoadingViewAttached()) {
            showLoadingView(this.cXh.ZG(), true);
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void PR() {
        if (isAdded() && this.bvq && isLoadingViewAttached()) {
            hideLoadingView(this.cXh.ZG());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (apG()) {
            showLoadingView(this.cXh.ZG(), true);
            this.cXh.kg(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.cXp.t(3, true);
            xj().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void setHeaderViewHeight(int i) {
        this.cXI = i;
        if (this.cXh != null) {
            this.cXh.setHeaderViewHeight(this.cXI);
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.s sVar) {
        if (sVar != null) {
            this.aNJ = sVar.HN();
            this.cXJ = sVar.HO();
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void showFloatingView() {
        if (this.aNJ != null) {
            this.aNJ.bY(true);
        }
    }

    private void I(Intent intent) {
        if (intent != null) {
            if (!com.baidu.tieba.frs.f.e.a(this, getForumName(), "from", intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false)) && getActivity() != null) {
                getActivity().finish();
                return;
            }
        }
        if (intent != null && intent.getData() != null) {
            Uri data = intent.getData();
            this.cXa = data.getQueryParameter("name");
            this.mFrom = data.getQueryParameter("from");
            if (!StringUtils.isNull(this.cXa)) {
                intent.putExtra("name", this.cXa);
            }
            if (!StringUtils.isNull(this.mFrom)) {
                intent.putExtra("from", this.mFrom);
            }
            TiebaStatic.log("c10105");
        }
        if (StringUtils.isNull(this.cXa)) {
            this.cXa = com.baidu.tieba.frs.f.h.K(intent);
            if (!StringUtils.isNull(this.cXa)) {
                intent.putExtra("name", this.cXa);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.cXg = getVoiceManager();
        if (this.cXg != null) {
            this.cXg.onStart(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        Intent intent;
        registerListener(2001118, this.auR);
        if (bundle != null) {
            this.cXa = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
            this.cXa = intent.getStringExtra("name");
            this.mFrom = intent.getStringExtra("from");
            this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
        }
        if (TextUtils.isEmpty(this.mFrom) || FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
        }
        if (this.mIsLogin) {
            registerListener(2001120, this.auR);
        }
        this.cXq.l(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.cYq);
        if (this.cXg != null) {
            this.cXg.onDestory(getPageContext());
        }
        this.cXg = null;
        com.baidu.tieba.card.v.afy().et(false);
        if (this.cWL != null && this.cWL.aVq() != null) {
            aa.aqH().bC(com.baidu.adp.lib.g.b.c(this.cWL.aVq().getId(), 0L));
        }
        if (this.cXE != null) {
            this.cXE.onDestory();
        }
        if (this.cXh != null) {
            com.baidu.tieba.frs.f.g.a(this.cXh, this.cWL, getForumId(), false, null);
            this.cXh.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.cXn != null) {
                this.cXn.onDestroy();
            }
            this.cXh.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.cXp.onActivityDestroy();
        this.cXq.onActivityDestroy();
        if (this.cXp != null) {
            this.cXp.Ry();
        }
        if (this.cXv != null) {
            this.cXv.HM();
        }
        if (this.cXy != null) {
            this.cXy.destory();
        }
        if (this.cXz != null) {
            this.cXz.destory();
        }
        if (this.cXt != null) {
            this.cXt.onDestroy();
        }
        if (this.cXL != null) {
            this.cXL.onDestory();
        }
        if (this.cXD != null) {
            this.cXD.onDestroy();
        }
        if (this.cXO != null) {
            this.cXO.onDestroy();
        }
        if (this.cXP != null) {
            this.cXP.onDestroy();
        }
        com.baidu.tieba.recapp.d.a.bjZ().bkb();
        com.baidu.tieba.frs.f.i.auO();
        if (this.cXr != null) {
            this.cXr.a((FrsTabViewController.a) null);
            this.cXr.avv();
        }
        if (this.cXQ != null) {
            this.cXQ.onDestroy();
        }
        if (this.cXR != null) {
            this.cXR.onDestroy();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.cXa);
        bundle.putString("from", this.mFrom);
        this.cXp.onSaveInstanceState(bundle);
        if (this.cXg != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            this.cXg.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.cXD != null) {
            this.cXD.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.cXh != null) {
            this.cXh.aqk();
            this.cXh.onResume();
        }
        this.cXs.fT(true);
        this.cXo = true;
        if (cWZ) {
            cWZ = false;
            this.cXh.startPullRefresh();
            return;
        }
        if (this.cXg != null) {
            this.cXg.onResume(getPageContext());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921338));
        this.cXh.fx(false);
        registerListener(this.cYl);
        if (this.cXM) {
            refresh(6);
            this.cXM = false;
        }
        if (KuangFloatingViewController.getInstance().init()) {
            ((BaseFragmentActivity) getPageContext().getOrignalPage()).grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.frs.FrsFragment.19
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
        refresh();
    }

    public boolean apw() {
        Intent intent;
        if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
            return false;
        }
        return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
    }

    public void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.cXa = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.cXb = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.cXb) {
                apx();
            }
            if (this.mFrom != null && this.mFrom.equals("from_tieba_kuang")) {
                KuangFloatingViewController.getInstance().setNeedShowFloatingView(true);
                if (KuangFloatingViewController.getInstance().init()) {
                    ((BaseFragmentActivity) getPageContext().getOrignalPage()).grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.frs.FrsFragment.20
                        @Override // com.baidu.tbadk.core.e
                        public void ak(boolean z) {
                            if (z) {
                                KuangFloatingViewController.getInstance().showFloatingView();
                            }
                        }
                    });
                }
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SCHEMA_UPLOAD);
                httpMessage.addParam("call_url", com.baidu.adp.lib.util.k.aS("shoubai://internal?type=frs&param=" + this.cXa));
                MessageManager.getInstance().sendMessage(httpMessage);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apx() {
        this.cXh.startPullRefresh();
    }

    public void closeActivity() {
        com.baidu.tieba.frs.f.h.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.mFrom);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.cXh.setTitle(this.cXa);
        } else {
            this.cXh.setTitle("");
            this.mFlag = 1;
        }
        this.cXh.setOnAdapterItemClickListener(this.cYo);
        this.cXh.addOnScrollListener(this.mScrollListener);
        this.cXh.h(this.cVe);
        this.cXh.aqt().a(this.cYn);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cXh.onChangeSkinType(i);
        this.cXq.lm(i);
        this.cXr.onChangeSkinType(i);
        if (this.cXK != null) {
            this.cXK.onChangeSkinType();
        }
        if (this.cXQ != null) {
            this.cXQ.onChangeSkinType(i);
        }
    }

    public void kc(int i) {
        if (!this.mIsLogin) {
            if (this.cWL != null && this.cWL.qT() != null) {
                this.cWL.qT().setIfpost(1);
            }
            if (i == 0) {
                az.aJ(getActivity());
            }
        } else if (this.cWL != null) {
            if (i == 0) {
                com.baidu.tieba.frs.f.i.c(this, 0);
            } else {
                this.cXh.aqm();
            }
        }
    }

    public void refresh() {
        com.baidu.tieba.a.d.MH().hX("page_frs");
        refresh(3);
    }

    public void refresh(int i) {
        this.cXl = false;
        apC();
        if (this.cXh.aqc() != null) {
            this.cXh.aqc().aza();
        }
        this.cXp.t(i, true);
    }

    private void apy() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.g.h.fx().d(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.21
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.sX(FrsFragment.this.cXa);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apz() {
        apC();
        try {
            if (this.cWL != null) {
                this.cXh.showListView();
                this.cXh.fs(this.cXp.aui());
                if (!com.baidu.tieba.frs.vc.f.i(this.cWL) || !com.baidu.tieba.frs.vc.f.h(this.cWL)) {
                }
                if (this.cWL.aVq() != null) {
                    this.cXa = this.cWL.aVq().getName();
                    this.forumId = this.cWL.aVq().getId();
                }
                if (this.cWL.rg() != null) {
                    setHasMore(this.cWL.rg().rc());
                }
                this.cXh.setTitle(this.cXa);
                this.cXh.setForumName(this.cXa);
                TbadkCoreApplication.getInst().setDefaultBubble(this.cWL.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.cWL.getUserData().getBimg_end_time());
                apy();
                apA();
                ArrayList<com.baidu.adp.widget.ListView.h> threadList = this.cWL.getThreadList();
                if (threadList != null) {
                    this.cXh.a(threadList, this.cWL);
                    com.baidu.tieba.frs.f.c.v(this.cXh);
                    this.cXq.ln(getPageNum());
                    this.cXq.f(this.cWL);
                    this.cXr.a(this.cWL, this.cXp.aun());
                    this.cXh.aqn();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void apA() {
        if (this.cWL != null) {
            if (this.cWL.aVF() == 1) {
                this.cXh.aqt().setFromCDN(true);
            } else {
                this.cXh.aqt().setFromCDN(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.cXs.fT(false);
        this.cXo = false;
        this.cXh.onPause();
        if (this.cXg != null) {
            this.cXg.onPause(getPageContext());
        }
        this.cXh.fx(true);
        if (this.cXz != null) {
            this.cXz.auR();
        }
        MessageManager.getInstance().unRegisterListener(this.cYl);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.cXr != null && this.cXr.avt() != null && (this.cXr.avt().fragment instanceof BaseFragment)) {
            ((BaseFragment) this.cXr.avt().fragment).setPrimary(z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.v.afy().et(false);
        if (this.cWL != null && this.cWL.aVq() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            com.baidu.tbadk.distribute.a.Dq().a(getPageContext().getPageActivity(), "frs", this.cWL.aVq().getId(), 0L);
        }
        if (this.cXg != null) {
            this.cXg.onStop(getPageContext());
        }
        if (xj() != null) {
            xj().getRecycledViewPool().clear();
        }
        this.cXq.onActivityStop();
        com.baidu.tbadk.util.t.HQ();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && this.cXq != null) {
            this.cXq.fV(isPrimary());
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || this.cXh == null) {
            return false;
        }
        return this.cXh.aqj();
    }

    @Override // com.baidu.tieba.recapp.n
    public TbPageContext<?> aeY() {
        return getPageContext();
    }

    @Override // com.baidu.tieba.recapp.n
    public void a(AdvertAppInfo advertAppInfo, String str) {
        com.baidu.tbadk.distribute.a.Dq().a(advertAppInfo, this.forumId, 0L, "FRS", str, getPn());
    }

    @Override // com.baidu.tieba.recapp.n
    public void apB() {
        aph().apB();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.cXg == null) {
            this.cXg = VoiceManager.instance();
        }
        return this.cXg;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdRecyclerView xj() {
        if (this.cXh == null) {
            return null;
        }
        return this.cXh.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void apC() {
        if (this.cXg != null) {
            this.cXg.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> xk() {
        if (this.aqg == null) {
            this.aqg = UserIconBox.h(getPageContext().getPageActivity(), 8);
        }
        return this.aqg;
    }

    public void apD() {
        if (getFragmentActivity() != null && getFragmentActivity().getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.b(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.k onGetPreLoadListView() {
        return xj().getPreLoadHandle();
    }

    @Override // com.baidu.tieba.frs.ai
    public NavigationBar Rg() {
        if (this.cXh == null) {
            return null;
        }
        return this.cXh.Rg();
    }

    /* loaded from: classes2.dex */
    private final class a implements com.baidu.adp.widget.ListView.n {
        private a() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v13, resolved type: com.baidu.tieba.frs.FrsFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.n
        public void a(View view2, com.baidu.adp.widget.ListView.h hVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null) {
                if (bdUniqueId == n.cZC) {
                    if (FrsFragment.this.cXh != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.al("c11752").ac(ImageViewerConfig.FORUM_ID, FrsFragment.this.forumId).ac("obj_locate", "1"));
                        FrsFragment.this.cXh.startPullRefresh();
                    }
                } else if (hVar != null && (hVar instanceof bd)) {
                    bd bdVar = (bd) hVar;
                    if (bdVar.sz() == null || bdVar.sz().getGroup_id() == 0 || az.aK(FrsFragment.this.getActivity())) {
                        if (bdVar.ss() != 1 || az.aK(FrsFragment.this.getActivity())) {
                            if (bdVar.sd() != null) {
                                if (az.aK(FrsFragment.this.getActivity())) {
                                    String postUrl = bdVar.sd().getPostUrl();
                                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.hg()) {
                                        com.baidu.tbadk.browser.a.N(FrsFragment.this.getActivity(), postUrl);
                                    }
                                }
                            } else if (bdVar.sI() != null) {
                                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                    az.aJ(FrsFragment.this.getPageContext().getPageActivity());
                                    return;
                                }
                                com.baidu.tbadk.core.data.n sI = bdVar.sI();
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), sI.getCartoonId(), sI.getChapterId(), 2)));
                            } else {
                                com.baidu.tieba.tbadkCore.util.e readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                                if (readThreadHistory != null && !readThreadHistory.td(bdVar.getId())) {
                                    readThreadHistory.tc(bdVar.getId());
                                }
                                boolean z = false;
                                final String rX = bdVar.rX();
                                if (rX != null && !rX.equals("")) {
                                    z = true;
                                    new Thread(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.a.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(rX);
                                            xVar.vj().wi().mIsNeedAddCommenParam = false;
                                            xVar.vj().wi().mIsUseCurrentBDUSS = false;
                                            xVar.uM();
                                        }
                                    }).start();
                                }
                                String tid = bdVar.getTid();
                                if (tid == null) {
                                    tid = "";
                                }
                                if (bdVar.rL() == 2 && !tid.startsWith("pb:")) {
                                    ax.wg().c(FrsFragment.this.getPageContext(), new String[]{tid, "", null});
                                    return;
                                }
                                if (tid.startsWith("pb:")) {
                                    bdVar.setId(tid.substring(3));
                                }
                                if (bdUniqueId.getId() == bd.aaV.getId()) {
                                    com.baidu.tieba.frs.f.g.a(bdVar.rA());
                                } else if (bdUniqueId.getId() == bd.ZO.getId()) {
                                    com.baidu.tbadk.core.util.al alVar = new com.baidu.tbadk.core.util.al("c12940");
                                    alVar.ac("obj_type", "2");
                                    alVar.ac("tid", bdVar.getTid());
                                    TiebaStatic.log(alVar);
                                }
                                com.baidu.tieba.frs.f.h.a(FrsFragment.this, bdVar, i, z);
                                com.baidu.tieba.frs.f.g.a(FrsFragment.this, FrsFragment.this.cWL, bdVar);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.l.hg()) {
            hideNetRefreshView(this.cXh.ZG());
            showLoadingView(this.cXh.ZG(), true);
            this.cXh.fv(false);
            this.cXp.t(3, true);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public com.baidu.tieba.tbadkCore.l apE() {
        return this.cWL;
    }

    public boolean apF() {
        return this.cXh.apF();
    }

    public void R(Object obj) {
        if (this.cXu != null && this.cXu.dmT != null) {
            this.cXu.dmT.f(obj);
        }
    }

    public void S(Object obj) {
        if (this.cXu != null && this.cXu.dmU != null) {
            this.cXu.dmU.f(obj);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.l.hg()) {
            this.cXh.Qq();
        } else if (this.cXp.auh() == 1) {
            PC();
            Po();
        } else if (this.cXp.hasMore()) {
            Po();
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void lx(String str) {
        PC();
        showToast(str);
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void J(ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        PC();
        if (!com.baidu.tbadk.core.util.v.w(arrayList)) {
            if (!this.cXp.aur() && TbadkCoreApplication.getInst().isRecAppExist() && this.cXp.auh() == 1) {
                this.cWL.a(this, arrayList);
            }
            ArrayList<com.baidu.adp.widget.ListView.h> a2 = this.cXB.a(false, false, arrayList, this.cXd);
            if (a2 != null) {
                this.cWL.av(a2);
                this.cXh.a(a2, this.cWL);
            }
            if (this.cXp != null) {
                com.baidu.tieba.frs.e.b.a(this.cWL, this.cXp.aun(), 2);
            }
        }
    }

    private void PC() {
        if (apo() == 1 || this.cXB.bo(this.cWL.bqh())) {
            if (com.baidu.tbadk.core.util.v.v(this.cWL.getThreadList()) > 3) {
                this.cXh.Qo();
            } else {
                this.cXh.aqw();
            }
        } else if (com.baidu.tbadk.core.util.v.w(this.cWL.getThreadList())) {
            this.cXh.Qq();
        } else {
            this.cXh.Qp();
        }
    }

    @Override // com.baidu.tieba.frs.mc.j
    public void Po() {
        if (this.cXB != null) {
            this.cXB.a(this.cXa, this.forumId, this.cWL);
        }
    }

    public void takePhoto() {
        if (!com.baidu.tbadk.core.util.ab.e(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.aj.b(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return apG() ? "a034" : "a006";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (!apG()) {
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

    @Override // android.support.v4.app.Fragment
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        com.baidu.tieba.frs.f.h.a(this, i, strArr, iArr);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(getForumId(), 0L));
        }
        return pageStayDurationItem;
    }

    public void fp(boolean z) {
        if (this.cXv != null) {
            this.cXv.fC(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.cXw.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a ga(int i) {
        return this.cXw.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        this.cXF.b(bVar);
    }

    public boolean apG() {
        return this.cWW;
    }

    @Override // com.baidu.tieba.frs.af
    public void PP() {
        if (this.cXh != null) {
            showFloatingView();
            this.cXh.getListView().scrollToPosition(0);
            this.cXh.startPullRefresh();
        }
    }

    public ForumWriteData apH() {
        if (this.cWL == null || this.cWL.aVq() == null) {
            return null;
        }
        ForumData aVq = this.cWL.aVq();
        ForumWriteData forumWriteData = new ForumWriteData(aVq.getId(), aVq.getName(), aVq.getPrefixData(), this.cWL.qT());
        forumWriteData.avatar = aVq.getImage_url();
        forumWriteData.forumLevel = aVq.getUser_level();
        forumWriteData.specialForumType = aVq.special_forum_type;
        forumWriteData.firstDir = aVq.getFirst_class();
        forumWriteData.secondDir = aVq.getSecond_class();
        UserData userData = this.cWL.getUserData();
        forumWriteData.privateThread = userData != null ? userData.getPrivateThread() : 0;
        return forumWriteData;
    }

    @Override // com.baidu.tieba.frs.af
    public void wY() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.frs.af
    public void setVideoThreadId(String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view2, boolean z) {
        super.showLoadingView(view2, z);
        this.cXh.kf(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view2) {
        super.hideLoadingView(view2);
        this.cXh.kf(0);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view2, String str, boolean z) {
        super.showNetRefreshView(view2, str, z);
        this.cXh.kf(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshViewNoClick(View view2, String str, boolean z) {
        super.showNetRefreshViewNoClick(view2, str, z);
        this.cXh.kf(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view2) {
        super.hideNetRefreshView(view2);
        this.cXh.kf(0);
    }

    public void apI() {
        FrsTabViewController.b avt;
        if (this.cXr != null && (avt = this.cXr.avt()) != null && avt.fragment != null && (avt.fragment instanceof ah)) {
            ((ah) avt.fragment).aoY();
        }
    }

    public void a(ContriInfo contriInfo) {
        if (this.cXQ == null) {
            this.cXQ = new com.baidu.tbadk.core.dialog.i(aeY());
        }
        this.cXQ.a(contriInfo, -1L);
    }

    public void fq(boolean z) {
        this.cWY = z;
    }

    public boolean apJ() {
        return this.cWY;
    }

    public void lK(String str) {
        if (TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.util.an.isEmpty(str)) {
            if (this.cXR == null) {
                this.cXR = new AddExperiencedModel(aeY());
                this.cXR.a(this.cXS);
            }
            this.cXR.bV(this.forumId, str);
        }
    }

    public com.baidu.tieba.frs.entelechy.b apK() {
        return this.cWU;
    }
}
