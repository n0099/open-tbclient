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
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.data.bd;
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
    private com.baidu.tbadk.util.r bBs;
    private com.baidu.adp.lib.e.b<TbImageView> bdh;
    private com.baidu.tieba.frs.gametab.b cgn;
    private VoiceManager dBC;
    private FrsModelController dBL;
    private com.baidu.tieba.frs.f.f dBM;
    private com.baidu.tieba.frs.f.i dBN;
    private com.baidu.tieba.frs.mc.f dBO;
    private com.baidu.tieba.frs.smartsort.b dBP;
    private com.baidu.tieba.frs.mc.b dBQ;
    private ap dBR;
    private com.baidu.tieba.frs.entelechy.b.b dBT;
    private com.baidu.tbadk.h.a dBU;
    private com.baidu.tieba.frs.f.a dBV;
    private com.baidu.tieba.frs.mc.d dBW;
    private com.baidu.tieba.frs.mc.c dBX;
    private com.baidu.tieba.frs.f.h dBY;
    private com.baidu.tieba.frs.mc.a dBZ;
    private com.baidu.tieba.frs.entelechy.b dBr;
    public bd dBv;
    private com.baidu.tieba.tbadkCore.data.e dBz;
    private com.baidu.tieba.frs.live.a dCa;
    private j dCb;
    public com.baidu.tieba.frs.f.c dCc;
    private com.baidu.tieba.frs.mc.e dCd;
    private int dCe;
    private View.OnTouchListener dCf;
    private com.baidu.tieba.frs.view.b dCg;
    private com.baidu.tieba.frs.f.e dCh;
    private boolean dCi;
    private com.baidu.tieba.NEGFeedBack.a dCk;
    private com.baidu.tieba.ala.a dCl;
    public View mRootView;
    public static boolean dBu = false;
    public static volatile long dBE = 0;
    public static volatile long dBF = 0;
    public static volatile int dBG = 0;
    public boolean dBs = false;
    private boolean dBt = false;
    public String dBw = null;
    public String mFrom = null;
    public int mFlag = 0;
    private boolean dBx = false;
    private String mThreadId = null;
    public String forumId = null;
    private int dBl = 0;
    private boolean dBy = false;
    private boolean dBA = false;
    private boolean dBB = false;
    private k dBD = null;
    public final bd bXU = null;
    private com.baidu.tieba.tbadkCore.l dBi = new com.baidu.tieba.tbadkCore.l();
    public long dmS = -1;
    public long byF = 0;
    public long byx = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean dBH = false;
    private boolean dBI = false;
    public com.baidu.tbadk.k.d dBJ = null;
    private boolean dBK = true;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> dBS = new SparseArray<>();
    private boolean chw = true;
    private boolean dCj = false;
    private final CustomMessageListener dCm = new CustomMessageListener(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED) { // from class: com.baidu.tieba.frs.i.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof bd) {
                    com.baidu.tieba.frs.e.g.a(i.this.dBD, i.this.dBi, i.this.getForumId(), true, (bd) data);
                }
            }
        }
    };
    private CustomMessageListener dCn = new CustomMessageListener(CmdConfigCustom.CMD_CLOSE_GAME_RANK_CARD) { // from class: com.baidu.tieba.frs.i.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (i.this.dBi != null) {
                i.this.dBi.buJ();
                if (i.this.dBD != null) {
                    i.this.dBD.alT();
                }
            }
        }
    };
    private CustomMessageListener dCo = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.i.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 1) {
                    i.this.aun();
                }
            }
        }
    };
    private final an dCp = new an() { // from class: com.baidu.tieba.frs.i.28
        @Override // com.baidu.tieba.frs.an
        public void a(int i, int i2, at atVar, ArrayList<com.baidu.adp.widget.ListView.i> arrayList) {
            i.this.aug();
            if (i.this.dBT != null) {
                i.this.dBM.gi(i.this.dBT.nj(i));
            }
            d.a aVar = new d.a();
            if (atVar != null) {
                aVar.isSuccess = atVar.errCode == 0;
                aVar.errorCode = atVar.errCode;
                aVar.errorMsg = atVar.errMsg;
                if (aVar.isSuccess) {
                    if (v.E(arrayList)) {
                        i.this.dBD.alU();
                    } else if (atVar.hasMore) {
                        if (v.D(i.this.dBi.getThreadList()) > 3) {
                            i.this.dBD.auX();
                        } else {
                            i.this.dBD.auZ();
                        }
                    } else if (atVar.dEF) {
                        i.this.dBD.auY();
                    } else {
                        i.this.dBD.alU();
                    }
                }
            } else {
                atVar = new at();
                atVar.pn = 1;
                atVar.hasMore = false;
                atVar.dEF = false;
            }
            if (i == 1) {
                i.this.dBK = true;
                i.this.dCz.a(i.this.dBL.getType(), false, aVar);
            } else {
                i.this.a(aVar);
                if (i.this.dBL.axV() != null) {
                    i.this.dBi = i.this.dBL.axV();
                }
                i.this.aup();
            }
            if (i.this.dCI != null) {
                i.this.dCI.a(i, i2, atVar, arrayList);
            }
        }
    };
    private ak dCq = new ak() { // from class: com.baidu.tieba.frs.i.29
        @Override // com.baidu.tieba.frs.ak
        public void a(an anVar) {
        }

        @Override // com.baidu.tieba.frs.ak
        public void a(int i, int i2, aq aqVar) {
            if (i != 1) {
                com.baidu.tieba.card.s.akK().eH(false);
            }
            i.this.aus();
            i.this.dBL.a(i, i2, aqVar);
        }

        @Override // com.baidu.tieba.frs.ak
        public void init() {
        }

        @Override // com.baidu.tieba.frs.ak
        public void XY() {
        }
    };
    private i.b dCr = new i.b() { // from class: com.baidu.tieba.frs.i.30
        @Override // com.baidu.tieba.frs.f.i.b
        public void hV(int i) {
            if (i != 1) {
                com.baidu.tieba.card.s.akK().eH(false);
            }
            i.this.aus();
            com.baidu.tieba.frs.d.c.dRe.dQV = i;
            com.baidu.tieba.frs.d.c.dRe.dQW = -1;
        }
    };
    private CustomMessageListener dCs = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIVE_COUNT) { // from class: com.baidu.tieba.frs.i.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                i.this.dBN.nV(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    };
    private CustomMessageListener dCt = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_LIVE_START) { // from class: com.baidu.tieba.frs.i.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && ((Integer) customResponsedMessage.getData()).intValue() == 51 && i.this.dBi != null) {
                com.baidu.tieba.frs.e.i.a(i.this.dBi, i.this.getPageContext());
            }
        }
    };
    private final CustomMessageListener dCu = new CustomMessageListener(CmdConfigCustom.CMD_FRS_SELECT_ALA_LIVE_TAB) { // from class: com.baidu.tieba.frs.i.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                i.this.dBN.nT(49);
            }
        }
    };
    private final CustomMessageListener dCv = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.frs.i.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && i.this.dBi != null && i.this.dBi.aYJ() != null) {
                SignData signData = (SignData) customResponsedMessage.getData();
                int user_level = i.this.dBi.aYJ().getUser_level();
                if (signData.forumId != null && signData.forumId.equals(i.this.dBi.aYJ().getId())) {
                    i.this.dBi.d(signData);
                    i.this.dBM.g(i.this.dBi);
                    if (i.this.dBM.azm()) {
                        i = i.this.dBi.aYJ().getUser_level();
                        if (user_level >= i) {
                            i++;
                        }
                    } else {
                        i = user_level;
                    }
                    TbadkCoreApplication.getInst().addSignedForum(i.this.dBi.aYJ().getName(), signData.sign_bonus_point, i);
                }
            }
        }
    };
    private final CustomMessageListener dCw = new CustomMessageListener(CmdConfigCustom.CMD_FRS_EXPERIENCE_TIP) { // from class: com.baidu.tieba.frs.i.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.r) && i.this.dBi != null) {
                i.this.dBi.c((com.baidu.tieba.tbadkCore.r) customResponsedMessage.getData());
                i.this.dBM.f(i.this.dBi);
                i.this.dBN.a(i.this.dBi, i.this.dBL.ayv());
            }
        }
    };
    private final AntiHelper.a dCx = new AntiHelper.a() { // from class: com.baidu.tieba.frs.i.4
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12536").s("obj_locate", ap.a.aWb));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12535").s("obj_locate", ap.a.aWb));
        }
    };
    private CustomMessageListener cdD = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.i.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(i.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().bgS != null) {
                        if (AntiHelper.a(i.this.getActivity(), updateAttentionMessage.getData().bgS, i.this.dCx) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12534").s("obj_locate", ap.a.aWb));
                        }
                    } else if (updateAttentionMessage.getData().apQ && updateAttentionMessage.getData().isAttention) {
                        com.baidu.adp.lib.util.l.showToast(i.this.getPageContext().getPageActivity(), d.j.attention_success);
                    }
                }
            }
        }
    };
    private CustomMessageListener dCy = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.frs.i.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                i.this.dBD.c((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.n dCz = new com.baidu.tieba.tbadkCore.n() { // from class: com.baidu.tieba.frs.i.7
        private long startTime = 0;

        @Override // com.baidu.tieba.tbadkCore.n
        public void mT(int i) {
            this.startTime = System.nanoTime();
            if (i.this.dBD != null) {
                switch (i) {
                    case 1:
                    case 2:
                        i.this.dBD.auM();
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
            if (i.this.chw) {
                i.this.chw = false;
                com.baidu.tieba.frs.e.g.a(i.this.dBD, i.this.dBi, i.this.getForumId(), false, null);
            }
            i.this.aug();
            i.this.dBH = true;
            if (aVar != null && aVar.isSuccess) {
                i.this.dBD.auU().fV(com.baidu.tbadk.core.util.an.CK().CM());
                i.dBE = 0L;
                i.dBF = 0L;
                i.dBG = 0;
            } else {
                i.dBG = 1;
            }
            if (!i.this.dBL.ayz() && (i == 3 || i == 6)) {
                i.this.dBX.resetData();
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i.this.dBL.axV() != null) {
                i.this.dBi = i.this.dBL.axV();
            }
            if (i == 7) {
                i.this.mR(i.this.dBi.btY());
                return;
            }
            if (i.this.dBi.xZ() != null) {
                i.this.setHasMore(i.this.dBi.xZ().xV());
            }
            i.this.auh();
            if (i == 4) {
                if (!i.this.dBL.ayz() && TbadkCoreApplication.getInst().isRecAppExist() && i.this.dBL.ayp() == 1) {
                    i.this.dBi.a(i.this);
                }
                ArrayList<com.baidu.adp.widget.ListView.i> a2 = i.this.dBX.a(false, false, i.this.dBi.getThreadList(), i.this.dBz);
                if (a2 != null) {
                    i.this.dBi.at(a2);
                    i.this.dBi.buy();
                    i.this.dBD.a(a2, i.this.dBi);
                }
                if (i.this.dBL != null) {
                    com.baidu.tieba.frs.d.b.a(i.this.dBi, i.this.dBL.ayv(), 2);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    i.this.dBD.auM();
                    break;
                case 2:
                    i.this.dBD.auM();
                    break;
                case 3:
                case 6:
                    if (i.this.dBi != null) {
                        i.this.dBi.buw();
                    }
                    if (i.this.dCc != null) {
                        i.this.dCc.refresh();
                        break;
                    }
                    break;
            }
            i.this.aui();
            if (aVar == null || aVar.errorCode == 0) {
                if (i.this.dBi != null) {
                    i.this.w(false, i == 5);
                    i.this.dBD.mW(i);
                    i.dBE = (System.nanoTime() - this.startTime) / 1000000;
                    if (aVar != null) {
                        i.dBF = aVar.gVq;
                    }
                } else {
                    return;
                }
            } else if (i.this.dBi == null || v.E(i.this.dBi.getThreadList())) {
                i.this.a(aVar);
            } else if (aVar.gVp) {
                i.this.showToast(i.this.getPageContext().getResources().getString(d.j.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
            }
            if (i.this.dBi.btE() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11384"));
            }
            if (i.this.dmS > -1 && !i.this.dCj) {
                com.baidu.tieba.frs.e.g.a(i.this.dBL, i.this.dmS);
                i.this.dmS = -1L;
                i.this.dCj = true;
            }
            if (i.this.dBA && i.this.dBN.nT(49)) {
                i.this.dBA = false;
            }
            i.this.byF = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void b(com.baidu.tieba.tbadkCore.i iVar) {
            if (iVar != null) {
                if ("normal_page".equals(i.this.dBL.ayl()) || "frs_page".equals(i.this.dBL.ayl()) || "book_page".equals(i.this.dBL.ayl())) {
                    i.this.a(iVar);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE, iVar));
                }
            }
        }
    };
    private final CustomMessageListener dCA = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.frs.i.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.h) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                i.this.dBi.a((com.baidu.tbadk.data.h) customResponsedMessage.getData());
                i.this.dBD.auU().notifyDataSetChanged();
            }
        }
    };
    private final CustomMessageListener mMemListener = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_MEM) { // from class: com.baidu.tieba.frs.i.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && i.this.dBi != null && (userData = i.this.dBi.getUserData()) != null) {
                userData.setIsMem(num.intValue());
                if (num.intValue() != 0) {
                    i.this.dBM.f(num);
                }
            }
        }
    };
    private final com.baidu.tieba.frs.mc.i dCB = new com.baidu.tieba.frs.mc.i() { // from class: com.baidu.tieba.frs.i.13
        @Override // com.baidu.tieba.frs.mc.i
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.i> arrayList, boolean z3) {
            if (i.this.dBP != null && i.this.dBL != null && i.this.dBL.ayz() && z && !z2 && !z3) {
                i.this.dBP.nJ(i2);
            }
        }
    };
    public final View.OnTouchListener bBt = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.i.14
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (i.this.dCf != null) {
                i.this.dCf.onTouch(view, motionEvent);
            }
            if (i.this.dBR != null && i.this.dBR.avs() != null) {
                i.this.dBR.avs().onTouchEvent(motionEvent);
            }
            if (i.this.cgn != null) {
                i.this.cgn.f(view, motionEvent);
            }
            if (i.this.dBM != null) {
                i.this.dBM.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private final CustomMessageListener dCC = new CustomMessageListener(CmdConfigCustom.CMD_GOTOLIVE_HOST_UPGRADE) { // from class: com.baidu.tieba.frs.i.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "photolive_hostLevel", -1) != -1 && i.this.dBi.aYJ() != null) {
                i.this.dBi.aYJ().setCanAddPhotoLivePost(true);
            }
        }
    };
    private final CustomMessageListener dCD = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.frs.i.16
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.frs.i */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11455").aa("obj_locate", "frs"));
                    com.baidu.tbadk.core.util.av.Da().c(i.this.getPageContext(), new String[]{str});
                }
            }
        }
    };
    public final View.OnClickListener dCE = new View.OnClickListener() { // from class: com.baidu.tieba.frs.i.20
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (i.this.dBD == null || view != i.this.dBD.auK() || i.this.getActivity() == null) {
                if (i.this.dBi != null && i.this.dBi.aYJ() != null && i.this.dBD != null && view == i.this.dBD.auQ()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12402").aa(ImageViewerConfig.FORUM_ID, i.this.dBi.aYJ().getId()).aa("uid", TbadkCoreApplication.getCurrentAccount()).aa(ImageViewerConfig.FORUM_NAME, i.this.dBi.aYJ().getName()));
                    if (!StringUtils.isNull(i.this.dBi.aYJ().getName())) {
                        i.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PostSearchActivityConfig(i.this.getPageContext().getPageActivity(), i.this.dBi.aYJ().getName(), i.this.dBi.aYJ().getId())));
                        return;
                    }
                    return;
                }
                if (view.getId() == d.g.game_activity_egg_layout && com.baidu.adp.lib.util.l.pa()) {
                    TiebaStatic.log("c10853");
                    if (i.this.dBD.auR()) {
                        i.this.dBD.auS();
                    } else {
                        String activityUrl = i.this.dBi.aYJ().getYuleData().Au().getActivityUrl();
                        if (!StringUtils.isNull(activityUrl)) {
                            com.baidu.tbadk.browser.a.Q(i.this.getPageContext().getPageActivity(), activityUrl);
                        }
                    }
                }
                if (view == i.this.dBD.ava() && i.this.dBL != null && i.this.dBL.hasMore()) {
                    i.this.dBD.auX();
                    i.this.VX();
                    return;
                }
                return;
            }
            i.this.getActivity().finish();
        }
    };
    private final RecyclerView.OnScrollListener Si = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.i.21
        private int dCL = 0;
        private int bXz = 0;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (i.this.dBV != null) {
                i.this.dBV.ayV();
            }
            this.dCL = 0;
            this.bXz = 0;
            if (recyclerView != null && (recyclerView instanceof com.baidu.adp.widget.ListView.h)) {
                this.dCL = ((com.baidu.adp.widget.ListView.h) recyclerView).getFirstVisiblePosition();
                this.bXz = ((com.baidu.adp.widget.ListView.h) recyclerView).getLastVisiblePosition();
            }
            if (i.this.dCh != null) {
                i.this.dCh.b(recyclerView, this.dCL, this.bXz);
            }
            if (i.this.dBi != null && i.this.dBD != null && i.this.dBD.auU() != null) {
                i.this.dBD.bx(this.dCL, this.bXz);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i.this.dBM != null) {
                i.this.dBM.setScrollState(i);
            }
            if ((i == 2 || i == 1) && !i.this.dBI) {
                i.this.dBI = true;
                i.this.dBD.auW();
            }
            if (i.this.dBJ == null && !i.this.auy()) {
                i.this.dBJ = new com.baidu.tbadk.k.d();
                i.this.dBJ.im(1000);
            }
            if (i == 0) {
                com.baidu.tieba.card.s.akK().eH(true);
                i.this.dBD.bw(this.dCL, this.bXz);
            }
            if (i.this.dCh != null) {
                i.this.dCh.onScrollStateChanged(recyclerView, i);
            }
            if (i.this.dBJ != null) {
                i.this.dBJ.Nx();
            }
            if (i == 0) {
                com.baidu.tieba.frs.e.g.a(i.this.dBD, i.this.dBi, i.this.getForumId(), false, null);
            }
        }
    };
    private final b dCF = new b() { // from class: com.baidu.tieba.frs.i.22
        @Override // com.baidu.tieba.frs.b
        public void a(int i, int i2, View view, View view2, bd bdVar) {
            if (i != i.this.dBD.auU().awq()) {
                if (i != i.this.dBD.auU().awr()) {
                    if (i != i.this.dBD.auU().awt()) {
                        if (i != i.this.dBD.auU().avj()) {
                            if (i == i.this.dBD.auU().aws() && i.this.dBi != null && i.this.dBi.getUserData() != null && i.this.dBi.getUserData().isBawu()) {
                                final String btW = i.this.dBi.btW();
                                if (!com.baidu.tbadk.core.util.am.isEmpty(btW) && i.this.dBi.aYJ() != null) {
                                    com.baidu.tieba.c.a.a(i.this.getPageContext(), i.this.dBi.aYJ().getId(), i.this.dBi.aYJ().getName(), new a.InterfaceC0105a() { // from class: com.baidu.tieba.frs.i.22.1
                                        @Override // com.baidu.tieba.c.a.InterfaceC0105a
                                        public void ake() {
                                            com.baidu.tbadk.browser.a.P(i.this.getPageContext().getPageActivity(), btW);
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10502").aa(ImageViewerConfig.FORUM_ID, i.this.dBi.aYJ().getId()).aa("uid", i.this.dBi.getUserData().getUserId()));
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        i.this.dBv = bdVar;
                        com.baidu.tieba.frs.e.h.a(i.this, i.this.dBv);
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10179").aa(ImageViewerConfig.FORUM_ID, i.this.getForumId()));
                        return;
                    }
                    com.baidu.tieba.frs.e.h.z(i.this);
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak(i == i.this.dBD.auU().awt() ? "c10177" : "c10244").aa(ImageViewerConfig.FORUM_ID, i.this.getForumId()));
                } else if (com.baidu.tbadk.core.util.ax.bb(i.this.getPageContext().getPageActivity())) {
                    TiebaStatic.log("my_service_ck");
                    if (i.this.dBi != null && i.this.dBi.aYJ() != null) {
                        ForumData aYJ = i.this.dBi.aYJ();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(i.this.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(aYJ.getId(), 0L), aYJ.getName(), aYJ.getImage_url(), 0)));
                    }
                }
            } else if (com.baidu.tbadk.core.util.ax.bb(i.this.getActivity())) {
                TiebaStatic.log("forum_fortune_click");
                com.baidu.tieba.frs.e.h.a(i.this.getPageContext(), i.this.dBi);
            }
        }
    };
    private final NoNetworkView.a dzL = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.i.24
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bq(boolean z) {
            if (i.this.dBL.ayp() == 1 && z && !i.this.dBD.auw()) {
                if (i.this.dBi == null || v.E(i.this.dBi.getThreadList())) {
                    i.this.hideNetRefreshView(i.this.dBD.aep());
                    i.this.showLoadingView(i.this.dBD.aep(), true);
                    i.this.dBD.fH(false);
                    i.this.refresh();
                    return;
                }
                i.this.dBD.auM();
            }
        }
    };
    private final CustomMessageListener dCG = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.i.25
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                com.baidu.tieba.frs.e.c.a(customResponsedMessage, i.this.dBD, i.this.dBi);
            }
        }
    };
    private com.baidu.adp.widget.ListView.o dCH = new a();
    private an dCI = new an() { // from class: com.baidu.tieba.frs.i.26
        @Override // com.baidu.tieba.frs.an
        public void a(int i, int i2, at atVar, ArrayList<com.baidu.adp.widget.ListView.i> arrayList) {
            com.baidu.adp.lib.g.e.ns().post(new Runnable() { // from class: com.baidu.tieba.frs.i.26.1
                @Override // java.lang.Runnable
                public void run() {
                    if (i.this.dBD != null && i.this.dBD.alK()) {
                        i.this.VX();
                    }
                }
            });
        }
    };
    private CustomMessageListener dCJ = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.frs.i.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    i.this.dCi = true;
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.frs.loadmore.a
    public /* bridge */ /* synthetic */ com.baidu.adp.base.e getPageContext() {
        return super.getPageContext();
    }

    public com.baidu.tieba.frs.entelechy.b.b atU() {
        return this.dBT;
    }

    public com.baidu.adp.widget.ListView.o atV() {
        return this.dCH;
    }

    public com.baidu.tieba.frs.mc.d atW() {
        return this.dBW;
    }

    public com.baidu.tieba.frs.smartsort.b atX() {
        return this.dBP;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public FrsModelController atY() {
        return this.dBL;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public com.baidu.tieba.frs.mc.c atZ() {
        return this.dBX;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public com.baidu.tieba.frs.f.f aua() {
        return this.dBM;
    }

    public com.baidu.tieba.frs.f.k aub() {
        return this.dBN;
    }

    public ap auc() {
        return this.dBR;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public k aud() {
        return this.dBD;
    }

    @Override // com.baidu.tieba.frs.ao
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.ao, com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.dBw;
    }

    public void setForumName(String str) {
        this.dBw = str;
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
        if (this.dBX == null) {
            return 1;
        }
        return this.dBX.getPn();
    }

    public int getPn() {
        if (this.dBX == null) {
            return 1;
        }
        return this.dBX.getPn();
    }

    public void setPn(int i) {
        if (this.dBX != null) {
            this.dBX.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.dBX != null) {
            this.dBX.setHasMore(i);
        }
    }

    public int aue() {
        if (this.dBX == null) {
            return -1;
        }
        return this.dBX.aue();
    }

    public boolean auf() {
        return this.dBB;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d.a aVar) {
        if (aVar == null) {
            String string = TbadkCoreApplication.getInst().getString(d.j.error_unkown_try_again);
            this.dBD.auH();
            showNetRefreshView(this.dBD.aep(), string, true);
        } else if (340001 == aVar.errorCode) {
            a(aVar, this.dBi.btB());
        } else {
            if (v.E(this.dBi.getThreadList())) {
                b(aVar);
            }
            if (auy()) {
                setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.s(TbadkCoreApplication.getInst(), d.e.ds280));
            } else {
                setNetRefreshViewEmotionDefMarginTop();
            }
        }
    }

    public void a(View view, String str, boolean z, List<RecmForumInfo> list) {
        this.dBD.auH();
        this.dBD.mU(8);
        if (this.dCg == null) {
            this.dCg = new com.baidu.tieba.frs.view.b(getPageContext(), getNetRefreshListener());
        }
        this.dCg.gM(str);
        this.dCg.bw(list);
        this.dCg.j(view, z);
    }

    private void a(d.a aVar, List<RecmForumInfo> list) {
        if (this.dBD != null) {
            this.dBD.auH();
            this.dBD.setTitle(this.dBw);
        }
        a(this.dBD.aep(), aVar.errorMsg, true, list);
    }

    private void b(d.a aVar) {
        this.dBD.auH();
        if (aVar.gVp) {
            showNetRefreshView(this.dBD.aep(), TbadkCoreApplication.getInst().getString(d.j.net_error_text, new Object[]{aVar.errorMsg, Integer.valueOf(aVar.errorCode)}), true);
        } else {
            showNetRefreshView(this.dBD.aep(), aVar.errorMsg, true);
        }
    }

    public void aug() {
        hideLoadingView(this.dBD.aep());
        if (!this.dBD.auw()) {
            this.dBD.fI(false);
        } else {
            this.dBD.fI(true);
        }
        if (this.dBD.auF() instanceof com.baidu.tieba.frs.tab.a) {
            ((com.baidu.tieba.frs.tab.a) this.dBD.auF()).ayR();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auh() {
        if (aue() == 0 && v.E(this.dBi.btK())) {
            if (v.E(this.dBi.getThreadList())) {
                this.dBD.alU();
            } else {
                this.dBD.auY();
            }
        } else if (v.D(this.dBi.getThreadList()) > 3) {
            this.dBD.auX();
        } else {
            this.dBD.auZ();
        }
    }

    public void a(ErrorData errorData) {
        aug();
        this.dBD.auM();
        d.a aym = this.dBL.aym();
        boolean E = v.E(this.dBi.getThreadList());
        if (aym != null && E) {
            if (E) {
                if (this.dBL.ayn() != 0) {
                    this.dBL.ayt();
                    this.dBD.auM();
                } else {
                    a(aym);
                }
                this.dBD.x(this.dBi.buP(), false);
                return;
            } else if (aym.gVp) {
                this.dBD.x(true, false);
                showToast(getPageContext().getResources().getString(d.j.net_error_text, aym.errorMsg, Integer.valueOf(aym.errorCode)));
                return;
            } else {
                return;
            }
        }
        a(aym);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aui() {
        if (this.dBi == null || this.dBi.aYJ() != null) {
            this.dBD.auT();
        } else if (this.dBi.aYJ().getYuleData() != null && this.dBi.aYJ().getYuleData().At()) {
            TiebaStatic.log("c10852");
            this.dBD.a(this.dBi.aYJ().getYuleData().Au());
        } else {
            this.dBD.auT();
        }
    }

    private void v(boolean z, boolean z2) {
        if (this.dBL != null && this.dBi != null && this.dBD != null && z) {
            if (!this.dBL.ayz() && this.dBL.ayp() == 1) {
                if (!this.dBL.ayx()) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        this.dBi.buH();
                        this.dBi.buA();
                    }
                    this.dBi.buF();
                    this.dBi.buG();
                }
                boolean z3 = false;
                if (this.dBD.auU().k(com.baidu.tieba.card.data.p.cXN)) {
                    z3 = this.dBi.buK();
                }
                if (!z3) {
                    this.dBi.buI();
                }
                if (TbadkCoreApplication.getInst().isRecAppExist()) {
                    this.dBi.a(this);
                }
                if (!this.dBD.auU().k(bd.aNf)) {
                    this.dBi.bux();
                }
                this.dBi.buL();
            }
            if (!this.dBD.auU().k(bd.aNf)) {
                this.dBi.buE();
                this.dBi.buC();
            } else {
                this.dBi.buD();
                this.dBi.buB();
            }
            this.dBi.buy();
            this.dBi.buv();
            if (this.dBD.auU().k(com.baidu.tieba.g.b.dWa)) {
                this.dBi.mx(z2);
            }
            if (TbadkCoreApplication.isLogin() && (!this.dBL.ayz() || this.dBL.isNetFirstLoad)) {
                this.dBi.buM();
            }
            this.dBi.buN();
        }
    }

    public boolean auj() {
        if (this.dBM != null && this.dBL != null) {
            this.dBM.a(this.dBL.ayl(), this.dBi);
        }
        boolean z = false;
        if (this.dBi != null) {
            z = this.dBi.buQ();
        }
        aul();
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mR(int i) {
        aq aqVar = null;
        auj();
        aus();
        try {
            if (this.dBi != null) {
                this.dBD.a((ArrayList<com.baidu.adp.widget.ListView.i>) null, this.dBi);
                this.dBM.nO(1);
                this.dBD.auP();
                this.dBN.a(this.dBi, this.dBL.ayv());
                com.baidu.tieba.frs.tab.b nU = this.dBN.nU(this.dBi.btY());
                if (nU != null && !TextUtils.isEmpty(nU.url)) {
                    aqVar = new aq();
                    aqVar.dEC = nU.url;
                    aqVar.stType = nU.name;
                }
                this.dBL.a(this.dBi.btY(), 0, aqVar);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(boolean z, boolean z2) {
        try {
            if (this.dBi != null && this.dBN != null && this.dBL != null) {
                if (!this.dBD.auU().k(bd.aNf)) {
                    this.dBi.bux();
                }
                boolean E = v.E(this.dBi.bul());
                this.dBD.fF(E);
                if (!E) {
                    if (this.dCh == null) {
                        this.dCh = new com.baidu.tieba.frs.f.e(this, (NoPressedRelativeLayout) this.mRootView);
                    }
                    if (this.cgn == null) {
                        this.cgn = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
                    }
                } else {
                    this.dCh = null;
                    this.cgn = null;
                }
                if (this.dBi.aYJ() != null) {
                    this.dBw = this.dBi.aYJ().getName();
                    this.forumId = this.dBi.aYJ().getId();
                }
                if (this.dBi.buQ()) {
                    this.dBN.a(this.dBi, this.dBL.ayv());
                }
                if (z) {
                    v(true, z);
                } else {
                    v(this.dBK, z);
                }
                auj();
                if (this.dBT != null) {
                    this.dBT.a(this.dBM, this.dBi);
                }
                if (this.dBi.xZ() != null) {
                    setHasMore(this.dBi.xZ().xV());
                }
                ArrayList<com.baidu.adp.widget.ListView.i> a2 = this.dBX.a(z2, true, this.dBi.getThreadList(), null, z);
                if (a2 != null) {
                    this.dBi.at(a2);
                }
                if (this.dBL.ayp() == 1) {
                    aup();
                    if (!z && this.dBL.getPn() == 1) {
                        auk();
                    }
                }
                this.dBl = this.dBi.ayr();
                if (this.dBz != null) {
                    this.dBy = true;
                    this.dBz.vH(this.dBl);
                    com.baidu.tieba.frs.e.a.a(this, this.dBi.aYJ(), this.dBi.getThreadList(), this.dBy, getPn());
                }
                if (this.dBV != null) {
                    this.dBV.bS(this.dBN.azq());
                }
                aug();
                this.dBD.auI();
                this.dBD.x(true, false);
                if (this.dBi.aYJ() != null) {
                    this.dBD.lz(this.dBi.aYJ().getWarningMsg());
                }
                if (this.dBi != null && this.dBi.buo() != null && com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("frs_video_activity_guide", 0L) == 0) {
                    com.baidu.adp.lib.g.e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.i.8
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.dBD.ave();
                        }
                    }, 1000L);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FRS_SHOW_AR_ENTRY, this));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void auk() {
        if (this.dCa == null) {
            this.dCa = new com.baidu.tieba.frs.live.a(this, com.baidu.adp.lib.g.b.h(this.forumId, 0));
        }
        this.dCa.axY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.i iVar) {
        try {
            if (!this.dBH && iVar != null && this.dBi != null) {
                this.dBi.e(iVar);
                w(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void aul() {
        if (this.dBL != null) {
            ly(this.dBL.ayl());
        } else {
            ly("normal_page");
        }
    }

    private void ly(String str) {
        fC("frs_page".equals(str));
        if (this.dBT != null) {
            this.dBT.a(this.dBM, this.dBD, this.dBi);
        }
    }

    public void fC(boolean z) {
        if (this.dBY != null) {
            this.dBY.a(this.dBD, z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(d.h.frs_activity, viewGroup, false);
            this.dBr = new com.baidu.tieba.frs.entelechy.b();
            this.dBT = this.dBr.avW();
            this.dBM = new com.baidu.tieba.frs.f.f(this, this.dBr, (FrsHeaderViewContainer) this.mRootView.findViewById(d.g.header_view_container));
            this.dBN = new com.baidu.tieba.frs.f.i(this, this.mRootView);
            this.dBN.a(this.dCr);
            Intent intent = getActivity().getIntent();
            if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                this.dBt = true;
            }
            this.dBD = new k(this, this.dCE, this.dBr, this.dBt);
            this.dBD.setHeaderViewHeight(this.dCe);
        } else {
            if (this.mRootView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            this.dBN.resetData();
            this.dBD.avd();
        }
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Intent intent = getActivity().getIntent();
        this.dmS = System.currentTimeMillis();
        if (intent != null) {
            this.dBA = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.dmS = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            L(intent);
        }
        this.beginTime = System.currentTimeMillis();
        this.byx = this.beginTime - this.dmS;
        this.dBz = new com.baidu.tieba.tbadkCore.data.e("frs", com.baidu.tieba.tbadkCore.data.e.gXZ);
        this.dBL = new FrsModelController(this, this.dCz);
        this.dBL.a(this.dCp);
        this.dBL.init();
        if (intent != null) {
            this.dBL.k(intent.getExtras());
        } else if (bundle != null) {
            this.dBL.k(bundle);
        } else {
            this.dBL.k(null);
        }
        if (intent != null) {
            this.dBM.n(intent.getExtras());
        } else if (bundle != null) {
            this.dBM.n(bundle);
        } else {
            this.dBM.n((Bundle) null);
        }
        this.dBC = getVoiceManager();
        this.dCb = new j(getPageContext(), this);
        initUI();
        initData(bundle);
        if (this.mFrom != null && this.mFrom.equals("from_tieba_kuang")) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12264").s("obj_type", 1).aa(ImageViewerConfig.FORUM_NAME, this.dBL.getForumName()));
            KuangFloatingViewController.getInstance().setNeedShowFloatingView(true);
            if (KuangFloatingViewController.getInstance().init()) {
                ((BaseFragmentActivity) getPageContext().getOrignalPage()).grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.frs.i.11
                    @Override // com.baidu.tbadk.core.e
                    public void aP(boolean z) {
                        if (z) {
                            KuangFloatingViewController.getInstance().showFloatingView();
                        }
                    }
                });
            }
        }
        if (!auy()) {
            this.dBR = new ap(getActivity(), this.dBD, this.dBM);
            this.dBR.fP(true);
        }
        this.dBC = getVoiceManager();
        if (this.dBC != null) {
            this.dBC.onCreate(getPageContext());
        }
        new com.baidu.tieba.frs.mc.g();
        this.dBX = new com.baidu.tieba.frs.mc.c(this, this.dCB);
        this.dBP = new com.baidu.tieba.frs.smartsort.b(this);
        this.dBY = new com.baidu.tieba.frs.f.h(this);
        this.createTime = System.currentTimeMillis() - this.beginTime;
        this.dBV = new com.baidu.tieba.frs.f.a(getPageContext(), this.dBL.ayw());
        this.dBQ = new com.baidu.tieba.frs.mc.b(this);
        this.dBW = new com.baidu.tieba.frs.mc.d(this);
        this.dBO = new com.baidu.tieba.frs.mc.f(this);
        this.dBZ = new com.baidu.tieba.frs.mc.a(this);
        this.dCc = new com.baidu.tieba.frs.f.c(this);
        this.dCd = new com.baidu.tieba.frs.mc.e(this, getUniqueId());
        this.dCk = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "frs");
        this.dCl = new com.baidu.tieba.ala.a(getPageContext());
        registerListener(this.cdD);
        registerListener(this.mMemListener);
        registerListener(this.dCw);
        registerListener(this.dCC);
        registerListener(this.dCv);
        registerListener(this.dCA);
        registerListener(this.dCs);
        registerListener(this.dCt);
        registerListener(this.dCu);
        registerListener(this.dCm);
        registerListener(this.dCn);
        registerListener(this.dCJ);
        registerListener(this.dCy);
        registerListener(this.dCo);
        this.dBD.fH(false);
        if (!auy()) {
            showLoadingView(this.dBD.aep(), true);
            this.dBL.B(3, true);
        }
        super.onActivityCreated(bundle);
    }

    @Override // com.baidu.tieba.frs.aj
    public void Wz() {
        if (isAdded() && this.chw && !isLoadingViewAttached()) {
            showLoadingView(this.dBD.aep(), true);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void WA() {
        if (isAdded() && this.chw && isLoadingViewAttached()) {
            hideLoadingView(this.dBD.aep());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (auy()) {
            showLoadingView(this.dBD.aep(), true);
            this.dBD.mV(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.dBL.B(3, true);
            Ee().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void setHeaderViewHeight(int i) {
        this.dCe = i;
        if (this.dBD != null) {
            this.dBD.setHeaderViewHeight(this.dCe);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.s sVar) {
        if (sVar != null) {
            this.bBs = sVar.OG();
            this.dCf = sVar.OH();
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void showFloatingView() {
        if (this.bBs != null) {
            this.bBs.cC(true);
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
            this.dBw = data.getQueryParameter("name");
            this.mFrom = data.getQueryParameter("from");
            if (!StringUtils.isNull(this.dBw)) {
                intent.putExtra("name", this.dBw);
            }
            if (!StringUtils.isNull(this.mFrom)) {
                intent.putExtra("from", this.mFrom);
            }
            TiebaStatic.log("c10105");
        }
        if (StringUtils.isNull(this.dBw)) {
            this.dBw = com.baidu.tieba.frs.e.h.N(intent);
            if (!StringUtils.isNull(this.dBw)) {
                intent.putExtra("name", this.dBw);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.dBC = getVoiceManager();
        if (this.dBC != null) {
            this.dBC.onStart(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        Intent intent;
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.dCG);
        if (bundle != null) {
            this.dBw = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
            this.dBw = intent.getStringExtra("name");
            this.mFrom = intent.getStringExtra("from");
            this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
        }
        if (TextUtils.isEmpty(this.mFrom) || FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
        }
        if (this.mIsLogin) {
            registerListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL, this.dCG);
        }
        this.dBM.n(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dCJ);
        if (this.dBC != null) {
            this.dBC.onDestory(getPageContext());
        }
        this.dBC = null;
        com.baidu.tieba.card.s.akK().eH(false);
        if (this.dBi != null && this.dBi.aYJ() != null) {
            ae.avp().bE(com.baidu.adp.lib.g.b.c(this.dBi.aYJ().getId(), 0L));
        }
        if (this.dCa != null) {
            this.dCa.onDestory();
        }
        if (this.dBD != null) {
            com.baidu.tieba.frs.e.g.a(this.dBD, this.dBi, getForumId(), false, null);
            this.dBD.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.dBJ != null) {
                this.dBJ.onDestroy();
            }
            this.dBD.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.dBL.onActivityDestroy();
        this.dBM.onActivityDestroy();
        if (this.dBL != null) {
            this.dBL.XY();
        }
        if (this.dBR != null) {
            this.dBR.OF();
        }
        if (this.dBU != null) {
            this.dBU.destory();
        }
        if (this.dBV != null) {
            this.dBV.destory();
        }
        if (this.dBP != null) {
            this.dBP.onDestroy();
        }
        if (this.dCh != null) {
            this.dCh.onDestory();
        }
        if (this.dBZ != null) {
            this.dBZ.onDestroy();
        }
        if (this.dCk != null) {
            this.dCk.onDestroy();
        }
        if (this.dCl != null) {
            this.dCl.onDestroy();
        }
        com.baidu.tieba.recapp.e.a.bnx().bnz();
        com.baidu.tieba.frs.e.i.ayS();
        if (this.dBN != null) {
            this.dBN.a((i.b) null);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.dBw);
        bundle.putString("from", this.mFrom);
        this.dBL.onSaveInstanceState(bundle);
        if (this.dBC != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            this.dBC.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.dBZ != null) {
            this.dBZ.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dBD != null) {
            this.dBD.auM();
            this.dBD.onResume();
        }
        this.dBO.gf(true);
        this.dBK = true;
        if (dBu) {
            dBu = false;
            this.dBD.startPullRefresh();
            return;
        }
        if (this.dBC != null) {
            this.dBC.onResume(getPageContext());
        }
        this.dBD.fJ(false);
        registerListener(this.dCD);
        if (this.dCi) {
            refresh(6);
            this.dCi = false;
        }
        if (KuangFloatingViewController.getInstance().init()) {
            ((BaseFragmentActivity) getPageContext().getOrignalPage()).grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.frs.i.17
                @Override // com.baidu.tbadk.core.e
                public void aP(boolean z) {
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

    public boolean aum() {
        Intent intent;
        if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
            return false;
        }
        return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
    }

    public void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.dBw = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.dBx = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.dBx) {
                aun();
            }
            if (this.mFrom != null && this.mFrom.equals("from_tieba_kuang")) {
                KuangFloatingViewController.getInstance().setNeedShowFloatingView(true);
                if (KuangFloatingViewController.getInstance().init()) {
                    ((BaseFragmentActivity) getPageContext().getOrignalPage()).grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.frs.i.18
                        @Override // com.baidu.tbadk.core.e
                        public void aP(boolean z) {
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
    public void aun() {
        this.dBD.startPullRefresh();
    }

    public void closeActivity() {
        com.baidu.tieba.frs.e.h.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.mFrom);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.dBD.setTitle(this.dBw);
        } else {
            this.dBD.setTitle("");
            this.mFlag = 1;
        }
        this.dBD.setOnAdapterItemClickListener(this.dCH);
        this.dBD.addOnScrollListener(this.Si);
        this.dBD.h(this.dzL);
        this.dBD.auU().a(this.dCF);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dBD.onChangeSkinType(i);
        this.dBM.nN(i);
        this.dBN.onChangeSkinType(i);
        if (this.dCg != null) {
            this.dCg.onChangeSkinType();
        }
    }

    public void mS(int i) {
        if (!this.mIsLogin) {
            if (this.dBi != null && this.dBi.xH() != null) {
                this.dBi.xH().setIfpost(1);
            }
            if (i == 0) {
                com.baidu.tbadk.core.util.ax.ba(getActivity());
            }
        } else if (this.dBi != null) {
            if (i == 0) {
                com.baidu.tieba.frs.e.i.b(this, 0);
            } else {
                this.dBD.auO();
            }
        }
    }

    public void refresh() {
        refresh(3);
    }

    public void refresh(int i) {
        this.dBH = false;
        aus();
        if (this.dBD.auE() != null) {
            this.dBD.auE().aCG();
        }
        this.dBL.B(i, true);
    }

    private void auo() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.g.h.nt().e(new Runnable() { // from class: com.baidu.tieba.frs.i.19
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.sI(i.this.dBw);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aup() {
        aus();
        try {
            if (this.dBi != null) {
                this.dBD.WP();
                this.dBD.fE(this.dBL.ayq());
                if (com.baidu.tieba.frs.f.f.i(this.dBi) && !com.baidu.tieba.frs.f.f.h(this.dBi)) {
                    this.dBD.avb();
                }
                if (this.dBi.aYJ() != null) {
                    this.dBw = this.dBi.aYJ().getName();
                    this.forumId = this.dBi.aYJ().getId();
                }
                if (this.dBi.xZ() != null) {
                    setHasMore(this.dBi.xZ().xV());
                }
                this.dBD.setTitle(this.dBw);
                this.dBD.setForumName(this.dBw);
                TbadkCoreApplication.getInst().setDefaultBubble(this.dBi.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.dBi.getUserData().getBimg_end_time());
                auo();
                auq();
                ArrayList<com.baidu.adp.widget.ListView.i> threadList = this.dBi.getThreadList();
                if (threadList != null) {
                    this.dBD.a(threadList, this.dBi);
                    com.baidu.tieba.frs.e.c.l(this.dBD);
                    this.dBM.nO(getPageNum());
                    this.dBM.f(this.dBi);
                    this.dBN.a(this.dBi, this.dBL.ayv());
                    this.dBD.auP();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void auq() {
        if (this.dBi != null) {
            if (this.dBi.aYY() == 1) {
                this.dBD.auU().setFromCDN(true);
            } else {
                this.dBD.auU().setFromCDN(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.dBO.gf(false);
        this.dBK = false;
        this.dBD.onPause();
        if (this.dBC != null) {
            this.dBC.onPause(getPageContext());
        }
        this.dBD.fJ(true);
        if (this.dBV != null) {
            this.dBV.ayV();
        }
        MessageManager.getInstance().unRegisterListener(this.dCD);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.s.akK().eH(false);
        if (this.dBi != null && this.dBi.aYJ() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            com.baidu.tbadk.distribute.a.Kg().a(getPageContext().getPageActivity(), "frs", this.dBi.aYJ().getId(), 0L);
        }
        if (this.dBC != null) {
            this.dBC.onStop(getPageContext());
        }
        if (Ee() != null) {
            Ee().getRecycledViewPool().clear();
        }
        this.dBM.onActivityStop();
        t.OJ();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && this.dBM != null) {
            this.dBM.gh(isPrimary());
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || this.dBD == null) {
            return false;
        }
        return this.dBD.auL();
    }

    @Override // com.baidu.tieba.recapp.o
    public TbPageContext<?> akf() {
        return getPageContext();
    }

    @Override // com.baidu.tieba.recapp.o
    public void a(AdvertAppInfo advertAppInfo, String str) {
        com.baidu.tbadk.distribute.a.Kg().a(advertAppInfo, this.forumId, 0L, "FRS", str, getPn());
    }

    @Override // com.baidu.tieba.recapp.o
    public void aur() {
        atY().aur();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dBC == null) {
            this.dBC = VoiceManager.instance();
        }
        return this.dBC;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public com.baidu.adp.widget.ListView.h Ee() {
        if (this.dBD == null) {
            return null;
        }
        return this.dBD.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void aus() {
        if (this.dBC != null) {
            this.dBC.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> Ef() {
        if (this.bdh == null) {
            this.bdh = UserIconBox.v(getPageContext().getPageActivity(), 8);
        }
        return this.bdh;
    }

    public void aut() {
        if (getFragmentActivity() != null && getFragmentActivity().getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.a(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.l onGetPreLoadListView() {
        return Ee().getPreLoadHandle();
    }

    @Override // com.baidu.tieba.frs.am
    public NavigationBar auu() {
        if (this.dBD == null) {
            return null;
        }
        return this.dBD.auu();
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
                if (bdUniqueId == r.dDQ) {
                    if (i.this.dBD != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11752").aa(ImageViewerConfig.FORUM_ID, i.this.forumId).aa("obj_locate", "1"));
                        i.this.dBD.startPullRefresh();
                    }
                } else if (iVar != null && (iVar instanceof bd)) {
                    bd bdVar = (bd) iVar;
                    if (bdVar.zE() == null || bdVar.zE().getGroup_id() == 0 || com.baidu.tbadk.core.util.ax.bb(i.this.getActivity())) {
                        if ((bdVar.zx() != 1 && bdVar.zx() != 2) || com.baidu.tbadk.core.util.ax.bb(i.this.getActivity())) {
                            if (bdVar.zh() != null) {
                                if (com.baidu.tbadk.core.util.ax.bb(i.this.getActivity())) {
                                    String postUrl = bdVar.zh().getPostUrl();
                                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.pa()) {
                                        com.baidu.tbadk.browser.a.Q(i.this.getActivity(), postUrl);
                                    }
                                }
                            } else if (bdVar.zN() != null) {
                                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                    com.baidu.tbadk.core.util.ax.ba(i.this.getPageContext().getPageActivity());
                                    return;
                                }
                                com.baidu.tbadk.core.data.m zN = bdVar.zN();
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(i.this.getPageContext().getPageActivity(), zN.getCartoonId(), zN.getChapterId(), 2)));
                            } else if (bdVar.getThreadType() == 47 && bdVar.yO() == 1 && !com.baidu.tbadk.core.util.am.isEmpty(bdVar.zb())) {
                                com.baidu.tbadk.browser.a.P(i.this.getPageContext().getPageActivity(), bdVar.zb());
                            } else {
                                com.baidu.tieba.tbadkCore.util.e readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                                if (readThreadHistory != null && !readThreadHistory.sO(bdVar.getId())) {
                                    readThreadHistory.sN(bdVar.getId());
                                }
                                final String zb = bdVar.zb();
                                if (zb == null || zb.equals("")) {
                                    z = false;
                                } else {
                                    new Thread(new Runnable() { // from class: com.baidu.tieba.frs.i.a.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(zb);
                                            xVar.Cg().Dc().mIsNeedAddCommenParam = false;
                                            xVar.Cg().Dc().mIsUseCurrentBDUSS = false;
                                            xVar.BJ();
                                        }
                                    }).start();
                                    z = true;
                                }
                                String tid = bdVar.getTid();
                                if (tid == null) {
                                    tid = "";
                                }
                                if (bdVar.yO() == 2 && !tid.startsWith("pb:")) {
                                    com.baidu.tbadk.core.util.av.Da().c(i.this.getPageContext(), new String[]{tid, "", null});
                                } else if (bdVar.getThreadType() == 33 || (bdVar instanceof as)) {
                                    String str = bdVar.getThreadType() == 33 ? "c10245" : "c10180";
                                    if (i.this.dBL.ayp() == 5) {
                                        str = "c10387";
                                    }
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak(str).aa(ImageViewerConfig.FORUM_ID, i.this.forumId));
                                    com.baidu.tieba.frs.e.h.b(i.this, bdVar);
                                    if (i.this.dBi != null && i.this.dBi.aYJ() != null) {
                                        com.baidu.tieba.frs.d.a aVar = new com.baidu.tieba.frs.d.a();
                                        aVar.dQS = i.this.dBi.gVW == 1;
                                        aVar.dQU = i.this.dBi.aYJ().getId();
                                        aVar.dQT = i.this.atY().ayv();
                                        com.baidu.tieba.frs.d.b.ayP().a(aVar, bdVar, 1);
                                    }
                                } else {
                                    if (tid.startsWith("pb:")) {
                                        bdVar.setId(tid.substring(3));
                                    }
                                    if (bdUniqueId.getId() == bd.aOp.getId()) {
                                        com.baidu.tieba.frs.e.g.a(bdVar.yB());
                                    }
                                    com.baidu.tieba.frs.e.h.a(i.this, bdVar, i, z);
                                    com.baidu.tieba.frs.e.g.a(i.this, i.this.dBi, bdVar);
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
        if (com.baidu.adp.lib.util.l.pa()) {
            hideNetRefreshView(this.dBD.aep());
            showLoadingView(this.dBD.aep(), true);
            this.dBD.fH(false);
            this.dBL.B(3, true);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public com.baidu.tieba.tbadkCore.l auv() {
        return this.dBi;
    }

    public boolean auw() {
        return this.dBD.auw();
    }

    public void aU(Object obj) {
        if (this.dBQ != null && this.dBQ.dPH != null) {
            this.dBQ.dPH.ak(obj);
        }
    }

    public void aV(Object obj) {
        if (this.dBQ != null && this.dBQ.dPI != null) {
            this.dBQ.dPI.ak(obj);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.l.pa()) {
            this.dBD.alU();
        } else if (this.dBL.ayp() == 1) {
            Wl();
            VX();
        } else if (this.dBL.hasMore()) {
            VX();
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void lm(String str) {
        Wl();
        showToast(str);
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void J(ArrayList<com.baidu.adp.widget.ListView.i> arrayList) {
        Wl();
        if (!v.E(arrayList)) {
            if (!this.dBL.ayz() && TbadkCoreApplication.getInst().isRecAppExist() && this.dBL.ayp() == 1) {
                this.dBi.a(this, arrayList);
            }
            ArrayList<com.baidu.adp.widget.ListView.i> a2 = this.dBX.a(false, false, arrayList, this.dBz);
            if (a2 != null) {
                this.dBi.at(a2);
                this.dBD.a(a2, this.dBi);
            }
            if (this.dBL != null) {
                com.baidu.tieba.frs.d.b.a(this.dBi, this.dBL.ayv(), 2);
            }
        }
    }

    private void Wl() {
        if (aue() == 1 || this.dBX.bt(this.dBi.btK())) {
            if (v.D(this.dBi.getThreadList()) > 3) {
                this.dBD.auX();
            } else {
                this.dBD.auZ();
            }
        } else if (v.E(this.dBi.getThreadList())) {
            this.dBD.alU();
        } else {
            this.dBD.auY();
        }
    }

    @Override // com.baidu.tieba.frs.mc.j
    public void VX() {
        if (this.dBX != null) {
            this.dBX.a(this.dBw, this.forumId, this.dBi);
        }
    }

    public void aux() {
        if (!com.baidu.tbadk.core.util.ab.e(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.ai.c(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return auy() ? "a034" : "a006";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (!auy()) {
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

    public void fD(boolean z) {
        if (this.dBR != null) {
            this.dBR.fP(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.dBS.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a jg(int i) {
        return this.dBS.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        this.dCb.b(bVar);
    }

    public boolean auy() {
        return this.dBt;
    }

    @Override // com.baidu.tieba.frs.aj
    public void Wy() {
        if (this.dBD != null) {
            showFloatingView();
            this.dBD.getListView().scrollToPosition(0);
            this.dBD.startPullRefresh();
        }
    }

    public ForumWriteData auz() {
        if (this.dBi == null || this.dBi.aYJ() == null) {
            return null;
        }
        ForumData aYJ = this.dBi.aYJ();
        ForumWriteData forumWriteData = new ForumWriteData(aYJ.getId(), aYJ.getName(), aYJ.getPrefixData(), this.dBi.xH());
        forumWriteData.setForumLevel(aYJ.getUser_level());
        forumWriteData.setAvatar(this.dBi.aYJ().getImage_url());
        UserData userData = this.dBi.getUserData();
        if (userData != null) {
            forumWriteData.setPrivateThread(userData.getPrivateThread());
            return forumWriteData;
        }
        return forumWriteData;
    }

    @Override // com.baidu.tieba.frs.aj
    public void DT() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.frs.aj
    public void setVideoThreadId(String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z) {
        super.showLoadingView(view, z);
        this.dBD.mU(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        super.hideLoadingView(view);
        this.dBD.mU(0);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        super.showNetRefreshView(view, str, z);
        this.dBD.mU(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshViewNoClick(View view, String str, boolean z) {
        super.showNetRefreshViewNoClick(view, str, z);
        this.dBD.mU(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        super.hideNetRefreshView(view);
        this.dBD.mU(0);
    }

    public void auA() {
        i.c azr;
        if (this.dBN != null && (azr = this.dBN.azr()) != null && azr.fragment != null && (azr.fragment instanceof al)) {
            ((al) azr.fragment).atP();
        }
    }
}
