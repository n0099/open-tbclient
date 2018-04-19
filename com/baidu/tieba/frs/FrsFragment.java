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
    public static boolean cXc = false;
    public static volatile long cXl = 0;
    public static volatile long cXm = 0;
    public static volatile int cXn = 0;
    private com.baidu.tbadk.util.r aNJ;
    private com.baidu.adp.lib.e.b<TbImageView> aqg;
    private com.baidu.tieba.frs.gametab.b buc;
    private com.baidu.tieba.frs.entelechy.b cWX;
    private com.baidu.tieba.frs.entelechy.b.b cXA;
    private com.baidu.tbadk.h.a cXB;
    private com.baidu.tieba.frs.vc.a cXC;
    private com.baidu.tieba.frs.mc.d cXD;
    private com.baidu.tieba.frs.mc.c cXE;
    private com.baidu.tieba.frs.vc.h cXF;
    private com.baidu.tieba.frs.mc.a cXG;
    private com.baidu.tieba.frs.live.a cXH;
    private h cXI;
    public com.baidu.tieba.frs.vc.c cXJ;
    private com.baidu.tieba.frs.mc.e cXK;
    private int cXL;
    private View.OnTouchListener cXM;
    private com.baidu.tieba.frs.view.a cXN;
    private com.baidu.tieba.frs.vc.e cXO;
    private boolean cXP;
    private com.baidu.tieba.NEGFeedBack.a cXR;
    private com.baidu.tieba.ala.a cXS;
    private com.baidu.tbadk.core.dialog.i cXT;
    private AddExperiencedModel cXU;
    private com.baidu.tieba.tbadkCore.data.e cXg;
    private VoiceManager cXj;
    private FrsModelController cXs;
    private com.baidu.tieba.frs.vc.f cXt;
    private FrsTabViewController cXu;
    private com.baidu.tieba.frs.mc.f cXv;
    private com.baidu.tieba.frs.smartsort.b cXw;
    private com.baidu.tieba.frs.mc.b cXx;
    private al cXy;
    public View mRootView;
    public boolean cWY = false;
    private boolean cWZ = false;
    private boolean cXa = false;
    private boolean cXb = true;
    public String cXd = null;
    public String mFrom = null;
    public int mFlag = 0;
    private boolean cXe = false;
    private String mThreadId = null;
    public String forumId = null;
    private int cWR = 0;
    private boolean cXf = false;
    private boolean cXh = false;
    private boolean cXi = false;
    private i cXk = null;
    public final bd bjU = null;
    private com.baidu.tieba.tbadkCore.l cWO = new com.baidu.tieba.tbadkCore.l();
    public long cHR = -1;
    public long aKV = 0;
    public long aKN = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean cXo = false;
    private boolean cXp = false;
    public com.baidu.tbadk.k.d cXq = null;
    private boolean cXr = true;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> cXz = new SparseArray<>();
    private boolean bvq = true;
    private boolean cXQ = false;
    private AddExperiencedModel.a cXV = new AddExperiencedModel.a() { // from class: com.baidu.tieba.frs.FrsFragment.1
        @Override // com.baidu.tieba.share.AddExperiencedModel.a
        public void b(ContriInfo contriInfo) {
            if (contriInfo != null && contriInfo.isShowToast()) {
                FrsFragment.this.a(contriInfo);
            }
        }
    };
    private HttpMessageListener cXW = new HttpMessageListener(CmdConfigHttp.CMD_PB_FLOOR_AGREE, true) { // from class: com.baidu.tieba.frs.FrsFragment.12
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
    private final CustomMessageListener cXX = new CustomMessageListener(2016495) { // from class: com.baidu.tieba.frs.FrsFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof bd) {
                    com.baidu.tieba.frs.f.g.a(FrsFragment.this.cXk, FrsFragment.this.cWO, FrsFragment.this.getForumId(), true, (bd) data);
                }
            }
        }
    };
    private CustomMessageListener cXY = new CustomMessageListener(2921005) { // from class: com.baidu.tieba.frs.FrsFragment.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.cWO != null) {
                FrsFragment.this.cWO.brc();
                if (FrsFragment.this.cXk != null) {
                    FrsFragment.this.cXk.agD();
                }
            }
        }
    };
    private CustomMessageListener cXZ = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.FrsFragment.31
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
    private final aj cYa = new aj() { // from class: com.baidu.tieba.frs.FrsFragment.32
        @Override // com.baidu.tieba.frs.aj
        public void a(int i, int i2, ap apVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
            FrsFragment.this.apq();
            if (FrsFragment.this.cXA != null) {
                FrsFragment.this.cXt.fW(FrsFragment.this.cXA.kv(i));
            }
            d.a aVar = new d.a();
            if (apVar != null) {
                aVar.isSuccess = apVar.errCode == 0;
                aVar.errorCode = apVar.errCode;
                aVar.errorMsg = apVar.errMsg;
                if (aVar.isSuccess) {
                    if (com.baidu.tbadk.core.util.v.w(arrayList)) {
                        FrsFragment.this.cXk.Qq();
                    } else if (apVar.hasMore) {
                        if (com.baidu.tbadk.core.util.v.v(FrsFragment.this.cWO.getThreadList()) > 3) {
                            FrsFragment.this.cXk.Qo();
                        } else {
                            FrsFragment.this.cXk.aqw();
                        }
                    } else if (apVar.daw) {
                        FrsFragment.this.cXk.Qp();
                    } else {
                        FrsFragment.this.cXk.Qq();
                    }
                }
            } else {
                apVar = new ap();
                apVar.pn = 1;
                apVar.hasMore = false;
                apVar.daw = false;
            }
            if (i == 1) {
                FrsFragment.this.cXr = true;
                FrsFragment.this.cYk.a(FrsFragment.this.cXs.getType(), false, aVar);
            } else {
                FrsFragment.this.a(aVar);
                if (FrsFragment.this.cXs.atJ() != null) {
                    FrsFragment.this.cWO = FrsFragment.this.cXs.atJ();
                }
                FrsFragment.this.apz();
            }
            if (FrsFragment.this.cYs != null) {
                FrsFragment.this.cYs.a(i, i2, apVar, arrayList);
            }
        }
    };
    private FrsTabViewController.a cYb = new FrsTabViewController.a() { // from class: com.baidu.tieba.frs.FrsFragment.33
        @Override // com.baidu.tieba.frs.vc.FrsTabViewController.a
        public void eS(int i) {
            if (i != 1) {
                com.baidu.tieba.card.v.afy().et(false);
            }
            FrsFragment.this.apC();
            com.baidu.tieba.frs.e.c.doy.dop = i;
            com.baidu.tieba.frs.e.c.doy.doq = -1;
        }
    };
    private CustomMessageListener cYc = new CustomMessageListener(2001606) { // from class: com.baidu.tieba.frs.FrsFragment.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                FrsFragment.this.cXu.lu(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    };
    private CustomMessageListener cYd = new CustomMessageListener(2001607) { // from class: com.baidu.tieba.frs.FrsFragment.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && ((Integer) customResponsedMessage.getData()).intValue() == 51 && FrsFragment.this.cWO != null) {
                com.baidu.tieba.frs.f.i.a(FrsFragment.this.cWO, FrsFragment.this.getPageContext());
            }
        }
    };
    private final CustomMessageListener cYe = new CustomMessageListener(2003019) { // from class: com.baidu.tieba.frs.FrsFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                FrsFragment.this.cXu.ls(49);
            }
        }
    };
    private final CustomMessageListener cYf = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.frs.FrsFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && FrsFragment.this.cWO != null && FrsFragment.this.cWO.aVq() != null) {
                SignData signData = (SignData) customResponsedMessage.getData();
                int user_level = FrsFragment.this.cWO.aVq().getUser_level();
                if (signData.forumId != null && signData.forumId.equals(FrsFragment.this.cWO.aVq().getId())) {
                    FrsFragment.this.cWO.d(signData);
                    FrsFragment.this.cXt.g(FrsFragment.this.cWO);
                    if (FrsFragment.this.cXt.avn()) {
                        i = FrsFragment.this.cWO.aVq().getUser_level();
                        if (user_level >= i) {
                            i++;
                        }
                    } else {
                        i = user_level;
                    }
                    TbadkCoreApplication.getInst().addSignedForum(FrsFragment.this.cWO.aVq().getName(), signData.sign_bonus_point, i);
                }
            }
        }
    };
    private final CustomMessageListener cYg = new CustomMessageListener(2001352) { // from class: com.baidu.tieba.frs.FrsFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.r) && FrsFragment.this.cWO != null) {
                FrsFragment.this.cWO.c((com.baidu.tieba.tbadkCore.r) customResponsedMessage.getData());
                FrsFragment.this.cXt.f(FrsFragment.this.cWO);
                FrsFragment.this.cXu.a(FrsFragment.this.cWO, FrsFragment.this.cXs.aun());
            }
        }
    };
    private final AntiHelper.a cYh = new AntiHelper.a() { // from class: com.baidu.tieba.frs.FrsFragment.5
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
                        if (AntiHelper.a(FrsFragment.this.getActivity(), updateAttentionMessage.getData().auo, FrsFragment.this.cYh) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.al("c12534").r("obj_locate", ar.a.aje));
                        }
                    } else if (updateAttentionMessage.getData().Aj && updateAttentionMessage.getData().isAttention) {
                        com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getPageContext().getPageActivity(), d.k.attention_success);
                    }
                }
            }
        }
    };
    private CustomMessageListener cYi = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.frs.FrsFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                FrsFragment.this.cXk.c((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener cYj = new CustomMessageListener(2001626) { // from class: com.baidu.tieba.frs.FrsFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewsRemindMessage newsRemindMessage;
            if (customResponsedMessage != null && (customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626 && (newsRemindMessage = (NewsRemindMessage) customResponsedMessage) != null) {
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (FrsFragment.this.cXk != null) {
                    FrsFragment.this.cXk.q(notificationCount, z);
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.n cYk = new com.baidu.tieba.tbadkCore.n() { // from class: com.baidu.tieba.frs.FrsFragment.9
        private long startTime = 0;

        @Override // com.baidu.tieba.tbadkCore.n
        public void kd(int i) {
            this.startTime = System.nanoTime();
            if (FrsFragment.this.cXk != null) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsFragment.this.cXk.aqk();
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
                com.baidu.tieba.frs.f.g.a(FrsFragment.this.cXk, FrsFragment.this.cWO, FrsFragment.this.getForumId(), false, null);
            }
            FrsFragment.this.apq();
            FrsFragment.this.cXo = true;
            if (aVar != null && aVar.isSuccess) {
                FrsFragment.this.cXk.aqt().fJ(com.baidu.tbadk.core.util.ap.vQ().vS());
                FrsFragment.cXl = 0L;
                FrsFragment.cXm = 0L;
                FrsFragment.cXn = 0;
            } else {
                FrsFragment.cXn = 1;
            }
            if (!FrsFragment.this.cXs.aur() && (i == 3 || i == 6)) {
                FrsFragment.this.cXE.resetData();
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (FrsFragment.this.cXs.atJ() != null) {
                FrsFragment.this.cWO = FrsFragment.this.cXs.atJ();
            }
            FrsFragment.this.ka(1);
            if (i == 7) {
                FrsFragment.this.kb(FrsFragment.this.cWO.bqs());
                return;
            }
            if (FrsFragment.this.cWO.rg() != null) {
                FrsFragment.this.setHasMore(FrsFragment.this.cWO.rg().rc());
            }
            FrsFragment.this.apr();
            if (i == 4) {
                if (!FrsFragment.this.cXs.aur() && TbadkCoreApplication.getInst().isRecAppExist() && FrsFragment.this.cXs.auh() == 1) {
                    FrsFragment.this.cWO.a(FrsFragment.this);
                }
                ArrayList<com.baidu.adp.widget.ListView.h> a2 = FrsFragment.this.cXE.a(false, false, FrsFragment.this.cWO.getThreadList(), FrsFragment.this.cXg);
                if (a2 != null) {
                    FrsFragment.this.cWO.av(a2);
                    FrsFragment.this.cWO.bqU();
                    FrsFragment.this.cXk.a(a2, FrsFragment.this.cWO);
                }
                if (FrsFragment.this.cXs != null) {
                    com.baidu.tieba.frs.e.b.a(FrsFragment.this.cWO, FrsFragment.this.cXs.aun(), 2);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsFragment.this.cXk.aqk();
                    break;
                case 2:
                    FrsFragment.this.cXk.aqk();
                    break;
                case 3:
                case 6:
                    if (FrsFragment.this.cWO != null) {
                        FrsFragment.this.cWO.bqS();
                    }
                    if (FrsFragment.this.cXJ != null) {
                        FrsFragment.this.cXJ.refresh();
                        break;
                    }
                    break;
            }
            FrsFragment.this.aps();
            if (aVar == null || aVar.errorCode == 0) {
                if (FrsFragment.this.cWO != null) {
                    FrsFragment.this.t(false, i == 5);
                    FrsFragment.this.cXk.kh(i);
                    FrsFragment.cXl = (System.nanoTime() - this.startTime) / 1000000;
                    if (aVar != null) {
                        FrsFragment.cXm = aVar.gto;
                    }
                } else {
                    return;
                }
            } else if (FrsFragment.this.cWO == null || com.baidu.tbadk.core.util.v.w(FrsFragment.this.cWO.getThreadList())) {
                FrsFragment.this.a(aVar);
            } else if (aVar.gtn) {
                FrsFragment.this.showToast(FrsFragment.this.getPageContext().getResources().getString(d.k.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
            }
            if (FrsFragment.this.cWO.bqb() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.al("c11384"));
            }
            if (FrsFragment.this.cHR > -1 && !FrsFragment.this.cXQ) {
                com.baidu.tieba.frs.f.g.a(FrsFragment.this.cXs, FrsFragment.this.cHR);
                FrsFragment.this.cHR = -1L;
                FrsFragment.this.cXQ = true;
            }
            if (FrsFragment.this.cXh && FrsFragment.this.cXu.ls(49)) {
                FrsFragment.this.cXh = false;
            }
            FrsFragment.this.aKV = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void b(com.baidu.tieba.tbadkCore.i iVar) {
            if (iVar != null) {
                if ("normal_page".equals(FrsFragment.this.cXs.aud()) || "frs_page".equals(FrsFragment.this.cXs.aud()) || "book_page".equals(FrsFragment.this.cXs.aud())) {
                    FrsFragment.this.a(iVar);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001615, iVar));
                }
            }
        }
    };
    private final CustomMessageListener cYl = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.frs.FrsFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.h) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                FrsFragment.this.cWO.a((com.baidu.tbadk.data.h) customResponsedMessage.getData());
                FrsFragment.this.cXk.aqt().notifyDataSetChanged();
            }
        }
    };
    private final CustomMessageListener mMemListener = new CustomMessageListener(2001194) { // from class: com.baidu.tieba.frs.FrsFragment.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && FrsFragment.this.cWO != null && (userData = FrsFragment.this.cWO.getUserData()) != null) {
                userData.setIsMem(num.intValue());
                if (num.intValue() != 0) {
                    FrsFragment.this.cXt.g(num);
                }
            }
        }
    };
    private final com.baidu.tieba.frs.mc.i cYm = new com.baidu.tieba.frs.mc.i() { // from class: com.baidu.tieba.frs.FrsFragment.15
        @Override // com.baidu.tieba.frs.mc.i
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.h> arrayList, boolean z3) {
            if (FrsFragment.this.cXw != null && FrsFragment.this.cXs != null && FrsFragment.this.cXs.aur() && z && !z2 && !z3) {
                FrsFragment.this.cXw.kX(i2);
            }
        }
    };
    public final View.OnTouchListener aNK = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.FrsFragment.16
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            if (FrsFragment.this.cXM != null) {
                FrsFragment.this.cXM.onTouch(view2, motionEvent);
            }
            if (FrsFragment.this.cXy != null && FrsFragment.this.cXy.aqK() != null) {
                FrsFragment.this.cXy.aqK().onTouchEvent(motionEvent);
            }
            if (FrsFragment.this.buc != null) {
                FrsFragment.this.buc.d(view2, motionEvent);
            }
            if (FrsFragment.this.cXt != null) {
                FrsFragment.this.cXt.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private final CustomMessageListener cYn = new CustomMessageListener(2004507) { // from class: com.baidu.tieba.frs.FrsFragment.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "photolive_hostLevel", -1) != -1 && FrsFragment.this.cWO.aVq() != null) {
                FrsFragment.this.cWO.aVq().setCanAddPhotoLivePost(true);
            }
        }
    };
    private final CustomMessageListener cYo = new CustomMessageListener(2016493) { // from class: com.baidu.tieba.frs.FrsFragment.18
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
    public final View.OnClickListener cYp = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.22
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (FrsFragment.this.cXk == null || view2 != FrsFragment.this.cXk.aqi() || FrsFragment.this.getActivity() == null) {
                if (FrsFragment.this.cWO != null && FrsFragment.this.cWO.aVq() != null && FrsFragment.this.cXk != null && view2 == FrsFragment.this.cXk.aqo()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.al("c12402").ac(ImageViewerConfig.FORUM_ID, FrsFragment.this.cWO.aVq().getId()).ac("uid", TbadkCoreApplication.getCurrentAccount()).ac(ImageViewerConfig.FORUM_NAME, FrsFragment.this.cWO.aVq().getName()));
                    if (!StringUtils.isNull(FrsFragment.this.cWO.aVq().getName())) {
                        FrsFragment.this.sendMessage(new CustomMessage(2002001, new PostSearchActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), FrsFragment.this.cWO.aVq().getName(), FrsFragment.this.cWO.aVq().getId())));
                        return;
                    }
                    return;
                }
                if (view2.getId() == d.g.game_activity_egg_layout && com.baidu.adp.lib.util.l.hg()) {
                    TiebaStatic.log("c10853");
                    if (FrsFragment.this.cXk.aqq()) {
                        FrsFragment.this.cXk.aqr();
                    } else {
                        String activityUrl = FrsFragment.this.cWO.aVq().getYuleData().tw().getActivityUrl();
                        if (!StringUtils.isNull(activityUrl)) {
                            com.baidu.tbadk.browser.a.N(FrsFragment.this.getPageContext().getPageActivity(), activityUrl);
                        }
                    }
                }
                if (view2 == FrsFragment.this.cXk.aqx() && FrsFragment.this.cXs != null && FrsFragment.this.cXs.hasMore()) {
                    FrsFragment.this.cXk.Qo();
                    FrsFragment.this.Po();
                }
                if (view2 != null && view2 == FrsFragment.this.cXk.aqp() && az.aK(FrsFragment.this.getContext())) {
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
        private int cYv = 0;
        private int bjz = 0;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (FrsFragment.this.cXC != null) {
                FrsFragment.this.cXC.auR();
            }
            this.cYv = 0;
            this.bjz = 0;
            if (recyclerView != null && (recyclerView instanceof BdRecyclerView)) {
                this.cYv = ((BdRecyclerView) recyclerView).getFirstVisiblePosition();
                this.bjz = ((BdRecyclerView) recyclerView).getLastVisiblePosition();
            }
            if (FrsFragment.this.cXO != null) {
                FrsFragment.this.cXO.a(recyclerView, this.cYv, this.bjz);
            }
            if (FrsFragment.this.cWO != null && FrsFragment.this.cXk != null && FrsFragment.this.cXk.aqt() != null) {
                FrsFragment.this.cXk.az(this.cYv, this.bjz);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (FrsFragment.this.cXt != null) {
                FrsFragment.this.cXt.setScrollState(i);
            }
            if ((i == 2 || i == 1) && !FrsFragment.this.cXp) {
                FrsFragment.this.cXp = true;
                FrsFragment.this.cXk.aqv();
            }
            if (FrsFragment.this.cXq == null && !FrsFragment.this.apG()) {
                FrsFragment.this.cXq = new com.baidu.tbadk.k.d();
                FrsFragment.this.cXq.fi(1000);
            }
            if (i == 0) {
                com.baidu.tieba.card.v.afy().et(true);
                FrsFragment.this.cXk.ay(this.cYv, this.bjz);
            }
            if (FrsFragment.this.cXO != null) {
                FrsFragment.this.cXO.onScrollStateChanged(recyclerView, i);
            }
            if (FrsFragment.this.cXq != null) {
                FrsFragment.this.cXq.GF();
            }
            if (i == 0) {
                com.baidu.tieba.frs.f.g.a(FrsFragment.this.cXk, FrsFragment.this.cWO, FrsFragment.this.getForumId(), false, null);
            }
            if (FrsFragment.this.cXu != null && i == 1) {
                FrsFragment.this.cXu.avv();
            }
        }
    };
    private final b cYq = new b() { // from class: com.baidu.tieba.frs.FrsFragment.25
        @Override // com.baidu.tieba.frs.b
        public void a(int i, int i2, View view2, View view3, bd bdVar) {
            if (i != FrsFragment.this.cXk.aqt().arO()) {
                if (i != FrsFragment.this.cXk.aqt().arP()) {
                    if (i == FrsFragment.this.cXk.aqt().arQ() && FrsFragment.this.cWO != null && FrsFragment.this.cWO.getUserData() != null && FrsFragment.this.cWO.getUserData().isBawu()) {
                        final String bqq = FrsFragment.this.cWO.bqq();
                        if (!com.baidu.tbadk.core.util.an.isEmpty(bqq) && FrsFragment.this.cWO.aVq() != null) {
                            com.baidu.tieba.c.a.a(FrsFragment.this.getPageContext(), FrsFragment.this.cWO.aVq().getId(), FrsFragment.this.cWO.aVq().getName(), new a.InterfaceC0121a() { // from class: com.baidu.tieba.frs.FrsFragment.25.1
                                @Override // com.baidu.tieba.c.a.InterfaceC0121a
                                public void aeX() {
                                    com.baidu.tbadk.browser.a.M(FrsFragment.this.getPageContext().getPageActivity(), bqq);
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.al("c10502").ac(ImageViewerConfig.FORUM_ID, FrsFragment.this.cWO.aVq().getId()).ac("uid", FrsFragment.this.cWO.getUserData().getUserId()));
                                }
                            });
                        }
                    }
                } else if (az.aK(FrsFragment.this.getPageContext().getPageActivity())) {
                    TiebaStatic.log("my_service_ck");
                    if (FrsFragment.this.cWO != null && FrsFragment.this.cWO.aVq() != null) {
                        ForumData aVq = FrsFragment.this.cWO.aVq();
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(aVq.getId(), 0L), aVq.getName(), aVq.getImage_url(), 0)));
                    }
                }
            } else if (az.aK(FrsFragment.this.getActivity())) {
                TiebaStatic.log("forum_fortune_click");
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.getPageContext(), FrsFragment.this.cWO);
            }
        }
    };
    private final NoNetworkView.a cVh = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.FrsFragment.26
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aM(boolean z) {
            if (FrsFragment.this.cXs.auh() == 1 && z && !FrsFragment.this.cXk.apF()) {
                if (FrsFragment.this.cWO == null || com.baidu.tbadk.core.util.v.w(FrsFragment.this.cWO.getThreadList())) {
                    FrsFragment.this.hideNetRefreshView(FrsFragment.this.cXk.ZG());
                    FrsFragment.this.showLoadingView(FrsFragment.this.cXk.ZG(), true);
                    FrsFragment.this.cXk.fv(false);
                    FrsFragment.this.refresh();
                    return;
                }
                FrsFragment.this.cXk.aqk();
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
                com.baidu.tieba.frs.f.c.a(customResponsedMessage, FrsFragment.this.cXk, FrsFragment.this.cWO);
            }
        }
    };
    private com.baidu.adp.widget.ListView.n cYr = new a();
    private aj cYs = new aj() { // from class: com.baidu.tieba.frs.FrsFragment.28
        @Override // com.baidu.tieba.frs.aj
        public void a(int i, int i2, ap apVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
            com.baidu.adp.lib.g.e.fw().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.28.1
                @Override // java.lang.Runnable
                public void run() {
                    if (FrsFragment.this.cXk != null && FrsFragment.this.cXk.agu()) {
                        FrsFragment.this.Po();
                    }
                }
            });
        }
    };
    private CustomMessageListener cYt = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.frs.FrsFragment.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    FrsFragment.this.cXP = true;
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.frs.loadmore.a
    public /* bridge */ /* synthetic */ com.baidu.adp.base.e getPageContext() {
        return super.getPageContext();
    }

    public com.baidu.tieba.frs.entelechy.b.b apd() {
        return this.cXA;
    }

    public com.baidu.adp.widget.ListView.n ape() {
        return this.cYr;
    }

    public com.baidu.tieba.frs.mc.d apf() {
        return this.cXD;
    }

    public com.baidu.tieba.frs.smartsort.b apg() {
        return this.cXw;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public FrsModelController aph() {
        return this.cXs;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public com.baidu.tieba.frs.mc.c apj() {
        return this.cXE;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public com.baidu.tieba.frs.vc.f apk() {
        return this.cXt;
    }

    public com.baidu.tieba.frs.vc.j apl() {
        return this.cXu;
    }

    public al apm() {
        return this.cXy;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public i apn() {
        return this.cXk;
    }

    @Override // com.baidu.tieba.frs.ak
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.ak, com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.cXd;
    }

    public void setForumName(String str) {
        this.cXd = str;
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
        if (this.cXE == null) {
            return 1;
        }
        return this.cXE.getPn();
    }

    public int getPn() {
        if (this.cXE == null) {
            return 1;
        }
        return this.cXE.getPn();
    }

    public void setPn(int i) {
        if (this.cXE != null) {
            this.cXE.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.cXE != null) {
            this.cXE.setHasMore(i);
        }
    }

    public int apo() {
        if (this.cXE == null) {
            return -1;
        }
        return this.cXE.apo();
    }

    public boolean app() {
        return this.cXi;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d.a aVar) {
        if (aVar == null) {
            String string = TbadkCoreApplication.getInst().getString(d.k.error_unkown_try_again);
            this.cXk.aqf();
            showNetRefreshView(this.cXk.ZG(), string, true);
        } else if (340001 == aVar.errorCode) {
            a(aVar, this.cWO.bpY());
        } else {
            if (com.baidu.tbadk.core.util.v.w(this.cWO.getThreadList())) {
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
        this.cXk.aqf();
        this.cXk.kf(8);
        if (this.cXN == null) {
            this.cXN = new com.baidu.tieba.frs.view.a(getPageContext(), getNetRefreshListener());
        }
        this.cXN.setSubText(str);
        this.cXN.bs(list);
        this.cXN.d(view2, z);
    }

    private void a(d.a aVar, List<RecmForumInfo> list) {
        if (this.cXk != null) {
            this.cXk.aqf();
            this.cXk.setTitle(this.cXd);
            a(this.cXk.ZG(), aVar.errorMsg, true, list);
        }
    }

    private void b(d.a aVar) {
        this.cXk.aqf();
        if (aVar.gtn) {
            showNetRefreshView(this.cXk.ZG(), TbadkCoreApplication.getInst().getString(d.k.net_error_text, new Object[]{aVar.errorMsg, Integer.valueOf(aVar.errorCode)}), true);
        } else {
            showNetRefreshView(this.cXk.ZG(), aVar.errorMsg, true);
        }
    }

    public void apq() {
        hideLoadingView(this.cXk.ZG());
        if (!this.cXk.apF()) {
            this.cXk.fw(false);
        } else {
            this.cXk.fw(true);
        }
        if (this.cXk.aqd() instanceof com.baidu.tieba.frs.tab.c) {
            ((com.baidu.tieba.frs.tab.c) this.cXk.aqd()).auL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apr() {
        if (apo() == 0 && com.baidu.tbadk.core.util.v.w(this.cWO.bqh())) {
            if (com.baidu.tbadk.core.util.v.w(this.cWO.getThreadList())) {
                this.cXk.Qq();
            } else {
                this.cXk.Qp();
            }
        } else if (com.baidu.tbadk.core.util.v.v(this.cWO.getThreadList()) > 3) {
            this.cXk.Qo();
        } else {
            this.cXk.aqw();
        }
    }

    public void a(ErrorData errorData) {
        apq();
        this.cXk.aqk();
        d.a aue = this.cXs.aue();
        boolean w = com.baidu.tbadk.core.util.v.w(this.cWO.getThreadList());
        if (aue != null && w) {
            if (this.cXs.auf() != 0) {
                this.cXs.aul();
                this.cXk.aqk();
            } else {
                a(aue);
            }
            this.cXk.u(this.cWO.brj(), false);
            return;
        }
        a(aue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ka(int i) {
        List<WindowToast> list;
        if (TbadkCoreApplication.isLogin() && this.cWO != null && (list = this.cWO.guP) != null && list.size() > 0) {
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
        if (this.cWO == null || this.cWO.aVq() != null) {
            this.cXk.aqs();
        } else if (this.cWO.aVq().getYuleData() != null && this.cWO.aVq().getYuleData().tv()) {
            TiebaStatic.log("c10852");
            this.cXk.a(this.cWO.aVq().getYuleData().tw());
        } else {
            this.cXk.aqs();
        }
    }

    private void s(boolean z, boolean z2) {
        if (this.cXs != null && this.cWO != null && this.cXk != null && z) {
            if (!this.cXs.aur() && this.cXs.auh() == 1) {
                if (!this.cXs.aup()) {
                    this.cWO.bqZ();
                    this.cWO.bra();
                }
                boolean z3 = false;
                if (this.cXk.aqt().k(com.baidu.tieba.card.data.n.csm)) {
                    z3 = this.cWO.brd();
                }
                if (!z3) {
                    this.cWO.brb();
                }
                if (TbadkCoreApplication.getInst().isRecAppExist()) {
                    this.cWO.a(this);
                }
                if (!this.cXk.aqt().k(bd.ZL)) {
                    this.cWO.bqT();
                }
                this.cWO.bre();
            }
            if (!this.cXk.aqt().k(bd.ZL)) {
                this.cWO.bqY();
                this.cWO.bqW();
            } else {
                this.cWO.bqX();
                this.cWO.bqV();
            }
            this.cWO.bqU();
            this.cWO.bqR();
            if (this.cXk.aqt().k(com.baidu.tieba.h.b.duW)) {
                this.cWO.mm(z2);
            }
            if (TbadkCoreApplication.isLogin() && (!this.cXs.aur() || this.cXs.isNetFirstLoad)) {
                this.cWO.brf();
            }
            this.cWO.brh();
        }
    }

    public boolean apt() {
        if (this.cXt != null && this.cXs != null) {
            this.cXt.a(this.cXs.aud(), this.cWO);
        }
        boolean z = false;
        if (this.cWO != null) {
            z = this.cWO.brk();
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
            if (this.cWO != null) {
                this.cXk.a((ArrayList<com.baidu.adp.widget.ListView.h>) null, this.cWO);
                this.cXt.ln(1);
                this.cXk.aqn();
                this.cXu.a(this.cWO, this.cXs.aun());
                com.baidu.tieba.frs.tab.d lt = this.cXu.lt(this.cWO.bqs());
                if (lt != null && !TextUtils.isEmpty(lt.url)) {
                    amVar = new am();
                    amVar.das = lt.url;
                    amVar.stType = lt.name;
                }
                this.cXs.a(this.cWO.bqs(), 0, amVar);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(boolean z, boolean z2) {
        try {
            if (this.cWO != null && this.cXu != null && this.cXs != null) {
                if (!this.cXk.aqt().k(bd.ZL)) {
                    this.cWO.bqT();
                }
                boolean w = com.baidu.tbadk.core.util.v.w(this.cWO.bqG());
                this.cXk.ft(w);
                if (!w) {
                    if (this.cXO == null) {
                        this.cXO = new com.baidu.tieba.frs.vc.e(this, (NoPressedRelativeLayout) this.mRootView);
                    }
                    if (this.buc == null) {
                        this.buc = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
                    }
                } else {
                    this.cXO = null;
                    this.buc = null;
                }
                if (this.cWO.aVq() != null) {
                    this.cXd = this.cWO.aVq().getName();
                    this.forumId = this.cWO.aVq().getId();
                }
                if (this.cWO.brk()) {
                    this.cXu.a(this.cWO, this.cXs.aun());
                }
                if (z) {
                    s(true, z);
                } else {
                    s(this.cXr, z);
                }
                apt();
                if (this.cXA != null) {
                    this.cXA.a(this.cXt, this.cWO);
                }
                if (this.cWO.rg() != null) {
                    setHasMore(this.cWO.rg().rc());
                }
                ArrayList<com.baidu.adp.widget.ListView.h> a2 = this.cXE.a(z2, true, this.cWO.getThreadList(), null, z);
                if (a2 != null) {
                    this.cWO.av(a2);
                }
                this.cWO.brg();
                if (this.cXs.auh() == 1) {
                    apz();
                    if (!z && this.cXs.getPn() == 1) {
                        apu();
                    }
                }
                this.cWR = this.cWO.auj();
                if (this.cXg != null) {
                    this.cXf = true;
                    this.cXg.tk(this.cWR);
                    com.baidu.tieba.frs.f.a.a(this, this.cWO.aVq(), this.cWO.getThreadList(), this.cXf, getPn());
                }
                if (this.cXC != null) {
                    this.cXC.ax(this.cXu.avs());
                }
                apq();
                this.cXk.aqg();
                this.cXk.u(true, false);
                if (this.cWO.aVq() != null) {
                    this.cXk.lL(this.cWO.aVq().getWarningMsg());
                }
                if (this.cWO != null && this.cWO.bqJ() != null && com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("frs_video_activity_guide", 0L) == 0) {
                    com.baidu.adp.lib.g.e.fw().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.10
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsFragment.this.cXk.aqB();
                        }
                    }, 1000L);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2921326, this));
                this.cXk.apZ();
                if (this.cWO != null && this.cWO.aVq() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016564, new VisitedForumData(this.cWO.aVq().getId(), this.cWO.aVq().getName(), this.cWO.aVq().getImage_url(), String.valueOf(System.currentTimeMillis() / 1000), "showlive".equals(this.cWO.aVq().special_forum_type))));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void apu() {
        if (this.cXH == null) {
            this.cXH = new com.baidu.tieba.frs.live.a(this, com.baidu.adp.lib.g.b.g(this.forumId, 0));
        }
        this.cXH.atQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.i iVar) {
        try {
            if (!this.cXo && iVar != null && this.cWO != null) {
                this.cWO.e(iVar);
                t(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void apv() {
        if (this.cXs != null) {
            lJ(this.cXs.aud());
        } else {
            lJ("normal_page");
        }
    }

    private void lJ(String str) {
        fo("frs_page".equals(str));
        if (this.cXA != null) {
            this.cXA.a(this.cXt, this.cXk, this.cWO);
        }
    }

    public void fo(boolean z) {
        if (this.cXF != null) {
            this.cXF.c(this.cXk, z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(d.i.frs_activity, viewGroup, false);
            this.cWX = new com.baidu.tieba.frs.entelechy.b();
            this.cXA = this.cWX.arr();
            this.cXt = new com.baidu.tieba.frs.vc.f(this, this.cWX, (FrsHeaderViewContainer) this.mRootView.findViewById(d.g.header_view_container));
            this.cXu = new FrsTabViewController(this, this.mRootView);
            this.cXt.a(this.cXu);
            this.cXu.a(this.cYb);
            Intent intent = getActivity().getIntent();
            if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                this.cWZ = true;
            }
            this.cXk = new i(this, this.cYp, this.cWX, this.cWZ, this.cXt);
            this.cXk.setHeaderViewHeight(this.cXL);
        } else {
            if (this.mRootView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            this.cXu.resetData();
            this.cXk.aqA();
        }
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        this.cHR = System.currentTimeMillis();
        this.beginTime = this.cHR;
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.cXh = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.cHR = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            I(intent);
        }
        this.aKN = this.beginTime - this.cHR;
        this.cXg = new com.baidu.tieba.tbadkCore.data.e("frs", com.baidu.tieba.tbadkCore.data.e.gvU);
        this.cXs = new FrsModelController(this, this.cYk);
        this.cXs.a(this.cYa);
        this.cXs.init();
        if (intent != null) {
            this.cXs.i(intent.getExtras());
        } else if (bundle != null) {
            this.cXs.i(bundle);
        } else {
            this.cXs.i(null);
        }
        if (intent != null) {
            this.cXt.l(intent.getExtras());
        } else if (bundle != null) {
            this.cXt.l(bundle);
        } else {
            this.cXt.l((Bundle) null);
        }
        this.cXj = getVoiceManager();
        this.cXI = new h(getPageContext(), this);
        initUI();
        initData(bundle);
        if (this.mFrom != null && this.mFrom.equals("from_tieba_kuang")) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.al("c12264").r("obj_type", 1).ac(ImageViewerConfig.FORUM_NAME, this.cXs.getForumName()));
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
                httpMessage.addParam("call_url", com.baidu.adp.lib.util.k.aS("shoubai://internal?type=frs&param=" + this.cXd));
                MessageManager.getInstance().sendMessage(httpMessage);
            }
        }
        if (!apG()) {
            this.cXy = new al(getActivity(), this.cXk, this.cXt);
            this.cXy.fC(true);
        }
        this.cXj = getVoiceManager();
        if (this.cXj != null) {
            this.cXj.onCreate(getPageContext());
        }
        new com.baidu.tieba.frs.mc.g();
        this.cXE = new com.baidu.tieba.frs.mc.c(this, this.cYm);
        this.cXw = new com.baidu.tieba.frs.smartsort.b(this);
        this.cXF = new com.baidu.tieba.frs.vc.h(this);
        this.cXC = new com.baidu.tieba.frs.vc.a(getPageContext(), this.cXs.auo());
        this.cXx = new com.baidu.tieba.frs.mc.b(this);
        this.cXD = new com.baidu.tieba.frs.mc.d(this);
        this.cXv = new com.baidu.tieba.frs.mc.f(this);
        this.cXG = new com.baidu.tieba.frs.mc.a(this);
        this.cXJ = new com.baidu.tieba.frs.vc.c(this);
        this.cXK = new com.baidu.tieba.frs.mc.e(this, getUniqueId());
        this.cXR = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "frs");
        this.cXS = new com.baidu.tieba.ala.a(getPageContext());
        registerListener(this.bro);
        registerListener(this.mMemListener);
        registerListener(this.cYg);
        registerListener(this.cYn);
        registerListener(this.cYf);
        registerListener(this.cYl);
        registerListener(this.cYc);
        registerListener(this.cYd);
        registerListener(this.cYe);
        registerListener(this.cXX);
        registerListener(this.cXY);
        registerListener(this.cYt);
        registerListener(this.cYi);
        registerListener(this.cXZ);
        registerListener(this.cYj);
        this.cXW.setTag(getPageContext().getUniqueId());
        registerListener(this.cXW);
        this.cXk.fv(false);
        if (!apG()) {
            showLoadingView(this.cXk.ZG(), true);
            this.cXs.t(3, true);
        }
        super.onActivityCreated(bundle);
        this.createTime = System.currentTimeMillis() - this.beginTime;
    }

    @Override // com.baidu.tieba.frs.af
    public void PQ() {
        if (isAdded() && this.bvq && !isLoadingViewAttached()) {
            showLoadingView(this.cXk.ZG(), true);
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void PR() {
        if (isAdded() && this.bvq && isLoadingViewAttached()) {
            hideLoadingView(this.cXk.ZG());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (apG()) {
            showLoadingView(this.cXk.ZG(), true);
            this.cXk.kg(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.cXs.t(3, true);
            xj().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void setHeaderViewHeight(int i) {
        this.cXL = i;
        if (this.cXk != null) {
            this.cXk.setHeaderViewHeight(this.cXL);
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.s sVar) {
        if (sVar != null) {
            this.aNJ = sVar.HN();
            this.cXM = sVar.HO();
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
            this.cXd = data.getQueryParameter("name");
            this.mFrom = data.getQueryParameter("from");
            if (!StringUtils.isNull(this.cXd)) {
                intent.putExtra("name", this.cXd);
            }
            if (!StringUtils.isNull(this.mFrom)) {
                intent.putExtra("from", this.mFrom);
            }
            TiebaStatic.log("c10105");
        }
        if (StringUtils.isNull(this.cXd)) {
            this.cXd = com.baidu.tieba.frs.f.h.K(intent);
            if (!StringUtils.isNull(this.cXd)) {
                intent.putExtra("name", this.cXd);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.cXj = getVoiceManager();
        if (this.cXj != null) {
            this.cXj.onStart(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        Intent intent;
        registerListener(2001118, this.auR);
        if (bundle != null) {
            this.cXd = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
            this.cXd = intent.getStringExtra("name");
            this.mFrom = intent.getStringExtra("from");
            this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
        }
        if (TextUtils.isEmpty(this.mFrom) || FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
        }
        if (this.mIsLogin) {
            registerListener(2001120, this.auR);
        }
        this.cXt.l(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.cYt);
        if (this.cXj != null) {
            this.cXj.onDestory(getPageContext());
        }
        this.cXj = null;
        com.baidu.tieba.card.v.afy().et(false);
        if (this.cWO != null && this.cWO.aVq() != null) {
            aa.aqH().bC(com.baidu.adp.lib.g.b.c(this.cWO.aVq().getId(), 0L));
        }
        if (this.cXH != null) {
            this.cXH.onDestory();
        }
        if (this.cXk != null) {
            com.baidu.tieba.frs.f.g.a(this.cXk, this.cWO, getForumId(), false, null);
            this.cXk.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.cXq != null) {
                this.cXq.onDestroy();
            }
            this.cXk.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.cXs.onActivityDestroy();
        this.cXt.onActivityDestroy();
        if (this.cXs != null) {
            this.cXs.Ry();
        }
        if (this.cXy != null) {
            this.cXy.HM();
        }
        if (this.cXB != null) {
            this.cXB.destory();
        }
        if (this.cXC != null) {
            this.cXC.destory();
        }
        if (this.cXw != null) {
            this.cXw.onDestroy();
        }
        if (this.cXO != null) {
            this.cXO.onDestory();
        }
        if (this.cXG != null) {
            this.cXG.onDestroy();
        }
        if (this.cXR != null) {
            this.cXR.onDestroy();
        }
        if (this.cXS != null) {
            this.cXS.onDestroy();
        }
        com.baidu.tieba.recapp.d.a.bjZ().bkb();
        com.baidu.tieba.frs.f.i.auO();
        if (this.cXu != null) {
            this.cXu.a((FrsTabViewController.a) null);
            this.cXu.avv();
        }
        if (this.cXT != null) {
            this.cXT.onDestroy();
        }
        if (this.cXU != null) {
            this.cXU.onDestroy();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.cXd);
        bundle.putString("from", this.mFrom);
        this.cXs.onSaveInstanceState(bundle);
        if (this.cXj != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            this.cXj.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.cXG != null) {
            this.cXG.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.cXk != null) {
            this.cXk.aqk();
            this.cXk.onResume();
        }
        this.cXv.fT(true);
        this.cXr = true;
        if (cXc) {
            cXc = false;
            this.cXk.startPullRefresh();
            return;
        }
        if (this.cXj != null) {
            this.cXj.onResume(getPageContext());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921338));
        this.cXk.fx(false);
        registerListener(this.cYo);
        if (this.cXP) {
            refresh(6);
            this.cXP = false;
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
                this.cXd = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.cXe = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.cXe) {
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
                httpMessage.addParam("call_url", com.baidu.adp.lib.util.k.aS("shoubai://internal?type=frs&param=" + this.cXd));
                MessageManager.getInstance().sendMessage(httpMessage);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apx() {
        this.cXk.startPullRefresh();
    }

    public void closeActivity() {
        com.baidu.tieba.frs.f.h.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.mFrom);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.cXk.setTitle(this.cXd);
        } else {
            this.cXk.setTitle("");
            this.mFlag = 1;
        }
        this.cXk.setOnAdapterItemClickListener(this.cYr);
        this.cXk.addOnScrollListener(this.mScrollListener);
        this.cXk.h(this.cVh);
        this.cXk.aqt().a(this.cYq);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cXk.onChangeSkinType(i);
        this.cXt.lm(i);
        this.cXu.onChangeSkinType(i);
        if (this.cXN != null) {
            this.cXN.onChangeSkinType();
        }
        if (this.cXT != null) {
            this.cXT.onChangeSkinType(i);
        }
    }

    public void kc(int i) {
        if (!this.mIsLogin) {
            if (this.cWO != null && this.cWO.qT() != null) {
                this.cWO.qT().setIfpost(1);
            }
            if (i == 0) {
                az.aJ(getActivity());
            }
        } else if (this.cWO != null) {
            if (i == 0) {
                com.baidu.tieba.frs.f.i.c(this, 0);
            } else {
                this.cXk.aqm();
            }
        }
    }

    public void refresh() {
        com.baidu.tieba.a.d.MH().hX("page_frs");
        refresh(3);
    }

    public void refresh(int i) {
        this.cXo = false;
        apC();
        if (this.cXk.aqc() != null) {
            this.cXk.aqc().aza();
        }
        this.cXs.t(i, true);
    }

    private void apy() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.g.h.fx().d(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.21
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.sX(FrsFragment.this.cXd);
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
            if (this.cWO != null) {
                this.cXk.showListView();
                this.cXk.fs(this.cXs.aui());
                if (!com.baidu.tieba.frs.vc.f.i(this.cWO) || !com.baidu.tieba.frs.vc.f.h(this.cWO)) {
                }
                if (this.cWO.aVq() != null) {
                    this.cXd = this.cWO.aVq().getName();
                    this.forumId = this.cWO.aVq().getId();
                }
                if (this.cWO.rg() != null) {
                    setHasMore(this.cWO.rg().rc());
                }
                this.cXk.setTitle(this.cXd);
                this.cXk.setForumName(this.cXd);
                TbadkCoreApplication.getInst().setDefaultBubble(this.cWO.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.cWO.getUserData().getBimg_end_time());
                apy();
                apA();
                ArrayList<com.baidu.adp.widget.ListView.h> threadList = this.cWO.getThreadList();
                if (threadList != null) {
                    this.cXk.a(threadList, this.cWO);
                    com.baidu.tieba.frs.f.c.v(this.cXk);
                    this.cXt.ln(getPageNum());
                    this.cXt.f(this.cWO);
                    this.cXu.a(this.cWO, this.cXs.aun());
                    this.cXk.aqn();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void apA() {
        if (this.cWO != null) {
            if (this.cWO.aVF() == 1) {
                this.cXk.aqt().setFromCDN(true);
            } else {
                this.cXk.aqt().setFromCDN(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.cXv.fT(false);
        this.cXr = false;
        this.cXk.onPause();
        if (this.cXj != null) {
            this.cXj.onPause(getPageContext());
        }
        this.cXk.fx(true);
        if (this.cXC != null) {
            this.cXC.auR();
        }
        MessageManager.getInstance().unRegisterListener(this.cYo);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.cXu != null && this.cXu.avt() != null && (this.cXu.avt().fragment instanceof BaseFragment)) {
            ((BaseFragment) this.cXu.avt().fragment).setPrimary(z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.v.afy().et(false);
        if (this.cWO != null && this.cWO.aVq() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            com.baidu.tbadk.distribute.a.Dq().a(getPageContext().getPageActivity(), "frs", this.cWO.aVq().getId(), 0L);
        }
        if (this.cXj != null) {
            this.cXj.onStop(getPageContext());
        }
        if (xj() != null) {
            xj().getRecycledViewPool().clear();
        }
        this.cXt.onActivityStop();
        com.baidu.tbadk.util.t.HQ();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && this.cXt != null) {
            this.cXt.fV(isPrimary());
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || this.cXk == null) {
            return false;
        }
        return this.cXk.aqj();
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
        if (this.cXj == null) {
            this.cXj = VoiceManager.instance();
        }
        return this.cXj;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdRecyclerView xj() {
        if (this.cXk == null) {
            return null;
        }
        return this.cXk.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void apC() {
        if (this.cXj != null) {
            this.cXj.stopPlay();
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
        if (this.cXk == null) {
            return null;
        }
        return this.cXk.Rg();
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
                if (bdUniqueId == n.cZF) {
                    if (FrsFragment.this.cXk != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.al("c11752").ac(ImageViewerConfig.FORUM_ID, FrsFragment.this.forumId).ac("obj_locate", "1"));
                        FrsFragment.this.cXk.startPullRefresh();
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
                                com.baidu.tieba.frs.f.g.a(FrsFragment.this, FrsFragment.this.cWO, bdVar);
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
            hideNetRefreshView(this.cXk.ZG());
            showLoadingView(this.cXk.ZG(), true);
            this.cXk.fv(false);
            this.cXs.t(3, true);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public com.baidu.tieba.tbadkCore.l apE() {
        return this.cWO;
    }

    public boolean apF() {
        return this.cXk.apF();
    }

    public void R(Object obj) {
        if (this.cXx != null && this.cXx.dmW != null) {
            this.cXx.dmW.f(obj);
        }
    }

    public void S(Object obj) {
        if (this.cXx != null && this.cXx.dmX != null) {
            this.cXx.dmX.f(obj);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.l.hg()) {
            this.cXk.Qq();
        } else if (this.cXs.auh() == 1) {
            PC();
            Po();
        } else if (this.cXs.hasMore()) {
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
            if (!this.cXs.aur() && TbadkCoreApplication.getInst().isRecAppExist() && this.cXs.auh() == 1) {
                this.cWO.a(this, arrayList);
            }
            ArrayList<com.baidu.adp.widget.ListView.h> a2 = this.cXE.a(false, false, arrayList, this.cXg);
            if (a2 != null) {
                this.cWO.av(a2);
                this.cXk.a(a2, this.cWO);
            }
            if (this.cXs != null) {
                com.baidu.tieba.frs.e.b.a(this.cWO, this.cXs.aun(), 2);
            }
        }
    }

    private void PC() {
        if (apo() == 1 || this.cXE.bo(this.cWO.bqh())) {
            if (com.baidu.tbadk.core.util.v.v(this.cWO.getThreadList()) > 3) {
                this.cXk.Qo();
            } else {
                this.cXk.aqw();
            }
        } else if (com.baidu.tbadk.core.util.v.w(this.cWO.getThreadList())) {
            this.cXk.Qq();
        } else {
            this.cXk.Qp();
        }
    }

    @Override // com.baidu.tieba.frs.mc.j
    public void Po() {
        if (this.cXE != null) {
            this.cXE.a(this.cXd, this.forumId, this.cWO);
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
        if (this.cXy != null) {
            this.cXy.fC(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.cXz.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a ga(int i) {
        return this.cXz.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        this.cXI.b(bVar);
    }

    public boolean apG() {
        return this.cWZ;
    }

    @Override // com.baidu.tieba.frs.af
    public void PP() {
        if (this.cXk != null) {
            showFloatingView();
            this.cXk.getListView().scrollToPosition(0);
            this.cXk.startPullRefresh();
        }
    }

    public ForumWriteData apH() {
        if (this.cWO == null || this.cWO.aVq() == null) {
            return null;
        }
        ForumData aVq = this.cWO.aVq();
        ForumWriteData forumWriteData = new ForumWriteData(aVq.getId(), aVq.getName(), aVq.getPrefixData(), this.cWO.qT());
        forumWriteData.avatar = aVq.getImage_url();
        forumWriteData.forumLevel = aVq.getUser_level();
        forumWriteData.specialForumType = aVq.special_forum_type;
        forumWriteData.firstDir = aVq.getFirst_class();
        forumWriteData.secondDir = aVq.getSecond_class();
        UserData userData = this.cWO.getUserData();
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
        this.cXk.kf(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view2) {
        super.hideLoadingView(view2);
        this.cXk.kf(0);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view2, String str, boolean z) {
        super.showNetRefreshView(view2, str, z);
        this.cXk.kf(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshViewNoClick(View view2, String str, boolean z) {
        super.showNetRefreshViewNoClick(view2, str, z);
        this.cXk.kf(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view2) {
        super.hideNetRefreshView(view2);
        this.cXk.kf(0);
    }

    public void apI() {
        FrsTabViewController.b avt;
        if (this.cXu != null && (avt = this.cXu.avt()) != null && avt.fragment != null && (avt.fragment instanceof ah)) {
            ((ah) avt.fragment).aoY();
        }
    }

    public void a(ContriInfo contriInfo) {
        if (this.cXT == null) {
            this.cXT = new com.baidu.tbadk.core.dialog.i(aeY());
        }
        this.cXT.a(contriInfo, -1L);
    }

    public void fq(boolean z) {
        this.cXb = z;
    }

    public boolean apJ() {
        return this.cXb;
    }

    public void lK(String str) {
        if (TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.util.an.isEmpty(str)) {
            if (this.cXU == null) {
                this.cXU = new AddExperiencedModel(aeY());
                this.cXU.a(this.cXV);
            }
            this.cXU.bV(this.forumId, str);
        }
    }

    public com.baidu.tieba.frs.entelechy.b apK() {
        return this.cWX;
    }
}
