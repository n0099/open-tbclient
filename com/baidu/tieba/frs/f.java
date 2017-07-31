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
import com.baidu.a.a.a;
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
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
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
import com.baidu.tieba.frs.f.f;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.tbadkCore.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.AlaLiveNotify;
/* loaded from: classes.dex */
public class f extends BaseFragment implements a.InterfaceC0000a, BdListView.e, d.c, UserIconBox.b, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, ah, aj, al, com.baidu.tieba.frs.mc.k, com.baidu.tieba.recapp.o {
    private q aMR;
    private com.baidu.adp.lib.e.b<TbImageView> apA;
    private com.baidu.tieba.frs.entelechy.b ciJ;
    private boolean ciN;
    public bl ciO;
    private com.baidu.tieba.tbadkCore.data.e ciT;
    private VoiceManager ciW;
    private int cjA;
    private View.OnTouchListener cjB;
    private com.baidu.tieba.frs.g.e cjC;
    private boolean cjD;
    private boolean cjS;
    private f.a cje;
    private FrsModelController cjg;
    private com.baidu.tieba.frs.g.f cjh;
    private com.baidu.tieba.frs.entelechy.b.d cji;
    private com.baidu.tieba.frs.mc.g cjj;
    private com.baidu.tieba.frs.mc.b cjk;
    private com.baidu.tieba.frs.smartsort.b cjl;
    private com.baidu.tieba.frs.mc.c cjm;
    private am cjn;
    private com.baidu.tieba.frs.entelechy.b.b cjp;
    private com.baidu.tbadk.i.a cjq;
    private com.baidu.tieba.frs.g.a cjr;
    private com.baidu.tieba.frs.mc.e cjs;
    private com.baidu.tieba.frs.mc.d cjt;
    private com.baidu.tieba.frs.g.h cju;
    private com.baidu.tieba.frs.mc.a cjv;
    private h cjw;
    public com.baidu.tieba.frs.g.c cjx;
    private com.baidu.tieba.frs.mc.f cjy;
    private Intent cjz;
    public View mRootView;
    private static boolean isNeedRefreshOnResume = false;
    public static boolean ciM = false;
    public static volatile long ciY = 0;
    public static volatile long ciZ = 0;
    public static volatile int cja = 0;
    public boolean ciK = false;
    private boolean ciL = false;
    public String ciP = null;
    public String ajt = null;
    public int mFlag = 0;
    private boolean ciQ = false;
    private boolean ciR = false;
    private String mThreadId = null;
    private String forumId = null;
    private int ciE = 0;
    private boolean ciS = false;
    private boolean ciU = false;
    private boolean ciV = false;
    private i ciX = null;
    public final bl bgF = null;
    private com.baidu.tieba.tbadkCore.i ciB = new com.baidu.tieba.tbadkCore.i();
    public long bYB = -1;
    public long aKi = 0;
    public long aKa = 0;
    public long createTime = 0;
    public long Xc = -1;
    private boolean cjb = false;
    private boolean cjc = false;
    public com.baidu.tbadk.l.d cjd = null;
    private boolean cjf = true;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> cjo = new SparseArray<>();
    private boolean bjA = true;
    private boolean cjE = false;
    private final CustomMessageListener cjF = new CustomMessageListener(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED) { // from class: com.baidu.tieba.frs.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof bl) {
                    com.baidu.tieba.frs.f.h.a(f.this.ciX, f.this.ciB, f.this.getForumId(), true, (bl) data);
                }
            }
        }
    };
    private CustomMessageListener cjG = new CustomMessageListener(CmdConfigCustom.CMD_CLOSE_GAME_RANK_CARD) { // from class: com.baidu.tieba.frs.f.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (f.this.ciB != null) {
                f.this.ciB.brz();
                if (f.this.ciX != null) {
                    f.this.ciX.XG();
                }
            }
        }
    };
    private final ak cjH = new ak() { // from class: com.baidu.tieba.frs.f.20
        @Override // com.baidu.tieba.frs.ak
        public void a(int i, int i2, aq aqVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
            f.this.afc();
            if (f.this.cjp != null) {
                f.this.cjh.fa(f.this.cjp.iP(i));
            }
            d.a aVar = new d.a();
            if (aqVar != null) {
                aVar.isSuccess = aqVar.errCode == 0;
                aVar.errorCode = aqVar.errCode;
                aVar.errorMsg = aqVar.errMsg;
                if (aVar.isSuccess) {
                    if (com.baidu.tbadk.core.util.u.v(arrayList)) {
                        f.this.ciX.XH();
                    } else if (aqVar.hasMore) {
                        f.this.ciX.VX();
                    } else if (aqVar.cmh) {
                        f.this.ciX.VZ();
                    } else {
                        f.this.ciX.XH();
                    }
                }
            } else {
                aqVar = new aq();
                aqVar.pn = 1;
                aqVar.hasMore = false;
                aqVar.cmh = false;
            }
            if (i == 1) {
                f.this.cjf = true;
                f.this.cjP.a(f.this.cjg.getType(), false, aVar);
            } else {
                f.this.a(aVar, true);
                if (f.this.cjg.ahS() != null) {
                    f.this.ciB = f.this.cjg.ahS();
                }
                f.this.afl();
            }
            if (f.this.cka != null) {
                f.this.cka.a(i, i2, aqVar, arrayList);
            }
        }
    };
    private ai cjI = new ai() { // from class: com.baidu.tieba.frs.f.21
        @Override // com.baidu.tieba.frs.ai
        public void a(ak akVar) {
        }

        @Override // com.baidu.tieba.frs.ai
        public void a(int i, int i2, an anVar) {
            if (i != 1) {
                com.baidu.tieba.card.u.WB().dE(false);
            }
            if (i == 1) {
                f.this.ciX.eH(true);
                f.this.ciX.eG(false);
            } else {
                f.this.ciX.eI(true);
                f.this.ciX.eG(true);
            }
            f.this.afo();
            f.this.cjg.a(i, i2, anVar);
        }

        @Override // com.baidu.tieba.frs.ai
        public void init() {
        }

        @Override // com.baidu.tieba.frs.ai
        public void Ox() {
        }
    };
    private CustomMessageListener cjJ = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIVE_COUNT) { // from class: com.baidu.tieba.frs.f.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                ((com.baidu.tieba.frs.entelechy.c.a) f.this.cji).iR(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    };
    private CustomMessageListener cjK = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_LIVE_START) { // from class: com.baidu.tieba.frs.f.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && ((Integer) customResponsedMessage.getData()).intValue() == 51 && f.this.ciB != null) {
                com.baidu.tieba.frs.f.j.a(f.this.ciB, f.this.getPageContext());
            }
        }
    };
    private final CustomMessageListener cjL = new CustomMessageListener(CmdConfigCustom.CMD_FRS_SELECT_ALA_LIVE_TAB) { // from class: com.baidu.tieba.frs.f.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (f.this.cji instanceof com.baidu.tieba.frs.entelechy.c.a) && ((com.baidu.tieba.frs.entelechy.c.a) f.this.cji).ahg() != null) {
                ((com.baidu.tieba.frs.entelechy.c.a) f.this.cji).ahg().jn(49);
            }
        }
    };
    private final CustomMessageListener cjM = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.frs.f.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && f.this.ciB != null && f.this.ciB.aPh() != null) {
                SignData signData = (SignData) customResponsedMessage.getData();
                int user_level = f.this.ciB.aPh().getUser_level();
                if (signData.forumId != null && signData.forumId.equals(f.this.ciB.aPh().getId())) {
                    f.this.ciB.d(signData);
                    f.this.cjh.g(f.this.ciB);
                    if (f.this.cjh.ajC()) {
                        i = f.this.ciB.aPh().getUser_level();
                        if (user_level >= i) {
                            i++;
                        }
                    } else {
                        i = user_level;
                    }
                    TbadkCoreApplication.getInst().addSignedForum(f.this.ciB.aPh().getName(), signData.sign_bonus_point, i);
                }
            }
        }
    };
    private final CustomMessageListener cjN = new CustomMessageListener(CmdConfigCustom.CMD_FRS_EXPERIENCE_TIP) { // from class: com.baidu.tieba.frs.f.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.o) && f.this.ciB != null) {
                f.this.ciB.c((com.baidu.tieba.tbadkCore.o) customResponsedMessage.getData());
                f.this.cjh.f(f.this.ciB);
                f.this.cji.a(f.this.ciX.getListView(), f.this.ciB, f.this.cjg.aiE());
            }
        }
    };
    private CustomMessageListener cjO = new CustomMessageListener(CmdConfigCustom.CMD_STORY_READ_CACHE) { // from class: com.baidu.tieba.frs.f.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.story.process.b)) {
                com.baidu.tieba.story.process.b bVar = (com.baidu.tieba.story.process.b) customResponsedMessage.getData();
                if (f.this.forumId != null && f.this.forumId.equals(String.valueOf(bVar.forumId)) && bVar.state == 3 && f.this.afr() != null && !com.baidu.tbadk.core.util.u.v(f.this.afr().bqx()) && f.this.ciJ.agt() != null && f.this.ciJ.agt().agJ() != null) {
                    List<com.baidu.adp.widget.ListView.f> bqx = f.this.afr().bqx();
                    int size = bqx.size();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= size) {
                            i = -1;
                            break;
                        } else if ((bqx.get(i2) instanceof com.baidu.tbadk.data.f) && TbadkCoreApplication.getCurrentAccount().equals(String.valueOf(((com.baidu.tbadk.data.f) bqx.get(i2)).user_id))) {
                            i = i2;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    com.baidu.tbadk.data.f fVar = new com.baidu.tbadk.data.f();
                    fVar.user_id = com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L);
                    fVar.user_name = TbadkCoreApplication.getCurrentAccountName();
                    fVar.portrait = TbadkCoreApplication.getCurrentPortrait();
                    fVar.mStatus = 3;
                    fVar.aAB = String.valueOf(f.this.forumId);
                    fVar.aAA = bVar;
                    if (i != -1) {
                        bqx.set(i, fVar);
                    } else {
                        bqx.add(1, fVar);
                    }
                    f.this.ciJ.agt().agJ().b(bqx, f.this.forumId, f.this.getThreadId());
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.k cjP = new com.baidu.tieba.tbadkCore.k() { // from class: com.baidu.tieba.frs.f.3
        private long startTime = 0;

        @Override // com.baidu.tieba.tbadkCore.k
        public void iD(int i) {
            this.startTime = System.nanoTime();
            if (f.this.ciX != null) {
                switch (i) {
                    case 1:
                    case 2:
                        f.this.ciX.afH();
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
            if (f.this.bjA) {
                f.this.bjA = false;
                com.baidu.tieba.frs.f.h.a(f.this.ciX, f.this.ciB, f.this.getForumId(), false, null);
            }
            f.this.afc();
            f.this.cjb = true;
            if (aVar != null && aVar.isSuccess) {
                f.this.ciX.afR().eP(com.baidu.tbadk.core.util.am.vQ().vS());
                f.ciY = 0L;
                f.ciZ = 0L;
                f.cja = 0;
            } else {
                f.cja = 1;
            }
            if (!f.this.cjg.aiI() && (i == 3 || i == 6)) {
                f.this.cjt.resetData();
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (f.this.cjg.ahS() != null) {
                f.this.ciB = f.this.cjg.ahS();
            }
            if (i == 7) {
                f.this.iB(f.this.ciB.bqW());
                return;
            }
            if (f.this.ciB.qH() != null) {
                f.this.setHasMore(f.this.ciB.qH().qD());
            }
            f.this.afd();
            if (i == 4) {
                if (!f.this.cjg.aiI() && TbadkCoreApplication.getInst().isRecAppExist() && f.this.cjg.aiy() == 1) {
                    f.this.ciB.a(f.this);
                }
                ArrayList<com.baidu.adp.widget.ListView.f> a2 = f.this.cjt.a(false, false, f.this.ciB.getThreadList(), f.this.ciT);
                if (a2 != null) {
                    f.this.ciB.aB(a2);
                    f.this.ciB.brs();
                    f.this.ciX.a(a2, f.this.ciB);
                }
                if (f.this.cjg != null) {
                    com.baidu.tieba.frs.e.b.a(f.this.ciB, f.this.cjg.aiE(), 2);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    f.this.ciX.afH();
                    break;
                case 2:
                    f.this.ciX.afH();
                    break;
                case 3:
                case 6:
                    if (f.this.ciB != null) {
                        f.this.ciB.brq();
                    }
                    if (f.this.cjx != null) {
                        f.this.cjx.refresh();
                        break;
                    }
                    break;
            }
            f.this.afe();
            if (aVar == null || aVar.errorCode == 0) {
                if (f.this.ciB != null) {
                    f.this.ciX.iF(i);
                    f.this.r(false, i == 5);
                    f.ciY = (System.nanoTime() - this.startTime) / 1000000;
                    if (aVar != null) {
                        f.ciZ = aVar.geP;
                    }
                } else {
                    return;
                }
            } else if (f.this.ciB == null || com.baidu.tbadk.core.util.u.v(f.this.ciB.getThreadList())) {
                f.this.a(aVar, false);
            } else if (aVar.geO) {
                f.this.showToast(f.this.getPageContext().getResources().getString(d.l.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
            }
            if (f.this.ciB.bqB() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11384"));
            }
            if (f.this.bYB > -1 && !f.this.cjE) {
                com.baidu.tieba.frs.f.h.a(f.this.cjg, f.this.bYB);
                f.this.bYB = -1L;
                f.this.cjE = true;
            }
            if (f.this.ciU && (f.this.cji instanceof com.baidu.tieba.frs.entelechy.c.a) && ((com.baidu.tieba.frs.entelechy.c.a) f.this.cji).ahg() != null) {
                ((com.baidu.tieba.frs.entelechy.c.a) f.this.cji).ahg().jn(49);
                f.this.ciU = false;
            }
            f.this.aKi = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.k
        public void b(com.baidu.tieba.tbadkCore.g gVar) {
            if (gVar != null) {
                if ("normal_page".equals(f.this.cjg.aiu()) || "frs_page".equals(f.this.cjg.aiu()) || "book_page".equals(f.this.cjg.aiu())) {
                    f.this.a(gVar);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE, gVar));
                }
            }
        }
    };
    private final CustomMessageListener cjQ = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.frs.f.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                f.this.ciB.a((com.baidu.tbadk.data.j) customResponsedMessage.getData());
                f.this.ciX.afR().notifyDataSetChanged();
            }
        }
    };
    private final CustomMessageListener mMemListener = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_MEM) { // from class: com.baidu.tieba.frs.f.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && f.this.ciB != null && (userData = f.this.ciB.getUserData()) != null) {
                userData.setIsMem(num.intValue());
                if (num.intValue() != 0) {
                    f.this.cjh.e(num);
                }
            }
        }
    };
    private final com.baidu.tieba.frs.mc.j cjR = new com.baidu.tieba.frs.mc.j() { // from class: com.baidu.tieba.frs.f.6
        @Override // com.baidu.tieba.frs.mc.j
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
            if (f.this.cjl != null && f.this.cjg != null && f.this.cjg.aiI() && z && !z2) {
                f.this.cjl.jh(i2);
            }
        }
    };
    public final View.OnTouchListener aMS = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.f.7
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (f.this.cjB != null) {
                f.this.cjB.onTouch(view, motionEvent);
            }
            if (f.this.cjn != null && f.this.cjn.agl() != null) {
                f.this.cjn.agl().onTouchEvent(motionEvent);
            }
            f.this.cjS = true;
            if (f.this.cjh != null) {
                f.this.cjh.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private final CustomMessageListener cjT = new CustomMessageListener(CmdConfigCustom.CMD_GOTOLIVE_HOST_UPGRADE) { // from class: com.baidu.tieba.frs.f.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "photolive_hostLevel", -1) != -1 && f.this.ciB.aPh() != null) {
                f.this.ciB.aPh().setCanAddPhotoLivePost(true);
            }
        }
    };
    private final CustomMessageListener cjU = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.frs.f.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11455").aa("obj_locate", "frs"));
                    com.baidu.tbadk.core.util.at.wf().c(f.this.getPageContext(), new String[]{str});
                }
            }
        }
    };
    public final View.OnClickListener cjV = new View.OnClickListener() { // from class: com.baidu.tieba.frs.f.11
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (f.this.ciX == null || view != f.this.ciX.afF()) {
                if (f.this.ciB != null && f.this.ciB.aPh() != null) {
                    if (f.this.ciX == null || view != f.this.ciX.afL()) {
                        if (f.this.ciX != null && view == f.this.ciX.afM()) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10378").r("obj_type", 5));
                            if (!StringUtils.isNull(f.this.ciB.aPh().getName())) {
                                f.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PostSearchActivityConfig(f.this.getPageContext().getPageActivity(), f.this.ciB.aPh().getName())));
                                return;
                            }
                            return;
                        }
                    } else if (!StringUtils.isNull(f.this.ciB.aPh().getId())) {
                        if (f.this.ciB.aPh() != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c12046").aa("fid", f.this.ciB.aPh().getId()).r("obj_locate", f.this.aft() ? 1 : 2));
                        }
                        f.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(f.this.getPageContext().getPageActivity(), f.this.ciB.aPh().getId(), ForumDetailActivityConfig.FromType.FRS)));
                        return;
                    } else {
                        return;
                    }
                }
                if (view.getId() == d.h.game_activity_egg_layout && com.baidu.adp.lib.util.k.hI()) {
                    TiebaStatic.log("c10853");
                    if (f.this.ciX.afO()) {
                        f.this.ciX.afP();
                        return;
                    }
                    String activityUrl = f.this.ciB.aPh().getYuleData().tk().getActivityUrl();
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
    private final AbsListView.OnScrollListener cjW = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.f.13
        private int cke = 0;
        private int bcZ = 0;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (f.this.aMR != null && f.this.isPrimary()) {
                f.this.aMR.a(absListView, this.cke, i, i2, i3);
            }
            if (f.this.cji != null) {
                f.this.cji.a(absListView, i, i2, i3, f.this.cjh.ajH());
            }
            if (f.this.cjr != null) {
                f.this.cjr.aji();
            }
            if (f.this.cjl != null) {
                f.this.cjl.aiT();
            }
            if (f.this.cjn != null) {
                f.this.cjn.a(absListView, i, i2, i3, f.this.cjh.ajH(), false);
            }
            if (f.this.cjC != null) {
                f.this.cjC.onScroll(absListView, i, i2, i3);
            }
            if (f.this.ciB != null && f.this.ciX != null && f.this.ciX.afR() != null) {
                this.cke = i;
                this.bcZ = (i + i2) - 1;
                f.this.ciX.ap(this.cke, this.bcZ);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (f.this.cjh != null) {
                f.this.cjh.setScrollState(i);
            }
            if (f.this.aMR != null && f.this.isPrimary()) {
                f.this.aMR.onScrollStateChanged(absListView, i);
            }
            if (f.this.cjn != null) {
                f.this.cjn.a(absListView, i, 0);
            }
            if ((i == 2 || i == 1) && !f.this.cjc) {
                f.this.cjc = true;
                f.this.ciX.afS();
            }
            if (f.this.cjd == null && !f.this.aft()) {
                f.this.cjd = new com.baidu.tbadk.l.d();
                f.this.cjd.fi(1000);
            }
            if (i == 0) {
                com.baidu.tieba.card.u.WB().dE(true);
                f.this.ciX.ao(this.cke, this.bcZ);
            }
            if (f.this.cjC != null) {
                f.this.cjC.onScrollStateChanged(absListView, i);
            }
            if (f.this.cjd != null) {
                f.this.cjd.Gg();
            }
            if (i == 0) {
                com.baidu.tieba.frs.f.h.a(f.this.ciX, f.this.ciB, f.this.getForumId(), false, null);
            }
        }
    };
    private final b cjX = new b() { // from class: com.baidu.tieba.frs.f.14
        @Override // com.baidu.tieba.frs.b
        public void a(int i, int i2, View view, View view2, bl blVar) {
            if (i != f.this.ciX.afR().agP()) {
                if (i != f.this.ciX.afR().agQ()) {
                    if (i != f.this.ciX.afR().agS()) {
                        if (i != f.this.ciX.afR().agd()) {
                            if (i == f.this.ciX.afR().agR() && f.this.ciB != null && f.this.ciB.getUserData() != null && f.this.ciB.getUserData().isBawu()) {
                                final String bqU = f.this.ciB.bqU();
                                if (!com.baidu.tbadk.core.util.al.isEmpty(bqU) && f.this.ciB.aPh() != null) {
                                    com.baidu.tieba.c.a.a(f.this.getPageContext(), f.this.ciB.aPh().getId(), f.this.ciB.aPh().getName(), new a.InterfaceC0076a() { // from class: com.baidu.tieba.frs.f.14.1
                                        @Override // com.baidu.tieba.c.a.InterfaceC0076a
                                        public void Vo() {
                                            com.baidu.tbadk.browser.a.T(f.this.getPageContext().getPageActivity(), bqU);
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10502").aa("fid", f.this.ciB.aPh().getId()).aa(SapiAccountManager.SESSION_UID, f.this.ciB.getUserData().getUserId()));
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        f.this.ciO = blVar;
                        com.baidu.tieba.frs.f.i.a(f.this, f.this.ciO);
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10179").aa("fid", f.this.getForumId()));
                        return;
                    }
                    com.baidu.tieba.frs.f.i.B(f.this);
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aj(i == f.this.ciX.afR().agS() ? "c10177" : "c10244").aa("fid", f.this.getForumId()));
                } else if (aw.aO(f.this.getPageContext().getPageActivity())) {
                    TiebaStatic.log("my_service_ck");
                    if (f.this.ciB != null && f.this.ciB.aPh() != null) {
                        ForumData aPh = f.this.ciB.aPh();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(f.this.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(aPh.getId(), 0L), aPh.getName(), aPh.getImage_url(), 0)));
                    }
                }
            } else if (aw.aO(f.this.getActivity())) {
                TiebaStatic.log("forum_fortune_click");
                com.baidu.tieba.frs.f.i.a(f.this.getPageContext(), f.this.ciB);
            }
        }
    };
    private final NoNetworkView.a bEV = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.f.15
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aM(boolean z) {
            if (f.this.cjg.aiy() == 1 && z && !f.this.ciX.afs()) {
                if (f.this.ciB == null || com.baidu.tbadk.core.util.u.v(f.this.ciB.getThreadList())) {
                    f.this.hideNetRefreshView(f.this.ciX.VR());
                    f.this.showLoadingView(f.this.ciX.VR(), true);
                    f.this.ciX.eI(false);
                    f.this.refresh();
                    return;
                }
                f.this.ciX.afH();
            }
        }
    };
    private final CustomMessageListener cjY = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.f.16
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                com.baidu.tieba.frs.f.c.a(customResponsedMessage, f.this.ciX, f.this.ciB);
            }
        }
    };
    private com.baidu.adp.widget.ListView.h cjZ = new a();
    private ak cka = new ak() { // from class: com.baidu.tieba.frs.f.17
        @Override // com.baidu.tieba.frs.ak
        public void a(int i, int i2, aq aqVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
            com.baidu.adp.lib.g.e.ga().post(new Runnable() { // from class: com.baidu.tieba.frs.f.17.1
                @Override // java.lang.Runnable
                public void run() {
                    if (f.this.ciX != null && f.this.ciX.Xw()) {
                        f.this.MS();
                    }
                }
            });
        }
    };
    private CustomMessageListener ckb = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.frs.f.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    f.this.cjD = true;
                }
            }
        }
    };
    private final com.baidu.tbadk.util.g<Boolean> ckc = new com.baidu.tbadk.util.g<Boolean>() { // from class: com.baidu.tieba.frs.f.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.util.g
        /* renamed from: d */
        public void F(Boolean bool) {
            if (bool != null && f.this.ciX != null) {
                f.this.ciX.afW();
            }
        }
    };

    public com.baidu.tieba.frs.entelechy.b.b aeQ() {
        return this.cjp;
    }

    public com.baidu.adp.widget.ListView.h aeR() {
        return this.cjZ;
    }

    public com.baidu.tieba.frs.mc.e aeS() {
        return this.cjs;
    }

    public com.baidu.tieba.frs.smartsort.b aeT() {
        return this.cjl;
    }

    @Override // com.baidu.tieba.frs.mc.k
    public FrsModelController aeU() {
        return this.cjg;
    }

    @Override // com.baidu.tieba.frs.mc.k
    public com.baidu.tieba.frs.mc.d aeV() {
        return this.cjt;
    }

    @Override // com.baidu.tieba.frs.mc.k
    public com.baidu.tieba.frs.g.f aeW() {
        return this.cjh;
    }

    public com.baidu.tieba.frs.entelechy.b.d aeX() {
        return this.cji;
    }

    public am aeY() {
        return this.cjn;
    }

    @Override // com.baidu.tieba.frs.mc.k
    public i aeZ() {
        return this.ciX;
    }

    @Override // com.baidu.tieba.frs.al
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.al
    public String getForumName() {
        return this.ciP;
    }

    public void setForumName(String str) {
        this.ciP = str;
    }

    public void setFrom(String str) {
        this.ajt = str;
    }

    public String getFrom() {
        return this.ajt;
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
        if (this.cjt == null) {
            return 1;
        }
        return this.cjt.getPn();
    }

    public int getPn() {
        if (this.cjt == null) {
            return 1;
        }
        return this.cjt.getPn();
    }

    public void setPn(int i) {
        if (this.cjt != null) {
            this.cjt.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.cjt != null) {
            this.cjt.setHasMore(i);
        }
    }

    public int afa() {
        if (this.cjt == null) {
            return -1;
        }
        return this.cjt.afa();
    }

    public boolean afb() {
        return this.ciV;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d.a aVar, boolean z) {
        this.ciX.afC();
        if (aVar == null) {
            showNetRefreshView(this.ciX.VR(), TbadkCoreApplication.getInst().getString(d.l.error_unkown_try_again), true);
        } else if (aVar.geO) {
            if (340001 == aVar.errorCode) {
                showNetRefreshViewNoClick(this.ciX.VR(), TbadkCoreApplication.getInst().getString(d.l.net_error_text, new Object[]{aVar.errorMsg, Integer.valueOf(aVar.errorCode)}), true);
            } else {
                showNetRefreshView(this.ciX.VR(), TbadkCoreApplication.getInst().getString(d.l.net_error_text, new Object[]{aVar.errorMsg, Integer.valueOf(aVar.errorCode)}), true);
            }
        } else if (340001 == aVar.errorCode) {
            showNetRefreshViewNoClick(this.ciX.VR(), aVar.errorMsg, true);
        } else {
            showNetRefreshView(this.ciX.VR(), aVar.errorMsg, true);
        }
        if (aft()) {
            setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.k.g(TbadkCoreApplication.getInst(), d.f.ds280));
        } else {
            setNetRefreshViewEmotionDefMarginTop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afc() {
        eB(false);
    }

    private void eB(boolean z) {
        hideLoadingView(this.ciX.VR());
        this.ciX.ck(false);
        this.ciX.afN();
        if (this.ciX.afA() instanceof com.baidu.tieba.frs.tab.c) {
            ((com.baidu.tieba.frs.tab.c) this.ciX.afA()).ajc();
            if (!z) {
                this.cju.ajI();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afd() {
        if (afa() == 0 && com.baidu.tbadk.core.util.u.v(this.ciB.bqH())) {
            if (com.baidu.tbadk.core.util.u.v(this.ciB.getThreadList())) {
                this.ciX.XH();
                return;
            } else {
                this.ciX.VZ();
                return;
            }
        }
        this.ciX.VX();
    }

    public void a(ErrorData errorData) {
        afc();
        this.ciX.afH();
        d.a aiv = this.cjg.aiv();
        boolean v = com.baidu.tbadk.core.util.u.v(this.ciB.getThreadList());
        if (aiv != null && v) {
            if (v) {
                if (this.cjg.aiw() != 0) {
                    this.cjg.aiC();
                    this.ciX.afH();
                } else {
                    a(aiv, false);
                }
                this.ciX.s(this.ciB.brE(), false);
                return;
            } else if (aiv.geO) {
                this.ciX.s(true, false);
                showToast(getPageContext().getResources().getString(d.l.net_error_text, aiv.errorMsg, Integer.valueOf(aiv.errorCode)));
                return;
            } else {
                return;
            }
        }
        a(aiv, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afe() {
        if (this.ciB == null || this.ciB.aPh() != null) {
            this.ciX.afQ();
        } else if (this.ciB.aPh().getYuleData() != null && this.ciB.aPh().getYuleData().tj()) {
            TiebaStatic.log("c10852");
            this.ciX.a(this.ciB.aPh().getYuleData().tk());
        } else {
            this.ciX.afQ();
        }
    }

    private void q(boolean z, boolean z2) {
        if (this.cjg != null && this.ciB != null && this.ciX != null && z) {
            if (!this.cjg.aiI() && this.cjg.aiy() == 1) {
                if (!this.cjg.aiG()) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        this.ciB.brx();
                        this.ciB.bru();
                    }
                    this.ciB.brv();
                    this.ciB.brw();
                }
                boolean z3 = false;
                if (this.ciX.afR().k(com.baidu.tieba.card.data.p.bJX)) {
                    z3 = this.ciB.brA();
                }
                if (!z3) {
                    this.ciB.bry();
                }
                if (TbadkCoreApplication.getInst().isRecAppExist()) {
                    this.ciB.a(this);
                }
                if (!this.ciX.afR().k(bl.Ze)) {
                    this.ciB.brr();
                }
                this.ciB.brB();
                this.ciB.brC();
            }
            this.ciB.brs();
            this.ciB.brp();
            if (this.ciX.afR().k(com.baidu.tieba.g.b.cEX)) {
                this.ciB.mv(z2);
            }
        }
    }

    public boolean aff() {
        if (this.cji != null && this.ciX != null) {
            this.cji.b(this.ciX.getListView());
        }
        if (this.cjh != null && this.cjg != null) {
            this.cjh.a(this.cjg.aiu(), this.ciB);
        }
        boolean z = false;
        if (this.ciB != null) {
            z = this.ciB.brF();
        }
        eC(z);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iB(int i) {
        an anVar = null;
        aff();
        afo();
        try {
            if (this.ciB != null) {
                this.ciX.a((ArrayList<com.baidu.adp.widget.ListView.f>) null, this.ciB);
                this.cjh.jv(1);
                this.ciX.afK();
                this.cji.a(this.ciX.getListView(), this.ciB, this.cjg.aiE());
                com.baidu.tieba.frs.tab.d a2 = a(this.cji.agZ(), this.ciB.bqW());
                if (a2 != null && !TextUtils.isEmpty(a2.url)) {
                    anVar = new an();
                    anVar.cmc = a2.url;
                    anVar.stType = a2.name;
                }
                this.cjg.a(this.ciB.bqW(), 0, anVar);
                this.cji.eR(false);
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
            if (dVar != null && dVar.cwi == i) {
                return dVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(boolean z, boolean z2) {
        AlaLiveNotify brj;
        try {
            if (this.ciB != null && this.cji != null && this.cjg != null) {
                if (!this.ciX.afR().k(bl.Ze)) {
                    this.ciB.brr();
                }
                if (!com.baidu.tbadk.core.util.u.v(this.ciB.brk()) && this.cjC == null) {
                    this.cjC = new com.baidu.tieba.frs.g.e(this, (NoPressedRelativeLayout) this.mRootView);
                }
                if (this.ciB.aPh() != null) {
                    this.ciP = this.ciB.aPh().getName();
                    this.forumId = this.ciB.aPh().getId();
                }
                if (this.ciB.brF()) {
                    this.cji.a(this.ciX.getListView(), this.ciB, this.cjg.aiE());
                }
                if (z) {
                    q(true, z);
                } else {
                    q(this.cjf, z);
                }
                aff();
                if (this.cjp != null) {
                    this.cjp.a(this.cjh, this.ciB);
                }
                if (this.ciB.qH() != null) {
                    setHasMore(this.ciB.qH().qD());
                }
                ArrayList<com.baidu.adp.widget.ListView.f> a2 = this.cjt.a(z2, true, this.ciB.getThreadList(), null);
                if (a2 != null) {
                    this.ciB.aB(a2);
                }
                if (this.cjg.aiy() == 1) {
                    afl();
                    if (!z && this.cjg.getPn() == 1 && (brj = afr().brj()) != null) {
                        new com.baidu.tieba.frs.c.a().a(this, brj);
                    }
                }
                this.ciE = this.ciB.aiA();
                if (this.ciT != null) {
                    this.ciS = true;
                    this.ciT.te(this.ciE);
                    com.baidu.tieba.frs.f.a.a(this, this.ciB.aPh(), this.ciB.getThreadList(), this.ciS, getPn());
                }
                if (this.cjr != null) {
                    this.cjr.cj(this.cjg.aiI());
                    this.cjr.ao(this.cji.aha());
                }
                eB(z);
                this.ciX.afD();
                this.ciX.s(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.g gVar) {
        try {
            if (!this.cjb && gVar != null && this.ciB != null) {
                this.ciB.e(gVar);
                r(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void eC(boolean z) {
        if (this.cjg != null) {
            e(z, this.cjg.aiu());
        } else {
            e(z, "normal_page");
        }
    }

    private void e(boolean z, String str) {
        eD("frs_page".equals(str));
        if (this.cjp != null) {
            this.cjp.a(z, this.cji, this.cjh, this.ciX, this.ciB);
        }
    }

    public void eD(boolean z) {
        if (this.cju != null) {
            this.cju.a(this.ciX, z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(d.j.frs_activity, viewGroup, false);
            this.ciJ = new com.baidu.tieba.frs.entelechy.b();
            this.cjp = this.ciJ.ags();
            this.cjh = new com.baidu.tieba.frs.g.f(this, this.ciJ);
            this.cji = this.ciJ.z(this);
            Intent intent = this.cjz != null ? this.cjz : getActivity().getIntent();
            if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                this.ciL = true;
            }
            this.ciX = new i(this, this.cjV, this.ciJ, this.ciL);
            this.ciX.setHeaderViewHeight(this.cjA);
        } else if (this.mRootView.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            this.ciX.afX();
        }
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Intent intent = this.cjz != null ? this.cjz : getActivity().getIntent();
        this.bYB = System.currentTimeMillis();
        if (intent != null) {
            this.ciU = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.bYB = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            K(intent);
        }
        this.Xc = System.currentTimeMillis();
        this.aKa = this.Xc - this.bYB;
        this.ciT = new com.baidu.tieba.tbadkCore.data.e("frs", com.baidu.tieba.tbadkCore.data.e.ghm);
        this.cjg = new FrsModelController(this, this.cjP);
        this.cjg.a(this.cjH);
        this.cjg.init();
        if (intent != null) {
            this.cjg.f(intent.getExtras());
        } else if (bundle != null) {
            this.cjg.f(bundle);
        } else {
            this.cjg.f(null);
        }
        this.cji.al(this.ciX.VR());
        if (intent != null) {
            this.cjh.j(intent.getExtras());
        } else if (bundle != null) {
            this.cjh.j(bundle);
        } else {
            this.cjh.j((Bundle) null);
        }
        this.ciW = getVoiceManager();
        this.cjw = new h(getPageContext(), this);
        initUI();
        initData(bundle);
        if (this.ajt != null && this.ajt.equals("from_tieba_kuang")) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c12264").r("obj_type", 1).aa(ImageViewerConfig.FORUM_NAME, this.cjg.getForumName()));
            KuangFloatingViewController.getInstance().setNeedShowFloatingView(true);
            KuangFloatingViewController.getInstance().showFloatingView();
        }
        if (!aft()) {
            this.cjn = new am(getActivity(), this.ciX, this.cjh);
            this.cjn.a(this.ckc);
            this.cjn.eM(true);
        }
        this.ciW = getVoiceManager();
        if (this.ciW != null) {
            this.ciW.onCreate(getPageContext());
        }
        new com.baidu.tieba.frs.mc.h();
        this.cjt = new com.baidu.tieba.frs.mc.d(this, this.cjR);
        this.cjl = new com.baidu.tieba.frs.smartsort.b(this);
        this.cju = new com.baidu.tieba.frs.g.h(this);
        this.createTime = System.currentTimeMillis() - this.Xc;
        this.cjr = new com.baidu.tieba.frs.g.a(getPageContext(), this.cjg.aiF());
        this.cjm = new com.baidu.tieba.frs.mc.c(this);
        this.cjs = new com.baidu.tieba.frs.mc.e(this);
        this.cjj = new com.baidu.tieba.frs.mc.g(this);
        this.cjk = new com.baidu.tieba.frs.mc.b(this);
        this.cjv = new com.baidu.tieba.frs.mc.a(this);
        this.cjx = new com.baidu.tieba.frs.g.c(this);
        this.cjy = new com.baidu.tieba.frs.mc.f(this, getUniqueId());
        registerListener(this.mMemListener);
        registerListener(this.cjN);
        registerListener(this.cjT);
        registerListener(this.cjM);
        registerListener(this.cjQ);
        registerListener(this.cjJ);
        registerListener(this.cjK);
        registerListener(this.cjL);
        registerListener(this.cjF);
        registerListener(this.cjG);
        registerListener(this.ckb);
        registerListener(this.cjO);
        this.ciX.eI(false);
        if (!aft()) {
            showLoadingView(this.ciX.VR(), true);
            this.cjg.r(3, true);
        }
        super.onActivityCreated(bundle);
    }

    @Override // com.baidu.tieba.frs.ah
    public void afg() {
        if (isAdded() && this.bjA && !isLoadingViewAttached()) {
            showLoadingView(this.ciX.VR(), true);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void afh() {
        if (isAdded() && this.bjA && isLoadingViewAttached()) {
            hideLoadingView(this.ciX.VR());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (aft()) {
            showLoadingView(this.ciX.VR(), true);
            this.ciX.iE(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.cjg.r(3, true);
            getListView().setSelection(0);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void setHeaderViewHeight(int i) {
        this.cjA = i;
        if (this.ciX != null) {
            this.ciX.setHeaderViewHeight(this.cjA);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void setRecommendFrsNavigationAnimDispatcher(r rVar) {
        if (rVar != null) {
            this.aMR = rVar.Hp();
            this.cjB = rVar.Hq();
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void showFloatingView() {
        if (this.aMR != null) {
            this.aMR.cg(true);
        }
    }

    private void K(Intent intent) {
        if (intent != null) {
            if (!com.baidu.tieba.frs.f.f.a(this, getForumName(), "from", intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false))) {
                getActivity().finish();
                return;
            }
        }
        if (intent != null && intent.getData() != null) {
            Uri data = intent.getData();
            this.ciP = data.getQueryParameter("name");
            this.ajt = data.getQueryParameter("from");
            if (!StringUtils.isNull(this.ciP)) {
                intent.putExtra("name", this.ciP);
            }
            if (!StringUtils.isNull(this.ajt)) {
                intent.putExtra("from", this.ajt);
            }
            TiebaStatic.log("c10105");
        }
        if (StringUtils.isNull(this.ciP)) {
            this.ciP = com.baidu.tieba.frs.f.i.M(intent);
            if (!StringUtils.isNull(this.ciP)) {
                intent.putExtra("name", this.ciP);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.ciW = getVoiceManager();
        if (this.ciW != null) {
            this.ciW.onStart(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.cjY);
        if (bundle != null) {
            this.ciP = bundle.getString("name");
            this.ajt = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Intent intent = getActivity().getIntent();
            if (intent != null) {
                this.ciP = intent.getStringExtra("name");
                this.ajt = intent.getStringExtra("from");
                this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
            }
        }
        if (TextUtils.isEmpty(this.ajt) || FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.ajt)) {
        }
        if (this.mIsLogin) {
            registerListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL, this.cjY);
        }
        this.cjh.j(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.ckb);
        if (this.ciW != null) {
            this.ciW.onDestory(getPageContext());
        }
        this.ciW = null;
        com.baidu.tieba.card.u.WB().dE(false);
        if (this.ciB != null && this.ciB.aPh() != null) {
            ac.agh().bi(com.baidu.adp.lib.g.b.d(this.ciB.aPh().getId(), 0L));
        }
        if (this.ciX != null) {
            com.baidu.tieba.frs.f.h.a(this.ciX, this.ciB, getForumId(), false, null);
            this.ciX.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.cjd != null) {
                this.cjd.onDestroy();
            }
            this.ciX.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.cjg.onActivityDestroy();
        this.cjh.onActivityDestroy();
        if (this.cje != null) {
            this.cje.cancel(true);
            this.cje = null;
        }
        if (this.cjg != null) {
            this.cjg.Ox();
        }
        if (this.cjn != null) {
            this.cjn.Ho();
        }
        if (this.cjq != null) {
            this.cjq.destory();
        }
        if (this.cjr != null) {
            this.cjr.destory();
        }
        if (this.cjl != null) {
            this.cjl.onDestroy();
        }
        if (this.cjC != null) {
            this.cjC.onDestory();
        }
        com.baidu.tieba.recapp.d.a.bii().bik();
        com.baidu.tieba.frs.f.j.ajf();
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.ciP);
        bundle.putString("from", this.ajt);
        this.cjg.onSaveInstanceState(bundle);
        if (this.ciW != null) {
            this.ciW.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.cjv != null) {
            this.cjv.onActivityResult(i, i2, intent);
        }
    }

    public void a(UpdateAttentionMessage updateAttentionMessage) {
        Message<?> message;
        if (updateAttentionMessage != null && updateAttentionMessage.isAttention() && updateAttentionMessage.isGod() && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(getUniqueId())) {
            if (this.cjq == null) {
                this.cjq = new com.baidu.tbadk.i.a(getPageContext());
            }
            this.cjq.an(updateAttentionMessage.getData().toUid, getForumId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.ciX != null) {
            this.ciX.afH();
            this.ciX.onResume();
        }
        this.cji.a(this.cjI);
        this.cjj.eY(true);
        this.cjf = true;
        if (isNeedRefreshOnResume) {
            isNeedRefreshOnResume = false;
            this.ciX.startPullRefresh();
        } else if (ciM) {
            ciM = false;
            this.ciX.startPullRefresh();
        } else {
            if (this.ciW != null) {
                this.ciW.onResume(getPageContext());
            }
            this.ciX.eJ(false);
            registerListener(this.cjU);
            if (this.cjD) {
                cm(6);
                this.cjD = false;
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
    public void L(Intent intent) {
        this.cjz = intent;
    }

    public boolean afi() {
        Intent intent = this.cjz != null ? this.cjz : getActivity().getIntent();
        if (intent != null) {
            return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
        }
        return false;
    }

    public void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.ciP = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.ajt = intent.getStringExtra("from");
            }
            this.ciR = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.ciR) {
                afj();
            }
            if (this.ajt != null && this.ajt.equals("from_tieba_kuang")) {
                KuangFloatingViewController.getInstance().setNeedShowFloatingView(true);
                KuangFloatingViewController.getInstance().showFloatingView();
            }
        }
    }

    private void afj() {
        this.ciX.startPullRefresh();
    }

    public void closeActivity() {
        com.baidu.tieba.frs.f.i.a(getPageContext(), getActivity().getIntent(), this.ajt);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.ciX.setTitle(this.ciP);
        } else {
            this.ciX.setTitle("");
            this.mFlag = 1;
        }
        this.cjh.d(this.ciX.getListView());
        this.ciX.setOnAdapterItemClickListener(this.cjZ);
        this.ciX.setOnScrollListener(this.cjW);
        this.ciX.c(this.bEV);
        this.ciX.afR().a(this.cjX);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ciX.onChangeSkinType(i);
        this.cjh.ju(i);
        this.cji.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.d.c
    public void lz() {
    }

    @Override // com.baidu.adp.widget.d.c
    public void lA() {
    }

    public void iC(int i) {
        if (!this.mIsLogin) {
            if (this.ciB != null && this.ciB.qr() != null) {
                this.ciB.qr().setIfpost(1);
            }
            if (i == 0) {
                aw.aN(getActivity());
            }
        } else if (this.ciB != null) {
            if (i == 0) {
                if (!this.ciN) {
                    com.baidu.tieba.frs.f.j.b(this, 0);
                    return;
                }
                TiebaStatic.log("c10152");
                com.baidu.tieba.frs.f.j.b(this, 4);
                return;
            }
            this.ciX.afJ();
        }
    }

    public void refresh() {
        cm(3);
    }

    public void cm(int i) {
        this.cjb = false;
        afo();
        if (this.ciX.afz() != null) {
            this.ciX.afz().apY();
        }
        this.cjg.r(i, true);
    }

    private void afk() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.g.h.gb().f(new Runnable() { // from class: com.baidu.tieba.frs.f.10
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.sf(f.this.ciP);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afl() {
        afo();
        try {
            if (this.ciB != null) {
                this.ciX.Nr();
                this.ciX.eF(this.cjg.aiz());
                if (com.baidu.tieba.frs.g.f.i(this.ciB) && !com.baidu.tieba.frs.g.f.h(this.ciB)) {
                    this.ciX.afT();
                }
                if (this.ciB.aPh() != null) {
                    this.ciP = this.ciB.aPh().getName();
                    this.forumId = this.ciB.aPh().getId();
                }
                if (this.ciB.qH() != null) {
                    setHasMore(this.ciB.qH().qD());
                }
                this.ciX.setTitle(this.ciP);
                this.ciX.setForumName(this.ciP);
                TbadkCoreApplication.getInst().setDefaultBubble(this.ciB.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.ciB.getUserData().getBimg_end_time());
                afk();
                afm();
                ArrayList<com.baidu.adp.widget.ListView.f> threadList = this.ciB.getThreadList();
                if (threadList != null) {
                    this.ciX.a(threadList, this.ciB);
                    com.baidu.tieba.frs.f.c.j(this.ciX);
                    this.cjh.jv(getPageNum());
                    this.cjh.f(this.ciB);
                    this.cji.a(this.ciX.getListView(), this.ciB, this.cjg.aiE());
                    this.ciX.afK();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void afm() {
        if (this.ciB != null) {
            if (this.ciB.aPv() == 1) {
                this.ciX.afR().setFromCDN(true);
            } else {
                this.ciX.afR().setFromCDN(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.cjj.eY(false);
        this.cjf = false;
        this.ciX.onPause();
        if (this.ciW != null) {
            this.ciW.onPause(getPageContext());
        }
        this.ciX.eJ(true);
        if (this.cjr != null) {
            this.cjr.aji();
        }
        MessageManager.getInstance().unRegisterListener(this.cjU);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.u.WB().dE(false);
        if (this.ciB != null && this.ciB.aPh() != null) {
            com.baidu.tbadk.distribute.a.CK().a(getPageContext().getPageActivity(), "frs", this.ciB.aPh().getId(), 0L);
        }
        if (this.ciW != null) {
            this.ciW.onStop(getPageContext());
        }
        com.baidu.tieba.frs.f.i.c(getListView());
        this.cjh.onActivityStop();
        s.Hs();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || this.ciX == null) {
            return false;
        }
        return this.ciX.afG();
    }

    @Override // com.baidu.tieba.recapp.o
    public TbPageContext<?> yg() {
        return getPageContext();
    }

    @Override // com.baidu.tieba.recapp.o
    public void a(AdvertAppInfo advertAppInfo, String str) {
        com.baidu.tbadk.distribute.a.CK().a(advertAppInfo, this.forumId, 0L, "FRS", str, getPn());
    }

    @Override // com.baidu.tieba.recapp.o
    public void afn() {
        aeU().afn();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.ciW == null) {
            this.ciW = VoiceManager.instance();
        }
        return this.ciW;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public BdListView getListView() {
        if (this.ciX == null) {
            return null;
        }
        return this.ciX.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void afo() {
        if (this.ciW != null) {
            this.ciW.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> xn() {
        if (this.apA == null) {
            this.apA = UserIconBox.j(getPageContext().getPageActivity(), 8);
        }
        return this.apA;
    }

    public void afp() {
        if (getFragmentActivity() != null && getFragmentActivity().getCurrentFocus() != null) {
            com.baidu.adp.lib.util.k.b(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.g onGetPreLoadListView() {
        return getListView();
    }

    @Override // com.baidu.tieba.frs.aj
    public NavigationBar afq() {
        if (this.ciX == null) {
            return null;
        }
        return this.ciX.afq();
    }

    /* loaded from: classes.dex */
    private final class a implements com.baidu.adp.widget.ListView.h {
        private a() {
        }

        @Override // com.baidu.adp.widget.ListView.h
        public void a(View view, com.baidu.adp.widget.ListView.f fVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            boolean z;
            if (bdUniqueId != null) {
                if (bdUniqueId == p.clt) {
                    if (f.this.ciX != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11752").aa("fid", f.this.forumId).aa("obj_locate", "1"));
                        f.this.ciX.startPullRefresh();
                    }
                } else if (fVar != null && (fVar instanceof bl)) {
                    bl blVar = (bl) fVar;
                    if (blVar.sq() == null || blVar.sq().getGroup_id() == 0 || aw.aO(f.this.getActivity())) {
                        if ((blVar.sj() != 1 && blVar.sj() != 2) || aw.aO(f.this.getActivity())) {
                            if (blVar.rS() != null) {
                                if (aw.aO(f.this.getActivity())) {
                                    String postUrl = blVar.rS().getPostUrl();
                                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.k.hI()) {
                                        com.baidu.tbadk.browser.a.U(f.this.getActivity(), postUrl);
                                    }
                                }
                            } else if (blVar.sB() != null) {
                                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                    aw.aN(f.this.getPageContext().getPageActivity());
                                    return;
                                }
                                com.baidu.tbadk.core.data.n sB = blVar.sB();
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(f.this.getPageContext().getPageActivity(), sB.getCartoonId(), sB.getChapterId(), 2)));
                            } else if (blVar.getThreadType() == 47 && blVar.rA() == 1 && !com.baidu.tbadk.core.util.al.isEmpty(blVar.rM())) {
                                com.baidu.tbadk.browser.a.T(f.this.getPageContext().getPageActivity(), blVar.rM());
                            } else {
                                com.baidu.tieba.tbadkCore.util.f readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                                if (readThreadHistory != null && !readThreadHistory.sl(blVar.getId())) {
                                    readThreadHistory.sk(blVar.getId());
                                }
                                final String rM = blVar.rM();
                                if (rM == null || rM.equals("")) {
                                    z = false;
                                } else {
                                    new Thread(new Runnable() { // from class: com.baidu.tieba.frs.f.a.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            com.baidu.tbadk.core.util.w wVar = new com.baidu.tbadk.core.util.w(rM);
                                            wVar.vl().wh().mIsNeedAddCommenParam = false;
                                            wVar.vl().wh().mIsUseCurrentBDUSS = false;
                                            wVar.uf();
                                        }
                                    }).start();
                                    z = true;
                                }
                                String tid = blVar.getTid();
                                if (tid == null) {
                                    tid = "";
                                }
                                if (blVar.rA() == 2 && !tid.startsWith("pb:")) {
                                    com.baidu.tbadk.core.util.at.wf().c(f.this.getPageContext(), new String[]{tid, "", null});
                                } else if (blVar.getThreadType() == 33 || (blVar instanceof ay)) {
                                    String str = blVar.getThreadType() == 33 ? "c10245" : "c10180";
                                    if (f.this.cjg.aiy() == 5) {
                                        str = "c10387";
                                    }
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.aj(str).aa("fid", f.this.forumId));
                                    com.baidu.tieba.frs.f.i.c(f.this, blVar);
                                    if (f.this.ciB != null && f.this.ciB.aPh() != null) {
                                        com.baidu.tieba.frs.e.a aVar = new com.baidu.tieba.frs.e.a();
                                        aVar.cvB = f.this.ciB.gfq == 1;
                                        aVar.cvD = f.this.ciB.aPh().getId();
                                        aVar.cvC = f.this.aeU().aiE();
                                        com.baidu.tieba.frs.e.b.aiY().a(aVar, blVar, 1);
                                    }
                                } else {
                                    if (tid.startsWith("pb:")) {
                                        blVar.setId(tid.substring(3));
                                    }
                                    if (bdUniqueId.getId() == bl.aam.getId()) {
                                        com.baidu.tieba.frs.f.h.a(blVar.rn());
                                        com.baidu.tieba.frs.f.i.b(f.this, blVar);
                                        return;
                                    }
                                    com.baidu.tieba.frs.f.i.a(f.this, blVar, i, z);
                                    com.baidu.tieba.frs.f.h.a(f.this, f.this.ciB, blVar);
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
        if (com.baidu.adp.lib.util.k.hI()) {
            hideNetRefreshView(this.ciX.VR());
            showLoadingView(this.ciX.VR(), true);
            this.ciX.eI(false);
            this.cjg.r(3, true);
        }
    }

    public com.baidu.tieba.tbadkCore.i afr() {
        return this.ciB;
    }

    public boolean afs() {
        return this.ciX.afs();
    }

    public void P(Object obj) {
        if (this.cjm != null && this.cjm.cux != null) {
            this.cjm.cux.g(obj);
        }
    }

    public void Q(Object obj) {
        if (this.cjm != null && this.cjm.cuy != null) {
            this.cjm.cuy.g(obj);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.k.hI()) {
            this.ciX.XH();
        } else if (this.cjg.aiy() == 1) {
            MZ();
            MS();
        } else if (this.cjg.hasMore()) {
            MS();
        }
    }

    public void kj(String str) {
        MZ();
        showToast(str);
    }

    public void G(ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        MZ();
        if (!com.baidu.tbadk.core.util.u.v(arrayList)) {
            if (!this.cjg.aiI() && TbadkCoreApplication.getInst().isRecAppExist() && this.cjg.aiy() == 1) {
                this.ciB.a(this, arrayList);
            }
            ArrayList<com.baidu.adp.widget.ListView.f> a2 = this.cjt.a(false, false, arrayList, this.ciT);
            if (a2 != null) {
                this.ciB.aB(a2);
                this.ciX.a(a2, this.ciB);
            }
            if (this.cjg != null) {
                com.baidu.tieba.frs.e.b.a(this.ciB, this.cjg.aiE(), 2);
            }
        }
    }

    private void MZ() {
        if (afa() == 1 || this.cjt.aK(this.ciB.bqH())) {
            this.ciX.VX();
        } else if (com.baidu.tbadk.core.util.u.v(this.ciB.getThreadList())) {
            this.ciX.XH();
        } else {
            this.ciX.VZ();
        }
    }

    @Override // com.baidu.tieba.frs.mc.k
    public void MS() {
        if (this.cjt != null) {
            this.cjt.a(this.ciP, this.forumId, this.ciB);
        }
    }

    public void SE() {
        if (!com.baidu.tbadk.core.util.aa.d(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.ah.c(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return aft() ? "a034" : "a006";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (!aft()) {
            return super.getCurrentPageSourceKeyList();
        }
        if (super.getCurrentPageSourceKeyList() != null) {
            arrayList = new ArrayList(super.getCurrentPageSourceKeyList());
        } else {
            arrayList = new ArrayList();
        }
        if (!"a001".equals(com.baidu.tbadk.core.util.u.c(arrayList, arrayList.size() - 1))) {
            arrayList.add("a001");
            return arrayList;
        }
        return arrayList;
    }

    @Override // com.baidu.a.a.a.InterfaceC0000a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        com.baidu.tieba.frs.f.i.a(this, i, strArr, iArr);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.d(getForumId(), 0L));
        }
        return pageStayDurationItem;
    }

    public void eE(boolean z) {
        if (this.cjn != null) {
            this.cjn.eM(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.cjo.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a fI(int i) {
        return this.cjo.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        this.cjw.b(bVar);
    }

    public boolean aft() {
        return this.ciL;
    }

    @Override // com.baidu.tieba.frs.ah
    public void afu() {
        if (this.ciX != null) {
            showFloatingView();
            this.ciX.getListView().setSelection(0);
            this.ciX.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public ForumWriteData afv() {
        if (this.ciB == null || this.ciB.aPh() == null) {
            return null;
        }
        ForumData aPh = this.ciB.aPh();
        ForumWriteData forumWriteData = new ForumWriteData(aPh.getId(), aPh.getName(), aPh.getPrefixData(), this.ciB.qr());
        forumWriteData.setForumLevel(aPh.getUser_level());
        forumWriteData.setAvatar(this.ciB.aPh().getImage_url());
        return forumWriteData;
    }

    @Override // com.baidu.tieba.frs.ah
    public void xd() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void cH(boolean z) {
        if (this.ciX != null) {
            this.ciX.cH(z);
        }
    }
}
