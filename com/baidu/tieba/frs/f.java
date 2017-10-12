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
    public static boolean cqk = false;
    public static volatile long cqu = 0;
    public static volatile long cqv = 0;
    public static volatile int cqw = 0;
    private com.baidu.tbadk.util.p aLY;
    private com.baidu.adp.lib.e.b<TbImageView> aoo;
    private com.baidu.tieba.frs.gametab.a blb;
    private f.a cqA;
    private FrsModelController cqC;
    private com.baidu.tieba.frs.h.f cqD;
    private com.baidu.tieba.frs.entelechy.b.d cqE;
    private com.baidu.tieba.frs.mc.f cqF;
    private com.baidu.tieba.frs.smartsort.b cqG;
    private com.baidu.tieba.frs.mc.b cqH;
    private an cqI;
    private com.baidu.tieba.frs.entelechy.b.b cqK;
    private com.baidu.tbadk.h.a cqL;
    private com.baidu.tieba.frs.h.a cqM;
    private com.baidu.tieba.frs.mc.d cqN;
    private com.baidu.tieba.frs.mc.c cqO;
    private com.baidu.tieba.frs.h.h cqP;
    private com.baidu.tieba.frs.mc.a cqQ;
    private h cqR;
    public com.baidu.tieba.frs.h.c cqS;
    private com.baidu.tieba.frs.mc.e cqT;
    private int cqU;
    private View.OnTouchListener cqV;
    private com.baidu.tieba.frs.h.e cqW;
    private boolean cqX;
    private com.baidu.tieba.NEGFeedBack.a cqZ;
    private com.baidu.tieba.frs.entelechy.b cqh;
    public bh cql;
    private com.baidu.tieba.tbadkCore.data.e cqp;
    private VoiceManager cqs;
    public View mRootView;
    public boolean cqi = false;
    private boolean cqj = false;
    public String cqm = null;
    public String aiq = null;
    public int mFlag = 0;
    private boolean cqn = false;
    private String mThreadId = null;
    public String forumId = null;
    private int cqb = 0;
    private boolean cqo = false;
    private boolean cqq = false;
    private boolean cqr = false;
    private i cqt = null;
    public final bh bit = null;
    private com.baidu.tieba.tbadkCore.i cpZ = new com.baidu.tieba.tbadkCore.i();
    public long cde = -1;
    public long aJm = 0;
    public long aJe = 0;
    public long createTime = 0;
    public long WC = -1;
    private boolean cqx = false;
    private boolean cqy = false;
    public com.baidu.tbadk.k.d cqz = null;
    private boolean cqB = true;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> cqJ = new SparseArray<>();
    private boolean blC = true;
    private boolean cqY = false;
    private final CustomMessageListener cra = new CustomMessageListener(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED) { // from class: com.baidu.tieba.frs.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof bh) {
                    com.baidu.tieba.frs.g.h.a(f.this.cqt, f.this.cpZ, f.this.getForumId(), true, (bh) data);
                }
            }
        }
    };
    private CustomMessageListener crb = new CustomMessageListener(CmdConfigCustom.CMD_CLOSE_GAME_RANK_CARD) { // from class: com.baidu.tieba.frs.f.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (f.this.cpZ != null) {
                f.this.cpZ.bqw();
                if (f.this.cqt != null) {
                    f.this.cqt.YV();
                }
            }
        }
    };
    private final al crd = new al() { // from class: com.baidu.tieba.frs.f.21
        @Override // com.baidu.tieba.frs.al
        public void a(int i, int i2, ar arVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
            f.this.agX();
            if (f.this.cqK != null) {
                f.this.cqD.fg(f.this.cqK.jq(i));
            }
            d.a aVar = new d.a();
            if (arVar != null) {
                aVar.isSuccess = arVar.errCode == 0;
                aVar.errorCode = arVar.errCode;
                aVar.errorMsg = arVar.errMsg;
                if (aVar.isSuccess) {
                    if (com.baidu.tbadk.core.util.v.u(arrayList)) {
                        f.this.cqt.YW();
                    } else if (arVar.hasMore) {
                        f.this.cqt.ahO();
                    } else if (arVar.ctK) {
                        f.this.cqt.ahP();
                    } else {
                        f.this.cqt.YW();
                    }
                }
            } else {
                arVar = new ar();
                arVar.pn = 1;
                arVar.hasMore = false;
                arVar.ctK = false;
            }
            if (i == 1) {
                f.this.cqB = true;
                f.this.crm.a(f.this.cqC.getType(), false, aVar);
            } else {
                f.this.a(aVar);
                if (f.this.cqC.akh() != null) {
                    f.this.cpZ = f.this.cqC.akh();
                }
                f.this.ahe();
            }
            if (f.this.crw != null) {
                f.this.crw.a(i, i2, arVar, arrayList);
            }
        }
    };
    private aj cre = new aj() { // from class: com.baidu.tieba.frs.f.22
        @Override // com.baidu.tieba.frs.aj
        public void a(al alVar) {
        }

        @Override // com.baidu.tieba.frs.aj
        public void a(int i, int i2, ao aoVar) {
            if (i != 1) {
                com.baidu.tieba.card.u.XR().dC(false);
            }
            if (i == 1) {
                f.this.cqt.eD(true);
                f.this.cqt.eC(false);
            } else {
                f.this.cqt.eE(true);
                f.this.cqt.eC(true);
            }
            f.this.ahh();
            f.this.cqC.a(i, i2, aoVar);
        }

        @Override // com.baidu.tieba.frs.aj
        public void init() {
        }

        @Override // com.baidu.tieba.frs.aj
        public void Pl() {
        }
    };
    private CustomMessageListener crf = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIVE_COUNT) { // from class: com.baidu.tieba.frs.f.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                ((com.baidu.tieba.frs.entelechy.c.a) f.this.cqE).js(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    };
    private CustomMessageListener crg = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_LIVE_START) { // from class: com.baidu.tieba.frs.f.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && ((Integer) customResponsedMessage.getData()).intValue() == 51 && f.this.cpZ != null) {
                com.baidu.tieba.frs.g.j.a(f.this.cpZ, f.this.getPageContext());
            }
        }
    };
    private final CustomMessageListener crh = new CustomMessageListener(CmdConfigCustom.CMD_FRS_SELECT_ALA_LIVE_TAB) { // from class: com.baidu.tieba.frs.f.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (f.this.cqE instanceof com.baidu.tieba.frs.entelechy.c.a) && ((com.baidu.tieba.frs.entelechy.c.a) f.this.cqE).ajy() != null) {
                ((com.baidu.tieba.frs.entelechy.c.a) f.this.cqE).ajy().jV(49);
            }
        }
    };
    private final CustomMessageListener cri = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.frs.f.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && f.this.cpZ != null && f.this.cpZ.aMZ() != null) {
                SignData signData = (SignData) customResponsedMessage.getData();
                int user_level = f.this.cpZ.aMZ().getUser_level();
                if (signData.forumId != null && signData.forumId.equals(f.this.cpZ.aMZ().getId())) {
                    f.this.cpZ.d(signData);
                    f.this.cqD.g(f.this.cpZ);
                    if (f.this.cqD.alZ()) {
                        i = f.this.cpZ.aMZ().getUser_level();
                        if (user_level >= i) {
                            i++;
                        }
                    } else {
                        i = user_level;
                    }
                    TbadkCoreApplication.getInst().addSignedForum(f.this.cpZ.aMZ().getName(), signData.sign_bonus_point, i);
                }
            }
        }
    };
    private final CustomMessageListener crj = new CustomMessageListener(CmdConfigCustom.CMD_FRS_EXPERIENCE_TIP) { // from class: com.baidu.tieba.frs.f.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.o) && f.this.cpZ != null) {
                f.this.cpZ.c((com.baidu.tieba.tbadkCore.o) customResponsedMessage.getData());
                f.this.cqD.f(f.this.cpZ);
                f.this.cqE.a(f.this.cqt.getListView(), f.this.cpZ, f.this.cqC.ald());
            }
        }
    };
    private final AntiHelper.a crk = new AntiHelper.a() { // from class: com.baidu.tieba.frs.f.2
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12536").r("obj_locate", ap.a.ahm));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12535").r("obj_locate", ap.a.ahm));
        }
    };
    private CustomMessageListener biz = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.f.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(f.this.xH().getUniqueId())) {
                    if (updateAttentionMessage.getData().arE != null) {
                        if (AntiHelper.a(f.this.getActivity(), updateAttentionMessage.getData().arE, f.this.crk) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12534").r("obj_locate", ap.a.ahm));
                        }
                    } else if (updateAttentionMessage.getData().BY && updateAttentionMessage.getData().isAttention) {
                        com.baidu.adp.lib.util.l.showToast(f.this.xH().getPageActivity(), d.l.attention_success);
                    }
                }
            }
        }
    };
    private CustomMessageListener crl = new CustomMessageListener(CmdConfigCustom.CMD_STORY_READ_CACHE) { // from class: com.baidu.tieba.frs.f.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.story.process.b)) {
                com.baidu.tieba.story.process.b bVar = (com.baidu.tieba.story.process.b) customResponsedMessage.getData();
                if (f.this.forumId != null && f.this.forumId.equals(String.valueOf(bVar.forumId)) && bVar.state == 3 && f.this.ahk() != null && !com.baidu.tbadk.core.util.v.u(f.this.ahk().bpt()) && f.this.cqh.aiJ() != null && f.this.cqh.aiJ().aiZ() != null) {
                    List<com.baidu.adp.widget.ListView.f> bpt = f.this.ahk().bpt();
                    int size = bpt.size();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= size) {
                            i = -1;
                            break;
                        } else if ((bpt.get(i2) instanceof com.baidu.tbadk.data.e) && TbadkCoreApplication.getCurrentAccount().equals(String.valueOf(((com.baidu.tbadk.data.e) bpt.get(i2)).user_id))) {
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
                    eVar.azf = String.valueOf(f.this.forumId);
                    eVar.aze = bVar;
                    if (i != -1) {
                        bpt.set(i, eVar);
                    } else {
                        bpt.add(1, eVar);
                    }
                    f.this.cqh.aiJ().aiZ().b(bpt, f.this.forumId, f.this.getThreadId());
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.k crm = new com.baidu.tieba.tbadkCore.k() { // from class: com.baidu.tieba.frs.f.5
        private long startTime = 0;

        @Override // com.baidu.tieba.tbadkCore.k
        public void jb(int i) {
            this.startTime = System.nanoTime();
            if (f.this.cqt != null) {
                switch (i) {
                    case 1:
                    case 2:
                        f.this.cqt.ahA();
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
            if (f.this.blC) {
                f.this.blC = false;
                com.baidu.tieba.frs.g.h.a(f.this.cqt, f.this.cpZ, f.this.getForumId(), false, null);
            }
            f.this.agX();
            f.this.cqx = true;
            if (aVar != null && aVar.isSuccess) {
                f.this.cqt.ahK().eS(com.baidu.tbadk.core.util.an.vs().vu());
                f.cqu = 0L;
                f.cqv = 0L;
                f.cqw = 0;
            } else {
                f.cqw = 1;
            }
            if (!f.this.cqC.alh() && (i == 3 || i == 6)) {
                f.this.cqO.resetData();
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (f.this.cqC.akh() != null) {
                f.this.cpZ = f.this.cqC.akh();
            }
            if (i == 7) {
                f.this.iZ(f.this.cpZ.bpT());
                return;
            }
            if (f.this.cpZ.qx() != null) {
                f.this.setHasMore(f.this.cpZ.qx().qt());
            }
            f.this.agY();
            if (i == 4) {
                if (!f.this.cqC.alh() && TbadkCoreApplication.getInst().isRecAppExist() && f.this.cqC.akX() == 1) {
                    f.this.cpZ.a(f.this);
                }
                ArrayList<com.baidu.adp.widget.ListView.f> a2 = f.this.cqO.a(false, false, f.this.cpZ.getThreadList(), f.this.cqp);
                if (a2 != null) {
                    f.this.cpZ.az(a2);
                    f.this.cpZ.bqp();
                    f.this.cqt.a(a2, f.this.cpZ);
                }
                if (f.this.cqC != null) {
                    com.baidu.tieba.frs.f.b.a(f.this.cpZ, f.this.cqC.ald(), 2);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    f.this.cqt.ahA();
                    break;
                case 2:
                    f.this.cqt.ahA();
                    break;
                case 3:
                case 6:
                    if (f.this.cpZ != null) {
                        f.this.cpZ.bqn();
                    }
                    if (f.this.cqS != null) {
                        f.this.cqS.refresh();
                        break;
                    }
                    break;
            }
            f.this.agZ();
            if (aVar == null || aVar.errorCode == 0) {
                if (f.this.cpZ != null) {
                    f.this.cqt.jd(i);
                    f.this.t(false, i == 5);
                    f.cqu = (System.nanoTime() - this.startTime) / 1000000;
                    if (aVar != null) {
                        f.cqv = aVar.gdJ;
                    }
                } else {
                    return;
                }
            } else if (f.this.cpZ == null || com.baidu.tbadk.core.util.v.u(f.this.cpZ.getThreadList())) {
                f.this.a(aVar);
            } else if (aVar.gdI) {
                f.this.showToast(f.this.getPageContext().getResources().getString(d.l.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
            }
            if (f.this.cpZ.bpy() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11384"));
            }
            if (f.this.cde > -1 && !f.this.cqY) {
                com.baidu.tieba.frs.g.h.a(f.this.cqC, f.this.cde);
                f.this.cde = -1L;
                f.this.cqY = true;
            }
            if (f.this.cqq && (f.this.cqE instanceof com.baidu.tieba.frs.entelechy.c.a) && ((com.baidu.tieba.frs.entelechy.c.a) f.this.cqE).ajy() != null) {
                ((com.baidu.tieba.frs.entelechy.c.a) f.this.cqE).ajy().jV(49);
                f.this.cqq = false;
            }
            f.this.aJm = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.k
        public void b(com.baidu.tieba.tbadkCore.g gVar) {
            if (gVar != null) {
                if ("normal_page".equals(f.this.cqC.akT()) || "frs_page".equals(f.this.cqC.akT()) || "book_page".equals(f.this.cqC.akT())) {
                    f.this.a(gVar);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE, gVar));
                }
            }
        }
    };
    private final CustomMessageListener crn = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.frs.f.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.i) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                f.this.cpZ.a((com.baidu.tbadk.data.i) customResponsedMessage.getData());
                f.this.cqt.ahK().notifyDataSetChanged();
            }
        }
    };
    private final CustomMessageListener mMemListener = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_MEM) { // from class: com.baidu.tieba.frs.f.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && f.this.cpZ != null && (userData = f.this.cpZ.getUserData()) != null) {
                userData.setIsMem(num.intValue());
                if (num.intValue() != 0) {
                    f.this.cqD.f(num);
                }
            }
        }
    };
    private final com.baidu.tieba.frs.mc.i cro = new com.baidu.tieba.frs.mc.i() { // from class: com.baidu.tieba.frs.f.8
        @Override // com.baidu.tieba.frs.mc.i
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.f> arrayList, boolean z3) {
            if (f.this.cqG != null && f.this.cqC != null && f.this.cqC.alh() && z && !z2 && !z3) {
                f.this.cqG.jP(i2);
            }
        }
    };
    public final View.OnTouchListener aLZ = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.f.9
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (f.this.cqV != null) {
                f.this.cqV.onTouch(view, motionEvent);
            }
            if (f.this.cqI != null && f.this.cqI.aih() != null) {
                f.this.cqI.aih().onTouchEvent(motionEvent);
            }
            if (f.this.blb != null) {
                f.this.blb.d(view, motionEvent);
            }
            if (f.this.cqD != null) {
                f.this.cqD.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private final CustomMessageListener crp = new CustomMessageListener(CmdConfigCustom.CMD_GOTOLIVE_HOST_UPGRADE) { // from class: com.baidu.tieba.frs.f.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "photolive_hostLevel", -1) != -1 && f.this.cpZ.aMZ() != null) {
                f.this.cpZ.aMZ().setCanAddPhotoLivePost(true);
            }
        }
    };
    private final CustomMessageListener crq = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.frs.f.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11455").ad("obj_locate", "frs"));
                    com.baidu.tbadk.core.util.av.vH().c(f.this.getPageContext(), new String[]{str});
                }
            }
        }
    };
    public final View.OnClickListener crr = new View.OnClickListener() { // from class: com.baidu.tieba.frs.f.14
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (f.this.cqt == null || view != f.this.cqt.ahy() || f.this.getActivity() == null) {
                if (f.this.cpZ != null && f.this.cpZ.aMZ() != null) {
                    if (f.this.cqt == null || view != f.this.cqt.ahE()) {
                        if (f.this.cqt != null && view == f.this.cqt.ahF()) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12402").ad("fid", f.this.cpZ.aMZ().getId()).ad(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()).ad(ImageViewerConfig.FORUM_NAME, f.this.cpZ.aMZ().getName()));
                            if (!StringUtils.isNull(f.this.cpZ.aMZ().getName())) {
                                f.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PostSearchActivityConfig(f.this.getPageContext().getPageActivity(), f.this.cpZ.aMZ().getName(), f.this.cpZ.aMZ().getId())));
                                return;
                            }
                            return;
                        }
                    } else if (!StringUtils.isNull(f.this.cpZ.aMZ().getId())) {
                        if (f.this.cpZ.aMZ() != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12046").ad("fid", f.this.cpZ.aMZ().getId()).r("obj_locate", f.this.ahn() ? 1 : 2));
                        }
                        f.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(f.this.getPageContext().getPageActivity(), f.this.cpZ.aMZ().getId(), ForumDetailActivityConfig.FromType.FRS)));
                        return;
                    } else {
                        return;
                    }
                }
                if (view.getId() == d.h.game_activity_egg_layout && com.baidu.adp.lib.util.l.hy()) {
                    TiebaStatic.log("c10853");
                    if (f.this.cqt.ahH()) {
                        f.this.cqt.ahI();
                        return;
                    }
                    String activityUrl = f.this.cpZ.aMZ().getYuleData().tb().getActivityUrl();
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
    private final AbsListView.OnScrollListener crs = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.f.15
        private int crz = 0;
        private int beI = 0;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (f.this.aLY != null && f.this.isPrimary()) {
                f.this.aLY.a(absListView, this.crz, i, i2, i3);
            }
            if (f.this.cqE != null) {
                f.this.cqE.a(absListView, i, i2, i3, f.this.cqD.ame());
            }
            if (f.this.cqM != null) {
                f.this.cqM.alI();
            }
            if (f.this.cqG != null) {
                f.this.cqG.als();
            }
            if (f.this.cqW != null) {
                f.this.cqW.onScroll(absListView, i, i2, i3);
            }
            if (f.this.cpZ != null && f.this.cqt != null && f.this.cqt.ahK() != null) {
                this.crz = i;
                this.beI = (i + i2) - 1;
                f.this.cqt.ax(this.crz, this.beI);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (f.this.cqD != null) {
                f.this.cqD.setScrollState(i);
            }
            if (f.this.aLY != null && f.this.isPrimary()) {
                f.this.aLY.onScrollStateChanged(absListView, i);
            }
            if ((i == 2 || i == 1) && !f.this.cqy) {
                f.this.cqy = true;
                f.this.cqt.ahN();
            }
            if (f.this.cqz == null && !f.this.ahn()) {
                f.this.cqz = new com.baidu.tbadk.k.d();
                f.this.cqz.ft(1000);
            }
            if (i == 0) {
                com.baidu.tieba.card.u.XR().dC(true);
                f.this.cqt.aw(this.crz, this.beI);
            }
            if (f.this.cqW != null) {
                f.this.cqW.onScrollStateChanged(absListView, i);
            }
            if (f.this.cqz != null) {
                f.this.cqz.FJ();
            }
            if (i == 0) {
                com.baidu.tieba.frs.g.h.a(f.this.cqt, f.this.cpZ, f.this.getForumId(), false, null);
            }
        }
    };
    private final b crt = new b() { // from class: com.baidu.tieba.frs.f.16
        @Override // com.baidu.tieba.frs.b
        public void a(int i, int i2, View view, View view2, bh bhVar) {
            if (i != f.this.cqt.ahK().ajf()) {
                if (i != f.this.cqt.ahK().ajg()) {
                    if (i != f.this.cqt.ahK().aji()) {
                        if (i != f.this.cqt.ahK().ahX()) {
                            if (i == f.this.cqt.ahK().ajh() && f.this.cpZ != null && f.this.cpZ.getUserData() != null && f.this.cpZ.getUserData().isBawu()) {
                                final String bpR = f.this.cpZ.bpR();
                                if (!com.baidu.tbadk.core.util.am.isEmpty(bpR) && f.this.cpZ.aMZ() != null) {
                                    com.baidu.tieba.c.a.a(f.this.getPageContext(), f.this.cpZ.aMZ().getId(), f.this.cpZ.aMZ().getName(), new a.InterfaceC0078a() { // from class: com.baidu.tieba.frs.f.16.1
                                        @Override // com.baidu.tieba.c.a.InterfaceC0078a
                                        public void Xp() {
                                            com.baidu.tbadk.browser.a.T(f.this.getPageContext().getPageActivity(), bpR);
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10502").ad("fid", f.this.cpZ.aMZ().getId()).ad(SapiAccountManager.SESSION_UID, f.this.cpZ.getUserData().getUserId()));
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        f.this.cql = bhVar;
                        com.baidu.tieba.frs.g.i.a(f.this, f.this.cql);
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10179").ad("fid", f.this.getForumId()));
                        return;
                    }
                    com.baidu.tieba.frs.g.i.B(f.this);
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak(i == f.this.cqt.ahK().aji() ? "c10177" : "c10244").ad("fid", f.this.getForumId()));
                } else if (ax.aU(f.this.getPageContext().getPageActivity())) {
                    TiebaStatic.log("my_service_ck");
                    if (f.this.cpZ != null && f.this.cpZ.aMZ() != null) {
                        ForumData aMZ = f.this.cpZ.aMZ();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(f.this.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(aMZ.getId(), 0L), aMZ.getName(), aMZ.getImage_url(), 0)));
                    }
                }
            } else if (ax.aU(f.this.getActivity())) {
                TiebaStatic.log("forum_fortune_click");
                com.baidu.tieba.frs.g.i.a(f.this.getPageContext(), f.this.cpZ);
            }
        }
    };
    private final NoNetworkView.a coJ = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.f.17
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aM(boolean z) {
            if (f.this.cqC.akX() == 1 && z && !f.this.cqt.ahl()) {
                if (f.this.cpZ == null || com.baidu.tbadk.core.util.v.u(f.this.cpZ.getThreadList())) {
                    f.this.hideNetRefreshView(f.this.cqt.ahL());
                    f.this.showLoadingView(f.this.cqt.ahL(), true);
                    f.this.cqt.eE(false);
                    f.this.refresh();
                    return;
                }
                f.this.cqt.ahA();
            }
        }
    };
    private final CustomMessageListener cru = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.f.18
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                com.baidu.tieba.frs.g.c.a(customResponsedMessage, f.this.cqt, f.this.cpZ);
            }
        }
    };
    private com.baidu.adp.widget.ListView.h crv = new a();
    private al crw = new al() { // from class: com.baidu.tieba.frs.f.19
        @Override // com.baidu.tieba.frs.al
        public void a(int i, int i2, ar arVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
            com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tieba.frs.f.19.1
                @Override // java.lang.Runnable
                public void run() {
                    if (f.this.cqt != null && f.this.cqt.YM()) {
                        f.this.Ny();
                    }
                }
            });
        }
    };
    private CustomMessageListener crx = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.frs.f.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    f.this.cqX = true;
                }
            }
        }
    };

    public com.baidu.tieba.frs.entelechy.b.b agL() {
        return this.cqK;
    }

    public com.baidu.adp.widget.ListView.h agM() {
        return this.crv;
    }

    public com.baidu.tieba.frs.mc.d agN() {
        return this.cqN;
    }

    public com.baidu.tieba.frs.smartsort.b agO() {
        return this.cqG;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public FrsModelController agP() {
        return this.cqC;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public com.baidu.tieba.frs.mc.c agQ() {
        return this.cqO;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public com.baidu.tieba.frs.h.f agR() {
        return this.cqD;
    }

    public com.baidu.tieba.frs.entelechy.b.d agS() {
        return this.cqE;
    }

    public an agT() {
        return this.cqI;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public i agU() {
        return this.cqt;
    }

    @Override // com.baidu.tieba.frs.am
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.am
    public String getForumName() {
        return this.cqm;
    }

    public void setForumName(String str) {
        this.cqm = str;
    }

    public void setFrom(String str) {
        this.aiq = str;
    }

    public String getFrom() {
        return this.aiq;
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
        if (this.cqO == null) {
            return 1;
        }
        return this.cqO.getPn();
    }

    public int getPn() {
        if (this.cqO == null) {
            return 1;
        }
        return this.cqO.getPn();
    }

    public void setPn(int i) {
        if (this.cqO != null) {
            this.cqO.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.cqO != null) {
            this.cqO.setHasMore(i);
        }
    }

    public int agV() {
        if (this.cqO == null) {
            return -1;
        }
        return this.cqO.agV();
    }

    public boolean agW() {
        return this.cqr;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d.a aVar) {
        if (aVar == null) {
            String string = TbadkCoreApplication.getInst().getString(d.l.error_unkown_try_again);
            this.cqt.ahv();
            showNetRefreshView(this.cqt.ahL(), string, true);
        } else if (340001 == aVar.errorCode) {
            b(aVar);
        } else {
            if (com.baidu.tbadk.core.util.v.u(this.cpZ.getThreadList())) {
                c(aVar);
            }
            if (ahn()) {
                setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst(), d.f.ds280));
            } else {
                setNetRefreshViewEmotionDefMarginTop();
            }
        }
    }

    private void b(d.a aVar) {
        this.cqt.ahv();
        if (aVar.gdI) {
            showNetRefreshViewNoClick(this.cqt.ahL(), TbadkCoreApplication.getInst().getString(d.l.net_error_text, new Object[]{aVar.errorMsg, Integer.valueOf(aVar.errorCode)}), true);
        } else {
            showNetRefreshViewNoClick(this.cqt.ahL(), aVar.errorMsg, true);
        }
    }

    private void c(d.a aVar) {
        this.cqt.ahv();
        if (aVar.gdI) {
            showNetRefreshView(this.cqt.ahL(), TbadkCoreApplication.getInst().getString(d.l.net_error_text, new Object[]{aVar.errorMsg, Integer.valueOf(aVar.errorCode)}), true);
        } else {
            showNetRefreshView(this.cqt.ahL(), aVar.errorMsg, true);
        }
    }

    public void agX() {
        hideLoadingView(this.cqt.ahL());
        this.cqt.ahG();
        if (this.cqt.aht() instanceof com.baidu.tieba.frs.tab.c) {
            ((com.baidu.tieba.frs.tab.c) this.cqt.aht()).alC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agY() {
        if (agV() == 0 && com.baidu.tbadk.core.util.v.u(this.cpZ.bpE())) {
            if (com.baidu.tbadk.core.util.v.u(this.cpZ.getThreadList())) {
                this.cqt.YW();
                return;
            } else {
                this.cqt.ahP();
                return;
            }
        }
        this.cqt.ahO();
    }

    public void a(ErrorData errorData) {
        agX();
        this.cqt.ahA();
        d.a akU = this.cqC.akU();
        boolean u = com.baidu.tbadk.core.util.v.u(this.cpZ.getThreadList());
        if (akU != null && u) {
            if (u) {
                if (this.cqC.akV() != 0) {
                    this.cqC.alb();
                    this.cqt.ahA();
                } else {
                    a(akU);
                }
                this.cqt.u(this.cpZ.bqC(), false);
                return;
            } else if (akU.gdI) {
                this.cqt.u(true, false);
                showToast(getPageContext().getResources().getString(d.l.net_error_text, akU.errorMsg, Integer.valueOf(akU.errorCode)));
                return;
            } else {
                return;
            }
        }
        a(akU);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agZ() {
        if (this.cpZ == null || this.cpZ.aMZ() != null) {
            this.cqt.ahJ();
        } else if (this.cpZ.aMZ().getYuleData() != null && this.cpZ.aMZ().getYuleData().ta()) {
            TiebaStatic.log("c10852");
            this.cqt.a(this.cpZ.aMZ().getYuleData().tb());
        } else {
            this.cqt.ahJ();
        }
    }

    private void s(boolean z, boolean z2) {
        if (this.cqC != null && this.cpZ != null && this.cqt != null && z) {
            if (!this.cqC.alh() && this.cqC.akX() == 1) {
                if (!this.cqC.alf()) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        this.cpZ.bqu();
                        this.cpZ.bqr();
                    }
                    this.cpZ.bqs();
                    this.cpZ.bqt();
                }
                boolean z3 = false;
                if (this.cqt.ahK().l(com.baidu.tieba.card.data.p.bNV)) {
                    z3 = this.cpZ.bqx();
                }
                if (!z3) {
                    this.cpZ.bqv();
                }
                if (TbadkCoreApplication.getInst().isRecAppExist()) {
                    this.cpZ.a(this);
                }
                if (!this.cqt.ahK().l(bh.Ym)) {
                    this.cpZ.bqo();
                }
                this.cpZ.bqy();
                this.cpZ.bqz();
            }
            this.cpZ.bqp();
            this.cpZ.bqm();
            if (this.cqt.ahK().l(com.baidu.tieba.g.b.cPd)) {
                this.cpZ.mz(z2);
            }
            if (TbadkCoreApplication.isLogin()) {
                if (!this.cqC.alh() || this.cqC.isNetFirstLoad) {
                    this.cpZ.bqA();
                }
            }
        }
    }

    public boolean aha() {
        if (this.cqE != null && this.cqt != null) {
            this.cqE.b(this.cqt.getListView());
        }
        if (this.cqD != null && this.cqC != null) {
            this.cqD.a(this.cqC.akT(), this.cpZ);
        }
        boolean z = false;
        if (this.cpZ != null) {
            z = this.cpZ.bqD();
        }
        ex(z);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iZ(int i) {
        ao aoVar = null;
        aha();
        ahh();
        try {
            if (this.cpZ != null) {
                this.cqt.a((ArrayList<com.baidu.adp.widget.ListView.f>) null, this.cpZ);
                this.cqD.kd(1);
                this.cqt.ahD();
                this.cqE.a(this.cqt.getListView(), this.cpZ, this.cqC.ald());
                com.baidu.tieba.frs.tab.d a2 = a(this.cqE.ajr(), this.cpZ.bpT());
                if (a2 != null && !TextUtils.isEmpty(a2.url)) {
                    aoVar = new ao();
                    aoVar.ctH = a2.url;
                    aoVar.stType = a2.name;
                }
                this.cqC.a(this.cpZ.bpT(), 0, aoVar);
                this.cqE.eV(false);
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
            if (dVar != null && dVar.cDa == i) {
                return dVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(boolean z, boolean z2) {
        AlaLiveNotify bqf;
        try {
            if (this.cpZ != null && this.cqE != null && this.cqC != null) {
                if (!this.cqt.ahK().l(bh.Ym)) {
                    this.cpZ.bqo();
                }
                boolean u = com.baidu.tbadk.core.util.v.u(this.cpZ.bqg());
                this.cqt.eB(u);
                if (!u) {
                    if (this.cqW == null) {
                        this.cqW = new com.baidu.tieba.frs.h.e(this, (NoPressedRelativeLayout) this.mRootView);
                    }
                    if (this.blb == null) {
                        this.blb = new com.baidu.tieba.frs.gametab.a(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
                    }
                } else {
                    this.cqW = null;
                    this.blb = null;
                }
                if (this.cpZ.aMZ() != null) {
                    this.cqm = this.cpZ.aMZ().getName();
                    this.forumId = this.cpZ.aMZ().getId();
                }
                if (this.cpZ.bqD()) {
                    this.cqE.a(this.cqt.getListView(), this.cpZ, this.cqC.ald());
                }
                if (z) {
                    s(true, z);
                } else {
                    s(this.cqB, z);
                }
                aha();
                if (this.cqK != null) {
                    this.cqK.a(this.cqD, this.cpZ);
                }
                if (this.cpZ.qx() != null) {
                    setHasMore(this.cpZ.qx().qt());
                }
                ArrayList<com.baidu.adp.widget.ListView.f> a2 = this.cqO.a(z2, true, this.cpZ.getThreadList(), null, z);
                if (a2 != null) {
                    this.cpZ.az(a2);
                }
                if (this.cqC.akX() == 1) {
                    ahe();
                    if (!z && this.cqC.getPn() == 1 && (bqf = ahk().bqf()) != null) {
                        new com.baidu.tieba.frs.d.a().a(this, bqf);
                    }
                }
                this.cqb = this.cpZ.akZ();
                if (this.cqp != null) {
                    this.cqo = true;
                    this.cqp.tx(this.cqb);
                    com.baidu.tieba.frs.g.a.a(this, this.cpZ.aMZ(), this.cpZ.getThreadList(), this.cqo, getPn());
                }
                if (this.cqM != null) {
                    this.cqM.aw(this.cqE.ajs());
                }
                agX();
                this.cqt.ahw();
                this.cqt.u(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.g gVar) {
        try {
            if (!this.cqx && gVar != null && this.cpZ != null) {
                this.cpZ.e(gVar);
                t(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void ex(boolean z) {
        if (this.cqC != null) {
            f(z, this.cqC.akT());
        } else {
            f(z, "normal_page");
        }
    }

    private void f(boolean z, String str) {
        ey("frs_page".equals(str));
        if (this.cqK != null) {
            this.cqK.a(z, this.cqE, this.cqD, this.cqt, this.cpZ);
        }
    }

    public void ey(boolean z) {
        if (this.cqP != null) {
            this.cqP.a(this.cqt, z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(d.j.frs_activity, viewGroup, false);
            this.cqh = new com.baidu.tieba.frs.entelechy.b();
            this.cqK = this.cqh.aiI();
            this.cqD = new com.baidu.tieba.frs.h.f(this, this.cqh);
            this.cqE = this.cqh.z(this);
            Intent intent = getActivity().getIntent();
            if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                this.cqj = true;
            }
            this.cqt = new i(this, this.crr, this.cqh, this.cqj);
            this.cqt.setHeaderViewHeight(this.cqU);
        } else if (this.mRootView.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            this.cqt.ahS();
        }
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Intent intent = getActivity().getIntent();
        this.cde = System.currentTimeMillis();
        if (intent != null) {
            this.cqq = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.cde = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            K(intent);
        }
        this.WC = System.currentTimeMillis();
        this.aJe = this.WC - this.cde;
        this.cqp = new com.baidu.tieba.tbadkCore.data.e("frs", com.baidu.tieba.tbadkCore.data.e.ggh);
        this.cqC = new FrsModelController(this, this.crm);
        this.cqC.a(this.crd);
        this.cqC.init();
        if (intent != null) {
            this.cqC.i(intent.getExtras());
        } else if (bundle != null) {
            this.cqC.i(bundle);
        } else {
            this.cqC.i(null);
        }
        this.cqE.as(this.cqt.ahL());
        if (intent != null) {
            this.cqD.l(intent.getExtras());
        } else if (bundle != null) {
            this.cqD.l(bundle);
        } else {
            this.cqD.l((Bundle) null);
        }
        this.cqs = getVoiceManager();
        this.cqR = new h(getPageContext(), this);
        initUI();
        initData(bundle);
        if (this.aiq != null && this.aiq.equals("from_tieba_kuang")) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12264").r("obj_type", 1).ad(ImageViewerConfig.FORUM_NAME, this.cqC.getForumName()));
            KuangFloatingViewController.getInstance().setNeedShowFloatingView(true);
            KuangFloatingViewController.getInstance().showFloatingView();
        }
        if (!ahn()) {
            this.cqI = new an(getActivity(), this.cqt, this.cqD);
            this.cqI.eL(true);
        }
        this.cqs = getVoiceManager();
        if (this.cqs != null) {
            this.cqs.onCreate(getPageContext());
        }
        new com.baidu.tieba.frs.mc.g();
        this.cqO = new com.baidu.tieba.frs.mc.c(this, this.cro);
        this.cqG = new com.baidu.tieba.frs.smartsort.b(this);
        this.cqP = new com.baidu.tieba.frs.h.h(this);
        this.createTime = System.currentTimeMillis() - this.WC;
        this.cqM = new com.baidu.tieba.frs.h.a(getPageContext(), this.cqC.ale());
        this.cqH = new com.baidu.tieba.frs.mc.b(this);
        this.cqN = new com.baidu.tieba.frs.mc.d(this);
        this.cqF = new com.baidu.tieba.frs.mc.f(this);
        this.cqQ = new com.baidu.tieba.frs.mc.a(this);
        this.cqS = new com.baidu.tieba.frs.h.c(this);
        this.cqT = new com.baidu.tieba.frs.mc.e(this, getUniqueId());
        this.cqZ = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "frs");
        registerListener(this.biz);
        registerListener(this.mMemListener);
        registerListener(this.crj);
        registerListener(this.crp);
        registerListener(this.cri);
        registerListener(this.crn);
        registerListener(this.crf);
        registerListener(this.crg);
        registerListener(this.crh);
        registerListener(this.cra);
        registerListener(this.crb);
        registerListener(this.crx);
        registerListener(this.crl);
        this.cqt.eE(false);
        if (!ahn()) {
            showLoadingView(this.cqt.ahL(), true);
            this.cqC.o(3, true);
        }
        super.onActivityCreated(bundle);
    }

    @Override // com.baidu.tieba.frs.ai
    public void NJ() {
        if (isAdded() && this.blC && !isLoadingViewAttached()) {
            showLoadingView(this.cqt.ahL(), true);
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void NK() {
        if (isAdded() && this.blC && isLoadingViewAttached()) {
            hideLoadingView(this.cqt.ahL());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (ahn()) {
            showLoadingView(this.cqt.ahL(), true);
            this.cqt.jc(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.cqC.o(3, true);
            getListView().setSelection(0);
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void setHeaderViewHeight(int i) {
        this.cqU = i;
        if (this.cqt != null) {
            this.cqt.setHeaderViewHeight(this.cqU);
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.q qVar) {
        if (qVar != null) {
            this.aLY = qVar.GS();
            this.cqV = qVar.GT();
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void showFloatingView() {
        if (this.aLY != null) {
            this.aLY.cf(true);
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
            this.cqm = data.getQueryParameter("name");
            this.aiq = data.getQueryParameter("from");
            if (!StringUtils.isNull(this.cqm)) {
                intent.putExtra("name", this.cqm);
            }
            if (!StringUtils.isNull(this.aiq)) {
                intent.putExtra("from", this.aiq);
            }
            TiebaStatic.log("c10105");
        }
        if (StringUtils.isNull(this.cqm)) {
            this.cqm = com.baidu.tieba.frs.g.i.M(intent);
            if (!StringUtils.isNull(this.cqm)) {
                intent.putExtra("name", this.cqm);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.cqs = getVoiceManager();
        if (this.cqs != null) {
            this.cqs.onStart(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        Intent intent;
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.cru);
        if (bundle != null) {
            this.cqm = bundle.getString("name");
            this.aiq = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
            this.cqm = intent.getStringExtra("name");
            this.aiq = intent.getStringExtra("from");
            this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
        }
        if (TextUtils.isEmpty(this.aiq) || FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.aiq)) {
        }
        if (this.mIsLogin) {
            registerListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL, this.cru);
        }
        this.cqD.l(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.crx);
        if (this.cqs != null) {
            this.cqs.onDestory(getPageContext());
        }
        this.cqs = null;
        com.baidu.tieba.card.u.XR().dC(false);
        if (this.cpZ != null && this.cpZ.aMZ() != null) {
            ad.aid().bf(com.baidu.adp.lib.g.b.c(this.cpZ.aMZ().getId(), 0L));
        }
        if (this.cqt != null) {
            com.baidu.tieba.frs.g.h.a(this.cqt, this.cpZ, getForumId(), false, null);
            this.cqt.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.cqz != null) {
                this.cqz.onDestroy();
            }
            this.cqt.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.cqC.onActivityDestroy();
        this.cqD.onActivityDestroy();
        if (this.cqA != null) {
            this.cqA.cancel(true);
            this.cqA = null;
        }
        if (this.cqC != null) {
            this.cqC.Pl();
        }
        if (this.cqI != null) {
            this.cqI.GR();
        }
        if (this.cqL != null) {
            this.cqL.destory();
        }
        if (this.cqM != null) {
            this.cqM.destory();
        }
        if (this.cqG != null) {
            this.cqG.onDestroy();
        }
        if (this.cqW != null) {
            this.cqW.onDestory();
        }
        if (this.cqQ != null) {
            this.cqQ.onDestroy();
        }
        if (this.cqZ != null) {
            this.cqZ.onDestroy();
        }
        com.baidu.tieba.recapp.d.a.bgy().bgA();
        com.baidu.tieba.frs.g.j.alF();
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.cqm);
        bundle.putString("from", this.aiq);
        this.cqC.onSaveInstanceState(bundle);
        if (this.cqs != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            this.cqs.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.cqQ != null) {
            this.cqQ.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.cqt != null) {
            this.cqt.ahA();
            this.cqt.onResume();
        }
        this.cqE.a(this.cre);
        this.cqF.fe(true);
        this.cqB = true;
        if (cqk) {
            cqk = false;
            this.cqt.startPullRefresh();
            return;
        }
        if (this.cqs != null) {
            this.cqs.onResume(getPageContext());
        }
        this.cqt.eF(false);
        registerListener(this.crq);
        if (this.cqX) {
            cm(6);
            this.cqX = false;
        }
        KuangFloatingViewController.getInstance().showFloatingView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        refresh();
    }

    public boolean ahb() {
        Intent intent;
        if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
            return false;
        }
        return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
    }

    public void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.cqm = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.aiq = intent.getStringExtra("from");
            }
            this.cqn = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.cqn) {
                ahc();
            }
            if (this.aiq != null && this.aiq.equals("from_tieba_kuang")) {
                KuangFloatingViewController.getInstance().setNeedShowFloatingView(true);
                KuangFloatingViewController.getInstance().showFloatingView();
            }
        }
    }

    private void ahc() {
        this.cqt.startPullRefresh();
    }

    public void closeActivity() {
        com.baidu.tieba.frs.g.i.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.aiq);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.cqt.setTitle(this.cqm);
        } else {
            this.cqt.setTitle("");
            this.mFlag = 1;
        }
        this.cqD.d(this.cqt.getListView());
        this.cqt.setOnAdapterItemClickListener(this.crv);
        this.cqt.setOnScrollListener(this.crs);
        this.cqt.h(this.coJ);
        this.cqt.ahK().a(this.crt);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cqt.onChangeSkinType(i);
        this.cqD.kc(i);
        this.cqE.onChangeSkinType(i);
    }

    public void ja(int i) {
        if (!this.mIsLogin) {
            if (this.cpZ != null && this.cpZ.qh() != null) {
                this.cpZ.qh().setIfpost(1);
            }
            if (i == 0) {
                ax.aT(getActivity());
            }
        } else if (this.cpZ != null) {
            if (i == 0) {
                com.baidu.tieba.frs.g.j.b(this, 0);
            } else {
                this.cqt.ahC();
            }
        }
    }

    public void refresh() {
        cm(3);
    }

    public void cm(int i) {
        this.cqx = false;
        ahh();
        if (this.cqt.ahs() != null) {
            this.cqt.ahs().ard();
        }
        this.cqC.o(i, true);
    }

    private void ahd() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.g.h.fQ().d(new Runnable() { // from class: com.baidu.tieba.frs.f.13
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.rT(f.this.cqm);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahe() {
        ahh();
        try {
            if (this.cpZ != null) {
                this.cqt.Od();
                this.cqt.eA(this.cqC.akY());
                if (com.baidu.tieba.frs.h.f.i(this.cpZ) && !com.baidu.tieba.frs.h.f.h(this.cpZ)) {
                    this.cqt.ahQ();
                }
                if (this.cpZ.aMZ() != null) {
                    this.cqm = this.cpZ.aMZ().getName();
                    this.forumId = this.cpZ.aMZ().getId();
                }
                if (this.cpZ.qx() != null) {
                    setHasMore(this.cpZ.qx().qt());
                }
                this.cqt.setTitle(this.cqm);
                this.cqt.setForumName(this.cqm);
                TbadkCoreApplication.getInst().setDefaultBubble(this.cpZ.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.cpZ.getUserData().getBimg_end_time());
                ahd();
                ahf();
                ArrayList<com.baidu.adp.widget.ListView.f> threadList = this.cpZ.getThreadList();
                if (threadList != null) {
                    this.cqt.a(threadList, this.cpZ);
                    com.baidu.tieba.frs.g.c.j(this.cqt);
                    this.cqD.kd(getPageNum());
                    this.cqD.f(this.cpZ);
                    this.cqE.a(this.cqt.getListView(), this.cpZ, this.cqC.ald());
                    this.cqt.ahD();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void ahf() {
        if (this.cpZ != null) {
            if (this.cpZ.aNn() == 1) {
                this.cqt.ahK().setFromCDN(true);
            } else {
                this.cqt.ahK().setFromCDN(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.cqF.fe(false);
        this.cqB = false;
        this.cqt.onPause();
        if (this.cqs != null) {
            this.cqs.onPause(getPageContext());
        }
        this.cqt.eF(true);
        if (this.cqM != null) {
            this.cqM.alI();
        }
        MessageManager.getInstance().unRegisterListener(this.crq);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.u.XR().dC(false);
        if (this.cpZ != null && this.cpZ.aMZ() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            com.baidu.tbadk.distribute.a.Cj().a(getPageContext().getPageActivity(), "frs", this.cpZ.aMZ().getId(), 0L);
        }
        if (this.cqs != null) {
            this.cqs.onStop(getPageContext());
        }
        com.baidu.tieba.frs.g.i.a(getListView());
        this.cqD.onActivityStop();
        r.GV();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || this.cqt == null) {
            return false;
        }
        return this.cqt.ahz();
    }

    @Override // com.baidu.tieba.recapp.o
    public TbPageContext<?> xH() {
        return getPageContext();
    }

    @Override // com.baidu.tieba.recapp.o
    public void a(AdvertAppInfo advertAppInfo, String str) {
        com.baidu.tbadk.distribute.a.Cj().a(advertAppInfo, this.forumId, 0L, "FRS", str, getPn());
    }

    @Override // com.baidu.tieba.recapp.o
    public void ahg() {
        agP().ahg();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.cqs == null) {
            this.cqs = VoiceManager.instance();
        }
        return this.cqs;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public BdListView getListView() {
        if (this.cqt == null) {
            return null;
        }
        return this.cqt.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void ahh() {
        if (this.cqs != null) {
            this.cqs.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> wN() {
        if (this.aoo == null) {
            this.aoo = UserIconBox.j(getPageContext().getPageActivity(), 8);
        }
        return this.aoo;
    }

    public void ahi() {
        if (getFragmentActivity() != null && getFragmentActivity().getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.a(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.g onGetPreLoadListView() {
        return getListView();
    }

    @Override // com.baidu.tieba.frs.ak
    public NavigationBar ahj() {
        if (this.cqt == null) {
            return null;
        }
        return this.cqt.ahj();
    }

    /* loaded from: classes.dex */
    private final class a implements com.baidu.adp.widget.ListView.h {
        private a() {
        }

        @Override // com.baidu.adp.widget.ListView.h
        public void a(View view, com.baidu.adp.widget.ListView.f fVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            boolean z;
            if (bdUniqueId != null) {
                if (bdUniqueId == p.csP) {
                    if (f.this.cqt != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11752").ad("fid", f.this.forumId).ad("obj_locate", "1"));
                        f.this.cqt.startPullRefresh();
                    }
                } else if (fVar != null && (fVar instanceof bh)) {
                    bh bhVar = (bh) fVar;
                    if (bhVar.sg() == null || bhVar.sg().getGroup_id() == 0 || ax.aU(f.this.getActivity())) {
                        if ((bhVar.rZ() != 1 && bhVar.rZ() != 2) || ax.aU(f.this.getActivity())) {
                            if (bhVar.rI() != null) {
                                if (ax.aU(f.this.getActivity())) {
                                    String postUrl = bhVar.rI().getPostUrl();
                                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.hy()) {
                                        com.baidu.tbadk.browser.a.U(f.this.getActivity(), postUrl);
                                    }
                                }
                            } else if (bhVar.sr() != null) {
                                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                    ax.aT(f.this.getPageContext().getPageActivity());
                                    return;
                                }
                                com.baidu.tbadk.core.data.n sr = bhVar.sr();
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(f.this.getPageContext().getPageActivity(), sr.getCartoonId(), sr.getChapterId(), 2)));
                            } else if (bhVar.getThreadType() == 47 && bhVar.rq() == 1 && !com.baidu.tbadk.core.util.am.isEmpty(bhVar.rC())) {
                                com.baidu.tbadk.browser.a.T(f.this.getPageContext().getPageActivity(), bhVar.rC());
                            } else {
                                com.baidu.tieba.tbadkCore.util.e readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                                if (readThreadHistory != null && !readThreadHistory.rZ(bhVar.getId())) {
                                    readThreadHistory.rY(bhVar.getId());
                                }
                                final String rC = bhVar.rC();
                                if (rC == null || rC.equals("")) {
                                    z = false;
                                } else {
                                    new Thread(new Runnable() { // from class: com.baidu.tieba.frs.f.a.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(rC);
                                            xVar.uN().vJ().mIsNeedAddCommenParam = false;
                                            xVar.uN().vJ().mIsUseCurrentBDUSS = false;
                                            xVar.uq();
                                        }
                                    }).start();
                                    z = true;
                                }
                                String tid = bhVar.getTid();
                                if (tid == null) {
                                    tid = "";
                                }
                                if (bhVar.rq() == 2 && !tid.startsWith("pb:")) {
                                    com.baidu.tbadk.core.util.av.vH().c(f.this.getPageContext(), new String[]{tid, "", null});
                                } else if (bhVar.getThreadType() == 33 || (bhVar instanceof aw)) {
                                    String str = bhVar.getThreadType() == 33 ? "c10245" : "c10180";
                                    if (f.this.cqC.akX() == 5) {
                                        str = "c10387";
                                    }
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak(str).ad("fid", f.this.forumId));
                                    com.baidu.tieba.frs.g.i.c(f.this, bhVar);
                                    if (f.this.cpZ != null && f.this.cpZ.aMZ() != null) {
                                        com.baidu.tieba.frs.f.a aVar = new com.baidu.tieba.frs.f.a();
                                        aVar.cFS = f.this.cpZ.gek == 1;
                                        aVar.cFU = f.this.cpZ.aMZ().getId();
                                        aVar.cFT = f.this.agP().ald();
                                        com.baidu.tieba.frs.f.b.aly().a(aVar, bhVar, 1);
                                    }
                                } else {
                                    if (tid.startsWith("pb:")) {
                                        bhVar.setId(tid.substring(3));
                                    }
                                    if (bdUniqueId.getId() == bh.Zs.getId()) {
                                        com.baidu.tieba.frs.g.h.a(bhVar.rc());
                                        com.baidu.tieba.frs.g.i.b(f.this, bhVar);
                                        return;
                                    }
                                    com.baidu.tieba.frs.g.i.a(f.this, bhVar, i, z);
                                    com.baidu.tieba.frs.g.h.a(f.this, f.this.cpZ, bhVar);
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
            hideNetRefreshView(this.cqt.ahL());
            showLoadingView(this.cqt.ahL(), true);
            this.cqt.eE(false);
            this.cqC.o(3, true);
        }
    }

    public com.baidu.tieba.tbadkCore.i ahk() {
        return this.cpZ;
    }

    public boolean ahl() {
        return this.cqt.ahl();
    }

    public void N(Object obj) {
        if (this.cqH != null && this.cqH.cEM != null) {
            this.cqH.cEM.f(obj);
        }
    }

    public void O(Object obj) {
        if (this.cqH != null && this.cqH.cEN != null) {
            this.cqH.cEN.f(obj);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.l.hy()) {
            this.cqt.YW();
        } else if (this.cqC.akX() == 1) {
            NF();
            Ny();
        } else if (this.cqC.hasMore()) {
            Ny();
        }
    }

    public void kx(String str) {
        NF();
        showToast(str);
    }

    public void G(ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        NF();
        if (!com.baidu.tbadk.core.util.v.u(arrayList)) {
            if (!this.cqC.alh() && TbadkCoreApplication.getInst().isRecAppExist() && this.cqC.akX() == 1) {
                this.cpZ.a(this, arrayList);
            }
            ArrayList<com.baidu.adp.widget.ListView.f> a2 = this.cqO.a(false, false, arrayList, this.cqp);
            if (a2 != null) {
                this.cpZ.az(a2);
                this.cqt.a(a2, this.cpZ);
            }
            if (this.cqC != null) {
                com.baidu.tieba.frs.f.b.a(this.cpZ, this.cqC.ald(), 2);
            }
        }
    }

    private void NF() {
        if (agV() == 1 || this.cqO.aO(this.cpZ.bpE())) {
            this.cqt.ahO();
        } else if (com.baidu.tbadk.core.util.v.u(this.cpZ.getThreadList())) {
            this.cqt.YW();
        } else {
            this.cqt.ahP();
        }
    }

    @Override // com.baidu.tieba.frs.mc.j
    public void Ny() {
        if (this.cqO != null) {
            this.cqO.a(this.cqm, this.forumId, this.cpZ);
        }
    }

    public void ahm() {
        if (!com.baidu.tbadk.core.util.ab.d(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.ai.c(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return ahn() ? "a034" : "a006";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (!ahn()) {
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

    public void ez(boolean z) {
        if (this.cqI != null) {
            this.cqI.eL(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.cqJ.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a fW(int i) {
        return this.cqJ.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        this.cqR.b(bVar);
    }

    public boolean ahn() {
        return this.cqj;
    }

    @Override // com.baidu.tieba.frs.ai
    public void NI() {
        if (this.cqt != null) {
            showFloatingView();
            this.cqt.getListView().setSelection(0);
            this.cqt.startPullRefresh();
        }
    }

    public ForumWriteData aho() {
        if (this.cpZ == null || this.cpZ.aMZ() == null) {
            return null;
        }
        ForumData aMZ = this.cpZ.aMZ();
        ForumWriteData forumWriteData = new ForumWriteData(aMZ.getId(), aMZ.getName(), aMZ.getPrefixData(), this.cpZ.qh());
        forumWriteData.setForumLevel(aMZ.getUser_level());
        forumWriteData.setAvatar(this.cpZ.aMZ().getImage_url());
        return forumWriteData;
    }

    @Override // com.baidu.tieba.frs.ai
    public void wB() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void cJ(boolean z) {
        if (this.cqt != null) {
            this.cqt.cJ(z);
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void setVideoThreadId(String str) {
    }
}
