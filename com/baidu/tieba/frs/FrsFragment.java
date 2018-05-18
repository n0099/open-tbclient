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
    public static boolean cYg = false;
    public static volatile long cYp = 0;
    public static volatile long cYq = 0;
    public static volatile int cYr = 0;
    private com.baidu.tbadk.util.r aNK;
    private com.baidu.adp.lib.e.b<TbImageView> aqg;
    private com.baidu.tieba.frs.gametab.b buN;
    private com.baidu.tieba.frs.smartsort.b cYA;
    private com.baidu.tieba.frs.mc.b cYB;
    private al cYC;
    private com.baidu.tieba.frs.entelechy.b.b cYE;
    private com.baidu.tbadk.h.a cYF;
    private com.baidu.tieba.frs.vc.a cYG;
    private com.baidu.tieba.frs.mc.d cYH;
    private com.baidu.tieba.frs.mc.c cYI;
    private com.baidu.tieba.frs.vc.h cYJ;
    private com.baidu.tieba.frs.mc.a cYK;
    private com.baidu.tieba.frs.live.a cYL;
    private h cYM;
    public com.baidu.tieba.frs.vc.c cYN;
    private com.baidu.tieba.frs.mc.e cYO;
    private int cYP;
    private View.OnTouchListener cYQ;
    private com.baidu.tieba.frs.view.a cYR;
    private com.baidu.tieba.frs.vc.e cYS;
    private boolean cYT;
    private com.baidu.tieba.NEGFeedBack.a cYV;
    private com.baidu.tieba.ala.a cYW;
    private com.baidu.tbadk.core.dialog.i cYX;
    private AddExperiencedModel cYY;
    private com.baidu.tieba.frs.entelechy.b cYb;
    private com.baidu.tieba.tbadkCore.data.e cYk;
    private VoiceManager cYn;
    private FrsModelController cYw;
    private com.baidu.tieba.frs.vc.f cYx;
    private FrsTabViewController cYy;
    private com.baidu.tieba.frs.mc.f cYz;
    public View mRootView;
    public boolean cYc = false;
    private boolean cYd = false;
    private boolean cYe = false;
    private boolean cYf = true;
    public String cYh = null;
    public String mFrom = null;
    public int mFlag = 0;
    private boolean cYi = false;
    private String mThreadId = null;
    public String forumId = null;
    private int cXV = 0;
    private boolean cYj = false;
    private boolean cYl = false;
    private boolean cYm = false;
    private i cYo = null;
    public final bd bkk = null;
    private com.baidu.tieba.tbadkCore.l cXS = new com.baidu.tieba.tbadkCore.l();
    public long cIX = -1;
    public long aKW = 0;
    public long aKO = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean cYs = false;
    private boolean cYt = false;
    public com.baidu.tbadk.k.d cYu = null;
    private boolean cYv = true;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> cYD = new SparseArray<>();
    private boolean bwa = true;
    private boolean cYU = false;
    private AddExperiencedModel.a cYZ = new AddExperiencedModel.a() { // from class: com.baidu.tieba.frs.FrsFragment.1
        @Override // com.baidu.tieba.share.AddExperiencedModel.a
        public void b(ContriInfo contriInfo) {
            if (contriInfo != null && contriInfo.isShowToast()) {
                FrsFragment.this.a(contriInfo);
            }
        }
    };
    private HttpMessageListener cZa = new HttpMessageListener(CmdConfigHttp.CMD_PB_FLOOR_AGREE, true) { // from class: com.baidu.tieba.frs.FrsFragment.12
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
    private final CustomMessageListener cZb = new CustomMessageListener(2016495) { // from class: com.baidu.tieba.frs.FrsFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof bd) {
                    com.baidu.tieba.frs.f.g.a(FrsFragment.this.cYo, FrsFragment.this.cXS, FrsFragment.this.getForumId(), true, (bd) data);
                }
            }
        }
    };
    private CustomMessageListener cZc = new CustomMessageListener(2921005) { // from class: com.baidu.tieba.frs.FrsFragment.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.cXS != null) {
                FrsFragment.this.cXS.bra();
                if (FrsFragment.this.cYo != null) {
                    FrsFragment.this.cYo.agD();
                }
            }
        }
    };
    private CustomMessageListener cZd = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.FrsFragment.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 1) {
                    FrsFragment.this.apw();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                }
            }
        }
    };
    private final aj cZe = new aj() { // from class: com.baidu.tieba.frs.FrsFragment.32
        @Override // com.baidu.tieba.frs.aj
        public void a(int i, int i2, ap apVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
            FrsFragment.this.app();
            if (FrsFragment.this.cYE != null) {
                FrsFragment.this.cYx.fX(FrsFragment.this.cYE.ku(i));
            }
            d.a aVar = new d.a();
            if (apVar != null) {
                aVar.isSuccess = apVar.errCode == 0;
                aVar.errorCode = apVar.errCode;
                aVar.errorMsg = apVar.errMsg;
                if (aVar.isSuccess) {
                    if (com.baidu.tbadk.core.util.v.w(arrayList)) {
                        FrsFragment.this.cYo.Qn();
                    } else if (apVar.hasMore) {
                        if (com.baidu.tbadk.core.util.v.v(FrsFragment.this.cXS.getThreadList()) > 3) {
                            FrsFragment.this.cYo.Ql();
                        } else {
                            FrsFragment.this.cYo.aqv();
                        }
                    } else if (apVar.dbB) {
                        FrsFragment.this.cYo.Qm();
                    } else {
                        FrsFragment.this.cYo.Qn();
                    }
                }
            } else {
                apVar = new ap();
                apVar.pn = 1;
                apVar.hasMore = false;
                apVar.dbB = false;
            }
            if (i == 1) {
                FrsFragment.this.cYv = true;
                FrsFragment.this.cZo.a(FrsFragment.this.cYw.getType(), false, aVar);
            } else {
                FrsFragment.this.a(aVar);
                if (FrsFragment.this.cYw.atI() != null) {
                    FrsFragment.this.cXS = FrsFragment.this.cYw.atI();
                }
                FrsFragment.this.apy();
            }
            if (FrsFragment.this.cZw != null) {
                FrsFragment.this.cZw.a(i, i2, apVar, arrayList);
            }
        }
    };
    private FrsTabViewController.a cZf = new FrsTabViewController.a() { // from class: com.baidu.tieba.frs.FrsFragment.33
        @Override // com.baidu.tieba.frs.vc.FrsTabViewController.a
        public void eT(int i) {
            if (i != 1) {
                com.baidu.tieba.card.v.afy().eu(false);
            }
            FrsFragment.this.apB();
            com.baidu.tieba.frs.e.c.dpD.dpu = i;
            com.baidu.tieba.frs.e.c.dpD.dpv = -1;
        }
    };
    private CustomMessageListener cZg = new CustomMessageListener(2001606) { // from class: com.baidu.tieba.frs.FrsFragment.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                FrsFragment.this.cYy.lt(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    };
    private CustomMessageListener cZh = new CustomMessageListener(2001607) { // from class: com.baidu.tieba.frs.FrsFragment.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && ((Integer) customResponsedMessage.getData()).intValue() == 51 && FrsFragment.this.cXS != null) {
                com.baidu.tieba.frs.f.i.a(FrsFragment.this.cXS, FrsFragment.this.getPageContext());
            }
        }
    };
    private final CustomMessageListener cZi = new CustomMessageListener(2003019) { // from class: com.baidu.tieba.frs.FrsFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                FrsFragment.this.cYy.lr(49);
            }
        }
    };
    private final CustomMessageListener cZj = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.frs.FrsFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && FrsFragment.this.cXS != null && FrsFragment.this.cXS.aVq() != null) {
                SignData signData = (SignData) customResponsedMessage.getData();
                int user_level = FrsFragment.this.cXS.aVq().getUser_level();
                if (signData.forumId != null && signData.forumId.equals(FrsFragment.this.cXS.aVq().getId())) {
                    FrsFragment.this.cXS.d(signData);
                    FrsFragment.this.cYx.g(FrsFragment.this.cXS);
                    if (FrsFragment.this.cYx.avm()) {
                        i = FrsFragment.this.cXS.aVq().getUser_level();
                        if (user_level >= i) {
                            i++;
                        }
                    } else {
                        i = user_level;
                    }
                    TbadkCoreApplication.getInst().addSignedForum(FrsFragment.this.cXS.aVq().getName(), signData.sign_bonus_point, i);
                }
            }
        }
    };
    private final CustomMessageListener cZk = new CustomMessageListener(2001352) { // from class: com.baidu.tieba.frs.FrsFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.r) && FrsFragment.this.cXS != null) {
                FrsFragment.this.cXS.c((com.baidu.tieba.tbadkCore.r) customResponsedMessage.getData());
                FrsFragment.this.cYx.f(FrsFragment.this.cXS);
                FrsFragment.this.cYy.a(FrsFragment.this.cXS, FrsFragment.this.cYw.aum());
            }
        }
    };
    private final AntiHelper.a cZl = new AntiHelper.a() { // from class: com.baidu.tieba.frs.FrsFragment.5
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.al("c12536").r("obj_locate", ar.a.aje));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.al("c12535").r("obj_locate", ar.a.aje));
        }
    };
    private CustomMessageListener brD = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.frs.FrsFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(FrsFragment.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().aup != null) {
                        if (AntiHelper.a(FrsFragment.this.getActivity(), updateAttentionMessage.getData().aup, FrsFragment.this.cZl) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.al("c12534").r("obj_locate", ar.a.aje));
                        }
                    } else if (updateAttentionMessage.getData().Ai && updateAttentionMessage.getData().isAttention) {
                        com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getPageContext().getPageActivity(), d.k.attention_success);
                    }
                }
            }
        }
    };
    private CustomMessageListener cZm = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.frs.FrsFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                FrsFragment.this.cYo.c((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener cZn = new CustomMessageListener(2001626) { // from class: com.baidu.tieba.frs.FrsFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewsRemindMessage newsRemindMessage;
            if (customResponsedMessage != null && (customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626 && (newsRemindMessage = (NewsRemindMessage) customResponsedMessage) != null) {
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (FrsFragment.this.cYo != null) {
                    FrsFragment.this.cYo.q(notificationCount, z);
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.n cZo = new com.baidu.tieba.tbadkCore.n() { // from class: com.baidu.tieba.frs.FrsFragment.9
        private long startTime = 0;

        @Override // com.baidu.tieba.tbadkCore.n
        public void kc(int i) {
            this.startTime = System.nanoTime();
            if (FrsFragment.this.cYo != null) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsFragment.this.cYo.aqj();
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
            if (FrsFragment.this.bwa) {
                FrsFragment.this.bwa = false;
                com.baidu.tieba.frs.f.g.a(FrsFragment.this.cYo, FrsFragment.this.cXS, FrsFragment.this.getForumId(), false, null);
            }
            FrsFragment.this.app();
            FrsFragment.this.cYs = true;
            if (aVar != null && aVar.isSuccess) {
                FrsFragment.this.cYo.aqs().fK(com.baidu.tbadk.core.util.ap.vP().vR());
                FrsFragment.cYp = 0L;
                FrsFragment.cYq = 0L;
                FrsFragment.cYr = 0;
            } else {
                FrsFragment.cYr = 1;
            }
            if (!FrsFragment.this.cYw.auq() && (i == 3 || i == 6)) {
                FrsFragment.this.cYI.resetData();
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (FrsFragment.this.cYw.atI() != null) {
                FrsFragment.this.cXS = FrsFragment.this.cYw.atI();
            }
            FrsFragment.this.jZ(1);
            if (i == 7) {
                FrsFragment.this.ka(FrsFragment.this.cXS.bqq());
                return;
            }
            if (FrsFragment.this.cXS.rf() != null) {
                FrsFragment.this.setHasMore(FrsFragment.this.cXS.rf().rb());
            }
            FrsFragment.this.apq();
            if (i == 4) {
                if (!FrsFragment.this.cYw.auq() && TbadkCoreApplication.getInst().isRecAppExist() && FrsFragment.this.cYw.aug() == 1) {
                    FrsFragment.this.cXS.a(FrsFragment.this);
                }
                ArrayList<com.baidu.adp.widget.ListView.h> a2 = FrsFragment.this.cYI.a(false, false, FrsFragment.this.cXS.getThreadList(), FrsFragment.this.cYk);
                if (a2 != null) {
                    FrsFragment.this.cXS.av(a2);
                    FrsFragment.this.cXS.bqS();
                    FrsFragment.this.cYo.a(a2, FrsFragment.this.cXS);
                }
                if (FrsFragment.this.cYw != null) {
                    com.baidu.tieba.frs.e.b.a(FrsFragment.this.cXS, FrsFragment.this.cYw.aum(), 2);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    FrsFragment.this.cYo.aqj();
                    break;
                case 2:
                    FrsFragment.this.cYo.aqj();
                    break;
                case 3:
                case 6:
                    if (FrsFragment.this.cXS != null) {
                        FrsFragment.this.cXS.bqQ();
                    }
                    if (FrsFragment.this.cYN != null) {
                        FrsFragment.this.cYN.refresh();
                        break;
                    }
                    break;
            }
            FrsFragment.this.apr();
            if (aVar == null || aVar.errorCode == 0) {
                if (FrsFragment.this.cXS != null) {
                    FrsFragment.this.t(false, i == 5);
                    FrsFragment.this.cYo.kg(i);
                    FrsFragment.cYp = (System.nanoTime() - this.startTime) / 1000000;
                    if (aVar != null) {
                        FrsFragment.cYq = aVar.gup;
                    }
                } else {
                    return;
                }
            } else if (FrsFragment.this.cXS == null || com.baidu.tbadk.core.util.v.w(FrsFragment.this.cXS.getThreadList())) {
                FrsFragment.this.a(aVar);
            } else if (aVar.guo) {
                FrsFragment.this.showToast(FrsFragment.this.getPageContext().getResources().getString(d.k.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
            }
            if (FrsFragment.this.cXS.bpZ() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.al("c11384"));
            }
            if (FrsFragment.this.cIX > -1 && !FrsFragment.this.cYU) {
                com.baidu.tieba.frs.f.g.a(FrsFragment.this.cYw, FrsFragment.this.cIX);
                FrsFragment.this.cIX = -1L;
                FrsFragment.this.cYU = true;
            }
            if (FrsFragment.this.cYl && FrsFragment.this.cYy.lr(49)) {
                FrsFragment.this.cYl = false;
            }
            FrsFragment.this.aKW = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void b(com.baidu.tieba.tbadkCore.i iVar) {
            if (iVar != null) {
                if ("normal_page".equals(FrsFragment.this.cYw.auc()) || "frs_page".equals(FrsFragment.this.cYw.auc()) || "book_page".equals(FrsFragment.this.cYw.auc())) {
                    FrsFragment.this.a(iVar);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001615, iVar));
                }
            }
        }
    };
    private final CustomMessageListener cZp = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.frs.FrsFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.h) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                FrsFragment.this.cXS.a((com.baidu.tbadk.data.h) customResponsedMessage.getData());
                FrsFragment.this.cYo.aqs().notifyDataSetChanged();
            }
        }
    };
    private final CustomMessageListener mMemListener = new CustomMessageListener(2001194) { // from class: com.baidu.tieba.frs.FrsFragment.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && FrsFragment.this.cXS != null && (userData = FrsFragment.this.cXS.getUserData()) != null) {
                userData.setIsMem(num.intValue());
                if (num.intValue() != 0) {
                    FrsFragment.this.cYx.g(num);
                }
            }
        }
    };
    private final com.baidu.tieba.frs.mc.i cZq = new com.baidu.tieba.frs.mc.i() { // from class: com.baidu.tieba.frs.FrsFragment.15
        @Override // com.baidu.tieba.frs.mc.i
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.h> arrayList, boolean z3) {
            if (FrsFragment.this.cYA != null && FrsFragment.this.cYw != null && FrsFragment.this.cYw.auq() && z && !z2 && !z3) {
                FrsFragment.this.cYA.kW(i2);
            }
        }
    };
    public final View.OnTouchListener aNL = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.FrsFragment.16
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            if (FrsFragment.this.cYQ != null) {
                FrsFragment.this.cYQ.onTouch(view2, motionEvent);
            }
            if (FrsFragment.this.cYC != null && FrsFragment.this.cYC.aqJ() != null) {
                FrsFragment.this.cYC.aqJ().onTouchEvent(motionEvent);
            }
            if (FrsFragment.this.buN != null) {
                FrsFragment.this.buN.d(view2, motionEvent);
            }
            if (FrsFragment.this.cYx != null) {
                FrsFragment.this.cYx.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private final CustomMessageListener cZr = new CustomMessageListener(2004507) { // from class: com.baidu.tieba.frs.FrsFragment.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "photolive_hostLevel", -1) != -1 && FrsFragment.this.cXS.aVq() != null) {
                FrsFragment.this.cXS.aVq().setCanAddPhotoLivePost(true);
            }
        }
    };
    private final CustomMessageListener cZs = new CustomMessageListener(2016493) { // from class: com.baidu.tieba.frs.FrsFragment.18
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.frs.FrsFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.al("c11455").ac("obj_locate", "frs"));
                    ax.wf().c(FrsFragment.this.getPageContext(), new String[]{str});
                }
            }
        }
    };
    public final View.OnClickListener cZt = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.22
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (FrsFragment.this.cYo == null || view2 != FrsFragment.this.cYo.aqh() || FrsFragment.this.getActivity() == null) {
                if (FrsFragment.this.cXS != null && FrsFragment.this.cXS.aVq() != null && FrsFragment.this.cYo != null && view2 == FrsFragment.this.cYo.aqn()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.al("c12402").ac(ImageViewerConfig.FORUM_ID, FrsFragment.this.cXS.aVq().getId()).ac("uid", TbadkCoreApplication.getCurrentAccount()).ac(ImageViewerConfig.FORUM_NAME, FrsFragment.this.cXS.aVq().getName()));
                    if (!StringUtils.isNull(FrsFragment.this.cXS.aVq().getName())) {
                        FrsFragment.this.sendMessage(new CustomMessage(2002001, new PostSearchActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), FrsFragment.this.cXS.aVq().getName(), FrsFragment.this.cXS.aVq().getId())));
                        return;
                    }
                    return;
                }
                if (view2.getId() == d.g.game_activity_egg_layout && com.baidu.adp.lib.util.l.hg()) {
                    TiebaStatic.log("c10853");
                    if (FrsFragment.this.cYo.aqp()) {
                        FrsFragment.this.cYo.aqq();
                    } else {
                        String activityUrl = FrsFragment.this.cXS.aVq().getYuleData().tv().getActivityUrl();
                        if (!StringUtils.isNull(activityUrl)) {
                            com.baidu.tbadk.browser.a.N(FrsFragment.this.getPageContext().getPageActivity(), activityUrl);
                        }
                    }
                }
                if (view2 == FrsFragment.this.cYo.aqw() && FrsFragment.this.cYw != null && FrsFragment.this.cYw.hasMore()) {
                    FrsFragment.this.cYo.Ql();
                    FrsFragment.this.Pl();
                }
                if (view2 != null && view2 == FrsFragment.this.cYo.aqo() && az.aK(FrsFragment.this.getContext())) {
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
        private int cZz = 0;
        private int bjP = 0;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (FrsFragment.this.cYG != null) {
                FrsFragment.this.cYG.auQ();
            }
            this.cZz = 0;
            this.bjP = 0;
            if (recyclerView != null && (recyclerView instanceof BdRecyclerView)) {
                this.cZz = ((BdRecyclerView) recyclerView).getFirstVisiblePosition();
                this.bjP = ((BdRecyclerView) recyclerView).getLastVisiblePosition();
            }
            if (FrsFragment.this.cYS != null) {
                FrsFragment.this.cYS.a(recyclerView, this.cZz, this.bjP);
            }
            if (FrsFragment.this.cXS != null && FrsFragment.this.cYo != null && FrsFragment.this.cYo.aqs() != null) {
                FrsFragment.this.cYo.ay(this.cZz, this.bjP);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (FrsFragment.this.cYx != null) {
                FrsFragment.this.cYx.setScrollState(i);
            }
            if ((i == 2 || i == 1) && !FrsFragment.this.cYt) {
                FrsFragment.this.cYt = true;
                FrsFragment.this.cYo.aqu();
            }
            if (FrsFragment.this.cYu == null && !FrsFragment.this.apF()) {
                FrsFragment.this.cYu = new com.baidu.tbadk.k.d();
                FrsFragment.this.cYu.fj(1000);
            }
            if (i == 0) {
                com.baidu.tieba.card.v.afy().eu(true);
                FrsFragment.this.cYo.ax(this.cZz, this.bjP);
            }
            if (FrsFragment.this.cYS != null) {
                FrsFragment.this.cYS.onScrollStateChanged(recyclerView, i);
            }
            if (FrsFragment.this.cYu != null) {
                FrsFragment.this.cYu.GD();
            }
            if (i == 0) {
                com.baidu.tieba.frs.f.g.a(FrsFragment.this.cYo, FrsFragment.this.cXS, FrsFragment.this.getForumId(), false, null);
            }
            if (FrsFragment.this.cYy != null && i == 1) {
                FrsFragment.this.cYy.avu();
            }
        }
    };
    private final b cZu = new b() { // from class: com.baidu.tieba.frs.FrsFragment.25
        @Override // com.baidu.tieba.frs.b
        public void a(int i, int i2, View view2, View view3, bd bdVar) {
            if (i != FrsFragment.this.cYo.aqs().arN()) {
                if (i != FrsFragment.this.cYo.aqs().arO()) {
                    if (i == FrsFragment.this.cYo.aqs().arP() && FrsFragment.this.cXS != null && FrsFragment.this.cXS.getUserData() != null && FrsFragment.this.cXS.getUserData().isBawu()) {
                        final String bqo = FrsFragment.this.cXS.bqo();
                        if (!com.baidu.tbadk.core.util.an.isEmpty(bqo) && FrsFragment.this.cXS.aVq() != null) {
                            com.baidu.tieba.c.a.a(FrsFragment.this.getPageContext(), FrsFragment.this.cXS.aVq().getId(), FrsFragment.this.cXS.aVq().getName(), new a.InterfaceC0121a() { // from class: com.baidu.tieba.frs.FrsFragment.25.1
                                @Override // com.baidu.tieba.c.a.InterfaceC0121a
                                public void aeX() {
                                    com.baidu.tbadk.browser.a.M(FrsFragment.this.getPageContext().getPageActivity(), bqo);
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.al("c10502").ac(ImageViewerConfig.FORUM_ID, FrsFragment.this.cXS.aVq().getId()).ac("uid", FrsFragment.this.cXS.getUserData().getUserId()));
                                }
                            });
                        }
                    }
                } else if (az.aK(FrsFragment.this.getPageContext().getPageActivity())) {
                    TiebaStatic.log("my_service_ck");
                    if (FrsFragment.this.cXS != null && FrsFragment.this.cXS.aVq() != null) {
                        ForumData aVq = FrsFragment.this.cXS.aVq();
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(aVq.getId(), 0L), aVq.getName(), aVq.getImage_url(), 0)));
                    }
                }
            } else if (az.aK(FrsFragment.this.getActivity())) {
                TiebaStatic.log("forum_fortune_click");
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.getPageContext(), FrsFragment.this.cXS);
            }
        }
    };
    private final NoNetworkView.a cWl = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.FrsFragment.26
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aM(boolean z) {
            if (FrsFragment.this.cYw.aug() == 1 && z && !FrsFragment.this.cYo.apE()) {
                if (FrsFragment.this.cXS == null || com.baidu.tbadk.core.util.v.w(FrsFragment.this.cXS.getThreadList())) {
                    FrsFragment.this.hideNetRefreshView(FrsFragment.this.cYo.ZJ());
                    FrsFragment.this.showLoadingView(FrsFragment.this.cYo.ZJ(), true);
                    FrsFragment.this.cYo.fw(false);
                    FrsFragment.this.refresh();
                    return;
                }
                FrsFragment.this.cYo.aqj();
            }
        }
    };
    private final CustomMessageListener auS = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.FrsFragment.27
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                com.baidu.tieba.frs.f.c.a(customResponsedMessage, FrsFragment.this.cYo, FrsFragment.this.cXS);
            }
        }
    };
    private com.baidu.adp.widget.ListView.n cZv = new a();
    private aj cZw = new aj() { // from class: com.baidu.tieba.frs.FrsFragment.28
        @Override // com.baidu.tieba.frs.aj
        public void a(int i, int i2, ap apVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
            com.baidu.adp.lib.g.e.fw().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.28.1
                @Override // java.lang.Runnable
                public void run() {
                    if (FrsFragment.this.cYo != null && FrsFragment.this.cYo.agu()) {
                        FrsFragment.this.Pl();
                    }
                }
            });
        }
    };
    private CustomMessageListener cZx = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.frs.FrsFragment.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    FrsFragment.this.cYT = true;
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.frs.loadmore.a
    public /* bridge */ /* synthetic */ com.baidu.adp.base.e getPageContext() {
        return super.getPageContext();
    }

    public com.baidu.tieba.frs.entelechy.b.b apc() {
        return this.cYE;
    }

    public com.baidu.adp.widget.ListView.n apd() {
        return this.cZv;
    }

    public com.baidu.tieba.frs.mc.d ape() {
        return this.cYH;
    }

    public com.baidu.tieba.frs.smartsort.b apf() {
        return this.cYA;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public FrsModelController apg() {
        return this.cYw;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public com.baidu.tieba.frs.mc.c aph() {
        return this.cYI;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public com.baidu.tieba.frs.vc.f apj() {
        return this.cYx;
    }

    public com.baidu.tieba.frs.vc.j apk() {
        return this.cYy;
    }

    public al apl() {
        return this.cYC;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public i apm() {
        return this.cYo;
    }

    @Override // com.baidu.tieba.frs.ak
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.ak, com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.cYh;
    }

    public void setForumName(String str) {
        this.cYh = str;
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
        if (this.cYI == null) {
            return 1;
        }
        return this.cYI.getPn();
    }

    public int getPn() {
        if (this.cYI == null) {
            return 1;
        }
        return this.cYI.getPn();
    }

    public void setPn(int i) {
        if (this.cYI != null) {
            this.cYI.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.cYI != null) {
            this.cYI.setHasMore(i);
        }
    }

    public int apn() {
        if (this.cYI == null) {
            return -1;
        }
        return this.cYI.apn();
    }

    public boolean apo() {
        return this.cYm;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d.a aVar) {
        if (aVar == null) {
            String string = TbadkCoreApplication.getInst().getString(d.k.error_unkown_try_again);
            this.cYo.aqe();
            showNetRefreshView(this.cYo.ZJ(), string, true);
        } else if (340001 == aVar.errorCode) {
            a(aVar, this.cXS.bpW());
        } else {
            if (com.baidu.tbadk.core.util.v.w(this.cXS.getThreadList())) {
                b(aVar);
            }
            if (apF()) {
                setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst(), d.e.ds280));
            } else {
                setNetRefreshViewEmotionDefMarginTop();
            }
        }
    }

    public void a(View view2, String str, boolean z, List<RecmForumInfo> list) {
        this.cYo.aqe();
        this.cYo.ke(8);
        if (this.cYR == null) {
            this.cYR = new com.baidu.tieba.frs.view.a(getPageContext(), getNetRefreshListener());
        }
        this.cYR.setSubText(str);
        this.cYR.bv(list);
        this.cYR.d(view2, z);
    }

    private void a(d.a aVar, List<RecmForumInfo> list) {
        if (this.cYo != null) {
            this.cYo.aqe();
            this.cYo.setTitle(this.cYh);
            a(this.cYo.ZJ(), aVar.errorMsg, true, list);
        }
    }

    private void b(d.a aVar) {
        this.cYo.aqe();
        if (aVar.guo) {
            showNetRefreshView(this.cYo.ZJ(), TbadkCoreApplication.getInst().getString(d.k.net_error_text, new Object[]{aVar.errorMsg, Integer.valueOf(aVar.errorCode)}), true);
        } else {
            showNetRefreshView(this.cYo.ZJ(), aVar.errorMsg, true);
        }
    }

    public void app() {
        hideLoadingView(this.cYo.ZJ());
        if (!this.cYo.apE()) {
            this.cYo.fx(false);
        } else {
            this.cYo.fx(true);
        }
        if (this.cYo.aqc() instanceof com.baidu.tieba.frs.tab.c) {
            ((com.baidu.tieba.frs.tab.c) this.cYo.aqc()).auK();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apq() {
        if (apn() == 0 && com.baidu.tbadk.core.util.v.w(this.cXS.bqf())) {
            if (com.baidu.tbadk.core.util.v.w(this.cXS.getThreadList())) {
                this.cYo.Qn();
            } else {
                this.cYo.Qm();
            }
        } else if (com.baidu.tbadk.core.util.v.v(this.cXS.getThreadList()) > 3) {
            this.cYo.Ql();
        } else {
            this.cYo.aqv();
        }
    }

    public void a(ErrorData errorData) {
        app();
        this.cYo.aqj();
        d.a aud = this.cYw.aud();
        boolean w = com.baidu.tbadk.core.util.v.w(this.cXS.getThreadList());
        if (aud != null && w) {
            if (this.cYw.aue() != 0) {
                this.cYw.auk();
                this.cYo.aqj();
            } else {
                a(aud);
            }
            this.cYo.u(this.cXS.brh(), false);
            return;
        }
        a(aud);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jZ(int i) {
        List<WindowToast> list;
        if (TbadkCoreApplication.isLogin() && this.cXS != null && (list = this.cXS.gvQ) != null && list.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < list.size()) {
                    WindowToast windowToast = list.get(i3);
                    if (windowToast == null || windowToast.toast_type.intValue() != i) {
                        i2 = i3 + 1;
                    } else if (!com.baidu.tbadk.core.util.an.isEmpty(windowToast.toast_link)) {
                        sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(getPageContext().getPageActivity(), "", com.baidu.tbadk.util.z.hp(windowToast.toast_link), true)));
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
    public void apr() {
        if (this.cXS == null || this.cXS.aVq() != null) {
            this.cYo.aqr();
        } else if (this.cXS.aVq().getYuleData() != null && this.cXS.aVq().getYuleData().tu()) {
            TiebaStatic.log("c10852");
            this.cYo.a(this.cXS.aVq().getYuleData().tv());
        } else {
            this.cYo.aqr();
        }
    }

    private void s(boolean z, boolean z2) {
        if (this.cYw != null && this.cXS != null && this.cYo != null && z) {
            if (!this.cYw.auq() && this.cYw.aug() == 1) {
                if (!this.cYw.auo()) {
                    this.cXS.bqX();
                    this.cXS.bqY();
                }
                boolean z3 = false;
                if (this.cYo.aqs().k(com.baidu.tieba.card.data.n.cts)) {
                    z3 = this.cXS.brb();
                }
                if (!z3) {
                    this.cXS.bqZ();
                }
                if (TbadkCoreApplication.getInst().isRecAppExist()) {
                    this.cXS.a(this);
                }
                if (!this.cYo.aqs().k(bd.ZL)) {
                    this.cXS.bqR();
                }
                this.cXS.brc();
            }
            if (!this.cYo.aqs().k(bd.ZL)) {
                this.cXS.bqW();
                this.cXS.bqU();
            } else {
                this.cXS.bqV();
                this.cXS.bqT();
            }
            this.cXS.bqS();
            this.cXS.bqP();
            if (this.cYo.aqs().k(com.baidu.tieba.h.b.dwa)) {
                this.cXS.mn(z2);
            }
            if (TbadkCoreApplication.isLogin() && (!this.cYw.auq() || this.cYw.isNetFirstLoad)) {
                this.cXS.brd();
            }
            this.cXS.brf();
        }
    }

    public boolean aps() {
        if (this.cYx != null && this.cYw != null) {
            this.cYx.a(this.cYw.auc(), this.cXS);
        }
        boolean z = false;
        if (this.cXS != null) {
            z = this.cXS.bri();
        }
        apu();
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ka(int i) {
        am amVar = null;
        aps();
        apB();
        try {
            if (this.cXS != null) {
                this.cYo.a((ArrayList<com.baidu.adp.widget.ListView.h>) null, this.cXS);
                this.cYx.lm(1);
                this.cYo.aqm();
                this.cYy.a(this.cXS, this.cYw.aum());
                com.baidu.tieba.frs.tab.d ls = this.cYy.ls(this.cXS.bqq());
                if (ls != null && !TextUtils.isEmpty(ls.url)) {
                    amVar = new am();
                    amVar.dby = ls.url;
                    amVar.stType = ls.name;
                }
                this.cYw.a(this.cXS.bqq(), 0, amVar);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(boolean z, boolean z2) {
        try {
            if (this.cXS != null && this.cYy != null && this.cYw != null) {
                if (!this.cYo.aqs().k(bd.ZL)) {
                    this.cXS.bqR();
                }
                boolean w = com.baidu.tbadk.core.util.v.w(this.cXS.bqE());
                this.cYo.fu(w);
                if (!w) {
                    if (this.cYS == null) {
                        this.cYS = new com.baidu.tieba.frs.vc.e(this, (NoPressedRelativeLayout) this.mRootView);
                    }
                    if (this.buN == null) {
                        this.buN = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
                    }
                } else {
                    this.cYS = null;
                    this.buN = null;
                }
                if (this.cXS.aVq() != null) {
                    this.cYh = this.cXS.aVq().getName();
                    this.forumId = this.cXS.aVq().getId();
                }
                if (this.cXS.bri()) {
                    this.cYy.a(this.cXS, this.cYw.aum());
                }
                if (z) {
                    s(true, z);
                } else {
                    s(this.cYv, z);
                }
                aps();
                if (this.cYE != null) {
                    this.cYE.a(this.cYx, this.cXS);
                }
                if (this.cXS.rf() != null) {
                    setHasMore(this.cXS.rf().rb());
                }
                ArrayList<com.baidu.adp.widget.ListView.h> a2 = this.cYI.a(z2, true, this.cXS.getThreadList(), null, z);
                if (a2 != null) {
                    this.cXS.av(a2);
                }
                this.cXS.bre();
                if (this.cYw.aug() == 1) {
                    apy();
                    if (!z && this.cYw.getPn() == 1) {
                        apt();
                    }
                }
                this.cXV = this.cXS.aui();
                if (this.cYk != null) {
                    this.cYj = true;
                    this.cYk.tj(this.cXV);
                    com.baidu.tieba.frs.f.a.a(this, this.cXS.aVq(), this.cXS.getThreadList(), this.cYj, getPn());
                }
                if (this.cYG != null) {
                    this.cYG.ax(this.cYy.avr());
                }
                app();
                this.cYo.aqf();
                this.cYo.u(true, false);
                if (this.cXS.aVq() != null) {
                    this.cYo.lO(this.cXS.aVq().getWarningMsg());
                }
                if (this.cXS != null && this.cXS.bqH() != null && com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("frs_video_activity_guide", 0L) == 0) {
                    com.baidu.adp.lib.g.e.fw().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.10
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsFragment.this.cYo.aqA();
                        }
                    }, 1000L);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2921326, this));
                this.cYo.apY();
                if (this.cXS != null && this.cXS.aVq() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016564, new VisitedForumData(this.cXS.aVq().getId(), this.cXS.aVq().getName(), this.cXS.aVq().getImage_url(), String.valueOf(System.currentTimeMillis() / 1000), "showlive".equals(this.cXS.aVq().special_forum_type))));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void apt() {
        if (this.cYL == null) {
            this.cYL = new com.baidu.tieba.frs.live.a(this, com.baidu.adp.lib.g.b.g(this.forumId, 0));
        }
        this.cYL.atP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.i iVar) {
        try {
            if (!this.cYs && iVar != null && this.cXS != null) {
                this.cXS.e(iVar);
                t(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void apu() {
        if (this.cYw != null) {
            lM(this.cYw.auc());
        } else {
            lM("normal_page");
        }
    }

    private void lM(String str) {
        fp("frs_page".equals(str));
        if (this.cYE != null) {
            this.cYE.a(this.cYx, this.cYo, this.cXS);
        }
    }

    public void fp(boolean z) {
        if (this.cYJ != null) {
            this.cYJ.c(this.cYo, z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(d.i.frs_activity, viewGroup, false);
            this.cYb = new com.baidu.tieba.frs.entelechy.b();
            this.cYE = this.cYb.arq();
            this.cYx = new com.baidu.tieba.frs.vc.f(this, this.cYb, (FrsHeaderViewContainer) this.mRootView.findViewById(d.g.header_view_container));
            this.cYy = new FrsTabViewController(this, this.mRootView);
            this.cYx.a(this.cYy);
            this.cYy.a(this.cZf);
            Intent intent = getActivity().getIntent();
            if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                this.cYd = true;
            }
            this.cYo = new i(this, this.cZt, this.cYb, this.cYd, this.cYx);
            this.cYo.setHeaderViewHeight(this.cYP);
        } else {
            if (this.mRootView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            this.cYy.resetData();
            this.cYo.aqz();
        }
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        this.cIX = System.currentTimeMillis();
        this.beginTime = this.cIX;
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.cYl = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.cIX = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            I(intent);
        }
        this.aKO = this.beginTime - this.cIX;
        this.cYk = new com.baidu.tieba.tbadkCore.data.e("frs", com.baidu.tieba.tbadkCore.data.e.gwV);
        this.cYw = new FrsModelController(this, this.cZo);
        this.cYw.a(this.cZe);
        this.cYw.init();
        if (intent != null) {
            this.cYw.i(intent.getExtras());
        } else if (bundle != null) {
            this.cYw.i(bundle);
        } else {
            this.cYw.i(null);
        }
        if (intent != null) {
            this.cYx.l(intent.getExtras());
        } else if (bundle != null) {
            this.cYx.l(bundle);
        } else {
            this.cYx.l((Bundle) null);
        }
        this.cYn = getVoiceManager();
        this.cYM = new h(getPageContext(), this);
        initUI();
        initData(bundle);
        if (this.mFrom != null && this.mFrom.equals("from_tieba_kuang")) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.al("c12264").r("obj_type", 1).ac(ImageViewerConfig.FORUM_NAME, this.cYw.getForumName()));
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
                httpMessage.addParam("call_url", com.baidu.adp.lib.util.k.aS("shoubai://internal?type=frs&param=" + this.cYh));
                MessageManager.getInstance().sendMessage(httpMessage);
            }
        }
        if (!apF()) {
            this.cYC = new al(getActivity(), this.cYo, this.cYx);
            this.cYC.fD(true);
        }
        this.cYn = getVoiceManager();
        if (this.cYn != null) {
            this.cYn.onCreate(getPageContext());
        }
        new com.baidu.tieba.frs.mc.g();
        this.cYI = new com.baidu.tieba.frs.mc.c(this, this.cZq);
        this.cYA = new com.baidu.tieba.frs.smartsort.b(this);
        this.cYJ = new com.baidu.tieba.frs.vc.h(this);
        this.cYG = new com.baidu.tieba.frs.vc.a(getPageContext(), this.cYw.aun());
        this.cYB = new com.baidu.tieba.frs.mc.b(this);
        this.cYH = new com.baidu.tieba.frs.mc.d(this);
        this.cYz = new com.baidu.tieba.frs.mc.f(this);
        this.cYK = new com.baidu.tieba.frs.mc.a(this);
        this.cYN = new com.baidu.tieba.frs.vc.c(this);
        this.cYO = new com.baidu.tieba.frs.mc.e(this, getUniqueId());
        this.cYV = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "frs");
        this.cYW = new com.baidu.tieba.ala.a(getPageContext());
        registerListener(this.brD);
        registerListener(this.mMemListener);
        registerListener(this.cZk);
        registerListener(this.cZr);
        registerListener(this.cZj);
        registerListener(this.cZp);
        registerListener(this.cZg);
        registerListener(this.cZh);
        registerListener(this.cZi);
        registerListener(this.cZb);
        registerListener(this.cZc);
        registerListener(this.cZx);
        registerListener(this.cZm);
        registerListener(this.cZd);
        registerListener(this.cZn);
        this.cZa.setTag(getPageContext().getUniqueId());
        registerListener(this.cZa);
        this.cYo.fw(false);
        if (!apF()) {
            showLoadingView(this.cYo.ZJ(), true);
            this.cYw.t(3, true);
        }
        super.onActivityCreated(bundle);
        this.createTime = System.currentTimeMillis() - this.beginTime;
    }

    @Override // com.baidu.tieba.frs.af
    public void PN() {
        if (isAdded() && this.bwa && !isLoadingViewAttached()) {
            showLoadingView(this.cYo.ZJ(), true);
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void PO() {
        if (isAdded() && this.bwa && isLoadingViewAttached()) {
            hideLoadingView(this.cYo.ZJ());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (apF()) {
            showLoadingView(this.cYo.ZJ(), true);
            this.cYo.kf(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.cYw.t(3, true);
            xi().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void setHeaderViewHeight(int i) {
        this.cYP = i;
        if (this.cYo != null) {
            this.cYo.setHeaderViewHeight(this.cYP);
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.s sVar) {
        if (sVar != null) {
            this.aNK = sVar.HL();
            this.cYQ = sVar.HM();
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void showFloatingView() {
        if (this.aNK != null) {
            this.aNK.bY(true);
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
            this.cYh = data.getQueryParameter("name");
            this.mFrom = data.getQueryParameter("from");
            if (!StringUtils.isNull(this.cYh)) {
                intent.putExtra("name", this.cYh);
            }
            if (!StringUtils.isNull(this.mFrom)) {
                intent.putExtra("from", this.mFrom);
            }
            TiebaStatic.log("c10105");
        }
        if (StringUtils.isNull(this.cYh)) {
            this.cYh = com.baidu.tieba.frs.f.h.K(intent);
            if (!StringUtils.isNull(this.cYh)) {
                intent.putExtra("name", this.cYh);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.cYn = getVoiceManager();
        if (this.cYn != null) {
            this.cYn.onStart(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        Intent intent;
        registerListener(2001118, this.auS);
        if (bundle != null) {
            this.cYh = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
            this.cYh = intent.getStringExtra("name");
            this.mFrom = intent.getStringExtra("from");
            this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
        }
        if (TextUtils.isEmpty(this.mFrom) || FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
        }
        if (this.mIsLogin) {
            registerListener(2001120, this.auS);
        }
        this.cYx.l(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.cZx);
        if (this.cYn != null) {
            this.cYn.onDestory(getPageContext());
        }
        this.cYn = null;
        com.baidu.tieba.card.v.afy().eu(false);
        if (this.cXS != null && this.cXS.aVq() != null) {
            aa.aqG().bC(com.baidu.adp.lib.g.b.c(this.cXS.aVq().getId(), 0L));
        }
        if (this.cYL != null) {
            this.cYL.onDestory();
        }
        if (this.cYo != null) {
            com.baidu.tieba.frs.f.g.a(this.cYo, this.cXS, getForumId(), false, null);
            this.cYo.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.cYu != null) {
                this.cYu.onDestroy();
            }
            this.cYo.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.cYw.onActivityDestroy();
        this.cYx.onActivityDestroy();
        if (this.cYw != null) {
            this.cYw.Rv();
        }
        if (this.cYC != null) {
            this.cYC.HK();
        }
        if (this.cYF != null) {
            this.cYF.destory();
        }
        if (this.cYG != null) {
            this.cYG.destory();
        }
        if (this.cYA != null) {
            this.cYA.onDestroy();
        }
        if (this.cYS != null) {
            this.cYS.onDestory();
        }
        if (this.cYK != null) {
            this.cYK.onDestroy();
        }
        if (this.cYV != null) {
            this.cYV.onDestroy();
        }
        if (this.cYW != null) {
            this.cYW.onDestroy();
        }
        com.baidu.tieba.recapp.d.a.bjY().bka();
        com.baidu.tieba.frs.f.i.auN();
        if (this.cYy != null) {
            this.cYy.a((FrsTabViewController.a) null);
            this.cYy.avu();
        }
        if (this.cYX != null) {
            this.cYX.onDestroy();
        }
        if (this.cYY != null) {
            this.cYY.onDestroy();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.cYh);
        bundle.putString("from", this.mFrom);
        this.cYw.onSaveInstanceState(bundle);
        if (this.cYn != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            this.cYn.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.cYK != null) {
            this.cYK.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.cYo != null) {
            this.cYo.aqj();
            this.cYo.onResume();
        }
        this.cYz.fU(true);
        this.cYv = true;
        if (cYg) {
            cYg = false;
            this.cYo.startPullRefresh();
            return;
        }
        if (this.cYn != null) {
            this.cYn.onResume(getPageContext());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921338));
        this.cYo.fy(false);
        registerListener(this.cZs);
        if (this.cYT) {
            refresh(6);
            this.cYT = false;
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

    public boolean apv() {
        Intent intent;
        if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
            return false;
        }
        return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
    }

    public void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.cYh = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.cYi = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.cYi) {
                apw();
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
                httpMessage.addParam("call_url", com.baidu.adp.lib.util.k.aS("shoubai://internal?type=frs&param=" + this.cYh));
                MessageManager.getInstance().sendMessage(httpMessage);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apw() {
        this.cYo.startPullRefresh();
    }

    public void closeActivity() {
        com.baidu.tieba.frs.f.h.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.mFrom);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.cYo.setTitle(this.cYh);
        } else {
            this.cYo.setTitle("");
            this.mFlag = 1;
        }
        this.cYo.setOnAdapterItemClickListener(this.cZv);
        this.cYo.addOnScrollListener(this.mScrollListener);
        this.cYo.h(this.cWl);
        this.cYo.aqs().a(this.cZu);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cYo.onChangeSkinType(i);
        this.cYx.ll(i);
        this.cYy.onChangeSkinType(i);
        if (this.cYR != null) {
            this.cYR.onChangeSkinType();
        }
        if (this.cYX != null) {
            this.cYX.onChangeSkinType(i);
        }
    }

    public void kb(int i) {
        if (!this.mIsLogin) {
            if (this.cXS != null && this.cXS.qS() != null) {
                this.cXS.qS().setIfpost(1);
            }
            if (i == 0) {
                az.aJ(getActivity());
            }
        } else if (this.cXS != null) {
            if (i == 0) {
                com.baidu.tieba.frs.f.i.c(this, 0);
            } else {
                this.cYo.aql();
            }
        }
    }

    public void refresh() {
        com.baidu.tieba.a.d.MF().hY("page_frs");
        refresh(3);
    }

    public void refresh(int i) {
        this.cYs = false;
        apB();
        if (this.cYo.aqb() != null) {
            this.cYo.aqb().ayY();
        }
        this.cYw.t(i, true);
    }

    private void apx() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.g.h.fx().d(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.21
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.ta(FrsFragment.this.cYh);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apy() {
        apB();
        try {
            if (this.cXS != null) {
                this.cYo.showListView();
                this.cYo.ft(this.cYw.auh());
                if (!com.baidu.tieba.frs.vc.f.i(this.cXS) || !com.baidu.tieba.frs.vc.f.h(this.cXS)) {
                }
                if (this.cXS.aVq() != null) {
                    this.cYh = this.cXS.aVq().getName();
                    this.forumId = this.cXS.aVq().getId();
                }
                if (this.cXS.rf() != null) {
                    setHasMore(this.cXS.rf().rb());
                }
                this.cYo.setTitle(this.cYh);
                this.cYo.setForumName(this.cYh);
                TbadkCoreApplication.getInst().setDefaultBubble(this.cXS.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.cXS.getUserData().getBimg_end_time());
                apx();
                apz();
                ArrayList<com.baidu.adp.widget.ListView.h> threadList = this.cXS.getThreadList();
                if (threadList != null) {
                    this.cYo.a(threadList, this.cXS);
                    com.baidu.tieba.frs.f.c.v(this.cYo);
                    this.cYx.lm(getPageNum());
                    this.cYx.f(this.cXS);
                    this.cYy.a(this.cXS, this.cYw.aum());
                    this.cYo.aqm();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void apz() {
        if (this.cXS != null) {
            if (this.cXS.aVF() == 1) {
                this.cYo.aqs().setFromCDN(true);
            } else {
                this.cYo.aqs().setFromCDN(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.cYz.fU(false);
        this.cYv = false;
        this.cYo.onPause();
        if (this.cYn != null) {
            this.cYn.onPause(getPageContext());
        }
        this.cYo.fy(true);
        if (this.cYG != null) {
            this.cYG.auQ();
        }
        MessageManager.getInstance().unRegisterListener(this.cZs);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.cYy != null && this.cYy.avs() != null && (this.cYy.avs().fragment instanceof BaseFragment)) {
            ((BaseFragment) this.cYy.avs().fragment).setPrimary(z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.v.afy().eu(false);
        if (this.cXS != null && this.cXS.aVq() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            com.baidu.tbadk.distribute.a.Do().a(getPageContext().getPageActivity(), "frs", this.cXS.aVq().getId(), 0L);
        }
        if (this.cYn != null) {
            this.cYn.onStop(getPageContext());
        }
        if (xi() != null) {
            xi().getRecycledViewPool().clear();
        }
        this.cYx.onActivityStop();
        com.baidu.tbadk.util.t.HO();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && this.cYx != null) {
            this.cYx.fW(isPrimary());
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || this.cYo == null) {
            return false;
        }
        return this.cYo.aqi();
    }

    @Override // com.baidu.tieba.recapp.n
    public TbPageContext<?> aeY() {
        return getPageContext();
    }

    @Override // com.baidu.tieba.recapp.n
    public void a(AdvertAppInfo advertAppInfo, String str) {
        com.baidu.tbadk.distribute.a.Do().a(advertAppInfo, this.forumId, 0L, "FRS", str, getPn());
    }

    @Override // com.baidu.tieba.recapp.n
    public void apA() {
        apg().apA();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.cYn == null) {
            this.cYn = VoiceManager.instance();
        }
        return this.cYn;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdRecyclerView xi() {
        if (this.cYo == null) {
            return null;
        }
        return this.cYo.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void apB() {
        if (this.cYn != null) {
            this.cYn.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> xj() {
        if (this.aqg == null) {
            this.aqg = UserIconBox.h(getPageContext().getPageActivity(), 8);
        }
        return this.aqg;
    }

    public void apC() {
        if (getFragmentActivity() != null && getFragmentActivity().getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.b(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.k onGetPreLoadListView() {
        return xi().getPreLoadHandle();
    }

    @Override // com.baidu.tieba.frs.ai
    public NavigationBar Rd() {
        if (this.cYo == null) {
            return null;
        }
        return this.cYo.Rd();
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
                if (bdUniqueId == n.daL) {
                    if (FrsFragment.this.cYo != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.al("c11752").ac(ImageViewerConfig.FORUM_ID, FrsFragment.this.forumId).ac("obj_locate", "1"));
                        FrsFragment.this.cYo.startPullRefresh();
                    }
                } else if (hVar != null && (hVar instanceof bd)) {
                    bd bdVar = (bd) hVar;
                    if (bdVar.sy() == null || bdVar.sy().getGroup_id() == 0 || az.aK(FrsFragment.this.getActivity())) {
                        if (bdVar.sr() != 1 || az.aK(FrsFragment.this.getActivity())) {
                            if (bdVar.sc() != null) {
                                if (az.aK(FrsFragment.this.getActivity())) {
                                    String postUrl = bdVar.sc().getPostUrl();
                                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.hg()) {
                                        com.baidu.tbadk.browser.a.N(FrsFragment.this.getActivity(), postUrl);
                                    }
                                }
                            } else if (bdVar.sH() != null) {
                                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                    az.aJ(FrsFragment.this.getPageContext().getPageActivity());
                                    return;
                                }
                                com.baidu.tbadk.core.data.n sH = bdVar.sH();
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), sH.getCartoonId(), sH.getChapterId(), 2)));
                            } else {
                                com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                                if (readThreadHistory != null && !readThreadHistory.tg(bdVar.getId())) {
                                    readThreadHistory.tf(bdVar.getId());
                                }
                                boolean z = false;
                                final String rW = bdVar.rW();
                                if (rW != null && !rW.equals("")) {
                                    z = true;
                                    new Thread(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.a.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(rW);
                                            xVar.vi().wh().mIsNeedAddCommenParam = false;
                                            xVar.vi().wh().mIsUseCurrentBDUSS = false;
                                            xVar.uL();
                                        }
                                    }).start();
                                }
                                String tid = bdVar.getTid();
                                if (tid == null) {
                                    tid = "";
                                }
                                if (bdVar.rK() == 2 && !tid.startsWith("pb:")) {
                                    ax.wf().c(FrsFragment.this.getPageContext(), new String[]{tid, "", null});
                                    return;
                                }
                                if (tid.startsWith("pb:")) {
                                    bdVar.setId(tid.substring(3));
                                }
                                if (bdUniqueId.getId() == bd.aaW.getId()) {
                                    com.baidu.tieba.frs.f.g.a(bdVar.rz());
                                } else if (bdUniqueId.getId() == bd.ZO.getId()) {
                                    com.baidu.tbadk.core.util.al alVar = new com.baidu.tbadk.core.util.al("c12940");
                                    alVar.ac("obj_type", "2");
                                    alVar.ac("tid", bdVar.getTid());
                                    TiebaStatic.log(alVar);
                                }
                                com.baidu.tieba.frs.f.h.a(FrsFragment.this, bdVar, i, z);
                                com.baidu.tieba.frs.f.g.a(FrsFragment.this, FrsFragment.this.cXS, bdVar);
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
            hideNetRefreshView(this.cYo.ZJ());
            showLoadingView(this.cYo.ZJ(), true);
            this.cYo.fw(false);
            this.cYw.t(3, true);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public com.baidu.tieba.tbadkCore.l apD() {
        return this.cXS;
    }

    public boolean apE() {
        return this.cYo.apE();
    }

    public void R(Object obj) {
        if (this.cYB != null && this.cYB.dob != null) {
            this.cYB.dob.f(obj);
        }
    }

    public void S(Object obj) {
        if (this.cYB != null && this.cYB.dod != null) {
            this.cYB.dod.f(obj);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.l.hg()) {
            this.cYo.Qn();
        } else if (this.cYw.aug() == 1) {
            Pz();
            Pl();
        } else if (this.cYw.hasMore()) {
            Pl();
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void lA(String str) {
        Pz();
        showToast(str);
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void J(ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        Pz();
        if (!com.baidu.tbadk.core.util.v.w(arrayList)) {
            if (!this.cYw.auq() && TbadkCoreApplication.getInst().isRecAppExist() && this.cYw.aug() == 1) {
                this.cXS.a(this, arrayList);
            }
            ArrayList<com.baidu.adp.widget.ListView.h> a2 = this.cYI.a(false, false, arrayList, this.cYk);
            if (a2 != null) {
                this.cXS.av(a2);
                this.cYo.a(a2, this.cXS);
            }
            if (this.cYw != null) {
                com.baidu.tieba.frs.e.b.a(this.cXS, this.cYw.aum(), 2);
            }
        }
    }

    private void Pz() {
        if (apn() == 1 || this.cYI.br(this.cXS.bqf())) {
            if (com.baidu.tbadk.core.util.v.v(this.cXS.getThreadList()) > 3) {
                this.cYo.Ql();
            } else {
                this.cYo.aqv();
            }
        } else if (com.baidu.tbadk.core.util.v.w(this.cXS.getThreadList())) {
            this.cYo.Qn();
        } else {
            this.cYo.Qm();
        }
    }

    @Override // com.baidu.tieba.frs.mc.j
    public void Pl() {
        if (this.cYI != null) {
            this.cYI.a(this.cYh, this.forumId, this.cXS);
        }
    }

    public void takePhoto() {
        if (!com.baidu.tbadk.core.util.ab.e(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.aj.b(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return apF() ? "a034" : "a006";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (!apF()) {
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

    public void fq(boolean z) {
        if (this.cYC != null) {
            this.cYC.fD(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.cYD.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a gb(int i) {
        return this.cYD.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        this.cYM.b(bVar);
    }

    public boolean apF() {
        return this.cYd;
    }

    @Override // com.baidu.tieba.frs.af
    public void PM() {
        if (this.cYo != null) {
            showFloatingView();
            this.cYo.getListView().scrollToPosition(0);
            this.cYo.startPullRefresh();
        }
    }

    public ForumWriteData apG() {
        if (this.cXS == null || this.cXS.aVq() == null) {
            return null;
        }
        ForumData aVq = this.cXS.aVq();
        ForumWriteData forumWriteData = new ForumWriteData(aVq.getId(), aVq.getName(), aVq.getPrefixData(), this.cXS.qS());
        forumWriteData.avatar = aVq.getImage_url();
        forumWriteData.forumLevel = aVq.getUser_level();
        forumWriteData.specialForumType = aVq.special_forum_type;
        forumWriteData.firstDir = aVq.getFirst_class();
        forumWriteData.secondDir = aVq.getSecond_class();
        UserData userData = this.cXS.getUserData();
        forumWriteData.privateThread = userData != null ? userData.getPrivateThread() : 0;
        return forumWriteData;
    }

    @Override // com.baidu.tieba.frs.af
    public void wX() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.frs.af
    public void setVideoThreadId(String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view2, boolean z) {
        super.showLoadingView(view2, z);
        this.cYo.ke(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view2) {
        super.hideLoadingView(view2);
        this.cYo.ke(0);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view2, String str, boolean z) {
        super.showNetRefreshView(view2, str, z);
        this.cYo.ke(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshViewNoClick(View view2, String str, boolean z) {
        super.showNetRefreshViewNoClick(view2, str, z);
        this.cYo.ke(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view2) {
        super.hideNetRefreshView(view2);
        this.cYo.ke(0);
    }

    public void apH() {
        FrsTabViewController.b avs;
        if (this.cYy != null && (avs = this.cYy.avs()) != null && avs.fragment != null && (avs.fragment instanceof ah)) {
            ((ah) avs.fragment).aoX();
        }
    }

    public void a(ContriInfo contriInfo) {
        if (this.cYX == null) {
            this.cYX = new com.baidu.tbadk.core.dialog.i(aeY());
        }
        this.cYX.a(contriInfo, -1L);
    }

    public void fr(boolean z) {
        this.cYf = z;
    }

    public boolean apI() {
        return this.cYf;
    }

    public void lN(String str) {
        if (TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.util.an.isEmpty(str)) {
            if (this.cYY == null) {
                this.cYY = new AddExperiencedModel(aeY());
                this.cYY.a(this.cYZ);
            }
            this.cYY.bV(this.forumId, str);
        }
    }

    public com.baidu.tieba.frs.entelechy.b apJ() {
        return this.cYb;
    }
}
