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
import com.baidu.c.a.a;
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
import com.baidu.tbadk.core.data.bd;
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
import com.baidu.tbadk.util.t;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.c.a;
import com.baidu.tieba.card.s;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.tbadkCore.d;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsPage.RecmForumInfo;
/* loaded from: classes.dex */
public class g extends BaseFragment implements BdListView.e, a.InterfaceC0023a, UserIconBox.b, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, aj, al, an, com.baidu.tieba.frs.mc.j, com.baidu.tieba.recapp.o {
    public static boolean cGZ = false;
    public static volatile long cHj = 0;
    public static volatile long cHk = 0;
    public static volatile int cHl = 0;
    private com.baidu.tbadk.util.r aNl;
    private com.baidu.adp.lib.e.b<TbImageView> aoR;
    private com.baidu.tieba.frs.gametab.b bsB;
    private com.baidu.tieba.frs.entelechy.b cGW;
    private com.baidu.tieba.frs.g.a cHA;
    private com.baidu.tieba.frs.mc.d cHB;
    private com.baidu.tieba.frs.mc.c cHC;
    private com.baidu.tieba.frs.g.h cHD;
    private com.baidu.tieba.frs.mc.a cHE;
    private com.baidu.tieba.frs.live.a cHF;
    private i cHG;
    public com.baidu.tieba.frs.g.c cHH;
    private com.baidu.tieba.frs.mc.e cHI;
    private int cHJ;
    private View.OnTouchListener cHK;
    private com.baidu.tieba.frs.view.b cHL;
    private com.baidu.tieba.frs.g.e cHM;
    private boolean cHN;
    private com.baidu.tieba.NEGFeedBack.a cHP;
    public bd cHa;
    private com.baidu.tieba.tbadkCore.data.e cHe;
    private VoiceManager cHh;
    private FrsModelController cHq;
    private com.baidu.tieba.frs.g.f cHr;
    private com.baidu.tieba.frs.entelechy.b.d cHs;
    private com.baidu.tieba.frs.mc.f cHt;
    private com.baidu.tieba.frs.smartsort.b cHu;
    private com.baidu.tieba.frs.mc.b cHv;
    private ao cHw;
    private com.baidu.tieba.frs.entelechy.b.b cHy;
    private com.baidu.tbadk.h.a cHz;
    public View mRootView;
    public boolean cGX = false;
    private boolean cGY = false;
    public String cHb = null;
    public String mFrom = null;
    public int mFlag = 0;
    private boolean cHc = false;
    private String mThreadId = null;
    public String forumId = null;
    private int cGQ = 0;
    private boolean cHd = false;
    private boolean cHf = false;
    private boolean cHg = false;
    private j cHi = null;
    public final bd bkq = null;
    private com.baidu.tieba.tbadkCore.k cGO = new com.baidu.tieba.tbadkCore.k();
    public long ctu = -1;
    public long aKw = 0;
    public long aKo = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean cHm = false;
    private boolean cHn = false;
    public com.baidu.tbadk.k.d cHo = null;
    private boolean cHp = true;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> cHx = new SparseArray<>();
    private boolean btL = true;
    private boolean cHO = false;
    private final CustomMessageListener cHQ = new CustomMessageListener(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED) { // from class: com.baidu.tieba.frs.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof bd) {
                    com.baidu.tieba.frs.f.g.a(g.this.cHi, g.this.cGO, g.this.getForumId(), true, (bd) data);
                }
            }
        }
    };
    private CustomMessageListener cHR = new CustomMessageListener(CmdConfigCustom.CMD_CLOSE_GAME_RANK_CARD) { // from class: com.baidu.tieba.frs.g.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (g.this.cGO != null) {
                g.this.cGO.bvV();
                if (g.this.cHi != null) {
                    g.this.cHi.adf();
                }
            }
        }
    };
    private final am cHS = new am() { // from class: com.baidu.tieba.frs.g.23
        @Override // com.baidu.tieba.frs.am
        public void a(int i, int i2, as asVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
            g.this.alq();
            if (g.this.cHy != null) {
                g.this.cHr.fC(g.this.cHy.kf(i));
            }
            d.a aVar = new d.a();
            if (asVar != null) {
                aVar.isSuccess = asVar.errCode == 0;
                aVar.errorCode = asVar.errCode;
                aVar.errorMsg = asVar.errMsg;
                if (aVar.isSuccess) {
                    if (com.baidu.tbadk.core.util.v.w(arrayList)) {
                        g.this.cHi.adg();
                    } else if (asVar.hasMore) {
                        if (com.baidu.tbadk.core.util.v.v(g.this.cGO.getThreadList()) > 3) {
                            g.this.cHi.amg();
                        } else {
                            g.this.cHi.ami();
                        }
                    } else if (asVar.cKA) {
                        g.this.cHi.amh();
                    } else {
                        g.this.cHi.adg();
                    }
                }
            } else {
                asVar = new as();
                asVar.pn = 1;
                asVar.hasMore = false;
                asVar.cKA = false;
            }
            if (i == 1) {
                g.this.cHp = true;
                g.this.cIc.a(g.this.cHq.getType(), false, aVar);
            } else {
                g.this.a(aVar);
                if (g.this.cHq.aoH() != null) {
                    g.this.cGO = g.this.cHq.aoH();
                }
                g.this.aly();
            }
            if (g.this.cIm != null) {
                g.this.cIm.a(i, i2, asVar, arrayList);
            }
        }
    };
    private ak cHT = new ak() { // from class: com.baidu.tieba.frs.g.24
        @Override // com.baidu.tieba.frs.ak
        public void a(am amVar) {
        }

        @Override // com.baidu.tieba.frs.ak
        public void a(int i, int i2, ap apVar) {
            if (i != 1) {
                s.abW().dU(false);
            }
            if (i == 1) {
                g.this.cHi.eV(true);
                g.this.cHi.eU(false);
            } else {
                g.this.cHi.eW(true);
                g.this.cHi.eU(true);
            }
            g.this.alB();
            g.this.cHq.a(i, i2, apVar);
        }

        @Override // com.baidu.tieba.frs.ak
        public void init() {
        }

        @Override // com.baidu.tieba.frs.ak
        public void QJ() {
        }
    };
    private CustomMessageListener cHU = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIVE_COUNT) { // from class: com.baidu.tieba.frs.g.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                ((com.baidu.tieba.frs.entelechy.c.a) g.this.cHs).kh(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    };
    private CustomMessageListener cHV = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_LIVE_START) { // from class: com.baidu.tieba.frs.g.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && ((Integer) customResponsedMessage.getData()).intValue() == 51 && g.this.cGO != null) {
                com.baidu.tieba.frs.f.i.a(g.this.cGO, g.this.getPageContext());
            }
        }
    };
    private final CustomMessageListener cHW = new CustomMessageListener(CmdConfigCustom.CMD_FRS_SELECT_ALA_LIVE_TAB) { // from class: com.baidu.tieba.frs.g.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (g.this.cHs instanceof com.baidu.tieba.frs.entelechy.c.a) && ((com.baidu.tieba.frs.entelechy.c.a) g.this.cHs).anX() != null) {
                ((com.baidu.tieba.frs.entelechy.c.a) g.this.cHs).anX().kQ(49);
            }
        }
    };
    private final CustomMessageListener cHX = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.frs.g.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && g.this.cGO != null && g.this.cGO.aRn() != null) {
                SignData signData = (SignData) customResponsedMessage.getData();
                int user_level = g.this.cGO.aRn().getUser_level();
                if (signData.forumId != null && signData.forumId.equals(g.this.cGO.aRn().getId())) {
                    g.this.cGO.d(signData);
                    g.this.cHr.h(g.this.cGO);
                    if (g.this.cHr.aqW()) {
                        i = g.this.cGO.aRn().getUser_level();
                        if (user_level >= i) {
                            i++;
                        }
                    } else {
                        i = user_level;
                    }
                    TbadkCoreApplication.getInst().addSignedForum(g.this.cGO.aRn().getName(), signData.sign_bonus_point, i);
                }
            }
        }
    };
    private final CustomMessageListener cHY = new CustomMessageListener(CmdConfigCustom.CMD_FRS_EXPERIENCE_TIP) { // from class: com.baidu.tieba.frs.g.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.q) && g.this.cGO != null) {
                g.this.cGO.c((com.baidu.tieba.tbadkCore.q) customResponsedMessage.getData());
                g.this.cHr.g(g.this.cGO);
                g.this.cHs.a(g.this.cHi.getListView(), g.this.cGO, g.this.cHq.aqa());
            }
        }
    };
    private final AntiHelper.a cHZ = new AntiHelper.a() { // from class: com.baidu.tieba.frs.g.2
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12536").r("obj_locate", ap.a.ahM));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12535").r("obj_locate", ap.a.ahM));
        }
    };
    private CustomMessageListener bpP = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.g.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(g.this.xR().getUniqueId())) {
                    if (updateAttentionMessage.getData().asp != null) {
                        if (AntiHelper.a(g.this.getActivity(), updateAttentionMessage.getData().asp, g.this.cHZ) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12534").r("obj_locate", ap.a.ahM));
                        }
                    } else if (updateAttentionMessage.getData().BI && updateAttentionMessage.getData().isAttention) {
                        com.baidu.adp.lib.util.l.showToast(g.this.xR().getPageActivity(), d.j.attention_success);
                    }
                }
            }
        }
    };
    private CustomMessageListener cIa = new CustomMessageListener(CmdConfigCustom.CMD_STORY_READ_CACHE) { // from class: com.baidu.tieba.frs.g.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.story.process.b)) {
                com.baidu.tieba.story.process.b bVar = (com.baidu.tieba.story.process.b) customResponsedMessage.getData();
                if (g.this.forumId != null && g.this.forumId.equals(String.valueOf(bVar.forumId)) && bVar.state == 3 && g.this.alE() != null && !com.baidu.tbadk.core.util.v.w(g.this.alE().buN()) && g.this.cGW.ani() != null && g.this.cGW.ani().anx() != null) {
                    List<com.baidu.adp.widget.ListView.f> buN = g.this.alE().buN();
                    int size = buN.size();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= size) {
                            i = -1;
                            break;
                        } else if ((buN.get(i2) instanceof com.baidu.tbadk.data.g) && TbadkCoreApplication.getCurrentAccount().equals(String.valueOf(((com.baidu.tbadk.data.g) buN.get(i2)).user_id))) {
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
                    gVar.aAs = String.valueOf(g.this.forumId);
                    gVar.aAr = bVar;
                    if (i != -1) {
                        buN.set(i, gVar);
                    } else {
                        buN.add(1, gVar);
                    }
                    g.this.cGW.ani().anx().b(buN, g.this.forumId, g.this.getThreadId());
                }
            }
        }
    };
    private CustomMessageListener cIb = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.frs.g.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                g.this.cHi.c((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.m cIc = new com.baidu.tieba.tbadkCore.m() { // from class: com.baidu.tieba.frs.g.6
        private long startTime = 0;

        @Override // com.baidu.tieba.tbadkCore.m
        public void jP(int i) {
            this.startTime = System.nanoTime();
            if (g.this.cHi != null) {
                switch (i) {
                    case 1:
                    case 2:
                        g.this.cHi.alT();
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

        @Override // com.baidu.tieba.tbadkCore.m
        public void a(int i, boolean z, d.a aVar) {
            if (g.this.btL) {
                g.this.btL = false;
                com.baidu.tieba.frs.f.g.a(g.this.cHi, g.this.cGO, g.this.getForumId(), false, null);
            }
            g.this.alq();
            g.this.cHm = true;
            if (aVar != null && aVar.isSuccess) {
                g.this.cHi.amd().fj(com.baidu.tbadk.core.util.an.vs().vu());
                g.cHj = 0L;
                g.cHk = 0L;
                g.cHl = 0;
            } else {
                g.cHl = 1;
            }
            if (!g.this.cHq.aqe() && (i == 3 || i == 6)) {
                g.this.cHC.resetData();
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (g.this.cHq.aoH() != null) {
                g.this.cGO = g.this.cHq.aoH();
            }
            if (i == 7) {
                g.this.jN(g.this.cGO.bvn());
                return;
            }
            if (g.this.cGO.qy() != null) {
                g.this.setHasMore(g.this.cGO.qy().qu());
            }
            g.this.alr();
            if (i == 4) {
                if (!g.this.cHq.aqe() && TbadkCoreApplication.getInst().isRecAppExist() && g.this.cHq.apU() == 1) {
                    g.this.cGO.a(g.this);
                }
                ArrayList<com.baidu.adp.widget.ListView.f> a2 = g.this.cHC.a(false, false, g.this.cGO.getThreadList(), g.this.cHe);
                if (a2 != null) {
                    g.this.cGO.aA(a2);
                    g.this.cGO.bvM();
                    g.this.cHi.a(a2, g.this.cGO);
                }
                if (g.this.cHq != null) {
                    com.baidu.tieba.frs.e.b.a(g.this.cGO, g.this.cHq.aqa(), 2);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    g.this.cHi.alT();
                    break;
                case 2:
                    g.this.cHi.alT();
                    break;
                case 3:
                case 6:
                    if (g.this.cGO != null) {
                        g.this.cGO.bvK();
                    }
                    if (g.this.cHH != null) {
                        g.this.cHH.refresh();
                        break;
                    }
                    break;
            }
            g.this.als();
            if (aVar == null || aVar.errorCode == 0) {
                if (g.this.cGO != null) {
                    g.this.cHi.jR(i);
                    g.this.u(false, i == 5);
                    g.cHj = (System.nanoTime() - this.startTime) / 1000000;
                    if (aVar != null) {
                        g.cHk = aVar.gyH;
                    }
                } else {
                    return;
                }
            } else if (g.this.cGO == null || com.baidu.tbadk.core.util.v.w(g.this.cGO.getThreadList())) {
                g.this.a(aVar);
            } else if (aVar.gyG) {
                g.this.showToast(g.this.getPageContext().getResources().getString(d.j.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
            }
            if (g.this.cGO.buT() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11384"));
            }
            if (g.this.ctu > -1 && !g.this.cHO) {
                com.baidu.tieba.frs.f.g.a(g.this.cHq, g.this.ctu);
                g.this.ctu = -1L;
                g.this.cHO = true;
            }
            if (g.this.cHf && (g.this.cHs instanceof com.baidu.tieba.frs.entelechy.c.a) && ((com.baidu.tieba.frs.entelechy.c.a) g.this.cHs).anX() != null) {
                ((com.baidu.tieba.frs.entelechy.c.a) g.this.cHs).anX().kQ(49);
                g.this.cHf = false;
            }
            g.this.aKw = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.m
        public void b(com.baidu.tieba.tbadkCore.h hVar) {
            if (hVar != null) {
                if ("normal_page".equals(g.this.cHq.apQ()) || "frs_page".equals(g.this.cHq.apQ()) || "book_page".equals(g.this.cHq.apQ())) {
                    g.this.a(hVar);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE, hVar));
                }
            }
        }
    };
    private final CustomMessageListener cId = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.frs.g.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.k) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                g.this.cGO.a((com.baidu.tbadk.data.k) customResponsedMessage.getData());
                g.this.cHi.amd().notifyDataSetChanged();
            }
        }
    };
    private final CustomMessageListener mMemListener = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_MEM) { // from class: com.baidu.tieba.frs.g.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && g.this.cGO != null && (userData = g.this.cGO.getUserData()) != null) {
                userData.setIsMem(num.intValue());
                if (num.intValue() != 0) {
                    g.this.cHr.f(num);
                }
            }
        }
    };
    private final com.baidu.tieba.frs.mc.i cIe = new com.baidu.tieba.frs.mc.i() { // from class: com.baidu.tieba.frs.g.10
        @Override // com.baidu.tieba.frs.mc.i
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.f> arrayList, boolean z3) {
            if (g.this.cHu != null && g.this.cHq != null && g.this.cHq.aqe() && z && !z2 && !z3) {
                g.this.cHu.kK(i2);
            }
        }
    };
    public final View.OnTouchListener aNm = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.g.11
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (g.this.cHK != null) {
                g.this.cHK.onTouch(view, motionEvent);
            }
            if (g.this.cHw != null && g.this.cHw.amC() != null) {
                g.this.cHw.amC().onTouchEvent(motionEvent);
            }
            if (g.this.bsB != null) {
                g.this.bsB.d(view, motionEvent);
            }
            if (g.this.cHr != null) {
                g.this.cHr.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private final CustomMessageListener cIf = new CustomMessageListener(CmdConfigCustom.CMD_GOTOLIVE_HOST_UPGRADE) { // from class: com.baidu.tieba.frs.g.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "photolive_hostLevel", -1) != -1 && g.this.cGO.aRn() != null) {
                g.this.cGO.aRn().setCanAddPhotoLivePost(true);
            }
        }
    };
    private final CustomMessageListener cIg = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.frs.g.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11455").ac("obj_locate", "frs"));
                    com.baidu.tbadk.core.util.av.vI().c(g.this.getPageContext(), new String[]{str});
                }
            }
        }
    };
    public final View.OnClickListener cIh = new View.OnClickListener() { // from class: com.baidu.tieba.frs.g.16
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.this.cHi == null || view != g.this.cHi.alR() || g.this.getActivity() == null) {
                if (g.this.cGO != null && g.this.cGO.aRn() != null) {
                    if (g.this.cHi == null || view != g.this.cHi.alX()) {
                        if (g.this.cHi != null && view == g.this.cHi.alY()) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12402").ac(ImageViewerConfig.FORUM_ID, g.this.cGO.aRn().getId()).ac("uid", TbadkCoreApplication.getCurrentAccount()).ac(ImageViewerConfig.FORUM_NAME, g.this.cGO.aRn().getName()));
                            if (!StringUtils.isNull(g.this.cGO.aRn().getName())) {
                                g.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PostSearchActivityConfig(g.this.getPageContext().getPageActivity(), g.this.cGO.aRn().getName(), g.this.cGO.aRn().getId())));
                                return;
                            }
                            return;
                        }
                    } else if (!StringUtils.isNull(g.this.cGO.aRn().getId())) {
                        if (g.this.cGO.aRn() != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12046").ac(ImageViewerConfig.FORUM_ID, g.this.cGO.aRn().getId()).r("obj_locate", g.this.alG() ? 1 : 2));
                        }
                        g.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(g.this.getPageContext().getPageActivity(), g.this.cGO.aRn().getId(), ForumDetailActivityConfig.FromType.FRS)));
                        return;
                    } else {
                        return;
                    }
                }
                if (view.getId() == d.g.game_activity_egg_layout && com.baidu.adp.lib.util.l.hy()) {
                    TiebaStatic.log("c10853");
                    if (g.this.cHi.ama()) {
                        g.this.cHi.amb();
                    } else {
                        String activityUrl = g.this.cGO.aRn().getYuleData().ta().getActivityUrl();
                        if (!StringUtils.isNull(activityUrl)) {
                            com.baidu.tbadk.browser.a.P(g.this.getPageContext().getPageActivity(), activityUrl);
                        }
                    }
                }
                if (view == g.this.cHi.amj() && g.this.cHq != null && g.this.cHq.hasMore()) {
                    g.this.cHi.amg();
                    g.this.OI();
                    return;
                }
                return;
            }
            g.this.getActivity().finish();
        }
    };
    private final AbsListView.OnScrollListener cIi = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.g.17
        private int cIp = 0;
        private int bjV = 0;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (g.this.aNl != null && g.this.isPrimary()) {
                g.this.aNl.a(absListView, this.cIp, i, i2, i3);
            }
            if (g.this.cHs != null) {
                g.this.cHs.a(absListView, i, i2, i3, g.this.cHr.ara());
            }
            if (g.this.cHA != null) {
                g.this.cHA.aqF();
            }
            if (g.this.cHu != null) {
                g.this.cHu.aqp();
            }
            if (g.this.cHM != null) {
                g.this.cHM.onScroll(absListView, i, i2, i3);
            }
            if (g.this.cGO != null && g.this.cHi != null && g.this.cHi.amd() != null) {
                this.cIp = i;
                this.bjV = (i + i2) - 1;
                g.this.cHi.az(this.cIp, this.bjV);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (g.this.cHr != null) {
                g.this.cHr.setScrollState(i);
            }
            if (g.this.aNl != null && g.this.isPrimary()) {
                g.this.aNl.onScrollStateChanged(absListView, i);
            }
            if ((i == 2 || i == 1) && !g.this.cHn) {
                g.this.cHn = true;
                g.this.cHi.amf();
            }
            if (g.this.cHo == null && !g.this.alG()) {
                g.this.cHo = new com.baidu.tbadk.k.d();
                g.this.cHo.fr(1000);
            }
            if (i == 0) {
                s.abW().dU(true);
                g.this.cHi.ay(this.cIp, this.bjV);
            }
            if (g.this.cHM != null) {
                g.this.cHM.onScrollStateChanged(absListView, i);
            }
            if (g.this.cHo != null) {
                g.this.cHo.Gi();
            }
            if (i == 0) {
                com.baidu.tieba.frs.f.g.a(g.this.cHi, g.this.cGO, g.this.getForumId(), false, null);
            }
        }
    };
    private final b cIj = new b() { // from class: com.baidu.tieba.frs.g.18
        @Override // com.baidu.tieba.frs.b
        public void a(int i, int i2, View view, View view2, bd bdVar) {
            if (i != g.this.cHi.amd().anE()) {
                if (i != g.this.cHi.amd().anF()) {
                    if (i != g.this.cHi.amd().anH()) {
                        if (i != g.this.cHi.amd().ams()) {
                            if (i == g.this.cHi.amd().anG() && g.this.cGO != null && g.this.cGO.getUserData() != null && g.this.cGO.getUserData().isBawu()) {
                                final String bvl = g.this.cGO.bvl();
                                if (!com.baidu.tbadk.core.util.am.isEmpty(bvl) && g.this.cGO.aRn() != null) {
                                    com.baidu.tieba.c.a.a(g.this.getPageContext(), g.this.cGO.aRn().getId(), g.this.cGO.aRn().getName(), new a.InterfaceC0093a() { // from class: com.baidu.tieba.frs.g.18.1
                                        @Override // com.baidu.tieba.c.a.InterfaceC0093a
                                        public void abr() {
                                            com.baidu.tbadk.browser.a.O(g.this.getPageContext().getPageActivity(), bvl);
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10502").ac(ImageViewerConfig.FORUM_ID, g.this.cGO.aRn().getId()).ac("uid", g.this.cGO.getUserData().getUserId()));
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        g.this.cHa = bdVar;
                        com.baidu.tieba.frs.f.h.a(g.this, g.this.cHa);
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10179").ac(ImageViewerConfig.FORUM_ID, g.this.getForumId()));
                        return;
                    }
                    com.baidu.tieba.frs.f.h.B(g.this);
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak(i == g.this.cHi.amd().anH() ? "c10177" : "c10244").ac(ImageViewerConfig.FORUM_ID, g.this.getForumId()));
                } else if (ax.aS(g.this.getPageContext().getPageActivity())) {
                    TiebaStatic.log("my_service_ck");
                    if (g.this.cGO != null && g.this.cGO.aRn() != null) {
                        ForumData aRn = g.this.cGO.aRn();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(g.this.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(aRn.getId(), 0L), aRn.getName(), aRn.getImage_url(), 0)));
                    }
                }
            } else if (ax.aS(g.this.getActivity())) {
                TiebaStatic.log("forum_fortune_click");
                com.baidu.tieba.frs.f.h.a(g.this.getPageContext(), g.this.cGO);
            }
        }
    };
    private final NoNetworkView.a cFw = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.g.19
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aJ(boolean z) {
            if (g.this.cHq.apU() == 1 && z && !g.this.cHi.alF()) {
                if (g.this.cGO == null || com.baidu.tbadk.core.util.v.w(g.this.cGO.getThreadList())) {
                    g.this.hideNetRefreshView(g.this.cHi.WQ());
                    g.this.showLoadingView(g.this.cHi.WQ(), true);
                    g.this.cHi.eW(false);
                    g.this.refresh();
                    return;
                }
                g.this.cHi.alT();
            }
        }
    };
    private final CustomMessageListener cIk = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.g.20
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                com.baidu.tieba.frs.f.c.a(customResponsedMessage, g.this.cHi, g.this.cGO);
            }
        }
    };
    private com.baidu.adp.widget.ListView.h cIl = new a();
    private am cIm = new am() { // from class: com.baidu.tieba.frs.g.21
        @Override // com.baidu.tieba.frs.am
        public void a(int i, int i2, as asVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
            com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tieba.frs.g.21.1
                @Override // java.lang.Runnable
                public void run() {
                    if (g.this.cHi != null && g.this.cHi.acW()) {
                        g.this.OI();
                    }
                }
            });
        }
    };
    private CustomMessageListener cIn = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.frs.g.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    g.this.cHN = true;
                }
            }
        }
    };

    public com.baidu.tieba.frs.entelechy.b.b ale() {
        return this.cHy;
    }

    public com.baidu.adp.widget.ListView.h alf() {
        return this.cIl;
    }

    public com.baidu.tieba.frs.mc.d alg() {
        return this.cHB;
    }

    public com.baidu.tieba.frs.smartsort.b alh() {
        return this.cHu;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public FrsModelController ali() {
        return this.cHq;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public com.baidu.tieba.frs.mc.c alj() {
        return this.cHC;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public com.baidu.tieba.frs.g.f alk() {
        return this.cHr;
    }

    public com.baidu.tieba.frs.entelechy.b.d all() {
        return this.cHs;
    }

    public ao alm() {
        return this.cHw;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public j aln() {
        return this.cHi;
    }

    @Override // com.baidu.tieba.frs.an
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.an
    public String getForumName() {
        return this.cHb;
    }

    public void setForumName(String str) {
        this.cHb = str;
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

    @Override // com.baidu.tieba.recapp.o
    public String getFid() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.recapp.o
    public int getPageNum() {
        if (this.cHC == null) {
            return 1;
        }
        return this.cHC.getPn();
    }

    public int getPn() {
        if (this.cHC == null) {
            return 1;
        }
        return this.cHC.getPn();
    }

    public void setPn(int i) {
        if (this.cHC != null) {
            this.cHC.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.cHC != null) {
            this.cHC.setHasMore(i);
        }
    }

    public int alo() {
        if (this.cHC == null) {
            return -1;
        }
        return this.cHC.alo();
    }

    public boolean alp() {
        return this.cHg;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d.a aVar) {
        if (aVar == null) {
            String string = TbadkCoreApplication.getInst().getString(d.j.error_unkown_try_again);
            this.cHi.alO();
            showNetRefreshView(this.cHi.WQ(), string, true);
        } else if (340001 == aVar.errorCode) {
            a(aVar, this.cGO.buQ());
        } else {
            if (com.baidu.tbadk.core.util.v.w(this.cGO.getThreadList())) {
                b(aVar);
            }
            if (alG()) {
                setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst(), d.e.ds280));
            } else {
                setNetRefreshViewEmotionDefMarginTop();
            }
        }
    }

    public void a(View view, String str, boolean z, List<RecmForumInfo> list) {
        this.cHi.alO();
        if (this.cHL == null) {
            this.cHL = new com.baidu.tieba.frs.view.b(getPageContext(), getNetRefreshListener());
        }
        this.cHL.gB(str);
        this.cHL.bn(list);
        this.cHL.c(view, z);
    }

    private void a(d.a aVar, List<RecmForumInfo> list) {
        if (this.cHi != null) {
            this.cHi.alO();
            this.cHi.setTitle(this.cHb);
        }
        a(this.cHi.WQ(), aVar.errorMsg, true, list);
    }

    private void b(d.a aVar) {
        this.cHi.alO();
        if (aVar.gyG) {
            showNetRefreshView(this.cHi.WQ(), TbadkCoreApplication.getInst().getString(d.j.net_error_text, new Object[]{aVar.errorMsg, Integer.valueOf(aVar.errorCode)}), true);
        } else {
            showNetRefreshView(this.cHi.WQ(), aVar.errorMsg, true);
        }
    }

    public void alq() {
        hideLoadingView(this.cHi.WQ());
        this.cHi.alZ();
        if (this.cHi.alM() instanceof com.baidu.tieba.frs.tab.c) {
            ((com.baidu.tieba.frs.tab.c) this.cHi.alM()).aqz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alr() {
        if (alo() == 0 && com.baidu.tbadk.core.util.v.w(this.cGO.buZ())) {
            if (com.baidu.tbadk.core.util.v.w(this.cGO.getThreadList())) {
                this.cHi.adg();
            } else {
                this.cHi.amh();
            }
        } else if (com.baidu.tbadk.core.util.v.v(this.cGO.getThreadList()) > 3) {
            this.cHi.amg();
        } else {
            this.cHi.ami();
        }
    }

    public void a(ErrorData errorData) {
        alq();
        this.cHi.alT();
        d.a apR = this.cHq.apR();
        boolean w = com.baidu.tbadk.core.util.v.w(this.cGO.getThreadList());
        if (apR != null && w) {
            if (w) {
                if (this.cHq.apS() != 0) {
                    this.cHq.apY();
                    this.cHi.alT();
                } else {
                    a(apR);
                }
                this.cHi.v(this.cGO.bwb(), false);
                return;
            } else if (apR.gyG) {
                this.cHi.v(true, false);
                showToast(getPageContext().getResources().getString(d.j.net_error_text, apR.errorMsg, Integer.valueOf(apR.errorCode)));
                return;
            } else {
                return;
            }
        }
        a(apR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void als() {
        if (this.cGO == null || this.cGO.aRn() != null) {
            this.cHi.amc();
        } else if (this.cGO.aRn().getYuleData() != null && this.cGO.aRn().getYuleData().sZ()) {
            TiebaStatic.log("c10852");
            this.cHi.a(this.cGO.aRn().getYuleData().ta());
        } else {
            this.cHi.amc();
        }
    }

    private void t(boolean z, boolean z2) {
        if (this.cHq != null && this.cGO != null && this.cHi != null && z) {
            if (!this.cHq.aqe() && this.cHq.apU() == 1) {
                if (!this.cHq.aqc()) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        this.cGO.bvT();
                        this.cGO.bvO();
                    }
                    this.cGO.bvR();
                    this.cGO.bvS();
                }
                boolean z3 = false;
                if (this.cHi.amd().l(com.baidu.tieba.card.data.p.cei)) {
                    z3 = this.cGO.bvW();
                }
                if (!z3) {
                    this.cGO.bvU();
                }
                if (TbadkCoreApplication.getInst().isRecAppExist()) {
                    this.cGO.a(this);
                }
                if (!this.cHi.amd().l(bd.YE)) {
                    this.cGO.bvL();
                }
                this.cGO.bvX();
            }
            if (!this.cHi.amd().l(bd.YE)) {
                this.cGO.bvQ();
            } else {
                this.cGO.bvP();
            }
            this.cGO.bvM();
            this.cGO.bvJ();
            if (this.cHi.amd().l(com.baidu.tieba.g.b.dik)) {
                this.cGO.na(z2);
            }
            if (TbadkCoreApplication.isLogin() && (!this.cHq.aqe() || this.cHq.isNetFirstLoad)) {
                this.cGO.bvY();
            }
            this.cGO.bvZ();
        }
    }

    public boolean alt() {
        if (this.cHs != null && this.cHi != null) {
            this.cHs.b(this.cHi.getListView());
        }
        if (this.cHr != null && this.cHq != null) {
            this.cHr.a(this.cHq.apQ(), this.cGO);
        }
        boolean z = false;
        if (this.cGO != null) {
            z = this.cGO.bwc();
        }
        eP(z);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jN(int i) {
        ap apVar = null;
        alt();
        alB();
        try {
            if (this.cGO != null) {
                this.cHi.a((ArrayList<com.baidu.adp.widget.ListView.f>) null, this.cGO);
                this.cHr.kY(1);
                this.cHi.alW();
                this.cHs.a(this.cHi.getListView(), this.cGO, this.cHq.aqa());
                com.baidu.tieba.frs.tab.d a2 = a(this.cHs.anQ(), this.cGO.bvn());
                if (a2 != null && !TextUtils.isEmpty(a2.url)) {
                    apVar = new ap();
                    apVar.cKx = a2.url;
                    apVar.stType = a2.name;
                }
                this.cHq.a(this.cGO.bvn(), 0, apVar);
                this.cHs.fm(false);
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
            if (dVar != null && dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(boolean z, boolean z2) {
        try {
            if (this.cGO != null && this.cHs != null && this.cHq != null) {
                if (!this.cHi.amd().l(bd.YE)) {
                    this.cGO.bvL();
                }
                boolean w = com.baidu.tbadk.core.util.v.w(this.cGO.bvA());
                this.cHi.eT(w);
                if (!w) {
                    if (this.cHM == null) {
                        this.cHM = new com.baidu.tieba.frs.g.e(this, (NoPressedRelativeLayout) this.mRootView);
                    }
                    if (this.bsB == null) {
                        this.bsB = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
                    }
                } else {
                    this.cHM = null;
                    this.bsB = null;
                }
                if (this.cGO.aRn() != null) {
                    this.cHb = this.cGO.aRn().getName();
                    this.forumId = this.cGO.aRn().getId();
                }
                if (this.cGO.bwc()) {
                    this.cHs.a(this.cHi.getListView(), this.cGO, this.cHq.aqa());
                }
                if (z) {
                    t(true, z);
                } else {
                    t(this.cHp, z);
                }
                alt();
                if (this.cHy != null) {
                    this.cHy.a(this.cHr, this.cGO);
                }
                if (this.cGO.qy() != null) {
                    setHasMore(this.cGO.qy().qu());
                }
                ArrayList<com.baidu.adp.widget.ListView.f> a2 = this.cHC.a(z2, true, this.cGO.getThreadList(), null, z);
                if (a2 != null) {
                    this.cGO.aA(a2);
                }
                if (this.cHq.apU() == 1) {
                    aly();
                    if (!z && this.cHq.getPn() == 1) {
                        alu();
                    }
                }
                this.cGQ = this.cGO.apW();
                if (this.cHe != null) {
                    this.cHd = true;
                    this.cHe.us(this.cGQ);
                    com.baidu.tieba.frs.f.a.a(this, this.cGO.aRn(), this.cGO.getThreadList(), this.cHd, getPn());
                }
                if (this.cHA != null) {
                    this.cHA.aF(this.cHs.anR());
                }
                alq();
                this.cHi.alP();
                this.cHi.v(true, false);
                if (this.cGO.aRn() != null) {
                    this.cHi.lc(this.cGO.aRn().getWarningMsg());
                }
                if (this.cGO != null && this.cGO.bvD() != null && com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("frs_video_activity_guide", 0L) == 0) {
                    com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.g.7
                        @Override // java.lang.Runnable
                        public void run() {
                            g.this.cHi.amn();
                        }
                    }, 1000L);
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void alu() {
        if (this.cHF == null) {
            this.cHF = new com.baidu.tieba.frs.live.a(this, com.baidu.adp.lib.g.b.g(this.forumId, 0));
        }
        this.cHF.apC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.h hVar) {
        try {
            if (!this.cHm && hVar != null && this.cGO != null) {
                this.cGO.e(hVar);
                u(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void eP(boolean z) {
        if (this.cHq != null) {
            g(z, this.cHq.apQ());
        } else {
            g(z, "normal_page");
        }
    }

    private void g(boolean z, String str) {
        eQ("frs_page".equals(str));
        if (this.cHy != null) {
            this.cHy.a(z, this.cHs, this.cHr, this.cHi, this.cGO);
        }
    }

    public void eQ(boolean z) {
        if (this.cHD != null) {
            this.cHD.a(this.cHi, z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(d.h.frs_activity, viewGroup, false);
            this.cGW = new com.baidu.tieba.frs.entelechy.b();
            this.cHy = this.cGW.anh();
            this.cHr = new com.baidu.tieba.frs.g.f(this, this.cGW);
            this.cHs = this.cGW.z(this);
            Intent intent = getActivity().getIntent();
            if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                this.cGY = true;
            }
            this.cHi = new j(this, this.cIh, this.cGW, this.cGY);
            this.cHi.setHeaderViewHeight(this.cHJ);
        } else if (this.mRootView.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            this.cHi.amm();
        }
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Intent intent = getActivity().getIntent();
        this.ctu = System.currentTimeMillis();
        if (intent != null) {
            this.cHf = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.ctu = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            J(intent);
        }
        this.beginTime = System.currentTimeMillis();
        this.aKo = this.beginTime - this.ctu;
        this.cHe = new com.baidu.tieba.tbadkCore.data.e("frs", com.baidu.tieba.tbadkCore.data.e.gBn);
        this.cHq = new FrsModelController(this, this.cIc);
        this.cHq.a(this.cHS);
        this.cHq.init();
        if (intent != null) {
            this.cHq.h(intent.getExtras());
        } else if (bundle != null) {
            this.cHq.h(bundle);
        } else {
            this.cHq.h(null);
        }
        this.cHs.az(this.cHi.WQ());
        if (intent != null) {
            this.cHr.k(intent.getExtras());
        } else if (bundle != null) {
            this.cHr.k(bundle);
        } else {
            this.cHr.k((Bundle) null);
        }
        this.cHh = getVoiceManager();
        this.cHG = new i(getPageContext(), this);
        initUI();
        initData(bundle);
        if (this.mFrom != null && this.mFrom.equals("from_tieba_kuang")) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12264").r("obj_type", 1).ac(ImageViewerConfig.FORUM_NAME, this.cHq.getForumName()));
            KuangFloatingViewController.getInstance().setNeedShowFloatingView(true);
            KuangFloatingViewController.getInstance().showFloatingView();
        }
        if (!alG()) {
            this.cHw = new ao(getActivity(), this.cHi, this.cHr);
            this.cHw.fd(true);
        }
        this.cHh = getVoiceManager();
        if (this.cHh != null) {
            this.cHh.onCreate(getPageContext());
        }
        new com.baidu.tieba.frs.mc.g();
        this.cHC = new com.baidu.tieba.frs.mc.c(this, this.cIe);
        this.cHu = new com.baidu.tieba.frs.smartsort.b(this);
        this.cHD = new com.baidu.tieba.frs.g.h(this);
        this.createTime = System.currentTimeMillis() - this.beginTime;
        this.cHA = new com.baidu.tieba.frs.g.a(getPageContext(), this.cHq.aqb());
        this.cHv = new com.baidu.tieba.frs.mc.b(this);
        this.cHB = new com.baidu.tieba.frs.mc.d(this);
        this.cHt = new com.baidu.tieba.frs.mc.f(this);
        this.cHE = new com.baidu.tieba.frs.mc.a(this);
        this.cHH = new com.baidu.tieba.frs.g.c(this);
        this.cHI = new com.baidu.tieba.frs.mc.e(this, getUniqueId());
        this.cHP = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "frs");
        registerListener(this.bpP);
        registerListener(this.mMemListener);
        registerListener(this.cHY);
        registerListener(this.cIf);
        registerListener(this.cHX);
        registerListener(this.cId);
        registerListener(this.cHU);
        registerListener(this.cHV);
        registerListener(this.cHW);
        registerListener(this.cHQ);
        registerListener(this.cHR);
        registerListener(this.cIn);
        registerListener(this.cIa);
        registerListener(this.cIb);
        this.cHi.eW(false);
        if (!alG()) {
            showLoadingView(this.cHi.WQ(), true);
            this.cHq.p(3, true);
        }
        super.onActivityCreated(bundle);
    }

    @Override // com.baidu.tieba.frs.aj
    public void Pk() {
        if (isAdded() && this.btL && !isLoadingViewAttached()) {
            showLoadingView(this.cHi.WQ(), true);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void Pl() {
        if (isAdded() && this.btL && isLoadingViewAttached()) {
            hideLoadingView(this.cHi.WQ());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (alG()) {
            showLoadingView(this.cHi.WQ(), true);
            this.cHi.jQ(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.cHq.p(3, true);
            getListView().setSelection(0);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void setHeaderViewHeight(int i) {
        this.cHJ = i;
        if (this.cHi != null) {
            this.cHi.setHeaderViewHeight(this.cHJ);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.s sVar) {
        if (sVar != null) {
            this.aNl = sVar.Hr();
            this.cHK = sVar.Hs();
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void showFloatingView() {
        if (this.aNl != null) {
            this.aNl.ca(true);
        }
    }

    private void J(Intent intent) {
        if (intent != null) {
            if (!com.baidu.tieba.frs.f.e.a(this, getForumName(), "from", intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false)) && getActivity() != null) {
                getActivity().finish();
                return;
            }
        }
        if (intent != null && intent.getData() != null) {
            Uri data = intent.getData();
            this.cHb = data.getQueryParameter("name");
            this.mFrom = data.getQueryParameter("from");
            if (!StringUtils.isNull(this.cHb)) {
                intent.putExtra("name", this.cHb);
            }
            if (!StringUtils.isNull(this.mFrom)) {
                intent.putExtra("from", this.mFrom);
            }
            TiebaStatic.log("c10105");
        }
        if (StringUtils.isNull(this.cHb)) {
            this.cHb = com.baidu.tieba.frs.f.h.L(intent);
            if (!StringUtils.isNull(this.cHb)) {
                intent.putExtra("name", this.cHb);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.cHh = getVoiceManager();
        if (this.cHh != null) {
            this.cHh.onStart(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        Intent intent;
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.cIk);
        if (bundle != null) {
            this.cHb = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
            this.cHb = intent.getStringExtra("name");
            this.mFrom = intent.getStringExtra("from");
            this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
        }
        if (TextUtils.isEmpty(this.mFrom) || FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
        }
        if (this.mIsLogin) {
            registerListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL, this.cIk);
        }
        this.cHr.k(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.cIn);
        if (this.cHh != null) {
            this.cHh.onDestory(getPageContext());
        }
        this.cHh = null;
        s.abW().dU(false);
        if (this.cGO != null && this.cGO.aRn() != null) {
            ae.amy().bo(com.baidu.adp.lib.g.b.c(this.cGO.aRn().getId(), 0L));
        }
        if (this.cHF != null) {
            this.cHF.onDestory();
        }
        if (this.cHi != null) {
            com.baidu.tieba.frs.f.g.a(this.cHi, this.cGO, getForumId(), false, null);
            this.cHi.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.cHo != null) {
                this.cHo.onDestroy();
            }
            this.cHi.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.cHq.onActivityDestroy();
        this.cHr.onActivityDestroy();
        if (this.cHq != null) {
            this.cHq.QJ();
        }
        if (this.cHw != null) {
            this.cHw.Hq();
        }
        if (this.cHz != null) {
            this.cHz.destory();
        }
        if (this.cHA != null) {
            this.cHA.destory();
        }
        if (this.cHu != null) {
            this.cHu.onDestroy();
        }
        if (this.cHM != null) {
            this.cHM.onDestory();
        }
        if (this.cHE != null) {
            this.cHE.onDestroy();
        }
        if (this.cHP != null) {
            this.cHP.onDestroy();
        }
        com.baidu.tieba.recapp.e.a.bmv().bmx();
        com.baidu.tieba.frs.f.i.aqC();
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.cHb);
        bundle.putString("from", this.mFrom);
        this.cHq.onSaveInstanceState(bundle);
        if (this.cHh != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            this.cHh.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.cHE != null) {
            this.cHE.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.cHi != null) {
            this.cHi.alT();
            this.cHi.onResume();
        }
        this.cHs.a(this.cHT);
        this.cHt.fz(true);
        this.cHp = true;
        if (cGZ) {
            cGZ = false;
            this.cHi.startPullRefresh();
            return;
        }
        if (this.cHh != null) {
            this.cHh.onResume(getPageContext());
        }
        this.cHi.eX(false);
        registerListener(this.cIg);
        if (this.cHN) {
            cn(6);
            this.cHN = false;
        }
        KuangFloatingViewController.getInstance().showFloatingView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        refresh();
    }

    public boolean alv() {
        Intent intent;
        if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
            return false;
        }
        return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
    }

    public void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.cHb = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.cHc = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.cHc) {
                alw();
            }
            if (this.mFrom != null && this.mFrom.equals("from_tieba_kuang")) {
                KuangFloatingViewController.getInstance().setNeedShowFloatingView(true);
                KuangFloatingViewController.getInstance().showFloatingView();
            }
        }
    }

    private void alw() {
        this.cHi.startPullRefresh();
    }

    public void closeActivity() {
        com.baidu.tieba.frs.f.h.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.mFrom);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.cHi.setTitle(this.cHb);
        } else {
            this.cHi.setTitle("");
            this.mFlag = 1;
        }
        this.cHr.d(this.cHi.getListView());
        this.cHi.setOnAdapterItemClickListener(this.cIl);
        this.cHi.setOnScrollListener(this.cIi);
        this.cHi.h(this.cFw);
        this.cHi.amd().a(this.cIj);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cHi.onChangeSkinType(i);
        this.cHr.kX(i);
        this.cHs.onChangeSkinType(i);
        if (this.cHL != null) {
            this.cHL.onChangeSkinType();
        }
    }

    public void jO(int i) {
        if (!this.mIsLogin) {
            if (this.cGO != null && this.cGO.qg() != null) {
                this.cGO.qg().setIfpost(1);
            }
            if (i == 0) {
                ax.aR(getActivity());
            }
        } else if (this.cGO != null) {
            if (i == 0) {
                com.baidu.tieba.frs.f.i.b(this, 0);
            } else {
                this.cHi.alV();
            }
        }
    }

    public void refresh() {
        cn(3);
    }

    public void cn(int i) {
        this.cHm = false;
        alB();
        if (this.cHi.alL() != null) {
            this.cHi.alL().avt();
        }
        this.cHq.p(i, true);
    }

    private void alx() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.g.h.fQ().d(new Runnable() { // from class: com.baidu.tieba.frs.g.15
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.ti(g.this.cHb);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aly() {
        alB();
        try {
            if (this.cGO != null) {
                this.cHi.PB();
                this.cHi.eS(this.cHq.apV());
                if (com.baidu.tieba.frs.g.f.j(this.cGO) && !com.baidu.tieba.frs.g.f.i(this.cGO)) {
                    this.cHi.amk();
                }
                if (this.cGO.aRn() != null) {
                    this.cHb = this.cGO.aRn().getName();
                    this.forumId = this.cGO.aRn().getId();
                }
                if (this.cGO.qy() != null) {
                    setHasMore(this.cGO.qy().qu());
                }
                this.cHi.setTitle(this.cHb);
                this.cHi.setForumName(this.cHb);
                TbadkCoreApplication.getInst().setDefaultBubble(this.cGO.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.cGO.getUserData().getBimg_end_time());
                alx();
                alz();
                ArrayList<com.baidu.adp.widget.ListView.f> threadList = this.cGO.getThreadList();
                if (threadList != null) {
                    this.cHi.a(threadList, this.cGO);
                    com.baidu.tieba.frs.f.c.j(this.cHi);
                    this.cHr.kY(getPageNum());
                    this.cHr.g(this.cGO);
                    this.cHs.a(this.cHi.getListView(), this.cGO, this.cHq.aqa());
                    this.cHi.alW();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void alz() {
        if (this.cGO != null) {
            if (this.cGO.aRB() == 1) {
                this.cHi.amd().setFromCDN(true);
            } else {
                this.cHi.amd().setFromCDN(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.cHt.fz(false);
        this.cHp = false;
        this.cHi.onPause();
        if (this.cHh != null) {
            this.cHh.onPause(getPageContext());
        }
        this.cHi.eX(true);
        if (this.cHA != null) {
            this.cHA.aqF();
        }
        MessageManager.getInstance().unRegisterListener(this.cIg);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        s.abW().dU(false);
        if (this.cGO != null && this.cGO.aRn() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            com.baidu.tbadk.distribute.a.CO().a(getPageContext().getPageActivity(), "frs", this.cGO.aRn().getId(), 0L);
        }
        if (this.cHh != null) {
            this.cHh.onStop(getPageContext());
        }
        com.baidu.tieba.frs.f.h.a(getListView());
        this.cHr.onActivityStop();
        t.Hu();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && this.cHr != null) {
            this.cHr.fB(isPrimary());
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || this.cHi == null) {
            return false;
        }
        return this.cHi.alS();
    }

    @Override // com.baidu.tieba.recapp.o
    public TbPageContext<?> xR() {
        return getPageContext();
    }

    @Override // com.baidu.tieba.recapp.o
    public void a(AdvertAppInfo advertAppInfo, String str) {
        com.baidu.tbadk.distribute.a.CO().a(advertAppInfo, this.forumId, 0L, "FRS", str, getPn());
    }

    @Override // com.baidu.tieba.recapp.o
    public void alA() {
        ali().alA();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.cHh == null) {
            this.cHh = VoiceManager.instance();
        }
        return this.cHh;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public BdListView getListView() {
        if (this.cHi == null) {
            return null;
        }
        return this.cHi.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void alB() {
        if (this.cHh != null) {
            this.cHh.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> wN() {
        if (this.aoR == null) {
            this.aoR = UserIconBox.i(getPageContext().getPageActivity(), 8);
        }
        return this.aoR;
    }

    public void alC() {
        if (getFragmentActivity() != null && getFragmentActivity().getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.a(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.g onGetPreLoadListView() {
        return getListView();
    }

    @Override // com.baidu.tieba.frs.al
    public NavigationBar alD() {
        if (this.cHi == null) {
            return null;
        }
        return this.cHi.alD();
    }

    /* loaded from: classes.dex */
    private final class a implements com.baidu.adp.widget.ListView.h {
        private a() {
        }

        @Override // com.baidu.adp.widget.ListView.h
        public void a(View view, com.baidu.adp.widget.ListView.f fVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            boolean z;
            if (bdUniqueId != null) {
                if (bdUniqueId == q.cJH) {
                    if (g.this.cHi != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11752").ac(ImageViewerConfig.FORUM_ID, g.this.forumId).ac("obj_locate", "1"));
                        g.this.cHi.startPullRefresh();
                    }
                } else if (fVar != null && (fVar instanceof bd)) {
                    bd bdVar = (bd) fVar;
                    if (bdVar.sg() == null || bdVar.sg().getGroup_id() == 0 || ax.aS(g.this.getActivity())) {
                        if ((bdVar.rZ() != 1 && bdVar.rZ() != 2) || ax.aS(g.this.getActivity())) {
                            if (bdVar.rJ() != null) {
                                if (ax.aS(g.this.getActivity())) {
                                    String postUrl = bdVar.rJ().getPostUrl();
                                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.hy()) {
                                        com.baidu.tbadk.browser.a.P(g.this.getActivity(), postUrl);
                                    }
                                }
                            } else if (bdVar.ss() != null) {
                                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                    ax.aR(g.this.getPageContext().getPageActivity());
                                    return;
                                }
                                com.baidu.tbadk.core.data.m ss = bdVar.ss();
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(g.this.getPageContext().getPageActivity(), ss.getCartoonId(), ss.getChapterId(), 2)));
                            } else if (bdVar.getThreadType() == 47 && bdVar.rq() == 1 && !com.baidu.tbadk.core.util.am.isEmpty(bdVar.rD())) {
                                com.baidu.tbadk.browser.a.O(g.this.getPageContext().getPageActivity(), bdVar.rD());
                            } else {
                                com.baidu.tieba.tbadkCore.util.e readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                                if (readThreadHistory != null && !readThreadHistory.to(bdVar.getId())) {
                                    readThreadHistory.tn(bdVar.getId());
                                }
                                final String rD = bdVar.rD();
                                if (rD == null || rD.equals("")) {
                                    z = false;
                                } else {
                                    new Thread(new Runnable() { // from class: com.baidu.tieba.frs.g.a.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(rD);
                                            xVar.uN().vK().mIsNeedAddCommenParam = false;
                                            xVar.uN().vK().mIsUseCurrentBDUSS = false;
                                            xVar.uq();
                                        }
                                    }).start();
                                    z = true;
                                }
                                String tid = bdVar.getTid();
                                if (tid == null) {
                                    tid = "";
                                }
                                if (bdVar.rq() == 2 && !tid.startsWith("pb:")) {
                                    com.baidu.tbadk.core.util.av.vI().c(g.this.getPageContext(), new String[]{tid, "", null});
                                } else if (bdVar.getThreadType() == 33 || (bdVar instanceof com.baidu.tbadk.core.data.as)) {
                                    String str = bdVar.getThreadType() == 33 ? "c10245" : "c10180";
                                    if (g.this.cHq.apU() == 5) {
                                        str = "c10387";
                                    }
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak(str).ac(ImageViewerConfig.FORUM_ID, g.this.forumId));
                                    com.baidu.tieba.frs.f.h.b(g.this, bdVar);
                                    if (g.this.cGO != null && g.this.cGO.aRn() != null) {
                                        com.baidu.tieba.frs.e.a aVar = new com.baidu.tieba.frs.e.a();
                                        aVar.cYO = g.this.cGO.gzl == 1;
                                        aVar.cYQ = g.this.cGO.aRn().getId();
                                        aVar.cYP = g.this.ali().aqa();
                                        com.baidu.tieba.frs.e.b.aqv().a(aVar, bdVar, 1);
                                    }
                                } else {
                                    if (tid.startsWith("pb:")) {
                                        bdVar.setId(tid.substring(3));
                                    }
                                    if (bdUniqueId.getId() == bd.ZO.getId()) {
                                        com.baidu.tieba.frs.f.g.a(bdVar.rb());
                                    }
                                    com.baidu.tieba.frs.f.h.a(g.this, bdVar, i, z);
                                    com.baidu.tieba.frs.f.g.a(g.this, g.this.cGO, bdVar);
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
            hideNetRefreshView(this.cHi.WQ());
            showLoadingView(this.cHi.WQ(), true);
            this.cHi.eW(false);
            this.cHq.p(3, true);
        }
    }

    public com.baidu.tieba.tbadkCore.k alE() {
        return this.cGO;
    }

    public boolean alF() {
        return this.cHi.alF();
    }

    public void Q(Object obj) {
        if (this.cHv != null && this.cHv.cXH != null) {
            this.cHv.cXH.f(obj);
        }
    }

    public void R(Object obj) {
        if (this.cHv != null && this.cHv.cXI != null) {
            this.cHv.cXI.f(obj);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.l.hy()) {
            this.cHi.adg();
        } else if (this.cHq.apU() == 1) {
            OW();
            OI();
        } else if (this.cHq.hasMore()) {
            OI();
        }
    }

    public void lb(String str) {
        OW();
        showToast(str);
    }

    public void I(ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        OW();
        if (!com.baidu.tbadk.core.util.v.w(arrayList)) {
            if (!this.cHq.aqe() && TbadkCoreApplication.getInst().isRecAppExist() && this.cHq.apU() == 1) {
                this.cGO.a(this, arrayList);
            }
            ArrayList<com.baidu.adp.widget.ListView.f> a2 = this.cHC.a(false, false, arrayList, this.cHe);
            if (a2 != null) {
                this.cGO.aA(a2);
                this.cHi.a(a2, this.cGO);
            }
            if (this.cHq != null) {
                com.baidu.tieba.frs.e.b.a(this.cGO, this.cHq.aqa(), 2);
            }
        }
    }

    private void OW() {
        if (alo() == 1 || this.cHC.bc(this.cGO.buZ())) {
            if (com.baidu.tbadk.core.util.v.v(this.cGO.getThreadList()) > 3) {
                this.cHi.amg();
            } else {
                this.cHi.ami();
            }
        } else if (com.baidu.tbadk.core.util.v.w(this.cGO.getThreadList())) {
            this.cHi.adg();
        } else {
            this.cHi.amh();
        }
    }

    @Override // com.baidu.tieba.frs.mc.j
    public void OI() {
        if (this.cHC != null) {
            this.cHC.a(this.cHb, this.forumId, this.cGO);
        }
    }

    public void takePhoto() {
        if (!com.baidu.tbadk.core.util.ab.f(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.ai.c(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return alG() ? "a034" : "a006";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (!alG()) {
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

    @Override // com.baidu.c.a.a.InterfaceC0023a
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

    public void eR(boolean z) {
        if (this.cHw != null) {
            this.cHw.fd(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.cHx.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a gl(int i) {
        return this.cHx.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        this.cHG.b(bVar);
    }

    public boolean alG() {
        return this.cGY;
    }

    @Override // com.baidu.tieba.frs.aj
    public void Pj() {
        if (this.cHi != null) {
            showFloatingView();
            this.cHi.getListView().setSelection(0);
            this.cHi.startPullRefresh();
        }
    }

    public ForumWriteData alH() {
        if (this.cGO == null || this.cGO.aRn() == null) {
            return null;
        }
        ForumData aRn = this.cGO.aRn();
        ForumWriteData forumWriteData = new ForumWriteData(aRn.getId(), aRn.getName(), aRn.getPrefixData(), this.cGO.qg());
        forumWriteData.setForumLevel(aRn.getUser_level());
        forumWriteData.setAvatar(this.cGO.aRn().getImage_url());
        UserData userData = this.cGO.getUserData();
        if (userData != null) {
            forumWriteData.setPrivateThread(userData.getPrivateThread());
            return forumWriteData;
        }
        return forumWriteData;
    }

    @Override // com.baidu.tieba.frs.aj
    public void wC() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void cN(boolean z) {
        if (this.cHi != null) {
            this.cHi.cN(z);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void setVideoThreadId(String str) {
    }
}
