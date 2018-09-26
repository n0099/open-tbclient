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
/* loaded from: classes2.dex */
public class FrsFragment extends BaseFragment implements BdListView.e, a.InterfaceC0062a, NavigationBar.a, UserIconBox.b<BdRecyclerView>, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, ah, ak, am, com.baidu.tieba.frs.loadmore.a, com.baidu.tieba.frs.mc.j, com.baidu.tieba.recapp.n {
    public static boolean dsc = false;
    public static volatile long dsn = 0;
    public static volatile long dso = 0;
    public static volatile int dsp = 0;
    private com.baidu.adp.lib.e.b<TbImageView> aBR;
    private com.baidu.tbadk.util.t aZW;
    private com.baidu.tieba.frs.gametab.b bLs;
    private com.baidu.tbadk.core.dialog.a cGU;
    private com.baidu.tieba.frs.entelechy.b drX;
    private com.baidu.tieba.frs.smartsort.b dsA;
    private com.baidu.tieba.frs.mc.b dsB;
    private an dsC;
    private com.baidu.tieba.frs.entelechy.b.b dsE;
    private com.baidu.tbadk.i.a dsF;
    private com.baidu.tieba.frs.vc.a dsG;
    private com.baidu.tieba.frs.mc.d dsH;
    private com.baidu.tieba.frs.mc.c dsI;
    private com.baidu.tieba.frs.vc.h dsJ;
    private com.baidu.tieba.frs.mc.a dsK;
    private com.baidu.tieba.frs.live.a dsL;
    private j dsM;
    public com.baidu.tieba.frs.vc.c dsN;
    private com.baidu.tieba.frs.mc.e dsO;
    private int dsP;
    private View.OnTouchListener dsQ;
    private com.baidu.tieba.frs.view.a dsR;
    private com.baidu.tieba.frs.vc.e dsS;
    private boolean dsT;
    private com.baidu.tieba.NEGFeedBack.a dsV;
    private com.baidu.tieba.ala.a dsW;
    private com.baidu.tbadk.core.dialog.h dsX;
    private com.baidu.tieba.frs.brand.buttommenu.a dsY;
    private AddExperiencedModel dsZ;
    private com.baidu.tieba.tbadkCore.data.e dsh;
    private VoiceManager dsk;
    private FrsModelController dsw;
    private com.baidu.tieba.frs.vc.f dsx;
    private FrsTabViewController dsy;
    private com.baidu.tieba.frs.mc.f dsz;
    private boolean dtb;
    private int dtj;
    public View mRootView;
    public boolean drY = false;
    private boolean drZ = false;
    private boolean dsa = false;
    private boolean dsb = true;
    public String dsd = null;
    public String mFrom = null;
    public int mFlag = 0;
    public boolean dse = false;
    private boolean dsf = false;
    private String mThreadId = null;
    public String forumId = null;
    private int drQ = 0;
    private boolean dsg = false;
    private boolean dsi = false;
    private boolean dsj = false;
    private k dsl = null;
    public final bb bAn = null;
    private com.baidu.tieba.tbadkCore.l drN = new com.baidu.tieba.tbadkCore.l();
    public long cYB = -1;
    public long aXi = 0;
    public long aXa = 0;
    public long createTime = 0;
    public long beginTime = -1;
    public long dsm = 0;
    public Pair<Integer, Integer> dsq = null;
    public boolean dsr = false;
    private boolean dss = false;
    private boolean dst = false;
    public com.baidu.tbadk.l.b dsu = null;
    private boolean dsv = true;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> dsD = new SparseArray<>();
    private boolean bEO = true;
    private boolean dsU = false;
    private boolean hasInit = false;
    private boolean dta = false;
    private AddExperiencedModel.a dtc = new AddExperiencedModel.a() { // from class: com.baidu.tieba.frs.FrsFragment.1
        @Override // com.baidu.tieba.share.AddExperiencedModel.a
        public void b(ContriInfo contriInfo) {
            if (contriInfo != null && contriInfo.isShowToast()) {
                FrsFragment.this.a(contriInfo);
            }
        }
    };
    private HttpMessageListener dtd = new HttpMessageListener(CmdConfigHttp.CMD_PB_FLOOR_AGREE, true) { // from class: com.baidu.tieba.frs.FrsFragment.12
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
    private final CustomMessageListener dte = new CustomMessageListener(2016495) { // from class: com.baidu.tieba.frs.FrsFragment.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof bb) {
                    com.baidu.tieba.frs.f.h.a(FrsFragment.this.dsl, FrsFragment.this.drN, FrsFragment.this.getForumId(), true, (bb) data);
                }
            }
        }
    };
    private CustomMessageListener dtf = new CustomMessageListener(2921005) { // from class: com.baidu.tieba.frs.FrsFragment.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (FrsFragment.this.drN != null) {
                FrsFragment.this.drN.bxO();
                if (FrsFragment.this.dsl != null) {
                    FrsFragment.this.dsl.alQ();
                }
            }
        }
    };
    private CustomMessageListener dtg = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.FrsFragment.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 1) {
                    FrsFragment.this.awo();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                }
            }
        }
    };
    private final al dth = new al() { // from class: com.baidu.tieba.frs.FrsFragment.32
        @Override // com.baidu.tieba.frs.al
        public void a(int i, int i2, ar arVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
            FrsFragment.this.awh();
            if (FrsFragment.this.dsE != null) {
                FrsFragment.this.dsx.gK(FrsFragment.this.dsE.lt(i));
            }
            d.a aVar = new d.a();
            if (arVar != null) {
                aVar.isSuccess = arVar.errCode == 0;
                aVar.errorCode = arVar.errCode;
                aVar.errorMsg = arVar.errMsg;
                if (aVar.isSuccess) {
                    if (com.baidu.tbadk.core.util.v.z(arrayList)) {
                        FrsFragment.this.dsl.Wd();
                    } else if (arVar.hasMore) {
                        if (com.baidu.tbadk.core.util.v.y(FrsFragment.this.drN.getThreadList()) > 3) {
                            FrsFragment.this.dsl.Wb();
                        } else {
                            FrsFragment.this.dsl.axq();
                        }
                    } else if (arVar.dwc) {
                        FrsFragment.this.dsl.Wc();
                    } else {
                        FrsFragment.this.dsl.Wd();
                    }
                }
            } else {
                arVar = new ar();
                arVar.pn = 1;
                arVar.hasMore = false;
                arVar.dwc = false;
            }
            if (i == 1) {
                FrsFragment.this.dsv = true;
                FrsFragment.this.dtt.a(FrsFragment.this.dsw.getType(), false, aVar);
            } else {
                FrsFragment.this.a(aVar);
                if (FrsFragment.this.dsw.aBl() != null) {
                    FrsFragment.this.drN = FrsFragment.this.dsw.aBl();
                }
                FrsFragment.this.awq();
            }
            if (FrsFragment.this.dtA != null) {
                FrsFragment.this.dtA.a(i, i2, arVar, arrayList);
            }
        }
    };
    private FrsTabViewController.a dti = new FrsTabViewController.a() { // from class: com.baidu.tieba.frs.FrsFragment.33
        @Override // com.baidu.tieba.frs.vc.FrsTabViewController.a
        public void fk(int i) {
            boolean z = false;
            if (i != 1) {
                com.baidu.tieba.card.v.akM().eP(false);
            }
            if (i == 303 && i != FrsFragment.this.dtj) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13121").al(ImageViewerConfig.FORUM_ID, FrsFragment.this.forumId).al("uid", TbadkCoreApplication.getCurrentAccount()));
            }
            FrsFragment.this.dtj = i;
            FrsFragment.this.awt();
            com.baidu.tieba.frs.e.c.dAB.dLK = i;
            com.baidu.tieba.frs.e.c.dAB.dLL = -1;
            com.baidu.tieba.frs.a avq = com.baidu.tieba.frs.a.avq();
            if (i == 1 && FrsFragment.this.dta) {
                z = true;
            }
            avq.u(z, true);
        }
    };
    private CustomMessageListener dtk = new CustomMessageListener(2001606) { // from class: com.baidu.tieba.frs.FrsFragment.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                FrsFragment.this.dsy.mu(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    };
    private CustomMessageListener dtl = new CustomMessageListener(2001607) { // from class: com.baidu.tieba.frs.FrsFragment.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && ((Integer) customResponsedMessage.getData()).intValue() == 51 && FrsFragment.this.drN != null) {
                com.baidu.tieba.frs.f.j.a(FrsFragment.this.drN, FrsFragment.this.getPageContext());
            }
        }
    };
    private final CustomMessageListener dtm = new CustomMessageListener(2003019) { // from class: com.baidu.tieba.frs.FrsFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                FrsFragment.this.dsy.ms(49);
            }
        }
    };
    private final CustomMessageListener dtn = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.frs.FrsFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && FrsFragment.this.drN != null && FrsFragment.this.drN.bbH() != null) {
                SignData signData = (SignData) customResponsedMessage.getData();
                int user_level = FrsFragment.this.drN.bbH().getUser_level();
                if (signData.forumId != null && signData.forumId.equals(FrsFragment.this.drN.bbH().getId())) {
                    FrsFragment.this.drN.d(signData);
                    FrsFragment.this.dsx.i(FrsFragment.this.drN);
                    if (FrsFragment.this.dsx.aCO()) {
                        i = FrsFragment.this.drN.bbH().getUser_level();
                        if (user_level >= i) {
                            i++;
                        }
                    } else {
                        i = user_level;
                    }
                    TbadkCoreApplication.getInst().addSignedForum(FrsFragment.this.drN.bbH().getName(), signData.sign_bonus_point, i);
                }
            }
        }
    };
    private final CustomMessageListener dto = new CustomMessageListener(2001352) { // from class: com.baidu.tieba.frs.FrsFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.r) && FrsFragment.this.drN != null) {
                FrsFragment.this.drN.c((com.baidu.tieba.tbadkCore.r) customResponsedMessage.getData());
                FrsFragment.this.dsx.h(FrsFragment.this.drN);
                FrsFragment.this.dsy.a(FrsFragment.this.drN, FrsFragment.this.dsw.aBR());
            }
        }
    };
    private final AntiHelper.a dtp = new AntiHelper.a() { // from class: com.baidu.tieba.frs.FrsFragment.5
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12536").w("obj_locate", as.a.atP));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12535").w("obj_locate", as.a.atP));
        }
    };
    private CustomMessageListener bIg = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.frs.FrsFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(FrsFragment.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().aGz != null) {
                        if (AntiHelper.a(FrsFragment.this.getActivity(), updateAttentionMessage.getData().aGz, FrsFragment.this.dtp) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12534").w("obj_locate", as.a.atP));
                        }
                    } else if (updateAttentionMessage.getData().IM && updateAttentionMessage.getData().isAttention) {
                        com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getPageContext().getPageActivity(), e.j.attention_success);
                    }
                }
            }
        }
    };
    private CustomMessageListener dtq = new CustomMessageListener(2921346) { // from class: com.baidu.tieba.frs.FrsFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsFragment.this.refresh();
        }
    };
    private CustomMessageListener dtr = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.frs.FrsFragment.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                FrsFragment.this.dsl.c((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener dts = new CustomMessageListener(2001626) { // from class: com.baidu.tieba.frs.FrsFragment.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewsRemindMessage newsRemindMessage;
            if (customResponsedMessage != null && (customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626 && (newsRemindMessage = (NewsRemindMessage) customResponsedMessage) != null) {
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (FrsFragment.this.dsl != null) {
                    FrsFragment.this.dsl.p(notificationCount, z);
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.n dtt = new com.baidu.tieba.tbadkCore.n() { // from class: com.baidu.tieba.frs.FrsFragment.10
        private long startTime = 0;

        @Override // com.baidu.tieba.tbadkCore.n
        public void kS(int i) {
            this.startTime = System.nanoTime();
            if (FrsFragment.this.dsl != null) {
                switch (i) {
                    case 1:
                    case 2:
                        FrsFragment.this.dsl.axc();
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
            if (FrsFragment.this.bEO) {
                FrsFragment.this.bEO = false;
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.dsl, FrsFragment.this.drN, FrsFragment.this.getForumId(), false, null);
            }
            FrsFragment.this.awh();
            FrsFragment.this.dss = true;
            if (aVar != null && aVar.isSuccess) {
                FrsFragment.this.dsl.axm().gx(com.baidu.tbadk.core.util.aq.Az().AB());
                FrsFragment.dsn = 0L;
                FrsFragment.dso = 0L;
                FrsFragment.dsp = 0;
            } else {
                FrsFragment.dsp = 1;
            }
            if (!FrsFragment.this.dsw.aBV() && (i == 3 || i == 6)) {
                FrsFragment.this.dsI.resetData();
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (FrsFragment.this.dsw.aBl() != null) {
                FrsFragment.this.drN = FrsFragment.this.dsw.aBl();
            }
            FrsFragment.this.dsl.b(FrsFragment.this.drN.bxw());
            FrsFragment.this.kP(1);
            if (i == 7) {
                FrsFragment.this.kQ(FrsFragment.this.drN.bxb());
                return;
            }
            if (FrsFragment.this.drN.vy() != null) {
                FrsFragment.this.setHasMore(FrsFragment.this.drN.vy().vu());
            }
            if (i == 4) {
                if (!FrsFragment.this.dsw.aBV() && TbadkCoreApplication.getInst().isRecAppExist() && FrsFragment.this.dsw.aBL() == 1) {
                    FrsFragment.this.drN.a(FrsFragment.this);
                }
                ArrayList<com.baidu.adp.widget.ListView.h> a2 = FrsFragment.this.dsI.a(false, false, FrsFragment.this.drN.getThreadList(), FrsFragment.this.dsh, false);
                if (a2 != null) {
                    FrsFragment.this.drN.ay(a2);
                    FrsFragment.this.drN.bxF();
                    FrsFragment.this.dsl.a(a2, FrsFragment.this.drN);
                }
                if (FrsFragment.this.dsw != null) {
                    com.baidu.tieba.frs.e.b.a(FrsFragment.this.drN, FrsFragment.this.dsw.aBR(), 2);
                }
                com.baidu.tieba.frs.f.a.a(FrsFragment.this, FrsFragment.this.drN.bbH(), FrsFragment.this.drN.getThreadList(), false, FrsFragment.this.getPn());
                FrsFragment.this.aXi = System.currentTimeMillis() - currentTimeMillis;
                FrsFragment.this.awi();
                return;
            }
            FrsFragment.this.awi();
            switch (i) {
                case 1:
                    FrsFragment.this.dsl.axc();
                    break;
                case 2:
                    FrsFragment.this.dsl.axc();
                    break;
                case 3:
                case 6:
                    if (FrsFragment.this.drN != null) {
                        FrsFragment.this.drN.bxD();
                    }
                    if (FrsFragment.this.dsN != null) {
                        FrsFragment.this.dsN.refresh();
                        break;
                    }
                    break;
            }
            FrsFragment.this.awj();
            if (aVar == null || aVar.errorCode == 0) {
                if (FrsFragment.this.drN != null) {
                    FrsFragment.this.x(false, i == 5);
                    FrsFragment.this.dsl.la(i);
                    FrsFragment.dsn = (System.nanoTime() - this.startTime) / 1000000;
                    if (aVar != null) {
                        FrsFragment.dso = aVar.gSf;
                    }
                } else {
                    return;
                }
            } else if (FrsFragment.this.drN == null || com.baidu.tbadk.core.util.v.z(FrsFragment.this.drN.getThreadList())) {
                FrsFragment.this.a(aVar);
            } else if (aVar.gSe) {
                FrsFragment.this.showToast(FrsFragment.this.getPageContext().getResources().getString(e.j.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
            }
            if (FrsFragment.this.drN.bwL() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11384"));
            }
            if (FrsFragment.this.cYB > -1 && !FrsFragment.this.dsU) {
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.dsw, FrsFragment.this.cYB);
                FrsFragment.this.cYB = -1L;
                FrsFragment.this.dsU = true;
            }
            if (FrsFragment.this.dsi && FrsFragment.this.dsy.ms(49)) {
                FrsFragment.this.dsi = false;
            }
            FrsFragment.this.aXi = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void b(com.baidu.tieba.tbadkCore.i iVar) {
            if ((iVar != null && ("normal_page".equals(FrsFragment.this.dsw.getPageType()) || "frs_page".equals(FrsFragment.this.dsw.getPageType()) || "book_page".equals(FrsFragment.this.dsw.getPageType()))) || "brand_page".equals(FrsFragment.this.dsw.getPageType())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001615, iVar));
                FrsFragment.this.a(iVar);
            }
        }
    };
    private final CustomMessageListener dtu = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.frs.FrsFragment.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                FrsFragment.this.drN.a((com.baidu.tbadk.data.j) customResponsedMessage.getData());
                FrsFragment.this.dsl.axm().notifyDataSetChanged();
            }
        }
    };
    private final CustomMessageListener mMemListener = new CustomMessageListener(2001194) { // from class: com.baidu.tieba.frs.FrsFragment.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && FrsFragment.this.drN != null && (userData = FrsFragment.this.drN.getUserData()) != null) {
                userData.setIsMem(num.intValue());
                if (num.intValue() != 0) {
                    FrsFragment.this.dsx.g(num);
                }
            }
        }
    };
    private final com.baidu.tieba.frs.mc.i dtv = new com.baidu.tieba.frs.mc.i() { // from class: com.baidu.tieba.frs.FrsFragment.17
        @Override // com.baidu.tieba.frs.mc.i
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.h> arrayList, boolean z3) {
            if (FrsFragment.this.dsA != null && FrsFragment.this.dsw != null && FrsFragment.this.dsw.aBV() && z && !z2 && !z3) {
                FrsFragment.this.dsA.lX(i2);
            }
        }
    };
    public final View.OnTouchListener aZX = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.FrsFragment.18
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (FrsFragment.this.dsQ != null) {
                FrsFragment.this.dsQ.onTouch(view, motionEvent);
            }
            if (FrsFragment.this.dsC != null && FrsFragment.this.dsC.axX() != null) {
                FrsFragment.this.dsC.axX().onTouchEvent(motionEvent);
            }
            if (FrsFragment.this.bLs != null) {
                FrsFragment.this.bLs.d(view, motionEvent);
            }
            if (FrsFragment.this.dsx != null) {
                FrsFragment.this.dsx.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private final CustomMessageListener dtw = new CustomMessageListener(2004507) { // from class: com.baidu.tieba.frs.FrsFragment.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "photolive_hostLevel", -1) != -1 && FrsFragment.this.drN.bbH() != null) {
                FrsFragment.this.drN.bbH().setCanAddPhotoLivePost(true);
            }
        }
    };
    public final View.OnClickListener dtx = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsFragment.21
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsFragment.this.dsl == null || view != FrsFragment.this.dsl.axa() || FrsFragment.this.getActivity() == null) {
                if (FrsFragment.this.drN != null && FrsFragment.this.drN.bbH() != null && FrsFragment.this.dsl != null && view == FrsFragment.this.dsl.axg()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12402").al(ImageViewerConfig.FORUM_ID, FrsFragment.this.drN.bbH().getId()).al("uid", TbadkCoreApplication.getCurrentAccount()).al(ImageViewerConfig.FORUM_NAME, FrsFragment.this.drN.bbH().getName()));
                    if (!StringUtils.isNull(FrsFragment.this.drN.bbH().getName())) {
                        FrsFragment.this.sendMessage(new CustomMessage(2002001, new PostSearchActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), FrsFragment.this.drN.bbH().getName(), FrsFragment.this.drN.bbH().getId())));
                        return;
                    }
                    return;
                }
                if (view.getId() == e.g.game_activity_egg_layout && com.baidu.adp.lib.util.l.lb()) {
                    TiebaStatic.log("c10853");
                    if (FrsFragment.this.dsl.axj()) {
                        FrsFragment.this.dsl.axk();
                    } else {
                        String activityUrl = FrsFragment.this.drN.bbH().getYuleData().ye().getActivityUrl();
                        if (!StringUtils.isNull(activityUrl)) {
                            com.baidu.tbadk.browser.a.ag(FrsFragment.this.getPageContext().getPageActivity(), activityUrl);
                        }
                    }
                }
                if (view == FrsFragment.this.dsl.axr() && FrsFragment.this.dsw != null && FrsFragment.this.dsw.hasMore()) {
                    FrsFragment.this.dsl.Wb();
                    FrsFragment.this.Vd();
                }
                if (view != null && view == FrsFragment.this.dsl.axh() && ba.bA(FrsFragment.this.getContext())) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12924").w("obj_locate", 2));
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
        private int dtE = 0;
        private int bzS = 0;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (FrsFragment.this.dsG != null) {
                FrsFragment.this.dsG.aCt();
            }
            this.dtE = 0;
            this.bzS = 0;
            if (recyclerView != null && (recyclerView instanceof BdRecyclerView)) {
                this.dtE = ((BdRecyclerView) recyclerView).getFirstVisiblePosition();
                this.bzS = ((BdRecyclerView) recyclerView).getLastVisiblePosition();
            }
            if (FrsFragment.this.dsS != null) {
                FrsFragment.this.dsS.a(recyclerView, this.dtE, this.bzS);
            }
            if (FrsFragment.this.drN != null && FrsFragment.this.dsl != null && FrsFragment.this.dsl.axm() != null) {
                FrsFragment.this.dsl.aG(this.dtE, this.bzS);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (FrsFragment.this.dsx != null) {
                FrsFragment.this.dsx.setScrollState(i);
            }
            if ((i == 2 || i == 1) && !FrsFragment.this.dst) {
                FrsFragment.this.dst = true;
                FrsFragment.this.dsl.axp();
            }
            if (FrsFragment.this.dsu == null && !FrsFragment.this.awx()) {
                FrsFragment.this.dsu = new com.baidu.tbadk.l.b();
                FrsFragment.this.dsu.fx(1000);
            }
            if (i == 0) {
                if (FrsFragment.this.dsu != null) {
                    FrsFragment.this.dsu.LQ();
                }
                com.baidu.tieba.card.v.akM().eP(true);
                FrsFragment.this.dsl.aF(this.dtE, this.bzS);
            } else if (FrsFragment.this.dsu != null) {
                FrsFragment.this.dsu.LP();
            }
            if (FrsFragment.this.dsS != null) {
                FrsFragment.this.dsS.onScrollStateChanged(recyclerView, i);
            }
            if (i == 0) {
                com.baidu.tieba.frs.f.h.a(FrsFragment.this.dsl, FrsFragment.this.drN, FrsFragment.this.getForumId(), false, null);
            }
            if (FrsFragment.this.dsy != null && i == 1) {
                FrsFragment.this.dsy.aCY();
            }
        }
    };
    private final d dty = new d() { // from class: com.baidu.tieba.frs.FrsFragment.24
        @Override // com.baidu.tieba.frs.d
        public void a(int i, int i2, View view, View view2, bb bbVar) {
            if (i != FrsFragment.this.dsl.axm().azo()) {
                if (i != FrsFragment.this.dsl.axm().azp()) {
                    if (i == FrsFragment.this.dsl.axm().azq() && FrsFragment.this.drN != null && FrsFragment.this.drN.getUserData() != null && FrsFragment.this.drN.getUserData().isBawu()) {
                        String bwZ = FrsFragment.this.drN.bwZ();
                        if (!com.baidu.tbadk.core.util.ao.isEmpty(bwZ) && FrsFragment.this.drN.bbH() != null) {
                            com.baidu.tbadk.browser.a.ae(FrsFragment.this.getPageContext().getPageActivity(), bwZ);
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10502").al(ImageViewerConfig.FORUM_ID, FrsFragment.this.drN.bbH().getId()).al("uid", FrsFragment.this.drN.getUserData().getUserId()));
                        }
                    }
                } else if (ba.bA(FrsFragment.this.getPageContext().getPageActivity())) {
                    TiebaStatic.log("my_service_ck");
                    if (FrsFragment.this.drN != null && FrsFragment.this.drN.bbH() != null) {
                        ForumData bbH = FrsFragment.this.drN.bbH();
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(bbH.getId(), 0L), bbH.getName(), bbH.getImage_url(), 0)));
                    }
                }
            } else if (ba.bA(FrsFragment.this.getActivity())) {
                TiebaStatic.log("forum_fortune_click");
                com.baidu.tieba.frs.f.i.b(FrsFragment.this.getPageContext(), FrsFragment.this.drN);
            }
        }
    };
    private final NoNetworkView.a dpW = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.FrsFragment.25
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bd(boolean z) {
            if (FrsFragment.this.dsw.aBL() == 1 && z && !FrsFragment.this.dsl.aww()) {
                if (FrsFragment.this.drN == null || com.baidu.tbadk.core.util.v.z(FrsFragment.this.drN.getThreadList())) {
                    FrsFragment.this.hideNetRefreshView(FrsFragment.this.dsl.axn());
                    FrsFragment.this.showLoadingView(FrsFragment.this.dsl.axn(), true);
                    FrsFragment.this.dsl.fW(false);
                    FrsFragment.this.refresh();
                    return;
                }
                FrsFragment.this.dsl.axc();
            }
        }
    };
    private final CustomMessageListener aHc = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.FrsFragment.26
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                com.baidu.tieba.frs.f.c.a(customResponsedMessage, FrsFragment.this.dsl, FrsFragment.this.drN);
            }
        }
    };
    private com.baidu.adp.widget.ListView.n dtz = new a();
    private al dtA = new al() { // from class: com.baidu.tieba.frs.FrsFragment.27
        @Override // com.baidu.tieba.frs.al
        public void a(int i, int i2, ar arVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
            com.baidu.adp.lib.g.e.jt().post(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.27.1
                @Override // java.lang.Runnable
                public void run() {
                    if (FrsFragment.this.dsl != null && FrsFragment.this.dsl.alI()) {
                        FrsFragment.this.Vd();
                    }
                }
            });
        }
    };
    private CustomMessageListener dtB = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.frs.FrsFragment.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    FrsFragment.this.dsT = true;
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.frs.loadmore.a
    public /* bridge */ /* synthetic */ com.baidu.adp.base.e getPageContext() {
        return super.getPageContext();
    }

    public com.baidu.tieba.frs.entelechy.b.b avV() {
        return this.dsE;
    }

    public com.baidu.adp.widget.ListView.n avW() {
        return this.dtz;
    }

    public com.baidu.tieba.frs.mc.d avX() {
        return this.dsH;
    }

    public com.baidu.tieba.frs.smartsort.b avY() {
        return this.dsA;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public FrsModelController avZ() {
        return this.dsw;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public com.baidu.tieba.frs.mc.c awa() {
        return this.dsI;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public com.baidu.tieba.frs.vc.f awb() {
        return this.dsx;
    }

    public com.baidu.tieba.frs.vc.j awc() {
        return this.dsy;
    }

    public an awd() {
        return this.dsC;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public k awe() {
        return this.dsl;
    }

    @Override // com.baidu.tieba.frs.am
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.am, com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.dsd;
    }

    public void setForumName(String str) {
        this.dsd = str;
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
        if (this.dsI == null) {
            return 1;
        }
        return this.dsI.getPn();
    }

    public int getPn() {
        if (this.dsI == null) {
            return 1;
        }
        return this.dsI.getPn();
    }

    public void setPn(int i) {
        if (this.dsI != null) {
            this.dsI.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.dsI != null) {
            this.dsI.setHasMore(i);
        }
    }

    public int awf() {
        if (this.dsI == null) {
            return -1;
        }
        return this.dsI.awf();
    }

    public boolean awg() {
        return this.dsj;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d.a aVar) {
        if (aVar == null) {
            String string = TbadkCoreApplication.getInst().getString(e.j.error_unkown_try_again);
            this.dsl.awX();
            showNetRefreshView(this.dsl.axn(), string, true);
        } else if (340001 == aVar.errorCode) {
            a(aVar, this.drN.bwI());
        } else {
            if (com.baidu.tbadk.core.util.v.z(this.drN.getThreadList())) {
                b(aVar);
            }
            if (awx()) {
                setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst(), e.C0141e.ds280));
            } else {
                setNetRefreshViewEmotionDefMarginTop();
            }
        }
    }

    public void a(View view, String str, boolean z, List<RecmForumInfo> list) {
        this.dsl.awX();
        this.dsl.kW(8);
        if (this.dsR == null) {
            this.dsR = new com.baidu.tieba.frs.view.a(getPageContext(), getNetRefreshListener());
        }
        this.dsR.hG(str);
        this.dsR.bC(list);
        this.dsR.c(view, z);
    }

    private void a(d.a aVar, List<RecmForumInfo> list) {
        if (this.dsl != null) {
            this.dsl.awX();
            this.dsl.setTitle(this.dsd);
            a(this.dsl.axn(), aVar.errorMsg, true, list);
        }
    }

    private void b(d.a aVar) {
        this.dsl.awX();
        if (aVar.gSe) {
            showNetRefreshView(this.dsl.axn(), TbadkCoreApplication.getInst().getString(e.j.net_error_text, new Object[]{aVar.errorMsg, Integer.valueOf(aVar.errorCode)}), true);
        } else {
            showNetRefreshView(this.dsl.axn(), aVar.errorMsg, true);
        }
    }

    public void awh() {
        hideLoadingView(this.dsl.axn());
        if (!this.dsl.aww()) {
            this.dsl.fX(false);
        } else {
            this.dsl.fX(true);
        }
        if (this.dsl.awV() instanceof com.baidu.tieba.frs.tab.c) {
            ((com.baidu.tieba.frs.tab.c) this.dsl.awV()).aCn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awi() {
        if (awf() == 0 && com.baidu.tbadk.core.util.v.z(this.drN.bwR())) {
            if (com.baidu.tbadk.core.util.v.z(this.drN.getThreadList())) {
                this.dsl.Wd();
            } else {
                this.dsl.Wc();
            }
        } else if (com.baidu.tbadk.core.util.v.y(this.drN.getThreadList()) > 3) {
            this.dsl.Wb();
        } else {
            this.dsl.axq();
        }
    }

    public void a(ErrorData errorData) {
        awh();
        this.dsl.axc();
        d.a aBI = this.dsw.aBI();
        boolean z = com.baidu.tbadk.core.util.v.z(this.drN.getThreadList());
        if (aBI != null && z) {
            if (this.dsw.aBJ() != 0) {
                this.dsw.aBP();
                this.dsl.axc();
            } else {
                a(aBI);
            }
            this.dsl.y(this.drN.bxV(), false);
            return;
        }
        a(aBI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kP(int i) {
        List<WindowToast> list;
        if (TbadkCoreApplication.isLogin() && this.drN != null && (list = this.drN.gTJ) != null && list.size() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < list.size()) {
                    WindowToast windowToast = list.get(i3);
                    if (windowToast == null || windowToast.toast_type.intValue() != i) {
                        i2 = i3 + 1;
                    } else if (!com.baidu.tbadk.core.util.ao.isEmpty(windowToast.toast_link)) {
                        sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(getPageContext().getPageActivity(), "", com.baidu.tbadk.util.ab.ij(windowToast.toast_link), true)));
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
    public void awj() {
        if (this.drN == null || this.drN.bbH() != null) {
            this.dsl.axl();
        } else if (this.drN.bbH().getYuleData() != null && this.drN.bbH().getYuleData().yd()) {
            TiebaStatic.log("c10852");
            this.dsl.a(this.drN.bbH().getYuleData().ye());
        } else {
            this.dsl.axl();
        }
    }

    private void w(boolean z, boolean z2) {
        if (this.dsw != null && this.drN != null && this.dsl != null && z) {
            if (!this.dsw.aBV() && this.dsw.aBL() == 1) {
                if (!this.dsw.aBT()) {
                    this.drN.bxL();
                    this.drN.bxM();
                }
                boolean z3 = false;
                if (this.dsl.axm().k(com.baidu.tieba.card.data.n.cIk)) {
                    z3 = this.drN.bxP();
                }
                if (!z3) {
                    this.drN.bxN();
                }
                if (TbadkCoreApplication.getInst().isRecAppExist()) {
                    this.drN.a(this);
                }
                if (!this.dsl.axm().k(bb.akb)) {
                    this.drN.bxE();
                }
                this.drN.bxQ();
            }
            if (!this.dsl.axm().k(bb.akb)) {
                this.drN.bxK();
                this.drN.bxI();
            } else {
                this.drN.bxJ();
                this.drN.bxH();
            }
            this.drN.bxF();
            this.drN.bxC();
            if (this.dsl.axm().k(com.baidu.tieba.h.b.dUE)) {
                this.drN.mM(z2);
            }
            if (TbadkCoreApplication.isLogin() && (!this.dsw.aBV() || this.dsw.isNetFirstLoad)) {
                this.drN.bxR();
            }
            this.drN.bxT();
        }
    }

    public boolean awk() {
        if (this.dsx != null && this.dsw != null) {
            this.dsx.a(this.dsw.getPageType(), this.drN);
        }
        boolean z = false;
        if (this.drN != null) {
            z = this.drN.bxW();
        }
        awm();
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kQ(int i) {
        ao aoVar = null;
        awk();
        awt();
        try {
            if (this.drN != null) {
                this.dsl.a((ArrayList<com.baidu.adp.widget.ListView.h>) null, this.drN);
                this.dsx.mn(1);
                this.dsl.axf();
                this.dsy.a(this.drN, this.dsw.aBR());
                com.baidu.tieba.frs.tab.d mt = this.dsy.mt(this.drN.bxb());
                if (mt != null && !TextUtils.isEmpty(mt.url)) {
                    aoVar = new ao();
                    aoVar.dvZ = mt.url;
                    aoVar.stType = mt.name;
                }
                this.dsw.a(this.drN.bxb(), 0, aoVar);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(boolean z, boolean z2) {
        try {
            if (this.drN != null && this.dsy != null && this.dsw != null) {
                if (!this.dsl.axm().k(bb.akb)) {
                    this.drN.bxE();
                }
                boolean z3 = com.baidu.tbadk.core.util.v.z(this.drN.bxp());
                this.dsl.fU(z3);
                if (!z3) {
                    if (this.dsS == null) {
                        this.dsS = new com.baidu.tieba.frs.vc.e(this, (NoPressedRelativeLayout) this.mRootView);
                    }
                    if (this.bLs == null) {
                        this.bLs = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
                    }
                } else {
                    this.dsS = null;
                    this.bLs = null;
                }
                if (this.drN.bbH() != null) {
                    this.dsd = this.drN.bbH().getName();
                    this.forumId = this.drN.bbH().getId();
                }
                if (this.drN.bxW()) {
                    this.dsy.a(this.drN, this.dsw.aBR());
                }
                if (z) {
                    w(true, z);
                } else {
                    w(this.dsv, z);
                }
                awk();
                if (this.dsE != null) {
                    this.dsE.a(this.dsx, this.drN);
                }
                if (this.drN.vy() != null) {
                    setHasMore(this.drN.vy().vu());
                }
                ArrayList<com.baidu.adp.widget.ListView.h> a2 = this.dsI.a(z2, true, this.drN.getThreadList(), null, z, false);
                if (a2 != null) {
                    this.drN.ay(a2);
                }
                this.drN.bxS();
                if (this.dsw.aBL() == 1) {
                    awq();
                    if (!z && this.dsw.getPn() == 1) {
                        awl();
                    }
                }
                this.drQ = this.drN.aBN();
                if (this.dsh != null) {
                    this.dsg = true;
                    this.dsh.uf(this.drQ);
                    com.baidu.tieba.frs.f.a.a(this, this.drN.bbH(), this.drN.getThreadList(), this.dsg, getPn());
                }
                if (this.dsG != null) {
                    this.dsG.aQ(this.dsy.aCV());
                }
                awh();
                this.dsl.awY();
                this.dsl.y(true, false);
                if (this.drN.bbH() != null) {
                    this.dsl.mY(this.drN.bbH().getWarningMsg());
                }
                if (this.drN != null && this.drN.bxs() != null && com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("frs_video_activity_guide", 0L) == 0) {
                    com.baidu.adp.lib.g.e.jt().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.11
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsFragment.this.dsl.axv();
                        }
                    }, 1000L);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2921326, this));
                this.dsl.awR();
                if (this.drN != null && this.drN.bbH() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016564, new VisitedForumData(this.drN.bbH().getId(), this.drN.bbH().getName(), this.drN.bbH().getImage_url(), String.valueOf(System.currentTimeMillis() / 1000), "showlive".equals(this.drN.bbH().special_forum_type))));
                }
                this.dsY.a(this.drN.gTO, this.drN.bbH());
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void awl() {
        if (this.dsL == null) {
            this.dsL = new com.baidu.tieba.frs.live.a(this, com.baidu.adp.lib.g.b.l(this.forumId, 0));
        }
        this.dsL.aBt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.i iVar) {
        try {
            if (!this.dss && iVar != null && this.drN != null) {
                this.drN.e(iVar);
                x(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void awm() {
        if (this.dsw != null) {
            mW(this.dsw.getPageType());
        } else {
            mW("normal_page");
        }
    }

    private void mW(String str) {
        fN("frs_page".equals(str));
        if (this.dsE != null) {
            this.dsE.a(this.dsx, this.dsl, this.drN);
        }
    }

    public void fN(boolean z) {
        if (this.dsJ != null) {
            this.dsJ.c(this.dsl, z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(e.h.frs_activity, viewGroup, false);
            this.drX = new com.baidu.tieba.frs.entelechy.b();
            this.dsE = this.drX.ayP();
            this.dsx = new com.baidu.tieba.frs.vc.f(this, this.drX, (FrsHeaderViewContainer) this.mRootView.findViewById(e.g.header_view_container));
            this.dsy = new FrsTabViewController(this, this.mRootView);
            this.dsx.a(this.dsy);
            this.dsy.a(this.dti);
            Intent intent = getActivity().getIntent();
            if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                this.drZ = true;
            }
            this.dsl = new k(this, this.dtx, this.drX, this.drZ, this.dsx);
            this.dsl.setHeaderViewHeight(this.dsP);
            this.dsY = new com.baidu.tieba.frs.brand.buttommenu.a(getPageContext(), this.mRootView);
        } else {
            if (this.mRootView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            this.dsl.axu();
        }
        this.dtb = true;
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        this.cYB = System.currentTimeMillis();
        this.beginTime = this.cYB;
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.dsi = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.cYB = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            I(intent);
        }
        this.aXa = this.beginTime - this.cYB;
        this.dsh = new com.baidu.tieba.tbadkCore.data.e("frs", com.baidu.tieba.tbadkCore.data.e.gUY);
        this.dsw = new FrsModelController(this, this.dtt);
        this.dsw.a(this.dth);
        this.dsw.init();
        if (intent != null) {
            this.dsw.i(intent.getExtras());
        } else if (bundle != null) {
            this.dsw.i(bundle);
        } else {
            this.dsw.i(null);
        }
        if (intent != null) {
            this.dsx.m(intent.getExtras());
        } else if (bundle != null) {
            this.dsx.m(bundle);
        } else {
            this.dsx.m((Bundle) null);
        }
        this.dsk = getVoiceManager();
        this.dsM = new j(getPageContext(), this);
        initUI();
        initData(bundle);
        if (!awx()) {
            this.dsC = new an(getActivity(), this.dsl, this.dsx);
            this.dsC.gl(true);
        }
        this.dsk = getVoiceManager();
        if (this.dsk != null) {
            this.dsk.onCreate(getPageContext());
        }
        new com.baidu.tieba.frs.mc.g();
        this.dsI = new com.baidu.tieba.frs.mc.c(this, this.dtv);
        this.dsA = new com.baidu.tieba.frs.smartsort.b(this);
        this.dsJ = new com.baidu.tieba.frs.vc.h(this);
        this.dsG = new com.baidu.tieba.frs.vc.a(getPageContext(), this.dsw.aBS());
        this.dsB = new com.baidu.tieba.frs.mc.b(this);
        this.dsH = new com.baidu.tieba.frs.mc.d(this);
        this.dsz = new com.baidu.tieba.frs.mc.f(this);
        this.dsK = new com.baidu.tieba.frs.mc.a(this);
        this.dsN = new com.baidu.tieba.frs.vc.c(this);
        this.dsO = new com.baidu.tieba.frs.mc.e(this, getUniqueId());
        this.dsV = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "frs");
        this.dsW = new com.baidu.tieba.ala.a(getPageContext());
        registerListener(this.bIg);
        registerListener(this.mMemListener);
        registerListener(this.dto);
        registerListener(this.dtw);
        registerListener(this.dtn);
        registerListener(this.dtu);
        registerListener(this.dtk);
        registerListener(this.dtl);
        registerListener(this.dtm);
        registerListener(this.dte);
        registerListener(this.dtf);
        registerListener(this.dtB);
        registerListener(this.dtr);
        registerListener(this.dtg);
        registerListener(this.dts);
        registerListener(this.dtq);
        this.dtd.setTag(getPageContext().getUniqueId());
        registerListener(this.dtd);
        this.dsl.fW(false);
        if (!awx() && !this.hasInit) {
            showLoadingView(this.dsl.axn(), true);
            this.dsw.r(3, false);
        }
        com.baidu.tieba.frs.a.avq().a(new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.15
            @Override // com.baidu.tieba.frs.a.b
            public void v(boolean z, boolean z2) {
                if (FrsFragment.this.dsl != null) {
                    FrsFragment.this.dsl.kX(z ? 0 : 8);
                    if (!z2) {
                        FrsFragment.this.dta = z;
                    }
                    if (FrsFragment.this.dsl.axm() != null && FrsFragment.this.dsw != null && FrsFragment.this.dsw.aBM()) {
                        FrsFragment.this.dsl.axm().notifyDataSetChanged();
                    }
                    if (FrsFragment.this.dsl.awW() != null) {
                        FrsFragment.this.dsl.fT(!z);
                    }
                    if (FrsFragment.this.getActivity() instanceof FrsActivity) {
                        ((FrsActivity) FrsFragment.this.getActivity()).fM(!z);
                    }
                    if (FrsFragment.this.dsY != null) {
                        FrsFragment.this.dsY.gu(!z);
                    }
                    FrsFragment.this.dsl.fY(!z);
                    FrsFragment.this.dsl.fZ(z ? false : true);
                }
            }

            @Override // com.baidu.tieba.frs.a.b
            public void kM(int i) {
                if (FrsFragment.this.dsl != null) {
                    FrsFragment.this.dsl.kY(i);
                }
            }

            @Override // com.baidu.tieba.frs.a.b
            public void avw() {
                com.baidu.adp.lib.util.l.showToast(FrsFragment.this.getContext(), e.j.frs_multi_delete_max_num);
            }
        });
        this.dsl.b(new d.a() { // from class: com.baidu.tieba.frs.FrsFragment.16
            @Override // com.baidu.tieba.NEGFeedBack.d.a
            public void a(DeleteThreadHttpResponseMessage deleteThreadHttpResponseMessage) {
                int i;
                int i2 = 0;
                if (deleteThreadHttpResponseMessage != null) {
                    FrsFragment.this.dsl.Ro();
                    FrsFragment.this.dsl.axw();
                    if (deleteThreadHttpResponseMessage.getError() == 0) {
                        String text = !TextUtils.isEmpty(deleteThreadHttpResponseMessage.getText()) ? deleteThreadHttpResponseMessage.getText() : FrsFragment.this.getString(e.j.delete_fail);
                        if (deleteThreadHttpResponseMessage.getRetType() == 1211066) {
                            if (FrsFragment.this.cGU == null) {
                                FrsFragment.this.cGU = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.cGU.dT(text);
                            FrsFragment.this.cGU.a(e.j.dialog_known, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.16.1
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.cGU.aF(false);
                            FrsFragment.this.cGU.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.cGU.yl();
                        } else if (deleteThreadHttpResponseMessage.getRetType() == 1211067) {
                            if (FrsFragment.this.cGU == null) {
                                FrsFragment.this.cGU = new com.baidu.tbadk.core.dialog.a(FrsFragment.this.getActivity());
                            }
                            FrsFragment.this.cGU.dT(text);
                            FrsFragment.this.cGU.a(e.j.know, new a.b() { // from class: com.baidu.tieba.frs.FrsFragment.16.2
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    if (aVar != null) {
                                        aVar.dismiss();
                                    }
                                }
                            });
                            FrsFragment.this.cGU.aF(false);
                            FrsFragment.this.cGU.b(FrsFragment.this.getPageContext());
                            FrsFragment.this.cGU.yl();
                        } else {
                            FrsFragment.this.dsl.X(deleteThreadHttpResponseMessage.getText(), ContextCompat.getColor(FrsFragment.this.getContext(), deleteThreadHttpResponseMessage.getRetType() == 1 ? e.d.nav_bar_tip_error : e.d.cp_link_tip_a_alpha95));
                        }
                        FrsFragment.this.bm(deleteThreadHttpResponseMessage.getSuccessItems());
                        com.baidu.tieba.frs.a.avq().bl(deleteThreadHttpResponseMessage.getSuccessItems());
                        Iterator<com.baidu.adp.widget.ListView.h> it = FrsFragment.this.drN.getThreadList().iterator();
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
                            FrsFragment.this.Vd();
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

    public void fO(boolean z) {
        if (this.dsy != null) {
            this.dsy.dOs = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bm(List<String> list) {
        if (!com.baidu.tbadk.core.util.v.z(list)) {
            ArrayList<com.baidu.adp.widget.ListView.h> threadList = this.drN.getThreadList();
            if (!com.baidu.tbadk.core.util.v.z(threadList) && this.dsl.getListView() != null && this.dsl.getListView().getData() != null) {
                Iterator<com.baidu.adp.widget.ListView.h> it = threadList.iterator();
                List<com.baidu.adp.widget.ListView.h> data = this.dsl.getListView().getData();
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
                                this.dsI.ab(bbVar);
                                this.dsl.getListView().getAdapter().notifyItemRemoved(i);
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
    public void VD() {
        if (isAdded() && this.bEO && !isLoadingViewAttached()) {
            showLoadingView(this.dsl.axn(), true);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void VE() {
        if (isAdded() && this.bEO && isLoadingViewAttached()) {
            hideLoadingView(this.dsl.axn());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (awx()) {
            showLoadingView(this.dsl.axn(), true);
            this.dsl.kZ(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.dsw.r(3, true);
            Cb().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void setHeaderViewHeight(int i) {
        this.dsP = i;
        if (this.dsl != null) {
            this.dsl.setHeaderViewHeight(this.dsP);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.u uVar) {
        if (uVar != null) {
            this.aZW = uVar.MQ();
            this.dsQ = uVar.MR();
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void showFloatingView() {
        if (this.aZW != null) {
            this.aZW.cr(true);
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
            this.dsd = data.getQueryParameter("name");
            this.mFrom = data.getQueryParameter("from");
            if (!StringUtils.isNull(this.dsd)) {
                intent.putExtra("name", this.dsd);
            }
            if (!StringUtils.isNull(this.mFrom)) {
                intent.putExtra("from", this.mFrom);
            }
            TiebaStatic.log("c10105");
        }
        if (StringUtils.isNull(this.dsd)) {
            com.baidu.tieba.frs.f.d K = com.baidu.tieba.frs.f.i.K(intent);
            if (K != null) {
                this.dsd = K.forumName;
                if (K.dML != null && K.dML.equals("aidou")) {
                    com.baidu.tbadk.core.dialog.h.aoc = System.currentTimeMillis();
                }
            }
            if (!StringUtils.isNull(this.dsd)) {
                intent.putExtra("name", this.dsd);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.dsk = getVoiceManager();
        if (this.dsk != null) {
            this.dsk.onStart(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        Intent intent;
        registerListener(2001118, this.aHc);
        if (bundle != null) {
            this.dsd = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
            this.dsd = intent.getStringExtra("name");
            this.mFrom = intent.getStringExtra("from");
            this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
        }
        if (getArguments() != null) {
            this.dse = getArguments().getBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, false);
        }
        if (TextUtils.isEmpty(this.mFrom) || FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
        }
        if (this.mIsLogin) {
            registerListener(2001120, this.aHc);
        }
        this.dsx.m(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dtB);
        if (this.dsk != null) {
            this.dsk.onDestory(getPageContext());
        }
        com.baidu.tieba.recapp.report.a.remove("FRS");
        this.dsk = null;
        com.baidu.tieba.card.v.akM().eP(false);
        if (this.drN != null && this.drN.bbH() != null) {
            ac.axU().bL(com.baidu.adp.lib.g.b.d(this.drN.bbH().getId(), 0L));
        }
        if (this.dsL != null) {
            this.dsL.onDestory();
        }
        if (this.dsl != null) {
            com.baidu.tieba.frs.f.h.a(this.dsl, this.drN, getForumId(), false, null);
            this.dsl.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.dsu != null) {
                this.dsu.LR();
            }
            this.dsl.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.dsw.onActivityDestroy();
        this.dsx.onActivityDestroy();
        if (this.dsw != null) {
            this.dsw.Xn();
        }
        if (this.dsC != null) {
            this.dsC.MP();
        }
        if (this.dsF != null) {
            this.dsF.destory();
        }
        if (this.dsG != null) {
            this.dsG.destory();
        }
        if (this.dsA != null) {
            this.dsA.onDestroy();
        }
        if (this.dsS != null) {
            this.dsS.onDestory();
        }
        if (this.dsK != null) {
            this.dsK.onDestroy();
        }
        if (this.dsV != null) {
            this.dsV.onDestroy();
        }
        if (this.dsW != null) {
            this.dsW.onDestroy();
        }
        com.baidu.tieba.recapp.d.a.bqL().bqN();
        com.baidu.tieba.frs.f.j.aCq();
        if (this.dsy != null) {
            this.dsy.a((FrsTabViewController.a) null);
            this.dsy.aCY();
        }
        if (this.dsX != null) {
            this.dsX.onDestroy();
        }
        if (this.dsZ != null) {
            this.dsZ.onDestroy();
        }
        com.baidu.tieba.frs.a.avq().a(null);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.dsd);
        bundle.putString("from", this.mFrom);
        this.dsw.onSaveInstanceState(bundle);
        if (this.dsk != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            this.dsk.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.dsK != null) {
            this.dsK.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dsl != null) {
            this.dsl.axc();
            this.dsl.onResume();
        }
        this.dsz.gI(true);
        this.dsv = true;
        if (dsc) {
            dsc = false;
            this.dsl.startPullRefresh();
            return;
        }
        if (this.dsk != null) {
            this.dsk.onResume(getPageContext());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921338));
        this.dsl.ga(false);
        if (this.dsT) {
            refresh(6);
            this.dsT = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
    }

    public boolean awn() {
        Intent intent;
        if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
            return false;
        }
        return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
    }

    public void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.dsd = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.dsf = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.dsf) {
                awo();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awo() {
        this.dsl.startPullRefresh();
    }

    public void closeActivity() {
        com.baidu.tieba.frs.f.i.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.mFrom);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.dsl.setTitle(this.dsd);
        } else {
            this.dsl.setTitle("");
            this.mFlag = 1;
        }
        this.dsl.setOnAdapterItemClickListener(this.dtz);
        this.dsl.addOnScrollListener(this.mScrollListener);
        this.dsl.h(this.dpW);
        this.dsl.axm().a(this.dty);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dtb) {
            this.dsl.onChangeSkinType(i);
            this.dsx.mm(i);
            this.dsy.onChangeSkinType(i);
            if (this.dsR != null) {
                this.dsR.onChangeSkinType();
            }
            if (this.dsX != null) {
                this.dsX.onChangeSkinType(i);
            }
            if (this.dsY != null) {
                this.dsY.d(getPageContext(), i);
            }
            if (this.cGU != null) {
                com.baidu.tbadk.o.a.a(getPageContext(), this.cGU.ym());
            }
        }
    }

    public void kR(int i) {
        if (!this.mIsLogin) {
            if (this.drN != null && this.drN.vj() != null) {
                this.drN.vj().setIfpost(1);
            }
            if (i == 0) {
                ba.bz(getActivity());
            }
        } else if (this.drN != null) {
            if (i == 0) {
                com.baidu.tieba.frs.f.j.d(this, 0);
            } else {
                this.dsl.axe();
            }
        }
    }

    public void refresh() {
        com.baidu.tieba.a.d.SB().jc("page_frs");
        refresh(3);
    }

    public void refresh(int i) {
        this.dss = false;
        awt();
        if (this.dsl.awU() != null) {
            this.dsl.awU().aHP();
        }
        this.dsw.r(i, true);
    }

    private void awp() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.g.h.ju().d(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.20
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.uD(FrsFragment.this.dsd);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awq() {
        awt();
        try {
            if (this.drN != null) {
                this.dsl.aiB();
                this.dsl.fT(awC());
                if (!com.baidu.tieba.frs.vc.f.k(this.drN) || !com.baidu.tieba.frs.vc.f.j(this.drN)) {
                }
                if (this.drN.bbH() != null) {
                    this.dsd = this.drN.bbH().getName();
                    this.forumId = this.drN.bbH().getId();
                }
                if (this.drN.vy() != null) {
                    setHasMore(this.drN.vy().vu());
                }
                this.dsl.setTitle(this.dsd);
                this.dsl.setForumName(this.dsd);
                TbadkCoreApplication.getInst().setDefaultBubble(this.drN.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.drN.getUserData().getBimg_end_time());
                awp();
                awr();
                ArrayList<com.baidu.adp.widget.ListView.h> threadList = this.drN.getThreadList();
                if (threadList != null) {
                    this.dsl.a(threadList, this.drN);
                    com.baidu.tieba.frs.f.c.w(this.dsl);
                    this.dsx.mn(getPageNum());
                    this.dsx.h(this.drN);
                    this.dsy.a(this.drN, this.dsw.aBR());
                    this.dsl.axf();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void awr() {
        if (this.drN != null) {
            if (this.drN.bbW() == 1) {
                this.dsl.axm().setFromCDN(true);
            } else {
                this.dsl.axm().setFromCDN(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.dsz.gI(false);
        this.dsv = false;
        this.dsl.onPause();
        if (this.dsk != null) {
            this.dsk.onPause(getPageContext());
        }
        this.dsl.ga(true);
        if (this.dsG != null) {
            this.dsG.aCt();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.dsy != null && this.dsy.aCW() != null && (this.dsy.aCW().fragment instanceof BaseFragment)) {
            ((BaseFragment) this.dsy.aCW().fragment).setPrimary(z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.v.akM().eP(false);
        if (this.drN != null && this.drN.bbH() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            com.baidu.tbadk.distribute.a.Iv().a(getPageContext().getPageActivity(), "frs", this.drN.bbH().getId(), 0L);
        }
        if (this.dsk != null) {
            this.dsk.onStop(getPageContext());
        }
        if (Cb() != null) {
            Cb().getRecycledViewPool().clear();
        }
        this.dsx.onActivityStop();
        com.baidu.tbadk.util.v.MT();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            if (this.dsx != null) {
                this.dsx.fR(isPrimary());
            }
            if (this.dsl != null) {
                this.dsl.fR(isPrimary());
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (com.baidu.tieba.frs.a.avq().avr()) {
                com.baidu.tieba.frs.a.avq().reset();
                return true;
            } else if (this.dsl != null) {
                return this.dsl.axb();
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
        com.baidu.tbadk.distribute.a.Iv().a(advertAppInfo, this.forumId, 0L, "FRS", str, getPn());
    }

    @Override // com.baidu.tieba.recapp.n
    public void aws() {
        avZ().aws();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dsk == null) {
            this.dsk = VoiceManager.instance();
        }
        return this.dsk;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdRecyclerView Cb() {
        if (this.dsl == null) {
            return null;
        }
        return this.dsl.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void awt() {
        if (this.dsk != null) {
            this.dsk.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> Cc() {
        if (this.aBR == null) {
            this.aBR = UserIconBox.k(getPageContext().getPageActivity(), 8);
        }
        return this.aBR;
    }

    public void awu() {
        if (getFragmentActivity() != null && getFragmentActivity().getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.a(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.k onGetPreLoadListView() {
        return Cb().getPreLoadHandle();
    }

    @Override // com.baidu.tieba.frs.ak
    public NavigationBar WW() {
        if (this.dsl == null) {
            return null;
        }
        return this.dsl.WW();
    }

    @Override // com.baidu.tbadk.core.view.NavigationBar.a
    public void b(Pair<Integer, Integer> pair) {
        this.dsq = pair;
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
                if (bdUniqueId == p.duV) {
                    if (FrsFragment.this.dsl != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11752").al(ImageViewerConfig.FORUM_ID, FrsFragment.this.forumId).al("obj_locate", "1"));
                        FrsFragment.this.dsl.startPullRefresh();
                    }
                } else if (hVar != null && (hVar instanceof bb)) {
                    bb bbVar = (bb) hVar;
                    if (bbVar.wY() == null || bbVar.wY().getGroup_id() == 0 || ba.bA(FrsFragment.this.getActivity())) {
                        if (bbVar.wQ() != 1 || ba.bA(FrsFragment.this.getActivity())) {
                            if (bbVar.wA() != null) {
                                if (ba.bA(FrsFragment.this.getActivity())) {
                                    String postUrl = bbVar.wA().getPostUrl();
                                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.lb()) {
                                        com.baidu.tbadk.browser.a.ag(FrsFragment.this.getActivity(), postUrl);
                                    }
                                }
                            } else if (bbVar.xh() != null) {
                                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                    ba.bz(FrsFragment.this.getPageContext().getPageActivity());
                                    return;
                                }
                                com.baidu.tbadk.core.data.m xh = bbVar.xh();
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(FrsFragment.this.getPageContext().getPageActivity(), xh.getCartoonId(), xh.getChapterId(), 2)));
                            } else {
                                com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                                if (readThreadHistory != null && !readThreadHistory.uJ(bbVar.getId())) {
                                    readThreadHistory.uI(bbVar.getId());
                                }
                                boolean z = false;
                                final String wu = bbVar.wu();
                                if (wu != null && !wu.equals("")) {
                                    z = true;
                                    new Thread(new Runnable() { // from class: com.baidu.tieba.frs.FrsFragment.a.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(wu);
                                            xVar.zR().AP().mIsNeedAddCommenParam = false;
                                            xVar.zR().AP().mIsUseCurrentBDUSS = false;
                                            xVar.zu();
                                        }
                                    }).start();
                                }
                                String tid = bbVar.getTid();
                                if (tid == null) {
                                    tid = "";
                                }
                                if (bbVar.wh() == 2 && !tid.startsWith("pb:")) {
                                    ay.AN().c(FrsFragment.this.getPageContext(), new String[]{tid, "", null});
                                    return;
                                }
                                if (tid.startsWith("pb:")) {
                                    bbVar.setId(tid.substring(3));
                                }
                                if (bdUniqueId.getId() == bb.alv.getId()) {
                                    com.baidu.tieba.frs.f.h.a(bbVar.vT());
                                } else if (bdUniqueId.getId() == bb.ake.getId()) {
                                    com.baidu.tbadk.core.util.am amVar = new com.baidu.tbadk.core.util.am("c12940");
                                    amVar.al("obj_type", "2");
                                    amVar.al("tid", bbVar.getTid());
                                    TiebaStatic.log(amVar);
                                }
                                com.baidu.tieba.frs.f.i.a(FrsFragment.this, bbVar, i, z);
                                com.baidu.tieba.frs.f.h.a(FrsFragment.this, FrsFragment.this.drN, bbVar);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.l.lb()) {
            hideNetRefreshView(this.dsl.axn());
            showLoadingView(this.dsl.axn(), true);
            this.dsl.fW(false);
            this.dsw.r(3, true);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public com.baidu.tieba.tbadkCore.l awv() {
        return this.drN;
    }

    public boolean aww() {
        return this.dsl.aww();
    }

    public void Z(Object obj) {
        if (this.dsB != null && this.dsB.dKg != null) {
            this.dsB.dKg.j(obj);
        }
    }

    public void aa(Object obj) {
        if (this.dsB != null && this.dsB.dKh != null) {
            this.dsB.dKh.j(obj);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        this.dsl.getListView().stopScroll();
        if (!this.dsl.axi()) {
            if (!com.baidu.adp.lib.util.l.lb()) {
                this.dsl.Wd();
            } else if (this.dsw.aBL() == 1) {
                Vr();
                Vd();
            } else if (this.dsw.hasMore()) {
                Vd();
            }
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void mF(String str) {
        Vr();
        showToast(str);
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void O(ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        boolean z = com.baidu.tbadk.core.util.v.z(arrayList);
        setHasMore(z ? 0 : 1);
        Vr();
        if (!z) {
            if (!this.dsw.aBV() && TbadkCoreApplication.getInst().isRecAppExist() && this.dsw.aBL() == 1) {
                this.drN.a(this, arrayList);
            }
            ArrayList<com.baidu.adp.widget.ListView.h> a2 = this.dsI.a(false, false, arrayList, this.dsh, false);
            if (a2 != null) {
                this.drN.ay(a2);
                this.dsl.a(a2, this.drN);
            }
            if (this.dsw != null) {
                com.baidu.tieba.frs.e.b.a(this.drN, this.dsw.aBR(), 2);
            }
        }
    }

    private void Vr() {
        if (awf() == 1 || this.dsI.by(this.drN.bwR())) {
            if (com.baidu.tbadk.core.util.v.y(this.drN.getThreadList()) > 3) {
                this.dsl.Wb();
            } else {
                this.dsl.axq();
            }
        } else if (com.baidu.tbadk.core.util.v.z(this.drN.getThreadList())) {
            this.dsl.Wd();
        } else {
            this.dsl.Wc();
        }
    }

    @Override // com.baidu.tieba.frs.mc.j
    public void Vd() {
        if (this.dsI != null) {
            this.dsI.a(this.dsd, this.forumId, this.drN);
        }
    }

    public void takePhoto() {
        if (!com.baidu.tbadk.core.util.ab.e(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.ak.b(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        if (this.dsr) {
            return null;
        }
        if (awx()) {
            return "a034";
        }
        return "a006";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (!awx()) {
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

    public void fP(boolean z) {
        if (this.dsC != null) {
            this.dsC.gl(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.dsD.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a gI(int i) {
        return this.dsD.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        this.dsM.b(bVar);
    }

    public boolean awx() {
        return this.drZ;
    }

    @Override // com.baidu.tieba.frs.ah
    public void VC() {
        if (this.dsl != null) {
            showFloatingView();
            this.dsl.getListView().scrollToPosition(0);
            this.dsl.startPullRefresh();
        }
    }

    public ForumWriteData awy() {
        if (this.drN == null || this.drN.bbH() == null) {
            return null;
        }
        ForumData bbH = this.drN.bbH();
        ForumWriteData forumWriteData = new ForumWriteData(bbH.getId(), bbH.getName(), bbH.getPrefixData(), this.drN.vj());
        forumWriteData.avatar = bbH.getImage_url();
        forumWriteData.forumLevel = bbH.getUser_level();
        forumWriteData.specialForumType = bbH.special_forum_type;
        forumWriteData.firstDir = bbH.getFirst_class();
        forumWriteData.secondDir = bbH.getSecond_class();
        UserData userData = this.drN.getUserData();
        forumWriteData.privateThread = userData != null ? userData.getPrivateThread() : 0;
        return forumWriteData;
    }

    @Override // com.baidu.tieba.frs.ah
    public void BQ() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.frs.ah
    public void setVideoThreadId(String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z) {
        super.showLoadingView(view, z);
        this.dsl.kW(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        super.hideLoadingView(view);
        this.dsl.kW(0);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        super.showNetRefreshView(view, str, z);
        this.dsl.kW(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshViewNoClick(View view, String str, boolean z) {
        super.showNetRefreshViewNoClick(view, str, z);
        this.dsl.kW(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        super.hideNetRefreshView(view);
        this.dsl.kW(0);
    }

    public void awz() {
        FrsTabViewController.b aCW;
        if (this.dsy != null && (aCW = this.dsy.aCW()) != null && aCW.fragment != null && (aCW.fragment instanceof aj)) {
            ((aj) aCW.fragment).avO();
        }
    }

    public void a(ContriInfo contriInfo) {
        if (this.dsX == null) {
            this.dsX = new com.baidu.tbadk.core.dialog.h(getTbPageContext());
            this.dsX.a(new h.a() { // from class: com.baidu.tieba.frs.FrsFragment.29
                @Override // com.baidu.tbadk.core.dialog.h.a
                public void aM(boolean z) {
                    if (z) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13061"));
                    }
                }
            });
        }
        this.dsX.a(contriInfo, -1L);
    }

    public void fQ(boolean z) {
        this.dsb = z;
    }

    public boolean awA() {
        return this.dsb;
    }

    public void mX(String str) {
        if (TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.util.ao.isEmpty(str)) {
            if (this.dsZ == null) {
                this.dsZ = new AddExperiencedModel(getTbPageContext());
                this.dsZ.a(this.dtc);
            }
            this.dsZ.co(this.forumId, str);
        }
    }

    public com.baidu.tieba.frs.entelechy.b awB() {
        return this.drX;
    }

    public boolean awC() {
        return (this.dsw != null && this.dsw.aBM() && com.baidu.tieba.frs.a.avq().avr()) ? false : true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.core.util.e.c
    public boolean videoNeedPreload() {
        if (this.drN != null) {
            return com.baidu.tbadk.util.aa.Na() && (this.drN.gTQ || com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("auto_play_video_frs", 0) == 1);
        }
        return super.videoNeedPreload();
    }
}
