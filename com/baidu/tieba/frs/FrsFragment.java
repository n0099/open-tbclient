package com.baidu.tieba.frs;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
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
import com.baidu.adp.widget.ListView.s;
import com.baidu.card.a.a;
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
import com.baidu.tbadk.core.data.PrivateForumPopInfoData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.coreExtra.messageCenter.NewsRemindMessage;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tbadk.widget.FRSRefreshButton;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.d;
import com.baidu.tieba.card.t;
import com.baidu.tieba.d;
import com.baidu.tieba.deletethread.DeleteThreadHttpResponseMessage;
import com.baidu.tieba.frs.a;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.frs.mc.FrsNewAreaFragment;
import com.baidu.tieba.frs.vc.FrsTabViewController;
import com.baidu.tieba.frs.view.FrsHeaderViewContainer;
import com.baidu.tieba.pb.data.ContriInfo;
import com.baidu.tieba.pb.data.PbFloorAgreeResponseMessage;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.e;
import com.baidu.tieba.tbadkCore.r;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsPage.RecmForumInfo;
import tbclient.WindowToast;
/* loaded from: classes4.dex */
public class FrsFragment extends BaseFragment implements BdListView.e, a.InterfaceC0040a, UserIconBox.b<BdRecyclerView>, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, ae, ah, aj, com.baidu.tieba.frs.loadmore.a, com.baidu.tieba.frs.mc.l, com.baidu.tieba.recapp.n {
    public static com.baidu.tieba.tbadkCore.j eYX;
    private com.baidu.adp.lib.e.b<TbImageView> bTR;
    private com.baidu.tbadk.util.w ctJ;
    private com.baidu.tieba.frs.gametab.b dor;
    private com.baidu.tieba.frs.entelechy.a eYF;
    private com.baidu.tieba.tbadkCore.data.f eYP;
    private VoiceManager eYS;
    private OvalActionButton eYU;
    private FRSRefreshButton eYV;
    private j eZA;
    public com.baidu.tieba.frs.vc.c eZB;
    private com.baidu.tieba.frs.mc.e eZC;
    private View.OnTouchListener eZD;
    private com.baidu.tieba.frs.view.a eZE;
    private com.baidu.tieba.frs.view.c eZF;
    private com.baidu.tieba.frs.vc.e eZG;
    private boolean eZH;
    private com.baidu.tieba.NEGFeedBack.a eZJ;
    private com.baidu.tieba.ala.a eZK;
    private com.baidu.tieba.frs.brand.buttommenu.a eZL;
    private AddExperiencedModel eZM;
    private boolean eZO;
    private int eZY;
    private com.baidu.card.z eZj;
    private FrsModelController eZk;
    private com.baidu.tieba.frs.vc.f eZl;
    private FrsTabViewController eZm;
    private com.baidu.tieba.frs.mc.h eZn;
    private com.baidu.tieba.frs.smartsort.b eZo;
    private com.baidu.tieba.frs.mc.b eZp;
    private ak eZq;
    private com.baidu.tieba.frs.entelechy.b.b eZs;
    private com.baidu.tbadk.k.a eZt;
    private com.baidu.tieba.frs.vc.a eZu;
    private com.baidu.tieba.frs.mc.d eZv;
    private com.baidu.tieba.frs.mc.c eZw;
    private com.baidu.tieba.frs.vc.h eZx;
    private com.baidu.tieba.frs.mc.a eZy;
    private com.baidu.tieba.frs.live.a eZz;
    private com.baidu.tbadk.core.dialog.a eks;
    private View mRootView;
    public static boolean eYK = false;
    public static volatile long eYZ = 0;
    public static volatile long eZa = 0;
    public static volatile int eZb = 0;
    public boolean eYG = false;
    private boolean eYH = false;
    private boolean eYI = false;
    private boolean eYJ = true;
    public String eYL = null;
    public String mFrom = null;
    public int mFlag = 0;
    public boolean eYM = false;
    private boolean eYN = false;
    private String mThreadId = null;
    public String forumId = null;
    private int eYy = 0;
    private boolean eYO = false;
    private boolean eYQ = false;
    private boolean eYR = false;
    private k eYT = null;
    private boolean eYW = false;
    public final bg bTk = null;
    private FrsViewData eYw = new FrsViewData();
    public long eCP = -1;
    public long cqv = 0;
    public long cqn = 0;
    public long createTime = 0;
    public long beginTime = -1;
    public long eYY = 0;
    public boolean eZc = false;
    private boolean eZd = false;
    private boolean eZe = false;
    public com.baidu.tbadk.o.b eZf = null;
    private boolean eZg = true;
    private boolean eZh = true;
    private a.C0037a eZi = new a.C0037a(2);
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> eZr = new SparseArray<>();
    private boolean ddg = true;
    private boolean eZI = false;
    private boolean hasInit = false;
    private boolean eZN = false;
    private AlphaAnimation eZP = null;
    private AlphaAnimation eZQ = null;
    private AddExperiencedModel.a eZR = new AddExperiencedModel.a() { // from class: com.baidu.tieba.frs.FrsFragment.1
        @Override // com.baidu.tieba.share.AddExperiencedModel.a
        public void a(ContriInfo contriInfo) {
        }
    };
    private HttpMessageListener eZS = new HttpMessageListener(CmdConfigHttp.CMD_PB_FLOOR_AGREE, true) { // from class: com.baidu.tieba.frs.FrsFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof PbFloorAgreeResponseMessage)) {
                PbFloorAgreeResponseMessage pbFloorAgreeResponseMessage = (PbFloorAgreeResponseMessage) httpResponsedMessage;
            }
        }
    };
    private final CustomMessageListener eZT = new CustomMessageListener(2016495) { // from class: com.baidu.tieba.frs.FrsFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof bg) {
                    com.baidu.tieba.frs.f.h.a(FrsFragment.this.eYT, FrsFragment.this.eYw, FrsFragment.this.getForumId(), true, (bg) data);
                }
            }
        }
    };
    private CustomMessageListener eZU = new CustomMessageListener(2921005) { // from class: com.baidu.tieba.frs.FrsFragment.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.eYw != null) {
                FrsFragment.this.eYw.removeGameRankListFromThreadList();
                if (FrsFragment.this.eYT != null) {
                    FrsFragment.this.eYT.Ru();
                }
            }
        }
    };
    private CustomMessageListener XV = new CustomMessageListener(2921401) { // from class: com.baidu.tieba.frs.FrsFragment.40
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && FrsFragment.this.eYV != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() <= 0 || FrsFragment.this.eZm.bjy() == 0) {
                    if (FrsFragment.this.eZm.bjy() != 0) {
                        FrsFragment.this.bcQ();
                        return;
                    }
                    return;
                }
                FrsFragment.this.bcR();
            }
        }
    };
    private CustomMessageListener eZV = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.FrsFragment.41
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 1) {
                    FrsFragment.this.bcI();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                }
            }
        }
    };
    private final ai eZW = new ai() { // from class: com.baidu.tieba.frs.FrsFragment.42
        @Override // com.baidu.tieba.frs.ai
        public void a(int i, int i2, ap apVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
            FrsFragment.this.bcy();
            if (FrsFragment.this.eZs != null) {
                FrsFragment.this.eZl.jP(FrsFragment.this.eZs.qz(i));
            }
            e.b bVar = new e.b();
            if (apVar != null) {
                bVar.isSuccess = apVar.errCode == 0;
                bVar.errorCode = apVar.errCode;
                bVar.errorMsg = apVar.errMsg;
                if (bVar.isSuccess) {
                    if (com.baidu.tbadk.core.util.v.T(arrayList)) {
                        FrsFragment.this.eYT.aCx();
                    } else if (apVar.hasMore) {
                        if (com.baidu.tbadk.core.util.v.S(FrsFragment.this.eYw.getThreadList()) > 3) {
                            FrsFragment.this.eYT.aCv();
                        } else {
                            FrsFragment.this.eYT.bdP();
                        }
                    } else if (apVar.fde) {
                        FrsFragment.this.eYT.aCw();
                    } else {
                        FrsFragment.this.eYT.aCx();
                    }
                }
            } else {
                apVar = new ap();
                apVar.pn = 1;
                apVar.hasMore = false;
                apVar.fde = false;
            }
            if (i == 1) {
                FrsFragment.this.eZg = true;
                FrsFragment.this.faj.a(FrsFragment.this.eZk.getType(), false, bVar);
            } else {
                FrsFragment.this.a(bVar);
                if (FrsFragment.this.eZk.bhp() != null) {
                    FrsFragment.this.eYw = FrsFragment.this.eZk.bhp();
                }
                FrsFragment.this.bcK();
            }
            if (FrsFragment.this.faq != null) {
                FrsFragment.this.faq.a(i, i2, apVar, arrayList);
            }
        }
    };
    private FrsTabViewController.a eZX = new FrsTabViewController.a() { // from class: com.baidu.tieba.frs.FrsFragment.43
        @Override // com.baidu.tieba.frs.vc.FrsTabViewController.a
        public void jH(int i) {
            boolean z = false;
            if (i != 1) {
                t.aQG().hQ(false);
                FrsFragment.this.iS(false);
            }
            if (i == 303 && i != FrsFragment.this.eZY) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13121").bJ(ImageViewerConfig.FORUM_ID, FrsFragment.this.forumId).bJ("uid", TbadkCoreApplication.getCurrentAccount()));
            }
            if (i == 502) {
                FrsFragment.this.eYU.setIconFade(d.f.btn_frs_professional_edit_n);
            } else {
                FrsFragment.this.eYU.setIconFade(0);
            }
            FrsFragment.this.eZY = i;
            FrsFragment.this.bcN();
            com.baidu.tieba.frs.d.d.fhf.fte = i;
            com.baidu.tieba.frs.d.d.fhf.ftf = -1;
            com.baidu.tieba.frs.a bbG = com.baidu.tieba.frs.a.bbG();
            if (i == 1 && FrsFragment.this.eZN) {
                z = true;
            }
            bbG.B(z, true);
        }
    };
    private CustomMessageListener eZZ = new CustomMessageListener(2001606) { // from class: com.baidu.tieba.frs.FrsFragment.44
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                FrsFragment.this.eZm.rE(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    };
    private CustomMessageListener faa = new CustomMessageListener(2001607) { // from class: com.baidu.tieba.frs.FrsFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && ((Integer) customResponsedMessage.getData()).intValue() == 51 && FrsFragment.this.eYw != null) {
                com.baidu.tieba.frs.f.j.a(FrsFragment.this.eYw, FrsFragment.this.getPageContext());
            }
        }
    };
    private final CustomMessageListener fab = new CustomMessageListener(2003019) { // from class: com.baidu.tieba.frs.FrsFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                FrsFragment.this.eZm.rC(49);
            }
        }
    };
    private final CustomMessageListener fac = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.frs.FrsFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && FrsFragment.this.eYw != null && FrsFragment.this.eYw.getForum() != null) {
                SignData signData = (SignData) customResponsedMessage.getData();
                int user_level = FrsFragment.this.eYw.getForum().getUser_level();
                if (signData.forumId != null && signData.forumId.equals(FrsFragment.this.eYw.getForum().getId())) {
                    FrsFragment.this.eYw.updateSignData(signData);
                    FrsFragment.this.eZl.i(FrsFragment.this.eYw);
                    if (FrsFragment.this.eZl.bjj()) {
                        i = FrsFragment.this.eYw.getForum().getUser_level();
                        if (user_level >= i) {
                            i++;
                        }
                    } else {
                        i = user_level;
                    }
                    TbadkCoreApplication.getInst().addSignedForum(FrsFragment.this.eYw.getForum().getName(), signData.sign_bonus_point, i);
                }
            }
        }
    };
    private final CustomMessageListener fad = new CustomMessageListener(2001352) { // from class: com.baidu.tieba.frs.FrsFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof r) && FrsFragment.this.eYw != null) {
                FrsFragment.this.eYw.updateLikeData((r) customResponsedMessage.getData());
                FrsFragment.this.eZl.h(FrsFragment.this.eYw);
                FrsFragment.this.eZm.a(FrsFragment.this.eYw, FrsFragment.this.eZk.bhQ());
            }
        }
    };
    private final AntiHelper.a fae = new AntiHelper.a() { // from class: com.baidu.tieba.frs.FrsFragment.6
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12536").T("obj_locate", at.a.bLm));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12535").T("obj_locate", at.a.bLm));
        }
    };
    private CustomMessageListener ddr = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.frs.FrsFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(FrsFragment.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().bYy != null) {
                        if (AntiHelper.a(FrsFragment.this.getActivity(), updateAttentionMessage.getData().bYy, FrsFragment.this.fae) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12534").T("obj_locate", at.a.bLm));
                        }
                    } else if (updateAttentionMessage.getData().Jy && updateAttentionMessage.getData().isAttention) {
                        com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getPageContext().getPageActivity(), d.j.attention_success);
                    }
                }
            }
        }
    };
    private CustomMessageListener faf = new CustomMessageListener(2921346) { // from class: com.baidu.tieba.frs.FrsFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsFragment.this.refresh();
        }
    };
    private CustomMessageListener fag = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.frs.FrsFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                FrsFragment.this.eYT.c((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener fah = new CustomMessageListener(2001626) { // from class: com.baidu.tieba.frs.FrsFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewsRemindMessage newsRemindMessage;
            if (customResponsedMessage != null && (customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626 && (newsRemindMessage = (NewsRemindMessage) customResponsedMessage) != null) {
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (FrsFragment.this.eYT != null) {
                    FrsFragment.this.eYT.w(notificationCount, z);
                }
            }
        }
    };
    private final CustomMessageListener bro = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.frs.FrsFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.isResumed()) {
                FrsFragment.this.bda();
            }
        }
    };
    private CustomMessageListener fai = new CustomMessageListener(2003020) { // from class: com.baidu.tieba.frs.FrsFragment.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (FrsFragment.this.eYT != null) {
                    FrsFragment.this.eYT.setExpanded(booleanValue);
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.n faj = new com.baidu.tieba.tbadkCore.n() { // from class: com.baidu.tieba.frs.FrsFragment.14
        private long startTime = 0;

        @Override // com.baidu.tieba.tbadkCore.n
        public void pX(int i) {
            this.startTime = System.nanoTime();
            if (FrsFragment.this.eYT != null) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsFragment.this.eYT.bdy();
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
        public void a(int i, boolean z, e.b bVar) {
            if (FrsFragment.this.ddg) {
                FrsFragment.this.ddg = false;
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.eYT, FrsFragment.this.eYw, FrsFragment.this.getForumId(), false, null);
            }
            FrsFragment.this.bcy();
            FrsFragment.this.eZd = true;
            if (bVar != null && bVar.isSuccess) {
                FrsFragment.this.eYT.bdL().jC(com.baidu.tbadk.core.util.ar.adp().adr());
                FrsFragment.eYZ = 0L;
                FrsFragment.eZa = 0L;
                FrsFragment.eZb = 0;
            } else {
                FrsFragment.eZb = 1;
            }
            if (!FrsFragment.this.eZk.bhU() && (i == 3 || i == 6)) {
                FrsFragment.this.eZw.resetData();
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (FrsFragment.this.eZk.bhp() != null) {
                FrsFragment.this.eYw = FrsFragment.this.eZk.bhp();
            }
            FrsFragment.this.eYT.b(FrsFragment.this.eYw.getRedpacketRainData());
            FrsFragment.this.pU(1);
            if (i == 7) {
                FrsFragment.this.pV(FrsFragment.this.eYw.getFrsDefaultTabId());
                return;
            }
            if (FrsFragment.this.eYw.getPage() != null) {
                FrsFragment.this.setHasMore(FrsFragment.this.eYw.getPage().XK());
            }
            if (i == 4) {
                if (!FrsFragment.this.eZk.bhU() && TbadkCoreApplication.getInst().isRecAppExist() && FrsFragment.this.eZk.bhL() == 1) {
                    FrsFragment.this.eYw.addRecommendAppToThreadList(FrsFragment.this);
                }
                ArrayList<com.baidu.adp.widget.ListView.m> a2 = FrsFragment.this.eZw.a(false, false, FrsFragment.this.eYw.getThreadList(), FrsFragment.this.eYP, false);
                if (a2 != null) {
                    FrsFragment.this.eYw.setThreadList(a2);
                    FrsFragment.this.eYw.updateInterviewTaskInfoDataInThreadList();
                }
                if (FrsFragment.this.eZk != null) {
                    com.baidu.tieba.frs.d.c.a(FrsFragment.this.eYw, FrsFragment.this.eZk.bhQ(), 2);
                }
                com.baidu.tieba.frs.f.a.a(FrsFragment.this, FrsFragment.this.eYw.getForum(), FrsFragment.this.eYw.getThreadList(), false, FrsFragment.this.getPn());
                FrsFragment.this.cqv = System.currentTimeMillis() - currentTimeMillis;
                FrsFragment.this.eYT.a(a2, FrsFragment.this.eYw);
                FrsFragment.this.bcz();
                return;
            }
            FrsFragment.this.bcz();
            switch (i) {
                case 1:
                    FrsFragment.this.eYT.bdy();
                    break;
                case 2:
                    FrsFragment.this.eYT.bdy();
                    break;
                case 3:
                case 6:
                    if (FrsFragment.this.eYw != null) {
                        FrsFragment.this.eYw.clearPostThreadCount();
                    }
                    if (FrsFragment.this.eZB != null) {
                        FrsFragment.this.eZB.refresh();
                        break;
                    }
                    break;
            }
            FrsFragment.this.bcD();
            if (bVar == null || bVar.errorCode == 0) {
                if (FrsFragment.this.eYw != null) {
                    FrsFragment.this.E(false, i == 5);
                    if (FrsFragment.this.eZk != null) {
                        com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), FrsFragment.this.eYw.getThreadList(), FrsFragment.this.eYw.getForum(), FrsFragment.this.eZk.getSortType());
                    }
                    FrsFragment.this.eYT.qg(i);
                    FrsFragment.eYZ = (System.nanoTime() - this.startTime) / 1000000;
                    if (bVar != null) {
                        FrsFragment.eZa = bVar.iDZ;
                    }
                } else {
                    return;
                }
            } else if (FrsFragment.this.eYw == null || com.baidu.tbadk.core.util.v.T(FrsFragment.this.eYw.getThreadList())) {
                FrsFragment.this.a(bVar);
            } else if (bVar.iDY) {
                FrsFragment.this.showToast(FrsFragment.this.getPageContext().getResources().getString(d.j.net_error_text, bVar.errorMsg, Integer.valueOf(bVar.errorCode)));
            }
            FrsFragment.this.bcA();
            FrsFragment.this.bcB();
            if (FrsFragment.this.eYw.getAccessFlag() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11384"));
            }
            if (FrsFragment.this.eCP > -1 && !FrsFragment.this.eZI) {
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.eZk, FrsFragment.this.eCP);
                FrsFragment.this.eCP = -1L;
                FrsFragment.this.eZI = true;
            }
            if (FrsFragment.this.eYQ && FrsFragment.this.eZm.rC(49)) {
                FrsFragment.this.eYQ = false;
            }
            FrsFragment.this.cqv = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void b(com.baidu.tieba.tbadkCore.j jVar) {
            if ((jVar != null && ("normal_page".equals(FrsFragment.this.eZk.getPageType()) || "frs_page".equals(FrsFragment.this.eZk.getPageType()) || "book_page".equals(FrsFragment.this.eZk.getPageType()))) || "brand_page".equals(FrsFragment.this.eZk.getPageType())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001615, jVar));
                FrsFragment.this.a(jVar);
                FrsFragment.eYX = jVar;
            }
        }
    };
    private final CustomMessageListener fak = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.frs.FrsFragment.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                FrsFragment.this.eYw.updateCurrentUserPendant((com.baidu.tbadk.data.l) customResponsedMessage.getData());
                FrsFragment.this.eYT.bdL().notifyDataSetChanged();
            }
        }
    };
    private final CustomMessageListener mMemListener = new CustomMessageListener(2001194) { // from class: com.baidu.tieba.frs.FrsFragment.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && FrsFragment.this.eYw != null && (userData = FrsFragment.this.eYw.getUserData()) != null) {
                userData.setIsMem(num.intValue());
                if (num.intValue() != 0) {
                    FrsFragment.this.eZl.h(num);
                }
            }
        }
    };
    private final com.baidu.tieba.frs.mc.k fal = new com.baidu.tieba.frs.mc.k() { // from class: com.baidu.tieba.frs.FrsFragment.26
        @Override // com.baidu.tieba.frs.mc.k
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.m> arrayList, boolean z3) {
            if (FrsFragment.this.eZo != null && FrsFragment.this.eZk != null && FrsFragment.this.eZk.bhU() && z && !z2 && !z3) {
                FrsFragment.this.eZo.rf(i2);
            }
        }
    };
    public final View.OnTouchListener ccU = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.FrsFragment.27
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (FrsFragment.this.eZD != null) {
                FrsFragment.this.eZD.onTouch(view, motionEvent);
            }
            if (FrsFragment.this.eZq != null && FrsFragment.this.eZq.bet() != null) {
                FrsFragment.this.eZq.bet().onTouchEvent(motionEvent);
            }
            if (FrsFragment.this.dor != null) {
                FrsFragment.this.dor.f(view, motionEvent);
            }
            if (FrsFragment.this.eZl != null) {
                FrsFragment.this.eZl.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private final CustomMessageListener fam = new CustomMessageListener(2004507) { // from class: com.baidu.tieba.frs.FrsFragment.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "photolive_hostLevel", -1) != -1 && FrsFragment.this.eYw.getForum() != null) {
                FrsFragment.this.eYw.getForum().setCanAddPhotoLivePost(true);
            }
        }
    };
    public final View.OnClickListener fan = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.30
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsFragment.this.eYT == null || view != FrsFragment.this.eYT.bdw() || FrsFragment.this.getActivity() == null) {
                if (FrsFragment.this.eYw == null || FrsFragment.this.eYw.getForum() == null || FrsFragment.this.eYT == null || view != FrsFragment.this.eYT.bdC()) {
                    if (FrsFragment.this.eYw != null && FrsFragment.this.eYw.getForum() != null && FrsFragment.this.eYT != null && view == FrsFragment.this.eYT.bdD()) {
                        if (FrsFragment.this.eZF == null) {
                            FrsFragment.this.eZF = new com.baidu.tieba.frs.view.c(FrsFragment.this.getPageContext());
                        }
                        FrsFragment.this.eZF.l(FrsFragment.this.eYw);
                        FrsFragment.this.eZF.showDialog();
                        return;
                    }
                    if (view.getId() == d.g.game_activity_egg_layout && com.baidu.adp.lib.util.l.lo()) {
                        TiebaStatic.log("c10853");
                        if (FrsFragment.this.eYT.bdI()) {
                            FrsFragment.this.eYT.bdJ();
                        } else {
                            String activityUrl = FrsFragment.this.eYw.getForum().getYuleData().aaT().getActivityUrl();
                            if (!StringUtils.isNull(activityUrl)) {
                                com.baidu.tbadk.browser.a.as(FrsFragment.this.getPageContext().getPageActivity(), activityUrl);
                            }
                        }
                    }
                    if (view == FrsFragment.this.eYT.bdQ() && FrsFragment.this.eZk != null && FrsFragment.this.eZk.hasMore()) {
                        FrsFragment.this.eYT.aCv();
                        FrsFragment.this.aBd();
                    }
                    if (view != null && view == FrsFragment.this.eYT.bdF() && bc.cZ(FrsFragment.this.getContext())) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12924").T("obj_locate", 2));
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(FrsFragment.this.getContext())));
                        return;
                    }
                    return;
                }
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12402").bJ(ImageViewerConfig.FORUM_ID, FrsFragment.this.eYw.getForum().getId()).bJ("uid", TbadkCoreApplication.getCurrentAccount()).bJ(ImageViewerConfig.FORUM_NAME, FrsFragment.this.eYw.getForum().getName()));
                if (!StringUtils.isNull(FrsFragment.this.eYw.getForum().getName())) {
                    FrsFragment.this.sendMessage(new CustomMessage(2002001, new PostSearchActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), FrsFragment.this.eYw.getForum().getName(), FrsFragment.this.eYw.getForum().getId())));
                    return;
                }
                return;
            }
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
            customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, FrsFragment.this.getPageContext().getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.FrsFragment.31
        private int fay = 0;
        private int cZV = 0;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (FrsFragment.this.eZu != null) {
                FrsFragment.this.eZu.biJ();
            }
            this.fay = 0;
            this.cZV = 0;
            if (recyclerView != null && (recyclerView instanceof BdRecyclerView)) {
                this.fay = ((BdRecyclerView) recyclerView).getFirstVisiblePosition();
                this.cZV = ((BdRecyclerView) recyclerView).getLastVisiblePosition();
            }
            if (FrsFragment.this.eZG != null) {
                FrsFragment.this.eZG.a(recyclerView, this.fay, this.cZV);
            }
            if (FrsFragment.this.eYw != null && FrsFragment.this.eYT != null && FrsFragment.this.eYT.bdL() != null) {
                FrsFragment.this.eYT.bh(this.fay, this.cZV);
                if (FrsFragment.this.eZj != null && FrsFragment.this.eZj.rx() != null) {
                    FrsFragment.this.eZj.rx().b(FrsFragment.this.eZi);
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (FrsFragment.this.eZl != null) {
                FrsFragment.this.eZl.setScrollState(i);
            }
            if (i == 0) {
                FrsFragment.this.eYT.bdU();
            }
            if ((i == 2 || i == 1) && !FrsFragment.this.eZe) {
                FrsFragment.this.eZe = true;
                FrsFragment.this.eYT.bdO();
            }
            if (FrsFragment.this.eZf == null && !FrsFragment.this.bcU()) {
                FrsFragment.this.eZf = new com.baidu.tbadk.o.b();
                FrsFragment.this.eZf.jX(1000);
            }
            if (i == 0) {
                if (FrsFragment.this.eZf != null) {
                    FrsFragment.this.eZf.apb();
                }
                t.aQG().hQ(true);
                FrsFragment.this.iS(true);
                FrsFragment.this.eYT.bg(this.fay, this.cZV);
            } else if (FrsFragment.this.eZf != null) {
                FrsFragment.this.eZf.apa();
            }
            if (FrsFragment.this.eZG != null) {
                FrsFragment.this.eZG.onScrollStateChanged(recyclerView, i);
            }
            if (i == 0) {
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.eYT, FrsFragment.this.eYw, FrsFragment.this.getForumId(), false, null);
            }
            if (FrsFragment.this.eZm != null && i == 1) {
                FrsFragment.this.eZm.bjx();
            }
            if (FrsFragment.this.eZj == null) {
                if (FrsFragment.this.eYT.bdp() != null && !FrsFragment.this.eYT.bcT() && FrsFragment.this.eYT.bdp().bTl() != null && (FrsFragment.this.eYT.bdp().bTl().getTag() instanceof com.baidu.card.z)) {
                    FrsFragment.this.eZj = (com.baidu.card.z) FrsFragment.this.eYT.bdp().bTl().getTag();
                }
            } else if (i == 0 && FrsFragment.this.eYT.bdp() != null && !FrsFragment.this.eYT.bcT() && FrsFragment.this.eYT.bdp().bTl() != null && (FrsFragment.this.eYT.bdp().bTl().getTag() instanceof com.baidu.card.z)) {
                FrsFragment.this.eZj = (com.baidu.card.z) FrsFragment.this.eYT.bdp().bTl().getTag();
            }
        }
    };
    private final d fao = new d() { // from class: com.baidu.tieba.frs.FrsFragment.32
        @Override // com.baidu.tieba.frs.d
        public void a(int i, int i2, View view, View view2, bg bgVar) {
            if (i != FrsFragment.this.eYT.bdL().bfE()) {
                if (i != FrsFragment.this.eYT.bdL().bfF()) {
                    if (i == FrsFragment.this.eYT.bdL().bfC() && FrsFragment.this.eYw != null && FrsFragment.this.eYw.getUserData() != null && FrsFragment.this.eYw.getUserData().isBawu()) {
                        String bawuCenterUrl = FrsFragment.this.eYw.getBawuCenterUrl();
                        if (!com.baidu.tbadk.core.util.ap.isEmpty(bawuCenterUrl) && FrsFragment.this.eYw.getForum() != null) {
                            com.baidu.tbadk.browser.a.ar(FrsFragment.this.getPageContext().getPageActivity(), bawuCenterUrl);
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10502").bJ(ImageViewerConfig.FORUM_ID, FrsFragment.this.eYw.getForum().getId()).bJ("uid", FrsFragment.this.eYw.getUserData().getUserId()));
                        }
                    }
                } else if (bc.cZ(FrsFragment.this.getPageContext().getPageActivity())) {
                    TiebaStatic.log("my_service_ck");
                    if (FrsFragment.this.eYw != null && FrsFragment.this.eYw.getForum() != null) {
                        ForumData forum = FrsFragment.this.eYw.getForum();
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(forum.getId(), 0L), forum.getName(), forum.getImage_url(), 0)));
                    }
                }
            } else if (bc.cZ(FrsFragment.this.getActivity())) {
                TiebaStatic.log("forum_fortune_click");
                com.baidu.tieba.frs.f.i.b(FrsFragment.this.getPageContext(), FrsFragment.this.eYw);
            }
        }
    };
    private final NoNetworkView.a eWE = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.FrsFragment.33
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void dP(boolean z) {
            if (FrsFragment.this.eZk.bhL() == 1 && z && !FrsFragment.this.eYT.bcT()) {
                if (FrsFragment.this.eYw == null || com.baidu.tbadk.core.util.v.T(FrsFragment.this.eYw.getThreadList())) {
                    FrsFragment.this.hideNetRefreshView(FrsFragment.this.eYT.bdM());
                    FrsFragment.this.showLoadingView(FrsFragment.this.eYT.bdM(), true);
                    FrsFragment.this.eYT.jd(false);
                    FrsFragment.this.refresh();
                    return;
                }
                FrsFragment.this.eYT.bdy();
            }
        }
    };
    private final CustomMessageListener bZb = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.FrsFragment.35
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                com.baidu.tieba.frs.f.c.a(customResponsedMessage, FrsFragment.this.eYT, FrsFragment.this.eYw);
            }
        }
    };
    private s fap = new a();
    private ai faq = new ai() { // from class: com.baidu.tieba.frs.FrsFragment.37
        @Override // com.baidu.tieba.frs.ai
        public void a(int i, int i2, ap apVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
            com.baidu.adp.lib.g.e.jH().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.37.1
                @Override // java.lang.Runnable
                public void run() {
                    if (FrsFragment.this.eYT != null && FrsFragment.this.eYT.aRE()) {
                        FrsFragment.this.aBd();
                    }
                }
            });
        }
    };
    private CustomMessageListener far = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.frs.FrsFragment.38
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    FrsFragment.this.eZH = true;
                }
            }
        }
    };
    private CustomMessageListener fas = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.frs.FrsFragment.39
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && FrsFragment.this.eZj != null && FrsFragment.this.eZj.rx() != null) {
                    FrsFragment.this.eZj.rx().b(new a.C0037a(3));
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.frs.loadmore.a
    public /* bridge */ /* synthetic */ com.baidu.adp.base.e getPageContext() {
        return super.getPageContext();
    }

    public com.baidu.tieba.frs.entelechy.b.b bcm() {
        return this.eZs;
    }

    public s bcn() {
        return this.fap;
    }

    public com.baidu.tieba.frs.mc.d bco() {
        return this.eZv;
    }

    public com.baidu.tieba.frs.smartsort.b bcp() {
        return this.eZo;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public FrsModelController bcq() {
        return this.eZk;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public com.baidu.tieba.frs.mc.c bcr() {
        return this.eZw;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public com.baidu.tieba.frs.vc.f bcs() {
        return this.eZl;
    }

    public FrsTabViewController bct() {
        return this.eZm;
    }

    public ak bcu() {
        return this.eZq;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public k bcv() {
        return this.eYT;
    }

    @Override // com.baidu.tieba.frs.aj
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.aj, com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.eYL;
    }

    public void setForumName(String str) {
        this.eYL = str;
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
        if (this.eZw == null) {
            return 1;
        }
        return this.eZw.getPn();
    }

    public int getPn() {
        if (this.eZw == null) {
            return 1;
        }
        return this.eZw.getPn();
    }

    public void setPn(int i) {
        if (this.eZw != null) {
            this.eZw.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.eZw != null) {
            this.eZw.setHasMore(i);
        }
    }

    public int bcw() {
        if (this.eZw == null) {
            return -1;
        }
        return this.eZw.bcw();
    }

    public boolean bcx() {
        return this.eYR;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public View getRootView() {
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e.b bVar) {
        if (bVar == null) {
            String string = TbadkCoreApplication.getInst().getString(d.j.error_unkown_try_again);
            this.eYT.bds();
            showNetRefreshView(this.eYT.bdM(), string, true);
        } else if (340001 == bVar.errorCode) {
            a(bVar, this.eYw.getRecm_forum_list());
        } else {
            if (com.baidu.tbadk.core.util.v.T(this.eYw.getThreadList())) {
                b(bVar);
            }
            if (bcU()) {
                setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst(), d.e.ds280));
            } else {
                setNetRefreshViewEmotionDefMarginTop();
            }
        }
    }

    public void a(View view, String str, boolean z, List<RecmForumInfo> list) {
        this.eYT.bds();
        this.eYT.qc(8);
        if (this.eZE == null) {
            this.eZE = new com.baidu.tieba.frs.view.a(getPageContext(), getNetRefreshListener());
        }
        this.eZE.po(str);
        this.eZE.cj(list);
        this.eZE.attachView(view, z);
    }

    private void a(e.b bVar, List<RecmForumInfo> list) {
        if (this.eYT != null) {
            this.eYT.bds();
            this.eYT.setTitle(this.eYL);
            a(this.eYT.bdM(), bVar.errorMsg, true, list);
        }
    }

    private void b(e.b bVar) {
        this.eYT.bds();
        if (bVar.iDY) {
            showNetRefreshView(this.eYT.bdM(), TbadkCoreApplication.getInst().getString(d.j.net_error_text, new Object[]{bVar.errorMsg, Integer.valueOf(bVar.errorCode)}), true);
        } else {
            showNetRefreshView(this.eYT.bdM(), bVar.errorMsg, true);
        }
    }

    public void bcy() {
        hideLoadingView(this.eYT.bdM());
        this.eYT.jf(false);
        if (this.eYT.bdq() instanceof com.baidu.tieba.frs.tab.c) {
            ((com.baidu.tieba.frs.tab.c) this.eYT.bdq()).biq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcz() {
        if (bcw() == 0 && com.baidu.tbadk.core.util.v.T(this.eYw.getThreadListIds())) {
            if (com.baidu.tbadk.core.util.v.T(this.eYw.getThreadList())) {
                this.eYT.aCx();
            } else {
                this.eYT.aCw();
            }
        } else if (com.baidu.tbadk.core.util.v.S(this.eYw.getThreadList()) > 3) {
            this.eYT.aCv();
        } else {
            this.eYT.bdP();
        }
    }

    public void a(ErrorData errorData) {
        bcy();
        this.eYT.bdy();
        e.b bhI = this.eZk.bhI();
        boolean T = com.baidu.tbadk.core.util.v.T(this.eYw.getThreadList());
        if (bhI != null && T) {
            if (this.eZk.bhJ() != 0) {
                this.eZk.bhO();
                this.eYT.bdy();
            } else {
                a(bhI);
            }
            this.eYT.F(this.eYw.isStarForum(), false);
            return;
        }
        a(bhI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcA() {
        boolean b;
        if (!bcC()) {
            final PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
            privateForumPopInfoData.a(this.eYw.getPrivateForumTotalInfo().getPrivatePopInfo());
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(getActivity());
            if (this.eYw.getPrivateForumTotalInfo().XS().private_forum_status.intValue() == 1 && (com.baidu.tbadk.core.util.ap.isEmpty(privateForumPopInfoData.XU()) || privateForumPopInfoData.XX() != Integer.valueOf(this.forumId))) {
                privateForumPopInfoData.lb("create_success");
                privateForumPopInfoData.lc(TbadkCoreApplication.getInst().getString(d.j.frs_private_create_hint));
                privateForumPopInfoData.ld("https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.eYL + "&nomenu=1");
                privateForumPopInfoData.b(Integer.valueOf(this.forumId));
                b = frsPrivateCommonDialogView.b(privateForumPopInfoData);
            } else {
                b = privateForumPopInfoData.XX() == Integer.valueOf(this.forumId) ? frsPrivateCommonDialogView.b(privateForumPopInfoData) : false;
            }
            if (b) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
                aVar.gF(2);
                aVar.az(frsPrivateCommonDialogView);
                aVar.dr(false);
                frsPrivateCommonDialogView.setConfirmButton(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.15
                    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.frs.FrsFragment */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ba.adD().c(FrsFragment.this.getPageContext(), new String[]{privateForumPopInfoData.XW()});
                        aVar.dismiss();
                    }
                });
                aVar.a(new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.16
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(getPageContext()).aaZ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcB() {
        if (bcC() || this.eYw.getPrivateForumTotalInfo().XS().private_forum_status.intValue() != 1) {
            a((Integer) null, (Integer) null, true);
        } else {
            a(this.eYw.getPrivateForumTotalInfo().XS().private_forum_audit_status, this.eYw.getPrivateForumTotalInfo().XT(), false);
        }
    }

    public void a(Integer num, Integer num2, boolean z) {
        final String str;
        final int i = 2;
        if (this.eYT.bdE() != null) {
            TextView bdE = this.eYT.bdE();
            if (z) {
                bdE.setVisibility(8);
                return;
            }
            if (num.intValue() == 2) {
                bdE.setText("修改实名认证信息");
                bdE.setVisibility(0);
                str = "https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + this.forumId + "&nomenu=1";
            } else if (num2.intValue() >= 0 && num2.intValue() <= 100) {
                bdE.setText("目标已完成" + String.valueOf(num2) + "%");
                bdE.setVisibility(0);
                str = "https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.eYL + "&nomenu=1";
                i = 1;
            } else {
                bdE.setVisibility(8);
                i = 0;
                str = "";
            }
            bdE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.17
                /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13387").bJ(ImageViewerConfig.FORUM_ID, FrsFragment.this.forumId).bJ("uid", TbadkCoreApplication.getCurrentAccount()).T("obj_type", i));
                    ba.adD().c(FrsFragment.this.getPageContext(), new String[]{str});
                }
            });
        }
    }

    private boolean bcC() {
        return this.eYw == null || !this.eYw.isPrivateForum() || this.eYw.getPrivateForumTotalInfo() == null || this.eYw.getPrivateForumTotalInfo().XS() == null || this.eYw.getUserData().getIs_manager() != 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pU(int i) {
        List<WindowToast> list;
        if (TbadkCoreApplication.isLogin() && this.eYw != null && (list = this.eYw.mWindowToast) != null && list.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < list.size()) {
                    WindowToast windowToast = list.get(i3);
                    if (windowToast == null || windowToast.toast_type.intValue() != i) {
                        i2 = i3 + 1;
                    } else if (!com.baidu.tbadk.core.util.ap.isEmpty(windowToast.toast_link)) {
                        sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(getPageContext().getPageActivity(), "", com.baidu.tbadk.util.ae.pT(windowToast.toast_link), true)));
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
    public void bcD() {
        if (this.eYw == null || this.eYw.getForum() != null) {
            this.eYT.bdK();
        } else if (this.eYw.getForum().getYuleData() != null && this.eYw.getForum().getYuleData().aaS()) {
            TiebaStatic.log("c10852");
            this.eYT.a(this.eYw.getForum().getYuleData().aaT());
        } else {
            this.eYT.bdK();
        }
    }

    private void D(boolean z, boolean z2) {
        if (this.eZk != null && this.eYw != null && this.eYT != null && z) {
            if (!this.eZk.bhU() && this.eZk.bhL() == 1) {
                if (!this.eZk.bhS()) {
                    this.eYw.addCardVideoInfoToThreadList();
                    this.eYw.addVideoInfoToThreadListInTenAndFifteenFloor();
                }
                boolean z3 = false;
                if (this.eYT.bdL().l(com.baidu.tieba.card.data.n.elW)) {
                    z3 = this.eYw.addHotTopicDataToThreadList();
                }
                if (!z3) {
                    this.eYw.addFeedForumDataToThreadList();
                }
                if (TbadkCoreApplication.getInst().isRecAppExist()) {
                    this.eYw.addRecommendAppToThreadList(this);
                }
                if (!this.eYT.bdL().l(bg.bBc)) {
                    this.eYw.removeAlaLiveThreadData();
                }
                this.eYw.addSchoolRecommendToThreadList();
            }
            if (!this.eYT.bdL().l(bg.bBc)) {
                this.eYw.removeAlaInsertLiveData();
                this.eYw.removeAlaStageLiveDat();
            } else {
                this.eYw.addInsertLiveDataToThreadList();
                this.eYw.addStageLiveDataToThreadList();
            }
            this.eYw.updateInterviewTaskInfoDataInThreadList();
            this.eYw.addNoticeThreadToThreadList();
            if (this.eYT.bdL().l(com.baidu.tieba.h.b.fAJ)) {
                this.eYw.addGameRankListToThreadList(z2);
            }
            if (TbadkCoreApplication.isLogin() && (!this.eZk.bhU() || this.eZk.isNetFirstLoad)) {
                this.eYw.addUserRecommendToThreadList();
            }
            this.eYw.addVideoActivityToTop();
        }
    }

    public boolean bcE() {
        if (this.eZl != null && this.eZk != null) {
            this.eZl.a(this.eZk.getPageType(), this.eYw);
        }
        boolean z = false;
        if (this.eYw != null) {
            z = this.eYw.hasTab();
        }
        bcG();
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pV(int i) {
        am amVar = null;
        bcE();
        bcN();
        try {
            if (this.eYw != null) {
                this.eYT.a((ArrayList<com.baidu.adp.widget.ListView.m>) null, this.eYw);
                this.eZl.rw(1);
                this.eYT.bdB();
                this.eZm.a(this.eYw, this.eZk.bhQ());
                com.baidu.tieba.frs.tab.d rD = this.eZm.rD(this.eYw.getFrsDefaultTabId());
                if (rD != null && !TextUtils.isEmpty(rD.url)) {
                    amVar = new am();
                    amVar.fdb = rD.url;
                    amVar.stType = rD.name;
                }
                this.eZk.a(this.eYw.getFrsDefaultTabId(), 0, amVar);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(boolean z, boolean z2) {
        try {
            if (this.eYw != null && this.eZm != null && this.eZk != null) {
                if (!this.eYT.bdL().l(bg.bBc)) {
                    this.eYw.removeAlaLiveThreadData();
                }
                boolean T = com.baidu.tbadk.core.util.v.T(this.eYw.getGameTabInfo());
                this.eYT.jb(T);
                if (!T) {
                    if (this.eZG == null) {
                        this.eZG = new com.baidu.tieba.frs.vc.e(this, (NoPressedRelativeLayout) this.mRootView);
                    }
                    if (this.dor == null) {
                        this.dor = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
                    }
                } else {
                    this.eZG = null;
                    this.dor = null;
                }
                if (this.eYw.getForum() != null) {
                    this.eYL = this.eYw.getForum().getName();
                    this.forumId = this.eYw.getForum().getId();
                }
                if (this.eYw.hasTab()) {
                    this.eZm.a(this.eYw, this.eZk.bhQ());
                }
                if (z) {
                    D(true, z);
                } else {
                    D(this.eZg, z);
                }
                bcE();
                if (this.eZs != null) {
                    this.eZs.a(this.eZl, this.eYw);
                }
                if (this.eYw.getPage() != null) {
                    setHasMore(this.eYw.getPage().XK());
                }
                ArrayList<com.baidu.adp.widget.ListView.m> a2 = this.eZw.a(z2, true, this.eYw.getThreadList(), null, z, false);
                if (a2 != null) {
                    this.eYw.setThreadList(a2);
                }
                this.eYw.removeRedundantUserRecommendData();
                this.eYy = this.eYw.getTopThreadSize();
                if (this.eYP != null) {
                    this.eYO = true;
                    this.eYP.zq(this.eYy);
                    com.baidu.tieba.frs.f.a.a(this, this.eYw.getForum(), this.eYw.getThreadList(), this.eYO, getPn());
                }
                if (this.eZk.bhL() == 1) {
                    bcK();
                    if (!z && this.eZk.getPn() == 1) {
                        bcF();
                    }
                }
                if (this.eZu != null) {
                    this.eZu.bN(this.eZm.bju());
                }
                bcy();
                this.eYT.bdt();
                this.eYT.F(true, false);
                if (z && this.eYw.isFirstTabEqualAllThread()) {
                    com.baidu.adp.lib.g.e.jH().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.18
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!FrsFragment.this.eZd) {
                                FrsFragment.this.eYT.bdV();
                            }
                        }
                    });
                }
                if (this.eYw.getForum() != null) {
                    this.eYT.va(this.eYw.getForum().getWarningMsg());
                }
                if (this.eYw != null && this.eYw.getFrsVideoActivityData() != null && com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("frs_video_activity_guide", 0L) == 0) {
                    com.baidu.adp.lib.g.e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.19
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsFragment.this.eYT.bdS();
                        }
                    }, 1000L);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2921326, this));
                this.eYT.bdn();
                if (this.eYw != null && this.eYw.getForum() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016564, new VisitedForumData(this.eYw.getForum().getId(), this.eYw.getForum().getName(), this.eYw.getForum().getImage_url(), String.valueOf(System.currentTimeMillis() / 1000), "showlive".equals(this.eYw.getForum().special_forum_type), this.eYw.getForum().getThemeColorInfo(), this.eYw.getForum().getMember_num())));
                }
                this.eZL.a(this.eYw.bottomMenuList, this.eYw.getForum());
                bda();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void iS(boolean z) {
        com.baidu.tieba.q.c.cdr().b(getUniqueId(), z);
    }

    public void bcF() {
        if (this.eZz == null) {
            this.eZz = new com.baidu.tieba.frs.live.a(this, com.baidu.adp.lib.g.b.l(this.forumId, 0));
        }
        this.eZz.bhu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.j jVar) {
        try {
            if (!this.eZd && jVar != null && this.eYw != null) {
                this.eYw.receiveData(jVar);
                E(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void bcG() {
        if (this.eZk != null) {
            uY(this.eZk.getPageType());
        } else {
            uY("normal_page");
        }
    }

    private void uY(String str) {
        iT("frs_page".equals(str));
        if (this.eZs != null) {
            this.eZs.a(this.eZl, this.eYT, this.eYw);
        }
    }

    public void iT(boolean z) {
        if (this.eZx != null) {
            this.eZx.bjo();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.q.c.cdr().s(getUniqueId());
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(d.h.frs_activity, viewGroup, false);
            this.eYF = new com.baidu.tieba.frs.entelechy.a();
            this.eZs = this.eYF.bfj();
            this.eZl = new com.baidu.tieba.frs.vc.f(this, this.eYF, (FrsHeaderViewContainer) this.mRootView.findViewById(d.g.header_view_container));
            this.eZm = new FrsTabViewController(this, this.mRootView);
            this.eZm.registerListener();
            this.eZl.a(this.eZm);
            this.eZm.a(this.eZX);
            Intent intent = getActivity().getIntent();
            if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                this.eYH = true;
            }
            this.eYT = new k(this, this.fan, this.eYF, this.eYH, this.eZl);
            this.eZL = new com.baidu.tieba.frs.brand.buttommenu.a(getPageContext(), this.mRootView);
        } else {
            if (this.mRootView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            if (this.eZm != null) {
                this.eZm.registerListener();
            }
            this.eYT.bdR();
        }
        this.eZO = true;
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        ArrayList<com.baidu.adp.widget.ListView.m> arrayList = null;
        this.eCP = System.currentTimeMillis();
        this.beginTime = this.eCP;
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.eYQ = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.eCP = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            ac(intent);
        }
        this.cqn = this.beginTime - this.eCP;
        this.eYP = new com.baidu.tieba.tbadkCore.data.f("frs", com.baidu.tieba.tbadkCore.data.f.iFI);
        if (this.eZk == null) {
            this.eZk = new FrsModelController(this, this.faj);
            this.eZk.a(this.eZW);
            this.eZk.init();
        }
        if (intent != null) {
            this.eZk.J(intent.getExtras());
        } else if (bundle != null) {
            this.eZk.J(bundle);
        } else {
            this.eZk.J(null);
        }
        if (intent != null) {
            this.eZl.Q(intent.getExtras());
        } else if (bundle != null) {
            this.eZl.Q(bundle);
        } else {
            this.eZl.Q(null);
        }
        this.eYS = getVoiceManager();
        this.eZA = new j(getPageContext(), this);
        initUI();
        initData(bundle);
        if (!bcU()) {
            this.eZq = new ak(getActivity(), this.eYT, this.eZl);
            this.eZq.js(true);
        }
        this.eYS = getVoiceManager();
        if (this.eYS != null) {
            this.eYS.onCreate(getPageContext());
        }
        new com.baidu.tieba.frs.mc.i();
        int i = -1;
        if (this.eZw != null && this.eZw.bhF() != null) {
            i = this.eZw.bhF().bcw();
            arrayList = this.eZw.bhF().getDataList();
        }
        this.eZw = new com.baidu.tieba.frs.mc.c(this, this.fal);
        this.eZw.bhF().setHasMore(i);
        if (arrayList != null && arrayList.size() > 0) {
            this.eZw.bhF().Z(arrayList);
        }
        this.eZo = new com.baidu.tieba.frs.smartsort.b(this);
        this.eZx = new com.baidu.tieba.frs.vc.h(this);
        this.eZu = new com.baidu.tieba.frs.vc.a(getPageContext(), this.eZk.bhR());
        this.eZp = new com.baidu.tieba.frs.mc.b(this);
        this.eZv = new com.baidu.tieba.frs.mc.d(this);
        this.eZn = new com.baidu.tieba.frs.mc.h(this);
        this.eZy = new com.baidu.tieba.frs.mc.a(this);
        this.eZB = new com.baidu.tieba.frs.vc.c(this);
        this.eZC = new com.baidu.tieba.frs.mc.e(this, getUniqueId());
        this.eZJ = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "frs");
        this.eZK = new com.baidu.tieba.ala.a(getPageContext());
        registerListener(this.ddr);
        registerListener(this.mMemListener);
        registerListener(this.fad);
        registerListener(this.fam);
        registerListener(this.fac);
        registerListener(this.fak);
        registerListener(this.eZZ);
        registerListener(this.faa);
        registerListener(this.fab);
        registerListener(this.eZT);
        registerListener(this.eZU);
        registerListener(this.XV);
        registerListener(this.far);
        registerListener(this.fag);
        registerListener(this.eZV);
        registerListener(this.fah);
        registerListener(this.faf);
        this.eZS.setTag(getPageContext().getUniqueId());
        registerListener(this.eZS);
        registerListener(this.bro);
        registerListener(this.fai);
        this.fas.setTag(getPageContext().getUniqueId());
        MessageManager.getInstance().registerListener(this.fas);
        this.eYT.jd(false);
        if (!bcU() && !this.hasInit) {
            showLoadingView(this.eYT.bdM(), true);
            this.eZk.y(3, false);
        }
        com.baidu.tieba.frs.a.bbG().a(new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.22
            @Override // com.baidu.tieba.frs.a.b
            public void C(boolean z, boolean z2) {
                if (FrsFragment.this.eYT != null) {
                    FrsFragment.this.eYT.qd(z ? 0 : 8);
                    if (!z2) {
                        FrsFragment.this.eZN = z;
                    }
                    if (FrsFragment.this.eYT.bdL() != null && FrsFragment.this.eZk != null && FrsFragment.this.eZk.bhM()) {
                        FrsFragment.this.eYT.bdL().notifyDataSetChanged();
                    }
                    if (FrsFragment.this.bct() != null) {
                        FrsTabViewController.b bjv = FrsFragment.this.bct().bjv();
                        if (bjv != null && bjv.tabId == 502 && (bjv.fragment instanceof FrsCommonTabFragment)) {
                            ((FrsCommonTabFragment) bjv.fragment).bfh();
                        } else if (bjv != null && bjv.tabId == 503 && (bjv.fragment instanceof FrsNewAreaFragment)) {
                            FrsNewAreaFragment frsNewAreaFragment = (FrsNewAreaFragment) bjv.fragment;
                            frsNewAreaFragment.bfh();
                            if (frsNewAreaFragment.bhX() != null) {
                                com.baidu.tieba.frs.mc.g bhX = frsNewAreaFragment.bhX();
                                bhX.jg(!z);
                                bhX.jh(!z);
                            }
                        }
                        if (FrsFragment.this.bct().bjp() != null) {
                            FrsFragment.this.bct().bjp().setmDisallowSlip(z);
                            FrsFragment.this.bct().jR(z);
                        }
                    }
                    if (FrsFragment.this.eYT.bdr() != null) {
                        FrsFragment.this.eYT.ja(!z);
                    }
                    if (FrsFragment.this.getActivity() instanceof FrsActivity) {
                        ((FrsActivity) FrsFragment.this.getActivity()).iR(!z);
                    }
                    if (FrsFragment.this.eZL != null) {
                        FrsFragment.this.eZL.jA(!z);
                    }
                    FrsFragment.this.eYT.jg(!z);
                    FrsFragment.this.eYT.jh(z ? false : true);
                }
            }

            @Override // com.baidu.tieba.frs.a.b
            public void pR(int i2) {
                if (FrsFragment.this.eYT != null) {
                    FrsFragment.this.eYT.qe(i2);
                }
            }

            @Override // com.baidu.tieba.frs.a.b
            public void bbM() {
                com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getContext(), d.j.frs_multi_delete_max_num);
            }
        });
        this.eYT.b(new d.a() { // from class: com.baidu.tieba.frs.FrsFragment.24
            @Override // com.baidu.tieba.NEGFeedBack.d.a
            public void a(DeleteThreadHttpResponseMessage deleteThreadHttpResponseMessage) {
                boolean z;
                int i2 = 0;
                if (deleteThreadHttpResponseMessage != null) {
                    FrsFragment.this.eYT.auV();
                    FrsFragment.this.eYT.bdT();
                    FrsNewAreaFragment frsNewAreaFragment = null;
                    if (FrsFragment.this.eZm == null || FrsFragment.this.eZm.bjv() == null || !(FrsFragment.this.eZm.bjv().fragment instanceof FrsNewAreaFragment)) {
                        z = false;
                    } else {
                        frsNewAreaFragment = (FrsNewAreaFragment) FrsFragment.this.eZm.bjv().fragment;
                        z = true;
                    }
                    if (deleteThreadHttpResponseMessage.getError() == 0) {
                        String text = !TextUtils.isEmpty(deleteThreadHttpResponseMessage.getText()) ? deleteThreadHttpResponseMessage.getText() : FrsFragment.this.getString(d.j.delete_fail);
                        if (deleteThreadHttpResponseMessage.getRetType() == 1211066) {
                            if (FrsFragment.this.eks == null) {
                                FrsFragment.this.eks = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.eks.ly(text);
                            FrsFragment.this.eks.a(d.j.dialog_known, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.24.1
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.eks.dr(false);
                            FrsFragment.this.eks.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.eks.aaZ();
                        } else if (deleteThreadHttpResponseMessage.getRetType() == 1211067) {
                            if (FrsFragment.this.eks == null) {
                                FrsFragment.this.eks = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.eks.ly(text);
                            FrsFragment.this.eks.a(d.j.know, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.24.2
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.eks.dr(false);
                            FrsFragment.this.eks.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.eks.aaZ();
                        } else {
                            FrsFragment.this.eYT.ax(deleteThreadHttpResponseMessage.getText(), ContextCompat.getColor(FrsFragment.this.getContext(), deleteThreadHttpResponseMessage.getRetType() == 1 ? d.C0236d.nav_bar_tip_error : d.C0236d.cp_link_tip_a_alpha95));
                        }
                        if (z && frsNewAreaFragment != null) {
                            frsNewAreaFragment.ce(deleteThreadHttpResponseMessage.getSuccessItems());
                        }
                        FrsFragment.this.bR(deleteThreadHttpResponseMessage.getSuccessItems());
                        com.baidu.tieba.frs.a.bbG().bQ(deleteThreadHttpResponseMessage.getSuccessItems());
                        for (com.baidu.adp.widget.ListView.m mVar : FrsFragment.this.eYw.getThreadList()) {
                            if (mVar instanceof bf) {
                                i2++;
                                continue;
                            }
                            if (i2 >= 6) {
                                break;
                            }
                        }
                        if (i2 < 6) {
                            FrsFragment.this.aBd();
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

    public void iU(boolean z) {
        if (this.eZm != null) {
            this.eZm.fwu = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bR(List<String> list) {
        if (!com.baidu.tbadk.core.util.v.T(list)) {
            ArrayList<com.baidu.adp.widget.ListView.m> threadList = this.eYw.getThreadList();
            if (!com.baidu.tbadk.core.util.v.T(threadList) && this.eYT.getListView() != null && this.eYT.getListView().getData() != null) {
                Iterator<com.baidu.adp.widget.ListView.m> it = threadList.iterator();
                List<com.baidu.adp.widget.ListView.m> data = this.eYT.getListView().getData();
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.m next = it.next();
                    if (next instanceof bf) {
                        bg bgVar = ((bf) next).threadData;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= list.size()) {
                                break;
                            } else if (!com.baidu.tbadk.core.util.ap.equals(list.get(i2), bgVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(next);
                                this.eZw.e(next);
                                this.eYT.getListView().getAdapter().notifyItemRemoved(i);
                                break;
                            }
                        }
                    }
                    i++;
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void aBw() {
        if (isAdded() && this.ddg && !isLoadingViewAttached()) {
            showLoadingView(this.eYT.bdM(), true);
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void aBx() {
        if (isAdded() && this.ddg && isLoadingViewAttached()) {
            hideLoadingView(this.eYT.bdM());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (bcU()) {
            showLoadingView(this.eYT.bdM(), true);
            this.eYT.qf(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.eZk.y(3, true);
            afc().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void setHeaderViewHeight(int i) {
    }

    @Override // com.baidu.tieba.frs.ae
    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.x xVar) {
        if (xVar != null) {
            this.ctJ = xVar.aqm();
            this.eZD = xVar.aqn();
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void showFloatingView() {
        if (this.ctJ != null) {
            this.ctJ.fl(true);
        }
    }

    private void ac(Intent intent) {
        if (intent != null) {
            if (intent != null) {
                if (!com.baidu.tieba.frs.f.f.a(this, getForumName(), "from", intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false)) && getActivity() != null) {
                    getActivity().finish();
                    return;
                }
            }
            if (intent != null && intent.getData() != null) {
                Uri data = intent.getData();
                this.eYL = data.getQueryParameter("name");
                this.mFrom = data.getQueryParameter("from");
                if (!StringUtils.isNull(this.eYL)) {
                    intent.putExtra("name", this.eYL);
                }
                if (!StringUtils.isNull(this.mFrom)) {
                    intent.putExtra("from", this.mFrom);
                }
                TiebaStatic.log("c10105");
            }
            if (StringUtils.isNull(this.eYL) && intent != null && intent.getData() != null) {
                Uri data2 = intent.getData();
                if (com.baidu.tbadk.BdToken.f.m(data2)) {
                    com.baidu.tbadk.BdToken.f.Uk().b(data2, new f.a() { // from class: com.baidu.tieba.frs.FrsFragment.25
                        @Override // com.baidu.tbadk.BdToken.f.a
                        public void o(HashMap<String, Object> hashMap) {
                            if (hashMap != null && (hashMap.get(com.baidu.tbadk.BdToken.f.brH) instanceof String)) {
                                FrsFragment.this.eYL = (String) hashMap.get(com.baidu.tbadk.BdToken.f.brH);
                            }
                        }
                    });
                } else {
                    com.baidu.tieba.frs.f.d af = com.baidu.tieba.frs.f.i.af(intent);
                    if (af != null) {
                        this.eYL = af.forumName;
                        if (af.fuR == null || af.fuR.equals("aidou")) {
                        }
                    }
                }
                if (!StringUtils.isNull(this.eYL)) {
                    intent.putExtra("name", this.eYL);
                }
                intent.putExtra(FrsActivityConfig.FRS_CALL_FROM, 12);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.eYS = getVoiceManager();
        if (this.eYS != null) {
            this.eYS.onStart(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        Intent intent;
        registerListener(2001118, this.bZb);
        if (bundle != null) {
            this.eYL = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
            this.eYL = intent.getStringExtra("name");
            this.mFrom = intent.getStringExtra("from");
            this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
        }
        if (getArguments() != null) {
            this.eYM = getArguments().getBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, false);
        }
        if (TextUtils.isEmpty(this.mFrom) || FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
        }
        if (this.mIsLogin) {
            registerListener(2001120, this.bZb);
        }
        this.eZl.Q(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.q.c.cdr().t(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.far);
        eYX = null;
        if (this.eYS != null) {
            this.eYS.onDestory(getPageContext());
        }
        com.baidu.tieba.recapp.report.a.remove("FRS");
        this.eYS = null;
        t.aQG().hQ(false);
        if (this.eYw != null && this.eYw.getForum() != null) {
            aa.beq().cF(com.baidu.adp.lib.g.b.d(this.eYw.getForum().getId(), 0L));
        }
        if (this.eZz != null) {
            this.eZz.onDestory();
        }
        if (this.eYT != null) {
            com.baidu.tieba.frs.f.h.a(this.eYT, this.eYw, getForumId(), false, null);
            this.eYT.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.eZf != null) {
                this.eZf.apc();
            }
            this.eYT.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.eZl.onActivityDestroy();
        if (this.eZk != null) {
            this.eZk.aDG();
        }
        if (this.eZq != null) {
            this.eZq.aql();
        }
        if (this.eZt != null) {
            this.eZt.destory();
        }
        if (this.eZu != null) {
            this.eZu.destory();
        }
        if (this.eZo != null) {
            this.eZo.onDestroy();
        }
        if (this.eZG != null) {
            this.eZG.onDestory();
        }
        if (this.eZy != null) {
            this.eZy.onDestroy();
        }
        if (this.eZJ != null) {
            this.eZJ.onDestroy();
        }
        if (this.eZK != null) {
            this.eZK.onDestroy();
        }
        com.baidu.tieba.recapp.d.a.bXx().bXz();
        com.baidu.tieba.frs.f.j.biG();
        if (this.eZm != null) {
            this.eZm.a((FrsTabViewController.a) null);
            this.eZm.bjx();
        }
        if (this.eZM != null) {
            this.eZM.onDestroy();
        }
        com.baidu.tieba.frs.a.bbG().a(null);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.eYL);
        bundle.putString("from", this.mFrom);
        this.eZk.onSaveInstanceState(bundle);
        if (this.eYS != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            this.eYS.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.eZy != null) {
            this.eZy.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.eYT != null) {
            this.eYT.bdy();
            this.eYT.onResume();
        }
        this.eZn.jN(true);
        this.eZg = true;
        if (eYK) {
            eYK = false;
            this.eYT.startPullRefresh();
            return;
        }
        if (this.eYS != null) {
            this.eYS.onResume(getPageContext());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921338));
        this.eYT.ji(false);
        if (this.eZH) {
            refresh(6);
            this.eZH = false;
        }
        bda();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
    }

    public boolean bcH() {
        Intent intent;
        if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
            return false;
        }
        return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
    }

    public void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.eYL = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.eYN = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.eYN) {
                bcI();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcI() {
        this.eYT.startPullRefresh();
    }

    public void closeActivity() {
        com.baidu.tieba.frs.f.i.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.mFrom);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.eYT.setTitle(this.eYL);
        } else {
            this.eYT.setTitle("");
            this.mFlag = 1;
        }
        this.eYT.setOnAdapterItemClickListener(this.fap);
        this.eYT.addOnScrollListener(this.mScrollListener);
        this.eYT.h(this.eWE);
        this.eYT.bdL().a(this.fao);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.eZO) {
            this.eYT.onChangeSkinType(i);
            this.eZl.rv(i);
            this.eZm.onChangeSkinType(i);
            if (this.eYV != null) {
                this.eYV.onChangeSkinType(i);
            }
            if (this.eZE != null) {
                this.eZE.onChangeSkinType();
            }
            if (this.eZL != null) {
                this.eZL.onChangeSkinType(getPageContext(), i);
            }
            if (this.eks != null) {
                com.baidu.tbadk.r.a.a(getPageContext(), this.eks.aba());
            }
            if (this.eZF != null) {
                this.eZF.onChangeSkinType();
            }
        }
    }

    public void pW(int i) {
        if (!this.mIsLogin) {
            if (this.eYw != null && this.eYw.getAnti() != null) {
                this.eYw.getAnti().setIfpost(1);
            }
            if (i == 0) {
                bc.cY(getActivity());
            }
        } else if (this.eYw != null) {
            if (i == 0) {
                com.baidu.tieba.frs.f.j.d(this, 0);
            } else {
                this.eYT.bdA();
            }
        }
    }

    public void refresh() {
        com.baidu.tieba.a.d.awl().qM("page_frs");
        refresh(3);
    }

    public void refresh(int i) {
        this.eZd = false;
        bcN();
        if (this.eYT.bdp() != null) {
            this.eYT.bdp().bop();
        }
        this.eZk.y(i, true);
    }

    private void bcJ() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.g.h.jI().d(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.29
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.CJ(FrsFragment.this.eYL);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcK() {
        bcN();
        try {
            if (this.eYw != null) {
                this.eYT.aOB();
                this.eYT.ja(bcZ());
                if (!com.baidu.tieba.frs.vc.f.k(this.eYw) || !com.baidu.tieba.frs.vc.f.j(this.eYw)) {
                }
                if (this.eYw.getForum() != null) {
                    this.eYL = this.eYw.getForum().getName();
                    this.forumId = this.eYw.getForum().getId();
                }
                if (this.eYw.getPage() != null) {
                    setHasMore(this.eYw.getPage().XK());
                }
                this.eYT.setTitle(this.eYL);
                this.eYT.setForumName(this.eYL);
                TbadkCoreApplication.getInst().setDefaultBubble(this.eYw.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.eYw.getUserData().getBimg_end_time());
                bcJ();
                bcL();
                ArrayList<com.baidu.adp.widget.ListView.m> threadList = this.eYw.getThreadList();
                if (threadList != null) {
                    this.eYT.a(threadList, this.eYw);
                    com.baidu.tieba.frs.f.c.w(this.eYT);
                    this.eZl.rw(getPageNum());
                    this.eZl.h(this.eYw);
                    this.eZm.a(this.eYw, this.eZk.bhQ());
                    this.eYT.bdB();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void bcL() {
        if (this.eYw != null) {
            if (this.eYw.getIsNewUrl() == 1) {
                this.eYT.bdL().setFromCDN(true);
            } else {
                this.eYT.bdL().setFromCDN(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.eZn.jN(false);
        this.eZg = false;
        this.eYT.onPause();
        if (this.eYS != null) {
            this.eYS.onPause(getPageContext());
        }
        this.eYT.ji(true);
        if (this.eZu != null) {
            this.eZu.biJ();
        }
        com.baidu.tbadk.BdToken.c.TZ().Ua();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.eZm != null && this.eZm.bjv() != null && (this.eZm.bjv().fragment instanceof BaseFragment)) {
            ((BaseFragment) this.eZm.bjv().fragment).setPrimary(z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        t.aQG().hQ(false);
        iS(false);
        if (this.eYw != null && this.eYw.getForum() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            com.baidu.tbadk.distribute.a.alG().a(getPageContext().getPageActivity(), "frs", this.eYw.getForum().getId(), 0L);
        }
        if (this.eYS != null) {
            this.eYS.onStop(getPageContext());
        }
        if (afc() != null) {
            afc().getRecycledViewPool().clear();
        }
        this.eZl.onActivityStop();
        com.baidu.tbadk.util.y.aqp();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            if (this.eZl != null) {
                this.eZl.iY(isPrimary());
            }
            if (this.eYT != null) {
                this.eYT.iY(isPrimary());
                this.eYT.ji(!isPrimary());
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (com.baidu.tieba.frs.a.bbG().bbH()) {
                com.baidu.tieba.frs.a.bbG().reset();
                return true;
            } else if (this.eYT != null) {
                return this.eYT.bdx();
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
        com.baidu.tbadk.distribute.a.alG().a(advertAppInfo, this.forumId, 0L, "FRS", str, getPn());
    }

    @Override // com.baidu.tieba.recapp.n
    public void bcM() {
        bcq().bcM();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.eYS == null) {
            this.eYS = VoiceManager.instance();
        }
        return this.eYS;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdRecyclerView afc() {
        if (this.eYT == null) {
            return null;
        }
        return this.eYT.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void bcN() {
        if (this.eYS != null) {
            this.eYS.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> afd() {
        if (this.bTR == null) {
            this.bTR = UserIconBox.q(getPageContext().getPageActivity(), 8);
        }
        return this.bTR;
    }

    public void bcO() {
        if (getFragmentActivity() != null && getFragmentActivity().getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.b(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.p onGetPreLoadListView() {
        return afc().getPreLoadHandle();
    }

    @Override // com.baidu.tieba.frs.ah
    public NavigationBar aDq() {
        if (this.eYT == null) {
            return null;
        }
        return this.eYT.aDq();
    }

    public FRSRefreshButton bcP() {
        return this.eYV;
    }

    public void a(FRSRefreshButton fRSRefreshButton) {
        if (fRSRefreshButton != null) {
            this.eYV = fRSRefreshButton;
            this.eYV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.36
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (FrsFragment.this.eZm != null) {
                        FrsTabViewController.b bjv = FrsFragment.this.eZm.bjv();
                        if (bjv != null && bjv.fragment != null && (bjv.fragment instanceof ag)) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                            ((ag) bjv.fragment).bce();
                            ((ag) bjv.fragment).aCu();
                            return;
                        }
                        FrsFragment.this.bcv().startPullRefresh();
                    }
                }
            });
        }
    }

    public void bcQ() {
        if (this.eYV != null && this.eYW) {
            if (this.eZP != null) {
                this.eZP.cancel();
            }
            this.eZP = new AlphaAnimation(1.0f, 0.0f);
            this.eZP.setDuration(300L);
            this.eZP.setFillAfter(true);
            this.eYV.startAnimation(this.eZP);
            this.eYW = false;
        }
    }

    public void bcR() {
        if (this.eYV != null && !this.eYW && this.eZm.bjy() != 0) {
            this.eYV.setVisibility(0);
            if (this.eZQ != null) {
                this.eZQ.cancel();
            }
            this.eZQ = new AlphaAnimation(0.0f, 1.0f);
            this.eZQ.setDuration(300L);
            this.eZQ.setFillAfter(true);
            this.eYV.startAnimation(this.eZQ);
            this.eYW = true;
        }
    }

    /* loaded from: classes4.dex */
    private final class a implements s {
        private a() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.s
        public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null) {
                if (bdUniqueId == p.fbZ) {
                    if (FrsFragment.this.eYT != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11752").bJ(ImageViewerConfig.FORUM_ID, FrsFragment.this.forumId).bJ("obj_locate", "1"));
                        FrsFragment.this.eYT.startPullRefresh();
                    }
                } else if (mVar != null && (mVar instanceof bf)) {
                    bg bgVar = ((bf) mVar).threadData;
                    if (bgVar.ZJ() == null || bgVar.ZJ().getGroup_id() == 0 || bc.cZ(FrsFragment.this.getActivity())) {
                        if (bgVar.ZB() != 1 || bc.cZ(FrsFragment.this.getActivity())) {
                            if (bgVar.Ze() != null) {
                                if (bc.cZ(FrsFragment.this.getActivity())) {
                                    String postUrl = bgVar.Ze().getPostUrl();
                                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.lo()) {
                                        com.baidu.tbadk.browser.a.as(FrsFragment.this.getActivity(), postUrl);
                                    }
                                }
                            } else if (bgVar.ZU() != null) {
                                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                    bc.cY(FrsFragment.this.getPageContext().getPageActivity());
                                    return;
                                }
                                com.baidu.tbadk.core.data.o ZU = bgVar.ZU();
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), ZU.getCartoonId(), ZU.getChapterId(), 2)));
                            } else {
                                com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                                if (readThreadHistory != null && !readThreadHistory.CP(bgVar.getId())) {
                                    readThreadHistory.CO(bgVar.getId());
                                }
                                boolean z = false;
                                final String YY = bgVar.YY();
                                if (YY != null && !YY.equals("")) {
                                    z = true;
                                    new Thread(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.a.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(YY);
                                            xVar.acH().adF().mIsNeedAddCommenParam = false;
                                            xVar.acH().adF().mIsUseCurrentBDUSS = false;
                                            xVar.ack();
                                        }
                                    }).start();
                                }
                                String tid = bgVar.getTid();
                                if (tid == null) {
                                    tid = "";
                                }
                                if (bgVar.YM() == 2 && !tid.startsWith("pb:")) {
                                    ba.adD().c(FrsFragment.this.getPageContext(), new String[]{tid, "", null});
                                    return;
                                }
                                if (tid.startsWith("pb:")) {
                                    bgVar.setId(tid.substring(3));
                                }
                                if (bdUniqueId.getId() == bg.bCy.getId()) {
                                    com.baidu.tieba.frs.f.h.a(bgVar.Yx());
                                } else if (bdUniqueId.getId() == bg.bBf.getId()) {
                                    com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c12940");
                                    amVar.bJ("obj_type", "2");
                                    amVar.bJ("tid", bgVar.getTid());
                                    TiebaStatic.log(amVar);
                                }
                                com.baidu.tieba.frs.f.i.a(FrsFragment.this, bgVar, i, z);
                                com.baidu.tieba.frs.f.h.a(FrsFragment.this, FrsFragment.this.eYw, bgVar);
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
            hideNetRefreshView(this.eYT.bdM());
            showLoadingView(this.eYT.bdM(), true);
            this.eYT.jd(false);
            this.eZk.y(3, true);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData bcS() {
        return this.eYw;
    }

    public boolean bcT() {
        return this.eYT.bcT();
    }

    public void at(Object obj) {
        if (this.eZp != null && this.eZp.fqQ != null) {
            this.eZp.fqQ.m(obj);
        }
    }

    public void au(Object obj) {
        if (this.eZp != null && this.eZp.fqR != null) {
            this.eZp.fqR.m(obj);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        this.eYT.getListView().stopScroll();
        if (!this.eYT.bdH()) {
            if (!com.baidu.adp.lib.util.l.lo()) {
                this.eYT.aCx();
            } else if (this.eZk.bhL() == 1) {
                aBr();
                aBd();
            } else if (this.eZk.hasMore()) {
                aBd();
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void uH(String str) {
        aBr();
        showToast(str);
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void R(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        boolean T = com.baidu.tbadk.core.util.v.T(arrayList);
        setHasMore(T ? 0 : 1);
        aBr();
        if (!T) {
            if (!this.eZk.bhU() && TbadkCoreApplication.getInst().isRecAppExist() && this.eZk.bhL() == 1) {
                this.eYw.addRecommendAppToThreadList(this, arrayList);
            }
            if (this.eZk != null) {
                com.baidu.tieba.frs.d.a.a(getUniqueId(), arrayList, this.eYw.getForum(), this.eZk.getSortType());
            }
            ArrayList<com.baidu.adp.widget.ListView.m> a2 = this.eZw.a(false, false, arrayList, this.eYP, false);
            if (a2 != null) {
                this.eYw.setThreadList(a2);
                this.eYT.a(a2, this.eYw);
            }
            if (this.eZk != null) {
                com.baidu.tieba.frs.d.c.a(this.eYw, this.eZk.bhQ(), 2);
            }
        }
    }

    private void aBr() {
        if (bcw() == 1 || this.eZw.cd(this.eYw.getThreadListIds())) {
            if (com.baidu.tbadk.core.util.v.S(this.eYw.getThreadList()) > 3) {
                this.eYT.aCv();
            } else {
                this.eYT.bdP();
            }
        } else if (com.baidu.tbadk.core.util.v.T(this.eYw.getThreadList())) {
            this.eYT.aCx();
        } else {
            this.eYT.aCw();
        }
    }

    @Override // com.baidu.tieba.frs.mc.l
    public void aBd() {
        if (this.eZw != null) {
            this.eZw.a(this.eYL, this.forumId, this.eYw);
        }
    }

    public void takePhoto() {
        if (!com.baidu.tbadk.core.util.ab.e(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.ak.c(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        if (this.eZc) {
            return null;
        }
        if (bcU()) {
            return "a034";
        }
        return "a006";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (!bcU()) {
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

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.d(getForumId(), 0L));
        }
        return pageStayDurationItem;
    }

    @Override // android.support.v4.app.Fragment, com.baidu.e.a.a.InterfaceC0040a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        com.baidu.tieba.frs.f.i.a(this, i, strArr, iArr);
    }

    public void iV(boolean z) {
        if (this.eZq != null) {
            this.eZq.js(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.eZr.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a lj(int i) {
        return this.eZr.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        this.eZA.b(bVar);
    }

    public boolean bcU() {
        return this.eYH;
    }

    @Override // com.baidu.tieba.frs.ae
    public void aBv() {
        if (this.eYT != null) {
            showFloatingView();
            this.eYT.getListView().scrollToPosition(0);
            this.eYT.startPullRefresh();
        }
    }

    public ForumWriteData bcV() {
        if (this.eYw == null || this.eYw.getForum() == null) {
            return null;
        }
        ForumData forum = this.eYw.getForum();
        ForumWriteData forumWriteData = new ForumWriteData(forum.getId(), forum.getName(), forum.getPrefixData(), this.eYw.getAnti());
        forumWriteData.avatar = forum.getImage_url();
        forumWriteData.forumLevel = forum.getUser_level();
        forumWriteData.specialForumType = forum.special_forum_type;
        forumWriteData.firstDir = forum.getFirst_class();
        forumWriteData.secondDir = forum.getSecond_class();
        UserData userData = this.eYw.getUserData();
        forumWriteData.privateThread = userData != null ? userData.getPrivateThread() : 0;
        return forumWriteData;
    }

    @Override // com.baidu.tieba.frs.ae
    public void aeK() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.frs.ae
    public void setVideoThreadId(String str) {
    }

    public void iW(boolean z) {
        this.eZh = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z) {
        super.showLoadingView(view, z);
        this.eYT.qc(8);
        ((FrsActivity) getActivity()).i(view, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        super.hideLoadingView(view);
        this.eYT.qc(0);
        ((FrsActivity) getActivity()).i(view, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        super.showNetRefreshView(view, str, z);
        this.eYT.qc(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshViewNoClick(View view, String str, boolean z) {
        super.showNetRefreshViewNoClick(view, str, z);
        this.eYT.qc(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        super.hideNetRefreshView(view);
        this.eYT.qc(0);
    }

    public void bcW() {
        FrsTabViewController.b bjv;
        if (this.eZm != null && (bjv = this.eZm.bjv()) != null && bjv.fragment != null && (bjv.fragment instanceof ag)) {
            ((ag) bjv.fragment).bce();
        }
    }

    public void iX(boolean z) {
        this.eYJ = z;
    }

    public void b(OvalActionButton ovalActionButton) {
        this.eYU = ovalActionButton;
    }

    public OvalActionButton bcX() {
        return this.eYU;
    }

    public boolean bcY() {
        return this.eYJ;
    }

    public void uZ(String str) {
        if (TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.util.ap.isEmpty(str)) {
            if (this.eZM == null) {
                this.eZM = new AddExperiencedModel(getTbPageContext());
                this.eZM.a(this.eZR);
            }
            this.eZM.dP(this.forumId, str);
        }
    }

    public boolean bcZ() {
        if (this.eZh) {
            return (this.eZk != null && this.eZk.bhM() && com.baidu.tieba.frs.a.bbG().bbH()) ? false : true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.e.c
    public boolean videoNeedPreload() {
        if (this.eYw != null) {
            return com.baidu.tbadk.util.ad.aqw() && (this.eYw.isFrsVideoAutoPlay || com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("auto_play_video_frs", 0) == 1);
        }
        return super.videoNeedPreload();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bda() {
        if (!com.baidu.tbadk.core.util.ap.isEmpty(this.forumId)) {
            com.baidu.tbadk.BdToken.c.TZ().g(com.baidu.tbadk.BdToken.b.bqD, com.baidu.adp.lib.g.b.d(this.forumId, 0L));
        }
    }
}
