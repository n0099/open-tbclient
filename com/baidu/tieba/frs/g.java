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
public class g extends BaseFragment implements BdListView.e, a.InterfaceC0022a, UserIconBox.b, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, aj, al, an, com.baidu.tieba.frs.mc.j, com.baidu.tieba.recapp.o {
    public static boolean cHd = false;
    public static volatile long cHn = 0;
    public static volatile long cHo = 0;
    public static volatile int cHp = 0;
    private com.baidu.tbadk.util.r aNo;
    private com.baidu.adp.lib.e.b<TbImageView> aoU;
    private com.baidu.tieba.frs.gametab.b bsF;
    private ao cHA;
    private com.baidu.tieba.frs.entelechy.b.b cHC;
    private com.baidu.tbadk.h.a cHD;
    private com.baidu.tieba.frs.g.a cHE;
    private com.baidu.tieba.frs.mc.d cHF;
    private com.baidu.tieba.frs.mc.c cHG;
    private com.baidu.tieba.frs.g.h cHH;
    private com.baidu.tieba.frs.mc.a cHI;
    private com.baidu.tieba.frs.live.a cHJ;
    private i cHK;
    public com.baidu.tieba.frs.g.c cHL;
    private com.baidu.tieba.frs.mc.e cHM;
    private int cHN;
    private View.OnTouchListener cHO;
    private com.baidu.tieba.frs.view.b cHP;
    private com.baidu.tieba.frs.g.e cHQ;
    private boolean cHR;
    private com.baidu.tieba.NEGFeedBack.a cHT;
    private com.baidu.tieba.frs.entelechy.b cHa;
    public bd cHe;
    private com.baidu.tieba.tbadkCore.data.e cHi;
    private VoiceManager cHl;
    private FrsModelController cHu;
    private com.baidu.tieba.frs.g.f cHv;
    private com.baidu.tieba.frs.entelechy.b.d cHw;
    private com.baidu.tieba.frs.mc.f cHx;
    private com.baidu.tieba.frs.smartsort.b cHy;
    private com.baidu.tieba.frs.mc.b cHz;
    public View mRootView;
    public boolean cHb = false;
    private boolean cHc = false;
    public String cHf = null;
    public String mFrom = null;
    public int mFlag = 0;
    private boolean cHg = false;
    private String mThreadId = null;
    public String forumId = null;
    private int cGU = 0;
    private boolean cHh = false;
    private boolean cHj = false;
    private boolean cHk = false;
    private j cHm = null;
    public final bd bku = null;
    private com.baidu.tieba.tbadkCore.k cGS = new com.baidu.tieba.tbadkCore.k();
    public long ctz = -1;
    public long aKz = 0;
    public long aKr = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean cHq = false;
    private boolean cHr = false;
    public com.baidu.tbadk.k.d cHs = null;
    private boolean cHt = true;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> cHB = new SparseArray<>();
    private boolean btP = true;
    private boolean cHS = false;
    private final CustomMessageListener cHU = new CustomMessageListener(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED) { // from class: com.baidu.tieba.frs.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof bd) {
                    com.baidu.tieba.frs.f.g.a(g.this.cHm, g.this.cGS, g.this.getForumId(), true, (bd) data);
                }
            }
        }
    };
    private CustomMessageListener cHV = new CustomMessageListener(CmdConfigCustom.CMD_CLOSE_GAME_RANK_CARD) { // from class: com.baidu.tieba.frs.g.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (g.this.cGS != null) {
                g.this.cGS.bvW();
                if (g.this.cHm != null) {
                    g.this.cHm.adf();
                }
            }
        }
    };
    private final am cHW = new am() { // from class: com.baidu.tieba.frs.g.23
        @Override // com.baidu.tieba.frs.am
        public void a(int i, int i2, as asVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
            g.this.alq();
            if (g.this.cHC != null) {
                g.this.cHv.fC(g.this.cHC.kf(i));
            }
            d.a aVar = new d.a();
            if (asVar != null) {
                aVar.isSuccess = asVar.errCode == 0;
                aVar.errorCode = asVar.errCode;
                aVar.errorMsg = asVar.errMsg;
                if (aVar.isSuccess) {
                    if (com.baidu.tbadk.core.util.v.w(arrayList)) {
                        g.this.cHm.adg();
                    } else if (asVar.hasMore) {
                        if (com.baidu.tbadk.core.util.v.v(g.this.cGS.getThreadList()) > 3) {
                            g.this.cHm.amh();
                        } else {
                            g.this.cHm.amj();
                        }
                    } else if (asVar.cKE) {
                        g.this.cHm.ami();
                    } else {
                        g.this.cHm.adg();
                    }
                }
            } else {
                asVar = new as();
                asVar.pn = 1;
                asVar.hasMore = false;
                asVar.cKE = false;
            }
            if (i == 1) {
                g.this.cHt = true;
                g.this.cIg.a(g.this.cHu.getType(), false, aVar);
            } else {
                g.this.a(aVar);
                if (g.this.cHu.aoI() != null) {
                    g.this.cGS = g.this.cHu.aoI();
                }
                g.this.aly();
            }
            if (g.this.cIq != null) {
                g.this.cIq.a(i, i2, asVar, arrayList);
            }
        }
    };
    private ak cHX = new ak() { // from class: com.baidu.tieba.frs.g.24
        @Override // com.baidu.tieba.frs.ak
        public void a(am amVar) {
        }

        @Override // com.baidu.tieba.frs.ak
        public void a(int i, int i2, ap apVar) {
            if (i != 1) {
                s.abW().dU(false);
            }
            if (i == 1) {
                g.this.cHm.eV(true);
                g.this.cHm.eU(false);
            } else {
                g.this.cHm.eW(true);
                g.this.cHm.eU(true);
            }
            g.this.alB();
            g.this.cHu.a(i, i2, apVar);
        }

        @Override // com.baidu.tieba.frs.ak
        public void init() {
        }

        @Override // com.baidu.tieba.frs.ak
        public void QJ() {
        }
    };
    private CustomMessageListener cHY = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIVE_COUNT) { // from class: com.baidu.tieba.frs.g.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                ((com.baidu.tieba.frs.entelechy.c.a) g.this.cHw).kh(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    };
    private CustomMessageListener cHZ = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_LIVE_START) { // from class: com.baidu.tieba.frs.g.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && ((Integer) customResponsedMessage.getData()).intValue() == 51 && g.this.cGS != null) {
                com.baidu.tieba.frs.f.i.a(g.this.cGS, g.this.getPageContext());
            }
        }
    };
    private final CustomMessageListener cIa = new CustomMessageListener(CmdConfigCustom.CMD_FRS_SELECT_ALA_LIVE_TAB) { // from class: com.baidu.tieba.frs.g.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (g.this.cHw instanceof com.baidu.tieba.frs.entelechy.c.a) && ((com.baidu.tieba.frs.entelechy.c.a) g.this.cHw).anY() != null) {
                ((com.baidu.tieba.frs.entelechy.c.a) g.this.cHw).anY().kQ(49);
            }
        }
    };
    private final CustomMessageListener cIb = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.frs.g.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && g.this.cGS != null && g.this.cGS.aRo() != null) {
                SignData signData = (SignData) customResponsedMessage.getData();
                int user_level = g.this.cGS.aRo().getUser_level();
                if (signData.forumId != null && signData.forumId.equals(g.this.cGS.aRo().getId())) {
                    g.this.cGS.d(signData);
                    g.this.cHv.h(g.this.cGS);
                    if (g.this.cHv.aqX()) {
                        i = g.this.cGS.aRo().getUser_level();
                        if (user_level >= i) {
                            i++;
                        }
                    } else {
                        i = user_level;
                    }
                    TbadkCoreApplication.getInst().addSignedForum(g.this.cGS.aRo().getName(), signData.sign_bonus_point, i);
                }
            }
        }
    };
    private final CustomMessageListener cIc = new CustomMessageListener(CmdConfigCustom.CMD_FRS_EXPERIENCE_TIP) { // from class: com.baidu.tieba.frs.g.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.q) && g.this.cGS != null) {
                g.this.cGS.c((com.baidu.tieba.tbadkCore.q) customResponsedMessage.getData());
                g.this.cHv.g(g.this.cGS);
                g.this.cHw.a(g.this.cHm.getListView(), g.this.cGS, g.this.cHu.aqb());
            }
        }
    };
    private final AntiHelper.a cId = new AntiHelper.a() { // from class: com.baidu.tieba.frs.g.2
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12536").r("obj_locate", ap.a.ahP));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12535").r("obj_locate", ap.a.ahP));
        }
    };
    private CustomMessageListener bpT = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.g.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(g.this.xR().getUniqueId())) {
                    if (updateAttentionMessage.getData().ass != null) {
                        if (AntiHelper.a(g.this.getActivity(), updateAttentionMessage.getData().ass, g.this.cId) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12534").r("obj_locate", ap.a.ahP));
                        }
                    } else if (updateAttentionMessage.getData().BJ && updateAttentionMessage.getData().isAttention) {
                        com.baidu.adp.lib.util.l.showToast(g.this.xR().getPageActivity(), d.j.attention_success);
                    }
                }
            }
        }
    };
    private CustomMessageListener cIe = new CustomMessageListener(CmdConfigCustom.CMD_STORY_READ_CACHE) { // from class: com.baidu.tieba.frs.g.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.story.process.b)) {
                com.baidu.tieba.story.process.b bVar = (com.baidu.tieba.story.process.b) customResponsedMessage.getData();
                if (g.this.forumId != null && g.this.forumId.equals(String.valueOf(bVar.forumId)) && bVar.state == 3 && g.this.alE() != null && !com.baidu.tbadk.core.util.v.w(g.this.alE().buO()) && g.this.cHa.anj() != null && g.this.cHa.anj().any() != null) {
                    List<com.baidu.adp.widget.ListView.f> buO = g.this.alE().buO();
                    int size = buO.size();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= size) {
                            i = -1;
                            break;
                        } else if ((buO.get(i2) instanceof com.baidu.tbadk.data.g) && TbadkCoreApplication.getCurrentAccount().equals(String.valueOf(((com.baidu.tbadk.data.g) buO.get(i2)).user_id))) {
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
                    gVar.aAv = String.valueOf(g.this.forumId);
                    gVar.aAu = bVar;
                    if (i != -1) {
                        buO.set(i, gVar);
                    } else {
                        buO.add(1, gVar);
                    }
                    g.this.cHa.anj().any().b(buO, g.this.forumId, g.this.getThreadId());
                }
            }
        }
    };
    private CustomMessageListener cIf = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.frs.g.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                g.this.cHm.c((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.m cIg = new com.baidu.tieba.tbadkCore.m() { // from class: com.baidu.tieba.frs.g.6
        private long startTime = 0;

        @Override // com.baidu.tieba.tbadkCore.m
        public void jP(int i) {
            this.startTime = System.nanoTime();
            if (g.this.cHm != null) {
                switch (i) {
                    case 1:
                    case 2:
                        g.this.cHm.alU();
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
            if (g.this.btP) {
                g.this.btP = false;
                com.baidu.tieba.frs.f.g.a(g.this.cHm, g.this.cGS, g.this.getForumId(), false, null);
            }
            g.this.alq();
            g.this.cHq = true;
            if (aVar != null && aVar.isSuccess) {
                g.this.cHm.ame().fj(com.baidu.tbadk.core.util.an.vs().vu());
                g.cHn = 0L;
                g.cHo = 0L;
                g.cHp = 0;
            } else {
                g.cHp = 1;
            }
            if (!g.this.cHu.aqf() && (i == 3 || i == 6)) {
                g.this.cHG.resetData();
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (g.this.cHu.aoI() != null) {
                g.this.cGS = g.this.cHu.aoI();
            }
            if (i == 7) {
                g.this.jN(g.this.cGS.bvo());
                return;
            }
            if (g.this.cGS.qy() != null) {
                g.this.setHasMore(g.this.cGS.qy().qu());
            }
            g.this.alr();
            if (i == 4) {
                if (!g.this.cHu.aqf() && TbadkCoreApplication.getInst().isRecAppExist() && g.this.cHu.apV() == 1) {
                    g.this.cGS.a(g.this);
                }
                ArrayList<com.baidu.adp.widget.ListView.f> a2 = g.this.cHG.a(false, false, g.this.cGS.getThreadList(), g.this.cHi);
                if (a2 != null) {
                    g.this.cGS.aA(a2);
                    g.this.cGS.bvN();
                    g.this.cHm.a(a2, g.this.cGS);
                }
                if (g.this.cHu != null) {
                    com.baidu.tieba.frs.e.b.a(g.this.cGS, g.this.cHu.aqb(), 2);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    g.this.cHm.alU();
                    break;
                case 2:
                    g.this.cHm.alU();
                    break;
                case 3:
                case 6:
                    if (g.this.cGS != null) {
                        g.this.cGS.bvL();
                    }
                    if (g.this.cHL != null) {
                        g.this.cHL.refresh();
                        break;
                    }
                    break;
            }
            g.this.als();
            if (aVar == null || aVar.errorCode == 0) {
                if (g.this.cGS != null) {
                    g.this.cHm.jR(i);
                    g.this.u(false, i == 5);
                    g.cHn = (System.nanoTime() - this.startTime) / 1000000;
                    if (aVar != null) {
                        g.cHo = aVar.gyM;
                    }
                } else {
                    return;
                }
            } else if (g.this.cGS == null || com.baidu.tbadk.core.util.v.w(g.this.cGS.getThreadList())) {
                g.this.a(aVar);
            } else if (aVar.gyL) {
                g.this.showToast(g.this.getPageContext().getResources().getString(d.j.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
            }
            if (g.this.cGS.buU() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11384"));
            }
            if (g.this.ctz > -1 && !g.this.cHS) {
                com.baidu.tieba.frs.f.g.a(g.this.cHu, g.this.ctz);
                g.this.ctz = -1L;
                g.this.cHS = true;
            }
            if (g.this.cHj && (g.this.cHw instanceof com.baidu.tieba.frs.entelechy.c.a) && ((com.baidu.tieba.frs.entelechy.c.a) g.this.cHw).anY() != null) {
                ((com.baidu.tieba.frs.entelechy.c.a) g.this.cHw).anY().kQ(49);
                g.this.cHj = false;
            }
            g.this.aKz = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.m
        public void b(com.baidu.tieba.tbadkCore.h hVar) {
            if (hVar != null) {
                if ("normal_page".equals(g.this.cHu.apR()) || "frs_page".equals(g.this.cHu.apR()) || "book_page".equals(g.this.cHu.apR())) {
                    g.this.a(hVar);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE, hVar));
                }
            }
        }
    };
    private final CustomMessageListener cIh = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.frs.g.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.k) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                g.this.cGS.a((com.baidu.tbadk.data.k) customResponsedMessage.getData());
                g.this.cHm.ame().notifyDataSetChanged();
            }
        }
    };
    private final CustomMessageListener mMemListener = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_MEM) { // from class: com.baidu.tieba.frs.g.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && g.this.cGS != null && (userData = g.this.cGS.getUserData()) != null) {
                userData.setIsMem(num.intValue());
                if (num.intValue() != 0) {
                    g.this.cHv.f(num);
                }
            }
        }
    };
    private final com.baidu.tieba.frs.mc.i cIi = new com.baidu.tieba.frs.mc.i() { // from class: com.baidu.tieba.frs.g.10
        @Override // com.baidu.tieba.frs.mc.i
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.f> arrayList, boolean z3) {
            if (g.this.cHy != null && g.this.cHu != null && g.this.cHu.aqf() && z && !z2 && !z3) {
                g.this.cHy.kK(i2);
            }
        }
    };
    public final View.OnTouchListener aNp = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.g.11
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (g.this.cHO != null) {
                g.this.cHO.onTouch(view, motionEvent);
            }
            if (g.this.cHA != null && g.this.cHA.amD() != null) {
                g.this.cHA.amD().onTouchEvent(motionEvent);
            }
            if (g.this.bsF != null) {
                g.this.bsF.d(view, motionEvent);
            }
            if (g.this.cHv != null) {
                g.this.cHv.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private final CustomMessageListener cIj = new CustomMessageListener(CmdConfigCustom.CMD_GOTOLIVE_HOST_UPGRADE) { // from class: com.baidu.tieba.frs.g.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "photolive_hostLevel", -1) != -1 && g.this.cGS.aRo() != null) {
                g.this.cGS.aRo().setCanAddPhotoLivePost(true);
            }
        }
    };
    private final CustomMessageListener cIk = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.frs.g.14
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
    public final View.OnClickListener cIl = new View.OnClickListener() { // from class: com.baidu.tieba.frs.g.16
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.this.cHm == null || view != g.this.cHm.alS() || g.this.getActivity() == null) {
                if (g.this.cGS != null && g.this.cGS.aRo() != null) {
                    if (g.this.cHm == null || view != g.this.cHm.alY()) {
                        if (g.this.cHm != null && view == g.this.cHm.alZ()) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12402").ac(ImageViewerConfig.FORUM_ID, g.this.cGS.aRo().getId()).ac("uid", TbadkCoreApplication.getCurrentAccount()).ac(ImageViewerConfig.FORUM_NAME, g.this.cGS.aRo().getName()));
                            if (!StringUtils.isNull(g.this.cGS.aRo().getName())) {
                                g.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PostSearchActivityConfig(g.this.getPageContext().getPageActivity(), g.this.cGS.aRo().getName(), g.this.cGS.aRo().getId())));
                                return;
                            }
                            return;
                        }
                    } else if (!StringUtils.isNull(g.this.cGS.aRo().getId())) {
                        if (g.this.cGS.aRo() != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12046").ac(ImageViewerConfig.FORUM_ID, g.this.cGS.aRo().getId()).r("obj_locate", g.this.alH() ? 1 : 2));
                        }
                        g.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(g.this.getPageContext().getPageActivity(), g.this.cGS.aRo().getId(), ForumDetailActivityConfig.FromType.FRS)));
                        return;
                    } else {
                        return;
                    }
                }
                if (view.getId() == d.g.game_activity_egg_layout && com.baidu.adp.lib.util.l.hy()) {
                    TiebaStatic.log("c10853");
                    if (g.this.cHm.amb()) {
                        g.this.cHm.amc();
                    } else {
                        String activityUrl = g.this.cGS.aRo().getYuleData().ta().getActivityUrl();
                        if (!StringUtils.isNull(activityUrl)) {
                            com.baidu.tbadk.browser.a.P(g.this.getPageContext().getPageActivity(), activityUrl);
                        }
                    }
                }
                if (view == g.this.cHm.amk() && g.this.cHu != null && g.this.cHu.hasMore()) {
                    g.this.cHm.amh();
                    g.this.OI();
                    return;
                }
                return;
            }
            g.this.getActivity().finish();
        }
    };
    private final AbsListView.OnScrollListener cIm = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.g.17
        private int cIt = 0;
        private int bjZ = 0;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (g.this.aNo != null && g.this.isPrimary()) {
                g.this.aNo.a(absListView, this.cIt, i, i2, i3);
            }
            if (g.this.cHw != null) {
                g.this.cHw.a(absListView, i, i2, i3, g.this.cHv.arb());
            }
            if (g.this.cHE != null) {
                g.this.cHE.aqG();
            }
            if (g.this.cHy != null) {
                g.this.cHy.aqq();
            }
            if (g.this.cHQ != null) {
                g.this.cHQ.onScroll(absListView, i, i2, i3);
            }
            if (g.this.cGS != null && g.this.cHm != null && g.this.cHm.ame() != null) {
                this.cIt = i;
                this.bjZ = (i + i2) - 1;
                g.this.cHm.az(this.cIt, this.bjZ);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (g.this.cHv != null) {
                g.this.cHv.setScrollState(i);
            }
            if (g.this.aNo != null && g.this.isPrimary()) {
                g.this.aNo.onScrollStateChanged(absListView, i);
            }
            if ((i == 2 || i == 1) && !g.this.cHr) {
                g.this.cHr = true;
                g.this.cHm.amg();
            }
            if (g.this.cHs == null && !g.this.alH()) {
                g.this.cHs = new com.baidu.tbadk.k.d();
                g.this.cHs.fr(1000);
            }
            if (i == 0) {
                s.abW().dU(true);
                g.this.cHm.ay(this.cIt, this.bjZ);
            }
            if (g.this.cHQ != null) {
                g.this.cHQ.onScrollStateChanged(absListView, i);
            }
            if (g.this.cHs != null) {
                g.this.cHs.Gi();
            }
            if (i == 0) {
                com.baidu.tieba.frs.f.g.a(g.this.cHm, g.this.cGS, g.this.getForumId(), false, null);
            }
        }
    };
    private final b cIn = new b() { // from class: com.baidu.tieba.frs.g.18
        @Override // com.baidu.tieba.frs.b
        public void a(int i, int i2, View view, View view2, bd bdVar) {
            if (i != g.this.cHm.ame().anF()) {
                if (i != g.this.cHm.ame().anG()) {
                    if (i != g.this.cHm.ame().anI()) {
                        if (i != g.this.cHm.ame().amt()) {
                            if (i == g.this.cHm.ame().anH() && g.this.cGS != null && g.this.cGS.getUserData() != null && g.this.cGS.getUserData().isBawu()) {
                                final String bvm = g.this.cGS.bvm();
                                if (!com.baidu.tbadk.core.util.am.isEmpty(bvm) && g.this.cGS.aRo() != null) {
                                    com.baidu.tieba.c.a.a(g.this.getPageContext(), g.this.cGS.aRo().getId(), g.this.cGS.aRo().getName(), new a.InterfaceC0092a() { // from class: com.baidu.tieba.frs.g.18.1
                                        @Override // com.baidu.tieba.c.a.InterfaceC0092a
                                        public void abr() {
                                            com.baidu.tbadk.browser.a.O(g.this.getPageContext().getPageActivity(), bvm);
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10502").ac(ImageViewerConfig.FORUM_ID, g.this.cGS.aRo().getId()).ac("uid", g.this.cGS.getUserData().getUserId()));
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        g.this.cHe = bdVar;
                        com.baidu.tieba.frs.f.h.a(g.this, g.this.cHe);
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10179").ac(ImageViewerConfig.FORUM_ID, g.this.getForumId()));
                        return;
                    }
                    com.baidu.tieba.frs.f.h.B(g.this);
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak(i == g.this.cHm.ame().anI() ? "c10177" : "c10244").ac(ImageViewerConfig.FORUM_ID, g.this.getForumId()));
                } else if (ax.aS(g.this.getPageContext().getPageActivity())) {
                    TiebaStatic.log("my_service_ck");
                    if (g.this.cGS != null && g.this.cGS.aRo() != null) {
                        ForumData aRo = g.this.cGS.aRo();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(g.this.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(aRo.getId(), 0L), aRo.getName(), aRo.getImage_url(), 0)));
                    }
                }
            } else if (ax.aS(g.this.getActivity())) {
                TiebaStatic.log("forum_fortune_click");
                com.baidu.tieba.frs.f.h.a(g.this.getPageContext(), g.this.cGS);
            }
        }
    };
    private final NoNetworkView.a cFA = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.g.19
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aJ(boolean z) {
            if (g.this.cHu.apV() == 1 && z && !g.this.cHm.alF()) {
                if (g.this.cGS == null || com.baidu.tbadk.core.util.v.w(g.this.cGS.getThreadList())) {
                    g.this.hideNetRefreshView(g.this.cHm.WQ());
                    g.this.showLoadingView(g.this.cHm.WQ(), true);
                    g.this.cHm.eW(false);
                    g.this.refresh();
                    return;
                }
                g.this.cHm.alU();
            }
        }
    };
    private final CustomMessageListener cIo = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.g.20
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                com.baidu.tieba.frs.f.c.a(customResponsedMessage, g.this.cHm, g.this.cGS);
            }
        }
    };
    private com.baidu.adp.widget.ListView.h cIp = new a();
    private am cIq = new am() { // from class: com.baidu.tieba.frs.g.21
        @Override // com.baidu.tieba.frs.am
        public void a(int i, int i2, as asVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
            com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tieba.frs.g.21.1
                @Override // java.lang.Runnable
                public void run() {
                    if (g.this.cHm != null && g.this.cHm.acW()) {
                        g.this.OI();
                    }
                }
            });
        }
    };
    private CustomMessageListener cIr = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.frs.g.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    g.this.cHR = true;
                }
            }
        }
    };

    public com.baidu.tieba.frs.entelechy.b.b ale() {
        return this.cHC;
    }

    public com.baidu.adp.widget.ListView.h alf() {
        return this.cIp;
    }

    public com.baidu.tieba.frs.mc.d alg() {
        return this.cHF;
    }

    public com.baidu.tieba.frs.smartsort.b alh() {
        return this.cHy;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public FrsModelController ali() {
        return this.cHu;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public com.baidu.tieba.frs.mc.c alj() {
        return this.cHG;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public com.baidu.tieba.frs.g.f alk() {
        return this.cHv;
    }

    public com.baidu.tieba.frs.entelechy.b.d all() {
        return this.cHw;
    }

    public ao alm() {
        return this.cHA;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public j aln() {
        return this.cHm;
    }

    @Override // com.baidu.tieba.frs.an
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.an
    public String getForumName() {
        return this.cHf;
    }

    public void setForumName(String str) {
        this.cHf = str;
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
        if (this.cHG == null) {
            return 1;
        }
        return this.cHG.getPn();
    }

    public int getPn() {
        if (this.cHG == null) {
            return 1;
        }
        return this.cHG.getPn();
    }

    public void setPn(int i) {
        if (this.cHG != null) {
            this.cHG.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.cHG != null) {
            this.cHG.setHasMore(i);
        }
    }

    public int alo() {
        if (this.cHG == null) {
            return -1;
        }
        return this.cHG.alo();
    }

    public boolean alp() {
        return this.cHk;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d.a aVar) {
        if (aVar == null) {
            String string = TbadkCoreApplication.getInst().getString(d.j.error_unkown_try_again);
            this.cHm.alP();
            showNetRefreshView(this.cHm.WQ(), string, true);
        } else if (340001 == aVar.errorCode) {
            a(aVar, this.cGS.buR());
        } else {
            if (com.baidu.tbadk.core.util.v.w(this.cGS.getThreadList())) {
                b(aVar);
            }
            if (alH()) {
                setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst(), d.e.ds280));
            } else {
                setNetRefreshViewEmotionDefMarginTop();
            }
        }
    }

    public void a(View view, String str, boolean z, List<RecmForumInfo> list) {
        this.cHm.alP();
        if (this.cHP == null) {
            this.cHP = new com.baidu.tieba.frs.view.b(getPageContext(), getNetRefreshListener());
        }
        this.cHP.gB(str);
        this.cHP.bn(list);
        this.cHP.c(view, z);
    }

    private void a(d.a aVar, List<RecmForumInfo> list) {
        if (this.cHm != null) {
            this.cHm.alP();
            this.cHm.setTitle(this.cHf);
        }
        a(this.cHm.WQ(), aVar.errorMsg, true, list);
    }

    private void b(d.a aVar) {
        this.cHm.alP();
        if (aVar.gyL) {
            showNetRefreshView(this.cHm.WQ(), TbadkCoreApplication.getInst().getString(d.j.net_error_text, new Object[]{aVar.errorMsg, Integer.valueOf(aVar.errorCode)}), true);
        } else {
            showNetRefreshView(this.cHm.WQ(), aVar.errorMsg, true);
        }
    }

    public void alq() {
        hideLoadingView(this.cHm.WQ());
        this.cHm.ama();
        if (this.cHm.alN() instanceof com.baidu.tieba.frs.tab.c) {
            ((com.baidu.tieba.frs.tab.c) this.cHm.alN()).aqA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alr() {
        if (alo() == 0 && com.baidu.tbadk.core.util.v.w(this.cGS.bva())) {
            if (com.baidu.tbadk.core.util.v.w(this.cGS.getThreadList())) {
                this.cHm.adg();
            } else {
                this.cHm.ami();
            }
        } else if (com.baidu.tbadk.core.util.v.v(this.cGS.getThreadList()) > 3) {
            this.cHm.amh();
        } else {
            this.cHm.amj();
        }
    }

    public void a(ErrorData errorData) {
        alq();
        this.cHm.alU();
        d.a apS = this.cHu.apS();
        boolean w = com.baidu.tbadk.core.util.v.w(this.cGS.getThreadList());
        if (apS != null && w) {
            if (w) {
                if (this.cHu.apT() != 0) {
                    this.cHu.apZ();
                    this.cHm.alU();
                } else {
                    a(apS);
                }
                this.cHm.v(this.cGS.bwc(), false);
                return;
            } else if (apS.gyL) {
                this.cHm.v(true, false);
                showToast(getPageContext().getResources().getString(d.j.net_error_text, apS.errorMsg, Integer.valueOf(apS.errorCode)));
                return;
            } else {
                return;
            }
        }
        a(apS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void als() {
        if (this.cGS == null || this.cGS.aRo() != null) {
            this.cHm.amd();
        } else if (this.cGS.aRo().getYuleData() != null && this.cGS.aRo().getYuleData().sZ()) {
            TiebaStatic.log("c10852");
            this.cHm.a(this.cGS.aRo().getYuleData().ta());
        } else {
            this.cHm.amd();
        }
    }

    private void t(boolean z, boolean z2) {
        if (this.cHu != null && this.cGS != null && this.cHm != null && z) {
            if (!this.cHu.aqf() && this.cHu.apV() == 1) {
                if (!this.cHu.aqd()) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        this.cGS.bvU();
                        this.cGS.bvP();
                    }
                    this.cGS.bvS();
                    this.cGS.bvT();
                }
                boolean z3 = false;
                if (this.cHm.ame().l(com.baidu.tieba.card.data.p.cem)) {
                    z3 = this.cGS.bvX();
                }
                if (!z3) {
                    this.cGS.bvV();
                }
                if (TbadkCoreApplication.getInst().isRecAppExist()) {
                    this.cGS.a(this);
                }
                if (!this.cHm.ame().l(bd.YH)) {
                    this.cGS.bvM();
                }
                this.cGS.bvY();
            }
            if (!this.cHm.ame().l(bd.YH)) {
                this.cGS.bvR();
            } else {
                this.cGS.bvQ();
            }
            this.cGS.bvN();
            this.cGS.bvK();
            if (this.cHm.ame().l(com.baidu.tieba.g.b.dio)) {
                this.cGS.na(z2);
            }
            if (TbadkCoreApplication.isLogin() && (!this.cHu.aqf() || this.cHu.isNetFirstLoad)) {
                this.cGS.bvZ();
            }
            this.cGS.bwa();
        }
    }

    public boolean alt() {
        if (this.cHw != null && this.cHm != null) {
            this.cHw.b(this.cHm.getListView());
        }
        if (this.cHv != null && this.cHu != null) {
            this.cHv.a(this.cHu.apR(), this.cGS);
        }
        boolean z = false;
        if (this.cGS != null) {
            z = this.cGS.bwd();
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
            if (this.cGS != null) {
                this.cHm.a((ArrayList<com.baidu.adp.widget.ListView.f>) null, this.cGS);
                this.cHv.kY(1);
                this.cHm.alX();
                this.cHw.a(this.cHm.getListView(), this.cGS, this.cHu.aqb());
                com.baidu.tieba.frs.tab.d a2 = a(this.cHw.anR(), this.cGS.bvo());
                if (a2 != null && !TextUtils.isEmpty(a2.url)) {
                    apVar = new ap();
                    apVar.cKB = a2.url;
                    apVar.stType = a2.name;
                }
                this.cHu.a(this.cGS.bvo(), 0, apVar);
                this.cHw.fm(false);
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
            if (this.cGS != null && this.cHw != null && this.cHu != null) {
                if (!this.cHm.ame().l(bd.YH)) {
                    this.cGS.bvM();
                }
                boolean w = com.baidu.tbadk.core.util.v.w(this.cGS.bvB());
                this.cHm.eT(w);
                if (!w) {
                    if (this.cHQ == null) {
                        this.cHQ = new com.baidu.tieba.frs.g.e(this, (NoPressedRelativeLayout) this.mRootView);
                    }
                    if (this.bsF == null) {
                        this.bsF = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
                    }
                } else {
                    this.cHQ = null;
                    this.bsF = null;
                }
                if (this.cGS.aRo() != null) {
                    this.cHf = this.cGS.aRo().getName();
                    this.forumId = this.cGS.aRo().getId();
                }
                if (this.cGS.bwd()) {
                    this.cHw.a(this.cHm.getListView(), this.cGS, this.cHu.aqb());
                }
                if (z) {
                    t(true, z);
                } else {
                    t(this.cHt, z);
                }
                alt();
                if (this.cHC != null) {
                    this.cHC.a(this.cHv, this.cGS);
                }
                if (this.cGS.qy() != null) {
                    setHasMore(this.cGS.qy().qu());
                }
                ArrayList<com.baidu.adp.widget.ListView.f> a2 = this.cHG.a(z2, true, this.cGS.getThreadList(), null, z);
                if (a2 != null) {
                    this.cGS.aA(a2);
                }
                if (this.cHu.apV() == 1) {
                    aly();
                    if (!z && this.cHu.getPn() == 1) {
                        alu();
                    }
                }
                this.cGU = this.cGS.apX();
                if (this.cHi != null) {
                    this.cHh = true;
                    this.cHi.us(this.cGU);
                    com.baidu.tieba.frs.f.a.a(this, this.cGS.aRo(), this.cGS.getThreadList(), this.cHh, getPn());
                }
                if (this.cHE != null) {
                    this.cHE.aF(this.cHw.anS());
                }
                alq();
                this.cHm.alQ();
                this.cHm.v(true, false);
                if (this.cGS.aRo() != null) {
                    this.cHm.lc(this.cGS.aRo().getWarningMsg());
                }
                if (this.cGS != null && this.cGS.bvE() != null && com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("frs_video_activity_guide", 0L) == 0) {
                    com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.g.7
                        @Override // java.lang.Runnable
                        public void run() {
                            g.this.cHm.amo();
                        }
                    }, 1000L);
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void alu() {
        if (this.cHJ == null) {
            this.cHJ = new com.baidu.tieba.frs.live.a(this, com.baidu.adp.lib.g.b.g(this.forumId, 0));
        }
        this.cHJ.apD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.h hVar) {
        try {
            if (!this.cHq && hVar != null && this.cGS != null) {
                this.cGS.e(hVar);
                u(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void eP(boolean z) {
        if (this.cHu != null) {
            g(z, this.cHu.apR());
        } else {
            g(z, "normal_page");
        }
    }

    private void g(boolean z, String str) {
        eQ("frs_page".equals(str));
        if (this.cHC != null) {
            this.cHC.a(z, this.cHw, this.cHv, this.cHm, this.cGS);
        }
    }

    public void eQ(boolean z) {
        if (this.cHH != null) {
            this.cHH.a(this.cHm, z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(d.h.frs_activity, viewGroup, false);
            this.cHa = new com.baidu.tieba.frs.entelechy.b();
            this.cHC = this.cHa.ani();
            this.cHv = new com.baidu.tieba.frs.g.f(this, this.cHa);
            this.cHw = this.cHa.z(this);
            Intent intent = getActivity().getIntent();
            if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                this.cHc = true;
            }
            this.cHm = new j(this, this.cIl, this.cHa, this.cHc);
            this.cHm.setHeaderViewHeight(this.cHN);
        } else if (this.mRootView.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            this.cHm.amn();
        }
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Intent intent = getActivity().getIntent();
        this.ctz = System.currentTimeMillis();
        if (intent != null) {
            this.cHj = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.ctz = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            J(intent);
        }
        this.beginTime = System.currentTimeMillis();
        this.aKr = this.beginTime - this.ctz;
        this.cHi = new com.baidu.tieba.tbadkCore.data.e("frs", com.baidu.tieba.tbadkCore.data.e.gBs);
        this.cHu = new FrsModelController(this, this.cIg);
        this.cHu.a(this.cHW);
        this.cHu.init();
        if (intent != null) {
            this.cHu.h(intent.getExtras());
        } else if (bundle != null) {
            this.cHu.h(bundle);
        } else {
            this.cHu.h(null);
        }
        this.cHw.az(this.cHm.WQ());
        if (intent != null) {
            this.cHv.k(intent.getExtras());
        } else if (bundle != null) {
            this.cHv.k(bundle);
        } else {
            this.cHv.k((Bundle) null);
        }
        this.cHl = getVoiceManager();
        this.cHK = new i(getPageContext(), this);
        initUI();
        initData(bundle);
        if (this.mFrom != null && this.mFrom.equals("from_tieba_kuang")) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12264").r("obj_type", 1).ac(ImageViewerConfig.FORUM_NAME, this.cHu.getForumName()));
            KuangFloatingViewController.getInstance().setNeedShowFloatingView(true);
            KuangFloatingViewController.getInstance().showFloatingView();
        }
        if (!alH()) {
            this.cHA = new ao(getActivity(), this.cHm, this.cHv);
            this.cHA.fd(true);
        }
        this.cHl = getVoiceManager();
        if (this.cHl != null) {
            this.cHl.onCreate(getPageContext());
        }
        new com.baidu.tieba.frs.mc.g();
        this.cHG = new com.baidu.tieba.frs.mc.c(this, this.cIi);
        this.cHy = new com.baidu.tieba.frs.smartsort.b(this);
        this.cHH = new com.baidu.tieba.frs.g.h(this);
        this.createTime = System.currentTimeMillis() - this.beginTime;
        this.cHE = new com.baidu.tieba.frs.g.a(getPageContext(), this.cHu.aqc());
        this.cHz = new com.baidu.tieba.frs.mc.b(this);
        this.cHF = new com.baidu.tieba.frs.mc.d(this);
        this.cHx = new com.baidu.tieba.frs.mc.f(this);
        this.cHI = new com.baidu.tieba.frs.mc.a(this);
        this.cHL = new com.baidu.tieba.frs.g.c(this);
        this.cHM = new com.baidu.tieba.frs.mc.e(this, getUniqueId());
        this.cHT = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "frs");
        registerListener(this.bpT);
        registerListener(this.mMemListener);
        registerListener(this.cIc);
        registerListener(this.cIj);
        registerListener(this.cIb);
        registerListener(this.cIh);
        registerListener(this.cHY);
        registerListener(this.cHZ);
        registerListener(this.cIa);
        registerListener(this.cHU);
        registerListener(this.cHV);
        registerListener(this.cIr);
        registerListener(this.cIe);
        registerListener(this.cIf);
        this.cHm.eW(false);
        if (!alH()) {
            showLoadingView(this.cHm.WQ(), true);
            this.cHu.p(3, true);
        }
        super.onActivityCreated(bundle);
    }

    @Override // com.baidu.tieba.frs.aj
    public void Pk() {
        if (isAdded() && this.btP && !isLoadingViewAttached()) {
            showLoadingView(this.cHm.WQ(), true);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void Pl() {
        if (isAdded() && this.btP && isLoadingViewAttached()) {
            hideLoadingView(this.cHm.WQ());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (alH()) {
            showLoadingView(this.cHm.WQ(), true);
            this.cHm.jQ(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.cHu.p(3, true);
            getListView().setSelection(0);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void setHeaderViewHeight(int i) {
        this.cHN = i;
        if (this.cHm != null) {
            this.cHm.setHeaderViewHeight(this.cHN);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.s sVar) {
        if (sVar != null) {
            this.aNo = sVar.Hr();
            this.cHO = sVar.Hs();
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void showFloatingView() {
        if (this.aNo != null) {
            this.aNo.ca(true);
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
            this.cHf = data.getQueryParameter("name");
            this.mFrom = data.getQueryParameter("from");
            if (!StringUtils.isNull(this.cHf)) {
                intent.putExtra("name", this.cHf);
            }
            if (!StringUtils.isNull(this.mFrom)) {
                intent.putExtra("from", this.mFrom);
            }
            TiebaStatic.log("c10105");
        }
        if (StringUtils.isNull(this.cHf)) {
            this.cHf = com.baidu.tieba.frs.f.h.L(intent);
            if (!StringUtils.isNull(this.cHf)) {
                intent.putExtra("name", this.cHf);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.cHl = getVoiceManager();
        if (this.cHl != null) {
            this.cHl.onStart(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        Intent intent;
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.cIo);
        if (bundle != null) {
            this.cHf = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
            this.cHf = intent.getStringExtra("name");
            this.mFrom = intent.getStringExtra("from");
            this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
        }
        if (TextUtils.isEmpty(this.mFrom) || FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
        }
        if (this.mIsLogin) {
            registerListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL, this.cIo);
        }
        this.cHv.k(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.cIr);
        if (this.cHl != null) {
            this.cHl.onDestory(getPageContext());
        }
        this.cHl = null;
        s.abW().dU(false);
        if (this.cGS != null && this.cGS.aRo() != null) {
            ae.amz().bo(com.baidu.adp.lib.g.b.c(this.cGS.aRo().getId(), 0L));
        }
        if (this.cHJ != null) {
            this.cHJ.onDestory();
        }
        if (this.cHm != null) {
            com.baidu.tieba.frs.f.g.a(this.cHm, this.cGS, getForumId(), false, null);
            this.cHm.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.cHs != null) {
                this.cHs.onDestroy();
            }
            this.cHm.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.cHu.onActivityDestroy();
        this.cHv.onActivityDestroy();
        if (this.cHu != null) {
            this.cHu.QJ();
        }
        if (this.cHA != null) {
            this.cHA.Hq();
        }
        if (this.cHD != null) {
            this.cHD.destory();
        }
        if (this.cHE != null) {
            this.cHE.destory();
        }
        if (this.cHy != null) {
            this.cHy.onDestroy();
        }
        if (this.cHQ != null) {
            this.cHQ.onDestory();
        }
        if (this.cHI != null) {
            this.cHI.onDestroy();
        }
        if (this.cHT != null) {
            this.cHT.onDestroy();
        }
        com.baidu.tieba.recapp.e.a.bmw().bmy();
        com.baidu.tieba.frs.f.i.aqD();
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.cHf);
        bundle.putString("from", this.mFrom);
        this.cHu.onSaveInstanceState(bundle);
        if (this.cHl != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            this.cHl.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.cHI != null) {
            this.cHI.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.cHm != null) {
            this.cHm.alU();
            this.cHm.onResume();
        }
        this.cHw.a(this.cHX);
        this.cHx.fz(true);
        this.cHt = true;
        if (cHd) {
            cHd = false;
            this.cHm.startPullRefresh();
            return;
        }
        if (this.cHl != null) {
            this.cHl.onResume(getPageContext());
        }
        this.cHm.eX(false);
        registerListener(this.cIk);
        if (this.cHR) {
            cn(6);
            this.cHR = false;
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
                this.cHf = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.cHg = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.cHg) {
                alw();
            }
            if (this.mFrom != null && this.mFrom.equals("from_tieba_kuang")) {
                KuangFloatingViewController.getInstance().setNeedShowFloatingView(true);
                KuangFloatingViewController.getInstance().showFloatingView();
            }
        }
    }

    private void alw() {
        this.cHm.startPullRefresh();
    }

    public void closeActivity() {
        com.baidu.tieba.frs.f.h.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.mFrom);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.cHm.setTitle(this.cHf);
        } else {
            this.cHm.setTitle("");
            this.mFlag = 1;
        }
        this.cHv.d(this.cHm.getListView());
        this.cHm.setOnAdapterItemClickListener(this.cIp);
        this.cHm.setOnScrollListener(this.cIm);
        this.cHm.h(this.cFA);
        this.cHm.ame().a(this.cIn);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cHm.onChangeSkinType(i);
        this.cHv.kX(i);
        this.cHw.onChangeSkinType(i);
        if (this.cHP != null) {
            this.cHP.onChangeSkinType();
        }
    }

    public void jO(int i) {
        if (!this.mIsLogin) {
            if (this.cGS != null && this.cGS.qg() != null) {
                this.cGS.qg().setIfpost(1);
            }
            if (i == 0) {
                ax.aR(getActivity());
            }
        } else if (this.cGS != null) {
            if (i == 0) {
                com.baidu.tieba.frs.f.i.b(this, 0);
            } else {
                this.cHm.alW();
            }
        }
    }

    public void refresh() {
        cn(3);
    }

    public void cn(int i) {
        this.cHq = false;
        alB();
        if (this.cHm.alM() != null) {
            this.cHm.alM().avu();
        }
        this.cHu.p(i, true);
    }

    private void alx() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.g.h.fQ().d(new Runnable() { // from class: com.baidu.tieba.frs.g.15
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.ti(g.this.cHf);
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
            if (this.cGS != null) {
                this.cHm.PB();
                this.cHm.eS(this.cHu.apW());
                if (com.baidu.tieba.frs.g.f.j(this.cGS) && !com.baidu.tieba.frs.g.f.i(this.cGS)) {
                    this.cHm.aml();
                }
                if (this.cGS.aRo() != null) {
                    this.cHf = this.cGS.aRo().getName();
                    this.forumId = this.cGS.aRo().getId();
                }
                if (this.cGS.qy() != null) {
                    setHasMore(this.cGS.qy().qu());
                }
                this.cHm.setTitle(this.cHf);
                this.cHm.setForumName(this.cHf);
                TbadkCoreApplication.getInst().setDefaultBubble(this.cGS.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.cGS.getUserData().getBimg_end_time());
                alx();
                alz();
                ArrayList<com.baidu.adp.widget.ListView.f> threadList = this.cGS.getThreadList();
                if (threadList != null) {
                    this.cHm.a(threadList, this.cGS);
                    com.baidu.tieba.frs.f.c.j(this.cHm);
                    this.cHv.kY(getPageNum());
                    this.cHv.g(this.cGS);
                    this.cHw.a(this.cHm.getListView(), this.cGS, this.cHu.aqb());
                    this.cHm.alX();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void alz() {
        if (this.cGS != null) {
            if (this.cGS.aRC() == 1) {
                this.cHm.ame().setFromCDN(true);
            } else {
                this.cHm.ame().setFromCDN(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.cHx.fz(false);
        this.cHt = false;
        this.cHm.onPause();
        if (this.cHl != null) {
            this.cHl.onPause(getPageContext());
        }
        this.cHm.eX(true);
        if (this.cHE != null) {
            this.cHE.aqG();
        }
        MessageManager.getInstance().unRegisterListener(this.cIk);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        s.abW().dU(false);
        if (this.cGS != null && this.cGS.aRo() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            com.baidu.tbadk.distribute.a.CO().a(getPageContext().getPageActivity(), "frs", this.cGS.aRo().getId(), 0L);
        }
        if (this.cHl != null) {
            this.cHl.onStop(getPageContext());
        }
        com.baidu.tieba.frs.f.h.a(getListView());
        this.cHv.onActivityStop();
        t.Hu();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && this.cHv != null) {
            this.cHv.fB(isPrimary());
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || this.cHm == null) {
            return false;
        }
        return this.cHm.alT();
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
        if (this.cHl == null) {
            this.cHl = VoiceManager.instance();
        }
        return this.cHl;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public BdListView getListView() {
        if (this.cHm == null) {
            return null;
        }
        return this.cHm.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void alB() {
        if (this.cHl != null) {
            this.cHl.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> wN() {
        if (this.aoU == null) {
            this.aoU = UserIconBox.i(getPageContext().getPageActivity(), 8);
        }
        return this.aoU;
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
        if (this.cHm == null) {
            return null;
        }
        return this.cHm.alD();
    }

    /* loaded from: classes.dex */
    private final class a implements com.baidu.adp.widget.ListView.h {
        private a() {
        }

        @Override // com.baidu.adp.widget.ListView.h
        public void a(View view, com.baidu.adp.widget.ListView.f fVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            boolean z;
            if (bdUniqueId != null) {
                if (bdUniqueId == q.cJL) {
                    if (g.this.cHm != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11752").ac(ImageViewerConfig.FORUM_ID, g.this.forumId).ac("obj_locate", "1"));
                        g.this.cHm.startPullRefresh();
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
                                    if (g.this.cHu.apV() == 5) {
                                        str = "c10387";
                                    }
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak(str).ac(ImageViewerConfig.FORUM_ID, g.this.forumId));
                                    com.baidu.tieba.frs.f.h.b(g.this, bdVar);
                                    if (g.this.cGS != null && g.this.cGS.aRo() != null) {
                                        com.baidu.tieba.frs.e.a aVar = new com.baidu.tieba.frs.e.a();
                                        aVar.cYS = g.this.cGS.gzq == 1;
                                        aVar.cYU = g.this.cGS.aRo().getId();
                                        aVar.cYT = g.this.ali().aqb();
                                        com.baidu.tieba.frs.e.b.aqw().a(aVar, bdVar, 1);
                                    }
                                } else {
                                    if (tid.startsWith("pb:")) {
                                        bdVar.setId(tid.substring(3));
                                    }
                                    if (bdUniqueId.getId() == bd.ZR.getId()) {
                                        com.baidu.tieba.frs.f.g.a(bdVar.rb());
                                    }
                                    com.baidu.tieba.frs.f.h.a(g.this, bdVar, i, z);
                                    com.baidu.tieba.frs.f.g.a(g.this, g.this.cGS, bdVar);
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
            hideNetRefreshView(this.cHm.WQ());
            showLoadingView(this.cHm.WQ(), true);
            this.cHm.eW(false);
            this.cHu.p(3, true);
        }
    }

    public com.baidu.tieba.tbadkCore.k alE() {
        return this.cGS;
    }

    public boolean alF() {
        return this.cHm.alF();
    }

    public void Q(Object obj) {
        if (this.cHz != null && this.cHz.cXL != null) {
            this.cHz.cXL.f(obj);
        }
    }

    public void R(Object obj) {
        if (this.cHz != null && this.cHz.cXM != null) {
            this.cHz.cXM.f(obj);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.l.hy()) {
            this.cHm.adg();
        } else if (this.cHu.apV() == 1) {
            OW();
            OI();
        } else if (this.cHu.hasMore()) {
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
            if (!this.cHu.aqf() && TbadkCoreApplication.getInst().isRecAppExist() && this.cHu.apV() == 1) {
                this.cGS.a(this, arrayList);
            }
            ArrayList<com.baidu.adp.widget.ListView.f> a2 = this.cHG.a(false, false, arrayList, this.cHi);
            if (a2 != null) {
                this.cGS.aA(a2);
                this.cHm.a(a2, this.cGS);
            }
            if (this.cHu != null) {
                com.baidu.tieba.frs.e.b.a(this.cGS, this.cHu.aqb(), 2);
            }
        }
    }

    private void OW() {
        if (alo() == 1 || this.cHG.bc(this.cGS.bva())) {
            if (com.baidu.tbadk.core.util.v.v(this.cGS.getThreadList()) > 3) {
                this.cHm.amh();
            } else {
                this.cHm.amj();
            }
        } else if (com.baidu.tbadk.core.util.v.w(this.cGS.getThreadList())) {
            this.cHm.adg();
        } else {
            this.cHm.ami();
        }
    }

    @Override // com.baidu.tieba.frs.mc.j
    public void OI() {
        if (this.cHG != null) {
            this.cHG.a(this.cHf, this.forumId, this.cGS);
        }
    }

    public void alG() {
        if (!com.baidu.tbadk.core.util.ab.f(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.ai.c(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return alH() ? "a034" : "a006";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (!alH()) {
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

    public void eR(boolean z) {
        if (this.cHA != null) {
            this.cHA.fd(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.cHB.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a gl(int i) {
        return this.cHB.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        this.cHK.b(bVar);
    }

    public boolean alH() {
        return this.cHc;
    }

    @Override // com.baidu.tieba.frs.aj
    public void Pj() {
        if (this.cHm != null) {
            showFloatingView();
            this.cHm.getListView().setSelection(0);
            this.cHm.startPullRefresh();
        }
    }

    public ForumWriteData alI() {
        if (this.cGS == null || this.cGS.aRo() == null) {
            return null;
        }
        ForumData aRo = this.cGS.aRo();
        ForumWriteData forumWriteData = new ForumWriteData(aRo.getId(), aRo.getName(), aRo.getPrefixData(), this.cGS.qg());
        forumWriteData.setForumLevel(aRo.getUser_level());
        forumWriteData.setAvatar(this.cGS.aRo().getImage_url());
        UserData userData = this.cGS.getUserData();
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
        if (this.cHm != null) {
            this.cHm.cN(z);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void setVideoThreadId(String str) {
    }
}
