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
    public static boolean dAZ = false;
    public static volatile long dBj = 0;
    public static volatile long dBk = 0;
    public static volatile int dBl = 0;
    private com.baidu.tbadk.util.r bBk;
    private com.baidu.adp.lib.e.b<TbImageView> bcZ;
    private com.baidu.tieba.frs.gametab.b cgf;
    private com.baidu.tieba.frs.entelechy.b dAW;
    private com.baidu.tieba.frs.f.a dBA;
    private com.baidu.tieba.frs.mc.d dBB;
    private com.baidu.tieba.frs.mc.c dBC;
    private com.baidu.tieba.frs.f.h dBD;
    private com.baidu.tieba.frs.mc.a dBE;
    private com.baidu.tieba.frs.live.a dBF;
    private j dBG;
    public com.baidu.tieba.frs.f.c dBH;
    private com.baidu.tieba.frs.mc.e dBI;
    private int dBJ;
    private View.OnTouchListener dBK;
    private com.baidu.tieba.frs.view.b dBL;
    private com.baidu.tieba.frs.f.e dBM;
    private boolean dBN;
    private com.baidu.tieba.NEGFeedBack.a dBP;
    private com.baidu.tieba.ala.a dBQ;
    public bd dBa;
    private com.baidu.tieba.tbadkCore.data.e dBe;
    private VoiceManager dBh;
    private FrsModelController dBq;
    private com.baidu.tieba.frs.f.f dBr;
    private com.baidu.tieba.frs.f.i dBs;
    private com.baidu.tieba.frs.mc.f dBt;
    private com.baidu.tieba.frs.smartsort.b dBu;
    private com.baidu.tieba.frs.mc.b dBv;
    private ap dBw;
    private com.baidu.tieba.frs.entelechy.b.b dBy;
    private com.baidu.tbadk.h.a dBz;
    public View mRootView;
    public boolean dAX = false;
    private boolean dAY = false;
    public String dBb = null;
    public String mFrom = null;
    public int mFlag = 0;
    private boolean dBc = false;
    private String mThreadId = null;
    public String forumId = null;
    private int dAQ = 0;
    private boolean dBd = false;
    private boolean dBf = false;
    private boolean dBg = false;
    private k dBi = null;
    public final bd bXM = null;
    private com.baidu.tieba.tbadkCore.l dAN = new com.baidu.tieba.tbadkCore.l();
    public long dmx = -1;
    public long byw = 0;
    public long byo = 0;
    public long createTime = 0;
    public long beginTime = -1;
    private boolean dBm = false;
    private boolean dBn = false;
    public com.baidu.tbadk.k.d dBo = null;
    private boolean dBp = true;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> dBx = new SparseArray<>();
    private boolean cho = true;
    private boolean dBO = false;
    private final CustomMessageListener dBR = new CustomMessageListener(CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED) { // from class: com.baidu.tieba.frs.i.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016495) {
                Object data = customResponsedMessage.getData();
                if (data instanceof bd) {
                    com.baidu.tieba.frs.e.g.a(i.this.dBi, i.this.dAN, i.this.getForumId(), true, (bd) data);
                }
            }
        }
    };
    private CustomMessageListener dBS = new CustomMessageListener(CmdConfigCustom.CMD_CLOSE_GAME_RANK_CARD) { // from class: com.baidu.tieba.frs.i.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (i.this.dAN != null) {
                i.this.dAN.buH();
                if (i.this.dBi != null) {
                    i.this.dBi.alO();
                }
            }
        }
    };
    private CustomMessageListener dBT = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.i.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 1) {
                    i.this.aui();
                }
            }
        }
    };
    private final an dBU = new an() { // from class: com.baidu.tieba.frs.i.28
        @Override // com.baidu.tieba.frs.an
        public void a(int i, int i2, at atVar, ArrayList<com.baidu.adp.widget.ListView.i> arrayList) {
            i.this.aub();
            if (i.this.dBy != null) {
                i.this.dBr.gg(i.this.dBy.nj(i));
            }
            d.a aVar = new d.a();
            if (atVar != null) {
                aVar.isSuccess = atVar.errCode == 0;
                aVar.errorCode = atVar.errCode;
                aVar.errorMsg = atVar.errMsg;
                if (aVar.isSuccess) {
                    if (v.E(arrayList)) {
                        i.this.dBi.alP();
                    } else if (atVar.hasMore) {
                        if (v.D(i.this.dAN.getThreadList()) > 3) {
                            i.this.dBi.auS();
                        } else {
                            i.this.dBi.auU();
                        }
                    } else if (atVar.dEk) {
                        i.this.dBi.auT();
                    } else {
                        i.this.dBi.alP();
                    }
                }
            } else {
                atVar = new at();
                atVar.pn = 1;
                atVar.hasMore = false;
                atVar.dEk = false;
            }
            if (i == 1) {
                i.this.dBp = true;
                i.this.dCe.a(i.this.dBq.getType(), false, aVar);
            } else {
                i.this.a(aVar);
                if (i.this.dBq.axQ() != null) {
                    i.this.dAN = i.this.dBq.axQ();
                }
                i.this.auk();
            }
            if (i.this.dCn != null) {
                i.this.dCn.a(i, i2, atVar, arrayList);
            }
        }
    };
    private ak dBV = new ak() { // from class: com.baidu.tieba.frs.i.29
        @Override // com.baidu.tieba.frs.ak
        public void a(an anVar) {
        }

        @Override // com.baidu.tieba.frs.ak
        public void a(int i, int i2, aq aqVar) {
            if (i != 1) {
                com.baidu.tieba.card.s.akF().eF(false);
            }
            i.this.aun();
            i.this.dBq.a(i, i2, aqVar);
        }

        @Override // com.baidu.tieba.frs.ak
        public void init() {
        }

        @Override // com.baidu.tieba.frs.ak
        public void XW() {
        }
    };
    private i.b dBW = new i.b() { // from class: com.baidu.tieba.frs.i.30
        @Override // com.baidu.tieba.frs.f.i.b
        public void hV(int i) {
            if (i != 1) {
                com.baidu.tieba.card.s.akF().eF(false);
            }
            i.this.aun();
            com.baidu.tieba.frs.d.c.dQJ.dQA = i;
            com.baidu.tieba.frs.d.c.dQJ.dQB = -1;
        }
    };
    private CustomMessageListener dBX = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIVE_COUNT) { // from class: com.baidu.tieba.frs.i.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                i.this.dBs.nV(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    };
    private CustomMessageListener dBY = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_LIVE_START) { // from class: com.baidu.tieba.frs.i.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && ((Integer) customResponsedMessage.getData()).intValue() == 51 && i.this.dAN != null) {
                com.baidu.tieba.frs.e.i.a(i.this.dAN, i.this.getPageContext());
            }
        }
    };
    private final CustomMessageListener dBZ = new CustomMessageListener(CmdConfigCustom.CMD_FRS_SELECT_ALA_LIVE_TAB) { // from class: com.baidu.tieba.frs.i.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                i.this.dBs.nT(49);
            }
        }
    };
    private final CustomMessageListener dCa = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.frs.i.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && i.this.dAN != null && i.this.dAN.aYE() != null) {
                SignData signData = (SignData) customResponsedMessage.getData();
                int user_level = i.this.dAN.aYE().getUser_level();
                if (signData.forumId != null && signData.forumId.equals(i.this.dAN.aYE().getId())) {
                    i.this.dAN.d(signData);
                    i.this.dBr.g(i.this.dAN);
                    if (i.this.dBr.azh()) {
                        i = i.this.dAN.aYE().getUser_level();
                        if (user_level >= i) {
                            i++;
                        }
                    } else {
                        i = user_level;
                    }
                    TbadkCoreApplication.getInst().addSignedForum(i.this.dAN.aYE().getName(), signData.sign_bonus_point, i);
                }
            }
        }
    };
    private final CustomMessageListener dCb = new CustomMessageListener(CmdConfigCustom.CMD_FRS_EXPERIENCE_TIP) { // from class: com.baidu.tieba.frs.i.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.r) && i.this.dAN != null) {
                i.this.dAN.c((com.baidu.tieba.tbadkCore.r) customResponsedMessage.getData());
                i.this.dBr.f(i.this.dAN);
                i.this.dBs.a(i.this.dAN, i.this.dBq.ayq());
            }
        }
    };
    private final AntiHelper.a dCc = new AntiHelper.a() { // from class: com.baidu.tieba.frs.i.4
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12536").s("obj_locate", ap.a.aVY));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12535").s("obj_locate", ap.a.aVY));
        }
    };
    private CustomMessageListener cdv = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.i.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(i.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().bgK != null) {
                        if (AntiHelper.a(i.this.getActivity(), updateAttentionMessage.getData().bgK, i.this.dCc) != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12534").s("obj_locate", ap.a.aVY));
                        }
                    } else if (updateAttentionMessage.getData().apN && updateAttentionMessage.getData().isAttention) {
                        com.baidu.adp.lib.util.l.showToast(i.this.getPageContext().getPageActivity(), d.j.attention_success);
                    }
                }
            }
        }
    };
    private CustomMessageListener dCd = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.frs.i.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                i.this.dBi.c((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.n dCe = new com.baidu.tieba.tbadkCore.n() { // from class: com.baidu.tieba.frs.i.7
        private long startTime = 0;

        @Override // com.baidu.tieba.tbadkCore.n
        public void mT(int i) {
            this.startTime = System.nanoTime();
            if (i.this.dBi != null) {
                switch (i) {
                    case 1:
                    case 2:
                        i.this.dBi.auH();
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
            if (i.this.cho) {
                i.this.cho = false;
                com.baidu.tieba.frs.e.g.a(i.this.dBi, i.this.dAN, i.this.getForumId(), false, null);
            }
            i.this.aub();
            i.this.dBm = true;
            if (aVar != null && aVar.isSuccess) {
                i.this.dBi.auP().fT(com.baidu.tbadk.core.util.an.CJ().CL());
                i.dBj = 0L;
                i.dBk = 0L;
                i.dBl = 0;
            } else {
                i.dBl = 1;
            }
            if (!i.this.dBq.ayu() && (i == 3 || i == 6)) {
                i.this.dBC.resetData();
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i.this.dBq.axQ() != null) {
                i.this.dAN = i.this.dBq.axQ();
            }
            if (i == 7) {
                i.this.mR(i.this.dAN.btW());
                return;
            }
            if (i.this.dAN.xY() != null) {
                i.this.setHasMore(i.this.dAN.xY().xU());
            }
            i.this.auc();
            if (i == 4) {
                if (!i.this.dBq.ayu() && TbadkCoreApplication.getInst().isRecAppExist() && i.this.dBq.ayk() == 1) {
                    i.this.dAN.a(i.this);
                }
                ArrayList<com.baidu.adp.widget.ListView.i> a2 = i.this.dBC.a(false, false, i.this.dAN.getThreadList(), i.this.dBe);
                if (a2 != null) {
                    i.this.dAN.at(a2);
                    i.this.dAN.buw();
                    i.this.dBi.a(a2, i.this.dAN);
                }
                if (i.this.dBq != null) {
                    com.baidu.tieba.frs.d.b.a(i.this.dAN, i.this.dBq.ayq(), 2);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    i.this.dBi.auH();
                    break;
                case 2:
                    i.this.dBi.auH();
                    break;
                case 3:
                case 6:
                    if (i.this.dAN != null) {
                        i.this.dAN.buu();
                    }
                    if (i.this.dBH != null) {
                        i.this.dBH.refresh();
                        break;
                    }
                    break;
            }
            i.this.aud();
            if (aVar == null || aVar.errorCode == 0) {
                if (i.this.dAN != null) {
                    i.this.w(false, i == 5);
                    i.this.dBi.mW(i);
                    i.dBj = (System.nanoTime() - this.startTime) / 1000000;
                    if (aVar != null) {
                        i.dBk = aVar.gUW;
                    }
                } else {
                    return;
                }
            } else if (i.this.dAN == null || v.E(i.this.dAN.getThreadList())) {
                i.this.a(aVar);
            } else if (aVar.gUV) {
                i.this.showToast(i.this.getPageContext().getResources().getString(d.j.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
            }
            if (i.this.dAN.btC() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11384"));
            }
            if (i.this.dmx > -1 && !i.this.dBO) {
                com.baidu.tieba.frs.e.g.a(i.this.dBq, i.this.dmx);
                i.this.dmx = -1L;
                i.this.dBO = true;
            }
            if (i.this.dBf && i.this.dBs.nT(49)) {
                i.this.dBf = false;
            }
            i.this.byw = System.currentTimeMillis() - currentTimeMillis;
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void b(com.baidu.tieba.tbadkCore.i iVar) {
            if (iVar != null) {
                if ("normal_page".equals(i.this.dBq.ayg()) || "frs_page".equals(i.this.dBq.ayg()) || "book_page".equals(i.this.dBq.ayg())) {
                    i.this.a(iVar);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE, iVar));
                }
            }
        }
    };
    private final CustomMessageListener dCf = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.frs.i.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.h) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                i.this.dAN.a((com.baidu.tbadk.data.h) customResponsedMessage.getData());
                i.this.dBi.auP().notifyDataSetChanged();
            }
        }
    };
    private final CustomMessageListener mMemListener = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_MEM) { // from class: com.baidu.tieba.frs.i.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            UserData userData;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && i.this.dAN != null && (userData = i.this.dAN.getUserData()) != null) {
                userData.setIsMem(num.intValue());
                if (num.intValue() != 0) {
                    i.this.dBr.f(num);
                }
            }
        }
    };
    private final com.baidu.tieba.frs.mc.i dCg = new com.baidu.tieba.frs.mc.i() { // from class: com.baidu.tieba.frs.i.13
        @Override // com.baidu.tieba.frs.mc.i
        public void a(int i, boolean z, int i2, boolean z2, ArrayList<com.baidu.adp.widget.ListView.i> arrayList, boolean z3) {
            if (i.this.dBu != null && i.this.dBq != null && i.this.dBq.ayu() && z && !z2 && !z3) {
                i.this.dBu.nJ(i2);
            }
        }
    };
    public final View.OnTouchListener bBl = new View.OnTouchListener() { // from class: com.baidu.tieba.frs.i.14
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (i.this.dBK != null) {
                i.this.dBK.onTouch(view, motionEvent);
            }
            if (i.this.dBw != null && i.this.dBw.avn() != null) {
                i.this.dBw.avn().onTouchEvent(motionEvent);
            }
            if (i.this.cgf != null) {
                i.this.cgf.f(view, motionEvent);
            }
            if (i.this.dBr != null) {
                i.this.dBr.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private final CustomMessageListener dCh = new CustomMessageListener(CmdConfigCustom.CMD_GOTOLIVE_HOST_UPGRADE) { // from class: com.baidu.tieba.frs.i.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(TbadkCoreApplication.getCurrentAccount() + "photolive_hostLevel", -1) != -1 && i.this.dAN.aYE() != null) {
                i.this.dAN.aYE().setCanAddPhotoLivePost(true);
            }
        }
    };
    private final CustomMessageListener dCi = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.frs.i.16
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.frs.i */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11455").ab("obj_locate", "frs"));
                    com.baidu.tbadk.core.util.av.CZ().c(i.this.getPageContext(), new String[]{str});
                }
            }
        }
    };
    public final View.OnClickListener dCj = new View.OnClickListener() { // from class: com.baidu.tieba.frs.i.20
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (i.this.dBi == null || view != i.this.dBi.auF() || i.this.getActivity() == null) {
                if (i.this.dAN != null && i.this.dAN.aYE() != null && i.this.dBi != null && view == i.this.dBi.auL()) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12402").ab(ImageViewerConfig.FORUM_ID, i.this.dAN.aYE().getId()).ab("uid", TbadkCoreApplication.getCurrentAccount()).ab(ImageViewerConfig.FORUM_NAME, i.this.dAN.aYE().getName()));
                    if (!StringUtils.isNull(i.this.dAN.aYE().getName())) {
                        i.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PostSearchActivityConfig(i.this.getPageContext().getPageActivity(), i.this.dAN.aYE().getName(), i.this.dAN.aYE().getId())));
                        return;
                    }
                    return;
                }
                if (view.getId() == d.g.game_activity_egg_layout && com.baidu.adp.lib.util.l.oZ()) {
                    TiebaStatic.log("c10853");
                    if (i.this.dBi.auM()) {
                        i.this.dBi.auN();
                    } else {
                        String activityUrl = i.this.dAN.aYE().getYuleData().At().getActivityUrl();
                        if (!StringUtils.isNull(activityUrl)) {
                            com.baidu.tbadk.browser.a.R(i.this.getPageContext().getPageActivity(), activityUrl);
                        }
                    }
                }
                if (view == i.this.dBi.auV() && i.this.dBq != null && i.this.dBq.hasMore()) {
                    i.this.dBi.auS();
                    i.this.VV();
                    return;
                }
                return;
            }
            i.this.getActivity().finish();
        }
    };
    private final RecyclerView.OnScrollListener Si = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.i.21
        private int dCq = 0;
        private int bXr = 0;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (i.this.dBA != null) {
                i.this.dBA.ayQ();
            }
            this.dCq = 0;
            this.bXr = 0;
            if (recyclerView != null && (recyclerView instanceof com.baidu.adp.widget.ListView.h)) {
                this.dCq = ((com.baidu.adp.widget.ListView.h) recyclerView).getFirstVisiblePosition();
                this.bXr = ((com.baidu.adp.widget.ListView.h) recyclerView).getLastVisiblePosition();
            }
            if (i.this.dBM != null) {
                i.this.dBM.b(recyclerView, this.dCq, this.bXr);
            }
            if (i.this.dAN != null && i.this.dBi != null && i.this.dBi.auP() != null) {
                i.this.dBi.bx(this.dCq, this.bXr);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i.this.dBr != null) {
                i.this.dBr.setScrollState(i);
            }
            if ((i == 2 || i == 1) && !i.this.dBn) {
                i.this.dBn = true;
                i.this.dBi.auR();
            }
            if (i.this.dBo == null && !i.this.aut()) {
                i.this.dBo = new com.baidu.tbadk.k.d();
                i.this.dBo.im(1000);
            }
            if (i == 0) {
                com.baidu.tieba.card.s.akF().eF(true);
                i.this.dBi.bw(this.dCq, this.bXr);
            }
            if (i.this.dBM != null) {
                i.this.dBM.onScrollStateChanged(recyclerView, i);
            }
            if (i.this.dBo != null) {
                i.this.dBo.Nv();
            }
            if (i == 0) {
                com.baidu.tieba.frs.e.g.a(i.this.dBi, i.this.dAN, i.this.getForumId(), false, null);
            }
        }
    };
    private final b dCk = new b() { // from class: com.baidu.tieba.frs.i.22
        @Override // com.baidu.tieba.frs.b
        public void a(int i, int i2, View view, View view2, bd bdVar) {
            if (i != i.this.dBi.auP().awl()) {
                if (i != i.this.dBi.auP().awm()) {
                    if (i != i.this.dBi.auP().awo()) {
                        if (i != i.this.dBi.auP().ave()) {
                            if (i == i.this.dBi.auP().awn() && i.this.dAN != null && i.this.dAN.getUserData() != null && i.this.dAN.getUserData().isBawu()) {
                                final String btU = i.this.dAN.btU();
                                if (!com.baidu.tbadk.core.util.am.isEmpty(btU) && i.this.dAN.aYE() != null) {
                                    com.baidu.tieba.c.a.a(i.this.getPageContext(), i.this.dAN.aYE().getId(), i.this.dAN.aYE().getName(), new a.InterfaceC0104a() { // from class: com.baidu.tieba.frs.i.22.1
                                        @Override // com.baidu.tieba.c.a.InterfaceC0104a
                                        public void ajZ() {
                                            com.baidu.tbadk.browser.a.Q(i.this.getPageContext().getPageActivity(), btU);
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10502").ab(ImageViewerConfig.FORUM_ID, i.this.dAN.aYE().getId()).ab("uid", i.this.dAN.getUserData().getUserId()));
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        i.this.dBa = bdVar;
                        com.baidu.tieba.frs.e.h.a(i.this, i.this.dBa);
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10179").ab(ImageViewerConfig.FORUM_ID, i.this.getForumId()));
                        return;
                    }
                    com.baidu.tieba.frs.e.h.z(i.this);
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak(i == i.this.dBi.auP().awo() ? "c10177" : "c10244").ab(ImageViewerConfig.FORUM_ID, i.this.getForumId()));
                } else if (com.baidu.tbadk.core.util.ax.be(i.this.getPageContext().getPageActivity())) {
                    TiebaStatic.log("my_service_ck");
                    if (i.this.dAN != null && i.this.dAN.aYE() != null) {
                        ForumData aYE = i.this.dAN.aYE();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(i.this.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(aYE.getId(), 0L), aYE.getName(), aYE.getImage_url(), 0)));
                    }
                }
            } else if (com.baidu.tbadk.core.util.ax.be(i.this.getActivity())) {
                TiebaStatic.log("forum_fortune_click");
                com.baidu.tieba.frs.e.h.a(i.this.getPageContext(), i.this.dAN);
            }
        }
    };
    private final NoNetworkView.a dzq = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.i.24
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bp(boolean z) {
            if (i.this.dBq.ayk() == 1 && z && !i.this.dBi.aur()) {
                if (i.this.dAN == null || v.E(i.this.dAN.getThreadList())) {
                    i.this.hideNetRefreshView(i.this.dBi.aem());
                    i.this.showLoadingView(i.this.dBi.aem(), true);
                    i.this.dBi.fF(false);
                    i.this.refresh();
                    return;
                }
                i.this.dBi.auH();
            }
        }
    };
    private final CustomMessageListener dCl = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.i.25
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001118) {
                com.baidu.tieba.frs.e.c.a(customResponsedMessage, i.this.dBi, i.this.dAN);
            }
        }
    };
    private com.baidu.adp.widget.ListView.o dCm = new a();
    private an dCn = new an() { // from class: com.baidu.tieba.frs.i.26
        @Override // com.baidu.tieba.frs.an
        public void a(int i, int i2, at atVar, ArrayList<com.baidu.adp.widget.ListView.i> arrayList) {
            com.baidu.adp.lib.g.e.nr().post(new Runnable() { // from class: com.baidu.tieba.frs.i.26.1
                @Override // java.lang.Runnable
                public void run() {
                    if (i.this.dBi != null && i.this.dBi.alF()) {
                        i.this.VV();
                    }
                }
            });
        }
    };
    private CustomMessageListener dCo = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.frs.i.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                    i.this.dBN = true;
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.frs.loadmore.a
    public /* bridge */ /* synthetic */ com.baidu.adp.base.e getPageContext() {
        return super.getPageContext();
    }

    public com.baidu.tieba.frs.entelechy.b.b atP() {
        return this.dBy;
    }

    public com.baidu.adp.widget.ListView.o atQ() {
        return this.dCm;
    }

    public com.baidu.tieba.frs.mc.d atR() {
        return this.dBB;
    }

    public com.baidu.tieba.frs.smartsort.b atS() {
        return this.dBu;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public FrsModelController atT() {
        return this.dBq;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public com.baidu.tieba.frs.mc.c atU() {
        return this.dBC;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public com.baidu.tieba.frs.f.f atV() {
        return this.dBr;
    }

    public com.baidu.tieba.frs.f.k atW() {
        return this.dBs;
    }

    public ap atX() {
        return this.dBw;
    }

    @Override // com.baidu.tieba.frs.mc.j
    public k atY() {
        return this.dBi;
    }

    @Override // com.baidu.tieba.frs.ao
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.ao, com.baidu.tieba.frs.loadmore.a
    public String getForumName() {
        return this.dBb;
    }

    public void setForumName(String str) {
        this.dBb = str;
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
        if (this.dBC == null) {
            return 1;
        }
        return this.dBC.getPn();
    }

    public int getPn() {
        if (this.dBC == null) {
            return 1;
        }
        return this.dBC.getPn();
    }

    public void setPn(int i) {
        if (this.dBC != null) {
            this.dBC.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.dBC != null) {
            this.dBC.setHasMore(i);
        }
    }

    public int atZ() {
        if (this.dBC == null) {
            return -1;
        }
        return this.dBC.atZ();
    }

    public boolean aua() {
        return this.dBg;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d.a aVar) {
        if (aVar == null) {
            String string = TbadkCoreApplication.getInst().getString(d.j.error_unkown_try_again);
            this.dBi.auC();
            showNetRefreshView(this.dBi.aem(), string, true);
        } else if (340001 == aVar.errorCode) {
            a(aVar, this.dAN.btz());
        } else {
            if (v.E(this.dAN.getThreadList())) {
                b(aVar);
            }
            if (aut()) {
                setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.s(TbadkCoreApplication.getInst(), d.e.ds280));
            } else {
                setNetRefreshViewEmotionDefMarginTop();
            }
        }
    }

    public void a(View view, String str, boolean z, List<RecmForumInfo> list) {
        this.dBi.auC();
        this.dBi.mU(8);
        if (this.dBL == null) {
            this.dBL = new com.baidu.tieba.frs.view.b(getPageContext(), getNetRefreshListener());
        }
        this.dBL.gF(str);
        this.dBL.bw(list);
        this.dBL.j(view, z);
    }

    private void a(d.a aVar, List<RecmForumInfo> list) {
        if (this.dBi != null) {
            this.dBi.auC();
            this.dBi.setTitle(this.dBb);
        }
        a(this.dBi.aem(), aVar.errorMsg, true, list);
    }

    private void b(d.a aVar) {
        this.dBi.auC();
        if (aVar.gUV) {
            showNetRefreshView(this.dBi.aem(), TbadkCoreApplication.getInst().getString(d.j.net_error_text, new Object[]{aVar.errorMsg, Integer.valueOf(aVar.errorCode)}), true);
        } else {
            showNetRefreshView(this.dBi.aem(), aVar.errorMsg, true);
        }
    }

    public void aub() {
        hideLoadingView(this.dBi.aem());
        if (!this.dBi.aur()) {
            this.dBi.fG(false);
        } else {
            this.dBi.fG(true);
        }
        if (this.dBi.auA() instanceof com.baidu.tieba.frs.tab.a) {
            ((com.baidu.tieba.frs.tab.a) this.dBi.auA()).ayM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auc() {
        if (atZ() == 0 && v.E(this.dAN.btI())) {
            if (v.E(this.dAN.getThreadList())) {
                this.dBi.alP();
            } else {
                this.dBi.auT();
            }
        } else if (v.D(this.dAN.getThreadList()) > 3) {
            this.dBi.auS();
        } else {
            this.dBi.auU();
        }
    }

    public void a(ErrorData errorData) {
        aub();
        this.dBi.auH();
        d.a ayh = this.dBq.ayh();
        boolean E = v.E(this.dAN.getThreadList());
        if (ayh != null && E) {
            if (E) {
                if (this.dBq.ayi() != 0) {
                    this.dBq.ayo();
                    this.dBi.auH();
                } else {
                    a(ayh);
                }
                this.dBi.x(this.dAN.buN(), false);
                return;
            } else if (ayh.gUV) {
                this.dBi.x(true, false);
                showToast(getPageContext().getResources().getString(d.j.net_error_text, ayh.errorMsg, Integer.valueOf(ayh.errorCode)));
                return;
            } else {
                return;
            }
        }
        a(ayh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aud() {
        if (this.dAN == null || this.dAN.aYE() != null) {
            this.dBi.auO();
        } else if (this.dAN.aYE().getYuleData() != null && this.dAN.aYE().getYuleData().As()) {
            TiebaStatic.log("c10852");
            this.dBi.a(this.dAN.aYE().getYuleData().At());
        } else {
            this.dBi.auO();
        }
    }

    private void v(boolean z, boolean z2) {
        if (this.dBq != null && this.dAN != null && this.dBi != null && z) {
            if (!this.dBq.ayu() && this.dBq.ayk() == 1) {
                if (!this.dBq.ays()) {
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        this.dAN.buF();
                        this.dAN.buy();
                    }
                    this.dAN.buD();
                    this.dAN.buE();
                }
                boolean z3 = false;
                if (this.dBi.auP().k(com.baidu.tieba.card.data.p.cXs)) {
                    z3 = this.dAN.buI();
                }
                if (!z3) {
                    this.dAN.buG();
                }
                if (TbadkCoreApplication.getInst().isRecAppExist()) {
                    this.dAN.a(this);
                }
                if (!this.dBi.auP().k(bd.aNc)) {
                    this.dAN.buv();
                }
                this.dAN.buJ();
            }
            if (!this.dBi.auP().k(bd.aNc)) {
                this.dAN.buC();
                this.dAN.buA();
            } else {
                this.dAN.buB();
                this.dAN.buz();
            }
            this.dAN.buw();
            this.dAN.but();
            if (this.dBi.auP().k(com.baidu.tieba.g.b.dVF)) {
                this.dAN.mv(z2);
            }
            if (TbadkCoreApplication.isLogin() && (!this.dBq.ayu() || this.dBq.isNetFirstLoad)) {
                this.dAN.buK();
            }
            this.dAN.buL();
        }
    }

    public boolean aue() {
        if (this.dBr != null && this.dBq != null) {
            this.dBr.a(this.dBq.ayg(), this.dAN);
        }
        boolean z = false;
        if (this.dAN != null) {
            z = this.dAN.buO();
        }
        aug();
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mR(int i) {
        aq aqVar = null;
        aue();
        aun();
        try {
            if (this.dAN != null) {
                this.dBi.a((ArrayList<com.baidu.adp.widget.ListView.i>) null, this.dAN);
                this.dBr.nO(1);
                this.dBi.auK();
                this.dBs.a(this.dAN, this.dBq.ayq());
                com.baidu.tieba.frs.tab.b nU = this.dBs.nU(this.dAN.btW());
                if (nU != null && !TextUtils.isEmpty(nU.url)) {
                    aqVar = new aq();
                    aqVar.dEh = nU.url;
                    aqVar.stType = nU.name;
                }
                this.dBq.a(this.dAN.btW(), 0, aqVar);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(boolean z, boolean z2) {
        try {
            if (this.dAN != null && this.dBs != null && this.dBq != null) {
                if (!this.dBi.auP().k(bd.aNc)) {
                    this.dAN.buv();
                }
                boolean E = v.E(this.dAN.buj());
                this.dBi.fD(E);
                if (!E) {
                    if (this.dBM == null) {
                        this.dBM = new com.baidu.tieba.frs.f.e(this, (NoPressedRelativeLayout) this.mRootView);
                    }
                    if (this.cgf == null) {
                        this.cgf = new com.baidu.tieba.frs.gametab.b(getActivity(), getBaseFragmentActivity().getUniqueId(), true);
                    }
                } else {
                    this.dBM = null;
                    this.cgf = null;
                }
                if (this.dAN.aYE() != null) {
                    this.dBb = this.dAN.aYE().getName();
                    this.forumId = this.dAN.aYE().getId();
                }
                if (this.dAN.buO()) {
                    this.dBs.a(this.dAN, this.dBq.ayq());
                }
                if (z) {
                    v(true, z);
                } else {
                    v(this.dBp, z);
                }
                aue();
                if (this.dBy != null) {
                    this.dBy.a(this.dBr, this.dAN);
                }
                if (this.dAN.xY() != null) {
                    setHasMore(this.dAN.xY().xU());
                }
                ArrayList<com.baidu.adp.widget.ListView.i> a2 = this.dBC.a(z2, true, this.dAN.getThreadList(), null, z);
                if (a2 != null) {
                    this.dAN.at(a2);
                }
                if (this.dBq.ayk() == 1) {
                    auk();
                    if (!z && this.dBq.getPn() == 1) {
                        auf();
                    }
                }
                this.dAQ = this.dAN.aym();
                if (this.dBe != null) {
                    this.dBd = true;
                    this.dBe.vH(this.dAQ);
                    com.baidu.tieba.frs.e.a.a(this, this.dAN.aYE(), this.dAN.getThreadList(), this.dBd, getPn());
                }
                if (this.dBA != null) {
                    this.dBA.bS(this.dBs.azl());
                }
                aub();
                this.dBi.auD();
                this.dBi.x(true, false);
                if (this.dAN.aYE() != null) {
                    this.dBi.ls(this.dAN.aYE().getWarningMsg());
                }
                if (this.dAN != null && this.dAN.bum() != null && com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("frs_video_activity_guide", 0L) == 0) {
                    com.baidu.adp.lib.g.e.nr().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.i.8
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.dBi.auZ();
                        }
                    }, 1000L);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FRS_SHOW_AR_ENTRY, this));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void auf() {
        if (this.dBF == null) {
            this.dBF = new com.baidu.tieba.frs.live.a(this, com.baidu.adp.lib.g.b.h(this.forumId, 0));
        }
        this.dBF.axT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.i iVar) {
        try {
            if (!this.dBm && iVar != null && this.dAN != null) {
                this.dAN.e(iVar);
                w(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void aug() {
        if (this.dBq != null) {
            lr(this.dBq.ayg());
        } else {
            lr("normal_page");
        }
    }

    private void lr(String str) {
        fA("frs_page".equals(str));
        if (this.dBy != null) {
            this.dBy.a(this.dBr, this.dBi, this.dAN);
        }
    }

    public void fA(boolean z) {
        if (this.dBD != null) {
            this.dBD.a(this.dBi, z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(d.h.frs_activity, viewGroup, false);
            this.dAW = new com.baidu.tieba.frs.entelechy.b();
            this.dBy = this.dAW.avR();
            this.dBr = new com.baidu.tieba.frs.f.f(this, this.dAW, (FrsHeaderViewContainer) this.mRootView.findViewById(d.g.header_view_container));
            this.dBs = new com.baidu.tieba.frs.f.i(this, this.mRootView);
            this.dBs.a(this.dBW);
            Intent intent = getActivity().getIntent();
            if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                this.dAY = true;
            }
            this.dBi = new k(this, this.dCj, this.dAW, this.dAY);
            this.dBi.setHeaderViewHeight(this.dBJ);
        } else {
            if (this.mRootView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            this.dBs.resetData();
            this.dBi.auY();
        }
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Intent intent = getActivity().getIntent();
        this.dmx = System.currentTimeMillis();
        if (intent != null) {
            this.dBf = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.dmx = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            L(intent);
        }
        this.beginTime = System.currentTimeMillis();
        this.byo = this.beginTime - this.dmx;
        this.dBe = new com.baidu.tieba.tbadkCore.data.e("frs", com.baidu.tieba.tbadkCore.data.e.gXF);
        this.dBq = new FrsModelController(this, this.dCe);
        this.dBq.a(this.dBU);
        this.dBq.init();
        if (intent != null) {
            this.dBq.k(intent.getExtras());
        } else if (bundle != null) {
            this.dBq.k(bundle);
        } else {
            this.dBq.k(null);
        }
        if (intent != null) {
            this.dBr.n(intent.getExtras());
        } else if (bundle != null) {
            this.dBr.n(bundle);
        } else {
            this.dBr.n((Bundle) null);
        }
        this.dBh = getVoiceManager();
        this.dBG = new j(getPageContext(), this);
        initUI();
        initData(bundle);
        if (this.mFrom != null && this.mFrom.equals("from_tieba_kuang")) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12264").s("obj_type", 1).ab(ImageViewerConfig.FORUM_NAME, this.dBq.getForumName()));
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
        if (!aut()) {
            this.dBw = new ap(getActivity(), this.dBi, this.dBr);
            this.dBw.fN(true);
        }
        this.dBh = getVoiceManager();
        if (this.dBh != null) {
            this.dBh.onCreate(getPageContext());
        }
        new com.baidu.tieba.frs.mc.g();
        this.dBC = new com.baidu.tieba.frs.mc.c(this, this.dCg);
        this.dBu = new com.baidu.tieba.frs.smartsort.b(this);
        this.dBD = new com.baidu.tieba.frs.f.h(this);
        this.createTime = System.currentTimeMillis() - this.beginTime;
        this.dBA = new com.baidu.tieba.frs.f.a(getPageContext(), this.dBq.ayr());
        this.dBv = new com.baidu.tieba.frs.mc.b(this);
        this.dBB = new com.baidu.tieba.frs.mc.d(this);
        this.dBt = new com.baidu.tieba.frs.mc.f(this);
        this.dBE = new com.baidu.tieba.frs.mc.a(this);
        this.dBH = new com.baidu.tieba.frs.f.c(this);
        this.dBI = new com.baidu.tieba.frs.mc.e(this, getUniqueId());
        this.dBP = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "frs");
        this.dBQ = new com.baidu.tieba.ala.a(getPageContext());
        registerListener(this.cdv);
        registerListener(this.mMemListener);
        registerListener(this.dCb);
        registerListener(this.dCh);
        registerListener(this.dCa);
        registerListener(this.dCf);
        registerListener(this.dBX);
        registerListener(this.dBY);
        registerListener(this.dBZ);
        registerListener(this.dBR);
        registerListener(this.dBS);
        registerListener(this.dCo);
        registerListener(this.dCd);
        registerListener(this.dBT);
        this.dBi.fF(false);
        if (!aut()) {
            showLoadingView(this.dBi.aem(), true);
            this.dBq.B(3, true);
        }
        super.onActivityCreated(bundle);
    }

    @Override // com.baidu.tieba.frs.aj
    public void Wx() {
        if (isAdded() && this.cho && !isLoadingViewAttached()) {
            showLoadingView(this.dBi.aem(), true);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void Wy() {
        if (isAdded() && this.cho && isLoadingViewAttached()) {
            hideLoadingView(this.dBi.aem());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (aut()) {
            showLoadingView(this.dBi.aem(), true);
            this.dBi.mV(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.dBq.B(3, true);
            Ec().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void setHeaderViewHeight(int i) {
        this.dBJ = i;
        if (this.dBi != null) {
            this.dBi.setHeaderViewHeight(this.dBJ);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.s sVar) {
        if (sVar != null) {
            this.bBk = sVar.OE();
            this.dBK = sVar.OF();
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void showFloatingView() {
        if (this.bBk != null) {
            this.bBk.cB(true);
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
            this.dBb = data.getQueryParameter("name");
            this.mFrom = data.getQueryParameter("from");
            if (!StringUtils.isNull(this.dBb)) {
                intent.putExtra("name", this.dBb);
            }
            if (!StringUtils.isNull(this.mFrom)) {
                intent.putExtra("from", this.mFrom);
            }
            TiebaStatic.log("c10105");
        }
        if (StringUtils.isNull(this.dBb)) {
            this.dBb = com.baidu.tieba.frs.e.h.N(intent);
            if (!StringUtils.isNull(this.dBb)) {
                intent.putExtra("name", this.dBb);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.dBh = getVoiceManager();
        if (this.dBh != null) {
            this.dBh.onStart(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        Intent intent;
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.dCl);
        if (bundle != null) {
            this.dBb = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
            this.dBb = intent.getStringExtra("name");
            this.mFrom = intent.getStringExtra("from");
            this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
        }
        if (TextUtils.isEmpty(this.mFrom) || FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
        }
        if (this.mIsLogin) {
            registerListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL, this.dCl);
        }
        this.dBr.n(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dCo);
        if (this.dBh != null) {
            this.dBh.onDestory(getPageContext());
        }
        this.dBh = null;
        com.baidu.tieba.card.s.akF().eF(false);
        if (this.dAN != null && this.dAN.aYE() != null) {
            ae.avk().bC(com.baidu.adp.lib.g.b.c(this.dAN.aYE().getId(), 0L));
        }
        if (this.dBF != null) {
            this.dBF.onDestory();
        }
        if (this.dBi != null) {
            com.baidu.tieba.frs.e.g.a(this.dBi, this.dAN, getForumId(), false, null);
            this.dBi.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.dBo != null) {
                this.dBo.onDestroy();
            }
            this.dBi.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.dBq.onActivityDestroy();
        this.dBr.onActivityDestroy();
        if (this.dBq != null) {
            this.dBq.XW();
        }
        if (this.dBw != null) {
            this.dBw.OD();
        }
        if (this.dBz != null) {
            this.dBz.destory();
        }
        if (this.dBA != null) {
            this.dBA.destory();
        }
        if (this.dBu != null) {
            this.dBu.onDestroy();
        }
        if (this.dBM != null) {
            this.dBM.onDestory();
        }
        if (this.dBE != null) {
            this.dBE.onDestroy();
        }
        if (this.dBP != null) {
            this.dBP.onDestroy();
        }
        if (this.dBQ != null) {
            this.dBQ.onDestroy();
        }
        com.baidu.tieba.recapp.e.a.bnw().bny();
        com.baidu.tieba.frs.e.i.ayN();
        if (this.dBs != null) {
            this.dBs.a((i.b) null);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.dBb);
        bundle.putString("from", this.mFrom);
        this.dBq.onSaveInstanceState(bundle);
        if (this.dBh != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            this.dBh.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.dBE != null) {
            this.dBE.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dBi != null) {
            this.dBi.auH();
            this.dBi.onResume();
        }
        this.dBt.gd(true);
        this.dBp = true;
        if (dAZ) {
            dAZ = false;
            this.dBi.startPullRefresh();
            return;
        }
        if (this.dBh != null) {
            this.dBh.onResume(getPageContext());
        }
        this.dBi.fH(false);
        registerListener(this.dCi);
        if (this.dBN) {
            refresh(6);
            this.dBN = false;
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

    public boolean auh() {
        Intent intent;
        if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
            return false;
        }
        return intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
    }

    public void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.dBb = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.dBc = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.dBc) {
                aui();
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
    public void aui() {
        this.dBi.startPullRefresh();
    }

    public void closeActivity() {
        com.baidu.tieba.frs.e.h.a(getPageContext(), getActivity() == null ? null : getActivity().getIntent(), this.mFrom);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.dBi.setTitle(this.dBb);
        } else {
            this.dBi.setTitle("");
            this.mFlag = 1;
        }
        this.dBi.setOnAdapterItemClickListener(this.dCm);
        this.dBi.addOnScrollListener(this.Si);
        this.dBi.h(this.dzq);
        this.dBi.auP().a(this.dCk);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dBi.onChangeSkinType(i);
        this.dBr.nN(i);
        this.dBs.onChangeSkinType(i);
        if (this.dBL != null) {
            this.dBL.onChangeSkinType();
        }
    }

    public void mS(int i) {
        if (!this.mIsLogin) {
            if (this.dAN != null && this.dAN.xG() != null) {
                this.dAN.xG().setIfpost(1);
            }
            if (i == 0) {
                com.baidu.tbadk.core.util.ax.bd(getActivity());
            }
        } else if (this.dAN != null) {
            if (i == 0) {
                com.baidu.tieba.frs.e.i.b(this, 0);
            } else {
                this.dBi.auJ();
            }
        }
    }

    public void refresh() {
        refresh(3);
    }

    public void refresh(int i) {
        this.dBm = false;
        aun();
        if (this.dBi.auz() != null) {
            this.dBi.auz().aCB();
        }
        this.dBq.B(i, true);
    }

    private void auj() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.g.h.ns().e(new Runnable() { // from class: com.baidu.tieba.frs.i.19
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.tbadkCore.util.a.sB(i.this.dBb);
                    }
                });
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auk() {
        aun();
        try {
            if (this.dAN != null) {
                this.dBi.WN();
                this.dBi.fC(this.dBq.ayl());
                if (com.baidu.tieba.frs.f.f.i(this.dAN) && !com.baidu.tieba.frs.f.f.h(this.dAN)) {
                    this.dBi.auW();
                }
                if (this.dAN.aYE() != null) {
                    this.dBb = this.dAN.aYE().getName();
                    this.forumId = this.dAN.aYE().getId();
                }
                if (this.dAN.xY() != null) {
                    setHasMore(this.dAN.xY().xU());
                }
                this.dBi.setTitle(this.dBb);
                this.dBi.setForumName(this.dBb);
                TbadkCoreApplication.getInst().setDefaultBubble(this.dAN.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(this.dAN.getUserData().getBimg_end_time());
                auj();
                aul();
                ArrayList<com.baidu.adp.widget.ListView.i> threadList = this.dAN.getThreadList();
                if (threadList != null) {
                    this.dBi.a(threadList, this.dAN);
                    com.baidu.tieba.frs.e.c.l(this.dBi);
                    this.dBr.nO(getPageNum());
                    this.dBr.f(this.dAN);
                    this.dBs.a(this.dAN, this.dBq.ayq());
                    this.dBi.auK();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void aul() {
        if (this.dAN != null) {
            if (this.dAN.aYT() == 1) {
                this.dBi.auP().setFromCDN(true);
            } else {
                this.dBi.auP().setFromCDN(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.dBt.gd(false);
        this.dBp = false;
        this.dBi.onPause();
        if (this.dBh != null) {
            this.dBh.onPause(getPageContext());
        }
        this.dBi.fH(true);
        if (this.dBA != null) {
            this.dBA.ayQ();
        }
        MessageManager.getInstance().unRegisterListener(this.dCi);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.s.akF().eF(false);
        if (this.dAN != null && this.dAN.aYE() != null && getPageContext() != null && getPageContext().getPageActivity() != null) {
            com.baidu.tbadk.distribute.a.Ke().a(getPageContext().getPageActivity(), "frs", this.dAN.aYE().getId(), 0L);
        }
        if (this.dBh != null) {
            this.dBh.onStop(getPageContext());
        }
        if (Ec() != null) {
            Ec().getRecycledViewPool().clear();
        }
        this.dBr.onActivityStop();
        t.OH();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && this.dBr != null) {
            this.dBr.gf(isPrimary());
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || this.dBi == null) {
            return false;
        }
        return this.dBi.auG();
    }

    @Override // com.baidu.tieba.recapp.o
    public TbPageContext<?> aka() {
        return getPageContext();
    }

    @Override // com.baidu.tieba.recapp.o
    public void a(AdvertAppInfo advertAppInfo, String str) {
        com.baidu.tbadk.distribute.a.Ke().a(advertAppInfo, this.forumId, 0L, "FRS", str, getPn());
    }

    @Override // com.baidu.tieba.recapp.o
    public void aum() {
        atT().aum();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dBh == null) {
            this.dBh = VoiceManager.instance();
        }
        return this.dBh;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public com.baidu.adp.widget.ListView.h Ec() {
        if (this.dBi == null) {
            return null;
        }
        return this.dBi.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void aun() {
        if (this.dBh != null) {
            this.dBh.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> Ed() {
        if (this.bcZ == null) {
            this.bcZ = UserIconBox.v(getPageContext().getPageActivity(), 8);
        }
        return this.bcZ;
    }

    public void auo() {
        if (getFragmentActivity() != null && getFragmentActivity().getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.a(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.l onGetPreLoadListView() {
        return Ec().getPreLoadHandle();
    }

    @Override // com.baidu.tieba.frs.am
    public NavigationBar aup() {
        if (this.dBi == null) {
            return null;
        }
        return this.dBi.aup();
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
                if (bdUniqueId == r.dDv) {
                    if (i.this.dBi != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11752").ab(ImageViewerConfig.FORUM_ID, i.this.forumId).ab("obj_locate", "1"));
                        i.this.dBi.startPullRefresh();
                    }
                } else if (iVar != null && (iVar instanceof bd)) {
                    bd bdVar = (bd) iVar;
                    if (bdVar.zD() == null || bdVar.zD().getGroup_id() == 0 || com.baidu.tbadk.core.util.ax.be(i.this.getActivity())) {
                        if ((bdVar.zw() != 1 && bdVar.zw() != 2) || com.baidu.tbadk.core.util.ax.be(i.this.getActivity())) {
                            if (bdVar.zg() != null) {
                                if (com.baidu.tbadk.core.util.ax.be(i.this.getActivity())) {
                                    String postUrl = bdVar.zg().getPostUrl();
                                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.l.oZ()) {
                                        com.baidu.tbadk.browser.a.R(i.this.getActivity(), postUrl);
                                    }
                                }
                            } else if (bdVar.zM() != null) {
                                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                                    com.baidu.tbadk.core.util.ax.bd(i.this.getPageContext().getPageActivity());
                                    return;
                                }
                                com.baidu.tbadk.core.data.m zM = bdVar.zM();
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(i.this.getPageContext().getPageActivity(), zM.getCartoonId(), zM.getChapterId(), 2)));
                            } else if (bdVar.getThreadType() == 47 && bdVar.yN() == 1 && !com.baidu.tbadk.core.util.am.isEmpty(bdVar.za())) {
                                com.baidu.tbadk.browser.a.Q(i.this.getPageContext().getPageActivity(), bdVar.za());
                            } else {
                                com.baidu.tieba.tbadkCore.util.e readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                                if (readThreadHistory != null && !readThreadHistory.sH(bdVar.getId())) {
                                    readThreadHistory.sG(bdVar.getId());
                                }
                                final String za = bdVar.za();
                                if (za == null || za.equals("")) {
                                    z = false;
                                } else {
                                    new Thread(new Runnable() { // from class: com.baidu.tieba.frs.i.a.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(za);
                                            xVar.Cf().Db().mIsNeedAddCommenParam = false;
                                            xVar.Cf().Db().mIsUseCurrentBDUSS = false;
                                            xVar.BI();
                                        }
                                    }).start();
                                    z = true;
                                }
                                String tid = bdVar.getTid();
                                if (tid == null) {
                                    tid = "";
                                }
                                if (bdVar.yN() == 2 && !tid.startsWith("pb:")) {
                                    com.baidu.tbadk.core.util.av.CZ().c(i.this.getPageContext(), new String[]{tid, "", null});
                                } else if (bdVar.getThreadType() == 33 || (bdVar instanceof as)) {
                                    String str = bdVar.getThreadType() == 33 ? "c10245" : "c10180";
                                    if (i.this.dBq.ayk() == 5) {
                                        str = "c10387";
                                    }
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak(str).ab(ImageViewerConfig.FORUM_ID, i.this.forumId));
                                    com.baidu.tieba.frs.e.h.b(i.this, bdVar);
                                    if (i.this.dAN != null && i.this.dAN.aYE() != null) {
                                        com.baidu.tieba.frs.d.a aVar = new com.baidu.tieba.frs.d.a();
                                        aVar.dQx = i.this.dAN.gVC == 1;
                                        aVar.dQz = i.this.dAN.aYE().getId();
                                        aVar.dQy = i.this.atT().ayq();
                                        com.baidu.tieba.frs.d.b.ayK().a(aVar, bdVar, 1);
                                    }
                                } else {
                                    if (tid.startsWith("pb:")) {
                                        bdVar.setId(tid.substring(3));
                                    }
                                    if (bdUniqueId.getId() == bd.aOm.getId()) {
                                        com.baidu.tieba.frs.e.g.a(bdVar.yA());
                                    }
                                    com.baidu.tieba.frs.e.h.a(i.this, bdVar, i, z);
                                    com.baidu.tieba.frs.e.g.a(i.this, i.this.dAN, bdVar);
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
            hideNetRefreshView(this.dBi.aem());
            showLoadingView(this.dBi.aem(), true);
            this.dBi.fF(false);
            this.dBq.B(3, true);
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.a
    public com.baidu.tieba.tbadkCore.l auq() {
        return this.dAN;
    }

    public boolean aur() {
        return this.dBi.aur();
    }

    public void aU(Object obj) {
        if (this.dBv != null && this.dBv.dPm != null) {
            this.dBv.dPm.ak(obj);
        }
    }

    public void aV(Object obj) {
        if (this.dBv != null && this.dBv.dPn != null) {
            this.dBv.dPn.ak(obj);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.l.oZ()) {
            this.dBi.alP();
        } else if (this.dBq.ayk() == 1) {
            Wj();
            VV();
        } else if (this.dBq.hasMore()) {
            VV();
        }
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void lf(String str) {
        Wj();
        showToast(str);
    }

    @Override // com.baidu.tieba.frs.loadmore.FrsLoadMoreModel.a
    public void J(ArrayList<com.baidu.adp.widget.ListView.i> arrayList) {
        Wj();
        if (!v.E(arrayList)) {
            if (!this.dBq.ayu() && TbadkCoreApplication.getInst().isRecAppExist() && this.dBq.ayk() == 1) {
                this.dAN.a(this, arrayList);
            }
            ArrayList<com.baidu.adp.widget.ListView.i> a2 = this.dBC.a(false, false, arrayList, this.dBe);
            if (a2 != null) {
                this.dAN.at(a2);
                this.dBi.a(a2, this.dAN);
            }
            if (this.dBq != null) {
                com.baidu.tieba.frs.d.b.a(this.dAN, this.dBq.ayq(), 2);
            }
        }
    }

    private void Wj() {
        if (atZ() == 1 || this.dBC.bt(this.dAN.btI())) {
            if (v.D(this.dAN.getThreadList()) > 3) {
                this.dBi.auS();
            } else {
                this.dBi.auU();
            }
        } else if (v.E(this.dAN.getThreadList())) {
            this.dBi.alP();
        } else {
            this.dBi.auT();
        }
    }

    @Override // com.baidu.tieba.frs.mc.j
    public void VV() {
        if (this.dBC != null) {
            this.dBC.a(this.dBb, this.forumId, this.dAN);
        }
    }

    public void aus() {
        if (!com.baidu.tbadk.core.util.ab.f(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.ai.c(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return aut() ? "a034" : "a006";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (!aut()) {
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

    public void fB(boolean z) {
        if (this.dBw != null) {
            this.dBw.fN(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.dBx.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a jg(int i) {
        return this.dBx.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        this.dBG.b(bVar);
    }

    public boolean aut() {
        return this.dAY;
    }

    @Override // com.baidu.tieba.frs.aj
    public void Ww() {
        if (this.dBi != null) {
            showFloatingView();
            this.dBi.getListView().scrollToPosition(0);
            this.dBi.startPullRefresh();
        }
    }

    public ForumWriteData auu() {
        if (this.dAN == null || this.dAN.aYE() == null) {
            return null;
        }
        ForumData aYE = this.dAN.aYE();
        ForumWriteData forumWriteData = new ForumWriteData(aYE.getId(), aYE.getName(), aYE.getPrefixData(), this.dAN.xG());
        forumWriteData.setForumLevel(aYE.getUser_level());
        forumWriteData.setAvatar(this.dAN.aYE().getImage_url());
        UserData userData = this.dAN.getUserData();
        if (userData != null) {
            forumWriteData.setPrivateThread(userData.getPrivateThread());
            return forumWriteData;
        }
        return forumWriteData;
    }

    @Override // com.baidu.tieba.frs.aj
    public void DR() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.frs.aj
    public void setVideoThreadId(String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z) {
        super.showLoadingView(view, z);
        this.dBi.mU(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        super.hideLoadingView(view);
        this.dBi.mU(0);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        super.showNetRefreshView(view, str, z);
        this.dBi.mU(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshViewNoClick(View view, String str, boolean z) {
        super.showNetRefreshViewNoClick(view, str, z);
        this.dBi.mU(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        super.hideNetRefreshView(view);
        this.dBi.mU(0);
    }

    public void auv() {
        i.c azm;
        if (this.dBs != null && (azm = this.dBs.azm()) != null && azm.fragment != null && (azm.fragment instanceof al)) {
            ((al) azm.fragment).atK();
        }
    }
}
