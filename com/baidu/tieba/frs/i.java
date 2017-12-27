package com.baidu.tieba.frs;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
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
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.util.t;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.c.a;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.f.i;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.frs.view.FrsHeaderViewContainer;
import com.baidu.tieba.tbadkCore.d;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPage.RecmForumInfo;
/* loaded from: classes2.dex */
public class i extends BaseFragment implements BdListView.e, a.InterfaceC0036a, UserIconBox.b<com.baidu.adp.widget.ListView.h>, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, aj, am, ao, com.baidu.tieba.frs.loadmore.a, com.baidu.tieba.frs.mc.j, com.baidu.tieba.recapp.o {
    private com.baidu.tbadk.util.r bBb;
    private com.baidu.adp.lib.e.b<TbImageView> bcT;
    private com.baidu.tieba.frs.gametab.b cfY;
    private com.baidu.tieba.tbadkCore.data.e dwD;
    private VoiceManager dwG;
    private FrsModelController dwP;
    private com.baidu.tieba.frs.f.f dwQ;
    private com.baidu.tieba.frs.f.i dwR;
    private com.baidu.tieba.frs.mc.f dwS;
    private com.baidu.tieba.frs.smartsort.b dwT;
    private com.baidu.tieba.frs.mc.b dwU;
    private ap dwV;
    private com.baidu.tieba.frs.entelechy.b.b dwX;
    private com.baidu.tbadk.h.a dwY;
    private com.baidu.tieba.frs.f.a dwZ;
    private com.baidu.tieba.frs.entelechy.b dwv;
    public be dwz;
    private com.baidu.tieba.frs.mc.d dxa;
    private com.baidu.tieba.frs.mc.c dxb;
    private com.baidu.tieba.frs.f.h dxc;
    private com.baidu.tieba.frs.mc.a dxd;
    private com.baidu.tieba.frs.live.a dxe;
    private j dxf;
    public com.baidu.tieba.frs.f.c dxg;
    private com.baidu.tieba.frs.mc.e dxh;
    private int dxi;
    private View.OnTouchListener dxj;
    private com.baidu.tieba.frs.view.b dxk;
    private com.baidu.tieba.frs.f.e dxl;
    private boolean dxm;
    private com.baidu.tieba.NEGFeedBack.a dxo;
    private com.baidu.tieba.ala.a dxp;
    public View mRootView;
    public static boolean dwy = false;
    public static volatile long dwI = 0;
    public static volatile long dwJ = 0;
    public static volatile int dwK = 0;
    public boolean dww = false;
    private boolean dwx = false;
    public String dwA = null;
    public String mFrom = null;
    public int mFlag = 0;
    private boolean dwB = false;
    private String mThreadId = null;
    public String forumId = null;
    private int dwp = 0;
    private boolean dwC = false;
    private boolean dwE = false;
    private boolean dwF = false;
    private k dwH = null;
    public final be bXF = null;
    private com.baidu.tieba.tbadkCore.l dwm = new com.baidu.tieba.tbadkCore.l();
    public long dhW = -1;
    public long byn = 0;
    public long byf = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean dwL = false;
    private boolean dwM = false;
    public com.baidu.tbadk.k.d dwN = null;
    private boolean dwO = true;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> dwW = new SparseArray<>();
    private boolean chh = true;
    private boolean dxn = false;
    private final CustomMessageListener dxq = new CustomMessageListener(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED) { // from class: com.baidu.tieba.frs.i.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof be) {
                    com.baidu.tieba.frs.e.g.a(i.this.dwH, i.this.dwm, i.this.getForumId(), true, (be) data);
                }
            }
        }
    };
    private CustomMessageListener dxr = new CustomMessageListener(CmdConfigCustom.CMD_CLOSE_GAME_RANK_CARD) { // from class: com.baidu.tieba.frs.i.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (i.this.dwm != null) {
                i.this.dwm.bBl();
                if (i.this.dwH != null) {
                    i.this.dwH.akL();
                }
            }
        }
    };
    private CustomMessageListener dxs = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.i.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 1) {
                    i.this.atf();
                }
            }
        }
    };
    private final an dxt = new an() { // from class: com.baidu.tieba.frs.i.28
        @Override // com.baidu.tieba.frs.an
        public void a(int i, int i2, at atVar, ArrayList<com.baidu.adp.widget.ListView.i> arrayList) {
            i.this.asY();
            if (i.this.dwX != null) {
                i.this.dwQ.gc(i.this.dwX.ng(i));
            }
            d.a aVar = new d.a();
            if (atVar != null) {
                aVar.isSuccess = atVar.errCode == 0;
                aVar.errorCode = atVar.errCode;
                aVar.errorMsg = atVar.errMsg;
                if (aVar.isSuccess) {
                    if (v.G(arrayList)) {
                        i.this.dwH.akM();
                    } else if (atVar.hasMore) {
                        if (v.F(i.this.dwm.getThreadList()) > 3) {
                            i.this.dwH.atP();
                        } else {
                            i.this.dwH.atR();
                        }
                    } else if (atVar.dzJ) {
                        i.this.dwH.atQ();
                    } else {
                        i.this.dwH.akM();
                    }
                }
            } else {
                atVar = new at();
                atVar.pn = 1;
                atVar.hasMore = false;
                atVar.dzJ = false;
            }
            if (i == 1) {
                i.this.dwO = true;
                i.this.dxD.a(i.this.dwP.getType(), false, aVar);
            } else {
                i.this.a(aVar);
                if (i.this.dwP.awN() != null) {
                    i.this.dwm = i.this.dwP.awN();
                }
                i.this.ath();
            }
            if (i.this.dxM != null) {
                i.this.dxM.a(i, i2, atVar, arrayList);
            }
        }
    };
    private ak dxu = new ak() { // from class: com.baidu.tieba.frs.i.29
        @Override // com.baidu.tieba.frs.ak
        public void a(an anVar) {
        }

        @Override // com.baidu.tieba.frs.ak
        public void a(int i, int i2, aq aqVar) {
            if (i != 1) {
                com.baidu.tieba.card.s.ajC().eB(false);
            }
            i.this.atk();
            i.this.dwP.a(i, i2, aqVar);
        }

        @Override // com.baidu.tieba.frs.ak
        public void init() {
        }

        @Override // com.baidu.tieba.frs.ak
        public void Yi() {
        }
    };
    private i.b dxv = new i.b() { // from class: com.baidu.tieba.frs.i.30
        @Override // com.baidu.tieba.frs.f.i.b
        public void hZ(int i) {
            if (i != 1) {
                com.baidu.tieba.card.s.ajC().eB(false);
            }
            i.this.atk();
            com.baidu.tieba.frs.d.c.dMh.dLY = i;
            com.baidu.tieba.frs.d.c.dMh.dLZ = -1;
        }
    };
    private CustomMessageListener dxw = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIVE_COUNT) { // from class: com.baidu.tieba.frs.i.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                i.this.dwR.nS(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    };
    private CustomMessageListener dxx = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_LIVE_START) { // from class: com.baidu.tieba.frs.i.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && ((Integer) customResponsedMessage.getData()).intValue() == 51 && i.this.dwm != null) {
                com.baidu.tieba.frs.e.i.a(i.this.dwm, i.this.getPageContext());
            }
        }
    };
    private final CustomMessageListener dxy = new CustomMessageListener(CmdConfigCustom.CMD_FRS_SELECT_ALA_LIVE_TAB) { // from class: com.baidu.tieba.frs.i.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                i.this.dwR.nQ(49);
            }
        }
    };
    private final CustomMessageListener dxz = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.frs.i.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && i.this.dwm != null && i.this.dwm.aYy() != null) {
                SignData signData = (SignData) customResponsedMessage.getData();
                int user_level = i.this.dwm.aYy().getUser_level();
                if (signData.forumId != null && signData.forumId.equals(i.this.dwm.aYy().getId())) {
                    i.this.dwm.d(signData);
                    i.this.dwQ.g(i.this.dwm);
                    if (i.this.dwQ.aye()) {
                        i = i.this.dwm.aYy().getUser_level();
                        if (user_level >= i) {
                            i++;
                        }
                    } else {
                        i = user_level;
                    }
                    TbadkCoreApplication.getInst().addSignedForum(i.this.dwm.aYy().getName(), signData.sign_bonus_point, i);
                }
            }
        }
    };
    private final CustomMessageListener dxA = new CustomMessageListener(CmdConfigCustom.CMD_FRS_EXPERIENCE_TIP) { // from class: com.baidu.tieba.frs.i.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.r) && i.this.dwm != null) {
                i.this.dwm.c((com.baidu.tieba.tbadkCore.r) customResponsedMessage.getData());
                i.this.dwQ.f(i.this.dwm);
                i.this.dwR.a(i.this.dwm, i.this.dwP.axn());
            }
        }
    };
    private final AntiHelper.a dxB = new AntiHelper.a() { // from class: com.baidu.tieba.frs.i.4
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12536").s("obj_locate", ap.a.aVZ));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12535").s("obj_locate", ap.a.aVZ));
        }
    };
    private CustomMessageListener cdo = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.i.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(i.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().bgt != null) {
                        if (AntiHelper.a(i.this.getActivity(), updateAttentionMessage.getData().bgt, i.this.dxB) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12534").s("obj_locate", ap.a.aVZ));
                        }
                    } else if (updateAttentionMessage.getData().apO && updateAttentionMessage.getData().isAttention) {
                        com.baidu.adp.lib.util.l.showToast(i.this.getPageContext().getPageActivity(), d.j.attention_success);
                    }
                }
            }
        }
    };
    private CustomMessageListener dxC = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.frs.i.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                i.this.dwH.c((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.n dxD = new com.baidu.tieba.tbadkCore.n() { // from class: com.baidu.tieba.frs.i.7
        private long startTime = 0;

        @Override // com.baidu.tieba.tbadkCore.n
        public void mQ(int i) {
            this.startTime = System.nanoTime();
            if (i.this.dwH != null) {
                switch (i) {
                    case 1:
                    case 2:
                        i.this.dwH.atE();
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

        @Override // com.baidu.tieba.tbadkCore.n
        public void a(int i, boolean z, d.a aVar) {
            if (i.this.chh) {
                i.this.chh = false;
                com.baidu.tieba.frs.e.g.a(i.this.dwH, i.this.dwm, i.this.getForumId(), false, null);
            }
            i.this.asY();
            i.this.dwL = true;
            if (aVar != null && aVar.isSuccess) {
                i.this.dwH.atM().fP(com.baidu.tbadk.core.util.an.CS().CU());
                i.dwI = 0L;
                i.dwJ = 0L;
                i.dwK = 0;
            } else {
                i.dwK = 1;
            }
            if (!i.this.dwP.axr() && (i == 3 || i == 6)) {
                i.this.dxb.resetData();
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i.this.dwP.awN() != null) {
                i.this.dwm = i.this.dwP.awN();
            }
            if (i == 7) {
                i.this.mO(i.this.dwm.bAA());
                return;
            }
            if (i.this.dwm.yb() != null) {
                i.this.setHasMore(i.this.dwm.yb().xX());
            }
            i.this.asZ();
            if (i == 4) {
                if (!i.this.dwP.axr() && TbadkCoreApplication.getInst().isRecAppExist() && i.this.dwP.axh() == 1) {
                    i.this.dwm.a(i.this);
                }
                ArrayList<com.baidu.adp.widget.ListView.i> a2 = i.this.dxb.a(false, false, i.this.dwm.getThreadList(), i.this.dwD);
                if (a2 != null) {
                    i.this.dwm.az(a2);
                    i.this.dwm.bBa();
                    i.this.dwH.a(a2, i.this.dwm);
                }
                if (i.this.dwP != null) {
                    com.baidu.tieba.frs.d.b.a(i.this.dwm, i.this.dwP.axn(), 2);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    i.this.dwH.atE();
                    break;
                case 2:
                    i.this.dwH.atE();
                    break;
                case 3:
                case 6:
                    if (i.this.dwm != null) {
                        i.this.dwm.bAY();
                    }
                    if (i.this.dxg != null) {
                        i.this.dxg.refresh();
                        break;
                    }
                    break;
            }
            i.this.ata();
            if (aVar == null || aVar.errorCode == 0) {
                if (i.this.dwm != null) {
                    i.this.w(false, i == 5);
                    i.this.dwH.mT(i);
                    i.dwI = (System.nanoTime() - this.startTime) / 1000000;
                    if (aVar != null) {
                        i.dwJ = aVar.hfw;
                    }
                } else {
                    return;
                }
            } else if (i.this.dwm == null || v.G(i.this.dwm.getThreadList())) {
                i.this.a(aVar);
            } else if (aVar.hfv) {
                i.this.showToast(i.this.getPageContext().getResources().getString(d.j.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
            }
            if (i.this.dwm.bAg() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11384"));
            }
            if (i.this.dhW > -1 && !i.this.dxn) {
                com.baidu.tieba.frs.e.g.a(i.this.dwP, i.this.dhW);
                i.this.dhW = -1L;
                i.this.dxn = true;
            }
            if (i.this.dwE && i.this.dwR.nQ(49)) {
                i.this.dwE = false;
            }
            i.this.byn = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void b(com.baidu.tieba.tbadkCore.i iVar) {
            if (iVar != null) {
                if ("normal_page".equals(i.this.dwP.axd()) || "frs_page".equals(i.this.dwP.axd()) || "book_page".equals(i.this.dwP.axd())) {
                    i.this.a(iVar);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE, iVar));
                }
            }
        }
    };
    private final CustomMessageListener dxE = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.frs.i.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.h) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                i.this.dwm.a((com.baidu.tbadk.data.h) customResponsedMessage.getData());
                i.this.dwH.atM().notifyDataSetChanged();
            }
        }
    };
    private final CustomMessageListener mMemListener = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_MEM) { // from class: com.baidu.tieba.frs.i.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && i.this.dwm != null && (userData = i.this.dwm.getUserData()) != null) {
                userData.setIsMem(num.intValue());
                if (num.intValue() != 0) {
                    i.this.dwQ.f(num);
                }
            }
        }
    };
    private final com.baidu.tieba.frs.mc.i dxF = new com.baidu.tieba.frs.mc.i() { // from class: com.baidu.tieba.frs.i.13
        @Override // com.baidu.tieba.frs.mc.i
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.i> arrayList, boolean z3) {
            if (i.this.dwT != null && i.this.dwP != null && i.this.dwP.axr() && z && !z2 && !z3) {
                i.this.dwT.nG(i2);
            }
        }
    };
    public final View.OnTouchListener bBc = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.i.14
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (i.this.dxj != null) {
                i.this.dxj.onTouch(view, motionEvent);
            }
            if (i.this.dwV != null && i.this.dwV.auk() != null) {
                i.this.dwV.auk().onTouchEvent(motionEvent);
            }
            if (i.this.cfY != null) {
                i.this.cfY.f(view, motionEvent);
            }
            if (i.this.dwQ != null) {
                i.this.dwQ.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private final CustomMessageListener dxG = new CustomMessageListener(CmdConfigCustom.CMD_GOTOLIVE_HOST_UPGRADE) { // from class: com.baidu.tieba.frs.i.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "photolive_hostLevel", -1) != -1 && i.this.dwm.aYy() != null) {
                i.this.dwm.aYy().setCanAddPhotoLivePost(true);
            }
        }
    };
    private final CustomMessageListener dxH = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.frs.i.16
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.frs.i */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11455").ab("obj_locate", "frs"));
                    com.baidu.tbadk.core.util.av.Di().c(i.this.getPageContext(), new String[]{str});
                }
            }
        }
    };
    public final View.OnClickListener dxI = new View.OnClickListener() { // from class: com.baidu.tieba.frs.i.20
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (i.this.dwH == null || view != i.this.dwH.atC() || i.this.getActivity() == null) {
                if (i.this.dwm != null && i.this.dwm.aYy() != null && i.this.dwH != null && view == i.this.dwH.atI()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12402").ab(ImageViewerConfig.FORUM_ID, i.this.dwm.aYy().getId()).ab("uid", TbadkCoreApplication.getCurrentAccount()).ab(ImageViewerConfig.FORUM_NAME, i.this.dwm.aYy().getName()));
                    if (!StringUtils.isNull(i.this.dwm.aYy().getName())) {
                        i.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PostSearchActivityConfig(i.this.getPageContext().getPageActivity(), i.this.dwm.aYy().getName(), i.this.dwm.aYy().getId())));
                        return;
                    }
                    return;
                }
                if (view.getId() == d.g.game_activity_egg_layout && com.baidu.adp.lib.util.l.oZ()) {
                    TiebaStatic.log("c10853");
                    if (i.this.dwH.atJ()) {
                        i.this.dwH.atK();
                    } else {
                        String activityUrl = i.this.dwm.aYy().getYuleData().AB().getActivityUrl();
                        if (!StringUtils.isNull(activityUrl)) {
                            com.baidu.tbadk.browser.a.S(i.this.getPageContext().getPageActivity(), activityUrl);
                        }
                    }
                }
                if (view == i.this.dwH.atS() && i.this.dwP != null && i.this.dwP.hasMore()) {
                    i.this.dwH.atP();
                    i.this.Wh();
                    return;
                }
                return;
            }
            i.this.getActivity().finish();
        }
    };
    private final RecyclerView.OnScrollListener Si = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.i.21
        private int dxP = 0;
        private int bXk = 0;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (i.this.dwZ != null) {
                i.this.dwZ.axN();
            }
            this.dxP = 0;
            this.bXk = 0;
            if (recyclerView != null && (recyclerView instanceof com.baidu.adp.widget.ListView.h)) {
                this.dxP = ((com.baidu.adp.widget.ListView.h) recyclerView).getFirstVisiblePosition();
                this.bXk = ((com.baidu.adp.widget.ListView.h) recyclerView).getLastVisiblePosition();
            }
            if (i.this.dxl != null) {
                i.this.dxl.b(recyclerView, this.dxP, this.bXk);
            }
            if (i.this.dwm != null && i.this.dwH != null && i.this.dwH.atM() != null) {
                i.this.dwH.bx(this.dxP, this.bXk);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i.this.dwQ != null) {
                i.this.dwQ.setScrollState(i);
            }
            if ((i == 2 || i == 1) && !i.this.dwM) {
                i.this.dwM = true;
                i.this.dwH.atO();
            }
            if (i.this.dwN == null && !i.this.atq()) {
                i.this.dwN = new com.baidu.tbadk.k.d();
                i.this.dwN.iq(1000);
            }
            if (i == 0) {
                com.baidu.tieba.card.s.ajC().eB(true);
                i.this.dwH.bw(this.dxP, this.bXk);
            }
            if (i.this.dxl != null) {
                i.this.dxl.onScrollStateChanged(recyclerView, i);
            }
            if (i.this.dwN != null) {
                i.this.dwN.NH();
            }
            if (i == 0) {
                com.baidu.tieba.frs.e.g.a(i.this.dwH, i.this.dwm, i.this.getForumId(), false, null);
            }
        }
    };
    private final b dxJ = new b() { // from class: com.baidu.tieba.frs.i.22
        @Override // com.baidu.tieba.frs.b
        public void a(int i, int i2, View view, View view2, be beVar) {
            if (i != i.this.dwH.atM().avi()) {
                if (i != i.this.dwH.atM().avj()) {
                    if (i != i.this.dwH.atM().avl()) {
                        if (i != i.this.dwH.atM().aub()) {
                            if (i == i.this.dwH.atM().avk() && i.this.dwm != null && i.this.dwm.getUserData() != null && i.this.dwm.getUserData().isBawu()) {
                                final String bAy = i.this.dwm.bAy();
                                if (!com.baidu.tbadk.core.util.am.isEmpty(bAy) && i.this.dwm.aYy() != null) {
                                    com.baidu.tieba.c.a.a(i.this.getPageContext(), i.this.dwm.aYy().getId(), i.this.dwm.aYy().getName(), new a.InterfaceC0105a() { // from class: com.baidu.tieba.frs.i.22.1
                                        @Override // com.baidu.tieba.c.a.InterfaceC0105a
                                        public void aiW() {
                                            com.baidu.tbadk.browser.a.R(i.this.getPageContext().getPageActivity(), bAy);
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10502").ab(ImageViewerConfig.FORUM_ID, i.this.dwm.aYy().getId()).ab("uid", i.this.dwm.getUserData().getUserId()));
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        i.this.dwz = beVar;
                        com.baidu.tieba.frs.e.h.a(i.this, i.this.dwz);
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10179").ab(ImageViewerConfig.FORUM_ID, i.this.getForumId()));
                        return;
                    }
                    com.baidu.tieba.frs.e.h.z(i.this);
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak(i == i.this.dwH.atM().avl() ? "c10177" : "c10244").ab(ImageViewerConfig.FORUM_ID, i.this.getForumId()));
                } else if (com.baidu.tbadk.core.util.ax.be(i.this.getPageContext().getPageActivity())) {
                    TiebaStatic.log("my_service_ck");
                    if (i.this.dwm != null && i.this.dwm.aYy() != null) {
                        ForumData aYy = i.this.dwm.aYy();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(i.this.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(aYy.getId(), 0L), aYy.getName(), aYy.getImage_url(), 0)));
                    }
                }
            } else if (com.baidu.tbadk.core.util.ax.be(i.this.getActivity())) {
                TiebaStatic.log("forum_fortune_click");
                com.baidu.tieba.frs.e.h.a(i.this.getPageContext(), i.this.dwm);
            }
        }
    };
    private final NoNetworkView.a duP = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.i.24
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bp(boolean z) {
            if (i.this.dwP.axh() == 1 && z && !i.this.dwH.ato()) {
                if (i.this.dwm == null || v.G(i.this.dwm.getThreadList())) {
                    i.this.hideNetRefreshView(i.this.dwH.aey());
                    i.this.showLoadingView(i.this.dwH.aey(), true);
                    i.this.dwH.fB(false);
                    i.this.refresh();
                    return;
                }
                i.this.dwH.atE();
            }
        }
    };
    private final CustomMessageListener dxK = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.i.25
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                com.baidu.tieba.frs.e.c.a(customResponsedMessage, i.this.dwH, i.this.dwm);
            }
        }
    };
    private com.baidu.adp.widget.ListView.o dxL = new a();
    private an dxM = new an() { // from class: com.baidu.tieba.frs.i.26
        @Override // com.baidu.tieba.frs.an
        public void a(int i, int i2, at atVar, ArrayList<com.baidu.adp.widget.ListView.i> arrayList) {
            com.baidu.adp.lib.g.e.nr().post(new Runnable() { // from class: com.baidu.tieba.frs.i.26.1
                @Override // java.lang.Runnable
                public void run() {
                    if (i.this.dwH != null && i.this.dwH.akC()) {
                        i.this.Wh();
                    }
                }
            });
        }
    };
    private CustomMessageListener dxN = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.frs.i.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    i.this.dxm = true;
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.frs.loadmore.a
    public /* bridge */ /* synthetic */ com.baidu.adp.base.e getPageContext() {
        return super.getPageContext();
    }

    public com.baidu.tieba.frs.entelechy.b.b asM() {
        return this.dwX;
    }

    public com.baidu.adp.widget.ListView.o asN() {
        return this.dxL;
    }

    public com.baidu.tieba.frs.mc.d asO() {
        return this.dxa;
    }

    public com.baidu.tieba.frs.smartsort.b asP() {
        return this.dwT;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public FrsModelController asQ() {
        return this.dwP;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public com.baidu.tieba.frs.mc.c asR() {
        return this.dxb;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public com.baidu.tieba.frs.f.f asS() {
        return this.dwQ;
    }

    public com.baidu.tieba.frs.f.k asT() {
        return this.dwR;
    }

    public ap asU() {
        return this.dwV;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public k asV() {
        return this.dwH;
    }

    @Override // com.baidu.tieba.frs.ao
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.ao, com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.dwA;
    }

    public void setForumName(String str) {
        this.dwA = str;
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
        if (this.dxb == null) {
            return 1;
        }
        return this.dxb.getPn();
    }

    public int getPn() {
        if (this.dxb == null) {
            return 1;
        }
        return this.dxb.getPn();
    }

    public void setPn(int i) {
        if (this.dxb != null) {
            this.dxb.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.dxb != null) {
            this.dxb.setHasMore(i);
        }
    }

    public int asW() {
        if (this.dxb == null) {
            return -1;
        }
        return this.dxb.asW();
    }

    public boolean asX() {
        return this.dwF;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d.a aVar) {
        if (aVar == null) {
            String string = TbadkCoreApplication.getInst().getString(d.j.error_unkown_try_again);
            this.dwH.atz();
            showNetRefreshView(this.dwH.aey(), string, true);
        } else if (340001 == aVar.errorCode) {
            a(aVar, this.dwm.bAd());
        } else {
            if (v.G(this.dwm.getThreadList())) {
                b(aVar);
            }
            if (atq()) {
                setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.s(TbadkCoreApplication.getInst(), d.e.ds280));
            } else {
                setNetRefreshViewEmotionDefMarginTop();
            }
        }
    }

    public void a(View view, String str, boolean z, List<RecmForumInfo> list) {
        this.dwH.atz();
        this.dwH.mR(8);
        if (this.dxk == null) {
            this.dxk = new com.baidu.tieba.frs.view.b(getPageContext(), getNetRefreshListener());
        }
        this.dxk.gE(str);
        this.dxk.by(list);
        this.dxk.j(view, z);
    }

    private void a(d.a aVar, List<RecmForumInfo> list) {
        if (this.dwH != null) {
            this.dwH.atz();
            this.dwH.setTitle(this.dwA);
        }
        a(this.dwH.aey(), aVar.errorMsg, true, list);
    }

    private void b(d.a aVar) {
        this.dwH.atz();
        if (aVar.hfv) {
            showNetRefreshView(this.dwH.aey(), TbadkCoreApplication.getInst().getString(d.j.net_error_text, new Object[]{aVar.errorMsg, Integer.valueOf(aVar.errorCode)}), true);
        } else {
            showNetRefreshView(this.dwH.aey(), aVar.errorMsg, true);
        }
    }

    public void asY() {
        hideLoadingView(this.dwH.aey());
        if (!this.dwH.ato()) {
            this.dwH.fC(false);
        } else {
            this.dwH.fC(true);
        }
        if (this.dwH.atx() instanceof com.baidu.tieba.frs.tab.a) {
            ((com.baidu.tieba.frs.tab.a) this.dwH.atx()).axJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asZ() {
        if (asW() == 0 && v.G(this.dwm.bAm())) {
            if (v.G(this.dwm.getThreadList())) {
                this.dwH.akM();
            } else {
                this.dwH.atQ();
            }
        } else if (v.F(this.dwm.getThreadList()) > 3) {
            this.dwH.atP();
        } else {
            this.dwH.atR();
        }
    }

    public void a(ErrorData errorData) {
        asY();
        this.dwH.atE();
        d.a axe = this.dwP.axe();
        boolean G = v.G(this.dwm.getThreadList());
        if (axe != null && G) {
            if (G) {
                if (this.dwP.axf() != 0) {
                    this.dwP.axl();
                    this.dwH.atE();
                } else {
                    a(axe);
                }
                this.dwH.x(this.dwm.bBr(), false);
                return;
            } else if (axe.hfv) {
                this.dwH.x(true, false);
                showToast(getPageContext().getResources().getString(d.j.net_error_text, axe.errorMsg, Integer.valueOf(axe.errorCode)));
                return;
            } else {
                return;
            }
        }
        a(axe);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ata() {
        if (this.dwm == null || this.dwm.aYy() != null) {
            this.dwH.atL();
        } else if (this.dwm.aYy().getYuleData() != null && this.dwm.aYy().getYuleData().AA()) {
            TiebaStatic.log("c10852");
            this.dwH.a(this.dwm.aYy().getYuleData().AB());
        } else {
            this.dwH.atL();
        }
    }

    private void v(boolean z, boolean z2) {
        if (this.dwP != null && this.dwm != null && this.dwH != null && z) {
            if (!this.dwP.axr() && this.dwP.axh() == 1) {
                if (!this.dwP.axp()) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        this.dwm.bBj();
                        this.dwm.bBc();
                    }
                    this.dwm.bBh();
                    this.dwm.bBi();
                }
                boolean z3 = false;
                if (this.dwH.atM().k(com.baidu.tieba.card.data.p.cSQ)) {
                    z3 = this.dwm.bBm();
                }
                if (!z3) {
                    this.dwm.bBk();
                }
                if (TbadkCoreApplication.getInst().isRecAppExist()) {
                    this.dwm.a(this);
                }
                if (!this.dwH.atM().k(be.aNg)) {
                    this.dwm.bAZ();
                }
                this.dwm.bBn();
            }
            if (!this.dwH.atM().k(be.aNg)) {
                this.dwm.bBg();
                this.dwm.bBe();
            } else {
                this.dwm.bBf();
                this.dwm.bBd();
            }
            this.dwm.bBa();
            this.dwm.bAX();
            if (this.dwH.atM().k(com.baidu.tieba.g.b.dUw)) {
                this.dwm.nt(z2);
            }
            if (TbadkCoreApplication.isLogin() && (!this.dwP.axr() || this.dwP.isNetFirstLoad)) {
                this.dwm.bBo();
            }
            this.dwm.bBp();
        }
    }

    public boolean atb() {
        if (this.dwQ != null && this.dwP != null) {
            this.dwQ.a(this.dwP.axd(), this.dwm);
        }
        boolean z = false;
        if (this.dwm != null) {
            z = this.dwm.bBs();
        }
        atd();
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mO(int i) {
        aq aqVar = null;
        atb();
        atk();
        try {
            if (this.dwm != null) {
                this.dwH.a((ArrayList<com.baidu.adp.widget.ListView.i>) null, this.dwm);
                this.dwQ.nL(1);
                this.dwH.atH();
                this.dwR.a(this.dwm, this.dwP.axn());
                com.baidu.tieba.frs.tab.b nR = this.dwR.nR(this.dwm.bAA());
                if (nR != null && !TextUtils.isEmpty(nR.url)) {
                    aqVar = new aq();
                    aqVar.dzG = nR.url;
                    aqVar.stType = nR.name;
                }
                this.dwP.a(this.dwm.bAA(), 0, aqVar);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(boolean z, boolean z2) {
        try {
            if (this.dwm != null && this.dwR != null && this.dwP != null) {
                if (!this.dwH.atM().k(be.aNg)) {
                    this.dwm.bAZ();
                }
                boolean G = v.G(this.dwm.bAN());
                this.dwH.fz(G);
                if (!G) {
                    if (this.dxl == null) {
                        this.dxl = new com.baidu.tieba.frs.f.e(this, (NoPressedRelativeLayout) this.mRootView);
                    }
                    if (this.cfY == null) {
                        this.cfY = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
                    }
                } else {
                    this.dxl = null;
                    this.cfY = null;
                }
                if (this.dwm.aYy() != null) {
                    this.dwA = this.dwm.aYy().getName();
                    this.forumId = this.dwm.aYy().getId();
                }
                if (this.dwm.bBs()) {
                    this.dwR.a(this.dwm, this.dwP.axn());
                }
                if (z) {
                    v(true, z);
                } else {
                    v(this.dwO, z);
                }
                atb();
                if (this.dwX != null) {
                    this.dwX.a(this.dwQ, this.dwm);
                }
                if (this.dwm.yb() != null) {
                    setHasMore(this.dwm.yb().xX());
                }
                ArrayList<com.baidu.adp.widget.ListView.i> a2 = this.dxb.a(z2, true, this.dwm.getThreadList(), null, z);
                if (a2 != null) {
                    this.dwm.az(a2);
                }
                if (this.dwP.axh() == 1) {
                    ath();
                    if (!z && this.dwP.getPn() == 1) {
                        atc();
                    }
                }
                this.dwp = this.dwm.axj();
                if (this.dwD != null) {
                    this.dwC = true;
                    this.dwD.xf(this.dwp);
                    com.baidu.tieba.frs.e.a.a(this, this.dwm.aYy(), this.dwm.getThreadList(), this.dwC, getPn());
                }
                if (this.dwZ != null) {
                    this.dwZ.bQ(this.dwR.ayi());
                }
                asY();
                this.dwH.atA();
                this.dwH.x(true, false);
                if (this.dwm.aYy() != null) {
                    this.dwH.lk(this.dwm.aYy().getWarningMsg());
                }
                if (this.dwm != null && this.dwm.bAQ() != null && com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("frs_video_activity_guide", 0L) == 0) {
                    com.baidu.adp.lib.g.e.nr().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.i.8
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.dwH.atW();
                        }
                    }, 1000L);
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void atc() {
        if (this.dxe == null) {
            this.dxe = new com.baidu.tieba.frs.live.a(this, com.baidu.adp.lib.g.b.h(this.forumId, 0));
        }
        this.dxe.awQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.i iVar) {
        try {
            if (!this.dwL && iVar != null && this.dwm != null) {
                this.dwm.e(iVar);
                w(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void atd() {
        if (this.dwP != null) {
            lj(this.dwP.axd());
        } else {
            lj("normal_page");
        }
    }

    private void lj(String str) {
        fw("frs_page".equals(str));
        if (this.dwX != null) {
            this.dwX.a(this.dwQ, this.dwH, this.dwm);
        }
    }

    public void fw(boolean z) {
        if (this.dxc != null) {
            this.dxc.a(this.dwH, z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(d.h.frs_activity, viewGroup, false);
            this.dwv = new com.baidu.tieba.frs.entelechy.b();
            this.dwX = this.dwv.auO();
            this.dwQ = new com.baidu.tieba.frs.f.f(this, this.dwv, (FrsHeaderViewContainer) this.mRootView.findViewById(d.g.header_view_container));
            this.dwR = new com.baidu.tieba.frs.f.i(this, this.mRootView);
            this.dwR.a(this.dxv);
            Intent intent = getActivity().getIntent();
            if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                this.dwx = true;
            }
            this.dwH = new k(this, this.dxI, this.dwv, this.dwx);
            this.dwH.setHeaderViewHeight(this.dxi);
        } else {
            if (this.mRootView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            this.dwR.resetData();
            this.dwH.atV();
        }
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Intent intent = getActivity().getIntent();
        this.dhW = System.currentTimeMillis();
        if (intent != null) {
            this.dwE = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.dhW = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            L(intent);
        }
        this.beginTime = System.currentTimeMillis();
        this.byf = this.beginTime - this.dhW;
        this.dwD = new com.baidu.tieba.tbadkCore.data.e("frs", com.baidu.tieba.tbadkCore.data.e.hif);
        this.dwP = new FrsModelController(this, this.dxD);
        this.dwP.a(this.dxt);
        this.dwP.init();
        if (intent != null) {
            this.dwP.k(intent.getExtras());
        } else if (bundle != null) {
            this.dwP.k(bundle);
        } else {
            this.dwP.k(null);
        }
        if (intent != null) {
            this.dwQ.n(intent.getExtras());
        } else if (bundle != null) {
            this.dwQ.n(bundle);
        } else {
            this.dwQ.n((Bundle) null);
        }
        this.dwG = getVoiceManager();
        this.dxf = new j(getPageContext(), this);
        initUI();
        initData(bundle);
        if (this.mFrom != null && this.mFrom.equals("from_tieba_kuang")) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12264").s("obj_type", 1).ab(ImageViewerConfig.FORUM_NAME, this.dwP.getForumName()));
            KuangFloatingViewController.getInstance().setNeedShowFloatingView(true);
            if (KuangFloatingViewController.getInstance().init()) {
                ((BaseFragmentActivity) getPageContext().getOrignalPage()).grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.frs.i.11
                    @Override // com.baidu.tbadk.core.e
                    public void aO(boolean z) {
                        if (z) {
                            KuangFloatingViewController.getInstance().showFloatingView();
                        }
                    }
                });
            }
        }
        if (!atq()) {
            this.dwV = new ap(getActivity(), this.dwH, this.dwQ);
            this.dwV.fJ(true);
        }
        this.dwG = getVoiceManager();
        if (this.dwG != null) {
            this.dwG.onCreate(getPageContext());
        }
        new com.baidu.tieba.frs.mc.g();
        this.dxb = new com.baidu.tieba.frs.mc.c(this, this.dxF);
        this.dwT = new com.baidu.tieba.frs.smartsort.b(this);
        this.dxc = new com.baidu.tieba.frs.f.h(this);
        this.createTime = System.currentTimeMillis() - this.beginTime;
        this.dwZ = new com.baidu.tieba.frs.f.a(getPageContext(), this.dwP.axo());
        this.dwU = new com.baidu.tieba.frs.mc.b(this);
        this.dxa = new com.baidu.tieba.frs.mc.d(this);
        this.dwS = new com.baidu.tieba.frs.mc.f(this);
        this.dxd = new com.baidu.tieba.frs.mc.a(this);
        this.dxg = new com.baidu.tieba.frs.f.c(this);
        this.dxh = new com.baidu.tieba.frs.mc.e(this, getUniqueId());
        this.dxo = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "frs");
        this.dxp = new com.baidu.tieba.ala.a(getPageContext());
        registerListener(this.cdo);
        registerListener(this.mMemListener);
        registerListener(this.dxA);
        registerListener(this.dxG);
        registerListener(this.dxz);
        registerListener(this.dxE);
        registerListener(this.dxw);
        registerListener(this.dxx);
        registerListener(this.dxy);
        registerListener(this.dxq);
        registerListener(this.dxr);
        registerListener(this.dxN);
        registerListener(this.dxC);
        registerListener(this.dxs);
        this.dwH.fB(false);
        if (!atq()) {
            showLoadingView(this.dwH.aey(), true);
            this.dwP.B(3, true);
        }
        super.onActivityCreated(bundle);
    }

    @Override // com.baidu.tieba.frs.aj
    public void WJ() {
        if (isAdded() && this.chh && !isLoadingViewAttached()) {
            showLoadingView(this.dwH.aey(), true);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void WK() {
        if (isAdded() && this.chh && isLoadingViewAttached()) {
            hideLoadingView(this.dwH.aey());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (atq()) {
            showLoadingView(this.dwH.aey(), true);
            this.dwH.mS(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.dwP.B(3, true);
            El().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void setHeaderViewHeight(int i) {
        this.dxi = i;
        if (this.dwH != null) {
            this.dwH.setHeaderViewHeight(this.dxi);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.s sVar) {
        if (sVar != null) {
            this.bBb = sVar.OQ();
            this.dxj = sVar.OR();
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void showFloatingView() {
        if (this.bBb != null) {
            this.bBb.cD(true);
        }
    }

    private void L(Intent intent) {
        if (intent != null) {
            if (!com.baidu.tieba.frs.e.e.a(this, getForumName(), "from", intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false)) && getActivity() != null) {
                getActivity().finish();
                return;
            }
        }
        if (intent != null && intent.getData() != null) {
            Uri data = intent.getData();
            this.dwA = data.getQueryParameter("name");
            this.mFrom = data.getQueryParameter("from");
            if (!StringUtils.isNull(this.dwA)) {
                intent.putExtra("name", this.dwA);
            }
            if (!StringUtils.isNull(this.mFrom)) {
                intent.putExtra("from", this.mFrom);
            }
            TiebaStatic.log("c10105");
        }
        if (StringUtils.isNull(this.dwA)) {
            this.dwA = com.baidu.tieba.frs.e.h.N(intent);
            if (!StringUtils.isNull(this.dwA)) {
                intent.putExtra("name", this.dwA);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.dwG = getVoiceManager();
        if (this.dwG != null) {
            this.dwG.onStart(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        Intent intent;
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.dxK);
        if (bundle != null) {
            this.dwA = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
            this.dwA = intent.getStringExtra("name");
            this.mFrom = intent.getStringExtra("from");
            this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
        }
        if (TextUtils.isEmpty(this.mFrom) || FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
        }
        if (this.mIsLogin) {
            registerListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL, this.dxK);
        }
        this.dwQ.n(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dxN);
        if (this.dwG != null) {
            this.dwG.onDestory(getPageContext());
        }
        this.dwG = null;
        com.baidu.tieba.card.s.ajC().eB(false);
        if (this.dwm != null && this.dwm.aYy() != null) {
            ae.auh().bx(com.baidu.adp.lib.g.b.c(this.dwm.aYy().getId(), 0L));
        }
        if (this.dxe != null) {
            this.dxe.onDestory();
        }
        if (this.dwH != null) {
            com.baidu.tieba.frs.e.g.a(this.dwH, this.dwm, getForumId(), false, null);
            this.dwH.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.dwN != null) {
                this.dwN.onDestroy();
            }
            this.dwH.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.dwP.onActivityDestroy();
        this.dwQ.onActivityDestroy();
        if (this.dwP != null) {
            this.dwP.Yi();
        }
        if (this.dwV != null) {
            this.dwV.OP();
        }
        if (this.dwY != null) {
            this.dwY.destory();
        }
        if (this.dwZ != null) {
            this.dwZ.destory();
        }
        if (this.dwT != null) {
            this.dwT.onDestroy();
        }
        if (this.dxl != null) {
            this.dxl.onDestory();
        }
        if (this.dxd != null) {
            this.dxd.onDestroy();
        }
        if (this.dxo != null) {
            this.dxo.onDestroy();
        }
        if (this.dxp != null) {
            this.dxp.onDestroy();
        }
        com.baidu.tieba.recapp.e.a.bud().buf();
        com.baidu.tieba.frs.e.i.axK();
        if (this.dwR != null) {
            this.dwR.a((i.b) null);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.dwA);
        bundle.putString("from", this.mFrom);
        this.dwP.onSaveInstanceState(bundle);
        if (this.dwG != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            this.dwG.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.dxd != null) {
            this.dxd.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dwH != null) {
            this.dwH.atE();
            this.dwH.onResume();
        }
        this.dwS.fZ(true);
        this.dwO = true;
        if (dwy) {
            dwy = false;
            this.dwH.startPullRefresh();
            return;
        }
        if (this.dwG != null) {
            this.dwG.onResume(getPageContext());
        }
        this.dwH.fD(false);
        registerListener(this.dxH);
        if (this.dxm) {
            refresh(6);
            this.dxm = false;
        }
        if (KuangFloatingViewController.getInstance().init()) {
            ((BaseFragmentActivity) getPageContext().getOrignalPage()).grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.frs.i.17
                @Override // com.baidu.tbadk.core.e
                public void aO(boolean z) {
                    if (z) {
                        KuangFloatingViewController.getInstance().showFloatingView();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        refresh();
    }

    public boolean ate() {
        Intent intent;
        if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
            return false;
        }
        return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
    }

    public void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.dwA = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.dwB = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.dwB) {
                atf();
            }
            if (this.mFrom != null && this.mFrom.equals("from_tieba_kuang")) {
                KuangFloatingViewController.getInstance().setNeedShowFloatingView(true);
                if (KuangFloatingViewController.getInstance().init()) {
                    ((BaseFragmentActivity) getPageContext().getOrignalPage()).grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.frs.i.18
                        @Override // com.baidu.tbadk.core.e
                        public void aO(boolean z) {
                            if (z) {
                                KuangFloatingViewController.getInstance().showFloatingView();
                            }
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atf() {
        this.dwH.startPullRefresh();
    }

    public void closeActivity() {
        com.baidu.tieba.frs.e.h.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.mFrom);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.dwH.setTitle(this.dwA);
        } else {
            this.dwH.setTitle("");
            this.mFlag = 1;
        }
        this.dwH.setOnAdapterItemClickListener(this.dxL);
        this.dwH.addOnScrollListener(this.Si);
        this.dwH.h(this.duP);
        this.dwH.atM().a(this.dxJ);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dwH.onChangeSkinType(i);
        this.dwQ.nK(i);
        this.dwR.onChangeSkinType(i);
        if (this.dxk != null) {
            this.dxk.onChangeSkinType();
        }
    }

    public void mP(int i) {
        if (!this.mIsLogin) {
            if (this.dwm != null && this.dwm.xJ() != null) {
                this.dwm.xJ().setIfpost(1);
            }
            if (i == 0) {
                com.baidu.tbadk.core.util.ax.bd(getActivity());
            }
        } else if (this.dwm != null) {
            if (i == 0) {
                com.baidu.tieba.frs.e.i.b(this, 0);
            } else {
                this.dwH.atG();
            }
        }
    }

    public void refresh() {
        refresh(3);
    }

    public void refresh(int i) {
        this.dwL = false;
        atk();
        if (this.dwH.atw() != null) {
            this.dwH.atw().aCw();
        }
        this.dwP.B(i, true);
    }

    private void atg() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.g.h.ns().e(new Runnable() { // from class: com.baidu.tieba.frs.i.19
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.th(i.this.dwA);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ath() {
        atk();
        try {
            if (this.dwm != null) {
                this.dwH.WZ();
                this.dwH.fy(this.dwP.axi());
                if (com.baidu.tieba.frs.f.f.i(this.dwm) && !com.baidu.tieba.frs.f.f.h(this.dwm)) {
                    this.dwH.atT();
                }
                if (this.dwm.aYy() != null) {
                    this.dwA = this.dwm.aYy().getName();
                    this.forumId = this.dwm.aYy().getId();
                }
                if (this.dwm.yb() != null) {
                    setHasMore(this.dwm.yb().xX());
                }
                this.dwH.setTitle(this.dwA);
                this.dwH.setForumName(this.dwA);
                TbadkCoreApplication.getInst().setDefaultBubble(this.dwm.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.dwm.getUserData().getBimg_end_time());
                atg();
                ati();
                ArrayList<com.baidu.adp.widget.ListView.i> threadList = this.dwm.getThreadList();
                if (threadList != null) {
                    this.dwH.a(threadList, this.dwm);
                    com.baidu.tieba.frs.e.c.l(this.dwH);
                    this.dwQ.nL(getPageNum());
                    this.dwQ.f(this.dwm);
                    this.dwR.a(this.dwm, this.dwP.axn());
                    this.dwH.atH();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void ati() {
        if (this.dwm != null) {
            if (this.dwm.aYO() == 1) {
                this.dwH.atM().setFromCDN(true);
            } else {
                this.dwH.atM().setFromCDN(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.dwS.fZ(false);
        this.dwO = false;
        this.dwH.onPause();
        if (this.dwG != null) {
            this.dwG.onPause(getPageContext());
        }
        this.dwH.fD(true);
        if (this.dwZ != null) {
            this.dwZ.axN();
        }
        MessageManager.getInstance().unRegisterListener(this.dxH);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.s.ajC().eB(false);
        if (this.dwm != null && this.dwm.aYy() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            com.baidu.tbadk.distribute.a.Kp().a(getPageContext().getPageActivity(), "frs", this.dwm.aYy().getId(), 0L);
        }
        if (this.dwG != null) {
            this.dwG.onStop(getPageContext());
        }
        if (El() != null) {
            El().getRecycledViewPool().clear();
        }
        this.dwQ.onActivityStop();
        t.OT();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && this.dwQ != null) {
            this.dwQ.gb(isPrimary());
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || this.dwH == null) {
            return false;
        }
        return this.dwH.atD();
    }

    @Override // com.baidu.tieba.recapp.o
    public TbPageContext<?> aiX() {
        return getPageContext();
    }

    @Override // com.baidu.tieba.recapp.o
    public void a(AdvertAppInfo advertAppInfo, String str) {
        com.baidu.tbadk.distribute.a.Kp().a(advertAppInfo, this.forumId, 0L, "FRS", str, getPn());
    }

    @Override // com.baidu.tieba.recapp.o
    public void atj() {
        asQ().atj();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dwG == null) {
            this.dwG = VoiceManager.instance();
        }
        return this.dwG;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public com.baidu.adp.widget.ListView.h El() {
        if (this.dwH == null) {
            return null;
        }
        return this.dwH.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void atk() {
        if (this.dwG != null) {
            this.dwG.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> Em() {
        if (this.bcT == null) {
            this.bcT = UserIconBox.v(getPageContext().getPageActivity(), 8);
        }
        return this.bcT;
    }

    public void atl() {
        if (getFragmentActivity() != null && getFragmentActivity().getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.a(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.l onGetPreLoadListView() {
        return El().getPreLoadHandle();
    }

    @Override // com.baidu.tieba.frs.am
    public NavigationBar atm() {
        if (this.dwH == null) {
            return null;
        }
        return this.dwH.atm();
    }

    /* loaded from: classes2.dex */
    private final class a implements com.baidu.adp.widget.ListView.o {
        private a() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v8, resolved type: com.baidu.tieba.frs.i */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.o
        public void a(View view, com.baidu.adp.widget.ListView.i iVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            boolean z;
            if (bdUniqueId != null) {
                if (bdUniqueId == r.dyU) {
                    if (i.this.dwH != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11752").ab(ImageViewerConfig.FORUM_ID, i.this.forumId).ab("obj_locate", "1"));
                        i.this.dwH.startPullRefresh();
                    }
                } else if (iVar != null && (iVar instanceof be)) {
                    be beVar = (be) iVar;
                    if (beVar.zI() == null || beVar.zI().getGroup_id() == 0 || com.baidu.tbadk.core.util.ax.be(i.this.getActivity())) {
                        if ((beVar.zB() != 1 && beVar.zB() != 2) || com.baidu.tbadk.core.util.ax.be(i.this.getActivity())) {
                            if (beVar.zl() != null) {
                                if (com.baidu.tbadk.core.util.ax.be(i.this.getActivity())) {
                                    String postUrl = beVar.zl().getPostUrl();
                                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.oZ()) {
                                        com.baidu.tbadk.browser.a.S(i.this.getActivity(), postUrl);
                                    }
                                }
                            } else if (beVar.zU() != null) {
                                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                    com.baidu.tbadk.core.util.ax.bd(i.this.getPageContext().getPageActivity());
                                    return;
                                }
                                com.baidu.tbadk.core.data.m zU = beVar.zU();
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(i.this.getPageContext().getPageActivity(), zU.getCartoonId(), zU.getChapterId(), 2)));
                            } else if (beVar.getThreadType() == 47 && beVar.yS() == 1 && !com.baidu.tbadk.core.util.am.isEmpty(beVar.zf())) {
                                com.baidu.tbadk.browser.a.R(i.this.getPageContext().getPageActivity(), beVar.zf());
                            } else {
                                com.baidu.tieba.tbadkCore.util.e readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                                if (readThreadHistory != null && !readThreadHistory.tn(beVar.getId())) {
                                    readThreadHistory.tm(beVar.getId());
                                }
                                final String zf = beVar.zf();
                                if (zf == null || zf.equals("")) {
                                    z = false;
                                } else {
                                    new Thread(new Runnable() { // from class: com.baidu.tieba.frs.i.a.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(zf);
                                            xVar.Cn().Dk().mIsNeedAddCommenParam = false;
                                            xVar.Cn().Dk().mIsUseCurrentBDUSS = false;
                                            xVar.BQ();
                                        }
                                    }).start();
                                    z = true;
                                }
                                String tid = beVar.getTid();
                                if (tid == null) {
                                    tid = "";
                                }
                                if (beVar.yS() == 2 && !tid.startsWith("pb:")) {
                                    com.baidu.tbadk.core.util.av.Di().c(i.this.getPageContext(), new String[]{tid, "", null});
                                } else if (beVar.getThreadType() == 33 || (beVar instanceof com.baidu.tbadk.core.data.at)) {
                                    String str = beVar.getThreadType() == 33 ? "c10245" : "c10180";
                                    if (i.this.dwP.axh() == 5) {
                                        str = "c10387";
                                    }
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak(str).ab(ImageViewerConfig.FORUM_ID, i.this.forumId));
                                    com.baidu.tieba.frs.e.h.b(i.this, beVar);
                                    if (i.this.dwm != null && i.this.dwm.aYy() != null) {
                                        com.baidu.tieba.frs.d.a aVar = new com.baidu.tieba.frs.d.a();
                                        aVar.dLV = i.this.dwm.hgc == 1;
                                        aVar.dLX = i.this.dwm.aYy().getId();
                                        aVar.dLW = i.this.asQ().axn();
                                        com.baidu.tieba.frs.d.b.axH().a(aVar, beVar, 1);
                                    }
                                } else {
                                    if (tid.startsWith("pb:")) {
                                        beVar.setId(tid.substring(3));
                                    }
                                    if (bdUniqueId.getId() == be.aOq.getId()) {
                                        com.baidu.tieba.frs.e.g.a(beVar.yD());
                                    }
                                    com.baidu.tieba.frs.e.h.a(i.this, beVar, i, z);
                                    com.baidu.tieba.frs.e.g.a(i.this, i.this.dwm, beVar);
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
        if (com.baidu.adp.lib.util.l.oZ()) {
            hideNetRefreshView(this.dwH.aey());
            showLoadingView(this.dwH.aey(), true);
            this.dwH.fB(false);
            this.dwP.B(3, true);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public com.baidu.tieba.tbadkCore.l atn() {
        return this.dwm;
    }

    public boolean ato() {
        return this.dwH.ato();
    }

    public void aU(Object obj) {
        if (this.dwU != null && this.dwU.dKK != null) {
            this.dwU.dKK.ak(obj);
        }
    }

    public void aV(Object obj) {
        if (this.dwU != null && this.dwU.dKL != null) {
            this.dwU.dKL.ak(obj);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.l.oZ()) {
            this.dwH.akM();
        } else if (this.dwP.axh() == 1) {
            Wv();
            Wh();
        } else if (this.dwP.hasMore()) {
            Wh();
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void kX(String str) {
        Wv();
        showToast(str);
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void J(ArrayList<com.baidu.adp.widget.ListView.i> arrayList) {
        Wv();
        if (!v.G(arrayList)) {
            if (!this.dwP.axr() && TbadkCoreApplication.getInst().isRecAppExist() && this.dwP.axh() == 1) {
                this.dwm.a(this, arrayList);
            }
            ArrayList<com.baidu.adp.widget.ListView.i> a2 = this.dxb.a(false, false, arrayList, this.dwD);
            if (a2 != null) {
                this.dwm.az(a2);
                this.dwH.a(a2, this.dwm);
            }
            if (this.dwP != null) {
                com.baidu.tieba.frs.d.b.a(this.dwm, this.dwP.axn(), 2);
            }
        }
    }

    private void Wv() {
        if (asW() == 1 || this.dxb.bv(this.dwm.bAm())) {
            if (v.F(this.dwm.getThreadList()) > 3) {
                this.dwH.atP();
            } else {
                this.dwH.atR();
            }
        } else if (v.G(this.dwm.getThreadList())) {
            this.dwH.akM();
        } else {
            this.dwH.atQ();
        }
    }

    @Override // com.baidu.tieba.frs.mc.j
    public void Wh() {
        if (this.dxb != null) {
            this.dxb.a(this.dwA, this.forumId, this.dwm);
        }
    }

    public void atp() {
        if (!com.baidu.tbadk.core.util.ab.f(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.ai.c(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return atq() ? "a034" : "a006";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (!atq()) {
            return super.getCurrentPageSourceKeyList();
        }
        if (super.getCurrentPageSourceKeyList() != null) {
            arrayList = new ArrayList(super.getCurrentPageSourceKeyList());
        } else {
            arrayList = new ArrayList();
        }
        if (!"a001".equals(v.f(arrayList, arrayList.size() - 1))) {
            arrayList.add("a001");
            return arrayList;
        }
        return arrayList;
    }

    @Override // android.support.v4.app.Fragment, com.baidu.b.a.a.InterfaceC0036a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        com.baidu.tieba.frs.e.h.a(this, i, strArr, iArr);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(getForumId(), 0L));
        }
        return pageStayDurationItem;
    }

    public void fx(boolean z) {
        if (this.dwV != null) {
            this.dwV.fJ(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.dwW.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a jk(int i) {
        return this.dwW.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        this.dxf.b(bVar);
    }

    public boolean atq() {
        return this.dwx;
    }

    @Override // com.baidu.tieba.frs.aj
    public void WI() {
        if (this.dwH != null) {
            showFloatingView();
            this.dwH.getListView().scrollToPosition(0);
            this.dwH.startPullRefresh();
        }
    }

    public ForumWriteData atr() {
        if (this.dwm == null || this.dwm.aYy() == null) {
            return null;
        }
        ForumData aYy = this.dwm.aYy();
        ForumWriteData forumWriteData = new ForumWriteData(aYy.getId(), aYy.getName(), aYy.getPrefixData(), this.dwm.xJ());
        forumWriteData.setForumLevel(aYy.getUser_level());
        forumWriteData.setAvatar(this.dwm.aYy().getImage_url());
        UserData userData = this.dwm.getUserData();
        if (userData != null) {
            forumWriteData.setPrivateThread(userData.getPrivateThread());
            return forumWriteData;
        }
        return forumWriteData;
    }

    @Override // com.baidu.tieba.frs.aj
    public void Ea() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.frs.aj
    public void setVideoThreadId(String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z) {
        super.showLoadingView(view, z);
        this.dwH.mR(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        super.hideLoadingView(view);
        this.dwH.mR(0);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        super.showNetRefreshView(view, str, z);
        this.dwH.mR(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshViewNoClick(View view, String str, boolean z) {
        super.showNetRefreshViewNoClick(view, str, z);
        this.dwH.mR(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        super.hideNetRefreshView(view);
        this.dwH.mR(0);
    }

    public void ats() {
        i.c ayj;
        if (this.dwR != null && (ayj = this.dwR.ayj()) != null && ayj.fragment != null && (ayj.fragment instanceof al)) {
            ((al) ayj.fragment).asH();
        }
    }
}
