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
    public static boolean cxL = false;
    public static volatile long cxV = 0;
    public static volatile long cxW = 0;
    public static volatile int cxX = 0;
    private r aMH;
    private com.baidu.adp.lib.e.b<TbImageView> aox;
    private com.baidu.tieba.frs.gametab.b blW;
    private com.baidu.tieba.frs.entelechy.b cxI;
    public bh cxM;
    private com.baidu.tieba.tbadkCore.data.e cxQ;
    private VoiceManager cxT;
    private com.baidu.tieba.NEGFeedBack.a cyB;
    private f.a cyb;
    private FrsModelController cyd;
    private com.baidu.tieba.frs.g.f cye;
    private com.baidu.tieba.frs.entelechy.b.d cyf;
    private com.baidu.tieba.frs.mc.f cyg;
    private com.baidu.tieba.frs.smartsort.b cyh;
    private com.baidu.tieba.frs.mc.b cyi;
    private an cyj;
    private com.baidu.tieba.frs.entelechy.b.b cyl;
    private com.baidu.tbadk.i.a cym;
    private com.baidu.tieba.frs.g.a cyn;
    private com.baidu.tieba.frs.mc.d cyo;
    private com.baidu.tieba.frs.mc.c cyp;
    private com.baidu.tieba.frs.g.h cyq;
    private com.baidu.tieba.frs.mc.a cyr;
    private com.baidu.tieba.frs.live.a cys;
    private h cyt;
    public com.baidu.tieba.frs.g.c cyu;
    private com.baidu.tieba.frs.mc.e cyv;
    private int cyw;
    private View.OnTouchListener cyx;
    private com.baidu.tieba.frs.g.e cyy;
    private boolean cyz;
    public View mRootView;
    public boolean cxJ = false;
    private boolean cxK = false;
    public String cxN = null;
    public String aiB = null;
    public int mFlag = 0;
    private boolean cxO = false;
    private String mThreadId = null;
    public String forumId = null;
    private int cxC = 0;
    private boolean cxP = false;
    private boolean cxR = false;
    private boolean cxS = false;
    private i cxU = null;
    public final bh biZ = null;
    private com.baidu.tieba.tbadkCore.j cxA = new com.baidu.tieba.tbadkCore.j();
    public long ckH = -1;
    public long aJR = 0;
    public long aJJ = 0;
    public long createTime = 0;
    public long WI = -1;
    private boolean cxY = false;
    private boolean cxZ = false;
    public com.baidu.tbadk.l.d cya = null;
    private boolean cyc = true;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> cyk = new SparseArray<>();
    private boolean bne = true;
    private boolean cyA = false;
    private final CustomMessageListener cyC = new CustomMessageListener(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED) { // from class: com.baidu.tieba.frs.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof bh) {
                    com.baidu.tieba.frs.f.h.a(f.this.cxU, f.this.cxA, f.this.getForumId(), true, (bh) data);
                }
            }
        }
    };
    private CustomMessageListener cyD = new CustomMessageListener(CmdConfigCustom.CMD_CLOSE_GAME_RANK_CARD) { // from class: com.baidu.tieba.frs.f.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (f.this.cxA != null) {
                f.this.cxA.btG();
                if (f.this.cxU != null) {
                    f.this.cxU.abn();
                }
            }
        }
    };
    private final al cyE = new al() { // from class: com.baidu.tieba.frs.f.23
        @Override // com.baidu.tieba.frs.al
        public void a(int i, int i2, ar arVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
            f.this.ajn();
            if (f.this.cyl != null) {
                f.this.cye.fk(f.this.cyl.jF(i));
            }
            d.a aVar = new d.a();
            if (arVar != null) {
                aVar.isSuccess = arVar.errCode == 0;
                aVar.errorCode = arVar.errCode;
                aVar.errorMsg = arVar.errMsg;
                if (aVar.isSuccess) {
                    if (com.baidu.tbadk.core.util.v.v(arrayList)) {
                        f.this.cxU.abo();
                    } else if (arVar.hasMore) {
                        f.this.cxU.ake();
                    } else if (arVar.cBm) {
                        f.this.cxU.akf();
                    } else {
                        f.this.cxU.abo();
                    }
                }
            } else {
                arVar = new ar();
                arVar.pn = 1;
                arVar.hasMore = false;
                arVar.cBm = false;
            }
            if (i == 1) {
                f.this.cyc = true;
                f.this.cyO.a(f.this.cyd.getType(), false, aVar);
            } else {
                f.this.a(aVar);
                if (f.this.cyd.amD() != null) {
                    f.this.cxA = f.this.cyd.amD();
                }
                f.this.ajv();
            }
            if (f.this.cyY != null) {
                f.this.cyY.a(i, i2, arVar, arrayList);
            }
        }
    };
    private aj cyF = new aj() { // from class: com.baidu.tieba.frs.f.24
        @Override // com.baidu.tieba.frs.aj
        public void a(al alVar) {
        }

        @Override // com.baidu.tieba.frs.aj
        public void a(int i, int i2, ao aoVar) {
            if (i != 1) {
                com.baidu.tieba.card.u.aaj().dF(false);
            }
            if (i == 1) {
                f.this.cxU.eD(true);
                f.this.cxU.eC(false);
            } else {
                f.this.cxU.eE(true);
                f.this.cxU.eC(true);
            }
            f.this.ajy();
            f.this.cyd.a(i, i2, aoVar);
        }

        @Override // com.baidu.tieba.frs.aj
        public void init() {
        }

        @Override // com.baidu.tieba.frs.aj
        public void PA() {
        }
    };
    private CustomMessageListener cyG = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIVE_COUNT) { // from class: com.baidu.tieba.frs.f.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                ((com.baidu.tieba.frs.entelechy.c.a) f.this.cyf).jH(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    };
    private CustomMessageListener cyH = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_LIVE_START) { // from class: com.baidu.tieba.frs.f.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && ((Integer) customResponsedMessage.getData()).intValue() == 51 && f.this.cxA != null) {
                com.baidu.tieba.frs.f.j.a(f.this.cxA, f.this.getPageContext());
            }
        }
    };
    private final CustomMessageListener cyI = new CustomMessageListener(CmdConfigCustom.CMD_FRS_SELECT_ALA_LIVE_TAB) { // from class: com.baidu.tieba.frs.f.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (f.this.cyf instanceof com.baidu.tieba.frs.entelechy.c.a) && ((com.baidu.tieba.frs.entelechy.c.a) f.this.cyf).alU() != null) {
                ((com.baidu.tieba.frs.entelechy.c.a) f.this.cyf).alU().kq(49);
            }
        }
    };
    private final CustomMessageListener cyJ = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.frs.f.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && f.this.cxA != null && f.this.cxA.aPU() != null) {
                SignData signData = (SignData) customResponsedMessage.getData();
                int user_level = f.this.cxA.aPU().getUser_level();
                if (signData.forumId != null && signData.forumId.equals(f.this.cxA.aPU().getId())) {
                    f.this.cxA.d(signData);
                    f.this.cye.g(f.this.cxA);
                    if (f.this.cye.aoU()) {
                        i = f.this.cxA.aPU().getUser_level();
                        if (user_level >= i) {
                            i++;
                        }
                    } else {
                        i = user_level;
                    }
                    TbadkCoreApplication.getInst().addSignedForum(f.this.cxA.aPU().getName(), signData.sign_bonus_point, i);
                }
            }
        }
    };
    private final CustomMessageListener cyK = new CustomMessageListener(CmdConfigCustom.CMD_FRS_EXPERIENCE_TIP) { // from class: com.baidu.tieba.frs.f.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.p) && f.this.cxA != null) {
                f.this.cxA.c((com.baidu.tieba.tbadkCore.p) customResponsedMessage.getData());
                f.this.cye.f(f.this.cxA);
                f.this.cyf.a(f.this.cxU.getListView(), f.this.cxA, f.this.cyd.anY());
            }
        }
    };
    private final AntiHelper.a cyL = new AntiHelper.a() { // from class: com.baidu.tieba.frs.f.2
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12536").r("obj_locate", ap.a.ahv));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12535").r("obj_locate", ap.a.ahv));
        }
    };
    private CustomMessageListener bjf = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.f.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(f.this.xP().getUniqueId())) {
                    if (updateAttentionMessage.getData().arR != null) {
                        if (AntiHelper.a(f.this.getActivity(), updateAttentionMessage.getData().arR, f.this.cyL) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12534").r("obj_locate", ap.a.ahv));
                        }
                    } else if (updateAttentionMessage.getData().BJ && updateAttentionMessage.getData().isAttention) {
                        com.baidu.adp.lib.util.l.showToast(f.this.xP().getPageActivity(), d.j.attention_success);
                    }
                }
            }
        }
    };
    private CustomMessageListener cyM = new CustomMessageListener(CmdConfigCustom.CMD_STORY_READ_CACHE) { // from class: com.baidu.tieba.frs.f.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.story.process.b)) {
                com.baidu.tieba.story.process.b bVar = (com.baidu.tieba.story.process.b) customResponsedMessage.getData();
                if (f.this.forumId != null && f.this.forumId.equals(String.valueOf(bVar.forumId)) && bVar.state == 3 && f.this.ajB() != null && !com.baidu.tbadk.core.util.v.v(f.this.ajB().bsB()) && f.this.cxI.ale() != null && f.this.cxI.ale().alu() != null) {
                    List<com.baidu.adp.widget.ListView.f> bsB = f.this.ajB().bsB();
                    int size = bsB.size();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= size) {
                            i = -1;
                            break;
                        } else if ((bsB.get(i2) instanceof com.baidu.tbadk.data.g) && TbadkCoreApplication.getCurrentAccount().equals(String.valueOf(((com.baidu.tbadk.data.g) bsB.get(i2)).user_id))) {
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
                    gVar.azM = String.valueOf(f.this.forumId);
                    gVar.azL = bVar;
                    if (i != -1) {
                        bsB.set(i, gVar);
                    } else {
                        bsB.add(1, gVar);
                    }
                    f.this.cxI.ale().alu().b(bsB, f.this.forumId, f.this.getThreadId());
                }
            }
        }
    };
    private CustomMessageListener cyN = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.frs.f.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                f.this.cxU.b((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.l cyO = new com.baidu.tieba.tbadkCore.l() { // from class: com.baidu.tieba.frs.f.6
        private long startTime = 0;

        @Override // com.baidu.tieba.tbadkCore.l
        public void jp(int i) {
            this.startTime = System.nanoTime();
            if (f.this.cxU != null) {
                switch (i) {
                    case 1:
                    case 2:
                        f.this.cxU.ajR();
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
            if (f.this.bne) {
                f.this.bne = false;
                com.baidu.tieba.frs.f.h.a(f.this.cxU, f.this.cxA, f.this.getForumId(), false, null);
            }
            f.this.ajn();
            f.this.cxY = true;
            if (aVar != null && aVar.isSuccess) {
                f.this.cxU.akb().eR(com.baidu.tbadk.core.util.an.vs().vu());
                f.cxV = 0L;
                f.cxW = 0L;
                f.cxX = 0;
            } else {
                f.cxX = 1;
            }
            if (!f.this.cyd.aoc() && (i == 3 || i == 6)) {
                f.this.cyp.resetData();
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (f.this.cyd.amD() != null) {
                f.this.cxA = f.this.cyd.amD();
            }
            if (i == 7) {
                f.this.jn(f.this.cxA.btb());
                return;
            }
            if (f.this.cxA.qv() != null) {
                f.this.setHasMore(f.this.cxA.qv().qr());
            }
            f.this.ajo();
            if (i == 4) {
                if (!f.this.cyd.aoc() && TbadkCoreApplication.getInst().isRecAppExist() && f.this.cyd.anS() == 1) {
                    f.this.cxA.a(f.this);
                }
                ArrayList<com.baidu.adp.widget.ListView.f> a2 = f.this.cyp.a(false, false, f.this.cxA.getThreadList(), f.this.cxQ);
                if (a2 != null) {
                    f.this.cxA.az(a2);
                    f.this.cxA.btz();
                    f.this.cxU.a(a2, f.this.cxA);
                }
                if (f.this.cyd != null) {
                    com.baidu.tieba.frs.e.b.a(f.this.cxA, f.this.cyd.anY(), 2);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    f.this.cxU.ajR();
                    break;
                case 2:
                    f.this.cxU.ajR();
                    break;
                case 3:
                case 6:
                    if (f.this.cxA != null) {
                        f.this.cxA.btx();
                    }
                    if (f.this.cyu != null) {
                        f.this.cyu.refresh();
                        break;
                    }
                    break;
            }
            f.this.ajp();
            if (aVar == null || aVar.errorCode == 0) {
                if (f.this.cxA != null) {
                    f.this.cxU.jr(i);
                    f.this.u(false, i == 5);
                    f.cxV = (System.nanoTime() - this.startTime) / 1000000;
                    if (aVar != null) {
                        f.cxW = aVar.gnj;
                    }
                } else {
                    return;
                }
            } else if (f.this.cxA == null || com.baidu.tbadk.core.util.v.v(f.this.cxA.getThreadList())) {
                f.this.a(aVar);
            } else if (aVar.gni) {
                f.this.showToast(f.this.getPageContext().getResources().getString(d.j.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
            }
            if (f.this.cxA.bsG() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11384"));
            }
            if (f.this.ckH > -1 && !f.this.cyA) {
                com.baidu.tieba.frs.f.h.a(f.this.cyd, f.this.ckH);
                f.this.ckH = -1L;
                f.this.cyA = true;
            }
            if (f.this.cxR && (f.this.cyf instanceof com.baidu.tieba.frs.entelechy.c.a) && ((com.baidu.tieba.frs.entelechy.c.a) f.this.cyf).alU() != null) {
                ((com.baidu.tieba.frs.entelechy.c.a) f.this.cyf).alU().kq(49);
                f.this.cxR = false;
            }
            f.this.aJR = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.l
        public void b(com.baidu.tieba.tbadkCore.g gVar) {
            if (gVar != null) {
                if ("normal_page".equals(f.this.cyd.anO()) || "frs_page".equals(f.this.cyd.anO()) || "book_page".equals(f.this.cyd.anO())) {
                    f.this.a(gVar);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE, gVar));
                }
            }
        }
    };
    private final CustomMessageListener cyP = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.frs.f.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.k) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                f.this.cxA.a((com.baidu.tbadk.data.k) customResponsedMessage.getData());
                f.this.cxU.akb().notifyDataSetChanged();
            }
        }
    };
    private final CustomMessageListener mMemListener = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_MEM) { // from class: com.baidu.tieba.frs.f.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && f.this.cxA != null && (userData = f.this.cxA.getUserData()) != null) {
                userData.setIsMem(num.intValue());
                if (num.intValue() != 0) {
                    f.this.cye.f(num);
                }
            }
        }
    };
    private final com.baidu.tieba.frs.mc.i cyQ = new com.baidu.tieba.frs.mc.i() { // from class: com.baidu.tieba.frs.f.10
        @Override // com.baidu.tieba.frs.mc.i
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.f> arrayList, boolean z3) {
            if (f.this.cyh != null && f.this.cyd != null && f.this.cyd.aoc() && z && !z2 && !z3) {
                f.this.cyh.kk(i2);
            }
        }
    };
    public final View.OnTouchListener aMI = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.f.11
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (f.this.cyx != null) {
                f.this.cyx.onTouch(view, motionEvent);
            }
            if (f.this.cyj != null && f.this.cyj.aky() != null) {
                f.this.cyj.aky().onTouchEvent(motionEvent);
            }
            if (f.this.blW != null) {
                f.this.blW.d(view, motionEvent);
            }
            if (f.this.cye != null) {
                f.this.cye.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private final CustomMessageListener cyR = new CustomMessageListener(CmdConfigCustom.CMD_GOTOLIVE_HOST_UPGRADE) { // from class: com.baidu.tieba.frs.f.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "photolive_hostLevel", -1) != -1 && f.this.cxA.aPU() != null) {
                f.this.cxA.aPU().setCanAddPhotoLivePost(true);
            }
        }
    };
    private final CustomMessageListener cyS = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.frs.f.14
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
    public final View.OnClickListener cyT = new View.OnClickListener() { // from class: com.baidu.tieba.frs.f.16
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (f.this.cxU == null || view != f.this.cxU.ajP() || f.this.getActivity() == null) {
                if (f.this.cxA != null && f.this.cxA.aPU() != null) {
                    if (f.this.cxU == null || view != f.this.cxU.ajV()) {
                        if (f.this.cxU != null && view == f.this.cxU.ajW()) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12402").ac(ImageViewerConfig.FORUM_ID, f.this.cxA.aPU().getId()).ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()).ac(ImageViewerConfig.FORUM_NAME, f.this.cxA.aPU().getName()));
                            if (!StringUtils.isNull(f.this.cxA.aPU().getName())) {
                                f.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PostSearchActivityConfig(f.this.getPageContext().getPageActivity(), f.this.cxA.aPU().getName(), f.this.cxA.aPU().getId())));
                                return;
                            }
                            return;
                        }
                    } else if (!StringUtils.isNull(f.this.cxA.aPU().getId())) {
                        if (f.this.cxA.aPU() != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12046").ac(ImageViewerConfig.FORUM_ID, f.this.cxA.aPU().getId()).r("obj_locate", f.this.ajE() ? 1 : 2));
                        }
                        f.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(f.this.getPageContext().getPageActivity(), f.this.cxA.aPU().getId(), ForumDetailActivityConfig.FromType.FRS)));
                        return;
                    } else {
                        return;
                    }
                }
                if (view.getId() == d.g.game_activity_egg_layout && com.baidu.adp.lib.util.l.hy()) {
                    TiebaStatic.log("c10853");
                    if (f.this.cxU.ajY()) {
                        f.this.cxU.ajZ();
                        return;
                    }
                    String activityUrl = f.this.cxA.aPU().getYuleData().ta().getActivityUrl();
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
    private final AbsListView.OnScrollListener cyU = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.f.17
        private int czb = 0;
        private int bfu = 0;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (f.this.aMH != null && f.this.isPrimary()) {
                f.this.aMH.a(absListView, this.czb, i, i2, i3);
            }
            if (f.this.cyf != null) {
                f.this.cyf.a(absListView, i, i2, i3, f.this.cye.aoZ());
            }
            if (f.this.cyn != null) {
                f.this.cyn.aoD();
            }
            if (f.this.cyh != null) {
                f.this.cyh.aon();
            }
            if (f.this.cyy != null) {
                f.this.cyy.onScroll(absListView, i, i2, i3);
            }
            if (f.this.cxA != null && f.this.cxU != null && f.this.cxU.akb() != null) {
                this.czb = i;
                this.bfu = (i + i2) - 1;
                f.this.cxU.ay(this.czb, this.bfu);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (f.this.cye != null) {
                f.this.cye.setScrollState(i);
            }
            if (f.this.aMH != null && f.this.isPrimary()) {
                f.this.aMH.onScrollStateChanged(absListView, i);
            }
            if ((i == 2 || i == 1) && !f.this.cxZ) {
                f.this.cxZ = true;
                f.this.cxU.akd();
            }
            if (f.this.cya == null && !f.this.ajE()) {
                f.this.cya = new com.baidu.tbadk.l.d();
                f.this.cya.fs(1000);
            }
            if (i == 0) {
                com.baidu.tieba.card.u.aaj().dF(true);
                f.this.cxU.ax(this.czb, this.bfu);
            }
            if (f.this.cyy != null) {
                f.this.cyy.onScrollStateChanged(absListView, i);
            }
            if (f.this.cya != null) {
                f.this.cya.Ga();
            }
            if (i == 0) {
                com.baidu.tieba.frs.f.h.a(f.this.cxU, f.this.cxA, f.this.getForumId(), false, null);
            }
        }
    };
    private final b cyV = new b() { // from class: com.baidu.tieba.frs.f.18
        @Override // com.baidu.tieba.frs.b
        public void a(int i, int i2, View view, View view2, bh bhVar) {
            if (i != f.this.cxU.akb().alB()) {
                if (i != f.this.cxU.akb().alC()) {
                    if (i != f.this.cxU.akb().alE()) {
                        if (i != f.this.cxU.akb().ako()) {
                            if (i == f.this.cxU.akb().alD() && f.this.cxA != null && f.this.cxA.getUserData() != null && f.this.cxA.getUserData().isBawu()) {
                                final String bsZ = f.this.cxA.bsZ();
                                if (!com.baidu.tbadk.core.util.am.isEmpty(bsZ) && f.this.cxA.aPU() != null) {
                                    com.baidu.tieba.c.a.a(f.this.getPageContext(), f.this.cxA.aPU().getId(), f.this.cxA.aPU().getName(), new a.InterfaceC0078a() { // from class: com.baidu.tieba.frs.f.18.1
                                        @Override // com.baidu.tieba.c.a.InterfaceC0078a
                                        public void ZH() {
                                            com.baidu.tbadk.browser.a.O(f.this.getPageContext().getPageActivity(), bsZ);
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10502").ac(ImageViewerConfig.FORUM_ID, f.this.cxA.aPU().getId()).ac(SapiAccountManager.SESSION_UID, f.this.cxA.getUserData().getUserId()));
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        f.this.cxM = bhVar;
                        com.baidu.tieba.frs.f.i.a(f.this, f.this.cxM);
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10179").ac(ImageViewerConfig.FORUM_ID, f.this.getForumId()));
                        return;
                    }
                    com.baidu.tieba.frs.f.i.B(f.this);
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak(i == f.this.cxU.akb().alE() ? "c10177" : "c10244").ac(ImageViewerConfig.FORUM_ID, f.this.getForumId()));
                } else if (ax.aT(f.this.getPageContext().getPageActivity())) {
                    TiebaStatic.log("my_service_ck");
                    if (f.this.cxA != null && f.this.cxA.aPU() != null) {
                        ForumData aPU = f.this.cxA.aPU();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(f.this.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(aPU.getId(), 0L), aPU.getName(), aPU.getImage_url(), 0)));
                    }
                }
            } else if (ax.aT(f.this.getActivity())) {
                TiebaStatic.log("forum_fortune_click");
                com.baidu.tieba.frs.f.i.a(f.this.getPageContext(), f.this.cxA);
            }
        }
    };
    private final NoNetworkView.a cwk = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.f.19
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aJ(boolean z) {
            if (f.this.cyd.anS() == 1 && z && !f.this.cxU.ajC()) {
                if (f.this.cxA == null || com.baidu.tbadk.core.util.v.v(f.this.cxA.getThreadList())) {
                    f.this.hideNetRefreshView(f.this.cxU.VB());
                    f.this.showLoadingView(f.this.cxU.VB(), true);
                    f.this.cxU.eE(false);
                    f.this.refresh();
                    return;
                }
                f.this.cxU.ajR();
            }
        }
    };
    private final CustomMessageListener cyW = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.f.20
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                com.baidu.tieba.frs.f.c.a(customResponsedMessage, f.this.cxU, f.this.cxA);
            }
        }
    };
    private com.baidu.adp.widget.ListView.h cyX = new a();
    private al cyY = new al() { // from class: com.baidu.tieba.frs.f.21
        @Override // com.baidu.tieba.frs.al
        public void a(int i, int i2, ar arVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
            com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tieba.frs.f.21.1
                @Override // java.lang.Runnable
                public void run() {
                    if (f.this.cxU != null && f.this.cxU.abe()) {
                        f.this.NQ();
                    }
                }
            });
        }
    };
    private CustomMessageListener cyZ = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.frs.f.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    f.this.cyz = true;
                }
            }
        }
    };

    public com.baidu.tieba.frs.entelechy.b.b ajb() {
        return this.cyl;
    }

    public com.baidu.adp.widget.ListView.h ajc() {
        return this.cyX;
    }

    public com.baidu.tieba.frs.mc.d ajd() {
        return this.cyo;
    }

    public com.baidu.tieba.frs.smartsort.b aje() {
        return this.cyh;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public FrsModelController ajf() {
        return this.cyd;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public com.baidu.tieba.frs.mc.c ajg() {
        return this.cyp;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public com.baidu.tieba.frs.g.f ajh() {
        return this.cye;
    }

    public com.baidu.tieba.frs.entelechy.b.d aji() {
        return this.cyf;
    }

    public an ajj() {
        return this.cyj;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public i ajk() {
        return this.cxU;
    }

    @Override // com.baidu.tieba.frs.am
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.am
    public String getForumName() {
        return this.cxN;
    }

    public void setForumName(String str) {
        this.cxN = str;
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
        if (this.cyp == null) {
            return 1;
        }
        return this.cyp.getPn();
    }

    public int getPn() {
        if (this.cyp == null) {
            return 1;
        }
        return this.cyp.getPn();
    }

    public void setPn(int i) {
        if (this.cyp != null) {
            this.cyp.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.cyp != null) {
            this.cyp.setHasMore(i);
        }
    }

    public int ajl() {
        if (this.cyp == null) {
            return -1;
        }
        return this.cyp.ajl();
    }

    public boolean ajm() {
        return this.cxS;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d.a aVar) {
        if (aVar == null) {
            String string = TbadkCoreApplication.getInst().getString(d.j.error_unkown_try_again);
            this.cxU.ajM();
            showNetRefreshView(this.cxU.VB(), string, true);
        } else if (340001 == aVar.errorCode) {
            b(aVar);
        } else {
            if (com.baidu.tbadk.core.util.v.v(this.cxA.getThreadList())) {
                c(aVar);
            }
            if (ajE()) {
                setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst(), d.e.ds280));
            } else {
                setNetRefreshViewEmotionDefMarginTop();
            }
        }
    }

    private void b(d.a aVar) {
        this.cxU.ajM();
        if (aVar.gni) {
            showNetRefreshViewNoClick(this.cxU.VB(), TbadkCoreApplication.getInst().getString(d.j.net_error_text, new Object[]{aVar.errorMsg, Integer.valueOf(aVar.errorCode)}), true);
        } else {
            showNetRefreshViewNoClick(this.cxU.VB(), aVar.errorMsg, true);
        }
    }

    private void c(d.a aVar) {
        this.cxU.ajM();
        if (aVar.gni) {
            showNetRefreshView(this.cxU.VB(), TbadkCoreApplication.getInst().getString(d.j.net_error_text, new Object[]{aVar.errorMsg, Integer.valueOf(aVar.errorCode)}), true);
        } else {
            showNetRefreshView(this.cxU.VB(), aVar.errorMsg, true);
        }
    }

    public void ajn() {
        hideLoadingView(this.cxU.VB());
        this.cxU.ajX();
        if (this.cxU.ajK() instanceof com.baidu.tieba.frs.tab.c) {
            ((com.baidu.tieba.frs.tab.c) this.cxU.ajK()).aox();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajo() {
        if (ajl() == 0 && com.baidu.tbadk.core.util.v.v(this.cxA.bsM())) {
            if (com.baidu.tbadk.core.util.v.v(this.cxA.getThreadList())) {
                this.cxU.abo();
                return;
            } else {
                this.cxU.akf();
                return;
            }
        }
        this.cxU.ake();
    }

    public void a(ErrorData errorData) {
        ajn();
        this.cxU.ajR();
        d.a anP = this.cyd.anP();
        boolean v = com.baidu.tbadk.core.util.v.v(this.cxA.getThreadList());
        if (anP != null && v) {
            if (v) {
                if (this.cyd.anQ() != 0) {
                    this.cyd.anW();
                    this.cxU.ajR();
                } else {
                    a(anP);
                }
                this.cxU.v(this.cxA.btN(), false);
                return;
            } else if (anP.gni) {
                this.cxU.v(true, false);
                showToast(getPageContext().getResources().getString(d.j.net_error_text, anP.errorMsg, Integer.valueOf(anP.errorCode)));
                return;
            } else {
                return;
            }
        }
        a(anP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajp() {
        if (this.cxA == null || this.cxA.aPU() != null) {
            this.cxU.aka();
        } else if (this.cxA.aPU().getYuleData() != null && this.cxA.aPU().getYuleData().sZ()) {
            TiebaStatic.log("c10852");
            this.cxU.a(this.cxA.aPU().getYuleData().ta());
        } else {
            this.cxU.aka();
        }
    }

    private void t(boolean z, boolean z2) {
        if (this.cyd != null && this.cxA != null && this.cxU != null && z) {
            if (!this.cyd.aoc() && this.cyd.anS() == 1) {
                if (!this.cyd.aoa()) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        this.cxA.btE();
                        this.cxA.btB();
                    }
                    this.cxA.btC();
                    this.cxA.btD();
                }
                boolean z3 = false;
                if (this.cxU.akb().l(com.baidu.tieba.card.data.p.bVA)) {
                    z3 = this.cxA.btH();
                }
                if (!z3) {
                    this.cxA.btF();
                }
                if (TbadkCoreApplication.getInst().isRecAppExist()) {
                    this.cxA.a(this);
                }
                if (!this.cxU.akb().l(bh.Ys)) {
                    this.cxA.bty();
                }
                this.cxA.btI();
                this.cxA.btJ();
            }
            this.cxA.btz();
            this.cxA.btw();
            if (this.cxU.akb().l(com.baidu.tieba.g.b.cYw)) {
                this.cxA.mB(z2);
            }
            if (TbadkCoreApplication.isLogin() && (!this.cyd.aoc() || this.cyd.isNetFirstLoad)) {
                this.cxA.btK();
            }
            this.cxA.btL();
        }
    }

    public boolean ajq() {
        if (this.cyf != null && this.cxU != null) {
            this.cyf.b(this.cxU.getListView());
        }
        if (this.cye != null && this.cyd != null) {
            this.cye.a(this.cyd.anO(), this.cxA);
        }
        boolean z = false;
        if (this.cxA != null) {
            z = this.cxA.btO();
        }
        ex(z);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jn(int i) {
        ao aoVar = null;
        ajq();
        ajy();
        try {
            if (this.cxA != null) {
                this.cxU.a((ArrayList<com.baidu.adp.widget.ListView.f>) null, this.cxA);
                this.cye.ky(1);
                this.cxU.ajU();
                this.cyf.a(this.cxU.getListView(), this.cxA, this.cyd.anY());
                com.baidu.tieba.frs.tab.d a2 = a(this.cyf.alN(), this.cxA.btb());
                if (a2 != null && !TextUtils.isEmpty(a2.url)) {
                    aoVar = new ao();
                    aoVar.cBj = a2.url;
                    aoVar.stType = a2.name;
                }
                this.cyd.a(this.cxA.btb(), 0, aoVar);
                this.cyf.eU(false);
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
            if (dVar != null && dVar.cKT == i) {
                return dVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(boolean z, boolean z2) {
        try {
            if (this.cxA != null && this.cyf != null && this.cyd != null) {
                if (!this.cxU.akb().l(bh.Ys)) {
                    this.cxA.bty();
                }
                boolean v = com.baidu.tbadk.core.util.v.v(this.cxA.bto());
                this.cxU.eB(v);
                if (!v) {
                    if (this.cyy == null) {
                        this.cyy = new com.baidu.tieba.frs.g.e(this, (NoPressedRelativeLayout) this.mRootView);
                    }
                    if (this.blW == null) {
                        this.blW = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
                    }
                } else {
                    this.cyy = null;
                    this.blW = null;
                }
                if (this.cxA.aPU() != null) {
                    this.cxN = this.cxA.aPU().getName();
                    this.forumId = this.cxA.aPU().getId();
                }
                if (this.cxA.btO()) {
                    this.cyf.a(this.cxU.getListView(), this.cxA, this.cyd.anY());
                }
                if (z) {
                    t(true, z);
                } else {
                    t(this.cyc, z);
                }
                ajq();
                if (this.cyl != null) {
                    this.cyl.a(this.cye, this.cxA);
                }
                if (this.cxA.qv() != null) {
                    setHasMore(this.cxA.qv().qr());
                }
                ArrayList<com.baidu.adp.widget.ListView.f> a2 = this.cyp.a(z2, true, this.cxA.getThreadList(), null, z);
                if (a2 != null) {
                    this.cxA.az(a2);
                }
                if (this.cyd.anS() == 1) {
                    ajv();
                    if (!z && this.cyd.getPn() == 1) {
                        ajr();
                    }
                }
                this.cxC = this.cxA.anU();
                if (this.cxQ != null) {
                    this.cxP = true;
                    this.cxQ.tR(this.cxC);
                    com.baidu.tieba.frs.f.a.a(this, this.cxA.aPU(), this.cxA.getThreadList(), this.cxP, getPn());
                }
                if (this.cyn != null) {
                    this.cyn.aB(this.cyf.alO());
                }
                ajn();
                this.cxU.ajN();
                this.cxU.v(true, false);
                if (this.cxA != null && this.cxA.btr() != null && com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("frs_video_activity_guide", 0L) == 0) {
                    com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.f.7
                        @Override // java.lang.Runnable
                        public void run() {
                            f.this.cxU.akj();
                        }
                    }, 1000L);
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void ajr() {
        if (this.cys == null) {
            this.cys = new com.baidu.tieba.frs.live.a(this, com.baidu.adp.lib.g.b.g(this.forumId, 0));
        }
        this.cys.anA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.g gVar) {
        try {
            if (!this.cxY && gVar != null && this.cxA != null) {
                this.cxA.e(gVar);
                u(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void ex(boolean z) {
        if (this.cyd != null) {
            g(z, this.cyd.anO());
        } else {
            g(z, "normal_page");
        }
    }

    private void g(boolean z, String str) {
        ey("frs_page".equals(str));
        if (this.cyl != null) {
            this.cyl.a(z, this.cyf, this.cye, this.cxU, this.cxA);
        }
    }

    public void ey(boolean z) {
        if (this.cyq != null) {
            this.cyq.a(this.cxU, z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(d.h.frs_activity, viewGroup, false);
            this.cxI = new com.baidu.tieba.frs.entelechy.b();
            this.cyl = this.cxI.ald();
            this.cye = new com.baidu.tieba.frs.g.f(this, this.cxI);
            this.cyf = this.cxI.z(this);
            Intent intent = getActivity().getIntent();
            if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                this.cxK = true;
            }
            this.cxU = new i(this, this.cyT, this.cxI, this.cxK);
            this.cxU.setHeaderViewHeight(this.cyw);
        } else if (this.mRootView.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            this.cxU.aki();
        }
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Intent intent = getActivity().getIntent();
        this.ckH = System.currentTimeMillis();
        if (intent != null) {
            this.cxR = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.ckH = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            J(intent);
        }
        this.WI = System.currentTimeMillis();
        this.aJJ = this.WI - this.ckH;
        this.cxQ = new com.baidu.tieba.tbadkCore.data.e("frs", com.baidu.tieba.tbadkCore.data.e.gpM);
        this.cyd = new FrsModelController(this, this.cyO);
        this.cyd.a(this.cyE);
        this.cyd.init();
        if (intent != null) {
            this.cyd.h(intent.getExtras());
        } else if (bundle != null) {
            this.cyd.h(bundle);
        } else {
            this.cyd.h(null);
        }
        this.cyf.aw(this.cxU.VB());
        if (intent != null) {
            this.cye.k(intent.getExtras());
        } else if (bundle != null) {
            this.cye.k(bundle);
        } else {
            this.cye.k((Bundle) null);
        }
        this.cxT = getVoiceManager();
        this.cyt = new h(getPageContext(), this);
        initUI();
        initData(bundle);
        if (this.aiB != null && this.aiB.equals("from_tieba_kuang")) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12264").r("obj_type", 1).ac(ImageViewerConfig.FORUM_NAME, this.cyd.getForumName()));
            KuangFloatingViewController.getInstance().setNeedShowFloatingView(true);
            KuangFloatingViewController.getInstance().showFloatingView();
        }
        if (!ajE()) {
            this.cyj = new an(getActivity(), this.cxU, this.cye);
            this.cyj.eL(true);
        }
        this.cxT = getVoiceManager();
        if (this.cxT != null) {
            this.cxT.onCreate(getPageContext());
        }
        new com.baidu.tieba.frs.mc.g();
        this.cyp = new com.baidu.tieba.frs.mc.c(this, this.cyQ);
        this.cyh = new com.baidu.tieba.frs.smartsort.b(this);
        this.cyq = new com.baidu.tieba.frs.g.h(this);
        this.createTime = System.currentTimeMillis() - this.WI;
        this.cyn = new com.baidu.tieba.frs.g.a(getPageContext(), this.cyd.anZ());
        this.cyi = new com.baidu.tieba.frs.mc.b(this);
        this.cyo = new com.baidu.tieba.frs.mc.d(this);
        this.cyg = new com.baidu.tieba.frs.mc.f(this);
        this.cyr = new com.baidu.tieba.frs.mc.a(this);
        this.cyu = new com.baidu.tieba.frs.g.c(this);
        this.cyv = new com.baidu.tieba.frs.mc.e(this, getUniqueId());
        this.cyB = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "frs");
        registerListener(this.bjf);
        registerListener(this.mMemListener);
        registerListener(this.cyK);
        registerListener(this.cyR);
        registerListener(this.cyJ);
        registerListener(this.cyP);
        registerListener(this.cyG);
        registerListener(this.cyH);
        registerListener(this.cyI);
        registerListener(this.cyC);
        registerListener(this.cyD);
        registerListener(this.cyZ);
        registerListener(this.cyM);
        registerListener(this.cyN);
        this.cxU.eE(false);
        if (!ajE()) {
            showLoadingView(this.cxU.VB(), true);
            this.cyd.q(3, true);
        }
        super.onActivityCreated(bundle);
    }

    @Override // com.baidu.tieba.frs.ai
    public void Ob() {
        if (isAdded() && this.bne && !isLoadingViewAttached()) {
            showLoadingView(this.cxU.VB(), true);
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void Oc() {
        if (isAdded() && this.bne && isLoadingViewAttached()) {
            hideLoadingView(this.cxU.VB());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (ajE()) {
            showLoadingView(this.cxU.VB(), true);
            this.cxU.jq(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.cyd.q(3, true);
            getListView().setSelection(0);
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void setHeaderViewHeight(int i) {
        this.cyw = i;
        if (this.cxU != null) {
            this.cxU.setHeaderViewHeight(this.cyw);
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        if (sVar != null) {
            this.aMH = sVar.Hj();
            this.cyx = sVar.Hk();
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void showFloatingView() {
        if (this.aMH != null) {
            this.aMH.ca(true);
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
            this.cxN = data.getQueryParameter("name");
            this.aiB = data.getQueryParameter("from");
            if (!StringUtils.isNull(this.cxN)) {
                intent.putExtra("name", this.cxN);
            }
            if (!StringUtils.isNull(this.aiB)) {
                intent.putExtra("from", this.aiB);
            }
            TiebaStatic.log("c10105");
        }
        if (StringUtils.isNull(this.cxN)) {
            this.cxN = com.baidu.tieba.frs.f.i.L(intent);
            if (!StringUtils.isNull(this.cxN)) {
                intent.putExtra("name", this.cxN);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.cxT = getVoiceManager();
        if (this.cxT != null) {
            this.cxT.onStart(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        Intent intent;
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.cyW);
        if (bundle != null) {
            this.cxN = bundle.getString("name");
            this.aiB = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
            this.cxN = intent.getStringExtra("name");
            this.aiB = intent.getStringExtra("from");
            this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
        }
        if (TextUtils.isEmpty(this.aiB) || FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.aiB)) {
        }
        if (this.mIsLogin) {
            registerListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL, this.cyW);
        }
        this.cye.k(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.cyZ);
        if (this.cxT != null) {
            this.cxT.onDestory(getPageContext());
        }
        this.cxT = null;
        com.baidu.tieba.card.u.aaj().dF(false);
        if (this.cxA != null && this.cxA.aPU() != null) {
            ad.aku().bg(com.baidu.adp.lib.g.b.c(this.cxA.aPU().getId(), 0L));
        }
        if (this.cys != null) {
            this.cys.onDestory();
        }
        if (this.cxU != null) {
            com.baidu.tieba.frs.f.h.a(this.cxU, this.cxA, getForumId(), false, null);
            this.cxU.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.cya != null) {
                this.cya.onDestroy();
            }
            this.cxU.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.cyd.onActivityDestroy();
        this.cye.onActivityDestroy();
        if (this.cyb != null) {
            this.cyb.cancel(true);
            this.cyb = null;
        }
        if (this.cyd != null) {
            this.cyd.PA();
        }
        if (this.cyj != null) {
            this.cyj.Hi();
        }
        if (this.cym != null) {
            this.cym.destory();
        }
        if (this.cyn != null) {
            this.cyn.destory();
        }
        if (this.cyh != null) {
            this.cyh.onDestroy();
        }
        if (this.cyy != null) {
            this.cyy.onDestory();
        }
        if (this.cyr != null) {
            this.cyr.onDestroy();
        }
        if (this.cyB != null) {
            this.cyB.onDestroy();
        }
        com.baidu.tieba.recapp.e.a.bjQ().bjS();
        com.baidu.tieba.frs.f.j.aoA();
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.cxN);
        bundle.putString("from", this.aiB);
        this.cyd.onSaveInstanceState(bundle);
        if (this.cxT != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            this.cxT.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.cyr != null) {
            this.cyr.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.cxU != null) {
            this.cxU.ajR();
            this.cxU.onResume();
        }
        this.cyf.a(this.cyF);
        this.cyg.fh(true);
        this.cyc = true;
        if (cxL) {
            cxL = false;
            this.cxU.startPullRefresh();
            return;
        }
        if (this.cxT != null) {
            this.cxT.onResume(getPageContext());
        }
        this.cxU.eF(false);
        registerListener(this.cyS);
        if (this.cyz) {
            cm(6);
            this.cyz = false;
        }
        KuangFloatingViewController.getInstance().showFloatingView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        refresh();
    }

    public boolean ajs() {
        Intent intent;
        if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
            return false;
        }
        return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
    }

    public void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.cxN = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.aiB = intent.getStringExtra("from");
            }
            this.cxO = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.cxO) {
                ajt();
            }
            if (this.aiB != null && this.aiB.equals("from_tieba_kuang")) {
                KuangFloatingViewController.getInstance().setNeedShowFloatingView(true);
                KuangFloatingViewController.getInstance().showFloatingView();
            }
        }
    }

    private void ajt() {
        this.cxU.startPullRefresh();
    }

    public void closeActivity() {
        com.baidu.tieba.frs.f.i.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.aiB);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.cxU.setTitle(this.cxN);
        } else {
            this.cxU.setTitle("");
            this.mFlag = 1;
        }
        this.cye.d(this.cxU.getListView());
        this.cxU.setOnAdapterItemClickListener(this.cyX);
        this.cxU.setOnScrollListener(this.cyU);
        this.cxU.h(this.cwk);
        this.cxU.akb().a(this.cyV);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cxU.onChangeSkinType(i);
        this.cye.kx(i);
        this.cyf.onChangeSkinType(i);
    }

    public void jo(int i) {
        if (!this.mIsLogin) {
            if (this.cxA != null && this.cxA.qf() != null) {
                this.cxA.qf().setIfpost(1);
            }
            if (i == 0) {
                ax.aS(getActivity());
            }
        } else if (this.cxA != null) {
            if (i == 0) {
                com.baidu.tieba.frs.f.j.b(this, 0);
            } else {
                this.cxU.ajT();
            }
        }
    }

    public void refresh() {
        cm(3);
    }

    public void cm(int i) {
        this.cxY = false;
        ajy();
        if (this.cxU.ajJ() != null) {
            this.cxU.ajJ().atL();
        }
        this.cyd.q(i, true);
    }

    private void aju() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.g.h.fQ().d(new Runnable() { // from class: com.baidu.tieba.frs.f.15
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.sG(f.this.cxN);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajv() {
        ajy();
        try {
            if (this.cxA != null) {
                this.cxU.Oo();
                this.cxU.eA(this.cyd.anT());
                if (com.baidu.tieba.frs.g.f.i(this.cxA) && !com.baidu.tieba.frs.g.f.h(this.cxA)) {
                    this.cxU.akg();
                }
                if (this.cxA.aPU() != null) {
                    this.cxN = this.cxA.aPU().getName();
                    this.forumId = this.cxA.aPU().getId();
                }
                if (this.cxA.qv() != null) {
                    setHasMore(this.cxA.qv().qr());
                }
                this.cxU.setTitle(this.cxN);
                this.cxU.setForumName(this.cxN);
                TbadkCoreApplication.getInst().setDefaultBubble(this.cxA.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.cxA.getUserData().getBimg_end_time());
                aju();
                ajw();
                ArrayList<com.baidu.adp.widget.ListView.f> threadList = this.cxA.getThreadList();
                if (threadList != null) {
                    this.cxU.a(threadList, this.cxA);
                    com.baidu.tieba.frs.f.c.j(this.cxU);
                    this.cye.ky(getPageNum());
                    this.cye.f(this.cxA);
                    this.cyf.a(this.cxU.getListView(), this.cxA, this.cyd.anY());
                    this.cxU.ajU();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void ajw() {
        if (this.cxA != null) {
            if (this.cxA.aQi() == 1) {
                this.cxU.akb().setFromCDN(true);
            } else {
                this.cxU.akb().setFromCDN(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.cyg.fh(false);
        this.cyc = false;
        this.cxU.onPause();
        if (this.cxT != null) {
            this.cxT.onPause(getPageContext());
        }
        this.cxU.eF(true);
        if (this.cyn != null) {
            this.cyn.aoD();
        }
        MessageManager.getInstance().unRegisterListener(this.cyS);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.u.aaj().dF(false);
        if (this.cxA != null && this.cxA.aPU() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            com.baidu.tbadk.distribute.a.CE().a(getPageContext().getPageActivity(), "frs", this.cxA.aPU().getId(), 0L);
        }
        if (this.cxT != null) {
            this.cxT.onStop(getPageContext());
        }
        com.baidu.tieba.frs.f.i.a(getListView());
        this.cye.onActivityStop();
        t.Hm();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && this.cye != null) {
            this.cye.fj(isPrimary());
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || this.cxU == null) {
            return false;
        }
        return this.cxU.ajQ();
    }

    @Override // com.baidu.tieba.recapp.o
    public TbPageContext<?> xP() {
        return getPageContext();
    }

    @Override // com.baidu.tieba.recapp.o
    public void a(AdvertAppInfo advertAppInfo, String str) {
        com.baidu.tbadk.distribute.a.CE().a(advertAppInfo, this.forumId, 0L, "FRS", str, getPn());
    }

    @Override // com.baidu.tieba.recapp.o
    public void ajx() {
        ajf().ajx();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.cxT == null) {
            this.cxT = VoiceManager.instance();
        }
        return this.cxT;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public BdListView getListView() {
        if (this.cxU == null) {
            return null;
        }
        return this.cxU.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void ajy() {
        if (this.cxT != null) {
            this.cxT.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> wN() {
        if (this.aox == null) {
            this.aox = UserIconBox.i(getPageContext().getPageActivity(), 8);
        }
        return this.aox;
    }

    public void ajz() {
        if (getFragmentActivity() != null && getFragmentActivity().getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.a(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.g onGetPreLoadListView() {
        return getListView();
    }

    @Override // com.baidu.tieba.frs.ak
    public NavigationBar ajA() {
        if (this.cxU == null) {
            return null;
        }
        return this.cxU.ajA();
    }

    /* loaded from: classes.dex */
    private final class a implements com.baidu.adp.widget.ListView.h {
        private a() {
        }

        @Override // com.baidu.adp.widget.ListView.h
        public void a(View view, com.baidu.adp.widget.ListView.f fVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            boolean z;
            if (bdUniqueId != null) {
                if (bdUniqueId == p.cAt) {
                    if (f.this.cxU != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11752").ac(ImageViewerConfig.FORUM_ID, f.this.forumId).ac("obj_locate", "1"));
                        f.this.cxU.startPullRefresh();
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
                                if (readThreadHistory != null && !readThreadHistory.sM(bhVar.getId())) {
                                    readThreadHistory.sL(bhVar.getId());
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
                                    if (f.this.cyd.anS() == 5) {
                                        str = "c10387";
                                    }
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak(str).ac(ImageViewerConfig.FORUM_ID, f.this.forumId));
                                    com.baidu.tieba.frs.f.i.b(f.this, bhVar);
                                    if (f.this.cxA != null && f.this.cxA.aPU() != null) {
                                        com.baidu.tieba.frs.e.a aVar = new com.baidu.tieba.frs.e.a();
                                        aVar.cPn = f.this.cxA.gnK == 1;
                                        aVar.cPp = f.this.cxA.aPU().getId();
                                        aVar.cPo = f.this.ajf().anY();
                                        com.baidu.tieba.frs.e.b.aot().a(aVar, bhVar, 1);
                                    }
                                } else {
                                    if (tid.startsWith("pb:")) {
                                        bhVar.setId(tid.substring(3));
                                    }
                                    if (bdUniqueId.getId() == bh.ZB.getId()) {
                                        com.baidu.tieba.frs.f.h.a(bhVar.qZ());
                                    }
                                    com.baidu.tieba.frs.f.i.a(f.this, bhVar, i, z);
                                    com.baidu.tieba.frs.f.h.a(f.this, f.this.cxA, bhVar);
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
            hideNetRefreshView(this.cxU.VB());
            showLoadingView(this.cxU.VB(), true);
            this.cxU.eE(false);
            this.cyd.q(3, true);
        }
    }

    public com.baidu.tieba.tbadkCore.j ajB() {
        return this.cxA;
    }

    public boolean ajC() {
        return this.cxU.ajC();
    }

    public void Q(Object obj) {
        if (this.cyi != null && this.cyi.cOh != null) {
            this.cyi.cOh.f(obj);
        }
    }

    public void R(Object obj) {
        if (this.cyi != null && this.cyi.cOi != null) {
            this.cyi.cOi.f(obj);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.l.hy()) {
            this.cxU.abo();
        } else if (this.cyd.anS() == 1) {
            NX();
            NQ();
        } else if (this.cyd.hasMore()) {
            NQ();
        }
    }

    public void kU(String str) {
        NX();
        showToast(str);
    }

    public void H(ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        NX();
        if (!com.baidu.tbadk.core.util.v.v(arrayList)) {
            if (!this.cyd.aoc() && TbadkCoreApplication.getInst().isRecAppExist() && this.cyd.anS() == 1) {
                this.cxA.a(this, arrayList);
            }
            ArrayList<com.baidu.adp.widget.ListView.f> a2 = this.cyp.a(false, false, arrayList, this.cxQ);
            if (a2 != null) {
                this.cxA.az(a2);
                this.cxU.a(a2, this.cxA);
            }
            if (this.cyd != null) {
                com.baidu.tieba.frs.e.b.a(this.cxA, this.cyd.anY(), 2);
            }
        }
    }

    private void NX() {
        if (ajl() == 1 || this.cyp.aQ(this.cxA.bsM())) {
            this.cxU.ake();
        } else if (com.baidu.tbadk.core.util.v.v(this.cxA.getThreadList())) {
            this.cxU.abo();
        } else {
            this.cxU.akf();
        }
    }

    @Override // com.baidu.tieba.frs.mc.j
    public void NQ() {
        if (this.cyp != null) {
            this.cyp.a(this.cxN, this.forumId, this.cxA);
        }
    }

    public void ajD() {
        if (!com.baidu.tbadk.core.util.ab.e(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.ai.c(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return ajE() ? "a034" : "a006";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (!ajE()) {
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

    public void ez(boolean z) {
        if (this.cyj != null) {
            this.cyj.eL(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.cyk.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a gd(int i) {
        return this.cyk.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        this.cyt.b(bVar);
    }

    public boolean ajE() {
        return this.cxK;
    }

    @Override // com.baidu.tieba.frs.ai
    public void Oa() {
        if (this.cxU != null) {
            showFloatingView();
            this.cxU.getListView().setSelection(0);
            this.cxU.startPullRefresh();
        }
    }

    public ForumWriteData ajF() {
        if (this.cxA == null || this.cxA.aPU() == null) {
            return null;
        }
        ForumData aPU = this.cxA.aPU();
        ForumWriteData forumWriteData = new ForumWriteData(aPU.getId(), aPU.getName(), aPU.getPrefixData(), this.cxA.qf());
        forumWriteData.setForumLevel(aPU.getUser_level());
        forumWriteData.setAvatar(this.cxA.aPU().getImage_url());
        return forumWriteData;
    }

    @Override // com.baidu.tieba.frs.ai
    public void wB() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void cE(boolean z) {
        if (this.cxU != null) {
            this.cxU.cE(z);
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void setVideoThreadId(String str) {
    }
}
