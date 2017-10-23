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
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.c.a;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.g.f;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.tbadkCore.d;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.AlaLiveNotify;
/* loaded from: classes.dex */
public class f extends BaseFragment implements BdListView.e, a.InterfaceC0022a, UserIconBox.b, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, ai, ak, am, com.baidu.tieba.frs.mc.j, com.baidu.tieba.recapp.o {
    public static boolean cpY = false;
    public static volatile long cqi = 0;
    public static volatile long cqj = 0;
    public static volatile int cqk = 0;
    private com.baidu.tbadk.util.p aLL;
    private com.baidu.adp.lib.e.b<TbImageView> aoc;
    private com.baidu.tieba.frs.gametab.a bkN;
    private com.baidu.tieba.frs.entelechy.b cpV;
    public bh cpZ;
    private com.baidu.tieba.frs.h.a cqA;
    private com.baidu.tieba.frs.mc.d cqB;
    private com.baidu.tieba.frs.mc.c cqC;
    private com.baidu.tieba.frs.h.h cqD;
    private com.baidu.tieba.frs.mc.a cqE;
    private h cqF;
    public com.baidu.tieba.frs.h.c cqG;
    private com.baidu.tieba.frs.mc.e cqH;
    private int cqI;
    private View.OnTouchListener cqJ;
    private com.baidu.tieba.frs.h.e cqK;
    private boolean cqL;
    private com.baidu.tieba.NEGFeedBack.a cqN;
    private com.baidu.tieba.tbadkCore.data.e cqd;
    private VoiceManager cqg;
    private f.a cqo;
    private FrsModelController cqq;
    private com.baidu.tieba.frs.h.f cqr;
    private com.baidu.tieba.frs.entelechy.b.d cqs;
    private com.baidu.tieba.frs.mc.f cqt;
    private com.baidu.tieba.frs.smartsort.b cqu;
    private com.baidu.tieba.frs.mc.b cqv;
    private an cqw;
    private com.baidu.tieba.frs.entelechy.b.b cqy;
    private com.baidu.tbadk.h.a cqz;
    public View mRootView;
    public boolean cpW = false;
    private boolean cpX = false;
    public String cqa = null;
    public String aie = null;
    public int mFlag = 0;
    private boolean cqb = false;
    private String mThreadId = null;
    public String forumId = null;
    private int cpP = 0;
    private boolean cqc = false;
    private boolean cqe = false;
    private boolean cqf = false;
    private i cqh = null;
    public final bh bie = null;
    private com.baidu.tieba.tbadkCore.i cpN = new com.baidu.tieba.tbadkCore.i();
    public long ccS = -1;
    public long aIZ = 0;
    public long aIR = 0;
    public long createTime = 0;
    public long Wq = -1;
    private boolean cql = false;
    private boolean cqm = false;
    public com.baidu.tbadk.k.d cqn = null;
    private boolean cqp = true;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> cqx = new SparseArray<>();
    private boolean blo = true;
    private boolean cqM = false;
    private final CustomMessageListener cqO = new CustomMessageListener(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED) { // from class: com.baidu.tieba.frs.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof bh) {
                    com.baidu.tieba.frs.g.h.a(f.this.cqh, f.this.cpN, f.this.getForumId(), true, (bh) data);
                }
            }
        }
    };
    private CustomMessageListener cqP = new CustomMessageListener(CmdConfigCustom.CMD_CLOSE_GAME_RANK_CARD) { // from class: com.baidu.tieba.frs.f.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (f.this.cpN != null) {
                f.this.cpN.bqp();
                if (f.this.cqh != null) {
                    f.this.cqh.YR();
                }
            }
        }
    };
    private final al cqQ = new al() { // from class: com.baidu.tieba.frs.f.21
        @Override // com.baidu.tieba.frs.al
        public void a(int i, int i2, ar arVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
            f.this.agS();
            if (f.this.cqy != null) {
                f.this.cqr.ff(f.this.cqy.jp(i));
            }
            d.a aVar = new d.a();
            if (arVar != null) {
                aVar.isSuccess = arVar.errCode == 0;
                aVar.errorCode = arVar.errCode;
                aVar.errorMsg = arVar.errMsg;
                if (aVar.isSuccess) {
                    if (com.baidu.tbadk.core.util.v.u(arrayList)) {
                        f.this.cqh.YS();
                    } else if (arVar.hasMore) {
                        f.this.cqh.ahJ();
                    } else if (arVar.cty) {
                        f.this.cqh.ahK();
                    } else {
                        f.this.cqh.YS();
                    }
                }
            } else {
                arVar = new ar();
                arVar.pn = 1;
                arVar.hasMore = false;
                arVar.cty = false;
            }
            if (i == 1) {
                f.this.cqp = true;
                f.this.cqZ.a(f.this.cqq.getType(), false, aVar);
            } else {
                f.this.a(aVar);
                if (f.this.cqq.akc() != null) {
                    f.this.cpN = f.this.cqq.akc();
                }
                f.this.agZ();
            }
            if (f.this.crk != null) {
                f.this.crk.a(i, i2, arVar, arrayList);
            }
        }
    };
    private aj cqR = new aj() { // from class: com.baidu.tieba.frs.f.22
        @Override // com.baidu.tieba.frs.aj
        public void a(al alVar) {
        }

        @Override // com.baidu.tieba.frs.aj
        public void a(int i, int i2, ao aoVar) {
            if (i != 1) {
                com.baidu.tieba.card.u.XN().dB(false);
            }
            if (i == 1) {
                f.this.cqh.eC(true);
                f.this.cqh.eB(false);
            } else {
                f.this.cqh.eD(true);
                f.this.cqh.eB(true);
            }
            f.this.ahc();
            f.this.cqq.a(i, i2, aoVar);
        }

        @Override // com.baidu.tieba.frs.aj
        public void init() {
        }

        @Override // com.baidu.tieba.frs.aj
        public void Pf() {
        }
    };
    private CustomMessageListener cqS = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIVE_COUNT) { // from class: com.baidu.tieba.frs.f.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                ((com.baidu.tieba.frs.entelechy.c.a) f.this.cqs).jr(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    };
    private CustomMessageListener cqT = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_LIVE_START) { // from class: com.baidu.tieba.frs.f.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && ((Integer) customResponsedMessage.getData()).intValue() == 51 && f.this.cpN != null) {
                com.baidu.tieba.frs.g.j.a(f.this.cpN, f.this.getPageContext());
            }
        }
    };
    private final CustomMessageListener cqU = new CustomMessageListener(CmdConfigCustom.CMD_FRS_SELECT_ALA_LIVE_TAB) { // from class: com.baidu.tieba.frs.f.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (f.this.cqs instanceof com.baidu.tieba.frs.entelechy.c.a) && ((com.baidu.tieba.frs.entelechy.c.a) f.this.cqs).ajt() != null) {
                ((com.baidu.tieba.frs.entelechy.c.a) f.this.cqs).ajt().jU(49);
            }
        }
    };
    private final CustomMessageListener cqV = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.frs.f.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && f.this.cpN != null && f.this.cpN.aMU() != null) {
                SignData signData = (SignData) customResponsedMessage.getData();
                int user_level = f.this.cpN.aMU().getUser_level();
                if (signData.forumId != null && signData.forumId.equals(f.this.cpN.aMU().getId())) {
                    f.this.cpN.d(signData);
                    f.this.cqr.g(f.this.cpN);
                    if (f.this.cqr.alU()) {
                        i = f.this.cpN.aMU().getUser_level();
                        if (user_level >= i) {
                            i++;
                        }
                    } else {
                        i = user_level;
                    }
                    TbadkCoreApplication.getInst().addSignedForum(f.this.cpN.aMU().getName(), signData.sign_bonus_point, i);
                }
            }
        }
    };
    private final CustomMessageListener cqW = new CustomMessageListener(CmdConfigCustom.CMD_FRS_EXPERIENCE_TIP) { // from class: com.baidu.tieba.frs.f.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.o) && f.this.cpN != null) {
                f.this.cpN.c((com.baidu.tieba.tbadkCore.o) customResponsedMessage.getData());
                f.this.cqr.f(f.this.cpN);
                f.this.cqs.a(f.this.cqh.getListView(), f.this.cpN, f.this.cqq.akY());
            }
        }
    };
    private final AntiHelper.a cqX = new AntiHelper.a() { // from class: com.baidu.tieba.frs.f.2
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12536").r("obj_locate", ap.a.aha));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12535").r("obj_locate", ap.a.aha));
        }
    };
    private CustomMessageListener bil = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.f.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(f.this.xA().getUniqueId())) {
                    if (updateAttentionMessage.getData().ars != null) {
                        if (AntiHelper.a(f.this.getActivity(), updateAttentionMessage.getData().ars, f.this.cqX) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12534").r("obj_locate", ap.a.aha));
                        }
                    } else if (updateAttentionMessage.getData().BZ && updateAttentionMessage.getData().isAttention) {
                        com.baidu.adp.lib.util.l.showToast(f.this.xA().getPageActivity(), d.l.attention_success);
                    }
                }
            }
        }
    };
    private CustomMessageListener cqY = new CustomMessageListener(CmdConfigCustom.CMD_STORY_READ_CACHE) { // from class: com.baidu.tieba.frs.f.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.story.process.b)) {
                com.baidu.tieba.story.process.b bVar = (com.baidu.tieba.story.process.b) customResponsedMessage.getData();
                if (f.this.forumId != null && f.this.forumId.equals(String.valueOf(bVar.forumId)) && bVar.state == 3 && f.this.ahf() != null && !com.baidu.tbadk.core.util.v.u(f.this.ahf().bpm()) && f.this.cpV.aiE() != null && f.this.cpV.aiE().aiU() != null) {
                    List<com.baidu.adp.widget.ListView.f> bpm = f.this.ahf().bpm();
                    int size = bpm.size();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= size) {
                            i = -1;
                            break;
                        } else if ((bpm.get(i2) instanceof com.baidu.tbadk.data.e) && TbadkCoreApplication.getCurrentAccount().equals(String.valueOf(((com.baidu.tbadk.data.e) bpm.get(i2)).user_id))) {
                            i = i2;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    com.baidu.tbadk.data.e eVar = new com.baidu.tbadk.data.e();
                    eVar.user_id = com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                    eVar.user_name = TbadkCoreApplication.getCurrentAccountName();
                    eVar.portrait = TbadkCoreApplication.getCurrentPortrait();
                    eVar.mStatus = 3;
                    eVar.ayT = String.valueOf(f.this.forumId);
                    eVar.ayS = bVar;
                    if (i != -1) {
                        bpm.set(i, eVar);
                    } else {
                        bpm.add(1, eVar);
                    }
                    f.this.cpV.aiE().aiU().b(bpm, f.this.forumId, f.this.getThreadId());
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.k cqZ = new com.baidu.tieba.tbadkCore.k() { // from class: com.baidu.tieba.frs.f.5
        private long startTime = 0;

        @Override // com.baidu.tieba.tbadkCore.k
        public void ja(int i) {
            this.startTime = System.nanoTime();
            if (f.this.cqh != null) {
                switch (i) {
                    case 1:
                    case 2:
                        f.this.cqh.ahv();
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
            if (f.this.blo) {
                f.this.blo = false;
                com.baidu.tieba.frs.g.h.a(f.this.cqh, f.this.cpN, f.this.getForumId(), false, null);
            }
            f.this.agS();
            f.this.cql = true;
            if (aVar != null && aVar.isSuccess) {
                f.this.cqh.ahF().eR(com.baidu.tbadk.core.util.an.vl().vn());
                f.cqi = 0L;
                f.cqj = 0L;
                f.cqk = 0;
            } else {
                f.cqk = 1;
            }
            if (!f.this.cqq.alc() && (i == 3 || i == 6)) {
                f.this.cqC.resetData();
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (f.this.cqq.akc() != null) {
                f.this.cpN = f.this.cqq.akc();
            }
            if (i == 7) {
                f.this.iY(f.this.cpN.bpM());
                return;
            }
            if (f.this.cpN.qq() != null) {
                f.this.setHasMore(f.this.cpN.qq().qm());
            }
            f.this.agT();
            if (i == 4) {
                if (!f.this.cqq.alc() && TbadkCoreApplication.getInst().isRecAppExist() && f.this.cqq.akS() == 1) {
                    f.this.cpN.a(f.this);
                }
                ArrayList<com.baidu.adp.widget.ListView.f> a2 = f.this.cqC.a(false, false, f.this.cpN.getThreadList(), f.this.cqd);
                if (a2 != null) {
                    f.this.cpN.az(a2);
                    f.this.cpN.bqi();
                    f.this.cqh.a(a2, f.this.cpN);
                }
                if (f.this.cqq != null) {
                    com.baidu.tieba.frs.f.b.a(f.this.cpN, f.this.cqq.akY(), 2);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    f.this.cqh.ahv();
                    break;
                case 2:
                    f.this.cqh.ahv();
                    break;
                case 3:
                case 6:
                    if (f.this.cpN != null) {
                        f.this.cpN.bqg();
                    }
                    if (f.this.cqG != null) {
                        f.this.cqG.refresh();
                        break;
                    }
                    break;
            }
            f.this.agU();
            if (aVar == null || aVar.errorCode == 0) {
                if (f.this.cpN != null) {
                    f.this.cqh.jc(i);
                    f.this.t(false, i == 5);
                    f.cqi = (System.nanoTime() - this.startTime) / 1000000;
                    if (aVar != null) {
                        f.cqj = aVar.gdv;
                    }
                } else {
                    return;
                }
            } else if (f.this.cpN == null || com.baidu.tbadk.core.util.v.u(f.this.cpN.getThreadList())) {
                f.this.a(aVar);
            } else if (aVar.gdu) {
                f.this.showToast(f.this.getPageContext().getResources().getString(d.l.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
            }
            if (f.this.cpN.bpr() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11384"));
            }
            if (f.this.ccS > -1 && !f.this.cqM) {
                com.baidu.tieba.frs.g.h.a(f.this.cqq, f.this.ccS);
                f.this.ccS = -1L;
                f.this.cqM = true;
            }
            if (f.this.cqe && (f.this.cqs instanceof com.baidu.tieba.frs.entelechy.c.a) && ((com.baidu.tieba.frs.entelechy.c.a) f.this.cqs).ajt() != null) {
                ((com.baidu.tieba.frs.entelechy.c.a) f.this.cqs).ajt().jU(49);
                f.this.cqe = false;
            }
            f.this.aIZ = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.k
        public void b(com.baidu.tieba.tbadkCore.g gVar) {
            if (gVar != null) {
                if ("normal_page".equals(f.this.cqq.akO()) || "frs_page".equals(f.this.cqq.akO()) || "book_page".equals(f.this.cqq.akO())) {
                    f.this.a(gVar);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE, gVar));
                }
            }
        }
    };
    private final CustomMessageListener cra = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.frs.f.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.i) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                f.this.cpN.a((com.baidu.tbadk.data.i) customResponsedMessage.getData());
                f.this.cqh.ahF().notifyDataSetChanged();
            }
        }
    };
    private final CustomMessageListener mMemListener = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_MEM) { // from class: com.baidu.tieba.frs.f.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && f.this.cpN != null && (userData = f.this.cpN.getUserData()) != null) {
                userData.setIsMem(num.intValue());
                if (num.intValue() != 0) {
                    f.this.cqr.f(num);
                }
            }
        }
    };
    private final com.baidu.tieba.frs.mc.i crb = new com.baidu.tieba.frs.mc.i() { // from class: com.baidu.tieba.frs.f.8
        @Override // com.baidu.tieba.frs.mc.i
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.f> arrayList, boolean z3) {
            if (f.this.cqu != null && f.this.cqq != null && f.this.cqq.alc() && z && !z2 && !z3) {
                f.this.cqu.jO(i2);
            }
        }
    };
    public final View.OnTouchListener aLM = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.f.9
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (f.this.cqJ != null) {
                f.this.cqJ.onTouch(view, motionEvent);
            }
            if (f.this.cqw != null && f.this.cqw.aic() != null) {
                f.this.cqw.aic().onTouchEvent(motionEvent);
            }
            if (f.this.bkN != null) {
                f.this.bkN.d(view, motionEvent);
            }
            if (f.this.cqr != null) {
                f.this.cqr.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private final CustomMessageListener crd = new CustomMessageListener(CmdConfigCustom.CMD_GOTOLIVE_HOST_UPGRADE) { // from class: com.baidu.tieba.frs.f.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "photolive_hostLevel", -1) != -1 && f.this.cpN.aMU() != null) {
                f.this.cpN.aMU().setCanAddPhotoLivePost(true);
            }
        }
    };
    private final CustomMessageListener cre = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.frs.f.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11455").ac("obj_locate", "frs"));
                    com.baidu.tbadk.core.util.av.vA().c(f.this.getPageContext(), new String[]{str});
                }
            }
        }
    };
    public final View.OnClickListener crf = new View.OnClickListener() { // from class: com.baidu.tieba.frs.f.14
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (f.this.cqh == null || view != f.this.cqh.aht() || f.this.getActivity() == null) {
                if (f.this.cpN != null && f.this.cpN.aMU() != null) {
                    if (f.this.cqh == null || view != f.this.cqh.ahz()) {
                        if (f.this.cqh != null && view == f.this.cqh.ahA()) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12402").ac("fid", f.this.cpN.aMU().getId()).ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()).ac(ImageViewerConfig.FORUM_NAME, f.this.cpN.aMU().getName()));
                            if (!StringUtils.isNull(f.this.cpN.aMU().getName())) {
                                f.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PostSearchActivityConfig(f.this.getPageContext().getPageActivity(), f.this.cpN.aMU().getName(), f.this.cpN.aMU().getId())));
                                return;
                            }
                            return;
                        }
                    } else if (!StringUtils.isNull(f.this.cpN.aMU().getId())) {
                        if (f.this.cpN.aMU() != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12046").ac("fid", f.this.cpN.aMU().getId()).r("obj_locate", f.this.ahi() ? 1 : 2));
                        }
                        f.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(f.this.getPageContext().getPageActivity(), f.this.cpN.aMU().getId(), ForumDetailActivityConfig.FromType.FRS)));
                        return;
                    } else {
                        return;
                    }
                }
                if (view.getId() == d.h.game_activity_egg_layout && com.baidu.adp.lib.util.l.hy()) {
                    TiebaStatic.log("c10853");
                    if (f.this.cqh.ahC()) {
                        f.this.cqh.ahD();
                        return;
                    }
                    String activityUrl = f.this.cpN.aMU().getYuleData().sU().getActivityUrl();
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
    private final AbsListView.OnScrollListener crg = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.f.15
        private int crn = 0;
        private int beu = 0;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (f.this.aLL != null && f.this.isPrimary()) {
                f.this.aLL.a(absListView, this.crn, i, i2, i3);
            }
            if (f.this.cqs != null) {
                f.this.cqs.a(absListView, i, i2, i3, f.this.cqr.alZ());
            }
            if (f.this.cqA != null) {
                f.this.cqA.alD();
            }
            if (f.this.cqu != null) {
                f.this.cqu.aln();
            }
            if (f.this.cqK != null) {
                f.this.cqK.onScroll(absListView, i, i2, i3);
            }
            if (f.this.cpN != null && f.this.cqh != null && f.this.cqh.ahF() != null) {
                this.crn = i;
                this.beu = (i + i2) - 1;
                f.this.cqh.ax(this.crn, this.beu);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (f.this.cqr != null) {
                f.this.cqr.setScrollState(i);
            }
            if (f.this.aLL != null && f.this.isPrimary()) {
                f.this.aLL.onScrollStateChanged(absListView, i);
            }
            if ((i == 2 || i == 1) && !f.this.cqm) {
                f.this.cqm = true;
                f.this.cqh.ahI();
            }
            if (f.this.cqn == null && !f.this.ahi()) {
                f.this.cqn = new com.baidu.tbadk.k.d();
                f.this.cqn.fs(1000);
            }
            if (i == 0) {
                com.baidu.tieba.card.u.XN().dB(true);
                f.this.cqh.aw(this.crn, this.beu);
            }
            if (f.this.cqK != null) {
                f.this.cqK.onScrollStateChanged(absListView, i);
            }
            if (f.this.cqn != null) {
                f.this.cqn.FD();
            }
            if (i == 0) {
                com.baidu.tieba.frs.g.h.a(f.this.cqh, f.this.cpN, f.this.getForumId(), false, null);
            }
        }
    };
    private final b crh = new b() { // from class: com.baidu.tieba.frs.f.16
        @Override // com.baidu.tieba.frs.b
        public void a(int i, int i2, View view, View view2, bh bhVar) {
            if (i != f.this.cqh.ahF().aja()) {
                if (i != f.this.cqh.ahF().ajb()) {
                    if (i != f.this.cqh.ahF().ajd()) {
                        if (i != f.this.cqh.ahF().ahS()) {
                            if (i == f.this.cqh.ahF().ajc() && f.this.cpN != null && f.this.cpN.getUserData() != null && f.this.cpN.getUserData().isBawu()) {
                                final String bpK = f.this.cpN.bpK();
                                if (!com.baidu.tbadk.core.util.am.isEmpty(bpK) && f.this.cpN.aMU() != null) {
                                    com.baidu.tieba.c.a.a(f.this.getPageContext(), f.this.cpN.aMU().getId(), f.this.cpN.aMU().getName(), new a.InterfaceC0078a() { // from class: com.baidu.tieba.frs.f.16.1
                                        @Override // com.baidu.tieba.c.a.InterfaceC0078a
                                        public void Xl() {
                                            com.baidu.tbadk.browser.a.O(f.this.getPageContext().getPageActivity(), bpK);
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10502").ac("fid", f.this.cpN.aMU().getId()).ac(SapiAccountManager.SESSION_UID, f.this.cpN.getUserData().getUserId()));
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        f.this.cpZ = bhVar;
                        com.baidu.tieba.frs.g.i.a(f.this, f.this.cpZ);
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10179").ac("fid", f.this.getForumId()));
                        return;
                    }
                    com.baidu.tieba.frs.g.i.B(f.this);
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak(i == f.this.cqh.ahF().ajd() ? "c10177" : "c10244").ac("fid", f.this.getForumId()));
                } else if (ax.aT(f.this.getPageContext().getPageActivity())) {
                    TiebaStatic.log("my_service_ck");
                    if (f.this.cpN != null && f.this.cpN.aMU() != null) {
                        ForumData aMU = f.this.cpN.aMU();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(f.this.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(aMU.getId(), 0L), aMU.getName(), aMU.getImage_url(), 0)));
                    }
                }
            } else if (ax.aT(f.this.getActivity())) {
                TiebaStatic.log("forum_fortune_click");
                com.baidu.tieba.frs.g.i.a(f.this.getPageContext(), f.this.cpN);
            }
        }
    };
    private final NoNetworkView.a cow = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.f.17
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aL(boolean z) {
            if (f.this.cqq.akS() == 1 && z && !f.this.cqh.ahg()) {
                if (f.this.cpN == null || com.baidu.tbadk.core.util.v.u(f.this.cpN.getThreadList())) {
                    f.this.hideNetRefreshView(f.this.cqh.ahG());
                    f.this.showLoadingView(f.this.cqh.ahG(), true);
                    f.this.cqh.eD(false);
                    f.this.refresh();
                    return;
                }
                f.this.cqh.ahv();
            }
        }
    };
    private final CustomMessageListener cri = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.f.18
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                com.baidu.tieba.frs.g.c.a(customResponsedMessage, f.this.cqh, f.this.cpN);
            }
        }
    };
    private com.baidu.adp.widget.ListView.h crj = new a();
    private al crk = new al() { // from class: com.baidu.tieba.frs.f.19
        @Override // com.baidu.tieba.frs.al
        public void a(int i, int i2, ar arVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
            com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tieba.frs.f.19.1
                @Override // java.lang.Runnable
                public void run() {
                    if (f.this.cqh != null && f.this.cqh.YI()) {
                        f.this.Ns();
                    }
                }
            });
        }
    };
    private CustomMessageListener crl = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.frs.f.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    f.this.cqL = true;
                }
            }
        }
    };

    public com.baidu.tieba.frs.entelechy.b.b agG() {
        return this.cqy;
    }

    public com.baidu.adp.widget.ListView.h agH() {
        return this.crj;
    }

    public com.baidu.tieba.frs.mc.d agI() {
        return this.cqB;
    }

    public com.baidu.tieba.frs.smartsort.b agJ() {
        return this.cqu;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public FrsModelController agK() {
        return this.cqq;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public com.baidu.tieba.frs.mc.c agL() {
        return this.cqC;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public com.baidu.tieba.frs.h.f agM() {
        return this.cqr;
    }

    public com.baidu.tieba.frs.entelechy.b.d agN() {
        return this.cqs;
    }

    public an agO() {
        return this.cqw;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public i agP() {
        return this.cqh;
    }

    @Override // com.baidu.tieba.frs.am
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.am
    public String getForumName() {
        return this.cqa;
    }

    public void setForumName(String str) {
        this.cqa = str;
    }

    public void setFrom(String str) {
        this.aie = str;
    }

    public String getFrom() {
        return this.aie;
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
        if (this.cqC == null) {
            return 1;
        }
        return this.cqC.getPn();
    }

    public int getPn() {
        if (this.cqC == null) {
            return 1;
        }
        return this.cqC.getPn();
    }

    public void setPn(int i) {
        if (this.cqC != null) {
            this.cqC.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.cqC != null) {
            this.cqC.setHasMore(i);
        }
    }

    public int agQ() {
        if (this.cqC == null) {
            return -1;
        }
        return this.cqC.agQ();
    }

    public boolean agR() {
        return this.cqf;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d.a aVar) {
        if (aVar == null) {
            String string = TbadkCoreApplication.getInst().getString(d.l.error_unkown_try_again);
            this.cqh.ahq();
            showNetRefreshView(this.cqh.ahG(), string, true);
        } else if (340001 == aVar.errorCode) {
            b(aVar);
        } else {
            if (com.baidu.tbadk.core.util.v.u(this.cpN.getThreadList())) {
                c(aVar);
            }
            if (ahi()) {
                setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst(), d.f.ds280));
            } else {
                setNetRefreshViewEmotionDefMarginTop();
            }
        }
    }

    private void b(d.a aVar) {
        this.cqh.ahq();
        if (aVar.gdu) {
            showNetRefreshViewNoClick(this.cqh.ahG(), TbadkCoreApplication.getInst().getString(d.l.net_error_text, new Object[]{aVar.errorMsg, Integer.valueOf(aVar.errorCode)}), true);
        } else {
            showNetRefreshViewNoClick(this.cqh.ahG(), aVar.errorMsg, true);
        }
    }

    private void c(d.a aVar) {
        this.cqh.ahq();
        if (aVar.gdu) {
            showNetRefreshView(this.cqh.ahG(), TbadkCoreApplication.getInst().getString(d.l.net_error_text, new Object[]{aVar.errorMsg, Integer.valueOf(aVar.errorCode)}), true);
        } else {
            showNetRefreshView(this.cqh.ahG(), aVar.errorMsg, true);
        }
    }

    public void agS() {
        hideLoadingView(this.cqh.ahG());
        this.cqh.ahB();
        if (this.cqh.aho() instanceof com.baidu.tieba.frs.tab.c) {
            ((com.baidu.tieba.frs.tab.c) this.cqh.aho()).alx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agT() {
        if (agQ() == 0 && com.baidu.tbadk.core.util.v.u(this.cpN.bpx())) {
            if (com.baidu.tbadk.core.util.v.u(this.cpN.getThreadList())) {
                this.cqh.YS();
                return;
            } else {
                this.cqh.ahK();
                return;
            }
        }
        this.cqh.ahJ();
    }

    public void a(ErrorData errorData) {
        agS();
        this.cqh.ahv();
        d.a akP = this.cqq.akP();
        boolean u = com.baidu.tbadk.core.util.v.u(this.cpN.getThreadList());
        if (akP != null && u) {
            if (u) {
                if (this.cqq.akQ() != 0) {
                    this.cqq.akW();
                    this.cqh.ahv();
                } else {
                    a(akP);
                }
                this.cqh.u(this.cpN.bqv(), false);
                return;
            } else if (akP.gdu) {
                this.cqh.u(true, false);
                showToast(getPageContext().getResources().getString(d.l.net_error_text, akP.errorMsg, Integer.valueOf(akP.errorCode)));
                return;
            } else {
                return;
            }
        }
        a(akP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agU() {
        if (this.cpN == null || this.cpN.aMU() != null) {
            this.cqh.ahE();
        } else if (this.cpN.aMU().getYuleData() != null && this.cpN.aMU().getYuleData().sT()) {
            TiebaStatic.log("c10852");
            this.cqh.a(this.cpN.aMU().getYuleData().sU());
        } else {
            this.cqh.ahE();
        }
    }

    private void s(boolean z, boolean z2) {
        if (this.cqq != null && this.cpN != null && this.cqh != null && z) {
            if (!this.cqq.alc() && this.cqq.akS() == 1) {
                if (!this.cqq.ala()) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        this.cpN.bqn();
                        this.cpN.bqk();
                    }
                    this.cpN.bql();
                    this.cpN.bqm();
                }
                boolean z3 = false;
                if (this.cqh.ahF().l(com.baidu.tieba.card.data.p.bNJ)) {
                    z3 = this.cpN.bqq();
                }
                if (!z3) {
                    this.cpN.bqo();
                }
                if (TbadkCoreApplication.getInst().isRecAppExist()) {
                    this.cpN.a(this);
                }
                if (!this.cqh.ahF().l(bh.Ya)) {
                    this.cpN.bqh();
                }
                this.cpN.bqr();
                this.cpN.bqs();
            }
            this.cpN.bqi();
            this.cpN.bqf();
            if (this.cqh.ahF().l(com.baidu.tieba.g.b.cOR)) {
                this.cpN.my(z2);
            }
            if (TbadkCoreApplication.isLogin()) {
                if (!this.cqq.alc() || this.cqq.isNetFirstLoad) {
                    this.cpN.bqt();
                }
            }
        }
    }

    public boolean agV() {
        if (this.cqs != null && this.cqh != null) {
            this.cqs.b(this.cqh.getListView());
        }
        if (this.cqr != null && this.cqq != null) {
            this.cqr.a(this.cqq.akO(), this.cpN);
        }
        boolean z = false;
        if (this.cpN != null) {
            z = this.cpN.bqw();
        }
        ew(z);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iY(int i) {
        ao aoVar = null;
        agV();
        ahc();
        try {
            if (this.cpN != null) {
                this.cqh.a((ArrayList<com.baidu.adp.widget.ListView.f>) null, this.cpN);
                this.cqr.kc(1);
                this.cqh.ahy();
                this.cqs.a(this.cqh.getListView(), this.cpN, this.cqq.akY());
                com.baidu.tieba.frs.tab.d a2 = a(this.cqs.ajm(), this.cpN.bpM());
                if (a2 != null && !TextUtils.isEmpty(a2.url)) {
                    aoVar = new ao();
                    aoVar.ctu = a2.url;
                    aoVar.stType = a2.name;
                }
                this.cqq.a(this.cpN.bpM(), 0, aoVar);
                this.cqs.eU(false);
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
            if (dVar != null && dVar.cCO == i) {
                return dVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(boolean z, boolean z2) {
        AlaLiveNotify bpY;
        try {
            if (this.cpN != null && this.cqs != null && this.cqq != null) {
                if (!this.cqh.ahF().l(bh.Ya)) {
                    this.cpN.bqh();
                }
                boolean u = com.baidu.tbadk.core.util.v.u(this.cpN.bpZ());
                this.cqh.eA(u);
                if (!u) {
                    if (this.cqK == null) {
                        this.cqK = new com.baidu.tieba.frs.h.e(this, (NoPressedRelativeLayout) this.mRootView);
                    }
                    if (this.bkN == null) {
                        this.bkN = new com.baidu.tieba.frs.gametab.a(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
                    }
                } else {
                    this.cqK = null;
                    this.bkN = null;
                }
                if (this.cpN.aMU() != null) {
                    this.cqa = this.cpN.aMU().getName();
                    this.forumId = this.cpN.aMU().getId();
                }
                if (this.cpN.bqw()) {
                    this.cqs.a(this.cqh.getListView(), this.cpN, this.cqq.akY());
                }
                if (z) {
                    s(true, z);
                } else {
                    s(this.cqp, z);
                }
                agV();
                if (this.cqy != null) {
                    this.cqy.a(this.cqr, this.cpN);
                }
                if (this.cpN.qq() != null) {
                    setHasMore(this.cpN.qq().qm());
                }
                ArrayList<com.baidu.adp.widget.ListView.f> a2 = this.cqC.a(z2, true, this.cpN.getThreadList(), null, z);
                if (a2 != null) {
                    this.cpN.az(a2);
                }
                if (this.cqq.akS() == 1) {
                    agZ();
                    if (!z && this.cqq.getPn() == 1 && (bpY = ahf().bpY()) != null) {
                        new com.baidu.tieba.frs.d.a().a(this, bpY);
                    }
                }
                this.cpP = this.cpN.akU();
                if (this.cqd != null) {
                    this.cqc = true;
                    this.cqd.tw(this.cpP);
                    com.baidu.tieba.frs.g.a.a(this, this.cpN.aMU(), this.cpN.getThreadList(), this.cqc, getPn());
                }
                if (this.cqA != null) {
                    this.cqA.aw(this.cqs.ajn());
                }
                agS();
                this.cqh.ahr();
                this.cqh.u(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.g gVar) {
        try {
            if (!this.cql && gVar != null && this.cpN != null) {
                this.cpN.e(gVar);
                t(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void ew(boolean z) {
        if (this.cqq != null) {
            f(z, this.cqq.akO());
        } else {
            f(z, "normal_page");
        }
    }

    private void f(boolean z, String str) {
        ex("frs_page".equals(str));
        if (this.cqy != null) {
            this.cqy.a(z, this.cqs, this.cqr, this.cqh, this.cpN);
        }
    }

    public void ex(boolean z) {
        if (this.cqD != null) {
            this.cqD.a(this.cqh, z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(d.j.frs_activity, viewGroup, false);
            this.cpV = new com.baidu.tieba.frs.entelechy.b();
            this.cqy = this.cpV.aiD();
            this.cqr = new com.baidu.tieba.frs.h.f(this, this.cpV);
            this.cqs = this.cpV.z(this);
            Intent intent = getActivity().getIntent();
            if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                this.cpX = true;
            }
            this.cqh = new i(this, this.crf, this.cpV, this.cpX);
            this.cqh.setHeaderViewHeight(this.cqI);
        } else if (this.mRootView.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            this.cqh.ahN();
        }
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Intent intent = getActivity().getIntent();
        this.ccS = System.currentTimeMillis();
        if (intent != null) {
            this.cqe = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.ccS = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            K(intent);
        }
        this.Wq = System.currentTimeMillis();
        this.aIR = this.Wq - this.ccS;
        this.cqd = new com.baidu.tieba.tbadkCore.data.e("frs", com.baidu.tieba.tbadkCore.data.e.gfT);
        this.cqq = new FrsModelController(this, this.cqZ);
        this.cqq.a(this.cqQ);
        this.cqq.init();
        if (intent != null) {
            this.cqq.i(intent.getExtras());
        } else if (bundle != null) {
            this.cqq.i(bundle);
        } else {
            this.cqq.i(null);
        }
        this.cqs.as(this.cqh.ahG());
        if (intent != null) {
            this.cqr.l(intent.getExtras());
        } else if (bundle != null) {
            this.cqr.l(bundle);
        } else {
            this.cqr.l((Bundle) null);
        }
        this.cqg = getVoiceManager();
        this.cqF = new h(getPageContext(), this);
        initUI();
        initData(bundle);
        if (this.aie != null && this.aie.equals("from_tieba_kuang")) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12264").r("obj_type", 1).ac(ImageViewerConfig.FORUM_NAME, this.cqq.getForumName()));
            KuangFloatingViewController.getInstance().setNeedShowFloatingView(true);
            KuangFloatingViewController.getInstance().showFloatingView();
        }
        if (!ahi()) {
            this.cqw = new an(getActivity(), this.cqh, this.cqr);
            this.cqw.eK(true);
        }
        this.cqg = getVoiceManager();
        if (this.cqg != null) {
            this.cqg.onCreate(getPageContext());
        }
        new com.baidu.tieba.frs.mc.g();
        this.cqC = new com.baidu.tieba.frs.mc.c(this, this.crb);
        this.cqu = new com.baidu.tieba.frs.smartsort.b(this);
        this.cqD = new com.baidu.tieba.frs.h.h(this);
        this.createTime = System.currentTimeMillis() - this.Wq;
        this.cqA = new com.baidu.tieba.frs.h.a(getPageContext(), this.cqq.akZ());
        this.cqv = new com.baidu.tieba.frs.mc.b(this);
        this.cqB = new com.baidu.tieba.frs.mc.d(this);
        this.cqt = new com.baidu.tieba.frs.mc.f(this);
        this.cqE = new com.baidu.tieba.frs.mc.a(this);
        this.cqG = new com.baidu.tieba.frs.h.c(this);
        this.cqH = new com.baidu.tieba.frs.mc.e(this, getUniqueId());
        this.cqN = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "frs");
        registerListener(this.bil);
        registerListener(this.mMemListener);
        registerListener(this.cqW);
        registerListener(this.crd);
        registerListener(this.cqV);
        registerListener(this.cra);
        registerListener(this.cqS);
        registerListener(this.cqT);
        registerListener(this.cqU);
        registerListener(this.cqO);
        registerListener(this.cqP);
        registerListener(this.crl);
        registerListener(this.cqY);
        this.cqh.eD(false);
        if (!ahi()) {
            showLoadingView(this.cqh.ahG(), true);
            this.cqq.o(3, true);
        }
        super.onActivityCreated(bundle);
    }

    @Override // com.baidu.tieba.frs.ai
    public void ND() {
        if (isAdded() && this.blo && !isLoadingViewAttached()) {
            showLoadingView(this.cqh.ahG(), true);
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void NE() {
        if (isAdded() && this.blo && isLoadingViewAttached()) {
            hideLoadingView(this.cqh.ahG());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (ahi()) {
            showLoadingView(this.cqh.ahG(), true);
            this.cqh.jb(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.cqq.o(3, true);
            getListView().setSelection(0);
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void setHeaderViewHeight(int i) {
        this.cqI = i;
        if (this.cqh != null) {
            this.cqh.setHeaderViewHeight(this.cqI);
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.q qVar) {
        if (qVar != null) {
            this.aLL = qVar.GM();
            this.cqJ = qVar.GN();
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void showFloatingView() {
        if (this.aLL != null) {
            this.aLL.ce(true);
        }
    }

    private void K(Intent intent) {
        if (intent != null) {
            if (!com.baidu.tieba.frs.g.f.a(this, getForumName(), "from", intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false)) && getActivity() != null) {
                getActivity().finish();
                return;
            }
        }
        if (intent != null && intent.getData() != null) {
            Uri data = intent.getData();
            this.cqa = data.getQueryParameter("name");
            this.aie = data.getQueryParameter("from");
            if (!StringUtils.isNull(this.cqa)) {
                intent.putExtra("name", this.cqa);
            }
            if (!StringUtils.isNull(this.aie)) {
                intent.putExtra("from", this.aie);
            }
            TiebaStatic.log("c10105");
        }
        if (StringUtils.isNull(this.cqa)) {
            this.cqa = com.baidu.tieba.frs.g.i.M(intent);
            if (!StringUtils.isNull(this.cqa)) {
                intent.putExtra("name", this.cqa);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.cqg = getVoiceManager();
        if (this.cqg != null) {
            this.cqg.onStart(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        Intent intent;
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.cri);
        if (bundle != null) {
            this.cqa = bundle.getString("name");
            this.aie = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
            this.cqa = intent.getStringExtra("name");
            this.aie = intent.getStringExtra("from");
            this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
        }
        if (TextUtils.isEmpty(this.aie) || FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.aie)) {
        }
        if (this.mIsLogin) {
            registerListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL, this.cri);
        }
        this.cqr.l(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.crl);
        if (this.cqg != null) {
            this.cqg.onDestory(getPageContext());
        }
        this.cqg = null;
        com.baidu.tieba.card.u.XN().dB(false);
        if (this.cpN != null && this.cpN.aMU() != null) {
            ad.ahY().bg(com.baidu.adp.lib.g.b.c(this.cpN.aMU().getId(), 0L));
        }
        if (this.cqh != null) {
            com.baidu.tieba.frs.g.h.a(this.cqh, this.cpN, getForumId(), false, null);
            this.cqh.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.cqn != null) {
                this.cqn.onDestroy();
            }
            this.cqh.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.cqq.onActivityDestroy();
        this.cqr.onActivityDestroy();
        if (this.cqo != null) {
            this.cqo.cancel(true);
            this.cqo = null;
        }
        if (this.cqq != null) {
            this.cqq.Pf();
        }
        if (this.cqw != null) {
            this.cqw.GL();
        }
        if (this.cqz != null) {
            this.cqz.destory();
        }
        if (this.cqA != null) {
            this.cqA.destory();
        }
        if (this.cqu != null) {
            this.cqu.onDestroy();
        }
        if (this.cqK != null) {
            this.cqK.onDestory();
        }
        if (this.cqE != null) {
            this.cqE.onDestroy();
        }
        if (this.cqN != null) {
            this.cqN.onDestroy();
        }
        com.baidu.tieba.recapp.d.a.bgt().bgv();
        com.baidu.tieba.frs.g.j.alA();
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.cqa);
        bundle.putString("from", this.aie);
        this.cqq.onSaveInstanceState(bundle);
        if (this.cqg != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            this.cqg.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.cqE != null) {
            this.cqE.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.cqh != null) {
            this.cqh.ahv();
            this.cqh.onResume();
        }
        this.cqs.a(this.cqR);
        this.cqt.fd(true);
        this.cqp = true;
        if (cpY) {
            cpY = false;
            this.cqh.startPullRefresh();
            return;
        }
        if (this.cqg != null) {
            this.cqg.onResume(getPageContext());
        }
        this.cqh.eE(false);
        registerListener(this.cre);
        if (this.cqL) {
            cl(6);
            this.cqL = false;
        }
        KuangFloatingViewController.getInstance().showFloatingView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        refresh();
    }

    public boolean agW() {
        Intent intent;
        if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
            return false;
        }
        return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
    }

    public void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.cqa = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.aie = intent.getStringExtra("from");
            }
            this.cqb = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.cqb) {
                agX();
            }
            if (this.aie != null && this.aie.equals("from_tieba_kuang")) {
                KuangFloatingViewController.getInstance().setNeedShowFloatingView(true);
                KuangFloatingViewController.getInstance().showFloatingView();
            }
        }
    }

    private void agX() {
        this.cqh.startPullRefresh();
    }

    public void closeActivity() {
        com.baidu.tieba.frs.g.i.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.aie);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.cqh.setTitle(this.cqa);
        } else {
            this.cqh.setTitle("");
            this.mFlag = 1;
        }
        this.cqr.d(this.cqh.getListView());
        this.cqh.setOnAdapterItemClickListener(this.crj);
        this.cqh.setOnScrollListener(this.crg);
        this.cqh.h(this.cow);
        this.cqh.ahF().a(this.crh);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cqh.onChangeSkinType(i);
        this.cqr.kb(i);
        this.cqs.onChangeSkinType(i);
    }

    public void iZ(int i) {
        if (!this.mIsLogin) {
            if (this.cpN != null && this.cpN.qa() != null) {
                this.cpN.qa().setIfpost(1);
            }
            if (i == 0) {
                ax.aS(getActivity());
            }
        } else if (this.cpN != null) {
            if (i == 0) {
                com.baidu.tieba.frs.g.j.b(this, 0);
            } else {
                this.cqh.ahx();
            }
        }
    }

    public void refresh() {
        cl(3);
    }

    public void cl(int i) {
        this.cql = false;
        ahc();
        if (this.cqh.ahn() != null) {
            this.cqh.ahn().aqY();
        }
        this.cqq.o(i, true);
    }

    private void agY() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.g.h.fQ().d(new Runnable() { // from class: com.baidu.tieba.frs.f.13
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.rS(f.this.cqa);
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
            if (this.cpN != null) {
                this.cqh.NX();
                this.cqh.ez(this.cqq.akT());
                if (com.baidu.tieba.frs.h.f.i(this.cpN) && !com.baidu.tieba.frs.h.f.h(this.cpN)) {
                    this.cqh.ahL();
                }
                if (this.cpN.aMU() != null) {
                    this.cqa = this.cpN.aMU().getName();
                    this.forumId = this.cpN.aMU().getId();
                }
                if (this.cpN.qq() != null) {
                    setHasMore(this.cpN.qq().qm());
                }
                this.cqh.setTitle(this.cqa);
                this.cqh.setForumName(this.cqa);
                TbadkCoreApplication.getInst().setDefaultBubble(this.cpN.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.cpN.getUserData().getBimg_end_time());
                agY();
                aha();
                ArrayList<com.baidu.adp.widget.ListView.f> threadList = this.cpN.getThreadList();
                if (threadList != null) {
                    this.cqh.a(threadList, this.cpN);
                    com.baidu.tieba.frs.g.c.j(this.cqh);
                    this.cqr.kc(getPageNum());
                    this.cqr.f(this.cpN);
                    this.cqs.a(this.cqh.getListView(), this.cpN, this.cqq.akY());
                    this.cqh.ahy();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void aha() {
        if (this.cpN != null) {
            if (this.cpN.aNi() == 1) {
                this.cqh.ahF().setFromCDN(true);
            } else {
                this.cqh.ahF().setFromCDN(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.cqt.fd(false);
        this.cqp = false;
        this.cqh.onPause();
        if (this.cqg != null) {
            this.cqg.onPause(getPageContext());
        }
        this.cqh.eE(true);
        if (this.cqA != null) {
            this.cqA.alD();
        }
        MessageManager.getInstance().unRegisterListener(this.cre);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.u.XN().dB(false);
        if (this.cpN != null && this.cpN.aMU() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            com.baidu.tbadk.distribute.a.Cd().a(getPageContext().getPageActivity(), "frs", this.cpN.aMU().getId(), 0L);
        }
        if (this.cqg != null) {
            this.cqg.onStop(getPageContext());
        }
        com.baidu.tieba.frs.g.i.a(getListView());
        this.cqr.onActivityStop();
        r.GP();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || this.cqh == null) {
            return false;
        }
        return this.cqh.ahu();
    }

    @Override // com.baidu.tieba.recapp.o
    public TbPageContext<?> xA() {
        return getPageContext();
    }

    @Override // com.baidu.tieba.recapp.o
    public void a(AdvertAppInfo advertAppInfo, String str) {
        com.baidu.tbadk.distribute.a.Cd().a(advertAppInfo, this.forumId, 0L, "FRS", str, getPn());
    }

    @Override // com.baidu.tieba.recapp.o
    public void ahb() {
        agK().ahb();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.cqg == null) {
            this.cqg = VoiceManager.instance();
        }
        return this.cqg;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public BdListView getListView() {
        if (this.cqh == null) {
            return null;
        }
        return this.cqh.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void ahc() {
        if (this.cqg != null) {
            this.cqg.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> wG() {
        if (this.aoc == null) {
            this.aoc = UserIconBox.i(getPageContext().getPageActivity(), 8);
        }
        return this.aoc;
    }

    public void ahd() {
        if (getFragmentActivity() != null && getFragmentActivity().getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.a(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.g onGetPreLoadListView() {
        return getListView();
    }

    @Override // com.baidu.tieba.frs.ak
    public NavigationBar ahe() {
        if (this.cqh == null) {
            return null;
        }
        return this.cqh.ahe();
    }

    /* loaded from: classes.dex */
    private final class a implements com.baidu.adp.widget.ListView.h {
        private a() {
        }

        @Override // com.baidu.adp.widget.ListView.h
        public void a(View view, com.baidu.adp.widget.ListView.f fVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            boolean z;
            if (bdUniqueId != null) {
                if (bdUniqueId == p.csD) {
                    if (f.this.cqh != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11752").ac("fid", f.this.forumId).ac("obj_locate", "1"));
                        f.this.cqh.startPullRefresh();
                    }
                } else if (fVar != null && (fVar instanceof bh)) {
                    bh bhVar = (bh) fVar;
                    if (bhVar.rZ() == null || bhVar.rZ().getGroup_id() == 0 || ax.aT(f.this.getActivity())) {
                        if ((bhVar.rS() != 1 && bhVar.rS() != 2) || ax.aT(f.this.getActivity())) {
                            if (bhVar.rB() != null) {
                                if (ax.aT(f.this.getActivity())) {
                                    String postUrl = bhVar.rB().getPostUrl();
                                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.hy()) {
                                        com.baidu.tbadk.browser.a.P(f.this.getActivity(), postUrl);
                                    }
                                }
                            } else if (bhVar.sk() != null) {
                                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                    ax.aS(f.this.getPageContext().getPageActivity());
                                    return;
                                }
                                com.baidu.tbadk.core.data.n sk = bhVar.sk();
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(f.this.getPageContext().getPageActivity(), sk.getCartoonId(), sk.getChapterId(), 2)));
                            } else if (bhVar.getThreadType() == 47 && bhVar.rj() == 1 && !com.baidu.tbadk.core.util.am.isEmpty(bhVar.rv())) {
                                com.baidu.tbadk.browser.a.O(f.this.getPageContext().getPageActivity(), bhVar.rv());
                            } else {
                                com.baidu.tieba.tbadkCore.util.e readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                                if (readThreadHistory != null && !readThreadHistory.rY(bhVar.getId())) {
                                    readThreadHistory.rX(bhVar.getId());
                                }
                                final String rv = bhVar.rv();
                                if (rv == null || rv.equals("")) {
                                    z = false;
                                } else {
                                    new Thread(new Runnable() { // from class: com.baidu.tieba.frs.f.a.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(rv);
                                            xVar.uG().vC().mIsNeedAddCommenParam = false;
                                            xVar.uG().vC().mIsUseCurrentBDUSS = false;
                                            xVar.uj();
                                        }
                                    }).start();
                                    z = true;
                                }
                                String tid = bhVar.getTid();
                                if (tid == null) {
                                    tid = "";
                                }
                                if (bhVar.rj() == 2 && !tid.startsWith("pb:")) {
                                    com.baidu.tbadk.core.util.av.vA().c(f.this.getPageContext(), new String[]{tid, "", null});
                                } else if (bhVar.getThreadType() == 33 || (bhVar instanceof aw)) {
                                    String str = bhVar.getThreadType() == 33 ? "c10245" : "c10180";
                                    if (f.this.cqq.akS() == 5) {
                                        str = "c10387";
                                    }
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak(str).ac("fid", f.this.forumId));
                                    com.baidu.tieba.frs.g.i.c(f.this, bhVar);
                                    if (f.this.cpN != null && f.this.cpN.aMU() != null) {
                                        com.baidu.tieba.frs.f.a aVar = new com.baidu.tieba.frs.f.a();
                                        aVar.cFG = f.this.cpN.gdW == 1;
                                        aVar.cFI = f.this.cpN.aMU().getId();
                                        aVar.cFH = f.this.agK().akY();
                                        com.baidu.tieba.frs.f.b.alt().a(aVar, bhVar, 1);
                                    }
                                } else {
                                    if (tid.startsWith("pb:")) {
                                        bhVar.setId(tid.substring(3));
                                    }
                                    if (bdUniqueId.getId() == bh.Zg.getId()) {
                                        com.baidu.tieba.frs.g.h.a(bhVar.qV());
                                        com.baidu.tieba.frs.g.i.b(f.this, bhVar);
                                        return;
                                    }
                                    com.baidu.tieba.frs.g.i.a(f.this, bhVar, i, z);
                                    com.baidu.tieba.frs.g.h.a(f.this, f.this.cpN, bhVar);
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
            hideNetRefreshView(this.cqh.ahG());
            showLoadingView(this.cqh.ahG(), true);
            this.cqh.eD(false);
            this.cqq.o(3, true);
        }
    }

    public com.baidu.tieba.tbadkCore.i ahf() {
        return this.cpN;
    }

    public boolean ahg() {
        return this.cqh.ahg();
    }

    public void N(Object obj) {
        if (this.cqv != null && this.cqv.cEA != null) {
            this.cqv.cEA.f(obj);
        }
    }

    public void O(Object obj) {
        if (this.cqv != null && this.cqv.cEB != null) {
            this.cqv.cEB.f(obj);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.l.hy()) {
            this.cqh.YS();
        } else if (this.cqq.akS() == 1) {
            Nz();
            Ns();
        } else if (this.cqq.hasMore()) {
            Ns();
        }
    }

    public void kw(String str) {
        Nz();
        showToast(str);
    }

    public void G(ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        Nz();
        if (!com.baidu.tbadk.core.util.v.u(arrayList)) {
            if (!this.cqq.alc() && TbadkCoreApplication.getInst().isRecAppExist() && this.cqq.akS() == 1) {
                this.cpN.a(this, arrayList);
            }
            ArrayList<com.baidu.adp.widget.ListView.f> a2 = this.cqC.a(false, false, arrayList, this.cqd);
            if (a2 != null) {
                this.cpN.az(a2);
                this.cqh.a(a2, this.cpN);
            }
            if (this.cqq != null) {
                com.baidu.tieba.frs.f.b.a(this.cpN, this.cqq.akY(), 2);
            }
        }
    }

    private void Nz() {
        if (agQ() == 1 || this.cqC.aO(this.cpN.bpx())) {
            this.cqh.ahJ();
        } else if (com.baidu.tbadk.core.util.v.u(this.cpN.getThreadList())) {
            this.cqh.YS();
        } else {
            this.cqh.ahK();
        }
    }

    @Override // com.baidu.tieba.frs.mc.j
    public void Ns() {
        if (this.cqC != null) {
            this.cqC.a(this.cqa, this.forumId, this.cpN);
        }
    }

    public void ahh() {
        if (!com.baidu.tbadk.core.util.ab.e(getPageContext().getPageActivity(), 1)) {
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

    public void ey(boolean z) {
        if (this.cqw != null) {
            this.cqw.eK(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.cqx.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a fV(int i) {
        return this.cqx.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        this.cqF.b(bVar);
    }

    public boolean ahi() {
        return this.cpX;
    }

    @Override // com.baidu.tieba.frs.ai
    public void NC() {
        if (this.cqh != null) {
            showFloatingView();
            this.cqh.getListView().setSelection(0);
            this.cqh.startPullRefresh();
        }
    }

    public ForumWriteData ahj() {
        if (this.cpN == null || this.cpN.aMU() == null) {
            return null;
        }
        ForumData aMU = this.cpN.aMU();
        ForumWriteData forumWriteData = new ForumWriteData(aMU.getId(), aMU.getName(), aMU.getPrefixData(), this.cpN.qa());
        forumWriteData.setForumLevel(aMU.getUser_level());
        forumWriteData.setAvatar(this.cpN.aMU().getImage_url());
        return forumWriteData;
    }

    @Override // com.baidu.tieba.frs.ai
    public void wu() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void cI(boolean z) {
        if (this.cqh != null) {
            this.cqh.cI(z);
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void setVideoThreadId(String str) {
    }
}
