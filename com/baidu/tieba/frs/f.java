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
import com.baidu.adp.widget.d;
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
import com.baidu.tbadk.core.data.ay;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.util.q;
import com.baidu.tbadk.util.r;
import com.baidu.tbadk.util.s;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.c.a;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.g.f;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.tbadkCore.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.AlaLiveNotify;
/* loaded from: classes.dex */
public class f extends BaseFragment implements BdListView.e, d.c, a.InterfaceC0023a, UserIconBox.b, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, ah, aj, al, com.baidu.tieba.frs.mc.k, com.baidu.tieba.recapp.o {
    private q aMz;
    private com.baidu.adp.lib.e.b<TbImageView> apf;
    private com.baidu.tieba.frs.gametab.a bjr;
    private com.baidu.tieba.frs.entelechy.b coQ;
    private boolean coU;
    public bj coV;
    private com.baidu.tieba.frs.mc.d cpA;
    private com.baidu.tieba.frs.h.h cpB;
    private com.baidu.tieba.frs.mc.a cpC;
    private h cpD;
    public com.baidu.tieba.frs.h.c cpE;
    private com.baidu.tieba.frs.mc.f cpF;
    private Intent cpG;
    private int cpH;
    private View.OnTouchListener cpI;
    private com.baidu.tieba.frs.h.e cpJ;
    private boolean cpK;
    private boolean cpZ;
    private com.baidu.tieba.tbadkCore.data.e cpa;
    private VoiceManager cpd;
    private f.a cpl;
    private FrsModelController cpn;
    private com.baidu.tieba.frs.h.f cpo;
    private com.baidu.tieba.frs.entelechy.b.d cpp;
    private com.baidu.tieba.frs.mc.g cpq;
    private com.baidu.tieba.frs.mc.b cpr;
    private com.baidu.tieba.frs.smartsort.b cps;
    private com.baidu.tieba.frs.mc.c cpt;
    private am cpu;
    private com.baidu.tieba.frs.entelechy.b.b cpw;
    private com.baidu.tbadk.i.a cpx;
    private com.baidu.tieba.frs.h.a cpy;
    private com.baidu.tieba.frs.mc.e cpz;
    public View mRootView;
    private static boolean isNeedRefreshOnResume = false;
    public static boolean coT = false;
    public static volatile long cpf = 0;
    public static volatile long cpg = 0;
    public static volatile int cph = 0;
    public boolean coR = false;
    private boolean coS = false;
    public String coW = null;
    public String aiP = null;
    public int mFlag = 0;
    private boolean coX = false;
    private boolean coY = false;
    private String mThreadId = null;
    public String forumId = null;
    private int coK = 0;
    private boolean coZ = false;
    private boolean cpb = false;
    private boolean cpc = false;
    private i cpe = null;
    public final bj bgI = null;
    private com.baidu.tieba.tbadkCore.i coI = new com.baidu.tieba.tbadkCore.i();
    public long ccl = -1;
    public long aJO = 0;
    public long aJG = 0;
    public long createTime = 0;
    public long Wo = -1;
    private boolean cpi = false;
    private boolean cpj = false;
    public com.baidu.tbadk.l.d cpk = null;
    private boolean cpm = true;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> cpv = new SparseArray<>();
    private boolean bjS = true;
    private boolean cpL = false;
    private final CustomMessageListener cpM = new CustomMessageListener(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED) { // from class: com.baidu.tieba.frs.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof bj) {
                    com.baidu.tieba.frs.g.h.a(f.this.cpe, f.this.coI, f.this.getForumId(), true, (bj) data);
                }
            }
        }
    };
    private CustomMessageListener cpN = new CustomMessageListener(CmdConfigCustom.CMD_CLOSE_GAME_RANK_CARD) { // from class: com.baidu.tieba.frs.f.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (f.this.coI != null) {
                f.this.coI.brp();
                if (f.this.cpe != null) {
                    f.this.cpe.Zb();
                }
            }
        }
    };
    private final ak cpO = new ak() { // from class: com.baidu.tieba.frs.f.19
        @Override // com.baidu.tieba.frs.ak
        public void a(int i, int i2, aq aqVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
            f.this.agQ();
            if (f.this.cpw != null) {
                f.this.cpo.fl(f.this.cpw.jf(i));
            }
            d.a aVar = new d.a();
            if (aqVar != null) {
                aVar.isSuccess = aqVar.errCode == 0;
                aVar.errorCode = aqVar.errCode;
                aVar.errorMsg = aqVar.errMsg;
                if (aVar.isSuccess) {
                    if (com.baidu.tbadk.core.util.v.v(arrayList)) {
                        f.this.cpe.Zc();
                    } else if (aqVar.hasMore) {
                        f.this.cpe.Xt();
                    } else if (aqVar.csn) {
                        f.this.cpe.Xv();
                    } else {
                        f.this.cpe.Zc();
                    }
                }
            } else {
                aqVar = new aq();
                aqVar.pn = 1;
                aqVar.hasMore = false;
                aqVar.csn = false;
            }
            if (i == 1) {
                f.this.cpm = true;
                f.this.cpW.a(f.this.cpn.getType(), false, aVar);
            } else {
                f.this.a(aVar, true);
                if (f.this.cpn.ajS() != null) {
                    f.this.coI = f.this.cpn.ajS();
                }
                f.this.agZ();
            }
            if (f.this.cqh != null) {
                f.this.cqh.a(i, i2, aqVar, arrayList);
            }
        }
    };
    private ai cpP = new ai() { // from class: com.baidu.tieba.frs.f.20
        @Override // com.baidu.tieba.frs.ai
        public void a(ak akVar) {
        }

        @Override // com.baidu.tieba.frs.ai
        public void a(int i, int i2, an anVar) {
            if (i != 1) {
                com.baidu.tieba.card.u.XY().dI(false);
            }
            if (i == 1) {
                f.this.cpe.eM(true);
                f.this.cpe.eL(false);
            } else {
                f.this.cpe.eN(true);
                f.this.cpe.eL(true);
            }
            f.this.ahc();
            f.this.cpn.a(i, i2, anVar);
        }

        @Override // com.baidu.tieba.frs.ai
        public void init() {
        }

        @Override // com.baidu.tieba.frs.ai
        public void OO() {
        }
    };
    private CustomMessageListener cpQ = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIVE_COUNT) { // from class: com.baidu.tieba.frs.f.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                ((com.baidu.tieba.frs.entelechy.c.a) f.this.cpp).jh(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    };
    private CustomMessageListener cpR = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_LIVE_START) { // from class: com.baidu.tieba.frs.f.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && ((Integer) customResponsedMessage.getData()).intValue() == 51 && f.this.coI != null) {
                com.baidu.tieba.frs.g.j.a(f.this.coI, f.this.getPageContext());
            }
        }
    };
    private final CustomMessageListener cpS = new CustomMessageListener(CmdConfigCustom.CMD_FRS_SELECT_ALA_LIVE_TAB) { // from class: com.baidu.tieba.frs.f.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (f.this.cpp instanceof com.baidu.tieba.frs.entelechy.c.a) && ((com.baidu.tieba.frs.entelechy.c.a) f.this.cpp).aji() != null) {
                ((com.baidu.tieba.frs.entelechy.c.a) f.this.cpp).aji().jL(49);
            }
        }
    };
    private final CustomMessageListener cpT = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.frs.f.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && f.this.coI != null && f.this.coI.aOV() != null) {
                SignData signData = (SignData) customResponsedMessage.getData();
                int user_level = f.this.coI.aOV().getUser_level();
                if (signData.forumId != null && signData.forumId.equals(f.this.coI.aOV().getId())) {
                    f.this.coI.d(signData);
                    f.this.cpo.g(f.this.coI);
                    if (f.this.cpo.alK()) {
                        i = f.this.coI.aOV().getUser_level();
                        if (user_level >= i) {
                            i++;
                        }
                    } else {
                        i = user_level;
                    }
                    TbadkCoreApplication.getInst().addSignedForum(f.this.coI.aOV().getName(), signData.sign_bonus_point, i);
                }
            }
        }
    };
    private final CustomMessageListener cpU = new CustomMessageListener(CmdConfigCustom.CMD_FRS_EXPERIENCE_TIP) { // from class: com.baidu.tieba.frs.f.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.o) && f.this.coI != null) {
                f.this.coI.c((com.baidu.tieba.tbadkCore.o) customResponsedMessage.getData());
                f.this.cpo.f(f.this.coI);
                f.this.cpp.a(f.this.cpe.getListView(), f.this.coI, f.this.cpn.akO());
            }
        }
    };
    private CustomMessageListener cpV = new CustomMessageListener(CmdConfigCustom.CMD_STORY_READ_CACHE) { // from class: com.baidu.tieba.frs.f.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.story.process.b)) {
                com.baidu.tieba.story.process.b bVar = (com.baidu.tieba.story.process.b) customResponsedMessage.getData();
                if (f.this.forumId != null && f.this.forumId.equals(String.valueOf(bVar.forumId)) && bVar.state == 3 && f.this.ahf() != null && !com.baidu.tbadk.core.util.v.v(f.this.ahf().bqn()) && f.this.coQ.aiu() != null && f.this.coQ.aiu().aiK() != null) {
                    List<com.baidu.adp.widget.ListView.f> bqn = f.this.ahf().bqn();
                    int size = bqn.size();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= size) {
                            i = -1;
                            break;
                        } else if ((bqn.get(i2) instanceof com.baidu.tbadk.data.f) && TbadkCoreApplication.getCurrentAccount().equals(String.valueOf(((com.baidu.tbadk.data.f) bqn.get(i2)).user_id))) {
                            i = i2;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    com.baidu.tbadk.data.f fVar = new com.baidu.tbadk.data.f();
                    fVar.user_id = com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                    fVar.user_name = TbadkCoreApplication.getCurrentAccountName();
                    fVar.portrait = TbadkCoreApplication.getCurrentPortrait();
                    fVar.mStatus = 3;
                    fVar.azO = String.valueOf(f.this.forumId);
                    fVar.azN = bVar;
                    if (i != -1) {
                        bqn.set(i, fVar);
                    } else {
                        bqn.add(1, fVar);
                    }
                    f.this.coQ.aiu().aiK().b(bqn, f.this.forumId, f.this.getThreadId());
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.k cpW = new com.baidu.tieba.tbadkCore.k() { // from class: com.baidu.tieba.frs.f.3
        private long startTime = 0;

        @Override // com.baidu.tieba.tbadkCore.k
        public void iR(int i) {
            this.startTime = System.nanoTime();
            if (f.this.cpe != null) {
                switch (i) {
                    case 1:
                    case 2:
                        f.this.cpe.ahw();
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

        @Override // com.baidu.tieba.tbadkCore.k
        public void a(int i, boolean z, d.a aVar) {
            if (f.this.bjS) {
                f.this.bjS = false;
                com.baidu.tieba.frs.g.h.a(f.this.cpe, f.this.coI, f.this.getForumId(), false, null);
            }
            f.this.agQ();
            f.this.cpi = true;
            if (aVar != null && aVar.isSuccess) {
                f.this.cpe.ahG().eY(com.baidu.tbadk.core.util.an.vO().vQ());
                f.cpf = 0L;
                f.cpg = 0L;
                f.cph = 0;
            } else {
                f.cph = 1;
            }
            if (!f.this.cpn.akS() && (i == 3 || i == 6)) {
                f.this.cpA.resetData();
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (f.this.cpn.ajS() != null) {
                f.this.coI = f.this.cpn.ajS();
            }
            if (i == 7) {
                f.this.iP(f.this.coI.bqM());
                return;
            }
            if (f.this.coI.qD() != null) {
                f.this.setHasMore(f.this.coI.qD().qz());
            }
            f.this.agR();
            if (i == 4) {
                if (!f.this.cpn.akS() && TbadkCoreApplication.getInst().isRecAppExist() && f.this.cpn.akI() == 1) {
                    f.this.coI.a(f.this);
                }
                ArrayList<com.baidu.adp.widget.ListView.f> a2 = f.this.cpA.a(false, false, f.this.coI.getThreadList(), f.this.cpa);
                if (a2 != null) {
                    f.this.coI.aA(a2);
                    f.this.coI.bri();
                    f.this.cpe.a(a2, f.this.coI);
                }
                if (f.this.cpn != null) {
                    com.baidu.tieba.frs.f.b.a(f.this.coI, f.this.cpn.akO(), 2);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    f.this.cpe.ahw();
                    break;
                case 2:
                    f.this.cpe.ahw();
                    break;
                case 3:
                case 6:
                    if (f.this.coI != null) {
                        f.this.coI.brg();
                    }
                    if (f.this.cpE != null) {
                        f.this.cpE.refresh();
                        break;
                    }
                    break;
            }
            f.this.agS();
            if (aVar == null || aVar.errorCode == 0) {
                if (f.this.coI != null) {
                    f.this.cpe.iT(i);
                    f.this.t(false, i == 5);
                    f.cpf = (System.nanoTime() - this.startTime) / 1000000;
                    if (aVar != null) {
                        f.cpg = aVar.gfj;
                    }
                } else {
                    return;
                }
            } else if (f.this.coI == null || com.baidu.tbadk.core.util.v.v(f.this.coI.getThreadList())) {
                f.this.a(aVar, false);
            } else if (aVar.gfi) {
                f.this.showToast(f.this.getPageContext().getResources().getString(d.l.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
            }
            if (f.this.coI.bqr() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11384"));
            }
            if (f.this.ccl > -1 && !f.this.cpL) {
                com.baidu.tieba.frs.g.h.a(f.this.cpn, f.this.ccl);
                f.this.ccl = -1L;
                f.this.cpL = true;
            }
            if (f.this.cpb && (f.this.cpp instanceof com.baidu.tieba.frs.entelechy.c.a) && ((com.baidu.tieba.frs.entelechy.c.a) f.this.cpp).aji() != null) {
                ((com.baidu.tieba.frs.entelechy.c.a) f.this.cpp).aji().jL(49);
                f.this.cpb = false;
            }
            f.this.aJO = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.k
        public void b(com.baidu.tieba.tbadkCore.g gVar) {
            if (gVar != null) {
                if ("normal_page".equals(f.this.cpn.akE()) || "frs_page".equals(f.this.cpn.akE()) || "book_page".equals(f.this.cpn.akE())) {
                    f.this.a(gVar);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE, gVar));
                }
            }
        }
    };
    private final CustomMessageListener cpX = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.frs.f.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                f.this.coI.a((com.baidu.tbadk.data.j) customResponsedMessage.getData());
                f.this.cpe.ahG().notifyDataSetChanged();
            }
        }
    };
    private final CustomMessageListener mMemListener = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_MEM) { // from class: com.baidu.tieba.frs.f.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && f.this.coI != null && (userData = f.this.coI.getUserData()) != null) {
                userData.setIsMem(num.intValue());
                if (num.intValue() != 0) {
                    f.this.cpo.f(num);
                }
            }
        }
    };
    private final com.baidu.tieba.frs.mc.j cpY = new com.baidu.tieba.frs.mc.j() { // from class: com.baidu.tieba.frs.f.6
        @Override // com.baidu.tieba.frs.mc.j
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.f> arrayList, boolean z3) {
            if (f.this.cps != null && f.this.cpn != null && f.this.cpn.akS() && z && !z2 && !z3) {
                f.this.cps.jF(i2);
            }
        }
    };
    public final View.OnTouchListener aMA = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.f.7
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (f.this.cpI != null) {
                f.this.cpI.onTouch(view, motionEvent);
            }
            if (f.this.cpu != null && f.this.cpu.ahY() != null) {
                f.this.cpu.ahY().onTouchEvent(motionEvent);
            }
            if (f.this.bjr != null) {
                f.this.bjr.d(view, motionEvent);
            }
            f.this.cpZ = true;
            if (f.this.cpo != null) {
                f.this.cpo.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private final CustomMessageListener cqa = new CustomMessageListener(CmdConfigCustom.CMD_GOTOLIVE_HOST_UPGRADE) { // from class: com.baidu.tieba.frs.f.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "photolive_hostLevel", -1) != -1 && f.this.coI.aOV() != null) {
                f.this.coI.aOV().setCanAddPhotoLivePost(true);
            }
        }
    };
    private final CustomMessageListener cqb = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.frs.f.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11455").ad("obj_locate", "frs"));
                    com.baidu.tbadk.core.util.au.wd().c(f.this.getPageContext(), new String[]{str});
                }
            }
        }
    };
    public final View.OnClickListener cqc = new View.OnClickListener() { // from class: com.baidu.tieba.frs.f.11
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (f.this.cpe == null || view != f.this.cpe.ahu() || f.this.getActivity() == null) {
                if (f.this.coI != null && f.this.coI.aOV() != null) {
                    if (f.this.cpe == null || view != f.this.cpe.ahA()) {
                        if (f.this.cpe != null && view == f.this.cpe.ahB()) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12402").ad("fid", f.this.coI.aOV().getId()).ad(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()).ad(ImageViewerConfig.FORUM_NAME, f.this.coI.aOV().getName()));
                            if (!StringUtils.isNull(f.this.coI.aOV().getName())) {
                                f.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PostSearchActivityConfig(f.this.getPageContext().getPageActivity(), f.this.coI.aOV().getName(), f.this.coI.aOV().getId())));
                                return;
                            }
                            return;
                        }
                    } else if (!StringUtils.isNull(f.this.coI.aOV().getId())) {
                        if (f.this.coI.aOV() != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12046").ad("fid", f.this.coI.aOV().getId()).r("obj_locate", f.this.ahi() ? 1 : 2));
                        }
                        f.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(f.this.getPageContext().getPageActivity(), f.this.coI.aOV().getId(), ForumDetailActivityConfig.FromType.FRS)));
                        return;
                    } else {
                        return;
                    }
                }
                if (view.getId() == d.h.game_activity_egg_layout && com.baidu.adp.lib.util.k.hz()) {
                    TiebaStatic.log("c10853");
                    if (f.this.cpe.ahD()) {
                        f.this.cpe.ahE();
                        return;
                    }
                    String activityUrl = f.this.coI.aOV().getYuleData().th().getActivityUrl();
                    if (!StringUtils.isNull(activityUrl)) {
                        com.baidu.tbadk.browser.a.U(f.this.getPageContext().getPageActivity(), activityUrl);
                        return;
                    }
                    return;
                }
                return;
            }
            f.this.getActivity().finish();
        }
    };
    private final AbsListView.OnScrollListener cqd = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.f.13
        private int cqk = 0;
        private int bcY = 0;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (f.this.aMz != null && f.this.isPrimary()) {
                f.this.aMz.a(absListView, this.cqk, i, i2, i3);
            }
            if (f.this.cpp != null) {
                f.this.cpp.a(absListView, i, i2, i3, f.this.cpo.alP());
            }
            if (f.this.cpy != null) {
                f.this.cpy.alt();
            }
            if (f.this.cps != null) {
                f.this.cps.ald();
            }
            if (f.this.cpJ != null) {
                f.this.cpJ.onScroll(absListView, i, i2, i3);
            }
            if (f.this.coI != null && f.this.cpe != null && f.this.cpe.ahG() != null) {
                this.cqk = i;
                this.bcY = (i + i2) - 1;
                f.this.cpe.ao(this.cqk, this.bcY);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (f.this.cpo != null) {
                f.this.cpo.setScrollState(i);
            }
            if (f.this.aMz != null && f.this.isPrimary()) {
                f.this.aMz.onScrollStateChanged(absListView, i);
            }
            if ((i == 2 || i == 1) && !f.this.cpj) {
                f.this.cpj = true;
                f.this.cpe.ahI();
            }
            if (f.this.cpk == null && !f.this.ahi()) {
                f.this.cpk = new com.baidu.tbadk.l.d();
                f.this.cpk.fi(1000);
            }
            if (i == 0) {
                com.baidu.tieba.card.u.XY().dI(true);
                f.this.cpe.an(this.cqk, this.bcY);
            }
            if (f.this.cpJ != null) {
                f.this.cpJ.onScrollStateChanged(absListView, i);
            }
            if (f.this.cpk != null) {
                f.this.cpk.Ge();
            }
            if (i == 0) {
                com.baidu.tieba.frs.g.h.a(f.this.cpe, f.this.coI, f.this.getForumId(), false, null);
            }
        }
    };
    private final b cqe = new b() { // from class: com.baidu.tieba.frs.f.14
        @Override // com.baidu.tieba.frs.b
        public void a(int i, int i2, View view, View view2, bj bjVar) {
            if (i != f.this.cpe.ahG().aiQ()) {
                if (i != f.this.cpe.ahG().aiR()) {
                    if (i != f.this.cpe.ahG().aiT()) {
                        if (i != f.this.cpe.ahG().ahQ()) {
                            if (i == f.this.cpe.ahG().aiS() && f.this.coI != null && f.this.coI.getUserData() != null && f.this.coI.getUserData().isBawu()) {
                                final String bqK = f.this.coI.bqK();
                                if (!com.baidu.tbadk.core.util.am.isEmpty(bqK) && f.this.coI.aOV() != null) {
                                    com.baidu.tieba.c.a.a(f.this.getPageContext(), f.this.coI.aOV().getId(), f.this.coI.aOV().getName(), new a.InterfaceC0079a() { // from class: com.baidu.tieba.frs.f.14.1
                                        @Override // com.baidu.tieba.c.a.InterfaceC0079a
                                        public void WK() {
                                            com.baidu.tbadk.browser.a.T(f.this.getPageContext().getPageActivity(), bqK);
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10502").ad("fid", f.this.coI.aOV().getId()).ad(SapiAccountManager.SESSION_UID, f.this.coI.getUserData().getUserId()));
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        f.this.coV = bjVar;
                        com.baidu.tieba.frs.g.i.a(f.this, f.this.coV);
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10179").ad("fid", f.this.getForumId()));
                        return;
                    }
                    com.baidu.tieba.frs.g.i.A(f.this);
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak(i == f.this.cpe.ahG().aiT() ? "c10177" : "c10244").ad("fid", f.this.getForumId()));
                } else if (ax.aT(f.this.getPageContext().getPageActivity())) {
                    TiebaStatic.log("my_service_ck");
                    if (f.this.coI != null && f.this.coI.aOV() != null) {
                        ForumData aOV = f.this.coI.aOV();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(f.this.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(aOV.getId(), 0L), aOV.getName(), aOV.getImage_url(), 0)));
                    }
                }
            } else if (ax.aT(f.this.getActivity())) {
                TiebaStatic.log("forum_fortune_click");
                com.baidu.tieba.frs.g.i.a(f.this.getPageContext(), f.this.coI);
            }
        }
    };
    private final NoNetworkView.a bIz = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.f.15
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aM(boolean z) {
            if (f.this.cpn.akI() == 1 && z && !f.this.cpe.ahg()) {
                if (f.this.coI == null || com.baidu.tbadk.core.util.v.v(f.this.coI.getThreadList())) {
                    f.this.hideNetRefreshView(f.this.cpe.Xn());
                    f.this.showLoadingView(f.this.cpe.Xn(), true);
                    f.this.cpe.eN(false);
                    f.this.refresh();
                    return;
                }
                f.this.cpe.ahw();
            }
        }
    };
    private final CustomMessageListener cqf = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.f.16
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                com.baidu.tieba.frs.g.c.a(customResponsedMessage, f.this.cpe, f.this.coI);
            }
        }
    };
    private com.baidu.adp.widget.ListView.h cqg = new a();
    private ak cqh = new ak() { // from class: com.baidu.tieba.frs.f.17
        @Override // com.baidu.tieba.frs.ak
        public void a(int i, int i2, aq aqVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
            com.baidu.adp.lib.g.e.fQ().post(new Runnable() { // from class: com.baidu.tieba.frs.f.17.1
                @Override // java.lang.Runnable
                public void run() {
                    if (f.this.cpe != null && f.this.cpe.YS()) {
                        f.this.Nf();
                    }
                }
            });
        }
    };
    private CustomMessageListener cqi = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.frs.f.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    f.this.cpK = true;
                }
            }
        }
    };

    public com.baidu.tieba.frs.entelechy.b.b agE() {
        return this.cpw;
    }

    public com.baidu.adp.widget.ListView.h agF() {
        return this.cqg;
    }

    public com.baidu.tieba.frs.mc.e agG() {
        return this.cpz;
    }

    public com.baidu.tieba.frs.smartsort.b agH() {
        return this.cps;
    }

    @Override // com.baidu.tieba.frs.mc.k
    public FrsModelController agI() {
        return this.cpn;
    }

    @Override // com.baidu.tieba.frs.mc.k
    public com.baidu.tieba.frs.mc.d agJ() {
        return this.cpA;
    }

    @Override // com.baidu.tieba.frs.mc.k
    public com.baidu.tieba.frs.h.f agK() {
        return this.cpo;
    }

    public com.baidu.tieba.frs.entelechy.b.d agL() {
        return this.cpp;
    }

    public am agM() {
        return this.cpu;
    }

    @Override // com.baidu.tieba.frs.mc.k
    public i agN() {
        return this.cpe;
    }

    @Override // com.baidu.tieba.frs.al
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.al
    public String getForumName() {
        return this.coW;
    }

    public void setForumName(String str) {
        this.coW = str;
    }

    public void setFrom(String str) {
        this.aiP = str;
    }

    public String getFrom() {
        return this.aiP;
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
        if (this.cpA == null) {
            return 1;
        }
        return this.cpA.getPn();
    }

    public int getPn() {
        if (this.cpA == null) {
            return 1;
        }
        return this.cpA.getPn();
    }

    public void setPn(int i) {
        if (this.cpA != null) {
            this.cpA.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.cpA != null) {
            this.cpA.setHasMore(i);
        }
    }

    public int agO() {
        if (this.cpA == null) {
            return -1;
        }
        return this.cpA.agO();
    }

    public boolean agP() {
        return this.cpc;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d.a aVar, boolean z) {
        this.cpe.ahr();
        if (aVar == null) {
            showNetRefreshView(this.cpe.Xn(), TbadkCoreApplication.getInst().getString(d.l.error_unkown_try_again), true);
        } else if (aVar.gfi) {
            if (340001 == aVar.errorCode) {
                showNetRefreshViewNoClick(this.cpe.Xn(), TbadkCoreApplication.getInst().getString(d.l.net_error_text, new Object[]{aVar.errorMsg, Integer.valueOf(aVar.errorCode)}), true);
            } else {
                showNetRefreshView(this.cpe.Xn(), TbadkCoreApplication.getInst().getString(d.l.net_error_text, new Object[]{aVar.errorMsg, Integer.valueOf(aVar.errorCode)}), true);
            }
        } else if (340001 == aVar.errorCode) {
            showNetRefreshViewNoClick(this.cpe.Xn(), aVar.errorMsg, true);
        } else {
            showNetRefreshView(this.cpe.Xn(), aVar.errorMsg, true);
        }
        if (ahi()) {
            setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.k.g(TbadkCoreApplication.getInst(), d.f.ds280));
        } else {
            setNetRefreshViewEmotionDefMarginTop();
        }
    }

    public void agQ() {
        hideLoadingView(this.cpe.Xn());
        this.cpe.ahC();
        if (this.cpe.ahp() instanceof com.baidu.tieba.frs.tab.c) {
            ((com.baidu.tieba.frs.tab.c) this.cpe.ahp()).aln();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agR() {
        if (agO() == 0 && com.baidu.tbadk.core.util.v.v(this.coI.bqx())) {
            if (com.baidu.tbadk.core.util.v.v(this.coI.getThreadList())) {
                this.cpe.Zc();
                return;
            } else {
                this.cpe.Xv();
                return;
            }
        }
        this.cpe.Xt();
    }

    public void a(ErrorData errorData) {
        agQ();
        this.cpe.ahw();
        d.a akF = this.cpn.akF();
        boolean v = com.baidu.tbadk.core.util.v.v(this.coI.getThreadList());
        if (akF != null && v) {
            if (v) {
                if (this.cpn.akG() != 0) {
                    this.cpn.akM();
                    this.cpe.ahw();
                } else {
                    a(akF, false);
                }
                this.cpe.u(this.coI.bru(), false);
                return;
            } else if (akF.gfi) {
                this.cpe.u(true, false);
                showToast(getPageContext().getResources().getString(d.l.net_error_text, akF.errorMsg, Integer.valueOf(akF.errorCode)));
                return;
            } else {
                return;
            }
        }
        a(akF, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agS() {
        if (this.coI == null || this.coI.aOV() != null) {
            this.cpe.ahF();
        } else if (this.coI.aOV().getYuleData() != null && this.coI.aOV().getYuleData().tg()) {
            TiebaStatic.log("c10852");
            this.cpe.a(this.coI.aOV().getYuleData().th());
        } else {
            this.cpe.ahF();
        }
    }

    private void s(boolean z, boolean z2) {
        if (this.cpn != null && this.coI != null && this.cpe != null && z) {
            if (!this.cpn.akS() && this.cpn.akI() == 1) {
                if (!this.cpn.akQ()) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        this.coI.brn();
                        this.coI.brk();
                    }
                    this.coI.brl();
                    this.coI.brm();
                }
                boolean z3 = false;
                if (this.cpe.ahG().m(com.baidu.tieba.card.data.p.bNz)) {
                    z3 = this.coI.brq();
                }
                if (!z3) {
                    this.coI.bro();
                }
                if (TbadkCoreApplication.getInst().isRecAppExist()) {
                    this.coI.a(this);
                }
                if (!this.cpe.ahG().m(bj.Yl)) {
                    this.coI.brh();
                }
                this.coI.brr();
                this.coI.brs();
            }
            this.coI.bri();
            this.coI.brf();
            if (this.cpe.ahG().m(com.baidu.tieba.g.b.cNj)) {
                this.coI.mE(z2);
            }
        }
    }

    public boolean agT() {
        if (this.cpp != null && this.cpe != null) {
            this.cpp.b(this.cpe.getListView());
        }
        if (this.cpo != null && this.cpn != null) {
            this.cpo.a(this.cpn.akE(), this.coI);
        }
        boolean z = false;
        if (this.coI != null) {
            z = this.coI.brv();
        }
        eG(z);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iP(int i) {
        an anVar = null;
        agT();
        ahc();
        try {
            if (this.coI != null) {
                this.cpe.a((ArrayList<com.baidu.adp.widget.ListView.f>) null, this.coI);
                this.cpo.jT(1);
                this.cpe.ahz();
                this.cpp.a(this.cpe.getListView(), this.coI, this.cpn.akO());
                com.baidu.tieba.frs.tab.d a2 = a(this.cpp.ajb(), this.coI.bqM());
                if (a2 != null && !TextUtils.isEmpty(a2.url)) {
                    anVar = new an();
                    anVar.csj = a2.url;
                    anVar.stType = a2.name;
                }
                this.cpn.a(this.coI.bqM(), 0, anVar);
                this.cpp.fb(false);
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
            if (dVar != null && dVar.cBp == i) {
                return dVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(boolean z, boolean z2) {
        AlaLiveNotify bqZ;
        try {
            if (this.coI != null && this.cpp != null && this.cpn != null) {
                if (!this.cpe.ahG().m(bj.Yl)) {
                    this.coI.brh();
                }
                boolean v = com.baidu.tbadk.core.util.v.v(this.coI.bra());
                this.cpe.eK(v);
                if (!v) {
                    if (this.cpJ == null) {
                        this.cpJ = new com.baidu.tieba.frs.h.e(this, (NoPressedRelativeLayout) this.mRootView);
                    }
                    if (this.bjr == null) {
                        this.bjr = new com.baidu.tieba.frs.gametab.a(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
                    }
                } else {
                    this.cpJ = null;
                    this.bjr = null;
                }
                if (this.coI.aOV() != null) {
                    this.coW = this.coI.aOV().getName();
                    this.forumId = this.coI.aOV().getId();
                }
                if (this.coI.brv()) {
                    this.cpp.a(this.cpe.getListView(), this.coI, this.cpn.akO());
                }
                if (z) {
                    s(true, z);
                } else {
                    s(this.cpm, z);
                }
                agT();
                if (this.cpw != null) {
                    this.cpw.a(this.cpo, this.coI);
                }
                if (this.coI.qD() != null) {
                    setHasMore(this.coI.qD().qz());
                }
                ArrayList<com.baidu.adp.widget.ListView.f> a2 = this.cpA.a(z2, true, this.coI.getThreadList(), null, z);
                if (a2 != null) {
                    this.coI.aA(a2);
                }
                if (this.cpn.akI() == 1) {
                    agZ();
                    if (!z && this.cpn.getPn() == 1 && (bqZ = ahf().bqZ()) != null) {
                        new com.baidu.tieba.frs.d.a().a(this, bqZ);
                    }
                }
                this.coK = this.coI.akK();
                if (this.cpa != null) {
                    this.coZ = true;
                    this.cpa.tq(this.coK);
                    com.baidu.tieba.frs.g.a.a(this, this.coI.aOV(), this.coI.getThreadList(), this.coZ, getPn());
                }
                if (this.cpy != null) {
                    this.cpy.ax(this.cpp.ajc());
                }
                agQ();
                this.cpe.ahs();
                this.cpe.u(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.g gVar) {
        try {
            if (!this.cpi && gVar != null && this.coI != null) {
                this.coI.e(gVar);
                t(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void eG(boolean z) {
        if (this.cpn != null) {
            f(z, this.cpn.akE());
        } else {
            f(z, "normal_page");
        }
    }

    private void f(boolean z, String str) {
        eH("frs_page".equals(str));
        if (this.cpw != null) {
            this.cpw.a(z, this.cpp, this.cpo, this.cpe, this.coI);
        }
    }

    public void eH(boolean z) {
        if (this.cpB != null) {
            this.cpB.a(this.cpe, z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(d.j.frs_activity, viewGroup, false);
            this.coQ = new com.baidu.tieba.frs.entelechy.b();
            this.cpw = this.coQ.ait();
            this.cpo = new com.baidu.tieba.frs.h.f(this, this.coQ);
            this.cpp = this.coQ.y(this);
            Intent intent = this.cpG != null ? this.cpG : getActivity().getIntent();
            if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                this.coS = true;
            }
            this.cpe = new i(this, this.cqc, this.coQ, this.coS);
            this.cpe.setHeaderViewHeight(this.cpH);
        } else if (this.mRootView.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            this.cpe.ahL();
        }
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Intent intent = this.cpG != null ? this.cpG : getActivity().getIntent();
        this.ccl = System.currentTimeMillis();
        if (intent != null) {
            this.cpb = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.ccl = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            M(intent);
        }
        this.Wo = System.currentTimeMillis();
        this.aJG = this.Wo - this.ccl;
        this.cpa = new com.baidu.tieba.tbadkCore.data.e("frs", com.baidu.tieba.tbadkCore.data.e.ghG);
        this.cpn = new FrsModelController(this, this.cpW);
        this.cpn.a(this.cpO);
        this.cpn.init();
        if (intent != null) {
            this.cpn.i(intent.getExtras());
        } else if (bundle != null) {
            this.cpn.i(bundle);
        } else {
            this.cpn.i(null);
        }
        this.cpp.as(this.cpe.Xn());
        if (intent != null) {
            this.cpo.l(intent.getExtras());
        } else if (bundle != null) {
            this.cpo.l(bundle);
        } else {
            this.cpo.l((Bundle) null);
        }
        this.cpd = getVoiceManager();
        this.cpD = new h(getPageContext(), this);
        initUI();
        initData(bundle);
        if (this.aiP != null && this.aiP.equals("from_tieba_kuang")) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12264").r("obj_type", 1).ad(ImageViewerConfig.FORUM_NAME, this.cpn.getForumName()));
            KuangFloatingViewController.getInstance().setNeedShowFloatingView(true);
            KuangFloatingViewController.getInstance().showFloatingView();
        }
        if (!ahi()) {
            this.cpu = new am(getActivity(), this.cpe, this.cpo);
            this.cpu.eS(true);
        }
        this.cpd = getVoiceManager();
        if (this.cpd != null) {
            this.cpd.onCreate(getPageContext());
        }
        new com.baidu.tieba.frs.mc.h();
        this.cpA = new com.baidu.tieba.frs.mc.d(this, this.cpY);
        this.cps = new com.baidu.tieba.frs.smartsort.b(this);
        this.cpB = new com.baidu.tieba.frs.h.h(this);
        this.createTime = System.currentTimeMillis() - this.Wo;
        this.cpy = new com.baidu.tieba.frs.h.a(getPageContext(), this.cpn.akP());
        this.cpt = new com.baidu.tieba.frs.mc.c(this);
        this.cpz = new com.baidu.tieba.frs.mc.e(this);
        this.cpq = new com.baidu.tieba.frs.mc.g(this);
        this.cpr = new com.baidu.tieba.frs.mc.b(this);
        this.cpC = new com.baidu.tieba.frs.mc.a(this);
        this.cpE = new com.baidu.tieba.frs.h.c(this);
        this.cpF = new com.baidu.tieba.frs.mc.f(this, getUniqueId());
        registerListener(this.mMemListener);
        registerListener(this.cpU);
        registerListener(this.cqa);
        registerListener(this.cpT);
        registerListener(this.cpX);
        registerListener(this.cpQ);
        registerListener(this.cpR);
        registerListener(this.cpS);
        registerListener(this.cpM);
        registerListener(this.cpN);
        registerListener(this.cqi);
        registerListener(this.cpV);
        this.cpe.eN(false);
        if (!ahi()) {
            showLoadingView(this.cpe.Xn(), true);
            this.cpn.q(3, true);
        }
        super.onActivityCreated(bundle);
    }

    @Override // com.baidu.tieba.frs.ah
    public void agU() {
        if (isAdded() && this.bjS && !isLoadingViewAttached()) {
            showLoadingView(this.cpe.Xn(), true);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void agV() {
        if (isAdded() && this.bjS && isLoadingViewAttached()) {
            hideLoadingView(this.cpe.Xn());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (ahi()) {
            showLoadingView(this.cpe.Xn(), true);
            this.cpe.iS(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.cpn.q(3, true);
            getListView().setSelection(0);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void setHeaderViewHeight(int i) {
        this.cpH = i;
        if (this.cpe != null) {
            this.cpe.setHeaderViewHeight(this.cpH);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void setRecommendFrsNavigationAnimDispatcher(r rVar) {
        if (rVar != null) {
            this.aMz = rVar.Ho();
            this.cpI = rVar.Hp();
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void showFloatingView() {
        if (this.aMz != null) {
            this.aMz.cg(true);
        }
    }

    private void M(Intent intent) {
        if (intent != null) {
            if (!com.baidu.tieba.frs.g.f.a(this, getForumName(), "from", intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false)) && getActivity() != null) {
                getActivity().finish();
                return;
            }
        }
        if (intent != null && intent.getData() != null) {
            Uri data = intent.getData();
            this.coW = data.getQueryParameter("name");
            this.aiP = data.getQueryParameter("from");
            if (!StringUtils.isNull(this.coW)) {
                intent.putExtra("name", this.coW);
            }
            if (!StringUtils.isNull(this.aiP)) {
                intent.putExtra("from", this.aiP);
            }
            TiebaStatic.log("c10105");
        }
        if (StringUtils.isNull(this.coW)) {
            this.coW = com.baidu.tieba.frs.g.i.P(intent);
            if (!StringUtils.isNull(this.coW)) {
                intent.putExtra("name", this.coW);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.cpd = getVoiceManager();
        if (this.cpd != null) {
            this.cpd.onStart(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        Intent intent;
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.cqf);
        if (bundle != null) {
            this.coW = bundle.getString("name");
            this.aiP = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
            this.coW = intent.getStringExtra("name");
            this.aiP = intent.getStringExtra("from");
            this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
        }
        if (TextUtils.isEmpty(this.aiP) || FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.aiP)) {
        }
        if (this.mIsLogin) {
            registerListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL, this.cqf);
        }
        this.cpo.l(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.cqi);
        if (this.cpd != null) {
            this.cpd.onDestory(getPageContext());
        }
        this.cpd = null;
        com.baidu.tieba.card.u.XY().dI(false);
        if (this.coI != null && this.coI.aOV() != null) {
            ac.ahU().bi(com.baidu.adp.lib.g.b.c(this.coI.aOV().getId(), 0L));
        }
        if (this.cpe != null) {
            com.baidu.tieba.frs.g.h.a(this.cpe, this.coI, getForumId(), false, null);
            this.cpe.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.cpk != null) {
                this.cpk.onDestroy();
            }
            this.cpe.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.cpn.onActivityDestroy();
        this.cpo.onActivityDestroy();
        if (this.cpl != null) {
            this.cpl.cancel(true);
            this.cpl = null;
        }
        if (this.cpn != null) {
            this.cpn.OO();
        }
        if (this.cpu != null) {
            this.cpu.Hn();
        }
        if (this.cpx != null) {
            this.cpx.destory();
        }
        if (this.cpy != null) {
            this.cpy.destory();
        }
        if (this.cps != null) {
            this.cps.onDestroy();
        }
        if (this.cpJ != null) {
            this.cpJ.onDestory();
        }
        com.baidu.tieba.recapp.d.a.bhI().bhK();
        com.baidu.tieba.frs.g.j.alq();
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.coW);
        bundle.putString("from", this.aiP);
        this.cpn.onSaveInstanceState(bundle);
        if (this.cpd != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            this.cpd.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.cpC != null) {
            this.cpC.onActivityResult(i, i2, intent);
        }
    }

    public void a(UpdateAttentionMessage updateAttentionMessage) {
        Message<?> message;
        if (updateAttentionMessage != null && updateAttentionMessage.isAttention() && updateAttentionMessage.isGod() && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(getUniqueId())) {
            if (this.cpx == null) {
                this.cpx = new com.baidu.tbadk.i.a(getPageContext());
            }
            this.cpx.aq(updateAttentionMessage.getData().toUid, getForumId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.cpe != null) {
            this.cpe.ahw();
            this.cpe.onResume();
        }
        this.cpp.a(this.cpP);
        this.cpq.fj(true);
        this.cpm = true;
        if (isNeedRefreshOnResume) {
            isNeedRefreshOnResume = false;
            this.cpe.startPullRefresh();
        } else if (coT) {
            coT = false;
            this.cpe.startPullRefresh();
        } else {
            if (this.cpd != null) {
                this.cpd.onResume(getPageContext());
            }
            this.cpe.eO(false);
            registerListener(this.cqb);
            if (this.cpK) {
                cm(6);
                this.cpK = false;
            }
            KuangFloatingViewController.getInstance().showFloatingView();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        refresh();
    }

    @Override // com.baidu.tieba.frs.ah
    public void N(Intent intent) {
        this.cpG = intent;
    }

    public boolean agW() {
        if (getActivity() == null) {
            return false;
        }
        Intent intent = this.cpG != null ? this.cpG : getActivity().getIntent();
        if (intent != null) {
            return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
        }
        return false;
    }

    public void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.coW = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.aiP = intent.getStringExtra("from");
            }
            this.coY = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.coY) {
                agX();
            }
            if (this.aiP != null && this.aiP.equals("from_tieba_kuang")) {
                KuangFloatingViewController.getInstance().setNeedShowFloatingView(true);
                KuangFloatingViewController.getInstance().showFloatingView();
            }
        }
    }

    private void agX() {
        this.cpe.startPullRefresh();
    }

    public void closeActivity() {
        com.baidu.tieba.frs.g.i.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.aiP);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.cpe.setTitle(this.coW);
        } else {
            this.cpe.setTitle("");
            this.mFlag = 1;
        }
        this.cpo.d(this.cpe.getListView());
        this.cpe.setOnAdapterItemClickListener(this.cqg);
        this.cpe.setOnScrollListener(this.cqd);
        this.cpe.c(this.bIz);
        this.cpe.ahG().a(this.cqe);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cpe.onChangeSkinType(i);
        this.cpo.jS(i);
        this.cpp.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.d.c
    public void lq() {
    }

    @Override // com.baidu.adp.widget.d.c
    public void lr() {
    }

    public void iQ(int i) {
        if (!this.mIsLogin) {
            if (this.coI != null && this.coI.qn() != null) {
                this.coI.qn().setIfpost(1);
            }
            if (i == 0) {
                ax.aS(getActivity());
            }
        } else if (this.coI != null) {
            if (i == 0) {
                if (!this.coU) {
                    com.baidu.tieba.frs.g.j.b(this, 0);
                    return;
                }
                TiebaStatic.log("c10152");
                com.baidu.tieba.frs.g.j.b(this, 4);
                return;
            }
            this.cpe.ahy();
        }
    }

    public void refresh() {
        cm(3);
    }

    public void cm(int i) {
        this.cpi = false;
        ahc();
        if (this.cpe.aho() != null) {
            this.cpe.aho().asj();
        }
        this.cpn.q(i, true);
    }

    private void agY() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.g.h.fR().d(new Runnable() { // from class: com.baidu.tieba.frs.f.10
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.sh(f.this.coW);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agZ() {
        ahc();
        try {
            if (this.coI != null) {
                this.cpe.NH();
                this.cpe.eJ(this.cpn.akJ());
                if (com.baidu.tieba.frs.h.f.i(this.coI) && !com.baidu.tieba.frs.h.f.h(this.coI)) {
                    this.cpe.ahJ();
                }
                if (this.coI.aOV() != null) {
                    this.coW = this.coI.aOV().getName();
                    this.forumId = this.coI.aOV().getId();
                }
                if (this.coI.qD() != null) {
                    setHasMore(this.coI.qD().qz());
                }
                this.cpe.setTitle(this.coW);
                this.cpe.setForumName(this.coW);
                TbadkCoreApplication.getInst().setDefaultBubble(this.coI.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.coI.getUserData().getBimg_end_time());
                agY();
                aha();
                ArrayList<com.baidu.adp.widget.ListView.f> threadList = this.coI.getThreadList();
                if (threadList != null) {
                    this.cpe.a(threadList, this.coI);
                    com.baidu.tieba.frs.g.c.j(this.cpe);
                    this.cpo.jT(getPageNum());
                    this.cpo.f(this.coI);
                    this.cpp.a(this.cpe.getListView(), this.coI, this.cpn.akO());
                    this.cpe.ahz();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void aha() {
        if (this.coI != null) {
            if (this.coI.aPj() == 1) {
                this.cpe.ahG().setFromCDN(true);
            } else {
                this.cpe.ahG().setFromCDN(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.cpq.fj(false);
        this.cpm = false;
        this.cpe.onPause();
        if (this.cpd != null) {
            this.cpd.onPause(getPageContext());
        }
        this.cpe.eO(true);
        if (this.cpy != null) {
            this.cpy.alt();
        }
        MessageManager.getInstance().unRegisterListener(this.cqb);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.u.XY().dI(false);
        if (this.coI != null && this.coI.aOV() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            com.baidu.tbadk.distribute.a.CF().a(getPageContext().getPageActivity(), "frs", this.coI.aOV().getId(), 0L);
        }
        if (this.cpd != null) {
            this.cpd.onStop(getPageContext());
        }
        com.baidu.tieba.frs.g.i.a(getListView());
        this.cpo.onActivityStop();
        s.Hr();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || this.cpe == null) {
            return false;
        }
        return this.cpe.ahv();
    }

    @Override // com.baidu.tieba.recapp.o
    public TbPageContext<?> yi() {
        return getPageContext();
    }

    @Override // com.baidu.tieba.recapp.o
    public void a(AdvertAppInfo advertAppInfo, String str) {
        com.baidu.tbadk.distribute.a.CF().a(advertAppInfo, this.forumId, 0L, "FRS", str, getPn());
    }

    @Override // com.baidu.tieba.recapp.o
    public void ahb() {
        agI().ahb();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.cpd == null) {
            this.cpd = VoiceManager.instance();
        }
        return this.cpd;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public BdListView getListView() {
        if (this.cpe == null) {
            return null;
        }
        return this.cpe.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void ahc() {
        if (this.cpd != null) {
            this.cpd.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> xp() {
        if (this.apf == null) {
            this.apf = UserIconBox.k(getPageContext().getPageActivity(), 8);
        }
        return this.apf;
    }

    public void ahd() {
        if (getFragmentActivity() != null && getFragmentActivity().getCurrentFocus() != null) {
            com.baidu.adp.lib.util.k.a(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.g onGetPreLoadListView() {
        return getListView();
    }

    @Override // com.baidu.tieba.frs.aj
    public NavigationBar ahe() {
        if (this.cpe == null) {
            return null;
        }
        return this.cpe.ahe();
    }

    /* loaded from: classes.dex */
    private final class a implements com.baidu.adp.widget.ListView.h {
        private a() {
        }

        @Override // com.baidu.adp.widget.ListView.h
        public void a(View view, com.baidu.adp.widget.ListView.f fVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            boolean z;
            if (bdUniqueId != null) {
                if (bdUniqueId == p.crA) {
                    if (f.this.cpe != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11752").ad("fid", f.this.forumId).ad("obj_locate", "1"));
                        f.this.cpe.startPullRefresh();
                    }
                } else if (fVar != null && (fVar instanceof bj)) {
                    bj bjVar = (bj) fVar;
                    if (bjVar.sm() == null || bjVar.sm().getGroup_id() == 0 || ax.aT(f.this.getActivity())) {
                        if ((bjVar.sf() != 1 && bjVar.sf() != 2) || ax.aT(f.this.getActivity())) {
                            if (bjVar.rO() != null) {
                                if (ax.aT(f.this.getActivity())) {
                                    String postUrl = bjVar.rO().getPostUrl();
                                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.k.hz()) {
                                        com.baidu.tbadk.browser.a.U(f.this.getActivity(), postUrl);
                                    }
                                }
                            } else if (bjVar.sx() != null) {
                                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                    ax.aS(f.this.getPageContext().getPageActivity());
                                    return;
                                }
                                com.baidu.tbadk.core.data.n sx = bjVar.sx();
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(f.this.getPageContext().getPageActivity(), sx.getCartoonId(), sx.getChapterId(), 2)));
                            } else if (bjVar.getThreadType() == 47 && bjVar.rw() == 1 && !com.baidu.tbadk.core.util.am.isEmpty(bjVar.rI())) {
                                com.baidu.tbadk.browser.a.T(f.this.getPageContext().getPageActivity(), bjVar.rI());
                            } else {
                                com.baidu.tieba.tbadkCore.util.f readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                                if (readThreadHistory != null && !readThreadHistory.sn(bjVar.getId())) {
                                    readThreadHistory.sm(bjVar.getId());
                                }
                                final String rI = bjVar.rI();
                                if (rI == null || rI.equals("")) {
                                    z = false;
                                } else {
                                    new Thread(new Runnable() { // from class: com.baidu.tieba.frs.f.a.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(rI);
                                            xVar.vj().wf().mIsNeedAddCommenParam = false;
                                            xVar.vj().wf().mIsUseCurrentBDUSS = false;
                                            xVar.uc();
                                        }
                                    }).start();
                                    z = true;
                                }
                                String tid = bjVar.getTid();
                                if (tid == null) {
                                    tid = "";
                                }
                                if (bjVar.rw() == 2 && !tid.startsWith("pb:")) {
                                    com.baidu.tbadk.core.util.au.wd().c(f.this.getPageContext(), new String[]{tid, "", null});
                                } else if (bjVar.getThreadType() == 33 || (bjVar instanceof ay)) {
                                    String str = bjVar.getThreadType() == 33 ? "c10245" : "c10180";
                                    if (f.this.cpn.akI() == 5) {
                                        str = "c10387";
                                    }
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak(str).ad("fid", f.this.forumId));
                                    com.baidu.tieba.frs.g.i.c(f.this, bjVar);
                                    if (f.this.coI != null && f.this.coI.aOV() != null) {
                                        com.baidu.tieba.frs.f.a aVar = new com.baidu.tieba.frs.f.a();
                                        aVar.cEh = f.this.coI.gfK == 1;
                                        aVar.cEj = f.this.coI.aOV().getId();
                                        aVar.cEi = f.this.agI().akO();
                                        com.baidu.tieba.frs.f.b.alj().a(aVar, bjVar, 1);
                                    }
                                } else {
                                    if (tid.startsWith("pb:")) {
                                        bjVar.setId(tid.substring(3));
                                    }
                                    if (bdUniqueId.getId() == bj.Zs.getId()) {
                                        com.baidu.tieba.frs.g.h.a(bjVar.ri());
                                        com.baidu.tieba.frs.g.i.b(f.this, bjVar);
                                        return;
                                    }
                                    com.baidu.tieba.frs.g.i.a(f.this, bjVar, i, z);
                                    com.baidu.tieba.frs.g.h.a(f.this, f.this.coI, bjVar);
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
        if (com.baidu.adp.lib.util.k.hz()) {
            hideNetRefreshView(this.cpe.Xn());
            showLoadingView(this.cpe.Xn(), true);
            this.cpe.eN(false);
            this.cpn.q(3, true);
        }
    }

    public com.baidu.tieba.tbadkCore.i ahf() {
        return this.coI;
    }

    public boolean ahg() {
        return this.cpe.ahg();
    }

    public void O(Object obj) {
        if (this.cpt != null && this.cpt.cDb != null) {
            this.cpt.cDb.f(obj);
        }
    }

    public void P(Object obj) {
        if (this.cpt != null && this.cpt.cDc != null) {
            this.cpt.cDc.f(obj);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.k.hz()) {
            this.cpe.Zc();
        } else if (this.cpn.akI() == 1) {
            Nm();
            Nf();
        } else if (this.cpn.hasMore()) {
            Nf();
        }
    }

    public void kA(String str) {
        Nm();
        showToast(str);
    }

    public void G(ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        Nm();
        if (!com.baidu.tbadk.core.util.v.v(arrayList)) {
            if (!this.cpn.akS() && TbadkCoreApplication.getInst().isRecAppExist() && this.cpn.akI() == 1) {
                this.coI.a(this, arrayList);
            }
            ArrayList<com.baidu.adp.widget.ListView.f> a2 = this.cpA.a(false, false, arrayList, this.cpa);
            if (a2 != null) {
                this.coI.aA(a2);
                this.cpe.a(a2, this.coI);
            }
            if (this.cpn != null) {
                com.baidu.tieba.frs.f.b.a(this.coI, this.cpn.akO(), 2);
            }
        }
    }

    private void Nm() {
        if (agO() == 1 || this.cpA.aO(this.coI.bqx())) {
            this.cpe.Xt();
        } else if (com.baidu.tbadk.core.util.v.v(this.coI.getThreadList())) {
            this.cpe.Zc();
        } else {
            this.cpe.Xv();
        }
    }

    @Override // com.baidu.tieba.frs.mc.k
    public void Nf() {
        if (this.cpA != null) {
            this.cpA.a(this.coW, this.forumId, this.coI);
        }
    }

    public void ahh() {
        if (!com.baidu.tbadk.core.util.ab.d(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.ai.c(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return ahi() ? "a034" : "a006";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (!ahi()) {
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

    @Override // com.baidu.b.a.a.InterfaceC0023a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        com.baidu.tieba.frs.g.i.a(this, i, strArr, iArr);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(getForumId(), 0L));
        }
        return pageStayDurationItem;
    }

    public void eI(boolean z) {
        if (this.cpu != null) {
            this.cpu.eS(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.cpv.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a fJ(int i) {
        return this.cpv.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        this.cpD.b(bVar);
    }

    public boolean ahi() {
        return this.coS;
    }

    @Override // com.baidu.tieba.frs.ah
    public void ahj() {
        if (this.cpe != null) {
            showFloatingView();
            this.cpe.getListView().setSelection(0);
            this.cpe.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public ForumWriteData ahk() {
        if (this.coI == null || this.coI.aOV() == null) {
            return null;
        }
        ForumData aOV = this.coI.aOV();
        ForumWriteData forumWriteData = new ForumWriteData(aOV.getId(), aOV.getName(), aOV.getPrefixData(), this.coI.qn());
        forumWriteData.setForumLevel(aOV.getUser_level());
        forumWriteData.setAvatar(this.coI.aOV().getImage_url());
        return forumWriteData;
    }

    @Override // com.baidu.tieba.frs.ah
    public void xc() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void cK(boolean z) {
        if (this.cpe != null) {
            this.cpe.cK(z);
        }
    }
}
