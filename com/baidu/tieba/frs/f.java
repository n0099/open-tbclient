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
public class f extends BaseFragment implements BdListView.e, d.c, a.InterfaceC0023a, UserIconBox.b, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, ah, aj, al, com.baidu.tieba.frs.mc.k, com.baidu.tieba.recapp.o {
    private q aMS;
    private com.baidu.adp.lib.e.b<TbImageView> apB;
    private boolean cjA;
    public bl cjB;
    private com.baidu.tieba.tbadkCore.data.e cjG;
    private VoiceManager cjJ;
    private f.a cjR;
    private FrsModelController cjT;
    private com.baidu.tieba.frs.g.f cjU;
    private com.baidu.tieba.frs.entelechy.b.d cjV;
    private com.baidu.tieba.frs.mc.g cjW;
    private com.baidu.tieba.frs.mc.b cjX;
    private com.baidu.tieba.frs.smartsort.b cjY;
    private com.baidu.tieba.frs.mc.c cjZ;
    private com.baidu.tieba.frs.entelechy.b cjw;
    private boolean ckF;
    private am cka;
    private com.baidu.tieba.frs.entelechy.b.b ckc;
    private com.baidu.tbadk.i.a ckd;
    private com.baidu.tieba.frs.g.a cke;
    private com.baidu.tieba.frs.mc.e ckf;
    private com.baidu.tieba.frs.mc.d ckg;
    private com.baidu.tieba.frs.g.h ckh;
    private com.baidu.tieba.frs.mc.a cki;
    private h ckj;
    public com.baidu.tieba.frs.g.c ckk;
    private com.baidu.tieba.frs.mc.f ckl;
    private Intent ckm;
    private int ckn;
    private View.OnTouchListener cko;
    private com.baidu.tieba.frs.g.e ckp;
    private boolean ckq;
    public View mRootView;
    private static boolean isNeedRefreshOnResume = false;
    public static boolean cjz = false;
    public static volatile long cjL = 0;
    public static volatile long cjM = 0;
    public static volatile int cjN = 0;
    public boolean cjx = false;
    private boolean cjy = false;
    public String cjC = null;
    public String ajv = null;
    public int mFlag = 0;
    private boolean cjD = false;
    private boolean cjE = false;
    private String mThreadId = null;
    private String forumId = null;
    private int cjq = 0;
    private boolean cjF = false;
    private boolean cjH = false;
    private boolean cjI = false;
    private i cjK = null;
    public final bl bgF = null;
    private com.baidu.tieba.tbadkCore.i cjn = new com.baidu.tieba.tbadkCore.i();
    public long bZn = -1;
    public long aKj = 0;
    public long aKb = 0;
    public long createTime = 0;
    public long Xe = -1;
    private boolean cjO = false;
    private boolean cjP = false;
    public com.baidu.tbadk.l.d cjQ = null;
    private boolean cjS = true;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> ckb = new SparseArray<>();
    private boolean bjB = true;
    private boolean ckr = false;
    private final CustomMessageListener cks = new CustomMessageListener(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED) { // from class: com.baidu.tieba.frs.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof bl) {
                    com.baidu.tieba.frs.f.h.a(f.this.cjK, f.this.cjn, f.this.getForumId(), true, (bl) data);
                }
            }
        }
    };
    private CustomMessageListener ckt = new CustomMessageListener(CmdConfigCustom.CMD_CLOSE_GAME_RANK_CARD) { // from class: com.baidu.tieba.frs.f.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (f.this.cjn != null) {
                f.this.cjn.bsh();
                if (f.this.cjK != null) {
                    f.this.cjK.Yb();
                }
            }
        }
    };
    private final ak cku = new ak() { // from class: com.baidu.tieba.frs.f.19
        @Override // com.baidu.tieba.frs.ak
        public void a(int i, int i2, aq aqVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
            f.this.afy();
            if (f.this.ckc != null) {
                f.this.cjU.fd(f.this.ckc.iR(i));
            }
            d.a aVar = new d.a();
            if (aqVar != null) {
                aVar.isSuccess = aqVar.errCode == 0;
                aVar.errorCode = aqVar.errCode;
                aVar.errorMsg = aqVar.errMsg;
                if (aVar.isSuccess) {
                    if (com.baidu.tbadk.core.util.u.v(arrayList)) {
                        f.this.cjK.Yc();
                    } else if (aqVar.hasMore) {
                        f.this.cjK.Wt();
                    } else if (aqVar.cmS) {
                        f.this.cjK.Wv();
                    } else {
                        f.this.cjK.Yc();
                    }
                }
            } else {
                aqVar = new aq();
                aqVar.pn = 1;
                aqVar.hasMore = false;
                aqVar.cmS = false;
            }
            if (i == 1) {
                f.this.cjS = true;
                f.this.ckC.a(f.this.cjT.getType(), false, aVar);
            } else {
                f.this.a(aVar, true);
                if (f.this.cjT.aim() != null) {
                    f.this.cjn = f.this.cjT.aim();
                }
                f.this.afH();
            }
            if (f.this.ckN != null) {
                f.this.ckN.a(i, i2, aqVar, arrayList);
            }
        }
    };
    private ai ckv = new ai() { // from class: com.baidu.tieba.frs.f.20
        @Override // com.baidu.tieba.frs.ai
        public void a(ak akVar) {
        }

        @Override // com.baidu.tieba.frs.ai
        public void a(int i, int i2, an anVar) {
            if (i != 1) {
                com.baidu.tieba.card.u.WX().dF(false);
            }
            if (i == 1) {
                f.this.cjK.eJ(true);
                f.this.cjK.eI(false);
            } else {
                f.this.cjK.eK(true);
                f.this.cjK.eI(true);
            }
            f.this.afK();
            f.this.cjT.a(i, i2, anVar);
        }

        @Override // com.baidu.tieba.frs.ai
        public void init() {
        }

        @Override // com.baidu.tieba.frs.ai
        public void Ox() {
        }
    };
    private CustomMessageListener ckw = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIVE_COUNT) { // from class: com.baidu.tieba.frs.f.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                ((com.baidu.tieba.frs.entelechy.c.a) f.this.cjV).iT(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    };
    private CustomMessageListener ckx = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_LIVE_START) { // from class: com.baidu.tieba.frs.f.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && ((Integer) customResponsedMessage.getData()).intValue() == 51 && f.this.cjn != null) {
                com.baidu.tieba.frs.f.j.a(f.this.cjn, f.this.getPageContext());
            }
        }
    };
    private final CustomMessageListener cky = new CustomMessageListener(CmdConfigCustom.CMD_FRS_SELECT_ALA_LIVE_TAB) { // from class: com.baidu.tieba.frs.f.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (f.this.cjV instanceof com.baidu.tieba.frs.entelechy.c.a) && ((com.baidu.tieba.frs.entelechy.c.a) f.this.cjV).ahB() != null) {
                ((com.baidu.tieba.frs.entelechy.c.a) f.this.cjV).ahB().jx(49);
            }
        }
    };
    private final CustomMessageListener ckz = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.frs.f.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && f.this.cjn != null && f.this.cjn.aPO() != null) {
                SignData signData = (SignData) customResponsedMessage.getData();
                int user_level = f.this.cjn.aPO().getUser_level();
                if (signData.forumId != null && signData.forumId.equals(f.this.cjn.aPO().getId())) {
                    f.this.cjn.d(signData);
                    f.this.cjU.g(f.this.cjn);
                    if (f.this.cjU.aki()) {
                        i = f.this.cjn.aPO().getUser_level();
                        if (user_level >= i) {
                            i++;
                        }
                    } else {
                        i = user_level;
                    }
                    TbadkCoreApplication.getInst().addSignedForum(f.this.cjn.aPO().getName(), signData.sign_bonus_point, i);
                }
            }
        }
    };
    private final CustomMessageListener ckA = new CustomMessageListener(CmdConfigCustom.CMD_FRS_EXPERIENCE_TIP) { // from class: com.baidu.tieba.frs.f.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.o) && f.this.cjn != null) {
                f.this.cjn.c((com.baidu.tieba.tbadkCore.o) customResponsedMessage.getData());
                f.this.cjU.f(f.this.cjn);
                f.this.cjV.a(f.this.cjK.getListView(), f.this.cjn, f.this.cjT.ajl());
            }
        }
    };
    private CustomMessageListener ckB = new CustomMessageListener(CmdConfigCustom.CMD_STORY_READ_CACHE) { // from class: com.baidu.tieba.frs.f.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.story.process.b)) {
                com.baidu.tieba.story.process.b bVar = (com.baidu.tieba.story.process.b) customResponsedMessage.getData();
                if (f.this.forumId != null && f.this.forumId.equals(String.valueOf(bVar.forumId)) && bVar.state == 3 && f.this.afN() != null && !com.baidu.tbadk.core.util.u.v(f.this.afN().brf()) && f.this.cjw.agO() != null && f.this.cjw.agO().ahe() != null) {
                    List<com.baidu.adp.widget.ListView.f> brf = f.this.afN().brf();
                    int size = brf.size();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= size) {
                            i = -1;
                            break;
                        } else if ((brf.get(i2) instanceof com.baidu.tbadk.data.f) && TbadkCoreApplication.getCurrentAccount().equals(String.valueOf(((com.baidu.tbadk.data.f) brf.get(i2)).user_id))) {
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
                    fVar.aAC = String.valueOf(f.this.forumId);
                    fVar.aAB = bVar;
                    if (i != -1) {
                        brf.set(i, fVar);
                    } else {
                        brf.add(1, fVar);
                    }
                    f.this.cjw.agO().ahe().b(brf, f.this.forumId, f.this.getThreadId());
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.k ckC = new com.baidu.tieba.tbadkCore.k() { // from class: com.baidu.tieba.frs.f.3
        private long startTime = 0;

        @Override // com.baidu.tieba.tbadkCore.k
        public void iF(int i) {
            this.startTime = System.nanoTime();
            if (f.this.cjK != null) {
                switch (i) {
                    case 1:
                    case 2:
                        f.this.cjK.age();
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
            if (f.this.bjB) {
                f.this.bjB = false;
                com.baidu.tieba.frs.f.h.a(f.this.cjK, f.this.cjn, f.this.getForumId(), false, null);
            }
            f.this.afy();
            f.this.cjO = true;
            if (aVar != null && aVar.isSuccess) {
                f.this.cjK.ago().eR(com.baidu.tbadk.core.util.am.vQ().vS());
                f.cjL = 0L;
                f.cjM = 0L;
                f.cjN = 0;
            } else {
                f.cjN = 1;
            }
            if (!f.this.cjT.ajp() && (i == 3 || i == 6)) {
                f.this.ckg.resetData();
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (f.this.cjT.aim() != null) {
                f.this.cjn = f.this.cjT.aim();
            }
            if (i == 7) {
                f.this.iD(f.this.cjn.brE());
                return;
            }
            if (f.this.cjn.qH() != null) {
                f.this.setHasMore(f.this.cjn.qH().qD());
            }
            f.this.afz();
            if (i == 4) {
                if (!f.this.cjT.ajp() && TbadkCoreApplication.getInst().isRecAppExist() && f.this.cjT.ajf() == 1) {
                    f.this.cjn.a(f.this);
                }
                ArrayList<com.baidu.adp.widget.ListView.f> a2 = f.this.ckg.a(false, false, f.this.cjn.getThreadList(), f.this.cjG);
                if (a2 != null) {
                    f.this.cjn.aB(a2);
                    f.this.cjn.bsa();
                    f.this.cjK.a(a2, f.this.cjn);
                }
                if (f.this.cjT != null) {
                    com.baidu.tieba.frs.e.b.a(f.this.cjn, f.this.cjT.ajl(), 2);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    f.this.cjK.age();
                    break;
                case 2:
                    f.this.cjK.age();
                    break;
                case 3:
                case 6:
                    if (f.this.cjn != null) {
                        f.this.cjn.brY();
                    }
                    if (f.this.ckk != null) {
                        f.this.ckk.refresh();
                        break;
                    }
                    break;
            }
            f.this.afA();
            if (aVar == null || aVar.errorCode == 0) {
                if (f.this.cjn != null) {
                    f.this.cjK.iH(i);
                    f.this.s(false, i == 5);
                    f.cjL = (System.nanoTime() - this.startTime) / 1000000;
                    if (aVar != null) {
                        f.cjM = aVar.ggH;
                    }
                } else {
                    return;
                }
            } else if (f.this.cjn == null || com.baidu.tbadk.core.util.u.v(f.this.cjn.getThreadList())) {
                f.this.a(aVar, false);
            } else if (aVar.ggG) {
                f.this.showToast(f.this.getPageContext().getResources().getString(d.l.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
            }
            if (f.this.cjn.brj() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11384"));
            }
            if (f.this.bZn > -1 && !f.this.ckr) {
                com.baidu.tieba.frs.f.h.a(f.this.cjT, f.this.bZn);
                f.this.bZn = -1L;
                f.this.ckr = true;
            }
            if (f.this.cjH && (f.this.cjV instanceof com.baidu.tieba.frs.entelechy.c.a) && ((com.baidu.tieba.frs.entelechy.c.a) f.this.cjV).ahB() != null) {
                ((com.baidu.tieba.frs.entelechy.c.a) f.this.cjV).ahB().jx(49);
                f.this.cjH = false;
            }
            f.this.aKj = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.k
        public void b(com.baidu.tieba.tbadkCore.g gVar) {
            if (gVar != null) {
                if ("normal_page".equals(f.this.cjT.ajb()) || "frs_page".equals(f.this.cjT.ajb()) || "book_page".equals(f.this.cjT.ajb())) {
                    f.this.a(gVar);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE, gVar));
                }
            }
        }
    };
    private final CustomMessageListener ckD = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.frs.f.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                f.this.cjn.a((com.baidu.tbadk.data.j) customResponsedMessage.getData());
                f.this.cjK.ago().notifyDataSetChanged();
            }
        }
    };
    private final CustomMessageListener mMemListener = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_MEM) { // from class: com.baidu.tieba.frs.f.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && f.this.cjn != null && (userData = f.this.cjn.getUserData()) != null) {
                userData.setIsMem(num.intValue());
                if (num.intValue() != 0) {
                    f.this.cjU.e(num);
                }
            }
        }
    };
    private final com.baidu.tieba.frs.mc.j ckE = new com.baidu.tieba.frs.mc.j() { // from class: com.baidu.tieba.frs.f.6
        @Override // com.baidu.tieba.frs.mc.j
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
            if (f.this.cjY != null && f.this.cjT != null && f.this.cjT.ajp() && z && !z2) {
                f.this.cjY.jr(i2);
            }
        }
    };
    public final View.OnTouchListener aMT = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.f.7
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (f.this.cko != null) {
                f.this.cko.onTouch(view, motionEvent);
            }
            if (f.this.cka != null && f.this.cka.agG() != null) {
                f.this.cka.agG().onTouchEvent(motionEvent);
            }
            f.this.ckF = true;
            if (f.this.cjU != null) {
                f.this.cjU.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private final CustomMessageListener ckG = new CustomMessageListener(CmdConfigCustom.CMD_GOTOLIVE_HOST_UPGRADE) { // from class: com.baidu.tieba.frs.f.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "photolive_hostLevel", -1) != -1 && f.this.cjn.aPO() != null) {
                f.this.cjn.aPO().setCanAddPhotoLivePost(true);
            }
        }
    };
    private final CustomMessageListener ckH = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.frs.f.9
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
    public final View.OnClickListener ckI = new View.OnClickListener() { // from class: com.baidu.tieba.frs.f.11
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (f.this.cjK == null || view != f.this.cjK.agc() || f.this.getActivity() == null) {
                if (f.this.cjn != null && f.this.cjn.aPO() != null) {
                    if (f.this.cjK == null || view != f.this.cjK.agi()) {
                        if (f.this.cjK != null && view == f.this.cjK.agj()) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10378").r("obj_type", 5));
                            if (!StringUtils.isNull(f.this.cjn.aPO().getName())) {
                                f.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PostSearchActivityConfig(f.this.getPageContext().getPageActivity(), f.this.cjn.aPO().getName())));
                                return;
                            }
                            return;
                        }
                    } else if (!StringUtils.isNull(f.this.cjn.aPO().getId())) {
                        if (f.this.cjn.aPO() != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c12046").aa("fid", f.this.cjn.aPO().getId()).r("obj_locate", f.this.afQ() ? 1 : 2));
                        }
                        f.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(f.this.getPageContext().getPageActivity(), f.this.cjn.aPO().getId(), ForumDetailActivityConfig.FromType.FRS)));
                        return;
                    } else {
                        return;
                    }
                }
                if (view.getId() == d.h.game_activity_egg_layout && com.baidu.adp.lib.util.k.hI()) {
                    TiebaStatic.log("c10853");
                    if (f.this.cjK.agl()) {
                        f.this.cjK.agm();
                        return;
                    }
                    String activityUrl = f.this.cjn.aPO().getYuleData().tk().getActivityUrl();
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
    private final AbsListView.OnScrollListener ckJ = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.f.13
        private int ckQ = 0;
        private int bda = 0;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (f.this.aMS != null && f.this.isPrimary()) {
                f.this.aMS.a(absListView, this.ckQ, i, i2, i3);
            }
            if (f.this.cjV != null) {
                f.this.cjV.a(absListView, i, i2, i3, f.this.cjU.akn());
            }
            if (f.this.cke != null) {
                f.this.cke.ajP();
            }
            if (f.this.cjY != null) {
                f.this.cjY.ajA();
            }
            if (f.this.cka != null) {
                f.this.cka.a(absListView, i, i2, i3, f.this.cjU.akn(), false);
            }
            if (f.this.ckp != null) {
                f.this.ckp.onScroll(absListView, i, i2, i3);
            }
            if (f.this.cjn != null && f.this.cjK != null && f.this.cjK.ago() != null) {
                this.ckQ = i;
                this.bda = (i + i2) - 1;
                f.this.cjK.ap(this.ckQ, this.bda);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (f.this.cjU != null) {
                f.this.cjU.setScrollState(i);
            }
            if (f.this.aMS != null && f.this.isPrimary()) {
                f.this.aMS.onScrollStateChanged(absListView, i);
            }
            if (f.this.cka != null) {
                f.this.cka.a(absListView, i, 0);
            }
            if ((i == 2 || i == 1) && !f.this.cjP) {
                f.this.cjP = true;
                f.this.cjK.agq();
            }
            if (f.this.cjQ == null && !f.this.afQ()) {
                f.this.cjQ = new com.baidu.tbadk.l.d();
                f.this.cjQ.fi(1000);
            }
            if (i == 0) {
                com.baidu.tieba.card.u.WX().dF(true);
                f.this.cjK.ao(this.ckQ, this.bda);
            }
            if (f.this.ckp != null) {
                f.this.ckp.onScrollStateChanged(absListView, i);
            }
            if (f.this.cjQ != null) {
                f.this.cjQ.Gg();
            }
            if (i == 0) {
                com.baidu.tieba.frs.f.h.a(f.this.cjK, f.this.cjn, f.this.getForumId(), false, null);
            }
        }
    };
    private final b ckK = new b() { // from class: com.baidu.tieba.frs.f.14
        @Override // com.baidu.tieba.frs.b
        public void a(int i, int i2, View view, View view2, bl blVar) {
            if (i != f.this.cjK.ago().ahk()) {
                if (i != f.this.cjK.ago().ahl()) {
                    if (i != f.this.cjK.ago().ahn()) {
                        if (i != f.this.cjK.ago().agy()) {
                            if (i == f.this.cjK.ago().ahm() && f.this.cjn != null && f.this.cjn.getUserData() != null && f.this.cjn.getUserData().isBawu()) {
                                final String brC = f.this.cjn.brC();
                                if (!com.baidu.tbadk.core.util.al.isEmpty(brC) && f.this.cjn.aPO() != null) {
                                    com.baidu.tieba.c.a.a(f.this.getPageContext(), f.this.cjn.aPO().getId(), f.this.cjn.aPO().getName(), new a.InterfaceC0076a() { // from class: com.baidu.tieba.frs.f.14.1
                                        @Override // com.baidu.tieba.c.a.InterfaceC0076a
                                        public void VK() {
                                            com.baidu.tbadk.browser.a.T(f.this.getPageContext().getPageActivity(), brC);
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10502").aa("fid", f.this.cjn.aPO().getId()).aa(SapiAccountManager.SESSION_UID, f.this.cjn.getUserData().getUserId()));
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        f.this.cjB = blVar;
                        com.baidu.tieba.frs.f.i.a(f.this, f.this.cjB);
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10179").aa("fid", f.this.getForumId()));
                        return;
                    }
                    com.baidu.tieba.frs.f.i.B(f.this);
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aj(i == f.this.cjK.ago().ahn() ? "c10177" : "c10244").aa("fid", f.this.getForumId()));
                } else if (aw.aO(f.this.getPageContext().getPageActivity())) {
                    TiebaStatic.log("my_service_ck");
                    if (f.this.cjn != null && f.this.cjn.aPO() != null) {
                        ForumData aPO = f.this.cjn.aPO();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(f.this.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(aPO.getId(), 0L), aPO.getName(), aPO.getImage_url(), 0)));
                    }
                }
            } else if (aw.aO(f.this.getActivity())) {
                TiebaStatic.log("forum_fortune_click");
                com.baidu.tieba.frs.f.i.a(f.this.getPageContext(), f.this.cjn);
            }
        }
    };
    private final NoNetworkView.a bFE = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.f.15
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aM(boolean z) {
            if (f.this.cjT.ajf() == 1 && z && !f.this.cjK.afO()) {
                if (f.this.cjn == null || com.baidu.tbadk.core.util.u.v(f.this.cjn.getThreadList())) {
                    f.this.hideNetRefreshView(f.this.cjK.Wn());
                    f.this.showLoadingView(f.this.cjK.Wn(), true);
                    f.this.cjK.eK(false);
                    f.this.refresh();
                    return;
                }
                f.this.cjK.age();
            }
        }
    };
    private final CustomMessageListener ckL = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.f.16
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                com.baidu.tieba.frs.f.c.a(customResponsedMessage, f.this.cjK, f.this.cjn);
            }
        }
    };
    private com.baidu.adp.widget.ListView.h ckM = new a();
    private ak ckN = new ak() { // from class: com.baidu.tieba.frs.f.17
        @Override // com.baidu.tieba.frs.ak
        public void a(int i, int i2, aq aqVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
            com.baidu.adp.lib.g.e.ga().post(new Runnable() { // from class: com.baidu.tieba.frs.f.17.1
                @Override // java.lang.Runnable
                public void run() {
                    if (f.this.cjK != null && f.this.cjK.XS()) {
                        f.this.MS();
                    }
                }
            });
        }
    };
    private CustomMessageListener ckO = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.frs.f.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    f.this.ckq = true;
                }
            }
        }
    };

    public com.baidu.tieba.frs.entelechy.b.b afm() {
        return this.ckc;
    }

    public com.baidu.adp.widget.ListView.h afn() {
        return this.ckM;
    }

    public com.baidu.tieba.frs.mc.e afo() {
        return this.ckf;
    }

    public com.baidu.tieba.frs.smartsort.b afp() {
        return this.cjY;
    }

    @Override // com.baidu.tieba.frs.mc.k
    public FrsModelController afq() {
        return this.cjT;
    }

    @Override // com.baidu.tieba.frs.mc.k
    public com.baidu.tieba.frs.mc.d afr() {
        return this.ckg;
    }

    @Override // com.baidu.tieba.frs.mc.k
    public com.baidu.tieba.frs.g.f afs() {
        return this.cjU;
    }

    public com.baidu.tieba.frs.entelechy.b.d aft() {
        return this.cjV;
    }

    public am afu() {
        return this.cka;
    }

    @Override // com.baidu.tieba.frs.mc.k
    public i afv() {
        return this.cjK;
    }

    @Override // com.baidu.tieba.frs.al
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.al
    public String getForumName() {
        return this.cjC;
    }

    public void setForumName(String str) {
        this.cjC = str;
    }

    public void setFrom(String str) {
        this.ajv = str;
    }

    public String getFrom() {
        return this.ajv;
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
        if (this.ckg == null) {
            return 1;
        }
        return this.ckg.getPn();
    }

    public int getPn() {
        if (this.ckg == null) {
            return 1;
        }
        return this.ckg.getPn();
    }

    public void setPn(int i) {
        if (this.ckg != null) {
            this.ckg.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.ckg != null) {
            this.ckg.setHasMore(i);
        }
    }

    public int afw() {
        if (this.ckg == null) {
            return -1;
        }
        return this.ckg.afw();
    }

    public boolean afx() {
        return this.cjI;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d.a aVar, boolean z) {
        this.cjK.afZ();
        if (aVar == null) {
            showNetRefreshView(this.cjK.Wn(), TbadkCoreApplication.getInst().getString(d.l.error_unkown_try_again), true);
        } else if (aVar.ggG) {
            if (340001 == aVar.errorCode) {
                showNetRefreshViewNoClick(this.cjK.Wn(), TbadkCoreApplication.getInst().getString(d.l.net_error_text, new Object[]{aVar.errorMsg, Integer.valueOf(aVar.errorCode)}), true);
            } else {
                showNetRefreshView(this.cjK.Wn(), TbadkCoreApplication.getInst().getString(d.l.net_error_text, new Object[]{aVar.errorMsg, Integer.valueOf(aVar.errorCode)}), true);
            }
        } else if (340001 == aVar.errorCode) {
            showNetRefreshViewNoClick(this.cjK.Wn(), aVar.errorMsg, true);
        } else {
            showNetRefreshView(this.cjK.Wn(), aVar.errorMsg, true);
        }
        if (afQ()) {
            setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.k.g(TbadkCoreApplication.getInst(), d.f.ds280));
        } else {
            setNetRefreshViewEmotionDefMarginTop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afy() {
        eD(false);
    }

    private void eD(boolean z) {
        hideLoadingView(this.cjK.Wn());
        this.cjK.ck(false);
        this.cjK.agk();
        if (this.cjK.afX() instanceof com.baidu.tieba.frs.tab.c) {
            ((com.baidu.tieba.frs.tab.c) this.cjK.afX()).ajJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afz() {
        if (afw() == 0 && com.baidu.tbadk.core.util.u.v(this.cjn.brp())) {
            if (com.baidu.tbadk.core.util.u.v(this.cjn.getThreadList())) {
                this.cjK.Yc();
                return;
            } else {
                this.cjK.Wv();
                return;
            }
        }
        this.cjK.Wt();
    }

    public void a(ErrorData errorData) {
        afy();
        this.cjK.age();
        d.a ajc = this.cjT.ajc();
        boolean v = com.baidu.tbadk.core.util.u.v(this.cjn.getThreadList());
        if (ajc != null && v) {
            if (v) {
                if (this.cjT.ajd() != 0) {
                    this.cjT.ajj();
                    this.cjK.age();
                } else {
                    a(ajc, false);
                }
                this.cjK.t(this.cjn.bsm(), false);
                return;
            } else if (ajc.ggG) {
                this.cjK.t(true, false);
                showToast(getPageContext().getResources().getString(d.l.net_error_text, ajc.errorMsg, Integer.valueOf(ajc.errorCode)));
                return;
            } else {
                return;
            }
        }
        a(ajc, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afA() {
        if (this.cjn == null || this.cjn.aPO() != null) {
            this.cjK.agn();
        } else if (this.cjn.aPO().getYuleData() != null && this.cjn.aPO().getYuleData().tj()) {
            TiebaStatic.log("c10852");
            this.cjK.a(this.cjn.aPO().getYuleData().tk());
        } else {
            this.cjK.agn();
        }
    }

    private void r(boolean z, boolean z2) {
        if (this.cjT != null && this.cjn != null && this.cjK != null && z) {
            if (!this.cjT.ajp() && this.cjT.ajf() == 1) {
                if (!this.cjT.ajn()) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        this.cjn.bsf();
                        this.cjn.bsc();
                    }
                    this.cjn.bsd();
                    this.cjn.bse();
                }
                boolean z3 = false;
                if (this.cjK.ago().k(com.baidu.tieba.card.data.p.bKG)) {
                    z3 = this.cjn.bsi();
                }
                if (!z3) {
                    this.cjn.bsg();
                }
                if (TbadkCoreApplication.getInst().isRecAppExist()) {
                    this.cjn.a(this);
                }
                if (!this.cjK.ago().k(bl.Zg)) {
                    this.cjn.brZ();
                }
                this.cjn.bsj();
                this.cjn.bsk();
            }
            this.cjn.bsa();
            this.cjn.brX();
            if (this.cjK.ago().k(com.baidu.tieba.g.b.cGU)) {
                this.cjn.my(z2);
            }
        }
    }

    public boolean afB() {
        if (this.cjV != null && this.cjK != null) {
            this.cjV.b(this.cjK.getListView());
        }
        if (this.cjU != null && this.cjT != null) {
            this.cjU.a(this.cjT.ajb(), this.cjn);
        }
        boolean z = false;
        if (this.cjn != null) {
            z = this.cjn.bsn();
        }
        eE(z);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iD(int i) {
        an anVar = null;
        afB();
        afK();
        try {
            if (this.cjn != null) {
                this.cjK.a((ArrayList<com.baidu.adp.widget.ListView.f>) null, this.cjn);
                this.cjU.jF(1);
                this.cjK.agh();
                this.cjV.a(this.cjK.getListView(), this.cjn, this.cjT.ajl());
                com.baidu.tieba.frs.tab.d a2 = a(this.cjV.ahu(), this.cjn.brE());
                if (a2 != null && !TextUtils.isEmpty(a2.url)) {
                    anVar = new an();
                    anVar.cmO = a2.url;
                    anVar.stType = a2.name;
                }
                this.cjT.a(this.cjn.brE(), 0, anVar);
                this.cjV.eT(false);
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
            if (dVar != null && dVar.cuL == i) {
                return dVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(boolean z, boolean z2) {
        AlaLiveNotify brR;
        try {
            if (this.cjn != null && this.cjV != null && this.cjT != null) {
                if (!this.cjK.ago().k(bl.Zg)) {
                    this.cjn.brZ();
                }
                if (!com.baidu.tbadk.core.util.u.v(this.cjn.brS()) && this.ckp == null) {
                    this.ckp = new com.baidu.tieba.frs.g.e(this, (NoPressedRelativeLayout) this.mRootView);
                }
                if (this.cjn.aPO() != null) {
                    this.cjC = this.cjn.aPO().getName();
                    this.forumId = this.cjn.aPO().getId();
                }
                if (this.cjn.bsn()) {
                    this.cjV.a(this.cjK.getListView(), this.cjn, this.cjT.ajl());
                }
                if (z) {
                    r(true, z);
                } else {
                    r(this.cjS, z);
                }
                afB();
                if (this.ckc != null) {
                    this.ckc.a(this.cjU, this.cjn);
                }
                if (this.cjn.qH() != null) {
                    setHasMore(this.cjn.qH().qD());
                }
                ArrayList<com.baidu.adp.widget.ListView.f> a2 = this.ckg.a(z2, true, this.cjn.getThreadList(), null);
                if (a2 != null) {
                    this.cjn.aB(a2);
                }
                if (this.cjT.ajf() == 1) {
                    afH();
                    if (!z && this.cjT.getPn() == 1 && (brR = afN().brR()) != null) {
                        new com.baidu.tieba.frs.c.a().a(this, brR);
                    }
                }
                this.cjq = this.cjn.ajh();
                if (this.cjG != null) {
                    this.cjF = true;
                    this.cjG.to(this.cjq);
                    com.baidu.tieba.frs.f.a.a(this, this.cjn.aPO(), this.cjn.getThreadList(), this.cjF, getPn());
                }
                if (this.cke != null) {
                    this.cke.cj(this.cjT.ajp());
                    this.cke.aq(this.cjV.ahv());
                }
                eD(z);
                this.cjK.aga();
                this.cjK.t(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.g gVar) {
        try {
            if (!this.cjO && gVar != null && this.cjn != null) {
                this.cjn.e(gVar);
                s(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void eE(boolean z) {
        if (this.cjT != null) {
            e(z, this.cjT.ajb());
        } else {
            e(z, "normal_page");
        }
    }

    private void e(boolean z, String str) {
        eF("frs_page".equals(str));
        if (this.ckc != null) {
            this.ckc.a(z, this.cjV, this.cjU, this.cjK, this.cjn);
        }
    }

    public void eF(boolean z) {
        if (this.ckh != null) {
            this.ckh.a(this.cjK, z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(d.j.frs_activity, viewGroup, false);
            this.cjw = new com.baidu.tieba.frs.entelechy.b();
            this.ckc = this.cjw.agN();
            this.cjU = new com.baidu.tieba.frs.g.f(this, this.cjw);
            this.cjV = this.cjw.z(this);
            Intent intent = this.ckm != null ? this.ckm : getActivity().getIntent();
            if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                this.cjy = true;
            }
            this.cjK = new i(this, this.ckI, this.cjw, this.cjy);
            this.cjK.setHeaderViewHeight(this.ckn);
        } else if (this.mRootView.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            this.cjK.agt();
        }
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Intent intent = this.ckm != null ? this.ckm : getActivity().getIntent();
        this.bZn = System.currentTimeMillis();
        if (intent != null) {
            this.cjH = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.bZn = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            M(intent);
        }
        this.Xe = System.currentTimeMillis();
        this.aKb = this.Xe - this.bZn;
        this.cjG = new com.baidu.tieba.tbadkCore.data.e("frs", com.baidu.tieba.tbadkCore.data.e.gjf);
        this.cjT = new FrsModelController(this, this.ckC);
        this.cjT.a(this.cku);
        this.cjT.init();
        if (intent != null) {
            this.cjT.f(intent.getExtras());
        } else if (bundle != null) {
            this.cjT.f(bundle);
        } else {
            this.cjT.f(null);
        }
        this.cjV.al(this.cjK.Wn());
        if (intent != null) {
            this.cjU.j(intent.getExtras());
        } else if (bundle != null) {
            this.cjU.j(bundle);
        } else {
            this.cjU.j((Bundle) null);
        }
        this.cjJ = getVoiceManager();
        this.ckj = new h(getPageContext(), this);
        initUI();
        initData(bundle);
        if (this.ajv != null && this.ajv.equals("from_tieba_kuang")) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c12264").r("obj_type", 1).aa(ImageViewerConfig.FORUM_NAME, this.cjT.getForumName()));
            KuangFloatingViewController.getInstance().setNeedShowFloatingView(true);
            KuangFloatingViewController.getInstance().showFloatingView();
        }
        if (!afQ()) {
            this.cka = new am(getActivity(), this.cjK, this.cjU);
            this.cka.eP(true);
        }
        this.cjJ = getVoiceManager();
        if (this.cjJ != null) {
            this.cjJ.onCreate(getPageContext());
        }
        new com.baidu.tieba.frs.mc.h();
        this.ckg = new com.baidu.tieba.frs.mc.d(this, this.ckE);
        this.cjY = new com.baidu.tieba.frs.smartsort.b(this);
        this.ckh = new com.baidu.tieba.frs.g.h(this);
        this.createTime = System.currentTimeMillis() - this.Xe;
        this.cke = new com.baidu.tieba.frs.g.a(getPageContext(), this.cjT.ajm());
        this.cjZ = new com.baidu.tieba.frs.mc.c(this);
        this.ckf = new com.baidu.tieba.frs.mc.e(this);
        this.cjW = new com.baidu.tieba.frs.mc.g(this);
        this.cjX = new com.baidu.tieba.frs.mc.b(this);
        this.cki = new com.baidu.tieba.frs.mc.a(this);
        this.ckk = new com.baidu.tieba.frs.g.c(this);
        this.ckl = new com.baidu.tieba.frs.mc.f(this, getUniqueId());
        registerListener(this.mMemListener);
        registerListener(this.ckA);
        registerListener(this.ckG);
        registerListener(this.ckz);
        registerListener(this.ckD);
        registerListener(this.ckw);
        registerListener(this.ckx);
        registerListener(this.cky);
        registerListener(this.cks);
        registerListener(this.ckt);
        registerListener(this.ckO);
        registerListener(this.ckB);
        this.cjK.eK(false);
        if (!afQ()) {
            showLoadingView(this.cjK.Wn(), true);
            this.cjT.r(3, true);
        }
        super.onActivityCreated(bundle);
    }

    @Override // com.baidu.tieba.frs.ah
    public void afC() {
        if (isAdded() && this.bjB && !isLoadingViewAttached()) {
            showLoadingView(this.cjK.Wn(), true);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void afD() {
        if (isAdded() && this.bjB && isLoadingViewAttached()) {
            hideLoadingView(this.cjK.Wn());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (afQ()) {
            showLoadingView(this.cjK.Wn(), true);
            this.cjK.iG(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.cjT.r(3, true);
            getListView().setSelection(0);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void setHeaderViewHeight(int i) {
        this.ckn = i;
        if (this.cjK != null) {
            this.cjK.setHeaderViewHeight(this.ckn);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void setRecommendFrsNavigationAnimDispatcher(r rVar) {
        if (rVar != null) {
            this.aMS = rVar.Hp();
            this.cko = rVar.Hq();
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void showFloatingView() {
        if (this.aMS != null) {
            this.aMS.cg(true);
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
            this.cjC = data.getQueryParameter("name");
            this.ajv = data.getQueryParameter("from");
            if (!StringUtils.isNull(this.cjC)) {
                intent.putExtra("name", this.cjC);
            }
            if (!StringUtils.isNull(this.ajv)) {
                intent.putExtra("from", this.ajv);
            }
            TiebaStatic.log("c10105");
        }
        if (StringUtils.isNull(this.cjC)) {
            this.cjC = com.baidu.tieba.frs.f.i.O(intent);
            if (!StringUtils.isNull(this.cjC)) {
                intent.putExtra("name", this.cjC);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.cjJ = getVoiceManager();
        if (this.cjJ != null) {
            this.cjJ.onStart(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        Intent intent;
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.ckL);
        if (bundle != null) {
            this.cjC = bundle.getString("name");
            this.ajv = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
            this.cjC = intent.getStringExtra("name");
            this.ajv = intent.getStringExtra("from");
            this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
        }
        if (TextUtils.isEmpty(this.ajv) || FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.ajv)) {
        }
        if (this.mIsLogin) {
            registerListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL, this.ckL);
        }
        this.cjU.j(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.ckO);
        if (this.cjJ != null) {
            this.cjJ.onDestory(getPageContext());
        }
        this.cjJ = null;
        com.baidu.tieba.card.u.WX().dF(false);
        if (this.cjn != null && this.cjn.aPO() != null) {
            ac.agC().bi(com.baidu.adp.lib.g.b.d(this.cjn.aPO().getId(), 0L));
        }
        if (this.cjK != null) {
            com.baidu.tieba.frs.f.h.a(this.cjK, this.cjn, getForumId(), false, null);
            this.cjK.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.cjQ != null) {
                this.cjQ.onDestroy();
            }
            this.cjK.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.cjT.onActivityDestroy();
        this.cjU.onActivityDestroy();
        if (this.cjR != null) {
            this.cjR.cancel(true);
            this.cjR = null;
        }
        if (this.cjT != null) {
            this.cjT.Ox();
        }
        if (this.cka != null) {
            this.cka.Ho();
        }
        if (this.ckd != null) {
            this.ckd.destory();
        }
        if (this.cke != null) {
            this.cke.destory();
        }
        if (this.cjY != null) {
            this.cjY.onDestroy();
        }
        if (this.ckp != null) {
            this.ckp.onDestory();
        }
        com.baidu.tieba.recapp.d.a.biO().biQ();
        com.baidu.tieba.frs.f.j.ajM();
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.cjC);
        bundle.putString("from", this.ajv);
        this.cjT.onSaveInstanceState(bundle);
        if (this.cjJ != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            this.cjJ.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.cki != null) {
            this.cki.onActivityResult(i, i2, intent);
        }
    }

    public void a(UpdateAttentionMessage updateAttentionMessage) {
        Message<?> message;
        if (updateAttentionMessage != null && updateAttentionMessage.isAttention() && updateAttentionMessage.isGod() && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(getUniqueId())) {
            if (this.ckd == null) {
                this.ckd = new com.baidu.tbadk.i.a(getPageContext());
            }
            this.ckd.an(updateAttentionMessage.getData().toUid, getForumId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.cjK != null) {
            this.cjK.age();
            this.cjK.onResume();
        }
        this.cjV.a(this.ckv);
        this.cjW.fb(true);
        this.cjS = true;
        if (isNeedRefreshOnResume) {
            isNeedRefreshOnResume = false;
            this.cjK.startPullRefresh();
        } else if (cjz) {
            cjz = false;
            this.cjK.startPullRefresh();
        } else {
            if (this.cjJ != null) {
                this.cjJ.onResume(getPageContext());
            }
            this.cjK.eL(false);
            registerListener(this.ckH);
            if (this.ckq) {
                cm(6);
                this.ckq = false;
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
        this.ckm = intent;
    }

    public boolean afE() {
        if (getActivity() == null) {
            return false;
        }
        Intent intent = this.ckm != null ? this.ckm : getActivity().getIntent();
        if (intent != null) {
            return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
        }
        return false;
    }

    public void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.cjC = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.ajv = intent.getStringExtra("from");
            }
            this.cjE = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.cjE) {
                afF();
            }
            if (this.ajv != null && this.ajv.equals("from_tieba_kuang")) {
                KuangFloatingViewController.getInstance().setNeedShowFloatingView(true);
                KuangFloatingViewController.getInstance().showFloatingView();
            }
        }
    }

    private void afF() {
        this.cjK.startPullRefresh();
    }

    public void closeActivity() {
        com.baidu.tieba.frs.f.i.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.ajv);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.cjK.setTitle(this.cjC);
        } else {
            this.cjK.setTitle("");
            this.mFlag = 1;
        }
        this.cjU.d(this.cjK.getListView());
        this.cjK.setOnAdapterItemClickListener(this.ckM);
        this.cjK.setOnScrollListener(this.ckJ);
        this.cjK.c(this.bFE);
        this.cjK.ago().a(this.ckK);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cjK.onChangeSkinType(i);
        this.cjU.jE(i);
        this.cjV.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.d.c
    public void lz() {
    }

    @Override // com.baidu.adp.widget.d.c
    public void lA() {
    }

    public void iE(int i) {
        if (!this.mIsLogin) {
            if (this.cjn != null && this.cjn.qr() != null) {
                this.cjn.qr().setIfpost(1);
            }
            if (i == 0) {
                aw.aN(getActivity());
            }
        } else if (this.cjn != null) {
            if (i == 0) {
                if (!this.cjA) {
                    com.baidu.tieba.frs.f.j.b(this, 0);
                    return;
                }
                TiebaStatic.log("c10152");
                com.baidu.tieba.frs.f.j.b(this, 4);
                return;
            }
            this.cjK.agg();
        }
    }

    public void refresh() {
        cm(3);
    }

    public void cm(int i) {
        this.cjO = false;
        afK();
        if (this.cjK.afW() != null) {
            this.cjK.afW().aqF();
        }
        this.cjT.r(i, true);
    }

    private void afG() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.g.h.gb().f(new Runnable() { // from class: com.baidu.tieba.frs.f.10
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.sh(f.this.cjC);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afH() {
        afK();
        try {
            if (this.cjn != null) {
                this.cjK.Nr();
                this.cjK.eH(this.cjT.ajg());
                if (com.baidu.tieba.frs.g.f.i(this.cjn) && !com.baidu.tieba.frs.g.f.h(this.cjn)) {
                    this.cjK.agr();
                }
                if (this.cjn.aPO() != null) {
                    this.cjC = this.cjn.aPO().getName();
                    this.forumId = this.cjn.aPO().getId();
                }
                if (this.cjn.qH() != null) {
                    setHasMore(this.cjn.qH().qD());
                }
                this.cjK.setTitle(this.cjC);
                this.cjK.setForumName(this.cjC);
                TbadkCoreApplication.getInst().setDefaultBubble(this.cjn.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.cjn.getUserData().getBimg_end_time());
                afG();
                afI();
                ArrayList<com.baidu.adp.widget.ListView.f> threadList = this.cjn.getThreadList();
                if (threadList != null) {
                    this.cjK.a(threadList, this.cjn);
                    com.baidu.tieba.frs.f.c.j(this.cjK);
                    this.cjU.jF(getPageNum());
                    this.cjU.f(this.cjn);
                    this.cjV.a(this.cjK.getListView(), this.cjn, this.cjT.ajl());
                    this.cjK.agh();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void afI() {
        if (this.cjn != null) {
            if (this.cjn.aQc() == 1) {
                this.cjK.ago().setFromCDN(true);
            } else {
                this.cjK.ago().setFromCDN(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.cjW.fb(false);
        this.cjS = false;
        this.cjK.onPause();
        if (this.cjJ != null) {
            this.cjJ.onPause(getPageContext());
        }
        this.cjK.eL(true);
        if (this.cke != null) {
            this.cke.ajP();
        }
        MessageManager.getInstance().unRegisterListener(this.ckH);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.u.WX().dF(false);
        if (this.cjn != null && this.cjn.aPO() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            com.baidu.tbadk.distribute.a.CK().a(getPageContext().getPageActivity(), "frs", this.cjn.aPO().getId(), 0L);
        }
        if (this.cjJ != null) {
            this.cjJ.onStop(getPageContext());
        }
        com.baidu.tieba.frs.f.i.c(getListView());
        this.cjU.onActivityStop();
        s.Hs();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || this.cjK == null) {
            return false;
        }
        return this.cjK.agd();
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
    public void afJ() {
        afq().afJ();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.cjJ == null) {
            this.cjJ = VoiceManager.instance();
        }
        return this.cjJ;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public BdListView getListView() {
        if (this.cjK == null) {
            return null;
        }
        return this.cjK.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void afK() {
        if (this.cjJ != null) {
            this.cjJ.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> xn() {
        if (this.apB == null) {
            this.apB = UserIconBox.j(getPageContext().getPageActivity(), 8);
        }
        return this.apB;
    }

    public void afL() {
        if (getFragmentActivity() != null && getFragmentActivity().getCurrentFocus() != null) {
            com.baidu.adp.lib.util.k.b(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.g onGetPreLoadListView() {
        return getListView();
    }

    @Override // com.baidu.tieba.frs.aj
    public NavigationBar afM() {
        if (this.cjK == null) {
            return null;
        }
        return this.cjK.afM();
    }

    /* loaded from: classes.dex */
    private final class a implements com.baidu.adp.widget.ListView.h {
        private a() {
        }

        @Override // com.baidu.adp.widget.ListView.h
        public void a(View view, com.baidu.adp.widget.ListView.f fVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            boolean z;
            if (bdUniqueId != null) {
                if (bdUniqueId == p.cmf) {
                    if (f.this.cjK != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11752").aa("fid", f.this.forumId).aa("obj_locate", "1"));
                        f.this.cjK.startPullRefresh();
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
                                if (readThreadHistory != null && !readThreadHistory.sn(blVar.getId())) {
                                    readThreadHistory.sm(blVar.getId());
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
                                    if (f.this.cjT.ajf() == 5) {
                                        str = "c10387";
                                    }
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.aj(str).aa("fid", f.this.forumId));
                                    com.baidu.tieba.frs.f.i.c(f.this, blVar);
                                    if (f.this.cjn != null && f.this.cjn.aPO() != null) {
                                        com.baidu.tieba.frs.e.a aVar = new com.baidu.tieba.frs.e.a();
                                        aVar.cxE = f.this.cjn.ghi == 1;
                                        aVar.cxG = f.this.cjn.aPO().getId();
                                        aVar.cxF = f.this.afq().ajl();
                                        com.baidu.tieba.frs.e.b.ajF().a(aVar, blVar, 1);
                                    }
                                } else {
                                    if (tid.startsWith("pb:")) {
                                        blVar.setId(tid.substring(3));
                                    }
                                    if (bdUniqueId.getId() == bl.aao.getId()) {
                                        com.baidu.tieba.frs.f.h.a(blVar.rn());
                                        com.baidu.tieba.frs.f.i.b(f.this, blVar);
                                        return;
                                    }
                                    com.baidu.tieba.frs.f.i.a(f.this, blVar, i, z);
                                    com.baidu.tieba.frs.f.h.a(f.this, f.this.cjn, blVar);
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
            hideNetRefreshView(this.cjK.Wn());
            showLoadingView(this.cjK.Wn(), true);
            this.cjK.eK(false);
            this.cjT.r(3, true);
        }
    }

    public com.baidu.tieba.tbadkCore.i afN() {
        return this.cjn;
    }

    public boolean afO() {
        return this.cjK.afO();
    }

    public void P(Object obj) {
        if (this.cjZ != null && this.cjZ.cwB != null) {
            this.cjZ.cwB.g(obj);
        }
    }

    public void Q(Object obj) {
        if (this.cjZ != null && this.cjZ.cwC != null) {
            this.cjZ.cwC.g(obj);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.k.hI()) {
            this.cjK.Yc();
        } else if (this.cjT.ajf() == 1) {
            MZ();
            MS();
        } else if (this.cjT.hasMore()) {
            MS();
        }
    }

    public void kl(String str) {
        MZ();
        showToast(str);
    }

    public void G(ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        MZ();
        if (!com.baidu.tbadk.core.util.u.v(arrayList)) {
            if (!this.cjT.ajp() && TbadkCoreApplication.getInst().isRecAppExist() && this.cjT.ajf() == 1) {
                this.cjn.a(this, arrayList);
            }
            ArrayList<com.baidu.adp.widget.ListView.f> a2 = this.ckg.a(false, false, arrayList, this.cjG);
            if (a2 != null) {
                this.cjn.aB(a2);
                this.cjK.a(a2, this.cjn);
            }
            if (this.cjT != null) {
                com.baidu.tieba.frs.e.b.a(this.cjn, this.cjT.ajl(), 2);
            }
        }
    }

    private void MZ() {
        if (afw() == 1 || this.ckg.aK(this.cjn.brp())) {
            this.cjK.Wt();
        } else if (com.baidu.tbadk.core.util.u.v(this.cjn.getThreadList())) {
            this.cjK.Yc();
        } else {
            this.cjK.Wv();
        }
    }

    @Override // com.baidu.tieba.frs.mc.k
    public void MS() {
        if (this.ckg != null) {
            this.ckg.a(this.cjC, this.forumId, this.cjn);
        }
    }

    public void afP() {
        if (!com.baidu.tbadk.core.util.aa.d(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.ah.c(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return afQ() ? "a034" : "a006";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (!afQ()) {
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

    @Override // com.baidu.b.a.a.InterfaceC0023a
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

    public void eG(boolean z) {
        if (this.cka != null) {
            this.cka.eP(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.ckb.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a fI(int i) {
        return this.ckb.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        this.ckj.b(bVar);
    }

    public boolean afQ() {
        return this.cjy;
    }

    @Override // com.baidu.tieba.frs.ah
    public void afR() {
        if (this.cjK != null) {
            showFloatingView();
            this.cjK.getListView().setSelection(0);
            this.cjK.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public ForumWriteData afS() {
        if (this.cjn == null || this.cjn.aPO() == null) {
            return null;
        }
        ForumData aPO = this.cjn.aPO();
        ForumWriteData forumWriteData = new ForumWriteData(aPO.getId(), aPO.getName(), aPO.getPrefixData(), this.cjn.qr());
        forumWriteData.setForumLevel(aPO.getUser_level());
        forumWriteData.setAvatar(this.cjn.aPO().getImage_url());
        return forumWriteData;
    }

    @Override // com.baidu.tieba.frs.ah
    public void xd() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void cH(boolean z) {
        if (this.cjK != null) {
            this.cjK.cH(z);
        }
    }
}
