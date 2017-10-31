package com.baidu.tieba.frs;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.b.a.a;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.KuangFloatingViewController;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.atomData.PostSearchActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.aw;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.util.r;
import com.baidu.tbadk.util.s;
import com.baidu.tbadk.util.t;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.c.a;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.f.f;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.tbadkCore.d;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class f extends BaseFragment implements BdListView.e, a.InterfaceC0022a, UserIconBox.b, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, ai, ak, am, com.baidu.tieba.frs.mc.j, com.baidu.tieba.recapp.o {
    private r aMz;
    private com.baidu.adp.lib.e.b<TbImageView> aoy;
    private com.baidu.tieba.frs.gametab.b blN;
    private VoiceManager cxA;
    private f.a cxI;
    private FrsModelController cxK;
    private com.baidu.tieba.frs.g.f cxL;
    private com.baidu.tieba.frs.entelechy.b.d cxM;
    private com.baidu.tieba.frs.mc.f cxN;
    private com.baidu.tieba.frs.smartsort.b cxO;
    private com.baidu.tieba.frs.mc.b cxP;
    private an cxQ;
    private com.baidu.tieba.frs.entelechy.b.b cxS;
    private com.baidu.tbadk.i.a cxT;
    private com.baidu.tieba.frs.g.a cxU;
    private com.baidu.tieba.frs.mc.d cxV;
    private com.baidu.tieba.frs.mc.c cxW;
    private com.baidu.tieba.frs.g.h cxX;
    private com.baidu.tieba.frs.mc.a cxY;
    private com.baidu.tieba.frs.live.a cxZ;
    private com.baidu.tieba.frs.entelechy.b cxp;
    public bh cxt;
    private com.baidu.tieba.tbadkCore.data.e cxx;
    private h cya;
    public com.baidu.tieba.frs.g.c cyb;
    private com.baidu.tieba.frs.mc.e cyc;
    private int cyd;
    private View.OnTouchListener cye;
    private com.baidu.tieba.frs.g.e cyf;
    private boolean cyg;
    private com.baidu.tieba.NEGFeedBack.a cyi;
    public View mRootView;
    public static boolean cxs = false;
    public static volatile long cxC = 0;
    public static volatile long cxD = 0;
    public static volatile int cxE = 0;
    public boolean cxq = false;
    private boolean cxr = false;
    public String cxu = null;
    public String aiB = null;
    public int mFlag = 0;
    private boolean cxv = false;
    private String mThreadId = null;
    public String forumId = null;
    private int cxj = 0;
    private boolean cxw = false;
    private boolean cxy = false;
    private boolean cxz = false;
    private i cxB = null;
    public final bh biQ = null;
    private com.baidu.tieba.tbadkCore.j cxh = new com.baidu.tieba.tbadkCore.j();
    public long cko = -1;
    public long aJJ = 0;
    public long aJB = 0;
    public long createTime = 0;
    public long WI = -1;
    private boolean cxF = false;
    private boolean cxG = false;
    public com.baidu.tbadk.l.d cxH = null;
    private boolean cxJ = true;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> cxR = new SparseArray<>();
    private boolean bmV = true;
    private boolean cyh = false;
    private final CustomMessageListener cyj = new CustomMessageListener(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED) { // from class: com.baidu.tieba.frs.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof bh) {
                    com.baidu.tieba.frs.f.h.a(f.this.cxB, f.this.cxh, f.this.getForumId(), true, (bh) data);
                }
            }
        }
    };
    private CustomMessageListener cyk = new CustomMessageListener(CmdConfigCustom.CMD_CLOSE_GAME_RANK_CARD) { // from class: com.baidu.tieba.frs.f.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (f.this.cxh != null) {
                f.this.cxh.btu();
                if (f.this.cxB != null) {
                    f.this.cxB.abb();
                }
            }
        }
    };
    private final al cyl = new al() { // from class: com.baidu.tieba.frs.f.23
        @Override // com.baidu.tieba.frs.al
        public void a(int i, int i2, ar arVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
            f.this.aiZ();
            if (f.this.cxS != null) {
                f.this.cxL.fe(f.this.cxS.jG(i));
            }
            d.a aVar = new d.a();
            if (arVar != null) {
                aVar.isSuccess = arVar.errCode == 0;
                aVar.errorCode = arVar.errCode;
                aVar.errorMsg = arVar.errMsg;
                if (aVar.isSuccess) {
                    if (com.baidu.tbadk.core.util.v.v(arrayList)) {
                        f.this.cxB.abc();
                    } else if (arVar.hasMore) {
                        f.this.cxB.ajQ();
                    } else if (arVar.cAT) {
                        f.this.cxB.ajR();
                    } else {
                        f.this.cxB.abc();
                    }
                }
            } else {
                arVar = new ar();
                arVar.pn = 1;
                arVar.hasMore = false;
                arVar.cAT = false;
            }
            if (i == 1) {
                f.this.cxJ = true;
                f.this.cyv.a(f.this.cxK.getType(), false, aVar);
            } else {
                f.this.a(aVar);
                if (f.this.cxK.amp() != null) {
                    f.this.cxh = f.this.cxK.amp();
                }
                f.this.ajh();
            }
            if (f.this.cyF != null) {
                f.this.cyF.a(i, i2, arVar, arrayList);
            }
        }
    };
    private aj cym = new aj() { // from class: com.baidu.tieba.frs.f.24
        @Override // com.baidu.tieba.frs.aj
        public void a(al alVar) {
        }

        @Override // com.baidu.tieba.frs.aj
        public void a(int i, int i2, ao aoVar) {
            if (i != 1) {
                com.baidu.tieba.card.u.ZX().dA(false);
            }
            if (i == 1) {
                f.this.cxB.ey(true);
                f.this.cxB.ex(false);
            } else {
                f.this.cxB.ez(true);
                f.this.cxB.ex(true);
            }
            f.this.ajk();
            f.this.cxK.a(i, i2, aoVar);
        }

        @Override // com.baidu.tieba.frs.aj
        public void init() {
        }

        @Override // com.baidu.tieba.frs.aj
        public void Pp() {
        }
    };
    private CustomMessageListener cyn = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIVE_COUNT) { // from class: com.baidu.tieba.frs.f.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                ((com.baidu.tieba.frs.entelechy.c.a) f.this.cxM).jI(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    };
    private CustomMessageListener cyo = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_LIVE_START) { // from class: com.baidu.tieba.frs.f.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && ((Integer) customResponsedMessage.getData()).intValue() == 51 && f.this.cxh != null) {
                com.baidu.tieba.frs.f.j.a(f.this.cxh, f.this.getPageContext());
            }
        }
    };
    private final CustomMessageListener cyp = new CustomMessageListener(CmdConfigCustom.CMD_FRS_SELECT_ALA_LIVE_TAB) { // from class: com.baidu.tieba.frs.f.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (f.this.cxM instanceof com.baidu.tieba.frs.entelechy.c.a) && ((com.baidu.tieba.frs.entelechy.c.a) f.this.cxM).alG() != null) {
                ((com.baidu.tieba.frs.entelechy.c.a) f.this.cxM).alG().kq(49);
            }
        }
    };
    private final CustomMessageListener cyq = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.frs.f.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && f.this.cxh != null && f.this.cxh.aPM() != null) {
                SignData signData = (SignData) customResponsedMessage.getData();
                int user_level = f.this.cxh.aPM().getUser_level();
                if (signData.forumId != null && signData.forumId.equals(f.this.cxh.aPM().getId())) {
                    f.this.cxh.d(signData);
                    f.this.cxL.g(f.this.cxh);
                    if (f.this.cxL.aoF()) {
                        i = f.this.cxh.aPM().getUser_level();
                        if (user_level >= i) {
                            i++;
                        }
                    } else {
                        i = user_level;
                    }
                    TbadkCoreApplication.getInst().addSignedForum(f.this.cxh.aPM().getName(), signData.sign_bonus_point, i);
                }
            }
        }
    };
    private final CustomMessageListener cyr = new CustomMessageListener(CmdConfigCustom.CMD_FRS_EXPERIENCE_TIP) { // from class: com.baidu.tieba.frs.f.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.p) && f.this.cxh != null) {
                f.this.cxh.c((com.baidu.tieba.tbadkCore.p) customResponsedMessage.getData());
                f.this.cxL.f(f.this.cxh);
                f.this.cxM.a(f.this.cxB.getListView(), f.this.cxh, f.this.cxK.anJ());
            }
        }
    };
    private final AntiHelper.a cys = new AntiHelper.a() { // from class: com.baidu.tieba.frs.f.2
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12536").r("obj_locate", ap.a.ahv));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12535").r("obj_locate", ap.a.ahv));
        }
    };
    private CustomMessageListener biW = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.f.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(f.this.xH().getUniqueId())) {
                    if (updateAttentionMessage.getData().arL != null) {
                        if (AntiHelper.a(f.this.getActivity(), updateAttentionMessage.getData().arL, f.this.cys) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12534").r("obj_locate", ap.a.ahv));
                        }
                    } else if (updateAttentionMessage.getData().BJ && updateAttentionMessage.getData().isAttention) {
                        com.baidu.adp.lib.util.l.showToast(f.this.xH().getPageActivity(), d.j.attention_success);
                    }
                }
            }
        }
    };
    private CustomMessageListener cyt = new CustomMessageListener(CmdConfigCustom.CMD_STORY_READ_CACHE) { // from class: com.baidu.tieba.frs.f.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.story.process.b)) {
                com.baidu.tieba.story.process.b bVar = (com.baidu.tieba.story.process.b) customResponsedMessage.getData();
                if (f.this.forumId != null && f.this.forumId.equals(String.valueOf(bVar.forumId)) && bVar.state == 3 && f.this.ajn() != null && !com.baidu.tbadk.core.util.v.v(f.this.ajn().bsq()) && f.this.cxp.akQ() != null && f.this.cxp.akQ().alg() != null) {
                    List<com.baidu.adp.widget.ListView.f> bsq = f.this.ajn().bsq();
                    int size = bsq.size();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= size) {
                            i = -1;
                            break;
                        } else if ((bsq.get(i2) instanceof com.baidu.tbadk.data.g) && TbadkCoreApplication.getCurrentAccount().equals(String.valueOf(((com.baidu.tbadk.data.g) bsq.get(i2)).user_id))) {
                            i = i2;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    com.baidu.tbadk.data.g gVar = new com.baidu.tbadk.data.g();
                    gVar.user_id = com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                    gVar.user_name = TbadkCoreApplication.getCurrentAccountName();
                    gVar.portrait = TbadkCoreApplication.getCurrentPortrait();
                    gVar.mStatus = 3;
                    gVar.azE = String.valueOf(f.this.forumId);
                    gVar.azD = bVar;
                    if (i != -1) {
                        bsq.set(i, gVar);
                    } else {
                        bsq.add(1, gVar);
                    }
                    f.this.cxp.akQ().alg().b(bsq, f.this.forumId, f.this.getThreadId());
                }
            }
        }
    };
    private CustomMessageListener cyu = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.frs.f.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                f.this.cxB.b((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.l cyv = new com.baidu.tieba.tbadkCore.l() { // from class: com.baidu.tieba.frs.f.6
        private long startTime = 0;

        @Override // com.baidu.tieba.tbadkCore.l
        public void jq(int i) {
            this.startTime = System.nanoTime();
            if (f.this.cxB != null) {
                switch (i) {
                    case 1:
                    case 2:
                        f.this.cxB.ajD();
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

        @Override // com.baidu.tieba.tbadkCore.l
        public void a(int i, boolean z, d.a aVar) {
            if (f.this.bmV) {
                f.this.bmV = false;
                com.baidu.tieba.frs.f.h.a(f.this.cxB, f.this.cxh, f.this.getForumId(), false, null);
            }
            f.this.aiZ();
            f.this.cxF = true;
            if (aVar != null && aVar.isSuccess) {
                f.this.cxB.ajN().eM(com.baidu.tbadk.core.util.an.vs().vu());
                f.cxC = 0L;
                f.cxD = 0L;
                f.cxE = 0;
            } else {
                f.cxE = 1;
            }
            if (!f.this.cxK.anN() && (i == 3 || i == 6)) {
                f.this.cxW.resetData();
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (f.this.cxK.amp() != null) {
                f.this.cxh = f.this.cxK.amp();
            }
            if (i == 7) {
                f.this.jo(f.this.cxh.bsQ());
                return;
            }
            if (f.this.cxh.qv() != null) {
                f.this.setHasMore(f.this.cxh.qv().qr());
            }
            f.this.aja();
            if (i == 4) {
                if (!f.this.cxK.anN() && TbadkCoreApplication.getInst().isRecAppExist() && f.this.cxK.anD() == 1) {
                    f.this.cxh.a(f.this);
                }
                ArrayList<com.baidu.adp.widget.ListView.f> a2 = f.this.cxW.a(false, false, f.this.cxh.getThreadList(), f.this.cxx);
                if (a2 != null) {
                    f.this.cxh.az(a2);
                    f.this.cxh.btn();
                    f.this.cxB.a(a2, f.this.cxh);
                }
                if (f.this.cxK != null) {
                    com.baidu.tieba.frs.e.b.a(f.this.cxh, f.this.cxK.anJ(), 2);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    f.this.cxB.ajD();
                    break;
                case 2:
                    f.this.cxB.ajD();
                    break;
                case 3:
                case 6:
                    if (f.this.cxh != null) {
                        f.this.cxh.btl();
                    }
                    if (f.this.cyb != null) {
                        f.this.cyb.refresh();
                        break;
                    }
                    break;
            }
            f.this.ajb();
            if (aVar == null || aVar.errorCode == 0) {
                if (f.this.cxh != null) {
                    f.this.cxB.js(i);
                    f.this.u(false, i == 5);
                    f.cxC = (System.nanoTime() - this.startTime) / 1000000;
                    if (aVar != null) {
                        f.cxD = aVar.gmh;
                    }
                } else {
                    return;
                }
            } else if (f.this.cxh == null || com.baidu.tbadk.core.util.v.v(f.this.cxh.getThreadList())) {
                f.this.a(aVar);
            } else if (aVar.gmg) {
                f.this.showToast(f.this.getPageContext().getResources().getString(d.j.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
            }
            if (f.this.cxh.bsv() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11384"));
            }
            if (f.this.cko > -1 && !f.this.cyh) {
                com.baidu.tieba.frs.f.h.a(f.this.cxK, f.this.cko);
                f.this.cko = -1L;
                f.this.cyh = true;
            }
            if (f.this.cxy && (f.this.cxM instanceof com.baidu.tieba.frs.entelechy.c.a) && ((com.baidu.tieba.frs.entelechy.c.a) f.this.cxM).alG() != null) {
                ((com.baidu.tieba.frs.entelechy.c.a) f.this.cxM).alG().kq(49);
                f.this.cxy = false;
            }
            f.this.aJJ = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.l
        public void b(com.baidu.tieba.tbadkCore.g gVar) {
            if (gVar != null) {
                if ("normal_page".equals(f.this.cxK.anz()) || "frs_page".equals(f.this.cxK.anz()) || "book_page".equals(f.this.cxK.anz())) {
                    f.this.a(gVar);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE, gVar));
                }
            }
        }
    };
    private final CustomMessageListener cyw = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.frs.f.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.k) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                f.this.cxh.a((com.baidu.tbadk.data.k) customResponsedMessage.getData());
                f.this.cxB.ajN().notifyDataSetChanged();
            }
        }
    };
    private final CustomMessageListener mMemListener = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_MEM) { // from class: com.baidu.tieba.frs.f.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && f.this.cxh != null && (userData = f.this.cxh.getUserData()) != null) {
                userData.setIsMem(num.intValue());
                if (num.intValue() != 0) {
                    f.this.cxL.f(num);
                }
            }
        }
    };
    private final com.baidu.tieba.frs.mc.i cyx = new com.baidu.tieba.frs.mc.i() { // from class: com.baidu.tieba.frs.f.10
        @Override // com.baidu.tieba.frs.mc.i
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.f> arrayList, boolean z3) {
            if (f.this.cxO != null && f.this.cxK != null && f.this.cxK.anN() && z && !z2 && !z3) {
                f.this.cxO.kk(i2);
            }
        }
    };
    public final View.OnTouchListener aMA = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.f.11
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (f.this.cye != null) {
                f.this.cye.onTouch(view, motionEvent);
            }
            if (f.this.cxQ != null && f.this.cxQ.akk() != null) {
                f.this.cxQ.akk().onTouchEvent(motionEvent);
            }
            if (f.this.blN != null) {
                f.this.blN.d(view, motionEvent);
            }
            if (f.this.cxL != null) {
                f.this.cxL.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private final CustomMessageListener cyy = new CustomMessageListener(CmdConfigCustom.CMD_GOTOLIVE_HOST_UPGRADE) { // from class: com.baidu.tieba.frs.f.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "photolive_hostLevel", -1) != -1 && f.this.cxh.aPM() != null) {
                f.this.cxh.aPM().setCanAddPhotoLivePost(true);
            }
        }
    };
    private final CustomMessageListener cyz = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.frs.f.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11455").ac("obj_locate", "frs"));
                    com.baidu.tbadk.core.util.av.vI().c(f.this.getPageContext(), new String[]{str});
                }
            }
        }
    };
    public final View.OnClickListener cyA = new View.OnClickListener() { // from class: com.baidu.tieba.frs.f.16
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (f.this.cxB == null || view != f.this.cxB.ajB() || f.this.getActivity() == null) {
                if (f.this.cxh != null && f.this.cxh.aPM() != null) {
                    if (f.this.cxB == null || view != f.this.cxB.ajH()) {
                        if (f.this.cxB != null && view == f.this.cxB.ajI()) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12402").ac(ImageViewerConfig.FORUM_ID, f.this.cxh.aPM().getId()).ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()).ac(ImageViewerConfig.FORUM_NAME, f.this.cxh.aPM().getName()));
                            if (!StringUtils.isNull(f.this.cxh.aPM().getName())) {
                                f.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PostSearchActivityConfig(f.this.getPageContext().getPageActivity(), f.this.cxh.aPM().getName(), f.this.cxh.aPM().getId())));
                                return;
                            }
                            return;
                        }
                    } else if (!StringUtils.isNull(f.this.cxh.aPM().getId())) {
                        if (f.this.cxh.aPM() != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12046").ac(ImageViewerConfig.FORUM_ID, f.this.cxh.aPM().getId()).r("obj_locate", f.this.ajq() ? 1 : 2));
                        }
                        f.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(f.this.getPageContext().getPageActivity(), f.this.cxh.aPM().getId(), ForumDetailActivityConfig.FromType.FRS)));
                        return;
                    } else {
                        return;
                    }
                }
                if (view.getId() == d.g.game_activity_egg_layout && com.baidu.adp.lib.util.l.hy()) {
                    TiebaStatic.log("c10853");
                    if (f.this.cxB.ajK()) {
                        f.this.cxB.ajL();
                        return;
                    }
                    String activityUrl = f.this.cxh.aPM().getYuleData().ta().getActivityUrl();
                    if (!StringUtils.isNull(activityUrl)) {
                        com.baidu.tbadk.browser.a.P(f.this.getPageContext().getPageActivity(), activityUrl);
                        return;
                    }
                    return;
                }
                return;
            }
            f.this.getActivity().finish();
        }
    };
    private final AbsListView.OnScrollListener cyB = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.f.17
        private int cyI = 0;
        private int bfl = 0;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (f.this.aMz != null && f.this.isPrimary()) {
                f.this.aMz.a(absListView, this.cyI, i, i2, i3);
            }
            if (f.this.cxM != null) {
                f.this.cxM.a(absListView, i, i2, i3, f.this.cxL.aoK());
            }
            if (f.this.cxU != null) {
                f.this.cxU.aoo();
            }
            if (f.this.cxO != null) {
                f.this.cxO.anY();
            }
            if (f.this.cyf != null) {
                f.this.cyf.onScroll(absListView, i, i2, i3);
            }
            if (f.this.cxh != null && f.this.cxB != null && f.this.cxB.ajN() != null) {
                this.cyI = i;
                this.bfl = (i + i2) - 1;
                f.this.cxB.ay(this.cyI, this.bfl);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (f.this.cxL != null) {
                f.this.cxL.setScrollState(i);
            }
            if (f.this.aMz != null && f.this.isPrimary()) {
                f.this.aMz.onScrollStateChanged(absListView, i);
            }
            if ((i == 2 || i == 1) && !f.this.cxG) {
                f.this.cxG = true;
                f.this.cxB.ajP();
            }
            if (f.this.cxH == null && !f.this.ajq()) {
                f.this.cxH = new com.baidu.tbadk.l.d();
                f.this.cxH.ft(1000);
            }
            if (i == 0) {
                com.baidu.tieba.card.u.ZX().dA(true);
                f.this.cxB.ax(this.cyI, this.bfl);
            }
            if (f.this.cyf != null) {
                f.this.cyf.onScrollStateChanged(absListView, i);
            }
            if (f.this.cxH != null) {
                f.this.cxH.FP();
            }
            if (i == 0) {
                com.baidu.tieba.frs.f.h.a(f.this.cxB, f.this.cxh, f.this.getForumId(), false, null);
            }
        }
    };
    private final b cyC = new b() { // from class: com.baidu.tieba.frs.f.18
        @Override // com.baidu.tieba.frs.b
        public void a(int i, int i2, View view, View view2, bh bhVar) {
            if (i != f.this.cxB.ajN().aln()) {
                if (i != f.this.cxB.ajN().alo()) {
                    if (i != f.this.cxB.ajN().alq()) {
                        if (i != f.this.cxB.ajN().aka()) {
                            if (i == f.this.cxB.ajN().alp() && f.this.cxh != null && f.this.cxh.getUserData() != null && f.this.cxh.getUserData().isBawu()) {
                                final String bsO = f.this.cxh.bsO();
                                if (!com.baidu.tbadk.core.util.am.isEmpty(bsO) && f.this.cxh.aPM() != null) {
                                    com.baidu.tieba.c.a.a(f.this.getPageContext(), f.this.cxh.aPM().getId(), f.this.cxh.aPM().getName(), new a.InterfaceC0078a() { // from class: com.baidu.tieba.frs.f.18.1
                                        @Override // com.baidu.tieba.c.a.InterfaceC0078a
                                        public void Zv() {
                                            com.baidu.tbadk.browser.a.O(f.this.getPageContext().getPageActivity(), bsO);
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10502").ac(ImageViewerConfig.FORUM_ID, f.this.cxh.aPM().getId()).ac(SapiAccountManager.SESSION_UID, f.this.cxh.getUserData().getUserId()));
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        f.this.cxt = bhVar;
                        com.baidu.tieba.frs.f.i.a(f.this, f.this.cxt);
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10179").ac(ImageViewerConfig.FORUM_ID, f.this.getForumId()));
                        return;
                    }
                    com.baidu.tieba.frs.f.i.B(f.this);
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak(i == f.this.cxB.ajN().alq() ? "c10177" : "c10244").ac(ImageViewerConfig.FORUM_ID, f.this.getForumId()));
                } else if (ax.aT(f.this.getPageContext().getPageActivity())) {
                    TiebaStatic.log("my_service_ck");
                    if (f.this.cxh != null && f.this.cxh.aPM() != null) {
                        ForumData aPM = f.this.cxh.aPM();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(f.this.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(aPM.getId(), 0L), aPM.getName(), aPM.getImage_url(), 0)));
                    }
                }
            } else if (ax.aT(f.this.getActivity())) {
                TiebaStatic.log("forum_fortune_click");
                com.baidu.tieba.frs.f.i.a(f.this.getPageContext(), f.this.cxh);
            }
        }
    };
    private final NoNetworkView.a cvR = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.f.19
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aJ(boolean z) {
            if (f.this.cxK.anD() == 1 && z && !f.this.cxB.ajo()) {
                if (f.this.cxh == null || com.baidu.tbadk.core.util.v.v(f.this.cxh.getThreadList())) {
                    f.this.hideNetRefreshView(f.this.cxB.Vq());
                    f.this.showLoadingView(f.this.cxB.Vq(), true);
                    f.this.cxB.ez(false);
                    f.this.refresh();
                    return;
                }
                f.this.cxB.ajD();
            }
        }
    };
    private final CustomMessageListener cyD = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.f.20
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                com.baidu.tieba.frs.f.c.a(customResponsedMessage, f.this.cxB, f.this.cxh);
            }
        }
    };
    private com.baidu.adp.widget.ListView.h cyE = new a();
    private al cyF = new al() { // from class: com.baidu.tieba.frs.f.21
        @Override // com.baidu.tieba.frs.al
        public void a(int i, int i2, ar arVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
            com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tieba.frs.f.21.1
                @Override // java.lang.Runnable
                public void run() {
                    if (f.this.cxB != null && f.this.cxB.aaS()) {
                        f.this.NF();
                    }
                }
            });
        }
    };
    private CustomMessageListener cyG = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.frs.f.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    f.this.cyg = true;
                }
            }
        }
    };

    public com.baidu.tieba.frs.entelechy.b.b aiN() {
        return this.cxS;
    }

    public com.baidu.adp.widget.ListView.h aiO() {
        return this.cyE;
    }

    public com.baidu.tieba.frs.mc.d aiP() {
        return this.cxV;
    }

    public com.baidu.tieba.frs.smartsort.b aiQ() {
        return this.cxO;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public FrsModelController aiR() {
        return this.cxK;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public com.baidu.tieba.frs.mc.c aiS() {
        return this.cxW;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public com.baidu.tieba.frs.g.f aiT() {
        return this.cxL;
    }

    public com.baidu.tieba.frs.entelechy.b.d aiU() {
        return this.cxM;
    }

    public an aiV() {
        return this.cxQ;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public i aiW() {
        return this.cxB;
    }

    @Override // com.baidu.tieba.frs.am
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.am
    public String getForumName() {
        return this.cxu;
    }

    public void setForumName(String str) {
        this.cxu = str;
    }

    public void setFrom(String str) {
        this.aiB = str;
    }

    public String getFrom() {
        return this.aiB;
    }

    public void setFlag(int i) {
        this.mFlag = i;
    }

    @Override // com.baidu.tieba.recapp.o
    public String getFid() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.recapp.o
    public int getPageNum() {
        if (this.cxW == null) {
            return 1;
        }
        return this.cxW.getPn();
    }

    public int getPn() {
        if (this.cxW == null) {
            return 1;
        }
        return this.cxW.getPn();
    }

    public void setPn(int i) {
        if (this.cxW != null) {
            this.cxW.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.cxW != null) {
            this.cxW.setHasMore(i);
        }
    }

    public int aiX() {
        if (this.cxW == null) {
            return -1;
        }
        return this.cxW.aiX();
    }

    public boolean aiY() {
        return this.cxz;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d.a aVar) {
        if (aVar == null) {
            String string = TbadkCoreApplication.getInst().getString(d.j.error_unkown_try_again);
            this.cxB.ajy();
            showNetRefreshView(this.cxB.Vq(), string, true);
        } else if (340001 == aVar.errorCode) {
            b(aVar);
        } else {
            if (com.baidu.tbadk.core.util.v.v(this.cxh.getThreadList())) {
                c(aVar);
            }
            if (ajq()) {
                setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst(), d.e.ds280));
            } else {
                setNetRefreshViewEmotionDefMarginTop();
            }
        }
    }

    private void b(d.a aVar) {
        this.cxB.ajy();
        if (aVar.gmg) {
            showNetRefreshViewNoClick(this.cxB.Vq(), TbadkCoreApplication.getInst().getString(d.j.net_error_text, new Object[]{aVar.errorMsg, Integer.valueOf(aVar.errorCode)}), true);
        } else {
            showNetRefreshViewNoClick(this.cxB.Vq(), aVar.errorMsg, true);
        }
    }

    private void c(d.a aVar) {
        this.cxB.ajy();
        if (aVar.gmg) {
            showNetRefreshView(this.cxB.Vq(), TbadkCoreApplication.getInst().getString(d.j.net_error_text, new Object[]{aVar.errorMsg, Integer.valueOf(aVar.errorCode)}), true);
        } else {
            showNetRefreshView(this.cxB.Vq(), aVar.errorMsg, true);
        }
    }

    public void aiZ() {
        hideLoadingView(this.cxB.Vq());
        this.cxB.ajJ();
        if (this.cxB.ajw() instanceof com.baidu.tieba.frs.tab.c) {
            ((com.baidu.tieba.frs.tab.c) this.cxB.ajw()).aoi();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aja() {
        if (aiX() == 0 && com.baidu.tbadk.core.util.v.v(this.cxh.bsB())) {
            if (com.baidu.tbadk.core.util.v.v(this.cxh.getThreadList())) {
                this.cxB.abc();
                return;
            } else {
                this.cxB.ajR();
                return;
            }
        }
        this.cxB.ajQ();
    }

    public void a(ErrorData errorData) {
        aiZ();
        this.cxB.ajD();
        d.a anA = this.cxK.anA();
        boolean v = com.baidu.tbadk.core.util.v.v(this.cxh.getThreadList());
        if (anA != null && v) {
            if (v) {
                if (this.cxK.anB() != 0) {
                    this.cxK.anH();
                    this.cxB.ajD();
                } else {
                    a(anA);
                }
                this.cxB.v(this.cxh.btB(), false);
                return;
            } else if (anA.gmg) {
                this.cxB.v(true, false);
                showToast(getPageContext().getResources().getString(d.j.net_error_text, anA.errorMsg, Integer.valueOf(anA.errorCode)));
                return;
            } else {
                return;
            }
        }
        a(anA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajb() {
        if (this.cxh == null || this.cxh.aPM() != null) {
            this.cxB.ajM();
        } else if (this.cxh.aPM().getYuleData() != null && this.cxh.aPM().getYuleData().sZ()) {
            TiebaStatic.log("c10852");
            this.cxB.a(this.cxh.aPM().getYuleData().ta());
        } else {
            this.cxB.ajM();
        }
    }

    private void t(boolean z, boolean z2) {
        if (this.cxK != null && this.cxh != null && this.cxB != null && z) {
            if (!this.cxK.anN() && this.cxK.anD() == 1) {
                if (!this.cxK.anL()) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        this.cxh.bts();
                        this.cxh.btp();
                    }
                    this.cxh.btq();
                    this.cxh.btr();
                }
                boolean z3 = false;
                if (this.cxB.ajN().l(com.baidu.tieba.card.data.p.bVn)) {
                    z3 = this.cxh.btv();
                }
                if (!z3) {
                    this.cxh.btt();
                }
                if (TbadkCoreApplication.getInst().isRecAppExist()) {
                    this.cxh.a(this);
                }
                if (!this.cxB.ajN().l(bh.Ys)) {
                    this.cxh.btm();
                }
                this.cxh.btw();
                this.cxh.btx();
            }
            this.cxh.btn();
            this.cxh.btk();
            if (this.cxB.ajN().l(com.baidu.tieba.g.b.cYc)) {
                this.cxh.mt(z2);
            }
            if (TbadkCoreApplication.isLogin() && (!this.cxK.anN() || this.cxK.isNetFirstLoad)) {
                this.cxh.bty();
            }
            this.cxh.btz();
        }
    }

    public boolean ajc() {
        if (this.cxM != null && this.cxB != null) {
            this.cxM.b(this.cxB.getListView());
        }
        if (this.cxL != null && this.cxK != null) {
            this.cxL.a(this.cxK.anz(), this.cxh);
        }
        boolean z = false;
        if (this.cxh != null) {
            z = this.cxh.btC();
        }
        es(z);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jo(int i) {
        ao aoVar = null;
        ajc();
        ajk();
        try {
            if (this.cxh != null) {
                this.cxB.a((ArrayList<com.baidu.adp.widget.ListView.f>) null, this.cxh);
                this.cxL.ky(1);
                this.cxB.ajG();
                this.cxM.a(this.cxB.getListView(), this.cxh, this.cxK.anJ());
                com.baidu.tieba.frs.tab.d a2 = a(this.cxM.alz(), this.cxh.bsQ());
                if (a2 != null && !TextUtils.isEmpty(a2.url)) {
                    aoVar = new ao();
                    aoVar.cAQ = a2.url;
                    aoVar.stType = a2.name;
                }
                this.cxK.a(this.cxh.bsQ(), 0, aoVar);
                this.cxM.eP(false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private com.baidu.tieba.frs.tab.d a(TabData tabData, int i) {
        if (i < 0 || tabData == null || tabData.size() <= 0) {
            return null;
        }
        Iterator it = tabData.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
            if (dVar != null && dVar.cKA == i) {
                return dVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(boolean z, boolean z2) {
        try {
            if (this.cxh != null && this.cxM != null && this.cxK != null) {
                if (!this.cxB.ajN().l(bh.Ys)) {
                    this.cxh.btm();
                }
                boolean v = com.baidu.tbadk.core.util.v.v(this.cxh.btd());
                this.cxB.ew(v);
                if (!v) {
                    if (this.cyf == null) {
                        this.cyf = new com.baidu.tieba.frs.g.e(this, (NoPressedRelativeLayout) this.mRootView);
                    }
                    if (this.blN == null) {
                        this.blN = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
                    }
                } else {
                    this.cyf = null;
                    this.blN = null;
                }
                if (this.cxh.aPM() != null) {
                    this.cxu = this.cxh.aPM().getName();
                    this.forumId = this.cxh.aPM().getId();
                }
                if (this.cxh.btC()) {
                    this.cxM.a(this.cxB.getListView(), this.cxh, this.cxK.anJ());
                }
                if (z) {
                    t(true, z);
                } else {
                    t(this.cxJ, z);
                }
                ajc();
                if (this.cxS != null) {
                    this.cxS.a(this.cxL, this.cxh);
                }
                if (this.cxh.qv() != null) {
                    setHasMore(this.cxh.qv().qr());
                }
                ArrayList<com.baidu.adp.widget.ListView.f> a2 = this.cxW.a(z2, true, this.cxh.getThreadList(), null, z);
                if (a2 != null) {
                    this.cxh.az(a2);
                }
                if (this.cxK.anD() == 1) {
                    ajh();
                    if (!z && this.cxK.getPn() == 1) {
                        ajd();
                    }
                }
                this.cxj = this.cxh.anF();
                if (this.cxx != null) {
                    this.cxw = true;
                    this.cxx.tN(this.cxj);
                    com.baidu.tieba.frs.f.a.a(this, this.cxh.aPM(), this.cxh.getThreadList(), this.cxw, getPn());
                }
                if (this.cxU != null) {
                    this.cxU.aA(this.cxM.alA());
                }
                aiZ();
                this.cxB.ajz();
                this.cxB.v(true, false);
                if (this.cxh != null && this.cxh.btf() != null && com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("frs_video_activity_guide", 0L) == 0) {
                    com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.f.7
                        @Override // java.lang.Runnable
                        public void run() {
                            f.this.cxB.ajV();
                        }
                    }, 1000L);
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void ajd() {
        if (this.cxZ == null) {
            this.cxZ = new com.baidu.tieba.frs.live.a(this, com.baidu.adp.lib.g.b.g(this.forumId, 0));
        }
        this.cxZ.anl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.g gVar) {
        try {
            if (!this.cxF && gVar != null && this.cxh != null) {
                this.cxh.e(gVar);
                u(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void es(boolean z) {
        if (this.cxK != null) {
            f(z, this.cxK.anz());
        } else {
            f(z, "normal_page");
        }
    }

    private void f(boolean z, String str) {
        et("frs_page".equals(str));
        if (this.cxS != null) {
            this.cxS.a(z, this.cxM, this.cxL, this.cxB, this.cxh);
        }
    }

    public void et(boolean z) {
        if (this.cxX != null) {
            this.cxX.a(this.cxB, z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(d.h.frs_activity, viewGroup, false);
            this.cxp = new com.baidu.tieba.frs.entelechy.b();
            this.cxS = this.cxp.akP();
            this.cxL = new com.baidu.tieba.frs.g.f(this, this.cxp);
            this.cxM = this.cxp.z(this);
            Intent intent = getActivity().getIntent();
            if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                this.cxr = true;
            }
            this.cxB = new i(this, this.cyA, this.cxp, this.cxr);
            this.cxB.setHeaderViewHeight(this.cyd);
        } else if (this.mRootView.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            this.cxB.ajU();
        }
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Intent intent = getActivity().getIntent();
        this.cko = System.currentTimeMillis();
        if (intent != null) {
            this.cxy = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.cko = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            J(intent);
        }
        this.WI = System.currentTimeMillis();
        this.aJB = this.WI - this.cko;
        this.cxx = new com.baidu.tieba.tbadkCore.data.e("frs", com.baidu.tieba.tbadkCore.data.e.goJ);
        this.cxK = new FrsModelController(this, this.cyv);
        this.cxK.a(this.cyl);
        this.cxK.init();
        if (intent != null) {
            this.cxK.h(intent.getExtras());
        } else if (bundle != null) {
            this.cxK.h(bundle);
        } else {
            this.cxK.h(null);
        }
        this.cxM.av(this.cxB.Vq());
        if (intent != null) {
            this.cxL.k(intent.getExtras());
        } else if (bundle != null) {
            this.cxL.k(bundle);
        } else {
            this.cxL.k((Bundle) null);
        }
        this.cxA = getVoiceManager();
        this.cya = new h(getPageContext(), this);
        initUI();
        initData(bundle);
        if (this.aiB != null && this.aiB.equals("from_tieba_kuang")) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12264").r("obj_type", 1).ac(ImageViewerConfig.FORUM_NAME, this.cxK.getForumName()));
            KuangFloatingViewController.getInstance().setNeedShowFloatingView(true);
            KuangFloatingViewController.getInstance().showFloatingView();
        }
        if (!ajq()) {
            this.cxQ = new an(getActivity(), this.cxB, this.cxL);
            this.cxQ.eG(true);
        }
        this.cxA = getVoiceManager();
        if (this.cxA != null) {
            this.cxA.onCreate(getPageContext());
        }
        new com.baidu.tieba.frs.mc.g();
        this.cxW = new com.baidu.tieba.frs.mc.c(this, this.cyx);
        this.cxO = new com.baidu.tieba.frs.smartsort.b(this);
        this.cxX = new com.baidu.tieba.frs.g.h(this);
        this.createTime = System.currentTimeMillis() - this.WI;
        this.cxU = new com.baidu.tieba.frs.g.a(getPageContext(), this.cxK.anK());
        this.cxP = new com.baidu.tieba.frs.mc.b(this);
        this.cxV = new com.baidu.tieba.frs.mc.d(this);
        this.cxN = new com.baidu.tieba.frs.mc.f(this);
        this.cxY = new com.baidu.tieba.frs.mc.a(this);
        this.cyb = new com.baidu.tieba.frs.g.c(this);
        this.cyc = new com.baidu.tieba.frs.mc.e(this, getUniqueId());
        this.cyi = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "frs");
        registerListener(this.biW);
        registerListener(this.mMemListener);
        registerListener(this.cyr);
        registerListener(this.cyy);
        registerListener(this.cyq);
        registerListener(this.cyw);
        registerListener(this.cyn);
        registerListener(this.cyo);
        registerListener(this.cyp);
        registerListener(this.cyj);
        registerListener(this.cyk);
        registerListener(this.cyG);
        registerListener(this.cyt);
        registerListener(this.cyu);
        this.cxB.ez(false);
        if (!ajq()) {
            showLoadingView(this.cxB.Vq(), true);
            this.cxK.p(3, true);
        }
        super.onActivityCreated(bundle);
    }

    @Override // com.baidu.tieba.frs.ai
    public void NQ() {
        if (isAdded() && this.bmV && !isLoadingViewAttached()) {
            showLoadingView(this.cxB.Vq(), true);
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void NR() {
        if (isAdded() && this.bmV && isLoadingViewAttached()) {
            hideLoadingView(this.cxB.Vq());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (ajq()) {
            showLoadingView(this.cxB.Vq(), true);
            this.cxB.jr(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.cxK.p(3, true);
            getListView().setSelection(0);
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void setHeaderViewHeight(int i) {
        this.cyd = i;
        if (this.cxB != null) {
            this.cxB.setHeaderViewHeight(this.cyd);
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        if (sVar != null) {
            this.aMz = sVar.GY();
            this.cye = sVar.GZ();
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void showFloatingView() {
        if (this.aMz != null) {
            this.aMz.bZ(true);
        }
    }

    private void J(Intent intent) {
        if (intent != null) {
            if (!com.baidu.tieba.frs.f.f.a(this, getForumName(), "from", intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false)) && getActivity() != null) {
                getActivity().finish();
                return;
            }
        }
        if (intent != null && intent.getData() != null) {
            Uri data = intent.getData();
            this.cxu = data.getQueryParameter("name");
            this.aiB = data.getQueryParameter("from");
            if (!StringUtils.isNull(this.cxu)) {
                intent.putExtra("name", this.cxu);
            }
            if (!StringUtils.isNull(this.aiB)) {
                intent.putExtra("from", this.aiB);
            }
            TiebaStatic.log("c10105");
        }
        if (StringUtils.isNull(this.cxu)) {
            this.cxu = com.baidu.tieba.frs.f.i.L(intent);
            if (!StringUtils.isNull(this.cxu)) {
                intent.putExtra("name", this.cxu);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.cxA = getVoiceManager();
        if (this.cxA != null) {
            this.cxA.onStart(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        Intent intent;
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.cyD);
        if (bundle != null) {
            this.cxu = bundle.getString("name");
            this.aiB = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
            this.cxu = intent.getStringExtra("name");
            this.aiB = intent.getStringExtra("from");
            this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
        }
        if (TextUtils.isEmpty(this.aiB) || FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.aiB)) {
        }
        if (this.mIsLogin) {
            registerListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL, this.cyD);
        }
        this.cxL.k(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.cyG);
        if (this.cxA != null) {
            this.cxA.onDestory(getPageContext());
        }
        this.cxA = null;
        com.baidu.tieba.card.u.ZX().dA(false);
        if (this.cxh != null && this.cxh.aPM() != null) {
            ad.akg().bg(com.baidu.adp.lib.g.b.c(this.cxh.aPM().getId(), 0L));
        }
        if (this.cxZ != null) {
            this.cxZ.onDestory();
        }
        if (this.cxB != null) {
            com.baidu.tieba.frs.f.h.a(this.cxB, this.cxh, getForumId(), false, null);
            this.cxB.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.cxH != null) {
                this.cxH.onDestroy();
            }
            this.cxB.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.cxK.onActivityDestroy();
        this.cxL.onActivityDestroy();
        if (this.cxI != null) {
            this.cxI.cancel(true);
            this.cxI = null;
        }
        if (this.cxK != null) {
            this.cxK.Pp();
        }
        if (this.cxQ != null) {
            this.cxQ.GX();
        }
        if (this.cxT != null) {
            this.cxT.destory();
        }
        if (this.cxU != null) {
            this.cxU.destory();
        }
        if (this.cxO != null) {
            this.cxO.onDestroy();
        }
        if (this.cyf != null) {
            this.cyf.onDestory();
        }
        if (this.cxY != null) {
            this.cxY.onDestroy();
        }
        if (this.cyi != null) {
            this.cyi.onDestroy();
        }
        com.baidu.tieba.recapp.e.a.bjF().bjH();
        com.baidu.tieba.frs.f.j.aol();
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.cxu);
        bundle.putString("from", this.aiB);
        this.cxK.onSaveInstanceState(bundle);
        if (this.cxA != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            this.cxA.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.cxY != null) {
            this.cxY.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.cxB != null) {
            this.cxB.ajD();
            this.cxB.onResume();
        }
        this.cxM.a(this.cym);
        this.cxN.fc(true);
        this.cxJ = true;
        if (cxs) {
            cxs = false;
            this.cxB.startPullRefresh();
            return;
        }
        if (this.cxA != null) {
            this.cxA.onResume(getPageContext());
        }
        this.cxB.eA(false);
        registerListener(this.cyz);
        if (this.cyg) {
            cm(6);
            this.cyg = false;
        }
        KuangFloatingViewController.getInstance().showFloatingView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        refresh();
    }

    public boolean aje() {
        Intent intent;
        if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
            return false;
        }
        return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
    }

    public void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.cxu = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.aiB = intent.getStringExtra("from");
            }
            this.cxv = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.cxv) {
                ajf();
            }
            if (this.aiB != null && this.aiB.equals("from_tieba_kuang")) {
                KuangFloatingViewController.getInstance().setNeedShowFloatingView(true);
                KuangFloatingViewController.getInstance().showFloatingView();
            }
        }
    }

    private void ajf() {
        this.cxB.startPullRefresh();
    }

    public void closeActivity() {
        com.baidu.tieba.frs.f.i.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.aiB);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.cxB.setTitle(this.cxu);
        } else {
            this.cxB.setTitle("");
            this.mFlag = 1;
        }
        this.cxL.d(this.cxB.getListView());
        this.cxB.setOnAdapterItemClickListener(this.cyE);
        this.cxB.setOnScrollListener(this.cyB);
        this.cxB.h(this.cvR);
        this.cxB.ajN().a(this.cyC);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cxB.onChangeSkinType(i);
        this.cxL.kx(i);
        this.cxM.onChangeSkinType(i);
    }

    public void jp(int i) {
        if (!this.mIsLogin) {
            if (this.cxh != null && this.cxh.qf() != null) {
                this.cxh.qf().setIfpost(1);
            }
            if (i == 0) {
                ax.aS(getActivity());
            }
        } else if (this.cxh != null) {
            if (i == 0) {
                com.baidu.tieba.frs.f.j.b(this, 0);
            } else {
                this.cxB.ajF();
            }
        }
    }

    public void refresh() {
        cm(3);
    }

    public void cm(int i) {
        this.cxF = false;
        ajk();
        if (this.cxB.ajv() != null) {
            this.cxB.ajv().atu();
        }
        this.cxK.p(i, true);
    }

    private void ajg() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.g.h.fQ().d(new Runnable() { // from class: com.baidu.tieba.frs.f.15
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.sA(f.this.cxu);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajh() {
        ajk();
        try {
            if (this.cxh != null) {
                this.cxB.Od();
                this.cxB.ev(this.cxK.anE());
                if (com.baidu.tieba.frs.g.f.i(this.cxh) && !com.baidu.tieba.frs.g.f.h(this.cxh)) {
                    this.cxB.ajS();
                }
                if (this.cxh.aPM() != null) {
                    this.cxu = this.cxh.aPM().getName();
                    this.forumId = this.cxh.aPM().getId();
                }
                if (this.cxh.qv() != null) {
                    setHasMore(this.cxh.qv().qr());
                }
                this.cxB.setTitle(this.cxu);
                this.cxB.setForumName(this.cxu);
                TbadkCoreApplication.getInst().setDefaultBubble(this.cxh.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.cxh.getUserData().getBimg_end_time());
                ajg();
                aji();
                ArrayList<com.baidu.adp.widget.ListView.f> threadList = this.cxh.getThreadList();
                if (threadList != null) {
                    this.cxB.a(threadList, this.cxh);
                    com.baidu.tieba.frs.f.c.j(this.cxB);
                    this.cxL.ky(getPageNum());
                    this.cxL.f(this.cxh);
                    this.cxM.a(this.cxB.getListView(), this.cxh, this.cxK.anJ());
                    this.cxB.ajG();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void aji() {
        if (this.cxh != null) {
            if (this.cxh.aQa() == 1) {
                this.cxB.ajN().setFromCDN(true);
            } else {
                this.cxB.ajN().setFromCDN(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.cxN.fc(false);
        this.cxJ = false;
        this.cxB.onPause();
        if (this.cxA != null) {
            this.cxA.onPause(getPageContext());
        }
        this.cxB.eA(true);
        if (this.cxU != null) {
            this.cxU.aoo();
        }
        MessageManager.getInstance().unRegisterListener(this.cyz);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.u.ZX().dA(false);
        if (this.cxh != null && this.cxh.aPM() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            com.baidu.tbadk.distribute.a.Cs().a(getPageContext().getPageActivity(), "frs", this.cxh.aPM().getId(), 0L);
        }
        if (this.cxA != null) {
            this.cxA.onStop(getPageContext());
        }
        com.baidu.tieba.frs.f.i.a(getListView());
        this.cxL.onActivityStop();
        t.Hb();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || this.cxB == null) {
            return false;
        }
        return this.cxB.ajC();
    }

    @Override // com.baidu.tieba.recapp.o
    public TbPageContext<?> xH() {
        return getPageContext();
    }

    @Override // com.baidu.tieba.recapp.o
    public void a(AdvertAppInfo advertAppInfo, String str) {
        com.baidu.tbadk.distribute.a.Cs().a(advertAppInfo, this.forumId, 0L, "FRS", str, getPn());
    }

    @Override // com.baidu.tieba.recapp.o
    public void ajj() {
        aiR().ajj();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.cxA == null) {
            this.cxA = VoiceManager.instance();
        }
        return this.cxA;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public BdListView getListView() {
        if (this.cxB == null) {
            return null;
        }
        return this.cxB.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void ajk() {
        if (this.cxA != null) {
            this.cxA.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> wN() {
        if (this.aoy == null) {
            this.aoy = UserIconBox.i(getPageContext().getPageActivity(), 8);
        }
        return this.aoy;
    }

    public void ajl() {
        if (getFragmentActivity() != null && getFragmentActivity().getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.a(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.g onGetPreLoadListView() {
        return getListView();
    }

    @Override // com.baidu.tieba.frs.ak
    public NavigationBar ajm() {
        if (this.cxB == null) {
            return null;
        }
        return this.cxB.ajm();
    }

    /* loaded from: classes.dex */
    private final class a implements com.baidu.adp.widget.ListView.h {
        private a() {
        }

        @Override // com.baidu.adp.widget.ListView.h
        public void a(View view, com.baidu.adp.widget.ListView.f fVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            boolean z;
            if (bdUniqueId != null) {
                if (bdUniqueId == p.cAa) {
                    if (f.this.cxB != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11752").ac(ImageViewerConfig.FORUM_ID, f.this.forumId).ac("obj_locate", "1"));
                        f.this.cxB.startPullRefresh();
                    }
                } else if (fVar != null && (fVar instanceof bh)) {
                    bh bhVar = (bh) fVar;
                    if (bhVar.sf() == null || bhVar.sf().getGroup_id() == 0 || ax.aT(f.this.getActivity())) {
                        if ((bhVar.rY() != 1 && bhVar.rY() != 2) || ax.aT(f.this.getActivity())) {
                            if (bhVar.rH() != null) {
                                if (ax.aT(f.this.getActivity())) {
                                    String postUrl = bhVar.rH().getPostUrl();
                                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.hy()) {
                                        com.baidu.tbadk.browser.a.P(f.this.getActivity(), postUrl);
                                    }
                                }
                            } else if (bhVar.sr() != null) {
                                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                    ax.aS(f.this.getPageContext().getPageActivity());
                                    return;
                                }
                                com.baidu.tbadk.core.data.n sr = bhVar.sr();
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(f.this.getPageContext().getPageActivity(), sr.getCartoonId(), sr.getChapterId(), 2)));
                            } else if (bhVar.getThreadType() == 47 && bhVar.ro() == 1 && !com.baidu.tbadk.core.util.am.isEmpty(bhVar.rB())) {
                                com.baidu.tbadk.browser.a.O(f.this.getPageContext().getPageActivity(), bhVar.rB());
                            } else {
                                com.baidu.tieba.tbadkCore.util.e readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                                if (readThreadHistory != null && !readThreadHistory.sG(bhVar.getId())) {
                                    readThreadHistory.sF(bhVar.getId());
                                }
                                final String rB = bhVar.rB();
                                if (rB == null || rB.equals("")) {
                                    z = false;
                                } else {
                                    new Thread(new Runnable() { // from class: com.baidu.tieba.frs.f.a.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(rB);
                                            xVar.uN().vK().mIsNeedAddCommenParam = false;
                                            xVar.uN().vK().mIsUseCurrentBDUSS = false;
                                            xVar.uq();
                                        }
                                    }).start();
                                    z = true;
                                }
                                String tid = bhVar.getTid();
                                if (tid == null) {
                                    tid = "";
                                }
                                if (bhVar.ro() == 2 && !tid.startsWith("pb:")) {
                                    com.baidu.tbadk.core.util.av.vI().c(f.this.getPageContext(), new String[]{tid, "", null});
                                } else if (bhVar.getThreadType() == 33 || (bhVar instanceof aw)) {
                                    String str = bhVar.getThreadType() == 33 ? "c10245" : "c10180";
                                    if (f.this.cxK.anD() == 5) {
                                        str = "c10387";
                                    }
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak(str).ac(ImageViewerConfig.FORUM_ID, f.this.forumId));
                                    com.baidu.tieba.frs.f.i.b(f.this, bhVar);
                                    if (f.this.cxh != null && f.this.cxh.aPM() != null) {
                                        com.baidu.tieba.frs.e.a aVar = new com.baidu.tieba.frs.e.a();
                                        aVar.cOT = f.this.cxh.gmI == 1;
                                        aVar.cOV = f.this.cxh.aPM().getId();
                                        aVar.cOU = f.this.aiR().anJ();
                                        com.baidu.tieba.frs.e.b.aoe().a(aVar, bhVar, 1);
                                    }
                                } else {
                                    if (tid.startsWith("pb:")) {
                                        bhVar.setId(tid.substring(3));
                                    }
                                    if (bdUniqueId.getId() == bh.ZB.getId()) {
                                        com.baidu.tieba.frs.f.h.a(bhVar.qZ());
                                    }
                                    com.baidu.tieba.frs.f.i.a(f.this, bhVar, i, z);
                                    com.baidu.tieba.frs.f.h.a(f.this, f.this.cxh, bhVar);
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
        if (com.baidu.adp.lib.util.l.hy()) {
            hideNetRefreshView(this.cxB.Vq());
            showLoadingView(this.cxB.Vq(), true);
            this.cxB.ez(false);
            this.cxK.p(3, true);
        }
    }

    public com.baidu.tieba.tbadkCore.j ajn() {
        return this.cxh;
    }

    public boolean ajo() {
        return this.cxB.ajo();
    }

    public void Q(Object obj) {
        if (this.cxP != null && this.cxP.cNN != null) {
            this.cxP.cNN.f(obj);
        }
    }

    public void R(Object obj) {
        if (this.cxP != null && this.cxP.cNO != null) {
            this.cxP.cNO.f(obj);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.l.hy()) {
            this.cxB.abc();
        } else if (this.cxK.anD() == 1) {
            NM();
            NF();
        } else if (this.cxK.hasMore()) {
            NF();
        }
    }

    public void kT(String str) {
        NM();
        showToast(str);
    }

    public void H(ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        NM();
        if (!com.baidu.tbadk.core.util.v.v(arrayList)) {
            if (!this.cxK.anN() && TbadkCoreApplication.getInst().isRecAppExist() && this.cxK.anD() == 1) {
                this.cxh.a(this, arrayList);
            }
            ArrayList<com.baidu.adp.widget.ListView.f> a2 = this.cxW.a(false, false, arrayList, this.cxx);
            if (a2 != null) {
                this.cxh.az(a2);
                this.cxB.a(a2, this.cxh);
            }
            if (this.cxK != null) {
                com.baidu.tieba.frs.e.b.a(this.cxh, this.cxK.anJ(), 2);
            }
        }
    }

    private void NM() {
        if (aiX() == 1 || this.cxW.aQ(this.cxh.bsB())) {
            this.cxB.ajQ();
        } else if (com.baidu.tbadk.core.util.v.v(this.cxh.getThreadList())) {
            this.cxB.abc();
        } else {
            this.cxB.ajR();
        }
    }

    @Override // com.baidu.tieba.frs.mc.j
    public void NF() {
        if (this.cxW != null) {
            this.cxW.a(this.cxu, this.forumId, this.cxh);
        }
    }

    public void ajp() {
        if (!com.baidu.tbadk.core.util.ab.e(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.ai.c(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return ajq() ? "a034" : "a006";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (!ajq()) {
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

    @Override // com.baidu.b.a.a.InterfaceC0022a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        com.baidu.tieba.frs.f.i.a(this, i, strArr, iArr);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(getForumId(), 0L));
        }
        return pageStayDurationItem;
    }

    public void eu(boolean z) {
        if (this.cxQ != null) {
            this.cxQ.eG(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.cxR.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a ge(int i) {
        return this.cxR.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        this.cya.b(bVar);
    }

    public boolean ajq() {
        return this.cxr;
    }

    @Override // com.baidu.tieba.frs.ai
    public void NP() {
        if (this.cxB != null) {
            showFloatingView();
            this.cxB.getListView().setSelection(0);
            this.cxB.startPullRefresh();
        }
    }

    public ForumWriteData ajr() {
        if (this.cxh == null || this.cxh.aPM() == null) {
            return null;
        }
        ForumData aPM = this.cxh.aPM();
        ForumWriteData forumWriteData = new ForumWriteData(aPM.getId(), aPM.getName(), aPM.getPrefixData(), this.cxh.qf());
        forumWriteData.setForumLevel(aPM.getUser_level());
        forumWriteData.setAvatar(this.cxh.aPM().getImage_url());
        return forumWriteData;
    }

    @Override // com.baidu.tieba.frs.ai
    public void wB() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void cD(boolean z) {
        if (this.cxB != null) {
            this.cxB.cD(z);
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void setVideoThreadId(String str) {
    }
}
