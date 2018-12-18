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
    public static boolean dHU = false;
    public static volatile long dIf = 0;
    public static volatile long dIg = 0;
    public static volatile int mNetError = 0;
    private com.baidu.adp.lib.e.b<TbImageView> aKN;
    private com.baidu.tieba.frs.gametab.b bYA;
    private com.baidu.tbadk.util.t biL;
    private com.baidu.tbadk.core.dialog.a cXb;
    private com.baidu.tieba.frs.entelechy.b dHP;
    private com.baidu.tieba.tbadkCore.data.e dHZ;
    private com.baidu.tieba.frs.vc.h dIA;
    private com.baidu.tieba.frs.mc.a dIB;
    private com.baidu.tieba.frs.live.a dIC;
    private j dID;
    public com.baidu.tieba.frs.vc.c dIE;
    private com.baidu.tieba.frs.mc.e dIF;
    private int dIG;
    private View.OnTouchListener dIH;
    private com.baidu.tieba.frs.view.a dII;
    private com.baidu.tieba.frs.vc.e dIJ;
    private boolean dIK;
    private com.baidu.tieba.NEGFeedBack.a dIM;
    private com.baidu.tieba.ala.a dIN;
    private com.baidu.tbadk.core.dialog.h dIO;
    private com.baidu.tieba.frs.brand.buttommenu.a dIP;
    private AddExperiencedModel dIQ;
    private boolean dIS;
    private VoiceManager dIc;
    private FrsModelController dIn;
    private com.baidu.tieba.frs.vc.f dIo;
    private FrsTabViewController dIp;
    private com.baidu.tieba.frs.mc.f dIq;
    private com.baidu.tieba.frs.smartsort.b dIr;
    private com.baidu.tieba.frs.mc.b dIs;
    private an dIt;
    private com.baidu.tieba.frs.entelechy.b.b dIv;
    private com.baidu.tbadk.i.a dIw;
    private com.baidu.tieba.frs.vc.a dIx;
    private com.baidu.tieba.frs.mc.d dIy;
    private com.baidu.tieba.frs.mc.c dIz;
    private int dJa;
    public View mRootView;
    public boolean dHQ = false;
    private boolean dHR = false;
    private boolean dHS = false;
    private boolean dHT = true;
    public String dHV = null;
    public String mFrom = null;
    public int mFlag = 0;
    public boolean dHW = false;
    private boolean dHX = false;
    private String mThreadId = null;
    public String forumId = null;
    private int dHI = 0;
    private boolean dHY = false;
    private boolean dIa = false;
    private boolean dIb = false;
    private k dId = null;
    public final bb bNv = null;
    private com.baidu.tieba.tbadkCore.l dHF = new com.baidu.tieba.tbadkCore.l();
    public long doE = -1;
    public long bfV = 0;
    public long bfN = 0;
    public long createTime = 0;
    public long beginTime = -1;
    public long dIe = 0;
    public Pair<Integer, Integer> dIh = null;
    public boolean dIi = false;
    private boolean dIj = false;
    private boolean dIk = false;
    public com.baidu.tbadk.l.b dIl = null;
    private boolean dIm = true;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> dIu = new SparseArray<>();
    private boolean bRT = true;
    private boolean dIL = false;
    private boolean hasInit = false;
    private boolean dIR = false;
    private AddExperiencedModel.a dIT = new AddExperiencedModel.a() { // from class: com.baidu.tieba.frs.FrsFragment.1
        @Override // com.baidu.tieba.share.AddExperiencedModel.a
        public void b(ContriInfo contriInfo) {
            if (contriInfo != null && contriInfo.isShowToast()) {
                FrsFragment.this.a(contriInfo);
            }
        }
    };
    private HttpMessageListener dIU = new HttpMessageListener(CmdConfigHttp.CMD_PB_FLOOR_AGREE, true) { // from class: com.baidu.tieba.frs.FrsFragment.12
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
    private final CustomMessageListener dIV = new CustomMessageListener(2016495) { // from class: com.baidu.tieba.frs.FrsFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof bb) {
                    com.baidu.tieba.frs.f.h.a(FrsFragment.this.dId, FrsFragment.this.dHF, FrsFragment.this.getForumId(), true, (bb) data);
                }
            }
        }
    };
    private CustomMessageListener dIW = new CustomMessageListener(2921005) { // from class: com.baidu.tieba.frs.FrsFragment.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.dHF != null) {
                FrsFragment.this.dHF.bCt();
                if (FrsFragment.this.dId != null) {
                    FrsFragment.this.dId.notifyDataChanged();
                }
            }
        }
    };
    private CustomMessageListener dIX = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.FrsFragment.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 1) {
                    FrsFragment.this.aAS();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                }
            }
        }
    };
    private final al dIY = new al() { // from class: com.baidu.tieba.frs.FrsFragment.34
        @Override // com.baidu.tieba.frs.al
        public void a(int i, int i2, ar arVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
            FrsFragment.this.aAL();
            if (FrsFragment.this.dIv != null) {
                FrsFragment.this.dIo.ho(FrsFragment.this.dIv.my(i));
            }
            d.a aVar = new d.a();
            if (arVar != null) {
                aVar.isSuccess = arVar.errCode == 0;
                aVar.errorCode = arVar.errCode;
                aVar.errorMsg = arVar.errMsg;
                if (aVar.isSuccess) {
                    if (com.baidu.tbadk.core.util.v.I(arrayList)) {
                        FrsFragment.this.dId.abb();
                    } else if (arVar.hasMore) {
                        if (com.baidu.tbadk.core.util.v.H(FrsFragment.this.dHF.getThreadList()) > 3) {
                            FrsFragment.this.dId.aaZ();
                        } else {
                            FrsFragment.this.dId.aBT();
                        }
                    } else if (arVar.dLS) {
                        FrsFragment.this.dId.aba();
                    } else {
                        FrsFragment.this.dId.abb();
                    }
                }
            } else {
                arVar = new ar();
                arVar.pn = 1;
                arVar.hasMore = false;
                arVar.dLS = false;
            }
            if (i == 1) {
                FrsFragment.this.dIm = true;
                FrsFragment.this.dJk.a(FrsFragment.this.dIn.getType(), false, aVar);
            } else {
                FrsFragment.this.a(aVar);
                if (FrsFragment.this.dIn.aFM() != null) {
                    FrsFragment.this.dHF = FrsFragment.this.dIn.aFM();
                }
                FrsFragment.this.aAU();
            }
            if (FrsFragment.this.dJr != null) {
                FrsFragment.this.dJr.a(i, i2, arVar, arrayList);
            }
        }
    };
    private FrsTabViewController.a dIZ = new FrsTabViewController.a() { // from class: com.baidu.tieba.frs.FrsFragment.35
        @Override // com.baidu.tieba.frs.vc.FrsTabViewController.a
        public void fV(int i) {
            boolean z = false;
            if (i != 1) {
                com.baidu.tieba.card.v.apD().ft(false);
            }
            if (i == 303 && i != FrsFragment.this.dJa) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13121").aA(ImageViewerConfig.FORUM_ID, FrsFragment.this.forumId).aA("uid", TbadkCoreApplication.getCurrentAccount()));
            }
            FrsFragment.this.dJa = i;
            FrsFragment.this.aAX();
            com.baidu.tieba.frs.e.c.dQi.ebp = i;
            com.baidu.tieba.frs.e.c.dQi.ebq = -1;
            com.baidu.tieba.frs.a azU = com.baidu.tieba.frs.a.azU();
            if (i == 1 && FrsFragment.this.dIR) {
                z = true;
            }
            azU.x(z, true);
        }
    };
    private CustomMessageListener dJb = new CustomMessageListener(2001606) { // from class: com.baidu.tieba.frs.FrsFragment.36
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                FrsFragment.this.dIp.nA(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    };
    private CustomMessageListener dJc = new CustomMessageListener(2001607) { // from class: com.baidu.tieba.frs.FrsFragment.37
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && ((Integer) customResponsedMessage.getData()).intValue() == 51 && FrsFragment.this.dHF != null) {
                com.baidu.tieba.frs.f.j.a(FrsFragment.this.dHF, FrsFragment.this.getPageContext());
            }
        }
    };
    private final CustomMessageListener dJd = new CustomMessageListener(2003019) { // from class: com.baidu.tieba.frs.FrsFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                FrsFragment.this.dIp.ny(49);
            }
        }
    };
    private final CustomMessageListener dJe = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.frs.FrsFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && FrsFragment.this.dHF != null && FrsFragment.this.dHF.bgh() != null) {
                SignData signData = (SignData) customResponsedMessage.getData();
                int user_level = FrsFragment.this.dHF.bgh().getUser_level();
                if (signData.forumId != null && signData.forumId.equals(FrsFragment.this.dHF.bgh().getId())) {
                    FrsFragment.this.dHF.d(signData);
                    FrsFragment.this.dIo.j(FrsFragment.this.dHF);
                    if (FrsFragment.this.dIo.aHo()) {
                        i = FrsFragment.this.dHF.bgh().getUser_level();
                        if (user_level >= i) {
                            i++;
                        }
                    } else {
                        i = user_level;
                    }
                    TbadkCoreApplication.getInst().addSignedForum(FrsFragment.this.dHF.bgh().getName(), signData.sign_bonus_point, i);
                }
            }
        }
    };
    private final CustomMessageListener dJf = new CustomMessageListener(2001352) { // from class: com.baidu.tieba.frs.FrsFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.r) && FrsFragment.this.dHF != null) {
                FrsFragment.this.dHF.c((com.baidu.tieba.tbadkCore.r) customResponsedMessage.getData());
                FrsFragment.this.dIo.i(FrsFragment.this.dHF);
                FrsFragment.this.dIp.a(FrsFragment.this.dHF, FrsFragment.this.dIn.aGs());
            }
        }
    };
    private final AntiHelper.a dJg = new AntiHelper.a() { // from class: com.baidu.tieba.frs.FrsFragment.5
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12536").x("obj_locate", as.a.aCN));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12535").x("obj_locate", as.a.aCN));
        }
    };
    private CustomMessageListener bVk = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.frs.FrsFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(FrsFragment.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().aPr != null) {
                        if (AntiHelper.a(FrsFragment.this.getActivity(), updateAttentionMessage.getData().aPr, FrsFragment.this.dJg) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12534").x("obj_locate", as.a.aCN));
                        }
                    } else if (updateAttentionMessage.getData().Jr && updateAttentionMessage.getData().isAttention) {
                        com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getPageContext().getPageActivity(), e.j.attention_success);
                    }
                }
            }
        }
    };
    private CustomMessageListener dJh = new CustomMessageListener(2921346) { // from class: com.baidu.tieba.frs.FrsFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsFragment.this.refresh();
        }
    };
    private CustomMessageListener dJi = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.frs.FrsFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                FrsFragment.this.dId.c((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener dJj = new CustomMessageListener(2001626) { // from class: com.baidu.tieba.frs.FrsFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewsRemindMessage newsRemindMessage;
            if (customResponsedMessage != null && (customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626 && (newsRemindMessage = (NewsRemindMessage) customResponsedMessage) != null) {
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (FrsFragment.this.dId != null) {
                    FrsFragment.this.dId.p(notificationCount, z);
                }
            }
        }
    };
    private final CustomMessageListener akA = new CustomMessageListener(2921383) { // from class: com.baidu.tieba.frs.FrsFragment.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.isResumed()) {
                FrsFragment.this.aBh();
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.n dJk = new com.baidu.tieba.tbadkCore.n() { // from class: com.baidu.tieba.frs.FrsFragment.11
        private long startTime = 0;

        @Override // com.baidu.tieba.tbadkCore.n
        public void lY(int i) {
            this.startTime = System.nanoTime();
            if (FrsFragment.this.dId != null) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsFragment.this.dId.aBF();
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
            if (FrsFragment.this.bRT) {
                FrsFragment.this.bRT = false;
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.dId, FrsFragment.this.dHF, FrsFragment.this.getForumId(), false, null);
            }
            FrsFragment.this.aAL();
            FrsFragment.this.dIj = true;
            if (aVar != null && aVar.isSuccess) {
                FrsFragment.this.dId.aBP().ha(com.baidu.tbadk.core.util.aq.DR().DT());
                FrsFragment.dIf = 0L;
                FrsFragment.dIg = 0L;
                FrsFragment.mNetError = 0;
            } else {
                FrsFragment.mNetError = 1;
            }
            if (!FrsFragment.this.dIn.aGw() && (i == 3 || i == 6)) {
                FrsFragment.this.dIz.resetData();
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (FrsFragment.this.dIn.aFM() != null) {
                FrsFragment.this.dHF = FrsFragment.this.dIn.aFM();
            }
            FrsFragment.this.dId.b(FrsFragment.this.dHF.bCa());
            FrsFragment.this.lV(1);
            if (i == 7) {
                FrsFragment.this.lW(FrsFragment.this.dHF.bBF());
                return;
            }
            if (FrsFragment.this.dHF.yS() != null) {
                FrsFragment.this.setHasMore(FrsFragment.this.dHF.yS().yP());
            }
            if (i == 4) {
                if (!FrsFragment.this.dIn.aGw() && TbadkCoreApplication.getInst().isRecAppExist() && FrsFragment.this.dIn.aGm() == 1) {
                    FrsFragment.this.dHF.a(FrsFragment.this);
                }
                ArrayList<com.baidu.adp.widget.ListView.h> a2 = FrsFragment.this.dIz.a(false, false, FrsFragment.this.dHF.getThreadList(), FrsFragment.this.dHZ, false);
                if (a2 != null) {
                    FrsFragment.this.dHF.ax(a2);
                    FrsFragment.this.dHF.bCj();
                    FrsFragment.this.dId.a(a2, FrsFragment.this.dHF);
                }
                if (FrsFragment.this.dIn != null) {
                    com.baidu.tieba.frs.e.b.a(FrsFragment.this.dHF, FrsFragment.this.dIn.aGs(), 2);
                }
                com.baidu.tieba.frs.f.a.a(FrsFragment.this, FrsFragment.this.dHF.bgh(), FrsFragment.this.dHF.getThreadList(), false, FrsFragment.this.getPn());
                FrsFragment.this.bfV = System.currentTimeMillis() - currentTimeMillis;
                FrsFragment.this.aAM();
                return;
            }
            FrsFragment.this.aAM();
            switch (i) {
                case 1:
                    FrsFragment.this.dId.aBF();
                    break;
                case 2:
                    FrsFragment.this.dId.aBF();
                    break;
                case 3:
                case 6:
                    if (FrsFragment.this.dHF != null) {
                        FrsFragment.this.dHF.bCh();
                    }
                    if (FrsFragment.this.dIE != null) {
                        FrsFragment.this.dIE.refresh();
                        break;
                    }
                    break;
            }
            FrsFragment.this.aAN();
            if (aVar == null || aVar.errorCode == 0) {
                if (FrsFragment.this.dHF != null) {
                    FrsFragment.this.A(false, i == 5);
                    FrsFragment.this.dId.mg(i);
                    FrsFragment.dIf = (System.nanoTime() - this.startTime) / 1000000;
                    if (aVar != null) {
                        FrsFragment.dIg = aVar.hhR;
                    }
                } else {
                    return;
                }
            } else if (FrsFragment.this.dHF == null || com.baidu.tbadk.core.util.v.I(FrsFragment.this.dHF.getThreadList())) {
                FrsFragment.this.a(aVar);
            } else if (aVar.hhQ) {
                FrsFragment.this.showToast(FrsFragment.this.getPageContext().getResources().getString(e.j.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
            }
            if (FrsFragment.this.dHF.bBp() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11384"));
            }
            if (FrsFragment.this.doE > -1 && !FrsFragment.this.dIL) {
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.dIn, FrsFragment.this.doE);
                FrsFragment.this.doE = -1L;
                FrsFragment.this.dIL = true;
            }
            if (FrsFragment.this.dIa && FrsFragment.this.dIp.ny(49)) {
                FrsFragment.this.dIa = false;
            }
            FrsFragment.this.bfV = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void b(com.baidu.tieba.tbadkCore.i iVar) {
            if ((iVar != null && ("normal_page".equals(FrsFragment.this.dIn.getPageType()) || "frs_page".equals(FrsFragment.this.dIn.getPageType()) || "book_page".equals(FrsFragment.this.dIn.getPageType()))) || "brand_page".equals(FrsFragment.this.dIn.getPageType())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001615, iVar));
                FrsFragment.this.a(iVar);
            }
        }
    };
    private final CustomMessageListener dJl = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.frs.FrsFragment.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                FrsFragment.this.dHF.a((com.baidu.tbadk.data.j) customResponsedMessage.getData());
                FrsFragment.this.dId.aBP().notifyDataSetChanged();
            }
        }
    };
    private final CustomMessageListener mMemListener = new CustomMessageListener(2001194) { // from class: com.baidu.tieba.frs.FrsFragment.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && FrsFragment.this.dHF != null && (userData = FrsFragment.this.dHF.getUserData()) != null) {
                userData.setIsMem(num.intValue());
                if (num.intValue() != 0) {
                    FrsFragment.this.dIo.g(num);
                }
            }
        }
    };
    private final com.baidu.tieba.frs.mc.i dJm = new com.baidu.tieba.frs.mc.i() { // from class: com.baidu.tieba.frs.FrsFragment.19
        @Override // com.baidu.tieba.frs.mc.i
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.h> arrayList, boolean z3) {
            if (FrsFragment.this.dIr != null && FrsFragment.this.dIn != null && FrsFragment.this.dIn.aGw() && z && !z2 && !z3) {
                FrsFragment.this.dIr.nd(i2);
            }
        }
    };
    public final View.OnTouchListener biM = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.FrsFragment.20
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (FrsFragment.this.dIH != null) {
                FrsFragment.this.dIH.onTouch(view, motionEvent);
            }
            if (FrsFragment.this.dIt != null && FrsFragment.this.dIt.aCA() != null) {
                FrsFragment.this.dIt.aCA().onTouchEvent(motionEvent);
            }
            if (FrsFragment.this.bYA != null) {
                FrsFragment.this.bYA.d(view, motionEvent);
            }
            if (FrsFragment.this.dIo != null) {
                FrsFragment.this.dIo.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private final CustomMessageListener dJn = new CustomMessageListener(2004507) { // from class: com.baidu.tieba.frs.FrsFragment.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "photolive_hostLevel", -1) != -1 && FrsFragment.this.dHF.bgh() != null) {
                FrsFragment.this.dHF.bgh().setCanAddPhotoLivePost(true);
            }
        }
    };
    public final View.OnClickListener dJo = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.24
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsFragment.this.dId == null || view != FrsFragment.this.dId.aBD() || FrsFragment.this.getActivity() == null) {
                if (FrsFragment.this.dHF != null && FrsFragment.this.dHF.bgh() != null && FrsFragment.this.dId != null && view == FrsFragment.this.dId.aBJ()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12402").aA(ImageViewerConfig.FORUM_ID, FrsFragment.this.dHF.bgh().getId()).aA("uid", TbadkCoreApplication.getCurrentAccount()).aA(ImageViewerConfig.FORUM_NAME, FrsFragment.this.dHF.bgh().getName()));
                    if (!StringUtils.isNull(FrsFragment.this.dHF.bgh().getName())) {
                        FrsFragment.this.sendMessage(new CustomMessage(2002001, new PostSearchActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), FrsFragment.this.dHF.bgh().getName(), FrsFragment.this.dHF.bgh().getId())));
                        return;
                    }
                    return;
                }
                if (view.getId() == e.g.game_activity_egg_layout && com.baidu.adp.lib.util.l.ll()) {
                    TiebaStatic.log("c10853");
                    if (FrsFragment.this.dId.aBM()) {
                        FrsFragment.this.dId.aBN();
                    } else {
                        String activityUrl = FrsFragment.this.dHF.bgh().getYuleData().By().getActivityUrl();
                        if (!StringUtils.isNull(activityUrl)) {
                            com.baidu.tbadk.browser.a.af(FrsFragment.this.getPageContext().getPageActivity(), activityUrl);
                        }
                    }
                }
                if (view == FrsFragment.this.dId.aBU() && FrsFragment.this.dIn != null && FrsFragment.this.dIn.hasMore()) {
                    FrsFragment.this.dId.aaZ();
                    FrsFragment.this.aab();
                }
                if (view != null && view == FrsFragment.this.dId.aBK() && ba.bJ(FrsFragment.this.getContext())) {
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
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.FrsFragment.25
        private int dJv = 0;
        private int bNa = 0;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (FrsFragment.this.dIx != null) {
                FrsFragment.this.dIx.aGT();
            }
            this.dJv = 0;
            this.bNa = 0;
            if (recyclerView != null && (recyclerView instanceof BdRecyclerView)) {
                this.dJv = ((BdRecyclerView) recyclerView).getFirstVisiblePosition();
                this.bNa = ((BdRecyclerView) recyclerView).getLastVisiblePosition();
            }
            if (FrsFragment.this.dIJ != null) {
                FrsFragment.this.dIJ.a(recyclerView, this.dJv, this.bNa);
            }
            if (FrsFragment.this.dHF != null && FrsFragment.this.dId != null && FrsFragment.this.dId.aBP() != null) {
                FrsFragment.this.dId.aL(this.dJv, this.bNa);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (FrsFragment.this.dIo != null) {
                FrsFragment.this.dIo.setScrollState(i);
            }
            if ((i == 2 || i == 1) && !FrsFragment.this.dIk) {
                FrsFragment.this.dIk = true;
                FrsFragment.this.dId.aBS();
            }
            if (FrsFragment.this.dIl == null && !FrsFragment.this.aBb()) {
                FrsFragment.this.dIl = new com.baidu.tbadk.l.b();
                FrsFragment.this.dIl.gi(1000);
            }
            if (i == 0) {
                if (FrsFragment.this.dIl != null) {
                    FrsFragment.this.dIl.Pb();
                }
                com.baidu.tieba.card.v.apD().ft(true);
                FrsFragment.this.dId.aK(this.dJv, this.bNa);
            } else if (FrsFragment.this.dIl != null) {
                FrsFragment.this.dIl.Pa();
            }
            if (FrsFragment.this.dIJ != null) {
                FrsFragment.this.dIJ.onScrollStateChanged(recyclerView, i);
            }
            if (i == 0) {
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.dId, FrsFragment.this.dHF, FrsFragment.this.getForumId(), false, null);
            }
            if (FrsFragment.this.dIp != null && i == 1) {
                FrsFragment.this.dIp.aHy();
            }
        }
    };
    private final d dJp = new d() { // from class: com.baidu.tieba.frs.FrsFragment.26
        @Override // com.baidu.tieba.frs.d
        public void a(int i, int i2, View view, View view2, bb bbVar) {
            if (i != FrsFragment.this.dId.aBP().aDO()) {
                if (i != FrsFragment.this.dId.aBP().aDP()) {
                    if (i == FrsFragment.this.dId.aBP().aDQ() && FrsFragment.this.dHF != null && FrsFragment.this.dHF.getUserData() != null && FrsFragment.this.dHF.getUserData().isBawu()) {
                        String bBD = FrsFragment.this.dHF.bBD();
                        if (!com.baidu.tbadk.core.util.ao.isEmpty(bBD) && FrsFragment.this.dHF.bgh() != null) {
                            com.baidu.tbadk.browser.a.ad(FrsFragment.this.getPageContext().getPageActivity(), bBD);
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10502").aA(ImageViewerConfig.FORUM_ID, FrsFragment.this.dHF.bgh().getId()).aA("uid", FrsFragment.this.dHF.getUserData().getUserId()));
                        }
                    }
                } else if (ba.bJ(FrsFragment.this.getPageContext().getPageActivity())) {
                    TiebaStatic.log("my_service_ck");
                    if (FrsFragment.this.dHF != null && FrsFragment.this.dHF.bgh() != null) {
                        ForumData bgh = FrsFragment.this.dHF.bgh();
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(bgh.getId(), 0L), bgh.getName(), bgh.getImage_url(), 0)));
                    }
                }
            } else if (ba.bJ(FrsFragment.this.getActivity())) {
                TiebaStatic.log("forum_fortune_click");
                com.baidu.tieba.frs.f.i.b(FrsFragment.this.getPageContext(), FrsFragment.this.dHF);
            }
        }
    };
    private final NoNetworkView.a dFP = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.FrsFragment.27
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bF(boolean z) {
            if (FrsFragment.this.dIn.aGm() == 1 && z && !FrsFragment.this.dId.aBa()) {
                if (FrsFragment.this.dHF == null || com.baidu.tbadk.core.util.v.I(FrsFragment.this.dHF.getThreadList())) {
                    FrsFragment.this.hideNetRefreshView(FrsFragment.this.dId.aBQ());
                    FrsFragment.this.showLoadingView(FrsFragment.this.dId.aBQ(), true);
                    FrsFragment.this.dId.gz(false);
                    FrsFragment.this.refresh();
                    return;
                }
                FrsFragment.this.dId.aBF();
            }
        }
    };
    private final CustomMessageListener aPU = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.FrsFragment.28
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                com.baidu.tieba.frs.f.c.a(customResponsedMessage, FrsFragment.this.dId, FrsFragment.this.dHF);
            }
        }
    };
    private com.baidu.adp.widget.ListView.n dJq = new a();
    private al dJr = new al() { // from class: com.baidu.tieba.frs.FrsFragment.29
        @Override // com.baidu.tieba.frs.al
        public void a(int i, int i2, ar arVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
            com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.29.1
                @Override // java.lang.Runnable
                public void run() {
                    if (FrsFragment.this.dId != null && FrsFragment.this.dId.aqz()) {
                        FrsFragment.this.aab();
                    }
                }
            });
        }
    };
    private CustomMessageListener dJs = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.frs.FrsFragment.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    FrsFragment.this.dIK = true;
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.frs.loadmore.a
    public /* bridge */ /* synthetic */ com.baidu.adp.base.e getPageContext() {
        return super.getPageContext();
    }

    public com.baidu.tieba.frs.entelechy.b.b aAz() {
        return this.dIv;
    }

    public com.baidu.adp.widget.ListView.n aAA() {
        return this.dJq;
    }

    public com.baidu.tieba.frs.mc.d aAB() {
        return this.dIy;
    }

    public com.baidu.tieba.frs.smartsort.b aAC() {
        return this.dIr;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public FrsModelController aAD() {
        return this.dIn;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public com.baidu.tieba.frs.mc.c aAE() {
        return this.dIz;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public com.baidu.tieba.frs.vc.f aAF() {
        return this.dIo;
    }

    public com.baidu.tieba.frs.vc.k aAG() {
        return this.dIp;
    }

    public an aAH() {
        return this.dIt;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public k aAI() {
        return this.dId;
    }

    @Override // com.baidu.tieba.frs.am
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.am, com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.dHV;
    }

    public void setForumName(String str) {
        this.dHV = str;
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
        if (this.dIz == null) {
            return 1;
        }
        return this.dIz.getPn();
    }

    public int getPn() {
        if (this.dIz == null) {
            return 1;
        }
        return this.dIz.getPn();
    }

    public void setPn(int i) {
        if (this.dIz != null) {
            this.dIz.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.dIz != null) {
            this.dIz.setHasMore(i);
        }
    }

    public int aAJ() {
        if (this.dIz == null) {
            return -1;
        }
        return this.dIz.aAJ();
    }

    public boolean aAK() {
        return this.dIb;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d.a aVar) {
        if (aVar == null) {
            String string = TbadkCoreApplication.getInst().getString(e.j.error_unkown_try_again);
            this.dId.aBA();
            showNetRefreshView(this.dId.aBQ(), string, true);
        } else if (340001 == aVar.errorCode) {
            a(aVar, this.dHF.bBm());
        } else {
            if (com.baidu.tbadk.core.util.v.I(this.dHF.getThreadList())) {
                b(aVar);
            }
            if (aBb()) {
                setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst(), e.C0210e.ds280));
            } else {
                setNetRefreshViewEmotionDefMarginTop();
            }
        }
    }

    public void a(View view, String str, boolean z, List<RecmForumInfo> list) {
        this.dId.aBA();
        this.dId.mc(8);
        if (this.dII == null) {
            this.dII = new com.baidu.tieba.frs.view.a(getPageContext(), getNetRefreshListener());
        }
        this.dII.in(str);
        this.dII.bS(list);
        this.dII.attachView(view, z);
    }

    private void a(d.a aVar, List<RecmForumInfo> list) {
        if (this.dId != null) {
            this.dId.aBA();
            this.dId.setTitle(this.dHV);
            a(this.dId.aBQ(), aVar.errorMsg, true, list);
        }
    }

    private void b(d.a aVar) {
        this.dId.aBA();
        if (aVar.hhQ) {
            showNetRefreshView(this.dId.aBQ(), TbadkCoreApplication.getInst().getString(e.j.net_error_text, new Object[]{aVar.errorMsg, Integer.valueOf(aVar.errorCode)}), true);
        } else {
            showNetRefreshView(this.dId.aBQ(), aVar.errorMsg, true);
        }
    }

    public void aAL() {
        hideLoadingView(this.dId.aBQ());
        if (!this.dId.aBa()) {
            this.dId.gA(false);
        } else {
            this.dId.gA(true);
        }
        if (this.dId.aBy() instanceof com.baidu.tieba.frs.tab.c) {
            ((com.baidu.tieba.frs.tab.c) this.dId.aBy()).aGO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAM() {
        if (aAJ() == 0 && com.baidu.tbadk.core.util.v.I(this.dHF.bBv())) {
            if (com.baidu.tbadk.core.util.v.I(this.dHF.getThreadList())) {
                this.dId.abb();
            } else {
                this.dId.aba();
            }
        } else if (com.baidu.tbadk.core.util.v.H(this.dHF.getThreadList()) > 3) {
            this.dId.aaZ();
        } else {
            this.dId.aBT();
        }
    }

    public void a(ErrorData errorData) {
        aAL();
        this.dId.aBF();
        d.a aGj = this.dIn.aGj();
        boolean I = com.baidu.tbadk.core.util.v.I(this.dHF.getThreadList());
        if (aGj != null && I) {
            if (this.dIn.aGk() != 0) {
                this.dIn.aGq();
                this.dId.aBF();
            } else {
                a(aGj);
            }
            this.dId.B(this.dHF.bCA(), false);
            return;
        }
        a(aGj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lV(int i) {
        List<WindowToast> list;
        if (TbadkCoreApplication.isLogin() && this.dHF != null && (list = this.dHF.hjv) != null && list.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < list.size()) {
                    WindowToast windowToast = list.get(i3);
                    if (windowToast == null || windowToast.toast_type.intValue() != i) {
                        i2 = i3 + 1;
                    } else if (!com.baidu.tbadk.core.util.ao.isEmpty(windowToast.toast_link)) {
                        sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(getPageContext().getPageActivity(), "", com.baidu.tbadk.util.ab.iQ(windowToast.toast_link), true)));
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
    public void aAN() {
        if (this.dHF == null || this.dHF.bgh() != null) {
            this.dId.aBO();
        } else if (this.dHF.bgh().getYuleData() != null && this.dHF.bgh().getYuleData().Bx()) {
            TiebaStatic.log("c10852");
            this.dId.a(this.dHF.bgh().getYuleData().By());
        } else {
            this.dId.aBO();
        }
    }

    private void z(boolean z, boolean z2) {
        if (this.dIn != null && this.dHF != null && this.dId != null && z) {
            if (!this.dIn.aGw() && this.dIn.aGm() == 1) {
                if (!this.dIn.aGu()) {
                    this.dHF.bCp();
                    this.dHF.bCq();
                }
                boolean z3 = false;
                if (this.dId.aBP().k(com.baidu.tieba.card.data.n.cYq)) {
                    z3 = this.dHF.bCu();
                }
                if (!z3) {
                    this.dHF.bCs();
                }
                if (TbadkCoreApplication.getInst().isRecAppExist()) {
                    this.dHF.a(this);
                }
                if (!this.dId.aBP().k(bb.atk)) {
                    this.dHF.bCi();
                }
                this.dHF.bCv();
            }
            if (!this.dId.aBP().k(bb.atk)) {
                this.dHF.bCo();
                this.dHF.bCm();
            } else {
                this.dHF.bCn();
                this.dHF.bCl();
            }
            this.dHF.bCj();
            this.dHF.bCg();
            if (this.dId.aBP().k(com.baidu.tieba.h.b.ekK)) {
                this.dHF.nq(z2);
            }
            if (TbadkCoreApplication.isLogin() && (!this.dIn.aGw() || this.dIn.isNetFirstLoad)) {
                this.dHF.bCw();
            }
            this.dHF.bCy();
        }
    }

    public boolean aAO() {
        if (this.dIo != null && this.dIn != null) {
            this.dIo.a(this.dIn.getPageType(), this.dHF);
        }
        boolean z = false;
        if (this.dHF != null) {
            z = this.dHF.bCB();
        }
        aAQ();
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lW(int i) {
        ao aoVar = null;
        aAO();
        aAX();
        try {
            if (this.dHF != null) {
                this.dId.a((ArrayList<com.baidu.adp.widget.ListView.h>) null, this.dHF);
                this.dIo.nt(1);
                this.dId.aBI();
                this.dIp.a(this.dHF, this.dIn.aGs());
                com.baidu.tieba.frs.tab.d nz = this.dIp.nz(this.dHF.bBF());
                if (nz != null && !TextUtils.isEmpty(nz.url)) {
                    aoVar = new ao();
                    aoVar.dLP = nz.url;
                    aoVar.stType = nz.name;
                }
                this.dIn.a(this.dHF.bBF(), 0, aoVar);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(boolean z, boolean z2) {
        try {
            if (this.dHF != null && this.dIp != null && this.dIn != null) {
                if (!this.dId.aBP().k(bb.atk)) {
                    this.dHF.bCi();
                }
                boolean I = com.baidu.tbadk.core.util.v.I(this.dHF.bBT());
                this.dId.gx(I);
                if (!I) {
                    if (this.dIJ == null) {
                        this.dIJ = new com.baidu.tieba.frs.vc.e(this, (NoPressedRelativeLayout) this.mRootView);
                    }
                    if (this.bYA == null) {
                        this.bYA = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
                    }
                } else {
                    this.dIJ = null;
                    this.bYA = null;
                }
                if (this.dHF.bgh() != null) {
                    this.dHV = this.dHF.bgh().getName();
                    this.forumId = this.dHF.bgh().getId();
                }
                if (this.dHF.bCB()) {
                    this.dIp.a(this.dHF, this.dIn.aGs());
                }
                if (z) {
                    z(true, z);
                } else {
                    z(this.dIm, z);
                }
                aAO();
                if (this.dIv != null) {
                    this.dIv.a(this.dIo, this.dHF);
                }
                if (this.dHF.yS() != null) {
                    setHasMore(this.dHF.yS().yP());
                }
                ArrayList<com.baidu.adp.widget.ListView.h> a2 = this.dIz.a(z2, true, this.dHF.getThreadList(), null, z, false);
                if (a2 != null) {
                    this.dHF.ax(a2);
                }
                this.dHF.bCx();
                if (this.dIn.aGm() == 1) {
                    aAU();
                    if (!z && this.dIn.getPn() == 1) {
                        aAP();
                    }
                }
                this.dHI = this.dHF.aGo();
                if (this.dHZ != null) {
                    this.dHY = true;
                    this.dHZ.vr(this.dHI);
                    com.baidu.tieba.frs.f.a.a(this, this.dHF.bgh(), this.dHF.getThreadList(), this.dHY, getPn());
                }
                if (this.dIx != null) {
                    this.dIx.aS(this.dIp.aHv());
                }
                aAL();
                this.dId.aBB();
                this.dId.B(true, false);
                if (this.dHF.bgh() != null) {
                    this.dId.oa(this.dHF.bgh().getWarningMsg());
                }
                if (this.dHF != null && this.dHF.bBW() != null && com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("frs_video_activity_guide", 0L) == 0) {
                    com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.13
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsFragment.this.dId.aBY();
                        }
                    }, 1000L);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2921326, this));
                this.dId.aBu();
                if (this.dHF != null && this.dHF.bgh() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016564, new VisitedForumData(this.dHF.bgh().getId(), this.dHF.bgh().getName(), this.dHF.bgh().getImage_url(), String.valueOf(System.currentTimeMillis() / 1000), "showlive".equals(this.dHF.bgh().special_forum_type))));
                }
                this.dIP.a(this.dHF.hjA, this.dHF.bgh());
                aBh();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void aAP() {
        if (this.dIC == null) {
            this.dIC = new com.baidu.tieba.frs.live.a(this, com.baidu.adp.lib.g.b.l(this.forumId, 0));
        }
        this.dIC.aFU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.i iVar) {
        try {
            if (!this.dIj && iVar != null && this.dHF != null) {
                this.dHF.g(iVar);
                A(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void aAQ() {
        if (this.dIn != null) {
            nY(this.dIn.getPageType());
        } else {
            nY("normal_page");
        }
    }

    private void nY(String str) {
        gq("frs_page".equals(str));
        if (this.dIv != null) {
            this.dIv.a(this.dIo, this.dId, this.dHF);
        }
    }

    public void gq(boolean z) {
        if (this.dIA != null) {
            this.dIA.c(this.dId, z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(e.h.frs_activity, viewGroup, false);
            this.dHP = new com.baidu.tieba.frs.entelechy.b();
            this.dIv = this.dHP.aDn();
            this.dIo = new com.baidu.tieba.frs.vc.f(this, this.dHP, (FrsHeaderViewContainer) this.mRootView.findViewById(e.g.header_view_container));
            this.dIp = new FrsTabViewController(this, this.mRootView);
            this.dIp.registerListener();
            this.dIo.a(this.dIp);
            this.dIp.a(this.dIZ);
            Intent intent = getActivity().getIntent();
            if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                this.dHR = true;
            }
            this.dId = new k(this, this.dJo, this.dHP, this.dHR, this.dIo);
            this.dId.setHeaderViewHeight(this.dIG);
            this.dIP = new com.baidu.tieba.frs.brand.buttommenu.a(getPageContext(), this.mRootView);
        } else {
            if (this.mRootView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            if (this.dIp != null) {
                this.dIp.registerListener();
            }
            this.dId.aBX();
        }
        this.dIS = true;
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        this.doE = System.currentTimeMillis();
        this.beginTime = this.doE;
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.dIa = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.doE = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            M(intent);
        }
        this.bfN = this.beginTime - this.doE;
        this.dHZ = new com.baidu.tieba.tbadkCore.data.e("frs", com.baidu.tieba.tbadkCore.data.e.hkL);
        if (this.dIn == null) {
            this.dIn = new FrsModelController(this, this.dJk);
            this.dIn.a(this.dIY);
            this.dIn.init();
        }
        if (intent != null) {
            this.dIn.p(intent.getExtras());
        } else if (bundle != null) {
            this.dIn.p(bundle);
        } else {
            this.dIn.p(null);
        }
        if (intent != null) {
            this.dIo.t(intent.getExtras());
        } else if (bundle != null) {
            this.dIo.t(bundle);
        } else {
            this.dIo.t(null);
        }
        this.dIc = getVoiceManager();
        this.dID = new j(getPageContext(), this);
        initUI();
        initData(bundle);
        if (!aBb()) {
            this.dIt = new an(getActivity(), this.dId, this.dIo);
            this.dIt.gO(true);
        }
        this.dIc = getVoiceManager();
        if (this.dIc != null) {
            this.dIc.onCreate(getPageContext());
        }
        new com.baidu.tieba.frs.mc.g();
        this.dIz = new com.baidu.tieba.frs.mc.c(this, this.dJm);
        this.dIr = new com.baidu.tieba.frs.smartsort.b(this);
        this.dIA = new com.baidu.tieba.frs.vc.h(this);
        this.dIx = new com.baidu.tieba.frs.vc.a(getPageContext(), this.dIn.aGt());
        this.dIs = new com.baidu.tieba.frs.mc.b(this);
        this.dIy = new com.baidu.tieba.frs.mc.d(this);
        this.dIq = new com.baidu.tieba.frs.mc.f(this);
        this.dIB = new com.baidu.tieba.frs.mc.a(this);
        this.dIE = new com.baidu.tieba.frs.vc.c(this);
        this.dIF = new com.baidu.tieba.frs.mc.e(this, getUniqueId());
        this.dIM = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "frs");
        this.dIN = new com.baidu.tieba.ala.a(getPageContext());
        registerListener(this.bVk);
        registerListener(this.mMemListener);
        registerListener(this.dJf);
        registerListener(this.dJn);
        registerListener(this.dJe);
        registerListener(this.dJl);
        registerListener(this.dJb);
        registerListener(this.dJc);
        registerListener(this.dJd);
        registerListener(this.dIV);
        registerListener(this.dIW);
        registerListener(this.dJs);
        registerListener(this.dJi);
        registerListener(this.dIX);
        registerListener(this.dJj);
        registerListener(this.dJh);
        this.dIU.setTag(getPageContext().getUniqueId());
        registerListener(this.dIU);
        registerListener(this.akA);
        this.dId.gz(false);
        if (!aBb() && !this.hasInit) {
            showLoadingView(this.dId.aBQ(), true);
            this.dIn.r(3, false);
        }
        com.baidu.tieba.frs.a.azU().a(new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.16
            @Override // com.baidu.tieba.frs.a.b
            public void y(boolean z, boolean z2) {
                if (FrsFragment.this.dId != null) {
                    FrsFragment.this.dId.md(z ? 0 : 8);
                    if (!z2) {
                        FrsFragment.this.dIR = z;
                    }
                    if (FrsFragment.this.dId.aBP() != null && FrsFragment.this.dIn != null && FrsFragment.this.dIn.aGn()) {
                        FrsFragment.this.dId.aBP().notifyDataSetChanged();
                    }
                    if (FrsFragment.this.dId.aBz() != null) {
                        FrsFragment.this.dId.gw(!z);
                    }
                    if (FrsFragment.this.getActivity() instanceof FrsActivity) {
                        ((FrsActivity) FrsFragment.this.getActivity()).gp(!z);
                    }
                    if (FrsFragment.this.dIP != null) {
                        FrsFragment.this.dIP.gX(!z);
                    }
                    FrsFragment.this.dId.gB(!z);
                    FrsFragment.this.dId.gC(z ? false : true);
                }
            }

            @Override // com.baidu.tieba.frs.a.b
            public void lS(int i) {
                if (FrsFragment.this.dId != null) {
                    FrsFragment.this.dId.me(i);
                }
            }

            @Override // com.baidu.tieba.frs.a.b
            public void aAa() {
                com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getContext(), e.j.frs_multi_delete_max_num);
            }
        });
        this.dId.b(new d.a() { // from class: com.baidu.tieba.frs.FrsFragment.17
            @Override // com.baidu.tieba.NEGFeedBack.d.a
            public void a(DeleteThreadHttpResponseMessage deleteThreadHttpResponseMessage) {
                int i;
                int i2 = 0;
                if (deleteThreadHttpResponseMessage != null) {
                    FrsFragment.this.dId.Uz();
                    FrsFragment.this.dId.aBZ();
                    if (deleteThreadHttpResponseMessage.getError() == 0) {
                        String text = !TextUtils.isEmpty(deleteThreadHttpResponseMessage.getText()) ? deleteThreadHttpResponseMessage.getText() : FrsFragment.this.getString(e.j.delete_fail);
                        if (deleteThreadHttpResponseMessage.getRetType() == 1211066) {
                            if (FrsFragment.this.cXb == null) {
                                FrsFragment.this.cXb = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.cXb.eB(text);
                            FrsFragment.this.cXb.a(e.j.dialog_known, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.17.1
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.cXb.bg(false);
                            FrsFragment.this.cXb.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.cXb.BF();
                        } else if (deleteThreadHttpResponseMessage.getRetType() == 1211067) {
                            if (FrsFragment.this.cXb == null) {
                                FrsFragment.this.cXb = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.cXb.eB(text);
                            FrsFragment.this.cXb.a(e.j.know, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.17.2
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.cXb.bg(false);
                            FrsFragment.this.cXb.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.cXb.BF();
                        } else {
                            FrsFragment.this.dId.ac(deleteThreadHttpResponseMessage.getText(), ContextCompat.getColor(FrsFragment.this.getContext(), deleteThreadHttpResponseMessage.getRetType() == 1 ? e.d.nav_bar_tip_error : e.d.cp_link_tip_a_alpha95));
                        }
                        FrsFragment.this.bC(deleteThreadHttpResponseMessage.getSuccessItems());
                        com.baidu.tieba.frs.a.azU().bB(deleteThreadHttpResponseMessage.getSuccessItems());
                        Iterator<com.baidu.adp.widget.ListView.h> it = FrsFragment.this.dHF.getThreadList().iterator();
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
                            FrsFragment.this.aab();
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

    public void gr(boolean z) {
        if (this.dIp != null) {
            this.dIp.edY = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bC(List<String> list) {
        if (!com.baidu.tbadk.core.util.v.I(list)) {
            ArrayList<com.baidu.adp.widget.ListView.h> threadList = this.dHF.getThreadList();
            if (!com.baidu.tbadk.core.util.v.I(threadList) && this.dId.getListView() != null && this.dId.getListView().getData() != null) {
                Iterator<com.baidu.adp.widget.ListView.h> it = threadList.iterator();
                List<com.baidu.adp.widget.ListView.h> data = this.dId.getListView().getData();
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
                                this.dIz.ab(bbVar);
                                this.dId.getListView().getAdapter().notifyItemRemoved(i);
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
    public void aaB() {
        if (isAdded() && this.bRT && !isLoadingViewAttached()) {
            showLoadingView(this.dId.aBQ(), true);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void aaC() {
        if (isAdded() && this.bRT && isLoadingViewAttached()) {
            hideLoadingView(this.dId.aBQ());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (aBb()) {
            showLoadingView(this.dId.aBQ(), true);
            this.dId.mf(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.dIn.r(3, true);
            Fu().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void setHeaderViewHeight(int i) {
        this.dIG = i;
        if (this.dId != null) {
            this.dId.setHeaderViewHeight(this.dIG);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.u uVar) {
        if (uVar != null) {
            this.biL = uVar.Qd();
            this.dIH = uVar.Qe();
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void showFloatingView() {
        if (this.biL != null) {
            this.biL.cS(true);
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
                this.dHV = data.getQueryParameter("name");
                this.mFrom = data.getQueryParameter("from");
                if (!StringUtils.isNull(this.dHV)) {
                    intent.putExtra("name", this.dHV);
                }
                if (!StringUtils.isNull(this.mFrom)) {
                    intent.putExtra("from", this.mFrom);
                }
                TiebaStatic.log("c10105");
            }
            if (StringUtils.isNull(this.dHV) && intent != null && intent.getData() != null) {
                Uri data2 = intent.getData();
                if (com.baidu.tbadk.BdToken.f.e(data2)) {
                    com.baidu.tbadk.BdToken.f.vF().b(data2, new f.a() { // from class: com.baidu.tieba.frs.FrsFragment.18
                        @Override // com.baidu.tbadk.BdToken.f.a
                        public void n(HashMap<String, Object> hashMap) {
                            if (hashMap != null && (hashMap.get(com.baidu.tbadk.BdToken.f.akS) instanceof String)) {
                                FrsFragment.this.dHV = (String) hashMap.get(com.baidu.tbadk.BdToken.f.akS);
                            }
                        }
                    });
                } else {
                    com.baidu.tieba.frs.f.d O = com.baidu.tieba.frs.f.i.O(intent);
                    if (O != null) {
                        this.dHV = O.forumName;
                        if (O.ecq != null && O.ecq.equals("aidou")) {
                            com.baidu.tbadk.core.dialog.h.axh = System.currentTimeMillis();
                        }
                    }
                }
                if (!StringUtils.isNull(this.dHV)) {
                    intent.putExtra("name", this.dHV);
                }
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.dIc = getVoiceManager();
        if (this.dIc != null) {
            this.dIc.onStart(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        Intent intent;
        registerListener(2001118, this.aPU);
        if (bundle != null) {
            this.dHV = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
            this.dHV = intent.getStringExtra("name");
            this.mFrom = intent.getStringExtra("from");
            this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
        }
        if (getArguments() != null) {
            this.dHW = getArguments().getBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, false);
        }
        if (TextUtils.isEmpty(this.mFrom) || FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
        }
        if (this.mIsLogin) {
            registerListener(2001120, this.aPU);
        }
        this.dIo.t(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dJs);
        if (this.dIc != null) {
            this.dIc.onDestory(getPageContext());
        }
        com.baidu.tieba.recapp.report.a.remove("FRS");
        this.dIc = null;
        com.baidu.tieba.card.v.apD().ft(false);
        if (this.dHF != null && this.dHF.bgh() != null) {
            ac.aCx().bV(com.baidu.adp.lib.g.b.d(this.dHF.bgh().getId(), 0L));
        }
        if (this.dIC != null) {
            this.dIC.onDestory();
        }
        if (this.dId != null) {
            com.baidu.tieba.frs.f.h.a(this.dId, this.dHF, getForumId(), false, null);
            this.dId.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.dIl != null) {
                this.dIl.Pc();
            }
            this.dId.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.dIo.onActivityDestroy();
        if (this.dIn != null) {
            this.dIn.acl();
        }
        if (this.dIt != null) {
            this.dIt.Qc();
        }
        if (this.dIw != null) {
            this.dIw.destory();
        }
        if (this.dIx != null) {
            this.dIx.destory();
        }
        if (this.dIr != null) {
            this.dIr.onDestroy();
        }
        if (this.dIJ != null) {
            this.dIJ.onDestory();
        }
        if (this.dIB != null) {
            this.dIB.onDestroy();
        }
        if (this.dIM != null) {
            this.dIM.onDestroy();
        }
        if (this.dIN != null) {
            this.dIN.onDestroy();
        }
        com.baidu.tieba.recapp.d.a.bvo().bvq();
        com.baidu.tieba.frs.f.j.aGQ();
        if (this.dIp != null) {
            this.dIp.a((FrsTabViewController.a) null);
            this.dIp.aHy();
        }
        if (this.dIO != null) {
            this.dIO.onDestroy();
        }
        if (this.dIQ != null) {
            this.dIQ.onDestroy();
        }
        com.baidu.tieba.frs.a.azU().a(null);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.dHV);
        bundle.putString("from", this.mFrom);
        this.dIn.onSaveInstanceState(bundle);
        if (this.dIc != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            this.dIc.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.dIB != null) {
            this.dIB.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dId != null) {
            this.dId.aBF();
            this.dId.onResume();
        }
        this.dIq.hm(true);
        this.dIm = true;
        if (dHU) {
            dHU = false;
            this.dId.startPullRefresh();
            return;
        }
        if (this.dIc != null) {
            this.dIc.onResume(getPageContext());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921338));
        this.dId.gD(false);
        if (this.dIK) {
            refresh(6);
            this.dIK = false;
        }
        aBh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
    }

    public boolean aAR() {
        Intent intent;
        if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
            return false;
        }
        return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
    }

    public void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.dHV = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.dHX = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.dHX) {
                aAS();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAS() {
        this.dId.startPullRefresh();
    }

    public void closeActivity() {
        com.baidu.tieba.frs.f.i.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.mFrom);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.dId.setTitle(this.dHV);
        } else {
            this.dId.setTitle("");
            this.mFlag = 1;
        }
        this.dId.setOnAdapterItemClickListener(this.dJq);
        this.dId.addOnScrollListener(this.mScrollListener);
        this.dId.h(this.dFP);
        this.dId.aBP().a(this.dJp);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dIS) {
            this.dId.onChangeSkinType(i);
            this.dIo.ns(i);
            this.dIp.onChangeSkinType(i);
            if (this.dII != null) {
                this.dII.onChangeSkinType();
            }
            if (this.dIO != null) {
                this.dIO.onChangeSkinType(i);
            }
            if (this.dIP != null) {
                this.dIP.d(getPageContext(), i);
            }
            if (this.cXb != null) {
                com.baidu.tbadk.o.a.a(getPageContext(), this.cXb.BG());
            }
        }
    }

    public void lX(int i) {
        if (!this.mIsLogin) {
            if (this.dHF != null && this.dHF.yE() != null) {
                this.dHF.yE().setIfpost(1);
            }
            if (i == 0) {
                ba.bI(getActivity());
            }
        } else if (this.dHF != null) {
            if (i == 0) {
                com.baidu.tieba.frs.f.j.d(this, 0);
            } else {
                this.dId.aBH();
            }
        }
    }

    public void refresh() {
        com.baidu.tieba.a.d.VM().jJ("page_frs");
        refresh(3);
    }

    public void refresh(int i) {
        this.dIj = false;
        aAX();
        if (this.dId.aBx() != null) {
            this.dId.aBx().aMw();
        }
        this.dIn.r(i, true);
    }

    private void aAT() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.g.h.jH().d(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.22
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.vL(FrsFragment.this.dHV);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAU() {
        aAX();
        try {
            if (this.dHF != null) {
                this.dId.amN();
                this.dId.gw(aBg());
                if (!com.baidu.tieba.frs.vc.f.l(this.dHF) || !com.baidu.tieba.frs.vc.f.k(this.dHF)) {
                }
                if (this.dHF.bgh() != null) {
                    this.dHV = this.dHF.bgh().getName();
                    this.forumId = this.dHF.bgh().getId();
                }
                if (this.dHF.yS() != null) {
                    setHasMore(this.dHF.yS().yP());
                }
                this.dId.setTitle(this.dHV);
                this.dId.setForumName(this.dHV);
                TbadkCoreApplication.getInst().setDefaultBubble(this.dHF.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.dHF.getUserData().getBimg_end_time());
                aAT();
                aAV();
                ArrayList<com.baidu.adp.widget.ListView.h> threadList = this.dHF.getThreadList();
                if (threadList != null) {
                    this.dId.a(threadList, this.dHF);
                    com.baidu.tieba.frs.f.c.w(this.dId);
                    this.dIo.nt(getPageNum());
                    this.dIo.i(this.dHF);
                    this.dIp.a(this.dHF, this.dIn.aGs());
                    this.dId.aBI();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void aAV() {
        if (this.dHF != null) {
            if (this.dHF.bgw() == 1) {
                this.dId.aBP().setFromCDN(true);
            } else {
                this.dId.aBP().setFromCDN(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.dIq.hm(false);
        this.dIm = false;
        this.dId.onPause();
        if (this.dIc != null) {
            this.dIc.onPause(getPageContext());
        }
        this.dId.gD(true);
        if (this.dIx != null) {
            this.dIx.aGT();
        }
        com.baidu.tbadk.BdToken.c.vu().vv();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.dIp != null && this.dIp.aHw() != null && (this.dIp.aHw().fragment instanceof BaseFragment)) {
            ((BaseFragment) this.dIp.aHw().fragment).setPrimary(z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.v.apD().ft(false);
        if (this.dHF != null && this.dHF.bgh() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            com.baidu.tbadk.distribute.a.LK().a(getPageContext().getPageActivity(), "frs", this.dHF.bgh().getId(), 0L);
        }
        if (this.dIc != null) {
            this.dIc.onStop(getPageContext());
        }
        if (Fu() != null) {
            Fu().getRecycledViewPool().clear();
        }
        this.dIo.onActivityStop();
        com.baidu.tbadk.util.v.Qg();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            if (this.dIo != null) {
                this.dIo.gu(isPrimary());
            }
            if (this.dId != null) {
                this.dId.gu(isPrimary());
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (com.baidu.tieba.frs.a.azU().azV()) {
                com.baidu.tieba.frs.a.azU().reset();
                return true;
            } else if (this.dId != null) {
                return this.dId.aBE();
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
        com.baidu.tbadk.distribute.a.LK().a(advertAppInfo, this.forumId, 0L, "FRS", str, getPn());
    }

    @Override // com.baidu.tieba.recapp.n
    public void aAW() {
        aAD().aAW();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dIc == null) {
            this.dIc = VoiceManager.instance();
        }
        return this.dIc;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdRecyclerView Fu() {
        if (this.dId == null) {
            return null;
        }
        return this.dId.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void aAX() {
        if (this.dIc != null) {
            this.dIc.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> Fv() {
        if (this.aKN == null) {
            this.aKN = UserIconBox.l(getPageContext().getPageActivity(), 8);
        }
        return this.aKN;
    }

    public void aAY() {
        if (getFragmentActivity() != null && getFragmentActivity().getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.b(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.k onGetPreLoadListView() {
        return Fu().getPreLoadHandle();
    }

    @Override // com.baidu.tieba.frs.ak
    public NavigationBar abU() {
        if (this.dId == null) {
            return null;
        }
        return this.dId.abU();
    }

    @Override // com.baidu.tbadk.core.view.NavigationBar.a
    public void b(Pair<Integer, Integer> pair) {
        this.dIh = pair;
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
                if (bdUniqueId == p.dKL) {
                    if (FrsFragment.this.dId != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11752").aA(ImageViewerConfig.FORUM_ID, FrsFragment.this.forumId).aA("obj_locate", "1"));
                        FrsFragment.this.dId.startPullRefresh();
                    }
                } else if (hVar != null && (hVar instanceof bb)) {
                    bb bbVar = (bb) hVar;
                    if (bbVar.As() == null || bbVar.As().getGroup_id() == 0 || ba.bJ(FrsFragment.this.getActivity())) {
                        if (bbVar.Ak() != 1 || ba.bJ(FrsFragment.this.getActivity())) {
                            if (bbVar.zU() != null) {
                                if (ba.bJ(FrsFragment.this.getActivity())) {
                                    String postUrl = bbVar.zU().getPostUrl();
                                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.ll()) {
                                        com.baidu.tbadk.browser.a.af(FrsFragment.this.getActivity(), postUrl);
                                    }
                                }
                            } else if (bbVar.AB() != null) {
                                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                    ba.bI(FrsFragment.this.getPageContext().getPageActivity());
                                    return;
                                }
                                com.baidu.tbadk.core.data.m AB = bbVar.AB();
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), AB.getCartoonId(), AB.getChapterId(), 2)));
                            } else {
                                com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                                if (readThreadHistory != null && !readThreadHistory.vR(bbVar.getId())) {
                                    readThreadHistory.vQ(bbVar.getId());
                                }
                                boolean z = false;
                                final String zO = bbVar.zO();
                                if (zO != null && !zO.equals("")) {
                                    z = true;
                                    new Thread(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.a.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(zO);
                                            xVar.Dj().Eh().mIsNeedAddCommenParam = false;
                                            xVar.Dj().Eh().mIsUseCurrentBDUSS = false;
                                            xVar.CM();
                                        }
                                    }).start();
                                }
                                String tid = bbVar.getTid();
                                if (tid == null) {
                                    tid = "";
                                }
                                if (bbVar.zB() == 2 && !tid.startsWith("pb:")) {
                                    ay.Ef().c(FrsFragment.this.getPageContext(), new String[]{tid, "", null});
                                    return;
                                }
                                if (tid.startsWith("pb:")) {
                                    bbVar.setId(tid.substring(3));
                                }
                                if (bdUniqueId.getId() == bb.auD.getId()) {
                                    com.baidu.tieba.frs.f.h.a(bbVar.zn());
                                } else if (bdUniqueId.getId() == bb.atn.getId()) {
                                    com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c12940");
                                    amVar.aA("obj_type", "2");
                                    amVar.aA("tid", bbVar.getTid());
                                    TiebaStatic.log(amVar);
                                }
                                com.baidu.tieba.frs.f.i.a(FrsFragment.this, bbVar, i, z);
                                com.baidu.tieba.frs.f.h.a(FrsFragment.this, FrsFragment.this.dHF, bbVar);
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
            hideNetRefreshView(this.dId.aBQ());
            showLoadingView(this.dId.aBQ(), true);
            this.dId.gz(false);
            this.dIn.r(3, true);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public com.baidu.tieba.tbadkCore.l aAZ() {
        return this.dHF;
    }

    public boolean aBa() {
        return this.dId.aBa();
    }

    public void ac(Object obj) {
        if (this.dIs != null && this.dIs.dZM != null) {
            this.dIs.dZM.m(obj);
        }
    }

    public void ad(Object obj) {
        if (this.dIs != null && this.dIs.dZN != null) {
            this.dIs.dZN.m(obj);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        this.dId.getListView().stopScroll();
        if (!this.dId.aBL()) {
            if (!com.baidu.adp.lib.util.l.ll()) {
                this.dId.abb();
            } else if (this.dIn.aGm() == 1) {
                aap();
                aab();
            } else if (this.dIn.hasMore()) {
                aab();
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void nH(String str) {
        aap();
        showToast(str);
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void O(ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        boolean I = com.baidu.tbadk.core.util.v.I(arrayList);
        setHasMore(I ? 0 : 1);
        aap();
        if (!I) {
            if (!this.dIn.aGw() && TbadkCoreApplication.getInst().isRecAppExist() && this.dIn.aGm() == 1) {
                this.dHF.a(this, arrayList);
            }
            ArrayList<com.baidu.adp.widget.ListView.h> a2 = this.dIz.a(false, false, arrayList, this.dHZ, false);
            if (a2 != null) {
                this.dHF.ax(a2);
                this.dId.a(a2, this.dHF);
            }
            if (this.dIn != null) {
                com.baidu.tieba.frs.e.b.a(this.dHF, this.dIn.aGs(), 2);
            }
        }
    }

    private void aap() {
        if (aAJ() == 1 || this.dIz.bO(this.dHF.bBv())) {
            if (com.baidu.tbadk.core.util.v.H(this.dHF.getThreadList()) > 3) {
                this.dId.aaZ();
            } else {
                this.dId.aBT();
            }
        } else if (com.baidu.tbadk.core.util.v.I(this.dHF.getThreadList())) {
            this.dId.abb();
        } else {
            this.dId.aba();
        }
    }

    @Override // com.baidu.tieba.frs.mc.j
    public void aab() {
        if (this.dIz != null) {
            this.dIz.a(this.dHV, this.forumId, this.dHF);
        }
    }

    public void takePhoto() {
        if (!com.baidu.tbadk.core.util.ab.e(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.ak.b(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        if (this.dIi) {
            return null;
        }
        if (aBb()) {
            return "a034";
        }
        return "a006";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (!aBb()) {
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

    public void gs(boolean z) {
        if (this.dIt != null) {
            this.dIt.gO(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.dIu.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a hs(int i) {
        return this.dIu.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        this.dID.b(bVar);
    }

    public boolean aBb() {
        return this.dHR;
    }

    @Override // com.baidu.tieba.frs.ah
    public void aaA() {
        if (this.dId != null) {
            showFloatingView();
            this.dId.getListView().scrollToPosition(0);
            this.dId.startPullRefresh();
        }
    }

    public ForumWriteData aBc() {
        if (this.dHF == null || this.dHF.bgh() == null) {
            return null;
        }
        ForumData bgh = this.dHF.bgh();
        ForumWriteData forumWriteData = new ForumWriteData(bgh.getId(), bgh.getName(), bgh.getPrefixData(), this.dHF.yE());
        forumWriteData.avatar = bgh.getImage_url();
        forumWriteData.forumLevel = bgh.getUser_level();
        forumWriteData.specialForumType = bgh.special_forum_type;
        forumWriteData.firstDir = bgh.getFirst_class();
        forumWriteData.secondDir = bgh.getSecond_class();
        UserData userData = this.dHF.getUserData();
        forumWriteData.privateThread = userData != null ? userData.getPrivateThread() : 0;
        return forumWriteData;
    }

    @Override // com.baidu.tieba.frs.ah
    public void Fj() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.frs.ah
    public void setVideoThreadId(String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z) {
        super.showLoadingView(view, z);
        this.dId.mc(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        super.hideLoadingView(view);
        this.dId.mc(0);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        super.showNetRefreshView(view, str, z);
        this.dId.mc(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshViewNoClick(View view, String str, boolean z) {
        super.showNetRefreshViewNoClick(view, str, z);
        this.dId.mc(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        super.hideNetRefreshView(view);
        this.dId.mc(0);
    }

    public void aBd() {
        FrsTabViewController.b aHw;
        if (this.dIp != null && (aHw = this.dIp.aHw()) != null && aHw.fragment != null && (aHw.fragment instanceof aj)) {
            ((aj) aHw.fragment).aAs();
        }
    }

    public void a(ContriInfo contriInfo) {
        if (this.dIO == null) {
            this.dIO = new com.baidu.tbadk.core.dialog.h(getTbPageContext());
            this.dIO.a(new h.a() { // from class: com.baidu.tieba.frs.FrsFragment.31
                @Override // com.baidu.tbadk.core.dialog.h.a
                public void bn(boolean z) {
                    if (z) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13061"));
                    }
                }
            });
        }
        this.dIO.a(contriInfo, -1L);
    }

    public void gt(boolean z) {
        this.dHT = z;
    }

    public boolean aBe() {
        return this.dHT;
    }

    public void nZ(String str) {
        if (TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.util.ao.isEmpty(str)) {
            if (this.dIQ == null) {
                this.dIQ = new AddExperiencedModel(getTbPageContext());
                this.dIQ.a(this.dIT);
            }
            this.dIQ.cE(this.forumId, str);
        }
    }

    public com.baidu.tieba.frs.entelechy.b aBf() {
        return this.dHP;
    }

    public boolean aBg() {
        return (this.dIn != null && this.dIn.aGn() && com.baidu.tieba.frs.a.azU().azV()) ? false : true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.e.c
    public boolean videoNeedPreload() {
        if (this.dHF != null) {
            return com.baidu.tbadk.util.aa.Qn() && (this.dHF.hjC || com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("auto_play_video_frs", 0) == 1);
        }
        return super.videoNeedPreload();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBh() {
        if (!com.baidu.tbadk.core.util.ao.isEmpty(this.forumId)) {
            com.baidu.tbadk.BdToken.c.vu().g(com.baidu.tbadk.BdToken.b.ajP, com.baidu.adp.lib.g.b.d(this.forumId, 0L));
        }
    }
}
