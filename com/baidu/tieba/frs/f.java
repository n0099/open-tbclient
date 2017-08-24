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
    private q aMT;
    private com.baidu.adp.lib.e.b<TbImageView> apB;
    private boolean cjB;
    public bl cjC;
    private com.baidu.tieba.tbadkCore.data.e cjH;
    private VoiceManager cjK;
    private f.a cjS;
    private FrsModelController cjU;
    private com.baidu.tieba.frs.g.f cjV;
    private com.baidu.tieba.frs.entelechy.b.d cjW;
    private com.baidu.tieba.frs.mc.g cjX;
    private com.baidu.tieba.frs.mc.b cjY;
    private com.baidu.tieba.frs.smartsort.b cjZ;
    private com.baidu.tieba.frs.entelechy.b cjx;
    private boolean ckG;
    private com.baidu.tieba.frs.mc.c cka;
    private am ckb;
    private com.baidu.tieba.frs.entelechy.b.b ckd;
    private com.baidu.tbadk.i.a cke;
    private com.baidu.tieba.frs.g.a ckf;
    private com.baidu.tieba.frs.mc.e ckg;
    private com.baidu.tieba.frs.mc.d ckh;
    private com.baidu.tieba.frs.g.h cki;
    private com.baidu.tieba.frs.mc.a ckj;
    private h ckk;
    public com.baidu.tieba.frs.g.c ckl;
    private com.baidu.tieba.frs.mc.f ckm;
    private Intent ckn;
    private int cko;
    private View.OnTouchListener ckp;
    private com.baidu.tieba.frs.g.e ckq;
    private boolean ckr;
    public View mRootView;
    private static boolean isNeedRefreshOnResume = false;
    public static boolean cjA = false;
    public static volatile long cjM = 0;
    public static volatile long cjN = 0;
    public static volatile int cjO = 0;
    public boolean cjy = false;
    private boolean cjz = false;
    public String cjD = null;
    public String ajv = null;
    public int mFlag = 0;
    private boolean cjE = false;
    private boolean cjF = false;
    private String mThreadId = null;
    private String forumId = null;
    private int cjr = 0;
    private boolean cjG = false;
    private boolean cjI = false;
    private boolean cjJ = false;
    private i cjL = null;
    public final bl bgG = null;
    private com.baidu.tieba.tbadkCore.i cjo = new com.baidu.tieba.tbadkCore.i();
    public long bZo = -1;
    public long aKk = 0;
    public long aKc = 0;
    public long createTime = 0;
    public long Xf = -1;
    private boolean cjP = false;
    private boolean cjQ = false;
    public com.baidu.tbadk.l.d cjR = null;
    private boolean cjT = true;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> ckc = new SparseArray<>();
    private boolean bjC = true;
    private boolean cks = false;
    private final CustomMessageListener ckt = new CustomMessageListener(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED) { // from class: com.baidu.tieba.frs.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof bl) {
                    com.baidu.tieba.frs.f.h.a(f.this.cjL, f.this.cjo, f.this.getForumId(), true, (bl) data);
                }
            }
        }
    };
    private CustomMessageListener cku = new CustomMessageListener(CmdConfigCustom.CMD_CLOSE_GAME_RANK_CARD) { // from class: com.baidu.tieba.frs.f.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (f.this.cjo != null) {
                f.this.cjo.bsa();
                if (f.this.cjL != null) {
                    f.this.cjL.XY();
                }
            }
        }
    };
    private final ak ckv = new ak() { // from class: com.baidu.tieba.frs.f.19
        @Override // com.baidu.tieba.frs.ak
        public void a(int i, int i2, aq aqVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
            f.this.afs();
            if (f.this.ckd != null) {
                f.this.cjV.fd(f.this.ckd.iR(i));
            }
            d.a aVar = new d.a();
            if (aqVar != null) {
                aVar.isSuccess = aqVar.errCode == 0;
                aVar.errorCode = aqVar.errCode;
                aVar.errorMsg = aqVar.errMsg;
                if (aVar.isSuccess) {
                    if (com.baidu.tbadk.core.util.u.v(arrayList)) {
                        f.this.cjL.XZ();
                    } else if (aqVar.hasMore) {
                        f.this.cjL.Wq();
                    } else if (aqVar.cmT) {
                        f.this.cjL.Ws();
                    } else {
                        f.this.cjL.XZ();
                    }
                }
            } else {
                aqVar = new aq();
                aqVar.pn = 1;
                aqVar.hasMore = false;
                aqVar.cmT = false;
            }
            if (i == 1) {
                f.this.cjT = true;
                f.this.ckD.a(f.this.cjU.getType(), false, aVar);
            } else {
                f.this.a(aVar, true);
                if (f.this.cjU.aig() != null) {
                    f.this.cjo = f.this.cjU.aig();
                }
                f.this.afB();
            }
            if (f.this.ckO != null) {
                f.this.ckO.a(i, i2, aqVar, arrayList);
            }
        }
    };
    private ai ckw = new ai() { // from class: com.baidu.tieba.frs.f.20
        @Override // com.baidu.tieba.frs.ai
        public void a(ak akVar) {
        }

        @Override // com.baidu.tieba.frs.ai
        public void a(int i, int i2, an anVar) {
            if (i != 1) {
                com.baidu.tieba.card.u.WU().dF(false);
            }
            if (i == 1) {
                f.this.cjL.eJ(true);
                f.this.cjL.eI(false);
            } else {
                f.this.cjL.eK(true);
                f.this.cjL.eI(true);
            }
            f.this.afE();
            f.this.cjU.a(i, i2, anVar);
        }

        @Override // com.baidu.tieba.frs.ai
        public void init() {
        }

        @Override // com.baidu.tieba.frs.ai
        public void Ox() {
        }
    };
    private CustomMessageListener ckx = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIVE_COUNT) { // from class: com.baidu.tieba.frs.f.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                ((com.baidu.tieba.frs.entelechy.c.a) f.this.cjW).iT(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    };
    private CustomMessageListener cky = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_LIVE_START) { // from class: com.baidu.tieba.frs.f.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && ((Integer) customResponsedMessage.getData()).intValue() == 51 && f.this.cjo != null) {
                com.baidu.tieba.frs.f.j.a(f.this.cjo, f.this.getPageContext());
            }
        }
    };
    private final CustomMessageListener ckz = new CustomMessageListener(CmdConfigCustom.CMD_FRS_SELECT_ALA_LIVE_TAB) { // from class: com.baidu.tieba.frs.f.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (f.this.cjW instanceof com.baidu.tieba.frs.entelechy.c.a) && ((com.baidu.tieba.frs.entelechy.c.a) f.this.cjW).ahv() != null) {
                ((com.baidu.tieba.frs.entelechy.c.a) f.this.cjW).ahv().jx(49);
            }
        }
    };
    private final CustomMessageListener ckA = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.frs.f.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && f.this.cjo != null && f.this.cjo.aPJ() != null) {
                SignData signData = (SignData) customResponsedMessage.getData();
                int user_level = f.this.cjo.aPJ().getUser_level();
                if (signData.forumId != null && signData.forumId.equals(f.this.cjo.aPJ().getId())) {
                    f.this.cjo.d(signData);
                    f.this.cjV.g(f.this.cjo);
                    if (f.this.cjV.akc()) {
                        i = f.this.cjo.aPJ().getUser_level();
                        if (user_level >= i) {
                            i++;
                        }
                    } else {
                        i = user_level;
                    }
                    TbadkCoreApplication.getInst().addSignedForum(f.this.cjo.aPJ().getName(), signData.sign_bonus_point, i);
                }
            }
        }
    };
    private final CustomMessageListener ckB = new CustomMessageListener(CmdConfigCustom.CMD_FRS_EXPERIENCE_TIP) { // from class: com.baidu.tieba.frs.f.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.o) && f.this.cjo != null) {
                f.this.cjo.c((com.baidu.tieba.tbadkCore.o) customResponsedMessage.getData());
                f.this.cjV.f(f.this.cjo);
                f.this.cjW.a(f.this.cjL.getListView(), f.this.cjo, f.this.cjU.ajf());
            }
        }
    };
    private CustomMessageListener ckC = new CustomMessageListener(CmdConfigCustom.CMD_STORY_READ_CACHE) { // from class: com.baidu.tieba.frs.f.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.story.process.b)) {
                com.baidu.tieba.story.process.b bVar = (com.baidu.tieba.story.process.b) customResponsedMessage.getData();
                if (f.this.forumId != null && f.this.forumId.equals(String.valueOf(bVar.forumId)) && bVar.state == 3 && f.this.afH() != null && !com.baidu.tbadk.core.util.u.v(f.this.afH().bqY()) && f.this.cjx.agI() != null && f.this.cjx.agI().agY() != null) {
                    List<com.baidu.adp.widget.ListView.f> bqY = f.this.afH().bqY();
                    int size = bqY.size();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= size) {
                            i = -1;
                            break;
                        } else if ((bqY.get(i2) instanceof com.baidu.tbadk.data.f) && TbadkCoreApplication.getCurrentAccount().equals(String.valueOf(((com.baidu.tbadk.data.f) bqY.get(i2)).user_id))) {
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
                    fVar.aAD = String.valueOf(f.this.forumId);
                    fVar.aAC = bVar;
                    if (i != -1) {
                        bqY.set(i, fVar);
                    } else {
                        bqY.add(1, fVar);
                    }
                    f.this.cjx.agI().agY().b(bqY, f.this.forumId, f.this.getThreadId());
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.k ckD = new com.baidu.tieba.tbadkCore.k() { // from class: com.baidu.tieba.frs.f.3
        private long startTime = 0;

        @Override // com.baidu.tieba.tbadkCore.k
        public void iF(int i) {
            this.startTime = System.nanoTime();
            if (f.this.cjL != null) {
                switch (i) {
                    case 1:
                    case 2:
                        f.this.cjL.afY();
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
            if (f.this.bjC) {
                f.this.bjC = false;
                com.baidu.tieba.frs.f.h.a(f.this.cjL, f.this.cjo, f.this.getForumId(), false, null);
            }
            f.this.afs();
            f.this.cjP = true;
            if (aVar != null && aVar.isSuccess) {
                f.this.cjL.agi().eR(com.baidu.tbadk.core.util.am.vR().vT());
                f.cjM = 0L;
                f.cjN = 0L;
                f.cjO = 0;
            } else {
                f.cjO = 1;
            }
            if (!f.this.cjU.ajj() && (i == 3 || i == 6)) {
                f.this.ckh.resetData();
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (f.this.cjU.aig() != null) {
                f.this.cjo = f.this.cjU.aig();
            }
            if (i == 7) {
                f.this.iD(f.this.cjo.brx());
                return;
            }
            if (f.this.cjo.qI() != null) {
                f.this.setHasMore(f.this.cjo.qI().qE());
            }
            f.this.aft();
            if (i == 4) {
                if (!f.this.cjU.ajj() && TbadkCoreApplication.getInst().isRecAppExist() && f.this.cjU.aiZ() == 1) {
                    f.this.cjo.a(f.this);
                }
                ArrayList<com.baidu.adp.widget.ListView.f> a2 = f.this.ckh.a(false, false, f.this.cjo.getThreadList(), f.this.cjH);
                if (a2 != null) {
                    f.this.cjo.aB(a2);
                    f.this.cjo.brT();
                    f.this.cjL.a(a2, f.this.cjo);
                }
                if (f.this.cjU != null) {
                    com.baidu.tieba.frs.e.b.a(f.this.cjo, f.this.cjU.ajf(), 2);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    f.this.cjL.afY();
                    break;
                case 2:
                    f.this.cjL.afY();
                    break;
                case 3:
                case 6:
                    if (f.this.cjo != null) {
                        f.this.cjo.brR();
                    }
                    if (f.this.ckl != null) {
                        f.this.ckl.refresh();
                        break;
                    }
                    break;
            }
            f.this.afu();
            if (aVar == null || aVar.errorCode == 0) {
                if (f.this.cjo != null) {
                    f.this.cjL.iH(i);
                    f.this.s(false, i == 5);
                    f.cjM = (System.nanoTime() - this.startTime) / 1000000;
                    if (aVar != null) {
                        f.cjN = aVar.ggH;
                    }
                } else {
                    return;
                }
            } else if (f.this.cjo == null || com.baidu.tbadk.core.util.u.v(f.this.cjo.getThreadList())) {
                f.this.a(aVar, false);
            } else if (aVar.ggG) {
                f.this.showToast(f.this.getPageContext().getResources().getString(d.l.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
            }
            if (f.this.cjo.brc() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11384"));
            }
            if (f.this.bZo > -1 && !f.this.cks) {
                com.baidu.tieba.frs.f.h.a(f.this.cjU, f.this.bZo);
                f.this.bZo = -1L;
                f.this.cks = true;
            }
            if (f.this.cjI && (f.this.cjW instanceof com.baidu.tieba.frs.entelechy.c.a) && ((com.baidu.tieba.frs.entelechy.c.a) f.this.cjW).ahv() != null) {
                ((com.baidu.tieba.frs.entelechy.c.a) f.this.cjW).ahv().jx(49);
                f.this.cjI = false;
            }
            f.this.aKk = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.k
        public void b(com.baidu.tieba.tbadkCore.g gVar) {
            if (gVar != null) {
                if ("normal_page".equals(f.this.cjU.aiV()) || "frs_page".equals(f.this.cjU.aiV()) || "book_page".equals(f.this.cjU.aiV())) {
                    f.this.a(gVar);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE, gVar));
                }
            }
        }
    };
    private final CustomMessageListener ckE = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.frs.f.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                f.this.cjo.a((com.baidu.tbadk.data.j) customResponsedMessage.getData());
                f.this.cjL.agi().notifyDataSetChanged();
            }
        }
    };
    private final CustomMessageListener mMemListener = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_MEM) { // from class: com.baidu.tieba.frs.f.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && f.this.cjo != null && (userData = f.this.cjo.getUserData()) != null) {
                userData.setIsMem(num.intValue());
                if (num.intValue() != 0) {
                    f.this.cjV.e(num);
                }
            }
        }
    };
    private final com.baidu.tieba.frs.mc.j ckF = new com.baidu.tieba.frs.mc.j() { // from class: com.baidu.tieba.frs.f.6
        @Override // com.baidu.tieba.frs.mc.j
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
            if (f.this.cjZ != null && f.this.cjU != null && f.this.cjU.ajj() && z && !z2) {
                f.this.cjZ.jr(i2);
            }
        }
    };
    public final View.OnTouchListener aMU = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.f.7
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (f.this.ckp != null) {
                f.this.ckp.onTouch(view, motionEvent);
            }
            if (f.this.ckb != null && f.this.ckb.agA() != null) {
                f.this.ckb.agA().onTouchEvent(motionEvent);
            }
            f.this.ckG = true;
            if (f.this.cjV != null) {
                f.this.cjV.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private final CustomMessageListener ckH = new CustomMessageListener(CmdConfigCustom.CMD_GOTOLIVE_HOST_UPGRADE) { // from class: com.baidu.tieba.frs.f.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "photolive_hostLevel", -1) != -1 && f.this.cjo.aPJ() != null) {
                f.this.cjo.aPJ().setCanAddPhotoLivePost(true);
            }
        }
    };
    private final CustomMessageListener ckI = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.frs.f.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11455").aa("obj_locate", "frs"));
                    com.baidu.tbadk.core.util.at.wg().c(f.this.getPageContext(), new String[]{str});
                }
            }
        }
    };
    public final View.OnClickListener ckJ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.f.11
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (f.this.cjL == null || view != f.this.cjL.afW() || f.this.getActivity() == null) {
                if (f.this.cjo != null && f.this.cjo.aPJ() != null) {
                    if (f.this.cjL == null || view != f.this.cjL.agc()) {
                        if (f.this.cjL != null && view == f.this.cjL.agd()) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10378").r("obj_type", 5));
                            if (!StringUtils.isNull(f.this.cjo.aPJ().getName())) {
                                f.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PostSearchActivityConfig(f.this.getPageContext().getPageActivity(), f.this.cjo.aPJ().getName())));
                                return;
                            }
                            return;
                        }
                    } else if (!StringUtils.isNull(f.this.cjo.aPJ().getId())) {
                        if (f.this.cjo.aPJ() != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c12046").aa("fid", f.this.cjo.aPJ().getId()).r("obj_locate", f.this.afK() ? 1 : 2));
                        }
                        f.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(f.this.getPageContext().getPageActivity(), f.this.cjo.aPJ().getId(), ForumDetailActivityConfig.FromType.FRS)));
                        return;
                    } else {
                        return;
                    }
                }
                if (view.getId() == d.h.game_activity_egg_layout && com.baidu.adp.lib.util.k.hI()) {
                    TiebaStatic.log("c10853");
                    if (f.this.cjL.agf()) {
                        f.this.cjL.agg();
                        return;
                    }
                    String activityUrl = f.this.cjo.aPJ().getYuleData().tl().getActivityUrl();
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
    private final AbsListView.OnScrollListener ckK = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.f.13
        private int ckR = 0;
        private int bdb = 0;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (f.this.aMT != null && f.this.isPrimary()) {
                f.this.aMT.a(absListView, this.ckR, i, i2, i3);
            }
            if (f.this.cjW != null) {
                f.this.cjW.a(absListView, i, i2, i3, f.this.cjV.akh());
            }
            if (f.this.ckf != null) {
                f.this.ckf.ajJ();
            }
            if (f.this.cjZ != null) {
                f.this.cjZ.aju();
            }
            if (f.this.ckb != null) {
                f.this.ckb.a(absListView, i, i2, i3, f.this.cjV.akh(), false);
            }
            if (f.this.ckq != null) {
                f.this.ckq.onScroll(absListView, i, i2, i3);
            }
            if (f.this.cjo != null && f.this.cjL != null && f.this.cjL.agi() != null) {
                this.ckR = i;
                this.bdb = (i + i2) - 1;
                f.this.cjL.ap(this.ckR, this.bdb);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (f.this.cjV != null) {
                f.this.cjV.setScrollState(i);
            }
            if (f.this.aMT != null && f.this.isPrimary()) {
                f.this.aMT.onScrollStateChanged(absListView, i);
            }
            if (f.this.ckb != null) {
                f.this.ckb.a(absListView, i, 0);
            }
            if ((i == 2 || i == 1) && !f.this.cjQ) {
                f.this.cjQ = true;
                f.this.cjL.agk();
            }
            if (f.this.cjR == null && !f.this.afK()) {
                f.this.cjR = new com.baidu.tbadk.l.d();
                f.this.cjR.fi(1000);
            }
            if (i == 0) {
                com.baidu.tieba.card.u.WU().dF(true);
                f.this.cjL.ao(this.ckR, this.bdb);
            }
            if (f.this.ckq != null) {
                f.this.ckq.onScrollStateChanged(absListView, i);
            }
            if (f.this.cjR != null) {
                f.this.cjR.Gg();
            }
            if (i == 0) {
                com.baidu.tieba.frs.f.h.a(f.this.cjL, f.this.cjo, f.this.getForumId(), false, null);
            }
        }
    };
    private final b ckL = new b() { // from class: com.baidu.tieba.frs.f.14
        @Override // com.baidu.tieba.frs.b
        public void a(int i, int i2, View view, View view2, bl blVar) {
            if (i != f.this.cjL.agi().ahe()) {
                if (i != f.this.cjL.agi().ahf()) {
                    if (i != f.this.cjL.agi().ahh()) {
                        if (i != f.this.cjL.agi().ags()) {
                            if (i == f.this.cjL.agi().ahg() && f.this.cjo != null && f.this.cjo.getUserData() != null && f.this.cjo.getUserData().isBawu()) {
                                final String brv = f.this.cjo.brv();
                                if (!com.baidu.tbadk.core.util.al.isEmpty(brv) && f.this.cjo.aPJ() != null) {
                                    com.baidu.tieba.c.a.a(f.this.getPageContext(), f.this.cjo.aPJ().getId(), f.this.cjo.aPJ().getName(), new a.InterfaceC0076a() { // from class: com.baidu.tieba.frs.f.14.1
                                        @Override // com.baidu.tieba.c.a.InterfaceC0076a
                                        public void VH() {
                                            com.baidu.tbadk.browser.a.T(f.this.getPageContext().getPageActivity(), brv);
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10502").aa("fid", f.this.cjo.aPJ().getId()).aa(SapiAccountManager.SESSION_UID, f.this.cjo.getUserData().getUserId()));
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        f.this.cjC = blVar;
                        com.baidu.tieba.frs.f.i.a(f.this, f.this.cjC);
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c10179").aa("fid", f.this.getForumId()));
                        return;
                    }
                    com.baidu.tieba.frs.f.i.B(f.this);
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aj(i == f.this.cjL.agi().ahh() ? "c10177" : "c10244").aa("fid", f.this.getForumId()));
                } else if (aw.aO(f.this.getPageContext().getPageActivity())) {
                    TiebaStatic.log("my_service_ck");
                    if (f.this.cjo != null && f.this.cjo.aPJ() != null) {
                        ForumData aPJ = f.this.cjo.aPJ();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(f.this.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(aPJ.getId(), 0L), aPJ.getName(), aPJ.getImage_url(), 0)));
                    }
                }
            } else if (aw.aO(f.this.getActivity())) {
                TiebaStatic.log("forum_fortune_click");
                com.baidu.tieba.frs.f.i.a(f.this.getPageContext(), f.this.cjo);
            }
        }
    };
    private final NoNetworkView.a bFF = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.f.15
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aM(boolean z) {
            if (f.this.cjU.aiZ() == 1 && z && !f.this.cjL.afI()) {
                if (f.this.cjo == null || com.baidu.tbadk.core.util.u.v(f.this.cjo.getThreadList())) {
                    f.this.hideNetRefreshView(f.this.cjL.Wk());
                    f.this.showLoadingView(f.this.cjL.Wk(), true);
                    f.this.cjL.eK(false);
                    f.this.refresh();
                    return;
                }
                f.this.cjL.afY();
            }
        }
    };
    private final CustomMessageListener ckM = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.f.16
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                com.baidu.tieba.frs.f.c.a(customResponsedMessage, f.this.cjL, f.this.cjo);
            }
        }
    };
    private com.baidu.adp.widget.ListView.h ckN = new a();
    private ak ckO = new ak() { // from class: com.baidu.tieba.frs.f.17
        @Override // com.baidu.tieba.frs.ak
        public void a(int i, int i2, aq aqVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
            com.baidu.adp.lib.g.e.ga().post(new Runnable() { // from class: com.baidu.tieba.frs.f.17.1
                @Override // java.lang.Runnable
                public void run() {
                    if (f.this.cjL != null && f.this.cjL.XP()) {
                        f.this.MS();
                    }
                }
            });
        }
    };
    private CustomMessageListener ckP = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.frs.f.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    f.this.ckr = true;
                }
            }
        }
    };

    public com.baidu.tieba.frs.entelechy.b.b afg() {
        return this.ckd;
    }

    public com.baidu.adp.widget.ListView.h afh() {
        return this.ckN;
    }

    public com.baidu.tieba.frs.mc.e afi() {
        return this.ckg;
    }

    public com.baidu.tieba.frs.smartsort.b afj() {
        return this.cjZ;
    }

    @Override // com.baidu.tieba.frs.mc.k
    public FrsModelController afk() {
        return this.cjU;
    }

    @Override // com.baidu.tieba.frs.mc.k
    public com.baidu.tieba.frs.mc.d afl() {
        return this.ckh;
    }

    @Override // com.baidu.tieba.frs.mc.k
    public com.baidu.tieba.frs.g.f afm() {
        return this.cjV;
    }

    public com.baidu.tieba.frs.entelechy.b.d afn() {
        return this.cjW;
    }

    public am afo() {
        return this.ckb;
    }

    @Override // com.baidu.tieba.frs.mc.k
    public i afp() {
        return this.cjL;
    }

    @Override // com.baidu.tieba.frs.al
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.al
    public String getForumName() {
        return this.cjD;
    }

    public void setForumName(String str) {
        this.cjD = str;
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
        if (this.ckh == null) {
            return 1;
        }
        return this.ckh.getPn();
    }

    public int getPn() {
        if (this.ckh == null) {
            return 1;
        }
        return this.ckh.getPn();
    }

    public void setPn(int i) {
        if (this.ckh != null) {
            this.ckh.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.ckh != null) {
            this.ckh.setHasMore(i);
        }
    }

    public int afq() {
        if (this.ckh == null) {
            return -1;
        }
        return this.ckh.afq();
    }

    public boolean afr() {
        return this.cjJ;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d.a aVar, boolean z) {
        this.cjL.afT();
        if (aVar == null) {
            showNetRefreshView(this.cjL.Wk(), TbadkCoreApplication.getInst().getString(d.l.error_unkown_try_again), true);
        } else if (aVar.ggG) {
            if (340001 == aVar.errorCode) {
                showNetRefreshViewNoClick(this.cjL.Wk(), TbadkCoreApplication.getInst().getString(d.l.net_error_text, new Object[]{aVar.errorMsg, Integer.valueOf(aVar.errorCode)}), true);
            } else {
                showNetRefreshView(this.cjL.Wk(), TbadkCoreApplication.getInst().getString(d.l.net_error_text, new Object[]{aVar.errorMsg, Integer.valueOf(aVar.errorCode)}), true);
            }
        } else if (340001 == aVar.errorCode) {
            showNetRefreshViewNoClick(this.cjL.Wk(), aVar.errorMsg, true);
        } else {
            showNetRefreshView(this.cjL.Wk(), aVar.errorMsg, true);
        }
        if (afK()) {
            setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.k.g(TbadkCoreApplication.getInst(), d.f.ds280));
        } else {
            setNetRefreshViewEmotionDefMarginTop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afs() {
        eD(false);
    }

    private void eD(boolean z) {
        hideLoadingView(this.cjL.Wk());
        this.cjL.ck(false);
        this.cjL.age();
        if (this.cjL.afR() instanceof com.baidu.tieba.frs.tab.c) {
            ((com.baidu.tieba.frs.tab.c) this.cjL.afR()).ajD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aft() {
        if (afq() == 0 && com.baidu.tbadk.core.util.u.v(this.cjo.bri())) {
            if (com.baidu.tbadk.core.util.u.v(this.cjo.getThreadList())) {
                this.cjL.XZ();
                return;
            } else {
                this.cjL.Ws();
                return;
            }
        }
        this.cjL.Wq();
    }

    public void a(ErrorData errorData) {
        afs();
        this.cjL.afY();
        d.a aiW = this.cjU.aiW();
        boolean v = com.baidu.tbadk.core.util.u.v(this.cjo.getThreadList());
        if (aiW != null && v) {
            if (v) {
                if (this.cjU.aiX() != 0) {
                    this.cjU.ajd();
                    this.cjL.afY();
                } else {
                    a(aiW, false);
                }
                this.cjL.t(this.cjo.bsf(), false);
                return;
            } else if (aiW.ggG) {
                this.cjL.t(true, false);
                showToast(getPageContext().getResources().getString(d.l.net_error_text, aiW.errorMsg, Integer.valueOf(aiW.errorCode)));
                return;
            } else {
                return;
            }
        }
        a(aiW, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afu() {
        if (this.cjo == null || this.cjo.aPJ() != null) {
            this.cjL.agh();
        } else if (this.cjo.aPJ().getYuleData() != null && this.cjo.aPJ().getYuleData().tk()) {
            TiebaStatic.log("c10852");
            this.cjL.a(this.cjo.aPJ().getYuleData().tl());
        } else {
            this.cjL.agh();
        }
    }

    private void r(boolean z, boolean z2) {
        if (this.cjU != null && this.cjo != null && this.cjL != null && z) {
            if (!this.cjU.ajj() && this.cjU.aiZ() == 1) {
                if (!this.cjU.ajh()) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        this.cjo.brY();
                        this.cjo.brV();
                    }
                    this.cjo.brW();
                    this.cjo.brX();
                }
                boolean z3 = false;
                if (this.cjL.agi().k(com.baidu.tieba.card.data.p.bKH)) {
                    z3 = this.cjo.bsb();
                }
                if (!z3) {
                    this.cjo.brZ();
                }
                if (TbadkCoreApplication.getInst().isRecAppExist()) {
                    this.cjo.a(this);
                }
                if (!this.cjL.agi().k(bl.Zh)) {
                    this.cjo.brS();
                }
                this.cjo.bsc();
                this.cjo.bsd();
            }
            this.cjo.brT();
            this.cjo.brQ();
            if (this.cjL.agi().k(com.baidu.tieba.g.b.cGU)) {
                this.cjo.my(z2);
            }
        }
    }

    public boolean afv() {
        if (this.cjW != null && this.cjL != null) {
            this.cjW.b(this.cjL.getListView());
        }
        if (this.cjV != null && this.cjU != null) {
            this.cjV.a(this.cjU.aiV(), this.cjo);
        }
        boolean z = false;
        if (this.cjo != null) {
            z = this.cjo.bsg();
        }
        eE(z);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iD(int i) {
        an anVar = null;
        afv();
        afE();
        try {
            if (this.cjo != null) {
                this.cjL.a((ArrayList<com.baidu.adp.widget.ListView.f>) null, this.cjo);
                this.cjV.jF(1);
                this.cjL.agb();
                this.cjW.a(this.cjL.getListView(), this.cjo, this.cjU.ajf());
                com.baidu.tieba.frs.tab.d a2 = a(this.cjW.aho(), this.cjo.brx());
                if (a2 != null && !TextUtils.isEmpty(a2.url)) {
                    anVar = new an();
                    anVar.cmP = a2.url;
                    anVar.stType = a2.name;
                }
                this.cjU.a(this.cjo.brx(), 0, anVar);
                this.cjW.eT(false);
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
        AlaLiveNotify brK;
        try {
            if (this.cjo != null && this.cjW != null && this.cjU != null) {
                if (!this.cjL.agi().k(bl.Zh)) {
                    this.cjo.brS();
                }
                if (!com.baidu.tbadk.core.util.u.v(this.cjo.brL()) && this.ckq == null) {
                    this.ckq = new com.baidu.tieba.frs.g.e(this, (NoPressedRelativeLayout) this.mRootView);
                }
                if (this.cjo.aPJ() != null) {
                    this.cjD = this.cjo.aPJ().getName();
                    this.forumId = this.cjo.aPJ().getId();
                }
                if (this.cjo.bsg()) {
                    this.cjW.a(this.cjL.getListView(), this.cjo, this.cjU.ajf());
                }
                if (z) {
                    r(true, z);
                } else {
                    r(this.cjT, z);
                }
                afv();
                if (this.ckd != null) {
                    this.ckd.a(this.cjV, this.cjo);
                }
                if (this.cjo.qI() != null) {
                    setHasMore(this.cjo.qI().qE());
                }
                ArrayList<com.baidu.adp.widget.ListView.f> a2 = this.ckh.a(z2, true, this.cjo.getThreadList(), null);
                if (a2 != null) {
                    this.cjo.aB(a2);
                }
                if (this.cjU.aiZ() == 1) {
                    afB();
                    if (!z && this.cjU.getPn() == 1 && (brK = afH().brK()) != null) {
                        new com.baidu.tieba.frs.c.a().a(this, brK);
                    }
                }
                this.cjr = this.cjo.ajb();
                if (this.cjH != null) {
                    this.cjG = true;
                    this.cjH.to(this.cjr);
                    com.baidu.tieba.frs.f.a.a(this, this.cjo.aPJ(), this.cjo.getThreadList(), this.cjG, getPn());
                }
                if (this.ckf != null) {
                    this.ckf.cj(this.cjU.ajj());
                    this.ckf.ap(this.cjW.ahp());
                }
                eD(z);
                this.cjL.afU();
                this.cjL.t(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.g gVar) {
        try {
            if (!this.cjP && gVar != null && this.cjo != null) {
                this.cjo.e(gVar);
                s(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void eE(boolean z) {
        if (this.cjU != null) {
            f(z, this.cjU.aiV());
        } else {
            f(z, "normal_page");
        }
    }

    private void f(boolean z, String str) {
        eF("frs_page".equals(str));
        if (this.ckd != null) {
            this.ckd.a(z, this.cjW, this.cjV, this.cjL, this.cjo);
        }
    }

    public void eF(boolean z) {
        if (this.cki != null) {
            this.cki.a(this.cjL, z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(d.j.frs_activity, viewGroup, false);
            this.cjx = new com.baidu.tieba.frs.entelechy.b();
            this.ckd = this.cjx.agH();
            this.cjV = new com.baidu.tieba.frs.g.f(this, this.cjx);
            this.cjW = this.cjx.z(this);
            Intent intent = this.ckn != null ? this.ckn : getActivity().getIntent();
            if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                this.cjz = true;
            }
            this.cjL = new i(this, this.ckJ, this.cjx, this.cjz);
            this.cjL.setHeaderViewHeight(this.cko);
        } else if (this.mRootView.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            this.cjL.agn();
        }
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Intent intent = this.ckn != null ? this.ckn : getActivity().getIntent();
        this.bZo = System.currentTimeMillis();
        if (intent != null) {
            this.cjI = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.bZo = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            M(intent);
        }
        this.Xf = System.currentTimeMillis();
        this.aKc = this.Xf - this.bZo;
        this.cjH = new com.baidu.tieba.tbadkCore.data.e("frs", com.baidu.tieba.tbadkCore.data.e.gjf);
        this.cjU = new FrsModelController(this, this.ckD);
        this.cjU.a(this.ckv);
        this.cjU.init();
        if (intent != null) {
            this.cjU.f(intent.getExtras());
        } else if (bundle != null) {
            this.cjU.f(bundle);
        } else {
            this.cjU.f(null);
        }
        this.cjW.ak(this.cjL.Wk());
        if (intent != null) {
            this.cjV.i(intent.getExtras());
        } else if (bundle != null) {
            this.cjV.i(bundle);
        } else {
            this.cjV.i((Bundle) null);
        }
        this.cjK = getVoiceManager();
        this.ckk = new h(getPageContext(), this);
        initUI();
        initData(bundle);
        if (this.ajv != null && this.ajv.equals("from_tieba_kuang")) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c12264").r("obj_type", 1).aa(ImageViewerConfig.FORUM_NAME, this.cjU.getForumName()));
            KuangFloatingViewController.getInstance().setNeedShowFloatingView(true);
            KuangFloatingViewController.getInstance().showFloatingView();
        }
        if (!afK()) {
            this.ckb = new am(getActivity(), this.cjL, this.cjV);
            this.ckb.eP(true);
        }
        this.cjK = getVoiceManager();
        if (this.cjK != null) {
            this.cjK.onCreate(getPageContext());
        }
        new com.baidu.tieba.frs.mc.h();
        this.ckh = new com.baidu.tieba.frs.mc.d(this, this.ckF);
        this.cjZ = new com.baidu.tieba.frs.smartsort.b(this);
        this.cki = new com.baidu.tieba.frs.g.h(this);
        this.createTime = System.currentTimeMillis() - this.Xf;
        this.ckf = new com.baidu.tieba.frs.g.a(getPageContext(), this.cjU.ajg());
        this.cka = new com.baidu.tieba.frs.mc.c(this);
        this.ckg = new com.baidu.tieba.frs.mc.e(this);
        this.cjX = new com.baidu.tieba.frs.mc.g(this);
        this.cjY = new com.baidu.tieba.frs.mc.b(this);
        this.ckj = new com.baidu.tieba.frs.mc.a(this);
        this.ckl = new com.baidu.tieba.frs.g.c(this);
        this.ckm = new com.baidu.tieba.frs.mc.f(this, getUniqueId());
        registerListener(this.mMemListener);
        registerListener(this.ckB);
        registerListener(this.ckH);
        registerListener(this.ckA);
        registerListener(this.ckE);
        registerListener(this.ckx);
        registerListener(this.cky);
        registerListener(this.ckz);
        registerListener(this.ckt);
        registerListener(this.cku);
        registerListener(this.ckP);
        registerListener(this.ckC);
        this.cjL.eK(false);
        if (!afK()) {
            showLoadingView(this.cjL.Wk(), true);
            this.cjU.r(3, true);
        }
        super.onActivityCreated(bundle);
    }

    @Override // com.baidu.tieba.frs.ah
    public void afw() {
        if (isAdded() && this.bjC && !isLoadingViewAttached()) {
            showLoadingView(this.cjL.Wk(), true);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void afx() {
        if (isAdded() && this.bjC && isLoadingViewAttached()) {
            hideLoadingView(this.cjL.Wk());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (afK()) {
            showLoadingView(this.cjL.Wk(), true);
            this.cjL.iG(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.cjU.r(3, true);
            getListView().setSelection(0);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void setHeaderViewHeight(int i) {
        this.cko = i;
        if (this.cjL != null) {
            this.cjL.setHeaderViewHeight(this.cko);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void setRecommendFrsNavigationAnimDispatcher(r rVar) {
        if (rVar != null) {
            this.aMT = rVar.Hp();
            this.ckp = rVar.Hq();
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void showFloatingView() {
        if (this.aMT != null) {
            this.aMT.cg(true);
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
            this.cjD = data.getQueryParameter("name");
            this.ajv = data.getQueryParameter("from");
            if (!StringUtils.isNull(this.cjD)) {
                intent.putExtra("name", this.cjD);
            }
            if (!StringUtils.isNull(this.ajv)) {
                intent.putExtra("from", this.ajv);
            }
            TiebaStatic.log("c10105");
        }
        if (StringUtils.isNull(this.cjD)) {
            this.cjD = com.baidu.tieba.frs.f.i.O(intent);
            if (!StringUtils.isNull(this.cjD)) {
                intent.putExtra("name", this.cjD);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.cjK = getVoiceManager();
        if (this.cjK != null) {
            this.cjK.onStart(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        Intent intent;
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.ckM);
        if (bundle != null) {
            this.cjD = bundle.getString("name");
            this.ajv = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
            this.cjD = intent.getStringExtra("name");
            this.ajv = intent.getStringExtra("from");
            this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
        }
        if (TextUtils.isEmpty(this.ajv) || FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.ajv)) {
        }
        if (this.mIsLogin) {
            registerListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL, this.ckM);
        }
        this.cjV.i(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.ckP);
        if (this.cjK != null) {
            this.cjK.onDestory(getPageContext());
        }
        this.cjK = null;
        com.baidu.tieba.card.u.WU().dF(false);
        if (this.cjo != null && this.cjo.aPJ() != null) {
            ac.agw().bi(com.baidu.adp.lib.g.b.d(this.cjo.aPJ().getId(), 0L));
        }
        if (this.cjL != null) {
            com.baidu.tieba.frs.f.h.a(this.cjL, this.cjo, getForumId(), false, null);
            this.cjL.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.cjR != null) {
                this.cjR.onDestroy();
            }
            this.cjL.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.cjU.onActivityDestroy();
        this.cjV.onActivityDestroy();
        if (this.cjS != null) {
            this.cjS.cancel(true);
            this.cjS = null;
        }
        if (this.cjU != null) {
            this.cjU.Ox();
        }
        if (this.ckb != null) {
            this.ckb.Ho();
        }
        if (this.cke != null) {
            this.cke.destory();
        }
        if (this.ckf != null) {
            this.ckf.destory();
        }
        if (this.cjZ != null) {
            this.cjZ.onDestroy();
        }
        if (this.ckq != null) {
            this.ckq.onDestory();
        }
        com.baidu.tieba.recapp.d.a.biJ().biL();
        com.baidu.tieba.frs.f.j.ajG();
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.cjD);
        bundle.putString("from", this.ajv);
        this.cjU.onSaveInstanceState(bundle);
        if (this.cjK != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            this.cjK.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.ckj != null) {
            this.ckj.onActivityResult(i, i2, intent);
        }
    }

    public void a(UpdateAttentionMessage updateAttentionMessage) {
        Message<?> message;
        if (updateAttentionMessage != null && updateAttentionMessage.isAttention() && updateAttentionMessage.isGod() && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(getUniqueId())) {
            if (this.cke == null) {
                this.cke = new com.baidu.tbadk.i.a(getPageContext());
            }
            this.cke.an(updateAttentionMessage.getData().toUid, getForumId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.cjL != null) {
            this.cjL.afY();
            this.cjL.onResume();
        }
        this.cjW.a(this.ckw);
        this.cjX.fb(true);
        this.cjT = true;
        if (isNeedRefreshOnResume) {
            isNeedRefreshOnResume = false;
            this.cjL.startPullRefresh();
        } else if (cjA) {
            cjA = false;
            this.cjL.startPullRefresh();
        } else {
            if (this.cjK != null) {
                this.cjK.onResume(getPageContext());
            }
            this.cjL.eL(false);
            registerListener(this.ckI);
            if (this.ckr) {
                cm(6);
                this.ckr = false;
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
        this.ckn = intent;
    }

    public boolean afy() {
        if (getActivity() == null) {
            return false;
        }
        Intent intent = this.ckn != null ? this.ckn : getActivity().getIntent();
        if (intent != null) {
            return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
        }
        return false;
    }

    public void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.cjD = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.ajv = intent.getStringExtra("from");
            }
            this.cjF = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.cjF) {
                afz();
            }
            if (this.ajv != null && this.ajv.equals("from_tieba_kuang")) {
                KuangFloatingViewController.getInstance().setNeedShowFloatingView(true);
                KuangFloatingViewController.getInstance().showFloatingView();
            }
        }
    }

    private void afz() {
        this.cjL.startPullRefresh();
    }

    public void closeActivity() {
        com.baidu.tieba.frs.f.i.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.ajv);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.cjL.setTitle(this.cjD);
        } else {
            this.cjL.setTitle("");
            this.mFlag = 1;
        }
        this.cjV.d(this.cjL.getListView());
        this.cjL.setOnAdapterItemClickListener(this.ckN);
        this.cjL.setOnScrollListener(this.ckK);
        this.cjL.c(this.bFF);
        this.cjL.agi().a(this.ckL);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cjL.onChangeSkinType(i);
        this.cjV.jE(i);
        this.cjW.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.d.c
    public void ly() {
    }

    @Override // com.baidu.adp.widget.d.c
    public void lz() {
    }

    public void iE(int i) {
        if (!this.mIsLogin) {
            if (this.cjo != null && this.cjo.qs() != null) {
                this.cjo.qs().setIfpost(1);
            }
            if (i == 0) {
                aw.aN(getActivity());
            }
        } else if (this.cjo != null) {
            if (i == 0) {
                if (!this.cjB) {
                    com.baidu.tieba.frs.f.j.b(this, 0);
                    return;
                }
                TiebaStatic.log("c10152");
                com.baidu.tieba.frs.f.j.b(this, 4);
                return;
            }
            this.cjL.aga();
        }
    }

    public void refresh() {
        cm(3);
    }

    public void cm(int i) {
        this.cjP = false;
        afE();
        if (this.cjL.afQ() != null) {
            this.cjL.afQ().aqz();
        }
        this.cjU.r(i, true);
    }

    private void afA() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.g.h.gb().f(new Runnable() { // from class: com.baidu.tieba.frs.f.10
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.sm(f.this.cjD);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afB() {
        afE();
        try {
            if (this.cjo != null) {
                this.cjL.Nr();
                this.cjL.eH(this.cjU.aja());
                if (com.baidu.tieba.frs.g.f.i(this.cjo) && !com.baidu.tieba.frs.g.f.h(this.cjo)) {
                    this.cjL.agl();
                }
                if (this.cjo.aPJ() != null) {
                    this.cjD = this.cjo.aPJ().getName();
                    this.forumId = this.cjo.aPJ().getId();
                }
                if (this.cjo.qI() != null) {
                    setHasMore(this.cjo.qI().qE());
                }
                this.cjL.setTitle(this.cjD);
                this.cjL.setForumName(this.cjD);
                TbadkCoreApplication.getInst().setDefaultBubble(this.cjo.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.cjo.getUserData().getBimg_end_time());
                afA();
                afC();
                ArrayList<com.baidu.adp.widget.ListView.f> threadList = this.cjo.getThreadList();
                if (threadList != null) {
                    this.cjL.a(threadList, this.cjo);
                    com.baidu.tieba.frs.f.c.j(this.cjL);
                    this.cjV.jF(getPageNum());
                    this.cjV.f(this.cjo);
                    this.cjW.a(this.cjL.getListView(), this.cjo, this.cjU.ajf());
                    this.cjL.agb();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void afC() {
        if (this.cjo != null) {
            if (this.cjo.aPX() == 1) {
                this.cjL.agi().setFromCDN(true);
            } else {
                this.cjL.agi().setFromCDN(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.cjX.fb(false);
        this.cjT = false;
        this.cjL.onPause();
        if (this.cjK != null) {
            this.cjK.onPause(getPageContext());
        }
        this.cjL.eL(true);
        if (this.ckf != null) {
            this.ckf.ajJ();
        }
        MessageManager.getInstance().unRegisterListener(this.ckI);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.u.WU().dF(false);
        if (this.cjo != null && this.cjo.aPJ() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            com.baidu.tbadk.distribute.a.CK().a(getPageContext().getPageActivity(), "frs", this.cjo.aPJ().getId(), 0L);
        }
        if (this.cjK != null) {
            this.cjK.onStop(getPageContext());
        }
        com.baidu.tieba.frs.f.i.c(getListView());
        this.cjV.onActivityStop();
        s.Hs();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || this.cjL == null) {
            return false;
        }
        return this.cjL.afX();
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
    public void afD() {
        afk().afD();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.cjK == null) {
            this.cjK = VoiceManager.instance();
        }
        return this.cjK;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public BdListView getListView() {
        if (this.cjL == null) {
            return null;
        }
        return this.cjL.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void afE() {
        if (this.cjK != null) {
            this.cjK.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> xn() {
        if (this.apB == null) {
            this.apB = UserIconBox.j(getPageContext().getPageActivity(), 8);
        }
        return this.apB;
    }

    public void afF() {
        if (getFragmentActivity() != null && getFragmentActivity().getCurrentFocus() != null) {
            com.baidu.adp.lib.util.k.b(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.g onGetPreLoadListView() {
        return getListView();
    }

    @Override // com.baidu.tieba.frs.aj
    public NavigationBar afG() {
        if (this.cjL == null) {
            return null;
        }
        return this.cjL.afG();
    }

    /* loaded from: classes.dex */
    private final class a implements com.baidu.adp.widget.ListView.h {
        private a() {
        }

        @Override // com.baidu.adp.widget.ListView.h
        public void a(View view, com.baidu.adp.widget.ListView.f fVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            boolean z;
            if (bdUniqueId != null) {
                if (bdUniqueId == p.cmg) {
                    if (f.this.cjL != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11752").aa("fid", f.this.forumId).aa("obj_locate", "1"));
                        f.this.cjL.startPullRefresh();
                    }
                } else if (fVar != null && (fVar instanceof bl)) {
                    bl blVar = (bl) fVar;
                    if (blVar.sr() == null || blVar.sr().getGroup_id() == 0 || aw.aO(f.this.getActivity())) {
                        if ((blVar.sk() != 1 && blVar.sk() != 2) || aw.aO(f.this.getActivity())) {
                            if (blVar.rT() != null) {
                                if (aw.aO(f.this.getActivity())) {
                                    String postUrl = blVar.rT().getPostUrl();
                                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.k.hI()) {
                                        com.baidu.tbadk.browser.a.U(f.this.getActivity(), postUrl);
                                    }
                                }
                            } else if (blVar.sC() != null) {
                                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                    aw.aN(f.this.getPageContext().getPageActivity());
                                    return;
                                }
                                com.baidu.tbadk.core.data.n sC = blVar.sC();
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(f.this.getPageContext().getPageActivity(), sC.getCartoonId(), sC.getChapterId(), 2)));
                            } else if (blVar.getThreadType() == 47 && blVar.rB() == 1 && !com.baidu.tbadk.core.util.al.isEmpty(blVar.rN())) {
                                com.baidu.tbadk.browser.a.T(f.this.getPageContext().getPageActivity(), blVar.rN());
                            } else {
                                com.baidu.tieba.tbadkCore.util.f readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                                if (readThreadHistory != null && !readThreadHistory.ss(blVar.getId())) {
                                    readThreadHistory.sr(blVar.getId());
                                }
                                final String rN = blVar.rN();
                                if (rN == null || rN.equals("")) {
                                    z = false;
                                } else {
                                    new Thread(new Runnable() { // from class: com.baidu.tieba.frs.f.a.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            com.baidu.tbadk.core.util.w wVar = new com.baidu.tbadk.core.util.w(rN);
                                            wVar.vm().wi().mIsNeedAddCommenParam = false;
                                            wVar.vm().wi().mIsUseCurrentBDUSS = false;
                                            wVar.ug();
                                        }
                                    }).start();
                                    z = true;
                                }
                                String tid = blVar.getTid();
                                if (tid == null) {
                                    tid = "";
                                }
                                if (blVar.rB() == 2 && !tid.startsWith("pb:")) {
                                    com.baidu.tbadk.core.util.at.wg().c(f.this.getPageContext(), new String[]{tid, "", null});
                                } else if (blVar.getThreadType() == 33 || (blVar instanceof ay)) {
                                    String str = blVar.getThreadType() == 33 ? "c10245" : "c10180";
                                    if (f.this.cjU.aiZ() == 5) {
                                        str = "c10387";
                                    }
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.aj(str).aa("fid", f.this.forumId));
                                    com.baidu.tieba.frs.f.i.c(f.this, blVar);
                                    if (f.this.cjo != null && f.this.cjo.aPJ() != null) {
                                        com.baidu.tieba.frs.e.a aVar = new com.baidu.tieba.frs.e.a();
                                        aVar.cxE = f.this.cjo.ghi == 1;
                                        aVar.cxG = f.this.cjo.aPJ().getId();
                                        aVar.cxF = f.this.afk().ajf();
                                        com.baidu.tieba.frs.e.b.ajz().a(aVar, blVar, 1);
                                    }
                                } else {
                                    if (tid.startsWith("pb:")) {
                                        blVar.setId(tid.substring(3));
                                    }
                                    if (bdUniqueId.getId() == bl.aao.getId()) {
                                        com.baidu.tieba.frs.f.h.a(blVar.ro());
                                        com.baidu.tieba.frs.f.i.b(f.this, blVar);
                                        return;
                                    }
                                    com.baidu.tieba.frs.f.i.a(f.this, blVar, i, z);
                                    com.baidu.tieba.frs.f.h.a(f.this, f.this.cjo, blVar);
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
            hideNetRefreshView(this.cjL.Wk());
            showLoadingView(this.cjL.Wk(), true);
            this.cjL.eK(false);
            this.cjU.r(3, true);
        }
    }

    public com.baidu.tieba.tbadkCore.i afH() {
        return this.cjo;
    }

    public boolean afI() {
        return this.cjL.afI();
    }

    public void P(Object obj) {
        if (this.cka != null && this.cka.cwB != null) {
            this.cka.cwB.g(obj);
        }
    }

    public void Q(Object obj) {
        if (this.cka != null && this.cka.cwC != null) {
            this.cka.cwC.g(obj);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.k.hI()) {
            this.cjL.XZ();
        } else if (this.cjU.aiZ() == 1) {
            MZ();
            MS();
        } else if (this.cjU.hasMore()) {
            MS();
        }
    }

    public void ko(String str) {
        MZ();
        showToast(str);
    }

    public void G(ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        MZ();
        if (!com.baidu.tbadk.core.util.u.v(arrayList)) {
            if (!this.cjU.ajj() && TbadkCoreApplication.getInst().isRecAppExist() && this.cjU.aiZ() == 1) {
                this.cjo.a(this, arrayList);
            }
            ArrayList<com.baidu.adp.widget.ListView.f> a2 = this.ckh.a(false, false, arrayList, this.cjH);
            if (a2 != null) {
                this.cjo.aB(a2);
                this.cjL.a(a2, this.cjo);
            }
            if (this.cjU != null) {
                com.baidu.tieba.frs.e.b.a(this.cjo, this.cjU.ajf(), 2);
            }
        }
    }

    private void MZ() {
        if (afq() == 1 || this.ckh.aK(this.cjo.bri())) {
            this.cjL.Wq();
        } else if (com.baidu.tbadk.core.util.u.v(this.cjo.getThreadList())) {
            this.cjL.XZ();
        } else {
            this.cjL.Ws();
        }
    }

    @Override // com.baidu.tieba.frs.mc.k
    public void MS() {
        if (this.ckh != null) {
            this.ckh.a(this.cjD, this.forumId, this.cjo);
        }
    }

    public void afJ() {
        if (!com.baidu.tbadk.core.util.aa.d(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.ah.c(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return afK() ? "a034" : "a006";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (!afK()) {
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
        if (this.ckb != null) {
            this.ckb.eP(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.ckc.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a fI(int i) {
        return this.ckc.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        this.ckk.b(bVar);
    }

    public boolean afK() {
        return this.cjz;
    }

    @Override // com.baidu.tieba.frs.ah
    public void afL() {
        if (this.cjL != null) {
            showFloatingView();
            this.cjL.getListView().setSelection(0);
            this.cjL.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public ForumWriteData afM() {
        if (this.cjo == null || this.cjo.aPJ() == null) {
            return null;
        }
        ForumData aPJ = this.cjo.aPJ();
        ForumWriteData forumWriteData = new ForumWriteData(aPJ.getId(), aPJ.getName(), aPJ.getPrefixData(), this.cjo.qs());
        forumWriteData.setForumLevel(aPJ.getUser_level());
        forumWriteData.setAvatar(this.cjo.aPJ().getImage_url());
        return forumWriteData;
    }

    @Override // com.baidu.tieba.frs.ah
    public void xd() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void cH(boolean z) {
        if (this.cjL != null) {
            this.cjL.cH(z);
        }
    }
}
