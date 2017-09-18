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
public class f extends BaseFragment implements BdListView.e, d.c, a.InterfaceC0022a, UserIconBox.b, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, ah, aj, al, com.baidu.tieba.frs.mc.k, com.baidu.tieba.recapp.o {
    private q aMw;
    private com.baidu.adp.lib.e.b<TbImageView> apd;
    private com.baidu.tieba.frs.gametab.a bjq;
    private com.baidu.tieba.frs.entelechy.b cpI;
    private boolean cpM;
    public bj cpN;
    private com.baidu.tieba.tbadkCore.data.e cpS;
    private VoiceManager cpV;
    private View.OnTouchListener cqA;
    private com.baidu.tieba.frs.h.e cqB;
    private boolean cqC;
    private boolean cqR;
    private f.a cqd;
    private FrsModelController cqf;
    private com.baidu.tieba.frs.h.f cqg;
    private com.baidu.tieba.frs.entelechy.b.d cqh;
    private com.baidu.tieba.frs.mc.g cqi;
    private com.baidu.tieba.frs.mc.b cqj;
    private com.baidu.tieba.frs.smartsort.b cqk;
    private com.baidu.tieba.frs.mc.c cql;
    private am cqm;
    private com.baidu.tieba.frs.entelechy.b.b cqo;
    private com.baidu.tbadk.i.a cqp;
    private com.baidu.tieba.frs.h.a cqq;
    private com.baidu.tieba.frs.mc.e cqr;
    private com.baidu.tieba.frs.mc.d cqs;
    private com.baidu.tieba.frs.h.h cqt;
    private com.baidu.tieba.frs.mc.a cqu;
    private h cqv;
    public com.baidu.tieba.frs.h.c cqw;
    private com.baidu.tieba.frs.mc.f cqx;
    private Intent cqy;
    private int cqz;
    public View mRootView;
    private static boolean isNeedRefreshOnResume = false;
    public static boolean cpL = false;
    public static volatile long cpX = 0;
    public static volatile long cpY = 0;
    public static volatile int cpZ = 0;
    public boolean cpJ = false;
    private boolean cpK = false;
    public String cpO = null;
    public String aiO = null;
    public int mFlag = 0;
    private boolean cpP = false;
    private boolean cpQ = false;
    private String mThreadId = null;
    public String forumId = null;
    private int cpC = 0;
    private boolean cpR = false;
    private boolean cpT = false;
    private boolean cpU = false;
    private i cpW = null;
    public final bj bgF = null;
    private com.baidu.tieba.tbadkCore.i cpA = new com.baidu.tieba.tbadkCore.i();
    public long cdd = -1;
    public long aJL = 0;
    public long aJD = 0;
    public long createTime = 0;
    public long Wo = -1;
    private boolean cqa = false;
    private boolean cqb = false;
    public com.baidu.tbadk.l.d cqc = null;
    private boolean cqe = true;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> cqn = new SparseArray<>();
    private boolean bjR = true;
    private boolean cqD = false;
    private final CustomMessageListener cqE = new CustomMessageListener(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED) { // from class: com.baidu.tieba.frs.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof bj) {
                    com.baidu.tieba.frs.g.h.a(f.this.cpW, f.this.cpA, f.this.getForumId(), true, (bj) data);
                }
            }
        }
    };
    private CustomMessageListener cqF = new CustomMessageListener(CmdConfigCustom.CMD_CLOSE_GAME_RANK_CARD) { // from class: com.baidu.tieba.frs.f.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (f.this.cpA != null) {
                f.this.cpA.brA();
                if (f.this.cpW != null) {
                    f.this.cpW.Zm();
                }
            }
        }
    };
    private final ak cqG = new ak() { // from class: com.baidu.tieba.frs.f.19
        @Override // com.baidu.tieba.frs.ak
        public void a(int i, int i2, aq aqVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
            f.this.ahb();
            if (f.this.cqo != null) {
                f.this.cqg.fm(f.this.cqo.jh(i));
            }
            d.a aVar = new d.a();
            if (aqVar != null) {
                aVar.isSuccess = aqVar.errCode == 0;
                aVar.errorCode = aqVar.errCode;
                aVar.errorMsg = aqVar.errMsg;
                if (aVar.isSuccess) {
                    if (com.baidu.tbadk.core.util.v.v(arrayList)) {
                        f.this.cpW.Zn();
                    } else if (aqVar.hasMore) {
                        f.this.cpW.XE();
                    } else if (aqVar.ctf) {
                        f.this.cpW.XG();
                    } else {
                        f.this.cpW.Zn();
                    }
                }
            } else {
                aqVar = new aq();
                aqVar.pn = 1;
                aqVar.hasMore = false;
                aqVar.ctf = false;
            }
            if (i == 1) {
                f.this.cqe = true;
                f.this.cqO.a(f.this.cqf.getType(), false, aVar);
            } else {
                f.this.a(aVar, true);
                if (f.this.cqf.akd() != null) {
                    f.this.cpA = f.this.cqf.akd();
                }
                f.this.ahk();
            }
            if (f.this.cqZ != null) {
                f.this.cqZ.a(i, i2, aqVar, arrayList);
            }
        }
    };
    private ai cqH = new ai() { // from class: com.baidu.tieba.frs.f.20
        @Override // com.baidu.tieba.frs.ai
        public void a(ak akVar) {
        }

        @Override // com.baidu.tieba.frs.ai
        public void a(int i, int i2, an anVar) {
            if (i != 1) {
                com.baidu.tieba.card.u.Yj().dJ(false);
            }
            if (i == 1) {
                f.this.cpW.eN(true);
                f.this.cpW.eM(false);
            } else {
                f.this.cpW.eO(true);
                f.this.cpW.eM(true);
            }
            f.this.ahn();
            f.this.cqf.a(i, i2, anVar);
        }

        @Override // com.baidu.tieba.frs.ai
        public void init() {
        }

        @Override // com.baidu.tieba.frs.ai
        public void OQ() {
        }
    };
    private CustomMessageListener cqI = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIVE_COUNT) { // from class: com.baidu.tieba.frs.f.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                ((com.baidu.tieba.frs.entelechy.c.a) f.this.cqh).jj(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    };
    private CustomMessageListener cqJ = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_LIVE_START) { // from class: com.baidu.tieba.frs.f.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && ((Integer) customResponsedMessage.getData()).intValue() == 51 && f.this.cpA != null) {
                com.baidu.tieba.frs.g.j.a(f.this.cpA, f.this.getPageContext());
            }
        }
    };
    private final CustomMessageListener cqK = new CustomMessageListener(CmdConfigCustom.CMD_FRS_SELECT_ALA_LIVE_TAB) { // from class: com.baidu.tieba.frs.f.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (f.this.cqh instanceof com.baidu.tieba.frs.entelechy.c.a) && ((com.baidu.tieba.frs.entelechy.c.a) f.this.cqh).ajt() != null) {
                ((com.baidu.tieba.frs.entelechy.c.a) f.this.cqh).ajt().jN(49);
            }
        }
    };
    private final CustomMessageListener cqL = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.frs.f.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && f.this.cpA != null && f.this.cpA.aPg() != null) {
                SignData signData = (SignData) customResponsedMessage.getData();
                int user_level = f.this.cpA.aPg().getUser_level();
                if (signData.forumId != null && signData.forumId.equals(f.this.cpA.aPg().getId())) {
                    f.this.cpA.d(signData);
                    f.this.cqg.g(f.this.cpA);
                    if (f.this.cqg.alV()) {
                        i = f.this.cpA.aPg().getUser_level();
                        if (user_level >= i) {
                            i++;
                        }
                    } else {
                        i = user_level;
                    }
                    TbadkCoreApplication.getInst().addSignedForum(f.this.cpA.aPg().getName(), signData.sign_bonus_point, i);
                }
            }
        }
    };
    private final CustomMessageListener cqM = new CustomMessageListener(CmdConfigCustom.CMD_FRS_EXPERIENCE_TIP) { // from class: com.baidu.tieba.frs.f.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.o) && f.this.cpA != null) {
                f.this.cpA.c((com.baidu.tieba.tbadkCore.o) customResponsedMessage.getData());
                f.this.cqg.f(f.this.cpA);
                f.this.cqh.a(f.this.cpW.getListView(), f.this.cpA, f.this.cqf.akZ());
            }
        }
    };
    private CustomMessageListener cqN = new CustomMessageListener(CmdConfigCustom.CMD_STORY_READ_CACHE) { // from class: com.baidu.tieba.frs.f.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.story.process.b)) {
                com.baidu.tieba.story.process.b bVar = (com.baidu.tieba.story.process.b) customResponsedMessage.getData();
                if (f.this.forumId != null && f.this.forumId.equals(String.valueOf(bVar.forumId)) && bVar.state == 3 && f.this.ahq() != null && !com.baidu.tbadk.core.util.v.v(f.this.ahq().bqy()) && f.this.cpI.aiF() != null && f.this.cpI.aiF().aiV() != null) {
                    List<com.baidu.adp.widget.ListView.f> bqy = f.this.ahq().bqy();
                    int size = bqy.size();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= size) {
                            i = -1;
                            break;
                        } else if ((bqy.get(i2) instanceof com.baidu.tbadk.data.f) && TbadkCoreApplication.getCurrentAccount().equals(String.valueOf(((com.baidu.tbadk.data.f) bqy.get(i2)).user_id))) {
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
                    fVar.azL = String.valueOf(f.this.forumId);
                    fVar.azK = bVar;
                    if (i != -1) {
                        bqy.set(i, fVar);
                    } else {
                        bqy.add(1, fVar);
                    }
                    f.this.cpI.aiF().aiV().b(bqy, f.this.forumId, f.this.getThreadId());
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.k cqO = new com.baidu.tieba.tbadkCore.k() { // from class: com.baidu.tieba.frs.f.3
        private long startTime = 0;

        @Override // com.baidu.tieba.tbadkCore.k
        public void iT(int i) {
            this.startTime = System.nanoTime();
            if (f.this.cpW != null) {
                switch (i) {
                    case 1:
                    case 2:
                        f.this.cpW.ahH();
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
            if (f.this.bjR) {
                f.this.bjR = false;
                com.baidu.tieba.frs.g.h.a(f.this.cpW, f.this.cpA, f.this.getForumId(), false, null);
            }
            f.this.ahb();
            f.this.cqa = true;
            if (aVar != null && aVar.isSuccess) {
                f.this.cpW.ahR().eZ(com.baidu.tbadk.core.util.an.vO().vQ());
                f.cpX = 0L;
                f.cpY = 0L;
                f.cpZ = 0;
            } else {
                f.cpZ = 1;
            }
            if (!f.this.cqf.ald() && (i == 3 || i == 6)) {
                f.this.cqs.resetData();
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (f.this.cqf.akd() != null) {
                f.this.cpA = f.this.cqf.akd();
            }
            if (i == 7) {
                f.this.iR(f.this.cpA.bqX());
                return;
            }
            if (f.this.cpA.qD() != null) {
                f.this.setHasMore(f.this.cpA.qD().qz());
            }
            f.this.ahc();
            if (i == 4) {
                if (!f.this.cqf.ald() && TbadkCoreApplication.getInst().isRecAppExist() && f.this.cqf.akT() == 1) {
                    f.this.cpA.a(f.this);
                }
                ArrayList<com.baidu.adp.widget.ListView.f> a2 = f.this.cqs.a(false, false, f.this.cpA.getThreadList(), f.this.cpS);
                if (a2 != null) {
                    f.this.cpA.aA(a2);
                    f.this.cpA.brt();
                    f.this.cpW.a(a2, f.this.cpA);
                }
                if (f.this.cqf != null) {
                    com.baidu.tieba.frs.f.b.a(f.this.cpA, f.this.cqf.akZ(), 2);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    f.this.cpW.ahH();
                    break;
                case 2:
                    f.this.cpW.ahH();
                    break;
                case 3:
                case 6:
                    if (f.this.cpA != null) {
                        f.this.cpA.brr();
                    }
                    if (f.this.cqw != null) {
                        f.this.cqw.refresh();
                        break;
                    }
                    break;
            }
            f.this.ahd();
            if (aVar == null || aVar.errorCode == 0) {
                if (f.this.cpA != null) {
                    f.this.cpW.iV(i);
                    f.this.t(false, i == 5);
                    f.cpX = (System.nanoTime() - this.startTime) / 1000000;
                    if (aVar != null) {
                        f.cpY = aVar.ggd;
                    }
                } else {
                    return;
                }
            } else if (f.this.cpA == null || com.baidu.tbadk.core.util.v.v(f.this.cpA.getThreadList())) {
                f.this.a(aVar, false);
            } else if (aVar.ggc) {
                f.this.showToast(f.this.getPageContext().getResources().getString(d.l.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
            }
            if (f.this.cpA.bqC() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11384"));
            }
            if (f.this.cdd > -1 && !f.this.cqD) {
                com.baidu.tieba.frs.g.h.a(f.this.cqf, f.this.cdd);
                f.this.cdd = -1L;
                f.this.cqD = true;
            }
            if (f.this.cpT && (f.this.cqh instanceof com.baidu.tieba.frs.entelechy.c.a) && ((com.baidu.tieba.frs.entelechy.c.a) f.this.cqh).ajt() != null) {
                ((com.baidu.tieba.frs.entelechy.c.a) f.this.cqh).ajt().jN(49);
                f.this.cpT = false;
            }
            f.this.aJL = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.k
        public void b(com.baidu.tieba.tbadkCore.g gVar) {
            if (gVar != null) {
                if ("normal_page".equals(f.this.cqf.akP()) || "frs_page".equals(f.this.cqf.akP()) || "book_page".equals(f.this.cqf.akP())) {
                    f.this.a(gVar);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE, gVar));
                }
            }
        }
    };
    private final CustomMessageListener cqP = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.frs.f.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                f.this.cpA.a((com.baidu.tbadk.data.j) customResponsedMessage.getData());
                f.this.cpW.ahR().notifyDataSetChanged();
            }
        }
    };
    private final CustomMessageListener mMemListener = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_MEM) { // from class: com.baidu.tieba.frs.f.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && f.this.cpA != null && (userData = f.this.cpA.getUserData()) != null) {
                userData.setIsMem(num.intValue());
                if (num.intValue() != 0) {
                    f.this.cqg.f(num);
                }
            }
        }
    };
    private final com.baidu.tieba.frs.mc.j cqQ = new com.baidu.tieba.frs.mc.j() { // from class: com.baidu.tieba.frs.f.6
        @Override // com.baidu.tieba.frs.mc.j
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.f> arrayList, boolean z3) {
            if (f.this.cqk != null && f.this.cqf != null && f.this.cqf.ald() && z && !z2 && !z3) {
                f.this.cqk.jH(i2);
            }
        }
    };
    public final View.OnTouchListener aMx = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.f.7
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (f.this.cqA != null) {
                f.this.cqA.onTouch(view, motionEvent);
            }
            if (f.this.cqm != null && f.this.cqm.aij() != null) {
                f.this.cqm.aij().onTouchEvent(motionEvent);
            }
            if (f.this.bjq != null) {
                f.this.bjq.d(view, motionEvent);
            }
            f.this.cqR = true;
            if (f.this.cqg != null) {
                f.this.cqg.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private final CustomMessageListener cqS = new CustomMessageListener(CmdConfigCustom.CMD_GOTOLIVE_HOST_UPGRADE) { // from class: com.baidu.tieba.frs.f.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "photolive_hostLevel", -1) != -1 && f.this.cpA.aPg() != null) {
                f.this.cpA.aPg().setCanAddPhotoLivePost(true);
            }
        }
    };
    private final CustomMessageListener cqT = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.frs.f.9
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
    public final View.OnClickListener cqU = new View.OnClickListener() { // from class: com.baidu.tieba.frs.f.11
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (f.this.cpW == null || view != f.this.cpW.ahF() || f.this.getActivity() == null) {
                if (f.this.cpA != null && f.this.cpA.aPg() != null) {
                    if (f.this.cpW == null || view != f.this.cpW.ahL()) {
                        if (f.this.cpW != null && view == f.this.cpW.ahM()) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12402").ad("fid", f.this.cpA.aPg().getId()).ad(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()).ad(ImageViewerConfig.FORUM_NAME, f.this.cpA.aPg().getName()));
                            if (!StringUtils.isNull(f.this.cpA.aPg().getName())) {
                                f.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PostSearchActivityConfig(f.this.getPageContext().getPageActivity(), f.this.cpA.aPg().getName(), f.this.cpA.aPg().getId())));
                                return;
                            }
                            return;
                        }
                    } else if (!StringUtils.isNull(f.this.cpA.aPg().getId())) {
                        if (f.this.cpA.aPg() != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12046").ad("fid", f.this.cpA.aPg().getId()).r("obj_locate", f.this.aht() ? 1 : 2));
                        }
                        f.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(f.this.getPageContext().getPageActivity(), f.this.cpA.aPg().getId(), ForumDetailActivityConfig.FromType.FRS)));
                        return;
                    } else {
                        return;
                    }
                }
                if (view.getId() == d.h.game_activity_egg_layout && com.baidu.adp.lib.util.k.hz()) {
                    TiebaStatic.log("c10853");
                    if (f.this.cpW.ahO()) {
                        f.this.cpW.ahP();
                        return;
                    }
                    String activityUrl = f.this.cpA.aPg().getYuleData().th().getActivityUrl();
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
    private final AbsListView.OnScrollListener cqV = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.f.13
        private int crd = 0;
        private int bcV = 0;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (f.this.aMw != null && f.this.isPrimary()) {
                f.this.aMw.a(absListView, this.crd, i, i2, i3);
            }
            if (f.this.cqh != null) {
                f.this.cqh.a(absListView, i, i2, i3, f.this.cqg.ama());
            }
            if (f.this.cqq != null) {
                f.this.cqq.alE();
            }
            if (f.this.cqk != null) {
                f.this.cqk.alo();
            }
            if (f.this.cqB != null) {
                f.this.cqB.onScroll(absListView, i, i2, i3);
            }
            if (f.this.cpA != null && f.this.cpW != null && f.this.cpW.ahR() != null) {
                this.crd = i;
                this.bcV = (i + i2) - 1;
                f.this.cpW.as(this.crd, this.bcV);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (f.this.cqg != null) {
                f.this.cqg.setScrollState(i);
            }
            if (f.this.aMw != null && f.this.isPrimary()) {
                f.this.aMw.onScrollStateChanged(absListView, i);
            }
            if ((i == 2 || i == 1) && !f.this.cqb) {
                f.this.cqb = true;
                f.this.cpW.ahT();
            }
            if (f.this.cqc == null && !f.this.aht()) {
                f.this.cqc = new com.baidu.tbadk.l.d();
                f.this.cqc.fi(1000);
            }
            if (i == 0) {
                com.baidu.tieba.card.u.Yj().dJ(true);
                f.this.cpW.ar(this.crd, this.bcV);
            }
            if (f.this.cqB != null) {
                f.this.cqB.onScrollStateChanged(absListView, i);
            }
            if (f.this.cqc != null) {
                f.this.cqc.Ge();
            }
            if (i == 0) {
                com.baidu.tieba.frs.g.h.a(f.this.cpW, f.this.cpA, f.this.getForumId(), false, null);
            }
        }
    };
    private final b cqW = new b() { // from class: com.baidu.tieba.frs.f.14
        @Override // com.baidu.tieba.frs.b
        public void a(int i, int i2, View view, View view2, bj bjVar) {
            if (i != f.this.cpW.ahR().ajb()) {
                if (i != f.this.cpW.ahR().ajc()) {
                    if (i != f.this.cpW.ahR().aje()) {
                        if (i != f.this.cpW.ahR().aib()) {
                            if (i == f.this.cpW.ahR().ajd() && f.this.cpA != null && f.this.cpA.getUserData() != null && f.this.cpA.getUserData().isBawu()) {
                                final String bqV = f.this.cpA.bqV();
                                if (!com.baidu.tbadk.core.util.am.isEmpty(bqV) && f.this.cpA.aPg() != null) {
                                    com.baidu.tieba.c.a.a(f.this.getPageContext(), f.this.cpA.aPg().getId(), f.this.cpA.aPg().getName(), new a.InterfaceC0078a() { // from class: com.baidu.tieba.frs.f.14.1
                                        @Override // com.baidu.tieba.c.a.InterfaceC0078a
                                        public void WV() {
                                            com.baidu.tbadk.browser.a.T(f.this.getPageContext().getPageActivity(), bqV);
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10502").ad("fid", f.this.cpA.aPg().getId()).ad(SapiAccountManager.SESSION_UID, f.this.cpA.getUserData().getUserId()));
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        f.this.cpN = bjVar;
                        com.baidu.tieba.frs.g.i.a(f.this, f.this.cpN);
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10179").ad("fid", f.this.getForumId()));
                        return;
                    }
                    com.baidu.tieba.frs.g.i.A(f.this);
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak(i == f.this.cpW.ahR().aje() ? "c10177" : "c10244").ad("fid", f.this.getForumId()));
                } else if (ax.aU(f.this.getPageContext().getPageActivity())) {
                    TiebaStatic.log("my_service_ck");
                    if (f.this.cpA != null && f.this.cpA.aPg() != null) {
                        ForumData aPg = f.this.cpA.aPg();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(f.this.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(aPg.getId(), 0L), aPg.getName(), aPg.getImage_url(), 0)));
                    }
                }
            } else if (ax.aU(f.this.getActivity())) {
                TiebaStatic.log("forum_fortune_click");
                com.baidu.tieba.frs.g.i.a(f.this.getPageContext(), f.this.cpA);
            }
        }
    };
    private final NoNetworkView.a bJq = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.f.15
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aM(boolean z) {
            if (f.this.cqf.akT() == 1 && z && !f.this.cpW.ahr()) {
                if (f.this.cpA == null || com.baidu.tbadk.core.util.v.v(f.this.cpA.getThreadList())) {
                    f.this.hideNetRefreshView(f.this.cpW.Xy());
                    f.this.showLoadingView(f.this.cpW.Xy(), true);
                    f.this.cpW.eO(false);
                    f.this.refresh();
                    return;
                }
                f.this.cpW.ahH();
            }
        }
    };
    private final CustomMessageListener cqX = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.f.16
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                com.baidu.tieba.frs.g.c.a(customResponsedMessage, f.this.cpW, f.this.cpA);
            }
        }
    };
    private com.baidu.adp.widget.ListView.h cqY = new a();
    private ak cqZ = new ak() { // from class: com.baidu.tieba.frs.f.17
        @Override // com.baidu.tieba.frs.ak
        public void a(int i, int i2, aq aqVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
            com.baidu.adp.lib.g.e.fQ().post(new Runnable() { // from class: com.baidu.tieba.frs.f.17.1
                @Override // java.lang.Runnable
                public void run() {
                    if (f.this.cpW != null && f.this.cpW.Zd()) {
                        f.this.Ng();
                    }
                }
            });
        }
    };
    private CustomMessageListener cra = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.frs.f.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    f.this.cqC = true;
                }
            }
        }
    };

    public com.baidu.tieba.frs.entelechy.b.b agP() {
        return this.cqo;
    }

    public com.baidu.adp.widget.ListView.h agQ() {
        return this.cqY;
    }

    public com.baidu.tieba.frs.mc.e agR() {
        return this.cqr;
    }

    public com.baidu.tieba.frs.smartsort.b agS() {
        return this.cqk;
    }

    @Override // com.baidu.tieba.frs.mc.k
    public FrsModelController agT() {
        return this.cqf;
    }

    @Override // com.baidu.tieba.frs.mc.k
    public com.baidu.tieba.frs.mc.d agU() {
        return this.cqs;
    }

    @Override // com.baidu.tieba.frs.mc.k
    public com.baidu.tieba.frs.h.f agV() {
        return this.cqg;
    }

    public com.baidu.tieba.frs.entelechy.b.d agW() {
        return this.cqh;
    }

    public am agX() {
        return this.cqm;
    }

    @Override // com.baidu.tieba.frs.mc.k
    public i agY() {
        return this.cpW;
    }

    @Override // com.baidu.tieba.frs.al
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.al
    public String getForumName() {
        return this.cpO;
    }

    public void setForumName(String str) {
        this.cpO = str;
    }

    public void setFrom(String str) {
        this.aiO = str;
    }

    public String getFrom() {
        return this.aiO;
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
        if (this.cqs == null) {
            return 1;
        }
        return this.cqs.getPn();
    }

    public int getPn() {
        if (this.cqs == null) {
            return 1;
        }
        return this.cqs.getPn();
    }

    public void setPn(int i) {
        if (this.cqs != null) {
            this.cqs.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.cqs != null) {
            this.cqs.setHasMore(i);
        }
    }

    public int agZ() {
        if (this.cqs == null) {
            return -1;
        }
        return this.cqs.agZ();
    }

    public boolean aha() {
        return this.cpU;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d.a aVar, boolean z) {
        this.cpW.ahC();
        if (aVar == null) {
            showNetRefreshView(this.cpW.Xy(), TbadkCoreApplication.getInst().getString(d.l.error_unkown_try_again), true);
        } else if (aVar.ggc) {
            if (340001 == aVar.errorCode) {
                showNetRefreshViewNoClick(this.cpW.Xy(), TbadkCoreApplication.getInst().getString(d.l.net_error_text, new Object[]{aVar.errorMsg, Integer.valueOf(aVar.errorCode)}), true);
            } else {
                showNetRefreshView(this.cpW.Xy(), TbadkCoreApplication.getInst().getString(d.l.net_error_text, new Object[]{aVar.errorMsg, Integer.valueOf(aVar.errorCode)}), true);
            }
        } else if (340001 == aVar.errorCode) {
            showNetRefreshViewNoClick(this.cpW.Xy(), aVar.errorMsg, true);
        } else {
            showNetRefreshView(this.cpW.Xy(), aVar.errorMsg, true);
        }
        if (aht()) {
            setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.k.f(TbadkCoreApplication.getInst(), d.f.ds280));
        } else {
            setNetRefreshViewEmotionDefMarginTop();
        }
    }

    public void ahb() {
        hideLoadingView(this.cpW.Xy());
        this.cpW.ahN();
        if (this.cpW.ahA() instanceof com.baidu.tieba.frs.tab.c) {
            ((com.baidu.tieba.frs.tab.c) this.cpW.ahA()).aly();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahc() {
        if (agZ() == 0 && com.baidu.tbadk.core.util.v.v(this.cpA.bqI())) {
            if (com.baidu.tbadk.core.util.v.v(this.cpA.getThreadList())) {
                this.cpW.Zn();
                return;
            } else {
                this.cpW.XG();
                return;
            }
        }
        this.cpW.XE();
    }

    public void a(ErrorData errorData) {
        ahb();
        this.cpW.ahH();
        d.a akQ = this.cqf.akQ();
        boolean v = com.baidu.tbadk.core.util.v.v(this.cpA.getThreadList());
        if (akQ != null && v) {
            if (v) {
                if (this.cqf.akR() != 0) {
                    this.cqf.akX();
                    this.cpW.ahH();
                } else {
                    a(akQ, false);
                }
                this.cpW.u(this.cpA.brF(), false);
                return;
            } else if (akQ.ggc) {
                this.cpW.u(true, false);
                showToast(getPageContext().getResources().getString(d.l.net_error_text, akQ.errorMsg, Integer.valueOf(akQ.errorCode)));
                return;
            } else {
                return;
            }
        }
        a(akQ, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahd() {
        if (this.cpA == null || this.cpA.aPg() != null) {
            this.cpW.ahQ();
        } else if (this.cpA.aPg().getYuleData() != null && this.cpA.aPg().getYuleData().tg()) {
            TiebaStatic.log("c10852");
            this.cpW.a(this.cpA.aPg().getYuleData().th());
        } else {
            this.cpW.ahQ();
        }
    }

    private void s(boolean z, boolean z2) {
        if (this.cqf != null && this.cpA != null && this.cpW != null && z) {
            if (!this.cqf.ald() && this.cqf.akT() == 1) {
                if (!this.cqf.alb()) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        this.cpA.bry();
                        this.cpA.brv();
                    }
                    this.cpA.brw();
                    this.cpA.brx();
                }
                boolean z3 = false;
                if (this.cpW.ahR().m(com.baidu.tieba.card.data.p.bOq)) {
                    z3 = this.cpA.brB();
                }
                if (!z3) {
                    this.cpA.brz();
                }
                if (TbadkCoreApplication.getInst().isRecAppExist()) {
                    this.cpA.a(this);
                }
                if (!this.cpW.ahR().m(bj.Yl)) {
                    this.cpA.brs();
                }
                this.cpA.brC();
                this.cpA.brD();
            }
            this.cpA.brt();
            this.cpA.brq();
            if (this.cpW.ahR().m(com.baidu.tieba.g.b.cOd)) {
                this.cpA.mF(z2);
            }
        }
    }

    public boolean ahe() {
        if (this.cqh != null && this.cpW != null) {
            this.cqh.b(this.cpW.getListView());
        }
        if (this.cqg != null && this.cqf != null) {
            this.cqg.a(this.cqf.akP(), this.cpA);
        }
        boolean z = false;
        if (this.cpA != null) {
            z = this.cpA.brG();
        }
        eH(z);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iR(int i) {
        an anVar = null;
        ahe();
        ahn();
        try {
            if (this.cpA != null) {
                this.cpW.a((ArrayList<com.baidu.adp.widget.ListView.f>) null, this.cpA);
                this.cqg.jV(1);
                this.cpW.ahK();
                this.cqh.a(this.cpW.getListView(), this.cpA, this.cqf.akZ());
                com.baidu.tieba.frs.tab.d a2 = a(this.cqh.ajm(), this.cpA.bqX());
                if (a2 != null && !TextUtils.isEmpty(a2.url)) {
                    anVar = new an();
                    anVar.ctb = a2.url;
                    anVar.stType = a2.name;
                }
                this.cqf.a(this.cpA.bqX(), 0, anVar);
                this.cqh.fc(false);
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
            if (dVar != null && dVar.cCh == i) {
                return dVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(boolean z, boolean z2) {
        AlaLiveNotify brk;
        try {
            if (this.cpA != null && this.cqh != null && this.cqf != null) {
                if (!this.cpW.ahR().m(bj.Yl)) {
                    this.cpA.brs();
                }
                boolean v = com.baidu.tbadk.core.util.v.v(this.cpA.brl());
                this.cpW.eL(v);
                if (!v) {
                    if (this.cqB == null) {
                        this.cqB = new com.baidu.tieba.frs.h.e(this, (NoPressedRelativeLayout) this.mRootView);
                    }
                    if (this.bjq == null) {
                        this.bjq = new com.baidu.tieba.frs.gametab.a(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
                    }
                } else {
                    this.cqB = null;
                    this.bjq = null;
                }
                if (this.cpA.aPg() != null) {
                    this.cpO = this.cpA.aPg().getName();
                    this.forumId = this.cpA.aPg().getId();
                }
                if (this.cpA.brG()) {
                    this.cqh.a(this.cpW.getListView(), this.cpA, this.cqf.akZ());
                }
                if (z) {
                    s(true, z);
                } else {
                    s(this.cqe, z);
                }
                ahe();
                if (this.cqo != null) {
                    this.cqo.a(this.cqg, this.cpA);
                }
                if (this.cpA.qD() != null) {
                    setHasMore(this.cpA.qD().qz());
                }
                ArrayList<com.baidu.adp.widget.ListView.f> a2 = this.cqs.a(z2, true, this.cpA.getThreadList(), null, z);
                if (a2 != null) {
                    this.cpA.aA(a2);
                }
                if (this.cqf.akT() == 1) {
                    ahk();
                    if (!z && this.cqf.getPn() == 1 && (brk = ahq().brk()) != null) {
                        new com.baidu.tieba.frs.d.a().a(this, brk);
                    }
                }
                this.cpC = this.cpA.akV();
                if (this.cpS != null) {
                    this.cpR = true;
                    this.cpS.ts(this.cpC);
                    com.baidu.tieba.frs.g.a.a(this, this.cpA.aPg(), this.cpA.getThreadList(), this.cpR, getPn());
                }
                if (this.cqq != null) {
                    this.cqq.ax(this.cqh.ajn());
                }
                ahb();
                this.cpW.ahD();
                this.cpW.u(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.g gVar) {
        try {
            if (!this.cqa && gVar != null && this.cpA != null) {
                this.cpA.e(gVar);
                t(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void eH(boolean z) {
        if (this.cqf != null) {
            f(z, this.cqf.akP());
        } else {
            f(z, "normal_page");
        }
    }

    private void f(boolean z, String str) {
        eI("frs_page".equals(str));
        if (this.cqo != null) {
            this.cqo.a(z, this.cqh, this.cqg, this.cpW, this.cpA);
        }
    }

    public void eI(boolean z) {
        if (this.cqt != null) {
            this.cqt.a(this.cpW, z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(d.j.frs_activity, viewGroup, false);
            this.cpI = new com.baidu.tieba.frs.entelechy.b();
            this.cqo = this.cpI.aiE();
            this.cqg = new com.baidu.tieba.frs.h.f(this, this.cpI);
            this.cqh = this.cpI.y(this);
            Intent intent = this.cqy != null ? this.cqy : getActivity().getIntent();
            if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                this.cpK = true;
            }
            this.cpW = new i(this, this.cqU, this.cpI, this.cpK);
            this.cpW.setHeaderViewHeight(this.cqz);
        } else if (this.mRootView.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            this.cpW.ahW();
        }
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Intent intent = this.cqy != null ? this.cqy : getActivity().getIntent();
        this.cdd = System.currentTimeMillis();
        if (intent != null) {
            this.cpT = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.cdd = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            L(intent);
        }
        this.Wo = System.currentTimeMillis();
        this.aJD = this.Wo - this.cdd;
        this.cpS = new com.baidu.tieba.tbadkCore.data.e("frs", com.baidu.tieba.tbadkCore.data.e.giB);
        this.cqf = new FrsModelController(this, this.cqO);
        this.cqf.a(this.cqG);
        this.cqf.init();
        if (intent != null) {
            this.cqf.i(intent.getExtras());
        } else if (bundle != null) {
            this.cqf.i(bundle);
        } else {
            this.cqf.i(null);
        }
        this.cqh.as(this.cpW.Xy());
        if (intent != null) {
            this.cqg.l(intent.getExtras());
        } else if (bundle != null) {
            this.cqg.l(bundle);
        } else {
            this.cqg.l((Bundle) null);
        }
        this.cpV = getVoiceManager();
        this.cqv = new h(getPageContext(), this);
        initUI();
        initData(bundle);
        if (this.aiO != null && this.aiO.equals("from_tieba_kuang")) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12264").r("obj_type", 1).ad(ImageViewerConfig.FORUM_NAME, this.cqf.getForumName()));
            KuangFloatingViewController.getInstance().setNeedShowFloatingView(true);
            KuangFloatingViewController.getInstance().showFloatingView();
        }
        if (!aht()) {
            this.cqm = new am(getActivity(), this.cpW, this.cqg);
            this.cqm.eT(true);
        }
        this.cpV = getVoiceManager();
        if (this.cpV != null) {
            this.cpV.onCreate(getPageContext());
        }
        new com.baidu.tieba.frs.mc.h();
        this.cqs = new com.baidu.tieba.frs.mc.d(this, this.cqQ);
        this.cqk = new com.baidu.tieba.frs.smartsort.b(this);
        this.cqt = new com.baidu.tieba.frs.h.h(this);
        this.createTime = System.currentTimeMillis() - this.Wo;
        this.cqq = new com.baidu.tieba.frs.h.a(getPageContext(), this.cqf.ala());
        this.cql = new com.baidu.tieba.frs.mc.c(this);
        this.cqr = new com.baidu.tieba.frs.mc.e(this);
        this.cqi = new com.baidu.tieba.frs.mc.g(this);
        this.cqj = new com.baidu.tieba.frs.mc.b(this);
        this.cqu = new com.baidu.tieba.frs.mc.a(this);
        this.cqw = new com.baidu.tieba.frs.h.c(this);
        this.cqx = new com.baidu.tieba.frs.mc.f(this, getUniqueId());
        registerListener(this.mMemListener);
        registerListener(this.cqM);
        registerListener(this.cqS);
        registerListener(this.cqL);
        registerListener(this.cqP);
        registerListener(this.cqI);
        registerListener(this.cqJ);
        registerListener(this.cqK);
        registerListener(this.cqE);
        registerListener(this.cqF);
        registerListener(this.cra);
        registerListener(this.cqN);
        this.cpW.eO(false);
        if (!aht()) {
            showLoadingView(this.cpW.Xy(), true);
            this.cqf.q(3, true);
        }
        super.onActivityCreated(bundle);
    }

    @Override // com.baidu.tieba.frs.ah
    public void ahf() {
        if (isAdded() && this.bjR && !isLoadingViewAttached()) {
            showLoadingView(this.cpW.Xy(), true);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void ahg() {
        if (isAdded() && this.bjR && isLoadingViewAttached()) {
            hideLoadingView(this.cpW.Xy());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (aht()) {
            showLoadingView(this.cpW.Xy(), true);
            this.cpW.iU(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.cqf.q(3, true);
            getListView().setSelection(0);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void setHeaderViewHeight(int i) {
        this.cqz = i;
        if (this.cpW != null) {
            this.cpW.setHeaderViewHeight(this.cqz);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void setRecommendFrsNavigationAnimDispatcher(r rVar) {
        if (rVar != null) {
            this.aMw = rVar.Ho();
            this.cqA = rVar.Hp();
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void showFloatingView() {
        if (this.aMw != null) {
            this.aMw.cg(true);
        }
    }

    private void L(Intent intent) {
        if (intent != null) {
            if (!com.baidu.tieba.frs.g.f.a(this, getForumName(), "from", intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false)) && getActivity() != null) {
                getActivity().finish();
                return;
            }
        }
        if (intent != null && intent.getData() != null) {
            Uri data = intent.getData();
            this.cpO = data.getQueryParameter("name");
            this.aiO = data.getQueryParameter("from");
            if (!StringUtils.isNull(this.cpO)) {
                intent.putExtra("name", this.cpO);
            }
            if (!StringUtils.isNull(this.aiO)) {
                intent.putExtra("from", this.aiO);
            }
            TiebaStatic.log("c10105");
        }
        if (StringUtils.isNull(this.cpO)) {
            this.cpO = com.baidu.tieba.frs.g.i.O(intent);
            if (!StringUtils.isNull(this.cpO)) {
                intent.putExtra("name", this.cpO);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.cpV = getVoiceManager();
        if (this.cpV != null) {
            this.cpV.onStart(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        Intent intent;
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.cqX);
        if (bundle != null) {
            this.cpO = bundle.getString("name");
            this.aiO = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
            this.cpO = intent.getStringExtra("name");
            this.aiO = intent.getStringExtra("from");
            this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
        }
        if (TextUtils.isEmpty(this.aiO) || FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.aiO)) {
        }
        if (this.mIsLogin) {
            registerListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL, this.cqX);
        }
        this.cqg.l(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.cra);
        if (this.cpV != null) {
            this.cpV.onDestory(getPageContext());
        }
        this.cpV = null;
        com.baidu.tieba.card.u.Yj().dJ(false);
        if (this.cpA != null && this.cpA.aPg() != null) {
            ac.aif().bi(com.baidu.adp.lib.g.b.c(this.cpA.aPg().getId(), 0L));
        }
        if (this.cpW != null) {
            com.baidu.tieba.frs.g.h.a(this.cpW, this.cpA, getForumId(), false, null);
            this.cpW.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.cqc != null) {
                this.cqc.onDestroy();
            }
            this.cpW.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.cqf.onActivityDestroy();
        this.cqg.onActivityDestroy();
        if (this.cqd != null) {
            this.cqd.cancel(true);
            this.cqd = null;
        }
        if (this.cqf != null) {
            this.cqf.OQ();
        }
        if (this.cqm != null) {
            this.cqm.Hn();
        }
        if (this.cqp != null) {
            this.cqp.destory();
        }
        if (this.cqq != null) {
            this.cqq.destory();
        }
        if (this.cqk != null) {
            this.cqk.onDestroy();
        }
        if (this.cqB != null) {
            this.cqB.onDestory();
        }
        com.baidu.tieba.recapp.d.a.bhT().bhV();
        com.baidu.tieba.frs.g.j.alB();
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.cpO);
        bundle.putString("from", this.aiO);
        this.cqf.onSaveInstanceState(bundle);
        if (this.cpV != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            this.cpV.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.cqu != null) {
            this.cqu.onActivityResult(i, i2, intent);
        }
    }

    public void a(UpdateAttentionMessage updateAttentionMessage) {
        Message<?> message;
        if (updateAttentionMessage != null && updateAttentionMessage.isAttention() && updateAttentionMessage.isGod() && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(getUniqueId())) {
            if (this.cqp == null) {
                this.cqp = new com.baidu.tbadk.i.a(getPageContext());
            }
            this.cqp.aq(updateAttentionMessage.getData().toUid, getForumId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.cpW != null) {
            this.cpW.ahH();
            this.cpW.onResume();
        }
        this.cqh.a(this.cqH);
        this.cqi.fk(true);
        this.cqe = true;
        if (isNeedRefreshOnResume) {
            isNeedRefreshOnResume = false;
            this.cpW.startPullRefresh();
        } else if (cpL) {
            cpL = false;
            this.cpW.startPullRefresh();
        } else {
            if (this.cpV != null) {
                this.cpV.onResume(getPageContext());
            }
            this.cpW.eP(false);
            registerListener(this.cqT);
            if (this.cqC) {
                cm(6);
                this.cqC = false;
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
    public void M(Intent intent) {
        this.cqy = intent;
    }

    public boolean ahh() {
        if (getActivity() == null) {
            return false;
        }
        Intent intent = this.cqy != null ? this.cqy : getActivity().getIntent();
        if (intent != null) {
            return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
        }
        return false;
    }

    public void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.cpO = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.aiO = intent.getStringExtra("from");
            }
            this.cpQ = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.cpQ) {
                ahi();
            }
            if (this.aiO != null && this.aiO.equals("from_tieba_kuang")) {
                KuangFloatingViewController.getInstance().setNeedShowFloatingView(true);
                KuangFloatingViewController.getInstance().showFloatingView();
            }
        }
    }

    private void ahi() {
        this.cpW.startPullRefresh();
    }

    public void closeActivity() {
        com.baidu.tieba.frs.g.i.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.aiO);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.cpW.setTitle(this.cpO);
        } else {
            this.cpW.setTitle("");
            this.mFlag = 1;
        }
        this.cqg.d(this.cpW.getListView());
        this.cpW.setOnAdapterItemClickListener(this.cqY);
        this.cpW.setOnScrollListener(this.cqV);
        this.cpW.c(this.bJq);
        this.cpW.ahR().a(this.cqW);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cpW.onChangeSkinType(i);
        this.cqg.jU(i);
        this.cqh.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.d.c
    public void lq() {
    }

    @Override // com.baidu.adp.widget.d.c
    public void lr() {
    }

    public void iS(int i) {
        if (!this.mIsLogin) {
            if (this.cpA != null && this.cpA.qn() != null) {
                this.cpA.qn().setIfpost(1);
            }
            if (i == 0) {
                ax.aT(getActivity());
            }
        } else if (this.cpA != null) {
            if (i == 0) {
                if (!this.cpM) {
                    com.baidu.tieba.frs.g.j.b(this, 0);
                    return;
                }
                TiebaStatic.log("c10152");
                com.baidu.tieba.frs.g.j.b(this, 4);
                return;
            }
            this.cpW.ahJ();
        }
    }

    public void refresh() {
        cm(3);
    }

    public void cm(int i) {
        this.cqa = false;
        ahn();
        if (this.cpW.ahz() != null) {
            this.cpW.ahz().asu();
        }
        this.cqf.q(i, true);
    }

    private void ahj() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.g.h.fR().d(new Runnable() { // from class: com.baidu.tieba.frs.f.10
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.sj(f.this.cpO);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahk() {
        ahn();
        try {
            if (this.cpA != null) {
                this.cpW.NI();
                this.cpW.eK(this.cqf.akU());
                if (com.baidu.tieba.frs.h.f.i(this.cpA) && !com.baidu.tieba.frs.h.f.h(this.cpA)) {
                    this.cpW.ahU();
                }
                if (this.cpA.aPg() != null) {
                    this.cpO = this.cpA.aPg().getName();
                    this.forumId = this.cpA.aPg().getId();
                }
                if (this.cpA.qD() != null) {
                    setHasMore(this.cpA.qD().qz());
                }
                this.cpW.setTitle(this.cpO);
                this.cpW.setForumName(this.cpO);
                TbadkCoreApplication.getInst().setDefaultBubble(this.cpA.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.cpA.getUserData().getBimg_end_time());
                ahj();
                ahl();
                ArrayList<com.baidu.adp.widget.ListView.f> threadList = this.cpA.getThreadList();
                if (threadList != null) {
                    this.cpW.a(threadList, this.cpA);
                    com.baidu.tieba.frs.g.c.j(this.cpW);
                    this.cqg.jV(getPageNum());
                    this.cqg.f(this.cpA);
                    this.cqh.a(this.cpW.getListView(), this.cpA, this.cqf.akZ());
                    this.cpW.ahK();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void ahl() {
        if (this.cpA != null) {
            if (this.cpA.aPu() == 1) {
                this.cpW.ahR().setFromCDN(true);
            } else {
                this.cpW.ahR().setFromCDN(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.cqi.fk(false);
        this.cqe = false;
        this.cpW.onPause();
        if (this.cpV != null) {
            this.cpV.onPause(getPageContext());
        }
        this.cpW.eP(true);
        if (this.cqq != null) {
            this.cqq.alE();
        }
        MessageManager.getInstance().unRegisterListener(this.cqT);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.u.Yj().dJ(false);
        if (this.cpA != null && this.cpA.aPg() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            com.baidu.tbadk.distribute.a.CF().a(getPageContext().getPageActivity(), "frs", this.cpA.aPg().getId(), 0L);
        }
        if (this.cpV != null) {
            this.cpV.onStop(getPageContext());
        }
        com.baidu.tieba.frs.g.i.a(getListView());
        this.cqg.onActivityStop();
        s.Hr();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || this.cpW == null) {
            return false;
        }
        return this.cpW.ahG();
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
    public void ahm() {
        agT().ahm();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.cpV == null) {
            this.cpV = VoiceManager.instance();
        }
        return this.cpV;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public BdListView getListView() {
        if (this.cpW == null) {
            return null;
        }
        return this.cpW.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void ahn() {
        if (this.cpV != null) {
            this.cpV.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> xp() {
        if (this.apd == null) {
            this.apd = UserIconBox.j(getPageContext().getPageActivity(), 8);
        }
        return this.apd;
    }

    public void aho() {
        if (getFragmentActivity() != null && getFragmentActivity().getCurrentFocus() != null) {
            com.baidu.adp.lib.util.k.a(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.g onGetPreLoadListView() {
        return getListView();
    }

    @Override // com.baidu.tieba.frs.aj
    public NavigationBar ahp() {
        if (this.cpW == null) {
            return null;
        }
        return this.cpW.ahp();
    }

    /* loaded from: classes.dex */
    private final class a implements com.baidu.adp.widget.ListView.h {
        private a() {
        }

        @Override // com.baidu.adp.widget.ListView.h
        public void a(View view, com.baidu.adp.widget.ListView.f fVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            boolean z;
            if (bdUniqueId != null) {
                if (bdUniqueId == p.css) {
                    if (f.this.cpW != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11752").ad("fid", f.this.forumId).ad("obj_locate", "1"));
                        f.this.cpW.startPullRefresh();
                    }
                } else if (fVar != null && (fVar instanceof bj)) {
                    bj bjVar = (bj) fVar;
                    if (bjVar.sm() == null || bjVar.sm().getGroup_id() == 0 || ax.aU(f.this.getActivity())) {
                        if ((bjVar.sf() != 1 && bjVar.sf() != 2) || ax.aU(f.this.getActivity())) {
                            if (bjVar.rO() != null) {
                                if (ax.aU(f.this.getActivity())) {
                                    String postUrl = bjVar.rO().getPostUrl();
                                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.k.hz()) {
                                        com.baidu.tbadk.browser.a.U(f.this.getActivity(), postUrl);
                                    }
                                }
                            } else if (bjVar.sx() != null) {
                                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                    ax.aT(f.this.getPageContext().getPageActivity());
                                    return;
                                }
                                com.baidu.tbadk.core.data.n sx = bjVar.sx();
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(f.this.getPageContext().getPageActivity(), sx.getCartoonId(), sx.getChapterId(), 2)));
                            } else if (bjVar.getThreadType() == 47 && bjVar.rw() == 1 && !com.baidu.tbadk.core.util.am.isEmpty(bjVar.rI())) {
                                com.baidu.tbadk.browser.a.T(f.this.getPageContext().getPageActivity(), bjVar.rI());
                            } else {
                                com.baidu.tieba.tbadkCore.util.f readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                                if (readThreadHistory != null && !readThreadHistory.sp(bjVar.getId())) {
                                    readThreadHistory.so(bjVar.getId());
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
                                    if (f.this.cqf.akT() == 5) {
                                        str = "c10387";
                                    }
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak(str).ad("fid", f.this.forumId));
                                    com.baidu.tieba.frs.g.i.c(f.this, bjVar);
                                    if (f.this.cpA != null && f.this.cpA.aPg() != null) {
                                        com.baidu.tieba.frs.f.a aVar = new com.baidu.tieba.frs.f.a();
                                        aVar.cEZ = f.this.cpA.ggE == 1;
                                        aVar.cFb = f.this.cpA.aPg().getId();
                                        aVar.cFa = f.this.agT().akZ();
                                        com.baidu.tieba.frs.f.b.alu().a(aVar, bjVar, 1);
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
                                    com.baidu.tieba.frs.g.h.a(f.this, f.this.cpA, bjVar);
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
            hideNetRefreshView(this.cpW.Xy());
            showLoadingView(this.cpW.Xy(), true);
            this.cpW.eO(false);
            this.cqf.q(3, true);
        }
    }

    public com.baidu.tieba.tbadkCore.i ahq() {
        return this.cpA;
    }

    public boolean ahr() {
        return this.cpW.ahr();
    }

    public void O(Object obj) {
        if (this.cql != null && this.cql.cDT != null) {
            this.cql.cDT.f(obj);
        }
    }

    public void P(Object obj) {
        if (this.cql != null && this.cql.cDU != null) {
            this.cql.cDU.f(obj);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.k.hz()) {
            this.cpW.Zn();
        } else if (this.cqf.akT() == 1) {
            Nn();
            Ng();
        } else if (this.cqf.hasMore()) {
            Ng();
        }
    }

    public void kC(String str) {
        Nn();
        showToast(str);
    }

    public void G(ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        Nn();
        if (!com.baidu.tbadk.core.util.v.v(arrayList)) {
            if (!this.cqf.ald() && TbadkCoreApplication.getInst().isRecAppExist() && this.cqf.akT() == 1) {
                this.cpA.a(this, arrayList);
            }
            ArrayList<com.baidu.adp.widget.ListView.f> a2 = this.cqs.a(false, false, arrayList, this.cpS);
            if (a2 != null) {
                this.cpA.aA(a2);
                this.cpW.a(a2, this.cpA);
            }
            if (this.cqf != null) {
                com.baidu.tieba.frs.f.b.a(this.cpA, this.cqf.akZ(), 2);
            }
        }
    }

    private void Nn() {
        if (agZ() == 1 || this.cqs.aO(this.cpA.bqI())) {
            this.cpW.XE();
        } else if (com.baidu.tbadk.core.util.v.v(this.cpA.getThreadList())) {
            this.cpW.Zn();
        } else {
            this.cpW.XG();
        }
    }

    @Override // com.baidu.tieba.frs.mc.k
    public void Ng() {
        if (this.cqs != null) {
            this.cqs.a(this.cpO, this.forumId, this.cpA);
        }
    }

    public void ahs() {
        if (!com.baidu.tbadk.core.util.ab.d(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.ai.c(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return aht() ? "a034" : "a006";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (!aht()) {
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

    public void eJ(boolean z) {
        if (this.cqm != null) {
            this.cqm.eT(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.cqn.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a fJ(int i) {
        return this.cqn.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        this.cqv.b(bVar);
    }

    public boolean aht() {
        return this.cpK;
    }

    @Override // com.baidu.tieba.frs.ah
    public void ahu() {
        if (this.cpW != null) {
            showFloatingView();
            this.cpW.getListView().setSelection(0);
            this.cpW.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public ForumWriteData ahv() {
        if (this.cpA == null || this.cpA.aPg() == null) {
            return null;
        }
        ForumData aPg = this.cpA.aPg();
        ForumWriteData forumWriteData = new ForumWriteData(aPg.getId(), aPg.getName(), aPg.getPrefixData(), this.cpA.qn());
        forumWriteData.setForumLevel(aPg.getUser_level());
        forumWriteData.setAvatar(this.cpA.aPg().getImage_url());
        return forumWriteData;
    }

    @Override // com.baidu.tieba.frs.ah
    public void xc() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void cK(boolean z) {
        if (this.cpW != null) {
            this.cpW.cK(z);
        }
    }
}
