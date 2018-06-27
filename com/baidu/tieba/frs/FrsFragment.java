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
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.dialog.h;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.bb;
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
    private com.baidu.tbadk.util.s aWC;
    private com.baidu.adp.lib.e.b<TbImageView> azg;
    private com.baidu.tieba.frs.gametab.b bEN;
    private FrsModelController djL;
    private com.baidu.tieba.frs.vc.f djM;
    private FrsTabViewController djN;
    private com.baidu.tieba.frs.mc.f djO;
    private com.baidu.tieba.frs.smartsort.b djP;
    private com.baidu.tieba.frs.mc.b djQ;
    private an djR;
    private com.baidu.tieba.frs.entelechy.b.b djT;
    private com.baidu.tbadk.h.a djU;
    private com.baidu.tieba.frs.vc.a djV;
    private com.baidu.tieba.frs.mc.d djW;
    private com.baidu.tieba.frs.mc.c djX;
    private com.baidu.tieba.frs.vc.h djY;
    private com.baidu.tieba.frs.mc.a djZ;
    private com.baidu.tieba.frs.entelechy.b djm;
    private com.baidu.tieba.tbadkCore.data.e djw;
    private VoiceManager djz;
    private com.baidu.tieba.frs.live.a dka;
    private j dkb;
    public com.baidu.tieba.frs.vc.c dkc;
    private com.baidu.tieba.frs.mc.e dkd;
    private int dke;
    private View.OnTouchListener dkf;
    private com.baidu.tieba.frs.view.a dkg;
    private com.baidu.tieba.frs.vc.e dkh;
    private boolean dki;
    private com.baidu.tieba.NEGFeedBack.a dkk;
    private com.baidu.tieba.ala.a dkl;
    private com.baidu.tbadk.core.dialog.h dkm;
    private com.baidu.tieba.frs.brand.buttommenu.a dkn;
    private AddExperiencedModel dko;
    private int dkx;
    public View mRootView;
    public static boolean djr = false;
    public static volatile long djC = 0;
    public static volatile long djD = 0;
    public static volatile int djE = 0;
    public boolean djn = false;
    private boolean djo = false;
    private boolean djp = false;
    private boolean djq = true;
    public String djs = null;
    public String mFrom = null;
    public int mFlag = 0;
    public boolean djt = false;
    private boolean dju = false;
    private String mThreadId = null;
    public String forumId = null;
    private int djf = 0;
    private boolean djv = false;
    private boolean djx = false;
    private boolean djy = false;
    private k djA = null;
    public final bc btP = null;
    private com.baidu.tieba.tbadkCore.l djc = new com.baidu.tieba.tbadkCore.l();
    public long cQb = -1;
    public long aTS = 0;
    public long aTK = 0;
    public long createTime = 0;
    public long beginTime = -1;
    public long djB = 0;
    public Pair<Integer, Integer> djF = null;
    public boolean djG = false;
    private boolean djH = false;
    private boolean djI = false;
    public com.baidu.tbadk.k.b djJ = null;
    private boolean djK = true;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> djS = new SparseArray<>();
    private boolean byr = true;
    private boolean dkj = false;
    private boolean dkp = false;
    private AddExperiencedModel.a dkq = new AddExperiencedModel.a() { // from class: com.baidu.tieba.frs.FrsFragment.1
        @Override // com.baidu.tieba.share.AddExperiencedModel.a
        public void b(ContriInfo contriInfo) {
            if (contriInfo != null && contriInfo.isShowToast()) {
                FrsFragment.this.a(contriInfo);
            }
        }
    };
    private HttpMessageListener dkr = new HttpMessageListener(CmdConfigHttp.CMD_PB_FLOOR_AGREE, true) { // from class: com.baidu.tieba.frs.FrsFragment.12
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
    private final CustomMessageListener dks = new CustomMessageListener(2016495) { // from class: com.baidu.tieba.frs.FrsFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof bc) {
                    com.baidu.tieba.frs.f.h.a(FrsFragment.this.djA, FrsFragment.this.djc, FrsFragment.this.getForumId(), true, (bc) data);
                }
            }
        }
    };
    private CustomMessageListener dkt = new CustomMessageListener(2921005) { // from class: com.baidu.tieba.frs.FrsFragment.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.djc != null) {
                FrsFragment.this.djc.bwD();
                if (FrsFragment.this.djA != null) {
                    FrsFragment.this.djA.ajF();
                }
            }
        }
    };
    private CustomMessageListener dku = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.FrsFragment.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 1) {
                    FrsFragment.this.atS();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                }
            }
        }
    };
    private final al dkv = new al() { // from class: com.baidu.tieba.frs.FrsFragment.35
        @Override // com.baidu.tieba.frs.al
        public void a(int i, int i2, ar arVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
            FrsFragment.this.atL();
            if (FrsFragment.this.djT != null) {
                FrsFragment.this.djM.gm(FrsFragment.this.djT.kG(i));
            }
            d.a aVar = new d.a();
            if (arVar != null) {
                aVar.isSuccess = arVar.errCode == 0;
                aVar.errorCode = arVar.errCode;
                aVar.errorMsg = arVar.errMsg;
                if (aVar.isSuccess) {
                    if (com.baidu.tbadk.core.util.w.A(arrayList)) {
                        FrsFragment.this.djA.Uf();
                    } else if (arVar.hasMore) {
                        if (com.baidu.tbadk.core.util.w.z(FrsFragment.this.djc.getThreadList()) > 3) {
                            FrsFragment.this.djA.Ud();
                        } else {
                            FrsFragment.this.djA.auT();
                        }
                    } else if (arVar.dmY) {
                        FrsFragment.this.djA.Ue();
                    } else {
                        FrsFragment.this.djA.Uf();
                    }
                }
            } else {
                arVar = new ar();
                arVar.pn = 1;
                arVar.hasMore = false;
                arVar.dmY = false;
            }
            if (i == 1) {
                FrsFragment.this.djK = true;
                FrsFragment.this.dkH.a(FrsFragment.this.djL.getType(), false, aVar);
            } else {
                FrsFragment.this.a(aVar);
                if (FrsFragment.this.djL.ayA() != null) {
                    FrsFragment.this.djc = FrsFragment.this.djL.ayA();
                }
                FrsFragment.this.atU();
            }
            if (FrsFragment.this.dkO != null) {
                FrsFragment.this.dkO.a(i, i2, arVar, arrayList);
            }
        }
    };
    private FrsTabViewController.a dkw = new FrsTabViewController.a() { // from class: com.baidu.tieba.frs.FrsFragment.36
        @Override // com.baidu.tieba.frs.vc.FrsTabViewController.a
        public void eY(int i) {
            boolean z = false;
            if (i != 1) {
                com.baidu.tieba.card.v.aiz().ex(false);
            }
            if (i == 303 && i != FrsFragment.this.dkx) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13121").ah(ImageViewerConfig.FORUM_ID, FrsFragment.this.forumId).ah("uid", TbadkCoreApplication.getCurrentAccount()));
            }
            FrsFragment.this.dkx = i;
            FrsFragment.this.atX();
            com.baidu.tieba.frs.e.c.drl.dBU = i;
            com.baidu.tieba.frs.e.c.drl.dBV = -1;
            com.baidu.tieba.frs.a asZ = com.baidu.tieba.frs.a.asZ();
            if (i == 1 && FrsFragment.this.dkp) {
                z = true;
            }
            asZ.s(z, true);
        }
    };
    private CustomMessageListener dky = new CustomMessageListener(2001606) { // from class: com.baidu.tieba.frs.FrsFragment.37
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                FrsFragment.this.djN.lH(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    };
    private CustomMessageListener dkz = new CustomMessageListener(2001607) { // from class: com.baidu.tieba.frs.FrsFragment.38
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && ((Integer) customResponsedMessage.getData()).intValue() == 51 && FrsFragment.this.djc != null) {
                com.baidu.tieba.frs.f.j.a(FrsFragment.this.djc, FrsFragment.this.getPageContext());
            }
        }
    };
    private final CustomMessageListener dkA = new CustomMessageListener(2003019) { // from class: com.baidu.tieba.frs.FrsFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                FrsFragment.this.djN.lF(49);
            }
        }
    };
    private final CustomMessageListener dkB = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.frs.FrsFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && FrsFragment.this.djc != null && FrsFragment.this.djc.baT() != null) {
                SignData signData = (SignData) customResponsedMessage.getData();
                int user_level = FrsFragment.this.djc.baT().getUser_level();
                if (signData.forumId != null && signData.forumId.equals(FrsFragment.this.djc.baT().getId())) {
                    FrsFragment.this.djc.d(signData);
                    FrsFragment.this.djM.i(FrsFragment.this.djc);
                    if (FrsFragment.this.djM.aAb()) {
                        i = FrsFragment.this.djc.baT().getUser_level();
                        if (user_level >= i) {
                            i++;
                        }
                    } else {
                        i = user_level;
                    }
                    TbadkCoreApplication.getInst().addSignedForum(FrsFragment.this.djc.baT().getName(), signData.sign_bonus_point, i);
                }
            }
        }
    };
    private final CustomMessageListener dkC = new CustomMessageListener(2001352) { // from class: com.baidu.tieba.frs.FrsFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.r) && FrsFragment.this.djc != null) {
                FrsFragment.this.djc.c((com.baidu.tieba.tbadkCore.r) customResponsedMessage.getData());
                FrsFragment.this.djM.h(FrsFragment.this.djc);
                FrsFragment.this.djN.a(FrsFragment.this.djc, FrsFragment.this.djL.azf());
            }
        }
    };
    private final AntiHelper.a dkD = new AntiHelper.a() { // from class: com.baidu.tieba.frs.FrsFragment.5
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12536").r("obj_locate", at.a.arP));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12535").r("obj_locate", at.a.arP));
        }
    };
    private CustomMessageListener bBI = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.frs.FrsFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(FrsFragment.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().aDu != null) {
                        if (AntiHelper.a(FrsFragment.this.getActivity(), updateAttentionMessage.getData().aDu, FrsFragment.this.dkD) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12534").r("obj_locate", at.a.arP));
                        }
                    } else if (updateAttentionMessage.getData().Gr && updateAttentionMessage.getData().isAttention) {
                        com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getPageContext().getPageActivity(), d.k.attention_success);
                    }
                }
            }
        }
    };
    private CustomMessageListener dkE = new CustomMessageListener(2921346) { // from class: com.baidu.tieba.frs.FrsFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsFragment.this.refresh();
        }
    };
    private CustomMessageListener dkF = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.frs.FrsFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                FrsFragment.this.djA.c((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener dkG = new CustomMessageListener(2001626) { // from class: com.baidu.tieba.frs.FrsFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewsRemindMessage newsRemindMessage;
            if (customResponsedMessage != null && (customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626 && (newsRemindMessage = (NewsRemindMessage) customResponsedMessage) != null) {
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (FrsFragment.this.djA != null) {
                    FrsFragment.this.djA.p(notificationCount, z);
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.n dkH = new com.baidu.tieba.tbadkCore.n() { // from class: com.baidu.tieba.frs.FrsFragment.10
        private long startTime = 0;

        @Override // com.baidu.tieba.tbadkCore.n
        public void kj(int i) {
            this.startTime = System.nanoTime();
            if (FrsFragment.this.djA != null) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsFragment.this.djA.auG();
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
            if (FrsFragment.this.byr) {
                FrsFragment.this.byr = false;
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.djA, FrsFragment.this.djc, FrsFragment.this.getForumId(), false, null);
            }
            FrsFragment.this.atL();
            FrsFragment.this.djH = true;
            if (aVar != null && aVar.isSuccess) {
                FrsFragment.this.djA.auQ().fX(com.baidu.tbadk.core.util.ar.zF().zH());
                FrsFragment.djC = 0L;
                FrsFragment.djD = 0L;
                FrsFragment.djE = 0;
            } else {
                FrsFragment.djE = 1;
            }
            if (!FrsFragment.this.djL.azj() && (i == 3 || i == 6)) {
                FrsFragment.this.djX.resetData();
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (FrsFragment.this.djL.ayA() != null) {
                FrsFragment.this.djc = FrsFragment.this.djL.ayA();
            }
            FrsFragment.this.djA.b(FrsFragment.this.djc.bwl());
            FrsFragment.this.kg(1);
            if (i == 7) {
                FrsFragment.this.kh(FrsFragment.this.djc.bvQ());
                return;
            }
            if (FrsFragment.this.djc.uJ() != null) {
                FrsFragment.this.setHasMore(FrsFragment.this.djc.uJ().uF());
            }
            FrsFragment.this.atM();
            if (i == 4) {
                if (!FrsFragment.this.djL.azj() && TbadkCoreApplication.getInst().isRecAppExist() && FrsFragment.this.djL.ayZ() == 1) {
                    FrsFragment.this.djc.a(FrsFragment.this);
                }
                ArrayList<com.baidu.adp.widget.ListView.h> a2 = FrsFragment.this.djX.a(false, false, FrsFragment.this.djc.getThreadList(), FrsFragment.this.djw, false);
                if (a2 != null) {
                    FrsFragment.this.djc.az(a2);
                    FrsFragment.this.djc.bwu();
                    FrsFragment.this.djA.a(a2, FrsFragment.this.djc);
                }
                if (FrsFragment.this.djL != null) {
                    com.baidu.tieba.frs.e.b.a(FrsFragment.this.djc, FrsFragment.this.djL.azf(), 2);
                }
                FrsFragment.this.aTS = System.currentTimeMillis() - currentTimeMillis;
                return;
            }
            switch (i) {
                case 1:
                    FrsFragment.this.djA.auG();
                    break;
                case 2:
                    FrsFragment.this.djA.auG();
                    break;
                case 3:
                case 6:
                    if (FrsFragment.this.djc != null) {
                        FrsFragment.this.djc.bws();
                    }
                    if (FrsFragment.this.dkc != null) {
                        FrsFragment.this.dkc.refresh();
                        break;
                    }
                    break;
            }
            FrsFragment.this.atN();
            if (aVar == null || aVar.errorCode == 0) {
                if (FrsFragment.this.djc != null) {
                    FrsFragment.this.v(false, i == 5);
                    FrsFragment.this.djA.kr(i);
                    FrsFragment.djC = (System.nanoTime() - this.startTime) / 1000000;
                    if (aVar != null) {
                        FrsFragment.djD = aVar.gJG;
                    }
                } else {
                    return;
                }
            } else if (FrsFragment.this.djc == null || com.baidu.tbadk.core.util.w.A(FrsFragment.this.djc.getThreadList())) {
                FrsFragment.this.a(aVar);
            } else if (aVar.gJF) {
                FrsFragment.this.showToast(FrsFragment.this.getPageContext().getResources().getString(d.k.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
            }
            if (FrsFragment.this.djc.bvA() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11384"));
            }
            if (FrsFragment.this.cQb > -1 && !FrsFragment.this.dkj) {
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.djL, FrsFragment.this.cQb);
                FrsFragment.this.cQb = -1L;
                FrsFragment.this.dkj = true;
            }
            if (FrsFragment.this.djx && FrsFragment.this.djN.lF(49)) {
                FrsFragment.this.djx = false;
            }
            FrsFragment.this.aTS = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void b(com.baidu.tieba.tbadkCore.i iVar) {
            if (iVar != null) {
                if ("normal_page".equals(FrsFragment.this.djL.ayV()) || "frs_page".equals(FrsFragment.this.djL.ayV()) || "book_page".equals(FrsFragment.this.djL.ayV())) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001615, iVar));
                    FrsFragment.this.a(iVar);
                }
            }
        }
    };
    private final CustomMessageListener dkI = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.frs.FrsFragment.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.i) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                FrsFragment.this.djc.a((com.baidu.tbadk.data.i) customResponsedMessage.getData());
                FrsFragment.this.djA.auQ().notifyDataSetChanged();
            }
        }
    };
    private final CustomMessageListener mMemListener = new CustomMessageListener(2001194) { // from class: com.baidu.tieba.frs.FrsFragment.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && FrsFragment.this.djc != null && (userData = FrsFragment.this.djc.getUserData()) != null) {
                userData.setIsMem(num.intValue());
                if (num.intValue() != 0) {
                    FrsFragment.this.djM.g(num);
                }
            }
        }
    };
    private final com.baidu.tieba.frs.mc.i dkJ = new com.baidu.tieba.frs.mc.i() { // from class: com.baidu.tieba.frs.FrsFragment.18
        @Override // com.baidu.tieba.frs.mc.i
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.h> arrayList, boolean z3) {
            if (FrsFragment.this.djP != null && FrsFragment.this.djL != null && FrsFragment.this.djL.azj() && z && !z2 && !z3) {
                FrsFragment.this.djP.lk(i2);
            }
        }
    };
    public final View.OnTouchListener aWD = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.FrsFragment.19
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (FrsFragment.this.dkf != null) {
                FrsFragment.this.dkf.onTouch(view, motionEvent);
            }
            if (FrsFragment.this.djR != null && FrsFragment.this.djR.avi() != null) {
                FrsFragment.this.djR.avi().onTouchEvent(motionEvent);
            }
            if (FrsFragment.this.bEN != null) {
                FrsFragment.this.bEN.d(view, motionEvent);
            }
            if (FrsFragment.this.djM != null) {
                FrsFragment.this.djM.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private final CustomMessageListener dkK = new CustomMessageListener(2004507) { // from class: com.baidu.tieba.frs.FrsFragment.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "photolive_hostLevel", -1) != -1 && FrsFragment.this.djc.baT() != null) {
                FrsFragment.this.djc.baT().setCanAddPhotoLivePost(true);
            }
        }
    };
    public final View.OnClickListener dkL = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.25
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsFragment.this.djA == null || view != FrsFragment.this.djA.auE() || FrsFragment.this.getActivity() == null) {
                if (FrsFragment.this.djc != null && FrsFragment.this.djc.baT() != null && FrsFragment.this.djA != null && view == FrsFragment.this.djA.auK()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12402").ah(ImageViewerConfig.FORUM_ID, FrsFragment.this.djc.baT().getId()).ah("uid", TbadkCoreApplication.getCurrentAccount()).ah(ImageViewerConfig.FORUM_NAME, FrsFragment.this.djc.baT().getName()));
                    if (!StringUtils.isNull(FrsFragment.this.djc.baT().getName())) {
                        FrsFragment.this.sendMessage(new CustomMessage(2002001, new PostSearchActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), FrsFragment.this.djc.baT().getName(), FrsFragment.this.djc.baT().getId())));
                        return;
                    }
                    return;
                }
                if (view.getId() == d.g.game_activity_egg_layout && com.baidu.adp.lib.util.l.jU()) {
                    TiebaStatic.log("c10853");
                    if (FrsFragment.this.djA.auN()) {
                        FrsFragment.this.djA.auO();
                    } else {
                        String activityUrl = FrsFragment.this.djc.baT().getYuleData().xg().getActivityUrl();
                        if (!StringUtils.isNull(activityUrl)) {
                            com.baidu.tbadk.browser.a.Q(FrsFragment.this.getPageContext().getPageActivity(), activityUrl);
                        }
                    }
                }
                if (view == FrsFragment.this.djA.auU() && FrsFragment.this.djL != null && FrsFragment.this.djL.hasMore()) {
                    FrsFragment.this.djA.Ud();
                    FrsFragment.this.Tf();
                }
                if (view != null && view == FrsFragment.this.djA.auL() && bb.aU(FrsFragment.this.getContext())) {
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
        private int dkR = 0;
        private int btu = 0;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (FrsFragment.this.djV != null) {
                FrsFragment.this.djV.azG();
            }
            this.dkR = 0;
            this.btu = 0;
            if (recyclerView != null && (recyclerView instanceof BdRecyclerView)) {
                this.dkR = ((BdRecyclerView) recyclerView).getFirstVisiblePosition();
                this.btu = ((BdRecyclerView) recyclerView).getLastVisiblePosition();
            }
            if (FrsFragment.this.dkh != null) {
                FrsFragment.this.dkh.a(recyclerView, this.dkR, this.btu);
            }
            if (FrsFragment.this.djc != null && FrsFragment.this.djA != null && FrsFragment.this.djA.auQ() != null) {
                FrsFragment.this.djA.az(this.dkR, this.btu);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (FrsFragment.this.djM != null) {
                FrsFragment.this.djM.setScrollState(i);
            }
            if ((i == 2 || i == 1) && !FrsFragment.this.djI) {
                FrsFragment.this.djI = true;
                FrsFragment.this.djA.auS();
            }
            if (FrsFragment.this.djJ == null && !FrsFragment.this.aub()) {
                FrsFragment.this.djJ = new com.baidu.tbadk.k.b();
                FrsFragment.this.djJ.fl(1000);
            }
            if (i == 0) {
                if (FrsFragment.this.djJ != null) {
                    FrsFragment.this.djJ.KB();
                }
                com.baidu.tieba.card.v.aiz().ex(true);
                FrsFragment.this.djA.ay(this.dkR, this.btu);
            } else if (FrsFragment.this.djJ != null) {
                FrsFragment.this.djJ.KA();
            }
            if (FrsFragment.this.dkh != null) {
                FrsFragment.this.dkh.onScrollStateChanged(recyclerView, i);
            }
            if (i == 0) {
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.djA, FrsFragment.this.djc, FrsFragment.this.getForumId(), false, null);
            }
            if (FrsFragment.this.djN != null && i == 1) {
                FrsFragment.this.djN.aAk();
            }
        }
    };
    private final d dkM = new d() { // from class: com.baidu.tieba.frs.FrsFragment.27
        @Override // com.baidu.tieba.frs.d
        public void a(int i, int i2, View view, View view2, bc bcVar) {
            if (i != FrsFragment.this.djA.auQ().aww()) {
                if (i != FrsFragment.this.djA.auQ().awx()) {
                    if (i == FrsFragment.this.djA.auQ().awy() && FrsFragment.this.djc != null && FrsFragment.this.djc.getUserData() != null && FrsFragment.this.djc.getUserData().isBawu()) {
                        String bvO = FrsFragment.this.djc.bvO();
                        if (!com.baidu.tbadk.core.util.ap.isEmpty(bvO) && FrsFragment.this.djc.baT() != null) {
                            com.baidu.tbadk.browser.a.O(FrsFragment.this.getPageContext().getPageActivity(), bvO);
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10502").ah(ImageViewerConfig.FORUM_ID, FrsFragment.this.djc.baT().getId()).ah("uid", FrsFragment.this.djc.getUserData().getUserId()));
                        }
                    }
                } else if (bb.aU(FrsFragment.this.getPageContext().getPageActivity())) {
                    TiebaStatic.log("my_service_ck");
                    if (FrsFragment.this.djc != null && FrsFragment.this.djc.baT() != null) {
                        ForumData baT = FrsFragment.this.djc.baT();
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(baT.getId(), 0L), baT.getName(), baT.getImage_url(), 0)));
                    }
                }
            } else if (bb.aU(FrsFragment.this.getActivity())) {
                TiebaStatic.log("forum_fortune_click");
                com.baidu.tieba.frs.f.i.b(FrsFragment.this.getPageContext(), FrsFragment.this.djc);
            }
        }
    };
    private final NoNetworkView.a dhp = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.FrsFragment.28
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aS(boolean z) {
            if (FrsFragment.this.djL.ayZ() == 1 && z && !FrsFragment.this.djA.aua()) {
                if (FrsFragment.this.djc == null || com.baidu.tbadk.core.util.w.A(FrsFragment.this.djc.getThreadList())) {
                    FrsFragment.this.hideNetRefreshView(FrsFragment.this.djA.adP());
                    FrsFragment.this.showLoadingView(FrsFragment.this.djA.adP(), true);
                    FrsFragment.this.djA.fD(false);
                    FrsFragment.this.refresh();
                    return;
                }
                FrsFragment.this.djA.auG();
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
                com.baidu.tieba.frs.f.c.a(customResponsedMessage, FrsFragment.this.djA, FrsFragment.this.djc);
            }
        }
    };
    private com.baidu.adp.widget.ListView.n dkN = new a();
    private al dkO = new al() { // from class: com.baidu.tieba.frs.FrsFragment.30
        @Override // com.baidu.tieba.frs.al
        public void a(int i, int i2, ar arVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
            com.baidu.adp.lib.g.e.im().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.30.1
                @Override // java.lang.Runnable
                public void run() {
                    if (FrsFragment.this.djA != null && FrsFragment.this.djA.ajw()) {
                        FrsFragment.this.Tf();
                    }
                }
            });
        }
    };
    private CustomMessageListener dkP = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.frs.FrsFragment.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    FrsFragment.this.dki = true;
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.frs.loadmore.a
    public /* bridge */ /* synthetic */ com.baidu.adp.base.e getPageContext() {
        return super.getPageContext();
    }

    public com.baidu.tieba.frs.entelechy.b.b atz() {
        return this.djT;
    }

    public com.baidu.adp.widget.ListView.n atA() {
        return this.dkN;
    }

    public com.baidu.tieba.frs.mc.d atB() {
        return this.djW;
    }

    public com.baidu.tieba.frs.smartsort.b atC() {
        return this.djP;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public FrsModelController atD() {
        return this.djL;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public com.baidu.tieba.frs.mc.c atE() {
        return this.djX;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public com.baidu.tieba.frs.vc.f atF() {
        return this.djM;
    }

    public com.baidu.tieba.frs.vc.j atG() {
        return this.djN;
    }

    public an atH() {
        return this.djR;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public k atI() {
        return this.djA;
    }

    @Override // com.baidu.tieba.frs.am
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.am, com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.djs;
    }

    public void setForumName(String str) {
        this.djs = str;
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
        if (this.djX == null) {
            return 1;
        }
        return this.djX.getPn();
    }

    public int getPn() {
        if (this.djX == null) {
            return 1;
        }
        return this.djX.getPn();
    }

    public void setPn(int i) {
        if (this.djX != null) {
            this.djX.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.djX != null) {
            this.djX.setHasMore(i);
        }
    }

    public int atJ() {
        if (this.djX == null) {
            return -1;
        }
        return this.djX.atJ();
    }

    public boolean atK() {
        return this.djy;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d.a aVar) {
        if (aVar == null) {
            String string = TbadkCoreApplication.getInst().getString(d.k.error_unkown_try_again);
            this.djA.auB();
            showNetRefreshView(this.djA.adP(), string, true);
        } else if (340001 == aVar.errorCode) {
            a(aVar, this.djc.bvx());
        } else {
            if (com.baidu.tbadk.core.util.w.A(this.djc.getThreadList())) {
                b(aVar);
            }
            if (aub()) {
                setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst(), d.e.ds280));
            } else {
                setNetRefreshViewEmotionDefMarginTop();
            }
        }
    }

    public void a(View view, String str, boolean z, List<RecmForumInfo> list) {
        this.djA.auB();
        this.djA.kn(8);
        if (this.dkg == null) {
            this.dkg = new com.baidu.tieba.frs.view.a(getPageContext(), getNetRefreshListener());
        }
        this.dkg.setSubText(str);
        this.dkg.bC(list);
        this.dkg.d(view, z);
    }

    private void a(d.a aVar, List<RecmForumInfo> list) {
        if (this.djA != null) {
            this.djA.auB();
            this.djA.setTitle(this.djs);
            a(this.djA.adP(), aVar.errorMsg, true, list);
        }
    }

    private void b(d.a aVar) {
        this.djA.auB();
        if (aVar.gJF) {
            showNetRefreshView(this.djA.adP(), TbadkCoreApplication.getInst().getString(d.k.net_error_text, new Object[]{aVar.errorMsg, Integer.valueOf(aVar.errorCode)}), true);
        } else {
            showNetRefreshView(this.djA.adP(), aVar.errorMsg, true);
        }
    }

    public void atL() {
        hideLoadingView(this.djA.adP());
        if (!this.djA.aua()) {
            this.djA.fE(false);
        } else {
            this.djA.fE(true);
        }
        if (this.djA.auz() instanceof com.baidu.tieba.frs.tab.c) {
            ((com.baidu.tieba.frs.tab.c) this.djA.auz()).azA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atM() {
        if (atJ() == 0 && com.baidu.tbadk.core.util.w.A(this.djc.bvG())) {
            if (com.baidu.tbadk.core.util.w.A(this.djc.getThreadList())) {
                this.djA.Uf();
            } else {
                this.djA.Ue();
            }
        } else if (com.baidu.tbadk.core.util.w.z(this.djc.getThreadList()) > 3) {
            this.djA.Ud();
        } else {
            this.djA.auT();
        }
    }

    public void a(ErrorData errorData) {
        atL();
        this.djA.auG();
        d.a ayW = this.djL.ayW();
        boolean A = com.baidu.tbadk.core.util.w.A(this.djc.getThreadList());
        if (ayW != null && A) {
            if (this.djL.ayX() != 0) {
                this.djL.azd();
                this.djA.auG();
            } else {
                a(ayW);
            }
            this.djA.w(this.djc.bwK(), false);
            return;
        }
        a(ayW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kg(int i) {
        List<WindowToast> list;
        if (TbadkCoreApplication.isLogin() && this.djc != null && (list = this.djc.gLi) != null && list.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < list.size()) {
                    WindowToast windowToast = list.get(i3);
                    if (windowToast == null || windowToast.toast_type.intValue() != i) {
                        i2 = i3 + 1;
                    } else if (!com.baidu.tbadk.core.util.ap.isEmpty(windowToast.toast_link)) {
                        sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(getPageContext().getPageActivity(), "", com.baidu.tbadk.util.aa.hO(windowToast.toast_link), true)));
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
    public void atN() {
        if (this.djc == null || this.djc.baT() != null) {
            this.djA.auP();
        } else if (this.djc.baT().getYuleData() != null && this.djc.baT().getYuleData().xf()) {
            TiebaStatic.log("c10852");
            this.djA.a(this.djc.baT().getYuleData().xg());
        } else {
            this.djA.auP();
        }
    }

    private void u(boolean z, boolean z2) {
        if (this.djL != null && this.djc != null && this.djA != null && z) {
            if (!this.djL.azj() && this.djL.ayZ() == 1) {
                if (!this.djL.azh()) {
                    this.djc.bwA();
                    this.djc.bwB();
                }
                boolean z3 = false;
                if (this.djA.auQ().k(com.baidu.tieba.card.data.n.czR)) {
                    z3 = this.djc.bwE();
                }
                if (!z3) {
                    this.djc.bwC();
                }
                if (TbadkCoreApplication.getInst().isRecAppExist()) {
                    this.djc.a(this);
                }
                if (!this.djA.auQ().k(bc.aif)) {
                    this.djc.bwt();
                }
                this.djc.bwF();
            }
            if (!this.djA.auQ().k(bc.aif)) {
                this.djc.bwz();
                this.djc.bwx();
            } else {
                this.djc.bwy();
                this.djc.bww();
            }
            this.djc.bwu();
            this.djc.bwr();
            if (this.djA.auQ().k(com.baidu.tieba.h.b.dKD)) {
                this.djc.mE(z2);
            }
            if (TbadkCoreApplication.isLogin() && (!this.djL.azj() || this.djL.isNetFirstLoad)) {
                this.djc.bwG();
            }
            this.djc.bwI();
        }
    }

    public boolean atO() {
        if (this.djM != null && this.djL != null) {
            this.djM.a(this.djL.ayV(), this.djc);
        }
        boolean z = false;
        if (this.djc != null) {
            z = this.djc.bwL();
        }
        atQ();
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kh(int i) {
        ao aoVar = null;
        atO();
        atX();
        try {
            if (this.djc != null) {
                this.djA.a((ArrayList<com.baidu.adp.widget.ListView.h>) null, this.djc);
                this.djM.lA(1);
                this.djA.auJ();
                this.djN.a(this.djc, this.djL.azf());
                com.baidu.tieba.frs.tab.d lG = this.djN.lG(this.djc.bvQ());
                if (lG != null && !TextUtils.isEmpty(lG.url)) {
                    aoVar = new ao();
                    aoVar.dmV = lG.url;
                    aoVar.stType = lG.name;
                }
                this.djL.a(this.djc.bvQ(), 0, aoVar);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(boolean z, boolean z2) {
        try {
            if (this.djc != null && this.djN != null && this.djL != null) {
                if (!this.djA.auQ().k(bc.aif)) {
                    this.djc.bwt();
                }
                boolean A = com.baidu.tbadk.core.util.w.A(this.djc.bwe());
                this.djA.fB(A);
                if (!A) {
                    if (this.dkh == null) {
                        this.dkh = new com.baidu.tieba.frs.vc.e(this, (NoPressedRelativeLayout) this.mRootView);
                    }
                    if (this.bEN == null) {
                        this.bEN = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
                    }
                } else {
                    this.dkh = null;
                    this.bEN = null;
                }
                if (this.djc.baT() != null) {
                    this.djs = this.djc.baT().getName();
                    this.forumId = this.djc.baT().getId();
                }
                if (this.djc.bwL()) {
                    this.djN.a(this.djc, this.djL.azf());
                }
                if (z) {
                    u(true, z);
                } else {
                    u(this.djK, z);
                }
                atO();
                if (this.djT != null) {
                    this.djT.a(this.djM, this.djc);
                }
                if (this.djc.uJ() != null) {
                    setHasMore(this.djc.uJ().uF());
                }
                ArrayList<com.baidu.adp.widget.ListView.h> a2 = this.djX.a(z2, true, this.djc.getThreadList(), null, z, false);
                if (a2 != null) {
                    this.djc.az(a2);
                }
                this.djc.bwH();
                if (this.djL.ayZ() == 1) {
                    atU();
                    if (!z && this.djL.getPn() == 1) {
                        atP();
                    }
                }
                this.djf = this.djc.azb();
                if (this.djw != null) {
                    this.djv = true;
                    this.djw.tH(this.djf);
                    com.baidu.tieba.frs.f.a.a(this, this.djc.baT(), this.djc.getThreadList(), this.djv, getPn());
                }
                if (this.djV != null) {
                    this.djV.az(this.djN.aAh());
                }
                atL();
                this.djA.auC();
                this.djA.w(true, false);
                if (this.djc.baT() != null) {
                    this.djA.mv(this.djc.baT().getWarningMsg());
                }
                if (this.djc != null && this.djc.bwh() != null && com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("frs_video_activity_guide", 0L) == 0) {
                    com.baidu.adp.lib.g.e.im().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.11
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsFragment.this.djA.auY();
                        }
                    }, 1000L);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2921326, this));
                this.djA.auv();
                if (this.djc != null && this.djc.baT() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016564, new VisitedForumData(this.djc.baT().getId(), this.djc.baT().getName(), this.djc.baT().getImage_url(), String.valueOf(System.currentTimeMillis() / 1000), "showlive".equals(this.djc.baT().special_forum_type))));
                }
                this.dkn.a(this.djc.gLn, this.djc.baT());
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void atP() {
        if (this.dka == null) {
            this.dka = new com.baidu.tieba.frs.live.a(this, com.baidu.adp.lib.g.b.g(this.forumId, 0));
        }
        this.dka.ayI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.i iVar) {
        try {
            if (!this.djH && iVar != null && this.djc != null) {
                this.djc.e(iVar);
                v(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void atQ() {
        if (this.djL != null) {
            mt(this.djL.ayV());
        } else {
            mt("normal_page");
        }
    }

    private void mt(String str) {
        fv("frs_page".equals(str));
        if (this.djT != null) {
            this.djT.a(this.djM, this.djA, this.djc);
        }
    }

    public void fv(boolean z) {
        if (this.djY != null) {
            this.djY.c(this.djA, z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(d.i.frs_activity, viewGroup, false);
            this.djm = new com.baidu.tieba.frs.entelechy.b();
            this.djT = this.djm.avX();
            this.djM = new com.baidu.tieba.frs.vc.f(this, this.djm, (FrsHeaderViewContainer) this.mRootView.findViewById(d.g.header_view_container));
            this.djN = new FrsTabViewController(this, this.mRootView);
            this.djM.a(this.djN);
            this.djN.a(this.dkw);
            Intent intent = getActivity().getIntent();
            if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                this.djo = true;
            }
            this.djA = new k(this, this.dkL, this.djm, this.djo, this.djM);
            this.djA.setHeaderViewHeight(this.dke);
            this.dkn = new com.baidu.tieba.frs.brand.buttommenu.a(getPageContext(), this.mRootView);
        } else {
            if (this.mRootView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            this.djN.resetData();
            this.djA.auX();
        }
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        this.cQb = System.currentTimeMillis();
        this.beginTime = this.cQb;
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.djx = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.cQb = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            I(intent);
        }
        this.aTK = this.beginTime - this.cQb;
        this.djw = new com.baidu.tieba.tbadkCore.data.e("frs", com.baidu.tieba.tbadkCore.data.e.gMu);
        this.djL = new FrsModelController(this, this.dkH);
        this.djL.a(this.dkv);
        this.djL.init();
        if (intent != null) {
            this.djL.i(intent.getExtras());
        } else if (bundle != null) {
            this.djL.i(bundle);
        } else {
            this.djL.i(null);
        }
        if (intent != null) {
            this.djM.m(intent.getExtras());
        } else if (bundle != null) {
            this.djM.m(bundle);
        } else {
            this.djM.m((Bundle) null);
        }
        this.djz = getVoiceManager();
        this.dkb = new j(getPageContext(), this);
        initUI();
        initData(bundle);
        if (this.mFrom != null && this.mFrom.equals("from_tieba_kuang")) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12264").r("obj_type", 1).ah(ImageViewerConfig.FORUM_NAME, this.djL.getForumName()));
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
                httpMessage.addParam("call_url", com.baidu.adp.lib.util.k.bg("shoubai://internal?type=frs&param=" + this.djs));
                MessageManager.getInstance().sendMessage(httpMessage);
            }
        }
        if (!aub()) {
            this.djR = new an(getActivity(), this.djA, this.djM);
            this.djR.fM(true);
        }
        this.djz = getVoiceManager();
        if (this.djz != null) {
            this.djz.onCreate(getPageContext());
        }
        new com.baidu.tieba.frs.mc.g();
        this.djX = new com.baidu.tieba.frs.mc.c(this, this.dkJ);
        this.djP = new com.baidu.tieba.frs.smartsort.b(this);
        this.djY = new com.baidu.tieba.frs.vc.h(this);
        this.djV = new com.baidu.tieba.frs.vc.a(getPageContext(), this.djL.azg());
        this.djQ = new com.baidu.tieba.frs.mc.b(this);
        this.djW = new com.baidu.tieba.frs.mc.d(this);
        this.djO = new com.baidu.tieba.frs.mc.f(this);
        this.djZ = new com.baidu.tieba.frs.mc.a(this);
        this.dkc = new com.baidu.tieba.frs.vc.c(this);
        this.dkd = new com.baidu.tieba.frs.mc.e(this, getUniqueId());
        this.dkk = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "frs");
        this.dkl = new com.baidu.tieba.ala.a(getPageContext());
        registerListener(this.bBI);
        registerListener(this.mMemListener);
        registerListener(this.dkC);
        registerListener(this.dkK);
        registerListener(this.dkB);
        registerListener(this.dkI);
        registerListener(this.dky);
        registerListener(this.dkz);
        registerListener(this.dkA);
        registerListener(this.dks);
        registerListener(this.dkt);
        registerListener(this.dkP);
        registerListener(this.dkF);
        registerListener(this.dku);
        registerListener(this.dkG);
        registerListener(this.dkE);
        this.dkr.setTag(getPageContext().getUniqueId());
        registerListener(this.dkr);
        this.djA.fD(false);
        if (!aub()) {
            showLoadingView(this.djA.adP(), true);
            this.djL.r(3, true);
        }
        com.baidu.tieba.frs.a.asZ().a(new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.16
            @Override // com.baidu.tieba.frs.a.b
            public void t(boolean z, boolean z2) {
                if (FrsFragment.this.djA != null) {
                    FrsFragment.this.djA.ko(z ? 0 : 8);
                    if (!z2) {
                        FrsFragment.this.dkp = z;
                    }
                    if (FrsFragment.this.djA.auQ() != null && FrsFragment.this.djL != null && FrsFragment.this.djL.aza()) {
                        FrsFragment.this.djA.auQ().notifyDataSetChanged();
                    }
                    if (FrsFragment.this.djA.auA() != null) {
                        FrsFragment.this.djA.fA(!z);
                    }
                    if (FrsFragment.this.getActivity() instanceof FrsActivity) {
                        ((FrsActivity) FrsFragment.this.getActivity()).fu(!z);
                    }
                    if (FrsFragment.this.dkn != null) {
                        FrsFragment.this.dkn.fV(!z);
                    }
                    FrsFragment.this.djA.fF(!z);
                    FrsFragment.this.djA.fG(z ? false : true);
                }
            }

            @Override // com.baidu.tieba.frs.a.b
            public void kd(int i) {
                if (FrsFragment.this.djA != null) {
                    FrsFragment.this.djA.kp(i);
                }
            }

            @Override // com.baidu.tieba.frs.a.b
            public void ate() {
                com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getContext(), d.k.frs_multi_delete_max_num);
            }
        });
        this.djA.b(new d.a() { // from class: com.baidu.tieba.frs.FrsFragment.17
            @Override // com.baidu.tieba.NEGFeedBack.d.a
            public void a(DeleteThreadHttpResponseMessage deleteThreadHttpResponseMessage) {
                if (deleteThreadHttpResponseMessage != null) {
                    FrsFragment.this.djA.Pp();
                    FrsFragment.this.djA.auZ();
                    if (deleteThreadHttpResponseMessage.getError() == 0) {
                        FrsFragment.this.djA.W(deleteThreadHttpResponseMessage.getText(), ContextCompat.getColor(FrsFragment.this.getContext(), deleteThreadHttpResponseMessage.getRetType() == 1 ? d.C0142d.nav_bar_tip_error : d.C0142d.cp_link_tip_a_alpha95));
                        FrsFragment.this.bm(deleteThreadHttpResponseMessage.getSuccessItems());
                        com.baidu.tieba.frs.a.asZ().bl(deleteThreadHttpResponseMessage.getSuccessItems());
                        int i = 0;
                        Iterator<com.baidu.adp.widget.ListView.h> it = FrsFragment.this.djc.getThreadList().iterator();
                        while (true) {
                            int i2 = i;
                            if (!it.hasNext()) {
                                i = i2;
                                break;
                            }
                            i = it.next() instanceof bc ? i2 + 1 : i2;
                            if (i >= 6) {
                                break;
                            }
                        }
                        if (i < 6) {
                            FrsFragment.this.Tf();
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

    /* JADX INFO: Access modifiers changed from: private */
    public void bm(List<String> list) {
        if (!com.baidu.tbadk.core.util.w.A(list)) {
            ArrayList<com.baidu.adp.widget.ListView.h> threadList = this.djc.getThreadList();
            if (!com.baidu.tbadk.core.util.w.A(threadList) && this.djA.getListView() != null && this.djA.getListView().getData() != null) {
                Iterator<com.baidu.adp.widget.ListView.h> it = threadList.iterator();
                List<com.baidu.adp.widget.ListView.h> data = this.djA.getListView().getData();
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.h next = it.next();
                    if (next instanceof bc) {
                        bc bcVar = (bc) next;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= list.size()) {
                                break;
                            } else if (!com.baidu.tbadk.core.util.ap.equals(list.get(i2), bcVar.getId())) {
                                i2++;
                            } else {
                                it.remove();
                                data.remove(bcVar);
                                this.djX.Y(bcVar);
                                this.djA.getListView().getAdapter().notifyItemRemoved(i);
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
    public void TF() {
        if (isAdded() && this.byr && !isLoadingViewAttached()) {
            showLoadingView(this.djA.adP(), true);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void TG() {
        if (isAdded() && this.byr && isLoadingViewAttached()) {
            hideLoadingView(this.djA.adP());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (aub()) {
            showLoadingView(this.djA.adP(), true);
            this.djA.kq(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.djL.r(3, true);
            Bb().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void setHeaderViewHeight(int i) {
        this.dke = i;
        if (this.djA != null) {
            this.djA.setHeaderViewHeight(this.dke);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.t tVar) {
        if (tVar != null) {
            this.aWC = tVar.Lz();
            this.dkf = tVar.LA();
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void showFloatingView() {
        if (this.aWC != null) {
            this.aWC.cg(true);
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
            this.djs = data.getQueryParameter("name");
            this.mFrom = data.getQueryParameter("from");
            if (!StringUtils.isNull(this.djs)) {
                intent.putExtra("name", this.djs);
            }
            if (!StringUtils.isNull(this.mFrom)) {
                intent.putExtra("from", this.mFrom);
            }
            TiebaStatic.log("c10105");
        }
        if (StringUtils.isNull(this.djs)) {
            com.baidu.tieba.frs.f.d K = com.baidu.tieba.frs.f.i.K(intent);
            if (K != null) {
                this.djs = K.forumName;
                if (K.dCW != null && K.dCW.equals("aidou")) {
                    com.baidu.tbadk.core.dialog.h.alY = System.currentTimeMillis();
                }
            }
            if (!StringUtils.isNull(this.djs)) {
                intent.putExtra("name", this.djs);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.djz = getVoiceManager();
        if (this.djz != null) {
            this.djz.onStart(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        Intent intent;
        registerListener(2001118, this.aDX);
        if (bundle != null) {
            this.djs = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
            this.djs = intent.getStringExtra("name");
            this.mFrom = intent.getStringExtra("from");
            this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
        }
        if (getArguments() != null) {
            this.djt = getArguments().getBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, false);
        }
        if (TextUtils.isEmpty(this.mFrom) || FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
        }
        if (this.mIsLogin) {
            registerListener(2001120, this.aDX);
        }
        this.djM.m(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dkP);
        if (this.djz != null) {
            this.djz.onDestory(getPageContext());
        }
        this.djz = null;
        com.baidu.tieba.card.v.aiz().ex(false);
        if (this.djc != null && this.djc.baT() != null) {
            ac.avf().bC(com.baidu.adp.lib.g.b.c(this.djc.baT().getId(), 0L));
        }
        if (this.dka != null) {
            this.dka.onDestory();
        }
        if (this.djA != null) {
            com.baidu.tieba.frs.f.h.a(this.djA, this.djc, getForumId(), false, null);
            this.djA.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.djJ != null) {
                this.djJ.KC();
            }
            this.djA.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.djL.onActivityDestroy();
        this.djM.onActivityDestroy();
        if (this.djL != null) {
            this.djL.Vo();
        }
        if (this.djR != null) {
            this.djR.Ly();
        }
        if (this.djU != null) {
            this.djU.destory();
        }
        if (this.djV != null) {
            this.djV.destory();
        }
        if (this.djP != null) {
            this.djP.onDestroy();
        }
        if (this.dkh != null) {
            this.dkh.onDestory();
        }
        if (this.djZ != null) {
            this.djZ.onDestroy();
        }
        if (this.dkk != null) {
            this.dkk.onDestroy();
        }
        if (this.dkl != null) {
            this.dkl.onDestroy();
        }
        com.baidu.tieba.recapp.d.a.bpy().bpA();
        com.baidu.tieba.frs.f.j.azD();
        if (this.djN != null) {
            this.djN.a((FrsTabViewController.a) null);
            this.djN.aAk();
        }
        if (this.dkm != null) {
            this.dkm.onDestroy();
        }
        if (this.dko != null) {
            this.dko.onDestroy();
        }
        com.baidu.tieba.frs.a.asZ().a(null);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.djs);
        bundle.putString("from", this.mFrom);
        this.djL.onSaveInstanceState(bundle);
        if (this.djz != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            this.djz.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.djZ != null) {
            this.djZ.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.djA != null) {
            this.djA.auG();
            this.djA.onResume();
        }
        this.djO.gk(true);
        this.djK = true;
        if (djr) {
            djr = false;
            this.djA.startPullRefresh();
            return;
        }
        if (this.djz != null) {
            this.djz.onResume(getPageContext());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921338));
        this.djA.fH(false);
        if (this.dki) {
            refresh(6);
            this.dki = false;
        }
        if (KuangFloatingViewController.getInstance().init()) {
            ((BaseFragmentActivity) getPageContext().getOrignalPage()).grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.frs.FrsFragment.21
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
    }

    public boolean atR() {
        Intent intent;
        if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
            return false;
        }
        return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
    }

    public void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.djs = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.dju = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.dju) {
                atS();
            }
            if (this.mFrom != null && this.mFrom.equals("from_tieba_kuang")) {
                KuangFloatingViewController.getInstance().setNeedShowFloatingView(true);
                if (KuangFloatingViewController.getInstance().init()) {
                    ((BaseFragmentActivity) getPageContext().getOrignalPage()).grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.frs.FrsFragment.22
                        @Override // com.baidu.tbadk.core.e
                        public void an(boolean z) {
                            if (z) {
                                KuangFloatingViewController.getInstance().showFloatingView();
                            }
                        }
                    });
                }
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SCHEMA_UPLOAD);
                httpMessage.addParam("call_url", com.baidu.adp.lib.util.k.bg("shoubai://internal?type=frs&param=" + this.djs));
                MessageManager.getInstance().sendMessage(httpMessage);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atS() {
        this.djA.startPullRefresh();
    }

    public void closeActivity() {
        com.baidu.tieba.frs.f.i.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.mFrom);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.djA.setTitle(this.djs);
        } else {
            this.djA.setTitle("");
            this.mFlag = 1;
        }
        this.djA.setOnAdapterItemClickListener(this.dkN);
        this.djA.addOnScrollListener(this.mScrollListener);
        this.djA.h(this.dhp);
        this.djA.auQ().a(this.dkM);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.djA.onChangeSkinType(i);
        this.djM.lz(i);
        this.djN.onChangeSkinType(i);
        if (this.dkg != null) {
            this.dkg.onChangeSkinType();
        }
        if (this.dkm != null) {
            this.dkm.onChangeSkinType(i);
        }
        if (this.dkn != null) {
            this.dkn.d(getPageContext(), i);
        }
    }

    public void ki(int i) {
        if (!this.mIsLogin) {
            if (this.djc != null && this.djc.uu() != null) {
                this.djc.uu().setIfpost(1);
            }
            if (i == 0) {
                bb.aT(getActivity());
            }
        } else if (this.djc != null) {
            if (i == 0) {
                com.baidu.tieba.frs.f.j.d(this, 0);
            } else {
                this.djA.auI();
            }
        }
    }

    public void refresh() {
        com.baidu.tieba.a.d.QB().iC("page_frs");
        refresh(3);
    }

    public void refresh(int i) {
        this.djH = false;
        atX();
        if (this.djA.auy() != null) {
            this.djA.auy().aED();
        }
        this.djL.r(i, true);
    }

    private void atT() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.g.h.in().d(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.24
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.tU(FrsFragment.this.djs);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atU() {
        atX();
        try {
            if (this.djc != null) {
                this.djA.showListView();
                this.djA.fA(aug());
                if (!com.baidu.tieba.frs.vc.f.k(this.djc) || !com.baidu.tieba.frs.vc.f.j(this.djc)) {
                }
                if (this.djc.baT() != null) {
                    this.djs = this.djc.baT().getName();
                    this.forumId = this.djc.baT().getId();
                }
                if (this.djc.uJ() != null) {
                    setHasMore(this.djc.uJ().uF());
                }
                this.djA.setTitle(this.djs);
                this.djA.setForumName(this.djs);
                TbadkCoreApplication.getInst().setDefaultBubble(this.djc.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.djc.getUserData().getBimg_end_time());
                atT();
                atV();
                ArrayList<com.baidu.adp.widget.ListView.h> threadList = this.djc.getThreadList();
                if (threadList != null) {
                    this.djA.a(threadList, this.djc);
                    com.baidu.tieba.frs.f.c.w(this.djA);
                    this.djM.lA(getPageNum());
                    this.djM.h(this.djc);
                    this.djN.a(this.djc, this.djL.azf());
                    this.djA.auJ();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void atV() {
        if (this.djc != null) {
            if (this.djc.bbi() == 1) {
                this.djA.auQ().setFromCDN(true);
            } else {
                this.djA.auQ().setFromCDN(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.djO.gk(false);
        this.djK = false;
        this.djA.onPause();
        if (this.djz != null) {
            this.djz.onPause(getPageContext());
        }
        this.djA.fH(true);
        if (this.djV != null) {
            this.djV.azG();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.djN != null && this.djN.aAi() != null && (this.djN.aAi().fragment instanceof BaseFragment)) {
            ((BaseFragment) this.djN.aAi().fragment).setPrimary(z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.v.aiz().ex(false);
        if (this.djc != null && this.djc.baT() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            com.baidu.tbadk.distribute.a.Hj().a(getPageContext().getPageActivity(), "frs", this.djc.baT().getId(), 0L);
        }
        if (this.djz != null) {
            this.djz.onStop(getPageContext());
        }
        if (Bb() != null) {
            Bb().getRecycledViewPool().clear();
        }
        this.djM.onActivityStop();
        com.baidu.tbadk.util.u.LC();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            if (this.djM != null) {
                this.djM.fy(isPrimary());
            }
            if (this.djA != null) {
                this.djA.fy(isPrimary());
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (com.baidu.tieba.frs.a.asZ().ata()) {
                com.baidu.tieba.frs.a.asZ().reset();
                return true;
            } else if (this.djA != null) {
                return this.djA.auF();
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.n
    public TbPageContext<?> ahZ() {
        return getPageContext();
    }

    @Override // com.baidu.tieba.recapp.n
    public void a(AdvertAppInfo advertAppInfo, String str) {
        com.baidu.tbadk.distribute.a.Hj().a(advertAppInfo, this.forumId, 0L, "FRS", str, getPn());
    }

    @Override // com.baidu.tieba.recapp.n
    public void atW() {
        atD().atW();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.djz == null) {
            this.djz = VoiceManager.instance();
        }
        return this.djz;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdRecyclerView Bb() {
        if (this.djA == null) {
            return null;
        }
        return this.djA.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void atX() {
        if (this.djz != null) {
            this.djz.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> Bc() {
        if (this.azg == null) {
            this.azg = UserIconBox.h(getPageContext().getPageActivity(), 8);
        }
        return this.azg;
    }

    public void atY() {
        if (getFragmentActivity() != null && getFragmentActivity().getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.b(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.k onGetPreLoadListView() {
        return Bb().getPreLoadHandle();
    }

    @Override // com.baidu.tieba.frs.ak
    public NavigationBar UW() {
        if (this.djA == null) {
            return null;
        }
        return this.djA.UW();
    }

    @Override // com.baidu.tbadk.core.view.NavigationBar.a
    public void b(Pair<Integer, Integer> pair) {
        this.djF = pair;
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
                if (bdUniqueId == p.dmi) {
                    if (FrsFragment.this.djA != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11752").ah(ImageViewerConfig.FORUM_ID, FrsFragment.this.forumId).ah("obj_locate", "1"));
                        FrsFragment.this.djA.startPullRefresh();
                    }
                } else if (hVar != null && (hVar instanceof bc)) {
                    bc bcVar = (bc) hVar;
                    if (bcVar.wf() == null || bcVar.wf().getGroup_id() == 0 || bb.aU(FrsFragment.this.getActivity())) {
                        if (bcVar.vY() != 1 || bb.aU(FrsFragment.this.getActivity())) {
                            if (bcVar.vJ() != null) {
                                if (bb.aU(FrsFragment.this.getActivity())) {
                                    String postUrl = bcVar.vJ().getPostUrl();
                                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.jU()) {
                                        com.baidu.tbadk.browser.a.Q(FrsFragment.this.getActivity(), postUrl);
                                    }
                                }
                            } else if (bcVar.wo() != null) {
                                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                    bb.aT(FrsFragment.this.getPageContext().getPageActivity());
                                    return;
                                }
                                com.baidu.tbadk.core.data.n wo = bcVar.wo();
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), wo.getCartoonId(), wo.getChapterId(), 2)));
                            } else {
                                com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                                if (readThreadHistory != null && !readThreadHistory.ua(bcVar.getId())) {
                                    readThreadHistory.tZ(bcVar.getId());
                                }
                                boolean z = false;
                                final String vD = bcVar.vD();
                                if (vD != null && !vD.equals("")) {
                                    z = true;
                                    new Thread(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.a.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            com.baidu.tbadk.core.util.y yVar = new com.baidu.tbadk.core.util.y(vD);
                                            yVar.yX().zX().mIsNeedAddCommenParam = false;
                                            yVar.yX().zX().mIsUseCurrentBDUSS = false;
                                            yVar.yA();
                                        }
                                    }).start();
                                }
                                String tid = bcVar.getTid();
                                if (tid == null) {
                                    tid = "";
                                }
                                if (bcVar.vr() == 2 && !tid.startsWith("pb:")) {
                                    az.zV().c(FrsFragment.this.getPageContext(), new String[]{tid, "", null});
                                    return;
                                }
                                if (tid.startsWith("pb:")) {
                                    bcVar.setId(tid.substring(3));
                                }
                                if (bdUniqueId.getId() == bc.ajw.getId()) {
                                    com.baidu.tieba.frs.f.h.a(bcVar.vd());
                                } else if (bdUniqueId.getId() == bc.aii.getId()) {
                                    com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c12940");
                                    anVar.ah("obj_type", "2");
                                    anVar.ah("tid", bcVar.getTid());
                                    TiebaStatic.log(anVar);
                                }
                                com.baidu.tieba.frs.f.i.a(FrsFragment.this, bcVar, i, z);
                                com.baidu.tieba.frs.f.h.a(FrsFragment.this, FrsFragment.this.djc, bcVar);
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
            hideNetRefreshView(this.djA.adP());
            showLoadingView(this.djA.adP(), true);
            this.djA.fD(false);
            this.djL.r(3, true);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public com.baidu.tieba.tbadkCore.l atZ() {
        return this.djc;
    }

    public boolean aua() {
        return this.djA.aua();
    }

    public void W(Object obj) {
        if (this.djQ != null && this.djQ.dAH != null) {
            this.djQ.dAH.i(obj);
        }
    }

    public void X(Object obj) {
        if (this.djQ != null && this.djQ.dAI != null) {
            this.djQ.dAI.i(obj);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        this.djA.getListView().stopScroll();
        if (!this.djA.auM()) {
            if (!com.baidu.adp.lib.util.l.jU()) {
                this.djA.Uf();
            } else if (this.djL.ayZ() == 1) {
                Tt();
                Tf();
            } else if (this.djL.hasMore()) {
                Tf();
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void mc(String str) {
        Tt();
        showToast(str);
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void O(ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        Tt();
        if (!com.baidu.tbadk.core.util.w.A(arrayList)) {
            if (!this.djL.azj() && TbadkCoreApplication.getInst().isRecAppExist() && this.djL.ayZ() == 1) {
                this.djc.a(this, arrayList);
            }
            ArrayList<com.baidu.adp.widget.ListView.h> a2 = this.djX.a(false, false, arrayList, this.djw, false);
            if (a2 != null) {
                this.djc.az(a2);
                this.djA.a(a2, this.djc);
            }
            if (this.djL != null) {
                com.baidu.tieba.frs.e.b.a(this.djc, this.djL.azf(), 2);
            }
        }
    }

    private void Tt() {
        if (atJ() == 1 || this.djX.by(this.djc.bvG())) {
            if (com.baidu.tbadk.core.util.w.z(this.djc.getThreadList()) > 3) {
                this.djA.Ud();
            } else {
                this.djA.auT();
            }
        } else if (com.baidu.tbadk.core.util.w.A(this.djc.getThreadList())) {
            this.djA.Uf();
        } else {
            this.djA.Ue();
        }
    }

    @Override // com.baidu.tieba.frs.mc.j
    public void Tf() {
        if (this.djX != null) {
            this.djX.a(this.djs, this.forumId, this.djc);
        }
    }

    public void takePhoto() {
        if (!com.baidu.tbadk.core.util.ac.e(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.al.b(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        if (this.djG) {
            return null;
        }
        if (aub()) {
            return "a034";
        }
        return "a006";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (!aub()) {
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

    public void fw(boolean z) {
        if (this.djR != null) {
            this.djR.fM(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.djS.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a gd(int i) {
        return this.djS.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        this.dkb.b(bVar);
    }

    public boolean aub() {
        return this.djo;
    }

    @Override // com.baidu.tieba.frs.ah
    public void TE() {
        if (this.djA != null) {
            showFloatingView();
            this.djA.getListView().scrollToPosition(0);
            this.djA.startPullRefresh();
        }
    }

    public ForumWriteData auc() {
        if (this.djc == null || this.djc.baT() == null) {
            return null;
        }
        ForumData baT = this.djc.baT();
        ForumWriteData forumWriteData = new ForumWriteData(baT.getId(), baT.getName(), baT.getPrefixData(), this.djc.uu());
        forumWriteData.avatar = baT.getImage_url();
        forumWriteData.forumLevel = baT.getUser_level();
        forumWriteData.specialForumType = baT.special_forum_type;
        forumWriteData.firstDir = baT.getFirst_class();
        forumWriteData.secondDir = baT.getSecond_class();
        UserData userData = this.djc.getUserData();
        forumWriteData.privateThread = userData != null ? userData.getPrivateThread() : 0;
        return forumWriteData;
    }

    @Override // com.baidu.tieba.frs.ah
    public void AP() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.frs.ah
    public void setVideoThreadId(String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z) {
        super.showLoadingView(view, z);
        this.djA.kn(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        super.hideLoadingView(view);
        this.djA.kn(0);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        super.showNetRefreshView(view, str, z);
        this.djA.kn(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshViewNoClick(View view, String str, boolean z) {
        super.showNetRefreshViewNoClick(view, str, z);
        this.djA.kn(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        super.hideNetRefreshView(view);
        this.djA.kn(0);
    }

    public void aud() {
        FrsTabViewController.b aAi;
        if (this.djN != null && (aAi = this.djN.aAi()) != null && aAi.fragment != null && (aAi.fragment instanceof aj)) {
            ((aj) aAi.fragment).atu();
        }
    }

    public void a(ContriInfo contriInfo) {
        if (this.dkm == null) {
            this.dkm = new com.baidu.tbadk.core.dialog.h(ahZ());
            this.dkm.a(new h.a() { // from class: com.baidu.tieba.frs.FrsFragment.32
                @Override // com.baidu.tbadk.core.dialog.h.a
                public void aE(boolean z) {
                    if (z) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13061"));
                    }
                }
            });
        }
        this.dkm.a(contriInfo, -1L);
    }

    public void fx(boolean z) {
        this.djq = z;
    }

    public boolean aue() {
        return this.djq;
    }

    public void mu(String str) {
        if (TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.util.ap.isEmpty(str)) {
            if (this.dko == null) {
                this.dko = new AddExperiencedModel(ahZ());
                this.dko.a(this.dkq);
            }
            this.dko.ch(this.forumId, str);
        }
    }

    public com.baidu.tieba.frs.entelechy.b auf() {
        return this.djm;
    }

    public boolean aug() {
        return (this.djL != null && this.djL.aza() && com.baidu.tieba.frs.a.asZ().ata()) ? false : true;
    }
}
