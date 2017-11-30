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
import com.baidu.tbadk.util.r;
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
/* loaded from: classes.dex */
public class f extends BaseFragment implements BdListView.e, a.InterfaceC0022a, UserIconBox.b, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, ai, ak, am, com.baidu.tieba.frs.mc.j, com.baidu.tieba.recapp.o {
    public static boolean cGR = false;
    public static volatile long cHb = 0;
    public static volatile long cHc = 0;
    public static volatile int cHd = 0;
    private r aNi;
    private com.baidu.adp.lib.e.b<TbImageView> aoO;
    private com.baidu.tieba.frs.gametab.b bsA;
    private com.baidu.tieba.frs.entelechy.b cGO;
    public bd cGS;
    private com.baidu.tieba.tbadkCore.data.e cGW;
    private VoiceManager cGZ;
    private com.baidu.tieba.frs.mc.e cHA;
    private int cHB;
    private View.OnTouchListener cHC;
    private com.baidu.tieba.frs.g.e cHD;
    private boolean cHE;
    private com.baidu.tieba.NEGFeedBack.a cHG;
    private FrsModelController cHi;
    private com.baidu.tieba.frs.g.f cHj;
    private com.baidu.tieba.frs.entelechy.b.d cHk;
    private com.baidu.tieba.frs.mc.f cHl;
    private com.baidu.tieba.frs.smartsort.b cHm;
    private com.baidu.tieba.frs.mc.b cHn;
    private an cHo;
    private com.baidu.tieba.frs.entelechy.b.b cHq;
    private com.baidu.tbadk.h.a cHr;
    private com.baidu.tieba.frs.g.a cHs;
    private com.baidu.tieba.frs.mc.d cHt;
    private com.baidu.tieba.frs.mc.c cHu;
    private com.baidu.tieba.frs.g.h cHv;
    private com.baidu.tieba.frs.mc.a cHw;
    private com.baidu.tieba.frs.live.a cHx;
    private h cHy;
    public com.baidu.tieba.frs.g.c cHz;
    public View mRootView;
    public boolean cGP = false;
    private boolean cGQ = false;
    public String cGT = null;
    public String mFrom = null;
    public int mFlag = 0;
    private boolean cGU = false;
    private String mThreadId = null;
    public String forumId = null;
    private int cGI = 0;
    private boolean cGV = false;
    private boolean cGX = false;
    private boolean cGY = false;
    private i cHa = null;
    public final bd bkp = null;
    private com.baidu.tieba.tbadkCore.k cGG = new com.baidu.tieba.tbadkCore.k();
    public long ctl = -1;
    public long aKs = 0;
    public long aKk = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean cHe = false;
    private boolean cHf = false;
    public com.baidu.tbadk.k.d cHg = null;
    private boolean cHh = true;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> cHp = new SparseArray<>();
    private boolean btK = true;
    private boolean cHF = false;
    private final CustomMessageListener cHH = new CustomMessageListener(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED) { // from class: com.baidu.tieba.frs.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof bd) {
                    com.baidu.tieba.frs.f.g.a(f.this.cHa, f.this.cGG, f.this.getForumId(), true, (bd) data);
                }
            }
        }
    };
    private CustomMessageListener cHI = new CustomMessageListener(CmdConfigCustom.CMD_CLOSE_GAME_RANK_CARD) { // from class: com.baidu.tieba.frs.f.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (f.this.cGG != null) {
                f.this.cGG.bvp();
                if (f.this.cHa != null) {
                    f.this.cHa.acW();
                }
            }
        }
    };
    private final al cHJ = new al() { // from class: com.baidu.tieba.frs.f.23
        @Override // com.baidu.tieba.frs.al
        public void a(int i, int i2, ar arVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
            f.this.alh();
            if (f.this.cHq != null) {
                f.this.cHj.fB(f.this.cHq.kd(i));
            }
            d.a aVar = new d.a();
            if (arVar != null) {
                aVar.isSuccess = arVar.errCode == 0;
                aVar.errorCode = arVar.errCode;
                aVar.errorMsg = arVar.errMsg;
                if (aVar.isSuccess) {
                    if (com.baidu.tbadk.core.util.v.w(arrayList)) {
                        f.this.cHa.acX();
                    } else if (arVar.hasMore) {
                        if (com.baidu.tbadk.core.util.v.v(f.this.cGG.getThreadList()) > 3) {
                            f.this.cHa.alY();
                        } else {
                            f.this.cHa.ama();
                        }
                    } else if (arVar.cKq) {
                        f.this.cHa.alZ();
                    } else {
                        f.this.cHa.acX();
                    }
                }
            } else {
                arVar = new ar();
                arVar.pn = 1;
                arVar.hasMore = false;
                arVar.cKq = false;
            }
            if (i == 1) {
                f.this.cHh = true;
                f.this.cHT.a(f.this.cHi.getType(), false, aVar);
            } else {
                f.this.a(aVar);
                if (f.this.cHi.aoz() != null) {
                    f.this.cGG = f.this.cHi.aoz();
                }
                f.this.alp();
            }
            if (f.this.cId != null) {
                f.this.cId.a(i, i2, arVar, arrayList);
            }
        }
    };
    private aj cHK = new aj() { // from class: com.baidu.tieba.frs.f.24
        @Override // com.baidu.tieba.frs.aj
        public void a(al alVar) {
        }

        @Override // com.baidu.tieba.frs.aj
        public void a(int i, int i2, ao aoVar) {
            if (i != 1) {
                s.abU().dT(false);
            }
            if (i == 1) {
                f.this.cHa.eU(true);
                f.this.cHa.eT(false);
            } else {
                f.this.cHa.eV(true);
                f.this.cHa.eT(true);
            }
            f.this.als();
            f.this.cHi.a(i, i2, aoVar);
        }

        @Override // com.baidu.tieba.frs.aj
        public void init() {
        }

        @Override // com.baidu.tieba.frs.aj
        public void QJ() {
        }
    };
    private CustomMessageListener cHL = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIVE_COUNT) { // from class: com.baidu.tieba.frs.f.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                ((com.baidu.tieba.frs.entelechy.c.a) f.this.cHk).kf(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    };
    private CustomMessageListener cHM = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_LIVE_START) { // from class: com.baidu.tieba.frs.f.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && ((Integer) customResponsedMessage.getData()).intValue() == 51 && f.this.cGG != null) {
                com.baidu.tieba.frs.f.i.a(f.this.cGG, f.this.getPageContext());
            }
        }
    };
    private final CustomMessageListener cHN = new CustomMessageListener(CmdConfigCustom.CMD_FRS_SELECT_ALA_LIVE_TAB) { // from class: com.baidu.tieba.frs.f.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (f.this.cHk instanceof com.baidu.tieba.frs.entelechy.c.a) && ((com.baidu.tieba.frs.entelechy.c.a) f.this.cHk).anP() != null) {
                ((com.baidu.tieba.frs.entelechy.c.a) f.this.cHk).anP().kO(49);
            }
        }
    };
    private final CustomMessageListener cHO = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.frs.f.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && f.this.cGG != null && f.this.cGG.aRf() != null) {
                SignData signData = (SignData) customResponsedMessage.getData();
                int user_level = f.this.cGG.aRf().getUser_level();
                if (signData.forumId != null && signData.forumId.equals(f.this.cGG.aRf().getId())) {
                    f.this.cGG.d(signData);
                    f.this.cHj.g(f.this.cGG);
                    if (f.this.cHj.aqO()) {
                        i = f.this.cGG.aRf().getUser_level();
                        if (user_level >= i) {
                            i++;
                        }
                    } else {
                        i = user_level;
                    }
                    TbadkCoreApplication.getInst().addSignedForum(f.this.cGG.aRf().getName(), signData.sign_bonus_point, i);
                }
            }
        }
    };
    private final CustomMessageListener cHP = new CustomMessageListener(CmdConfigCustom.CMD_FRS_EXPERIENCE_TIP) { // from class: com.baidu.tieba.frs.f.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.q) && f.this.cGG != null) {
                f.this.cGG.c((com.baidu.tieba.tbadkCore.q) customResponsedMessage.getData());
                f.this.cHj.f(f.this.cGG);
                f.this.cHk.a(f.this.cHa.getListView(), f.this.cGG, f.this.cHi.apS());
            }
        }
    };
    private final AntiHelper.a cHQ = new AntiHelper.a() { // from class: com.baidu.tieba.frs.f.2
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12536").r("obj_locate", ap.a.ahS));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12535").r("obj_locate", ap.a.ahS));
        }
    };
    private CustomMessageListener bpO = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.f.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(f.this.xQ().getUniqueId())) {
                    if (updateAttentionMessage.getData().ask != null) {
                        if (AntiHelper.a(f.this.getActivity(), updateAttentionMessage.getData().ask, f.this.cHQ) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12534").r("obj_locate", ap.a.ahS));
                        }
                    } else if (updateAttentionMessage.getData().BJ && updateAttentionMessage.getData().isAttention) {
                        com.baidu.adp.lib.util.l.showToast(f.this.xQ().getPageActivity(), d.j.attention_success);
                    }
                }
            }
        }
    };
    private CustomMessageListener cHR = new CustomMessageListener(CmdConfigCustom.CMD_STORY_READ_CACHE) { // from class: com.baidu.tieba.frs.f.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.story.process.b)) {
                com.baidu.tieba.story.process.b bVar = (com.baidu.tieba.story.process.b) customResponsedMessage.getData();
                if (f.this.forumId != null && f.this.forumId.equals(String.valueOf(bVar.forumId)) && bVar.state == 3 && f.this.alv() != null && !com.baidu.tbadk.core.util.v.w(f.this.alv().bui()) && f.this.cGO.ana() != null && f.this.cGO.ana().anp() != null) {
                    List<com.baidu.adp.widget.ListView.f> bui = f.this.alv().bui();
                    int size = bui.size();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= size) {
                            i = -1;
                            break;
                        } else if ((bui.get(i2) instanceof com.baidu.tbadk.data.g) && TbadkCoreApplication.getCurrentAccount().equals(String.valueOf(((com.baidu.tbadk.data.g) bui.get(i2)).user_id))) {
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
                    gVar.aAn = String.valueOf(f.this.forumId);
                    gVar.aAm = bVar;
                    if (i != -1) {
                        bui.set(i, gVar);
                    } else {
                        bui.add(1, gVar);
                    }
                    f.this.cGO.ana().anp().b(bui, f.this.forumId, f.this.getThreadId());
                }
            }
        }
    };
    private CustomMessageListener cHS = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.frs.f.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                f.this.cHa.c((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.m cHT = new com.baidu.tieba.tbadkCore.m() { // from class: com.baidu.tieba.frs.f.6
        private long startTime = 0;

        @Override // com.baidu.tieba.tbadkCore.m
        public void jN(int i) {
            this.startTime = System.nanoTime();
            if (f.this.cHa != null) {
                switch (i) {
                    case 1:
                    case 2:
                        f.this.cHa.alL();
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
            if (f.this.btK) {
                f.this.btK = false;
                com.baidu.tieba.frs.f.g.a(f.this.cHa, f.this.cGG, f.this.getForumId(), false, null);
            }
            f.this.alh();
            f.this.cHe = true;
            if (aVar != null && aVar.isSuccess) {
                f.this.cHa.alV().fi(com.baidu.tbadk.core.util.an.vv().vx());
                f.cHb = 0L;
                f.cHc = 0L;
                f.cHd = 0;
            } else {
                f.cHd = 1;
            }
            if (!f.this.cHi.apW() && (i == 3 || i == 6)) {
                f.this.cHu.resetData();
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (f.this.cHi.aoz() != null) {
                f.this.cGG = f.this.cHi.aoz();
            }
            if (i == 7) {
                f.this.jL(f.this.cGG.buH());
                return;
            }
            if (f.this.cGG.qA() != null) {
                f.this.setHasMore(f.this.cGG.qA().qw());
            }
            f.this.ali();
            if (i == 4) {
                if (!f.this.cHi.apW() && TbadkCoreApplication.getInst().isRecAppExist() && f.this.cHi.apM() == 1) {
                    f.this.cGG.a(f.this);
                }
                ArrayList<com.baidu.adp.widget.ListView.f> a2 = f.this.cHu.a(false, false, f.this.cGG.getThreadList(), f.this.cGW);
                if (a2 != null) {
                    f.this.cGG.az(a2);
                    f.this.cGG.bvg();
                    f.this.cHa.a(a2, f.this.cGG);
                }
                if (f.this.cHi != null) {
                    com.baidu.tieba.frs.e.b.a(f.this.cGG, f.this.cHi.apS(), 2);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    f.this.cHa.alL();
                    break;
                case 2:
                    f.this.cHa.alL();
                    break;
                case 3:
                case 6:
                    if (f.this.cGG != null) {
                        f.this.cGG.bve();
                    }
                    if (f.this.cHz != null) {
                        f.this.cHz.refresh();
                        break;
                    }
                    break;
            }
            f.this.alj();
            if (aVar == null || aVar.errorCode == 0) {
                if (f.this.cGG != null) {
                    f.this.cHa.jP(i);
                    f.this.u(false, i == 5);
                    f.cHb = (System.nanoTime() - this.startTime) / 1000000;
                    if (aVar != null) {
                        f.cHc = aVar.gvZ;
                    }
                } else {
                    return;
                }
            } else if (f.this.cGG == null || com.baidu.tbadk.core.util.v.w(f.this.cGG.getThreadList())) {
                f.this.a(aVar);
            } else if (aVar.gvY) {
                f.this.showToast(f.this.getPageContext().getResources().getString(d.j.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
            }
            if (f.this.cGG.bun() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11384"));
            }
            if (f.this.ctl > -1 && !f.this.cHF) {
                com.baidu.tieba.frs.f.g.a(f.this.cHi, f.this.ctl);
                f.this.ctl = -1L;
                f.this.cHF = true;
            }
            if (f.this.cGX && (f.this.cHk instanceof com.baidu.tieba.frs.entelechy.c.a) && ((com.baidu.tieba.frs.entelechy.c.a) f.this.cHk).anP() != null) {
                ((com.baidu.tieba.frs.entelechy.c.a) f.this.cHk).anP().kO(49);
                f.this.cGX = false;
            }
            f.this.aKs = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.m
        public void b(com.baidu.tieba.tbadkCore.h hVar) {
            if (hVar != null) {
                if ("normal_page".equals(f.this.cHi.apI()) || "frs_page".equals(f.this.cHi.apI()) || "book_page".equals(f.this.cHi.apI())) {
                    f.this.a(hVar);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE, hVar));
                }
            }
        }
    };
    private final CustomMessageListener cHU = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.frs.f.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.k) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                f.this.cGG.a((com.baidu.tbadk.data.k) customResponsedMessage.getData());
                f.this.cHa.alV().notifyDataSetChanged();
            }
        }
    };
    private final CustomMessageListener mMemListener = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_MEM) { // from class: com.baidu.tieba.frs.f.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && f.this.cGG != null && (userData = f.this.cGG.getUserData()) != null) {
                userData.setIsMem(num.intValue());
                if (num.intValue() != 0) {
                    f.this.cHj.f(num);
                }
            }
        }
    };
    private final com.baidu.tieba.frs.mc.i cHV = new com.baidu.tieba.frs.mc.i() { // from class: com.baidu.tieba.frs.f.10
        @Override // com.baidu.tieba.frs.mc.i
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.f> arrayList, boolean z3) {
            if (f.this.cHm != null && f.this.cHi != null && f.this.cHi.apW() && z && !z2 && !z3) {
                f.this.cHm.kI(i2);
            }
        }
    };
    public final View.OnTouchListener aNj = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.f.11
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (f.this.cHC != null) {
                f.this.cHC.onTouch(view, motionEvent);
            }
            if (f.this.cHo != null && f.this.cHo.amu() != null) {
                f.this.cHo.amu().onTouchEvent(motionEvent);
            }
            if (f.this.bsA != null) {
                f.this.bsA.d(view, motionEvent);
            }
            if (f.this.cHj != null) {
                f.this.cHj.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private final CustomMessageListener cHW = new CustomMessageListener(CmdConfigCustom.CMD_GOTOLIVE_HOST_UPGRADE) { // from class: com.baidu.tieba.frs.f.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "photolive_hostLevel", -1) != -1 && f.this.cGG.aRf() != null) {
                f.this.cGG.aRf().setCanAddPhotoLivePost(true);
            }
        }
    };
    private final CustomMessageListener cHX = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.frs.f.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11455").ac("obj_locate", "frs"));
                    com.baidu.tbadk.core.util.av.vL().c(f.this.getPageContext(), new String[]{str});
                }
            }
        }
    };
    public final View.OnClickListener cHY = new View.OnClickListener() { // from class: com.baidu.tieba.frs.f.16
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (f.this.cHa == null || view != f.this.cHa.alJ() || f.this.getActivity() == null) {
                if (f.this.cGG != null && f.this.cGG.aRf() != null) {
                    if (f.this.cHa == null || view != f.this.cHa.alP()) {
                        if (f.this.cHa != null && view == f.this.cHa.alQ()) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12402").ac(ImageViewerConfig.FORUM_ID, f.this.cGG.aRf().getId()).ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()).ac(ImageViewerConfig.FORUM_NAME, f.this.cGG.aRf().getName()));
                            if (!StringUtils.isNull(f.this.cGG.aRf().getName())) {
                                f.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PostSearchActivityConfig(f.this.getPageContext().getPageActivity(), f.this.cGG.aRf().getName(), f.this.cGG.aRf().getId())));
                                return;
                            }
                            return;
                        }
                    } else if (!StringUtils.isNull(f.this.cGG.aRf().getId())) {
                        if (f.this.cGG.aRf() != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12046").ac(ImageViewerConfig.FORUM_ID, f.this.cGG.aRf().getId()).r("obj_locate", f.this.aly() ? 1 : 2));
                        }
                        f.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(f.this.getPageContext().getPageActivity(), f.this.cGG.aRf().getId(), ForumDetailActivityConfig.FromType.FRS)));
                        return;
                    } else {
                        return;
                    }
                }
                if (view.getId() == d.g.game_activity_egg_layout && com.baidu.adp.lib.util.l.hy()) {
                    TiebaStatic.log("c10853");
                    if (f.this.cHa.alS()) {
                        f.this.cHa.alT();
                    } else {
                        String activityUrl = f.this.cGG.aRf().getYuleData().td().getActivityUrl();
                        if (!StringUtils.isNull(activityUrl)) {
                            com.baidu.tbadk.browser.a.Q(f.this.getPageContext().getPageActivity(), activityUrl);
                        }
                    }
                }
                if (view == f.this.cHa.amb() && f.this.cHi != null && f.this.cHi.hasMore()) {
                    f.this.cHa.alY();
                    f.this.OI();
                    return;
                }
                return;
            }
            f.this.getActivity().finish();
        }
    };
    private final AbsListView.OnScrollListener cHZ = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.f.17
        private int cIg = 0;
        private int bjU = 0;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (f.this.aNi != null && f.this.isPrimary()) {
                f.this.aNi.a(absListView, this.cIg, i, i2, i3);
            }
            if (f.this.cHk != null) {
                f.this.cHk.a(absListView, i, i2, i3, f.this.cHj.aqS());
            }
            if (f.this.cHs != null) {
                f.this.cHs.aqx();
            }
            if (f.this.cHm != null) {
                f.this.cHm.aqh();
            }
            if (f.this.cHD != null) {
                f.this.cHD.onScroll(absListView, i, i2, i3);
            }
            if (f.this.cGG != null && f.this.cHa != null && f.this.cHa.alV() != null) {
                this.cIg = i;
                this.bjU = (i + i2) - 1;
                f.this.cHa.ay(this.cIg, this.bjU);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (f.this.cHj != null) {
                f.this.cHj.setScrollState(i);
            }
            if (f.this.aNi != null && f.this.isPrimary()) {
                f.this.aNi.onScrollStateChanged(absListView, i);
            }
            if ((i == 2 || i == 1) && !f.this.cHf) {
                f.this.cHf = true;
                f.this.cHa.alX();
            }
            if (f.this.cHg == null && !f.this.aly()) {
                f.this.cHg = new com.baidu.tbadk.k.d();
                f.this.cHg.fr(1000);
            }
            if (i == 0) {
                s.abU().dT(true);
                f.this.cHa.ax(this.cIg, this.bjU);
            }
            if (f.this.cHD != null) {
                f.this.cHD.onScrollStateChanged(absListView, i);
            }
            if (f.this.cHg != null) {
                f.this.cHg.Gh();
            }
            if (i == 0) {
                com.baidu.tieba.frs.f.g.a(f.this.cHa, f.this.cGG, f.this.getForumId(), false, null);
            }
        }
    };
    private final b cIa = new b() { // from class: com.baidu.tieba.frs.f.18
        @Override // com.baidu.tieba.frs.b
        public void a(int i, int i2, View view, View view2, bd bdVar) {
            if (i != f.this.cHa.alV().anw()) {
                if (i != f.this.cHa.alV().anx()) {
                    if (i != f.this.cHa.alV().anz()) {
                        if (i != f.this.cHa.alV().amk()) {
                            if (i == f.this.cHa.alV().any() && f.this.cGG != null && f.this.cGG.getUserData() != null && f.this.cGG.getUserData().isBawu()) {
                                final String buF = f.this.cGG.buF();
                                if (!com.baidu.tbadk.core.util.am.isEmpty(buF) && f.this.cGG.aRf() != null) {
                                    com.baidu.tieba.c.a.a(f.this.getPageContext(), f.this.cGG.aRf().getId(), f.this.cGG.aRf().getName(), new a.InterfaceC0079a() { // from class: com.baidu.tieba.frs.f.18.1
                                        @Override // com.baidu.tieba.c.a.InterfaceC0079a
                                        public void abq() {
                                            com.baidu.tbadk.browser.a.P(f.this.getPageContext().getPageActivity(), buF);
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10502").ac(ImageViewerConfig.FORUM_ID, f.this.cGG.aRf().getId()).ac(SapiAccountManager.SESSION_UID, f.this.cGG.getUserData().getUserId()));
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        f.this.cGS = bdVar;
                        com.baidu.tieba.frs.f.h.a(f.this, f.this.cGS);
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10179").ac(ImageViewerConfig.FORUM_ID, f.this.getForumId()));
                        return;
                    }
                    com.baidu.tieba.frs.f.h.B(f.this);
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak(i == f.this.cHa.alV().anz() ? "c10177" : "c10244").ac(ImageViewerConfig.FORUM_ID, f.this.getForumId()));
                } else if (ax.aV(f.this.getPageContext().getPageActivity())) {
                    TiebaStatic.log("my_service_ck");
                    if (f.this.cGG != null && f.this.cGG.aRf() != null) {
                        ForumData aRf = f.this.cGG.aRf();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(f.this.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(aRf.getId(), 0L), aRf.getName(), aRf.getImage_url(), 0)));
                    }
                }
            } else if (ax.aV(f.this.getActivity())) {
                TiebaStatic.log("forum_fortune_click");
                com.baidu.tieba.frs.f.h.a(f.this.getPageContext(), f.this.cGG);
            }
        }
    };
    private final NoNetworkView.a cFo = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.f.19
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aJ(boolean z) {
            if (f.this.cHi.apM() == 1 && z && !f.this.cHa.alw()) {
                if (f.this.cGG == null || com.baidu.tbadk.core.util.v.w(f.this.cGG.getThreadList())) {
                    f.this.hideNetRefreshView(f.this.cHa.WP());
                    f.this.showLoadingView(f.this.cHa.WP(), true);
                    f.this.cHa.eV(false);
                    f.this.refresh();
                    return;
                }
                f.this.cHa.alL();
            }
        }
    };
    private final CustomMessageListener cIb = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.f.20
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                com.baidu.tieba.frs.f.c.a(customResponsedMessage, f.this.cHa, f.this.cGG);
            }
        }
    };
    private com.baidu.adp.widget.ListView.h cIc = new a();
    private al cId = new al() { // from class: com.baidu.tieba.frs.f.21
        @Override // com.baidu.tieba.frs.al
        public void a(int i, int i2, ar arVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
            com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tieba.frs.f.21.1
                @Override // java.lang.Runnable
                public void run() {
                    if (f.this.cHa != null && f.this.cHa.acN()) {
                        f.this.OI();
                    }
                }
            });
        }
    };
    private CustomMessageListener cIe = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.frs.f.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    f.this.cHE = true;
                }
            }
        }
    };

    public com.baidu.tieba.frs.entelechy.b.b akV() {
        return this.cHq;
    }

    public com.baidu.adp.widget.ListView.h akW() {
        return this.cIc;
    }

    public com.baidu.tieba.frs.mc.d akX() {
        return this.cHt;
    }

    public com.baidu.tieba.frs.smartsort.b akY() {
        return this.cHm;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public FrsModelController akZ() {
        return this.cHi;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public com.baidu.tieba.frs.mc.c ala() {
        return this.cHu;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public com.baidu.tieba.frs.g.f alb() {
        return this.cHj;
    }

    public com.baidu.tieba.frs.entelechy.b.d alc() {
        return this.cHk;
    }

    public an ald() {
        return this.cHo;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public i ale() {
        return this.cHa;
    }

    @Override // com.baidu.tieba.frs.am
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.am
    public String getForumName() {
        return this.cGT;
    }

    public void setForumName(String str) {
        this.cGT = str;
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
        if (this.cHu == null) {
            return 1;
        }
        return this.cHu.getPn();
    }

    public int getPn() {
        if (this.cHu == null) {
            return 1;
        }
        return this.cHu.getPn();
    }

    public void setPn(int i) {
        if (this.cHu != null) {
            this.cHu.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.cHu != null) {
            this.cHu.setHasMore(i);
        }
    }

    public int alf() {
        if (this.cHu == null) {
            return -1;
        }
        return this.cHu.alf();
    }

    public boolean alg() {
        return this.cGY;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d.a aVar) {
        if (aVar == null) {
            String string = TbadkCoreApplication.getInst().getString(d.j.error_unkown_try_again);
            this.cHa.alG();
            showNetRefreshView(this.cHa.WP(), string, true);
        } else if (340001 == aVar.errorCode) {
            b(aVar);
        } else {
            if (com.baidu.tbadk.core.util.v.w(this.cGG.getThreadList())) {
                c(aVar);
            }
            if (aly()) {
                setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst(), d.e.ds280));
            } else {
                setNetRefreshViewEmotionDefMarginTop();
            }
        }
    }

    private void b(d.a aVar) {
        this.cHa.alG();
        if (aVar.gvY) {
            showNetRefreshViewNoClick(this.cHa.WP(), TbadkCoreApplication.getInst().getString(d.j.net_error_text, new Object[]{aVar.errorMsg, Integer.valueOf(aVar.errorCode)}), true);
        } else {
            showNetRefreshViewNoClick(this.cHa.WP(), aVar.errorMsg, true);
        }
    }

    private void c(d.a aVar) {
        this.cHa.alG();
        if (aVar.gvY) {
            showNetRefreshView(this.cHa.WP(), TbadkCoreApplication.getInst().getString(d.j.net_error_text, new Object[]{aVar.errorMsg, Integer.valueOf(aVar.errorCode)}), true);
        } else {
            showNetRefreshView(this.cHa.WP(), aVar.errorMsg, true);
        }
    }

    public void alh() {
        hideLoadingView(this.cHa.WP());
        this.cHa.alR();
        if (this.cHa.alE() instanceof com.baidu.tieba.frs.tab.c) {
            ((com.baidu.tieba.frs.tab.c) this.cHa.alE()).aqr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ali() {
        if (alf() == 0 && com.baidu.tbadk.core.util.v.w(this.cGG.but())) {
            if (com.baidu.tbadk.core.util.v.w(this.cGG.getThreadList())) {
                this.cHa.acX();
            } else {
                this.cHa.alZ();
            }
        } else if (com.baidu.tbadk.core.util.v.v(this.cGG.getThreadList()) > 3) {
            this.cHa.alY();
        } else {
            this.cHa.ama();
        }
    }

    public void a(ErrorData errorData) {
        alh();
        this.cHa.alL();
        d.a apJ = this.cHi.apJ();
        boolean w = com.baidu.tbadk.core.util.v.w(this.cGG.getThreadList());
        if (apJ != null && w) {
            if (w) {
                if (this.cHi.apK() != 0) {
                    this.cHi.apQ();
                    this.cHa.alL();
                } else {
                    a(apJ);
                }
                this.cHa.v(this.cGG.bvv(), false);
                return;
            } else if (apJ.gvY) {
                this.cHa.v(true, false);
                showToast(getPageContext().getResources().getString(d.j.net_error_text, apJ.errorMsg, Integer.valueOf(apJ.errorCode)));
                return;
            } else {
                return;
            }
        }
        a(apJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alj() {
        if (this.cGG == null || this.cGG.aRf() != null) {
            this.cHa.alU();
        } else if (this.cGG.aRf().getYuleData() != null && this.cGG.aRf().getYuleData().tc()) {
            TiebaStatic.log("c10852");
            this.cHa.a(this.cGG.aRf().getYuleData().td());
        } else {
            this.cHa.alU();
        }
    }

    private void t(boolean z, boolean z2) {
        if (this.cHi != null && this.cGG != null && this.cHa != null && z) {
            if (!this.cHi.apW() && this.cHi.apM() == 1) {
                if (!this.cHi.apU()) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        this.cGG.bvn();
                        this.cGG.bvi();
                    }
                    this.cGG.bvl();
                    this.cGG.bvm();
                }
                boolean z3 = false;
                if (this.cHa.alV().l(com.baidu.tieba.card.data.p.cdU)) {
                    z3 = this.cGG.bvq();
                }
                if (!z3) {
                    this.cGG.bvo();
                }
                if (TbadkCoreApplication.getInst().isRecAppExist()) {
                    this.cGG.a(this);
                }
                if (!this.cHa.alV().l(bd.YK)) {
                    this.cGG.bvf();
                }
                this.cGG.bvr();
            }
            if (!this.cHa.alV().l(bd.YK)) {
                this.cGG.bvk();
            } else {
                this.cGG.bvj();
            }
            this.cGG.bvg();
            this.cGG.bvd();
            if (this.cHa.alV().l(com.baidu.tieba.g.b.dhf)) {
                this.cGG.mY(z2);
            }
            if (TbadkCoreApplication.isLogin() && (!this.cHi.apW() || this.cHi.isNetFirstLoad)) {
                this.cGG.bvs();
            }
            this.cGG.bvt();
        }
    }

    public boolean alk() {
        if (this.cHk != null && this.cHa != null) {
            this.cHk.b(this.cHa.getListView());
        }
        if (this.cHj != null && this.cHi != null) {
            this.cHj.a(this.cHi.apI(), this.cGG);
        }
        boolean z = false;
        if (this.cGG != null) {
            z = this.cGG.bvw();
        }
        eO(z);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jL(int i) {
        ao aoVar = null;
        alk();
        als();
        try {
            if (this.cGG != null) {
                this.cHa.a((ArrayList<com.baidu.adp.widget.ListView.f>) null, this.cGG);
                this.cHj.kW(1);
                this.cHa.alO();
                this.cHk.a(this.cHa.getListView(), this.cGG, this.cHi.apS());
                com.baidu.tieba.frs.tab.d a2 = a(this.cHk.anI(), this.cGG.buH());
                if (a2 != null && !TextUtils.isEmpty(a2.url)) {
                    aoVar = new ao();
                    aoVar.cKn = a2.url;
                    aoVar.stType = a2.name;
                }
                this.cHi.a(this.cGG.buH(), 0, aoVar);
                this.cHk.fl(false);
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
            if (this.cGG != null && this.cHk != null && this.cHi != null) {
                if (!this.cHa.alV().l(bd.YK)) {
                    this.cGG.bvf();
                }
                boolean w = com.baidu.tbadk.core.util.v.w(this.cGG.buU());
                this.cHa.eS(w);
                if (!w) {
                    if (this.cHD == null) {
                        this.cHD = new com.baidu.tieba.frs.g.e(this, (NoPressedRelativeLayout) this.mRootView);
                    }
                    if (this.bsA == null) {
                        this.bsA = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
                    }
                } else {
                    this.cHD = null;
                    this.bsA = null;
                }
                if (this.cGG.aRf() != null) {
                    this.cGT = this.cGG.aRf().getName();
                    this.forumId = this.cGG.aRf().getId();
                }
                if (this.cGG.bvw()) {
                    this.cHk.a(this.cHa.getListView(), this.cGG, this.cHi.apS());
                }
                if (z) {
                    t(true, z);
                } else {
                    t(this.cHh, z);
                }
                alk();
                if (this.cHq != null) {
                    this.cHq.a(this.cHj, this.cGG);
                }
                if (this.cGG.qA() != null) {
                    setHasMore(this.cGG.qA().qw());
                }
                ArrayList<com.baidu.adp.widget.ListView.f> a2 = this.cHu.a(z2, true, this.cGG.getThreadList(), null, z);
                if (a2 != null) {
                    this.cGG.az(a2);
                }
                if (this.cHi.apM() == 1) {
                    alp();
                    if (!z && this.cHi.getPn() == 1) {
                        all();
                    }
                }
                this.cGI = this.cGG.apO();
                if (this.cGW != null) {
                    this.cGV = true;
                    this.cGW.uh(this.cGI);
                    com.baidu.tieba.frs.f.a.a(this, this.cGG.aRf(), this.cGG.getThreadList(), this.cGV, getPn());
                }
                if (this.cHs != null) {
                    this.cHs.aC(this.cHk.anJ());
                }
                alh();
                this.cHa.alH();
                this.cHa.v(true, false);
                if (this.cGG != null && this.cGG.buX() != null && com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("frs_video_activity_guide", 0L) == 0) {
                    com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.f.7
                        @Override // java.lang.Runnable
                        public void run() {
                            f.this.cHa.amf();
                        }
                    }, 1000L);
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void all() {
        if (this.cHx == null) {
            this.cHx = new com.baidu.tieba.frs.live.a(this, com.baidu.adp.lib.g.b.g(this.forumId, 0));
        }
        this.cHx.apu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.h hVar) {
        try {
            if (!this.cHe && hVar != null && this.cGG != null) {
                this.cGG.e(hVar);
                u(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void eO(boolean z) {
        if (this.cHi != null) {
            g(z, this.cHi.apI());
        } else {
            g(z, "normal_page");
        }
    }

    private void g(boolean z, String str) {
        eP("frs_page".equals(str));
        if (this.cHq != null) {
            this.cHq.a(z, this.cHk, this.cHj, this.cHa, this.cGG);
        }
    }

    public void eP(boolean z) {
        if (this.cHv != null) {
            this.cHv.a(this.cHa, z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(d.h.frs_activity, viewGroup, false);
            this.cGO = new com.baidu.tieba.frs.entelechy.b();
            this.cHq = this.cGO.amZ();
            this.cHj = new com.baidu.tieba.frs.g.f(this, this.cGO);
            this.cHk = this.cGO.z(this);
            Intent intent = getActivity().getIntent();
            if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                this.cGQ = true;
            }
            this.cHa = new i(this, this.cHY, this.cGO, this.cGQ);
            this.cHa.setHeaderViewHeight(this.cHB);
        } else if (this.mRootView.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            this.cHa.ame();
        }
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Intent intent = getActivity().getIntent();
        this.ctl = System.currentTimeMillis();
        if (intent != null) {
            this.cGX = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.ctl = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            J(intent);
        }
        this.beginTime = System.currentTimeMillis();
        this.aKk = this.beginTime - this.ctl;
        this.cGW = new com.baidu.tieba.tbadkCore.data.e("frs", com.baidu.tieba.tbadkCore.data.e.gyE);
        this.cHi = new FrsModelController(this, this.cHT);
        this.cHi.a(this.cHJ);
        this.cHi.init();
        if (intent != null) {
            this.cHi.h(intent.getExtras());
        } else if (bundle != null) {
            this.cHi.h(bundle);
        } else {
            this.cHi.h(null);
        }
        this.cHk.ax(this.cHa.WP());
        if (intent != null) {
            this.cHj.k(intent.getExtras());
        } else if (bundle != null) {
            this.cHj.k(bundle);
        } else {
            this.cHj.k((Bundle) null);
        }
        this.cGZ = getVoiceManager();
        this.cHy = new h(getPageContext(), this);
        initUI();
        initData(bundle);
        if (this.mFrom != null && this.mFrom.equals("from_tieba_kuang")) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12264").r("obj_type", 1).ac(ImageViewerConfig.FORUM_NAME, this.cHi.getForumName()));
            KuangFloatingViewController.getInstance().setNeedShowFloatingView(true);
            KuangFloatingViewController.getInstance().showFloatingView();
        }
        if (!aly()) {
            this.cHo = new an(getActivity(), this.cHa, this.cHj);
            this.cHo.fc(true);
        }
        this.cGZ = getVoiceManager();
        if (this.cGZ != null) {
            this.cGZ.onCreate(getPageContext());
        }
        new com.baidu.tieba.frs.mc.g();
        this.cHu = new com.baidu.tieba.frs.mc.c(this, this.cHV);
        this.cHm = new com.baidu.tieba.frs.smartsort.b(this);
        this.cHv = new com.baidu.tieba.frs.g.h(this);
        this.createTime = System.currentTimeMillis() - this.beginTime;
        this.cHs = new com.baidu.tieba.frs.g.a(getPageContext(), this.cHi.apT());
        this.cHn = new com.baidu.tieba.frs.mc.b(this);
        this.cHt = new com.baidu.tieba.frs.mc.d(this);
        this.cHl = new com.baidu.tieba.frs.mc.f(this);
        this.cHw = new com.baidu.tieba.frs.mc.a(this);
        this.cHz = new com.baidu.tieba.frs.g.c(this);
        this.cHA = new com.baidu.tieba.frs.mc.e(this, getUniqueId());
        this.cHG = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "frs");
        registerListener(this.bpO);
        registerListener(this.mMemListener);
        registerListener(this.cHP);
        registerListener(this.cHW);
        registerListener(this.cHO);
        registerListener(this.cHU);
        registerListener(this.cHL);
        registerListener(this.cHM);
        registerListener(this.cHN);
        registerListener(this.cHH);
        registerListener(this.cHI);
        registerListener(this.cIe);
        registerListener(this.cHR);
        registerListener(this.cHS);
        this.cHa.eV(false);
        if (!aly()) {
            showLoadingView(this.cHa.WP(), true);
            this.cHi.p(3, true);
        }
        super.onActivityCreated(bundle);
    }

    @Override // com.baidu.tieba.frs.ai
    public void Pk() {
        if (isAdded() && this.btK && !isLoadingViewAttached()) {
            showLoadingView(this.cHa.WP(), true);
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void Pl() {
        if (isAdded() && this.btK && isLoadingViewAttached()) {
            hideLoadingView(this.cHa.WP());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (aly()) {
            showLoadingView(this.cHa.WP(), true);
            this.cHa.jO(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.cHi.p(3, true);
            getListView().setSelection(0);
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void setHeaderViewHeight(int i) {
        this.cHB = i;
        if (this.cHa != null) {
            this.cHa.setHeaderViewHeight(this.cHB);
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.s sVar) {
        if (sVar != null) {
            this.aNi = sVar.Hq();
            this.cHC = sVar.Hr();
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void showFloatingView() {
        if (this.aNi != null) {
            this.aNi.bZ(true);
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
            this.cGT = data.getQueryParameter("name");
            this.mFrom = data.getQueryParameter("from");
            if (!StringUtils.isNull(this.cGT)) {
                intent.putExtra("name", this.cGT);
            }
            if (!StringUtils.isNull(this.mFrom)) {
                intent.putExtra("from", this.mFrom);
            }
            TiebaStatic.log("c10105");
        }
        if (StringUtils.isNull(this.cGT)) {
            this.cGT = com.baidu.tieba.frs.f.h.L(intent);
            if (!StringUtils.isNull(this.cGT)) {
                intent.putExtra("name", this.cGT);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.cGZ = getVoiceManager();
        if (this.cGZ != null) {
            this.cGZ.onStart(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        Intent intent;
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.cIb);
        if (bundle != null) {
            this.cGT = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
            this.cGT = intent.getStringExtra("name");
            this.mFrom = intent.getStringExtra("from");
            this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
        }
        if (TextUtils.isEmpty(this.mFrom) || FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
        }
        if (this.mIsLogin) {
            registerListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL, this.cIb);
        }
        this.cHj.k(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.cIe);
        if (this.cGZ != null) {
            this.cGZ.onDestory(getPageContext());
        }
        this.cGZ = null;
        s.abU().dT(false);
        if (this.cGG != null && this.cGG.aRf() != null) {
            ad.amq().bo(com.baidu.adp.lib.g.b.c(this.cGG.aRf().getId(), 0L));
        }
        if (this.cHx != null) {
            this.cHx.onDestory();
        }
        if (this.cHa != null) {
            com.baidu.tieba.frs.f.g.a(this.cHa, this.cGG, getForumId(), false, null);
            this.cHa.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.cHg != null) {
                this.cHg.onDestroy();
            }
            this.cHa.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.cHi.onActivityDestroy();
        this.cHj.onActivityDestroy();
        if (this.cHi != null) {
            this.cHi.QJ();
        }
        if (this.cHo != null) {
            this.cHo.Hp();
        }
        if (this.cHr != null) {
            this.cHr.destory();
        }
        if (this.cHs != null) {
            this.cHs.destory();
        }
        if (this.cHm != null) {
            this.cHm.onDestroy();
        }
        if (this.cHD != null) {
            this.cHD.onDestory();
        }
        if (this.cHw != null) {
            this.cHw.onDestroy();
        }
        if (this.cHG != null) {
            this.cHG.onDestroy();
        }
        com.baidu.tieba.recapp.e.a.blQ().blS();
        com.baidu.tieba.frs.f.i.aqu();
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.cGT);
        bundle.putString("from", this.mFrom);
        this.cHi.onSaveInstanceState(bundle);
        if (this.cGZ != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            this.cGZ.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.cHw != null) {
            this.cHw.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.cHa != null) {
            this.cHa.alL();
            this.cHa.onResume();
        }
        this.cHk.a(this.cHK);
        this.cHl.fy(true);
        this.cHh = true;
        if (cGR) {
            cGR = false;
            this.cHa.startPullRefresh();
            return;
        }
        if (this.cGZ != null) {
            this.cGZ.onResume(getPageContext());
        }
        this.cHa.eW(false);
        registerListener(this.cHX);
        if (this.cHE) {
            cn(6);
            this.cHE = false;
        }
        KuangFloatingViewController.getInstance().showFloatingView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        refresh();
    }

    public boolean alm() {
        Intent intent;
        if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
            return false;
        }
        return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
    }

    public void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.cGT = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.cGU = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.cGU) {
                aln();
            }
            if (this.mFrom != null && this.mFrom.equals("from_tieba_kuang")) {
                KuangFloatingViewController.getInstance().setNeedShowFloatingView(true);
                KuangFloatingViewController.getInstance().showFloatingView();
            }
        }
    }

    private void aln() {
        this.cHa.startPullRefresh();
    }

    public void closeActivity() {
        com.baidu.tieba.frs.f.h.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.mFrom);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.cHa.setTitle(this.cGT);
        } else {
            this.cHa.setTitle("");
            this.mFlag = 1;
        }
        this.cHj.d(this.cHa.getListView());
        this.cHa.setOnAdapterItemClickListener(this.cIc);
        this.cHa.setOnScrollListener(this.cHZ);
        this.cHa.h(this.cFo);
        this.cHa.alV().a(this.cIa);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cHa.onChangeSkinType(i);
        this.cHj.kV(i);
        this.cHk.onChangeSkinType(i);
    }

    public void jM(int i) {
        if (!this.mIsLogin) {
            if (this.cGG != null && this.cGG.qi() != null) {
                this.cGG.qi().setIfpost(1);
            }
            if (i == 0) {
                ax.aU(getActivity());
            }
        } else if (this.cGG != null) {
            if (i == 0) {
                com.baidu.tieba.frs.f.i.b(this, 0);
            } else {
                this.cHa.alN();
            }
        }
    }

    public void refresh() {
        cn(3);
    }

    public void cn(int i) {
        this.cHe = false;
        als();
        if (this.cHa.alD() != null) {
            this.cHa.alD().avl();
        }
        this.cHi.p(i, true);
    }

    private void alo() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.g.h.fQ().d(new Runnable() { // from class: com.baidu.tieba.frs.f.15
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.td(f.this.cGT);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alp() {
        als();
        try {
            if (this.cGG != null) {
                this.cHa.PB();
                this.cHa.eR(this.cHi.apN());
                if (com.baidu.tieba.frs.g.f.i(this.cGG) && !com.baidu.tieba.frs.g.f.h(this.cGG)) {
                    this.cHa.amc();
                }
                if (this.cGG.aRf() != null) {
                    this.cGT = this.cGG.aRf().getName();
                    this.forumId = this.cGG.aRf().getId();
                }
                if (this.cGG.qA() != null) {
                    setHasMore(this.cGG.qA().qw());
                }
                this.cHa.setTitle(this.cGT);
                this.cHa.setForumName(this.cGT);
                TbadkCoreApplication.getInst().setDefaultBubble(this.cGG.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.cGG.getUserData().getBimg_end_time());
                alo();
                alq();
                ArrayList<com.baidu.adp.widget.ListView.f> threadList = this.cGG.getThreadList();
                if (threadList != null) {
                    this.cHa.a(threadList, this.cGG);
                    com.baidu.tieba.frs.f.c.j(this.cHa);
                    this.cHj.kW(getPageNum());
                    this.cHj.f(this.cGG);
                    this.cHk.a(this.cHa.getListView(), this.cGG, this.cHi.apS());
                    this.cHa.alO();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void alq() {
        if (this.cGG != null) {
            if (this.cGG.aRt() == 1) {
                this.cHa.alV().setFromCDN(true);
            } else {
                this.cHa.alV().setFromCDN(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.cHl.fy(false);
        this.cHh = false;
        this.cHa.onPause();
        if (this.cGZ != null) {
            this.cGZ.onPause(getPageContext());
        }
        this.cHa.eW(true);
        if (this.cHs != null) {
            this.cHs.aqx();
        }
        MessageManager.getInstance().unRegisterListener(this.cHX);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        s.abU().dT(false);
        if (this.cGG != null && this.cGG.aRf() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            com.baidu.tbadk.distribute.a.CN().a(getPageContext().getPageActivity(), "frs", this.cGG.aRf().getId(), 0L);
        }
        if (this.cGZ != null) {
            this.cGZ.onStop(getPageContext());
        }
        com.baidu.tieba.frs.f.h.a(getListView());
        this.cHj.onActivityStop();
        t.Ht();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && this.cHj != null) {
            this.cHj.fA(isPrimary());
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || this.cHa == null) {
            return false;
        }
        return this.cHa.alK();
    }

    @Override // com.baidu.tieba.recapp.o
    public TbPageContext<?> xQ() {
        return getPageContext();
    }

    @Override // com.baidu.tieba.recapp.o
    public void a(AdvertAppInfo advertAppInfo, String str) {
        com.baidu.tbadk.distribute.a.CN().a(advertAppInfo, this.forumId, 0L, "FRS", str, getPn());
    }

    @Override // com.baidu.tieba.recapp.o
    public void alr() {
        akZ().alr();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.cGZ == null) {
            this.cGZ = VoiceManager.instance();
        }
        return this.cGZ;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public BdListView getListView() {
        if (this.cHa == null) {
            return null;
        }
        return this.cHa.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void als() {
        if (this.cGZ != null) {
            this.cGZ.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> wO() {
        if (this.aoO == null) {
            this.aoO = UserIconBox.i(getPageContext().getPageActivity(), 8);
        }
        return this.aoO;
    }

    public void alt() {
        if (getFragmentActivity() != null && getFragmentActivity().getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.a(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.g onGetPreLoadListView() {
        return getListView();
    }

    @Override // com.baidu.tieba.frs.ak
    public NavigationBar alu() {
        if (this.cHa == null) {
            return null;
        }
        return this.cHa.alu();
    }

    /* loaded from: classes.dex */
    private final class a implements com.baidu.adp.widget.ListView.h {
        private a() {
        }

        @Override // com.baidu.adp.widget.ListView.h
        public void a(View view, com.baidu.adp.widget.ListView.f fVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            boolean z;
            if (bdUniqueId != null) {
                if (bdUniqueId == p.cJx) {
                    if (f.this.cHa != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11752").ac(ImageViewerConfig.FORUM_ID, f.this.forumId).ac("obj_locate", "1"));
                        f.this.cHa.startPullRefresh();
                    }
                } else if (fVar != null && (fVar instanceof bd)) {
                    bd bdVar = (bd) fVar;
                    if (bdVar.si() == null || bdVar.si().getGroup_id() == 0 || ax.aV(f.this.getActivity())) {
                        if ((bdVar.sb() != 1 && bdVar.sb() != 2) || ax.aV(f.this.getActivity())) {
                            if (bdVar.rL() != null) {
                                if (ax.aV(f.this.getActivity())) {
                                    String postUrl = bdVar.rL().getPostUrl();
                                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.hy()) {
                                        com.baidu.tbadk.browser.a.Q(f.this.getActivity(), postUrl);
                                    }
                                }
                            } else if (bdVar.su() != null) {
                                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                    ax.aU(f.this.getPageContext().getPageActivity());
                                    return;
                                }
                                com.baidu.tbadk.core.data.m su = bdVar.su();
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(f.this.getPageContext().getPageActivity(), su.getCartoonId(), su.getChapterId(), 2)));
                            } else if (bdVar.getThreadType() == 47 && bdVar.rs() == 1 && !com.baidu.tbadk.core.util.am.isEmpty(bdVar.rF())) {
                                com.baidu.tbadk.browser.a.P(f.this.getPageContext().getPageActivity(), bdVar.rF());
                            } else {
                                com.baidu.tieba.tbadkCore.util.e readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                                if (readThreadHistory != null && !readThreadHistory.tj(bdVar.getId())) {
                                    readThreadHistory.ti(bdVar.getId());
                                }
                                final String rF = bdVar.rF();
                                if (rF == null || rF.equals("")) {
                                    z = false;
                                } else {
                                    new Thread(new Runnable() { // from class: com.baidu.tieba.frs.f.a.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(rF);
                                            xVar.uQ().vN().mIsNeedAddCommenParam = false;
                                            xVar.uQ().vN().mIsUseCurrentBDUSS = false;
                                            xVar.ut();
                                        }
                                    }).start();
                                    z = true;
                                }
                                String tid = bdVar.getTid();
                                if (tid == null) {
                                    tid = "";
                                }
                                if (bdVar.rs() == 2 && !tid.startsWith("pb:")) {
                                    com.baidu.tbadk.core.util.av.vL().c(f.this.getPageContext(), new String[]{tid, "", null});
                                } else if (bdVar.getThreadType() == 33 || (bdVar instanceof com.baidu.tbadk.core.data.as)) {
                                    String str = bdVar.getThreadType() == 33 ? "c10245" : "c10180";
                                    if (f.this.cHi.apM() == 5) {
                                        str = "c10387";
                                    }
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak(str).ac(ImageViewerConfig.FORUM_ID, f.this.forumId));
                                    com.baidu.tieba.frs.f.h.b(f.this, bdVar);
                                    if (f.this.cGG != null && f.this.cGG.aRf() != null) {
                                        com.baidu.tieba.frs.e.a aVar = new com.baidu.tieba.frs.e.a();
                                        aVar.cYC = f.this.cGG.gwD == 1;
                                        aVar.cYE = f.this.cGG.aRf().getId();
                                        aVar.cYD = f.this.akZ().apS();
                                        com.baidu.tieba.frs.e.b.aqn().a(aVar, bdVar, 1);
                                    }
                                } else {
                                    if (tid.startsWith("pb:")) {
                                        bdVar.setId(tid.substring(3));
                                    }
                                    if (bdUniqueId.getId() == bd.ZU.getId()) {
                                        com.baidu.tieba.frs.f.g.a(bdVar.rd());
                                    }
                                    com.baidu.tieba.frs.f.h.a(f.this, bdVar, i, z);
                                    com.baidu.tieba.frs.f.g.a(f.this, f.this.cGG, bdVar);
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
            hideNetRefreshView(this.cHa.WP());
            showLoadingView(this.cHa.WP(), true);
            this.cHa.eV(false);
            this.cHi.p(3, true);
        }
    }

    public com.baidu.tieba.tbadkCore.k alv() {
        return this.cGG;
    }

    public boolean alw() {
        return this.cHa.alw();
    }

    public void Q(Object obj) {
        if (this.cHn != null && this.cHn.cXw != null) {
            this.cHn.cXw.f(obj);
        }
    }

    public void R(Object obj) {
        if (this.cHn != null && this.cHn.cXx != null) {
            this.cHn.cXx.f(obj);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.l.hy()) {
            this.cHa.acX();
        } else if (this.cHi.apM() == 1) {
            OW();
            OI();
        } else if (this.cHi.hasMore()) {
            OI();
        }
    }

    public void ld(String str) {
        OW();
        showToast(str);
    }

    public void H(ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        OW();
        if (!com.baidu.tbadk.core.util.v.w(arrayList)) {
            if (!this.cHi.apW() && TbadkCoreApplication.getInst().isRecAppExist() && this.cHi.apM() == 1) {
                this.cGG.a(this, arrayList);
            }
            ArrayList<com.baidu.adp.widget.ListView.f> a2 = this.cHu.a(false, false, arrayList, this.cGW);
            if (a2 != null) {
                this.cGG.az(a2);
                this.cHa.a(a2, this.cGG);
            }
            if (this.cHi != null) {
                com.baidu.tieba.frs.e.b.a(this.cGG, this.cHi.apS(), 2);
            }
        }
    }

    private void OW() {
        if (alf() == 1 || this.cHu.bc(this.cGG.but())) {
            if (com.baidu.tbadk.core.util.v.v(this.cGG.getThreadList()) > 3) {
                this.cHa.alY();
            } else {
                this.cHa.ama();
            }
        } else if (com.baidu.tbadk.core.util.v.w(this.cGG.getThreadList())) {
            this.cHa.acX();
        } else {
            this.cHa.alZ();
        }
    }

    @Override // com.baidu.tieba.frs.mc.j
    public void OI() {
        if (this.cHu != null) {
            this.cHu.a(this.cGT, this.forumId, this.cGG);
        }
    }

    public void alx() {
        if (!com.baidu.tbadk.core.util.ab.e(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.ai.c(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return aly() ? "a034" : "a006";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (!aly()) {
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

    public void eQ(boolean z) {
        if (this.cHo != null) {
            this.cHo.fc(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.cHp.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a gl(int i) {
        return this.cHp.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        this.cHy.b(bVar);
    }

    public boolean aly() {
        return this.cGQ;
    }

    @Override // com.baidu.tieba.frs.ai
    public void Pj() {
        if (this.cHa != null) {
            showFloatingView();
            this.cHa.getListView().setSelection(0);
            this.cHa.startPullRefresh();
        }
    }

    public ForumWriteData alz() {
        if (this.cGG == null || this.cGG.aRf() == null) {
            return null;
        }
        ForumData aRf = this.cGG.aRf();
        ForumWriteData forumWriteData = new ForumWriteData(aRf.getId(), aRf.getName(), aRf.getPrefixData(), this.cGG.qi());
        forumWriteData.setForumLevel(aRf.getUser_level());
        forumWriteData.setAvatar(this.cGG.aRf().getImage_url());
        return forumWriteData;
    }

    @Override // com.baidu.tieba.frs.ai
    public void wE() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void cM(boolean z) {
        if (this.cHa != null) {
            this.cHa.cM(z);
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void setVideoThreadId(String str) {
    }
}
