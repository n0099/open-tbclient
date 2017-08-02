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
import com.baidu.tieba.frs.g.f;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.tbadkCore.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.AlaLiveNotify;
/* loaded from: classes.dex */
public class f extends BaseFragment implements a.InterfaceC0000a, BdListView.e, d.c, UserIconBox.b, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, ah, aj, al, com.baidu.tieba.frs.mc.k, com.baidu.tieba.recapp.o {
    private q aLC;
    private com.baidu.adp.lib.e.b<TbImageView> aog;
    private com.baidu.tieba.frs.entelechy.b chC;
    private boolean chG;
    public bl chH;
    private com.baidu.tieba.tbadkCore.data.e chM;
    private VoiceManager chP;
    private f.a chX;
    private FrsModelController chZ;
    private boolean ciM;
    private com.baidu.tieba.frs.h.f cia;
    private com.baidu.tieba.frs.entelechy.b.d cib;
    private com.baidu.tieba.frs.mc.g cic;
    private com.baidu.tieba.frs.mc.b cie;
    private com.baidu.tieba.frs.smartsort.b cif;
    private com.baidu.tieba.frs.mc.c cig;
    private am cih;
    private com.baidu.tieba.frs.entelechy.b.b cij;
    private com.baidu.tbadk.i.a cik;
    private com.baidu.tieba.frs.h.a cil;
    private com.baidu.tieba.frs.mc.e cim;
    private com.baidu.tieba.frs.mc.d cin;
    private com.baidu.tieba.frs.h.h cio;
    private com.baidu.tieba.frs.mc.a cip;
    private h ciq;
    public com.baidu.tieba.frs.h.c cir;
    private com.baidu.tieba.frs.mc.f cis;
    private Intent cit;
    private int ciu;
    private View.OnTouchListener civ;
    private com.baidu.tieba.frs.h.e ciw;
    private boolean cix;
    public View mRootView;
    private static boolean isNeedRefreshOnResume = false;
    public static boolean chF = false;
    public static volatile long chR = 0;
    public static volatile long chS = 0;
    public static volatile int chT = 0;
    public boolean chD = false;
    private boolean chE = false;
    public String chI = null;
    public String aia = null;
    public int mFlag = 0;
    private boolean chJ = false;
    private boolean chK = false;
    private String mThreadId = null;
    private String forumId = null;
    private int chx = 0;
    private boolean chL = false;
    private boolean chN = false;
    private boolean chO = false;
    private i chQ = null;
    public final bl bfu = null;
    private com.baidu.tieba.tbadkCore.i chu = new com.baidu.tieba.tbadkCore.i();
    public long bXv = -1;
    public long aIT = 0;
    public long aIL = 0;
    public long createTime = 0;
    public long VG = -1;
    private boolean chU = false;
    private boolean chV = false;
    public com.baidu.tbadk.l.d chW = null;
    private boolean chY = true;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> cii = new SparseArray<>();
    private boolean biq = true;
    private boolean ciy = false;
    private final CustomMessageListener ciz = new CustomMessageListener(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED) { // from class: com.baidu.tieba.frs.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof bl) {
                    com.baidu.tieba.frs.g.h.a(f.this.chQ, f.this.chu, f.this.getForumId(), true, (bl) data);
                }
            }
        }
    };
    private CustomMessageListener ciA = new CustomMessageListener(CmdConfigCustom.CMD_CLOSE_GAME_RANK_CARD) { // from class: com.baidu.tieba.frs.f.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (f.this.chu != null) {
                f.this.chu.brs();
                if (f.this.chQ != null) {
                    f.this.chQ.XB();
                }
            }
        }
    };
    private final ak ciB = new ak() { // from class: com.baidu.tieba.frs.f.19
        @Override // com.baidu.tieba.frs.ak
        public void a(int i, int i2, aq aqVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
            f.this.aeX();
            if (f.this.cij != null) {
                f.this.cia.fa(f.this.cij.iP(i));
            }
            d.a aVar = new d.a();
            if (aqVar != null) {
                aVar.isSuccess = aqVar.errCode == 0;
                aVar.errorCode = aqVar.errCode;
                aVar.errorMsg = aqVar.errMsg;
                if (aVar.isSuccess) {
                    if (com.baidu.tbadk.core.util.u.v(arrayList)) {
                        f.this.chQ.XC();
                    } else if (aqVar.hasMore) {
                        f.this.chQ.VS();
                    } else if (aqVar.ckY) {
                        f.this.chQ.VU();
                    } else {
                        f.this.chQ.XC();
                    }
                }
            } else {
                aqVar = new aq();
                aqVar.pn = 1;
                aqVar.hasMore = false;
                aqVar.ckY = false;
            }
            if (i == 1) {
                f.this.chY = true;
                f.this.ciJ.a(f.this.chZ.getType(), false, aVar);
            } else {
                f.this.a(aVar, true);
                if (f.this.chZ.ahK() != null) {
                    f.this.chu = f.this.chZ.ahK();
                }
                f.this.afg();
            }
            if (f.this.ciU != null) {
                f.this.ciU.a(i, i2, aqVar, arrayList);
            }
        }
    };
    private ai ciC = new ai() { // from class: com.baidu.tieba.frs.f.20
        @Override // com.baidu.tieba.frs.ai
        public void a(ak akVar) {
        }

        @Override // com.baidu.tieba.frs.ai
        public void a(int i, int i2, an anVar) {
            if (i != 1) {
                com.baidu.tieba.card.u.Ww().dE(false);
            }
            if (i == 1) {
                f.this.chQ.eH(true);
                f.this.chQ.eG(false);
            } else {
                f.this.chQ.eI(true);
                f.this.chQ.eG(true);
            }
            f.this.afj();
            f.this.chZ.a(i, i2, anVar);
        }

        @Override // com.baidu.tieba.frs.ai
        public void init() {
        }

        @Override // com.baidu.tieba.frs.ai
        public void Os() {
        }
    };
    private CustomMessageListener ciD = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIVE_COUNT) { // from class: com.baidu.tieba.frs.f.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                ((com.baidu.tieba.frs.entelechy.c.a) f.this.cib).iR(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    };
    private CustomMessageListener ciE = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_LIVE_START) { // from class: com.baidu.tieba.frs.f.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && ((Integer) customResponsedMessage.getData()).intValue() == 51 && f.this.chu != null) {
                com.baidu.tieba.frs.g.j.a(f.this.chu, f.this.getPageContext());
            }
        }
    };
    private final CustomMessageListener ciF = new CustomMessageListener(CmdConfigCustom.CMD_FRS_SELECT_ALA_LIVE_TAB) { // from class: com.baidu.tieba.frs.f.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (f.this.cib instanceof com.baidu.tieba.frs.entelechy.c.a) && ((com.baidu.tieba.frs.entelechy.c.a) f.this.cib).agZ() != null) {
                ((com.baidu.tieba.frs.entelechy.c.a) f.this.cib).agZ().jn(49);
            }
        }
    };
    private final CustomMessageListener ciG = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.frs.f.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && f.this.chu != null && f.this.chu.aOW() != null) {
                SignData signData = (SignData) customResponsedMessage.getData();
                int user_level = f.this.chu.aOW().getUser_level();
                if (signData.forumId != null && signData.forumId.equals(f.this.chu.aOW().getId())) {
                    f.this.chu.d(signData);
                    f.this.cia.g(f.this.chu);
                    if (f.this.cia.ajp()) {
                        i = f.this.chu.aOW().getUser_level();
                        if (user_level >= i) {
                            i++;
                        }
                    } else {
                        i = user_level;
                    }
                    TbadkCoreApplication.getInst().addSignedForum(f.this.chu.aOW().getName(), signData.sign_bonus_point, i);
                }
            }
        }
    };
    private final CustomMessageListener ciH = new CustomMessageListener(CmdConfigCustom.CMD_FRS_EXPERIENCE_TIP) { // from class: com.baidu.tieba.frs.f.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.o) && f.this.chu != null) {
                f.this.chu.c((com.baidu.tieba.tbadkCore.o) customResponsedMessage.getData());
                f.this.cia.f(f.this.chu);
                f.this.cib.a(f.this.chQ.getListView(), f.this.chu, f.this.chZ.ais());
            }
        }
    };
    private CustomMessageListener ciI = new CustomMessageListener(CmdConfigCustom.CMD_STORY_READ_CACHE) { // from class: com.baidu.tieba.frs.f.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.story.process.b)) {
                com.baidu.tieba.story.process.b bVar = (com.baidu.tieba.story.process.b) customResponsedMessage.getData();
                if (f.this.forumId != null && f.this.forumId.equals(String.valueOf(bVar.forumId)) && bVar.state == 3 && f.this.afm() != null && !com.baidu.tbadk.core.util.u.v(f.this.afm().bqq()) && f.this.chC.agm() != null && f.this.chC.agm().agC() != null) {
                    List<com.baidu.adp.widget.ListView.f> bqq = f.this.afm().bqq();
                    int size = bqq.size();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= size) {
                            i = -1;
                            break;
                        } else if ((bqq.get(i2) instanceof com.baidu.tbadk.data.f) && TbadkCoreApplication.getCurrentAccount().equals(String.valueOf(((com.baidu.tbadk.data.f) bqq.get(i2)).user_id))) {
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
                    fVar.azk = String.valueOf(f.this.forumId);
                    fVar.azj = bVar;
                    if (i != -1) {
                        bqq.set(i, fVar);
                    } else {
                        bqq.add(1, fVar);
                    }
                    f.this.chC.agm().agC().b(bqq, f.this.forumId, f.this.getThreadId());
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.k ciJ = new com.baidu.tieba.tbadkCore.k() { // from class: com.baidu.tieba.frs.f.3
        private long startTime = 0;

        @Override // com.baidu.tieba.tbadkCore.k
        public void iD(int i) {
            this.startTime = System.nanoTime();
            if (f.this.chQ != null) {
                switch (i) {
                    case 1:
                    case 2:
                        f.this.chQ.afC();
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
            if (f.this.biq) {
                f.this.biq = false;
                com.baidu.tieba.frs.g.h.a(f.this.chQ, f.this.chu, f.this.getForumId(), false, null);
            }
            f.this.aeX();
            f.this.chU = true;
            if (aVar != null && aVar.isSuccess) {
                f.this.chQ.afM().eP(com.baidu.tbadk.core.util.am.vG().vI());
                f.chR = 0L;
                f.chS = 0L;
                f.chT = 0;
            } else {
                f.chT = 1;
            }
            if (!f.this.chZ.aiw() && (i == 3 || i == 6)) {
                f.this.cin.resetData();
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (f.this.chZ.ahK() != null) {
                f.this.chu = f.this.chZ.ahK();
            }
            if (i == 7) {
                f.this.iB(f.this.chu.bqP());
                return;
            }
            if (f.this.chu.qx() != null) {
                f.this.setHasMore(f.this.chu.qx().qt());
            }
            f.this.aeY();
            if (i == 4) {
                if (!f.this.chZ.aiw() && TbadkCoreApplication.getInst().isRecAppExist() && f.this.chZ.aim() == 1) {
                    f.this.chu.a(f.this);
                }
                ArrayList<com.baidu.adp.widget.ListView.f> a2 = f.this.cin.a(false, false, f.this.chu.getThreadList(), f.this.chM);
                if (a2 != null) {
                    f.this.chu.aB(a2);
                    f.this.chu.brl();
                    f.this.chQ.a(a2, f.this.chu);
                }
                if (f.this.chZ != null) {
                    com.baidu.tieba.frs.f.b.a(f.this.chu, f.this.chZ.ais(), 2);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    f.this.chQ.afC();
                    break;
                case 2:
                    f.this.chQ.afC();
                    break;
                case 3:
                case 6:
                    if (f.this.chu != null) {
                        f.this.chu.brj();
                    }
                    if (f.this.cir != null) {
                        f.this.cir.refresh();
                        break;
                    }
                    break;
            }
            f.this.aeZ();
            if (aVar == null || aVar.errorCode == 0) {
                if (f.this.chu != null) {
                    f.this.chQ.iF(i);
                    f.this.r(false, i == 5);
                    f.chR = (System.nanoTime() - this.startTime) / 1000000;
                    if (aVar != null) {
                        f.chS = aVar.gdE;
                    }
                } else {
                    return;
                }
            } else if (f.this.chu == null || com.baidu.tbadk.core.util.u.v(f.this.chu.getThreadList())) {
                f.this.a(aVar, false);
            } else if (aVar.gdD) {
                f.this.showToast(f.this.getPageContext().getResources().getString(d.l.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
            }
            if (f.this.chu.bqu() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11384"));
            }
            if (f.this.bXv > -1 && !f.this.ciy) {
                com.baidu.tieba.frs.g.h.a(f.this.chZ, f.this.bXv);
                f.this.bXv = -1L;
                f.this.ciy = true;
            }
            if (f.this.chN && (f.this.cib instanceof com.baidu.tieba.frs.entelechy.c.a) && ((com.baidu.tieba.frs.entelechy.c.a) f.this.cib).agZ() != null) {
                ((com.baidu.tieba.frs.entelechy.c.a) f.this.cib).agZ().jn(49);
                f.this.chN = false;
            }
            f.this.aIT = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.k
        public void b(com.baidu.tieba.tbadkCore.g gVar) {
            if (gVar != null) {
                if ("normal_page".equals(f.this.chZ.aii()) || "frs_page".equals(f.this.chZ.aii()) || "book_page".equals(f.this.chZ.aii())) {
                    f.this.a(gVar);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE, gVar));
                }
            }
        }
    };
    private final CustomMessageListener ciK = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.frs.f.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                f.this.chu.a((com.baidu.tbadk.data.j) customResponsedMessage.getData());
                f.this.chQ.afM().notifyDataSetChanged();
            }
        }
    };
    private final CustomMessageListener mMemListener = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_MEM) { // from class: com.baidu.tieba.frs.f.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && f.this.chu != null && (userData = f.this.chu.getUserData()) != null) {
                userData.setIsMem(num.intValue());
                if (num.intValue() != 0) {
                    f.this.cia.e(num);
                }
            }
        }
    };
    private final com.baidu.tieba.frs.mc.j ciL = new com.baidu.tieba.frs.mc.j() { // from class: com.baidu.tieba.frs.f.6
        @Override // com.baidu.tieba.frs.mc.j
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
            if (f.this.cif != null && f.this.chZ != null && f.this.chZ.aiw() && z && !z2) {
                f.this.cif.jh(i2);
            }
        }
    };
    public final View.OnTouchListener aLD = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.f.7
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (f.this.civ != null) {
                f.this.civ.onTouch(view, motionEvent);
            }
            if (f.this.cih != null && f.this.cih.age() != null) {
                f.this.cih.age().onTouchEvent(motionEvent);
            }
            f.this.ciM = true;
            if (f.this.cia != null) {
                f.this.cia.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private final CustomMessageListener ciN = new CustomMessageListener(CmdConfigCustom.CMD_GOTOLIVE_HOST_UPGRADE) { // from class: com.baidu.tieba.frs.f.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "photolive_hostLevel", -1) != -1 && f.this.chu.aOW() != null) {
                f.this.chu.aOW().setCanAddPhotoLivePost(true);
            }
        }
    };
    private final CustomMessageListener ciO = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.frs.f.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11455").aa("obj_locate", "frs"));
                    com.baidu.tbadk.core.util.at.vV().c(f.this.getPageContext(), new String[]{str});
                }
            }
        }
    };
    public final View.OnClickListener ciP = new View.OnClickListener() { // from class: com.baidu.tieba.frs.f.11
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (f.this.chQ == null || view != f.this.chQ.afA()) {
                if (f.this.chu != null && f.this.chu.aOW() != null) {
                    if (f.this.chQ == null || view != f.this.chQ.afG()) {
                        if (f.this.chQ != null && view == f.this.chQ.afH()) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10378").r("obj_type", 5));
                            if (!StringUtils.isNull(f.this.chu.aOW().getName())) {
                                f.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PostSearchActivityConfig(f.this.getPageContext().getPageActivity(), f.this.chu.aOW().getName())));
                                return;
                            }
                            return;
                        }
                    } else if (!StringUtils.isNull(f.this.chu.aOW().getId())) {
                        if (f.this.chu.aOW() != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c12046").aa("fid", f.this.chu.aOW().getId()).r("obj_locate", f.this.afo() ? 1 : 2));
                        }
                        f.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(f.this.getPageContext().getPageActivity(), f.this.chu.aOW().getId(), ForumDetailActivityConfig.FromType.FRS)));
                        return;
                    } else {
                        return;
                    }
                }
                if (view.getId() == d.h.game_activity_egg_layout && com.baidu.adp.lib.util.k.hy()) {
                    TiebaStatic.log("c10853");
                    if (f.this.chQ.afJ()) {
                        f.this.chQ.afK();
                        return;
                    }
                    String activityUrl = f.this.chu.aOW().getYuleData().ta().getActivityUrl();
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
    private final AbsListView.OnScrollListener ciQ = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.f.13
        private int ciX = 0;
        private int bbP = 0;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (f.this.aLC != null && f.this.isPrimary()) {
                f.this.aLC.a(absListView, this.ciX, i, i2, i3);
            }
            if (f.this.cib != null) {
                f.this.cib.a(absListView, i, i2, i3, f.this.cia.aju());
            }
            if (f.this.cil != null) {
                f.this.cil.aiW();
            }
            if (f.this.cif != null) {
                f.this.cif.aiH();
            }
            if (f.this.cih != null) {
                f.this.cih.a(absListView, i, i2, i3, f.this.cia.aju(), false);
            }
            if (f.this.ciw != null) {
                f.this.ciw.onScroll(absListView, i, i2, i3);
            }
            if (f.this.chu != null && f.this.chQ != null && f.this.chQ.afM() != null) {
                this.ciX = i;
                this.bbP = (i + i2) - 1;
                f.this.chQ.ao(this.ciX, this.bbP);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (f.this.cia != null) {
                f.this.cia.setScrollState(i);
            }
            if (f.this.aLC != null && f.this.isPrimary()) {
                f.this.aLC.onScrollStateChanged(absListView, i);
            }
            if (f.this.cih != null) {
                f.this.cih.a(absListView, i, 0);
            }
            if ((i == 2 || i == 1) && !f.this.chV) {
                f.this.chV = true;
                f.this.chQ.afO();
            }
            if (f.this.chW == null && !f.this.afo()) {
                f.this.chW = new com.baidu.tbadk.l.d();
                f.this.chW.fg(1000);
            }
            if (i == 0) {
                com.baidu.tieba.card.u.Ww().dE(true);
                f.this.chQ.an(this.ciX, this.bbP);
            }
            if (f.this.ciw != null) {
                f.this.ciw.onScrollStateChanged(absListView, i);
            }
            if (f.this.chW != null) {
                f.this.chW.FY();
            }
            if (i == 0) {
                com.baidu.tieba.frs.g.h.a(f.this.chQ, f.this.chu, f.this.getForumId(), false, null);
            }
        }
    };
    private final b ciR = new b() { // from class: com.baidu.tieba.frs.f.14
        @Override // com.baidu.tieba.frs.b
        public void a(int i, int i2, View view, View view2, bl blVar) {
            if (i != f.this.chQ.afM().agI()) {
                if (i != f.this.chQ.afM().agJ()) {
                    if (i != f.this.chQ.afM().agL()) {
                        if (i != f.this.chQ.afM().afW()) {
                            if (i == f.this.chQ.afM().agK() && f.this.chu != null && f.this.chu.getUserData() != null && f.this.chu.getUserData().isBawu()) {
                                final String bqN = f.this.chu.bqN();
                                if (!com.baidu.tbadk.core.util.al.isEmpty(bqN) && f.this.chu.aOW() != null) {
                                    com.baidu.tieba.c.a.a(f.this.getPageContext(), f.this.chu.aOW().getId(), f.this.chu.aOW().getName(), new a.InterfaceC0076a() { // from class: com.baidu.tieba.frs.f.14.1
                                        @Override // com.baidu.tieba.c.a.InterfaceC0076a
                                        public void Vj() {
                                            com.baidu.tbadk.browser.a.T(f.this.getPageContext().getPageActivity(), bqN);
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10502").aa("fid", f.this.chu.aOW().getId()).aa(SapiAccountManager.SESSION_UID, f.this.chu.getUserData().getUserId()));
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        f.this.chH = blVar;
                        com.baidu.tieba.frs.g.i.a(f.this, f.this.chH);
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10179").aa("fid", f.this.getForumId()));
                        return;
                    }
                    com.baidu.tieba.frs.g.i.B(f.this);
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aj(i == f.this.chQ.afM().agL() ? "c10177" : "c10244").aa("fid", f.this.getForumId()));
                } else if (aw.aN(f.this.getPageContext().getPageActivity())) {
                    TiebaStatic.log("my_service_ck");
                    if (f.this.chu != null && f.this.chu.aOW() != null) {
                        ForumData aOW = f.this.chu.aOW();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(f.this.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(aOW.getId(), 0L), aOW.getName(), aOW.getImage_url(), 0)));
                    }
                }
            } else if (aw.aN(f.this.getActivity())) {
                TiebaStatic.log("forum_fortune_click");
                com.baidu.tieba.frs.g.i.a(f.this.getPageContext(), f.this.chu);
            }
        }
    };
    private final NoNetworkView.a bDL = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.f.15
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aM(boolean z) {
            if (f.this.chZ.aim() == 1 && z && !f.this.chQ.afn()) {
                if (f.this.chu == null || com.baidu.tbadk.core.util.u.v(f.this.chu.getThreadList())) {
                    f.this.hideNetRefreshView(f.this.chQ.VM());
                    f.this.showLoadingView(f.this.chQ.VM(), true);
                    f.this.chQ.eI(false);
                    f.this.refresh();
                    return;
                }
                f.this.chQ.afC();
            }
        }
    };
    private final CustomMessageListener ciS = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.f.16
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                com.baidu.tieba.frs.g.c.a(customResponsedMessage, f.this.chQ, f.this.chu);
            }
        }
    };
    private com.baidu.adp.widget.ListView.h ciT = new a();
    private ak ciU = new ak() { // from class: com.baidu.tieba.frs.f.17
        @Override // com.baidu.tieba.frs.ak
        public void a(int i, int i2, aq aqVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
            com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tieba.frs.f.17.1
                @Override // java.lang.Runnable
                public void run() {
                    if (f.this.chQ != null && f.this.chQ.Xr()) {
                        f.this.MN();
                    }
                }
            });
        }
    };
    private CustomMessageListener ciV = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.frs.f.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    f.this.cix = true;
                }
            }
        }
    };

    public com.baidu.tieba.frs.entelechy.b.b aeL() {
        return this.cij;
    }

    public com.baidu.adp.widget.ListView.h aeM() {
        return this.ciT;
    }

    public com.baidu.tieba.frs.mc.e aeN() {
        return this.cim;
    }

    public com.baidu.tieba.frs.smartsort.b aeO() {
        return this.cif;
    }

    @Override // com.baidu.tieba.frs.mc.k
    public FrsModelController aeP() {
        return this.chZ;
    }

    @Override // com.baidu.tieba.frs.mc.k
    public com.baidu.tieba.frs.mc.d aeQ() {
        return this.cin;
    }

    @Override // com.baidu.tieba.frs.mc.k
    public com.baidu.tieba.frs.h.f aeR() {
        return this.cia;
    }

    public com.baidu.tieba.frs.entelechy.b.d aeS() {
        return this.cib;
    }

    public am aeT() {
        return this.cih;
    }

    @Override // com.baidu.tieba.frs.mc.k
    public i aeU() {
        return this.chQ;
    }

    @Override // com.baidu.tieba.frs.al
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.al
    public String getForumName() {
        return this.chI;
    }

    public void setForumName(String str) {
        this.chI = str;
    }

    public void setFrom(String str) {
        this.aia = str;
    }

    public String getFrom() {
        return this.aia;
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
        if (this.cin == null) {
            return 1;
        }
        return this.cin.getPn();
    }

    public int getPn() {
        if (this.cin == null) {
            return 1;
        }
        return this.cin.getPn();
    }

    public void setPn(int i) {
        if (this.cin != null) {
            this.cin.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.cin != null) {
            this.cin.setHasMore(i);
        }
    }

    public int aeV() {
        if (this.cin == null) {
            return -1;
        }
        return this.cin.aeV();
    }

    public boolean aeW() {
        return this.chO;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d.a aVar, boolean z) {
        this.chQ.afx();
        if (aVar == null) {
            showNetRefreshView(this.chQ.VM(), TbadkCoreApplication.getInst().getString(d.l.error_unkown_try_again), true);
        } else if (aVar.gdD) {
            if (340001 == aVar.errorCode) {
                showNetRefreshViewNoClick(this.chQ.VM(), TbadkCoreApplication.getInst().getString(d.l.net_error_text, new Object[]{aVar.errorMsg, Integer.valueOf(aVar.errorCode)}), true);
            } else {
                showNetRefreshView(this.chQ.VM(), TbadkCoreApplication.getInst().getString(d.l.net_error_text, new Object[]{aVar.errorMsg, Integer.valueOf(aVar.errorCode)}), true);
            }
        } else if (340001 == aVar.errorCode) {
            showNetRefreshViewNoClick(this.chQ.VM(), aVar.errorMsg, true);
        } else {
            showNetRefreshView(this.chQ.VM(), aVar.errorMsg, true);
        }
        if (afo()) {
            setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.k.g(TbadkCoreApplication.getInst(), d.f.ds280));
        } else {
            setNetRefreshViewEmotionDefMarginTop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeX() {
        eB(false);
    }

    private void eB(boolean z) {
        hideLoadingView(this.chQ.VM());
        this.chQ.ck(false);
        this.chQ.afI();
        if (this.chQ.afv() instanceof com.baidu.tieba.frs.tab.c) {
            ((com.baidu.tieba.frs.tab.c) this.chQ.afv()).aiQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeY() {
        if (aeV() == 0 && com.baidu.tbadk.core.util.u.v(this.chu.bqA())) {
            if (com.baidu.tbadk.core.util.u.v(this.chu.getThreadList())) {
                this.chQ.XC();
                return;
            } else {
                this.chQ.VU();
                return;
            }
        }
        this.chQ.VS();
    }

    public void a(ErrorData errorData) {
        aeX();
        this.chQ.afC();
        d.a aij = this.chZ.aij();
        boolean v = com.baidu.tbadk.core.util.u.v(this.chu.getThreadList());
        if (aij != null && v) {
            if (v) {
                if (this.chZ.aik() != 0) {
                    this.chZ.aiq();
                    this.chQ.afC();
                } else {
                    a(aij, false);
                }
                this.chQ.s(this.chu.brx(), false);
                return;
            } else if (aij.gdD) {
                this.chQ.s(true, false);
                showToast(getPageContext().getResources().getString(d.l.net_error_text, aij.errorMsg, Integer.valueOf(aij.errorCode)));
                return;
            } else {
                return;
            }
        }
        a(aij, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeZ() {
        if (this.chu == null || this.chu.aOW() != null) {
            this.chQ.afL();
        } else if (this.chu.aOW().getYuleData() != null && this.chu.aOW().getYuleData().sZ()) {
            TiebaStatic.log("c10852");
            this.chQ.a(this.chu.aOW().getYuleData().ta());
        } else {
            this.chQ.afL();
        }
    }

    private void q(boolean z, boolean z2) {
        if (this.chZ != null && this.chu != null && this.chQ != null && z) {
            if (!this.chZ.aiw() && this.chZ.aim() == 1) {
                if (!this.chZ.aiu()) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        this.chu.brq();
                        this.chu.brn();
                    }
                    this.chu.bro();
                    this.chu.brp();
                }
                boolean z3 = false;
                if (this.chQ.afM().k(com.baidu.tieba.card.data.p.bIN)) {
                    z3 = this.chu.brt();
                }
                if (!z3) {
                    this.chu.brr();
                }
                if (TbadkCoreApplication.getInst().isRecAppExist()) {
                    this.chu.a(this);
                }
                if (!this.chQ.afM().k(bl.XI)) {
                    this.chu.brk();
                }
                this.chu.bru();
                this.chu.brv();
            }
            this.chu.brl();
            this.chu.bri();
            if (this.chQ.afM().k(com.baidu.tieba.g.b.cDC)) {
                this.chu.mv(z2);
            }
        }
    }

    public boolean afa() {
        if (this.cib != null && this.chQ != null) {
            this.cib.b(this.chQ.getListView());
        }
        if (this.cia != null && this.chZ != null) {
            this.cia.a(this.chZ.aii(), this.chu);
        }
        boolean z = false;
        if (this.chu != null) {
            z = this.chu.bry();
        }
        eC(z);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iB(int i) {
        an anVar = null;
        afa();
        afj();
        try {
            if (this.chu != null) {
                this.chQ.a((ArrayList<com.baidu.adp.widget.ListView.f>) null, this.chu);
                this.cia.jv(1);
                this.chQ.afF();
                this.cib.a(this.chQ.getListView(), this.chu, this.chZ.ais());
                com.baidu.tieba.frs.tab.d a2 = a(this.cib.agS(), this.chu.bqP());
                if (a2 != null && !TextUtils.isEmpty(a2.url)) {
                    anVar = new an();
                    anVar.ckU = a2.url;
                    anVar.stType = a2.name;
                }
                this.chZ.a(this.chu.bqP(), 0, anVar);
                this.cib.eR(false);
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
            if (dVar != null && dVar.cuQ == i) {
                return dVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(boolean z, boolean z2) {
        AlaLiveNotify brc;
        try {
            if (this.chu != null && this.cib != null && this.chZ != null) {
                if (!this.chQ.afM().k(bl.XI)) {
                    this.chu.brk();
                }
                if (!com.baidu.tbadk.core.util.u.v(this.chu.brd()) && this.ciw == null) {
                    this.ciw = new com.baidu.tieba.frs.h.e(this, (NoPressedRelativeLayout) this.mRootView);
                }
                if (this.chu.aOW() != null) {
                    this.chI = this.chu.aOW().getName();
                    this.forumId = this.chu.aOW().getId();
                }
                if (this.chu.bry()) {
                    this.cib.a(this.chQ.getListView(), this.chu, this.chZ.ais());
                }
                if (z) {
                    q(true, z);
                } else {
                    q(this.chY, z);
                }
                afa();
                if (this.cij != null) {
                    this.cij.a(this.cia, this.chu);
                }
                if (this.chu.qx() != null) {
                    setHasMore(this.chu.qx().qt());
                }
                ArrayList<com.baidu.adp.widget.ListView.f> a2 = this.cin.a(z2, true, this.chu.getThreadList(), null);
                if (a2 != null) {
                    this.chu.aB(a2);
                }
                if (this.chZ.aim() == 1) {
                    afg();
                    if (!z && this.chZ.getPn() == 1 && (brc = afm().brc()) != null) {
                        new com.baidu.tieba.frs.d.a().a(this, brc);
                    }
                }
                this.chx = this.chu.aio();
                if (this.chM != null) {
                    this.chL = true;
                    this.chM.tf(this.chx);
                    com.baidu.tieba.frs.g.a.a(this, this.chu.aOW(), this.chu.getThreadList(), this.chL, getPn());
                }
                if (this.cil != null) {
                    this.cil.cj(this.chZ.aiw());
                    this.cil.ao(this.cib.agT());
                }
                eB(z);
                this.chQ.afy();
                this.chQ.s(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.g gVar) {
        try {
            if (!this.chU && gVar != null && this.chu != null) {
                this.chu.e(gVar);
                r(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void eC(boolean z) {
        if (this.chZ != null) {
            e(z, this.chZ.aii());
        } else {
            e(z, "normal_page");
        }
    }

    private void e(boolean z, String str) {
        eD("frs_page".equals(str));
        if (this.cij != null) {
            this.cij.a(z, this.cib, this.cia, this.chQ, this.chu);
        }
    }

    public void eD(boolean z) {
        if (this.cio != null) {
            this.cio.a(this.chQ, z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(d.j.frs_activity, viewGroup, false);
            this.chC = new com.baidu.tieba.frs.entelechy.b();
            this.cij = this.chC.agl();
            this.cia = new com.baidu.tieba.frs.h.f(this, this.chC);
            this.cib = this.chC.z(this);
            Intent intent = this.cit != null ? this.cit : getActivity().getIntent();
            if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                this.chE = true;
            }
            this.chQ = new i(this, this.ciP, this.chC, this.chE);
            this.chQ.setHeaderViewHeight(this.ciu);
        } else if (this.mRootView.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            this.chQ.afR();
        }
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Intent intent = this.cit != null ? this.cit : getActivity().getIntent();
        this.bXv = System.currentTimeMillis();
        if (intent != null) {
            this.chN = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.bXv = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            K(intent);
        }
        this.VG = System.currentTimeMillis();
        this.aIL = this.VG - this.bXv;
        this.chM = new com.baidu.tieba.tbadkCore.data.e("frs", com.baidu.tieba.tbadkCore.data.e.ggb);
        this.chZ = new FrsModelController(this, this.ciJ);
        this.chZ.a(this.ciB);
        this.chZ.init();
        if (intent != null) {
            this.chZ.f(intent.getExtras());
        } else if (bundle != null) {
            this.chZ.f(bundle);
        } else {
            this.chZ.f(null);
        }
        this.cib.al(this.chQ.VM());
        if (intent != null) {
            this.cia.j(intent.getExtras());
        } else if (bundle != null) {
            this.cia.j(bundle);
        } else {
            this.cia.j((Bundle) null);
        }
        this.chP = getVoiceManager();
        this.ciq = new h(getPageContext(), this);
        initUI();
        initData(bundle);
        if (this.aia != null && this.aia.equals("from_tieba_kuang")) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c12264").r("obj_type", 1).aa(ImageViewerConfig.FORUM_NAME, this.chZ.getForumName()));
            KuangFloatingViewController.getInstance().setNeedShowFloatingView(true);
            KuangFloatingViewController.getInstance().showFloatingView();
        }
        if (!afo()) {
            this.cih = new am(getActivity(), this.chQ, this.cia);
            this.cih.eN(true);
        }
        this.chP = getVoiceManager();
        if (this.chP != null) {
            this.chP.onCreate(getPageContext());
        }
        new com.baidu.tieba.frs.mc.h();
        this.cin = new com.baidu.tieba.frs.mc.d(this, this.ciL);
        this.cif = new com.baidu.tieba.frs.smartsort.b(this);
        this.cio = new com.baidu.tieba.frs.h.h(this);
        this.createTime = System.currentTimeMillis() - this.VG;
        this.cil = new com.baidu.tieba.frs.h.a(getPageContext(), this.chZ.ait());
        this.cig = new com.baidu.tieba.frs.mc.c(this);
        this.cim = new com.baidu.tieba.frs.mc.e(this);
        this.cic = new com.baidu.tieba.frs.mc.g(this);
        this.cie = new com.baidu.tieba.frs.mc.b(this);
        this.cip = new com.baidu.tieba.frs.mc.a(this);
        this.cir = new com.baidu.tieba.frs.h.c(this);
        this.cis = new com.baidu.tieba.frs.mc.f(this, getUniqueId());
        registerListener(this.mMemListener);
        registerListener(this.ciH);
        registerListener(this.ciN);
        registerListener(this.ciG);
        registerListener(this.ciK);
        registerListener(this.ciD);
        registerListener(this.ciE);
        registerListener(this.ciF);
        registerListener(this.ciz);
        registerListener(this.ciA);
        registerListener(this.ciV);
        registerListener(this.ciI);
        this.chQ.eI(false);
        if (!afo()) {
            showLoadingView(this.chQ.VM(), true);
            this.chZ.q(3, true);
        }
        super.onActivityCreated(bundle);
    }

    @Override // com.baidu.tieba.frs.ah
    public void afb() {
        if (isAdded() && this.biq && !isLoadingViewAttached()) {
            showLoadingView(this.chQ.VM(), true);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void afc() {
        if (isAdded() && this.biq && isLoadingViewAttached()) {
            hideLoadingView(this.chQ.VM());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (afo()) {
            showLoadingView(this.chQ.VM(), true);
            this.chQ.iE(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.chZ.q(3, true);
            getListView().setSelection(0);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void setHeaderViewHeight(int i) {
        this.ciu = i;
        if (this.chQ != null) {
            this.chQ.setHeaderViewHeight(this.ciu);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void setRecommendFrsNavigationAnimDispatcher(r rVar) {
        if (rVar != null) {
            this.aLC = rVar.Hh();
            this.civ = rVar.Hi();
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void showFloatingView() {
        if (this.aLC != null) {
            this.aLC.cg(true);
        }
    }

    private void K(Intent intent) {
        if (intent != null) {
            if (!com.baidu.tieba.frs.g.f.a(this, getForumName(), "from", intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false))) {
                getActivity().finish();
                return;
            }
        }
        if (intent != null && intent.getData() != null) {
            Uri data = intent.getData();
            this.chI = data.getQueryParameter("name");
            this.aia = data.getQueryParameter("from");
            if (!StringUtils.isNull(this.chI)) {
                intent.putExtra("name", this.chI);
            }
            if (!StringUtils.isNull(this.aia)) {
                intent.putExtra("from", this.aia);
            }
            TiebaStatic.log("c10105");
        }
        if (StringUtils.isNull(this.chI)) {
            this.chI = com.baidu.tieba.frs.g.i.M(intent);
            if (!StringUtils.isNull(this.chI)) {
                intent.putExtra("name", this.chI);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.chP = getVoiceManager();
        if (this.chP != null) {
            this.chP.onStart(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.ciS);
        if (bundle != null) {
            this.chI = bundle.getString("name");
            this.aia = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Intent intent = getActivity().getIntent();
            if (intent != null) {
                this.chI = intent.getStringExtra("name");
                this.aia = intent.getStringExtra("from");
                this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
            }
        }
        if (TextUtils.isEmpty(this.aia) || FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.aia)) {
        }
        if (this.mIsLogin) {
            registerListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL, this.ciS);
        }
        this.cia.j(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.ciV);
        if (this.chP != null) {
            this.chP.onDestory(getPageContext());
        }
        this.chP = null;
        com.baidu.tieba.card.u.Ww().dE(false);
        if (this.chu != null && this.chu.aOW() != null) {
            ac.aga().bi(com.baidu.adp.lib.g.b.c(this.chu.aOW().getId(), 0L));
        }
        if (this.chQ != null) {
            com.baidu.tieba.frs.g.h.a(this.chQ, this.chu, getForumId(), false, null);
            this.chQ.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.chW != null) {
                this.chW.onDestroy();
            }
            this.chQ.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.chZ.onActivityDestroy();
        this.cia.onActivityDestroy();
        if (this.chX != null) {
            this.chX.cancel(true);
            this.chX = null;
        }
        if (this.chZ != null) {
            this.chZ.Os();
        }
        if (this.cih != null) {
            this.cih.Hg();
        }
        if (this.cik != null) {
            this.cik.destory();
        }
        if (this.cil != null) {
            this.cil.destory();
        }
        if (this.cif != null) {
            this.cif.onDestroy();
        }
        if (this.ciw != null) {
            this.ciw.onDestory();
        }
        com.baidu.tieba.recapp.d.a.bhY().bia();
        com.baidu.tieba.frs.g.j.aiT();
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.chI);
        bundle.putString("from", this.aia);
        this.chZ.onSaveInstanceState(bundle);
        if (this.chP != null) {
            this.chP.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.cip != null) {
            this.cip.onActivityResult(i, i2, intent);
        }
    }

    public void a(UpdateAttentionMessage updateAttentionMessage) {
        Message<?> message;
        if (updateAttentionMessage != null && updateAttentionMessage.isAttention() && updateAttentionMessage.isGod() && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(getUniqueId())) {
            if (this.cik == null) {
                this.cik = new com.baidu.tbadk.i.a(getPageContext());
            }
            this.cik.an(updateAttentionMessage.getData().toUid, getForumId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.chQ != null) {
            this.chQ.afC();
            this.chQ.onResume();
        }
        this.cib.a(this.ciC);
        this.cic.eY(true);
        this.chY = true;
        if (isNeedRefreshOnResume) {
            isNeedRefreshOnResume = false;
            this.chQ.startPullRefresh();
        } else if (chF) {
            chF = false;
            this.chQ.startPullRefresh();
        } else {
            if (this.chP != null) {
                this.chP.onResume(getPageContext());
            }
            this.chQ.eJ(false);
            registerListener(this.ciO);
            if (this.cix) {
                ck(6);
                this.cix = false;
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
        this.cit = intent;
    }

    public boolean afd() {
        if (getActivity() == null) {
            return false;
        }
        Intent intent = this.cit != null ? this.cit : getActivity().getIntent();
        if (intent != null) {
            return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
        }
        return false;
    }

    public void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.chI = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.aia = intent.getStringExtra("from");
            }
            this.chK = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.chK) {
                afe();
            }
            if (this.aia != null && this.aia.equals("from_tieba_kuang")) {
                KuangFloatingViewController.getInstance().setNeedShowFloatingView(true);
                KuangFloatingViewController.getInstance().showFloatingView();
            }
        }
    }

    private void afe() {
        this.chQ.startPullRefresh();
    }

    public void closeActivity() {
        com.baidu.tieba.frs.g.i.a(getPageContext(), getActivity().getIntent(), this.aia);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.chQ.setTitle(this.chI);
        } else {
            this.chQ.setTitle("");
            this.mFlag = 1;
        }
        this.cia.d(this.chQ.getListView());
        this.chQ.setOnAdapterItemClickListener(this.ciT);
        this.chQ.setOnScrollListener(this.ciQ);
        this.chQ.c(this.bDL);
        this.chQ.afM().a(this.ciR);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.chQ.onChangeSkinType(i);
        this.cia.ju(i);
        this.cib.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.d.c
    public void lp() {
    }

    @Override // com.baidu.adp.widget.d.c
    public void lq() {
    }

    public void iC(int i) {
        if (!this.mIsLogin) {
            if (this.chu != null && this.chu.qh() != null) {
                this.chu.qh().setIfpost(1);
            }
            if (i == 0) {
                aw.aM(getActivity());
            }
        } else if (this.chu != null) {
            if (i == 0) {
                if (!this.chG) {
                    com.baidu.tieba.frs.g.j.b(this, 0);
                    return;
                }
                TiebaStatic.log("c10152");
                com.baidu.tieba.frs.g.j.b(this, 4);
                return;
            }
            this.chQ.afE();
        }
    }

    public void refresh() {
        ck(3);
    }

    public void ck(int i) {
        this.chU = false;
        afj();
        if (this.chQ.afu() != null) {
            this.chQ.afu().apM();
        }
        this.chZ.q(i, true);
    }

    private void aff() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.g.h.fQ().f(new Runnable() { // from class: com.baidu.tieba.frs.f.10
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.sa(f.this.chI);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afg() {
        afj();
        try {
            if (this.chu != null) {
                this.chQ.Nm();
                this.chQ.eF(this.chZ.ain());
                if (com.baidu.tieba.frs.h.f.i(this.chu) && !com.baidu.tieba.frs.h.f.h(this.chu)) {
                    this.chQ.afP();
                }
                if (this.chu.aOW() != null) {
                    this.chI = this.chu.aOW().getName();
                    this.forumId = this.chu.aOW().getId();
                }
                if (this.chu.qx() != null) {
                    setHasMore(this.chu.qx().qt());
                }
                this.chQ.setTitle(this.chI);
                this.chQ.setForumName(this.chI);
                TbadkCoreApplication.getInst().setDefaultBubble(this.chu.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.chu.getUserData().getBimg_end_time());
                aff();
                afh();
                ArrayList<com.baidu.adp.widget.ListView.f> threadList = this.chu.getThreadList();
                if (threadList != null) {
                    this.chQ.a(threadList, this.chu);
                    com.baidu.tieba.frs.g.c.j(this.chQ);
                    this.cia.jv(getPageNum());
                    this.cia.f(this.chu);
                    this.cib.a(this.chQ.getListView(), this.chu, this.chZ.ais());
                    this.chQ.afF();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void afh() {
        if (this.chu != null) {
            if (this.chu.aPk() == 1) {
                this.chQ.afM().setFromCDN(true);
            } else {
                this.chQ.afM().setFromCDN(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.cic.eY(false);
        this.chY = false;
        this.chQ.onPause();
        if (this.chP != null) {
            this.chP.onPause(getPageContext());
        }
        this.chQ.eJ(true);
        if (this.cil != null) {
            this.cil.aiW();
        }
        MessageManager.getInstance().unRegisterListener(this.ciO);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.u.Ww().dE(false);
        if (this.chu != null && this.chu.aOW() != null) {
            com.baidu.tbadk.distribute.a.CC().a(getPageContext().getPageActivity(), "frs", this.chu.aOW().getId(), 0L);
        }
        if (this.chP != null) {
            this.chP.onStop(getPageContext());
        }
        com.baidu.tieba.frs.g.i.c(getListView());
        this.cia.onActivityStop();
        s.Hk();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || this.chQ == null) {
            return false;
        }
        return this.chQ.afB();
    }

    @Override // com.baidu.tieba.recapp.o
    public TbPageContext<?> xY() {
        return getPageContext();
    }

    @Override // com.baidu.tieba.recapp.o
    public void a(AdvertAppInfo advertAppInfo, String str) {
        com.baidu.tbadk.distribute.a.CC().a(advertAppInfo, this.forumId, 0L, "FRS", str, getPn());
    }

    @Override // com.baidu.tieba.recapp.o
    public void afi() {
        aeP().afi();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.chP == null) {
            this.chP = VoiceManager.instance();
        }
        return this.chP;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public BdListView getListView() {
        if (this.chQ == null) {
            return null;
        }
        return this.chQ.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void afj() {
        if (this.chP != null) {
            this.chP.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> xf() {
        if (this.aog == null) {
            this.aog = UserIconBox.j(getPageContext().getPageActivity(), 8);
        }
        return this.aog;
    }

    public void afk() {
        if (getFragmentActivity() != null && getFragmentActivity().getCurrentFocus() != null) {
            com.baidu.adp.lib.util.k.b(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.g onGetPreLoadListView() {
        return getListView();
    }

    @Override // com.baidu.tieba.frs.aj
    public NavigationBar afl() {
        if (this.chQ == null) {
            return null;
        }
        return this.chQ.afl();
    }

    /* loaded from: classes.dex */
    private final class a implements com.baidu.adp.widget.ListView.h {
        private a() {
        }

        @Override // com.baidu.adp.widget.ListView.h
        public void a(View view, com.baidu.adp.widget.ListView.f fVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            boolean z;
            if (bdUniqueId != null) {
                if (bdUniqueId == p.ckl) {
                    if (f.this.chQ != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11752").aa("fid", f.this.forumId).aa("obj_locate", "1"));
                        f.this.chQ.startPullRefresh();
                    }
                } else if (fVar != null && (fVar instanceof bl)) {
                    bl blVar = (bl) fVar;
                    if (blVar.sg() == null || blVar.sg().getGroup_id() == 0 || aw.aN(f.this.getActivity())) {
                        if ((blVar.rZ() != 1 && blVar.rZ() != 2) || aw.aN(f.this.getActivity())) {
                            if (blVar.rI() != null) {
                                if (aw.aN(f.this.getActivity())) {
                                    String postUrl = blVar.rI().getPostUrl();
                                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.k.hy()) {
                                        com.baidu.tbadk.browser.a.U(f.this.getActivity(), postUrl);
                                    }
                                }
                            } else if (blVar.sr() != null) {
                                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                    aw.aM(f.this.getPageContext().getPageActivity());
                                    return;
                                }
                                com.baidu.tbadk.core.data.n sr = blVar.sr();
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(f.this.getPageContext().getPageActivity(), sr.getCartoonId(), sr.getChapterId(), 2)));
                            } else if (blVar.getThreadType() == 47 && blVar.rq() == 1 && !com.baidu.tbadk.core.util.al.isEmpty(blVar.rC())) {
                                com.baidu.tbadk.browser.a.T(f.this.getPageContext().getPageActivity(), blVar.rC());
                            } else {
                                com.baidu.tieba.tbadkCore.util.f readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                                if (readThreadHistory != null && !readThreadHistory.sg(blVar.getId())) {
                                    readThreadHistory.sf(blVar.getId());
                                }
                                final String rC = blVar.rC();
                                if (rC == null || rC.equals("")) {
                                    z = false;
                                } else {
                                    new Thread(new Runnable() { // from class: com.baidu.tieba.frs.f.a.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            com.baidu.tbadk.core.util.w wVar = new com.baidu.tbadk.core.util.w(rC);
                                            wVar.vb().vX().mIsNeedAddCommenParam = false;
                                            wVar.vb().vX().mIsUseCurrentBDUSS = false;
                                            wVar.tV();
                                        }
                                    }).start();
                                    z = true;
                                }
                                String tid = blVar.getTid();
                                if (tid == null) {
                                    tid = "";
                                }
                                if (blVar.rq() == 2 && !tid.startsWith("pb:")) {
                                    com.baidu.tbadk.core.util.at.vV().c(f.this.getPageContext(), new String[]{tid, "", null});
                                } else if (blVar.getThreadType() == 33 || (blVar instanceof ay)) {
                                    String str = blVar.getThreadType() == 33 ? "c10245" : "c10180";
                                    if (f.this.chZ.aim() == 5) {
                                        str = "c10387";
                                    }
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.aj(str).aa("fid", f.this.forumId));
                                    com.baidu.tieba.frs.g.i.c(f.this, blVar);
                                    if (f.this.chu != null && f.this.chu.aOW() != null) {
                                        com.baidu.tieba.frs.f.a aVar = new com.baidu.tieba.frs.f.a();
                                        aVar.cuj = f.this.chu.gef == 1;
                                        aVar.cul = f.this.chu.aOW().getId();
                                        aVar.cuk = f.this.aeP().ais();
                                        com.baidu.tieba.frs.f.b.aiM().a(aVar, blVar, 1);
                                    }
                                } else {
                                    if (tid.startsWith("pb:")) {
                                        blVar.setId(tid.substring(3));
                                    }
                                    if (bdUniqueId.getId() == bl.YQ.getId()) {
                                        com.baidu.tieba.frs.g.h.a(blVar.rd());
                                        com.baidu.tieba.frs.g.i.b(f.this, blVar);
                                        return;
                                    }
                                    com.baidu.tieba.frs.g.i.a(f.this, blVar, i, z);
                                    com.baidu.tieba.frs.g.h.a(f.this, f.this.chu, blVar);
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
        if (com.baidu.adp.lib.util.k.hy()) {
            hideNetRefreshView(this.chQ.VM());
            showLoadingView(this.chQ.VM(), true);
            this.chQ.eI(false);
            this.chZ.q(3, true);
        }
    }

    public com.baidu.tieba.tbadkCore.i afm() {
        return this.chu;
    }

    public boolean afn() {
        return this.chQ.afn();
    }

    public void P(Object obj) {
        if (this.cig != null && this.cig.ctd != null) {
            this.cig.ctd.g(obj);
        }
    }

    public void Q(Object obj) {
        if (this.cig != null && this.cig.cte != null) {
            this.cig.cte.g(obj);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.k.hy()) {
            this.chQ.XC();
        } else if (this.chZ.aim() == 1) {
            MU();
            MN();
        } else if (this.chZ.hasMore()) {
            MN();
        }
    }

    public void kf(String str) {
        MU();
        showToast(str);
    }

    public void G(ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        MU();
        if (!com.baidu.tbadk.core.util.u.v(arrayList)) {
            if (!this.chZ.aiw() && TbadkCoreApplication.getInst().isRecAppExist() && this.chZ.aim() == 1) {
                this.chu.a(this, arrayList);
            }
            ArrayList<com.baidu.adp.widget.ListView.f> a2 = this.cin.a(false, false, arrayList, this.chM);
            if (a2 != null) {
                this.chu.aB(a2);
                this.chQ.a(a2, this.chu);
            }
            if (this.chZ != null) {
                com.baidu.tieba.frs.f.b.a(this.chu, this.chZ.ais(), 2);
            }
        }
    }

    private void MU() {
        if (aeV() == 1 || this.cin.aK(this.chu.bqA())) {
            this.chQ.VS();
        } else if (com.baidu.tbadk.core.util.u.v(this.chu.getThreadList())) {
            this.chQ.XC();
        } else {
            this.chQ.VU();
        }
    }

    @Override // com.baidu.tieba.frs.mc.k
    public void MN() {
        if (this.cin != null) {
            this.cin.a(this.chI, this.forumId, this.chu);
        }
    }

    public void Sz() {
        if (!com.baidu.tbadk.core.util.aa.d(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.ah.c(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return afo() ? "a034" : "a006";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (!afo()) {
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

    public void eE(boolean z) {
        if (this.cih != null) {
            this.cih.eN(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.cii.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a fG(int i) {
        return this.cii.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        this.ciq.b(bVar);
    }

    public boolean afo() {
        return this.chE;
    }

    @Override // com.baidu.tieba.frs.ah
    public void afp() {
        if (this.chQ != null) {
            showFloatingView();
            this.chQ.getListView().setSelection(0);
            this.chQ.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public ForumWriteData afq() {
        if (this.chu == null || this.chu.aOW() == null) {
            return null;
        }
        ForumData aOW = this.chu.aOW();
        ForumWriteData forumWriteData = new ForumWriteData(aOW.getId(), aOW.getName(), aOW.getPrefixData(), this.chu.qh());
        forumWriteData.setForumLevel(aOW.getUser_level());
        forumWriteData.setAvatar(this.chu.aOW().getImage_url());
        return forumWriteData;
    }

    @Override // com.baidu.tieba.frs.ah
    public void wV() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void cH(boolean z) {
        if (this.chQ != null) {
            this.chQ.cH(z);
        }
    }
}
