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
import java.util.Iterator;
import java.util.List;
import tbclient.FrsPage.RecmForumInfo;
import tbclient.WindowToast;
/* loaded from: classes6.dex */
public class FrsFragment extends BaseFragment implements BdListView.e, a.InterfaceC0073a, NavigationBar.a, UserIconBox.b<BdRecyclerView>, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, ah, ak, am, com.baidu.tieba.frs.loadmore.a, com.baidu.tieba.frs.mc.j, com.baidu.tieba.recapp.n {
    private com.baidu.adp.lib.e.b<TbImageView> aHn;
    private com.baidu.tieba.frs.gametab.b bUI;
    private com.baidu.tbadk.util.t bfl;
    private com.baidu.tbadk.core.dialog.a cQu;
    private com.baidu.tieba.tbadkCore.data.e dBA;
    private VoiceManager dBD;
    private FrsModelController dBO;
    private com.baidu.tieba.frs.vc.f dBP;
    private FrsTabViewController dBQ;
    private com.baidu.tieba.frs.mc.f dBR;
    private com.baidu.tieba.frs.smartsort.b dBS;
    private com.baidu.tieba.frs.mc.b dBT;
    private an dBU;
    private com.baidu.tieba.frs.entelechy.b.b dBW;
    private com.baidu.tbadk.i.a dBX;
    private com.baidu.tieba.frs.vc.a dBY;
    private com.baidu.tieba.frs.mc.d dBZ;
    private com.baidu.tieba.frs.entelechy.b dBq;
    private int dCB;
    private com.baidu.tieba.frs.mc.c dCa;
    private com.baidu.tieba.frs.vc.h dCb;
    private com.baidu.tieba.frs.mc.a dCc;
    private com.baidu.tieba.frs.live.a dCd;
    private j dCe;
    public com.baidu.tieba.frs.vc.c dCf;
    private com.baidu.tieba.frs.mc.e dCg;
    private int dCh;
    private View.OnTouchListener dCi;
    private com.baidu.tieba.frs.view.a dCj;
    private com.baidu.tieba.frs.vc.e dCk;
    private boolean dCl;
    private com.baidu.tieba.NEGFeedBack.a dCn;
    private com.baidu.tieba.ala.a dCo;
    private com.baidu.tbadk.core.dialog.h dCp;
    private com.baidu.tieba.frs.brand.buttommenu.a dCq;
    private AddExperiencedModel dCr;
    private boolean dCt;
    public View mRootView;
    public static boolean dBv = false;
    public static volatile long dBG = 0;
    public static volatile long dBH = 0;
    public static volatile int mNetError = 0;
    public boolean dBr = false;
    private boolean dBs = false;
    private boolean dBt = false;
    private boolean dBu = true;
    public String dBw = null;
    public String mFrom = null;
    public int mFlag = 0;
    public boolean dBx = false;
    private boolean dBy = false;
    private String mThreadId = null;
    public String forumId = null;
    private int dBj = 0;
    private boolean dBz = false;
    private boolean dBB = false;
    private boolean dBC = false;
    private k dBE = null;
    public final bb bJG = null;
    private com.baidu.tieba.tbadkCore.l dBg = new com.baidu.tieba.tbadkCore.l();
    public long dhW = -1;
    public long bcv = 0;
    public long bcn = 0;
    public long createTime = 0;
    public long beginTime = -1;
    public long dBF = 0;
    public Pair<Integer, Integer> dBI = null;
    public boolean dBJ = false;
    private boolean dBK = false;
    private boolean dBL = false;
    public com.baidu.tbadk.l.b dBM = null;
    private boolean dBN = true;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> dBV = new SparseArray<>();
    private boolean bOc = true;
    private boolean dCm = false;
    private boolean hasInit = false;
    private boolean dCs = false;
    private AddExperiencedModel.a dCu = new AddExperiencedModel.a() { // from class: com.baidu.tieba.frs.FrsFragment.1
        @Override // com.baidu.tieba.share.AddExperiencedModel.a
        public void b(ContriInfo contriInfo) {
            if (contriInfo != null && contriInfo.isShowToast()) {
                FrsFragment.this.a(contriInfo);
            }
        }
    };
    private HttpMessageListener dCv = new HttpMessageListener(CmdConfigHttp.CMD_PB_FLOOR_AGREE, true) { // from class: com.baidu.tieba.frs.FrsFragment.12
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
    private final CustomMessageListener dCw = new CustomMessageListener(2016495) { // from class: com.baidu.tieba.frs.FrsFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof bb) {
                    com.baidu.tieba.frs.f.h.a(FrsFragment.this.dBE, FrsFragment.this.dBg, FrsFragment.this.getForumId(), true, (bb) data);
                }
            }
        }
    };
    private CustomMessageListener dCx = new CustomMessageListener(2921005) { // from class: com.baidu.tieba.frs.FrsFragment.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.dBg != null) {
                FrsFragment.this.dBg.bAz();
                if (FrsFragment.this.dBE != null) {
                    FrsFragment.this.dBE.notifyDataChanged();
                }
            }
        }
    };
    private CustomMessageListener dCy = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.FrsFragment.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 1) {
                    FrsFragment.this.azi();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                }
            }
        }
    };
    private final al dCz = new al() { // from class: com.baidu.tieba.frs.FrsFragment.32
        @Override // com.baidu.tieba.frs.al
        public void a(int i, int i2, ar arVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
            FrsFragment.this.azb();
            if (FrsFragment.this.dBW != null) {
                FrsFragment.this.dBP.hm(FrsFragment.this.dBW.mi(i));
            }
            d.a aVar = new d.a();
            if (arVar != null) {
                aVar.isSuccess = arVar.errCode == 0;
                aVar.errorCode = arVar.errCode;
                aVar.errorMsg = arVar.errMsg;
                if (aVar.isSuccess) {
                    if (com.baidu.tbadk.core.util.v.I(arrayList)) {
                        FrsFragment.this.dBE.ZV();
                    } else if (arVar.hasMore) {
                        if (com.baidu.tbadk.core.util.v.H(FrsFragment.this.dBg.getThreadList()) > 3) {
                            FrsFragment.this.dBE.ZT();
                        } else {
                            FrsFragment.this.dBE.aAj();
                        }
                    } else if (arVar.dFt) {
                        FrsFragment.this.dBE.ZU();
                    } else {
                        FrsFragment.this.dBE.ZV();
                    }
                }
            } else {
                arVar = new ar();
                arVar.pn = 1;
                arVar.hasMore = false;
                arVar.dFt = false;
            }
            if (i == 1) {
                FrsFragment.this.dBN = true;
                FrsFragment.this.dCL.a(FrsFragment.this.dBO.getType(), false, aVar);
            } else {
                FrsFragment.this.a(aVar);
                if (FrsFragment.this.dBO.aEa() != null) {
                    FrsFragment.this.dBg = FrsFragment.this.dBO.aEa();
                }
                FrsFragment.this.azk();
            }
            if (FrsFragment.this.dCS != null) {
                FrsFragment.this.dCS.a(i, i2, arVar, arrayList);
            }
        }
    };
    private FrsTabViewController.a dCA = new FrsTabViewController.a() { // from class: com.baidu.tieba.frs.FrsFragment.33
        @Override // com.baidu.tieba.frs.vc.FrsTabViewController.a
        public void fH(int i) {
            boolean z = false;
            if (i != 1) {
                com.baidu.tieba.card.v.anQ().fs(false);
            }
            if (i == 303 && i != FrsFragment.this.dCB) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13121").ax(ImageViewerConfig.FORUM_ID, FrsFragment.this.forumId).ax("uid", TbadkCoreApplication.getCurrentAccount()));
            }
            FrsFragment.this.dCB = i;
            FrsFragment.this.azn();
            com.baidu.tieba.frs.e.c.dJF.dUM = i;
            com.baidu.tieba.frs.e.c.dJF.dUN = -1;
            com.baidu.tieba.frs.a ayk = com.baidu.tieba.frs.a.ayk();
            if (i == 1 && FrsFragment.this.dCs) {
                z = true;
            }
            ayk.x(z, true);
        }
    };
    private CustomMessageListener dCC = new CustomMessageListener(2001606) { // from class: com.baidu.tieba.frs.FrsFragment.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                FrsFragment.this.dBQ.nk(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    };
    private CustomMessageListener dCD = new CustomMessageListener(2001607) { // from class: com.baidu.tieba.frs.FrsFragment.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && ((Integer) customResponsedMessage.getData()).intValue() == 51 && FrsFragment.this.dBg != null) {
                com.baidu.tieba.frs.f.j.a(FrsFragment.this.dBg, FrsFragment.this.getPageContext());
            }
        }
    };
    private final CustomMessageListener dCE = new CustomMessageListener(2003019) { // from class: com.baidu.tieba.frs.FrsFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                FrsFragment.this.dBQ.ni(49);
            }
        }
    };
    private final CustomMessageListener dCF = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.frs.FrsFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && FrsFragment.this.dBg != null && FrsFragment.this.dBg.ber() != null) {
                SignData signData = (SignData) customResponsedMessage.getData();
                int user_level = FrsFragment.this.dBg.ber().getUser_level();
                if (signData.forumId != null && signData.forumId.equals(FrsFragment.this.dBg.ber().getId())) {
                    FrsFragment.this.dBg.d(signData);
                    FrsFragment.this.dBP.i(FrsFragment.this.dBg);
                    if (FrsFragment.this.dBP.aFC()) {
                        i = FrsFragment.this.dBg.ber().getUser_level();
                        if (user_level >= i) {
                            i++;
                        }
                    } else {
                        i = user_level;
                    }
                    TbadkCoreApplication.getInst().addSignedForum(FrsFragment.this.dBg.ber().getName(), signData.sign_bonus_point, i);
                }
            }
        }
    };
    private final CustomMessageListener dCG = new CustomMessageListener(2001352) { // from class: com.baidu.tieba.frs.FrsFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.r) && FrsFragment.this.dBg != null) {
                FrsFragment.this.dBg.c((com.baidu.tieba.tbadkCore.r) customResponsedMessage.getData());
                FrsFragment.this.dBP.h(FrsFragment.this.dBg);
                FrsFragment.this.dBQ.a(FrsFragment.this.dBg, FrsFragment.this.dBO.aEG());
            }
        }
    };
    private final AntiHelper.a dCH = new AntiHelper.a() { // from class: com.baidu.tieba.frs.FrsFragment.5
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12536").x("obj_locate", as.a.azn));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12535").x("obj_locate", as.a.azn));
        }
    };
    private CustomMessageListener bRt = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.frs.FrsFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(FrsFragment.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().aLS != null) {
                        if (AntiHelper.a(FrsFragment.this.getActivity(), updateAttentionMessage.getData().aLS, FrsFragment.this.dCH) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12534").x("obj_locate", as.a.azn));
                        }
                    } else if (updateAttentionMessage.getData().Jr && updateAttentionMessage.getData().isAttention) {
                        com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getPageContext().getPageActivity(), e.j.attention_success);
                    }
                }
            }
        }
    };
    private CustomMessageListener dCI = new CustomMessageListener(2921346) { // from class: com.baidu.tieba.frs.FrsFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsFragment.this.refresh();
        }
    };
    private CustomMessageListener dCJ = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.frs.FrsFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                FrsFragment.this.dBE.c((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener dCK = new CustomMessageListener(2001626) { // from class: com.baidu.tieba.frs.FrsFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewsRemindMessage newsRemindMessage;
            if (customResponsedMessage != null && (customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626 && (newsRemindMessage = (NewsRemindMessage) customResponsedMessage) != null) {
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (FrsFragment.this.dBE != null) {
                    FrsFragment.this.dBE.p(notificationCount, z);
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.n dCL = new com.baidu.tieba.tbadkCore.n() { // from class: com.baidu.tieba.frs.FrsFragment.10
        private long startTime = 0;

        @Override // com.baidu.tieba.tbadkCore.n
        public void lI(int i) {
            this.startTime = System.nanoTime();
            if (FrsFragment.this.dBE != null) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsFragment.this.dBE.azV();
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
            if (FrsFragment.this.bOc) {
                FrsFragment.this.bOc = false;
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.dBE, FrsFragment.this.dBg, FrsFragment.this.getForumId(), false, null);
            }
            FrsFragment.this.azb();
            FrsFragment.this.dBK = true;
            if (aVar != null && aVar.isSuccess) {
                FrsFragment.this.dBE.aAf().gY(com.baidu.tbadk.core.util.aq.CN().CP());
                FrsFragment.dBG = 0L;
                FrsFragment.dBH = 0L;
                FrsFragment.mNetError = 0;
            } else {
                FrsFragment.mNetError = 1;
            }
            if (!FrsFragment.this.dBO.aEK() && (i == 3 || i == 6)) {
                FrsFragment.this.dCa.resetData();
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (FrsFragment.this.dBO.aEa() != null) {
                FrsFragment.this.dBg = FrsFragment.this.dBO.aEa();
            }
            FrsFragment.this.dBE.b(FrsFragment.this.dBg.bAh());
            FrsFragment.this.lF(1);
            if (i == 7) {
                FrsFragment.this.lG(FrsFragment.this.dBg.bzM());
                return;
            }
            if (FrsFragment.this.dBg.xO() != null) {
                FrsFragment.this.setHasMore(FrsFragment.this.dBg.xO().xL());
            }
            if (i == 4) {
                if (!FrsFragment.this.dBO.aEK() && TbadkCoreApplication.getInst().isRecAppExist() && FrsFragment.this.dBO.aEA() == 1) {
                    FrsFragment.this.dBg.a(FrsFragment.this);
                }
                ArrayList<com.baidu.adp.widget.ListView.h> a2 = FrsFragment.this.dCa.a(false, false, FrsFragment.this.dBg.getThreadList(), FrsFragment.this.dBA, false);
                if (a2 != null) {
                    FrsFragment.this.dBg.ax(a2);
                    FrsFragment.this.dBg.bAq();
                    FrsFragment.this.dBE.a(a2, FrsFragment.this.dBg);
                }
                if (FrsFragment.this.dBO != null) {
                    com.baidu.tieba.frs.e.b.a(FrsFragment.this.dBg, FrsFragment.this.dBO.aEG(), 2);
                }
                com.baidu.tieba.frs.f.a.a(FrsFragment.this, FrsFragment.this.dBg.ber(), FrsFragment.this.dBg.getThreadList(), false, FrsFragment.this.getPn());
                FrsFragment.this.bcv = System.currentTimeMillis() - currentTimeMillis;
                FrsFragment.this.azc();
                return;
            }
            FrsFragment.this.azc();
            switch (i) {
                case 1:
                    FrsFragment.this.dBE.azV();
                    break;
                case 2:
                    FrsFragment.this.dBE.azV();
                    break;
                case 3:
                case 6:
                    if (FrsFragment.this.dBg != null) {
                        FrsFragment.this.dBg.bAo();
                    }
                    if (FrsFragment.this.dCf != null) {
                        FrsFragment.this.dCf.refresh();
                        break;
                    }
                    break;
            }
            FrsFragment.this.azd();
            if (aVar == null || aVar.errorCode == 0) {
                if (FrsFragment.this.dBg != null) {
                    FrsFragment.this.A(false, i == 5);
                    FrsFragment.this.dBE.lQ(i);
                    FrsFragment.dBG = (System.nanoTime() - this.startTime) / 1000000;
                    if (aVar != null) {
                        FrsFragment.dBH = aVar.haZ;
                    }
                } else {
                    return;
                }
            } else if (FrsFragment.this.dBg == null || com.baidu.tbadk.core.util.v.I(FrsFragment.this.dBg.getThreadList())) {
                FrsFragment.this.a(aVar);
            } else if (aVar.haY) {
                FrsFragment.this.showToast(FrsFragment.this.getPageContext().getResources().getString(e.j.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
            }
            if (FrsFragment.this.dBg.bzw() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11384"));
            }
            if (FrsFragment.this.dhW > -1 && !FrsFragment.this.dCm) {
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.dBO, FrsFragment.this.dhW);
                FrsFragment.this.dhW = -1L;
                FrsFragment.this.dCm = true;
            }
            if (FrsFragment.this.dBB && FrsFragment.this.dBQ.ni(49)) {
                FrsFragment.this.dBB = false;
            }
            FrsFragment.this.bcv = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void b(com.baidu.tieba.tbadkCore.i iVar) {
            if ((iVar != null && ("normal_page".equals(FrsFragment.this.dBO.getPageType()) || "frs_page".equals(FrsFragment.this.dBO.getPageType()) || "book_page".equals(FrsFragment.this.dBO.getPageType()))) || "brand_page".equals(FrsFragment.this.dBO.getPageType())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001615, iVar));
                FrsFragment.this.a(iVar);
            }
        }
    };
    private final CustomMessageListener dCM = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.frs.FrsFragment.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                FrsFragment.this.dBg.a((com.baidu.tbadk.data.j) customResponsedMessage.getData());
                FrsFragment.this.dBE.aAf().notifyDataSetChanged();
            }
        }
    };
    private final CustomMessageListener mMemListener = new CustomMessageListener(2001194) { // from class: com.baidu.tieba.frs.FrsFragment.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && FrsFragment.this.dBg != null && (userData = FrsFragment.this.dBg.getUserData()) != null) {
                userData.setIsMem(num.intValue());
                if (num.intValue() != 0) {
                    FrsFragment.this.dBP.g(num);
                }
            }
        }
    };
    private final com.baidu.tieba.frs.mc.i dCN = new com.baidu.tieba.frs.mc.i() { // from class: com.baidu.tieba.frs.FrsFragment.17
        @Override // com.baidu.tieba.frs.mc.i
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.h> arrayList, boolean z3) {
            if (FrsFragment.this.dBS != null && FrsFragment.this.dBO != null && FrsFragment.this.dBO.aEK() && z && !z2 && !z3) {
                FrsFragment.this.dBS.mN(i2);
            }
        }
    };
    public final View.OnTouchListener bfm = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.FrsFragment.18
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (FrsFragment.this.dCi != null) {
                FrsFragment.this.dCi.onTouch(view, motionEvent);
            }
            if (FrsFragment.this.dBU != null && FrsFragment.this.dBU.aAQ() != null) {
                FrsFragment.this.dBU.aAQ().onTouchEvent(motionEvent);
            }
            if (FrsFragment.this.bUI != null) {
                FrsFragment.this.bUI.d(view, motionEvent);
            }
            if (FrsFragment.this.dBP != null) {
                FrsFragment.this.dBP.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private final CustomMessageListener dCO = new CustomMessageListener(2004507) { // from class: com.baidu.tieba.frs.FrsFragment.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "photolive_hostLevel", -1) != -1 && FrsFragment.this.dBg.ber() != null) {
                FrsFragment.this.dBg.ber().setCanAddPhotoLivePost(true);
            }
        }
    };
    public final View.OnClickListener dCP = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.21
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsFragment.this.dBE == null || view != FrsFragment.this.dBE.azT() || FrsFragment.this.getActivity() == null) {
                if (FrsFragment.this.dBg != null && FrsFragment.this.dBg.ber() != null && FrsFragment.this.dBE != null && view == FrsFragment.this.dBE.azZ()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12402").ax(ImageViewerConfig.FORUM_ID, FrsFragment.this.dBg.ber().getId()).ax("uid", TbadkCoreApplication.getCurrentAccount()).ax(ImageViewerConfig.FORUM_NAME, FrsFragment.this.dBg.ber().getName()));
                    if (!StringUtils.isNull(FrsFragment.this.dBg.ber().getName())) {
                        FrsFragment.this.sendMessage(new CustomMessage(2002001, new PostSearchActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), FrsFragment.this.dBg.ber().getName(), FrsFragment.this.dBg.ber().getId())));
                        return;
                    }
                    return;
                }
                if (view.getId() == e.g.game_activity_egg_layout && com.baidu.adp.lib.util.l.lm()) {
                    TiebaStatic.log("c10853");
                    if (FrsFragment.this.dBE.aAc()) {
                        FrsFragment.this.dBE.aAd();
                    } else {
                        String activityUrl = FrsFragment.this.dBg.ber().getYuleData().Au().getActivityUrl();
                        if (!StringUtils.isNull(activityUrl)) {
                            com.baidu.tbadk.browser.a.ae(FrsFragment.this.getPageContext().getPageActivity(), activityUrl);
                        }
                    }
                }
                if (view == FrsFragment.this.dBE.aAk() && FrsFragment.this.dBO != null && FrsFragment.this.dBO.hasMore()) {
                    FrsFragment.this.dBE.ZT();
                    FrsFragment.this.YV();
                }
                if (view != null && view == FrsFragment.this.dBE.aAa() && ba.bG(FrsFragment.this.getContext())) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12924").x("obj_locate", 2));
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
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.FrsFragment.22
        private int dCW = 0;
        private int bJl = 0;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (FrsFragment.this.dBY != null) {
                FrsFragment.this.dBY.aFh();
            }
            this.dCW = 0;
            this.bJl = 0;
            if (recyclerView != null && (recyclerView instanceof BdRecyclerView)) {
                this.dCW = ((BdRecyclerView) recyclerView).getFirstVisiblePosition();
                this.bJl = ((BdRecyclerView) recyclerView).getLastVisiblePosition();
            }
            if (FrsFragment.this.dCk != null) {
                FrsFragment.this.dCk.a(recyclerView, this.dCW, this.bJl);
            }
            if (FrsFragment.this.dBg != null && FrsFragment.this.dBE != null && FrsFragment.this.dBE.aAf() != null) {
                FrsFragment.this.dBE.aL(this.dCW, this.bJl);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (FrsFragment.this.dBP != null) {
                FrsFragment.this.dBP.setScrollState(i);
            }
            if ((i == 2 || i == 1) && !FrsFragment.this.dBL) {
                FrsFragment.this.dBL = true;
                FrsFragment.this.dBE.aAi();
            }
            if (FrsFragment.this.dBM == null && !FrsFragment.this.azr()) {
                FrsFragment.this.dBM = new com.baidu.tbadk.l.b();
                FrsFragment.this.dBM.fU(1000);
            }
            if (i == 0) {
                if (FrsFragment.this.dBM != null) {
                    FrsFragment.this.dBM.NX();
                }
                com.baidu.tieba.card.v.anQ().fs(true);
                FrsFragment.this.dBE.aK(this.dCW, this.bJl);
            } else if (FrsFragment.this.dBM != null) {
                FrsFragment.this.dBM.NW();
            }
            if (FrsFragment.this.dCk != null) {
                FrsFragment.this.dCk.onScrollStateChanged(recyclerView, i);
            }
            if (i == 0) {
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.dBE, FrsFragment.this.dBg, FrsFragment.this.getForumId(), false, null);
            }
            if (FrsFragment.this.dBQ != null && i == 1) {
                FrsFragment.this.dBQ.aFM();
            }
        }
    };
    private final d dCQ = new d() { // from class: com.baidu.tieba.frs.FrsFragment.24
        @Override // com.baidu.tieba.frs.d
        public void a(int i, int i2, View view, View view2, bb bbVar) {
            if (i != FrsFragment.this.dBE.aAf().aCc()) {
                if (i != FrsFragment.this.dBE.aAf().aCd()) {
                    if (i == FrsFragment.this.dBE.aAf().aCe() && FrsFragment.this.dBg != null && FrsFragment.this.dBg.getUserData() != null && FrsFragment.this.dBg.getUserData().isBawu()) {
                        String bzK = FrsFragment.this.dBg.bzK();
                        if (!com.baidu.tbadk.core.util.ao.isEmpty(bzK) && FrsFragment.this.dBg.ber() != null) {
                            com.baidu.tbadk.browser.a.ac(FrsFragment.this.getPageContext().getPageActivity(), bzK);
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10502").ax(ImageViewerConfig.FORUM_ID, FrsFragment.this.dBg.ber().getId()).ax("uid", FrsFragment.this.dBg.getUserData().getUserId()));
                        }
                    }
                } else if (ba.bG(FrsFragment.this.getPageContext().getPageActivity())) {
                    TiebaStatic.log("my_service_ck");
                    if (FrsFragment.this.dBg != null && FrsFragment.this.dBg.ber() != null) {
                        ForumData ber = FrsFragment.this.dBg.ber();
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(ber.getId(), 0L), ber.getName(), ber.getImage_url(), 0)));
                    }
                }
            } else if (ba.bG(FrsFragment.this.getActivity())) {
                TiebaStatic.log("forum_fortune_click");
                com.baidu.tieba.frs.f.i.b(FrsFragment.this.getPageContext(), FrsFragment.this.dBg);
            }
        }
    };
    private final NoNetworkView.a dzq = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.FrsFragment.25
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bE(boolean z) {
            if (FrsFragment.this.dBO.aEA() == 1 && z && !FrsFragment.this.dBE.azq()) {
                if (FrsFragment.this.dBg == null || com.baidu.tbadk.core.util.v.I(FrsFragment.this.dBg.getThreadList())) {
                    FrsFragment.this.hideNetRefreshView(FrsFragment.this.dBE.aAg());
                    FrsFragment.this.showLoadingView(FrsFragment.this.dBE.aAg(), true);
                    FrsFragment.this.dBE.gy(false);
                    FrsFragment.this.refresh();
                    return;
                }
                FrsFragment.this.dBE.azV();
            }
        }
    };
    private final CustomMessageListener aMv = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.FrsFragment.26
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                com.baidu.tieba.frs.f.c.a(customResponsedMessage, FrsFragment.this.dBE, FrsFragment.this.dBg);
            }
        }
    };
    private com.baidu.adp.widget.ListView.n dCR = new a();
    private al dCS = new al() { // from class: com.baidu.tieba.frs.FrsFragment.27
        @Override // com.baidu.tieba.frs.al
        public void a(int i, int i2, ar arVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
            com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.27.1
                @Override // java.lang.Runnable
                public void run() {
                    if (FrsFragment.this.dBE != null && FrsFragment.this.dBE.aoM()) {
                        FrsFragment.this.YV();
                    }
                }
            });
        }
    };
    private CustomMessageListener dCT = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.frs.FrsFragment.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    FrsFragment.this.dCl = true;
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.frs.loadmore.a
    public /* bridge */ /* synthetic */ com.baidu.adp.base.e getPageContext() {
        return super.getPageContext();
    }

    public com.baidu.tieba.frs.entelechy.b.b ayP() {
        return this.dBW;
    }

    public com.baidu.adp.widget.ListView.n ayQ() {
        return this.dCR;
    }

    public com.baidu.tieba.frs.mc.d ayR() {
        return this.dBZ;
    }

    public com.baidu.tieba.frs.smartsort.b ayS() {
        return this.dBS;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public FrsModelController ayT() {
        return this.dBO;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public com.baidu.tieba.frs.mc.c ayU() {
        return this.dCa;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public com.baidu.tieba.frs.vc.f ayV() {
        return this.dBP;
    }

    public com.baidu.tieba.frs.vc.k ayW() {
        return this.dBQ;
    }

    public an ayX() {
        return this.dBU;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public k ayY() {
        return this.dBE;
    }

    @Override // com.baidu.tieba.frs.am
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.am, com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.dBw;
    }

    public void setForumName(String str) {
        this.dBw = str;
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
        if (this.dCa == null) {
            return 1;
        }
        return this.dCa.getPn();
    }

    public int getPn() {
        if (this.dCa == null) {
            return 1;
        }
        return this.dCa.getPn();
    }

    public void setPn(int i) {
        if (this.dCa != null) {
            this.dCa.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.dCa != null) {
            this.dCa.setHasMore(i);
        }
    }

    public int ayZ() {
        if (this.dCa == null) {
            return -1;
        }
        return this.dCa.ayZ();
    }

    public boolean aza() {
        return this.dBC;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d.a aVar) {
        if (aVar == null) {
            String string = TbadkCoreApplication.getInst().getString(e.j.error_unkown_try_again);
            this.dBE.azQ();
            showNetRefreshView(this.dBE.aAg(), string, true);
        } else if (340001 == aVar.errorCode) {
            a(aVar, this.dBg.bzt());
        } else {
            if (com.baidu.tbadk.core.util.v.I(this.dBg.getThreadList())) {
                b(aVar);
            }
            if (azr()) {
                setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst(), e.C0200e.ds280));
            } else {
                setNetRefreshViewEmotionDefMarginTop();
            }
        }
    }

    public void a(View view, String str, boolean z, List<RecmForumInfo> list) {
        this.dBE.azQ();
        this.dBE.lM(8);
        if (this.dCj == null) {
            this.dCj = new com.baidu.tieba.frs.view.a(getPageContext(), getNetRefreshListener());
        }
        this.dCj.hV(str);
        this.dCj.bQ(list);
        this.dCj.attachView(view, z);
    }

    private void a(d.a aVar, List<RecmForumInfo> list) {
        if (this.dBE != null) {
            this.dBE.azQ();
            this.dBE.setTitle(this.dBw);
            a(this.dBE.aAg(), aVar.errorMsg, true, list);
        }
    }

    private void b(d.a aVar) {
        this.dBE.azQ();
        if (aVar.haY) {
            showNetRefreshView(this.dBE.aAg(), TbadkCoreApplication.getInst().getString(e.j.net_error_text, new Object[]{aVar.errorMsg, Integer.valueOf(aVar.errorCode)}), true);
        } else {
            showNetRefreshView(this.dBE.aAg(), aVar.errorMsg, true);
        }
    }

    public void azb() {
        hideLoadingView(this.dBE.aAg());
        if (!this.dBE.azq()) {
            this.dBE.gz(false);
        } else {
            this.dBE.gz(true);
        }
        if (this.dBE.azO() instanceof com.baidu.tieba.frs.tab.c) {
            ((com.baidu.tieba.frs.tab.c) this.dBE.azO()).aFc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azc() {
        if (ayZ() == 0 && com.baidu.tbadk.core.util.v.I(this.dBg.bzC())) {
            if (com.baidu.tbadk.core.util.v.I(this.dBg.getThreadList())) {
                this.dBE.ZV();
            } else {
                this.dBE.ZU();
            }
        } else if (com.baidu.tbadk.core.util.v.H(this.dBg.getThreadList()) > 3) {
            this.dBE.ZT();
        } else {
            this.dBE.aAj();
        }
    }

    public void a(ErrorData errorData) {
        azb();
        this.dBE.azV();
        d.a aEx = this.dBO.aEx();
        boolean I = com.baidu.tbadk.core.util.v.I(this.dBg.getThreadList());
        if (aEx != null && I) {
            if (this.dBO.aEy() != 0) {
                this.dBO.aEE();
                this.dBE.azV();
            } else {
                a(aEx);
            }
            this.dBE.B(this.dBg.bAG(), false);
            return;
        }
        a(aEx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lF(int i) {
        List<WindowToast> list;
        if (TbadkCoreApplication.isLogin() && this.dBg != null && (list = this.dBg.hcC) != null && list.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < list.size()) {
                    WindowToast windowToast = list.get(i3);
                    if (windowToast == null || windowToast.toast_type.intValue() != i) {
                        i2 = i3 + 1;
                    } else if (!com.baidu.tbadk.core.util.ao.isEmpty(windowToast.toast_link)) {
                        sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(getPageContext().getPageActivity(), "", com.baidu.tbadk.util.ab.iy(windowToast.toast_link), true)));
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
    public void azd() {
        if (this.dBg == null || this.dBg.ber() != null) {
            this.dBE.aAe();
        } else if (this.dBg.ber().getYuleData() != null && this.dBg.ber().getYuleData().At()) {
            TiebaStatic.log("c10852");
            this.dBE.a(this.dBg.ber().getYuleData().Au());
        } else {
            this.dBE.aAe();
        }
    }

    private void z(boolean z, boolean z2) {
        if (this.dBO != null && this.dBg != null && this.dBE != null && z) {
            if (!this.dBO.aEK() && this.dBO.aEA() == 1) {
                if (!this.dBO.aEI()) {
                    this.dBg.bAw();
                    this.dBg.bAx();
                }
                boolean z3 = false;
                if (this.dBE.aAf().k(com.baidu.tieba.card.data.n.cRJ)) {
                    z3 = this.dBg.bAA();
                }
                if (!z3) {
                    this.dBg.bAy();
                }
                if (TbadkCoreApplication.getInst().isRecAppExist()) {
                    this.dBg.a(this);
                }
                if (!this.dBE.aAf().k(bb.apK)) {
                    this.dBg.bAp();
                }
                this.dBg.bAB();
            }
            if (!this.dBE.aAf().k(bb.apK)) {
                this.dBg.bAv();
                this.dBg.bAt();
            } else {
                this.dBg.bAu();
                this.dBg.bAs();
            }
            this.dBg.bAq();
            this.dBg.bAn();
            if (this.dBE.aAf().k(com.baidu.tieba.h.b.edS)) {
                this.dBg.no(z2);
            }
            if (TbadkCoreApplication.isLogin() && (!this.dBO.aEK() || this.dBO.isNetFirstLoad)) {
                this.dBg.bAC();
            }
            this.dBg.bAE();
        }
    }

    public boolean aze() {
        if (this.dBP != null && this.dBO != null) {
            this.dBP.a(this.dBO.getPageType(), this.dBg);
        }
        boolean z = false;
        if (this.dBg != null) {
            z = this.dBg.bAH();
        }
        azg();
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lG(int i) {
        ao aoVar = null;
        aze();
        azn();
        try {
            if (this.dBg != null) {
                this.dBE.a((ArrayList<com.baidu.adp.widget.ListView.h>) null, this.dBg);
                this.dBP.nd(1);
                this.dBE.azY();
                this.dBQ.a(this.dBg, this.dBO.aEG());
                com.baidu.tieba.frs.tab.d nj = this.dBQ.nj(this.dBg.bzM());
                if (nj != null && !TextUtils.isEmpty(nj.url)) {
                    aoVar = new ao();
                    aoVar.dFq = nj.url;
                    aoVar.stType = nj.name;
                }
                this.dBO.a(this.dBg.bzM(), 0, aoVar);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(boolean z, boolean z2) {
        try {
            if (this.dBg != null && this.dBQ != null && this.dBO != null) {
                if (!this.dBE.aAf().k(bb.apK)) {
                    this.dBg.bAp();
                }
                boolean I = com.baidu.tbadk.core.util.v.I(this.dBg.bAa());
                this.dBE.gw(I);
                if (!I) {
                    if (this.dCk == null) {
                        this.dCk = new com.baidu.tieba.frs.vc.e(this, (NoPressedRelativeLayout) this.mRootView);
                    }
                    if (this.bUI == null) {
                        this.bUI = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
                    }
                } else {
                    this.dCk = null;
                    this.bUI = null;
                }
                if (this.dBg.ber() != null) {
                    this.dBw = this.dBg.ber().getName();
                    this.forumId = this.dBg.ber().getId();
                }
                if (this.dBg.bAH()) {
                    this.dBQ.a(this.dBg, this.dBO.aEG());
                }
                if (z) {
                    z(true, z);
                } else {
                    z(this.dBN, z);
                }
                aze();
                if (this.dBW != null) {
                    this.dBW.a(this.dBP, this.dBg);
                }
                if (this.dBg.xO() != null) {
                    setHasMore(this.dBg.xO().xL());
                }
                ArrayList<com.baidu.adp.widget.ListView.h> a2 = this.dCa.a(z2, true, this.dBg.getThreadList(), null, z, false);
                if (a2 != null) {
                    this.dBg.ax(a2);
                }
                this.dBg.bAD();
                if (this.dBO.aEA() == 1) {
                    azk();
                    if (!z && this.dBO.getPn() == 1) {
                        azf();
                    }
                }
                this.dBj = this.dBg.aEC();
                if (this.dBA != null) {
                    this.dBz = true;
                    this.dBA.uV(this.dBj);
                    com.baidu.tieba.frs.f.a.a(this, this.dBg.ber(), this.dBg.getThreadList(), this.dBz, getPn());
                }
                if (this.dBY != null) {
                    this.dBY.aS(this.dBQ.aFJ());
                }
                azb();
                this.dBE.azR();
                this.dBE.B(true, false);
                if (this.dBg.ber() != null) {
                    this.dBE.nB(this.dBg.ber().getWarningMsg());
                }
                if (this.dBg != null && this.dBg.bAd() != null && com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("frs_video_activity_guide", 0L) == 0) {
                    com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.11
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsFragment.this.dBE.aAo();
                        }
                    }, 1000L);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2921326, this));
                this.dBE.azK();
                if (this.dBg != null && this.dBg.ber() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016564, new VisitedForumData(this.dBg.ber().getId(), this.dBg.ber().getName(), this.dBg.ber().getImage_url(), String.valueOf(System.currentTimeMillis() / 1000), "showlive".equals(this.dBg.ber().special_forum_type))));
                }
                this.dCq.a(this.dBg.hcH, this.dBg.ber());
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void azf() {
        if (this.dCd == null) {
            this.dCd = new com.baidu.tieba.frs.live.a(this, com.baidu.adp.lib.g.b.l(this.forumId, 0));
        }
        this.dCd.aEi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.i iVar) {
        try {
            if (!this.dBK && iVar != null && this.dBg != null) {
                this.dBg.g(iVar);
                A(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void azg() {
        if (this.dBO != null) {
            nz(this.dBO.getPageType());
        } else {
            nz("normal_page");
        }
    }

    private void nz(String str) {
        gp("frs_page".equals(str));
        if (this.dBW != null) {
            this.dBW.a(this.dBP, this.dBE, this.dBg);
        }
    }

    public void gp(boolean z) {
        if (this.dCb != null) {
            this.dCb.c(this.dBE, z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(e.h.frs_activity, viewGroup, false);
            this.dBq = new com.baidu.tieba.frs.entelechy.b();
            this.dBW = this.dBq.aBD();
            this.dBP = new com.baidu.tieba.frs.vc.f(this, this.dBq, (FrsHeaderViewContainer) this.mRootView.findViewById(e.g.header_view_container));
            this.dBQ = new FrsTabViewController(this, this.mRootView);
            this.dBQ.registerListener();
            this.dBP.a(this.dBQ);
            this.dBQ.a(this.dCA);
            Intent intent = getActivity().getIntent();
            if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                this.dBs = true;
            }
            this.dBE = new k(this, this.dCP, this.dBq, this.dBs, this.dBP);
            this.dBE.setHeaderViewHeight(this.dCh);
            this.dCq = new com.baidu.tieba.frs.brand.buttommenu.a(getPageContext(), this.mRootView);
        } else {
            if (this.mRootView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            if (this.dBQ != null) {
                this.dBQ.registerListener();
            }
            this.dBE.aAn();
        }
        this.dCt = true;
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        this.dhW = System.currentTimeMillis();
        this.beginTime = this.dhW;
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.dBB = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.dhW = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            M(intent);
        }
        this.bcn = this.beginTime - this.dhW;
        this.dBA = new com.baidu.tieba.tbadkCore.data.e("frs", com.baidu.tieba.tbadkCore.data.e.hdR);
        this.dBO = new FrsModelController(this, this.dCL);
        this.dBO.a(this.dCz);
        this.dBO.init();
        if (intent != null) {
            this.dBO.m(intent.getExtras());
        } else if (bundle != null) {
            this.dBO.m(bundle);
        } else {
            this.dBO.m(null);
        }
        if (intent != null) {
            this.dBP.q(intent.getExtras());
        } else if (bundle != null) {
            this.dBP.q(bundle);
        } else {
            this.dBP.q((Bundle) null);
        }
        this.dBD = getVoiceManager();
        this.dCe = new j(getPageContext(), this);
        initUI();
        initData(bundle);
        if (!azr()) {
            this.dBU = new an(getActivity(), this.dBE, this.dBP);
            this.dBU.gN(true);
        }
        this.dBD = getVoiceManager();
        if (this.dBD != null) {
            this.dBD.onCreate(getPageContext());
        }
        new com.baidu.tieba.frs.mc.g();
        this.dCa = new com.baidu.tieba.frs.mc.c(this, this.dCN);
        this.dBS = new com.baidu.tieba.frs.smartsort.b(this);
        this.dCb = new com.baidu.tieba.frs.vc.h(this);
        this.dBY = new com.baidu.tieba.frs.vc.a(getPageContext(), this.dBO.aEH());
        this.dBT = new com.baidu.tieba.frs.mc.b(this);
        this.dBZ = new com.baidu.tieba.frs.mc.d(this);
        this.dBR = new com.baidu.tieba.frs.mc.f(this);
        this.dCc = new com.baidu.tieba.frs.mc.a(this);
        this.dCf = new com.baidu.tieba.frs.vc.c(this);
        this.dCg = new com.baidu.tieba.frs.mc.e(this, getUniqueId());
        this.dCn = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "frs");
        this.dCo = new com.baidu.tieba.ala.a(getPageContext());
        registerListener(this.bRt);
        registerListener(this.mMemListener);
        registerListener(this.dCG);
        registerListener(this.dCO);
        registerListener(this.dCF);
        registerListener(this.dCM);
        registerListener(this.dCC);
        registerListener(this.dCD);
        registerListener(this.dCE);
        registerListener(this.dCw);
        registerListener(this.dCx);
        registerListener(this.dCT);
        registerListener(this.dCJ);
        registerListener(this.dCy);
        registerListener(this.dCK);
        registerListener(this.dCI);
        this.dCv.setTag(getPageContext().getUniqueId());
        registerListener(this.dCv);
        this.dBE.gy(false);
        if (!azr() && !this.hasInit) {
            showLoadingView(this.dBE.aAg(), true);
            this.dBO.r(3, false);
        }
        com.baidu.tieba.frs.a.ayk().a(new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.15
            @Override // com.baidu.tieba.frs.a.b
            public void y(boolean z, boolean z2) {
                if (FrsFragment.this.dBE != null) {
                    FrsFragment.this.dBE.lN(z ? 0 : 8);
                    if (!z2) {
                        FrsFragment.this.dCs = z;
                    }
                    if (FrsFragment.this.dBE.aAf() != null && FrsFragment.this.dBO != null && FrsFragment.this.dBO.aEB()) {
                        FrsFragment.this.dBE.aAf().notifyDataSetChanged();
                    }
                    if (FrsFragment.this.dBE.azP() != null) {
                        FrsFragment.this.dBE.gv(!z);
                    }
                    if (FrsFragment.this.getActivity() instanceof FrsActivity) {
                        ((FrsActivity) FrsFragment.this.getActivity()).go(!z);
                    }
                    if (FrsFragment.this.dCq != null) {
                        FrsFragment.this.dCq.gW(!z);
                    }
                    FrsFragment.this.dBE.gA(!z);
                    FrsFragment.this.dBE.gB(z ? false : true);
                }
            }

            @Override // com.baidu.tieba.frs.a.b
            public void lC(int i) {
                if (FrsFragment.this.dBE != null) {
                    FrsFragment.this.dBE.lO(i);
                }
            }

            @Override // com.baidu.tieba.frs.a.b
            public void ayq() {
                com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getContext(), e.j.frs_multi_delete_max_num);
            }
        });
        this.dBE.b(new d.a() { // from class: com.baidu.tieba.frs.FrsFragment.16
            @Override // com.baidu.tieba.NEGFeedBack.d.a
            public void a(DeleteThreadHttpResponseMessage deleteThreadHttpResponseMessage) {
                int i;
                int i2 = 0;
                if (deleteThreadHttpResponseMessage != null) {
                    FrsFragment.this.dBE.Tt();
                    FrsFragment.this.dBE.aAp();
                    if (deleteThreadHttpResponseMessage.getError() == 0) {
                        String text = !TextUtils.isEmpty(deleteThreadHttpResponseMessage.getText()) ? deleteThreadHttpResponseMessage.getText() : FrsFragment.this.getString(e.j.delete_fail);
                        if (deleteThreadHttpResponseMessage.getRetType() == 1211066) {
                            if (FrsFragment.this.cQu == null) {
                                FrsFragment.this.cQu = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.cQu.ej(text);
                            FrsFragment.this.cQu.a(e.j.dialog_known, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.16.1
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.cQu.bf(false);
                            FrsFragment.this.cQu.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.cQu.AB();
                        } else if (deleteThreadHttpResponseMessage.getRetType() == 1211067) {
                            if (FrsFragment.this.cQu == null) {
                                FrsFragment.this.cQu = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.cQu.ej(text);
                            FrsFragment.this.cQu.a(e.j.know, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.16.2
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.cQu.bf(false);
                            FrsFragment.this.cQu.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.cQu.AB();
                        } else {
                            FrsFragment.this.dBE.ab(deleteThreadHttpResponseMessage.getText(), ContextCompat.getColor(FrsFragment.this.getContext(), deleteThreadHttpResponseMessage.getRetType() == 1 ? e.d.nav_bar_tip_error : e.d.cp_link_tip_a_alpha95));
                        }
                        FrsFragment.this.bA(deleteThreadHttpResponseMessage.getSuccessItems());
                        com.baidu.tieba.frs.a.ayk().bz(deleteThreadHttpResponseMessage.getSuccessItems());
                        Iterator<com.baidu.adp.widget.ListView.h> it = FrsFragment.this.dBg.getThreadList().iterator();
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
                            FrsFragment.this.YV();
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

    public void gq(boolean z) {
        if (this.dBQ != null) {
            this.dBQ.dXu = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bA(List<String> list) {
        if (!com.baidu.tbadk.core.util.v.I(list)) {
            ArrayList<com.baidu.adp.widget.ListView.h> threadList = this.dBg.getThreadList();
            if (!com.baidu.tbadk.core.util.v.I(threadList) && this.dBE.getListView() != null && this.dBE.getListView().getData() != null) {
                Iterator<com.baidu.adp.widget.ListView.h> it = threadList.iterator();
                List<com.baidu.adp.widget.ListView.h> data = this.dBE.getListView().getData();
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
                                this.dCa.ab(bbVar);
                                this.dBE.getListView().getAdapter().notifyItemRemoved(i);
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
    public void Zv() {
        if (isAdded() && this.bOc && !isLoadingViewAttached()) {
            showLoadingView(this.dBE.aAg(), true);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void Zw() {
        if (isAdded() && this.bOc && isLoadingViewAttached()) {
            hideLoadingView(this.dBE.aAg());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (azr()) {
            showLoadingView(this.dBE.aAg(), true);
            this.dBE.lP(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.dBO.r(3, true);
            Eq().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void setHeaderViewHeight(int i) {
        this.dCh = i;
        if (this.dBE != null) {
            this.dBE.setHeaderViewHeight(this.dCh);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.u uVar) {
        if (uVar != null) {
            this.bfl = uVar.OX();
            this.dCi = uVar.OY();
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void showFloatingView() {
        if (this.bfl != null) {
            this.bfl.cR(true);
        }
    }

    private void M(Intent intent) {
        if (intent != null) {
            if (!com.baidu.tieba.frs.f.f.a(this, getForumName(), "from", intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false)) && getActivity() != null) {
                getActivity().finish();
                return;
            }
        }
        if (intent != null && intent.getData() != null) {
            Uri data = intent.getData();
            this.dBw = data.getQueryParameter("name");
            this.mFrom = data.getQueryParameter("from");
            if (!StringUtils.isNull(this.dBw)) {
                intent.putExtra("name", this.dBw);
            }
            if (!StringUtils.isNull(this.mFrom)) {
                intent.putExtra("from", this.mFrom);
            }
            TiebaStatic.log("c10105");
        }
        if (StringUtils.isNull(this.dBw)) {
            com.baidu.tieba.frs.f.d O = com.baidu.tieba.frs.f.i.O(intent);
            if (O != null) {
                this.dBw = O.forumName;
                if (O.dVN != null && O.dVN.equals("aidou")) {
                    com.baidu.tbadk.core.dialog.h.atH = System.currentTimeMillis();
                }
            }
            if (!StringUtils.isNull(this.dBw)) {
                intent.putExtra("name", this.dBw);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.dBD = getVoiceManager();
        if (this.dBD != null) {
            this.dBD.onStart(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        Intent intent;
        registerListener(2001118, this.aMv);
        if (bundle != null) {
            this.dBw = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
            this.dBw = intent.getStringExtra("name");
            this.mFrom = intent.getStringExtra("from");
            this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
        }
        if (getArguments() != null) {
            this.dBx = getArguments().getBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, false);
        }
        if (TextUtils.isEmpty(this.mFrom) || FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
        }
        if (this.mIsLogin) {
            registerListener(2001120, this.aMv);
        }
        this.dBP.q(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        this.hasInit = false;
        MessageManager.getInstance().unRegisterListener(this.dCT);
        if (this.dBD != null) {
            this.dBD.onDestory(getPageContext());
        }
        com.baidu.tieba.recapp.report.a.remove("FRS");
        this.dBD = null;
        com.baidu.tieba.card.v.anQ().fs(false);
        if (this.dBg != null && this.dBg.ber() != null) {
            ac.aAN().bO(com.baidu.adp.lib.g.b.d(this.dBg.ber().getId(), 0L));
        }
        if (this.dCd != null) {
            this.dCd.onDestory();
        }
        if (this.dBE != null) {
            com.baidu.tieba.frs.f.h.a(this.dBE, this.dBg, getForumId(), false, null);
            this.dBE.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.dBM != null) {
                this.dBM.NY();
            }
            this.dBE.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.dBO.onActivityDestroy();
        this.dBP.onActivityDestroy();
        if (this.dBO != null) {
            this.dBO.abf();
        }
        if (this.dBU != null) {
            this.dBU.OW();
        }
        if (this.dBX != null) {
            this.dBX.destory();
        }
        if (this.dBY != null) {
            this.dBY.destory();
        }
        if (this.dBS != null) {
            this.dBS.onDestroy();
        }
        if (this.dCk != null) {
            this.dCk.onDestory();
        }
        if (this.dCc != null) {
            this.dCc.onDestroy();
        }
        if (this.dCn != null) {
            this.dCn.onDestroy();
        }
        if (this.dCo != null) {
            this.dCo.onDestroy();
        }
        com.baidu.tieba.recapp.d.a.btw().bty();
        com.baidu.tieba.frs.f.j.aFe();
        if (this.dBQ != null) {
            this.dBQ.a((FrsTabViewController.a) null);
            this.dBQ.aFM();
        }
        if (this.dCp != null) {
            this.dCp.onDestroy();
        }
        if (this.dCr != null) {
            this.dCr.onDestroy();
        }
        com.baidu.tieba.frs.a.ayk().a(null);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.dBw);
        bundle.putString("from", this.mFrom);
        this.dBO.onSaveInstanceState(bundle);
        if (this.dBD != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            this.dBD.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.dCc != null) {
            this.dCc.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dBE != null) {
            this.dBE.azV();
            this.dBE.onResume();
        }
        this.dBR.hk(true);
        this.dBN = true;
        if (dBv) {
            dBv = false;
            this.dBE.startPullRefresh();
            return;
        }
        if (this.dBD != null) {
            this.dBD.onResume(getPageContext());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921338));
        this.dBE.gC(false);
        if (this.dCl) {
            refresh(6);
            this.dCl = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
    }

    public boolean azh() {
        Intent intent;
        if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
            return false;
        }
        return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
    }

    public void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.dBw = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.dBy = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.dBy) {
                azi();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azi() {
        this.dBE.startPullRefresh();
    }

    public void closeActivity() {
        com.baidu.tieba.frs.f.i.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.mFrom);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.dBE.setTitle(this.dBw);
        } else {
            this.dBE.setTitle("");
            this.mFlag = 1;
        }
        this.dBE.setOnAdapterItemClickListener(this.dCR);
        this.dBE.addOnScrollListener(this.mScrollListener);
        this.dBE.h(this.dzq);
        this.dBE.aAf().a(this.dCQ);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dCt) {
            this.dBE.onChangeSkinType(i);
            this.dBP.nc(i);
            this.dBQ.onChangeSkinType(i);
            if (this.dCj != null) {
                this.dCj.onChangeSkinType();
            }
            if (this.dCp != null) {
                this.dCp.onChangeSkinType(i);
            }
            if (this.dCq != null) {
                this.dCq.d(getPageContext(), i);
            }
            if (this.cQu != null) {
                com.baidu.tbadk.o.a.a(getPageContext(), this.cQu.AC());
            }
        }
    }

    public void lH(int i) {
        if (!this.mIsLogin) {
            if (this.dBg != null && this.dBg.xA() != null) {
                this.dBg.xA().setIfpost(1);
            }
            if (i == 0) {
                ba.bF(getActivity());
            }
        } else if (this.dBg != null) {
            if (i == 0) {
                com.baidu.tieba.frs.f.j.d(this, 0);
            } else {
                this.dBE.azX();
            }
        }
    }

    public void refresh() {
        com.baidu.tieba.a.d.UG().jr("page_frs");
        refresh(3);
    }

    public void refresh(int i) {
        this.dBK = false;
        azn();
        if (this.dBE.azN() != null) {
            this.dBE.azN().aKF();
        }
        this.dBO.r(i, true);
    }

    private void azj() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.g.h.jH().d(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.20
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.vk(FrsFragment.this.dBw);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azk() {
        azn();
        try {
            if (this.dBg != null) {
                this.dBE.alG();
                this.dBE.gv(azw());
                if (!com.baidu.tieba.frs.vc.f.k(this.dBg) || !com.baidu.tieba.frs.vc.f.j(this.dBg)) {
                }
                if (this.dBg.ber() != null) {
                    this.dBw = this.dBg.ber().getName();
                    this.forumId = this.dBg.ber().getId();
                }
                if (this.dBg.xO() != null) {
                    setHasMore(this.dBg.xO().xL());
                }
                this.dBE.setTitle(this.dBw);
                this.dBE.setForumName(this.dBw);
                TbadkCoreApplication.getInst().setDefaultBubble(this.dBg.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.dBg.getUserData().getBimg_end_time());
                azj();
                azl();
                ArrayList<com.baidu.adp.widget.ListView.h> threadList = this.dBg.getThreadList();
                if (threadList != null) {
                    this.dBE.a(threadList, this.dBg);
                    com.baidu.tieba.frs.f.c.w(this.dBE);
                    this.dBP.nd(getPageNum());
                    this.dBP.h(this.dBg);
                    this.dBQ.a(this.dBg, this.dBO.aEG());
                    this.dBE.azY();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void azl() {
        if (this.dBg != null) {
            if (this.dBg.beG() == 1) {
                this.dBE.aAf().setFromCDN(true);
            } else {
                this.dBE.aAf().setFromCDN(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.dBR.hk(false);
        this.dBN = false;
        this.dBE.onPause();
        if (this.dBD != null) {
            this.dBD.onPause(getPageContext());
        }
        this.dBE.gC(true);
        if (this.dBY != null) {
            this.dBY.aFh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.dBQ != null && this.dBQ.aFK() != null && (this.dBQ.aFK().fragment instanceof BaseFragment)) {
            ((BaseFragment) this.dBQ.aFK().fragment).setPrimary(z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.v.anQ().fs(false);
        if (this.dBg != null && this.dBg.ber() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            com.baidu.tbadk.distribute.a.KG().a(getPageContext().getPageActivity(), "frs", this.dBg.ber().getId(), 0L);
        }
        if (this.dBD != null) {
            this.dBD.onStop(getPageContext());
        }
        if (Eq() != null) {
            Eq().getRecycledViewPool().clear();
        }
        this.dBP.onActivityStop();
        com.baidu.tbadk.util.v.Pa();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            if (this.dBP != null) {
                this.dBP.gt(isPrimary());
            }
            if (this.dBE != null) {
                this.dBE.gt(isPrimary());
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (com.baidu.tieba.frs.a.ayk().ayl()) {
                com.baidu.tieba.frs.a.ayk().reset();
                return true;
            } else if (this.dBE != null) {
                return this.dBE.azU();
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
        com.baidu.tbadk.distribute.a.KG().a(advertAppInfo, this.forumId, 0L, "FRS", str, getPn());
    }

    @Override // com.baidu.tieba.recapp.n
    public void azm() {
        ayT().azm();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dBD == null) {
            this.dBD = VoiceManager.instance();
        }
        return this.dBD;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdRecyclerView Eq() {
        if (this.dBE == null) {
            return null;
        }
        return this.dBE.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void azn() {
        if (this.dBD != null) {
            this.dBD.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> Er() {
        if (this.aHn == null) {
            this.aHn = UserIconBox.l(getPageContext().getPageActivity(), 8);
        }
        return this.aHn;
    }

    public void azo() {
        if (getFragmentActivity() != null && getFragmentActivity().getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.b(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.k onGetPreLoadListView() {
        return Eq().getPreLoadHandle();
    }

    @Override // com.baidu.tieba.frs.ak
    public NavigationBar aaO() {
        if (this.dBE == null) {
            return null;
        }
        return this.dBE.aaO();
    }

    @Override // com.baidu.tbadk.core.view.NavigationBar.a
    public void b(Pair<Integer, Integer> pair) {
        this.dBI = pair;
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
                if (bdUniqueId == p.dEm) {
                    if (FrsFragment.this.dBE != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11752").ax(ImageViewerConfig.FORUM_ID, FrsFragment.this.forumId).ax("obj_locate", "1"));
                        FrsFragment.this.dBE.startPullRefresh();
                    }
                } else if (hVar != null && (hVar instanceof bb)) {
                    bb bbVar = (bb) hVar;
                    if (bbVar.zo() == null || bbVar.zo().getGroup_id() == 0 || ba.bG(FrsFragment.this.getActivity())) {
                        if (bbVar.zg() != 1 || ba.bG(FrsFragment.this.getActivity())) {
                            if (bbVar.yQ() != null) {
                                if (ba.bG(FrsFragment.this.getActivity())) {
                                    String postUrl = bbVar.yQ().getPostUrl();
                                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.lm()) {
                                        com.baidu.tbadk.browser.a.ae(FrsFragment.this.getActivity(), postUrl);
                                    }
                                }
                            } else if (bbVar.zx() != null) {
                                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                    ba.bF(FrsFragment.this.getPageContext().getPageActivity());
                                    return;
                                }
                                com.baidu.tbadk.core.data.m zx = bbVar.zx();
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), zx.getCartoonId(), zx.getChapterId(), 2)));
                            } else {
                                com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                                if (readThreadHistory != null && !readThreadHistory.vq(bbVar.getId())) {
                                    readThreadHistory.vp(bbVar.getId());
                                }
                                boolean z = false;
                                final String yK = bbVar.yK();
                                if (yK != null && !yK.equals("")) {
                                    z = true;
                                    new Thread(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.a.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(yK);
                                            xVar.Cf().Dd().mIsNeedAddCommenParam = false;
                                            xVar.Cf().Dd().mIsUseCurrentBDUSS = false;
                                            xVar.BI();
                                        }
                                    }).start();
                                }
                                String tid = bbVar.getTid();
                                if (tid == null) {
                                    tid = "";
                                }
                                if (bbVar.yx() == 2 && !tid.startsWith("pb:")) {
                                    ay.Db().c(FrsFragment.this.getPageContext(), new String[]{tid, "", null});
                                    return;
                                }
                                if (tid.startsWith("pb:")) {
                                    bbVar.setId(tid.substring(3));
                                }
                                if (bdUniqueId.getId() == bb.ard.getId()) {
                                    com.baidu.tieba.frs.f.h.a(bbVar.yj());
                                } else if (bdUniqueId.getId() == bb.apN.getId()) {
                                    com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c12940");
                                    amVar.ax("obj_type", "2");
                                    amVar.ax("tid", bbVar.getTid());
                                    TiebaStatic.log(amVar);
                                }
                                com.baidu.tieba.frs.f.i.a(FrsFragment.this, bbVar, i, z);
                                com.baidu.tieba.frs.f.h.a(FrsFragment.this, FrsFragment.this.dBg, bbVar);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.l.lm()) {
            hideNetRefreshView(this.dBE.aAg());
            showLoadingView(this.dBE.aAg(), true);
            this.dBE.gy(false);
            this.dBO.r(3, true);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public com.baidu.tieba.tbadkCore.l azp() {
        return this.dBg;
    }

    public boolean azq() {
        return this.dBE.azq();
    }

    public void ac(Object obj) {
        if (this.dBT != null && this.dBT.dTj != null) {
            this.dBT.dTj.m(obj);
        }
    }

    public void ad(Object obj) {
        if (this.dBT != null && this.dBT.dTk != null) {
            this.dBT.dTk.m(obj);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        this.dBE.getListView().stopScroll();
        if (!this.dBE.aAb()) {
            if (!com.baidu.adp.lib.util.l.lm()) {
                this.dBE.ZV();
            } else if (this.dBO.aEA() == 1) {
                Zj();
                YV();
            } else if (this.dBO.hasMore()) {
                YV();
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void ni(String str) {
        Zj();
        showToast(str);
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void O(ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        boolean I = com.baidu.tbadk.core.util.v.I(arrayList);
        setHasMore(I ? 0 : 1);
        Zj();
        if (!I) {
            if (!this.dBO.aEK() && TbadkCoreApplication.getInst().isRecAppExist() && this.dBO.aEA() == 1) {
                this.dBg.a(this, arrayList);
            }
            ArrayList<com.baidu.adp.widget.ListView.h> a2 = this.dCa.a(false, false, arrayList, this.dBA, false);
            if (a2 != null) {
                this.dBg.ax(a2);
                this.dBE.a(a2, this.dBg);
            }
            if (this.dBO != null) {
                com.baidu.tieba.frs.e.b.a(this.dBg, this.dBO.aEG(), 2);
            }
        }
    }

    private void Zj() {
        if (ayZ() == 1 || this.dCa.bM(this.dBg.bzC())) {
            if (com.baidu.tbadk.core.util.v.H(this.dBg.getThreadList()) > 3) {
                this.dBE.ZT();
            } else {
                this.dBE.aAj();
            }
        } else if (com.baidu.tbadk.core.util.v.I(this.dBg.getThreadList())) {
            this.dBE.ZV();
        } else {
            this.dBE.ZU();
        }
    }

    @Override // com.baidu.tieba.frs.mc.j
    public void YV() {
        if (this.dCa != null) {
            this.dCa.a(this.dBw, this.forumId, this.dBg);
        }
    }

    public void takePhoto() {
        if (!com.baidu.tbadk.core.util.ab.e(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.ak.b(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        if (this.dBJ) {
            return null;
        }
        if (azr()) {
            return "a034";
        }
        return "a006";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (!azr()) {
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

    public void gr(boolean z) {
        if (this.dBU != null) {
            this.dBU.gN(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.dBV.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a he(int i) {
        return this.dBV.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        this.dCe.b(bVar);
    }

    public boolean azr() {
        return this.dBs;
    }

    @Override // com.baidu.tieba.frs.ah
    public void Zu() {
        if (this.dBE != null) {
            showFloatingView();
            this.dBE.getListView().scrollToPosition(0);
            this.dBE.startPullRefresh();
        }
    }

    public ForumWriteData azs() {
        if (this.dBg == null || this.dBg.ber() == null) {
            return null;
        }
        ForumData ber = this.dBg.ber();
        ForumWriteData forumWriteData = new ForumWriteData(ber.getId(), ber.getName(), ber.getPrefixData(), this.dBg.xA());
        forumWriteData.avatar = ber.getImage_url();
        forumWriteData.forumLevel = ber.getUser_level();
        forumWriteData.specialForumType = ber.special_forum_type;
        forumWriteData.firstDir = ber.getFirst_class();
        forumWriteData.secondDir = ber.getSecond_class();
        UserData userData = this.dBg.getUserData();
        forumWriteData.privateThread = userData != null ? userData.getPrivateThread() : 0;
        return forumWriteData;
    }

    @Override // com.baidu.tieba.frs.ah
    public void Ef() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.frs.ah
    public void setVideoThreadId(String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z) {
        super.showLoadingView(view, z);
        this.dBE.lM(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        super.hideLoadingView(view);
        this.dBE.lM(0);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        super.showNetRefreshView(view, str, z);
        this.dBE.lM(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshViewNoClick(View view, String str, boolean z) {
        super.showNetRefreshViewNoClick(view, str, z);
        this.dBE.lM(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        super.hideNetRefreshView(view);
        this.dBE.lM(0);
    }

    public void azt() {
        FrsTabViewController.b aFK;
        if (this.dBQ != null && (aFK = this.dBQ.aFK()) != null && aFK.fragment != null && (aFK.fragment instanceof aj)) {
            ((aj) aFK.fragment).ayI();
        }
    }

    public void a(ContriInfo contriInfo) {
        if (this.dCp == null) {
            this.dCp = new com.baidu.tbadk.core.dialog.h(getTbPageContext());
            this.dCp.a(new h.a() { // from class: com.baidu.tieba.frs.FrsFragment.29
                @Override // com.baidu.tbadk.core.dialog.h.a
                public void bm(boolean z) {
                    if (z) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13061"));
                    }
                }
            });
        }
        this.dCp.a(contriInfo, -1L);
    }

    public void gs(boolean z) {
        this.dBu = z;
    }

    public boolean azu() {
        return this.dBu;
    }

    public void nA(String str) {
        if (TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.util.ao.isEmpty(str)) {
            if (this.dCr == null) {
                this.dCr = new AddExperiencedModel(getTbPageContext());
                this.dCr.a(this.dCu);
            }
            this.dCr.cz(this.forumId, str);
        }
    }

    public com.baidu.tieba.frs.entelechy.b azv() {
        return this.dBq;
    }

    public boolean azw() {
        return (this.dBO != null && this.dBO.aEB() && com.baidu.tieba.frs.a.ayk().ayl()) ? false : true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.e.c
    public boolean videoNeedPreload() {
        if (this.dBg != null) {
            return com.baidu.tbadk.util.aa.Ph() && (this.dBg.hcJ || com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("auto_play_video_frs", 0) == 1);
        }
        return super.videoNeedPreload();
    }
}
