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
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
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
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.atomData.PostSearchActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.coreExtra.messageCenter.NewsRemindMessage;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.c.a;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.g.i;
import com.baidu.tieba.frs.mc.FrsModelController;
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
/* loaded from: classes2.dex */
public class i extends BaseFragment implements BdListView.e, a.InterfaceC0056a, UserIconBox.b<com.baidu.adp.widget.ListView.h>, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, aj, am, ao, com.baidu.tieba.frs.loadmore.a, com.baidu.tieba.frs.mc.j, com.baidu.tieba.recapp.n {
    private com.baidu.tbadk.util.r bDw;
    private com.baidu.adp.lib.e.b<TbImageView> beZ;
    private com.baidu.tieba.frs.gametab.b ckg;
    private FrsModelController dEF;
    private com.baidu.tieba.frs.g.f dEG;
    private com.baidu.tieba.frs.g.i dEH;
    private com.baidu.tieba.frs.mc.f dEI;
    private com.baidu.tieba.frs.smartsort.b dEJ;
    private com.baidu.tieba.frs.mc.b dEK;
    private ap dEL;
    private com.baidu.tieba.frs.entelechy.b.b dEN;
    private com.baidu.tbadk.h.a dEO;
    private com.baidu.tieba.frs.g.a dEP;
    private com.baidu.tieba.frs.mc.d dEQ;
    private com.baidu.tieba.frs.mc.c dER;
    private com.baidu.tieba.frs.g.h dES;
    private com.baidu.tieba.frs.mc.a dET;
    private com.baidu.tieba.frs.live.a dEU;
    private j dEV;
    public com.baidu.tieba.frs.g.c dEW;
    private com.baidu.tieba.frs.mc.e dEX;
    private int dEY;
    private View.OnTouchListener dEZ;
    private com.baidu.tieba.frs.entelechy.b dEk;
    public bd dEp;
    private com.baidu.tieba.tbadkCore.data.e dEt;
    private VoiceManager dEw;
    private com.baidu.tieba.frs.view.b dFa;
    private com.baidu.tieba.frs.g.e dFb;
    private boolean dFc;
    private com.baidu.tieba.NEGFeedBack.a dFe;
    private com.baidu.tieba.ala.a dFf;
    private com.baidu.tbadk.core.dialog.i dFg;
    private AddExperiencedModel dFh;
    public View mRootView;
    public static boolean dEo = false;
    public static volatile long dEy = 0;
    public static volatile long dEz = 0;
    public static volatile int dEA = 0;
    public boolean dEl = false;
    private boolean dEm = false;
    private boolean dEn = false;
    public String dEq = null;
    public String mFrom = null;
    public int mFlag = 0;
    private boolean dEr = false;
    private String mThreadId = null;
    public String forumId = null;
    private int dEe = 0;
    private boolean dEs = false;
    private boolean dEu = false;
    private boolean dEv = false;
    private k dEx = null;
    public final bd cad = null;
    private com.baidu.tieba.tbadkCore.l dEb = new com.baidu.tieba.tbadkCore.l();
    public long dpJ = -1;
    public long bAJ = 0;
    public long bAB = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean dEB = false;
    private boolean dEC = false;
    public com.baidu.tbadk.k.d dED = null;
    private boolean dEE = true;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> dEM = new SparseArray<>();
    private boolean clp = true;
    private boolean dFd = false;
    private AddExperiencedModel.a dFi = new AddExperiencedModel.a() { // from class: com.baidu.tieba.frs.i.1
        @Override // com.baidu.tieba.share.AddExperiencedModel.a
        public void b(ContriInfo contriInfo) {
            if (contriInfo != null && contriInfo.isShowToast()) {
                i.this.a(contriInfo);
            }
        }
    };
    private HttpMessageListener dFj = new HttpMessageListener(CmdConfigHttp.CMD_PB_FLOOR_AGREE, true) { // from class: com.baidu.tieba.frs.i.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof PbFloorAgreeResponseMessage)) {
                PbFloorAgreeResponseMessage pbFloorAgreeResponseMessage = (PbFloorAgreeResponseMessage) httpResponsedMessage;
                if (pbFloorAgreeResponseMessage.getContriInfo() != null && pbFloorAgreeResponseMessage.getContriInfo().isShowToast()) {
                    i.this.a(pbFloorAgreeResponseMessage.getContriInfo());
                }
            }
        }
    };
    private final CustomMessageListener dFk = new CustomMessageListener(2016495) { // from class: com.baidu.tieba.frs.i.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof bd) {
                    com.baidu.tieba.frs.f.g.a(i.this.dEx, i.this.dEb, i.this.getForumId(), true, (bd) data);
                }
            }
        }
    };
    private CustomMessageListener dFl = new CustomMessageListener(2921005) { // from class: com.baidu.tieba.frs.i.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (i.this.dEb != null) {
                i.this.dEb.bvY();
                if (i.this.dEx != null) {
                    i.this.dEx.amD();
                }
            }
        }
    };
    private CustomMessageListener dFm = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.i.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 1) {
                    i.this.avd();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                }
            }
        }
    };
    private final an dFn = new an() { // from class: com.baidu.tieba.frs.i.32
        @Override // com.baidu.tieba.frs.an
        public void a(int i, int i2, at atVar, ArrayList<com.baidu.adp.widget.ListView.i> arrayList) {
            i.this.auW();
            if (i.this.dEN != null) {
                i.this.dEG.gs(i.this.dEN.nh(i));
            }
            d.a aVar = new d.a();
            if (atVar != null) {
                aVar.isSuccess = atVar.errCode == 0;
                aVar.errorCode = atVar.errCode;
                aVar.errorMsg = atVar.errMsg;
                if (aVar.isSuccess) {
                    if (com.baidu.tbadk.core.util.v.E(arrayList)) {
                        i.this.dEx.XQ();
                    } else if (atVar.hasMore) {
                        if (com.baidu.tbadk.core.util.v.D(i.this.dEb.getThreadList()) > 3) {
                            i.this.dEx.XO();
                        } else {
                            i.this.dEx.avZ();
                        }
                    } else if (atVar.dHJ) {
                        i.this.dEx.XP();
                    } else {
                        i.this.dEx.XQ();
                    }
                }
            } else {
                atVar = new at();
                atVar.pn = 1;
                atVar.hasMore = false;
                atVar.dHJ = false;
            }
            if (i == 1) {
                i.this.dEE = true;
                i.this.dFx.a(i.this.dEF.getType(), false, aVar);
            } else {
                i.this.a(aVar);
                if (i.this.dEF.ayV() != null) {
                    i.this.dEb = i.this.dEF.ayV();
                }
                i.this.avf();
            }
            if (i.this.dFF != null) {
                i.this.dFF.a(i, i2, atVar, arrayList);
            }
        }
    };
    private i.b dFo = new i.b() { // from class: com.baidu.tieba.frs.i.33
        @Override // com.baidu.tieba.frs.g.i.b
        public void hT(int i) {
            if (i != 1) {
                com.baidu.tieba.card.r.alt().eO(false);
            }
            i.this.avi();
            com.baidu.tieba.frs.e.c.dUq.dUh = i;
            com.baidu.tieba.frs.e.c.dUq.dUi = -1;
        }
    };
    private CustomMessageListener dFp = new CustomMessageListener(2001606) { // from class: com.baidu.tieba.frs.i.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                i.this.dEH.nV(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    };
    private CustomMessageListener dFq = new CustomMessageListener(2001607) { // from class: com.baidu.tieba.frs.i.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && ((Integer) customResponsedMessage.getData()).intValue() == 51 && i.this.dEb != null) {
                com.baidu.tieba.frs.f.i.a(i.this.dEb, i.this.getPageContext());
            }
        }
    };
    private final CustomMessageListener dFr = new CustomMessageListener(2003019) { // from class: com.baidu.tieba.frs.i.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                i.this.dEH.nT(49);
            }
        }
    };
    private final CustomMessageListener dFs = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.frs.i.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && i.this.dEb != null && i.this.dEb.bas() != null) {
                SignData signData = (SignData) customResponsedMessage.getData();
                int user_level = i.this.dEb.bas().getUser_level();
                if (signData.forumId != null && signData.forumId.equals(i.this.dEb.bas().getId())) {
                    i.this.dEb.d(signData);
                    i.this.dEG.g(i.this.dEb);
                    if (i.this.dEG.aAq()) {
                        i = i.this.dEb.bas().getUser_level();
                        if (user_level >= i) {
                            i++;
                        }
                    } else {
                        i = user_level;
                    }
                    TbadkCoreApplication.getInst().addSignedForum(i.this.dEb.bas().getName(), signData.sign_bonus_point, i);
                }
            }
        }
    };
    private final CustomMessageListener dFt = new CustomMessageListener(2001352) { // from class: com.baidu.tieba.frs.i.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.r) && i.this.dEb != null) {
                i.this.dEb.c((com.baidu.tieba.tbadkCore.r) customResponsedMessage.getData());
                i.this.dEG.f(i.this.dEb);
                i.this.dEH.a(i.this.dEb, i.this.dEF.azx());
            }
        }
    };
    private final AntiHelper.a dFu = new AntiHelper.a() { // from class: com.baidu.tieba.frs.i.5
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12536").s("obj_locate", aq.a.aXK));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12535").s("obj_locate", aq.a.aXK));
        }
    };
    private CustomMessageListener cht = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.frs.i.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(i.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().biU != null) {
                        if (AntiHelper.a(i.this.getActivity(), updateAttentionMessage.getData().biU, i.this.dFu) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12534").s("obj_locate", aq.a.aXK));
                        }
                    } else if (updateAttentionMessage.getData().apP && updateAttentionMessage.getData().isAttention) {
                        com.baidu.adp.lib.util.l.showToast(i.this.getPageContext().getPageActivity(), d.j.attention_success);
                    }
                }
            }
        }
    };
    private CustomMessageListener dFv = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.frs.i.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                i.this.dEx.c((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener dFw = new CustomMessageListener(2001626) { // from class: com.baidu.tieba.frs.i.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewsRemindMessage newsRemindMessage;
            if (customResponsedMessage != null && (customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626 && (newsRemindMessage = (NewsRemindMessage) customResponsedMessage) != null) {
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (i.this.dEx != null) {
                    i.this.dEx.E(notificationCount, z);
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.n dFx = new com.baidu.tieba.tbadkCore.n() { // from class: com.baidu.tieba.frs.i.9
        private long startTime = 0;

        @Override // com.baidu.tieba.tbadkCore.n
        public void mQ(int i) {
            this.startTime = System.nanoTime();
            if (i.this.dEx != null) {
                switch (i) {
                    case 1:
                    case 2:
                        i.this.dEx.avN();
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
            if (i.this.clp) {
                i.this.clp = false;
                com.baidu.tieba.frs.f.g.a(i.this.dEx, i.this.dEb, i.this.getForumId(), false, null);
            }
            i.this.auW();
            i.this.dEB = true;
            if (aVar != null && aVar.isSuccess) {
                i.this.dEx.avW().gd(com.baidu.tbadk.core.util.ao.De().Dg());
                i.dEy = 0L;
                i.dEz = 0L;
                i.dEA = 0;
            } else {
                i.dEA = 1;
            }
            if (!i.this.dEF.azB() && (i == 3 || i == 6)) {
                i.this.dER.resetData();
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i.this.dEF.ayV() != null) {
                i.this.dEb = i.this.dEF.ayV();
            }
            if (i == 7) {
                i.this.mO(i.this.dEb.bvn());
                return;
            }
            if (i.this.dEb.yA() != null) {
                i.this.setHasMore(i.this.dEb.yA().yw());
            }
            i.this.auX();
            if (i == 4) {
                if (!i.this.dEF.azB() && TbadkCoreApplication.getInst().isRecAppExist() && i.this.dEF.azr() == 1) {
                    i.this.dEb.a(i.this);
                }
                ArrayList<com.baidu.adp.widget.ListView.i> a2 = i.this.dER.a(false, false, i.this.dEb.getThreadList(), i.this.dEt);
                if (a2 != null) {
                    i.this.dEb.au(a2);
                    i.this.dEb.bvN();
                    i.this.dEx.a(a2, i.this.dEb);
                }
                if (i.this.dEF != null) {
                    com.baidu.tieba.frs.e.b.a(i.this.dEb, i.this.dEF.azx(), 2);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    i.this.dEx.avN();
                    break;
                case 2:
                    i.this.dEx.avN();
                    break;
                case 3:
                case 6:
                    if (i.this.dEb != null) {
                        i.this.dEb.bvL();
                    }
                    if (i.this.dEW != null) {
                        i.this.dEW.refresh();
                        break;
                    }
                    break;
            }
            i.this.auY();
            if (aVar == null || aVar.errorCode == 0) {
                if (i.this.dEb != null) {
                    i.this.x(false, i == 5);
                    i.this.dEx.mU(i);
                    i.dEy = (System.nanoTime() - this.startTime) / 1000000;
                    if (aVar != null) {
                        i.dEz = aVar.gXJ;
                    }
                } else {
                    return;
                }
            } else if (i.this.dEb == null || com.baidu.tbadk.core.util.v.E(i.this.dEb.getThreadList())) {
                i.this.a(aVar);
            } else if (aVar.gXI) {
                i.this.showToast(i.this.getPageContext().getResources().getString(d.j.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
            }
            if (i.this.dEb.buT() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11384"));
            }
            if (i.this.dpJ > -1 && !i.this.dFd) {
                com.baidu.tieba.frs.f.g.a(i.this.dEF, i.this.dpJ);
                i.this.dpJ = -1L;
                i.this.dFd = true;
            }
            if (i.this.dEu && i.this.dEH.nT(49)) {
                i.this.dEu = false;
            }
            i.this.bAJ = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void b(com.baidu.tieba.tbadkCore.i iVar) {
            if (iVar != null) {
                if ("normal_page".equals(i.this.dEF.azn()) || "frs_page".equals(i.this.dEF.azn()) || "book_page".equals(i.this.dEF.azn())) {
                    i.this.a(iVar);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001615, iVar));
                }
            }
        }
    };
    private final CustomMessageListener dFy = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.frs.i.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.h) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                i.this.dEb.a((com.baidu.tbadk.data.h) customResponsedMessage.getData());
                i.this.dEx.avW().notifyDataSetChanged();
            }
        }
    };
    private final CustomMessageListener mMemListener = new CustomMessageListener(2001194) { // from class: com.baidu.tieba.frs.i.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && i.this.dEb != null && (userData = i.this.dEb.getUserData()) != null) {
                userData.setIsMem(num.intValue());
                if (num.intValue() != 0) {
                    i.this.dEG.f(num);
                }
            }
        }
    };
    private final com.baidu.tieba.frs.mc.i dFz = new com.baidu.tieba.frs.mc.i() { // from class: com.baidu.tieba.frs.i.15
        @Override // com.baidu.tieba.frs.mc.i
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.i> arrayList, boolean z3) {
            if (i.this.dEJ != null && i.this.dEF != null && i.this.dEF.azB() && z && !z2 && !z3) {
                i.this.dEJ.nJ(i2);
            }
        }
    };
    public final View.OnTouchListener bDx = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.i.16
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (i.this.dEZ != null) {
                i.this.dEZ.onTouch(view, motionEvent);
            }
            if (i.this.dEL != null && i.this.dEL.awq() != null) {
                i.this.dEL.awq().onTouchEvent(motionEvent);
            }
            if (i.this.ckg != null) {
                i.this.ckg.f(view, motionEvent);
            }
            if (i.this.dEG != null) {
                i.this.dEG.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private final CustomMessageListener dFA = new CustomMessageListener(2004507) { // from class: com.baidu.tieba.frs.i.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "photolive_hostLevel", -1) != -1 && i.this.dEb.bas() != null) {
                i.this.dEb.bas().setCanAddPhotoLivePost(true);
            }
        }
    };
    private final CustomMessageListener dFB = new CustomMessageListener(2016493) { // from class: com.baidu.tieba.frs.i.18
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.frs.i */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11455").ab("obj_locate", "frs"));
                    com.baidu.tbadk.core.util.aw.Du().c(i.this.getPageContext(), new String[]{str});
                }
            }
        }
    };
    public final View.OnClickListener dFC = new View.OnClickListener() { // from class: com.baidu.tieba.frs.i.22
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (i.this.dEx == null || view != i.this.dEx.avK() || i.this.getActivity() == null) {
                if (i.this.dEb != null && i.this.dEb.bas() != null && i.this.dEx != null && view == i.this.dEx.avR()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12402").ab(ImageViewerConfig.FORUM_ID, i.this.dEb.bas().getId()).ab("uid", TbadkCoreApplication.getCurrentAccount()).ab(ImageViewerConfig.FORUM_NAME, i.this.dEb.bas().getName()));
                    if (!StringUtils.isNull(i.this.dEb.bas().getName())) {
                        i.this.sendMessage(new CustomMessage(2002001, new PostSearchActivityConfig(i.this.getPageContext().getPageActivity(), i.this.dEb.bas().getName(), i.this.dEb.bas().getId())));
                        return;
                    }
                    return;
                }
                if (view.getId() == d.g.game_activity_egg_layout && com.baidu.adp.lib.util.l.pa()) {
                    TiebaStatic.log("c10853");
                    if (i.this.dEx.avT()) {
                        i.this.dEx.avU();
                    } else {
                        String activityUrl = i.this.dEb.bas().getYuleData().AN().getActivityUrl();
                        if (!StringUtils.isNull(activityUrl)) {
                            com.baidu.tbadk.browser.b.S(i.this.getPageContext().getPageActivity(), activityUrl);
                        }
                    }
                }
                if (view == i.this.dEx.awa() && i.this.dEF != null && i.this.dEF.hasMore()) {
                    i.this.dEx.XO();
                    i.this.WO();
                }
                if (view != null && view == i.this.dEx.avS() && ay.ba(i.this.getContext())) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12924").s("obj_locate", 2));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(i.this.getContext())));
                    return;
                }
                return;
            }
            i.this.getActivity().finish();
        }
    };
    private final RecyclerView.OnScrollListener Sh = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.i.24
        private int dFI = 0;
        private int bZI = 0;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (i.this.dEP != null) {
                i.this.dEP.azX();
            }
            this.dFI = 0;
            this.bZI = 0;
            if (recyclerView != null && (recyclerView instanceof com.baidu.adp.widget.ListView.h)) {
                this.dFI = ((com.baidu.adp.widget.ListView.h) recyclerView).getFirstVisiblePosition();
                this.bZI = ((com.baidu.adp.widget.ListView.h) recyclerView).getLastVisiblePosition();
            }
            if (i.this.dFb != null) {
                i.this.dFb.b(recyclerView, this.dFI, this.bZI);
            }
            if (i.this.dEb != null && i.this.dEx != null && i.this.dEx.avW() != null) {
                i.this.dEx.bv(this.dFI, this.bZI);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i.this.dEG != null) {
                i.this.dEG.setScrollState(i);
            }
            if ((i == 2 || i == 1) && !i.this.dEC) {
                i.this.dEC = true;
                i.this.dEx.avY();
            }
            if (i.this.dED == null && !i.this.avn()) {
                i.this.dED = new com.baidu.tbadk.k.d();
                i.this.dED.ij(1000);
            }
            if (i == 0) {
                com.baidu.tieba.card.r.alt().eO(true);
                i.this.dEx.bu(this.dFI, this.bZI);
            }
            if (i.this.dFb != null) {
                i.this.dFb.onScrollStateChanged(recyclerView, i);
            }
            if (i.this.dED != null) {
                i.this.dED.Od();
            }
            if (i == 0) {
                com.baidu.tieba.frs.f.g.a(i.this.dEx, i.this.dEb, i.this.getForumId(), false, null);
            }
            if (i.this.dEH != null && i == 1) {
                i.this.dEH.aAy();
            }
        }
    };
    private final b dFD = new b() { // from class: com.baidu.tieba.frs.i.25
        @Override // com.baidu.tieba.frs.b
        public void a(int i, int i2, View view, View view2, bd bdVar) {
            if (i != i.this.dEx.avW().axp()) {
                if (i != i.this.dEx.avW().axq()) {
                    if (i != i.this.dEx.avW().axs()) {
                        if (i != i.this.dEx.avW().awh()) {
                            if (i == i.this.dEx.avW().axr() && i.this.dEb != null && i.this.dEb.getUserData() != null && i.this.dEb.getUserData().isBawu()) {
                                final String bvl = i.this.dEb.bvl();
                                if (!com.baidu.tbadk.core.util.am.isEmpty(bvl) && i.this.dEb.bas() != null) {
                                    com.baidu.tieba.c.a.a(i.this.getPageContext(), i.this.dEb.bas().getId(), i.this.dEb.bas().getName(), new a.InterfaceC0135a() { // from class: com.baidu.tieba.frs.i.25.1
                                        @Override // com.baidu.tieba.c.a.InterfaceC0135a
                                        public void akN() {
                                            com.baidu.tbadk.browser.b.R(i.this.getPageContext().getPageActivity(), bvl);
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10502").ab(ImageViewerConfig.FORUM_ID, i.this.dEb.bas().getId()).ab("uid", i.this.dEb.getUserData().getUserId()));
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        i.this.dEp = bdVar;
                        com.baidu.tieba.frs.f.h.a(i.this, i.this.dEp);
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10179").ab(ImageViewerConfig.FORUM_ID, i.this.getForumId()));
                        return;
                    }
                    com.baidu.tieba.frs.f.h.z(i.this);
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak(i == i.this.dEx.avW().axs() ? "c10177" : "c10244").ab(ImageViewerConfig.FORUM_ID, i.this.getForumId()));
                } else if (ay.ba(i.this.getPageContext().getPageActivity())) {
                    TiebaStatic.log("my_service_ck");
                    if (i.this.dEb != null && i.this.dEb.bas() != null) {
                        ForumData bas = i.this.dEb.bas();
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(i.this.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(bas.getId(), 0L), bas.getName(), bas.getImage_url(), 0)));
                    }
                }
            } else if (ay.ba(i.this.getActivity())) {
                TiebaStatic.log("forum_fortune_click");
                com.baidu.tieba.frs.f.h.a(i.this.getPageContext(), i.this.dEb);
            }
        }
    };
    private final NoNetworkView.a dCE = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.i.26
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bu(boolean z) {
            if (i.this.dEF.azr() == 1 && z && !i.this.dEx.avm()) {
                if (i.this.dEb == null || com.baidu.tbadk.core.util.v.E(i.this.dEb.getThreadList())) {
                    i.this.hideNetRefreshView(i.this.dEx.afu());
                    i.this.showLoadingView(i.this.dEx.afu(), true);
                    i.this.dEx.fQ(false);
                    i.this.refresh();
                    return;
                }
                i.this.dEx.avN();
            }
        }
    };
    private final CustomMessageListener bjx = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.i.27
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                com.baidu.tieba.frs.f.c.a(customResponsedMessage, i.this.dEx, i.this.dEb);
            }
        }
    };
    private com.baidu.adp.widget.ListView.o dFE = new a();
    private an dFF = new an() { // from class: com.baidu.tieba.frs.i.28
        @Override // com.baidu.tieba.frs.an
        public void a(int i, int i2, at atVar, ArrayList<com.baidu.adp.widget.ListView.i> arrayList) {
            com.baidu.adp.lib.g.e.ns().post(new Runnable() { // from class: com.baidu.tieba.frs.i.28.1
                @Override // java.lang.Runnable
                public void run() {
                    if (i.this.dEx != null && i.this.dEx.amu()) {
                        i.this.WO();
                    }
                }
            });
        }
    };
    private CustomMessageListener dFG = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.frs.i.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    i.this.dFc = true;
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.frs.loadmore.a
    public /* bridge */ /* synthetic */ com.baidu.adp.base.e getPageContext() {
        return super.getPageContext();
    }

    public com.baidu.tieba.frs.entelechy.b.b auK() {
        return this.dEN;
    }

    public com.baidu.adp.widget.ListView.o auL() {
        return this.dFE;
    }

    public com.baidu.tieba.frs.mc.d auM() {
        return this.dEQ;
    }

    public com.baidu.tieba.frs.smartsort.b auN() {
        return this.dEJ;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public FrsModelController auO() {
        return this.dEF;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public com.baidu.tieba.frs.mc.c auP() {
        return this.dER;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public com.baidu.tieba.frs.g.f auQ() {
        return this.dEG;
    }

    public com.baidu.tieba.frs.g.k auR() {
        return this.dEH;
    }

    public ap auS() {
        return this.dEL;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public k auT() {
        return this.dEx;
    }

    @Override // com.baidu.tieba.frs.ao
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.ao, com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.dEq;
    }

    public void setForumName(String str) {
        this.dEq = str;
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
        if (this.dER == null) {
            return 1;
        }
        return this.dER.getPn();
    }

    public int getPn() {
        if (this.dER == null) {
            return 1;
        }
        return this.dER.getPn();
    }

    public void setPn(int i) {
        if (this.dER != null) {
            this.dER.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.dER != null) {
            this.dER.setHasMore(i);
        }
    }

    public int auU() {
        if (this.dER == null) {
            return -1;
        }
        return this.dER.auU();
    }

    public boolean auV() {
        return this.dEv;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d.a aVar) {
        if (aVar == null) {
            String string = TbadkCoreApplication.getInst().getString(d.j.error_unkown_try_again);
            this.dEx.avH();
            showNetRefreshView(this.dEx.afu(), string, true);
        } else if (340001 == aVar.errorCode) {
            a(aVar, this.dEb.buQ());
        } else {
            if (com.baidu.tbadk.core.util.v.E(this.dEb.getThreadList())) {
                b(aVar);
            }
            if (avn()) {
                setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.t(TbadkCoreApplication.getInst(), d.e.ds280));
            } else {
                setNetRefreshViewEmotionDefMarginTop();
            }
        }
    }

    public void a(View view, String str, boolean z, List<RecmForumInfo> list) {
        this.dEx.avH();
        this.dEx.mS(8);
        if (this.dFa == null) {
            this.dFa = new com.baidu.tieba.frs.view.b(getPageContext(), getNetRefreshListener());
        }
        this.dFa.gW(str);
        this.dFa.by(list);
        this.dFa.j(view, z);
    }

    private void a(d.a aVar, List<RecmForumInfo> list) {
        if (this.dEx != null) {
            this.dEx.avH();
            this.dEx.setTitle(this.dEq);
            a(this.dEx.afu(), aVar.errorMsg, true, list);
        }
    }

    private void b(d.a aVar) {
        this.dEx.avH();
        if (aVar.gXI) {
            showNetRefreshView(this.dEx.afu(), TbadkCoreApplication.getInst().getString(d.j.net_error_text, new Object[]{aVar.errorMsg, Integer.valueOf(aVar.errorCode)}), true);
        } else {
            showNetRefreshView(this.dEx.afu(), aVar.errorMsg, true);
        }
    }

    public void auW() {
        hideLoadingView(this.dEx.afu());
        if (!this.dEx.avm()) {
            this.dEx.fR(false);
        } else {
            this.dEx.fR(true);
        }
        if (this.dEx.avF() instanceof com.baidu.tieba.frs.tab.a) {
            ((com.baidu.tieba.frs.tab.a) this.dEx.avF()).azT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auX() {
        if (auU() == 0 && com.baidu.tbadk.core.util.v.E(this.dEb.buZ())) {
            if (com.baidu.tbadk.core.util.v.E(this.dEb.getThreadList())) {
                this.dEx.XQ();
            } else {
                this.dEx.XP();
            }
        } else if (com.baidu.tbadk.core.util.v.D(this.dEb.getThreadList()) > 3) {
            this.dEx.XO();
        } else {
            this.dEx.avZ();
        }
    }

    public void a(ErrorData errorData) {
        auW();
        this.dEx.avN();
        d.a azo = this.dEF.azo();
        boolean E = com.baidu.tbadk.core.util.v.E(this.dEb.getThreadList());
        if (azo != null && E) {
            if (E) {
                if (this.dEF.azp() != 0) {
                    this.dEF.azv();
                    this.dEx.avN();
                } else {
                    a(azo);
                }
                this.dEx.y(this.dEb.bwf(), false);
                return;
            } else if (azo.gXI) {
                this.dEx.y(true, false);
                showToast(getPageContext().getResources().getString(d.j.net_error_text, azo.errorMsg, Integer.valueOf(azo.errorCode)));
                return;
            } else {
                return;
            }
        }
        a(azo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auY() {
        if (this.dEb == null || this.dEb.bas() != null) {
            this.dEx.avV();
        } else if (this.dEb.bas().getYuleData() != null && this.dEb.bas().getYuleData().AM()) {
            TiebaStatic.log("c10852");
            this.dEx.a(this.dEb.bas().getYuleData().AN());
        } else {
            this.dEx.avV();
        }
    }

    private void w(boolean z, boolean z2) {
        if (this.dEF != null && this.dEb != null && this.dEx != null && z) {
            if (!this.dEF.azB() && this.dEF.azr() == 1) {
                if (!this.dEF.azz()) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        this.dEb.bvW();
                        this.dEb.bvP();
                    }
                    this.dEb.bvU();
                    this.dEb.bvV();
                }
                boolean z3 = false;
                if (this.dEx.avW().k(com.baidu.tieba.card.data.o.daC)) {
                    z3 = this.dEb.bvZ();
                }
                if (!z3) {
                    this.dEb.bvX();
                }
                if (TbadkCoreApplication.getInst().isRecAppExist()) {
                    this.dEb.a(this);
                }
                if (!this.dEx.avW().k(bd.aOy)) {
                    this.dEb.bvM();
                }
                this.dEb.bwa();
            }
            if (!this.dEx.avW().k(bd.aOy)) {
                this.dEb.bvT();
                this.dEb.bvR();
            } else {
                this.dEb.bvS();
                this.dEb.bvQ();
            }
            this.dEb.bvN();
            this.dEb.bvK();
            if (this.dEx.avW().k(com.baidu.tieba.g.b.eam)) {
                this.dEb.mF(z2);
            }
            if (TbadkCoreApplication.isLogin() && (!this.dEF.azB() || this.dEF.isNetFirstLoad)) {
                this.dEb.bwb();
            }
            this.dEb.bwd();
        }
    }

    public boolean auZ() {
        if (this.dEG != null && this.dEF != null) {
            this.dEG.a(this.dEF.azn(), this.dEb);
        }
        boolean z = false;
        if (this.dEb != null) {
            z = this.dEb.bwg();
        }
        avb();
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mO(int i) {
        aq aqVar = null;
        auZ();
        avi();
        try {
            if (this.dEb != null) {
                this.dEx.a((ArrayList<com.baidu.adp.widget.ListView.i>) null, this.dEb);
                this.dEG.nO(1);
                this.dEx.avQ();
                this.dEH.a(this.dEb, this.dEF.azx());
                com.baidu.tieba.frs.tab.b nU = this.dEH.nU(this.dEb.bvn());
                if (nU != null && !TextUtils.isEmpty(nU.url)) {
                    aqVar = new aq();
                    aqVar.dHG = nU.url;
                    aqVar.stType = nU.name;
                }
                this.dEF.a(this.dEb.bvn(), 0, aqVar);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(boolean z, boolean z2) {
        try {
            if (this.dEb != null && this.dEH != null && this.dEF != null) {
                if (!this.dEx.avW().k(bd.aOy)) {
                    this.dEb.bvM();
                }
                boolean E = com.baidu.tbadk.core.util.v.E(this.dEb.bvA());
                this.dEx.fO(E);
                if (!E) {
                    if (this.dFb == null) {
                        this.dFb = new com.baidu.tieba.frs.g.e(this, (NoPressedRelativeLayout) this.mRootView);
                    }
                    if (this.ckg == null) {
                        this.ckg = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
                    }
                } else {
                    this.dFb = null;
                    this.ckg = null;
                }
                if (this.dEb.bas() != null) {
                    this.dEq = this.dEb.bas().getName();
                    this.forumId = this.dEb.bas().getId();
                }
                if (this.dEb.bwg()) {
                    this.dEH.a(this.dEb, this.dEF.azx());
                }
                if (z) {
                    w(true, z);
                } else {
                    w(this.dEE, z);
                }
                auZ();
                if (this.dEN != null) {
                    this.dEN.a(this.dEG, this.dEb);
                }
                if (this.dEb.yA() != null) {
                    setHasMore(this.dEb.yA().yw());
                }
                ArrayList<com.baidu.adp.widget.ListView.i> a2 = this.dER.a(z2, true, this.dEb.getThreadList(), null, z);
                if (a2 != null) {
                    this.dEb.au(a2);
                }
                this.dEb.bwc();
                if (this.dEF.azr() == 1) {
                    avf();
                    if (!z && this.dEF.getPn() == 1) {
                        ava();
                    }
                }
                this.dEe = this.dEb.azt();
                if (this.dEt != null) {
                    this.dEs = true;
                    this.dEt.vH(this.dEe);
                    com.baidu.tieba.frs.f.a.a(this, this.dEb.bas(), this.dEb.getThreadList(), this.dEs, getPn());
                }
                if (this.dEP != null) {
                    this.dEP.bS(this.dEH.aAv());
                }
                auW();
                this.dEx.avI();
                this.dEx.y(true, false);
                if (this.dEb.bas() != null) {
                    this.dEx.lI(this.dEb.bas().getWarningMsg());
                }
                if (this.dEb != null && this.dEb.bvD() != null && com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("frs_video_activity_guide", 0L) == 0) {
                    com.baidu.adp.lib.g.e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.i.10
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.dEx.awe();
                        }
                    }, 1000L);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2921326, this));
                this.dEx.avB();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void ava() {
        if (this.dEU == null) {
            this.dEU = new com.baidu.tieba.frs.live.a(this, com.baidu.adp.lib.g.b.h(this.forumId, 0));
        }
        this.dEU.aza();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.i iVar) {
        try {
            if (!this.dEB && iVar != null && this.dEb != null) {
                this.dEb.e(iVar);
                x(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void avb() {
        if (this.dEF != null) {
            lG(this.dEF.azn());
        } else {
            lG("normal_page");
        }
    }

    private void lG(String str) {
        fJ("frs_page".equals(str));
        if (this.dEN != null) {
            this.dEN.a(this.dEG, this.dEx, this.dEb);
        }
    }

    public void fJ(boolean z) {
        if (this.dES != null) {
            this.dES.c(this.dEx, z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(d.h.frs_activity, viewGroup, false);
            this.dEk = new com.baidu.tieba.frs.entelechy.b();
            this.dEN = this.dEk.awV();
            this.dEG = new com.baidu.tieba.frs.g.f(this, this.dEk, (FrsHeaderViewContainer) this.mRootView.findViewById(d.g.header_view_container));
            this.dEH = new com.baidu.tieba.frs.g.i(this, this.mRootView);
            this.dEH.a(this.dFo);
            Intent intent = getActivity().getIntent();
            if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                this.dEm = true;
            }
            this.dEx = new k(this, this.dFC, this.dEk, this.dEm, this.dEG);
            this.dEx.setHeaderViewHeight(this.dEY);
        } else {
            if (this.mRootView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            this.dEH.resetData();
            this.dEx.awd();
        }
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Intent intent = getActivity().getIntent();
        this.dpJ = System.currentTimeMillis();
        if (intent != null) {
            this.dEu = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.dpJ = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            K(intent);
        }
        this.beginTime = System.currentTimeMillis();
        this.bAB = this.beginTime - this.dpJ;
        this.dEt = new com.baidu.tieba.tbadkCore.data.e("frs", com.baidu.tieba.tbadkCore.data.e.hap);
        this.dEF = new FrsModelController(this, this.dFx);
        this.dEF.a(this.dFn);
        this.dEF.init();
        if (intent != null) {
            this.dEF.l(intent.getExtras());
        } else if (bundle != null) {
            this.dEF.l(bundle);
        } else {
            this.dEF.l(null);
        }
        if (intent != null) {
            this.dEG.o(intent.getExtras());
        } else if (bundle != null) {
            this.dEG.o(bundle);
        } else {
            this.dEG.o((Bundle) null);
        }
        this.dEw = getVoiceManager();
        this.dEV = new j(getPageContext(), this);
        initUI();
        initData(bundle);
        if (this.mFrom != null && this.mFrom.equals("from_tieba_kuang")) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12264").s("obj_type", 1).ab(ImageViewerConfig.FORUM_NAME, this.dEF.getForumName()));
            KuangFloatingViewController.getInstance().setNeedShowFloatingView(true);
            if (KuangFloatingViewController.getInstance().init()) {
                ((BaseFragmentActivity) getPageContext().getOrignalPage()).grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.frs.i.14
                    @Override // com.baidu.tbadk.core.e
                    public void aS(boolean z) {
                        if (z) {
                            KuangFloatingViewController.getInstance().showFloatingView();
                        }
                    }
                });
            }
        }
        if (!avn()) {
            this.dEL = new ap(getActivity(), this.dEx, this.dEG);
            this.dEL.fX(true);
        }
        this.dEw = getVoiceManager();
        if (this.dEw != null) {
            this.dEw.onCreate(getPageContext());
        }
        new com.baidu.tieba.frs.mc.g();
        this.dER = new com.baidu.tieba.frs.mc.c(this, this.dFz);
        this.dEJ = new com.baidu.tieba.frs.smartsort.b(this);
        this.dES = new com.baidu.tieba.frs.g.h(this);
        this.createTime = System.currentTimeMillis() - this.beginTime;
        this.dEP = new com.baidu.tieba.frs.g.a(getPageContext(), this.dEF.azy());
        this.dEK = new com.baidu.tieba.frs.mc.b(this);
        this.dEQ = new com.baidu.tieba.frs.mc.d(this);
        this.dEI = new com.baidu.tieba.frs.mc.f(this);
        this.dET = new com.baidu.tieba.frs.mc.a(this);
        this.dEW = new com.baidu.tieba.frs.g.c(this);
        this.dEX = new com.baidu.tieba.frs.mc.e(this, getUniqueId());
        this.dFe = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "frs");
        this.dFf = new com.baidu.tieba.ala.a(getPageContext());
        registerListener(this.cht);
        registerListener(this.mMemListener);
        registerListener(this.dFt);
        registerListener(this.dFA);
        registerListener(this.dFs);
        registerListener(this.dFy);
        registerListener(this.dFp);
        registerListener(this.dFq);
        registerListener(this.dFr);
        registerListener(this.dFk);
        registerListener(this.dFl);
        registerListener(this.dFG);
        registerListener(this.dFv);
        registerListener(this.dFm);
        registerListener(this.dFw);
        this.dFj.setTag(getPageContext().getUniqueId());
        registerListener(this.dFj);
        this.dEx.fQ(false);
        if (!avn()) {
            showLoadingView(this.dEx.afu(), true);
            this.dEF.G(3, true);
        }
        super.onActivityCreated(bundle);
    }

    @Override // com.baidu.tieba.frs.aj
    public void Xq() {
        if (isAdded() && this.clp && !isLoadingViewAttached()) {
            showLoadingView(this.dEx.afu(), true);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void Xr() {
        if (isAdded() && this.clp && isLoadingViewAttached()) {
            hideLoadingView(this.dEx.afu());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (avn()) {
            showLoadingView(this.dEx.afu(), true);
            this.dEx.mT(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.dEF.G(3, true);
            Ez().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void setHeaderViewHeight(int i) {
        this.dEY = i;
        if (this.dEx != null) {
            this.dEx.setHeaderViewHeight(this.dEY);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.s sVar) {
        if (sVar != null) {
            this.bDw = sVar.Pl();
            this.dEZ = sVar.Pm();
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void showFloatingView() {
        if (this.bDw != null) {
            this.bDw.cG(true);
        }
    }

    private void K(Intent intent) {
        if (intent != null) {
            if (!com.baidu.tieba.frs.f.e.a(this, getForumName(), "from", intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false)) && getActivity() != null) {
                getActivity().finish();
                return;
            }
        }
        if (intent != null && intent.getData() != null) {
            Uri data = intent.getData();
            this.dEq = data.getQueryParameter("name");
            this.mFrom = data.getQueryParameter("from");
            if (!StringUtils.isNull(this.dEq)) {
                intent.putExtra("name", this.dEq);
            }
            if (!StringUtils.isNull(this.mFrom)) {
                intent.putExtra("from", this.mFrom);
            }
            TiebaStatic.log("c10105");
        }
        if (StringUtils.isNull(this.dEq)) {
            this.dEq = com.baidu.tieba.frs.f.h.M(intent);
            if (!StringUtils.isNull(this.dEq)) {
                intent.putExtra("name", this.dEq);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.dEw = getVoiceManager();
        if (this.dEw != null) {
            this.dEw.onStart(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        Intent intent;
        registerListener(2001118, this.bjx);
        if (bundle != null) {
            this.dEq = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
            this.dEq = intent.getStringExtra("name");
            this.mFrom = intent.getStringExtra("from");
            this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
        }
        if (TextUtils.isEmpty(this.mFrom) || FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
        }
        if (this.mIsLogin) {
            registerListener(2001120, this.bjx);
        }
        this.dEG.o(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dFG);
        if (this.dEw != null) {
            this.dEw.onDestory(getPageContext());
        }
        this.dEw = null;
        com.baidu.tieba.card.r.alt().eO(false);
        if (this.dEb != null && this.dEb.bas() != null) {
            ae.awn().bF(com.baidu.adp.lib.g.b.c(this.dEb.bas().getId(), 0L));
        }
        if (this.dEU != null) {
            this.dEU.onDestory();
        }
        if (this.dEx != null) {
            com.baidu.tieba.frs.f.g.a(this.dEx, this.dEb, getForumId(), false, null);
            this.dEx.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.dED != null) {
                this.dED.onDestroy();
            }
            this.dEx.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.dEF.onActivityDestroy();
        this.dEG.onActivityDestroy();
        if (this.dEF != null) {
            this.dEF.Za();
        }
        if (this.dEL != null) {
            this.dEL.Pk();
        }
        if (this.dEO != null) {
            this.dEO.destory();
        }
        if (this.dEP != null) {
            this.dEP.destory();
        }
        if (this.dEJ != null) {
            this.dEJ.onDestroy();
        }
        if (this.dFb != null) {
            this.dFb.onDestory();
        }
        if (this.dET != null) {
            this.dET.onDestroy();
        }
        if (this.dFe != null) {
            this.dFe.onDestroy();
        }
        if (this.dFf != null) {
            this.dFf.onDestroy();
        }
        com.baidu.tieba.recapp.d.a.boS().boU();
        com.baidu.tieba.frs.f.i.azU();
        if (this.dEH != null) {
            this.dEH.a((i.b) null);
            this.dEH.aAy();
        }
        if (this.dFg != null) {
            this.dFg.onDestroy();
        }
        if (this.dFh != null) {
            this.dFh.onDestroy();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.dEq);
        bundle.putString("from", this.mFrom);
        this.dEF.onSaveInstanceState(bundle);
        if (this.dEw != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            this.dEw.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.dET != null) {
            this.dET.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dEx != null) {
            this.dEx.avN();
            this.dEx.onResume();
        }
        this.dEI.gp(true);
        this.dEE = true;
        if (dEo) {
            dEo = false;
            this.dEx.startPullRefresh();
            return;
        }
        if (this.dEw != null) {
            this.dEw.onResume(getPageContext());
        }
        this.dEx.fS(false);
        registerListener(this.dFB);
        if (this.dFc) {
            refresh(6);
            this.dFc = false;
        }
        if (KuangFloatingViewController.getInstance().init()) {
            ((BaseFragmentActivity) getPageContext().getOrignalPage()).grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.frs.i.19
                @Override // com.baidu.tbadk.core.e
                public void aS(boolean z) {
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

    public boolean avc() {
        Intent intent;
        if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
            return false;
        }
        return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
    }

    public void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.dEq = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.dEr = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.dEr) {
                avd();
            }
            if (this.mFrom != null && this.mFrom.equals("from_tieba_kuang")) {
                KuangFloatingViewController.getInstance().setNeedShowFloatingView(true);
                if (KuangFloatingViewController.getInstance().init()) {
                    ((BaseFragmentActivity) getPageContext().getOrignalPage()).grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.frs.i.20
                        @Override // com.baidu.tbadk.core.e
                        public void aS(boolean z) {
                            if (z) {
                                KuangFloatingViewController.getInstance().showFloatingView();
                            }
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avd() {
        this.dEx.startPullRefresh();
    }

    public void closeActivity() {
        com.baidu.tieba.frs.f.h.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.mFrom);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.dEx.setTitle(this.dEq);
        } else {
            this.dEx.setTitle("");
            this.mFlag = 1;
        }
        this.dEx.setOnAdapterItemClickListener(this.dFE);
        this.dEx.addOnScrollListener(this.Sh);
        this.dEx.h(this.dCE);
        this.dEx.avW().a(this.dFD);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dEx.onChangeSkinType(i);
        this.dEG.nN(i);
        this.dEH.onChangeSkinType(i);
        if (this.dFa != null) {
            this.dFa.onChangeSkinType();
        }
        if (this.dFg != null) {
            this.dFg.onChangeSkinType(i);
        }
    }

    public void mP(int i) {
        if (!this.mIsLogin) {
            if (this.dEb != null && this.dEb.yn() != null) {
                this.dEb.yn().setIfpost(1);
            }
            if (i == 0) {
                ay.aZ(getActivity());
            }
        } else if (this.dEb != null) {
            if (i == 0) {
                com.baidu.tieba.frs.f.i.b(this, 0);
            } else {
                this.dEx.avP();
            }
        }
    }

    public void refresh() {
        this.dEx.avL();
        refresh(3);
    }

    public void refresh(int i) {
        this.dEB = false;
        avi();
        if (this.dEx.avE() != null) {
            this.dEx.avE().aEa();
        }
        this.dEF.G(i, true);
    }

    private void ave() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.g.h.nt().e(new Runnable() { // from class: com.baidu.tieba.frs.i.21
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.sQ(i.this.dEq);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avf() {
        avi();
        try {
            if (this.dEb != null) {
                this.dEx.aik();
                this.dEx.fN(this.dEF.azs());
                if (!com.baidu.tieba.frs.g.f.i(this.dEb) || !com.baidu.tieba.frs.g.f.h(this.dEb)) {
                }
                if (this.dEb.bas() != null) {
                    this.dEq = this.dEb.bas().getName();
                    this.forumId = this.dEb.bas().getId();
                }
                if (this.dEb.yA() != null) {
                    setHasMore(this.dEb.yA().yw());
                }
                this.dEx.setTitle(this.dEq);
                this.dEx.setForumName(this.dEq);
                TbadkCoreApplication.getInst().setDefaultBubble(this.dEb.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.dEb.getUserData().getBimg_end_time());
                ave();
                avg();
                ArrayList<com.baidu.adp.widget.ListView.i> threadList = this.dEb.getThreadList();
                if (threadList != null) {
                    this.dEx.a(threadList, this.dEb);
                    com.baidu.tieba.frs.f.c.u(this.dEx);
                    this.dEG.nO(getPageNum());
                    this.dEG.f(this.dEb);
                    this.dEH.a(this.dEb, this.dEF.azx());
                    this.dEx.avQ();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void avg() {
        if (this.dEb != null) {
            if (this.dEb.baH() == 1) {
                this.dEx.avW().setFromCDN(true);
            } else {
                this.dEx.avW().setFromCDN(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.dEI.gp(false);
        this.dEE = false;
        this.dEx.onPause();
        if (this.dEw != null) {
            this.dEw.onPause(getPageContext());
        }
        this.dEx.fS(true);
        if (this.dEP != null) {
            this.dEP.azX();
        }
        MessageManager.getInstance().unRegisterListener(this.dFB);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.r.alt().eO(false);
        if (this.dEb != null && this.dEb.bas() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            com.baidu.tbadk.distribute.a.KM().a(getPageContext().getPageActivity(), "frs", this.dEb.bas().getId(), 0L);
        }
        if (this.dEw != null) {
            this.dEw.onStop(getPageContext());
        }
        if (Ez() != null) {
            Ez().getRecycledViewPool().clear();
        }
        this.dEG.onActivityStop();
        com.baidu.tbadk.util.t.Po();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && this.dEG != null) {
            this.dEG.gr(isPrimary());
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || this.dEx == null) {
            return false;
        }
        return this.dEx.avM();
    }

    @Override // com.baidu.tieba.recapp.n
    public TbPageContext<?> akO() {
        return getPageContext();
    }

    @Override // com.baidu.tieba.recapp.n
    public void a(AdvertAppInfo advertAppInfo, String str) {
        com.baidu.tbadk.distribute.a.KM().a(advertAppInfo, this.forumId, 0L, "FRS", str, getPn());
    }

    @Override // com.baidu.tieba.recapp.n
    public void avh() {
        auO().avh();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dEw == null) {
            this.dEw = VoiceManager.instance();
        }
        return this.dEw;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public com.baidu.adp.widget.ListView.h Ez() {
        if (this.dEx == null) {
            return null;
        }
        return this.dEx.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void avi() {
        if (this.dEw != null) {
            this.dEw.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> EA() {
        if (this.beZ == null) {
            this.beZ = UserIconBox.w(getPageContext().getPageActivity(), 8);
        }
        return this.beZ;
    }

    public void avj() {
        if (getFragmentActivity() != null && getFragmentActivity().getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.a(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.l onGetPreLoadListView() {
        return Ez().getPreLoadHandle();
    }

    @Override // com.baidu.tieba.frs.am
    public NavigationBar avk() {
        if (this.dEx == null) {
            return null;
        }
        return this.dEx.avk();
    }

    /* loaded from: classes2.dex */
    private final class a implements com.baidu.adp.widget.ListView.o {
        private a() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v8, resolved type: com.baidu.tieba.frs.i */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.o
        public void a(View view, com.baidu.adp.widget.ListView.i iVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            boolean z;
            if (bdUniqueId != null) {
                if (bdUniqueId == r.dGT) {
                    if (i.this.dEx != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11752").ab(ImageViewerConfig.FORUM_ID, i.this.forumId).ab("obj_locate", "1"));
                        i.this.dEx.startPullRefresh();
                    }
                } else if (iVar != null && (iVar instanceof bd)) {
                    bd bdVar = (bd) iVar;
                    if (bdVar.zY() == null || bdVar.zY().getGroup_id() == 0 || ay.ba(i.this.getActivity())) {
                        if (bdVar.zR() != 1 || ay.ba(i.this.getActivity())) {
                            if (bdVar.zB() != null) {
                                if (ay.ba(i.this.getActivity())) {
                                    String postUrl = bdVar.zB().getPostUrl();
                                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.pa()) {
                                        com.baidu.tbadk.browser.b.S(i.this.getActivity(), postUrl);
                                    }
                                }
                            } else if (bdVar.Ag() != null) {
                                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                    ay.aZ(i.this.getPageContext().getPageActivity());
                                    return;
                                }
                                com.baidu.tbadk.core.data.m Ag = bdVar.Ag();
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(i.this.getPageContext().getPageActivity(), Ag.getCartoonId(), Ag.getChapterId(), 2)));
                            } else {
                                com.baidu.tieba.tbadkCore.util.e readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                                if (readThreadHistory != null && !readThreadHistory.sW(bdVar.getId())) {
                                    readThreadHistory.sV(bdVar.getId());
                                }
                                final String zv = bdVar.zv();
                                if (zv == null || zv.equals("")) {
                                    z = false;
                                } else {
                                    new Thread(new Runnable() { // from class: com.baidu.tieba.frs.i.a.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(zv);
                                            xVar.Cz().Dw().mIsNeedAddCommenParam = false;
                                            xVar.Cz().Dw().mIsUseCurrentBDUSS = false;
                                            xVar.Cc();
                                        }
                                    }).start();
                                    z = true;
                                }
                                String tid = bdVar.getTid();
                                if (tid == null) {
                                    tid = "";
                                }
                                if (bdVar.zi() == 2 && !tid.startsWith("pb:")) {
                                    com.baidu.tbadk.core.util.aw.Du().c(i.this.getPageContext(), new String[]{tid, "", null});
                                } else if (bdVar.getThreadType() == 33 || (bdVar instanceof com.baidu.tbadk.core.data.as)) {
                                    String str = bdVar.getThreadType() == 33 ? "c10245" : "c10180";
                                    if (i.this.dEF.azr() == 5) {
                                        str = "c10387";
                                    }
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak(str).ab(ImageViewerConfig.FORUM_ID, i.this.forumId));
                                    com.baidu.tieba.frs.f.h.b(i.this, bdVar);
                                    if (i.this.dEb != null && i.this.dEb.bas() != null) {
                                        com.baidu.tieba.frs.e.a aVar = new com.baidu.tieba.frs.e.a();
                                        aVar.dUe = i.this.dEb.gYp == 1;
                                        aVar.dUg = i.this.dEb.bas().getId();
                                        aVar.dUf = i.this.auO().azx();
                                        if (com.baidu.tieba.frs.e.c.dUq != null) {
                                            aVar.dUh = com.baidu.tieba.frs.e.c.dUq.dUh;
                                            aVar.dUi = com.baidu.tieba.frs.e.c.dUq.dUi;
                                        }
                                        com.baidu.tieba.frs.e.b.azR().a(aVar, bdVar, 1);
                                    }
                                } else {
                                    if (tid.startsWith("pb:")) {
                                        bdVar.setId(tid.substring(3));
                                    }
                                    if (bdUniqueId.getId() == bd.aPI.getId()) {
                                        com.baidu.tieba.frs.f.g.a(bdVar.yV());
                                    } else if (bdUniqueId.getId() == bd.aOB.getId()) {
                                        com.baidu.tbadk.core.util.ak akVar = new com.baidu.tbadk.core.util.ak("c12940");
                                        akVar.ab("obj_type", "2");
                                        akVar.ab("tid", bdVar.getTid());
                                        TiebaStatic.log(akVar);
                                    }
                                    com.baidu.tieba.frs.f.h.a(i.this, bdVar, i, z);
                                    com.baidu.tieba.frs.f.g.a(i.this, i.this.dEb, bdVar);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.l.pa()) {
            hideNetRefreshView(this.dEx.afu());
            showLoadingView(this.dEx.afu(), true);
            this.dEx.fQ(false);
            this.dEF.G(3, true);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public com.baidu.tieba.tbadkCore.l avl() {
        return this.dEb;
    }

    public boolean avm() {
        return this.dEx.avm();
    }

    public void aW(Object obj) {
        if (this.dEK != null && this.dEK.dSS != null) {
            this.dEK.dSS.ak(obj);
        }
    }

    public void aX(Object obj) {
        if (this.dEK != null && this.dEK.dST != null) {
            this.dEK.dST.ak(obj);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.l.pa()) {
            this.dEx.XQ();
        } else if (this.dEF.azr() == 1) {
            Xc();
            WO();
        } else if (this.dEF.hasMore()) {
            WO();
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void lu(String str) {
        Xc();
        showToast(str);
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void J(ArrayList<com.baidu.adp.widget.ListView.i> arrayList) {
        Xc();
        if (!com.baidu.tbadk.core.util.v.E(arrayList)) {
            if (!this.dEF.azB() && TbadkCoreApplication.getInst().isRecAppExist() && this.dEF.azr() == 1) {
                this.dEb.a(this, arrayList);
            }
            ArrayList<com.baidu.adp.widget.ListView.i> a2 = this.dER.a(false, false, arrayList, this.dEt);
            if (a2 != null) {
                this.dEb.au(a2);
                this.dEx.a(a2, this.dEb);
            }
            if (this.dEF != null) {
                com.baidu.tieba.frs.e.b.a(this.dEb, this.dEF.azx(), 2);
            }
        }
    }

    private void Xc() {
        if (auU() == 1 || this.dER.bv(this.dEb.buZ())) {
            if (com.baidu.tbadk.core.util.v.D(this.dEb.getThreadList()) > 3) {
                this.dEx.XO();
            } else {
                this.dEx.avZ();
            }
        } else if (com.baidu.tbadk.core.util.v.E(this.dEb.getThreadList())) {
            this.dEx.XQ();
        } else {
            this.dEx.XP();
        }
    }

    @Override // com.baidu.tieba.frs.mc.j
    public void WO() {
        if (this.dER != null) {
            this.dER.a(this.dEq, this.forumId, this.dEb);
        }
    }

    public void takePhoto() {
        if (!com.baidu.tbadk.core.util.ab.e(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.ai.b(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return avn() ? "a034" : "a006";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (!avn()) {
            return super.getCurrentPageSourceKeyList();
        }
        if (super.getCurrentPageSourceKeyList() != null) {
            arrayList = new ArrayList(super.getCurrentPageSourceKeyList());
        } else {
            arrayList = new ArrayList();
        }
        if (!"a001".equals(com.baidu.tbadk.core.util.v.f(arrayList, arrayList.size() - 1))) {
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

    public void fK(boolean z) {
        if (this.dEL != null) {
            this.dEL.fX(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.dEM.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a jc(int i) {
        return this.dEM.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        this.dEV.b(bVar);
    }

    public boolean avn() {
        return this.dEm;
    }

    @Override // com.baidu.tieba.frs.aj
    public void Xp() {
        if (this.dEx != null) {
            showFloatingView();
            this.dEx.getListView().scrollToPosition(0);
            this.dEx.startPullRefresh();
        }
    }

    public ForumWriteData avo() {
        if (this.dEb == null || this.dEb.bas() == null) {
            return null;
        }
        ForumData bas = this.dEb.bas();
        ForumWriteData forumWriteData = new ForumWriteData(bas.getId(), bas.getName(), bas.getPrefixData(), this.dEb.yn());
        forumWriteData.setForumLevel(bas.getUser_level());
        forumWriteData.setAvatar(this.dEb.bas().getImage_url());
        forumWriteData.specialForumType = bas.special_forum_type;
        UserData userData = this.dEb.getUserData();
        if (userData != null) {
            forumWriteData.setPrivateThread(userData.getPrivateThread());
            return forumWriteData;
        }
        return forumWriteData;
    }

    @Override // com.baidu.tieba.frs.aj
    public void En() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.frs.aj
    public void setVideoThreadId(String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z) {
        super.showLoadingView(view, z);
        this.dEx.mS(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        super.hideLoadingView(view);
        this.dEx.mS(0);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        super.showNetRefreshView(view, str, z);
        this.dEx.mS(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshViewNoClick(View view, String str, boolean z) {
        super.showNetRefreshViewNoClick(view, str, z);
        this.dEx.mS(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        super.hideNetRefreshView(view);
        this.dEx.mS(0);
    }

    public void avp() {
        i.c aAw;
        if (this.dEH != null && (aAw = this.dEH.aAw()) != null && aAw.fragment != null && (aAw.fragment instanceof al)) {
            ((al) aAw.fragment).auF();
        }
    }

    public void a(ContriInfo contriInfo) {
        if (this.dFg == null) {
            this.dFg = new com.baidu.tbadk.core.dialog.i(akO());
        }
        this.dFg.a(contriInfo, -1L);
    }

    public void fL(boolean z) {
        this.dEn = z;
    }

    public boolean avq() {
        return this.dEn;
    }

    public void lH(String str) {
        if (!com.baidu.tbadk.core.util.am.isEmpty(str)) {
            if (this.dFh == null) {
                this.dFh = new AddExperiencedModel(akO());
                this.dFh.a(this.dFi);
            }
            this.dFh.bW(this.forumId, str);
        }
    }
}
