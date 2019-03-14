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
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsPage.RecmForumInfo;
import tbclient.WindowToast;
/* loaded from: classes4.dex */
public class FrsFragment extends BaseFragment implements BdListView.e, a.InterfaceC0042a, UserIconBox.b<BdRecyclerView>, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, ae, ah, aj, com.baidu.tieba.frs.loadmore.a, com.baidu.tieba.frs.mc.l, com.baidu.tieba.recapp.n {
    public static com.baidu.tieba.tbadkCore.j eYW;
    private com.baidu.adp.lib.e.b<TbImageView> bTS;
    private com.baidu.tbadk.util.w ctG;
    private com.baidu.tieba.frs.gametab.b don;
    private com.baidu.tieba.frs.entelechy.a eYE;
    private com.baidu.tieba.tbadkCore.data.f eYO;
    private VoiceManager eYR;
    private OvalActionButton eYT;
    private FRSRefreshButton eYU;
    public com.baidu.tieba.frs.vc.c eZA;
    private com.baidu.tieba.frs.mc.e eZB;
    private View.OnTouchListener eZC;
    private com.baidu.tieba.frs.view.a eZD;
    private com.baidu.tieba.frs.view.c eZE;
    private com.baidu.tieba.frs.vc.e eZF;
    private boolean eZG;
    private com.baidu.tieba.NEGFeedBack.a eZI;
    private com.baidu.tieba.ala.a eZJ;
    private com.baidu.tieba.frs.brand.buttommenu.a eZK;
    private AddExperiencedModel eZL;
    private boolean eZN;
    private int eZX;
    private com.baidu.card.z eZi;
    private FrsModelController eZj;
    private com.baidu.tieba.frs.vc.f eZk;
    private FrsTabViewController eZl;
    private com.baidu.tieba.frs.mc.h eZm;
    private com.baidu.tieba.frs.smartsort.b eZn;
    private com.baidu.tieba.frs.mc.b eZo;
    private ak eZp;
    private com.baidu.tieba.frs.entelechy.b.b eZr;
    private com.baidu.tbadk.k.a eZs;
    private com.baidu.tieba.frs.vc.a eZt;
    private com.baidu.tieba.frs.mc.d eZu;
    private com.baidu.tieba.frs.mc.c eZv;
    private com.baidu.tieba.frs.vc.h eZw;
    private com.baidu.tieba.frs.mc.a eZx;
    private com.baidu.tieba.frs.live.a eZy;
    private j eZz;
    private com.baidu.tbadk.core.dialog.a eko;
    private View mRootView;
    public static boolean eYJ = false;
    public static volatile long eYY = 0;
    public static volatile long eYZ = 0;
    public static volatile int eZa = 0;
    public boolean eYF = false;
    private boolean eYG = false;
    private boolean eYH = false;
    private boolean eYI = true;
    public String eYK = null;
    public String mFrom = null;
    public int mFlag = 0;
    public boolean eYL = false;
    private boolean eYM = false;
    private String mThreadId = null;
    public String forumId = null;
    private int eYx = 0;
    private boolean eYN = false;
    private boolean eYP = false;
    private boolean eYQ = false;
    private k eYS = null;
    private boolean eYV = false;
    public final bg bTl = null;
    private FrsViewData eYv = new FrsViewData();
    public long eCL = -1;
    public long cqv = 0;
    public long cqn = 0;
    public long createTime = 0;
    public long beginTime = -1;
    public long eYX = 0;
    public boolean eZb = false;
    private boolean eZc = false;
    private boolean eZd = false;
    public com.baidu.tbadk.o.b eZe = null;
    private boolean eZf = true;
    private boolean eZg = true;
    private a.C0039a eZh = new a.C0039a(2);
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> eZq = new SparseArray<>();
    private boolean ddc = true;
    private boolean eZH = false;
    private boolean hasInit = false;
    private boolean eZM = false;
    private AlphaAnimation eZO = null;
    private AlphaAnimation eZP = null;
    private AddExperiencedModel.a eZQ = new AddExperiencedModel.a() { // from class: com.baidu.tieba.frs.FrsFragment.1
        @Override // com.baidu.tieba.share.AddExperiencedModel.a
        public void a(ContriInfo contriInfo) {
        }
    };
    private HttpMessageListener eZR = new HttpMessageListener(CmdConfigHttp.CMD_PB_FLOOR_AGREE, true) { // from class: com.baidu.tieba.frs.FrsFragment.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof PbFloorAgreeResponseMessage)) {
                PbFloorAgreeResponseMessage pbFloorAgreeResponseMessage = (PbFloorAgreeResponseMessage) httpResponsedMessage;
            }
        }
    };
    private final CustomMessageListener eZS = new CustomMessageListener(2016495) { // from class: com.baidu.tieba.frs.FrsFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof bg) {
                    com.baidu.tieba.frs.f.h.a(FrsFragment.this.eYS, FrsFragment.this.eYv, FrsFragment.this.getForumId(), true, (bg) data);
                }
            }
        }
    };
    private CustomMessageListener eZT = new CustomMessageListener(2921005) { // from class: com.baidu.tieba.frs.FrsFragment.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.eYv != null) {
                FrsFragment.this.eYv.removeGameRankListFromThreadList();
                if (FrsFragment.this.eYS != null) {
                    FrsFragment.this.eYS.Ru();
                }
            }
        }
    };
    private CustomMessageListener XW = new CustomMessageListener(2921401) { // from class: com.baidu.tieba.frs.FrsFragment.40
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && FrsFragment.this.eYU != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() <= 0 || FrsFragment.this.eZl.bjx() == 0) {
                    if (FrsFragment.this.eZl.bjx() != 0) {
                        FrsFragment.this.bcP();
                        return;
                    }
                    return;
                }
                FrsFragment.this.bcQ();
            }
        }
    };
    private CustomMessageListener eZU = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.FrsFragment.41
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 1) {
                    FrsFragment.this.bcH();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                }
            }
        }
    };
    private final ai eZV = new ai() { // from class: com.baidu.tieba.frs.FrsFragment.42
        @Override // com.baidu.tieba.frs.ai
        public void a(int i, int i2, ap apVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
            FrsFragment.this.bcx();
            if (FrsFragment.this.eZr != null) {
                FrsFragment.this.eZk.jP(FrsFragment.this.eZr.qz(i));
            }
            e.b bVar = new e.b();
            if (apVar != null) {
                bVar.isSuccess = apVar.errCode == 0;
                bVar.errorCode = apVar.errCode;
                bVar.errorMsg = apVar.errMsg;
                if (bVar.isSuccess) {
                    if (com.baidu.tbadk.core.util.v.T(arrayList)) {
                        FrsFragment.this.eYS.aCw();
                    } else if (apVar.hasMore) {
                        if (com.baidu.tbadk.core.util.v.S(FrsFragment.this.eYv.getThreadList()) > 3) {
                            FrsFragment.this.eYS.aCu();
                        } else {
                            FrsFragment.this.eYS.bdO();
                        }
                    } else if (apVar.fdd) {
                        FrsFragment.this.eYS.aCv();
                    } else {
                        FrsFragment.this.eYS.aCw();
                    }
                }
            } else {
                apVar = new ap();
                apVar.pn = 1;
                apVar.hasMore = false;
                apVar.fdd = false;
            }
            if (i == 1) {
                FrsFragment.this.eZf = true;
                FrsFragment.this.fai.a(FrsFragment.this.eZj.getType(), false, bVar);
            } else {
                FrsFragment.this.a(bVar);
                if (FrsFragment.this.eZj.bho() != null) {
                    FrsFragment.this.eYv = FrsFragment.this.eZj.bho();
                }
                FrsFragment.this.bcJ();
            }
            if (FrsFragment.this.fap != null) {
                FrsFragment.this.fap.a(i, i2, apVar, arrayList);
            }
        }
    };
    private FrsTabViewController.a eZW = new FrsTabViewController.a() { // from class: com.baidu.tieba.frs.FrsFragment.43
        @Override // com.baidu.tieba.frs.vc.FrsTabViewController.a
        public void jH(int i) {
            boolean z = false;
            if (i != 1) {
                com.baidu.tieba.card.t.aQF().hQ(false);
                FrsFragment.this.iS(false);
            }
            if (i == 303 && i != FrsFragment.this.eZX) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13121").bJ(ImageViewerConfig.FORUM_ID, FrsFragment.this.forumId).bJ("uid", TbadkCoreApplication.getCurrentAccount()));
            }
            if (i == 502) {
                FrsFragment.this.eYT.setIconFade(d.f.btn_frs_professional_edit_n);
            } else {
                FrsFragment.this.eYT.setIconFade(0);
            }
            FrsFragment.this.eZX = i;
            FrsFragment.this.bcM();
            com.baidu.tieba.frs.d.d.fhe.ftd = i;
            com.baidu.tieba.frs.d.d.fhe.fte = -1;
            com.baidu.tieba.frs.a bbF = com.baidu.tieba.frs.a.bbF();
            if (i == 1 && FrsFragment.this.eZM) {
                z = true;
            }
            bbF.B(z, true);
        }
    };
    private CustomMessageListener eZY = new CustomMessageListener(2001606) { // from class: com.baidu.tieba.frs.FrsFragment.44
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                FrsFragment.this.eZl.rE(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    };
    private CustomMessageListener eZZ = new CustomMessageListener(2001607) { // from class: com.baidu.tieba.frs.FrsFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && ((Integer) customResponsedMessage.getData()).intValue() == 51 && FrsFragment.this.eYv != null) {
                com.baidu.tieba.frs.f.j.a(FrsFragment.this.eYv, FrsFragment.this.getPageContext());
            }
        }
    };
    private final CustomMessageListener faa = new CustomMessageListener(2003019) { // from class: com.baidu.tieba.frs.FrsFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                FrsFragment.this.eZl.rC(49);
            }
        }
    };
    private final CustomMessageListener fab = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.frs.FrsFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && FrsFragment.this.eYv != null && FrsFragment.this.eYv.getForum() != null) {
                SignData signData = (SignData) customResponsedMessage.getData();
                int user_level = FrsFragment.this.eYv.getForum().getUser_level();
                if (signData.forumId != null && signData.forumId.equals(FrsFragment.this.eYv.getForum().getId())) {
                    FrsFragment.this.eYv.updateSignData(signData);
                    FrsFragment.this.eZk.i(FrsFragment.this.eYv);
                    if (FrsFragment.this.eZk.bji()) {
                        i = FrsFragment.this.eYv.getForum().getUser_level();
                        if (user_level >= i) {
                            i++;
                        }
                    } else {
                        i = user_level;
                    }
                    TbadkCoreApplication.getInst().addSignedForum(FrsFragment.this.eYv.getForum().getName(), signData.sign_bonus_point, i);
                }
            }
        }
    };
    private final CustomMessageListener fac = new CustomMessageListener(2001352) { // from class: com.baidu.tieba.frs.FrsFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.r) && FrsFragment.this.eYv != null) {
                FrsFragment.this.eYv.updateLikeData((com.baidu.tieba.tbadkCore.r) customResponsedMessage.getData());
                FrsFragment.this.eZk.h(FrsFragment.this.eYv);
                FrsFragment.this.eZl.a(FrsFragment.this.eYv, FrsFragment.this.eZj.bhP());
            }
        }
    };
    private final AntiHelper.a fad = new AntiHelper.a() { // from class: com.baidu.tieba.frs.FrsFragment.6
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12536").T("obj_locate", at.a.bLn));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12535").T("obj_locate", at.a.bLn));
        }
    };
    private CustomMessageListener ddn = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.frs.FrsFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(FrsFragment.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().bYz != null) {
                        if (AntiHelper.a(FrsFragment.this.getActivity(), updateAttentionMessage.getData().bYz, FrsFragment.this.fad) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12534").T("obj_locate", at.a.bLn));
                        }
                    } else if (updateAttentionMessage.getData().Jy && updateAttentionMessage.getData().isAttention) {
                        com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getPageContext().getPageActivity(), d.j.attention_success);
                    }
                }
            }
        }
    };
    private CustomMessageListener fae = new CustomMessageListener(2921346) { // from class: com.baidu.tieba.frs.FrsFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsFragment.this.refresh();
        }
    };
    private CustomMessageListener faf = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.frs.FrsFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                FrsFragment.this.eYS.c((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener fag = new CustomMessageListener(2001626) { // from class: com.baidu.tieba.frs.FrsFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewsRemindMessage newsRemindMessage;
            if (customResponsedMessage != null && (customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626 && (newsRemindMessage = (NewsRemindMessage) customResponsedMessage) != null) {
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (FrsFragment.this.eYS != null) {
                    FrsFragment.this.eYS.w(notificationCount, z);
                }
            }
        }
    };
    private final CustomMessageListener brp = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.frs.FrsFragment.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.isResumed()) {
                FrsFragment.this.bcZ();
            }
        }
    };
    private CustomMessageListener fah = new CustomMessageListener(2003020) { // from class: com.baidu.tieba.frs.FrsFragment.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (FrsFragment.this.eYS != null) {
                    FrsFragment.this.eYS.setExpanded(booleanValue);
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.n fai = new com.baidu.tieba.tbadkCore.n() { // from class: com.baidu.tieba.frs.FrsFragment.14
        private long startTime = 0;

        @Override // com.baidu.tieba.tbadkCore.n
        public void pX(int i) {
            this.startTime = System.nanoTime();
            if (FrsFragment.this.eYS != null) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsFragment.this.eYS.bdx();
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
            if (FrsFragment.this.ddc) {
                FrsFragment.this.ddc = false;
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.eYS, FrsFragment.this.eYv, FrsFragment.this.getForumId(), false, null);
            }
            FrsFragment.this.bcx();
            FrsFragment.this.eZc = true;
            if (bVar != null && bVar.isSuccess) {
                FrsFragment.this.eYS.bdK().jC(com.baidu.tbadk.core.util.ar.adp().adr());
                FrsFragment.eYY = 0L;
                FrsFragment.eYZ = 0L;
                FrsFragment.eZa = 0;
            } else {
                FrsFragment.eZa = 1;
            }
            if (!FrsFragment.this.eZj.bhT() && (i == 3 || i == 6)) {
                FrsFragment.this.eZv.resetData();
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (FrsFragment.this.eZj.bho() != null) {
                FrsFragment.this.eYv = FrsFragment.this.eZj.bho();
            }
            FrsFragment.this.eYS.b(FrsFragment.this.eYv.getRedpacketRainData());
            FrsFragment.this.pU(1);
            if (i == 7) {
                FrsFragment.this.pV(FrsFragment.this.eYv.getFrsDefaultTabId());
                return;
            }
            if (FrsFragment.this.eYv.getPage() != null) {
                FrsFragment.this.setHasMore(FrsFragment.this.eYv.getPage().XK());
            }
            if (i == 4) {
                if (!FrsFragment.this.eZj.bhT() && TbadkCoreApplication.getInst().isRecAppExist() && FrsFragment.this.eZj.bhK() == 1) {
                    FrsFragment.this.eYv.addRecommendAppToThreadList(FrsFragment.this);
                }
                ArrayList<com.baidu.adp.widget.ListView.m> a2 = FrsFragment.this.eZv.a(false, false, FrsFragment.this.eYv.getThreadList(), FrsFragment.this.eYO, false);
                if (a2 != null) {
                    FrsFragment.this.eYv.setThreadList(a2);
                    FrsFragment.this.eYv.updateInterviewTaskInfoDataInThreadList();
                }
                if (FrsFragment.this.eZj != null) {
                    com.baidu.tieba.frs.d.c.a(FrsFragment.this.eYv, FrsFragment.this.eZj.bhP(), 2);
                }
                com.baidu.tieba.frs.f.a.a(FrsFragment.this, FrsFragment.this.eYv.getForum(), FrsFragment.this.eYv.getThreadList(), false, FrsFragment.this.getPn());
                FrsFragment.this.cqv = System.currentTimeMillis() - currentTimeMillis;
                FrsFragment.this.eYS.a(a2, FrsFragment.this.eYv);
                FrsFragment.this.bcy();
                return;
            }
            FrsFragment.this.bcy();
            switch (i) {
                case 1:
                    FrsFragment.this.eYS.bdx();
                    break;
                case 2:
                    FrsFragment.this.eYS.bdx();
                    break;
                case 3:
                case 6:
                    if (FrsFragment.this.eYv != null) {
                        FrsFragment.this.eYv.clearPostThreadCount();
                    }
                    if (FrsFragment.this.eZA != null) {
                        FrsFragment.this.eZA.refresh();
                        break;
                    }
                    break;
            }
            FrsFragment.this.bcC();
            if (bVar == null || bVar.errorCode == 0) {
                if (FrsFragment.this.eYv != null) {
                    FrsFragment.this.E(false, i == 5);
                    if (FrsFragment.this.eZj != null) {
                        com.baidu.tieba.frs.d.a.a(FrsFragment.this.getUniqueId(), FrsFragment.this.eYv.getThreadList(), FrsFragment.this.eYv.getForum(), FrsFragment.this.eZj.getSortType());
                    }
                    FrsFragment.this.eYS.qg(i);
                    FrsFragment.eYY = (System.nanoTime() - this.startTime) / 1000000;
                    if (bVar != null) {
                        FrsFragment.eYZ = bVar.iDR;
                    }
                } else {
                    return;
                }
            } else if (FrsFragment.this.eYv == null || com.baidu.tbadk.core.util.v.T(FrsFragment.this.eYv.getThreadList())) {
                FrsFragment.this.a(bVar);
            } else if (bVar.iDQ) {
                FrsFragment.this.showToast(FrsFragment.this.getPageContext().getResources().getString(d.j.net_error_text, bVar.errorMsg, Integer.valueOf(bVar.errorCode)));
            }
            FrsFragment.this.bcz();
            FrsFragment.this.bcA();
            if (FrsFragment.this.eYv.getAccessFlag() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11384"));
            }
            if (FrsFragment.this.eCL > -1 && !FrsFragment.this.eZH) {
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.eZj, FrsFragment.this.eCL);
                FrsFragment.this.eCL = -1L;
                FrsFragment.this.eZH = true;
            }
            if (FrsFragment.this.eYP && FrsFragment.this.eZl.rC(49)) {
                FrsFragment.this.eYP = false;
            }
            FrsFragment.this.cqv = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void b(com.baidu.tieba.tbadkCore.j jVar) {
            if ((jVar != null && ("normal_page".equals(FrsFragment.this.eZj.getPageType()) || "frs_page".equals(FrsFragment.this.eZj.getPageType()) || "book_page".equals(FrsFragment.this.eZj.getPageType()))) || "brand_page".equals(FrsFragment.this.eZj.getPageType())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001615, jVar));
                FrsFragment.this.a(jVar);
                FrsFragment.eYW = jVar;
            }
        }
    };
    private final CustomMessageListener faj = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.frs.FrsFragment.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                FrsFragment.this.eYv.updateCurrentUserPendant((com.baidu.tbadk.data.l) customResponsedMessage.getData());
                FrsFragment.this.eYS.bdK().notifyDataSetChanged();
            }
        }
    };
    private final CustomMessageListener mMemListener = new CustomMessageListener(2001194) { // from class: com.baidu.tieba.frs.FrsFragment.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && FrsFragment.this.eYv != null && (userData = FrsFragment.this.eYv.getUserData()) != null) {
                userData.setIsMem(num.intValue());
                if (num.intValue() != 0) {
                    FrsFragment.this.eZk.h(num);
                }
            }
        }
    };
    private final com.baidu.tieba.frs.mc.k fak = new com.baidu.tieba.frs.mc.k() { // from class: com.baidu.tieba.frs.FrsFragment.26
        @Override // com.baidu.tieba.frs.mc.k
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.m> arrayList, boolean z3) {
            if (FrsFragment.this.eZn != null && FrsFragment.this.eZj != null && FrsFragment.this.eZj.bhT() && z && !z2 && !z3) {
                FrsFragment.this.eZn.rf(i2);
            }
        }
    };
    public final View.OnTouchListener ccU = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.FrsFragment.27
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (FrsFragment.this.eZC != null) {
                FrsFragment.this.eZC.onTouch(view, motionEvent);
            }
            if (FrsFragment.this.eZp != null && FrsFragment.this.eZp.bes() != null) {
                FrsFragment.this.eZp.bes().onTouchEvent(motionEvent);
            }
            if (FrsFragment.this.don != null) {
                FrsFragment.this.don.f(view, motionEvent);
            }
            if (FrsFragment.this.eZk != null) {
                FrsFragment.this.eZk.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private final CustomMessageListener fal = new CustomMessageListener(2004507) { // from class: com.baidu.tieba.frs.FrsFragment.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "photolive_hostLevel", -1) != -1 && FrsFragment.this.eYv.getForum() != null) {
                FrsFragment.this.eYv.getForum().setCanAddPhotoLivePost(true);
            }
        }
    };
    public final View.OnClickListener fam = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.30
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsFragment.this.eYS == null || view != FrsFragment.this.eYS.bdv() || FrsFragment.this.getActivity() == null) {
                if (FrsFragment.this.eYv == null || FrsFragment.this.eYv.getForum() == null || FrsFragment.this.eYS == null || view != FrsFragment.this.eYS.bdB()) {
                    if (FrsFragment.this.eYv != null && FrsFragment.this.eYv.getForum() != null && FrsFragment.this.eYS != null && view == FrsFragment.this.eYS.bdC()) {
                        if (FrsFragment.this.eZE == null) {
                            FrsFragment.this.eZE = new com.baidu.tieba.frs.view.c(FrsFragment.this.getPageContext());
                        }
                        FrsFragment.this.eZE.l(FrsFragment.this.eYv);
                        FrsFragment.this.eZE.showDialog();
                        return;
                    }
                    if (view.getId() == d.g.game_activity_egg_layout && com.baidu.adp.lib.util.l.lo()) {
                        TiebaStatic.log("c10853");
                        if (FrsFragment.this.eYS.bdH()) {
                            FrsFragment.this.eYS.bdI();
                        } else {
                            String activityUrl = FrsFragment.this.eYv.getForum().getYuleData().aaT().getActivityUrl();
                            if (!StringUtils.isNull(activityUrl)) {
                                com.baidu.tbadk.browser.a.as(FrsFragment.this.getPageContext().getPageActivity(), activityUrl);
                            }
                        }
                    }
                    if (view == FrsFragment.this.eYS.bdP() && FrsFragment.this.eZj != null && FrsFragment.this.eZj.hasMore()) {
                        FrsFragment.this.eYS.aCu();
                        FrsFragment.this.aBc();
                    }
                    if (view != null && view == FrsFragment.this.eYS.bdE() && bc.cZ(FrsFragment.this.getContext())) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12924").T("obj_locate", 2));
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(FrsFragment.this.getContext())));
                        return;
                    }
                    return;
                }
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12402").bJ(ImageViewerConfig.FORUM_ID, FrsFragment.this.eYv.getForum().getId()).bJ("uid", TbadkCoreApplication.getCurrentAccount()).bJ(ImageViewerConfig.FORUM_NAME, FrsFragment.this.eYv.getForum().getName()));
                if (!StringUtils.isNull(FrsFragment.this.eYv.getForum().getName())) {
                    FrsFragment.this.sendMessage(new CustomMessage(2002001, new PostSearchActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), FrsFragment.this.eYv.getForum().getName(), FrsFragment.this.eYv.getForum().getId())));
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
        private int fax = 0;
        private int cZR = 0;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (FrsFragment.this.eZt != null) {
                FrsFragment.this.eZt.biI();
            }
            this.fax = 0;
            this.cZR = 0;
            if (recyclerView != null && (recyclerView instanceof BdRecyclerView)) {
                this.fax = ((BdRecyclerView) recyclerView).getFirstVisiblePosition();
                this.cZR = ((BdRecyclerView) recyclerView).getLastVisiblePosition();
            }
            if (FrsFragment.this.eZF != null) {
                FrsFragment.this.eZF.a(recyclerView, this.fax, this.cZR);
            }
            if (FrsFragment.this.eYv != null && FrsFragment.this.eYS != null && FrsFragment.this.eYS.bdK() != null) {
                FrsFragment.this.eYS.bh(this.fax, this.cZR);
                if (FrsFragment.this.eZi != null && FrsFragment.this.eZi.rx() != null) {
                    FrsFragment.this.eZi.rx().b(FrsFragment.this.eZh);
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (FrsFragment.this.eZk != null) {
                FrsFragment.this.eZk.setScrollState(i);
            }
            if (i == 0) {
                FrsFragment.this.eYS.bdT();
            }
            if ((i == 2 || i == 1) && !FrsFragment.this.eZd) {
                FrsFragment.this.eZd = true;
                FrsFragment.this.eYS.bdN();
            }
            if (FrsFragment.this.eZe == null && !FrsFragment.this.bcT()) {
                FrsFragment.this.eZe = new com.baidu.tbadk.o.b();
                FrsFragment.this.eZe.jX(1000);
            }
            if (i == 0) {
                if (FrsFragment.this.eZe != null) {
                    FrsFragment.this.eZe.apa();
                }
                com.baidu.tieba.card.t.aQF().hQ(true);
                FrsFragment.this.iS(true);
                FrsFragment.this.eYS.bg(this.fax, this.cZR);
            } else if (FrsFragment.this.eZe != null) {
                FrsFragment.this.eZe.aoZ();
            }
            if (FrsFragment.this.eZF != null) {
                FrsFragment.this.eZF.onScrollStateChanged(recyclerView, i);
            }
            if (i == 0) {
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.eYS, FrsFragment.this.eYv, FrsFragment.this.getForumId(), false, null);
            }
            if (FrsFragment.this.eZl != null && i == 1) {
                FrsFragment.this.eZl.bjw();
            }
            if (FrsFragment.this.eZi == null) {
                if (FrsFragment.this.eYS.bdo() != null && !FrsFragment.this.eYS.bcS() && FrsFragment.this.eYS.bdo().bTn() != null && (FrsFragment.this.eYS.bdo().bTn().getTag() instanceof com.baidu.card.z)) {
                    FrsFragment.this.eZi = (com.baidu.card.z) FrsFragment.this.eYS.bdo().bTn().getTag();
                }
            } else if (i == 0 && FrsFragment.this.eYS.bdo() != null && !FrsFragment.this.eYS.bcS() && FrsFragment.this.eYS.bdo().bTn() != null && (FrsFragment.this.eYS.bdo().bTn().getTag() instanceof com.baidu.card.z)) {
                FrsFragment.this.eZi = (com.baidu.card.z) FrsFragment.this.eYS.bdo().bTn().getTag();
            }
        }
    };
    private final d fan = new d() { // from class: com.baidu.tieba.frs.FrsFragment.32
        @Override // com.baidu.tieba.frs.d
        public void a(int i, int i2, View view, View view2, bg bgVar) {
            if (i != FrsFragment.this.eYS.bdK().bfD()) {
                if (i != FrsFragment.this.eYS.bdK().bfE()) {
                    if (i == FrsFragment.this.eYS.bdK().bfB() && FrsFragment.this.eYv != null && FrsFragment.this.eYv.getUserData() != null && FrsFragment.this.eYv.getUserData().isBawu()) {
                        String bawuCenterUrl = FrsFragment.this.eYv.getBawuCenterUrl();
                        if (!com.baidu.tbadk.core.util.ap.isEmpty(bawuCenterUrl) && FrsFragment.this.eYv.getForum() != null) {
                            com.baidu.tbadk.browser.a.ar(FrsFragment.this.getPageContext().getPageActivity(), bawuCenterUrl);
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10502").bJ(ImageViewerConfig.FORUM_ID, FrsFragment.this.eYv.getForum().getId()).bJ("uid", FrsFragment.this.eYv.getUserData().getUserId()));
                        }
                    }
                } else if (bc.cZ(FrsFragment.this.getPageContext().getPageActivity())) {
                    TiebaStatic.log("my_service_ck");
                    if (FrsFragment.this.eYv != null && FrsFragment.this.eYv.getForum() != null) {
                        ForumData forum = FrsFragment.this.eYv.getForum();
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(forum.getId(), 0L), forum.getName(), forum.getImage_url(), 0)));
                    }
                }
            } else if (bc.cZ(FrsFragment.this.getActivity())) {
                TiebaStatic.log("forum_fortune_click");
                com.baidu.tieba.frs.f.i.b(FrsFragment.this.getPageContext(), FrsFragment.this.eYv);
            }
        }
    };
    private final NoNetworkView.a eWD = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.FrsFragment.33
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void dP(boolean z) {
            if (FrsFragment.this.eZj.bhK() == 1 && z && !FrsFragment.this.eYS.bcS()) {
                if (FrsFragment.this.eYv == null || com.baidu.tbadk.core.util.v.T(FrsFragment.this.eYv.getThreadList())) {
                    FrsFragment.this.hideNetRefreshView(FrsFragment.this.eYS.bdL());
                    FrsFragment.this.showLoadingView(FrsFragment.this.eYS.bdL(), true);
                    FrsFragment.this.eYS.jd(false);
                    FrsFragment.this.refresh();
                    return;
                }
                FrsFragment.this.eYS.bdx();
            }
        }
    };
    private final CustomMessageListener bZc = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.FrsFragment.35
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                com.baidu.tieba.frs.f.c.a(customResponsedMessage, FrsFragment.this.eYS, FrsFragment.this.eYv);
            }
        }
    };
    private com.baidu.adp.widget.ListView.s fao = new a();
    private ai fap = new ai() { // from class: com.baidu.tieba.frs.FrsFragment.37
        @Override // com.baidu.tieba.frs.ai
        public void a(int i, int i2, ap apVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
            com.baidu.adp.lib.g.e.jH().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.37.1
                @Override // java.lang.Runnable
                public void run() {
                    if (FrsFragment.this.eYS != null && FrsFragment.this.eYS.aRD()) {
                        FrsFragment.this.aBc();
                    }
                }
            });
        }
    };
    private CustomMessageListener faq = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.frs.FrsFragment.38
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    FrsFragment.this.eZG = true;
                }
            }
        }
    };
    private CustomMessageListener far = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.frs.FrsFragment.39
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && FrsFragment.this.eZi != null && FrsFragment.this.eZi.rx() != null) {
                    FrsFragment.this.eZi.rx().b(new a.C0039a(3));
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.frs.loadmore.a
    public /* bridge */ /* synthetic */ com.baidu.adp.base.e getPageContext() {
        return super.getPageContext();
    }

    public com.baidu.tieba.frs.entelechy.b.b bcl() {
        return this.eZr;
    }

    public com.baidu.adp.widget.ListView.s bcm() {
        return this.fao;
    }

    public com.baidu.tieba.frs.mc.d bcn() {
        return this.eZu;
    }

    public com.baidu.tieba.frs.smartsort.b bco() {
        return this.eZn;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public FrsModelController bcp() {
        return this.eZj;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public com.baidu.tieba.frs.mc.c bcq() {
        return this.eZv;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public com.baidu.tieba.frs.vc.f bcr() {
        return this.eZk;
    }

    public FrsTabViewController bcs() {
        return this.eZl;
    }

    public ak bct() {
        return this.eZp;
    }

    @Override // com.baidu.tieba.frs.mc.l
    public k bcu() {
        return this.eYS;
    }

    @Override // com.baidu.tieba.frs.aj
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.aj, com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.eYK;
    }

    public void setForumName(String str) {
        this.eYK = str;
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
        if (this.eZv == null) {
            return 1;
        }
        return this.eZv.getPn();
    }

    public int getPn() {
        if (this.eZv == null) {
            return 1;
        }
        return this.eZv.getPn();
    }

    public void setPn(int i) {
        if (this.eZv != null) {
            this.eZv.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.eZv != null) {
            this.eZv.setHasMore(i);
        }
    }

    public int bcv() {
        if (this.eZv == null) {
            return -1;
        }
        return this.eZv.bcv();
    }

    public boolean bcw() {
        return this.eYQ;
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
            this.eYS.bdr();
            showNetRefreshView(this.eYS.bdL(), string, true);
        } else if (340001 == bVar.errorCode) {
            a(bVar, this.eYv.getRecm_forum_list());
        } else {
            if (com.baidu.tbadk.core.util.v.T(this.eYv.getThreadList())) {
                b(bVar);
            }
            if (bcT()) {
                setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst(), d.e.ds280));
            } else {
                setNetRefreshViewEmotionDefMarginTop();
            }
        }
    }

    public void a(View view, String str, boolean z, List<RecmForumInfo> list) {
        this.eYS.bdr();
        this.eYS.qc(8);
        if (this.eZD == null) {
            this.eZD = new com.baidu.tieba.frs.view.a(getPageContext(), getNetRefreshListener());
        }
        this.eZD.po(str);
        this.eZD.cj(list);
        this.eZD.attachView(view, z);
    }

    private void a(e.b bVar, List<RecmForumInfo> list) {
        if (this.eYS != null) {
            this.eYS.bdr();
            this.eYS.setTitle(this.eYK);
            a(this.eYS.bdL(), bVar.errorMsg, true, list);
        }
    }

    private void b(e.b bVar) {
        this.eYS.bdr();
        if (bVar.iDQ) {
            showNetRefreshView(this.eYS.bdL(), TbadkCoreApplication.getInst().getString(d.j.net_error_text, new Object[]{bVar.errorMsg, Integer.valueOf(bVar.errorCode)}), true);
        } else {
            showNetRefreshView(this.eYS.bdL(), bVar.errorMsg, true);
        }
    }

    public void bcx() {
        hideLoadingView(this.eYS.bdL());
        this.eYS.jf(false);
        if (this.eYS.bdp() instanceof com.baidu.tieba.frs.tab.c) {
            ((com.baidu.tieba.frs.tab.c) this.eYS.bdp()).bip();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcy() {
        if (bcv() == 0 && com.baidu.tbadk.core.util.v.T(this.eYv.getThreadListIds())) {
            if (com.baidu.tbadk.core.util.v.T(this.eYv.getThreadList())) {
                this.eYS.aCw();
            } else {
                this.eYS.aCv();
            }
        } else if (com.baidu.tbadk.core.util.v.S(this.eYv.getThreadList()) > 3) {
            this.eYS.aCu();
        } else {
            this.eYS.bdO();
        }
    }

    public void a(ErrorData errorData) {
        bcx();
        this.eYS.bdx();
        e.b bhH = this.eZj.bhH();
        boolean T = com.baidu.tbadk.core.util.v.T(this.eYv.getThreadList());
        if (bhH != null && T) {
            if (this.eZj.bhI() != 0) {
                this.eZj.bhN();
                this.eYS.bdx();
            } else {
                a(bhH);
            }
            this.eYS.F(this.eYv.isStarForum(), false);
            return;
        }
        a(bhH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcz() {
        boolean b;
        if (!bcB()) {
            final PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
            privateForumPopInfoData.a(this.eYv.getPrivateForumTotalInfo().getPrivatePopInfo());
            FrsPrivateCommonDialogView frsPrivateCommonDialogView = new FrsPrivateCommonDialogView(getActivity());
            if (this.eYv.getPrivateForumTotalInfo().XS().private_forum_status.intValue() == 1 && (com.baidu.tbadk.core.util.ap.isEmpty(privateForumPopInfoData.XU()) || privateForumPopInfoData.XX() != Integer.valueOf(this.forumId))) {
                privateForumPopInfoData.lb("create_success");
                privateForumPopInfoData.lc(TbadkCoreApplication.getInst().getString(d.j.frs_private_create_hint));
                privateForumPopInfoData.ld("https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.eYK + "&nomenu=1");
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
    public void bcA() {
        if (bcB() || this.eYv.getPrivateForumTotalInfo().XS().private_forum_status.intValue() != 1) {
            a((Integer) null, (Integer) null, true);
        } else {
            a(this.eYv.getPrivateForumTotalInfo().XS().private_forum_audit_status, this.eYv.getPrivateForumTotalInfo().XT(), false);
        }
    }

    public void a(Integer num, Integer num2, boolean z) {
        final String str;
        final int i = 2;
        if (this.eYS.bdD() != null) {
            TextView bdD = this.eYS.bdD();
            if (z) {
                bdD.setVisibility(8);
                return;
            }
            if (num.intValue() == 2) {
                bdD.setText("修改实名认证信息");
                bdD.setVisibility(0);
                str = "https://tieba.baidu.com/mo/q/priforum/editinfo?fid=" + this.forumId + "&nomenu=1";
            } else if (num2.intValue() >= 0 && num2.intValue() <= 100) {
                bdD.setText("目标已完成" + String.valueOf(num2) + "%");
                bdD.setVisibility(0);
                str = "https://tieba.baidu.com/mo/q/forumtarget?fid=" + this.forumId + "&fn=" + this.eYK + "&nomenu=1";
                i = 1;
            } else {
                bdD.setVisibility(8);
                i = 0;
                str = "";
            }
            bdD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.17
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

    private boolean bcB() {
        return this.eYv == null || !this.eYv.isPrivateForum() || this.eYv.getPrivateForumTotalInfo() == null || this.eYv.getPrivateForumTotalInfo().XS() == null || this.eYv.getUserData().getIs_manager() != 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pU(int i) {
        List<WindowToast> list;
        if (TbadkCoreApplication.isLogin() && this.eYv != null && (list = this.eYv.mWindowToast) != null && list.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < list.size()) {
                    WindowToast windowToast = list.get(i3);
                    if (windowToast == null || windowToast.toast_type.intValue() != i) {
                        i2 = i3 + 1;
                    } else if (!com.baidu.tbadk.core.util.ap.isEmpty(windowToast.toast_link)) {
                        sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(getPageContext().getPageActivity(), "", com.baidu.tbadk.util.ae.pR(windowToast.toast_link), true)));
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
    public void bcC() {
        if (this.eYv == null || this.eYv.getForum() != null) {
            this.eYS.bdJ();
        } else if (this.eYv.getForum().getYuleData() != null && this.eYv.getForum().getYuleData().aaS()) {
            TiebaStatic.log("c10852");
            this.eYS.a(this.eYv.getForum().getYuleData().aaT());
        } else {
            this.eYS.bdJ();
        }
    }

    private void D(boolean z, boolean z2) {
        if (this.eZj != null && this.eYv != null && this.eYS != null && z) {
            if (!this.eZj.bhT() && this.eZj.bhK() == 1) {
                if (!this.eZj.bhR()) {
                    this.eYv.addCardVideoInfoToThreadList();
                    this.eYv.addVideoInfoToThreadListInTenAndFifteenFloor();
                }
                boolean z3 = false;
                if (this.eYS.bdK().l(com.baidu.tieba.card.data.n.elS)) {
                    z3 = this.eYv.addHotTopicDataToThreadList();
                }
                if (!z3) {
                    this.eYv.addFeedForumDataToThreadList();
                }
                if (TbadkCoreApplication.getInst().isRecAppExist()) {
                    this.eYv.addRecommendAppToThreadList(this);
                }
                if (!this.eYS.bdK().l(bg.bBe)) {
                    this.eYv.removeAlaLiveThreadData();
                }
                this.eYv.addSchoolRecommendToThreadList();
            }
            if (!this.eYS.bdK().l(bg.bBe)) {
                this.eYv.removeAlaInsertLiveData();
                this.eYv.removeAlaStageLiveDat();
            } else {
                this.eYv.addInsertLiveDataToThreadList();
                this.eYv.addStageLiveDataToThreadList();
            }
            this.eYv.updateInterviewTaskInfoDataInThreadList();
            this.eYv.addNoticeThreadToThreadList();
            if (this.eYS.bdK().l(com.baidu.tieba.h.b.fAI)) {
                this.eYv.addGameRankListToThreadList(z2);
            }
            if (TbadkCoreApplication.isLogin() && (!this.eZj.bhT() || this.eZj.isNetFirstLoad)) {
                this.eYv.addUserRecommendToThreadList();
            }
            this.eYv.addVideoActivityToTop();
        }
    }

    public boolean bcD() {
        if (this.eZk != null && this.eZj != null) {
            this.eZk.a(this.eZj.getPageType(), this.eYv);
        }
        boolean z = false;
        if (this.eYv != null) {
            z = this.eYv.hasTab();
        }
        bcF();
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pV(int i) {
        am amVar = null;
        bcD();
        bcM();
        try {
            if (this.eYv != null) {
                this.eYS.a((ArrayList<com.baidu.adp.widget.ListView.m>) null, this.eYv);
                this.eZk.rw(1);
                this.eYS.bdA();
                this.eZl.a(this.eYv, this.eZj.bhP());
                com.baidu.tieba.frs.tab.d rD = this.eZl.rD(this.eYv.getFrsDefaultTabId());
                if (rD != null && !TextUtils.isEmpty(rD.url)) {
                    amVar = new am();
                    amVar.fda = rD.url;
                    amVar.stType = rD.name;
                }
                this.eZj.a(this.eYv.getFrsDefaultTabId(), 0, amVar);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(boolean z, boolean z2) {
        try {
            if (this.eYv != null && this.eZl != null && this.eZj != null) {
                if (!this.eYS.bdK().l(bg.bBe)) {
                    this.eYv.removeAlaLiveThreadData();
                }
                boolean T = com.baidu.tbadk.core.util.v.T(this.eYv.getGameTabInfo());
                this.eYS.jb(T);
                if (!T) {
                    if (this.eZF == null) {
                        this.eZF = new com.baidu.tieba.frs.vc.e(this, (NoPressedRelativeLayout) this.mRootView);
                    }
                    if (this.don == null) {
                        this.don = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
                    }
                } else {
                    this.eZF = null;
                    this.don = null;
                }
                if (this.eYv.getForum() != null) {
                    this.eYK = this.eYv.getForum().getName();
                    this.forumId = this.eYv.getForum().getId();
                }
                if (this.eYv.hasTab()) {
                    this.eZl.a(this.eYv, this.eZj.bhP());
                }
                if (z) {
                    D(true, z);
                } else {
                    D(this.eZf, z);
                }
                bcD();
                if (this.eZr != null) {
                    this.eZr.a(this.eZk, this.eYv);
                }
                if (this.eYv.getPage() != null) {
                    setHasMore(this.eYv.getPage().XK());
                }
                ArrayList<com.baidu.adp.widget.ListView.m> a2 = this.eZv.a(z2, true, this.eYv.getThreadList(), null, z, false);
                if (a2 != null) {
                    this.eYv.setThreadList(a2);
                }
                this.eYv.removeRedundantUserRecommendData();
                this.eYx = this.eYv.getTopThreadSize();
                if (this.eYO != null) {
                    this.eYN = true;
                    this.eYO.zq(this.eYx);
                    com.baidu.tieba.frs.f.a.a(this, this.eYv.getForum(), this.eYv.getThreadList(), this.eYN, getPn());
                }
                if (this.eZj.bhK() == 1) {
                    bcJ();
                    if (!z && this.eZj.getPn() == 1) {
                        bcE();
                    }
                }
                if (this.eZt != null) {
                    this.eZt.bN(this.eZl.bjt());
                }
                bcx();
                this.eYS.bds();
                this.eYS.F(true, false);
                if (z && this.eYv.isFirstTabEqualAllThread()) {
                    com.baidu.adp.lib.g.e.jH().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.18
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!FrsFragment.this.eZc) {
                                FrsFragment.this.eYS.bdU();
                            }
                        }
                    });
                }
                if (this.eYv.getForum() != null) {
                    this.eYS.uY(this.eYv.getForum().getWarningMsg());
                }
                if (this.eYv != null && this.eYv.getFrsVideoActivityData() != null && com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("frs_video_activity_guide", 0L) == 0) {
                    com.baidu.adp.lib.g.e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.19
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsFragment.this.eYS.bdR();
                        }
                    }, 1000L);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2921326, this));
                this.eYS.bdm();
                if (this.eYv != null && this.eYv.getForum() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016564, new VisitedForumData(this.eYv.getForum().getId(), this.eYv.getForum().getName(), this.eYv.getForum().getImage_url(), String.valueOf(System.currentTimeMillis() / 1000), "showlive".equals(this.eYv.getForum().special_forum_type), this.eYv.getForum().getThemeColorInfo(), this.eYv.getForum().getMember_num())));
                }
                this.eZK.a(this.eYv.bottomMenuList, this.eYv.getForum());
                bcZ();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void iS(boolean z) {
        com.baidu.tieba.q.c.cdt().b(getUniqueId(), z);
    }

    public void bcE() {
        if (this.eZy == null) {
            this.eZy = new com.baidu.tieba.frs.live.a(this, com.baidu.adp.lib.g.b.l(this.forumId, 0));
        }
        this.eZy.bht();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.j jVar) {
        try {
            if (!this.eZc && jVar != null && this.eYv != null) {
                this.eYv.receiveData(jVar);
                E(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void bcF() {
        if (this.eZj != null) {
            uW(this.eZj.getPageType());
        } else {
            uW("normal_page");
        }
    }

    private void uW(String str) {
        iT("frs_page".equals(str));
        if (this.eZr != null) {
            this.eZr.a(this.eZk, this.eYS, this.eYv);
        }
    }

    public void iT(boolean z) {
        if (this.eZw != null) {
            this.eZw.bjn();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.q.c.cdt().s(getUniqueId());
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(d.h.frs_activity, viewGroup, false);
            this.eYE = new com.baidu.tieba.frs.entelechy.a();
            this.eZr = this.eYE.bfi();
            this.eZk = new com.baidu.tieba.frs.vc.f(this, this.eYE, (FrsHeaderViewContainer) this.mRootView.findViewById(d.g.header_view_container));
            this.eZl = new FrsTabViewController(this, this.mRootView);
            this.eZl.registerListener();
            this.eZk.a(this.eZl);
            this.eZl.a(this.eZW);
            Intent intent = getActivity().getIntent();
            if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                this.eYG = true;
            }
            this.eYS = new k(this, this.fam, this.eYE, this.eYG, this.eZk);
            this.eZK = new com.baidu.tieba.frs.brand.buttommenu.a(getPageContext(), this.mRootView);
        } else {
            if (this.mRootView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            if (this.eZl != null) {
                this.eZl.registerListener();
            }
            this.eYS.bdQ();
        }
        this.eZN = true;
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        ArrayList<com.baidu.adp.widget.ListView.m> arrayList = null;
        this.eCL = System.currentTimeMillis();
        this.beginTime = this.eCL;
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.eYP = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.eCL = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            ac(intent);
        }
        this.cqn = this.beginTime - this.eCL;
        this.eYO = new com.baidu.tieba.tbadkCore.data.f("frs", com.baidu.tieba.tbadkCore.data.f.iFA);
        if (this.eZj == null) {
            this.eZj = new FrsModelController(this, this.fai);
            this.eZj.a(this.eZV);
            this.eZj.init();
        }
        if (intent != null) {
            this.eZj.J(intent.getExtras());
        } else if (bundle != null) {
            this.eZj.J(bundle);
        } else {
            this.eZj.J(null);
        }
        if (intent != null) {
            this.eZk.Q(intent.getExtras());
        } else if (bundle != null) {
            this.eZk.Q(bundle);
        } else {
            this.eZk.Q(null);
        }
        this.eYR = getVoiceManager();
        this.eZz = new j(getPageContext(), this);
        initUI();
        initData(bundle);
        if (!bcT()) {
            this.eZp = new ak(getActivity(), this.eYS, this.eZk);
            this.eZp.js(true);
        }
        this.eYR = getVoiceManager();
        if (this.eYR != null) {
            this.eYR.onCreate(getPageContext());
        }
        new com.baidu.tieba.frs.mc.i();
        int i = -1;
        if (this.eZv != null && this.eZv.bhE() != null) {
            i = this.eZv.bhE().bcv();
            arrayList = this.eZv.bhE().getDataList();
        }
        this.eZv = new com.baidu.tieba.frs.mc.c(this, this.fak);
        this.eZv.bhE().setHasMore(i);
        if (arrayList != null && arrayList.size() > 0) {
            this.eZv.bhE().Z(arrayList);
        }
        this.eZn = new com.baidu.tieba.frs.smartsort.b(this);
        this.eZw = new com.baidu.tieba.frs.vc.h(this);
        this.eZt = new com.baidu.tieba.frs.vc.a(getPageContext(), this.eZj.bhQ());
        this.eZo = new com.baidu.tieba.frs.mc.b(this);
        this.eZu = new com.baidu.tieba.frs.mc.d(this);
        this.eZm = new com.baidu.tieba.frs.mc.h(this);
        this.eZx = new com.baidu.tieba.frs.mc.a(this);
        this.eZA = new com.baidu.tieba.frs.vc.c(this);
        this.eZB = new com.baidu.tieba.frs.mc.e(this, getUniqueId());
        this.eZI = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "frs");
        this.eZJ = new com.baidu.tieba.ala.a(getPageContext());
        registerListener(this.ddn);
        registerListener(this.mMemListener);
        registerListener(this.fac);
        registerListener(this.fal);
        registerListener(this.fab);
        registerListener(this.faj);
        registerListener(this.eZY);
        registerListener(this.eZZ);
        registerListener(this.faa);
        registerListener(this.eZS);
        registerListener(this.eZT);
        registerListener(this.XW);
        registerListener(this.faq);
        registerListener(this.faf);
        registerListener(this.eZU);
        registerListener(this.fag);
        registerListener(this.fae);
        this.eZR.setTag(getPageContext().getUniqueId());
        registerListener(this.eZR);
        registerListener(this.brp);
        registerListener(this.fah);
        this.far.setTag(getPageContext().getUniqueId());
        MessageManager.getInstance().registerListener(this.far);
        this.eYS.jd(false);
        if (!bcT() && !this.hasInit) {
            showLoadingView(this.eYS.bdL(), true);
            this.eZj.y(3, false);
        }
        com.baidu.tieba.frs.a.bbF().a(new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.22
            @Override // com.baidu.tieba.frs.a.b
            public void C(boolean z, boolean z2) {
                if (FrsFragment.this.eYS != null) {
                    FrsFragment.this.eYS.qd(z ? 0 : 8);
                    if (!z2) {
                        FrsFragment.this.eZM = z;
                    }
                    if (FrsFragment.this.eYS.bdK() != null && FrsFragment.this.eZj != null && FrsFragment.this.eZj.bhL()) {
                        FrsFragment.this.eYS.bdK().notifyDataSetChanged();
                    }
                    if (FrsFragment.this.bcs() != null) {
                        FrsTabViewController.b bju = FrsFragment.this.bcs().bju();
                        if (bju != null && bju.tabId == 502 && (bju.fragment instanceof FrsCommonTabFragment)) {
                            ((FrsCommonTabFragment) bju.fragment).bfg();
                        } else if (bju != null && bju.tabId == 503 && (bju.fragment instanceof FrsNewAreaFragment)) {
                            FrsNewAreaFragment frsNewAreaFragment = (FrsNewAreaFragment) bju.fragment;
                            frsNewAreaFragment.bfg();
                            if (frsNewAreaFragment.bhW() != null) {
                                com.baidu.tieba.frs.mc.g bhW = frsNewAreaFragment.bhW();
                                bhW.jg(!z);
                                bhW.jh(!z);
                            }
                        }
                        if (FrsFragment.this.bcs().bjo() != null) {
                            FrsFragment.this.bcs().bjo().setmDisallowSlip(z);
                            FrsFragment.this.bcs().jR(z);
                        }
                    }
                    if (FrsFragment.this.eYS.bdq() != null) {
                        FrsFragment.this.eYS.ja(!z);
                    }
                    if (FrsFragment.this.getActivity() instanceof FrsActivity) {
                        ((FrsActivity) FrsFragment.this.getActivity()).iR(!z);
                    }
                    if (FrsFragment.this.eZK != null) {
                        FrsFragment.this.eZK.jA(!z);
                    }
                    FrsFragment.this.eYS.jg(!z);
                    FrsFragment.this.eYS.jh(z ? false : true);
                }
            }

            @Override // com.baidu.tieba.frs.a.b
            public void pR(int i2) {
                if (FrsFragment.this.eYS != null) {
                    FrsFragment.this.eYS.qe(i2);
                }
            }

            @Override // com.baidu.tieba.frs.a.b
            public void bbL() {
                com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getContext(), d.j.frs_multi_delete_max_num);
            }
        });
        this.eYS.b(new d.a() { // from class: com.baidu.tieba.frs.FrsFragment.24
            @Override // com.baidu.tieba.NEGFeedBack.d.a
            public void a(DeleteThreadHttpResponseMessage deleteThreadHttpResponseMessage) {
                boolean z;
                int i2 = 0;
                if (deleteThreadHttpResponseMessage != null) {
                    FrsFragment.this.eYS.auU();
                    FrsFragment.this.eYS.bdS();
                    FrsNewAreaFragment frsNewAreaFragment = null;
                    if (FrsFragment.this.eZl == null || FrsFragment.this.eZl.bju() == null || !(FrsFragment.this.eZl.bju().fragment instanceof FrsNewAreaFragment)) {
                        z = false;
                    } else {
                        frsNewAreaFragment = (FrsNewAreaFragment) FrsFragment.this.eZl.bju().fragment;
                        z = true;
                    }
                    if (deleteThreadHttpResponseMessage.getError() == 0) {
                        String text = !TextUtils.isEmpty(deleteThreadHttpResponseMessage.getText()) ? deleteThreadHttpResponseMessage.getText() : FrsFragment.this.getString(d.j.delete_fail);
                        if (deleteThreadHttpResponseMessage.getRetType() == 1211066) {
                            if (FrsFragment.this.eko == null) {
                                FrsFragment.this.eko = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.eko.ly(text);
                            FrsFragment.this.eko.a(d.j.dialog_known, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.24.1
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.eko.dr(false);
                            FrsFragment.this.eko.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.eko.aaZ();
                        } else if (deleteThreadHttpResponseMessage.getRetType() == 1211067) {
                            if (FrsFragment.this.eko == null) {
                                FrsFragment.this.eko = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.eko.ly(text);
                            FrsFragment.this.eko.a(d.j.know, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.24.2
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.eko.dr(false);
                            FrsFragment.this.eko.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.eko.aaZ();
                        } else {
                            FrsFragment.this.eYS.ax(deleteThreadHttpResponseMessage.getText(), ContextCompat.getColor(FrsFragment.this.getContext(), deleteThreadHttpResponseMessage.getRetType() == 1 ? d.C0277d.nav_bar_tip_error : d.C0277d.cp_link_tip_a_alpha95));
                        }
                        if (z && frsNewAreaFragment != null) {
                            frsNewAreaFragment.ce(deleteThreadHttpResponseMessage.getSuccessItems());
                        }
                        FrsFragment.this.bR(deleteThreadHttpResponseMessage.getSuccessItems());
                        com.baidu.tieba.frs.a.bbF().bQ(deleteThreadHttpResponseMessage.getSuccessItems());
                        for (com.baidu.adp.widget.ListView.m mVar : FrsFragment.this.eYv.getThreadList()) {
                            if (mVar instanceof bf) {
                                i2++;
                                continue;
                            }
                            if (i2 >= 6) {
                                break;
                            }
                        }
                        if (i2 < 6) {
                            FrsFragment.this.aBc();
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
        if (this.eZl != null) {
            this.eZl.fwt = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bR(List<String> list) {
        if (!com.baidu.tbadk.core.util.v.T(list)) {
            ArrayList<com.baidu.adp.widget.ListView.m> threadList = this.eYv.getThreadList();
            if (!com.baidu.tbadk.core.util.v.T(threadList) && this.eYS.getListView() != null && this.eYS.getListView().getData() != null) {
                Iterator<com.baidu.adp.widget.ListView.m> it = threadList.iterator();
                List<com.baidu.adp.widget.ListView.m> data = this.eYS.getListView().getData();
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
                                this.eZv.e(next);
                                this.eYS.getListView().getAdapter().notifyItemRemoved(i);
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
    public void aBv() {
        if (isAdded() && this.ddc && !isLoadingViewAttached()) {
            showLoadingView(this.eYS.bdL(), true);
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void aBw() {
        if (isAdded() && this.ddc && isLoadingViewAttached()) {
            hideLoadingView(this.eYS.bdL());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (bcT()) {
            showLoadingView(this.eYS.bdL(), true);
            this.eYS.qf(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.eZj.y(3, true);
            afc().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void setHeaderViewHeight(int i) {
    }

    @Override // com.baidu.tieba.frs.ae
    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.x xVar) {
        if (xVar != null) {
            this.ctG = xVar.aql();
            this.eZC = xVar.aqm();
        }
    }

    @Override // com.baidu.tieba.frs.ae
    public void showFloatingView() {
        if (this.ctG != null) {
            this.ctG.fl(true);
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
                this.eYK = data.getQueryParameter("name");
                this.mFrom = data.getQueryParameter("from");
                if (!StringUtils.isNull(this.eYK)) {
                    intent.putExtra("name", this.eYK);
                }
                if (!StringUtils.isNull(this.mFrom)) {
                    intent.putExtra("from", this.mFrom);
                }
                TiebaStatic.log("c10105");
            }
            if (StringUtils.isNull(this.eYK) && intent != null && intent.getData() != null) {
                Uri data2 = intent.getData();
                if (com.baidu.tbadk.BdToken.f.m(data2)) {
                    com.baidu.tbadk.BdToken.f.Uk().b(data2, new f.a() { // from class: com.baidu.tieba.frs.FrsFragment.25
                        @Override // com.baidu.tbadk.BdToken.f.a
                        public void o(HashMap<String, Object> hashMap) {
                            if (hashMap != null && (hashMap.get(com.baidu.tbadk.BdToken.f.brI) instanceof String)) {
                                FrsFragment.this.eYK = (String) hashMap.get(com.baidu.tbadk.BdToken.f.brI);
                            }
                        }
                    });
                } else {
                    com.baidu.tieba.frs.f.d af = com.baidu.tieba.frs.f.i.af(intent);
                    if (af != null) {
                        this.eYK = af.forumName;
                        if (af.fuQ == null || af.fuQ.equals("aidou")) {
                        }
                    }
                }
                if (!StringUtils.isNull(this.eYK)) {
                    intent.putExtra("name", this.eYK);
                }
                intent.putExtra(FrsActivityConfig.FRS_CALL_FROM, 12);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.eYR = getVoiceManager();
        if (this.eYR != null) {
            this.eYR.onStart(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        Intent intent;
        registerListener(2001118, this.bZc);
        if (bundle != null) {
            this.eYK = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
            this.eYK = intent.getStringExtra("name");
            this.mFrom = intent.getStringExtra("from");
            this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
        }
        if (getArguments() != null) {
            this.eYL = getArguments().getBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, false);
        }
        if (TextUtils.isEmpty(this.mFrom) || FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
        }
        if (this.mIsLogin) {
            registerListener(2001120, this.bZc);
        }
        this.eZk.Q(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.q.c.cdt().t(getUniqueId());
        MessageManager.getInstance().unRegisterListener(this.faq);
        eYW = null;
        if (this.eYR != null) {
            this.eYR.onDestory(getPageContext());
        }
        com.baidu.tieba.recapp.report.a.remove("FRS");
        this.eYR = null;
        com.baidu.tieba.card.t.aQF().hQ(false);
        if (this.eYv != null && this.eYv.getForum() != null) {
            aa.bep().cF(com.baidu.adp.lib.g.b.d(this.eYv.getForum().getId(), 0L));
        }
        if (this.eZy != null) {
            this.eZy.onDestory();
        }
        if (this.eYS != null) {
            com.baidu.tieba.frs.f.h.a(this.eYS, this.eYv, getForumId(), false, null);
            this.eYS.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.eZe != null) {
                this.eZe.apb();
            }
            this.eYS.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.eZk.onActivityDestroy();
        if (this.eZj != null) {
            this.eZj.aDF();
        }
        if (this.eZp != null) {
            this.eZp.aqk();
        }
        if (this.eZs != null) {
            this.eZs.destory();
        }
        if (this.eZt != null) {
            this.eZt.destory();
        }
        if (this.eZn != null) {
            this.eZn.onDestroy();
        }
        if (this.eZF != null) {
            this.eZF.onDestory();
        }
        if (this.eZx != null) {
            this.eZx.onDestroy();
        }
        if (this.eZI != null) {
            this.eZI.onDestroy();
        }
        if (this.eZJ != null) {
            this.eZJ.onDestroy();
        }
        com.baidu.tieba.recapp.d.a.bXz().bXB();
        com.baidu.tieba.frs.f.j.biF();
        if (this.eZl != null) {
            this.eZl.a((FrsTabViewController.a) null);
            this.eZl.bjw();
        }
        if (this.eZL != null) {
            this.eZL.onDestroy();
        }
        com.baidu.tieba.frs.a.bbF().a(null);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.eYK);
        bundle.putString("from", this.mFrom);
        this.eZj.onSaveInstanceState(bundle);
        if (this.eYR != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            this.eYR.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.eZx != null) {
            this.eZx.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.eYS != null) {
            this.eYS.bdx();
            this.eYS.onResume();
        }
        this.eZm.jN(true);
        this.eZf = true;
        if (eYJ) {
            eYJ = false;
            this.eYS.startPullRefresh();
            return;
        }
        if (this.eYR != null) {
            this.eYR.onResume(getPageContext());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921338));
        this.eYS.ji(false);
        if (this.eZG) {
            refresh(6);
            this.eZG = false;
        }
        bcZ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
    }

    public boolean bcG() {
        Intent intent;
        if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
            return false;
        }
        return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
    }

    public void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.eYK = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.eYM = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.eYM) {
                bcH();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcH() {
        this.eYS.startPullRefresh();
    }

    public void closeActivity() {
        com.baidu.tieba.frs.f.i.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.mFrom);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.eYS.setTitle(this.eYK);
        } else {
            this.eYS.setTitle("");
            this.mFlag = 1;
        }
        this.eYS.setOnAdapterItemClickListener(this.fao);
        this.eYS.addOnScrollListener(this.mScrollListener);
        this.eYS.h(this.eWD);
        this.eYS.bdK().a(this.fan);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.eZN) {
            this.eYS.onChangeSkinType(i);
            this.eZk.rv(i);
            this.eZl.onChangeSkinType(i);
            if (this.eYU != null) {
                this.eYU.onChangeSkinType(i);
            }
            if (this.eZD != null) {
                this.eZD.onChangeSkinType();
            }
            if (this.eZK != null) {
                this.eZK.onChangeSkinType(getPageContext(), i);
            }
            if (this.eko != null) {
                com.baidu.tbadk.r.a.a(getPageContext(), this.eko.aba());
            }
            if (this.eZE != null) {
                this.eZE.onChangeSkinType();
            }
        }
    }

    public void pW(int i) {
        if (!this.mIsLogin) {
            if (this.eYv != null && this.eYv.getAnti() != null) {
                this.eYv.getAnti().setIfpost(1);
            }
            if (i == 0) {
                bc.cY(getActivity());
            }
        } else if (this.eYv != null) {
            if (i == 0) {
                com.baidu.tieba.frs.f.j.d(this, 0);
            } else {
                this.eYS.bdz();
            }
        }
    }

    public void refresh() {
        com.baidu.tieba.a.d.awk().qK("page_frs");
        refresh(3);
    }

    public void refresh(int i) {
        this.eZc = false;
        bcM();
        if (this.eYS.bdo() != null) {
            this.eYS.bdo().boo();
        }
        this.eZj.y(i, true);
    }

    private void bcI() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.g.h.jI().d(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.29
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.CH(FrsFragment.this.eYK);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcJ() {
        bcM();
        try {
            if (this.eYv != null) {
                this.eYS.aOA();
                this.eYS.ja(bcY());
                if (!com.baidu.tieba.frs.vc.f.k(this.eYv) || !com.baidu.tieba.frs.vc.f.j(this.eYv)) {
                }
                if (this.eYv.getForum() != null) {
                    this.eYK = this.eYv.getForum().getName();
                    this.forumId = this.eYv.getForum().getId();
                }
                if (this.eYv.getPage() != null) {
                    setHasMore(this.eYv.getPage().XK());
                }
                this.eYS.setTitle(this.eYK);
                this.eYS.setForumName(this.eYK);
                TbadkCoreApplication.getInst().setDefaultBubble(this.eYv.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.eYv.getUserData().getBimg_end_time());
                bcI();
                bcK();
                ArrayList<com.baidu.adp.widget.ListView.m> threadList = this.eYv.getThreadList();
                if (threadList != null) {
                    this.eYS.a(threadList, this.eYv);
                    com.baidu.tieba.frs.f.c.w(this.eYS);
                    this.eZk.rw(getPageNum());
                    this.eZk.h(this.eYv);
                    this.eZl.a(this.eYv, this.eZj.bhP());
                    this.eYS.bdA();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void bcK() {
        if (this.eYv != null) {
            if (this.eYv.getIsNewUrl() == 1) {
                this.eYS.bdK().setFromCDN(true);
            } else {
                this.eYS.bdK().setFromCDN(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.eZm.jN(false);
        this.eZf = false;
        this.eYS.onPause();
        if (this.eYR != null) {
            this.eYR.onPause(getPageContext());
        }
        this.eYS.ji(true);
        if (this.eZt != null) {
            this.eZt.biI();
        }
        com.baidu.tbadk.BdToken.c.TZ().Ua();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.eZl != null && this.eZl.bju() != null && (this.eZl.bju().fragment instanceof BaseFragment)) {
            ((BaseFragment) this.eZl.bju().fragment).setPrimary(z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.t.aQF().hQ(false);
        iS(false);
        if (this.eYv != null && this.eYv.getForum() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            com.baidu.tbadk.distribute.a.alF().a(getPageContext().getPageActivity(), "frs", this.eYv.getForum().getId(), 0L);
        }
        if (this.eYR != null) {
            this.eYR.onStop(getPageContext());
        }
        if (afc() != null) {
            afc().getRecycledViewPool().clear();
        }
        this.eZk.onActivityStop();
        com.baidu.tbadk.util.y.aqo();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            if (this.eZk != null) {
                this.eZk.iY(isPrimary());
            }
            if (this.eYS != null) {
                this.eYS.iY(isPrimary());
                this.eYS.ji(!isPrimary());
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (com.baidu.tieba.frs.a.bbF().bbG()) {
                com.baidu.tieba.frs.a.bbF().reset();
                return true;
            } else if (this.eYS != null) {
                return this.eYS.bdw();
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
        com.baidu.tbadk.distribute.a.alF().a(advertAppInfo, this.forumId, 0L, "FRS", str, getPn());
    }

    @Override // com.baidu.tieba.recapp.n
    public void bcL() {
        bcp().bcL();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.eYR == null) {
            this.eYR = VoiceManager.instance();
        }
        return this.eYR;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdRecyclerView afc() {
        if (this.eYS == null) {
            return null;
        }
        return this.eYS.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void bcM() {
        if (this.eYR != null) {
            this.eYR.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> afd() {
        if (this.bTS == null) {
            this.bTS = UserIconBox.q(getPageContext().getPageActivity(), 8);
        }
        return this.bTS;
    }

    public void bcN() {
        if (getFragmentActivity() != null && getFragmentActivity().getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.b(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.p onGetPreLoadListView() {
        return afc().getPreLoadHandle();
    }

    @Override // com.baidu.tieba.frs.ah
    public NavigationBar aDp() {
        if (this.eYS == null) {
            return null;
        }
        return this.eYS.aDp();
    }

    public FRSRefreshButton bcO() {
        return this.eYU;
    }

    public void a(FRSRefreshButton fRSRefreshButton) {
        if (fRSRefreshButton != null) {
            this.eYU = fRSRefreshButton;
            this.eYU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.36
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (FrsFragment.this.eZl != null) {
                        FrsTabViewController.b bju = FrsFragment.this.eZl.bju();
                        if (bju != null && bju.fragment != null && (bju.fragment instanceof ag)) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                            ((ag) bju.fragment).bcd();
                            ((ag) bju.fragment).aCt();
                            return;
                        }
                        FrsFragment.this.bcu().startPullRefresh();
                    }
                }
            });
        }
    }

    public void bcP() {
        if (this.eYU != null && this.eYV) {
            if (this.eZO != null) {
                this.eZO.cancel();
            }
            this.eZO = new AlphaAnimation(1.0f, 0.0f);
            this.eZO.setDuration(300L);
            this.eZO.setFillAfter(true);
            this.eYU.startAnimation(this.eZO);
            this.eYV = false;
        }
    }

    public void bcQ() {
        if (this.eYU != null && !this.eYV && this.eZl.bjx() != 0) {
            this.eYU.setVisibility(0);
            if (this.eZP != null) {
                this.eZP.cancel();
            }
            this.eZP = new AlphaAnimation(0.0f, 1.0f);
            this.eZP.setDuration(300L);
            this.eZP.setFillAfter(true);
            this.eYU.startAnimation(this.eZP);
            this.eYV = true;
        }
    }

    /* loaded from: classes4.dex */
    private final class a implements com.baidu.adp.widget.ListView.s {
        private a() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.s
        public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null) {
                if (bdUniqueId == p.fbY) {
                    if (FrsFragment.this.eYS != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11752").bJ(ImageViewerConfig.FORUM_ID, FrsFragment.this.forumId).bJ("obj_locate", "1"));
                        FrsFragment.this.eYS.startPullRefresh();
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
                                if (readThreadHistory != null && !readThreadHistory.CN(bgVar.getId())) {
                                    readThreadHistory.CM(bgVar.getId());
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
                                if (bdUniqueId.getId() == bg.bCA.getId()) {
                                    com.baidu.tieba.frs.f.h.a(bgVar.Yx());
                                } else if (bdUniqueId.getId() == bg.bBh.getId()) {
                                    com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c12940");
                                    amVar.bJ("obj_type", "2");
                                    amVar.bJ("tid", bgVar.getTid());
                                    TiebaStatic.log(amVar);
                                }
                                com.baidu.tieba.frs.f.i.a(FrsFragment.this, bgVar, i, z);
                                com.baidu.tieba.frs.f.h.a(FrsFragment.this, FrsFragment.this.eYv, bgVar);
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
            hideNetRefreshView(this.eYS.bdL());
            showLoadingView(this.eYS.bdL(), true);
            this.eYS.jd(false);
            this.eZj.y(3, true);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public FrsViewData bcR() {
        return this.eYv;
    }

    public boolean bcS() {
        return this.eYS.bcS();
    }

    public void at(Object obj) {
        if (this.eZo != null && this.eZo.fqP != null) {
            this.eZo.fqP.m(obj);
        }
    }

    public void au(Object obj) {
        if (this.eZo != null && this.eZo.fqQ != null) {
            this.eZo.fqQ.m(obj);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        this.eYS.getListView().stopScroll();
        if (!this.eYS.bdG()) {
            if (!com.baidu.adp.lib.util.l.lo()) {
                this.eYS.aCw();
            } else if (this.eZj.bhK() == 1) {
                aBq();
                aBc();
            } else if (this.eZj.hasMore()) {
                aBc();
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void uF(String str) {
        aBq();
        showToast(str);
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void R(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        boolean T = com.baidu.tbadk.core.util.v.T(arrayList);
        setHasMore(T ? 0 : 1);
        aBq();
        if (!T) {
            if (!this.eZj.bhT() && TbadkCoreApplication.getInst().isRecAppExist() && this.eZj.bhK() == 1) {
                this.eYv.addRecommendAppToThreadList(this, arrayList);
            }
            if (this.eZj != null) {
                com.baidu.tieba.frs.d.a.a(getUniqueId(), arrayList, this.eYv.getForum(), this.eZj.getSortType());
            }
            ArrayList<com.baidu.adp.widget.ListView.m> a2 = this.eZv.a(false, false, arrayList, this.eYO, false);
            if (a2 != null) {
                this.eYv.setThreadList(a2);
                this.eYS.a(a2, this.eYv);
            }
            if (this.eZj != null) {
                com.baidu.tieba.frs.d.c.a(this.eYv, this.eZj.bhP(), 2);
            }
        }
    }

    private void aBq() {
        if (bcv() == 1 || this.eZv.cd(this.eYv.getThreadListIds())) {
            if (com.baidu.tbadk.core.util.v.S(this.eYv.getThreadList()) > 3) {
                this.eYS.aCu();
            } else {
                this.eYS.bdO();
            }
        } else if (com.baidu.tbadk.core.util.v.T(this.eYv.getThreadList())) {
            this.eYS.aCw();
        } else {
            this.eYS.aCv();
        }
    }

    @Override // com.baidu.tieba.frs.mc.l
    public void aBc() {
        if (this.eZv != null) {
            this.eZv.a(this.eYK, this.forumId, this.eYv);
        }
    }

    public void takePhoto() {
        if (!com.baidu.tbadk.core.util.ab.e(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.ak.c(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        if (this.eZb) {
            return null;
        }
        if (bcT()) {
            return "a034";
        }
        return "a006";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (!bcT()) {
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

    @Override // android.support.v4.app.Fragment, com.baidu.e.a.a.InterfaceC0042a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        com.baidu.tieba.frs.f.i.a(this, i, strArr, iArr);
    }

    public void iV(boolean z) {
        if (this.eZp != null) {
            this.eZp.js(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.eZq.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a lj(int i) {
        return this.eZq.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        this.eZz.b(bVar);
    }

    public boolean bcT() {
        return this.eYG;
    }

    @Override // com.baidu.tieba.frs.ae
    public void aBu() {
        if (this.eYS != null) {
            showFloatingView();
            this.eYS.getListView().scrollToPosition(0);
            this.eYS.startPullRefresh();
        }
    }

    public ForumWriteData bcU() {
        if (this.eYv == null || this.eYv.getForum() == null) {
            return null;
        }
        ForumData forum = this.eYv.getForum();
        ForumWriteData forumWriteData = new ForumWriteData(forum.getId(), forum.getName(), forum.getPrefixData(), this.eYv.getAnti());
        forumWriteData.avatar = forum.getImage_url();
        forumWriteData.forumLevel = forum.getUser_level();
        forumWriteData.specialForumType = forum.special_forum_type;
        forumWriteData.firstDir = forum.getFirst_class();
        forumWriteData.secondDir = forum.getSecond_class();
        UserData userData = this.eYv.getUserData();
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
        this.eZg = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z) {
        super.showLoadingView(view, z);
        this.eYS.qc(8);
        ((FrsActivity) getActivity()).i(view, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        super.hideLoadingView(view);
        this.eYS.qc(0);
        ((FrsActivity) getActivity()).i(view, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        super.showNetRefreshView(view, str, z);
        this.eYS.qc(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshViewNoClick(View view, String str, boolean z) {
        super.showNetRefreshViewNoClick(view, str, z);
        this.eYS.qc(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        super.hideNetRefreshView(view);
        this.eYS.qc(0);
    }

    public void bcV() {
        FrsTabViewController.b bju;
        if (this.eZl != null && (bju = this.eZl.bju()) != null && bju.fragment != null && (bju.fragment instanceof ag)) {
            ((ag) bju.fragment).bcd();
        }
    }

    public void iX(boolean z) {
        this.eYI = z;
    }

    public void b(OvalActionButton ovalActionButton) {
        this.eYT = ovalActionButton;
    }

    public OvalActionButton bcW() {
        return this.eYT;
    }

    public boolean bcX() {
        return this.eYI;
    }

    public void uX(String str) {
        if (TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.util.ap.isEmpty(str)) {
            if (this.eZL == null) {
                this.eZL = new AddExperiencedModel(getTbPageContext());
                this.eZL.a(this.eZQ);
            }
            this.eZL.dO(this.forumId, str);
        }
    }

    public boolean bcY() {
        if (this.eZg) {
            return (this.eZj != null && this.eZj.bhL() && com.baidu.tieba.frs.a.bbF().bbG()) ? false : true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.e.c
    public boolean videoNeedPreload() {
        if (this.eYv != null) {
            return com.baidu.tbadk.util.ad.aqv() && (this.eYv.isFrsVideoAutoPlay || com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("auto_play_video_frs", 0) == 1);
        }
        return super.videoNeedPreload();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcZ() {
        if (!com.baidu.tbadk.core.util.ap.isEmpty(this.forumId)) {
            com.baidu.tbadk.BdToken.c.TZ().g(com.baidu.tbadk.BdToken.b.bqE, com.baidu.adp.lib.g.b.d(this.forumId, 0L));
        }
    }
}
